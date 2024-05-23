package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.validdatamodels;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbIgnoreNulls;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionDoNothing;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEncryptionSignOnly;

/**
 * This class is used by the Enhanced Client Tests
 */

@DynamoDbBean
public class AllTypesClass {

  private String partitionKey;
  private int sortKey;

  // One attribute for every DDB attribute type and ENCRYPT_AND_SIGN/SIGN_ONLY pair
  private String encryptString;
  private String signString;
  private Double encryptNum;
  private Double signNum;
  private ByteBuffer encryptBinary;
  private ByteBuffer signBinary;
  private Boolean encryptBool;
  private Boolean signBool;
  private String encryptExpectedNull; // This should always be null, define no setters
  private String signExpectedNull; // This should always be null, define no setters
  private List<String> encryptList;
  private List<String> signList;
  private Map<String, Integer> encryptMap;
  private Map<String, Integer> signMap;
  private Set<String> encryptStringSet;
  private Set<String> signStringSet;
  private Set<Integer> encryptNumSet;
  private Set<Integer> signNumSet;
  private Set<ByteBuffer> encryptBinarySet;
  private Set<ByteBuffer> signBinarySet;

  // And one doNothing for good measure
  private String doNothing;

  @DynamoDbPartitionKey
  @DynamoDbAttribute(value = "partition_key")
  public String getPartitionKey() {
    return this.partitionKey;
  }

  @DynamoDbSortKey
  @DynamoDbAttribute(value = "sort_key")
  public int getSortKey() {
    return this.sortKey;
  }

  @DynamoDbIgnoreNulls
  public String getEncryptString() {
    return this.encryptString;
  }

  @DynamoDbEncryptionSignOnly
  @DynamoDbIgnoreNulls
  public String getSignString() {
    return this.signString;
  }

