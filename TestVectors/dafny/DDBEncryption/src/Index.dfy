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


  const DEFAULT_KEYS : string := "../../../submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders/test/keys.json"

  method AddJson(prev : TestVectorConfig, file : string, keyVectors: KeyVectors.KeyVectorsClient)
    returns (output : Result<TestVectorConfig, string>)
    requires keyVectors.ValidState()
    modifies keyVectors.Modifies
    ensures keyVectors.ValidState()
  {
    var configBytes := FileIO.ReadBytesFromFile(file);
    if configBytes.Failure? {
      print "Failed to open ", file, " continuing anyway.\n";
      return Success(MakeEmptyTestVector());
    }
    var json :- expect API.Deserialize(configBytes.value);
    output := ParseTestVector(json, prev, keyVectors);
    if output.Failure? {
      print output.error, "\n";
    }
  }

  method ASDF()
  {
    // KeyVectors client passed to every test.
    // All test vectors currently use the same keys manifest, located at DEFAULT_KEYS.
    // All test vectors can share this same KeyVectors client.

    // To use a different keys manifest, create a new KeyVectors client.
    // If you need to create a new KeyVectors client, create it as infrequently as possible.
    // Creating this client frequently means JSON is parsed frequently.
    // Parsing JSON is very slow in Python. Parse JSON as infrequently as possible.
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
