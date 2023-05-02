// Class __default
// Dafny class __default compiled into Java
package DynamoDbItemEncryptorUtil_Compile;

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
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;
import CompoundBeacon_Compile.*;
import SearchableEncryptionInfo_Compile.*;
import SearchConfigToInfo_Compile.*;
import DynamoDbUpdateExpr_Compile.*;
import DynamoDBFilterExpr_Compile.*;
import DynamoDBIndexSupport_Compile.*;
import DynamoDBSupport_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error E(dafny.DafnySequence<? extends Character> msg) {
    return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(msg);
  }
  public static boolean ByteLess(byte x, byte y)
  {
    return java.lang.Integer.compareUnsigned(x, y) < 0;
  }
  public static boolean CharLess(char x, char y)
  {
    return (x) < (y);
  }
  public static dafny.DafnySequence<? extends Character> ReservedPrefix()
  {
    return dafny.DafnySequence.asString("aws_dbe_");
  }
  public static dafny.DafnySequence<? extends Character> BeaconPrefix()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedPrefix(), dafny.DafnySequence.asString("b_"));
  }
  public static dafny.DafnySequence<? extends Character> VersionPrefix()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedPrefix(), dafny.DafnySequence.asString("v_"));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbItemEncryptorUtil_Compile._default";
  }
}
