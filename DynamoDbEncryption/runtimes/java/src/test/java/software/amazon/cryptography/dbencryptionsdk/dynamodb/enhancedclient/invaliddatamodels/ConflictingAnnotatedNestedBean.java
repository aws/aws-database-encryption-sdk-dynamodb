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
 * Worse yet, the top level annotation conflicts with annotations given in
 * the subfields.<p>
 */
@DynamoDbBean
public class ConflictingAnnotatedNestedBean {

  private String partitionKey;
  private int sortKey;
  private NestedBean nestedEncrypted;
  private NestedBean nestedSigned;
  private NestedBean nestedIgnored;

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

  // By Default, DB-ESDK for DDB will Encrypt & Sign this field
  public NestedBean getNestedEncrypted() {
    return this.nestedEncrypted;
  }

  public void setNestedEncrypted(NestedBean nested) {
    this.nestedEncrypted = nested;
  }

  @DynamoDbEncryptionSignOnly //This annotation is respected
  public NestedBean getNestedSigned() {
    return this.nestedSigned;
  }

  public void setNestedSigned(NestedBean nested) {
    this.nestedSigned = nested;
  }

  @DynamoDbEncryptionDoNothing //This annotation is respected
  public NestedBean getNestedIgnored() {
    return this.nestedIgnored;
  }

  public void setNestedIgnored(NestedBean nestedIgnored) {
    this.nestedIgnored = nestedIgnored;
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

    // Ignored DynamoDb Annotation
    @DynamoDbAttribute("id")
    public String getId() {
      return this.id;
    }

    public void setId(String id) {
      this.id = id;
    }

    // Ignored DynamoDb & DynamoDbEncryption Annotations
    @DynamoDbEncryptionSignOnly
    @DynamoDbAttribute("firstName")
    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    // Ignored DynamoDb & DynamoDbEncryption Annotations
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
