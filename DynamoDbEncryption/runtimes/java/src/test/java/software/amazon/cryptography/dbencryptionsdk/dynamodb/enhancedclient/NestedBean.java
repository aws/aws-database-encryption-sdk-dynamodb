package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverterProvider;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@DynamoDbBean
public class NestedBean {
    private String id;
    private String firstName;
    private String lastName;

    public NestedBean() {};

    NestedBean(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @DynamoDbAttribute("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbEncryptionSignOnly
    @DynamoDbAttribute("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDbEncryptionDoNothing
    @DynamoDbAttribute("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static final class NestedBeanConverter implements AttributeConverter<NestedBean> {
        @Override
        public AttributeValue transformFrom(NestedBean nestedBean) {
            Map<String, AttributeValue> map = new HashMap<>(3);
            map.put("id", AttributeValue.fromS(nestedBean.getId()));
            map.put("firstName", AttributeValue.fromS(nestedBean.getFirstName()));
            map.put("lastName", AttributeValue.fromS(nestedBean.getLastName()));
            return AttributeValue.fromM(map);
        }

        @Override
        public NestedBean transformTo(AttributeValue attributeValue) {
            Map<String, AttributeValue> map = attributeValue.m();
            return new NestedBean(
                map.get("id").s(),
                map.get("cookieName").s(),
                map.get("cookieValue").s());
        }

        @Override
        public EnhancedType<NestedBean> type() {
            return EnhancedType.of(NestedBean.class);
        }

        @Override
        public AttributeValueType attributeValueType() {
            return AttributeValueType.M;
        }
    }

    public static final class NestedBeanConverterProvider implements AttributeConverterProvider {
        private static final Map<EnhancedType<?>, AttributeConverter<?>> converterCache;
        static {
            converterCache = new HashMap<>(1);
            converterCache.put(EnhancedType.of(NestedBean.class), new NestedBeanConverter());
        }

        public static NestedBeanConverterProvider create() {
            return new NestedBeanConverterProvider();
        }

        // The SDK calls this method to find out if the provider contains a AttributeConverter instance
        // for the EnhancedType<T> argument.
        @SuppressWarnings("unchecked")
        @Override
        public <T> AttributeConverter<T> converterFor(EnhancedType<T> enhancedType) {
            return (AttributeConverter<T>) converterCache.get(enhancedType);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        NestedBean other = (NestedBean) obj;
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
}
