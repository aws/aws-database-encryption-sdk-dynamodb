package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.invaliddatamodels;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;

@DynamoDbBean
public class InvalidAnnotatedPartitionClass {

  private String id;

  @DynamoDbEncryptionDoNothing
  @DynamoDbPartitionKey
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
