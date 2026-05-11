// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

/**
 * Normalizes DynamoDB number strings to a canonical form.
 * DynamoDB numbers support up to 38 significant digits and magnitudes from 10^-130 to 10^125.
 */
public final class NumberNormalizer {

  private NumberNormalizer() {}

  /**
   * Normalize a DynamoDB number string.
   * Handles: leading/trailing zeros, scientific notation, sign normalization.
   */
  public static String normalize(String n) {
    if (n == null || n.isEmpty()) {
      throw new IllegalArgumentException("An empty string is not a valid number.");
    }

    boolean negative = false;
    int start = 0;
    if (n.charAt(0) == '-') {
      negative = true;
      start = 1;
    } else if (n.charAt(0) == '+') {
      start = 1;
    }

    if (start >= n.length()) {
      throw new IllegalArgumentException("An empty string is not a valid number.");
    }

    String result = normalizePositive(n.substring(start));
    result = trimZerosFromValidNumber(result);

    if (negative && !"0".equals(result)) {
      return "-" + result;
    }
    return result;
  }

  private static String normalizePositive(String n) {
    // Parse into digits, decimal position, and exponent
    int[] parsed = parseNumber(n);
    // parsed[0] = start of digits in builder, parsed[1] = pos (decimal position), parsed[2] = exp
    String digits = extractDigits(n);
    int pos = parsed[0];
    int exp = parsed[1];

    // NormalizeValue: strip leading zeros before pos, trailing zeros after pos
    int lo = 0, hi = digits.length();
    int p = pos;
    while (lo < hi && digits.charAt(lo) == '0' && p > 0) { lo++; p--; }
    while (hi > lo && digits.charAt(hi - 1) == '0' && p < (hi - lo)) { hi--; }
    digits = digits.substring(lo, hi);
    pos = p;

    // Check precision
    String precision = stripAllZeros(digits);
    if (precision.length() > 38) {
      throw new IllegalArgumentException("Attempting to store more than 38 significant digits in a Number.");
    }

    int newPos = pos + exp;
    if (precision.isEmpty()) {
      return "0";
    } else if (newPos <= 0) {
      int leadingZeros = countLeadingZeros(digits);
      if (newPos - leadingZeros < -129) {
        throw new IllegalArgumentException("Attempting to store a number with magnitude smaller than supported range.");
      }
      return "0." + zeros(-newPos) + digits;
    } else if (newPos >= digits.length()) {
      int leadingZeros = countLeadingZeros(digits);
      if (newPos - leadingZeros > 126) {
        throw new IllegalArgumentException("Attempting to store a number with magnitude larger than supported range.");
      }
      return digits + zeros(newPos - digits.length());
    } else {
      return digits.substring(0, newPos) + "." + digits.substring(newPos);
    }
  }

  /** Parse number into (digits, decimalPosition, exponent). Returns [pos, exp]. */
  private static int[] parseNumber(String n) {
    int preDot = countDigits(n, 0);
    if (preDot == n.length()) {
      return new int[] { preDot, 0 };
    } else if (n.charAt(preDot) == '.') {
      int postDot = countDigits(n, preDot + 1);
      if (preDot + postDot == 0) {
        throw new IllegalArgumentException("Number needs digits either before or after the decimal point.");
      }
      int len = preDot + postDot + 1;
      if (len == n.length()) {
        return new int[] { preDot, 0 };
      } else if (isE(n.charAt(len))) {
        int exp = parseInt(n.substring(len + 1));
        return new int[] { preDot, exp };
      } else {
        throw new IllegalArgumentException("Invalid Character in number at '" + n.substring(len) + "'.");
      }
    } else if (preDot == 0) {
      throw new IllegalArgumentException("Number needs digits either before or after the decimal point.");
    } else if (isE(n.charAt(preDot))) {
      int exp = parseInt(n.substring(preDot + 1));
      return new int[] { preDot, exp };
    } else {
      throw new IllegalArgumentException("Invalid Character in number at '" + n.substring(preDot) + "'.");
    }
  }

  /** Extract only the digit characters (skip the dot). */
  private static String extractDigits(String n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n.length(); i++) {
      char c = n.charAt(i);
      if (c >= '0' && c <= '9') {
        sb.append(c);
      } else if (c == '.') {
        continue;
      } else {
        break; // hit 'e'/'E' or end
      }
    }
    return sb.toString();
  }

  private static String trimZerosFromValidNumber(String n) {
    n = skipLeadingZeros(n);
    if (n.indexOf('.') >= 0) {
      n = skipTrailingZeros(n);
    }
    return n;
  }

  private static String skipLeadingZeros(String val) {
    int i = 0;
    while (i < val.length() - 1 && val.charAt(i) == '0' && val.charAt(i + 1) != '.') {
      i++;
    }
    return val.substring(i);
  }

  private static String skipTrailingZeros(String val) {
    int end = val.length();
    while (end > 1 && val.charAt(end - 1) == '0') {
      if (val.charAt(end - 2) == '.') {
        return val.substring(0, end - 2);
      }
      end--;
    }
    return val.substring(0, end);
  }

  private static String stripAllZeros(String s) {
    int lo = 0, hi = s.length();
    while (lo < hi && s.charAt(lo) == '0') lo++;
    while (hi > lo && s.charAt(hi - 1) == '0') hi--;
    return s.substring(lo, hi);
  }

  private static int countLeadingZeros(String s) {
    int c = 0;
    for (int i = 0; i < s.length() && s.charAt(i) == '0'; i++) c++;
    return c;
  }

  private static int countDigits(String s, int from) {
    int i = from;
    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') i++;
    return i - from;
  }

  private static boolean isE(char c) { return c == 'e' || c == 'E'; }

  private static String zeros(int n) {
    if (n <= 0) return "";
    char[] z = new char[n];
    java.util.Arrays.fill(z, '0');
    return new String(z);
  }

  private static int parseInt(String s) {
    if (s.isEmpty()) throw new IllegalArgumentException("An empty string is not a valid number.");
    return Integer.parseInt(s);
  }
}
