// Class StructuredDataContent_Terminal
// Dafny class StructuredDataContent_Terminal compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class StructuredDataContent_Terminal extends StructuredDataContent {
  public StructuredDataTerminal _Terminal;
  public StructuredDataContent_Terminal (StructuredDataTerminal Terminal) {
    this._Terminal = Terminal;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StructuredDataContent_Terminal o = (StructuredDataContent_Terminal)other;
    return true && java.util.Objects.equals(this._Terminal, o._Terminal);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._Terminal);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.StructuredDataContent.Terminal");
    s.append("(");
    s.append(dafny.Helpers.toString(this._Terminal));
    s.append(")");
    return s.toString();
  }
}
