// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"

module JsonEncryptorTest {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import JsonEncryptor
  import JsonToStruct
  import UTF8
  import JSON.API

  // import AwsCryptographyMaterialProvidersTypes
  // import Types = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  // import UTF8
  // import DDB = ComAmazonawsDynamodbTypes
  // import TestFixtures
  // import AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations
  // import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  // import SE = StructuredEncryptionUtil
  // import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  // import AlgorithmSuites
  // import StandardLibrary.String


  method ExpectEqualJson(item : string, final : string)
  {
    var obj :- expect UTF8.Encode(item);
    var itemJson :- expect API.Deserialize(obj);
    var jsonBytes :- expect API.Serialize(itemJson);
    var newItem :- expect UTF8.Decode(jsonBytes);

  if newItem == final {
    return;
  }

    obj :- expect UTF8.Encode(final);
    var finalJson :- expect API.Deserialize(obj);
    if JsonToStruct.JsonEqual(itemJson, finalJson) {
      print "Item seemed to change from : ", item, " to ", final, " but it was really still the same\n";

    } else {
      print "Item changed : ", item, " to ", final, "\n";
      expect false;
    }
  }

  method TestRoundTrip(item : string)
  {
    print "Testing ", item, "\n";
    var o2s := JsonToStruct.ObjectToStructured(item, None);
    if o2s.Failure? {
      print "Unexpected ObjectToStructured error : \n", o2s.error, "\n", item, "\n";
    }
    expect o2s.Success?;
    var s2o := JsonToStruct.StructuredToObject(o2s.value);
    if s2o.Failure? {
      print "Unexpected StructuredToObject error : \n", s2o.error, "\n", item, "\n", o2s.value, "\n";
    }
    expect s2o.Success?;
    ExpectEqualJson(item, s2o.value);

  }
  method {:test} TestRoundTrips() {
    TestRoundTrip("{}");
    TestRoundTrip("{\"abc\" : 42}");
    TestRoundTrip("{\"abc\" : true}");
    TestRoundTrip("{\"abc\" : false}");
    TestRoundTrip("{\"abc\" : null}");
    TestRoundTrip("{\"abc\" : 100}");
    TestRoundTrip("{\"abc\" : 100e0}");
    TestRoundTrip("{\"abc\" : 100e1}");
    TestRoundTrip("{\"abc\" : 100e2}");
    TestRoundTrip("{\"abc\" : \"foo\"}");
    TestRoundTrip("{\"abc\" : \"foo\", \"bcd\" : true, \"cde\" : 42}");
    TestRoundTrip("{\"abc\" : {}}");
    TestRoundTrip("{\"abc\" : []}");
    TestRoundTrip("{\"abc\" : [1,2,true,false,null,\"aaa\"]}");
    TestRoundTrip("{\"abc\" : {\"bcd\" : 42, \"abcde\" : null, \"cde\" : \"foo\", \"qwert\" : [1,2,3]}}");
  }

}
