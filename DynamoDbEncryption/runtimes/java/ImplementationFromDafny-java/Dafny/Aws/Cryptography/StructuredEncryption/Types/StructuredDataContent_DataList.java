// Class StructuredDataContent_DataList
// Dafny class StructuredDataContent_DataList compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class StructuredDataContent_DataList extends StructuredDataContent {
  public dafny.DafnySequence<? extends StructuredData> _DataList;
  public StructuredDataContent_DataList (dafny.DafnySequence<? extends StructuredData> DataList) {
    this._DataList = DataList;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StructuredDataContent_DataList o = (StructuredDataContent_DataList)other;
    return true && java.util.Objects.equals(this._DataList, o._DataList);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._DataList);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.StructuredDataContent.DataList");
    s.append("(");
    s.append(dafny.Helpers.toString(this._DataList));
    s.append(")");
    return s.toString();
  }
}
