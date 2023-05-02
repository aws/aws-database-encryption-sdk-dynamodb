// Class AuthenticateSchemaContent_SchemaMap
// Dafny class AuthenticateSchemaContent_SchemaMap compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class AuthenticateSchemaContent_SchemaMap extends AuthenticateSchemaContent {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateSchema> _SchemaMap;
  public AuthenticateSchemaContent_SchemaMap (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateSchema> SchemaMap) {
    this._SchemaMap = SchemaMap;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AuthenticateSchemaContent_SchemaMap o = (AuthenticateSchemaContent_SchemaMap)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.AuthenticateSchemaContent.SchemaMap");
    s.append("(");
    s.append(dafny.Helpers.toString(this._SchemaMap));
    s.append(")");
    return s.toString();
  }
}
