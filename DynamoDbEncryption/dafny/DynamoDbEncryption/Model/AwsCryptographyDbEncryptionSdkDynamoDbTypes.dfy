// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
include "../../StructuredEncryption/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographyPrimitives/src/Index.dfy"
include "../../../../submodules/MaterialProviders/ComAmazonawsDynamodb/src/Index.dfy"
module {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types" } AwsCryptographyDbEncryptionSdkDynamoDbTypes
{
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import AwsCryptographyMaterialProvidersTypes
  import AwsCryptographyKeyStoreTypes
  import AwsCryptographyPrimitivesTypes
  import ComAmazonawsDynamodbTypes
    // Generic helpers for verification of mock/unit tests.
  datatype DafnyCallEvent<I, O> = DafnyCallEvent(input: I, output: O)

  // Begin Generated Types

  datatype AsSet = | AsSet (

                   )
  type AttributeActions = map<ComAmazonawsDynamodbTypes.AttributeName, AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction>
  type BeaconBitLength = x: int32 | IsValid_BeaconBitLength(x) witness *
  predicate method IsValid_BeaconBitLength(x: int32) {
    ( 1 <= x <= 63 )
  }
  datatype BeaconKeySource =
    | single(single: SingleKeyStore)
    | multi(multi: MultiKeyStore)
  datatype BeaconStyle =
    | partOnly(partOnly: PartOnly)
    | shared(shared: Shared)
    | asSet(asSet: AsSet)
    | sharedSet(sharedSet: SharedSet)
  datatype BeaconVersion = | BeaconVersion (
    nameonly version: VersionNumber ,
    nameonly keyStore: AwsCryptographyKeyStoreTypes.IKeyStoreClient ,
    nameonly keySource: BeaconKeySource ,
    nameonly standardBeacons: StandardBeaconList ,
    nameonly compoundBeacons: Option<CompoundBeaconList> := Option.None ,
    nameonly virtualFields: Option<VirtualFieldList> := Option.None ,
    nameonly encryptedParts: Option<EncryptedPartsList> := Option.None ,
    nameonly signedParts: Option<SignedPartsList> := Option.None ,
    nameonly maximumNumberOfBuckets: Option<BucketCount> := Option.None ,
    nameonly defaultNumberOfBuckets: Option<BucketCount> := Option.None ,
    nameonly bucketSelector: Option<IBucketSelector> := Option.None
  )
  type BeaconVersionList = x: seq<BeaconVersion> | IsValid_BeaconVersionList(x) witness *
  predicate method IsValid_BeaconVersionList(x: seq<BeaconVersion>) {
    ( 1 <= |x| <= 1 )
  }
  type BucketCount = x: int32 | IsValid_BucketCount(x) witness *
  predicate method IsValid_BucketCount(x: int32) {
    ( 1 <= x <= 255 )
  }
  type BucketNumber = x: int32 | IsValid_BucketNumber(x) witness *
  predicate method IsValid_BucketNumber(x: int32) {
    ( 0 <= x <= 254 )
  }
  class IBucketSelectorCallHistory {
    ghost constructor() {
      GetBucketNumber := [];
    }
    ghost var GetBucketNumber: seq<DafnyCallEvent<GetBucketNumberInput, Result<GetBucketNumberOutput, Error>>>
  }
  trait {:termination false} IBucketSelector
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
    ghost const History: IBucketSelectorCallHistory
    predicate GetBucketNumberEnsuresPublicly(input: GetBucketNumberInput , output: Result<GetBucketNumberOutput, Error>)
    // The public method to be called by library consumers
    method GetBucketNumber ( input: GetBucketNumberInput )
      returns (output: Result<GetBucketNumberOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`GetBucketNumber
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures GetBucketNumberEnsuresPublicly(input, output)
      ensures History.GetBucketNumber == old(History.GetBucketNumber) + [DafnyCallEvent(input, output)]
    {
      output := GetBucketNumber' (input);
      History.GetBucketNumber := History.GetBucketNumber + [DafnyCallEvent(input, output)];
    }
    // The method to implement in the concrete class.
    method GetBucketNumber' ( input: GetBucketNumberInput )
      returns (output: Result<GetBucketNumberOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History}
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures GetBucketNumberEnsuresPublicly(input, output)
      ensures unchanged(History)

  }
  type Char = x: string | IsValid_Char(x) witness *
  predicate method IsValid_Char(x: string) {
    ( 1 <= |x| <= 1 )
  }
  datatype CompoundBeacon = | CompoundBeacon (
    nameonly name: string ,
    nameonly split: Char ,
    nameonly encrypted: Option<EncryptedPartsList> := Option.None ,
    nameonly signed: Option<SignedPartsList> := Option.None ,
    nameonly constructors: Option<ConstructorList> := Option.None
  )
  type CompoundBeaconList = x: seq<CompoundBeacon> | IsValid_CompoundBeaconList(x) witness *
  predicate method IsValid_CompoundBeaconList(x: seq<CompoundBeacon>) {
    ( 1 <= |x|  )
  }
  datatype Constructor = | Constructor (
    nameonly parts: ConstructorPartList
  )
  type ConstructorList = x: seq<Constructor> | IsValid_ConstructorList(x) witness *
  predicate method IsValid_ConstructorList(x: seq<Constructor>) {
    ( 1 <= |x|  )
  }
  datatype ConstructorPart = | ConstructorPart (
    nameonly name: string ,
    nameonly required: bool
  )
  type ConstructorPartList = x: seq<ConstructorPart> | IsValid_ConstructorPartList(x) witness *
  predicate method IsValid_ConstructorPartList(x: seq<ConstructorPart>) {
    ( 1 <= |x|  )
  }
  datatype CreateDynamoDbEncryptionBranchKeyIdSupplierInput = | CreateDynamoDbEncryptionBranchKeyIdSupplierInput (
    nameonly ddbKeyBranchKeyIdSupplier: IDynamoDbKeyBranchKeyIdSupplier
  )
  datatype CreateDynamoDbEncryptionBranchKeyIdSupplierOutput = | CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (
    nameonly branchKeyIdSupplier: AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplier
  )
  class IDynamoDbEncryptionClientCallHistory {
    ghost constructor() {
      CreateDynamoDbEncryptionBranchKeyIdSupplier := [];
      GetEncryptedDataKeyDescription := [];
    }
    ghost var CreateDynamoDbEncryptionBranchKeyIdSupplier: seq<DafnyCallEvent<CreateDynamoDbEncryptionBranchKeyIdSupplierInput, Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>>>
    ghost var GetEncryptedDataKeyDescription: seq<DafnyCallEvent<GetEncryptedDataKeyDescriptionInput, Result<GetEncryptedDataKeyDescriptionOutput, Error>>>
  }
  trait {:termination false} IDynamoDbEncryptionClient
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
    ghost const History: IDynamoDbEncryptionClientCallHistory
    predicate CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput , output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
    // The public method to be called by library consumers
    method CreateDynamoDbEncryptionBranchKeyIdSupplier ( input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput )
      returns (output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
      requires
        && ValidState()
        && input.ddbKeyBranchKeyIdSupplier.ValidState()
        && input.ddbKeyBranchKeyIdSupplier.Modifies !! {History}
      modifies Modifies - {History} ,
               input.ddbKeyBranchKeyIdSupplier.Modifies ,
               History`CreateDynamoDbEncryptionBranchKeyIdSupplier
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.ddbKeyBranchKeyIdSupplier.Modifies
      ensures
        && ValidState()
        && ( output.Success? ==>
               && output.value.branchKeyIdSupplier.ValidState()
               && output.value.branchKeyIdSupplier.Modifies !! {History}
               && fresh(output.value.branchKeyIdSupplier)
               && fresh ( output.value.branchKeyIdSupplier.Modifies
                          - Modifies - {History}
                          - input.ddbKeyBranchKeyIdSupplier.Modifies ) )
      ensures CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input, output)
      ensures History.CreateDynamoDbEncryptionBranchKeyIdSupplier == old(History.CreateDynamoDbEncryptionBranchKeyIdSupplier) + [DafnyCallEvent(input, output)]

    predicate GetEncryptedDataKeyDescriptionEnsuresPublicly(input: GetEncryptedDataKeyDescriptionInput , output: Result<GetEncryptedDataKeyDescriptionOutput, Error>)
    // The public method to be called by library consumers
    method GetEncryptedDataKeyDescription ( input: GetEncryptedDataKeyDescriptionInput )
      returns (output: Result<GetEncryptedDataKeyDescriptionOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`GetEncryptedDataKeyDescription
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures GetEncryptedDataKeyDescriptionEnsuresPublicly(input, output)
      ensures History.GetEncryptedDataKeyDescription == old(History.GetEncryptedDataKeyDescription) + [DafnyCallEvent(input, output)]

  }
  datatype DynamoDbEncryptionConfig = | DynamoDbEncryptionConfig (

                                      )
  class IDynamoDbKeyBranchKeyIdSupplierCallHistory {
    ghost constructor() {
      GetBranchKeyIdFromDdbKey := [];
    }
    ghost var GetBranchKeyIdFromDdbKey: seq<DafnyCallEvent<GetBranchKeyIdFromDdbKeyInput, Result<GetBranchKeyIdFromDdbKeyOutput, Error>>>
  }
  trait {:termination false} IDynamoDbKeyBranchKeyIdSupplier
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
    ghost const History: IDynamoDbKeyBranchKeyIdSupplierCallHistory
    predicate GetBranchKeyIdFromDdbKeyEnsuresPublicly(input: GetBranchKeyIdFromDdbKeyInput , output: Result<GetBranchKeyIdFromDdbKeyOutput, Error>)
    // The public method to be called by library consumers
    method GetBranchKeyIdFromDdbKey ( input: GetBranchKeyIdFromDdbKeyInput )
      returns (output: Result<GetBranchKeyIdFromDdbKeyOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`GetBranchKeyIdFromDdbKey
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures GetBranchKeyIdFromDdbKeyEnsuresPublicly(input, output)
      ensures History.GetBranchKeyIdFromDdbKey == old(History.GetBranchKeyIdFromDdbKey) + [DafnyCallEvent(input, output)]
    {
      output := GetBranchKeyIdFromDdbKey' (input);
      History.GetBranchKeyIdFromDdbKey := History.GetBranchKeyIdFromDdbKey + [DafnyCallEvent(input, output)];
    }
    // The method to implement in the concrete class.
    method GetBranchKeyIdFromDdbKey' ( input: GetBranchKeyIdFromDdbKeyInput )
      returns (output: Result<GetBranchKeyIdFromDdbKeyOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History}
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures GetBranchKeyIdFromDdbKeyEnsuresPublicly(input, output)
      ensures unchanged(History)

  }
  datatype DynamoDbTableEncryptionConfig = | DynamoDbTableEncryptionConfig (
    nameonly logicalTableName: string ,
    nameonly partitionKeyName: ComAmazonawsDynamodbTypes.KeySchemaAttributeName ,
    nameonly sortKeyName: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName> := Option.None ,
    nameonly search: Option<SearchConfig> := Option.None ,
    nameonly attributeActionsOnEncrypt: AttributeActions ,
    nameonly allowedUnsignedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList> := Option.None ,
    nameonly allowedUnsignedAttributePrefix: Option<string> := Option.None ,
    nameonly algorithmSuiteId: Option<AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId> := Option.None ,
    nameonly keyring: Option<AwsCryptographyMaterialProvidersTypes.IKeyring> := Option.None ,
    nameonly cmm: Option<AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager> := Option.None ,
    nameonly legacyOverride: Option<LegacyOverride> := Option.None ,
    nameonly plaintextOverride: Option<PlaintextOverride> := Option.None
  )
  type DynamoDbTableEncryptionConfigList = map<ComAmazonawsDynamodbTypes.TableName, DynamoDbTableEncryptionConfig>
  datatype DynamoDbTablesEncryptionConfig = | DynamoDbTablesEncryptionConfig (
    nameonly tableEncryptionConfigs: DynamoDbTableEncryptionConfigList
  )
  datatype EncryptedDataKeyDescription = | EncryptedDataKeyDescription (
    nameonly keyProviderId: string ,
    nameonly keyProviderInfo: Option<string> := Option.None ,
    nameonly branchKeyId: Option<string> := Option.None ,
    nameonly branchKeyVersion: Option<string> := Option.None
  )
  type EncryptedDataKeyDescriptionList = seq<EncryptedDataKeyDescription>
  datatype EncryptedPart = | EncryptedPart (
    nameonly name: string ,
    nameonly prefix: Prefix
  )
  type EncryptedPartsList = x: seq<EncryptedPart> | IsValid_EncryptedPartsList(x) witness *
  predicate method IsValid_EncryptedPartsList(x: seq<EncryptedPart>) {
    ( 1 <= |x|  )
  }
  datatype GetBranchKeyIdFromDdbKeyInput = | GetBranchKeyIdFromDdbKeyInput (
    nameonly ddbKey: ComAmazonawsDynamodbTypes.Key
  )
  datatype GetBranchKeyIdFromDdbKeyOutput = | GetBranchKeyIdFromDdbKeyOutput (
    nameonly branchKeyId: string
  )
  datatype GetBucketNumberInput = | GetBucketNumberInput (
    nameonly item: ComAmazonawsDynamodbTypes.AttributeMap ,
    nameonly numberOfBuckets: BucketCount ,
    nameonly logicalTableName: string
  )
  datatype GetBucketNumberOutput = | GetBucketNumberOutput (
    nameonly bucketNumber: BucketNumber
  )
  datatype GetEncryptedDataKeyDescriptionInput = | GetEncryptedDataKeyDescriptionInput (
    nameonly input: GetEncryptedDataKeyDescriptionUnion
  )
  datatype GetEncryptedDataKeyDescriptionOutput = | GetEncryptedDataKeyDescriptionOutput (
    nameonly EncryptedDataKeyDescriptionOutput: EncryptedDataKeyDescriptionList
  )
  datatype GetEncryptedDataKeyDescriptionUnion =
    | header(header: seq<uint8>)
    | item(item: ComAmazonawsDynamodbTypes.AttributeMap)
  datatype GetPrefix = | GetPrefix (
    nameonly length: int32
  )
  datatype GetSegment = | GetSegment (
    nameonly split: Char ,
    nameonly index: int32
  )
  datatype GetSegments = | GetSegments (
    nameonly split: Char ,
    nameonly low: int32 ,
    nameonly high: int32
  )
  datatype GetSubstring = | GetSubstring (
    nameonly low: int32 ,
    nameonly high: int32
  )
  datatype GetSuffix = | GetSuffix (
    nameonly length: int32
  )
  datatype Insert = | Insert (
    nameonly literal: string
  )
  class ILegacyDynamoDbEncryptorCallHistory {
    ghost constructor() {

    }

  }
  trait {:termination false} ILegacyDynamoDbEncryptor
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
    ghost const History: ILegacyDynamoDbEncryptorCallHistory

  }
  datatype LegacyOverride = | LegacyOverride (
    nameonly policy: LegacyPolicy ,
    nameonly encryptor: ILegacyDynamoDbEncryptor ,
    nameonly attributeActionsOnEncrypt: AttributeActions ,
    nameonly defaultAttributeFlag: Option<AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction> := Option.None
  )
  datatype LegacyPolicy =
    | FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT
    | FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT
    | FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT
  datatype Lower = | Lower (

                   )
  datatype MultiKeyStore = | MultiKeyStore (
    nameonly keyFieldName: string ,
    nameonly cacheTTL: int32 ,
    nameonly cache: Option<AwsCryptographyMaterialProvidersTypes.CacheType> := Option.None ,
    nameonly partitionId: Option<string> := Option.None
  )
  datatype PartOnly = | PartOnly (

                      )
  datatype PlaintextOverride =
    | FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
    | FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
    | FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ
  type Prefix = x: string | IsValid_Prefix(x) witness *
  predicate method IsValid_Prefix(x: string) {
    ( 1 <= |x|  )
  }
  datatype SearchConfig = | SearchConfig (
    nameonly versions: BeaconVersionList ,
    nameonly writeVersion: VersionNumber
  )
  datatype Shared = | Shared (
    nameonly other: string
  )
  datatype SharedSet = | SharedSet (
    nameonly other: string
  )
  datatype SignedPart = | SignedPart (
    nameonly name: string ,
    nameonly prefix: Prefix ,
    nameonly loc: Option<TerminalLocation> := Option.None
  )
  type SignedPartsList = x: seq<SignedPart> | IsValid_SignedPartsList(x) witness *
  predicate method IsValid_SignedPartsList(x: seq<SignedPart>) {
    ( 1 <= |x|  )
  }
  datatype SingleKeyStore = | SingleKeyStore (
    nameonly keyId: string ,
    nameonly cacheTTL: int32 ,
    nameonly cache: Option<AwsCryptographyMaterialProvidersTypes.CacheType> := Option.None ,
    nameonly partitionId: Option<string> := Option.None
  )
  datatype StandardBeacon = | StandardBeacon (
    nameonly name: string ,
    nameonly length: BeaconBitLength ,
    nameonly loc: Option<TerminalLocation> := Option.None ,
    nameonly style: Option<BeaconStyle> := Option.None ,
    nameonly numberOfBuckets: Option<BucketCount> := Option.None
  )
  type StandardBeaconList = x: seq<StandardBeacon> | IsValid_StandardBeaconList(x) witness *
  predicate method IsValid_StandardBeaconList(x: seq<StandardBeacon>) {
    ( 1 <= |x|  )
  }
  type TerminalLocation = x: string | IsValid_TerminalLocation(x) witness *
  predicate method IsValid_TerminalLocation(x: string) {
    ( 1 <= |x|  )
  }
  datatype Upper = | Upper (

                   )
  type VersionNumber = x: int32 | IsValid_VersionNumber(x) witness *
  predicate method IsValid_VersionNumber(x: int32) {
    ( 1 <= x  )
  }
  datatype VirtualField = | VirtualField (
    nameonly name: string ,
    nameonly parts: VirtualPartList
  )
  type VirtualFieldList = x: seq<VirtualField> | IsValid_VirtualFieldList(x) witness *
  predicate method IsValid_VirtualFieldList(x: seq<VirtualField>) {
    ( 1 <= |x|  )
  }
  datatype VirtualPart = | VirtualPart (
    nameonly loc: TerminalLocation ,
    nameonly trans: Option<VirtualTransformList> := Option.None
  )
  type VirtualPartList = x: seq<VirtualPart> | IsValid_VirtualPartList(x) witness *
  predicate method IsValid_VirtualPartList(x: seq<VirtualPart>) {
    ( 1 <= |x|  )
  }
  datatype VirtualTransform =
    | upper(upper: Upper)
    | lower(lower: Lower)
    | insert(insert: Insert)
    | prefix(prefix: GetPrefix)
    | suffix(suffix: GetSuffix)
    | substring(substring: GetSubstring)
    | segment(segment: GetSegment)
    | segments(segments: GetSegments)
  type VirtualTransformList = x: seq<VirtualTransform> | IsValid_VirtualTransformList(x) witness *
  predicate method IsValid_VirtualTransformList(x: seq<VirtualTransform>) {
    ( 1 <= |x|  )
  }
  datatype Error =
      // Local Error structures are listed here
    | DynamoDbEncryptionException (
        nameonly message: string
      )
      // Any dependent models are listed here
    | AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryption: AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error)
    | AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders: AwsCryptographyMaterialProvidersTypes.Error)
    | AwsCryptographyKeyStore(AwsCryptographyKeyStore: AwsCryptographyKeyStoreTypes.Error)
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
abstract module AbstractAwsCryptographyDbEncryptionSdkDynamoDbService
{
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import opened Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import Operations : AbstractAwsCryptographyDbEncryptionSdkDynamoDbOperations
  function method DefaultDynamoDbEncryptionConfig(): DynamoDbEncryptionConfig
  method DynamoDbEncryption(config: DynamoDbEncryptionConfig := DefaultDynamoDbEncryptionConfig())
    returns (res: Result<DynamoDbEncryptionClient, Error>)
    ensures res.Success? ==>
              && fresh(res.value)
              && fresh(res.value.Modifies)
              && fresh(res.value.History)
              && res.value.ValidState()

