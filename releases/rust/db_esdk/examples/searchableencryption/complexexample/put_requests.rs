// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

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
 * This class implements PutItemAsync calls to populate a DDB table with items from our workshop.
 * By providing a DynamoDbClient that is configured to use searchable encryption,
 *   this class will encrypt the data client side and add beacon attributes to the items.
 * This only implements a single item of each of the 6 record types from Demo.md. Adding the remaining
 *   items would extend the test and example coverage.
 */

pub async fn put_all_items_to_table(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    put_all_meeting_items(ddb_table_name, ddb).await?;
    put_all_employee_items(ddb_table_name, ddb).await?;
    put_all_project_items(ddb_table_name, ddb).await?;
    put_all_reservation_items(ddb_table_name, ddb).await?;
    put_all_ticket_items(ddb_table_name, ddb).await?;
    put_all_timecard_items(ddb_table_name, ddb).await?;
    Ok(())
}

fn ss(s: &str) -> AttributeValue {
    AttributeValue::S(s.to_string())
}
fn entry(name: &str, value: &str) -> (String, AttributeValue) {
    (name.to_string(), ss(value))
}

async fn put_item(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
    item: HashMap<String, AttributeValue>,
) -> Result<(), crate::BoxError> {
    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item))
        .send()
        .await?;
    Ok(())
}

// emeeting.json
async fn put_all_meeting_items(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    let meeting1_attendee_list = vec![ss("able@gmail.com"), ss("zorro@gmail.com")];
    let meeting1_location = HashMap::from([entry("Floor", "12"), entry("Room", "403")]);
    let meeting1 = HashMap::from([
        entry("partition_key", "meeting1"),
        entry("EmployeeID", "emp_001"),
        entry("EmployeeEmail", "able@gmail.com"),
        entry("MeetingStart", "2022-07-04T13:00"),
        entry("Duration", "30"),
        entry("Subject", "Scan Beacons"),
        ("Location".to_string(), AttributeValue::M(meeting1_location)),
        (
            "Attendees".to_string(),
            AttributeValue::L(meeting1_attendee_list),
        ),
    ]);
    put_item(ddb_table_name, ddb, meeting1).await?;

    let meeting2_attendee_list = vec![ss("barney@gmail.com"), ss("zorro@gmail.com")];
    let meeting2_location = HashMap::from([entry("Floor", "12"), entry("Room", "403")]);
    let meeting2 = HashMap::from([
        entry("partition_key", "meeting2"),
        entry("EmployeeID", "emp_002"),
        entry("EmployeeEmail", "barney@gmail.com"),
        entry("MeetingStart", "2022-07-04T13:00"),
        entry("Duration", "30"),
        entry("Subject", "Scan Beacons"),
        ("Location".to_string(), AttributeValue::M(meeting2_location)),
        (
            "Attendees".to_string(),
            AttributeValue::L(meeting2_attendee_list),
        ),
    ]);
    put_item(ddb_table_name, ddb, meeting2).await?;

    let meeting3_attendee_list = vec![ss("charlie@gmail.com"), ss("zorro@gmail.com")];
    let meeting3_location = HashMap::from([entry("Floor", "12"), entry("Room", "403")]);
    let meeting3 = HashMap::from([
        entry("partition_key", "meeting3"),
        entry("EmployeeID", "emp_003"),
        entry("EmployeeEmail", "charlie@gmail.com"),
        entry("MeetingStart", "2022-07-04T13:00"),
        entry("Duration", "30"),
        entry("Subject", "Scan Beacons"),
        ("Location".to_string(), AttributeValue::M(meeting3_location)),
        (
            "Attendees".to_string(),
            AttributeValue::L(meeting3_attendee_list),
        ),
    ]);
    put_item(ddb_table_name, ddb, meeting3).await?;

    let meeting4_attendee_list = vec![ss("david@gmail.com"), ss("zorro@gmail.com")];
    let meeting4_location = HashMap::from([entry("Floor", "12"), entry("Room", "403")]);
    let meeting4 = HashMap::from([
        entry("partition_key", "meeting4"),
        entry("EmployeeID", "emp_004"),
        entry("EmployeeEmail", "david@gmail.com"),
        entry("MeetingStart", "2022-07-04T13:00"),
        entry("Duration", "30"),
        entry("Subject", "Scan Beacons"),
        ("Location".to_string(), AttributeValue::M(meeting4_location)),
        (
            "Attendees".to_string(),
            AttributeValue::L(meeting4_attendee_list),
        ),
    ]);
    put_item(ddb_table_name, ddb, meeting4).await?;

    let meeting5_attendee_list = vec![ss("barney@gmail.com"), ss("zorro@gmail.com")];
    let meeting5_location = HashMap::from([entry("Floor", "12"), entry("Room", "407")]);
    let meeting5 = HashMap::from([
        entry("partition_key", "meeting5"),
        entry("EmployeeID", "emp_002"),
        entry("EmployeeEmail", "barney@gmail.com"),
        entry("MeetingStart", "2022-07-04T14:00"),
        entry("Duration", "30"),
        entry("Subject", "DB ESDK"),
        ("Location".to_string(), AttributeValue::M(meeting5_location)),
        (
            "Attendees".to_string(),
            AttributeValue::L(meeting5_attendee_list),
        ),
    ]);
    put_item(ddb_table_name, ddb, meeting5).await?;

    let meeting6_attendee_list = vec![ss("charlie@gmail.com"), ss("zorro@gmail.com")];
    let meeting6_location = HashMap::from([entry("Floor", "12"), entry("Room", "407")]);
    let meeting6 = HashMap::from([
        entry("partition_key", "meeting6"),
        entry("EmployeeID", "emp_003"),
        entry("EmployeeEmail", "charlie@gmail.com"),
        entry("MeetingStart", "2022-07-04T14:00"),
        entry("Duration", "30"),
        entry("Subject", "DB ESDK"),
        ("Location".to_string(), AttributeValue::M(meeting6_location)),
        (
            "Attendees".to_string(),
            AttributeValue::L(meeting6_attendee_list),
        ),
    ]);
    put_item(ddb_table_name, ddb, meeting6).await?;
    Ok(())
}

