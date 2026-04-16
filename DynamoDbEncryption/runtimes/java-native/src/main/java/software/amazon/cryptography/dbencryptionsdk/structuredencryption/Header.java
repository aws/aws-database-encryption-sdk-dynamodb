// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

/**
 * Serializes and deserializes the structured encryption header stored
 * in the {@code aws_dbe_head} attribute.
 *
 * <p>Wire format (Partial Header):
 * <pre>
 * [1B version][1B flavor][32B messageID][legend][encryptionContext][encryptedDataKeys]
 * </pre>
 * Full header = partial header + 32-byte HMAC commitment.
 */
public final class Header {

    // ---- Constants ----

    public static final int VERSION_LEN = 1;
    public static final int FLAVOR_LEN = 1;
    public static final int MSG_ID_LEN = 32;
    public static final int COMMITMENT_LEN = 32;
    public static final int PREFIX_LEN = VERSION_LEN + FLAVOR_LEN + MSG_ID_LEN; // 34

    public static final byte LEGEND_ENCRYPT_AND_SIGN = 0x65;           // 'e'
    public static final byte LEGEND_SIGN_ONLY = 0x73;                  // 's'
    public static final byte LEGEND_SIGN_AND_INCLUDE_IN_EC = 0x63;     // 'c'

    public static final byte DBE_ALGORITHM_FAMILY = 0x67;

    // ---- Encrypted Data Key ----

    public static final class EncryptedDataKey {
        private final byte[] keyProviderId;
        private final byte[] keyProviderInfo;
        private final byte[] ciphertext;

        public EncryptedDataKey(byte[] keyProviderId, byte[] keyProviderInfo, byte[] ciphertext) {
            this.keyProviderId = keyProviderId;
            this.keyProviderInfo = keyProviderInfo;
            this.ciphertext = ciphertext;
        }

        public byte[] getKeyProviderId() { return Arrays.copyOf(keyProviderId, keyProviderId.length); }
        public byte[] getKeyProviderInfo() { return Arrays.copyOf(keyProviderInfo, keyProviderInfo.length); }
        public byte[] getCiphertext() { return Arrays.copyOf(ciphertext, ciphertext.length); }
    }

    // ---- Partial Header ----

    public static final class PartialHeader {
        private final byte version;
        private final byte flavor;
        private final byte[] msgID;
        private final byte[] legend;
        private final Map<byte[], byte[]> encContext;
        private final List<EncryptedDataKey> dataKeys;

        public PartialHeader(byte version, byte flavor, byte[] msgID,
                             byte[] legend, Map<byte[], byte[]> encContext,
                             List<EncryptedDataKey> dataKeys) {
            this.version = version;
            this.flavor = flavor;
            this.msgID = msgID;
            this.legend = legend;
            this.encContext = encContext;
            this.dataKeys = dataKeys;
        }

        public byte getVersion() { return version; }
        public byte getFlavor() { return flavor; }
        public byte[] getMsgID() { return Arrays.copyOf(msgID, msgID.length); }
        public byte[] getLegend() { return Arrays.copyOf(legend, legend.length); }
        public Map<byte[], byte[]> getEncContext() { return encContext; }
        public List<EncryptedDataKey> getDataKeys() { return Collections.unmodifiableList(dataKeys); }

        /** Serialize the partial header (without commitment). */
        public byte[] serialize() {
            byte[] legendBytes = serializeLegend(legend);
            byte[] contextBytes = serializeContext(encContext);
            byte[] keysBytes = serializeDataKeys(dataKeys);

            ByteBuffer buf = ByteBuffer.allocate(
                PREFIX_LEN + legendBytes.length + contextBytes.length + keysBytes.length);
            buf.put(version);
            buf.put(flavor);
            buf.put(msgID);
            buf.put(legendBytes);
            buf.put(contextBytes);
            buf.put(keysBytes);
            return buf.array();
        }
    }

    private Header() {}

    // ---- Legend ----

    /** Map a CryptoAction to its legend byte. Returns -1 for DO_NOTHING (not included). */
    public static byte legendByteForAction(CryptoAction action) {
        switch (action) {
            case ENCRYPT_AND_SIGN: return LEGEND_ENCRYPT_AND_SIGN;
            case SIGN_ONLY: return LEGEND_SIGN_ONLY;
            case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT: return LEGEND_SIGN_AND_INCLUDE_IN_EC;
            default: throw new DbeException("DO_NOTHING has no legend byte");
        }
    }

