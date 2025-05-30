# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
These examples set up DynamoDb Encryption for the AWS SDK client
using the AWS KMS ECDH Keyring. This keyring, depending on its KeyAgreement scheme,
takes in the sender's KMS ECC Key ARN, and the recipient's ECC Public Key to derive a shared secret.
The keyring uses the shared secret to derive a data key to protect the
data keys that encrypt and decrypt DynamoDb table items.

Running these examples require access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""
import pathlib

import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsEcdhKeyringInput,
    DBEAlgorithmSuiteId,
    KmsEcdhStaticConfigurationsKmsPrivateKeyToStaticPublicKey,
    KmsEcdhStaticConfigurationsKmsPublicKeyDiscovery,
    KmsPrivateKeyToStaticPublicKeyInput,
    KmsPublicKeyDiscoveryInput,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring

# TODO: Resolve dependencies
# from aws_cryptographic_primitives.model import ECDHCurveSpec
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)
from cryptography.hazmat.primitives import serialization

EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME = "KmsEccKeyringKeyringExamplePublicKeySender.pem"
EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME = "KmsEccKeyringKeyringExamplePublicKeyRecipient.pem"


def kms_ecdh_keyring_get_item_put_item(
    ddb_table_name: str,
    ecc_key_arn: str,
    ecc_public_key_sender_filename: str = EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME,
    ecc_public_key_recipient_filename: str = EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME
):
    """
    Demonstrate using a KMS ECDH keyring with static keys.

    This example takes in the sender's KMS ECC key ARN, the sender's public key,
    the recipient's public key, and the algorithm definition where the ECC keys lie.
    The ecc_key_arn parameter takes in the sender's KMS ECC key ARN,
    the ecc_public_key_sender_filename parameter takes in the sender's public key that corresponds to the
    ecc_key_arn, the ecc_public_key_recipient_filename parameter takes in the recipient's public key,
    and the Curve Specification where the keys lie.

    Both public keys MUST be UTF8 PEM-encoded X.509 public key, also known as SubjectPublicKeyInfo (SPKI)

    This example encrypts a test item using the provided ECC keys and puts the
    encrypted item to the provided DynamoDb table. Then, it gets the
    item from the table and decrypts it.

    Running this example requires access to the DDB Table whose name
    is provided in CLI arguments.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (S)
    This example also requires access to a KMS ECC key.
    Our tests provide a KMS ECC Key ARN that anyone can use, but you
    can also provide your own KMS ECC key.
    To use your own KMS ECC key, you must have either:
     - Its public key downloaded in a UTF-8 encoded PEM file
     - kms:GetPublicKey permissions on that key.
    If you do not have the public key downloaded, running this example
    through its main method will download the public key for you
    by calling kms:GetPublicKey.
    You must also have kms:DeriveSharedSecret permissions on the KMS ECC key.
    This example also requires a recipient ECC Public Key that lies on the same
    curve as the sender public key. This examples uses another distinct
    KMS ECC Public Key, it does not have to be a KMS key; it can be a
    valid SubjectPublicKeyInfo (SPKI) Public Key.

    :param ddb_table_name: The name of the DynamoDB table
    :param ecc_key_arn: The ARN of the KMS ECC key to use
    :param ecc_public_key_sender_filename: The filename containing the sender's public key
    :param ecc_public_key_recipient_filename: The filename containing the recipient's public key
    """
    # Load UTF-8 encoded public key PEM files as DER encoded bytes.
    # You may provide your own PEM files to use here. If you provide this, it MUST
    # be a key on curve P256.
    # If not, the main method in this class will call
    # the KMS ECC key, retrieve its public key, and store it
    # in a PEM file for example use.
    public_key_recipient_bytes = load_public_key_bytes(ecc_public_key_recipient_filename)
    public_key_sender_bytes = load_public_key_bytes(ecc_public_key_sender_filename)

    # Create a KMS ECDH keyring.
    # This keyring uses the KmsPrivateKeyToStaticPublicKey configuration. This configuration calls for both of
    # the keys to be on the same curve (P256, P384, P521).
    # On encrypt, the keyring calls AWS KMS to derive the shared secret from the sender's KMS ECC Key ARN and the recipient's public key.
    # For this example, on decrypt, the keyring calls AWS KMS to derive the shared secret from the sender's KMS ECC Key ARN and the recipient's public key;
    # however, on decrypt, the recipient can construct a keyring such that the shared secret is calculated with
    # the recipient's private key and the sender's public key. In both scenarios the shared secret will be the same.
    # For more information on this configuration see:
    # https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-ecdh-keyring.html#kms-ecdh-create
    # The DynamoDb encryption client uses this keyring to encrypt and decrypt items.
    # This keyring takes in:
    #  - kms_client
    #  - kms_key_id: Must be an ARN representing a KMS ECC key meant for KeyAgreement
    #  - curve_spec: The curve name where the public keys lie
    #  - sender_public_key: A ByteBuffer of a UTF-8 encoded public
    #               key for the key passed into kms_key_id in DER format
    #  - recipient_public_key: A ByteBuffer of a UTF-8 encoded public
    #               key for the key passed into kms_key_id in DER format
    mat_prov = AwsCryptographicMaterialProviders(
        config=MaterialProvidersConfig()
    )

    keyring_input = CreateAwsKmsEcdhKeyringInput(
        kms_client=boto3.client('kms'),
        curve_spec='ECC_NIST_P256',
        key_agreement_scheme=KmsEcdhStaticConfigurationsKmsPrivateKeyToStaticPublicKey(
            KmsPrivateKeyToStaticPublicKeyInput(
                sender_kms_identifier=ecc_key_arn,
                # Must be a DER-encoded X.509 public key
                sender_public_key=public_key_sender_bytes,
                # Must be a DER-encoded X.509 public key
                recipient_public_key=public_key_recipient_bytes
            )
        )
    )

    kms_ecdh_keyring = mat_prov.create_aws_kms_ecdh_keyring(
        input=keyring_input
    )

    put_get_item_with_keyring(kms_ecdh_keyring, ddb_table_name)