// employee.json
async fn put_all_employee_items(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    let employee1_location = HashMap::from([
        entry("Building", "44"),
        entry("Floor", "12"),
        entry("Desk", "3"),
        entry("City", "Seattle"),
    ]);
    let employee1 = HashMap::from([
        entry("partition_key", "employee1"),
        entry("EmployeeID", "emp_001"),
        entry("EmployeeEmail", "able@gmail.com"),
        entry("ManagerEmail", "zorro@gmail.com"),
        entry("EmployeeName", "Able Jones"),
        entry("EmployeeTitle", "SDE9"),
        (
            "Location".to_string(),
            AttributeValue::M(employee1_location),
        ),
    ]);
    put_item(ddb_table_name, ddb, employee1).await?;

    let employee2_location = HashMap::from([
        entry("Building", "44"),
        entry("Floor", "12"),
        entry("Desk", "4"),
        entry("City", "Seattle"),
    ]);
    let employee2 = HashMap::from([
        entry("partition_key", "employee2"),
        entry("EmployeeID", "emp_002"),
        entry("EmployeeEmail", "barney@gmail.com"),
        entry("ManagerEmail", "zorro@gmail.com"),
        entry("EmployeeName", "Barney Jones"),
        entry("EmployeeTitle", "SDE8"),
        (
            "Location".to_string(),
            AttributeValue::M(employee2_location),
        ),
    ]);
    put_item(ddb_table_name, ddb, employee2).await?;

    let employee3_location = HashMap::from([
        entry("Building", "44"),
        entry("Floor", "4"),
        entry("Desk", "5"),
        entry("City", "Seattle"),
    ]);
    let employee3 = HashMap::from([
        entry("partition_key", "employee3"),
        entry("EmployeeID", "emp_003"),
        entry("EmployeeEmail", "charlie@gmail.com"),
        entry("ManagerEmail", "zorro@gmail.com"),
        entry("EmployeeName", "Charlie Jones"),
        entry("EmployeeTitle", "SDE7"),
        (
            "Location".to_string(),
            AttributeValue::M(employee3_location),
        ),
    ]);
    put_item(ddb_table_name, ddb, employee3).await?;

    let employee4_location = HashMap::from([
        entry("Building", "22"),
        entry("Floor", "1"),
        entry("Desk", "3"),
        entry("City", "NYC"),
    ]);
    let employee4 = HashMap::from([
        entry("partition_key", "employee4"),
        entry("EmployeeID", "emp_004"),
        entry("EmployeeEmail", "david@gmail.com"),
        entry("ManagerEmail", "zorro@gmail.com"),
        entry("EmployeeName", "David Jones"),
        entry("EmployeeTitle", "SDE6"),
        (
            "Location".to_string(),
            AttributeValue::M(employee4_location),
        ),
    ]);
    put_item(ddb_table_name, ddb, employee4).await?;
    Ok(())
}

