// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;

/**
 * Inputs for decrypting a JSON object.
 */
public class DecryptObjectInput {

  /**
   * The encrypted JSON object to decrypt.
   */
  private final Json encryptedObject;

  protected DecryptObjectInput(BuilderImpl builder) {
    this.encryptedObject = builder.encryptedObject();
  }

  /**
   * @return The encrypted JSON object to decrypt.
   */
  public Json encryptedObject() {
    return this.encryptedObject;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param encryptedObject The encrypted JSON object to decrypt.
     */
    Builder encryptedObject(Json encryptedObject);

    /**
     * @return The encrypted JSON object to decrypt.
     */
    Json encryptedObject();

    DecryptObjectInput build();
  }

  static class BuilderImpl implements Builder {

    protected Json encryptedObject;

    protected BuilderImpl() {}

    protected BuilderImpl(DecryptObjectInput model) {
      this.encryptedObject = model.encryptedObject();
    }

    public Builder encryptedObject(Json encryptedObject) {
      this.encryptedObject = encryptedObject;
      return this;
    }

    public Json encryptedObject() {
      return this.encryptedObject;
    }

    public DecryptObjectInput build() {
      if (Objects.isNull(this.encryptedObject())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptedObject`"
        );
      }
      return new DecryptObjectInput(this);
    }
  }
}