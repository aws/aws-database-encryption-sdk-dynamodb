package software.amazon.cryptography.examples.plaintext;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

/**
 * This class is used by the Migration Examples
 */

@DynamoDbBean
public class SimpleClass {

    private String partitionKey;
    private int sortKey;
    // The next three fields represent plaintext attributes in our unencrypted table.
    // Their variable names indicate the encryption operation we will perform
    // when we migrate the table to an encrypted table, but these operations
    // have not been performed for any attributes in this Plaintext example.

    // encryptAndSign: Encrypt the data and sign it for authenticity
    private String encryptAndSign;
    // doNothing: Do not encrypt and do not sign
    private String doNothing;
    // signOnly: Do not encrypt but sign for authenticity
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

    @DynamoDbAttribute(value="encrypt_and_sign")
    public String getEncryptAndSign() {
        return this.encryptAndSign;
    }

    public void setEncryptAndSign(String encryptAndSign) {
        this.encryptAndSign = encryptAndSign;
    }

    @DynamoDbAttribute(value="sign_only")
    public String getSignOnly() {
        return this.signOnly;
    }

    public void setSignOnly(String signOnly) {
        this.signOnly = signOnly;
    }

    @DynamoDbAttribute(value="do_nothing")
    public String getDoNothing() {
        return this.doNothing;
    }

    public void setDoNothing(String doNothing) {
        this.doNothing = doNothing;
    }
}

