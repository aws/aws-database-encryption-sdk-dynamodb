// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Objects;

public class PathSegment {

  private final StructureSegment member;

  protected PathSegment(BuilderImpl builder) {
    this.member = builder.member();
  }

  public StructureSegment member() {
    return this.member;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder member(StructureSegment member);

    StructureSegment member();

    PathSegment build();
  }

  static class BuilderImpl implements Builder {

    protected StructureSegment member;

    protected BuilderImpl() {}

    protected BuilderImpl(PathSegment model) {
      this.member = model.member();
    }

    public Builder member(StructureSegment member) {
      this.member = member;
      return this;
    }

    public StructureSegment member() {
      return this.member;
    }

    public PathSegment build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException(
          "`PathSegment` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new PathSegment(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = { this.member };
      boolean haveOneNonNull = false;
      for (Object o : allValues) {
        if (Objects.nonNull(o)) {
          if (haveOneNonNull) {
            return false;
          }
          haveOneNonNull = true;
        }
      }
      return haveOneNonNull;
    }
  }
}
