# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from _dafny import Map, Seq
import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes import (
    AsSet_AsSet as DafnyAsSet,
    BeaconKeySource_multi,
    BeaconKeySource_single,
    BeaconStyle_asSet,
    BeaconStyle_partOnly,
    BeaconStyle_shared,
    BeaconStyle_sharedSet,
    BeaconVersion_BeaconVersion as DafnyBeaconVersion,
    CompoundBeacon_CompoundBeacon as DafnyCompoundBeacon,
    ConstructorPart_ConstructorPart as DafnyConstructorPart,
    Constructor_Constructor as DafnyConstructor,
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput as DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierInput,
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput as DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
    DynamoDbEncryptionConfig_DynamoDbEncryptionConfig as DafnyDynamoDbEncryptionConfig,
    DynamoDbTableEncryptionConfig_DynamoDbTableEncryptionConfig as DafnyDynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig_DynamoDbTablesEncryptionConfig as DafnyDynamoDbTablesEncryptionConfig,
    EncryptedDataKeyDescription_EncryptedDataKeyDescription as DafnyEncryptedDataKeyDescription,
    EncryptedPart_EncryptedPart as DafnyEncryptedPart,
    GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput as DafnyGetBranchKeyIdFromDdbKeyInput,
    GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput as DafnyGetBranchKeyIdFromDdbKeyOutput,
    GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput as DafnyGetEncryptedDataKeyDescriptionInput,
    GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput as DafnyGetEncryptedDataKeyDescriptionOutput,
    GetEncryptedDataKeyDescriptionUnion_header,
    GetEncryptedDataKeyDescriptionUnion_item,
    GetPrefix_GetPrefix as DafnyGetPrefix,
    GetSegment_GetSegment as DafnyGetSegment,
    GetSegments_GetSegments as DafnyGetSegments,
    GetSubstring_GetSubstring as DafnyGetSubstring,
    GetSuffix_GetSuffix as DafnyGetSuffix,
    Insert_Insert as DafnyInsert,
    LegacyOverride_LegacyOverride as DafnyLegacyOverride,
    LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT,
    LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT,
    LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT,
    Lower_Lower as DafnyLower,
    MultiKeyStore_MultiKeyStore as DafnyMultiKeyStore,
    PartOnly_PartOnly as DafnyPartOnly,
    PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ,
    PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ,
    PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ,
    SearchConfig_SearchConfig as DafnySearchConfig,
    SharedSet_SharedSet as DafnySharedSet,
    Shared_Shared as DafnyShared,
    SignedPart_SignedPart as DafnySignedPart,
    SingleKeyStore_SingleKeyStore as DafnySingleKeyStore,
    StandardBeacon_StandardBeacon as DafnyStandardBeacon,
    Upper_Upper as DafnyUpper,
    VirtualField_VirtualField as DafnyVirtualField,
    VirtualPart_VirtualPart as DafnyVirtualPart,
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
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny
from smithy_dafny_standard_library.internaldafny.generated.Wrappers import (
    Option_None,
    Option_Some,
)


def aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyInput(native_input):
    return DafnyGetBranchKeyIdFromDdbKeyInput(
        ddbKey=Map({Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(key.encode('utf-16-be'))]*2)])): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(value) for (key, value) in native_input.ddb_key.items() }),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyOutput(native_input):
    return DafnyGetBranchKeyIdFromDdbKeyOutput(
        branchKeyId=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.branch_key_id.encode('utf-16-be'))]*2)])),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(native_input):
    return DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierInput(
        ddbKeyBranchKeyIdSupplier=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbKeyBranchKeyIdSupplierReference(native_input.ddb_key_branch_key_id_supplier),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbKeyBranchKeyIdSupplierReference(native_input):
    if hasattr(native_input, '_impl'):
        return native_input._impl

    else:
        return native_input

def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionInput(native_input):
    return DafnyGetEncryptedDataKeyDescriptionInput(
        input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionUnion(native_input.input),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionUnion(native_input):
    if isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionUnionHeader):
        GetEncryptedDataKeyDescriptionUnion_union_value = GetEncryptedDataKeyDescriptionUnion_header(Seq(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionUnionItem):
        GetEncryptedDataKeyDescriptionUnion_union_value = GetEncryptedDataKeyDescriptionUnion_item(Map({Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(key.encode('utf-16-be'))]*2)])): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(value) for (key, value) in native_input.value.items() }))
    else:
        raise ValueError("No recognized union value in union type: " + str(native_input))

    return GetEncryptedDataKeyDescriptionUnion_union_value

def aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(native_input):
    return DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
        branchKeyIdSupplier=aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_BranchKeyIdSupplierReference(native_input.branch_key_id_supplier),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionOutput(native_input):
    return DafnyGetEncryptedDataKeyDescriptionOutput(
        EncryptedDataKeyDescriptionOutput=Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_EncryptedDataKeyDescription(list_element) for list_element in native_input.encrypted_data_key_description_output]),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_EncryptedDataKeyDescription(native_input):
    return DafnyEncryptedDataKeyDescription(
        keyProviderId=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.key_provider_id.encode('utf-16-be'))]*2)])),
        keyProviderInfo=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.key_provider_info.encode('utf-16-be'))]*2)])))) if (native_input.key_provider_info is not None) else (Option_None())),
        branchKeyId=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.branch_key_id.encode('utf-16-be'))]*2)])))) if (native_input.branch_key_id is not None) else (Option_None())),
        branchKeyVersion=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.branch_key_version.encode('utf-16-be'))]*2)])))) if (native_input.branch_key_version is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_AsSet(native_input):
    return DafnyAsSet(
    )

def aws_cryptography_dbencryptionsdk_dynamodb_AtomicPrimitivesReference(native_input):
    return native_input._config.dafnyImplInterface.impl

def aws_cryptography_dbencryptionsdk_dynamodb_MultiKeyStore(native_input):
    return DafnyMultiKeyStore(
        keyFieldName=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.key_field_name.encode('utf-16-be'))]*2)])),
        cacheTTL=native_input.cache_ttl,
        cache=((Option_Some(aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CacheType(native_input.cache))) if (native_input.cache is not None) else (Option_None())),
        partitionId=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.partition_id.encode('utf-16-be'))]*2)])))) if (native_input.partition_id is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_SingleKeyStore(native_input):
    return DafnySingleKeyStore(
        keyId=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.key_id.encode('utf-16-be'))]*2)])),
        cacheTTL=native_input.cache_ttl,
        cache=((Option_Some(aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CacheType(native_input.cache))) if (native_input.cache is not None) else (Option_None())),
        partitionId=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.partition_id.encode('utf-16-be'))]*2)])))) if (native_input.partition_id is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_BeaconKeySource(native_input):
    if isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconKeySourceSingle):
        BeaconKeySource_union_value = BeaconKeySource_single(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_SingleKeyStore(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconKeySourceMulti):
        BeaconKeySource_union_value = BeaconKeySource_multi(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_MultiKeyStore(native_input.value))
    else:
        raise ValueError("No recognized union value in union type: " + str(native_input))

    return BeaconKeySource_union_value

def aws_cryptography_dbencryptionsdk_dynamodb_PartOnly(native_input):
    return DafnyPartOnly(
    )

def aws_cryptography_dbencryptionsdk_dynamodb_Shared(native_input):
    return DafnyShared(
        other=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.other.encode('utf-16-be'))]*2)])),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_SharedSet(native_input):
    return DafnySharedSet(
        other=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.other.encode('utf-16-be'))]*2)])),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_BeaconStyle(native_input):
    if isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconStylePartOnly):
        BeaconStyle_union_value = BeaconStyle_partOnly(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_PartOnly(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconStyleShared):
        BeaconStyle_union_value = BeaconStyle_shared(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_Shared(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconStyleAsSet):
        BeaconStyle_union_value = BeaconStyle_asSet(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_AsSet(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.BeaconStyleSharedSet):
        BeaconStyle_union_value = BeaconStyle_sharedSet(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_SharedSet(native_input.value))
    else:
        raise ValueError("No recognized union value in union type: " + str(native_input))

    return BeaconStyle_union_value

def aws_cryptography_dbencryptionsdk_dynamodb_ConstructorPart(native_input):
    return DafnyConstructorPart(
        name=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.name.encode('utf-16-be'))]*2)])),
        required=native_input.required,
    )

