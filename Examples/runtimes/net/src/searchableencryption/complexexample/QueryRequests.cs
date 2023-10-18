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
 * This class implements query access patterns from our workshop.
 * The queries in this file are more complicated than in other searchable encryption examples,
 *   and should demonstrate how one can structure queries on beacons in a broader variety of applications.
 */

public class QueryRequests
{
    public static async Task RunQueries(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        await RunQuery1(ddbTableName, ddb);
        await RunQuery2(ddbTableName, ddb);
        await RunQuery3(ddbTableName, ddb);
        await RunQuery4(ddbTableName, ddb);
        await RunQuery5(ddbTableName, ddb);
        await RunQuery6(ddbTableName, ddb);
        await RunQuery7(ddbTableName, ddb);
        await RunQuery8(ddbTableName, ddb);
        await RunQuery9(ddbTableName, ddb);
        await RunQuery10(ddbTableName, ddb);
        await RunQuery11(ddbTableName, ddb);
        await RunQuery12(ddbTableName, ddb);
        await RunQuery13(ddbTableName, ddb);
        await RunQuery14(ddbTableName, ddb);
        await RunQuery15(ddbTableName, ddb);
        await RunQuery16(ddbTableName, ddb);
        await RunQuery17(ddbTableName, ddb);
        await RunQuery18(ddbTableName, ddb);
        await RunQuery19(ddbTableName, ddb);
        await RunQuery20(ddbTableName, ddb);
        await RunQuery21(ddbTableName, ddb);
        await RunQuery22(ddbTableName, ddb);
        await RunQuery23(ddbTableName, ddb);
    }

    static bool DoesContain(List<AttributeValue> list, String val)
    {
        foreach (var item in list)
        {
            if (item.S.Equals(val)) return true;
        }
        return false;
    }
    static async Task RunQuery1(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 1: Get meetings by date and email
        // Key condition: PK1=email SK1 between(date1, date2)
        // Filter condition: duration > 0
        var query1AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#sk1"] = "SK1",
            ["#duration"] = "Duration"
        };

