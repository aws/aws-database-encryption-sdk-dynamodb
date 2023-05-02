// Class GetItemOutputTransformOutput
// Dafny class GetItemOutputTransformOutput compiled into Java
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
public class GetItemOutputTransformOutput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput _transformedOutput;
  public GetItemOutputTransformOutput (Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetItemOutputTransformOutput o = (GetItemOutputTransformOutput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.GetItemOutputTransformOutput.GetItemOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }

  private static final GetItemOutputTransformOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput.create(Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput.Default());
  public static GetItemOutputTransformOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<GetItemOutputTransformOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(GetItemOutputTransformOutput.class, () -> Default());
  public static dafny.TypeDescriptor<GetItemOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetItemOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static GetItemOutputTransformOutput create(Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput transformedOutput) {
    return new GetItemOutputTransformOutput(transformedOutput);
  }
  public static GetItemOutputTransformOutput create_GetItemOutputTransformOutput(Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_GetItemOutputTransformOutput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
