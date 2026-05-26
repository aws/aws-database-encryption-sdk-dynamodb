// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Collections;
import java.util.List;

/**
 * A decrypt test definition containing a config, encrypted records, and expected plaintext records.
 */
public class DecryptTest {

    private final TableConfig config;
    private final List<Record> encryptedRecords;
    private final List<Record> plaintextRecords;

    public DecryptTest(TableConfig config, List<Record> encryptedRecords, List<Record> plaintextRecords) {
        this.config = config;
        this.encryptedRecords = encryptedRecords != null
                ? Collections.unmodifiableList(encryptedRecords)
                : Collections.<Record>emptyList();
        this.plaintextRecords = plaintextRecords != null
                ? Collections.unmodifiableList(plaintextRecords)
                : Collections.<Record>emptyList();
    }

    public TableConfig getConfig() {
        return config;
    }

    public List<Record> getEncryptedRecords() {
        return encryptedRecords;
    }

    public List<Record> getPlaintextRecords() {
        return plaintextRecords;
    }

    @Override
    public String toString() {
        return "DecryptTest{config=" + config + ", encryptedRecords=" + encryptedRecords.size()
                + " items, plaintextRecords=" + plaintextRecords.size() + " items}";
    }
}
