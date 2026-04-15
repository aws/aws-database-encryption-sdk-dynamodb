package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

public enum CryptoAction {
    ENCRYPT_AND_SIGN,
    SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
    SIGN_ONLY,
    DO_NOTHING
}
