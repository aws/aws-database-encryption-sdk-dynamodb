package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class InvalidAnnotatedConvertedBy {
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

    @DynamoDbConvertedBy(NestedBean.NestedBeanConverter.class)
    public NestedBean getNestedBeanClass() {
        return this.nestedBeanClass;
    }

    public void setNestedBeanClass(NestedBean nestedBeanClass) {
        this.nestedBeanClass = nestedBeanClass;
    }
}
