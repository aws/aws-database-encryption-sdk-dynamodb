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

  const Timestamp := BeaconPart("timestamp", TermLocMap("timestamp"), "T-", None);
  const Secret := BeaconPart("secret", TermLocMap("secret"), "S-", Some(4));

  method {:test} TestCompoundBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var b := BeaconBase(client := primitives, name := "foo", beaconName := "aws_dbe_b_foo", key := [1,2]);
    var parts := [Timestamp, Secret];
    var cons := MakeDefaultConstructor(parts);
    var b1 := CompoundBeacon(b, '.', parts, [cons]);
    var data := map["timestamp" := "1234", "secret" := "abcd"];
    var bytes :- expect b.getHmac(UTF8.EncodeAscii("S-abcd"));
    expect bytes[7] == 0x42;

   // var str :- expect b1.hash(t => StringifyMap(t, data));
   // expect str == "T-1234.S-2";

    var query :-  expect b1.getPart("T-1234.S-abcd");
    expect query == "T-1234.S-2";
  }

  method {:test} TestBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var bb := BeaconBase(client := primitives, name := "foo", beaconName := "aws_dbe_b_foo", key := [1,2]);
    var b := StandardBeacon(bb, 8, TermLocMap("foo"));
    var bytes :- expect bb.getHmac([1,2,3]);
    expect bytes == [0x27, 0x93, 0x93, 0x8b, 0x26, 0xe9, 0x52, 0x7e];
    var str :- expect b.hash([1,2,3]);
    expect str == "7e";
    bytes :- expect bb.getHmac([]);
    expect bytes[7] == 0x80;
    str :- expect b.hash([]);
    expect str == "80";
    bytes :- expect bb.getHmac(UTF8.EncodeAscii("123"));
    expect bytes[7] == 0x61;
  }

  method {:test} TestFailures() {
    var version := T.BeaconVersion (
      version := 1,
      key := T.BeaconKey(keyArn := "", tableArn := "", branchKeyID := ""),
      standardBeacons := None,
      compoundBeacons := Some([BadPrefix]),
      virtualFields := None
    );
    var beaconVersion :- expect C.ConvertVersionWithKey(FullTableConfig, version, [1,2,3,4,5]);

    var res := beaconVersion.ValidStateResult();
    expect res.Failure?;
    expect_equal(res.error, E("Compound beacon BadPrefix defines part Title with prefix T_ which is incompatible with part TooBad which has a prefix of T."));
  }

}
