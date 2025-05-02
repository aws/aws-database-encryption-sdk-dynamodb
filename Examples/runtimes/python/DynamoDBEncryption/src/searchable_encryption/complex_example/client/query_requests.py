# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Run all queries on the EncryptedClient."""


def run_queries(ddb_client, table_name):
    """Run all queries on the table."""
    run_query_1(ddb_client, table_name)
    run_query_2(ddb_client, table_name)
    run_query_3(ddb_client, table_name)
    run_query_4(ddb_client, table_name)
    run_query_5(ddb_client, table_name)
    run_query_6(ddb_client, table_name)
    run_query_7(ddb_client, table_name)
    run_query_8(ddb_client, table_name)
    run_query_9(ddb_client, table_name)
    run_query_10(ddb_client, table_name)
    run_query_11(ddb_client, table_name)
    run_query_12(ddb_client, table_name)
    run_query_13(ddb_client, table_name)
    run_query_14(ddb_client, table_name)
    run_query_15(ddb_client, table_name)
    run_query_16(ddb_client, table_name)
    run_query_17(ddb_client, table_name)
    run_query_18(ddb_client, table_name)
    run_query_19(ddb_client, table_name)
    run_query_20(ddb_client, table_name)
    run_query_21(ddb_client, table_name)
    run_query_22(ddb_client, table_name)
    run_query_23(ddb_client, table_name)


def run_query_1(ddb_client, table_name):
    """
    Query 1: Get meetings by date and email.

    Key condition: PK1 = email AND SK1 BETWEEN date1 AND date2.
    Filter condition: Duration > 0.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :email AND #sk1 BETWEEN :date1 AND :date2",
        FilterExpression="#dur > :zero",
        ExpressionAttributeNames={"#pk1": "PK1", "#sk1": "SK1", "#dur": "Duration"},
        ExpressionAttributeValues={
            ":email": {"S": "EE-able@gmail.com"},
            ":date1": {"S": "MS-2022-07-02"},
            ":date2": {"S": "MS-2022-07-08"},
            ":zero": {"S": "0"},
        },
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "meeting1":
            found_known_value_item = True
            assert item["Subject"]["S"] == "Scan Beacons"
            assert item["Location"]["M"]["Floor"]["S"] == "12"
            assert {"S": "zorro@gmail.com"} in item["Attendees"]["L"]

    assert found_known_value_item


def run_query_2(ddb_client, table_name):
    """
    Query 2: Get meetings by date and employeeID.

    Key condition: PK=employeeID SK between(date1, date2).
    Filter condition: duration > 0.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :empid AND #sk BETWEEN :date1 AND :date2",
        FilterExpression="#dur > :zero",
        ExpressionAttributeNames={"#pk": "PK", "#sk": "SK", "#dur": "Duration"},
        ExpressionAttributeValues={
            ":empid": {"S": "E-emp_001"},
            ":date1": {"S": "MS-2022-07-02"},
            ":date2": {"S": "MS-2022-07-08"},
            ":zero": {"S": "0"},
        },
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "meeting1":
            found_known_value_item = True
            assert item["Subject"]["S"] == "Scan Beacons"
            assert item["Location"]["M"]["Floor"]["S"] == "12"
            assert {"S": "zorro@gmail.com"} in item["Attendees"]["L"]

    assert found_known_value_item


