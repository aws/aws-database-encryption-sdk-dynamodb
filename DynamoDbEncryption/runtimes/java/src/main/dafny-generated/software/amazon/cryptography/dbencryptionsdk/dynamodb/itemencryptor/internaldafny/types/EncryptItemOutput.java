// Class EncryptItemOutput
// Dafny class EncryptItemOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptItemOutput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _encryptedItem;
  public Wrappers_Compile.Option<ParsedHeader> _parsedHeader;
  public EncryptItemOutput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> encryptedItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    this._encryptedItem = encryptedItem;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptItemOutput o = (EncryptItemOutput)other;
    return true && java.util.Objects.equals(this._encryptedItem, o._encryptedItem) && java.util.Objects.equals(this._parsedHeader, o._parsedHeader);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedItem);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parsedHeader);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput.EncryptItemOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._encryptedItem));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<EncryptItemOutput> _TYPE = dafny.TypeDescriptor.<EncryptItemOutput>referenceWithInitializer(EncryptItemOutput.class, () -> EncryptItemOutput.Default());
  public static dafny.TypeDescriptor<EncryptItemOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptItemOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EncryptItemOutput theDefault = EncryptItemOutput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty(), Wrappers_Compile.Option.<ParsedHeader>Default(ParsedHeader._typeDescriptor()));
  public static EncryptItemOutput Default() {
    return theDefault;
  }
  public static EncryptItemOutput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> encryptedItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    return new EncryptItemOutput(encryptedItem, parsedHeader);
  }
  public static EncryptItemOutput create_EncryptItemOutput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> encryptedItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    return create(encryptedItem, parsedHeader);
  }
  public boolean is_EncryptItemOutput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> dtor_encryptedItem() {
    return this._encryptedItem;
  }
  public Wrappers_Compile.Option<ParsedHeader> dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
