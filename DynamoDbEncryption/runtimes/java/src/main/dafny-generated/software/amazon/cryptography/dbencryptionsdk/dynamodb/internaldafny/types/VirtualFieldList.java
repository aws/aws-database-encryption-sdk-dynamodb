// Class VirtualFieldList
// Dafny class VirtualFieldList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualFieldList {
  public VirtualFieldList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends VirtualField> __source) {
    dafny.DafnySequence<? extends VirtualField> _5_x = __source;
    return __default.IsValid__VirtualFieldList(_5_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualField>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends VirtualField>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<VirtualField> empty(VirtualField._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualField>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualField>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
