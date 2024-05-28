package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.TestUtils.*;

import java.util.*;
import java.util.stream.Collectors;
import org.testng.annotations.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

public class DynamoDbItemConversionIntegrationTests {

  @Test
  public void TestPutItemGetRichItem() {
    Map<String, CryptoAction> actions = new HashMap<>();
    actions.put(TEST_PARTITION_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_ATTR_NAME, CryptoAction.SIGN_ONLY);
    actions.put(TEST_ATTR2_NAME, CryptoAction.DO_NOTHING);
    actions.put("Sattr", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("Nattr", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("Battr", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("SSattr", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("NSattr", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("BSattr", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("Lattr", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("Lattr-empty", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("Mattr", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("Mattr-empty", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("BOOLattr-true", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("BOOLattr-false", CryptoAction.ENCRYPT_AND_SIGN);
    actions.put("NULattr", CryptoAction.ENCRYPT_AND_SIGN);

    String sValue = "Sattr";
    String sValue2 = "";
    String nValue = "0";
    String nValue2 = "1E-130"; // positive minimum
    String nValue3 = "9.9999999999999999999999999999999999999E+125"; // positive maximum
    String nValue4 = "-9.9999999999999999999999999999999999999E+125"; // negative minimum
    String nValue5 = "-1E-130"; // negative maximum
    SdkBytes bValue = SdkBytes.fromByteArray(new byte[0]);
    SdkBytes bValue2 = SdkBytes.fromByteArray(
      Base64.getEncoder().encode("hello World".getBytes())
    );
    List<AttributeValue> lValue = new ArrayList();
    lValue.add(AttributeValue.fromB(bValue));
    lValue.add(AttributeValue.fromS(sValue));
    lValue.add(AttributeValue.fromN(nValue));
    Map<String, AttributeValue> mValue = new HashMap<>();
    mValue.put("M:Nattr", AttributeValue.fromN(nValue2));
    mValue.put("M:Sattr", AttributeValue.fromS(sValue2));
    mValue.put("M:Battr", AttributeValue.fromB(bValue2));

    Map<String, AttributeValue> item = createTestItem(
      "foo",
      "42",
      "bar",
      "awol"
    );
    item.put("Sattr", AttributeValue.fromS(sValue));
    item.put("Nattr", AttributeValue.fromN(nValue));
    item.put("Battr", AttributeValue.fromB(bValue));
    item.put("BOOLattr-true", AttributeValue.fromBool(true));
    item.put("BOOLattr-false", AttributeValue.fromBool(false));
    item.put("NULattr", AttributeValue.fromNul(true));
    item.put("SSattr", AttributeValue.builder().ss(sValue, sValue2).build());
    item.put(
      "NSattr",
      AttributeValue
        .builder()
        .ns(nValue, nValue2, nValue3, nValue4, nValue5)
        .build()
    );
    item.put("BSattr", AttributeValue.builder().bs(bValue, bValue2).build());
    item.put("Lattr", AttributeValue.fromL(lValue));
    item.put("Lattr-empty", AttributeValue.fromL(Collections.EMPTY_LIST));
    item.put("Mattr", AttributeValue.fromM(mValue));
    item.put("Mattr-empty", AttributeValue.fromM(Collections.EMPTY_MAP));

    DynamoDbEncryptionInterceptor interceptor = createInterceptor(
      actions,
      Arrays.asList(TEST_ATTR2_NAME),
      createKmsKeyring(),
      null,
      null
    );
    DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();

    String partitionValue = "foo";
    String sortValue = "42";
    String attrValue = "bar";

    PutItemRequest putRequest = PutItemRequest
      .builder()
      .tableName(TEST_TABLE_NAME)
      .item(item)
      .build();

    PutItemResponse putResponse = ddb.putItem(putRequest);
    assertEquals(200, putResponse.sdkHttpResponse().statusCode());

    // Using a client with the DDBEncryptionInterceptor, ensure that attributes have been "encrypted"
    DynamoDbClient ddbWithoutDecryption = DynamoDbClient.create();

    Map<String, AttributeValue> keyToGet = createTestKey(
      partitionValue,
      sortValue
    );

    GetItemRequest getRequest = GetItemRequest
      .builder()
      .key(keyToGet)
      .tableName(TEST_TABLE_NAME)
      .build();
    GetItemResponse encryptedGetResponse = ddbWithoutDecryption.getItem(
      getRequest
    );
    Map<String, AttributeValue> encryptedItem = encryptedGetResponse.item();
    assertNotNull(encryptedItem);
    assertEquals(partitionValue, encryptedItem.get(TEST_PARTITION_NAME).s());
    assertEquals(sortValue, encryptedItem.get(TEST_SORT_NAME).n());
    assertEquals(attrValue, encryptedItem.get(TEST_ATTR_NAME).s());

    // Check Simple Types
    assertNull(encryptedItem.get("Sattr").s());
    assertNotNull(encryptedItem.get("Sattr").b());
    assertNotEquals(sValue, encryptedItem.get("Sattr").b());

    assertNull(encryptedItem.get("Nattr").n());
    assertNotNull(encryptedItem.get("Nattr").b());
    assertNotEquals(nValue, encryptedItem.get("Nattr").b());

    assertNotNull(encryptedItem.get("Battr").b());
    assertNotEquals(bValue, encryptedItem.get("Battr").b());

    assertNull(encryptedItem.get("BOOLattr-true").bool());
    assertNotNull(encryptedItem.get("BOOLattr-true").b());
    assertNull(encryptedItem.get("BOOLattr-false").bool());
    assertNotNull(encryptedItem.get("BOOLattr-false").b());
    assertNull(encryptedItem.get("NULattr").nul());
    assertNotNull(encryptedItem.get("NULattr").b());

    // Check Sets
    assertEquals(0, encryptedItem.get("SSattr").ss().size());
    assertNotNull(encryptedItem.get("SSattr").b());
    assertEquals(0, encryptedItem.get("NSattr").ss().size());
    assertNotNull(encryptedItem.get("NSattr").b());
    assertEquals(0, encryptedItem.get("BSattr").ss().size());
    assertNotNull(encryptedItem.get("BSattr").b());

    // Check List
    assertEquals(0, encryptedItem.get("Lattr").l().size());
    assertNotNull(encryptedItem.get("Lattr").b());
    assertEquals(0, encryptedItem.get("Lattr-empty").l().size());
    assertNotNull(encryptedItem.get("Lattr-empty").b());

    // Check Map
    assertEquals(0, encryptedItem.get("Mattr").m().size());
    assertNotNull(encryptedItem.get("Mattr").b());
    assertEquals(0, encryptedItem.get("Mattr-empty").m().size());
    assertNotNull(encryptedItem.get("Mattr-empty").b());

    // Get Item back from table using Interceptor

    GetItemResponse getResponse = ddb.getItem(getRequest);
    assertEquals(200, getResponse.sdkHttpResponse().statusCode());
    Map<String, AttributeValue> newItem = getResponse.item();
    assertNotNull(newItem);
    assertEquals(partitionValue, newItem.get(TEST_PARTITION_NAME).s());
    assertEquals(sortValue, newItem.get(TEST_SORT_NAME).n());
    assertEquals(attrValue, newItem.get(TEST_ATTR_NAME).s());

    // Check Simple Types
    assertEquals(sValue, newItem.get("Sattr").s());
    assertEquals(nValue, newItem.get("Nattr").n());
    assertEquals(bValue, newItem.get("Battr").b());
    assertTrue(newItem.get("BOOLattr-true").bool());
    assertFalse(newItem.get("BOOLattr-false").bool());
    assertTrue(newItem.get("NULattr").nul());

    // Check Sets
    List<String> ss = newItem.get("SSattr").ss();
    assertTrue(ss.containsAll(Arrays.asList(sValue, sValue2)));
    List<String> ns = newItem.get("NSattr").ns();
    assertTrue(ns.size() > 0);
    List<Double> nsConverted = ns
      .stream()
      .map(val -> Double.parseDouble(val))
      .collect(Collectors.toList());
    assertTrue(nsConverted.contains(Double.parseDouble(nValue2)));
    assertTrue(nsConverted.contains(Double.parseDouble(nValue3)));
    assertTrue(nsConverted.contains(Double.parseDouble(nValue4)));
    assertTrue(nsConverted.contains(Double.parseDouble(nValue5)));
    List<SdkBytes> bs = newItem.get("BSattr").bs();
    assertTrue(bs.size() > 0);
    assertTrue(bs.containsAll(Arrays.asList(bValue, bValue2)));

    // Check List
    List<AttributeValue> l = newItem.get("Lattr").l();
    assertEquals(3, l.size());
    assertEquals(bValue, l.get(0).b());
    assertEquals(sValue, l.get(1).s());
    assertEquals(nValue, l.get(2).n());

    // Check Map
    Map<String, AttributeValue> m = newItem.get("Mattr").m();
    assertEquals(3, m.size());
    assertEquals(sValue2, m.get("M:Sattr").s());
    assertEquals(
      Double.parseDouble(nValue2),
      Double.parseDouble(m.get("M:Nattr").n())
    );
    assertEquals(bValue2, m.get("M:Battr").b());

    // Check empty structures
    assertEquals(0, newItem.get("Lattr-empty").l().size());
    assertEquals(0, newItem.get("Mattr-empty").m().size());
  }
}
