package software.amazon.cryptography.dynamoDbEncryption.model;

public enum LegacyPolicy {
    REQUIRE_ENCRYPT_ALLOW_DECRYPT("REQUIRE_ENCRYPT_ALLOW_DECRYPT"),

    FORBID_ENCRYPT_ALLOW_DECRYPT("FORBID_ENCRYPT_ALLOW_DECRYPT");

    private final String value;

    private LegacyPolicy(String value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}