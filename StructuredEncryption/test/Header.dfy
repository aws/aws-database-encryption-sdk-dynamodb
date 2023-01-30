// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/Index.dfy"
include "TestFixtures.dfy"
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/src/Index.dfy"
include "../src/Header.dfy"

module TestHeader {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import StructuredEncryption
  import AwsCryptographyMaterialProvidersTypes
  import CMP = AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import TestFixtures
  import opened Header
  import opened UTF8
  import Aws.Cryptography.Primitives

  method {:test} TestRoundTrip() {
    var head := PartialHeader (
      version := 1,
      flavor := 1,
      msgID := [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32],
      legend := [0x65, 0x73],
      encContext := map[EncodeAscii("abc") := EncodeAscii("def")],
      dataKeys := [CMP.EncryptedDataKey(
        keyProviderId := EncodeAscii("provID") ,
        keyProviderInfo := [1,2,3,4,5],
        ciphertext := [6,7,8,9])]
    );
    var ser := head.serialize();
    var orig :- expect PartialDeserialize(ser);
    expect orig == head;
  }

  method {:test} TestRoundTripWithCommit() {
    var client :- expect Primitives.AtomicPrimitives();
    var head := PartialHeader (
      version := 1,
      flavor := 1,
      msgID := [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32],
      legend := [0x65, 0x73],
      encContext := map[EncodeAscii("abc") := EncodeAscii("def")],
      dataKeys := [CMP.EncryptedDataKey(
        keyProviderId := EncodeAscii("provID") ,
        keyProviderInfo := [1,2,3,4,5],
        ciphertext := [6,7,8,9])]
    );
    var ser :- expect Serialize(client, head);
    var orig :- expect Deserialize(client, ser);
    expect orig == head;

    var lastByte := ser[|ser|-1];
    var badByte : uint8 := if lastByte == 0 then 255 as uint8 else lastByte - 1;
    var badSer := ser[..|ser|-1] + [badByte];
    var badness := Deserialize(client, badSer);
    expect badness.Failure?;
    expect badness.error == E("Key commitment mismatch.");
  }

}
