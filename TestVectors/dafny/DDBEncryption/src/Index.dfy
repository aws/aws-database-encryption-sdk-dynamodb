// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "LibraryIndex.dfy"
include "TestVectors.dfy"

module WrappedDDBEncryptionMain {
  import opened Wrappers
  import opened DdbEncryptionTestVectors

  import CreateInterceptedDDBClient
  import FileIO
  import JSON.API
  import opened JSONHelpers

  method AddJson(prev : TestVectorConfig, file : string) returns (output : Result<TestVectorConfig, string>)
  {
    var configBv :- expect FileIO.ReadBytesFromFile(file);
    var configBytes := BvToBytes(configBv);
    var json :- expect API.Deserialize(configBytes);
    output := ParseTestVector(json, prev);
    if output.Failure? {
      print output.error, "\n";
    }
  }

  method ASDF() {
    var config := MakeEmptyTestVector();
    config :- expect AddJson(config, "records.json");
    config :- expect AddJson(config, "configs.json");
    config :- expect AddJson(config, "data.json");
    config :- expect AddJson(config, "iotest.json");
    config.RunAllTests();
  }
}
