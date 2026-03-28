package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.security.GeneralSecurityException;
import java.util.Map;

public interface LegacyEncryptorAdapter {

    Map<String, AttributeValue>
    encryptRecord(Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> item) throws GeneralSecurityException;

    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue>
    decryptRecord(Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> item) throws GeneralSecurityException;

    String getMaterialDescriptionFieldName();
    String getSignatureFieldName();
}
