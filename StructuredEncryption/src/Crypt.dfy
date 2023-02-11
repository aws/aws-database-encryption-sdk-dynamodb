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

  function method FieldKey(HKDFOutput : Bytes, offset : uint32)
    : (ret : Bytes)
    requires |HKDFOutput| == KeySize
    ensures |ret| == KeySize+NonceSize
  {
    (HKDFOutput+HKDFOutput)[..44] // good enough for testing
    //aes256ctr(KeySize+NonceSize, HKDFOutput, FieldKeyNonce(offset * 3))
  }

  function method FieldKeyNonce(offset : uint32)
    : (ret : seq<uint8>)
    ensures |ret| == 16 // NOT NonceSize
    {
      UTF8.EncodeAscii("AwsDbeField")
      + [(KeySize+NonceSize) as uint8] // length
      + UInt32ToSeq(offset)
    }
    
  // the underscore is not present in the AWS Encryption SDK's constants
  const LABEL_COMMITMENT_KEY := UTF8.EncodeAscii("AWS_DBE_COMMIT_KEY")
  const LABEL_ENCRYPTION_KEY := UTF8.EncodeAscii("AWS_DBE_DERIVE_KEY")
  
  // suitable for header field
  method GetCommitKey(alg : CMP.AlgorithmSuiteInfo, key : Key, msgID : MessageID)
    returns (ret : Key)
    requires ValidSuite(alg)
  {
    ret := HKDF.Hkdf(
      alg.commitment.HKDF.hmac,
      None, // salt
      key, // ikm
      LABEL_COMMITMENT_KEY + msgID, // info
      alg.commitment.HKDF.outputKeyLength as int // length
    );
  }

  datatype EncryptionSelector = Encrypt | Decrypt

  // Encrypt or Decrypt a StructuredDataMap
  method Crypt(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    key : Key,
    head : Header.PartialHeader,
    keys : seq<Bytes>,
    data : map<Bytes, StructuredData>)
    returns (ret : Result<map<Bytes, StructuredData>, Error>)
    requires forall k <- keys :: k in data
    requires |keys| < (UINT32_LIMIT / 3)
    requires forall k <- data :: data[k].content.Terminal?
    requires ValidSuite(alg)
    ensures ret.Success? ==> forall k <- ret.value :: ret.value[k].content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var FieldRootKey := HKDF.Hkdf(
      alg.kdf.HKDF.hmac,
      None, // salt
      key, // ikm
      LABEL_ENCRYPTION_KEY + head.msgID, // info
      alg.kdf.HKDF.outputKeyLength as int // length
    );
    var result := CryptList(mode, client, alg, FieldRootKey, 0, keys, data, map[]);
    return result;
  }

  // Encrypt or Decrypt each entry in keys, putting results in output
  method {:tailrecursion} CryptList(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    FieldRootKey : Key,
    offset : uint32,
    keys : seq<Bytes>,
    input : map<Bytes, StructuredData>,
    output : map<Bytes, StructuredData>
  )
    returns (ret : Result<map<Bytes, StructuredData>, Error>)
    requires forall k <- keys :: k in input
    requires |keys| * 3 + (offset as nat) < UINT32_LIMIT
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
    var data :- CryptOne(mode, client, alg, FieldRootKey, offset, keys[0], input[keys[0]]);
    var result := CryptList(mode, client, alg, FieldRootKey, offset+1, keys[1..], input, output[keys[0] := data]);
    return result;
  }

  // Encrypt or Decrypt a single Terminal
  method CryptOne(
    mode : EncryptionSelector,
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    FieldRootKey : Key,
    offset : uint32,
    path : seq<uint8>,
    data : StructuredData
  )
    returns (ret : Result<StructuredData, Error>)
    requires data.content.Terminal?
    ensures ret.Success? ==> ret.value.content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var dataKey := FieldKey(FieldRootKey, offset);
    var encryptionKey : Key := dataKey[0..KeySize];
    var nonce : Nonce := dataKey[KeySize..];
    var value := data.content.Terminal.value;

    if mode == Encrypt {
      var encInput := Prim.AESEncryptInput(
        encAlg := alg.encrypt.AES_GCM,
        iv := nonce,
        key := encryptionKey,
        msg := data.content.Terminal.typeId + value,
        aad := path
      );

      var encOutR := client.AESEncrypt(encInput);
      var encOut :- encOutR.MapFailure(e => AwsCryptographyPrimitives(e));
      :- Need (|encOut.authTag| == AuthTagSize, E("Auth Tag Wrong Size."));
      return Success(ValueToData(encOut.cipherText + encOut.authTag, BYTES_TYPE_ID));

    } else {
      :- Need(AuthTagSize <= |value|, E("cipherTxt too short."));
      var decInput := Prim.AESDecryptInput(
        encAlg := alg.encrypt.AES_GCM,
        iv := nonce,
        key := encryptionKey,
        cipherTxt := value[..|value| - AuthTagSize],
        aad := path,
        authTag := value[|value|-AuthTagSize..]
      );

      var decOutR := client.AESDecrypt(decInput);
      var decOut :- decOutR.MapFailure(e => AwsCryptographyPrimitives(e));
      :- Need(2 <= |decOut|, E("Too little data."));
      return Success(ValueToData(decOut[2..], decOut[..2]));
    }
  }
}
