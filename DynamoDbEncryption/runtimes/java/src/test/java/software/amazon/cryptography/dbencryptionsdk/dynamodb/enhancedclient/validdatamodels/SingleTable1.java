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
public class SingleTable1 {

  private String partitionKey;
  private int sortKey;
  private String encryptAndSign;
  private String doNothing;
  private String signOnly;

  private String extraSignOnly1;
  private String extraSignOnly12;
  private String extraSignOnly13;
  private String extraSignAndInclude1;
  private String extraSignAndInclude12;
  private String extraSignAndInclude13;
  private String extraDoNothing1;
  private String extraDoNothing12;
  private String extraDoNothing13;
  private String extraEncryptAndSign1;
  private String extraEncryptAndSign12;
  private String extraEncryptAndSign13;

  public String getExtraEncryptAndSign1() {
    return this.extraEncryptAndSign1;
  }

  public String getExtraEncryptAndSign12() {
    return this.extraEncryptAndSign12;
  }

  public String getExtraEncryptAndSign13() {
    return this.extraEncryptAndSign13;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing1() {
    return this.extraDoNothing1;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing12() {
    return this.extraDoNothing12;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing13() {
    return this.extraDoNothing13;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly1() {
    return this.extraSignOnly1;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly12() {
    return this.extraSignOnly12;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly13() {
    return this.extraSignOnly13;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude1() {
    return this.extraSignAndInclude1;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude12() {
    return this.extraSignAndInclude12;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude13() {
    return this.extraSignAndInclude13;
  }

  public void setExtraDoNothing1(String text) {
    this.extraDoNothing1 = text;
  }

  public void setExtraDoNothing12(String text) {
    this.extraDoNothing12 = text;
  }

  public void setExtraDoNothing13(String text) {
    this.extraDoNothing13 = text;
  }

  public void setExtraSignOnly1(String text) {
    this.extraSignOnly1 = text;
  }

  public void setExtraSignOnly12(String text) {
    this.extraSignOnly12 = text;
  }

  public void setExtraSignOnly13(String text) {
    this.extraSignOnly13 = text;
  }

  public void setExtraSignAndInclude1(String text) {
    this.extraSignAndInclude1 = text;
  }

  public void setExtraSignAndInclude12(String text) {
    this.extraSignAndInclude12 = text;
  }

  public void setExtraSignAndInclude13(String text) {
    this.extraSignAndInclude13 = text;
  }

  public void setExtraEncryptAndSign1(String text) {
    this.extraEncryptAndSign1 = text;
  }

  public void setExtraEncryptAndSign12(String text) {
    this.extraEncryptAndSign12 = text;
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
