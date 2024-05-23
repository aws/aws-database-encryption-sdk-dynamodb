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
public class SingleTable2 {

  private String partitionKey;
  private int sortKey;
  private String encryptAndSign;
  private String doNothing;
  private String signOnly;

  private String extraSignOnly2;
  private String extraSignOnly12;
  private String extraSignOnly23;
  private String extraSignAndInclude2;
  private String extraSignAndInclude12;
  private String extraSignAndInclude23;
  private String extraDoNothing2;
  private String extraDoNothing12;
  private String extraDoNothing23;
  private String extraEncryptAndSign2;
  private String extraEncryptAndSign12;
  private String extraEncryptAndSign23;

  public String getExtraEncryptAndSign2() {
    return this.extraEncryptAndSign2;
  }

  public String getExtraEncryptAndSign12() {
    return this.extraEncryptAndSign12;
  }

  public String getExtraEncryptAndSign23() {
    return this.extraEncryptAndSign23;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing2() {
    return this.extraDoNothing2;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing12() {
    return this.extraDoNothing12;
  }

  @DynamoDbEncryptionDoNothing
  public String getExtraDoNothing23() {
    return this.extraDoNothing23;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly2() {
    return this.extraSignOnly2;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly12() {
    return this.extraSignOnly12;
  }

  @DynamoDbEncryptionSignOnly
  public String getExtraSignOnly23() {
    return this.extraSignOnly23;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude2() {
    return this.extraSignAndInclude2;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude12() {
    return this.extraSignAndInclude12;
  }

  @DynamoDbEncryptionSignAndIncludeInEncryptionContext
  public String getExtraSignAndInclude23() {
    return this.extraSignAndInclude23;
  }

  public void setExtraDoNothing2(String text) {
    this.extraDoNothing2 = text;
  }

  public void setExtraDoNothing12(String text) {
    this.extraDoNothing12 = text;
  }

  public void setExtraDoNothing23(String text) {
    this.extraDoNothing23 = text;
  }

  public void setExtraSignOnly2(String text) {
    this.extraSignOnly2 = text;
  }

  public void setExtraSignOnly12(String text) {
    this.extraSignOnly12 = text;
  }

  public void setExtraSignOnly23(String text) {
    this.extraSignOnly23 = text;
  }

  public void setExtraSignAndInclude2(String text) {
    this.extraSignAndInclude2 = text;
  }

  public void setExtraSignAndInclude12(String text) {
    this.extraSignAndInclude12 = text;
  }

  public void setExtraSignAndInclude23(String text) {
    this.extraSignAndInclude23 = text;
  }

  public void setExtraEncryptAndSign2(String text) {
    this.extraEncryptAndSign2 = text;
  }

  public void setExtraEncryptAndSign12(String text) {
    this.extraEncryptAndSign12 = text;
  }

  public void setExtraEncryptAndSign23(String text) {
    this.extraEncryptAndSign23 = text;
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
