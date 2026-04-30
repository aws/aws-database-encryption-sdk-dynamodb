// Class MaybeKeyId_ShouldHaveKeyId
// Dafny class MaybeKeyId_ShouldHaveKeyId compiled into Java
package DynamoDbEncryptionUtil_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class MaybeKeyId_ShouldHaveKeyId extends MaybeKeyId {
  public MaybeKeyId_ShouldHaveKeyId () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    MaybeKeyId_ShouldHaveKeyId o = (MaybeKeyId_ShouldHaveKeyId)other;
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
    s.append("DynamoDbEncryptionUtil.MaybeKeyId.ShouldHaveKeyId");
    return s.toString();
  }
}
