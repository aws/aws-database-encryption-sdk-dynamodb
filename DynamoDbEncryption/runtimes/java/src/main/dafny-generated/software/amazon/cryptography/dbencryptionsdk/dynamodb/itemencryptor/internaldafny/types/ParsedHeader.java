// Class ParsedHeader
// Dafny class ParsedHeader compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ParsedHeader {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _attributeActionsOnEncrypt;
  public software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId _algorithmSuiteId;
  public dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> _encryptedDataKeys;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _storedEncryptionContext;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _encryptionContext;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _selectorContext;
  public ParsedHeader (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> selectorContext) {
    this._attributeActionsOnEncrypt = attributeActionsOnEncrypt;
    this._algorithmSuiteId = algorithmSuiteId;
    this._encryptedDataKeys = encryptedDataKeys;
    this._storedEncryptionContext = storedEncryptionContext;
    this._encryptionContext = encryptionContext;
    this._selectorContext = selectorContext;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ParsedHeader o = (ParsedHeader)other;
    return true && java.util.Objects.equals(this._attributeActionsOnEncrypt, o._attributeActionsOnEncrypt) && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && java.util.Objects.equals(this._encryptedDataKeys, o._encryptedDataKeys) && java.util.Objects.equals(this._storedEncryptionContext, o._storedEncryptionContext) && java.util.Objects.equals(this._encryptionContext, o._encryptionContext) && java.util.Objects.equals(this._selectorContext, o._selectorContext);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributeActionsOnEncrypt);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedDataKeys);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._storedEncryptionContext);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptionContext);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._selectorContext);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader.ParsedHeader");
    s.append("(");
    s.append(dafny.Helpers.toString(this._attributeActionsOnEncrypt));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptedDataKeys));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._storedEncryptionContext));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptionContext));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._selectorContext));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ParsedHeader> _TYPE = dafny.TypeDescriptor.<ParsedHeader>referenceWithInitializer(ParsedHeader.class, () -> ParsedHeader.Default());
  public static dafny.TypeDescriptor<ParsedHeader> _typeDescriptor() {
    return (dafny.TypeDescriptor<ParsedHeader>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ParsedHeader theDefault = ParsedHeader.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> empty(), software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId.Default(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> empty(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
  public static ParsedHeader Default() {
    return theDefault;
  }
  public static ParsedHeader create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> selectorContext) {
    return new ParsedHeader(attributeActionsOnEncrypt, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext, encryptionContext, selectorContext);
  }
  public static ParsedHeader create_ParsedHeader(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> selectorContext) {
    return create(attributeActionsOnEncrypt, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext, encryptionContext, selectorContext);
  }
  public boolean is_ParsedHeader() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> dtor_attributeActionsOnEncrypt() {
    return this._attributeActionsOnEncrypt;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId dtor_algorithmSuiteId() {
    return this._algorithmSuiteId;
  }
  public dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> dtor_encryptedDataKeys() {
    return this._encryptedDataKeys;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_storedEncryptionContext() {
    return this._storedEncryptionContext;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_encryptionContext() {
    return this._encryptionContext;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> dtor_selectorContext() {
    return this._selectorContext;
  }
}