    /** Build legend bytes from an ordered list of CryptoActions (canonical order). */
    public static byte[] buildLegend(List<CryptoAction> orderedActions) {
        int count = 0;
        for (CryptoAction a : orderedActions) {
            if (a != CryptoAction.DO_NOTHING) count++;
        }
        byte[] legend = new byte[count];
        int idx = 0;
        for (CryptoAction a : orderedActions) {
            if (a != CryptoAction.DO_NOTHING) {
                legend[idx++] = legendByteForAction(a);
            }
        }
        return legend;
    }

    /** Determine version from actions: 2 if any SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT, else 1. */
    public static byte versionForActions(List<CryptoAction> actions) {
        for (CryptoAction a : actions) {
            if (a == CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) return 2;
        }
        return 1;
    }

    public static boolean isValidVersion(byte v) { return v == 1 || v == 2; }
    public static boolean isValidFlavor(byte f) { return f == 0 || f == 1; }
    public static boolean isValidLegendByte(byte b) {
        return b == LEGEND_ENCRYPT_AND_SIGN || b == LEGEND_SIGN_ONLY || b == LEGEND_SIGN_AND_INCLUDE_IN_EC;
    }

    // ---- Serialization ----

    /** Legend → bytes: [2B length][legend bytes] */
    static byte[] serializeLegend(byte[] legend) {
        ByteBuffer buf = ByteBuffer.allocate(2 + legend.length);
        buf.putShort((short) legend.length);
        buf.put(legend);
        return buf.array();
    }

    /** Encryption context → bytes: [2B count][entries sorted by key bytes ascending] */
    static byte[] serializeContext(Map<byte[], byte[]> ctx) {
        List<byte[]> sortedKeys = new ArrayList<>(ctx.keySet());
        Collections.sort(sortedKeys, BYTES_COMPARATOR);

        // Calculate total size
        int size = 2; // count
        for (byte[] key : sortedKeys) {
            byte[] val = ctx.get(key);
            size += 2 + key.length + 2 + val.length;
        }

        ByteBuffer buf = ByteBuffer.allocate(size);
        buf.putShort((short) ctx.size());
        for (byte[] key : sortedKeys) {
            byte[] val = ctx.get(key);
            buf.putShort((short) key.length);
            buf.put(key);
            buf.putShort((short) val.length);
            buf.put(val);
        }
        return buf.array();
    }

    /** Encrypted data keys → bytes: [1B count][entries] */
    static byte[] serializeDataKeys(List<EncryptedDataKey> keys) {
        if (keys.isEmpty()) {
            throw new DbeException("At least one data key required");
        }
        if (keys.size() >= 256) {
            throw new DbeException("Too many data keys");
        }

        int size = 1; // count byte
        for (EncryptedDataKey k : keys) {
            size += 2 + k.keyProviderId.length + 2 + k.keyProviderInfo.length + 2 + k.ciphertext.length;
        }

        ByteBuffer buf = ByteBuffer.allocate(size);
        buf.put((byte) keys.size());
        for (EncryptedDataKey k : keys) {
            buf.putShort((short) k.keyProviderId.length);
            buf.put(k.keyProviderId);
            buf.putShort((short) k.keyProviderInfo.length);
            buf.put(k.keyProviderInfo);
            buf.putShort((short) k.ciphertext.length);
            buf.put(k.ciphertext);
        }
        return buf.array();
    }

    // ---- Deserialization ----

    /** Deserialize a full header (partial header + 32-byte commitment). Returns the PartialHeader. */
    public static PartialHeader deserialize(byte[] data) {
        return partialDeserialize(data);
    }

