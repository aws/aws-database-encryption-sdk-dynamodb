// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package complexexample

import (
	"context"

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
 * This file implements PutItem calls to populate a DDB table with items from our workshop.
 * By providing a DynamoDbClient that is configured to use searchable encryption,
 *   this file will encrypt the data client side and add beacon attributes to the items.
 * This only implements a single item of each of the 6 record types from Demo.md. Adding the remaining
 *   items would extend the test and example coverage.
 */

// PutAllItemsToTable puts all sample items to the specified DynamoDB table
func PutAllItemsToTable(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	if err := PutAllMeetingItemsToTable(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := PutAllEmployeeItemsToTable(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := PutAllProjectItemsToTable(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := PutAllReservationItemsToTable(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := PutAllTicketItemsToTable(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	if err := PutAllTimecardItemsToTable(ctx, ddbTableName, ddb); err != nil {
		return err
	}
	return nil
}

// Helper function to create string attribute value
func stringAttr(s string) types.AttributeValue {
	return &types.AttributeValueMemberS{Value: s}
}

// Helper function to create map attribute value
func mapAttr(m map[string]types.AttributeValue) types.AttributeValue {
	return &types.AttributeValueMemberM{Value: m}
}

// Helper function to create list attribute value
func listAttr(l []types.AttributeValue) types.AttributeValue {
	return &types.AttributeValueMemberL{Value: l}
}

// meeting.json
// PutAllMeetingItemsToTable puts all meeting items to the table
func PutAllMeetingItemsToTable(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	// Meeting 1
	meeting1AttendeeList := []types.AttributeValue{
		stringAttr("able@gmail.com"),
		stringAttr("zorro@gmail.com"),
	}

	meeting1Location := map[string]types.AttributeValue{
		"Floor": stringAttr("12"),
		"Room":  stringAttr("403"),
	}

	meeting1 := map[string]types.AttributeValue{
		"partition_key": stringAttr("meeting1"),
		"EmployeeID":    stringAttr("emp_001"),
		"EmployeeEmail": stringAttr("able@gmail.com"),
		"MeetingStart":  stringAttr("2022-07-04T13:00"),
		"Location":      mapAttr(meeting1Location),
		"Duration":      stringAttr("30"),
		"Attendees":     listAttr(meeting1AttendeeList),
		"Subject":       stringAttr("Scan Beacons"),
	}

	_, err := ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      meeting1,
	})
	if err != nil {
		return err
	}

	// Meeting 2
	meeting2AttendeeList := []types.AttributeValue{
		stringAttr("barney@gmail.com"),
		stringAttr("zorro@gmail.com"),
	}

	meeting2Location := map[string]types.AttributeValue{
		"Floor": stringAttr("12"),
		"Room":  stringAttr("403"),
	}

	meeting2 := map[string]types.AttributeValue{
		"partition_key": stringAttr("meeting2"),
		"EmployeeID":    stringAttr("emp_002"),
		"EmployeeEmail": stringAttr("barney@gmail.com"),
		"MeetingStart":  stringAttr("2022-07-04T13:00"),
		"Location":      mapAttr(meeting2Location),
		"Duration":      stringAttr("30"),
		"Attendees":     listAttr(meeting2AttendeeList),
		"Subject":       stringAttr("Scan Beacons"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      meeting2,
	})
	if err != nil {
		return err
	}

	// Meeting 3
	meeting3AttendeeList := []types.AttributeValue{
		stringAttr("charlie@gmail.com"),
		stringAttr("zorro@gmail.com"),
	}

	meeting3Location := map[string]types.AttributeValue{
		"Floor": stringAttr("12"),
		"Room":  stringAttr("403"),
	}

	meeting3 := map[string]types.AttributeValue{
		"partition_key": stringAttr("meeting3"),
		"EmployeeID":    stringAttr("emp_003"),
		"EmployeeEmail": stringAttr("charlie@gmail.com"),
		"MeetingStart":  stringAttr("2022-07-04T13:00"),
		"Location":      mapAttr(meeting3Location),
		"Duration":      stringAttr("30"),
		"Attendees":     listAttr(meeting3AttendeeList),
		"Subject":       stringAttr("Scan Beacons"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      meeting3,
	})
	if err != nil {
		return err
	}

	// Meeting 4
	meeting4AttendeeList := []types.AttributeValue{
		stringAttr("david@gmail.com"),
		stringAttr("zorro@gmail.com"),
	}

	meeting4Location := map[string]types.AttributeValue{
		"Floor": stringAttr("12"),
		"Room":  stringAttr("403"),
	}

	meeting4 := map[string]types.AttributeValue{
		"partition_key": stringAttr("meeting4"),
		"EmployeeID":    stringAttr("emp_004"),
		"EmployeeEmail": stringAttr("david@gmail.com"),
		"MeetingStart":  stringAttr("2022-07-04T13:00"),
		"Location":      mapAttr(meeting4Location),
		"Duration":      stringAttr("30"),
		"Attendees":     listAttr(meeting4AttendeeList),
		"Subject":       stringAttr("Scan Beacons"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      meeting4,
	})
	if err != nil {
		return err
	}

	// Meeting 5
	meeting5AttendeeList := []types.AttributeValue{
		stringAttr("barney@gmail.com"),
		stringAttr("zorro@gmail.com"),
	}

	meeting5Location := map[string]types.AttributeValue{
		"Floor": stringAttr("12"),
		"Room":  stringAttr("407"),
	}

	meeting5 := map[string]types.AttributeValue{
		"partition_key": stringAttr("meeting5"),
		"EmployeeID":    stringAttr("emp_002"),
		"EmployeeEmail": stringAttr("barney@gmail.com"),
		"MeetingStart":  stringAttr("2022-07-04T14:00"),
		"Location":      mapAttr(meeting5Location),
		"Duration":      stringAttr("30"),
		"Attendees":     listAttr(meeting5AttendeeList),
		"Subject":       stringAttr("DB ESDK"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      meeting5,
	})
	if err != nil {
		return err
	}

	// Meeting 6
	meeting6AttendeeList := []types.AttributeValue{
		stringAttr("charlie@gmail.com"),
		stringAttr("zorro@gmail.com"),
	}

	meeting6Location := map[string]types.AttributeValue{
		"Floor": stringAttr("12"),
		"Room":  stringAttr("407"),
	}

	meeting6 := map[string]types.AttributeValue{
		"partition_key": stringAttr("meeting6"),
		"EmployeeID":    stringAttr("emp_003"),
		"EmployeeEmail": stringAttr("charlie@gmail.com"),
		"MeetingStart":  stringAttr("2022-07-04T14:00"),
		"Location":      mapAttr(meeting6Location),
		"Duration":      stringAttr("30"),
		"Attendees":     listAttr(meeting6AttendeeList),
		"Subject":       stringAttr("DB ESDK"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      meeting6,
	})
	return err
}

// employee.json
// PutAllEmployeeItemsToTable puts all employee items to the table
func PutAllEmployeeItemsToTable(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	// Employee 1
	employee1Location := map[string]types.AttributeValue{
		"Building": stringAttr("44"),
		"Floor":    stringAttr("12"),
		"Desk":     stringAttr("3"),
		"City":     stringAttr("Seattle"),
	}

	employee1 := map[string]types.AttributeValue{
		"partition_key": stringAttr("employee1"),
		"EmployeeID":    stringAttr("emp_001"),
		"EmployeeEmail": stringAttr("able@gmail.com"),
		"ManagerEmail":  stringAttr("zorro@gmail.com"),
		"EmployeeName":  stringAttr("Able Jones"),
		"EmployeeTitle": stringAttr("SDE9"),
		"Location":      mapAttr(employee1Location),
	}

	_, err := ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      employee1,
	})
	if err != nil {
		return err
	}

	// Employee 2
	employee2Location := map[string]types.AttributeValue{
		"Building": stringAttr("44"),
		"Floor":    stringAttr("12"),
		"Desk":     stringAttr("4"),
		"City":     stringAttr("Seattle"),
	}

	employee2 := map[string]types.AttributeValue{
		"partition_key": stringAttr("employee2"),
		"EmployeeID":    stringAttr("emp_002"),
		"EmployeeEmail": stringAttr("barney@gmail.com"),
		"ManagerEmail":  stringAttr("zorro@gmail.com"),
		"EmployeeName":  stringAttr("Barney Jones"),
		"EmployeeTitle": stringAttr("SDE8"),
		"Location":      mapAttr(employee2Location),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      employee2,
	})
	if err != nil {
		return err
	}

	// Employee 3
	employee3Location := map[string]types.AttributeValue{
		"Building": stringAttr("44"),
		"Floor":    stringAttr("4"),
		"Desk":     stringAttr("5"),
		"City":     stringAttr("Seattle"),
	}

	employee3 := map[string]types.AttributeValue{
		"partition_key": stringAttr("employee3"),
		"EmployeeID":    stringAttr("emp_003"),
		"EmployeeEmail": stringAttr("charlie@gmail.com"),
		"ManagerEmail":  stringAttr("zorro@gmail.com"),
		"EmployeeName":  stringAttr("Charlie Jones"),
		"EmployeeTitle": stringAttr("SDE7"),
		"Location":      mapAttr(employee3Location),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      employee3,
	})
	if err != nil {
		return err
	}

	// Employee 4
	employee4Location := map[string]types.AttributeValue{
		"Building": stringAttr("22"),
		"Floor":    stringAttr("1"),
		"Desk":     stringAttr("3"),
		"City":     stringAttr("NYC"),
	}

	employee4 := map[string]types.AttributeValue{
		"partition_key": stringAttr("employee4"),
		"EmployeeID":    stringAttr("emp_004"),
		"EmployeeEmail": stringAttr("david@gmail.com"),
		"ManagerEmail":  stringAttr("zorro@gmail.com"),
		"EmployeeName":  stringAttr("David Jones"),
		"EmployeeTitle": stringAttr("SDE6"),
		"Location":      mapAttr(employee4Location),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      employee4,
	})
	return err
}

