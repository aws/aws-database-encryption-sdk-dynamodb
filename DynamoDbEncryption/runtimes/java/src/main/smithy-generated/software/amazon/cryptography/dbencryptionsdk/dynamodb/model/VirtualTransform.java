// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

public class VirtualTransform {

  /**
   * The Virtual Part Transformation that converts ASCII characters to upper case.
   */
  private final Upper upper;

  /**
   * The Virtual Part Transformation that converts ASCII characters to lower case.
   */
  private final Lower lower;

  /**
   * The Virtual Part Transformation that appends a literal string.
   */
  private final Insert insert;

  /**
   * The Virtual Part Transformation that gets the prefix of a string.
   */
  private final GetPrefix prefix;

  /**
   * The Virtual Part Transformation that gets the suffix of a string.
   */
  private final GetSuffix suffix;

  /**
   * The Virtual Part Transformation that gets a substring from a string.
   */
  private final GetSubstring substring;

  /**
   * The Virtual Part Transformation that splits a string and gets a particular segment of that split.
   */
  private final GetSegment segment;

  /**
   * The Virtual Part Transformation that splits a string and gets a range of segments of that split.
   */
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

  /**
   * @return The Virtual Part Transformation that converts ASCII characters to upper case.
   */
  public Upper upper() {
    return this.upper;
  }

  /**
   * @return The Virtual Part Transformation that converts ASCII characters to lower case.
   */
  public Lower lower() {
    return this.lower;
  }

  /**
   * @return The Virtual Part Transformation that appends a literal string.
   */
  public Insert insert() {
    return this.insert;
  }

  /**
   * @return The Virtual Part Transformation that gets the prefix of a string.
   */
  public GetPrefix prefix() {
    return this.prefix;
  }

  /**
   * @return The Virtual Part Transformation that gets the suffix of a string.
   */
  public GetSuffix suffix() {
    return this.suffix;
  }

  /**
   * @return The Virtual Part Transformation that gets a substring from a string.
   */
  public GetSubstring substring() {
    return this.substring;
  }

  /**
   * @return The Virtual Part Transformation that splits a string and gets a particular segment of that split.
   */
  public GetSegment segment() {
    return this.segment;
  }

  /**
   * @return The Virtual Part Transformation that splits a string and gets a range of segments of that split.
   */
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
    /**
     * @param upper The Virtual Part Transformation that converts ASCII characters to upper case.
     */
    Builder upper(Upper upper);

    /**
     * @return The Virtual Part Transformation that converts ASCII characters to upper case.
     */
    Upper upper();

    /**
     * @param lower The Virtual Part Transformation that converts ASCII characters to lower case.
     */
    Builder lower(Lower lower);

    /**
     * @return The Virtual Part Transformation that converts ASCII characters to lower case.
     */
    Lower lower();

    /**
     * @param insert The Virtual Part Transformation that appends a literal string.
     */
    Builder insert(Insert insert);

    /**
     * @return The Virtual Part Transformation that appends a literal string.
     */
    Insert insert();

    /**
     * @param prefix The Virtual Part Transformation that gets the prefix of a string.
     */
    Builder prefix(GetPrefix prefix);

    /**
     * @return The Virtual Part Transformation that gets the prefix of a string.
     */
    GetPrefix prefix();

    /**
     * @param suffix The Virtual Part Transformation that gets the suffix of a string.
     */
    Builder suffix(GetSuffix suffix);

    /**
     * @return The Virtual Part Transformation that gets the suffix of a string.
     */
    GetSuffix suffix();

    /**
     * @param substring The Virtual Part Transformation that gets a substring from a string.
     */
    Builder substring(GetSubstring substring);

    /**
     * @return The Virtual Part Transformation that gets a substring from a string.
     */
    GetSubstring substring();

    /**
     * @param segment The Virtual Part Transformation that splits a string and gets a particular segment of that split.
     */
    Builder segment(GetSegment segment);

    /**
     * @return The Virtual Part Transformation that splits a string and gets a particular segment of that split.
     */
    GetSegment segment();

    /**
     * @param segments The Virtual Part Transformation that splits a string and gets a range of segments of that split.
     */
    Builder segments(GetSegments segments);

    /**
     * @return The Virtual Part Transformation that splits a string and gets a range of segments of that split.
     */
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

    protected BuilderImpl() {}

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
        throw new IllegalArgumentException(
          "`VirtualTransform` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new VirtualTransform(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = {
        this.upper,
        this.lower,
        this.insert,
        this.prefix,
        this.suffix,
        this.substring,
        this.segment,
        this.segments,
      };
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
