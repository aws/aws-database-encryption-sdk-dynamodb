// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../StructuredEncryptionConstants.dfy"

module DecryptStructureOperation {
  import opened Wrappers
  import opened StandardLibrary
  import StructuredEncryptionConstants
  import Types = AwsCryptographyStructuredEncryptionTypes

  method DecryptStructure(config: Types.StructuredEncryptionConfig, input: Types.DecryptStructureInput)
      returns (output: Result<Types.DecryptStructureOutput, Types.Error>)
    ensures 
      (
        || (input.cmm.Some? && input.keyring.Some?)
        || (input.cmm.None? && input.keyring.None?)
      ) ==> output.Failure?
    ensures |input.cryptoSchemas| <= 0 ==> output.Failure?
  {
    // Ensure a Keyring XOR a CMM was included on input, otherwise error
    :- Need(input.cmm.Some? || input.keyring.Some?,
      Types.Error.StructuredEncryptionException(
        message := "Invalid input: A Keyring or CMM MUST be supplied on input."));
    :- Need(input.cmm.None? || input.keyring.None?,
      Types.Error.StructuredEncryptionException(
        message := "Invalid input: Cannot recieve both a Keyring and a CMM on input."));

    // Ensure CryptoSchemas is not empty
    :- Need(|input.cryptoSchemas| > 0,
      Types.Error.StructuredEncryptionException(
        message := "Invalid input: a non-empty Crypto Schema map must be supplied on input."));

    // TODO: Currently stubbed out to return a hardcoded StructuredData
    var stubbedBytes := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];
    var stubbedStructure := Types.StructuredData(
      content := Types.StructuredDataContent.dataMap(
        StructuredDataMap := map[
          "foo" := Types.StructuredData(
            content := Types.StructuredDataContent.terminal(
                Terminal := Types.Terminal(
                    value := stubbedBytes,
                    typeId := StructuredEncryptionConstants.BYTES_TYPE_ID
                )
            ),
            attributes := None()
          ),
          "bar" := Types.StructuredData(
            content := Types.StructuredDataContent.terminal(
                Terminal := Types.Terminal(
                    value := stubbedBytes,
                    typeId := StructuredEncryptionConstants.BYTES_TYPE_ID
                )
            ),
            attributes := None()
          ),
          "fizzbuzz" := Types.StructuredData(
            content := Types.StructuredDataContent.terminal(
                Terminal := Types.Terminal(
                    value := stubbedBytes,
                    typeId := StructuredEncryptionConstants.BYTES_TYPE_ID
                )
            ),
            attributes := None()
          )
        ]
      ),
      attributes := None()
    );

    var decryptOutput := Types.DecryptStructureOutput(plaintextStructure := stubbedStructure);
    output := Success(decryptOutput);
  }
}
