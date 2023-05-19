package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class InvalidAnnotatedSortClass {

    private String id;
    private String sortKey;

    @DynamoDbPartitionKey
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbEncryptionDoNothing
    @DynamoDbSortKey
    public String getSortKey() {
        return this.sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }
}
