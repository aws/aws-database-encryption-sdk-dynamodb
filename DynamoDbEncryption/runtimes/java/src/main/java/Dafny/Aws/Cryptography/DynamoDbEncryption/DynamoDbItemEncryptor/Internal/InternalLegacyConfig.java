package Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal;

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

import Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy;
import Wrappers_Compile.Option;
import dafny.DafnyMap;
import dafny.DafnySequence;
import Wrappers_Compile.Result;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import dafny.TypeDescriptor;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.cryptography.dynamoDbEncryption.ILegacyDynamoDbEncryptor;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.ToNative;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class InternalLegacyConfig {
  private DynamoDBEncryptor encryptor;
  private Map<String, Set<EncryptionFlags>> actions;
  private EncryptionContext encryptionContext;
  private LegacyPolicy _policy;
  private DafnySequence<Character> materialDescriptionFieldName;
  private DafnySequence<Character> signatureFieldName;

  private InternalLegacyConfig(
    DynamoDBEncryptor encryptor,
    Map<String, Set<EncryptionFlags>> actions,
    EncryptionContext encryptionContext,
    LegacyPolicy policy
  ) {
    this.encryptor = encryptor;
    this.actions = actions;
    this.encryptionContext = encryptionContext;
    this._policy = policy;
    // It is possible that these values
    // have been customized by the customer.
    this.materialDescriptionFieldName = software
      .amazon
      .dafny
      .conversion
      .ToDafny
      .Simple
      .CharacterSequence(encryptor.getMaterialDescriptionFieldName());
    this.signatureFieldName = software
      .amazon
      .dafny
      .conversion
      .ToDafny
      .Simple
      .CharacterSequence(encryptor.getSignatureFieldName());
  }

  public static TypeDescriptor<InternalLegacyConfig> _typeDescriptor() {
    return TypeDescriptor.referenceWithInitializer(InternalLegacyConfig.class, () -> null);
  }

  public Boolean IsLegacyInput(
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput input
  ) {
    return input.is_DecryptItemInput() &&
      input._encryptedItem.contains(materialDescriptionFieldName) &&
      input._encryptedItem.contains(signatureFieldName);
  }

  public LegacyPolicy policy() {
    return _policy;
  }

  public Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Error> EncryptItem(
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput input
  ) {

    // Precondition: Policy MUST allow the caller to encrypt.
    if (!_policy.is_REQUIRE__ENCRYPT__ALLOW__DECRYPT()) {
      return createFailure("Legacy Policy does not support encrypt.");
    }

    try {
      Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> plaintextItem = software
        .amazon
        .cryptography
        .dynamoDbEncryption
        .itemEncryptor
        .ToNative
        .EncryptItemInput(input)
        .plaintextItem();

      final Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> encryptedItem = encryptor
        .encryptRecord(
          V2MapToV1Map(plaintextItem),
          actions,
          encryptionContext
        );

      final software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.EncryptItemOutput nativeOutput = software
        .amazon
        .cryptography
        .dynamoDbEncryption
        .itemEncryptor
        .model
        .EncryptItemOutput
        .builder()
        .encryptedItem(V1MapToV2Map(encryptedItem))
        .build();
      final Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput dafnyOutput = software
        .amazon
        .cryptography
        .dynamoDbEncryption
        .itemEncryptor
        .ToDafny
        .EncryptItemOutput(nativeOutput);
      return Result.create_Success(dafnyOutput);
    } catch (Exception ex) {
      return Result.create_Failure(Error.create_Opaque(ex));
    }
  }

  public Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Error> DecryptItem(
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput input
  ) {

    // Precondition: Policy MUST allow the caller to decrypt.
    if (!_policy.is_REQUIRE__ENCRYPT__ALLOW__DECRYPT() && !_policy.is_FORBID__ENCRYPT__ALLOW__DECRYPT()) {
      return createFailure("Legacy Policy does not support decrypt.");
    }
    try {
      Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> encryptedItem = software
        .amazon
        .cryptography
        .dynamoDbEncryption
        .itemEncryptor
        .ToNative
        .DecryptItemInput(input)
        .encryptedItem();

      final Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> plaintextItem = encryptor
        .decryptRecord(
          V2MapToV1Map(encryptedItem),
          actions,
          encryptionContext
        );

      final software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.DecryptItemOutput nativeOutput = software
        .amazon
        .cryptography
        .dynamoDbEncryption
        .itemEncryptor
        .model
        .DecryptItemOutput
        .builder()
        .plaintextItem(V1MapToV2Map(plaintextItem))
        .build();
      final Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput dafnyOutput = software
        .amazon
        .cryptography
        .dynamoDbEncryption
        .itemEncryptor
        .ToDafny
        .DecryptItemOutput(nativeOutput);
      return Result.create_Success(dafnyOutput);
    } catch (Exception ex) {
      return Result.create_Failure(Error.create_Opaque(ex));
    }
  }

  public static Result<Option<InternalLegacyConfig>, Error> Build(
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig encryptorConfig
  ) {

    // Check for early return (Postcondition): If there is no legacyConfig there is nothing to do.
    if (encryptorConfig.dtor_legacyConfig().is_None()) {
      return Result.create_Success(Option.create_None());
    }
    final Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyConfig legacyConfig = encryptorConfig
      .dtor_legacyConfig()
      .dtor_value();

    final Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor foo = legacyConfig.dtor_encryptor();
    final ILegacyDynamoDbEncryptor maybeEncryptor = software.amazon.cryptography.dynamoDbEncryption.ToNative
      .LegacyDynamoDbEncryptor(foo);

    // Precondition: The encryptor MUST be a DynamoDBEncryptor
    if (!isDynamoDBEncryptor(maybeEncryptor)) {
      return createFailure("Legacy encryptor is not supported");
    }
    // Preconditions: MUST be able to create valid encryption context
    final Result<EncryptionContext, Error> maybeEncryptionContext = legacyEncryptionContext(encryptorConfig);
    if (maybeEncryptionContext.is_Failure()) {
      return Result.create_Failure(maybeEncryptionContext.dtor_error());
    }
    // Precondition: All actions MUST be supported types
    final Result<Map<String, Set<EncryptionFlags>>, Error> maybeActions = legacyActions(legacyConfig.dtor_attributeFlags());
    if (maybeActions.is_Failure()) {
      return Result.create_Failure(maybeEncryptionContext.dtor_error());
    }

    final InternalLegacyConfig internalLegacyConfig = new InternalLegacyConfig(
      (DynamoDBEncryptor) maybeEncryptor,
      maybeActions.dtor_value(),
      maybeEncryptionContext.dtor_value(),
      legacyConfig.dtor_policy()
    );

    return Result.create_Success(Option.create_Some(internalLegacyConfig));
  }

  //  Everything below this point is an implementation detail

  public static <T> Result<T, Error>createFailure(String message) {
    final DafnySequence<Character> dafnyMessage = software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(message);
    final Error dafnyEx = Error.create_DynamoDbItemEncryptorException(dafnyMessage);
    return Result.create_Failure(dafnyEx);
  }

  public static boolean isDynamoDBEncryptor(
    software.amazon.cryptography.dynamoDbEncryption.ILegacyDynamoDbEncryptor maybe
  ) {
    System.out.println(maybe.getClass());
    return maybe.getClass().equals(DynamoDBEncryptor.class);
  }

  public static String ToNativeString(DafnySequence< ? extends Character> s)
  {
    return software.amazon.dafny.conversion.ToNative.Simple.String(s);
  }

  public static DafnySequence<Character> ToDafnyString(String s)
  {
    return software.amazon.dafny.conversion.ToDafny.Simple.CharacterSequence(s);
  }

  public static Result<EncryptionContext, Error> legacyEncryptionContext(
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig config
  ) {
    try {
      EncryptionContext.Builder encryptionContextBuilder = new EncryptionContext
        .Builder()
        .withTableName(ToNativeString(config.dtor_tableName()))
        .withHashKeyName(ToNativeString(config.dtor_partitionKeyName()));

      final EncryptionContext encryptionContext = config.dtor_sortKeyName().is_Some()
        ? encryptionContextBuilder.withRangeKeyName(ToNativeString(config.dtor_sortKeyName().dtor_value())).build()
        : encryptionContextBuilder.build();

      return Result.create_Success(encryptionContext);
    } catch (Exception ex) {
      return Result.create_Failure(Error.create_Opaque(ex));
    }
  }

  public static Result<Map<String, Set<EncryptionFlags>>, Error> legacyActions(
    DafnyMap<? extends DafnySequence<? extends Character>, ? extends CryptoAction> attributeFlags
  ) {
    try {
      final EnumSet<EncryptionFlags> signOnly = EnumSet.of(EncryptionFlags.SIGN);
      final EnumSet<EncryptionFlags> encryptAndSign = EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN);

      Map<String, Set<EncryptionFlags>> legacyActions = new HashMap<>();
      BiConsumer<? super DafnySequence<? extends Character>, ? super CryptoAction> buildLegacyActions = (dafnyKey, value) -> {
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
      attributeFlags.forEach(buildLegacyActions);
      return Result.create_Success(legacyActions);
    } catch (IllegalArgumentException ex) {
      final Error dafnyEx = Error.create_DynamoDbItemEncryptorException(ToDafnyString(ex.getMessage()));
      return Result.create_Failure(dafnyEx);
    } catch (Exception ex) {
      return Result.create_Failure(Error.create_Opaque(ex));
    }
  }

  public static com.amazonaws.services.dynamodbv2.model.AttributeValue V2AttributeToV1Attribute(
    software.amazon.awssdk.services.dynamodb.model.AttributeValue value
  ) {
    final com.amazonaws.services.dynamodbv2.model.AttributeValue attribute = new com.amazonaws.services.dynamodbv2.model.AttributeValue();
    switch (value.type()) {
      case B:
        return attribute.withB(value.b().asByteBuffer());
      case BOOL:
        return attribute.withBOOL(value.bool());
      case BS:
        return attribute
          .withBS(value.bs().stream().map(b -> b.asByteBuffer()).collect(Collectors.toList()));
      case L:
        return attribute
          .withL(value.l().stream().map(a -> V2AttributeToV1Attribute(a)).collect(Collectors.toList()));
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
        throw new IllegalArgumentException("omfg");
    }

    throw new IllegalArgumentException("omfg");
  }

  public static Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> V2MapToV1Map(
    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> input
  ) {
    return input
      .entrySet()
      .stream()
      .collect(Collectors.toMap(
        entry -> entry.getKey(),
        entry -> V2AttributeToV1Attribute(entry.getValue()))
      );
  }

  public static software.amazon.awssdk.services.dynamodb.model.AttributeValue V1AttributeToV2Attribute(
    com.amazonaws.services.dynamodbv2.model.AttributeValue value
  ) {
    final software.amazon.awssdk.services.dynamodb.model.AttributeValue.Builder attributeBuilder = software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder();
    if (Boolean.TRUE.equals(value.getNULL())) {
      return attributeBuilder.nul(value.getNULL()).build();
    } else if (Boolean.FALSE.equals(value.getNULL())) {
      throw new UnsupportedOperationException("False-NULL is not supported in DynamoDB");
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
        .bs(value.getBS().stream().map(bb -> SdkBytes.fromByteBuffer(bb)).collect(Collectors.toList()))
        .build();
    } else if (value.getL() != null) {
      return attributeBuilder
        .l(value.getL().stream().map(a -> V1AttributeToV2Attribute(a)).collect(Collectors.toList()))
        .build();
    } else if (value.getM() != null) {
      return attributeBuilder.m(V1MapToV2Map(value.getM())).build();
    } else {
      throw new IllegalArgumentException("Unsupported Value" + value);
    }
  }

  public static Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> V1MapToV2Map(
    Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> input
  ) {
    return input
      .entrySet()
      .stream()
      .collect(Collectors.toMap(
        entry -> entry.getKey(),
        entry -> V1AttributeToV2Attribute(entry.getValue()))
      );
  }

}
