// Class MaybeKeyId_KeyId
// Dafny class MaybeKeyId_KeyId compiled into Java
package DynamoDbEncryptionUtil_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class MaybeKeyId_KeyId extends MaybeKeyId {
  public dafny.DafnySequence<? extends Character> _value;
  public MaybeKeyId_KeyId (dafny.DafnySequence<? extends Character> value) {
    this._value = value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    MaybeKeyId_KeyId o = (MaybeKeyId_KeyId)other;
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
    s.append("DynamoDbEncryptionUtil_Compile.MaybeKeyId.KeyId");
    s.append("(");
    s.append(dafny.Helpers.toString(this._value));
    s.append(")");
    return s.toString();
  }
}
