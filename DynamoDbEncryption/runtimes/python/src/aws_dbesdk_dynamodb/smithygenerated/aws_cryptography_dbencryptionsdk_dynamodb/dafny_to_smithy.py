# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes import (
    BeaconKeySource_multi,
    BeaconKeySource_single,
    BeaconStyle_asSet,
    BeaconStyle_partOnly,
    BeaconStyle_shared,
    BeaconStyle_sharedSet,
    GetEncryptedDataKeyDescriptionUnion_header,
    GetEncryptedDataKeyDescriptionUnion_item,
    LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT,
    LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT,
    LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT,
    PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ,
    PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ,
    PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ,
    VirtualTransform_insert,
    VirtualTransform_lower,
    VirtualTransform_prefix,
    VirtualTransform_segment,
    VirtualTransform_segments,
    VirtualTransform_substring,
    VirtualTransform_suffix,
    VirtualTransform_upper,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy


def aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyInput(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetBranchKeyIdFromDdbKeyInput(
        ddb_key={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ddbKey.items
        },
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyOutput(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetBranchKeyIdFromDdbKeyOutput(
        branch_key_id=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.branchKeyId).decode("utf-16-be"),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbKeyBranchKeyIdSupplierReference(dafny_input):
    if hasattr(dafny_input, "_native_impl"):
        return dafny_input._native_impl

    else:
        from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references import (
            DynamoDbKeyBranchKeyIdSupplier,
        )

        return DynamoDbKeyBranchKeyIdSupplier(_impl=dafny_input)


def aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
        ddb_key_branch_key_id_supplier=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbKeyBranchKeyIdSupplierReference(
                    dafny_input.ddbKeyBranchKeyIdSupplier
                )
            )
            if (dafny_input.ddbKeyBranchKeyIdSupplier is not None)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionUnion(dafny_input):
    # Convert GetEncryptedDataKeyDescriptionUnion
    if isinstance(dafny_input, GetEncryptedDataKeyDescriptionUnion_header):
        GetEncryptedDataKeyDescriptionUnion_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionUnionHeader(
            bytes(dafny_input.header)
        )
    elif isinstance(dafny_input, GetEncryptedDataKeyDescriptionUnion_item):
        GetEncryptedDataKeyDescriptionUnion_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionUnionItem(
            {
                b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                    "utf-16-be"
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in dafny_input.item.items
            }
        )
    else:
        raise ValueError("No recognized union value in union type: " + str(dafny_input))

    return GetEncryptedDataKeyDescriptionUnion_union_value


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionInput(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionInput(
        input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionUnion(
            dafny_input.input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
        branch_key_id_supplier=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_BranchKeyIdSupplierReference(
                    dafny_input.branchKeyIdSupplier
                )
            )
            if (dafny_input.branchKeyIdSupplier is not None)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_EncryptedDataKeyDescription(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.EncryptedDataKeyDescription(
        key_provider_id=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.keyProviderId).decode("utf-16-be"),
        key_provider_info=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.keyProviderInfo.value).decode("utf-16-be"))
            if (dafny_input.keyProviderInfo.is_Some)
            else None
        ),
        branch_key_id=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.branchKeyId.value).decode("utf-16-be"))
            if (dafny_input.branchKeyId.is_Some)
            else None
        ),
        branch_key_version=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.branchKeyVersion.value).decode("utf-16-be"))
            if (dafny_input.branchKeyVersion.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionOutput(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionOutput(
        encrypted_data_key_description_output=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_EncryptedDataKeyDescription(
                list_element
            )
            for list_element in dafny_input.EncryptedDataKeyDescriptionOutput
        ],
    )


def aws_cryptography_dbencryptionsdk_dynamodb_AsSet(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.AsSet()


def aws_cryptography_dbencryptionsdk_dynamodb_AtomicPrimitivesReference(dafny_input):
    from aws_cryptography_primitives.smithygenerated.aws_cryptography_primitives.client import (
        AwsCryptographicPrimitives,
    )

    return AwsCryptographicPrimitives(config=None, dafny_client=dafny_input)


def aws_cryptography_dbencryptionsdk_dynamodb_MultiKeyStore(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.MultiKeyStore(
        key_field_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.keyFieldName).decode("utf-16-be"),
        cache_ttl=dafny_input.cacheTTL,
        cache=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_CacheType(
                    dafny_input.cache.value
                )
            )
            if (dafny_input.cache.is_Some)
            else None
        ),
        partition_id=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.partitionId.value).decode("utf-16-be"))
            if (dafny_input.partitionId.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_SingleKeyStore(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.SingleKeyStore(
        key_id=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.keyId).decode("utf-16-be"),
        cache_ttl=dafny_input.cacheTTL,
        cache=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_CacheType(
                    dafny_input.cache.value
                )
            )
            if (dafny_input.cache.is_Some)
            else None
        ),
        partition_id=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.partitionId.value).decode("utf-16-be"))
            if (dafny_input.partitionId.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_BeaconKeySource(dafny_input):
    # Convert BeaconKeySource
    if isinstance(dafny_input, BeaconKeySource_single):
        BeaconKeySource_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconKeySourceSingle(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_SingleKeyStore(
                dafny_input.single
            )
        )
    elif isinstance(dafny_input, BeaconKeySource_multi):
        BeaconKeySource_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconKeySourceMulti(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_MultiKeyStore(
                dafny_input.multi
            )
        )
    else:
        raise ValueError("No recognized union value in union type: " + str(dafny_input))

    return BeaconKeySource_union_value


def aws_cryptography_dbencryptionsdk_dynamodb_PartOnly(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.PartOnly()


def aws_cryptography_dbencryptionsdk_dynamodb_Shared(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.Shared(
        other=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.other).decode("utf-16-be"),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_SharedSet(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.SharedSet(
        other=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.other).decode("utf-16-be"),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_BeaconStyle(dafny_input):
    # Convert BeaconStyle
    if isinstance(dafny_input, BeaconStyle_partOnly):
        BeaconStyle_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconStylePartOnly(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_PartOnly(
                dafny_input.partOnly
            )
        )
    elif isinstance(dafny_input, BeaconStyle_shared):
        BeaconStyle_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconStyleShared(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_Shared(
                dafny_input.shared
            )
        )
    elif isinstance(dafny_input, BeaconStyle_asSet):
        BeaconStyle_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconStyleAsSet(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_AsSet(
                dafny_input.asSet
            )
        )
    elif isinstance(dafny_input, BeaconStyle_sharedSet):
        BeaconStyle_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconStyleSharedSet(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_SharedSet(
                dafny_input.sharedSet
            )
        )
    else:
        raise ValueError("No recognized union value in union type: " + str(dafny_input))

    return BeaconStyle_union_value


def aws_cryptography_dbencryptionsdk_dynamodb_ConstructorPart(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.ConstructorPart(
        name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.name).decode("utf-16-be"),
        required=dafny_input.required,
    )


def aws_cryptography_dbencryptionsdk_dynamodb_Constructor(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.Constructor(
        parts=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_ConstructorPart(
                list_element
            )
            for list_element in dafny_input.parts
        ],
    )


def aws_cryptography_dbencryptionsdk_dynamodb_EncryptedPart(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.EncryptedPart(
        name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.name).decode("utf-16-be"),
        prefix=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.prefix).decode("utf-16-be"),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_SignedPart(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.SignedPart(
        name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.name).decode("utf-16-be"),
        prefix=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.prefix).decode("utf-16-be"),
        loc=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.loc.value).decode("utf-16-be"))
            if (dafny_input.loc.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_CompoundBeacon(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.CompoundBeacon(
        name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.name).decode("utf-16-be"),
        split=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.split).decode("utf-16-be"),
        encrypted=(
            (
                [
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_EncryptedPart(
                        list_element
                    )
                    for list_element in dafny_input.encrypted.value
                ]
            )
            if (dafny_input.encrypted.is_Some)
            else None
        ),
        signed=(
            (
                [
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_SignedPart(
                        list_element
                    )
                    for list_element in dafny_input.signed.value
                ]
            )
            if (dafny_input.signed.is_Some)
            else None
        ),
        constructors=(
            (
                [
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_Constructor(
                        list_element
                    )
                    for list_element in dafny_input.constructors.value
                ]
            )
            if (dafny_input.constructors.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_KeyStoreReference(dafny_input):
    from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_keystore.client import KeyStore

    return KeyStore(config=None, dafny_client=dafny_input)


def aws_cryptography_dbencryptionsdk_dynamodb_StandardBeacon(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.StandardBeacon(
        name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.name).decode("utf-16-be"),
        length=dafny_input.length,
        loc=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.loc.value).decode("utf-16-be"))
            if (dafny_input.loc.is_Some)
            else None
        ),
        style=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_BeaconStyle(
                    dafny_input.style.value
                )
            )
            if (dafny_input.style.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_Insert(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.Insert(
        literal=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.literal).decode("utf-16-be"),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_Lower(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.Lower()


def aws_cryptography_dbencryptionsdk_dynamodb_GetPrefix(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetPrefix(
        length=dafny_input.length,
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetSegment(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetSegment(
        split=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.split).decode("utf-16-be"),
        index=dafny_input.index,
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetSegments(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetSegments(
        split=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.split).decode("utf-16-be"),
        low=dafny_input.low,
        high=dafny_input.high,
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetSubstring(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetSubstring(
        low=dafny_input.low,
        high=dafny_input.high,
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetSuffix(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetSuffix(
        length=dafny_input.length,
    )


def aws_cryptography_dbencryptionsdk_dynamodb_Upper(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.Upper()


def aws_cryptography_dbencryptionsdk_dynamodb_VirtualTransform(dafny_input):
    # Convert VirtualTransform
    if isinstance(dafny_input, VirtualTransform_upper):
        VirtualTransform_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformUpper(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_Upper(
                dafny_input.upper
            )
        )
    elif isinstance(dafny_input, VirtualTransform_lower):
        VirtualTransform_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformLower(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_Lower(
                dafny_input.lower
            )
        )
    elif isinstance(dafny_input, VirtualTransform_insert):
        VirtualTransform_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformInsert(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_Insert(
                dafny_input.insert
            )
        )
    elif isinstance(dafny_input, VirtualTransform_prefix):
        VirtualTransform_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformPrefix(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetPrefix(
                dafny_input.prefix
            )
        )
    elif isinstance(dafny_input, VirtualTransform_suffix):
        VirtualTransform_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformSuffix(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetSuffix(
                dafny_input.suffix
            )
        )
    elif isinstance(dafny_input, VirtualTransform_substring):
        VirtualTransform_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformSubstring(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetSubstring(
                dafny_input.substring
            )
        )
    elif isinstance(dafny_input, VirtualTransform_segment):
        VirtualTransform_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformSegment(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetSegment(
                dafny_input.segment
            )
        )
    elif isinstance(dafny_input, VirtualTransform_segments):
        VirtualTransform_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformSegments(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetSegments(
                dafny_input.segments
            )
        )
    else:
        raise ValueError("No recognized union value in union type: " + str(dafny_input))

    return VirtualTransform_union_value


def aws_cryptography_dbencryptionsdk_dynamodb_VirtualPart(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualPart(
        loc=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.loc).decode("utf-16-be"),
        trans=(
            (
                [
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_VirtualTransform(
                        list_element
                    )
                    for list_element in dafny_input.trans.value
                ]
            )
            if (dafny_input.trans.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_VirtualField(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualField(
        name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.name).decode("utf-16-be"),
        parts=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_VirtualPart(
                list_element
            )
            for list_element in dafny_input.parts
        ],
    )


def aws_cryptography_dbencryptionsdk_dynamodb_BeaconVersion(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconVersion(
        version=dafny_input.version,
        key_store=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_KeyStoreReference(
                    dafny_input.keyStore
                )
            )
            if (dafny_input.keyStore is not None)
            else None
        ),
        key_source=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_BeaconKeySource(
            dafny_input.keySource
        ),
        standard_beacons=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_StandardBeacon(
                list_element
            )
            for list_element in dafny_input.standardBeacons
        ],
        compound_beacons=(
            (
                [
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_CompoundBeacon(
                        list_element
                    )
                    for list_element in dafny_input.compoundBeacons.value
                ]
            )
            if (dafny_input.compoundBeacons.is_Some)
            else None
        ),
        virtual_fields=(
            (
                [
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_VirtualField(
                        list_element
                    )
                    for list_element in dafny_input.virtualFields.value
                ]
            )
            if (dafny_input.virtualFields.is_Some)
            else None
        ),
        encrypted_parts=(
            (
                [
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_EncryptedPart(
                        list_element
                    )
                    for list_element in dafny_input.encryptedParts.value
                ]
            )
            if (dafny_input.encryptedParts.is_Some)
            else None
        ),
        signed_parts=(
            (
                [
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_SignedPart(
                        list_element
                    )
                    for list_element in dafny_input.signedParts.value
                ]
            )
            if (dafny_input.signedParts.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbEncryptionConfig(dafny_input):
    # Deferred import of .config to avoid circular dependency
    import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.config

    return (
        aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.config.DynamoDbEncryptionConfig()
    )


def aws_cryptography_dbencryptionsdk_dynamodb_LegacyDynamoDbEncryptorReference(dafny_input):
    if hasattr(dafny_input, "_native_impl"):
        return dafny_input._native_impl

    else:
        from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references import (
            LegacyDynamoDbEncryptor,
        )

        return LegacyDynamoDbEncryptor(_impl=dafny_input)


def aws_cryptography_dbencryptionsdk_dynamodb_LegacyPolicy(dafny_input):
    if isinstance(dafny_input, LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT):
        return "FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT"

    elif isinstance(dafny_input, LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT):
        return "FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT"

    elif isinstance(dafny_input, LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT):
        return "FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT"

    else:
        raise ValueError(f"No recognized enum value in enum type: {dafny_input=}")


def aws_cryptography_dbencryptionsdk_dynamodb_LegacyOverride(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.LegacyOverride(
        policy=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_LegacyPolicy(
            dafny_input.policy
        ),
        encryptor=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_LegacyDynamoDbEncryptorReference(
                    dafny_input.encryptor
                )
            )
            if (dafny_input.encryptor is not None)
            else None
        ),
        attribute_actions_on_encrypt={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                value
            )
            for (key, value) in dafny_input.attributeActionsOnEncrypt.items
        },
        default_attribute_flag=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                    dafny_input.defaultAttributeFlag.value
                )
            )
            if (dafny_input.defaultAttributeFlag.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_PlaintextOverride(dafny_input):
    if isinstance(dafny_input, PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ):
        return "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ"

    elif isinstance(dafny_input, PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ):
        return "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ"

    elif isinstance(dafny_input, PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ):
        return "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ"

    else:
        raise ValueError(f"No recognized enum value in enum type: {dafny_input=}")


def aws_cryptography_dbencryptionsdk_dynamodb_SearchConfig(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.SearchConfig(
        versions=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_BeaconVersion(
                list_element
            )
            for list_element in dafny_input.versions
        ],
        write_version=dafny_input.writeVersion,
    )


def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTableEncryptionConfig(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.DynamoDbTableEncryptionConfig(
        logical_table_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.logicalTableName).decode(
            "utf-16-be"
        ),
        partition_key_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.partitionKeyName).decode(
            "utf-16-be"
        ),
        sort_key_name=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.sortKeyName.value).decode("utf-16-be"))
            if (dafny_input.sortKeyName.is_Some)
            else None
        ),
        search=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_SearchConfig(
                    dafny_input.search.value
                )
            )
            if (dafny_input.search.is_Some)
            else None
        ),
        attribute_actions_on_encrypt={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                value
            )
            for (key, value) in dafny_input.attributeActionsOnEncrypt.items
        },
        allowed_unsigned_attributes=(
            (
                [
                    b"".join(ord(c).to_bytes(2, "big") for c in list_element).decode("utf-16-be")
                    for list_element in dafny_input.allowedUnsignedAttributes.value
                ]
            )
            if (dafny_input.allowedUnsignedAttributes.is_Some)
            else None
        ),
        allowed_unsigned_attribute_prefix=(
            (
                b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.allowedUnsignedAttributePrefix.value).decode(
                    "utf-16-be"
                )
            )
            if (dafny_input.allowedUnsignedAttributePrefix.is_Some)
            else None
        ),
        algorithm_suite_id=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_DBEAlgorithmSuiteId(
                    dafny_input.algorithmSuiteId.value
                )
            )
            if (dafny_input.algorithmSuiteId.is_Some)
            else None
        ),
        keyring=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_KeyringReference(
                    dafny_input.keyring.UnwrapOr(None)
                )
            )
            if (dafny_input.keyring.UnwrapOr(None) is not None)
            else None
        ),
        cmm=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
                    dafny_input.cmm.UnwrapOr(None)
                )
            )
            if (dafny_input.cmm.UnwrapOr(None) is not None)
            else None
        ),
        legacy_override=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_LegacyOverride(
                    dafny_input.legacyOverride.value
                )
            )
            if (dafny_input.legacyOverride.is_Some)
            else None
        ),
        plaintext_override=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_PlaintextOverride(
                    dafny_input.plaintextOverride.value
                )
            )
            if (dafny_input.plaintextOverride.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.DynamoDbTablesEncryptionConfig(
        table_encryption_configs={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTableEncryptionConfig(
                value
            )
            for (key, value) in dafny_input.tableEncryptionConfigs.items
        },
    )
