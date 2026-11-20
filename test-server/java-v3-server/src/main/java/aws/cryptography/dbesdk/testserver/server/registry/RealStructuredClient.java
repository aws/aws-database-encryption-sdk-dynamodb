package aws.cryptography.dbesdk.testserver.server.registry;

import aws.cryptography.dbesdk.testserver.server.error.DbesdkClientException;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.StructuredEncryption;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptPathStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.DecryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptPathStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.EncryptStructureInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;

/**
 * A {@link StructuredClient} backed by the real
 * {@link StructuredEncryption} from the AWS Database Encryption SDK, plus the
 * {@code CMM} the client was configured with (the CMM is a per-operation input
 * of the DBE Encrypt/DecryptStructure API, so it is held here and passed on
 * every call). Every DBE exception is caught and rethrown as a
 * {@link DbesdkClientException} so the operation wrapper surfaces it as
 * {@code DBESDKClientError}.
 */
public final class RealStructuredClient implements StructuredClient {

  private final StructuredEncryption structured;
  private final ICryptographicMaterialsManager cmm;

  public RealStructuredClient(
    StructuredEncryption structured,
    ICryptographicMaterialsManager cmm
  ) {
    this.structured = structured;
    this.cmm = cmm;
  }

  @Override
  public Map<String, StructuredDataTerminal> encryptStructure(
    String tableName,
    Map<String, StructuredDataTerminal> plaintextStructure,
    Map<String, CryptoAction> cryptoSchema
  ) throws DbesdkClientException {
    try {
      return structured
        .EncryptStructure(
          EncryptStructureInput
            .builder()
            .tableName(tableName)
            .plaintextStructure(plaintextStructure)
            .cryptoSchema(cryptoSchema)
            .cmm(cmm)
            .build()
        )
        .encryptedStructure();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public Map<String, StructuredDataTerminal> decryptStructure(
    String tableName,
    Map<String, StructuredDataTerminal> encryptedStructure,
    Map<String, AuthenticateAction> authenticateSchema
  ) throws DbesdkClientException {
    try {
      return structured
        .DecryptStructure(
          DecryptStructureInput
            .builder()
            .tableName(tableName)
            .encryptedStructure(encryptedStructure)
            .authenticateSchema(authenticateSchema)
            .cmm(cmm)
            .build()
        )
        .plaintextStructure();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public List<CryptoItem> encryptPathStructure(
    String tableName,
    List<CryptoItem> plaintextStructure
  ) throws DbesdkClientException {
    try {
      return structured
        .EncryptPathStructure(
          EncryptPathStructureInput
            .builder()
            .tableName(tableName)
            .plaintextStructure(plaintextStructure)
            .cmm(cmm)
            .build()
        )
        .encryptedStructure();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public List<CryptoItem> decryptPathStructure(
    String tableName,
    List<AuthItem> encryptedStructure
  ) throws DbesdkClientException {
    try {
      return structured
        .DecryptPathStructure(
          DecryptPathStructureInput
            .builder()
            .tableName(tableName)
            .encryptedStructure(encryptedStructure)
            .cmm(cmm)
            .build()
        )
        .plaintextStructure();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }
}
