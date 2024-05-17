package software.amazon.cryptography.examples;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;

public class ConfigUtils {

  public static DynamoDbItemEncryptorConfig fromEncryptionInterceptor(
    final DynamoDbEncryptionInterceptor encryptionInterceptor,
    final String tableName
  ) {
    DynamoDbTableEncryptionConfig tableEncryptionConfig = encryptionInterceptor
      .config()
      .tableEncryptionConfigs()
      .get(tableName);
    DynamoDbItemEncryptorConfig.Builder builder =
      DynamoDbItemEncryptorConfig.builder();
    builder.logicalTableName(tableEncryptionConfig.logicalTableName());
    builder.partitionKeyName(tableEncryptionConfig.partitionKeyName());
    builder.attributeActionsOnEncrypt(
      tableEncryptionConfig.attributeActionsOnEncrypt()
    );
    builder.algorithmSuiteId(tableEncryptionConfig.algorithmSuiteId());
    if (
      Objects.nonNull(tableEncryptionConfig.sortKeyName())
    ) builder.sortKeyName(tableEncryptionConfig.sortKeyName());
    if (
      Objects.nonNull(tableEncryptionConfig.allowedUnsignedAttributes())
    ) builder.allowedUnsignedAttributes(
      tableEncryptionConfig.allowedUnsignedAttributes()
    );
    if (
      Objects.nonNull(tableEncryptionConfig.allowedUnsignedAttributePrefix())
    ) builder.allowedUnsignedAttributePrefix(
      tableEncryptionConfig.allowedUnsignedAttributePrefix()
    );
    if (Objects.nonNull(tableEncryptionConfig.keyring())) builder.keyring(
      tableEncryptionConfig.keyring()
    );
    if (Objects.nonNull(tableEncryptionConfig.cmm())) builder.cmm(
      tableEncryptionConfig.cmm()
    );
    if (
      Objects.nonNull(tableEncryptionConfig.legacyOverride())
    ) builder.legacyOverride(tableEncryptionConfig.legacyOverride());
    if (
      Objects.nonNull(tableEncryptionConfig.plaintextOverride())
    ) builder.plaintextOverride(tableEncryptionConfig.plaintextOverride());
    return builder.build();
  }
}
