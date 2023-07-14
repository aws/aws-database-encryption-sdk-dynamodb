package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.*;
import java.util.stream.Collectors;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

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

    // private static void checkCustomMetadataForUnSupported(Map<String, Object> tableCustomMetadata) {
    //     Map<String, Object> customMetadata = new HashMap<>(tableCustomMetadata);
    //     customMetadata.remove(CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX);
    //     customMetadata.remove(CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX);
    //     if (customMetadata.size() > 0) {
    //         AtomicReference<String> errorMessage = new AtomicReference<>("");
    //         customMetadata.forEach((key, value) ->
    //             errorMessage.updateAndGet(v -> v + String.format("\n\tAnnotation Prefix: %s with value of class %s.", key, value.getClass())));
    //         throw DynamoDbEncryptionException.builder()
    //             .message(String.format("Cannot create a Dynamo DB Encryption Interceptor with Custom Metadata" +
    //                 " other than @DynamoDbEncryptionSignOnly & @DynamoDbEncryptionDoNothing." +
    //                 "Encountered the following Custom Metadata:\n%s", errorMessage.get()))
    //             .build();
    //     }
    // }
    // private static void checkTableSchemaForUnSupported(TableSchema tableSchema) {
    //     Map<String, Object> topTableCustomMetadata = tableSchema.tableMetadata().customMetadata();
    //     tableSchema.tableMetadata().customMetadataObject()
    //     Object topSignOnly = topTableCustomMetadata.get(CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX);
    //     Object topIgnore = topTableCustomMetadata.get(CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX);
    //     checkCustomMetadataForUnSupported(tableSchema.tableMetadata().customMetadata());
    //     List<String> attributeNames = tableSchema.attributeNames();
    //     // Discard the Primary Keys
    //     attributeNames.removeAll(tableSchema.tableMetadata().primaryKeys());
    //     String attributeName = attributeNames.remove(0);
    //     AttributeConverter attributeConverter = tableSchema.converterForAttribute(attributeName);
    //     EnhancedType type = attributeConverter.type();
    //     if (type.tableSchema().isPresent()) {
    //         Object maybeTableSchema = type.tableSchema().get();
    //         if (maybeTableSchema instanceof TableSchema) {
    //             TableSchema subTableSchema = (TableSchema) maybeTableSchema;
    //             subTableSchema.tableMetadata().customMetadata().containsKey(CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX);
    //             subTableSchema.tableMetadata().customMetadata().containsKey(CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX);
    //         }
    //     }
    // }

    private static <T> DynamoDbTableEncryptionConfig getTableConfig(DynamoDbEnhancedTableEncryptionConfig configWithSchema) {
        Map<String, CryptoAction> actions = new HashMap<>();
        Set<String> signOnlyAttributes = configWithSchema.schemaOnEncrypt().tableMetadata().customMetadataObject(CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX, Set.class).orElseGet(HashSet::new);
        Set<String> doNothingAttributes = configWithSchema.schemaOnEncrypt().tableMetadata().customMetadataObject(CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX, Set.class).orElseGet(HashSet::new);
        Set<String> keyAttributes = configWithSchema.schemaOnEncrypt().tableMetadata().keyAttributes().stream().map(val -> val.name()).collect(Collectors.toSet());

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

            AttributeConverter attributeConverter = configWithSchema.schemaOnEncrypt().converterForAttribute(attributeName);
            if (Objects.nonNull(attributeConverter) && Objects.nonNull(attributeConverter.type()) && attributeConverter.type().tableSchema().isPresent()) {
                Object maybeTableSchema = attributeConverter.type().tableSchema().get();
                if (maybeTableSchema instanceof TableSchema) {
                    TableSchema subTableSchema = (TableSchema) maybeTableSchema;
                    if (
                        subTableSchema.tableMetadata().customMetadata().containsKey(CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX) ||
                            subTableSchema.tableMetadata().customMetadata().containsKey(CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX)
                    ) {
                        throw DynamoDbEncryptionException.builder()
                            .message(String.format(
                                "Detected a DynamoDbEncryption configuration on a nested attribute of %s. " +
                                    "This is NOT Supported at this time!",
                                attributeName))
                            .build();
                    }
                }
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
