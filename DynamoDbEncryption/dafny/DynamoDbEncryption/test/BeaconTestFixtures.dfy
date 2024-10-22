// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/Index.dfy"

module BeaconTestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened DynamoDbEncryptionUtil
  import DDB = ComAmazonawsDynamodbTypes
  import SE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import KeyStore
  import Seq
  import KMS = Com.Amazonaws.Kms
  import DDBC = Com.Amazonaws.Dynamodb
  import KTypes = AwsCryptographyKeyStoreTypes
  import SI = SearchableEncryptionInfo
  import Primitives = AtomicPrimitives
  import MaterialProviders
  import MPT = AwsCryptographyMaterialProvidersTypes
  import SortedSets

  method expect_equal<T(==)>(a: T, b: T)
    ensures a == b
  {
    if a != b {
      print "Not equal: ", a, ", ", b, "\n";
    }
    expect a == b;
  }

  const std2 := StandardBeacon(name := "std2", length := 24, loc := None, style := None)
  const std4 := StandardBeacon(name := "std4", length := 24, loc := Some("std4"), style := None)
  const std6 := StandardBeacon(name := "std6", length := 26, loc := Some("std6[0]"), style := None)
  const NameB := StandardBeacon(name := "Name", length := 32, loc := None, style := None)
  const TitleB := StandardBeacon(name := "Title", length := 32, loc := None, style := None)
  const TooBadB := StandardBeacon(name := "TooBad", length := 32, loc := None, style := None)

  const Year := SignedPart(name := "Year", prefix := "Y_", loc := None)
  const Month := SignedPart(name := "Month", prefix := "M_", loc := Some("Date.Month"))
  const Nothing := SignedPart(name := "Nothing", prefix := "N__", loc := None)

  const Name := EncryptedPart(name := "Name", prefix := "N_")
  const Title := EncryptedPart(name := "Title", prefix := "T_")
  const TooBad := EncryptedPart(name := "TooBad", prefix := "T")

  const NameTitle := CompoundBeacon (
                       name := "NameTitle",
                       split := ".",
                       encrypted := Some([Name,Title]),
                       signed := None,
                       constructors := None
                     )
  const YearName := CompoundBeacon (
                      name := "YearName",
                      split := ".",
                      encrypted := Some([Name]),
                      signed := Some([Year]),
                      constructors := None
                    )
  const BadPrefix := CompoundBeacon (
                       name := "BadPrefix",
                       split := ".",
                       encrypted := Some([Name,Title,TooBad]),
                       signed := None,
                       constructors := None
                     )
  const BadPrefix2 := CompoundBeacon (
                        name := "BadPrefix2",
                        split := ".",
                        encrypted := Some([Name]),
                        signed := Some([Nothing]),
                        constructors := None
                      )
  const JustSigned := CompoundBeacon (
                        name := "JustSigned",
                        split := ".",
                        encrypted := None,
                        signed := Some([Year,Month]),
                        constructors := None
                      )
  const Mixed := CompoundBeacon (
                   name := "Mixed",
                   split := ".",
                   encrypted := Some([Name,Title]),
                   signed := Some([Year,Month]),
                   constructors := Some([
                                          Constructor(parts := [ConstructorPart(name := "Name", required := true), ConstructorPart(name := "Year", required := true)]),
                                          Constructor(parts := [ConstructorPart(name := "Title", required := true), ConstructorPart(name := "Month", required := false)])
                                        ])
                 )

  const std2_beacon := "ac6f5d"
  const Name_beacon := "7d9bfa40"
  const Title_beacon := "e4feb833"
  const std4_beacon := "0e9064"
  const std6_beacon := "2d99222"
  const NameTitle_beacon := "4c577d7"
  const EmptyName_beacon := "e0e88994"
  const EmptyTitle_beacon := "af34f26f"

  const Std2String := DDB.AttributeValue.N("1.23")
  const Std4String := DDB.AttributeValue.S("abc")
  const Std6String := DDB.AttributeValue.S("666")
  const Std6List := DDB.AttributeValue.L([Std6String])

  const YearString := DDB.AttributeValue.N("1984")
  const MonthString := DDB.AttributeValue.S("May")
  const DateMap := DDB.AttributeValue.M(map["Month" := MonthString, "Year" := YearString])

  const NameString := DDB.AttributeValue.S("MyName")
  const TitleString := DDB.AttributeValue.S("MyTitle")

  const VPart1 := VirtualPart(loc := "Name", trans := Some([insert(Insert(literal := "__"))]))
  const VPart2 := VirtualPart(loc := "Title", trans := Some([lower(Lower)]))
  const NameTitleField := VirtualField(name := "NameTitleField", parts := [VPart1, VPart2])
  const NameTitleBeacon := StandardBeacon(name := "NameTitleField", length := 28, loc := None, style := None)
  const NameVirtField := VirtualField(name := "NameVirtField", parts := [VPart1])

  method GetKeyStore() returns (output : SI.ValidStore)
    ensures fresh(output.Modifies)
  {
    var kmsClient :- expect KMS.KMSClient();
    var ddbClient :- expect DDBC.DynamoDBClient();
    var kmsConfig := KTypes.KMSConfiguration.kmsKeyArn(
      "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126"
    );
    var keyStoreConfig := KTypes.KeyStoreConfig(
      id := None,
      kmsConfiguration := kmsConfig,
      logicalKeyStoreName := "KeyStoreDdbTable",
      grantTokens := None,
      ddbTableName := "KeyStoreDdbTable",
      ddbClient := Some(ddbClient),
      kmsClient := Some(kmsClient)
    );

    var store :- expect KeyStore.KeyStore(keyStoreConfig);
    return store;
  }

  method GetEmptyBeacons() returns (output : BeaconVersion)
    ensures output.keyStore.ValidState()
    ensures fresh(output.keyStore.Modifies)
    ensures output.version == 1
  {
    var store := GetKeyStore();
    return BeaconVersion (
        version := 1,
        keyStore := store,
        keySource := single(SingleKeyStore(keyId := "foo", cacheTTL := 42)),
        standardBeacons := [std2],
        compoundBeacons := None,
        virtualFields := None,
        encryptedParts := None,
        signedParts := None
      );
  }

  method GetLotsaBeacons() returns (output : BeaconVersion)
    ensures output.keyStore.ValidState()
    ensures fresh(output.keyStore.Modifies)
    ensures output.version == 1
  {
    var store := GetKeyStore();
    return BeaconVersion (
        version := 1,
        keyStore := store,
        keySource := single(SingleKeyStore(keyId := "foo", cacheTTL := 42)),
        standardBeacons := [std2, std4, std6, NameTitleBeacon, NameB, TitleB],
        compoundBeacons := Some([NameTitle, YearName, Mixed, JustSigned]),
        virtualFields := Some([NameTitleField]),
        encryptedParts := None,
        signedParts := None
      );
  }

  method GetLotsaBeaconsMulti() returns (output : BeaconVersion)
    ensures output.keyStore.ValidState()
    ensures fresh(output.keyStore.Modifies)
    ensures output.version == 1
  {
    var store := GetKeyStore();
    return BeaconVersion (
        version := 1,
        keyStore := store,
        keySource := multi(MultiKeyStore(keyFieldName := "TheKeyField", cacheTTL := 42)),
        standardBeacons := [std2, std4, std6, NameTitleBeacon, NameB, TitleB],
        compoundBeacons := Some([NameTitle, YearName, Mixed, JustSigned]),
        virtualFields := Some([NameTitleField]),
        encryptedParts := None,
        signedParts := None
      );
  }

  const EmptyTableConfig := DynamoDbTableEncryptionConfig (
                              logicalTableName := "Foo",
                              partitionKeyName := "foo",
                              sortKeyName := None,
                              search := None,
                              attributeActionsOnEncrypt := map[],
                              allowedUnsignedAttributes := None,
                              allowedUnsignedAttributePrefix := None,
                              algorithmSuiteId := None,
                              keyring := None,
                              cmm := None,
                              legacyOverride := None,
                              plaintextOverride := None
                            )
  const FullTableConfig := EmptyTableConfig.(
                           attributeActionsOnEncrypt := map[
                             "std2" := SE.ENCRYPT_AND_SIGN,
                             "std4" := SE.ENCRYPT_AND_SIGN,
                             "std6" := SE.ENCRYPT_AND_SIGN,
                             "Name" := SE.ENCRYPT_AND_SIGN,
                             "Title" := SE.ENCRYPT_AND_SIGN,
                             "TooBad" := SE.ENCRYPT_AND_SIGN,
                             "Year" := SE.SIGN_ONLY,
                             "Date" := SE.SIGN_ONLY,
                             "TheKeyField" := SE.SIGN_ONLY
                           ]
                           )

  method GetLiteralSource(key: Bytes, version : BeaconVersion) returns (output : SI.KeySource)
    requires version.keyStore.ValidState()
    ensures output.ValidState()
    ensures version.keyStore == output.store
    ensures fresh(output.client.Modifies)
  {
    var client :- expect Primitives.AtomicPrimitives();

    var keyNameSet := set b <- version.standardBeacons :: b.name;
    var keyNames := SortedSets.ComputeSetToOrderedSequence2(keyNameSet, CharLess);
    var keys :- expect SI.GetHmacKeys(client, keyNames, keyNames, key);
    var mpl :- expect MaterialProviders.MaterialProviders();
    var input := MPT.CreateCryptographicMaterialsCacheInput(
      cache := MPT.Default(Default := MPT.DefaultCache(entryCapacity := 3))
    );
    var cache :- expect mpl.CreateCryptographicMaterialsCache(input);
    return SI.KeySource(client, version.keyStore, SI.LiteralLoc(keys), cache, 0);
  }

  method GetMultiSource(keyName : string, version : BeaconVersion) returns (output : SI.KeySource)
    requires version.keyStore.ValidState()
    ensures output.ValidState()
    ensures version.keyStore == output.store
    ensures fresh(output.client.Modifies)
  {
    var client :- expect Primitives.AtomicPrimitives();
    var mpl :- expect MaterialProviders.MaterialProviders();
    var input := MPT.CreateCryptographicMaterialsCacheInput(
      cache := MPT.Default(Default := MPT.DefaultCache(entryCapacity := 3))
    );
    var cache :- expect mpl.CreateCryptographicMaterialsCache(input);
    return SI.KeySource(client, version.keyStore, SI.MultiLoc(keyName, false), cache, 0);
  }

  const SimpleItem : DDB.AttributeMap := map[
                                           "std2" := Std2String,
                                           "std4" := Std4String,
                                           "std6" := Std6List,
                                           "Date" := DateMap,
                                           "Year" := YearString,
                                           "Name" := NameString,
                                           "Title" := TitleString
                                         ]
}
