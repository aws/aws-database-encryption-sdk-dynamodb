// Class DynamoDbEncryptionClient
// Dafny class DynamoDbEncryptionClient compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbEncryptionClient implements Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbEncryptionClient {
  public DynamoDbEncryptionClient() {
    this._config = AwsCryptographyDynamoDbEncryptionOperations_Compile.Config.Default();
  }
  public void __ctor(AwsCryptographyDynamoDbEncryptionOperations_Compile.Config config)
  {
    (this)._config = config;
  }
  public Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CreateDynamoDbEncryptionBranchKeyIdSupplier(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out3;
      _out3 = AwsCryptographyDynamoDbEncryptionOperations_Compile.__default.CreateDynamoDbEncryptionBranchKeyIdSupplier((this).config(), input);
      output = _out3;
    }
    return output;
  }
  public AwsCryptographyDynamoDbEncryptionOperations_Compile.Config _config;
  public AwsCryptographyDynamoDbEncryptionOperations_Compile.Config config()
  {
    return this._config;
  }
  private static final dafny.TypeDescriptor<DynamoDbEncryptionClient> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DynamoDbEncryptionClient.class, () -> (DynamoDbEncryptionClient) null);
  public static dafny.TypeDescriptor<DynamoDbEncryptionClient> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbEncryptionClient>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.DynamoDbEncryption_Compile.DynamoDbEncryptionClient";
  }
}
