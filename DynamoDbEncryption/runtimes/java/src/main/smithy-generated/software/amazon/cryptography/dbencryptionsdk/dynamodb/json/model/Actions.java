// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

public class Actions {

  /**
   * A map that describes which members should be encrypted and/or signed on encrypt.
   */
  private final Map<String, CryptoAction> attributeActionsOnEncrypt;

  /**
   * A map that provides Actions for sub-objects.
   */
  private final Map<String, Actions> nestedActionsOnEncrypt;

  /**
   * Separate encryption of sub-objects, each getting their own header and footer.
   */
  private final Map<String, JsonEncryptorConfig> nestedEncryptors;

  /**
   * A map that allows separate encryption of individual values.
   */
  private final Map<String, KeyAccess> eSDKActions;

  /**
   * What to do with actions not explicitly mentioned in attributeActionsOnEncrypt.
   */
  private final DefaultAction defaultAction;

  protected Actions(BuilderImpl builder) {
    this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt();
    this.nestedActionsOnEncrypt = builder.nestedActionsOnEncrypt();
    this.nestedEncryptors = builder.nestedEncryptors();
    this.eSDKActions = builder.eSDKActions();
    this.defaultAction = builder.defaultAction();
  }

  /**
   * @return A map that describes which members should be encrypted and/or signed on encrypt.
   */
  public Map<String, CryptoAction> attributeActionsOnEncrypt() {
    return this.attributeActionsOnEncrypt;
  }

  /**
   * @return A map that provides Actions for sub-objects.
   */
  public Map<String, Actions> nestedActionsOnEncrypt() {
    return this.nestedActionsOnEncrypt;
  }

  /**
   * @return Separate encryption of sub-objects, each getting their own header and footer.
   */
  public Map<String, JsonEncryptorConfig> nestedEncryptors() {
    return this.nestedEncryptors;
  }

  /**
   * @return A map that allows separate encryption of individual values.
   */
  public Map<String, KeyAccess> eSDKActions() {
    return this.eSDKActions;
  }

  /**
   * @return What to do with actions not explicitly mentioned in attributeActionsOnEncrypt.
   */
  public DefaultAction defaultAction() {
    return this.defaultAction;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param attributeActionsOnEncrypt A map that describes which members should be encrypted and/or signed on encrypt.
     */
    Builder attributeActionsOnEncrypt(
      Map<String, CryptoAction> attributeActionsOnEncrypt
    );

    /**
     * @return A map that describes which members should be encrypted and/or signed on encrypt.
     */
    Map<String, CryptoAction> attributeActionsOnEncrypt();

    /**
     * @param nestedActionsOnEncrypt A map that provides Actions for sub-objects.
     */
    Builder nestedActionsOnEncrypt(Map<String, Actions> nestedActionsOnEncrypt);

    /**
     * @return A map that provides Actions for sub-objects.
     */
    Map<String, Actions> nestedActionsOnEncrypt();

    /**
     * @param nestedEncryptors Separate encryption of sub-objects, each getting their own header and footer.
     */
    Builder nestedEncryptors(Map<String, JsonEncryptorConfig> nestedEncryptors);

    /**
     * @return Separate encryption of sub-objects, each getting their own header and footer.
     */
    Map<String, JsonEncryptorConfig> nestedEncryptors();

    /**
     * @param eSDKActions A map that allows separate encryption of individual values.
     */
    Builder eSDKActions(Map<String, KeyAccess> eSDKActions);

    /**
     * @return A map that allows separate encryption of individual values.
     */
    Map<String, KeyAccess> eSDKActions();

    /**
     * @param defaultAction What to do with actions not explicitly mentioned in attributeActionsOnEncrypt.
     */
    Builder defaultAction(DefaultAction defaultAction);

    /**
     * @return What to do with actions not explicitly mentioned in attributeActionsOnEncrypt.
     */
    DefaultAction defaultAction();

    Actions build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, CryptoAction> attributeActionsOnEncrypt;

    protected Map<String, Actions> nestedActionsOnEncrypt;

    protected Map<String, JsonEncryptorConfig> nestedEncryptors;

    protected Map<String, KeyAccess> eSDKActions;

    protected DefaultAction defaultAction;

    protected BuilderImpl() {}

    protected BuilderImpl(Actions model) {
      this.attributeActionsOnEncrypt = model.attributeActionsOnEncrypt();
      this.nestedActionsOnEncrypt = model.nestedActionsOnEncrypt();
      this.nestedEncryptors = model.nestedEncryptors();
      this.eSDKActions = model.eSDKActions();
      this.defaultAction = model.defaultAction();
    }

    public Builder attributeActionsOnEncrypt(
      Map<String, CryptoAction> attributeActionsOnEncrypt
    ) {
      this.attributeActionsOnEncrypt = attributeActionsOnEncrypt;
      return this;
    }

    public Map<String, CryptoAction> attributeActionsOnEncrypt() {
      return this.attributeActionsOnEncrypt;
    }

    public Builder nestedActionsOnEncrypt(
      Map<String, Actions> nestedActionsOnEncrypt
    ) {
      this.nestedActionsOnEncrypt = nestedActionsOnEncrypt;
      return this;
    }

    public Map<String, Actions> nestedActionsOnEncrypt() {
      return this.nestedActionsOnEncrypt;
    }

    public Builder nestedEncryptors(
      Map<String, JsonEncryptorConfig> nestedEncryptors
    ) {
      this.nestedEncryptors = nestedEncryptors;
      return this;
    }

    public Map<String, JsonEncryptorConfig> nestedEncryptors() {
      return this.nestedEncryptors;
    }

    public Builder eSDKActions(Map<String, KeyAccess> eSDKActions) {
      this.eSDKActions = eSDKActions;
      return this;
    }

    public Map<String, KeyAccess> eSDKActions() {
      return this.eSDKActions;
    }

    public Builder defaultAction(DefaultAction defaultAction) {
      this.defaultAction = defaultAction;
      return this;
    }

    public DefaultAction defaultAction() {
      return this.defaultAction;
    }

    public Actions build() {
      if (Objects.isNull(this.attributeActionsOnEncrypt())) {
        throw new IllegalArgumentException(
          "Missing value for required field `attributeActionsOnEncrypt`"
        );
      }
      return new Actions(this);
    }
  }
}
