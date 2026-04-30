// Class SignedPartsList
// Dafny class SignedPartsList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class SignedPartsList {
  public SignedPartsList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends SignedPart> __source) {
    dafny.DafnySequence<? extends SignedPart> _1_x = __source;
    return __default.IsValid__SignedPartsList(_1_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends SignedPart>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends SignedPart>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<SignedPart> empty(SignedPart._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends SignedPart>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends SignedPart>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
