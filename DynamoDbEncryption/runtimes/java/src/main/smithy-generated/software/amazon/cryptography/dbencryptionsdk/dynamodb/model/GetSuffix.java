// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

public class GetSuffix {
  private final Integer length;

  protected GetSuffix(BuilderImpl builder) {
    this.length = builder.length();
  }

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
    Builder length(Integer length);

    Integer length();

    GetSuffix build();
  }

  static class BuilderImpl implements Builder {
    protected Integer length;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetSuffix model) {
      this.length = model.length();
    }

    public Builder length(Integer length) {
      this.length = length;
      return this;
    }

    public Integer length() {
      return this.length;
    }

    public GetSuffix build() {
      if (Objects.isNull(this.length()))  {
        throw new IllegalArgumentException("Missing value for required field `length`");
      }
      return new GetSuffix(this);
    }
  }
}
