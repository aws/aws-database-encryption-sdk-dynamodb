package CreateWrappedItemEncryptor_Compile;

import Wrappers_Compile.Result;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToDafny;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.wrapped.TestDynamoDbItemEncryptor;

public class __default {

  public static Result<IDynamoDbItemEncryptorClient, Error> CreateWrappedItemEncryptor(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig config
  ) {
    try {
      final DynamoDbItemEncryptorConfig nativeConfig =
        ToNative.DynamoDbItemEncryptorConfig(config);

      final DynamoDbItemEncryptor itemEncryptor = DynamoDbItemEncryptor
        .builder()
        .DynamoDbItemEncryptorConfig(nativeConfig)
        .build();

      final TestDynamoDbItemEncryptor wrappedEncryptor = TestDynamoDbItemEncryptor
        .builder()
        .impl(itemEncryptor)
        .build();

      return Result.create_Success(wrappedEncryptor);
    } catch (Exception e) {
      return Result.create_Failure(ToDafny.Error((RuntimeException) e));
    }
  }
}