// project.json
async fn put_all_project_items(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    let project1 = HashMap::from([
        entry("partition_key", "project1"),
        entry("ProjectName", "project_001"),
        entry("ProjectStatus", "Pending"),
        entry("ProjectStart", "2022-11-01"),
        entry("Description", "Turbo Crypto"),
        entry("ProjectTarget", "2024-01-01"),
    ]);
    put_item(ddb_table_name, ddb, project1).await?;

    let project2 = HashMap::from([
        entry("partition_key", "project2"),
        entry("ProjectName", "project_002"),
        entry("ProjectStatus", "Active"),
        entry("ProjectStart", "2022-07-04"),
        entry("Description", "Scan Beacons"),
        entry("ProjectTarget", "2024-01-01"),
    ]);
    put_item(ddb_table_name, ddb, project2).await?;

    let project3 = HashMap::from([
        entry("partition_key", "project3"),
        entry("ProjectName", "project_003"),
        entry("ProjectStatus", "Active"),
        entry("ProjectStart", "2022-08-05"),
        entry("Description", "DB ESDK"),
        entry("ProjectTarget", "2023-02-27"),
    ]);
    put_item(ddb_table_name, ddb, project3).await?;

    let project4 = HashMap::from([
        entry("partition_key", "project4"),
        entry("ProjectName", "project_004"),
        entry("ProjectStatus", "Done"),
        entry("ProjectStart", "2020-03-03"),
        entry("Description", "S3EC"),
        entry("ProjectTarget", "2021-09-05"),
    ]);
    put_item(ddb_table_name, ddb, project4).await?;
    Ok(())
}

// reservation.json
async fn put_all_reservation_items(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    let reservation1_attendee_list = vec![ss("able@gmail.com"), ss("barney@gmail.com")];
    let reservation1_location = HashMap::from([
        entry("Building", "SEA33"),
        entry("Floor", "12"),
        entry("Room", "403"),
    ]);
    let reservation1 = HashMap::from([
        entry("partition_key", "reservation1"),
        entry("MeetingStart", "2022-07-04T13:00"),
        entry("OrganizerEmail", "able@gmail.com"),
        entry("Duration", "30"),
        entry("Subject", "Scan beacons"),
        (
            "Location".to_string(),
            AttributeValue::M(reservation1_location),
        ),
        (
            "Attendees".to_string(),
            AttributeValue::L(reservation1_attendee_list),
        ),
    ]);
    put_item(ddb_table_name, ddb, reservation1).await?;

    let reservation2_attendee_list = vec![ss("able@gmail.com"), ss("barney@gmail.com")];
    let reservation2_location = HashMap::from([
        entry("Building", "SEA33"),
        entry("Floor", "12"),
        entry("Room", "407"),
    ]);
    let reservation2 = HashMap::from([
        entry("partition_key", "reservation2"),
        entry("MeetingStart", "2022-07-04T14:00"),
        entry("OrganizerEmail", "barney@gmail.com"),
        entry("Duration", "30"),
        entry("Subject", "DB ESDK"),
        (
            "Location".to_string(),
            AttributeValue::M(reservation2_location),
        ),
        (
            "Attendees".to_string(),
            AttributeValue::L(reservation2_attendee_list),
        ),
    ]);
    put_item(ddb_table_name, ddb, reservation2).await?;
    Ok(())
}

