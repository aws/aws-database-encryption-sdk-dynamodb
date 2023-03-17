// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class NonSensitivePart {
  private final String name;

  private final String loc;

  protected NonSensitivePart(BuilderImpl builder) {
    this.name = builder.name();
    this.loc = builder.loc();
  }

  public String name() {
    return this.name;
  }

  public String loc() {
    return this.loc;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder name(String name);

    String name();

    Builder loc(String loc);

    String loc();

    NonSensitivePart build();
  }

  static class BuilderImpl implements Builder {
    protected String name;

    protected String loc;

    protected BuilderImpl() {
    }

    protected BuilderImpl(NonSensitivePart model) {
      this.name = model.name();
      this.loc = model.loc();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder loc(String loc) {
      this.loc = loc;
      return this;
    }

    public String loc() {
      return this.loc;
    }

    public NonSensitivePart build() {
      if (Objects.isNull(this.name()))  {
        throw new IllegalArgumentException("Missing value for required field `name`");
      }
      if (Objects.isNull(this.loc()))  {
        throw new IllegalArgumentException("Missing value for required field `loc`");
      }
      if (Objects.nonNull(this.loc()) && this.loc().length() < 1) {
        throw new IllegalArgumentException("The size of `loc` must be greater than or equal to 1");
      }
      return new NonSensitivePart(this);
    }
  }
}
