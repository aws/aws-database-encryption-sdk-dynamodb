// Class ParsedHeader
// Dafny class ParsedHeader compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ParsedHeader {
  public software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId _algorithmSuiteId;
  public dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> _encryptedDataKeys;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _storedEncryptionContext;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _encryptionContext;
  public ParsedHeader (software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encryptionContext) {
    this._algorithmSuiteId = algorithmSuiteId;
    this._encryptedDataKeys = encryptedDataKeys;
    this._storedEncryptionContext = storedEncryptionContext;
    this._encryptionContext = encryptionContext;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ParsedHeader o = (ParsedHeader)other;
    return true && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && java.util.Objects.equals(this._encryptedDataKeys, o._encryptedDataKeys) && java.util.Objects.equals(this._storedEncryptionContext, o._storedEncryptionContext) && java.util.Objects.equals(this._encryptionContext, o._encryptionContext);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedDataKeys);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._storedEncryptionContext);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptionContext);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ParsedHeader.ParsedHeader");
    s.append("(");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptedDataKeys));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._storedEncryptionContext));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptionContext));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ParsedHeader> _TYPE = dafny.TypeDescriptor.<ParsedHeader>referenceWithInitializer(ParsedHeader.class, () -> ParsedHeader.Default());
  public static dafny.TypeDescriptor<ParsedHeader> _typeDescriptor() {
    return (dafny.TypeDescriptor<ParsedHeader>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ParsedHeader theDefault = ParsedHeader.create(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId.Default(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> empty(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
  public static ParsedHeader Default() {
    return theDefault;
  }
  public static ParsedHeader create(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encryptionContext) {
    return new ParsedHeader(algorithmSuiteId, encryptedDataKeys, storedEncryptionContext, encryptionContext);
  }
  public static ParsedHeader create_ParsedHeader(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encryptionContext) {
    return create(algorithmSuiteId, encryptedDataKeys, storedEncryptionContext, encryptionContext);
  }
  public boolean is_ParsedHeader() { return true; }
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
}
