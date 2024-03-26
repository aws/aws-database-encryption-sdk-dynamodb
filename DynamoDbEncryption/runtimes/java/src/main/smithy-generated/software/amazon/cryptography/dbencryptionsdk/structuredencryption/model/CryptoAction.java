// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

public enum CryptoAction {
  ENCRYPT_AND_SIGN("ENCRYPT_AND_SIGN"),

  SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT(
    "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"
  ),

  SIGN_ONLY("SIGN_ONLY"),

  DO_NOTHING("DO_NOTHING");

  private final String value;

  private CryptoAction(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }
}
