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
  private final int length;

  /**
   * The DynamoDB document path to the value this beacon will calculate over. If not specified, the beacon will calculate values for the attribute with the name specified in 'name'.
   */
  private final String loc;

  /**
   * Optional augmented behavior.
   */
  private final BeaconStyle style;

  /**
   * The number of separate buckets across which this particular beacon should be divided. Ths must be no greater than the global numberOfBuckets, and can never be changed once an item containing this beacon has been written.
   */
  private final int numberOfBuckets;

  protected StandardBeacon(BuilderImpl builder) {
    this.name = builder.name();
    this.length = builder.length();
    this.loc = builder.loc();
    this.style = builder.style();
    this.numberOfBuckets = builder.numberOfBuckets();
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
  public int length() {
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

  /**
   * @return The number of separate buckets across which this particular beacon should be divided. Ths must be no greater than the global numberOfBuckets, and can never be changed once an item containing this beacon has been written.
   */
  public int numberOfBuckets() {
    return this.numberOfBuckets;
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
    Builder length(int length);

    /**
     * @return The length of the calculated beacon.
     */
    int length();

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

    /**
     * @param numberOfBuckets The number of separate buckets across which this particular beacon should be divided. Ths must be no greater than the global numberOfBuckets, and can never be changed once an item containing this beacon has been written.
     */
    Builder numberOfBuckets(int numberOfBuckets);

    /**
     * @return The number of separate buckets across which this particular beacon should be divided. Ths must be no greater than the global numberOfBuckets, and can never be changed once an item containing this beacon has been written.
     */
    int numberOfBuckets();

    StandardBeacon build();
  }

  static class BuilderImpl implements Builder {

    protected String name;

    protected int length;

    private boolean _lengthSet = false;

    protected String loc;

    protected BeaconStyle style;

    protected int numberOfBuckets;

    private boolean _numberOfBucketsSet = false;

    protected BuilderImpl() {}

    protected BuilderImpl(StandardBeacon model) {
      this.name = model.name();
      this.length = model.length();
      this._lengthSet = true;
      this.loc = model.loc();
      this.style = model.style();
      this.numberOfBuckets = model.numberOfBuckets();
      this._numberOfBucketsSet = true;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder length(int length) {
      this.length = length;
      this._lengthSet = true;
      return this;
    }

    public int length() {
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

    public Builder numberOfBuckets(int numberOfBuckets) {
      this.numberOfBuckets = numberOfBuckets;
      this._numberOfBucketsSet = true;
      return this;
    }

    public int numberOfBuckets() {
      return this.numberOfBuckets;
    }

    public StandardBeacon build() {
      if (Objects.isNull(this.name())) {
        throw new IllegalArgumentException(
          "Missing value for required field `name`"
        );
      }
      if (!this._lengthSet) {
        throw new IllegalArgumentException(
          "Missing value for required field `length`"
        );
      }
      if (this._lengthSet && this.length() < 1) {
        throw new IllegalArgumentException(
          "`length` must be greater than or equal to 1"
        );
      }
      if (this._lengthSet && this.length() > 63) {
        throw new IllegalArgumentException(
          "`length` must be less than or equal to 63."
        );
      }
      if (Objects.nonNull(this.loc()) && this.loc().length() < 1) {
        throw new IllegalArgumentException(
          "The size of `loc` must be greater than or equal to 1"
        );
      }
      if (this._numberOfBucketsSet && this.numberOfBuckets() < 1) {
        throw new IllegalArgumentException(
          "`numberOfBuckets` must be greater than or equal to 1"
        );
      }
      return new StandardBeacon(this);
    }
  }
}
