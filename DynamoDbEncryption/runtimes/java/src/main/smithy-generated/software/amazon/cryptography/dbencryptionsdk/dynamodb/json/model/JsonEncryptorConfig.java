// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;

/**
 * The configuration for the client-side encryption of JSON objects.
 */
public class JsonEncryptorConfig {

  /**
   * The logical table name for this table. This is the name that is cryptographically bound with your data.
   */
  private final String logicalTableName;

  /**
   * A full description of the cryptographic actions that should be applied to each attributes.
   */
  private final Actions actions;

  /**
   * Setting for encryption and decryption.
   */
  private final DbesdkEncrypt encrypt;

  protected JsonEncryptorConfig(BuilderImpl builder) {
    this.logicalTableName = builder.logicalTableName();
    this.actions = builder.actions();
    this.encrypt = builder.encrypt();
  }

  /**
   * @return The logical table name for this table. This is the name that is cryptographically bound with your data.
   */
  public String logicalTableName() {
    return this.logicalTableName;
  }

  /**
   * @return A full description of the cryptographic actions that should be applied to each attributes.
   */
  public Actions actions() {
    return this.actions;
  }

  /**
   * @return Setting for encryption and decryption.
   */
  public DbesdkEncrypt encrypt() {
    return this.encrypt;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param logicalTableName The logical table name for this table. This is the name that is cryptographically bound with your data.
     */
    Builder logicalTableName(String logicalTableName);

    /**
     * @return The logical table name for this table. This is the name that is cryptographically bound with your data.
     */
    String logicalTableName();

    /**
     * @param actions A full description of the cryptographic actions that should be applied to each attributes.
     */
    Builder actions(Actions actions);

    /**
     * @return A full description of the cryptographic actions that should be applied to each attributes.
     */
    Actions actions();

    /**
     * @param encrypt Setting for encryption and decryption.
     */
    Builder encrypt(DbesdkEncrypt encrypt);

    /**
     * @return Setting for encryption and decryption.
     */
    DbesdkEncrypt encrypt();

    JsonEncryptorConfig build();
  }

  static class BuilderImpl implements Builder {

    protected String logicalTableName;

    protected Actions actions;

    protected DbesdkEncrypt encrypt;

    protected BuilderImpl() {}

    protected BuilderImpl(JsonEncryptorConfig model) {
      this.logicalTableName = model.logicalTableName();
      this.actions = model.actions();
      this.encrypt = model.encrypt();
    }

    public Builder logicalTableName(String logicalTableName) {
      this.logicalTableName = logicalTableName;
      return this;
    }

    public String logicalTableName() {
      return this.logicalTableName;
    }

    public Builder actions(Actions actions) {
      this.actions = actions;
      return this;
    }

    public Actions actions() {
      return this.actions;
    }

    public Builder encrypt(DbesdkEncrypt encrypt) {
      this.encrypt = encrypt;
      return this;
    }

    public DbesdkEncrypt encrypt() {
      return this.encrypt;
    }

    public JsonEncryptorConfig build() {
      if (Objects.isNull(this.logicalTableName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `logicalTableName`"
        );
      }
      if (Objects.isNull(this.actions())) {
        throw new IllegalArgumentException(
          "Missing value for required field `actions`"
        );
      }
      return new JsonEncryptorConfig(this);
    }
  }
}
