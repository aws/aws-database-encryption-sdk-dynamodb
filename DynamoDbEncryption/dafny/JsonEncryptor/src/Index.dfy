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
  import MaterialProviders
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import Operations = AwsCryptographyDbEncryptionSdkJsonEncryptorOperations
  import SE =  StructuredEncryptionUtil
  import SortedSets

  // There is no sensible default, so construct something simple but invalid at runtime.
  function method DefaultJsonEncryptorConfig(): JsonEncryptorConfig
  {
    JsonEncryptorConfig(
      domain := "TableName",
      memberActionsOnEncrypt := map[],
      encrypt := JsonEncrypt()
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
              && rconfig.memberActionsOnEncrypt == config.memberActionsOnEncrypt
              && rconfig.allowedUnsignedMembers == config.allowedUnsignedMembers
              && rconfig.allowedUnsignedMemberPrefix == config.allowedUnsignedMemberPrefix
              && rconfig.algorithmSuiteId == config.encrypt.algorithmSuiteId
  {
    :- Need(forall k <- config.memberActionsOnEncrypt :: config.memberActionsOnEncrypt[k].crypto?, E(""));
    var memberNames : seq<string> := SortedSets.ComputeSetToSequence(config.memberActionsOnEncrypt.Keys);
    for i := 0 to |memberNames|
      invariant forall j | 0 <= j < i ::
      && UnreservedPrefix(memberNames[j])
      && (Operations.ForwardCompatibleMemberAction(
               memberNames[j],
               config.memberActionsOnEncrypt[memberNames[j]].crypto,
               config.allowedUnsignedMembers,
               config.allowedUnsignedMemberPrefix))
    {
      var memberName := memberNames[i];
      var action := config.memberActionsOnEncrypt[memberName].crypto;
      if !(Operations.ForwardCompatibleMemberAction(
          memberName,
          action,
          config.allowedUnsignedMembers,
          config.allowedUnsignedMemberPrefix
        ))
      {
        return Failure(JsonEncryptorException(
          message := Operations.ExplainNotForwardCompatible(memberName, action, config.allowedUnsignedMembers, config.allowedUnsignedMemberPrefix)
        ));
      }
      if !UnreservedPrefix(memberName) {
        return Failure(JsonEncryptorException(
          message := "Member: " + memberName + " is reserved, and may not be configured."
        ));
      }
      assert UnreservedPrefix(memberName);
      assert UnreservedPrefix(memberNames[i]);
    }

    assert (forall member <- memberNames :: UnreservedPrefix(member));
    assert (forall member <- config.memberActionsOnEncrypt.Keys :: UnreservedPrefix(member));
    assert (forall member <- config.memberActionsOnEncrypt.Keys :: !(ReservedPrefix <= member));

    // Create the structured encryption client
    var structuredEncryptionRes := StructuredEncryption.StructuredEncryption();
    var structuredEncryptionX : CSE.IStructuredEncryptionClient :- structuredEncryptionRes
    .MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    assert structuredEncryptionX is StructuredEncryption.StructuredEncryptionClient;
    var structuredEncryption := structuredEncryptionX as StructuredEncryption.StructuredEncryptionClient;

    var cmm;
    if (config.encrypt.cmm.Some?) {
      cmm := config.encrypt.cmm.value;
    } else if (config.encrypt.keyring.Some?) {
      var keyring := config.encrypt.keyring.value;
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
      domain := config.domain,
      cmpClient := cmpClient,
      memberActionsOnEncrypt := config.memberActionsOnEncrypt,
      allowedUnsignedMembers := config.allowedUnsignedMembers,
      allowedUnsignedMemberPrefix := config.allowedUnsignedMemberPrefix,
      algorithmSuiteId := config.encrypt.algorithmSuiteId,
      cmm := cmm,
      structuredEncryption := structuredEncryption
    );

    // Dafny needs some extra help here
    assert (forall member <- internalConfig.memberActionsOnEncrypt.Keys :: UnreservedPrefix(member));
    assert (forall member <- internalConfig.memberActionsOnEncrypt.Keys :: !(ReservedPrefix <= member));
    assert Operations.ValidInternalConfig?(internalConfig);

    var client := new JsonEncryptorClient(internalConfig);

    assert fresh(client.Modifies
                 - ( if config.encrypt.keyring.Some? then config.encrypt.keyring.value.Modifies else {})
                 - ( if config.encrypt.cmm.Some? then config.encrypt.cmm.value.Modifies else {} ));

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
