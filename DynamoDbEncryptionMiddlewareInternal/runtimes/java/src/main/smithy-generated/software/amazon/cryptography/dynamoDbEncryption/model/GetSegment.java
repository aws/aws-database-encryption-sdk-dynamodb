// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class GetSegment {
  private final String split;

  private final Integer index;

  protected GetSegment(BuilderImpl builder) {
    this.split = builder.split();
    this.index = builder.index();
  }

  public String split() {
    return this.split;
  }

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
    Builder split(String split);

    String split();

    Builder index(Integer index);

    Integer index();

    GetSegment build();
  }

  static class BuilderImpl implements Builder {
    protected String split;

    protected Integer index;

    protected BuilderImpl() {
    }

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
      if (Objects.isNull(this.split()))  {
        throw new IllegalArgumentException("Missing value for required field `split`");
      }
      if (Objects.nonNull(this.split()) && this.split().length() < 1) {
        throw new IllegalArgumentException("The size of `split` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.split()) && this.split().length() > 1) {
        throw new IllegalArgumentException("The size of `split` must be less than or equal to 1");
      }
      if (Objects.isNull(this.index()))  {
        throw new IllegalArgumentException("Missing value for required field `index`");
      }
      return new GetSegment(this);
    }
  }
}
