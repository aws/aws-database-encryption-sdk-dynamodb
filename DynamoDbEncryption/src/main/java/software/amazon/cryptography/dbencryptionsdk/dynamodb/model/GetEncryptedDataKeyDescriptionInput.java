// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

/**
 * Input for getting encrypted data key description.
 */
public class GetEncryptedDataKeyDescriptionInput {

  private final GetEncryptedDataKeyDescriptionUnion input;

  protected GetEncryptedDataKeyDescriptionInput(BuilderImpl builder) {
    this.input = builder.input();
  }

  public GetEncryptedDataKeyDescriptionUnion input() {
    return this.input;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder input(GetEncryptedDataKeyDescriptionUnion input);

    GetEncryptedDataKeyDescriptionUnion input();

    GetEncryptedDataKeyDescriptionInput build();
  }

  static class BuilderImpl implements Builder {

    protected GetEncryptedDataKeyDescriptionUnion input;

    protected BuilderImpl() {}

    protected BuilderImpl(GetEncryptedDataKeyDescriptionInput model) {
      this.input = model.input();
    }

    public Builder input(GetEncryptedDataKeyDescriptionUnion input) {
      this.input = input;
      return this;
    }

    public GetEncryptedDataKeyDescriptionUnion input() {
      return this.input;
    }

    public GetEncryptedDataKeyDescriptionInput build() {
      if (Objects.isNull(this.input())) {
        throw new IllegalArgumentException(
          "Missing value for required field `input`"
        );
      }
      return new GetEncryptedDataKeyDescriptionInput(this);
    }
  }
}
