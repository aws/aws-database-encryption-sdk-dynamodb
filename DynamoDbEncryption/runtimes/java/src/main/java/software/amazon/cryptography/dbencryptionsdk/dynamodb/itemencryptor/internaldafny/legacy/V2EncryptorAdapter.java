package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy;

import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;

import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.Set;

import static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride.V1MapToV2Map;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride.V2MapToV1Map;

public class V2EncryptorAdapter implements LegacyEncryptorAdapter {
    private final DynamoDBEncryptor encryptor;
    private final Map<String, Set<EncryptionFlags>> actions;
    private final EncryptionContext encryptionContext;

    V2EncryptorAdapter(DynamoDBEncryptor encryptor, Map<String, Set<EncryptionFlags>> actions, EncryptionContext encryptionContext) {
        this.encryptor = encryptor;
        this.actions = actions;
        this.encryptionContext = encryptionContext;
    }

    @Override
    public Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue>
        encryptRecord(Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> item) throws GeneralSecurityException {
            return encryptor.encryptRecord(item, actions, encryptionContext);
        }

    @Override
    public Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue>
    decryptRecord(Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> item) throws GeneralSecurityException {
        return encryptor.decryptRecord(item, actions, encryptionContext);
    }

    @Override
    public String getMaterialDescriptionFieldName() {
        return encryptor.getMaterialDescriptionFieldName();
    }

    @Override
    public String getSignatureFieldName() {
        return encryptor.getSignatureFieldName();
    }
}
