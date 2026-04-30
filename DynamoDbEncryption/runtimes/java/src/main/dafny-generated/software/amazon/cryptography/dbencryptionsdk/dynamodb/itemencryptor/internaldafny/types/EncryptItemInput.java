// Class EncryptItemInput
// Dafny class EncryptItemInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptItemInput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _plaintextItem;
  public EncryptItemInput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> plaintextItem) {
    this._plaintextItem = plaintextItem;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptItemInput o = (EncryptItemInput)other;
    return true && java.util.Objects.equals(this._plaintextItem, o._plaintextItem);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextItem);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemInput.EncryptItemInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._plaintextItem));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<EncryptItemInput> _TYPE = dafny.TypeDescriptor.<EncryptItemInput>referenceWithInitializer(EncryptItemInput.class, () -> EncryptItemInput.Default());
  public static dafny.TypeDescriptor<EncryptItemInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptItemInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EncryptItemInput theDefault = EncryptItemInput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
  public static EncryptItemInput Default() {
    return theDefault;
  }
  public static EncryptItemInput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> plaintextItem) {
    return new EncryptItemInput(plaintextItem);
  }
  public static EncryptItemInput create_EncryptItemInput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> plaintextItem) {
    return create(plaintextItem);
  }
  public boolean is_EncryptItemInput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> dtor_plaintextItem() {
    return this._plaintextItem;
  }
}
