// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package keyring

import (
	"fmt"

	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

// ExampleBranchKeyIdSupplier is used in the 'HierarchicalKeyringExample'.
// In that example, we have a table where we distinguish multiple tenants
// by a tenant ID that is stored in our partition attribute.
// The expectation is that this does not produce a confused deputy
// because the tenants are separated by partition.
// In order to create a Hierarchical Keyring that is capable of encrypting or
// decrypting data for either tenant, we implement this interface
// to map the correct branch key ID to the correct tenant ID.
type ExampleBranchKeyIdSupplier struct {
	branchKeyIdForTenant1 string
	branchKeyIdForTenant2 string
}

// NewExampleBranchKeyIdSupplier creates a new instance of ExampleBranchKeyIdSupplier
func NewExampleBranchKeyIdSupplier(tenant1Id, tenant2Id string) *ExampleBranchKeyIdSupplier {
	return &ExampleBranchKeyIdSupplier{
		branchKeyIdForTenant1: tenant1Id,
		branchKeyIdForTenant2: tenant2Id,
	}
}

// GetBranchKeyIdFromDdbKey implements the DynamoDbKeyBranchKeyIdSupplier interface
func (s *ExampleBranchKeyIdSupplier) GetBranchKeyIdFromDdbKey(
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

	// Extract the string value from the AttributeValue
	var tenantKeyId string
	switch attr := partitionKeyAttr.(type) {
	case *types.AttributeValueMemberS:
		tenantKeyId = attr.Value
	default:
		return nil, fmt.Errorf("partition_key must be a string attribute")
	}

	var branchKeyId string
	switch tenantKeyId {
	case "tenant1Id":
		branchKeyId = s.branchKeyIdForTenant1
	case "tenant2Id":
		branchKeyId = s.branchKeyIdForTenant2
	default:
		return nil, fmt.Errorf("item does not contain valid tenant ID")
	}

	return &dbesdkdynamodbencryptiontypes.GetBranchKeyIdFromDdbKeyOutput{
		BranchKeyId: branchKeyId,
	}, nil
}
