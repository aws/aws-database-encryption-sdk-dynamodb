// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;

/**
 * Outputs for decrypting a JSON object.
 */
public class DecryptObjectOutput {
  /**
   * The decrypted JSON object.
   */
  private final String plaintextObject;

  /**
   * A parsed version of the header on the encrypted JSON object.
   */
  private final ParsedHeader parsedHeader;

  protected DecryptObjectOutput(BuilderImpl builder) {
    this.plaintextObject = builder.plaintextObject();
    this.parsedHeader = builder.parsedHeader();
  }

  /**
   * @return The decrypted JSON object.
   */
  public String plaintextObject() {
    return this.plaintextObject;
  }

  /**
   * @return A parsed version of the header on the encrypted JSON object.
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
     * @param plaintextObject The decrypted JSON object.
     */
    Builder plaintextObject(String plaintextObject);

    /**
     * @return The decrypted JSON object.
     */
    String plaintextObject();

    /**
     * @param parsedHeader A parsed version of the header on the encrypted JSON object.
     */
    Builder parsedHeader(ParsedHeader parsedHeader);

    /**
     * @return A parsed version of the header on the encrypted JSON object.
     */
    ParsedHeader parsedHeader();

    DecryptObjectOutput build();
  }

  static class BuilderImpl implements Builder {
    protected String plaintextObject;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DecryptObjectOutput model) {
      this.plaintextObject = model.plaintextObject();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder plaintextObject(String plaintextObject) {
      this.plaintextObject = plaintextObject;
      return this;
    }

    public String plaintextObject() {
      return this.plaintextObject;
    }

    public Builder parsedHeader(ParsedHeader parsedHeader) {
      this.parsedHeader = parsedHeader;
      return this;
    }

    public ParsedHeader parsedHeader() {
      return this.parsedHeader;
    }

    public DecryptObjectOutput build() {
      if (Objects.isNull(this.plaintextObject()))  {
        throw new IllegalArgumentException("Missing value for required field `plaintextObject`");
      }
      return new DecryptObjectOutput(this);
    }
  }
}
