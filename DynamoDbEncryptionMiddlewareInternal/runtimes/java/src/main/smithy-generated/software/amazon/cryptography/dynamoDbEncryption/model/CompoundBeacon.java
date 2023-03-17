// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.List;
import java.util.Objects;

public class CompoundBeacon {
  private final String name;

  private final String split;

  private final List<SensitivePart> sensitive;

  private final List<NonSensitivePart> nonSensitive;

  private final List<Constructor> constructors;

  protected CompoundBeacon(BuilderImpl builder) {
    this.name = builder.name();
    this.split = builder.split();
    this.sensitive = builder.sensitive();
    this.nonSensitive = builder.nonSensitive();
    this.constructors = builder.constructors();
  }

  public String name() {
    return this.name;
  }

  public String split() {
    return this.split;
  }

  public List<SensitivePart> sensitive() {
    return this.sensitive;
  }

  public List<NonSensitivePart> nonSensitive() {
    return this.nonSensitive;
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

    Builder sensitive(List<SensitivePart> sensitive);

    List<SensitivePart> sensitive();

    Builder nonSensitive(List<NonSensitivePart> nonSensitive);

    List<NonSensitivePart> nonSensitive();

    Builder constructors(List<Constructor> constructors);

    List<Constructor> constructors();

    CompoundBeacon build();
  }

  static class BuilderImpl implements Builder {
    protected String name;

    protected String split;

    protected List<SensitivePart> sensitive;

    protected List<NonSensitivePart> nonSensitive;

    protected List<Constructor> constructors;

    protected BuilderImpl() {
    }

    protected BuilderImpl(CompoundBeacon model) {
      this.name = model.name();
      this.split = model.split();
      this.sensitive = model.sensitive();
      this.nonSensitive = model.nonSensitive();
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

    public Builder sensitive(List<SensitivePart> sensitive) {
      this.sensitive = sensitive;
      return this;
    }

    public List<SensitivePart> sensitive() {
      return this.sensitive;
    }

    public Builder nonSensitive(List<NonSensitivePart> nonSensitive) {
      this.nonSensitive = nonSensitive;
      return this;
    }

    public List<NonSensitivePart> nonSensitive() {
      return this.nonSensitive;
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
      if (Objects.isNull(this.sensitive()))  {
        throw new IllegalArgumentException("Missing value for required field `sensitive`");
      }
      return new CompoundBeacon(this);
    }
  }
}
