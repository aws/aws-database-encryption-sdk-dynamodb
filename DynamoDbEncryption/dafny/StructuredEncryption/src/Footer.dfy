// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "Util.dfy"
include "Header.dfy"

/*
  Intended usage :

  For encryption 
    footer := CreateFooter();
    footerAttribute := footer.makeTerminal();
  
  For decryption
    footer :- Footer.DeserializeFooter();
    footer.validate()
*/

module StructuredEncryptionFooter {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import opened MemoryMath
  import Primitives = AtomicPrimitives
  import Materials
  import Header = StructuredEncryptionHeader

  import CMP = AwsCryptographyMaterialProvidersTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import UTF8
  import Digest
  import StandardLibrary.String
  import Seq

  const RecipientTagSize := 48
  //const SignatureSize := 96
  const SignatureSize := 103
  type RecipientTag = x : Bytes | |x| == RecipientTagSize witness *
  type Signature = x : Bytes | |x| == SignatureSize witness *

  //= specification/structured-encryption/footer.md#footer-format
  //= type=implication
  //# The [Terminal Value](./structures.md#terminal-value) of the footer MUST be
  // | Field | Length (bytes) | Interpreted as |
  // | ----- | -------------- | -------------- |
  // | [Recipient Tags](#recipient-tags) | Variable. 48 bytes per Encrypted Data Key in the header | Bytes |
  // | [Signature](#signature) | 0 or 103 | Signature, if signatures are enabled |
  datatype Footer = Footer (
    tags : seq<RecipientTag>,
    sig : Option<Signature>
  ) {
    function method serialize()
      : Bytes
    {
      SerializeTags(tags) + SerializeSig(sig)
    }

    function method makeTerminal()
      : (ret : StructuredDataTerminal)
      //= specification/structured-encryption/encrypt-path-structure.md#footer-field
      //= type=implication
      //# The Footer Field TypeID MUST be 0xFFFF
      ensures ret.typeId == BYTES_TYPE_ID
      //= specification/structured-encryption/encrypt-path-structure.md#footer-field
      //= type=implication
      //# The Footer Field Value MUST be the serialized [footer](footer.md).
      ensures ret.value == serialize()
    {
      ValueToData(serialize(), BYTES_TYPE_ID)
    }

    method validate(
      client: Primitives.AtomicPrimitivesClient,
      mat : CMP.DecryptionMaterials,
      edks : CMP.EncryptedDataKeyList,
      data : CanonCryptoList,
      header : Bytes)
      returns (ret : Result<bool, Error>)
      requires Materials.DecryptionMaterialsWithPlaintextDataKey(mat)
      requires ValidSuite(mat.algorithmSuite)
      requires Header.ValidEncryptionContext(mat.encryptionContext)
      //= specification/structured-encryption/decrypt-path-structure.md#verify-signatures
      //= type=implication
      //# The number of [HMACs in the footer](./footer.md#hmacs)
      //# MUST be the number of [Encrypted Data Keys in the header](./header.md#encrypted-data-keys).
      ensures ret.Success? ==>
                |edks| == |tags|

      modifies client.Modifies
      requires client.ValidState()
      ensures client.ValidState()
    {
      :- Need(|edks| == |tags|, E("There are a different number of recipient tags in the stored header than there are in the decryption materials."));
      var canonicalHash :- CanonHash(data, header, mat.encryptionContext);

      var input := Prim.HMacInput (
        digestAlgorithm := mat.algorithmSuite.symmetricSignature.HMAC,
        key := mat.symmetricSigningKey.value,
        message := canonicalHash
      );
      var hashR := client.HMac(input);
      var hash :- hashR.MapFailure(e => AwsCryptographyPrimitives(e));
      // is there any way to get "48" from alg.symmetricSignature.HMAC?
      :- Need(|hash| == 48, E("Bad hash length"));

      var foundTag := false;
      for i := 0 to |tags| {
        //= specification/structured-encryption/footer.md#recipient-tag-verification
        //# Recipient Tag comparisons MUST be constant time operations.
        if ConstantTimeEquals(hash, tags[i]) {
          foundTag := true;
          break;
        }
      }

      //= specification/structured-encryption/footer.md#recipient-tag-verification
      //# Verification MUST fail unless at least one of the [Recipient Tags](#recipient-tags)
      //# matches a calculated recipient tag using the provided symmetricSigningKey.
      :- Need(foundTag, E("Signature of record does not match the signature computed when the record was encrypted."));

      :- Need(sig.Some? == mat.algorithmSuite.signature.ECDSA?, E("Internal error. Signature both does and does not exist."));
      //= specification/structured-encryption/footer.md#signature-verification
      //# If the footer contains a signature, this signature MUST be verified using the
      //# [asymmetric signature algorithm](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
      //# indicated by the algorithm suite.
      if sig.Some? {
        var verInput := Prim.ECDSAVerifyInput(
          signatureAlgorithm := mat.algorithmSuite.signature.ECDSA.curve,
          verificationKey := mat.verificationKey.value,
          message := canonicalHash,
          signature := sig.value
        );
        var verR := client.ECDSAVerify(verInput);
        var ver :- verR.MapFailure(e => AwsCryptographyPrimitives(e));
        :- Need(ver, E("Signature did not verify"));
      }
      return Success(true);
    }
  }

