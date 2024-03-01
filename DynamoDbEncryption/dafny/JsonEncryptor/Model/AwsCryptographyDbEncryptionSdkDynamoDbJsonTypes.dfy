// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
include "../../StructuredEncryption/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographyPrimitives/src/Index.dfy"
module {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types" } AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
{
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import AwsCryptographyMaterialProvidersTypes
  import AwsCryptographyPrimitivesTypes
    // Generic helpers for verification of mock/unit tests.
  datatype DafnyCallEvent<I, O> = DafnyCallEvent(input: I, output: O)

  // Begin Generated Types

  datatype Action =
    | crypto(crypto: AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)
    | esdk(esdk: EsdkEncrypt)
    | dbesdk(dbesdk: JsonEncrypt)
  type AttributeActions = map<string, Action>
  type AttributeNameList = seq<string>
  datatype DecryptObjectInput = | DecryptObjectInput (
    nameonly encryptedObject: Json
  )
  datatype DecryptObjectOutput = | DecryptObjectOutput (
    nameonly plaintextObject: Json ,
    nameonly parsedHeader: Option<ParsedHeader> := Option.None
  )
  datatype EncryptObjectInput = | EncryptObjectInput (
    nameonly plaintextObject: Json
  )
  datatype EncryptObjectOutput = | EncryptObjectOutput (
    nameonly encryptedObject: Json ,
    nameonly parsedHeader: Option<ParsedHeader> := Option.None
  )
  datatype EsdkEncrypt = | EsdkEncrypt (
    nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext> := Option.None ,
    nameonly materialsManager: Option<AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager> := Option.None ,
    nameonly keyring: Option<AwsCryptographyMaterialProvidersTypes.IKeyring> := Option.None ,
    nameonly algorithmSuiteId: Option<AwsCryptographyMaterialProvidersTypes.ESDKAlgorithmSuiteId> := Option.None ,
    nameonly frameLength: Option<FrameLength> := Option.None
  )
  type FrameLength = x: int64 | IsValid_FrameLength(x) witness *
  predicate method IsValid_FrameLength(x: int64) {
    ( 1 <= x <= 2000000000 )
  }
  datatype Json =
    | utf8(utf8: Utf8Bytes)
    | text(text: string)
  datatype JsonEncrypt = | JsonEncrypt (
    nameonly keyring: Option<AwsCryptographyMaterialProvidersTypes.IKeyring> := Option.None ,
    nameonly cmm: Option<AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager> := Option.None ,
    nameonly algorithmSuiteId: Option<AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId> := Option.None ,
    nameonly signedValue: Option<SignedValues> := Option.None ,
    nameonly encryptionContext: Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext> := Option.None
  )
  class IJsonEncryptorClientCallHistory {
    ghost constructor() {
      EncryptObject := [];
      DecryptObject := [];
    }
    ghost var EncryptObject: seq<DafnyCallEvent<EncryptObjectInput, Result<EncryptObjectOutput, Error>>>
    ghost var DecryptObject: seq<DafnyCallEvent<DecryptObjectInput, Result<DecryptObjectOutput, Error>>>
  }
  trait {:termination false} IJsonEncryptorClient
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
    ghost const History: IJsonEncryptorClientCallHistory
    predicate EncryptObjectEnsuresPublicly(input: EncryptObjectInput , output: Result<EncryptObjectOutput, Error>)
    // The public method to be called by library consumers
    method EncryptObject ( input: EncryptObjectInput )
      returns (output: Result<EncryptObjectOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`EncryptObject
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures EncryptObjectEnsuresPublicly(input, output)
      ensures History.EncryptObject == old(History.EncryptObject) + [DafnyCallEvent(input, output)]

    predicate DecryptObjectEnsuresPublicly(input: DecryptObjectInput , output: Result<DecryptObjectOutput, Error>)
    // The public method to be called by library consumers
    method DecryptObject ( input: DecryptObjectInput )
      returns (output: Result<DecryptObjectOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`DecryptObject
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures DecryptObjectEnsuresPublicly(input, output)
      ensures History.DecryptObject == old(History.DecryptObject) + [DafnyCallEvent(input, output)]

  }
  datatype JsonEncryptorConfig = | JsonEncryptorConfig (
    nameonly domain: string ,
    nameonly attributeActionsOnEncrypt: AttributeActions ,
    nameonly allowedUnsignedAttributes: Option<AttributeNameList> := Option.None ,
    nameonly allowedUnsignedAttributePrefix: Option<string> := Option.None ,
    nameonly encrypt: JsonEncrypt
  )
  datatype ParsedHeader = | ParsedHeader (
    nameonly attributeActionsOnEncrypt: AttributeActions ,
    nameonly algorithmSuiteId: AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId ,
    nameonly encryptedDataKeys: AwsCryptographyMaterialProvidersTypes.EncryptedDataKeyList ,
    nameonly storedEncryptionContext: AwsCryptographyMaterialProvidersTypes.EncryptionContext ,
    nameonly encryptionContext: AwsCryptographyMaterialProvidersTypes.EncryptionContext
  )
  type SignedValues = map<string, string>
  type Utf8Bytes = ValidUTF8Bytes
  datatype Error =
      // Local Error structures are listed here
    | JsonEncryptorException (
        nameonly message: string
      )
      // Any dependent models are listed here
    | AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryption: AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error)
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
  type OpaqueError = e: Error | e.Opaque? witness *
}
abstract module AbstractAwsCryptographyDbEncryptionSdkDynamoDbJsonService
{
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import opened Types = AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  import Operations : AbstractAwsCryptographyDbEncryptionSdkDynamoDbJsonOperations
  function method DefaultJsonEncryptorConfig(): JsonEncryptorConfig
  method JsonEncryptor(config: JsonEncryptorConfig := DefaultJsonEncryptorConfig())
    returns (res: Result<IJsonEncryptorClient, Error>)
    requires config.encrypt.keyring.Some? ==>
               config.encrypt.keyring.value.ValidState()
    requires config.encrypt.cmm.Some? ==>
               config.encrypt.cmm.value.ValidState()
    requires var tmps0 := set t0 | t0 in config.attributeActionsOnEncrypt.Values;
             forall tmp0 :: tmp0 in tmps0 ==>
                              tmp0.esdk? ==>
                                tmp0.esdk.materialsManager.Some? ==>
                                  tmp0.esdk.materialsManager.value.ValidState()
    requires var tmps1 := set t1 | t1 in config.attributeActionsOnEncrypt.Values;
             forall tmp1 :: tmp1 in tmps1 ==>
                              tmp1.esdk? ==>
                                tmp1.esdk.keyring.Some? ==>
                                  tmp1.esdk.keyring.value.ValidState()
    modifies if config.encrypt.keyring.Some? then
               config.encrypt.keyring.value.Modifies
             else {}
    modifies if config.encrypt.cmm.Some? then
               config.encrypt.cmm.value.Modifies
             else {}
    modifies set tmps2 <- set t2 <- config.attributeActionsOnEncrypt.Values | true
                                                                              && t2.esdk?
                                                                              && t2.esdk.materialsManager.Some?
                            :: t2.esdk.materialsManager.value,
               obj <- tmps2.Modifies | obj in tmps2.Modifies :: obj
    modifies set tmps3 <- set t3 <- config.attributeActionsOnEncrypt.Values | true
                                                                              && t3.esdk?
                                                                              && t3.esdk.keyring.Some?
                            :: t3.esdk.keyring.value,
               obj <- tmps3.Modifies | obj in tmps3.Modifies :: obj
    ensures res.Success? ==>
              && fresh(res.value)
              && fresh(res.value.Modifies
                       - ( if config.encrypt.keyring.Some? then
                             config.encrypt.keyring.value.Modifies
                           else {}
                       ) - ( if config.encrypt.cmm.Some? then
                               config.encrypt.cmm.value.Modifies
                             else {}
                       ) - ( set tmps4 <- set t4 <- config.attributeActionsOnEncrypt.Values | true
                                                                                              && t4.esdk?
                                                                                              && t4.esdk.materialsManager.Some?
                                            :: t4.esdk.materialsManager.value,
                               obj <- tmps4.Modifies | obj in tmps4.Modifies :: obj
                       ) - ( set tmps5 <- set t5 <- config.attributeActionsOnEncrypt.Values | true
                                                                                              && t5.esdk?
                                                                                              && t5.esdk.keyring.Some?
                                            :: t5.esdk.keyring.value,
                               obj <- tmps5.Modifies | obj in tmps5.Modifies :: obj
                       ) )
              && fresh(res.value.History)
              && res.value.ValidState()
    ensures config.encrypt.keyring.Some? ==>
              config.encrypt.keyring.value.ValidState()
    ensures config.encrypt.cmm.Some? ==>
              config.encrypt.cmm.value.ValidState()
    ensures var tmps6 := set t6 | t6 in config.attributeActionsOnEncrypt.Values;
            forall tmp6 :: tmp6 in tmps6 ==>
                             tmp6.esdk? ==>
                               tmp6.esdk.materialsManager.Some? ==>
                                 tmp6.esdk.materialsManager.value.ValidState()
    ensures var tmps7 := set t7 | t7 in config.attributeActionsOnEncrypt.Values;
            forall tmp7 :: tmp7 in tmps7 ==>
                             tmp7.esdk? ==>
                               tmp7.esdk.keyring.Some? ==>
                                 tmp7.esdk.keyring.value.ValidState()

