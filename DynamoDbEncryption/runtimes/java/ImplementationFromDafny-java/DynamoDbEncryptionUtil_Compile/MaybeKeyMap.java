// Class MaybeKeyMap
// Dafny class MaybeKeyMap compiled into Java
package DynamoDbEncryptionUtil_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class MaybeKeyMap {
  public MaybeKeyMap() { }

  private static final MaybeKeyMap theDefault = DynamoDbEncryptionUtil_Compile.MaybeKeyMap.create_DontUseKeys();
  public static MaybeKeyMap Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<MaybeKeyMap> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(MaybeKeyMap.class, () -> Default());
  public static dafny.TypeDescriptor<MaybeKeyMap> _typeDescriptor() {
    return (dafny.TypeDescriptor<MaybeKeyMap>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static MaybeKeyMap create_DontUseKeys() {
    return new MaybeKeyMap_DontUseKeys();
  }
  public static MaybeKeyMap create_ShouldHaveKeys() {
    return new MaybeKeyMap_ShouldHaveKeys();
  }
  public static MaybeKeyMap create_Keys(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> value) {
    return new MaybeKeyMap_Keys(value);
  }
  public boolean is_DontUseKeys() { return this instanceof MaybeKeyMap_DontUseKeys; }
  public boolean is_ShouldHaveKeys() { return this instanceof MaybeKeyMap_ShouldHaveKeys; }
  public boolean is_Keys() { return this instanceof MaybeKeyMap_Keys; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_value() {
    MaybeKeyMap d = this;
    return ((MaybeKeyMap_Keys)d)._value;
  }
}
