package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * This is an INVALID use of DynamoDbEncryption annotations on nested attributes.
 * The DynamoDbEncryption annotations are placed on elements that are NOT
 * DynamoDB Attributes but that will be mapped together into one attribute.<p>
 */
@DynamoDbBean
public class InvalidAnnotatedConvertedBy {
    private String partitionKey;
    private int sortKey;
    private ConvertedByNestedBean nestedBeanClass;

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

    @DynamoDbConvertedBy(ConvertedByNestedBean.NestedBeanConverter.class)
    @DynamoDbAttribute("nestedEncrypted")
    public ConvertedByNestedBean getNestedBeanClass() {
        return this.nestedBeanClass;
    }

    public void setNestedBeanClass(ConvertedByNestedBean nestedBeanClass) {
        this.nestedBeanClass = nestedBeanClass;
    }

    public static class ConvertedByNestedBean {
        private String id;
        private String firstName;
        private String lastName;

        public ConvertedByNestedBean() {};

        public ConvertedByNestedBean(String id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getId() { return this.id; }
        public void setId(String id) { this.id = id; }

        @DynamoDbEncryptionSignOnly //This annotation is IGNORED
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        @DynamoDbEncryptionDoNothing //This annotation is IGNORED
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            ConvertedByNestedBean other = (ConvertedByNestedBean) obj;
            if (id == null) {
                if (other.getId() != null) return false;
            } else if (!id.equals(other.getId())) return false;
            if (firstName == null) {
                if (other.getFirstName() != null) return false;
            } else if (!firstName.equals(other.getFirstName())) return false;
            if (lastName == null) {
                if (other.getLastName() != null) return false;
            } else if (!lastName.equals(other.getLastName())) return false;
            return true;
        }

        public static final class NestedBeanConverter implements AttributeConverter<ConvertedByNestedBean> {
            @Override
            public AttributeValue transformFrom(ConvertedByNestedBean ConvertedByNestedBean) {
                Map<String, AttributeValue> map = new HashMap<>(3);
                map.put("id", AttributeValue.fromS(ConvertedByNestedBean.getId()));
                map.put("firstName", AttributeValue.fromS(ConvertedByNestedBean.getFirstName()));
                map.put("lastName", AttributeValue.fromS(ConvertedByNestedBean.getLastName()));
                return AttributeValue.fromM(map);
            }

            @Override
            public ConvertedByNestedBean transformTo(AttributeValue attributeValue) {
                Map<String, AttributeValue> map = attributeValue.m();
                return new ConvertedByNestedBean(
                    map.get("id").s(),
                    map.get("firstName").s(),
                    map.get("lastName").s());
            }

            @Override
            public EnhancedType<ConvertedByNestedBean> type() {
                return EnhancedType.of(ConvertedByNestedBean.class);
            }

            @Override
            public AttributeValueType attributeValueType() {
                return AttributeValueType.M;
            }
        }
    }
}
