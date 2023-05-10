// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.model;

import java.util.List;
import java.util.Objects;

public class SearchConfig {
  private final List<BeaconVersion> versions;

  private final int writeVersion;

  protected SearchConfig(BuilderImpl builder) {
    this.versions = builder.versions();
    this.writeVersion = builder.writeVersion();
  }

  public List<BeaconVersion> versions() {
    return this.versions;
  }

  public int writeVersion() {
    return this.writeVersion;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder versions(List<BeaconVersion> versions);

    List<BeaconVersion> versions();

    Builder writeVersion(int writeVersion);

    int writeVersion();

    SearchConfig build();
  }

  static class BuilderImpl implements Builder {
    protected List<BeaconVersion> versions;

    protected int writeVersion;

    private boolean _writeVersionSet = false;

    protected BuilderImpl() {
    }

    protected BuilderImpl(SearchConfig model) {
      this.versions = model.versions();
      this.writeVersion = model.writeVersion();
      this._writeVersionSet = true;
    }

    public Builder versions(List<BeaconVersion> versions) {
      this.versions = versions;
      return this;
    }

    public List<BeaconVersion> versions() {
      return this.versions;
    }

    public Builder writeVersion(int writeVersion) {
      this.writeVersion = writeVersion;
      this._writeVersionSet = true;
      return this;
    }

    public int writeVersion() {
      return this.writeVersion;
    }

    public SearchConfig build() {
      if (Objects.isNull(this.versions()))  {
        throw new IllegalArgumentException("Missing value for required field `versions`");
      }
      if (Objects.nonNull(this.versions()) && this.versions().size() < 1) {
        throw new IllegalArgumentException("The size of `versions` must be greater than or equal to 1");
      }
      if (Objects.nonNull(this.versions()) && this.versions().size() > 1) {
        throw new IllegalArgumentException("The size of `versions` must be less than or equal to 1");
      }
      if (!this._writeVersionSet) {
        throw new IllegalArgumentException("Missing value for required field `writeVersion`");
      }
      if (this._writeVersionSet && this.writeVersion() < 1) {
        throw new IllegalArgumentException("`writeVersion` must be greater than or equal to 1");
      }
      return new SearchConfig(this);
    }
  }
}
