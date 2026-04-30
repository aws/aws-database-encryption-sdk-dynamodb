// Class EncryptStructureOutput
// Dafny class EncryptStructureOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptStructureOutput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> _encryptedStructure;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> _cryptoSchema;
  public ParsedHeader _parsedHeader;
  public EncryptStructureOutput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> encryptedStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> cryptoSchema, ParsedHeader parsedHeader) {
    this._encryptedStructure = encryptedStructure;
    this._cryptoSchema = cryptoSchema;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptStructureOutput o = (EncryptStructureOutput)other;
    return true && java.util.Objects.equals(this._encryptedStructure, o._encryptedStructure) && java.util.Objects.equals(this._cryptoSchema, o._cryptoSchema) && java.util.Objects.equals(this._parsedHeader, o._parsedHeader);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedStructure);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cryptoSchema);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parsedHeader);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureOutput.EncryptStructureOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._encryptedStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cryptoSchema));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<EncryptStructureOutput> _TYPE = dafny.TypeDescriptor.<EncryptStructureOutput>referenceWithInitializer(EncryptStructureOutput.class, () -> EncryptStructureOutput.Default());
  public static dafny.TypeDescriptor<EncryptStructureOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptStructureOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EncryptStructureOutput theDefault = EncryptStructureOutput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,StructuredDataTerminal> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,CryptoAction> empty(), ParsedHeader.Default());
  public static EncryptStructureOutput Default() {
    return theDefault;
  }
  public static EncryptStructureOutput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> encryptedStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> cryptoSchema, ParsedHeader parsedHeader) {
    return new EncryptStructureOutput(encryptedStructure, cryptoSchema, parsedHeader);
  }
  public static EncryptStructureOutput create_EncryptStructureOutput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> encryptedStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> cryptoSchema, ParsedHeader parsedHeader) {
    return create(encryptedStructure, cryptoSchema, parsedHeader);
  }
  public boolean is_EncryptStructureOutput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> dtor_encryptedStructure() {
    return this._encryptedStructure;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoAction> dtor_cryptoSchema() {
    return this._cryptoSchema;
  }
  public ParsedHeader dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
