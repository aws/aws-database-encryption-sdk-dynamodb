// Class EncryptStructureInput
// Dafny class EncryptStructureInput compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptStructureInput {
  public dafny.DafnySequence<? extends Character> _tableName;
  public StructuredData _plaintextStructure;
  public CryptoSchema _cryptoSchema;
  public Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager _cmm;
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> _algorithmSuiteId;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> _encryptionContext;
  public EncryptStructureInput (dafny.DafnySequence<? extends Character> tableName, StructuredData plaintextStructure, CryptoSchema cryptoSchema, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    this._tableName = tableName;
    this._plaintextStructure = plaintextStructure;
    this._cryptoSchema = cryptoSchema;
    this._cmm = cmm;
    this._algorithmSuiteId = algorithmSuiteId;
    this._encryptionContext = encryptionContext;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptStructureInput o = (EncryptStructureInput)other;
    return true && java.util.Objects.equals(this._tableName, o._tableName) && java.util.Objects.equals(this._plaintextStructure, o._plaintextStructure) && java.util.Objects.equals(this._cryptoSchema, o._cryptoSchema) && this._cmm == o._cmm && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && java.util.Objects.equals(this._encryptionContext, o._encryptionContext);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextStructure);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cryptoSchema);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmm);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptionContext);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.EncryptStructureInput.EncryptStructureInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._plaintextStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cryptoSchema));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cmm));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptionContext));
    s.append(")");
    return s.toString();
  }

  private static final EncryptStructureInput theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), StructuredData.Default(), CryptoSchema.Default(), null, Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId>Default(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>Default());
  public static EncryptStructureInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<EncryptStructureInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(EncryptStructureInput.class, () -> Default());
  public static dafny.TypeDescriptor<EncryptStructureInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptStructureInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static EncryptStructureInput create(dafny.DafnySequence<? extends Character> tableName, StructuredData plaintextStructure, CryptoSchema cryptoSchema, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    return new EncryptStructureInput(tableName, plaintextStructure, cryptoSchema, cmm, algorithmSuiteId, encryptionContext);
  }
  public static EncryptStructureInput create_EncryptStructureInput(dafny.DafnySequence<? extends Character> tableName, StructuredData plaintextStructure, CryptoSchema cryptoSchema, Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    return create(tableName, plaintextStructure, cryptoSchema, cmm, algorithmSuiteId, encryptionContext);
  }
  public boolean is_EncryptStructureInput() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_tableName() {
    return this._tableName;
  }
  public StructuredData dtor_plaintextStructure() {
    return this._plaintextStructure;
  }
  public CryptoSchema dtor_cryptoSchema() {
    return this._cryptoSchema;
  }
  public Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager dtor_cmm() {
    return this._cmm;
  }
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> dtor_algorithmSuiteId() {
    return this._algorithmSuiteId;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> dtor_encryptionContext() {
    return this._encryptionContext;
  }
}
