// Class GetItemInputTransformOutput
// Dafny class GetItemInputTransformOutput compiled into Java
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
public class GetItemInputTransformOutput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.GetItemInput _transformedInput;
  public GetItemInputTransformOutput (Dafny.Com.Amazonaws.Dynamodb.Types.GetItemInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetItemInputTransformOutput o = (GetItemInputTransformOutput)other;
    return true && java.util.Objects.equals(this._transformedInput, o._transformedInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._transformedInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.GetItemInputTransformOutput.GetItemInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }

  private static final GetItemInputTransformOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput.create(Dafny.Com.Amazonaws.Dynamodb.Types.GetItemInput.Default());
  public static GetItemInputTransformOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<GetItemInputTransformOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(GetItemInputTransformOutput.class, () -> Default());
  public static dafny.TypeDescriptor<GetItemInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetItemInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static GetItemInputTransformOutput create(Dafny.Com.Amazonaws.Dynamodb.Types.GetItemInput transformedInput) {
    return new GetItemInputTransformOutput(transformedInput);
  }
  public static GetItemInputTransformOutput create_GetItemInputTransformOutput(Dafny.Com.Amazonaws.Dynamodb.Types.GetItemInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_GetItemInputTransformOutput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.GetItemInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
