// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

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
   * An ID for the algorithm suite to use during encryption and decryption.
   */
  private final DBEAlgorithmSuiteId algorithmSuiteId;

  private final KeyAccess keyAccess;

  protected JsonEncryptorConfig(BuilderImpl builder) {
    this.logicalTableName = builder.logicalTableName();
    this.actions = builder.actions();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.keyAccess = builder.keyAccess();
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
   * @return An ID for the algorithm suite to use during encryption and decryption.
   */
  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  public KeyAccess keyAccess() {
    return this.keyAccess;
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
     * @param algorithmSuiteId An ID for the algorithm suite to use during encryption and decryption.
     */
    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    /**
     * @return An ID for the algorithm suite to use during encryption and decryption.
     */
    DBEAlgorithmSuiteId algorithmSuiteId();

    Builder keyAccess(KeyAccess keyAccess);

    KeyAccess keyAccess();

    JsonEncryptorConfig build();
  }

  static class BuilderImpl implements Builder {

    protected String logicalTableName;

    protected Actions actions;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected KeyAccess keyAccess;

    protected BuilderImpl() {}

    protected BuilderImpl(JsonEncryptorConfig model) {
      this.logicalTableName = model.logicalTableName();
      this.actions = model.actions();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.keyAccess = model.keyAccess();
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

    public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
    }

    public Builder keyAccess(KeyAccess keyAccess) {
      this.keyAccess = keyAccess;
      return this;
    }

    public KeyAccess keyAccess() {
      return this.keyAccess;
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
      if (Objects.isNull(this.keyAccess())) {
        throw new IllegalArgumentException(
          "Missing value for required field `keyAccess`"
        );
      }
      return new JsonEncryptorConfig(this);
    }
  }
}
