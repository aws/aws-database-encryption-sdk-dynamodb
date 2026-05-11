package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.Collections;
import java.util.function.Consumer;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTag;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticTableMetadata;

public class DoNothingTag implements StaticAttributeTag {

  public static final String CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX =
    "DynamoDbEncryption:DoNothing";

  @Override
  public Consumer<StaticTableMetadata.Builder> modifyMetadata(
    String attributeName,
    AttributeValueType attributeValueType
  ) {
    return metadata ->
      metadata.addCustomMetadataObject(
        CUSTOM_DDB_ENCRYPTION_DO_NOTHING_PREFIX,
        Collections.singleton(attributeName)
      );
  }
}
