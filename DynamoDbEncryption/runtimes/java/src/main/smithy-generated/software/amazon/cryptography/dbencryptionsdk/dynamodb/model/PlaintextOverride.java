// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

public enum PlaintextOverride {
  FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ(
    "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ"
  ),

  FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ(
    "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ"
  ),

  FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ(
    "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ"
  );

  private final String value;

  private PlaintextOverride(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }
}
