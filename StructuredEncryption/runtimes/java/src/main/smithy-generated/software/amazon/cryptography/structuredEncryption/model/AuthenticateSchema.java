// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption.model;

import java.util.Map;
import java.util.Objects;

public class AuthenticateSchema {
  private final AuthenticateSchemaContent content;

  private final Map<String, AuthenticateAction> attributes;

  protected AuthenticateSchema(BuilderImpl builder) {
    this.content = builder.content();
    this.attributes = builder.attributes();
  }

  public AuthenticateSchemaContent content() {
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
    Builder content(AuthenticateSchemaContent content);

    AuthenticateSchemaContent content();

    Builder attributes(Map<String, AuthenticateAction> attributes);

    Map<String, AuthenticateAction> attributes();

    AuthenticateSchema build();
  }

  static class BuilderImpl implements Builder {
    protected AuthenticateSchemaContent content;

    protected Map<String, AuthenticateAction> attributes;

    protected BuilderImpl() {
    }

    protected BuilderImpl(AuthenticateSchema model) {
      this.content = model.content();
      this.attributes = model.attributes();
    }

    public Builder content(AuthenticateSchemaContent content) {
      this.content = content;
      return this;
    }

    public AuthenticateSchemaContent content() {
      return this.content;
    }

    public Builder attributes(Map<String, AuthenticateAction> attributes) {
      this.attributes = attributes;
      return this;
    }

    public Map<String, AuthenticateAction> attributes() {
      return this.attributes;
    }

    public AuthenticateSchema build() {
      if (Objects.isNull(this.content()))  {
        throw new IllegalArgumentException("Missing value for required field `content`");
      }
      return new AuthenticateSchema(this);
    }
  }
}
