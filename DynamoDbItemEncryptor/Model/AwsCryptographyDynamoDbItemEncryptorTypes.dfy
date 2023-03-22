// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/Index.dfy"
 include "../../StructuredEncryption/src/Index.dfy"
 include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"
 include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographyPrimitives/src/Index.dfy"
 include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/src/Index.dfy"
 module {:extern "Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types" } AwsCryptographyDynamoDbItemEncryptorTypes
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import AwsCryptographyStructuredEncryptionTypes
 import AwsCryptographyMaterialProvidersTypes
 import AwsCryptographyPrimitivesTypes
 import ComAmazonawsDynamodbTypes
 // Generic helpers for verification of mock/unit tests.
 datatype DafnyCallEvent<I, O> = DafnyCallEvent(input: I, output: O)
 
 // Begin Generated Types
 
 type AttributeActions = map<ComAmazonawsDynamodbTypes.AttributeName, AwsCryptographyStructuredEncryptionTypes.CryptoAction>
 datatype DecryptItemInput = | DecryptItemInput (
 nameonly encryptedItem: ComAmazonawsDynamodbTypes.AttributeMap
 )
 datatype DecryptItemOutput = | DecryptItemOutput (
 nameonly plaintextItem: ComAmazonawsDynamodbTypes.AttributeMap
 )
 class IDynamoDbItemEncryptorClientCallHistory {
 ghost constructor() {
 EncryptItem := [];
 DecryptItem := [];
}
 ghost var EncryptItem: seq<DafnyCallEvent<EncryptItemInput, Result<EncryptItemOutput, Error>>>
 ghost var DecryptItem: seq<DafnyCallEvent<DecryptItemInput, Result<DecryptItemOutput, Error>>>
}
 trait {:termination false} IDynamoDbItemEncryptorClient
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
  ghost const History: IDynamoDbItemEncryptorClientCallHistory
 predicate EncryptItemEnsuresPublicly(input: EncryptItemInput , output: Result<EncryptItemOutput, Error>)
 // The public method to be called by library consumers
 method EncryptItem ( input: EncryptItemInput )
 returns (output: Result<EncryptItemOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`EncryptItem
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures EncryptItemEnsuresPublicly(input, output)
 ensures History.EncryptItem == old(History.EncryptItem) + [DafnyCallEvent(input, output)]
 
 predicate DecryptItemEnsuresPublicly(input: DecryptItemInput , output: Result<DecryptItemOutput, Error>)
 // The public method to be called by library consumers
 method DecryptItem ( input: DecryptItemInput )
 returns (output: Result<DecryptItemOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`DecryptItem
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures DecryptItemEnsuresPublicly(input, output)
 ensures History.DecryptItem == old(History.DecryptItem) + [DafnyCallEvent(input, output)]
 
}
 datatype DynamoDbItemEncryptorConfig = | DynamoDbItemEncryptorConfig (
 nameonly tableName: ComAmazonawsDynamodbTypes.TableName ,
 nameonly partitionKeyName: ComAmazonawsDynamodbTypes.KeySchemaAttributeName ,
 nameonly sortKeyName: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName> ,
 nameonly attributeActions: AttributeActions ,
 nameonly allowedUnauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList> ,
 nameonly allowedUnauthenticatedAttributePrefix: Option<string> ,
 nameonly algorithmSuiteId: Option<AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId> ,
 nameonly keyring: Option<AwsCryptographyMaterialProvidersTypes.IKeyring> ,
 nameonly cmm: Option<AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager>
 )
 datatype EncryptItemInput = | EncryptItemInput (
 nameonly plaintextItem: ComAmazonawsDynamodbTypes.AttributeMap
 )
 datatype EncryptItemOutput = | EncryptItemOutput (
 nameonly encryptedItem: ComAmazonawsDynamodbTypes.AttributeMap
 )
 datatype Error =
 // Local Error structures are listed here
 | DynamoDbItemEncryptorException (
 nameonly message: string
 )
 // Any dependent models are listed here
 | AwsCryptographyStructuredEncryption(AwsCryptographyStructuredEncryption: AwsCryptographyStructuredEncryptionTypes.Error)
 | AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders: AwsCryptographyMaterialProvidersTypes.Error)
 | AwsCryptographyPrimitives(AwsCryptographyPrimitives: AwsCryptographyPrimitivesTypes.Error)
 | ComAmazonawsDynamodb(ComAmazonawsDynamodb: ComAmazonawsDynamodbTypes.Error)
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
 abstract module AbstractAwsCryptographyDynamoDbItemEncryptorService
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDynamoDbItemEncryptorTypes
 import Operations : AbstractAwsCryptographyDynamoDbItemEncryptorOperations
 function method DefaultDynamoDbItemEncryptorConfig(): DynamoDbItemEncryptorConfig
 method DynamoDbItemEncryptor(config: DynamoDbItemEncryptorConfig := DefaultDynamoDbItemEncryptorConfig())
 returns (res: Result<DynamoDbItemEncryptorClient, Error>)
 requires config.cmm.Some? ==> config.cmm.value.ValidState()
 requires config.keyring.Some? ==> config.keyring.value.ValidState()
 modifies if config.cmm.Some? then config.cmm.value.Modifies else {}
 modifies if config.keyring.Some? then config.keyring.value.Modifies else {}
 ensures res.Success? ==> 
 && fresh(res.value)
 && fresh(res.value.Modifies
 - (if config.cmm.Some? then config.cmm.value.Modifies else {})
 - (if config.keyring.Some? then config.keyring.value.Modifies else {})
 )
 && fresh(res.value.History)
 && res.value.ValidState()
 ensures config.cmm.Some? ==> config.cmm.value.ValidState()
 ensures config.keyring.Some? ==> config.keyring.value.ValidState()

 class DynamoDbItemEncryptorClient extends IDynamoDbItemEncryptorClient
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
 predicate EncryptItemEnsuresPublicly(input: EncryptItemInput , output: Result<EncryptItemOutput, Error>)
 {Operations.EncryptItemEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method EncryptItem ( input: EncryptItemInput )
 returns (output: Result<EncryptItemOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`EncryptItem
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures EncryptItemEnsuresPublicly(input, output)
 ensures History.EncryptItem == old(History.EncryptItem) + [DafnyCallEvent(input, output)]
 {
 output := Operations.EncryptItem(config, input);
 History.EncryptItem := History.EncryptItem + [DafnyCallEvent(input, output)];
}
 
 predicate DecryptItemEnsuresPublicly(input: DecryptItemInput , output: Result<DecryptItemOutput, Error>)
 {Operations.DecryptItemEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method DecryptItem ( input: DecryptItemInput )
 returns (output: Result<DecryptItemOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`DecryptItem
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures DecryptItemEnsuresPublicly(input, output)
 ensures History.DecryptItem == old(History.DecryptItem) + [DafnyCallEvent(input, output)]
 {
 output := Operations.DecryptItem(config, input);
 History.DecryptItem := History.DecryptItem + [DafnyCallEvent(input, output)];
}
 
}
}
 abstract module AbstractAwsCryptographyDynamoDbItemEncryptorOperations {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDynamoDbItemEncryptorTypes
 type InternalConfig
 predicate ValidInternalConfig?(config: InternalConfig)
 function ModifiesInternalConfig(config: InternalConfig): set<object>
 predicate EncryptItemEnsuresPublicly(input: EncryptItemInput , output: Result<EncryptItemOutput, Error>)
 // The private method to be refined by the library developer


 method EncryptItem ( config: InternalConfig , input: EncryptItemInput )
 returns (output: Result<EncryptItemOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures EncryptItemEnsuresPublicly(input, output)


 predicate DecryptItemEnsuresPublicly(input: DecryptItemInput , output: Result<DecryptItemOutput, Error>)
 // The private method to be refined by the library developer


 method DecryptItem ( config: InternalConfig , input: DecryptItemInput )
 returns (output: Result<DecryptItemOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures DecryptItemEnsuresPublicly(input, output)
}
