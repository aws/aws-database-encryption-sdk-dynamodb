// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "BeaconTestFixtures.dfy"
include "../src/DDBSupport.dfy"

module TestDDBSupport {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened ComAmazonawsDynamodbTypes
  import opened DynamoDBFilterExpr
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened BeaconTestFixtures
  import opened DynamoDBSupport
  import opened DynamoDbEncryptionUtil
  import opened SearchConfigToInfo
  import SI = SearchableEncryptionInfo

  method {:test} TestAddSignedBeacons() {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect ConvertVersionWithSource(FullTableConfig, version, src);
    var search := SI.SearchInfo([bv], 0);
    expect search.ValidState?();
    var newItem :- expect AddSignedBeacons(Some(search), SimpleItem);
    assert IsValid_AttributeName("aws_dbe_v_1");
    assert IsValid_AttributeName("JustSigned");
    var expectedNew : DDB.AttributeMap := map[
      "aws_dbe_v_1" := AttributeValue.S(" "),
      "JustSigned" := AttributeValue.S("Y_1984.M_May")
    ];
    expect newItem == SimpleItem + expectedNew;
  }

}