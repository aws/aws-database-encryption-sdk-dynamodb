// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor;

import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import dafny.TypeDescriptor;
import java.lang.Byte;
import java.lang.Character;
import java.lang.RuntimeException;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error_DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.OpaqueWithTextError;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;
import software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue;

public class ToDafny {

  public static Error Error(RuntimeException nativeValue) {
    if (nativeValue instanceof DynamoDbItemEncryptorException) {
      return ToDafny.Error((DynamoDbItemEncryptorException) nativeValue);
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

  public static DecryptItemInput DecryptItemInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends AttributeValue
    > encryptedItem;
    encryptedItem =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(
        nativeValue.encryptedItem()
      );
    return new DecryptItemInput(encryptedItem);
  }

  public static DecryptItemOutput DecryptItemOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends AttributeValue
    > plaintextItem;
    plaintextItem =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(
        nativeValue.plaintextItem()
      );
    Option<ParsedHeader> parsedHeader;
    parsedHeader =
      Objects.nonNull(nativeValue.parsedHeader())
        ? Option.create_Some(
          ParsedHeader._typeDescriptor(),
          ToDafny.ParsedHeader(nativeValue.parsedHeader())
        )
        : Option.create_None(ParsedHeader._typeDescriptor());
    return new DecryptItemOutput(plaintextItem, parsedHeader);
  }

  public static DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig nativeValue
  ) {
    DafnySequence<? extends Character> logicalTableName;
    logicalTableName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.logicalTableName()
      );
    DafnySequence<? extends Character> partitionKeyName;
    partitionKeyName =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.partitionKeyName()
      );
    Option<DafnySequence<? extends Character>> sortKeyName;
    sortKeyName =
      Objects.nonNull(nativeValue.sortKeyName())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.sortKeyName()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
        );
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends CryptoAction
    > attributeActionsOnEncrypt;
    attributeActionsOnEncrypt =
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.AttributeActions(
        nativeValue.attributeActionsOnEncrypt()
      );
    Option<
      DafnySequence<? extends DafnySequence<? extends Character>>
    > allowedUnsignedAttributes;
    allowedUnsignedAttributes =
      (Objects.nonNull(nativeValue.allowedUnsignedAttributes()) &&
          nativeValue.allowedUnsignedAttributes().size() > 0)
        ? Option.create_Some(
          DafnySequence._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
          ),
          software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeNameList(
            nativeValue.allowedUnsignedAttributes()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(
            DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
          )
        );
    Option<DafnySequence<? extends Character>> allowedUnsignedAttributePrefix;
    allowedUnsignedAttributePrefix =
      Objects.nonNull(nativeValue.allowedUnsignedAttributePrefix())
        ? Option.create_Some(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR),
          software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
            nativeValue.allowedUnsignedAttributePrefix()
          )
        )
        : Option.create_None(
          DafnySequence._typeDescriptor(TypeDescriptor.CHAR)
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
    Option<IKeyring> keyring;
    keyring =
      Objects.nonNull(nativeValue.keyring())
        ? Option.create_Some(
          TypeDescriptor.reference(IKeyring.class),
          software.amazon.cryptography.materialproviders.ToDafny.Keyring(
            nativeValue.keyring()
          )
        )
        : Option.create_None(TypeDescriptor.reference(IKeyring.class));
    Option<ICryptographicMaterialsManager> cmm;
    cmm =
      Objects.nonNull(nativeValue.cmm())
        ? Option.create_Some(
          TypeDescriptor.reference(ICryptographicMaterialsManager.class),
          software.amazon.cryptography.materialproviders.ToDafny.CryptographicMaterialsManager(
            nativeValue.cmm()
          )
        )
        : Option.create_None(
          TypeDescriptor.reference(ICryptographicMaterialsManager.class)
        );
    Option<LegacyOverride> legacyOverride;
    legacyOverride =
      Objects.nonNull(nativeValue.legacyOverride())
        ? Option.create_Some(
          LegacyOverride._typeDescriptor(),
          software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.LegacyOverride(
            nativeValue.legacyOverride()
          )
        )
        : Option.create_None(LegacyOverride._typeDescriptor());
    Option<PlaintextOverride> plaintextOverride;
    plaintextOverride =
      Objects.nonNull(nativeValue.plaintextOverride())
        ? Option.create_Some(
          PlaintextOverride._typeDescriptor(),
          software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.PlaintextOverride(
            nativeValue.plaintextOverride()
          )
        )
        : Option.create_None(PlaintextOverride._typeDescriptor());
    return new DynamoDbItemEncryptorConfig(
      logicalTableName,
      partitionKeyName,
      sortKeyName,
      attributeActionsOnEncrypt,
      allowedUnsignedAttributes,
      allowedUnsignedAttributePrefix,
      algorithmSuiteId,
      keyring,
      cmm,
      legacyOverride,
      plaintextOverride
    );
  }

  public static EncryptItemInput EncryptItemInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends AttributeValue
    > plaintextItem;
    plaintextItem =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(
        nativeValue.plaintextItem()
      );
    return new EncryptItemInput(plaintextItem);
  }

  public static EncryptItemOutput EncryptItemOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends AttributeValue
    > encryptedItem;
    encryptedItem =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.AttributeMap(
        nativeValue.encryptedItem()
      );
    Option<ParsedHeader> parsedHeader;
    parsedHeader =
      Objects.nonNull(nativeValue.parsedHeader())
        ? Option.create_Some(
          ParsedHeader._typeDescriptor(),
          ToDafny.ParsedHeader(nativeValue.parsedHeader())
        )
        : Option.create_None(ParsedHeader._typeDescriptor());
    return new EncryptItemOutput(encryptedItem, parsedHeader);
  }

  public static ParsedHeader ParsedHeader(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.ParsedHeader nativeValue
  ) {
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends CryptoAction
    > attributeActionsOnEncrypt;
    attributeActionsOnEncrypt =
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny.AttributeActions(
        nativeValue.attributeActionsOnEncrypt()
      );
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
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends AttributeValue
    > selectorContext;
    selectorContext =
      software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.Key(
        nativeValue.selectorContext()
      );
    return new ParsedHeader(
      attributeActionsOnEncrypt,
      algorithmSuiteId,
      encryptedDataKeys,
      storedEncryptionContext,
      encryptionContext,
      selectorContext
    );
  }

  public static Error Error(DynamoDbItemEncryptorException nativeValue) {
    DafnySequence<? extends Character> message;
    message =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        nativeValue.message()
      );
    return new Error_DynamoDbItemEncryptorException(message);
  }

  public static IDynamoDbItemEncryptorClient DynamoDbItemEncryptor(
    DynamoDbItemEncryptor nativeValue
  ) {
    return nativeValue.impl();
  }
}
