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
  import SE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes

  const x123 : UTF8.ValidUTF8Bytes :=
    var s := [0x31, 0x32, 0x33];
    assert s == UTF8.EncodeAscii("123");
    s

  method {:test} TestBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var bb := BeaconBase(client := primitives, name := "foo", beaconName := "aws_dbe_b_foo");
    var b := StandardBeacon(bb, 8, TermLocMap("foo"), false, false, None);
    var bytes :- expect bb.getHmac([1,2,3], key := [1,2]);
    expect bytes == [0x27, 0x93, 0x93, 0x8b, 0x26, 0xe9, 0x52, 0x7e];
    var str :- expect b.hash([1,2,3], key := [1,2]);
    expect str == "7e";
    bytes :- expect bb.getHmac([], key := [1,2]);
    expect bytes[7] == 0x80;
    str :- expect b.hash([], key := [1,2]);
    expect str == "80";
    bytes :- expect bb.getHmac(x123, key := [1,2]);
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
      virtualFields := None,
      encryptedParts := None,
      signedParts := None
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

  method {:test} TestSharedCacheBeaconsSingleKeyStoreWithSamePartitionId()
  {
    var partitionId : string := "partitionId";
    var sharedCache : MPT.CacheType := GetSharedCache();
    var primitives :- expect Primitives.AtomicPrimitives();

    // Verification by adding assume statements in "by" passes, but there's an error while transpiling code to runtimes
    // Dafny is working on a fix. Update this test when Dafny releases `4.9.2`.
    // Using `assume{:axiom} false;` for this test for now.
    // var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives) by {
    //   assume {:axiom} C.ValidSharedCache(version.keySource);
    // }
    // var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    // var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId) by {
    //   assume{:axiom} false;
    // }
    assume{:axiom} false;

    // This call is expected to fail because we are providing a Bad KeyStore which does NOT exist
    var badVersion := GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(cache := sharedCache, partitionId := Some(partitionId));
    var badSrc :- expect C.MakeKeySource(FullTableConfig, badVersion.keyStore, badVersion.keySource, primitives);
    var badBv :- expect C.ConvertVersionWithSource(FullTableConfig, badVersion, badSrc);
    var badAttrs := badBv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect badAttrs.Failure?;

    // This is expected to pass because we pass a valid KeyStore
    var version := GetLotsaBeaconsSingleWithSharedCache(cache := sharedCache, partitionId := Some(partitionId));
    var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);

    // This is expected to pass now because the cache already has cached material for this Branch Key ID.
    // This is a hack to test that the correct material is cached.
    var badAttrsNowCached :- expect badBv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
  }

  method {:test} TestSharedCacheBeaconsSingleKeyStoreWithDifferentPartitionId()
  {
    var sharedCache : MPT.CacheType := GetSharedCache();
    var primitives :- expect Primitives.AtomicPrimitives();

    // Verification by adding assume statements in "by" passes, but there's an error while transpiling code to runtimes
    // Dafny is working on a fix. Update this test when Dafny releases `4.9.2`.
    // Using `assume{:axiom} false;` for this test for now.
    // var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives) by {
    //   assume {:axiom} C.ValidSharedCache(version.keySource);
    // }
    // var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    // var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId) by {
    //   assume{:axiom} false;
    // }
    assume{:axiom} false;

    // This call is expected to fail because we are providing a Bad KeyStore which does NOT exist
    var partitionIdBadVersion : string := "partitionIdBadVersion";
    var badVersion := GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(cache := sharedCache, partitionId := Some(partitionIdBadVersion));
    var badSrc :- expect C.MakeKeySource(FullTableConfig, badVersion.keyStore, badVersion.keySource, primitives);
    var badBv :- expect C.ConvertVersionWithSource(FullTableConfig, badVersion, badSrc);
    var badAttrs := badBv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect badAttrs.Failure?;

    // This is expected to pass because we pass a valid KeyStore
    var partitionIdGoodVersion : string := "partitionIdGoodVersion";
    var version := GetLotsaBeaconsSingleWithSharedCache(cache := sharedCache, partitionId := Some(partitionIdGoodVersion));
    var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);

    // This is still expected to fail because the partitionId for the cached material is different.
    var badAttrsNowCached := badBv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect badAttrsNowCached.Failure?;
  }

  method {:test} TestSharedCacheBeaconsSingleKeyStoreWithUnspecifiedPartitionId()
  {
    var sharedCache : MPT.CacheType := GetSharedCache();
    var primitives :- expect Primitives.AtomicPrimitives();

    // Verification by adding assume statements in "by" passes, but there's an error while transpiling code to runtimes
    // Dafny is working on a fix. Update this test when Dafny releases `4.9.2`.
    // Using `assume{:axiom} false;` for this test for now.
    // var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives) by {
    //   assume {:axiom} C.ValidSharedCache(version.keySource);
    // }
    // var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    // var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId) by {
    //   assume{:axiom} false;
    // }
    assume{:axiom} false;

    // This call is expected to fail because we are providing a Bad KeyStore which does NOT exist
    var badVersion := GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(cache := sharedCache, partitionId := None);
    var badSrc :- expect C.MakeKeySource(FullTableConfig, badVersion.keyStore, badVersion.keySource, primitives);
    var badBv :- expect C.ConvertVersionWithSource(FullTableConfig, badVersion, badSrc);
    var badAttrs := badBv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect badAttrs.Failure?;

    // This is expected to pass because we pass a valid KeyStore
    var version := GetLotsaBeaconsSingleWithSharedCache(cache := sharedCache, partitionId := None);
    var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);

    // This is still expected to fail because the partitionId for the cached material is different.
    // If the user does NOT specify the partitionId, it is set to a random UUID
    var badAttrsNowCached := badBv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect badAttrsNowCached.Failure?;
  }

  method {:test} TestSharedCacheBeaconsMultiKeyStoreWithSamePartitionId()
  {
    var partitionId : string := "partitionId";
    var sharedCache : MPT.CacheType := GetSharedCache();
    var primitives :- expect Primitives.AtomicPrimitives();

    // Verification by adding assume statements in "by" passes, but there's an error while transpiling code to runtimes
    // Dafny is working on a fix. Update this test when Dafny releases `4.9.2`.
    // Using `assume{:axiom} false;` for this test for now.
    // var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives) by {
    //   assume {:axiom} C.ValidSharedCache(version.keySource);
    // }
    // var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    // var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId) by {
    //   assume{:axiom} false;
    // }
    assume{:axiom} false;

    // This call is expected to fail because we are providing a Bad KeyStore which does NOT exist
    var badVersion := GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(cache := sharedCache, partitionId := Some(partitionId));
    var badSrc :- expect C.MakeKeySource(FullTableConfig, badVersion.keyStore, badVersion.keySource, primitives);
    var badBv :- expect C.ConvertVersionWithSource(FullTableConfig, badVersion, badSrc);
    var badAttrs := badBv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));
    expect badAttrs.Failure?;

    // This is expected to pass because we pass a valid KeyStore
    var version := GetLotsaBeaconsMultiWithSharedCache(cache := sharedCache, partitionId := Some(partitionId));
    var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));

    // This is expected to pass now because the cache already has cached material for this Branch Key ID.
    // This is a hack to test that the correct material is cached.
    var badAttrsNowCached :- expect badBv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));
  }


  method {:test} TestSharedCacheBeaconsMultiKeyStoreWithDifferentPartitionId()
  {
    var sharedCache : MPT.CacheType := GetSharedCache();
    var primitives :- expect Primitives.AtomicPrimitives();

    // Verification by adding assume statements in "by" passes, but there's an error while transpiling code to runtimes
    // Dafny is working on a fix. Update this test when Dafny releases `4.9.2`.
    // Using `assume{:axiom} false;` for this test for now.
    // var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives) by {
    //   assume {:axiom} C.ValidSharedCache(version.keySource);
    // }
    // var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    // var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId) by {
    //   assume{:axiom} false;
    // }
    assume{:axiom} false;

    // This call is expected to fail because we are providing a Bad KeyStore which does NOT exist
    var partitionIdBadVersion : string := "partitionIdBadVersion";
    var badVersion := GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(cache := sharedCache, partitionId := Some(partitionIdBadVersion));
    var badSrc :- expect C.MakeKeySource(FullTableConfig, badVersion.keyStore, badVersion.keySource, primitives);
    var badBv :- expect C.ConvertVersionWithSource(FullTableConfig, badVersion, badSrc);
    // This KeyId is a valid branch_key_id present in the KeyStoreDdbTable.
    // Providing a valid branch_key_id is important in this method because unlike other tests in Beacon.dfy,
    // this is used in a test which actually fetches data from DynamoDb without using a Literal KeySource.
    var badAttrs := badBv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));
    expect badAttrs.Failure?;

    // This is expected to pass because we pass a valid KeyStore
    var partitionIdGoodVersion : string := "partitionIdGoodVersion";
    var version := GetLotsaBeaconsMultiWithSharedCache(cache := sharedCache, partitionId := Some(partitionIdGoodVersion));
    var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));

    // This is still expected to fail because the partitionId for the cached material is different.
    var badAttrsNowCached := badBv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));
    expect badAttrsNowCached.Failure?;
  }

  method {:test} TestSharedCacheBeaconsMultiKeyStoreWithUnspecifiedPartitionId()
  {
    var sharedCache : MPT.CacheType := GetSharedCache();
    var primitives :- expect Primitives.AtomicPrimitives();

    // Verification by adding assume statements in "by" passes, but there's an error while transpiling code to runtimes
    // Dafny is working on a fix. Update this test when Dafny releases `4.9.2`.
    // Using `assume{:axiom} false;` for this test for now.
    // var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives) by {
    //   assume {:axiom} C.ValidSharedCache(version.keySource);
    // }
    // var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    // var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId) by {
    //   assume{:axiom} false;
    // }
    assume{:axiom} false;

    // This call is expected to fail because we are providing a Bad KeyStore which does NOT exist
    var badVersion := GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(cache := sharedCache, partitionId := None);
    var badSrc :- expect C.MakeKeySource(FullTableConfig, badVersion.keyStore, badVersion.keySource, primitives);
    var badBv :- expect C.ConvertVersionWithSource(FullTableConfig, badVersion, badSrc);
    // This KeyId is a valid branch_key_id present in the KeyStoreDdbTable.
    // Providing a valid branch_key_id is important in this method because unlike other tests in Beacon.dfy,
    // this is used in a test which actually fetches data from DynamoDb without using a Literal KeySource.
    var badAttrs := badBv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));
    expect badAttrs.Failure?;

    // This is expected to pass because we pass a valid KeyStore
    var version := GetLotsaBeaconsMultiWithSharedCache(cache := sharedCache, partitionId := None);
    var src :- expect C.MakeKeySource(FullTableConfig, version.keyStore, version.keySource, primitives);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));

    // This is still expected to fail because the partitionId for the cached material is different.
    // If the user does NOT specify the partitionId, it is set to a random UUID
    var badAttrsNowCached := badBv.GenerateEncryptedBeacons(SimpleItem, KeyId("040a32a8-3737-4f16-a3ba-bd4449556d73"));
    expect badAttrsNowCached.Failure?;
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

  method {:test} TestUnusedPartOnly()
  {
    var version := GetLotsaBeacons();
    var badBeacon := T.StandardBeacon(name := "badBeacon", length := 24, loc := None,
                                      style := Some(
                                        T.partOnly(T.PartOnly())
                                      ));
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["badBeacon" := SE.ENCRYPT_AND_SIGN]);
    version := version.(standardBeacons := version.standardBeacons + [badBeacon]);
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(newConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("PartOnly beacon badBeacon MUST be used in a compound beacon.");
  }

  method {:test} TestCompoundWithUnknown()
  {
    var Unknown := T.EncryptedPart(name := "Unknown", prefix := "U_");

    var NameUnknown := T.CompoundBeacon (
      name := "NameUnknown",
      split := ".",
      encrypted := Some([Name,Unknown]),
      signed := None,
      constructors := None
    );
    var version := GetLotsaBeacons();
    expect version.compoundBeacons.Some?;
    version := version.(compoundBeacons := Some(version.compoundBeacons.value + [NameUnknown]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Compound beacon NameUnknown refers to standard beacon Unknown which is not configured.");
  }

  method {:test} TesSetInCompound()
  {
    var version := GetLotsaBeacons();
    var setBeacon := T.StandardBeacon(name := "setBeacon", length := 24, loc := None,
                                      style := Some(
                                        T.asSet(T.AsSet())
                                      ));
    var compoundSet := T.CompoundBeacon (
      name := "compoundSet",
      split := ".",
      encrypted := Some([Name,T.EncryptedPart(name := "setBeacon", prefix := "S_")]),
      signed := None,
      constructors := None
    );

    expect version.compoundBeacons.Some?;
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["setBeacon" := SE.ENCRYPT_AND_SIGN]);
    version := version.(standardBeacons := version.standardBeacons + [setBeacon],
    compoundBeacons := Some(version.compoundBeacons.value + [compoundSet]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(newConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Compound beacon compoundSet uses setBeacon which is an AsSet beacon, and therefore cannot be used in a Compound Beacon.");
  }

  method {:test} SharedBadReferenceToCompound()
  {
    var version := GetLotsaBeacons();
    var shareBeacon := T.StandardBeacon(name := "shareBeacon", length := 24, loc := None,
                                        style := Some(
                                          T.shared(T.Shared(other := "NameTitle"))
                                        ));

    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["shareBeacon" := SE.ENCRYPT_AND_SIGN]);
    version := version.(standardBeacons := version.standardBeacons + [shareBeacon]);
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(newConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Beacon shareBeacon is shared to NameTitle but NameTitle is a compound beacon.");
  }

  method {:test} ChainedShare()
  {
    var version := GetLotsaBeacons();
    var shareBeacon := T.StandardBeacon(name := "shareBeacon", length := 24, loc := None,
                                        style := Some(
                                          T.shared(T.Shared(other := "std2"))
                                        ));
    var other := T.StandardBeacon(name := "std4", length := 24, loc := None,
                                  style := Some(
                                    T.shared(T.Shared(other := "shareBeacon"))
                                  ));

    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["shareBeacon" := SE.ENCRYPT_AND_SIGN]);
    version := version.(compoundBeacons := None, standardBeacons :=  [std2, shareBeacon, other]);
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(newConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Beacon std4 is shared to shareBeacon which is in turn shared to std2. Share chains are not allowed.");
  }

  method {:test} SelfShare()
  {
    var version := GetLotsaBeacons();
    var shareBeacon := T.StandardBeacon(name := "shareBeacon", length := 24, loc := None,
                                        style := Some(
                                          T.shared(T.Shared(other := "shareBeacon"))
                                        ));

    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["shareBeacon" := SE.ENCRYPT_AND_SIGN]);
    version := version.(compoundBeacons := None, standardBeacons :=  [std2, shareBeacon]);
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(newConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Beacon shareBeacon is shared to itself.");
  }

  method {:test} SharedBadReferenceNonExistent()
  {
    var version := GetLotsaBeacons();
    var shareBeacon := T.StandardBeacon(name := "shareBeacon", length := 24, loc := None,
                                        style := Some(
                                          T.shared(T.Shared(other := "DoesNotExist"))
                                        ));

    version := version.(standardBeacons := version.standardBeacons + [shareBeacon]);
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["shareBeacon" := SE.ENCRYPT_AND_SIGN]);
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(newConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Beacon shareBeacon is shared to DoesNotExist which is not defined.");
  }


  method {:test} SharedBadLength()
  {
    var version := GetLotsaBeacons();
    var shareBeacon := T.StandardBeacon(name := "shareBeacon", length := 23, loc := None,
                                        style := Some(
                                          T.shared(T.Shared(other := "std2"))
                                        ));

    version := version.(standardBeacons := version.standardBeacons + [shareBeacon]);
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["shareBeacon" := SE.ENCRYPT_AND_SIGN]);
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(newConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Beacon shareBeacon is shared to std2 but shareBeacon has length 23 and std2 has length 24.");
  }

  method {:test} TestPartOnlyNotStored()
  {
    var MyItem : DDB.AttributeMap := map[
      "std2" := DDB.AttributeValue.S("abc"),
      "partOnly" := DDB.AttributeValue.S("def")
    ];
    var compoundPart := T.CompoundBeacon (
      name := "compoundPart",
      split := ".",
      encrypted := Some([T.EncryptedPart(name := "partOnly", prefix := "S_")]),
      signed := None,
      constructors := None
    );
    var context := ExprContext (
      None,
      Some("partOnly = :val"),
      Some(map[":val" := DDB.AttributeValue.S("foo")]),
      None
    );

    var version := GetLotsaBeacons();
    expect version.compoundBeacons.Some?;
    var partBeacon := T.StandardBeacon(name := "partOnly", length := 23, loc := None, style := None);
    var newVersion := version.(
    standardBeacons := version.standardBeacons + [partBeacon],
    compoundBeacons := Some(version.compoundBeacons.value + [compoundPart])
    );
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["partOnly" := SE.ENCRYPT_AND_SIGN]);

    var src := GetLiteralSource([1,2,3,4,5], newVersion);
    var bv :- expect C.ConvertVersionWithSource(newConfig, newVersion, src);

    var goodAttrs :- expect bv.GenerateEncryptedBeacons(MyItem, DontUseKeyId);
    expect goodAttrs == map[
                          "aws_dbe_b_std2" := DDB.AttributeValue.S("51e1da"),
                          "aws_dbe_b_partOnly" := DDB.AttributeValue.S("405a51"),
                          "aws_dbe_b_compoundPart" := DDB.AttributeValue.S("S_405a51")
                        ];
    var goodQuery := Beaconize(bv, context, DontUseKeyId);
    expect goodQuery.Success?;


    partBeacon := T.StandardBeacon(name := "partOnly", length := 23, loc := None,
                                   style := Some(
                                     T.partOnly(T.PartOnly())
                                   ));
    newVersion := version.(
    standardBeacons := version.standardBeacons + [partBeacon],
    compoundBeacons := Some(version.compoundBeacons.value + [compoundPart])
    );
    bv :- expect C.ConvertVersionWithSource(newConfig, newVersion, src);
    goodAttrs :- expect bv.GenerateEncryptedBeacons(MyItem, DontUseKeyId);

    //= specification/searchable-encryption/beacons.md#partonly-initialization
    //= type=test
    //# The Standard Beacon MUST NOT be stored in the item for a PartOnly beacon.
    expect goodAttrs == map[
                          "aws_dbe_b_std2" := DDB.AttributeValue.S("51e1da"),
                          "aws_dbe_b_compoundPart" := DDB.AttributeValue.S("S_405a51")
                        ];

    //= specification/searchable-encryption/beacons.md#partonly-initialization
    //= type=test
    //# A query MUST fail if it tries to search on a PartOnly beacon directly.
    var badQuery := Beaconize(bv, context, DontUseKeyId);
    expect badQuery.Failure?;
    expect badQuery.error == E("Field partOnly is encrypted, and has a PartOnly beacon, and so can only be used as part of a compound beacon.");
  }

  method {:test} TestShareSameBeacon()
  {
    var MyItem : DDB.AttributeMap := map[
      "std2" := DDB.AttributeValue.S("abc"),
      "partOnly" := DDB.AttributeValue.S("abc")
    ];

    var version := GetLotsaBeacons();
    expect version.compoundBeacons.Some?;
    var partBeacon := T.StandardBeacon(name := "partOnly", length := 24, loc := None, style := None);
    var newVersion := version.(
    standardBeacons := version.standardBeacons + [partBeacon]
    );
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["partOnly" := SE.ENCRYPT_AND_SIGN]);

    var src := GetLiteralSource([1,2,3,4,5], newVersion);
    var bv :- expect C.ConvertVersionWithSource(newConfig, newVersion, src);

    var goodAttrs :- expect bv.GenerateEncryptedBeacons(MyItem, DontUseKeyId);
    expect goodAttrs == map[
                          "aws_dbe_b_std2" := DDB.AttributeValue.S("51e1da"),
                          "aws_dbe_b_partOnly" := DDB.AttributeValue.S("928d9b")
                        ];


    partBeacon := T.StandardBeacon(name := "partOnly", length := 24, loc := None,
                                   style := Some(
                                     T.shared(T.Shared(other := "std2"))
                                   ));
    newVersion := version.(
    standardBeacons := version.standardBeacons + [partBeacon]
    );
    bv :- expect C.ConvertVersionWithSource(newConfig, newVersion, src);
    goodAttrs :- expect bv.GenerateEncryptedBeacons(MyItem, DontUseKeyId);

    //= specification/searchable-encryption/beacons.md#shared-initialization
    //= type=test
    //# This beacon MUST calculate its [value](#beacon-value) as if it were the `other` beacon.
    expect goodAttrs == map[
                          "aws_dbe_b_std2" := DDB.AttributeValue.S("51e1da"),
                          "aws_dbe_b_partOnly" := DDB.AttributeValue.S("51e1da")
                        ];

    // also check matching beacon value in query
    var context := ExprContext (
      None,
      Some("partOnly = :pVal AND std2 = :sVal"),
      Some(map[":pVal" := DDB.AttributeValue.S("foo"), ":sVal" := DDB.AttributeValue.S("foo")]),
      None
    );
    var goodQuery :- expect Beaconize(bv, context, DontUseKeyId);
    expect goodQuery.values == Some(map[":pVal" := DDB.AttributeValue.S("4379a7"), ":sVal" := DDB.AttributeValue.S("4379a7")]);
  }

  method {:test} TestBeaconSetQuery()
  {
    var context := ExprContext (
      None,
      Some("setAttr = :setVal"),
      Some(map[":setVal" := DDB.AttributeValue.SS(["abc", "def", "ghi"])]),
      None
    );
    var setBeacon := T.StandardBeacon(name := "setAttr", length := 24, loc := None,
                                      style := Some(
                                        T.asSet(T.AsSet())
                                      ));

    var version := GetLotsaBeacons();
    var newVersion := version.(
    standardBeacons := version.standardBeacons + [setBeacon]
    );
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["setAttr" := SE.ENCRYPT_AND_SIGN]);

    var src := GetLiteralSource([1,2,3,4,5], newVersion);
    var bv :- expect C.ConvertVersionWithSource(newConfig, newVersion, src);

    // also check matching beacon value in query
    var goodQuery :- expect Beaconize(bv, context, DontUseKeyId);
    expect goodQuery.values == Some(map[":setVal" := DDB.AttributeValue.SS(["43c4d8", "2f3278", "f1972e"])]);

    context := ExprContext (
      None,
      Some("setAttr = :setVal"),
      Some(map[":setVal" := DDB.AttributeValue.S("abc")]),
      None
    );
    goodQuery :- expect Beaconize(bv, context, DontUseKeyId);

    context := ExprContext (
      None,
      Some("setAttr = :setVal"),
      Some(map[":setVal" := DDB.AttributeValue.L([])]),
      None
    );
    var badQuery := Beaconize(bv, context, DontUseKeyId);
    expect badQuery.Failure?;
    expect badQuery.error == E("Beacon setAttr has style AsSet, but attribute has type L.");
  }

  method {:test} TestSetNotSet()
  {
    var MyItem : DDB.AttributeMap := map[
      "std2" := DDB.AttributeValue.S("abc"),
      "partOnly" := DDB.AttributeValue.SS(["abc", "def", "ghi"])
    ];

    var version := GetLotsaBeacons();
    expect version.compoundBeacons.Some?;
    var partBeacon := T.StandardBeacon(name := "partOnly", length := 24, loc := None,
                                       style := Some(
                                         T.asSet(T.AsSet())
                                       ));
    var newVersion := version.(
    standardBeacons := version.standardBeacons + [partBeacon]
    );
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["partOnly" := SE.ENCRYPT_AND_SIGN]);

    var src := GetLiteralSource([1,2,3,4,5], newVersion);
    var bv :- expect C.ConvertVersionWithSource(newConfig, newVersion, src);
    expect "partOnly" in bv.beacons;
    expect bv.beacons["partOnly"].Standard?;
    var goodAttrs := bv.GenerateEncryptedBeacons(MyItem, DontUseKeyId);
    if goodAttrs.Failure? {
      print "\n", goodAttrs.error, "\n";
    }
    //= specification/searchable-encryption/beacons.md#asset-initialization
    //= type=test
    //# * The Standard Beacon MUST be stored in the item as a Set,
    //# comprised of the [beacon values](#beacon-value) of all the elements in the original Set.
    expect goodAttrs.Success?;
    expect goodAttrs.value == map[
                                "aws_dbe_b_std2" := DDB.AttributeValue.S("51e1da"),
                                "aws_dbe_b_partOnly" := DDB.AttributeValue.SS(["928d9b", "405a51", "9c6c2e"])
                              ];

    //= specification/searchable-encryption/beacons.md#asset-initialization
    //= type=test
    //# * Writing an item MUST fail if the item contains this beacon's attribute,
    //# and that attribute is not of type Set.
    var BadItem := MyItem["partOnly" := DDB.AttributeValue.S("abc")];
    var badAttrs := bv.GenerateEncryptedBeacons(BadItem, DontUseKeyId);
    expect badAttrs.Failure?;
    expect badAttrs.error == E("Beacon partOnly has style AsSet, but attribute has type S.");
  }

  method {:test} TestSharedSet()
  {
    var MyItem : DDB.AttributeMap := map[
      "std2" := DDB.AttributeValue.S("abc"),
      "partOnly" := DDB.AttributeValue.SS(["abc", "def", "ghi"])
    ];

    var version := GetLotsaBeacons();
    expect version.compoundBeacons.Some?;
    var partBeacon := T.StandardBeacon(name := "partOnly", length := 24, loc := None,
                                       style := Some(
                                         T.sharedSet(T.SharedSet(other := "std2"))
                                       ));
    var newVersion := version.(
    standardBeacons := version.standardBeacons + [partBeacon]
    );
    var newConfig := FullTableConfig.(attributeActionsOnEncrypt := FullTableConfig.attributeActionsOnEncrypt["partOnly" := SE.ENCRYPT_AND_SIGN]);

    var src := GetLiteralSource([1,2,3,4,5], newVersion);
    var bv :- expect C.ConvertVersionWithSource(newConfig, newVersion, src);
    expect "partOnly" in bv.beacons;
    expect bv.beacons["partOnly"].Standard?;
    var goodAttrs := bv.GenerateEncryptedBeacons(MyItem, DontUseKeyId);
    if goodAttrs.Failure? {
      print "\n", goodAttrs.error, "\n";
    }

    //= specification/searchable-encryption/beacons.md#sharedset-initialization
    //= type=test
    //# A SharedSet Beacon MUST behave both as [Shared](#shared-initialization) and [AsSet](#asset-initialization).
    expect goodAttrs.Success?;
    expect goodAttrs.value == map[
                                "aws_dbe_b_std2" := DDB.AttributeValue.S("51e1da"),
                                "aws_dbe_b_partOnly" := DDB.AttributeValue.SS(["51e1da", "39ef85", "3ff06a"])
                              ];
  }

  method {:test} GlobalPartNotExist()
  {
    var version := GetLotsaBeacons();
    var NotExist := T.EncryptedPart(name := "NotExist", prefix := "Q_");

    version := version.(encryptedParts := Some([NotExist]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Global Parts List refers to standard beacon NotExist which is not configured.");
  }

  method {:test} DuplicateGlobalSigned()
  {
    var version := GetLotsaBeacons();
    version := version.(compoundBeacons := None, signedParts := Some([Year, Month, Year]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Duplicate part name Year in Global Parts List.");
  }

  method {:test} DuplicateGlobalEncrypted()
  {
    var version := GetLotsaBeacons();
    version := version.(compoundBeacons := None, encryptedParts := Some([Name, Title, Name]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Duplicate part name Name in Global Parts List.");
  }

  method {:test} DuplicateGlobalPrefix()
  {
    var version := GetLotsaBeacons();
    var Std6 := T.EncryptedPart(name := "std6", prefix := "N_");
    version := version.(compoundBeacons := None, encryptedParts := Some([Name, Title, Std6]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Duplicate prefix N_ in Global Parts List.");
  }

  method {:test} DuplicateGlobalVsLocalEncrypted()
  {
    var version := GetLotsaBeacons();
    version := version.(encryptedParts := Some([Name]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Compound beacon NameTitle defines encrypted part Name which is already defined as a global part.");
  }

  method {:test} DuplicateGlobalVsLocalSigned()
  {
    var version := GetLotsaBeacons();
    version := version.(signedParts := Some([Month]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Compound beacon Mixed defines signed part Month which is already defined as a global part.");
  }

  method {:test} CompoundNoConstructor()
  {
    var compoundDefault := T.CompoundBeacon (
      name := "compoundDefault",
      split := ".",
      encrypted := None,
      signed := None,
      constructors := None
    );

    var version := GetLotsaBeacons();
    version := version.(compoundBeacons := Some([compoundDefault]), signedParts := Some([Month]), encryptedParts := Some([Name, Title]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv := C.ConvertVersionWithSource(FullTableConfig, version, src);
    expect bv.Failure?;
    expect bv.error == E("Compound beacon compoundDefault defines no constructors, and also no local parts. Cannot make a default constructor from global parts.");
  }

  method {:test} CompoundMixed()
  {
    var Mixed := T.CompoundBeacon (
      name := "Mixed",
      split := ".",
      encrypted := Some([Title]),
      signed := Some([Month]),
      constructors := Some([
                             T.Constructor(parts := [T.ConstructorPart(name := "Name", required := true), T.ConstructorPart(name := "Year", required := true)]),
                             T.Constructor(parts := [T.ConstructorPart(name := "Title", required := true), T.ConstructorPart(name := "Month", required := false)])
                           ])
    );

    var version := GetLotsaBeacons();
    version := version.(compoundBeacons := Some([Mixed]), signedParts := Some([Year]), encryptedParts := Some([Name]));
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
  }

  method {:test} CheckBytesToHex()
  {
    var bytes := [1,2,3,4,5,6,7,0xb7];
    // These could be asserted instead,
    // but they get too expensive
    // on more recent versions of Dafny.
    expect BytesToHex(bytes, 1) == "1";
    expect BytesToHex(bytes, 2) == "3";
    expect BytesToHex(bytes, 3) == "7";
    expect BytesToHex(bytes, 4) == "7";
    expect BytesToHex(bytes, 5) == "17";
    expect BytesToHex(bytes, 6) == "37";
    expect BytesToHex(bytes, 7) == "37";
    expect BytesToHex(bytes, 8) == "b7";
  }
}
