// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;

public class PermuteDecryptInput {
  /**
   * Inputs for decrypting a DynamoDB Item.
   */
  private final DecryptItemInput inner;

  private final Integer maxSetSize;

  protected PermuteDecryptInput(BuilderImpl builder) {
    this.inner = builder.inner();
    this.maxSetSize = builder.maxSetSize();
  }

  /**
   * @return Inputs for decrypting a DynamoDB Item.
   */
  public DecryptItemInput inner() {
    return this.inner;
  }

  public Integer maxSetSize() {
    return this.maxSetSize;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param inner Inputs for decrypting a DynamoDB Item.
     */
    Builder inner(DecryptItemInput inner);

    /**
     * @return Inputs for decrypting a DynamoDB Item.
     */
    DecryptItemInput inner();

    Builder maxSetSize(Integer maxSetSize);

    Integer maxSetSize();

    PermuteDecryptInput build();
  }

  static class BuilderImpl implements Builder {
    protected DecryptItemInput inner;

    protected Integer maxSetSize;

    protected BuilderImpl() {
    }

    protected BuilderImpl(PermuteDecryptInput model) {
      this.inner = model.inner();
      this.maxSetSize = model.maxSetSize();
    }

    public Builder inner(DecryptItemInput inner) {
      this.inner = inner;
      return this;
    }

    public DecryptItemInput inner() {
      return this.inner;
    }

    public Builder maxSetSize(Integer maxSetSize) {
      this.maxSetSize = maxSetSize;
      return this;
    }

    public Integer maxSetSize() {
      return this.maxSetSize;
    }

    public PermuteDecryptInput build() {
      if (Objects.isNull(this.inner()))  {
        throw new IllegalArgumentException("Missing value for required field `inner`");
      }
      if (Objects.isNull(this.maxSetSize()))  {
        throw new IllegalArgumentException("Missing value for required field `maxSetSize`");
      }
      if (Objects.nonNull(this.maxSetSize()) && this.maxSetSize() < 0) {
        throw new IllegalArgumentException("`maxSetSize` must be greater than or equal to 0");
      }
      return new PermuteDecryptInput(this);
    }
  }
}
