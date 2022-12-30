// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "../Model/AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/Model/AwsCryptographyMaterialProvidersTypes.dfy"

module TestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes
  import DynamoDbEncryptionMiddlewareInternal
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import CSE = AwsCryptographyStructuredEncryptionTypes

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

  method GetDynamoDbEncryptionMiddlewareInternal()
      returns (encryption: DynamoDbEncryptionMiddlewareInternal.DynamoDbEncryptionMiddlewareInternalClient)
    ensures encryption.ValidState()
    ensures fresh(encryption)
    ensures fresh(encryption.Modifies)
  {
    var keyring := GetStaticKeyring();
    encryption :- expect DynamoDbEncryptionMiddlewareInternal.DynamoDbEncryptionMiddlewareInternal(
      DynamoDbEncryptionMiddlewareInternalConfig(
        tableEncryptionConfigs := map[
          "foo" := DynamoDbTableEncryptionConfig(
            partitionKeyName := "bar",
            sortKeyName := None(),
            attributeActions := map["bar" := CSE.SIGN_ONLY],
            allowedUnauthenticatedAttributes := None(),
            allowedUnauthenticatedAttributePrefix := None(),
            keyring := Some(keyring),
            cmm := None()
          )
        ]
      )
    );
  }
}
