# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Put all items into the table."""


def put_all_meeting_items_to_table(ddb_table_name, ddb):
    """Put all meeting items into the table."""
    meetings = [
        {
            "partition_key": {"S": "meeting1"},
            "EmployeeID": {"S": "emp_001"},
            "EmployeeEmail": {"S": "able@gmail.com"},
            "MeetingStart": {"S": "2022-07-04T13:00"},
            "Location": {"M": {"Floor": {"S": "12"}, "Room": {"S": "403"}}},
            "Duration": {"S": "30"},
            "Attendees": {"L": [{"S": "able@gmail.com"}, {"S": "zorro@gmail.com"}]},
            "Subject": {"S": "Scan Beacons"},
        },
        {
            "partition_key": {"S": "meeting2"},
            "EmployeeID": {"S": "emp_002"},
            "EmployeeEmail": {"S": "barney@gmail.com"},
            "MeetingStart": {"S": "2022-07-04T13:00"},
            "Location": {"M": {"Floor": {"S": "12"}, "Room": {"S": "403"}}},
            "Duration": {"S": "30"},
            "Attendees": {"L": [{"S": "barney@gmail.com"}, {"S": "zorro@gmail.com"}]},
            "Subject": {"S": "Scan Beacons"},
        },
        {
            "partition_key": {"S": "meeting3"},
            "EmployeeID": {"S": "emp_003"},
            "EmployeeEmail": {"S": "charlie@gmail.com"},
            "MeetingStart": {"S": "2022-07-04T13:00"},
            "Location": {"M": {"Floor": {"S": "12"}, "Room": {"S": "403"}}},
            "Duration": {"S": "30"},
            "Attendees": {"L": [{"S": "charlie@gmail.com"}, {"S": "zorro@gmail.com"}]},
            "Subject": {"S": "Scan Beacons"},
        },
        {
            "partition_key": {"S": "meeting4"},
            "EmployeeID": {"S": "emp_004"},
            "EmployeeEmail": {"S": "david@gmail.com"},
            "MeetingStart": {"S": "2022-07-04T13:00"},
            "Location": {"M": {"Floor": {"S": "12"}, "Room": {"S": "403"}}},
            "Duration": {"S": "30"},
            "Attendees": {"L": [{"S": "david@gmail.com"}, {"S": "zorro@gmail.com"}]},
            "Subject": {"S": "Scan Beacons"},
        },
        {
            "partition_key": {"S": "meeting5"},
            "EmployeeID": {"S": "emp_002"},
            "EmployeeEmail": {"S": "barney@gmail.com"},
            "MeetingStart": {"S": "2022-07-04T14:00"},
            "Location": {"M": {"Floor": {"S": "12"}, "Room": {"S": "407"}}},
            "Duration": {"S": "30"},
            "Attendees": {"L": [{"S": "barney@gmail.com"}, {"S": "zorro@gmail.com"}]},
            "Subject": {"S": "DB ESDK"},
        },
        {
            "partition_key": {"S": "meeting6"},
            "EmployeeID": {"S": "emp_003"},
            "EmployeeEmail": {"S": "charlie@gmail.com"},
            "MeetingStart": {"S": "2022-07-04T14:00"},
            "Location": {"M": {"Floor": {"S": "12"}, "Room": {"S": "407"}}},
            "Duration": {"S": "30"},
            "Attendees": {"L": [{"S": "charlie@gmail.com"}, {"S": "zorro@gmail.com"}]},
            "Subject": {"S": "DB ESDK"},
        },
    ]

    for meeting in meetings:
        ddb.put_item(TableName=ddb_table_name, Item=meeting)


