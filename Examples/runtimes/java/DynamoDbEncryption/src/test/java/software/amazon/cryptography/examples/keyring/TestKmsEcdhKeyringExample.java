package software.amazon.cryptography.examples.keyring;

import static software.amazon.cryptography.examples.keyring.KmsEcdhKeyringExample.EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME;
import static software.amazon.cryptography.examples.keyring.KmsEcdhKeyringExample.EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME;
import static software.amazon.cryptography.examples.keyring.KmsEcdhKeyringExample.shouldGetNewPublicKeys;
import static software.amazon.cryptography.examples.keyring.KmsEcdhKeyringExample.writePublicKeyPemForEccKey;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestKmsEcdhKeyringExample {

  @Test
  public void TestKmsEcdhKeyringExampleStatic() {
    // You may provide your own ECC public keys at
    // - EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
    // - EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME.
    // If you provide these, the keys MUST be on curve P256
    // This must be the public key for the ECC key represented at eccKeyArn
    // If this file is not present, this will write a UTF-8 encoded PEM file for you.
    if (shouldGetNewPublicKeys()) {
      writePublicKeyPemForEccKey(
        TestUtils.TEST_KMS_ECDH_KEY_ID_P256_SENDER,
        EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
      );
      writePublicKeyPemForEccKey(
        TestUtils.TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT,
        EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME
      );
    }

    KmsEcdhKeyringExample.KmsEcdhKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      TestUtils.TEST_KMS_ECDH_KEY_ID_P256_SENDER
    );
  }

  @Test
  public void TestKmsEcdhKeyringExampleDiscovery() {
    // In this example you do not need to provide the recipient ECC Public Key.
    // On initialization, the keyring will call KMS:getPublicKey on the configured
    // recipientKmsIdentifier set on the keyring. This example uses the previous example
    // to write an item meant for the recipient.
    KmsEcdhKeyringExample.KmsEcdhDiscoveryGetItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      TestUtils.TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT
    );
  }
}
