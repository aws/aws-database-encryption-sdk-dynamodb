// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

/**
 * Footer computation for structured encryption: canonical hash, HMAC recipient tags,
 * and optional ECDSA signature.
 *
 * <p>Footer format: [recipientTags (48B each)][optional signature (103B)]
 */
public final class Footer {

    public static final int RECIPIENT_TAG_SIZE = 48;
    public static final int SIGNATURE_SIZE = 103;

    private static final byte[] ENCRYPTED_LABEL =
        "ENCRYPTED".getBytes(StandardCharsets.UTF_8);
    private static final byte[] PLAINTEXT_LABEL =
        "PLAINTEXT".getBytes(StandardCharsets.UTF_8);

    private final List<byte[]> tags;
    private final byte[] signature; // null if no ECDSA

    public Footer(List<byte[]> tags, byte[] signature) {
        this.tags = tags;
        this.signature = signature;
    }

    public List<byte[]> getTags() { return tags; }
    public byte[] getSignature() { return signature; }

    /** Serialize the footer to bytes. */
    public byte[] serialize() {
        int size = tags.size() * RECIPIENT_TAG_SIZE;
        if (signature != null) size += signature.length;

        byte[] result = new byte[size];
        int pos = 0;
        for (byte[] tag : tags) {
            System.arraycopy(tag, 0, result, pos, RECIPIENT_TAG_SIZE);
            pos += RECIPIENT_TAG_SIZE;
        }
        if (signature != null) {
            System.arraycopy(signature, 0, result, pos, signature.length);
        }
        return result;
    }

    /** Create a StructuredDataTerminal for the footer (typeId = 0xFFFF). */
    public StructuredDataTerminal makeTerminal() {
        return new StructuredDataTerminal(serialize(), new byte[]{(byte) 0xFF, (byte) 0xFF});
    }

    // ---- Footer Creation ----

    /**
     * Create a footer from encrypted data.
     *
     * @param canonFields     canonicalized fields (after encryption, in canonical order)
     * @param fullHeaderBytes full serialized header (with commitment)
     * @param encryptionContext full encryption context from materials
     * @param symmetricSigningKeys one per EDK, for HMAC recipient tags
     * @param signingKey ECDSA signing key (null if flavor=0x00)
     * @return the computed Footer
     */
    public static Footer createFooter(
            List<Canonize.CanonField> canonFields,
            byte[] fullHeaderBytes,
            Map<byte[], byte[]> encryptionContext,
            List<byte[]> symmetricSigningKeys,
            byte[] signingKey) {

        byte[] canonicalHash = computeCanonicalHash(canonFields, fullHeaderBytes, encryptionContext);

        // Compute one HMAC-SHA384 recipient tag per symmetric signing key
        List<byte[]> tags = new ArrayList<>(symmetricSigningKeys.size());
        for (byte[] key : symmetricSigningKeys) {
            byte[] hmac = Crypt.hmacSha384(key, canonicalHash);
            if (hmac.length != RECIPIENT_TAG_SIZE) {
                throw new DbeException("HMAC produced wrong length: " + hmac.length);
            }
            tags.add(hmac);
        }

        // Optional ECDSA signature
        byte[] sig = null;
        if (signingKey != null) {
            sig = ecdsaSign(signingKey, canonicalHash);
        }

        return new Footer(tags, sig);
    }

    // ---- Footer Verification ----

