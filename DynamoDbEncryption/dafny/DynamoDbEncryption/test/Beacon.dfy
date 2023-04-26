// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Beacon.dfy"
include "../src/CompoundBeacon.dfy"
include "BeaconTestFixtures.dfy"
include "../src/ConfigToInfo.dfy"
include "../src/SearchInfo.dfy"

module TestBaseBeacon {
  import T = AwsCryptographyDynamoDbEncryptionTypes
  import opened BaseBeacon
  import opened CompoundBeacon
  import opened Wrappers
  import opened TermLoc
  import opened BeaconTestFixtures
  import opened DynamoDbEncryptionUtil
  import C = SearchConfigToInfo
  import I = SearchableEncryptionInfo
  import SI = SearchableEncryptionInfo

  //const Timestamp := BeaconPart("timestamp", TermLocMap("timestamp"), "T-", None);
  //const Secret := BeaconPart("secret", TermLocMap("secret"), "S-", Some(4));
/*
  method {:test} TestCompoundBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var b := BeaconBase(client := primitives, name := "foo", beaconName := "aws_dbe_b_foo");
    var parts := [Timestamp, Secret];
    var cons := MakeDefaultConstructor(parts);
    var b1 := CompoundBeacon(b, '.', parts, [cons]);
    var data := map["timestamp" := "1234", "secret" := "abcd"];
    var bytes :- expect b.getHmac(UTF8.EncodeAscii("S-abcd"), key := [1,2]);
    expect bytes[7] == 0x42;

   // var str :- expect b1.hash(t => StringifyMap(t, data));
   // expect str == "T-1234.S-2";

    var query :-  expect b1.getPart("T-1234.S-abcd", key := [1,2]);
    expect query == "T-1234.S-2";
  }
*/
  method {:test} TestBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var bb := BeaconBase(client := primitives, name := "foo", beaconName := "aws_dbe_b_foo");
    var b := StandardBeacon(bb, 8, TermLocMap("foo"));
    var bytes :- expect bb.getHmac([1,2,3], key := [1,2]);
    expect bytes == [0x27, 0x93, 0x93, 0x8b, 0x26, 0xe9, 0x52, 0x7e];
    var str :- expect b.hash([1,2,3], key := [1,2]);
    expect str == "7e";
    bytes :- expect bb.getHmac([], key := [1,2]);
    expect bytes[7] == 0x80;
    str :- expect b.hash([], key := [1,2]);
    expect str == "80";
    bytes :- expect bb.getHmac(UTF8.EncodeAscii("123"), key := [1,2]);
    expect bytes[7] == 0x61;
  }

  method {:test} TestBadPrefix() {
    var store := GetKeyStore();
    var version := T.BeaconVersion (
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [NameB, TitleB, TooBadB],
      compoundBeacons := Some([BadPrefix]),
      virtualFields := None
    );
    var src := GetLiteralSource([1,2,3,4,5], version);
    var res := C.ConvertVersionWithSource(FullTableConfig, version, src);

    expect res.Failure?;
    expect_equal(res.error, E("Compound beacon BadPrefix defines part Title with prefix T_ which is incompatible with part TooBad which has a prefix of T."));
  }

  
  method {:test} TestContainsSplit()
  {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    var badItem := SimpleItem["Name" := DDB.AttributeValue.S("A.B")];
    var badAttrs := bv.GenerateEncryptedBeacons(badItem, DontUseKeyId);
    expect badAttrs.Failure?;
    expect_equal(badAttrs.error, E("Part Name for beacon Mixed has value 'A.B' which contains the split character .'."));
  }

  method {:test} TestNumbersNormalize()
  {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    assert Std2String == DDB.AttributeValue.N("1.23");
    expect "aws_dbe_b_std2" in goodAttrs;
    expect goodAttrs["aws_dbe_b_std2"] == DDB.AttributeValue.S("b1eb7a");
    var newItem := SimpleItem["std2" := DDB.AttributeValue.N("000001.23000000")];
    var newAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect "aws_dbe_b_std2" in newAttrs;
    expect goodAttrs["aws_dbe_b_std2"] == newAttrs["aws_dbe_b_std2"];
  }
}
