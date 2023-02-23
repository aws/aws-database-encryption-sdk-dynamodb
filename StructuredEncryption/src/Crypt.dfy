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
    Success((HKDFOutput+HKDFOutput)[..44]) // TODO - replace with below after next merge with private-dafny
    //var keyR := AesKdfCtr.Stream(FieldKeyNonce(offset * 3), HKDFOutput, (KeySize+NonceSize) as uint32);
    //keyR.MapFailure(e => AwsCryptographyPrimitives(e))
  }

  function method FieldKeyNonce(offset : uint32)
    : (ret : Bytes)
    ensures |ret| == 16 // NOT NonceSize
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
  {
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
    var fieldRootKey := HKDF.Hkdf(
      alg.kdf.HKDF.hmac,
      None, // salt
      key, // ikm
      LABEL_ENCRYPTION_KEY + head.msgID, // info
      alg.kdf.HKDF.outputKeyLength as int // length
    );
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
      data :- EncryptTermina(client, alg, fieldRootKey, offset, fieldNames[0], input[fieldNames[0]].content.Terminal);
    } else {
      data :- DecryptTerminal(client, alg, fieldRootKey, offset, fieldNames[0], input[fieldNames[0]].content.Terminal);
    }
    var result := CryptList(mode, client, alg, fieldRootKey, offset+1, fieldNames[1..], input, output[fieldNames[0] := data]);
    return result;
  }

  // Encrypt a single Terminal
  method EncryptTermina(
    client: Primitives.AtomicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    fieldRootKey : Key,
    offset : uint32,
    path : CanonicalPath,
    data : StructuredDataTerminal
  )
    returns (ret : Result<StructuredData, Error>)
    requires offset as nat * 3 < UINT32_LIMIT
    ensures ret.Success? ==> ret.value.content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var dataKey :- FieldKey(fieldRootKey, offset);
    var encryptionKey : Key := dataKey[0..KeySize];
    var nonce : Nonce := dataKey[KeySize..];
    var value := data.value;

    var encInput := Prim.AESEncryptInput(
      encAlg := alg.encrypt.AES_GCM,
      iv := nonce,
      key := encryptionKey,
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
    ensures ret.Success? ==> ret.value.content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var dataKey :- FieldKey(fieldRootKey, offset);
    var encryptionKey : Key := dataKey[0..KeySize];
    var nonce : Nonce := dataKey[KeySize..];
    var value := data.value;

    :- Need((AuthTagSize+2) <= |value|, E("cipherTxt too short."));
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
