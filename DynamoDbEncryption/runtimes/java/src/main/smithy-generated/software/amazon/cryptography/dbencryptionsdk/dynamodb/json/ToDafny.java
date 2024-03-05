// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import dafny.TypeDescriptor;
import java.lang.Byte;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_JsonEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.IJsonEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Json;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncrypt;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.OpaqueError;
import software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring;

public class ToDafny {

  public static Error Error(RuntimeException nativeValue) {
    if (nativeValue instanceof JsonEncryptorException) {
      return ToDafny.Error((JsonEncryptorException) nativeValue);
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
    DafnySequence<? extends Error> list =
      software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
        nativeValue.list(),
        ToDafny::Error,
        Error._typeDescriptor()
      );
    DafnySequence<? extends Character> message =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.getMessage()
      );
    return Error.create_CollectionOfErrors(list, message);
  }

  public static DecryptObjectInput DecryptObjectInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectInput nativeValue
  ) {
    Json encryptedObject;
    encryptedObject = ToDafny.Json(nativeValue.encryptedObject());
    return new DecryptObjectInput(encryptedObject);
  }

  public static DecryptObjectOutput DecryptObjectOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectOutput nativeValue
  ) {
    Json plaintextObject;
    plaintextObject = ToDafny.Json(nativeValue.plaintextObject());
    Option<ParsedHeader> parsedHeader;
    parsedHeader =
      Objects.nonNull(nativeValue.parsedHeader())
        ? Option.create_Some(ToDafny.ParsedHeader(nativeValue.parsedHeader()))
        : Option.create_None();
    return new DecryptObjectOutput(plaintextObject, parsedHeader);
  }

  public static EncryptObjectInput EncryptObjectInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectInput nativeValue
  ) {
    Json plaintextObject;
    plaintextObject = ToDafny.Json(nativeValue.plaintextObject());
    return new EncryptObjectInput(plaintextObject);
  }

  public static EncryptObjectOutput EncryptObjectOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectOutput nativeValue
  ) {
    Json encryptedObject;
    encryptedObject = ToDafny.Json(nativeValue.encryptedObject());
    Option<ParsedHeader> parsedHeader;
    parsedHeader =
      Objects.nonNull(nativeValue.parsedHeader())
        ? Option.create_Some(ToDafny.ParsedHeader(nativeValue.parsedHeader()))
        : Option.create_None();
    return new EncryptObjectOutput(encryptedObject, parsedHeader);
  }

  public static JsonEncrypt JsonEncrypt(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncrypt nativeValue
  ) {
    Option<IKeyring> keyring;
    keyring =
      Objects.nonNull(nativeValue.keyring())
        ? Option.create_Some(
          software.amazon.cryptography.materialproviders.ToDafny.Keyring(
            nativeValue.keyring()
          )
        )
        : Option.create_None();
    Option<ICryptographicMaterialsManager> cmm;
    cmm =
      Objects.nonNull(nativeValue.cmm())
        ? Option.create_Some(
          software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(
            nativeValue.cmm()
          )
        )
        : Option.create_None();
    Option<DBEAlgorithmSuiteId> algorithmSuiteId;
    algorithmSuiteId =
      Objects.nonNull(nativeValue.algorithmSuiteId())
        ? Option.create_Some(
          software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(
            nativeValue.algorithmSuiteId()
          )
        )
        : Option.create_None();
    Option<
      DafnyMap<
        ? extends DafnySequence<? extends Byte>,
        ? extends DafnySequence<? extends Byte>
      >
    > encryptionContext;
    encryptionContext =
      (Objects.nonNull(nativeValue.encryptionContext()) &&
          nativeValue.encryptionContext().size() > 0)
        ? Option.create_Some(
          software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(
            nativeValue.encryptionContext()
          )
        )
        : Option.create_None();
    return new JsonEncrypt(keyring, cmm, algorithmSuiteId, encryptionContext);
  }

  public static JsonEncryptorConfig JsonEncryptorConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorConfig nativeValue
  ) {
    DafnySequence<? extends Character> domain;
    domain =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.domain()
      );
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends Action
    > memberActionsOnEncrypt;
    memberActionsOnEncrypt =
      ToDafny.MemberActions(nativeValue.memberActionsOnEncrypt());
    Option<
      DafnySequence<? extends DafnySequence<? extends Character>>
    > allowedUnsignedMembers;
    allowedUnsignedMembers =
      (Objects.nonNull(nativeValue.allowedUnsignedMembers()) &&
          nativeValue.allowedUnsignedMembers().size() > 0)
        ? Option.create_Some(
          ToDafny.MemberNameList(nativeValue.allowedUnsignedMembers())
        )
        : Option.create_None();
    Option<DafnySequence<? extends Character>> allowedUnsignedMemberPrefix;
    allowedUnsignedMemberPrefix =
      Objects.nonNull(nativeValue.allowedUnsignedMemberPrefix())
        ? Option.create_Some(
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.allowedUnsignedMemberPrefix()
          )
        )
        : Option.create_None();
    JsonEncrypt encrypt;
    encrypt = ToDafny.JsonEncrypt(nativeValue.encrypt());
    return new JsonEncryptorConfig(
      domain,
      memberActionsOnEncrypt,
      allowedUnsignedMembers,
      allowedUnsignedMemberPrefix,
      encrypt
    );
  }

  public static ParsedHeader ParsedHeader(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.ParsedHeader nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends Action
    > memberActionsOnEncrypt;
    memberActionsOnEncrypt =
      ToDafny.MemberActions(nativeValue.memberActionsOnEncrypt());
    DBEAlgorithmSuiteId algorithmSuiteId;
    algorithmSuiteId =
      software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(
        nativeValue.algorithmSuiteId()
      );
    DafnySequence<? extends EncryptedDataKey> encryptedDataKeys;
    encryptedDataKeys =
      software.amazon.cryptography.materialproviders.ToDafny.EncryptedDataKeyList(
        nativeValue.encryptedDataKeys()
      );
    DafnyMap<
      ? extends DafnySequence<? extends Byte>,
      ? extends DafnySequence<? extends Byte>
    > storedEncryptionContext;
    storedEncryptionContext =
      software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(
        nativeValue.storedEncryptionContext()
      );
    DafnyMap<
      ? extends DafnySequence<? extends Byte>,
      ? extends DafnySequence<? extends Byte>
    > encryptionContext;
    encryptionContext =
      software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(
        nativeValue.encryptionContext()
      );
    return new ParsedHeader(
      memberActionsOnEncrypt,
      algorithmSuiteId,
      encryptedDataKeys,
      storedEncryptionContext,
      encryptionContext
    );
  }

  public static Error Error(JsonEncryptorException nativeValue) {
    DafnySequence<? extends Character> message;
    message =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.message()
      );
    return new Error_JsonEncryptorException(message);
  }

  public static Action Action(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.Action nativeValue
  ) {
    if (Objects.nonNull(nativeValue.crypto())) {
      return Action.create_crypto(
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny.CryptoAction(
          nativeValue.crypto()
        )
      );
    }
    if (Objects.nonNull(nativeValue.dbesdk())) {
      return Action.create_dbesdk(ToDafny.JsonEncrypt(nativeValue.dbesdk()));
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action."
    );
  }

  public static Json Json(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.Json nativeValue
  ) {
    if (Objects.nonNull(nativeValue.utf8())) {
      return Json.create_utf8(
        software.amazon.smithy.dafny.conversion.ToDafny.Simple.DafnyUtf8Bytes(
          nativeValue.utf8()
        )
      );
    }
    if (Objects.nonNull(nativeValue.text())) {
      return Json.create_text(
        software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
          nativeValue.text()
        )
      );
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Json."
    );
  }

  public static DafnySequence<
    ? extends DafnySequence<? extends Character>
  > MemberNameList(List<String> nativeValue) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends Action
  > MemberActions(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.Action
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.ToDafny::Action
    );
  }

  public static IJsonEncryptorClient JsonEncryptor(JsonEncryptor nativeValue) {
    return nativeValue.impl();
  }
}
