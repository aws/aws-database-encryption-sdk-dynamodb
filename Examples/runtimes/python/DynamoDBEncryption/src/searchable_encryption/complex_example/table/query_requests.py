# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Run all queries on the EncryptedTables."""
from boto3.dynamodb.conditions import Attr, Key


def run_queries(table):
    """Run all queries on the table."""
    run_query_1(table)
    run_query_2(table)
    run_query_3(table)
    run_query_4(table)
    run_query_5(table)
    run_query_6(table)
    run_query_7(table)
    run_query_8(table)
    run_query_9(table)
    run_query_10(table)
    run_query_11(table)
    run_query_12(table)
    run_query_13(table)
    run_query_14(table)
    run_query_15(table)
    run_query_16(table)
    run_query_17(table)
    run_query_18(table)
    run_query_19(table)
    run_query_20(table)
    run_query_21(table)
    run_query_22(table)
    run_query_23(table)


def run_query_1(table):
    """
    Query 1: Get meetings by date and email.

    Key condition: PK1 = email AND SK1 BETWEEN date1 AND date2.
    Filter condition: Duration > 0.
    """
    key_condition = Key("PK1").eq("EE-able@gmail.com") & Key("SK1").between("MS-2022-07-02", "MS-2022-07-08")
    filter_condition = Attr("Duration").gt("0")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition, FilterExpression=filter_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "meeting1":
            found_known_value_item = True
            assert item["Subject"] == "Scan Beacons"
            assert item["Location"]["Floor"] == "12"
            assert "zorro@gmail.com" in item["Attendees"]

    assert found_known_value_item


def run_query_2(table):
    """
    Query 2: Get meetings by date and employeeID.

    Key condition: PK=employeeID SK between(date1, date2).
    Filter condition: duration > 0.
    """
    key_condition = Key("PK").eq("E-emp_001") & Key("SK").between("MS-2022-07-02", "MS-2022-07-08")
    filter_condition = Attr("Duration").gt("0")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition, FilterExpression=filter_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "meeting1":
            found_known_value_item = True
            assert item["Subject"] == "Scan Beacons"
            assert item["Location"]["Floor"] == "12"
            assert "zorro@gmail.com" in item["Attendees"]

    assert found_known_value_item


def run_query_3(table):
    """
    Query 3: Get meetings by date and building/floor/room.

    Key condition: PK=employeeID SK between(date1, date2)
    Filter condition: SK contains building.floor.room (see NOTE)
    NOTE: This query is modified from Demo.md.
          Demo.md calls for a filter condition "SK contains building.floor.room"
          However, one cannot use primary keys (partition nor sort) in a filter expression.
          Instead, this query filters on the individual beacon attributes: building, floor, and room.
    """
    key_condition = Key("PK").eq("B-SEA33") & Key("SK").between("MS-2022-07-02", "MS-2022-07-08")
    filter_condition = Attr("Building").eq("SEA33") & Attr("Floor").eq("12") & Attr("Room").eq("403")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition, FilterExpression=filter_condition)
    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1
    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "reservation1":
            found_known_value_item = True
            assert item["Subject"] == "Scan beacons"
            assert item["Location"]["Building"] == "SEA33"
            assert "barney@gmail.com" in item["Attendees"]

    assert found_known_value_item


def run_query_4(table):
    """
    Query 4: Get employee data by email.

    Key condition: PK1=email SK1=employee ID.
    """
    key_condition = Key("PK1").eq("EE-able@gmail.com") & Key("SK1").eq("E-emp_001")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "employee1":
            found_known_value_item = True
            assert item["EmployeeID"] == "emp_001"
            assert item["Location"]["Desk"] == "3"

    assert found_known_value_item


def run_query_5(table):
    """
    Query 5: Get meetings by email.

    Key condition: PK1=email SK1 > 30 days ago.
    """
    key_condition = Key("PK1").eq("EE-able@gmail.com") & Key("SK1").between("MS-", "MS-2023-03-20")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "meeting1":
            found_known_value_item = True
            assert item["Subject"] == "Scan Beacons"
            assert item["Location"]["Floor"] == "12"
            assert "zorro@gmail.com" in item["Attendees"]

    assert found_known_value_item


