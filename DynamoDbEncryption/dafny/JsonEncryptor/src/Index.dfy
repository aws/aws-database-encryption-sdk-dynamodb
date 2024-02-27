// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDbEncryptionSdkDynamoDbJsonOperations.dfy"
include "Util.dfy"

module
  {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny" }
  JsonEncryptor refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbJsonService
{
  import opened JsonEncryptorUtil
  import StructuredEncryption
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import MaterialProviders
  import Operations = AwsCryptographyDbEncryptionSdkJsonEncryptorOperations
  import SE =  StructuredEncryptionUtil
  import SortedSets

  // There is no sensible default, so construct something simple but invalid at runtime.
  function method DefaultJsonEncryptorConfig(): JsonEncryptorConfig
  {
    JsonEncryptorConfig(
      logicalTableName := "TableName",
      actions := Actions(attributeActionsOnEncrypt := map[])
    )
  }

  // because an inline "!(ReservedPrefix <= attr)" is too hard for Dafny
  predicate method UnreservedPrefix(attr : string)
  {
    !(ReservedPrefix <= attr)
  }

  method {:vcs_split_on_every_assert} JsonEncryptor(config: JsonEncryptorConfig)
    returns (res: Result<IJsonEncryptorClient, Error>)
    ensures res.Success? ==>
              && res.value is JsonEncryptorClient
              && var rconfig := (res.value as JsonEncryptorClient).config;
              && rconfig.attributeActionsOnEncrypt == config.actions.attributeActionsOnEncrypt
              && config.encrypt.Some?
              && config.actions.defaultAction.Some?
              && config.actions.defaultAction.value.explicitUnsigned?
              && rconfig.allowedUnsignedAttributes == config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributes
              && rconfig.allowedUnsignedAttributePrefix == config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributePrefix
              && rconfig.algorithmSuiteId == config.encrypt.value.algorithmSuiteId
  {

    :- Need(config.encrypt.Some?, E("foo"));
    :- Need(config.actions.defaultAction.Some?, E("foo"));
    :- Need(config.actions.defaultAction.value.explicitUnsigned?, E("foo"));

    var attributeNames : seq<string> := SortedSets.ComputeSetToSequence(config.actions.attributeActionsOnEncrypt.Keys);
    for i := 0 to |attributeNames|
      invariant forall j | 0 <= j < i ::
      && UnreservedPrefix(attributeNames[j])
      && (Operations.ForwardCompatibleAttributeAction(
               attributeNames[j],
               config.actions.attributeActionsOnEncrypt[attributeNames[j]],
               config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributes,
               config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributePrefix))
    {
      var attributeName := attributeNames[i];
      var action := config.actions.attributeActionsOnEncrypt[attributeName];
      if !(Operations.ForwardCompatibleAttributeAction(
          attributeName,
          action,
          config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributes,
          config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributePrefix
        ))
      {
        return Failure(JsonEncryptorException(
          message := Operations.ExplainNotForwardCompatible(attributeName, action, config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributes, config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributePrefix)
        ));
      }
      if !UnreservedPrefix(attributeName) {
        return Failure(JsonEncryptorException(
          message := "Attribute: " + attributeName + " is reserved, and may not be configured."
        ));
      }
      assert UnreservedPrefix(attributeName);
      assert UnreservedPrefix(attributeNames[i]);
    }

    assert (forall attribute <- attributeNames :: UnreservedPrefix(attribute));
    assert (forall attribute <- config.actions.attributeActionsOnEncrypt.Keys :: UnreservedPrefix(attribute));
    assert (forall attribute <- config.actions.attributeActionsOnEncrypt.Keys :: !(ReservedPrefix <= attribute));

    // Create the structured encryption client
    var structuredEncryptionRes := StructuredEncryption.StructuredEncryption();
    var structuredEncryptionX : CSE.IStructuredEncryptionClient :- structuredEncryptionRes
    .MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    assert structuredEncryptionX is StructuredEncryption.StructuredEncryptionClient;
    var structuredEncryption := structuredEncryptionX as StructuredEncryption.StructuredEncryptionClient;

    var cmm;
    if (config.encrypt.value.cmm.Some?) {
      cmm := config.encrypt.value.cmm.value;
    } else if (config.encrypt.value.keyring.Some?) {
      var keyring := config.encrypt.value.keyring.value;
      var matProv :- expect MaterialProviders.MaterialProviders();
      var maybeCmm := matProv.CreateDefaultCryptographicMaterialsManager(
        AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput(
          keyring := keyring
        )
      );
      cmm :- maybeCmm.MapFailure(e => AwsCryptographyMaterialProviders(e));
    } else {
      return Failure(E("Either a CMM or a Keyring must be provided."));
    }

    var maybeCmpClient := MaterialProviders.MaterialProviders();
    var cmpClient :- maybeCmpClient.MapFailure(e => AwsCryptographyMaterialProviders(e));

    var internalConfig := Operations.Config(
      logicalTableName := config.logicalTableName,
      cmpClient := cmpClient,
      attributeActionsOnEncrypt := config.actions.attributeActionsOnEncrypt,
      allowedUnsignedAttributes := config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributes,
      allowedUnsignedAttributePrefix := config.actions.defaultAction.value.explicitUnsigned.allowedUnsignedAttributePrefix,
      algorithmSuiteId := config.encrypt.value.algorithmSuiteId,
      cmm := cmm,
      structuredEncryption := structuredEncryption
    );

    // Dafny needs some extra help here
    assert (forall attribute <- internalConfig.attributeActionsOnEncrypt.Keys :: UnreservedPrefix(attribute));
    assert (forall attribute <- internalConfig.attributeActionsOnEncrypt.Keys :: !(ReservedPrefix <= attribute));
    assert Operations.ValidInternalConfig?(internalConfig);

    var client := new JsonEncryptorClient(internalConfig);

    assert fresh(client.Modifies
                 - ( if config.encrypt.value.keyring.Some? then config.encrypt.value.keyring.value.Modifies else {})
                 - ( if config.encrypt.value.cmm.Some? then config.encrypt.value.cmm.value.Modifies else {} ));

    return Success(client);
  }

  class JsonEncryptorClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IJsonEncryptorClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }
}
