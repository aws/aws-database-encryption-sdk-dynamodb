// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

class FieldEncryptorTest {

  @Test
  void deriveFieldRootKeyProduces32Bytes() {
    byte[] dataKey = new byte[32];
    Arrays.fill(dataKey, (byte) 0xAA);
    byte[] messageId = new byte[MSG_ID_LEN];
    Arrays.fill(messageId, (byte) 0xBB);

    byte[] fieldRootKey = FieldEncryptor.deriveFieldRootKey(dataKey, messageId);
    assertEquals(KEY_SIZE, fieldRootKey.length);
  }

  @Test
  void deriveFieldKeyProduces44Bytes() {
    byte[] fieldRootKey = new byte[KEY_SIZE];
    Arrays.fill(fieldRootKey, (byte) 0xCC);

    byte[] fieldKey = FieldEncryptor.deriveFieldKey(fieldRootKey, 0);
    assertEquals(FIELD_KEY_LENGTH, fieldKey.length);
  }

  @Test
  void differentOffsetsProduceDifferentKeys() {
    byte[] fieldRootKey = new byte[KEY_SIZE];
    Arrays.fill(fieldRootKey, (byte) 0xDD);

    byte[] key0 = FieldEncryptor.deriveFieldKey(fieldRootKey, 0);
    byte[] key1 = FieldEncryptor.deriveFieldKey(fieldRootKey, 1);
    assertFalse(Arrays.equals(key0, key1));
  }

  @Test
  void encryptDecryptRoundTrip() {
    byte[] fieldRootKey = new byte[KEY_SIZE];
    Arrays.fill(fieldRootKey, (byte) 0xEE);

    byte[] fieldKey = FieldEncryptor.deriveFieldKey(fieldRootKey, 0);
    byte[] cipherKey = FieldEncryptor.getCipherKey(fieldKey);
    byte[] nonce = FieldEncryptor.getNonce(fieldKey);

    byte[] plaintext = "Hello, DB-ESDK!".getBytes();
    byte[] aad = CanonicalPath.simpleCanon("MyTable", "myField");

    byte[] ciphertext = FieldEncryptor.encrypt(cipherKey, nonce, plaintext, aad);
    assertFalse(Arrays.equals(plaintext, ciphertext));
    assertTrue(ciphertext.length > plaintext.length); // includes auth tag

    byte[] decrypted = FieldEncryptor.decrypt(cipherKey, nonce, ciphertext, aad);
    assertArrayEquals(plaintext, decrypted);
  }

  @Test
  void wrongAadFailsDecrypt() {
    byte[] fieldRootKey = new byte[KEY_SIZE];
    byte[] fieldKey = FieldEncryptor.deriveFieldKey(fieldRootKey, 0);
    byte[] cipherKey = FieldEncryptor.getCipherKey(fieldKey);
    byte[] nonce = FieldEncryptor.getNonce(fieldKey);

    byte[] plaintext = "secret".getBytes();
    byte[] aad = CanonicalPath.simpleCanon("Table", "field1");
    byte[] wrongAad = CanonicalPath.simpleCanon("Table", "field2");

    byte[] ciphertext = FieldEncryptor.encrypt(cipherKey, nonce, plaintext, aad);

    assertThrows(RuntimeException.class, () ->
      FieldEncryptor.decrypt(cipherKey, nonce, ciphertext, wrongAad)
    );
  }

  @Test
  void canonicalPathDeterministic() {
    byte[] path1 = CanonicalPath.simpleCanon("MyTable", "pk");
    byte[] path2 = CanonicalPath.simpleCanon("MyTable", "pk");
    assertArrayEquals(path1, path2);
  }

  @Test
  void differentFieldsDifferentPaths() {
    byte[] path1 = CanonicalPath.simpleCanon("MyTable", "pk");
    byte[] path2 = CanonicalPath.simpleCanon("MyTable", "sk");
    assertFalse(Arrays.equals(path1, path2));
  }
}
