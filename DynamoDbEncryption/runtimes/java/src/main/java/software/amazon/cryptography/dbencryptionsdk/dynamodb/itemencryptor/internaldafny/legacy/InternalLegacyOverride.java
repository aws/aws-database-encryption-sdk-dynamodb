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
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import dafny.DafnyMap;
import dafny.DafnySequence;
import dafny.TypeDescriptor;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ILegacyDynamoDbEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction;

public class InternalLegacyOverride extends _ExternBase_InternalLegacyOverride {

  private final LegacyEncryptorAdapter _encryptorAdapter;
  private final LegacyPolicy _policy;
  private final DafnySequence<Character> materialDescriptionFieldNameDafnyType;
  private final DafnySequence<Character> signatureFieldNameDafnyType;

  private InternalLegacyOverride(
    LegacyEncryptorAdapter encryptorAdapter,
    LegacyPolicy policy
  ) {
    this._encryptorAdapter = encryptorAdapter;
    this._policy = policy;
    // It is possible that these values
    // have been customized by the customer.
    this.materialDescriptionFieldNameDafnyType =
      software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence(
        encryptorAdapter.getMaterialDescriptionFieldName()
      );
    this.signatureFieldNameDafnyType =
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
      input._encryptedItem.contains(materialDescriptionFieldNameDafnyType) &&
      input._encryptedItem.contains(signatureFieldNameDafnyType)
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
    if (maybeEncryptor instanceof DynamoDBEncryptor) {
      encryptorAdapter =
        new V1EncryptorAdapter(
          (DynamoDBEncryptor) maybeEncryptor,
          maybeActions.value(),
          maybeEncryptionContext.value()
        );
    } else if (
      maybeEncryptor instanceof
      software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor
    ) {
      encryptorAdapter =
        new V2EncryptorAdapter(
          (software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor) maybeEncryptor,
          convertActionsV1ToV2(maybeActions.value()),
          convertEncryptionContextV1ToV2(maybeEncryptionContext.value())
        );
    } else {
      return CreateBuildFailure(createError("Unsupported encryptor type: " + maybeEncryptor.getClass().getName()));
    }

    final InternalLegacyOverride internalLegacyOverride =
      new InternalLegacyOverride(encryptorAdapter, legacyOverride.dtor_policy());

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
      maybe instanceof DynamoDBEncryptor ||
      maybe instanceof
        software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor
    );
  }

  // Convert SDK V1 EncryptionFlags to SDK V2
  private static Map<
    String,
    Set<
      software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags
    >
  > convertActionsV1ToV2(Map<String, Set<EncryptionFlags>> v1Actions) {
    Map<
      String,
      Set<
        software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags
      >
    > v2Actions = new HashMap<>();
    for (Map.Entry<String, Set<EncryptionFlags>> entry : v1Actions.entrySet()) {
      Set<
        software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags
      > v2Flags = new HashSet<>();
      for (EncryptionFlags v1Flag : entry.getValue()) {
        v2Flags.add(
          software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags.valueOf(
            v1Flag.name()
          )
        );
      }
      v2Actions.put(entry.getKey(), v2Flags);
    }
    return v2Actions;
  }

  // Convert SDK V1 EncryptionContext to SDK V2
  private static software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext convertEncryptionContextV1ToV2(
    EncryptionContext v1Context
  ) {
    return software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext
      .builder()
      .tableName(v1Context.getTableName())
      .hashKeyName(v1Context.getHashKeyName())
      .rangeKeyName(v1Context.getRangeKeyName())
      .attributeValues(V1MapToV2Map(v1Context.getAttributeValues()))
      .developerContext(v1Context.getDeveloperContext())
      .materialDescription(v1Context.getMaterialDescription())
      .build();
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
          .withTableName(ToNativeString(config.dtor_logicalTableName()))
          .withHashKeyName(ToNativeString(config.dtor_partitionKeyName()));

      final EncryptionContext encryptionContext = config
          .dtor_sortKeyName()
          .is_Some()
        ? encryptionContextBuilder
          .withRangeKeyName(
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

  public static com.amazonaws.services.dynamodbv2.model.AttributeValue V2AttributeToV1Attribute(
    software.amazon.awssdk.services.dynamodb.model.AttributeValue value
  ) {
    final com.amazonaws.services.dynamodbv2.model.AttributeValue attribute =
      new com.amazonaws.services.dynamodbv2.model.AttributeValue();
    switch (value.type()) {
      case B:
        return attribute.withB(value.b().asByteBuffer());
      case BOOL:
        return attribute.withBOOL(value.bool());
      case BS:
        return attribute.withBS(
          value
            .bs()
            .stream()
            .map(b -> b.asByteBuffer())
            .collect(Collectors.toList())
        );
      case L:
        return attribute.withL(
          value
            .l()
            .stream()
            .map(a -> V2AttributeToV1Attribute(a))
            .collect(Collectors.toList())
        );
      case M:
        return attribute.withM(V2MapToV1Map(value.m()));
      case N:
        return attribute.withN(value.n());
      case NS:
        return attribute.withNS(value.ns());
      case NUL:
        return attribute.withNULL(value.nul());
      case S:
        return attribute.withS(value.s());
      case SS:
        return attribute.withSS(value.ss());
      case UNKNOWN_TO_SDK_VERSION:
        throw new IllegalArgumentException("Unsupported AttributeValue type: UNKNOWN_TO_SDK_VERSION. This may indicate a newer DynamoDB attribute type that is not supported by this SDK version.");
    }

    throw new IllegalArgumentException("Unexpected AttributeValue type: " + value.type() + ". Unable to convert from SDK v2 to SDK v1 format.");
  }

  public static Map<
    String,
    com.amazonaws.services.dynamodbv2.model.AttributeValue
  > V2MapToV1Map(
    Map<
      String,
      software.amazon.awssdk.services.dynamodb.model.AttributeValue
    > input
  ) {
    return input
      .entrySet()
      .stream()
      .collect(
        Collectors.toMap(
          entry -> entry.getKey(),
          entry -> V2AttributeToV1Attribute(entry.getValue())
        )
      );
  }

  public static software.amazon.awssdk.services.dynamodb.model.AttributeValue V1AttributeToV2Attribute(
    com.amazonaws.services.dynamodbv2.model.AttributeValue value
  ) {
    final software.amazon.awssdk.services.dynamodb.model.AttributeValue.Builder attributeBuilder =
      software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder();
    if (Boolean.TRUE.equals(value.getNULL())) {
      return attributeBuilder.nul(value.getNULL()).build();
    } else if (Boolean.FALSE.equals(value.getNULL())) {
      throw new UnsupportedOperationException(
        "False-NULL is not supported in DynamoDB"
      );
    } else if (value.getBOOL() != null) {
      return attributeBuilder.bool(value.getBOOL()).build();
    } else if (value.getS() != null) {
      return attributeBuilder.s(value.getS()).build();
    } else if (value.getN() != null) {
      return attributeBuilder.n(value.getN()).build();
    } else if (value.getB() != null) {
      return attributeBuilder.b(SdkBytes.fromByteBuffer(value.getB())).build();
    } else if (value.getSS() != null) {
      return attributeBuilder.ss(value.getSS()).build();
    } else if (value.getNS() != null) {
      return attributeBuilder.ns(value.getNS()).build();
    } else if (value.getBS() != null) {
      return attributeBuilder
        .bs(
          value
            .getBS()
            .stream()
            .map(bb -> SdkBytes.fromByteBuffer(bb))
            .collect(Collectors.toList())
        )
        .build();
    } else if (value.getL() != null) {
      return attributeBuilder
        .l(
          value
            .getL()
            .stream()
            .map(a -> V1AttributeToV2Attribute(a))
            .collect(Collectors.toList())
        )
        .build();
    } else if (value.getM() != null) {
      return attributeBuilder.m(V1MapToV2Map(value.getM())).build();
    } else {
      throw new IllegalArgumentException("Unsupported Value" + value);
    }
  }

  public static Map<
    String,
    software.amazon.awssdk.services.dynamodb.model.AttributeValue
  > V1MapToV2Map(
    Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> input
  ) {
    return input
      .entrySet()
      .stream()
      .collect(
        Collectors.toMap(
          entry -> entry.getKey(),
          entry -> V1AttributeToV2Attribute(entry.getValue())
        )
      );
  }
}
