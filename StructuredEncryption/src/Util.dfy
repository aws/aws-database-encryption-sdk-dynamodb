// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module StructuredEncryptionUtil {
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import UTF8
  import CMP = AwsCryptographyMaterialProvidersTypes

  // all attributes with this prefix reserved for the implementation
  const ReservedPrefix := "aws_dbe_"
  const HeaderField := ReservedPrefix + "head"
  const FooterField := ReservedPrefix + "foot"

  const BYTES_TYPE_ID : seq<uint8> := [0xFF, 0xFF];

  // Currently, only one set of sizes are supported
  const KeySize := 32 // 256 bits, for 256-bit AES keys
  const NonceSize := 12 // 96 bits, per AES-GCM nonces
  const AuthTagSize := 16
  const MSGID_LEN := 32

  type Key = x : seq<uint8> | |x| == KeySize witness *
  type Nonce = x : seq<uint8> | |x| == NonceSize witness *
  type AuthTag = x : seq<uint8> | |x| == AuthTagSize witness *
  type MessageID = x: Bytes | |x| == MSGID_LEN witness *

  type Bytes = seq<uint8>
  type GoodString = x : string | ValidString(x)

  type StructuredDataPlain = x : map<GoodString, StructuredData> | (forall k <- x :: x[k].content.Terminal?)
  type StructuredDataCanon = x : map<Bytes, StructuredData> | (forall k <- x :: x[k].content.Terminal?)
  type CryptoSchemaPlain = x : map<GoodString, CryptoSchema> | (forall k <- x :: x[k].content.Action?)
  type CryptoSchemaCanon = x : map<Bytes, CryptoSchema> | (forall k <- x :: x[k].content.Action?)
  type AuthSchemaPlain = x : map<GoodString, AuthenticateSchema> | (forall k <- x :: x[k].content.Action?)
  type AuthSchemaCanon = x : map<Bytes, AuthenticateSchema> | (forall k <- x :: x[k].content.Action?)

  // Within the context of the StructuredEncryptionClient, certains things must be true of any Algorithm Suite
  predicate method ValidSuite(alg : CMP.AlgorithmSuiteInfo)
  {
    && alg.commitment.HKDF?
    && alg.commitment.HKDF.outputKeyLength as int == KeySize
    && alg.kdf.HKDF?
    && alg.kdf.HKDF.outputKeyLength as int == KeySize
  }

  predicate method ValidString(x : string)
  {
    && |x| <  UINT64_LIMIT
    && UTF8.Encode(x).Success?
  }

  // string to Error
  function method E(s : string) : Error {
    StructuredEncryptionException(message := s)
  }

  // Is the CryptoSchemaMap flat, i.e., does it contain only Actions?
  function method CryptoSchemaMapIsFlat(data : CryptoSchemaMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Action?)
  {
    forall v <- data.Values :: v.content.Action? 
  }

  // Schema must contain only Actions
  function method AuthSchemaIsFlat(data : AuthenticateSchemaMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Action?)
  {
    forall v <- data.Values :: v.content.Action? 
  }

  // Map must contain only Terminals
  function method DataMapIsFlat(data : StructuredDataMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Terminal?)
  {
    forall v <- data.Values :: v.content.Terminal? 
  }

  // attibute is "authorized", a.k.a. included in the signature
  predicate method IsAuthAttr(x : CryptoAction)
  {
    x.ENCRYPT_AND_SIGN? || x.SIGN_ONLY?
  }

  // wrap a value in a StructuredData
  function method ValueToData(value : Bytes, typeId : Bytes)
    : StructuredData
    requires IsValid_TerminalTypeId(typeId)
  {
    StructuredData(
      content := StructuredDataContent.Terminal(
        Terminal := StructuredDataTerminal(
          typeId := typeId,
          value := value
        )
      ),
      attributes := None
    )
  }

  // extract a value from a StructuredData
  function method GetValue(data : StructuredData) : Bytes
    requires data.content.Terminal?
  {
    data.content.Terminal.value
  }

  predicate method ByteLess(x : uint8, y : uint8)
  {
    x < y
  }

  predicate method CharLess(x : char, y : char)
  {
    x < y
  }
}
