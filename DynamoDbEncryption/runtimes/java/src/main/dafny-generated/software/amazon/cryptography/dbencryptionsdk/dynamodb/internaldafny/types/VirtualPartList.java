// Class VirtualPartList
// Dafny class VirtualPartList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualPartList {
  public VirtualPartList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends VirtualPart> __source) {
    dafny.DafnySequence<? extends VirtualPart> _6_x = __source;
    return __default.IsValid__VirtualPartList(_6_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualPart>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends VirtualPart>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<VirtualPart> empty(VirtualPart._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualPart>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualPart>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
