// Class VirtualFieldList
// Dafny class VirtualFieldList compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtualFieldList {
  public VirtualFieldList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<VirtualField> empty(VirtualField._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualField>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends VirtualField>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
