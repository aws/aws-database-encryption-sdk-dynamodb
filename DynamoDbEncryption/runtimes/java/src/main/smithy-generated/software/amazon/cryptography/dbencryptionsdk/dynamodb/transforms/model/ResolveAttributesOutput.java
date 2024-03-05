// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Map;
import java.util.Objects;

public class ResolveAttributesOutput {

  /**
   * Full plaintext of all calculable virtual fields.
   */
  private final Map<String, String> VirtualFields;

  /**
   * Full plaintext of all calculable compound beacons.
   */
  private final Map<String, String> CompoundBeacons;

  protected ResolveAttributesOutput(BuilderImpl builder) {
    this.VirtualFields = builder.VirtualFields();
    this.CompoundBeacons = builder.CompoundBeacons();
  }

  /**
   * @return Full plaintext of all calculable virtual fields.
   */
  public Map<String, String> VirtualFields() {
    return this.VirtualFields;
  }

  /**
   * @return Full plaintext of all calculable compound beacons.
   */
  public Map<String, String> CompoundBeacons() {
    return this.CompoundBeacons;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param VirtualFields Full plaintext of all calculable virtual fields.
     */
    Builder VirtualFields(Map<String, String> VirtualFields);

    /**
     * @return Full plaintext of all calculable virtual fields.
     */
    Map<String, String> VirtualFields();

    /**
     * @param CompoundBeacons Full plaintext of all calculable compound beacons.
     */
    Builder CompoundBeacons(Map<String, String> CompoundBeacons);

    /**
     * @return Full plaintext of all calculable compound beacons.
     */
    Map<String, String> CompoundBeacons();

    ResolveAttributesOutput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, String> VirtualFields;

    protected Map<String, String> CompoundBeacons;

    protected BuilderImpl() {}

    protected BuilderImpl(ResolveAttributesOutput model) {
      this.VirtualFields = model.VirtualFields();
      this.CompoundBeacons = model.CompoundBeacons();
    }

    public Builder VirtualFields(Map<String, String> VirtualFields) {
      this.VirtualFields = VirtualFields;
      return this;
    }

    public Map<String, String> VirtualFields() {
      return this.VirtualFields;
    }

    public Builder CompoundBeacons(Map<String, String> CompoundBeacons) {
      this.CompoundBeacons = CompoundBeacons;
      return this;
    }

    public Map<String, String> CompoundBeacons() {
      return this.CompoundBeacons;
    }

    public ResolveAttributesOutput build() {
      if (Objects.isNull(this.VirtualFields())) {
        throw new IllegalArgumentException(
          "Missing value for required field `VirtualFields`"
        );
      }
      if (Objects.isNull(this.CompoundBeacons())) {
        throw new IllegalArgumentException(
          "Missing value for required field `CompoundBeacons`"
        );
      }
      return new ResolveAttributesOutput(this);
    }
  }
}
