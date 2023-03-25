// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class VirtualTransform {
  private final Upper upper;

  private final Lower lower;

  private final Insert insert;

  private final PrefixTrans prefix;

  private final Suffix suffix;

  private final Substring substring;

  private final Segment segment;

  protected VirtualTransform(BuilderImpl builder) {
    this.upper = builder.upper();
    this.lower = builder.lower();
    this.insert = builder.insert();
    this.prefix = builder.prefix();
    this.suffix = builder.suffix();
    this.substring = builder.substring();
    this.segment = builder.segment();
  }

  public Upper upper() {
    return this.upper;
  }

  public Lower lower() {
    return this.lower;
  }

  public Insert insert() {
    return this.insert;
  }

  public PrefixTrans prefix() {
    return this.prefix;
  }

  public Suffix suffix() {
    return this.suffix;
  }

  public Substring substring() {
    return this.substring;
  }

  public Segment segment() {
    return this.segment;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder upper(Upper upper);

    Upper upper();

    Builder lower(Lower lower);

    Lower lower();

    Builder insert(Insert insert);

    Insert insert();

    Builder prefix(PrefixTrans prefix);

    PrefixTrans prefix();

    Builder suffix(Suffix suffix);

    Suffix suffix();

    Builder substring(Substring substring);

    Substring substring();

    Builder segment(Segment segment);

    Segment segment();

    VirtualTransform build();
  }

  static class BuilderImpl implements Builder {
    protected Upper upper;

    protected Lower lower;

    protected Insert insert;

    protected PrefixTrans prefix;

    protected Suffix suffix;

    protected Substring substring;

    protected Segment segment;

    protected BuilderImpl() {
    }

    protected BuilderImpl(VirtualTransform model) {
      this.upper = model.upper();
      this.lower = model.lower();
      this.insert = model.insert();
      this.prefix = model.prefix();
      this.suffix = model.suffix();
      this.substring = model.substring();
      this.segment = model.segment();
    }

    public Builder upper(Upper upper) {
      this.upper = upper;
      return this;
    }

    public Upper upper() {
      return this.upper;
    }

    public Builder lower(Lower lower) {
      this.lower = lower;
      return this;
    }

    public Lower lower() {
      return this.lower;
    }

    public Builder insert(Insert insert) {
      this.insert = insert;
      return this;
    }

    public Insert insert() {
      return this.insert;
    }

    public Builder prefix(PrefixTrans prefix) {
      this.prefix = prefix;
      return this;
    }

    public PrefixTrans prefix() {
      return this.prefix;
    }

    public Builder suffix(Suffix suffix) {
      this.suffix = suffix;
      return this;
    }

    public Suffix suffix() {
      return this.suffix;
    }

    public Builder substring(Substring substring) {
      this.substring = substring;
      return this;
    }

    public Substring substring() {
      return this.substring;
    }

    public Builder segment(Segment segment) {
      this.segment = segment;
      return this;
    }

    public Segment segment() {
      return this.segment;
    }

    public VirtualTransform build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException("`VirtualTransform` is a Union. A Union MUST have one and only one value set.");
      }
      return new VirtualTransform(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = {this.upper, this.lower, this.insert, this.prefix, this.suffix, this.substring, this.segment};
      boolean haveOneNonNull = false;
      for (Object o : allValues) {
        if (Objects.nonNull(o)) {
          if (haveOneNonNull) {
            return false;
          }
          haveOneNonNull = true;
        }
      }
      return haveOneNonNull;
    }
  }
}
