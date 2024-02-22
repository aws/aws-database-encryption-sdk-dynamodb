// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.List;

public class ExplicitUnsigned {

  /**
   * A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
   */
  private final List<String> allowedUnsignedAttributes;

  /**
   * A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
   */
  private final String allowedUnsignedAttributePrefix;

  protected ExplicitUnsigned(BuilderImpl builder) {
    this.allowedUnsignedAttributes = builder.allowedUnsignedAttributes();
    this.allowedUnsignedAttributePrefix =
      builder.allowedUnsignedAttributePrefix();
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

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
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

    ExplicitUnsigned build();
  }

  static class BuilderImpl implements Builder {

    protected List<String> allowedUnsignedAttributes;

    protected String allowedUnsignedAttributePrefix;

    protected BuilderImpl() {}

    protected BuilderImpl(ExplicitUnsigned model) {
      this.allowedUnsignedAttributes = model.allowedUnsignedAttributes();
      this.allowedUnsignedAttributePrefix =
        model.allowedUnsignedAttributePrefix();
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

    public ExplicitUnsigned build() {
      return new ExplicitUnsigned(this);
    }
  }
}
