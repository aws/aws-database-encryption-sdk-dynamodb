// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * A part of a Compound Beacon that contains signed plaintext data.
 */
public class SignedPart {

  /**
   * The name for this Signed Part.
   */
  private final String name;

  /**
   * The prefix that is written with this Signed Part.
   */
  private final String prefix;

  /**
   * The DynamoDB document path to the value for this Signed Part. If not provided, the 'name' is used for the location.
   */
  private final String loc;

  protected SignedPart(BuilderImpl builder) {
    this.name = builder.name();
    this.prefix = builder.prefix();
    this.loc = builder.loc();
  }

  /**
   * @return The name for this Signed Part.
   */
  public String name() {
    return this.name;
  }

  /**
   * @return The prefix that is written with this Signed Part.
   */
  public String prefix() {
    return this.prefix;
  }

  /**
   * @return The DynamoDB document path to the value for this Signed Part. If not provided, the 'name' is used for the location.
   */
  public String loc() {
    return this.loc;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param name The name for this Signed Part.
     */
    Builder name(String name);

    /**
     * @return The name for this Signed Part.
     */
    String name();

    /**
     * @param prefix The prefix that is written with this Signed Part.
     */
    Builder prefix(String prefix);

    /**
     * @return The prefix that is written with this Signed Part.
     */
    String prefix();

    /**
     * @param loc The DynamoDB document path to the value for this Signed Part. If not provided, the 'name' is used for the location.
     */
    Builder loc(String loc);

    /**
     * @return The DynamoDB document path to the value for this Signed Part. If not provided, the 'name' is used for the location.
     */
    String loc();

    SignedPart build();
  }

  static class BuilderImpl implements Builder {

    protected String name;

    protected String prefix;

    protected String loc;

    protected BuilderImpl() {}

    protected BuilderImpl(SignedPart model) {
      this.name = model.name();
      this.prefix = model.prefix();
      this.loc = model.loc();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder prefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    public String prefix() {
      return this.prefix;
    }

    public Builder loc(String loc) {
      this.loc = loc;
      return this;
    }

    public String loc() {
      return this.loc;
    }

    public SignedPart build() {
      if (Objects.isNull(this.name())) {
        throw new IllegalArgumentException(
          "Missing value for required field `name`"
        );
      }
      if (Objects.isNull(this.prefix())) {
        throw new IllegalArgumentException(
          "Missing value for required field `prefix`"
        );
      }
      if (Objects.nonNull(this.prefix()) && this.prefix().length() < 1) {
        throw new IllegalArgumentException(
          "The size of `prefix` must be greater than or equal to 1"
        );
      }
      if (Objects.nonNull(this.loc()) && this.loc().length() < 1) {
        throw new IllegalArgumentException(
          "The size of `loc` must be greater than or equal to 1"
        );
      }
      return new SignedPart(this);
    }
  }
}
