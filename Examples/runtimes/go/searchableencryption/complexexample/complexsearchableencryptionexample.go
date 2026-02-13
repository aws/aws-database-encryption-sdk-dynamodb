// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package complexexample

import (
	"context"
	"fmt"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
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
 */
func ComplexSearchableEncryptionExample(
	ddbTableName,
	branchKeyId,
	branchKeyWrappingKmsKeyArn,
	branchKeyDdbTableName string,
) {
	ddb, err := SetupBeaconConfig(
		context.TODO(),
		ddbTableName,
		branchKeyId,
		branchKeyWrappingKmsKeyArn,
		branchKeyDdbTableName,
	)
	utils.HandleError(err)
	PutAllItemsToTable(context.TODO(), ddbTableName, ddb)
	RunQueries(context.TODO(), ddbTableName, ddb)

	fmt.Println("Complex Searchable Encryption Example Completed")
}
