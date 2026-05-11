// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internal.DynamoDbItemEncryptorImpl;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;

public class DynamoDbItemEncryptor {

  private final DynamoDbItemEncryptorImpl impl;

  protected DynamoDbItemEncryptor(BuilderImpl builder) {
    DynamoDbItemEncryptorConfig config = builder.DynamoDbItemEncryptorConfig();
    // Use provided CMM, or construct default CMM from keyring
    ICryptographicMaterialsManager cmm = config.cmm();
    if (cmm == null && config.keyring() != null) {
      software.amazon.cryptography.materialproviders.MaterialProviders mpl =
        software.amazon.cryptography.materialproviders.MaterialProviders.builder()
          .MaterialProvidersConfig(software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig.builder().build())
          .build();
      cmm = mpl.CreateDefaultCryptographicMaterialsManager(
        software.amazon.cryptography.materialproviders.model.CreateDefaultCryptographicMaterialsManagerInput.builder()
          .keyring(config.keyring())
          .build());
    }
    if (cmm == null) {
      throw new IllegalArgumentException("Either a CMM or Keyring must be provided.");
    }
    this.impl = new DynamoDbItemEncryptorImpl(config, cmm);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public DecryptItemOutput DecryptItem(DecryptItemInput input) {
    return impl.decryptItem(input);
  }

  public EncryptItemOutput EncryptItem(EncryptItemInput input) {
    return impl.encryptItem(input);
  }

  public interface Builder {
    Builder DynamoDbItemEncryptorConfig(DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig);
    DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig();
    DynamoDbItemEncryptor build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig;

    protected BuilderImpl() {}

    public Builder DynamoDbItemEncryptorConfig(DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig) {
      this.DynamoDbItemEncryptorConfig = DynamoDbItemEncryptorConfig;
      return this;
    }

    public DynamoDbItemEncryptorConfig DynamoDbItemEncryptorConfig() {
      return this.DynamoDbItemEncryptorConfig;
    }

    public DynamoDbItemEncryptor build() {
      if (Objects.isNull(this.DynamoDbItemEncryptorConfig())) {
        throw new IllegalArgumentException(
          "Missing value for required field `DynamoDbItemEncryptorConfig`"
        );
      }
      return new DynamoDbItemEncryptor(this);
    }
  }
}
