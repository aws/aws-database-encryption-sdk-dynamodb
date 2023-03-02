// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographyPrimitives/src/AesKdfCtr.dfy"

include "Header.dfy"
include "Util.dfy"

module StructuredEncryptionCrypt {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened StructuredEncryptionUtil

  import CMP = AwsCryptographyMaterialProvidersTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import Aws.Cryptography.Primitives
  import UTF8
  import Header = StructuredEncryptionHeader
  import HKDF
  import AesKdfCtr


  function method FieldKey(HKDFOutput : Bytes, offset : uint32)
    : (ret : Result<Bytes, Error>)
    requires |HKDFOutput| == KeySize
    requires offset as nat * 3 < UINT32_LIMIT
    ensures ret.Success? ==> |ret.value| == KeySize+NonceSize
    //= specification/structured-encryption/encrypt-structure.md#calculate-cipherkey-and-nonce
    //= type=implication
    //# The `FieldKey` for a given key and offset MUST be the first 44 bytes
    //# of the aes256ctr_stream
    //# of the given key and the `FieldKeyNonce` of three times the given offset
  {
    var keyR := AesKdfCtr.Stream(FieldKeyNonce(offset * 3), HKDFOutput, (KeySize+NonceSize) as uint32);
    keyR.MapFailure(e => AwsCryptographyPrimitives(e))
  }

  function method FieldKeyNonce(offset : uint32)
    : (ret : Bytes)
    ensures |ret| == 16 // NOT NonceSize
    //= specification/structured-encryption/encrypt-structure.md#calculate-cipherkey-and-nonce
    //= type=implication
    //# The `FieldKeyNonce` for a given offset MUST be 16 bytes comprised of
    //  - the ASCII encoding of "AwsDbeField"
    //  - the byte 0x2c (aka 44, the length of the eventual FieldKey)
    //  - the offset as a 4-byte integer
    ensures ret ==
      UTF8.EncodeAscii("AwsDbeField")
      + [(KeySize+NonceSize) as uint8]
      + UInt32ToSeq(offset)
    {
      UTF8.EncodeAscii("AwsDbeField")
      + [(KeySize+NonceSize) as uint8] // length
      + UInt32ToSeq(offset)
    }
    
  const LABEL_COMMITMENT_KEY := UTF8.EncodeAscii("AWS_DBE_COMMIT_KEY")
  const LABEL_ENCRYPTION_KEY := UTF8.EncodeAscii("AWS_DBE_DERIVE_KEY")
  
  // suitable for header field
  method GetCommitKey(alg : CMP.AlgorithmSuiteInfo, key : Key, msgID : MessageID)
    returns (ret : Key)
    requires ValidSuite(alg)
    //= specification/structured-encryption/header.md#commit-key
    //= type=implication
    //# The calculated Commitment Key MUST have length equal to the
    //# [algorithm suite's encryption key length](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings).
    ensures |ret| == AlgorithmSuites.GetEncryptKeyLength(alg) as int
  {
    //= specification/structured-encryption/header.md#commit-key
    //# The KDF used to calculate the Commitment Key MUST be the
    //# [Commit Key KDF](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-commit-key-derivation-settings)
    //# indicated by the algorithm suite.
    ret := HKDF.Hkdf(
      alg.commitment.HKDF.hmac,
      None, // salt
      key, // ikm
      LABEL_COMMITMENT_KEY + msgID, // info
      alg.commitment.HKDF.outputKeyLength as int // length
    );
  }

  datatype EncryptionSelector = DoEncrypt | DoDecrypt

