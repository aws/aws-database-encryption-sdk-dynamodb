package software.amazon.cryptography.DynamoDbEncryption.Wrapped;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig;
import Wrappers_Compile.Result;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.wrapped.TestDynamoDbEncryption;

public class __default extends _ExternBase___default {
    public static Result<IDynamoDbEncryptionClient, Error> WrappedDynamoDbEncryption(DynamoDbEncryptionConfig config) {
        software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig wrappedConfig = ToNative.DynamoDbEncryptionConfig(config);
        software.amazon.cryptography.dynamoDbEncryption.DynamoDbEncryption impl = DynamoDbEncryption.builder().DynamoDbEncryptionConfig(wrappedConfig).build();
        TestDynamoDbEncryption wrappedClient = TestDynamoDbEncryption.builder().impl(impl).build();
        return Result.create_Success(wrappedClient);
    }
}
