// Class Insert
// Dafny class Insert compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Insert {
  public dafny.DafnySequence<? extends Character> _literal;
  public Insert (dafny.DafnySequence<? extends Character> literal) {
    this._literal = literal;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Insert o = (Insert)other;
    return true && java.util.Objects.equals(this._literal, o._literal);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._literal);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.Insert.Insert");
    s.append("(");
    s.append(dafny.Helpers.toString(this._literal));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<Insert> _TYPE = dafny.TypeDescriptor.<Insert>referenceWithInitializer(Insert.class, () -> Insert.Default());
  public static dafny.TypeDescriptor<Insert> _typeDescriptor() {
    return (dafny.TypeDescriptor<Insert>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Insert theDefault = Insert.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static Insert Default() {
    return theDefault;
  }
  public static Insert create(dafny.DafnySequence<? extends Character> literal) {
    return new Insert(literal);
  }
  public static Insert create_Insert(dafny.DafnySequence<? extends Character> literal) {
    return create(literal);
  }
  public boolean is_Insert() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_literal() {
    return this._literal;
  }
}
