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

    const {:extern} policy: DDBE.LegacyPolicy

    method {:extern} EncryptItem(input: Types.EncryptItemInput)
      returns (output: Result<Types.EncryptItemOutput, Types.Error>)
    method {:extern} DecryptItem(input: Types.DecryptItemInput)
      returns (output: Result<Types.DecryptItemOutput, Types.Error>)

    predicate method {:extern} IsLegacyInput(input: Types.DecryptItemInput)

  }

  // The following functions are for the benefit of the extern implementation to call,
  // avoiding direct references to generic datatype constructors
  // since their calling pattern is different between different versions of Dafny
  // (i.e. after 4.2, explicit type descriptors are required).

  function method CreateBuildSuccess(value: Option<InternalLegacyOverride>): Result<Option<InternalLegacyOverride>, Types.Error> {
    Success(value)
  }

  function method CreateBuildFailure(error: Types.Error): Result<Option<InternalLegacyOverride>, Types.Error> {
    Failure(error)
  }

  function method CreateInternalLegacyOverrideSome(value: InternalLegacyOverride): Option<InternalLegacyOverride> {
    Some(value)
  }

  function method CreateInternalLegacyOverrideNone(): Option<InternalLegacyOverride> {
    None
  }

  function method CreateEncryptItemSuccess(value: Types.EncryptItemOutput): Result<Types.EncryptItemOutput, Types.Error> {
    Success(value)
  }

  function method CreateEncryptItemFailure(error: Types.Error): Result<Types.EncryptItemOutput, Types.Error> {
    Failure(error)
  }

  function method CreateDecryptItemSuccess(value: Types.DecryptItemOutput): Result<Types.DecryptItemOutput, Types.Error> {
    Success(value)
  }

  function method CreateDecryptItemFailure(error: Types.Error): Result<Types.DecryptItemOutput, Types.Error> {
    Failure(error)
  }

}