def aws_cryptography_dbencryptionsdk_dynamodb_Constructor(native_input):
    return DafnyConstructor(
        parts=Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_ConstructorPart(list_element) for list_element in native_input.parts]),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_EncryptedPart(native_input):
    return DafnyEncryptedPart(
        name=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.name.encode('utf-16-be'))]*2)])),
        prefix=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.prefix.encode('utf-16-be'))]*2)])),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_SignedPart(native_input):
    return DafnySignedPart(
        name=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.name.encode('utf-16-be'))]*2)])),
        prefix=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.prefix.encode('utf-16-be'))]*2)])),
        loc=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.loc.encode('utf-16-be'))]*2)])))) if (native_input.loc is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_CompoundBeacon(native_input):
    return DafnyCompoundBeacon(
        name=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.name.encode('utf-16-be'))]*2)])),
        split=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.split.encode('utf-16-be'))]*2)])),
        encrypted=((Option_Some(Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_EncryptedPart(list_element) for list_element in native_input.encrypted]))) if (native_input.encrypted is not None) else (Option_None())),
        signed=((Option_Some(Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_SignedPart(list_element) for list_element in native_input.signed]))) if (native_input.signed is not None) else (Option_None())),
        constructors=((Option_Some(Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_Constructor(list_element) for list_element in native_input.constructors]))) if (native_input.constructors is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_KeyStoreReference(native_input):
    return native_input._config.dafnyImplInterface.impl

def aws_cryptography_dbencryptionsdk_dynamodb_StandardBeacon(native_input):
    return DafnyStandardBeacon(
        name=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.name.encode('utf-16-be'))]*2)])),
        length=native_input.length,
        loc=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.loc.encode('utf-16-be'))]*2)])))) if (native_input.loc is not None) else (Option_None())),
        style=((Option_Some(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_BeaconStyle(native_input.style))) if (native_input.style is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_Insert(native_input):
    return DafnyInsert(
        literal=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.literal.encode('utf-16-be'))]*2)])),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_Lower(native_input):
    return DafnyLower(
    )

def aws_cryptography_dbencryptionsdk_dynamodb_GetPrefix(native_input):
    return DafnyGetPrefix(
        length=native_input.length,
    )

def aws_cryptography_dbencryptionsdk_dynamodb_GetSegment(native_input):
    return DafnyGetSegment(
        split=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.split.encode('utf-16-be'))]*2)])),
        index=native_input.index,
    )

def aws_cryptography_dbencryptionsdk_dynamodb_GetSegments(native_input):
    return DafnyGetSegments(
        split=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.split.encode('utf-16-be'))]*2)])),
        low=native_input.low,
        high=native_input.high,
    )

def aws_cryptography_dbencryptionsdk_dynamodb_GetSubstring(native_input):
    return DafnyGetSubstring(
        low=native_input.low,
        high=native_input.high,
    )

def aws_cryptography_dbencryptionsdk_dynamodb_GetSuffix(native_input):
    return DafnyGetSuffix(
        length=native_input.length,
    )

def aws_cryptography_dbencryptionsdk_dynamodb_Upper(native_input):
    return DafnyUpper(
    )

