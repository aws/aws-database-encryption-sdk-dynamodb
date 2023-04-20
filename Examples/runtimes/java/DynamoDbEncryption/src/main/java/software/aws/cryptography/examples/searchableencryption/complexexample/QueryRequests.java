package software.aws.cryptography.examples.searchableencryption.complexexample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

/*
 * This class implements query access patterns from
 * https://github.com/aws-samples/searchable-encryption-dynamodb-howto/blob/main/BeaconPOC/Demo.md
 * The queries in this file are more complicated than in other searchable encryption examples,
 *   and should demonstrate how one can structure queries on beacons in a broader variety of applications.
 */

public class QueryRequests {

  public static void runQueries(String ddbTableName, DynamoDbClient ddb) {
    runQueriesOnGsi0(ddbTableName, ddb);
    runQueriesOnGsi1(ddbTableName, ddb);
    runQueriesOnGsi2(ddbTableName, ddb);
    runQueriesOnGsi3(ddbTableName, ddb);
  }

  public static void runQueriesOnGsi0(String ddbTableName, DynamoDbClient ddb) {
    // Query 2: Get meetings by date and employeeID
    // Key condition: PK=employeeID SK between(date1, date2)
    // Filter condition: duration > 0
    Map<String,String> query2AttributeNames = new HashMap<>();
    query2AttributeNames.put("#p", "PK");
    query2AttributeNames.put("#s", "SK");
    query2AttributeNames.put("#dur", "Duration");

    Map<String,AttributeValue> query2AttributeValues = new HashMap<>();
    query2AttributeValues.put(":e", AttributeValue.builder().s("E-emp_001").build());
    query2AttributeValues.put(":date1", AttributeValue.builder().s("MS-2022-07-02").build());
    query2AttributeValues.put(":date2", AttributeValue.builder().s("MS-2022-07-08").build());
    query2AttributeValues.put(":dur", AttributeValue.builder().s("0").build());

    QueryRequest query2Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-0")
        .keyConditionExpression("#p = :e AND #s BETWEEN :date1 AND :date2")
        .filterExpression("#dur > :dur")
        .expressionAttributeNames(query2AttributeNames)
        .expressionAttributeValues(query2AttributeValues)
        .build();

    System.out.println(query2Request);

    QueryResponse query2Response = ddb.query(query2Request);
    // Validate query was returned successfully
    assert 200 == query2Response.sdkHttpResponse().statusCode();
    System.out.println("query2 returned items: " + query2Response.items().size());

//    Map<String,String> query3AttributeNames = new HashMap<>();
//    query3AttributeNames.put("#p", "PK");
//    query3AttributeNames.put("#s", "SK");
//    query3AttributeNames.put("#dur", "Duration");
//
//    // To query against a compound beacon, you must write the prefix, then the unencrypted value.
//    // The expression below queries against zipcodes of 98109.
//    // This is similar to the behavior in the Basic example, which also queries as if the beacon was plaintext,
//    //     except we must add the prefix.
//    Map<String,AttributeValue> query3AttributeValues = new HashMap<>();
//    query3AttributeValues.put(":b", AttributeValue.builder().s("B-44").build());
//    query3AttributeValues.put(":date1", AttributeValue.builder().s("MS-2022-07-02").build());
//    query3AttributeValues.put(":date2", AttributeValue.builder().s("MS-2022-07-08").build());
//    query3AttributeValues.put(":dur", AttributeValue.builder().s("0").build());
//
//    QueryRequest query3Request = QueryRequest.builder()
//        .tableName(ddbTableName)
//        .indexName("GSI-0")
//        .keyConditionExpression("#p = :e AND #s BETWEEN :date1 AND :date2")
//        .filterExpression("contains(#s, :")
//        .expressionAttributeNames(query3AttributeNames)
//        .expressionAttributeValues(query3AttributeValues)
//        .build();
//
//    System.out.println(query3Request);
//
//    QueryResponse query3Response = ddb.query(query3Request);
//    // Validate query was returned successfully
//    assert 200 == query3Response.sdkHttpResponse().statusCode();
//    System.out.println("query3 returned items: " + query3Response.items().size());
  }

