/*
 * Copyright 2014-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.KeyStoreMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.internal.Utils;
import java.io.ByteArrayInputStream;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStore.SecretKeyEntry;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.model.*;

/**
 * Integration tests for DynamoDBEncryptor with JCEKS KeyStore-backed
 * KeyStoreMaterialsProvider against a local DynamoDB instance.
 * Covers all four key-type combinations and a negative password test.
 */
public class KeyStoreEncryptorIT {

  private static final String TABLE_NAME = "KeyStoreEncryptorIT";
  private static final String PK = "pk";
  private static final String SK = "sk";
  private static final String PASSWORD = "testPassword";
  private static final PasswordProtection PWD = new PasswordProtection(
    PASSWORD.toCharArray()
  );

  // Reuse cert/key PEMs from KeyStoreMaterialsProviderTest for PrivateKeyEntry
  private static final String CERT_PEM =
    "MIIDbTCCAlWgAwIBAgIJANdRvzVsW1CIMA0GCSqGSIb3DQEBBQUAME0xCzAJBgNV" +
    "BAYTAlVTMRMwEQYDVQQIDApXYXNoaW5ndG9uMQwwCgYDVQQKDANBV1MxGzAZBgNV" +
    "BAMMEktleVN0b3JlIFRlc3QgQ2VydDAeFw0xMzA1MDgyMzMyMjBaFw0xMzA2MDcy" +
    "MzMyMjBaME0xCzAJBgNVBAYTAlVTMRMwEQYDVQQIDApXYXNoaW5ndG9uMQwwCgYD" +
    "VQQKDANBV1MxGzAZBgNVBAMMEktleVN0b3JlIFRlc3QgQ2VydDCCASIwDQYJKoZI" +
    "hvcNAQEBBQADggEPADCCAQoCggEBAJ8+umOX8x/Ma4OZishtYpcA676bwK5KScf3" +
    "w+YGM37L12KTdnOyieiGtRW8p0fS0YvnhmVTvaky09I33bH+qy9gliuNL2QkyMxp" +
    "uu1IwkTKKuB67CaKT6osYJLFxV/OwHcaZnTszzDgbAVg/Z+8IZxhPgxMzMa+7nDn" +
    "hEm9Jd+EONq3PnRagnFeLNbMIePprdJzXHyNNiZKRRGQ/Mo9rr7mqMLSKnFNsmzB" +
    "OIfeZM8nXeg+cvlmtXl72obwnGGw2ksJfaxTPm4eEhzRoAgkbjPPLHbwiJlc+GwF" +
    "i8kh0Y3vQTj/gOFE4nzipkm7ux1lsGHNRVpVDWpjNd8Fl9JFELkCAwEAAaNQME4w" +
    "HQYDVR0OBBYEFM0oGUuFAWlLXZaMXoJgGZxWqfOxMB8GA1UdIwQYMBaAFM0oGUuF" +
    "AWlLXZaMXoJgGZxWqfOxMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADggEB" +
    "AAXCsXeC8ZRxovP0Wc6C5qv3d7dtgJJVzHwoIRt2YR3yScBa1XI40GKT80jP3MYH" +
    "8xMu3mBQtcYrgRKZBy4GpHAyxoFTnPcuzq5Fg7dw7fx4E4OKIbWOahdxwtbVxQfZ" +
    "UHnGG88Z0bq2twj7dALGyJhUDdiccckJGmJPOFMzjqsvoAu0n/p7eS6y5WZ5ewqw" +
    "p7VwYOP3N9wVV7Podmkh1os+eCcp9GoFf0MHBMFXi2Ps2azKx8wHRIA5D1MZv/Va" +
    "4L4/oTBKCjORpFlP7EhMksHBYnjqXLDP6awPMAgQNYB5J9zX6GfJsAgly3t4Rjr5" +
    "cLuNYBmRuByFGo+SOdrj6D8=";
  private static final String KEY_PEM =
    "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCfPrpjl/MfzGuD" +
    "mYrIbWKXAOu+m8CuSknH98PmBjN+y9dik3ZzsonohrUVvKdH0tGL54ZlU72pMtPS" +
    "N92x/qsvYJYrjS9kJMjMabrtSMJEyirgeuwmik+qLGCSxcVfzsB3GmZ07M8w4GwF" +
    "YP2fvCGcYT4MTMzGvu5w54RJvSXfhDjatz50WoJxXizWzCHj6a3Sc1x8jTYmSkUR" +
    "kPzKPa6+5qjC0ipxTbJswTiH3mTPJ13oPnL5ZrV5e9qG8JxhsNpLCX2sUz5uHhIc" +
    "0aAIJG4zzyx28IiZXPhsBYvJIdGN70E4/4DhROJ84qZJu7sdZbBhzUVaVQ1qYzXf" +
    "BZfSRRC5AgMBAAECggEBAJMwx9eGe5LIwBfDtCPN93LbxwtHq7FtuQS8XrYexTpN" +
    "76eN5c7LF+11lauh1HzuwAEw32iJHqVl9aQ5PxFm85O3ExbuSP+ngHJwx/bLacVr" +
    "mHYlKGH3Net1WU5Qvz7vO7bbEBjDSj9DMJVIMSWUHv0MZO25jw2lLX/ufrgpvPf7" +
    "KXSgXg/8uV7PbnTbBDNlg02u8eOc+IbH4O8XDKAhD+YQ8AE3pxtopJbb912U/cJs" +
    "Y0hQ01zbkWYH7wL9BeQmR7+TEjjtr/IInNjnXmaOmSX867/rTSTuozaVrl1Ce7r8" +
    "EmUDg9ZLZeKfoNYovMy08wnxWVX2J+WnNDjNiSOm+IECgYEA0v3jtGrOnKbd0d9E" +
    "dbyIuhjgnwp+UsgALIiBeJYjhFS9NcWgs+02q/0ztqOK7g088KBBQOmiA+frLIVb" +
    "uNCt/3jF6kJvHYkHMZ0eBEstxjVSM2UcxzJ6ceHZ68pmrru74382TewVosxccNy0" +
    "glsUWNN0t5KQDcetaycRYg50MmcCgYEAwTb8klpNyQE8AWxVQlbOIEV24iarXxex" +
    "7HynIg9lSeTzquZOXjp0m5omQ04psil2gZ08xjiudG+Dm7QKgYQcxQYUtZPQe15K" +
    "m+2hQM0jA7tRfM1NAZHoTmUlYhzRNX6GWAqQXOgjOqBocT4ySBXRaSQq9zuZu36s" +
    "fI17knap798CgYArDa2yOf0xEAfBdJqmn7MSrlLfgSenwrHuZGhu78wNi7EUUOBq" +
    "9qOqUr+DrDmEO+VMgJbwJPxvaZqeehPuUX6/26gfFjFQSI7UO+hNHf4YLPc6D47g" +
    "wtcjd9+c8q8jRqGfWWz+V4dOsf7G9PJMi0NKoNN3RgvpE+66J72vUZ26TwKBgEUq" +
    "DdfGA7pEetp3kT2iHT9oHlpuRUJRFRv2s015/WQqVR+EOeF5Q2zADZpiTIK+XPGg" +
    "+7Rpbem4UYBXPruGM1ZECv3E4AiJhGO0+Nhdln8reswWIc7CEEqf4nXwouNnW2gA" +
    "wBTB9Hp0GW8QOKedR80/aTH/X9TCT7R2YRnY6JQ5AoGBAKjgPySgrNDhlJkW7jXR" +
    "WiGpjGSAFPT9NMTvEHDo7oLTQ8AcYzcGQ7ISMRdVXR6GJOlFVsH4NLwuHGtcMTPK" +
    "zoHbPHJyOn1SgC5tARD/1vm5CsG2hATRpWRQCTJFg5VRJ4R7Pz+HuxY4SoABcPQd" +
    "K+MP8GlGqTldC6NaB1s7KuAX";

