package software.amazon.cryptography.examples;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;

public class ConfigUtils {
    public static DynamoDbItemEncryptorConfig fromEncryptionInterceptor(
        final DynamoDbEncryptionInterceptor encryptionInterceptor,
        final String tableName
    ) {
        DynamoDbTableEncryptionConfig tableEncryptionConfig =
            encryptionInterceptor.config().tableEncryptionConfigs().get(tableName);
        DynamoDbItemEncryptorConfig.Builder builder = DynamoDbItemEncryptorConfig.builder();
        builder.logicalTableName(tableEncryptionConfig.logicalTableName());
        builder.partitionKeyName(tableEncryptionConfig.partitionKeyName());
        builder.sortKeyName(tableEncryptionConfig.sortKeyName());
        builder.attributeActionsOnEncrypt(tableEncryptionConfig.attributeActionsOnEncrypt());
        builder.allowedUnsignedAttributes(tableEncryptionConfig.allowedUnsignedAttributes());
        builder.allowedUnsignedAttributePrefix(tableEncryptionConfig.allowedUnsignedAttributePrefix());
        builder.algorithmSuiteId(tableEncryptionConfig.algorithmSuiteId());
        builder.keyring(tableEncryptionConfig.keyring());
        return builder.build();
    }
}