  @DynamoDbIgnoreNulls
  public Double getEncryptNum() {
    return encryptNum;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionSignOnly
  public Double getSignNum() {
    return signNum;
  }

  @DynamoDbIgnoreNulls
  public ByteBuffer getEncryptBinary() {
    return encryptBinary;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionSignOnly
  public ByteBuffer getSignBinary() {
    return signBinary;
  }

  @DynamoDbIgnoreNulls
  public Boolean getEncryptBool() {
    return encryptBool;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionSignOnly
  public Boolean getSignBool() {
    return signBool;
  }

  // This should always return null
  public String getEncryptExpectedNull() {
    return encryptExpectedNull;
  }

  // This should always return null
  @DynamoDbEncryptionSignOnly
  public String getSignExpectedNull() {
    return signExpectedNull;
  }

  @DynamoDbIgnoreNulls
  public List<String> getEncryptList() {
    return encryptList;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionSignOnly
  public List<String> getSignList() {
    return signList;
  }

  @DynamoDbIgnoreNulls
  public Map<String, Integer> getEncryptMap() {
    return encryptMap;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionSignOnly
  public Map<String, Integer> getSignMap() {
    return signMap;
  }

  @DynamoDbIgnoreNulls
  public Set<String> getEncryptStringSet() {
    return encryptStringSet;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionSignOnly
  public Set<String> getSignStringSet() {
    return signStringSet;
  }

  @DynamoDbIgnoreNulls
  public Set<Integer> getEncryptNumSet() {
    return encryptNumSet;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionSignOnly
  public Set<Integer> getSignNumSet() {
    return signNumSet;
  }

  @DynamoDbIgnoreNulls
  public Set<ByteBuffer> getEncryptBinarySet() {
    return encryptBinarySet;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionSignOnly
  public Set<ByteBuffer> getSignBinarySet() {
    return signBinarySet;
  }

  @DynamoDbIgnoreNulls
  @DynamoDbEncryptionDoNothing
  public String getDoNothing() {
    return this.doNothing;
  }

  public void setPartitionKey(String partitionKey) {
    this.partitionKey = partitionKey;
  }

  public void setSortKey(int sortKey) {
    this.sortKey = sortKey;
  }

  public void setEncryptString(String encryptString) {
    this.encryptString = encryptString;
  }

  public void setSignString(String signString) {
    this.signString = signString;
  }

  public void setEncryptNum(Double encryptNum) {
    this.encryptNum = encryptNum;
  }

  public void setSignNum(Double signNum) {
    this.signNum = signNum;
  }

  public void setEncryptBinary(ByteBuffer encryptBinary) {
    this.encryptBinary = encryptBinary;
  }

  public void setSignBinary(ByteBuffer signBinary) {
    this.signBinary = signBinary;
  }

  public void setEncryptBool(Boolean encryptBool) {
    this.encryptBool = encryptBool;
  }

  public void setSignBool(Boolean signBool) {
    this.signBool = signBool;
  }

  public void setEncryptList(List<String> encryptList) {
    this.encryptList = encryptList;
  }

  public void setSignList(List<String> signList) {
    this.signList = signList;
  }

  public void setEncryptMap(Map<String, Integer> encryptMap) {
    this.encryptMap = encryptMap;
  }

  public void setSignMap(Map<String, Integer> signMap) {
    this.signMap = signMap;
  }

  public void setEncryptStringSet(Set<String> encryptStringSet) {
    this.encryptStringSet = encryptStringSet;
  }

  public void setSignStringSet(Set<String> signStringSet) {
    this.signStringSet = signStringSet;
  }

  public void setEncryptNumSet(Set<Integer> encryptNumSet) {
    this.encryptNumSet = encryptNumSet;
  }

  public void setSignNumSet(Set<Integer> signNumSet) {
    this.signNumSet = signNumSet;
  }

  public void setEncryptBinarySet(Set<ByteBuffer> encryptBinarySet) {
    this.encryptBinarySet = encryptBinarySet;
  }

  public void setSignBinarySet(Set<ByteBuffer> signBinarySet) {
    this.signBinarySet = signBinarySet;
  }

  public void setDoNothing(String doNothing) {
    this.doNothing = doNothing;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (obj.getClass() != this.getClass()) {
      return false;
    }

    final AllTypesClass other = (AllTypesClass) obj;

    if (!(Objects.equals(other.getPartitionKey(), this.partitionKey))) {
      return false;
    }
    if (other.getSortKey() != this.sortKey) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptString(), this.encryptString))) {
      return false;
    }
    if (!(Objects.equals(other.getSignString(), this.signString))) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptNum(), this.encryptNum))) {
      return false;
    }
    if (!(Objects.equals(other.getSignNum(), this.signNum))) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptBinary(), this.encryptBinary))) {
      return false;
    }
    if (!(Objects.equals(other.getSignBinary(), this.signBinary))) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptBool(), this.encryptBool))) {
      return false;
    }
    if (!(Objects.equals(other.getSignBool(), this.signBool))) {
      return false;
    }
    if (other.getEncryptExpectedNull() != null) {
      return false;
    }
    if (other.getSignExpectedNull() != null) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptList(), this.encryptList))) {
      return false;
    }
    if (!(Objects.equals(other.getSignList(), this.signList))) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptMap(), this.encryptMap))) {
      return false;
    }
    if (!(Objects.equals(other.getSignMap(), this.signMap))) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptStringSet(), this.encryptStringSet))) {
      return false;
    }
    if (!(Objects.equals(other.getSignStringSet(), this.signStringSet))) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptNumSet(), this.encryptNumSet))) {
      return false;
    }
    if (!(Objects.equals(other.getSignNumSet(), this.signNumSet))) {
      return false;
    }
    if (!(Objects.equals(other.getEncryptBinarySet(), this.encryptBinarySet))) {
      return false;
    }
    if (!(Objects.equals(other.getSignBinarySet(), this.signBinarySet))) {
      return false;
    }
    if (!(Objects.equals(other.getDoNothing(), this.doNothing))) {
      return false;
    }

    return true;
  }

  public static AllTypesClass createTestItem(
    String partitionValue,
    int sortValue
  ) {
    AllTypesClass testItem = new AllTypesClass();
    testItem.setPartitionKey(partitionValue);
    testItem.setSortKey(sortValue);
    testItem.setEncryptString("encryptString");
    testItem.setSignString("signString");
    testItem.setEncryptNum(111.111);
    testItem.setSignNum(999.999);
    testItem.setEncryptBinary(StandardCharsets.UTF_8.encode("encryptBinary"));
    testItem.setSignBinary(StandardCharsets.UTF_8.encode("sortBinary"));
    testItem.setEncryptBool(true);
    testItem.setSignBool(false);
    testItem.setEncryptList(Arrays.asList("encrypt1", "encrypt2", "encrypt3"));
    testItem.setSignList(Arrays.asList("sort1", "sort2", "sort3"));
    testItem.setEncryptMap(Collections.singletonMap("encryptMap", 1));
    testItem.setSignMap(Collections.singletonMap("sortMap", 2));
    testItem.setEncryptStringSet(
      new HashSet<>(Arrays.asList("encrypt1", "encrypt2", "encrypt3"))
    );
    testItem.setSignStringSet(
      new HashSet<>(Arrays.asList("sort1", "sort2", "sort3"))
    );
    testItem.setEncryptNumSet(new HashSet<>(Arrays.asList(1, 2, 3)));
    testItem.setSignNumSet(new HashSet<>(Arrays.asList(4, 5, 6)));
    testItem.setEncryptBinarySet(
      new HashSet<>(
        Arrays.asList(
          StandardCharsets.UTF_8.encode("encrypt1"),
          StandardCharsets.UTF_8.encode("encrypt2"),
          StandardCharsets.UTF_8.encode("encrypt3")
        )
      )
    );
    testItem.setSignBinarySet(
      new HashSet<>(
        Arrays.asList(
          StandardCharsets.UTF_8.encode("sort1"),
          StandardCharsets.UTF_8.encode("sort2"),
          StandardCharsets.UTF_8.encode("sort3")
        )
      )
    );
    testItem.setDoNothing("doNothing");
    return testItem;
  }
}
