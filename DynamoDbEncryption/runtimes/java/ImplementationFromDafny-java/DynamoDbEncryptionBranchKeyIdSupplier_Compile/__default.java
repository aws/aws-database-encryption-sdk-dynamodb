// Class __default
// Dafny class __default compiled into Java
package DynamoDbEncryptionBranchKeyIdSupplier_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> AddAttributeToMap(dafny.DafnySequence<? extends java.lang.Byte> ddbAttrKey, dafny.DafnySequence<? extends java.lang.Byte> encodedAttrValue, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> attrMap)
  {
    dafny.DafnySequence<? extends java.lang.Byte> _267_ddbAttrNameBytes = (ddbAttrKey).drop(java.math.BigInteger.valueOf((DynamoDbEncryptionUtil_Compile.__default.DDBEC__EC__ATTR__PREFIX()).length()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _268_valueOrError0 = (UTF8.__default.Decode(_267_ddbAttrNameBytes)).<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>)(_269_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _269_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_269_e_boxed0));
      return Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(_269_e);
    }));
    if ((_268_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
      return (_268_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends Character> _270_ddbAttrName = (_268_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor());
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _271_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Need(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_270_ddbAttrName), Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(dafny.DafnySequence.asString("Invalid serialization of DDB Attribute in encryption context.")));
      if ((_271_valueOrError1).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
        return (_271_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _272_valueOrError2 = (UTF8.__default.Decode(encodedAttrValue)).<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>)(_273_e_boxed0) -> {
          dafny.DafnySequence<? extends Character> _273_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_273_e_boxed0));
          return Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(_273_e);
        }));
        if ((_272_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
          return (_272_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends Character> _274_utf8DecodedVal = (_272_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor());
          Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _275_valueOrError3 = (Base64_Compile.__default.Decode(_274_utf8DecodedVal)).<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>)(_276_e_boxed0) -> {
            dafny.DafnySequence<? extends Character> _276_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_276_e_boxed0));
            return Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(_276_e);
          }));
          if ((_275_valueOrError3).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
            return (_275_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
          } else {
            dafny.DafnySequence<? extends java.lang.Byte> _277_base64DecodedVal = (_275_valueOrError3).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor());
            Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _278_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>Need(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_277_base64DecodedVal).length())).compareTo(java.math.BigInteger.valueOf(2L)) >= 0, Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(dafny.DafnySequence.asString("Invalid serialization of DDB Attribute in encryption context.")));
            if ((_278_valueOrError4).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
              return (_278_valueOrError4).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
            } else {
              dafny.DafnySequence<? extends java.lang.Byte> _279_typeId = (_277_base64DecodedVal).take(java.math.BigInteger.valueOf(2L));
              dafny.DafnySequence<? extends java.lang.Byte> _280_serializedValue = (_277_base64DecodedVal).drop(java.math.BigInteger.valueOf(2L));
              Wrappers_Compile.Result<DynamoToStruct_Compile.AttrValueAndLength, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _281_valueOrError5 = (DynamoToStruct_Compile.__default.BytesToAttr(_280_serializedValue, _279_typeId, false)).<Dafny.Aws.Cryptography.MaterialProviders.Types.Error>MapFailure(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>)(_282_e_boxed0) -> {
                dafny.DafnySequence<? extends Character> _282_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_282_e_boxed0));
                return Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(_282_e);
              }));
              if ((_281_valueOrError5).IsFailure(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())) {
                return (_281_valueOrError5).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
              } else {
                DynamoToStruct_Compile.AttrValueAndLength _283_ddbAttrValue = (_281_valueOrError5).Extract(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor());
                return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>update(attrMap, _270_ddbAttrName, (_283_ddbAttrValue).dtor_val()));
              }
            }
          }
        }
      }
    }
  }
  public static Dafny.Aws.Cryptography.MaterialProviders.Types.Error ConvertToMplError(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error err) {
    if ((err).is_Opaque()) {
      return Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_Opaque((err).dtor_obj());
    } else {
      return Dafny.Aws.Cryptography.MaterialProviders.Types.Error.create_AwsCryptographicMaterialProvidersException(dafny.DafnySequence.asString("Unexpected error while getting Branch Key ID."));
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> MPL__EC__PARTITION__NAME()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("aws-crypto-partition-name"));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> MPL__EC__SORT__NAME()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("aws-crypto-sort-name"));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionBranchKeyIdSupplier_Compile._default";
  }
}
