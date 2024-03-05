// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Outputs for decrypting a DynamoDB Item.
 */
public class DecryptItemOutput {

  /**
   * The decrypted DynamoDB item.
   */
  private final Map<String, AttributeValue> plaintextItem;

  /**
   * A parsed version of the header on the encrypted DynamoDB item.
   */
  private final ParsedHeader parsedHeader;

  protected DecryptItemOutput(BuilderImpl builder) {
    this.plaintextItem = builder.plaintextItem();
    this.parsedHeader = builder.parsedHeader();
  }

  /**
   * @return The decrypted DynamoDB item.
   */
  public Map<String, AttributeValue> plaintextItem() {
    return this.plaintextItem;
  }

  /**
   * @return A parsed version of the header on the encrypted DynamoDB item.
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
     * @param plaintextItem The decrypted DynamoDB item.
     */
    Builder plaintextItem(Map<String, AttributeValue> plaintextItem);

    /**
     * @return The decrypted DynamoDB item.
     */
    Map<String, AttributeValue> plaintextItem();

    /**
     * @param parsedHeader A parsed version of the header on the encrypted DynamoDB item.
     */
    Builder parsedHeader(ParsedHeader parsedHeader);

    /**
     * @return A parsed version of the header on the encrypted DynamoDB item.
     */
    ParsedHeader parsedHeader();

    DecryptItemOutput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, AttributeValue> plaintextItem;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {}

    protected BuilderImpl(DecryptItemOutput model) {
      this.plaintextItem = model.plaintextItem();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder plaintextItem(Map<String, AttributeValue> plaintextItem) {
      this.plaintextItem = plaintextItem;
      return this;
    }

    public Map<String, AttributeValue> plaintextItem() {
      return this.plaintextItem;
    }

    public Builder parsedHeader(ParsedHeader parsedHeader) {
      this.parsedHeader = parsedHeader;
      return this;
    }

    public ParsedHeader parsedHeader() {
      return this.parsedHeader;
    }

    public DecryptItemOutput build() {
      if (Objects.isNull(this.plaintextItem())) {
        throw new IllegalArgumentException(
          "Missing value for required field `plaintextItem`"
        );
      }
      return new DecryptItemOutput(this);
    }
  }
}
