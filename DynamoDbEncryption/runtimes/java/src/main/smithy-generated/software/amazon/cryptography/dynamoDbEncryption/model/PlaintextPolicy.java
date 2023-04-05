// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

public enum PlaintextPolicy {
  REQUIRE_WRITE_ALLOW_READ("REQUIRE_WRITE_ALLOW_READ"),

  FORBID_WRITE_ALLOW_READ("FORBID_WRITE_ALLOW_READ"),

  FORBID_WRITE_FORBID_READ("FORBID_WRITE_FORBID_READ");

  private final String value;

  private PlaintextPolicy(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }
}
