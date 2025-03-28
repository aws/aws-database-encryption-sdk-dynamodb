// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographyPrimitives/src/Index.dfy"
module {:extern "software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types" } AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
{
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import AwsCryptographyMaterialProvidersTypes
  import AwsCryptographyPrimitivesTypes
  // Generic helpers for verification of mock/unit tests.
  datatype DafnyCallEvent<I, O> = DafnyCallEvent(input: I, output: O)

  // Begin Generated Types

  datatype AuthenticateAction =
    | SIGN
    | DO_NOT_SIGN
  type AuthenticateSchemaMap = map<string, AuthenticateAction>
  datatype AuthItem = | AuthItem (
    nameonly key: Path ,
    nameonly data: StructuredDataTerminal ,
    nameonly action: AuthenticateAction
  )
  type AuthList = seq<AuthItem>
  datatype CryptoAction =
    | ENCRYPT_AND_SIGN
    | SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
    | SIGN_ONLY
    | DO_NOTHING
  datatype CryptoItem = | CryptoItem (
    nameonly key: Path ,
    nameonly data: StructuredDataTerminal ,
    nameonly action: CryptoAction
  )
  type CryptoList = seq<CryptoItem>
  type CryptoSchemaMap = map<string, CryptoAction>
  datatype DecryptPathStructureInput = | DecryptPathStructureInput (
    nameonly tableName: string ,
    nameonly encryptedStructure: AuthList ,
    nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager ,
    nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext> := Option.None
  )
  datatype DecryptPathStructureOutput = | DecryptPathStructureOutput (
    nameonly plaintextStructure: CryptoList ,
    nameonly parsedHeader: ParsedHeader
  )
  datatype DecryptStructureInput = | DecryptStructureInput (
    nameonly tableName: string ,
    nameonly encryptedStructure: StructuredDataMap ,
    nameonly authenticateSchema: AuthenticateSchemaMap ,
    nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager ,
    nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext> := Option.None
  )
  datatype DecryptStructureOutput = | DecryptStructureOutput (
    nameonly plaintextStructure: StructuredDataMap ,
    nameonly cryptoSchema: CryptoSchemaMap ,
    nameonly parsedHeader: ParsedHeader
  )
  datatype EncryptPathStructureInput = | EncryptPathStructureInput (
    nameonly tableName: string ,
    nameonly plaintextStructure: CryptoList ,
    nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager ,
    nameonly algorithmSuiteId: Option<AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId> := Option.None ,
    nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext> := Option.None
  )
  datatype EncryptPathStructureOutput = | EncryptPathStructureOutput (
    nameonly encryptedStructure: CryptoList ,
    nameonly parsedHeader: ParsedHeader
  )
  datatype EncryptStructureInput = | EncryptStructureInput (
    nameonly tableName: string ,
    nameonly plaintextStructure: StructuredDataMap ,
    nameonly cryptoSchema: CryptoSchemaMap ,
    nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager ,
    nameonly algorithmSuiteId: Option<AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId> := Option.None ,
    nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext> := Option.None
  )
  datatype EncryptStructureOutput = | EncryptStructureOutput (
    nameonly encryptedStructure: StructuredDataMap ,
    nameonly cryptoSchema: CryptoSchemaMap ,
    nameonly parsedHeader: ParsedHeader
  )
  datatype ParsedHeader = | ParsedHeader (
    nameonly algorithmSuiteId: AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId ,
    nameonly encryptedDataKeys: AwsCryptographyMaterialProvidersTypes.EncryptedDataKeyList ,
    nameonly storedEncryptionContext: AwsCryptographyMaterialProvidersTypes.EncryptionContext ,
    nameonly encryptionContext: AwsCryptographyMaterialProvidersTypes.EncryptionContext
  )
  type Path = seq<PathSegment>
  datatype PathSegment =
    | member(member: StructureSegment)
  datatype ResolveAuthActionsInput = | ResolveAuthActionsInput (
    nameonly tableName: string ,
    nameonly authActions: AuthList ,
    nameonly headerBytes: seq<uint8>
  )
  datatype ResolveAuthActionsOutput = | ResolveAuthActionsOutput (
    nameonly cryptoActions: CryptoList
  )
  type StructuredDataMap = map<string, StructuredDataTerminal>
  datatype StructuredDataTerminal = | StructuredDataTerminal (
    nameonly value: TerminalValue ,
    nameonly typeId: TerminalTypeId
  )
  class IStructuredEncryptionClientCallHistory {
    ghost constructor() {
      EncryptStructure := [];
      DecryptStructure := [];
      EncryptPathStructure := [];
      DecryptPathStructure := [];
      ResolveAuthActions := [];
    }
    ghost var EncryptStructure: seq<DafnyCallEvent<EncryptStructureInput, Result<EncryptStructureOutput, Error>>>
    ghost var DecryptStructure: seq<DafnyCallEvent<DecryptStructureInput, Result<DecryptStructureOutput, Error>>>
    ghost var EncryptPathStructure: seq<DafnyCallEvent<EncryptPathStructureInput, Result<EncryptPathStructureOutput, Error>>>
    ghost var DecryptPathStructure: seq<DafnyCallEvent<DecryptPathStructureInput, Result<DecryptPathStructureOutput, Error>>>
    ghost var ResolveAuthActions: seq<DafnyCallEvent<ResolveAuthActionsInput, Result<ResolveAuthActionsOutput, Error>>>
  }
  trait {:termination false} IStructuredEncryptionClient
  {
    // Helper to define any additional modifies/reads clauses.
    // If your operations need to mutate state,
    // add it in your constructor function:
    // Modifies := {your, fields, here, History};
    // If you do not need to mutate anything:
    // Modifies := {History};

    ghost const Modifies: set<object>
    // For an unassigned field defined in a trait,
    // Dafny can only assign a value in the constructor.
    // This means that for Dafny to reason about this value,
    // it needs some way to know (an invariant),
    // about the state of the object.
    // This builds on the Valid/Repr paradigm
    // To make this kind requires safe to add
    // to methods called from unverified code,
    // the predicate MUST NOT take any arguments.
    // This means that the correctness of this requires
    // MUST only be evaluated by the class itself.
    // If you require any additional mutation,
    // then you MUST ensure everything you need in ValidState.
    // You MUST also ensure ValidState in your constructor.
    predicate ValidState()
      ensures ValidState() ==> History in Modifies
    ghost const History: IStructuredEncryptionClientCallHistory
    predicate EncryptStructureEnsuresPublicly(input: EncryptStructureInput , output: Result<EncryptStructureOutput, Error>)
    // The public method to be called by library consumers
    method EncryptStructure ( input: EncryptStructureInput )
      returns (output: Result<EncryptStructureOutput, Error>)
      requires
        && ValidState()
        && input.cmm.ValidState()
        && input.cmm.Modifies !! {History}
      modifies Modifies - {History} ,
               input.cmm.Modifies ,
               History`EncryptStructure
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.cmm.Modifies
      ensures
        && ValidState()
      ensures EncryptStructureEnsuresPublicly(input, output)
      ensures History.EncryptStructure == old(History.EncryptStructure) + [DafnyCallEvent(input, output)]

    predicate DecryptStructureEnsuresPublicly(input: DecryptStructureInput , output: Result<DecryptStructureOutput, Error>)
    // The public method to be called by library consumers
    method DecryptStructure ( input: DecryptStructureInput )
      returns (output: Result<DecryptStructureOutput, Error>)
      requires
        && ValidState()
        && input.cmm.ValidState()
        && input.cmm.Modifies !! {History}
      modifies Modifies - {History} ,
               input.cmm.Modifies ,
               History`DecryptStructure
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.cmm.Modifies
      ensures
        && ValidState()
      ensures DecryptStructureEnsuresPublicly(input, output)
      ensures History.DecryptStructure == old(History.DecryptStructure) + [DafnyCallEvent(input, output)]

    predicate EncryptPathStructureEnsuresPublicly(input: EncryptPathStructureInput , output: Result<EncryptPathStructureOutput, Error>)
    // The public method to be called by library consumers
    method EncryptPathStructure ( input: EncryptPathStructureInput )
      returns (output: Result<EncryptPathStructureOutput, Error>)
      requires
        && ValidState()
        && input.cmm.ValidState()
        && input.cmm.Modifies !! {History}
      modifies Modifies - {History} ,
               input.cmm.Modifies ,
               History`EncryptPathStructure
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.cmm.Modifies
      ensures
        && ValidState()
      ensures EncryptPathStructureEnsuresPublicly(input, output)
      ensures History.EncryptPathStructure == old(History.EncryptPathStructure) + [DafnyCallEvent(input, output)]

    predicate DecryptPathStructureEnsuresPublicly(input: DecryptPathStructureInput , output: Result<DecryptPathStructureOutput, Error>)
    // The public method to be called by library consumers
    method DecryptPathStructure ( input: DecryptPathStructureInput )
      returns (output: Result<DecryptPathStructureOutput, Error>)
      requires
        && ValidState()
        && input.cmm.ValidState()
        && input.cmm.Modifies !! {History}
      modifies Modifies - {History} ,
               input.cmm.Modifies ,
               History`DecryptPathStructure
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.cmm.Modifies
      ensures
        && ValidState()
      ensures DecryptPathStructureEnsuresPublicly(input, output)
      ensures History.DecryptPathStructure == old(History.DecryptPathStructure) + [DafnyCallEvent(input, output)]

    predicate ResolveAuthActionsEnsuresPublicly(input: ResolveAuthActionsInput , output: Result<ResolveAuthActionsOutput, Error>)
    // The public method to be called by library consumers
    method ResolveAuthActions ( input: ResolveAuthActionsInput )
      returns (output: Result<ResolveAuthActionsOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`ResolveAuthActions
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures ResolveAuthActionsEnsuresPublicly(input, output)
      ensures History.ResolveAuthActions == old(History.ResolveAuthActions) + [DafnyCallEvent(input, output)]

  }
  datatype StructuredEncryptionConfig = | StructuredEncryptionConfig (

                                        )
  datatype StructureSegment = | StructureSegment (
    nameonly key: string
  )
  type TerminalTypeId = x: seq<uint8> | IsValid_TerminalTypeId(x) witness *
  predicate method IsValid_TerminalTypeId(x: seq<uint8>) {
    ( 2 <= |x| <= 2 )
  }
  type TerminalValue = seq<uint8>
  datatype Error =
      // Local Error structures are listed here
    | StructuredEncryptionException (
        nameonly message: string
      )
      // Any dependent models are listed here
    | AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders: AwsCryptographyMaterialProvidersTypes.Error)
    | AwsCryptographyPrimitives(AwsCryptographyPrimitives: AwsCryptographyPrimitivesTypes.Error)
      // The Collection error is used to collect several errors together
      // This is useful when composing OR logic.
      // Consider the following method:
      // 
      // method FN<I, O>(n:I)
      //   returns (res: Result<O, Types.Error>)
      //   ensures A(I).Success? ==> res.Success?
      //   ensures B(I).Success? ==> res.Success?
      //   ensures A(I).Failure? && B(I).Failure? ==> res.Failure?
      // 
      // If either A || B is successful then FN is successful.
      // And if A && B fail then FN will fail.
      // But what information should FN transmit back to the caller?
      // While it may be correct to hide these details from the caller,
      // this can not be the globally correct option.
      // Suppose that A and B can be blocked by different ACLs,
      // and that their representation of I is only eventually consistent.
      // How can the caller distinguish, at a minimum for logging,
      // the difference between the four failure modes?
    // || (!access(A(I)) && !access(B(I)))
    // || (!exit(A(I)) && !exit(B(I)))
    // || (!access(A(I)) && !exit(B(I)))
    // || (!exit(A(I)) && !access(B(I)))
    | CollectionOfErrors(list: seq<Error>, nameonly message: string)
      // The Opaque error, used for native, extern, wrapped or unknown errors
    | Opaque(obj: object)
      // A better Opaque, with a visible string representation.
    | OpaqueWithText(obj: object, objMessage : string)
  type OpaqueError = e: Error | e.Opaque? || e.OpaqueWithText? witness *
  // This dummy subset type is included to make sure Dafny
  // always generates a _ExternBase___default.java class.
  type DummySubsetType = x: int | IsDummySubsetType(x) witness 1
  predicate method IsDummySubsetType(x: int) {
    0 < x
  }

}
abstract module AbstractAwsCryptographyDbEncryptionSdkStructuredEncryptionService
{
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import opened Types = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import Operations : AbstractAwsCryptographyDbEncryptionSdkStructuredEncryptionOperations
  function method DefaultStructuredEncryptionConfig(): StructuredEncryptionConfig
  method StructuredEncryption(config: StructuredEncryptionConfig := DefaultStructuredEncryptionConfig())
    returns (res: Result<StructuredEncryptionClient, Error>)
    ensures res.Success? ==>
              && fresh(res.value)
              && fresh(res.value.Modifies)
              && fresh(res.value.History)
              && res.value.ValidState()

  // Helper functions for the benefit of native code to create a Success(client) without referring to Dafny internals
  function method CreateSuccessOfClient(client: IStructuredEncryptionClient): Result<IStructuredEncryptionClient, Error> {
    Success(client)
  }
  function method CreateFailureOfError(error: Error): Result<IStructuredEncryptionClient, Error> {
    Failure(error)
  }
  class StructuredEncryptionClient extends IStructuredEncryptionClient
  {
    constructor(config: Operations.InternalConfig)
      requires Operations.ValidInternalConfig?(config)
      ensures
        && ValidState()
        && fresh(History)
        && this.config == config
    const config: Operations.InternalConfig
    predicate ValidState()
      ensures ValidState() ==>
                && Operations.ValidInternalConfig?(config)
                && History !in Operations.ModifiesInternalConfig(config)
                && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    predicate EncryptStructureEnsuresPublicly(input: EncryptStructureInput , output: Result<EncryptStructureOutput, Error>)
    {Operations.EncryptStructureEnsuresPublicly(input, output)}
    // The public method to be called by library consumers
    method EncryptStructure ( input: EncryptStructureInput )
      returns (output: Result<EncryptStructureOutput, Error>)
      requires
        && ValidState()
        && input.cmm.ValidState()
        && input.cmm.Modifies !! {History}
      modifies Modifies - {History} ,
               input.cmm.Modifies ,
               History`EncryptStructure
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.cmm.Modifies
      ensures
        && ValidState()
      ensures EncryptStructureEnsuresPublicly(input, output)
      ensures History.EncryptStructure == old(History.EncryptStructure) + [DafnyCallEvent(input, output)]
    {
      output := Operations.EncryptStructure(config, input);
      History.EncryptStructure := History.EncryptStructure + [DafnyCallEvent(input, output)];
    }

    predicate DecryptStructureEnsuresPublicly(input: DecryptStructureInput , output: Result<DecryptStructureOutput, Error>)
    {Operations.DecryptStructureEnsuresPublicly(input, output)}
    // The public method to be called by library consumers
    method DecryptStructure ( input: DecryptStructureInput )
      returns (output: Result<DecryptStructureOutput, Error>)
      requires
        && ValidState()
        && input.cmm.ValidState()
        && input.cmm.Modifies !! {History}
      modifies Modifies - {History} ,
               input.cmm.Modifies ,
               History`DecryptStructure
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.cmm.Modifies
      ensures
        && ValidState()
      ensures DecryptStructureEnsuresPublicly(input, output)
      ensures History.DecryptStructure == old(History.DecryptStructure) + [DafnyCallEvent(input, output)]
    {
      output := Operations.DecryptStructure(config, input);
      History.DecryptStructure := History.DecryptStructure + [DafnyCallEvent(input, output)];
    }

    predicate EncryptPathStructureEnsuresPublicly(input: EncryptPathStructureInput , output: Result<EncryptPathStructureOutput, Error>)
    {Operations.EncryptPathStructureEnsuresPublicly(input, output)}
    // The public method to be called by library consumers
    method EncryptPathStructure ( input: EncryptPathStructureInput )
      returns (output: Result<EncryptPathStructureOutput, Error>)
      requires
        && ValidState()
        && input.cmm.ValidState()
        && input.cmm.Modifies !! {History}
      modifies Modifies - {History} ,
               input.cmm.Modifies ,
               History`EncryptPathStructure
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.cmm.Modifies
      ensures
        && ValidState()
      ensures EncryptPathStructureEnsuresPublicly(input, output)
      ensures History.EncryptPathStructure == old(History.EncryptPathStructure) + [DafnyCallEvent(input, output)]
    {
      output := Operations.EncryptPathStructure(config, input);
      History.EncryptPathStructure := History.EncryptPathStructure + [DafnyCallEvent(input, output)];
    }

    predicate DecryptPathStructureEnsuresPublicly(input: DecryptPathStructureInput , output: Result<DecryptPathStructureOutput, Error>)
    {Operations.DecryptPathStructureEnsuresPublicly(input, output)}
    // The public method to be called by library consumers
    method DecryptPathStructure ( input: DecryptPathStructureInput )
      returns (output: Result<DecryptPathStructureOutput, Error>)
      requires
        && ValidState()
        && input.cmm.ValidState()
        && input.cmm.Modifies !! {History}
      modifies Modifies - {History} ,
               input.cmm.Modifies ,
               History`DecryptPathStructure
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.cmm.Modifies
      ensures
        && ValidState()
      ensures DecryptPathStructureEnsuresPublicly(input, output)
      ensures History.DecryptPathStructure == old(History.DecryptPathStructure) + [DafnyCallEvent(input, output)]
    {
      output := Operations.DecryptPathStructure(config, input);
      History.DecryptPathStructure := History.DecryptPathStructure + [DafnyCallEvent(input, output)];
    }

    predicate ResolveAuthActionsEnsuresPublicly(input: ResolveAuthActionsInput , output: Result<ResolveAuthActionsOutput, Error>)
    {Operations.ResolveAuthActionsEnsuresPublicly(input, output)}
    // The public method to be called by library consumers
    method ResolveAuthActions ( input: ResolveAuthActionsInput )
      returns (output: Result<ResolveAuthActionsOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`ResolveAuthActions
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures ResolveAuthActionsEnsuresPublicly(input, output)
      ensures History.ResolveAuthActions == old(History.ResolveAuthActions) + [DafnyCallEvent(input, output)]
    {
      output := Operations.ResolveAuthActions(config, input);
      History.ResolveAuthActions := History.ResolveAuthActions + [DafnyCallEvent(input, output)];
    }

  }
}
abstract module AbstractAwsCryptographyDbEncryptionSdkStructuredEncryptionOperations {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import opened Types = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  type InternalConfig
  predicate ValidInternalConfig?(config: InternalConfig)
  function ModifiesInternalConfig(config: InternalConfig): set<object>
  predicate EncryptStructureEnsuresPublicly(input: EncryptStructureInput , output: Result<EncryptStructureOutput, Error>)
  // The private method to be refined by the library developer


  method EncryptStructure ( config: InternalConfig , input: EncryptStructureInput )
    returns (output: Result<EncryptStructureOutput, Error>)
    requires
      && ValidInternalConfig?(config)
      && input.cmm.ValidState()
    modifies ModifiesInternalConfig(config) ,
             input.cmm.Modifies
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config) ,
              input.cmm.Modifies
    ensures
      && ValidInternalConfig?(config)
    ensures EncryptStructureEnsuresPublicly(input, output)


  predicate DecryptStructureEnsuresPublicly(input: DecryptStructureInput , output: Result<DecryptStructureOutput, Error>)
  // The private method to be refined by the library developer


  method DecryptStructure ( config: InternalConfig , input: DecryptStructureInput )
    returns (output: Result<DecryptStructureOutput, Error>)
    requires
      && ValidInternalConfig?(config)
      && input.cmm.ValidState()
    modifies ModifiesInternalConfig(config) ,
             input.cmm.Modifies
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config) ,
              input.cmm.Modifies
    ensures
      && ValidInternalConfig?(config)
    ensures DecryptStructureEnsuresPublicly(input, output)


  predicate EncryptPathStructureEnsuresPublicly(input: EncryptPathStructureInput , output: Result<EncryptPathStructureOutput, Error>)
  // The private method to be refined by the library developer


  method EncryptPathStructure ( config: InternalConfig , input: EncryptPathStructureInput )
    returns (output: Result<EncryptPathStructureOutput, Error>)
    requires
      && ValidInternalConfig?(config)
      && input.cmm.ValidState()
    modifies ModifiesInternalConfig(config) ,
             input.cmm.Modifies
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config) ,
              input.cmm.Modifies
    ensures
      && ValidInternalConfig?(config)
    ensures EncryptPathStructureEnsuresPublicly(input, output)


  predicate DecryptPathStructureEnsuresPublicly(input: DecryptPathStructureInput , output: Result<DecryptPathStructureOutput, Error>)
  // The private method to be refined by the library developer


  method DecryptPathStructure ( config: InternalConfig , input: DecryptPathStructureInput )
    returns (output: Result<DecryptPathStructureOutput, Error>)
    requires
      && ValidInternalConfig?(config)
      && input.cmm.ValidState()
    modifies ModifiesInternalConfig(config) ,
             input.cmm.Modifies
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config) ,
              input.cmm.Modifies
    ensures
      && ValidInternalConfig?(config)
    ensures DecryptPathStructureEnsuresPublicly(input, output)


  predicate ResolveAuthActionsEnsuresPublicly(input: ResolveAuthActionsInput , output: Result<ResolveAuthActionsOutput, Error>)
  // The private method to be refined by the library developer


  method ResolveAuthActions ( config: InternalConfig , input: ResolveAuthActionsInput )
    returns (output: Result<ResolveAuthActionsOutput, Error>)
    requires
      && ValidInternalConfig?(config)
    modifies ModifiesInternalConfig(config)
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config)
    ensures
      && ValidInternalConfig?(config)
    ensures ResolveAuthActionsEnsuresPublicly(input, output)
}
