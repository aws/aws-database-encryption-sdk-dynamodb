// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographyPrimitives/src/AesKdfCtr.dfy"

include "Header.dfy"
include "Util.dfy"
include "SortCanon.dfy"
include "Canonize.dfy"

module StructuredEncryptionCrypt {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import opened DafnyLibraries

  import CMP = AwsCryptographyMaterialProvidersTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import Primitives = AtomicPrimitives
  import UTF8
  import Header = StructuredEncryptionHeader
  import HKDF
  import AesKdfCtr
  import Seq
  import SortCanon
    // import Relations
  import opened Canonize

  function method FieldKey(HKDFOutput : Bytes, offset : uint32)
    : (ret : Result<Bytes, Error>)
    requires |HKDFOutput| == KeySize
    ensures ret.Success? ==>
              //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
              //= type=implication
              //# The `FieldKey` for a given key and offset MUST be the first 44 bytes
              //# of the aes256ctr_stream
              //# of the `FieldRootKey` and the `FieldKeyNonce` of three times the given offset.
              && offset as nat * 3 < UINT32_LIMIT
              && |ret.value| == KeySize+NonceSize
              && |ret.value| == 44
              && AesKdfCtr.Stream(FieldKeyNonce(offset * 3), HKDFOutput, (KeySize+NonceSize) as uint32).Success?
              && ret.value == AesKdfCtr.Stream(FieldKeyNonce(offset * 3), HKDFOutput, (KeySize+NonceSize) as uint32).value
  {
    :- Need(offset as nat * 3 < UINT32_LIMIT, E("Too many encrypted fields."));
    var keyR := AesKdfCtr.Stream(FieldKeyNonce(offset * 3), HKDFOutput, (KeySize+NonceSize) as uint32);
    keyR.MapFailure(e => AwsCryptographyPrimitives(e))
  }

  const AwsDbeField : UTF8.ValidUTF8Bytes :=
    var s := [0x41, 0x77, 0x73, 0x44, 0x62, 0x65, 0x46, 0x69, 0x65, 0x6c, 0x64];
    assert s == UTF8.EncodeAscii("AwsDbeField");
    s

  function method FieldKeyNonce(offset : uint32)
    : (ret : Bytes)
    ensures |ret| == 16 // NOT NonceSize
    //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
    //= type=implication
    //# The `FieldKeyNonce` for a given offset MUST be 16 bytes comprised of
    //# | Field         | Length   | Interpretation |
    //# | ------------- | -------- | -------------- |
    //# | "AwsDbeField" | 11       | Literal Ascii String |
    //# | 0x2c          | 1        | 44, the length of the eventual FieldKey |
    //# | offset        | 4        | 32 bit integer representation of offset |
    ensures ret ==
            AwsDbeField
            + [(KeySize+NonceSize) as uint8]
            + UInt32ToSeq(offset)
  {
    AwsDbeField
    + [(KeySize+NonceSize) as uint8] // length
    + UInt32ToSeq(offset)
  }

  const LABEL_COMMITMENT_KEY : UTF8.ValidUTF8Bytes :=
    var s := [0x41, 0x57, 0x53, 0x5f, 0x44, 0x42, 0x45, 0x5f, 0x43, 0x4f, 0x4d, 0x4d, 0x49, 0x54, 0x5f, 0x4b, 0x45, 0x59];
    assert s == UTF8.EncodeAscii("AWS_DBE_COMMIT_KEY");
    s

  const LABEL_ENCRYPTION_KEY : UTF8.ValidUTF8Bytes :=
    var s := [0x41, 0x57, 0x53, 0x5f, 0x44, 0x42, 0x45, 0x5f, 0x44, 0x45, 0x52, 0x49, 0x56, 0x45, 0x5f, 0x4b, 0x45, 0x59];
    assert s == UTF8.EncodeAscii("AWS_DBE_DERIVE_KEY");
    s

  // suitable for header field
  method GetCommitKey(
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    key : Key,
    msgID : MessageID
  )
    returns (ret : Result<Key, Error>)
    requires ValidSuite(alg)
    ensures ret.Success? ==>
              //= specification/structured-encryption/header.md#commit-key
              //= type=implication
              //# The calculated Commitment Key MUST have length equal to the
              //# [algorithm suite's encryption key length](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings).
              && |ret.value| == AlgorithmSuites.GetEncryptKeyLength(alg) as int

