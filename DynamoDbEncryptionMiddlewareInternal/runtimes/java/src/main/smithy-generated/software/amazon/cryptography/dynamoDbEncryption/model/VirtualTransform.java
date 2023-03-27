// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class VirtualTransform {
  private final Upper upper;

  private final Lower lower;

  private final Insert insert;

  private final GetPrefix prefix;

  private final GetSuffix suffix;

  private final GetSubstring substring;

  private final GetSegment segment;

  private final GetSegments segments;

  protected VirtualTransform(BuilderImpl builder) {
    this.upper = builder.upper();
    this.lower = builder.lower();
    this.insert = builder.insert();
    this.prefix = builder.prefix();
    this.suffix = builder.suffix();
    this.substring = builder.substring();
    this.segment = builder.segment();
    this.segments = builder.segments();
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

  public GetPrefix prefix() {
    return this.prefix;
  }

  public GetSuffix suffix() {
    return this.suffix;
  }

  public GetSubstring substring() {
    return this.substring;
  }

  public GetSegment segment() {
    return this.segment;
  }

  public GetSegments segments() {
    return this.segments;
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

    Builder prefix(GetPrefix prefix);

    GetPrefix prefix();

    Builder suffix(GetSuffix suffix);

    GetSuffix suffix();

    Builder substring(GetSubstring substring);

    GetSubstring substring();

    Builder segment(GetSegment segment);

    GetSegment segment();

    Builder segments(GetSegments segments);

    GetSegments segments();

    VirtualTransform build();
  }

  static class BuilderImpl implements Builder {
    protected Upper upper;

    protected Lower lower;

    protected Insert insert;

    protected GetPrefix prefix;

    protected GetSuffix suffix;

    protected GetSubstring substring;

    protected GetSegment segment;

    protected GetSegments segments;

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
      this.segments = model.segments();
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

    public Builder prefix(GetPrefix prefix) {
      this.prefix = prefix;
      return this;
    }

    public GetPrefix prefix() {
      return this.prefix;
    }

    public Builder suffix(GetSuffix suffix) {
      this.suffix = suffix;
      return this;
    }

    public GetSuffix suffix() {
      return this.suffix;
    }

    public Builder substring(GetSubstring substring) {
      this.substring = substring;
      return this;
    }

    public GetSubstring substring() {
      return this.substring;
    }

    public Builder segment(GetSegment segment) {
      this.segment = segment;
      return this;
    }

    public GetSegment segment() {
      return this.segment;
    }

    public Builder segments(GetSegments segments) {
      this.segments = segments;
      return this;
    }

    public GetSegments segments() {
      return this.segments;
    }

    public VirtualTransform build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException("`VirtualTransform` is a Union. A Union MUST have one and only one value set.");
      }
      return new VirtualTransform(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = {this.upper, this.lower, this.insert, this.prefix, this.suffix, this.substring, this.segment, this.segments};
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
