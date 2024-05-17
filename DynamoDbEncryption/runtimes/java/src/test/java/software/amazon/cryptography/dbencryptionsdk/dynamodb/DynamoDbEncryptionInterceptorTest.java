package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import static org.testng.Assert.*;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.TestUtils.*;

import java.util.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import software.amazon.awssdk.core.ClientType;
import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.interceptor.*;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructMap;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DynamoDbEncryptionTransformsException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

public class DynamoDbEncryptionInterceptorTest {

  static DynamoDbEncryptionInterceptor interceptor;
  static ExecutionAttributes validAttributes;

  @BeforeTest
  public static void setup() {
    interceptor = createInterceptor(createKmsKeyring(), null, null);
    validAttributes =
      ExecutionAttributes
        .builder()
        .put(SdkExecutionAttribute.SERVICE_NAME, "DynamoDb")
        .put(SdkExecutionAttribute.CLIENT_TYPE, ClientType.SYNC)
        .build();
  }

  @Test
  public void TestPutItemEncryptsAccordingToAttributeActions() {
    String partitionValue = "foo";
    String sortValue = "42";
    String attrValue = "encrypt";
    String attrValue2 = "do nothing";
    Map<String, AttributeValue> item = createTestItem(
      partitionValue,
      sortValue,
      attrValue,
      attrValue2
    );

    PutItemRequest oldRequest = PutItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .item(item)
      .conditionExpression(TEST_ATTR2_NAME + " < :a")
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
      .build();

    SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
    assertTrue(newRequest instanceof PutItemRequest);

    // ENCRYPT_AND_SIGN results in changed attribute
    assertNotEquals(
      oldRequest.item().get(TEST_ATTR_NAME),
      ((PutItemRequest) newRequest).item().get(TEST_ATTR_NAME)
    );

    // SIGN_ONLY and DO_NOTHING does not modify any attribute values
    assertEquals(
      oldRequest.item().get(TEST_ATTR2_NAME),
      ((PutItemRequest) newRequest).item().get(TEST_ATTR2_NAME)
    );
    assertEquals(
      oldRequest.item().get(TEST_PARTITION_NAME),
      ((PutItemRequest) newRequest).item().get(TEST_PARTITION_NAME)
    );
    assertEquals(
      oldRequest.item().get(TEST_SORT_NAME),
      ((PutItemRequest) newRequest).item().get(TEST_SORT_NAME)
    );
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "^Condition Expressions forbidden on encrypted attributes : attr1$"
  )
  public void TestPutItemGetItemWithConditionExpressionBad() {
    PutItemRequest oldRequest = PutItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .conditionExpression(TEST_ATTR_NAME + " < :a")
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test
  public void TestUpdateItemOnEncryptedTableGood() {
    UpdateItemRequest oldRequest = UpdateItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .key(Collections.EMPTY_MAP)
      .updateExpression("SET " + TEST_ATTR2_NAME + " = :p")
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "UpdateItem")
      .build();

    SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
    assertEquals(oldRequest, newRequest);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "Update Expressions forbidden on signed attributes : " +
    TEST_ATTR_NAME
  )
  public void TestUpdateItemOnEncryptedTableBad() throws Exception {
    UpdateItemRequest oldRequest = UpdateItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .key(Collections.EMPTY_MAP)
      .updateExpression("SET " + TEST_ATTR_NAME + " = :p")
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "UpdateItem")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test
  public void TestUpdateItemOnNonEncryptedTable() {
    UpdateItemRequest oldRequest = UpdateItemRequest
      .builder()
      .tableName("otherTable")
      .key(Collections.EMPTY_MAP)
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "UpdateItem")
      .build();

    SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
    assertEquals(oldRequest, newRequest);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "Condition Expressions forbidden on encrypted attributes : attr1"
  )
  public void TestTransactWriteItemsWithConditionCheck() {
    TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest
      .builder()
      .transactItems(
        TransactWriteItem
          .builder()
          .put(Put.builder().tableName(TEST_TABLE_NAME).build())
          .conditionCheck(
            ConditionCheck
              .builder()
              .tableName(TEST_TABLE_NAME)
              .conditionExpression(TEST_ATTR_NAME + " < :a")
              .build()
          )
          .build()
      )
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "Condition Expressions forbidden on encrypted attributes : attr1"
  )
  public void TestTransactWriteItemsWithPutConditionExpression() {
    TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest
      .builder()
      .transactItems(
        TransactWriteItem
          .builder()
          .put(
            Put
              .builder()
              .tableName(TEST_TABLE_NAME)
              .conditionExpression(TEST_ATTR_NAME + " < :a")
              .build()
          )
          .build()
      )
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "Condition Expressions forbidden on encrypted attributes : attr1"
  )
  public void TestTransactWriteItemsWithDeleteConditionExpression() {
    TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest
      .builder()
      .transactItems(
        TransactWriteItem
          .builder()
          .delete(
            Delete
              .builder()
              .tableName(TEST_TABLE_NAME)
              .conditionExpression(TEST_ATTR_NAME + " < :a")
              .build()
          )
          .build()
      )
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test
  public void TestTransactWriteItemsWithUpdateOnEncryptedTableGood() {
    TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest
      .builder()
      .transactItems(
        TransactWriteItem
          .builder()
          .update(
            Update
              .builder()
              .tableName(TEST_TABLE_NAME)
              .key(Collections.EMPTY_MAP)
              .updateExpression("SET " + TEST_ATTR2_NAME + " = :p")
              .build()
          )
          .build()
      )
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
      .build();

    SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
    assertEquals(oldRequest, newRequest);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "Update Expressions forbidden on signed attributes : " +
    TEST_ATTR_NAME
  )
  public void TestTransactWriteItemsWithUpdateOnEncryptedTableBad() {
    TransactWriteItemsRequest oldRequest = TransactWriteItemsRequest
      .builder()
      .transactItems(
        TransactWriteItem
          .builder()
          .update(
            Update
              .builder()
              .tableName(TEST_TABLE_NAME)
              .key(Collections.EMPTY_MAP)
              .updateExpression("SET " + TEST_ATTR_NAME + " = :p")
              .build()
          )
          .build()
      )
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "TransactWriteItems")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "Condition Expressions forbidden on encrypted attributes : attr1"
  )
  public void TestDeleteItemWithConditionExpression() {
    DeleteItemRequest oldRequest = DeleteItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .conditionExpression(TEST_ATTR_NAME + " < :a")
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "DeleteItem")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test
  public void TestDeleteItemWithConditionExpressionNonEncryptedTable() {
    DeleteItemRequest oldRequest = DeleteItemRequest
      .builder()
      .tableName("otherTable")
      .key(Collections.EMPTY_MAP)
      .conditionExpression("foo")
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "DeleteItem")
      .build();

    SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
    assertEquals(oldRequest, newRequest);
  }

  @Test
  public void TestExecuteStatementOnEncryptedTable() {
    List<String> statementsWithEncryptedTable = Arrays.asList(
      String.format(
        "EXISTS( SELECT * FROM \"%s\" WHERE \"Artist\" = 'Acme Band' AND \"SongTitle\" = 'PartiQL Rocks')",
        TEST_TABLE_NAME
      ),
      String.format(
        "INSERT INTO \"%s\" value {'Artist' : 'Acme Band','SongTitle' : 'PartiQL Rocks'}",
        TEST_TABLE_NAME
      ),
      String.format(
        "DELETE FROM \"%s\" WHERE \"Artist\" = 'Acme Band' AND \"SongTitle\" = 'PartiQL Rocks' RETURNING ALL OLD *",
        TEST_TABLE_NAME
      ),
      String.format(
        "SELECT OrderID, Total FROM \"%s\" WHERE OrderID IN [1, 2, 3] ORDER BY OrderID DESC",
        TEST_TABLE_NAME
      ),
      String.format(
        "SELECT Devices.FireStick.DateWatched[0] FROM %s WHERE CustomerID= 'C1' AND MovieID= 'M1'",
        TEST_TABLE_NAME
      ),
      String.format(
        "UPDATE \"%s\" SET AwardsWon=1 SET AwardDetail={'Grammys':[2020, 2018]}  WHERE Artist='Acme Band' AND SongTitle='PartiQL Rocks",
        TEST_TABLE_NAME
      )
    );

    for (String statement : statementsWithEncryptedTable) {
      ExecuteStatementRequest oldRequest = ExecuteStatementRequest
        .builder()
        .statement(statement)
        .build();
      Context.ModifyRequest context = InterceptorContext
        .builder()
        .request(oldRequest)
        .build();
      ExecutionAttributes attributes = validAttributes
        .toBuilder()
        .put(SdkExecutionAttribute.OPERATION_NAME, "ExecuteStatement")
        .build();
      try {
        interceptor.modifyRequest(context, attributes);
      } catch (DynamoDbEncryptionTransformsException e) {
        assertTrue(
          e
            .getMessage()
            .contains("ExecuteStatement not Supported on encrypted tables.")
        );
      }
    }
  }

  @Test
  public void TestExecuteStatementOnNonEncryptedTable() {
    ExecuteStatementRequest oldRequest = ExecuteStatementRequest
      .builder()
      .statement("SELECT * FROM otherTable")
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "ExecuteStatement")
      .build();

    SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
    assertEquals(oldRequest, newRequest);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "DynamoDbEncryptionInterceptor does not support use with unrecognized operation: UnknownOperation"
  )
  public void TestUnknownOperationRequest() {
    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(PutItemRequest.builder().build())
      .build();
    ExecutionAttributes badAttributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "UnknownOperation")
      .build();

    interceptor.modifyRequest(context, badAttributes);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "DynamoDbEncryptionInterceptor does not support use with the Async client."
  )
  public void TestNonSyncClientRequest() {
    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(PutItemRequest.builder().build())
      .build();
    ExecutionAttributes badAttributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.CLIENT_TYPE, ClientType.ASYNC)
      .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem") // use something valid for operation name
      .build();

    interceptor.modifyRequest(context, badAttributes);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "DynamoDbEncryptionInterceptor does not support use with services other than DynamoDb."
  )
  public void TestNonDDBServiceRequest() {
    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(PutItemRequest.builder().build())
      .build();
    ExecutionAttributes badAttributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.SERVICE_NAME, "OtherService")
      .build();

    interceptor.modifyRequest(context, badAttributes);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionTransformsException.class,
    expectedExceptionsMessageRegExp = "Missing value for required field `config`"
  )
  public void TestEmptyInterceptorBuild() {
    DynamoDbEncryptionInterceptor.builder().build();
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "^Partition key attribute action MUST be SIGN_ONLY$"
  )
  public void TestBadCryptoActionOnPartitionKey() {
    Map<String, CryptoAction> actions = new HashMap<>();
    actions.put(TEST_PARTITION_NAME, CryptoAction.ENCRYPT_AND_SIGN);
    actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
    List<String> allowedUnauth = Arrays.asList(TEST_ATTR_NAME);

    createInterceptor(actions, allowedUnauth, createKmsKeyring(), null, null);
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "^Sort key attribute action MUST be SIGN_ONLY$"
  )
  public void TestBadCryptoActionOnSortKey() {
    Map<String, CryptoAction> actions = new HashMap<>();
    actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_SORT_NAME, CryptoAction.ENCRYPT_AND_SIGN);
    actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
    List<String> allowedUnauth = Arrays.asList(TEST_ATTR_NAME);

    createInterceptor(actions, allowedUnauth, createKmsKeyring(), null, null);
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "Attribute " +
    TEST_ATTR_NAME +
    " is configured as DO_NOTHING but it must also be in unauthenticatedAttributes or begin with the unauthenticatedPrefix."
  )
  public void TestSignatureScopeMissingAttr() {
    Map<String, CryptoAction> actions = new HashMap<>();
    actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
    List<String> allowedUnauth = Arrays.asList();

    createInterceptor(actions, allowedUnauth, createKmsKeyring(), null, null);
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "Attribute " +
    TEST_SORT_NAME +
    " is configured as SIGN_ONLY but it is also in unauthenticatedAttributes."
  )
  public void TestSignatureScopeExtraAttr() {
    Map<String, CryptoAction> actions = new HashMap<>();
    actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
    List<String> allowedUnauth = Arrays.asList(TEST_ATTR_NAME, TEST_SORT_NAME);

    createInterceptor(actions, allowedUnauth, createKmsKeyring(), null, null);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionException.class,
    expectedExceptionsMessageRegExp = "No Crypto Action configured for attribute attr3"
  )
  public void TestPutWithInvalidCryptoAction() {
    Map<String, AttributeValue> item = createTestItem(
      "foo",
      "10",
      "bar",
      "awol"
    );
    // Add an attribute not modelled in the crypto schema
    item.put("attr3", AttributeValue.fromS("attr3"));
    PutItemRequest oldRequest = PutItemRequest
      .builder()
      .item(item)
      .tableName(TEST_TABLE_NAME)
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "On Encrypt : Partition key 'partition_key' does not exist in item. Item contains these attributes : attr1 attr2 sort_key."
  )
  public void TestPutMissingPartition() {
    Map<String, AttributeValue> item = createTestItem(
      "foo",
      "10",
      "bar",
      "awol"
    );
    // Remove partition key from item
    item.remove(TEST_PARTITION_NAME);
    PutItemRequest oldRequest = PutItemRequest
      .builder()
      .item(item)
      .tableName(TEST_TABLE_NAME)
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "On Encrypt : Sort key 'sort_key' does not exist in item. Item contains these attributes : attr1 attr2 partition_key."
  )
  public void TestPutMissingSort() {
    Map<String, AttributeValue> item = createTestItem(
      "foo",
      "10",
      "bar",
      "awol"
    );
    // Remove partition key from item
    item.remove(TEST_SORT_NAME);
    PutItemRequest oldRequest = PutItemRequest
      .builder()
      .item(item)
      .tableName(TEST_TABLE_NAME)
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "PutItem")
      .build();

    interceptor.modifyRequest(context, attributes);
  }

  @Test
  public void TestQueryPreservesEmptyExclusiveStartKey() {
    QueryRequest oldRequest = QueryRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .exclusiveStartKey(new HashMap<>())
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "Query")
      .build();

    SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
    assertTrue(newRequest instanceof QueryRequest);
    assertFalse(
      ((QueryRequest) newRequest).exclusiveStartKey() instanceof
      DefaultSdkAutoConstructMap
    );
    assertEquals(((QueryRequest) newRequest).exclusiveStartKey().size(), 0);
  }

  @Test
  public void TestScanPreservesEmptyExclusiveStartKey() {
    ScanRequest oldRequest = ScanRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .exclusiveStartKey(new HashMap<>())
      .build();

    Context.ModifyRequest context = InterceptorContext
      .builder()
      .request(oldRequest)
      .build();

    ExecutionAttributes attributes = validAttributes
      .toBuilder()
      .put(SdkExecutionAttribute.OPERATION_NAME, "Scan")
      .build();

    SdkRequest newRequest = interceptor.modifyRequest(context, attributes);
    assertTrue(newRequest instanceof ScanRequest);
    assertFalse(
      ((ScanRequest) newRequest).exclusiveStartKey() instanceof
      DefaultSdkAutoConstructMap
    );
    assertEquals(((ScanRequest) newRequest).exclusiveStartKey().size(), 0);
  }
}
