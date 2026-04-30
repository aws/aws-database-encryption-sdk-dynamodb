// Class TermLoc
// Dafny class TermLoc compiled into Java
package TermLoc_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class TermLoc {
  public TermLoc() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends Selector> __source) {
    dafny.DafnySequence<? extends Selector> _0_x = __source;
    return __default.ValidTermLoc(_0_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends Selector>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends Selector>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<Selector> empty(Selector._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends Selector>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends Selector>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
