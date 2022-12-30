package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.TableMetadata;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTag;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticTableMetadata;

public class SignOnlyTag implements StaticAttributeTag {
    @Override
    public Consumer<StaticTableMetadata.Builder> modifyMetadata(String attributeName, AttributeValueType attributeValueType) {
        // Stubbed to do nothing
        return metadata -> {};
    }
}
