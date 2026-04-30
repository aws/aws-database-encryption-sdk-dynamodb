// Class ParsedContext
// Dafny class ParsedContext compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class ParsedContext {
  public dafny.DafnySequence<? extends Token> _expr;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _values;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _names;
  public ParsedContext (dafny.DafnySequence<? extends Token> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
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
    s.append("DynamoDBFilterExpr.ParsedContext.ParsedContext");
    s.append("(");
    s.append(dafny.Helpers.toString(this._expr));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._values));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._names));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ParsedContext> _TYPE = dafny.TypeDescriptor.<ParsedContext>referenceWithInitializer(ParsedContext.class, () -> ParsedContext.Default());
  public static dafny.TypeDescriptor<ParsedContext> _typeDescriptor() {
    return (dafny.TypeDescriptor<ParsedContext>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ParsedContext theDefault = ParsedContext.create(dafny.DafnySequence.<Token> empty(Token._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
  public static ParsedContext Default() {
    return theDefault;
  }
  public static ParsedContext create(dafny.DafnySequence<? extends Token> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
    return new ParsedContext(expr, values, names);
  }
  public static ParsedContext create_ParsedContext(dafny.DafnySequence<? extends Token> expr, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names) {
    return create(expr, values, names);
  }
  public boolean is_ParsedContext() { return true; }
  public dafny.DafnySequence<? extends Token> dtor_expr() {
    return this._expr;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> dtor_values() {
    return this._values;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> dtor_names() {
    return this._names;
  }
}
