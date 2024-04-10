// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;

public class GetEncryptedDataKeyDescriptionOutput {
  private final List<EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput;

  protected GetEncryptedDataKeyDescriptionOutput(BuilderImpl builder) {
    this.EncryptedDataKeyDescriptionOutput = builder.EncryptedDataKeyDescriptionOutput();
  }

  public List<EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput() {
    return this.EncryptedDataKeyDescriptionOutput;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder EncryptedDataKeyDescriptionOutput(
        List<EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput);

    List<EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput();

    GetEncryptedDataKeyDescriptionOutput build();
  }

  static class BuilderImpl implements Builder {
    protected List<EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput;

    protected BuilderImpl() {
    }

    protected BuilderImpl(GetEncryptedDataKeyDescriptionOutput model) {
      this.EncryptedDataKeyDescriptionOutput = model.EncryptedDataKeyDescriptionOutput();
    }

    public Builder EncryptedDataKeyDescriptionOutput(
        List<EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput) {
      this.EncryptedDataKeyDescriptionOutput = EncryptedDataKeyDescriptionOutput;
      return this;
    }

    public List<EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput() {
      return this.EncryptedDataKeyDescriptionOutput;
    }

    public GetEncryptedDataKeyDescriptionOutput build() {
      if (Objects.isNull(this.EncryptedDataKeyDescriptionOutput()))  {
        throw new IllegalArgumentException("Missing value for required field `EncryptedDataKeyDescriptionOutput`");
      }
      return new GetEncryptedDataKeyDescriptionOutput(this);
    }
  }
}
