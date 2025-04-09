// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Paths.dfy"

module PathsTests {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths

  const example_table : UTF8.ValidUTF8Bytes :=
    var s := [0x65, 0x78, 0x61, 0x6d, 0x70, 0x6c, 0x65, 0x5f, 0x74, 0x61, 0x62, 0x6c, 0x65];
    assert s == UTF8.EncodeAscii("example_table");
    s

  const name : UTF8.ValidUTF8Bytes :=
    var s := [0x6e, 0x61, 0x6d, 0x65];
    assert s == UTF8.EncodeAscii("name");
    s

  method {:test} TestSpecExamples() {
    var tableName : GoodString := "example_table";
    assert(ValidString("example_table"));
    var pathToTest := StringToUniPath("name");
    expect CanonPath(tableName, pathToTest) ==
           example_table
           + [0,0,0,0,0,0,0,1] // depth
           + ['$' as uint8] // map
           + [0,0,0,0,0,0,0,4] // length
           + name;
  }
}
