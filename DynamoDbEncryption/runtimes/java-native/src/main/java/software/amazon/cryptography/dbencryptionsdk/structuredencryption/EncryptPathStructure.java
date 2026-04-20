// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.ParsedHeader;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.CommitmentPolicy;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.DBECommitmentPolicy;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.model.EncryptionMaterials;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsInput;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsOutput;

/**
 * Orchestrates the full EncryptPathStructure operation:
 * get materials → generate header → encrypt fields → compute footer → assemble output.
 */
public final class EncryptPathStructure {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final String HEADER_FIELD = "aws_dbe_head";
    private static final String FOOTER_FIELD = "aws_dbe_foot";
    private static final byte[] BYTES_TYPE_ID = new byte[]{(byte) 0xFF, (byte) 0xFF};

    private EncryptPathStructure() {}

    /** Result of an EncryptPathStructure operation. */
    public static final class Result {
        private final List<CryptoItem> encryptedStructure;
        private final ParsedHeader parsedHeader;

        public Result(List<CryptoItem> encryptedStructure, ParsedHeader parsedHeader) {
            this.encryptedStructure = encryptedStructure;
            this.parsedHeader = parsedHeader;
        }

        public List<CryptoItem> getEncryptedStructure() { return encryptedStructure; }
        public ParsedHeader getParsedHeader() { return parsedHeader; }
    }

    /**
     * Encrypt a structured data record.
     *
     * @param tableName          logical table name
     * @param plaintextStructure list of CryptoItems (path + data + action)
     * @param cmm                Cryptographic Materials Manager
     * @param algorithmSuiteId   optional algorithm suite override (null for default)
     * @param encryptionContext   additional encryption context (may be null)
     * @return encrypted structure with header and footer fields appended
     */
    public static Result encrypt(
            String tableName,
            List<CryptoItem> plaintextStructure,
            ICryptographicMaterialsManager cmm,
            DBEAlgorithmSuiteId algorithmSuiteId,
            Map<String, String> encryptionContext) {

        // Validate input
        validateInput(plaintextStructure);

        // Step 1: Canonicalize — compute canonical paths and sort
        List<Canonize.CanonField> canonFields = Canonize.canonicalize(tableName, plaintextStructure);

        // Step 2: Determine version and build legend
        List<CryptoAction> orderedActions = new ArrayList<>(canonFields.size());
        for (Canonize.CanonField f : canonFields) {
            orderedActions.add(f.getAction());
        }
        byte version = Header.versionForActions(orderedActions);
        byte[] legend = Header.buildLegend(orderedActions);

        // Step 3: Get encryption materials from CMM
        Map<String, String> ec = encryptionContext != null
            ? new LinkedHashMap<>(encryptionContext) : new LinkedHashMap<String, String>();

        // Step 2.5: V2 encryption context augmentation
        if (version == 2) {
            augmentEncryptionContextV2(canonFields, ec);
        }

        GetEncryptionMaterialsInput.Builder matInputBuilder = GetEncryptionMaterialsInput.builder()
            .encryptionContext(ec)
            .commitmentPolicy(CommitmentPolicy.builder()
                .DBE(DBECommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT).build());

        if (algorithmSuiteId != null) {
            matInputBuilder.algorithmSuiteId(
                AlgorithmSuiteId.builder().DBE(algorithmSuiteId).build());
        }

        GetEncryptionMaterialsOutput matOutput = cmm.GetEncryptionMaterials(matInputBuilder.build());
        EncryptionMaterials materials = matOutput.encryptionMaterials();

        // Extract key material
        byte[] plaintextDataKey = toBytes(materials.plaintextDataKey());
        if (plaintextDataKey == null || plaintextDataKey.length == 0) {
            throw new DbeException("Encryption materials missing plaintext data key");
        }

        // Step 4: Generate 256-bit random Message ID
        byte[] msgID = new byte[Header.MSG_ID_LEN];
        SECURE_RANDOM.nextBytes(msgID);

        // Step 5: Build encryption context for header (stored EC = full EC minus required keys)
        Map<String, String> fullEC = materials.encryptionContext();
        List<String> requiredKeys = materials.requiredEncryptionContextKeys();
        Map<byte[], byte[]> storedEC = buildStoredEncryptionContext(fullEC, requiredKeys);

        // Step 6: Build encrypted data keys for header
        List<Header.EncryptedDataKey> headerEdks = convertEdks(materials.encryptedDataKeys());

        // Step 7: Determine flavor from algorithm suite
        byte flavor = flavorFromMaterials(materials);

        // Step 8: Create partial header and serialize
        Header.PartialHeader partialHeader = new Header.PartialHeader(
            version, flavor, msgID, legend, storedEC, headerEdks);
        byte[] partialHeaderBytes = partialHeader.serialize();

        // Step 9: Derive commit key and compute header commitment
        byte[] commitKey = Crypt.deriveCommitKey(plaintextDataKey, msgID);
        byte[] commitment = Crypt.computeHeaderCommitment(commitKey, partialHeaderBytes);
        byte[] fullHeaderBytes = Crypt.concat(partialHeaderBytes, commitment);

        // Step 10: Derive field root key and encrypt fields
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(plaintextDataKey, msgID);
        List<Canonize.CanonField> encryptedFields = encryptFields(canonFields, fieldRootKey);

        // Step 11: Compute footer
        List<byte[]> symmetricSigningKeys = toBytesList(materials.symmetricSigningKeys());
        byte[] signingKey = materials.signingKey() != null ? toBytes(materials.signingKey()) : null;

        Map<byte[], byte[]> fullECBytes = stringMapToByteMap(fullEC);
        Footer footer = Footer.createFooter(
            encryptedFields, fullHeaderBytes, fullECBytes, symmetricSigningKeys, signingKey);

        // Step 12: Assemble output — encrypted fields + header + footer
        List<CryptoItem> output = new ArrayList<>();
        for (Canonize.CanonField f : encryptedFields) {
            output.add(new CryptoItem(f.getOriginalPath(), f.getData(), f.getAction()));
        }

        // Add header field
        output.add(new CryptoItem(
            Collections.singletonList(new PathSegment(HEADER_FIELD)),
            new StructuredDataTerminal(fullHeaderBytes, BYTES_TYPE_ID),
            CryptoAction.DO_NOTHING));

        // Add footer field
        output.add(new CryptoItem(
            Collections.singletonList(new PathSegment(FOOTER_FIELD)),
            footer.makeTerminal(),
            CryptoAction.DO_NOTHING));

        // Build parsed header for output
        ParsedHeader parsedHeader = new ParsedHeader(
            flavor == 0x01
                ? "ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384"
                : "ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384",
            toStringMap(storedEC),
            fullEC);

        return new Result(output, parsedHeader);
    }

