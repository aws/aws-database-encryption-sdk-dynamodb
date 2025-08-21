using System.Collections.Generic;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;

namespace Examples.migration.PlaintextToAWSDBE
{
    public static class Common
    {
        public static Dictionary<string, DynamoDbTableEncryptionConfig> CreateTableConfigs(string kmsKeyId, string ddbTableName, PlaintextOverride PlaintextOverride)
        {
            // Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
            // For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
            // We will use the `CreateMrkMultiKeyring` method to create this keyring,
            // as it will correctly handle both single region and Multi-Region KMS Keys.
            var matProv = new MaterialProviders(new MaterialProvidersConfig());
            var keyringInput = new CreateAwsKmsMrkMultiKeyringInput { Generator = kmsKeyId };
            var kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);
            
            // Configure which attributes are encrypted and/or signed when writing new items.
            // For each attribute that may exist on the items we plan to write to our DynamoDbTable,
            // we must explicitly configure how they should be treated during item encryption:
            //  - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
            //  - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
            //  - DO_NOTHING: The attribute is not encrypted and not included in the signature
            var partitionKeyName = "partition_key";
            var sortKeyName = "sort_key";
            var attributeActionsOnEncrypt = new Dictionary<string, CryptoAction>
            {
                [partitionKeyName] = CryptoAction.SIGN_ONLY,
                [sortKeyName] = CryptoAction.SIGN_ONLY,
                ["attribute1"] = CryptoAction.ENCRYPT_AND_SIGN,
                ["attribute2"] = CryptoAction.SIGN_ONLY,
                ["attribute3"] = CryptoAction.DO_NOTHING
            };
            
            // Configure which attributes we expect to be excluded in the signature
            // when reading items. There are two options for configuring this:
            //
            //    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
            //      When defining your DynamoDb schema and deciding on attribute names,
            //      choose a distinguishing prefix (such as ":") for all attributes that
            //      you do not want to include in the signature.
            //      This has two main benefits:
            //      - It is easier to reason about the security and authenticity of data within your item
            //        when all unauthenticated data is easily distinguishable by their attribute name.
            //      - If you need to add new unauthenticated attributes in the future,
            //        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
            //        and immediately start writing to that new attribute, without
            //        any other configuration update needed.
            //      Once you configure this field, it is not safe to update it.
            //
            //    - Configure `allowedUnsignedAttributes`: You may also explicitly list
            //      a set of attributes that should be considered unauthenticated when encountered
            //      on read. Be careful if you use this configuration. Do not remove an attribute
            //      name from this configuration, even if you are no longer writing with that attribute,
            //      as old items may still include this attribute, and our configuration needs to know
            //      to continue to exclude this attribute from the signature scope.
            //      If you add new attribute names to this field, you must first deploy the update to this
            //      field to all readers in your host fleet before deploying the update to start writing
            //      with that new attribute.
            //
            //   For this example, we will explicitly list the attributes that are not signed.
            var unsignedAttributes = new List<string> { "attribute3" };

            // Create the DynamoDb Encryption configuration for the table we will be writing to.
            var tableConfig = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = partitionKeyName,
                SortKeyName = sortKeyName,
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = kmsKeyring,
                AllowedUnsignedAttributes = unsignedAttributes,
                PlaintextOverride = PlaintextOverride
            };

            return new Dictionary<string, DynamoDbTableEncryptionConfig>
            {
                [ddbTableName] = tableConfig
            };
        }
    }
}
