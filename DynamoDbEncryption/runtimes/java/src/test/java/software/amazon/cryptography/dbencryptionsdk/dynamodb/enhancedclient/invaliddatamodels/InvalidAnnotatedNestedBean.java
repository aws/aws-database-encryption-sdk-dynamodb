package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.invaliddatamodels;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This is an INVALID use of DynamoDbEncryption annotations on nested attributes.
 * The DynamoDbEncryption annotations are placed on elements that are NOT
 * DynamoDB Attributes but that will be mapped together into one DynamoDB
 * Attribute that is a Map.<p>
 */
@DynamoDbBean
public class InvalidAnnotatedNestedBean {

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

  public NestedBean getNestedBeanClass() {
    return this.nestedBeanClass;
  }

  public void setNestedBeanClass(NestedBean nestedBeanClass) {
    this.nestedBeanClass = nestedBeanClass;
  }

  @DynamoDbBean
  public static class NestedBean {

    private String id;
    private String firstName;
    private String lastName;

    public NestedBean() {}

    NestedBean(String id, String firstName, String lastName) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
    }

    @DynamoDbAttribute("id") //This annotation is IGNORED
    public String getId() {
      return this.id;
    }

    public void setId(String id) {
      this.id = id;
    }

    @DynamoDbEncryptionSignOnly //This annotation is IGNORED
    @DynamoDbAttribute("firstName") //This annotation is IGNORED
    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    @DynamoDbEncryptionDoNothing //This annotation is IGNORED
    @DynamoDbAttribute("lastName") //This annotation is IGNORED
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
}
