// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.CryptoSchemaCanonizer.CanonicalCryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.FooterSerializer.SignedField;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.*;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.CommitmentPolicy;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.DBECommitmentPolicy;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsInput;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsOutput;
import software.amazon.cryptography.materialproviders.model.DecryptionMaterials;
import software.amazon.cryptography.materialproviders.model.EncryptionMaterials;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsInput;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsOutput;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Orchestrates the encrypt and decrypt path structure operations.
 *
 * //= specification/structured-encryption/encrypt-path-structure.md#behavior
 * //# 1. Retrieve Encryption Materials
 * //# 2. Calculate Intermediate Encrypted Structured Data
 * //# 3. Construct Encrypted Structured Data
 */
public final class StructuredEncryptionImpl {

  private static final SecureRandom SECURE_RANDOM = new SecureRandom();

  private StructuredEncryptionImpl() {}

  /**
   * Encrypt a path structure.
   */
  public static EncryptPathStructureOutput encryptPathStructure(
    String tableName,
    List<CryptoItem> plaintextStructure,
    ICryptographicMaterialsManager cmm,
    DBEAlgorithmSuiteId algorithmSuiteId,
    Map<String, String> encryptionContext
  ) {
    // 1. Canonicalize and build legend
    List<CanonicalCryptoItem> canonItems = CryptoSchemaCanonizer.canonicalize(tableName, plaintextStructure);
    byte[] legend = CryptoSchemaCanonizer.buildLegend(canonItems);

    // Determine version and flavor
    boolean hasContext = canonItems.stream()
      .anyMatch(i -> CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.equals(i.action));
    byte version = hasContext ? FORMAT_VERSION_2 : FORMAT_VERSION_1;

    boolean hasSignature = algorithmSuiteId == null ||
      DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384
        .equals(algorithmSuiteId);
    byte flavor = hasSignature ? FLAVOR_WITH_SIGNATURE : FLAVOR_NO_SIGNATURE;

    // Count encrypted fields for max plaintext length
    long encryptedCount = canonItems.stream()
      .filter(i -> CryptoAction.ENCRYPT_AND_SIGN.equals(i.action)).count();
    long totalSize = canonItems.stream()
      .filter(i -> CryptoAction.ENCRYPT_AND_SIGN.equals(i.action))
      .mapToLong(i -> i.data.value() != null ? i.data.value().remaining() : 0).sum();
    long maxPlaintextLength = encryptedCount * 2 + totalSize;

    // 2. Get encryption materials
    if (encryptionContext == null) encryptionContext = new HashMap<>();
    GetEncryptionMaterialsInput.Builder matInputBuilder = GetEncryptionMaterialsInput.builder()
      .encryptionContext(encryptionContext)
      .commitmentPolicy(CommitmentPolicy.builder()
        .DBE(DBECommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT).build())
      .maxPlaintextLength(maxPlaintextLength);
    if (algorithmSuiteId != null) {
      matInputBuilder.algorithmSuiteId(AlgorithmSuiteId.builder().DBE(algorithmSuiteId).build());
    }
    GetEncryptionMaterialsOutput materialsOutput = cmm.GetEncryptionMaterials(matInputBuilder.build());
    EncryptionMaterials materials = materialsOutput.encryptionMaterials();
    byte[] plaintextDataKey = toByteArray(materials.plaintextDataKey());

    // 3. Generate message ID
    byte[] messageId = new byte[MSG_ID_LEN];
    SECURE_RANDOM.nextBytes(messageId);

    // 4. Derive keys
    byte[] fieldRootKey = FieldEncryptor.deriveFieldRootKey(plaintextDataKey, messageId);

    // 5. Encrypt fields
    List<CryptoItem> encryptedItems = new ArrayList<>();
    int encryptOffset = 0;
    for (CryptoItem item : plaintextStructure) {
      if (CryptoAction.ENCRYPT_AND_SIGN.equals(item.action())) {
        byte[] fieldKey = FieldEncryptor.deriveFieldKey(fieldRootKey, encryptOffset);
        byte[] cipherKey = FieldEncryptor.getCipherKey(fieldKey);
        byte[] nonce = FieldEncryptor.getNonce(fieldKey);
        byte[] aad = CanonicalPath.canonPath(tableName, item.key());
        byte[] plaintext = toByteArray(item.data().value());
        byte[] typeId = toByteArray(item.data().typeId());
        byte[] ciphertext = FieldEncryptor.encrypt(cipherKey, nonce, plaintext, aad);

        // Output: typeId=0xFFFF, value = originalTypeId + ciphertext
        byte[] encValue = new byte[2 + ciphertext.length];
        System.arraycopy(typeId, 0, encValue, 0, 2);
        System.arraycopy(ciphertext, 0, encValue, 2, ciphertext.length);

        encryptedItems.add(CryptoItem.builder()
          .key(item.key())
          .data(StructuredDataTerminal.builder()
            .typeId(ByteBuffer.wrap(BYTES_TYPE_ID))
            .value(ByteBuffer.wrap(encValue))
            .build())
          .action(item.action())
          .build());
        encryptOffset++;
      } else {
        encryptedItems.add(item);
      }
    }

    // 6. Build header
    Map<String, String> storedEC = materials.encryptionContext();
    byte[] partialHeader = HeaderSerializer.serializePartialHeader(
      version, flavor, messageId, legend, storedEC, materials.encryptedDataKeys());
    byte[] commitKey = HeaderCommitment.deriveCommitKey(plaintextDataKey, messageId);
    byte[] commitment = HeaderCommitment.computeCommitment(commitKey, partialHeader);
    byte[] fullHeader = HeaderSerializer.serializeFullHeader(partialHeader, commitment);

    // 7. Build footer
    List<SignedField> signedFields = buildSignedFields(tableName, encryptedItems, canonItems);
    byte[] canonicalHash = FooterSerializer.computeCanonicalHash(fullHeader, storedEC, signedFields);

    List<byte[]> symKeys = materials.symmetricSigningKeys().stream()
      .map(StructuredEncryptionImpl::toByteArray).collect(Collectors.toList());
    byte[] recipientTags = FooterSerializer.computeRecipientTags(canonicalHash, symKeys);

    byte[] signature = null;
    if (flavor == FLAVOR_WITH_SIGNATURE && materials.signingKey() != null) {
      ECPrivateKey ecKey = extractEcPrivateKey(toByteArray(materials.signingKey()));
      signature = FooterSerializer.computeSignature(canonicalHash, ecKey);
    }
    byte[] footer = FooterSerializer.serializeFooter(recipientTags, signature);

    // 8. Build output: encrypted items + header + footer
    List<CryptoItem> outputItems = new ArrayList<>(encryptedItems);
    outputItems.add(CryptoItem.builder()
      .key(HEADER_PATH)
      .data(StructuredDataTerminal.builder()
        .typeId(ByteBuffer.wrap(BYTES_TYPE_ID))
        .value(ByteBuffer.wrap(fullHeader))
        .build())
      .action(CryptoAction.DO_NOTHING)
      .build());
    outputItems.add(CryptoItem.builder()
      .key(FOOTER_PATH)
      .data(StructuredDataTerminal.builder()
        .typeId(ByteBuffer.wrap(BYTES_TYPE_ID))
        .value(ByteBuffer.wrap(footer))
        .build())
      .action(CryptoAction.DO_NOTHING)
      .build());

    // Build parsed header for output
    ParsedHeader parsedHeader = ParsedHeader.builder()
      .algorithmSuiteId(materials.algorithmSuite().id().DBE())
      .encryptedDataKeys(materials.encryptedDataKeys())
      .storedEncryptionContext(storedEC)
      .encryptionContext(encryptionContext)
      .build();

    return EncryptPathStructureOutput.builder()
      .encryptedStructure(outputItems)
      .parsedHeader(parsedHeader)
      .build();
  }

