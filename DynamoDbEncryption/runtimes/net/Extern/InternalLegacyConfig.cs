// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

using Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Types;

namespace Dafny.Aws.Cryptography.DynamoDbItemEncryptor.Internal
{

  public partial class InternalLegacyConfig
  {

    public static Wrappers_Compile._IResult<
      Wrappers_Compile._IOption<InternalLegacyConfig>,
      _IError
    > Build(_IDynamoDbItemEncryptorConfig config)
    {
      if (config.dtor_legacyConfig.is_None)
      {
        return Wrappers_Compile
          .Result<Wrappers_Compile._IOption<InternalLegacyConfig>, _IError>
          .create_Success(Wrappers_Compile.Option<InternalLegacyConfig>.create_None());
      }
      // .Net does not support the Legacy DDB-EC
      var ex = new Error_DynamoDbItemEncryptorException(
        Dafny.Sequence<char>.FromString("Legacy configuration unsupported."));
      return Wrappers_Compile
        .Result<Wrappers_Compile._IOption<InternalLegacyConfig>, _IError>
        .create_Failure(ex);
    }

    public Wrappers_Compile._IResult<
      _IEncryptItemOutput,
      _IError
    > EncryptItem(_IEncryptItemInput input)
    {
      // .Net does not support the Legacy DDB-EC
      var ex = new Error_DynamoDbItemEncryptorException(
        Dafny.Sequence<char>.FromString("Legacy configuration unsupported."));
      return Wrappers_Compile.Result<_IEncryptItemOutput, _IError>
        .create_Failure(ex);
    }

    public Wrappers_Compile._IResult<
      _IDecryptItemOutput,
      _IError
    > DecryptItem(_IDecryptItemInput input)
    {
      // .Net does not support the Legacy DDB-EC
      var ex = new Error_DynamoDbItemEncryptorException(
        Dafny.Sequence<char>.FromString("Legacy configuration unsupported."));
      return Wrappers_Compile.Result<_IDecryptItemOutput, _IError>
        .create_Failure(ex);
    }

    public bool IsLegacyInput(_IDecryptItemInput input)
    {
      // .Net does not support the Legacy DDB-EC
      return false;
    }
  }

}
