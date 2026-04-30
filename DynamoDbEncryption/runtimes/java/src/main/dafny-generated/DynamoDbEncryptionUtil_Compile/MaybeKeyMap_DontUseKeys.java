// Class MaybeKeyMap_DontUseKeys
// Dafny class MaybeKeyMap_DontUseKeys compiled into Java
package DynamoDbEncryptionUtil_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class MaybeKeyMap_DontUseKeys extends MaybeKeyMap {
  public MaybeKeyMap_DontUseKeys () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    MaybeKeyMap_DontUseKeys o = (MaybeKeyMap_DontUseKeys)other;
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
    s.append("DynamoDbEncryptionUtil.MaybeKeyMap.DontUseKeys");
    return s.toString();
  }
}
