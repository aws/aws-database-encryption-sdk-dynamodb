# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
These examples set up DynamoDb Encryption for the AWS SDK table resource using the raw ECDH Keyring with EncrypedTable.

This keyring, depending on its KeyAgreement scheme,
takes in the sender's ECC private key, and the recipient's ECC Public Key to derive a shared secret.
The keyring uses the shared secret to derive a data key to protect the
data keys that encrypt and decrypt DynamoDb table items.

Running these examples require access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateRawEcdhKeyringInput,
    EphemeralPrivateKeyToStaticPublicKeyInput,
    PublicKeyDiscoveryInput,
    RawEcdhStaticConfigurationsEphemeralPrivateKeyToStaticPublicKey,
    RawEcdhStaticConfigurationsPublicKeyDiscovery,
    RawEcdhStaticConfigurationsRawPrivateKeyToStaticPublicKey,
    RawPrivateKeyToStaticPublicKeyInput,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)
from cryptography.hazmat.primitives import serialization

from .utility import (
    EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT,
    EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER,
    EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT,
)


def raw_ecdh_keyring_get_item_put_item_with_encrypted_table(ddb_table_name: str, curve_spec: str):
    """
    Demonstrate using a raw ECDH keyring with static keys.

    This example takes in the sender's private key as a
    UTF8 PEM-encoded (PKCS #8 PrivateKeyInfo structures)
    located at the file location defined in EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER,
    the recipient's public key as a UTF8 PEM-encoded X.509 public key, also known as SubjectPublicKeyInfo (SPKI),
    located at the file location defined in EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT,
    and the Curve Specification where the keys lie.

    This example encrypts a test item using the provided ECC keys and puts the
    encrypted item to the provided DynamoDb table. Then, it gets the
    item from the table and decrypts it.

    This examples creates a RawECDH keyring with the RawPrivateKeyToStaticPublicKey key agreement scheme.
    For more information on this configuration see:
    https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-raw-ecdh-keyring.html#raw-ecdh-RawPrivateKeyToStaticPublicKey

    On encrypt, the shared secret is derived from the sender's private key and the recipient's public key.
    On decrypt, the shared secret is derived from the sender's private key and the recipient's public key;
    however, on decrypt the recipient can construct a keyring such that the shared secret is calculated with
    the recipient's private key and the sender's public key. In both scenarios the shared secret will be the same.

    :param ddb_table_name: The name of the DynamoDB table
    :param curve_spec: The curve specification to use
    """
    # Load key pair from UTF-8 encoded PEM files.
    # You may provide your own PEM files to use here. If you provide this, it MUST
    # be a key on curve P256.
    # If you do not, the main method in this class will generate PEM
    # files for example use. Do not use these files for any other purpose.
    try:
        with open(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER, "rb") as f:
            private_key_utf8_encoded = f.read()
    except IOError as e:
        raise OSError("IOError while reading the private key from file") from e

    try:
        with open(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT, "rb") as f:
            public_key_utf8_encoded = f.read()
            public_key = serialization.load_pem_public_key(public_key_utf8_encoded)
            public_key_bytes = public_key.public_bytes(
                encoding=serialization.Encoding.DER, format=serialization.PublicFormat.SubjectPublicKeyInfo
            )
    except IOError as e:
        raise OSError("IOError while reading the public key from file") from e

    # Create the keyring.
    # This keyring uses static sender and recipient keys. This configuration calls for both of
    # the keys to be on the same curve (P256, P384, P521).
    # On encrypt, the shared secret is derived from the sender's private key and the recipient's public key.
    # For this example, on decrypt, the shared secret is derived from the sender's private key
    # and the recipient's public key;
    # however, on decrypt the recipient can construct a keyring such that the shared secret is calculated with
    # the recipient's private key and the sender's public key. In both scenarios the shared secret will be the same.
    # The DynamoDb encryption client uses this to encrypt and decrypt items.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateRawEcdhKeyringInput(
        curve_spec=curve_spec,
        key_agreement_scheme=RawEcdhStaticConfigurationsRawPrivateKeyToStaticPublicKey(
            RawPrivateKeyToStaticPublicKeyInput(
                # Must be a UTF8 PEM-encoded private key
                sender_static_private_key=private_key_utf8_encoded,
                # Must be a DER-encoded X.509 public key
                recipient_public_key=public_key_bytes,
            )
        ),
    )

    raw_ecdh_keyring = mat_prov.create_raw_ecdh_keyring(input=keyring_input)

    put_get_example_with_keyring_with_encrypted_table(raw_ecdh_keyring, ddb_table_name)


