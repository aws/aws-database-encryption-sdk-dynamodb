// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.resources.model;

public class DynamoDbEncryptionResourcesConfig {
  protected DynamoDbEncryptionResourcesConfig(BuilderImpl builder) {
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    DynamoDbEncryptionResourcesConfig build();
  }

  static class BuilderImpl implements Builder {
    protected BuilderImpl() {
    }

    protected BuilderImpl(DynamoDbEncryptionResourcesConfig model) {
    }

    public DynamoDbEncryptionResourcesConfig build() {
      return new DynamoDbEncryptionResourcesConfig(this);
    }
  }
}
