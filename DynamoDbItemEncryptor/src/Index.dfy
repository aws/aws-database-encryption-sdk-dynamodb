// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDynamoDbItemEncryptorOperations.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbItemEncryptor" }
  DynamoDbItemEncryptor refines AbstractAwsCryptographyDynamoDbItemEncryptorService
{
  import StructuredEncryption
  import CSE = AwsCryptographyStructuredEncryptionTypes
  import MaterialProviders
  import Operations = AwsCryptographyDynamoDbItemEncryptorOperations
  import SE =  StructuredEncryptionUtil

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
      algorithmSuiteId := None()
    )
  }

  // because an inline "!(SE.ReservedPrefix <= attr)" is too hard for Dafny
  predicate method UnreservedPrefix(attr : string)
  {
    !(SE.ReservedPrefix <= attr)
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
      && res.value.config.algorithmSuiteId == config.algorithmSuiteId
    // TODO expected CMM/Keyring behavior
  {
    // TODO validation of config input

    // TODO Fix this when the compile bug is fixed (https://t.corp.amazon.com/P78273149)
    // :- Need(config.keyring.None? || config.cmm.None?, DynamoDbItemEncryptorException(
    //   message := "Cannot provide both a keyring and a CMM"
    // ));
    if !(config.keyring.None? || config.cmm.None?) {
      return Failure(DynamoDbItemEncryptorException(
        message := "Cannot provide both a keyring and a CMM"
      ));
    }
    // :- Need(config.keyring.Some? || config.cmm.Some?, DynamoDbItemEncryptorException(
    //   message := "Must provide either a keyring or a CMM"
    // ));
    if !(config.keyring.Some? || config.cmm.Some?) {
      return Failure(DynamoDbItemEncryptorException(
        message := "Must provide either a keyring or a CMM"
      ));
    }
    // :- Need(
    //     && config.partitionKeyName in config.attributeActions
    //     && config.attributeActions[config.partitionKeyName] == CSE.SIGN_ONLY,
    //   DynamoDbItemEncryptorException(
    //     message := "Partition key attribute action MUST be SIGN_ONLY"
    //   ));
    if 
        !(&& config.partitionKeyName in config.attributeActions
        && config.attributeActions[config.partitionKeyName] == CSE.SIGN_ONLY)
    {
      return Failure(DynamoDbItemEncryptorException(
        message := "Partition key attribute action MUST be SIGN_ONLY"
      ));
    }
    // :- Need(
    //   (config.sortKeyName.Some? ==>
    //     && config.sortKeyName.value in config.attributeActions
    //     && config.attributeActions[config.sortKeyName.value] == CSE.SIGN_ONLY),
    //   DynamoDbItemEncryptorException(
    //     message := "Sort key attribute action MUST be SIGN_ONLY"
    //   ));
    if !(
      (config.sortKeyName.Some? ==>
        && config.sortKeyName.value in config.attributeActions
        && config.attributeActions[config.sortKeyName.value] == CSE.SIGN_ONLY))
    {
      return Failure(DynamoDbItemEncryptorException(
        message := "Sort key attribute action MUST be SIGN_ONLY"
      ));
    }

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
      // :- Need(Operations.ForwardCompatibleAttributeAction(
      //       attribute,
      //       action,
      //       config.allowedUnauthenticatedAttributes,
      //       config.allowedUnauthenticatedAttributePrefix
      //     ),
      //     DynamoDbItemEncryptorException(
      //       message := "Attribute: " + attribute + " configuration not compatible with unauthenticated configuration."
      //     ));
      if !(Operations.ForwardCompatibleAttributeAction(
          attribute,
          action,
          config.allowedUnauthenticatedAttributes,
          config.allowedUnauthenticatedAttributePrefix
        ))
      {
        return Failure(DynamoDbItemEncryptorException(
          message := "Attribute: " + attribute + " configuration not compatible with unauthenticated configuration."
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
      .MapFailure(e => AwsCryptographyStructuredEncryption(e));

    // TODO For now just passthrough cmm or wrap keyring with DefaultCMM
    var cmm;
    if (config.cmm.Some?) {
      cmm := config.cmm.value;
    } else {
      var keyring := config.keyring.value;
      var matProv :- expect MaterialProviders.MaterialProviders();
      var maybeCmm := matProv.CreateDefaultCryptographicMaterialsManager(
        AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput(
          keyring := keyring
        )
      );
      cmm :- maybeCmm.MapFailure(e => AwsCryptographyMaterialProviders(e));
    }

    var internalConfig := Operations.Config(
      tableName := config.tableName,
      partitionKeyName := config.partitionKeyName,
      sortKeyName := config.sortKeyName,
      attributeActions := config.attributeActions,
      allowedUnauthenticatedAttributes := config.allowedUnauthenticatedAttributes,
      allowedUnauthenticatedAttributePrefix := config.allowedUnauthenticatedAttributePrefix,
      algorithmSuiteId := config.algorithmSuiteId,
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
