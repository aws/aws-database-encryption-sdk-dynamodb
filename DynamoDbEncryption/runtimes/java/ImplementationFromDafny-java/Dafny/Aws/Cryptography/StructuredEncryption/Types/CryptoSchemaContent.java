// Class CryptoSchemaContent
// Dafny class CryptoSchemaContent compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public abstract class CryptoSchemaContent {
  public CryptoSchemaContent() { }

  private static final CryptoSchemaContent theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_Action(CryptoAction.Default());
  public static CryptoSchemaContent Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CryptoSchemaContent> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CryptoSchemaContent.class, () -> Default());
  public static dafny.TypeDescriptor<CryptoSchemaContent> _typeDescriptor() {
    return (dafny.TypeDescriptor<CryptoSchemaContent>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CryptoSchemaContent create_Action(CryptoAction Action) {
    return new CryptoSchemaContent_Action(Action);
  }
  public static CryptoSchemaContent create_SchemaMap(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoSchema> SchemaMap) {
    return new CryptoSchemaContent_SchemaMap(SchemaMap);
  }
  public static CryptoSchemaContent create_SchemaList(dafny.DafnySequence<? extends CryptoSchema> SchemaList) {
    return new CryptoSchemaContent_SchemaList(SchemaList);
  }
  public boolean is_Action() { return this instanceof CryptoSchemaContent_Action; }
  public boolean is_SchemaMap() { return this instanceof CryptoSchemaContent_SchemaMap; }
  public boolean is_SchemaList() { return this instanceof CryptoSchemaContent_SchemaList; }
  public CryptoAction dtor_Action() {
    CryptoSchemaContent d = this;
    return ((CryptoSchemaContent_Action)d)._Action;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends CryptoSchema> dtor_SchemaMap() {
    CryptoSchemaContent d = this;
    return ((CryptoSchemaContent_SchemaMap)d)._SchemaMap;
  }
  public dafny.DafnySequence<? extends CryptoSchema> dtor_SchemaList() {
    CryptoSchemaContent d = this;
    return ((CryptoSchemaContent_SchemaList)d)._SchemaList;
  }
}
