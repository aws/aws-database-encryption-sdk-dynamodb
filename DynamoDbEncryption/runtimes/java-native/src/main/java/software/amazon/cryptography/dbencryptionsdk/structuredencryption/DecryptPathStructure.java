// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction;
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
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsInput;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsOutput;
import software.amazon.cryptography.materialproviders.model.DecryptionMaterials;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;

/**
 * Orchestrates the full DecryptPathStructure operation:
 * parse header → verify commitment → get materials → decrypt fields → verify footer.
 */
public final class DecryptPathStructure {

    private static final String HEADER_FIELD = "aws_dbe_head";
    private static final String FOOTER_FIELD = "aws_dbe_foot";
    private static final byte[] BYTES_TYPE_ID = new byte[]{(byte) 0xFF, (byte) 0xFF};

    private DecryptPathStructure() {}

    /** Result of a DecryptPathStructure operation. */
    public static final class Result {
        private final List<CryptoItem> plaintextStructure;
        private final ParsedHeader parsedHeader;

        public Result(List<CryptoItem> plaintextStructure, ParsedHeader parsedHeader) {
            this.plaintextStructure = plaintextStructure;
            this.parsedHeader = parsedHeader;
        }

        public List<CryptoItem> getPlaintextStructure() { return plaintextStructure; }
        public ParsedHeader getParsedHeader() { return parsedHeader; }
    }

    /**
     * Decrypt a structured data record.
     *
     * @param tableName           logical table name
     * @param encryptedStructure  list of AuthItems (path + data + authenticate action) including header/footer
     * @param cmm                 Cryptographic Materials Manager
     * @param encryptionContext   additional encryption context (may be null)
     * @return decrypted structure with header and footer removed
     */
    public static Result decrypt(
            String tableName,
            List<CryptoItem> encryptedStructure,
            ICryptographicMaterialsManager cmm,
            Map<String, String> encryptionContext) {

        // Step 1: Extract header and footer from the structure
        CryptoItem headerItem = null;
        CryptoItem footerItem = null;
        List<CryptoItem> dataFields = new ArrayList<>();

        for (CryptoItem item : encryptedStructure) {
            String key = item.getKey().get(0).getKey();
            if (key.equals(HEADER_FIELD)) {
                headerItem = item;
            } else if (key.equals(FOOTER_FIELD)) {
                footerItem = item;
            } else {
                dataFields.add(item);
            }
        }

        if (headerItem == null) {
            throw new DbeException("Missing header field (aws_dbe_head)");
        }
        if (footerItem == null) {
            throw new DbeException("Missing footer field (aws_dbe_foot)");
        }

        byte[] fullHeaderBytes = headerItem.getData().getValue();
        byte[] footerBytes = footerItem.getData().getValue();

        // Step 2: Parse header
        Header.PartialHeader header = Header.deserialize(fullHeaderBytes);

        // Step 3: Resolve legend to crypto actions
        List<CryptoItem> resolvedFields = resolveActions(dataFields, header.getLegend(), tableName);

        // Step 4: Canonicalize
        List<Canonize.CanonField> canonFields = Canonize.canonicalize(tableName, resolvedFields);

        // Step 5: Get decryption materials from CMM
        DBEAlgorithmSuiteId suiteId = header.getFlavor() == 0x01
            ? DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384
            : DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;

        Map<String, String> ec = encryptionContext != null
            ? new LinkedHashMap<>(encryptionContext) : new LinkedHashMap<String, String>();

        // Add stored encryption context from header
        for (Map.Entry<byte[], byte[]> entry : header.getEncContext().entrySet()) {
            ec.put(new String(entry.getKey(), StandardCharsets.UTF_8),
                   new String(entry.getValue(), StandardCharsets.UTF_8));
        }

        List<EncryptedDataKey> edks = convertEdks(header.getDataKeys());

        DecryptMaterialsInput decInput = DecryptMaterialsInput.builder()
            .algorithmSuiteId(AlgorithmSuiteId.builder().DBE(suiteId).build())
            .encryptionContext(ec)
            .encryptedDataKeys(edks)
            .commitmentPolicy(CommitmentPolicy.builder()
                .DBE(DBECommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT).build())
            .build();

        DecryptMaterialsOutput decOutput = cmm.DecryptMaterials(decInput);
        DecryptionMaterials materials = decOutput.decryptionMaterials();

        byte[] plaintextDataKey = toBytes(materials.plaintextDataKey());

        // Step 6: Verify header commitment
        byte[] commitKey = Crypt.deriveCommitKey(plaintextDataKey, header.getMsgID());
        if (!Crypt.verifyHeaderCommitment(commitKey, fullHeaderBytes)) {
            throw new DbeException("Header commitment verification failed");
        }

        // Step 7: Verify footer
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(plaintextDataKey, header.getMsgID());

        // We need to verify footer BEFORE decrypting (per spec)
        Map<byte[], byte[]> fullECBytes = stringMapToByteMap(materials.encryptionContext());
        boolean hasSig = header.getFlavor() == 0x01;
        Footer footer = Footer.deserialize(footerBytes, hasSig);

        byte[] symmetricSigningKey = toBytes(materials.symmetricSigningKey());
        byte[] verificationKey = materials.verificationKey() != null
            ? toBytes(materials.verificationKey()) : null;

        footer.verify(canonFields, fullHeaderBytes, fullECBytes, symmetricSigningKey, verificationKey);

        // Step 8: Decrypt fields
        List<Canonize.CanonField> decryptedFields = decryptFields(canonFields, fieldRootKey);

        // Step 9: Assemble output (without header/footer)
        List<CryptoItem> output = new ArrayList<>();
        for (Canonize.CanonField f : decryptedFields) {
            output.add(new CryptoItem(f.getOriginalPath(), f.getData(), f.getAction()));
        }

        ParsedHeader parsedHeader = new ParsedHeader(
            suiteId.toString(),
            toStringMap(header.getEncContext()),
            materials.encryptionContext());

        return new Result(output, parsedHeader);
    }

