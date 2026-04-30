// Class Config
// Dafny class Config compiled into Java
package AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Config {
  public byte _version;
  public software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _cmpClient;
  public dafny.DafnySequence<? extends Character> _logicalTableName;
  public dafny.DafnySequence<? extends Character> _partitionKeyName;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _sortKeyName;
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager _cmm;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _attributeActionsOnEncrypt;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _allowedUnsignedAttributes;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _allowedUnsignedAttributePrefix;
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> _algorithmSuiteId;
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient _structuredEncryption;
  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride _plaintextOverride;
  public Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride> _internalLegacyOverride;
  public Config (byte version, software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient cmpClient, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnsignedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnsignedAttributePrefix, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient structuredEncryption, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride plaintextOverride, Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride> internalLegacyOverride) {
    this._version = version;
    this._cmpClient = cmpClient;
    this._logicalTableName = logicalTableName;
    this._partitionKeyName = partitionKeyName;
    this._sortKeyName = sortKeyName;
    this._cmm = cmm;
    this._attributeActionsOnEncrypt = attributeActionsOnEncrypt;
    this._allowedUnsignedAttributes = allowedUnsignedAttributes;
    this._allowedUnsignedAttributePrefix = allowedUnsignedAttributePrefix;
    this._algorithmSuiteId = algorithmSuiteId;
    this._structuredEncryption = structuredEncryption;
    this._plaintextOverride = plaintextOverride;
    this._internalLegacyOverride = internalLegacyOverride;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Config o = (Config)other;
    return true && this._version == o._version && this._cmpClient == o._cmpClient && java.util.Objects.equals(this._logicalTableName, o._logicalTableName) && java.util.Objects.equals(this._partitionKeyName, o._partitionKeyName) && java.util.Objects.equals(this._sortKeyName, o._sortKeyName) && this._cmm == o._cmm && java.util.Objects.equals(this._attributeActionsOnEncrypt, o._attributeActionsOnEncrypt) && java.util.Objects.equals(this._allowedUnsignedAttributes, o._allowedUnsignedAttributes) && java.util.Objects.equals(this._allowedUnsignedAttributePrefix, o._allowedUnsignedAttributePrefix) && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && this._structuredEncryption == o._structuredEncryption && java.util.Objects.equals(this._plaintextOverride, o._plaintextOverride) && java.util.Objects.equals(this._internalLegacyOverride, o._internalLegacyOverride);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Byte.hashCode(this._version);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmpClient);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._logicalTableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partitionKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sortKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmm);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributeActionsOnEncrypt);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._allowedUnsignedAttributes);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._allowedUnsignedAttributePrefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._structuredEncryption);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextOverride);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._internalLegacyOverride);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Config.Config");
    s.append("(");
    s.append(this._version);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cmpClient));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._logicalTableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._partitionKeyName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._sortKeyName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cmm));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._attributeActionsOnEncrypt));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._allowedUnsignedAttributes));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._allowedUnsignedAttributePrefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._structuredEncryption));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._plaintextOverride));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._internalLegacyOverride));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<Config> _TYPE = dafny.TypeDescriptor.<Config>referenceWithInitializer(Config.class, () -> Config.Default());
  public static dafny.TypeDescriptor<Config> _typeDescriptor() {
    return (dafny.TypeDescriptor<Config>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Config theDefault = Config.create(StructuredEncryptionHeader_Compile.Version.defaultValue(), null, dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()), null, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> empty(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>Default(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeNameList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>Default(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), null, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.Default(), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride>Default(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride.class))));
  public static Config Default() {
    return theDefault;
  }
  public static Config create(byte version, software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient cmpClient, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnsignedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnsignedAttributePrefix, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient structuredEncryption, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride plaintextOverride, Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride> internalLegacyOverride) {
    return new Config(version, cmpClient, logicalTableName, partitionKeyName, sortKeyName, cmm, attributeActionsOnEncrypt, allowedUnsignedAttributes, allowedUnsignedAttributePrefix, algorithmSuiteId, structuredEncryption, plaintextOverride, internalLegacyOverride);
  }
  public static Config create_Config(byte version, software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient cmpClient, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnsignedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnsignedAttributePrefix, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient structuredEncryption, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride plaintextOverride, Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride> internalLegacyOverride) {
    return create(version, cmpClient, logicalTableName, partitionKeyName, sortKeyName, cmm, attributeActionsOnEncrypt, allowedUnsignedAttributes, allowedUnsignedAttributePrefix, algorithmSuiteId, structuredEncryption, plaintextOverride, internalLegacyOverride);
  }
  public boolean is_Config() { return true; }
  public byte dtor_version() {
    return this._version;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient dtor_cmpClient() {
    return this._cmpClient;
  }
  public dafny.DafnySequence<? extends Character> dtor_logicalTableName() {
    return this._logicalTableName;
  }
  public dafny.DafnySequence<? extends Character> dtor_partitionKeyName() {
    return this._partitionKeyName;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_sortKeyName() {
    return this._sortKeyName;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager dtor_cmm() {
    return this._cmm;
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
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.StructuredEncryptionClient dtor_structuredEncryption() {
    return this._structuredEncryption;
  }
  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride dtor_plaintextOverride() {
    return this._plaintextOverride;
  }
  public Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy.InternalLegacyOverride> dtor_internalLegacyOverride() {
    return this._internalLegacyOverride;
  }
}
