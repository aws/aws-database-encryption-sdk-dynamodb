// Class MaybeKeyId
// Dafny class MaybeKeyId compiled into Java
package DynamoDbEncryptionUtil_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class MaybeKeyId {
  public MaybeKeyId() {
  }
  private static final dafny.TypeDescriptor<MaybeKeyId> _TYPE = dafny.TypeDescriptor.<MaybeKeyId>referenceWithInitializer(MaybeKeyId.class, () -> MaybeKeyId.Default());
  public static dafny.TypeDescriptor<MaybeKeyId> _typeDescriptor() {
    return (dafny.TypeDescriptor<MaybeKeyId>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final MaybeKeyId theDefault = MaybeKeyId.create_DontUseKeyId();
  public static MaybeKeyId Default() {
    return theDefault;
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