  // Helper functions for the benefit of native code to create a Success(client) without referring to Dafny internals
  function method CreateSuccessOfClient(client: IDynamoDbEncryptionClient): Result<IDynamoDbEncryptionClient, Error> {
    Success(client)
  }
  function method CreateFailureOfError(error: Error): Result<IDynamoDbEncryptionClient, Error> {
    Failure(error)
  }
  class DynamoDbEncryptionClient extends IDynamoDbEncryptionClient
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
        && input.ddbKeyBranchKeyIdSupplier.ValidState()
        && input.ddbKeyBranchKeyIdSupplier.Modifies !! {History}
      modifies Modifies - {History} ,
               input.ddbKeyBranchKeyIdSupplier.Modifies ,
               History`CreateDynamoDbEncryptionBranchKeyIdSupplier
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History} ,
                input.ddbKeyBranchKeyIdSupplier.Modifies
      ensures
        && ValidState()
        && ( output.Success? ==>
               && output.value.branchKeyIdSupplier.ValidState()
               && output.value.branchKeyIdSupplier.Modifies !! {History}
               && fresh(output.value.branchKeyIdSupplier)
               && fresh ( output.value.branchKeyIdSupplier.Modifies
                          - Modifies - {History}
                          - input.ddbKeyBranchKeyIdSupplier.Modifies ) )
      ensures CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input, output)
      ensures History.CreateDynamoDbEncryptionBranchKeyIdSupplier == old(History.CreateDynamoDbEncryptionBranchKeyIdSupplier) + [DafnyCallEvent(input, output)]
    {
      output := Operations.CreateDynamoDbEncryptionBranchKeyIdSupplier(config, input);
      History.CreateDynamoDbEncryptionBranchKeyIdSupplier := History.CreateDynamoDbEncryptionBranchKeyIdSupplier + [DafnyCallEvent(input, output)];
    }

    predicate GetEncryptedDataKeyDescriptionEnsuresPublicly(input: GetEncryptedDataKeyDescriptionInput , output: Result<GetEncryptedDataKeyDescriptionOutput, Error>)
    {Operations.GetEncryptedDataKeyDescriptionEnsuresPublicly(input, output)}
    // The public method to be called by library consumers
    method GetEncryptedDataKeyDescription ( input: GetEncryptedDataKeyDescriptionInput )
      returns (output: Result<GetEncryptedDataKeyDescriptionOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`GetEncryptedDataKeyDescription
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures GetEncryptedDataKeyDescriptionEnsuresPublicly(input, output)
      ensures History.GetEncryptedDataKeyDescription == old(History.GetEncryptedDataKeyDescription) + [DafnyCallEvent(input, output)]
    {
      output := Operations.GetEncryptedDataKeyDescription(config, input);
      History.GetEncryptedDataKeyDescription := History.GetEncryptedDataKeyDescription + [DafnyCallEvent(input, output)];
    }

  }
}
abstract module AbstractAwsCryptographyDbEncryptionSdkDynamoDbOperations {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import opened Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  type InternalConfig
  predicate ValidInternalConfig?(config: InternalConfig)
  function ModifiesInternalConfig(config: InternalConfig): set<object>
  predicate CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput , output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
  // The private method to be refined by the library developer


