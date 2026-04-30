// Class DecryptItemInput
// Dafny class DecryptItemInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DecryptItemInput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _encryptedItem;
  public DecryptItemInput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> encryptedItem) {
    this._encryptedItem = encryptedItem;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptItemInput o = (DecryptItemInput)other;
    return true && java.util.Objects.equals(this._encryptedItem, o._encryptedItem);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedItem);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemInput.DecryptItemInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._encryptedItem));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DecryptItemInput> _TYPE = dafny.TypeDescriptor.<DecryptItemInput>referenceWithInitializer(DecryptItemInput.class, () -> DecryptItemInput.Default());
  public static dafny.TypeDescriptor<DecryptItemInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptItemInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DecryptItemInput theDefault = DecryptItemInput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
  public static DecryptItemInput Default() {
    return theDefault;
  }
  public static DecryptItemInput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> encryptedItem) {
    return new DecryptItemInput(encryptedItem);
  }
  public static DecryptItemInput create_DecryptItemInput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> encryptedItem) {
    return create(encryptedItem);
  }
  public boolean is_DecryptItemInput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> dtor_encryptedItem() {
    return this._encryptedItem;
  }
}