def ephemeral_raw_ecdh_keyring_put_item_with_encrypted_table(ddb_table_name: str, curve_spec: str):
    """
    Demonstrate using a raw ECDH keyring with ephemeral keys.

    This example takes in the recipient's public key located at EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    as a UTF8 PEM-encoded X.509 public key, and the Curve Specification where the key lies.

    This examples creates a RawECDH keyring with the EphemeralPrivateKeyToStaticPublicKey key agreement scheme.
    This configuration will always create a new key pair as the sender key pair for the key agreement operation.
    The ephemeral configuration can only encrypt data and CANNOT decrypt messages.
    For more information on this configuration see:
    https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-raw-ecdh-keyring.html#raw-ecdh-EphemeralPrivateKeyToStaticPublicKey

    :param ddb_table_name: The name of the DynamoDB table
    :param curve_spec: The curve specification to use
    """
    # Load public key from UTF-8 encoded PEM files into a DER encoded public key.
    # You may provide your own PEM files to use here. If you provide this, it MUST
    # be a key on curve P256.
    # If you do not, the main method in this class will generate PEM
    # files for example use. Do not use these files for any other purpose.
    try:
        with open(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT, "rb") as f:
            public_key_utf8_encoded = f.read()
            public_key = serialization.load_pem_public_key(public_key_utf8_encoded)
            public_key_bytes = public_key.public_bytes(
                encoding=serialization.Encoding.DER, format=serialization.PublicFormat.SubjectPublicKeyInfo
            )
    except IOError as e:
        raise OSError("IOError while reading the public key from file") from e

    # Create the keyring.
    # This keyring uses an ephemeral configuration. This configuration will always create a new
    # key pair as the sender key pair for the key agreement operation. The ephemeral configuration can only
    # encrypt data and CANNOT decrypt messages.
    # The DynamoDb encryption client uses this to encrypt items.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateRawEcdhKeyringInput(
        curve_spec=curve_spec,
        key_agreement_scheme=RawEcdhStaticConfigurationsEphemeralPrivateKeyToStaticPublicKey(
            EphemeralPrivateKeyToStaticPublicKeyInput(recipient_public_key=public_key_bytes)
        ),
    )

    raw_ecdh_keyring = mat_prov.create_raw_ecdh_keyring(input=keyring_input)

    # A raw ecdh keyring with Ephemeral configuration cannot decrypt data since the key pair
    # used as the sender is ephemeral. This means that at decrypt time it does not have
    # the private key that corresponds to the public key that is stored on the message.
    put_example_with_keyring_with_encrypted_table(raw_ecdh_keyring, ddb_table_name)


def discovery_raw_ecdh_keyring_get_item_with_encrypted_table(ddb_table_name: str, curve_spec: str):
    """
    Demonstrate using a raw ECDH keyring with discovery.

    This example takes in the recipient's private key located at EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
    as a UTF8 PEM-encoded (PKCS #8 PrivateKeyInfo structures) private key,
    and the Curve Specification where the key lies.

    This examples creates a RawECDH keyring with the PublicKeyDiscovery key agreement scheme.
    This scheme is only available on decrypt.
    For more information on this configuration see:
    https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-raw-ecdh-keyring.html#raw-ecdh-PublicKeyDiscovery

    :param ddb_table_name: The name of the DynamoDB table
    :param curve_spec: The curve specification to use
    """
    # Load key pair from UTF-8 encoded PEM files.
    # You may provide your own PEM files to use here. If you provide this, it MUST
    # be a key on curve P256.
    # If you do not, the main method in this class will generate PEM
    # files for example use. Do not use these files for any other purpose.
    try:
        with open(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT, "rb") as f:
            private_key_utf8_encoded = f.read()
    except IOError as e:
        raise OSError("IOError while reading the private key from file") from e

    # Create the keyring.
    # This keyring uses a discovery configuration. This configuration will check on decrypt
    # if it is meant to decrypt the message by checking if the configured public key is stored on the message.
    # The discovery configuration can only decrypt messages and CANNOT encrypt messages.
    # The DynamoDb encryption client uses this to decrypt items.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateRawEcdhKeyringInput(
        curve_spec=curve_spec,
        key_agreement_scheme=RawEcdhStaticConfigurationsPublicKeyDiscovery(
            PublicKeyDiscoveryInput(recipient_static_private_key=private_key_utf8_encoded)
        ),
    )

    raw_ecdh_keyring = mat_prov.create_raw_ecdh_keyring(input=keyring_input)

    # A raw ecdh keyring with discovery configuration cannot encrypt data since the keyring
    # looks for its configured public key on the message.
    get_example_with_keyring_with_encrypted_table(raw_ecdh_keyring, ddb_table_name)


