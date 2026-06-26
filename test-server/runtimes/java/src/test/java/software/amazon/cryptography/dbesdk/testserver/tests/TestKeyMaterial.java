// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.KmsClientBuilder;
import software.amazon.awssdk.services.kms.model.GetPublicKeyRequest;
import software.amazon.awssdk.services.kms.model.GetPublicKeyResponse;

/**
 * Test-only key-material helpers for the per-keyring round-trip suites.
 *
 * <p>Keys are generated at test time (not committed) purely to exercise the keyrings end-to-end.
 * The RSA PEM encoding here matches {@code RawRsaKeyringExample}: the public key is a PEM-wrapped
 * X.509 SubjectPublicKeyInfo and the private key is a PEM-wrapped PKCS#8 PrivateKeyInfo, both as
 * UTF-8 bytes — which is exactly what {@code CreateRawRsaKeyringInput} expects. We use
 * {@link java.util.Base64} + PEM headers (rather than BouncyCastle's {@code PemWriter}) so the
 * suites need no extra test dependency; {@link java.security.Key#getEncoded()} already returns the
 * SubjectPublicKeyInfo / PKCS#8 DER that those PEM labels denote.
 */
final class TestKeyMaterial {

  private TestKeyMaterial() {}

  /** Resolves the KMS key id, honoring the system-property / env-var override, else the demo key. */
  static String resolveKmsKeyId() {
    final String fromProperty = System.getProperty("testserver.kms.key.id");
    if (fromProperty != null && !fromProperty.isBlank()) {
      return fromProperty.trim();
    }
    final String fromEnv = System.getenv("TEST_SERVER_KMS_KEY_ID");
    if (fromEnv != null && !fromEnv.isBlank()) {
      return fromEnv.trim();
    }
    return DemoResources.KMS_KEY_ID;
  }

  /** Generates a fresh AES key of the given size in bits (e.g. 256) as raw key bytes. */
  static ByteBuffer generateAesKey(final int bits) {
    final KeyGenerator aesGen;
    try {
      aesGen = KeyGenerator.getInstance("AES");
    } catch (final NoSuchAlgorithmException e) {
      throw new RuntimeException("AES KeyGenerator unavailable", e);
    }
    aesGen.init(bits, new SecureRandom());
    final SecretKey key = aesGen.generateKey();
    return ByteBuffer.wrap(key.getEncoded());
  }

  /** Generates a fresh RSA key pair of the given modulus size in bits (e.g. 2048). */
  static KeyPair generateRsaKeyPair(final int bits) {
    final KeyPairGenerator rsaGen;
    try {
      rsaGen = KeyPairGenerator.getInstance("RSA");
    } catch (final NoSuchAlgorithmException e) {
      throw new RuntimeException("RSA KeyPairGenerator unavailable", e);
    }
    rsaGen.initialize(bits, new SecureRandom());
    return rsaGen.generateKeyPair();
  }

  /** PEM-encodes the public key as an X.509 SubjectPublicKeyInfo, returned as UTF-8 bytes. */
  static ByteBuffer publicKeyPemUtf8(final KeyPair keyPair) {
    return pemUtf8("PUBLIC KEY", keyPair.getPublic().getEncoded());
  }

  /** PEM-encodes the private key as a PKCS#8 PrivateKeyInfo, returned as UTF-8 bytes. */
  static ByteBuffer privateKeyPemUtf8(final KeyPair keyPair) {
    return pemUtf8("PRIVATE KEY", keyPair.getPrivate().getEncoded());
  }

  private static ByteBuffer pemUtf8(final String label, final byte[] der) {
    final String base64 = Base64.getMimeEncoder(64, "\n".getBytes(StandardCharsets.UTF_8))
        .encodeToString(der);
    final String pem =
        "-----BEGIN " + label + "-----\n" + base64 + "\n-----END " + label + "-----\n";
    return ByteBuffer.wrap(pem.getBytes(StandardCharsets.UTF_8));
  }

  // --- EC / ECDH helpers ------------------------------------------------------------------------

  /**
   * Generates a fresh EC key pair on the given standard curve (e.g. {@code "secp256r1"} for
   * P-256). Used by the Raw ECDH round-trip suite.
   */
  static KeyPair generateEcKeyPair(final String stdCurveName) {
    final KeyPairGenerator ecGen;
    try {
      ecGen = KeyPairGenerator.getInstance("EC");
      ecGen.initialize(new ECGenParameterSpec(stdCurveName), new SecureRandom());
    } catch (final NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
      throw new RuntimeException("EC KeyPairGenerator unavailable for curve " + stdCurveName, e);
    }
    return ecGen.generateKeyPair();
  }

  /**
   * PEM-encodes the EC private key as a PKCS#8 PrivateKeyInfo, returned as UTF-8 bytes — exactly
   * what {@code RawPrivateKeyToStaticPublicKeyInput.senderStaticPrivateKey} expects.
   */
  static ByteBuffer ecPrivateKeyPkcs8PemUtf8(final KeyPair keyPair) {
    return pemUtf8("PRIVATE KEY", keyPair.getPrivate().getEncoded());
  }

  /**
   * Returns the EC public key as raw DER-encoded X.509 SubjectPublicKeyInfo bytes — exactly what
   * the ECDH keyrings' {@code recipientPublicKey} expects ({@link java.security.Key#getEncoded()}
   * already returns SPKI DER).
   */
  static ByteBuffer ecPublicKeyDer(final KeyPair keyPair) {
    return ByteBuffer.wrap(keyPair.getPublic().getEncoded());
  }

  // --- KMS public-key helpers -------------------------------------------------------------------

  /**
   * Calls {@code kms:GetPublicKey} and returns the raw DER-encoded X.509 SubjectPublicKeyInfo
   * bytes. Used directly as the ECDH {@code recipientPublicKey} (DER), and wrapped to PEM for the
   * AWS KMS RSA keyring's {@code publicKey} (UTF-8 PEM).
   */
  static byte[] fetchKmsPublicKeyDer(final String kmsKeyId, final String region) {
    final KmsClientBuilder builder = KmsClient.builder();
    if (region != null && !region.isEmpty()) {
      builder.region(Region.of(region));
    }
    try (KmsClient kms = builder.build()) {
      final GetPublicKeyResponse response =
          kms.getPublicKey(GetPublicKeyRequest.builder().keyId(kmsKeyId).build());
      return response.publicKey().asByteArray();
    }
  }

  /**
   * Fetches the RSA public key from KMS and PEM-encodes it as a UTF-8 X.509 SubjectPublicKeyInfo —
   * exactly what {@code CreateAwsKmsRsaKeyringInput.publicKey} expects.
   */
  static ByteBuffer kmsRsaPublicKeyPemUtf8(final String kmsKeyId, final String region) {
    return pemUtf8("PUBLIC KEY", fetchKmsPublicKeyDer(kmsKeyId, region));
  }

  /** Fetches the ECC public key from KMS as raw DER X.509 SPKI bytes (ECDH recipient public key). */
  static ByteBuffer kmsEccPublicKeyDer(final String kmsKeyId, final String region) {
    return ByteBuffer.wrap(fetchKmsPublicKeyDer(kmsKeyId, region));
  }
}
