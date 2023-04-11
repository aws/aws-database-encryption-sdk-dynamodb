// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "BeaconTestFixtures.dfy"
include "../src/ConfigToInfo.dfy"

module TestDynamoDBConfigToInfo {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened ComAmazonawsDynamodbTypes
  import opened DynamoDBFilterExpr
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened BeaconTestFixtures
  import opened SearchConfigToInfo
  import opened DynamoDbEncryptionUtil

  method {:test} TestTwoBeaconsOneLoc() {
    var fred := StandardBeacon(name := "fred", length := 16, loc := Some("std6[0]"));
    var newBeacons := LotsaBeacons.(standardBeacons := Some([std2, std4, std6, NameTitleBeacon, NameB, TitleB, fred]));
    var beaconVersion := ConvertVersionWithKey(FullTableConfig, newBeacons, [1,2,3,4,5]);
    expect beaconVersion.Failure?;
    expect beaconVersion.error == E("Beacon fred is defined on location std6[0], but beacon std6 is already defined on that location.");
  }
  method {:test} TestTwoVirtOneLoc() {
    var TitleNameField := VirtualField(name := "TitleNameField", parts := [VPart2, VPart1]);
    var newBeacons := LotsaBeacons.(virtualFields := Some([NameTitleField, TitleNameField]));
    var beaconVersion := ConvertVersionWithKey(FullTableConfig, newBeacons, [1,2,3,4,5]);
    expect beaconVersion.Failure?;
    expect beaconVersion.error == E("Virtual field TitleNameField is defined on the same locations as NameTitleField.");
  }
  method {:test} TestVirtAndBeaconSameLoc() {
    var newBeacons := LotsaBeacons.(virtualFields := Some([NameVirtField, NameTitleField]));
    var beaconVersion := ConvertVersionWithKey(FullTableConfig, newBeacons, [1,2,3,4,5]);
    expect beaconVersion.Failure?;
    expect beaconVersion.error == E("Beacon Name is defined on location Name, but virtual field NameVirtField is already defined on that single location.");
  }
  /*
    If primary or sort keys of table are beacons, they must be strictly NonSensitive
  */
}