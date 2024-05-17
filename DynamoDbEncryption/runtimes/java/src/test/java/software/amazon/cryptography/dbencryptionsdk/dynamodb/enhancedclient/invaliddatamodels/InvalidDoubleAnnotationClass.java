package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.invaliddatamodels;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This class is used by the Enhanced Client Tests
 */

@DynamoDbBean
public class InvalidDoubleAnnotationClass {

  private String id;
  private String sortKey;
  private String invalid;

  @DynamoDbPartitionKey
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @DynamoDbSortKey
  public String getSortKey() {
    return this.sortKey;
  }

  public void setSortKey(String sortKey) {
    this.sortKey = sortKey;
  }

  @DynamoDbEncryptionSignOnly
  @DynamoDbEncryptionDoNothing
  public String getInvalid() {
    return this.invalid;
  }

  public void setInvalid(String invalid) {
    this.invalid = invalid;
  }
}
