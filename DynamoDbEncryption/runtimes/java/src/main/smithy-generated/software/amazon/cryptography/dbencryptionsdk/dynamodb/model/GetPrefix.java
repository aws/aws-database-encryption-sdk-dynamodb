// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * The Virtual Part Transformation that gets the prefix of a string.
 */
public class GetPrefix {

  /**
   * If positive, the number of characters to return from the front. If negative, the absolute number of characters to exclude from the end. e.g. GetPrefix(-1) returns all but the last character.
   */
  private final Integer length;

  protected GetPrefix(BuilderImpl builder) {
    this.length = builder.length();
  }

  /**
   * @return If positive, the number of characters to return from the front. If negative, the absolute number of characters to exclude from the end. e.g. GetPrefix(-1) returns all but the last character.
   */
  public Integer length() {
    return this.length;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param length If positive, the number of characters to return from the front. If negative, the absolute number of characters to exclude from the end. e.g. GetPrefix(-1) returns all but the last character.
     */
    Builder length(Integer length);

    /**
     * @return If positive, the number of characters to return from the front. If negative, the absolute number of characters to exclude from the end. e.g. GetPrefix(-1) returns all but the last character.
     */
    Integer length();

    GetPrefix build();
  }

  static class BuilderImpl implements Builder {

    protected Integer length;

    protected BuilderImpl() {}

    protected BuilderImpl(GetPrefix model) {
      this.length = model.length();
    }

    public Builder length(Integer length) {
      this.length = length;
      return this;
    }

    public Integer length() {
      return this.length;
    }

    public GetPrefix build() {
      if (Objects.isNull(this.length())) {
        throw new IllegalArgumentException(
          "Missing value for required field `length`"
        );
      }
      return new GetPrefix(this);
    }
  }
}
