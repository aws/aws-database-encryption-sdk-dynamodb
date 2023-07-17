package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.*;
import java.util.stream.Collectors;

import software.amazon.awssdk.enhanced.dynamodb.IndexMetadata;
import software.amazon.awssdk.enhanced.dynamodb.KeyAttributeMetadata;
import software.amazon.awssdk.enhanced.dynamodb.TableMetadata;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;

import static software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DoNothingTag.CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.SignOnlyTag.CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX;

public class DynamoDbEnhancedClientEncryption {
    public static DynamoDbEncryptionInterceptor CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput input) {
        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        for (String tableName : input.tableEncryptionConfigs().keySet()) {
            tableConfigs.put(tableName, getTableConfig(input.tableEncryptionConfigs().get(tableName)));
        }

        return DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbTablesEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
    }

    private static Set<String> attributeNamesUsedInIndices(
        final TableMetadata tableMetadata
    ) {
        Set<String> partitionAttributeNames = tableMetadata.indices().stream()
            .map(IndexMetadata::partitionKey)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(KeyAttributeMetadata::name)
            .collect(Collectors.toSet());
        Set<String> sortAttributeNames = tableMetadata.indices().stream()
            .map(IndexMetadata::sortKey)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(KeyAttributeMetadata::name)
            .collect(Collectors.toSet());
        Set<String> allIndexAttributes = new HashSet<>();
        allIndexAttributes.addAll(partitionAttributeNames);
        allIndexAttributes.addAll(sortAttributeNames);
        return allIndexAttributes;
    }

    private static DynamoDbTableEncryptionConfig getTableConfig(DynamoDbEnhancedTableEncryptionConfig configWithSchema) {
        Map<String, CryptoAction> actions = new HashMap<>();

        Set<String> signOnlyAttributes = configWithSchema.schemaOnEncrypt().tableMetadata().customMetadataObject(CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX, Set.class).orElseGet(HashSet::new);
        Set<String> doNothingAttributes = configWithSchema.schemaOnEncrypt().tableMetadata().customMetadataObject(CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX, Set.class).orElseGet(HashSet::new);
        Set<String> keyAttributes = attributeNamesUsedInIndices(configWithSchema.schemaOnEncrypt().tableMetadata());

        if (!Collections.disjoint(keyAttributes, doNothingAttributes)) {
            throw DynamoDbEncryptionException.builder()
                    .message("Cannot use @DynamoDbEncryptionDoNothing on primary key attributes.")
                    .build();
        } else if (!Collections.disjoint(signOnlyAttributes, doNothingAttributes)) {
            throw DynamoDbEncryptionException.builder()
                    .message("Cannot use @DynamoDbEncryptionDoNothing and @DynamoDbEncryptionSignOnly on same attribute.")
                    .build();
        }

        List<String> attributeNames = configWithSchema.schemaOnEncrypt().attributeNames();
        for (String attributeName : attributeNames) {
            if (keyAttributes.contains(attributeName)) {
                // key attributes are always SIGN_ONLY
                actions.put(attributeName, CryptoAction.SIGN_ONLY);
            } else if (signOnlyAttributes.contains(attributeName)) {
                actions.put(attributeName, CryptoAction.SIGN_ONLY);
            } else if (doNothingAttributes.contains(attributeName)) {
                actions.put(attributeName, CryptoAction.DO_NOTHING);
            } else {
                // non-key attributes are ENCRYPT_AND_SIGN unless otherwise annotated
                actions.put(attributeName, CryptoAction.ENCRYPT_AND_SIGN);
            }
        }

        DynamoDbTableEncryptionConfig.Builder builder = DynamoDbTableEncryptionConfig.builder();
        String partitionName = configWithSchema.schemaOnEncrypt().tableMetadata().primaryPartitionKey();
        builder = builder.partitionKeyName(partitionName);

        Optional<String> sortName = configWithSchema.schemaOnEncrypt().tableMetadata().primarySortKey();
        if (sortName.isPresent()) {
            builder = builder.sortKeyName(sortName.get());
        }

        if (!Objects.isNull(configWithSchema.keyring())) {
            builder = builder.keyring(configWithSchema.keyring());
        }

        if (!Objects.isNull(configWithSchema.cmm())) {
            builder = builder.cmm(configWithSchema.cmm());
        }

        if (!Objects.isNull(configWithSchema.logicalTableName())) {
            builder = builder.logicalTableName(configWithSchema.logicalTableName());
        }

        if (!Objects.isNull(configWithSchema.plaintextOverride())) {
            builder = builder.plaintextOverride(configWithSchema.plaintextOverride());
        }

        return builder.allowedUnsignedAttributePrefix(configWithSchema.allowedUnsignedAttributePrefix())
                .allowedUnsignedAttributes(configWithSchema.allowedUnsignedAttributes())
                .attributeActionsOnEncrypt(actions)
                .legacyOverride(configWithSchema.legacyOverride())
                .build();
    }
}
