// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;

public class VirtualField {
  private final String name;

  private final List<VirtualPart> parts;

  protected VirtualField(BuilderImpl builder) {
    this.name = builder.name();
    this.parts = builder.parts();
  }

  public String name() {
    return this.name;
  }

  public List<VirtualPart> parts() {
    return this.parts;
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

    Builder parts(List<VirtualPart> parts);

    List<VirtualPart> parts();

    VirtualField build();
  }

  static class BuilderImpl implements Builder {
    protected String name;

    protected List<VirtualPart> parts;

    protected BuilderImpl() {
    }

    protected BuilderImpl(VirtualField model) {
      this.name = model.name();
      this.parts = model.parts();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder parts(List<VirtualPart> parts) {
      this.parts = parts;
      return this;
    }

    public List<VirtualPart> parts() {
      return this.parts;
    }

    public VirtualField build() {
      if (Objects.isNull(this.name()))  {
        throw new IllegalArgumentException("Missing value for required field `name`");
      }
      if (Objects.isNull(this.parts()))  {
        throw new IllegalArgumentException("Missing value for required field `parts`");
      }
      if (Objects.nonNull(this.parts()) && this.parts().size() < 1) {
        throw new IllegalArgumentException("The size of `parts` must be greater than or equal to 1");
      }
      return new VirtualField(this);
    }
  }
}
