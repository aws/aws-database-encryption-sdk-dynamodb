package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.validdatamodels;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignAndIncludeInEncryptionContext;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This class is used by the Enhanced Client Tests
 */

@DynamoDbBean
public class SingleTable3 {

  private String partitionKey;
  private int sortKey;
  private String encryptAndSign;
  private String doNothing;
  private String signOnly;

  private String extraSignOnly3;
  private String extraSignOnly23;
  private String extraSignOnly13;
  private String extraSignAndInclude3;
  private String extraSignAndInclude23;
  private String extraSignAndInclude13;
  private String extraDoNothing3;
  private String extraDoNothing23;
  private String extraDoNothing13;
  private String extraEncryptAndSign3;
  private String extraEncryptAndSign23;
  private String extraEncryptAndSign13;

  public String getExtraEncryptAndSign3() {
    return this.extraEncryptAndSign3;
  }

  public String getExtraEncryptAndSign23() {
    return this.extraEncryptAndSign23;
  }

  public String getExtraEncryptAndSign13() {
    return this.extraEncryptAndSign13;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing3() {
    return this.extraDoNothing3;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing23() {
    return this.extraDoNothing23;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing13() {
    return this.extraDoNothing13;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly3() {
    return this.extraSignOnly3;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly23() {
    return this.extraSignOnly23;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly13() {
    return this.extraSignOnly13;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude3() {
    return this.extraSignAndInclude3;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude23() {
    return this.extraSignAndInclude23;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude13() {
    return this.extraSignAndInclude13;
  }

  public void setExtraDoNothing3(String text) {
    this.extraDoNothing3 = text;
  }

  public void setExtraDoNothing23(String text) {
    this.extraDoNothing23 = text;
  }

  public void setExtraDoNothing13(String text) {
    this.extraDoNothing13 = text;
  }

  public void setExtraSignOnly3(String text) {
    this.extraSignOnly3 = text;
  }

  public void setExtraSignOnly23(String text) {
    this.extraSignOnly23 = text;
  }

  public void setExtraSignOnly13(String text) {
    this.extraSignOnly13 = text;
  }

  public void setExtraSignAndInclude3(String text) {
    this.extraSignAndInclude3 = text;
  }

  public void setExtraSignAndInclude23(String text) {
    this.extraSignAndInclude23 = text;
  }

  public void setExtraSignAndInclude13(String text) {
    this.extraSignAndInclude13 = text;
  }

  public void setExtraEncryptAndSign3(String text) {
    this.extraEncryptAndSign3 = text;
  }

  public void setExtraEncryptAndSign23(String text) {
    this.extraEncryptAndSign23 = text;
  }

  public void setExtraEncryptAndSign13(String text) {
    this.extraEncryptAndSign13 = text;
  }

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

  public String getEncryptAndSign() {
    return this.encryptAndSign;
  }

  public void setEncryptAndSign(String encryptAndSign) {
    this.encryptAndSign = encryptAndSign;
  }

  @DynamoDbEncryptionSignOnly
  public String getSignOnly() {
    return this.signOnly;
  }

  public void setSignOnly(String signOnly) {
    this.signOnly = signOnly;
  }

  @DynamoDbEncryptionDoNothing
  public String getDoNothing() {
    return this.doNothing;
  }

  public void setDoNothing(String doNothing) {
    this.doNothing = doNothing;
  }
}