  const ENCRYPTED : UTF8.ValidUTF8Bytes :=
    var s := [0x45, 0x4e, 0x43, 0x52, 0x59, 0x50, 0x54, 0x45, 0x44];
    assert s == UTF8.EncodeAscii("ENCRYPTED");
    s

  const PLAINTEXT : UTF8.ValidUTF8Bytes :=
    var s := [0x50, 0x4c, 0x41, 0x49, 0x4e, 0x54, 0x45, 0x58, 0x54];
    assert s == UTF8.EncodeAscii("PLAINTEXT");
    s



  // Given a StructuredDataTerminal, return the canonical value for the type, for use in the footer checksum calculations
  function method GetCanonicalType(value : StructuredDataTerminal, isEncrypted : bool)
    : Result<Bytes, Error>
  {
    if isEncrypted then
      :- Need(2 <= |value.value| && HasUint64Len(value.value), E("Bad length."));
      Success(UInt64ToSeq((|value.value| - 2) as uint64) + ENCRYPTED)
    else
      :- Need(HasUint64Len(value.value), E("Bad length."));
      Success(UInt64ToSeq((|value.value|) as uint64) + PLAINTEXT + value.typeId)
  }

  function method GetCanonicalEncryptedField(fieldName : CanonicalPath, value : StructuredDataTerminal)
    : (ret : Result<Bytes, Error>)
    ensures ret.Success? ==>
              //= specification/structured-encryption/footer.md#canonical-encrypted-field
              //= type=implication
              //# The canonical form of an encrypted field MUST be
              //# | Field | Length (bytes) | Interpreted as |
              //# | ----- | -------------- | -------------- |
              //# | The [canonical path](./header.md#canonical-path) of the field name | Variable | Bytes |
              //# | encrypted data length - 2 | 8 | 64-bit integer |
              //# | "ENCRYPTED" | 9 | Literal Ascii text |
              //# | TypeID | 2 | the type ID of the unencrypted Terminal |
              //# | value | Variable | the encrypted Terminal value |
              && 2 <= |value.value|
              && HasUint64Len(value.value)
              && ret.value ==
                 fieldName
                 + UInt64ToSeq((|value.value| - 2) as uint64)
                 + ENCRYPTED
                 + value.value // this is 2 bytes of unencrypted type, followed by encrypted value
  {
    :- Need(2 <= |value.value| && HasUint64Len(value.value), E("Bad length."));
    Success(
      fieldName
      + UInt64ToSeq((|value.value| - 2) as uint64)
      + ENCRYPTED
      + value.value
    )
  }

  function method GetCanonicalPlaintextField(fieldName : CanonicalPath, value : StructuredDataTerminal)
    : (ret : Result<Bytes, Error>)
    ensures ret.Success? ==>
              //= specification/structured-encryption/footer.md#canonical-plaintext-field
              //= type=implication
              //# The canonical form of a plaintext field MUST be
              //# | Field | Length (bytes) | Interpreted as |
              //# | ----- | -------------- | -------------- |
              //# | The [canonical path](./header.md#canonical-path) of the field name | Variable | Bytes |
              //# | data length | 8 | 64-bit integer |
              //# | "PLAINTEXT" | 9 | Literal Ascii text |
              //# | TypeID | 2 | the type ID of the Terminal |
              //# | value | Variable | the Terminal value |
              && HasUint64Len(value.value)
              && ret.value ==
                 fieldName
                 + UInt64ToSeq((|value.value|) as uint64)
                 + PLAINTEXT
                 + value.typeId
                 + value.value
  {
    :- Need(HasUint64Len(value.value), E("Bad length."));
    Success(
      fieldName
      + UInt64ToSeq((|value.value|) as uint64)
      + PLAINTEXT
      + value.typeId
      + value.value
    )
  }

