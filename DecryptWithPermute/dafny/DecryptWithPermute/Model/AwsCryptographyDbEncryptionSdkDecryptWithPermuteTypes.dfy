// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
 include "../../../../DynamoDbEncryption/dafny/DynamoDbEncryption/src/Index.dfy"
 include "../../../../DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy"
 include "../../../../DynamoDbEncryption/dafny/StructuredEncryption/src/Index.dfy"
 include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy"
 module {:extern "software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types" } AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import AwsCryptographyDbEncryptionSdkDynamoDbTypes
 import AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
 import AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
 import AwsCryptographyMaterialProvidersTypes
 // Generic helpers for verification of mock/unit tests.
 datatype DafnyCallEvent<I, O> = DafnyCallEvent(input: I, output: O)
 
 // Begin Generated Types
 
 class IDynamoDbPermuteDecryptorClientCallHistory {
 ghost constructor() {
 PermuteDecrypt := [];
}
 ghost var PermuteDecrypt: seq<DafnyCallEvent<PermuteDecryptInput, Result<PermuteDecryptOutput, Error>>>
}
 trait {:termination false} IDynamoDbPermuteDecryptorClient
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
  ghost const History: IDynamoDbPermuteDecryptorClientCallHistory
 predicate PermuteDecryptEnsuresPublicly(input: PermuteDecryptInput , output: Result<PermuteDecryptOutput, Error>)
 // The public method to be called by library consumers
 method PermuteDecrypt ( input: PermuteDecryptInput )
 returns (output: Result<PermuteDecryptOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`PermuteDecrypt
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures PermuteDecryptEnsuresPublicly(input, output)
 ensures History.PermuteDecrypt == old(History.PermuteDecrypt) + [DafnyCallEvent(input, output)]
 
}
 datatype DynamoDbPermuteDecryptorConfig = | DynamoDbPermuteDecryptorConfig (
 nameonly inner: AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
 )
 datatype PermuteDecryptInput = | PermuteDecryptInput (
 nameonly inner: AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemInput ,
 nameonly maxSetSize: int32
 )
 datatype PermuteDecryptOutput = | PermuteDecryptOutput (
 nameonly inner: AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput ,
 nameonly didPermute: bool
 )
 datatype Error =
 // Local Error structures are listed here
 | DynamoDbPermuteDecryptorException (
 nameonly message: string
 )
 // Any dependent models are listed here
 | AwsCryptographyDbEncryptionSdkDynamoDb(AwsCryptographyDbEncryptionSdkDynamoDb: AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)
 | AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor: AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error)
 | AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryption: AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error)
 | AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders: AwsCryptographyMaterialProvidersTypes.Error)
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
 type OpaqueError = e: Error | e.Opaque? witness *
}
 abstract module AbstractAwsCryptographyDbEncryptionSdkDecryptWithPermuteService
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes
 import Operations : AbstractAwsCryptographyDbEncryptionSdkDecryptWithPermuteOperations
 function method DefaultDynamoDbPermuteDecryptorConfig(): DynamoDbPermuteDecryptorConfig
 method DynamoDbPermuteDecryptor(config: DynamoDbPermuteDecryptorConfig := DefaultDynamoDbPermuteDecryptorConfig())
 returns (res: Result<DynamoDbPermuteDecryptorClient, Error>)
 requires config.inner.keyring.Some? ==>
 config.inner.keyring.value.ValidState()
 requires config.inner.cmm.Some? ==>
 config.inner.cmm.value.ValidState()
 requires config.inner.legacyOverride.Some? ==>
 config.inner.legacyOverride.value.encryptor.ValidState()
 modifies if config.inner.keyring.Some? then 
 config.inner.keyring.value.Modifies
 else {}
 modifies if config.inner.cmm.Some? then 
 config.inner.cmm.value.Modifies
 else {}
 modifies if config.inner.legacyOverride.Some? then 
 config.inner.legacyOverride.value.encryptor.Modifies
 else {}
 ensures res.Success? ==> 
 && fresh(res.value)
 && fresh(res.value.Modifies
 - ( if config.inner.keyring.Some? then 
 config.inner.keyring.value.Modifies
 else {}
 ) - ( if config.inner.cmm.Some? then 
 config.inner.cmm.value.Modifies
 else {}
 ) - ( if config.inner.legacyOverride.Some? then 
 config.inner.legacyOverride.value.encryptor.Modifies
 else {}
 ) )
 && fresh(res.value.History)
 && res.value.ValidState()
 ensures config.inner.keyring.Some? ==>
 config.inner.keyring.value.ValidState()
 ensures config.inner.cmm.Some? ==>
 config.inner.cmm.value.ValidState()
 ensures config.inner.legacyOverride.Some? ==>
 config.inner.legacyOverride.value.encryptor.ValidState()

 class DynamoDbPermuteDecryptorClient extends IDynamoDbPermuteDecryptorClient
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
 predicate PermuteDecryptEnsuresPublicly(input: PermuteDecryptInput , output: Result<PermuteDecryptOutput, Error>)
 {Operations.PermuteDecryptEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method PermuteDecrypt ( input: PermuteDecryptInput )
 returns (output: Result<PermuteDecryptOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`PermuteDecrypt
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures PermuteDecryptEnsuresPublicly(input, output)
 ensures History.PermuteDecrypt == old(History.PermuteDecrypt) + [DafnyCallEvent(input, output)]
 {
 output := Operations.PermuteDecrypt(config, input);
 History.PermuteDecrypt := History.PermuteDecrypt + [DafnyCallEvent(input, output)];
}
 
}
}
 abstract module AbstractAwsCryptographyDbEncryptionSdkDecryptWithPermuteOperations {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes
 type InternalConfig
 predicate ValidInternalConfig?(config: InternalConfig)
 function ModifiesInternalConfig(config: InternalConfig): set<object>
 predicate PermuteDecryptEnsuresPublicly(input: PermuteDecryptInput , output: Result<PermuteDecryptOutput, Error>)
 // The private method to be refined by the library developer


 method PermuteDecrypt ( config: InternalConfig , input: PermuteDecryptInput )
 returns (output: Result<PermuteDecryptOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures PermuteDecryptEnsuresPublicly(input, output)
}
