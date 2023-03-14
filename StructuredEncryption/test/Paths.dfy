// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Paths.dfy"
include "../src/Virtual.dfy"

module PathsTests {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths
  import opened VirtualFields

  method {:test} TestSpecExamples() {
    var tableName : GoodString := "example_table";
    assert(ValidString("example_table"));
    var nameSrc :- expect MakeTerminalLocation("name");
    expect nameSrc.canonicalPath(tableName) == 
         UTF8.EncodeAscii("example_table")
      + [0,0,0,0,0,0,0,1] // depth
      + ['$' as uint8] // map
      + [0,0,0,0,0,0,0,4] // length
      + UTF8.EncodeAscii("name");

    var stampSrc :- expect MakeTerminalLocation("status-history[0].timestamp");
    expect stampSrc.canonicalPath(tableName) == 
        UTF8.EncodeAscii("example_table")
      + [0,0,0,0,0,0,0,3] // depth
      + ['$' as uint8] // map
      + [0,0,0,0,0,0,0,14] // length of "status-history"
      + UTF8.EncodeAscii("status-history")
      + ['#' as uint8] // array
      + [0,0,0,0,0,0,0,0] // index
      + ['$' as uint8] // map
      + [0,0,0,0,0,0,0,9] // length of "timestamp"
      + UTF8.EncodeAscii("timestamp");
  }
}