// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class Insert {
  private final String literal;

  protected Insert(BuilderImpl builder) {
    this.literal = builder.literal();
  }

  public String literal() {
    return this.literal;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder literal(String literal);

    String literal();

    Insert build();
  }

  static class BuilderImpl implements Builder {
    protected String literal;

    protected BuilderImpl() {
    }

    protected BuilderImpl(Insert model) {
      this.literal = model.literal();
    }

    public Builder literal(String literal) {
      this.literal = literal;
      return this;
    }

    public String literal() {
      return this.literal;
    }

    public Insert build() {
      if (Objects.isNull(this.literal()))  {
        throw new IllegalArgumentException("Missing value for required field `literal`");
      }
      return new Insert(this);
    }
  }
}
