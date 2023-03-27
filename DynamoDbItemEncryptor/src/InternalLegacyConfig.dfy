// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"

module {:extern "Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Internal"} InternalLegacyConfig {
  import opened Wrappers
  import Types = AwsCryptographyDynamoDbItemEncryptorTypes

  class {:extern} InternalLegacyConfig {

    static method {:extern} Build(encryptorConfig: Types.DynamoDbItemEncryptorConfig)
      returns (output: Result<Option<InternalLegacyConfig>, Types.Error>)

    const policy: Types.LegacyPolicy

    method {:extern} EncryptItem(input: Types.EncryptItemInput)
      returns (output: Result<Types.EncryptItemOutput, Types.Error>)
    method {:extern} DecryptItem(input: Types.DecryptItemInput)
      returns (output: Result<Types.DecryptItemOutput, Types.Error>)

    predicate method {:extern} IsLegacyInput(input: Types.DecryptItemInput)

  }
  
}