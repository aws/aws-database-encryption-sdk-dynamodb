// Class CreateTableOutputTransformOutput
// Dafny class CreateTableOutputTransformOutput compiled into Java
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
public class CreateTableOutputTransformOutput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput _transformedOutput;
  public CreateTableOutputTransformOutput (Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CreateTableOutputTransformOutput o = (CreateTableOutputTransformOutput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.CreateTableOutputTransformOutput.CreateTableOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }

  private static final CreateTableOutputTransformOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformOutput.create(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput.Default());
  public static CreateTableOutputTransformOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CreateTableOutputTransformOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CreateTableOutputTransformOutput.class, () -> Default());
  public static dafny.TypeDescriptor<CreateTableOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<CreateTableOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CreateTableOutputTransformOutput create(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput transformedOutput) {
    return new CreateTableOutputTransformOutput(transformedOutput);
  }
  public static CreateTableOutputTransformOutput create_CreateTableOutputTransformOutput(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_CreateTableOutputTransformOutput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
