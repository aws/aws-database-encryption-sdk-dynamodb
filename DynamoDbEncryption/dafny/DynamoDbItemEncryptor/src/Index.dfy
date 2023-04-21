// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDynamoDbEncryptionItemEncryptorOperations.dfy"
include "Util.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor" }
  DynamoDbItemEncryptor refines AbstractAwsCryptographyDynamoDbEncryptionItemEncryptorService
{
  import opened DynamoDbItemEncryptorUtil
  import StructuredEncryption
  import CSE = AwsCryptographyStructuredEncryptionTypes
  import DDBE = AwsCryptographyDynamoDbEncryptionTypes
  import MaterialProviders
  import Operations = AwsCryptographyDynamoDbEncryptionItemEncryptorOperations
  import SE =  StructuredEncryptionUtil
  import InternalLegacyConfig

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
      cmm := None(),
      algorithmSuiteId := None(),
      legacyConfig := None(),
      plaintextPolicy := None()
    )
  }

  // because an inline "!(ReservedPrefix <= attr)" is too hard for Dafny
  predicate method UnreservedPrefix(attr : string)
  {
    !(ReservedPrefix <= attr)
  }

  method {:vcs_split_on_every_assert} DynamoDbItemEncryptor(config: DynamoDbItemEncryptorConfig)
    returns (res: Result<DynamoDbItemEncryptorClient, Error>)
    ensures res.Success? ==>
      && res.value.config.tableName == config.tableName
      && res.value.config.partitionKeyName == config.partitionKeyName
      && res.value.config.sortKeyName == config.sortKeyName
      && res.value.config.attributeActions == config.attributeActions
      && res.value.config.allowedUnauthenticatedAttributes == config.allowedUnauthenticatedAttributes
      && res.value.config.allowedUnauthenticatedAttributePrefix == config.allowedUnauthenticatedAttributePrefix
      && res.value.config.algorithmSuiteId == config.algorithmSuiteId

      //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#attribute-actions
      //= type=implication
      //# The [SIGN_ONLY](../structured-encryption/structures.md#signonly) Crypto Action
      //# MUST be configured to the partition attribute and, if present, sort attribute.
      && config.partitionKeyName in config.attributeActions
      && config.attributeActions[config.partitionKeyName] == CSE.SIGN_ONLY
      && (config.sortKeyName.Some? ==>
          && config.sortKeyName.value in config.attributeActions
          && config.attributeActions[config.sortKeyName.value] == CSE.SIGN_ONLY)

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#plaintext-policy
    //# If not specified, encryption and decryption MUST behave according to `FORBID_WRITE_FORBID_READ`.
    ensures
        && res.Success?
        && config.plaintextPolicy.None?
      ==>
        res.value.config.plaintextPolicy.FORBID_WRITE_FORBID_READ?
  {
    :- Need(config.keyring.None? || config.cmm.None?, DynamoDbItemEncryptorException(
      message := "Cannot provide both a keyring and a CMM"
    ));
    :- Need(config.keyring.Some? || config.cmm.Some?, DynamoDbItemEncryptorException(
      message := "Must provide either a keyring or a CMM"
    ));
    :- Need(
        && config.partitionKeyName in config.attributeActions
        && config.attributeActions[config.partitionKeyName] == CSE.SIGN_ONLY,
      DynamoDbItemEncryptorException(
        message := "Partition key attribute action MUST be SIGN_ONLY"
      ));
    :- Need(
      (config.sortKeyName.Some? ==>
        && config.sortKeyName.value in config.attributeActions
        && config.attributeActions[config.sortKeyName.value] == CSE.SIGN_ONLY),
      DynamoDbItemEncryptorException(
        message := "Sort key attribute action MUST be SIGN_ONLY"
      ));

    var attributeActions' := config.attributeActions;
    while attributeActions'.Keys != {}
      invariant forall attribute <- (config.attributeActions - attributeActions'.Keys)
      :: Operations.ForwardCompatibleAttributeAction(
          attribute,
          config.attributeActions[attribute],
          config.allowedUnauthenticatedAttributes,
          config.allowedUnauthenticatedAttributePrefix)
      invariant forall attribute <- (config.attributeActions - attributeActions'.Keys)
      :: UnreservedPrefix(attribute)
    {
      var attribute :| attribute in attributeActions';
      var action := config.attributeActions[attribute];
      if !(Operations.ForwardCompatibleAttributeAction(
          attribute,
          action,
          config.allowedUnauthenticatedAttributes,
          config.allowedUnauthenticatedAttributePrefix
        ))
      {
        return Failure(DynamoDbItemEncryptorException(
          message := Operations.ExplainNotForwardCompatible(attribute, action, config.allowedUnauthenticatedAttributes, config.allowedUnauthenticatedAttributePrefix)
        ));
      }
      if !UnreservedPrefix(attribute) {
        return Failure(DynamoDbItemEncryptorException(
          message := "Attribute: " + attribute + " is reserved, and may not be configured."
        ));
      }
      attributeActions' := attributeActions' - {attribute};
    }

    // Create the structured encryption client
    var structuredEncryptionRes := StructuredEncryption.StructuredEncryption();
    var structuredEncryption :- structuredEncryptionRes
      .MapFailure(e => AwsCryptographyDynamoDbEncryption(DDBE.AwsCryptographyStructuredEncryption(e)));

    var cmm;
    if (config.cmm.Some?) {
      cmm := config.cmm.value;
    } else {
      //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#cmm
      //= type=implication
      //# If not supplied during initialization,
      //# the CMM considered "configured" to this
      //# Item Encryptor MUST be a
      //# [default CMM](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/default-cmm.md)
      //# constructed using the [supplied keyring](#keyring) as input.
      var keyring := config.keyring.value;
      var matProv :- expect MaterialProviders.MaterialProviders();
      var maybeCmm := matProv.CreateDefaultCryptographicMaterialsManager(
        AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput(
          keyring := keyring
        )
      );
      cmm :- maybeCmm.MapFailure(e => AwsCryptographyMaterialProviders(e));
    }

    var maybeCmpClient := MaterialProviders.MaterialProviders();
    var internalLegacyConfig :- InternalLegacyConfig.InternalLegacyConfig.Build(config);
    var cmpClient :- maybeCmpClient.MapFailure(e => AwsCryptographyMaterialProviders(e));

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#structure
    //# A [Legacy Config](#legacy-config)
    //# and a [Plaintext Policy](#plaintext-policy)
    //# both specified on the same config is invalid,
    //# and MUST result in an error.
    // :- Need(internalLegacyConfig.None? || config.plaintextPolicy.None?, DynamoDbItemEncryptorException(
    //   message := "Cannot configure both a plaintext policy and a legacy config."
    // ));
    if !(internalLegacyConfig.None? || config.plaintextPolicy.None?) {
      return Failure(DynamoDbItemEncryptorException(
        message := "Cannot configure both a plaintext policy and a legacy config."
      ));
    }

    var plaintextPolicy := if config.plaintextPolicy.Some? then
      config.plaintextPolicy.value
    else
      DDBE.PlaintextPolicy.FORBID_WRITE_FORBID_READ;      

    var internalConfig := Operations.Config(
      cmpClient := cmpClient,
      tableName := config.tableName,
      partitionKeyName := config.partitionKeyName,
      sortKeyName := config.sortKeyName,
      attributeActions := config.attributeActions,
      allowedUnauthenticatedAttributes := config.allowedUnauthenticatedAttributes,
      allowedUnauthenticatedAttributePrefix := config.allowedUnauthenticatedAttributePrefix,
      //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#algorithm-suite
      //= type=implication
      //# The [algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md) that SHOULD be used for encryption.
      algorithmSuiteId := config.algorithmSuiteId,
      cmm := cmm,
      structuredEncryption := structuredEncryption,
      internalLegacyConfig := internalLegacyConfig,
      plaintextPolicy := plaintextPolicy
    );

    // Dafny needs some extra help here
    assert (forall attribute <- internalConfig.attributeActions.Keys :: UnreservedPrefix(attribute));
    assert (forall attribute <- internalConfig.attributeActions.Keys :: !(ReservedPrefix <= attribute));
    assert Operations.ValidInternalConfig?(internalConfig);

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