def run_query_3(ddb_client, table_name):
    """
    Query 3: Get meetings by date and building/floor/room.

    Key condition: PK=employeeID SK between(date1, date2).
    Filter condition: SK contains building.floor.room (see NOTE).
    NOTE: This query is modified from Demo.md.
          Demo.md calls for a filter condition "SK contains building.floor.room"
          However, one cannot use primary keys (partition nor sort) in a filter expression.
          Instead, this query filters on the individual beacon attributes: building, floor, and room.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :building AND #sk BETWEEN :date1 AND :date2",
        FilterExpression="#b = :b AND #f = :f AND #r = :r",
        ExpressionAttributeNames={"#pk": "PK", "#sk": "SK", "#b": "Building", "#f": "Floor", "#r": "Room"},
        ExpressionAttributeValues={
            ":building": {"S": "B-SEA33"},
            ":date1": {"S": "MS-2022-07-02"},
            ":date2": {"S": "MS-2022-07-08"},
            ":b": {"S": "SEA33"},
            ":f": {"S": "12"},
            ":r": {"S": "403"},
        },
    )
    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1
    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"] == "reservation1":
            found_known_value_item = True
        if item["partition_key"]["S"] == "reservation1":
            assert item["Subject"]["S"] == "Scan beacons"
            assert item["Location"]["M"]["Building"]["S"] == "SEA33"
            assert {"S": "barney@gmail.com"} in item["Attendees"]["L"]

    assert found_known_value_item


def run_query_4(ddb_client, table_name):
    """
    Query 4: Get employee data by email.

    Key condition: PK1=email SK1=employee ID.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :email AND #sk1 = :empid",
        ExpressionAttributeNames={"#pk1": "PK1", "#sk1": "SK1"},
        ExpressionAttributeValues={":email": {"S": "EE-able@gmail.com"}, ":empid": {"S": "E-emp_001"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "employee1":
            found_known_value_item = True
            assert item["EmployeeID"]["S"] == "emp_001"
            assert item["Location"]["M"]["Desk"]["S"] == "3"

    assert found_known_value_item


def run_query_5(ddb_client, table_name):
    """
    Query 5: Get meetings by email.

    Key condition: PK1=email SK1 > 30 days ago.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :email AND #sk1 BETWEEN :date1 AND :date2",
        ExpressionAttributeNames={"#pk1": "PK1", "#sk1": "SK1"},
        ExpressionAttributeValues={
            ":email": {"S": "EE-able@gmail.com"},
            ":date1": {"S": "MS-"},
            ":date2": {"S": "MS-2023-03-20"},
        },
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert exactly 1 item is returned
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "meeting1":
            found_known_value_item = True
            assert item["Subject"]["S"] == "Scan Beacons"
            assert item["Location"]["M"]["Floor"]["S"] == "12"
            assert {"S": "zorro@gmail.com"} in item["Attendees"]["L"]

    assert found_known_value_item


def run_query_6(ddb_client, table_name):
    """
    Query 6: Get tickets by email.

    Key condition: PK1=email SK1 > 30 days ago.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :email AND #sk1 < :date",
        ExpressionAttributeNames={"#pk1": "PK1", "#sk1": "SK1"},
        ExpressionAttributeValues={":email": {"S": "CE-zorro@gmail.com"}, ":date": {"S": "MS-2023-03-20"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `ticket1` and `ticket3`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"]["S"] == "ticket_001"

    assert found_known_value_item


def run_query_7(ddb_client, table_name):
    """
    Query 7: Get reservations by email.

    Key condition: PK1=organizeremail SK1 > 30 days ago.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :email AND #sk1 < :date",
        ExpressionAttributeNames={"#pk1": "PK1", "#sk1": "SK1"},
        ExpressionAttributeValues={":email": {"S": "OE-able@gmail.com"}, ":date": {"S": "MS-2023-03-20"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `reservation1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "reservation1":
            found_known_value_item = True
            assert item["Subject"]["S"] == "Scan beacons"
            assert item["Location"]["M"]["Floor"]["S"] == "12"
            assert {"S": "barney@gmail.com"} in item["Attendees"]["L"]

    assert found_known_value_item


def run_query_8(ddb_client, table_name):
    """
    Query 8: Get time cards by email.

    Key condition: PK1=employeeemail SK1 > 30 days ago.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :email AND #sk1 BETWEEN :date1 AND :date2",
        ExpressionAttributeNames={"#pk1": "PK1", "#sk1": "SK1"},
        ExpressionAttributeValues={
            ":email": {"S": "EE-able@gmail.com"},
            ":date1": {"S": "TC-"},
            ":date2": {"S": "TC-2023-03-20"},
        },
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `timecard1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "timecard1":
            found_known_value_item = True
            assert item["ProjectName"]["S"] == "project_002"

    assert found_known_value_item


def run_query_9(ddb_client, table_name):
    """
    Query 9: Get employee info by employee ID.

    Key condition: PK1=employeeID SK starts with "E-".
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :empid AND begins_with(#sk, :prefix)",
        ExpressionAttributeNames={"#pk": "PK", "#sk": "SK"},
        ExpressionAttributeValues={":empid": {"S": "E-emp_001"}, ":prefix": {"S": "E-"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `employee1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "employee1":
            found_known_value_item = True
            assert item["EmployeeID"]["S"] == "emp_001"

    assert found_known_value_item


def run_query_10(ddb_client, table_name):
    """
    Query 10: Get employee info by email.

    Key condition: PK1=email.
    Filter condition: SK starts with "E-".
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :email AND begins_with(#sk1, :prefix)",
        ExpressionAttributeNames={"#pk1": "PK1", "#sk1": "SK1"},
        ExpressionAttributeValues={":email": {"S": "EE-able@gmail.com"}, ":prefix": {"S": "E-"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `employee1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "employee1":
            found_known_value_item = True
            assert item["EmployeeID"]["S"] == "emp_001"

    assert found_known_value_item


def run_query_11(ddb_client, table_name):
    """
    Query 11: Get ticket history by ticket number.

    Key condition: PK=TicketNumber.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :ticketnum",
        ExpressionAttributeNames={"#pk": "PK"},
        ExpressionAttributeValues={":ticketnum": {"S": "T-ticket_001"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `ticket1` and `ticket2`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"]["S"] == "ticket_001"

    assert found_known_value_item


def run_query_12(ddb_client, table_name):
    """
    Query 12: Get Ticket History by employee email.

    Key condition: PK1=CreatorEmail.
    Filter condition: PK=TicketNumber.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :email",
        FilterExpression="#pk = :ticketnum",
        ExpressionAttributeNames={"#pk1": "PK1", "#pk": "PK"},
        ExpressionAttributeValues={":email": {"S": "CE-zorro@gmail.com"}, ":ticketnum": {"S": "T-ticket_001"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `ticket1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"]["S"] == "ticket_001"

    assert found_known_value_item


def run_query_13(ddb_client, table_name):
    """
    Query 13: Get ticket history by assignee email.

    Key condition: PK=AssigneeEmail.
    Filter condition: PK=ticketNumber.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-2",
        KeyConditionExpression="#pk2 = :assignee",
        FilterExpression="#pk = :ticketnum",
        ExpressionAttributeNames={"#pk2": "PK2", "#pk": "PK"},
        ExpressionAttributeValues={":assignee": {"S": "AE-able@gmail.com"}, ":ticketnum": {"S": "T-ticket_001"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `ticket1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "ticket1":
            found_known_value_item = True
            assert item["Subject"]["S"] == "Bad bug"

    assert found_known_value_item


def run_query_14(ddb_client, table_name):
    """
    Query 14: Get employees by city.building.floor.desk.

    Key condition: PK3=city SK3 begins_with(building.floor.desk).
    """
    for i in range(10):
        response = ddb_client.query(
            TableName=table_name,
            IndexName="GSI-3",
            KeyConditionExpression="#pk3 = :city AND begins_with(#sk3, :location)",
            ExpressionAttributeNames={"#pk3": "PK3", "#sk3": "SK3"},
            ExpressionAttributeValues={":city": {"S": "C-Seattle"}, ":location": {"S": "B-44~F-12~D-3"}},
        )

        # Validate query response
        assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

        # Assert 1 item was returned: `employee1`
        assert len(response["Items"]) == 1

        # Check known values in the response
        found_known_value_item = False
        for item in response["Items"]:
            if item["partition_key"]["S"] == "employee1":
                found_known_value_item = True
                assert item["EmployeeID"]["S"] == "emp_001"
                assert item["Location"]["M"]["Desk"]["S"] == "3"

        assert found_known_value_item
        break

    # Assert the value was found inside the loop
    assert found_known_value_item


def run_query_15(ddb_client, table_name):
    """
    Query 15: Get employees by manager email.

    Key condition: PK2 = ManagerEmail.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-2",
        KeyConditionExpression="#pk2 = :manager",
        ExpressionAttributeNames={"#pk2": "PK2"},
        ExpressionAttributeValues={":manager": {"S": "ME-zorro@gmail.com"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 4 items returned:
    # Expected to be `employee1`, `employee2`, `employee3`, and `employee4`
    assert len(response["Items"]) == 4

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "employee1":
            found_known_value_item = True
            assert item["EmployeeID"]["S"] == "emp_001"
            assert item["Location"]["M"]["Desk"]["S"] == "3"

    assert found_known_value_item


def run_query_16(ddb_client, table_name):
    """
    Query 16: Get assigned tickets by assignee email.

    Key condition: PK2 = AssigneeEmail.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-2",
        KeyConditionExpression="#pk2 = :assignee",
        ExpressionAttributeNames={"#pk2": "PK2"},
        ExpressionAttributeValues={":assignee": {"S": "AE-able@gmail.com"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `ticket1` and `ticket4`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"]["S"] == "ticket_001"

    assert found_known_value_item


def run_query_17(ddb_client, table_name):
    """
    Query 17: Get tickets updated within the last 24 hours.

    Key condition: PK3 = Severity, SK3 > 24 hours ago.
    (For the sake of this example, we will assume
     the date is 2022-10-08T09:30:00, such that "24 hours ago"
     is 2022-10-07T09:30:00, and that our sample ticket record
     with TicketModTime=2022-10-07T14:32:25 will be returned.)
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-3",
        KeyConditionExpression="#pk3 = :severity AND #sk3 > :date",
        ExpressionAttributeNames={"#pk3": "PK3", "#sk3": "SK3"},
        ExpressionAttributeValues={":severity": {"S": "S-3"}, ":date": {"S": "M-2022-10-07T09:30:00"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 3 items returned:
    # Expected to be `ticket1`, `ticket2`, and `ticket4`
    assert len(response["Items"]) == 3

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "ticket1":
            found_known_value_item = True
            assert item["TicketNumber"]["S"] == "ticket_001"

    assert found_known_value_item


def run_query_18(ddb_client, table_name):
    """
    Query 18: Get projects by status, start and target date.

    Key condition: PK1 = Status, SK1 > StartDate.
    Filter condition: TargetDelivery < TargetDate.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-1",
        KeyConditionExpression="#pk1 = :status AND #sk1 > :startdate",
        FilterExpression="#target < :targetdate",
        ExpressionAttributeNames={"#pk1": "PK1", "#sk1": "SK1", "#target": "ProjectTarget"},
        ExpressionAttributeValues={
            ":status": {"S": "PSts-Pending"},
            ":startdate": {"S": "PS-2022-01-01"},
            ":targetdate": {"S": "2025-01-01"},
        },
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `project1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "project1":
            found_known_value_item = True
            assert item["ProjectName"]["S"] == "project_001"

    assert found_known_value_item


def run_query_19(ddb_client, table_name):
    """
    Query 19: Get projects by name.

    Key condition: PK = ProjectName, SK = ProjectName.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :projname AND #sk = :projname",
        ExpressionAttributeNames={"#pk": "PK", "#sk": "SK"},
        ExpressionAttributeValues={":projname": {"S": "P-project_001"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `project1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "project1":
            found_known_value_item = True
            assert item["ProjectName"]["S"] == "project_001"

    assert found_known_value_item


def run_query_20(ddb_client, table_name):
    """
    Query 20: Get Project History by date range (against timecard record).

    Key condition: PK = ProjectName, SK between(date1, date2).
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :projname AND #sk BETWEEN :date1 AND :date2",
        ExpressionAttributeNames={"#pk": "PK", "#sk": "SK"},
        ExpressionAttributeValues={
            ":projname": {"S": "P-project_002"},
            ":date1": {"S": "TC-2022-01-01"},
            ":date2": {"S": "TC-2023-01-01"},
        },
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `timecard1` and `timecard2`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "timecard1":
            found_known_value_item = True
            assert item["ProjectName"]["S"] == "project_002"

    assert found_known_value_item


def run_query_21(ddb_client, table_name):
    """
    Query 21: Get Project History by role.

    Key condition: PK = ProjectName.
    Filter condition: role=rolename.
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :projname",
        FilterExpression="#role = :rolename",
        ExpressionAttributeNames={"#pk": "PK", "#role": "Role"},
        ExpressionAttributeValues={":projname": {"S": "P-project_002"}, ":rolename": {"S": "SDE3"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 1 item was returned: `timecard1`
    assert len(response["Items"]) == 1

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "timecard1":
            found_known_value_item = True
            assert item["ProjectName"]["S"] == "project_002"

    assert found_known_value_item


def run_query_22(ddb_client, table_name):
    """
    Query 22: Get reservations by building ID.

    Key condition: PK = Building ID
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :building",
        ExpressionAttributeNames={"#pk": "PK"},
        ExpressionAttributeValues={":building": {"S": "B-SEA33"}},
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `reservation1` and `reservation2`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "reservation1":
            found_known_value_item = True
            assert item["Subject"]["S"] == "Scan beacons"

    assert found_known_value_item


def run_query_23(ddb_client, table_name):
    """
    Query 23: Get reservations by building ID and time range.

    Key condition: PK = Building ID, SK between(date1, date2)
    Filter condition: Duration > 0
    """
    response = ddb_client.query(
        TableName=table_name,
        IndexName="GSI-0",
        KeyConditionExpression="#pk = :building AND #sk BETWEEN :date1 AND :date2",
        FilterExpression="#dur > :zero",
        ExpressionAttributeNames={"#pk": "PK", "#sk": "SK", "#dur": "Duration"},
        ExpressionAttributeValues={
            ":building": {"S": "B-SEA33"},
            ":date1": {"S": "MS-2022-07-01"},
            ":date2": {"S": "MS-2022-07-08"},
            ":zero": {"S": "0"},
        },
    )

    # Validate query response
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Assert 2 items returned:
    # Expected to be `reservation1` and `reservation2`
    assert len(response["Items"]) == 2

    # Check known values in the response
    found_known_value_item = False
    for item in response["Items"]:
        if item["partition_key"]["S"] == "reservation1":
            found_known_value_item = True
            assert item["Subject"]["S"] == "Scan beacons"

    assert found_known_value_item
