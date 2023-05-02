// Class __default
// Dafny class __default compiled into Java
package UpdateItemTransform_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(((input).dtor_sdkInput()).dtor_TableName())) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1833_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
      _1833_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_Expected()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'Expected' not supported in UpdateItem with Encryption")));
      if ((_1833_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1833_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1834_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
      _1834_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_AttributeUpdates()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'AttributeUpdates' not supported in UpdateItem with Encryption")));
      if ((_1834_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1834_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1835_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
      _1835_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_ConditionalOperator()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'ConditionalOperator' not supported in UpdateItem with Encryption")));
      if ((_1835_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1835_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput._typeDescriptor());
        return output;
      }
      DdbMiddlewareConfig_Compile.TableConfig _1836_tableConfig;
      _1836_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(((input).dtor_sdkInput()).dtor_TableName())));
      boolean _1837___v0;
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1838_valueOrError3 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
      _1838_valueOrError3 = DynamoDbMiddlewareSupport_Compile.__default.TestUpdateExpression(_1836_tableConfig, ((input).dtor_sdkInput()).dtor_UpdateExpression(), ((input).dtor_sdkInput()).dtor_ExpressionAttributeNames(), ((input).dtor_sdkInput()).dtor_ExpressionAttributeValues());
      if ((_1838_valueOrError3).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1838_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput._typeDescriptor());
        return output;
      }
      _1837___v0 = (_1838_valueOrError3).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    }
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput.create((input).dtor_sdkInput()));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput.Default());
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput.create((input).dtor_sdkOutput()));
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "UpdateItemTransform_Compile._default";
  }
}
