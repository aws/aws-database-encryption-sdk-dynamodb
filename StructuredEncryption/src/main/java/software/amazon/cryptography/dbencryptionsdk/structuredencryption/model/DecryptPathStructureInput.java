// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;

public class DecryptPathStructureInput {

  private final String tableName;

  private final List<AuthItem> encryptedStructure;

  private final ICryptographicMaterialsManager cmm;

  private final Map<String, String> encryptionContext;

  protected DecryptPathStructureInput(BuilderImpl builder) {
    this.tableName = builder.tableName();
    this.encryptedStructure = builder.encryptedStructure();
    this.cmm = builder.cmm();
    this.encryptionContext = builder.encryptionContext();
  }

  public String tableName() {
    return this.tableName;
  }

  public List<AuthItem> encryptedStructure() {
    return this.encryptedStructure;
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

    Builder encryptedStructure(List<AuthItem> encryptedStructure);

    List<AuthItem> encryptedStructure();

    Builder cmm(ICryptographicMaterialsManager cmm);

    ICryptographicMaterialsManager cmm();

    Builder encryptionContext(Map<String, String> encryptionContext);

    Map<String, String> encryptionContext();

    DecryptPathStructureInput build();
  }

  static class BuilderImpl implements Builder {

    protected String tableName;

    protected List<AuthItem> encryptedStructure;

    protected ICryptographicMaterialsManager cmm;

    protected Map<String, String> encryptionContext;

    protected BuilderImpl() {}

    protected BuilderImpl(DecryptPathStructureInput model) {
      this.tableName = model.tableName();
      this.encryptedStructure = model.encryptedStructure();
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

    public Builder encryptedStructure(List<AuthItem> encryptedStructure) {
      this.encryptedStructure = encryptedStructure;
      return this;
    }

    public List<AuthItem> encryptedStructure() {
      return this.encryptedStructure;
    }

    public Builder cmm(ICryptographicMaterialsManager cmm) {
      this.cmm = CryptographicMaterialsManager.wrap(cmm);
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

    public DecryptPathStructureInput build() {
      if (Objects.isNull(this.tableName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `tableName`"
        );
      }
      if (Objects.isNull(this.encryptedStructure())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptedStructure`"
        );
      }
      if (Objects.isNull(this.cmm())) {
        throw new IllegalArgumentException(
          "Missing value for required field `cmm`"
        );
      }
      return new DecryptPathStructureInput(this);
    }
  }
}