// project.json
// PutAllProjectItemsToTable puts all project items to the table
func PutAllProjectItemsToTable(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	// Project 1
	project1 := map[string]types.AttributeValue{
		"partition_key": stringAttr("project1"),
		"ProjectName":   stringAttr("project_001"),
		"ProjectStatus": stringAttr("Pending"),
		"ProjectStart":  stringAttr("2022-11-01"),
		"Description":   stringAttr("Turbo Crypto"),
		"ProjectTarget": stringAttr("2024-01-01"),
	}

	_, err := ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      project1,
	})
	if err != nil {
		return err
	}

	// Project 2
	project2 := map[string]types.AttributeValue{
		"partition_key": stringAttr("project2"),
		"ProjectName":   stringAttr("project_002"),
		"ProjectStatus": stringAttr("Active"),
		"ProjectStart":  stringAttr("2022-07-04"),
		"Description":   stringAttr("Scan Beacons"),
		"ProjectTarget": stringAttr("2024-01-01"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      project2,
	})
	if err != nil {
		return err
	}

	// Project 3
	project3 := map[string]types.AttributeValue{
		"partition_key": stringAttr("project3"),
		"ProjectName":   stringAttr("project_003"),
		"ProjectStatus": stringAttr("Active"),
		"ProjectStart":  stringAttr("2022-08-05"),
		"Description":   stringAttr("DB ESDK"),
		"ProjectTarget": stringAttr("2023-02-27"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      project3,
	})
	if err != nil {
		return err
	}

	// Project 4
	project4 := map[string]types.AttributeValue{
		"partition_key": stringAttr("project4"),
		"ProjectName":   stringAttr("project_004"),
		"ProjectStatus": stringAttr("Done"),
		"ProjectStart":  stringAttr("2020-03-03"),
		"Description":   stringAttr("S3EC"),
		"ProjectTarget": stringAttr("2021-09-05"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      project4,
	})
	return err
}

