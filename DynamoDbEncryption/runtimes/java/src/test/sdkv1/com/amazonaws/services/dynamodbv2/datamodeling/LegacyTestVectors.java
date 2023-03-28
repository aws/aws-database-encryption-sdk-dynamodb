package com.amazonaws.services.dynamodbv2.datamodeling;

import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.testing.types.*;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model.*;
import software.amazon.cryptography.dynamoDbEncryption.model.LegacyConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.LegacyPolicy;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialProviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LegacyTestVectors {

  public static void decryptBaseClassTestVector(
    final AmazonDynamoDB client,
    final DynamoDBEncryptor legacyEncryptor,
    final BaseClass TEST_VALUE
  ) {
    final DecryptItemOutput out = getAndDecrypt(client, legacyEncryptor, TEST_VALUE);

    try {
      assertEquals(TEST_VALUE, attributeMapToBaseClass(out.plaintextItem(), TEST_VALUE));
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  public static void decryptHashKeyOnlyTestVector(
    final AmazonDynamoDB client,
    final DynamoDBEncryptor legacyEncryptor,
    final String hashKey
  ) {
    final HashKeyOnly TEST_VALUE = new HashKeyOnly();
    TEST_VALUE.setHashKey(hashKey);

    final DecryptItemOutput out = getAndDecrypt(client, legacyEncryptor, TEST_VALUE);

    assertTrue(out.plaintextItem().containsKey(HASH_KEY));
    assertEquals(hashKey, out.plaintextItem().get(HASH_KEY).s());
  }

  public static void decryptKeysOnlyTestVector(
    final AmazonDynamoDB client,
    final DynamoDBEncryptor legacyEncryptor,
    final int hashKey,
    final int rangeKey
  ) {
    final KeysOnly TEST_VALUE = new KeysOnly();
    TEST_VALUE.setHashKey(hashKey);
    TEST_VALUE.setRangeKey(rangeKey);

    final DecryptItemOutput out = getAndDecrypt(client, legacyEncryptor, TEST_VALUE);

    assertTrue(out.plaintextItem().containsKey(HASH_KEY));
    assertTrue(out.plaintextItem().containsKey(RANGE_KEY));
    assertEquals(hashKey, Integer.valueOf(out.plaintextItem().get(HASH_KEY).n()).intValue());
    assertEquals(rangeKey, Integer.valueOf(out.plaintextItem().get(RANGE_KEY).n()).intValue());
  }

  public static DecryptItemOutput getAndDecrypt(
    final AmazonDynamoDB client,
    final DynamoDBEncryptor legacyEncryptor,
    final Object TEST_VALUE
  ) {
    final DynamoDbItemEncryptorConfig foo = getConfig(legacyEncryptor, TEST_VALUE);
    final DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor
      .builder()
      .DynamoDbItemEncryptorConfig(getConfig(legacyEncryptor, TEST_VALUE))
      .build();

    final GetItemResult item = client.getItem(getRequest(TEST_VALUE));

    final DecryptItemInput decryptInput = DecryptItemInput
      .builder()
      .encryptedItem(InternalLegacyConfig.V1MapToV2Map(item.getItem()))
      .build();
    return encryptor.DecryptItem(decryptInput);
  }

  public static PutItemResult encryptAndPut(
    final AmazonDynamoDB client,
    final DynamoDBEncryptor legacyEncryptor,
    final Object TEST_VALUE
  ) {
    final DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor
      .builder()
      .DynamoDbItemEncryptorConfig(getConfig(legacyEncryptor, TEST_VALUE))
      .build();
    
    final EncryptItemInput encryptInput = EncryptItemInput
      .builder()
      .plaintextItem(baseClassToAttributeMap(TEST_VALUE))
      .build();
    EncryptItemOutput encryptOutput = encryptor.EncryptItem(encryptInput);

    return client.putItem(putRequest(InternalLegacyConfig.V2MapToV1Map(encryptOutput.encryptedItem()), TEST_VALUE));
  }

  public static DynamoDbItemEncryptorConfig getConfig(
    final DynamoDBEncryptor legacyEncryptor,
    final Object TEST_VALUE
  ) {
    final String tableName = getTableName(TEST_VALUE);
    final Boolean hasRange = !getRangeKey(TEST_VALUE).equals("");

    final HashMap<String, CryptoAction> legacyAttributeFlags = ActionsFromClass(TEST_VALUE);

    final LegacyConfig legacyConfig = LegacyConfig
      .builder()
      .encryptor(legacyEncryptor)
      // This is not testing Policy requirements
      // This config works for both encrypt and decrypt test vectors.
      .policy(LegacyPolicy.REQUIRE_ENCRYPT_ALLOW_DECRYPT)
      .attributeFlags(legacyAttributeFlags)
      .build();

    final Map<String, CryptoAction> onlyHashRange = legacyAttributeFlags
      .entrySet()
      .stream()
      .filter(e -> e.getKey() == HASH_KEY || (e.getKey() == RANGE_KEY && hasRange))
      .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

    final DynamoDbItemEncryptorConfig.Builder config = DynamoDbItemEncryptorConfig
      .builder()
      .tableName(tableName)
      .partitionKeyName(HASH_KEY)
      .legacyConfig(legacyConfig)
      // **Not** trying to write things,
      // just trying to get to test the legacyConfig.
      .attributeActions(onlyHashRange)
      .keyring(createStaticKeyring());

    if (hasRange) {
      return config.sortKeyName(RANGE_KEY).build();
    } else {
      return config.build();
    }
  }
  public static GetItemRequest getRequest(final Object TEST_VALUE) {
    final String tableName = getTableName(TEST_VALUE);
    HashMap<String, AttributeValue> v1KeyToGet = new HashMap();

    if (TEST_VALUE instanceof HashKeyOnly) {
      v1KeyToGet.put(HASH_KEY, new AttributeValue().withS(getHashKey(TEST_VALUE)));
    } else {
      v1KeyToGet.put(HASH_KEY, new AttributeValue().withN(getHashKey(TEST_VALUE)));
    }

    final String rangeKey = getRangeKey(TEST_VALUE);
    if (!rangeKey.equals("")) {
      v1KeyToGet.put(RANGE_KEY, new AttributeValue().withN(rangeKey));
    }

    return new GetItemRequest()
      .withTableName(tableName)
      .withKey(v1KeyToGet);
  }

  public static PutItemRequest putRequest(
    final Map<String, AttributeValue> encryptedItem,
    final Object TEST_VALUE
  ) {
    final String tableName = getTableName(TEST_VALUE);

    return new PutItemRequest()
      .withTableName(tableName)
      .withItem(encryptedItem);
  }

  public static String getHashKey(final Object TEST_VALUE) {
    if (TEST_VALUE instanceof BaseClass) {
      return String.valueOf(((BaseClass) TEST_VALUE).getHashKey());
    } else if (TEST_VALUE instanceof HashKeyOnly) {
      return String.valueOf(((HashKeyOnly) TEST_VALUE).getHashKey());
    } else if (TEST_VALUE instanceof KeysOnly) {
      return String.valueOf(((KeysOnly) TEST_VALUE).getHashKey());
    } else {
      return ""; // ???
    }
  }

  public static String getRangeKey(final Object TEST_VALUE) {
    if (TEST_VALUE instanceof BaseClass) {
      return String.valueOf(((BaseClass) TEST_VALUE).getRangeKey());
    } else if (TEST_VALUE instanceof KeysOnly) {
      return String.valueOf(((KeysOnly) TEST_VALUE).getRangeKey());
    } else {
      return ""; // ???
    }
  }

  public static String getTableName(final Object TEST_VALUE) {
    return TEST_VALUE.getClass().getAnnotation(DynamoDBTable.class).tableName();
  }

  // This is verbose.
  // This way I can work out what is going on.
  // There MAY be some clever use of reflection
  // that would make this more compact.
  // However, for tests I prefer verbosity.
  public static HashMap<String, CryptoAction> ActionsFromClass(final Object value) {
    HashMap<String, CryptoAction> attributeFlags = new HashMap();

    if (value instanceof Mixed) {
      attributeFlags.put(HASH_KEY, CryptoAction.SIGN_ONLY);
      attributeFlags.put(RANGE_KEY, CryptoAction.SIGN_ONLY);
      attributeFlags.put("stringValue", CryptoAction.SIGN_ONLY);
      attributeFlags.put("intValue", CryptoAction.DO_NOTHING);
      attributeFlags.put("byteArrayValue", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("stringSet", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("intSet", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("version", CryptoAction.SIGN_ONLY);
      attributeFlags.put("doubleValue", CryptoAction.SIGN_ONLY);
      attributeFlags.put("doubleSet", CryptoAction.SIGN_ONLY);
    } else if (value instanceof SignOnly) {
      attributeFlags.put(HASH_KEY, CryptoAction.SIGN_ONLY);
      attributeFlags.put(RANGE_KEY, CryptoAction.SIGN_ONLY);
      attributeFlags.put("stringValue", CryptoAction.SIGN_ONLY);
      attributeFlags.put("intValue", CryptoAction.SIGN_ONLY);
      attributeFlags.put("byteArrayValue", CryptoAction.SIGN_ONLY);
      attributeFlags.put("stringSet", CryptoAction.SIGN_ONLY);
      attributeFlags.put("intSet", CryptoAction.SIGN_ONLY);
      attributeFlags.put("version", CryptoAction.SIGN_ONLY);
      attributeFlags.put("doubleValue", CryptoAction.SIGN_ONLY);
      attributeFlags.put("doubleSet", CryptoAction.SIGN_ONLY);
    } else if (value instanceof Untouched) {
      attributeFlags.put(HASH_KEY, CryptoAction.SIGN_ONLY );
      attributeFlags.put(RANGE_KEY, CryptoAction.SIGN_ONLY);
      attributeFlags.put("stringValue", CryptoAction.DO_NOTHING);
      attributeFlags.put("intValue", CryptoAction.DO_NOTHING);
      attributeFlags.put("byteArrayValue", CryptoAction.DO_NOTHING);
      attributeFlags.put("stringSet", CryptoAction.DO_NOTHING);
      attributeFlags.put("intSet", CryptoAction.DO_NOTHING);
      attributeFlags.put("version", CryptoAction.DO_NOTHING);
      attributeFlags.put("doubleValue", CryptoAction.DO_NOTHING);
      attributeFlags.put("doubleSet", CryptoAction.DO_NOTHING);
    } else if (value instanceof BaseClass) {
      // This is a BaseClass
      attributeFlags.put(HASH_KEY, CryptoAction.SIGN_ONLY);
      attributeFlags.put(RANGE_KEY, CryptoAction.SIGN_ONLY);
      attributeFlags.put("stringValue", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("intValue", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("byteArrayValue", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("stringSet", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("intSet", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("version", CryptoAction.SIGN_ONLY);
      attributeFlags.put("doubleValue", CryptoAction.ENCRYPT_AND_SIGN);
      attributeFlags.put("doubleSet", CryptoAction.ENCRYPT_AND_SIGN);
    } else if (value instanceof KeysOnly) {
      attributeFlags.put(HASH_KEY, CryptoAction.SIGN_ONLY);
      attributeFlags.put(RANGE_KEY, CryptoAction.SIGN_ONLY);
    } else if (value instanceof  HashKeyOnly) {
      attributeFlags.put(HASH_KEY, CryptoAction.SIGN_ONLY);
    }

    return attributeFlags;
  }

  public static BaseClass attributeMapToBaseClass(
    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> attributeMap,
    BaseClass TEST_VALUE
  ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    final BaseClass value = TEST_VALUE.getClass().getDeclaredConstructor().newInstance();

    if (attributeMap.containsKey(HASH_KEY)) {
      value.setHashKey(Integer.valueOf(attributeMap.get(HASH_KEY).n()));
    }
    if (attributeMap.containsKey(RANGE_KEY)) {
      value.setRangeKey(Integer.valueOf(attributeMap.get(RANGE_KEY).n()));
    }
    if (attributeMap.containsKey("stringValue")) {
      value.setStringValue(attributeMap.get("stringValue").s());
    }
    if (attributeMap.containsKey("intValue")) {
      value.setIntValue(Integer.valueOf(attributeMap.get("intValue").n()));
    }
    if (attributeMap.containsKey("byteArrayValue")) {
      value.setByteArrayValue(attributeMap.get("byteArrayValue").b().asByteArray());
    }
    if (attributeMap.containsKey("stringSet")) {
      value.setStringSet(attributeMap.get("stringSet").ss().stream().collect(Collectors.toSet()));
    }
    if (attributeMap.containsKey("intSet")) {
      value.setIntSet(
        attributeMap.get("intSet").ns().stream().map(s -> Integer.valueOf(s)).collect(Collectors.toSet()));
    }
    if (attributeMap.containsKey("version")) {
      value.setVersion(Integer.valueOf(attributeMap.get("version").n()));
    }
    if (attributeMap.containsKey("doubleValue")) {
      value.setDoubleValue(Double.valueOf(attributeMap.get("doubleValue").n()));
    }
    if (attributeMap.containsKey("doubleSet")) {
      value.setDoubleSet(
        attributeMap.get("doubleSet").ns().stream().map(s -> Double.valueOf(s)).collect(Collectors.toSet()));
    }

    return value;
  }

  public static Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> baseClassToAttributeMap(
    Object TEST_VALUE
  ) {
    HashMap<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> attributes = new HashMap();

    if (TEST_VALUE instanceof  BaseClass) {
      attributes.put(
        HASH_KEY,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .n(String.valueOf(((BaseClass) TEST_VALUE).getHashKey())).build()
      );
      attributes.put(
        RANGE_KEY,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .n(String.valueOf(((BaseClass) TEST_VALUE).getRangeKey())).build()
      );
      attributes.put(
        "stringValue",
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .s(String.valueOf(((BaseClass) TEST_VALUE).getStringValue())).build()
      );
      attributes.put(
        "intValue",
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .n(String.valueOf(((BaseClass) TEST_VALUE).getIntValue())).build()
      );

      attributes.put(
        "byteArrayValue",
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .b(SdkBytes.fromByteArray(((BaseClass) TEST_VALUE).getByteArrayValue())).build()
      );
      attributes.put(
        "stringSet",
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .ss(((BaseClass) TEST_VALUE).getStringSet()).build()
      );
      attributes.put(
        "intSet",
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .ns(((BaseClass) TEST_VALUE).getIntSet().stream().map(i -> String.valueOf(i)).collect(Collectors.toList())).build()
      );
      attributes.put(
        "version",
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .n(String.valueOf(((BaseClass) TEST_VALUE).getVersion())).build()
      );
      attributes.put(
        "doubleValue",
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .n(String.valueOf(((BaseClass) TEST_VALUE).getDoubleValue())).build()
      );
      attributes.put(
        "doubleSet",
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .ns(((BaseClass) TEST_VALUE).getDoubleSet().stream().map(i -> String.valueOf(i)).collect(Collectors.toList())).build()
      );
    } else if (TEST_VALUE instanceof KeysOnly) {
      attributes.put(
        HASH_KEY,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .n(String.valueOf(((KeysOnly) TEST_VALUE).getHashKey())).build()
      );
      attributes.put(
        RANGE_KEY,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .n(String.valueOf(((KeysOnly) TEST_VALUE).getRangeKey())).build()
      );

    } else if (TEST_VALUE instanceof  HashKeyOnly) {
      attributes.put(
        HASH_KEY,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder()
          .s(((HashKeyOnly) TEST_VALUE).getHashKey()).build()
      );
    }

    return attributes;
  }


    public static IKeyring createStaticKeyring() {
    MaterialProviders matProv = MaterialProviders.builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    ByteBuffer key = ByteBuffer.wrap(new byte[32]);
    CreateRawAesKeyringInput keyringInput = CreateRawAesKeyringInput.builder()
      .keyName("name")
      .keyNamespace("namespace")
      .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
      .wrappingKey(key)
      .build();
    return matProv.CreateRawAesKeyring(keyringInput);
  }

}
