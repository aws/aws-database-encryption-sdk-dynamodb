// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;

/**
 * Tests ported from TestNormalizeNumber.dfy.
 */
class NormalizeNumberTest {

    private void checkNormal(String input, String expected) {
        assertEquals(expected, NormalizeNumber.normalizeNumber(input),
            "NormalizeNumber(\"" + input + "\")");
    }

    private void checkFailure(String input) {
        assertThrows(DbeException.class, () -> NormalizeNumber.normalizeNumber(input),
            "Expected failure for \"" + input + "\"");
    }

    // ---- Zero variants ----

    @ParameterizedTest
    @CsvSource({
        "0, 0", "000, 0", ".000, 0", "0., 0", "0.0, 0", "000.000, 0", ".0, 0",
        "0e99, 0", "0.e99, 0", ".0e99, 0", "0.0e99, 0",
        "0e-99, 0", ".0e-99, 0", "0.0e-99, 0",
        "0e0, 0", "0.0e0, 0", "0.e0, 0", ".0e0, 0",
        "0e-0, 0", "0.0e-0, 0", "0.e-0, 0", ".0e-0, 0",
        "0e999, 0", "0e-999, 0",
        "-0, 0", "-000, 0", "-.000, 0", "-0., 0", "-0.0, 0", "-000.000, 0", "-.0, 0",
        "-0e99, 0", "-0.e99, 0", "-.0e99, 0", "-0.0e99, 0",
        "-0e-99, 0", "-.0e-99, 0", "-0.0e-99, 0",
        "-0e0, 0", "-0.0e0, 0", "-0.e0, 0", "-.0e0, 0",
        "-0e-0, 0", "-0.0e-0, 0", "-0.e-0, 0", "-.0e-0, 0",
        "+0, 0", "+0e+0, 0", "+0e0, 0", "0e+0, 0", "-0e+0, 0", "-0e0, 0"
    })
    void testZeroVariants(String input, String expected) {
        checkNormal(input, expected);
    }

    // ---- Basic normalization ----

    @ParameterizedTest
    @CsvSource({
        "12.34, 12.34",
        "00012.34, 12.34",
        "12.34000, 12.34",
        "012.340, 12.34",
        "123.456, 123.456",
        "+123.456, 123.456",
        "-123.456, -123.456",
        "1.2e2, 120",
        "+1.2e2, 120",
        "+1.2e+2, 120",
        "1.2e+2, 120",
        "-1.2e2, -120",
        "-1.2e+2, -120"
    })
    void testBasicNormalization(String input, String expected) {
        checkNormal(input, expected);
    }

    // ---- Scientific notation with decimal ----

    @ParameterizedTest
    @CsvSource({
        "123.456e0, 123.456", "123.456e-0, 123.456",
        "123.456e1, 1234.56", "123.456e-1, 12.3456",
        "123.456e2, 12345.6", "123.456e-2, 1.23456",
        "123.456e3, 123456",  "123.456e-3, 0.123456",
        "123.456e4, 1234560", "123.456e-4, 0.0123456",
        "123.456e5, 12345600","123.456e-5, 0.00123456"
    })
    void testScientificWithDecimal(String input, String expected) {
        checkNormal(input, expected);
    }

    // ---- Integer with exponent ----

    @ParameterizedTest
    @CsvSource({
        "123, 123", "123e0, 123", "123e-0, 123",
        "123e1, 1230", "123e2, 12300", "123e3, 123000",
        "123e-1, 12.3", "123e-2, 1.23", "123e-3, 0.123", "123e-4, 0.0123"
    })
    void testIntegerWithExponent(String input, String expected) {
        checkNormal(input, expected);
    }

    // ---- Fractional with exponent ----

    @ParameterizedTest
    @CsvSource({
        ".123, 0.123", ".123e0, 0.123", ".123e-0, 0.123",
        ".123e1, 1.23", ".123e-1, 0.0123",
        ".123e2, 12.3", ".123e-2, 0.00123",
        ".123e3, 123", ".123e-3, 0.000123",
        "0.123, 0.123", "0.123e0, 0.123", "0.123e-0, 0.123",
        "0.123e1, 1.23", "0.123e2, 12.3", "0.123e3, 123", "0.123e4, 1230",
        "0.123e-1, 0.0123", "0.123e-2, 0.00123"
    })
    void testFractionalWithExponent(String input, String expected) {
        checkNormal(input, expected);
    }

    // ---- Trailing decimal ----

    @ParameterizedTest
    @CsvSource({
        "123., 123", "123.e0, 123", "123.e-0, 123",
        "123.e1, 1230", "123.e-1, 12.3",
        "123.e2, 12300", "123.e-2, 1.23",
        "123.e3, 123000", "123.e-3, 0.123"
    })
    void testTrailingDecimal(String input, String expected) {
        checkNormal(input, expected);
    }

    // ---- Invalid inputs ----

    @ParameterizedTest
    @ValueSource(strings = {
        "", ".", "+", "-", "e", "E",
        "1.2.3", "1.2e3e4", ".e4", "1.2e4.",
        "e99", "e-99", "1.2e--99", "1.2e+-99", "1.2e-+99",
        "--1.2", "++1.2", "+-1.2", "-+1.2",
        "1e", "1e-", "1e+", "1e1.1", "e0",
        "1a1", "1-1", "1+1", "1.-2", "1.+2"
    })
    void testInvalidInputs(String input) {
        checkFailure(input);
    }

    // ---- Precision limits ----

    @Test
    void test38DigitsOk() {
        checkNormal("123456789.01234567890123456789012345678",
                    "123456789.01234567890123456789012345678");
    }

    @Test
    void test39DigitsFails() {
        checkFailure("123456789.012345678901234567890123456789");
    }

    @Test
    void test38DigitsWithTrailingZerosOk() {
        checkNormal("1234567890123456789012345678901234567800000000000000000000000000000",
                    "1234567890123456789012345678901234567800000000000000000000000000000");
    }

    @Test
    void test39DigitsWithTrailingZerosFails() {
        checkFailure("1234567890123456789012345678901234567890000000000000000000000000000");
    }

    // ---- Magnitude limits ----

    @Test
    void testMaxPositiveExponent() {
        // 9.999...E+125 is the max
        checkNormal("9.9999999999999999999999999999999999999E+125",
            "999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    }

    @Test
    void testExponentTooLarge() {
        checkFailure("1E+126");
        checkFailure("10E+125");
    }

    @Test
    void testMinPositiveExponent() {
        checkNormal("1E-130",
            "0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
    }

    @Test
    void testExponentTooSmall() {
        checkFailure("9.9999999999999999999999999999999999999E-131");
    }

    @Test
    void testNegativeMaxMagnitude() {
        checkNormal("-9.9999999999999999999999999999999999999E+125",
            "-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        checkFailure("-1E+126");
    }

    @Test
    void testNegativeMinMagnitude() {
        checkNormal("-1E-130",
            "-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
        checkFailure("-9.9999999999999999999999999999999999999E-131");
    }
}
