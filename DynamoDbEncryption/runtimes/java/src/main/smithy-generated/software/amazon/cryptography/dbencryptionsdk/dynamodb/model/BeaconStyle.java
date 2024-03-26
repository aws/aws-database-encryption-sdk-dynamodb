// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.Objects;

public class BeaconStyle {

  /**
   * Attribute must be used as part of a Compound Beacon, never alone.
   */
  private final PartOnly partOnly;

  /**
   * This beacon should calculate values like another beacon, so they can be compared.
   */
  private final Shared shared;

  /**
   * Attribute must be a Set. Beacon value will also be a Set.
   */
  private final AsSet asSet;

  /**
   * Both Shared and AsSet.
   */
  private final SharedSet sharedSet;

  protected BeaconStyle(BuilderImpl builder) {
    this.partOnly = builder.partOnly();
    this.shared = builder.shared();
    this.asSet = builder.asSet();
    this.sharedSet = builder.sharedSet();
  }

  /**
   * @return Attribute must be used as part of a Compound Beacon, never alone.
   */
  public PartOnly partOnly() {
    return this.partOnly;
  }

  /**
   * @return This beacon should calculate values like another beacon, so they can be compared.
   */
  public Shared shared() {
    return this.shared;
  }

  /**
   * @return Attribute must be a Set. Beacon value will also be a Set.
   */
  public AsSet asSet() {
    return this.asSet;
  }

  /**
   * @return Both Shared and AsSet.
   */
  public SharedSet sharedSet() {
    return this.sharedSet;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param partOnly Attribute must be used as part of a Compound Beacon, never alone.
     */
    Builder partOnly(PartOnly partOnly);

    /**
     * @return Attribute must be used as part of a Compound Beacon, never alone.
     */
    PartOnly partOnly();

    /**
     * @param shared This beacon should calculate values like another beacon, so they can be compared.
     */
    Builder shared(Shared shared);

    /**
     * @return This beacon should calculate values like another beacon, so they can be compared.
     */
    Shared shared();

    /**
     * @param asSet Attribute must be a Set. Beacon value will also be a Set.
     */
    Builder asSet(AsSet asSet);

    /**
     * @return Attribute must be a Set. Beacon value will also be a Set.
     */
    AsSet asSet();

    /**
     * @param sharedSet Both Shared and AsSet.
     */
    Builder sharedSet(SharedSet sharedSet);

    /**
     * @return Both Shared and AsSet.
     */
    SharedSet sharedSet();

    BeaconStyle build();
  }

  static class BuilderImpl implements Builder {

    protected PartOnly partOnly;

    protected Shared shared;

    protected AsSet asSet;

    protected SharedSet sharedSet;

    protected BuilderImpl() {}

    protected BuilderImpl(BeaconStyle model) {
      this.partOnly = model.partOnly();
      this.shared = model.shared();
      this.asSet = model.asSet();
      this.sharedSet = model.sharedSet();
    }

    public Builder partOnly(PartOnly partOnly) {
      this.partOnly = partOnly;
      return this;
    }

    public PartOnly partOnly() {
      return this.partOnly;
    }

    public Builder shared(Shared shared) {
      this.shared = shared;
      return this;
    }

    public Shared shared() {
      return this.shared;
    }

    public Builder asSet(AsSet asSet) {
      this.asSet = asSet;
      return this;
    }

    public AsSet asSet() {
      return this.asSet;
    }

    public Builder sharedSet(SharedSet sharedSet) {
      this.sharedSet = sharedSet;
      return this;
    }

    public SharedSet sharedSet() {
      return this.sharedSet;
    }

    public BeaconStyle build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException(
          "`BeaconStyle` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new BeaconStyle(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = {
        this.partOnly,
        this.shared,
        this.asSet,
        this.sharedSet,
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
