// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "BeaconTestFixtures.dfy"
include "Beacon.dfy"
include "../src/DDBSupport.dfy"

module TestBeaconPartition {
  import T = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened Wrappers
  import opened BeaconTestFixtures
  import opened DynamoDbEncryptionUtil
  import opened DynamoDBFilterExpr
  import C = SearchConfigToInfo
  import I = SearchableEncryptionInfo
  import DDB = ComAmazonawsDynamodbTypes
  import SE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import DDBS = DynamoDBSupport

  method {:test} TestEmptyBeaconName() {
    // --- Empty beacon name ---
    var store := GetKeyStore();
    var emptyNameBeacon := T.StandardBeacon(name := "", length := 24, loc := None, style := None);
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [emptyNameBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None
    );
    var emptyConfig := FullTableConfig.(attributeActionsOnEncrypt := map["" := SE.ENCRYPT_AND_SIGN]);
    var src := GetLiteralSource([1,2,3,4,5], version);
    var res := C.ConvertVersionWithSource(emptyConfig, version, src);
    expect res.Failure?;

  }

  method {:test} TestUnicodeBeaconName() {
    var store := GetKeyStore();
    // --- Unicode beacon name ---
    // Note: Dafny strings are sequences of UTF-16 chars; "café" is valid
    var unicodeNameBeacon := T.StandardBeacon(name := "caf\u00E9", length := 24, loc := None, style := None);
    var unicodeVersion := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [unicodeNameBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None
    );
    var unicodeConfig := FullTableConfig.(attributeActionsOnEncrypt := map["caf\u00E9" := SE.ENCRYPT_AND_SIGN]);
    var unicodeSrc := GetLiteralSource([1,2,3,4,5], unicodeVersion);
    var unicodeRes := C.ConvertVersionWithSource(unicodeConfig, unicodeVersion, unicodeSrc);
    expect unicodeRes.Success?;
    // Unicode names should succeed

    // --- Empty string value hashing ---
    var lotsaVersion := GetLotsaBeacons();
    var lotsaSrc := GetLiteralSource([1,2,3,4,5], lotsaVersion);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, lotsaVersion, lotsaSrc);
    var emptyValueItem := SimpleItem["Name" := DDB.AttributeValue.S("")];
    var emptyValueAttrs :- expect bv.GenerateEncryptedBeacons(emptyValueItem, DontUseKeyId, 0);
    expect "aws_dbe_b_Name" in emptyValueAttrs;
    // The beacon value should be non-empty
    expect emptyValueAttrs["aws_dbe_b_Name"].S?;
    expect |emptyValueAttrs["aws_dbe_b_Name"].S| > 0;

