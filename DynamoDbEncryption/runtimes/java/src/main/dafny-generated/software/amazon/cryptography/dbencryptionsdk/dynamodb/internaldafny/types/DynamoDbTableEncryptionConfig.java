// Class DynamoDbTableEncryptionConfig
// Dafny class DynamoDbTableEncryptionConfig compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbTableEncryptionConfig {
  public dafny.DafnySequence<? extends Character> _logicalTableName;
  public dafny.DafnySequence<? extends Character> _partitionKeyName;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _sortKeyName;
  public Wrappers_Compile.Option<SearchConfig> _search;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _attributeActionsOnEncrypt;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _allowedUnsignedAttributes;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _allowedUnsignedAttributePrefix;
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> _algorithmSuiteId;
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> _keyring;
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> _cmm;
  public Wrappers_Compile.Option<LegacyOverride> _legacyOverride;
  public Wrappers_Compile.Option<PlaintextOverride> _plaintextOverride;
  public DynamoDbTableEncryptionConfig (dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Wrappers_Compile.Option<SearchConfig> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnsignedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnsignedAttributePrefix, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> keyring, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> cmm, Wrappers_Compile.Option<LegacyOverride> legacyOverride, Wrappers_Compile.Option<PlaintextOverride> plaintextOverride) {
    this._logicalTableName = logicalTableName;
    this._partitionKeyName = partitionKeyName;
    this._sortKeyName = sortKeyName;
    this._search = search;
    this._attributeActionsOnEncrypt = attributeActionsOnEncrypt;
    this._allowedUnsignedAttributes = allowedUnsignedAttributes;
    this._allowedUnsignedAttributePrefix = allowedUnsignedAttributePrefix;
    this._algorithmSuiteId = algorithmSuiteId;
    this._keyring = keyring;
    this._cmm = cmm;
    this._legacyOverride = legacyOverride;
    this._plaintextOverride = plaintextOverride;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DynamoDbTableEncryptionConfig o = (DynamoDbTableEncryptionConfig)other;
    return true && java.util.Objects.equals(this._logicalTableName, o._logicalTableName) && java.util.Objects.equals(this._partitionKeyName, o._partitionKeyName) && java.util.Objects.equals(this._sortKeyName, o._sortKeyName) && java.util.Objects.equals(this._search, o._search) && java.util.Objects.equals(this._attributeActionsOnEncrypt, o._attributeActionsOnEncrypt) && java.util.Objects.equals(this._allowedUnsignedAttributes, o._allowedUnsignedAttributes) && java.util.Objects.equals(this._allowedUnsignedAttributePrefix, o._allowedUnsignedAttributePrefix) && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && java.util.Objects.equals(this._keyring, o._keyring) && java.util.Objects.equals(this._cmm, o._cmm) && java.util.Objects.equals(this._legacyOverride, o._legacyOverride) && java.util.Objects.equals(this._plaintextOverride, o._plaintextOverride);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._logicalTableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partitionKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sortKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._search);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributeActionsOnEncrypt);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._allowedUnsignedAttributes);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._allowedUnsignedAttributePrefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyring);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmm);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._legacyOverride);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextOverride);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig.DynamoDbTableEncryptionConfig");
    s.append("(");
    s.append(dafny.Helpers.toString(this._logicalTableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._partitionKeyName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._sortKeyName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._search));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._attributeActionsOnEncrypt));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._allowedUnsignedAttributes));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._allowedUnsignedAttributePrefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._keyring));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cmm));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._legacyOverride));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._plaintextOverride));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DynamoDbTableEncryptionConfig> _TYPE = dafny.TypeDescriptor.<DynamoDbTableEncryptionConfig>referenceWithInitializer(DynamoDbTableEncryptionConfig.class, () -> DynamoDbTableEncryptionConfig.Default());
  public static dafny.TypeDescriptor<DynamoDbTableEncryptionConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbTableEncryptionConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DynamoDbTableEncryptionConfig theDefault = DynamoDbTableEncryptionConfig.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()), Wrappers_Compile.Option.<SearchConfig>Default(SearchConfig._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> empty(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>Default(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeNameList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>Default(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>Default(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class))), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>Default(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class))), Wrappers_Compile.Option.<LegacyOverride>Default(LegacyOverride._typeDescriptor()), Wrappers_Compile.Option.<PlaintextOverride>Default(PlaintextOverride._typeDescriptor()));
  public static DynamoDbTableEncryptionConfig Default() {
    return theDefault;
  }
  public static DynamoDbTableEncryptionConfig create(dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Wrappers_Compile.Option<SearchConfig> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnsignedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnsignedAttributePrefix, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> keyring, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> cmm, Wrappers_Compile.Option<LegacyOverride> legacyOverride, Wrappers_Compile.Option<PlaintextOverride> plaintextOverride) {
    return new DynamoDbTableEncryptionConfig(logicalTableName, partitionKeyName, sortKeyName, search, attributeActionsOnEncrypt, allowedUnsignedAttributes, allowedUnsignedAttributePrefix, algorithmSuiteId, keyring, cmm, legacyOverride, plaintextOverride);
  }
  public static DynamoDbTableEncryptionConfig create_DynamoDbTableEncryptionConfig(dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Wrappers_Compile.Option<SearchConfig> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnsignedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnsignedAttributePrefix, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> keyring, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> cmm, Wrappers_Compile.Option<LegacyOverride> legacyOverride, Wrappers_Compile.Option<PlaintextOverride> plaintextOverride) {
    return create(logicalTableName, partitionKeyName, sortKeyName, search, attributeActionsOnEncrypt, allowedUnsignedAttributes, allowedUnsignedAttributePrefix, algorithmSuiteId, keyring, cmm, legacyOverride, plaintextOverride);
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
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> dtor_attributeActionsOnEncrypt() {
    return this._attributeActionsOnEncrypt;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> dtor_allowedUnsignedAttributes() {
    return this._allowedUnsignedAttributes;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_allowedUnsignedAttributePrefix() {
    return this._allowedUnsignedAttributePrefix;
  }
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> dtor_algorithmSuiteId() {
    return this._algorithmSuiteId;
  }
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring> dtor_keyring() {
    return this._keyring;
  }
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager> dtor_cmm() {
    return this._cmm;
  }
  public Wrappers_Compile.Option<LegacyOverride> dtor_legacyOverride() {
    return this._legacyOverride;
  }
  public Wrappers_Compile.Option<PlaintextOverride> dtor_plaintextOverride() {
    return this._plaintextOverride;
  }
}
