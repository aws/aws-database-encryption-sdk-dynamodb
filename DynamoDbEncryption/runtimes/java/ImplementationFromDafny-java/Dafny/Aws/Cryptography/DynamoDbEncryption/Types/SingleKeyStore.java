// Class SingleKeyStore
// Dafny class SingleKeyStore compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class SingleKeyStore {
  public dafny.DafnySequence<? extends Character> _keyId;
  public int _cacheTTL;
  public SingleKeyStore (dafny.DafnySequence<? extends Character> keyId, int cacheTTL) {
    this._keyId = keyId;
    this._cacheTTL = cacheTTL;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    SingleKeyStore o = (SingleKeyStore)other;
    return true && java.util.Objects.equals(this._keyId, o._keyId) && this._cacheTTL == o._cacheTTL;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyId);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._cacheTTL);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.SingleKeyStore.SingleKeyStore");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keyId));
    s.append(", ");
    s.append(this._cacheTTL);
    s.append(")");
    return s.toString();
  }

  private static final SingleKeyStore theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SingleKeyStore.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0);
  public static SingleKeyStore Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<SingleKeyStore> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(SingleKeyStore.class, () -> Default());
  public static dafny.TypeDescriptor<SingleKeyStore> _typeDescriptor() {
    return (dafny.TypeDescriptor<SingleKeyStore>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static SingleKeyStore create(dafny.DafnySequence<? extends Character> keyId, int cacheTTL) {
    return new SingleKeyStore(keyId, cacheTTL);
  }
  public static SingleKeyStore create_SingleKeyStore(dafny.DafnySequence<? extends Character> keyId, int cacheTTL) {
    return create(keyId, cacheTTL);
  }
  public boolean is_SingleKeyStore() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_keyId() {
    return this._keyId;
  }
  public int dtor_cacheTTL() {
    return this._cacheTTL;
  }
}
