// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.model;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;

/**
 * The configuration for the client-side encryption of DynamoDB items.
 */
public class DynamoDbPermuteDecryptorConfig {
  /**
   * The configuration for the client-side encryption of DynamoDB items.
   */
  private final DynamoDbItemEncryptorConfig inner;

  protected DynamoDbPermuteDecryptorConfig(BuilderImpl builder) {
    this.inner = builder.inner();
  }

  /**
   * @return The configuration for the client-side encryption of DynamoDB items.
   */
  public DynamoDbItemEncryptorConfig inner() {
    return this.inner;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param inner The configuration for the client-side encryption of DynamoDB items.
     */
    Builder inner(DynamoDbItemEncryptorConfig inner);

    /**
     * @return The configuration for the client-side encryption of DynamoDB items.
     */
    DynamoDbItemEncryptorConfig inner();

    DynamoDbPermuteDecryptorConfig build();
  }

  static class BuilderImpl implements Builder {
    protected DynamoDbItemEncryptorConfig inner;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DynamoDbPermuteDecryptorConfig model) {
      this.inner = model.inner();
    }

    public Builder inner(DynamoDbItemEncryptorConfig inner) {
      this.inner = inner;
      return this;
    }

    public DynamoDbItemEncryptorConfig inner() {
      return this.inner;
    }

    public DynamoDbPermuteDecryptorConfig build() {
      if (Objects.isNull(this.inner()))  {
        throw new IllegalArgumentException("Missing value for required field `inner`");
      }
      return new DynamoDbPermuteDecryptorConfig(this);
    }
  }
}
