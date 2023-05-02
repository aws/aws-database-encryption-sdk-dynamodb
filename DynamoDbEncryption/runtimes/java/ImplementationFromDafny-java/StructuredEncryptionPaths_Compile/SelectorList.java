// Class SelectorList
// Dafny class SelectorList compiled into Java
package StructuredEncryptionPaths_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class SelectorList {
  public SelectorList() {
  }
  private static final dafny.TypeDescriptor<dafny.DafnySequence> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(dafny.DafnySequence.class, () -> dafny.DafnySequence.<Selector> empty(Selector._typeDescriptor()));
  public static dafny.TypeDescriptor<dafny.DafnySequence<? extends Selector>> _typeDescriptor() {
    return (dafny.TypeDescriptor<dafny.DafnySequence<? extends Selector>>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
