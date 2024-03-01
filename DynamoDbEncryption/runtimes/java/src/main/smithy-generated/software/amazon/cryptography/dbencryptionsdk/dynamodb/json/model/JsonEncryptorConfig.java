// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The configuration for the client-side encryption of JSON objects.
 */
public class JsonEncryptorConfig {

  /**
   * The is the name that is cryptographically bound with your data.
   */
  private final String domain;

  /**
   * A map that describes which members should be encrypted and/or signed on encrypt.
   */
  private final Map<String, Action> attributeActionsOnEncrypt;

  /**
   * A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
   */
  private final List<String> allowedUnsignedAttributes;

  /**
   * A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
   */
  private final String allowedUnsignedAttributePrefix;

  /**
   * Setting for encryption and decryption.
   */
  private final JsonEncrypt encrypt;

  protected JsonEncryptorConfig(BuilderImpl builder) {
    this.domain = builder.domain();
    this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt();
    this.allowedUnsignedAttributes = builder.allowedUnsignedAttributes();
    this.allowedUnsignedAttributePrefix =
      builder.allowedUnsignedAttributePrefix();
    this.encrypt = builder.encrypt();
  }

  /**
   * @return The is the name that is cryptographically bound with your data.
   */
  public String domain() {
    return this.domain;
  }

  /**
   * @return A map that describes which members should be encrypted and/or signed on encrypt.
   */
  public Map<String, Action> attributeActionsOnEncrypt() {
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
   * @return Setting for encryption and decryption.
   */
  public JsonEncrypt encrypt() {
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
     * @param domain The is the name that is cryptographically bound with your data.
     */
    Builder domain(String domain);

    /**
     * @return The is the name that is cryptographically bound with your data.
     */
    String domain();

    /**
     * @param attributeActionsOnEncrypt A map that describes which members should be encrypted and/or signed on encrypt.
     */
    Builder attributeActionsOnEncrypt(
      Map<String, Action> attributeActionsOnEncrypt
    );

    /**
     * @return A map that describes which members should be encrypted and/or signed on encrypt.
     */
    Map<String, Action> attributeActionsOnEncrypt();

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
    Builder allowedUnsignedAttributePrefix(
      String allowedUnsignedAttributePrefix
    );

    /**
     * @return A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
     */
    String allowedUnsignedAttributePrefix();

    /**
     * @param encrypt Setting for encryption and decryption.
     */
    Builder encrypt(JsonEncrypt encrypt);

    /**
     * @return Setting for encryption and decryption.
     */
    JsonEncrypt encrypt();

    JsonEncryptorConfig build();
  }

  static class BuilderImpl implements Builder {

    protected String domain;

    protected Map<String, Action> attributeActionsOnEncrypt;

    protected List<String> allowedUnsignedAttributes;

    protected String allowedUnsignedAttributePrefix;

    protected JsonEncrypt encrypt;

    protected BuilderImpl() {}

    protected BuilderImpl(JsonEncryptorConfig model) {
      this.domain = model.domain();
      this.attributeActionsOnEncrypt = model.attributeActionsOnEncrypt();
      this.allowedUnsignedAttributes = model.allowedUnsignedAttributes();
      this.allowedUnsignedAttributePrefix =
        model.allowedUnsignedAttributePrefix();
      this.encrypt = model.encrypt();
    }

    public Builder domain(String domain) {
      this.domain = domain;
      return this;
    }

    public String domain() {
      return this.domain;
    }

    public Builder attributeActionsOnEncrypt(
      Map<String, Action> attributeActionsOnEncrypt
    ) {
      this.attributeActionsOnEncrypt = attributeActionsOnEncrypt;
      return this;
    }

    public Map<String, Action> attributeActionsOnEncrypt() {
      return this.attributeActionsOnEncrypt;
    }

    public Builder allowedUnsignedAttributes(
      List<String> allowedUnsignedAttributes
    ) {
      this.allowedUnsignedAttributes = allowedUnsignedAttributes;
      return this;
    }

    public List<String> allowedUnsignedAttributes() {
      return this.allowedUnsignedAttributes;
    }

    public Builder allowedUnsignedAttributePrefix(
      String allowedUnsignedAttributePrefix
    ) {
      this.allowedUnsignedAttributePrefix = allowedUnsignedAttributePrefix;
      return this;
    }

    public String allowedUnsignedAttributePrefix() {
      return this.allowedUnsignedAttributePrefix;
    }

    public Builder encrypt(JsonEncrypt encrypt) {
      this.encrypt = encrypt;
      return this;
    }

    public JsonEncrypt encrypt() {
      return this.encrypt;
    }

    public JsonEncryptorConfig build() {
      if (Objects.isNull(this.domain())) {
        throw new IllegalArgumentException(
          "Missing value for required field `domain`"
        );
      }
      if (Objects.isNull(this.attributeActionsOnEncrypt())) {
        throw new IllegalArgumentException(
          "Missing value for required field `attributeActionsOnEncrypt`"
        );
      }
      if (Objects.isNull(this.encrypt())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encrypt`"
        );
      }
      return new JsonEncryptorConfig(this);
    }
  }
}
