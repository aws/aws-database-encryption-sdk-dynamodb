// Class LegacyConfig
// Dafny class LegacyConfig compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class LegacyConfig {
  public LegacyPolicy _policy;
  public ILegacyDynamoDbEncryptor _encryptor;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _attributeFlags;
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _defaultAttributeFlag;
  public LegacyConfig (LegacyPolicy policy, ILegacyDynamoDbEncryptor encryptor, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeFlags, Wrappers_Compile.Option<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> defaultAttributeFlag) {
    this._policy = policy;
    this._encryptor = encryptor;
    this._attributeFlags = attributeFlags;
    this._defaultAttributeFlag = defaultAttributeFlag;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    LegacyConfig o = (LegacyConfig)other;
    return true && java.util.Objects.equals(this._policy, o._policy) && this._encryptor == o._encryptor && java.util.Objects.equals(this._attributeFlags, o._attributeFlags) && java.util.Objects.equals(this._defaultAttributeFlag, o._defaultAttributeFlag);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._policy);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptor);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributeFlags);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._defaultAttributeFlag);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.LegacyConfig.LegacyConfig");
    s.append("(");
    s.append(dafny.Helpers.toString(this._policy));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptor));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._attributeFlags));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._defaultAttributeFlag));
    s.append(")");
    return s.toString();
  }

  private static final LegacyConfig theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyConfig.create(LegacyPolicy.Default(), null, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> empty(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>Default());
  public static LegacyConfig Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<LegacyConfig> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(LegacyConfig.class, () -> Default());
  public static dafny.TypeDescriptor<LegacyConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<LegacyConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static LegacyConfig create(LegacyPolicy policy, ILegacyDynamoDbEncryptor encryptor, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeFlags, Wrappers_Compile.Option<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> defaultAttributeFlag) {
    return new LegacyConfig(policy, encryptor, attributeFlags, defaultAttributeFlag);
  }
  public static LegacyConfig create_LegacyConfig(LegacyPolicy policy, ILegacyDynamoDbEncryptor encryptor, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeFlags, Wrappers_Compile.Option<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> defaultAttributeFlag) {
    return create(policy, encryptor, attributeFlags, defaultAttributeFlag);
  }
  public boolean is_LegacyConfig() { return true; }
  public LegacyPolicy dtor_policy() {
    return this._policy;
  }
  public ILegacyDynamoDbEncryptor dtor_encryptor() {
    return this._encryptor;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> dtor_attributeFlags() {
    return this._attributeFlags;
  }
  public Wrappers_Compile.Option<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> dtor_defaultAttributeFlag() {
    return this._defaultAttributeFlag;
  }
}
