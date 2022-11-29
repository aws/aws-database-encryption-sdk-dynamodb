// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"

module TestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import Types = AwsCryptographyDynamoDbItemEncryptorTypes
  import DynamoDbItemEncryptor

  const EXPECTED_STUBBED_BLOB : seq<uint8> := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];

  method GetStaticKeyring()
      returns (keyring: AwsCryptographyMaterialProvidersTypes.IKeyring)
    ensures keyring.ValidState()
    ensures fresh(keyring)
    ensures fresh(keyring.Modifies)
  {
    var matProv :- expect MaterialProviders.MaterialProviders();
    keyring :- expect matProv.CreateRawAesKeyring(
      AwsCryptographyMaterialProvidersTypes.CreateRawAesKeyringInput(
        keyNamespace := "foo",
        keyName := "bar",
        wrappingKey := seq(32, i => 0),
        wrappingAlg := AwsCryptographyMaterialProvidersTypes.ALG_AES256_GCM_IV12_TAG16
      )
    );
  }

  method GetDynamoDbItemEncryptor()
      returns (encryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var keyring := GetStaticKeyring();
    var encryptorConfig := Types.DynamoDbItemEncryptorConfig(
      tableName := "foo",
      partitionKeyName := "bar",
      sortKeyName := None(),
      attributeActions := map[],
      allowedUnauthenticatedAttributes := None(),
      allowedUnauthenticatedAttributePrefix := None(),
      keyring := Some(keyring),
      cmm := None()
    );
    encryptor :- expect DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);
  }
}
