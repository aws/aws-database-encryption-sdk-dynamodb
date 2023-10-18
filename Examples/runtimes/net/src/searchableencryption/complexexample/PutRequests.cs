using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;

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

public class PutRequests
{
    public static async Task PutAllItemsToTable(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        await PutAllMeetingItemsToTable(ddbTableName, ddb);
        await PutAllEmployeeItemsToTable(ddbTableName, ddb);
        await PutAllProjectItemsToTable(ddbTableName, ddb);
        await PutAllReservationItemsToTable(ddbTableName, ddb);
        await PutAllTicketItemsToTable(ddbTableName, ddb);
        await PutAllTimecardItemsToTable(ddbTableName, ddb);
    }

    // emeeting.json
    static async Task PutAllMeetingItemsToTable(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        var meeting1AttendeeList = new List<AttributeValue>
        {
            new AttributeValue("able@gmail.com"),
            new AttributeValue("zorro@gmail.com")
        };

        var meeting1Location = new Dictionary<String, AttributeValue>
        {
            ["Floor"] = new AttributeValue("12"),
            ["Room"] = new AttributeValue("403")
        };

        var meeting1 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("meeting1"),
            ["EmployeeID"] = new AttributeValue("emp_001"),
            ["EmployeeEmail"] = new AttributeValue("able@gmail.com"),
            ["MeetingStart"] = new AttributeValue("2022-07-04T13:00"),
            ["Location"] = new AttributeValue { M = meeting1Location },
            ["Duration"] = new AttributeValue("30"),
            ["Attendees"] = new AttributeValue { L = meeting1AttendeeList },
            ["Subject"] = new AttributeValue("Scan Beacons")
        };
        var response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = meeting1
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var meeting2AttendeeList = new List<AttributeValue>
        {
            new AttributeValue("barney@gmail.com"),
            new AttributeValue("zorro@gmail.com")
        };
        var meeting2Location = new Dictionary<String, AttributeValue>
        {
            ["Floor"] = new AttributeValue("12"),
            ["Room"] = new AttributeValue("403")
        };
        var meeting2 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("meeting2"),
            ["EmployeeID"] = new AttributeValue("emp_002"),
            ["EmployeeEmail"] = new AttributeValue("barney@gmail.com"),
            ["MeetingStart"] = new AttributeValue("2022-07-04T13:00"),
            ["Location"] = new AttributeValue { M = meeting2Location },
            ["Duration"] = new AttributeValue("30"),
            ["Attendees"] = new AttributeValue { L = meeting2AttendeeList },
            ["Subject"] = new AttributeValue("Scan Beacons")
        };

        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = meeting2
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var meeting3AttendeeList = new List<AttributeValue>
        {
            new AttributeValue("charlie@gmail.com"),
            new AttributeValue("zorro@gmail.com")
        };
        var meeting3Location = new Dictionary<String, AttributeValue>
        {
            ["Floor"] = new AttributeValue("12"),
            ["Room"] = new AttributeValue("403")
        };

        var meeting3 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("meeting3"),
            ["EmployeeID"] = new AttributeValue("emp_003"),
            ["EmployeeEmail"] = new AttributeValue("charlie@gmail.com"),
            ["MeetingStart"] = new AttributeValue("2022-07-04T13:00"),
            ["Location"] = new AttributeValue { M = meeting3Location },
            ["Duration"] = new AttributeValue("30"),
            ["Attendees"] = new AttributeValue { L = meeting3AttendeeList },
            ["Subject"] = new AttributeValue("Scan Beacons")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = meeting3
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var meeting4AttendeeList = new List<AttributeValue>
        {
            new AttributeValue("david@gmail.com"),
            new AttributeValue("zorro@gmail.com")
        };

        var meeting4Location = new Dictionary<String, AttributeValue>
        {
            ["Floor"] = new AttributeValue("12"),
            ["Room"] = new AttributeValue("403")
        };
        var meeting4 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("meeting4"),
            ["EmployeeID"] = new AttributeValue("emp_004"),
            ["EmployeeEmail"] = new AttributeValue("david@gmail.com"),
            ["MeetingStart"] = new AttributeValue("2022-07-04T13:00"),
            ["Location"] = new AttributeValue { M = meeting4Location },
            ["Duration"] = new AttributeValue("30"),
            ["Attendees"] = new AttributeValue { L = meeting4AttendeeList },
            ["Subject"] = new AttributeValue("Scan Beacons")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = meeting4
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var meeting5AttendeeList = new List<AttributeValue>
        {
            new AttributeValue("barney@gmail.com"),
            new AttributeValue("zorro@gmail.com")
        };
        var meeting5Location = new Dictionary<String, AttributeValue>
        {
            ["Floor"] = new AttributeValue("12"),
            ["Room"] = new AttributeValue("407")
        };
        var meeting5 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("meeting5"),
            ["EmployeeID"] = new AttributeValue("emp_002"),
            ["EmployeeEmail"] = new AttributeValue("barney@gmail.com"),
            ["MeetingStart"] = new AttributeValue("2022-07-04T14:00"),
            ["Location"] = new AttributeValue { M = meeting5Location },
            ["Duration"] = new AttributeValue("30"),
            ["Attendees"] = new AttributeValue { L = meeting5AttendeeList },
            ["Subject"] = new AttributeValue("DB ESDK")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = meeting5
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var meeting6AttendeeList = new List<AttributeValue>
        {
            new AttributeValue("charlie@gmail.com"),
            new AttributeValue("zorro@gmail.com")
        };
        var meeting6Location = new Dictionary<String, AttributeValue>
        {
            ["Floor"] = new AttributeValue("12"),
            ["Room"] = new AttributeValue("407")
        };
        var meeting6 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("meeting6"),
            ["EmployeeID"] = new AttributeValue("emp_003"),
            ["EmployeeEmail"] = new AttributeValue("charlie@gmail.com"),
            ["MeetingStart"] = new AttributeValue("2022-07-04T14:00"),
            ["Location"] = new AttributeValue { M = meeting6Location },
            ["Duration"] = new AttributeValue("30"),
            ["Attendees"] = new AttributeValue { L = meeting6AttendeeList },
            ["Subject"] = new AttributeValue("DB ESDK")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = meeting6
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);
    }

    // employee.json
    static async Task PutAllEmployeeItemsToTable(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        var employee1Location = new Dictionary<String, AttributeValue>
        {
            ["Building"] = new AttributeValue("44"),
            ["Floor"] = new AttributeValue("12"),
            ["Desk"] = new AttributeValue("3"),
            ["City"] = new AttributeValue("Seattle")
        };
        var employee1 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("employee1"),
            ["EmployeeID"] = new AttributeValue("emp_001"),
            ["EmployeeEmail"] = new AttributeValue("able@gmail.com"),
            ["ManagerEmail"] = new AttributeValue("zorro@gmail.com"),
            ["EmployeeName"] = new AttributeValue("Able Jones"),
            ["EmployeeTitle"] = new AttributeValue("SDE9"),
            ["Location"] = new AttributeValue { M = employee1Location }
        };

        var response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = employee1
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var employee2Location = new Dictionary<String, AttributeValue>
        {
            ["Building"] = new AttributeValue("44"),
            ["Floor"] = new AttributeValue("12"),
            ["Desk"] = new AttributeValue("4"),
            ["City"] = new AttributeValue("Seattle")
        };
        var employee2 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("employee2"),
            ["EmployeeID"] = new AttributeValue("emp_002"),
            ["EmployeeEmail"] = new AttributeValue("barney@gmail.com"),
            ["ManagerEmail"] = new AttributeValue("zorro@gmail.com"),
            ["EmployeeName"] = new AttributeValue("Barney Jones"),
            ["EmployeeTitle"] = new AttributeValue("SDE8"),
            ["Location"] = new AttributeValue { M = employee2Location }
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = employee2
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);
        var employee3Location = new Dictionary<String, AttributeValue>
        {
            ["Building"] = new AttributeValue("44"),
            ["Floor"] = new AttributeValue("4"),
            ["Desk"] = new AttributeValue("5"),
            ["City"] = new AttributeValue("Seattle")
        };
        var employee3 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("employee3"),
            ["EmployeeID"] = new AttributeValue("emp_003"),
            ["EmployeeEmail"] = new AttributeValue("charlie@gmail.com"),
            ["ManagerEmail"] = new AttributeValue("zorro@gmail.com"),
            ["EmployeeName"] = new AttributeValue("Charlie Jones"),
            ["EmployeeTitle"] = new AttributeValue("SDE7"),
            ["Location"] = new AttributeValue { M = employee3Location }
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = employee3
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);
        var employee4Location = new Dictionary<String, AttributeValue>
        {
            ["Building"] = new AttributeValue("22"),
            ["Floor"] = new AttributeValue("1"),
            ["Desk"] = new AttributeValue("3"),
            ["City"] = new AttributeValue("NYC")
        };
        var employee4 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("employee4"),
            ["EmployeeID"] = new AttributeValue("emp_004"),
            ["EmployeeEmail"] = new AttributeValue("david@gmail.com"),
            ["ManagerEmail"] = new AttributeValue("zorro@gmail.com"),
            ["EmployeeName"] = new AttributeValue("David Jones"),
            ["EmployeeTitle"] = new AttributeValue("SDE6"),
            ["Location"] = new AttributeValue { M = employee4Location }
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = employee4
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);
    }

    // project.json
    static async Task PutAllProjectItemsToTable(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        var project1 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("project1"),
            ["ProjectName"] = new AttributeValue("project_001"),
            ["ProjectStatus"] = new AttributeValue("Pending"),
            ["ProjectStart"] = new AttributeValue("2022-11-01"),
            ["Description"] = new AttributeValue("Turbo Crypto"),
            ["ProjectTarget"] = new AttributeValue("2024-01-01")
        };

        var response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = project1
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var project2 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("project2"),
            ["ProjectName"] = new AttributeValue("project_002"),
            ["ProjectStatus"] = new AttributeValue("Active"),
            ["ProjectStart"] = new AttributeValue("2022-07-04"),
            ["Description"] = new AttributeValue("Scan Beacons"),
            ["ProjectTarget"] = new AttributeValue("2024-01-01")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = project2
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var project3 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("project3"),
            ["ProjectName"] = new AttributeValue("project_003"),
            ["ProjectStatus"] = new AttributeValue("Active"),
            ["ProjectStart"] = new AttributeValue("2022-08-05"),
            ["Description"] = new AttributeValue("DB ESDK"),
            ["ProjectTarget"] = new AttributeValue("2023-02-27")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = project3
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var project4 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("project4"),
            ["ProjectName"] = new AttributeValue("project_004"),
            ["ProjectStatus"] = new AttributeValue("Done"),
            ["ProjectStart"] = new AttributeValue("2020-03-03"),
            ["Description"] = new AttributeValue("S3EC"),
            ["ProjectTarget"] = new AttributeValue("2021-09-05")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = project4
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);
    }

    // reservation.json
    static async Task PutAllReservationItemsToTable(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        var reservation1AttendeeList = new List<AttributeValue>
        {
            new AttributeValue("able@gmail.com"),
            new AttributeValue("barney@gmail.com")
        };
        var reservation1Location = new Dictionary<String, AttributeValue>
        {
            ["Building"] = new AttributeValue("SEA33"),
            ["Floor"] = new AttributeValue("12"),
            ["Room"] = new AttributeValue("403")
        };
        var reservation1 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("reservation1"),
            ["Location"] = new AttributeValue { M = reservation1Location },
            ["MeetingStart"] = new AttributeValue("2022-07-04T13:00"),
            ["OrganizerEmail"] = new AttributeValue("able@gmail.com"),
            ["Duration"] = new AttributeValue("30"),
            ["Attendees"] = new AttributeValue { L = reservation1AttendeeList },
            ["Subject"] = new AttributeValue("Scan beacons")
        };

        var response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = reservation1
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var reservation2AttendeeList = new List<AttributeValue>
        {
            new AttributeValue("able@gmail.com"),
            new AttributeValue("barney@gmail.com")
        };
        var reservation2Location = new Dictionary<String, AttributeValue>
        {
            ["Building"] = new AttributeValue("SEA33"),
            ["Floor"] = new AttributeValue("12"),
            ["Room"] = new AttributeValue("407")
        };
        var reservation2 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("reservation2"),
            ["Location"] = new AttributeValue { M = reservation2Location },
            ["MeetingStart"] = new AttributeValue("2022-07-04T14:00"),
            ["OrganizerEmail"] = new AttributeValue("barney@gmail.com"),
            ["Duration"] = new AttributeValue("30"),
            ["Attendees"] = new AttributeValue { L = reservation2AttendeeList },
            ["Subject"] = new AttributeValue("DB ESDK")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = reservation2
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);
    }

    // ticket.json
    static async Task PutAllTicketItemsToTable(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        var ticket1 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("ticket1"),
            ["TicketNumber"] = new AttributeValue("ticket_001"),
            ["TicketModTime"] = new AttributeValue("2022-10-07T14:32:25"),
            ["CreatorEmail"] = new AttributeValue("zorro@gmail.com"),
            ["AssigneeEmail"] = new AttributeValue("able@gmail.com"),
            ["Severity"] = new AttributeValue("3"),
            ["Subject"] = new AttributeValue("Bad bug"),
            ["Message"] = new AttributeValue("This bug looks pretty bad")
        };

        var response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = ticket1
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var ticket2 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("ticket2"),
            ["TicketNumber"] = new AttributeValue("ticket_001"),
            ["TicketModTime"] = new AttributeValue("2022-10-07T14:32:25"),
            ["CreatorEmail"] = new AttributeValue("able@gmail.com"),
            ["AssigneeEmail"] = new AttributeValue("charlie@gmail.com"),
            ["Severity"] = new AttributeValue("3"),
            ["Subject"] = new AttributeValue("Bad bug"),
            ["Message"] = new AttributeValue("Charlie should handle this")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = ticket2
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var ticket3 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("ticket3"),
            ["TicketNumber"] = new AttributeValue("ticket_002"),
            ["TicketModTime"] = new AttributeValue("2022-10-06T14:32:25"),
            ["CreatorEmail"] = new AttributeValue("zorro@gmail.com"),
            ["AssigneeEmail"] = new AttributeValue("charlie@gmail.com"),
            ["Severity"] = new AttributeValue("3"),
            ["Subject"] = new AttributeValue("Easy Bug"),
            ["Message"] = new AttributeValue("This seems simple enough")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = ticket3
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var ticket4 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("ticket4"),
            ["TicketNumber"] = new AttributeValue("ticket_002"),
            ["TicketModTime"] = new AttributeValue("2022-10-08T14:32:25"),
            ["CreatorEmail"] = new AttributeValue("charlie@gmail.com"),
            ["AssigneeEmail"] = new AttributeValue("able@gmail.com"),
            ["Severity"] = new AttributeValue("3"),
            ["Subject"] = new AttributeValue("Easy Bug"),
            ["Message"] = new AttributeValue("that's in able's code")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = ticket4
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);
    }

    // timecard.json
    static async Task PutAllTimecardItemsToTable(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        var timecard1 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("timecard1"),
            ["ProjectName"] = new AttributeValue("project_002"),
            ["TimeCardStart"] = new AttributeValue("2022-09-12"),
            ["EmployeeEmail"] = new AttributeValue("able@gmail.com"),
            ["Hours"] = new AttributeValue("40"),
            ["Role"] = new AttributeValue("SDE3")
        };

        var response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = timecard1
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var timecard2 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("timecard2"),
            ["ProjectName"] = new AttributeValue("project_002"),
            ["TimeCardStart"] = new AttributeValue("2022-09-12"),
            ["EmployeeEmail"] = new AttributeValue("barney@gmail.com"),
            ["Hours"] = new AttributeValue("20"),
            ["Role"] = new AttributeValue("PM")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = timecard2
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var timecard3 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("timecard3"),
            ["ProjectName"] = new AttributeValue("project_003"),
            ["TimeCardStart"] = new AttributeValue("2022-09-12"),
            ["EmployeeEmail"] = new AttributeValue("charlie@gmail.com"),
            ["Hours"] = new AttributeValue("40"),
            ["Role"] = new AttributeValue("SDE3")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = timecard3
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);

        var timecard4 = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("timecard4"),
            ["ProjectName"] = new AttributeValue("project_003"),
            ["TimeCardStart"] = new AttributeValue("2022-09-12"),
            ["EmployeeEmail"] = new AttributeValue("barney@gmail.com"),
            ["Hours"] = new AttributeValue("20"),
            ["Role"] = new AttributeValue("PM")
        };
        response = await ddb.PutItemAsync(new PutItemRequest
        {
            TableName = ddbTableName,
            Item = timecard4
        });
        Debug.Assert(response.HttpStatusCode == HttpStatusCode.OK);
    }
}