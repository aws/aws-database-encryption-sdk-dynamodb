// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;

/**
 * A parsed version of the header that was written with or read on an encrypted Json object.
 */
public class ParsedHeader {

  /**
   * The non-DO_NOTHING Crypto Actions that were configured when this object was originally encrypted.
   */
  private final Map<String, Action> memberActionsOnEncrypt;

  /**
   * The ID of the algorithm suite that was used to encrypt this object.
   */
  private final DBEAlgorithmSuiteId algorithmSuiteId;

  /**
   * The encrypted data keys that are stored in the header of this object.
   */
  private final List<EncryptedDataKey> encryptedDataKeys;

  /**
   * The portion of the encryption context that was stored in the header of this object.
   */
  private final Map<String, String> storedEncryptionContext;

  /**
   * The full encryption context.
   */
  private final Map<String, String> encryptionContext;

  protected ParsedHeader(BuilderImpl builder) {
    this.memberActionsOnEncrypt = builder.memberActionsOnEncrypt();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.encryptedDataKeys = builder.encryptedDataKeys();
    this.storedEncryptionContext = builder.storedEncryptionContext();
    this.encryptionContext = builder.encryptionContext();
  }

  /**
   * @return The non-DO_NOTHING Crypto Actions that were configured when this object was originally encrypted.
   */
  public Map<String, Action> memberActionsOnEncrypt() {
    return this.memberActionsOnEncrypt;
  }

  /**
   * @return The ID of the algorithm suite that was used to encrypt this object.
   */
  public DBEAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  /**
   * @return The encrypted data keys that are stored in the header of this object.
   */
  public List<EncryptedDataKey> encryptedDataKeys() {
    return this.encryptedDataKeys;
  }

  /**
   * @return The portion of the encryption context that was stored in the header of this object.
   */
  public Map<String, String> storedEncryptionContext() {
    return this.storedEncryptionContext;
  }

  /**
   * @return The full encryption context.
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
     * @param memberActionsOnEncrypt The non-DO_NOTHING Crypto Actions that were configured when this object was originally encrypted.
     */
    Builder memberActionsOnEncrypt(Map<String, Action> memberActionsOnEncrypt);

    /**
     * @return The non-DO_NOTHING Crypto Actions that were configured when this object was originally encrypted.
     */
    Map<String, Action> memberActionsOnEncrypt();

    /**
     * @param algorithmSuiteId The ID of the algorithm suite that was used to encrypt this object.
     */
    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);

    /**
     * @return The ID of the algorithm suite that was used to encrypt this object.
     */
    DBEAlgorithmSuiteId algorithmSuiteId();

    /**
     * @param encryptedDataKeys The encrypted data keys that are stored in the header of this object.
     */
    Builder encryptedDataKeys(List<EncryptedDataKey> encryptedDataKeys);

    /**
     * @return The encrypted data keys that are stored in the header of this object.
     */
    List<EncryptedDataKey> encryptedDataKeys();

    /**
     * @param storedEncryptionContext The portion of the encryption context that was stored in the header of this object.
     */
    Builder storedEncryptionContext(
      Map<String, String> storedEncryptionContext
    );

    /**
     * @return The portion of the encryption context that was stored in the header of this object.
     */
    Map<String, String> storedEncryptionContext();

    /**
     * @param encryptionContext The full encryption context.
     */
    Builder encryptionContext(Map<String, String> encryptionContext);

    /**
     * @return The full encryption context.
     */
    Map<String, String> encryptionContext();

    ParsedHeader build();
  }

  static class BuilderImpl implements Builder {

    protected Map<String, Action> memberActionsOnEncrypt;

    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected List<EncryptedDataKey> encryptedDataKeys;

    protected Map<String, String> storedEncryptionContext;

    protected Map<String, String> encryptionContext;

    protected BuilderImpl() {}

    protected BuilderImpl(ParsedHeader model) {
      this.memberActionsOnEncrypt = model.memberActionsOnEncrypt();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.encryptedDataKeys = model.encryptedDataKeys();
      this.storedEncryptionContext = model.storedEncryptionContext();
      this.encryptionContext = model.encryptionContext();
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

    public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
    }

    public Builder encryptedDataKeys(List<EncryptedDataKey> encryptedDataKeys) {
      this.encryptedDataKeys = encryptedDataKeys;
      return this;
    }

    public List<EncryptedDataKey> encryptedDataKeys() {
      return this.encryptedDataKeys;
    }

    public Builder storedEncryptionContext(
      Map<String, String> storedEncryptionContext
    ) {
      this.storedEncryptionContext = storedEncryptionContext;
      return this;
    }

    public Map<String, String> storedEncryptionContext() {
      return this.storedEncryptionContext;
    }

    public Builder encryptionContext(Map<String, String> encryptionContext) {
      this.encryptionContext = encryptionContext;
      return this;
    }

    public Map<String, String> encryptionContext() {
      return this.encryptionContext;
    }

    public ParsedHeader build() {
      if (Objects.isNull(this.memberActionsOnEncrypt())) {
        throw new IllegalArgumentException(
          "Missing value for required field `memberActionsOnEncrypt`"
        );
      }
      if (Objects.isNull(this.algorithmSuiteId())) {
        throw new IllegalArgumentException(
          "Missing value for required field `algorithmSuiteId`"
        );
      }
      if (Objects.isNull(this.encryptedDataKeys())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptedDataKeys`"
        );
      }
      if (Objects.isNull(this.storedEncryptionContext())) {
        throw new IllegalArgumentException(
          "Missing value for required field `storedEncryptionContext`"
        );
      }
      if (Objects.isNull(this.encryptionContext())) {
        throw new IllegalArgumentException(
          "Missing value for required field `encryptionContext`"
        );
      }
      return new ParsedHeader(this);
    }
  }
}