// reservation.json
// PutAllReservationItemsToTable puts all reservation items to the table
func PutAllReservationItemsToTable(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	// Reservation 1
	reservation1AttendeeList := []types.AttributeValue{
		stringAttr("able@gmail.com"),
		stringAttr("barney@gmail.com"),
	}

	reservation1Location := map[string]types.AttributeValue{
		"Building": stringAttr("SEA33"),
		"Floor":    stringAttr("12"),
		"Room":     stringAttr("403"),
	}

	reservation1 := map[string]types.AttributeValue{
		"partition_key":  stringAttr("reservation1"),
		"Location":       mapAttr(reservation1Location),
		"MeetingStart":   stringAttr("2022-07-04T13:00"),
		"OrganizerEmail": stringAttr("able@gmail.com"),
		"Duration":       stringAttr("30"),
		"Attendees":      listAttr(reservation1AttendeeList),
		"Subject":        stringAttr("Scan beacons"),
	}

	_, err := ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      reservation1,
	})
	if err != nil {
		return err
	}

	// Reservation 2
	reservation2AttendeeList := []types.AttributeValue{
		stringAttr("able@gmail.com"),
		stringAttr("barney@gmail.com"),
	}

	reservation2Location := map[string]types.AttributeValue{
		"Building": stringAttr("SEA33"),
		"Floor":    stringAttr("12"),
		"Room":     stringAttr("407"),
	}

	reservation2 := map[string]types.AttributeValue{
		"partition_key":  stringAttr("reservation2"),
		"Location":       mapAttr(reservation2Location),
		"MeetingStart":   stringAttr("2022-07-04T14:00"),
		"OrganizerEmail": stringAttr("barney@gmail.com"),
		"Duration":       stringAttr("30"),
		"Attendees":      listAttr(reservation2AttendeeList),
		"Subject":        stringAttr("DB ESDK"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      reservation2,
	})
	return err
}

