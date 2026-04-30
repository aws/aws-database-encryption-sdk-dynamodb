// Class DecryptPathStructureOutput
// Dafny class DecryptPathStructureOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DecryptPathStructureOutput {
  public dafny.DafnySequence<? extends CryptoItem> _plaintextStructure;
  public ParsedHeader _parsedHeader;
  public DecryptPathStructureOutput (dafny.DafnySequence<? extends CryptoItem> plaintextStructure, ParsedHeader parsedHeader) {
    this._plaintextStructure = plaintextStructure;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptPathStructureOutput o = (DecryptPathStructureOutput)other;
    return true && java.util.Objects.equals(this._plaintextStructure, o._plaintextStructure) && java.util.Objects.equals(this._parsedHeader, o._parsedHeader);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextStructure);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parsedHeader);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureOutput.DecryptPathStructureOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._plaintextStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DecryptPathStructureOutput> _TYPE = dafny.TypeDescriptor.<DecryptPathStructureOutput>referenceWithInitializer(DecryptPathStructureOutput.class, () -> DecryptPathStructureOutput.Default());
  public static dafny.TypeDescriptor<DecryptPathStructureOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptPathStructureOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DecryptPathStructureOutput theDefault = DecryptPathStructureOutput.create(dafny.DafnySequence.<CryptoItem> empty(CryptoItem._typeDescriptor()), ParsedHeader.Default());
  public static DecryptPathStructureOutput Default() {
    return theDefault;
  }
  public static DecryptPathStructureOutput create(dafny.DafnySequence<? extends CryptoItem> plaintextStructure, ParsedHeader parsedHeader) {
    return new DecryptPathStructureOutput(plaintextStructure, parsedHeader);
  }
  public static DecryptPathStructureOutput create_DecryptPathStructureOutput(dafny.DafnySequence<? extends CryptoItem> plaintextStructure, ParsedHeader parsedHeader) {
    return create(plaintextStructure, parsedHeader);
  }
  public boolean is_DecryptPathStructureOutput() { return true; }
  public dafny.DafnySequence<? extends CryptoItem> dtor_plaintextStructure() {
    return this._plaintextStructure;
  }
  public ParsedHeader dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
