// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/Beacon.dfy"

module TestBaseBeacon {
  import opened BaseBeacon
  import opened Wrappers
/*
  method TestFail(b : Beacon, s : string)
  {
    var str := b.compoundHash(s);
    if !str.Failure? {
      print "Expected failure, got " + str.value + ", from ", s, "\n";
    }
    expect str.Failure?;
  }

  method TestCompound(b : Beacon, s : string, exp : string)
  {
    var str := b.compoundHash(s);
    if !str.Success? {
      print "Expected Success, got failure, from ", s, "\n", str, "\n";
    }

    expect str.Success?;

    if (str.value != exp) {
      print "Expected ", exp, " got ", str.value, " from ", s, "\n";
    }
    expect str.value == exp;
  }
*/
  const Timestamp := Part("timestamp", "T-", None);
  const Secret := Part("secret", "S-", Some(4));

  method {:test} TestCompoundBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var b1 := CompoundBeacon('.', [Timestamp, Secret], []);
    var b := Beacon(client := primitives, name := "foo", key := [1,2], config := Compound(b1));
    var data := map["timestamp" := "1234", "secret" := "abcd"];
    var bytes :- expect b.getHmac(UTF8.EncodeAscii("S-abcd"));
    expect bytes[7] == 0x42;

    var str :- expect b.compoundHash(data);
    expect str == "T-1234.S-2";

    var query :-  expect b.getPart("T-1234.S-abcd");
    expect query == "T-1234.S-2";
  }

  method {:test} TestBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var b := Beacon(client := primitives, name := "foo", key := [1,2], config := Standard(8));
    var bytes :- expect b.getHmac([1,2,3]);
    expect bytes == [0x27, 0x93, 0x93, 0x8b, 0x26, 0xe9, 0x52, 0x7e];
    var str :- expect b.standardHash([1,2,3]);
    expect str == "7e";
    bytes :- expect b.getHmac([]);
    expect bytes[7] == 0x80;
    str :- expect b.standardHash([]);
    expect str == "80";
    bytes :- expect b.getHmac(UTF8.EncodeAscii("123"));
    expect bytes[7] == 0x61;
  }

}