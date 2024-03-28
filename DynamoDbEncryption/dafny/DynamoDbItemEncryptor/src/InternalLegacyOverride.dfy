// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.dfy"

module {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy"} InternalLegacyOverride {
  import opened Wrappers
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes

  class {:extern} InternalLegacyOverride {

    static method {:extern} Build(encryptorConfig: Types.DynamoDbItemEncryptorConfig)
      returns (output: Result<Option<InternalLegacyOverride>, Types.Error>)

    const policy: DDBE.LegacyPolicy

    method {:extern} EncryptItem(input: Types.EncryptItemInput)
      returns (output: Result<Types.EncryptItemOutput, Types.Error>)
    method {:extern} DecryptItem(input: Types.DecryptItemInput)
      returns (output: Result<Types.DecryptItemOutput, Types.Error>)

    predicate method {:extern} IsLegacyInput(input: Types.DecryptItemInput)

  }

}
