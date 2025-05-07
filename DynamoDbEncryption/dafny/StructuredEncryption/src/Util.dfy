// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"

module StructuredEncryptionUtil {
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.MemoryMath

  import UTF8
  import CMP = AwsCryptographyMaterialProvidersTypes
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import AlgorithmSuites
  import SortedSets
  import Base64
  import opened Seq

  // all attributes with this prefix reserved for the implementation
  const ReservedPrefix := "aws_dbe_"

  const HeaderField := ReservedPrefix + "head"
  const FooterField := ReservedPrefix + "foot"
  const HeaderPath : Path := [member(StructureSegment(key := HeaderField))]
  const FooterPath : Path := [member(StructureSegment(key := FooterField))]
  const HeaderPaths : seq<Path> := [HeaderPath, FooterPath]
  const ReservedCryptoContextPrefixString := "aws-crypto-"

  const ReservedCryptoContextPrefixUTF8 : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x77, 0x73, 0x2d, 0x63, 0x72, 0x79, 0x70, 0x74, 0x6f, 0x2d];
    assert s == UTF8.EncodeAscii(ReservedCryptoContextPrefixString);
    s

  const ATTR_PREFIX := ReservedCryptoContextPrefixString + "attr."

  const EC_ATTR_PREFIX : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x77, 0x73, 0x2d, 0x63, 0x72, 0x79, 0x70, 0x74, 0x6f, 0x2d, 0x61, 0x74, 0x74, 0x72, 0x2e];
    assert s == UTF8.EncodeAscii(ATTR_PREFIX);
    s

  const LEGEND := ReservedCryptoContextPrefixString + "legend"

  const LEGEND_UTF8 : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x77, 0x73, 0x2d, 0x63, 0x72, 0x79, 0x70, 0x74, 0x6f, 0x2d, 0x6c, 0x65, 0x67, 0x65, 0x6e, 0x64];
    assert s == UTF8.EncodeAscii(LEGEND);
    s

  const LEGEND_STRING : char := 'S'
  const LEGEND_NUMBER : char := 'N'
  const LEGEND_LITERAL : char := 'L'
  const LEGEND_BINARY : char := 'B'

  const NULL_STR : string := "null"
  const NULL_UTF8 : UTF8.ValidUTF8Bytes :=
    var s := [0x6e, 0x75, 0x6c, 0x6c];
    assert s == UTF8.EncodeAscii(NULL_STR);
    s

  const TRUE_STR : string := "true"
  const TRUE_UTF8 : UTF8.ValidUTF8Bytes :=
    var s := [0x74, 0x72, 0x75, 0x65];
    assert s == UTF8.EncodeAscii(TRUE_STR);
    s

  const FALSE_STR : string := "false"
  const FALSE_UTF8 : UTF8.ValidUTF8Bytes :=
    var s := [0x66, 0x61, 0x6c, 0x73, 0x65];
    assert s == UTF8.EncodeAscii(FALSE_STR);
    s

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

  function method CryptoListToSet(xs: CryptoList) : (ret : set<Path>)
    ensures |xs| == 0 ==> |ret| == 0
    ensures |xs| == 1 ==> ret == {xs[0].key}
    ensures |xs| == 1 ==> |ret| == 1
  {
    set k <- xs :: k.key
  }

  function method CanonCryptoListToSet(xs: CanonCryptoList) : (ret : set<Path>)
    ensures |xs| == 0 ==> |ret| == 0
    ensures |xs| == 1 ==> ret == {xs[0].origKey}
    ensures |xs| == 1 ==> |ret| == 1
  {
    set k <- xs :: k.origKey
  }

  function method AuthListToSet(xs: AuthList) : (ret : set<Path>)
    ensures |xs| == 0 ==> |ret| == 0
    ensures |xs| == 1 ==> ret == {xs[0].key}
    ensures |xs| == 1 ==> |ret| == 1
  {
    set k <- xs :: k.key
  }

  predicate method CryptoListHasNoDuplicatesFromSet(xs: CryptoList)
  {
    SequenceIsSafeBecauseItIsInMemory(xs);
    SetIsSafeBecauseItIsInMemory(CryptoListToSet(xs));
    |CryptoListToSet(xs)| as uint64 == |xs| as uint64
  }

  predicate method AuthListHasNoDuplicatesFromSet(xs: AuthList)
  {
    SequenceIsSafeBecauseItIsInMemory(xs);
    SetIsSafeBecauseItIsInMemory(AuthListToSet(xs));
    |AuthListToSet(xs)| as uint64 == |xs| as uint64
  }

  predicate CryptoListHasNoDuplicates(xs: CryptoList)
  {
    forall i, j :: 0 <= i < j < |xs| ==> xs[i].key != xs[j].key
  }

  predicate AuthListHasNoDuplicates(xs: AuthList)
  {
    forall i, j :: 0 <= i < j < |xs| ==> xs[i].key != xs[j].key
  }

  predicate CanonCryptoListHasNoDuplicates(xs: CanonCryptoList)
  {
    forall i, j :: 0 <= i < j < |xs| ==> xs[i].origKey != xs[j].origKey
  }

  predicate CanonAuthListHasNoDuplicates(xs: CanonAuthList)
  {
    forall i, j :: 0 <= i < j < |xs| ==> xs[i].origKey != xs[j].origKey
  }

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

  ghost const TYPEID_LEN := 2
  const TYPEID_LEN64 : uint64 := 2
  const BYTES_TYPE_ID : seq<uint8> := [0xFF, 0xFF]
  lemma BYTES_TYPE_ID_OK()
    ensures |BYTES_TYPE_ID| == TYPEID_LEN
  {}

  // Currently, only one set of sizes are supported
  ghost const KeySize := 32 // 256 bits, for 256-bit AES keys
  ghost const NonceSize := 12 // 96 bits, per AES-GCM nonces
  ghost const AuthTagSize := 16
  ghost const MSGID_LEN := 32
  const KeySize64 : uint64 := 32 // 256 bits, for 256-bit AES keys
  const NonceSize64 : uint64 := 12 // 96 bits, per AES-GCM nonces
  const AuthTagSize64 : uint64 := 16
  const MSGID_LEN64 : uint64  := 32
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
    && HasUint64Len(x)
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
  function method {:tailrecursion} ConstantTimeCompare(a : Bytes, b : Bytes, pos : uint64 := 0, acc : bv8 := 0) : bv8
    requires |a| == |b|
    requires 0 <= pos as nat <= |a|
    decreases |a| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(a);
    if |a| as uint64 == pos then
      acc
    else
      var x := ((a[pos] as bv8) ^ (b[pos] as bv8));
      ConstantTimeCompare(a, b, pos+1, x | acc)
  }

  predicate method ConstantTimeEquals(a : Bytes, b : Bytes)
    requires |a| == |b|
  {
    ConstantTimeCompare(a, b) == 0
  }

  // attribute is "authorized", a.k.a. included in the signature
  predicate method IsAuthAttr(x : CryptoAction)
  {
    !x.DO_NOTHING?
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
    SequenceIsSafeBecauseItIsInMemory(keys);
    for i : uint64 := 0 to |keys| as uint64 {
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
    ensures ret == UTF8.Encode(Base64.Encode(t.typeId + t.value)).value
  {
    var base := Base64.Encode(t.typeId + t.value);
    UTF8.Encode(base).value
  }

  function method DecodeTerminal(t : UTF8.ValidUTF8Bytes) : (ret : Result<StructuredDataTerminal, string>)
  {
    var utf8DecodedVal :- UTF8.Decode(t);
    var base64DecodedVal :- Base64.Decode(utf8DecodedVal);
    SequenceIsSafeBecauseItIsInMemory(base64DecodedVal);
    :- Need(|base64DecodedVal| as uint64 >= 2, "Invalid serialization of DDB Attribute in encryption context.");
    var typeId := base64DecodedVal[..2 as uint32];
    var serializedValue := base64DecodedVal[2 as uint32..];
    Success(StructuredDataTerminal(value := serializedValue, typeId := typeId))
  }

  lemma CryptoListNoDupFromMap(xs: seq<CryptoItem>)
    requires HasNoDuplicates(Map((x: CryptoItem) => x.key, xs))
    ensures CryptoListHasNoDuplicates(xs)
  {
    var ys := Map((x: CryptoItem) => x.key, xs);
    assert forall i, j | 0 <= i < j < |xs| :: ys[i] != ys[j] by {
      reveal HasNoDuplicates();
    }
    assert forall i | 0 <= i < |xs| :: ys[i] == xs[i].key;
  }

  lemma AuthListNoDupFromMap(xs: seq<AuthItem>)
    requires HasNoDuplicates(Map((x: AuthItem) => x.key, xs))
    ensures AuthListHasNoDuplicates(xs)
  {
    var ys := Map((x: AuthItem) => x.key, xs);
    assert forall i, j | 0 <= i < j < |xs| :: ys[i] != ys[j] by {
      reveal HasNoDuplicates();
    }
    assert forall i | 0 <= i < |xs| :: ys[i] == xs[i].key;
  }

  lemma CryptoListCard(xs: seq<CryptoItem>)
    ensures |ToSet(Map((x: CryptoItem) => x.key, xs))| == |CryptoListToSet(xs)|
  {
    reveal ToSet();
    var ys := Map((x: CryptoItem) => x.key, xs);
    forall x ensures x in ToSet(ys) <==> x in CryptoListToSet(xs) {
      assert x in ToSet(ys) ==> x in CryptoListToSet(xs);
      assert x in CryptoListToSet(xs) ==> x in ToSet(ys) by {
        if x in CryptoListToSet(xs) {
          var i :| 0 <= i < |xs| && xs[i].key == x;
          assert ys[i] == x by {
            calc == {
              ys[i];
              Map((x: CryptoItem) => x.key, xs)[i];
              xs[i].key;
              x;
            }
          }
        } else {}
      }
    }
    assert ToSet(ys) == CryptoListToSet(xs);
  }

  lemma AuthListCard(xs: seq<AuthItem>)
    ensures |ToSet(Map((x: AuthItem) => x.key, xs))| == |AuthListToSet(xs)|
  {
    reveal ToSet();
    var ys := Map((x: AuthItem) => x.key, xs);
    forall x ensures x in ToSet(ys) <==> x in AuthListToSet(xs) {
      assert x in ToSet(ys) ==> x in AuthListToSet(xs);
      assert x in AuthListToSet(xs) ==> x in ToSet(ys) by {
        if x in AuthListToSet(xs) {
          var i :| 0 <= i < |xs| && xs[i].key == x;
          assert ys[i] == x by {
            calc == {
              ys[i];
              Map((x: AuthItem) => x.key, xs)[i];
              xs[i].key;
              x;
            }
          }
        } else {}
      }
    }
    assert ToSet(ys) == AuthListToSet(xs);
  }

  lemma SetSizeImpliesCryptoListHasNoDuplicates(xs: seq<CryptoItem>)
    requires CryptoListHasNoDuplicatesFromSet(xs)
    ensures CryptoListHasNoDuplicates(xs)
  {
    var ys := Map((x: CryptoItem) => x.key, xs);
    CryptoListCard(xs);
    LemmaNoDuplicatesCardinalityOfSet(ys);
    CryptoListNoDupFromMap(xs);
  }

  lemma SetSizeImpliesAuthListHasNoDuplicates(xs: seq<AuthItem>)
    requires AuthListHasNoDuplicatesFromSet(xs)
    ensures AuthListHasNoDuplicates(xs)
  {
    var ys := Map((x: AuthItem) => x.key, xs);
    AuthListCard(xs);
    LemmaNoDuplicatesCardinalityOfSet(ys);
    AuthListNoDupFromMap(xs);
  }


}
