// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.List;
import java.util.Objects;
import software.amazon.cryptography.keyStore.KeyStore;

public class BeaconVersion {
  private final int version;

  private final KeyStore keyStore;

  private final BeaconKeySource keySource;

  private final List<StandardBeacon> standardBeacons;

  private final List<CompoundBeacon> compoundBeacons;

  private final List<VirtualField> virtualFields;

  protected BeaconVersion(BuilderImpl builder) {
    this.version = builder.version();
    this.keyStore = builder.keyStore();
    this.keySource = builder.keySource();
    this.standardBeacons = builder.standardBeacons();
    this.compoundBeacons = builder.compoundBeacons();
    this.virtualFields = builder.virtualFields();
  }

  public int version() {
    return this.version;
  }

  public KeyStore keyStore() {
    return this.keyStore;
  }

  public BeaconKeySource keySource() {
    return this.keySource;
  }

  public List<StandardBeacon> standardBeacons() {
    return this.standardBeacons;
  }

  public List<CompoundBeacon> compoundBeacons() {
    return this.compoundBeacons;
  }

  public List<VirtualField> virtualFields() {
    return this.virtualFields;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder version(int version);

    int version();

    Builder keyStore(KeyStore keyStore);

    KeyStore keyStore();

    Builder keySource(BeaconKeySource keySource);

    BeaconKeySource keySource();

    Builder standardBeacons(List<StandardBeacon> standardBeacons);

    List<StandardBeacon> standardBeacons();

    Builder compoundBeacons(List<CompoundBeacon> compoundBeacons);

    List<CompoundBeacon> compoundBeacons();

    Builder virtualFields(List<VirtualField> virtualFields);

    List<VirtualField> virtualFields();

    BeaconVersion build();
  }

  static class BuilderImpl implements Builder {
    protected int version;

    protected KeyStore keyStore;

    protected BeaconKeySource keySource;

    protected List<StandardBeacon> standardBeacons;

    protected List<CompoundBeacon> compoundBeacons;

    protected List<VirtualField> virtualFields;

    protected BuilderImpl() {
    }

    protected BuilderImpl(BeaconVersion model) {
      this.version = model.version();
      this.keyStore = model.keyStore();
      this.keySource = model.keySource();
      this.standardBeacons = model.standardBeacons();
      this.compoundBeacons = model.compoundBeacons();
      this.virtualFields = model.virtualFields();
    }

    public Builder version(int version) {
      this.version = version;
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

    public BeaconVersion build() {
      if (Objects.isNull(this.version()))  {
        throw new IllegalArgumentException("Missing value for required field `version`");
      }
      if (Objects.nonNull(this.version()) && this.version() < 1) {
        throw new IllegalArgumentException("`version` must be greater than or equal to 1");
      }
      if (Objects.isNull(this.keyStore()))  {
        throw new IllegalArgumentException("Missing value for required field `keyStore`");
      }
      if (Objects.isNull(this.keySource()))  {
        throw new IllegalArgumentException("Missing value for required field `keySource`");
      }
      if (Objects.isNull(this.standardBeacons()))  {
        throw new IllegalArgumentException("Missing value for required field `standardBeacons`");
      }
      if (Objects.nonNull(this.standardBeacons()) && this.standardBeacons().size() < 1) {
        throw new IllegalArgumentException("The size of `standardBeacons` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.compoundBeacons()) && this.compoundBeacons().size() < 1) {
        throw new IllegalArgumentException("The size of `compoundBeacons` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.virtualFields()) && this.virtualFields().size() < 1) {
        throw new IllegalArgumentException("The size of `virtualFields` must be greater than or equal to 1");
      }
      return new BeaconVersion(this);
    }
  }
}
