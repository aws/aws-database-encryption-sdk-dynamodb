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
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import MaterialProviders
  import Operations = AwsCryptographyDbEncryptionSdkJsonEncryptorOperations
  import SE =  StructuredEncryptionUtil
  import SortedSets

  // There is no sensible default, so construct something simple but invalid at runtime.
  function method DefaultJsonEncryptorConfig(): JsonEncryptorConfig
  {
    JsonEncryptorConfig(
      logicalTableName := "TableName",
      attributeActionsOnEncrypt := map[],
      allowedUnsignedAttributes := None(),
      allowedUnsignedAttributePrefix := None(),
      keyring := None(),
      cmm := None(),
      algorithmSuiteId := None()
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
      && rconfig.attributeActionsOnEncrypt == config.attributeActionsOnEncrypt
      && rconfig.allowedUnsignedAttributes == config.allowedUnsignedAttributes
      && rconfig.allowedUnsignedAttributePrefix == config.allowedUnsignedAttributePrefix
      && rconfig.algorithmSuiteId == config.algorithmSuiteId
  {
    :- Need(config.keyring.None? || config.cmm.None?, JsonEncryptorException(
      message := "Cannot provide both a keyring and a CMM"
    ));
    :- Need(config.keyring.Some? || config.cmm.Some?, JsonEncryptorException(
      message := "Must provide either a keyring or a CMM"
    ));

    // We happen to order these values, but this ordering MUST NOT be relied upon.
    var attributeNames : seq<string> := SortedSets.ComputeSetToOrderedSequence2(config.attributeActionsOnEncrypt.Keys, CharLess);
    for i := 0 to |attributeNames|
      invariant forall j | 0 <= j < i ::
      && UnreservedPrefix(attributeNames[j])
      && (Operations.ForwardCompatibleAttributeAction(
               attributeNames[j],
               config.attributeActionsOnEncrypt[attributeNames[j]],
               config.allowedUnsignedAttributes,
               config.allowedUnsignedAttributePrefix))
    {
      var attributeName := attributeNames[i];
      var action := config.attributeActionsOnEncrypt[attributeName];
      if !(Operations.ForwardCompatibleAttributeAction(
          attributeName,
          action,
          config.allowedUnsignedAttributes,
          config.allowedUnsignedAttributePrefix
        ))
      {
        return Failure(JsonEncryptorException(
          message := Operations.ExplainNotForwardCompatible(attributeName, action, config.allowedUnsignedAttributes, config.allowedUnsignedAttributePrefix)
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
    assert (forall attribute <- config.attributeActionsOnEncrypt.Keys :: UnreservedPrefix(attribute));
    assert (forall attribute <- config.attributeActionsOnEncrypt.Keys :: !(ReservedPrefix <= attribute));

    // Create the structured encryption client
    var structuredEncryptionRes := StructuredEncryption.StructuredEncryption();
    var structuredEncryptionX : CSE.IStructuredEncryptionClient :- structuredEncryptionRes
      .MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    assert structuredEncryptionX is StructuredEncryption.StructuredEncryptionClient;
    var structuredEncryption := structuredEncryptionX as StructuredEncryption.StructuredEncryptionClient;

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

    var maybeCmpClient := MaterialProviders.MaterialProviders();
    var cmpClient :- maybeCmpClient.MapFailure(e => AwsCryptographyMaterialProviders(e));

    var internalConfig := Operations.Config(
      logicalTableName := config.logicalTableName,
      cmpClient := cmpClient,
      attributeActionsOnEncrypt := config.attributeActionsOnEncrypt,
      allowedUnsignedAttributes := config.allowedUnsignedAttributes,
      allowedUnsignedAttributePrefix := config.allowedUnsignedAttributePrefix,
      algorithmSuiteId := config.algorithmSuiteId,
      cmm := cmm,
      structuredEncryption := structuredEncryption
    );

    // Dafny needs some extra help here
    assert (forall attribute <- internalConfig.attributeActionsOnEncrypt.Keys :: UnreservedPrefix(attribute));
    assert (forall attribute <- internalConfig.attributeActionsOnEncrypt.Keys :: !(ReservedPrefix <= attribute));
    assert Operations.ValidInternalConfig?(internalConfig);

    var client := new JsonEncryptorClient(internalConfig);

    assert fresh(client.Modifies
      - ( if config.keyring.Some? then config.keyring.value.Modifies else {})
      - ( if config.cmm.Some? then config.cmm.value.Modifies else {} ));

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
