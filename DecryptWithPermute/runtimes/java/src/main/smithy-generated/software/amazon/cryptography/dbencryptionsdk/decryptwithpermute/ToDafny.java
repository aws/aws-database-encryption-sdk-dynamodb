// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.decryptwithpermute;

import dafny.DafnySequence;
import java.lang.Boolean;
import java.lang.Character;
import java.lang.Integer;
import java.lang.RuntimeException;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.DynamoDbPermuteDecryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.Error_DynamoDbPermuteDecryptorException;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.IDynamoDbPermuteDecryptorClient;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.PermuteDecryptInput;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny.types.PermuteDecryptOutput;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.DynamoDbPermuteDecryptorException;
import software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig;

public class ToDafny {
  public static Error Error(RuntimeException nativeValue) {
    if (nativeValue instanceof DynamoDbPermuteDecryptorException) {
      return ToDafny.Error((DynamoDbPermuteDecryptorException) nativeValue);
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
    DafnySequence<? extends Error> list = software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue.list(), 
        ToDafny::Error, 
        Error._typeDescriptor());
    DafnySequence<? extends Character> message = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.getMessage());
    return Error.create_CollectionOfErrors(list, message);
  }

  public static DynamoDbPermuteDecryptorConfig DynamoDbPermuteDecryptorConfig(
      software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.DynamoDbPermuteDecryptorConfig nativeValue) {
    DynamoDbItemEncryptorConfig inner;
    inner = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToDafny.DynamoDbItemEncryptorConfig(nativeValue.inner());
    return new DynamoDbPermuteDecryptorConfig(inner);
  }

  public static PermuteDecryptInput PermuteDecryptInput(
      software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.PermuteDecryptInput nativeValue) {
    DecryptItemInput inner;
    inner = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToDafny.DecryptItemInput(nativeValue.inner());
    Integer maxSetSize;
    maxSetSize = (nativeValue.maxSetSize());
    return new PermuteDecryptInput(inner, maxSetSize);
  }

  public static PermuteDecryptOutput PermuteDecryptOutput(
      software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model.PermuteDecryptOutput nativeValue) {
    DecryptItemOutput inner;
    inner = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToDafny.DecryptItemOutput(nativeValue.inner());
    Boolean didPermute;
    didPermute = (nativeValue.didPermute());
    return new PermuteDecryptOutput(inner, didPermute);
  }

  public static Error Error(DynamoDbPermuteDecryptorException nativeValue) {
    DafnySequence<? extends Character> message;
    message = software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(nativeValue.message());
    return new Error_DynamoDbPermuteDecryptorException(message);
  }

  public static IDynamoDbPermuteDecryptorClient DynamoDbPermuteDecryptor(
      DynamoDbPermuteDecryptor nativeValue) {
    return nativeValue.impl();
  }
}
