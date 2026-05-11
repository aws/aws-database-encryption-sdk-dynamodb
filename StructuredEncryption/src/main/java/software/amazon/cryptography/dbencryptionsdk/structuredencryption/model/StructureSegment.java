// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Objects;

public class StructureSegment {

  private final String key;

  protected StructureSegment(BuilderImpl builder) {
    this.key = builder.key();
  }

  public String key() {
    return this.key;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder key(String key);

    String key();

    StructureSegment build();
  }

  static class BuilderImpl implements Builder {

    protected String key;

    protected BuilderImpl() {}

    protected BuilderImpl(StructureSegment model) {
      this.key = model.key();
    }

    public Builder key(String key) {
      this.key = key;
      return this;
    }

    public String key() {
      return this.key;
    }

    public StructureSegment build() {
      if (Objects.isNull(this.key())) {
        throw new IllegalArgumentException(
          "Missing value for required field `key`"
        );
      }
      return new StructureSegment(this);
    }
  }
}
