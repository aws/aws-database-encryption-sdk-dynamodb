// Class EncryptPathStructureInput
// Dafny class EncryptPathStructureInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptPathStructureInput {
  public dafny.DafnySequence<? extends Character> _tableName;
  public dafny.DafnySequence<? extends CryptoItem> _plaintextStructure;
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager _cmm;
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> _algorithmSuiteId;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> _encryptionContext;
  public EncryptPathStructureInput (dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends CryptoItem> plaintextStructure, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    this._tableName = tableName;
    this._plaintextStructure = plaintextStructure;
    this._cmm = cmm;
    this._algorithmSuiteId = algorithmSuiteId;
    this._encryptionContext = encryptionContext;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptPathStructureInput o = (EncryptPathStructureInput)other;
    return true && java.util.Objects.equals(this._tableName, o._tableName) && java.util.Objects.equals(this._plaintextStructure, o._plaintextStructure) && this._cmm == o._cmm && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && java.util.Objects.equals(this._encryptionContext, o._encryptionContext);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextStructure);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmm);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptionContext);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureInput.EncryptPathStructureInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._plaintextStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cmm));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptionContext));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<EncryptPathStructureInput> _TYPE = dafny.TypeDescriptor.<EncryptPathStructureInput>referenceWithInitializer(EncryptPathStructureInput.class, () -> EncryptPathStructureInput.Default());
  public static dafny.TypeDescriptor<EncryptPathStructureInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptPathStructureInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EncryptPathStructureInput theDefault = EncryptPathStructureInput.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<CryptoItem> empty(CryptoItem._typeDescriptor()), null, Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>Default(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor())));
  public static EncryptPathStructureInput Default() {
    return theDefault;
  }
  public static EncryptPathStructureInput create(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends CryptoItem> plaintextStructure, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    return new EncryptPathStructureInput(tableName, plaintextStructure, cmm, algorithmSuiteId, encryptionContext);
  }
  public static EncryptPathStructureInput create_EncryptPathStructureInput(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends CryptoItem> plaintextStructure, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> algorithmSuiteId, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    return create(tableName, plaintextStructure, cmm, algorithmSuiteId, encryptionContext);
  }
  public boolean is_EncryptPathStructureInput() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_tableName() {
    return this._tableName;
  }
  public dafny.DafnySequence<? extends CryptoItem> dtor_plaintextStructure() {
    return this._plaintextStructure;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager dtor_cmm() {
    return this._cmm;
  }
  public Wrappers_Compile.Option<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId> dtor_algorithmSuiteId() {
    return this._algorithmSuiteId;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> dtor_encryptionContext() {
    return this._encryptionContext;
  }
}
