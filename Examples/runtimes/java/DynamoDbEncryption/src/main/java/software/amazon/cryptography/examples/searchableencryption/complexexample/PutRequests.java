package software.amazon.cryptography.examples.searchableencryption.complexexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

/*
 * This class implements PutItem calls to populate a DDB table with items from
 * https://github.com/aws-samples/searchable-encryption-dynamodb-howto/blob/main/BeaconPOC/plain_json
 * By providing a DynamoDbClient that is configured to use searchable encryption,
 *   this class will encrypt the data client side and add beacon attributes to the items.
 * This only implements a single item of each of the 6 record types from Demo.md. Adding the remaining
 *   items would extend the test and example coverage.
 */

public class PutRequests {

  public static void putAllItemsToTable(String ddbTableName, DynamoDbClient ddb) {
    putAllMeetingItemsToTable(ddbTableName, ddb);
    putAllEmployeeItemsToTable(ddbTableName, ddb);
    putAllProjectItemsToTable(ddbTableName, ddb);
    putAllReservationItemsToTable(ddbTableName, ddb);
    putAllTicketItemsToTable(ddbTableName, ddb);
    putAllTimecardItemsToTable(ddbTableName, ddb);
  }

  // emeeting.json
  public static void putAllMeetingItemsToTable(String ddbTableName, DynamoDbClient ddb) {
    final List<AttributeValue> meeting1AttendeeList = new ArrayList<>();
    meeting1AttendeeList.add(AttributeValue.builder().s("able@gmail.com").build());
    meeting1AttendeeList.add(AttributeValue.builder().s("zorro@gmail.com").build());

    final HashMap<String, AttributeValue> meeting1Location = new HashMap<>();
    meeting1Location.put("Floor", AttributeValue.builder().s("12").build());
    meeting1Location.put("Room", AttributeValue.builder().s("403").build());

    final HashMap<String, AttributeValue> meeting1 = new HashMap<>();
    meeting1.put("partition_key", AttributeValue.builder().s("meeting1").build());
    meeting1.put("EmployeeID", AttributeValue.builder().s("emp_001").build());
    meeting1.put("EmployeeEmail", AttributeValue.builder().s("able@gmail.com").build());
    meeting1.put("MeetingStart", AttributeValue.builder().s("2022-07-04T13:00").build());
    meeting1.put("Location", AttributeValue.builder().m(meeting1Location).build());
    meeting1.put("Duration", AttributeValue.builder().s("30").build());
    meeting1.put("Attendees", AttributeValue.builder().l(meeting1AttendeeList).build());
    meeting1.put("Subject", AttributeValue.builder().s("Scan Beacons").build());

    ddb.putItem(PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(meeting1)
        .build()
    );
  }

  // employee.json
  public static void putAllEmployeeItemsToTable(String ddbTableName, DynamoDbClient ddb) {
    final HashMap<String, AttributeValue> employee1Location = new HashMap<>();
    employee1Location.put("Building", AttributeValue.builder().s("44").build());
    employee1Location.put("Floor", AttributeValue.builder().s("12").build());
    employee1Location.put("Desk", AttributeValue.builder().s("3").build());
    employee1Location.put("City", AttributeValue.builder().s("Seattle").build());

    final HashMap<String, AttributeValue> employee1 = new HashMap<>();
    employee1.put("partition_key", AttributeValue.builder().s("employee1").build());
    employee1.put("EmployeeID", AttributeValue.builder().s("emp_001").build());
    employee1.put("EmployeeEmail", AttributeValue.builder().s("able@gmail.com").build());
    employee1.put("ManagerEmail", AttributeValue.builder().s("zorro@gmail.com").build());
    employee1.put("EmployeeName", AttributeValue.builder().s("Able Jones").build());
    employee1.put("EmployeeTitle", AttributeValue.builder().s("SDE9").build());
    employee1.put("Location", AttributeValue.builder().m(employee1Location).build());

    ddb.putItem(PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(employee1)
        .build()
    );
  }

