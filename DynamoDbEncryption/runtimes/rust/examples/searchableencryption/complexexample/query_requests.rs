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
 * This class implements query access patterns from our workshop.
 * The queries in this file are more complicated than in other searchable encryption examples,
 *   and should demonstrate how one can structure queries on beacons in a broader variety of applications.
 */

pub async fn run_queries(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    run_query1(ddb_table_name, ddb).await?;
    run_query2(ddb_table_name, ddb).await?;
    run_query3(ddb_table_name, ddb).await?;
    run_query4(ddb_table_name, ddb).await?;
    run_query5(ddb_table_name, ddb).await?;
    run_query6(ddb_table_name, ddb).await?;
    run_query7(ddb_table_name, ddb).await?;
    run_query8(ddb_table_name, ddb).await?;
    run_query9(ddb_table_name, ddb).await?;
    run_query10(ddb_table_name, ddb).await?;
    run_query11(ddb_table_name, ddb).await?;
    run_query12(ddb_table_name, ddb).await?;
    run_query13(ddb_table_name, ddb).await?;
    run_query14(ddb_table_name, ddb).await?;
    run_query15(ddb_table_name, ddb).await?;
    run_query16(ddb_table_name, ddb).await?;
    run_query17(ddb_table_name, ddb).await?;
    run_query18(ddb_table_name, ddb).await?;
    run_query19(ddb_table_name, ddb).await?;
    run_query20(ddb_table_name, ddb).await?;
    run_query21(ddb_table_name, ddb).await?;
    run_query22(ddb_table_name, ddb).await?;
    run_query23(ddb_table_name, ddb).await?;
    Ok(())
}

fn ss(s: &str) -> AttributeValue {
    AttributeValue::S(s.to_string())
}

fn entry(name: &str, value: &str) -> (String, AttributeValue) {
    (name.to_string(), ss(value))
}

async fn run_query1(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 1: Get meetings by date and email
    // Key condition: PK1=email SK1 between(date1, date2)
    // Filter condition: duration > 0

    let query1_names = HashMap::from([
        ("#duration".to_string(), "Duration".to_string()), // Duration is a reserved word
    ]);

    let query1_values = HashMap::from([
        entry(":e", "EE-able@gmail.com"),
        entry(":date1", "MS-2022-07-02"),
        entry(":date2", "MS-2022-07-08"),
        entry(":zero", "0"),
    ]);

    let query1_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_names(Some(query1_names))
        .set_expression_attribute_values(Some(query1_values))
        .key_condition_expression("PK1 = :e AND SK1 BETWEEN :date1 AND :date2")
        .filter_expression("#duration > :zero")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query1_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("meeting1"));
    assert_eq!(items[0]["Subject"], ss("Scan Beacons"));
    assert_eq!(items[0]["Location"].as_m().unwrap()["Floor"], ss("12"));
    assert!(items[0]["Attendees"]
        .as_l()
        .unwrap()
        .contains(&ss("zorro@gmail.com")));
    Ok(())
}

async fn run_query2(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 2: Get meetings by date and employeeID
    // Key condition: PK=employeeID SK between(date1, date2)
    // Filter condition: duration > 0

    let query2_names = HashMap::from([
        ("#duration".to_string(), "Duration".to_string()), // Duration is a reserved word
    ]);

    let query2_values = HashMap::from([
        entry(":employee", "E-emp_001"),
        entry(":date1", "MS-2022-07-02"),
        entry(":date2", "MS-2022-07-08"),
        entry(":zero", "0"),
    ]);

    let query2_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_names(Some(query2_names))
        .set_expression_attribute_values(Some(query2_values))
        .key_condition_expression("PK = :employee AND SK BETWEEN :date1 AND :date2")
        .filter_expression("#duration > :zero")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query2_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("meeting1"));
    assert_eq!(items[0]["Subject"], ss("Scan Beacons"));
    assert_eq!(items[0]["Location"].as_m().unwrap()["Floor"], ss("12"));
    assert!(items[0]["Attendees"]
        .as_l()
        .unwrap()
        .contains(&ss("zorro@gmail.com")));
    Ok(())
}

