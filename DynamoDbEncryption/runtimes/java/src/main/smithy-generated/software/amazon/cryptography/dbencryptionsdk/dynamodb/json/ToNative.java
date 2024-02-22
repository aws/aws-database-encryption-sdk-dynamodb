// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json;

import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_JsonEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Error_Opaque;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.IJsonEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.Actions;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DefaultAction;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.ExplicitUnsigned;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.KeyAccess;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

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

  public static JsonEncryptorException Error(
    Error_JsonEncryptorException dafnyValue
  ) {
    JsonEncryptorException.Builder nativeBuilder =
      JsonEncryptorException.builder();
    nativeBuilder.message(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_message()
      )
    );
    return nativeBuilder.build();
  }

  public static RuntimeException Error(Error dafnyValue) {
    if (dafnyValue.is_JsonEncryptorException()) {
      return ToNative.Error((Error_JsonEncryptorException) dafnyValue);
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
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkStructuredEncryption()) {
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption()
      );
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static Actions Actions(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Actions dafnyValue
  ) {
    Actions.Builder nativeBuilder = Actions.builder();
    nativeBuilder.attributeActionsOnEncrypt(
      ToNative.AttributeActions(dafnyValue.dtor_attributeActionsOnEncrypt())
    );
    if (dafnyValue.dtor_nestedActionsOnEncrypt().is_Some()) {
      nativeBuilder.nestedActionsOnEncrypt(
        ToNative.NestedActions(
          dafnyValue.dtor_nestedActionsOnEncrypt().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_nestedEncryptors().is_Some()) {
      nativeBuilder.nestedEncryptors(
        ToNative.NestedEncryptors(
          dafnyValue.dtor_nestedEncryptors().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_eSDKActions().is_Some()) {
      nativeBuilder.eSDKActions(
        ToNative.ESDKActions(dafnyValue.dtor_eSDKActions().dtor_value())
      );
    }
    if (dafnyValue.dtor_defaultAction().is_Some()) {
      nativeBuilder.defaultAction(
        ToNative.DefaultAction(dafnyValue.dtor_defaultAction().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static DecryptObjectInput DecryptObjectInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectInput dafnyValue
  ) {
    DecryptObjectInput.Builder nativeBuilder = DecryptObjectInput.builder();
    nativeBuilder.encryptedObject(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_encryptedObject()
      )
    );
    return nativeBuilder.build();
  }

  public static DecryptObjectOutput DecryptObjectOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectOutput dafnyValue
  ) {
    DecryptObjectOutput.Builder nativeBuilder = DecryptObjectOutput.builder();
    nativeBuilder.plaintextObject(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_plaintextObject()
      )
    );
    if (dafnyValue.dtor_parsedHeader().is_Some()) {
      nativeBuilder.parsedHeader(
        ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static EncryptObjectInput EncryptObjectInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectInput dafnyValue
  ) {
    EncryptObjectInput.Builder nativeBuilder = EncryptObjectInput.builder();
    nativeBuilder.plaintextObject(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_plaintextObject()
      )
    );
    return nativeBuilder.build();
  }

  public static EncryptObjectOutput EncryptObjectOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectOutput dafnyValue
  ) {
    EncryptObjectOutput.Builder nativeBuilder = EncryptObjectOutput.builder();
    nativeBuilder.encryptedObject(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_encryptedObject()
      )
    );
    if (dafnyValue.dtor_parsedHeader().is_Some()) {
      nativeBuilder.parsedHeader(
        ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static ExplicitUnsigned ExplicitUnsigned(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.ExplicitUnsigned dafnyValue
  ) {
    ExplicitUnsigned.Builder nativeBuilder = ExplicitUnsigned.builder();
    if (dafnyValue.dtor_allowedUnsignedAttributes().is_Some()) {
      nativeBuilder.allowedUnsignedAttributes(
        ToNative.AttributeNameList(
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
    return nativeBuilder.build();
  }

  public static JsonEncryptorConfig JsonEncryptorConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig dafnyValue
  ) {
    JsonEncryptorConfig.Builder nativeBuilder = JsonEncryptorConfig.builder();
    nativeBuilder.logicalTableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_logicalTableName()
      )
    );
    nativeBuilder.actions(ToNative.Actions(dafnyValue.dtor_actions()));
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(
        software.amazon.cryptography.materialproviders.ToNative.DBEAlgorithmSuiteId(
          dafnyValue.dtor_algorithmSuiteId().dtor_value()
        )
      );
    }
    nativeBuilder.keyAccess(ToNative.KeyAccess(dafnyValue.dtor_keyAccess()));
    return nativeBuilder.build();
  }

  public static ParsedHeader ParsedHeader(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.ParsedHeader dafnyValue
  ) {
    ParsedHeader.Builder nativeBuilder = ParsedHeader.builder();
    nativeBuilder.attributeActionsOnEncrypt(
      ToNative.AttributeActions(dafnyValue.dtor_attributeActionsOnEncrypt())
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
    nativeBuilder.encryptionContext(
      software.amazon.cryptography.materialproviders.ToNative.EncryptionContext(
        dafnyValue.dtor_encryptionContext()
      )
    );
    return nativeBuilder.build();
  }

  public static DefaultAction DefaultAction(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DefaultAction dafnyValue
  ) {
    DefaultAction.Builder nativeBuilder = DefaultAction.builder();
    if (dafnyValue.is_explicitUnsigned()) {
      nativeBuilder.explicitUnsigned(
        ToNative.ExplicitUnsigned(dafnyValue.dtor_explicitUnsigned())
      );
    }
    if (dafnyValue.is_defaultAction()) {
      nativeBuilder.defaultAction(
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative.CryptoAction(
          dafnyValue.dtor_defaultAction()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static KeyAccess KeyAccess(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.KeyAccess dafnyValue
  ) {
    KeyAccess.Builder nativeBuilder = KeyAccess.builder();
    if (dafnyValue.is_keyring()) {
      nativeBuilder.keyring(
        software.amazon.cryptography.materialproviders.ToNative.Keyring(
          dafnyValue.dtor_keyring()
        )
      );
    }
    if (dafnyValue.is_cmm()) {
      nativeBuilder.cmm(
        software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
          dafnyValue.dtor_cmm()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static List<String> AttributeNameList(
    DafnySequence<? extends DafnySequence<? extends Character>> dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String
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

  public static Map<String, KeyAccess> ESDKActions(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.KeyAccess
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.ToNative::KeyAccess
    );
  }

  public static Map<String, Actions> NestedActions(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Actions
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.ToNative::Actions
    );
  }

  public static Map<String, JsonEncryptorConfig> NestedEncryptors(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.ToNative::JsonEncryptorConfig
    );
  }

  public static JsonEncryptor JsonEncryptor(IJsonEncryptorClient dafnyValue) {
    return new JsonEncryptor(dafnyValue);
  }
}
