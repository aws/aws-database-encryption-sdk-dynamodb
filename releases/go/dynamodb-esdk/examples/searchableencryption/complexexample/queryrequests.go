// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package complexexample

import (
	"context"
	"fmt"

	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

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

// RunQueries executes all 23 complex query examples
func RunQueries(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	if err := RunQuery1(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery2(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery3(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery4(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery5(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery6(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery7(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery8(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery9(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery10(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery11(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery12(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery13(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery14(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery15(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery16(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery17(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery18(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery19(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery20(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery21(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery22(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := RunQuery23(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	return nil
}

// Helper function to check if a list contains a specific string value
func listContainsString(list []types.AttributeValue, value string) bool {
	for _, item := range list {
		if s, ok := item.(*types.AttributeValueMemberS); ok && s.Value == value {
			return true
		}
	}
	return false
}

// RunQuery1 executes Query 1: Get meetings by date and email
// Key condition: PK1=email SK1 between(date1, date2)
// Filter condition: duration > 0
func RunQuery1(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query1AttributeNames := map[string]string{
		"#pk1":      "PK1",
		"#sk1":      "SK1",
		"#duration": "Duration",
	}

	query1AttributeValues := map[string]types.AttributeValue{
		":e":     stringAttr("EE-able@gmail.com"),
		":date1": stringAttr("MS-2022-07-02"),
		":date2": stringAttr("MS-2022-07-08"),
		":zero":  stringAttr("0"),
	}

	query1Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :e AND #sk1 BETWEEN :date1 AND :date2"),
		FilterExpression:          StringPtr("#duration > :zero"),
		ExpressionAttributeNames:  query1AttributeNames,
		ExpressionAttributeValues: query1AttributeValues,
	}

	query1Response, err := ddb.Query(ctx, query1Input)
	if err != nil {
		return fmt.Errorf("query1 failed: %w", err)
	}

	// Validate query was returned successfully
	if query1Response == nil {
		return fmt.Errorf("query1: no response")
	}

	// Assert 1 item was returned: `meeting1`
	if len(query1Response.Items) != 1 {
		return fmt.Errorf("query1: expected 1 item, got %d", len(query1Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery1 := false
	for _, item := range query1Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "meeting1" {
			foundKnownValueItemQuery1 = true

			if subject, ok := item["Subject"].(*types.AttributeValueMemberS); !ok || subject.Value != "Scan Beacons" {
				return fmt.Errorf("query1: expected Subject 'Scan Beacons'")
			}

			if location, ok := item["Location"].(*types.AttributeValueMemberM); ok {
				if floor, ok := location.Value["Floor"].(*types.AttributeValueMemberS); !ok || floor.Value != "12" {
					return fmt.Errorf("query1: expected Floor '12'")
				}
			} else {
				return fmt.Errorf("query1: expected Location map")
			}

			if attendees, ok := item["Attendees"].(*types.AttributeValueMemberL); ok {
				if !listContainsString(attendees.Value, "zorro@gmail.com") {
					return fmt.Errorf("query1: expected attendee 'zorro@gmail.com'")
				}
			} else {
				return fmt.Errorf("query1: expected Attendees list")
			}
		}
	}

	if !foundKnownValueItemQuery1 {
		return fmt.Errorf("query1: did not find expected item 'meeting1'")
	}

	return nil
}

// RunQuery2 executes Query 2: Get meetings by date and employeeID
// Key condition: PK=employeeID SK between(date1, date2)
// Filter condition: duration > 0
func RunQuery2(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query2AttributeNames := map[string]string{
		"#pk":       "PK",
		"#sk":       "SK",
		"#duration": "Duration",
	}

	query2AttributeValues := map[string]types.AttributeValue{
		":employee": stringAttr("E-emp_001"),
		":date1":    stringAttr("MS-2022-07-02"),
		":date2":    stringAttr("MS-2022-07-08"),
		":zero":     stringAttr("0"),
	}

	query2Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :employee AND #sk BETWEEN :date1 AND :date2"),
		FilterExpression:          StringPtr("#duration > :zero"),
		ExpressionAttributeNames:  query2AttributeNames,
		ExpressionAttributeValues: query2AttributeValues,
	}

	query2Response, err := ddb.Query(ctx, query2Input)
	if err != nil {
		return fmt.Errorf("query2 failed: %w", err)
	}

	// Assert 1 item was returned: `meeting1`
	if len(query2Response.Items) != 1 {
		return fmt.Errorf("query2: expected 1 item, got %d", len(query2Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery2 := false
	for _, item := range query2Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "meeting1" {
			foundKnownValueItemQuery2 = true

			if subject, ok := item["Subject"].(*types.AttributeValueMemberS); !ok || subject.Value != "Scan Beacons" {
				return fmt.Errorf("query2: expected Subject 'Scan Beacons'")
			}

			if location, ok := item["Location"].(*types.AttributeValueMemberM); ok {
				if floor, ok := location.Value["Floor"].(*types.AttributeValueMemberS); !ok || floor.Value != "12" {
					return fmt.Errorf("query2: expected Floor '12'")
				}
			} else {
				return fmt.Errorf("query2: expected Location map")
			}

			if attendees, ok := item["Attendees"].(*types.AttributeValueMemberL); ok {
				if !listContainsString(attendees.Value, "zorro@gmail.com") {
					return fmt.Errorf("query2: expected attendee 'zorro@gmail.com'")
				}
			} else {
				return fmt.Errorf("query2: expected Attendees list")
			}
		}
	}

	if !foundKnownValueItemQuery2 {
		return fmt.Errorf("query2: did not find expected item 'meeting1'")
	}

	return nil
}

// RunQuery3 executes Query 3: Get meetings by date and building/floor/room
// Key condition: PK=employeeID SK between(date1, date2)
// Filter condition: SK contains building.floor.room (see NOTE)
// NOTE: This query is modified from Demo.md.
//
//	Demo.md calls for a filter condition "SK contains building.floor.room"
//	However, one cannot use primary keys (partition nor sort) in a filter expression.
//	Instead, this query filters on the individual beacon attributes: building, floor, and room.
func RunQuery3(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query3AttributeNames := map[string]string{
		"#pk":       "PK",
		"#sk":       "SK",
		"#building": "Building",
		"#floor":    "Floor",
		"#room":     "Room",
	}

	query3AttributeValues := map[string]types.AttributeValue{
		":buildingbeacon": stringAttr("B-SEA33"),
		":building":       stringAttr("SEA33"),
		":floor":          stringAttr("12"),
		":room":           stringAttr("403"),
		":date1":          stringAttr("MS-2022-07-02"),
		":date2":          stringAttr("MS-2022-07-08"),
	}

	query3Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :buildingbeacon AND #sk BETWEEN :date1 AND :date2"),
		FilterExpression:          StringPtr("#building = :building AND #floor = :floor AND #room = :room"),
		ExpressionAttributeNames:  query3AttributeNames,
		ExpressionAttributeValues: query3AttributeValues,
	}

	query3Response, err := ddb.Query(ctx, query3Input)
	if err != nil {
		return fmt.Errorf("query3 failed: %w", err)
	}

	// Assert 1 item was returned: `reservation1`
	if len(query3Response.Items) != 1 {
		return fmt.Errorf("query3: expected 1 item, got %d", len(query3Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery3 := false
	for _, item := range query3Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "reservation1" {
			foundKnownValueItemQuery3 = true

			if subject, ok := item["Subject"].(*types.AttributeValueMemberS); !ok || subject.Value != "Scan beacons" {
				return fmt.Errorf("query3: expected Subject 'Scan beacons'")
			}

			if location, ok := item["Location"].(*types.AttributeValueMemberM); ok {
				if building, ok := location.Value["Building"].(*types.AttributeValueMemberS); !ok || building.Value != "SEA33" {
					return fmt.Errorf("query3: expected Building 'SEA33'")
				}
			} else {
				return fmt.Errorf("query3: expected Location map")
			}

			if attendees, ok := item["Attendees"].(*types.AttributeValueMemberL); ok {
				if !listContainsString(attendees.Value, "barney@gmail.com") {
					return fmt.Errorf("query3: expected attendee 'barney@gmail.com'")
				}
			} else {
				return fmt.Errorf("query3: expected Attendees list")
			}
		}
	}

	if !foundKnownValueItemQuery3 {
		return fmt.Errorf("query3: did not find expected item 'reservation1'")
	}

	return nil
}

// RunQuery4 executes Query 4: Get employee data by email
// Key condition: PK1=email SK1=employee ID
func RunQuery4(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query4AttributeNames := map[string]string{
		"#pk1": "PK1",
		"#sk1": "SK1",
	}

	query4AttributeValues := map[string]types.AttributeValue{
		":email":    stringAttr("EE-able@gmail.com"),
		":employee": stringAttr("E-emp_001"),
	}

	query4Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :email AND #sk1 = :employee"),
		ExpressionAttributeNames:  query4AttributeNames,
		ExpressionAttributeValues: query4AttributeValues,
	}

	query4Response, err := ddb.Query(ctx, query4Input)
	if err != nil {
		return fmt.Errorf("query4 failed: %w", err)
	}

	// Assert 1 item was returned: `employee1`
	if len(query4Response.Items) != 1 {
		return fmt.Errorf("query4: expected 1 item, got %d", len(query4Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery4 := false
	for _, item := range query4Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "employee1" {
			foundKnownValueItemQuery4 = true

			if employeeID, ok := item["EmployeeID"].(*types.AttributeValueMemberS); !ok || employeeID.Value != "emp_001" {
				return fmt.Errorf("query4: expected EmployeeID 'emp_001'")
			}

			if location, ok := item["Location"].(*types.AttributeValueMemberM); ok {
				if desk, ok := location.Value["Desk"].(*types.AttributeValueMemberS); !ok || desk.Value != "3" {
					return fmt.Errorf("query4: expected Desk '3'")
				}
			} else {
				return fmt.Errorf("query4: expected Location map")
			}
		}
	}

	if !foundKnownValueItemQuery4 {
		return fmt.Errorf("query4: did not find expected item 'employee1'")
	}

	return nil
}

// RunQuery5 executes Query 5: Get meetings by email
// Key condition: PK1=email SK1 > 30 days ago
func RunQuery5(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query5AttributeNames := map[string]string{
		"#pk1": "PK1",
		"#sk1": "SK1",
	}

	query5AttributeValues := map[string]types.AttributeValue{
		":email":         stringAttr("EE-able@gmail.com"),
		":thirtydaysago": stringAttr("MS-2023-03-20"),
		":prefix":        stringAttr("MS-"),
	}

	query5Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :email AND #sk1 BETWEEN :prefix AND :thirtydaysago"),
		ExpressionAttributeNames:  query5AttributeNames,
		ExpressionAttributeValues: query5AttributeValues,
	}

	query5Response, err := ddb.Query(ctx, query5Input)
	if err != nil {
		return fmt.Errorf("query5 failed: %w", err)
	}

	// Assert 1 item was returned: `meeting1`
	if len(query5Response.Items) != 1 {
		return fmt.Errorf("query5: expected 1 item, got %d", len(query5Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery5 := false
	for _, item := range query5Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "meeting1" {
			foundKnownValueItemQuery5 = true

			if subject, ok := item["Subject"].(*types.AttributeValueMemberS); !ok || subject.Value != "Scan Beacons" {
				return fmt.Errorf("query5: expected Subject 'Scan Beacons'")
			}

			if location, ok := item["Location"].(*types.AttributeValueMemberM); ok {
				if floor, ok := location.Value["Floor"].(*types.AttributeValueMemberS); !ok || floor.Value != "12" {
					return fmt.Errorf("query5: expected Floor '12'")
				}
			} else {
				return fmt.Errorf("query5: expected Location map")
			}

			if attendees, ok := item["Attendees"].(*types.AttributeValueMemberL); ok {
				if !listContainsString(attendees.Value, "zorro@gmail.com") {
					return fmt.Errorf("query5: expected attendee 'zorro@gmail.com'")
				}
			} else {
				return fmt.Errorf("query5: expected Attendees list")
			}
		}
	}

	if !foundKnownValueItemQuery5 {
		return fmt.Errorf("query5: did not find expected item 'meeting1'")
	}

	return nil
}

// RunQuery6 executes Query 6: Get tickets by email
// Key condition: PK1=email SK1 > 30 days ago
func RunQuery6(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query6AttributeNames := map[string]string{
		"#pk1": "PK1",
		"#sk1": "SK1",
	}

	query6AttributeValues := map[string]types.AttributeValue{
		":creatoremail":  stringAttr("CE-zorro@gmail.com"),
		":thirtydaysago": stringAttr("MS-2023-03-20"),
	}

	query6Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :creatoremail AND #sk1 < :thirtydaysago"),
		ExpressionAttributeNames:  query6AttributeNames,
		ExpressionAttributeValues: query6AttributeValues,
	}

	query6Response, err := ddb.Query(ctx, query6Input)
	if err != nil {
		return fmt.Errorf("query6 failed: %w", err)
	}

	// Assert 2 items returned: Expected to be `ticket1` and `ticket3`
	if len(query6Response.Items) != 2 {
		return fmt.Errorf("query6: expected 2 items, got %d", len(query6Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery6 := false
	for _, item := range query6Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "ticket1" {
			foundKnownValueItemQuery6 = true

			if ticketNumber, ok := item["TicketNumber"].(*types.AttributeValueMemberS); !ok || ticketNumber.Value != "ticket_001" {
				return fmt.Errorf("query6: expected TicketNumber 'ticket_001'")
			}
		}
	}

	if !foundKnownValueItemQuery6 {
		return fmt.Errorf("query6: did not find expected item 'ticket1'")
	}

	return nil
}

// RunQuery7 executes Query 7: Get reservations by email
// Key condition: PK1=organizeremail SK1 > 30 days ago
func RunQuery7(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query7AttributeNames := map[string]string{
		"#pk1": "PK1",
		"#sk1": "SK1",
	}

	query7AttributeValues := map[string]types.AttributeValue{
		":organizeremail": stringAttr("OE-able@gmail.com"),
		":thirtydaysago":  stringAttr("MS-2023-03-20"),
	}

	query7Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :organizeremail AND #sk1 < :thirtydaysago"),
		ExpressionAttributeNames:  query7AttributeNames,
		ExpressionAttributeValues: query7AttributeValues,
	}

	query7Response, err := ddb.Query(ctx, query7Input)
	if err != nil {
		return fmt.Errorf("query7 failed: %w", err)
	}

	// Assert 1 item was returned: `reservation1`
	if len(query7Response.Items) != 1 {
		return fmt.Errorf("query7: expected 1 item, got %d", len(query7Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery7 := false
	for _, item := range query7Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "reservation1" {
			foundKnownValueItemQuery7 = true

			if subject, ok := item["Subject"].(*types.AttributeValueMemberS); !ok || subject.Value != "Scan beacons" {
				return fmt.Errorf("query7: expected Subject 'Scan beacons'")
			}

			if location, ok := item["Location"].(*types.AttributeValueMemberM); ok {
				if floor, ok := location.Value["Floor"].(*types.AttributeValueMemberS); !ok || floor.Value != "12" {
					return fmt.Errorf("query7: expected Floor '12'")
				}
			} else {
				return fmt.Errorf("query7: expected Location map")
			}

			if attendees, ok := item["Attendees"].(*types.AttributeValueMemberL); ok {
				if !listContainsString(attendees.Value, "barney@gmail.com") {
					return fmt.Errorf("query7: expected attendee 'barney@gmail.com'")
				}
			} else {
				return fmt.Errorf("query7: expected Attendees list")
			}
		}
	}

	if !foundKnownValueItemQuery7 {
		return fmt.Errorf("query7: did not find expected item 'reservation1'")
	}

	return nil
}

// RunQuery8 executes Query 8: Get time cards by email
// Key condition: PK1=employeeemail SK1 > 30 days ago
func RunQuery8(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query8AttributeNames := map[string]string{
		"#pk1": "PK1",
		"#sk1": "SK1",
	}

	query8AttributeValues := map[string]types.AttributeValue{
		":email":         stringAttr("EE-able@gmail.com"),
		":prefix":        stringAttr("TC-"),
		":thirtydaysago": stringAttr("TC-2023-03-20"),
	}

	query8Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :email AND #sk1 BETWEEN :prefix AND :thirtydaysago"),
		ExpressionAttributeNames:  query8AttributeNames,
		ExpressionAttributeValues: query8AttributeValues,
	}

	query8Response, err := ddb.Query(ctx, query8Input)
	if err != nil {
		return fmt.Errorf("query8 failed: %w", err)
	}

	// Assert 1 item was returned: `timecard1`
	if len(query8Response.Items) != 1 {
		return fmt.Errorf("query8: expected 1 item, got %d", len(query8Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery8 := false
	for _, item := range query8Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "timecard1" {
			foundKnownValueItemQuery8 = true

			if projectName, ok := item["ProjectName"].(*types.AttributeValueMemberS); !ok || projectName.Value != "project_002" {
				return fmt.Errorf("query8: expected ProjectName 'project_002'")
			}
		}
	}

	if !foundKnownValueItemQuery8 {
		return fmt.Errorf("query8: did not find expected item 'timecard1'")
	}

	return nil
}

// RunQuery9 executes Query 9: Get employee info by employee ID
// Key condition: PK1=employeeID SK starts with "E-"
func RunQuery9(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query9AttributeNames := map[string]string{
		"#pk": "PK",
		"#sk": "SK",
	}

	query9AttributeValues := map[string]types.AttributeValue{
		":employee": stringAttr("E-emp_001"),
		":prefix":   stringAttr("E-"),
	}

	query9Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :employee AND begins_with(#sk, :prefix)"),
		ExpressionAttributeNames:  query9AttributeNames,
		ExpressionAttributeValues: query9AttributeValues,
	}

	query9Response, err := ddb.Query(ctx, query9Input)
	if err != nil {
		return fmt.Errorf("query9 failed: %w", err)
	}

	// Assert 1 item was returned: `employee1`
	if len(query9Response.Items) != 1 {
		return fmt.Errorf("query9: expected 1 item, got %d", len(query9Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery9 := false
	for _, item := range query9Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "employee1" {
			foundKnownValueItemQuery9 = true

			if employeeID, ok := item["EmployeeID"].(*types.AttributeValueMemberS); !ok || employeeID.Value != "emp_001" {
				return fmt.Errorf("query9: expected EmployeeID 'emp_001'")
			}
		}
	}

	if !foundKnownValueItemQuery9 {
		return fmt.Errorf("query9: did not find expected item 'employee1'")
	}

	return nil
}

// RunQuery10 executes Query 10: Get employee info by email
// Key condition: PK1=email
// Filter condition: SK starts with "E-"
func RunQuery10(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query10AttributeNames := map[string]string{
		"#pk1": "PK1",
		"#sk1": "SK1",
	}

	query10AttributeValues := map[string]types.AttributeValue{
		":email":  stringAttr("EE-able@gmail.com"),
		":prefix": stringAttr("E-"),
	}

	query10Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :email AND begins_with(#sk1, :prefix)"),
		ExpressionAttributeNames:  query10AttributeNames,
		ExpressionAttributeValues: query10AttributeValues,
	}

	query10Response, err := ddb.Query(ctx, query10Input)
	if err != nil {
		return fmt.Errorf("query10 failed: %w", err)
	}

	// Assert 1 item was returned: `employee1`
	if len(query10Response.Items) != 1 {
		return fmt.Errorf("query10: expected 1 item, got %d", len(query10Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery10 := false
	for _, item := range query10Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "employee1" {
			foundKnownValueItemQuery10 = true

			if employeeID, ok := item["EmployeeID"].(*types.AttributeValueMemberS); !ok || employeeID.Value != "emp_001" {
				return fmt.Errorf("query10: expected EmployeeID 'emp_001'")
			}
		}
	}

	if !foundKnownValueItemQuery10 {
		return fmt.Errorf("query10: did not find expected item 'employee1'")
	}

	return nil
}

// RunQuery11 executes Query 11: Get ticket history by ticket number
// Key condition: PK=TicketNumber
func RunQuery11(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query11AttributeNames := map[string]string{
		"#pk": "PK",
	}

	query11AttributeValues := map[string]types.AttributeValue{
		":ticket": stringAttr("T-ticket_001"),
	}

	query11Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :ticket"),
		ExpressionAttributeNames:  query11AttributeNames,
		ExpressionAttributeValues: query11AttributeValues,
	}

	query11Response, err := ddb.Query(ctx, query11Input)
	if err != nil {
		return fmt.Errorf("query11 failed: %w", err)
	}

	// Assert 2 items returned: Expected to be `ticket1` and `ticket2`
	if len(query11Response.Items) != 2 {
		return fmt.Errorf("query11: expected 2 items, got %d", len(query11Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery11 := false
	for _, item := range query11Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "ticket1" {
			foundKnownValueItemQuery11 = true

			if ticketNumber, ok := item["TicketNumber"].(*types.AttributeValueMemberS); !ok || ticketNumber.Value != "ticket_001" {
				return fmt.Errorf("query11: expected TicketNumber 'ticket_001'")
			}
		}
	}

	if !foundKnownValueItemQuery11 {
		return fmt.Errorf("query11: did not find expected item 'ticket1'")
	}

	return nil
}

// RunQuery12 executes Query 12: Get Ticket History by employee email
// Key condition: PK1=CreatorEmail
// Filter condition: PK=TicketNumber
func RunQuery12(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query12AttributeNames := map[string]string{
		"#pk1": "PK1",
		"#pk":  "PK",
	}

	query12AttributeValues := map[string]types.AttributeValue{
		":email":  stringAttr("CE-zorro@gmail.com"),
		":ticket": stringAttr("T-ticket_001"),
	}

	query12Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :email"),
		FilterExpression:          StringPtr("#pk = :ticket"),
		ExpressionAttributeNames:  query12AttributeNames,
		ExpressionAttributeValues: query12AttributeValues,
	}

	query12Response, err := ddb.Query(ctx, query12Input)
	if err != nil {
		return fmt.Errorf("query12 failed: %w", err)
	}

	// Assert 1 item was returned: `ticket1`
	if len(query12Response.Items) != 1 {
		return fmt.Errorf("query12: expected 1 item, got %d", len(query12Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery12 := false
	for _, item := range query12Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "ticket1" {
			foundKnownValueItemQuery12 = true

			if ticketNumber, ok := item["TicketNumber"].(*types.AttributeValueMemberS); !ok || ticketNumber.Value != "ticket_001" {
				return fmt.Errorf("query12: expected TicketNumber 'ticket_001'")
			}
		}
	}

	if !foundKnownValueItemQuery12 {
		return fmt.Errorf("query12: did not find expected item 'ticket1'")
	}

	return nil
}

// RunQuery13 executes Query 13: Get ticket history by assignee email
// Key condition: PK=AssigneeEmail
// Filter condition: PK=ticketNumber
func RunQuery13(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query13AttributeNames := map[string]string{
		"#pk2": "PK2",
		"#pk":  "PK",
	}

	query13AttributeValues := map[string]types.AttributeValue{
		":assigneeemail": stringAttr("AE-able@gmail.com"),
		":ticket":        stringAttr("T-ticket_001"),
	}

	query13Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-2"),
		KeyConditionExpression:    StringPtr("#pk2 = :assigneeemail"),
		FilterExpression:          StringPtr("#pk = :ticket"),
		ExpressionAttributeNames:  query13AttributeNames,
		ExpressionAttributeValues: query13AttributeValues,
	}

	query13Response, err := ddb.Query(ctx, query13Input)
	if err != nil {
		return fmt.Errorf("query13 failed: %w", err)
	}

	// Assert 1 item was returned: `ticket1`
	if len(query13Response.Items) != 1 {
		return fmt.Errorf("query13: expected 1 item, got %d", len(query13Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery13 := false
	for _, item := range query13Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "ticket1" {
			foundKnownValueItemQuery13 = true

			if subject, ok := item["Subject"].(*types.AttributeValueMemberS); !ok || subject.Value != "Bad bug" {
				return fmt.Errorf("query13: expected Subject 'Bad bug'")
			}
		}
	}

	if !foundKnownValueItemQuery13 {
		return fmt.Errorf("query13: did not find expected item 'ticket1'")
	}

	return nil
}

// RunQuery14 executes Query 14: Get employees by city.building.floor.desk
// Key condition: PK3=city SK3 begins_with(building.floor.desk)
func RunQuery14(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query14AttributeNames := map[string]string{
		"#pk3": "PK3",
		"#sk3": "SK3",
	}

	query14AttributeValues := map[string]types.AttributeValue{
		":city":     stringAttr("C-Seattle"),
		":location": stringAttr("B-44~F-12~D-3"),
	}

	query14Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-3"),
		KeyConditionExpression:    StringPtr("#pk3 = :city AND begins_with(#sk3, :location)"),
		ExpressionAttributeNames:  query14AttributeNames,
		ExpressionAttributeValues: query14AttributeValues,
	}

	// GSIs do not update instantly, so if the results come back empty
	// we retry after a short sleep
	for i := 0; i < 10; i++ {
		query14Response, err := ddb.Query(ctx, query14Input)
		if err != nil {
			return fmt.Errorf("query14 failed: %w", err)
		}

		// if no results, sleep and try again
		if len(query14Response.Items) == 0 {
			// Sleep for 20ms and continue
			continue
		}

		// Assert 1 item was returned: `employee1`
		if len(query14Response.Items) != 1 {
			return fmt.Errorf("query14: expected 1 item, got %d", len(query14Response.Items))
		}

		// Known value test: Assert some properties on one of the items
		foundKnownValueItemQuery14 := false
		for _, item := range query14Response.Items {
			if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "employee1" {
				foundKnownValueItemQuery14 = true

				if employeeID, ok := item["EmployeeID"].(*types.AttributeValueMemberS); !ok || employeeID.Value != "emp_001" {
					return fmt.Errorf("query14: expected EmployeeID 'emp_001'")
				}

				if location, ok := item["Location"].(*types.AttributeValueMemberM); ok {
					if desk, ok := location.Value["Desk"].(*types.AttributeValueMemberS); !ok || desk.Value != "3" {
						return fmt.Errorf("query14: expected Desk '3'")
					}
				} else {
					return fmt.Errorf("query14: expected Location map")
				}
			}
		}

		if !foundKnownValueItemQuery14 {
			return fmt.Errorf("query14: did not find expected item 'employee1'")
		}

		return nil
	}

	return fmt.Errorf("query14: failed after 10 retries")
}

// RunQuery15 executes Query 15: Get employees by manager email
// Key condition: PK2 = ManagerEmail
func RunQuery15(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query15AttributeNames := map[string]string{
		"#pk2": "PK2",
	}

	query15AttributeValues := map[string]types.AttributeValue{
		":manageremail": stringAttr("ME-zorro@gmail.com"),
	}

	query15Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-2"),
		KeyConditionExpression:    StringPtr("#pk2 = :manageremail"),
		ExpressionAttributeNames:  query15AttributeNames,
		ExpressionAttributeValues: query15AttributeValues,
	}

	query15Response, err := ddb.Query(ctx, query15Input)
	if err != nil {
		return fmt.Errorf("query15 failed: %w", err)
	}

	// Assert 4 items returned: Expected to be `employee1`, `employee2`, `employee3`, and `employee4`
	if len(query15Response.Items) != 4 {
		return fmt.Errorf("query15: expected 4 items, got %d", len(query15Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery15 := false
	for _, item := range query15Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "employee1" {
			foundKnownValueItemQuery15 = true

			if employeeID, ok := item["EmployeeID"].(*types.AttributeValueMemberS); !ok || employeeID.Value != "emp_001" {
				return fmt.Errorf("query15: expected EmployeeID 'emp_001'")
			}

			if location, ok := item["Location"].(*types.AttributeValueMemberM); ok {
				if desk, ok := location.Value["Desk"].(*types.AttributeValueMemberS); !ok || desk.Value != "3" {
					return fmt.Errorf("query15: expected Desk '3'")
				}
			} else {
				return fmt.Errorf("query15: expected Location map")
			}
		}
	}

	if !foundKnownValueItemQuery15 {
		return fmt.Errorf("query15: did not find expected item 'employee1'")
	}

	return nil
}

// RunQuery16 executes Query 16: Get assigned tickets by assignee email
// Key condition: PK2 = AssigneeEmail
func RunQuery16(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query16AttributeNames := map[string]string{
		"#pk2": "PK2",
	}

	query16AttributeValues := map[string]types.AttributeValue{
		":assigneeemail": stringAttr("AE-able@gmail.com"),
	}

	query16Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-2"),
		KeyConditionExpression:    StringPtr("#pk2 = :assigneeemail"),
		ExpressionAttributeNames:  query16AttributeNames,
		ExpressionAttributeValues: query16AttributeValues,
	}

	query16Response, err := ddb.Query(ctx, query16Input)
	if err != nil {
		return fmt.Errorf("query16 failed: %w", err)
	}

	// Assert 2 items returned: Expected to be `ticket1` and `ticket4`
	if len(query16Response.Items) != 2 {
		return fmt.Errorf("query16: expected 2 items, got %d", len(query16Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery16 := false
	for _, item := range query16Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "ticket1" {
			foundKnownValueItemQuery16 = true

			if ticketNumber, ok := item["TicketNumber"].(*types.AttributeValueMemberS); !ok || ticketNumber.Value != "ticket_001" {
				return fmt.Errorf("query16: expected TicketNumber 'ticket_001'")
			}
		}
	}

	if !foundKnownValueItemQuery16 {
		return fmt.Errorf("query16: did not find expected item 'ticket1'")
	}

	return nil
}

// RunQuery17 executes Query 17: Get tickets updated within the last 24 hours
// Key condition: PK3 = Severity, SK3 > 24 hours ago
// (For the sake of this example, we will assume
//
//	the date is 2022-10-08T09:30:00, such that "24 hours ago"
//	is 2022-10-07T09:30:00, and that our sample ticket record
//	with TicketModTime=2022-10-07T14:32:25 will be returned.)
func RunQuery17(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query17AttributeNames := map[string]string{
		"#pk3": "PK3",
		"#sk3": "SK3",
	}

	query17AttributeValues := map[string]types.AttributeValue{
		":severity":  stringAttr("S-3"),
		":yesterday": stringAttr("M-2022-10-07T09:30:00"),
	}

	query17Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-3"),
		KeyConditionExpression:    StringPtr("#pk3 = :severity AND #sk3 > :yesterday"),
		ExpressionAttributeNames:  query17AttributeNames,
		ExpressionAttributeValues: query17AttributeValues,
	}

	query17Response, err := ddb.Query(ctx, query17Input)
	if err != nil {
		return fmt.Errorf("query17 failed: %w", err)
	}

	// Assert 3 items returned: Expected to be `ticket1`, `ticket2`, and `ticket4`
	if len(query17Response.Items) != 3 {
		return fmt.Errorf("query17: expected 3 items, got %d", len(query17Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery17 := false
	for _, item := range query17Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "ticket1" {
			foundKnownValueItemQuery17 = true

			if ticketNumber, ok := item["TicketNumber"].(*types.AttributeValueMemberS); !ok || ticketNumber.Value != "ticket_001" {
				return fmt.Errorf("query17: expected TicketNumber 'ticket_001'")
			}
		}
	}

	if !foundKnownValueItemQuery17 {
		return fmt.Errorf("query17: did not find expected item 'ticket1'")
	}

	return nil
}

// RunQuery18 executes Query 18: Get projects by status, start and target date
// Key condition: PK1 = Status, SK1 > StartDate
// Filter condition: TargetDelivery < TargetDate
func RunQuery18(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query18AttributeNames := map[string]string{
		"#pk1":    "PK1",
		"#sk1":    "SK1",
		"#target": "ProjectTarget",
	}

	query18AttributeValues := map[string]types.AttributeValue{
		":status":    stringAttr("PSts-Pending"),
		":startdate": stringAttr("PS-2022-01-01"),
		":target":    stringAttr("2025-01-01"),
	}

	query18Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-1"),
		KeyConditionExpression:    StringPtr("#pk1 = :status AND #sk1 > :startdate"),
		FilterExpression:          StringPtr("#target < :target"),
		ExpressionAttributeNames:  query18AttributeNames,
		ExpressionAttributeValues: query18AttributeValues,
	}

	query18Response, err := ddb.Query(ctx, query18Input)
	if err != nil {
		return fmt.Errorf("query18 failed: %w", err)
	}

	// Assert 1 item was returned: `project1`
	if len(query18Response.Items) != 1 {
		return fmt.Errorf("query18: expected 1 item, got %d", len(query18Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery18 := false
	for _, item := range query18Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "project1" {
			foundKnownValueItemQuery18 = true

			if projectName, ok := item["ProjectName"].(*types.AttributeValueMemberS); !ok || projectName.Value != "project_001" {
				return fmt.Errorf("query18: expected ProjectName 'project_001'")
			}
		}
	}

	if !foundKnownValueItemQuery18 {
		return fmt.Errorf("query18: did not find expected item 'project1'")
	}

	return nil
}

// RunQuery19 executes Query 19: Get projects by name
// Key condition: PK = ProjectName, SK = ProjectName
func RunQuery19(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query19AttributeNames := map[string]string{
		"#pk": "PK",
		"#sk": "SK",
	}

	query19AttributeValues := map[string]types.AttributeValue{
		":projectname": stringAttr("P-project_001"),
	}

	query19Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :projectname AND #sk = :projectname"),
		ExpressionAttributeNames:  query19AttributeNames,
		ExpressionAttributeValues: query19AttributeValues,
	}

	query19Response, err := ddb.Query(ctx, query19Input)
	if err != nil {
		return fmt.Errorf("query19 failed: %w", err)
	}

	// Assert 1 item was returned: `project1`
	if len(query19Response.Items) != 1 {
		return fmt.Errorf("query19: expected 1 item, got %d", len(query19Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery19 := false
	for _, item := range query19Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "project1" {
			foundKnownValueItemQuery19 = true

			if projectName, ok := item["ProjectName"].(*types.AttributeValueMemberS); !ok || projectName.Value != "project_001" {
				return fmt.Errorf("query19: expected ProjectName 'project_001'")
			}
		}
	}

	if !foundKnownValueItemQuery19 {
		return fmt.Errorf("query19: did not find expected item 'project1'")
	}

	return nil
}

// RunQuery20 executes Query 20: Get Project History by date range (against timecard record)
// Key condition: PK = ProjectName, SK between(date1, date2)
func RunQuery20(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query20AttributeNames := map[string]string{
		"#pk": "PK",
		"#sk": "SK",
	}

	query20AttributeValues := map[string]types.AttributeValue{
		":projectname": stringAttr("P-project_002"),
		":date1":       stringAttr("TC-2022-01-01"),
		":date2":       stringAttr("TC-2023-01-01"),
	}

	query20Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :projectname AND #sk BETWEEN :date1 AND :date2"),
		ExpressionAttributeNames:  query20AttributeNames,
		ExpressionAttributeValues: query20AttributeValues,
	}

	query20Response, err := ddb.Query(ctx, query20Input)
	if err != nil {
		return fmt.Errorf("query20 failed: %w", err)
	}

	// Assert 2 items returned: Expected to be `timecard1` and `timecard2`
	if len(query20Response.Items) != 2 {
		return fmt.Errorf("query20: expected 2 items, got %d", len(query20Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery20 := false
	for _, item := range query20Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "timecard1" {
			foundKnownValueItemQuery20 = true

			if projectName, ok := item["ProjectName"].(*types.AttributeValueMemberS); !ok || projectName.Value != "project_002" {
				return fmt.Errorf("query20: expected ProjectName 'project_002'")
			}
		}
	}

	if !foundKnownValueItemQuery20 {
		return fmt.Errorf("query20: did not find expected item 'timecard1'")
	}

	return nil
}

// RunQuery21 executes Query 21: Get Project History by role
// Key condition: PK = ProjectName
// Filter condition: role=rolename
func RunQuery21(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query21AttributeNames := map[string]string{
		"#pk":   "PK",
		"#role": "Role",
	}

	query21AttributeValues := map[string]types.AttributeValue{
		":projectname": stringAttr("P-project_002"),
		":role":        stringAttr("SDE3"),
	}

	query21Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :projectname"),
		FilterExpression:          StringPtr("#role = :role"),
		ExpressionAttributeNames:  query21AttributeNames,
		ExpressionAttributeValues: query21AttributeValues,
	}

	query21Response, err := ddb.Query(ctx, query21Input)
	if err != nil {
		return fmt.Errorf("query21 failed: %w", err)
	}

	// Assert 1 item was returned: `timecard1`
	if len(query21Response.Items) != 1 {
		return fmt.Errorf("query21: expected 1 item, got %d", len(query21Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery21 := false
	for _, item := range query21Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "timecard1" {
			foundKnownValueItemQuery21 = true

			if projectName, ok := item["ProjectName"].(*types.AttributeValueMemberS); !ok || projectName.Value != "project_002" {
				return fmt.Errorf("query21: expected ProjectName 'project_002'")
			}
		}
	}

	if !foundKnownValueItemQuery21 {
		return fmt.Errorf("query21: did not find expected item 'timecard1'")
	}

	return nil
}

// RunQuery22 executes Query 22: Get reservations by building ID
// Key condition: PK = Building ID
func RunQuery22(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query22AttributeNames := map[string]string{
		"#pk": "PK",
	}

	query22AttributeValues := map[string]types.AttributeValue{
		":building": stringAttr("B-SEA33"),
	}

	query22Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :building"),
		ExpressionAttributeNames:  query22AttributeNames,
		ExpressionAttributeValues: query22AttributeValues,
	}

	query22Response, err := ddb.Query(ctx, query22Input)
	if err != nil {
		return fmt.Errorf("query22 failed: %w", err)
	}

	// Assert 2 items returned: Expected to be `reservation1` and `reservation2`
	if len(query22Response.Items) != 2 {
		return fmt.Errorf("query22: expected 2 items, got %d", len(query22Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery22 := false
	for _, item := range query22Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "reservation1" {
			foundKnownValueItemQuery22 = true

			if subject, ok := item["Subject"].(*types.AttributeValueMemberS); !ok || subject.Value != "Scan beacons" {
				return fmt.Errorf("query22: expected Subject 'Scan beacons'")
			}
		}
	}

	if !foundKnownValueItemQuery22 {
		return fmt.Errorf("query22: did not find expected item 'reservation1'")
	}

	return nil
}

// RunQuery23 executes Query 23: Get reservations by building ID and time range
// Key condition: PK = Building ID, SK between(date1, date2)
// Filter condition: Duration > 0
func RunQuery23(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	query23AttributeNames := map[string]string{
		"#pk":       "PK",
		"#sk":       "SK",
		"#duration": "Duration",
	}

	query23AttributeValues := map[string]types.AttributeValue{
		":building": stringAttr("B-SEA33"),
		":date1":    stringAttr("MS-2022-07-01"),
		":date2":    stringAttr("MS-2022-07-08"),
		":zero":     stringAttr("0"),
	}

	query23Input := &dynamodb.QueryInput{
		TableName:                 &ddbTableName,
		IndexName:                 StringPtr("GSI-0"),
		KeyConditionExpression:    StringPtr("#pk = :building AND #sk BETWEEN :date1 AND :date2"),
		FilterExpression:          StringPtr("#duration > :zero"),
		ExpressionAttributeNames:  query23AttributeNames,
		ExpressionAttributeValues: query23AttributeValues,
	}

	query23Response, err := ddb.Query(ctx, query23Input)
	if err != nil {
		return fmt.Errorf("query23 failed: %w", err)
	}

	// Assert 2 items returned: Expected to be `reservation1` and `reservation2`
	if len(query23Response.Items) != 2 {
		return fmt.Errorf("query23: expected 2 items, got %d", len(query23Response.Items))
	}

	// Known value test: Assert some properties on one of the items
	foundKnownValueItemQuery23 := false
	for _, item := range query23Response.Items {
		if partitionKey, ok := item["partition_key"].(*types.AttributeValueMemberS); ok && partitionKey.Value == "reservation1" {
			foundKnownValueItemQuery23 = true

			if subject, ok := item["Subject"].(*types.AttributeValueMemberS); !ok || subject.Value != "Scan beacons" {
				return fmt.Errorf("query23: expected Subject 'Scan beacons'")
			}
		}
	}

	if !foundKnownValueItemQuery23 {
		return fmt.Errorf("query23: did not find expected item 'reservation1'")
	}

	return nil
}

// Helper function to create string pointer
func StringPtr(s string) *string {
	return &s
}
