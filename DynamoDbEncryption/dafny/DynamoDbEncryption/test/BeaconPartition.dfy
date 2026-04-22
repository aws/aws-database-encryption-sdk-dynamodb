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

  method {:test} TestLongAttributeNameForPartitionBeacon() {
    var store := GetKeyStore();

    // -- create a beacon with a long name
    // standarad beacon name constraints is that it has to be of type string.
    var longName := "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    var longNameBeacon := T.StandardBeacon(name := longName, length := 24, loc := None, style := None, numberOfPartitions := Some(3));
    var longNameVersion := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [longNameBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(10)
    );
    var longNameConfig := FullTableConfig.(attributeActionsOnEncrypt := map[longName := SE.ENCRYPT_AND_SIGN]);
    var src3 := GetLiteralSource([1,2,3,4,5], longNameVersion);
    var res3 := C.ConvertVersionWithSource(longNameConfig, longNameVersion, src3);
    expect res3.Success?;
  }

  method {:test} TestQueryMixedTableBeaconPartitions() {
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
    // We need to create a table with mulitple beacons with different partition numbers
    // We will test with the current number of partitions which is 1 and 5 partitions
    var version := GetLotsaBeacons();
    var partionedVersion := version.(standardBeacons := [std2, std4Partitioned, std6, NameTitleBeacon, NameB, TitleB], maximumNumberOfPartitions := Some(10));
    var src := GetLiteralSource([1,2,3,4,5], partionedVersion);
    var beaconVersion :- expect C.ConvertVersionWithSource(
      FullTableConfig.(search := Some(T.SearchConfig(versions := [partionedVersion], writeVersion := 1))),
      partionedVersion,
      src
    );
    var newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId, 0);
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
  }

  method {:test} TestNumberOfQueriesPartition1() {
    var store := GetKeyStore();

    //  --- Not passing any partition number is the same as saying partitions == 1 ---
    var validBeacon := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None);
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [validBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None
    ); 
    var src := GetLiteralSource([1,2,3,4,5], version);
    var longNameConfig := FullTableConfig.(search := Some(T.SearchConfig(versions := [version], writeVersion := 1)));
    var beaconVersion :- expect C.ConvertVersionWithSource(longNameConfig, version, src);
    var queryInput := DDB.QueryInput(
        TableName := "SomeTable",
        KeyConditionExpression := Some("std2 = :std2"),
        ExpressionAttributeValues := Some(map[":std2" := Std2String])
    );

    var res := DDBS.GetNumberOfQueries(
      search := beaconVersion,
      query := queryInput 
    );

    expect res.Success?;
    expect res.value == 1;
  }
  
  method {:test} TestNumberOfQueriesPartition5() {
    var store := GetKeyStore();

    //  --- Using 5 partitions, should get back 5 as the number of queries ---
    var validBeacon := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(5));
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [validBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(6)
    ); 
    var src := GetLiteralSource([1,2,3,4,5], version);
    var longNameConfig := FullTableConfig.(search := Some(T.SearchConfig(versions := [version], writeVersion := 1)));
    var beaconVersion :- expect C.ConvertVersionWithSource(longNameConfig, version, src);
    var queryInput := DDB.QueryInput(
        TableName := "SomeTable",
        KeyConditionExpression := Some("std2 = :std2"),
        ExpressionAttributeValues := Some(map[":std2" := Std2String])
    );

    var res := DDBS.GetNumberOfQueries(
      search := beaconVersion,
      query := queryInput 
    );

    expect res.Success?;
    expect res.value == 5;
  }

  method {:test} TestNumberOfQueriesPartition25() {
    var store := GetKeyStore();

    //  --- Using 25 partitions, should get back 25 as the number of queries ---
    var validBeacon := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(25));
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [validBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(26)
    ); 
    var src := GetLiteralSource([1,2,3,4,5], version);
    var longNameConfig := FullTableConfig.(search := Some(T.SearchConfig(versions := [version], writeVersion := 1)));
    var beaconVersion :- expect C.ConvertVersionWithSource(longNameConfig, version, src);
    var queryInput := DDB.QueryInput(
        TableName := "SomeTable",
        KeyConditionExpression := Some("std2 = :std2"),
        ExpressionAttributeValues := Some(map[":std2" := Std2String])
    );

    var res := DDBS.GetNumberOfQueries(
      search := beaconVersion,
      query := queryInput 
    );

    expect res.Success?;
    expect res.value == 25;
  }

  method {:test} TestNumberOfQueriesWithMultipleBeaconsConfigured() {
    var store := GetKeyStore();
    // -- Test with 2 Beacons one with 3 the other with 5, this should result in a 15 Number of Queries
    var beacon3 := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(3));
    var beacon5 := std4Partitioned;

    // Test only the least common multiple logic, since the number of partitions
    // for beacon3 and beacon5 is 3 and 5 respectively, the
    // LCM(3, 5) is 15. The spec says, that the number of queries is the minimum value between
    // max number of partitions configured on the table and the LCM of the beacons being evaluated.
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [beacon3, beacon5],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(16)
    ); 
    var src := GetLiteralSource([1,2,3,4,5], version);
    var config := FullTableConfig.(search := Some(T.SearchConfig(versions := [version], writeVersion := 1)));
    var beaconVersion :- expect C.ConvertVersionWithSource(config, version, src);
    var queryInput := DDB.QueryInput(
        TableName := "SomeTable",
        KeyConditionExpression := Some("std4 = :std4 AND std2 = :std2"),
        ExpressionAttributeValues := Some(map[
            ":std4" := Std4String,
            ":std2" := Std2String
        ])
    );
    
    var res := DDBS.GetNumberOfQueries(
      search := beaconVersion,
      query := queryInput
    );

    expect res.Success?;
    expect res.value == 15;

    // Test that the hard limit of max number of partitions gets evaluated when
    // it comes to number of queries
    version := version.(maximumNumberOfPartitions := Some(6));
    beaconVersion :- expect C.ConvertVersionWithSource(config, version, src);
    res := DDBS.GetNumberOfQueries(
      search := beaconVersion,
      query := queryInput
    );

    expect res.Success?;
    expect res.value == 6;
  }

  method {:test} TestNumberOfQueriesForCompoundBeacons() {
    var store := GetKeyStore();

    // NameTitle compound beacon uses Name (encrypted) and Title (encrypted) parts.
    // Give Name 3 partitions and Title 5 partitions via their standard beacons.
    var namePartitioned := T.StandardBeacon(name := "Name", length := 32, loc := None, style := None, numberOfPartitions := Some(3));
    var titlePartitioned := T.StandardBeacon(name := "Title", length := 32, loc := None, style := None, numberOfPartitions := Some(5));
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [namePartitioned, titlePartitioned],
      compoundBeacons := Some([NameTitle]),
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(16)
    );
    var src := GetLiteralSource([1,2,3,4,5], version);
    var config := FullTableConfig.(search := Some(T.SearchConfig(versions := [version], writeVersion := 1)));
    var beaconVersion :- expect C.ConvertVersionWithSource(config, version, src);

    // Query on compound beacon NameTitle with both parts → LCM(3,5) = 15
    var queryInput := DDB.QueryInput(
      TableName := "SomeTable",
      KeyConditionExpression := Some("NameTitle = :nt"),
      ExpressionAttributeValues := Some(map[":nt" := DDB.AttributeValue.S("N_MyName.T_MyTitle")])
    );
    var res := DDBS.GetNumberOfQueries(search := beaconVersion, query := queryInput);
    expect res.Success?;
    expect res.value == 15;

    // Query on compound beacon with only Name part → should be 3
    var queryInput2 := DDB.QueryInput(
      TableName := "SomeTable",
      KeyConditionExpression := Some("NameTitle = :nt"),
      ExpressionAttributeValues := Some(map[":nt" := DDB.AttributeValue.S("N_MyName")])
    );
    var res2 := DDBS.GetNumberOfQueries(search := beaconVersion, query := queryInput2);
    expect res2.Success?;
    expect res2.value == 3;
  }

  method {:test} TestDefaultPartitionsWithoutMaxPartitionsFail() {
    var store := GetKeyStore();

    // Spec: Initialization MUST fail if defaultNumberOfPartitions is supplied
    // but maximumNumberOfPartitions is not.
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [std2],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      defaultNumberOfPartitions := Some(3)
    );
    var src := GetLiteralSource([1,2,3,4,5], version);
    var res := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect res.Failure?;
  }

  method {:test} TestBoundaryPartitionValues() {
    var store := GetKeyStore();

    // --- maximumNumberOfPartitions = 255 is INVALID (must be < MAX_PARTITION_COUNT=255) ---
    var beacon254 := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(253));
    var version255 := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [beacon254],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(255)
    );
    var src := GetLiteralSource([1,2,3,4,5], version255);
    var res := C.ConvertVersionWithSource(FullTableConfig, version255, src);
    expect res.Failure?;

    // --- maximumNumberOfPartitions = 254 (actual max allowed) with beacon constrained to 253 ---
    var beacon253 := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(253));
    var version254 := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [beacon253],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(254)
    );
    var src1 := GetLiteralSource([1,2,3,4,5], version254);
    var res1 := C.ConvertVersionWithSource(FullTableConfig, version254, src1);
    expect res1.Success?;

    // --- maximumNumberOfPartitions = 128 (representative large) ---
    var beacon64 := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None, numberOfPartitions := Some(64));
    var version128 := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [beacon64],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(128)
    );
    var src2 := GetLiteralSource([1,2,3,4,5], version128);
    var res2 := C.ConvertVersionWithSource(FullTableConfig, version128, src2);
    expect res2.Success?;

    // Verify GetNumberOfQueries returns 64 for the constrained beacon
    var config := FullTableConfig.(search := Some(T.SearchConfig(versions := [version128], writeVersion := 1)));
    var bv :- expect C.ConvertVersionWithSource(config, version128, src2);
    var queryInput := DDB.QueryInput(
      TableName := "SomeTable",
      KeyConditionExpression := Some("std2 = :std2"),
      ExpressionAttributeValues := Some(map[":std2" := Std2String])
    );
    var qRes := DDBS.GetNumberOfQueries(search := bv, query := queryInput);
    expect qRes.Success?;
    expect qRes.value == 64;
  }

  method {:test} TestBeaconPartitionEncoding() {
    // Same value hashed in partition 0 vs partition N should produce different beacon values.
    // Use the same beacon set as GetLotsaBeacons so HMAC keys match.
    // Must set defaultNumberOfPartitions AND pass a config with search set,
    // because GetPartitionCount returns 1 when outer.search.None?.
    var lotsaVersion := GetLotsaBeacons();
    var partitionedVersion := lotsaVersion.(maximumNumberOfPartitions := Some(10), defaultNumberOfPartitions := Some(5));
    var src := GetLiteralSource([1,2,3,4,5], partitionedVersion);
    var config := FullTableConfig.(search := Some(T.SearchConfig(versions := [partitionedVersion], writeVersion := 1)));
    var bv :- expect C.ConvertVersionWithSource(config, partitionedVersion, src);

    // Generate beacons for partition 0 and partition 1
    var attrs0 :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId, 0);
    var attrs1 :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId, 1);

    // Both should produce beacon values
    expect "aws_dbe_b_Name" in attrs0;
    expect "aws_dbe_b_Name" in attrs1;
    expect attrs0["aws_dbe_b_Name"].S?;
    expect attrs1["aws_dbe_b_Name"].S?;

    // Core property: different partitions produce different beacon hashes for the same input
    expect attrs0["aws_dbe_b_Name"] != attrs1["aws_dbe_b_Name"];

    // Partition 0 uses empty encoding (PartitionNumberToBytes(0) == []),
    // so it should match the non-partitioned beacon from the same beacon set
    var noPartVersion := GetLotsaBeacons();
    var noPartSrc := GetLiteralSource([1,2,3,4,5], noPartVersion);
    var noPartBv :- expect C.ConvertVersionWithSource(FullTableConfig, noPartVersion, noPartSrc);
    var noPartAttrs :- expect noPartBv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId, 0);
    expect "aws_dbe_b_Name" in noPartAttrs;
    expect attrs0["aws_dbe_b_Name"] == noPartAttrs["aws_dbe_b_Name"];
  }

  method {:test} TestDefaultPartitionInheritance() {
    var store := GetKeyStore();

    // Set maximumNumberOfPartitions=10, defaultNumberOfPartitions=3.
    // Beacons without explicit numberOfPartitions should inherit default (3).
    var unconstrainedBeacon := T.StandardBeacon(name := "std2", length := 24, loc := None, style := None);
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [unconstrainedBeacon],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(10),
      defaultNumberOfPartitions := Some(3)
    );
    var src := GetLiteralSource([1,2,3,4,5], version);
    var config := FullTableConfig.(search := Some(T.SearchConfig(versions := [version], writeVersion := 1)));
    var bv :- expect C.ConvertVersionWithSource(config, version, src);

    // GetNumberOfQueries should return 3 (the default), not 10 (the max)
    var queryInput := DDB.QueryInput(
      TableName := "SomeTable",
      KeyConditionExpression := Some("std2 = :std2"),
      ExpressionAttributeValues := Some(map[":std2" := Std2String])
    );
    var res := DDBS.GetNumberOfQueries(search := bv, query := queryInput);
    expect res.Success?;
    expect res.value == 3;
  }

  method {:test} TestInvalidPartitionType() {
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

    // :aws_dbe_partition as type S (string) instead of N — should fail
    var valuesS : DDB.ExpressionAttributeValueMap := map[":aws_dbe_partition" := DDB.AttributeValue.S("2")];
    var resS := DDBS.ExtractPartition(bv, None, Some("Name = :val"), None, Some(valuesS), FullTableConfig.attributeActionsOnEncrypt);
    expect resS.Failure?;

    // :aws_dbe_partition as type BOOL — should fail
    var valuesB : DDB.ExpressionAttributeValueMap := map[":aws_dbe_partition" := DDB.AttributeValue.BOOL(true)];
    var resB := DDBS.ExtractPartition(bv, None, Some("Name = :val"), None, Some(valuesB), FullTableConfig.attributeActionsOnEncrypt);
    expect resB.Failure?;
  }

  method {:test} TestMissingBeaconAttributeWithPartitions() {
    var store := GetKeyStore();
    var version := T.BeaconVersion(
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [NameB],
      compoundBeacons := None,
      virtualFields := None,
      encryptedParts := None,
      signedParts := None,
      maximumNumberOfPartitions := Some(5)
    );
    var src := GetLiteralSource([1,2,3,4,5], version);
    var config := FullTableConfig.(search := Some(T.SearchConfig(versions := [version], writeVersion := 1)));
    var bv :- expect C.ConvertVersionWithSource(config, version, src);

    // Item missing the "Name" attribute — beacon should not be generated for it
    var itemMissingName : DDB.AttributeMap := map[
      "std2" := Std2String,
      "Title" := TitleString
    ];
    var attrs :- expect bv.GenerateEncryptedBeacons(itemMissingName, DontUseKeyId, 2);
    // The Name beacon should not appear since the attribute is absent
    expect "aws_dbe_b_Name" !in attrs;
  }
}
