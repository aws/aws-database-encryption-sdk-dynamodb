// Class EncryptPathStructureOutput
// Dafny class EncryptPathStructureOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptPathStructureOutput {
  public dafny.DafnySequence<? extends CryptoItem> _encryptedStructure;
  public ParsedHeader _parsedHeader;
  public EncryptPathStructureOutput (dafny.DafnySequence<? extends CryptoItem> encryptedStructure, ParsedHeader parsedHeader) {
    this._encryptedStructure = encryptedStructure;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptPathStructureOutput o = (EncryptPathStructureOutput)other;
    return true && java.util.Objects.equals(this._encryptedStructure, o._encryptedStructure) && java.util.Objects.equals(this._parsedHeader, o._parsedHeader);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedStructure);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parsedHeader);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureOutput.EncryptPathStructureOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._encryptedStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<EncryptPathStructureOutput> _TYPE = dafny.TypeDescriptor.<EncryptPathStructureOutput>referenceWithInitializer(EncryptPathStructureOutput.class, () -> EncryptPathStructureOutput.Default());
  public static dafny.TypeDescriptor<EncryptPathStructureOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptPathStructureOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EncryptPathStructureOutput theDefault = EncryptPathStructureOutput.create(dafny.DafnySequence.<CryptoItem> empty(CryptoItem._typeDescriptor()), ParsedHeader.Default());
  public static EncryptPathStructureOutput Default() {
    return theDefault;
  }
  public static EncryptPathStructureOutput create(dafny.DafnySequence<? extends CryptoItem> encryptedStructure, ParsedHeader parsedHeader) {
    return new EncryptPathStructureOutput(encryptedStructure, parsedHeader);
  }
  public static EncryptPathStructureOutput create_EncryptPathStructureOutput(dafny.DafnySequence<? extends CryptoItem> encryptedStructure, ParsedHeader parsedHeader) {
    return create(encryptedStructure, parsedHeader);
  }
  public boolean is_EncryptPathStructureOutput() { return true; }
  public dafny.DafnySequence<? extends CryptoItem> dtor_encryptedStructure() {
    return this._encryptedStructure;
  }
  public ParsedHeader dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
