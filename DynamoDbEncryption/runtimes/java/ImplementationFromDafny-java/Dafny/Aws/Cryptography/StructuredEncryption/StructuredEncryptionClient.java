// Class StructuredEncryptionClient
// Dafny class StructuredEncryptionClient compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class StructuredEncryptionClient implements Dafny.Aws.Cryptography.StructuredEncryption.Types.IStructuredEncryptionClient {
  public StructuredEncryptionClient() {
    this._config = (AwsCryptographyStructuredEncryptionOperations_Compile.Config)null;
  }
  public void __ctor(AwsCryptographyStructuredEncryptionOperations_Compile.Config config)
  {
    (this)._config = config;
  }
  public Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> EncryptStructure(Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out31;
      _out31 = AwsCryptographyStructuredEncryptionOperations_Compile.__default.EncryptStructure((this).config(), input);
      output = _out31;
    }
    return output;
  }
  public Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> DecryptStructure(Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out32;
      _out32 = AwsCryptographyStructuredEncryptionOperations_Compile.__default.DecryptStructure((this).config(), input);
      output = _out32;
    }
    return output;
  }
  public AwsCryptographyStructuredEncryptionOperations_Compile.Config _config;
  public AwsCryptographyStructuredEncryptionOperations_Compile.Config config()
  {
    return this._config;
  }
  private static final dafny.TypeDescriptor<StructuredEncryptionClient> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StructuredEncryptionClient.class, () -> (StructuredEncryptionClient) null);
  public static dafny.TypeDescriptor<StructuredEncryptionClient> _typeDescriptor() {
    return (dafny.TypeDescriptor<StructuredEncryptionClient>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.StructuredEncryption_Compile.StructuredEncryptionClient";
  }
}
