package software.amazon.cryptography.examples.migration.awsdbe;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This class is used by the Migration Examples with DynamoDB Enhanced Client.
 */
@DynamoDbBean
public class SimpleClass {

  private String partitionKey;
  private int sortKey;
  private String attribute1;
  private String attribute2;
  private String attribute3;

  @DynamoDbPartitionKey
  @DynamoDbAttribute(value = "partition_key")
  public String getPartitionKey() {
    return this.partitionKey;
  }

  public void setPartitionKey(String partitionKey) {
    this.partitionKey = partitionKey;
  }

  @DynamoDbSortKey
  @DynamoDbAttribute(value = "sort_key")
  public int getSortKey() {
    return this.sortKey;
  }

  public void setSortKey(int sortKey) {
    this.sortKey = sortKey;
  }

  @DynamoDbAttribute(value = "attribute1")
  public String getAttribute1() {
    return this.attribute1;
  }

  public void setAttribute1(String attribute1) {
    this.attribute1 = attribute1;
  }

  @DynamoDbEncryptionSignOnly
  @DynamoDbAttribute(value = "attribute2")
  public String getAttribute2() {
    return this.attribute2;
  }

  public void setAttribute2(String attribute2) {
    this.attribute2 = attribute2;
  }

  @DynamoDbEncryptionDoNothing
  @DynamoDbAttribute(value = "attribute3")
  public String getAttribute3() {
    return this.attribute3;
  }

  public void setAttribute3(String attribute3) {
    this.attribute3 = attribute3;
  }
}