  public static void runQueriesOnGsi1(String ddbTableName, DynamoDbClient ddb) {
    // Query 1: Get meetings by date and email
    // Key condition: PK1=email SK1 between(date1, date2)
    // Filter condition: duration > 0
    final Map<String,String> query1AttributeNames = new HashMap<>();
    query1AttributeNames.put("#p", "PK1");
    query1AttributeNames.put("#sk1", "SK1");
    query1AttributeNames.put("#dur", "Duration");

    final Map<String, AttributeValue> query1AttributeValues = new HashMap<>();
    query1AttributeValues.put(":e", AttributeValue.builder().s("EE-able@gmail.com").build());
    query1AttributeValues.put(":date1", AttributeValue.builder().s("MS-2022-07-02").build());
    query1AttributeValues.put(":date2", AttributeValue.builder().s("MS-2022-07-08").build());
    query1AttributeValues.put(":dur", AttributeValue.builder().s("0").build());

    final QueryRequest query1Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-1")
        .keyConditionExpression("#p = :e AND #sk1 BETWEEN :date1 AND :date2")
        .filterExpression("#dur > :dur")
        .expressionAttributeNames(query1AttributeNames)
        .expressionAttributeValues(query1AttributeValues)
        .build();

    final QueryResponse query1Response = ddb.query(query1Request);
    final List<Map<String, AttributeValue>> attributeValuesQuery1Response = query1Response.items();
    // Validate query was returned successfully
    assert 200 == query1Response.sdkHttpResponse().statusCode();
    System.out.println("query1 returned items: " + query1Response.items().size());

    // Query 4: Get employee data by email
    // Key condition: PK1=email SK1 > 30 days ago
    Map<String,String> query4AttributeNames = new HashMap<>();
    query4AttributeNames.put("#p", "PK1");
    query4AttributeNames.put("#s", "SK1");

    Map<String,AttributeValue> query4AttributeValues = new HashMap<>();
    query4AttributeValues.put(":e", AttributeValue.builder().s("EE-able@gmail.com").build());
    query4AttributeValues.put(":s", AttributeValue.builder().s("E-emp_001").build());

    QueryRequest query4Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-1")
        .keyConditionExpression("#p = :e AND #s = :s")
        .expressionAttributeNames(query4AttributeNames)
        .expressionAttributeValues(query4AttributeValues)
        .build();

    System.out.println(query4Request);

    QueryResponse query4Response = ddb.query(query4Request);
    // Validate query was returned successfully
    assert 200 == query4Response.sdkHttpResponse().statusCode();
    System.out.println("query4 returned items: " + query4Response.items().size());

    // Query 5: Get employee data by email
    // Key condition: PK1=email SK1 > 30 days ago
    Map<String,String> query5AttributeNames = new HashMap<>();
    query5AttributeNames.put("#p", "PK1");
    query5AttributeNames.put("#s", "SK1");

    Map<String,AttributeValue> query5AttributeValues = new HashMap<>();
    query5AttributeValues.put(":e", AttributeValue.builder().s("EE-able@gmail.com").build());
    query5AttributeValues.put(":s", AttributeValue.builder().s("MS-2023-03-20").build());

    QueryRequest query5Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-1")
        .keyConditionExpression("#p = :e AND #s < :s")
        .expressionAttributeNames(query5AttributeNames)
        .expressionAttributeValues(query5AttributeValues)
        .build();

    System.out.println(query5Request);

    QueryResponse query5Response = ddb.query(query5Request);
    // Validate query was returned successfully
    assert 200 == query5Response.sdkHttpResponse().statusCode();
    System.out.println("query5 returned items: " + query5Response.items().size());

    // Query 6: Get tickets by email
    // Key condition: PK1=email SK1 > 30 days ago
    Map<String,String> query6AttributeNames = new HashMap<>();
    query6AttributeNames.put("#p", "PK1");
    query6AttributeNames.put("#s", "SK1");

    // To query against a compound beacon, you must write the prefix, then the unencrypted value.
    // The expression below queries against zipcodes of 98109.
    // This is similar to the behavior in the Basic example, which also queries as if the beacon was plaintext,
    //     except we must add the prefix.
    Map<String,AttributeValue> query6AttributeValues = new HashMap<>();
    query6AttributeValues.put(":e", AttributeValue.builder().s("CE-zorro@gmail.com").build());
    query6AttributeValues.put(":s", AttributeValue.builder().s("MS-2023-03-20").build());

    QueryRequest query6Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-1")
        .keyConditionExpression("#p = :e AND #s < :s")
        .expressionAttributeNames(query6AttributeNames)
        .expressionAttributeValues(query6AttributeValues)
        .build();

    System.out.println(query6Request);

    QueryResponse query6Response = ddb.query(query6Request);
    // Validate query was returned successfully
    assert 200 == query6Response.sdkHttpResponse().statusCode();
    System.out.println("query6 returned items: " + query6Response.items().size());
  }

  public static void runQueriesOnGsi2(String ddbTableName, DynamoDbClient ddb) {
  }

  public static void runQueriesOnGsi3(String ddbTableName, DynamoDbClient ddb) {
  }

}
