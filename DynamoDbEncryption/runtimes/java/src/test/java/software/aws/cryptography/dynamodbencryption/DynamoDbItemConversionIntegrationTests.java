package software.aws.cryptography.dynamodbencryption;

import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static software.aws.cryptography.dynamodbencryption.TestUtils.*;

public class DynamoDbItemConversionIntegrationTests {
    // TODO break this up into distinct tests
    @Test
    public void TestPutItemGetRichItem() {
        Map<String, CryptoAction> actions = new HashMap<>();
        actions.put(TEST_PARTITION_NAME, CryptoAction.ENCRYPT_AND_SIGN);
        actions.put(TEST_SORT_NAME, CryptoAction.SIGN_ONLY);
        actions.put(TEST_ATTR_NAME, CryptoAction.DO_NOTHING);
        actions.put("Sattr", CryptoAction.SIGN_ONLY);
        actions.put("Nattr", CryptoAction.SIGN_ONLY);
        actions.put("Battr", CryptoAction.SIGN_ONLY);
        actions.put("SSattr", CryptoAction.SIGN_ONLY);
        actions.put("NSattr", CryptoAction.SIGN_ONLY);
        actions.put("BSattr", CryptoAction.SIGN_ONLY);
        actions.put("Lattr", CryptoAction.SIGN_ONLY);
        actions.put("Lattr-empty", CryptoAction.SIGN_ONLY);
        actions.put("Mattr", CryptoAction.SIGN_ONLY);
        actions.put("Mattr-empty", CryptoAction.SIGN_ONLY);
        actions.put("BOOLattr-true", CryptoAction.SIGN_ONLY);
        actions.put("BOOLattr-false", CryptoAction.SIGN_ONLY);
        actions.put("NULattr", CryptoAction.SIGN_ONLY);

        String sValue = "Sattr";
        String sValue2 = "";
        String nValue = "0";
        String nValue2 = "1E-130"; // positive minimum
        String nValue3 = "9.9999999999999999999999999999999999999E+125"; // positive maximum
        String nValue4 = "-9.9999999999999999999999999999999999999E+125"; // negative minimum
        String nValue5 = "-1E-130"; // negative maximum
        SdkBytes bValue = SdkBytes.fromByteArray(new byte[0]);
        SdkBytes bValue2 = SdkBytes.fromByteArray(Base64.getEncoder().encode("hello World".getBytes()));
        List<AttributeValue> lValue = new ArrayList();
        lValue.add(AttributeValue.fromB(bValue));
        lValue.add(AttributeValue.fromS(sValue));
        lValue.add(AttributeValue.fromN(nValue));
        Map<String, AttributeValue> mValue = new HashMap<>();
        mValue.put("M:Nattr", AttributeValue.fromN(nValue2));
        mValue.put("M:Sattr", AttributeValue.fromS(sValue2));
        mValue.put("M:Battr", AttributeValue.fromB(bValue2));

        Map<String, AttributeValue> item = createTestItem("foo", "42", "bar");
        item.put("Sattr", AttributeValue.fromS(sValue));
        item.put("Nattr", AttributeValue.fromN(nValue));
        item.put("Battr", AttributeValue.fromB(bValue));
        item.put("BOOLattr-true", AttributeValue.fromBool(true));
        item.put("BOOLattr-false", AttributeValue.fromBool(false));
        item.put("NULattr", AttributeValue.fromNul(true));
        item.put("SSattr", AttributeValue.builder().ss(sValue, sValue2).build());
        item.put("NSattr", AttributeValue.builder().ns(nValue, nValue2, nValue3, nValue4, nValue5).build());
        item.put("BSattr", AttributeValue.builder().bs(bValue, bValue2).build());
        item.put("Lattr", AttributeValue.fromL(lValue));
        item.put("Lattr-empty", AttributeValue.fromL(Collections.EMPTY_LIST));
        item.put("Mattr", AttributeValue.fromM(mValue));
        item.put("Mattr-empty", AttributeValue.fromM(Collections.EMPTY_MAP));

        DynamoDbEncryptionInterceptor interceptor = createInterceptor(actions, createStaticKeyring());
        DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        String partitionValue = "foo";
        String sortValue = "42";
        String attrValue = "bar";

        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(TEST_TABLE_NAME)
                .item(item)
                .build();

        PutItemResponse putResponse = ddb.putItem(putRequest);
        assertEquals(200, putResponse.sdkHttpResponse().statusCode());

        // Get Item back from table
        Map<String, AttributeValue> keyToGet = createTestKey(partitionValue, sortValue);

        GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(TEST_TABLE_NAME)
                .build();

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
        List<Double> nsConverted = ns.stream().map(val -> Double.parseDouble(val)).collect(Collectors.toList());
        assertTrue(nsConverted.contains(Double.parseDouble(nValue2)));
        assertTrue(nsConverted.contains(Double.parseDouble(nValue3)));
        assertTrue(nsConverted.contains(Double.parseDouble(nValue4)));
        assertTrue(nsConverted.contains(Double.parseDouble(nValue5)));
        List<SdkBytes> bs = newItem.get("BSattr").bs();
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
        assertEquals(Double.parseDouble(nValue2), Double.parseDouble(m.get("M:Nattr").n()));
        assertEquals(bValue2, m.get("M:Battr").b());

        // Check empty structures
        assertEquals(0, newItem.get("Lattr-empty").l().size());
        assertEquals(0, newItem.get("Mattr-empty").m().size());
    }
}
