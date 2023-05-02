// Class nat
// Dafny class nat compiled into Java
package _System;

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
import DdbMiddlewareConfig_Compile.*;
import DdbStatement_Compile.*;
import DynamoDbMiddlewareSupport_Compile.*;
import PutItemTransform_Compile.*;
import GetItemTransform_Compile.*;
import UpdateItemTransform_Compile.*;
import BatchWriteItemTransform_Compile.*;
import TransactWriteItemsTransform_Compile.*;
import BatchGetItemTransform_Compile.*;
import ScanTransform_Compile.*;
import QueryTransform_Compile.*;
import TransactGetItemsTransform_Compile.*;
import DeleteItemTransform_Compile.*;
import ExecuteStatementTransform_Compile.*;
import BatchExecuteStatementTransform_Compile.*;
import ExecuteTransactionTransform_Compile.*;
import CreateTableTransform_Compile.*;
import UpdateTableTransform_Compile.*;
import DescribeTableTransform_Compile.*;
import AwsCryptographyDynamoDbEncryptionTransformsOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class nat {
  public nat() {
  }
  private static final dafny.TypeDescriptor<java.math.BigInteger> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(java.math.BigInteger.class, () -> java.math.BigInteger.ZERO);
  public static dafny.TypeDescriptor<java.math.BigInteger> _typeDescriptor() {
    return (dafny.TypeDescriptor<java.math.BigInteger>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
