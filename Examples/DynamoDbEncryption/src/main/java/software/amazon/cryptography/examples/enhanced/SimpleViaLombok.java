package software.amazon.cryptography.examples.enhanced;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbImmutable;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

@Value
@Builder
@DynamoDbImmutable(builder = SimpleViaLombok.SimpleViaLombokBuilder.class)
public class SimpleViaLombok {

  @Getter(
    onMethod_ = {
      @DynamoDbPartitionKey, @DynamoDbAttribute(value = "partition_key"),
    }
  )
  String partitionKey;

  @Getter(
    onMethod_ = { @DynamoDbSortKey, @DynamoDbAttribute(value = "sort_key") }
  )
  int sortKey;

  String attribute1;

  @Getter(onMethod_ = @DynamoDbEncryptionSignOnly)
  String attribute2;

  @Getter(
    onMethod_ = {
      @DynamoDbEncryptionDoNothing, @DynamoDbAttribute(value = ":attribute3"),
    }
  )
  String attribute3;
}