  // Helper function for the benefit of native code to create a Success(client) without referring to Dafny internals
  function method CreateSuccessOfClient(client: IJsonEncryptorClient): Result<IJsonEncryptorClient, Error> {
    Success(client)
  } // Helper function for the benefit of native code to create a Failure(error) without referring to Dafny internals
  function method CreateFailureOfError(error: Error): Result<IJsonEncryptorClient, Error> {
    Failure(error)
  }
  class JsonEncryptorClient extends IJsonEncryptorClient
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
    predicate EncryptObjectEnsuresPublicly(input: EncryptObjectInput , output: Result<EncryptObjectOutput, Error>)
    {Operations.EncryptObjectEnsuresPublicly(input, output)}
    // The public method to be called by library consumers
    method EncryptObject ( input: EncryptObjectInput )
      returns (output: Result<EncryptObjectOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`EncryptObject
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures EncryptObjectEnsuresPublicly(input, output)
      ensures History.EncryptObject == old(History.EncryptObject) + [DafnyCallEvent(input, output)]
    {
      output := Operations.EncryptObject(config, input);
      History.EncryptObject := History.EncryptObject + [DafnyCallEvent(input, output)];
    }

    predicate DecryptObjectEnsuresPublicly(input: DecryptObjectInput , output: Result<DecryptObjectOutput, Error>)
    {Operations.DecryptObjectEnsuresPublicly(input, output)}
    // The public method to be called by library consumers
    method DecryptObject ( input: DecryptObjectInput )
      returns (output: Result<DecryptObjectOutput, Error>)
      requires
        && ValidState()
      modifies Modifies - {History} ,
               History`DecryptObject
      // Dafny will skip type parameters when generating a default decreases clause.
      decreases Modifies - {History}
      ensures
        && ValidState()
      ensures DecryptObjectEnsuresPublicly(input, output)
      ensures History.DecryptObject == old(History.DecryptObject) + [DafnyCallEvent(input, output)]
    {
      output := Operations.DecryptObject(config, input);
      History.DecryptObject := History.DecryptObject + [DafnyCallEvent(input, output)];
    }

  }
}
abstract module AbstractAwsCryptographyDbEncryptionSdkDynamoDbJsonOperations {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import opened Types = AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  type InternalConfig
  predicate ValidInternalConfig?(config: InternalConfig)
  function ModifiesInternalConfig(config: InternalConfig): set<object>
  predicate EncryptObjectEnsuresPublicly(input: EncryptObjectInput , output: Result<EncryptObjectOutput, Error>)
  // The private method to be refined by the library developer


  method EncryptObject ( config: InternalConfig , input: EncryptObjectInput )
    returns (output: Result<EncryptObjectOutput, Error>)
    requires
      && ValidInternalConfig?(config)
    modifies ModifiesInternalConfig(config)
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config)
    ensures
      && ValidInternalConfig?(config)
    ensures EncryptObjectEnsuresPublicly(input, output)


  predicate DecryptObjectEnsuresPublicly(input: DecryptObjectInput , output: Result<DecryptObjectOutput, Error>)
  // The private method to be refined by the library developer


  method DecryptObject ( config: InternalConfig , input: DecryptObjectInput )
    returns (output: Result<DecryptObjectOutput, Error>)
    requires
      && ValidInternalConfig?(config)
    modifies ModifiesInternalConfig(config)
    // Dafny will skip type parameters when generating a default decreases clause.
    decreases ModifiesInternalConfig(config)
    ensures
      && ValidInternalConfig?(config)
    ensures DecryptObjectEnsuresPublicly(input, output)
}
