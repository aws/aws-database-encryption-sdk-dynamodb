// Class StructuredData
// Dafny class StructuredData compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class StructuredData {
  public StructuredDataContent _content;
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal>> _attributes;
  public StructuredData (StructuredDataContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal>> attributes) {
    this._content = content;
    this._attributes = attributes;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StructuredData o = (StructuredData)other;
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
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.StructuredData.StructuredData");
    s.append("(");
    s.append(dafny.Helpers.toString(this._content));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._attributes));
    s.append(")");
    return s.toString();
  }

  private static final StructuredData theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData.create(StructuredDataContent.Default(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal>>Default());
  public static StructuredData Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<StructuredData> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StructuredData.class, () -> Default());
  public static dafny.TypeDescriptor<StructuredData> _typeDescriptor() {
    return (dafny.TypeDescriptor<StructuredData>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static StructuredData create(StructuredDataContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal>> attributes) {
    return new StructuredData(content, attributes);
  }
  public static StructuredData create_StructuredData(StructuredDataContent content, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal>> attributes) {
    return create(content, attributes);
  }
  public boolean is_StructuredData() { return true; }
  public StructuredDataContent dtor_content() {
    return this._content;
  }
  public Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredDataTerminal>> dtor_attributes() {
    return this._attributes;
  }
}
