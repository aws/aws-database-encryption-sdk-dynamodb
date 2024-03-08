// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Outputs for encrypting a DynamoDB Item.
 */
public class EncryptItemOutput {

  /**
   * The encrypted DynamoDB item.
   */
  private final Map<String, AttributeValue> encryptedItem;

  /**
   * A parsed version of the header written with the encrypted DynamoDB item.
   */
  private final ParsedHeader parsedHeader;

  protected EncryptItemOutput(BuilderImpl builder) {
    this.encryptedItem = builder.encryptedItem();
    this.parsedHeader = builder.parsedHeader();
  }

  /**
   * @return The encrypted DynamoDB item.
   */
  public Map<String, AttributeValue> encryptedItem() {
    return this.encryptedItem;
  }

  /**
   * @return A parsed version of the header written with the encrypted DynamoDB item.
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
     * @param encryptedItem The encrypted DynamoDB item.
     */
    Builder encryptedItem(Map<String, AttributeValue> encryptedItem);

    /**
     * @return The encrypted DynamoDB item.
     */
    Map<String, AttributeValue> encryptedItem();

    /**
     * @param parsedHeader A parsed version of the header written with the encrypted DynamoDB item.
     */
    Builder parsedHeader(ParsedHeader parsedHeader);

    /**
     * @return A parsed version of the header written with the encrypted DynamoDB item.
     */
    ParsedHeader parsedHeader();

    EncryptItemOutput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, AttributeValue> encryptedItem;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptItemOutput model) {
      this.encryptedItem = model.encryptedItem();
      this.parsedHeader = model.parsedHeader();
    }

    public Builder encryptedItem(Map<String, AttributeValue> encryptedItem) {
      this.encryptedItem = encryptedItem;
      return this;
    }

    public Map<String, AttributeValue> encryptedItem() {
      return this.encryptedItem;
    }

    public Builder parsedHeader(ParsedHeader parsedHeader) {
      this.parsedHeader = parsedHeader;
      return this;
    }

    public ParsedHeader parsedHeader() {
      return this.parsedHeader;
    }

    public EncryptItemOutput build() {
      if (Objects.isNull(this.encryptedItem())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptedItem`"
        );
      }
      return new EncryptItemOutput(this);
    }
  }
}
