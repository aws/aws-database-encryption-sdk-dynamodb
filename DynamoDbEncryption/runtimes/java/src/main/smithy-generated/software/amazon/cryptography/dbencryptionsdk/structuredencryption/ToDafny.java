// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

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
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.OpaqueWithTextError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionException;
import software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager;

public class ToDafny {

  public static Error Error(RuntimeException nativeValue) {
    if (nativeValue instanceof StructuredEncryptionException) {
      return ToDafny.Error((StructuredEncryptionException) nativeValue);
    }
    if (nativeValue instanceof OpaqueError) {
      return ToDafny.Error((OpaqueError) nativeValue);
    }
    if (nativeValue instanceof OpaqueWithTextError) {
      return ToDafny.Error((OpaqueWithTextError) nativeValue);
    }
    if (nativeValue instanceof CollectionOfErrors) {
      return ToDafny.Error((CollectionOfErrors) nativeValue);
    }
    return Error.create_Opaque(nativeValue);
  }

  public static Error Error(OpaqueError nativeValue) {
    return Error.create_Opaque(nativeValue.obj());
  }

  public static Error Error(OpaqueWithTextError nativeValue) {
    return Error.create_OpaqueWithText(
      nativeValue.obj(),
      dafny.DafnySequence.asString(nativeValue.objMessage())
    );
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

  public static AuthItem AuthItem(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthItem nativeValue
  ) {
    DafnySequence<? extends PathSegment> key;
    key = ToDafny.Path(nativeValue.key());
    StructuredDataTerminal data;
    data = ToDafny.StructuredDataTerminal(nativeValue.data());
    AuthenticateAction action;
    action = ToDafny.AuthenticateAction(nativeValue.action());
    return new AuthItem(key, data, action);
  }

  public static CryptoItem CryptoItem(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem nativeValue
  ) {
    DafnySequence<? extends PathSegment> key;
    key = ToDafny.Path(nativeValue.key());
    StructuredDataTerminal data;
    data = ToDafny.StructuredDataTerminal(nativeValue.data());
    CryptoAction action;
    action = ToDafny.CryptoAction(nativeValue.action());
    return new CryptoItem(key, data, action);
  }

  public static DecryptPathStructureInput DecryptPathStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptPathStructureInput nativeValue
  ) {
    DafnySequence<? extends Character> tableName;
    tableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.tableName()
      );
    DafnySequence<? extends AuthItem> encryptedStructure;
    encryptedStructure = ToDafny.AuthList(nativeValue.encryptedStructure());
    ICryptographicMaterialsManager cmm;
    cmm =
      software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(
        nativeValue.cmm()
      );
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
          DafnyMap._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE),
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE)
          ),
          software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(
            nativeValue.encryptionContext()
          )
        )
        : Option.create_None(
          DafnyMap._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE),
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE)
          )
        );
    return new DecryptPathStructureInput(
      tableName,
      encryptedStructure,
      cmm,
      encryptionContext
    );
  }

  public static DecryptPathStructureOutput DecryptPathStructureOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptPathStructureOutput nativeValue
  ) {
    DafnySequence<? extends CryptoItem> plaintextStructure;
    plaintextStructure = ToDafny.CryptoList(nativeValue.plaintextStructure());
    ParsedHeader parsedHeader;
    parsedHeader = ToDafny.ParsedHeader(nativeValue.parsedHeader());
    return new DecryptPathStructureOutput(plaintextStructure, parsedHeader);
  }

  public static DecryptStructureInput DecryptStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureInput nativeValue
  ) {
    DafnySequence<? extends Character> tableName;
    tableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.tableName()
      );
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends StructuredDataTerminal
    > encryptedStructure;
    encryptedStructure =
      ToDafny.StructuredDataMap(nativeValue.encryptedStructure());
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends AuthenticateAction
    > authenticateSchema;
    authenticateSchema =
      ToDafny.AuthenticateSchemaMap(nativeValue.authenticateSchema());
    ICryptographicMaterialsManager cmm;
    cmm =
      software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(
        nativeValue.cmm()
      );
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
          DafnyMap._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE),
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE)
          ),
          software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(
            nativeValue.encryptionContext()
          )
        )
        : Option.create_None(
          DafnyMap._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE),
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE)
          )
        );
    return new DecryptStructureInput(
      tableName,
      encryptedStructure,
      authenticateSchema,
      cmm,
      encryptionContext
    );
  }

  public static DecryptStructureOutput DecryptStructureOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureOutput nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends StructuredDataTerminal
    > plaintextStructure;
    plaintextStructure =
      ToDafny.StructuredDataMap(nativeValue.plaintextStructure());
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends CryptoAction
    > cryptoSchema;
    cryptoSchema = ToDafny.CryptoSchemaMap(nativeValue.cryptoSchema());
    ParsedHeader parsedHeader;
    parsedHeader = ToDafny.ParsedHeader(nativeValue.parsedHeader());
    return new DecryptStructureOutput(
      plaintextStructure,
      cryptoSchema,
      parsedHeader
    );
  }

  public static EncryptPathStructureInput EncryptPathStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptPathStructureInput nativeValue
  ) {
    DafnySequence<? extends Character> tableName;
    tableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.tableName()
      );
    DafnySequence<? extends CryptoItem> plaintextStructure;
    plaintextStructure = ToDafny.CryptoList(nativeValue.plaintextStructure());
    ICryptographicMaterialsManager cmm;
    cmm =
      software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(
        nativeValue.cmm()
      );
    Option<DBEAlgorithmSuiteId> algorithmSuiteId;
    algorithmSuiteId =
      Objects.nonNull(nativeValue.algorithmSuiteId())
        ? Option.create_Some(
          DBEAlgorithmSuiteId._typeDescriptor(),
          software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(
            nativeValue.algorithmSuiteId()
          )
        )
        : Option.create_None(DBEAlgorithmSuiteId._typeDescriptor());
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
          DafnyMap._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE),
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE)
          ),
          software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(
            nativeValue.encryptionContext()
          )
        )
        : Option.create_None(
          DafnyMap._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE),
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE)
          )
        );
    return new EncryptPathStructureInput(
      tableName,
      plaintextStructure,
      cmm,
      algorithmSuiteId,
      encryptionContext
    );
  }

  public static EncryptPathStructureOutput EncryptPathStructureOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptPathStructureOutput nativeValue
  ) {
    DafnySequence<? extends CryptoItem> encryptedStructure;
    encryptedStructure = ToDafny.CryptoList(nativeValue.encryptedStructure());
    ParsedHeader parsedHeader;
    parsedHeader = ToDafny.ParsedHeader(nativeValue.parsedHeader());
    return new EncryptPathStructureOutput(encryptedStructure, parsedHeader);
  }

  public static EncryptStructureInput EncryptStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureInput nativeValue
  ) {
    DafnySequence<? extends Character> tableName;
    tableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.tableName()
      );
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends StructuredDataTerminal
    > plaintextStructure;
    plaintextStructure =
      ToDafny.StructuredDataMap(nativeValue.plaintextStructure());
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends CryptoAction
    > cryptoSchema;
    cryptoSchema = ToDafny.CryptoSchemaMap(nativeValue.cryptoSchema());
    ICryptographicMaterialsManager cmm;
    cmm =
      software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(
        nativeValue.cmm()
      );
    Option<DBEAlgorithmSuiteId> algorithmSuiteId;
    algorithmSuiteId =
      Objects.nonNull(nativeValue.algorithmSuiteId())
        ? Option.create_Some(
          DBEAlgorithmSuiteId._typeDescriptor(),
          software.amazon.cryptography.materialproviders.ToDafny.DBEAlgorithmSuiteId(
            nativeValue.algorithmSuiteId()
          )
        )
        : Option.create_None(DBEAlgorithmSuiteId._typeDescriptor());
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
          DafnyMap._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE),
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE)
          ),
          software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(
            nativeValue.encryptionContext()
          )
        )
        : Option.create_None(
          DafnyMap._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE),
            DafnySequence._typeDescriptor(TypeDescriptor.BYTE)
          )
        );
    return new EncryptStructureInput(
      tableName,
      plaintextStructure,
      cryptoSchema,
      cmm,
      algorithmSuiteId,
      encryptionContext
    );
  }

  public static EncryptStructureOutput EncryptStructureOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureOutput nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends StructuredDataTerminal
    > encryptedStructure;
    encryptedStructure =
      ToDafny.StructuredDataMap(nativeValue.encryptedStructure());
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends CryptoAction
    > cryptoSchema;
    cryptoSchema = ToDafny.CryptoSchemaMap(nativeValue.cryptoSchema());
    ParsedHeader parsedHeader;
    parsedHeader = ToDafny.ParsedHeader(nativeValue.parsedHeader());
    return new EncryptStructureOutput(
      encryptedStructure,
      cryptoSchema,
      parsedHeader
    );
  }

  public static ParsedHeader ParsedHeader(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ParsedHeader nativeValue
  ) {
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
      algorithmSuiteId,
      encryptedDataKeys,
      storedEncryptionContext,
      encryptionContext
    );
  }

  public static ResolveAuthActionsInput ResolveAuthActionsInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ResolveAuthActionsInput nativeValue
  ) {
    DafnySequence<? extends Character> tableName;
    tableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.tableName()
      );
    DafnySequence<? extends AuthItem> authActions;
    authActions = ToDafny.AuthList(nativeValue.authActions());
    DafnySequence<? extends Byte> headerBytes;
    headerBytes =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.ByteSequence(
        nativeValue.headerBytes()
      );
    return new ResolveAuthActionsInput(tableName, authActions, headerBytes);
  }

  public static ResolveAuthActionsOutput ResolveAuthActionsOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ResolveAuthActionsOutput nativeValue
  ) {
    DafnySequence<? extends CryptoItem> cryptoActions;
    cryptoActions = ToDafny.CryptoList(nativeValue.cryptoActions());
    return new ResolveAuthActionsOutput(cryptoActions);
  }

  public static StructuredDataTerminal StructuredDataTerminal(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal nativeValue
  ) {
    DafnySequence<? extends Byte> value;
    value =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.ByteSequence(
        nativeValue.value()
      );
    DafnySequence<? extends Byte> typeId;
    typeId =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.ByteSequence(
        nativeValue.typeId()
      );
    return new StructuredDataTerminal(value, typeId);
  }

  public static StructuredEncryptionConfig StructuredEncryptionConfig(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionConfig nativeValue
  ) {
    return new StructuredEncryptionConfig();
  }

  public static StructureSegment StructureSegment(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructureSegment nativeValue
  ) {
    DafnySequence<? extends Character> key;
    key =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.key()
      );
    return new StructureSegment(key);
  }

  public static Error Error(StructuredEncryptionException nativeValue) {
    DafnySequence<? extends Character> message;
    message =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.message()
      );
    return new Error_StructuredEncryptionException(message);
  }

  public static AuthenticateAction AuthenticateAction(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction nativeValue
  ) {
    switch (nativeValue) {
      case SIGN:
        {
          return AuthenticateAction.create_SIGN();
        }
      case DO_NOT_SIGN:
        {
          return AuthenticateAction.create_DO__NOT__SIGN();
        }
      default:
        {
          throw new RuntimeException(
            "Cannot convert " +
            nativeValue +
            " to software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction."
          );
        }
    }
  }

  public static CryptoAction CryptoAction(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction nativeValue
  ) {
    switch (nativeValue) {
      case ENCRYPT_AND_SIGN:
        {
          return CryptoAction.create_ENCRYPT__AND__SIGN();
        }
      case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT:
        {
          return CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT();
        }
      case SIGN_ONLY:
        {
          return CryptoAction.create_SIGN__ONLY();
        }
      case DO_NOTHING:
        {
          return CryptoAction.create_DO__NOTHING();
        }
      default:
        {
          throw new RuntimeException(
            "Cannot convert " +
            nativeValue +
            " to software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction."
          );
        }
    }
  }

  public static PathSegment PathSegment(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment nativeValue
  ) {
    if (Objects.nonNull(nativeValue.member())) {
      return PathSegment.create(ToDafny.StructureSegment(nativeValue.member()));
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment."
    );
  }

  public static DafnySequence<? extends AuthItem> AuthList(
    List<
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthItem
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::AuthItem,
      AuthItem._typeDescriptor()
    );
  }

  public static DafnySequence<? extends CryptoItem> CryptoList(
    List<
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::CryptoItem,
      CryptoItem._typeDescriptor()
    );
  }

  public static DafnySequence<? extends PathSegment> Path(
    List<
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::PathSegment,
      PathSegment._typeDescriptor()
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends AuthenticateAction
  > AuthenticateSchemaMap(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::AuthenticateAction
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends CryptoAction
  > CryptoSchemaMap(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::CryptoAction
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends StructuredDataTerminal
  > StructuredDataMap(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::StructuredDataTerminal
    );
  }

  public static IStructuredEncryptionClient StructuredEncryption(
    StructuredEncryption nativeValue
  ) {
    return nativeValue.impl();
  }
}
