// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptools.dynamodbencryptionclientsdk2;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.amazonaws.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.AsymmetricStaticProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.CachingMostRecentProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.DirectKmsMaterialsProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.EncryptionMaterialsProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.SymmetricStaticProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.WrappedMaterialsProvider;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.store.MetaStore;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.store.ProviderStore;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.testing.*;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.testing.ScenarioManifest.KeyData;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.testing.ScenarioManifest.Keys;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.testing.ScenarioManifest.Scenario;

public class HolisticIT {

  private static final SecretKey aesKey =
      new SecretKeySpec(new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, "AES");
  private static final SecretKey hmacKey =
      new SecretKeySpec(new byte[] {0, 1, 2, 3, 4, 5, 6, 7}, "HmacSHA256");
  private static final String rsaEncPub =
      "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtiNSLSvT9cExXOcD0dGZ"
          + "9DFEMHw8895gAZcCdSppDrxbD7XgZiQYTlgt058i5fS+l11guAUJtKt5sZ2u8Fx0"
          + "K9pxMdlczGtvQJdx/LQETEnLnfzAijvHisJ8h6dQOVczM7t01KIkS24QZElyO+kY"
          + "qMWLytUV4RSHnrnIuUtPHCe6LieDWT2+1UBguxgtFt1xdXlquACLVv/Em3wp40Xc"
          + "bIwzhqLitb98rTY/wqSiGTz1uvvBX46n+f2j3geZKCEDGkWcXYw3dH4lRtDWTbqw"
          + "eRcaNDT/MJswQlBk/Up9KCyN7gjX67gttiCO6jMoTNDejGeJhG4Dd2o0vmn8WJlr"
          + "5wIDAQAB";
  private static final String rsaEncPriv =
      "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC2I1ItK9P1wTFc"
          + "5wPR0Zn0MUQwfDzz3mABlwJ1KmkOvFsPteBmJBhOWC3TnyLl9L6XXWC4BQm0q3mx"
          + "na7wXHQr2nEx2VzMa29Al3H8tARMScud/MCKO8eKwnyHp1A5VzMzu3TUoiRLbhBk"
          + "SXI76RioxYvK1RXhFIeeuci5S08cJ7ouJ4NZPb7VQGC7GC0W3XF1eWq4AItW/8Sb"
          + "fCnjRdxsjDOGouK1v3ytNj/CpKIZPPW6+8Ffjqf5/aPeB5koIQMaRZxdjDd0fiVG"
          + "0NZNurB5Fxo0NP8wmzBCUGT9Sn0oLI3uCNfruC22II7qMyhM0N6MZ4mEbgN3ajS+"
          + "afxYmWvnAgMBAAECggEBAIIU293zDWDZZ73oJ+w0fHXQsdjHAmlRitPX3CN99KZX"
          + "k9m2ldudL9bUV3Zqk2wUzgIg6LDEuFfWmAVojsaP4VBopKtriEFfAYfqIbjPgLpT"
          + "gh8FoyWW6D6MBJCFyGALjUAHQ7uRScathvt5ESMEqV3wKJTmdsfX97w/B8J+rLN3"
          + "3fT3ZJUck5duZ8XKD+UtX1Y3UE1hTWo3Ae2MFND964XyUqy+HaYXjH0x6dhZzqyJ"
          + "/OJ/MPGeMJgxp+nUbMWerwxrLQceNFVgnQgHj8e8k4fd04rkowkkPua912gNtmz7"
          + "DuIEvcMnY64z585cn+cnXUPJwtu3JbAmn/AyLsV9FLECgYEA798Ut/r+vORB16JD"
          + "KFu38pQCgIbdCPkXeI0DC6u1cW8JFhgRqi+AqSrEy5SzY3IY7NVMSRsBI9Y026Bl"
          + "R9OQwTrOzLRAw26NPSDvbTkeYXlY9+hX7IovHjGkho/OxyTJ7bKRDYLoNCz56BC1"
          + "khIWvECpcf/fZU0nqOFVFqF3H/UCgYEAwmJ4rjl5fksTNtNRL6ivkqkHIPKXzk5w"
          + "C+L90HKNicic9bqyX8K4JRkGKSNYN3mkjrguAzUlEld390qNBw5Lu7PwATv0e2i+"
          + "6hdwJsjTKNpj7Nh4Mieq6d7lWe1L8FLyHEhxgIeQ4BgqrVtPPOH8IBGpuzVZdWwI"
          + "dgOvEvAi/usCgYBdfk3NB/+SEEW5jn0uldE0s4vmHKq6fJwxWIT/X4XxGJ4qBmec"
          + "NbeoOAtMbkEdWbNtXBXHyMbA+RTRJctUG5ooNou0Le2wPr6+PMAVilXVGD8dIWpj"
          + "v9htpFvENvkZlbU++IKhCY0ICR++3ARpUrOZ3Hou/NRN36y9nlZT48tSoQKBgES2"
          + "Bi6fxmBsLUiN/f64xAc1lH2DA0I728N343xRYdK4hTMfYXoUHH+QjurvwXkqmI6S"
          + "cEFWAdqv7IoPYjaCSSb6ffYRuWP+LK4WxuAO0QV53SSViDdCalntHmlhRhyXVVnG"
          + "CckDIqT0JfHNev7savDzDWpNe2fUXlFJEBPDqrstAoGBAOpd5+QBHF/tP5oPILH4"
          + "aD/zmqMH7VtB+b/fOPwtIM+B/WnU7hHLO5t2lJYu18Be3amPkfoQIB7bpkM3Cer2"
          + "G7Jw+TcHrY+EtIziDB5vwau1fl4VcbA9SfWpBojJ5Ifo9ELVxGiK95WxeQNSmLUy"
          + "7AJzhK1Gwey8a/v+xfqiu9sE";
  private static final PrivateKey rsaPriv;
  private static final PublicKey rsaPub;
  private static final KeyPair rsaPair;
  private static final EncryptionMaterialsProvider symProv;
  private static final EncryptionMaterialsProvider asymProv;
  private static final EncryptionMaterialsProvider symWrappedProv;
  private static final String HASH_KEY = "hashKey";
  private static final String RANGE_KEY = "rangeKey";
  private static final String RSA = "RSA";
  private static final String tableName = "TableName";
  final EnumSet<EncryptionFlags> signOnly = EnumSet.of(EncryptionFlags.SIGN);
  final EnumSet<EncryptionFlags> encryptAndSign =
      EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN);

  private final LocalDynamoDb localDynamoDb = new LocalDynamoDb();
  private DynamoDbClient client;
  private static KmsClient kmsClient = KmsClient.builder().build();

  private static Map<String, KeyData> keyDataMap = new HashMap<>();

  private static final Map<String, AttributeValue> ENCRYPTED_TEST_VALUE = new HashMap<>();
  private static final Map<String, AttributeValue> MIXED_TEST_VALUE = new HashMap<>();
  private static final Map<String, AttributeValue> SIGNED_TEST_VALUE = new HashMap<>();
  private static final Map<String, AttributeValue> UNTOUCHED_TEST_VALUE = new HashMap<>();

  private static final Map<String, AttributeValue> ENCRYPTED_TEST_VALUE_2 = new HashMap<>();
  private static final Map<String, AttributeValue> MIXED_TEST_VALUE_2 = new HashMap<>();
  private static final Map<String, AttributeValue> SIGNED_TEST_VALUE_2 = new HashMap<>();
  private static final Map<String, AttributeValue> UNTOUCHED_TEST_VALUE_2 = new HashMap<>();

  private static final String TEST_VECTOR_MANIFEST_DIR = "/vectors/encrypted_item/";
  private static final String SCENARIO_MANIFEST_PATH = TEST_VECTOR_MANIFEST_DIR + "scenarios.json";
  private static final String JAVA_DIR = "java";

  static {
    try {
      KeyFactory rsaFact = KeyFactory.getInstance("RSA");
      rsaPub = rsaFact.generatePublic(new X509EncodedKeySpec(Base64.decode(rsaEncPub)));
      rsaPriv = rsaFact.generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(rsaEncPriv)));
      rsaPair = new KeyPair(rsaPub, rsaPriv);
    } catch (GeneralSecurityException ex) {
      throw new RuntimeException(ex);
    }
    symProv = new SymmetricStaticProvider(aesKey, hmacKey);
    asymProv = new AsymmetricStaticProvider(rsaPair, rsaPair);
    symWrappedProv = new WrappedMaterialsProvider(aesKey, aesKey, hmacKey);

    ENCRYPTED_TEST_VALUE.put("hashKey", AttributeValue.builder().n("5").build());
    ENCRYPTED_TEST_VALUE.put("rangeKey", AttributeValue.builder().n("7").build());
    ENCRYPTED_TEST_VALUE.put("version", AttributeValue.builder().n("0").build());
    ENCRYPTED_TEST_VALUE.put("intValue", AttributeValue.builder().n("123").build());
    ENCRYPTED_TEST_VALUE.put("stringValue", AttributeValue.builder().s("Hello world!").build());
    ENCRYPTED_TEST_VALUE.put(
        "byteArrayValue",
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
    ENCRYPTED_TEST_VALUE.put(
        "stringSet",
        AttributeValue.builder()
            .ss(new HashSet<>(Arrays.asList("Goodbye", "Cruel", "World", "?")))
            .build());
    ENCRYPTED_TEST_VALUE.put(
        "intSet",
        AttributeValue.builder()
            .ns(new HashSet<>(Arrays.asList("1", "200", "10", "15", "0")))
            .build());

    MIXED_TEST_VALUE.put("hashKey", AttributeValue.builder().n("6").build());
    MIXED_TEST_VALUE.put("rangeKey", AttributeValue.builder().n("8").build());
    MIXED_TEST_VALUE.put("version", AttributeValue.builder().n("0").build());
    MIXED_TEST_VALUE.put("intValue", AttributeValue.builder().n("123").build());
    MIXED_TEST_VALUE.put("stringValue", AttributeValue.builder().s("Hello world!").build());
    MIXED_TEST_VALUE.put(
        "byteArrayValue",
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
    MIXED_TEST_VALUE.put(
        "stringSet",
        AttributeValue.builder()
            .ss(new HashSet<>(Arrays.asList("Goodbye", "Cruel", "World", "?")))
            .build());
    MIXED_TEST_VALUE.put(
        "intSet",
        AttributeValue.builder()
            .ns(new HashSet<>(Arrays.asList("1", "200", "10", "15", "0")))
            .build());

    SIGNED_TEST_VALUE.put("hashKey", AttributeValue.builder().n("8").build());
    SIGNED_TEST_VALUE.put("rangeKey", AttributeValue.builder().n("10").build());
    SIGNED_TEST_VALUE.put("version", AttributeValue.builder().n("0").build());
    SIGNED_TEST_VALUE.put("intValue", AttributeValue.builder().n("123").build());
    SIGNED_TEST_VALUE.put("stringValue", AttributeValue.builder().s("Hello world!").build());
    SIGNED_TEST_VALUE.put(
        "byteArrayValue",
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
    SIGNED_TEST_VALUE.put(
        "stringSet",
        AttributeValue.builder()
            .ss(new HashSet<>(Arrays.asList("Goodbye", "Cruel", "World", "?")))
            .build());
    SIGNED_TEST_VALUE.put(
        "intSet",
        AttributeValue.builder()
            .ns(new HashSet<>(Arrays.asList("1", "200", "10", "15", "0")))
            .build());

    UNTOUCHED_TEST_VALUE.put("hashKey", AttributeValue.builder().n("7").build());
    UNTOUCHED_TEST_VALUE.put("rangeKey", AttributeValue.builder().n("9").build());
    UNTOUCHED_TEST_VALUE.put("version", AttributeValue.builder().n("0").build());
    UNTOUCHED_TEST_VALUE.put("intValue", AttributeValue.builder().n("123").build());
    UNTOUCHED_TEST_VALUE.put("stringValue", AttributeValue.builder().s("Hello world!").build());
    UNTOUCHED_TEST_VALUE.put(
        "byteArrayValue",
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
    UNTOUCHED_TEST_VALUE.put(
        "stringSet",
        AttributeValue.builder()
            .ss(new HashSet<String>(Arrays.asList("Goodbye", "Cruel", "World", "?")))
            .build());
    UNTOUCHED_TEST_VALUE.put(
        "intSet",
        AttributeValue.builder()
            .ns(new HashSet<String>(Arrays.asList("1", "200", "10", "15", "0")))
            .build());

    // STORING DOUBLES
    ENCRYPTED_TEST_VALUE_2.put("hashKey", AttributeValue.builder().n("5").build());
    ENCRYPTED_TEST_VALUE_2.put("rangeKey", AttributeValue.builder().n("7").build());
    ENCRYPTED_TEST_VALUE_2.put("version", AttributeValue.builder().n("0").build());
    ENCRYPTED_TEST_VALUE_2.put("intValue", AttributeValue.builder().n("123").build());
    ENCRYPTED_TEST_VALUE_2.put("stringValue", AttributeValue.builder().s("Hello world!").build());
    ENCRYPTED_TEST_VALUE_2.put(
        "byteArrayValue",
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
    ENCRYPTED_TEST_VALUE_2.put(
        "stringSet",
        AttributeValue.builder()
            .ss(new HashSet<>(Arrays.asList("Goodbye", "Cruel", "World", "?")))
            .build());
    ENCRYPTED_TEST_VALUE_2.put(
        "intSet",
        AttributeValue.builder()
            .ns(new HashSet<>(Arrays.asList("1", "200", "10", "15", "0")))
            .build());
    ENCRYPTED_TEST_VALUE_2.put(
        "doubleValue", AttributeValue.builder().n(String.valueOf(15)).build());
    ENCRYPTED_TEST_VALUE_2.put(
        "doubleSet",
        AttributeValue.builder()
            .ns(new HashSet<String>(Arrays.asList("15", "7.6", "-3", "-34.2", "0")))
            .build());

    MIXED_TEST_VALUE_2.put("hashKey", AttributeValue.builder().n("6").build());
    MIXED_TEST_VALUE_2.put("rangeKey", AttributeValue.builder().n("8").build());
    MIXED_TEST_VALUE_2.put("version", AttributeValue.builder().n("0").build());
    MIXED_TEST_VALUE_2.put("intValue", AttributeValue.builder().n("123").build());
    MIXED_TEST_VALUE_2.put("stringValue", AttributeValue.builder().s("Hello world!").build());
    MIXED_TEST_VALUE_2.put(
        "byteArrayValue",
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
    MIXED_TEST_VALUE_2.put(
        "stringSet",
        AttributeValue.builder()
            .ss(new HashSet<>(Arrays.asList("Goodbye", "Cruel", "World", "?")))
            .build());
    MIXED_TEST_VALUE_2.put(
        "intSet",
        AttributeValue.builder()
            .ns(new HashSet<>(Arrays.asList("1", "200", "10", "15", "0")))
            .build());
    MIXED_TEST_VALUE_2.put("doubleValue", AttributeValue.builder().n(String.valueOf(15)).build());
    MIXED_TEST_VALUE_2.put(
        "doubleSet",
        AttributeValue.builder()
            .ns(new HashSet<String>(Arrays.asList("15", "7.6", "-3", "-34.2", "0")))
            .build());

    SIGNED_TEST_VALUE_2.put("hashKey", AttributeValue.builder().n("8").build());
    SIGNED_TEST_VALUE_2.put("rangeKey", AttributeValue.builder().n("10").build());
    SIGNED_TEST_VALUE_2.put("version", AttributeValue.builder().n("0").build());
    SIGNED_TEST_VALUE_2.put("intValue", AttributeValue.builder().n("123").build());
    SIGNED_TEST_VALUE_2.put("stringValue", AttributeValue.builder().s("Hello world!").build());
    SIGNED_TEST_VALUE_2.put(
        "byteArrayValue",
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
    SIGNED_TEST_VALUE_2.put(
        "stringSet",
        AttributeValue.builder()
            .ss(new HashSet<>(Arrays.asList("Goodbye", "Cruel", "World", "?")))
            .build());
    SIGNED_TEST_VALUE_2.put(
        "intSet",
        AttributeValue.builder()
            .ns(new HashSet<>(Arrays.asList("1", "200", "10", "15", "0")))
            .build());
    SIGNED_TEST_VALUE_2.put("doubleValue", AttributeValue.builder().n(String.valueOf(15)).build());
    SIGNED_TEST_VALUE_2.put(
        "doubleSet",
        AttributeValue.builder()
            .ns(new HashSet<String>(Arrays.asList("15", "7.6", "-3", "-34.2", "0")))
            .build());

    UNTOUCHED_TEST_VALUE_2.put("hashKey", AttributeValue.builder().n("7").build());
    UNTOUCHED_TEST_VALUE_2.put("rangeKey", AttributeValue.builder().n("9").build());
    UNTOUCHED_TEST_VALUE_2.put("version", AttributeValue.builder().n("0").build());
    UNTOUCHED_TEST_VALUE_2.put("intValue", AttributeValue.builder().n("123").build());
    UNTOUCHED_TEST_VALUE_2.put("stringValue", AttributeValue.builder().s("Hello world!").build());
    UNTOUCHED_TEST_VALUE_2.put(
        "byteArrayValue",
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0, 1, 2, 3, 4, 5})).build());
    UNTOUCHED_TEST_VALUE_2.put(
        "stringSet",
        AttributeValue.builder()
            .ss(new HashSet<String>(Arrays.asList("Goodbye", "Cruel", "World", "?")))
            .build());
    UNTOUCHED_TEST_VALUE_2.put(
        "intSet",
        AttributeValue.builder()
            .ns(new HashSet<String>(Arrays.asList("1", "200", "10", "15", "0")))
            .build());
    UNTOUCHED_TEST_VALUE_2.put(
        "doubleValue", AttributeValue.builder().n(String.valueOf(15)).build());
    UNTOUCHED_TEST_VALUE_2.put(
        "doubleSet",
        AttributeValue.builder()
            .ns(new HashSet<String>(Arrays.asList("15", "7.6", "-3", "-34.2", "0")))
            .build());
  }

  @DataProvider(name = "getEncryptTestVectors")
  public static Object[][] getEncryptTestVectors() throws IOException {
    ScenarioManifest scenarioManifest =
        getManifestFromFile(SCENARIO_MANIFEST_PATH, new TypeReference<ScenarioManifest>() {});
    loadKeyData(scenarioManifest.keyDataPath);

    // Only use Java generated test vectors to dedupe the scenarios for encrypt,
    // we only care that we are able to generate data using the different provider configurations
    return scenarioManifest.scenarios.stream()
        .filter(s -> s.ciphertextPath.contains(JAVA_DIR))
        .map(s -> new Object[] {s})
        .toArray(Object[][]::new);
  }

  @DataProvider(name = "getDecryptTestVectors")
  public static Object[][] getDecryptTestVectors() throws IOException {
    ScenarioManifest scenarioManifest =
        getManifestFromFile(SCENARIO_MANIFEST_PATH, new TypeReference<ScenarioManifest>() {});
    loadKeyData(scenarioManifest.keyDataPath);

    return scenarioManifest.scenarios.stream().map(s -> new Object[] {s}).toArray(Object[][]::new);
  }

  @Test(dataProvider = "getDecryptTestVectors")
  public void decryptTestVector(Scenario scenario) throws IOException, GeneralSecurityException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();

    // load data into ciphertext tables
    createCiphertextTables(client);

    // load data from vector file
    putDataFromFile(client, scenario.ciphertextPath);

    // create and load metastore table if necessary
    ProviderStore metastore = null;
    if (scenario.metastore != null) {
      MetaStore.createTable(
          client,
          scenario.metastore.tableName,
          ProvisionedThroughput.builder().readCapacityUnits(100L).writeCapacityUnits(100L).build());
      putDataFromFile(client, scenario.metastore.path);
      EncryptionMaterialsProvider metaProvider =
          createProvider(
              scenario.metastore.providerName,
              scenario.materialName,
              scenario.metastore.keys,
              null);
      metastore =
          new MetaStore(
              client, scenario.metastore.tableName, DynamoDBEncryptor.getInstance(metaProvider));
    }

    // Create the mapper with the provider under test
    EncryptionMaterialsProvider provider =
        createProvider(scenario.providerName, scenario.materialName, scenario.keys, metastore);

    // Verify successful decryption
    switch (scenario.version) {
      case "v0":
        assertVersionCompatibility(provider, tableName);
        break;
      case "v1":
        assertVersionCompatibility_2(provider, tableName);
        break;
      default:
        throw new IllegalStateException(
            "Version " + scenario.version + " not yet implemented in test vector runner");
    }
    client.close();
    localDynamoDb.stop();
  }

  @Test(dataProvider = "getEncryptTestVectors")
  public void encryptWithTestVector(Scenario scenario) throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();

    // load data into ciphertext tables
    createCiphertextTables(client);

    // create and load metastore table if necessary
    ProviderStore metastore = null;
    if (scenario.metastore != null) {
      MetaStore.createTable(
          client,
          scenario.metastore.tableName,
          ProvisionedThroughput.builder().readCapacityUnits(100L).writeCapacityUnits(100L).build());
      putDataFromFile(client, scenario.metastore.path);
      EncryptionMaterialsProvider metaProvider =
          createProvider(
              scenario.metastore.providerName,
              scenario.materialName,
              scenario.metastore.keys,
              null);
      metastore =
          new MetaStore(
              client, scenario.metastore.tableName, DynamoDBEncryptor.getInstance(metaProvider));
    }

    // Encrypt data with the provider under test, only ensure that no exception is thrown
    EncryptionMaterialsProvider provider =
        createProvider(scenario.providerName, scenario.materialName, scenario.keys, metastore);
    generateStandardData(provider);
    client.close();
    localDynamoDb.stop();
  }

  private EncryptionMaterialsProvider createProvider(
      String providerName, String materialName, Keys keys, ProviderStore metastore) {
    switch (providerName) {
      case ScenarioManifest.MOST_RECENT_PROVIDER_NAME:
        return new CachingMostRecentProvider(metastore, materialName, 1000);
      case ScenarioManifest.STATIC_PROVIDER_NAME:
        KeyData decryptKeyData = keyDataMap.get(keys.decryptName);
        KeyData verifyKeyData = keyDataMap.get(keys.verifyName);
        SecretKey decryptKey =
            new SecretKeySpec(Base64.decode(decryptKeyData.material), decryptKeyData.algorithm);
        SecretKey verifyKey =
            new SecretKeySpec(Base64.decode(verifyKeyData.material), verifyKeyData.algorithm);
        return new SymmetricStaticProvider(decryptKey, verifyKey);
      case ScenarioManifest.WRAPPED_PROVIDER_NAME:
        decryptKeyData = keyDataMap.get(keys.decryptName);
        verifyKeyData = keyDataMap.get(keys.verifyName);

        // This can be either the asymmetric provider, where we should test using it's explicit
        // constructor,
        // or a wrapped symmetric where we use the wrapped materials constructor.
        if (decryptKeyData.keyType.equals(ScenarioManifest.SYMMETRIC_KEY_TYPE)) {
          decryptKey =
              new SecretKeySpec(Base64.decode(decryptKeyData.material), decryptKeyData.algorithm);
          verifyKey =
              new SecretKeySpec(Base64.decode(verifyKeyData.material), verifyKeyData.algorithm);
          return new WrappedMaterialsProvider(decryptKey, decryptKey, verifyKey);
        } else {
          KeyData encryptKeyData = keyDataMap.get(keys.encryptName);
          KeyData signKeyData = keyDataMap.get(keys.signName);
          try {
            // Hardcoded to use RSA for asymmetric keys. If we include vectors with a different
            // asymmetric scheme this will need to be updated.
            KeyFactory rsaFact = KeyFactory.getInstance(RSA);

            PublicKey encryptMaterial =
                rsaFact.generatePublic(
                    new X509EncodedKeySpec(Base64.decode(encryptKeyData.material)));
            PrivateKey decryptMaterial =
                rsaFact.generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.decode(decryptKeyData.material)));
            KeyPair decryptPair = new KeyPair(encryptMaterial, decryptMaterial);

            PublicKey verifyMaterial =
                rsaFact.generatePublic(
                    new X509EncodedKeySpec(Base64.decode(verifyKeyData.material)));
            PrivateKey signingMaterial =
                rsaFact.generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.decode(signKeyData.material)));
            KeyPair sigPair = new KeyPair(verifyMaterial, signingMaterial);

            return new AsymmetricStaticProvider(decryptPair, sigPair);
          } catch (GeneralSecurityException ex) {
            throw new RuntimeException(ex);
          }
        }
      case ScenarioManifest.AWS_KMS_PROVIDER_NAME:
        return new DirectKmsMaterialsProvider(kmsClient, keyDataMap.get(keys.decryptName).keyId);
      default:
        throw new IllegalStateException(
            "Provider " + providerName + " not yet implemented in test vector runner");
    }
  }

  // Create empty tables for the ciphertext.
  // The underlying structure to these tables is hardcoded,
  // and we run all test vectors assuming the ciphertext matches the key schema for these tables.
  private void createCiphertextTables(DynamoDbClient localDynamoDb) {
    // TableName Setup
    ArrayList<AttributeDefinition> attrDef = new ArrayList<>();
    attrDef.add(
        AttributeDefinition.builder()
            .attributeName(HASH_KEY)
            .attributeType(ScalarAttributeType.N)
            .build());

    attrDef.add(
        AttributeDefinition.builder()
            .attributeName(RANGE_KEY)
            .attributeType(ScalarAttributeType.N)
            .build());
    ArrayList<KeySchemaElement> keySchema = new ArrayList<>();
    keySchema.add(KeySchemaElement.builder().attributeName(HASH_KEY).keyType(KeyType.HASH).build());
    keySchema.add(
        KeySchemaElement.builder().attributeName(RANGE_KEY).keyType(KeyType.RANGE).build());

    localDynamoDb.createTable(
        CreateTableRequest.builder()
            .tableName("TableName")
            .attributeDefinitions(attrDef)
            .keySchema(keySchema)
            .provisionedThroughput(
                ProvisionedThroughput.builder()
                    .readCapacityUnits(100L)
                    .writeCapacityUnits(100L)
                    .build())
            .build());

    // HashKeyOnly SetUp
    attrDef = new ArrayList<>();
    attrDef.add(
        AttributeDefinition.builder()
            .attributeName(HASH_KEY)
            .attributeType(ScalarAttributeType.S)
            .build());

    keySchema = new ArrayList<>();
    keySchema.add(KeySchemaElement.builder().attributeName(HASH_KEY).keyType(KeyType.HASH).build());

    localDynamoDb.createTable(
        CreateTableRequest.builder()
            .tableName("HashKeyOnly")
            .attributeDefinitions(attrDef)
            .keySchema(keySchema)
            .provisionedThroughput(
                ProvisionedThroughput.builder()
                    .readCapacityUnits(100L)
                    .writeCapacityUnits(100L)
                    .build())
            .build());

    // DeterministicTable SetUp
    attrDef = new ArrayList<>();
    attrDef.add(
        AttributeDefinition.builder()
            .attributeName(HASH_KEY)
            .attributeType(ScalarAttributeType.B)
            .build());
    attrDef.add(
        AttributeDefinition.builder()
            .attributeName(RANGE_KEY)
            .attributeType(ScalarAttributeType.N)
            .build());

    keySchema = new ArrayList<>();
    keySchema.add(KeySchemaElement.builder().attributeName(HASH_KEY).keyType(KeyType.HASH).build());
    keySchema.add(
        KeySchemaElement.builder().attributeName(RANGE_KEY).keyType(KeyType.RANGE).build());

    localDynamoDb.createTable(
        CreateTableRequest.builder()
            .tableName("DeterministicTable")
            .attributeDefinitions(attrDef)
            .keySchema(keySchema)
            .provisionedThroughput(
                ProvisionedThroughput.builder()
                    .readCapacityUnits(100L)
                    .writeCapacityUnits(100L)
                    .build())
            .build());
  }

  // Given a file in the test vector ciphertext format, put those entries into their tables.
  // This assumes the expected tables have already been created.
  private void putDataFromFile(DynamoDbClient localDynamoDb, String filename) throws IOException {
    Map<String, List<Map<String, AttributeValue>>> manifest =
        getCiphertextManifestFromFile(filename);
    for (String tableName : manifest.keySet()) {
      for (Map<String, AttributeValue> attributes : manifest.get(tableName)) {
        localDynamoDb.putItem(
            PutItemRequest.builder().tableName(tableName).item(attributes).build());
      }
    }
  }

  private Map<String, List<Map<String, AttributeValue>>> getCiphertextManifestFromFile(
      String filename) throws IOException {
    return getManifestFromFile(
        TEST_VECTOR_MANIFEST_DIR + stripFilePath(filename),
        new TypeReference<Map<String, List<Map<String, DeserializedAttributeValue>>>>() {});
  }

  private static <T> T getManifestFromFile(String filename, TypeReference typeRef)
      throws IOException {
    final URL url = HolisticIT.class.getResource(filename);
    if (url == null) {
      throw new IllegalStateException("Missing file " + filename + " in src/test/resources.");
    }
    final File manifestFile = new File(url.getPath());
    final ObjectMapper manifestMapper = new ObjectMapper();
    return (T) manifestMapper.readValue(manifestFile, typeRef);
  }

  private static void loadKeyData(String filename) throws IOException {
    keyDataMap =
        getManifestFromFile(
            TEST_VECTOR_MANIFEST_DIR + stripFilePath(filename),
            new TypeReference<Map<String, KeyData>>() {});
  }

  public void generateStandardData(EncryptionMaterialsProvider prov) {
    DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(prov);
    Map<String, AttributeValue> encryptedRecord;
    Map<String, Set<EncryptionFlags>> actions;
    EncryptionContext encryptionContext =
        EncryptionContext.builder()
            .tableName(tableName)
            .hashKeyName("hashKey")
            .rangeKeyName("rangeKey")
            .build();
    Map<String, AttributeValue> hashKey1 = new HashMap<>();
    Map<String, AttributeValue> hashKey2 = new HashMap<>();
    Map<String, AttributeValue> hashKey3 = new HashMap<>();

    hashKey1.put("hashKey", AttributeValue.builder().s("Foo").build());
    hashKey2.put("hashKey", AttributeValue.builder().s("Bar").build());
    hashKey3.put("hashKey", AttributeValue.builder().s("Baz").build());

    // encrypted record
    actions = new HashMap<>();
    for (final String attr : ENCRYPTED_TEST_VALUE_2.keySet()) {
      switch (attr) {
        case "hashKey":
        case "rangeKey":
        case "version":
          actions.put(attr, signOnly);
          break;
        default:
          actions.put(attr, encryptAndSign);
          break;
      }
    }
    encryptedRecord = encryptor.encryptRecord(ENCRYPTED_TEST_VALUE_2, actions, encryptionContext);
    putItems(encryptedRecord, tableName);

    // mixed test record
    actions = new HashMap<>();
    for (final String attr : MIXED_TEST_VALUE_2.keySet()) {
      switch (attr) {
        case "rangeKey":
        case "hashKey":
        case "version":
        case "stringValue":
        case "doubleValue":
        case "doubleSet":
          actions.put(attr, signOnly);
          break;
        case "intValue":
          break;
        default:
          actions.put(attr, encryptAndSign);
          break;
      }
    }
    encryptedRecord = encryptor.encryptRecord(MIXED_TEST_VALUE_2, actions, encryptionContext);
    putItems(encryptedRecord, tableName);

    // sign only record
    actions = new HashMap<>();
    for (final String attr : SIGNED_TEST_VALUE_2.keySet()) {
      actions.put(attr, signOnly);
    }
    encryptedRecord = encryptor.encryptRecord(SIGNED_TEST_VALUE_2, actions, encryptionContext);
    putItems(encryptedRecord, tableName);

    // untouched record
    putItems(UNTOUCHED_TEST_VALUE_2, tableName);
  }

  private void putItems(Map<String, AttributeValue> map, String tableName) {
    PutItemRequest request = PutItemRequest.builder().item(map).tableName(tableName).build();
    client.putItem(request);
  }

  private Map<String, AttributeValue> getItems(Map<String, AttributeValue> map, String tableName) {
    GetItemRequest request = GetItemRequest.builder().key(map).tableName(tableName).build();
    return client.getItem(request).item();
  }

  private void assertVersionCompatibility(EncryptionMaterialsProvider provider, String tableName)
      throws GeneralSecurityException {
    DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(provider);
    Map<String, AttributeValue> response;
    Map<String, AttributeValue> decryptedRecord;
    EncryptionContext encryptionContext =
        EncryptionContext.builder()
            .tableName(tableName)
            .hashKeyName("hashKey")
            .rangeKeyName("rangeKey")
            .build();

    // Set up maps for table items
    HashMap<String, AttributeValue> untouched = new HashMap<>();
    HashMap<String, AttributeValue> signed = new HashMap<>();
    HashMap<String, AttributeValue> mixed = new HashMap<>();
    HashMap<String, AttributeValue> encrypted = new HashMap<>();
    HashMap<String, AttributeValue> hashKey1 = new HashMap<>();
    HashMap<String, AttributeValue> hashKey2 = new HashMap<>();
    HashMap<String, AttributeValue> hashKey3 = new HashMap<>();
    untouched.put("hashKey", UNTOUCHED_TEST_VALUE.get("hashKey"));
    untouched.put("rangeKey", UNTOUCHED_TEST_VALUE.get("rangeKey"));

    signed.put("hashKey", SIGNED_TEST_VALUE.get("hashKey"));
    signed.put("rangeKey", SIGNED_TEST_VALUE.get("rangeKey"));

    mixed.put("hashKey", MIXED_TEST_VALUE.get("hashKey"));
    mixed.put("rangeKey", MIXED_TEST_VALUE.get("rangeKey"));

    encrypted.put("hashKey", ENCRYPTED_TEST_VALUE.get("hashKey"));
    encrypted.put("rangeKey", ENCRYPTED_TEST_VALUE.get("rangeKey"));

    hashKey1.put("hashKey", AttributeValue.builder().s("Foo").build());
    hashKey2.put("hashKey", AttributeValue.builder().s("Bar").build());
    hashKey3.put("hashKey", AttributeValue.builder().s("Baz").build());

    // check untouched attr
    assertTrue(
        new DdbRecordMatcher(UNTOUCHED_TEST_VALUE, false).matches(getItems(untouched, tableName)));

    // check signed attr
    // Describe what actions need to be taken for each attribute
    Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
    for (final String attr : SIGNED_TEST_VALUE.keySet()) {
      actions.put(attr, signOnly);
    }
    response = getItems(signed, tableName);
    decryptedRecord = encryptor.decryptRecord(response, actions, encryptionContext);
    assertTrue(new DdbRecordMatcher(SIGNED_TEST_VALUE, false).matches(decryptedRecord));

    // check mixed attr
    actions = new HashMap<>();
    for (final String attr : MIXED_TEST_VALUE.keySet()) {
      switch (attr) {
        case "rangeKey":
        case "hashKey":
        case "version":
        case "stringValue":
          actions.put(attr, signOnly);
          break;
        case "intValue":
          break;
        default:
          actions.put(attr, encryptAndSign);
          break;
      }
    }
    response = getItems(mixed, tableName);
    decryptedRecord = encryptor.decryptRecord(response, actions, encryptionContext);
    assertTrue(new DdbRecordMatcher(MIXED_TEST_VALUE, false).matches(decryptedRecord));

    // check encrypted attr
    actions = new HashMap<>();
    for (final String attr : ENCRYPTED_TEST_VALUE.keySet()) {
      switch (attr) {
        case "hashKey":
        case "rangeKey":
        case "version":
          actions.put(attr, signOnly);
          break;
        default:
          actions.put(attr, encryptAndSign);
          break;
      }
    }
    response = getItems(encrypted, tableName);
    decryptedRecord = encryptor.decryptRecord(response, actions, encryptionContext);
    assertTrue(new DdbRecordMatcher(ENCRYPTED_TEST_VALUE, false).matches(decryptedRecord));

    assertEquals("Foo", getItems(hashKey1, "HashKeyOnly").get("hashKey").s());
    assertEquals("Bar", getItems(hashKey2, "HashKeyOnly").get("hashKey").s());
    assertEquals("Baz", getItems(hashKey3, "HashKeyOnly").get("hashKey").s());

    Map<String, AttributeValue> key = new HashMap<>();
    for (int i = 1; i <= 3; ++i) {
      key.put("hashKey", AttributeValue.builder().n("0").build());
      key.put("rangeKey", AttributeValue.builder().n(String.valueOf(i)).build());
      response = getItems(key, "TableName");
      assertEquals(0, Integer.parseInt(response.get("hashKey").n()));
      assertEquals(i, Integer.parseInt(response.get("rangeKey").n()));

      key.put("hashKey", AttributeValue.builder().n("1").build());
      key.put("rangeKey", AttributeValue.builder().n(String.valueOf(i)).build());
      response = getItems(key, "TableName");
      assertEquals(1, Integer.parseInt(response.get("hashKey").n()));
      assertEquals(i, Integer.parseInt(response.get("rangeKey").n()));

      key.put("hashKey", AttributeValue.builder().n(String.valueOf(4 + i)).build());
      key.put("rangeKey", AttributeValue.builder().n(String.valueOf(i)).build());
      response = getItems(key, "TableName");
      assertEquals(4 + i, Integer.parseInt(response.get("hashKey").n()));
      assertEquals(i, Integer.parseInt(response.get("rangeKey").n()));
    }
  }

  private void assertVersionCompatibility_2(EncryptionMaterialsProvider provider, String tableName)
      throws GeneralSecurityException {
    DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(provider);
    Map<String, AttributeValue> response;
    Map<String, AttributeValue> decryptedRecord;
    EncryptionContext encryptionContext =
        EncryptionContext.builder()
            .tableName(tableName)
            .hashKeyName("hashKey")
            .rangeKeyName("rangeKey")
            .build();

    // Set up maps for table items
    HashMap<String, AttributeValue> untouched = new HashMap<>();
    HashMap<String, AttributeValue> signed = new HashMap<>();
    HashMap<String, AttributeValue> mixed = new HashMap<>();
    HashMap<String, AttributeValue> encrypted = new HashMap<>();
    HashMap<String, AttributeValue> hashKey1 = new HashMap<>();
    HashMap<String, AttributeValue> hashKey2 = new HashMap<>();
    HashMap<String, AttributeValue> hashKey3 = new HashMap<>();

    untouched.put("hashKey", UNTOUCHED_TEST_VALUE_2.get("hashKey"));
    untouched.put("rangeKey", UNTOUCHED_TEST_VALUE_2.get("rangeKey"));

    signed.put("hashKey", SIGNED_TEST_VALUE_2.get("hashKey"));
    signed.put("rangeKey", SIGNED_TEST_VALUE_2.get("rangeKey"));

    mixed.put("hashKey", MIXED_TEST_VALUE_2.get("hashKey"));
    mixed.put("rangeKey", MIXED_TEST_VALUE_2.get("rangeKey"));

    encrypted.put("hashKey", ENCRYPTED_TEST_VALUE_2.get("hashKey"));
    encrypted.put("rangeKey", ENCRYPTED_TEST_VALUE_2.get("rangeKey"));

    hashKey1.put("hashKey", AttributeValue.builder().s("Foo").build());
    hashKey2.put("hashKey", AttributeValue.builder().s("Bar").build());
    hashKey3.put("hashKey", AttributeValue.builder().s("Baz").build());

    // check untouched attr
    assert new DdbRecordMatcher(UNTOUCHED_TEST_VALUE_2, false)
        .matches(getItems(untouched, tableName));

    // check signed attr
    // Describe what actions need to be taken for each attribute
    Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
    for (final String attr : SIGNED_TEST_VALUE_2.keySet()) {
      actions.put(attr, signOnly);
    }
    response = getItems(signed, tableName);
    decryptedRecord = encryptor.decryptRecord(response, actions, encryptionContext);
    assertTrue(new DdbRecordMatcher(SIGNED_TEST_VALUE_2, false).matches(decryptedRecord));

    // check mixed attr
    actions = new HashMap<>();
    for (final String attr : MIXED_TEST_VALUE_2.keySet()) {
      switch (attr) {
        case "rangeKey":
        case "hashKey":
        case "version":
        case "stringValue":
        case "doubleValue":
        case "doubleSet":
          actions.put(attr, signOnly);
          break;
        case "intValue":
          break;
        default:
          actions.put(attr, encryptAndSign);
          break;
      }
    }
    response = getItems(mixed, tableName);
    decryptedRecord = encryptor.decryptRecord(response, actions, encryptionContext);
    assertTrue(new DdbRecordMatcher(MIXED_TEST_VALUE_2, false).matches(decryptedRecord));

    // check encrypted attr
    actions = new HashMap<>();
    for (final String attr : ENCRYPTED_TEST_VALUE_2.keySet()) {
      switch (attr) {
        case "hashKey":
        case "rangeKey":
        case "version":
          actions.put(attr, signOnly);
          break;
        default:
          actions.put(attr, encryptAndSign);
          break;
      }
    }
    response = getItems(encrypted, tableName);
    decryptedRecord = encryptor.decryptRecord(response, actions, encryptionContext);
    assertTrue(new DdbRecordMatcher(ENCRYPTED_TEST_VALUE_2, false).matches(decryptedRecord));

    // check HashKey Table
    assertEquals("Foo", getItems(hashKey1, "HashKeyOnly").get("hashKey").s());
    assertEquals("Bar", getItems(hashKey2, "HashKeyOnly").get("hashKey").s());
    assertEquals("Baz", getItems(hashKey3, "HashKeyOnly").get("hashKey").s());

    // Check Hash and Range Key Values
    Map<String, AttributeValue> key = new HashMap<>();
    for (int i = 1; i <= 3; ++i) {
      key.put("hashKey", AttributeValue.builder().n("0").build());
      key.put("rangeKey", AttributeValue.builder().n(String.valueOf(i)).build());
      response = getItems(key, tableName);
      assertEquals(0, Integer.parseInt(response.get("hashKey").n()));
      assertEquals(i, Integer.parseInt(response.get("rangeKey").n()));

      key.put("hashKey", AttributeValue.builder().n("1").build());
      key.put("rangeKey", AttributeValue.builder().n(String.valueOf(i)).build());
      response = getItems(key, tableName);
      assertEquals(1, Integer.parseInt(response.get("hashKey").n()));
      assertEquals(i, Integer.parseInt(response.get("rangeKey").n()));

      key.put("hashKey", AttributeValue.builder().n(String.valueOf(4 + i)).build());
      key.put("rangeKey", AttributeValue.builder().n(String.valueOf(i)).build());
      response = getItems(key, tableName);
      assertEquals(4 + i, Integer.parseInt(response.get("hashKey").n()));
      assertEquals(i, Integer.parseInt(response.get("rangeKey").n()));
    }
  }

  private static String stripFilePath(String path) {
    return path.replaceFirst("file://", "");
  }

  @JsonDeserialize(using = AttributeValueDeserializer.class)
  public abstract static class DeserializedAttributeValue implements AttributeValue.Builder {}
}
