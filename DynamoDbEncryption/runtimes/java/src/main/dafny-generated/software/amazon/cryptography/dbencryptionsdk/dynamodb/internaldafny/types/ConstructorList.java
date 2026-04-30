// Class ConstructorList
// Dafny class ConstructorList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ConstructorList {
  public ConstructorList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends Constructor> __source) {
    dafny.DafnySequence<? extends Constructor> _4_x = __source;
    return __default.IsValid__ConstructorList(_4_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends Constructor>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends Constructor>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<Constructor> empty(Constructor._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends Constructor>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends Constructor>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
