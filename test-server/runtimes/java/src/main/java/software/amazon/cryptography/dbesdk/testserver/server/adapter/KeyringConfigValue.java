// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.adapter;

import java.nio.ByteBuffer;
import java.util.List;
import software.amazon.awssdk.services.kms.model.EncryptionAlgorithmSpec;
import software.amazon.cryptography.materialproviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialproviders.model.PaddingScheme;
import software.amazon.cryptography.primitives.model.ECDHCurveSpec;

/**
 * Framework-internal, extensible value mirror of the Smithy model's {@code KeyringConfig} shape.
 *
 * <p>This is a sealed hierarchy with exactly one record per supported keyring kind (Phase A). The
 * {@code createClient} handler translates the generated {@code KeyringConfig} into one of these
 * variants (validating that exactly one model member is set, and mapping the model enums onto the
 * Material Providers enum constants carried here) before handing it to the {@link
 * EnhancedClientAdapter}. Keeping the adapter's input as plain value objects decoupled from
 * generated code lets the adapter compile and be reasoned about independently, and lets the adapter
 * build each keyring with a clean exhaustive {@code switch}.
 *
 * <p>The {@link Multi} variant is recursive: it carries an optional generator {@link
 * KeyringConfigValue} and a list of child {@link KeyringConfigValue}s, mirroring {@code
 * CreateMultiKeyringInput}.
 */
