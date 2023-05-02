// Class TableConfig
// Dafny class TableConfig compiled into Java
package DdbMiddlewareConfig_Compile;

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
import AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class TableConfig {
  public dafny.DafnySequence<? extends Character> _physicalTableName;
  public dafny.DafnySequence<? extends Character> _logicalTableName;
  public dafny.DafnySequence<? extends Character> _partitionKeyName;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _sortKeyName;
  public Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient _itemEncryptor;
  public Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> _search;
  public TableConfig (dafny.DafnySequence<? extends Character> physicalTableName, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient itemEncryptor, Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search) {
    this._physicalTableName = physicalTableName;
    this._logicalTableName = logicalTableName;
    this._partitionKeyName = partitionKeyName;
    this._sortKeyName = sortKeyName;
    this._itemEncryptor = itemEncryptor;
    this._search = search;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TableConfig o = (TableConfig)other;
    return true && java.util.Objects.equals(this._physicalTableName, o._physicalTableName) && java.util.Objects.equals(this._logicalTableName, o._logicalTableName) && java.util.Objects.equals(this._partitionKeyName, o._partitionKeyName) && java.util.Objects.equals(this._sortKeyName, o._sortKeyName) && this._itemEncryptor == o._itemEncryptor && java.util.Objects.equals(this._search, o._search);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._physicalTableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._logicalTableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._partitionKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sortKeyName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._itemEncryptor);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._search);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DdbMiddlewareConfig_Compile.TableConfig.TableConfig");
    s.append("(");
    s.append(dafny.Helpers.toString(this._physicalTableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._logicalTableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._partitionKeyName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._sortKeyName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._itemEncryptor));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._search));
    s.append(")");
    return s.toString();
  }

  private static final TableConfig theDefault = DdbMiddlewareConfig_Compile.TableConfig.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(), null, Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>Default());
  public static TableConfig Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<TableConfig> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(TableConfig.class, () -> Default());
  public static dafny.TypeDescriptor<TableConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<TableConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static TableConfig create(dafny.DafnySequence<? extends Character> physicalTableName, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient itemEncryptor, Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search) {
    return new TableConfig(physicalTableName, logicalTableName, partitionKeyName, sortKeyName, itemEncryptor, search);
  }
  public static TableConfig create_TableConfig(dafny.DafnySequence<? extends Character> physicalTableName, dafny.DafnySequence<? extends Character> logicalTableName, dafny.DafnySequence<? extends Character> partitionKeyName, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient itemEncryptor, Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search) {
    return create(physicalTableName, logicalTableName, partitionKeyName, sortKeyName, itemEncryptor, search);
  }
  public boolean is_TableConfig() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_physicalTableName() {
    return this._physicalTableName;
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
  public Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient dtor_itemEncryptor() {
    return this._itemEncryptor;
  }
  public Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> dtor_search() {
    return this._search;
  }
}
