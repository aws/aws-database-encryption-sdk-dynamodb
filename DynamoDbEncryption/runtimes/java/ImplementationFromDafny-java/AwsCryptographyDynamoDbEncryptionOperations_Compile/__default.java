// Class __default
// Dafny class __default compiled into Java
package AwsCryptographyDynamoDbEncryptionOperations_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CreateDynamoDbEncryptionBranchKeyIdSupplier(Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    DynamoDbEncryptionBranchKeyIdSupplier_Compile.DynamoDbEncryptionBranchKeyIdSupplier _284_supplier;
    DynamoDbEncryptionBranchKeyIdSupplier_Compile.DynamoDbEncryptionBranchKeyIdSupplier _nw0 = new DynamoDbEncryptionBranchKeyIdSupplier_Compile.DynamoDbEncryptionBranchKeyIdSupplier();
    _nw0.__ctor((input).dtor_ddbKeyBranchKeyIdSupplier());
    _284_supplier = _nw0;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.create(_284_supplier));
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "AwsCryptographyDynamoDbEncryptionOperations_Compile._default";
  }
}