def kms_ecdh_discovery_get_item(
    ddb_table_name: str,
    ecc_recipient_key_arn: str
):
    """
    Demonstrate using a KMS ECDH keyring with discovery.

    This example takes in the recipient's KMS ECC key ARN via
    the ecc_recipient_key_arn parameter.

    This example attempts to decrypt a test item using the provided ecc_recipient_key_arn,
    it does so by checking if the message header contains the recipient's public key.

    Running this example requires access to the DDB Table whose name
    is provided in CLI arguments.
    This table must be configured with the following
    primary key configuration:
      - Partition key is named "partition_key" with type (S)
      - Sort key is named "sort_key" with type (S)
    This example also requires access to a KMS ECC key.
    Our tests provide a KMS ECC Key ARN that anyone can use, but you
    can also provide your own KMS ECC key.
    To use your own KMS ECC key, you must have:
     - kms:GetPublicKey permissions on that key.
    This example will call kms:GetPublicKey on keyring creation.
    You must also have kms:DeriveSharedSecret permissions on the KMS ECC key.

    :param ddb_table_name: The name of the DynamoDB table
    :param ecc_recipient_key_arn: The ARN of the recipient's KMS ECC key
    """
    # Create a KMS ECDH keyring.
    # This keyring uses the KmsPublicKeyDiscovery configuration.
    # On encrypt, the keyring will fail as it is not allowed to encrypt data under this configuration.
    # On decrypt, the keyring will check if its corresponding public key is stored in the message header. It
    # will AWS KMS to derive the shared from the recipient's KMS ECC Key ARN and the sender's public key;
    # For more information on this configuration see:
    # https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-ecdh-keyring.html#kms-ecdh-discovery
    # The DynamoDb encryption client uses this to encrypt and decrypt items.
    # This keyring takes in:
    #  - kms_client
    #  - recipient_kms_identifier: Must be an ARN representing a KMS ECC key meant for KeyAgreement
    #  - curve_spec: The curve name where the public keys lie
    mat_prov = AwsCryptographicMaterialProviders(
        config=MaterialProvidersConfig()
    )

    keyring_input = CreateAwsKmsEcdhKeyringInput(
        kms_client=boto3.client('kms'),
        curve_spec='ECC_NIST_P256',
        key_agreement_scheme=KmsEcdhStaticConfigurationsKmsPublicKeyDiscovery(
            KmsPublicKeyDiscoveryInput(
                recipient_kms_identifier=ecc_recipient_key_arn
            )
        )
    )

    kms_ecdh_keyring = mat_prov.create_aws_kms_ecdh_keyring(
        input=keyring_input
    )

    get_item_with_keyring(kms_ecdh_keyring, ddb_table_name)


