package software.aws.cryptography.examples.searchableencryption.complexexample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

public class QueryRequests {

  public static void runQueries(String ddbTableName, DynamoDbClient ddb) {
    Map<String,String> query1AttributeNames = new HashMap<>();
    query1AttributeNames.put("#p", "PK1");
    query1AttributeNames.put("#sk1", "SK1");
    query1AttributeNames.put("#dur", "Duration");

    // To query against a compound beacon, you must write the prefix, then the unencrypted value.
    // The expression below queries against zipcodes of 98109.
    // This is similar to the behavior in the Basic example, which also queries as if the beacon was plaintext,
    //     except we must add the prefix.
    Map<String, AttributeValue> query1AttributeValues = new HashMap<>();
    query1AttributeValues.put(":e", AttributeValue.builder().s("EE-able@gmail.com").build());
    query1AttributeValues.put(":date1", AttributeValue.builder().s("MS-2022-07-02").build());
    query1AttributeValues.put(":date2", AttributeValue.builder().s("MS-2022-07-08").build());
    query1AttributeValues.put(":dur", AttributeValue.builder().s("0").build());

    QueryRequest queryRequest = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-1")
        .keyConditionExpression("#p = :e AND #sk1 BETWEEN :date1 AND :date2")
        .filterExpression("#dur > :dur")
        .expressionAttributeNames(query1AttributeNames)
        .expressionAttributeValues(query1AttributeValues)
        .build();

    System.out.println(queryRequest);

    QueryResponse queryResponse = ddb.query(queryRequest);
    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
    // Validate query was returned successfully
    assert 200 == queryResponse.sdkHttpResponse().statusCode();
    System.out.println("query1 returned items: " + queryResponse.items().size());

    Map<String,String> query2AttributeNames = new HashMap<>();
    query2AttributeNames.put("#p", "PK");
    query2AttributeNames.put("#s", "SK");
    query2AttributeNames.put("#dur", "Duration");

    // To query against a compound beacon, you must write the prefix, then the unencrypted value.
    // The expression below queries against zipcodes of 98109.
    // This is similar to the behavior in the Basic example, which also queries as if the beacon was plaintext,
    //     except we must add the prefix.
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

    // Query 3: I suspect impossible.
    // Filter expression mentions "SK contains building.floor.room".
    // Is this possible? Will try again later.

    Map<String,String> query4AttributeNames = new HashMap<>();
    query4AttributeNames.put("#p", "PK1");
    query4AttributeNames.put("#s", "SK1");

    // To query against a compound beacon, you must write the prefix, then the unencrypted value.
    // The expression below queries against zipcodes of 98109.
    // This is similar to the behavior in the Basic example, which also queries as if the beacon was plaintext,
    //     except we must add the prefix.
    Map<String,AttributeValue> query4AttributeValues = new HashMap<>();
    query4AttributeValues.put(":e", AttributeValue.builder().s("EE-able@gmail.com").build());
    query4AttributeValues.put(":s", AttributeValue.builder().s("MS-2023-03-20").build());

    QueryRequest query4Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-1")
        .keyConditionExpression("#p = :e AND #s < :s")
        .expressionAttributeNames(query4AttributeNames)
        .expressionAttributeValues(query4AttributeValues)
        .build();

    System.out.println(query4Request);

    QueryResponse query4Response = ddb.query(query4Request);
    // Validate query was returned successfully
    assert 200 == query4Response.sdkHttpResponse().statusCode();
    System.out.println("query4 returned items: " + query4Response.items().size());

  }

}
