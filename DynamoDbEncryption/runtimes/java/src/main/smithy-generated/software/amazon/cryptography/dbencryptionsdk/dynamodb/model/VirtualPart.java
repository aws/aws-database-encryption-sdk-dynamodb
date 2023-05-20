// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;

public class VirtualPart {
  private final String loc;

  private final List<VirtualTransform> trans;

  protected VirtualPart(BuilderImpl builder) {
    this.loc = builder.loc();
    this.trans = builder.trans();
  }

  public String loc() {
    return this.loc;
  }

  public List<VirtualTransform> trans() {
    return this.trans;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder loc(String loc);

    String loc();

    Builder trans(List<VirtualTransform> trans);

    List<VirtualTransform> trans();

    VirtualPart build();
  }

  static class BuilderImpl implements Builder {
    protected String loc;

    protected List<VirtualTransform> trans;

    protected BuilderImpl() {
    }

    protected BuilderImpl(VirtualPart model) {
      this.loc = model.loc();
      this.trans = model.trans();
    }

    public Builder loc(String loc) {
      this.loc = loc;
      return this;
    }

    public String loc() {
      return this.loc;
    }

    public Builder trans(List<VirtualTransform> trans) {
      this.trans = trans;
      return this;
    }

    public List<VirtualTransform> trans() {
      return this.trans;
    }

    public VirtualPart build() {
      if (Objects.isNull(this.loc()))  {
        throw new IllegalArgumentException("Missing value for required field `loc`");
      }
      if (Objects.nonNull(this.loc()) && this.loc().length() < 1) {
        throw new IllegalArgumentException("The size of `loc` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.trans()) && this.trans().size() < 1) {
        throw new IllegalArgumentException("The size of `trans` must be greater than or equal to 1");
      }
      return new VirtualPart(this);
    }
  }
}
