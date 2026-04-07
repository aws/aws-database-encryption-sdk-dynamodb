package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy;

/**
 * This file does *NOT* import a lot of things.
 * This is because it is dealing with converting
 * between different versions of the same name.
 * The DynamoDbItemEncryptor module has Dafny and Java versions
 * of the same type.
 * This means that `EncryptItemOutput` for example
 * needs to be disambiguated between the Dafny version and the Java version.
 * In order to make it clearer at each call-site exactly what is happening
 * the full import is used.
 * IDEs tend to fight this so I'm sorry.
 */

import StandardLibraryInternal.InternalResult;
import Wrappers_Compile.Option;
import Wrappers_Compile.Result;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.EncryptionFlags;
import dafny.DafnyMap;
import dafny.DafnySequence;
import dafny.TypeDescriptor;
import java.util.*;
import java.util.function.BiConsumer;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ILegacyDynamoDbEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;

public class InternalLegacyOverride extends _ExternBase_InternalLegacyOverride {

  private final LegacyEncryptorAdapter _encryptorAdapter;
  private final LegacyPolicy _policy;
  private final DafnySequence<Character> materialDescriptionFieldNameDafny;
  private final DafnySequence<Character> signatureFieldNameDafny;

  private InternalLegacyOverride(
    LegacyEncryptorAdapter encryptorAdapter,
    LegacyPolicy policy
  ) {
    this._encryptorAdapter = encryptorAdapter;
    this._policy = policy;
    // It is possible that these values
    // have been customized by the customer.
    this.materialDescriptionFieldNameDafny =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        encryptorAdapter.getMaterialDescriptionFieldName()
      );
    this.signatureFieldNameDafny =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        encryptorAdapter.getSignatureFieldName()
      );
  }

  public static TypeDescriptor<InternalLegacyOverride> _typeDescriptor() {
    return TypeDescriptor.referenceWithInitializer(
      InternalLegacyOverride.class,
      () -> null
    );
  }

  public boolean IsLegacyInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput input
  ) {
    //= specification/dynamodb-encryption-client/decrypt-item.md#determining-legacy-items
    //# An item MUST be determined to be encrypted under the legacy format if it contains
    //# attributes for the material description and the signature.
    return (
      input.is_DecryptItemInput() &&
      input._encryptedItem.contains(materialDescriptionFieldNameDafny) &&
      input._encryptedItem.contains(signatureFieldNameDafny)
    );
  }

  public LegacyPolicy policy() {
    return _policy;
  }

  public Result<
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput,
    Error
  > EncryptItem(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput input
  ) {
    // Precondition: Policy MUST allow the caller to encrypt.
    if (!_policy.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT()) {
      return CreateEncryptItemFailure(
        createError("Legacy Policy does not support encrypt.")
      );
    }

    try {
      Map<
        String,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue
      > plaintextItem =
        software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative
          .EncryptItemInput(input)
          .plaintextItem();

      final Map<
        String,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue
      > encryptedItem = _encryptorAdapter.encryptRecord(plaintextItem);

      final software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput nativeOutput =
        software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput
          .builder()
          .encryptedItem(encryptedItem)
          .build();
      final software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput dafnyOutput =
        software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToDafny.EncryptItemOutput(
          nativeOutput
        );
      return CreateEncryptItemSuccess(dafnyOutput);
    } catch (Exception ex) {
      return CreateEncryptItemFailure(Error.create_Opaque(ex));
    }
  }

  public Result<
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput,
    Error
  > DecryptItem(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput input
  ) {
    // Precondition: Policy MUST allow the caller to decrypt.
    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //# If a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) of
    //# `FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT` is configured,
    //# and the input item [is an item written in the legacy format](#determining-legacy-items),
    //# this operation MUST fail.
    if (
      !_policy.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT() &&
      !_policy.is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT()
    ) {
      return CreateDecryptItemFailure(
        createError("Legacy Policy does not support decrypt.")
      );
    }
    try {
      Map<
        String,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue
      > encryptedItem =
        software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative
          .DecryptItemInput(input)
          .encryptedItem();

      Map<
        String,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue
      > plaintextItem = _encryptorAdapter.decryptRecord(encryptedItem);

      final software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput nativeOutput =
        software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput
          .builder()
          .plaintextItem(plaintextItem)
          .build();
      final software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput dafnyOutput =
        software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToDafny.DecryptItemOutput(
          nativeOutput
        );
      return CreateDecryptItemSuccess(dafnyOutput);
    } catch (Exception ex) {
      return CreateDecryptItemFailure(Error.create_Opaque(ex));
    }
  }

  public static Result<Option<InternalLegacyOverride>, Error> Build(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig encryptorConfig
  ) {
    // Check for early return (Postcondition): If there is no legacyOverride there is nothing to do.
    if (encryptorConfig.dtor_legacyOverride().is_None()) {
      return CreateBuildSuccess(CreateInternalLegacyOverrideNone());
    }
    final software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride legacyOverride =
      encryptorConfig.dtor_legacyOverride().dtor_value();

    final ILegacyDynamoDbEncryptor maybeEncryptor =
      software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative.LegacyDynamoDbEncryptor(
        legacyOverride.dtor_encryptor()
      );

    // Precondition: The encryptor MUST be a DynamoDBEncryptor
    if (!isDynamoDBEncryptor(maybeEncryptor)) {
      return CreateBuildFailure(
        createError("Legacy encryptor is not supported")
      );
    }
    // Preconditions: MUST be able to create valid encryption context
    final InternalResult<EncryptionContext, Error> maybeEncryptionContext =
      legacyEncryptionContext(encryptorConfig);
    if (maybeEncryptionContext.isFailure()) {
      return CreateBuildFailure(maybeEncryptionContext.error());
    }
    // Precondition: All actions MUST be supported types
    final InternalResult<
      Map<String, Set<EncryptionFlags>>,
      Error
    > maybeActions = legacyActions(
      legacyOverride.dtor_attributeActionsOnEncrypt()
    );
    if (maybeActions.isFailure()) {
      return CreateBuildFailure(maybeEncryptionContext.error());
    }

    final LegacyEncryptorAdapter encryptorAdapter;
    if (
      maybeEncryptor instanceof
      com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.DynamoDBEncryptor
    ) {
      encryptorAdapter =
        new V2EncryptorAdapter(
          (com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.DynamoDBEncryptor) maybeEncryptor,
          maybeActions.value(),
          maybeEncryptionContext.value()
        );
    } else {
      return CreateBuildFailure(
        createError(
          "Unsupported encryptor type: " + maybeEncryptor.getClass().getName()
        )
      );
    }

    final InternalLegacyOverride internalLegacyOverride =
      new InternalLegacyOverride(
        encryptorAdapter,
        legacyOverride.dtor_policy()
      );

    return CreateBuildSuccess(
      CreateInternalLegacyOverrideSome(internalLegacyOverride)
    );
  }

  //  Everything below this point is an implementation detail

  public static Error createError(String message) {
    final DafnySequence<Character> dafnyMessage =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        message
      );
    return Error.create_DynamoDbItemEncryptorException(dafnyMessage);
  }

  public static boolean isDynamoDBEncryptor(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.ILegacyDynamoDbEncryptor maybe
  ) {
    return (
      maybe instanceof
        com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.DynamoDBEncryptor
    );
  }

  public static String ToNativeString(DafnySequence<? extends Character> s) {
    return software.amazon.smithy.dafny.conversion.ToNative.Simple.String(s);
  }

  public static DafnySequence<Character> ToDafnyString(String s) {
    return software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
      s
    );
  }

  public static InternalResult<
    EncryptionContext,
    Error
  > legacyEncryptionContext(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig config
  ) {
    try {
      EncryptionContext.Builder encryptionContextBuilder =
        new EncryptionContext.Builder()
          .tableName(ToNativeString(config.dtor_logicalTableName()))
          .hashKeyName(ToNativeString(config.dtor_partitionKeyName()));

      final EncryptionContext encryptionContext = config
          .dtor_sortKeyName()
          .is_Some()
        ? encryptionContextBuilder
          .rangeKeyName(
            ToNativeString(config.dtor_sortKeyName().dtor_value())
          )
          .build()
        : encryptionContextBuilder.build();

      return InternalResult.success(encryptionContext);
    } catch (Exception ex) {
      return InternalResult.failure(Error.create_Opaque(ex));
    }
  }

  public static InternalResult<
    Map<String, Set<EncryptionFlags>>,
    Error
  > legacyActions(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends CryptoAction
    > attributeActionsOnEncrypt
  ) {
    try {
      final EnumSet<EncryptionFlags> signOnly = EnumSet.of(
        EncryptionFlags.SIGN
      );
      final EnumSet<EncryptionFlags> encryptAndSign = EnumSet.of(
        EncryptionFlags.ENCRYPT,
        EncryptionFlags.SIGN
      );

      Map<String, Set<EncryptionFlags>> legacyActions = new HashMap<>();
      BiConsumer<
        ? super DafnySequence<? extends Character>,
        ? super CryptoAction
      > buildLegacyActions = (dafnyKey, value) -> {
        final String key = ToNativeString(dafnyKey);
        if (value.is_SIGN__ONLY()) {
          legacyActions.put(key, signOnly);
        } else if (value.is_ENCRYPT__AND__SIGN()) {
          legacyActions.put(key, encryptAndSign);
        } else if (value.is_DO__NOTHING()) {
          // DDB-EC v1 is not explicit
        } else {
          // Exceptional Postcondition: Only ENCRYPT and SIGN are supported. Do Nothing is not supported
          throw new IllegalArgumentException("Unsupported CryptoAction.");
        }
      };
      attributeActionsOnEncrypt.forEach(buildLegacyActions);
      return InternalResult.success(legacyActions);
    } catch (IllegalArgumentException ex) {
      final Error dafnyEx = Error.create_DynamoDbItemEncryptorException(
        ToDafnyString(ex.getMessage())
      );
      return InternalResult.failure(dafnyEx);
    } catch (Exception ex) {
      return InternalResult.failure(Error.create_Opaque(ex));
    }
  }
}
