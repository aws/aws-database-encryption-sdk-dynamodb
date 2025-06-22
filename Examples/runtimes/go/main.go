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
	keyring.AwsKmsKeyringExample(utils.KmsKeyID(), utils.DdbTableName())
	keyring.RawAesExample(utils.DdbTableName(), utils.KeyNamespace(), utils.KeyName(), utils.GenerateAes256KeyBytes())
	itemencryptor.ItemEncryptDecryptExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.GetEncryptedDataKeyDescriptionExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.MultiPutGetExample(utils.KmsKeyID(), utils.DdbTableName())
	keyring.MrkDiscoveryMultiKeyringExample(utils.KmsKeyID(), utils.DdbTableName(), utils.DefaultKMSKeyAccountID(), utils.DefaultKmsKeyRegion())

	branchKey1 := misc.CreateBranchKeyIDExample(utils.TestKeystoreName(), utils.TestLogicalKeystoreName(), utils.TestKeystoreKmsKeyId())
	branchKey2 := misc.CreateBranchKeyIDExample(utils.TestKeystoreName(), utils.TestLogicalKeystoreName(), utils.TestKeystoreKmsKeyId())

	keyring.HierarchicalKeyringExample(utils.DdbTableName(), branchKey1, branchKey2, utils.TestKeystoreName(), utils.TestLogicalKeystoreName(), utils.TestKeystoreKmsKeyId())
	keyring.KmsEcdhKeyringExample(utils.DdbTableName(), utils.TestKmsEcdhKeyIdP256Sender(), utils.TestKmsEcdhKeyIdP256Recipient())
	keyring.KmsRsaKeyringExample(utils.DdbTableName(), utils.TestKmsRsaKeyID())
}
