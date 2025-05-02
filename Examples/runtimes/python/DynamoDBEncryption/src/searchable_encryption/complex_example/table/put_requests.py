# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Put all items into the table."""


def put_all_meeting_items_to_table(table):
    """Put all meeting items into the table."""
    meetings = [
        {
            "partition_key": "meeting1",
            "EmployeeID": "emp_001",
            "EmployeeEmail": "able@gmail.com",
            "MeetingStart": "2022-07-04T13:00",
            "Location": {"Floor": "12", "Room": "403"},
            "Duration": "30",
            "Attendees": ["able@gmail.com", "zorro@gmail.com"],
            "Subject": "Scan Beacons",
        },
        {
            "partition_key": "meeting2",
            "EmployeeID": "emp_002",
            "EmployeeEmail": "barney@gmail.com",
            "MeetingStart": "2022-07-04T13:00",
            "Location": {"Floor": "12", "Room": "403"},
            "Duration": "30",
            "Attendees": ["barney@gmail.com", "zorro@gmail.com"],
            "Subject": "Scan Beacons",
        },
        {
            "partition_key": "meeting3",
            "EmployeeID": "emp_003",
            "EmployeeEmail": "charlie@gmail.com",
            "MeetingStart": "2022-07-04T13:00",
            "Location": {"Floor": "12", "Room": "403"},
            "Duration": "30",
            "Attendees": ["charlie@gmail.com", "zorro@gmail.com"],
            "Subject": "Scan Beacons",
        },
        {
            "partition_key": "meeting4",
            "EmployeeID": "emp_004",
            "EmployeeEmail": "david@gmail.com",
            "MeetingStart": "2022-07-04T13:00",
            "Location": {"Floor": "12", "Room": "403"},
            "Duration": "30",
            "Attendees": ["david@gmail.com", "zorro@gmail.com"],
            "Subject": "Scan Beacons",
        },
        {
            "partition_key": "meeting5",
            "EmployeeID": "emp_002",
            "EmployeeEmail": "barney@gmail.com",
            "MeetingStart": "2022-07-04T14:00",
            "Location": {"Floor": "12", "Room": "407"},
            "Duration": "30",
            "Attendees": ["barney@gmail.com", "zorro@gmail.com"],
            "Subject": "DB ESDK",
        },
        {
            "partition_key": "meeting6",
            "EmployeeID": "emp_003",
            "EmployeeEmail": "charlie@gmail.com",
            "MeetingStart": "2022-07-04T14:00",
            "Location": {"Floor": "12", "Room": "407"},
            "Duration": "30",
            "Attendees": ["charlie@gmail.com", "zorro@gmail.com"],
            "Subject": "DB ESDK",
        },
    ]

    for meeting in meetings:
        table.put_item(Item=meeting)


def put_all_employee_items_to_table(table):
    """Put all employee items into the table."""
    employees = [
        {
            "partition_key": "employee1",
            "EmployeeID": "emp_001",
            "EmployeeEmail": "able@gmail.com",
            "ManagerEmail": "zorro@gmail.com",
            "EmployeeName": "Able Jones",
            "EmployeeTitle": "SDE9",
            "Location": {"Building": "44", "Floor": "12", "Desk": "3", "City": "Seattle"},
        },
        {
            "partition_key": "employee2",
            "EmployeeID": "emp_002",
            "EmployeeEmail": "barney@gmail.com",
            "ManagerEmail": "zorro@gmail.com",
            "EmployeeName": "Barney Jones",
            "EmployeeTitle": "SDE8",
            "Location": {"Building": "44", "Floor": "12", "Desk": "4", "City": "Seattle"},
        },
        {
            "partition_key": "employee3",
            "EmployeeID": "emp_003",
            "EmployeeEmail": "charlie@gmail.com",
            "ManagerEmail": "zorro@gmail.com",
            "EmployeeName": "Charlie Jones",
            "EmployeeTitle": "SDE7",
            "Location": {"Building": "44", "Floor": "4", "Desk": "5", "City": "Seattle"},
        },
        {
            "partition_key": "employee4",
            "EmployeeID": "emp_004",
            "EmployeeEmail": "david@gmail.com",
            "ManagerEmail": "zorro@gmail.com",
            "EmployeeName": "David Jones",
            "EmployeeTitle": "SDE6",
            "Location": {"Building": "22", "Floor": "1", "Desk": "3", "City": "NYC"},
        },
    ]

    for employee in employees:
        table.put_item(Item=employee)


