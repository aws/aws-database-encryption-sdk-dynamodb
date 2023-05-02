// Class ExprContext
// Dafny class ExprContext compiled into Java
package DynamoDBFilterExpr_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class ExprContext {
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _keyExpr;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _filterExpr;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _values;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _names;
  public ExprContext (Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
    this._keyExpr = keyExpr;
    this._filterExpr = filterExpr;
    this._values = values;
    this._names = names;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExprContext o = (ExprContext)other;
    return true && java.util.Objects.equals(this._keyExpr, o._keyExpr) && java.util.Objects.equals(this._filterExpr, o._filterExpr) && java.util.Objects.equals(this._values, o._values) && java.util.Objects.equals(this._names, o._names);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyExpr);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._filterExpr);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._values);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._names);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr_Compile.ExprContext.ExprContext");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keyExpr));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._filterExpr));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._values));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._names));
    s.append(")");
    return s.toString();
  }

  private static final ExprContext theDefault = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>Default(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>Default());
  public static ExprContext Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<ExprContext> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ExprContext.class, () -> Default());
  public static dafny.TypeDescriptor<ExprContext> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExprContext>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static ExprContext create(Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
    return new ExprContext(keyExpr, filterExpr, values, names);
  }
  public static ExprContext create_ExprContext(Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
    return create(keyExpr, filterExpr, values, names);
  }
  public boolean is_ExprContext() { return true; }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_keyExpr() {
    return this._keyExpr;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_filterExpr() {
    return this._filterExpr;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> dtor_values() {
    return this._values;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> dtor_names() {
    return this._names;
  }
}
