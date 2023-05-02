// Class ParsedHeader
// Dafny class ParsedHeader compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public class ParsedHeader {
  public CryptoSchema _cryptoSchema;
  public Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId _algorithmSuiteId;
  public dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> _encryptedDataKeys;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _storedEncryptionContext;
  public ParsedHeader (CryptoSchema cryptoSchema, Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext) {
    this._cryptoSchema = cryptoSchema;
    this._algorithmSuiteId = algorithmSuiteId;
    this._encryptedDataKeys = encryptedDataKeys;
    this._storedEncryptionContext = storedEncryptionContext;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ParsedHeader o = (ParsedHeader)other;
    return true && java.util.Objects.equals(this._cryptoSchema, o._cryptoSchema) && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && java.util.Objects.equals(this._encryptedDataKeys, o._encryptedDataKeys) && java.util.Objects.equals(this._storedEncryptionContext, o._storedEncryptionContext);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cryptoSchema);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedDataKeys);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._storedEncryptionContext);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.StructuredEncryption.Types_Compile.ParsedHeader.ParsedHeader");
    s.append("(");
    s.append(dafny.Helpers.toString(this._cryptoSchema));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptedDataKeys));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._storedEncryptionContext));
    s.append(")");
    return s.toString();
  }

  private static final ParsedHeader theDefault = Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader.create(CryptoSchema.Default(), Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId.Default(), dafny.DafnySequence.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> empty(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
  public static ParsedHeader Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<ParsedHeader> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ParsedHeader.class, () -> Default());
  public static dafny.TypeDescriptor<ParsedHeader> _typeDescriptor() {
    return (dafny.TypeDescriptor<ParsedHeader>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static ParsedHeader create(CryptoSchema cryptoSchema, Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext) {
    return new ParsedHeader(cryptoSchema, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext);
  }
  public static ParsedHeader create_ParsedHeader(CryptoSchema cryptoSchema, Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext) {
    return create(cryptoSchema, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext);
  }
  public boolean is_ParsedHeader() { return true; }
  public CryptoSchema dtor_cryptoSchema() {
    return this._cryptoSchema;
  }
  public Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId dtor_algorithmSuiteId() {
    return this._algorithmSuiteId;
  }
  public dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> dtor_encryptedDataKeys() {
    return this._encryptedDataKeys;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_storedEncryptionContext() {
    return this._storedEncryptionContext;
  }
}
