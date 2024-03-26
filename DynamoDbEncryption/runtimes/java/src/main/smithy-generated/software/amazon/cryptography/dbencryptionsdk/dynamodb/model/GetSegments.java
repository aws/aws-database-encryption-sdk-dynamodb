// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * The Virtual Part Transformation that splits a string and gets a range of segments of that split.
 */
public class GetSegments {

  /**
   * The characters to split on.
   */
  private final String split;

  /**
   * The index to start the segments from, inclusive. Negative numbers count from the end. -1 is the last segment.
   */
  private final Integer low;

  /**
   * The index to stop the segments at, exclusive. Negative numbers count from the end. -1 is the last segment.
   */
  private final Integer high;

  protected GetSegments(BuilderImpl builder) {
    this.split = builder.split();
    this.low = builder.low();
    this.high = builder.high();
  }

  /**
   * @return The characters to split on.
   */
  public String split() {
    return this.split;
  }

  /**
   * @return The index to start the segments from, inclusive. Negative numbers count from the end. -1 is the last segment.
   */
  public Integer low() {
    return this.low;
  }

  /**
   * @return The index to stop the segments at, exclusive. Negative numbers count from the end. -1 is the last segment.
   */
  public Integer high() {
    return this.high;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param split The characters to split on.
     */
    Builder split(String split);

    /**
     * @return The characters to split on.
     */
    String split();

    /**
     * @param low The index to start the segments from, inclusive. Negative numbers count from the end. -1 is the last segment.
     */
    Builder low(Integer low);

    /**
     * @return The index to start the segments from, inclusive. Negative numbers count from the end. -1 is the last segment.
     */
    Integer low();

    /**
     * @param high The index to stop the segments at, exclusive. Negative numbers count from the end. -1 is the last segment.
     */
    Builder high(Integer high);

    /**
     * @return The index to stop the segments at, exclusive. Negative numbers count from the end. -1 is the last segment.
     */
    Integer high();

    GetSegments build();
  }

  static class BuilderImpl implements Builder {

    protected String split;

    protected Integer low;

    protected Integer high;

    protected BuilderImpl() {}

    protected BuilderImpl(GetSegments model) {
      this.split = model.split();
      this.low = model.low();
      this.high = model.high();
    }

    public Builder split(String split) {
      this.split = split;
      return this;
    }

    public String split() {
      return this.split;
    }

    public Builder low(Integer low) {
      this.low = low;
      return this;
    }

    public Integer low() {
      return this.low;
    }

    public Builder high(Integer high) {
      this.high = high;
      return this;
    }

    public Integer high() {
      return this.high;
    }

    public GetSegments build() {
      if (Objects.isNull(this.split())) {
        throw new IllegalArgumentException(
          "Missing value for required field `split`"
        );
      }
      if (Objects.nonNull(this.split()) && this.split().length() < 1) {
        throw new IllegalArgumentException(
          "The size of `split` must be greater than or equal to 1"
        );
      }
      if (Objects.nonNull(this.split()) && this.split().length() > 1) {
        throw new IllegalArgumentException(
          "The size of `split` must be less than or equal to 1"
        );
      }
      if (Objects.isNull(this.low())) {
        throw new IllegalArgumentException(
          "Missing value for required field `low`"
        );
      }
      if (Objects.isNull(this.high())) {
        throw new IllegalArgumentException(
          "Missing value for required field `high`"
        );
      }
      return new GetSegments(this);
    }
  }
}
