// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionItemEncryptorTypes.dfy"

module {:extern "Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal"} InternalLegacyConfig {
  import opened Wrappers
  import Types = AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import DDBE = AwsCryptographyDynamoDbEncryptionTypes

  class {:extern} InternalLegacyConfig {

    static method {:extern} Build(encryptorConfig: Types.DynamoDbItemEncryptorConfig)
      returns (output: Result<Option<InternalLegacyConfig>, Types.Error>)

    const policy: DDBE.LegacyPolicy

    method {:extern} EncryptItem(input: Types.EncryptItemInput)
      returns (output: Result<Types.EncryptItemOutput, Types.Error>)
    method {:extern} DecryptItem(input: Types.DecryptItemInput)
      returns (output: Result<Types.DecryptItemOutput, Types.Error>)

    predicate method {:extern} IsLegacyInput(input: Types.DecryptItemInput)

  }
  
}