  method CreateDynamoDbEncryptionBranchKeyIdSupplier ( config: InternalConfig , input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput )
    returns (output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
    requires
      && ValidInternalConfig?(config)
      && input.ddbKeyBranchKeyIdSupplier.ValidState()
    modifies ModifiesInternalConfig(config) ,
             input.ddbKeyBranchKeyIdSupplier.Modifies
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config) ,
              input.ddbKeyBranchKeyIdSupplier.Modifies
    ensures
      && ValidInternalConfig?(config)
      && ( output.Success? ==>
             && output.value.branchKeyIdSupplier.ValidState()
             && fresh(output.value.branchKeyIdSupplier)
             && fresh ( output.value.branchKeyIdSupplier.Modifies
                        - ModifiesInternalConfig(config)
                        - input.ddbKeyBranchKeyIdSupplier.Modifies ) )
    ensures CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input, output)


  predicate GetEncryptedDataKeyDescriptionEnsuresPublicly(input: GetEncryptedDataKeyDescriptionInput , output: Result<GetEncryptedDataKeyDescriptionOutput, Error>)
  // The private method to be refined by the library developer


  method GetEncryptedDataKeyDescription ( config: InternalConfig , input: GetEncryptedDataKeyDescriptionInput )
    returns (output: Result<GetEncryptedDataKeyDescriptionOutput, Error>)
    requires
      && ValidInternalConfig?(config)
    modifies ModifiesInternalConfig(config)
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config)
    ensures
      && ValidInternalConfig?(config)
    ensures GetEncryptedDataKeyDescriptionEnsuresPublicly(input, output)
}
