package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.wrapped;

import Wrappers_Compile.Result;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.wrapped.TestDynamoDbEncryption;
import software.amazon.cryptography.materialproviders.internaldafny.wrapped._ExternBase___default;

public class __default extends _ExternBase___default {

  public static Result<
    IDynamoDbEncryptionClient,
    Error
  > WrappedDynamoDbEncryption(DynamoDbEncryptionConfig config) {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig wrappedConfig =
      ToNative.DynamoDbEncryptionConfig(config);
    software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption impl =
      DynamoDbEncryption
        .builder()
        .DynamoDbEncryptionConfig(wrappedConfig)
        .build();
    TestDynamoDbEncryption wrappedClient = TestDynamoDbEncryption
      .builder()
      .impl(impl)
      .build();
    return Result.create_Success(wrappedClient);
  }
}
