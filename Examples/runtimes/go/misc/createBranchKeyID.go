// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package misc

import (
	"context"

	keystore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygenerated"
	keystoretypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/kms"
)

/*
 The Hierarchical Keyring Example and Searchable Encryption Examples
 rely on the existence of a DDB-backed key store with pre-existing
 branch key material or beacon key material.

 See the "Create KeyStore Table Example" for how to first set up
 the DDB Table that will back this KeyStore.

 This example demonstrates configuring a KeyStore and then
 using a helper method to create a branch key and beacon key
 that share the same Id, then return that Id.
 We will always create a new beacon key alongside a new branch key,
 even if you are not using searchable encryption.

 This key creation should occur within your control plane.
*/

func CreateBranchKeyIDExample(
	keyStoreTableName,
	logicalKeyStoreName,
	kmsKeyArn string) string {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	ddbClient := dynamodb.NewFromConfig(cfg)
	kmsClient := kms.NewFromConfig(cfg)
	// 1. Configure your KeyStore resource.
	//    This SHOULD be the same configuration that was used to create the DDB table
	//    in the "Create KeyStore Table Example".
	kmsConfig := keystoretypes.KMSConfigurationMemberkmsKeyArn{
		Value: kmsKeyArn,
	}
	keyStore, err := keystore.NewClient(keystoretypes.KeyStoreConfig{
		DdbTableName:        keyStoreTableName,
		KmsConfiguration:    &kmsConfig,
		LogicalKeyStoreName: logicalKeyStoreName,
		DdbClient:           ddbClient,
		KmsClient:           kmsClient,
	})
	utils.HandleError(err)
	// 2. Create a new branch key and beacon key in our KeyStore.
	//    Both the branch key and the beacon key will share an Id.
	//    This creation is eventually consistent.
	branchKey, err := keyStore.CreateKey(context.Background(), keystoretypes.CreateKeyInput{})
	utils.HandleError(err)

	return branchKey.BranchKeyIdentifier
}
