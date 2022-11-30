// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/DynamoToStruct.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/libraries/src/Wrappers.dfy"
include "../../StructuredEncryption/Model/AwsCryptographyStructuredEncryptionTypes.dfy"


import opened DynamoToStruct
import opened Wrappers
import opened ComAmazonawsDynamodbTypes
import opened AwsCryptographyStructuredEncryptionTypes


  method {:opaque} check(o : AttributeMap, n : Result<AttributeMap, string>)
  {
    if n.Failure? {
      print n, "\n";
    }
    /*
    else {
      print "***\n";
      if "key10" in o {
        print o["key10"], "\n";
      }
      if "key10" in n.value {
        print n.value["key10"], "\n";
      }
      print "***\n";
    }
    */
    expect n.Success?;
    expect o == n.value;

  }
  method {:opaque} check1(x : Result<StructuredDataMap, string>) {
    if x.Failure? {
      print "SD ", x, "\n";
    } else {
      //print x.value, "\n";
    }
  }

  method {:test} {:vcs_split_on_every_assert} someTest() {

    var val1 := AttributeValue.S("astring");
    var val2 := AttributeValue.N("12345");
    var val3 := AttributeValue.B([1,2,3,4,5]);
    var val4 := AttributeValue.BOOL(true);
    var val5 := AttributeValue.NULL(false);
    var val6 := AttributeValue.BS([[1,2,3,4,5],[2,3,4,5,6],[3,4,5,6,7]]);
    var val7 := AttributeValue.SS(["ab","cdef","ghijk"]);
    var val8 := AttributeValue.NS(["1","234.567","0"]);

    var val9a := AttributeValue.L([val8, val7, val6]);
    var val9b := AttributeValue.L([val5, val4, val3]);
    var val9c := AttributeValue.L([val2, val1]);
    var val9 := AttributeValue.L([val9a, val9b, val9c]);
    var val10 := AttributeValue.M(map["key1" := val1, "key2" := val2, "key3" := val3, "key4" := val4, "key5" := val5, "key6" := val6, "key7" := val7, "key8" := val8, "key9" := val9]);

    var attrMap := map["key1" := val1, "key2" := val2, "key3" := val3, "key4" := val4, "key5" := val5, "key6" := val6, "key7" := val7, "key8" := val8, "key9" := val9, "key10" := val10];
    var struct := ItemToStructured(attrMap);
    check1(struct);
    expect struct.Success?;
    var nAttrMap := StructuredToItem(struct.value);
    check(attrMap, nAttrMap);
  }

