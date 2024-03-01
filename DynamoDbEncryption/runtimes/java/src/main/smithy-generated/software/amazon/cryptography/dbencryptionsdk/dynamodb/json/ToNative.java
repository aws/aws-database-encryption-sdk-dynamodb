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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.Action;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.DecryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EncryptObjectOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.EsdkEncrypt;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.Json;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncrypt;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.JsonEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model.ParsedHeader;

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

  public static DecryptObjectInput DecryptObjectInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectInput dafnyValue
  ) {
    DecryptObjectInput.Builder nativeBuilder = DecryptObjectInput.builder();
    nativeBuilder.encryptedObject(
      ToNative.Json(dafnyValue.dtor_encryptedObject())
    );
    return nativeBuilder.build();
  }

  public static DecryptObjectOutput DecryptObjectOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.DecryptObjectOutput dafnyValue
  ) {
    DecryptObjectOutput.Builder nativeBuilder = DecryptObjectOutput.builder();
    nativeBuilder.plaintextObject(
      ToNative.Json(dafnyValue.dtor_plaintextObject())
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
      ToNative.Json(dafnyValue.dtor_plaintextObject())
    );
    return nativeBuilder.build();
  }

  public static EncryptObjectOutput EncryptObjectOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EncryptObjectOutput dafnyValue
  ) {
    EncryptObjectOutput.Builder nativeBuilder = EncryptObjectOutput.builder();
    nativeBuilder.encryptedObject(
      ToNative.Json(dafnyValue.dtor_encryptedObject())
    );
    if (dafnyValue.dtor_parsedHeader().is_Some()) {
      nativeBuilder.parsedHeader(
        ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static EsdkEncrypt EsdkEncrypt(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.EsdkEncrypt dafnyValue
  ) {
    EsdkEncrypt.Builder nativeBuilder = EsdkEncrypt.builder();
    if (dafnyValue.dtor_encryptionContext().is_Some()) {
      nativeBuilder.encryptionContext(
        software.amazon.cryptography.materialproviders.ToNative.EncryptionContext(
          dafnyValue.dtor_encryptionContext().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_materialsManager().is_Some()) {
      nativeBuilder.materialsManager(
        software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
          dafnyValue.dtor_materialsManager().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_keyring().is_Some()) {
      nativeBuilder.keyring(
        software.amazon.cryptography.materialproviders.ToNative.Keyring(
          dafnyValue.dtor_keyring().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(
        software.amazon.cryptography.materialproviders.ToNative.ESDKAlgorithmSuiteId(
          dafnyValue.dtor_algorithmSuiteId().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_frameLength().is_Some()) {
      nativeBuilder.frameLength((dafnyValue.dtor_frameLength().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static JsonEncrypt JsonEncrypt(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncrypt dafnyValue
  ) {
    JsonEncrypt.Builder nativeBuilder = JsonEncrypt.builder();
    if (dafnyValue.dtor_keyring().is_Some()) {
      nativeBuilder.keyring(
        software.amazon.cryptography.materialproviders.ToNative.Keyring(
          dafnyValue.dtor_keyring().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_cmm().is_Some()) {
      nativeBuilder.cmm(
        software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
          dafnyValue.dtor_cmm().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(
        software.amazon.cryptography.materialproviders.ToNative.DBEAlgorithmSuiteId(
          dafnyValue.dtor_algorithmSuiteId().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_signedValue().is_Some()) {
      nativeBuilder.signedValue(
        ToNative.SignedValues(dafnyValue.dtor_signedValue().dtor_value())
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

  public static JsonEncryptorConfig JsonEncryptorConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.JsonEncryptorConfig dafnyValue
  ) {
    JsonEncryptorConfig.Builder nativeBuilder = JsonEncryptorConfig.builder();
    nativeBuilder.domain(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_domain()
      )
    );
    nativeBuilder.attributeActionsOnEncrypt(
      ToNative.AttributeActions(dafnyValue.dtor_attributeActionsOnEncrypt())
    );
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
    nativeBuilder.encrypt(ToNative.JsonEncrypt(dafnyValue.dtor_encrypt()));
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

  public static Action Action(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action dafnyValue
  ) {
    Action.Builder nativeBuilder = Action.builder();
    if (dafnyValue.is_crypto()) {
      nativeBuilder.crypto(
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative.CryptoAction(
          dafnyValue.dtor_crypto()
        )
      );
    }
    if (dafnyValue.is_esdk()) {
      nativeBuilder.esdk(ToNative.EsdkEncrypt(dafnyValue.dtor_esdk()));
    }
    if (dafnyValue.is_dbesdk()) {
      nativeBuilder.dbesdk(ToNative.JsonEncrypt(dafnyValue.dtor_dbesdk()));
    }
    return nativeBuilder.build();
  }

  public static Json Json(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Json dafnyValue
  ) {
    Json.Builder nativeBuilder = Json.builder();
    if (dafnyValue.is_utf8()) {
      nativeBuilder.utf8(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.DafnyUtf8Bytes(
          dafnyValue.dtor_utf8()
        )
      );
    }
    if (dafnyValue.is_text()) {
      nativeBuilder.text(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_text()
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

  public static Map<String, Action> AttributeActions(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.json.internaldafny.types.Action
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.cryptography.dbencryptionsdk.dynamodb.json.ToNative::Action
    );
  }

  public static Map<String, String> SignedValues(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends DafnySequence<? extends Character>
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String
    );
  }

  public static JsonEncryptor JsonEncryptor(IJsonEncryptorClient dafnyValue) {
    return new JsonEncryptor(dafnyValue);
  }
}