def put_get_example_with_keyring_with_encrypted_table(raw_ecdh_keyring: IKeyring, ddb_table_name: str):
    """
    Demonstrate put and get operations with a raw ECDH keyring.

    :param raw_ecdh_keyring: The raw ECDH keyring to use
    :param ddb_table_name: The name of the DynamoDB table
    """
    # Configure which attributes are encrypted and/or signed when writing new items.
    # For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    # we must explicitly configure how they should be treated during item encryption:
    #   - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #   - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #   - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions = {
        "partition_key": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "sort_key": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "sensitive_data": CryptoAction.ENCRYPT_AND_SIGN,
    }

    # Configure which attributes we expect to be included in the signature
    # when reading items. There are two options for configuring this:
    #
    # - (Recommended) Configure `allowed_unsigned_attribute_prefix`:
    #   When defining your DynamoDb schema and deciding on attribute names,
    #   choose a distinguishing prefix (such as ":") for all attributes that
    #   you do not want to include in the signature.
    #   This has two main benefits:
    #   - It is easier to reason about the security and authenticity of data within your item
    #     when all unauthenticated data is easily distinguishable by their attribute name.
    #   - If you need to add new unauthenticated attributes in the future,
    #     you can easily make the corresponding update to your `attribute_actions`
    #     and immediately start writing to that new attribute, without
    #     any other configuration update needed.
    #   Once you configure this field, it is not safe to update it.
    #
    # - Configure `allowed_unsigned_attributes`: You may also explicitly list
    #   a set of attributes that should be considered unauthenticated when encountered
    #   on read. Be careful if you use this configuration. Do not remove an attribute
    #   name from this configuration, even if you are no longer writing with that attribute,
    #   as old items may still include this attribute, and our configuration needs to know
    #   to continue to exclude this attribute from the signature scope.
    #   If you add new attribute names to this field, you must first deploy the update to this
    #   field to all readers in your host fleet before deploying the update to start writing
    #   with that new attribute.
    #
    # For this example, we currently authenticate all attributes. To make it easier to
    # add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    unsign_attr_prefix = ":"

    # Create the DynamoDb Encryption configuration for the table we will be writing to.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=raw_ecdh_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # Create the EncryptedTable
    ddb_table = boto3.resource("dynamodb").Table(ddb_table_name)
    encrypted_table = EncryptedTable(
        table=ddb_table,
        encryption_config=tables_config,
    )

    # Put an item into our table using the encrypted table
    # Before the item gets sent to DynamoDb, it will be encrypted
    # client-side, according to our configuration.
    item = {
        "partition_key": "rawEcdhKeyringItem",
        "sort_key": 0,
        "sensitive_data": "encrypt and sign me!",
    }

    put_response = encrypted_table.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Get the item back from our table using the encrypted table
    # The table will decrypt the item client-side and return the original item.
    key_to_get = {"partition_key": "rawEcdhKeyringItem", "sort_key": 0}

    get_response = encrypted_table.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"] == "encrypt and sign me!"