def aws_cryptography_dbencryptionsdk_dynamodb_VirtualTransform(native_input):
    if isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformUpper):
        VirtualTransform_union_value = VirtualTransform_upper(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_Upper(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformLower):
        VirtualTransform_union_value = VirtualTransform_lower(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_Lower(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformInsert):
        VirtualTransform_union_value = VirtualTransform_insert(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_Insert(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformPrefix):
        VirtualTransform_union_value = VirtualTransform_prefix(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetPrefix(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformSuffix):
        VirtualTransform_union_value = VirtualTransform_suffix(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetSuffix(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformSubstring):
        VirtualTransform_union_value = VirtualTransform_substring(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetSubstring(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformSegment):
        VirtualTransform_union_value = VirtualTransform_segment(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetSegment(native_input.value))
    elif isinstance(native_input, aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.VirtualTransformSegments):
        VirtualTransform_union_value = VirtualTransform_segments(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetSegments(native_input.value))
    else:
        raise ValueError("No recognized union value in union type: " + str(native_input))

    return VirtualTransform_union_value

def aws_cryptography_dbencryptionsdk_dynamodb_VirtualPart(native_input):
    return DafnyVirtualPart(
        loc=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.loc.encode('utf-16-be'))]*2)])),
        trans=((Option_Some(Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_VirtualTransform(list_element) for list_element in native_input.trans]))) if (native_input.trans is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_VirtualField(native_input):
    return DafnyVirtualField(
        name=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.name.encode('utf-16-be'))]*2)])),
        parts=Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_VirtualPart(list_element) for list_element in native_input.parts]),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_BeaconVersion(native_input):
    return DafnyBeaconVersion(
        version=native_input.version,
        keyStore=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_KeyStoreReference(native_input.key_store),
        keySource=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_BeaconKeySource(native_input.key_source),
        standardBeacons=Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_StandardBeacon(list_element) for list_element in native_input.standard_beacons]),
        compoundBeacons=((Option_Some(Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_CompoundBeacon(list_element) for list_element in native_input.compound_beacons]))) if (native_input.compound_beacons is not None) else (Option_None())),
        virtualFields=((Option_Some(Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_VirtualField(list_element) for list_element in native_input.virtual_fields]))) if (native_input.virtual_fields is not None) else (Option_None())),
        encryptedParts=((Option_Some(Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_EncryptedPart(list_element) for list_element in native_input.encrypted_parts]))) if (native_input.encrypted_parts is not None) else (Option_None())),
        signedParts=((Option_Some(Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_SignedPart(list_element) for list_element in native_input.signed_parts]))) if (native_input.signed_parts is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbEncryptionConfig(native_input):
    return DafnyDynamoDbEncryptionConfig(
    )

def aws_cryptography_dbencryptionsdk_dynamodb_LegacyDynamoDbEncryptorReference(native_input):
    if hasattr(native_input, '_impl'):
        return native_input._impl

    else:
        return native_input

def aws_cryptography_dbencryptionsdk_dynamodb_LegacyPolicy(native_input):
    if native_input == 'FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT':
        return LegacyPolicy_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT()

    elif native_input == 'FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT':
        return LegacyPolicy_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT()

    elif native_input == 'FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT':
        return LegacyPolicy_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT()

    else:
        raise ValueError(f'No recognized enum value in enum type: {native_input=}')

def aws_cryptography_dbencryptionsdk_dynamodb_LegacyOverride(native_input):
    return DafnyLegacyOverride(
        policy=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_LegacyPolicy(native_input.policy),
        encryptor=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_LegacyDynamoDbEncryptorReference(native_input.encryptor),
        attributeActionsOnEncrypt=Map({Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(key.encode('utf-16-be'))]*2)])): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(value) for (key, value) in native_input.attribute_actions_on_encrypt.items() }),
        defaultAttributeFlag=((Option_Some(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(native_input.default_attribute_flag))) if (native_input.default_attribute_flag is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_PlaintextOverride(native_input):
    if native_input == 'FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ':
        return PlaintextOverride_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ()

    elif native_input == 'FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ':
        return PlaintextOverride_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ()

    elif native_input == 'FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ':
        return PlaintextOverride_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ()

    else:
        raise ValueError(f'No recognized enum value in enum type: {native_input=}')

def aws_cryptography_dbencryptionsdk_dynamodb_SearchConfig(native_input):
    return DafnySearchConfig(
        versions=Seq([aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_BeaconVersion(list_element) for list_element in native_input.versions]),
        writeVersion=native_input.write_version,
    )

def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTableEncryptionConfig(native_input):
    return DafnyDynamoDbTableEncryptionConfig(
        logicalTableName=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.logical_table_name.encode('utf-16-be'))]*2)])),
        partitionKeyName=Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.partition_key_name.encode('utf-16-be'))]*2)])),
        sortKeyName=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.sort_key_name.encode('utf-16-be'))]*2)])))) if (native_input.sort_key_name is not None) else (Option_None())),
        search=((Option_Some(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_SearchConfig(native_input.search))) if (native_input.search is not None) else (Option_None())),
        attributeActionsOnEncrypt=Map({Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(key.encode('utf-16-be'))]*2)])): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(value) for (key, value) in native_input.attribute_actions_on_encrypt.items() }),
        allowedUnsignedAttributes=((Option_Some(Seq([Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(list_element.encode('utf-16-be'))]*2)])) for list_element in native_input.allowed_unsigned_attributes]))) if (native_input.allowed_unsigned_attributes is not None) else (Option_None())),
        allowedUnsignedAttributePrefix=((Option_Some(Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(native_input.allowed_unsigned_attribute_prefix.encode('utf-16-be'))]*2)])))) if (native_input.allowed_unsigned_attribute_prefix is not None) else (Option_None())),
        algorithmSuiteId=((Option_Some(aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_DBEAlgorithmSuiteId(native_input.algorithm_suite_id))) if (native_input.algorithm_suite_id is not None) else (Option_None())),
        keyring=((Option_Some(aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_KeyringReference(native_input.keyring))) if ((native_input.keyring is not None) and (aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_KeyringReference(native_input.keyring) is not None)) else (Option_None())),
        cmm=((Option_Some(aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(native_input.cmm))) if ((native_input.cmm is not None) and (aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(native_input.cmm) is not None)) else (Option_None())),
        legacyOverride=((Option_Some(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_LegacyOverride(native_input.legacy_override))) if (native_input.legacy_override is not None) else (Option_None())),
        plaintextOverride=((Option_Some(aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_PlaintextOverride(native_input.plaintext_override))) if (native_input.plaintext_override is not None) else (Option_None())),
    )

def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig(native_input):
    return DafnyDynamoDbTablesEncryptionConfig(
        tableEncryptionConfigs=Map({Seq(''.join([chr(int.from_bytes(pair, 'big')) for pair in zip(*[iter(key.encode('utf-16-be'))]*2)])): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTableEncryptionConfig(value) for (key, value) in native_input.table_encryption_configs.items() }),
    )
