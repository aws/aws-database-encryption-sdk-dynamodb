// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

using software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

namespace software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy
{

  public partial class InternalLegacyOverride
  {
    public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyPolicy _policy
    {
      get => software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy.create_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT();
      set { }
    }
    public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._ILegacyPolicy policy
    {
      get
      {
        return this._policy;
      }
    }
    public static Wrappers_Compile._IResult<
      Wrappers_Compile._IOption<InternalLegacyOverride>,
      _IError
    > Build(_IDynamoDbItemEncryptorConfig config)
    {
      if (config.dtor_legacyOverride.is_None)
      {
        return Wrappers_Compile
          .Result<Wrappers_Compile._IOption<InternalLegacyOverride>, _IError>
          .create_Success(Wrappers_Compile.Option<InternalLegacyOverride>.create_None());
      }
      // .Net does not support the Legacy DDB-EC
      var ex = new Error_DynamoDbItemEncryptorException(
        Dafny.Sequence<char>.FromString("Legacy configuration unsupported."));
      return Wrappers_Compile
        .Result<Wrappers_Compile._IOption<InternalLegacyOverride>, _IError>
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
