// Class Error_DynamoDbEncryptionTransformsException
// Dafny class Error_DynamoDbEncryptionTransformsException compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_DynamoDbEncryptionTransformsException extends Error {
  public dafny.DafnySequence<? extends Character> _message;
  public Error_DynamoDbEncryptionTransformsException (dafny.DafnySequence<? extends Character> message) {
    super();
    this._message = message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_DynamoDbEncryptionTransformsException o = (Error_DynamoDbEncryptionTransformsException)other;
    return true && java.util.Objects.equals(this._message, o._message);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._message);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.DynamoDbEncryptionTransformsException");
    s.append("(");
    s.append(dafny.Helpers.toString(this._message));
    s.append(")");
    return s.toString();
  }
}