  private static List<SignedField> buildSignedFields(
    String tableName, List<CryptoItem> items, List<CanonicalCryptoItem> canonItems
  ) {
    // Build signed fields sorted by canonical path (already sorted in canonItems)
    List<SignedField> fields = new ArrayList<>();
    for (CanonicalCryptoItem ci : canonItems) {
      // Find the corresponding item in the (possibly encrypted) list
      CryptoItem item = items.stream()
        .filter(i -> i.key().equals(ci.originalPath))
        .findFirst().orElse(null);
      if (item == null) continue;

      boolean encrypted = CryptoAction.ENCRYPT_AND_SIGN.equals(ci.action);
      byte[] typeId = encrypted ? toByteArray(ci.data.typeId()) : toByteArray(item.data().typeId());
      byte[] value = toByteArray(item.data().value());
      fields.add(new SignedField(ci.canonicalPath, typeId, value, encrypted));
    }
    return fields;
  }

  /**
   * Decrypt a path structure.
   */
  public static DecryptPathStructureOutput decryptPathStructure(
    String tableName,
    List<AuthItem> encryptedStructure,
    ICryptographicMaterialsManager cmm,
    Map<String, String> encryptionContext
  ) {
    // 1. Extract header and footer from the structure
    byte[] headerBytes = null;
    byte[] footerBytes = null;
    for (AuthItem item : encryptedStructure) {
      String key = item.key().get(0).member().key();
      if (HEADER_FIELD.equals(key)) {
        headerBytes = toByteArray(item.data().value());
      } else if (FOOTER_FIELD.equals(key)) {
        footerBytes = toByteArray(item.data().value());
      }
    }
    if (headerBytes == null) throw new RuntimeException("Missing header field aws_dbe_head");
    if (footerBytes == null) throw new RuntimeException("Missing footer field aws_dbe_foot");

    // 2. Deserialize header
    HeaderDeserializer.ParsedHeader parsedHeader = HeaderDeserializer.deserialize(headerBytes);

    // 3. Resolve auth actions from legend
    List<CryptoItem> resolvedActions = CryptoSchemaCanonizer.resolveAuthActions(
      tableName, encryptedStructure, parsedHeader.legend);

    // 4. Get decryption materials
    if (encryptionContext == null) encryptionContext = new HashMap<>();
    // Merge stored EC from header with provided EC
    Map<String, String> fullEC = new HashMap<>(encryptionContext);
    fullEC.putAll(parsedHeader.encryptionContext);

    List<String> requiredECKeys = new ArrayList<>(encryptionContext.keySet());

    DecryptMaterialsOutput materialsOutput = cmm.DecryptMaterials(
      DecryptMaterialsInput.builder()
        .encryptionContext(fullEC)
        .commitmentPolicy(CommitmentPolicy.builder()
          .DBE(DBECommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT).build())
        .algorithmSuiteId(AlgorithmSuiteId.builder()
          .DBE(parsedHeader.flavor == FLAVOR_WITH_SIGNATURE
            ? DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384
            : DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
          .build())
        .encryptedDataKeys(parsedHeader.encryptedDataKeys)
        .reproducedEncryptionContext(encryptionContext)
        .build()
    );
    DecryptionMaterials materials = materialsOutput.decryptionMaterials();
    byte[] plaintextDataKey = toByteArray(materials.plaintextDataKey());

    // 5. Verify header commitment
    byte[] commitKey = HeaderCommitment.deriveCommitKey(plaintextDataKey, parsedHeader.messageId);
    if (!HeaderCommitment.verifyCommitment(commitKey, parsedHeader.partialHeaderBytes, parsedHeader.commitment)) {
      throw new RuntimeException("Header commitment verification failed");
    }

    // 6. Verify footer (recipient tag)
    byte[] fieldRootKey = FieldEncryptor.deriveFieldRootKey(plaintextDataKey, parsedHeader.messageId);

    // Build signed fields for canonical hash (before decryption, using encrypted values)
    List<CanonicalCryptoItem> canonItems = new ArrayList<>();
    for (CryptoItem ci : resolvedActions) {
      byte[] cp = CanonicalPath.canonPath(tableName, ci.key());
      canonItems.add(new CanonicalCryptoItem(cp, ci.key(), ci.data(), ci.action()));
    }
    canonItems.sort((a, b) -> {
      int len = Math.min(a.canonicalPath.length, b.canonicalPath.length);
      for (int i = 0; i < len; i++) {
        int cmp = (a.canonicalPath[i] & 0xFF) - (b.canonicalPath[i] & 0xFF);
        if (cmp != 0) return cmp;
      }
      return a.canonicalPath.length - b.canonicalPath.length;
    });

    List<SignedField> signedFields = new ArrayList<>();
    for (CanonicalCryptoItem ci : canonItems) {
      boolean encrypted = CryptoAction.ENCRYPT_AND_SIGN.equals(ci.action);
      byte[] typeId;
      if (encrypted) {
        // For encrypted fields, the original typeId is stored as first 2 bytes of the value
        byte[] encValue = toByteArray(ci.data.value());
        typeId = Arrays.copyOf(encValue, 2);
      } else {
        typeId = toByteArray(ci.data.typeId());
      }
      byte[] value = toByteArray(ci.data.value());
      signedFields.add(new SignedField(ci.canonicalPath, typeId, value, encrypted));
    }

    byte[] canonicalHash = FooterSerializer.computeCanonicalHash(headerBytes, fullEC, signedFields);

    // Verify at least one recipient tag
    byte[] symmetricSigningKey = toByteArray(materials.symmetricSigningKey());
    if (!FooterVerifier.verifyRecipientTag(canonicalHash, symmetricSigningKey, footerBytes, parsedHeader.encryptedDataKeys.size())) {
      throw new RuntimeException("Footer recipient tag verification failed");
    }

    // Verify ECDSA signature if present (flavor 0x01)
    if (parsedHeader.flavor == FLAVOR_WITH_SIGNATURE) {
      if (materials.verificationKey() != null) {
        ECPublicKey ecPubKey = extractEcPublicKey(toByteArray(materials.verificationKey()));
        if (!FooterVerifier.verifySignature(canonicalHash, ecPubKey, footerBytes, parsedHeader.encryptedDataKeys.size())) {
          throw new RuntimeException("ECDSA signature verification failed");
        }
      }
    }

    // 7. Decrypt fields
    List<CryptoItem> decryptedItems = new ArrayList<>();
    int encryptOffset = 0;

    // We need to decrypt in canonical path order for correct key derivation
    List<CryptoItem> encryptedFieldsSorted = new ArrayList<>();
    for (CanonicalCryptoItem ci : canonItems) {
      if (CryptoAction.ENCRYPT_AND_SIGN.equals(ci.action)) {
        encryptedFieldsSorted.add(CryptoItem.builder().key(ci.originalPath).data(ci.data).action(ci.action).build());
      }
    }

    // Build output: decrypt ENCRYPT_AND_SIGN fields, pass through others
    for (CryptoItem ci : resolvedActions) {
      if (CryptoAction.ENCRYPT_AND_SIGN.equals(ci.action())) {
        // Find this field's position in the sorted encrypted fields list
        int offset = -1;
        for (int i = 0; i < encryptedFieldsSorted.size(); i++) {
          if (encryptedFieldsSorted.get(i).key().equals(ci.key())) {
            offset = i;
            break;
          }
        }
        byte[] fieldKey = FieldEncryptor.deriveFieldKey(fieldRootKey, offset);
        byte[] cipherKey = FieldEncryptor.getCipherKey(fieldKey);
        byte[] nonce = FieldEncryptor.getNonce(fieldKey);
        byte[] aad = CanonicalPath.canonPath(tableName, ci.key());

        byte[] encValue = toByteArray(ci.data().value());
        // encValue = originalTypeId (2 bytes) + ciphertext
        byte[] originalTypeId = Arrays.copyOf(encValue, 2);
        byte[] ciphertext = Arrays.copyOfRange(encValue, 2, encValue.length);

        byte[] plaintext = FieldEncryptor.decrypt(cipherKey, nonce, ciphertext, aad);

        decryptedItems.add(CryptoItem.builder()
          .key(ci.key())
          .data(StructuredDataTerminal.builder()
            .typeId(ByteBuffer.wrap(originalTypeId))
            .value(ByteBuffer.wrap(plaintext))
            .build())
          .action(ci.action())
          .build());
      } else {
        decryptedItems.add(ci);
      }
    }

    ParsedHeader outputHeader = ParsedHeader.builder()
      .algorithmSuiteId(materials.algorithmSuite().id().DBE())
      .encryptedDataKeys(parsedHeader.encryptedDataKeys)
      .storedEncryptionContext(parsedHeader.encryptionContext)
      .encryptionContext(fullEC)
      .build();

    return DecryptPathStructureOutput.builder()
      .plaintextStructure(decryptedItems)
      .parsedHeader(outputHeader)
      .build();
  }

  private static byte[] toByteArray(ByteBuffer buf) {
    if (buf == null) return new byte[0];
    buf = buf.asReadOnlyBuffer();
    byte[] arr = new byte[buf.remaining()];
    buf.get(arr);
    return arr;
  }

  /**
   * Extract an EC private key from MPL's signing key format.
   * MPL stores the private key as BigInteger.toByteArray() of the 'd' parameter (P-384).
   */
  private static ECPrivateKey extractEcPrivateKey(byte[] keyBytes) {
    try {
      java.math.BigInteger s = new java.math.BigInteger(keyBytes);
      java.security.spec.ECParameterSpec ecSpec = java.security.AlgorithmParameters
        .getInstance("EC").getParameterSpec(java.security.spec.ECParameterSpec.class);
    } catch (Exception ignored) {}
    try {
      java.security.AlgorithmParameters params = java.security.AlgorithmParameters.getInstance("EC");
      params.init(new java.security.spec.ECGenParameterSpec("secp384r1"));
      java.security.spec.ECParameterSpec ecSpec = params.getParameterSpec(java.security.spec.ECParameterSpec.class);
      java.math.BigInteger s = new java.math.BigInteger(keyBytes);
      java.security.spec.ECPrivateKeySpec privSpec = new java.security.spec.ECPrivateKeySpec(s, ecSpec);
      java.security.KeyFactory kf = java.security.KeyFactory.getInstance("EC");
      return (ECPrivateKey) kf.generatePrivate(privSpec);
    } catch (Exception e) {
      throw new RuntimeException("Failed to extract EC private key from signing key material", e);
    }
  }

  /**
   * Extract an EC public key from MPL's verification key format.
   * MPL stores the public key as a compressed EC point (1 byte prefix + x-coordinate) for P-384.
   */
  private static ECPublicKey extractEcPublicKey(byte[] keyBytes) {
    try {
      java.security.AlgorithmParameters params = java.security.AlgorithmParameters.getInstance("EC");
      params.init(new java.security.spec.ECGenParameterSpec("secp384r1"));
      java.security.spec.ECParameterSpec ecSpec = params.getParameterSpec(java.security.spec.ECParameterSpec.class);
      java.security.spec.ECPoint point = decodeCompressedPoint(keyBytes, ecSpec);
      java.security.spec.ECPublicKeySpec pubSpec = new java.security.spec.ECPublicKeySpec(point, ecSpec);
      java.security.KeyFactory kf = java.security.KeyFactory.getInstance("EC");
      return (ECPublicKey) kf.generatePublic(pubSpec);
    } catch (Exception e) {
      throw new RuntimeException("Failed to extract EC public key from verification key material", e);
    }
  }

  /**
   * Decode a compressed EC point (SEC 1 format: 02/03 prefix + x-coordinate).
   */
  private static java.security.spec.ECPoint decodeCompressedPoint(byte[] encoded, java.security.spec.ECParameterSpec ecSpec) {
    if (encoded.length == 0) throw new IllegalArgumentException("Empty encoded point");
    byte prefix = encoded[0];
    if (prefix != 0x02 && prefix != 0x03) {
      throw new IllegalArgumentException("Invalid compressed point prefix: " + prefix);
    }
    java.math.BigInteger x = new java.math.BigInteger(1, Arrays.copyOfRange(encoded, 1, encoded.length));
    java.math.BigInteger p = ((java.security.spec.ECFieldFp) ecSpec.getCurve().getField()).getP();
    java.math.BigInteger a = ecSpec.getCurve().getA();
    java.math.BigInteger b = ecSpec.getCurve().getB();
    // y^2 = x^3 + ax + b mod p
    java.math.BigInteger rhs = x.modPow(java.math.BigInteger.valueOf(3), p)
      .add(a.multiply(x)).add(b).mod(p);
    java.math.BigInteger y = modSqrt(rhs, p);
    // Choose correct y based on prefix parity
    if (y.testBit(0) != (prefix == 0x03)) {
      y = p.subtract(y);
    }
    return new java.security.spec.ECPoint(x, y);
  }

  /** Tonelli-Shanks modular square root for prime p ≡ 3 mod 4 (which P-384 satisfies). */
  private static java.math.BigInteger modSqrt(java.math.BigInteger a, java.math.BigInteger p) {
    // For p ≡ 3 mod 4: sqrt(a) = a^((p+1)/4) mod p
    return a.modPow(p.add(java.math.BigInteger.ONE).shiftRight(2), p);
  }
}
