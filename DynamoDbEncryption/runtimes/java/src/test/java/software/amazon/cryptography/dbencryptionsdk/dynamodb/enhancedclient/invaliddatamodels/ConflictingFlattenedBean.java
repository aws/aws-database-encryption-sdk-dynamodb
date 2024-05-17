package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.invaliddatamodels;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbFlatten;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This is an INVALID use of DynamoDbEncryption annotations on top level attributes.
 * The DynamoDbEncryption annotations are placed on elements that are NOT
 * DynamoDB Attributes but that will be replaced by the flattened class.<p>
 *
 * Worse yet, the top level annotation conflicts with annotations given in
 * the subfields.<p>
 */
@DynamoDbBean
public class ConflictingFlattenedBean {

  private String partitionKey;
  private int sortKey;
  private NestedBean nestedEncrypted;
  private AnotherNestedBean nestedSigned;
  private FinalNestedBean nestedIgnored;

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
  public NestedBean getNestedEncrypted() {
    return this.nestedEncrypted;
  }

  public void setNestedEncrypted(NestedBean nested) {
    this.nestedEncrypted = nested;
  }

  @DynamoDbFlatten
  @DynamoDbEncryptionSignOnly //This annotation is IGNORED
  public AnotherNestedBean getNestedSigned() {
    return this.nestedSigned;
  }

  public void setNestedSigned(AnotherNestedBean nested) {
    this.nestedSigned = nested;
  }

  @DynamoDbFlatten
  @DynamoDbEncryptionDoNothing //This annotation is IGNORED
  public FinalNestedBean getNestedIgnored() {
    return this.nestedIgnored;
  }

  public void setNestedIgnored(FinalNestedBean nestedIgnored) {
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

    // By Default, DB-ESDK for DDB will Encrypt & Sign this field
    public String getId() {
      return this.id;
    }

    public void setId(String id) {
      this.id = id;
    }

    @DynamoDbEncryptionSignOnly //This annotation is respected
    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    @DynamoDbEncryptionDoNothing //This annotation is respected
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

  @DynamoDbBean
  public static class AnotherNestedBean {

    private String anotherId;
    private String anotherFirstName;
    private String anotherLastName;

    public AnotherNestedBean() {}

    AnotherNestedBean(String id, String firstName, String lastName) {
      this.anotherId = id;
      this.anotherFirstName = firstName;
      this.anotherLastName = lastName;
    }

    // By Default, DB-ESDK for DDB will Encrypt & Sign this field
    public String getAnotherId() {
      return this.anotherId;
    }

    public void setAnotherId(String anotherId) {
      this.anotherId = anotherId;
    }

    @DynamoDbEncryptionSignOnly //This annotation is respected
    public String getAnotherFirstName() {
      return anotherFirstName;
    }

    public void setAnotherFirstName(String anotherFirstName) {
      this.anotherFirstName = anotherFirstName;
    }

    @DynamoDbEncryptionDoNothing //This annotation is respected
    public String getAnotherLastName() {
      return anotherLastName;
    }

    public void setAnotherLastName(String anotherLastName) {
      this.anotherLastName = anotherLastName;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      AnotherNestedBean other = (AnotherNestedBean) obj;
      if (anotherId == null) {
        if (other.getAnotherId() != null) return false;
      } else if (!anotherId.equals(other.getAnotherId())) return false;
      if (anotherFirstName == null) {
        if (other.getAnotherFirstName() != null) return false;
      } else if (
        !anotherFirstName.equals(other.getAnotherFirstName())
      ) return false;
      if (anotherLastName == null) {
        if (other.getAnotherLastName() != null) return false;
      } else if (
        !anotherLastName.equals(other.getAnotherLastName())
      ) return false;
      return true;
    }
  }

  @DynamoDbBean
  public static class FinalNestedBean {

    private String finalId;
    private String finalFirstName;
    private String finalLastName;

    public FinalNestedBean() {}

    FinalNestedBean(String id, String firstName, String lastName) {
      this.finalId = id;
      this.finalFirstName = firstName;
      this.finalLastName = lastName;
    }

    // By Default, DB-ESDK for DDB will Encrypt & Sign this field
    public String getFinalId() {
      return this.finalId;
    }

    public void setFinalId(String finalId) {
      this.finalId = finalId;
    }

    @DynamoDbEncryptionSignOnly //This annotation is respected
    public String getFinalFirstName() {
      return finalFirstName;
    }

    public void setFinalFirstName(String finalFirstName) {
      this.finalFirstName = finalFirstName;
    }

    @DynamoDbEncryptionDoNothing //This annotation is respected
    public String getFinalLastName() {
      return finalLastName;
    }

    public void setFinalLastName(String finalLastName) {
      this.finalLastName = finalLastName;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      FinalNestedBean other = (FinalNestedBean) obj;
      if (finalId == null) {
        if (other.getFinalId() != null) return false;
      } else if (!finalId.equals(other.getFinalId())) return false;
      if (finalFirstName == null) {
        if (other.getFinalFirstName() != null) return false;
      } else if (
        !finalFirstName.equals(other.getFinalFirstName())
      ) return false;
      if (finalLastName == null) {
        if (other.getFinalLastName() != null) return false;
      } else if (!finalLastName.equals(other.getFinalLastName())) return false;
      return true;
    }
  }
}
