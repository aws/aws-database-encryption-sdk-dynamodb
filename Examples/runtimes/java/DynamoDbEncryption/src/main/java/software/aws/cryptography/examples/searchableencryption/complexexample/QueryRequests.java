package software.aws.cryptography.examples.searchableencryption.complexexample;

import java.util.ArrayList;
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
    runQuery1(ddbTableName, ddb);
    runQuery2(ddbTableName, ddb);
    runQuery3(ddbTableName, ddb);
    runQuery4(ddbTableName, ddb);
    runQuery5(ddbTableName, ddb);
    runQuery6(ddbTableName, ddb);
  }

  public static void runQuery1(String ddbTableName, DynamoDbClient ddb) {
    // Query 1: Get meetings by date and email
    // Key condition: PK1=email SK1 between(date1, date2)
    // Filter condition: duration > 0
    final Map<String, String> query1AttributeNames = new HashMap<>();
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
    // Validate query was returned successfully
    assert 200 == query1Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned; only 1 item is expected until we add more items in PutRequests
    assert query1Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery1 = false;
    for (Map<String, AttributeValue> item : query1Response.items()) {
      if (item.get("partition_key").s().equals("meeting1")) {
        foundKnownValueItemQuery1 = true;
        assert item.get("Subject").s().equals("Scan Beacons");
        assert item.get("Location").m().get("Floor").s().equals("12");
        assert item.get("Attendees").l()
            .contains(AttributeValue.builder().s("zorro@gmail.com").build());
      }
    }
    assert foundKnownValueItemQuery1;
  }

  public static void runQuery2(String ddbTableName, DynamoDbClient ddb) {
    // Query 2: Get meetings by date and employeeID
    // Key condition: PK=employeeID SK between(date1, date2)
    // Filter condition: duration > 0
    Map<String, String> query2AttributeNames = new HashMap<>();
    query2AttributeNames.put("#p", "PK");
    query2AttributeNames.put("#s", "SK");
    query2AttributeNames.put("#dur", "Duration");

    Map<String, AttributeValue> query2AttributeValues = new HashMap<>();
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

    QueryResponse query2Response = ddb.query(query2Request);
    // Validate query was returned successfully
    assert 200 == query2Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned; only 1 item is expected until we add more items in PutRequests
    assert query2Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery2 = false;
    for (Map<String, AttributeValue> item : query2Response.items()) {
      if (item.get("partition_key").s().equals("meeting1")) {
        foundKnownValueItemQuery2 = true;
        assert item.get("Subject").s().equals("Scan Beacons");
        assert item.get("Location").m().get("Floor").s().equals("12");
        assert item.get("Attendees").l()
            .contains(AttributeValue.builder().s("zorro@gmail.com").build());
      }
    }
    assert foundKnownValueItemQuery2;
  }

  public static void runQuery3(String ddbTableName, DynamoDbClient ddb) {
    // Query 3: Get meetings by date and building/floor/room
    // Key condition: PK=employeeID SK between(date1, date2)
    // Filter condition: SK contains building.floor.room (see NOTE)
    // NOTE: This query is modified from Demo.md.
    //       Demo.md calls for a filter condition "SK contains building.floor.room"
    //       However, one cannot use primary keys (partition nor sort) in a filter expression.
    //       Instead, this query filters on the individual beacon attributes: building, floor, and room.
    Map<String,String> query3AttributeNames = new HashMap<>();
    query3AttributeNames.put("#p", "PK");
    query3AttributeNames.put("#s", "SK");
    query3AttributeNames.put("#b", "Building");
    query3AttributeNames.put("#f", "Floor");
    query3AttributeNames.put("#r", "Room");

    Map<String,AttributeValue> query3AttributeValues = new HashMap<>();
    query3AttributeValues.put(":bc", AttributeValue.builder().s("B-SEA33").build());
    query3AttributeValues.put(":b", AttributeValue.builder().s("SEA33").build());
    query3AttributeValues.put(":f", AttributeValue.builder().s("12").build());
    query3AttributeValues.put(":r", AttributeValue.builder().s("403").build());
    query3AttributeValues.put(":date1", AttributeValue.builder().s("MS-2022-07-02").build());
    query3AttributeValues.put(":date2", AttributeValue.builder().s("MS-2022-07-08").build());

    QueryRequest query3Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-0")
        .keyConditionExpression("#p = :bc AND #s BETWEEN :date1 AND :date2")
        .filterExpression("#b = :b AND #f = :f AND #r = :r")
        .expressionAttributeNames(query3AttributeNames)
        .expressionAttributeValues(query3AttributeValues)
        .build();

    QueryResponse query3Response = ddb.query(query3Request);
    // Validate query was returned successfully
    assert 200 == query3Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned; only 1 item is expected until we add more items in PutRequests
    assert query3Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery3 = false;
    for (Map<String, AttributeValue> item : query3Response.items()) {
      if (item.get("partition_key").s().equals("reservation1")) {
        foundKnownValueItemQuery3 = true;
        assert item.get("Subject").s().equals("Scan beacons");
        assert item.get("Location").m().get("Building").s().equals("SEA33");
        assert item.get("Attendees").l().contains(AttributeValue.builder().s("betty@gmail.com").build());
      }
    }
    assert foundKnownValueItemQuery3;
  }

  public static void runQuery4(String ddbTableName, DynamoDbClient ddb) {
    // Query 4: Get employee data by email
    // Key condition: PK1=email SK1=employee ID
    Map<String, String> query4AttributeNames = new HashMap<>();
    query4AttributeNames.put("#p", "PK1");
    query4AttributeNames.put("#s", "SK1");

    Map<String, AttributeValue> query4AttributeValues = new HashMap<>();
    query4AttributeValues.put(":e", AttributeValue.builder().s("EE-able@gmail.com").build());
    query4AttributeValues.put(":s", AttributeValue.builder().s("E-emp_001").build());

    QueryRequest query4Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-1")
        .keyConditionExpression("#p = :e AND #s = :s")
        .expressionAttributeNames(query4AttributeNames)
        .expressionAttributeValues(query4AttributeValues)
        .build();

    QueryResponse query4Response = ddb.query(query4Request);
    // Validate query was returned successfully
    assert 200 == query4Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned; only 1 item is expected until we add more items in PutRequests
    assert query4Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery4 = false;
    for (Map<String, AttributeValue> item : query4Response.items()) {
      if (item.get("partition_key").s().equals("employee1")) {
        foundKnownValueItemQuery4 = true;
        assert item.get("EmployeeID").s().equals("emp_001");
        assert item.get("Location").m().get("Desk").s().equals("3");
      }
    }
    assert foundKnownValueItemQuery4;
  }

  public static void runQuery5(String ddbTableName, DynamoDbClient ddb) {
    // Query 5: Get meetings by email
    // Key condition: PK1=email SK1 > 30 days ago
    Map<String, String> query5AttributeNames = new HashMap<>();
    query5AttributeNames.put("#p", "PK1");
    query5AttributeNames.put("#s", "SK1");

    Map<String, AttributeValue> query5AttributeValues = new HashMap<>();
    query5AttributeValues.put(":e", AttributeValue.builder().s("EE-able@gmail.com").build());
    query5AttributeValues.put(":s", AttributeValue.builder().s("MS-2023-03-20").build());

    QueryRequest query5Request = QueryRequest.builder()
        .tableName(ddbTableName)
        .indexName("GSI-1")
        .keyConditionExpression("#p = :e AND #s < :s")
        .expressionAttributeNames(query5AttributeNames)
        .expressionAttributeValues(query5AttributeValues)
        .build();

    QueryResponse query5Response = ddb.query(query5Request);
    // Validate query was returned successfully
    assert 200 == query5Response.sdkHttpResponse().statusCode();

    // Assert 2 items returned; only 2 items are expected until we add more items in PutRequests
    assert query5Response.items().size() == 2;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery5 = false;
    for (Map<String, AttributeValue> item : query5Response.items()) {
      if (item.get("partition_key").s().equals("meeting1")) {
        foundKnownValueItemQuery5 = true;
        assert item.get("Subject").s().equals("Scan Beacons");
        assert item.get("Location").m().get("Floor").s().equals("12");
        assert item.get("Attendees").l()
            .contains(AttributeValue.builder().s("zorro@gmail.com").build());
      }
    }
    assert foundKnownValueItemQuery5;
  }
  public static void runQuery6(String ddbTableName, DynamoDbClient ddb) {
    // Query 6: Get tickets by email
    // Key condition: PK1=email SK1 > 30 days ago
    Map<String,String> query6AttributeNames = new HashMap<>();
    query6AttributeNames.put("#p", "PK1");
    query6AttributeNames.put("#s", "SK1");

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

    QueryResponse query6Response = ddb.query(query6Request);
    // Validate query was returned successfully
    assert 200 == query6Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned; only 1 item is expected until we add more items in PutRequests
    assert query6Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery6 = false;
    for (Map<String, AttributeValue> item : query6Response.items()) {
      if (item.get("partition_key").s().equals("ticket1")) {
        foundKnownValueItemQuery6 = true;
        assert item.get("TicketNumber").s().equals("ticket_001");
      }
    }
    assert foundKnownValueItemQuery6;
  }

}
