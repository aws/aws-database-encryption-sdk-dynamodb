// Class Error_OpaqueWithText
// Dafny class Error_OpaqueWithText compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_OpaqueWithText extends Error {
  public Object _obj;
  public dafny.DafnySequence<? extends Character> _objMessage;
  public Error_OpaqueWithText (Object obj, dafny.DafnySequence<? extends Character> objMessage) {
    super();
    this._obj = obj;
    this._objMessage = objMessage;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_OpaqueWithText o = (Error_OpaqueWithText)other;
    return true && this._obj == o._obj && java.util.Objects.equals(this._objMessage, o._objMessage);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 5;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._obj);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._objMessage);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.OpaqueWithText");
    s.append("(");
    s.append(dafny.Helpers.toString(this._obj));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._objMessage));
    s.append(")");
    return s.toString();
  }
}