def put_all_employee_items_to_table(ddb_table_name, ddb):
    """Put all employee items into the table."""
    employees = [
        {
            "partition_key": {"S": "employee1"},
            "EmployeeID": {"S": "emp_001"},
            "EmployeeEmail": {"S": "able@gmail.com"},
            "ManagerEmail": {"S": "zorro@gmail.com"},
            "EmployeeName": {"S": "Able Jones"},
            "EmployeeTitle": {"S": "SDE9"},
            "Location": {
                "M": {"Building": {"S": "44"}, "Floor": {"S": "12"}, "Desk": {"S": "3"}, "City": {"S": "Seattle"}}
            },
        },
        {
            "partition_key": {"S": "employee2"},
            "EmployeeID": {"S": "emp_002"},
            "EmployeeEmail": {"S": "barney@gmail.com"},
            "ManagerEmail": {"S": "zorro@gmail.com"},
            "EmployeeName": {"S": "Barney Jones"},
            "EmployeeTitle": {"S": "SDE8"},
            "Location": {
                "M": {"Building": {"S": "44"}, "Floor": {"S": "12"}, "Desk": {"S": "4"}, "City": {"S": "Seattle"}}
            },
        },
        {
            "partition_key": {"S": "employee3"},
            "EmployeeID": {"S": "emp_003"},
            "EmployeeEmail": {"S": "charlie@gmail.com"},
            "ManagerEmail": {"S": "zorro@gmail.com"},
            "EmployeeName": {"S": "Charlie Jones"},
            "EmployeeTitle": {"S": "SDE7"},
            "Location": {
                "M": {"Building": {"S": "44"}, "Floor": {"S": "4"}, "Desk": {"S": "5"}, "City": {"S": "Seattle"}}
            },
        },
        {
            "partition_key": {"S": "employee4"},
            "EmployeeID": {"S": "emp_004"},
            "EmployeeEmail": {"S": "david@gmail.com"},
            "ManagerEmail": {"S": "zorro@gmail.com"},
            "EmployeeName": {"S": "David Jones"},
            "EmployeeTitle": {"S": "SDE6"},
            "Location": {"M": {"Building": {"S": "22"}, "Floor": {"S": "1"}, "Desk": {"S": "3"}, "City": {"S": "NYC"}}},
        },
    ]

    for employee in employees:
        ddb.put_item(TableName=ddb_table_name, Item=employee)


def put_all_project_items_to_table(ddb_table_name, ddb):
    """Put all project items into the table."""
    projects = [
        {
            "partition_key": {"S": "project1"},
            "ProjectName": {"S": "project_001"},
            "ProjectStatus": {"S": "Pending"},
            "ProjectStart": {"S": "2022-11-01"},
            "Description": {"S": "Turbo Crypto"},
            "ProjectTarget": {"S": "2024-01-01"},
        },
        {
            "partition_key": {"S": "project2"},
            "ProjectName": {"S": "project_002"},
            "ProjectStatus": {"S": "Active"},
            "ProjectStart": {"S": "2022-07-04"},
            "Description": {"S": "Scan Beacons"},
            "ProjectTarget": {"S": "2024-01-01"},
        },
        {
            "partition_key": {"S": "project3"},
            "ProjectName": {"S": "project_003"},
            "ProjectStatus": {"S": "Active"},
            "ProjectStart": {"S": "2022-08-05"},
            "Description": {"S": "DB ESDK"},
            "ProjectTarget": {"S": "2023-02-27"},
        },
        {
            "partition_key": {"S": "project4"},
            "ProjectName": {"S": "project_004"},
            "ProjectStatus": {"S": "Done"},
            "ProjectStart": {"S": "2020-03-03"},
            "Description": {"S": "S3EC"},
            "ProjectTarget": {"S": "2021-09-05"},
        },
    ]

    for project in projects:
        ddb.put_item(TableName=ddb_table_name, Item=project)


def put_all_reservation_items_to_table(ddb_table_name, ddb):
    """Put all reservation items into the table."""
    reservations = [
        {
            "partition_key": {"S": "reservation1"},
            "Location": {"M": {"Building": {"S": "SEA33"}, "Floor": {"S": "12"}, "Room": {"S": "403"}}},
            "MeetingStart": {"S": "2022-07-04T13:00"},
            "OrganizerEmail": {"S": "able@gmail.com"},
            "Duration": {"S": "30"},
            "Attendees": {"L": [{"S": "able@gmail.com"}, {"S": "barney@gmail.com"}]},
            "Subject": {"S": "Scan beacons"},
        },
        {
            "partition_key": {"S": "reservation2"},
            "Location": {"M": {"Building": {"S": "SEA33"}, "Floor": {"S": "12"}, "Room": {"S": "407"}}},
            "MeetingStart": {"S": "2022-07-04T14:00"},
            "OrganizerEmail": {"S": "barney@gmail.com"},
            "Duration": {"S": "30"},
            "Attendees": {"L": [{"S": "able@gmail.com"}, {"S": "barney@gmail.com"}]},
            "Subject": {"S": "DB ESDK"},
        },
    ]

    for reservation in reservations:
        ddb.put_item(TableName=ddb_table_name, Item=reservation)


