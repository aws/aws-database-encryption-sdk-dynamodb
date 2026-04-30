// Class Error
// Dafny class Error compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Error {
  public Error() {
  }
  private static final dafny.TypeDescriptor<Error> _TYPE = dafny.TypeDescriptor.<Error>referenceWithInitializer(Error.class, () -> Error.Default());
  public static dafny.TypeDescriptor<Error> _typeDescriptor() {
    return (dafny.TypeDescriptor<Error>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Error theDefault = Error.create_DynamoDbEncryptionException(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static Error Default() {
    return theDefault;
  }
  public static Error create_DynamoDbEncryptionException(dafny.DafnySequence<? extends Character> message) {
    return new Error_DynamoDbEncryptionException(message);
  }
  public static Error create_AwsCryptographyDbEncryptionSdkStructuredEncryption(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error AwsCryptographyDbEncryptionSdkStructuredEncryption) {
    return new Error_AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryption);
  }
  public static Error create_AwsCryptographyMaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.types.Error AwsCryptographyMaterialProviders) {
    return new Error_AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders);
  }
  public static Error create_AwsCryptographyKeyStore(software.amazon.cryptography.keystore.internaldafny.types.Error AwsCryptographyKeyStore) {
    return new Error_AwsCryptographyKeyStore(AwsCryptographyKeyStore);
  }
  public static Error create_AwsCryptographyPrimitives(software.amazon.cryptography.primitives.internaldafny.types.Error AwsCryptographyPrimitives) {
    return new Error_AwsCryptographyPrimitives(AwsCryptographyPrimitives);
  }
  public static Error create_ComAmazonawsDynamodb(software.amazon.cryptography.services.dynamodb.internaldafny.types.Error ComAmazonawsDynamodb) {
    return new Error_ComAmazonawsDynamodb(ComAmazonawsDynamodb);
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
  public boolean is_DynamoDbEncryptionException() { return this instanceof Error_DynamoDbEncryptionException; }
  public boolean is_AwsCryptographyDbEncryptionSdkStructuredEncryption() { return this instanceof Error_AwsCryptographyDbEncryptionSdkStructuredEncryption; }
  public boolean is_AwsCryptographyMaterialProviders() { return this instanceof Error_AwsCryptographyMaterialProviders; }
  public boolean is_AwsCryptographyKeyStore() { return this instanceof Error_AwsCryptographyKeyStore; }
  public boolean is_AwsCryptographyPrimitives() { return this instanceof Error_AwsCryptographyPrimitives; }
  public boolean is_ComAmazonawsDynamodb() { return this instanceof Error_ComAmazonawsDynamodb; }
  public boolean is_CollectionOfErrors() { return this instanceof Error_CollectionOfErrors; }
  public boolean is_Opaque() { return this instanceof Error_Opaque; }
  public boolean is_OpaqueWithText() { return this instanceof Error_OpaqueWithText; }
  public dafny.DafnySequence<? extends Character> dtor_message() {
    Error d = this;
    if (d instanceof Error_DynamoDbEncryptionException) { return ((Error_DynamoDbEncryptionException)d)._message; }
    return ((Error_CollectionOfErrors)d)._message;
  }
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption() {
    Error d = this;
    return ((Error_AwsCryptographyDbEncryptionSdkStructuredEncryption)d)._AwsCryptographyDbEncryptionSdkStructuredEncryption;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.Error dtor_AwsCryptographyMaterialProviders() {
    Error d = this;
    return ((Error_AwsCryptographyMaterialProviders)d)._AwsCryptographyMaterialProviders;
  }
  public software.amazon.cryptography.keystore.internaldafny.types.Error dtor_AwsCryptographyKeyStore() {
    Error d = this;
    return ((Error_AwsCryptographyKeyStore)d)._AwsCryptographyKeyStore;
  }
  public software.amazon.cryptography.primitives.internaldafny.types.Error dtor_AwsCryptographyPrimitives() {
    Error d = this;
    return ((Error_AwsCryptographyPrimitives)d)._AwsCryptographyPrimitives;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.Error dtor_ComAmazonawsDynamodb() {
    Error d = this;
    return ((Error_ComAmazonawsDynamodb)d)._ComAmazonawsDynamodb;
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
