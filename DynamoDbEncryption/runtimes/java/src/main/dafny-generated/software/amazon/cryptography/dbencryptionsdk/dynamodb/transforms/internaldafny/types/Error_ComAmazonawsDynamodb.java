// Class Error_ComAmazonawsDynamodb
// Dafny class Error_ComAmazonawsDynamodb compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_ComAmazonawsDynamodb extends Error {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.Error _ComAmazonawsDynamodb;
  public Error_ComAmazonawsDynamodb (software.amazon.cryptography.services.dynamodb.internaldafny.types.Error ComAmazonawsDynamodb) {
    super();
    this._ComAmazonawsDynamodb = ComAmazonawsDynamodb;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Error_ComAmazonawsDynamodb o = (Error_ComAmazonawsDynamodb)other;
    return true && java.util.Objects.equals(this._ComAmazonawsDynamodb, o._ComAmazonawsDynamodb);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 5;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._ComAmazonawsDynamodb);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.ComAmazonawsDynamodb");
    s.append("(");
    s.append(dafny.Helpers.toString(this._ComAmazonawsDynamodb));
    s.append(")");
    return s.toString();
  }
}
