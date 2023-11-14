// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "BeaconTestFixtures.dfy"

module TestBaseBeacon {
  import T = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened BaseBeacon
  import opened CompoundBeacon
  import opened Wrappers
  import opened TermLoc
  import opened BeaconTestFixtures
  import opened DynamoDbEncryptionUtil
  import opened DynamoDBFilterExpr
  import C = SearchConfigToInfo
  import I = SearchableEncryptionInfo
  import SI = SearchableEncryptionInfo
  import DDB = ComAmazonawsDynamodbTypes

  method {:test} TestBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var bb := BeaconBase(client := primitives, name := "foo", beaconName := "aws_dbe_b_foo");
    var b := StandardBeacon(bb, 8, TermLocMap("foo"));
    var bytes :- expect bb.getHmac([1,2,3], key := [1,2]);
    expect bytes == [0x27, 0x93, 0x93, 0x8b, 0x26, 0xe9, 0x52, 0x7e];
    var str :- expect b.hash([1,2,3], key := [1,2]);
    expect str == "7e";
    bytes :- expect bb.getHmac([], key := [1,2]);
    expect bytes[7] == 0x80;
    str :- expect b.hash([], key := [1,2]);
    expect str == "80";
    bytes :- expect bb.getHmac(UTF8.EncodeAscii("123"), key := [1,2]);
    expect bytes[7] == 0x61;
  }

  method {:test} TestBadPrefix() {
    var store := GetKeyStore();
    var version := T.BeaconVersion (
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [NameB, TitleB, TooBadB],
      compoundBeacons := Some([BadPrefix]),
      virtualFields := None
    );
    var src := GetLiteralSource([1,2,3,4,5], version);
    var res := C.ConvertVersionWithSource(FullTableConfig, version, src);

    expect res.Failure?;
    expect_equal(res.error, E("Compound beacon BadPrefix defines part Title with prefix T_ which is incompatible with part TooBad which has a prefix of T."));
  }


  method {:test} TestContainsSplit()
  {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    var badItem := SimpleItem["Name" := DDB.AttributeValue.S("A.B")];
    var badAttrs := bv.GenerateEncryptedBeacons(badItem, DontUseKeyId);
    expect badAttrs.Failure?;
    expect_equal(badAttrs.error, E("Part Name for beacon Mixed has value 'A.B' which contains the split character .'."));
  }


  method {:test} TestOneBeaconValue()
  {
    var x := GetBeaconValue("std2", [1,2,3,4,5], "1.23", 24);
    expect x == std2_beacon;
    x := GetBeaconValue("Name", [1,2,3,4,5], "MyName", 32);
    expect x == Name_beacon;
    x := GetBeaconValue("Title", [1,2,3,4,5], "MyTitle", 32);
    expect x == Title_beacon;
    x := GetBeaconValue("std4", [1,2,3,4,5], "abc", 24);
    expect x == std4_beacon;
    x := GetBeaconValue("std6", [1,2,3,4,5], "666", 26);
    expect x == std6_beacon;
    x := GetBeaconValue("NameTitleField", [1,2,3,4,5], "MyName__mytitle", 28);
    expect x == NameTitle_beacon;
    x := GetBeaconValue("Name", [1,2,3,4,5], "", 32);
    expect x == EmptyName_beacon;
    x := GetBeaconValue("Title", [1,2,3,4,5], "", 32);
    expect x == EmptyTitle_beacon;
  }

  method {:test} TestNumbersNormalize()
  {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    assert "std2" in SimpleItem;
    assert SimpleItem["std2"] == Std2String;
    assert Std2String == DDB.AttributeValue.N("1.23");
    expect "aws_dbe_b_std2" in goodAttrs;
    expect goodAttrs["aws_dbe_b_std2"] == DDB.AttributeValue.S(std2_beacon);
    var newItem := SimpleItem["std2" := DDB.AttributeValue.N("000001.23000000")];
    var newAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect "aws_dbe_b_std2" in newAttrs;
    expect goodAttrs["aws_dbe_b_std2"] == newAttrs["aws_dbe_b_std2"];
  }

  method {:test} TestBeaconValues()
  {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var attrs :- expect bv.GenerateSignedBeacons(SimpleItem);
    expect attrs == map["JustSigned" := DDB.AttributeValue.S("Y_1984.M_May")];
    attrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect attrs == map[
                      "aws_dbe_b_Mixed" := DDB.AttributeValue.S("N_" + Name_beacon + ".Y_1984"),
                      "aws_dbe_b_Name" := DDB.AttributeValue.S(Name_beacon),
                      //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
                      //= type=test
                      //# * The value returned MUST be these part values, joined with the `split character`.

                      //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
                      //= type=test
                      //# * For that constructor, hash MUST join the [part value](#part-value) for each part
                      //# on the `split character`,
                      //# excluding parts that are not required and with a source field that is not available.
                      "aws_dbe_b_NameTitle" := DDB.AttributeValue.S("N_" + Name_beacon + ".T_" + Title_beacon),
                      "aws_dbe_b_NameTitleField" := DDB.AttributeValue.S("4c577d7"),
                      "aws_dbe_b_std2" := DDB.AttributeValue.S(std2_beacon),
                      "aws_dbe_b_Title" := DDB.AttributeValue.S(Title_beacon),
                      "aws_dbe_b_std6" := DDB.AttributeValue.S(std6_beacon),
                      "aws_dbe_b_std4" := DDB.AttributeValue.S(std4_beacon),
                      "aws_dbe_b_YearName" := DDB.AttributeValue.S("Y_1984.N_" + Name_beacon)
                    ];
  }

  method GetBeaconValue(name : string, key : Bytes, value : string, length : BeaconLength) returns (output : string)
  {
    var info :- expect UTF8.Encode("AWS_DBE_SCAN_BEACON" + name);
    var client :- expect Primitives.AtomicPrimitives();

    var key :- expect client.Hkdf(Prim.HkdfInput(
                                    digestAlgorithm := Prim.SHA_512,
                                    salt := None,
                                    ikm := key,
                                    info := info,
                                    expectedLength := 64
                                  ));

    var data :- expect UTF8.Encode(value);
    var input := Prim.HMacInput (
      digestAlgorithm := Prim.SHA_384,
      key := key,
      message := data
    );
    var hmac48 :- expect client.HMac(input);
    var hmac8 := hmac48[..8];
    return BytesToHex(hmac8, length);
  }


  method {:test} TestCompoundQueries() {
    var context := ExprContext (
      None,
      Some("Mixed = :mixed"),
      None,
      None
    );
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var beaconVersion :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);

    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("N_MyName.Y_1984")]));
    var newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("N_MyName")]));
    newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("Y_1984")]));
    newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("T_foo")]));
    newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("M_bar")]));
    newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("T_foo.M_bar")]));
    newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);

    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("N_MyName.N_MyName")]));
    var badContext := Beaconize(beaconVersion, context, DontUseKeyId);
    expect badContext.Failure?;
    expect badContext.error == E("Compound Beacon value 'N_MyName.N_MyName' cannot be constructed from any available constructor for Mixed value parsed as N_N_ available constructors are N_Y_, T_[M_].");

    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("Y_1984.N_MyName")]));
    badContext := Beaconize(beaconVersion, context, DontUseKeyId);
    expect badContext.Failure?;
    expect badContext.error == E("Compound Beacon value 'Y_1984.N_MyName' cannot be constructed from any available constructor for Mixed value parsed as Y_N_ available constructors are N_Y_, T_[M_].");

    context := context.(values := Some(map[":mixed" := DDB.AttributeValue.S("M_bar.T_foo")]));
    badContext := Beaconize(beaconVersion, context, DontUseKeyId);
    expect badContext.Failure?;
    expect badContext.error == E("Compound Beacon value 'M_bar.T_foo' cannot be constructed from any available constructor for Mixed value parsed as M_T_ available constructors are N_Y_, T_[M_].");
  }

  method {:test} TestQueryBeacons() {
    var context := ExprContext (
      None,
      Some("std2 = :std2 AND std4 = :std4 AND :std6 = std6 AND Name = :Name AND Mixed = :Mixed"
           + " AND :NameTitle = NameTitle AND NameTitle = :NameTitleN AND NameTitle = :NameTitleT AND NameTitle = :NameTitleTN"
           + " AND NameTitleField = :NameTitleField And Title = :Title AND YearName = :YearName"),
      Some(map[
             ":std2" := Std2String,
             ":std4" := Std4String,
             ":std6" := Std6String,
             ":Name" := NameString,
             ":Title" := TitleString,
             ":Mixed" := DDB.AttributeValue.S("N_MyName.Y_1984"),
             ":NameTitle" := DDB.AttributeValue.S("N_MyName.T_MyTitle"),
             ":NameTitleN" := DDB.AttributeValue.S("N_MyName"),
             ":NameTitleT" := DDB.AttributeValue.S("T_MyTitle"),
             ":NameTitleTN" := DDB.AttributeValue.S("N_MyName.T_MyTitle"),
             ":NameTitleField" := DDB.AttributeValue.S("MyName__mytitle"),
             ":YearName" := DDB.AttributeValue.S("Y_1984.N_MyName")
           ]),
      None
    );
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var beaconVersion :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    expect newContext.values == Some(map[
                                       ":Mixed" := DDB.AttributeValue.S("N_" + Name_beacon + ".Y_1984"),
                                       ":Name" := DDB.AttributeValue.S(Name_beacon),
                                       ":NameTitle" := DDB.AttributeValue.S("N_" + Name_beacon + ".T_" + Title_beacon),
                                       ":NameTitleTN" := DDB.AttributeValue.S("N_" + Name_beacon + ".T_" + Title_beacon),
                                       ":NameTitleN" := DDB.AttributeValue.S("N_" + Name_beacon),
                                       ":NameTitleT" := DDB.AttributeValue.S("T_" + Title_beacon),
                                       ":NameTitleField" := DDB.AttributeValue.S(NameTitle_beacon),
                                       ":std2" := DDB.AttributeValue.S(std2_beacon),
                                       ":Title" := DDB.AttributeValue.S(Title_beacon),
                                       ":std6" := DDB.AttributeValue.S(std6_beacon),
                                       ":std4" := DDB.AttributeValue.S(std4_beacon),
                                       ":YearName" := DDB.AttributeValue.S("Y_1984.N_" + Name_beacon)
                                     ]);
    expect newContext.names == None;
    //expect_equal(newContext.expr, Some("aws_dbe_b_std2 <> :A AND #Field4 = :B"));
  }
}
