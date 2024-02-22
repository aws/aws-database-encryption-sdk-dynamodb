// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AuthenticateSchemaContent {

  private final AuthenticateAction Action;

  private final Map<String, AuthenticateSchema> SchemaMap;

  private final List<AuthenticateSchema> SchemaList;

  protected AuthenticateSchemaContent(BuilderImpl builder) {
    this.Action = builder.Action();
    this.SchemaMap = builder.SchemaMap();
    this.SchemaList = builder.SchemaList();
  }

  public AuthenticateAction Action() {
    return this.Action;
  }

  public Map<String, AuthenticateSchema> SchemaMap() {
    return this.SchemaMap;
  }

  public List<AuthenticateSchema> SchemaList() {
    return this.SchemaList;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder Action(AuthenticateAction Action);

    AuthenticateAction Action();

    Builder SchemaMap(Map<String, AuthenticateSchema> SchemaMap);

    Map<String, AuthenticateSchema> SchemaMap();

    Builder SchemaList(List<AuthenticateSchema> SchemaList);

    List<AuthenticateSchema> SchemaList();

    AuthenticateSchemaContent build();
  }

  static class BuilderImpl implements Builder {

    protected AuthenticateAction Action;

    protected Map<String, AuthenticateSchema> SchemaMap;

    protected List<AuthenticateSchema> SchemaList;

    protected BuilderImpl() {}

    protected BuilderImpl(AuthenticateSchemaContent model) {
      this.Action = model.Action();
      this.SchemaMap = model.SchemaMap();
      this.SchemaList = model.SchemaList();
    }

    public Builder Action(AuthenticateAction Action) {
      this.Action = Action;
      return this;
    }

    public AuthenticateAction Action() {
      return this.Action;
    }

    public Builder SchemaMap(Map<String, AuthenticateSchema> SchemaMap) {
      this.SchemaMap = SchemaMap;
      return this;
    }

    public Map<String, AuthenticateSchema> SchemaMap() {
      return this.SchemaMap;
    }

    public Builder SchemaList(List<AuthenticateSchema> SchemaList) {
      this.SchemaList = SchemaList;
      return this;
    }

    public List<AuthenticateSchema> SchemaList() {
      return this.SchemaList;
    }

    public AuthenticateSchemaContent build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException(
          "`AuthenticateSchemaContent` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new AuthenticateSchemaContent(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = { this.Action, this.SchemaMap, this.SchemaList };
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
