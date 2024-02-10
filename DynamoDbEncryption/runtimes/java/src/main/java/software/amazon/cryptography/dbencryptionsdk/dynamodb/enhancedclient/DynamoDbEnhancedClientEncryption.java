package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import software.amazon.awssdk.enhanced.dynamodb.IndexMetadata;
import software.amazon.awssdk.enhanced.dynamodb.KeyAttributeMetadata;
import software.amazon.awssdk.enhanced.dynamodb.TableMetadata;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;

import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

import static software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DoNothingTag.CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.SignOnlyTag.CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.SignAndIncludeInEncryptionContextTag.CUSTOM_DDB_ENCRYPTION_SIGN_AND_INCLUDE_PREFIX;

public class DynamoDbEnhancedClientEncryption {
    public static DynamoDbEncryptionInterceptor CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput input) {
        Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        input.tableEncryptionConfigs().forEach(
            (name, config) -> tableConfigs.put(name, getTableConfig(config, name)));

        return DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbTablesEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();
    }

    private static Set<String> attributeNamesUsedInIndices(
        final TableMetadata tableMetadata
    ) {
        Set<String> allIndexAttributes = new HashSet<>();
        tableMetadata.indices().stream()
            .map(IndexMetadata::partitionKey)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(KeyAttributeMetadata::name)
            .forEach(allIndexAttributes::add);
        tableMetadata.indices().stream()
            .map(IndexMetadata::sortKey)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(KeyAttributeMetadata::name)
            .forEach(allIndexAttributes::add);
        return allIndexAttributes;
    }

    private static DynamoDbTableEncryptionConfig getTableConfig(
        final DynamoDbEnhancedTableEncryptionConfig configWithSchema,
        final String tableName
    ) {
        Map<String, CryptoAction> actions = new HashMap<>();

        TableSchema<?> topTableSchema = configWithSchema.schemaOnEncrypt();
        Set<String> signOnlyAttributes = getSignOnlyAttributes(topTableSchema);
        Set<String> signAndIncludeAttributes = getSignAndIncludeInEncryptionContextAttributes(topTableSchema);
        Set<String> doNothingAttributes = getDoNothingAttributes(topTableSchema);
        Set<String> keyAttributes = attributeNamesUsedInIndices(topTableSchema.tableMetadata());

        if (!Collections.disjoint(keyAttributes, doNothingAttributes)) {
            throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Cannot use @DynamoDbEncryptionDoNothing on primary key attributes. Found on Table Name: %s",
                        tableName))
                    .build();
        } else if (!Collections.disjoint(signOnlyAttributes, doNothingAttributes)) {
            throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Cannot use @DynamoDbEncryptionDoNothing and @DynamoDbEncryptionSignOnly on same attribute. Found on Table Name: %s",
                        tableName))
                    .build();
        } else if (!Collections.disjoint(signOnlyAttributes, signAndIncludeAttributes)) {
            throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Cannot use @DynamoDbEncryptionSignAndIncludeInEncryptionContext and @DynamoDbEncryptionSignOnly on same attribute. Found on Table Name: %s",
                        tableName))
                    .build();
        } else if (!Collections.disjoint(doNothingAttributes, signAndIncludeAttributes)) {
            throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Cannot use @DynamoDbEncryptionSignAndIncludeInEncryptionContext and @DynamoDbEncryptionDoNothing on same attribute. Found on Table Name: %s",
                        tableName))
                    .build();
        }

        List<String> attributeNames = topTableSchema.attributeNames();
        StringBuilder path = new StringBuilder();
        path.append(tableName).append(".");
        for (String attributeName : attributeNames) {
            if (keyAttributes.contains(attributeName)) {
		if (signAndIncludeAttributes.isEmpty()) {
                    actions.put(attributeName, CryptoAction.SIGN_ONLY);
		} else {
                    actions.put(attributeName, CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
		}
            } else if (signOnlyAttributes.contains(attributeName)) {
                actions.put(attributeName, CryptoAction.SIGN_ONLY);
            } else if (signAndIncludeAttributes.contains(attributeName)) {
                actions.put(attributeName, CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
            } else if (doNothingAttributes.contains(attributeName)) {
                actions.put(attributeName, CryptoAction.DO_NOTHING);
            } else {
                // non-key attributes are ENCRYPT_AND_SIGN unless otherwise annotated
                actions.put(attributeName, CryptoAction.ENCRYPT_AND_SIGN);
            }

            // Detect Encryption Flags that are Ignored b/c they are in a Nested Class
            scanForIgnoredEncryptionTags(topTableSchema, attributeName, path);
        }

        DynamoDbTableEncryptionConfig.Builder builder = DynamoDbTableEncryptionConfig.builder();
        String partitionName = topTableSchema.tableMetadata().primaryPartitionKey();
        builder = builder.partitionKeyName(partitionName);

        Optional<String> sortName = topTableSchema.tableMetadata().primarySortKey();
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

    @SuppressWarnings("unchecked")
    private static Set<String> getSignOnlyAttributes(TableSchema<?> tableSchema) {
        return tableSchema.tableMetadata()
            .customMetadataObject(CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX, Set.class)
            .orElseGet(HashSet::new);
    }

    @SuppressWarnings("unchecked")
    private static Set<String> getSignAndIncludeInEncryptionContextAttributes(TableSchema<?> tableSchema) {
        return tableSchema.tableMetadata()
            .customMetadataObject(CUSTOM_DDB_ENCRYPTION_SIGN_AND_INCLUDE_PREFIX, Set.class)
            .orElseGet(HashSet::new);
    }

    @SuppressWarnings("unchecked")
    private static Set<String> getDoNothingAttributes(TableSchema<?> tableSchema) {
        return tableSchema.tableMetadata()
            .customMetadataObject(CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX, Set.class)
            .orElseGet(HashSet::new);
    }

    /**
     * Detects DynamoDB Encryption Tags in Nested Enhanced Types.<p>
     * DynamoDB Encryption Tags in Nested Classes are IGNORED by the
     * Database Encryption SDK for DynamoDB.<p>
     * As such, Detection of a nested DynamoDB Encryption Tag on a Nested Type
     * triggers a Runtime Exception that MUST NOT BE ignored.<p>
     * CAVEAT: Encryption Tags on fields of Nested Classes that are
     * Flattened onto the top record are Respected.<p>
     * The behavior of Flatten pushes the Attributes onto the top level record,
     * making the "flattened sub-fields" equivalent to any other DynamoDB Attribute.<p>
     * However, there still exists a possibility for IGNORED Encryption Tags,
     * as any Encryption Tag on the field that will be "flattened" is ignored.<p>
     * This method DOES NOT detect these "ignored-by-flattened" tags.
     */
    private static void scanForIgnoredEncryptionTags(
        final TableSchema<?> tableSchema,
        final String attributeName,
        final StringBuilder path
    ) {
        AttributeConverter<?> attributeConverter = tableSchema.converterForAttribute(attributeName);
        StringBuilder attributePath = new StringBuilder(path).append(attributeName).append(".");
        if (
            Objects.nonNull(attributeConverter) &&
                Objects.nonNull(attributeConverter.type()) &&
                attributeConverter.type().tableSchema().isPresent()
        ) {
            TableSchema<?> subTableSchema = attributeConverter.type().tableSchema().get();
            Set<String> signOnlyAttributes = getSignOnlyAttributes(subTableSchema);
            if (signOnlyAttributes.size() > 0) {
                throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Detected DynamoDbEncryption Tag %s on a nested attribute with Path %s. " +
                            "This is NOT Supported at this time!",
                        CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX,
                        attributePath.append(signOnlyAttributes.toArray()[0])))
                    .build();
            }
            Set<String> signAndIncludeAttributes = getSignAndIncludeInEncryptionContextAttributes(subTableSchema);
            if (signAndIncludeAttributes.size() > 0) {
                throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Detected DynamoDbEncryption Tag %s on a nested attribute with Path %s. " +
                            "This is NOT Supported at this time!",
                        CUSTOM_DDB_ENCRYPTION_SIGN_AND_INCLUDE_PREFIX,
                        attributePath.append(signAndIncludeAttributes.toArray()[0])))
                    .build();
            }
            Set<String> doNothingAttributes = getDoNothingAttributes(subTableSchema);
            if (doNothingAttributes.size() > 0) {
                throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Detected DynamoDbEncryption Tag %s on a nested attribute with Path %s. " +
                            "This is NOT Supported at this time!",
                        CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX,
                        attributePath.append(doNothingAttributes.toArray()[0])))
                    .build();
            }
            List<String> subAttributeNames = subTableSchema.attributeNames();
            for (String subAttributeName : subAttributeNames) {
                scanForIgnoredEncryptionTags(subTableSchema, subAttributeName, attributePath);
            }
        }
    }
}
