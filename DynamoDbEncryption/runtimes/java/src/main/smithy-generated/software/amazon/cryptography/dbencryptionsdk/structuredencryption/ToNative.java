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
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error_StructuredEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateSchema;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateSchemaContent;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoSchema;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoSchemaContent;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredData;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataContent;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionException;

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

  public static AuthenticateSchema AuthenticateSchema(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateSchema dafnyValue
  ) {
    AuthenticateSchema.Builder nativeBuilder = AuthenticateSchema.builder();
    nativeBuilder.content(
      ToNative.AuthenticateSchemaContent(dafnyValue.dtor_content())
    );
    if (dafnyValue.dtor_attributes().is_Some()) {
      nativeBuilder.attributes(
        ToNative.AuthenticateSchemaAttributes(
          dafnyValue.dtor_attributes().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static CryptoSchema CryptoSchema(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoSchema dafnyValue
  ) {
    CryptoSchema.Builder nativeBuilder = CryptoSchema.builder();
    nativeBuilder.content(
      ToNative.CryptoSchemaContent(dafnyValue.dtor_content())
    );
    if (dafnyValue.dtor_attributes().is_Some()) {
      nativeBuilder.attributes(
        ToNative.CryptoSchemaAttributes(
          dafnyValue.dtor_attributes().dtor_value()
        )
      );
    }
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
      ToNative.StructuredData(dafnyValue.dtor_encryptedStructure())
    );
    nativeBuilder.authenticateSchema(
      ToNative.AuthenticateSchema(dafnyValue.dtor_authenticateSchema())
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
      ToNative.StructuredData(dafnyValue.dtor_plaintextStructure())
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
      ToNative.StructuredData(dafnyValue.dtor_plaintextStructure())
    );
    nativeBuilder.cryptoSchema(
      ToNative.CryptoSchema(dafnyValue.dtor_cryptoSchema())
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
      ToNative.StructuredData(dafnyValue.dtor_encryptedStructure())
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
    nativeBuilder.cryptoSchema(
      ToNative.CryptoSchema(dafnyValue.dtor_cryptoSchema())
    );
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
    return nativeBuilder.build();
  }

  public static StructuredData StructuredData(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredData dafnyValue
  ) {
    StructuredData.Builder nativeBuilder = StructuredData.builder();
    nativeBuilder.content(
      ToNative.StructuredDataContent(dafnyValue.dtor_content())
    );
    if (dafnyValue.dtor_attributes().is_Some()) {
      nativeBuilder.attributes(
        ToNative.StructuredDataAttributes(
          dafnyValue.dtor_attributes().dtor_value()
        )
      );
    }
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

  public static AuthenticateSchemaContent AuthenticateSchemaContent(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateSchemaContent dafnyValue
  ) {
    AuthenticateSchemaContent.Builder nativeBuilder =
      AuthenticateSchemaContent.builder();
    if (dafnyValue.is_Action()) {
      nativeBuilder.Action(
        ToNative.AuthenticateAction(dafnyValue.dtor_Action())
      );
    }
    if (dafnyValue.is_SchemaMap()) {
      nativeBuilder.SchemaMap(
        ToNative.AuthenticateSchemaMap(dafnyValue.dtor_SchemaMap())
      );
    }
    if (dafnyValue.is_SchemaList()) {
      nativeBuilder.SchemaList(
        ToNative.AuthenticateSchemaList(dafnyValue.dtor_SchemaList())
      );
    }
    return nativeBuilder.build();
  }

  public static CryptoSchemaContent CryptoSchemaContent(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoSchemaContent dafnyValue
  ) {
    CryptoSchemaContent.Builder nativeBuilder = CryptoSchemaContent.builder();
    if (dafnyValue.is_Action()) {
      nativeBuilder.Action(ToNative.CryptoAction(dafnyValue.dtor_Action()));
    }
    if (dafnyValue.is_SchemaMap()) {
      nativeBuilder.SchemaMap(
        ToNative.CryptoSchemaMap(dafnyValue.dtor_SchemaMap())
      );
    }
    if (dafnyValue.is_SchemaList()) {
      nativeBuilder.SchemaList(
        ToNative.CryptoSchemaList(dafnyValue.dtor_SchemaList())
      );
    }
    return nativeBuilder.build();
  }

  public static StructuredDataContent StructuredDataContent(
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataContent dafnyValue
  ) {
    StructuredDataContent.Builder nativeBuilder =
      StructuredDataContent.builder();
    if (dafnyValue.is_Terminal()) {
      nativeBuilder.Terminal(
        ToNative.StructuredDataTerminal(dafnyValue.dtor_Terminal())
      );
    }
    if (dafnyValue.is_DataList()) {
      nativeBuilder.DataList(
        ToNative.StructuredDataList(dafnyValue.dtor_DataList())
      );
    }
    if (dafnyValue.is_DataMap()) {
      nativeBuilder.DataMap(
        ToNative.StructuredDataMap(dafnyValue.dtor_DataMap())
      );
    }
    return nativeBuilder.build();
  }

  public static List<AuthenticateSchema> AuthenticateSchemaList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateSchema
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::AuthenticateSchema
    );
  }

  public static List<CryptoSchema> CryptoSchemaList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoSchema
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::CryptoSchema
    );
  }

  public static List<StructuredData> StructuredDataList(
    DafnySequence<
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredData
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::StructuredData
    );
  }

  public static Map<String, AuthenticateAction> AuthenticateSchemaAttributes(
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

  public static Map<String, AuthenticateSchema> AuthenticateSchemaMap(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateSchema
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::AuthenticateSchema
    );
  }

  public static Map<String, AuthenticateAction> CryptoSchemaAttributes(
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

  public static Map<String, CryptoSchema> CryptoSchemaMap(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoSchema
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::CryptoSchema
    );
  }

  public static Map<String, StructuredDataTerminal> StructuredDataAttributes(
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

  public static Map<String, StructuredData> StructuredDataMap(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredData
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative::StructuredData
    );
  }

  public static StructuredEncryption StructuredEncryption(
    IStructuredEncryptionClient dafnyValue
  ) {
    return new StructuredEncryption(dafnyValue);
  }
}
