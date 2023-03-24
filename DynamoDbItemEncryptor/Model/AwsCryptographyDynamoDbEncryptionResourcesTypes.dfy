// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/Index.dfy"
 include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"
 include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/src/Index.dfy"
 module {:extern "Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types" } AwsCryptographyDynamoDbEncryptionResourcesTypes
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import AwsCryptographyMaterialProvidersTypes
 import ComAmazonawsDynamodbTypes
 // Generic helpers for verification of mock/unit tests.
 datatype DafnyCallEvent<I, O> = DafnyCallEvent(input: I, output: O)
 
 // Begin Generated Types
 
 datatype CreateDynamoDbEncryptionBranchKeyIdSupplierInput = | CreateDynamoDbEncryptionBranchKeyIdSupplierInput (
 nameonly ddbItemBranchKeyIdSupplier: IDynamoDbItemBranchKeyIdSupplier
 )
 datatype CreateDynamoDbEncryptionBranchKeyIdSupplierOutput = | CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (
 nameonly branchKeyIdSupplier: AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplier
 )
 class IDynamoDbEncryptionResourcesClientCallHistory {
 ghost constructor() {
 CreateDynamoDbEncryptionBranchKeyIdSupplier := [];
}
 ghost var CreateDynamoDbEncryptionBranchKeyIdSupplier: seq<DafnyCallEvent<CreateDynamoDbEncryptionBranchKeyIdSupplierInput, Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>>>
}
 trait {:termination false} IDynamoDbEncryptionResourcesClient
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
  ghost const History: IDynamoDbEncryptionResourcesClientCallHistory
 predicate CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput , output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
 // The public method to be called by library consumers
 method CreateDynamoDbEncryptionBranchKeyIdSupplier ( input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput )
 returns (output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
 requires
 && ValidState()
 && input.ddbItemBranchKeyIdSupplier.ValidState()
 && input.ddbItemBranchKeyIdSupplier.Modifies !! {History}
 modifies Modifies - {History} ,
 input.ddbItemBranchKeyIdSupplier.Modifies ,
 History`CreateDynamoDbEncryptionBranchKeyIdSupplier
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History} ,
 input.ddbItemBranchKeyIdSupplier.Modifies
 ensures
 && ValidState()
 && ( output.Success? ==> 
 && output.value.branchKeyIdSupplier.ValidState()
 && output.value.branchKeyIdSupplier.Modifies !! {History}
 && fresh(output.value.branchKeyIdSupplier)
 && fresh ( output.value.branchKeyIdSupplier.Modifies - Modifies - {History} - input.ddbItemBranchKeyIdSupplier.Modifies ) )
 ensures CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input, output)
 ensures History.CreateDynamoDbEncryptionBranchKeyIdSupplier == old(History.CreateDynamoDbEncryptionBranchKeyIdSupplier) + [DafnyCallEvent(input, output)]
 
}
 datatype DynamoDbEncryptionResourcesConfig = | DynamoDbEncryptionResourcesConfig (
 
 )
 class IDynamoDbItemBranchKeyIdSupplierCallHistory {
 ghost constructor() {
 GetBranchKeyIdFromItem := [];
}
 ghost var GetBranchKeyIdFromItem: seq<DafnyCallEvent<GetBranchKeyIdFromItemInput, Result<GetBranchKeyIdFromItemOutput, Error>>>
}
 trait {:termination false} IDynamoDbItemBranchKeyIdSupplier
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
  ghost const History: IDynamoDbItemBranchKeyIdSupplierCallHistory
 predicate GetBranchKeyIdFromItemEnsuresPublicly(input: GetBranchKeyIdFromItemInput , output: Result<GetBranchKeyIdFromItemOutput, Error>)
 // The public method to be called by library consumers
 method GetBranchKeyIdFromItem ( input: GetBranchKeyIdFromItemInput )
 returns (output: Result<GetBranchKeyIdFromItemOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`GetBranchKeyIdFromItem
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures GetBranchKeyIdFromItemEnsuresPublicly(input, output)
 ensures History.GetBranchKeyIdFromItem == old(History.GetBranchKeyIdFromItem) + [DafnyCallEvent(input, output)]
 {
 output := GetBranchKeyIdFromItem' (input);
 History.GetBranchKeyIdFromItem := History.GetBranchKeyIdFromItem + [DafnyCallEvent(input, output)];
}
 // The method to implement in the concrete class. 
 method GetBranchKeyIdFromItem' ( input: GetBranchKeyIdFromItemInput )
 returns (output: Result<GetBranchKeyIdFromItemOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History}
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures GetBranchKeyIdFromItemEnsuresPublicly(input, output)
 ensures unchanged(History)
 
}
 datatype GetBranchKeyIdFromItemInput = | GetBranchKeyIdFromItemInput (
 nameonly ddbItem: ComAmazonawsDynamodbTypes.AttributeMap
 )
 datatype GetBranchKeyIdFromItemOutput = | GetBranchKeyIdFromItemOutput (
 nameonly branchKeyId: string
 )
 datatype Error =
 // Local Error structures are listed here
 | DynamoDbEncryptionResourcesException (
 nameonly message: string
 )
 // Any dependent models are listed here
 | AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders: AwsCryptographyMaterialProvidersTypes.Error)
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
 abstract module AbstractAwsCryptographyDynamoDbEncryptionResourcesService
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDynamoDbEncryptionResourcesTypes
 import Operations : AbstractAwsCryptographyDynamoDbEncryptionResourcesOperations
 function method DefaultDynamoDbEncryptionResourcesConfig(): DynamoDbEncryptionResourcesConfig
 method DynamoDbEncryptionResources(config: DynamoDbEncryptionResourcesConfig := DefaultDynamoDbEncryptionResourcesConfig())
 returns (res: Result<DynamoDbEncryptionResourcesClient, Error>)
 ensures res.Success? ==> 
 && fresh(res.value)
 && fresh(res.value.Modifies)
 && fresh(res.value.History)
 && res.value.ValidState()

 class DynamoDbEncryptionResourcesClient extends IDynamoDbEncryptionResourcesClient
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
 predicate CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput , output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
 {Operations.CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method CreateDynamoDbEncryptionBranchKeyIdSupplier ( input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput )
 returns (output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
 requires
 && ValidState()
 && input.ddbItemBranchKeyIdSupplier.ValidState()
 && input.ddbItemBranchKeyIdSupplier.Modifies !! {History}
 modifies Modifies - {History} ,
 input.ddbItemBranchKeyIdSupplier.Modifies ,
 History`CreateDynamoDbEncryptionBranchKeyIdSupplier
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History} ,
 input.ddbItemBranchKeyIdSupplier.Modifies
 ensures
 && ValidState()
 && ( output.Success? ==> 
 && output.value.branchKeyIdSupplier.ValidState()
 && output.value.branchKeyIdSupplier.Modifies !! {History}
 && fresh(output.value.branchKeyIdSupplier)
 && fresh ( output.value.branchKeyIdSupplier.Modifies - Modifies - {History} - input.ddbItemBranchKeyIdSupplier.Modifies ) )
 ensures CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input, output)
 ensures History.CreateDynamoDbEncryptionBranchKeyIdSupplier == old(History.CreateDynamoDbEncryptionBranchKeyIdSupplier) + [DafnyCallEvent(input, output)]
 {
 output := Operations.CreateDynamoDbEncryptionBranchKeyIdSupplier(config, input);
 History.CreateDynamoDbEncryptionBranchKeyIdSupplier := History.CreateDynamoDbEncryptionBranchKeyIdSupplier + [DafnyCallEvent(input, output)];
}
 
}
}
 abstract module AbstractAwsCryptographyDynamoDbEncryptionResourcesOperations {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDynamoDbEncryptionResourcesTypes
 type InternalConfig
 predicate ValidInternalConfig?(config: InternalConfig)
 function ModifiesInternalConfig(config: InternalConfig): set<object>
 predicate CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput , output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
 // The private method to be refined by the library developer


 method CreateDynamoDbEncryptionBranchKeyIdSupplier ( config: InternalConfig , input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput )
 returns (output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 && input.ddbItemBranchKeyIdSupplier.ValidState()
 modifies ModifiesInternalConfig(config) ,
 input.ddbItemBranchKeyIdSupplier.Modifies
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config) ,
 input.ddbItemBranchKeyIdSupplier.Modifies
 ensures
 && ValidInternalConfig?(config)
 && ( output.Success? ==> 
 && output.value.branchKeyIdSupplier.ValidState()
 && fresh(output.value.branchKeyIdSupplier)
 && fresh ( output.value.branchKeyIdSupplier.Modifies - ModifiesInternalConfig(config) - input.ddbItemBranchKeyIdSupplier.Modifies ) )
 ensures CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input, output)
}
