// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

public enum Transform {
  LOWER("Lower"),

  UPPER("Upper"),

  INSERT("Insert"),

  PREFIX("Prefix"),

  SUFFIX("Suffix"),

  SUBSTRING("Substring"),

  SEGMENT("Segment");

  private final String value;

  private Transform(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }
}
