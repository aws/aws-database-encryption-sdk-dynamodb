package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbFlatten;

@DynamoDbBean
public class InvalidAnnotatedFlattenedBean {
    private String partitionKey;
    private int sortKey;
    private NestedBean nestedBeanClass;

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

    @DynamoDbFlatten
    public NestedBean getNestedBeanClass() {
        return this.nestedBeanClass;
    }

    public void setNestedBeanClass(NestedBean nestedBeanClass) {
        this.nestedBeanClass = nestedBeanClass;
    }
}
