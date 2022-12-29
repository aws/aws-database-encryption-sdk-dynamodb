// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model;

import java.util.List;

public class CollectionOfErrors extends NativeError {
  private final List<RuntimeException> list;

  protected CollectionOfErrors(BuilderImpl builder) {
    super(builder);
    this.list = builder.list();
  }

  public List<RuntimeException> list() {
    return this.list;
  }

  @Override
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder extends NativeError.Builder {
    Builder message(String message);

    Builder cause(Throwable cause);

    Builder list(List<RuntimeException> list);

    List<RuntimeException> list();

    CollectionOfErrors build();
  }

  static class BuilderImpl extends NativeError.BuilderImpl implements Builder {
    protected List<RuntimeException> list;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CollectionOfErrors model) {
      super(model);
      this.list = model.list();
    }

    public Builder list(List<RuntimeException> list) {
      this.list = list;
      return this;
    }

    public List<RuntimeException> list() {
      return this.list;
    }

    @Override
    public Builder message(String message) {
      super.message(message);
      return this;
    }

    @Override
    public Builder cause(Throwable cause) {
      super.cause(cause);
      return this;
    }

    @Override
    public CollectionOfErrors build() {
      return new CollectionOfErrors(this);
    }
  }
}
