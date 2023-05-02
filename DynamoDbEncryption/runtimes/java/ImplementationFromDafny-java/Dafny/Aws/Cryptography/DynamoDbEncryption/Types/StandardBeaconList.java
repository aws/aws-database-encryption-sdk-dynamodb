// Class StandardBeaconList
// Dafny class StandardBeaconList compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class StandardBeaconList {
  public StandardBeaconList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<StandardBeacon> empty(StandardBeacon._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends StandardBeacon>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends StandardBeacon>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