async fn run_query3(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 3: Get meetings by date and building/floor/room
    // Key condition: PK=employeeID SK between(date1, date2)
    // Filter condition: SK contains building.floor.room (see NOTE)
    // NOTE: This query is modified from Demo.md.
    //       Demo.md calls for a filter condition "SK contains building.floor.room"
    //       However, one cannot use primary keys (partition nor sort) in a filter expression.
    //       Instead, this query filters on the individual beacon attributes: building, floor, and room.

    let query3_values = HashMap::from([
        entry(":buildingbeacon", "B-SEA33"),
        entry(":building", "SEA33"),
        entry(":floor", "12"),
        entry(":room", "403"),
        entry(":date1", "MS-2022-07-02"),
        entry(":date2", "MS-2022-07-08"),
    ]);

    let query3_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_values(Some(query3_values))
        .key_condition_expression("PK = :buildingbeacon AND SK BETWEEN :date1 AND :date2")
        .filter_expression("Building = :building AND Floor = :floor AND Room = :room")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query3_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("reservation1"));
    assert_eq!(items[0]["Subject"], ss("Scan beacons"));
    assert_eq!(
        items[0]["Location"].as_m().unwrap()["Building"],
        ss("SEA33")
    );
    assert!(items[0]["Attendees"]
        .as_l()
        .unwrap()
        .contains(&ss("barney@gmail.com")));
    Ok(())
}

async fn run_query4(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 4: Get employee data by email
    // Key condition: PK1=email SK1=employee ID

    let query4_values = HashMap::from([
        entry(":email", "EE-able@gmail.com"),
        entry(":employee", "E-emp_001"),
    ]);

    let query4_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_values(Some(query4_values))
        .key_condition_expression("PK1 = :email AND SK1 = :employee")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query4_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("employee1"));
    assert_eq!(items[0]["EmployeeID"], ss("emp_001"));
    assert_eq!(items[0]["Location"].as_m().unwrap()["Desk"], ss("3"));
    Ok(())
}

async fn run_query5(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 5: Get meetings by email
    // Key condition: PK1=email SK1 > 30 days ago

    let query5_values = HashMap::from([
        entry(":email", "EE-able@gmail.com"),
        entry(":thirtydaysago", "MS-2023-03-20"),
        entry(":prefix", "MS-"),
    ]);

    let query5_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_values(Some(query5_values))
        .key_condition_expression("PK1 = :email AND SK1 BETWEEN :prefix AND :thirtydaysago")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query5_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("meeting1"));
    assert_eq!(items[0]["Subject"], ss("Scan Beacons"));
    assert_eq!(items[0]["Location"].as_m().unwrap()["Floor"], ss("12"));
    assert!(items[0]["Attendees"]
        .as_l()
        .unwrap()
        .contains(&ss("zorro@gmail.com")));
    Ok(())
}

async fn run_query6(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 6: Get tickets by email
    // Key condition: PK1=email SK1 > 30 days ago

    let query6_values = HashMap::from([
        entry(":creatoremail", "CE-zorro@gmail.com"),
        entry(":thirtydaysago", "MS-2023-03-20"),
    ]);

    let query6_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_values(Some(query6_values))
        .key_condition_expression("PK1 = :creatoremail AND SK1 < :thirtydaysago")
        .send()
        .await?;

    // Assert 2 items were returned
    let items = query6_response.items.unwrap();
    assert_eq!(items.len(), 2);

    // Expected to be `ticket1` and `ticket3`
    assert!(
        ((items[0]["partition_key"] == ss("ticket1"))
            && (items[1]["partition_key"] == ss("ticket3")))
            || ((items[0]["partition_key"] == ss("ticket3"))
                && (items[1]["partition_key"] == ss("ticket1")))
    );
    Ok(())
}

async fn run_query7(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 7: Get reservations by email
    // Key condition: PK1=organizeremail SK1 > 30 days ago

    let query7_values = HashMap::from([
        entry(":organizeremail", "OE-able@gmail.com"),
        entry(":thirtydaysago", "MS-2023-03-20"),
    ]);

    let query7_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_values(Some(query7_values))
        .key_condition_expression("PK1 = :organizeremail AND SK1 < :thirtydaysago")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query7_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("reservation1"));
    assert_eq!(items[0]["Subject"], ss("Scan beacons"));
    assert_eq!(items[0]["Location"].as_m().unwrap()["Floor"], ss("12"));
    assert!(items[0]["Attendees"]
        .as_l()
        .unwrap()
        .contains(&ss("barney@gmail.com")));
    Ok(())
}

