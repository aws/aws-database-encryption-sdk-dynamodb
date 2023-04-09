// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class SensitivePart {
  private final String name;

  private final String prefix;

  protected SensitivePart(BuilderImpl builder) {
    this.name = builder.name();
    this.prefix = builder.prefix();
  }

  public String name() {
    return this.name;
  }

  public String prefix() {
    return this.prefix;
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

    SensitivePart build();
  }

  static class BuilderImpl implements Builder {
    protected String name;

    protected String prefix;

    protected BuilderImpl() {
    }

    protected BuilderImpl(SensitivePart model) {
      this.name = model.name();
      this.prefix = model.prefix();
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

    public SensitivePart build() {
      if (Objects.isNull(this.name()))  {
        throw new IllegalArgumentException("Missing value for required field `name`");
      }
      if (Objects.isNull(this.prefix()))  {
        throw new IllegalArgumentException("Missing value for required field `prefix`");
      }
      if (Objects.nonNull(this.prefix()) && this.prefix().length() < 1) {
        throw new IllegalArgumentException("The size of `prefix` must be greater than or equal to 1");
      }
      return new SensitivePart(this);
    }
  }
}
