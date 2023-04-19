package software.aws.cryptography.examples.migration;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.aws.cryptography.dynamoDbEncryption.enhancedclient.DynamoDbEncryptionDoNothing;
import software.aws.cryptography.dynamoDbEncryption.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This class is used by the Enhanced Client Tests
 */

@DynamoDbBean
public class SimpleClass {

    private String partitionKey;
    private int sortKey;
    private String encryptAndSign;
    private String doNothing;
    private String signOnly;

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

    @DynamoDbAttribute(value = "encrypt_and_sign")
    public String getEncryptAndSign() {
        return this.encryptAndSign;
    }

    public void setEncryptAndSign(String encryptAndSign) {
        this.encryptAndSign = encryptAndSign;
    }

    @DynamoDbEncryptionSignOnly
    @DynamoDbAttribute(value = "sign_only")
    public String getSignOnly() {
        return this.signOnly;
    }

    public void setSignOnly(String signOnly) {
        this.signOnly = signOnly;
    }

    @DynamoDbEncryptionDoNothing
    @DynamoDbAttribute(value = "do_nothing")
    public String getDoNothing() {
        return this.doNothing;
    }

    public void setDoNothing(String doNothing) {
        this.doNothing = doNothing;
    }
}

