// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * The configuration for a Standard Beacon.
 */
public class StandardBeacon {

  /**
   * The name for this Standard Beacon.
   */
  private final String name;

  /**
   * The length of the calculated beacon.
   */
  private final Integer length;

  /**
   * The DynamoDB document path to the value this beacon will calculate over. If not specified, the beacon will calculate values for the attribute with the name specified in 'name'.
   */
  private final String loc;

  /**
   * Optional augmented behavior.
   */
  private final BeaconStyle style;

  protected StandardBeacon(BuilderImpl builder) {
    this.name = builder.name();
    this.length = builder.length();
    this.loc = builder.loc();
    this.style = builder.style();
  }

  /**
   * @return The name for this Standard Beacon.
   */
  public String name() {
    return this.name;
  }

  /**
   * @return The length of the calculated beacon.
   */
  public Integer length() {
    return this.length;
  }

  /**
   * @return The DynamoDB document path to the value this beacon will calculate over. If not specified, the beacon will calculate values for the attribute with the name specified in 'name'.
   */
  public String loc() {
    return this.loc;
  }

  /**
   * @return Optional augmented behavior.
   */
  public BeaconStyle style() {
    return this.style;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param name The name for this Standard Beacon.
     */
    Builder name(String name);

    /**
     * @return The name for this Standard Beacon.
     */
    String name();

    /**
     * @param length The length of the calculated beacon.
     */
    Builder length(Integer length);

    /**
     * @return The length of the calculated beacon.
     */
    Integer length();

    /**
     * @param loc The DynamoDB document path to the value this beacon will calculate over. If not specified, the beacon will calculate values for the attribute with the name specified in 'name'.
     */
    Builder loc(String loc);

    /**
     * @return The DynamoDB document path to the value this beacon will calculate over. If not specified, the beacon will calculate values for the attribute with the name specified in 'name'.
     */
    String loc();

    /**
     * @param style Optional augmented behavior.
     */
    Builder style(BeaconStyle style);

    /**
     * @return Optional augmented behavior.
     */
    BeaconStyle style();

    StandardBeacon build();
  }

  static class BuilderImpl implements Builder {

    protected String name;

    protected Integer length;

    protected String loc;

    protected BeaconStyle style;

    protected BuilderImpl() {}

    protected BuilderImpl(StandardBeacon model) {
      this.name = model.name();
      this.length = model.length();
      this.loc = model.loc();
      this.style = model.style();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder length(Integer length) {
      this.length = length;
      return this;
    }

    public Integer length() {
      return this.length;
    }

    public Builder loc(String loc) {
      this.loc = loc;
      return this;
    }

    public String loc() {
      return this.loc;
    }

    public Builder style(BeaconStyle style) {
      this.style = style;
      return this;
    }

    public BeaconStyle style() {
      return this.style;
    }

    public StandardBeacon build() {
      if (Objects.isNull(this.name())) {
        throw new IllegalArgumentException(
          "Missing value for required field `name`"
        );
      }
      if (Objects.isNull(this.length())) {
        throw new IllegalArgumentException(
          "Missing value for required field `length`"
        );
      }
      if (Objects.nonNull(this.length()) && this.length() < 1) {
        throw new IllegalArgumentException(
          "`length` must be greater than or equal to 1"
        );
      }
      if (Objects.nonNull(this.length()) && this.length() > 63) {
        throw new IllegalArgumentException(
          "`length` must be less than or equal to 63."
        );
      }
      if (Objects.nonNull(this.loc()) && this.loc().length() < 1) {
        throw new IllegalArgumentException(
          "The size of `loc` must be greater than or equal to 1"
        );
      }
      return new StandardBeacon(this);
    }
  }
}
