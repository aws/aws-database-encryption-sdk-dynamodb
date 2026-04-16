// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;

/**
 * Normalizes DynamoDB number strings to a canonical form, matching
 * the normalization that DynamoDB itself performs.
 *
 * <p>DynamoDB numbers have these constraints:
 * <ul>
 *   <li>Up to 38 significant digits</li>
 *   <li>Magnitude between 1e-130 and 9.9999...e+125 (positive) or zero</li>
 * </ul>
 */
public final class NormalizeNumber {

  private static final int MAX_SIGNIFICANT_DIGITS = 38;
  // Exponent of the most significant digit must be in [-130, 125]
  // i.e. the number 1e126 has its significant digit at exponent 126 which is out of range
  private static final int MAX_EXPONENT = 125;
  private static final int MIN_EXPONENT = -130;

  private NormalizeNumber() {}

  /**
   * Normalizes a DynamoDB number string to its canonical form.
   *
   * @param number the number string to normalize
   * @return the normalized number string
   * @throws DbeException if the input is not a valid DynamoDB number
   */
  public static String normalizeNumber(String number) {
    if (number == null || number.isEmpty()) {
      throw new DbeException("Invalid DynamoDB number: empty string");
    }

    String s = number;

    // Handle sign
    boolean negative = false;
    if (s.charAt(0) == '-') {
      negative = true;
      s = s.substring(1);
    } else if (s.charAt(0) == '+') {
      s = s.substring(1);
    }

    if (s.isEmpty()) {
      throw new DbeException("Invalid DynamoDB number: \"" + number + "\"");
    }

    // Split on 'e' or 'E' for scientific notation
    int expIndex = indexOfExponent(s);
    String mantissa;
    int exponent = 0;
    if (expIndex >= 0) {
      mantissa = s.substring(0, expIndex);
      String expStr = s.substring(expIndex + 1);
      if (expStr.isEmpty()) {
        throw new DbeException("Invalid DynamoDB number: \"" + number + "\"");
      }
      try {
        exponent = Integer.parseInt(expStr);
      } catch (NumberFormatException e) {
        throw new DbeException("Invalid DynamoDB number: \"" + number + "\"");
      }
    } else {
      mantissa = s;
    }

    if (mantissa.isEmpty()) {
      throw new DbeException("Invalid DynamoDB number: \"" + number + "\"");
    }

    // Split mantissa into integer and fractional parts
    int dotIndex = mantissa.indexOf('.');
    String intPart;
    String fracPart;
    if (dotIndex >= 0) {
      if (mantissa.indexOf('.', dotIndex + 1) >= 0) {
        throw new DbeException("Invalid DynamoDB number: \"" + number + "\"");
      }
      intPart = mantissa.substring(0, dotIndex);
      fracPart = mantissa.substring(dotIndex + 1);
    } else {
      intPart = mantissa;
      fracPart = "";
    }

    // Validate all characters are digits
    validateDigits(intPart, number);
    validateDigits(fracPart, number);

    if (intPart.isEmpty() && fracPart.isEmpty()) {
      throw new DbeException("Invalid DynamoDB number: \"" + number + "\"");
    }

    // Combine into a single digit string and track the decimal position.
    // digits = intPart + fracPart, with decimalPosition = intPart.length()
    // The actual value is: digits * 10^(exponent + intPart.length() - totalDigits)
    // But it's easier to think of it as: we have digits, and the decimal point
    // sits after intPart.length() digits from the left, then shifted by exponent.
    String allDigits = intPart + fracPart;
    // decPos: number of digits to the left of the decimal point (before exponent adjustment)
    int decPos = intPart.length() + exponent;

    // Strip leading zeros from allDigits
    int firstNonZero = 0;
    while (firstNonZero < allDigits.length() && allDigits.charAt(firstNonZero) == '0') {
      firstNonZero++;
    }

    if (firstNonZero == allDigits.length()) {
      // All zeros
      return "0";
    }

    String significantDigits = allDigits.substring(firstNonZero);
    // Adjust decPos: we removed firstNonZero leading zeros
    decPos = decPos - firstNonZero;

    // Strip trailing zeros from significantDigits
    int lastNonZero = significantDigits.length() - 1;
    while (lastNonZero > 0 && significantDigits.charAt(lastNonZero) == '0') {
      lastNonZero--;
    }
    significantDigits = significantDigits.substring(0, lastNonZero + 1);

    // Validate significant digit count
    if (significantDigits.length() > MAX_SIGNIFICANT_DIGITS) {
      throw new DbeException(
        "Invalid DynamoDB number: more than 38 significant digits in \"" + number + "\""
      );
    }

    // Validate magnitude.
    // decPos is the exponent of the most significant digit + 1.
    // The most significant digit's exponent = decPos - 1.
    int msdExponent = decPos - 1;
    if (msdExponent > MAX_EXPONENT) {
      throw new DbeException(
        "Invalid DynamoDB number: magnitude too large in \"" + number + "\""
      );
    }
    // The least significant digit's exponent = decPos - significantDigits.length()
    int lsdExponent = decPos - significantDigits.length();
    if (lsdExponent < MIN_EXPONENT) {
      throw new DbeException(
        "Invalid DynamoDB number: magnitude too small in \"" + number + "\""
      );
    }

    // Build the normalized string
    String result = buildNormalized(significantDigits, decPos);

    if (negative) {
      result = "-" + result;
    }
    return result;
  }

  /**
   * Builds the normalized decimal string from significant digits and the
   * decimal position (number of digits to the left of the decimal point).
   */
  private static String buildNormalized(String digits, int decPos) {
    int len = digits.length();

    if (decPos >= len) {
      // All digits are to the left of the decimal point; append zeros if needed.
      // e.g. digits="123", decPos=5 → "12300"
      StringBuilder sb = new StringBuilder(decPos);
      sb.append(digits);
      for (int i = len; i < decPos; i++) {
        sb.append('0');
      }
      return sb.toString();
    } else if (decPos > 0) {
      // Decimal point falls within the digits.
      // e.g. digits="12345", decPos=3 → "123.45"
      return digits.substring(0, decPos) + "." + digits.substring(decPos);
    } else {
      // decPos <= 0: all digits are to the right of the decimal point.
      // e.g. digits="123", decPos=-2 → "0.00123"
      StringBuilder sb = new StringBuilder(2 + (-decPos) + len);
      sb.append("0.");
      for (int i = 0; i < -decPos; i++) {
        sb.append('0');
      }
      sb.append(digits);
      return sb.toString();
    }
  }

  private static int indexOfExponent(String s) {
    int e = s.indexOf('e');
    if (e >= 0) return e;
    return s.indexOf('E');
  }

  private static void validateDigits(String s, String original) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c < '0' || c > '9') {
        throw new DbeException("Invalid DynamoDB number: \"" + original + "\"");
      }
    }
  }
}
