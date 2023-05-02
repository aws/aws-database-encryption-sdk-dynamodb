// Class MaybeKeyMap_ShouldHaveKeys
// Dafny class MaybeKeyMap_ShouldHaveKeys compiled into Java
package DynamoDbEncryptionUtil_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class MaybeKeyMap_ShouldHaveKeys extends MaybeKeyMap {
  public MaybeKeyMap_ShouldHaveKeys () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    MaybeKeyMap_ShouldHaveKeys o = (MaybeKeyMap_ShouldHaveKeys)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDbEncryptionUtil_Compile.MaybeKeyMap.ShouldHaveKeys");
    return s.toString();
  }
}
