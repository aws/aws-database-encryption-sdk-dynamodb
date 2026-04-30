// Class GetEncryptedDataKeyDescriptionUnion
// Dafny class GetEncryptedDataKeyDescriptionUnion compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class GetEncryptedDataKeyDescriptionUnion {
  public GetEncryptedDataKeyDescriptionUnion() {
  }
  private static final dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionUnion> _TYPE = dafny.TypeDescriptor.<GetEncryptedDataKeyDescriptionUnion>referenceWithInitializer(GetEncryptedDataKeyDescriptionUnion.class, () -> GetEncryptedDataKeyDescriptionUnion.Default());
  public static dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionUnion> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionUnion>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetEncryptedDataKeyDescriptionUnion theDefault = GetEncryptedDataKeyDescriptionUnion.create_header(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
  public static GetEncryptedDataKeyDescriptionUnion Default() {
    return theDefault;
  }
  public static GetEncryptedDataKeyDescriptionUnion create_header(dafny.DafnySequence<? extends java.lang.Byte> header) {
    return new GetEncryptedDataKeyDescriptionUnion_header(header);
  }
  public static GetEncryptedDataKeyDescriptionUnion create_item(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item) {
    return new GetEncryptedDataKeyDescriptionUnion_item(item);
  }
  public boolean is_header() { return this instanceof GetEncryptedDataKeyDescriptionUnion_header; }
  public boolean is_item() { return this instanceof GetEncryptedDataKeyDescriptionUnion_item; }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_header() {
    GetEncryptedDataKeyDescriptionUnion d = this;
    return ((GetEncryptedDataKeyDescriptionUnion_header)d)._header;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> dtor_item() {
    GetEncryptedDataKeyDescriptionUnion d = this;
    return ((GetEncryptedDataKeyDescriptionUnion_item)d)._item;
  }
}
