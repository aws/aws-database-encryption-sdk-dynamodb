// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "BeaconTestFixtures.dfy"
include "../src/ConfigToInfo.dfy"

module TestDynamoDBConfigToInfo {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
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
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var newBeacons := version.(standardBeacons := [std2, std4, std6, NameTitleBeacon, NameB, TitleB, fred]);
    var beaconVersion := ConvertVersionWithSource(FullTableConfig, newBeacons, src);
    expect beaconVersion.Failure?;
    expect beaconVersion.error == E("Beacon fred is defined on location std6[0], but beacon std6 is already defined on that location.");
  }
  method {:test} TestTwoVirtOneLoc() {
    var TitleNameField := VirtualField(name := "TitleNameField", parts := [VPart2, VPart1]);
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var newBeacons := version.(virtualFields := Some([NameTitleField, TitleNameField]));
    var beaconVersion := ConvertVersionWithSource(FullTableConfig, newBeacons, src);
    expect beaconVersion.Failure?;
    expect beaconVersion.error == E("Virtual field TitleNameField is defined on the same locations as NameTitleField.");
  }
  method {:test} TestVirtAndBeaconSameLoc() {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var newBeacons := version.(virtualFields := Some([NameVirtField, NameTitleField]));
    var beaconVersion := ConvertVersionWithSource(FullTableConfig, newBeacons, src);
    expect beaconVersion.Failure?;
    expect beaconVersion.error == E("Beacon Name is defined on location Name, but virtual field NameVirtField is already defined on that single location.");
  }
  method {:test} TestNSwithEB() {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);

    var DupNameNS := CompoundBeacon (
      name := "Name",
      split := ".",
      encrypted := None,
      signed := Some([Year,Month]),
      constructors := None
    );
    var DupNameS := DupNameNS.(encrypted := Some([Title]));
    var newBeacons := version.(compoundBeacons := Some([DupNameS]), standardBeacons := [std2, std4, std6, NameTitleBeacon, TitleB]);
    var beaconVersion := ConvertVersionWithSource(FullTableConfig, newBeacons, src);
    expect beaconVersion.Success?;

    newBeacons := newBeacons.(compoundBeacons := Some([DupNameNS]));
    beaconVersion := ConvertVersionWithSource(FullTableConfig, newBeacons, src);
    expect beaconVersion.Failure?;
    expect beaconVersion.error == E("Name not allowed as a CompoundBeacon because a fully signed beacon cannot have the same name as an existing attribute.");
  }
}