def put_all_project_items_to_table(table):
    """Put all project items into the table."""
    projects = [
        {
            "partition_key": "project1",
            "ProjectName": "project_001",
            "ProjectStatus": "Pending",
            "ProjectStart": "2022-11-01",
            "Description": "Turbo Crypto",
            "ProjectTarget": "2024-01-01",
        },
        {
            "partition_key": "project2",
            "ProjectName": "project_002",
            "ProjectStatus": "Active",
            "ProjectStart": "2022-07-04",
            "Description": "Scan Beacons",
            "ProjectTarget": "2024-01-01",
        },
        {
            "partition_key": "project3",
            "ProjectName": "project_003",
            "ProjectStatus": "Active",
            "ProjectStart": "2022-08-05",
            "Description": "DB ESDK",
            "ProjectTarget": "2023-02-27",
        },
        {
            "partition_key": "project4",
            "ProjectName": "project_004",
            "ProjectStatus": "Done",
            "ProjectStart": "2020-03-03",
            "Description": "S3EC",
            "ProjectTarget": "2021-09-05",
        },
    ]

    for project in projects:
        table.put_item(Item=project)


def put_all_reservation_items_to_table(table):
    """Put all reservation items into the table."""
    reservations = [
        {
            "partition_key": "reservation1",
            "Location": {"Building": "SEA33", "Floor": "12", "Room": "403"},
            "MeetingStart": "2022-07-04T13:00",
            "OrganizerEmail": "able@gmail.com",
            "Duration": "30",
            "Attendees": ["able@gmail.com", "barney@gmail.com"],
            "Subject": "Scan beacons",
        },
        {
            "partition_key": "reservation2",
            "Location": {"Building": "SEA33", "Floor": "12", "Room": "407"},
            "MeetingStart": "2022-07-04T14:00",
            "OrganizerEmail": "barney@gmail.com",
            "Duration": "30",
            "Attendees": ["able@gmail.com", "barney@gmail.com"],
            "Subject": "DB ESDK",
        },
    ]

    for reservation in reservations:
        table.put_item(Item=reservation)


def put_all_ticket_items_to_table(table):
    """Put all ticket items into the table."""
    tickets = [
        {
            "partition_key": "ticket1",
            "TicketNumber": "ticket_001",
            "TicketModTime": "2022-10-07T14:32:25",
            "CreatorEmail": "zorro@gmail.com",
            "AssigneeEmail": "able@gmail.com",
            "Severity": "3",
            "Subject": "Bad bug",
            "Message": "This bug looks pretty bad",
        },
        {
            "partition_key": "ticket2",
            "TicketNumber": "ticket_001",
            "TicketModTime": "2022-10-07T14:32:25",
            "CreatorEmail": "able@gmail.com",
            "AssigneeEmail": "charlie@gmail.com",
            "Severity": "3",
            "Subject": "Bad bug",
            "Message": "Charlie should handle this",
        },
        {
            "partition_key": "ticket3",
            "TicketNumber": "ticket_002",
            "TicketModTime": "2022-10-06T14:32:25",
            "CreatorEmail": "zorro@gmail.com",
            "AssigneeEmail": "charlie@gmail.com",
            "Severity": "3",
            "Subject": "Easy Bug",
            "Message": "This seems simple enough",
        },
        {
            "partition_key": "ticket4",
            "TicketNumber": "ticket_002",
            "TicketModTime": "2022-10-08T14:32:25",
            "CreatorEmail": "charlie@gmail.com",
            "AssigneeEmail": "able@gmail.com",
            "Severity": "3",
            "Subject": "Easy Bug",
            "Message": "that's in able's code",
        },
    ]

    for ticket in tickets:
        table.put_item(Item=ticket)


def put_all_timecard_items_to_table(table):
    """Put all timecard items into the table."""
    timecards = [
        {
            "partition_key": "timecard1",
            "ProjectName": "project_002",
            "TimeCardStart": "2022-09-12",
            "EmployeeEmail": "able@gmail.com",
            "Hours": "40",
            "Role": "SDE3",
        },
        {
            "partition_key": "timecard2",
            "ProjectName": "project_002",
            "TimeCardStart": "2022-09-12",
            "EmployeeEmail": "barney@gmail.com",
            "Hours": "20",
            "Role": "PM",
        },
        {
            "partition_key": "timecard3",
            "ProjectName": "project_003",
            "TimeCardStart": "2022-09-12",
            "EmployeeEmail": "charlie@gmail.com",
            "Hours": "40",
            "Role": "SDE3",
        },
        {
            "partition_key": "timecard4",
            "ProjectName": "project_003",
            "TimeCardStart": "2022-09-12",
            "EmployeeEmail": "barney@gmail.com",
            "Hours": "20",
            "Role": "PM",
        },
    ]

    for timecard in timecards:
        table.put_item(Item=timecard)


def put_all_items_to_table(table):
    """Put all items into the table."""
    put_all_meeting_items_to_table(table)
    put_all_employee_items_to_table(table)
    put_all_project_items_to_table(table)
    put_all_reservation_items_to_table(table)
    put_all_ticket_items_to_table(table)
    put_all_timecard_items_to_table(table)
