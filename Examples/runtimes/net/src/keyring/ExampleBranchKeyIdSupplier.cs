using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;

// Used in the 'HierarchicalKeyringExample'.
// In that example, we have a table where we distinguish multiple tenants
// by a tenant ID that is stored in our partition attribute.
// The expectation is that this does not produce a confused deputy
// because the tenants are separated by partition.
// In order to create a Hierarchical Keyring that is capable of encrypting or
// decrypting data for either tenant, we implement this interface
// to map the correct branch key ID to the correct tenant ID.
class ExampleBranchKeyIdSupplier : DynamoDbKeyBranchKeyIdSupplierBase
{
    private String _branchKeyIdForTenant1;
    private String _branchKeyIdForTenant2;

    public ExampleBranchKeyIdSupplier(String tenant1Id, String tenant2Id)
    {
        this._branchKeyIdForTenant1 = tenant1Id;
        this._branchKeyIdForTenant2 = tenant2Id;
    }

    protected override GetBranchKeyIdFromDdbKeyOutput _GetBranchKeyIdFromDdbKey(GetBranchKeyIdFromDdbKeyInput input)
    {
        var key = input.DdbKey;

        if (!key.ContainsKey("partition_key"))
        {
            throw new ArgumentException("Item invalid, does not contain expected partition key attribute.");
        }
        String tenantKeyId = key["partition_key"].S;

        String branchKeyId;
        if (tenantKeyId.Equals("tenant1Id"))
        {
            branchKeyId = _branchKeyIdForTenant1;
        }
        else if (tenantKeyId.Equals("tenant2Id"))
        {
            branchKeyId = _branchKeyIdForTenant2;
        }
        else
        {
            throw new ArgumentException("Item does not contain valid tenant ID");
        }

        return new GetBranchKeyIdFromDdbKeyOutput { BranchKeyId = branchKeyId };
    }
}
