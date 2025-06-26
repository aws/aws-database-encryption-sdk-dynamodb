// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package main

import (
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/itemencryptor"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/keyring"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/misc"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
)

func main() {
	// misc examples
	misc.GetEncryptedDataKeyDescriptionExample(
		utils.KmsKeyID(),
		utils.DdbTableName())
	misc.MultiPutGetExample(
		utils.KmsKeyID(),
		utils.DdbTableName())
	branchKey1 := misc.CreateBranchKeyIDExample(
		utils.TestKeystoreName(),
		utils.TestLogicalKeystoreName(),
		utils.TestKeystoreKmsKeyId())
	branchKey2 := misc.CreateBranchKeyIDExample(
		utils.TestKeystoreName(),
		utils.TestLogicalKeystoreName(),
		utils.TestKeystoreKmsKeyId())

	// keyring examples
	keyring.AwsKmsKeyringExample(
		utils.KmsKeyID(),
		utils.DdbTableName())
	keyring.RawAesExample(
		utils.DdbTableName(),
		utils.KeyNamespace(),
		utils.KeyName(),
		utils.GenerateAes256KeyBytes())
	keyring.HierarchicalKeyringExample(
		utils.DdbTableName(),
		branchKey1,
		branchKey2,
		utils.TestKeystoreName(),
		utils.TestLogicalKeystoreName(),
		utils.TestKeystoreKmsKeyId())

	// item encryptor example
	itemencryptor.ItemEncryptDecryptExample(
		utils.KmsKeyID(),
		utils.DdbTableName())
}