def run_query_6(table):
    """
    Query 6: Get tickets by email.

    Key condition: PK1=email SK1 > 30 days ago.
    """
    key_condition = Key("PK1").eq("CE-zorro@gmail.com") & Key("SK1").lt("MS-2023-03-20")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `ticket1` and `ticket3`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"] == "ticket_001"

    assert found_known_value_item


def run_query_7(table):
    """
    Query 7: Get reservations by email.

    Key condition: PK1=organizeremail SK1 > 30 days ago.
    """
    key_condition = Key("PK1").eq("OE-able@gmail.com") & Key("SK1").lt("MS-2023-03-20")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `reservation1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "reservation1":
            found_known_value_item = True
            assert item["Subject"] == "Scan beacons"
            assert item["Location"]["Floor"] == "12"
            assert "barney@gmail.com" in item["Attendees"]

    assert found_known_value_item


def run_query_8(table):
    """
    Query 8: Get time cards by email.

    Key condition: PK1=employeeemail SK1 > 30 days ago.
    """
    key_condition = Key("PK1").eq("EE-able@gmail.com") & Key("SK1").between("TC-", "TC-2023-03-20")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `timecard1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "timecard1":
            found_known_value_item = True
            assert item["ProjectName"] == "project_002"

    assert found_known_value_item


def run_query_9(table):
    """
    Query 9: Get employee info by employee ID.

    Key condition: PK1=employeeID SK starts with "E-"
    """
    key_condition = Key("PK").eq("E-emp_001") & Key("SK").begins_with("E-")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `employee1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "employee1":
            found_known_value_item = True
            assert item["EmployeeID"] == "emp_001"

    assert found_known_value_item


def run_query_10(table):
    """
    Query 10: Get employee info by email.

    Key condition: PK1=email
    Filter condition: SK starts with "E-"
    """
    key_condition = Key("PK1").eq("EE-able@gmail.com") & Key("SK1").begins_with("E-")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `employee1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "employee1":
            found_known_value_item = True
            assert item["EmployeeID"] == "emp_001"

    assert found_known_value_item


def run_query_11(table):
    """
    Query 11: Get ticket history by ticket number.

    Key condition: PK=TicketNumber
    """
    key_condition = Key("PK").eq("T-ticket_001")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `ticket1` and `ticket2`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"] == "ticket_001"

    assert found_known_value_item


def run_query_12(table):
    """
    Query 12: Get Ticket History by employee email.

    Key condition: PK1=CreatorEmail
    Filter condition: PK=TicketNumber
    """
    key_condition = Key("PK1").eq("CE-zorro@gmail.com")
    filter_condition = Attr("PK").eq("T-ticket_001")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition, FilterExpression=filter_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `ticket1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"] == "ticket_001"

    assert found_known_value_item


def run_query_13(table):
    """
    Query 13: Get ticket history by assignee email.

    Key condition: PK=AssigneeEmail
    Filter condition: PK=ticketNumber
    """
    key_condition = Key("PK2").eq("AE-able@gmail.com")
    filter_condition = Attr("PK").eq("T-ticket_001")

    response = table.query(IndexName="GSI-2", KeyConditionExpression=key_condition, FilterExpression=filter_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `ticket1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "ticket1":
            found_known_value_item = True
            assert item["Subject"] == "Bad bug"

    assert found_known_value_item


def run_query_14(table):
    """
    Query 14: Get employees by city.building.floor.desk.

    Key condition: PK3=city SK3 begins_with(building.floor.desk)
    """
    key_condition = Key("PK3").eq("C-Seattle") & Key("SK3").begins_with("B-44~F-12~D-3")

    # Execute query with retries since GSIs don't update instantly
    for i in range(10):
        response = table.query(IndexName="GSI-3", KeyConditionExpression=key_condition)

        # Validate query response
        assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

        # If no results, retry after short sleep
        if len(response["Items"]) == 0:
            import time

            time.sleep(0.02)
            continue

        # Assert 1 item was returned: `employee1`
        assert len(response["Items"]) == 1

        # Check known values in the response
        found_known_value_item = False
        for item in response["Items"]:
            if item["partition_key"] == "employee1":
                found_known_value_item = True
                assert item["EmployeeID"] == "emp_001"
                assert item["Location"]["Desk"] == "3"

        assert found_known_value_item
        break

    # Assert the value was found inside the loop
    assert found_known_value_item


