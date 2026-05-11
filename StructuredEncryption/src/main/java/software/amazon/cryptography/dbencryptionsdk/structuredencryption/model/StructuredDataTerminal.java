// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.nio.ByteBuffer;
import java.util.Objects;

public class StructuredDataTerminal {

  private final ByteBuffer value;

  private final ByteBuffer typeId;

  protected StructuredDataTerminal(BuilderImpl builder) {
    this.value = builder.value();
    this.typeId = builder.typeId();
  }

  public ByteBuffer value() {
    return this.value;
  }

  public ByteBuffer typeId() {
    return this.typeId;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder value(ByteBuffer value);

    ByteBuffer value();

    Builder typeId(ByteBuffer typeId);

    ByteBuffer typeId();

    StructuredDataTerminal build();
  }

  static class BuilderImpl implements Builder {

    protected ByteBuffer value;

    protected ByteBuffer typeId;

    protected BuilderImpl() {}

    protected BuilderImpl(StructuredDataTerminal model) {
      this.value = model.value();
      this.typeId = model.typeId();
    }

    public Builder value(ByteBuffer value) {
      this.value = value;
      return this;
    }

    public ByteBuffer value() {
      return this.value;
    }

    public Builder typeId(ByteBuffer typeId) {
      this.typeId = typeId;
      return this;
    }

    public ByteBuffer typeId() {
      return this.typeId;
    }

    public StructuredDataTerminal build() {
      if (Objects.isNull(this.value())) {
        throw new IllegalArgumentException(
          "Missing value for required field `value`"
        );
      }
      if (Objects.isNull(this.typeId())) {
        throw new IllegalArgumentException(
          "Missing value for required field `typeId`"
        );
      }
      if (Objects.nonNull(this.typeId()) && this.typeId().remaining() < 2) {
        throw new IllegalArgumentException(
          "The size of `typeId` must be greater than or equal to 2"
        );
      }
      if (Objects.nonNull(this.typeId()) && this.typeId().remaining() > 2) {
        throw new IllegalArgumentException(
          "The size of `typeId` must be less than or equal to 2"
        );
      }
      return new StructuredDataTerminal(this);
    }
  }
}
