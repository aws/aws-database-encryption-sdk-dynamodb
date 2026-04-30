// Class VirtualTransformList
// Dafny class VirtualTransformList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransformList {
  public VirtualTransformList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends VirtualTransform> __source) {
    dafny.DafnySequence<? extends VirtualTransform> _7_x = __source;
    return __default.IsValid__VirtualTransformList(_7_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualTransform>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends VirtualTransform>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<VirtualTransform> empty(VirtualTransform._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualTransform>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualTransform>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