    // --- Unicode string value hashing ---
    var unicodeValueItem := SimpleItem["Name" := DDB.AttributeValue.S("\u540D\u524D")];
    var unicodeValueAttrs :- expect bv.GenerateEncryptedBeacons(unicodeValueItem, DontUseKeyId, 0);
    expect "aws_dbe_b_Name" in unicodeValueAttrs;
    expect unicodeValueAttrs["aws_dbe_b_Name"].S?;
    expect |unicodeValueAttrs["aws_dbe_b_Name"].S| > 0;
  }

  method {:test} TestInvalidMaxNumberOfPartitionsConfigError() {
    var store := GetKeyStore();

    // --- defaultNumberOfPartitions == maximumNumberOfPartitions (should fail) ---
    var version1 := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [std2],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(5),
      defaultNumberOfPartitions := Some(5)
    );
    var src1 := GetLiteralSource([1,2,3,4,5], version1);
    var res1 := C.ConvertVersionWithSource(FullTableConfig, version1, src1);
    expect res1.Failure?;
    expect_equal(res1.error, E("Invalid defaultNumberOfPartitions specified, 5, must be 0 < defaultNumberOfPartitions < maximumNumberOfPartitions."));

    // --- defaultNumberOfPartitions > maximumNumberOfPartitions (should fail) ---
    var version2 := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [std2],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(5),
      defaultNumberOfPartitions := Some(10)
    );
    var src2 := GetLiteralSource([1,2,3,4,5], version2);
    var res2 := C.ConvertVersionWithSource(FullTableConfig, version2, src2);
    expect res2.Failure?;
    expect_equal(res2.error, E("Invalid defaultNumberOfPartitions specified, 10, must be 0 < defaultNumberOfPartitions < maximumNumberOfPartitions."));
  }

  method {:test} TestConstrainedBeaconConfigErrorsNumPartitionsEqConstrainedBeaconPartionsFail() {
    var store := GetKeyStore();

    // --- numberOfPartitions == maximumNumberOfPartitions (should fail) ---
    var constrainedBeacon := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(5));
    var version1 := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [constrainedBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(5)
    );
    var src1 := GetLiteralSource([1,2,3,4,5], version1);
    var res1 := C.ConvertVersionWithSource(
      FullTableConfig.(search := Some(T.SearchConfig(versions := [version1], writeVersion := 1))),
      version1,
      src1
    );
    expect res1.Failure?;
    expect_equal(res1.error, E("Constrained numberOfPartitions for  std2 is 5 but it must be less than the maximumNumberOfPartitions 5"));
  }

  method {:test} TestConstrainedBeaconPartitionGreaterThanMaxNumPartitionsFail() {
    var store := GetKeyStore();

    // --- numberOfPartitions > maximumNumberOfPartitions (should fail) ---
    var overBeacon := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(10));
    var version2 := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [overBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(5)
    );
    var src2 := GetLiteralSource([1,2,3,4,5], version2);
    var res2 := C.ConvertVersionWithSource(
      FullTableConfig.(search := Some(T.SearchConfig(versions := [version2], writeVersion := 1))),
      version2,
      src2
    );
    expect res2.Failure?;
    expect_equal(res2.error, E("Constrained numberOfPartitions for  std2 is 10 but it must be less than the maximumNumberOfPartitions 5")); 
  }

  method {:test} TestConstrainedBeaconNumPartitionLessThanMaxNumPartitionsSucceed() {
    var store := GetKeyStore();

    // --- numberOfPartitions < maximumNumberOfPartitions (should succeed) ---
    var validBeacon := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(3));
    var version3 := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [validBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(10)
    );
    var src3 := GetLiteralSource([1,2,3,4,5], version3);
    var res3 := C.ConvertVersionWithSource(FullTableConfig, version3, src3);
    expect res3.Success?;
  }

  method {:test} TestInvalidPartitionOnQuery() {
    // Set up a BeaconVersion with partitions
    var store := GetKeyStore();
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [std2, NameB, TitleB],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(5)
    );
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);

    // --- Partition number >= numPartitions (should fail) ---
    var values1 : DDB.ExpressionAttributeValueMap := map[":aws_dbe_partition" := DDB.AttributeValue.N("5")];
    var res1 := DDBS.ExtractPartition(bv, None, Some("Name = :val"), None, Some(values1), FullTableConfig.attributeActionsOnEncrypt);
    expect res1.Failure?;

    // --- Partition specified when no partitions configured (should fail) ---
    var noPartVersion := GetLotsaBeacons();
    var noPartSrc := GetLiteralSource([1,2,3,4,5], noPartVersion);
    var noPartBv :- expect C.ConvertVersionWithSource(FullTableConfig, noPartVersion, noPartSrc);
    var values2 : DDB.ExpressionAttributeValueMap := map[":aws_dbe_partition" := DDB.AttributeValue.N("0")];
    var res2 := DDBS.ExtractPartition(noPartBv, None, Some("Name = :val"), None, Some(values2), FullTableConfig.attributeActionsOnEncrypt);
    expect res2.Failure?;

    // --- Missing partition when partitions configured and encrypted fields used (should fail) ---
    var res3 := DDBS.ExtractPartition(bv, None, Some("Name = :val"), None, None, FullTableConfig.attributeActionsOnEncrypt);
    expect res3.Failure?;
  }

}
