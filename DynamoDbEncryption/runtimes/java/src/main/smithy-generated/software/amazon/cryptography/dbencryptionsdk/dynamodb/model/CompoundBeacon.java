// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;

/**
 * The configuration for a Compound Beacon.
 */
public class CompoundBeacon {

  /**
   * The name of the Compound Beacon.
   */
  private final String name;

  /**
   * The characters used to split parts of a compound beacon. The split character should be a character that does not appear in any Signed Part or Prefix used by the Compound Beacon.
   */
  private final String split;

  /**
   * The list of Encrypted Parts that may be included in the compound beacon.
   */
  private final List<EncryptedPart> encrypted;

  /**
   * The list of Signed Parts that may be included in the compound beacon.
   */
  private final List<SignedPart> signed;

  /**
   * The ordered list of constructors that may be used to create the Compound Beacon. Each constructor is checked, in order, to see if it can construct the beacon. The first constructor that can construct the beacon is used. If no constructor can construct the beacon, the Compound Beacon is not written to the item.
   */
  private final List<Constructor> constructors;

  protected CompoundBeacon(BuilderImpl builder) {
    this.name = builder.name();
    this.split = builder.split();
    this.encrypted = builder.encrypted();
    this.signed = builder.signed();
    this.constructors = builder.constructors();
  }

  /**
   * @return The name of the Compound Beacon.
   */
  public String name() {
    return this.name;
  }

  /**
   * @return The characters used to split parts of a compound beacon. The split character should be a character that does not appear in any Signed Part or Prefix used by the Compound Beacon.
   */
  public String split() {
    return this.split;
  }

  /**
   * @return The list of Encrypted Parts that may be included in the compound beacon.
   */
  public List<EncryptedPart> encrypted() {
    return this.encrypted;
  }

  /**
   * @return The list of Signed Parts that may be included in the compound beacon.
   */
  public List<SignedPart> signed() {
    return this.signed;
  }

  /**
   * @return The ordered list of constructors that may be used to create the Compound Beacon. Each constructor is checked, in order, to see if it can construct the beacon. The first constructor that can construct the beacon is used. If no constructor can construct the beacon, the Compound Beacon is not written to the item.
   */
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
    /**
     * @param name The name of the Compound Beacon.
     */
    Builder name(String name);

    /**
     * @return The name of the Compound Beacon.
     */
    String name();

    /**
     * @param split The characters used to split parts of a compound beacon. The split character should be a character that does not appear in any Signed Part or Prefix used by the Compound Beacon.
     */
    Builder split(String split);

    /**
     * @return The characters used to split parts of a compound beacon. The split character should be a character that does not appear in any Signed Part or Prefix used by the Compound Beacon.
     */
    String split();

    /**
     * @param encrypted The list of Encrypted Parts that may be included in the compound beacon.
     */
    Builder encrypted(List<EncryptedPart> encrypted);

    /**
     * @return The list of Encrypted Parts that may be included in the compound beacon.
     */
    List<EncryptedPart> encrypted();

    /**
     * @param signed The list of Signed Parts that may be included in the compound beacon.
     */
    Builder signed(List<SignedPart> signed);

    /**
     * @return The list of Signed Parts that may be included in the compound beacon.
     */
    List<SignedPart> signed();

    /**
     * @param constructors The ordered list of constructors that may be used to create the Compound Beacon. Each constructor is checked, in order, to see if it can construct the beacon. The first constructor that can construct the beacon is used. If no constructor can construct the beacon, the Compound Beacon is not written to the item.
     */
    Builder constructors(List<Constructor> constructors);

    /**
     * @return The ordered list of constructors that may be used to create the Compound Beacon. Each constructor is checked, in order, to see if it can construct the beacon. The first constructor that can construct the beacon is used. If no constructor can construct the beacon, the Compound Beacon is not written to the item.
     */
    List<Constructor> constructors();

    CompoundBeacon build();
  }

  static class BuilderImpl implements Builder {

    protected String name;

    protected String split;

    protected List<EncryptedPart> encrypted;

    protected List<SignedPart> signed;

    protected List<Constructor> constructors;

    protected BuilderImpl() {}

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
      if (Objects.isNull(this.name())) {
        throw new IllegalArgumentException(
          "Missing value for required field `name`"
        );
      }
      if (Objects.isNull(this.split())) {
        throw new IllegalArgumentException(
          "Missing value for required field `split`"
        );
      }
      if (Objects.nonNull(this.split()) && this.split().length() < 1) {
        throw new IllegalArgumentException(
          "The size of `split` must be greater than or equal to 1"
        );
      }
      if (Objects.nonNull(this.split()) && this.split().length() > 1) {
        throw new IllegalArgumentException(
          "The size of `split` must be less than or equal to 1"
        );
      }
      if (Objects.nonNull(this.encrypted()) && this.encrypted().size() < 1) {
        throw new IllegalArgumentException(
          "The size of `encrypted` must be greater than or equal to 1"
        );
      }
      if (Objects.nonNull(this.signed()) && this.signed().size() < 1) {
        throw new IllegalArgumentException(
          "The size of `signed` must be greater than or equal to 1"
        );
      }
      if (
        Objects.nonNull(this.constructors()) && this.constructors().size() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `constructors` must be greater than or equal to 1"
        );
      }
      return new CompoundBeacon(this);
    }
  }
}
