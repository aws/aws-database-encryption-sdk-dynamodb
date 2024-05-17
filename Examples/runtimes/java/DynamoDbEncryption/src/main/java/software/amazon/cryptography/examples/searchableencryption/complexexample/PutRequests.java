package software.amazon.cryptography.examples.searchableencryption.complexexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

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
 * This class implements PutItem calls to populate a DDB table with items from our workshop.
 * By providing a DynamoDbClient that is configured to use searchable encryption,
 *   this class will encrypt the data client side and add beacon attributes to the items.
 * This only implements a single item of each of the 6 record types from Demo.md. Adding the remaining
 *   items would extend the test and example coverage.
 */

public class PutRequests {

  public static void putAllItemsToTable(
    String ddbTableName,
    DynamoDbClient ddb
  ) {
    putAllMeetingItemsToTable(ddbTableName, ddb);
    putAllEmployeeItemsToTable(ddbTableName, ddb);
    putAllProjectItemsToTable(ddbTableName, ddb);
    putAllReservationItemsToTable(ddbTableName, ddb);
    putAllTicketItemsToTable(ddbTableName, ddb);
    putAllTimecardItemsToTable(ddbTableName, ddb);
  }

  // emeeting.json
  public static void putAllMeetingItemsToTable(
    String ddbTableName,
    DynamoDbClient ddb
  ) {
    final List<AttributeValue> meeting1AttendeeList = new ArrayList<>();
    meeting1AttendeeList.add(
      AttributeValue.builder().s("able@gmail.com").build()
    );
    meeting1AttendeeList.add(
      AttributeValue.builder().s("zorro@gmail.com").build()
    );

    final HashMap<String, AttributeValue> meeting1Location = new HashMap<>();
    meeting1Location.put("Floor", AttributeValue.builder().s("12").build());
    meeting1Location.put("Room", AttributeValue.builder().s("403").build());

    final HashMap<String, AttributeValue> meeting1 = new HashMap<>();
    meeting1.put(
      "partition_key",
      AttributeValue.builder().s("meeting1").build()
    );
    meeting1.put("EmployeeID", AttributeValue.builder().s("emp_001").build());
    meeting1.put(
      "EmployeeEmail",
      AttributeValue.builder().s("able@gmail.com").build()
    );
    meeting1.put(
      "MeetingStart",
      AttributeValue.builder().s("2022-07-04T13:00").build()
    );
    meeting1.put(
      "Location",
      AttributeValue.builder().m(meeting1Location).build()
    );
    meeting1.put("Duration", AttributeValue.builder().s("30").build());
    meeting1.put(
      "Attendees",
      AttributeValue.builder().l(meeting1AttendeeList).build()
    );
    meeting1.put("Subject", AttributeValue.builder().s("Scan Beacons").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(meeting1).build()
    );

    final List<AttributeValue> meeting2AttendeeList = new ArrayList<>();
    meeting2AttendeeList.add(
      AttributeValue.builder().s("barney@gmail.com").build()
    );
    meeting2AttendeeList.add(
      AttributeValue.builder().s("zorro@gmail.com").build()
    );

    final HashMap<String, AttributeValue> meeting2Location = new HashMap<>();
    meeting2Location.put("Floor", AttributeValue.builder().s("12").build());
    meeting2Location.put("Room", AttributeValue.builder().s("403").build());

    final HashMap<String, AttributeValue> meeting2 = new HashMap<>();
    meeting2.put(
      "partition_key",
      AttributeValue.builder().s("meeting2").build()
    );
    meeting2.put("EmployeeID", AttributeValue.builder().s("emp_002").build());
    meeting2.put(
      "EmployeeEmail",
      AttributeValue.builder().s("barney@gmail.com").build()
    );
    meeting2.put(
      "MeetingStart",
      AttributeValue.builder().s("2022-07-04T13:00").build()
    );
    meeting2.put(
      "Location",
      AttributeValue.builder().m(meeting2Location).build()
    );
    meeting2.put("Duration", AttributeValue.builder().s("30").build());
    meeting2.put(
      "Attendees",
      AttributeValue.builder().l(meeting2AttendeeList).build()
    );
    meeting2.put("Subject", AttributeValue.builder().s("Scan Beacons").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(meeting2).build()
    );

    final List<AttributeValue> meeting3AttendeeList = new ArrayList<>();
    meeting3AttendeeList.add(
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    meeting3AttendeeList.add(
      AttributeValue.builder().s("zorro@gmail.com").build()
    );

    final HashMap<String, AttributeValue> meeting3Location = new HashMap<>();
    meeting3Location.put("Floor", AttributeValue.builder().s("12").build());
    meeting3Location.put("Room", AttributeValue.builder().s("403").build());

    final HashMap<String, AttributeValue> meeting3 = new HashMap<>();
    meeting3.put(
      "partition_key",
      AttributeValue.builder().s("meeting3").build()
    );
    meeting3.put("EmployeeID", AttributeValue.builder().s("emp_003").build());
    meeting3.put(
      "EmployeeEmail",
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    meeting3.put(
      "MeetingStart",
      AttributeValue.builder().s("2022-07-04T13:00").build()
    );
    meeting3.put(
      "Location",
      AttributeValue.builder().m(meeting3Location).build()
    );
    meeting3.put("Duration", AttributeValue.builder().s("30").build());
    meeting3.put(
      "Attendees",
      AttributeValue.builder().l(meeting3AttendeeList).build()
    );
    meeting3.put("Subject", AttributeValue.builder().s("Scan Beacons").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(meeting3).build()
    );

    final List<AttributeValue> meeting4AttendeeList = new ArrayList<>();
    meeting4AttendeeList.add(
      AttributeValue.builder().s("david@gmail.com").build()
    );
    meeting4AttendeeList.add(
      AttributeValue.builder().s("zorro@gmail.com").build()
    );

    final HashMap<String, AttributeValue> meeting4Location = new HashMap<>();
    meeting4Location.put("Floor", AttributeValue.builder().s("12").build());
    meeting4Location.put("Room", AttributeValue.builder().s("403").build());

    final HashMap<String, AttributeValue> meeting4 = new HashMap<>();
    meeting4.put(
      "partition_key",
      AttributeValue.builder().s("meeting4").build()
    );
    meeting4.put("EmployeeID", AttributeValue.builder().s("emp_004").build());
    meeting4.put(
      "EmployeeEmail",
      AttributeValue.builder().s("david@gmail.com").build()
    );
    meeting4.put(
      "MeetingStart",
      AttributeValue.builder().s("2022-07-04T13:00").build()
    );
    meeting4.put(
      "Location",
      AttributeValue.builder().m(meeting4Location).build()
    );
    meeting4.put("Duration", AttributeValue.builder().s("30").build());
    meeting4.put(
      "Attendees",
      AttributeValue.builder().l(meeting4AttendeeList).build()
    );
    meeting4.put("Subject", AttributeValue.builder().s("Scan Beacons").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(meeting4).build()
    );

    final List<AttributeValue> meeting5AttendeeList = new ArrayList<>();
    meeting5AttendeeList.add(
      AttributeValue.builder().s("barney@gmail.com").build()
    );
    meeting5AttendeeList.add(
      AttributeValue.builder().s("zorro@gmail.com").build()
    );

    final HashMap<String, AttributeValue> meeting5Location = new HashMap<>();
    meeting5Location.put("Floor", AttributeValue.builder().s("12").build());
    meeting5Location.put("Room", AttributeValue.builder().s("407").build());

    final HashMap<String, AttributeValue> meeting5 = new HashMap<>();
    meeting5.put(
      "partition_key",
      AttributeValue.builder().s("meeting5").build()
    );
    meeting5.put("EmployeeID", AttributeValue.builder().s("emp_002").build());
    meeting5.put(
      "EmployeeEmail",
      AttributeValue.builder().s("barney@gmail.com").build()
    );
    meeting5.put(
      "MeetingStart",
      AttributeValue.builder().s("2022-07-04T14:00").build()
    );
    meeting5.put(
      "Location",
      AttributeValue.builder().m(meeting5Location).build()
    );
    meeting5.put("Duration", AttributeValue.builder().s("30").build());
    meeting5.put(
      "Attendees",
      AttributeValue.builder().l(meeting5AttendeeList).build()
    );
    meeting5.put("Subject", AttributeValue.builder().s("DB ESDK").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(meeting5).build()
    );

    final List<AttributeValue> meeting6AttendeeList = new ArrayList<>();
    meeting6AttendeeList.add(
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    meeting6AttendeeList.add(
      AttributeValue.builder().s("zorro@gmail.com").build()
    );

    final HashMap<String, AttributeValue> meeting6Location = new HashMap<>();
    meeting6Location.put("Floor", AttributeValue.builder().s("12").build());
    meeting6Location.put("Room", AttributeValue.builder().s("407").build());

    final HashMap<String, AttributeValue> meeting6 = new HashMap<>();
    meeting6.put(
      "partition_key",
      AttributeValue.builder().s("meeting6").build()
    );
    meeting6.put("EmployeeID", AttributeValue.builder().s("emp_003").build());
    meeting6.put(
      "EmployeeEmail",
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    meeting6.put(
      "MeetingStart",
      AttributeValue.builder().s("2022-07-04T14:00").build()
    );
    meeting6.put(
      "Location",
      AttributeValue.builder().m(meeting6Location).build()
    );
    meeting6.put("Duration", AttributeValue.builder().s("30").build());
    meeting6.put(
      "Attendees",
      AttributeValue.builder().l(meeting6AttendeeList).build()
    );
    meeting6.put("Subject", AttributeValue.builder().s("DB ESDK").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(meeting6).build()
    );
  }

  // employee.json
  public static void putAllEmployeeItemsToTable(
    String ddbTableName,
    DynamoDbClient ddb
  ) {
    final HashMap<String, AttributeValue> employee1Location = new HashMap<>();
    employee1Location.put("Building", AttributeValue.builder().s("44").build());
    employee1Location.put("Floor", AttributeValue.builder().s("12").build());
    employee1Location.put("Desk", AttributeValue.builder().s("3").build());
    employee1Location.put(
      "City",
      AttributeValue.builder().s("Seattle").build()
    );

    final HashMap<String, AttributeValue> employee1 = new HashMap<>();
    employee1.put(
      "partition_key",
      AttributeValue.builder().s("employee1").build()
    );
    employee1.put("EmployeeID", AttributeValue.builder().s("emp_001").build());
    employee1.put(
      "EmployeeEmail",
      AttributeValue.builder().s("able@gmail.com").build()
    );
    employee1.put(
      "ManagerEmail",
      AttributeValue.builder().s("zorro@gmail.com").build()
    );
    employee1.put(
      "EmployeeName",
      AttributeValue.builder().s("Able Jones").build()
    );
    employee1.put("EmployeeTitle", AttributeValue.builder().s("SDE9").build());
    employee1.put(
      "Location",
      AttributeValue.builder().m(employee1Location).build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(employee1).build()
    );

    final HashMap<String, AttributeValue> employee2Location = new HashMap<>();
    employee2Location.put("Building", AttributeValue.builder().s("44").build());
    employee2Location.put("Floor", AttributeValue.builder().s("12").build());
    employee2Location.put("Desk", AttributeValue.builder().s("4").build());
    employee2Location.put(
      "City",
      AttributeValue.builder().s("Seattle").build()
    );

    final HashMap<String, AttributeValue> employee2 = new HashMap<>();
    employee2.put(
      "partition_key",
      AttributeValue.builder().s("employee2").build()
    );
    employee2.put("EmployeeID", AttributeValue.builder().s("emp_002").build());
    employee2.put(
      "EmployeeEmail",
      AttributeValue.builder().s("barney@gmail.com").build()
    );
    employee2.put(
      "ManagerEmail",
      AttributeValue.builder().s("zorro@gmail.com").build()
    );
    employee2.put(
      "EmployeeName",
      AttributeValue.builder().s("Barney Jones").build()
    );
    employee2.put("EmployeeTitle", AttributeValue.builder().s("SDE8").build());
    employee2.put(
      "Location",
      AttributeValue.builder().m(employee2Location).build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(employee2).build()
    );

    final HashMap<String, AttributeValue> employee3Location = new HashMap<>();
    employee3Location.put("Building", AttributeValue.builder().s("44").build());
    employee3Location.put("Floor", AttributeValue.builder().s("4").build());
    employee3Location.put("Desk", AttributeValue.builder().s("5").build());
    employee3Location.put(
      "City",
      AttributeValue.builder().s("Seattle").build()
    );

    final HashMap<String, AttributeValue> employee3 = new HashMap<>();
    employee3.put(
      "partition_key",
      AttributeValue.builder().s("employee3").build()
    );
    employee3.put("EmployeeID", AttributeValue.builder().s("emp_003").build());
    employee3.put(
      "EmployeeEmail",
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    employee3.put(
      "ManagerEmail",
      AttributeValue.builder().s("zorro@gmail.com").build()
    );
    employee3.put(
      "EmployeeName",
      AttributeValue.builder().s("Charlie Jones").build()
    );
    employee3.put("EmployeeTitle", AttributeValue.builder().s("SDE7").build());
    employee3.put(
      "Location",
      AttributeValue.builder().m(employee3Location).build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(employee3).build()
    );

    final HashMap<String, AttributeValue> employee4Location = new HashMap<>();
    employee4Location.put("Building", AttributeValue.builder().s("22").build());
    employee4Location.put("Floor", AttributeValue.builder().s("1").build());
    employee4Location.put("Desk", AttributeValue.builder().s("3").build());
    employee4Location.put("City", AttributeValue.builder().s("NYC").build());

    final HashMap<String, AttributeValue> employee4 = new HashMap<>();
    employee4.put(
      "partition_key",
      AttributeValue.builder().s("employee4").build()
    );
    employee4.put("EmployeeID", AttributeValue.builder().s("emp_004").build());
    employee4.put(
      "EmployeeEmail",
      AttributeValue.builder().s("david@gmail.com").build()
    );
    employee4.put(
      "ManagerEmail",
      AttributeValue.builder().s("zorro@gmail.com").build()
    );
    employee4.put(
      "EmployeeName",
      AttributeValue.builder().s("David Jones").build()
    );
    employee4.put("EmployeeTitle", AttributeValue.builder().s("SDE6").build());
    employee4.put(
      "Location",
      AttributeValue.builder().m(employee4Location).build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(employee4).build()
    );
  }

  // project.json
  public static void putAllProjectItemsToTable(
    String ddbTableName,
    DynamoDbClient ddb
  ) {
    final HashMap<String, AttributeValue> project1 = new HashMap<>();
    project1.put(
      "partition_key",
      AttributeValue.builder().s("project1").build()
    );
    project1.put(
      "ProjectName",
      AttributeValue.builder().s("project_001").build()
    );
    project1.put(
      "ProjectStatus",
      AttributeValue.builder().s("Pending").build()
    );
    project1.put(
      "ProjectStart",
      AttributeValue.builder().s("2022-11-01").build()
    );
    project1.put(
      "Description",
      AttributeValue.builder().s("Turbo Crypto").build()
    );
    project1.put(
      "ProjectTarget",
      AttributeValue.builder().s("2024-01-01").build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(project1).build()
    );

    final HashMap<String, AttributeValue> project2 = new HashMap<>();
    project2.put(
      "partition_key",
      AttributeValue.builder().s("project2").build()
    );
    project2.put(
      "ProjectName",
      AttributeValue.builder().s("project_002").build()
    );
    project2.put("ProjectStatus", AttributeValue.builder().s("Active").build());
    project2.put(
      "ProjectStart",
      AttributeValue.builder().s("2022-07-04").build()
    );
    project2.put(
      "Description",
      AttributeValue.builder().s("Scan Beacons").build()
    );
    project2.put(
      "ProjectTarget",
      AttributeValue.builder().s("2024-01-01").build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(project2).build()
    );

    final HashMap<String, AttributeValue> project3 = new HashMap<>();
    project3.put(
      "partition_key",
      AttributeValue.builder().s("project3").build()
    );
    project3.put(
      "ProjectName",
      AttributeValue.builder().s("project_003").build()
    );
    project3.put("ProjectStatus", AttributeValue.builder().s("Active").build());
    project3.put(
      "ProjectStart",
      AttributeValue.builder().s("2022-08-05").build()
    );
    project3.put("Description", AttributeValue.builder().s("DB ESDK").build());
    project3.put(
      "ProjectTarget",
      AttributeValue.builder().s("2023-02-27").build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(project3).build()
    );

    final HashMap<String, AttributeValue> project4 = new HashMap<>();
    project4.put(
      "partition_key",
      AttributeValue.builder().s("project4").build()
    );
    project4.put(
      "ProjectName",
      AttributeValue.builder().s("project_004").build()
    );
    project4.put("ProjectStatus", AttributeValue.builder().s("Done").build());
    project4.put(
      "ProjectStart",
      AttributeValue.builder().s("2020-03-03").build()
    );
    project4.put("Description", AttributeValue.builder().s("S3EC").build());
    project4.put(
      "ProjectTarget",
      AttributeValue.builder().s("2021-09-05").build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(project4).build()
    );
  }

  // reservation.json
  public static void putAllReservationItemsToTable(
    String ddbTableName,
    DynamoDbClient ddb
  ) {
    final List<AttributeValue> reservation1AttendeeList = new ArrayList<>();
    reservation1AttendeeList.add(
      AttributeValue.builder().s("able@gmail.com").build()
    );
    reservation1AttendeeList.add(
      AttributeValue.builder().s("barney@gmail.com").build()
    );

    final HashMap<String, AttributeValue> reservation1Location =
      new HashMap<>();
    reservation1Location.put(
      "Building",
      AttributeValue.builder().s("SEA33").build()
    );
    reservation1Location.put("Floor", AttributeValue.builder().s("12").build());
    reservation1Location.put("Room", AttributeValue.builder().s("403").build());

    final HashMap<String, AttributeValue> reservation1 = new HashMap<>();
    reservation1.put(
      "partition_key",
      AttributeValue.builder().s("reservation1").build()
    );
    reservation1.put(
      "Location",
      AttributeValue.builder().m(reservation1Location).build()
    );
    reservation1.put(
      "MeetingStart",
      AttributeValue.builder().s("2022-07-04T13:00").build()
    );
    reservation1.put(
      "OrganizerEmail",
      AttributeValue.builder().s("able@gmail.com").build()
    );
    reservation1.put("Duration", AttributeValue.builder().s("30").build());
    reservation1.put(
      "Attendees",
      AttributeValue.builder().l(reservation1AttendeeList).build()
    );
    reservation1.put(
      "Subject",
      AttributeValue.builder().s("Scan beacons").build()
    );

    ddb.putItem(
      PutItemRequest
        .builder()
        .tableName(ddbTableName)
        .item(reservation1)
        .build()
    );

    final List<AttributeValue> reservation2AttendeeList = new ArrayList<>();
    reservation2AttendeeList.add(
      AttributeValue.builder().s("able@gmail.com").build()
    );
    reservation2AttendeeList.add(
      AttributeValue.builder().s("barney@gmail.com").build()
    );

    final HashMap<String, AttributeValue> reservation2Location =
      new HashMap<>();
    reservation2Location.put(
      "Building",
      AttributeValue.builder().s("SEA33").build()
    );
    reservation2Location.put("Floor", AttributeValue.builder().s("12").build());
    reservation2Location.put("Room", AttributeValue.builder().s("407").build());

    final HashMap<String, AttributeValue> reservation2 = new HashMap<>();
    reservation2.put(
      "partition_key",
      AttributeValue.builder().s("reservation2").build()
    );
    reservation2.put(
      "Location",
      AttributeValue.builder().m(reservation2Location).build()
    );
    reservation2.put(
      "MeetingStart",
      AttributeValue.builder().s("2022-07-04T14:00").build()
    );
    reservation2.put(
      "OrganizerEmail",
      AttributeValue.builder().s("barney@gmail.com").build()
    );
    reservation2.put("Duration", AttributeValue.builder().s("30").build());
    reservation2.put(
      "Attendees",
      AttributeValue.builder().l(reservation2AttendeeList).build()
    );
    reservation2.put("Subject", AttributeValue.builder().s("DB ESDK").build());

    ddb.putItem(
      PutItemRequest
        .builder()
        .tableName(ddbTableName)
        .item(reservation2)
        .build()
    );
  }

  // ticket.json
  public static void putAllTicketItemsToTable(
    String ddbTableName,
    DynamoDbClient ddb
  ) {
    final HashMap<String, AttributeValue> ticket1 = new HashMap<>();
    ticket1.put("partition_key", AttributeValue.builder().s("ticket1").build());
    ticket1.put(
      "TicketNumber",
      AttributeValue.builder().s("ticket_001").build()
    );
    ticket1.put(
      "TicketModTime",
      AttributeValue.builder().s("2022-10-07T14:32:25").build()
    );
    ticket1.put(
      "CreatorEmail",
      AttributeValue.builder().s("zorro@gmail.com").build()
    );
    ticket1.put(
      "AssigneeEmail",
      AttributeValue.builder().s("able@gmail.com").build()
    );
    ticket1.put("Severity", AttributeValue.builder().s("3").build());
    ticket1.put("Subject", AttributeValue.builder().s("Bad bug").build());
    ticket1.put(
      "Message",
      AttributeValue.builder().s("This bug looks pretty bad").build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(ticket1).build()
    );

    final HashMap<String, AttributeValue> ticket2 = new HashMap<>();
    ticket2.put("partition_key", AttributeValue.builder().s("ticket2").build());
    ticket2.put(
      "TicketNumber",
      AttributeValue.builder().s("ticket_001").build()
    );
    ticket2.put(
      "TicketModTime",
      AttributeValue.builder().s("2022-10-07T14:32:25").build()
    );
    ticket2.put(
      "CreatorEmail",
      AttributeValue.builder().s("able@gmail.com").build()
    );
    ticket2.put(
      "AssigneeEmail",
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    ticket2.put("Severity", AttributeValue.builder().s("3").build());
    ticket2.put("Subject", AttributeValue.builder().s("Bad bug").build());
    ticket2.put(
      "Message",
      AttributeValue.builder().s("Charlie should handle this").build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(ticket2).build()
    );

    final HashMap<String, AttributeValue> ticket3 = new HashMap<>();
    ticket3.put("partition_key", AttributeValue.builder().s("ticket3").build());
    ticket3.put(
      "TicketNumber",
      AttributeValue.builder().s("ticket_002").build()
    );
    ticket3.put(
      "TicketModTime",
      AttributeValue.builder().s("2022-10-06T14:32:25").build()
    );
    ticket3.put(
      "CreatorEmail",
      AttributeValue.builder().s("zorro@gmail.com").build()
    );
    ticket3.put(
      "AssigneeEmail",
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    ticket3.put("Severity", AttributeValue.builder().s("3").build());
    ticket3.put("Subject", AttributeValue.builder().s("Easy Bug").build());
    ticket3.put(
      "Message",
      AttributeValue.builder().s("This seems simple enough").build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(ticket3).build()
    );

    final HashMap<String, AttributeValue> ticket4 = new HashMap<>();
    ticket4.put("partition_key", AttributeValue.builder().s("ticket4").build());
    ticket4.put(
      "TicketNumber",
      AttributeValue.builder().s("ticket_002").build()
    );
    ticket4.put(
      "TicketModTime",
      AttributeValue.builder().s("2022-10-08T14:32:25").build()
    );
    ticket4.put(
      "CreatorEmail",
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    ticket4.put(
      "AssigneeEmail",
      AttributeValue.builder().s("able@gmail.com").build()
    );
    ticket4.put("Severity", AttributeValue.builder().s("3").build());
    ticket4.put("Subject", AttributeValue.builder().s("Easy Bug").build());
    ticket4.put(
      "Message",
      AttributeValue.builder().s("that's in able's code").build()
    );

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(ticket4).build()
    );
  }

  // timecard.json
  public static void putAllTimecardItemsToTable(
    String ddbTableName,
    DynamoDbClient ddb
  ) {
    final HashMap<String, AttributeValue> timecard1 = new HashMap<>();
    timecard1.put(
      "partition_key",
      AttributeValue.builder().s("timecard1").build()
    );
    timecard1.put(
      "ProjectName",
      AttributeValue.builder().s("project_002").build()
    );
    timecard1.put(
      "TimeCardStart",
      AttributeValue.builder().s("2022-09-12").build()
    );
    timecard1.put(
      "EmployeeEmail",
      AttributeValue.builder().s("able@gmail.com").build()
    );
    timecard1.put("Hours", AttributeValue.builder().s("40").build());
    timecard1.put("Role", AttributeValue.builder().s("SDE3").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(timecard1).build()
    );

    final HashMap<String, AttributeValue> timecard2 = new HashMap<>();
    timecard2.put(
      "partition_key",
      AttributeValue.builder().s("timecard2").build()
    );
    timecard2.put(
      "ProjectName",
      AttributeValue.builder().s("project_002").build()
    );
    timecard2.put(
      "TimeCardStart",
      AttributeValue.builder().s("2022-09-12").build()
    );
    timecard2.put(
      "EmployeeEmail",
      AttributeValue.builder().s("barney@gmail.com").build()
    );
    timecard2.put("Hours", AttributeValue.builder().s("20").build());
    timecard2.put("Role", AttributeValue.builder().s("PM").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(timecard2).build()
    );

    final HashMap<String, AttributeValue> timecard3 = new HashMap<>();
    timecard3.put(
      "partition_key",
      AttributeValue.builder().s("timecard3").build()
    );
    timecard3.put(
      "ProjectName",
      AttributeValue.builder().s("project_003").build()
    );
    timecard3.put(
      "TimeCardStart",
      AttributeValue.builder().s("2022-09-12").build()
    );
    timecard3.put(
      "EmployeeEmail",
      AttributeValue.builder().s("charlie@gmail.com").build()
    );
    timecard3.put("Hours", AttributeValue.builder().s("40").build());
    timecard3.put("Role", AttributeValue.builder().s("SDE3").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(timecard3).build()
    );

    final HashMap<String, AttributeValue> timecard4 = new HashMap<>();
    timecard4.put(
      "partition_key",
      AttributeValue.builder().s("timecard4").build()
    );
    timecard4.put(
      "ProjectName",
      AttributeValue.builder().s("project_003").build()
    );
    timecard4.put(
      "TimeCardStart",
      AttributeValue.builder().s("2022-09-12").build()
    );
    timecard4.put(
      "EmployeeEmail",
      AttributeValue.builder().s("barney@gmail.com").build()
    );
    timecard4.put("Hours", AttributeValue.builder().s("20").build());
    timecard4.put("Role", AttributeValue.builder().s("PM").build());

    ddb.putItem(
      PutItemRequest.builder().tableName(ddbTableName).item(timecard4).build()
    );
  }
}
