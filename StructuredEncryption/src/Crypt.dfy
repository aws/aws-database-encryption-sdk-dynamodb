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
  {
    Success((HKDFOutput+HKDFOutput)[..44]) // good enough for testing
    //var keyR := AesKdfCtr.Stream(FieldKeyNonce(offset * 3), HKDFOutput, (KeySize+NonceSize) as uint32);
    //keyR.MapFailure(e => AwsCryptographyPrimitives(e))
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
    data : StructuredDataCanon)
    returns (ret : Result<StructuredDataCanon, Error>)
    requires forall k <- keys :: k in data
    requires |keys| < (UINT32_LIMIT / 3)
    requires ValidSuite(alg)

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
    input : StructuredDataCanon,
    output : StructuredDataCanon
  )
    returns (ret : Result<StructuredDataCanon, Error>)
    requires forall k <- keys :: k in input
    requires (|keys| + offset as nat) * 3 < UINT32_LIMIT
    decreases |keys|

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    if |keys| == 0 {
      return Success(output);
    }
    var data :- CryptOne(mode, client, alg, FieldRootKey, offset, keys[0], input[keys[0]].content.Terminal);
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
    data : StructuredDataTerminal
  )
    returns (ret : Result<StructuredData, Error>)
    requires offset as nat * 3 < UINT32_LIMIT
    ensures ret.Success? ==> ret.value.content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var dataKey :- FieldKey(FieldRootKey, offset);
    var encryptionKey : Key := dataKey[0..KeySize];
    var nonce : Nonce := dataKey[KeySize..];
    var value := data.value;

    if mode == Encrypt {
      var encInput := Prim.AESEncryptInput(
        encAlg := alg.encrypt.AES_GCM,
        iv := nonce,
        key := encryptionKey,
        msg := data.typeId + value,
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
