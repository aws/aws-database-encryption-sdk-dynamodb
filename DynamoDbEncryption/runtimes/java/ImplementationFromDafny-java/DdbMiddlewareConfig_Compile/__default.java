// Class __default
// Dafny class __default compiled into Java
package DdbMiddlewareConfig_Compile;

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
import DynamoDbItemEncryptorUtil_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.*;
import AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static <__T> Wrappers_Compile.Result<__T, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> MapError(dafny.TypeDescriptor<__T> _td___T, Wrappers_Compile.Result<__T, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> r)
  {
    return (r).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(_td___T, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1750_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error _1750_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error)(java.lang.Object)(_1750_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryptionItemEncryptor(_1750_e);
    }));
  }
  public static <__T> Wrappers_Compile.Result<__T, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> MapString(dafny.TypeDescriptor<__T> _td___T, Wrappers_Compile.Result<__T, dafny.DafnySequence<? extends Character>> r)
  {
    return (r).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(_td___T, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1751_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1751_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1751_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_DynamoDbEncryptionTransformsException(_1751_e);
    }));
  }
  public static Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error E(dafny.DafnySequence<? extends Character> s) {
    return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_DynamoDbEncryptionTransformsException(s);
  }
  public static <__X> Wrappers_Compile.Result<__X, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> MakeError(dafny.TypeDescriptor<__X> _td___X, dafny.DafnySequence<? extends Character> s)
  {
    return Wrappers_Compile.Result.<__X, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Failure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_DynamoDbEncryptionTransformsException(s));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DdbMiddlewareConfig_Compile._default";
  }
}
