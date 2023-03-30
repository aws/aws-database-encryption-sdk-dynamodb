// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../DynamoDbEncryptionTransforms/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/Model/AwsCryptographyMaterialProvidersTypes.dfy"

module TestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyDynamoDbEncryptionTransformsTypes
  import opened AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import DynamoDbEncryptionTransforms
  import DynamoDbItemEncryptor
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import CSE = AwsCryptographyStructuredEncryptionTypes
  
  const PUBLIC_US_WEST_2_KMS_TEST_KEY := "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

  function method GetAttributeActions() : AttributeActions {
    map["bar" := CSE.SIGN_ONLY, "encrypt" := CSE.ENCRYPT_AND_SIGN, "sign" := CSE.SIGN_ONLY, "nothing" := CSE.DO_NOTHING]
  }

  method GetEncryptorConfig() returns (output : DynamoDbItemEncryptorConfig) {
    var keyring := GetKmsKeyring();
    output := DynamoDbItemEncryptorConfig(
      tableName := "foo",
      partitionKeyName := "bar",
      sortKeyName := None(),
      attributeActions := GetAttributeActions(),
      allowedUnauthenticatedAttributes := Some(["nothing"]),
      allowedUnauthenticatedAttributePrefix := None(),
      keyring := Some(keyring),
      cmm := None(),
      algorithmSuiteId := None(),
      legacyConfig := None()
    );
  }

  method GetDynamoDbItemEncryptorFrom(config : DynamoDbItemEncryptorConfig)
    returns (encryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var keyring := GetKmsKeyring();
    var encryptorConfig := DynamoDbItemEncryptorConfig(
      tableName := config.tableName,
      partitionKeyName := config.partitionKeyName,
      sortKeyName := config.sortKeyName,
      attributeActions := config.attributeActions,
      allowedUnauthenticatedAttributes := config.allowedUnauthenticatedAttributes,
      allowedUnauthenticatedAttributePrefix := config.allowedUnauthenticatedAttributePrefix,
      keyring := Some(keyring),
      cmm := None(),
      algorithmSuiteId := None(),
      legacyConfig := None()
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


  method expect_ok<X>(tag : string, actual : Result<X, AwsCryptographyDynamoDbEncryptionTransformsTypes.Error>)
    ensures actual.Success?
  {
    if actual.Failure? {
      print tag, "\t", actual;
    }
    expect actual.Success?;
  }
  method expect_equal<X(==)>(tag : string, actual : X, expected : X)
  {
    if actual != expected {
      print tag, "\texpected\n", expected, "\ngot\n", actual, "\n";
    }
    expect actual == expected;
  }

  method ExpectFailure<X>(ret : Result<X, AwsCryptographyDynamoDbEncryptionTransformsTypes.Error>, s : string)
  {
    if !ret.Failure? {
      print "Got Success when expected failure ", s, "\n";
    }
    expect ret.Failure?;
    if !ret.error.DynamoDbEncryptionTransformsException? {
      print "Error type not DynamoDbEncryptionTransformsException : ", ret, "\n";
    }
    expect ret.error.DynamoDbEncryptionTransformsException?;
    if ret.error.message != s {
      print "Expected error message '", s, "' got message '", ret.error.message, "'\n";
    }
    expect ret.error.message == s;
  }

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

  method GetDynamoDbEncryptionTransforms()
      returns (encryption: DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)
    ensures encryption.ValidState()
    ensures fresh(encryption)
    ensures fresh(encryption.Modifies)
  {
    var keyring := GetKmsKeyring();
    encryption :- expect DynamoDbEncryptionTransforms.DynamoDbEncryptionTransforms(
      DynamoDbTablesEncryptionConfig(
        tableEncryptionConfigs := map[
          "foo" := DynamoDbTableEncryptionConfig(
            partitionKeyName := "bar",
            sortKeyName := None(),
            attributeActions := map[
              "bar" := CSE.SIGN_ONLY,
              "sign" := CSE.SIGN_ONLY,
              "encrypt" := CSE.ENCRYPT_AND_SIGN,
              "plain" := CSE.DO_NOTHING
              ],
            allowedUnauthenticatedAttributes := Some(["plain"]),
            allowedUnauthenticatedAttributePrefix := None(),
            algorithmSuiteId := None(),
            keyring := Some(keyring),
            cmm := None(),
            search := None
          )
        ]
      )
    );
  }
}
