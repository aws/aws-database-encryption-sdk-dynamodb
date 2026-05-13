// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;
import software.amazon.cryptography.keystore.KeyStore;

/**
 * The configuration for a particular version of searchable encryption. Currently the only supported version is '1'.
 */
public class BeaconVersion {

  /**
   * The version of searchable encryption configured. This must be '1'.
   */
  private final int version;

  /**
   * The Key Store that contains the Beacon Keys to use with searchable encryption.
   */
  private final KeyStore keyStore;

  /**
   * The configuration for what beacon key(s) to use.
   */
  private final BeaconKeySource keySource;

  /**
   * The Standard Beacons to be written with items.
   */
  private final List<StandardBeacon> standardBeacons;

  /**
   * The Compound Beacons to be written with items.
   */
  private final List<CompoundBeacon> compoundBeacons;

  /**
   * The Virtual Fields to be calculated, supporting other searchable enryption configurations.
   */
  private final List<VirtualField> virtualFields;

  /**
   * The list of Encrypted Parts that may be included in any compound beacon.
   */
  private final List<EncryptedPart> encryptedParts;

  /**
   * The list of Signed Parts that may be included in any compound beacon.
   */
  private final List<SignedPart> signedParts;

  protected BeaconVersion(BuilderImpl builder) {
    this.version = builder.version();
    this.keyStore = builder.keyStore();
    this.keySource = builder.keySource();
    this.standardBeacons = builder.standardBeacons();
    this.compoundBeacons = builder.compoundBeacons();
    this.virtualFields = builder.virtualFields();
    this.encryptedParts = builder.encryptedParts();
    this.signedParts = builder.signedParts();
  }

  /**
   * @return The version of searchable encryption configured. This must be '1'.
   */
  public int version() {
    return this.version;
  }

  /**
   * @return The Key Store that contains the Beacon Keys to use with searchable encryption.
   */
  public KeyStore keyStore() {
    return this.keyStore;
  }

  /**
   * @return The configuration for what beacon key(s) to use.
   */
  public BeaconKeySource keySource() {
    return this.keySource;
  }

  /**
   * @return The Standard Beacons to be written with items.
   */
  public List<StandardBeacon> standardBeacons() {
    return this.standardBeacons;
  }

  /**
   * @return The Compound Beacons to be written with items.
   */
  public List<CompoundBeacon> compoundBeacons() {
    return this.compoundBeacons;
  }

  /**
   * @return The Virtual Fields to be calculated, supporting other searchable enryption configurations.
   */
  public List<VirtualField> virtualFields() {
    return this.virtualFields;
  }

  /**
   * @return The list of Encrypted Parts that may be included in any compound beacon.
   */
  public List<EncryptedPart> encryptedParts() {
    return this.encryptedParts;
  }

  /**
   * @return The list of Signed Parts that may be included in any compound beacon.
   */
  public List<SignedPart> signedParts() {
    return this.signedParts;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param version The version of searchable encryption configured. This must be '1'.
     */
    Builder version(int version);

    /**
     * @return The version of searchable encryption configured. This must be '1'.
     */
    int version();

    /**
     * @param keyStore The Key Store that contains the Beacon Keys to use with searchable encryption.
     */
    Builder keyStore(KeyStore keyStore);

    /**
     * @return The Key Store that contains the Beacon Keys to use with searchable encryption.
     */
    KeyStore keyStore();

    /**
     * @param keySource The configuration for what beacon key(s) to use.
     */
    Builder keySource(BeaconKeySource keySource);

    /**
     * @return The configuration for what beacon key(s) to use.
     */
    BeaconKeySource keySource();

    /**
     * @param standardBeacons The Standard Beacons to be written with items.
     */
    Builder standardBeacons(List<StandardBeacon> standardBeacons);

    /**
     * @return The Standard Beacons to be written with items.
     */
    List<StandardBeacon> standardBeacons();

    /**
     * @param compoundBeacons The Compound Beacons to be written with items.
     */
    Builder compoundBeacons(List<CompoundBeacon> compoundBeacons);

    /**
     * @return The Compound Beacons to be written with items.
     */
    List<CompoundBeacon> compoundBeacons();

    /**
     * @param virtualFields The Virtual Fields to be calculated, supporting other searchable enryption configurations.
     */
    Builder virtualFields(List<VirtualField> virtualFields);

    /**
     * @return The Virtual Fields to be calculated, supporting other searchable enryption configurations.
     */
    List<VirtualField> virtualFields();

    /**
     * @param encryptedParts The list of Encrypted Parts that may be included in any compound beacon.
     */
    Builder encryptedParts(List<EncryptedPart> encryptedParts);

    /**
     * @return The list of Encrypted Parts that may be included in any compound beacon.
     */
    List<EncryptedPart> encryptedParts();

    /**
     * @param signedParts The list of Signed Parts that may be included in any compound beacon.
     */
    Builder signedParts(List<SignedPart> signedParts);

    /**
     * @return The list of Signed Parts that may be included in any compound beacon.
     */
    List<SignedPart> signedParts();

    BeaconVersion build();
  }

