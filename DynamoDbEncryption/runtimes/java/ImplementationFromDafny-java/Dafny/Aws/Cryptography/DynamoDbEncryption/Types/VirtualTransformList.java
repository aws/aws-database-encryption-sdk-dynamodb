// Class VirtualTransformList
// Dafny class VirtualTransformList compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualTransformList {
  public VirtualTransformList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<VirtualTransform> empty(VirtualTransform._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualTransform>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualTransform>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
