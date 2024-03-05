// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;

public class Json {

  private final String utf8;

  private final String text;

  protected Json(BuilderImpl builder) {
    this.utf8 = builder.utf8();
    this.text = builder.text();
  }

  public String utf8() {
    return this.utf8;
  }

  public String text() {
    return this.text;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder utf8(String utf8);

    String utf8();

    Builder text(String text);

    String text();

    Json build();
  }

  static class BuilderImpl implements Builder {

    protected String utf8;

    protected String text;

    protected BuilderImpl() {}

    protected BuilderImpl(Json model) {
      this.utf8 = model.utf8();
      this.text = model.text();
    }

    public Builder utf8(String utf8) {
      this.utf8 = utf8;
      return this;
    }

    public String utf8() {
      return this.utf8;
    }

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public String text() {
      return this.text;
    }

    public Json build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException(
          "`Json` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new Json(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = { this.utf8, this.text };
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
