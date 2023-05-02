// Class StackValue
// Dafny class StackValue compiled into Java
package DynamoDBFilterExpr_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class StackValue {
  public StackValue() { }

  private static final StackValue theDefault = DynamoDBFilterExpr_Compile.StackValue.create_Bool(false);
  public static StackValue Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<StackValue> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(StackValue.class, () -> Default());
  public static dafny.TypeDescriptor<StackValue> _typeDescriptor() {
    return (dafny.TypeDescriptor<StackValue>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static StackValue create_Bool(boolean b) {
    return new StackValue_Bool(b);
  }
  public static StackValue create_Str(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue s) {
    return new StackValue_Str(s);
  }
  public static StackValue create_DoesNotExist() {
    return new StackValue_DoesNotExist();
  }
  public boolean is_Bool() { return this instanceof StackValue_Bool; }
  public boolean is_Str() { return this instanceof StackValue_Str; }
  public boolean is_DoesNotExist() { return this instanceof StackValue_DoesNotExist; }
  public boolean dtor_b() {
    StackValue d = this;
    return ((StackValue_Bool)d)._b;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue dtor_s() {
    StackValue d = this;
    return ((StackValue_Str)d)._s;
  }
}
