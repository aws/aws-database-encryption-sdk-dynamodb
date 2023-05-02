// Class AuthenticateSchemaContent
// Dafny class AuthenticateSchemaContent compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public abstract class AuthenticateSchemaContent {
  public AuthenticateSchemaContent() { }

  private static final AuthenticateSchemaContent theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_Action(AuthenticateAction.Default());
  public static AuthenticateSchemaContent Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<AuthenticateSchemaContent> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(AuthenticateSchemaContent.class, () -> Default());
  public static dafny.TypeDescriptor<AuthenticateSchemaContent> _typeDescriptor() {
    return (dafny.TypeDescriptor<AuthenticateSchemaContent>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static AuthenticateSchemaContent create_Action(AuthenticateAction Action) {
    return new AuthenticateSchemaContent_Action(Action);
  }
  public static AuthenticateSchemaContent create_SchemaMap(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateSchema> SchemaMap) {
    return new AuthenticateSchemaContent_SchemaMap(SchemaMap);
  }
  public static AuthenticateSchemaContent create_SchemaList(dafny.DafnySequence<? extends AuthenticateSchema> SchemaList) {
    return new AuthenticateSchemaContent_SchemaList(SchemaList);
  }
  public boolean is_Action() { return this instanceof AuthenticateSchemaContent_Action; }
  public boolean is_SchemaMap() { return this instanceof AuthenticateSchemaContent_SchemaMap; }
  public boolean is_SchemaList() { return this instanceof AuthenticateSchemaContent_SchemaList; }
  public AuthenticateAction dtor_Action() {
    AuthenticateSchemaContent d = this;
    return ((AuthenticateSchemaContent_Action)d)._Action;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateSchema> dtor_SchemaMap() {
    AuthenticateSchemaContent d = this;
    return ((AuthenticateSchemaContent_SchemaMap)d)._SchemaMap;
  }
  public dafny.DafnySequence<? extends AuthenticateSchema> dtor_SchemaList() {
    AuthenticateSchemaContent d = this;
    return ((AuthenticateSchemaContent_SchemaList)d)._SchemaList;
  }
}
