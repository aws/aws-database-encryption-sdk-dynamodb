// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
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
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import Aws.Cryptography.Primitives
  import Materials
  import Header = StructuredEncryptionHeader

  import CMP = AwsCryptographyMaterialProvidersTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import UTF8
  import Digest
  import StandardLibrary.String

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
      : (ret : StructuredData)
      ensures ret.content.Terminal?
      //= specification/structured-encryption/encrypt-structure.md#footer-field
      //= type=implication
      //# The Footer Field TypeID MUST be 0xFFFF
      ensures ret.content.Terminal.typeId == BYTES_TYPE_ID
      //= specification/structured-encryption/encrypt-structure.md#footer-field
      //= type=implication
      //# The Footer Field Value MUST be the serialized [footer](footer.md).
      ensures ret.content.Terminal.value == serialize()
    {
      ValueToData(serialize(), BYTES_TYPE_ID)
    }

    method validate(
      client: Primitives.AtomicPrimitivesClient,
      mat : CMP.DecryptionMaterials,
      edks : CMP.EncryptedDataKeyList,
      signedFields : seq<CanonicalPath>,
      encFields : seq<CanonicalPath>,
      encData : StructuredDataCanon,
      allData : StructuredDataCanon,
      header : Bytes)
      returns (ret : Result<bool, Error>)
      requires Materials.DecryptionMaterialsWithPlaintextDataKey(mat)
      requires ValidSuite(mat.algorithmSuite)
      requires Header.ValidEncryptionContext(mat.encryptionContext)
      requires forall k <- signedFields :: k in allData
      requires forall k <- encFields :: k in allData
      requires forall k <- encData :: encData[k].content.Terminal?
      requires forall k <- allData :: allData[k].content.Terminal?
      //= specification/structured-encryption/decrypt-structure.md#verify-signatures
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
      var canonicalHash :- CanonHash(signedFields, encFields, encData, allData, header, mat.encryptionContext);

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
        if hash == tags[i] {
          foundTag := true;
          break;
        }
      }

      //= specification/structured-encryption/footer.md#recipient-tag-verification
      //# Verification MUST fail unless at least one of the [Recipient Tags](#recipient-tags)
      //# matches a calculated recipient tag using the provided symmetricSigningKey.
      :- Need(foundTag, E("No recipient tag matched."));

      :- Need(sig.Some? == mat.algorithmSuite.signature.ECDSA?, E("Internal error. Signature both does and does not exist."));
      //= specification/structured-encryption/footer.md#signature-verification
      //# If the footer contains a signature, this signature MUST be verified using the
      //# [asymmetric signature algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
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

  // Given a StructuredDataTerminal, return the canonical value for the type, for use in the footer checksum calculations
  function method GetCanonicalType(value : StructuredDataTerminal, isEncrypted : bool)
    : Result<Bytes, Error>
  {
    if isEncrypted then
      :- Need(2 <= |value.value| < UINT64_LIMIT, E("Bad length."));
      Success(UInt64ToSeq((|value.value| - 2) as uint64) + UTF8.EncodeAscii("ENCRYPTED"))
    else
      :- Need(|value.value| < UINT64_LIMIT, E("Bad length."));
      Success(UInt64ToSeq((|value.value|) as uint64) + UTF8.EncodeAscii("PLAINTEXT") + value.typeId)
  }

  // Given a key value pair, return the canonical value for use in the footer checksum calculations
  function method GetCanonicalItem(fieldName : CanonicalPath, value : StructuredData, isEncrypted : bool)
    : (ret : Result<Bytes, Error>)
    requires value.content.Terminal?
    ensures ret.Success? ==>
      //= specification/structured-encryption/footer.md#canonical-field
      //= type=implication
      //# The canonical form of a field MUST be the concatenation of
      // - the canonical path of the field
      // - if the field is encrypted, the original data length as an 8-byte integer, followed by the literal "ENCRYPTED"
      // - otherwise, the data length as an 8-byte integer, followed by the literal "PLAINTEXT", followed by the 2-byte data type
      // - the value of the field
      && GetCanonicalType(value.content.Terminal, isEncrypted).Success?
      && ret.value ==
          fieldName
        + GetCanonicalType(value.content.Terminal, isEncrypted).value
        + GetValue(value)
  {
    var middle :- GetCanonicalType(value.content.Terminal, isEncrypted);
    Success(fieldName + middle + GetValue(value))
  }

  function method CanonContent (
    fields : seq<CanonicalPath>,      // remaining fields to be canonized
    encFields : seq<CanonicalPath>,   // fields that are encrypted
    encData : StructuredDataCanon,
    allData : StructuredDataCanon,
    canonized : Bytes := []   // output
  ) : Result<Bytes, Error>
    requires forall k <- fields :: k in allData
    requires forall k <- encFields :: k in allData
    requires forall k <- encData :: encData[k].content.Terminal?
    requires forall k <- allData :: allData[k].content.Terminal?
  {
    if |fields| == 0 then
      Success(canonized)
    else
      var data := if fields[0] in encData then encData[fields[0]] else allData[fields[0]];
      var newPart :- GetCanonicalItem(fields[0], data, fields[0] in encFields);
      CanonContent(fields[1..], encFields, encData, allData, canonized + newPart)
  }

  function method CanonRecord (
    signedFields : seq<CanonicalPath>,
    encFields : seq<CanonicalPath>,
    encData : StructuredDataCanon,
    allData : StructuredDataCanon,
    header : Bytes,
    enc : Header.CMPEncryptionContext
  ) : (ret : Result<Bytes, Error>)
    requires forall k <- signedFields :: k in allData
    requires forall k <- encFields :: k in allData
    requires forall k <- encData :: encData[k].content.Terminal?
    requires forall k <- allData :: allData[k].content.Terminal?

    //= specification/structured-encryption/footer.md#canonical-record
    //= type=implication
    //# The canonical form of a record MUST be the concatenation of
    //  - the full header with commitment
    //  - the 8-byte length of the AAD followed by the AAD value, or just a zero length if no AAD is used. The AAD value is the serialization of the Encryption Context from the Encryption MAterials.
    //  - for each [signed field](#signed-fields), ordered lexicographically by canonical path, the canonical field
    ensures ret.Success? ==>
      && CanonContent(signedFields, encFields, encData, allData).Success?
      && var AAD := Header.SerializeContext(enc);
      && ret.value == header + AAD + CanonContent(signedFields, encFields, encData, allData).value
  {
    var canon :- CanonContent(signedFields, encFields, encData, allData);
    var AAD := Header.SerializeContext(enc);
    Success(header + AAD + canon)
  }

  method CanonHash (
    signedFields : seq<CanonicalPath>,
    encFields : seq<CanonicalPath>,
    encData : StructuredDataCanon,
    allData : StructuredDataCanon,
    header : Bytes,
    enc : Header.CMPEncryptionContext
  ) returns (ret : Result<Bytes, Error>)
    requires forall k <- signedFields :: k in allData
    requires forall k <- encFields :: k in allData
    requires forall k <- encData :: encData[k].content.Terminal?
    requires forall k <- allData :: allData[k].content.Terminal?
    ensures ret.Success? ==>
      |ret.value| == 48
    //= specification/structured-encryption/footer.md#hash-calculation
    //= type=implication
    //# The canonical hash of a record MUST be the SHA384 of the canonical form of the record.
  {
    var data :- CanonRecord(signedFields, encFields, encData, allData, header, enc);
    var resultR := Digest.Digest(Prim.DigestInput(digestAlgorithm := Prim.SHA_384, message := data));
    return resultR.MapFailure(e => AwsCryptographyPrimitives(e));
  }

  // return the footer value for the StructuredData
  method CreateFooter(
    client: Primitives.AtomicPrimitivesClient,
    mat : CMP.EncryptionMaterials,
    signedFields : seq<CanonicalPath>,
    encFields : seq<CanonicalPath>,
    encData : StructuredDataCanon,
    allData : StructuredDataCanon,
    header : Bytes)
    returns (ret : Result<Footer, Error>)
    requires ValidSuite(mat.algorithmSuite)
    requires Materials.EncryptionMaterialsHasPlaintextDataKey(mat)
    requires Header.ValidEncryptionContext(mat.encryptionContext)
    requires forall k <- signedFields :: k in allData
    requires forall k <- encFields :: k in allData
    requires forall k <- encData :: encData[k].content.Terminal?
    requires forall k <- allData :: allData[k].content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var canonicalHash :- CanonHash(signedFields, encFields, encData, allData, header, mat.encryptionContext);
    var tags : seq<RecipientTag> := [];
    for i := 0 to |mat.encryptedDataKeys|
      invariant |tags| == i
    {
      //= specification/structured-encryption/footer.md#recipient-tags
      //# the Recipient Tag MUST be MUST be calculated over the [Canonical Hash](#canonical-hash)
      //# using the [symmetric signature algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
      //# indicated in the algorithm suite,
      //# and the
      //# [symmetric signing keys](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/structures.md#symmetric-signing-keys)
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
      //# [symmetric signing keys](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/structures.md#symmetric-signing-keys)
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

      //= specification/structured-encryption/footer.md#signature
      //# The `signature`, if it exists, MUST be calculated using the
      //# [asymmetric signature algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
      //# indicated by the algorithm suite.

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

  function method SerializeTags(tags : seq<RecipientTag>)
    : Bytes
  {
    if |tags| == 0 then
      []
    else
      tags[0] + SerializeTags(tags[1..])
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