async fn run_query8(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 8: Get time cards by email
    // Key condition: PK1=employeeemail SK1 > 30 days ago

    let query8_values = HashMap::from([
        entry(":email", "EE-able@gmail.com"),
        entry(":prefix", "TC-"),
        entry(":thirtydaysago", "TC-2023-03-20"),
    ]);

    let query8_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_values(Some(query8_values))
        .key_condition_expression("PK1 = :email AND SK1 BETWEEN :prefix AND :thirtydaysago")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query8_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("timecard1"));
    assert_eq!(items[0]["ProjectName"], ss("project_002"));
    Ok(())
}

async fn run_query9(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 9: Get employee info by employee ID
    // Key condition: PK1=employeeID SK starts with "E-"

    let query9_values = HashMap::from([entry(":employee", "E-emp_001"), entry(":prefix", "E-")]);

    let query9_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_values(Some(query9_values))
        .key_condition_expression("PK = :employee AND begins_with(SK, :prefix)")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query9_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("employee1"));
    assert_eq!(items[0]["EmployeeID"], ss("emp_001"));
    Ok(())
}

async fn run_query10(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 10: Get employee info by email
    // Key condition: PK1=email
    // Filter condition: SK starts with "E-"

    let query10_values =
        HashMap::from([entry(":email", "EE-able@gmail.com"), entry(":prefix", "E-")]);

    let query10_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_values(Some(query10_values))
        .key_condition_expression("PK1 = :email AND begins_with(SK1, :prefix)")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query10_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("employee1"));
    assert_eq!(items[0]["EmployeeID"], ss("emp_001"));
    Ok(())
}

async fn run_query11(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 11: Get ticket history by ticket number
    // Key condition: PK=TicketNumber

    let query11_values = HashMap::from([entry(":ticket", "T-ticket_001")]);

    let query11_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_values(Some(query11_values))
        .key_condition_expression("PK = :ticket")
        .send()
        .await?;

    // Assert 2 items were returned
    let items = query11_response.items.unwrap();
    assert_eq!(items.len(), 2);

    // Expected to be `ticket1` and `ticket3`
    assert!(
        ((items[0]["partition_key"] == ss("ticket1"))
            && (items[1]["partition_key"] == ss("ticket2")))
            || ((items[0]["partition_key"] == ss("ticket2"))
                && (items[1]["partition_key"] == ss("ticket1")))
    );
    Ok(())
}

async fn run_query12(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 12: Get Ticket History by employee email
    // Key condition: PK1=CreatorEmail
    // Filter condition: PK=TicketNumber

    let query12_values = HashMap::from([
        entry(":email", "CE-zorro@gmail.com"),
        entry(":ticket", "T-ticket_001"),
    ]);

    let query12_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_values(Some(query12_values))
        .key_condition_expression("PK1 = :email")
        .filter_expression("PK = :ticket")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query12_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("ticket1"));
    assert_eq!(items[0]["TicketNumber"], ss("ticket_001"));
    Ok(())
}

async fn run_query13(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 13: Get ticket history by assignee email
    // Key condition: PK=AssigneeEmail
    // Filter condition: PK=ticketNumber
    let query13_values = HashMap::from([
        entry(":assigneeemail", "AE-able@gmail.com"),
        entry(":ticket", "T-ticket_001"),
    ]);

    let query13_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-2")
        .set_expression_attribute_values(Some(query13_values))
        .key_condition_expression("PK2 = :assigneeemail")
        .filter_expression("PK = :ticket")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query13_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("ticket1"));
    assert_eq!(items[0]["Subject"], ss("Bad bug"));
    Ok(())
}

async fn run_query14(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 14: Get employees by city.building.floor.desk
    // Key condition: PK3=city SK3 begins_with(building.floor.desk)

    let query14_values = HashMap::from([
        entry(":city", "C-Seattle"),
        entry(":location", "B-44~F-12~D-3"),
    ]);

    let query14_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-3")
        .set_expression_attribute_values(Some(query14_values))
        .key_condition_expression("PK3 = :city AND begins_with(SK3, :location)")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query14_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("employee1"));
    assert_eq!(items[0]["EmployeeID"], ss("emp_001"));
    assert_eq!(items[0]["Location"].as_m().unwrap()["Desk"], ss("3"));
    Ok(())
}

