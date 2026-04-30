// Class DecryptStructureInput
// Dafny class DecryptStructureInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DecryptStructureInput {
  public dafny.DafnySequence<? extends Character> _tableName;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> _encryptedStructure;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction> _authenticateSchema;
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager _cmm;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> _encryptionContext;
  public DecryptStructureInput (dafny.DafnySequence<? extends Character> tableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> encryptedStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction> authenticateSchema, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    this._tableName = tableName;
    this._encryptedStructure = encryptedStructure;
    this._authenticateSchema = authenticateSchema;
    this._cmm = cmm;
    this._encryptionContext = encryptionContext;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptStructureInput o = (DecryptStructureInput)other;
    return true && java.util.Objects.equals(this._tableName, o._tableName) && java.util.Objects.equals(this._encryptedStructure, o._encryptedStructure) && java.util.Objects.equals(this._authenticateSchema, o._authenticateSchema) && this._cmm == o._cmm && java.util.Objects.equals(this._encryptionContext, o._encryptionContext);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedStructure);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._authenticateSchema);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cmm);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptionContext);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureInput.DecryptStructureInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptedStructure));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._authenticateSchema));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cmm));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptionContext));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DecryptStructureInput> _TYPE = dafny.TypeDescriptor.<DecryptStructureInput>referenceWithInitializer(DecryptStructureInput.class, () -> DecryptStructureInput.Default());
  public static dafny.TypeDescriptor<DecryptStructureInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptStructureInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DecryptStructureInput theDefault = DecryptStructureInput.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,StructuredDataTerminal> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,AuthenticateAction> empty(), null, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor())));
  public static DecryptStructureInput Default() {
    return theDefault;
  }
  public static DecryptStructureInput create(dafny.DafnySequence<? extends Character> tableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> encryptedStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction> authenticateSchema, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    return new DecryptStructureInput(tableName, encryptedStructure, authenticateSchema, cmm, encryptionContext);
  }
  public static DecryptStructureInput create_DecryptStructureInput(dafny.DafnySequence<? extends Character> tableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> encryptedStructure, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction> authenticateSchema, software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext) {
    return create(tableName, encryptedStructure, authenticateSchema, cmm, encryptionContext);
  }
  public boolean is_DecryptStructureInput() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_tableName() {
    return this._tableName;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal> dtor_encryptedStructure() {
    return this._encryptedStructure;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction> dtor_authenticateSchema() {
    return this._authenticateSchema;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager dtor_cmm() {
    return this._cmm;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> dtor_encryptionContext() {
    return this._encryptionContext;
  }
}