// ticket.json
async fn put_all_ticket_items(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    let ticket1 = HashMap::from([
        entry("partition_key", "ticket1"),
        entry("TicketNumber", "ticket_001"),
        entry("TicketModTime", "2022-10-07T14:32:25"),
        entry("CreatorEmail", "zorro@gmail.com"),
        entry("AssigneeEmail", "able@gmail.com"),
        entry("Severity", "3"),
        entry("Subject", "Bad bug"),
        entry("Message", "This bug looks pretty bad"),
    ]);
    put_item(ddb_table_name, ddb, ticket1).await?;

    let ticket2 = HashMap::from([
        entry("partition_key", "ticket2"),
        entry("TicketNumber", "ticket_001"),
        entry("TicketModTime", "2022-10-07T14:32:25"),
        entry("CreatorEmail", "able@gmail.com"),
        entry("AssigneeEmail", "charlie@gmail.com"),
        entry("Severity", "3"),
        entry("Subject", "Bad bug"),
        entry("Message", "Charlie should handle this"),
    ]);
    put_item(ddb_table_name, ddb, ticket2).await?;

    let ticket3 = HashMap::from([
        entry("partition_key", "ticket3"),
        entry("TicketNumber", "ticket_002"),
        entry("TicketModTime", "2022-10-06T14:32:25"),
        entry("CreatorEmail", "zorro@gmail.com"),
        entry("AssigneeEmail", "charlie@gmail.com"),
        entry("Severity", "3"),
        entry("Subject", "Easy bug"),
        entry("Message", "This seems simple enough"),
    ]);
    put_item(ddb_table_name, ddb, ticket3).await?;

    let ticket4 = HashMap::from([
        entry("partition_key", "ticket4"),
        entry("TicketNumber", "ticket_002"),
        entry("TicketModTime", "2022-10-08T14:32:25"),
        entry("CreatorEmail", "charlie@gmail.com"),
        entry("AssigneeEmail", "able@gmail.com"),
        entry("Severity", "3"),
        entry("Subject", "Easy bug"),
        entry("Message", "that's in able's code"),
    ]);
    put_item(ddb_table_name, ddb, ticket4).await?;
    Ok(())
}

// timecard.json
async fn put_all_timecard_items(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    let timecard1 = HashMap::from([
        entry("partition_key", "timecard1"),
        entry("ProjectName", "project_002"),
        entry("TimeCardStart", "2022-09-12"),
        entry("EmployeeEmail", "able@gmail.com"),
        entry("Hours", "40"),
        entry("Role", "SDE3"),
    ]);
    put_item(ddb_table_name, ddb, timecard1).await?;

    let timecard2 = HashMap::from([
        entry("partition_key", "timecard2"),
        entry("ProjectName", "project_002"),
        entry("TimeCardStart", "2022-09-12"),
        entry("EmployeeEmail", "barney@gmail.com"),
        entry("Hours", "20"),
        entry("Role", "PM"),
    ]);
    put_item(ddb_table_name, ddb, timecard2).await?;

    let timecard3 = HashMap::from([
        entry("partition_key", "timecard3"),
        entry("ProjectName", "project_003"),
        entry("TimeCardStart", "2022-09-12"),
        entry("EmployeeEmail", "charlie@gmail.com"),
        entry("Hours", "40"),
        entry("Role", "SDE3"),
    ]);
    put_item(ddb_table_name, ddb, timecard3).await?;

    let timecard4 = HashMap::from([
        entry("partition_key", "timecard4"),
        entry("ProjectName", "project_003"),
        entry("TimeCardStart", "2022-09-12"),
        entry("EmployeeEmail", "barney@gmail.com"),
        entry("Hours", "20"),
        entry("Role", "PM"),
    ]);
    put_item(ddb_table_name, ddb, timecard4).await?;
    Ok(())
}
