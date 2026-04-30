// Class DecryptPathStructureInput
// Dafny class DecryptPathStructureInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DecryptPathStructureInput {
  public dafny.DafnySequence<? extends Character> _tableName;
  public dafny.DafnySequence<? extends AuthItem> _encryptedStructure;
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager _cmm;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> _encryptionContext;
  public DecryptPathStructureInput (dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends AuthItem> encryptedStructure, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    this._tableName = tableName;
    this._encryptedStructure = encryptedStructure;
    this._cmm = cmm;
    this._encryptionContext = encryptionContext;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptPathStructureInput o = (DecryptPathStructureInput)other;
    return true && java.util.Objects.equals(this._tableName, o._tableName) && java.util.Objects.equals(this._encryptedStructure, o._encryptedStructure) && this._cmm == o._cmm && java.util.Objects.equals(this._encryptionContext, o._encryptionContext);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedStructure);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmm);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptionContext);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureInput.DecryptPathStructureInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptedStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cmm));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptionContext));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DecryptPathStructureInput> _TYPE = dafny.TypeDescriptor.<DecryptPathStructureInput>referenceWithInitializer(DecryptPathStructureInput.class, () -> DecryptPathStructureInput.Default());
  public static dafny.TypeDescriptor<DecryptPathStructureInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptPathStructureInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DecryptPathStructureInput theDefault = DecryptPathStructureInput.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<AuthItem> empty(AuthItem._typeDescriptor()), null, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor())));
  public static DecryptPathStructureInput Default() {
    return theDefault;
  }
  public static DecryptPathStructureInput create(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends AuthItem> encryptedStructure, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    return new DecryptPathStructureInput(tableName, encryptedStructure, cmm, encryptionContext);
  }
  public static DecryptPathStructureInput create_DecryptPathStructureInput(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends AuthItem> encryptedStructure, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    return create(tableName, encryptedStructure, cmm, encryptionContext);
  }
  public boolean is_DecryptPathStructureInput() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_tableName() {
    return this._tableName;
  }
  public dafny.DafnySequence<? extends AuthItem> dtor_encryptedStructure() {
    return this._encryptedStructure;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager dtor_cmm() {
    return this._cmm;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> dtor_encryptionContext() {
    return this._encryptionContext;
  }
}
