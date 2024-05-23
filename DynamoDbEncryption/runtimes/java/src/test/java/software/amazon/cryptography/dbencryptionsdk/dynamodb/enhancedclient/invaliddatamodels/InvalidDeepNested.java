package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.invaliddatamodels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This is an INVALID use of DynamoDbEncryption annotations on nested attributes.
 * The DynamoDbEncryption annotations are placed on elements that are NOT
 * DynamoDB Attributes but that will be mapped together into one DynamoDB
 * Attribute that is a Map.<p>
 */
@NoArgsConstructor
@DynamoDbBean
public class InvalidDeepNested {

  @Setter
  @Getter(
    onMethod_ = {
      @DynamoDbPartitionKey, @DynamoDbAttribute(value = "partition_key"),
    }
  )
  String partitionKey;

  @Setter
  @Getter(
    onMethod_ = { @DynamoDbSortKey, @DynamoDbAttribute(value = "sort_key") }
  )
  int sortKey;

  @Setter
  @Getter(onMethod_ = { @DynamoDbAttribute(value = "nestedObject") })
  FirstNest firstNest;

  @NoArgsConstructor
  @DynamoDbBean
  public static class FirstNest {

    @Setter
    @Getter
    String firstNestId;

    @Setter
    @Getter
    SecondNest secondNest;
  }

  @NoArgsConstructor
  @DynamoDbBean
  public static class SecondNest {

    @Setter
    @Getter(onMethod_ = @DynamoDbEncryptionSignOnly)
    String secondNestedId;
  }
}
