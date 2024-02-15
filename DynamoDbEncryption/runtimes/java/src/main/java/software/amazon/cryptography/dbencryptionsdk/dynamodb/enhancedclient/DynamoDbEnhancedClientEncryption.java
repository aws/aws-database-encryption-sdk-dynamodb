package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
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

    private static Set<String> attributeNamesUsedInPrimaryKey(
        final TableMetadata tableMetadata
    ) {
        Set<String> keyAttributes = new HashSet<>();
        tableMetadata.keyAttributes().stream()
            .map(KeyAttributeMetadata::name)
            .forEach(keyAttributes::add);
        return keyAttributes;
    }

    private static void UsageError(String tableName, String attributeName, String usage, String usage2)
    {
        throw DynamoDbEncryptionException.builder()
            .message(String.format(
                "Attribute %s of table %s is used as both %s and %s.",
                attributeName, tableName, usage, usage2))
            .build();

    }
    private static void EnsureNot(
        String tableName,
        String attributeName,
        String usage,
        Optional<Set<String>> signOnly,
        Optional<Set<String>> signAndInclude,
        Optional<Set<String>> doNothing
    )
    {
        if (signOnly.isPresent()) {
            if (signOnly.get().contains(attributeName)) {
                UsageError(tableName, attributeName, usage, "@DynamoDbEncryptionSignOnly");
            }
        }
        if (signAndInclude.isPresent()) {
            if (signAndInclude.get().contains(attributeName)) {
                UsageError(tableName, attributeName, usage, "@DynamoDbEncryptionSignAndIncludeInEncryptionContext");
            }
        }
        if (doNothing.isPresent()) {
            if (doNothing.get().contains(attributeName)) {
                UsageError(tableName, attributeName, usage, "@DynamoDbEncryptionDoNothing");
            }
        }
    }

    private static Map<String, CryptoAction> GetActionsFromSchema(String tableName, TableSchema<?> topTableSchema)
    {
        Set<String> signOnlyAttributes = getSignOnlyAttributes(topTableSchema);
        Set<String> signAndIncludeAttributes = getSignAndIncludeInEncryptionContextAttributes(topTableSchema);
        Set<String> doNothingAttributes = getDoNothingAttributes(topTableSchema);
        Set<String> keyAttributes = attributeNamesUsedInIndices(topTableSchema.tableMetadata());
        Set<String> tableKeys = attributeNamesUsedInPrimaryKey(topTableSchema.tableMetadata());
        List<String> attributeNames = topTableSchema.attributeNames();

        Map<String, CryptoAction> actions = new HashMap<>();
        StringBuilder path = new StringBuilder();
        path.append(tableName).append(".");
        for (String attributeName : attributeNames) {
            if (tableKeys.contains(attributeName)) {
                if (signAndIncludeAttributes.isEmpty()) {
                    EnsureNot(tableName, attributeName, "a primary key", Optional.empty(), Optional.of(signAndIncludeAttributes), Optional.of(doNothingAttributes));
                    actions.put(attributeName, CryptoAction.SIGN_ONLY);
                } else {
                    EnsureNot(tableName, attributeName, "a primary key", Optional.of(signOnlyAttributes), Optional.empty(), Optional.of(doNothingAttributes));
                    actions.put(attributeName, CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
                }
            } else if (keyAttributes.contains(attributeName)) {
                EnsureNot(tableName, attributeName, "an index key", Optional.empty(), Optional.of(signAndIncludeAttributes), Optional.of(doNothingAttributes));
                actions.put(attributeName, CryptoAction.SIGN_ONLY);
            } else if (signOnlyAttributes.contains(attributeName)) {
                EnsureNot(tableName, attributeName, "@DynamoDbEncryptionSignOnly", Optional.empty(), Optional.of(signAndIncludeAttributes), Optional.of(doNothingAttributes));
                actions.put(attributeName, CryptoAction.SIGN_ONLY);
            } else if (signAndIncludeAttributes.contains(attributeName)) {
                EnsureNot(tableName, attributeName, "@DynamoDbEncryptionSignAndIncludeInEncryptionContext", Optional.of(signOnlyAttributes), Optional.empty(), Optional.of(doNothingAttributes));
                actions.put(attributeName, CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
            } else if (doNothingAttributes.contains(attributeName)) {
                EnsureNot(tableName, attributeName, "@DynamoDbEncryptionDoNothing", Optional.of(signOnlyAttributes), Optional.of(signAndIncludeAttributes), Optional.empty());
                actions.put(attributeName, CryptoAction.DO_NOTHING);
            } else {
                // non-key attributes are ENCRYPT_AND_SIGN unless otherwise annotated
                actions.put(attributeName, CryptoAction.ENCRYPT_AND_SIGN);
            }

            // Detect Encryption Flags that are Ignored b/c they are in a Nested Class
            scanForIgnoredEncryptionTags(topTableSchema, attributeName, path);
        }
        return actions;
    }

    // given action maps from multiple tables, merge them into one
    private static Map<String, CryptoAction> MergeActions(List<Map<String, CryptoAction>> actionList)
    {
        // most common case
        if (actionList.size() == 1) {
            return actionList.get(0);
        }

        // Gather set of all attributes
        HashSet<String> attributes = new HashSet<>();
        for (Map<String, CryptoAction> config : actionList) {
            attributes.addAll(config.keySet());
        }

        // for each attribute, ensure that everyone agrees on its action
        Map<String, CryptoAction> actions = new HashMap<>();
        for (String attr : attributes) {
            Optional<CryptoAction> action = Optional.empty();
            for (Map<String, CryptoAction> config : actionList) {
                CryptoAction act = config.get(attr);
                if (act != null) {
                    if (action.isPresent()) {
                        if (!action.get().equals(act)) {
                            throw DynamoDbEncryptionException.builder()
                                .message(String.format(
                                    "Attribute %s set to %s in one table and %s in another.",
                                    attr, action.get(), act))
                                .build();
                        }
                    } else {
                        action = Optional.of(act);
                    }
                }
            }
            actions.put(attr, action.get());
        }
        return actions;
    }

    private static String GetPartitionKeyName(List<TableSchema<?>> schemas)
    {
        String partitionName = schemas.get(0).tableMetadata().primaryPartitionKey();
        for (TableSchema<?> schema : schemas) {
            String part = schema.tableMetadata().primaryPartitionKey();
            if (!partitionName.equals(part)) {
                throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Primary Key set to %s in one table and %s in another.",
                        partitionName, part))
                    .build();
            }
        }
        return partitionName;
    }

    private static Optional<String> GetSortKeyName(List<TableSchema<?>> schemas)
    {
        Optional<String> sortName = schemas.get(0).tableMetadata().primarySortKey();
        for (TableSchema<?> schema : schemas) {
            Optional<String> sort = schema.tableMetadata().primarySortKey();
            if (!sortName.equals(sort)) {
                throw DynamoDbEncryptionException.builder()
                    .message(String.format(
                        "Primary Key set to %s in one table and %s in another.",
                        sortName, sort))
                    .build();
            }
        }
        return sortName;
    }

    private static DynamoDbTableEncryptionConfig getTableConfig(
        final DynamoDbEnhancedTableEncryptionConfig configWithSchema,
        final String tableName
    ) {
        List<Map<String, CryptoAction>> actionList = new ArrayList<>();
        for (TableSchema<?> schema : configWithSchema.schemaOnEncrypt()) { 
            actionList.add(GetActionsFromSchema(tableName, schema));
        }
        Map<String, CryptoAction> actions = MergeActions(actionList);

        DynamoDbTableEncryptionConfig.Builder builder = DynamoDbTableEncryptionConfig.builder();
        String partitionName = GetPartitionKeyName(configWithSchema.schemaOnEncrypt());
        builder = builder.partitionKeyName(partitionName);

        Optional<String> sortName = GetSortKeyName(configWithSchema.schemaOnEncrypt());
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
