// Class DynamoDbEncryptionBranchKeyIdSupplier
// Dafny class DynamoDbEncryptionBranchKeyIdSupplier compiled into Java
package DynamoDbEncryptionBranchKeyIdSupplier_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbEncryptionBranchKeyIdSupplier implements Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier {
  public DynamoDbEncryptionBranchKeyIdSupplier() {
    this._ddbKeyBranchKeyIdSupplier = null;
  }
  public Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> GetBranchKeyId(Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out1;
    _out1 = Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_IBranchKeyIdSupplier.GetBranchKeyId(this, input);
    return _out1;
  }
  public void __ctor(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier)
  {
    (this)._ddbKeyBranchKeyIdSupplier = ddbKeyBranchKeyIdSupplier;
  }
  public Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> GetBranchKeyId_k(Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Default(Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput.Default());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _253_context;
    _253_context = (input).dtor_encryptionContext();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _254_attrMap;
    _254_attrMap = dafny.DafnyMap.fromElements();
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _255_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Default();
    _255_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Need(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), ((_253_context).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.MPL__EC__PARTITION__NAME()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(dafny.DafnySequence.asString("Invalid encryption context: Missing partition name")));
    if ((_255_valueOrError0).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
      output = (_255_valueOrError0).<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput._typeDescriptor());
      return output;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _256_partitionName;
    _256_partitionName = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_253_context).get(__default.MPL__EC__PARTITION__NAME())));
    dafny.DafnySequence<? extends java.lang.Byte> _257_partitionValueKey;
    _257_partitionValueKey = dafny.DafnySequence.<java.lang.Byte>concatenate(DynamoDbEncryptionUtil_Compile.__default.DDBEC__EC__ATTR__PREFIX(), _256_partitionName);
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _258_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Default();
    _258_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Need(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), ((_253_context).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_257_partitionValueKey), Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(dafny.DafnySequence.asString("Invalid encryption context: Missing partition value")));
    if ((_258_valueOrError1).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
      output = (_258_valueOrError1).<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _259_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    _259_valueOrError2 = __default.AddAttributeToMap(_257_partitionValueKey, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_253_context).get(_257_partitionValueKey))), _254_attrMap);
    if ((_259_valueOrError2).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
      output = (_259_valueOrError2).<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput._typeDescriptor());
      return output;
    }
    _254_attrMap = (_259_valueOrError2).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor());
    if (((_253_context).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.MPL__EC__SORT__NAME())) {
      dafny.DafnySequence<? extends java.lang.Byte> _260_sortName;
      _260_sortName = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_253_context).get(__default.MPL__EC__SORT__NAME())));
      dafny.DafnySequence<? extends java.lang.Byte> _261_sortValueKey;
      _261_sortValueKey = dafny.DafnySequence.<java.lang.Byte>concatenate(DynamoDbEncryptionUtil_Compile.__default.DDBEC__EC__ATTR__PREFIX(), _260_sortName);
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _262_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Default();
      _262_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Need(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), ((_253_context).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_261_sortValueKey), Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(dafny.DafnySequence.asString("Invalid encryption context: Missing sort value")));
      if ((_262_valueOrError3).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
        output = (_262_valueOrError3).<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _263_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
      _263_valueOrError4 = __default.AddAttributeToMap(_261_sortValueKey, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_253_context).get(_261_sortValueKey))), _254_attrMap);
      if ((_263_valueOrError4).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
        output = (_263_valueOrError4).<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput._typeDescriptor());
        return output;
      }
      _254_attrMap = (_263_valueOrError4).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor());
    }
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _264_branchKeyIdR;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out2;
    _out2 = ((this).ddbKeyBranchKeyIdSupplier()).GetBranchKeyIdFromDdbKey(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput.create(_254_attrMap));
    _264_branchKeyIdR = _out2;
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput _265_branchKeyIdOut;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _266_valueOrError5 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput.Default());
    _266_valueOrError5 = (_264_branchKeyIdR).<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>MapFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), __default::ConvertToMplError);
    if ((_266_valueOrError5).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
      output = (_266_valueOrError5).<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput._typeDescriptor());
      return output;
    }
    _265_branchKeyIdOut = (_266_valueOrError5).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor());
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>create_Success(Dafny.Aws.Cryptography.MaterialProviders.Types.GetBranchKeyIdOutput.create((_265_branchKeyIdOut).dtor_branchKeyId()));
    return output;
  }
  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier _ddbKeyBranchKeyIdSupplier;
  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier()
  {
    return this._ddbKeyBranchKeyIdSupplier;
  }
  private static final dafny.TypeDescriptor<DynamoDbEncryptionBranchKeyIdSupplier> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DynamoDbEncryptionBranchKeyIdSupplier.class, () -> (DynamoDbEncryptionBranchKeyIdSupplier) null);
  public static dafny.TypeDescriptor<DynamoDbEncryptionBranchKeyIdSupplier> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbEncryptionBranchKeyIdSupplier>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionBranchKeyIdSupplier_Compile.DynamoDbEncryptionBranchKeyIdSupplier";
  }
}
