package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.validdatamodels;

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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This is a valid use of DynamoDbEncryption annotations attributes with
 * DynamoDbConvertedBy.<p>
 * The DynamoDbEncryption annotations are placed on elements that are converted
 * to Maps.<p>
 * In this case, only {@code nestedEncrypted} will be written to the DynamoDB Table as a
 * binary. {@code nestedSigned} and {@code nestedIgnored} are recorded as DynamoDB Maps.
 */
@DynamoDbBean
public class AnnotatedConvertedBy {

  private String partitionKey;
  private int sortKey;
  private ConvertedByNestedBean nestedEncrypted;
  private ConvertedByNestedBean nestedSigned;
  private ConvertedByNestedBean nestedIgnored;

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
  public ConvertedByNestedBean getNestedEncrypted() {
    return this.nestedEncrypted;
  }

  public void setNestedEncrypted(ConvertedByNestedBean nested) {
    this.nestedEncrypted = nested;
  }

  @DynamoDbConvertedBy(ConvertedByNestedBean.NestedBeanConverter.class)
  @DynamoDbEncryptionSignOnly
  @DynamoDbAttribute("nestedSigned")
  public ConvertedByNestedBean getNestedSigned() {
    return this.nestedSigned;
  }

  public void setNestedSigned(ConvertedByNestedBean nested) {
    this.nestedSigned = nested;
  }

  @DynamoDbConvertedBy(ConvertedByNestedBean.NestedBeanConverter.class)
  @DynamoDbEncryptionDoNothing
  @DynamoDbAttribute("nestedIgnored")
  public ConvertedByNestedBean getNestedIgnored() {
    return this.nestedIgnored;
  }

  public void setNestedIgnored(ConvertedByNestedBean nested) {
    this.nestedIgnored = nested;
  }

  public static class ConvertedByNestedBean {

    private String id;
    private String firstName;
    private String lastName;

    // A Default Empty constructor is needed by the Enhanced Client
    public ConvertedByNestedBean() {}

    public ConvertedByNestedBean(String id, String firstName, String lastName) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public String getId() {
      return this.id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

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

    public static final class NestedBeanConverter
      implements AttributeConverter<ConvertedByNestedBean> {

      @Override
      public AttributeValue transformFrom(
        ConvertedByNestedBean ConvertedByNestedBean
      ) {
        Map<String, AttributeValue> map = new HashMap<>(3);
        map.put("id", AttributeValue.fromS(ConvertedByNestedBean.getId()));
        map.put(
          "firstName",
          AttributeValue.fromS(ConvertedByNestedBean.getFirstName())
        );
        map.put(
          "lastName",
          AttributeValue.fromS(ConvertedByNestedBean.getLastName())
        );
        return AttributeValue.fromM(map);
      }

      @Override
      public ConvertedByNestedBean transformTo(AttributeValue attributeValue) {
        Map<String, AttributeValue> map = attributeValue.m();
        return new ConvertedByNestedBean(
          map.get("id").s(),
          map.get("firstName").s(),
          map.get("lastName").s()
        );
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
