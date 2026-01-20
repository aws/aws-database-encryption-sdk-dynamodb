package software.amazon.cryptography.examples.migration.ddbec;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DoNotEncrypt;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DoNotTouch;

/**
 * This class is used by the Migration Examples
 */

@DynamoDBTable(tableName = "my-ddb-table")
public class SimpleClass {

  private String partitionKey;
  private int sortKey;
  private String attribute1;
  private String attribute2;
  private String attribute3;

  @DynamoDBHashKey(attributeName = "partition_key")
  public String getPartitionKey() {
    return this.partitionKey;
  }

  public void setPartitionKey(String partitionKey) {
    this.partitionKey = partitionKey;
  }

  @DynamoDBRangeKey(attributeName = "sort_key")
  public int getSortKey() {
    return this.sortKey;
  }

  public void setSortKey(int sortKey) {
    this.sortKey = sortKey;
  }

  @DynamoDBAttribute(attributeName = "attribute1")
  public String getAttribute1() {
    return this.attribute1;
  }

  public void setAttribute1(String attribute1) {
    this.attribute1 = attribute1;
  }

  @DoNotEncrypt
  @DynamoDBAttribute(attributeName = "attribute2")
  public String getAttribute2() {
    return this.attribute2;
  }

  public void setAttribute2(String attribute2) {
    this.attribute2 = attribute2;
  }

  @DoNotTouch
  @DynamoDBAttribute(attributeName = "attribute3")
  public String getAttribute3() {
    return this.attribute3;
  }

  public void setAttribute3(String attribute3) {
    this.attribute3 = attribute3;
  }
}
