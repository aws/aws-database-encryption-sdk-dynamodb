package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ParsedHeader {

    private final String algorithmSuiteId;
    private final Map<String, String> storedEncryptionContext;
    private final Map<String, String> encryptionContext;

    public ParsedHeader(
            String algorithmSuiteId,
            Map<String, String> storedEncryptionContext,
            Map<String, String> encryptionContext) {
        this.algorithmSuiteId = algorithmSuiteId;
        this.storedEncryptionContext = Collections.unmodifiableMap(
                new HashMap<String, String>(storedEncryptionContext));
        this.encryptionContext = Collections.unmodifiableMap(
                new HashMap<String, String>(encryptionContext));
    }

    public String getAlgorithmSuiteId() {
        return algorithmSuiteId;
    }

    public Map<String, String> getStoredEncryptionContext() {
        return storedEncryptionContext;
    }

    public Map<String, String> getEncryptionContext() {
        return encryptionContext;
    }
}
