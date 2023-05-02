// Class QueryOutputTransformInput
// Dafny class QueryOutputTransformInput compiled into Java
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
public class QueryOutputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput _sdkOutput;
  public Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput _originalInput;
  public QueryOutputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    QueryOutputTransformInput o = (QueryOutputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkOutput, o._sdkOutput) && java.util.Objects.equals(this._originalInput, o._originalInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkOutput);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._originalInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.QueryOutputTransformInput.QueryOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }

  private static final QueryOutputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput.Default(), Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput.Default());
  public static QueryOutputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<QueryOutputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(QueryOutputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<QueryOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<QueryOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static QueryOutputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput originalInput) {
    return new QueryOutputTransformInput(sdkOutput, originalInput);
  }
  public static QueryOutputTransformInput create_QueryOutputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_QueryOutputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput dtor_originalInput() {
    return this._originalInput;
  }
}
