// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Byte;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateSchema;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateSchemaContent;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoSchema;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoSchemaContent;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredData;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataContent;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.OpaqueError;
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

  public static AuthenticateSchema AuthenticateSchema(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateSchema nativeValue
  ) {
    AuthenticateSchemaContent content;
    content = ToDafny.AuthenticateSchemaContent(nativeValue.content());
    Option<
      DafnyMap<
        ? extends DafnySequence<? extends Character>,
        ? extends AuthenticateAction
      >
    > attributes;
    attributes =
      (Objects.nonNull(nativeValue.attributes()) &&
          nativeValue.attributes().size() > 0)
        ? Option.create_Some(
          ToDafny.AuthenticateSchemaAttributes(nativeValue.attributes())
        )
        : Option.create_None();
    return new AuthenticateSchema(content, attributes);
  }

  public static CryptoSchema CryptoSchema(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoSchema nativeValue
  ) {
    CryptoSchemaContent content;
    content = ToDafny.CryptoSchemaContent(nativeValue.content());
    Option<
      DafnyMap<
        ? extends DafnySequence<? extends Character>,
        ? extends AuthenticateAction
      >
    > attributes;
    attributes =
      (Objects.nonNull(nativeValue.attributes()) &&
          nativeValue.attributes().size() > 0)
        ? Option.create_Some(
          ToDafny.CryptoSchemaAttributes(nativeValue.attributes())
        )
        : Option.create_None();
    return new CryptoSchema(content, attributes);
  }

  public static DecryptStructureInput DecryptStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureInput nativeValue
  ) {
    DafnySequence<? extends Character> tableName;
    tableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.tableName()
      );
    StructuredData encryptedStructure;
    encryptedStructure =
      ToDafny.StructuredData(nativeValue.encryptedStructure());
    AuthenticateSchema authenticateSchema;
    authenticateSchema =
      ToDafny.AuthenticateSchema(nativeValue.authenticateSchema());
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
          software.amazon.cryptography.materialproviders.ToDafny.EncryptionContext(
            nativeValue.encryptionContext()
          )
        )
        : Option.create_None();
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
    StructuredData plaintextStructure;
    plaintextStructure =
      ToDafny.StructuredData(nativeValue.plaintextStructure());
    ParsedHeader parsedHeader;
    parsedHeader = ToDafny.ParsedHeader(nativeValue.parsedHeader());
    return new DecryptStructureOutput(plaintextStructure, parsedHeader);
  }

  public static EncryptStructureInput EncryptStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureInput nativeValue
  ) {
    DafnySequence<? extends Character> tableName;
    tableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.tableName()
      );
    StructuredData plaintextStructure;
    plaintextStructure =
      ToDafny.StructuredData(nativeValue.plaintextStructure());
    CryptoSchema cryptoSchema;
    cryptoSchema = ToDafny.CryptoSchema(nativeValue.cryptoSchema());
    ICryptographicMaterialsManager cmm;
    cmm =
      software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(
        nativeValue.cmm()
      );
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
    StructuredData encryptedStructure;
    encryptedStructure =
      ToDafny.StructuredData(nativeValue.encryptedStructure());
    ParsedHeader parsedHeader;
    parsedHeader = ToDafny.ParsedHeader(nativeValue.parsedHeader());
    return new EncryptStructureOutput(encryptedStructure, parsedHeader);
  }

  public static ParsedHeader ParsedHeader(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ParsedHeader nativeValue
  ) {
    CryptoSchema cryptoSchema;
    cryptoSchema = ToDafny.CryptoSchema(nativeValue.cryptoSchema());
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
      cryptoSchema,
      algorithmSuiteId,
      encryptedDataKeys,
      storedEncryptionContext,
      encryptionContext
    );
  }

  public static StructuredData StructuredData(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredData nativeValue
  ) {
    StructuredDataContent content;
    content = ToDafny.StructuredDataContent(nativeValue.content());
    Option<
      DafnyMap<
        ? extends DafnySequence<? extends Character>,
        ? extends StructuredDataTerminal
      >
    > attributes;
    attributes =
      (Objects.nonNull(nativeValue.attributes()) &&
          nativeValue.attributes().size() > 0)
        ? Option.create_Some(
          ToDafny.StructuredDataAttributes(nativeValue.attributes())
        )
        : Option.create_None();
    return new StructuredData(content, attributes);
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

  public static AuthenticateSchemaContent AuthenticateSchemaContent(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateSchemaContent nativeValue
  ) {
    if (Objects.nonNull(nativeValue.Action())) {
      return AuthenticateSchemaContent.create_Action(
        ToDafny.AuthenticateAction(nativeValue.Action())
      );
    }
    if (Objects.nonNull(nativeValue.SchemaMap())) {
      return AuthenticateSchemaContent.create_SchemaMap(
        ToDafny.AuthenticateSchemaMap(nativeValue.SchemaMap())
      );
    }
    if (Objects.nonNull(nativeValue.SchemaList())) {
      return AuthenticateSchemaContent.create_SchemaList(
        ToDafny.AuthenticateSchemaList(nativeValue.SchemaList())
      );
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateSchemaContent."
    );
  }

  public static CryptoSchemaContent CryptoSchemaContent(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoSchemaContent nativeValue
  ) {
    if (Objects.nonNull(nativeValue.Action())) {
      return CryptoSchemaContent.create_Action(
        ToDafny.CryptoAction(nativeValue.Action())
      );
    }
    if (Objects.nonNull(nativeValue.SchemaMap())) {
      return CryptoSchemaContent.create_SchemaMap(
        ToDafny.CryptoSchemaMap(nativeValue.SchemaMap())
      );
    }
    if (Objects.nonNull(nativeValue.SchemaList())) {
      return CryptoSchemaContent.create_SchemaList(
        ToDafny.CryptoSchemaList(nativeValue.SchemaList())
      );
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoSchemaContent."
    );
  }

  public static StructuredDataContent StructuredDataContent(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataContent nativeValue
  ) {
    if (Objects.nonNull(nativeValue.Terminal())) {
      return StructuredDataContent.create_Terminal(
        ToDafny.StructuredDataTerminal(nativeValue.Terminal())
      );
    }
    if (Objects.nonNull(nativeValue.DataList())) {
      return StructuredDataContent.create_DataList(
        ToDafny.StructuredDataList(nativeValue.DataList())
      );
    }
    if (Objects.nonNull(nativeValue.DataMap())) {
      return StructuredDataContent.create_DataMap(
        ToDafny.StructuredDataMap(nativeValue.DataMap())
      );
    }
    throw new IllegalArgumentException(
      "Cannot convert " +
      nativeValue +
      " to software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataContent."
    );
  }

  public static DafnySequence<
    ? extends AuthenticateSchema
  > AuthenticateSchemaList(
    List<
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateSchema
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::AuthenticateSchema,
      AuthenticateSchema._typeDescriptor()
    );
  }

  public static DafnySequence<? extends CryptoSchema> CryptoSchemaList(
    List<
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoSchema
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::CryptoSchema,
      CryptoSchema._typeDescriptor()
    );
  }

  public static DafnySequence<? extends StructuredData> StructuredDataList(
    List<
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredData
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToSequence(
      nativeValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::StructuredData,
      StructuredData._typeDescriptor()
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends AuthenticateAction
  > AuthenticateSchemaAttributes(
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
    ? extends AuthenticateSchema
  > AuthenticateSchemaMap(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateSchema
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::AuthenticateSchema
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends AuthenticateAction
  > CryptoSchemaAttributes(
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
    ? extends CryptoSchema
  > CryptoSchemaMap(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoSchema
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::CryptoSchema
    );
  }

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends StructuredDataTerminal
  > StructuredDataAttributes(
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

  public static DafnyMap<
    ? extends DafnySequence<? extends Character>,
    ? extends StructuredData
  > StructuredDataMap(
    Map<
      String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredData
    > nativeValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Aggregate.GenericToMap(
      nativeValue,
      software.amazon.smithy.dafny.conversion.ToDafny.Simple::CharacterSequence,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToDafny::StructuredData
    );
  }

  public static IStructuredEncryptionClient StructuredEncryption(
    StructuredEncryption nativeValue
  ) {
    return nativeValue.impl();
  }
}
