// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

public class ResolveAuthActionsInput {

  private final String tableName;

  private final List<AuthItem> authActions;

  private final ByteBuffer headerBytes;

  protected ResolveAuthActionsInput(BuilderImpl builder) {
    this.tableName = builder.tableName();
    this.authActions = builder.authActions();
    this.headerBytes = builder.headerBytes();
  }

  public String tableName() {
    return this.tableName;
  }

  public List<AuthItem> authActions() {
    return this.authActions;
  }

  public ByteBuffer headerBytes() {
    return this.headerBytes;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder tableName(String tableName);

    String tableName();

    Builder authActions(List<AuthItem> authActions);

    List<AuthItem> authActions();

    Builder headerBytes(ByteBuffer headerBytes);

    ByteBuffer headerBytes();

    ResolveAuthActionsInput build();
  }

  static class BuilderImpl implements Builder {

    protected String tableName;

    protected List<AuthItem> authActions;

    protected ByteBuffer headerBytes;

    protected BuilderImpl() {}

    protected BuilderImpl(ResolveAuthActionsInput model) {
      this.tableName = model.tableName();
      this.authActions = model.authActions();
      this.headerBytes = model.headerBytes();
    }

    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public String tableName() {
      return this.tableName;
    }

    public Builder authActions(List<AuthItem> authActions) {
      this.authActions = authActions;
      return this;
    }

    public List<AuthItem> authActions() {
      return this.authActions;
    }

    public Builder headerBytes(ByteBuffer headerBytes) {
      this.headerBytes = headerBytes;
      return this;
    }

    public ByteBuffer headerBytes() {
      return this.headerBytes;
    }

    public ResolveAuthActionsInput build() {
      if (Objects.isNull(this.tableName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `tableName`"
        );
      }
      if (Objects.isNull(this.authActions())) {
        throw new IllegalArgumentException(
          "Missing value for required field `authActions`"
        );
      }
      if (Objects.isNull(this.headerBytes())) {
        throw new IllegalArgumentException(
          "Missing value for required field `headerBytes`"
        );
      }
      return new ResolveAuthActionsInput(this);
    }
  }
}