    /** Deserialize partial header from bytes. Validates trailing 32 bytes exist for commitment. */
    public static PartialHeader partialDeserialize(byte[] data) {
        if (data.length < PREFIX_LEN) {
            throw new DbeException("Serialized header too short");
        }

        int pos = 0;
        byte version = data[pos++];
        if (!isValidVersion(version)) {
            throw new DbeException("Invalid version: " + version);
        }

        byte flavor = data[pos++];
        if (!isValidFlavor(flavor)) {
            throw new DbeException("Invalid flavor: " + flavor);
        }

        byte[] msgID = Arrays.copyOfRange(data, pos, pos + MSG_ID_LEN);
        pos += MSG_ID_LEN;

        // Legend
        if (pos + 2 > data.length) throw new DbeException("Unexpected end of header data");
        int legendLen = readUint16(data, pos);
        pos += 2;
        if (pos + legendLen > data.length) throw new DbeException("Unexpected end of header data");
        byte[] legend = Arrays.copyOfRange(data, pos, pos + legendLen);
        for (byte b : legend) {
            if (!isValidLegendByte(b)) {
                throw new DbeException("Invalid legend byte: " + (b & 0xFF));
            }
        }
        pos += legendLen;

        // Encryption context
        if (pos + 2 > data.length) throw new DbeException("Unexpected end of header data");
        int ctxCount = readUint16(data, pos);
        pos += 2;
        Map<byte[], byte[]> encContext = new LinkedHashMap<>(ctxCount);
        byte[] prevKey = new byte[0];
        for (int i = 0; i < ctxCount; i++) {
            if (pos + 2 > data.length) throw new DbeException("Unexpected end of header data");
            int keyLen = readUint16(data, pos); pos += 2;
            if (pos + keyLen > data.length) throw new DbeException("Unexpected end of header data");
            byte[] key = Arrays.copyOfRange(data, pos, pos + keyLen); pos += keyLen;
            if (i > 0 && BYTES_COMPARATOR.compare(prevKey, key) >= 0) {
                throw new DbeException("Context keys out of order or duplicate");
            }
            prevKey = key;
            if (pos + 2 > data.length) throw new DbeException("Unexpected end of header data");
            int valLen = readUint16(data, pos); pos += 2;
            if (pos + valLen > data.length) throw new DbeException("Unexpected end of header data");
            byte[] val = Arrays.copyOfRange(data, pos, pos + valLen); pos += valLen;
            encContext.put(key, val);
        }

        // Encrypted data keys
        if (pos + 1 > data.length) throw new DbeException("Unexpected end of header data");
        int keyCount = data[pos++] & 0xFF;
        if (keyCount == 0) throw new DbeException("At least one data key required");
        List<EncryptedDataKey> dataKeys = new ArrayList<>(keyCount);
        for (int i = 0; i < keyCount; i++) {
            if (pos + 2 > data.length) throw new DbeException("Unexpected end of header data");
            int provIdLen = readUint16(data, pos); pos += 2;
            if (pos + provIdLen > data.length) throw new DbeException("Unexpected end of header data");
            byte[] provId = Arrays.copyOfRange(data, pos, pos + provIdLen); pos += provIdLen;

            if (pos + 2 > data.length) throw new DbeException("Unexpected end of header data");
            int provInfoLen = readUint16(data, pos); pos += 2;
            if (pos + provInfoLen > data.length) throw new DbeException("Unexpected end of header data");
            byte[] provInfo = Arrays.copyOfRange(data, pos, pos + provInfoLen); pos += provInfoLen;

            if (pos + 2 > data.length) throw new DbeException("Unexpected end of header data");
            int cipherLen = readUint16(data, pos); pos += 2;
            if (pos + cipherLen > data.length) throw new DbeException("Unexpected end of header data");
            byte[] cipher = Arrays.copyOfRange(data, pos, pos + cipherLen); pos += cipherLen;

            dataKeys.add(new EncryptedDataKey(provId, provInfo, cipher));
        }

        // Remaining bytes must be exactly the 32-byte commitment
        int remaining = data.length - pos;
        if (remaining < COMMITMENT_LEN) {
            throw new DbeException("Serialized header too short for commitment");
        }
        if (remaining > COMMITMENT_LEN) {
            throw new DbeException("Unexpected trailing bytes in header");
        }

        return new PartialHeader(version, flavor, msgID, legend, encContext, dataKeys);
    }

    /** Extract the 32-byte commitment from the end of a full header. */
    public static byte[] getCommitment(byte[] fullHeader) {
        if (fullHeader.length < COMMITMENT_LEN) {
            throw new DbeException("Header too short for commitment");
        }
        return Arrays.copyOfRange(fullHeader, fullHeader.length - COMMITMENT_LEN, fullHeader.length);
    }

    /** Get the partial header bytes (everything before the commitment). */
    public static byte[] getPartialHeaderBytes(byte[] fullHeader) {
        if (fullHeader.length < COMMITMENT_LEN) {
            throw new DbeException("Header too short for commitment");
        }
        return Arrays.copyOfRange(fullHeader, 0, fullHeader.length - COMMITMENT_LEN);
    }

    // ---- Helpers ----

    private static int readUint16(byte[] data, int pos) {
        return ((data[pos] & 0xFF) << 8) | (data[pos + 1] & 0xFF);
    }

    /** Lexicographic unsigned byte comparator, matching Dafny's ByteLess ordering. */
    static final Comparator<byte[]> BYTES_COMPARATOR = new Comparator<byte[]>() {
        @Override
        public int compare(byte[] a, byte[] b) {
            int len = Math.min(a.length, b.length);
            for (int i = 0; i < len; i++) {
                int cmp = (a[i] & 0xFF) - (b[i] & 0xFF);
                if (cmp != 0) return cmp;
            }
            return a.length - b.length;
        }
    };
}
