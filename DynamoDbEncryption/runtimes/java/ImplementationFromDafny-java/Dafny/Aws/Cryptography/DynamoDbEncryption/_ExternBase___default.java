// Class _ExternBase___default
// Dafny class __default compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig DefaultDynamoDbEncryptionConfig() {
    return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig.create();
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> DynamoDbEncryption(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbEncryptionConfig config)
  {
    Wrappers_Compile.Result<DynamoDbEncryptionClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> res = (Wrappers_Compile.Result<DynamoDbEncryptionClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    AwsCryptographyDynamoDbEncryptionOperations_Compile.Config _285_internalConfig;
    _285_internalConfig = AwsCryptographyDynamoDbEncryptionOperations_Compile.Config.create();
    DynamoDbEncryptionClient _286_client;
    DynamoDbEncryptionClient _nw1 = new DynamoDbEncryptionClient();
    _nw1.__ctor(_285_internalConfig);
    _286_client = _nw1;
    res = Wrappers_Compile.Result.<DynamoDbEncryptionClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_286_client);
    return res;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.DynamoDbEncryption_Compile._default";
  }
}
