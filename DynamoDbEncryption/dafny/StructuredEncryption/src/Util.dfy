// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"

module StructuredEncryptionUtil {
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt

  import UTF8
  import CMP = AwsCryptographyMaterialProvidersTypes
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import AlgorithmSuites
  import SortedSets
  import Base64

  // all attributes with this prefix reserved for the implementation
  const ReservedPrefix := "aws_dbe_"

  const HeaderField := ReservedPrefix + "head"
  const FooterField := ReservedPrefix + "foot"
  const HeaderPath : Path := [member(StructureSegment(key := HeaderField))]
  const FooterPath : Path := [member(StructureSegment(key := FooterField))]
  const ReservedCryptoContextPrefixString := "aws-crypto-"
  const ReservedCryptoContextPrefixUTF8 := UTF8.EncodeAscii(ReservedCryptoContextPrefixString)

  const ATTR_PREFIX := ReservedCryptoContextPrefixString + "attr."
  const EC_ATTR_PREFIX : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii(ATTR_PREFIX)
  const LEGEND := ReservedCryptoContextPrefixString + "legend"
  const LEGEND_UTF8 : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii(LEGEND)
  const LEGEND_STRING : char := 'S'
  const LEGEND_NUMBER : char := 'N'
  const LEGEND_LITERAL : char := 'L'
  const LEGEND_BINARY : char := 'B'

  const NULL_STR : string := "null"
  const NULL_UTF8 : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii(NULL_STR)
  const TRUE_STR : string := "true"
  const TRUE_UTF8 : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii(TRUE_STR)
  const FALSE_STR : string := "false"
  const FALSE_UTF8 : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii(FALSE_STR)

  datatype CanonCryptoItem = CanonCryptoItem (
    key : CanonicalPath,
    origKey : Path,
    data : StructuredDataTerminal,
    action : CryptoAction
  )
  datatype CanonAuthItem = CanonAuthItem (
    key : CanonicalPath,
    origKey : Path,
    data : StructuredDataTerminal,
    action : AuthenticateAction
  )
  type CanonCryptoList = seq<CanonCryptoItem>
  type CanonAuthList = seq<CanonAuthItem>

  //= specification/structured-encryption/encrypt-path-structure.md#header-field
  //= type=implication
  //# The Header Field name MUST be `aws_dbe_head`

  //= specification/structured-encryption/encrypt-path-structure.md#footer-field
  //= type=implication
  //# The Footer Field name MUST be `aws_dbe_foot`
  lemma CheckNames()
    ensures HeaderField == "aws_dbe_head"
    ensures FooterField == "aws_dbe_foot"
  {}

  const TYPEID_LEN := 2
  const BYTES_TYPE_ID : seq<uint8> := [0xFF, 0xFF]
  lemma BYTES_TYPE_ID_OK()
    ensures |BYTES_TYPE_ID| == TYPEID_LEN
  {}

  // Currently, only one set of sizes are supported
  const KeySize := 32 // 256 bits, for 256-bit AES keys
  const NonceSize := 12 // 96 bits, per AES-GCM nonces
  const AuthTagSize := 16
  const MSGID_LEN := 32
  const DbeAlgorithmFamily : uint8 := 0x67

  lemma ValidSuiteSizes(alg : CMP.AlgorithmSuiteInfo)
    requires ValidSuite(alg)
    ensures AlgorithmSuites.GetEncryptKeyLength(alg) as int == KeySize
    ensures alg.encrypt.AES_GCM.keyLength as int == KeySize
    ensures alg.encrypt.AES_GCM.tagLength as int == AuthTagSize
    ensures alg.encrypt.AES_GCM.ivLength as int == NonceSize
  {}

  type Key = x : seq<uint8> | |x| == KeySize witness *
  type Nonce = x : seq<uint8> | |x| == NonceSize witness *
  type AuthTag = x : seq<uint8> | |x| == AuthTagSize witness *
  type MessageID = x: Bytes | |x| == MSGID_LEN witness *

  type Bytes = seq<uint8>
  type CanonicalPath = seq<uint8>

  type GoodString = x : string | ValidString(x)
  predicate method ValidString(x : string)
  {
    && |x| <  UINT64_LIMIT
    && UTF8.Encode(x).Success?
  }

  // Within the context of the StructuredEncryptionClient, certain things must be true of any Algorithm Suite
  predicate method ValidSuite(alg : CMP.AlgorithmSuiteInfo)
  {
    alg.id.DBE? && AlgorithmSuites.DBEAlgorithmSuite?(alg)
  }

  // string to Error
  function method E(s : string) : Error {
    StructuredEncryptionException(message := s)
  }

  // sequences are equal if zero is returned
  // Some care should be taken to ensure that target languages don't over optimize this.
  function method {:tailrecursion} ConstantTimeCompare(a : Bytes, b : Bytes, acc : bv8 := 0) : bv8
    requires |a| == |b|
  {
    if |a| == 0 then
      acc
    else
      var x := ((a[0] as bv8) ^ (b[0] as bv8));
      ConstantTimeCompare(a[1..], b[1..], x | acc)
  }

  predicate method ConstantTimeEquals(a : Bytes, b : Bytes)
    requires |a| == |b|
  {
    ConstantTimeCompare(a, b) == 0
  }

