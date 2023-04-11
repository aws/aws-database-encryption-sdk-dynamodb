// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
 include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy"
 include "../../../../submodules/MaterialProviders/AwsCryptographyPrimitives/src/Index.dfy"
 module {:extern "Dafny.Aws.Cryptography.StructuredEncryption.Types" } AwsCryptographyStructuredEncryptionTypes
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
 datatype AuthenticateSchema = | AuthenticateSchema (
 nameonly content: AuthenticateSchemaContent ,
 nameonly attributes: Option<AuthenticateSchemaAttributes>
 )
 type AuthenticateSchemaAttributes = map<string, AuthenticateAction>
 datatype AuthenticateSchemaContent =
 | Action(Action: AuthenticateAction)
 | SchemaMap(SchemaMap: AuthenticateSchemaMap)
 | SchemaList(SchemaList: AuthenticateSchemaList)
 type AuthenticateSchemaList = seq<AuthenticateSchema>
 type AuthenticateSchemaMap = map<string, AuthenticateSchema>
 datatype CryptoAction =
	| ENCRYPT_AND_SIGN
	| SIGN_ONLY
	| DO_NOTHING
 datatype CryptoSchema = | CryptoSchema (
 nameonly content: CryptoSchemaContent ,
 nameonly attributes: Option<CryptoSchemaAttributes>
 )
 type CryptoSchemaAttributes = map<string, AuthenticateAction>
 datatype CryptoSchemaContent =
 | Action(Action: CryptoAction)
 | SchemaMap(SchemaMap: CryptoSchemaMap)
 | SchemaList(SchemaList: CryptoSchemaList)
 type CryptoSchemaList = seq<CryptoSchema>
 type CryptoSchemaMap = map<string, CryptoSchema>
 datatype DecryptStructureInput = | DecryptStructureInput (
 nameonly tableName: string ,
 nameonly encryptedStructure: StructuredData ,
 nameonly authenticateSchema: AuthenticateSchema ,
 nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager ,
 nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext>
 )
 datatype DecryptStructureOutput = | DecryptStructureOutput (
 nameonly plaintextStructure: StructuredData ,
 nameonly parsedHeader: ParsedHeader
 )
 datatype EncryptStructureInput = | EncryptStructureInput (
 nameonly tableName: string ,
 nameonly plaintextStructure: StructuredData ,
 nameonly cryptoSchema: CryptoSchema ,
 nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager ,
 nameonly algorithmSuiteId: Option<AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId> ,
 nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext>
 )
 datatype EncryptStructureOutput = | EncryptStructureOutput (
 nameonly encryptedStructure: StructuredData
 )
 datatype ParsedHeader = | ParsedHeader (
 nameonly cryptoSchema: CryptoSchema ,
 nameonly algorithmSuiteId: AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId ,
 nameonly encryptedDataKeys: AwsCryptographyMaterialProvidersTypes.EncryptedDataKeyList ,
 nameonly storedEncryptionContext: AwsCryptographyMaterialProvidersTypes.EncryptionContext
 )
 datatype StructuredData = | StructuredData (
 nameonly content: StructuredDataContent ,
 nameonly attributes: Option<StructuredDataAttributes>
 )
 type StructuredDataAttributes = map<string, StructuredDataTerminal>
 datatype StructuredDataContent =
 | Terminal(Terminal: StructuredDataTerminal)
 | DataList(DataList: StructuredDataList)
 | DataMap(DataMap: StructuredDataMap)
 type StructuredDataList = seq<StructuredData>
 type StructuredDataMap = map<string, StructuredData>
 datatype StructuredDataTerminal = | StructuredDataTerminal (
 nameonly value: TerminalValue ,
 nameonly typeId: TerminalTypeId
 )
 class IStructuredEncryptionClientCallHistory {
 ghost constructor() {
 EncryptStructure := [];
 DecryptStructure := [];
}
 ghost var EncryptStructure: seq<DafnyCallEvent<EncryptStructureInput, Result<EncryptStructureOutput, Error>>>
 ghost var DecryptStructure: seq<DafnyCallEvent<DecryptStructureInput, Result<DecryptStructureOutput, Error>>>
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
 
}
 datatype StructuredEncryptionConfig = | StructuredEncryptionConfig (
 
 )
 type TerminalTypeId = x: seq<uint8> | IsValid_TerminalTypeId(x) witness *
 predicate method IsValid_TerminalTypeId(x: seq<uint8>) {
 ( 2 <= |x| <= 2 )
}
 type TerminalValue = seq<uint8>
 type Version = x: int32 | IsValid_Version(x) witness *
 predicate method IsValid_Version(x: int32) {
 ( 1 <= x <= 1 )
}
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
 | CollectionOfErrors(list: seq<Error>)
 // The Opaque error, used for native, extern, wrapped or unknown errors
 | Opaque(obj: object)
 type OpaqueError = e: Error | e.Opaque? witness *
}
 abstract module AbstractAwsCryptographyStructuredEncryptionService
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyStructuredEncryptionTypes
 import Operations : AbstractAwsCryptographyStructuredEncryptionOperations
 function method DefaultStructuredEncryptionConfig(): StructuredEncryptionConfig
 method StructuredEncryption(config: StructuredEncryptionConfig := DefaultStructuredEncryptionConfig())
 returns (res: Result<StructuredEncryptionClient, Error>)
 ensures res.Success? ==> 
 && fresh(res.value)
 && fresh(res.value.Modifies)
 && fresh(res.value.History)
 && res.value.ValidState()

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
 
}
}
 abstract module AbstractAwsCryptographyStructuredEncryptionOperations {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyStructuredEncryptionTypes
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
}
