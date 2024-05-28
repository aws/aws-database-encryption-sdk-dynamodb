package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.validdatamodels;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

@DynamoDbBean
public class SignOnlyClass {

  private String partitionKey;
  private int sortKey;
  private String attr1;
  private String attr2;

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

  @DynamoDbEncryptionSignOnly
  public String getAttr1() {
    return this.attr1;
  }

  public void setAttr1(String attr1) {
    this.attr1 = attr1;
  }

  @DynamoDbEncryptionSignOnly
  public String getAttr2() {
    return this.attr2;
  }

  public void setAttr2(String attr2) {
    this.attr2 = attr2;
  }
}
