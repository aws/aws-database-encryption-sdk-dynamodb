// Class Shared
// Dafny class Shared compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Shared {
  public dafny.DafnySequence<? extends Character> _other;
  public Shared (dafny.DafnySequence<? extends Character> other) {
    this._other = other;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Shared o = (Shared)other;
    return true && java.util.Objects.equals(this._other, o._other);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._other);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.Shared.Shared");
    s.append("(");
    s.append(dafny.Helpers.toString(this._other));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<Shared> _TYPE = dafny.TypeDescriptor.<Shared>referenceWithInitializer(Shared.class, () -> Shared.Default());
  public static dafny.TypeDescriptor<Shared> _typeDescriptor() {
    return (dafny.TypeDescriptor<Shared>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Shared theDefault = Shared.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static Shared Default() {
    return theDefault;
  }
  public static Shared create(dafny.DafnySequence<? extends Character> other) {
    return new Shared(other);
  }
  public static Shared create_Shared(dafny.DafnySequence<? extends Character> other) {
    return create(other);
  }
  public boolean is_Shared() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_other() {
    return this._other;
  }
}
