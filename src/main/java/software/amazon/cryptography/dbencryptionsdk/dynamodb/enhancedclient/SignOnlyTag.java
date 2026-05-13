package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTag;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticTableMetadata;

public class SignOnlyTag implements StaticAttributeTag {

  public static final String CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX =
    "DynamoDbEncryption:SortOnly";

  @Override
  public Consumer<StaticTableMetadata.Builder> modifyMetadata(
    String attributeName,
    AttributeValueType attributeValueType
  ) {
    return metadata ->
      metadata.addCustomMetadataObject(
        CUSTOM_DDB_ENCRYPTION_SIGN_ONLY_PREFIX,
        Collections.singleton(attributeName)
      );
  }
}
