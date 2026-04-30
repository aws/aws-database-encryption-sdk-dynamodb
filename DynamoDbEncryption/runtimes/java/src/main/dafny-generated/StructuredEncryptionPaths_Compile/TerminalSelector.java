// Class TerminalSelector
// Dafny class TerminalSelector compiled into Java
package StructuredEncryptionPaths_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class TerminalSelector {
  public TerminalSelector() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends Selector> __source) {
    dafny.DafnySequence<? extends Selector> _0_x = __source;
    return __default.ValidTerminalSelector(_0_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends Selector>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends Selector>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<Selector> empty(Selector._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends Selector>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends Selector>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
