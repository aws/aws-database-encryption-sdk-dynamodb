// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDynamoDbItemEncryptorOperations.dfy"
include "../../StructuredEncryption/src/Index.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbItemEncryption" }
  DynamoDbItemEncryptor refines AbstractAwsCryptographyDynamoDbItemEncryptorService
{
  import StructuredEncryption
  import MaterialProviders
  import Operations = AwsCryptographyDynamoDbItemEncryptorOperations

  // TODO there is no sensible default, so what should this do?
  // As is, the default config is invalid. Can we update the codegen to *not*
  // build a default config?
  function method DefaultDynamoDbItemEncryptorConfig(): DynamoDbItemEncryptorConfig
  {
    DynamoDbItemEncryptorConfig(
      tableName := "foo",
      partitionKeyName := "bar",
      sortKeyName := None(),
      attributeActions := map[],
      allowedUnauthenticatedAttributes := None(),
      allowedUnauthenticatedAttributePrefix := None(),
      keyring := None(),
      cmm := None()
    )
  }

  method DynamoDbItemEncryptor(config: DynamoDbItemEncryptorConfig)
    returns (res: Result<DynamoDbItemEncryptorClient, Error>)
  {
    // TODO validation of config input

    // Create the structured encryption client
    var structuredEncryptionRes := StructuredEncryption.StructuredEncryption();
    var structuredEncryption :- structuredEncryptionRes
      .MapFailure(e => AwsCryptographyStructuredEncryption(e));

    // TODO Create CMM from input
    // For now just create some DefaultCMM
    var matProv :- expect MaterialProviders.MaterialProviders(MaterialProviders.DefaultMaterialProvidersConfig());
    var dummyKeyring :- expect matProv.CreateRawAesKeyring(AwsCryptographyMaterialProvidersTypes.CreateRawAesKeyringInput(
      keyNamespace := "foo",
      keyName := "bar",
      wrappingKey := seq(32, i => 0),
      wrappingAlg := AwsCryptographyMaterialProvidersTypes.ALG_AES256_GCM_IV12_TAG16
    ));
    var cmm :- expect matProv.CreateDefaultCryptographicMaterialsManager(
      AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput(
        keyring := dummyKeyring
      )
    );

    var client := new DynamoDbItemEncryptorClient(Operations.Config(
      tableName := config.tableName,
      partitionKeyName := config.partitionKeyName,
      sortKeyName := config.sortKeyName,
      attributeActions := config.attributeActions,
      allowedUnauthenticatedAttributes := config.allowedUnauthenticatedAttributes,
      allowedUnauthenticatedAttributePrefix := config.allowedUnauthenticatedAttributePrefix,
      cmm := cmm,
      structuredEncryption := structuredEncryption
    ));
    return Success(client);
  }

  class DynamoDbItemEncryptorClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IDynamoDbItemEncryptorClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }

}
