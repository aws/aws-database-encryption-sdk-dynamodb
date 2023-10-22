// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;

/**
 * Outputs for decrypting a DynamoDB Item.
 */
public class PermuteDecryptOutput {
  /**
   * Outputs for decrypting a DynamoDB Item.
   */
  private final DecryptItemOutput inner;

  private final Boolean didPermute;

  protected PermuteDecryptOutput(BuilderImpl builder) {
    this.inner = builder.inner();
    this.didPermute = builder.didPermute();
  }

  /**
   * @return Outputs for decrypting a DynamoDB Item.
   */
  public DecryptItemOutput inner() {
    return this.inner;
  }

  public Boolean didPermute() {
    return this.didPermute;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param inner Outputs for decrypting a DynamoDB Item.
     */
    Builder inner(DecryptItemOutput inner);

    /**
     * @return Outputs for decrypting a DynamoDB Item.
     */
    DecryptItemOutput inner();

    Builder didPermute(Boolean didPermute);

    Boolean didPermute();

    PermuteDecryptOutput build();
  }

  static class BuilderImpl implements Builder {
    protected DecryptItemOutput inner;

    protected Boolean didPermute;

    protected BuilderImpl() {
    }

    protected BuilderImpl(PermuteDecryptOutput model) {
      this.inner = model.inner();
      this.didPermute = model.didPermute();
    }

    public Builder inner(DecryptItemOutput inner) {
      this.inner = inner;
      return this;
    }

    public DecryptItemOutput inner() {
      return this.inner;
    }

    public Builder didPermute(Boolean didPermute) {
      this.didPermute = didPermute;
      return this;
    }

    public Boolean didPermute() {
      return this.didPermute;
    }

    public PermuteDecryptOutput build() {
      if (Objects.isNull(this.inner()))  {
        throw new IllegalArgumentException("Missing value for required field `inner`");
      }
      if (Objects.isNull(this.didPermute()))  {
        throw new IllegalArgumentException("Missing value for required field `didPermute`");
      }
      return new PermuteDecryptOutput(this);
    }
  }
}
