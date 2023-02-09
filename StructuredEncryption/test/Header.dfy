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
  import opened StructuredEncryptionUtil

  import StructuredEncryption
  import AwsCryptographyMaterialProvidersTypes
  import CMP = AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import TestFixtures
  import opened StructuredEncryptionHeader
  import opened StructuredEncryptionPaths
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
    var ser := head.serialize() + head.msgID; // msgID as fake commitment
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
    var key : Bytes := head.msgID;
    var ser :- expect Serialize(client, key, head);
    var orig :- expect PartialDeserialize(ser);
    expect orig == head;
    var goodResult :- expect head.check(client, key, ser);

    var lastByte := ser[|ser|-1];
    var badByte : uint8 := if lastByte == 0 then 255 as uint8 else lastByte - 1;
    var badSer := ser[..|ser|-1] + [badByte];
    var head2 :- expect PartialDeserialize(badSer);
    expect head2 == head;
    var badResult := head.check(client, key, badSer);

    expect badResult.Failure?;
    expect badResult.error == E("Key commitment mismatch.");
  }

  const a : uint8 := 'a' as uint8;
  const b : uint8 := 'b' as uint8;
  const c : uint8 := 'c' as uint8;
  const d : uint8 := 'd' as uint8;
  const e : uint8 := 'e' as uint8;
  const f : uint8 := 'f' as uint8;
  method {:test} TestDuplicateContext() {
    var cont : CMPEncryptionContext := map[EncodeAscii("abc") := EncodeAscii("def"), EncodeAscii("cba") := EncodeAscii("fed")];
    var serCont := SerializeContext(cont);
    expect serCont == [
      0,2, // two items
      0,3,a,b,c,
      0,3,d,e,f,
      0,3,c,b,a,
      0,3,f,e,d
    ];
    var newCont := GetContext(serCont);
    expect newCont.Success?;
    expect newCont.value.0 == cont;
    expect newCont.value.1 == |serCont|;

    var badSerCont := [
      0,3, // three items
      0,3,a,b,c,
      0,3,d,e,f,
      0,3,c,b,a,
      0,3,f,e,d,
      0,3,a,b,c, // oops, a duplicate
      0,3,e,d,f
    ];
    var newBadCont := GetContext(badSerCont);
    //= specification/structured-encryption/header.md#key-value-pair-entries
    //= type=test
    //# This sequence MUST NOT contain duplicate entries.
    expect newBadCont == Failure(E("Context keys out of order."));
  }

  method {:test} TestOutOfOrderContext() {
    var badSerCont := [
      0,2, // two items
      0,3,c,b,a,
      0,3,f,e,d,
      0,3,a,b,c, // oops, abc after cba
      0,3,d,e,f
    ];
    var newBadCont := GetContext(badSerCont);
    //= specification/structured-encryption/header.md#key-value-pair-entries
    //= type=test
    //# These entries MUST have entries sorted, by key,
    //# in ascending order according to the UTF-8 encoded binary value.
    expect newBadCont == Failure(E("Context keys out of order."));
  }

  function method MakeSchema(action: CryptoAction) : CryptoSchema
  {
    CryptoSchema (
      content := CryptoSchemaContent.Action(action),
      attributes := None
    )
  }

  method {:test} TestSchemaOrderAlpha() {
    var schemaMap : CryptoSchemaMap := map[
      "abc" := MakeSchema(ENCRYPT_AND_SIGN),
      "def" := MakeSchema(SIGN_ONLY),
      "ghi" := MakeSchema(DO_NOTHING),
      "jkl" := MakeSchema(ENCRYPT_AND_SIGN),
      "mno" := MakeSchema(SIGN_ONLY),
      "pqr" := MakeSchema(DO_NOTHING)
    ];
    var schema := CryptoSchema(content := CryptoSchemaContent.SchemaMap(schemaMap), attributes := None);
    var tableName : GoodString := "name";
    var legend :- expect MakeLegend(tableName, schema);
    //= specification/structured-encryption/header.md#encrypt-legend-bytes
    //= type=test
    //# The Encrypt Legend Bytes MUST be serialized as follows:
    // 1. Order every authenticated attribute in the item lexicographically by the attribute name.
    // TODO - we must sort by the Canoncial Path, which is slightly different, even for just plain
    // attribute names in a single table.
    // 2. For each authenticated terminal, in order,
    // append one of the byte values specified above to indicate whether
    // that field should be encrypted.
    expect legend == [ENCRYPT_AND_SIGN_LEGEND, SIGN_ONLY_LEGEND, ENCRYPT_AND_SIGN_LEGEND, SIGN_ONLY_LEGEND];
  }

  method {:test} TestSchemaOrderLength() {
    var schemaMap : CryptoSchemaMap := map[
      "aa" := MakeSchema(ENCRYPT_AND_SIGN),
      "zz" := MakeSchema(SIGN_ONLY),
      "aaa" := MakeSchema(DO_NOTHING),
      "zzz" := MakeSchema(ENCRYPT_AND_SIGN),
      "aaaa" := MakeSchema(SIGN_ONLY),
      "zzzz" := MakeSchema(DO_NOTHING)
    ];
    var schema := CryptoSchema(content := CryptoSchemaContent.SchemaMap(schemaMap), attributes := None);
    var tableName : GoodString := "name";
    var legend :- expect MakeLegend(tableName, schema);
    //= specification/structured-encryption/header.md#encrypt-legend-bytes
    //= type=test
    //# The Encrypt Legend Bytes MUST be serialized as follows:
    // 1. Order every authenticated attribute in the item lexicographically by the attribute name.
    // TODO - we must sort by the Canoncial Path, which is slightly different, even for just plain
    // attribute names in a single table.
    // 2. For each authenticated terminal, in order,
    // append one of the byte values specified above to indicate whether
    // that field should be encrypted.
    expect legend == [ENCRYPT_AND_SIGN_LEGEND, SIGN_ONLY_LEGEND, ENCRYPT_AND_SIGN_LEGEND, SIGN_ONLY_LEGEND];
  }

}
