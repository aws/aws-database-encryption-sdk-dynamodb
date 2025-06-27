// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package main

import (
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/clientsupplier"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/itemencryptor"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/keyring"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/misc"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
)

func main() {
	clientsupplier.ClientSupplierExample(utils.DdbTableName(), utils.TestMrkReplicaKeyIdUsEast1(), utils.DefaultKMSKeyAccountID(), []string{"eu-west-1"})
	keyring.AwsKmsKeyringExample(utils.KmsKeyID(), utils.DdbTableName())
	keyring.RawAesExample(utils.DdbTableName(), utils.KeyNamespace(), utils.KeyName(), utils.GenerateAes256KeyBytes())
	itemencryptor.ItemEncryptDecryptExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.GetEncryptedDataKeyDescriptionExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.MultiPutGetExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.CreateBranchKeyIDExample(utils.TestKeystoreName(), utils.TestLogicalKeystoreName(), utils.TestKeystoreKmsKeyId())
}
