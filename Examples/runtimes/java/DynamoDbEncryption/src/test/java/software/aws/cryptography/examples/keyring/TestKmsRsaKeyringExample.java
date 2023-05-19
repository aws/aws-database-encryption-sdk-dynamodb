package software.aws.cryptography.examples.keyring;

import static software.aws.cryptography.examples.keyring.KmsRsaKeyringExample.shouldGetNewPublicKey;
import static software.aws.cryptography.examples.keyring.KmsRsaKeyringExample.writePublicKeyPemForRsaKey;

import org.testng.annotations.Test;
import software.aws.cryptography.examples.TestUtils;

public class TestKmsRsaKeyringExample {
    @Test
    public void TestKmsRsaKeyringExample() {
        // You may provide your own RSA public key at EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
        // This must be the public key for the RSA key represented at rsaKeyArn.
        // If this file is not present, this will write a UTF-8 encoded PEM file for you.
        if (shouldGetNewPublicKey()) {
            writePublicKeyPemForRsaKey(TestUtils.TEST_KMS_RSA_KEY_ID);
        }

        KmsRsaKeyringExample.KmsRsaKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                TestUtils.TEST_KMS_RSA_KEY_ID);
    }
}
