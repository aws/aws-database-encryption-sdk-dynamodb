// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package main

import (
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/itemencryptor"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/keyring"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/misc"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/searchableencryption"
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
	keyring.KmsRsaKeyringExample(
		utils.DdbTableName(),
		utils.TestKmsRsaKeyID(),
		utils.DefaultRsaPublicKeyFilename())
	keyring.RawRsaKeyringExample(
		utils.DdbTableName(),
		utils.ExampleRsaPublicKeyFilename(),
		utils.ExampleRsaPrivateKeyFilename())
	keyring.MrkDiscoveryMultiKeyringExample(
		utils.KmsKeyID(),
		utils.DdbTableName(),
		utils.DefaultKMSKeyAccountID(),
		utils.DefaultKmsKeyRegion())

	// item encryptor example
	itemencryptor.ItemEncryptDecryptExample(
		utils.KmsKeyID(),
		utils.DdbTableName())

	// searchable encryption example
	searchableencryption.BasicSearchableEncryptionExample(
		utils.UnitInspectionTestDdbTableName(),
		branchKey1,
		utils.TestKeystoreKmsKeyId(),
		utils.TestKeystoreName())
	searchableencryption.BeaconStylesSearchableEncryptionExample(
		utils.UnitInspectionTestDdbTableName(),
		branchKey1,
		utils.TestKeystoreKmsKeyId(),
		utils.TestKeystoreName())
	searchableencryption.CompoundBeaconSearchableEncryptionExample(
		utils.UnitInspectionTestDdbTableName(),
		branchKey2,
		utils.TestKeystoreKmsKeyId(),
		utils.TestKeystoreName())
	searchableencryption.VirtualBeaconSearchableEncryptionExample(
		utils.SimpleBeaconTestDdbTableName(),
		branchKey2,
		utils.TestKeystoreKmsKeyId(),
		utils.TestKeystoreName())
}
