// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

public class Action {

  private final CryptoAction crypto;

  private final JsonEncrypt dbesdk;

  protected Action(BuilderImpl builder) {
    this.crypto = builder.crypto();
    this.dbesdk = builder.dbesdk();
  }

  public CryptoAction crypto() {
    return this.crypto;
  }

  public JsonEncrypt dbesdk() {
    return this.dbesdk;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder crypto(CryptoAction crypto);

    CryptoAction crypto();

    Builder dbesdk(JsonEncrypt dbesdk);

    JsonEncrypt dbesdk();

    Action build();
  }

  static class BuilderImpl implements Builder {

    protected CryptoAction crypto;

    protected JsonEncrypt dbesdk;

    protected BuilderImpl() {}

    protected BuilderImpl(Action model) {
      this.crypto = model.crypto();
      this.dbesdk = model.dbesdk();
    }

    public Builder crypto(CryptoAction crypto) {
      this.crypto = crypto;
      return this;
    }

    public CryptoAction crypto() {
      return this.crypto;
    }

    public Builder dbesdk(JsonEncrypt dbesdk) {
      this.dbesdk = dbesdk;
      return this;
    }

    public JsonEncrypt dbesdk() {
      return this.dbesdk;
    }

    public Action build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException(
          "`Action` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new Action(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = { this.crypto, this.dbesdk };
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
