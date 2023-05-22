package software.amazon.cryptography.examples.migration;

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
    private String encryptAndSign;
    private String doNothing;
    private String signOnly;

    @DynamoDBHashKey(attributeName="partition_key")
    public String getPartitionKey() {
        return this.partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    @DynamoDBRangeKey(attributeName="sort_key")
    public int getSortKey() {
        return this.sortKey;
    }

    public void setSortKey(int sortKey) {
        this.sortKey = sortKey;
    }

    @DynamoDBAttribute(attributeName="encrypt_and_sign")
    public String getEncryptAndSign() {
        return this.encryptAndSign;
    }

    public void setEncryptAndSign(String encryptAndSign) {
        this.encryptAndSign = encryptAndSign;
    }

    @DoNotEncrypt
    @DynamoDBAttribute(attributeName="sign_only")
    public String getSignOnly() {
        return this.signOnly;
    }

    public void setSignOnly(String signOnly) {
        this.signOnly = signOnly;
    }

    @DoNotTouch
    @DynamoDBAttribute(attributeName="do_nothing")
    public String getDoNothing() {
        return this.doNothing;
    }

    public void setDoNothing(String doNothing) {
        this.doNothing = doNothing;
    }
}