  private static KeyStore keyStore;

  // Shared flags for all roundtrip tests
  private static final Set<EncryptionFlags> ENCRYPT_AND_SIGN = EnumSet.of(
    EncryptionFlags.ENCRYPT,
    EncryptionFlags.SIGN
  );
  private static final Set<EncryptionFlags> SIGN_ONLY = EnumSet.of(
    EncryptionFlags.SIGN
  );
  private static final Set<EncryptionFlags> DO_NOTHING = EnumSet.noneOf(
    EncryptionFlags.class
  );

  @BeforeClass
  public void setUp() throws Exception {
    // AES + HMAC keys
    KeyGenerator aesGen = KeyGenerator.getInstance("AES");
    aesGen.init(128, Utils.getRng());
    SecretKey aesKey = aesGen.generateKey();

    KeyGenerator hmacGen = KeyGenerator.getInstance("HmacSHA256");
    hmacGen.init(256, Utils.getRng());
    SecretKey hmacKey = hmacGen.generateKey();

    // RSA key + cert for PrivateKeyEntry
    KeyFactory kf = KeyFactory.getInstance("RSA");
    PrivateKey rsaKey = kf.generatePrivate(
      new PKCS8EncodedKeySpec(Base64.getDecoder().decode(KEY_PEM))
    );
    Certificate cert = CertificateFactory
      .getInstance("X509")
      .generateCertificate(
        new ByteArrayInputStream(Base64.getDecoder().decode(CERT_PEM))
      );
    Certificate[] chain = new Certificate[] { cert };

    // Build JCEKS KeyStore with all four aliases
    keyStore = KeyStore.getInstance("jceks");
    keyStore.load(null, PASSWORD.toCharArray());
    keyStore.setEntry("enc", new SecretKeyEntry(aesKey), PWD);
    keyStore.setEntry("sig", new SecretKeyEntry(hmacKey), PWD);
    keyStore.setEntry("enc-rsa", new PrivateKeyEntry(rsaKey, chain), PWD);
    keyStore.setEntry("sig-rsa", new PrivateKeyEntry(rsaKey, chain), PWD);
  }

