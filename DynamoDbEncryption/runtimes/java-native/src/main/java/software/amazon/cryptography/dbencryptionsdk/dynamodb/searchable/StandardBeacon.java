// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.searchable;

import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;

/**
 * Standard Beacon: truncated HMAC-SHA384 of a field value.
 *
 * <p>Computation:
 * 1. HMAC-SHA384(key, UTF8(value)) → take first 8 bytes
 * 2. Truncate to beaconLength bits (rightmost bits)
 * 3. Encode as hex string
 *
 * <p>Stored as attribute {@code aws_dbe_b_<name>}.
 */
public final class StandardBeacon {

    public static final String BEACON_PREFIX = "aws_dbe_b_";

    private final String name;
    private final String fieldName; // source field (terminal location)
    private final int beaconLength; // 1-63 bits

    public StandardBeacon(String name, String fieldName, int beaconLength) {
        if (beaconLength < 1 || beaconLength > 63) {
            throw new DbeException("Beacon length must be between 1 and 63, got: " + beaconLength);
        }
        this.name = name;
        this.fieldName = fieldName;
        this.beaconLength = beaconLength;
    }

    public String getName() { return name; }
    public String getFieldName() { return fieldName; }
    public int getBeaconLength() { return beaconLength; }
    public String getBeaconAttributeName() { return BEACON_PREFIX + name; }

    /**
     * Compute the beacon value for a plaintext field value.
     *
     * @param value the plaintext value (will be UTF-8 encoded)
     * @param hmacKey the HMAC key for this beacon
     * @return hex string of the truncated hash
     */
    public String computeBeacon(String value, byte[] hmacKey) {
        byte[] data = value.getBytes(StandardCharsets.UTF_8);
        return computeBeaconBytes(data, hmacKey);
    }

    /**
     * Compute the beacon value for raw bytes.
     *
     * @param data the bytes to hash
     * @param hmacKey the HMAC key for this beacon
     * @return hex string of the truncated hash
     */
    public String computeBeaconBytes(byte[] data, byte[] hmacKey) {
        byte[] hash = basicHash(data, hmacKey);
        return bytesToHex(hash, beaconLength);
    }

    /**
     * basicHash: HMAC-SHA384, keep first 8 bytes, then truncate to beaconLength bits.
     */
    static byte[] basicHash(byte[] data, byte[] key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA384");
            mac.init(new SecretKeySpec(key, "HmacSHA384"));
            byte[] fullHmac = mac.doFinal(data);
            // Keep first 8 bytes
            byte[] truncated = new byte[8];
            System.arraycopy(fullHmac, 0, truncated, 0, 8);
            return truncated;
        } catch (Exception e) {
            throw new DbeException("HMAC-SHA384 failed: " + e.getMessage());
        }
    }

    /**
     * Convert the rightmost `bits` bits of the 8-byte hash to a hex string.
     * Output length = ceil(bits / 4) hex characters.
     */
    static String bytesToHex(byte[] hash, int bits) {
        // Mask to keep only the rightmost `bits` bits
        long value = 0;
        for (int i = 0; i < 8; i++) {
            value = (value << 8) | (hash[i] & 0xFFL);
        }
        long mask = (1L << bits) - 1;
        value = value & mask;

        // Convert to hex string with correct length
        int hexLen = (bits + 3) / 4;
        String hex = Long.toHexString(value);
        // Pad with leading zeros
        while (hex.length() < hexLen) {
            hex = "0" + hex;
        }
        return hex;
    }
}