    // ---- Internal helpers ----

    /**
     * Resolve legend bytes to CryptoActions for the data fields.
     * Fields are sorted by canonical path, and legend bytes map 1:1 to authenticated fields.
     */
    private static List<CryptoItem> resolveActions(
            List<CryptoItem> dataFields, byte[] legend, String tableName) {
        // Sort fields by canonical path to match legend order
        List<Canonize.CanonField> sorted = new ArrayList<>();
        for (CryptoItem item : dataFields) {
            byte[] cp = Canonize.canonPath(tableName, item.getKey());
            sorted.add(new Canonize.CanonField(cp, item.getKey(), item.getData(), item.getAction()));
        }
        Collections.sort(sorted, Canonize.CANON_COMPARATOR);

        // Map legend bytes to actions
        int legendIdx = 0;
        List<CryptoItem> resolved = new ArrayList<>(sorted.size());
        for (Canonize.CanonField field : sorted) {
            CryptoAction action;
            if (field.getAction() == CryptoAction.DO_NOTHING) {
                action = CryptoAction.DO_NOTHING;
            } else {
                if (legendIdx >= legend.length) {
                    throw new DbeException("Legend too short for authenticated fields");
                }
                action = legendByteToAction(legend[legendIdx++]);
            }
            resolved.add(new CryptoItem(field.getOriginalPath(), field.getData(), action));
        }
        if (legendIdx != legend.length) {
            throw new DbeException("Legend length mismatch: used " + legendIdx + " of " + legend.length);
        }
        return resolved;
    }

    private static CryptoAction legendByteToAction(byte b) {
        switch (b) {
            case Header.LEGEND_ENCRYPT_AND_SIGN: return CryptoAction.ENCRYPT_AND_SIGN;
            case Header.LEGEND_SIGN_ONLY: return CryptoAction.SIGN_ONLY;
            case Header.LEGEND_SIGN_AND_INCLUDE_IN_EC: return CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT;
            default: throw new DbeException("Invalid legend byte: " + (b & 0xFF));
        }
    }

    private static List<Canonize.CanonField> decryptFields(
            List<Canonize.CanonField> canonFields, byte[] fieldRootKey) {
        List<Canonize.CanonField> result = new ArrayList<>(canonFields.size());
        int decryptOffset = 0;

        for (Canonize.CanonField field : canonFields) {
            if (field.getAction() == CryptoAction.ENCRYPT_AND_SIGN) {
                byte[][] decrypted = Crypt.decryptField(
                    fieldRootKey, decryptOffset,
                    field.getCanonicalPath(),
                    field.getData().getValue());
                result.add(field.withData(
                    new StructuredDataTerminal(decrypted[1], decrypted[0])));
                decryptOffset++;
            } else {
                result.add(field);
            }
        }
        return result;
    }

    private static List<EncryptedDataKey> convertEdks(List<Header.EncryptedDataKey> headerEdks) {
        List<EncryptedDataKey> result = new ArrayList<>(headerEdks.size());
        for (Header.EncryptedDataKey edk : headerEdks) {
            result.add(EncryptedDataKey.builder()
                .keyProviderId(new String(edk.getKeyProviderId(), StandardCharsets.UTF_8))
                .keyProviderInfo(ByteBuffer.wrap(edk.getKeyProviderInfo()))
                .ciphertext(ByteBuffer.wrap(edk.getCiphertext()))
                .build());
        }
        return result;
    }

    private static Map<byte[], byte[]> stringMapToByteMap(Map<String, String> map) {
        if (map == null) return new LinkedHashMap<>();
        Map<byte[], byte[]> result = new LinkedHashMap<>();
        for (Map.Entry<String, String> e : map.entrySet()) {
            result.put(e.getKey().getBytes(StandardCharsets.UTF_8),
                       e.getValue().getBytes(StandardCharsets.UTF_8));
        }
        return result;
    }

    private static Map<String, String> toStringMap(Map<byte[], byte[]> map) {
        Map<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<byte[], byte[]> e : map.entrySet()) {
            result.put(new String(e.getKey(), StandardCharsets.UTF_8),
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
}
