// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class Insert {
  private final String string;

  protected Insert(BuilderImpl builder) {
    this.string = builder.string();
  }

  public String string() {
    return this.string;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder string(String string);

    String string();

    Insert build();
  }

  static class BuilderImpl implements Builder {
    protected String string;

    protected BuilderImpl() {
    }

    protected BuilderImpl(Insert model) {
      this.string = model.string();
    }

    public Builder string(String string) {
      this.string = string;
      return this;
    }

    public String string() {
      return this.string;
    }

    public Insert build() {
      if (Objects.isNull(this.string()))  {
        throw new IllegalArgumentException("Missing value for required field `string`");
      }
      return new Insert(this);
    }
  }
}
