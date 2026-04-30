// Class ConstructorPartList
// Dafny class ConstructorPartList compiled into Java
package CompoundBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class ConstructorPartList {
  public ConstructorPartList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends ConstructorPart> __source) {
    dafny.DafnySequence<? extends ConstructorPart> _10_x = __source;
    return (java.math.BigInteger.valueOf((_10_x).length())).signum() == 1;
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends ConstructorPart>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends ConstructorPart>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<ConstructorPart> empty(ConstructorPart._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends ConstructorPart>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends ConstructorPart>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
