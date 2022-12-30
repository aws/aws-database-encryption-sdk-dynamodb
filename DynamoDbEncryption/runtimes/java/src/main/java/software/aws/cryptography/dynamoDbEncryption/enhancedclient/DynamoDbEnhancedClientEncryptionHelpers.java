package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DynamoDbEnhancedClientEncryptionHelpers {
    public static DynamoDbEncryptionInterceptor CreateDynamoDbEncryptionInterceptorWithTableSchema(
            CreateDynamoDbEncryptionInterceptorWithTableSchemaInput input) {
        DynamoDbTableEncryptionConfig.Builder builder = DynamoDbTableEncryptionConfig.builder();
        Map<String, CryptoAction> actions = new HashMap<>();

        String partitionName = input.tableSchema().tableMetadata().primaryPartitionKey();
        builder = builder.partitionKeyName(partitionName);
        actions.put(partitionName, CryptoAction.SIGN_ONLY);

        Optional<String> sortName = input.tableSchema().tableMetadata().primarySortKey();
        if (sortName.isPresent()) {
            builder = builder.sortKeyName(sortName.get());
            actions.put(sortName.get(), CryptoAction.SIGN_ONLY);
        }

        DynamoDbTableEncryptionConfig tableConfig = builder.allowedUnauthenticatedAttributePrefix(input.allowedUnauthenticatedAttributePrefix())
                .allowedUnauthenticatedAttributes(input.allowedUnauthenticatedAttributes())
                .attributeActions(actions)
                .keyring(input.keyring())
                .cmm(input.cmm())
                .build();

        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(input.tableName(), tableConfig);

        // Stubbed to return empty encryptor
        DynamoDbEncryptionInterceptor interceptor = DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
        return interceptor;
    }
}
