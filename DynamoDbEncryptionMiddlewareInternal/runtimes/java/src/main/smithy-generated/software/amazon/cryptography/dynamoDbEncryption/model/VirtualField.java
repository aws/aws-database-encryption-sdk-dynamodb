// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class VirtualField {
  private final String name;

  private final String config;

  protected VirtualField(BuilderImpl builder) {
    this.name = builder.name();
    this.config = builder.config();
  }

  public String name() {
    return this.name;
  }

  public String config() {
    return this.config;
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

    Builder config(String config);

    String config();

    VirtualField build();
  }

  static class BuilderImpl implements Builder {
    protected String name;

    protected String config;

    protected BuilderImpl() {
    }

    protected BuilderImpl(VirtualField model) {
      this.name = model.name();
      this.config = model.config();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder config(String config) {
      this.config = config;
      return this;
    }

    public String config() {
      return this.config;
    }

    public VirtualField build() {
      if (Objects.isNull(this.name()))  {
        throw new IllegalArgumentException("Missing value for required field `name`");
      }
      if (Objects.isNull(this.config()))  {
        throw new IllegalArgumentException("Missing value for required field `config`");
      }
      return new VirtualField(this);
    }
  }
}
