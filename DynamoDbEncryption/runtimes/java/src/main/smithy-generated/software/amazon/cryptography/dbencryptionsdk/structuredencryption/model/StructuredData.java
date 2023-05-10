// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Map;
import java.util.Objects;

public class StructuredData {
  private final StructuredDataContent content;

  private final Map<String, StructuredDataTerminal> attributes;

  protected StructuredData(BuilderImpl builder) {
    this.content = builder.content();
    this.attributes = builder.attributes();
  }

  public StructuredDataContent content() {
    return this.content;
  }

  public Map<String, StructuredDataTerminal> attributes() {
    return this.attributes;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder content(StructuredDataContent content);

    StructuredDataContent content();

    Builder attributes(Map<String, StructuredDataTerminal> attributes);

    Map<String, StructuredDataTerminal> attributes();

    StructuredData build();
  }

  static class BuilderImpl implements Builder {
    protected StructuredDataContent content;

    protected Map<String, StructuredDataTerminal> attributes;

    protected BuilderImpl() {
    }

    protected BuilderImpl(StructuredData model) {
      this.content = model.content();
      this.attributes = model.attributes();
    }

    public Builder content(StructuredDataContent content) {
      this.content = content;
      return this;
    }

    public StructuredDataContent content() {
      return this.content;
    }

    public Builder attributes(Map<String, StructuredDataTerminal> attributes) {
      this.attributes = attributes;
      return this;
    }

    public Map<String, StructuredDataTerminal> attributes() {
      return this.attributes;
    }

    public StructuredData build() {
      if (Objects.isNull(this.content()))  {
        throw new IllegalArgumentException("Missing value for required field `content`");
      }
      return new StructuredData(this);
    }
  }
}
