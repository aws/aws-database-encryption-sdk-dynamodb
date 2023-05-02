// Class BeaconVersionList
// Dafny class BeaconVersionList compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconVersionList {
  public BeaconVersionList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<BeaconVersion> empty(BeaconVersion._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends BeaconVersion>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends BeaconVersion>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
