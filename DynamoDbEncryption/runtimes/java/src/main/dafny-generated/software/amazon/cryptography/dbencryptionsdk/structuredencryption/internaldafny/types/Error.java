// Class Error
// Dafny class Error compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Error {
  public Error() {
  }
  private static final dafny.TypeDescriptor<Error> _TYPE = dafny.TypeDescriptor.<Error>referenceWithInitializer(Error.class, () -> Error.Default());
  public static dafny.TypeDescriptor<Error> _typeDescriptor() {
    return (dafny.TypeDescriptor<Error>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Error theDefault = Error.create_StructuredEncryptionException(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static Error Default() {
    return theDefault;
  }
  public static Error create_StructuredEncryptionException(dafny.DafnySequence<? extends Character> message) {
    return new Error_StructuredEncryptionException(message);
  }
  public static Error create_AwsCryptographyMaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.types.Error AwsCryptographyMaterialProviders) {
    return new Error_AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders);
  }
  public static Error create_AwsCryptographyPrimitives(software.amazon.cryptography.primitives.internaldafny.types.Error AwsCryptographyPrimitives) {
    return new Error_AwsCryptographyPrimitives(AwsCryptographyPrimitives);
  }
  public static Error create_CollectionOfErrors(dafny.DafnySequence<? extends Error> list, dafny.DafnySequence<? extends Character> message) {
    return new Error_CollectionOfErrors(list, message);
  }
  public static Error create_Opaque(Object obj) {
    return new Error_Opaque(obj);
  }
  public static Error create_OpaqueWithText(Object obj, dafny.DafnySequence<? extends Character> objMessage) {
    return new Error_OpaqueWithText(obj, objMessage);
  }
  public boolean is_StructuredEncryptionException() { return this instanceof Error_StructuredEncryptionException; }
  public boolean is_AwsCryptographyMaterialProviders() { return this instanceof Error_AwsCryptographyMaterialProviders; }
  public boolean is_AwsCryptographyPrimitives() { return this instanceof Error_AwsCryptographyPrimitives; }
  public boolean is_CollectionOfErrors() { return this instanceof Error_CollectionOfErrors; }
  public boolean is_Opaque() { return this instanceof Error_Opaque; }
  public boolean is_OpaqueWithText() { return this instanceof Error_OpaqueWithText; }
  public dafny.DafnySequence<? extends Character> dtor_message() {
    Error d = this;
    if (d instanceof Error_StructuredEncryptionException) { return ((Error_StructuredEncryptionException)d)._message; }
    return ((Error_CollectionOfErrors)d)._message;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.Error dtor_AwsCryptographyMaterialProviders() {
    Error d = this;
    return ((Error_AwsCryptographyMaterialProviders)d)._AwsCryptographyMaterialProviders;
  }
  public software.amazon.cryptography.primitives.internaldafny.types.Error dtor_AwsCryptographyPrimitives() {
    Error d = this;
    return ((Error_AwsCryptographyPrimitives)d)._AwsCryptographyPrimitives;
  }
  public dafny.DafnySequence<? extends Error> dtor_list() {
    Error d = this;
    return ((Error_CollectionOfErrors)d)._list;
  }
  public Object dtor_obj() {
    Error d = this;
    if (d instanceof Error_Opaque) { return ((Error_Opaque)d)._obj; }
    return ((Error_OpaqueWithText)d)._obj;
  }
  public dafny.DafnySequence<? extends Character> dtor_objMessage() {
    Error d = this;
    return ((Error_OpaqueWithText)d)._objMessage;
  }
}
