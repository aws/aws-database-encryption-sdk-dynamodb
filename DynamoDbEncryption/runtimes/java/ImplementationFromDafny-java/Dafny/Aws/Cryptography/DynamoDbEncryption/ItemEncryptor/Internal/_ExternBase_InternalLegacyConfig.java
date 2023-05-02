// Class _ExternBase_InternalLegacyConfig
// Dafny class InternalLegacyConfig compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal;

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

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase_InternalLegacyConfig {
  public _ExternBase_InternalLegacyConfig() {
    this._policy = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy.Default();
  }
  public abstract Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> EncryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput input);
  public abstract Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> DecryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput input);
  public abstract boolean IsLegacyInput(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput input);
  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy _policy;
  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyPolicy policy()
  {
    return this._policy;
  }
  private static final dafny.TypeDescriptor<InternalLegacyConfig> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(InternalLegacyConfig.class, () -> (InternalLegacyConfig) null);
  public static dafny.TypeDescriptor<InternalLegacyConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<InternalLegacyConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal_Compile.InternalLegacyConfig";
  }
}