def put_example_with_keyring_with_encrypted_table(raw_ecdh_keyring: IKeyring, ddb_table_name: str):
    """
    Demonstrate put operation with a raw ECDH keyring.

    :param raw_ecdh_keyring: The raw ECDH keyring to use
    :param ddb_table_name: The name of the DynamoDB table
    """
    # Configure which attributes are encrypted and/or signed when writing new items.
    # For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    # we must explicitly configure how they should be treated during item encryption:
    #   - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #   - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #   - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions = {
        "partition_key": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "sort_key": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "sensitive_data": CryptoAction.ENCRYPT_AND_SIGN,
    }

    # Configure which attributes we expect to be included in the signature
    # when reading items. There are two options for configuring this:
    #
    # - (Recommended) Configure `allowed_unsigned_attribute_prefix`:
    #   When defining your DynamoDb schema and deciding on attribute names,
    #   choose a distinguishing prefix (such as ":") for all attributes that
    #   you do not want to include in the signature.
    #   This has two main benefits:
    #   - It is easier to reason about the security and authenticity of data within your item
    #     when all unauthenticated data is easily distinguishable by their attribute name.
    #   - If you need to add new unauthenticated attributes in the future,
    #     you can easily make the corresponding update to your `attribute_actions`
    #     and immediately start writing to that new attribute, without
    #     any other configuration update needed.
    #   Once you configure this field, it is not safe to update it.
    #
    # - Configure `allowed_unsigned_attributes`: You may also explicitly list
    #   a set of attributes that should be considered unauthenticated when encountered
    #   on read. Be careful if you use this configuration. Do not remove an attribute
    #   name from this configuration, even if you are no longer writing with that attribute,
    #   as old items may still include this attribute, and our configuration needs to know
    #   to continue to exclude this attribute from the signature scope.
    #   If you add new attribute names to this field, you must first deploy the update to this
    #   field to all readers in your host fleet before deploying the update to start writing
    #   with that new attribute.
    #
    # For this example, we currently authenticate all attributes. To make it easier to
    # add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    unsign_attr_prefix = ":"

    # Create the DynamoDb Encryption configuration for the table we will be writing to.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=raw_ecdh_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # Create the EncryptedTable
    ddb_table = boto3.resource("dynamodb").Table(ddb_table_name)
    encrypted_table = EncryptedTable(
        table=ddb_table,
        encryption_config=tables_config,
    )

    # Put an item into our table using the encrypted table
    # Before the item gets sent to DynamoDb, it will be encrypted
    # client-side, according to our configuration.
    item = {
        "partition_key": "rawEcdhKeyringItem",
        "sort_key": 0,
        "sensitive_data": "encrypt and sign me!",
    }

    put_response = encrypted_table.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200


def get_example_with_keyring_with_encrypted_table(raw_ecdh_keyring: IKeyring, ddb_table_name: str):
    """
    Demonstrate get operation with a raw ECDH keyring.

    :param raw_ecdh_keyring: The raw ECDH keyring to use
    :param ddb_table_name: The name of the DynamoDB table
    """
    # Configure which attributes are encrypted and/or signed when writing new items.
    # For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    # we must explicitly configure how they should be treated during item encryption:
    #   - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #   - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #   - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions = {
        "partition_key": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "sort_key": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "sensitive_data": CryptoAction.ENCRYPT_AND_SIGN,
    }

    # Configure which attributes we expect to be included in the signature
    # when reading items. There are two options for configuring this:
    #
    # - (Recommended) Configure `allowed_unsigned_attribute_prefix`:
    #   When defining your DynamoDb schema and deciding on attribute names,
    #   choose a distinguishing prefix (such as ":") for all attributes that
    #   you do not want to include in the signature.
    #   This has two main benefits:
    #   - It is easier to reason about the security and authenticity of data within your item
    #     when all unauthenticated data is easily distinguishable by their attribute name.
    #   - If you need to add new unauthenticated attributes in the future,
    #     you can easily make the corresponding update to your `attribute_actions`
    #     and immediately start writing to that new attribute, without
    #     any other configuration update needed.
    #   Once you configure this field, it is not safe to update it.
    #
    # - Configure `allowed_unsigned_attributes`: You may also explicitly list
    #   a set of attributes that should be considered unauthenticated when encountered
    #   on read. Be careful if you use this configuration. Do not remove an attribute
    #   name from this configuration, even if you are no longer writing with that attribute,
    #   as old items may still include this attribute, and our configuration needs to know
    #   to continue to exclude this attribute from the signature scope.
    #   If you add new attribute names to this field, you must first deploy the update to this
    #   field to all readers in your host fleet before deploying the update to start writing
    #   with that new attribute.
    #
    # For this example, we currently authenticate all attributes. To make it easier to
    # add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    unsign_attr_prefix = ":"

    # Create the DynamoDb Encryption configuration for the table we will be writing to.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=raw_ecdh_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # Create the EncryptedTable
    ddb_table = boto3.resource("dynamodb").Table(ddb_table_name)
    encrypted_table = EncryptedTable(
        table=ddb_table,
        encryption_config=tables_config,
    )

    # Get the item back from our table using the encrypted table
    # The table will decrypt the item client-side and return the original item.
    key_to_get = {"partition_key": "rawEcdhKeyringItem", "sort_key": 0}

    get_response = encrypted_table.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"] == "encrypt and sign me!"
