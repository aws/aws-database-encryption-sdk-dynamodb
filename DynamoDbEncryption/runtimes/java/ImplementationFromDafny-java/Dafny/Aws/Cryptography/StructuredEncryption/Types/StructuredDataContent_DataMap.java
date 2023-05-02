// Class StructuredDataContent_DataMap
// Dafny class StructuredDataContent_DataMap compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class StructuredDataContent_DataMap extends StructuredDataContent {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredData> _DataMap;
  public StructuredDataContent_DataMap (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredData> DataMap) {
    this._DataMap = DataMap;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StructuredDataContent_DataMap o = (StructuredDataContent_DataMap)other;
    return true && java.util.Objects.equals(this._DataMap, o._DataMap);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._DataMap);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.StructuredDataContent.DataMap");
    s.append("(");
    s.append(dafny.Helpers.toString(this._DataMap));
    s.append(")");
    return s.toString();
  }
}
