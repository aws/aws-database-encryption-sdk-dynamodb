// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.decryptwithpermute;

import java.lang.RuntimeException;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.Error_CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.Error_DynamoDbPermuteDecryptorException;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.Error_Opaque;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.IDynamoDbPermuteDecryptorClient;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.DynamoDbPermuteDecryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.DynamoDbPermuteDecryptorException;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.PermuteDecryptInput;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.PermuteDecryptOutput;

public class ToNative {
  public static OpaqueError Error(Error_Opaque dafnyValue) {
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue.dtor_obj());
    return nativeBuilder.build();
  }

  public static CollectionOfErrors Error(Error_CollectionOfErrors dafnyValue) {
    CollectionOfErrors.Builder nativeBuilder = CollectionOfErrors.builder();
    nativeBuilder.list(
        software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue.dtor_list(), 
        ToNative::Error));
    nativeBuilder.message(software.amazon.smithy.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_message()));
    return nativeBuilder.build();
  }

  public static DynamoDbPermuteDecryptorException Error(
      Error_DynamoDbPermuteDecryptorException dafnyValue) {
    DynamoDbPermuteDecryptorException.Builder nativeBuilder = DynamoDbPermuteDecryptorException.builder();
    nativeBuilder.message(software.amazon.smithy.dafny.conversion.ToNative.Simple.String(dafnyValue.dtor_message()));
    return nativeBuilder.build();
  }

  public static RuntimeException Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbPermuteDecryptorException()) {
      return ToNative.Error((Error_DynamoDbPermuteDecryptorException) dafnyValue);
    }
    if (dafnyValue.is_Opaque()) {
      return ToNative.Error((Error_Opaque) dafnyValue);
    }
    if (dafnyValue.is_CollectionOfErrors()) {
      return ToNative.Error((Error_CollectionOfErrors) dafnyValue);
    }
    if (dafnyValue.is_AwsCryptographyMaterialProviders()) {
      return software.amazon.cryptography.materialproviders.ToNative.Error(dafnyValue.dtor_AwsCryptographyMaterialProviders());
    }
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkStructuredEncryption()) {
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative.Error(dafnyValue.dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption());
    }
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor()) {
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative.Error(dafnyValue.dtor_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor());
    }
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkDynamoDb()) {
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative.Error(dafnyValue.dtor_AwsCryptographyDbEncryptionSdkDynamoDb());
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static DynamoDbPermuteDecryptorConfig DynamoDbPermuteDecryptorConfig(
      software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.DynamoDbPermuteDecryptorConfig dafnyValue) {
    DynamoDbPermuteDecryptorConfig.Builder nativeBuilder = DynamoDbPermuteDecryptorConfig.builder();
    nativeBuilder.inner(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative.DynamoDbItemEncryptorConfig(dafnyValue.dtor_inner()));
    return nativeBuilder.build();
  }

  public static PermuteDecryptInput PermuteDecryptInput(
      software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.PermuteDecryptInput dafnyValue) {
    PermuteDecryptInput.Builder nativeBuilder = PermuteDecryptInput.builder();
    nativeBuilder.inner(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative.DecryptItemInput(dafnyValue.dtor_inner()));
    nativeBuilder.maxSetSize((dafnyValue.dtor_maxSetSize()));
    return nativeBuilder.build();
  }

  public static PermuteDecryptOutput PermuteDecryptOutput(
      software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.PermuteDecryptOutput dafnyValue) {
    PermuteDecryptOutput.Builder nativeBuilder = PermuteDecryptOutput.builder();
    nativeBuilder.inner(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative.DecryptItemOutput(dafnyValue.dtor_inner()));
    nativeBuilder.didPermute((dafnyValue.dtor_didPermute()));
    return nativeBuilder.build();
  }

  public static DynamoDbPermuteDecryptor DynamoDbPermuteDecryptor(
      IDynamoDbPermuteDecryptorClient dafnyValue) {
    return new DynamoDbPermuteDecryptor(dafnyValue);
  }
}