    // ---- Internal helpers ----

    private static void validateInput(List<CryptoItem> items) {
        boolean hasAuth = false;
        for (CryptoItem item : items) {
            String key = item.getKey().get(0).getKey();
            if (key.equals(HEADER_FIELD) || key.equals(FOOTER_FIELD)) {
                throw new DbeException("Input must not contain reserved field: " + key);
            }
            if (item.getAction() != CryptoAction.DO_NOTHING) {
                hasAuth = true;
            }
        }
        if (!hasAuth) {
            throw new DbeException("At least one field must have an auth action");
        }
    }

    private static List<Canonize.CanonField> encryptFields(
            List<Canonize.CanonField> canonFields, byte[] fieldRootKey) {
        List<Canonize.CanonField> result = new ArrayList<>(canonFields.size());
        int encryptOffset = 0;

        for (Canonize.CanonField field : canonFields) {
            if (field.getAction() == CryptoAction.ENCRYPT_AND_SIGN) {
                byte[] encrypted = Crypt.encryptField(
                    fieldRootKey, encryptOffset,
                    field.getCanonicalPath(),
                    field.getData().getTypeId(),
                    field.getData().getValue());
                result.add(field.withData(
                    new StructuredDataTerminal(encrypted, BYTES_TYPE_ID)));
                encryptOffset++;
            } else {
                result.add(field);
            }
        }
        return result;
    }

