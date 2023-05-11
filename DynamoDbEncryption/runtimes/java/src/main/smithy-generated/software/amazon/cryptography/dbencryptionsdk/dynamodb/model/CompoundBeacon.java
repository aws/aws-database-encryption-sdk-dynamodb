// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;

public class CompoundBeacon {
  private final String name;

  private final String split;

  private final List<EncryptedPart> encrypted;

  private final List<SignedPart> signed;

  private final List<Constructor> constructors;

  protected CompoundBeacon(BuilderImpl builder) {
    this.name = builder.name();
    this.split = builder.split();
    this.encrypted = builder.encrypted();
    this.signed = builder.signed();
    this.constructors = builder.constructors();
  }

  public String name() {
    return this.name;
  }

  public String split() {
    return this.split;
  }

  public List<EncryptedPart> encrypted() {
    return this.encrypted;
  }

  public List<SignedPart> signed() {
    return this.signed;
  }

  public List<Constructor> constructors() {
    return this.constructors;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder name(String name);

    String name();

    Builder split(String split);

    String split();

    Builder encrypted(List<EncryptedPart> encrypted);

    List<EncryptedPart> encrypted();

    Builder signed(List<SignedPart> signed);

    List<SignedPart> signed();

    Builder constructors(List<Constructor> constructors);

    List<Constructor> constructors();

    CompoundBeacon build();
  }

  static class BuilderImpl implements Builder {
    protected String name;

    protected String split;

    protected List<EncryptedPart> encrypted;

    protected List<SignedPart> signed;

    protected List<Constructor> constructors;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CompoundBeacon model) {
      this.name = model.name();
      this.split = model.split();
      this.encrypted = model.encrypted();
      this.signed = model.signed();
      this.constructors = model.constructors();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public String name() {
      return this.name;
    }

    public Builder split(String split) {
      this.split = split;
      return this;
    }

    public String split() {
      return this.split;
    }

    public Builder encrypted(List<EncryptedPart> encrypted) {
      this.encrypted = encrypted;
      return this;
    }

    public List<EncryptedPart> encrypted() {
      return this.encrypted;
    }

    public Builder signed(List<SignedPart> signed) {
      this.signed = signed;
      return this;
    }

    public List<SignedPart> signed() {
      return this.signed;
    }

    public Builder constructors(List<Constructor> constructors) {
      this.constructors = constructors;
      return this;
    }

    public List<Constructor> constructors() {
      return this.constructors;
    }

    public CompoundBeacon build() {
      if (Objects.isNull(this.name()))  {
        throw new IllegalArgumentException("Missing value for required field `name`");
      }
      if (Objects.isNull(this.split()))  {
        throw new IllegalArgumentException("Missing value for required field `split`");
      }
      if (Objects.nonNull(this.split()) && this.split().length() < 1) {
        throw new IllegalArgumentException("The size of `split` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.split()) && this.split().length() > 1) {
        throw new IllegalArgumentException("The size of `split` must be less than or equal to 1");
      }
      if (Objects.nonNull(this.encrypted()) && this.encrypted().size() < 1) {
        throw new IllegalArgumentException("The size of `encrypted` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.signed()) && this.signed().size() < 1) {
        throw new IllegalArgumentException("The size of `signed` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.constructors()) && this.constructors().size() < 1) {
        throw new IllegalArgumentException("The size of `constructors` must be greater than or equal to 1");
      }
      return new CompoundBeacon(this);
    }
  }
}
