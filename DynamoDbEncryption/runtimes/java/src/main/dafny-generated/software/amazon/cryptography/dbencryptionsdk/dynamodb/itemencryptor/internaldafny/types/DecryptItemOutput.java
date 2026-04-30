// Class DecryptItemOutput
// Dafny class DecryptItemOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DecryptItemOutput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _plaintextItem;
  public Wrappers_Compile.Option<ParsedHeader> _parsedHeader;
  public DecryptItemOutput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> plaintextItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    this._plaintextItem = plaintextItem;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptItemOutput o = (DecryptItemOutput)other;
    return true && java.util.Objects.equals(this._plaintextItem, o._plaintextItem) && java.util.Objects.equals(this._parsedHeader, o._parsedHeader);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextItem);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parsedHeader);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput.DecryptItemOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._plaintextItem));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DecryptItemOutput> _TYPE = dafny.TypeDescriptor.<DecryptItemOutput>referenceWithInitializer(DecryptItemOutput.class, () -> DecryptItemOutput.Default());
  public static dafny.TypeDescriptor<DecryptItemOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptItemOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DecryptItemOutput theDefault = DecryptItemOutput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty(), Wrappers_Compile.Option.<ParsedHeader>Default(ParsedHeader._typeDescriptor()));
  public static DecryptItemOutput Default() {
    return theDefault;
  }
  public static DecryptItemOutput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> plaintextItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    return new DecryptItemOutput(plaintextItem, parsedHeader);
  }
  public static DecryptItemOutput create_DecryptItemOutput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> plaintextItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    return create(plaintextItem, parsedHeader);
  }
  public boolean is_DecryptItemOutput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> dtor_plaintextItem() {
    return this._plaintextItem;
  }
  public Wrappers_Compile.Option<ParsedHeader> dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
