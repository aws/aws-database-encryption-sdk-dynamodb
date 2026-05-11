package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy;

import java.security.GeneralSecurityException;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface LegacyEncryptorAdapter {
  Map<String, AttributeValue> encryptRecord(
    Map<
      String,
      software.amazon.awssdk.services.dynamodb.model.AttributeValue
    > item
  ) throws GeneralSecurityException;

  Map<
    String,
    software.amazon.awssdk.services.dynamodb.model.AttributeValue
  > decryptRecord(
    Map<
      String,
      software.amazon.awssdk.services.dynamodb.model.AttributeValue
    > item
  ) throws GeneralSecurityException;

  String getMaterialDescriptionFieldName();
  String getSignatureFieldName();
}
