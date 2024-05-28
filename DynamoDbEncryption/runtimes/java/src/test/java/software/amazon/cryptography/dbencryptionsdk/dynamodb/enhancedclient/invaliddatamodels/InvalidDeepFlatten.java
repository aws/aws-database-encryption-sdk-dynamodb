package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.invaliddatamodels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbFlatten;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

@NoArgsConstructor
@DynamoDbBean
public class InvalidDeepFlatten {

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
    @Getter(onMethod_ = { @DynamoDbFlatten })
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
