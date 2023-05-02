// Class MaybeKeyId_DontUseKeyId
// Dafny class MaybeKeyId_DontUseKeyId compiled into Java
package DynamoDbEncryptionUtil_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class MaybeKeyId_DontUseKeyId extends MaybeKeyId {
  public MaybeKeyId_DontUseKeyId () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    MaybeKeyId_DontUseKeyId o = (MaybeKeyId_DontUseKeyId)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDbEncryptionUtil_Compile.MaybeKeyId.DontUseKeyId");
    return s.toString();
  }
}
