// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package utils

const (
	kmsKeyID     = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
	ddbTableName = "DynamoDbEncryptionInterceptorTestTableCS"
)

func KmsKeyID() string {
	return kmsKeyID
}

func DdbTableName() string {
	return ddbTableName
}

func AreMapsEqual(map1, map2 map[string]string) bool {
	if len(map1) != len(map2) {
		return false
	}

	for key, value1 := range map1 {
		value2, exists := map2[key]
		if !exists || value1 != value2 {
			return false
		}
	}
	return true
}