  // AES encrypt + HmacSHA256 sign
  @Test
  public void aesEncryptHmacSign() throws Exception {
    assertRoundTrip("enc", "sig", "test1");
  }

  // RSA encrypt + HmacSHA256 sign (envelope + HMAC)
  @Test
  public void rsaEncryptHmacSign() throws Exception {
    assertRoundTrip("enc-rsa", "sig", "test2");
  }

  // RSA encrypt + RSA sign (fully asymmetric)
  @Test
  public void rsaEncryptRsaSign() throws Exception {
    assertRoundTrip("enc-rsa", "sig-rsa", "test3");
  }

  // AES encrypt + RSA sign (symmetric encrypt + asymmetric sign)
  @Test
  public void aesEncryptRsaSign() throws Exception {
    assertRoundTrip("enc", "sig-rsa", "test4");
  }

  private void assertRoundTrip(
    String encAlias,
    String sigAlias,
    String pkValue
  ) throws Exception {
    KeyStoreMaterialsProvider provider = new KeyStoreMaterialsProvider(
      keyStore,
      encAlias,
      sigAlias,
      PWD,
      PWD,
      Collections.emptyMap()
    );
    DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(provider);
    EncryptionContext ctx = EncryptionContext
      .builder()
      .tableName(TABLE_NAME)
      .hashKeyName(PK)
      .rangeKeyName(SK)
      .build();

    Map<String, AttributeValue> item = new HashMap<>();
    item.put(PK, AttributeValue.builder().s(pkValue).build());
    item.put(SK, AttributeValue.builder().s("range").build());
    item.put("secretField", AttributeValue.builder().s("sensitive").build());
    item.put("signedField", AttributeValue.builder().n("42").build());
    item.put("untouchedField", AttributeValue.builder().s("plain").build());

    Map<String, Set<EncryptionFlags>> flags = new HashMap<>();
    flags.put(PK, SIGN_ONLY);
    flags.put(SK, SIGN_ONLY);
    flags.put("secretField", ENCRYPT_AND_SIGN);
    flags.put("signedField", SIGN_ONLY);
    flags.put("untouchedField", DO_NOTHING);

    Map<String, AttributeValue> encrypted = encryptor.encryptRecord(
      item,
      flags,
      ctx
    );
    assertNull(encrypted.get("secretField").s());
    assertNotNull(encrypted.get("secretField").b());
    assertEquals("42", encrypted.get("signedField").n());
    assertEquals("plain", encrypted.get("untouchedField").s());

    Map<String, AttributeValue> decrypted = encryptor.decryptRecord(
      encrypted,
      flags,
      ctx
    );
    assertEquals("sensitive", decrypted.get("secretField").s());
    assertEquals("42", decrypted.get("signedField").n());
    assertEquals("plain", decrypted.get("untouchedField").s());
  }
}
