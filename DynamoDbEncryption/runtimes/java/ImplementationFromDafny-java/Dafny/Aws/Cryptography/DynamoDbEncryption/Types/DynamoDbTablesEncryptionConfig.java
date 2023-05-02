// Class DynamoDbTablesEncryptionConfig
// Dafny class DynamoDbTablesEncryptionConfig compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbTablesEncryptionConfig {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> _tableEncryptionConfigs;
  public DynamoDbTablesEncryptionConfig (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> tableEncryptionConfigs) {
    this._tableEncryptionConfigs = tableEncryptionConfigs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DynamoDbTablesEncryptionConfig o = (DynamoDbTablesEncryptionConfig)other;
    return true && java.util.Objects.equals(this._tableEncryptionConfigs, o._tableEncryptionConfigs);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tableEncryptionConfigs);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.DynamoDbTablesEncryptionConfig.DynamoDbTablesEncryptionConfig");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tableEncryptionConfigs));
    s.append(")");
    return s.toString();
  }

  private static final DynamoDbTablesEncryptionConfig theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,DynamoDbTableEncryptionConfig> empty());
  public static DynamoDbTablesEncryptionConfig Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<DynamoDbTablesEncryptionConfig> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DynamoDbTablesEncryptionConfig.class, () -> Default());
  public static dafny.TypeDescriptor<DynamoDbTablesEncryptionConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbTablesEncryptionConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static DynamoDbTablesEncryptionConfig create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> tableEncryptionConfigs) {
    return new DynamoDbTablesEncryptionConfig(tableEncryptionConfigs);
  }
  public static DynamoDbTablesEncryptionConfig create_DynamoDbTablesEncryptionConfig(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> tableEncryptionConfigs) {
    return create(tableEncryptionConfigs);
  }
  public boolean is_DynamoDbTablesEncryptionConfig() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DynamoDbTableEncryptionConfig> dtor_tableEncryptionConfigs() {
    return this._tableEncryptionConfigs;
  }
}
