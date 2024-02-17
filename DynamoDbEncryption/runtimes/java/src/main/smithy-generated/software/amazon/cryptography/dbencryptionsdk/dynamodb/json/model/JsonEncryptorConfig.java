// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.Keyring;
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
   * A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
   */
  private final Map<String, CryptoAction> attributeActionsOnEncrypt;

  /**
   * A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
   */
  private final List<String> allowedUnsignedAttributes;

  /**
   * A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
   */
  private final String allowedUnsignedAttributePrefix;

  /**
   * An ID for the algorithm suite to use during encryption and decryption.
   */
  private final DBEAlgorithmSuiteId algorithmSuiteId;

  /**
   * The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  private final IKeyring keyring;

  /**
   * The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
   */
  private final ICryptographicMaterialsManager cmm;

  protected JsonEncryptorConfig(BuilderImpl builder) {
    this.logicalTableName = builder.logicalTableName();
    this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt();
    this.allowedUnsignedAttributes = builder.allowedUnsignedAttributes();
    this.allowedUnsignedAttributePrefix = builder.allowedUnsignedAttributePrefix();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
  }

  /**
   * @return The logical table name for this table. This is the name that is cryptographically bound with your data.
   */
  public String logicalTableName() {
    return this.logicalTableName;
  }

  /**
   * @return A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
   */
  public Map<String, CryptoAction> attributeActionsOnEncrypt() {
    return this.attributeActionsOnEncrypt;
  }

  /**
   * @return A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
   */
  public List<String> allowedUnsignedAttributes() {
    return this.allowedUnsignedAttributes;
  }

  /**
   * @return A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
   */
  public String allowedUnsignedAttributePrefix() {
    return this.allowedUnsignedAttributePrefix;
  }

  /**
   * @return An ID for the algorithm suite to use during encryption and decryption.
   */
  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
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
     * @param attributeActionsOnEncrypt A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
     */
    Builder attributeActionsOnEncrypt(Map<String, CryptoAction> attributeActionsOnEncrypt);

    /**
     * @return A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
     */
    Map<String, CryptoAction> attributeActionsOnEncrypt();

    /**
     * @param allowedUnsignedAttributes A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
     */
    Builder allowedUnsignedAttributes(List<String> allowedUnsignedAttributes);

    /**
     * @return A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
     */
    List<String> allowedUnsignedAttributes();

    /**
     * @param allowedUnsignedAttributePrefix A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
     */
    Builder allowedUnsignedAttributePrefix(String allowedUnsignedAttributePrefix);

    /**
     * @return A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
     */
    String allowedUnsignedAttributePrefix();

    /**
     * @param algorithmSuiteId An ID for the algorithm suite to use during encryption and decryption.
     */
    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    /**
     * @return An ID for the algorithm suite to use during encryption and decryption.
     */
    DBEAlgorithmSuiteId algorithmSuiteId();

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

    JsonEncryptorConfig build();
  }

  static class BuilderImpl implements Builder {
    protected String logicalTableName;

    protected Map<String, CryptoAction> attributeActionsOnEncrypt;

    protected List<String> allowedUnsignedAttributes;

    protected String allowedUnsignedAttributePrefix;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected IKeyring keyring;

    protected ICryptographicMaterialsManager cmm;

    protected BuilderImpl() {
    }

    protected BuilderImpl(JsonEncryptorConfig model) {
      this.logicalTableName = model.logicalTableName();
      this.attributeActionsOnEncrypt = model.attributeActionsOnEncrypt();
      this.allowedUnsignedAttributes = model.allowedUnsignedAttributes();
      this.allowedUnsignedAttributePrefix = model.allowedUnsignedAttributePrefix();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.keyring = model.keyring();
      this.cmm = model.cmm();
    }

    public Builder logicalTableName(String logicalTableName) {
      this.logicalTableName = logicalTableName;
      return this;
    }

    public String logicalTableName() {
      return this.logicalTableName;
    }

    public Builder attributeActionsOnEncrypt(Map<String, CryptoAction> attributeActionsOnEncrypt) {
      this.attributeActionsOnEncrypt = attributeActionsOnEncrypt;
      return this;
    }

    public Map<String, CryptoAction> attributeActionsOnEncrypt() {
      return this.attributeActionsOnEncrypt;
    }

    public Builder allowedUnsignedAttributes(List<String> allowedUnsignedAttributes) {
      this.allowedUnsignedAttributes = allowedUnsignedAttributes;
      return this;
    }

    public List<String> allowedUnsignedAttributes() {
      return this.allowedUnsignedAttributes;
    }

    public Builder allowedUnsignedAttributePrefix(String allowedUnsignedAttributePrefix) {
      this.allowedUnsignedAttributePrefix = allowedUnsignedAttributePrefix;
      return this;
    }

    public String allowedUnsignedAttributePrefix() {
      return this.allowedUnsignedAttributePrefix;
    }

    public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
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

    public JsonEncryptorConfig build() {
      if (Objects.isNull(this.logicalTableName()))  {
        throw new IllegalArgumentException("Missing value for required field `logicalTableName`");
      }
      if (Objects.isNull(this.attributeActionsOnEncrypt()))  {
        throw new IllegalArgumentException("Missing value for required field `attributeActionsOnEncrypt`");
      }
      return new JsonEncryptorConfig(this);
    }
  }
}
