// Class CompoundBeaconList
// Dafny class CompoundBeaconList compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class CompoundBeaconList {
  public CompoundBeaconList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<CompoundBeacon> empty(CompoundBeacon._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends CompoundBeacon>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends CompoundBeacon>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
