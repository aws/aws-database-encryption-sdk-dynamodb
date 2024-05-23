package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import static org.testng.Assert.*;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.TestUtils.*;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.IDynamoDbKeyBranchKeyIdSupplier;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.*;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.materialproviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.model.*;

public class HierarchicalKeyringBranchKeyIdSupplierTests {

  @Test
  public void TestHierarchyKeyringWithSupplier() {
    // Create client with keyring that uses branch key supplier for key A and key B
    KeyStore keystore = createKeyStore();
    DynamoDbEncryption ddbEnc = DynamoDbEncryption
      .builder()
      .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
      .build();
    IBranchKeyIdSupplier branchKeyIdSupplier = ddbEnc
      .CreateDynamoDbEncryptionBranchKeyIdSupplier(
        CreateDynamoDbEncryptionBranchKeyIdSupplierInput
          .builder()
          .ddbKeyBranchKeyIdSupplier(new TestSupplier())
          .build()
      )
      .branchKeyIdSupplier();
    IKeyring keyring = createHierarchicalKeyring(keystore, branchKeyIdSupplier);
    assertNotNull(keyring);
    DynamoDbEncryptionInterceptor interceptor = TestUtils.createInterceptor(
      keyring,
      null,
      null
    );
    DynamoDbClient ddbAB = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();

    // Create client with keyring only configured with key A
    IKeyring keyringA = createHierarchicalKeyring(keystore, BRANCH_KEY_ID);
    assertNotNull(keyringA);
    DynamoDbEncryptionInterceptor interceptorA = TestUtils.createInterceptor(
      keyringA,
      null,
      null
    );
    DynamoDbClient ddbA = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptorA)
          .build()
      )
      .build();

    // Put CaseA item into table with Hierarchy keyring with supplier
    // Put item into table
    String partitionValue = "caseA";
    String sortValue = "42";
    String attrValue = "bar";
    String attrValue2 = "hello world";
    Map<String, AttributeValue> item = createTestItem(
      partitionValue,
      sortValue,
      attrValue,
      attrValue2
    );

    PutItemRequest putRequestA = PutItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .item(item)
      .build();

    PutItemResponse putResponseA = ddbAB.putItem(putRequestA);
    assertEquals(200, putResponseA.sdkHttpResponse().statusCode());

    // Get Item back from table
    Map<String, AttributeValue> keyToGetA = createTestKey(
      partitionValue,
      sortValue
    );
    GetItemRequest getRequestA = GetItemRequest
      .builder()
      .key(keyToGetA)
      .tableName(TEST_TABLE_NAME)
      .build();

    GetItemResponse getResponseA = ddbAB.getItem(getRequestA);
    assertEquals(200, getResponseA.sdkHttpResponse().statusCode());
    Map<String, AttributeValue> returnedItemA = getResponseA.item();
    assertNotNull(returnedItemA);
    assertEquals(partitionValue, returnedItemA.get(TEST_PARTITION_NAME).s());
    assertEquals(sortValue, returnedItemA.get(TEST_SORT_NAME).n());
    assertEquals(attrValue, returnedItemA.get(TEST_ATTR_NAME).s());

    // Assert we can retrieve this item with a Hierarchical keyring configured only with key A
    getResponseA = ddbA.getItem(getRequestA);
    assertEquals(200, getResponseA.sdkHttpResponse().statusCode());
    returnedItemA = getResponseA.item();
    assertNotNull(returnedItemA);
    assertEquals(partitionValue, returnedItemA.get(TEST_PARTITION_NAME).s());
    assertEquals(sortValue, returnedItemA.get(TEST_SORT_NAME).n());
    assertEquals(attrValue, returnedItemA.get(TEST_ATTR_NAME).s());

    // Put CaseB item
    // Put item into table
    partitionValue = "caseB";
    sortValue = "42";
    attrValue = "bar";
    attrValue2 = "hello world";
    Map<String, AttributeValue> itemB = createTestItem(
      partitionValue,
      sortValue,
      attrValue,
      attrValue2
    );

    PutItemRequest putRequest2 = PutItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .item(itemB)
      .build();

    PutItemResponse putResponse2 = ddbAB.putItem(putRequest2);
    assertEquals(200, putResponse2.sdkHttpResponse().statusCode());

    // Get Item back from table
    Map<String, AttributeValue> keyToGetB = createTestKey(
      partitionValue,
      sortValue
    );

    GetItemRequest getRequestB = GetItemRequest
      .builder()
      .key(keyToGetB)
      .tableName(TEST_TABLE_NAME)
      .build();

    GetItemResponse getResponseB = ddbAB.getItem(getRequestB);
    assertEquals(200, getResponseB.sdkHttpResponse().statusCode());
    Map<String, AttributeValue> returnedItemB = getResponseB.item();
    assertNotNull(returnedItemB);
    assertEquals(partitionValue, returnedItemB.get(TEST_PARTITION_NAME).s());
    assertEquals(sortValue, returnedItemB.get(TEST_SORT_NAME).n());
    assertEquals(attrValue, returnedItemB.get(TEST_ATTR_NAME).s());
  }

  @Test(
    expectedExceptions = software.amazon.cryptography.materialproviders.model.OpaqueError.class,
    expectedExceptionsMessageRegExp = "Item invalid, does not contain expected attributes."
  )
  public void TestHierarchyKeyringWithSupplierReturnsExpectedError() {
    // Create client with keyring that uses branch key supplier that errors on "caseC"
    KeyStore keystore = createKeyStore();
    DynamoDbEncryption ddbEnc = DynamoDbEncryption
      .builder()
      .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
      .build();
    IBranchKeyIdSupplier branchKeyIdSupplier = ddbEnc
      .CreateDynamoDbEncryptionBranchKeyIdSupplier(
        CreateDynamoDbEncryptionBranchKeyIdSupplierInput
          .builder()
          .ddbKeyBranchKeyIdSupplier(new TestSupplier())
          .build()
      )
      .branchKeyIdSupplier();
    IKeyring keyring = createHierarchicalKeyring(keystore, branchKeyIdSupplier);
    assertNotNull(keyring);
    DynamoDbEncryptionInterceptor interceptor = TestUtils.createInterceptor(
      keyring,
      null,
      null
    );
    DynamoDbClient ddbAB = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();

    // Put CaseA item into table with Hierarchy keyring with supplier
    String partitionValue = "caseC";
    String sortValue = "42";
    String attrValue = "bar";
    String attrValue2 = "hello world";
    Map<String, AttributeValue> item = createTestItem(
      partitionValue,
      sortValue,
      attrValue,
      attrValue2
    );

    PutItemRequest putRequestA = PutItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .item(item)
      .build();

    ddbAB.putItem(putRequestA);
  }

  // DynamoDbKeyBranchKeyIdSupplier to be used with test items produced from TestUtils.java
  class TestSupplier implements IDynamoDbKeyBranchKeyIdSupplier {

    public GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKey(
      GetBranchKeyIdFromDdbKeyInput getBranchKeyIdFromDdbKeyInput
    ) {
      Map<String, AttributeValue> key = getBranchKeyIdFromDdbKeyInput.ddbKey();

      // Ensure that key only contains the expected attributes
      assertTrue(key.containsKey(TEST_PARTITION_NAME));
      assertTrue(key.containsKey(TEST_SORT_NAME));
      assertFalse(key.containsKey(TEST_ATTR_NAME));
      assertFalse(key.containsKey(TEST_ATTR2_NAME));

      String branchKeyId;
      if (
        key.containsKey(TEST_PARTITION_NAME) &&
        key.get(TEST_PARTITION_NAME).s().equals("caseA")
      ) {
        branchKeyId = BRANCH_KEY_ID;
      } else if (
        key.containsKey(TEST_PARTITION_NAME) &&
        key.get(TEST_PARTITION_NAME).s().equals("caseB")
      ) {
        branchKeyId = ALTERNATE_BRANCH_KEY_ID;
      } else {
        throw new IllegalArgumentException(
          "Item invalid, does not contain expected attributes."
        );
      }
      return GetBranchKeyIdFromDdbKeyOutput
        .builder()
        .branchKeyId(branchKeyId)
        .build();
    }
  }
}
