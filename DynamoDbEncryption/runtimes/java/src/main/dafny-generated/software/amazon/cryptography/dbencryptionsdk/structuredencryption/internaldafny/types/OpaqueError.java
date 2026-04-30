// Class OpaqueError
// Dafny class OpaqueError compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class OpaqueError {
  public OpaqueError() {
  }
  public static boolean _Is(Error __source) {
    Error _1_e = __source;
    return ((_1_e).is_Opaque()) || ((_1_e).is_OpaqueWithText());
  }
  private static final dafny.TypeDescriptor<Error> _TYPE = dafny.TypeDescriptor.<Error>referenceWithInitializer(Error.class, () -> Error.Default());
  public static dafny.TypeDescriptor<Error> _typeDescriptor() {
    return (dafny.TypeDescriptor<Error>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
