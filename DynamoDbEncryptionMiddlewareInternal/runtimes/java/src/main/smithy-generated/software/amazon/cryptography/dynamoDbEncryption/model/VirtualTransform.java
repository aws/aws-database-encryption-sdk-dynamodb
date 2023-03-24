// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.List;
import java.util.Objects;

public class VirtualTransform {
  private final Transform transform;

  private final List<Integer> numbers;

  private final List<String> strings;

  protected VirtualTransform(BuilderImpl builder) {
    this.transform = builder.transform();
    this.numbers = builder.numbers();
    this.strings = builder.strings();
  }

  public Transform transform() {
    return this.transform;
  }

  public List<Integer> numbers() {
    return this.numbers;
  }

  public List<String> strings() {
    return this.strings;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder transform(Transform transform);

    Transform transform();

    Builder numbers(List<Integer> numbers);

    List<Integer> numbers();

    Builder strings(List<String> strings);

    List<String> strings();

    VirtualTransform build();
  }

  static class BuilderImpl implements Builder {
    protected Transform transform;

    protected List<Integer> numbers;

    protected List<String> strings;

    protected BuilderImpl() {
    }

    protected BuilderImpl(VirtualTransform model) {
      this.transform = model.transform();
      this.numbers = model.numbers();
      this.strings = model.strings();
    }

    public Builder transform(Transform transform) {
      this.transform = transform;
      return this;
    }

    public Transform transform() {
      return this.transform;
    }

    public Builder numbers(List<Integer> numbers) {
      this.numbers = numbers;
      return this;
    }

    public List<Integer> numbers() {
      return this.numbers;
    }

    public Builder strings(List<String> strings) {
      this.strings = strings;
      return this;
    }

    public List<String> strings() {
      return this.strings;
    }

    public VirtualTransform build() {
      if (Objects.isNull(this.transform()))  {
        throw new IllegalArgumentException("Missing value for required field `transform`");
      }
      if (Objects.nonNull(this.numbers()) && this.numbers().size() < 1) {
        throw new IllegalArgumentException("The size of `numbers` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.strings()) && this.strings().size() < 1) {
        throw new IllegalArgumentException("The size of `strings` must be greater than or equal to 1");
      }
      return new VirtualTransform(this);
    }
  }
}
