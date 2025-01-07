// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_Opaque;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_OpaqueWithText;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptPathStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptPathStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptPathStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptPathStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.OpaqueWithTextError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ResolveAuthActionsInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ResolveAuthActionsOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructureSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionException;

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

  public static StructuredEncryptionException Error(
    Error_StructuredEncryptionException dafnyValue
  ) {
    StructuredEncryptionException.Builder nativeBuilder =
      StructuredEncryptionException.builder();
    nativeBuilder.message(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_message()
      )
    );
    return nativeBuilder.build();
  }

  public static RuntimeException Error(Error dafnyValue) {
    if (dafnyValue.is_StructuredEncryptionException()) {
      return ToNative.Error((Error_StructuredEncryptionException) dafnyValue);
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
    if (dafnyValue.is_AwsCryptographyMaterialProviders()) {
      return software.amazon.cryptography.materialproviders.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyMaterialProviders()
      );
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static AuthItem AuthItem(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem dafnyValue
  ) {
    AuthItem.Builder nativeBuilder = AuthItem.builder();
    nativeBuilder.key(ToNative.Path(dafnyValue.dtor_key()));
    nativeBuilder.data(ToNative.StructuredDataTerminal(dafnyValue.dtor_data()));
    nativeBuilder.action(ToNative.AuthenticateAction(dafnyValue.dtor_action()));
    return nativeBuilder.build();
  }

  public static CryptoItem CryptoItem(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem dafnyValue
  ) {
    CryptoItem.Builder nativeBuilder = CryptoItem.builder();
    nativeBuilder.key(ToNative.Path(dafnyValue.dtor_key()));
    nativeBuilder.data(ToNative.StructuredDataTerminal(dafnyValue.dtor_data()));
    nativeBuilder.action(ToNative.CryptoAction(dafnyValue.dtor_action()));
    return nativeBuilder.build();
  }

  public static DecryptPathStructureInput DecryptPathStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureInput dafnyValue
  ) {
    DecryptPathStructureInput.Builder nativeBuilder =
      DecryptPathStructureInput.builder();
    nativeBuilder.tableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_tableName()
      )
    );
    nativeBuilder.encryptedStructure(
      ToNative.AuthList(dafnyValue.dtor_encryptedStructure())
    );
    nativeBuilder.cmm(
      software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
        dafnyValue.dtor_cmm()
      )
    );
    if (dafnyValue.dtor_encryptionContext().is_Some()) {
      nativeBuilder.encryptionContext(
        software.amazon.cryptography.materialproviders.ToNative.EncryptionContext(
          dafnyValue.dtor_encryptionContext().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static DecryptPathStructureOutput DecryptPathStructureOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput dafnyValue
  ) {
    DecryptPathStructureOutput.Builder nativeBuilder =
      DecryptPathStructureOutput.builder();
    nativeBuilder.plaintextStructure(
      ToNative.CryptoList(dafnyValue.dtor_plaintextStructure())
    );
    nativeBuilder.parsedHeader(
      ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader())
    );
    return nativeBuilder.build();
  }

  public static DecryptStructureInput DecryptStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput dafnyValue
  ) {
    DecryptStructureInput.Builder nativeBuilder =
      DecryptStructureInput.builder();
    nativeBuilder.tableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_tableName()
      )
    );
    nativeBuilder.encryptedStructure(
      ToNative.StructuredDataMap(dafnyValue.dtor_encryptedStructure())
    );
    nativeBuilder.authenticateSchema(
      ToNative.AuthenticateSchemaMap(dafnyValue.dtor_authenticateSchema())
    );
    nativeBuilder.cmm(
      software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
        dafnyValue.dtor_cmm()
      )
    );
    if (dafnyValue.dtor_encryptionContext().is_Some()) {
      nativeBuilder.encryptionContext(
        software.amazon.cryptography.materialproviders.ToNative.EncryptionContext(
          dafnyValue.dtor_encryptionContext().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static DecryptStructureOutput DecryptStructureOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput dafnyValue
  ) {
    DecryptStructureOutput.Builder nativeBuilder =
      DecryptStructureOutput.builder();
    nativeBuilder.plaintextStructure(
      ToNative.StructuredDataMap(dafnyValue.dtor_plaintextStructure())
    );
    nativeBuilder.cryptoSchema(
      ToNative.CryptoSchemaMap(dafnyValue.dtor_cryptoSchema())
    );
    nativeBuilder.parsedHeader(
      ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader())
    );
    return nativeBuilder.build();
  }

  public static EncryptPathStructureInput EncryptPathStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureInput dafnyValue
  ) {
    EncryptPathStructureInput.Builder nativeBuilder =
      EncryptPathStructureInput.builder();
    nativeBuilder.tableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_tableName()
      )
    );
    nativeBuilder.plaintextStructure(
      ToNative.CryptoList(dafnyValue.dtor_plaintextStructure())
    );
    nativeBuilder.cmm(
      software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
        dafnyValue.dtor_cmm()
      )
    );
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(
        software.amazon.cryptography.materialproviders.ToNative.DBEAlgorithmSuiteId(
          dafnyValue.dtor_algorithmSuiteId().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_encryptionContext().is_Some()) {
      nativeBuilder.encryptionContext(
        software.amazon.cryptography.materialproviders.ToNative.EncryptionContext(
          dafnyValue.dtor_encryptionContext().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static EncryptPathStructureOutput EncryptPathStructureOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput dafnyValue
  ) {
    EncryptPathStructureOutput.Builder nativeBuilder =
      EncryptPathStructureOutput.builder();
    nativeBuilder.encryptedStructure(
      ToNative.CryptoList(dafnyValue.dtor_encryptedStructure())
    );
    nativeBuilder.parsedHeader(
      ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader())
    );
    return nativeBuilder.build();
  }

  public static EncryptStructureInput EncryptStructureInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput dafnyValue
  ) {
    EncryptStructureInput.Builder nativeBuilder =
      EncryptStructureInput.builder();
    nativeBuilder.tableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_tableName()
      )
    );
    nativeBuilder.plaintextStructure(
      ToNative.StructuredDataMap(dafnyValue.dtor_plaintextStructure())
    );
    nativeBuilder.cryptoSchema(
      ToNative.CryptoSchemaMap(dafnyValue.dtor_cryptoSchema())
    );
    nativeBuilder.cmm(
      software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
        dafnyValue.dtor_cmm()
      )
    );
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(
        software.amazon.cryptography.materialproviders.ToNative.DBEAlgorithmSuiteId(
          dafnyValue.dtor_algorithmSuiteId().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_encryptionContext().is_Some()) {
      nativeBuilder.encryptionContext(
        software.amazon.cryptography.materialproviders.ToNative.EncryptionContext(
          dafnyValue.dtor_encryptionContext().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static EncryptStructureOutput EncryptStructureOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput dafnyValue
  ) {
    EncryptStructureOutput.Builder nativeBuilder =
      EncryptStructureOutput.builder();
    nativeBuilder.encryptedStructure(
      ToNative.StructuredDataMap(dafnyValue.dtor_encryptedStructure())
    );
    nativeBuilder.cryptoSchema(
      ToNative.CryptoSchemaMap(dafnyValue.dtor_cryptoSchema())
    );
    nativeBuilder.parsedHeader(
      ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader())
    );
    return nativeBuilder.build();
  }

  public static ParsedHeader ParsedHeader(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ParsedHeader dafnyValue
  ) {
    ParsedHeader.Builder nativeBuilder = ParsedHeader.builder();
    nativeBuilder.algorithmSuiteId(
      software.amazon.cryptography.materialproviders.ToNative.DBEAlgorithmSuiteId(
        dafnyValue.dtor_algorithmSuiteId()
      )
    );
    nativeBuilder.encryptedDataKeys(
      software.amazon.cryptography.materialproviders.ToNative.EncryptedDataKeyList(
        dafnyValue.dtor_encryptedDataKeys()
      )
    );
    nativeBuilder.storedEncryptionContext(
      software.amazon.cryptography.materialproviders.ToNative.EncryptionContext(
        dafnyValue.dtor_storedEncryptionContext()
      )
    );
    nativeBuilder.encryptionContext(
      software.amazon.cryptography.materialproviders.ToNative.EncryptionContext(
        dafnyValue.dtor_encryptionContext()
      )
    );
    return nativeBuilder.build();
  }

  public static ResolveAuthActionsInput ResolveAuthActionsInput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsInput dafnyValue
  ) {
    ResolveAuthActionsInput.Builder nativeBuilder =
      ResolveAuthActionsInput.builder();
    nativeBuilder.tableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_tableName()
      )
    );
    nativeBuilder.authActions(ToNative.AuthList(dafnyValue.dtor_authActions()));
    nativeBuilder.headerBytes(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.ByteBuffer(
        dafnyValue.dtor_headerBytes()
      )
    );
    return nativeBuilder.build();
  }

  public static ResolveAuthActionsOutput ResolveAuthActionsOutput(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput dafnyValue
  ) {
    ResolveAuthActionsOutput.Builder nativeBuilder =
      ResolveAuthActionsOutput.builder();
    nativeBuilder.cryptoActions(
      ToNative.CryptoList(dafnyValue.dtor_cryptoActions())
    );
    return nativeBuilder.build();
  }

  public static StructuredDataTerminal StructuredDataTerminal(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal dafnyValue
  ) {
    StructuredDataTerminal.Builder nativeBuilder =
      StructuredDataTerminal.builder();
    nativeBuilder.value(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.ByteBuffer(
        dafnyValue.dtor_value()
      )
    );
    nativeBuilder.typeId(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.ByteBuffer(
        dafnyValue.dtor_typeId()
      )
    );
    return nativeBuilder.build();
  }

  public static StructuredEncryptionConfig StructuredEncryptionConfig(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig dafnyValue
  ) {
    StructuredEncryptionConfig.Builder nativeBuilder =
      StructuredEncryptionConfig.builder();
    return nativeBuilder.build();
  }

  public static StructureSegment StructureSegment(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment dafnyValue
  ) {
    StructureSegment.Builder nativeBuilder = StructureSegment.builder();
    nativeBuilder.key(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_key()
      )
    );
    return nativeBuilder.build();
  }

  public static AuthenticateAction AuthenticateAction(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction dafnyValue
  ) {
    if (dafnyValue.is_SIGN()) {
      return AuthenticateAction.SIGN;
    }
    if (dafnyValue.is_DO__NOT__SIGN()) {
      return AuthenticateAction.DO_NOT_SIGN;
    }
    throw new IllegalArgumentException(
      "No entry of software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction matches the input : " +
      dafnyValue
    );
  }

  public static CryptoAction CryptoAction(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction dafnyValue
  ) {
    if (dafnyValue.is_ENCRYPT__AND__SIGN()) {
      return CryptoAction.ENCRYPT_AND_SIGN;
    }
    if (dafnyValue.is_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()) {
      return CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT;
    }
    if (dafnyValue.is_SIGN__ONLY()) {
      return CryptoAction.SIGN_ONLY;
    }
    if (dafnyValue.is_DO__NOTHING()) {
      return CryptoAction.DO_NOTHING;
    }
    throw new IllegalArgumentException(
      "No entry of software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction matches the input : " +
      dafnyValue
    );
  }

  public static PathSegment PathSegment(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment dafnyValue
  ) {
    PathSegment.Builder nativeBuilder = PathSegment.builder();
    if (dafnyValue.is_member()) {
      nativeBuilder.member(ToNative.StructureSegment(dafnyValue.dtor_member()));
    }
    return nativeBuilder.build();
  }

  public static List<AuthItem> AuthList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::AuthItem
    );
  }

  public static List<CryptoItem> CryptoList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::CryptoItem
    );
  }

  public static List<PathSegment> Path(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::PathSegment
    );
  }

  public static Map<String, AuthenticateAction> AuthenticateSchemaMap(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::AuthenticateAction
    );
  }

  public static Map<String, CryptoAction> CryptoSchemaMap(
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

  public static Map<String, StructuredDataTerminal> StructuredDataMap(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::StructuredDataTerminal
    );
  }

  public static StructuredEncryption StructuredEncryption(
    IStructuredEncryptionClient dafnyValue
  ) {
    return new StructuredEncryption(dafnyValue);
  }
}
