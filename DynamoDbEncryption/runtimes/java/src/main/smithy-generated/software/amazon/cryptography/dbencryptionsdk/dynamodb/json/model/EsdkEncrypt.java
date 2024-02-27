// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.Keyring;
import software.amazon.cryptography.materialproviders.model.ESDKAlgorithmSuiteId;

public class EsdkEncrypt {

  private final ICryptographicMaterialsManager materialsManager;

  private final IKeyring keyring;

  private final ESDKAlgorithmSuiteId algorithmSuiteId;

  private final long frameLength;

  protected EsdkEncrypt(BuilderImpl builder) {
    this.materialsManager = builder.materialsManager();
    this.keyring = builder.keyring();
    this.algorithmSuiteId = builder.algorithmSuiteId();
    this.frameLength = builder.frameLength();
  }

  public ICryptographicMaterialsManager materialsManager() {
    return this.materialsManager;
  }

  public IKeyring keyring() {
    return this.keyring;
  }

  public ESDKAlgorithmSuiteId algorithmSuiteId() {
    return this.algorithmSuiteId;
  }

  public long frameLength() {
    return this.frameLength;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder materialsManager(ICryptographicMaterialsManager materialsManager);

    ICryptographicMaterialsManager materialsManager();

    Builder keyring(IKeyring keyring);

    IKeyring keyring();

    Builder algorithmSuiteId(ESDKAlgorithmSuiteId algorithmSuiteId);

    ESDKAlgorithmSuiteId algorithmSuiteId();

    Builder frameLength(long frameLength);

    long frameLength();

    EsdkEncrypt build();
  }

  static class BuilderImpl implements Builder {

    protected ICryptographicMaterialsManager materialsManager;

    protected IKeyring keyring;

    protected ESDKAlgorithmSuiteId algorithmSuiteId;

    protected long frameLength;

    private boolean _frameLengthSet = false;

    protected BuilderImpl() {}

    protected BuilderImpl(EsdkEncrypt model) {
      this.materialsManager = model.materialsManager();
      this.keyring = model.keyring();
      this.algorithmSuiteId = model.algorithmSuiteId();
      this.frameLength = model.frameLength();
      this._frameLengthSet = true;
    }

    public Builder materialsManager(
      ICryptographicMaterialsManager materialsManager
    ) {
      this.materialsManager =
        CryptographicMaterialsManager.wrap(materialsManager);
      return this;
    }

    public ICryptographicMaterialsManager materialsManager() {
      return this.materialsManager;
    }

    public Builder keyring(IKeyring keyring) {
      this.keyring = Keyring.wrap(keyring);
      return this;
    }

    public IKeyring keyring() {
      return this.keyring;
    }

    public Builder algorithmSuiteId(ESDKAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public ESDKAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
    }

    public Builder frameLength(long frameLength) {
      this.frameLength = frameLength;
      this._frameLengthSet = true;
      return this;
    }

    public long frameLength() {
      return this.frameLength;
    }

    public EsdkEncrypt build() {
      if (this._frameLengthSet && this.frameLength() < 1) {
        throw new IllegalArgumentException(
          "`frameLength` must be greater than or equal to 1"
        );
      }
      if (this._frameLengthSet && this.frameLength() > 4294967296) {
        throw new IllegalArgumentException(
          "`frameLength` must be less than or equal to 4294967296."
        );
      }
      return new EsdkEncrypt(this);
    }
  }
}
