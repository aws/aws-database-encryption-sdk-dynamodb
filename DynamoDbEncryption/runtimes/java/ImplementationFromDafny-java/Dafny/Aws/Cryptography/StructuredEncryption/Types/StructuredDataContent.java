// Class StructuredDataContent
// Dafny class StructuredDataContent compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public abstract class StructuredDataContent {
  public StructuredDataContent() { }

  private static final StructuredDataContent theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_Terminal(StructuredDataTerminal.Default());
  public static StructuredDataContent Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<StructuredDataContent> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StructuredDataContent.class, () -> Default());
  public static dafny.TypeDescriptor<StructuredDataContent> _typeDescriptor() {
    return (dafny.TypeDescriptor<StructuredDataContent>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static StructuredDataContent create_Terminal(StructuredDataTerminal Terminal) {
    return new StructuredDataContent_Terminal(Terminal);
  }
  public static StructuredDataContent create_DataList(dafny.DafnySequence<? extends StructuredData> DataList) {
    return new StructuredDataContent_DataList(DataList);
  }
  public static StructuredDataContent create_DataMap(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredData> DataMap) {
    return new StructuredDataContent_DataMap(DataMap);
  }
  public boolean is_Terminal() { return this instanceof StructuredDataContent_Terminal; }
  public boolean is_DataList() { return this instanceof StructuredDataContent_DataList; }
  public boolean is_DataMap() { return this instanceof StructuredDataContent_DataMap; }
  public StructuredDataTerminal dtor_Terminal() {
    StructuredDataContent d = this;
    return ((StructuredDataContent_Terminal)d)._Terminal;
  }
  public dafny.DafnySequence<? extends StructuredData> dtor_DataList() {
    StructuredDataContent d = this;
    return ((StructuredDataContent_DataList)d)._DataList;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends StructuredData> dtor_DataMap() {
    StructuredDataContent d = this;
    return ((StructuredDataContent_DataMap)d)._DataMap;
  }
}
