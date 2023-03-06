// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "../Model/AwsCryptographyDynamoDbEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/Model/AwsCryptographyMaterialProvidersTypes.dfy"

module TestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import DynamoDbEncryption
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import CSE = AwsCryptographyStructuredEncryptionTypes

  const PUBLIC_US_WEST_2_KMS_TEST_KEY := "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

  method expect_ok<X>(tag : string, actual : Result<X, AwsCryptographyDynamoDbEncryptionTypes.Error>)
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

  method ExpectFailure<X>(ret : Result<X, AwsCryptographyDynamoDbEncryptionTypes.Error>, s : string)
  {
    if !ret.Failure? {
      print "Got Success when expected failure ", s, "\n";
    }
    expect ret.Failure?;
    if !ret.error.DynamoDbEncryptionException? {
      print "Error type not DynamoDbEncryptionException : ", ret, "\n";
    }
    expect ret.error.DynamoDbEncryptionException?;
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

  method GetDynamoDbEncryption()
      returns (encryption: DynamoDbEncryption.DynamoDbEncryptionMiddlewareInternalClient)
    ensures encryption.ValidState()
    ensures fresh(encryption)
    ensures fresh(encryption.Modifies)
  {
    var keyring := GetKmsKeyring();
    encryption :- expect DynamoDbEncryption.DynamoDbEncryption(
      DynamoDbEncryptionConfig(
        tableEncryptionConfigs := map[
          "foo" := DynamoDbTableEncryptionConfig(
            partitionKeyName := "bar",
            sortKeyName := None(),
            attributeActions := map["bar" := CSE.SIGN_ONLY],
            allowedUnauthenticatedAttributes := None(),
            allowedUnauthenticatedAttributePrefix := None(),
            algorithmSuiteId := None(),
            keyring := Some(keyring),
            cmm := None()
          )
        ]
      )
    );
  }
}
