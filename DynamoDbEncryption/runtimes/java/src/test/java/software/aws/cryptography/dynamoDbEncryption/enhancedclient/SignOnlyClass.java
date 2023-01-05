package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class SignOnlyClass {

    private String id;
    private String attr1;
    private String attr2;

    @DynamoDbPartitionKey
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setAttr2(String attr12) {
        this.attr2 = attr2;
    }
}