def get_item_with_keyring(
    kms_ecdh_keyring: IKeyring,
    ddb_table_name: str
):
    """
    Demonstrate get operation with a KMS ECDH keyring.

    :param kms_ecdh_keyring: The KMS ECDH keyring to use
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
        "sensitive_data": CryptoAction.ENCRYPT_AND_SIGN
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
    # Note: To use the KMS RSA keyring, your table config must specify an algorithmSuite
    # that does not use asymmetric signing.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=kms_ecdh_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
        # Specify algorithmSuite without asymmetric signing here
        # As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
        # ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
        algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # Create the EncryptedClient
    ddb_client = boto3.client('dynamodb')
    encrypted_ddb_client = EncryptedClient(
        client=ddb_client,
        encryption_config=tables_config
    )

    # Get the item back from our table using the client.
    # The client will decrypt the item client-side using the ECDH keyring
    # and return the original item.
    key_to_get = {
        "partition_key": {"S": "awsKmsEcdhKeyringItem"},
        "sort_key": {"N": "0"}
    }

    get_response = encrypted_ddb_client.get_item(
        TableName=ddb_table_name,
        Key=key_to_get
    )

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response['ResponseMetadata']['HTTPStatusCode'] == 200
    returned_item = get_response['Item']
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"


def put_get_item_with_keyring(
    aws_kms_ecdh_keyring: IKeyring,
    ddb_table_name: str
):
    """
    Demonstrate put and get operations with a KMS ECDH keyring.

    :param aws_kms_ecdh_keyring: The KMS ECDH keyring to use
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
        "sensitive_data": CryptoAction.ENCRYPT_AND_SIGN
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
    # Note: To use the KMS RSA keyring, your table config must specify an algorithmSuite
    # that does not use asymmetric signing.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=aws_kms_ecdh_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
        # Specify algorithmSuite without asymmetric signing here
        # As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
        # ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
        algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # Create the EncryptedClient
    ddb_client = boto3.client('dynamodb')
    encrypted_ddb_client = EncryptedClient(
        client=ddb_client,
        encryption_config=tables_config
    )

    # Put an item into our table using the above client.
    # Before the item gets sent to DynamoDb, it will be encrypted
    # client-side, according to our configuration.
    item = {
        "partition_key": {"S": "awsKmsEcdhKeyringItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"}
    }

    put_response = encrypted_ddb_client.put_item(
        TableName=ddb_table_name,
        Item=item
    )

    # Demonstrate that PutItem succeeded
    assert put_response['ResponseMetadata']['HTTPStatusCode'] == 200

    # Get the item back from our table using the client.
    # The client will decrypt the item client-side using the RSA keyring
    # and return the original item.
    key_to_get = {
        "partition_key": {"S": "awsKmsEcdhKeyringItem"},
        "sort_key": {"N": "0"}
    }

    get_response = encrypted_ddb_client.get_item(
        TableName=ddb_table_name,
        Key=key_to_get
    )

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response['ResponseMetadata']['HTTPStatusCode'] == 200
    returned_item = get_response['Item']
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"


def load_public_key_bytes(ecc_public_key_filename: str) -> bytes:
    """
    Load public key bytes from a PEM file.

    :param ecc_public_key_filename: The filename containing the public key
    :return: The public key bytes
    """
    try:
        with open(ecc_public_key_filename, 'rb') as f:
            public_key_file_bytes = f.read()
            public_key = serialization.load_pem_public_key(public_key_file_bytes)
            return public_key.public_bytes(
                encoding=serialization.Encoding.DER,
                format=serialization.PublicFormat.SubjectPublicKeyInfo
            )
    except IOError as e:
        raise RuntimeError("IOError while reading public key from file") from e


def should_get_new_public_keys() -> bool:
    """
    Check if new public keys should be generated.

    :return: True if new keys should be generated, False otherwise
    """
    # Check if public keys already exist
    sender_public_key_file = pathlib.Path(EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME)
    recipient_public_key_file = pathlib.Path(EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME)

    if sender_public_key_file.exists() or recipient_public_key_file.exists():
        return False

    if not sender_public_key_file.exists() and recipient_public_key_file.exists():
        raise RuntimeError(
            f"Missing public key sender file at {EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME}"
        )

    if not recipient_public_key_file.exists() and sender_public_key_file.exists():
        raise RuntimeError(
            f"Missing public key recipient file at {EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME}"
        )

    return True


def write_public_key_pem_for_ecc_key(
    ecc_key_arn: str,
    ecc_public_key_filename: str
):
    """
    Write a public key PEM file for an ECC key.

    :param ecc_key_arn: The ARN of the KMS ECC key
    :param ecc_public_key_filename: The filename to write the public key to
    """
    # Safety check: Validate file is not present
    public_key_file = pathlib.Path(ecc_public_key_filename)
    if public_key_file.exists():
        raise RuntimeError(
            "writePublicKeyPemForEccKey will not overwrite existing PEM files"
        )

    # This code will call KMS to get the public key for the KMS ECC key.
    # You must have kms:GetPublicKey permissions on the key for this to succeed.
    # The public key will be written to the file EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
    # or EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME.
    kms_client = boto3.client('kms')
    response = kms_client.get_public_key(KeyId=ecc_key_arn)
    public_key_bytes = response['PublicKey']

    # Write the public key to a PEM file
    public_key = serialization.load_der_public_key(public_key_bytes)
    pem_data = public_key.public_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    with open(ecc_public_key_filename, 'wb') as f:
        f.write(pem_data)