// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * The Virtual Part Transformation that appends a literal string.
 */
public class Insert {

  /**
   * The literal string to append.
   */
  private final String literal;

  protected Insert(BuilderImpl builder) {
    this.literal = builder.literal();
  }

  /**
   * @return The literal string to append.
   */
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
    /**
     * @param literal The literal string to append.
     */
    Builder literal(String literal);

    /**
     * @return The literal string to append.
     */
    String literal();

    Insert build();
  }

  static class BuilderImpl implements Builder {

    protected String literal;

    protected BuilderImpl() {}

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
      if (Objects.isNull(this.literal())) {
        throw new IllegalArgumentException(
          "Missing value for required field `literal`"
        );
      }
      return new Insert(this);
    }
  }
}
