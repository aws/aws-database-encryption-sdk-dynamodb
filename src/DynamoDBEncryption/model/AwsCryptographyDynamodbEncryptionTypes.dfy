// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../StandardLibrary/StandardLibrary.dfy"
 include "../../Util/UTF8.dfy"
 include "../../StructuredEncryption/src/Index.dfy"
 include "../../../private-aws-encryption-sdk-dafny-staging/src/AwsCryptographicMaterialProviders/src/Index.dfy"
 include "../../AWS-DDB/src/Index.dfy"
 module {:extern "Dafny.Aws.Cryptography.DynamodbEncryption.Types" } AwsCryptographyDynamodbEncryptionTypes
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import AwsCryptographyStructuredEncryptionTypes
 import AwsCryptographyMaterialProvidersTypes
 import ComAmazonawsDynamodbTypes
 // Generic helpers for verification of mock/unit tests.
 datatype DafnyCallEvent<I, O> = DafnyCallEvent(input: I, output: O)
 function Last<T>(s: seq<T>): T requires |s| > 0 { s[|s|-1] }
 
 // Begin Generated Types
 
 datatype Beacon = | Beacon (
 nameonly name: string ,
 nameonly length: BitLength ,
 nameonly prefix: Option<Char> ,
 nameonly ignore: Option<Char> ,
 nameonly split: Option<SplitConfig>
 )
 datatype BeaconConfig = | BeaconConfig (
 nameonly beacons: BeaconVersionList ,
 nameonly writeBeaconVersion: VersionNumber
 )
 type BeaconList = seq<Beacon>
 datatype BeaconVersion = | BeaconVersion (
 nameonly version: VersionNumber ,
 nameonly beacons: BeaconList ,
 nameonly key: string ,
 nameonly write: bool ,
 nameonly primary: Option<PrimaryKey> ,
 nameonly narrowLSIs: Option<NarrowList>
 )
 type BeaconVersionList = seq<BeaconVersion>
 type BitLength = x: int32 | IsValid_BitLength(x) witness *
 predicate method IsValid_BitLength(x: int32) {
 ( 1 <= x <= 63 )
}
 type BitLengthList = seq<BitLength>
 type Char = x: string | IsValid_Char(x) witness *
 predicate method IsValid_Char(x: string) {
 ( 1 <= |x| <= 1 )
}
 type DDBCryptoSchema = map<ComAmazonawsDynamodbTypes.AttributeName, AwsCryptographyStructuredEncryptionTypes.CryptoAction>
 datatype DecryptItemInput = | DecryptItemInput (
 nameonly encryptedItem: ComAmazonawsDynamodbTypes.AttributeMap ,
 nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext> ,
 nameonly keyring: Option<AwsCryptographyMaterialProvidersTypes.IKeyring> ,
 nameonly cmm: Option<AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager>
 )
 datatype DecryptItemOutput = | DecryptItemOutput (
 nameonly item: ComAmazonawsDynamodbTypes.AttributeMap
 )
 class IDynamoDBEncryptionClientCallHistory {
 ghost constructor() {
 EncryptItem := [];
 DecryptItem := [];
}
 ghost var EncryptItem: seq<DafnyCallEvent<EncryptItemInput, Result<EncryptItemOutput, Error>>>
 ghost var DecryptItem: seq<DafnyCallEvent<DecryptItemInput, Result<DecryptItemOutput, Error>>>
}
 trait {:termination false} IDynamoDBEncryptionClient
 {
 // Helper to define any additional modifies/reads clauses
 // If your operations need to mutate state add it
 // in your constructor function:
 // Modifies := {your, fields, here, History};
 // If you do not need to mutate anything:
 // Modifies := {History};
 ghost const Modifies: set<object>
 // For an unassigned const field defined in a trait,
 // Dafny can only assign a value in the constructor.
 // This means that for Dafny to reason about this value,
 // it needs some way to know (an invariant),
 // about the state of the object.
 // This builds on the Valid/Repr paradigm
 // To make this kind requires is safe to add
 // to methods called from unverified code
 // the predicate MUST NOT take any arguments.
 // This means that the correctness of this requires
 // MUST only be evaluated by the class itself.
 // If you require any additional mutation,
 // Then you MUST ensure everything you need in ValidState.
 // You MUST also ensure ValidState in your constructor.
 predicate ValidState()
 ensures ValidState() ==> History in Modifies
  ghost const History: IDynamoDBEncryptionClientCallHistory
 predicate EncryptItemEnsuresPublicly(input: EncryptItemInput, output: Result<EncryptItemOutput, Error>)
 // The public method to be called by library consumers
 method EncryptItem ( input: EncryptItemInput )
 returns (output: Result<EncryptItemOutput, Error>)
 requires
 && ValidState() && ( input.keyring.Some? ==>
 && input.keyring.value.ValidState()
 && input.keyring.value.Modifies !! Modifies
 ) && ( input.cmm.Some? ==>
 && input.cmm.value.ValidState()
 && input.cmm.value.Modifies !! Modifies
 )
 modifies Modifies - {History} ,
 History`EncryptItem ,
 (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
 (if input.cmm.Some? then input.cmm.value.Modifies else {})
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies ,
 (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
 (if input.cmm.Some? then input.cmm.value.Modifies else {})
 ensures
 && ValidState()
 ensures EncryptItemEnsuresPublicly(input, output)
 ensures History.EncryptItem == old(History.EncryptItem) + [DafnyCallEvent(input, output)]
 
 predicate DecryptItemEnsuresPublicly(input: DecryptItemInput, output: Result<DecryptItemOutput, Error>)
 // The public method to be called by library consumers
 method DecryptItem ( input: DecryptItemInput )
 returns (output: Result<DecryptItemOutput, Error>)
 requires
 && ValidState() && ( input.keyring.Some? ==>
 && input.keyring.value.ValidState()
 && input.keyring.value.Modifies !! Modifies
 ) && ( input.cmm.Some? ==>
 && input.cmm.value.ValidState()
 && input.cmm.value.Modifies !! Modifies
 )
 modifies Modifies - {History} ,
 History`DecryptItem ,
 (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
 (if input.cmm.Some? then input.cmm.value.Modifies else {})
 // Dafny will skip type parameters when generating a default decreases clause.
 decreases Modifies ,
 (if input.keyring.Some? then input.keyring.value.Modifies else {}) ,
 (if input.cmm.Some? then input.cmm.value.Modifies else {})
 ensures
 && ValidState()
 ensures DecryptItemEnsuresPublicly(input, output)
 ensures History.DecryptItem == old(History.DecryptItem) + [DafnyCallEvent(input, output)]
 
}
 datatype DynamoDBEncryptionConfig = | DynamoDBEncryptionConfig (
 nameonly tableConfigs: DynamoDBTableEncryptionConfigs
 )
 datatype DynamoDBTableEncryptionConfig = | DynamoDBTableEncryptionConfig (
 nameonly partitionKeyName: ComAmazonawsDynamodbTypes.KeySchemaAttributeName ,
 nameonly sortKeyName: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName> ,
 nameonly beacons: Option<BeaconConfig>
 )
 type DynamoDBTableEncryptionConfigs = map<ComAmazonawsDynamodbTypes.TableName, DynamoDBTableEncryptionConfig>
 datatype EncryptItemInput = | EncryptItemInput (
 nameonly item: ComAmazonawsDynamodbTypes.AttributeMap ,
 nameonly cryptoSchema: DDBCryptoSchema ,
 nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext> ,
 nameonly requiredContextFieldsOnDecrypt: Option<AwsCryptographyStructuredEncryptionTypes.EncryptionContextFieldList> ,
 nameonly keyring: Option<AwsCryptographyMaterialProvidersTypes.IKeyring> ,
 nameonly cmm: Option<AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager>
 )
 datatype EncryptItemOutput = | EncryptItemOutput (
 nameonly encryptedItem: ComAmazonawsDynamodbTypes.AttributeMap
 )
 type NarrowList = seq<string>
 datatype PrimaryKey = | PrimaryKey (
 nameonly primary: ComAmazonawsDynamodbTypes.KeySchemaAttributeName ,
 nameonly partition: ComAmazonawsDynamodbTypes.KeySchemaAttributeName ,
 nameonly sort: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName>
 )
 datatype SplitConfig = | SplitConfig (
 nameonly split: Char ,
 nameonly splitLens: Option<BitLengthList> ,
 nameonly inner: Option<Char>
 )
 type VersionNumber = x: int32 | IsValid_VersionNumber(x) witness *
 predicate method IsValid_VersionNumber(x: int32) {
 ( 1 <= x  )
}
 datatype Error =
 // Local Error structures are listed here
 | DynamoDBEncryptionException (
 nameonly message: string
 )
 // Any dependent models are listed here
 | AwsCryptographyStructuredEncryption(AwsCryptographyStructuredEncryption: AwsCryptographyStructuredEncryptionTypes.Error)
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
 | Collection(list: seq<Error>)
 // The Opaque error, used for native, extern, wrapped or unknown errors
 | Opaque(obj: object)
 type OpaqueError = e: Error | e.Opaque? witness *
}
 abstract module AwsCryptographyDynamodbEncryptionAbstract
 {
 import opened Wrappers
 import opened StandardLibrary.UInt
 import opened UTF8
 import opened Types = AwsCryptographyDynamodbEncryptionTypes
 function method DefaultDynamoDBEncryptionConfig(): DynamoDBEncryptionConfig
 method DynamoDBEncryption(config: DynamoDBEncryptionConfig := DefaultDynamoDBEncryptionConfig())
 returns (res: Result<IDynamoDBEncryptionClient, Error>)
 ensures res.Success? ==> 
 && fresh(res.value)
 && fresh(res.value.Modifies)
 && fresh(res.value.History)
 && res.value.ValidState()
}
