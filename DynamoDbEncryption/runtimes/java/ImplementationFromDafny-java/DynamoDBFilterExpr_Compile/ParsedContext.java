// Class ParsedContext
// Dafny class ParsedContext compiled into Java
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
public class ParsedContext {
  public dafny.DafnySequence<? extends Token> _expr;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _values;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _names;
  public ParsedContext (dafny.DafnySequence<? extends Token> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
    this._expr = expr;
    this._values = values;
    this._names = names;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ParsedContext o = (ParsedContext)other;
    return true && java.util.Objects.equals(this._expr, o._expr) && java.util.Objects.equals(this._values, o._values) && java.util.Objects.equals(this._names, o._names);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._expr);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._values);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._names);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr_Compile.ParsedContext.ParsedContext");
    s.append("(");
    s.append(dafny.Helpers.toString(this._expr));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._values));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._names));
    s.append(")");
    return s.toString();
  }

  private static final ParsedContext theDefault = DynamoDBFilterExpr_Compile.ParsedContext.create(dafny.DafnySequence.<Token> empty(Token._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>Default());
  public static ParsedContext Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<ParsedContext> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ParsedContext.class, () -> Default());
  public static dafny.TypeDescriptor<ParsedContext> _typeDescriptor() {
    return (dafny.TypeDescriptor<ParsedContext>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static ParsedContext create(dafny.DafnySequence<? extends Token> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
    return new ParsedContext(expr, values, names);
  }
  public static ParsedContext create_ParsedContext(dafny.DafnySequence<? extends Token> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
    return create(expr, values, names);
  }
  public boolean is_ParsedContext() { return true; }
  public dafny.DafnySequence<? extends Token> dtor_expr() {
    return this._expr;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> dtor_values() {
    return this._values;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> dtor_names() {
    return this._names;
  }
}
