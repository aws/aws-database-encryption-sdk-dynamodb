// Class CryptoSchemaContent_SchemaMap
// Dafny class CryptoSchemaContent_SchemaMap compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoSchemaContent_SchemaMap extends CryptoSchemaContent {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoSchema> _SchemaMap;
  public CryptoSchemaContent_SchemaMap (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoSchema> SchemaMap) {
    this._SchemaMap = SchemaMap;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CryptoSchemaContent_SchemaMap o = (CryptoSchemaContent_SchemaMap)other;
    return true && java.util.Objects.equals(this._SchemaMap, o._SchemaMap);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._SchemaMap);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.CryptoSchemaContent.SchemaMap");
    s.append("(");
    s.append(dafny.Helpers.toString(this._SchemaMap));
    s.append(")");
    return s.toString();
  }
}
