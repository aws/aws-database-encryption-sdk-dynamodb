// Class Error_AwsCryptographyDbEncryptionSdkStructuredEncryption
// Dafny class Error_AwsCryptographyDbEncryptionSdkStructuredEncryption compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_AwsCryptographyDbEncryptionSdkStructuredEncryption extends Error {
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error _AwsCryptographyDbEncryptionSdkStructuredEncryption;
  public Error_AwsCryptographyDbEncryptionSdkStructuredEncryption (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error AwsCryptographyDbEncryptionSdkStructuredEncryption) {
    super();
    this._AwsCryptographyDbEncryptionSdkStructuredEncryption = AwsCryptographyDbEncryptionSdkStructuredEncryption;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_AwsCryptographyDbEncryptionSdkStructuredEncryption o = (Error_AwsCryptographyDbEncryptionSdkStructuredEncryption)other;
    return true && java.util.Objects.equals(this._AwsCryptographyDbEncryptionSdkStructuredEncryption, o._AwsCryptographyDbEncryptionSdkStructuredEncryption);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._AwsCryptographyDbEncryptionSdkStructuredEncryption);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error.AwsCryptographyDbEncryptionSdkStructuredEncryption");
    s.append("(");
    s.append(dafny.Helpers.toString(this._AwsCryptographyDbEncryptionSdkStructuredEncryption));
    s.append(")");
    return s.toString();
  }
}
