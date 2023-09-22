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
  private final Twinned twinned;

  /**
   * Attribute must be a Set. Beacon value will also be a Set.
   */
  private final AsSet asSet;

  /**
   * Both Twinned and AsSet.
   */
  private final TwinnedSet twinnedSet;

  protected BeaconStyle(BuilderImpl builder) {
    this.partOnly = builder.partOnly();
    this.twinned = builder.twinned();
    this.asSet = builder.asSet();
    this.twinnedSet = builder.twinnedSet();
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
  public Twinned twinned() {
    return this.twinned;
  }

  /**
   * @return Attribute must be a Set. Beacon value will also be a Set.
   */
  public AsSet asSet() {
    return this.asSet;
  }

  /**
   * @return Both Twinned and AsSet.
   */
  public TwinnedSet twinnedSet() {
    return this.twinnedSet;
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
     * @param twinned This beacon should calculate values like another beacon, so they can be compared.
     */
    Builder twinned(Twinned twinned);

    /**
     * @return This beacon should calculate values like another beacon, so they can be compared.
     */
    Twinned twinned();

    /**
     * @param asSet Attribute must be a Set. Beacon value will also be a Set.
     */
    Builder asSet(AsSet asSet);

    /**
     * @return Attribute must be a Set. Beacon value will also be a Set.
     */
    AsSet asSet();

    /**
     * @param twinnedSet Both Twinned and AsSet.
     */
    Builder twinnedSet(TwinnedSet twinnedSet);

    /**
     * @return Both Twinned and AsSet.
     */
    TwinnedSet twinnedSet();

    BeaconStyle build();
  }

  static class BuilderImpl implements Builder {
    protected PartOnly partOnly;

    protected Twinned twinned;

    protected AsSet asSet;

    protected TwinnedSet twinnedSet;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BeaconStyle model) {
      this.partOnly = model.partOnly();
      this.twinned = model.twinned();
      this.asSet = model.asSet();
      this.twinnedSet = model.twinnedSet();
    }

    public Builder partOnly(PartOnly partOnly) {
      this.partOnly = partOnly;
      return this;
    }

    public PartOnly partOnly() {
      return this.partOnly;
    }

    public Builder twinned(Twinned twinned) {
      this.twinned = twinned;
      return this;
    }

    public Twinned twinned() {
      return this.twinned;
    }

    public Builder asSet(AsSet asSet) {
      this.asSet = asSet;
      return this;
    }

    public AsSet asSet() {
      return this.asSet;
    }

    public Builder twinnedSet(TwinnedSet twinnedSet) {
      this.twinnedSet = twinnedSet;
      return this;
    }

    public TwinnedSet twinnedSet() {
      return this.twinnedSet;
    }

    public BeaconStyle build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException("`BeaconStyle` is a Union. A Union MUST have one and only one value set.");
      }
      return new BeaconStyle(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = {this.partOnly, this.twinned, this.asSet, this.twinnedSet};
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
