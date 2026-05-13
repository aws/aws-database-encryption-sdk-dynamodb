// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

public enum AuthenticateAction {
  SIGN("SIGN"),

  DO_NOT_SIGN("DO_NOT_SIGN");

  private final String value;

  private AuthenticateAction(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }
}
