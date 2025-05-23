// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor;

import java.lang.RuntimeException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_Opaque;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_OpaqueWithText;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.OpaqueWithTextError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.ParsedHeader;

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

  public static DynamoDbItemEncryptorException Error(
    Error_DynamoDbItemEncryptorException dafnyValue
  ) {
    DynamoDbItemEncryptorException.Builder nativeBuilder =
      DynamoDbItemEncryptorException.builder();
    nativeBuilder.message(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_message()
      )
    );
    return nativeBuilder.build();
  }

  public static RuntimeException Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbItemEncryptorException()) {
      return ToNative.Error((Error_DynamoDbItemEncryptorException) dafnyValue);
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
    if (dafnyValue.is_ComAmazonawsDynamodb()) {
      return software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.Error(
        dafnyValue.dtor_ComAmazonawsDynamodb()
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
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkDynamoDb()) {
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyDbEncryptionSdkDynamoDb()
      );
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static DecryptItemInput DecryptItemInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput dafnyValue
  ) {
    DecryptItemInput.Builder nativeBuilder = DecryptItemInput.builder();
    nativeBuilder.encryptedItem(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeMap(
        dafnyValue.dtor_encryptedItem()
      )
    );
    return nativeBuilder.build();
  }

  public static DecryptItemOutput DecryptItemOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput dafnyValue
  ) {
    DecryptItemOutput.Builder nativeBuilder = DecryptItemOutput.builder();
    nativeBuilder.plaintextItem(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeMap(
        dafnyValue.dtor_plaintextItem()
      )
    );
    if (dafnyValue.dtor_parsedHeader().is_Some()) {
      nativeBuilder.parsedHeader(
        ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig dafnyValue
  ) {
    DynamoDbItemEncryptorConfig.Builder nativeBuilder =
      DynamoDbItemEncryptorConfig.builder();
    nativeBuilder.logicalTableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_logicalTableName()
      )
    );
    nativeBuilder.partitionKeyName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_partitionKeyName()
      )
    );
    if (dafnyValue.dtor_sortKeyName().is_Some()) {
      nativeBuilder.sortKeyName(
        software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
          dafnyValue.dtor_sortKeyName().dtor_value()
        )
      );
    }
    nativeBuilder.attributeActionsOnEncrypt(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative.AttributeActions(
        dafnyValue.dtor_attributeActionsOnEncrypt()
      )
    );
    if (dafnyValue.dtor_allowedUnsignedAttributes().is_Some()) {
      nativeBuilder.allowedUnsignedAttributes(
        software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeNameList(
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
    if (dafnyValue.dtor_algorithmSuiteId().is_Some()) {
      nativeBuilder.algorithmSuiteId(
        software.amazon.cryptography.materialproviders.ToNative.DBEAlgorithmSuiteId(
          dafnyValue.dtor_algorithmSuiteId().dtor_value()
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
    if (dafnyValue.dtor_cmm().is_Some()) {
      nativeBuilder.cmm(
        software.amazon.cryptography.materialproviders.ToNative.CryptographicMaterialsManager(
          dafnyValue.dtor_cmm().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_legacyOverride().is_Some()) {
      nativeBuilder.legacyOverride(
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative.LegacyOverride(
          dafnyValue.dtor_legacyOverride().dtor_value()
        )
      );
    }
    if (dafnyValue.dtor_plaintextOverride().is_Some()) {
      nativeBuilder.plaintextOverride(
        software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative.PlaintextOverride(
          dafnyValue.dtor_plaintextOverride().dtor_value()
        )
      );
    }
    return nativeBuilder.build();
  }

  public static EncryptItemInput EncryptItemInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput dafnyValue
  ) {
    EncryptItemInput.Builder nativeBuilder = EncryptItemInput.builder();
    nativeBuilder.plaintextItem(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeMap(
        dafnyValue.dtor_plaintextItem()
      )
    );
    return nativeBuilder.build();
  }

  public static EncryptItemOutput EncryptItemOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput dafnyValue
  ) {
    EncryptItemOutput.Builder nativeBuilder = EncryptItemOutput.builder();
    nativeBuilder.encryptedItem(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeMap(
        dafnyValue.dtor_encryptedItem()
      )
    );
    if (dafnyValue.dtor_parsedHeader().is_Some()) {
      nativeBuilder.parsedHeader(
        ToNative.ParsedHeader(dafnyValue.dtor_parsedHeader().dtor_value())
      );
    }
    return nativeBuilder.build();
  }

  public static ParsedHeader ParsedHeader(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader dafnyValue
  ) {
    ParsedHeader.Builder nativeBuilder = ParsedHeader.builder();
    nativeBuilder.attributeActionsOnEncrypt(
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative.AttributeActions(
        dafnyValue.dtor_attributeActionsOnEncrypt()
      )
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
    nativeBuilder.selectorContext(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.Key(
        dafnyValue.dtor_selectorContext()
      )
    );
    return nativeBuilder.build();
  }

  public static DynamoDbItemEncryptor DynamoDbItemEncryptor(
    IDynamoDbItemEncryptorClient dafnyValue
  ) {
    return new DynamoDbItemEncryptor(dafnyValue);
  }
}
