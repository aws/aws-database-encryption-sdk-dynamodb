// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.dfy"
include "Util.dfy"

module {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny" } DynamoDbItemEncryptor
  refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorService
{
  import opened DynamoDbItemEncryptorUtil
  import StructuredEncryption
  import StructuredEncryptionHeader
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import MaterialProviders
  import Operations = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations
  import SE =  StructuredEncryptionUtil
  import InternalLegacyOverride
  import SortedSets
  import DDB = ComAmazonawsDynamodbTypes

  // There is no sensible default, so construct something simple but invalid at runtime.
  function method DefaultDynamoDbItemEncryptorConfig(): DynamoDbItemEncryptorConfig
  {
    DynamoDbItemEncryptorConfig(
      logicalTableName := "foo",
      partitionKeyName := "bar",
      sortKeyName := None(),
      attributeActionsOnEncrypt := map[],
      allowedUnsignedAttributes := None(),
      allowedUnsignedAttributePrefix := None(),
      keyring := None(),
      cmm := None(),
      algorithmSuiteId := None(),
      legacyOverride := None(),
      plaintextOverride := None()
    )
  }

  predicate method UnreservedPrefix(attr : string)
  {
    && !(ReservedPrefix <= attr)
    && !(SE.ReservedCryptoContextPrefixString <= attr)
  }

  method {:vcs_split_on_every_assert} DynamoDbItemEncryptor(config: DynamoDbItemEncryptorConfig)
    returns (res: Result<DynamoDbItemEncryptorClient, Error>)
    ensures res.Success? ==>
              && res.value is DynamoDbItemEncryptorClient
              && var rconfig := (res.value as DynamoDbItemEncryptorClient).config;
              && rconfig.logicalTableName == config.logicalTableName
              && rconfig.partitionKeyName == config.partitionKeyName
              && rconfig.sortKeyName == config.sortKeyName
              && rconfig.attributeActionsOnEncrypt == config.attributeActionsOnEncrypt
              && rconfig.allowedUnsignedAttributes == config.allowedUnsignedAttributes
              && rconfig.allowedUnsignedAttributePrefix == config.allowedUnsignedAttributePrefix
              && rconfig.algorithmSuiteId == config.algorithmSuiteId

              //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#attribute-actions
              //= type=implication
              //# The [Key Action](#key-action)
              //# MUST be configured to the partition attribute and, if present, sort attribute.
              && rconfig.version == Operations.VersionFromActions(config.attributeActionsOnEncrypt)
              && config.partitionKeyName in config.attributeActionsOnEncrypt
              && config.attributeActionsOnEncrypt[config.partitionKeyName] == Operations.KeyActionFromVersion(rconfig.version)
              && (config.sortKeyName.Some? ==>
                    && config.sortKeyName.value in config.attributeActionsOnEncrypt
                    && config.attributeActionsOnEncrypt[config.sortKeyName.value] == Operations.KeyActionFromVersion(rconfig.version))

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#plaintext-policy
    //# If not specified, encryption and decryption MUST behave according to `FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ`.
    ensures
      && res.Success?
      && config.plaintextOverride.None?
      ==>
        && var config := (res.value as DynamoDbItemEncryptorClient).config;
        && config.plaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ?
  {
    :- Need(config.keyring.None? || config.cmm.None?, DynamoDbItemEncryptorException(
              message := "Cannot provide both a keyring and a CMM"
            ));
    :- Need(config.keyring.Some? || config.cmm.Some?, DynamoDbItemEncryptorException(
              message := "Must provide either a keyring or a CMM"
            ));
    var version := Operations.VersionFromActions(config.attributeActionsOnEncrypt);
    var keyAction := Operations.KeyActionFromVersion(version);
    var keyActionStr := Operations.KeyActionStringFromVersion(version);
    :- Need(
      && config.partitionKeyName in config.attributeActionsOnEncrypt
      && config.attributeActionsOnEncrypt[config.partitionKeyName] == keyAction,
      DynamoDbItemEncryptorException(
        message := "Partition key attribute action MUST be " + keyActionStr
      ));
    :- Need(
      (config.sortKeyName.Some? ==>
         && config.sortKeyName.value in config.attributeActionsOnEncrypt
         && config.attributeActionsOnEncrypt[config.sortKeyName.value] == keyAction),
      DynamoDbItemEncryptorException(
        message := "Sort key attribute action MUST be " + keyActionStr
      ));

    // We happen to order these values, but this ordering MUST NOT be relied upon.
    var attributeNames : seq<DDB.AttributeName> := SortedSets.ComputeSetToOrderedSequence2(config.attributeActionsOnEncrypt.Keys, CharLess);
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
        return Failure(DynamoDbItemEncryptorException(
                         message := Operations.ExplainNotForwardCompatible(attributeName, action, config.allowedUnsignedAttributes, config.allowedUnsignedAttributePrefix)
                       ));
      }
      if !UnreservedPrefix(attributeName) {
        return Failure(DynamoDbItemEncryptorException(
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
    .MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(DDBE.AwsCryptographyDbEncryptionSdkStructuredEncryption(e)));
    assert structuredEncryptionX is StructuredEncryption.StructuredEncryptionClient;
    var structuredEncryption := structuredEncryptionX as StructuredEncryption.StructuredEncryptionClient;

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
    var internalLegacyOverride :- InternalLegacyOverride.InternalLegacyOverride.Build(config);
    var cmpClient :- maybeCmpClient.MapFailure(e => AwsCryptographyMaterialProviders(e));

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#structure
    //# A [Legacy Config](#legacy-config)
    //# and a [Plaintext Policy](#plaintext-policy)
    //# both specified on the same config is invalid,
    //# and MUST result in an error.
    // :- Need(internalLegacyOverride.None? || config.plaintextOverride.None?, DynamoDbItemEncryptorException(
    //   message := "Cannot configure both a plaintext policy and a legacy config."
    // ));
    if !(internalLegacyOverride.None? || config.plaintextOverride.None?) {
      return Failure(DynamoDbItemEncryptorException(
                       message := "Cannot configure both a plaintext policy and a legacy config."
                     ));
    }

    var plaintextOverride := if config.plaintextOverride.Some? then
      config.plaintextOverride.value
    else
      DDBE.PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ;

    var internalConfig := Operations.Config(
      version := version,
      cmpClient := cmpClient,
      logicalTableName := config.logicalTableName,
      partitionKeyName := config.partitionKeyName,
      sortKeyName := config.sortKeyName,
      attributeActionsOnEncrypt := config.attributeActionsOnEncrypt,
      allowedUnsignedAttributes := config.allowedUnsignedAttributes,
      allowedUnsignedAttributePrefix := config.allowedUnsignedAttributePrefix,
      //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#algorithm-suite
      //= type=implication
      //# The [algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md) that SHOULD be used for encryption.
      algorithmSuiteId := config.algorithmSuiteId,
      cmm := cmm,
      structuredEncryption := (structuredEncryption as StructuredEncryption.StructuredEncryptionClient),
      internalLegacyOverride := internalLegacyOverride,
      plaintextOverride := plaintextOverride
    );

    // Dafny needs some extra help here
    assert (forall attribute <- internalConfig.attributeActionsOnEncrypt.Keys :: UnreservedPrefix(attribute));
    assert (forall attribute <- internalConfig.attributeActionsOnEncrypt.Keys :: !(ReservedPrefix <= attribute));
    assert Operations.ValidInternalConfig?(internalConfig);

    var client := new DynamoDbItemEncryptorClient(internalConfig);

    assert fresh(client.History);
    assert client.Modifies == Operations.ModifiesInternalConfig(internalConfig) + {client.History};
    assert Operations.ModifiesInternalConfig(internalConfig) ==
           internalConfig.cmm.Modifies
           + internalConfig.structuredEncryption.Modifies
           + internalConfig.cmpClient.Modifies;

    assume {:axiom} fresh(client.Modifies
                          - ( if config.keyring.Some? then config.keyring.value.Modifies else {})
                          - ( if config.cmm.Some? then config.cmm.value.Modifies else {} )
                          - ( if config.legacyOverride.Some? then config.legacyOverride.value.encryptor.Modifies else {}));

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
