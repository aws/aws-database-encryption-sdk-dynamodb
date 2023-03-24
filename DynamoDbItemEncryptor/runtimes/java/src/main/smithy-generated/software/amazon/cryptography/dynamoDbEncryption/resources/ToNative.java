// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.resources;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_CollectionOfErrors;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_DynamoDbEncryptionResourcesException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_Opaque;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.DynamoDbEncryptionResourcesConfig;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.DynamoDbEncryptionResourcesException;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.GetBranchKeyIdFromItemInput;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.GetBranchKeyIdFromItemOutput;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.OpaqueError;

public class ToNative {
  public static OpaqueError Error(Error_Opaque dafnyValue) {
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue.dtor_obj());
    return nativeBuilder.build();
  }

  public static CollectionOfErrors Error(Error_CollectionOfErrors dafnyValue) {
    CollectionOfErrors.Builder nativeBuilder = CollectionOfErrors.builder();
    nativeBuilder.list(
        software.amazon.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue.dtor_list(), 
        ToNative::Error));
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionResourcesException Error(
      Error_DynamoDbEncryptionResourcesException dafnyValue) {
    DynamoDbEncryptionResourcesException.Builder nativeBuilder = DynamoDbEncryptionResourcesException.builder();
    nativeBuilder.message(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_message()));
    return nativeBuilder.build();
  }

  public static NativeError Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbEncryptionResourcesException()) {
      return ToNative.Error((Error_DynamoDbEncryptionResourcesException) dafnyValue);
    }
    if (dafnyValue.is_Opaque()) {
      return ToNative.Error((Error_Opaque) dafnyValue);
    }
    if (dafnyValue.is_CollectionOfErrors()) {
      return ToNative.Error((Error_CollectionOfErrors) dafnyValue);
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput dafnyValue) {
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.Builder nativeBuilder = CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.builder();
    nativeBuilder.branchKeyIdSupplier(software.amazon.cryptography.materialProviders.ToNative.BranchKeyIdSupplier(dafnyValue.dtor_branchKeyIdSupplier()));
    return nativeBuilder.build();
  }

  public static GetBranchKeyIdFromItemOutput GetBranchKeyIdFromItemOutput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemOutput dafnyValue) {
    GetBranchKeyIdFromItemOutput.Builder nativeBuilder = GetBranchKeyIdFromItemOutput.builder();
    nativeBuilder.branchKeyId(software.amazon.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_branchKeyId()));
    return nativeBuilder.build();
  }

  public static GetBranchKeyIdFromItemInput GetBranchKeyIdFromItemInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemInput dafnyValue) {
    GetBranchKeyIdFromItemInput.Builder nativeBuilder = GetBranchKeyIdFromItemInput.builder();
    nativeBuilder.ddbItem(Dafny.Com.Amazonaws.Dynamodb.ToNative.AttributeMap(dafnyValue.dtor_ddbItem()));
    return nativeBuilder.build();
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput dafnyValue) {
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput.Builder nativeBuilder = CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder();
    nativeBuilder.ddbItemBranchKeyIdSupplier(ToNative.DynamoDbItemBranchKeyIdSupplier(dafnyValue.dtor_ddbItemBranchKeyIdSupplier()));
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionResourcesConfig DynamoDbEncryptionResourcesConfig(
      Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.DynamoDbEncryptionResourcesConfig dafnyValue) {
    DynamoDbEncryptionResourcesConfig.Builder nativeBuilder = DynamoDbEncryptionResourcesConfig.builder();
    return nativeBuilder.build();
  }

  public static DynamoDbItemBranchKeyIdSupplier DynamoDbItemBranchKeyIdSupplier(
      IDynamoDbItemBranchKeyIdSupplier dafnyValue) {
    return DynamoDbItemBranchKeyIdSupplier.wrap(dafnyValue);
  }
}