def put_all_ticket_items_to_table(ddb_table_name, ddb):
    """Put all ticket items into the table."""
    tickets = [
        {
            "partition_key": {"S": "ticket1"},
            "TicketNumber": {"S": "ticket_001"},
            "TicketModTime": {"S": "2022-10-07T14:32:25"},
            "CreatorEmail": {"S": "zorro@gmail.com"},
            "AssigneeEmail": {"S": "able@gmail.com"},
            "Severity": {"S": "3"},
            "Subject": {"S": "Bad bug"},
            "Message": {"S": "This bug looks pretty bad"},
        },
        {
            "partition_key": {"S": "ticket2"},
            "TicketNumber": {"S": "ticket_001"},
            "TicketModTime": {"S": "2022-10-07T14:32:25"},
            "CreatorEmail": {"S": "able@gmail.com"},
            "AssigneeEmail": {"S": "charlie@gmail.com"},
            "Severity": {"S": "3"},
            "Subject": {"S": "Bad bug"},
            "Message": {"S": "Charlie should handle this"},
        },
        {
            "partition_key": {"S": "ticket3"},
            "TicketNumber": {"S": "ticket_002"},
            "TicketModTime": {"S": "2022-10-06T14:32:25"},
            "CreatorEmail": {"S": "zorro@gmail.com"},
            "AssigneeEmail": {"S": "charlie@gmail.com"},
            "Severity": {"S": "3"},
            "Subject": {"S": "Easy Bug"},
            "Message": {"S": "This seems simple enough"},
        },
        {
            "partition_key": {"S": "ticket4"},
            "TicketNumber": {"S": "ticket_002"},
            "TicketModTime": {"S": "2022-10-08T14:32:25"},
            "CreatorEmail": {"S": "charlie@gmail.com"},
            "AssigneeEmail": {"S": "able@gmail.com"},
            "Severity": {"S": "3"},
            "Subject": {"S": "Easy Bug"},
            "Message": {"S": "that's in able's code"},
        },
    ]

    for ticket in tickets:
        ddb.put_item(TableName=ddb_table_name, Item=ticket)


def put_all_timecard_items_to_table(ddb_table_name, ddb):
    """Put all timecard items into the table."""
    timecards = [
        {
            "partition_key": {"S": "timecard1"},
            "ProjectName": {"S": "project_002"},
            "TimeCardStart": {"S": "2022-09-12"},
            "EmployeeEmail": {"S": "able@gmail.com"},
            "Hours": {"S": "40"},
            "Role": {"S": "SDE3"},
        },
        {
            "partition_key": {"S": "timecard2"},
            "ProjectName": {"S": "project_002"},
            "TimeCardStart": {"S": "2022-09-12"},
            "EmployeeEmail": {"S": "barney@gmail.com"},
            "Hours": {"S": "20"},
            "Role": {"S": "PM"},
        },
        {
            "partition_key": {"S": "timecard3"},
            "ProjectName": {"S": "project_003"},
            "TimeCardStart": {"S": "2022-09-12"},
            "EmployeeEmail": {"S": "charlie@gmail.com"},
            "Hours": {"S": "40"},
            "Role": {"S": "SDE3"},
        },
        {
            "partition_key": {"S": "timecard4"},
            "ProjectName": {"S": "project_003"},
            "TimeCardStart": {"S": "2022-09-12"},
            "EmployeeEmail": {"S": "barney@gmail.com"},
            "Hours": {"S": "20"},
            "Role": {"S": "PM"},
        },
    ]

    for timecard in timecards:
        ddb.put_item(TableName=ddb_table_name, Item=timecard)


def put_all_items_to_table(ddb_table_name, ddb):
    """Put all items into the table."""
    put_all_meeting_items_to_table(ddb_table_name, ddb)
    put_all_employee_items_to_table(ddb_table_name, ddb)
    put_all_project_items_to_table(ddb_table_name, ddb)
    put_all_reservation_items_to_table(ddb_table_name, ddb)
    put_all_ticket_items_to_table(ddb_table_name, ddb)
    put_all_timecard_items_to_table(ddb_table_name, ddb)
