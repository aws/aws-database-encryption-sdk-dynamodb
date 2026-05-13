// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * A part of a Compound Beacon that contains a beacon over encrypted data.
 */
public class EncryptedPart {

  /**
   * The name of the Standard Beacon, whose value this Part will hold.
   */
  private final String name;

  /**
   * The prefix that is written with this Encrypted Part.
   */
  private final String prefix;

  protected EncryptedPart(BuilderImpl builder) {
    this.name = builder.name();
    this.prefix = builder.prefix();
  }

  /**
   * @return The name of the Standard Beacon, whose value this Part will hold.
   */
  public String name() {
    return this.name;
  }

  /**
   * @return The prefix that is written with this Encrypted Part.
   */
  public String prefix() {
    return this.prefix;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param name The name of the Standard Beacon, whose value this Part will hold.
     */
    Builder name(String name);

    /**
     * @return The name of the Standard Beacon, whose value this Part will hold.
     */
    String name();

    /**
     * @param prefix The prefix that is written with this Encrypted Part.
     */
    Builder prefix(String prefix);

    /**
     * @return The prefix that is written with this Encrypted Part.
     */
    String prefix();

    EncryptedPart build();
  }

  static class BuilderImpl implements Builder {

    protected String name;

    protected String prefix;

    protected BuilderImpl() {}

    protected BuilderImpl(EncryptedPart model) {
      this.name = model.name();
      this.prefix = model.prefix();
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

    public EncryptedPart build() {
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
      return new EncryptedPart(this);
    }
  }
}
