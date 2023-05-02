// Class CryptoSchemaContent_SchemaList
// Dafny class CryptoSchemaContent_SchemaList compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoSchemaContent_SchemaList extends CryptoSchemaContent {
  public dafny.DafnySequence<? extends CryptoSchema> _SchemaList;
  public CryptoSchemaContent_SchemaList (dafny.DafnySequence<? extends CryptoSchema> SchemaList) {
    this._SchemaList = SchemaList;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CryptoSchemaContent_SchemaList o = (CryptoSchemaContent_SchemaList)other;
    return true && java.util.Objects.equals(this._SchemaList, o._SchemaList);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._SchemaList);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.CryptoSchemaContent.SchemaList");
    s.append("(");
    s.append(dafny.Helpers.toString(this._SchemaList));
    s.append(")");
    return s.toString();
  }
}
