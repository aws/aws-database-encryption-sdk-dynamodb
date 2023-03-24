// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.resources;

import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.DynamoDbEncryptionResourcesConfig;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.Error_DynamoDbEncryptionResourcesException;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemInput;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.GetBranchKeyIdFromItemOutput;
import Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier;
import Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.CollectionOfErrors;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.DynamoDbEncryptionResourcesException;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.NativeError;
import software.amazon.cryptography.dynamoDbEncryption.resources.model.OpaqueError;

public class ToDafny {
  public static Error Error(NativeError nativeValue) {
    if (nativeValue instanceof DynamoDbEncryptionResourcesException) {
      return ToDafny.Error((DynamoDbEncryptionResourcesException) nativeValue);
    }
    if (nativeValue instanceof OpaqueError) {
      return ToDafny.Error((OpaqueError) nativeValue);
    }
    if (nativeValue instanceof CollectionOfErrors) {
      return ToDafny.Error((CollectionOfErrors) nativeValue);
    }
    return Error.create_Opaque(nativeValue);
  }

  public static Error Error(OpaqueError nativeValue) {
    return Error.create_Opaque(nativeValue.obj());
  }

  public static Error Error(CollectionOfErrors nativeValue) {
    DafnySequence<? extends Error> list = software.amazon.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue.list(), 
        ToDafny::Error, 
        Error._typeDescriptor());
    return Error.create_CollectionOfErrors(list);
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
      software.amazon.cryptography.dynamoDbEncryption.resources.model.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput nativeValue) {
    IBranchKeyIdSupplier branchKeyIdSupplier;
    branchKeyIdSupplier = software.amazon.cryptography.materialProviders.ToDafny.BranchKeyIdSupplier(nativeValue.branchKeyIdSupplier());
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(branchKeyIdSupplier);
  }

  public static GetBranchKeyIdFromItemOutput GetBranchKeyIdFromItemOutput(
      software.amazon.cryptography.dynamoDbEncryption.resources.model.GetBranchKeyIdFromItemOutput nativeValue) {
    DafnySequence<? extends Character> branchKeyId;
    branchKeyId = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.branchKeyId());
    return new GetBranchKeyIdFromItemOutput(branchKeyId);
  }

  public static GetBranchKeyIdFromItemInput GetBranchKeyIdFromItemInput(
      software.amazon.cryptography.dynamoDbEncryption.resources.model.GetBranchKeyIdFromItemInput nativeValue) {
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends AttributeValue> ddbItem;
    ddbItem = Dafny.Com.Amazonaws.Dynamodb.ToDafny.AttributeMap(nativeValue.ddbItem());
    return new GetBranchKeyIdFromItemInput(ddbItem);
  }

  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
      software.amazon.cryptography.dynamoDbEncryption.resources.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput nativeValue) {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier ddbItemBranchKeyIdSupplier;
    ddbItemBranchKeyIdSupplier = ToDafny.DynamoDbItemBranchKeyIdSupplier(nativeValue.ddbItemBranchKeyIdSupplier());
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierInput(ddbItemBranchKeyIdSupplier);
  }

  public static DynamoDbEncryptionResourcesConfig DynamoDbEncryptionResourcesConfig(
      software.amazon.cryptography.dynamoDbEncryption.resources.model.DynamoDbEncryptionResourcesConfig nativeValue) {
    return new DynamoDbEncryptionResourcesConfig();
  }

  public static Error Error(DynamoDbEncryptionResourcesException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_DynamoDbEncryptionResourcesException(message);
  }

  public static Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier DynamoDbItemBranchKeyIdSupplier(
      IDynamoDbItemBranchKeyIdSupplier nativeValue) {
    return DynamoDbItemBranchKeyIdSupplier.wrap(nativeValue).impl();
  }
}