        var query1AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":e"] = new AttributeValue("EE-able@gmail.com"),
            [":date1"] = new AttributeValue("MS-2022-07-02"),
            [":date2"] = new AttributeValue("MS-2022-07-08"),
            [":zero"] = new AttributeValue("0")
        };

        var query1Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :e AND #sk1 BETWEEN :date1 AND :date2",
            FilterExpression = "#duration > :zero",
            ExpressionAttributeNames = query1AttributeNames,
            ExpressionAttributeValues = query1AttributeValues
        };

        var query1Response = await ddb.QueryAsync(query1Request);
        // Validate query was returned successfully
        Debug.Assert(query1Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `meeting1`
        Debug.Assert(query1Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery1 = false;
        foreach (var item in query1Response.Items)
        {
            if (item["partition_key"].S.Equals("meeting1"))
            {
                foundKnownValueItemQuery1 = true;
                Debug.Assert(item["Subject"].S.Equals("Scan Beacons"));
                Debug.Assert(item["Location"].M["Floor"].S.Equals("12"));
                Debug.Assert(DoesContain(item["Attendees"].L, "zorro@gmail.com"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery1);
    }

    static async Task RunQuery2(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 2: Get meetings by date and employeeID
        // Key condition: PK=employeeID SK between(date1, date2)
        // Filter condition: duration > 0
        var query2AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK",
            ["#sk"] = "SK",
            ["#duration"] = "Duration"
        };

        var query2AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":employee"] = new AttributeValue("E-emp_001"),
            [":date1"] = new AttributeValue("MS-2022-07-02"),
            [":date2"] = new AttributeValue("MS-2022-07-08"),
            [":zero"] = new AttributeValue("0")
        };

        var query2Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :employee AND #sk BETWEEN :date1 AND :date2",
            FilterExpression = "#duration > :zero",
            ExpressionAttributeNames = query2AttributeNames,
            ExpressionAttributeValues = query2AttributeValues
        };

        QueryResponse query2Response = await ddb.QueryAsync(query2Request);
        // Validate query was returned successfully
        Debug.Assert(query2Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `meeting1`
        Debug.Assert(query2Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery2 = false;
        foreach (var item in query2Response.Items)
        {
            if (item["partition_key"].S.Equals("meeting1"))
            {
                foundKnownValueItemQuery2 = true;
                Debug.Assert(item["Subject"].S.Equals("Scan Beacons"));
                Debug.Assert(item["Location"].M["Floor"].S.Equals("12"));
                Debug.Assert(DoesContain(item["Attendees"].L, "zorro@gmail.com"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery2);
    }

    static async Task RunQuery3(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 3: Get meetings by date and building/floor/room
        // Key condition: PK=employeeID SK between(date1, date2)
        // Filter condition: SK contains building.floor.room (see NOTE)
        // NOTE: This query is modified from Demo.md.
        //       Demo.md calls for a filter condition "SK contains building.floor.room"
        //       However, one cannot use primary keys (partition nor sort) in a filter expression.
        //       Instead, this query filters on the individual beacon attributes: building, floor, and room.
        var query3AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK",
            ["#sk"] = "SK",
            ["#building"] = "Building",
            ["#floor"] = "Floor",
            ["#room"] = "Room"
        };

        var query3AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":buildingbeacon"] = new AttributeValue("B-SEA33"),
            [":building"] = new AttributeValue("SEA33"),
            [":floor"] = new AttributeValue("12"),
            [":room"] = new AttributeValue("403"),
            [":date1"] = new AttributeValue("MS-2022-07-02"),
            [":date2"] = new AttributeValue("MS-2022-07-08")
        };

        var query3Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :buildingbeacon AND #sk BETWEEN :date1 AND :date2",
            FilterExpression = "#building = :building AND #floor = :floor AND #room = :room",
            ExpressionAttributeNames = query3AttributeNames,
            ExpressionAttributeValues = query3AttributeValues
        };

        QueryResponse query3Response = await ddb.QueryAsync(query3Request);
        // Validate query was returned successfully
        Debug.Assert(query3Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `reservation1`
        Debug.Assert(query3Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery3 = false;
        foreach (var item in query3Response.Items)
        {
            if (item["partition_key"].S.Equals("reservation1"))
            {
                foundKnownValueItemQuery3 = true;
                Debug.Assert(item["Subject"].S.Equals("Scan beacons"));
                Debug.Assert(item["Location"].M["Building"].S.Equals("SEA33"));
                Debug.Assert(DoesContain(item["Attendees"].L, "barney@gmail.com"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery3);
    }

    static async Task RunQuery4(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 4: Get employee data by email
        // Key condition: PK1=email SK1=employee ID
        var query4AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#sk1"] = "SK1"
        };

        var query4AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":email"] = new AttributeValue("EE-able@gmail.com"),
            [":employee"] = new AttributeValue("E-emp_001")
        };

        var query4Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :email AND #sk1 = :employee",
            ExpressionAttributeNames = query4AttributeNames,
            ExpressionAttributeValues = query4AttributeValues
        };

        QueryResponse query4Response = await ddb.QueryAsync(query4Request);
        // Validate query was returned successfully
        Debug.Assert(query4Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `employee1`
        Debug.Assert(query4Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery4 = false;
        foreach (var item in query4Response.Items)
        {
            if (item["partition_key"].S.Equals("employee1"))
            {
                foundKnownValueItemQuery4 = true;
                Debug.Assert(item["EmployeeID"].S.Equals("emp_001"));
                Debug.Assert(item["Location"].M["Desk"].S.Equals("3"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery4);
    }

    static async Task RunQuery5(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 5: Get meetings by email
        // Key condition: PK1=email SK1 > 30 days ago
        var query5AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#sk1"] = "SK1"
        };

        var query5AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":email"] = new AttributeValue("EE-able@gmail.com"),
            [":thirtydaysago"] = new AttributeValue("MS-2023-03-20"),
            [":prefix"] = new AttributeValue("MS-")
        };

        var query5Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :email AND #sk1 BETWEEN :prefix AND :thirtydaysago",
            ExpressionAttributeNames = query5AttributeNames,
            ExpressionAttributeValues = query5AttributeValues
        };

        QueryResponse query5Response = await ddb.QueryAsync(query5Request);
        // Validate query was returned successfully
        Debug.Assert(query5Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `meeting1`
        Debug.Assert(query5Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery5 = false;
        foreach (var item in query5Response.Items)
        {
            if (item["partition_key"].S.Equals("meeting1"))
            {
                foundKnownValueItemQuery5 = true;
                Debug.Assert(item["Subject"].S.Equals("Scan Beacons"));
                Debug.Assert(item["Location"].M["Floor"].S.Equals("12"));
                Debug.Assert(DoesContain(item["Attendees"].L, "zorro@gmail.com"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery5);
    }

    static async Task RunQuery6(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 6: Get tickets by email
        // Key condition: PK1=email SK1 > 30 days ago
        var query6AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#sk1"] = "SK1"
        };

        var query6AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":creatoremail"] = new AttributeValue("CE-zorro@gmail.com"),
            [":thirtydaysago"] = new AttributeValue("MS-2023-03-20")
        };

        var query6Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :creatoremail AND #sk1 < :thirtydaysago",
            ExpressionAttributeNames = query6AttributeNames,
            ExpressionAttributeValues = query6AttributeValues
        };

        QueryResponse query6Response = await ddb.QueryAsync(query6Request);
        // Validate query was returned successfully
        Debug.Assert(query6Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 2 items returned:
        // Expected to be `ticket1` and `ticket3`
        Debug.Assert(query6Response.Items.Count == 2);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery6 = false;
        foreach (var item in query6Response.Items)
        {
            if (item["partition_key"].S.Equals("ticket1"))
            {
                foundKnownValueItemQuery6 = true;
                Debug.Assert(item["TicketNumber"].S.Equals("ticket_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery6);
    }

    static async Task RunQuery7(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 7: Get reservations by email
        // Key condition: PK1=organizeremail SK1 > 30 days ago
        var query7AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#sk1"] = "SK1"
        };

        var query7AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":organizeremail"] = new AttributeValue("OE-able@gmail.com"),
            [":thirtydaysago"] = new AttributeValue("MS-2023-03-20")
        };

        var query7Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :organizeremail AND #sk1 < :thirtydaysago",
            ExpressionAttributeNames = query7AttributeNames,
            ExpressionAttributeValues = query7AttributeValues
        };

        QueryResponse query7Response = await ddb.QueryAsync(query7Request);
        // Validate query was returned successfully
        Debug.Assert(query7Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `reservation1`
        Debug.Assert(query7Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery7 = false;
        foreach (var item in query7Response.Items)
        {
            if (item["partition_key"].S.Equals("reservation1"))
            {
                foundKnownValueItemQuery7 = true;
                Debug.Assert(item["Subject"].S.Equals("Scan beacons"));
                Debug.Assert(item["Location"].M["Floor"].S.Equals("12"));
                Debug.Assert(DoesContain(item["Attendees"].L, "barney@gmail.com"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery7);
    }

    static async Task RunQuery8(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 8: Get time cards by email
        // Key condition: PK1=employeeemail SK1 > 30 days ago
        var query8AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#sk1"] = "SK1"
        };

        var query8AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":email"] = new AttributeValue("EE-able@gmail.com"),
            [":prefix"] = new AttributeValue("TC-"),
            [":thirtydaysago"] = new AttributeValue("TC-2023-03-20")
        };

        var query8Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :email AND #sk1 BETWEEN :prefix AND :thirtydaysago",
            ExpressionAttributeNames = query8AttributeNames,
            ExpressionAttributeValues = query8AttributeValues
        };

        QueryResponse query8Response = await ddb.QueryAsync(query8Request);
        // Validate query was returned successfully
        Debug.Assert(query8Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `timecard1`
        Debug.Assert(query8Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery8 = false;
        foreach (var item in query8Response.Items)
        {
            if (item["partition_key"].S.Equals("timecard1"))
            {
                foundKnownValueItemQuery8 = true;
                Debug.Assert(item["ProjectName"].S.Equals("project_002"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery8);
    }

    static async Task RunQuery9(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 9: Get employee info by employee ID
        // Key condition: PK1=employeeID SK starts with "E-"
        var query9AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK",
            ["#sk"] = "SK"
        };

        var query9AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":employee"] = new AttributeValue("E-emp_001"),
            [":prefix"] = new AttributeValue("E-")
        };

        var query9Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :employee AND begins_with(#sk, :prefix)",
            ExpressionAttributeNames = query9AttributeNames,
            ExpressionAttributeValues = query9AttributeValues
        };

        QueryResponse query9Response = await ddb.QueryAsync(query9Request);
        // Validate query was returned successfully
        Debug.Assert(query9Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `employee1`
        Debug.Assert(query9Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery9 = false;
        foreach (var item in query9Response.Items)
        {
            if (item["partition_key"].S.Equals("employee1"))
            {
                foundKnownValueItemQuery9 = true;
                Debug.Assert(item["EmployeeID"].S.Equals("emp_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery9);
    }

    static async Task RunQuery10(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 10: Get employee info by email
        // Key condition: PK1=email
        // Filter condition: SK starts with "E-"
        var query10AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#sk1"] = "SK1"
        };

        var query10AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":email"] = new AttributeValue("EE-able@gmail.com"),
            [":prefix"] = new AttributeValue("E-")
        };

        var query10Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :email AND begins_with(#sk1, :prefix)",
            ExpressionAttributeNames = query10AttributeNames,
            ExpressionAttributeValues = query10AttributeValues
        };

        QueryResponse query10Response = await ddb.QueryAsync(query10Request);
        // Validate query was returned successfully
        Debug.Assert(query10Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `employee1`
        Debug.Assert(query10Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery10 = false;
        foreach (var item in query10Response.Items)
        {
            if (item["partition_key"].S.Equals("employee1"))
            {
                foundKnownValueItemQuery10 = true;
                Debug.Assert(item["EmployeeID"].S.Equals("emp_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery10);
    }

    static async Task RunQuery11(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 11: Get ticket history by ticket number
        // Key condition: PK=TicketNumber
        var query11AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK"
        };

        var query11AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":ticket"] = new AttributeValue("T-ticket_001")
        };

        var query11Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :ticket",
            ExpressionAttributeNames = query11AttributeNames,
            ExpressionAttributeValues = query11AttributeValues
        };

        QueryResponse query11Response = await ddb.QueryAsync(query11Request);
        // Validate query was returned successfully
        Debug.Assert(query11Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 2 items returned:
        // Expected to be `ticket1` and `ticket2`
        Debug.Assert(query11Response.Items.Count == 2);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery11 = false;
        foreach (var item in query11Response.Items)
        {
            if (item["partition_key"].S.Equals("ticket1"))
            {
                foundKnownValueItemQuery11 = true;
                Debug.Assert(item["TicketNumber"].S.Equals("ticket_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery11);
    }

    static async Task RunQuery12(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 12: Get Ticket History by employee email
        // Key condition: PK1=CreatorEmail
        // Filter condition: PK=TicketNumber
        var query12AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#pk"] = "PK"
        };

        var query12AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":email"] = new AttributeValue("CE-zorro@gmail.com"),
            [":ticket"] = new AttributeValue("T-ticket_001")
        };

        var query12Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :email",
            FilterExpression = "#pk = :ticket",
            ExpressionAttributeNames = query12AttributeNames,
            ExpressionAttributeValues = query12AttributeValues
        };

        QueryResponse query12Response = await ddb.QueryAsync(query12Request);
        // Validate query was returned successfully
        Debug.Assert(query12Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `ticket1`
        Debug.Assert(query12Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery12 = false;
        foreach (var item in query12Response.Items)
        {
            if (item["partition_key"].S.Equals("ticket1"))
            {
                foundKnownValueItemQuery12 = true;
                Debug.Assert(item["TicketNumber"].S.Equals("ticket_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery12);
    }

    static async Task RunQuery13(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 13: Get ticket history by assignee email
        // Key condition: PK=AssigneeEmail
        // Filter condition: PK=ticketNumber
        var query13AttributeNames = new Dictionary<String, String>
        {
            ["#pk2"] = "PK2",
            ["#pk"] = "PK"
        };

        var query13AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":assigneeemail"] = new AttributeValue("AE-able@gmail.com"),
            [":ticket"] = new AttributeValue("T-ticket_001")
        };

        var query13Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-2",
            KeyConditionExpression = "#pk2 = :assigneeemail",
            FilterExpression = "#pk = :ticket",
            ExpressionAttributeNames = query13AttributeNames,
            ExpressionAttributeValues = query13AttributeValues
        };

        QueryResponse query13Response = await ddb.QueryAsync(query13Request);
        // Validate query was returned successfully
        Debug.Assert(query13Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `ticket1`
        Debug.Assert(query13Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery13 = false;
        foreach (var item in query13Response.Items)
        {
            if (item["partition_key"].S.Equals("ticket1"))
            {
                foundKnownValueItemQuery13 = true;
                Debug.Assert(item["Subject"].S.Equals("Bad bug"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery13);
    }

    static async Task RunQuery14(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 14: Get employees by city.building.floor.desk
        // Key condition: PK3=city SK3 begins_with(building.floor.desk)
        var query14AttributeNames = new Dictionary<String, String>
        {
            ["#pk3"] = "PK3",
            ["#sk3"] = "SK3"
        };

        var query14AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":city"] = new AttributeValue("C-Seattle"),
            [":location"] = new AttributeValue("B-44~F-12~D-3")
        };

        var query14Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-3",
            KeyConditionExpression = "#pk3 = :city AND begins_with(#sk3, :location)",
            ExpressionAttributeNames = query14AttributeNames,
            ExpressionAttributeValues = query14AttributeValues
        };

        QueryResponse query14Response = await ddb.QueryAsync(query14Request);
        // Validate query was returned successfully
        Debug.Assert(query14Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `employee1`
        Debug.Assert(query14Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery14 = false;
        foreach (var item in query14Response.Items)
        {
            if (item["partition_key"].S.Equals("employee1"))
            {
                foundKnownValueItemQuery14 = true;
                Debug.Assert(item["EmployeeID"].S.Equals("emp_001"));
                Debug.Assert(item["Location"].M["Desk"].S.Equals("3"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery14);
    }

    static async Task RunQuery15(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 15: Get employees by manager email
        // Key condition: PK2 = ManagerEmail
        var query15AttributeNames = new Dictionary<String, String>
        {
            ["#pk2"] = "PK2"
        };

        var query15AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":manageremail"] = new AttributeValue("ME-zorro@gmail.com")
        };

        var query15Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-2",
            KeyConditionExpression = "#pk2 = :manageremail",
            ExpressionAttributeNames = query15AttributeNames,
            ExpressionAttributeValues = query15AttributeValues
        };

        QueryResponse query15Response = await ddb.QueryAsync(query15Request);
        // Validate query was returned successfully
        Debug.Assert(query15Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 4 items returned:
        // Expected to be `employee1`, `employee2`, `employee3`, and `employee4`
        Debug.Assert(query15Response.Items.Count == 4);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery15 = false;
        foreach (var item in query15Response.Items)
        {
            if (item["partition_key"].S.Equals("employee1"))
            {
                foundKnownValueItemQuery15 = true;
                Debug.Assert(item["EmployeeID"].S.Equals("emp_001"));
                Debug.Assert(item["Location"].M["Desk"].S.Equals("3"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery15);
    }

    static async Task RunQuery16(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 16: Get assigned tickets by assignee email
        // Key condition: PK2 = AssigneeEmail
        var query16AttributeNames = new Dictionary<String, String>
        {
            ["#pk2"] = "PK2"
        };
        var query16AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":assigneeemail"] = new AttributeValue("AE-able@gmail.com")
        };
        var query16Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-2",
            KeyConditionExpression = "#pk2 = :assigneeemail",
            ExpressionAttributeNames = query16AttributeNames,
            ExpressionAttributeValues = query16AttributeValues
        };
        QueryResponse query16Response = await ddb.QueryAsync(query16Request);
        // Validate query was returned successfully
        Debug.Assert(query16Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 2 items returned:
        // Expected to be `ticket1` and `ticket4`
        Debug.Assert(query16Response.Items.Count == 2);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery16 = false;
        foreach (var item in query16Response.Items)
        {
            if (item["partition_key"].S.Equals("ticket1"))
            {
                foundKnownValueItemQuery16 = true;
                Debug.Assert(item["TicketNumber"].S.Equals("ticket_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery16);
    }

    static async Task RunQuery17(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 17: Get tickets updated within the last 24 hours
        // Key condition: PK3 = Severity, SK3 > 24 hours ago
        // (For the sake of this example, we will assume
        //  the date is 2022-10-08T09:30:00, such that "24 hours ago"
        //  is 2022-10-07T09:30:00, and that our sample ticket record
        //  with TicketModTime=2022-10-07T14:32:25 will be returned.)
        var query17AttributeNames = new Dictionary<String, String>
        {
            ["#pk3"] = "PK3",
            ["#sk3"] = "SK3"
        };

        var query17AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":severity"] = new AttributeValue("S-3"),
            [":yesterday"] = new AttributeValue("M-2022-10-07T09:30:00")
        };

        var query17Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-3",
            KeyConditionExpression = "#pk3 = :severity AND #sk3 > :yesterday",
            ExpressionAttributeNames = query17AttributeNames,
            ExpressionAttributeValues = query17AttributeValues
        };

        QueryResponse query17Response = await ddb.QueryAsync(query17Request);
        // Validate query was returned successfully
        Debug.Assert(query17Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 3 items returned:
        // Expected to be `ticket1`, `ticket2`, and `ticket4`
        Debug.Assert(query17Response.Items.Count == 3);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery17 = false;
        foreach (var item in query17Response.Items)
        {
            if (item["partition_key"].S.Equals("ticket1"))
            {
                foundKnownValueItemQuery17 = true;
                Debug.Assert(item["TicketNumber"].S.Equals("ticket_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery17);
    }

    static async Task RunQuery18(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 18: Get projects by status, start and target date
        // Key condition: PK1 = Status, SK1 > StartDate
        // Filter condition: TargetDelivery < TargetDate
        var query18AttributeNames = new Dictionary<String, String>
        {
            ["#pk1"] = "PK1",
            ["#sk1"] = "SK1",
            ["#target"] = "ProjectTarget"
        };
        var query18AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":status"] = new AttributeValue("PSts-Pending"),
            [":startdate"] = new AttributeValue("PS-2022-01-01"),
            [":target"] = new AttributeValue("2025-01-01")
        };
        var query18Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-1",
            KeyConditionExpression = "#pk1 = :status AND #sk1 > :startdate",
            FilterExpression = "#target < :target",
            ExpressionAttributeNames = query18AttributeNames,
            ExpressionAttributeValues = query18AttributeValues
        };
        QueryResponse query18Response = await ddb.QueryAsync(query18Request);
        // Validate query was returned successfully
        Debug.Assert(query18Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `project1`
        Debug.Assert(query18Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery18 = false;
        foreach (var item in query18Response.Items)
        {
            if (item["partition_key"].S.Equals("project1"))
            {
                foundKnownValueItemQuery18 = true;
                Debug.Assert(item["ProjectName"].S.Equals("project_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery18);
    }

    static async Task RunQuery19(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 19: Get projects by name
        // Key condition: PK = ProjectName, SK = ProjectName
        var query19AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK",
            ["#sk"] = "SK"
        };
        var query19AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":projectname"] = new AttributeValue("P-project_001")
        };
        var query19Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :projectname AND #sk = :projectname",
            ExpressionAttributeNames = query19AttributeNames,
            ExpressionAttributeValues = query19AttributeValues
        };
        QueryResponse query19Response = await ddb.QueryAsync(query19Request);
        // Validate query was returned successfully
        Debug.Assert(query19Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `project1`
        Debug.Assert(query19Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery19 = false;
        foreach (var item in query19Response.Items)
        {
            if (item["partition_key"].S.Equals("project1"))
            {
                foundKnownValueItemQuery19 = true;
                Debug.Assert(item["ProjectName"].S.Equals("project_001"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery19);
    }

    static async Task RunQuery20(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 20: Get Project History by date range (against timecard record)
        // Key condition: PK = ProjectName, SK between(date1, date2)
        var query20AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK",
            ["#sk"] = "SK"
        };

        var query20AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":projectname"] = new AttributeValue("P-project_002"),
            [":date1"] = new AttributeValue("TC-2022-01-01"),
            [":date2"] = new AttributeValue("TC-2023-01-01")
        };

        var query20Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :projectname AND #sk BETWEEN :date1 AND :date2",
            ExpressionAttributeNames = query20AttributeNames,
            ExpressionAttributeValues = query20AttributeValues
        };

        QueryResponse query20Response = await ddb.QueryAsync(query20Request);
        // Validate query was returned successfully
        Debug.Assert(query20Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 2 items returned:
        // Expected to be `timecard1` and `timecard2`
        Debug.Assert(query20Response.Items.Count == 2);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery20 = false;
        foreach (var item in query20Response.Items)
        {
            if (item["partition_key"].S.Equals("timecard1"))
            {
                foundKnownValueItemQuery20 = true;
                Debug.Assert(item["ProjectName"].S.Equals("project_002"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery20);
    }

    static async Task RunQuery21(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 21: Get Project History by role
        // Key condition: PK = ProjectName
        // Filter condition: role=rolename
        var query21AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK",
            ["#role"] = "Role"
        };

        var query21AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":projectname"] = new AttributeValue("P-project_002"),
            [":role"] = new AttributeValue("SDE3")
        };

        var query21Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :projectname",
            FilterExpression = "#role = :role",
            ExpressionAttributeNames = query21AttributeNames,
            ExpressionAttributeValues = query21AttributeValues
        };

        QueryResponse query21Response = await ddb.QueryAsync(query21Request);
        // Validate query was returned successfully
        Debug.Assert(query21Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 1 item was returned: `timecard1`
        Debug.Assert(query21Response.Items.Count == 1);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery21 = false;
        foreach (var item in query21Response.Items)
        {
            if (item["partition_key"].S.Equals("timecard1"))
            {
                foundKnownValueItemQuery21 = true;
                Debug.Assert(item["ProjectName"].S.Equals("project_002"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery21);
    }

    static async Task RunQuery22(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 22: Get reservations by building ID
        // Key condition: PK = Building ID
        var query22AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK"
        };

        var query22AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":building"] = new AttributeValue("B-SEA33")
        };

        var query22Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :building",
            ExpressionAttributeNames = query22AttributeNames,
            ExpressionAttributeValues = query22AttributeValues
        };

        QueryResponse query22Response = await ddb.QueryAsync(query22Request);
        // Validate query was returned successfully
        Debug.Assert(query22Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 2 items returned:
        // Expected to be `reservation1` and `reservation2`
        Debug.Assert(query22Response.Items.Count == 2);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery22 = false;
        foreach (var item in query22Response.Items)
        {
            if (item["partition_key"].S.Equals("reservation1"))
            {
                foundKnownValueItemQuery22 = true;
                Debug.Assert(item["Subject"].S.Equals("Scan beacons"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery22);
    }

    static async Task RunQuery23(String ddbTableName, AmazonDynamoDBClient ddb)
    {
        // Query 23: Get reservations by building ID and time range
        // Key condition: PK = Building ID, SK between(date1, date2)
        // Filter condition: Duration > 0
        var query23AttributeNames = new Dictionary<String, String>
        {
            ["#pk"] = "PK",
            ["#sk"] = "SK",
            ["#duration"] = "Duration"
        };

        var query23AttributeValues = new Dictionary<String, AttributeValue>
        {
            [":building"] = new AttributeValue("B-SEA33"),
            [":date1"] = new AttributeValue("MS-2022-07-01"),
            [":date2"] = new AttributeValue("MS-2022-07-08"),
            [":zero"] = new AttributeValue("0")
        };

        var query23Request = new QueryRequest
        {
            TableName = ddbTableName,
            IndexName = "GSI-0",
            KeyConditionExpression = "#pk = :building AND #sk BETWEEN :date1 AND :date2",
            FilterExpression = "#duration > :zero",
            ExpressionAttributeNames = query23AttributeNames,
            ExpressionAttributeValues = query23AttributeValues
        };

        QueryResponse query23Response = await ddb.QueryAsync(query23Request);
        // Validate query was returned successfully
        Debug.Assert(query23Response.HttpStatusCode == HttpStatusCode.OK);

        // Assert 2 items returned:
        // Expected to be `reservation1` and `reservation2`
        Debug.Assert(query23Response.Items.Count == 2);
        // Known value test: Assert some properties on one of the items
        bool foundKnownValueItemQuery23 = false;
        foreach (var item in query23Response.Items)
        {
            if (item["partition_key"].S.Equals("reservation1"))
            {
                foundKnownValueItemQuery23 = true;
                Debug.Assert(item["Subject"].S.Equals("Scan beacons"));
            }
        }

        Debug.Assert(foundKnownValueItemQuery23);
    }
}