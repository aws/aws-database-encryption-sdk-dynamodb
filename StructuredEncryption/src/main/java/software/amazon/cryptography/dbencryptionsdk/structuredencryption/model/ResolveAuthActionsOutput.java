// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.List;
import java.util.Objects;

public class ResolveAuthActionsOutput {

  private final List<CryptoItem> cryptoActions;

  protected ResolveAuthActionsOutput(BuilderImpl builder) {
    this.cryptoActions = builder.cryptoActions();
  }

  public List<CryptoItem> cryptoActions() {
    return this.cryptoActions;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder cryptoActions(List<CryptoItem> cryptoActions);

    List<CryptoItem> cryptoActions();

    ResolveAuthActionsOutput build();
  }

  static class BuilderImpl implements Builder {

    protected List<CryptoItem> cryptoActions;

    protected BuilderImpl() {}

    protected BuilderImpl(ResolveAuthActionsOutput model) {
      this.cryptoActions = model.cryptoActions();
    }

    public Builder cryptoActions(List<CryptoItem> cryptoActions) {
      this.cryptoActions = cryptoActions;
      return this;
    }

    public List<CryptoItem> cryptoActions() {
      return this.cryptoActions;
    }

    public ResolveAuthActionsOutput build() {
      if (Objects.isNull(this.cryptoActions())) {
        throw new IllegalArgumentException(
          "Missing value for required field `cryptoActions`"
        );
      }
      return new ResolveAuthActionsOutput(this);
    }
  }
}
