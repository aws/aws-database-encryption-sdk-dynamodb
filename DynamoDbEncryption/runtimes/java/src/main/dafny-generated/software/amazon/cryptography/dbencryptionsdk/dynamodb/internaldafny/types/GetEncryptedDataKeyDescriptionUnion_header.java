// Class GetEncryptedDataKeyDescriptionUnion_header
// Dafny class GetEncryptedDataKeyDescriptionUnion_header compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetEncryptedDataKeyDescriptionUnion_header extends GetEncryptedDataKeyDescriptionUnion {
  public dafny.DafnySequence<? extends java.lang.Byte> _header;
  public GetEncryptedDataKeyDescriptionUnion_header (dafny.DafnySequence<? extends java.lang.Byte> header) {
    super();
    this._header = header;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetEncryptedDataKeyDescriptionUnion_header o = (GetEncryptedDataKeyDescriptionUnion_header)other;
    return true && java.util.Objects.equals(this._header, o._header);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._header);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionUnion.header");
    s.append("(");
    s.append(dafny.Helpers.toString(this._header));
    s.append(")");
    return s.toString();
  }
}
