// Class GetEncryptedDataKeyDescriptionUnion_item
// Dafny class GetEncryptedDataKeyDescriptionUnion_item compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetEncryptedDataKeyDescriptionUnion_item extends GetEncryptedDataKeyDescriptionUnion {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _item;
  public GetEncryptedDataKeyDescriptionUnion_item (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item) {
    super();
    this._item = item;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetEncryptedDataKeyDescriptionUnion_item o = (GetEncryptedDataKeyDescriptionUnion_item)other;
    return true && java.util.Objects.equals(this._item, o._item);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._item);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionUnion.item");
    s.append("(");
    s.append(dafny.Helpers.toString(this._item));
    s.append(")");
    return s.toString();
  }
}
