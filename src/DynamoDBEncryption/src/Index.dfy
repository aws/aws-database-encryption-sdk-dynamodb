// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/AwsCryptographicMaterialProviders/src/Index.dfy"
include "../../StructuredEncryption/model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../StructuredEncryption/src/Index.dfy"
include "../model/AwsCryptographyDynamodbEncryptionTypes.dfy"
include "Operations/EncryptItemOperation.dfy"
include "Operations/DecryptItemOperation.dfy"

module
  {:extern "Dafny.Aws.DynamoDBEncryption.DynamoDBEncryption"}
  DynamoDBEncryption refines AwsCryptographyDynamodbEncryptionAbstract
{
  import EncryptItemOperation
  import DecryptItemOperation
  import StructuredEncryption
  import AwsCryptographyStructuredEncryptionTypes

  // TODO there is no sensible default, so what should this do?
  // As is, the default config is invalid. Can we update the codegen to *not*
  // build a default config?
  function method DefaultDynamoDBEncryptionConfig(): DynamoDBEncryptionConfig
  {
    DynamoDBEncryptionConfig(tableConfigs := map[])
  }

  method DynamoDBEncryption(config: DynamoDBEncryptionConfig)
      returns (res: Result<IDynamoDBEncryptionClient, Error>)
    ensures res.Success? ==> 
      && fresh(res.value)
      && fresh(res.value.Modifies)
      && fresh(res.value.History)
      && res.value.ValidState()
    ensures |config.tableConfigs| <= 0 ==> res.Failure?
  {
    // Ensure at least one table config exists in the input
    :- Need(|config.tableConfigs| > 0,
      Types.Error.DynamoDBEncryptionException(
        message := "Invalid input: Configuration MUST exist for at least one table."));

    // Initialize StructuredEncryptionClient to use internally
    var structuredEncryptionRes :=
      StructuredEncryption.StructuredEncryption(StructuredEncryption.DefaultStructuredEncryptionConfig());
    // TODO Create helper to :- with different error type, bubble up message
    :- Need(structuredEncryptionRes.Success?,
      Types.Error.DynamoDBEncryptionException(
        message := "Failed to initialize client for structured encryption."));
    var structuredEncryption := structuredEncryptionRes.value;

    var client := new DynamoDBEncryptionClient(config, structuredEncryption);
    return Success(client);
  }

  class DynamoDBEncryptionClient extends Types.IDynamoDBEncryptionClient {
    const config: Types.DynamoDBEncryptionConfig;
    // TODO In Ryan's New World, this makes sense to be a part of the config.
    // However, we do not want this to be part of the API for configuration,
    // we always want this client to initialize the structured encryption client itself.
    // For now, just track as a separate const on this client and pass around.
    const structuredEncryption: AwsCryptographyStructuredEncryptionTypes.IStructuredEncryptionClient;

    predicate ValidState()
      ensures ValidState() ==> History in Modifies
    {
      && History in Modifies
      && History !in structuredEncryption.Modifies
      && |config.tableConfigs| > 0
      && structuredEncryption.ValidState()
      && structuredEncryption.Modifies < Modifies
    }
  
    constructor(
      config: Types.DynamoDBEncryptionConfig,
      structuredEncryption: AwsCryptographyStructuredEncryptionTypes.IStructuredEncryptionClient
    ) requires |config.tableConfigs| > 0
      requires structuredEncryption.ValidState()
      ensures ValidState() && fresh(Modifies - structuredEncryption.Modifies) && fresh(History)
    {
      History := new Types.IDynamoDBEncryptionClientCallHistory();
      Modifies := {History} + structuredEncryption.Modifies;

      this.config := config;
      this.structuredEncryption := structuredEncryption;
    }

    predicate EncryptItemEnsuresPublicly(input: EncryptItemInput, output: Result<EncryptItemOutput, Error>)
    {
      true
      // TODO ensure attributes in crypto schema match attributes in item, and vice versa
      // TODO ensure CMM XOR Keyring is supplied
      // TODO ensure required context fields have no duplicates
      // TODO ensure required context fields are included in encryption context
      // TODO ensure on success non-ENCRYPT_AND_SIGN attributes are unchanged
      // TODO ensure on success ENCRYPT_AND_SIGN attributes are changed, and are type bytes
    }

    predicate DecryptItemEnsuresPublicly(input: DecryptItemInput, output: Result<DecryptItemOutput, Error>)
    {
      true
      // TODO ensure CMM XOR Keyring is supplied
      // TODO ensure on success non-ENCRYPT_AND_SIGN attributes are unchanged
      // TODO ensure on success ENCRYPT_AND_SIGN attributes are changed
    }

    method EncryptItem ( input: EncryptItemInput )
        returns (output: Result<EncryptItemOutput, Error>)
      requires
        && ValidState()
        && ( 
          input.keyring.Some? ==>
            && input.keyring.value.ValidState()
            && input.keyring.value.Modifies !! Modifies
        ) && (
          input.cmm.Some? ==>
            && input.cmm.value.ValidState()
            && input.cmm.value.Modifies !! Modifies
        )
      modifies
        Modifies - {History},
        History`EncryptItem ,
        (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
        (if input.cmm.Some? then input.cmm.value.Modifies else {})
      decreases
        Modifies,
        (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
        (if input.cmm.Some? then input.cmm.value.Modifies else {})
      ensures
        && ValidState()
      ensures
        EncryptItemEnsuresPublicly(input, output)
      ensures
        History.EncryptItem == old(History.EncryptItem) + [DafnyCallEvent(input, output)]
    {
      output := EncryptItemOperation.EncryptItem(config, input, structuredEncryption);
      History.EncryptItem := History.EncryptItem + [Types.DafnyCallEvent(input, output)];
    }
    
    method DecryptItem ( input: DecryptItemInput )
        returns (output: Result<DecryptItemOutput, Error>)
      requires
        && ValidState()
        && ( 
          input.keyring.Some? ==>
            && input.keyring.value.ValidState()
            && input.keyring.value.Modifies !! Modifies
        ) && (
          input.cmm.Some? ==>
            && input.cmm.value.ValidState()
            && input.cmm.value.Modifies !! Modifies
        )
      modifies
        Modifies - {History},
        History`DecryptItem,
        (if input.keyring.Some? then input.keyring.value.Modifies else {}),
        (if input.cmm.Some? then input.cmm.value.Modifies else {})
      decreases
        Modifies,
        (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
        (if input.cmm.Some? then input.cmm.value.Modifies else {})
      ensures
        && ValidState()
      ensures DecryptItemEnsuresPublicly(input, output)
      ensures History.DecryptItem == old(History.DecryptItem) + [DafnyCallEvent(input, output)]
    {
      output := DecryptItemOperation.DecryptItem(config, input, structuredEncryption);
      History.DecryptItem := History.DecryptItem + [Types.DafnyCallEvent(input, output)];
    }
  }
}
