// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StructuredDataContent {
  private final StructuredDataTerminal Terminal;

  private final List<StructuredData> DataList;

  private final Map<String, StructuredData> DataMap;

  protected StructuredDataContent(BuilderImpl builder) {
    this.Terminal = builder.Terminal();
    this.DataList = builder.DataList();
    this.DataMap = builder.DataMap();
  }

  public StructuredDataTerminal Terminal() {
    return this.Terminal;
  }

  public List<StructuredData> DataList() {
    return this.DataList;
  }

  public Map<String, StructuredData> DataMap() {
    return this.DataMap;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder Terminal(StructuredDataTerminal Terminal);

    StructuredDataTerminal Terminal();

    Builder DataList(List<StructuredData> DataList);

    List<StructuredData> DataList();

    Builder DataMap(Map<String, StructuredData> DataMap);

    Map<String, StructuredData> DataMap();

    StructuredDataContent build();
  }

  static class BuilderImpl implements Builder {
    protected StructuredDataTerminal Terminal;

    protected List<StructuredData> DataList;

    protected Map<String, StructuredData> DataMap;

    protected BuilderImpl() {
    }

    protected BuilderImpl(StructuredDataContent model) {
      this.Terminal = model.Terminal();
      this.DataList = model.DataList();
      this.DataMap = model.DataMap();
    }

    public Builder Terminal(StructuredDataTerminal Terminal) {
      this.Terminal = Terminal;
      return this;
    }

    public StructuredDataTerminal Terminal() {
      return this.Terminal;
    }

    public Builder DataList(List<StructuredData> DataList) {
      this.DataList = DataList;
      return this;
    }

    public List<StructuredData> DataList() {
      return this.DataList;
    }

    public Builder DataMap(Map<String, StructuredData> DataMap) {
      this.DataMap = DataMap;
      return this;
    }

    public Map<String, StructuredData> DataMap() {
      return this.DataMap;
    }

    public StructuredDataContent build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException("`StructuredDataContent` is a Union. A Union MUST have one and only one value set.");
      }
      return new StructuredDataContent(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = {this.Terminal, this.DataList, this.DataMap};
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
