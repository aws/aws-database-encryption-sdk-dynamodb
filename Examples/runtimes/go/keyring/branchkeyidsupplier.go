// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package keyring

import (
	"fmt"

	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

// Used in the 'HierarchicalKeyringExample'.
// In that example, we have a table where we distinguish multiple tenants
// by a tenant ID that is stored in our partition attribute.
// The expectation is that this does not produce a confused deputy
// because the tenants are separated by partition.
// In order to create a Hierarchical Keyring that is capable of encrypting or
// decrypting data for either tenant, we implement this interface
// to map the correct branch key ID to the correct tenant ID.
type ExampleBranchKeyIDSupplier struct {
	branchKeyIDForTenant1 string
	branchKeyIDForTenant2 string
}

func NewExampleBranchKeyIDSupplier(tenant1ID, tenant2ID string) *ExampleBranchKeyIDSupplier {
	return &ExampleBranchKeyIDSupplier{
		branchKeyIDForTenant1: tenant1ID,
		branchKeyIDForTenant2: tenant2ID,
	}
}

func (s *ExampleBranchKeyIDSupplier) GetBranchKeyIDFromDdbKey(
	input dbesdkdynamodbencryptiontypes.GetBranchKeyIdFromDdbKeyInput,
) (*dbesdkdynamodbencryptiontypes.GetBranchKeyIdFromDdbKeyOutput, error) {
	if input.DdbKey == nil {
		return nil, fmt.Errorf("DdbKey cannot be nil")
	}

	key := input.DdbKey

	partitionKeyAttr, exists := key["partition_key"]
	if !exists {
		return nil, fmt.Errorf("item invalid, does not contain expected partition key attribute")
	}

	var tenantKeyID string
	switch attr := partitionKeyAttr.(type) {
	case *types.AttributeValueMemberS:
		tenantKeyID = attr.Value
	default:
		return nil, fmt.Errorf("partition_key must be a string attribute")
	}

	var branchKeyID string
	switch tenantKeyID {
	case "tenant1ID":
		branchKeyID = s.branchKeyIDForTenant1
	case "tenant2ID":
		branchKeyID = s.branchKeyIDForTenant2
	default:
		return nil, fmt.Errorf("item does not contain valid tenant ID")
	}

	return &dbesdkdynamodbencryptiontypes.GetBranchKeyIdFromDdbKeyOutput{
		BranchKeyId: branchKeyID,
	}, nil
}
