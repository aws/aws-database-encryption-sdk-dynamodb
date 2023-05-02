// Class NonSensitivePartsList
// Dafny class NonSensitivePartsList compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class NonSensitivePartsList {
  public NonSensitivePartsList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<NonSensitivePart> empty(NonSensitivePart._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends NonSensitivePart>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends NonSensitivePart>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