    /**
     * Verify the footer against decryption materials.
     *
     * @return true if verification passes
     * @throws DbeException if verification fails
     */
    public boolean verify(
            List<Canonize.CanonField> canonFields,
            byte[] fullHeaderBytes,
            Map<byte[], byte[]> encryptionContext,
            byte[] symmetricSigningKey,
            byte[] verificationKey) {

        byte[] canonicalHash = computeCanonicalHash(canonFields, fullHeaderBytes, encryptionContext);

        // Verify at least one recipient tag matches
        byte[] calcTag = Crypt.hmacSha384(symmetricSigningKey, canonicalHash);
        boolean found = false;
        for (byte[] tag : tags) {
            if (Crypt.constantTimeEquals(calcTag, tag)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new DbeException("Signature of record does not match");
        }

        // Verify ECDSA signature if present
        if (signature != null) {
            if (verificationKey == null) {
                throw new DbeException("Signature present but no verification key");
            }
            if (!ecdsaVerify(verificationKey, canonicalHash, signature)) {
                throw new DbeException("ECDSA signature did not verify");
            }
        }

        return true;
    }

    // ---- Canonical Hash ----

    /**
     * Compute the SHA-384 canonical hash of the record.
     *
     * <p>Canonical record = header + uint64(AAD_len) + AAD + field_data
     * where AAD = serialized encryption context, and field_data = canonical form of each signed field.
     */
    public static byte[] computeCanonicalHash(
            List<Canonize.CanonField> canonFields,
            byte[] fullHeaderBytes,
            Map<byte[], byte[]> encryptionContext) {

        byte[] aad = Header.serializeContext(encryptionContext);
        byte[] canonContent = buildCanonContent(canonFields);

        // canonical record = header + uint64(aad.length) + aad + canonContent
        ByteBuffer record = ByteBuffer.allocate(
            fullHeaderBytes.length + 8 + aad.length + canonContent.length);
        record.put(fullHeaderBytes);
        record.putLong((long) aad.length);
        record.put(aad);
        record.put(canonContent);

        return sha384(record.array());
    }

    // ---- Canonical Content ----

    /**
     * Build the canonical content for all signed fields (excluding DO_NOTHING).
     */
    static byte[] buildCanonContent(List<Canonize.CanonField> fields) {
        int totalSize = 0;
        List<byte[]> parts = new ArrayList<>();

        for (Canonize.CanonField field : fields) {
            if (field.getAction() == CryptoAction.DO_NOTHING) continue;

            byte[] part;
            if (field.getAction() == CryptoAction.ENCRYPT_AND_SIGN) {
                part = canonicalEncryptedField(field.getCanonicalPath(), field.getData());
            } else {
                part = canonicalPlaintextField(field.getCanonicalPath(), field.getData());
            }
            parts.add(part);
            totalSize += part.length;
        }

        byte[] result = new byte[totalSize];
        int pos = 0;
        for (byte[] part : parts) {
            System.arraycopy(part, 0, result, pos, part.length);
            pos += part.length;
        }
        return result;
    }

    /**
     * Canonical encrypted field:
     * canonicalPath + uint64(encryptedDataLen - 2) + "ENCRYPTED" + value
     * (value starts with 2-byte unencrypted typeId, followed by encrypted data)
     */
    static byte[] canonicalEncryptedField(byte[] canonicalPath, StructuredDataTerminal data) {
        byte[] value = data.getValue();
        if (value.length < 2) {
            throw new DbeException("Encrypted value too short");
        }
        long dataLen = value.length - 2;

        ByteBuffer buf = ByteBuffer.allocate(
            canonicalPath.length + 8 + ENCRYPTED_LABEL.length + value.length);
        buf.put(canonicalPath);
        buf.putLong(dataLen);
        buf.put(ENCRYPTED_LABEL);
        buf.put(value);
        return buf.array();
    }

    /**
     * Canonical plaintext field:
     * canonicalPath + uint64(dataLen) + "PLAINTEXT" + typeId + value
     */
    static byte[] canonicalPlaintextField(byte[] canonicalPath, StructuredDataTerminal data) {
        byte[] value = data.getValue();
        byte[] typeId = data.getTypeId();

        ByteBuffer buf = ByteBuffer.allocate(
            canonicalPath.length + 8 + PLAINTEXT_LABEL.length + typeId.length + value.length);
        buf.put(canonicalPath);
        buf.putLong((long) value.length);
        buf.put(PLAINTEXT_LABEL);
        buf.put(typeId);
        buf.put(value);
        return buf.array();
    }

    // ---- Deserialization ----

    /** Deserialize a footer from bytes, given the number of EDKs from the header. */
    public static Footer deserialize(byte[] data, boolean hasSig) {
        return deserialize(data, hasSig, -1);
    }

    /** Deserialize with known EDK count for unambiguous parsing. */
    public static Footer deserialize(byte[] data, boolean hasSig, int edkCount) {
        if (hasSig) {
            int tagDataLen;
            if (edkCount > 0) {
                tagDataLen = edkCount * RECIPIENT_TAG_SIZE;
            } else {
                // Fallback: assume signature is SIGNATURE_SIZE (103) bytes
                tagDataLen = data.length - SIGNATURE_SIZE;
                // If that doesn't work, try to find the right split
                if (tagDataLen <= 0 || tagDataLen % RECIPIENT_TAG_SIZE != 0) {
                    // Variable-length signature: tags must be a multiple of 48
                    // Try each possible split point
                    tagDataLen = -1;
                    for (int tl = RECIPIENT_TAG_SIZE; tl < data.length - 90; tl += RECIPIENT_TAG_SIZE) {
                        tagDataLen = tl;
                    }
                    if (tagDataLen < 0) throw new DbeException("Footer too short for signature");
                }
            }
            if (tagDataLen < RECIPIENT_TAG_SIZE || tagDataLen % RECIPIENT_TAG_SIZE != 0 || tagDataLen >= data.length) {
                throw new DbeException("Malformed signed footer");
            }
            List<byte[]> tags = gatherTags(data, tagDataLen);
            byte[] sig = Arrays.copyOfRange(data, tagDataLen, data.length);
            return new Footer(tags, sig);
        } else {
            if (data.length < RECIPIENT_TAG_SIZE) {
                throw new DbeException("Footer too short");
            }
            if (data.length % RECIPIENT_TAG_SIZE != 0) {
                throw new DbeException("Malformed unsigned footer");
            }
            return new Footer(gatherTags(data, data.length), null);
        }
    }

    private static List<byte[]> gatherTags(byte[] data, int tagDataLen) {
        int count = tagDataLen / RECIPIENT_TAG_SIZE;
        List<byte[]> tags = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            tags.add(Arrays.copyOfRange(data, i * RECIPIENT_TAG_SIZE, (i + 1) * RECIPIENT_TAG_SIZE));
        }
        return tags;
    }

