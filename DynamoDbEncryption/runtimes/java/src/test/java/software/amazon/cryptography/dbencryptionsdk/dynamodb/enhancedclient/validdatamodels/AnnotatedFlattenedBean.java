package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.validdatamodels;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbFlatten;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This is a valid use of DynamoDbEncryption annotations on nested attributes.
 * Currently, the ONLY WAY to properly specify DynamoDbEncryption actions
 * on nested attributes is via the @DynamoDbFlatten attribute.<p>
 *
 * Note that you MUST NOT use a DynamoDbEncryption annotation on the
 * Flattened Attribute itself.<p>
 * Only on it's sub-fields.<p>
 */
@DynamoDbBean
public class AnnotatedFlattenedBean {

  private String partitionKey;
  private int sortKey;
  private FlattenedNestedBean nestedBeanClass;

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

  // Any @DynamoDbEncryption annotation here would be IGNORED
  // Instead, the Annotations MUST BE placed on the Getter Methods of
  // FlattenedNestedBean.
  @DynamoDbFlatten
  public FlattenedNestedBean getNestedBeanClass() {
    return this.nestedBeanClass;
  }

  public void setNestedBeanClass(FlattenedNestedBean nestedBeanClass) {
    this.nestedBeanClass = nestedBeanClass;
  }

  @DynamoDbBean
  public static class FlattenedNestedBean {

    private String id;
    private String firstName;
    private String lastName;

    public FlattenedNestedBean() {}

    public FlattenedNestedBean(String id, String firstName, String lastName) {
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

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      FlattenedNestedBean other = (FlattenedNestedBean) obj;
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
}
