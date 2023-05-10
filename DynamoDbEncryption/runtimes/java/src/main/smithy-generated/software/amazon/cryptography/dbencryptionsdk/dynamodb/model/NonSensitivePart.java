// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

public class NonSensitivePart {
  private final String name;

  private final String prefix;

  private final String loc;

  protected NonSensitivePart(BuilderImpl builder) {
    this.name = builder.name();
    this.prefix = builder.prefix();
    this.loc = builder.loc();
  }

  public String name() {
    return this.name;
  }

  public String prefix() {
    return this.prefix;
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

    Builder prefix(String prefix);

    String prefix();

    Builder loc(String loc);

    String loc();

    NonSensitivePart build();
  }

  static class BuilderImpl implements Builder {
    protected String name;

    protected String prefix;

    protected String loc;

    protected BuilderImpl() {
    }

    protected BuilderImpl(NonSensitivePart model) {
      this.name = model.name();
      this.prefix = model.prefix();
      this.loc = model.loc();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder prefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    public String prefix() {
      return this.prefix;
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
      if (Objects.isNull(this.prefix()))  {
        throw new IllegalArgumentException("Missing value for required field `prefix`");
      }
      if (Objects.nonNull(this.prefix()) && this.prefix().length() < 1) {
        throw new IllegalArgumentException("The size of `prefix` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.loc()) && this.loc().length() < 1) {
        throw new IllegalArgumentException("The size of `loc` must be greater than or equal to 1");
      }
      return new NonSensitivePart(this);
    }
  }
}