    // ---- Crypto Primitives ----

    static byte[] sha384(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-384");
            return md.digest(data);
        } catch (Exception e) {
            throw new DbeException("SHA-384 failed: " + e.getMessage());
        }
    }

    static byte[] ecdsaSign(byte[] signingKey, byte[] message) {
        try {
            java.security.KeyFactory kf = java.security.KeyFactory.getInstance("EC");
            java.security.spec.PKCS8EncodedKeySpec spec =
                new java.security.spec.PKCS8EncodedKeySpec(signingKey);
            java.security.PrivateKey privKey = kf.generatePrivate(spec);
            java.security.Signature sig = java.security.Signature.getInstance("SHA384withECDSA");
            sig.initSign(privKey);
            sig.update(message);
            return sig.sign();
        } catch (Exception e) {
            throw new DbeException("ECDSA sign failed: " + e.getMessage());
        }
    }

    static boolean ecdsaVerify(byte[] verificationKey, byte[] message, byte[] signature) {
        try {
            java.security.KeyFactory kf = java.security.KeyFactory.getInstance("EC");
            java.security.spec.X509EncodedKeySpec spec =
                new java.security.spec.X509EncodedKeySpec(verificationKey);
            java.security.PublicKey pubKey = kf.generatePublic(spec);
            java.security.Signature sig = java.security.Signature.getInstance("SHA384withECDSA");
            sig.initVerify(pubKey);
            sig.update(message);
            return sig.verify(signature);
        } catch (Exception e) {
            throw new DbeException("ECDSA verify failed: " + e.getMessage());
        }
    }
}
