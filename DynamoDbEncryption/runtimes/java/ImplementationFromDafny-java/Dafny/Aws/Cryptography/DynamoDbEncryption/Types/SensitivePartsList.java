// Class SensitivePartsList
// Dafny class SensitivePartsList compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class SensitivePartsList {
  public SensitivePartsList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<SensitivePart> empty(SensitivePart._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends SensitivePart>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends SensitivePart>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
