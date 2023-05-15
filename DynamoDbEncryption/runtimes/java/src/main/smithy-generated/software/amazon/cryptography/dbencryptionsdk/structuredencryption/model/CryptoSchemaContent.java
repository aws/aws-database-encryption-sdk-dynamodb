// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CryptoSchemaContent {
  private final CryptoAction Action;

  private final Map<String, CryptoSchema> SchemaMap;

  private final List<CryptoSchema> SchemaList;

  protected CryptoSchemaContent(BuilderImpl builder) {
    this.Action = builder.Action();
    this.SchemaMap = builder.SchemaMap();
    this.SchemaList = builder.SchemaList();
  }

  public CryptoAction Action() {
    return this.Action;
  }

  public Map<String, CryptoSchema> SchemaMap() {
    return this.SchemaMap;
  }

  public List<CryptoSchema> SchemaList() {
    return this.SchemaList;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder Action(CryptoAction Action);

    CryptoAction Action();

    Builder SchemaMap(Map<String, CryptoSchema> SchemaMap);

    Map<String, CryptoSchema> SchemaMap();

    Builder SchemaList(List<CryptoSchema> SchemaList);

    List<CryptoSchema> SchemaList();

    CryptoSchemaContent build();
  }

  static class BuilderImpl implements Builder {
    protected CryptoAction Action;

    protected Map<String, CryptoSchema> SchemaMap;

    protected List<CryptoSchema> SchemaList;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CryptoSchemaContent model) {
      this.Action = model.Action();
      this.SchemaMap = model.SchemaMap();
      this.SchemaList = model.SchemaList();
    }

    public Builder Action(CryptoAction Action) {
      this.Action = Action;
      return this;
    }

    public CryptoAction Action() {
      return this.Action;
    }

    public Builder SchemaMap(Map<String, CryptoSchema> SchemaMap) {
      this.SchemaMap = SchemaMap;
      return this;
    }

    public Map<String, CryptoSchema> SchemaMap() {
      return this.SchemaMap;
    }

    public Builder SchemaList(List<CryptoSchema> SchemaList) {
      this.SchemaList = SchemaList;
      return this;
    }

    public List<CryptoSchema> SchemaList() {
      return this.SchemaList;
    }

    public CryptoSchemaContent build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException("`CryptoSchemaContent` is a Union. A Union MUST have one and only one value set.");
      }
      return new CryptoSchemaContent(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = {this.Action, this.SchemaMap, this.SchemaList};
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
