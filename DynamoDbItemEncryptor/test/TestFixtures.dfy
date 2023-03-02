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
  import CTypes = AwsCryptographyStructuredEncryptionTypes
  
  const PUBLIC_US_WEST_2_KMS_TEST_KEY := "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

  method GetKmsKeyring()
      returns (keyring: AwsCryptographyMaterialProvidersTypes.IKeyring)
    ensures keyring.ValidState()
    ensures fresh(keyring)
    ensures fresh(keyring.Modifies)
  {
    var matProv :- expect MaterialProviders.MaterialProviders(MaterialProviders.DefaultMaterialProvidersConfig());
    var keyringInput := AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput(
      generator := Some(PUBLIC_US_WEST_2_KMS_TEST_KEY),
      kmsKeyIds := None(),
      clientSupplier := None(),
      grantTokens := None()
    );
    keyring :- expect matProv.CreateAwsKmsMultiKeyring(keyringInput);
  }

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

  function method GetAttributeActions() : Types.AttributeActions {
    map["bar" := CTypes.SIGN_ONLY, "encrypt" := CTypes.ENCRYPT_AND_SIGN, "sign" := CTypes.SIGN_ONLY, "nothing" := CTypes.DO_NOTHING]
  }

  method GetEncryptorConfig() returns (output : Types.DynamoDbItemEncryptorConfig) {
    var keyring := GetKmsKeyring();
    output := Types.DynamoDbItemEncryptorConfig(
      tableName := "foo",
      partitionKeyName := "bar",
      sortKeyName := None(),
      attributeActions := GetAttributeActions(),
      allowedUnauthenticatedAttributes := Some(["nothing"]),
      allowedUnauthenticatedAttributePrefix := None(),
      keyring := Some(keyring),
      cmm := None(),
      algorithmSuiteId := None()
    );
  }

  method GetDynamoDbItemEncryptorFrom(config : Types.DynamoDbItemEncryptorConfig)
    returns (encryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var keyring := GetKmsKeyring();
    var encryptorConfig := Types.DynamoDbItemEncryptorConfig(
      tableName := config.tableName,
      partitionKeyName := config.partitionKeyName,
      sortKeyName := config.sortKeyName,
      attributeActions := config.attributeActions,
      allowedUnauthenticatedAttributes := config.allowedUnauthenticatedAttributes,
      allowedUnauthenticatedAttributePrefix := config.allowedUnauthenticatedAttributePrefix,
      keyring := Some(keyring),
      cmm := None(),
      algorithmSuiteId := None()
    );
    encryptor :- expect DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);
  }

  method GetDynamoDbItemEncryptor()
      returns (encryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var config := GetEncryptorConfig();
    encryptor := GetDynamoDbItemEncryptorFrom(config);
  }
}
