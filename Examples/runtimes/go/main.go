// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package main

import (
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/itemencryptor"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/keyring"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/misc"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
)

func main() {
	keyring.AwsKmsKeyringExample(utils.KmsKeyID(), utils.DdbTableName())
	keyring.RawAesExample(utils.DdbTableName(), utils.KeyNamespace(), utils.KeyName(), utils.GenerateAes256KeyBytes())
	itemencryptor.ItemEncryptDecryptExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.GetEncryptedDataKeyDescriptionExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.MultiPutGetExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.CreateBranchKeyIDExample(utils.TestKeystoreName(), utils.TestLogicalKeystoreName(), utils.TestKeystoreKmsKeyId())
}
