// Class Error
// Dafny class Error compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Error {
  public Error() {
  }
  private static final dafny.TypeDescriptor<Error> _TYPE = dafny.TypeDescriptor.<Error>referenceWithInitializer(Error.class, () -> Error.Default());
  public static dafny.TypeDescriptor<Error> _typeDescriptor() {
    return (dafny.TypeDescriptor<Error>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Error theDefault = Error.create_DynamoDbEncryptionTransformsException(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static Error Default() {
    return theDefault;
  }
  public static Error create_DynamoDbEncryptionTransformsException(dafny.DafnySequence<? extends Character> message) {
    return new Error_DynamoDbEncryptionTransformsException(message);
  }
  public static Error create_AwsCryptographyDbEncryptionSdkDynamoDb(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error AwsCryptographyDbEncryptionSdkDynamoDb) {
    return new Error_AwsCryptographyDbEncryptionSdkDynamoDb(AwsCryptographyDbEncryptionSdkDynamoDb);
  }
  public static Error create_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor) {
    return new Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor);
  }
  public static Error create_AwsCryptographyDbEncryptionSdkStructuredEncryption(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error AwsCryptographyDbEncryptionSdkStructuredEncryption) {
    return new Error_AwsCryptographyDbEncryptionSdkStructuredEncryption(AwsCryptographyDbEncryptionSdkStructuredEncryption);
  }
  public static Error create_AwsCryptographyMaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.types.Error AwsCryptographyMaterialProviders) {
    return new Error_AwsCryptographyMaterialProviders(AwsCryptographyMaterialProviders);
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
  public boolean is_DynamoDbEncryptionTransformsException() { return this instanceof Error_DynamoDbEncryptionTransformsException; }
  public boolean is_AwsCryptographyDbEncryptionSdkDynamoDb() { return this instanceof Error_AwsCryptographyDbEncryptionSdkDynamoDb; }
  public boolean is_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor() { return this instanceof Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor; }
  public boolean is_AwsCryptographyDbEncryptionSdkStructuredEncryption() { return this instanceof Error_AwsCryptographyDbEncryptionSdkStructuredEncryption; }
  public boolean is_AwsCryptographyMaterialProviders() { return this instanceof Error_AwsCryptographyMaterialProviders; }
  public boolean is_ComAmazonawsDynamodb() { return this instanceof Error_ComAmazonawsDynamodb; }
  public boolean is_CollectionOfErrors() { return this instanceof Error_CollectionOfErrors; }
  public boolean is_Opaque() { return this instanceof Error_Opaque; }
  public boolean is_OpaqueWithText() { return this instanceof Error_OpaqueWithText; }
  public dafny.DafnySequence<? extends Character> dtor_message() {
    Error d = this;
    if (d instanceof Error_DynamoDbEncryptionTransformsException) { return ((Error_DynamoDbEncryptionTransformsException)d)._message; }
    return ((Error_CollectionOfErrors)d)._message;
  }
  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error dtor_AwsCryptographyDbEncryptionSdkDynamoDb() {
    Error d = this;
    return ((Error_AwsCryptographyDbEncryptionSdkDynamoDb)d)._AwsCryptographyDbEncryptionSdkDynamoDb;
  }
  public software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error dtor_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor() {
    Error d = this;
    return ((Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor)d)._AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor;
  }
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption() {
    Error d = this;
    return ((Error_AwsCryptographyDbEncryptionSdkStructuredEncryption)d)._AwsCryptographyDbEncryptionSdkStructuredEncryption;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.Error dtor_AwsCryptographyMaterialProviders() {
    Error d = this;
    return ((Error_AwsCryptographyMaterialProviders)d)._AwsCryptographyMaterialProviders;
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
