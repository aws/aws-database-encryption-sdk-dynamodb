// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * The Virtual Part Transformation that gets a substring from a string.
 */
public class GetSubstring {

  /**
   * The index to start the substring from, inclusive. Negative numbers count from the end. -1 is the last character of a string.
   */
  private final Integer low;

  /**
   * The index to stop the substring at, exclusive. Negative numbers count from the end. -1 is the last character of a string.
   */
  private final Integer high;

  protected GetSubstring(BuilderImpl builder) {
    this.low = builder.low();
    this.high = builder.high();
  }

  /**
   * @return The index to start the substring from, inclusive. Negative numbers count from the end. -1 is the last character of a string.
   */
  public Integer low() {
    return this.low;
  }

  /**
   * @return The index to stop the substring at, exclusive. Negative numbers count from the end. -1 is the last character of a string.
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
     * @param low The index to start the substring from, inclusive. Negative numbers count from the end. -1 is the last character of a string.
     */
    Builder low(Integer low);

    /**
     * @return The index to start the substring from, inclusive. Negative numbers count from the end. -1 is the last character of a string.
     */
    Integer low();

    /**
     * @param high The index to stop the substring at, exclusive. Negative numbers count from the end. -1 is the last character of a string.
     */
    Builder high(Integer high);

    /**
     * @return The index to stop the substring at, exclusive. Negative numbers count from the end. -1 is the last character of a string.
     */
    Integer high();

    GetSubstring build();
  }

  static class BuilderImpl implements Builder {

    protected Integer low;

    protected Integer high;

    protected BuilderImpl() {}

    protected BuilderImpl(GetSubstring model) {
      this.low = model.low();
      this.high = model.high();
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

    public GetSubstring build() {
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
      return new GetSubstring(this);
    }
  }
}
