// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;

/**
 * The configuration for a particular Compound Beacon construction.
 */
public class Constructor {

  /**
   * The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
   */
  private final List<ConstructorPart> parts;

  protected Constructor(BuilderImpl builder) {
    this.parts = builder.parts();
  }

  /**
   * @return The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
   */
  public List<ConstructorPart> parts() {
    return this.parts;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param parts The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
     */
    Builder parts(List<ConstructorPart> parts);

    /**
     * @return The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
     */
    List<ConstructorPart> parts();

    Constructor build();
  }

  static class BuilderImpl implements Builder {

    protected List<ConstructorPart> parts;

    protected BuilderImpl() {}

    protected BuilderImpl(Constructor model) {
      this.parts = model.parts();
    }

    public Builder parts(List<ConstructorPart> parts) {
      this.parts = parts;
      return this;
    }

    public List<ConstructorPart> parts() {
      return this.parts;
    }

    public Constructor build() {
      if (Objects.isNull(this.parts())) {
        throw new IllegalArgumentException(
          "Missing value for required field `parts`"
        );
      }
      if (Objects.nonNull(this.parts()) && this.parts().size() < 1) {
        throw new IllegalArgumentException(
          "The size of `parts` must be greater than or equal to 1"
        );
      }
      return new Constructor(this);
    }
  }
}
