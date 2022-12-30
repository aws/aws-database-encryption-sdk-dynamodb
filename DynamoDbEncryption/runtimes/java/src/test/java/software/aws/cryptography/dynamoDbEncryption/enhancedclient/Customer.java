package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class Customer {

    private String id;
    private String email;

    @DynamoDbPartitionKey
    public String getId() {
        return this.id;
    }

    public void setId(String id) {

        this.id = id;
    }

    @DynamoDbSortKey
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
