// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package clientsupplier

import (
	"context"

	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"

	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/credentials/stscreds"
	"github.com/aws/aws-sdk-go-v2/service/kms"
	"github.com/aws/aws-sdk-go-v2/service/sts"
)

/*
Example class demonstrating an implementation of a custom client supplier.
This particular implementation will create KMS clients with different IAM roles,
depending on the region passed.
*/
type RegionalRoleClientSupplier struct{}

func (r *RegionalRoleClientSupplier) GetClient(input mpltypes.GetClientInput) (kms.Client, error) {
	supplierConfig := NewRegionalRoleClientSupplierConfig()

	roleArn, exists := supplierConfig.RegionIamRoleMap[input.Region]
	if !exists {
		return kms.Client{}, mpltypes.AwsCryptographicMaterialProvidersException{
			Message: "Missing region: " + input.Region,
		}
	}

	// Load default AWS config
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		return kms.Client{}, err
	}

	// Create STS client for assuming role
	stsClient := sts.NewFromConfig(cfg)

	// Create credentials provider that assumes the role
	roleProvider := stscreds.NewAssumeRoleProvider(stsClient, roleArn, func(o *stscreds.AssumeRoleOptions) {
		o.RoleSessionName = "Go-Client-Supplier-Example-Session"
	})

	// Create KMS client with the assumed role credentials
	sdkConfig, err := config.LoadDefaultConfig(context.Background(), config.WithRegion(input.Region), config.WithCredentialsProvider(roleProvider))
	kmsClient := kms.NewFromConfig(sdkConfig)

	return *kmsClient, nil
}
