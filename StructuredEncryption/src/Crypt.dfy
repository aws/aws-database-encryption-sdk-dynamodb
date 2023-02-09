// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
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

  const KeySize := 32 // 256 bits, for 256-bit AES keys
  const NonceSize := 12 // 96 bits, per AES-GCM nonces
  const AuthTagSize := 16

  // TODO - an extern that actually does AES CTR
  function method aes256ctr(length : nat, key : Bytes, nonce : Bytes)
    : (ret : Bytes)
    ensures |ret| == length
  {
    seq(length, i => (i % 256) as uint8)
  }

  function method FieldKey(HKDFOutput : Bytes, offset : uint32)
    : (ret : Bytes)
    requires |HKDFOutput| == KeySize
    ensures |ret| == KeySize+NonceSize
  {
    (HKDFOutput+HKDFOutput)[..44] // good enough for testing
    //aes256ctr(KeySize+NonceSize, HKDFOutput, FieldKeyNonce(offset * 3))
  }

  function method FieldKeyNonce(offset : uint32)
    : (ret : Bytes)
    ensures |ret| == 16
    {
        UTF8.EncodeAscii("Truss")
      + [0]
      + UTF8.EncodeAscii("Field")
      + [(KeySize+NonceSize) as uint8] // length
      + UInt32ToSeq(offset)
    }
    
  // the underscore is not present in the AWS Encryption SDK's constants
  const LABEL_COMMITMENT_KEY := UTF8.EncodeAscii("TRUSS_COMMIT_KEY")
  const LABEL_ENCRYPTION_KEY := UTF8.EncodeAscii("TRUSS_DERIVE_KEY")
  
  // suitable for header field
  method GetCommitKey(key : CMP.Secret, msgID : Bytes) returns (ret : Bytes)
    requires |msgID| == 32
    requires |key| == KeySize
  {
    ret := HKDF.Hkdf(
      Prim.SHA_512, 
      None, // salt
      key, // ikm
      LABEL_COMMITMENT_KEY + msgID, // info
      KeySize // length
    );
  }

  datatype EncryptionSelector = Encrypt | Decrypt

  // Encrypt or Decrypt a StructuredDataMap
  method Crypt(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    key : Bytes,
    head : Header.PartialHeader,
    keys : seq<Bytes>,
    data : map<Bytes, StructuredData>)
    returns (ret : Result<map<Bytes, StructuredData>, Error>)
    requires forall k <- keys :: k in data
    requires |keys| < (UINT32_LIMIT / 3)
    requires forall k <- data :: data[k].content.Terminal?
    ensures ret.Success? ==> forall k <- ret.value :: ret.value[k].content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    :- Need(|key| < INT32_MAX_LIMIT, E("key too long"));

    var FieldRootKey := HKDF.Hkdf(
      Prim.SHA_512, 
      None, // salt
      key, // ikm
      LABEL_ENCRYPTION_KEY + head.msgID, // info
      KeySize // length
    );
    var result := CryptList(mode, client, FieldRootKey, 0, keys, data, map[]);
    return result;
  }

  // Encrypt or Decrypt each entry in keys, putting results in output
  method {:tailrecursion} CryptList(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    FieldRootKey : Bytes,
    offset : uint32,
    keys : seq<Bytes>,
    input : map<Bytes, StructuredData>,
    output : map<Bytes, StructuredData>
  )
    returns (ret : Result<map<Bytes, StructuredData>, Error>)
    requires forall k <- keys :: k in input
    requires |keys| * 3 + (offset as nat) < UINT32_LIMIT
    requires |FieldRootKey| == KeySize
    requires forall k <- input :: input[k].content.Terminal?
    requires forall k <- output :: output[k].content.Terminal?
    ensures ret.Success? ==> forall k <- ret.value :: ret.value[k].content.Terminal?
    decreases |keys|

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    if |keys| == 0 {
      return Success(output);
    }
    var data :- CryptOne(mode, client, FieldRootKey, offset, input[keys[0]]);
    var result := CryptList(mode, client, FieldRootKey, offset+1, keys[1..], input, output[keys[0] := data]);
    return result;
  }

  // Encrypt or Decrypt a single Terminal
  method CryptOne(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    FieldRootKey : Bytes,
    offset : uint32,
    data : StructuredData
  )
    returns (ret : Result<StructuredData, Error>)
    requires |FieldRootKey| == KeySize
    requires data.content.Terminal?
    ensures ret.Success? ==> ret.value.content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var dataKey := FieldKey(FieldRootKey, offset);
    var encryptionKey := dataKey[0..KeySize];
    var nonce := dataKey[KeySize..];

    // TODO - algorithm suite
    var encAlg := Prim.AES_GCM(keyLength := KeySize as Prim.SymmetricKeyLength, tagLength := AuthTagSize as Prim.Uint8Bits, ivLength := NonceSize as Prim.Uint8Bits);
    var value := data.content.Terminal.value;
    if mode == Encrypt {
      var encInput := Prim.AESEncryptInput(
        encAlg := encAlg,
        iv := nonce,
        key := encryptionKey,
        msg := data.content.Terminal.typeId + value,
        aad := [] // encryption context
      );

      var encOutR := client.AESEncrypt(encInput);
      var encOut :- encOutR.MapFailure(e => AwsCryptographyPrimitives(e));
      return Success(ValueToData(encOut.cipherText + encOut.authTag, [0xff, 0xff]));
    } else {
      :- Need(AuthTagSize <= |value|, E("cipherTxt too short."));
      var decInput := Prim.AESDecryptInput(
        encAlg := encAlg,
        iv := nonce,
        key := encryptionKey,
        cipherTxt := value[..|value| - AuthTagSize],
        aad := [], // enc context
        authTag := value[|value|-AuthTagSize..]
      );

      var decOutR := client.AESDecrypt(decInput);
      var decOut :- decOutR.MapFailure(e => AwsCryptographyPrimitives(e));
      :- Need(2 <= |decOut|, E("Too little data."));
      return Success(ValueToData(decOut[2..], decOut[..2]));
    }
  }


}
