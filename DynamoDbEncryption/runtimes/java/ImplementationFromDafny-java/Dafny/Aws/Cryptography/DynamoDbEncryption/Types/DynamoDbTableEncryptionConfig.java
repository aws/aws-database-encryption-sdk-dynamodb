// Class DynamoDbTableEncryptionConfig
// Dafny class DynamoDbTableEncryptionConfig compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbTableEncryptionConfig {
  public dafny.DafnySequence<? extends Character> _logicalTableName;
  public dafny.DafnySequence<? extends Character> _partitionKeyName;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _sortKeyName;
  public Wrappers_Compile.Option<SearchConfig> _search;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _attributeActions;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _allowedUnauthenticatedAttributes;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _allowedUnauthenticatedAttributePrefix;
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> _algorithmSuiteId;
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> _keyring;
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> _cmm;
  public Wrappers_Compile.Option<LegacyConfig> _legacyConfig;
  public Wrappers_Compile.Option<PlaintextPolicy> _plaintextPolicy;
  public DynamoDbTableEncryptionConfig (dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Wrappers_Compile.Option<SearchConfig> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnauthenticatedAttributePrefix, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> keyring, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> cmm, Wrappers_Compile.Option<LegacyConfig> legacyConfig, Wrappers_Compile.Option<PlaintextPolicy> plaintextPolicy) {
    this._logicalTableName = logicalTableName;
    this._partitionKeyName = partitionKeyName;
    this._sortKeyName = sortKeyName;
    this._search = search;
    this._attributeActions = attributeActions;
    this._allowedUnauthenticatedAttributes = allowedUnauthenticatedAttributes;
    this._allowedUnauthenticatedAttributePrefix = allowedUnauthenticatedAttributePrefix;
    this._algorithmSuiteId = algorithmSuiteId;
    this._keyring = keyring;
    this._cmm = cmm;
    this._legacyConfig = legacyConfig;
    this._plaintextPolicy = plaintextPolicy;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DynamoDbTableEncryptionConfig o = (DynamoDbTableEncryptionConfig)other;
    return true && java.util.Objects.equals(this._logicalTableName, o._logicalTableName) && java.util.Objects.equals(this._partitionKeyName, o._partitionKeyName) && java.util.Objects.equals(this._sortKeyName, o._sortKeyName) && java.util.Objects.equals(this._search, o._search) && java.util.Objects.equals(this._attributeActions, o._attributeActions) && java.util.Objects.equals(this._allowedUnauthenticatedAttributes, o._allowedUnauthenticatedAttributes) && java.util.Objects.equals(this._allowedUnauthenticatedAttributePrefix, o._allowedUnauthenticatedAttributePrefix) && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && java.util.Objects.equals(this._keyring, o._keyring) && java.util.Objects.equals(this._cmm, o._cmm) && java.util.Objects.equals(this._legacyConfig, o._legacyConfig) && java.util.Objects.equals(this._plaintextPolicy, o._plaintextPolicy);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._logicalTableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partitionKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sortKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._search);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributeActions);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._allowedUnauthenticatedAttributes);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._allowedUnauthenticatedAttributePrefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyring);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmm);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._legacyConfig);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextPolicy);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.DynamoDbTableEncryptionConfig.DynamoDbTableEncryptionConfig");
    s.append("(");
    s.append(dafny.Helpers.toString(this._logicalTableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._partitionKeyName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._sortKeyName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._search));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._attributeActions));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._allowedUnauthenticatedAttributes));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._allowedUnauthenticatedAttributePrefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._keyring));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cmm));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._legacyConfig));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._plaintextPolicy));
    s.append(")");
    return s.toString();
  }

  private static final DynamoDbTableEncryptionConfig theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(), Wrappers_Compile.Option.<SearchConfig>Default(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> empty(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>Default(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId>Default(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>Default(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>Default(), Wrappers_Compile.Option.<LegacyConfig>Default(), Wrappers_Compile.Option.<PlaintextPolicy>Default());
  public static DynamoDbTableEncryptionConfig Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<DynamoDbTableEncryptionConfig> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DynamoDbTableEncryptionConfig.class, () -> Default());
  public static dafny.TypeDescriptor<DynamoDbTableEncryptionConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbTableEncryptionConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static DynamoDbTableEncryptionConfig create(dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Wrappers_Compile.Option<SearchConfig> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnauthenticatedAttributePrefix, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> keyring, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> cmm, Wrappers_Compile.Option<LegacyConfig> legacyConfig, Wrappers_Compile.Option<PlaintextPolicy> plaintextPolicy) {
    return new DynamoDbTableEncryptionConfig(logicalTableName, partitionKeyName, sortKeyName, search, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm, legacyConfig, plaintextPolicy);
  }
  public static DynamoDbTableEncryptionConfig create_DynamoDbTableEncryptionConfig(dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Wrappers_Compile.Option<SearchConfig> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnauthenticatedAttributePrefix, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> keyring, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> cmm, Wrappers_Compile.Option<LegacyConfig> legacyConfig, Wrappers_Compile.Option<PlaintextPolicy> plaintextPolicy) {
    return create(logicalTableName, partitionKeyName, sortKeyName, search, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, keyring, cmm, legacyConfig, plaintextPolicy);
  }
  public boolean is_DynamoDbTableEncryptionConfig() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_logicalTableName() {
    return this._logicalTableName;
  }
  public dafny.DafnySequence<? extends Character> dtor_partitionKeyName() {
    return this._partitionKeyName;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_sortKeyName() {
    return this._sortKeyName;
  }
  public Wrappers_Compile.Option<SearchConfig> dtor_search() {
    return this._search;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> dtor_attributeActions() {
    return this._attributeActions;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> dtor_allowedUnauthenticatedAttributes() {
    return this._allowedUnauthenticatedAttributes;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_allowedUnauthenticatedAttributePrefix() {
    return this._allowedUnauthenticatedAttributePrefix;
  }
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> dtor_algorithmSuiteId() {
    return this._algorithmSuiteId;
  }
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring> dtor_keyring() {
    return this._keyring;
  }
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager> dtor_cmm() {
    return this._cmm;
  }
  public Wrappers_Compile.Option<LegacyConfig> dtor_legacyConfig() {
    return this._legacyConfig;
  }
  public Wrappers_Compile.Option<PlaintextPolicy> dtor_plaintextPolicy() {
    return this._plaintextPolicy;
  }
}