async fn run_query15(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 15: Get employees by manager email
    // Key condition: PK2 = ManagerEmail

    let query15_values = HashMap::from([entry(":manageremail", "ME-zorro@gmail.com")]);

    let query15_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-2")
        .set_expression_attribute_values(Some(query15_values))
        .key_condition_expression("PK2 = :manageremail")
        .send()
        .await?;

    // Assert 4 items returned:
    // Expected to be `employee1`, `employee2`, `employee3`, and `employee4`
    let items = query15_response.items.unwrap();
    assert_eq!(items.len(), 4);

    let mut found_known_value_item_query15 = false;
    for item in &items {
        if item["partition_key"] == ss("employee1") {
            found_known_value_item_query15 = true;
            assert_eq!(item["EmployeeID"], ss("emp_001"));
            assert_eq!(item["Location"].as_m().unwrap()["Desk"], ss("3"));
        }
    }

    assert!(found_known_value_item_query15);
    Ok(())
}

async fn run_query16(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 16: Get assigned tickets by assignee email
    // Key condition: PK2 = AssigneeEmail

    let query16_values = HashMap::from([entry(":assigneeemail", "AE-able@gmail.com")]);

    let query16_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-2")
        .set_expression_attribute_values(Some(query16_values))
        .key_condition_expression("PK2 = :assigneeemail")
        .send()
        .await?;

    // Assert 2 items were returned
    let items = query16_response.items.unwrap();
    assert_eq!(items.len(), 2);

    // Expected to be `ticket1` and `ticket4`
    assert!(
        ((items[0]["partition_key"] == ss("ticket1"))
            && (items[1]["partition_key"] == ss("ticket4")))
            || ((items[0]["partition_key"] == ss("ticket4"))
                && (items[1]["partition_key"] == ss("ticket1")))
    );
    Ok(())
}

async fn run_query17(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 17: Get tickets updated within the last 24 hours
    // Key condition: PK3 = Severity, SK3 > 24 hours ago
    // (For the sake of this example, we will assume
    //  the date is 2022-10-08T09:30:00, such that "24 hours ago"
    //  is 2022-10-07T09:30:00, and that our sample ticket record
    //  with TicketModTime=2022-10-07T14:32:25 will be returned.)

    let query17_values = HashMap::from([
        entry(":severity", "S-3"),
        entry(":yesterday", "M-2022-10-07T09:30:00"),
    ]);

    let query17_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-3")
        .set_expression_attribute_values(Some(query17_values))
        .key_condition_expression("PK3 = :severity AND SK3 > :yesterday")
        .send()
        .await?;

    // Assert 3 items returned:
    // Expected to be `ticket1`, `ticket2`, and `ticket4`

    let items = query17_response.items.unwrap();
    assert_eq!(items.len(), 3);

    let mut found_known_value_item_query17 = false;
    for item in &items {
        if item["partition_key"] == ss("ticket1") {
            found_known_value_item_query17 = true;
            assert_eq!(item["TicketNumber"], ss("ticket_001"));
        }
    }

    assert!(found_known_value_item_query17);
    Ok(())
}

async fn run_query18(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 18: Get projects by status, start and target date
    // Key condition: PK1 = Status, SK1 > StartDate
    // Filter condition: TargetDelivery < TargetDate

    let query18_values = HashMap::from([
        entry(":status", "PSts-Pending"),
        entry(":startdate", "PS-2022-01-01"),
        entry(":target", "2025-01-01"),
    ]);

    let query18_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-1")
        .set_expression_attribute_values(Some(query18_values))
        .key_condition_expression("PK1 = :status AND SK1 > :startdate")
        .filter_expression("ProjectTarget < :target")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query18_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("project1"));
    assert_eq!(items[0]["ProjectName"], ss("project_001"));
    Ok(())
}

async fn run_query19(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 19: Get projects by name
    // Key condition: PK = ProjectName, SK = ProjectName

    let query19_values = HashMap::from([entry(":projectname", "P-project_001")]);

    let query19_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_values(Some(query19_values))
        .key_condition_expression("PK = :projectname AND SK = :projectname")
        .send()
        .await?;

    // Assert 1 item was returned
    let items = query19_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("project1"));
    assert_eq!(items[0]["ProjectName"], ss("project_001"));
    Ok(())
}

