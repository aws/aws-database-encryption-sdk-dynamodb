// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class GetSegment {
  private final String split;

  private final Integer low;

  private final Integer high;

  protected GetSegment(BuilderImpl builder) {
    this.split = builder.split();
    this.low = builder.low();
    this.high = builder.high();
  }

  public String split() {
    return this.split;
  }

  public Integer low() {
    return this.low;
  }

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
    Builder split(String split);

    String split();

    Builder low(Integer low);

    Integer low();

    Builder high(Integer high);

    Integer high();

    GetSegment build();
  }

  static class BuilderImpl implements Builder {
    protected String split;

    protected Integer low;

    protected Integer high;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetSegment model) {
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

    public GetSegment build() {
      if (Objects.isNull(this.split()))  {
        throw new IllegalArgumentException("Missing value for required field `split`");
      }
      if (Objects.nonNull(this.split()) && this.split().length() < 1) {
        throw new IllegalArgumentException("The size of `split` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.split()) && this.split().length() > 1) {
        throw new IllegalArgumentException("The size of `split` must be less than or equal to 1");
      }
      if (Objects.isNull(this.low()))  {
        throw new IllegalArgumentException("Missing value for required field `low`");
      }
      return new GetSegment(this);
    }
  }
}