  // Encrypt a StructuredDataMap
  method Encrypt(
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    key : Key,
    head : Header.PartialHeader,
    fieldNames : seq<CanonicalPath>,
    data : StructuredDataCanon)
    returns (ret : Result<StructuredDataCanon, Error>)
    requires forall k <- fieldNames :: k in data
    requires |fieldNames| < (UINT32_LIMIT / 3)
    requires ValidSuite(alg)

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    ret := Crypt(DoEncrypt, client, alg, key, head, fieldNames, data);
  }

  // Decrypt a StructuredDataMap
  method Decrypt(
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    key : Key,
    head : Header.PartialHeader,
    fieldNames : seq<CanonicalPath>,
    data : StructuredDataCanon)
    returns (ret : Result<StructuredDataCanon, Error>)
    requires forall k <- fieldNames :: k in data
    requires |fieldNames| < (UINT32_LIMIT / 3)
    requires ValidSuite(alg)

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    ret := Crypt(DoDecrypt, client, alg, key, head, fieldNames, data);
  }

  // Encrypt or Decrypt a StructuredDataMap
  // TODO - some guarantee that this encryption is being done in the right order
  method Crypt(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    key : Key,
    head : Header.PartialHeader,
    fieldNames : seq<CanonicalPath>,
    data : StructuredDataCanon)
    returns (ret : Result<StructuredDataCanon, Error>)
    requires forall k <- fieldNames :: k in data
    requires |fieldNames| < (UINT32_LIMIT / 3)
    requires ValidSuite(alg)

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    //= specification/structured-encryption/encrypt-structure.md#calculate-cipherkey-and-nonce
    //# The KDF used to calculate the Field Root Key MUST be the
    //# [Encryption Key KDF](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-key-derivation-settings)
    //# indicated by the algorithm suite, using a provided plaintext data key,
    //# no salt, and an info of "AWS_DBE_DERIVE_KEY" concatenated with a provided message id.

    //= specification/structured-encryption/encrypt-structure.md#calculate-cipherkey-and-nonce
    //# The `FieldRootKey` MUST be generated with the plaintext data key in the encryption materials
    //# and the Message ID generated for this Encrypted Structured Data
    var fieldRootKey := HKDF.Hkdf(
      alg.kdf.HKDF.hmac,
      None, // salt
      key, // ikm
      LABEL_ENCRYPTION_KEY + head.msgID, // info
      alg.kdf.HKDF.outputKeyLength as int // length
    );
    //= specification/structured-encryption/encrypt-structure.md#calculate-cipherkey-and-nonce
    //= type=implication
    //# The calculated Field Root MUST have length equal to the
    //# [algorithm suite's encryption key length](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings).
    assert |fieldRootKey| == AlgorithmSuites.GetEncryptKeyLength(alg) as int;
    var result := CryptList(mode, client, alg, fieldRootKey, 0, fieldNames, data, map[]);
    return result;
  }

  // Encrypt or Decrypt each entry in keys, putting results in output
  method {:tailrecursion} CryptList(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    fieldRootKey : Key,
    offset : uint32,
    fieldNames : seq<CanonicalPath>,
    input : StructuredDataCanon,
    output : StructuredDataCanon
  )
    returns (ret : Result<StructuredDataCanon, Error>)
    requires forall k <- fieldNames :: k in input
    requires (|fieldNames| + offset as nat) * 3 < UINT32_LIMIT
    decreases |fieldNames|

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    if |fieldNames| == 0 {
      return Success(output);
    }
    var data;
    if mode == DoEncrypt {
      data :- EncryptTerminal(client, alg, fieldRootKey, offset, fieldNames[0], input[fieldNames[0]].content.Terminal);
    } else {
      data :- DecryptTerminal(client, alg, fieldRootKey, offset, fieldNames[0], input[fieldNames[0]].content.Terminal);
    }
    var result := CryptList(mode, client, alg, fieldRootKey, offset+1, fieldNames[1..], input, output[fieldNames[0] := data]);
    return result;
  }

  // Encrypt a single Terminal
  method EncryptTerminal(
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    fieldRootKey : Key,
    offset : uint32,
    path : CanonicalPath,
    data : StructuredDataTerminal
  )
    returns (ret : Result<StructuredData, Error>)
    requires offset as nat * 3 < UINT32_LIMIT

    ensures ret.Success? ==>
      //= specification/structured-encryption/encrypt-structure.md#terminal-data-encryption
      //= type=implication
      //# The output encrypted Terminal Data MUST have a [Terminal Type Id](./structures.md#terminal-type-id)
      //# equal `0xFFFF`.
      && ret.value.content.Terminal?
      && ret.value.content.Terminal.typeId == BYTES_TYPE_ID

      //= specification/structured-encryption/encrypt-structure.md#terminal-data-encryption
      //= type=implication
      //# The output encrypted Terminal Data MUST have a [Terminal Value](./structures.md#terminal-value)
      //# with the following serialization:
      // | Field                      | Length   |
      // | -------------------------- | -------- |
      // | Terminal Type Id           | 2        |
      // | Encrypted Terminal Value   | Variable |

      //= specification/structured-encryption/encrypt-structure.md#terminal-type-id
      //= type=implication
      //# Terminal Type Id MUST equal the input Terminal Data's Terminal Type Id.
      && |ret.value.content.Terminal.value| >= 2
      && ret.value.content.Terminal.value[..2] == data.typeId

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var fieldKey :- FieldKey(fieldRootKey, offset);
    //= specification/structured-encryption/encrypt-structure.md#calculate-cipherkey-and-nonce
    //# The `Cipherkey` MUST be the first 32 bytes of the `FieldKey`
    var cipherkey : Key := fieldKey[0..KeySize];
    //= specification/structured-encryption/encrypt-structure.md#calculate-cipherkey-and-nonce
    //# The `Nonce` MUST be the remaining 12 bytes of the `FieldKey`
    var nonce : Nonce := fieldKey[KeySize..];
    var value := data.value;

    //= specification/structured-encryption/encrypt-structure.md#encrypted-terminal-value
    //# The Encrypted Terminal Value MUST be derived according to the following encryption:
    // - The encryption algorithm used is the
    //   [encryption algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
    //   indicated in the algorithm suite.
    // - The AAD is the [canonical path](./header.md#canonical-path) for this Terminal Data
    // - The [Cipherkey and Nonce](#calculate-cipherkey-and-nonce) are as calculated above.
    // - The plaintext is the [Terminal Value](./structures.md#terminal-value) for this Terminal Data.

    var encInput := Prim.AESEncryptInput(
      encAlg := alg.encrypt.AES_GCM,
      iv := nonce,
      key := cipherkey,
      msg := value,
      aad := path
    );

    var encOutR := client.AESEncrypt(encInput);
    var encOut :- encOutR.MapFailure(e => AwsCryptographyPrimitives(e));
    :- Need (|encOut.authTag| == AuthTagSize, E("Auth Tag Wrong Size."));
    return Success(ValueToData(data.typeId + encOut.cipherText + encOut.authTag, BYTES_TYPE_ID));
  }

  // Decrypt a single Terminal
  method DecryptTerminal(
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    fieldRootKey : Key,
    offset : uint32,
    path : CanonicalPath,
    data : StructuredDataTerminal
  )
    returns (ret : Result<StructuredData, Error>)
    requires offset as nat * 3 < UINT32_LIMIT
    ensures ret.Success? ==>
      && ret.value.content.Terminal?
      && |data.value| >= (AuthTagSize+2)
      //= specification/structured-encryption/decrypt-structure.md#terminal-data-decryption
      //= type=implication
      //# The output Terminal Data MUST have a [Terminal Type Id](./structures.md#terminal-type-id)
      //# equal to the deserialized Terminal Type Id.
      && ret.value.content.Terminal.typeId == data.value[0..TYPEID_LEN]

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var dataKey :- FieldKey(fieldRootKey, offset);
    var encryptionKey : Key := dataKey[0..KeySize];
    var nonce : Nonce := dataKey[KeySize..];
    var value := data.value;

    :- Need((AuthTagSize+2) <= |value|, E("cipherTxt too short."));

    //= specification/structured-encryption/decrypt-structure.md#terminal-data-decryption
    //# The input [Terminal Value](./structures.md#terminal-value) MUST be deserialized as follows:
    // | Field                      | Length   |
    // | -------------------------- | -------- |
    // | Terminal Type Id           | 2        |
    // | Encrypted Terminal Value   | Variable |

    //= specification/structured-encryption/decrypt-structure.md#terminal-data-decryption
    //# The output Terminal Data MUST have a [Terminal Value](./structures.md#terminal-type-id)
    //# equal to the following decryption:
    // - The decryption algorithm used is the
    //   [encryption algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
    //   indicated in the algorithm suite.
    // - The AAD is the [canonical path](./header.md#canonical-path) for this Terminal Data
    // - The Cipherkey and Nonce are as calculate [above](#calculate-cipherkey-and-nonce).
    // - The ciphertext is the deserialized Encrypted Terminal Value.
    var decInput := Prim.AESDecryptInput(
      encAlg := alg.encrypt.AES_GCM,
      iv := nonce,
      key := encryptionKey,
      cipherTxt := value[TYPEID_LEN..|value| - AuthTagSize],
      aad := path,
      authTag := value[|value|-AuthTagSize..]
    );

    var decOutR := client.AESDecrypt(decInput);
    var decOut :- decOutR.MapFailure(e => AwsCryptographyPrimitives(e));
    return Success(ValueToData(decOut, value[..TYPEID_LEN]));
  }
}
