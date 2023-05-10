// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Map;
import java.util.Objects;

public class CryptoSchema {
  private final CryptoSchemaContent content;

  private final Map<String, AuthenticateAction> attributes;

  protected CryptoSchema(BuilderImpl builder) {
    this.content = builder.content();
    this.attributes = builder.attributes();
  }

  public CryptoSchemaContent content() {
    return this.content;
  }

  public Map<String, AuthenticateAction> attributes() {
    return this.attributes;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder content(CryptoSchemaContent content);

    CryptoSchemaContent content();

    Builder attributes(Map<String, AuthenticateAction> attributes);

    Map<String, AuthenticateAction> attributes();

    CryptoSchema build();
  }

  static class BuilderImpl implements Builder {
    protected CryptoSchemaContent content;

    protected Map<String, AuthenticateAction> attributes;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CryptoSchema model) {
      this.content = model.content();
      this.attributes = model.attributes();
    }

    public Builder content(CryptoSchemaContent content) {
      this.content = content;
      return this;
    }

    public CryptoSchemaContent content() {
      return this.content;
    }

    public Builder attributes(Map<String, AuthenticateAction> attributes) {
      this.attributes = attributes;
      return this;
    }

    public Map<String, AuthenticateAction> attributes() {
      return this.attributes;
    }

    public CryptoSchema build() {
      if (Objects.isNull(this.content()))  {
        throw new IllegalArgumentException("Missing value for required field `content`");
      }
      return new CryptoSchema(this);
    }
  }
}
