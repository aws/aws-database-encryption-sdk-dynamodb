// Class MaybeKeyMap_Keys
// Dafny class MaybeKeyMap_Keys compiled into Java
package DynamoDbEncryptionUtil_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class MaybeKeyMap_Keys extends MaybeKeyMap {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _value;
  public MaybeKeyMap_Keys (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> value) {
    this._value = value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    MaybeKeyMap_Keys o = (MaybeKeyMap_Keys)other;
    return true && java.util.Objects.equals(this._value, o._value);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._value);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDbEncryptionUtil_Compile.MaybeKeyMap.Keys");
    s.append("(");
    s.append(dafny.Helpers.toString(this._value));
    s.append(")");
    return s.toString();
  }
}
