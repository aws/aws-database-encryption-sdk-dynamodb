import boto3
from boto3.dynamodb.types import Binary
from decimal import Decimal

from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsMrkKeyringInput,
    CreateAwsKmsMrkMultiKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models import (
    CryptoAction,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
    PlaintextOverride,
)
from aws_dbesdk_dynamodb.encrypted.client import (
    EncryptedClient
)

def migration_step1(kms_key_id, ddb_table_name, sort_read_value):
    # 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    #    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    #    as it will correctly handle both single region and Multi-Region KMS Keys.
    # 
    #    Note that while we still are not writing encrypted items,
    #    and our key will not be used to encrypt items in this example,
    #    our configuration specifies that we may read encrypted items,
    #    and we should expect to be able to decrypt and process any encrypted items.
    #    To that end, we must fully define our encryption configuration in
    #    this step.
    mat_prov: AwsCryptographicMaterialProviders = AwsCryptographicMaterialProviders(
        config=MaterialProvidersConfig()
    )
    keyring_input = CreateAwsKmsMrkMultiKeyringInput(generator=kms_key_id)
    kms_keyring = mat_prov.create_aws_kms_mrk_multi_keyring(keyring_input)

    # 2. Create a Table Schema over your annotated class.
    #    See SimpleClass.java in this directory for the update to use the new DynamoDb Enhanced Client annotations.
    #    All primary key attributes will be signed but not encrypted (SIGN_ONLY)
    #    and by default all non-primary key attributes will be encrypted and signed (ENCRYPT_AND_SIGN).
    #    If you want a particular non-primary key attribute to be signed but not encrypted,
    #    use the `DynamoDbEncryptionSignOnly` annotation.
    #    If you want a particular attribute to be neither signed nor encrypted (DO_NOTHING),
    #    use the `DynamoDbEncryptionDoNothing` annotation.
    table_schema = {
        'partition_key': {'type': 'S', 'key_type': 'HASH'},
        'sort_key': {'type': 'S', 'key_type': 'RANGE'}
    }

    # 3. Configure which attributes we expect to be excluded in the signature
    #    when reading items. This value represents all unsigned attributes
    #    across our entire dataset. If you ever want to add new unsigned attributes
    #    in the future, you must make an update to this field to all your readers
    #    before deploying any change to start writing that new data. It is not safe
    #    to remove attributes from this field.
    unsigned_attributes = ['attribute3']

    # 4. Create encryption configuration for table.
    #    Again, while we are not writing encrypted items,
    #    we should expect to be able to read encrypted items.
    table_configs = {
        ddb_table_name: DynamoDbTableEncryptionConfig(
            logical_table_name=ddb_table_name,
            keyring=kms_keyring,
            schema_on_encrypt=table_schema,
            allowed_unsigned_attributes=unsigned_attributes,
            # This plaintext override means:
            #  - Write: Items are forced to be written as plaintext.
            #           Items may not be written as encrypted items.
            #  - Read: Items are allowed to be read as plaintext.
            #          Items are allowed to be read as encrypted items.
            plaintext_override=PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
        )
    }

    # 5. Create DynamoDbTablesEncryptionConfig using the table config
    interceptor = DynamoDbEnhancedClientEncryption.create_dynamodb_encryption_interceptor(
        CreateDynamoDbEncryptionInterceptorInput(
            table_encryption_configs=table_configs
        )
    )

    # 6. Create the EnhancedClient using the interceptor, and create a table from the schema
    ddb = boto3.client('dynamodb', region_name='us-west-2')
    table = boto3.resource('dynamodb').Table(ddb_table_name)

    # 7. Put an item into your table using the DynamoDb Enhanced Client.
    #    This item will be stored in plaintext.
    item = {
        'partition_key': 'PlaintextMigrationExample',
        'sort_key': 1,
        'attribute1': 'this will be encrypted and signed',
        'attribute3': 'this will never be encrypted nor signed',
        'attribute2': 'this will never be encrypted, but it will be signed'
    }
    table.put_item(Item=item)

    # 8. Get an item back from the table using the DynamoDb Enhanced Client.
    #    If this is an item written in plaintext (i.e. any item written
    #    during Step 0 or 1), then the item will still be in plaintext.
    #    If this is an item that was encrypted client-side (i.e. any item written
    #    during Step 2 or after), then the item will be decrypted client-side
    #    and surfaced as a plaintext item.
    response = table.get_item(
        Key={
            'partition_key': 'PlaintextMigrationExample',
            'sort_key': sort_read_value
        }
    )
    returned_item = response['Item']

    # Demonstrate we get the expected item back
    assert returned_item['partition_key'] == 'PlaintextMigrationExample'
    assert returned_item['attribute1'] == 'this will be encrypted and signed'

def main():
    import sys
    if len(sys.argv) < 4:
        raise ValueError(
            "To run this example, include the kmsKeyId, ddbTableName, and sortReadValue as args."
        )
    
    kms_key_id = sys.argv[1]
    ddb_table_name = sys.argv[2]
    sort_read_value = int(sys.argv[3])
    
    migration_step1(kms_key_id, ddb_table_name, sort_read_value)

if __name__ == '__main__':
    main()