              //= specification/structured-encryption/header.md#commit-key
              //= type=implication
              //# The HKDF used to calculate the Commitment Key MUST be the
              //# [Commit Key KDF](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-commit-key-derivation-settings)
              //# indicated by the algorithm suite.
              && var history := client.History.Hkdf;
              && 0 < |history|
              && var hkdfInput := Seq.Last(history).input;
              && hkdfInput.digestAlgorithm == alg.commitment.HKDF.hmac

              //= specification/structured-encryption/header.md#commit-key
              //= type=implication
              //# The `info` used for the HKDF function MUST be
              //# | Field                | Length   |
              //# | -------------------- | -------- |
              //# | "AWS_DBE_COMMIT_KEY" | 18       |
              //# | Message ID           | 32       |
              && hkdfInput.info == LABEL_COMMITMENT_KEY + msgID

              //= specification/structured-encryption/header.md#commit-key
              //= type=implication
              //# The HKDF calculation MUST use a supplied key, no salt, and an `info` as described above.
              && hkdfInput.ikm == key
              && hkdfInput.salt == None

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var commitKey := client.Hkdf(
      Prim.HkdfInput(
        digestAlgorithm := alg.commitment.HKDF.hmac,
        salt := None,
        ikm := key,
        info := LABEL_COMMITMENT_KEY + msgID,
        expectedLength := alg.commitment.HKDF.outputKeyLength
      )
    );
    return commitKey.MapFailure(e => AwsCryptographyPrimitives(e));
  }

  lemma EncryptDataUpdated(origData : CryptoList, data : CanonCryptoList, finalData : CanonCryptoList)
    requires forall k <- origData :: CryptoExistsInCanonCrypto(k, data)
    requires |finalData| == |origData| == |data|
    requires (forall i | 0 <= i < |origData| :: Updated(data[i], finalData[i], DoEncrypt))
    ensures forall k <- origData :: CryptoUpdatedCanonCrypto(k, finalData)
  {
    reveal CryptoExistsInCanonCrypto();
    reveal CryptoUpdatedCanonCrypto();
    assert forall oldVal <- origData :: exists i :: 0 <= i < |finalData| && Updated5(oldVal, finalData[i], DoEncrypt);
    assert forall oldVal <- origData :: exists x :: x in finalData && Updated5(oldVal, x, DoEncrypt);
  }

  lemma EncryptFinalUpdated(origData : CryptoList, data : CanonCryptoList, finalData : CanonCryptoList)
    requires forall k <- data :: CanonCryptoExistsInCrypto(k, origData)
    requires |finalData| == |origData| == |data|
    requires forall i | 0 <= i < |origData| :: Updated(data[i], finalData[i], DoEncrypt)
    ensures forall k <- finalData :: CanonCryptoUpdatedCrypto(k, origData)
  {
    reveal CanonCryptoExistsInCrypto();
    reveal CanonCryptoUpdatedCrypto();
    assert forall val <- data :: exists x :: x in origData && x.key == val.origKey && x.data == val.data && x.action == val.action;
    assert forall newVal <- finalData :: exists x :: x in origData && Updated5(x, newVal, DoEncrypt);
  }

  lemma EncryptMaintains(tableName : GoodString, origData : CryptoList, data : CanonCryptoList, finalData : CanonCryptoList)
    requires CanonCryptoMatchesCryptoList(tableName, origData, data)
    requires |finalData| == |data|
    requires (forall i | 0 <= i < |data| :: Updated(data[i], finalData[i], DoEncrypt))
    ensures CanonCryptoUpdatedCryptoList(tableName, origData, finalData)
  {
    reveal CanonCryptoMatchesCryptoList();
    reveal CanonCryptoUpdatedCryptoList();

    assert forall k <- origData :: CryptoUpdatedCanonCrypto(k, finalData) by {
      EncryptDataUpdated(origData, data, finalData);
    }
    assert forall k <- finalData :: CanonCryptoUpdatedCrypto(k, origData) by {
      EncryptFinalUpdated(origData, data, finalData);
    }
  }

  // Encrypt a StructuredDataMap
  method Encrypt(
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    key : Key,
    head : Header.PartialHeader,
    data : CanonCryptoList,
    ghost tableName : GoodString,
    ghost origData : CryptoList)
    returns (ret : Result<CanonCryptoList, Error>)
    requires ValidSuite(alg)
    requires IsCryptoSorted(data)
    requires CanonCryptoMatchesCryptoList(tableName, origData, data)

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
    ensures ret.Success? ==>
              && |ret.value| == |data|
              && (forall i | 0 <= i < |data| :: Updated(data[i], ret.value[i], DoEncrypt))
              && CanonCryptoListHasNoDuplicates(ret.value)
              && IsCryptoSorted(ret.value)
              && CanonCryptoUpdatedCryptoList(tableName, origData, ret.value)
  {
    reveal CanonCryptoMatchesCryptoList();
    var result :- Crypt(DoEncrypt, client, alg, key, head, data);
    assert CanonCryptoUpdatedCryptoList(tableName, origData, result) by {
      EncryptMaintains(tableName, origData, data, result);
    }
    return Success(result);
  }

  lemma DecryptDataUpdated(origData : AuthList, data : CanonCryptoList, finalData : CanonCryptoList)
    requires forall k <- origData :: AuthExistsInCanonCrypto(k, data)
    requires |finalData| == |origData| == |data|
    requires (forall i | 0 <= i < |origData| :: Updated(data[i], finalData[i], DoDecrypt))
    ensures forall k <- origData :: AuthUpdatedCanonCrypto(k, finalData)
  {
    reveal AuthExistsInCanonCrypto();
    reveal AuthUpdatedCanonCrypto();
    assert forall oldVal <- origData :: exists i :: 0 <= i < |finalData| && Updated2(oldVal, finalData[i], DoDecrypt);
    assert forall oldVal <- origData :: exists x :: x in finalData && Updated2(oldVal, x, DoDecrypt);
  }

  lemma DecryptFinalUpdated(origData : AuthList, data : CanonCryptoList, finalData : CanonCryptoList)
    requires forall k <- data :: CanonCryptoExistsInAuth(k, origData)
    requires |finalData| == |origData| == |data|
    requires (forall i | 0 <= i < |origData| :: Updated(data[i], finalData[i], DoDecrypt))
    ensures forall k <- finalData :: CanonCryptoUpdatedAuth(k, origData)
  {
    reveal CanonCryptoExistsInAuth();
    reveal CanonCryptoUpdatedAuth();
    assert forall val <- data :: exists x :: x in origData && x.key == val.origKey && x.data == val.data;
    assert forall newVal <- finalData :: exists x :: x in origData && Updated2(x, newVal, DoDecrypt);
  }

  lemma DecryptMaintains(tableName : GoodString, origData : AuthList, data : CanonCryptoList, finalData : CanonCryptoList)
    requires CanonCryptoMatchesAuthList(tableName, origData, data)
    requires |finalData| == |data|
    requires (forall i | 0 <= i < |data| :: Updated(data[i], finalData[i], DoDecrypt))
    ensures CanonCryptoUpdatedAuthList(tableName, origData, finalData)
  {
    reveal CanonCryptoMatchesAuthList();
    reveal CanonCryptoUpdatedAuthList();

    assert forall k <- origData :: AuthUpdatedCanonCrypto(k, finalData) by {
      DecryptDataUpdated(origData, data, finalData);
    }
    assert forall k <- finalData :: CanonCryptoUpdatedAuth(k, origData) by {
      DecryptFinalUpdated(origData, data, finalData);
    }
  }

  // Decrypt a StructuredDataMap
  method Decrypt(
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    key : Key,
    head : Header.PartialHeader,
    data : CanonCryptoList,
    ghost tableName : GoodString,
    ghost origData : AuthList)
    returns (ret : Result<CanonCryptoList, Error>)
    requires ValidSuite(alg)
    requires IsCryptoSorted(data)
    requires CanonCryptoMatchesAuthList(tableName, origData, data)

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
    ensures ret.Success? ==>
              && |ret.value| == |data|
              && (forall i | 0 <= i < |data| :: Updated(data[i], ret.value[i], DoDecrypt))
              && IsCryptoSorted(ret.value)
              && CanonCryptoUpdatedAuthList(tableName, origData, ret.value)
  {
    reveal CanonCryptoMatchesAuthList();
    var result :- Crypt(DoDecrypt, client, alg, key, head, data);
    assert CanonCryptoUpdatedAuthList(tableName, origData, result) by {
      DecryptMaintains(tableName, origData, data, result);
    }
    return Success(result);
  }

  lemma MaintainSorted(data : CanonCryptoList, result : CanonCryptoList, mode : EncryptionSelector)
    requires IsCryptoSorted(data)
    requires |result| == |data|
    requires forall i | 0 <= i < |data| :: Updated(data[i], result[i], mode)
    ensures IsCryptoSorted(result)
  {
    reveal IsCryptoSorted();
    assert forall i | 0 <= i < |data| :: data[i].key == result[i].key;
    SortCanon.SortedIsSorted(data, result);
  }

  // Encrypt or Decrypt a StructuredDataMap
  method Crypt(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    key : Key,
    head : Header.PartialHeader,
    data : CanonCryptoList)
    returns (ret : Result<CanonCryptoList, Error>)
    requires ValidSuite(alg)
    requires CanonCryptoListHasNoDuplicates(data)
    requires IsCryptoSorted(data)

    ensures ret.Success? ==>
              //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
              //= type=implication
              //# The HKDF algorithm used to calculate the Field Root Key MUST be the
              //# [Encryption Key KDF](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-key-derivation-settings)
              //# indicated by the algorithm suite, using a provided plaintext data key, no salt,
              //# and an info as calculated [above](#calculate-info)

              //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
              //= type=implication
              //# The `FieldRootKey` MUST be generated with the plaintext data key in the encryption materials
              //# and the Message ID generated for this Encrypted Structured Data.

              //= specification/structured-encryption/encrypt-path-structure.md#calculate-info
              //= type=implication
              //# The `info` used for the HKDF function MUST be
              //# | Field                | Length   |
              //# | -------------------- | -------- |
              //# | "AWS_DBE_DERIVE_KEY" | 18       |
              //# | Message ID           | 32       |
              && var history := client.History.Hkdf;
              && 0 < |history|
              && var hkdfInput := Seq.Last(history).input;
              && hkdfInput.digestAlgorithm == alg.kdf.HKDF.hmac
              && hkdfInput.info == LABEL_ENCRYPTION_KEY + head.msgID
              && hkdfInput.salt == None
              && hkdfInput.ikm == key

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
    ensures ret.Success? ==>
              && |ret.value| == |data|
              && (forall i | 0 <= i < |data| :: Updated(data[i], ret.value[i], mode))
              && CanonCryptoListHasNoDuplicates(ret.value)
              && IsCryptoSorted(ret.value)
  {
    //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
    //# The `FieldRootKey` MUST be generated with the plaintext data key in the encryption materials
    //# and the Message ID generated for this Encrypted Structured Data.
    var fieldRootKeyR := client.Hkdf(
      Prim.HkdfInput(
        digestAlgorithm := alg.kdf.HKDF.hmac,
        salt := None,
        ikm := key,
        info := LABEL_ENCRYPTION_KEY + head.msgID,
        expectedLength := alg.kdf.HKDF.outputKeyLength
      )
    );

    var fieldRootKey :- fieldRootKeyR.MapFailure(e => AwsCryptographyPrimitives(e));
    //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
    //= type=implication
    //# The calculated Field Root MUST have length equal to the
    //# [algorithm suite's encryption key length](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings).
    assert |fieldRootKey| == AlgorithmSuites.GetEncryptKeyLength(alg) as int;
    var result :- CryptList(mode, client, alg, fieldRootKey, data);

    assert IsCryptoSorted(result) by {
      MaintainSorted(data, result, mode);
    }

    return Success(result);
  }

  // Encrypt or Decrypt each entry in keys, putting results in output
  method CryptList(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    fieldRootKey : Key,
    data : CanonCryptoList
  )
    returns (ret : Result<CanonCryptoList, Error>)

    modifies client.Modifies - {client.History} , client.History`AESEncrypt, client.History`AESDecrypt
    requires client.ValidState()
    ensures client.ValidState()
    ensures ret.Success? ==>
              && |ret.value| == |data|
              && (forall i | 0 <= i < |data| :: Updated(data[i], ret.value[i], mode))
  {
    var result : CanonCryptoList := [];
    var pos : uint32 := 0;
    :- Need(|data| < UINT32_LIMIT, E("Too many fields."));
    for i := 0 to |data|
      invariant pos <= (i as uint32)
      invariant |result| == i
      invariant forall x | 0 <= x < |result| :: Updated(data[x], result[x], mode)
    {
      if data[i].action == ENCRYPT_AND_SIGN {
        var newTerminal;
        if mode == DoEncrypt {
          newTerminal :- EncryptTerminal(client, alg, fieldRootKey, pos, data[i].key, data[i].data);
          assert newTerminal.typeId == BYTES_TYPE_ID;
        } else {
          newTerminal :- DecryptTerminal(client, alg, fieldRootKey, pos, data[i].key, data[i].data);
        }
        pos := pos + 1;
        var newItem := data[i].(data := newTerminal);
        result := result + [newItem];
        assert Updated(data[i], result[i], mode);
      } else {
        result := result + [data[i]];
        assert Updated(data[i], result[i], mode);
      }
      assert Updated(data[i], result[i], mode);
    }
    return Success(result);
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
    returns (ret : Result<StructuredDataTerminal, Error>)

    ensures ret.Success? ==>
              ret.value != data
    ensures ret.Success? ==>
              //= specification/structured-encryption/encrypt-path-structure.md#terminal-data-encryption
              //= type=implication
              //# The output encrypted Terminal Data MUST have a [Terminal Type Id](./structures.md#terminal-type-id)
              //# equal `0xFFFF`.
              && ret.value.typeId == BYTES_TYPE_ID

              //= specification/structured-encryption/encrypt-path-structure.md#terminal-data-encryption
              //= type=implication
              //# The output encrypted Terminal Data MUST have a [Terminal Value](./structures.md#terminal-value)
              //# with the following serialization:
                 // | Field                      | Length   |
                 // | -------------------------- | -------- |
                 // | Terminal Type Id           | 2        |
                 // | Encrypted Terminal Value   | Variable |

                 //= specification/structured-encryption/encrypt-path-structure.md#terminal-type-id
                 //= type=implication
                 //# Terminal Type Id MUST equal the input Terminal Data's Terminal Type Id.
              && |ret.value.value| >= 2
              && ret.value.value[..2] == data.typeId
              && var history := client.History.AESEncrypt;
              && 0 < |history|
              && var encryptInput := Seq.Last(history).input;
              && encryptInput.encAlg == alg.encrypt.AES_GCM
              && FieldKey(fieldRootKey, offset).Success?
              && var fieldKey := FieldKey(fieldRootKey, offset).value;
              //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
              //= type=implication
              //# The `Cipherkey` MUST be the first 32 bytes of the `FieldKey`
              && KeySize == 32
              && encryptInput.key == fieldKey[0..KeySize]
                 //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
                 //= type=implication
                 //# The `Nonce` MUST be the remaining 12 bytes of the `FieldKey`
              && NonceSize == 12
              && |fieldKey| - KeySize == 12
              && encryptInput.iv == fieldKey[KeySize..]

    modifies client.Modifies - {client.History} , client.History`AESEncrypt, client.History`AESDecrypt
    requires client.ValidState()
    ensures client.ValidState()
  {
    var fieldKey :- FieldKey(fieldRootKey, offset);
    //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
    //# The `Cipherkey` MUST be the first 32 bytes of the `FieldKey`
    var cipherkey : Key := fieldKey[0..KeySize];
    //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
    //# The `Nonce` MUST be the remaining 12 bytes of the `FieldKey`
    var nonce : Nonce := fieldKey[KeySize..];
    var value := data.value;

    //= specification/structured-encryption/encrypt-path-structure.md#encrypted-terminal-value
    //# The Encrypted Terminal Value MUST be derived according to the following encryption:
    // - The encryption algorithm used is the
    //   [encryption algorithm](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
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
    returns (ret : Result<StructuredDataTerminal, Error>)
    ensures ret.Success? ==>
              && |data.value| >= (AuthTagSize+2)
                 //= specification/structured-encryption/decrypt-path-structure.md#terminal-data-decryption
                 //= type=implication
                 //# The output Terminal Data MUST have a [Terminal Type Id](./structures.md#terminal-type-id)
                 //# equal to the deserialized Terminal Type Id.
              && ret.value.typeId == data.value[0..TYPEID_LEN]
              && ret.value != data

    modifies client.Modifies - {client.History} , client.History`AESEncrypt, client.History`AESDecrypt
    requires client.ValidState()
    ensures client.ValidState()
  {
    var dataKey :- FieldKey(fieldRootKey, offset);
    var encryptionKey : Key := dataKey[0..KeySize];
    var nonce : Nonce := dataKey[KeySize..];
    var value := data.value;

    :- Need((AuthTagSize+2) <= |value|, E("cipherTxt too short."));

    //= specification/structured-encryption/decrypt-path-structure.md#terminal-data-decryption
    //# The input [Terminal Value](./structures.md#terminal-value) MUST be deserialized as follows:
    // | Field                      | Length   |
    // | -------------------------- | -------- |
    // | Terminal Type Id           | 2        |
    // | Encrypted Terminal Value   | Variable |

    //= specification/structured-encryption/decrypt-path-structure.md#terminal-data-decryption
    //# The output Terminal Data MUST have a [Terminal Value](./structures.md#terminal-type-id)
    //# equal to the following decryption:
    // - The decryption algorithm used is the
    //   [encryption algorithm](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
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
