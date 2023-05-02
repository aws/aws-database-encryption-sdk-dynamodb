// Class ConstructorPartList
// Dafny class ConstructorPartList compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class ConstructorPartList {
  public ConstructorPartList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<ConstructorPart> empty(ConstructorPart._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends ConstructorPart>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends ConstructorPart>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
