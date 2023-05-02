// Class MultiKeyStore
// Dafny class MultiKeyStore compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class MultiKeyStore {
  public dafny.DafnySequence<? extends Character> _keyFieldName;
  public int _cacheTTL;
  public int _maxCacheSize;
  public MultiKeyStore (dafny.DafnySequence<? extends Character> keyFieldName, int cacheTTL, int maxCacheSize) {
    this._keyFieldName = keyFieldName;
    this._cacheTTL = cacheTTL;
    this._maxCacheSize = maxCacheSize;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    MultiKeyStore o = (MultiKeyStore)other;
    return true && java.util.Objects.equals(this._keyFieldName, o._keyFieldName) && this._cacheTTL == o._cacheTTL && this._maxCacheSize == o._maxCacheSize;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._keyFieldName);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._cacheTTL);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._maxCacheSize);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.MultiKeyStore.MultiKeyStore");
    s.append("(");
    s.append(dafny.Helpers.toString(this._keyFieldName));
    s.append(", ");
    s.append(this._cacheTTL);
    s.append(", ");
    s.append(this._maxCacheSize);
    s.append(")");
    return s.toString();
  }

  private static final MultiKeyStore theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.MultiKeyStore.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0, 0);
  public static MultiKeyStore Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<MultiKeyStore> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(MultiKeyStore.class, () -> Default());
  public static dafny.TypeDescriptor<MultiKeyStore> _typeDescriptor() {
    return (dafny.TypeDescriptor<MultiKeyStore>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static MultiKeyStore create(dafny.DafnySequence<? extends Character> keyFieldName, int cacheTTL, int maxCacheSize) {
    return new MultiKeyStore(keyFieldName, cacheTTL, maxCacheSize);
  }
  public static MultiKeyStore create_MultiKeyStore(dafny.DafnySequence<? extends Character> keyFieldName, int cacheTTL, int maxCacheSize) {
    return create(keyFieldName, cacheTTL, maxCacheSize);
  }
  public boolean is_MultiKeyStore() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_keyFieldName() {
    return this._keyFieldName;
  }
  public int dtor_cacheTTL() {
    return this._cacheTTL;
  }
  public int dtor_maxCacheSize() {
    return this._maxCacheSize;
  }
}
