// Class DynamoDbItemEncryptorClient
// Dafny class DynamoDbItemEncryptorClient compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbItemEncryptorClient implements Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.IDynamoDbItemEncryptorClient {
  public DynamoDbItemEncryptorClient() {
    this._config = (AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.Config)null;
  }
  public void __ctor(AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.Config config)
  {
    (this)._config = config;
  }
  public Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> EncryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out81;
      _out81 = AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.__default.EncryptItem((this).config(), input);
      output = _out81;
    }
    return output;
  }
  public Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> DecryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out82;
      _out82 = AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.__default.DecryptItem((this).config(), input);
      output = _out82;
    }
    return output;
  }
  public AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.Config _config;
  public AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.Config config()
  {
    return this._config;
  }
  private static final dafny.TypeDescriptor<DynamoDbItemEncryptorClient> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DynamoDbItemEncryptorClient.class, () -> (DynamoDbItemEncryptorClient) null);
  public static dafny.TypeDescriptor<DynamoDbItemEncryptorClient> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbItemEncryptorClient>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor_Compile.DynamoDbItemEncryptorClient";
  }
}
