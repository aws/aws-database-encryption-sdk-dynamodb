// Class OpaqueError
// Dafny class OpaqueError compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class OpaqueError {
  public OpaqueError() {
  }
  public static boolean _Is(Error __source) {
    Error _8_e = __source;
    return ((_8_e).is_Opaque()) || ((_8_e).is_OpaqueWithText());
  }
  private static final dafny.TypeDescriptor<Error> _TYPE = dafny.TypeDescriptor.<Error>referenceWithInitializer(Error.class, () -> Error.Default());
  public static dafny.TypeDescriptor<Error> _typeDescriptor() {
    return (dafny.TypeDescriptor<Error>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
