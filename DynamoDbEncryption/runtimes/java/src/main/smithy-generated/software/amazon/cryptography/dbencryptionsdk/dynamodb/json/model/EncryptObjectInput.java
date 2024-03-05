// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;

/**
 * Inputs for encrypting a JSON object.
 */
public class EncryptObjectInput {

  /**
   * The JSON object to encrypt.
   */
  private final Json plaintextObject;

  protected EncryptObjectInput(BuilderImpl builder) {
    this.plaintextObject = builder.plaintextObject();
  }

  /**
   * @return The JSON object to encrypt.
   */
  public Json plaintextObject() {
    return this.plaintextObject;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param plaintextObject The JSON object to encrypt.
     */
    Builder plaintextObject(Json plaintextObject);

    /**
     * @return The JSON object to encrypt.
     */
    Json plaintextObject();

    EncryptObjectInput build();
  }

  static class BuilderImpl implements Builder {

    protected Json plaintextObject;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptObjectInput model) {
      this.plaintextObject = model.plaintextObject();
    }

    public Builder plaintextObject(Json plaintextObject) {
      this.plaintextObject = plaintextObject;
      return this;
    }

    public Json plaintextObject() {
      return this.plaintextObject;
    }

    public EncryptObjectInput build() {
      if (Objects.isNull(this.plaintextObject())) {
        throw new IllegalArgumentException(
          "Missing value for required field `plaintextObject`"
        );
      }
      return new EncryptObjectInput(this);
    }
  }
}
