// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;

/**
 * The configuration for a Virtual Field. A Virtual Field is a field constructed from parts of other fields for use with beacons, but never itself stored on items.
 */
public class VirtualField {

  /**
   * The name of the Virtual Field.
   */
  private final String name;

  /**
   * The list of ordered parts that make up a Virtual Field.
   */
  private final List<VirtualPart> parts;

  protected VirtualField(BuilderImpl builder) {
    this.name = builder.name();
    this.parts = builder.parts();
  }

  /**
   * @return The name of the Virtual Field.
   */
  public String name() {
    return this.name;
  }

  /**
   * @return The list of ordered parts that make up a Virtual Field.
   */
  public List<VirtualPart> parts() {
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
     * @param name The name of the Virtual Field.
     */
    Builder name(String name);

    /**
     * @return The name of the Virtual Field.
     */
    String name();

    /**
     * @param parts The list of ordered parts that make up a Virtual Field.
     */
    Builder parts(List<VirtualPart> parts);

    /**
     * @return The list of ordered parts that make up a Virtual Field.
     */
    List<VirtualPart> parts();

    VirtualField build();
  }

  static class BuilderImpl implements Builder {

    protected String name;

    protected List<VirtualPart> parts;

    protected BuilderImpl() {}

    protected BuilderImpl(VirtualField model) {
      this.name = model.name();
      this.parts = model.parts();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder parts(List<VirtualPart> parts) {
      this.parts = parts;
      return this;
    }

    public List<VirtualPart> parts() {
      return this.parts;
    }

    public VirtualField build() {
      if (Objects.isNull(this.name())) {
        throw new IllegalArgumentException(
          "Missing value for required field `name`"
        );
      }
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
      return new VirtualField(this);
    }
  }
}
