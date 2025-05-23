package software.amazon.cryptography.examples.keyring;

import java.nio.ByteBuffer;
import java.security.spec.ECGenParameterSpec;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;
import software.amazon.cryptography.primitives.model.ECDHCurveSpec;

public class TestRawEcdhKeyringExample {

  @Test
  public void TestStaticRawEcdhKeyringExample() {
    // You may provide your own ECC Key pairs in the files located at
    // - EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
    // - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    // If you provide this, the keys MUST be on curve P256
    // If these files are not present, this will generate a pair for you.
    // For this example we will use the curve P256.
    if (RawEcdhKeyringExample.shouldGenerateNewEccKeyPairs()) {
      RawEcdhKeyringExample.generateEccKeyPairs();
    }

    // Part of using these keyrings is knowing which curve the keys used in the key agreement
    // lie on. The keyring will fail if the keys do not lie on the configured curve.
    RawEcdhKeyringExample.RawEcdhKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      ECDHCurveSpec.ECC_NIST_P256
    );
  }

  @Test
  public void TestEphemeralRawEcdhKeyringExample() {
    // You may provide your own ECC Public Key in the files located at
    // - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    // If you provide this, the keys MUST be on curve P256
    // If these files are not present, this will generate a pair for you.
    // For this example we will use the curve P256.
    if (RawEcdhKeyringExample.shouldGenerateNewEccKeyPairs()) {
      RawEcdhKeyringExample.generateEccKeyPairs();
    }

    // Part of using these keyrings is knowing which curve the keys used in the key agreement
    // lie on. The keyring will fail if the keys do not lie on the configured curve.
    RawEcdhKeyringExample.EphemeralRawEcdhKeyringPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      ECDHCurveSpec.ECC_NIST_P256
    );
  }

  @Test
  public void TestDiscoveryRawEcdhKeyringExample() {
    // You may provide your own ECC Public Key in the files located at
    // - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    // - EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
    // If you provide this, the keys MUST be on curve P256
    // If these files are not present, this will generate a pair for you.
    // For this example we will use the curve P256.
    if (RawEcdhKeyringExample.shouldGenerateNewEccKeyPairs()) {
      RawEcdhKeyringExample.generateEccKeyPairs();
    }

    // The discovery configuration is not allowed to encrypt
    // To understand this example best, we will write a record with the ephemeral configuration
    // in the previous example. This means that the recipient public key configured on
    // both keyrings is the same. This means that the other party has the recipient public key
    // and is writing messages meant only for the owner of the recipient public key to decrypt.

    // In this call we are writing a record that is written with an ephemeral sender key pair.
    // The recipient will be able to decrypt the message
    RawEcdhKeyringExample.EphemeralRawEcdhKeyringPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      ECDHCurveSpec.ECC_NIST_P256
    );

    // In this call we are reading a record that was written with the recipient's public key.
    // It will use the recipient's private key and the sender's public key stored in the message to
    // calculate the appropriate shared secret to successfully decrypt the message.
    RawEcdhKeyringExample.DiscoveryRawEcdhKeyringGetItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      ECDHCurveSpec.ECC_NIST_P256
    );
  }
}
