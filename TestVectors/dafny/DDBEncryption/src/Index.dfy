// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "LibraryIndex.dfy"
include "TestVectors.dfy"
include "WriteSetPermutations.dfy"

module WrappedDDBEncryptionMain {
  import opened Wrappers
  import opened DdbEncryptionTestVectors

  import WriteSetPermutations
  import CreateInterceptedDDBClient
  import FileIO
  import JSON.API
  import opened JSONHelpers

  method AddJson(prev : TestVectorConfig, file : string) returns (output : Result<TestVectorConfig, string>)
  {
    var configBv := FileIO.ReadBytesFromFile(file);
    if configBv.Failure? {
      print "Failed to open ", file, " continuing anyway.\n";
      return Success(MakeEmptyTestVector());
    }
    var configBytes := BvToBytes(configBv.value);
    var json :- expect API.Deserialize(configBytes);
    output := ParseTestVector(json, prev);
    if output.Failure? {
      print output.error, "\n";
    }
  }

  method ASDF() {
    WriteSetPermutations.WriteSetPermutations();
    var config := MakeEmptyTestVector();
    config :- expect AddJson(config, "records.json");
    config :- expect AddJson(config, "configs.json");
    config :- expect AddJson(config, "data.json");
    config :- expect AddJson(config, "iotest.json");
    config :- expect AddJson(config, "PermTest.json");
    config.RunAllTests();
  }
}
