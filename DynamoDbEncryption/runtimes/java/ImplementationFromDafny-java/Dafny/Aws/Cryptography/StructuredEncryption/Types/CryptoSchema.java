// Class CryptoSchema
// Dafny class CryptoSchema compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoSchema {
  public CryptoSchemaContent _content;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> _attributes;
  public CryptoSchema (CryptoSchemaContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> attributes) {
    this._content = content;
    this._attributes = attributes;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CryptoSchema o = (CryptoSchema)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.CryptoSchema.CryptoSchema");
    s.append("(");
    s.append(dafny.Helpers.toString(this._content));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._attributes));
    s.append(")");
    return s.toString();
  }

  private static final CryptoSchema theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(CryptoSchemaContent.Default(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>>Default());
  public static CryptoSchema Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CryptoSchema> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CryptoSchema.class, () -> Default());
  public static dafny.TypeDescriptor<CryptoSchema> _typeDescriptor() {
    return (dafny.TypeDescriptor<CryptoSchema>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CryptoSchema create(CryptoSchemaContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> attributes) {
    return new CryptoSchema(content, attributes);
  }
  public static CryptoSchema create_CryptoSchema(CryptoSchemaContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> attributes) {
    return create(content, attributes);
  }
  public boolean is_CryptoSchema() { return true; }
  public CryptoSchemaContent dtor_content() {
    return this._content;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends AuthenticateAction>> dtor_attributes() {
    return this._attributes;
  }
}
