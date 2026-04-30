// Class DecryptStructureOutput
// Dafny class DecryptStructureOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DecryptStructureOutput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> _plaintextStructure;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> _cryptoSchema;
  public ParsedHeader _parsedHeader;
  public DecryptStructureOutput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> plaintextStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> cryptoSchema, ParsedHeader parsedHeader) {
    this._plaintextStructure = plaintextStructure;
    this._cryptoSchema = cryptoSchema;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptStructureOutput o = (DecryptStructureOutput)other;
    return true && java.util.Objects.equals(this._plaintextStructure, o._plaintextStructure) && java.util.Objects.equals(this._cryptoSchema, o._cryptoSchema) && java.util.Objects.equals(this._parsedHeader, o._parsedHeader);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextStructure);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cryptoSchema);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parsedHeader);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureOutput.DecryptStructureOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._plaintextStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cryptoSchema));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DecryptStructureOutput> _TYPE = dafny.TypeDescriptor.<DecryptStructureOutput>referenceWithInitializer(DecryptStructureOutput.class, () -> DecryptStructureOutput.Default());
  public static dafny.TypeDescriptor<DecryptStructureOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptStructureOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DecryptStructureOutput theDefault = DecryptStructureOutput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,StructuredDataTerminal> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,CryptoAction> empty(), ParsedHeader.Default());
  public static DecryptStructureOutput Default() {
    return theDefault;
  }
  public static DecryptStructureOutput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> plaintextStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> cryptoSchema, ParsedHeader parsedHeader) {
    return new DecryptStructureOutput(plaintextStructure, cryptoSchema, parsedHeader);
  }
  public static DecryptStructureOutput create_DecryptStructureOutput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> plaintextStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> cryptoSchema, ParsedHeader parsedHeader) {
    return create(plaintextStructure, cryptoSchema, parsedHeader);
  }
  public boolean is_DecryptStructureOutput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> dtor_plaintextStructure() {
    return this._plaintextStructure;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> dtor_cryptoSchema() {
    return this._cryptoSchema;
  }
  public ParsedHeader dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
