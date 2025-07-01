// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package complexexample

import (
	"context"
	"fmt"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
)

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
