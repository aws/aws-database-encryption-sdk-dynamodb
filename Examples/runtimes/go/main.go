// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package main

import (
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/clientsupplier"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/itemencryptor"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/keyring"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/migration/PlaintextToAWSDBE/awsdbe"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/migration/PlaintextToAWSDBE/plaintext"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/misc"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/searchableencryption"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/searchableencryption/complexexample"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/google/uuid"
)

func main() {
	// clientsupplier example
	clientsupplier.ClientSupplierExample(
		utils.DdbTableName(),
		utils.TestMrkReplicaKeyIdUsEast1(),
		utils.DefaultKMSKeyAccountID(),
		utils.AlternateRegionKmsKeyRegionAsAList())
	// misc examples
	misc.BasicPutGetExample(
		utils.KmsKeyID(),
		utils.DdbTableName())
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
	complexexample.ComplexSearchableEncryptionExample(
		utils.TestComplexDdbTableName(),
		branchKey1,
		utils.TestKeystoreKmsKeyId(),
		utils.TestKeystoreName())

	// migration examples
	partitionKeyValue := uuid.New().String()
	sortKeyValue := "0"

	plaintext.MigrationStep0(utils.DdbTableName(), partitionKeyValue, sortKeyValue)
	awsdbe.MigrationStep1(utils.KmsKeyID(), utils.DdbTableName(), partitionKeyValue, sortKeyValue)
	awsdbe.MigrationStep2(utils.KmsKeyID(), utils.DdbTableName(), partitionKeyValue, sortKeyValue)
	awsdbe.MigrationStep3(utils.KmsKeyID(), utils.DdbTableName(), partitionKeyValue, sortKeyValue)
	utils.DeleteItem(utils.DdbTableName(), "partition_key", partitionKeyValue, "sort_key", sortKeyValue)
}