public sealed interface KeyringConfigValue
    permits
        KeyringConfigValue.RawAes,
        KeyringConfigValue.RawRsa,
        KeyringConfigValue.AwsKms,
        KeyringConfigValue.AwsKmsMrk,
        KeyringConfigValue.AwsKmsMrkMulti,
        KeyringConfigValue.AwsKmsRsa,
        KeyringConfigValue.AwsKmsEcdh,
        KeyringConfigValue.RawEcdh,
        KeyringConfigValue.Hierarchical,
        KeyringConfigValue.AwsKmsDiscovery,
        KeyringConfigValue.AwsKmsMrkDiscovery,
        KeyringConfigValue.AwsKmsDiscoveryMulti,
        KeyringConfigValue.AwsKmsMrkDiscoveryMulti,
        KeyringConfigValue.Multi {

  /**
   * A Raw AES keyring. Mirrors {@code CreateRawAesKeyringInput}.
   *
   * @param keyNamespace a namespace associated with the wrapping key (required)
   * @param keyName a name associated with the wrapping key (required)
   * @param wrappingKey the raw AES key bytes, 16/24/32 bytes (required)
   * @param wrappingAlg the AES-GCM wrapping algorithm (required)
   */
  record RawAes(
      String keyNamespace, String keyName, ByteBuffer wrappingKey, AesWrappingAlg wrappingAlg)
      implements KeyringConfigValue {}

  /**
   * A Raw RSA keyring. Mirrors {@code CreateRawRsaKeyringInput}. At least one of {@code publicKey} /
   * {@code privateKey} must be present; both are needed for a round-trip.
   *
   * @param keyNamespace a namespace associated with the wrapping key (required)
   * @param keyName a name associated with the wrapping key (required)
   * @param paddingScheme the RSA padding scheme (required)
   * @param publicKey UTF-8 PEM X.509 SPKI bytes, or {@code null} (needed to encrypt)
   * @param privateKey UTF-8 PEM PKCS#8 bytes, or {@code null} (needed to decrypt)
   */
  record RawRsa(
      String keyNamespace,
      String keyName,
      PaddingScheme paddingScheme,
      ByteBuffer publicKey,
      ByteBuffer privateKey)
      implements KeyringConfigValue {}

  /**
   * An AWS KMS keyring for a single-Region symmetric key. Mirrors {@code CreateAwsKmsKeyringInput}.
   * The adapter constructs the required {@code KmsClient}.
   *
   * @param kmsKeyId the AWS KMS key identifier (required)
   * @param grantTokens optional grant tokens, or {@code null}
   */
  record AwsKms(String kmsKeyId, List<String> grantTokens) implements KeyringConfigValue {}

  /**
   * An AWS KMS MRK keyring. Mirrors {@code CreateAwsKmsMrkKeyringInput}. The adapter constructs the
   * required {@code KmsClient}.
   *
   * @param kmsKeyId the AWS KMS key identifier (required)
   * @param grantTokens optional grant tokens, or {@code null}
   */
  record AwsKmsMrk(String kmsKeyId, List<String> grantTokens) implements KeyringConfigValue {}

  /**
   * An AWS KMS MRK multi-keyring. Mirrors {@code CreateAwsKmsMrkMultiKeyringInput}. The MPL builds
   * KMS clients itself, so no client is supplied. This is the keyring kind the original single
   * {@code kmsKeyring} member built.
   *
   * @param generator the generator KMS key id, or {@code null}
   * @param kmsKeyIds additional KMS key ids, or {@code null}
   */
  record AwsKmsMrkMulti(String generator, List<String> kmsKeyIds)
      implements KeyringConfigValue {}

  /**
   * An AWS KMS RSA keyring. Mirrors {@code CreateAwsKmsRsaKeyringInput}. The adapter constructs the
   * required {@code KmsClient}.
   *
   * @param kmsKeyId the asymmetric (RSA) AWS KMS key ARN (required)
   * @param encryptionAlgorithm the RSA wrapping algorithm (required)
   * @param publicKey UTF-8 PEM X.509 SPKI bytes (needed to encrypt), or {@code null}
   */
  record AwsKmsRsa(
      String kmsKeyId, EncryptionAlgorithmSpec encryptionAlgorithm, ByteBuffer publicKey)
      implements KeyringConfigValue {}

  /**
   * An AWS KMS ECDH keyring using the KmsPrivateKeyToStaticPublicKey scheme. Mirrors {@code
   * CreateAwsKmsEcdhKeyringInput}. The adapter constructs the required {@code KmsClient}.
   *
   * @param senderKmsIdentifier the sender's AWS KMS ECC key ARN (required)
   * @param recipientPublicKey raw DER X.509 SPKI bytes of the recipient public key (required)
   * @param curveSpec the named curve both keys lie on (required)
   */
  record AwsKmsEcdh(
      String senderKmsIdentifier, ByteBuffer recipientPublicKey, ECDHCurveSpec curveSpec)
      implements KeyringConfigValue {}

  /**
   * A Raw ECDH keyring using the RawPrivateKeyToStaticPublicKey scheme. Mirrors {@code
   * CreateRawEcdhKeyringInput}. No AWS access required.
   *
   * @param senderStaticPrivateKey UTF-8 PEM PKCS#8 bytes of the sender private key (required)
   * @param recipientPublicKey raw DER X.509 SPKI bytes of the recipient public key (required)
   * @param curveSpec the named curve both keys lie on (required)
   */
  record RawEcdh(
      ByteBuffer senderStaticPrivateKey, ByteBuffer recipientPublicKey, ECDHCurveSpec curveSpec)
      implements KeyringConfigValue {}

  /**
   * An AWS KMS Hierarchical keyring. Mirrors {@code CreateAwsKmsHierarchicalKeyringInput}. The
   * adapter builds the backing {@code KeyStore} (DynamoDB + KMS clients for the region).
   *
   * @param keyStoreTableName the DynamoDB table backing the branch-key store (required)
   * @param logicalKeyStoreName the logical key store name (required)
   * @param kmsKeyArn the symmetric KMS key that wraps branch keys (required)
   * @param branchKeyId the branch key id to use (required)
   * @param ttlSeconds branch-key cache TTL in seconds (required)
   * @param cacheEntryCapacity local cache capacity, or {@code null} for the MPL default
   */
  record Hierarchical(
      String keyStoreTableName,
      String logicalKeyStoreName,
      String kmsKeyArn,
      String branchKeyId,
      long ttlSeconds,
      Integer cacheEntryCapacity)
      implements KeyringConfigValue {}

  /**
   * An AWS KMS Discovery keyring (DECRYPT-ONLY). Mirrors {@code CreateAwsKmsDiscoveryKeyringInput}.
   * The adapter constructs the required {@code KmsClient} and, when {@code accountId} is present, a
   * {@code DiscoveryFilter}.
   *
   * @param accountId an allowed AWS account id for the discovery filter, or {@code null}
   * @param partition the AWS partition for the discovery filter, or {@code null} (default "aws")
   */
  record AwsKmsDiscovery(String accountId, String partition) implements KeyringConfigValue {}

  /**
   * An AWS KMS MRK Discovery keyring (DECRYPT-ONLY, single Region). Mirrors {@code
   * CreateAwsKmsMrkDiscoveryKeyringInput}.
   *
   * @param region the Region this keyring decrypts in (required)
   * @param accountId an allowed AWS account id for the discovery filter, or {@code null}
   * @param partition the AWS partition for the discovery filter, or {@code null} (default "aws")
   */
  record AwsKmsMrkDiscovery(String region, String accountId, String partition)
      implements KeyringConfigValue {}

  /**
   * An AWS KMS Discovery multi-keyring (DECRYPT-ONLY). Mirrors {@code
   * CreateAwsKmsDiscoveryMultiKeyringInput}; the MPL builds KMS clients per Region.
   *
   * @param regions the Regions to build discovery child keyrings for (required)
   * @param accountId an allowed AWS account id for the discovery filter, or {@code null}
   * @param partition the AWS partition for the discovery filter, or {@code null} (default "aws")
   */
  record AwsKmsDiscoveryMulti(List<String> regions, String accountId, String partition)
      implements KeyringConfigValue {}

  /**
   * An AWS KMS MRK Discovery multi-keyring (DECRYPT-ONLY). Mirrors {@code
   * CreateAwsKmsMrkDiscoveryMultiKeyringInput}; the MPL builds KMS clients per Region.
   *
   * @param regions the Regions to build discovery child keyrings for (required)
   * @param accountId an allowed AWS account id for the discovery filter, or {@code null}
   * @param partition the AWS partition for the discovery filter, or {@code null} (default "aws")
   */
  record AwsKmsMrkDiscoveryMulti(List<String> regions, String accountId, String partition)
      implements KeyringConfigValue {}

  /**
   * A multi-keyring. Mirrors {@code CreateMultiKeyringInput}.
   *
   * @param generator the generator keyring configuration, or {@code null}
   * @param childKeyrings the child keyring configurations; non-null (may be empty)
   */
  record Multi(KeyringConfigValue generator, List<KeyringConfigValue> childKeyrings)
      implements KeyringConfigValue {}
}
