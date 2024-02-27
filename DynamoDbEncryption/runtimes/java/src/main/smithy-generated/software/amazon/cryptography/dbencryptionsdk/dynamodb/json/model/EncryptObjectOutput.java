// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;

/**
 * Outputs for encrypting a JSON object.
 */
public class EncryptObjectOutput {

  /**
   * The encrypted JSON object.
   */
  private final Json encryptedObject;

  /**
   * A parsed version of the header written with the encrypted JSON object.
   */
  private final ParsedHeader parsedHeader;

  protected EncryptObjectOutput(BuilderImpl builder) {
    this.encryptedObject = builder.encryptedObject();
    this.parsedHeader = builder.parsedHeader();
  }

  /**
   * @return The encrypted JSON object.
   */
  public Json encryptedObject() {
    return this.encryptedObject;
  }

  /**
   * @return A parsed version of the header written with the encrypted JSON object.
   */
  public ParsedHeader parsedHeader() {
    return this.parsedHeader;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param encryptedObject The encrypted JSON object.
     */
    Builder encryptedObject(Json encryptedObject);

    /**
     * @return The encrypted JSON object.
     */
    Json encryptedObject();

    /**
     * @param parsedHeader A parsed version of the header written with the encrypted JSON object.
     */
    Builder parsedHeader(ParsedHeader parsedHeader);

    /**
     * @return A parsed version of the header written with the encrypted JSON object.
     */
    ParsedHeader parsedHeader();

    EncryptObjectOutput build();
  }

  static class BuilderImpl implements Builder {

    protected Json encryptedObject;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptObjectOutput model) {
      this.encryptedObject = model.encryptedObject();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder encryptedObject(Json encryptedObject) {
      this.encryptedObject = encryptedObject;
      return this;
    }

    public Json encryptedObject() {
      return this.encryptedObject;
    }

    public Builder parsedHeader(ParsedHeader parsedHeader) {
      this.parsedHeader = parsedHeader;
      return this;
    }

    public ParsedHeader parsedHeader() {
      return this.parsedHeader;
    }

    public EncryptObjectOutput build() {
      if (Objects.isNull(this.encryptedObject())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptedObject`"
        );
      }
      return new EncryptObjectOutput(this);
    }
  }
}
