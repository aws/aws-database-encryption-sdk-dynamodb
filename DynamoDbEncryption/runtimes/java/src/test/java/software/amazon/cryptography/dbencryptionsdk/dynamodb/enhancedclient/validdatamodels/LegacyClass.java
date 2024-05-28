package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.validdatamodels;

import static software.amazon.cryptography.dbencryptionsdk.dynamodb.TestUtils.TEST_TABLE_NAME;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DoNotEncrypt;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DoNotTouch;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This class is used by the Enhanced Client Tests
 */

@DynamoDbBean
@DynamoDBTable(tableName = TEST_TABLE_NAME)
public class LegacyClass {

  private String partitionKey;
  private int sortKey;
  private String encryptAndSign;
  private String doNothing;
  private String signOnly;

  @DynamoDbPartitionKey
  @DynamoDbAttribute(value = "partition_key")
  @DynamoDBHashKey(attributeName = "partition_key")
  public String getPartitionKey() {
    return this.partitionKey;
  }

  public void setPartitionKey(String partitionKey) {
    this.partitionKey = partitionKey;
  }

  @DynamoDbSortKey
  @DynamoDbAttribute(value = "sort_key")
  @DynamoDBRangeKey(attributeName = "sort_key")
  public int getSortKey() {
    return this.sortKey;
  }

  public void setSortKey(int sortKey) {
    this.sortKey = sortKey;
  }

  @DynamoDBAttribute
  public String getEncryptAndSign() {
    return this.encryptAndSign;
  }

  public void setEncryptAndSign(String encryptAndSign) {
    this.encryptAndSign = encryptAndSign;
  }

  @DynamoDBAttribute
  @DoNotEncrypt
  @DynamoDbEncryptionSignOnly
  public String getSignOnly() {
    return this.signOnly;
  }

  public void setSignOnly(String signOnly) {
    this.signOnly = signOnly;
  }

  @DynamoDBAttribute
  @DoNotTouch
  @DynamoDbEncryptionDoNothing
  public String getDoNothing() {
    return this.doNothing;
  }

  public void setDoNothing(String doNothing) {
    this.doNothing = doNothing;
  }
}
