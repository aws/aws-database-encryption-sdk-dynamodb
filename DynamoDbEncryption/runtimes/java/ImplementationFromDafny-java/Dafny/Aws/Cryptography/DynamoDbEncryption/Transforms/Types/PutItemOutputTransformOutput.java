// Class PutItemOutputTransformOutput
// Dafny class PutItemOutputTransformOutput compiled into Java
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
public class PutItemOutputTransformOutput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput _transformedOutput;
  public PutItemOutputTransformOutput (Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PutItemOutputTransformOutput o = (PutItemOutputTransformOutput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.PutItemOutputTransformOutput.PutItemOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }

  private static final PutItemOutputTransformOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput.create(Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput.Default());
  public static PutItemOutputTransformOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<PutItemOutputTransformOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(PutItemOutputTransformOutput.class, () -> Default());
  public static dafny.TypeDescriptor<PutItemOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<PutItemOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static PutItemOutputTransformOutput create(Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput transformedOutput) {
    return new PutItemOutputTransformOutput(transformedOutput);
  }
  public static PutItemOutputTransformOutput create_PutItemOutputTransformOutput(Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_PutItemOutputTransformOutput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
