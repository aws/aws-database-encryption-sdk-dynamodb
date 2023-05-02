// Class MaybeKeyId
// Dafny class MaybeKeyId compiled into Java
package DynamoDbEncryptionUtil_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class MaybeKeyId {
  public MaybeKeyId() { }

  private static final MaybeKeyId theDefault = DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId();
  public static MaybeKeyId Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<MaybeKeyId> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(MaybeKeyId.class, () -> Default());
  public static dafny.TypeDescriptor<MaybeKeyId> _typeDescriptor() {
    return (dafny.TypeDescriptor<MaybeKeyId>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static MaybeKeyId create_DontUseKeyId() {
    return new MaybeKeyId_DontUseKeyId();
  }
  public static MaybeKeyId create_ShouldHaveKeyId() {
    return new MaybeKeyId_ShouldHaveKeyId();
  }
  public static MaybeKeyId create_KeyId(dafny.DafnySequence<? extends Character> value) {
    return new MaybeKeyId_KeyId(value);
  }
  public boolean is_DontUseKeyId() { return this instanceof MaybeKeyId_DontUseKeyId; }
  public boolean is_ShouldHaveKeyId() { return this instanceof MaybeKeyId_ShouldHaveKeyId; }
  public boolean is_KeyId() { return this instanceof MaybeKeyId_KeyId; }
  public dafny.DafnySequence<? extends Character> dtor_value() {
    MaybeKeyId d = this;
    return ((MaybeKeyId_KeyId)d)._value;
  }
}
