// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class GetEncryptedDataKeyDescriptionUnion {

  /**
   * A binary header value.
   */
  private final ByteBuffer header;

  /**
   * A DynamoDB item.
   */
  private final Map<String, AttributeValue> item;

  protected GetEncryptedDataKeyDescriptionUnion(BuilderImpl builder) {
    this.header = builder.header();
    this.item = builder.item();
  }

  /**
   * @return A binary header value.
   */
  public ByteBuffer header() {
    return this.header;
  }

  /**
   * @return A DynamoDB item.
   */
  public Map<String, AttributeValue> item() {
    return this.item;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param header A binary header value.
     */
    Builder header(ByteBuffer header);

    /**
     * @return A binary header value.
     */
    ByteBuffer header();

    /**
     * @param item A DynamoDB item.
     */
    Builder item(Map<String, AttributeValue> item);

    /**
     * @return A DynamoDB item.
     */
    Map<String, AttributeValue> item();

    GetEncryptedDataKeyDescriptionUnion build();
  }

  static class BuilderImpl implements Builder {

    protected ByteBuffer header;

    protected Map<String, AttributeValue> item;

    protected BuilderImpl() {}

    protected BuilderImpl(GetEncryptedDataKeyDescriptionUnion model) {
      this.header = model.header();
      this.item = model.item();
    }

    public Builder header(ByteBuffer header) {
      this.header = header;
      return this;
    }

    public ByteBuffer header() {
      return this.header;
    }

    public Builder item(Map<String, AttributeValue> item) {
      this.item = item;
      return this;
    }

    public Map<String, AttributeValue> item() {
      return this.item;
    }

    public GetEncryptedDataKeyDescriptionUnion build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException(
          "`GetEncryptedDataKeyDescriptionUnion` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new GetEncryptedDataKeyDescriptionUnion(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = { this.header, this.item };
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