  // Given a key value pair, return the canonical value for use in the footer checksum calculations
  function method GetCanonicalItem(data : CanonCryptoItem)
    : (ret : Result<Bytes, Error>)
  {
    if data.action == ENCRYPT_AND_SIGN then
      GetCanonicalEncryptedField(data.key, data.data)
    else
      GetCanonicalPlaintextField(data.key, data.data)
  }

  function CanonContent (data : CanonCryptoList)
    : Result<Bytes, Error>
  {
    if |data| == 0 then
      Success([])
    else if data[0].action == DO_NOTHING then
      CanonContent(data[1..])
    else
      var tail :- CanonContent(data[1..]);
      var newPart :- GetCanonicalItem(data[0]);
      Success(newPart + tail)
  } by method {
    SequenceIsSafeBecauseItIsInMemory(data);
    var i: uint64 := |data| as uint64;
    var vectors : Bytes := [];

    while i != 0
      decreases i
      invariant Success(vectors) == CanonContent(data[i..])
    {
      i := i - 1;
      if data[i].action != DO_NOTHING {
        var test := GetCanonicalItem(data[i]);
        if test.Failure? {
          ghost var j := i;
          while j != 0
            decreases j
            invariant Failure(test.error) == CanonContent(data[j..])
          {
            j := j - 1;
          }
          return Failure(test.error);
        }
        vectors := test.value + vectors;
      }
    }

    return Success(vectors);
  }


  function method CanonRecord (
    data : CanonCryptoList,
    header : Bytes,
    enc : Header.CMPEncryptionContext
  ) : (ret : Result<Bytes, Error>)

    ensures ret.Success? ==>
              //= specification/structured-encryption/footer.md#canonical-record
              //= type=implication
              //# The canonical form of a record MUST be
              //# | Field | Length (bytes) | Interpreted as |
              //# | ----- | -------------- | -------------- |
              //# | header | Variable | The full serialized header with commitment |
              //# | AAD Length | 8 | 64-bit integer, the length of the following AAD data |
              //# | AAD | Variable | The serialization of the Encryption Context from the Encryption Materials |
              //# | Field Data | Variable | For each [signed field](#signed-fields), ordered lexicographically by [canonical path](./header.md#canonical-path), the [canonical field](#canonical-field).
              && CanonContent(data).Success?
              && var canon := CanonContent(data).value;
              && var AAD := Header.SerializeContext(enc);
              && HasUint64Len(AAD)
              && var len := UInt64ToSeq(|AAD| as uint64);
              && ret.value ==
                 header
                 + len
                 + AAD
                 + canon
  {
    var canon :- CanonContent(data);
    var AAD := Header.SerializeContext(enc);
    :- Need(HasUint64Len(AAD), E("AAD too long."));
    var len := UInt64ToSeq(|AAD| as uint64);
    Success(header + len + AAD + canon)
  }

  method CanonHash (
    data : CanonCryptoList,
    header : Bytes,
    enc : Header.CMPEncryptionContext
  ) returns (ret : Result<Bytes, Error>)
    ensures ret.Success? ==>
              |ret.value| == 48
    //= specification/structured-encryption/footer.md#hash-calculation
    //= type=implication
    //# The canonical hash of a record MUST be the SHA384 of the canonical form of the record.
  {
    var data :- CanonRecord(data, header, enc);
    var resultR := Digest.Digest(Prim.DigestInput(digestAlgorithm := Prim.SHA_384, message := data));
    return resultR.MapFailure(e => AwsCryptographyPrimitives(e));
  }

  // return the footer value for the StructuredData
  method CreateFooter(
    client: Primitives.AtomicPrimitivesClient,
    mat : CMP.EncryptionMaterials,
    data : CanonCryptoList,
    header : Bytes)
    returns (ret : Result<Footer, Error>)
    requires ValidSuite(mat.algorithmSuite)
    requires Materials.EncryptionMaterialsHasPlaintextDataKey(mat)
    requires Header.ValidEncryptionContext(mat.encryptionContext)

