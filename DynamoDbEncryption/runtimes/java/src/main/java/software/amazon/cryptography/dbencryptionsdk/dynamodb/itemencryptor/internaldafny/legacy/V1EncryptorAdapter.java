package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;

import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.Set;

import static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride.V1MapToV2Map;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride.V2MapToV1Map;

public class V1EncryptorAdapter implements LegacyEncryptorAdapter {
    private final DynamoDBEncryptor encryptor;
    private final Map<String, Set<EncryptionFlags>> actions;
    private final EncryptionContext encryptionContext;

    V1EncryptorAdapter(DynamoDBEncryptor encryptor, Map<String, Set<EncryptionFlags>> actions,EncryptionContext encryptionContext) {
        this.encryptor = encryptor;
        this.actions = actions;
        this.encryptionContext = encryptionContext;
    }

    @Override
    public Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue>
        encryptRecord(Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> item) throws GeneralSecurityException {
            return V1MapToV2Map(
                    encryptor.encryptRecord(V2MapToV1Map(item), actions, encryptionContext)
            );
        }

    @Override
    public Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue>
    decryptRecord(Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> item) throws GeneralSecurityException {
        return V1MapToV2Map(
                encryptor.decryptRecord(V2MapToV1Map(item), actions, encryptionContext)
        );
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
