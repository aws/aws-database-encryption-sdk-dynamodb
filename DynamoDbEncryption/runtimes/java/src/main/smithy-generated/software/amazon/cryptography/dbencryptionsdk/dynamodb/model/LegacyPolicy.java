// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

public enum LegacyPolicy {
  FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT(
    "FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT"
  ),

  FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT(
    "FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT"
  ),

  FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT(
    "FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT"
  );

  private final String value;

  private LegacyPolicy(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }
}
