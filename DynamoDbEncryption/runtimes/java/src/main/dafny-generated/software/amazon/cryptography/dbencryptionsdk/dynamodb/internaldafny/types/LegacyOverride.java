// Class LegacyOverride
// Dafny class LegacyOverride compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class LegacyOverride {
  public LegacyPolicy _policy;
  public ILegacyDynamoDbEncryptor _encryptor;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _attributeActionsOnEncrypt;
  public Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _defaultAttributeFlag;
  public LegacyOverride (LegacyPolicy policy, ILegacyDynamoDbEncryptor encryptor, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> defaultAttributeFlag) {
    this._policy = policy;
    this._encryptor = encryptor;
    this._attributeActionsOnEncrypt = attributeActionsOnEncrypt;
    this._defaultAttributeFlag = defaultAttributeFlag;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    LegacyOverride o = (LegacyOverride)other;
    return true && java.util.Objects.equals(this._policy, o._policy) && this._encryptor == o._encryptor && java.util.Objects.equals(this._attributeActionsOnEncrypt, o._attributeActionsOnEncrypt) && java.util.Objects.equals(this._defaultAttributeFlag, o._defaultAttributeFlag);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._policy);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptor);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributeActionsOnEncrypt);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._defaultAttributeFlag);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyOverride.LegacyOverride");
    s.append("(");
    s.append(dafny.Helpers.toString(this._policy));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptor));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._attributeActionsOnEncrypt));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._defaultAttributeFlag));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<LegacyOverride> _TYPE = dafny.TypeDescriptor.<LegacyOverride>referenceWithInitializer(LegacyOverride.class, () -> LegacyOverride.Default());
  public static dafny.TypeDescriptor<LegacyOverride> _typeDescriptor() {
    return (dafny.TypeDescriptor<LegacyOverride>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final LegacyOverride theDefault = LegacyOverride.create(LegacyPolicy.Default(), null, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> empty(), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction._typeDescriptor()));
  public static LegacyOverride Default() {
    return theDefault;
  }
  public static LegacyOverride create(LegacyPolicy policy, ILegacyDynamoDbEncryptor encryptor, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> defaultAttributeFlag) {
    return new LegacyOverride(policy, encryptor, attributeActionsOnEncrypt, defaultAttributeFlag);
  }
  public static LegacyOverride create_LegacyOverride(LegacyPolicy policy, ILegacyDynamoDbEncryptor encryptor, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> attributeActionsOnEncrypt, Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> defaultAttributeFlag) {
    return create(policy, encryptor, attributeActionsOnEncrypt, defaultAttributeFlag);
  }
  public boolean is_LegacyOverride() { return true; }
  public LegacyPolicy dtor_policy() {
    return this._policy;
  }
  public ILegacyDynamoDbEncryptor dtor_encryptor() {
    return this._encryptor;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> dtor_attributeActionsOnEncrypt() {
    return this._attributeActionsOnEncrypt;
  }
  public Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> dtor_defaultAttributeFlag() {
    return this._defaultAttributeFlag;
  }
}
