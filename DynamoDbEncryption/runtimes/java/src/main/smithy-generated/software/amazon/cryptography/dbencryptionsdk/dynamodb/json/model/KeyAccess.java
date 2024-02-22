// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.json.model;

import java.util.Objects;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.Keyring;

public class KeyAccess {

  /**
   * The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption.
   */
  private final IKeyring keyring;

  /**
   * The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.
   */
  private final ICryptographicMaterialsManager cmm;

  protected KeyAccess(BuilderImpl builder) {
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
  }

  /**
   * @return The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption.
   */
  public IKeyring keyring() {
    return this.keyring;
  }

  /**
   * @return The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.
   */
  public ICryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param keyring The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption.
     */
    Builder keyring(IKeyring keyring);

    /**
     * @return The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption.
     */
    IKeyring keyring();

    /**
     * @param cmm The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.
     */
    Builder cmm(ICryptographicMaterialsManager cmm);

    /**
     * @return The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.
     */
    ICryptographicMaterialsManager cmm();

    KeyAccess build();
  }

  static class BuilderImpl implements Builder {

    protected IKeyring keyring;

    protected ICryptographicMaterialsManager cmm;

    protected BuilderImpl() {}

    protected BuilderImpl(KeyAccess model) {
      this.keyring = model.keyring();
      this.cmm = model.cmm();
    }

    public Builder keyring(IKeyring keyring) {
      this.keyring = Keyring.wrap(keyring);
      return this;
    }

    public IKeyring keyring() {
      return this.keyring;
    }

    public Builder cmm(ICryptographicMaterialsManager cmm) {
      this.cmm = CryptographicMaterialsManager.wrap(cmm);
      return this;
    }

    public ICryptographicMaterialsManager cmm() {
      return this.cmm;
    }

    public KeyAccess build() {
      if (!onlyOneNonNull()) {
        throw new IllegalArgumentException(
          "`KeyAccess` is a Union. A Union MUST have one and only one value set."
        );
      }
      return new KeyAccess(this);
    }

    private boolean onlyOneNonNull() {
      Object[] allValues = { this.keyring, this.cmm };
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