// ticket.json
// PutAllTicketItemsToTable puts all ticket items to the table
func PutAllTicketItemsToTable(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	// Ticket 1
	ticket1 := map[string]types.AttributeValue{
		"partition_key": stringAttr("ticket1"),
		"TicketNumber":  stringAttr("ticket_001"),
		"TicketModTime": stringAttr("2022-10-07T14:32:25"),
		"CreatorEmail":  stringAttr("zorro@gmail.com"),
		"AssigneeEmail": stringAttr("able@gmail.com"),
		"Severity":      stringAttr("3"),
		"Subject":       stringAttr("Bad bug"),
		"Message":       stringAttr("This bug looks pretty bad"),
	}

	_, err := ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      ticket1,
	})
	if err != nil {
		return err
	}

	// Ticket 2
	ticket2 := map[string]types.AttributeValue{
		"partition_key": stringAttr("ticket2"),
		"TicketNumber":  stringAttr("ticket_001"),
		"TicketModTime": stringAttr("2022-10-07T14:32:25"),
		"CreatorEmail":  stringAttr("able@gmail.com"),
		"AssigneeEmail": stringAttr("charlie@gmail.com"),
		"Severity":      stringAttr("3"),
		"Subject":       stringAttr("Bad bug"),
		"Message":       stringAttr("Charlie should handle this"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      ticket2,
	})
	if err != nil {
		return err
	}

	// Ticket 3
	ticket3 := map[string]types.AttributeValue{
		"partition_key": stringAttr("ticket3"),
		"TicketNumber":  stringAttr("ticket_002"),
		"TicketModTime": stringAttr("2022-10-06T14:32:25"),
		"CreatorEmail":  stringAttr("zorro@gmail.com"),
		"AssigneeEmail": stringAttr("charlie@gmail.com"),
		"Severity":      stringAttr("3"),
		"Subject":       stringAttr("Easy Bug"),
		"Message":       stringAttr("This seems simple enough"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      ticket3,
	})
	if err != nil {
		return err
	}

	// Ticket 4
	ticket4 := map[string]types.AttributeValue{
		"partition_key": stringAttr("ticket4"),
		"TicketNumber":  stringAttr("ticket_002"),
		"TicketModTime": stringAttr("2022-10-08T14:32:25"),
		"CreatorEmail":  stringAttr("charlie@gmail.com"),
		"AssigneeEmail": stringAttr("able@gmail.com"),
		"Severity":      stringAttr("3"),
		"Subject":       stringAttr("Easy Bug"),
		"Message":       stringAttr("that's in able's code"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      ticket4,
	})
	return err
}

// timecard.json
// PutAllTimecardItemsToTable puts all timecard items to the table
func PutAllTimecardItemsToTable(ctx context.Context, ddbTableName string, ddb *dynamodb.Client) error {
	// Timecard 1
	timecard1 := map[string]types.AttributeValue{
		"partition_key": stringAttr("timecard1"),
		"ProjectName":   stringAttr("project_002"),
		"TimeCardStart": stringAttr("2022-09-12"),
		"EmployeeEmail": stringAttr("able@gmail.com"),
		"Hours":         stringAttr("40"),
		"Role":          stringAttr("SDE3"),
	}

	_, err := ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      timecard1,
	})
	if err != nil {
		return err
	}

	// Timecard 2
	timecard2 := map[string]types.AttributeValue{
		"partition_key": stringAttr("timecard2"),
		"ProjectName":   stringAttr("project_002"),
		"TimeCardStart": stringAttr("2022-09-12"),
		"EmployeeEmail": stringAttr("barney@gmail.com"),
		"Hours":         stringAttr("20"),
		"Role":          stringAttr("PM"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      timecard2,
	})
	if err != nil {
		return err
	}

	// Timecard 3
	timecard3 := map[string]types.AttributeValue{
		"partition_key": stringAttr("timecard3"),
		"ProjectName":   stringAttr("project_003"),
		"TimeCardStart": stringAttr("2022-09-12"),
		"EmployeeEmail": stringAttr("charlie@gmail.com"),
		"Hours":         stringAttr("40"),
		"Role":          stringAttr("SDE3"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      timecard3,
	})
	if err != nil {
		return err
	}

	// Timecard 4
	timecard4 := map[string]types.AttributeValue{
		"partition_key": stringAttr("timecard4"),
		"ProjectName":   stringAttr("project_003"),
		"TimeCardStart": stringAttr("2022-09-12"),
		"EmployeeEmail": stringAttr("barney@gmail.com"),
		"Hours":         stringAttr("20"),
		"Role":          stringAttr("PM"),
	}

	_, err = ddb.PutItem(ctx, &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      timecard4,
	})
	return err
}
