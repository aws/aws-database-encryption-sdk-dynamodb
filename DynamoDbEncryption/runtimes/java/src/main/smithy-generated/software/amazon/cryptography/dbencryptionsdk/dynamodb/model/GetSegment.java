// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * The Virtual Part Transformation that splits a string and gets a particular segment of that split.
 */
public class GetSegment {

  /**
   * The characters to split on.
   */
  private final String split;

  /**
   * The index of the split string result to return. 0 represents the segment before the first split character. -1 represents the segment after the last split character.
   */
  private final Integer index;

  protected GetSegment(BuilderImpl builder) {
    this.split = builder.split();
    this.index = builder.index();
  }

  /**
   * @return The characters to split on.
   */
  public String split() {
    return this.split;
  }

  /**
   * @return The index of the split string result to return. 0 represents the segment before the first split character. -1 represents the segment after the last split character.
   */
  public Integer index() {
    return this.index;
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
     * @param index The index of the split string result to return. 0 represents the segment before the first split character. -1 represents the segment after the last split character.
     */
    Builder index(Integer index);

    /**
     * @return The index of the split string result to return. 0 represents the segment before the first split character. -1 represents the segment after the last split character.
     */
    Integer index();

    GetSegment build();
  }

  static class BuilderImpl implements Builder {

    protected String split;

    protected Integer index;

    protected BuilderImpl() {}

    protected BuilderImpl(GetSegment model) {
      this.split = model.split();
      this.index = model.index();
    }

    public Builder split(String split) {
      this.split = split;
      return this;
    }

    public String split() {
      return this.split;
    }

    public Builder index(Integer index) {
      this.index = index;
      return this;
    }

    public Integer index() {
      return this.index;
    }

    public GetSegment build() {
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
      if (Objects.isNull(this.index())) {
        throw new IllegalArgumentException(
          "Missing value for required field `index`"
        );
      }
      return new GetSegment(this);
    }
  }
}
