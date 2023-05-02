// Class DescribeTableOutputTransformOutput
// Dafny class DescribeTableOutputTransformOutput compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class DescribeTableOutputTransformOutput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput _transformedOutput;
  public DescribeTableOutputTransformOutput (Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DescribeTableOutputTransformOutput o = (DescribeTableOutputTransformOutput)other;
    return true && java.util.Objects.equals(this._transformedOutput, o._transformedOutput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._transformedOutput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.DescribeTableOutputTransformOutput.DescribeTableOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }

  private static final DescribeTableOutputTransformOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput.create(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput.Default());
  public static DescribeTableOutputTransformOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<DescribeTableOutputTransformOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DescribeTableOutputTransformOutput.class, () -> Default());
  public static dafny.TypeDescriptor<DescribeTableOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DescribeTableOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static DescribeTableOutputTransformOutput create(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput transformedOutput) {
    return new DescribeTableOutputTransformOutput(transformedOutput);
  }
  public static DescribeTableOutputTransformOutput create_DescribeTableOutputTransformOutput(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_DescribeTableOutputTransformOutput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
