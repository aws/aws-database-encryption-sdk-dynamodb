// Class Error_CollectionOfErrors
// Dafny class Error_CollectionOfErrors compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_CollectionOfErrors extends Error {
  public dafny.DafnySequence<? extends Error> _list;
  public dafny.DafnySequence<? extends Character> _message;
  public Error_CollectionOfErrors (dafny.DafnySequence<? extends Error> list, dafny.DafnySequence<? extends Character> message) {
    super();
    this._list = list;
    this._message = message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_CollectionOfErrors o = (Error_CollectionOfErrors)other;
    return true && java.util.Objects.equals(this._list, o._list) && java.util.Objects.equals(this._message, o._message);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 6;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._list);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._message);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.CollectionOfErrors");
    s.append("(");
    s.append(dafny.Helpers.toString(this._list));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._message));
    s.append(")");
    return s.toString();
  }
}