  // project.json
  public static void putAllProjectItemsToTable(String ddbTableName, DynamoDbClient ddb) {
    final HashMap<String, AttributeValue> project1 = new HashMap<>();
    project1.put("partition_key", AttributeValue.builder().s("project1").build());
    project1.put("ProjectName", AttributeValue.builder().s("project_001").build());
    project1.put("ProjectStatus", AttributeValue.builder().s("Pending").build());
    project1.put("ProjectStart", AttributeValue.builder().s("2022-11-01").build());
    project1.put("Description", AttributeValue.builder().s("Turbo Crypto").build());
    project1.put("ProjectTarget", AttributeValue.builder().s("2024-01-01").build());

    ddb.putItem(PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(project1)
        .build()
    );
  }

  // reservation.json
  public static void putAllReservationItemsToTable(String ddbTableName, DynamoDbClient ddb) {
    final List<AttributeValue> reservation1AttendeeList = new ArrayList<>();
    reservation1AttendeeList.add(AttributeValue.builder().s("able@gmail.com").build());
    reservation1AttendeeList.add(AttributeValue.builder().s("betty@gmail.com").build());

    final HashMap<String, AttributeValue> reservation1Location = new HashMap<>();
    reservation1Location.put("Building", AttributeValue.builder().s("SEA33").build());
    reservation1Location.put("Floor", AttributeValue.builder().s("12").build());
    reservation1Location.put("Room", AttributeValue.builder().s("403").build());

    final HashMap<String, AttributeValue> reservation1 = new HashMap<>();
    reservation1.put("partition_key", AttributeValue.builder().s("reservation1").build());
    reservation1.put("Location", AttributeValue.builder().m(reservation1Location).build());
    reservation1.put("MeetingStart", AttributeValue.builder().s("2022-07-04T13:00").build());
    reservation1.put("OrganizerEmail", AttributeValue.builder().s("able@gmail.com").build());
    reservation1.put("Duration", AttributeValue.builder().s("30").build());
    reservation1.put("Attendees", AttributeValue.builder().l(reservation1AttendeeList).build());
    reservation1.put("Subject", AttributeValue.builder().s("Scan beacons").build());

    ddb.putItem(PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(reservation1)
        .build()
    );
  }

  // ticket.json
  public static void putAllTicketItemsToTable(String ddbTableName, DynamoDbClient ddb) {
    final HashMap<String, AttributeValue> ticket1 = new HashMap<>();
    ticket1.put("partition_key", AttributeValue.builder().s("ticket1").build());
    ticket1.put("TicketNumber", AttributeValue.builder().s("ticket_001").build());
    ticket1.put("TicketModTime", AttributeValue.builder().s("2022-10-07T14:32:25").build());
    ticket1.put("CreatorEmail", AttributeValue.builder().s("zorro@gmail.com").build());
    ticket1.put("AssigneeEmail", AttributeValue.builder().s("able@gmail.com").build());
    ticket1.put("Severity", AttributeValue.builder().s("3").build());
    ticket1.put("Subject", AttributeValue.builder().s("Bad bug").build());
    ticket1.put("Message", AttributeValue.builder().s("This bug looks pretty bad").build());

    ddb.putItem(PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(ticket1)
        .build()
    );
  }

  // timecard.json
  public static void putAllTimecardItemsToTable(String ddbTableName, DynamoDbClient ddb) {
    final HashMap<String, AttributeValue> timecard1 = new HashMap<>();
    timecard1.put("partition_key", AttributeValue.builder().s("timecard1").build());
    timecard1.put("ProjectName", AttributeValue.builder().s("project_002").build());
    timecard1.put("TimeCardStart", AttributeValue.builder().s("2022-09-12").build());
    timecard1.put("EmployeeEmail", AttributeValue.builder().s("able@gmail.com").build());
    timecard1.put("Hours", AttributeValue.builder().s("40").build());
    timecard1.put("Role", AttributeValue.builder().s("SDE3").build());

    ddb.putItem(PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(timecard1)
        .build()
    );
  }

}