  static class BuilderImpl implements Builder {

    protected int version;

    private boolean _versionSet = false;

    protected KeyStore keyStore;

    protected BeaconKeySource keySource;

    protected List<StandardBeacon> standardBeacons;

    protected List<CompoundBeacon> compoundBeacons;

    protected List<VirtualField> virtualFields;

    protected List<EncryptedPart> encryptedParts;

    protected List<SignedPart> signedParts;

    protected BuilderImpl() {}

    protected BuilderImpl(BeaconVersion model) {
      this.version = model.version();
      this._versionSet = true;
      this.keyStore = model.keyStore();
      this.keySource = model.keySource();
      this.standardBeacons = model.standardBeacons();
      this.compoundBeacons = model.compoundBeacons();
      this.virtualFields = model.virtualFields();
      this.encryptedParts = model.encryptedParts();
      this.signedParts = model.signedParts();
    }

    public Builder version(int version) {
      this.version = version;
      this._versionSet = true;
      return this;
    }

    public int version() {
      return this.version;
    }

    public Builder keyStore(KeyStore keyStore) {
      this.keyStore = keyStore;
      return this;
    }

    public KeyStore keyStore() {
      return this.keyStore;
    }

    public Builder keySource(BeaconKeySource keySource) {
      this.keySource = keySource;
      return this;
    }

    public BeaconKeySource keySource() {
      return this.keySource;
    }

    public Builder standardBeacons(List<StandardBeacon> standardBeacons) {
      this.standardBeacons = standardBeacons;
      return this;
    }

    public List<StandardBeacon> standardBeacons() {
      return this.standardBeacons;
    }

    public Builder compoundBeacons(List<CompoundBeacon> compoundBeacons) {
      this.compoundBeacons = compoundBeacons;
      return this;
    }

    public List<CompoundBeacon> compoundBeacons() {
      return this.compoundBeacons;
    }

    public Builder virtualFields(List<VirtualField> virtualFields) {
      this.virtualFields = virtualFields;
      return this;
    }

    public List<VirtualField> virtualFields() {
      return this.virtualFields;
    }

    public Builder encryptedParts(List<EncryptedPart> encryptedParts) {
      this.encryptedParts = encryptedParts;
      return this;
    }

    public List<EncryptedPart> encryptedParts() {
      return this.encryptedParts;
    }

    public Builder signedParts(List<SignedPart> signedParts) {
      this.signedParts = signedParts;
      return this;
    }

    public List<SignedPart> signedParts() {
      return this.signedParts;
    }

    public BeaconVersion build() {
      if (!this._versionSet) {
        throw new IllegalArgumentException(
          "Missing value for required field `version`"
        );
      }
      if (this._versionSet && this.version() < 1) {
        throw new IllegalArgumentException(
          "`version` must be greater than or equal to 1"
        );
      }
      if (Objects.isNull(this.keyStore())) {
        throw new IllegalArgumentException(
          "Missing value for required field `keyStore`"
        );
      }
      if (Objects.isNull(this.keySource())) {
        throw new IllegalArgumentException(
          "Missing value for required field `keySource`"
        );
      }
      if (Objects.isNull(this.standardBeacons())) {
        throw new IllegalArgumentException(
          "Missing value for required field `standardBeacons`"
        );
      }
      if (
        Objects.nonNull(this.standardBeacons()) &&
        this.standardBeacons().size() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `standardBeacons` must be greater than or equal to 1"
        );
      }
      if (
        Objects.nonNull(this.compoundBeacons()) &&
        this.compoundBeacons().size() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `compoundBeacons` must be greater than or equal to 1"
        );
      }
      if (
        Objects.nonNull(this.virtualFields()) && this.virtualFields().size() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `virtualFields` must be greater than or equal to 1"
        );
      }
      if (
        Objects.nonNull(this.encryptedParts()) &&
        this.encryptedParts().size() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `encryptedParts` must be greater than or equal to 1"
        );
      }
      if (
        Objects.nonNull(this.signedParts()) && this.signedParts().size() < 1
      ) {
        throw new IllegalArgumentException(
          "The size of `signedParts` must be greater than or equal to 1"
        );
      }
      return new BeaconVersion(this);
    }
  }
}
