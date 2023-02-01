// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.structuredEncryption.model;

import Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager;
import java.util.Map;
import java.util.Objects;

public class DecryptStructureInput {
  private final String tableName;

  private final StructuredData encryptedStructure;

  private final AuthenticateSchema authenticateSchema;

  private final ICryptographicMaterialsManager cmm;

  private final Map<String, String> encryptionContext;

  protected DecryptStructureInput(BuilderImpl builder) {
    this.tableName = builder.tableName();
    this.encryptedStructure = builder.encryptedStructure();
    this.authenticateSchema = builder.authenticateSchema();
    this.cmm = builder.cmm();
    this.encryptionContext = builder.encryptionContext();
  }

  public String tableName() {
    return this.tableName;
  }

  public StructuredData encryptedStructure() {
    return this.encryptedStructure;
  }

  public AuthenticateSchema authenticateSchema() {
    return this.authenticateSchema;
  }

  public ICryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  public Map<String, String> encryptionContext() {
    return this.encryptionContext;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder tableName(String tableName);

    String tableName();

    Builder encryptedStructure(StructuredData encryptedStructure);

    StructuredData encryptedStructure();

    Builder authenticateSchema(AuthenticateSchema authenticateSchema);

    AuthenticateSchema authenticateSchema();

    Builder cmm(ICryptographicMaterialsManager cmm);

    ICryptographicMaterialsManager cmm();

    Builder encryptionContext(Map<String, String> encryptionContext);

    Map<String, String> encryptionContext();

    DecryptStructureInput build();
  }

  static class BuilderImpl implements Builder {
    protected String tableName;

    protected StructuredData encryptedStructure;

    protected AuthenticateSchema authenticateSchema;

    protected ICryptographicMaterialsManager cmm;

    protected Map<String, String> encryptionContext;

    protected BuilderImpl() {
    }

    protected BuilderImpl(DecryptStructureInput model) {
      this.tableName = model.tableName();
      this.encryptedStructure = model.encryptedStructure();
      this.authenticateSchema = model.authenticateSchema();
      this.cmm = model.cmm();
      this.encryptionContext = model.encryptionContext();
    }

    public Builder tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }

    public String tableName() {
      return this.tableName;
    }

    public Builder encryptedStructure(StructuredData encryptedStructure) {
      this.encryptedStructure = encryptedStructure;
      return this;
    }

    public StructuredData encryptedStructure() {
      return this.encryptedStructure;
    }

    public Builder authenticateSchema(AuthenticateSchema authenticateSchema) {
      this.authenticateSchema = authenticateSchema;
      return this;
    }

    public AuthenticateSchema authenticateSchema() {
      return this.authenticateSchema;
    }

    public Builder cmm(ICryptographicMaterialsManager cmm) {
      this.cmm = cmm;
      return this;
    }

    public ICryptographicMaterialsManager cmm() {
      return this.cmm;
    }

    public Builder encryptionContext(Map<String, String> encryptionContext) {
      this.encryptionContext = encryptionContext;
      return this;
    }

    public Map<String, String> encryptionContext() {
      return this.encryptionContext;
    }

    public DecryptStructureInput build() {
      if (Objects.isNull(this.tableName()))  {
        throw new IllegalArgumentException("Missing value for required field `tableName`");
      }
      if (Objects.isNull(this.encryptedStructure()))  {
        throw new IllegalArgumentException("Missing value for required field `encryptedStructure`");
      }
      if (Objects.isNull(this.authenticateSchema()))  {
        throw new IllegalArgumentException("Missing value for required field `authenticateSchema`");
      }
      if (Objects.isNull(this.cmm()))  {
        throw new IllegalArgumentException("Missing value for required field `cmm`");
      }
      return new DecryptStructureInput(this);
    }
  }
}
