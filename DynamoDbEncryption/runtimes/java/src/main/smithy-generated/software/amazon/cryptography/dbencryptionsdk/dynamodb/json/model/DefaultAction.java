// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

public class DefaultAction {

  private final ExplicitUnsigned explicitUnsigned;

  private final CryptoAction action;

  protected DefaultAction(BuilderImpl builder) {
    this.explicitUnsigned = builder.explicitUnsigned();
    this.action = builder.action();
  }

  public ExplicitUnsigned explicitUnsigned() {
    return this.explicitUnsigned;
  }

  public CryptoAction action() {
    return this.action;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder explicitUnsigned(ExplicitUnsigned explicitUnsigned);

    ExplicitUnsigned explicitUnsigned();

    Builder action(CryptoAction action);

    CryptoAction action();

    DefaultAction build();
  }

  static class BuilderImpl implements Builder {

    protected ExplicitUnsigned explicitUnsigned;

    protected CryptoAction action;

    protected BuilderImpl() {}

    protected BuilderImpl(DefaultAction model) {
      this.explicitUnsigned = model.explicitUnsigned();
      this.action = model.action();
    }

    public Builder explicitUnsigned(ExplicitUnsigned explicitUnsigned) {
      this.explicitUnsigned = explicitUnsigned;
      return this;
    }

    public ExplicitUnsigned explicitUnsigned() {
      return this.explicitUnsigned;
    }

    public Builder action(CryptoAction action) {
      this.action = action;
      return this;
    }

    public CryptoAction action() {
      return this.action;
    }

    public DefaultAction build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException(
          "`DefaultAction` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new DefaultAction(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = { this.explicitUnsigned, this.action };
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