    ensures (ret.Success? && mat.algorithmSuite.signature.ECDSA?) ==>
              //= specification/structured-encryption/footer.md#signature
              //= type=implication
              //# The `signature`, if it exists, MUST be calculated using the
              //# [asymmetric signature algorithm](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
              //# indicated by the algorithm suite.
              && var history := client.History.ECDSASign;
              && 0 < |history|
              && var signInput := Seq.Last(history).input;
              && signInput.signatureAlgorithm == mat.algorithmSuite.signature.ECDSA.curve
    //  Can't do signInput.message == cHash, because SHA is a method, not a function

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var canonicalHash :- CanonHash(data, header, mat.encryptionContext);
    var tags : seq<RecipientTag> := [];
    for i := 0 to |mat.encryptedDataKeys|
      invariant |tags| == i
    {
      //= specification/structured-encryption/footer.md#recipient-tags
      //# the Recipient Tag MUST be MUST be calculated over the [Canonical Hash](#canonical-hash)
      //# using the [symmetric signature algorithm](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
      //# indicated in the algorithm suite,
      //# and the
      //# [symmetric signing keys](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#symmetric-signing-keys)
      //# in the encryption materials.
      var input := Prim.HMacInput (
        digestAlgorithm := mat.algorithmSuite.symmetricSignature.HMAC,
        key := mat.symmetricSigningKeys.value[i],
        message := canonicalHash
      );
      var hashR := client.HMac(input);
      var hash :- hashR.MapFailure(e => AwsCryptographyPrimitives(e));
      // is there any way to get "48" from alg.symmetricSignature.HMAC?
      :- Need(|hash| == 48, E("Bad hash length"));

      //= specification/structured-encryption/footer.md#recipient-tags
      //# the HMAC values MUST have the same order as the
      //# [symmetric signing keys](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#symmetric-signing-keys)
      //# used to calculate them.
      tags := tags + [hash];
    }
    //= specification/structured-encryption/footer.md#recipient-tags
    //= type=implication
    //# There MUST be one Recipient Tag for each Encrypted Data Key in the [header](./header.md#encrypted-data-keys)
    assert |tags| == |mat.encryptedDataKeys|;

    if mat.algorithmSuite.signature.ECDSA? {
      //= specification/structured-encryption/footer.md#signature
      //# The `signature`, if it exists, MUST be calculated over the [Canonical Hash](#canonical-hash),
      //# using the asymmetric signing key in the encryption materials.
      var verInput := Prim.ECDSASignInput(
        signatureAlgorithm := mat.algorithmSuite.signature.ECDSA.curve,
        signingKey := mat.signingKey.value,
        message := canonicalHash
      );
      var sigR := client.ECDSASign(verInput);
      var sig :- sigR.MapFailure(e => AwsCryptographyPrimitives(e));
      //assert |sig| == SignatureSize;
      :- Need(|sig| == SignatureSize, E("Signature is " + String.Base10Int2String(|sig|) + " bytes, should have been " + String.Base10Int2String(SignatureSize) + " bytes."));
      return Success(Footer(tags, Some(sig)));
    } else {
      return Success(Footer(tags, None));
    }
  }

  function SerializeTags(tags : seq<RecipientTag>)
    : Bytes
  {
    if |tags| == 0 then
      []
    else
      tags[0] + SerializeTags(tags[1..])
  } by method {
    var result : Bytes := [];
    SequenceIsSafeBecauseItIsInMemory(tags);
    for i : uint64 := |tags| as uint64 downto 0
      invariant result == SerializeTags(tags[i..])
    {
      result := tags[i] + result;
    }
    return result;
  }

  function method SerializeSig(sig : Option<Signature>)
    : Bytes
  {
    if sig.Some? then
      sig.value
    else
      []
  }

  function method GatherTags(data : Bytes)
    : seq<RecipientTag>
    requires |data| % RecipientTagSize == 0
  {
    if |data| == 0 then
      []
    else
      [data[0..RecipientTagSize]] + GatherTags(data[RecipientTagSize..])
  }

  function method DeserializeFooter(data : Bytes, hasSig : bool)
    : Result<Footer, Error>
  {
    if hasSig then
      :- Need((|data| - SignatureSize)  % RecipientTagSize == 0, E("Mangled signed footer has strange size"));
      :- Need(|data| >= RecipientTagSize + SignatureSize, E("Footer too short."));
      Success(Footer(GatherTags(data[..|data|-SignatureSize]), Some(data[|data|-SignatureSize..])))
    else
      :- Need(|data| % RecipientTagSize == 0, E("Mangled unsigned footer has strange size"));
      :- Need(|data| >= RecipientTagSize, E("Footer too short."));
      Success(Footer(GatherTags(data), None))
  }
}
