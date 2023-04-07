// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.itemEncryptor.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class DecryptItemOutput {
  private final Map<String, AttributeValue> plaintextItem;

  private final ParsedHeader parsedHeader;

  protected DecryptItemOutput(BuilderImpl builder) {
    this.plaintextItem = builder.plaintextItem();
    this.parsedHeader = builder.parsedHeader();
  }

  public Map<String, AttributeValue> plaintextItem() {
    return this.plaintextItem;
  }

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
    Builder plaintextItem(Map<String, AttributeValue> plaintextItem);

    Map<String, AttributeValue> plaintextItem();

    Builder parsedHeader(ParsedHeader parsedHeader);

    ParsedHeader parsedHeader();

    DecryptItemOutput build();
  }

  static class BuilderImpl implements Builder {
    protected Map<String, AttributeValue> plaintextItem;

    protected ParsedHeader parsedHeader;

    protected BuilderImpl() {
    }

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
      if (Objects.isNull(this.plaintextItem()))  {
        throw new IllegalArgumentException("Missing value for required field `plaintextItem`");
      }
      return new DecryptItemOutput(this);
    }
  }
}