  // attribute is "authorized", a.k.a. included in the signature
  predicate method IsAuthAttr(x : CryptoAction)
  {
    x.ENCRYPT_AND_SIGN? || x.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT? || x.SIGN_ONLY?
  }

  // wrap a value in a StructuredData
  function method ValueToData(value : Bytes, typeId : Bytes)
    : StructuredDataTerminal
    requires IsValid_TerminalTypeId(typeId)
  {
    StructuredDataTerminal(typeId := typeId, value := value)
  }

  // extract a value from a StructuredData
  function method GetValue(data : StructuredDataTerminal) : Bytes
  {
    data.value
  }

  predicate method ByteLess(x : uint8, y : uint8)
  {
    x < y
  }

  predicate method CharLess(x : char, y : char)
  {
    x < y
  }

  //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#type-id
  //= type=implication
  //# Type ID indicates what type a DynamoDB Attribute Value MUST
  //# be serialized and deserialized as.
  //# | Attribute Value Data Type | Terminal Type ID |
  //# | ------------------------- | ---------------- |
  //# | Null (NULL)               | 0x0000           |
  //# | String (S)                | 0x0001           |
  //# | Number (N)                | 0x0002           |
  //# | Binary (B)                | 0xFFFF           |
  //# | Boolean (BOOL)            | 0x0004           |
  //# | String Set (SS)           | 0x0101           |
  //# | Number Set (NS)           | 0x0102           |
  //# | Binary Set (BS)           | 0x01FF           |
  //# | Map (M)                   | 0x0200           |
  //# | List (L)                  | 0x0300           |
  const TERM_T : uint8 := 0x00
  const SET_T  : uint8 := 0x01
  const MAP_T  : uint8 := 0x02
  const LIST_T : uint8 := 0x03
  const NULL_T : uint8 := 0x00
  const STRING_T  : uint8 := 0x01
  const NUMBER_T  : uint8 := 0x02
  const BINARY_T : uint8 := 0xFF
  const BOOLEAN_T : uint8 := 0x04

  const NULL       : TerminalTypeId := [TERM_T, NULL_T]
  const STRING     : TerminalTypeId := [TERM_T, STRING_T]
  const NUMBER     : TerminalTypeId := [TERM_T, NUMBER_T]
  const BINARY     : TerminalTypeId := [0xFF, 0xFF]
  const BOOLEAN    : TerminalTypeId := [TERM_T, BOOLEAN_T]
  const STRING_SET : TerminalTypeId := [SET_T,  STRING_T]
  const NUMBER_SET : TerminalTypeId := [SET_T,  NUMBER_T]
  const BINARY_SET : TerminalTypeId := [SET_T,  BINARY_T]
  const MAP        : TerminalTypeId := [MAP_T,  NULL_T]
  const LIST       : TerminalTypeId := [LIST_T, NULL_T]

  method EcAsString(ec : CMP.EncryptionContext) returns (output : map<string, string>)
  {
    var keys : seq<UTF8.ValidUTF8Bytes> := SortedSets.ComputeSetToOrderedSequence2(ec.Keys, ByteLess);
    var ret : map<string, string> := map[];
    for i := 0 to |keys| {
      var key :- expect UTF8.Decode(keys[i]);
      var value :- expect UTF8.Decode(ec[keys[i]]);
      ret := ret[key := value];
    }
    return ret;
  }

  method PrintEncryptionContext(ec : CMP.EncryptionContext, name : string)
  {
    var keys : seq<UTF8.ValidUTF8Bytes> := SortedSets.ComputeSetToOrderedSequence2(ec.Keys, ByteLess);
    print name, " := {\n";
    for i := 0 to |keys| {
      var key :- expect UTF8.Decode(keys[i]);
      var value :- expect UTF8.Decode(ec[keys[i]]);
      print "  ", key, " := ", value, "\n";
    }
    print "}\n";
  }

  function method EncodeTerminal(t : StructuredDataTerminal) : (ret : UTF8.ValidUTF8Bytes)
    //= specification/dynamodb-encryption-client/encrypt-item.md#base-context-value-version-1
    //= type=implication
    //# The value MUST be the UTF8 Encoding of the
    //# [Base 64 encoded](https://www.rfc-editor.org/rfc/rfc4648),
    //# of the concatenation of the bytes `typeID + serializedValue`
    //# where `typeId` is the attribute's [type ID](./ddb-attribute-serialization.md#type-id)
    //# and `serializedValue` is the attribute's value serialized according to
    //# [Attribute Value Serialization](./ddb-attribute-serialization.md#attribute-value-serialization).
    ensures ret == UTF8.EncodeAscii(Base64.Encode(t.typeId + t.value))
  {
    UTF8.EncodeAscii(Base64.Encode(t.typeId + t.value))
  }

  function method DecodeTerminal(t : UTF8.ValidUTF8Bytes) : (ret : Result<StructuredDataTerminal, string>)
  {
    var utf8DecodedVal :- UTF8.Decode(t);
    var base64DecodedVal :- Base64.Decode(utf8DecodedVal);
    :- Need(|base64DecodedVal| >= 2, "Invalid serialization of DDB Attribute in encryption context.");
    var typeId := base64DecodedVal[..2];
    var serializedValue := base64DecodedVal[2..];
    Success(StructuredDataTerminal(value := serializedValue, typeId := typeId))
  }

}
