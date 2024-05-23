using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using Amazon.DynamoDBv2.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;
using Org.BouncyCastle.Crypto;
using PemWriter = Org.BouncyCastle.OpenSsl.PemWriter;
using Org.BouncyCastle.Crypto.Generators;
using Org.BouncyCastle.Security;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the raw RSA Keyring. This keyring uses an RSA key pair to
  encrypt and decrypt records. This keyring accepts PEM encodings of
  the key pair as UTF-8 interpreted bytes. The client uses the public key
  to encrypt items it adds to the table and uses the private key to decrypt
  existing table items it retrieves.

  This example loads a key pair from PEM files with paths defined in
   - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
   - EXAMPLE_RSA_PUBLIC_KEY_FILENAME
  If you do not provide these files, running this example through this
  class' main method will generate these files for you. These files will
  be generated in the directory where the example is run.
  In practice, users of this library should not generate new key pairs
  like this, and should instead retrieve an existing key from a secure
  key management system (e.g. an HSM).
  You may also provide your own key pair by placing PEM files in the
  directory where the example is run or modifying the paths in the code
  below. These files must be valid PEM encodings of the key pair as UTF-8
  encoded bytes. If you do provide your own key pair, or if a key pair
  already exists, this class' main method will not generate a new key pair.

  This example loads a key pair from disk, encrypts a test item, and puts the
  encrypted item to the provided DynamoDb table. Then, it gets the
  item from the table and decrypts it.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class RawRsaKeyringExample
{
    private static readonly String EXAMPLE_RSA_PRIVATE_KEY_FILENAME = "RawRsaKeyringExamplePrivateKey.pem";
    private static readonly String EXAMPLE_RSA_PUBLIC_KEY_FILENAME = "RawRsaKeyringExamplePublicKey.pem";

    public static async Task RawRsaKeyringGetItemPutItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;

        // You may provide your own RSA key pair in the files located at
        //  - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
        //  - EXAMPLE_RSA_PUBLIC_KEY_FILENAME
        // If these files are not present, this will generate a pair for you
        if (RawRsaKeyringExample.ShouldGenerateNewRsaKeyPair())
        {
            RawRsaKeyringExample.GenerateRsaKeyPair();
        }

        // 1. Load key pair from UTF-8 encoded PEM files.
        //    You may provide your own PEM files to use here.
        //    If you do not, the main method in this class will generate PEM
        //    files for example use. Do not use these files for any other purpose.
        MemoryStream publicKeyUtf8EncodedByteBuffer;
        try
        {
            publicKeyUtf8EncodedByteBuffer = new MemoryStream(
                File.ReadAllBytes(EXAMPLE_RSA_PUBLIC_KEY_FILENAME));
        }
        catch (IOException e)
        {
            throw new IOException("Exception while reading public key from file", e);
        }

        MemoryStream privateKeyUtf8EncodedByteBuffer;
        try
        {
            privateKeyUtf8EncodedByteBuffer = new MemoryStream(
                File.ReadAllBytes(EXAMPLE_RSA_PRIVATE_KEY_FILENAME));
        }
        catch (IOException e)
        {
            throw new IOException("Exception while reading private key from file", e);
        }

        // 2. Create the keyring.
        //    The DynamoDb encryption client uses this to encrypt and decrypt items.
        var keyringInput = new CreateRawRsaKeyringInput
        {
            KeyName = "my-rsa-key-name",
            KeyNamespace = "my-key-namespace",
            PaddingScheme = PaddingScheme.OAEP_SHA256_MGF1,
            PublicKey = publicKeyUtf8EncodedByteBuffer,
            PrivateKey = privateKeyUtf8EncodedByteBuffer
        };
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var rawRsaKeyring = matProv.CreateRawRsaKeyring(keyringInput);

        // 3. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        // 4. Configure which attributes we expect to be included in the signature
        //    when reading items. There are two options for configuring this:
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
        //   For this example, we currently authenticate all attributes. To make it easier to
        //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
        const String unsignAttrPrefix = ":";

        // 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = rawRsaKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // 6. Create a new AWS SDK DynamoDb client using the config above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 8. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side, according to our configuration.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("rawRsaKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["sensitive_data"] = new AttributeValue("encrypt and sign me!")
        };

        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item
        };

        var putResponse = await ddb.PutItemAsync(putRequest);

        // Demonstrate that PutItem succeeded
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        // 9. Get the item back from our table using the same client.
        //    The client will decrypt the item client-side, and return
        //    back the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("rawRsaKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName
        };

        var getResponse = await ddb.GetItemAsync(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Item;
        Debug.Assert(returnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));
    }

    static bool ShouldGenerateNewRsaKeyPair()
    {
        // If a key pair already exists: do not overwrite existing key pair
        if (File.Exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) && File.Exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME))
        {
            return false;
        }

        // If only one file is present: throw exception
        if (File.Exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) && !File.Exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME))
        {
            throw new ApplicationException("Missing public key file at " + EXAMPLE_RSA_PUBLIC_KEY_FILENAME);
        }

        // If a key pair already exists: do not overwrite existing key pair
        if (File.Exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) && !File.Exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME))
        {
            throw new ApplicationException("Missing private key file at " + EXAMPLE_RSA_PRIVATE_KEY_FILENAME);
        }

        // If neither file is present, generate a new key pair
        return true;
    }

    static void GenerateRsaKeyPair()
    {
        // Safety check: Validate neither file is present
        if (File.Exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) || File.Exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME))
        {
            throw new ApplicationException("generateRsaKeyPair will not overwrite existing PEM files");
        }

        // This code will generate a new RSA key pair for example use.
        // The public and private key will be written to the files:
        //  - public: EXAMPLE_RSA_PUBLIC_KEY_FILENAME
        //  - private: EXAMPLE_RSA_PRIVATE_KEY_FILENAME
        // This example uses BouncyCastle's KeyPairGenerator to generate the key pair.
        // In practice, you should not generate this in your code, and should instead
        // retrieve this key from a secure key management system (e.g. HSM)
        // This key is created here for example purposes only.

        var r = new RsaKeyPairGenerator();
        r.Init(new KeyGenerationParameters(new SecureRandom(), 2048));
        var keys = r.GenerateKeyPair();

        var privateKeyStringWriter = new StringWriter();
        var pemWriter = new PemWriter(privateKeyStringWriter);
        pemWriter.WriteObject(keys.Private);

        var privateKeyUtf8EncodedByteBuffer = Encoding.UTF8.GetBytes(privateKeyStringWriter.ToString());
        var fc = new FileStream(EXAMPLE_RSA_PRIVATE_KEY_FILENAME, FileMode.Create, FileAccess.Write);
        fc.Write(privateKeyUtf8EncodedByteBuffer);
        fc.Close();

        var publicKeyStringWriter = new StringWriter();
        var publicKeyPemWriter = new PemWriter(publicKeyStringWriter);
        publicKeyPemWriter.WriteObject(keys.Public);
        var publicKeyUtf8EncodedByteBuffer = Encoding.UTF8.GetBytes(publicKeyStringWriter.ToString());

        fc = new FileStream(EXAMPLE_RSA_PUBLIC_KEY_FILENAME, FileMode.Create, FileAccess.Write);
        fc.Write(publicKeyUtf8EncodedByteBuffer);
        fc.Close();
    }
}