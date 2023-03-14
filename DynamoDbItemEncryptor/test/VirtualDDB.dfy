include "../src/VirtualDDB.dfy"

module VirtualDDBFieldsTests {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths
  import opened VirtualFields
  import opened VirtualDDBFields
  import DDB = ComAmazonawsDynamodbTypes

  method CheckValueString(expr : string, data : DDB.AttributeMap, expected : string) {
    var val := VirtualFields.GetVirtualField("foo", expr);
    var val2 :- expect val;
    if !ValidVirtualField(val2) {
      print "Invalid Value : ", val2, "\n";
    }
    expect ValidVirtualField(val2);

    var str := val2.makeString(t => TermToString(t, data));
    var actual :- expect str;

    if actual != expected {
      print "Expected ", expected, " actual ", actual, "\n";
    }
    expect actual == expected;
  }

  method {:test} TestMakeString() {
    var data : DDB.AttributeMap := map["attr" := DS("12345"), "other" := DS("abcde"), "third" := DS("a.b.c.d.e")];
    CheckValueString("attr + other", data, "12345abcde");
    CheckValueString("attr | Prefix 3 + other | Suffix 3", data, "123cde");
    CheckValueString("attr + third | Parts . 3 4", data, "12345c.d");
    CheckValueString("attr + Literal _ + third | Parts . 3 4", data, "12345_c.d");
    CheckValueString("attr + Literal _ + third | Parts . 3", data, "12345_c");
  }
  method {:test} TestMakeString2() {
    var data : DDB.AttributeMap := map[
      "bool" := DDB.AttributeValue.BOOL(true),
      "null" := DDB.AttributeValue.NULL(true),
      "number" := DDB.AttributeValue.N("123"),
      "binary" := DDB.AttributeValue.B([1,2,3]),
      "list" := DDB.AttributeValue.L([
        DS("abc"),
        DS("def"),
        DS("ghi")
      ]),
      "map" := DDB.AttributeValue.M(map[
        "key1" := DS("jkl"),
        "key2" := DS("mno"),
        "key3" := DS("pqr")
      ])
    ];
    CheckValueString("list[1] + map.key2", data, "defmno");
    CheckValueString("bool + null + number + binary", data, "truenull123AQID");
  }
}
