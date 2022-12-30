package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

/**
 * This class is used by the Enhanced Client Tests
 */

@DynamoDbBean
public class SimpleClass {

    private String id;
    private String sortKey;
    private String encryptAndSign;
    private String doNothing;
    private String signOnly;

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
