// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package misc

import (
	"context"
	"fmt"

	dbesdkdynamodbencryption "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygenerated"
	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

func GetEncryptedDataKeyDescriptionExample(kmsKeyID, ddbTableName string) {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	ddbec, err := dbesdkdynamodbencryption.NewClient(dbesdkdynamodbencryptiontypes.DynamoDbEncryptionConfig{})
	utils.HandleError(err)
	// 1. Define keys that will be used to retrieve item from the DynamoDB table.
	keyToGet := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "BasicPutGetExample"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
	}

	// 2. Create a Amazon DynamoDB Client and retrieve item from DynamoDB table
	ddb := dynamodb.NewFromConfig(cfg)

	// 3. Extract the item from the dynamoDB table and prepare input for the GetEncryptedDataKeyDescription method.
	// Here, we are sending dynamodb item but you can also input the header itself by extracting the header from
	// "aws_dbe_head" attribute in the dynamoDB item. The part of the code where we send input as the header is commented.
	getInput := &dynamodb.GetItemInput{
		TableName: aws.String(ddbTableName),
		Key:       keyToGet,
		// In this example we configure a strongly consistent read
		// because we perform a read immediately after a write (for demonstrative purposes).
		// By default, reads are only eventually consistent.
		// Read our docs to determine which read consistency to use for your application:
		// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.ReadConsistency.html
		ConsistentRead: aws.Bool(true),
	}
	returnedItem, err := ddb.GetItem(context.TODO(), getInput)
	utils.HandleError(err)
	// inputUnion := dbesdkdynamodbencryptiontypes.GetEncryptedDataKeyDescriptionUnionMemberitem{
	// 	Value: returnedItem.Item,
	// }
	headerAttribute := "aws_dbe_head"
	headerBytes, ok := returnedItem.Item[headerAttribute].(*types.AttributeValueMemberB)
	if !ok {
		panic("attribute1 is not binary. It might not be encrypted.")
	}
	inputUnion := dbesdkdynamodbencryptiontypes.GetEncryptedDataKeyDescriptionUnionMemberheader{
		Value: headerBytes.Value,
	}
	encryptedDataKeyDescriptionInput := dbesdkdynamodbencryptiontypes.GetEncryptedDataKeyDescriptionInput{
		Input: &inputUnion,
	}
	encryptedDataKeyDescription, err := ddbec.GetEncryptedDataKeyDescription(context.TODO(), encryptedDataKeyDescriptionInput)
	utils.HandleError(err)

	if encryptedDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].KeyProviderId != "aws-kms" {
		panic("Key provider should have been aws-kms")
	}
	if *encryptedDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].KeyProviderInfo != kmsKeyID {
		panic("Key provider info should have been " + kmsKeyID)
	}
	fmt.Println("Get encrypted data Key description example successful.")
}
