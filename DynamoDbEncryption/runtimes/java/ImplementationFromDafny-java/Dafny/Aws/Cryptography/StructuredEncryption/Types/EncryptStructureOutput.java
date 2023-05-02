// Class EncryptStructureOutput
// Dafny class EncryptStructureOutput compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptStructureOutput {
  public StructuredData _encryptedStructure;
  public ParsedHeader _parsedHeader;
  public EncryptStructureOutput (StructuredData encryptedStructure, ParsedHeader parsedHeader) {
    this._encryptedStructure = encryptedStructure;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptStructureOutput o = (EncryptStructureOutput)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.EncryptStructureOutput.EncryptStructureOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._encryptedStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }

  private static final EncryptStructureOutput theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput.create(StructuredData.Default(), ParsedHeader.Default());
  public static EncryptStructureOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<EncryptStructureOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(EncryptStructureOutput.class, () -> Default());
  public static dafny.TypeDescriptor<EncryptStructureOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptStructureOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static EncryptStructureOutput create(StructuredData encryptedStructure, ParsedHeader parsedHeader) {
    return new EncryptStructureOutput(encryptedStructure, parsedHeader);
  }
  public static EncryptStructureOutput create_EncryptStructureOutput(StructuredData encryptedStructure, ParsedHeader parsedHeader) {
    return create(encryptedStructure, parsedHeader);
  }
  public boolean is_EncryptStructureOutput() { return true; }
  public StructuredData dtor_encryptedStructure() {
    return this._encryptedStructure;
  }
  public ParsedHeader dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
