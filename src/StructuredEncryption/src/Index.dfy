// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "Operations/EncryptStructureOperation.dfy"
include "Operations/DecryptStructureOperation.dfy"
include "TypeRegister.dfy"

module {:extern "Dafny.Aws.StructuredEncryption.StructuredEncryptionClient"} StructuredEncryptionClient {
  import opened Wrappers
  import opened StandardLibrary
  import Seq
  import Types = AwsCryptographyStructuredEncryptionTypes
  import EncryptStructureOperation
  import DecryptStructureOperation
  import TypeRegister

  class StructuredEncryptionClient extends Types.IStructuredEncryptionClient {
    const typeRegister: TypeRegister.TypeRegister

    predicate ValidState()
      ensures ValidState() ==> History in Modifies
    {
      && History in Modifies
    }
  
    // TODO we need a factory again. How does this jive with new MPL world?
    constructor(config: Types.StructuredEncryptionConfig)
      ensures ValidState() && fresh(Modifies) && fresh(History)
      // TODO If list contains dupes, error
      // TODO If list contains resrved typeId, error
    {
      History := new Types.IStructuredEncryptionClientCallHistory();
      Modifies := {History};
      var typesToRegister := if config.typesToRegister.Some? then config.typesToRegister.value else [];
      var typesMap: map<Types.TerminalTypeId, Types.TypeEntry> := map[];
      for i := 0 to |typesToRegister|
        invariant forall k :: k in typesMap.Keys ==> typesMap[k].typeId == k;
        invariant TypeRegister.BYTES_TYPE_ID !in typesMap.Keys
      {
        var terminalType := typesToRegister[i];
        // TODO I want this to fail instead of ignoring 0x62,
        // but we cannot do that in a constructor.
        // Nor can we constraint the type via Smithy model
        if (terminalType.typeId != TypeRegister.BYTES_TYPE_ID) {
          // TODO I want this to fail instead of writing over,
          // but we cannot do that in a constructor.
          // Nor can we constraint the type via Smithy model
          typesMap := typesMap[terminalType.typeId := terminalType];
        }
      }
      typeRegister := typesMap;
    }

    predicate EncryptStructureEnsuresPublicly(
      input: Types.EncryptStructureInput, 
      output: Result<Types.EncryptStructureOutput, Types.Error>)
    {
      var encryptionContextFields := if input.encryptionContext.Some? then input.encryptionContext.value.Keys else {};
      var requiredFields := if input.requiredContextFieldsOnDecrypt.Some? then input.requiredContextFieldsOnDecrypt.value else [];
      && (!(forall k :: k in requiredFields ==> k in encryptionContextFields) ==> output.Failure?)
      && (!Seq.HasNoDuplicates(requiredFields) ==> output.Failure?)
      && ((
          || (input.cmm.Some? && input.keyring.Some?)
          || (input.cmm.None? && input.keyring.None?)
        ) ==> output.Failure?)
    }

    predicate DecryptStructureEnsuresPublicly(
      input: Types.DecryptStructureInput, 
      output: Result<Types.DecryptStructureOutput, Types.Error>)
    {
      && ((
          || (input.cmm.Some? && input.keyring.Some?)
          || (input.cmm.None? && input.keyring.None?)
        ) ==> output.Failure?)
      && (|input.cryptoSchemas| <= 0 ==> output.Failure?)
    }

    method EncryptStructure(input: Types.EncryptStructureInput)
        returns (output: Result<Types.EncryptStructureOutput, Types.Error>)
      requires ValidState()
      modifies Modifies - {History},
        History`EncryptStructure
      decreases Modifies ,
        (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
        (if input.cmm.Some? then input.cmm.value.Modifies else {})
      ensures EncryptStructureEnsuresPublicly(input, output)
      ensures History.EncryptStructure == old(History.EncryptStructure) + [Types.DafnyCallEvent(input, output)]
    {
      output := EncryptStructureOperation.EncryptStructure(input);
      History.EncryptStructure := History.EncryptStructure + [Types.DafnyCallEvent(input, output)];
    }

    method DecryptStructure(input: Types.DecryptStructureInput)
        returns (output: Result<Types.DecryptStructureOutput, Types.Error>)
      requires ValidState()
      modifies Modifies - {History},
        History`DecryptStructure
      decreases Modifies ,
        (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
        (if input.cmm.Some? then input.cmm.value.Modifies else {})
      ensures DecryptStructureEnsuresPublicly(input, output)
      ensures History.DecryptStructure == old(History.DecryptStructure) + [Types.DafnyCallEvent(input, output)]
    {
      output := DecryptStructureOperation.DecryptStructure(input);
      History.DecryptStructure := History.DecryptStructure + [Types.DafnyCallEvent(input, output)];
    }
  }
}
