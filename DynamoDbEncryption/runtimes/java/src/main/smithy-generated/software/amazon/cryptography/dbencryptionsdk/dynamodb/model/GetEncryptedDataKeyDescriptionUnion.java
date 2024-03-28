// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class GetEncryptedDataKeyDescriptionUnion {
  private final ByteBuffer header;

  private final Map<String, AttributeValue> plaintextItem;

  protected GetEncryptedDataKeyDescriptionUnion(BuilderImpl builder) {
    this.header = builder.header();
    this.plaintextItem = builder.plaintextItem();
  }

  public ByteBuffer header() {
    return this.header;
  }

  public Map<String, AttributeValue> plaintextItem() {
    return this.plaintextItem;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder header(ByteBuffer header);

    ByteBuffer header();

    Builder plaintextItem(Map<String, AttributeValue> plaintextItem);

    Map<String, AttributeValue> plaintextItem();

    GetEncryptedDataKeyDescriptionUnion build();
  }

  static class BuilderImpl implements Builder {
    protected ByteBuffer header;

    protected Map<String, AttributeValue> plaintextItem;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetEncryptedDataKeyDescriptionUnion model) {
      this.header = model.header();
      this.plaintextItem = model.plaintextItem();
    }

    public Builder header(ByteBuffer header) {
      this.header = header;
      return this;
    }

    public ByteBuffer header() {
      return this.header;
    }

    public Builder plaintextItem(Map<String, AttributeValue> plaintextItem) {
      this.plaintextItem = plaintextItem;
      return this;
    }

    public Map<String, AttributeValue> plaintextItem() {
      return this.plaintextItem;
    }

    public GetEncryptedDataKeyDescriptionUnion build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException("`GetEncryptedDataKeyDescriptionUnion` is a Union. A Union MUST have one and only one value set.");
      }
      return new GetEncryptedDataKeyDescriptionUnion(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = {this.header, this.plaintextItem};
      boolean haveOneNonNull = false;
      for (Object o : allValues) {
        if (Objects.nonNull(o)) {
          if (haveOneNonNull) {
            return false;
          }
          haveOneNonNull = true;
        }
      }
      return haveOneNonNull;
    }
  }
}
