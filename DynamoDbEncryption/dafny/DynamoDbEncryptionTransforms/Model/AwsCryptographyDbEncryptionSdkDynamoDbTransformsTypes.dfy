// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
 include "../../DynamoDbEncryption/src/Index.dfy"
 include "../../DynamoDbItemEncryptor/src/Index.dfy"
 include "../../StructuredEncryption/src/Index.dfy"
 include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy"
 include "../../../../submodules/MaterialProviders/ComAmazonawsDynamodb/src/Index.dfy"
 module {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types" } AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import AwsCryptographyDbEncryptionSdkDynamoDbTypes
 import AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
 import AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
 import AwsCryptographyMaterialProvidersTypes
 import ComAmazonawsDynamodbTypes
 // Generic helpers for verification of mock/unit tests.
 datatype DafnyCallEvent<I, O> = DafnyCallEvent(input: I, output: O)
 
 // Begin Generated Types
 
 datatype BatchExecuteStatementInputTransformInput = | BatchExecuteStatementInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.BatchExecuteStatementInput
 )
 datatype BatchExecuteStatementInputTransformOutput = | BatchExecuteStatementInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.BatchExecuteStatementInput
 )
 datatype BatchExecuteStatementOutputTransformInput = | BatchExecuteStatementOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.BatchExecuteStatementOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.BatchExecuteStatementInput
 )
 datatype BatchExecuteStatementOutputTransformOutput = | BatchExecuteStatementOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.BatchExecuteStatementOutput
 )
 datatype BatchGetItemInputTransformInput = | BatchGetItemInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.BatchGetItemInput
 )
 datatype BatchGetItemInputTransformOutput = | BatchGetItemInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.BatchGetItemInput
 )
 datatype BatchGetItemOutputTransformInput = | BatchGetItemOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.BatchGetItemOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.BatchGetItemInput
 )
 datatype BatchGetItemOutputTransformOutput = | BatchGetItemOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.BatchGetItemOutput
 )
 datatype BatchWriteItemInputTransformInput = | BatchWriteItemInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.BatchWriteItemInput
 )
 datatype BatchWriteItemInputTransformOutput = | BatchWriteItemInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.BatchWriteItemInput
 )
 datatype BatchWriteItemOutputTransformInput = | BatchWriteItemOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.BatchWriteItemOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.BatchWriteItemInput
 )
 datatype BatchWriteItemOutputTransformOutput = | BatchWriteItemOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.BatchWriteItemOutput
 )
 datatype DeleteItemInputTransformInput = | DeleteItemInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.DeleteItemInput
 )
 datatype DeleteItemInputTransformOutput = | DeleteItemInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.DeleteItemInput
 )
 datatype DeleteItemOutputTransformInput = | DeleteItemOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.DeleteItemOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.DeleteItemInput
 )
 datatype DeleteItemOutputTransformOutput = | DeleteItemOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.DeleteItemOutput
 )
 class IDynamoDbEncryptionTransformsClientCallHistory {
 ghost constructor() {
 PutItemInputTransform := [];
 PutItemOutputTransform := [];
 GetItemInputTransform := [];
 GetItemOutputTransform := [];
 BatchWriteItemInputTransform := [];
 BatchWriteItemOutputTransform := [];
 BatchGetItemInputTransform := [];
 BatchGetItemOutputTransform := [];
 ScanInputTransform := [];
 ScanOutputTransform := [];
 QueryInputTransform := [];
 QueryOutputTransform := [];
 TransactWriteItemsInputTransform := [];
 TransactWriteItemsOutputTransform := [];
 UpdateItemInputTransform := [];
 UpdateItemOutputTransform := [];
 DeleteItemInputTransform := [];
 DeleteItemOutputTransform := [];
 TransactGetItemsInputTransform := [];
 TransactGetItemsOutputTransform := [];
 ExecuteStatementInputTransform := [];
 ExecuteStatementOutputTransform := [];
 BatchExecuteStatementInputTransform := [];
 BatchExecuteStatementOutputTransform := [];
 ExecuteTransactionInputTransform := [];
 ExecuteTransactionOutputTransform := [];
 ResolveAttributes := [];
}
 ghost var PutItemInputTransform: seq<DafnyCallEvent<PutItemInputTransformInput, Result<PutItemInputTransformOutput, Error>>>
 ghost var PutItemOutputTransform: seq<DafnyCallEvent<PutItemOutputTransformInput, Result<PutItemOutputTransformOutput, Error>>>
 ghost var GetItemInputTransform: seq<DafnyCallEvent<GetItemInputTransformInput, Result<GetItemInputTransformOutput, Error>>>
 ghost var GetItemOutputTransform: seq<DafnyCallEvent<GetItemOutputTransformInput, Result<GetItemOutputTransformOutput, Error>>>
 ghost var BatchWriteItemInputTransform: seq<DafnyCallEvent<BatchWriteItemInputTransformInput, Result<BatchWriteItemInputTransformOutput, Error>>>
 ghost var BatchWriteItemOutputTransform: seq<DafnyCallEvent<BatchWriteItemOutputTransformInput, Result<BatchWriteItemOutputTransformOutput, Error>>>
 ghost var BatchGetItemInputTransform: seq<DafnyCallEvent<BatchGetItemInputTransformInput, Result<BatchGetItemInputTransformOutput, Error>>>
 ghost var BatchGetItemOutputTransform: seq<DafnyCallEvent<BatchGetItemOutputTransformInput, Result<BatchGetItemOutputTransformOutput, Error>>>
 ghost var ScanInputTransform: seq<DafnyCallEvent<ScanInputTransformInput, Result<ScanInputTransformOutput, Error>>>
 ghost var ScanOutputTransform: seq<DafnyCallEvent<ScanOutputTransformInput, Result<ScanOutputTransformOutput, Error>>>
 ghost var QueryInputTransform: seq<DafnyCallEvent<QueryInputTransformInput, Result<QueryInputTransformOutput, Error>>>
 ghost var QueryOutputTransform: seq<DafnyCallEvent<QueryOutputTransformInput, Result<QueryOutputTransformOutput, Error>>>
 ghost var TransactWriteItemsInputTransform: seq<DafnyCallEvent<TransactWriteItemsInputTransformInput, Result<TransactWriteItemsInputTransformOutput, Error>>>
 ghost var TransactWriteItemsOutputTransform: seq<DafnyCallEvent<TransactWriteItemsOutputTransformInput, Result<TransactWriteItemsOutputTransformOutput, Error>>>
 ghost var UpdateItemInputTransform: seq<DafnyCallEvent<UpdateItemInputTransformInput, Result<UpdateItemInputTransformOutput, Error>>>
 ghost var UpdateItemOutputTransform: seq<DafnyCallEvent<UpdateItemOutputTransformInput, Result<UpdateItemOutputTransformOutput, Error>>>
 ghost var DeleteItemInputTransform: seq<DafnyCallEvent<DeleteItemInputTransformInput, Result<DeleteItemInputTransformOutput, Error>>>
 ghost var DeleteItemOutputTransform: seq<DafnyCallEvent<DeleteItemOutputTransformInput, Result<DeleteItemOutputTransformOutput, Error>>>
 ghost var TransactGetItemsInputTransform: seq<DafnyCallEvent<TransactGetItemsInputTransformInput, Result<TransactGetItemsInputTransformOutput, Error>>>
 ghost var TransactGetItemsOutputTransform: seq<DafnyCallEvent<TransactGetItemsOutputTransformInput, Result<TransactGetItemsOutputTransformOutput, Error>>>
 ghost var ExecuteStatementInputTransform: seq<DafnyCallEvent<ExecuteStatementInputTransformInput, Result<ExecuteStatementInputTransformOutput, Error>>>
 ghost var ExecuteStatementOutputTransform: seq<DafnyCallEvent<ExecuteStatementOutputTransformInput, Result<ExecuteStatementOutputTransformOutput, Error>>>
 ghost var BatchExecuteStatementInputTransform: seq<DafnyCallEvent<BatchExecuteStatementInputTransformInput, Result<BatchExecuteStatementInputTransformOutput, Error>>>
 ghost var BatchExecuteStatementOutputTransform: seq<DafnyCallEvent<BatchExecuteStatementOutputTransformInput, Result<BatchExecuteStatementOutputTransformOutput, Error>>>
 ghost var ExecuteTransactionInputTransform: seq<DafnyCallEvent<ExecuteTransactionInputTransformInput, Result<ExecuteTransactionInputTransformOutput, Error>>>
 ghost var ExecuteTransactionOutputTransform: seq<DafnyCallEvent<ExecuteTransactionOutputTransformInput, Result<ExecuteTransactionOutputTransformOutput, Error>>>
 ghost var ResolveAttributes: seq<DafnyCallEvent<ResolveAttributesInput, Result<ResolveAttributesOutput, Error>>>
}
 trait {:termination false} IDynamoDbEncryptionTransformsClient
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
  ghost const History: IDynamoDbEncryptionTransformsClientCallHistory
 predicate PutItemInputTransformEnsuresPublicly(input: PutItemInputTransformInput , output: Result<PutItemInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method PutItemInputTransform ( input: PutItemInputTransformInput )
 returns (output: Result<PutItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`PutItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures PutItemInputTransformEnsuresPublicly(input, output)
 ensures History.PutItemInputTransform == old(History.PutItemInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate PutItemOutputTransformEnsuresPublicly(input: PutItemOutputTransformInput , output: Result<PutItemOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method PutItemOutputTransform ( input: PutItemOutputTransformInput )
 returns (output: Result<PutItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`PutItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures PutItemOutputTransformEnsuresPublicly(input, output)
 ensures History.PutItemOutputTransform == old(History.PutItemOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate GetItemInputTransformEnsuresPublicly(input: GetItemInputTransformInput , output: Result<GetItemInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method GetItemInputTransform ( input: GetItemInputTransformInput )
 returns (output: Result<GetItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`GetItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures GetItemInputTransformEnsuresPublicly(input, output)
 ensures History.GetItemInputTransform == old(History.GetItemInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate GetItemOutputTransformEnsuresPublicly(input: GetItemOutputTransformInput , output: Result<GetItemOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method GetItemOutputTransform ( input: GetItemOutputTransformInput )
 returns (output: Result<GetItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`GetItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures GetItemOutputTransformEnsuresPublicly(input, output)
 ensures History.GetItemOutputTransform == old(History.GetItemOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate BatchWriteItemInputTransformEnsuresPublicly(input: BatchWriteItemInputTransformInput , output: Result<BatchWriteItemInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method BatchWriteItemInputTransform ( input: BatchWriteItemInputTransformInput )
 returns (output: Result<BatchWriteItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchWriteItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchWriteItemInputTransformEnsuresPublicly(input, output)
 ensures History.BatchWriteItemInputTransform == old(History.BatchWriteItemInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate BatchWriteItemOutputTransformEnsuresPublicly(input: BatchWriteItemOutputTransformInput , output: Result<BatchWriteItemOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method BatchWriteItemOutputTransform ( input: BatchWriteItemOutputTransformInput )
 returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchWriteItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchWriteItemOutputTransformEnsuresPublicly(input, output)
 ensures History.BatchWriteItemOutputTransform == old(History.BatchWriteItemOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate BatchGetItemInputTransformEnsuresPublicly(input: BatchGetItemInputTransformInput , output: Result<BatchGetItemInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method BatchGetItemInputTransform ( input: BatchGetItemInputTransformInput )
 returns (output: Result<BatchGetItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchGetItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchGetItemInputTransformEnsuresPublicly(input, output)
 ensures History.BatchGetItemInputTransform == old(History.BatchGetItemInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate BatchGetItemOutputTransformEnsuresPublicly(input: BatchGetItemOutputTransformInput , output: Result<BatchGetItemOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method BatchGetItemOutputTransform ( input: BatchGetItemOutputTransformInput )
 returns (output: Result<BatchGetItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchGetItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchGetItemOutputTransformEnsuresPublicly(input, output)
 ensures History.BatchGetItemOutputTransform == old(History.BatchGetItemOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate ScanInputTransformEnsuresPublicly(input: ScanInputTransformInput , output: Result<ScanInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method ScanInputTransform ( input: ScanInputTransformInput )
 returns (output: Result<ScanInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ScanInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ScanInputTransformEnsuresPublicly(input, output)
 ensures History.ScanInputTransform == old(History.ScanInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate ScanOutputTransformEnsuresPublicly(input: ScanOutputTransformInput , output: Result<ScanOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method ScanOutputTransform ( input: ScanOutputTransformInput )
 returns (output: Result<ScanOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ScanOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ScanOutputTransformEnsuresPublicly(input, output)
 ensures History.ScanOutputTransform == old(History.ScanOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate QueryInputTransformEnsuresPublicly(input: QueryInputTransformInput , output: Result<QueryInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method QueryInputTransform ( input: QueryInputTransformInput )
 returns (output: Result<QueryInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`QueryInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures QueryInputTransformEnsuresPublicly(input, output)
 ensures History.QueryInputTransform == old(History.QueryInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate QueryOutputTransformEnsuresPublicly(input: QueryOutputTransformInput , output: Result<QueryOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method QueryOutputTransform ( input: QueryOutputTransformInput )
 returns (output: Result<QueryOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`QueryOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures QueryOutputTransformEnsuresPublicly(input, output)
 ensures History.QueryOutputTransform == old(History.QueryOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate TransactWriteItemsInputTransformEnsuresPublicly(input: TransactWriteItemsInputTransformInput , output: Result<TransactWriteItemsInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method TransactWriteItemsInputTransform ( input: TransactWriteItemsInputTransformInput )
 returns (output: Result<TransactWriteItemsInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`TransactWriteItemsInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures TransactWriteItemsInputTransformEnsuresPublicly(input, output)
 ensures History.TransactWriteItemsInputTransform == old(History.TransactWriteItemsInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate TransactWriteItemsOutputTransformEnsuresPublicly(input: TransactWriteItemsOutputTransformInput , output: Result<TransactWriteItemsOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method TransactWriteItemsOutputTransform ( input: TransactWriteItemsOutputTransformInput )
 returns (output: Result<TransactWriteItemsOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`TransactWriteItemsOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures TransactWriteItemsOutputTransformEnsuresPublicly(input, output)
 ensures History.TransactWriteItemsOutputTransform == old(History.TransactWriteItemsOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate UpdateItemInputTransformEnsuresPublicly(input: UpdateItemInputTransformInput , output: Result<UpdateItemInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method UpdateItemInputTransform ( input: UpdateItemInputTransformInput )
 returns (output: Result<UpdateItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`UpdateItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures UpdateItemInputTransformEnsuresPublicly(input, output)
 ensures History.UpdateItemInputTransform == old(History.UpdateItemInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate UpdateItemOutputTransformEnsuresPublicly(input: UpdateItemOutputTransformInput , output: Result<UpdateItemOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method UpdateItemOutputTransform ( input: UpdateItemOutputTransformInput )
 returns (output: Result<UpdateItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`UpdateItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures UpdateItemOutputTransformEnsuresPublicly(input, output)
 ensures History.UpdateItemOutputTransform == old(History.UpdateItemOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate DeleteItemInputTransformEnsuresPublicly(input: DeleteItemInputTransformInput , output: Result<DeleteItemInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method DeleteItemInputTransform ( input: DeleteItemInputTransformInput )
 returns (output: Result<DeleteItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`DeleteItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures DeleteItemInputTransformEnsuresPublicly(input, output)
 ensures History.DeleteItemInputTransform == old(History.DeleteItemInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate DeleteItemOutputTransformEnsuresPublicly(input: DeleteItemOutputTransformInput , output: Result<DeleteItemOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method DeleteItemOutputTransform ( input: DeleteItemOutputTransformInput )
 returns (output: Result<DeleteItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`DeleteItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures DeleteItemOutputTransformEnsuresPublicly(input, output)
 ensures History.DeleteItemOutputTransform == old(History.DeleteItemOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate TransactGetItemsInputTransformEnsuresPublicly(input: TransactGetItemsInputTransformInput , output: Result<TransactGetItemsInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method TransactGetItemsInputTransform ( input: TransactGetItemsInputTransformInput )
 returns (output: Result<TransactGetItemsInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`TransactGetItemsInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures TransactGetItemsInputTransformEnsuresPublicly(input, output)
 ensures History.TransactGetItemsInputTransform == old(History.TransactGetItemsInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate TransactGetItemsOutputTransformEnsuresPublicly(input: TransactGetItemsOutputTransformInput , output: Result<TransactGetItemsOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method TransactGetItemsOutputTransform ( input: TransactGetItemsOutputTransformInput )
 returns (output: Result<TransactGetItemsOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`TransactGetItemsOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures TransactGetItemsOutputTransformEnsuresPublicly(input, output)
 ensures History.TransactGetItemsOutputTransform == old(History.TransactGetItemsOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate ExecuteStatementInputTransformEnsuresPublicly(input: ExecuteStatementInputTransformInput , output: Result<ExecuteStatementInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method ExecuteStatementInputTransform ( input: ExecuteStatementInputTransformInput )
 returns (output: Result<ExecuteStatementInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ExecuteStatementInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ExecuteStatementInputTransformEnsuresPublicly(input, output)
 ensures History.ExecuteStatementInputTransform == old(History.ExecuteStatementInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate ExecuteStatementOutputTransformEnsuresPublicly(input: ExecuteStatementOutputTransformInput , output: Result<ExecuteStatementOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method ExecuteStatementOutputTransform ( input: ExecuteStatementOutputTransformInput )
 returns (output: Result<ExecuteStatementOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ExecuteStatementOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ExecuteStatementOutputTransformEnsuresPublicly(input, output)
 ensures History.ExecuteStatementOutputTransform == old(History.ExecuteStatementOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate BatchExecuteStatementInputTransformEnsuresPublicly(input: BatchExecuteStatementInputTransformInput , output: Result<BatchExecuteStatementInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method BatchExecuteStatementInputTransform ( input: BatchExecuteStatementInputTransformInput )
 returns (output: Result<BatchExecuteStatementInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchExecuteStatementInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchExecuteStatementInputTransformEnsuresPublicly(input, output)
 ensures History.BatchExecuteStatementInputTransform == old(History.BatchExecuteStatementInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate BatchExecuteStatementOutputTransformEnsuresPublicly(input: BatchExecuteStatementOutputTransformInput , output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method BatchExecuteStatementOutputTransform ( input: BatchExecuteStatementOutputTransformInput )
 returns (output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchExecuteStatementOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchExecuteStatementOutputTransformEnsuresPublicly(input, output)
 ensures History.BatchExecuteStatementOutputTransform == old(History.BatchExecuteStatementOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate ExecuteTransactionInputTransformEnsuresPublicly(input: ExecuteTransactionInputTransformInput , output: Result<ExecuteTransactionInputTransformOutput, Error>)
 // The public method to be called by library consumers
 method ExecuteTransactionInputTransform ( input: ExecuteTransactionInputTransformInput )
 returns (output: Result<ExecuteTransactionInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ExecuteTransactionInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ExecuteTransactionInputTransformEnsuresPublicly(input, output)
 ensures History.ExecuteTransactionInputTransform == old(History.ExecuteTransactionInputTransform) + [DafnyCallEvent(input, output)]
 
 predicate ExecuteTransactionOutputTransformEnsuresPublicly(input: ExecuteTransactionOutputTransformInput , output: Result<ExecuteTransactionOutputTransformOutput, Error>)
 // The public method to be called by library consumers
 method ExecuteTransactionOutputTransform ( input: ExecuteTransactionOutputTransformInput )
 returns (output: Result<ExecuteTransactionOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ExecuteTransactionOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ExecuteTransactionOutputTransformEnsuresPublicly(input, output)
 ensures History.ExecuteTransactionOutputTransform == old(History.ExecuteTransactionOutputTransform) + [DafnyCallEvent(input, output)]
 
 predicate ResolveAttributesEnsuresPublicly(input: ResolveAttributesInput , output: Result<ResolveAttributesOutput, Error>)
 // The public method to be called by library consumers
 method ResolveAttributes ( input: ResolveAttributesInput )
 returns (output: Result<ResolveAttributesOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ResolveAttributes
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ResolveAttributesEnsuresPublicly(input, output)
 ensures History.ResolveAttributes == old(History.ResolveAttributes) + [DafnyCallEvent(input, output)]
 
}
 datatype ExecuteStatementInputTransformInput = | ExecuteStatementInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.ExecuteStatementInput
 )
 datatype ExecuteStatementInputTransformOutput = | ExecuteStatementInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.ExecuteStatementInput
 )
 datatype ExecuteStatementOutputTransformInput = | ExecuteStatementOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.ExecuteStatementOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.ExecuteStatementInput
 )
 datatype ExecuteStatementOutputTransformOutput = | ExecuteStatementOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.ExecuteStatementOutput
 )
 datatype ExecuteTransactionInputTransformInput = | ExecuteTransactionInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.ExecuteTransactionInput
 )
 datatype ExecuteTransactionInputTransformOutput = | ExecuteTransactionInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.ExecuteTransactionInput
 )
 datatype ExecuteTransactionOutputTransformInput = | ExecuteTransactionOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.ExecuteTransactionOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.ExecuteTransactionInput
 )
 datatype ExecuteTransactionOutputTransformOutput = | ExecuteTransactionOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.ExecuteTransactionOutput
 )
 datatype GetItemInputTransformInput = | GetItemInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.GetItemInput
 )
 datatype GetItemInputTransformOutput = | GetItemInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.GetItemInput
 )
 datatype GetItemOutputTransformInput = | GetItemOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.GetItemOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.GetItemInput
 )
 datatype GetItemOutputTransformOutput = | GetItemOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.GetItemOutput
 )
 datatype PutItemInputTransformInput = | PutItemInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.PutItemInput
 )
 datatype PutItemInputTransformOutput = | PutItemInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.PutItemInput
 )
 datatype PutItemOutputTransformInput = | PutItemOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.PutItemOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.PutItemInput
 )
 datatype PutItemOutputTransformOutput = | PutItemOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.PutItemOutput
 )
 datatype QueryInputTransformInput = | QueryInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.QueryInput
 )
 datatype QueryInputTransformOutput = | QueryInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.QueryInput
 )
 datatype QueryOutputTransformInput = | QueryOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.QueryOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.QueryInput
 )
 datatype QueryOutputTransformOutput = | QueryOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.QueryOutput
 )
 datatype ResolveAttributesInput = | ResolveAttributesInput (
 nameonly TableName: ComAmazonawsDynamodbTypes.TableName ,
 nameonly Item: ComAmazonawsDynamodbTypes.AttributeMap ,
 nameonly Version: Option<AwsCryptographyDbEncryptionSdkDynamoDbTypes.VersionNumber>
 )
 datatype ResolveAttributesOutput = | ResolveAttributesOutput (
 nameonly VirtualFields: StringMap ,
 nameonly CompoundBeacons: StringMap
 )
 datatype ScanInputTransformInput = | ScanInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.ScanInput
 )
 datatype ScanInputTransformOutput = | ScanInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.ScanInput
 )
 datatype ScanOutputTransformInput = | ScanOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.ScanOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.ScanInput
 )
 datatype ScanOutputTransformOutput = | ScanOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.ScanOutput
 )
 type StringMap = map<string, string>
 datatype TransactGetItemsInputTransformInput = | TransactGetItemsInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.TransactGetItemsInput
 )
 datatype TransactGetItemsInputTransformOutput = | TransactGetItemsInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.TransactGetItemsInput
 )
 datatype TransactGetItemsOutputTransformInput = | TransactGetItemsOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.TransactGetItemsOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.TransactGetItemsInput
 )
 datatype TransactGetItemsOutputTransformOutput = | TransactGetItemsOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.TransactGetItemsOutput
 )
 datatype TransactWriteItemsInputTransformInput = | TransactWriteItemsInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.TransactWriteItemsInput
 )
 datatype TransactWriteItemsInputTransformOutput = | TransactWriteItemsInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.TransactWriteItemsInput
 )
 datatype TransactWriteItemsOutputTransformInput = | TransactWriteItemsOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.TransactWriteItemsOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.TransactWriteItemsInput
 )
 datatype TransactWriteItemsOutputTransformOutput = | TransactWriteItemsOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.TransactWriteItemsOutput
 )
 datatype UpdateItemInputTransformInput = | UpdateItemInputTransformInput (
 nameonly sdkInput: ComAmazonawsDynamodbTypes.UpdateItemInput
 )
 datatype UpdateItemInputTransformOutput = | UpdateItemInputTransformOutput (
 nameonly transformedInput: ComAmazonawsDynamodbTypes.UpdateItemInput
 )
 datatype UpdateItemOutputTransformInput = | UpdateItemOutputTransformInput (
 nameonly sdkOutput: ComAmazonawsDynamodbTypes.UpdateItemOutput ,
 nameonly originalInput: ComAmazonawsDynamodbTypes.UpdateItemInput
 )
 datatype UpdateItemOutputTransformOutput = | UpdateItemOutputTransformOutput (
 nameonly transformedOutput: ComAmazonawsDynamodbTypes.UpdateItemOutput
 )
 datatype Error =
 // Local Error structures are listed here
 | DynamoDbEncryptionTransformsException (
 nameonly message: string
 )
 // Any dependent models are listed here
 | AwsCryptographyDbEncryptionSdkDynamoDb(AwsCryptographyDbEncryptionSdkDynamoDb: AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)
 | AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor: AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error)
 | AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryption: AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error)
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
 | CollectionOfErrors(list: seq<Error>, nameonly message: string)
 // The Opaque error, used for native, extern, wrapped or unknown errors
 | Opaque(obj: object)
 type OpaqueError = e: Error | e.Opaque? witness *
}
 abstract module AbstractAwsCryptographyDbEncryptionSdkDynamoDbTransformsService
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
 import Operations : AbstractAwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations
 function method DefaultDynamoDbTablesEncryptionConfig(): AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig
 method DynamoDbEncryptionTransforms(config: AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig := DefaultDynamoDbTablesEncryptionConfig())
 returns (res: Result<DynamoDbEncryptionTransformsClient, Error>)
// BEGIN MANUAL EDIT
 requires var tmps0 := set t0 | t0 in config.tableEncryptionConfigs.Values;
 forall tmp0 :: tmp0 in tmps0 ==>
 tmp0.keyring.Some? ==>
 tmp0.keyring.value.ValidState()
 requires var tmps1 := set t1 | t1 in config.tableEncryptionConfigs.Values;
 forall tmp1 :: tmp1 in tmps1 ==>
 tmp1.cmm.Some? ==>
 tmp1.cmm.value.ValidState()
 requires var tmps2 := set t2 | t2 in config.tableEncryptionConfigs.Values;
 forall tmp2 :: tmp2 in tmps2 ==>
 tmp2.legacyOverride.Some? ==>
 tmp2.legacyOverride.value.encryptor.ValidState()
 requires var tmps3 := set t3 | t3 in config.tableEncryptionConfigs.Values;
 forall tmp3 :: tmp3 in tmps3 ==>
 tmp3.search.Some? ==>
 var tmps4 := set t4 | t4 in tmp3.search.value.versions;
 forall tmp4 :: tmp4 in tmps4 ==>
 tmp4.keyStore.ValidState()
 modifies var tmps5 := set t5 | t5 in config.tableEncryptionConfigs.Values
  && t5.keyring.Some? 
  :: t5.keyring.value;
 var tmps5FlattenedModifiesSet: set<set<object>> := set t0
 | t0 in tmps5 :: t0.Modifies;
 (set tmp6ModifyEntry, tmp6Modifies | 
 tmp6Modifies in tmps5FlattenedModifiesSet 
 && tmp6ModifyEntry in tmp6Modifies 
 :: tmp6ModifyEntry)
 modifies var tmps7 := set t7 | t7 in config.tableEncryptionConfigs.Values
  && t7.cmm.Some? 
  :: t7.cmm.value;
 var tmps7FlattenedModifiesSet: set<set<object>> := set t0
 | t0 in tmps7 :: t0.Modifies;
 (set tmp8ModifyEntry, tmp8Modifies | 
 tmp8Modifies in tmps7FlattenedModifiesSet 
 && tmp8ModifyEntry in tmp8Modifies 
 :: tmp8ModifyEntry)
 modifies var tmps9 := set t9 | t9 in config.tableEncryptionConfigs.Values
  && t9.legacyOverride.Some? 
  :: t9.legacyOverride.value.encryptor;
 var tmps9FlattenedModifiesSet: set<set<object>> := set t0
 | t0 in tmps9 :: t0.Modifies;
 (set tmp10ModifyEntry, tmp10Modifies | 
 tmp10Modifies in tmps9FlattenedModifiesSet 
 && tmp10ModifyEntry in tmp10Modifies 
 :: tmp10ModifyEntry)
 modifies var tmps11 := set t11 | t11 in config.tableEncryptionConfigs.Values
  && t11.search.Some? 
  :: set t12 | t12 in t11.search.value.versions :: t12.keyStore;
 var tmps11FlattenedModifiesSet: set<set<object>> := set t0
, t1 | t0 in tmps11 && t1 in t0 :: t1.Modifies;
 (set tmp13ModifyEntry, tmp13Modifies | 
 tmp13Modifies in tmps11FlattenedModifiesSet 
 && tmp13ModifyEntry in tmp13Modifies 
 :: tmp13ModifyEntry)
 ensures res.Success? ==> 
 && fresh(res.value)
 && fresh(res.value.Modifies
 - ( var tmps14 := set t14 | t14 in config.tableEncryptionConfigs.Values
  && t14.keyring.Some? 
  :: t14.keyring.value;
 var tmps14FlattenedModifiesSet: set<set<object>> := set t0
 | t0 in tmps14 :: t0.Modifies;
 (set tmp15ModifyEntry, tmp15Modifies | 
 tmp15Modifies in tmps14FlattenedModifiesSet 
 && tmp15ModifyEntry in tmp15Modifies 
 :: tmp15ModifyEntry)
 ) - ( var tmps16 := set t16 | t16 in config.tableEncryptionConfigs.Values
  && t16.cmm.Some? 
  :: t16.cmm.value;
 var tmps16FlattenedModifiesSet: set<set<object>> := set t0
 | t0 in tmps16 :: t0.Modifies;
 (set tmp17ModifyEntry, tmp17Modifies | 
 tmp17Modifies in tmps16FlattenedModifiesSet 
 && tmp17ModifyEntry in tmp17Modifies 
 :: tmp17ModifyEntry)
 ) - ( var tmps18 := set t18 | t18 in config.tableEncryptionConfigs.Values
  && t18.legacyOverride.Some? 
  :: t18.legacyOverride.value.encryptor;
 var tmps18FlattenedModifiesSet: set<set<object>> := set t0
 | t0 in tmps18 :: t0.Modifies;
 (set tmp19ModifyEntry, tmp19Modifies | 
 tmp19Modifies in tmps18FlattenedModifiesSet 
 && tmp19ModifyEntry in tmp19Modifies 
 :: tmp19ModifyEntry)
 ) - ( var tmps20 := set t20 | t20 in config.tableEncryptionConfigs.Values
  && t20.search.Some? 
  :: set t21 | t21 in t20.search.value.versions :: t21.keyStore;
 var tmps20FlattenedModifiesSet: set<set<object>> := set t0
, t1 | t0 in tmps20 && t1 in t0 :: t1.Modifies;
 (set tmp22ModifyEntry, tmp22Modifies | 
 tmp22Modifies in tmps20FlattenedModifiesSet 
 && tmp22ModifyEntry in tmp22Modifies 
 :: tmp22ModifyEntry)
 ) )
 && fresh(res.value.History)
 && res.value.ValidState()
 ensures var tmps23 := set t23 | t23 in config.tableEncryptionConfigs.Values;
 forall tmp23 :: tmp23 in tmps23 ==>
 tmp23.keyring.Some? ==>
 tmp23.keyring.value.ValidState()
 ensures var tmps24 := set t24 | t24 in config.tableEncryptionConfigs.Values;
 forall tmp24 :: tmp24 in tmps24 ==>
 tmp24.cmm.Some? ==>
 tmp24.cmm.value.ValidState()
 ensures var tmps25 := set t25 | t25 in config.tableEncryptionConfigs.Values;
 forall tmp25 :: tmp25 in tmps25 ==>
 tmp25.legacyOverride.Some? ==>
 tmp25.legacyOverride.value.encryptor.ValidState()
 ensures var tmps26 := set t26 | t26 in config.tableEncryptionConfigs.Values;
 forall tmp26 :: tmp26 in tmps26 ==>
 tmp26.search.Some? ==>
 var tmps27 := set t27 | t27 in tmp26.search.value.versions;
 forall tmp27 :: tmp27 in tmps27 ==>
 tmp27.keyStore.ValidState()
// END MANUAL EDIT

 class DynamoDbEncryptionTransformsClient extends IDynamoDbEncryptionTransformsClient
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
 predicate PutItemInputTransformEnsuresPublicly(input: PutItemInputTransformInput , output: Result<PutItemInputTransformOutput, Error>)
 {Operations.PutItemInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method PutItemInputTransform ( input: PutItemInputTransformInput )
 returns (output: Result<PutItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`PutItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures PutItemInputTransformEnsuresPublicly(input, output)
 ensures History.PutItemInputTransform == old(History.PutItemInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.PutItemInputTransform(config, input);
 History.PutItemInputTransform := History.PutItemInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate PutItemOutputTransformEnsuresPublicly(input: PutItemOutputTransformInput , output: Result<PutItemOutputTransformOutput, Error>)
 {Operations.PutItemOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method PutItemOutputTransform ( input: PutItemOutputTransformInput )
 returns (output: Result<PutItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`PutItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures PutItemOutputTransformEnsuresPublicly(input, output)
 ensures History.PutItemOutputTransform == old(History.PutItemOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.PutItemOutputTransform(config, input);
 History.PutItemOutputTransform := History.PutItemOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate GetItemInputTransformEnsuresPublicly(input: GetItemInputTransformInput , output: Result<GetItemInputTransformOutput, Error>)
 {Operations.GetItemInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method GetItemInputTransform ( input: GetItemInputTransformInput )
 returns (output: Result<GetItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`GetItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures GetItemInputTransformEnsuresPublicly(input, output)
 ensures History.GetItemInputTransform == old(History.GetItemInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.GetItemInputTransform(config, input);
 History.GetItemInputTransform := History.GetItemInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate GetItemOutputTransformEnsuresPublicly(input: GetItemOutputTransformInput , output: Result<GetItemOutputTransformOutput, Error>)
 {Operations.GetItemOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method GetItemOutputTransform ( input: GetItemOutputTransformInput )
 returns (output: Result<GetItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`GetItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures GetItemOutputTransformEnsuresPublicly(input, output)
 ensures History.GetItemOutputTransform == old(History.GetItemOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.GetItemOutputTransform(config, input);
 History.GetItemOutputTransform := History.GetItemOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate BatchWriteItemInputTransformEnsuresPublicly(input: BatchWriteItemInputTransformInput , output: Result<BatchWriteItemInputTransformOutput, Error>)
 {Operations.BatchWriteItemInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method BatchWriteItemInputTransform ( input: BatchWriteItemInputTransformInput )
 returns (output: Result<BatchWriteItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchWriteItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchWriteItemInputTransformEnsuresPublicly(input, output)
 ensures History.BatchWriteItemInputTransform == old(History.BatchWriteItemInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.BatchWriteItemInputTransform(config, input);
 History.BatchWriteItemInputTransform := History.BatchWriteItemInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate BatchWriteItemOutputTransformEnsuresPublicly(input: BatchWriteItemOutputTransformInput , output: Result<BatchWriteItemOutputTransformOutput, Error>)
 {Operations.BatchWriteItemOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method BatchWriteItemOutputTransform ( input: BatchWriteItemOutputTransformInput )
 returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchWriteItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchWriteItemOutputTransformEnsuresPublicly(input, output)
 ensures History.BatchWriteItemOutputTransform == old(History.BatchWriteItemOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.BatchWriteItemOutputTransform(config, input);
 History.BatchWriteItemOutputTransform := History.BatchWriteItemOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate BatchGetItemInputTransformEnsuresPublicly(input: BatchGetItemInputTransformInput , output: Result<BatchGetItemInputTransformOutput, Error>)
 {Operations.BatchGetItemInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method BatchGetItemInputTransform ( input: BatchGetItemInputTransformInput )
 returns (output: Result<BatchGetItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchGetItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchGetItemInputTransformEnsuresPublicly(input, output)
 ensures History.BatchGetItemInputTransform == old(History.BatchGetItemInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.BatchGetItemInputTransform(config, input);
 History.BatchGetItemInputTransform := History.BatchGetItemInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate BatchGetItemOutputTransformEnsuresPublicly(input: BatchGetItemOutputTransformInput , output: Result<BatchGetItemOutputTransformOutput, Error>)
 {Operations.BatchGetItemOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method BatchGetItemOutputTransform ( input: BatchGetItemOutputTransformInput )
 returns (output: Result<BatchGetItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchGetItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchGetItemOutputTransformEnsuresPublicly(input, output)
 ensures History.BatchGetItemOutputTransform == old(History.BatchGetItemOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.BatchGetItemOutputTransform(config, input);
 History.BatchGetItemOutputTransform := History.BatchGetItemOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate ScanInputTransformEnsuresPublicly(input: ScanInputTransformInput , output: Result<ScanInputTransformOutput, Error>)
 {Operations.ScanInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method ScanInputTransform ( input: ScanInputTransformInput )
 returns (output: Result<ScanInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ScanInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ScanInputTransformEnsuresPublicly(input, output)
 ensures History.ScanInputTransform == old(History.ScanInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.ScanInputTransform(config, input);
 History.ScanInputTransform := History.ScanInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate ScanOutputTransformEnsuresPublicly(input: ScanOutputTransformInput , output: Result<ScanOutputTransformOutput, Error>)
 {Operations.ScanOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method ScanOutputTransform ( input: ScanOutputTransformInput )
 returns (output: Result<ScanOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ScanOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ScanOutputTransformEnsuresPublicly(input, output)
 ensures History.ScanOutputTransform == old(History.ScanOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.ScanOutputTransform(config, input);
 History.ScanOutputTransform := History.ScanOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate QueryInputTransformEnsuresPublicly(input: QueryInputTransformInput , output: Result<QueryInputTransformOutput, Error>)
 {Operations.QueryInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method QueryInputTransform ( input: QueryInputTransformInput )
 returns (output: Result<QueryInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`QueryInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures QueryInputTransformEnsuresPublicly(input, output)
 ensures History.QueryInputTransform == old(History.QueryInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.QueryInputTransform(config, input);
 History.QueryInputTransform := History.QueryInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate QueryOutputTransformEnsuresPublicly(input: QueryOutputTransformInput , output: Result<QueryOutputTransformOutput, Error>)
 {Operations.QueryOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method QueryOutputTransform ( input: QueryOutputTransformInput )
 returns (output: Result<QueryOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`QueryOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures QueryOutputTransformEnsuresPublicly(input, output)
 ensures History.QueryOutputTransform == old(History.QueryOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.QueryOutputTransform(config, input);
 History.QueryOutputTransform := History.QueryOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate TransactWriteItemsInputTransformEnsuresPublicly(input: TransactWriteItemsInputTransformInput , output: Result<TransactWriteItemsInputTransformOutput, Error>)
 {Operations.TransactWriteItemsInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method TransactWriteItemsInputTransform ( input: TransactWriteItemsInputTransformInput )
 returns (output: Result<TransactWriteItemsInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`TransactWriteItemsInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures TransactWriteItemsInputTransformEnsuresPublicly(input, output)
 ensures History.TransactWriteItemsInputTransform == old(History.TransactWriteItemsInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.TransactWriteItemsInputTransform(config, input);
 History.TransactWriteItemsInputTransform := History.TransactWriteItemsInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate TransactWriteItemsOutputTransformEnsuresPublicly(input: TransactWriteItemsOutputTransformInput , output: Result<TransactWriteItemsOutputTransformOutput, Error>)
 {Operations.TransactWriteItemsOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method TransactWriteItemsOutputTransform ( input: TransactWriteItemsOutputTransformInput )
 returns (output: Result<TransactWriteItemsOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`TransactWriteItemsOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures TransactWriteItemsOutputTransformEnsuresPublicly(input, output)
 ensures History.TransactWriteItemsOutputTransform == old(History.TransactWriteItemsOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.TransactWriteItemsOutputTransform(config, input);
 History.TransactWriteItemsOutputTransform := History.TransactWriteItemsOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate UpdateItemInputTransformEnsuresPublicly(input: UpdateItemInputTransformInput , output: Result<UpdateItemInputTransformOutput, Error>)
 {Operations.UpdateItemInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method UpdateItemInputTransform ( input: UpdateItemInputTransformInput )
 returns (output: Result<UpdateItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`UpdateItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures UpdateItemInputTransformEnsuresPublicly(input, output)
 ensures History.UpdateItemInputTransform == old(History.UpdateItemInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.UpdateItemInputTransform(config, input);
 History.UpdateItemInputTransform := History.UpdateItemInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate UpdateItemOutputTransformEnsuresPublicly(input: UpdateItemOutputTransformInput , output: Result<UpdateItemOutputTransformOutput, Error>)
 {Operations.UpdateItemOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method UpdateItemOutputTransform ( input: UpdateItemOutputTransformInput )
 returns (output: Result<UpdateItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`UpdateItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures UpdateItemOutputTransformEnsuresPublicly(input, output)
 ensures History.UpdateItemOutputTransform == old(History.UpdateItemOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.UpdateItemOutputTransform(config, input);
 History.UpdateItemOutputTransform := History.UpdateItemOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate DeleteItemInputTransformEnsuresPublicly(input: DeleteItemInputTransformInput , output: Result<DeleteItemInputTransformOutput, Error>)
 {Operations.DeleteItemInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method DeleteItemInputTransform ( input: DeleteItemInputTransformInput )
 returns (output: Result<DeleteItemInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`DeleteItemInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures DeleteItemInputTransformEnsuresPublicly(input, output)
 ensures History.DeleteItemInputTransform == old(History.DeleteItemInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.DeleteItemInputTransform(config, input);
 History.DeleteItemInputTransform := History.DeleteItemInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate DeleteItemOutputTransformEnsuresPublicly(input: DeleteItemOutputTransformInput , output: Result<DeleteItemOutputTransformOutput, Error>)
 {Operations.DeleteItemOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method DeleteItemOutputTransform ( input: DeleteItemOutputTransformInput )
 returns (output: Result<DeleteItemOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`DeleteItemOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures DeleteItemOutputTransformEnsuresPublicly(input, output)
 ensures History.DeleteItemOutputTransform == old(History.DeleteItemOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.DeleteItemOutputTransform(config, input);
 History.DeleteItemOutputTransform := History.DeleteItemOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate TransactGetItemsInputTransformEnsuresPublicly(input: TransactGetItemsInputTransformInput , output: Result<TransactGetItemsInputTransformOutput, Error>)
 {Operations.TransactGetItemsInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method TransactGetItemsInputTransform ( input: TransactGetItemsInputTransformInput )
 returns (output: Result<TransactGetItemsInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`TransactGetItemsInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures TransactGetItemsInputTransformEnsuresPublicly(input, output)
 ensures History.TransactGetItemsInputTransform == old(History.TransactGetItemsInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.TransactGetItemsInputTransform(config, input);
 History.TransactGetItemsInputTransform := History.TransactGetItemsInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate TransactGetItemsOutputTransformEnsuresPublicly(input: TransactGetItemsOutputTransformInput , output: Result<TransactGetItemsOutputTransformOutput, Error>)
 {Operations.TransactGetItemsOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method TransactGetItemsOutputTransform ( input: TransactGetItemsOutputTransformInput )
 returns (output: Result<TransactGetItemsOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`TransactGetItemsOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures TransactGetItemsOutputTransformEnsuresPublicly(input, output)
 ensures History.TransactGetItemsOutputTransform == old(History.TransactGetItemsOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.TransactGetItemsOutputTransform(config, input);
 History.TransactGetItemsOutputTransform := History.TransactGetItemsOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate ExecuteStatementInputTransformEnsuresPublicly(input: ExecuteStatementInputTransformInput , output: Result<ExecuteStatementInputTransformOutput, Error>)
 {Operations.ExecuteStatementInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method ExecuteStatementInputTransform ( input: ExecuteStatementInputTransformInput )
 returns (output: Result<ExecuteStatementInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ExecuteStatementInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ExecuteStatementInputTransformEnsuresPublicly(input, output)
 ensures History.ExecuteStatementInputTransform == old(History.ExecuteStatementInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.ExecuteStatementInputTransform(config, input);
 History.ExecuteStatementInputTransform := History.ExecuteStatementInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate ExecuteStatementOutputTransformEnsuresPublicly(input: ExecuteStatementOutputTransformInput , output: Result<ExecuteStatementOutputTransformOutput, Error>)
 {Operations.ExecuteStatementOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method ExecuteStatementOutputTransform ( input: ExecuteStatementOutputTransformInput )
 returns (output: Result<ExecuteStatementOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ExecuteStatementOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ExecuteStatementOutputTransformEnsuresPublicly(input, output)
 ensures History.ExecuteStatementOutputTransform == old(History.ExecuteStatementOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.ExecuteStatementOutputTransform(config, input);
 History.ExecuteStatementOutputTransform := History.ExecuteStatementOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate BatchExecuteStatementInputTransformEnsuresPublicly(input: BatchExecuteStatementInputTransformInput , output: Result<BatchExecuteStatementInputTransformOutput, Error>)
 {Operations.BatchExecuteStatementInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method BatchExecuteStatementInputTransform ( input: BatchExecuteStatementInputTransformInput )
 returns (output: Result<BatchExecuteStatementInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchExecuteStatementInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchExecuteStatementInputTransformEnsuresPublicly(input, output)
 ensures History.BatchExecuteStatementInputTransform == old(History.BatchExecuteStatementInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.BatchExecuteStatementInputTransform(config, input);
 History.BatchExecuteStatementInputTransform := History.BatchExecuteStatementInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate BatchExecuteStatementOutputTransformEnsuresPublicly(input: BatchExecuteStatementOutputTransformInput , output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
 {Operations.BatchExecuteStatementOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method BatchExecuteStatementOutputTransform ( input: BatchExecuteStatementOutputTransformInput )
 returns (output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`BatchExecuteStatementOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures BatchExecuteStatementOutputTransformEnsuresPublicly(input, output)
 ensures History.BatchExecuteStatementOutputTransform == old(History.BatchExecuteStatementOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.BatchExecuteStatementOutputTransform(config, input);
 History.BatchExecuteStatementOutputTransform := History.BatchExecuteStatementOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate ExecuteTransactionInputTransformEnsuresPublicly(input: ExecuteTransactionInputTransformInput , output: Result<ExecuteTransactionInputTransformOutput, Error>)
 {Operations.ExecuteTransactionInputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method ExecuteTransactionInputTransform ( input: ExecuteTransactionInputTransformInput )
 returns (output: Result<ExecuteTransactionInputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ExecuteTransactionInputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ExecuteTransactionInputTransformEnsuresPublicly(input, output)
 ensures History.ExecuteTransactionInputTransform == old(History.ExecuteTransactionInputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.ExecuteTransactionInputTransform(config, input);
 History.ExecuteTransactionInputTransform := History.ExecuteTransactionInputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate ExecuteTransactionOutputTransformEnsuresPublicly(input: ExecuteTransactionOutputTransformInput , output: Result<ExecuteTransactionOutputTransformOutput, Error>)
 {Operations.ExecuteTransactionOutputTransformEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method ExecuteTransactionOutputTransform ( input: ExecuteTransactionOutputTransformInput )
 returns (output: Result<ExecuteTransactionOutputTransformOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ExecuteTransactionOutputTransform
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ExecuteTransactionOutputTransformEnsuresPublicly(input, output)
 ensures History.ExecuteTransactionOutputTransform == old(History.ExecuteTransactionOutputTransform) + [DafnyCallEvent(input, output)]
 {
 output := Operations.ExecuteTransactionOutputTransform(config, input);
 History.ExecuteTransactionOutputTransform := History.ExecuteTransactionOutputTransform + [DafnyCallEvent(input, output)];
}
 
 predicate ResolveAttributesEnsuresPublicly(input: ResolveAttributesInput , output: Result<ResolveAttributesOutput, Error>)
 {Operations.ResolveAttributesEnsuresPublicly(input, output)}
 // The public method to be called by library consumers
 method ResolveAttributes ( input: ResolveAttributesInput )
 returns (output: Result<ResolveAttributesOutput, Error>)
 requires
 && ValidState()
 modifies Modifies - {History} ,
 History`ResolveAttributes
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies - {History}
 ensures
 && ValidState()
 ensures ResolveAttributesEnsuresPublicly(input, output)
 ensures History.ResolveAttributes == old(History.ResolveAttributes) + [DafnyCallEvent(input, output)]
 {
 output := Operations.ResolveAttributes(config, input);
 History.ResolveAttributes := History.ResolveAttributes + [DafnyCallEvent(input, output)];
}
 
}
}
 abstract module AbstractAwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
 type InternalConfig
 predicate ValidInternalConfig?(config: InternalConfig)
 function ModifiesInternalConfig(config: InternalConfig): set<object>
 predicate PutItemInputTransformEnsuresPublicly(input: PutItemInputTransformInput , output: Result<PutItemInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method PutItemInputTransform ( config: InternalConfig , input: PutItemInputTransformInput )
 returns (output: Result<PutItemInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures PutItemInputTransformEnsuresPublicly(input, output)


 predicate PutItemOutputTransformEnsuresPublicly(input: PutItemOutputTransformInput , output: Result<PutItemOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method PutItemOutputTransform ( config: InternalConfig , input: PutItemOutputTransformInput )
 returns (output: Result<PutItemOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures PutItemOutputTransformEnsuresPublicly(input, output)


 predicate GetItemInputTransformEnsuresPublicly(input: GetItemInputTransformInput , output: Result<GetItemInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method GetItemInputTransform ( config: InternalConfig , input: GetItemInputTransformInput )
 returns (output: Result<GetItemInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures GetItemInputTransformEnsuresPublicly(input, output)


 predicate GetItemOutputTransformEnsuresPublicly(input: GetItemOutputTransformInput , output: Result<GetItemOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method GetItemOutputTransform ( config: InternalConfig , input: GetItemOutputTransformInput )
 returns (output: Result<GetItemOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures GetItemOutputTransformEnsuresPublicly(input, output)


 predicate BatchWriteItemInputTransformEnsuresPublicly(input: BatchWriteItemInputTransformInput , output: Result<BatchWriteItemInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method BatchWriteItemInputTransform ( config: InternalConfig , input: BatchWriteItemInputTransformInput )
 returns (output: Result<BatchWriteItemInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures BatchWriteItemInputTransformEnsuresPublicly(input, output)


 predicate BatchWriteItemOutputTransformEnsuresPublicly(input: BatchWriteItemOutputTransformInput , output: Result<BatchWriteItemOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method BatchWriteItemOutputTransform ( config: InternalConfig , input: BatchWriteItemOutputTransformInput )
 returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures BatchWriteItemOutputTransformEnsuresPublicly(input, output)


 predicate BatchGetItemInputTransformEnsuresPublicly(input: BatchGetItemInputTransformInput , output: Result<BatchGetItemInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method BatchGetItemInputTransform ( config: InternalConfig , input: BatchGetItemInputTransformInput )
 returns (output: Result<BatchGetItemInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures BatchGetItemInputTransformEnsuresPublicly(input, output)


 predicate BatchGetItemOutputTransformEnsuresPublicly(input: BatchGetItemOutputTransformInput , output: Result<BatchGetItemOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method BatchGetItemOutputTransform ( config: InternalConfig , input: BatchGetItemOutputTransformInput )
 returns (output: Result<BatchGetItemOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures BatchGetItemOutputTransformEnsuresPublicly(input, output)


 predicate ScanInputTransformEnsuresPublicly(input: ScanInputTransformInput , output: Result<ScanInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method ScanInputTransform ( config: InternalConfig , input: ScanInputTransformInput )
 returns (output: Result<ScanInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures ScanInputTransformEnsuresPublicly(input, output)


 predicate ScanOutputTransformEnsuresPublicly(input: ScanOutputTransformInput , output: Result<ScanOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method ScanOutputTransform ( config: InternalConfig , input: ScanOutputTransformInput )
 returns (output: Result<ScanOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures ScanOutputTransformEnsuresPublicly(input, output)


 predicate QueryInputTransformEnsuresPublicly(input: QueryInputTransformInput , output: Result<QueryInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method QueryInputTransform ( config: InternalConfig , input: QueryInputTransformInput )
 returns (output: Result<QueryInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures QueryInputTransformEnsuresPublicly(input, output)


 predicate QueryOutputTransformEnsuresPublicly(input: QueryOutputTransformInput , output: Result<QueryOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method QueryOutputTransform ( config: InternalConfig , input: QueryOutputTransformInput )
 returns (output: Result<QueryOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures QueryOutputTransformEnsuresPublicly(input, output)


 predicate TransactWriteItemsInputTransformEnsuresPublicly(input: TransactWriteItemsInputTransformInput , output: Result<TransactWriteItemsInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method TransactWriteItemsInputTransform ( config: InternalConfig , input: TransactWriteItemsInputTransformInput )
 returns (output: Result<TransactWriteItemsInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures TransactWriteItemsInputTransformEnsuresPublicly(input, output)


 predicate TransactWriteItemsOutputTransformEnsuresPublicly(input: TransactWriteItemsOutputTransformInput , output: Result<TransactWriteItemsOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method TransactWriteItemsOutputTransform ( config: InternalConfig , input: TransactWriteItemsOutputTransformInput )
 returns (output: Result<TransactWriteItemsOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures TransactWriteItemsOutputTransformEnsuresPublicly(input, output)


 predicate UpdateItemInputTransformEnsuresPublicly(input: UpdateItemInputTransformInput , output: Result<UpdateItemInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method UpdateItemInputTransform ( config: InternalConfig , input: UpdateItemInputTransformInput )
 returns (output: Result<UpdateItemInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures UpdateItemInputTransformEnsuresPublicly(input, output)


 predicate UpdateItemOutputTransformEnsuresPublicly(input: UpdateItemOutputTransformInput , output: Result<UpdateItemOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method UpdateItemOutputTransform ( config: InternalConfig , input: UpdateItemOutputTransformInput )
 returns (output: Result<UpdateItemOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures UpdateItemOutputTransformEnsuresPublicly(input, output)


 predicate DeleteItemInputTransformEnsuresPublicly(input: DeleteItemInputTransformInput , output: Result<DeleteItemInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method DeleteItemInputTransform ( config: InternalConfig , input: DeleteItemInputTransformInput )
 returns (output: Result<DeleteItemInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures DeleteItemInputTransformEnsuresPublicly(input, output)


 predicate DeleteItemOutputTransformEnsuresPublicly(input: DeleteItemOutputTransformInput , output: Result<DeleteItemOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method DeleteItemOutputTransform ( config: InternalConfig , input: DeleteItemOutputTransformInput )
 returns (output: Result<DeleteItemOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures DeleteItemOutputTransformEnsuresPublicly(input, output)


 predicate TransactGetItemsInputTransformEnsuresPublicly(input: TransactGetItemsInputTransformInput , output: Result<TransactGetItemsInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method TransactGetItemsInputTransform ( config: InternalConfig , input: TransactGetItemsInputTransformInput )
 returns (output: Result<TransactGetItemsInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures TransactGetItemsInputTransformEnsuresPublicly(input, output)


 predicate TransactGetItemsOutputTransformEnsuresPublicly(input: TransactGetItemsOutputTransformInput , output: Result<TransactGetItemsOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method TransactGetItemsOutputTransform ( config: InternalConfig , input: TransactGetItemsOutputTransformInput )
 returns (output: Result<TransactGetItemsOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures TransactGetItemsOutputTransformEnsuresPublicly(input, output)


 predicate ExecuteStatementInputTransformEnsuresPublicly(input: ExecuteStatementInputTransformInput , output: Result<ExecuteStatementInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method ExecuteStatementInputTransform ( config: InternalConfig , input: ExecuteStatementInputTransformInput )
 returns (output: Result<ExecuteStatementInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures ExecuteStatementInputTransformEnsuresPublicly(input, output)


 predicate ExecuteStatementOutputTransformEnsuresPublicly(input: ExecuteStatementOutputTransformInput , output: Result<ExecuteStatementOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method ExecuteStatementOutputTransform ( config: InternalConfig , input: ExecuteStatementOutputTransformInput )
 returns (output: Result<ExecuteStatementOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures ExecuteStatementOutputTransformEnsuresPublicly(input, output)


 predicate BatchExecuteStatementInputTransformEnsuresPublicly(input: BatchExecuteStatementInputTransformInput , output: Result<BatchExecuteStatementInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method BatchExecuteStatementInputTransform ( config: InternalConfig , input: BatchExecuteStatementInputTransformInput )
 returns (output: Result<BatchExecuteStatementInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures BatchExecuteStatementInputTransformEnsuresPublicly(input, output)


 predicate BatchExecuteStatementOutputTransformEnsuresPublicly(input: BatchExecuteStatementOutputTransformInput , output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method BatchExecuteStatementOutputTransform ( config: InternalConfig , input: BatchExecuteStatementOutputTransformInput )
 returns (output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures BatchExecuteStatementOutputTransformEnsuresPublicly(input, output)


 predicate ExecuteTransactionInputTransformEnsuresPublicly(input: ExecuteTransactionInputTransformInput , output: Result<ExecuteTransactionInputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method ExecuteTransactionInputTransform ( config: InternalConfig , input: ExecuteTransactionInputTransformInput )
 returns (output: Result<ExecuteTransactionInputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures ExecuteTransactionInputTransformEnsuresPublicly(input, output)


 predicate ExecuteTransactionOutputTransformEnsuresPublicly(input: ExecuteTransactionOutputTransformInput , output: Result<ExecuteTransactionOutputTransformOutput, Error>)
 // The private method to be refined by the library developer


 method ExecuteTransactionOutputTransform ( config: InternalConfig , input: ExecuteTransactionOutputTransformInput )
 returns (output: Result<ExecuteTransactionOutputTransformOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures ExecuteTransactionOutputTransformEnsuresPublicly(input, output)


 predicate ResolveAttributesEnsuresPublicly(input: ResolveAttributesInput , output: Result<ResolveAttributesOutput, Error>)
 // The private method to be refined by the library developer


 method ResolveAttributes ( config: InternalConfig , input: ResolveAttributesInput )
 returns (output: Result<ResolveAttributesOutput, Error>)
 requires
 && ValidInternalConfig?(config)
 modifies ModifiesInternalConfig(config)
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases ModifiesInternalConfig(config)
 ensures
 && ValidInternalConfig?(config)
 ensures ResolveAttributesEnsuresPublicly(input, output)
}
