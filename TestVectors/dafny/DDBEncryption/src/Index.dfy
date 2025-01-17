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
  import KeyVectors
  import KeyVectorsTypes = AwsCryptographyMaterialProvidersTestVectorKeysTypes

  method AddJson(prev : TestVectorConfig, file : string, keyVectors: KeyVectors.KeyVectorsClient)
    returns (output : Result<TestVectorConfig, string>)
    requires keyVectors.ValidState()
    modifies keyVectors.Modifies
    ensures keyVectors.ValidState()
  {
    var configBv := FileIO.ReadBytesFromFile(file);
    if configBv.Failure? {
      print "Failed to open ", file, " continuing anyway.\n";
      return Success(MakeEmptyTestVector());
    }
    var configBytes := BvToBytes(configBv.value);
    var json :- expect API.Deserialize(configBytes);
    output := ParseTestVector(json, prev, keyVectors);
    if output.Failure? {
      print output.error, "\n";
    }
  }

  method ASDF() 
  {
    // Create a singleton keyVectors client used in every test.
    // Right now, all test vectors use the same keys manifest, located at DEFAULT_KEYS.
    // Parsing JSON is expensive in some languages.
    // 
    var keyVectors :- expect KeyVectors.KeyVectors(
      KeyVectorsTypes.KeyVectorsConfig(
        keyManifestPath := DEFAULT_KEYS
      )
    );

    WriteSetPermutations.WriteSetPermutations();
    var config := MakeEmptyTestVector();
    config :- expect AddJson(config, "records.json", keyVectors);
    config :- expect AddJson(config, "configs.json", keyVectors);
    config :- expect AddJson(config, "data.json", keyVectors);
    config :- expect AddJson(config, "iotest.json", keyVectors);
    config :- expect AddJson(config, "PermTest.json", keyVectors);
    config.RunAllTests(keyVectors);
  }
}