    /**
     * V2: Add SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT field values to the encryption context.
     * Keys: "aws-crypto-attr.<path>", values: type-dependent encoding.
     * Also adds "aws-crypto-legend" with one char per attribute (S/N/L/B).
     */
    private static void augmentEncryptionContextV2(
            List<Canonize.CanonField> canonFields, Map<String, String> ec) {
        // Collect SIGN_AND_INCLUDE_IN_EC fields, sorted by their EC key
        java.util.TreeMap<String, Canonize.CanonField> ecFields = new java.util.TreeMap<>();
        for (Canonize.CanonField f : canonFields) {
            if (f.getAction() == CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) {
                String attrName = f.getOriginalPath().get(0).getKey();
                String ecKey = "aws-crypto-attr." + attrName;
                ecFields.put(ecKey, f);
            }
        }

        StringBuilder legend = new StringBuilder();
        for (Map.Entry<String, Canonize.CanonField> entry : ecFields.entrySet()) {
            StructuredDataTerminal data = entry.getValue().getData();
            byte[] typeId = data.getTypeId();
            byte[] value = data.getValue();
            String ecValue;
            char legendChar;

            if (typeId[0] == 0x00 && typeId[1] == 0x00) { // NULL
                ecValue = "null";
                legendChar = 'L';
            } else if (typeId[0] == 0x00 && typeId[1] == 0x01) { // STRING
                ecValue = new String(value, StandardCharsets.UTF_8);
                legendChar = 'S';
            } else if (typeId[0] == 0x00 && typeId[1] == 0x02) { // NUMBER
                ecValue = new String(value, StandardCharsets.UTF_8);
                legendChar = 'N';
            } else if (typeId[0] == 0x00 && typeId[1] == 0x04) { // BOOLEAN
                ecValue = (value.length == 1 && value[0] == 0) ? "false" : "true";
                legendChar = 'L';
            } else { // Binary and complex types: base64(typeId + value)
                byte[] combined = new byte[2 + value.length];
                combined[0] = typeId[0]; combined[1] = typeId[1];
                System.arraycopy(value, 0, combined, 2, value.length);
                ecValue = java.util.Base64.getEncoder().encodeToString(combined);
                legendChar = 'B';
            }

            ec.put(entry.getKey(), ecValue);
            legend.append(legendChar);
        }

        if (legend.length() > 0) {
            ec.put("aws-crypto-legend", legend.toString());
        }
    }

    private static byte flavorFromMaterials(EncryptionMaterials materials) {
        DBEAlgorithmSuiteId suiteId = materials.algorithmSuite().id().DBE();
        if (suiteId == DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384) {
            return 0x01;
        }
        return 0x00;
    }

    private static Map<byte[], byte[]> buildStoredEncryptionContext(
            Map<String, String> fullEC, List<String> requiredKeys) {
        Map<byte[], byte[]> stored = new LinkedHashMap<>();
        if (fullEC == null) return stored;
        for (Map.Entry<String, String> entry : fullEC.entrySet()) {
            if (requiredKeys != null && requiredKeys.contains(entry.getKey())) {
                continue; // Skip required keys — they're not stored in the header
            }
            stored.put(
                entry.getKey().getBytes(StandardCharsets.UTF_8),
                entry.getValue().getBytes(StandardCharsets.UTF_8));
        }
        return stored;
    }

    private static List<Header.EncryptedDataKey> convertEdks(List<EncryptedDataKey> edks) {
        List<Header.EncryptedDataKey> result = new ArrayList<>(edks.size());
        for (EncryptedDataKey edk : edks) {
            result.add(new Header.EncryptedDataKey(
                edk.keyProviderId().getBytes(StandardCharsets.UTF_8),
                toBytes(edk.keyProviderInfo()),
                toBytes(edk.ciphertext())));
        }
        return result;
    }

    private static Map<byte[], byte[]> stringMapToByteMap(Map<String, String> map) {
        if (map == null) return new LinkedHashMap<>();
        Map<byte[], byte[]> result = new LinkedHashMap<>();
        for (Map.Entry<String, String> e : map.entrySet()) {
            result.put(
                e.getKey().getBytes(StandardCharsets.UTF_8),
                e.getValue().getBytes(StandardCharsets.UTF_8));
        }
        return result;
    }

    private static Map<String, String> toStringMap(Map<byte[], byte[]> map) {
        Map<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<byte[], byte[]> e : map.entrySet()) {
            result.put(
                new String(e.getKey(), StandardCharsets.UTF_8),
                new String(e.getValue(), StandardCharsets.UTF_8));
        }
        return result;
    }

    private static byte[] toBytes(ByteBuffer buf) {
        if (buf == null) return null;
        buf = buf.asReadOnlyBuffer();
        byte[] bytes = new byte[buf.remaining()];
        buf.get(bytes);
        return bytes;
    }

    private static List<byte[]> toBytesList(List<ByteBuffer> bufs) {
        if (bufs == null) return Collections.emptyList();
        List<byte[]> result = new ArrayList<>(bufs.size());
        for (ByteBuffer buf : bufs) {
            result.add(toBytes(buf));
        }
        return result;
    }
}
