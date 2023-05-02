// Class Error
// Dafny class Error compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Error {
  public Error() { }

  private static final Error theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_StructuredEncryptionException(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static Error Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Error> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Error.class, () -> Default());
  public static dafny.TypeDescriptor<Error> _typeDescriptor() {
    return (dafny.TypeDescriptor<Error>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Error create_StructuredEncryptionException(dafny.DafnySequence<? extends Character> message) {
    return new Error_StructuredEncryptionException(message);
  }
  public static Error create_AwsCryptographyMaterialProviders(Dafny.Aws.Cryptography.MaterialProviders.Types.Error AwsCryptographyMaterialProviders) {
    return new Error_AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders);
  }
  public static Error create_AwsCryptographyPrimitives(Dafny.Aws.Cryptography.Primitives.Types.Error AwsCryptographyPrimitives) {
    return new Error_AwsCryptographyPrimitives(AwsCryptographyPrimitives);
  }
  public static Error create_CollectionOfErrors(dafny.DafnySequence<? extends Error> list) {
    return new Error_CollectionOfErrors(list);
  }
  public static Error create_Opaque(Object obj) {
    return new Error_Opaque(obj);
  }
  public boolean is_StructuredEncryptionException() { return this instanceof Error_StructuredEncryptionException; }
  public boolean is_AwsCryptographyMaterialProviders() { return this instanceof Error_AwsCryptographyMaterialProviders; }
  public boolean is_AwsCryptographyPrimitives() { return this instanceof Error_AwsCryptographyPrimitives; }
  public boolean is_CollectionOfErrors() { return this instanceof Error_CollectionOfErrors; }
  public boolean is_Opaque() { return this instanceof Error_Opaque; }
  public dafny.DafnySequence<? extends Character> dtor_message() {
    Error d = this;
    return ((Error_StructuredEncryptionException)d)._message;
  }
  public Dafny.Aws.Cryptography.MaterialProviders.Types.Error dtor_AwsCryptographyMaterialProviders() {
    Error d = this;
    return ((Error_AwsCryptographyMaterialProviders)d)._AwsCryptographyMaterialProviders;
  }
  public Dafny.Aws.Cryptography.Primitives.Types.Error dtor_AwsCryptographyPrimitives() {
    Error d = this;
    return ((Error_AwsCryptographyPrimitives)d)._AwsCryptographyPrimitives;
  }
  public dafny.DafnySequence<? extends Error> dtor_list() {
    Error d = this;
    return ((Error_CollectionOfErrors)d)._list;
  }
  public Object dtor_obj() {
    Error d = this;
    return ((Error_Opaque)d)._obj;
  }
}
