// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

public class ConstructorPart {
  private final String name;

  private final Boolean required;

  protected ConstructorPart(BuilderImpl builder) {
    this.name = builder.name();
    this.required = builder.required();
  }

  public String name() {
    return this.name;
  }

  public Boolean required() {
    return this.required;
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

    Builder required(Boolean required);

    Boolean required();

    ConstructorPart build();
  }

  static class BuilderImpl implements Builder {
    protected String name;

    protected Boolean required;

    protected BuilderImpl() {
    }

    protected BuilderImpl(ConstructorPart model) {
      this.name = model.name();
      this.required = model.required();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder required(Boolean required) {
      this.required = required;
      return this;
    }

    public Boolean required() {
      return this.required;
    }

    public ConstructorPart build() {
      if (Objects.isNull(this.name()))  {
        throw new IllegalArgumentException("Missing value for required field `name`");
      }
      if (Objects.isNull(this.required()))  {
        throw new IllegalArgumentException("Missing value for required field `required`");
      }
      return new ConstructorPart(this);
    }
  }
}
