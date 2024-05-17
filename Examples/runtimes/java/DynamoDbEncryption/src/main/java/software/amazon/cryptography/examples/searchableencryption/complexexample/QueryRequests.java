package software.amazon.cryptography.examples.searchableencryption.complexexample;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;

/*
 * This file is used in an example to demonstrate complex queries
 * you can perform using beacons.
 * The example data used is for demonstrative purposes only,
 * and might not meet the distribution and correlation uniqueness
 * recommendations for beacons.
 * See our documentation for whether beacons are
 * right for your particular data set:
 * https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me
 *
 * This class implements query access patterns from our workshop.
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
    runQuery7(ddbTableName, ddb);
    runQuery8(ddbTableName, ddb);
    runQuery9(ddbTableName, ddb);
    runQuery10(ddbTableName, ddb);
    runQuery11(ddbTableName, ddb);
    runQuery12(ddbTableName, ddb);
    runQuery13(ddbTableName, ddb);
    runQuery14(ddbTableName, ddb);
    runQuery15(ddbTableName, ddb);
    runQuery16(ddbTableName, ddb);
    runQuery17(ddbTableName, ddb);
    runQuery18(ddbTableName, ddb);
    runQuery19(ddbTableName, ddb);
    runQuery20(ddbTableName, ddb);
    runQuery21(ddbTableName, ddb);
    runQuery22(ddbTableName, ddb);
    runQuery23(ddbTableName, ddb);
  }

  public static void runQuery1(String ddbTableName, DynamoDbClient ddb) {
    // Query 1: Get meetings by date and email
    // Key condition: PK1=email SK1 between(date1, date2)
    // Filter condition: duration > 0
    final Map<String, String> query1AttributeNames = new HashMap<>();
    query1AttributeNames.put("#pk1", "PK1");
    query1AttributeNames.put("#sk1", "SK1");
    query1AttributeNames.put("#duration", "Duration");

    final Map<String, AttributeValue> query1AttributeValues = new HashMap<>();
    query1AttributeValues.put(
      ":e",
      AttributeValue.builder().s("EE-able@gmail.com").build()
    );
    query1AttributeValues.put(
      ":date1",
      AttributeValue.builder().s("MS-2022-07-02").build()
    );
    query1AttributeValues.put(
      ":date2",
      AttributeValue.builder().s("MS-2022-07-08").build()
    );
    query1AttributeValues.put(":zero", AttributeValue.builder().s("0").build());

    final QueryRequest query1Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression("#pk1 = :e AND #sk1 BETWEEN :date1 AND :date2")
      .filterExpression("#duration > :zero")
      .expressionAttributeNames(query1AttributeNames)
      .expressionAttributeValues(query1AttributeValues)
      .build();

    final QueryResponse query1Response = ddb.query(query1Request);
    // Validate query was returned successfully
    assert 200 == query1Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `meeting1`
    assert query1Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery1 = false;
    for (Map<String, AttributeValue> item : query1Response.items()) {
      if (item.get("partition_key").s().equals("meeting1")) {
        foundKnownValueItemQuery1 = true;
        assert item.get("Subject").s().equals("Scan Beacons");
        assert item.get("Location").m().get("Floor").s().equals("12");
        assert item
          .get("Attendees")
          .l()
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
    query2AttributeNames.put("#pk", "PK");
    query2AttributeNames.put("#sk", "SK");
    query2AttributeNames.put("#duration", "Duration");

    Map<String, AttributeValue> query2AttributeValues = new HashMap<>();
    query2AttributeValues.put(
      ":employee",
      AttributeValue.builder().s("E-emp_001").build()
    );
    query2AttributeValues.put(
      ":date1",
      AttributeValue.builder().s("MS-2022-07-02").build()
    );
    query2AttributeValues.put(
      ":date2",
      AttributeValue.builder().s("MS-2022-07-08").build()
    );
    query2AttributeValues.put(":zero", AttributeValue.builder().s("0").build());

    QueryRequest query2Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression(
        "#pk = :employee AND #sk BETWEEN :date1 AND :date2"
      )
      .filterExpression("#duration > :zero")
      .expressionAttributeNames(query2AttributeNames)
      .expressionAttributeValues(query2AttributeValues)
      .build();

    QueryResponse query2Response = ddb.query(query2Request);
    // Validate query was returned successfully
    assert 200 == query2Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `meeting1`
    assert query2Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery2 = false;
    for (Map<String, AttributeValue> item : query2Response.items()) {
      if (item.get("partition_key").s().equals("meeting1")) {
        foundKnownValueItemQuery2 = true;
        assert item.get("Subject").s().equals("Scan Beacons");
        assert item.get("Location").m().get("Floor").s().equals("12");
        assert item
          .get("Attendees")
          .l()
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
    Map<String, String> query3AttributeNames = new HashMap<>();
    query3AttributeNames.put("#pk", "PK");
    query3AttributeNames.put("#sk", "SK");
    query3AttributeNames.put("#building", "Building");
    query3AttributeNames.put("#floor", "Floor");
    query3AttributeNames.put("#room", "Room");

    Map<String, AttributeValue> query3AttributeValues = new HashMap<>();
    query3AttributeValues.put(
      ":buildingbeacon",
      AttributeValue.builder().s("B-SEA33").build()
    );
    query3AttributeValues.put(
      ":building",
      AttributeValue.builder().s("SEA33").build()
    );
    query3AttributeValues.put(
      ":floor",
      AttributeValue.builder().s("12").build()
    );
    query3AttributeValues.put(
      ":room",
      AttributeValue.builder().s("403").build()
    );
    query3AttributeValues.put(
      ":date1",
      AttributeValue.builder().s("MS-2022-07-02").build()
    );
    query3AttributeValues.put(
      ":date2",
      AttributeValue.builder().s("MS-2022-07-08").build()
    );

    QueryRequest query3Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression(
        "#pk = :buildingbeacon AND #sk BETWEEN :date1 AND :date2"
      )
      .filterExpression(
        "#building = :building AND #floor = :floor AND #room = :room"
      )
      .expressionAttributeNames(query3AttributeNames)
      .expressionAttributeValues(query3AttributeValues)
      .build();

    QueryResponse query3Response = ddb.query(query3Request);
    // Validate query was returned successfully
    assert 200 == query3Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `reservation1`
    assert query3Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery3 = false;
    for (Map<String, AttributeValue> item : query3Response.items()) {
      if (item.get("partition_key").s().equals("reservation1")) {
        foundKnownValueItemQuery3 = true;
        assert item.get("Subject").s().equals("Scan beacons");
        assert item.get("Location").m().get("Building").s().equals("SEA33");
        assert item
          .get("Attendees")
          .l()
          .contains(AttributeValue.builder().s("barney@gmail.com").build());
      }
    }
    assert foundKnownValueItemQuery3;
  }

  public static void runQuery4(String ddbTableName, DynamoDbClient ddb) {
    // Query 4: Get employee data by email
    // Key condition: PK1=email SK1=employee ID
    Map<String, String> query4AttributeNames = new HashMap<>();
    query4AttributeNames.put("#pk1", "PK1");
    query4AttributeNames.put("#sk1", "SK1");

    Map<String, AttributeValue> query4AttributeValues = new HashMap<>();
    query4AttributeValues.put(
      ":email",
      AttributeValue.builder().s("EE-able@gmail.com").build()
    );
    query4AttributeValues.put(
      ":employee",
      AttributeValue.builder().s("E-emp_001").build()
    );

    QueryRequest query4Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression("#pk1 = :email AND #sk1 = :employee")
      .expressionAttributeNames(query4AttributeNames)
      .expressionAttributeValues(query4AttributeValues)
      .build();

    QueryResponse query4Response = ddb.query(query4Request);
    // Validate query was returned successfully
    assert 200 == query4Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `employee1`
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
    query5AttributeNames.put("#pk1", "PK1");
    query5AttributeNames.put("#sk1", "SK1");

    Map<String, AttributeValue> query5AttributeValues = new HashMap<>();
    query5AttributeValues.put(
      ":email",
      AttributeValue.builder().s("EE-able@gmail.com").build()
    );
    query5AttributeValues.put(
      ":thirtydaysago",
      AttributeValue.builder().s("MS-2023-03-20").build()
    );
    query5AttributeValues.put(
      ":prefix",
      AttributeValue.builder().s("MS-").build()
    );

    QueryRequest query5Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression(
        "#pk1 = :email AND #sk1 BETWEEN :prefix AND :thirtydaysago"
      )
      .expressionAttributeNames(query5AttributeNames)
      .expressionAttributeValues(query5AttributeValues)
      .build();

    QueryResponse query5Response = ddb.query(query5Request);
    // Validate query was returned successfully
    assert 200 == query5Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `meeting1`
    assert query5Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery5 = false;
    for (Map<String, AttributeValue> item : query5Response.items()) {
      if (item.get("partition_key").s().equals("meeting1")) {
        foundKnownValueItemQuery5 = true;
        assert item.get("Subject").s().equals("Scan Beacons");
        assert item.get("Location").m().get("Floor").s().equals("12");
        assert item
          .get("Attendees")
          .l()
          .contains(AttributeValue.builder().s("zorro@gmail.com").build());
      }
    }
    assert foundKnownValueItemQuery5;
  }

  public static void runQuery6(String ddbTableName, DynamoDbClient ddb) {
    // Query 6: Get tickets by email
    // Key condition: PK1=email SK1 > 30 days ago
    Map<String, String> query6AttributeNames = new HashMap<>();
    query6AttributeNames.put("#pk1", "PK1");
    query6AttributeNames.put("#sk1", "SK1");

    Map<String, AttributeValue> query6AttributeValues = new HashMap<>();
    query6AttributeValues.put(
      ":creatoremail",
      AttributeValue.builder().s("CE-zorro@gmail.com").build()
    );
    query6AttributeValues.put(
      ":thirtydaysago",
      AttributeValue.builder().s("MS-2023-03-20").build()
    );

    QueryRequest query6Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression("#pk1 = :creatoremail AND #sk1 < :thirtydaysago")
      .expressionAttributeNames(query6AttributeNames)
      .expressionAttributeValues(query6AttributeValues)
      .build();

    QueryResponse query6Response = ddb.query(query6Request);
    // Validate query was returned successfully
    assert 200 == query6Response.sdkHttpResponse().statusCode();

    // Assert 2 items returned:
    // Expected to be `ticket1` and `ticket3`
    assert query6Response.items().size() == 2;
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

  public static void runQuery7(String ddbTableName, DynamoDbClient ddb) {
    // Query 7: Get reservations by email
    // Key condition: PK1=organizeremail SK1 > 30 days ago
    Map<String, String> query7AttributeNames = new HashMap<>();
    query7AttributeNames.put("#pk1", "PK1");
    query7AttributeNames.put("#sk1", "SK1");

    Map<String, AttributeValue> query7AttributeValues = new HashMap<>();
    query7AttributeValues.put(
      ":organizeremail",
      AttributeValue.builder().s("OE-able@gmail.com").build()
    );
    query7AttributeValues.put(
      ":thirtydaysago",
      AttributeValue.builder().s("MS-2023-03-20").build()
    );

    QueryRequest query7Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression(
        "#pk1 = :organizeremail AND #sk1 < :thirtydaysago"
      )
      .expressionAttributeNames(query7AttributeNames)
      .expressionAttributeValues(query7AttributeValues)
      .build();

    QueryResponse query7Response = ddb.query(query7Request);
    // Validate query was returned successfully
    assert 200 == query7Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `reservation1`
    assert query7Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery7 = false;
    for (Map<String, AttributeValue> item : query7Response.items()) {
      if (item.get("partition_key").s().equals("reservation1")) {
        foundKnownValueItemQuery7 = true;
        assert item.get("Subject").s().equals("Scan beacons");
        assert item.get("Location").m().get("Floor").s().equals("12");
        assert item
          .get("Attendees")
          .l()
          .contains(AttributeValue.builder().s("barney@gmail.com").build());
      }
    }
    assert foundKnownValueItemQuery7;
  }

  public static void runQuery8(String ddbTableName, DynamoDbClient ddb) {
    // Query 8: Get time cards by email
    // Key condition: PK1=employeeemail SK1 > 30 days ago
    Map<String, String> query8AttributeNames = new HashMap<>();
    query8AttributeNames.put("#pk1", "PK1");
    query8AttributeNames.put("#sk1", "SK1");

    Map<String, AttributeValue> query8AttributeValues = new HashMap<>();
    query8AttributeValues.put(
      ":email",
      AttributeValue.builder().s("EE-able@gmail.com").build()
    );
    query8AttributeValues.put(
      ":prefix",
      AttributeValue.builder().s("TC-").build()
    );
    query8AttributeValues.put(
      ":thirtydaysago",
      AttributeValue.builder().s("TC-2023-03-20").build()
    );

    QueryRequest query8Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression(
        "#pk1 = :email AND #sk1 BETWEEN :prefix AND :thirtydaysago"
      )
      .expressionAttributeNames(query8AttributeNames)
      .expressionAttributeValues(query8AttributeValues)
      .build();

    QueryResponse query8Response = ddb.query(query8Request);
    // Validate query was returned successfully
    assert 200 == query8Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `timecard1`
    assert query8Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery8 = false;
    for (Map<String, AttributeValue> item : query8Response.items()) {
      if (item.get("partition_key").s().equals("timecard1")) {
        foundKnownValueItemQuery8 = true;
        assert item.get("ProjectName").s().equals("project_002");
      }
    }
    assert foundKnownValueItemQuery8;
  }

  public static void runQuery9(String ddbTableName, DynamoDbClient ddb) {
    // Query 9: Get employee info by employee ID
    // Key condition: PK1=employeeID SK starts with "E-"
    Map<String, String> query9AttributeNames = new HashMap<>();
    query9AttributeNames.put("#pk", "PK");
    query9AttributeNames.put("#sk", "SK");

    Map<String, AttributeValue> query9AttributeValues = new HashMap<>();
    query9AttributeValues.put(
      ":employee",
      AttributeValue.builder().s("E-emp_001").build()
    );
    query9AttributeValues.put(
      ":prefix",
      AttributeValue.builder().s("E-").build()
    );

    QueryRequest query9Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression("#pk = :employee AND begins_with(#sk, :prefix)")
      .expressionAttributeNames(query9AttributeNames)
      .expressionAttributeValues(query9AttributeValues)
      .build();

    QueryResponse query9Response = ddb.query(query9Request);
    // Validate query was returned successfully
    assert 200 == query9Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `employee1`
    assert query9Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery9 = false;
    for (Map<String, AttributeValue> item : query9Response.items()) {
      if (item.get("partition_key").s().equals("employee1")) {
        foundKnownValueItemQuery9 = true;
        assert item.get("EmployeeID").s().equals("emp_001");
      }
    }
    assert foundKnownValueItemQuery9;
  }

  public static void runQuery10(String ddbTableName, DynamoDbClient ddb) {
    // Query 10: Get employee info by email
    // Key condition: PK1=email
    // Filter condition: SK starts with "E-"
    Map<String, String> query10AttributeNames = new HashMap<>();
    query10AttributeNames.put("#pk1", "PK1");
    query10AttributeNames.put("#sk1", "SK1");

    Map<String, AttributeValue> query10AttributeValues = new HashMap<>();
    query10AttributeValues.put(
      ":email",
      AttributeValue.builder().s("EE-able@gmail.com").build()
    );
    query10AttributeValues.put(
      ":prefix",
      AttributeValue.builder().s("E-").build()
    );

    QueryRequest query10Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression("#pk1 = :email AND begins_with(#sk1, :prefix)")
      .expressionAttributeNames(query10AttributeNames)
      .expressionAttributeValues(query10AttributeValues)
      .build();

    QueryResponse query10Response = ddb.query(query10Request);
    // Validate query was returned successfully
    assert 200 == query10Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `employee1`
    assert query10Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery10 = false;
    for (Map<String, AttributeValue> item : query10Response.items()) {
      if (item.get("partition_key").s().equals("employee1")) {
        foundKnownValueItemQuery10 = true;
        assert item.get("EmployeeID").s().equals("emp_001");
      }
    }
    assert foundKnownValueItemQuery10;
  }

  public static void runQuery11(String ddbTableName, DynamoDbClient ddb) {
    // Query 11: Get ticket history by ticket number
    // Key condition: PK=TicketNumber
    Map<String, String> query11AttributeNames = new HashMap<>();
    query11AttributeNames.put("#pk", "PK");

    Map<String, AttributeValue> query11AttributeValues = new HashMap<>();
    query11AttributeValues.put(
      ":ticket",
      AttributeValue.builder().s("T-ticket_001").build()
    );

    QueryRequest query11Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression("#pk = :ticket")
      .expressionAttributeNames(query11AttributeNames)
      .expressionAttributeValues(query11AttributeValues)
      .build();

    QueryResponse query11Response = ddb.query(query11Request);
    // Validate query was returned successfully
    assert 200 == query11Response.sdkHttpResponse().statusCode();

    // Assert 2 items returned:
    // Expected to be `ticket1` and `ticket2`
    assert query11Response.items().size() == 2;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery11 = false;
    for (Map<String, AttributeValue> item : query11Response.items()) {
      if (item.get("partition_key").s().equals("ticket1")) {
        foundKnownValueItemQuery11 = true;
        assert item.get("TicketNumber").s().equals("ticket_001");
      }
    }
    assert foundKnownValueItemQuery11;
  }

  public static void runQuery12(String ddbTableName, DynamoDbClient ddb) {
    // Query 12: Get Ticket History by employee email
    // Key condition: PK1=CreatorEmail
    // Filter condition: PK=TicketNumber
    Map<String, String> query12AttributeNames = new HashMap<>();
    query12AttributeNames.put("#pk1", "PK1");
    query12AttributeNames.put("#pk", "PK");

    Map<String, AttributeValue> query12AttributeValues = new HashMap<>();
    query12AttributeValues.put(
      ":email",
      AttributeValue.builder().s("CE-zorro@gmail.com").build()
    );
    query12AttributeValues.put(
      ":ticket",
      AttributeValue.builder().s("T-ticket_001").build()
    );

    QueryRequest query12Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression("#pk1 = :email")
      .filterExpression("#pk = :ticket")
      .expressionAttributeNames(query12AttributeNames)
      .expressionAttributeValues(query12AttributeValues)
      .build();

    QueryResponse query12Response = ddb.query(query12Request);
    // Validate query was returned successfully
    assert 200 == query12Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `ticket1`
    assert query12Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery12 = false;
    for (Map<String, AttributeValue> item : query12Response.items()) {
      if (item.get("partition_key").s().equals("ticket1")) {
        foundKnownValueItemQuery12 = true;
        assert item.get("TicketNumber").s().equals("ticket_001");
      }
    }
    assert foundKnownValueItemQuery12;
  }

  public static void runQuery13(String ddbTableName, DynamoDbClient ddb) {
    // Query 13: Get ticket history by assignee email
    // Key condition: PK=AssigneeEmail
    // Filter condition: PK=ticketNumber
    Map<String, String> query13AttributeNames = new HashMap<>();
    query13AttributeNames.put("#pk2", "PK2");
    query13AttributeNames.put("#pk", "PK");

    Map<String, AttributeValue> query13AttributeValues = new HashMap<>();
    query13AttributeValues.put(
      ":assigneeemail",
      AttributeValue.builder().s("AE-able@gmail.com").build()
    );
    query13AttributeValues.put(
      ":ticket",
      AttributeValue.builder().s("T-ticket_001").build()
    );

    QueryRequest query13Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-2")
      .keyConditionExpression("#pk2 = :assigneeemail")
      .filterExpression("#pk = :ticket")
      .expressionAttributeNames(query13AttributeNames)
      .expressionAttributeValues(query13AttributeValues)
      .build();

    QueryResponse query13Response = ddb.query(query13Request);
    // Validate query was returned successfully
    assert 200 == query13Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `ticket1`
    assert query13Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery13 = false;
    for (Map<String, AttributeValue> item : query13Response.items()) {
      if (item.get("partition_key").s().equals("ticket1")) {
        foundKnownValueItemQuery13 = true;
        assert item.get("Subject").s().equals("Bad bug");
      }
    }
    assert foundKnownValueItemQuery13;
  }

  public static void runQuery14(String ddbTableName, DynamoDbClient ddb) {
    // Query 14: Get employees by city.building.floor.desk
    // Key condition: PK3=city SK3 begins_with(building.floor.desk)
    Map<String, String> query14AttributeNames = new HashMap<>();
    query14AttributeNames.put("#pk3", "PK3");
    query14AttributeNames.put("#sk3", "SK3");

    Map<String, AttributeValue> query14AttributeValues = new HashMap<>();
    query14AttributeValues.put(
      ":city",
      AttributeValue.builder().s("C-Seattle").build()
    );
    query14AttributeValues.put(
      ":location",
      AttributeValue.builder().s("B-44~F-12~D-3").build()
    );

    QueryRequest query14Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-3")
      .keyConditionExpression("#pk3 = :city AND begins_with(#sk3, :location)")
      .expressionAttributeNames(query14AttributeNames)
      .expressionAttributeValues(query14AttributeValues)
      .build();

    // GSIs do not update instantly
    // so if the results come back empty
    // we retry after a short sleep
    for (int i = 0; i < 10; ++i) {
      QueryResponse query14Response = ddb.query(query14Request);
      // Validate query was returned successfully
      assert 200 == query14Response.sdkHttpResponse().statusCode();

      // if no results, sleep and try again
      if (query14Response.items().size() == 0) {
        try {
          Thread.sleep(20);
        } catch (Exception e) {}
        continue;
      }

      // Assert 1 item was returned: `employee1`
      assert query14Response.items().size() == 1;
      // Known value test: Assert some properties on one of the items
      boolean foundKnownValueItemQuery14 = false;
      for (Map<String, AttributeValue> item : query14Response.items()) {
        if (item.get("partition_key").s().equals("employee1")) {
          foundKnownValueItemQuery14 = true;
          assert item.get("EmployeeID").s().equals("emp_001");
          assert item.get("Location").m().get("Desk").s().equals("3");
        }
      }
      assert foundKnownValueItemQuery14;
      break;
    }
  }

  public static void runQuery15(String ddbTableName, DynamoDbClient ddb) {
    // Query 15: Get employees by manager email
    // Key condition: PK2 = ManagerEmail
    Map<String, String> query15AttributeNames = new HashMap<>();
    query15AttributeNames.put("#pk2", "PK2");

    Map<String, AttributeValue> query15AttributeValues = new HashMap<>();
    query15AttributeValues.put(
      ":manageremail",
      AttributeValue.builder().s("ME-zorro@gmail.com").build()
    );

    QueryRequest query15Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-2")
      .keyConditionExpression("#pk2 = :manageremail")
      .expressionAttributeNames(query15AttributeNames)
      .expressionAttributeValues(query15AttributeValues)
      .build();

    QueryResponse query15Response = ddb.query(query15Request);
    // Validate query was returned successfully
    assert 200 == query15Response.sdkHttpResponse().statusCode();

    // Assert 4 items returned:
    // Expected to be `employee1`, `employee2`, `employee3`, and `employee4`
    assert query15Response.items().size() == 4;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery15 = false;
    for (Map<String, AttributeValue> item : query15Response.items()) {
      if (item.get("partition_key").s().equals("employee1")) {
        foundKnownValueItemQuery15 = true;
        assert item.get("EmployeeID").s().equals("emp_001");
        assert item.get("Location").m().get("Desk").s().equals("3");
      }
    }
    assert foundKnownValueItemQuery15;
  }

  public static void runQuery16(String ddbTableName, DynamoDbClient ddb) {
    // Query 16: Get assigned tickets by assignee email
    // Key condition: PK2 = AssigneeEmail
    Map<String, String> query16AttributeNames = new HashMap<>();
    query16AttributeNames.put("#pk2", "PK2");

    Map<String, AttributeValue> query16AttributeValues = new HashMap<>();
    query16AttributeValues.put(
      ":assigneeemail",
      AttributeValue.builder().s("AE-able@gmail.com").build()
    );

    QueryRequest query16Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-2")
      .keyConditionExpression("#pk2 = :assigneeemail")
      .expressionAttributeNames(query16AttributeNames)
      .expressionAttributeValues(query16AttributeValues)
      .build();

    QueryResponse query16Response = ddb.query(query16Request);
    // Validate query was returned successfully
    assert 200 == query16Response.sdkHttpResponse().statusCode();

    // Assert 2 items returned:
    // Expected to be `ticket1` and `ticket4`
    assert query16Response.items().size() == 2;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery16 = false;
    for (Map<String, AttributeValue> item : query16Response.items()) {
      if (item.get("partition_key").s().equals("ticket1")) {
        foundKnownValueItemQuery16 = true;
        assert item.get("TicketNumber").s().equals("ticket_001");
      }
    }
    assert foundKnownValueItemQuery16;
  }

  public static void runQuery17(String ddbTableName, DynamoDbClient ddb) {
    // Query 17: Get tickets updated within the last 24 hours
    // Key condition: PK3 = Severity, SK3 > 24 hours ago
    // (For the sake of this example, we will assume
    //  the date is 2022-10-08T09:30:00, such that "24 hours ago"
    //  is 2022-10-07T09:30:00, and that our sample ticket record
    //  with TicketModTime=2022-10-07T14:32:25 will be returned.)
    Map<String, String> query17AttributeNames = new HashMap<>();
    query17AttributeNames.put("#pk3", "PK3");
    query17AttributeNames.put("#sk3", "SK3");

    Map<String, AttributeValue> query17AttributeValues = new HashMap<>();
    query17AttributeValues.put(
      ":severity",
      AttributeValue.builder().s("S-3").build()
    );
    query17AttributeValues.put(
      ":yesterday",
      AttributeValue.builder().s("M-2022-10-07T09:30:00").build()
    );

    QueryRequest query17Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-3")
      .keyConditionExpression("#pk3 = :severity AND #sk3 > :yesterday")
      .expressionAttributeNames(query17AttributeNames)
      .expressionAttributeValues(query17AttributeValues)
      .build();

    QueryResponse query17Response = ddb.query(query17Request);
    // Validate query was returned successfully
    assert 200 == query17Response.sdkHttpResponse().statusCode();

    // Assert 3 items returned:
    // Expected to be `ticket1`, `ticket2`, and `ticket4`
    assert query17Response.items().size() == 3;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery17 = false;
    for (Map<String, AttributeValue> item : query17Response.items()) {
      if (item.get("partition_key").s().equals("ticket1")) {
        foundKnownValueItemQuery17 = true;
        assert item.get("TicketNumber").s().equals("ticket_001");
      }
    }
    assert foundKnownValueItemQuery17;
  }

  public static void runQuery18(String ddbTableName, DynamoDbClient ddb) {
    // Query 18: Get projects by status, start and target date
    // Key condition: PK1 = Status, SK1 > StartDate
    // Filter condition: TargetDelivery < TargetDate
    Map<String, String> query18AttributeNames = new HashMap<>();
    query18AttributeNames.put("#pk1", "PK1");
    query18AttributeNames.put("#sk1", "SK1");
    query18AttributeNames.put("#target", "ProjectTarget");

    Map<String, AttributeValue> query18AttributeValues = new HashMap<>();
    query18AttributeValues.put(
      ":status",
      AttributeValue.builder().s("PSts-Pending").build()
    );
    query18AttributeValues.put(
      ":startdate",
      AttributeValue.builder().s("PS-2022-01-01").build()
    );
    query18AttributeValues.put(
      ":target",
      AttributeValue.builder().s("2025-01-01").build()
    );

    QueryRequest query18Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-1")
      .keyConditionExpression("#pk1 = :status AND #sk1 > :startdate")
      .filterExpression("#target < :target")
      .expressionAttributeNames(query18AttributeNames)
      .expressionAttributeValues(query18AttributeValues)
      .build();

    QueryResponse query18Response = ddb.query(query18Request);
    // Validate query was returned successfully
    assert 200 == query18Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `project1`
    assert query18Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery18 = false;
    for (Map<String, AttributeValue> item : query18Response.items()) {
      if (item.get("partition_key").s().equals("project1")) {
        foundKnownValueItemQuery18 = true;
        assert item.get("ProjectName").s().equals("project_001");
      }
    }
    assert foundKnownValueItemQuery18;
  }

  public static void runQuery19(String ddbTableName, DynamoDbClient ddb) {
    // Query 19: Get projects by name
    // Key condition: PK = ProjectName, SK = ProjectName
    Map<String, String> query19AttributeNames = new HashMap<>();
    query19AttributeNames.put("#pk", "PK");
    query19AttributeNames.put("#sk", "SK");

    Map<String, AttributeValue> query19AttributeValues = new HashMap<>();
    query19AttributeValues.put(
      ":projectname",
      AttributeValue.builder().s("P-project_001").build()
    );

    QueryRequest query19Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression("#pk = :projectname AND #sk = :projectname")
      .expressionAttributeNames(query19AttributeNames)
      .expressionAttributeValues(query19AttributeValues)
      .build();

    QueryResponse query19Response = ddb.query(query19Request);
    // Validate query was returned successfully
    assert 200 == query19Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `project1`
    assert query19Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery19 = false;
    for (Map<String, AttributeValue> item : query19Response.items()) {
      if (item.get("partition_key").s().equals("project1")) {
        foundKnownValueItemQuery19 = true;
        assert item.get("ProjectName").s().equals("project_001");
      }
    }
    assert foundKnownValueItemQuery19;
  }

  public static void runQuery20(String ddbTableName, DynamoDbClient ddb) {
    // Query 20: Get Project History by date range (against timecard record)
    // Key condition: PK = ProjectName, SK between(date1, date2)
    Map<String, String> query20AttributeNames = new HashMap<>();
    query20AttributeNames.put("#pk", "PK");
    query20AttributeNames.put("#sk", "SK");

    Map<String, AttributeValue> query20AttributeValues = new HashMap<>();
    query20AttributeValues.put(
      ":projectname",
      AttributeValue.builder().s("P-project_002").build()
    );
    query20AttributeValues.put(
      ":date1",
      AttributeValue.builder().s("TC-2022-01-01").build()
    );
    query20AttributeValues.put(
      ":date2",
      AttributeValue.builder().s("TC-2023-01-01").build()
    );

    QueryRequest query20Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression(
        "#pk = :projectname AND #sk BETWEEN :date1 AND :date2"
      )
      .expressionAttributeNames(query20AttributeNames)
      .expressionAttributeValues(query20AttributeValues)
      .build();

    QueryResponse query20Response = ddb.query(query20Request);
    // Validate query was returned successfully
    assert 200 == query20Response.sdkHttpResponse().statusCode();

    // Assert 2 items returned:
    // Expected to be `timecard1` and `timecard2`
    assert query20Response.items().size() == 2;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery20 = false;
    for (Map<String, AttributeValue> item : query20Response.items()) {
      if (item.get("partition_key").s().equals("timecard1")) {
        foundKnownValueItemQuery20 = true;
        assert item.get("ProjectName").s().equals("project_002");
      }
    }
    assert foundKnownValueItemQuery20;
  }

  public static void runQuery21(String ddbTableName, DynamoDbClient ddb) {
    // Query 21: Get Project History by role
    // Key condition: PK = ProjectName
    // Filter condition: role=rolename
    Map<String, String> query21AttributeNames = new HashMap<>();
    query21AttributeNames.put("#pk", "PK");
    query21AttributeNames.put("#role", "Role");

    Map<String, AttributeValue> query21AttributeValues = new HashMap<>();
    query21AttributeValues.put(
      ":projectname",
      AttributeValue.builder().s("P-project_002").build()
    );
    query21AttributeValues.put(
      ":role",
      AttributeValue.builder().s("SDE3").build()
    );

    QueryRequest query21Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression("#pk = :projectname")
      .filterExpression("#role = :role")
      .expressionAttributeNames(query21AttributeNames)
      .expressionAttributeValues(query21AttributeValues)
      .build();

    QueryResponse query21Response = ddb.query(query21Request);
    // Validate query was returned successfully
    assert 200 == query21Response.sdkHttpResponse().statusCode();

    // Assert 1 item was returned: `timecard1`
    assert query21Response.items().size() == 1;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery21 = false;
    for (Map<String, AttributeValue> item : query21Response.items()) {
      if (item.get("partition_key").s().equals("timecard1")) {
        foundKnownValueItemQuery21 = true;
        assert item.get("ProjectName").s().equals("project_002");
      }
    }
    assert foundKnownValueItemQuery21;
  }

  public static void runQuery22(String ddbTableName, DynamoDbClient ddb) {
    // Query 22: Get reservations by building ID
    // Key condition: PK = Building ID
    Map<String, String> query22AttributeNames = new HashMap<>();
    query22AttributeNames.put("#pk", "PK");

    Map<String, AttributeValue> query22AttributeValues = new HashMap<>();
    query22AttributeValues.put(
      ":building",
      AttributeValue.builder().s("B-SEA33").build()
    );

    QueryRequest query22Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression("#pk = :building")
      .expressionAttributeNames(query22AttributeNames)
      .expressionAttributeValues(query22AttributeValues)
      .build();

    QueryResponse query22Response = ddb.query(query22Request);
    // Validate query was returned successfully
    assert 200 == query22Response.sdkHttpResponse().statusCode();

    // Assert 2 items returned:
    // Expected to be `reservation1` and `reservation2`
    assert query22Response.items().size() == 2;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery22 = false;
    for (Map<String, AttributeValue> item : query22Response.items()) {
      if (item.get("partition_key").s().equals("reservation1")) {
        foundKnownValueItemQuery22 = true;
        assert item.get("Subject").s().equals("Scan beacons");
      }
    }
    assert foundKnownValueItemQuery22;
  }

  public static void runQuery23(String ddbTableName, DynamoDbClient ddb) {
    // Query 23: Get reservations by building ID and time range
    // Key condition: PK = Building ID, SK between(date1, date2)
    // Filter condition: Duration > 0
    Map<String, String> query23AttributeNames = new HashMap<>();
    query23AttributeNames.put("#pk", "PK");
    query23AttributeNames.put("#sk", "SK");
    query23AttributeNames.put("#duration", "Duration");

    Map<String, AttributeValue> query23AttributeValues = new HashMap<>();
    query23AttributeValues.put(
      ":building",
      AttributeValue.builder().s("B-SEA33").build()
    );
    query23AttributeValues.put(
      ":date1",
      AttributeValue.builder().s("MS-2022-07-01").build()
    );
    query23AttributeValues.put(
      ":date2",
      AttributeValue.builder().s("MS-2022-07-08").build()
    );
    query23AttributeValues.put(
      ":zero",
      AttributeValue.builder().s("0").build()
    );

    QueryRequest query23Request = QueryRequest
      .builder()
      .tableName(ddbTableName)
      .indexName("GSI-0")
      .keyConditionExpression(
        "#pk = :building AND #sk BETWEEN :date1 AND :date2"
      )
      .filterExpression("#duration > :zero")
      .expressionAttributeNames(query23AttributeNames)
      .expressionAttributeValues(query23AttributeValues)
      .build();

    QueryResponse query23Response = ddb.query(query23Request);
    // Validate query was returned successfully
    assert 200 == query23Response.sdkHttpResponse().statusCode();

    // Assert 2 items returned:
    // Expected to be `reservation1` and `reservation2`
    assert query23Response.items().size() == 2;
    // Known value test: Assert some properties on one of the items
    boolean foundKnownValueItemQuery23 = false;
    for (Map<String, AttributeValue> item : query23Response.items()) {
      if (item.get("partition_key").s().equals("reservation1")) {
        foundKnownValueItemQuery23 = true;
        assert item.get("Subject").s().equals("Scan beacons");
      }
    }
    assert foundKnownValueItemQuery23;
  }
}
