// Class DecryptStructureOutput
// Dafny class DecryptStructureOutput compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class DecryptStructureOutput {
  public StructuredData _plaintextStructure;
  public ParsedHeader _parsedHeader;
  public DecryptStructureOutput (StructuredData plaintextStructure, ParsedHeader parsedHeader) {
    this._plaintextStructure = plaintextStructure;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptStructureOutput o = (DecryptStructureOutput)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.DecryptStructureOutput.DecryptStructureOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._plaintextStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }

  private static final DecryptStructureOutput theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput.create(StructuredData.Default(), ParsedHeader.Default());
  public static DecryptStructureOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<DecryptStructureOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DecryptStructureOutput.class, () -> Default());
  public static dafny.TypeDescriptor<DecryptStructureOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptStructureOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static DecryptStructureOutput create(StructuredData plaintextStructure, ParsedHeader parsedHeader) {
    return new DecryptStructureOutput(plaintextStructure, parsedHeader);
  }
  public static DecryptStructureOutput create_DecryptStructureOutput(StructuredData plaintextStructure, ParsedHeader parsedHeader) {
    return create(plaintextStructure, parsedHeader);
  }
  public boolean is_DecryptStructureOutput() { return true; }
  public StructuredData dtor_plaintextStructure() {
    return this._plaintextStructure;
  }
  public ParsedHeader dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
