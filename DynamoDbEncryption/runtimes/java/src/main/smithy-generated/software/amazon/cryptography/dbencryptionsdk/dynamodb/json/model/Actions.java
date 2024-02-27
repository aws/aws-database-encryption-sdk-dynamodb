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
   * What to do with actions not explicitly mentioned in attributeActionsOnEncrypt.
   */
  private final DefaultAction defaultAction;

  protected Actions(BuilderImpl builder) {
    this.attributeActionsOnEncrypt = builder.attributeActionsOnEncrypt();
    this.nestedActionsOnEncrypt = builder.nestedActionsOnEncrypt();
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

    protected DefaultAction defaultAction;

    protected BuilderImpl() {}

    protected BuilderImpl(Actions model) {
      this.attributeActionsOnEncrypt = model.attributeActionsOnEncrypt();
      this.nestedActionsOnEncrypt = model.nestedActionsOnEncrypt();
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
