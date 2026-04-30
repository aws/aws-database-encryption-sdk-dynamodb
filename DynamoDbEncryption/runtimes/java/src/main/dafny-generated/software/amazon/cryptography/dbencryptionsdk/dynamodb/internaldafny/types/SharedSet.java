// Class SharedSet
// Dafny class SharedSet compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class SharedSet {
  public dafny.DafnySequence<? extends Character> _other;
  public SharedSet (dafny.DafnySequence<? extends Character> other) {
    this._other = other;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    SharedSet o = (SharedSet)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.SharedSet.SharedSet");
    s.append("(");
    s.append(dafny.Helpers.toString(this._other));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<SharedSet> _TYPE = dafny.TypeDescriptor.<SharedSet>referenceWithInitializer(SharedSet.class, () -> SharedSet.Default());
  public static dafny.TypeDescriptor<SharedSet> _typeDescriptor() {
    return (dafny.TypeDescriptor<SharedSet>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final SharedSet theDefault = SharedSet.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static SharedSet Default() {
    return theDefault;
  }
  public static SharedSet create(dafny.DafnySequence<? extends Character> other) {
    return new SharedSet(other);
  }
  public static SharedSet create_SharedSet(dafny.DafnySequence<? extends Character> other) {
    return create(other);
  }
  public boolean is_SharedSet() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_other() {
    return this._other;
  }
}
