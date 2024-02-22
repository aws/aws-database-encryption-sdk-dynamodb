// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

public class DefaultAction {

  private final ExplicitUnsigned explicitUnsigned;

  private final CryptoAction defaultAction;

  protected DefaultAction(BuilderImpl builder) {
    this.explicitUnsigned = builder.explicitUnsigned();
    this.defaultAction = builder.defaultAction();
  }

  public ExplicitUnsigned explicitUnsigned() {
    return this.explicitUnsigned;
  }

  public CryptoAction defaultAction() {
    return this.defaultAction;
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

    Builder defaultAction(CryptoAction defaultAction);

    CryptoAction defaultAction();

    DefaultAction build();
  }

  static class BuilderImpl implements Builder {

    protected ExplicitUnsigned explicitUnsigned;

    protected CryptoAction defaultAction;

    protected BuilderImpl() {}

    protected BuilderImpl(DefaultAction model) {
      this.explicitUnsigned = model.explicitUnsigned();
      this.defaultAction = model.defaultAction();
    }

    public Builder explicitUnsigned(ExplicitUnsigned explicitUnsigned) {
      this.explicitUnsigned = explicitUnsigned;
      return this;
    }

    public ExplicitUnsigned explicitUnsigned() {
      return this.explicitUnsigned;
    }

    public Builder defaultAction(CryptoAction defaultAction) {
      this.defaultAction = defaultAction;
      return this;
    }

    public CryptoAction defaultAction() {
      return this.defaultAction;
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
      Object[] allValues = { this.explicitUnsigned, this.defaultAction };
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