async fn run_query20(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 20: Get Project History by date range (against timecard record)
    // Key condition: PK = ProjectName, SK between(date1, date2)

    let query20_values = HashMap::from([
        entry(":projectname", "P-project_002"),
        entry(":date1", "TC-2022-01-01"),
        entry(":date2", "TC-2023-01-01"),
    ]);

    let query20_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_values(Some(query20_values))
        .key_condition_expression("PK = :projectname AND SK BETWEEN :date1 AND :date2")
        .send()
        .await?;

    // Assert 2 items returned:
    // Expected to be `timecard1` and `timecard2`
    let items = query20_response.items.unwrap();
    assert_eq!(items.len(), 2);

    assert!(
        ((items[0]["partition_key"] == ss("timecard1"))
            && (items[1]["partition_key"] == ss("timecard2")))
            || ((items[0]["partition_key"] == ss("timecard2"))
                && (items[1]["partition_key"] == ss("timecard1")))
    );
    Ok(())
}

async fn run_query21(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 21: Get Project History by role
    // Key condition: PK = ProjectName
    // Filter condition: role=rolename

    let query21_names = HashMap::from([
        ("#role".to_string(), "Role".to_string()), // Role is a reserved word
    ]);

    let query21_values = HashMap::from([
        entry(":projectname", "P-project_002"),
        entry(":role", "SDE3"),
    ]);

    let query21_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_values(Some(query21_values))
        .set_expression_attribute_names(Some(query21_names))
        .key_condition_expression("PK = :projectname")
        .filter_expression("#role = :role")
        .send()
        .await?;

    // Assert 1 item was returned: `timecard1`
    let items = query21_response.items.unwrap();
    assert_eq!(items.len(), 1);

    // Known value test: Assert some properties the item
    assert_eq!(items[0]["partition_key"], ss("timecard1"));
    assert_eq!(items[0]["ProjectName"], ss("project_002"));
    Ok(())
}

async fn run_query22(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 22: Get reservations by building ID
    // Key condition: PK = Building ID

    let query22_values = HashMap::from([entry(":building", "B-SEA33")]);

    let query22_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_values(Some(query22_values))
        .key_condition_expression("PK = :building")
        .send()
        .await?;

    // Assert 2 items returned:
    // Expected to be `reservation1` and `reservation2`
    let items = query22_response.items.unwrap();
    assert_eq!(items.len(), 2);

    assert!(
        ((items[0]["partition_key"] == ss("reservation1"))
            && (items[1]["partition_key"] == ss("reservation2")))
            || ((items[0]["partition_key"] == ss("reservation2"))
                && (items[1]["partition_key"] == ss("reservation1")))
    );
    Ok(())
}

async fn run_query23(
    ddb_table_name: &str,
    ddb: &mut aws_sdk_dynamodb::Client,
) -> Result<(), crate::BoxError> {
    // Query 23: Get reservations by building ID and time range
    // Key condition: PK = Building ID, SK between(date1, date2)
    // Filter condition: Duration > 0

    let query23_names = HashMap::from([
        ("#duration".to_string(), "Duration".to_string()), // Duration is a reserved word
    ]);

    let query23_values = HashMap::from([
        entry(":building", "B-SEA33"),
        entry(":date1", "MS-2022-07-01"),
        entry(":date2", "MS-2022-07-08"),
        entry(":zero", "0"),
    ]);

    let query23_response = ddb
        .query()
        .table_name(ddb_table_name)
        .index_name("GSI-0")
        .set_expression_attribute_values(Some(query23_values))
        .set_expression_attribute_names(Some(query23_names))
        .key_condition_expression("PK = :building AND SK BETWEEN :date1 AND :date2")
        .filter_expression("#duration > :zero")
        .send()
        .await?;

    // Assert 2 items returned:
    // Expected to be `reservation1` and `reservation2`
    let items = query23_response.items.unwrap();
    assert_eq!(items.len(), 2);

    assert!(
        ((items[0]["partition_key"] == ss("reservation1"))
            && (items[1]["partition_key"] == ss("reservation2")))
            || ((items[0]["partition_key"] == ss("reservation2"))
                && (items[1]["partition_key"] == ss("reservation1")))
    );
    Ok(())
}
