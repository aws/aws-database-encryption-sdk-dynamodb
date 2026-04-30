// Class EncryptedPartsList
// Dafny class EncryptedPartsList compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptedPartsList {
  public EncryptedPartsList() {
  }
  public static boolean _Is(dafny.DafnySequence<? extends EncryptedPart> __source) {
    dafny.DafnySequence<? extends EncryptedPart> _0_x = __source;
    return __default.IsValid__EncryptedPartsList(_0_x);
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence<? extends EncryptedPart>> _TYPE = dafny.TypeDescriptor.<dafny.DafnySequence<? extends EncryptedPart>>referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<EncryptedPart> empty(EncryptedPart._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends EncryptedPart>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends EncryptedPart>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
