// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Map;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.Keyring;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

public class JsonEncrypt {

  /**
   * The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  private final IKeyring keyring;

  /**
   * The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  private final ICryptographicMaterialsManager cmm;

  /**
   * An ID for the algorithm suite to use during encryption and decryption.
   */
  private final DBEAlgorithmSuiteId algorithmSuiteId;

  /**
   * Extra key-value pairs to include in the required encryption context.
   */
  private final Map<String, String> encryptionContext;

  protected JsonEncrypt(BuilderImpl builder) {
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.encryptionContext = builder.encryptionContext();
  }

  /**
   * @return The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  public IKeyring keyring() {
    return this.keyring;
  }

  /**
   * @return The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  public ICryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  /**
   * @return An ID for the algorithm suite to use during encryption and decryption.
   */
  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  /**
   * @return Extra key-value pairs to include in the required encryption context.
   */
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
    /**
     * @param keyring The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
     */
    Builder keyring(IKeyring keyring);

    /**
     * @return The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
     */
    IKeyring keyring();

    /**
     * @param cmm The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
     */
    Builder cmm(ICryptographicMaterialsManager cmm);

    /**
     * @return The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
     */
    ICryptographicMaterialsManager cmm();

    /**
     * @param algorithmSuiteId An ID for the algorithm suite to use during encryption and decryption.
     */
    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    /**
     * @return An ID for the algorithm suite to use during encryption and decryption.
     */
    DBEAlgorithmSuiteId algorithmSuiteId();

    /**
     * @param encryptionContext Extra key-value pairs to include in the required encryption context.
     */
    Builder encryptionContext(Map<String, String> encryptionContext);

    /**
     * @return Extra key-value pairs to include in the required encryption context.
     */
    Map<String, String> encryptionContext();

    JsonEncrypt build();
  }

  static class BuilderImpl implements Builder {

    protected IKeyring keyring;

    protected ICryptographicMaterialsManager cmm;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected Map<String, String> encryptionContext;

    protected BuilderImpl() {}

    protected BuilderImpl(JsonEncrypt model) {
      this.keyring = model.keyring();
      this.cmm = model.cmm();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.encryptionContext = model.encryptionContext();
    }

    public Builder keyring(IKeyring keyring) {
      this.keyring = Keyring.wrap(keyring);
      return this;
    }

    public IKeyring keyring() {
      return this.keyring;
    }

    public Builder cmm(ICryptographicMaterialsManager cmm) {
      this.cmm = CryptographicMaterialsManager.wrap(cmm);
      return this;
    }

    public ICryptographicMaterialsManager cmm() {
      return this.cmm;
    }

    public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
    }

    public Builder encryptionContext(Map<String, String> encryptionContext) {
      this.encryptionContext = encryptionContext;
      return this;
    }

    public Map<String, String> encryptionContext() {
      return this.encryptionContext;
    }

    public JsonEncrypt build() {
      return new JsonEncrypt(this);
    }
  }
}