def run_query_15(table):
    """
    Query 15: Get employees by manager email.

    Key condition: PK2 = ManagerEmail
    """
    key_condition = Key("PK2").eq("ME-zorro@gmail.com")

    response = table.query(IndexName="GSI-2", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 4 items returned:
    # Expected to be `employee1`, `employee2`, `employee3`, and `employee4`
    assert len(response["Items"]) == 4

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "employee1":
            found_known_value_item = True
            assert item["EmployeeID"] == "emp_001"
            assert item["Location"]["Desk"] == "3"

    assert found_known_value_item


def run_query_16(table):
    """
    Query 16: Get assigned tickets by assignee email.

    Key condition: PK2 = AssigneeEmail
    """
    key_condition = Key("PK2").eq("AE-able@gmail.com")

    response = table.query(IndexName="GSI-2", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `ticket1` and `ticket4`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"] == "ticket_001"

    assert found_known_value_item


def run_query_17(table):
    """
    Query 17: Get tickets updated within the last 24 hours.

    Key condition: PK3 = Severity, SK3 > 24 hours ago
    (For the sake of this example, we will assume
     the date is 2022-10-08T09:30:00, such that "24 hours ago"
     is 2022-10-07T09:30:00, and that our sample ticket record
     with TicketModTime=2022-10-07T14:32:25 will be returned.)
    """
    key_condition = Key("PK3").eq("S-3") & Key("SK3").gt("M-2022-10-07T09:30:00")

    response = table.query(IndexName="GSI-3", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 3 items returned:
    # Expected to be `ticket1`, `ticket2`, and `ticket4`
    assert len(response["Items"]) == 3

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"] == "ticket_001"

    assert found_known_value_item


def run_query_18(table):
    """
    Query 18: Get projects by status, start and target date.

    Key condition: PK1 = Status, SK1 > StartDate
    Filter condition: TargetDelivery < TargetDate
    """
    key_condition = Key("PK1").eq("PSts-Pending") & Key("SK1").gt("PS-2022-01-01")
    filter_condition = Attr("ProjectTarget").lt("2025-01-01")

    response = table.query(IndexName="GSI-1", KeyConditionExpression=key_condition, FilterExpression=filter_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `project1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "project1":
            found_known_value_item = True
            assert item["ProjectName"] == "project_001"

    assert found_known_value_item


def run_query_19(table):
    """
    Query 19: Get projects by name.

    Key condition: PK = ProjectName, SK = ProjectName
    """
    key_condition = Key("PK").eq("P-project_001") & Key("SK").eq("P-project_001")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `project1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "project1":
            found_known_value_item = True
            assert item["ProjectName"] == "project_001"

    assert found_known_value_item


def run_query_20(table):
    """
    Query 20: Get Project History by date range (against timecard record).

    Key condition: PK = ProjectName, SK between(date1, date2)
    """
    key_condition = Key("PK").eq("P-project_002") & Key("SK").between("TC-2022-01-01", "TC-2023-01-01")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `timecard1` and `timecard2`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "timecard1":
            found_known_value_item = True
            assert item["ProjectName"] == "project_002"

    assert found_known_value_item


def run_query_21(table):
    """
    Query 21: Get Project History by role.

    Key condition: PK = ProjectName
    Filter condition: role=rolename
    """
    key_condition = Key("PK").eq("P-project_002")
    filter_condition = Attr("Role").eq("SDE3")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition, FilterExpression=filter_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `timecard1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "timecard1":
            found_known_value_item = True
            assert item["ProjectName"] == "project_002"

    assert found_known_value_item


def run_query_22(table):
    """
    Query 22: Get reservations by building ID.

    Key condition: PK = Building ID
    """
    key_condition = Key("PK").eq("B-SEA33")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `reservation1` and `reservation2`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "reservation1":
            found_known_value_item = True
            assert item["Subject"] == "Scan beacons"

    assert found_known_value_item


def run_query_23(table):
    """
    Query 23: Get reservations by building ID and time range.

    Key condition: PK = Building ID, SK between(date1, date2)
    Filter condition: Duration > 0
    """
    key_condition = Key("PK").eq("B-SEA33") & Key("SK").between("MS-2022-07-01", "MS-2022-07-08")
    filter_condition = Attr("Duration").gt("0")

    response = table.query(IndexName="GSI-0", KeyConditionExpression=key_condition, FilterExpression=filter_condition)

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `reservation1` and `reservation2`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "reservation1":
            found_known_value_item = True
            assert item["Subject"] == "Scan beacons"

    assert found_known_value_item
