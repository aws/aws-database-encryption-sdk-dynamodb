package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbItemEncryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import java.util.*;
import java.util.stream.Collectors;

import static software.aws.cryptography.dynamoDbEncryption.enhancedclient.DoNothingTag.CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX;
import static software.aws.cryptography.dynamoDbEncryption.enhancedclient.SignOnlyTag.CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX;

public class DynamoDbEnhancedClientEncryptionHelpers {
    public static DynamoDbEncryptionInterceptor CreateDynamoDbEncryptionInterceptorWithTableSchema(
            CreateDynamoDbEncryptionInterceptorWithTableSchemaInput input) {
        DynamoDbTableEncryptionConfig.Builder builder = DynamoDbTableEncryptionConfig.builder();
        Map<String, CryptoAction> actions = new HashMap<>();

        Set<String> signOnlyAttributes = input.tableSchema().tableMetadata().customMetadataObject(CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX, Set.class).orElseGet(HashSet::new);
        Set<String> doNothingAttributes = input.tableSchema().tableMetadata().customMetadataObject(CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX, Set.class).orElseGet(HashSet::new);
        Set<String> keyAttributes = input.tableSchema().tableMetadata().keyAttributes().stream().map(val -> val.name()).collect(Collectors.toSet());

        List<String> attributeNames = input.tableSchema().attributeNames();
        for (String attributeName : attributeNames) {
            if (keyAttributes.contains(attributeName)) {
                // key attributes are always SIGN_ONLY
                if (doNothingAttributes.contains(attributeName)) {
                    throw DynamoDbEncryptionException.builder()
                            .message("Cannot use @DynamoDbEncryptionDoNothing on primary key attributes.")
                            .build();
                }
                actions.put(attributeName, CryptoAction.SIGN_ONLY);
            } if (signOnlyAttributes.contains(attributeName)) {
                actions.put(attributeName, CryptoAction.SIGN_ONLY);
            } else if (doNothingAttributes.contains(attributeName)) {
                actions.put(attributeName, CryptoAction.DO_NOTHING);
            } else {
                // non-key attributes are ENCRYPT_AND_SIGN unless otherwise annotated
                actions.put(attributeName, CryptoAction.ENCRYPT_AND_SIGN);
            }
        }

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
