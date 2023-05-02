// Class Config
// Dafny class Config compiled into Java
package AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;
import CompoundBeacon_Compile.*;
import SearchableEncryptionInfo_Compile.*;
import SearchConfigToInfo_Compile.*;
import DynamoDbUpdateExpr_Compile.*;
import DynamoDBFilterExpr_Compile.*;
import DynamoDBIndexSupport_Compile.*;
import DynamoDBSupport_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.*;
import DynamoDbItemEncryptorUtil_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Config {
  public Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient _cmpClient;
  public dafny.DafnySequence<? extends Character> _logicalTableName;
  public dafny.DafnySequence<? extends Character> _partitionKeyName;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _sortKeyName;
  public Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager _cmm;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _attributeActions;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _allowedUnauthenticatedAttributes;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _allowedUnauthenticatedAttributePrefix;
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> _algorithmSuiteId;
  public Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient _structuredEncryption;
  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy _plaintextPolicy;
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig> _internalLegacyConfig;
  public Config (Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient cmpClient, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager cmm, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnauthenticatedAttributePrefix, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient structuredEncryption, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy plaintextPolicy, Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig> internalLegacyConfig) {
    this._cmpClient = cmpClient;
    this._logicalTableName = logicalTableName;
    this._partitionKeyName = partitionKeyName;
    this._sortKeyName = sortKeyName;
    this._cmm = cmm;
    this._attributeActions = attributeActions;
    this._allowedUnauthenticatedAttributes = allowedUnauthenticatedAttributes;
    this._allowedUnauthenticatedAttributePrefix = allowedUnauthenticatedAttributePrefix;
    this._algorithmSuiteId = algorithmSuiteId;
    this._structuredEncryption = structuredEncryption;
    this._plaintextPolicy = plaintextPolicy;
    this._internalLegacyConfig = internalLegacyConfig;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Config o = (Config)other;
    return true && this._cmpClient == o._cmpClient && java.util.Objects.equals(this._logicalTableName, o._logicalTableName) && java.util.Objects.equals(this._partitionKeyName, o._partitionKeyName) && java.util.Objects.equals(this._sortKeyName, o._sortKeyName) && this._cmm == o._cmm && java.util.Objects.equals(this._attributeActions, o._attributeActions) && java.util.Objects.equals(this._allowedUnauthenticatedAttributes, o._allowedUnauthenticatedAttributes) && java.util.Objects.equals(this._allowedUnauthenticatedAttributePrefix, o._allowedUnauthenticatedAttributePrefix) && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && this._structuredEncryption == o._structuredEncryption && java.util.Objects.equals(this._plaintextPolicy, o._plaintextPolicy) && java.util.Objects.equals(this._internalLegacyConfig, o._internalLegacyConfig);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmpClient);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._logicalTableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partitionKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sortKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmm);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributeActions);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._allowedUnauthenticatedAttributes);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._allowedUnauthenticatedAttributePrefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._structuredEncryption);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextPolicy);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._internalLegacyConfig);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.Config.Config");
    s.append("(");
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
    s.append(dafny.Helpers.toString(this._attributeActions));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._allowedUnauthenticatedAttributes));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._allowedUnauthenticatedAttributePrefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._structuredEncryption));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._plaintextPolicy));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._internalLegacyConfig));
    s.append(")");
    return s.toString();
  }

  private static final Config theDefault = AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.Config.create(null, dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(), null, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> empty(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>Default(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId>Default(), null, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.Default(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig>Default());
  public static Config Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Config> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Config.class, () -> Default());
  public static dafny.TypeDescriptor<Config> _typeDescriptor() {
    return (dafny.TypeDescriptor<Config>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Config create(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient cmpClient, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager cmm, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnauthenticatedAttributePrefix, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient structuredEncryption, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy plaintextPolicy, Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig> internalLegacyConfig) {
    return new Config(cmpClient, logicalTableName, partitionKeyName, sortKeyName, cmm, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, structuredEncryption, plaintextPolicy, internalLegacyConfig);
  }
  public static Config create_Config(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient cmpClient, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager cmm, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> allowedUnauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> allowedUnauthenticatedAttributePrefix, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient structuredEncryption, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy plaintextPolicy, Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig> internalLegacyConfig) {
    return create(cmpClient, logicalTableName, partitionKeyName, sortKeyName, cmm, attributeActions, allowedUnauthenticatedAttributes, allowedUnauthenticatedAttributePrefix, algorithmSuiteId, structuredEncryption, plaintextPolicy, internalLegacyConfig);
  }
  public boolean is_Config() { return true; }
  public Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient dtor_cmpClient() {
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
  public Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager dtor_cmm() {
    return this._cmm;
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
  public Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient dtor_structuredEncryption() {
    return this._structuredEncryption;
  }
  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy dtor_plaintextPolicy() {
    return this._plaintextPolicy;
  }
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig> dtor_internalLegacyConfig() {
    return this._internalLegacyConfig;
  }
}
