// Class Error_ComAmazonawsDynamodb
// Dafny class Error_ComAmazonawsDynamodb compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Error_ComAmazonawsDynamodb extends Error {
  public Dafny.Com.Amazonaws.Dynamodb.Types.Error _ComAmazonawsDynamodb;
  public Error_ComAmazonawsDynamodb (Dafny.Com.Amazonaws.Dynamodb.Types.Error ComAmazonawsDynamodb) {
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.Error.ComAmazonawsDynamodb");
    s.append("(");
    s.append(dafny.Helpers.toString(this._ComAmazonawsDynamodb));
    s.append(")");
    return s.toString();
  }
}
