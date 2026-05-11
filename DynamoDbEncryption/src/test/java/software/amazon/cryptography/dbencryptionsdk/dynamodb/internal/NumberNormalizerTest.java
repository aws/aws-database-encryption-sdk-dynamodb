// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberNormalizerTest {

  @Test
  void basicIntegers() {
    assertEquals("0", NumberNormalizer.normalize("0"));
    assertEquals("1", NumberNormalizer.normalize("1"));
    assertEquals("123", NumberNormalizer.normalize("123"));
    assertEquals("-1", NumberNormalizer.normalize("-1"));
  }

  @Test
  void leadingZeros() {
    assertEquals("1", NumberNormalizer.normalize("001"));
    assertEquals("0.1", NumberNormalizer.normalize("00.10"));
    assertEquals("123", NumberNormalizer.normalize("0123"));
  }

  @Test
  void trailingZeros() {
    assertEquals("1.5", NumberNormalizer.normalize("1.50"));
    assertEquals("1.5", NumberNormalizer.normalize("1.500"));
    assertEquals("10", NumberNormalizer.normalize("10.0"));
  }

  @Test
  void scientificNotation() {
    assertEquals("100", NumberNormalizer.normalize("1e2"));
    assertEquals("100", NumberNormalizer.normalize("1E2"));
    assertEquals("0.01", NumberNormalizer.normalize("1e-2"));
    assertEquals("12300", NumberNormalizer.normalize("123e2"));
    assertEquals("1.23", NumberNormalizer.normalize("123e-2"));
  }

  @Test
  void scientificWithDecimal() {
    assertEquals("123456700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
      NumberNormalizer.normalize("12345.67e121"));
  }

  @Test
  void negativeZeroBecomesZero() {
    assertEquals("0", NumberNormalizer.normalize("-0"));
    assertEquals("0", NumberNormalizer.normalize("-0.0"));
    assertEquals("0", NumberNormalizer.normalize("+0"));
  }

  @Test
  void plusSign() {
    assertEquals("42", NumberNormalizer.normalize("+42"));
  }

  @Test
  void precisionLimit38Digits() {
    // 38 digits OK
    assertDoesNotThrow(() -> NumberNormalizer.normalize("12345678901234567890123456789012345678"));
    // 39 digits fails
    assertThrows(IllegalArgumentException.class, () ->
      NumberNormalizer.normalize("123456789012345678901234567890123456789"));
  }

  @Test
  void magnitudeUpperBound() {
    // 10^125 range OK
    assertDoesNotThrow(() -> NumberNormalizer.normalize("9.9999999999999999999999999999999999999E+125"));
    // 10^126 fails
    assertThrows(IllegalArgumentException.class, () -> NumberNormalizer.normalize("1E+126"));
  }

  @Test
  void magnitudeLowerBound() {
    // 10^-130 OK
    assertDoesNotThrow(() -> NumberNormalizer.normalize("1E-130"));
    // below 10^-130 fails
    assertThrows(IllegalArgumentException.class, () -> NumberNormalizer.normalize("9.9999999999999999999999999999999999999E-131"));
  }

  @Test
  void invalidInputs() {
    assertThrows(IllegalArgumentException.class, () -> NumberNormalizer.normalize(""));
    assertThrows(IllegalArgumentException.class, () -> NumberNormalizer.normalize("abc"));
    assertThrows(IllegalArgumentException.class, () -> NumberNormalizer.normalize("e99"));
  }
}
