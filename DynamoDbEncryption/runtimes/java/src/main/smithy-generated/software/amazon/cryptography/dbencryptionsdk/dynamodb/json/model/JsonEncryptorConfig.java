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
  private final Map<String, Action> memberActionsOnEncrypt;

  /**
   * A list of member names such that, if encountered during decryption, those members are treated as unsigned.
   */
  private final List<String> allowedUnsignedMembers;

  /**
   * A prefix such that, if during decryption any member has a name with this prefix, it is treated as unsigned.
   */
  private final String allowedUnsignedMemberPrefix;

  /**
   * Setting for encryption and decryption.
   */
  private final JsonEncrypt encrypt;

  protected JsonEncryptorConfig(BuilderImpl builder) {
    this.domain = builder.domain();
    this.memberActionsOnEncrypt = builder.memberActionsOnEncrypt();
    this.allowedUnsignedMembers = builder.allowedUnsignedMembers();
    this.allowedUnsignedMemberPrefix = builder.allowedUnsignedMemberPrefix();
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
  public Map<String, Action> memberActionsOnEncrypt() {
    return this.memberActionsOnEncrypt;
  }

  /**
   * @return A list of member names such that, if encountered during decryption, those members are treated as unsigned.
   */
  public List<String> allowedUnsignedMembers() {
    return this.allowedUnsignedMembers;
  }

  /**
   * @return A prefix such that, if during decryption any member has a name with this prefix, it is treated as unsigned.
   */
  public String allowedUnsignedMemberPrefix() {
    return this.allowedUnsignedMemberPrefix;
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
     * @param memberActionsOnEncrypt A map that describes which members should be encrypted and/or signed on encrypt.
     */
    Builder memberActionsOnEncrypt(Map<String, Action> memberActionsOnEncrypt);

    /**
     * @return A map that describes which members should be encrypted and/or signed on encrypt.
     */
    Map<String, Action> memberActionsOnEncrypt();

    /**
     * @param allowedUnsignedMembers A list of member names such that, if encountered during decryption, those members are treated as unsigned.
     */
    Builder allowedUnsignedMembers(List<String> allowedUnsignedMembers);

    /**
     * @return A list of member names such that, if encountered during decryption, those members are treated as unsigned.
     */
    List<String> allowedUnsignedMembers();

    /**
     * @param allowedUnsignedMemberPrefix A prefix such that, if during decryption any member has a name with this prefix, it is treated as unsigned.
     */
    Builder allowedUnsignedMemberPrefix(String allowedUnsignedMemberPrefix);

    /**
     * @return A prefix such that, if during decryption any member has a name with this prefix, it is treated as unsigned.
     */
    String allowedUnsignedMemberPrefix();

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

    protected Map<String, Action> memberActionsOnEncrypt;

    protected List<String> allowedUnsignedMembers;

    protected String allowedUnsignedMemberPrefix;

    protected JsonEncrypt encrypt;

    protected BuilderImpl() {}

    protected BuilderImpl(JsonEncryptorConfig model) {
      this.domain = model.domain();
      this.memberActionsOnEncrypt = model.memberActionsOnEncrypt();
      this.allowedUnsignedMembers = model.allowedUnsignedMembers();
      this.allowedUnsignedMemberPrefix = model.allowedUnsignedMemberPrefix();
      this.encrypt = model.encrypt();
    }

    public Builder domain(String domain) {
      this.domain = domain;
      return this;
    }

    public String domain() {
      return this.domain;
    }

    public Builder memberActionsOnEncrypt(
      Map<String, Action> memberActionsOnEncrypt
    ) {
      this.memberActionsOnEncrypt = memberActionsOnEncrypt;
      return this;
    }

    public Map<String, Action> memberActionsOnEncrypt() {
      return this.memberActionsOnEncrypt;
    }

    public Builder allowedUnsignedMembers(List<String> allowedUnsignedMembers) {
      this.allowedUnsignedMembers = allowedUnsignedMembers;
      return this;
    }

    public List<String> allowedUnsignedMembers() {
      return this.allowedUnsignedMembers;
    }

    public Builder allowedUnsignedMemberPrefix(
      String allowedUnsignedMemberPrefix
    ) {
      this.allowedUnsignedMemberPrefix = allowedUnsignedMemberPrefix;
      return this;
    }

    public String allowedUnsignedMemberPrefix() {
      return this.allowedUnsignedMemberPrefix;
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
      if (Objects.isNull(this.memberActionsOnEncrypt())) {
        throw new IllegalArgumentException(
          "Missing value for required field `memberActionsOnEncrypt`"
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
