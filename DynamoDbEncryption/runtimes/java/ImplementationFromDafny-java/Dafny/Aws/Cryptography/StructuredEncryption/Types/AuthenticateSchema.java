// Class AuthenticateSchema
// Dafny class AuthenticateSchema compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class AuthenticateSchema {
  public AuthenticateSchemaContent _content;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> _attributes;
  public AuthenticateSchema (AuthenticateSchemaContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> attributes) {
    this._content = content;
    this._attributes = attributes;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AuthenticateSchema o = (AuthenticateSchema)other;
    return true && java.util.Objects.equals(this._content, o._content) && java.util.Objects.equals(this._attributes, o._attributes);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._content);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributes);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.AuthenticateSchema.AuthenticateSchema");
    s.append("(");
    s.append(dafny.Helpers.toString(this._content));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._attributes));
    s.append(")");
    return s.toString();
  }

  private static final AuthenticateSchema theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.create(AuthenticateSchemaContent.Default(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>>Default());
  public static AuthenticateSchema Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<AuthenticateSchema> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(AuthenticateSchema.class, () -> Default());
  public static dafny.TypeDescriptor<AuthenticateSchema> _typeDescriptor() {
    return (dafny.TypeDescriptor<AuthenticateSchema>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static AuthenticateSchema create(AuthenticateSchemaContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> attributes) {
    return new AuthenticateSchema(content, attributes);
  }
  public static AuthenticateSchema create_AuthenticateSchema(AuthenticateSchemaContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> attributes) {
    return create(content, attributes);
  }
  public boolean is_AuthenticateSchema() { return true; }
  public AuthenticateSchemaContent dtor_content() {
    return this._content;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> dtor_attributes() {
    return this._attributes;
  }
}
