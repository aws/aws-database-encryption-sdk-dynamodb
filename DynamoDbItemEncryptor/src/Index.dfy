// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDynamoDbItemEncryptorOperations.dfy"
include "../../StructuredEncryption/src/Index.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbItemEncryptor" }
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
    ensures res.Success? ==>
      && res.value.config.tableName == config.tableName
      && res.value.config.partitionKeyName == config.partitionKeyName
      && res.value.config.sortKeyName == config.sortKeyName
      && res.value.config.attributeActions == config.attributeActions
      && res.value.config.allowedUnauthenticatedAttributes == config.allowedUnauthenticatedAttributes
      && res.value.config.allowedUnauthenticatedAttributePrefix == config.allowedUnauthenticatedAttributePrefix
    // TODO expected CMM/Keyring behavior
  {
    // TODO validation of config input

    // Create the structured encryption client
    var structuredEncryptionRes := StructuredEncryption.StructuredEncryption();
    var structuredEncryption :- structuredEncryptionRes
      .MapFailure(e => AwsCryptographyStructuredEncryption(e));

    // TODO For now just passthrough cmm or wrap keyring with DefaultCMM
    var maybeCmm := config.cmm;
    var cmm;
    if (maybeCmm.Some?) {
      cmm := maybeCmm.value;
    } else {
      // TODO for now assume valid input
      expect config.keyring.Some?;
      var keyring := config.keyring.value;
      var matProv :- expect MaterialProviders.MaterialProviders();
      cmm :- expect matProv.CreateDefaultCryptographicMaterialsManager(
        AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput(
          keyring := keyring
        )
      );
    }

    var internalConfig := Operations.Config(
      tableName := config.tableName,
      partitionKeyName := config.partitionKeyName,
      sortKeyName := config.sortKeyName,
      attributeActions := config.attributeActions,
      allowedUnauthenticatedAttributes := config.allowedUnauthenticatedAttributes,
      allowedUnauthenticatedAttributePrefix := config.allowedUnauthenticatedAttributePrefix,
      cmm := cmm,
      structuredEncryption := structuredEncryption
    );
    assert Operations.ValidInternalConfig?(internalConfig); // Dafny needs some extra help here

    var client := new DynamoDbItemEncryptorClient(internalConfig);
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
