// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_Opaque;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error_OpaqueWithText;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.AsSet;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconStyle;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedDataKeyDescription;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBranchKeyIdFromDdbKeyOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBucketNumberInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetBucketNumberOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionUnion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetNumberOfQueriesInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetNumberOfQueriesOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPrefix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegment;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegments;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSubstring;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSuffix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Insert;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Lower;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.MultiKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.OpaqueWithTextError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PartOnly;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Shared;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SharedSet;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Upper;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

public class ToNative {

  public static OpaqueError Error(Error_Opaque dafnyValue) {
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue.dtor_obj());
    return nativeBuilder.build();
  }

  public static OpaqueWithTextError Error(Error_OpaqueWithText dafnyValue) {
    OpaqueWithTextError.Builder nativeBuilder = OpaqueWithTextError.builder();
    nativeBuilder.obj(dafnyValue.dtor_obj());
    nativeBuilder.objMessage(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_objMessage()
      )
    );
    return nativeBuilder.build();
  }

  public static CollectionOfErrors Error(Error_CollectionOfErrors dafnyValue) {
    CollectionOfErrors.Builder nativeBuilder = CollectionOfErrors.builder();
    nativeBuilder.list(
      software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue.dtor_list(),
        ToNative::Error
      )
    );
    nativeBuilder.message(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_message()
      )
    );
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionException Error(
    Error_DynamoDbEncryptionException dafnyValue
  ) {
    DynamoDbEncryptionException.Builder nativeBuilder =
      DynamoDbEncryptionException.builder();
    nativeBuilder.message(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_message()
      )
    );
    return nativeBuilder.build();
  }

  public static RuntimeException Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbEncryptionException()) {
      return ToNative.Error((Error_DynamoDbEncryptionException) dafnyValue);
    }
    if (dafnyValue.is_Opaque()) {
      return ToNative.Error((Error_Opaque) dafnyValue);
    }
    if (dafnyValue.is_OpaqueWithText()) {
      return ToNative.Error((Error_OpaqueWithText) dafnyValue);
    }
    if (dafnyValue.is_CollectionOfErrors()) {
      return ToNative.Error((Error_CollectionOfErrors) dafnyValue);
    }
    if (dafnyValue.is_AwsCryptographyPrimitives()) {
      return software.amazon.cryptography.primitives.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyPrimitives()
      );
    }
    if (dafnyValue.is_ComAmazonawsDynamodb()) {
      return software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.Error(
        dafnyValue.dtor_ComAmazonawsDynamodb()
      );
    }
    if (dafnyValue.is_AwsCryptographyMaterialProviders()) {
      return software.amazon.cryptography.materialproviders.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyMaterialProviders()
      );
    }
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkStructuredEncryption()) {
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption()
      );
    }
    if (dafnyValue.is_AwsCryptographyKeyStore()) {
      return software.amazon.cryptography.keystore.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyKeyStore()
      );
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static AsSet AsSet(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet dafnyValue
  ) {
    AsSet.Builder nativeBuilder = AsSet.builder();
    return nativeBuilder.build();
  }

  public static BeaconVersion BeaconVersion(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion dafnyValue
  ) {
    BeaconVersion.Builder nativeBuilder = BeaconVersion.builder();
    nativeBuilder.version((dafnyValue.dtor_version()));
    nativeBuilder.keyStore(
      software.amazon.cryptography.keystore.ToNative.KeyStore(
        dafnyValue.dtor_keyStore()
      )
    );
    nativeBuilder.keySource(
      ToNative.BeaconKeySource(dafnyValue.dtor_keySource())
    );
    nativeBuilder.standardBeacons(
      ToNative.StandardBeaconList(dafnyValue.dtor_standardBeacons())
    );
    if (dafnyValue.dtor_compoundBeacons().is_Some()) {
      nativeBuilder.compoundBeacons(
        ToNative.CompoundBeaconList(
          dafnyValue.dtor_compoundBeacons().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_virtualFields().is_Some()) {
      nativeBuilder.virtualFields(
        ToNative.VirtualFieldList(dafnyValue.dtor_virtualFields().dtor_value())
      );
    }
    if (dafnyValue.dtor_encryptedParts().is_Some()) {
      nativeBuilder.encryptedParts(
        ToNative.EncryptedPartsList(
          dafnyValue.dtor_encryptedParts().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_signedParts().is_Some()) {
      nativeBuilder.signedParts(
        ToNative.SignedPartsList(dafnyValue.dtor_signedParts().dtor_value())
      );
    }
    if (dafnyValue.dtor_maximumNumberOfBuckets().is_Some()) {
      nativeBuilder.maximumNumberOfBuckets(
        (dafnyValue.dtor_maximumNumberOfBuckets().dtor_value())
      );
    }
    if (dafnyValue.dtor_defaultNumberOfBuckets().is_Some()) {
      nativeBuilder.defaultNumberOfBuckets(
        (dafnyValue.dtor_defaultNumberOfBuckets().dtor_value())
      );
    }
    if (dafnyValue.dtor_bucketSelector().is_Some()) {
      nativeBuilder.bucketSelector(
        ToNative.BucketSelector(dafnyValue.dtor_bucketSelector().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static CompoundBeacon CompoundBeacon(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon dafnyValue
  ) {
    CompoundBeacon.Builder nativeBuilder = CompoundBeacon.builder();
    nativeBuilder.name(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_name()
      )
    );
    nativeBuilder.split(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_split()
      )
    );
    if (dafnyValue.dtor_encrypted().is_Some()) {
      nativeBuilder.encrypted(
        ToNative.EncryptedPartsList(dafnyValue.dtor_encrypted().dtor_value())
      );
    }
    if (dafnyValue.dtor_signed().is_Some()) {
      nativeBuilder.signed(
        ToNative.SignedPartsList(dafnyValue.dtor_signed().dtor_value())
      );
    }
    if (dafnyValue.dtor_constructors().is_Some()) {
      nativeBuilder.constructors(
        ToNative.ConstructorList(dafnyValue.dtor_constructors().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static Constructor Constructor(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor dafnyValue
  ) {
    Constructor.Builder nativeBuilder = Constructor.builder();
    nativeBuilder.parts(ToNative.ConstructorPartList(dafnyValue.dtor_parts()));
    return nativeBuilder.build();
  }

  public static ConstructorPart ConstructorPart(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart dafnyValue
  ) {
    ConstructorPart.Builder nativeBuilder = ConstructorPart.builder();
    nativeBuilder.name(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_name()
      )
    );
    nativeBuilder.required((dafnyValue.dtor_required()));
    return nativeBuilder.build();
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyValue
  ) {
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput.Builder nativeBuilder =
      CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder();
    nativeBuilder.ddbKeyBranchKeyIdSupplier(
      ToNative.DynamoDbKeyBranchKeyIdSupplier(
        dafnyValue.dtor_ddbKeyBranchKeyIdSupplier()
      )
    );
    return nativeBuilder.build();
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput dafnyValue
  ) {
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.Builder nativeBuilder =
      CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.builder();
    nativeBuilder.branchKeyIdSupplier(
      software.amazon.cryptography.materialproviders.ToNative.BranchKeyIdSupplier(
        dafnyValue.dtor_branchKeyIdSupplier()
      )
    );
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionConfig DynamoDbEncryptionConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbEncryptionConfig dafnyValue
  ) {
    DynamoDbEncryptionConfig.Builder nativeBuilder =
      DynamoDbEncryptionConfig.builder();
    return nativeBuilder.build();
  }

  public static DynamoDbTableEncryptionConfig DynamoDbTableEncryptionConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig dafnyValue
  ) {
    DynamoDbTableEncryptionConfig.Builder nativeBuilder =
      DynamoDbTableEncryptionConfig.builder();
    nativeBuilder.logicalTableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_logicalTableName()
      )
    );
    nativeBuilder.partitionKeyName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_partitionKeyName()
      )
    );
    if (dafnyValue.dtor_sortKeyName().is_Some()) {
      nativeBuilder.sortKeyName(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_sortKeyName().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_search().is_Some()) {
      nativeBuilder.search(
        ToNative.SearchConfig(dafnyValue.dtor_search().dtor_value())
      );
    }
    nativeBuilder.attributeActionsOnEncrypt(
      ToNative.AttributeActions(dafnyValue.dtor_attributeActionsOnEncrypt())
    );
    if (dafnyValue.dtor_allowedUnsignedAttributes().is_Some()) {
      nativeBuilder.allowedUnsignedAttributes(
        software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeNameList(
          dafnyValue.dtor_allowedUnsignedAttributes().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_allowedUnsignedAttributePrefix().is_Some()) {
      nativeBuilder.allowedUnsignedAttributePrefix(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_allowedUnsignedAttributePrefix().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(
        software.amazon.cryptography.materialproviders.ToNative.DBEAlgorithmSuiteId(
          dafnyValue.dtor_algorithmSuiteId().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_keyring().is_Some()) {
      nativeBuilder.keyring(
        software.amazon.cryptography.materialproviders.ToNative.Keyring(
          dafnyValue.dtor_keyring().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_cmm().is_Some()) {
      nativeBuilder.cmm(
        software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
          dafnyValue.dtor_cmm().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_legacyOverride().is_Some()) {
      nativeBuilder.legacyOverride(
        ToNative.LegacyOverride(dafnyValue.dtor_legacyOverride().dtor_value())
      );
    }
    if (dafnyValue.dtor_plaintextOverride().is_Some()) {
      nativeBuilder.plaintextOverride(
        ToNative.PlaintextOverride(
          dafnyValue.dtor_plaintextOverride().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static DynamoDbTablesEncryptionConfig DynamoDbTablesEncryptionConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig dafnyValue
  ) {
    DynamoDbTablesEncryptionConfig.Builder nativeBuilder =
      DynamoDbTablesEncryptionConfig.builder();
    nativeBuilder.tableEncryptionConfigs(
      ToNative.DynamoDbTableEncryptionConfigList(
        dafnyValue.dtor_tableEncryptionConfigs()
      )
    );
    return nativeBuilder.build();
  }

  public static EncryptedDataKeyDescription EncryptedDataKeyDescription(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription dafnyValue
  ) {
    EncryptedDataKeyDescription.Builder nativeBuilder =
      EncryptedDataKeyDescription.builder();
    nativeBuilder.keyProviderId(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_keyProviderId()
      )
    );
    if (dafnyValue.dtor_keyProviderInfo().is_Some()) {
      nativeBuilder.keyProviderInfo(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_keyProviderInfo().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_branchKeyId().is_Some()) {
      nativeBuilder.branchKeyId(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_branchKeyId().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_branchKeyVersion().is_Some()) {
      nativeBuilder.branchKeyVersion(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_branchKeyVersion().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static EncryptedPart EncryptedPart(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart dafnyValue
  ) {
    EncryptedPart.Builder nativeBuilder = EncryptedPart.builder();
    nativeBuilder.name(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_name()
      )
    );
    nativeBuilder.prefix(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_prefix()
      )
    );
    return nativeBuilder.build();
  }

  public static GetBranchKeyIdFromDdbKeyInput GetBranchKeyIdFromDdbKeyInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput dafnyValue
  ) {
    GetBranchKeyIdFromDdbKeyInput.Builder nativeBuilder =
      GetBranchKeyIdFromDdbKeyInput.builder();
    nativeBuilder.ddbKey(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.Key(
        dafnyValue.dtor_ddbKey()
      )
    );
    return nativeBuilder.build();
  }

  public static GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKeyOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput dafnyValue
  ) {
    GetBranchKeyIdFromDdbKeyOutput.Builder nativeBuilder =
      GetBranchKeyIdFromDdbKeyOutput.builder();
    nativeBuilder.branchKeyId(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_branchKeyId()
      )
    );
    return nativeBuilder.build();
  }

  public static GetBucketNumberInput GetBucketNumberInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberInput dafnyValue
  ) {
    GetBucketNumberInput.Builder nativeBuilder = GetBucketNumberInput.builder();
    nativeBuilder.item(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeMap(
        dafnyValue.dtor_item()
      )
    );
    nativeBuilder.numberOfBuckets((dafnyValue.dtor_numberOfBuckets()));
    return nativeBuilder.build();
  }

  public static GetBucketNumberOutput GetBucketNumberOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBucketNumberOutput dafnyValue
  ) {
    GetBucketNumberOutput.Builder nativeBuilder =
      GetBucketNumberOutput.builder();
    nativeBuilder.bucketNumber((dafnyValue.dtor_bucketNumber()));
    return nativeBuilder.build();
  }

  public static GetEncryptedDataKeyDescriptionInput GetEncryptedDataKeyDescriptionInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput dafnyValue
  ) {
    GetEncryptedDataKeyDescriptionInput.Builder nativeBuilder =
      GetEncryptedDataKeyDescriptionInput.builder();
    nativeBuilder.input(
      ToNative.GetEncryptedDataKeyDescriptionUnion(dafnyValue.dtor_input())
    );
    return nativeBuilder.build();
  }

  public static GetEncryptedDataKeyDescriptionOutput GetEncryptedDataKeyDescriptionOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput dafnyValue
  ) {
    GetEncryptedDataKeyDescriptionOutput.Builder nativeBuilder =
      GetEncryptedDataKeyDescriptionOutput.builder();
    nativeBuilder.EncryptedDataKeyDescriptionOutput(
      ToNative.EncryptedDataKeyDescriptionList(
        dafnyValue.dtor_EncryptedDataKeyDescriptionOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static GetNumberOfQueriesInput GetNumberOfQueriesInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetNumberOfQueriesInput dafnyValue
  ) {
    GetNumberOfQueriesInput.Builder nativeBuilder =
      GetNumberOfQueriesInput.builder();
    nativeBuilder.input(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.QueryInput(
        dafnyValue.dtor_input()
      )
    );
    return nativeBuilder.build();
  }

  public static GetNumberOfQueriesOutput GetNumberOfQueriesOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetNumberOfQueriesOutput dafnyValue
  ) {
    GetNumberOfQueriesOutput.Builder nativeBuilder =
      GetNumberOfQueriesOutput.builder();
    nativeBuilder.numberOfQueries((dafnyValue.dtor_numberOfQueries()));
    return nativeBuilder.build();
  }

  public static GetPrefix GetPrefix(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix dafnyValue
  ) {
    GetPrefix.Builder nativeBuilder = GetPrefix.builder();
    nativeBuilder.length((dafnyValue.dtor_length()));
    return nativeBuilder.build();
  }

  public static GetSegment GetSegment(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment dafnyValue
  ) {
    GetSegment.Builder nativeBuilder = GetSegment.builder();
    nativeBuilder.split(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_split()
      )
    );
    nativeBuilder.index((dafnyValue.dtor_index()));
    return nativeBuilder.build();
  }

  public static GetSegments GetSegments(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments dafnyValue
  ) {
    GetSegments.Builder nativeBuilder = GetSegments.builder();
    nativeBuilder.split(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_split()
      )
    );
    nativeBuilder.low((dafnyValue.dtor_low()));
    nativeBuilder.high((dafnyValue.dtor_high()));
    return nativeBuilder.build();
  }

  public static GetSubstring GetSubstring(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring dafnyValue
  ) {
    GetSubstring.Builder nativeBuilder = GetSubstring.builder();
    nativeBuilder.low((dafnyValue.dtor_low()));
    nativeBuilder.high((dafnyValue.dtor_high()));
    return nativeBuilder.build();
  }

  public static GetSuffix GetSuffix(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix dafnyValue
  ) {
    GetSuffix.Builder nativeBuilder = GetSuffix.builder();
    nativeBuilder.length((dafnyValue.dtor_length()));
    return nativeBuilder.build();
  }

  public static Insert Insert(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert dafnyValue
  ) {
    Insert.Builder nativeBuilder = Insert.builder();
    nativeBuilder.literal(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_literal()
      )
    );
    return nativeBuilder.build();
  }

  public static LegacyOverride LegacyOverride(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride dafnyValue
  ) {
    LegacyOverride.Builder nativeBuilder = LegacyOverride.builder();
    nativeBuilder.policy(ToNative.LegacyPolicy(dafnyValue.dtor_policy()));
    nativeBuilder.encryptor(
      ToNative.LegacyDynamoDbEncryptor(dafnyValue.dtor_encryptor())
    );
    nativeBuilder.attributeActionsOnEncrypt(
      ToNative.AttributeActions(dafnyValue.dtor_attributeActionsOnEncrypt())
    );
    if (dafnyValue.dtor_defaultAttributeFlag().is_Some()) {
      nativeBuilder.defaultAttributeFlag(
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative.CryptoAction(
          dafnyValue.dtor_defaultAttributeFlag().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static Lower Lower(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower dafnyValue
  ) {
    Lower.Builder nativeBuilder = Lower.builder();
    return nativeBuilder.build();
  }

  public static MultiKeyStore MultiKeyStore(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.MultiKeyStore dafnyValue
  ) {
    MultiKeyStore.Builder nativeBuilder = MultiKeyStore.builder();
    nativeBuilder.keyFieldName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_keyFieldName()
      )
    );
    nativeBuilder.cacheTTL((dafnyValue.dtor_cacheTTL()));
    if (dafnyValue.dtor_cache().is_Some()) {
      nativeBuilder.cache(
        software.amazon.cryptography.materialproviders.ToNative.CacheType(
          dafnyValue.dtor_cache().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_partitionId().is_Some()) {
      nativeBuilder.partitionId(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_partitionId().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static PartOnly PartOnly(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly dafnyValue
  ) {
    PartOnly.Builder nativeBuilder = PartOnly.builder();
    return nativeBuilder.build();
  }

  public static SearchConfig SearchConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig dafnyValue
  ) {
    SearchConfig.Builder nativeBuilder = SearchConfig.builder();
    nativeBuilder.versions(
      ToNative.BeaconVersionList(dafnyValue.dtor_versions())
    );
    nativeBuilder.writeVersion((dafnyValue.dtor_writeVersion()));
    return nativeBuilder.build();
  }

  public static Shared Shared(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared dafnyValue
  ) {
    Shared.Builder nativeBuilder = Shared.builder();
    nativeBuilder.other(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_other()
      )
    );
    return nativeBuilder.build();
  }

  public static SharedSet SharedSet(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet dafnyValue
  ) {
    SharedSet.Builder nativeBuilder = SharedSet.builder();
    nativeBuilder.other(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_other()
      )
    );
    return nativeBuilder.build();
  }

  public static SignedPart SignedPart(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart dafnyValue
  ) {
    SignedPart.Builder nativeBuilder = SignedPart.builder();
    nativeBuilder.name(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_name()
      )
    );
    nativeBuilder.prefix(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_prefix()
      )
    );
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_loc().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static SingleKeyStore SingleKeyStore(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SingleKeyStore dafnyValue
  ) {
    SingleKeyStore.Builder nativeBuilder = SingleKeyStore.builder();
    nativeBuilder.keyId(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_keyId()
      )
    );
    nativeBuilder.cacheTTL((dafnyValue.dtor_cacheTTL()));
    if (dafnyValue.dtor_cache().is_Some()) {
      nativeBuilder.cache(
        software.amazon.cryptography.materialproviders.ToNative.CacheType(
          dafnyValue.dtor_cache().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_partitionId().is_Some()) {
      nativeBuilder.partitionId(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_partitionId().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static StandardBeacon StandardBeacon(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon dafnyValue
  ) {
    StandardBeacon.Builder nativeBuilder = StandardBeacon.builder();
    nativeBuilder.name(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_name()
      )
    );
    nativeBuilder.length((dafnyValue.dtor_length()));
    if (dafnyValue.dtor_loc().is_Some()) {
      nativeBuilder.loc(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_loc().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_style().is_Some()) {
      nativeBuilder.style(
        ToNative.BeaconStyle(dafnyValue.dtor_style().dtor_value())
      );
    }
    if (dafnyValue.dtor_numberOfBuckets().is_Some()) {
      nativeBuilder.numberOfBuckets(
        (dafnyValue.dtor_numberOfBuckets().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static Upper Upper(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper dafnyValue
  ) {
    Upper.Builder nativeBuilder = Upper.builder();
    return nativeBuilder.build();
  }

  public static VirtualField VirtualField(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField dafnyValue
  ) {
    VirtualField.Builder nativeBuilder = VirtualField.builder();
    nativeBuilder.name(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_name()
      )
    );
    nativeBuilder.parts(ToNative.VirtualPartList(dafnyValue.dtor_parts()));
    return nativeBuilder.build();
  }

  public static VirtualPart VirtualPart(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart dafnyValue
  ) {
    VirtualPart.Builder nativeBuilder = VirtualPart.builder();
    nativeBuilder.loc(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_loc()
      )
    );
    if (dafnyValue.dtor_trans().is_Some()) {
      nativeBuilder.trans(
        ToNative.VirtualTransformList(dafnyValue.dtor_trans().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static LegacyPolicy LegacyPolicy(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy dafnyValue
  ) {
    if (dafnyValue.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT()) {
      return LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT;
    }
    if (dafnyValue.is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT()) {
      return LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT;
    }
    if (dafnyValue.is_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT()) {
      return LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT;
    }
    throw new IllegalArgumentException(
      "No entry of software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy matches the input : " +
      dafnyValue
    );
  }

  public static PlaintextOverride PlaintextOverride(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride dafnyValue
  ) {
    if (dafnyValue.is_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ()) {
      return PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ;
    }
    if (dafnyValue.is_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ()) {
      return PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ;
    }
    if (dafnyValue.is_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ()) {
      return PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ;
    }
    throw new IllegalArgumentException(
      "No entry of software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride matches the input : " +
      dafnyValue
    );
  }

  public static BeaconKeySource BeaconKeySource(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource dafnyValue
  ) {
    BeaconKeySource.Builder nativeBuilder = BeaconKeySource.builder();
    if (dafnyValue.is_single()) {
      nativeBuilder.single(ToNative.SingleKeyStore(dafnyValue.dtor_single()));
    }
    if (dafnyValue.is_multi()) {
      nativeBuilder.multi(ToNative.MultiKeyStore(dafnyValue.dtor_multi()));
    }
    return nativeBuilder.build();
  }

  public static BeaconStyle BeaconStyle(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle dafnyValue
  ) {
    BeaconStyle.Builder nativeBuilder = BeaconStyle.builder();
    if (dafnyValue.is_partOnly()) {
      nativeBuilder.partOnly(ToNative.PartOnly(dafnyValue.dtor_partOnly()));
    }
    if (dafnyValue.is_shared()) {
      nativeBuilder.shared(ToNative.Shared(dafnyValue.dtor_shared()));
    }
    if (dafnyValue.is_asSet()) {
      nativeBuilder.asSet(ToNative.AsSet(dafnyValue.dtor_asSet()));
    }
    if (dafnyValue.is_sharedSet()) {
      nativeBuilder.sharedSet(ToNative.SharedSet(dafnyValue.dtor_sharedSet()));
    }
    return nativeBuilder.build();
  }

  public static GetEncryptedDataKeyDescriptionUnion GetEncryptedDataKeyDescriptionUnion(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion dafnyValue
  ) {
    GetEncryptedDataKeyDescriptionUnion.Builder nativeBuilder =
      GetEncryptedDataKeyDescriptionUnion.builder();
    if (dafnyValue.is_header()) {
      nativeBuilder.header(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.ByteBuffer(
          dafnyValue.dtor_header()
        )
      );
    }
    if (dafnyValue.is_item()) {
      nativeBuilder.item(
        software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeMap(
          dafnyValue.dtor_item()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static VirtualTransform VirtualTransform(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform dafnyValue
  ) {
    VirtualTransform.Builder nativeBuilder = VirtualTransform.builder();
    if (dafnyValue.is_upper()) {
      nativeBuilder.upper(ToNative.Upper(dafnyValue.dtor_upper()));
    }
    if (dafnyValue.is_lower()) {
      nativeBuilder.lower(ToNative.Lower(dafnyValue.dtor_lower()));
    }
    if (dafnyValue.is_insert()) {
      nativeBuilder.insert(ToNative.Insert(dafnyValue.dtor_insert()));
    }
    if (dafnyValue.is_prefix()) {
      nativeBuilder.prefix(ToNative.GetPrefix(dafnyValue.dtor_prefix()));
    }
    if (dafnyValue.is_suffix()) {
      nativeBuilder.suffix(ToNative.GetSuffix(dafnyValue.dtor_suffix()));
    }
    if (dafnyValue.is_substring()) {
      nativeBuilder.substring(
        ToNative.GetSubstring(dafnyValue.dtor_substring())
      );
    }
    if (dafnyValue.is_segment()) {
      nativeBuilder.segment(ToNative.GetSegment(dafnyValue.dtor_segment()));
    }
    if (dafnyValue.is_segments()) {
      nativeBuilder.segments(ToNative.GetSegments(dafnyValue.dtor_segments()));
    }
    return nativeBuilder.build();
  }

  public static List<BeaconVersion> BeaconVersionList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::BeaconVersion
    );
  }

  public static List<CompoundBeacon> CompoundBeaconList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::CompoundBeacon
    );
  }

  public static List<Constructor> ConstructorList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::Constructor
    );
  }

  public static List<ConstructorPart> ConstructorPartList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::ConstructorPart
    );
  }

  public static List<
    EncryptedDataKeyDescription
  > EncryptedDataKeyDescriptionList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::EncryptedDataKeyDescription
    );
  }

  public static List<EncryptedPart> EncryptedPartsList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::EncryptedPart
    );
  }

  public static List<SignedPart> SignedPartsList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::SignedPart
    );
  }

  public static List<StandardBeacon> StandardBeaconList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::StandardBeacon
    );
  }

  public static List<VirtualField> VirtualFieldList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::VirtualField
    );
  }

  public static List<VirtualPart> VirtualPartList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::VirtualPart
    );
  }

  public static List<VirtualTransform> VirtualTransformList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::VirtualTransform
    );
  }

  public static Map<String, CryptoAction> AttributeActions(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::CryptoAction
    );
  }

  public static Map<
    String,
    DynamoDbTableEncryptionConfig
  > DynamoDbTableEncryptionConfigList(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative::DynamoDbTableEncryptionConfig
    );
  }

  public static IBucketSelector BucketSelector(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IBucketSelector dafnyValue
  ) {
    return BucketSelector.wrap(dafnyValue);
  }

  public static IDynamoDbKeyBranchKeyIdSupplier DynamoDbKeyBranchKeyIdSupplier(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier dafnyValue
  ) {
    if (dafnyValue instanceof DynamoDbKeyBranchKeyIdSupplier.NativeWrapper) {
      return ((DynamoDbKeyBranchKeyIdSupplier.NativeWrapper) dafnyValue)._impl;
    }
    return DynamoDbKeyBranchKeyIdSupplier.wrap(dafnyValue);
  }

  public static ILegacyDynamoDbEncryptor LegacyDynamoDbEncryptor(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor dafnyValue
  ) {
    if (dafnyValue instanceof LegacyDynamoDbEncryptor.NativeWrapper) {
      return ((LegacyDynamoDbEncryptor.NativeWrapper) dafnyValue)._impl;
    }
    return LegacyDynamoDbEncryptor.wrap(dafnyValue);
  }

  public static DynamoDbEncryption DynamoDbEncryption(
    IDynamoDbEncryptionClient dafnyValue
  ) {
    return new DynamoDbEncryption(dafnyValue);
  }
}
