// Class __default
// Dafny class __default compiled into Java
package DynamoDBIndexSupport_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends Character> UnbeaconString(dafny.DafnySequence<? extends Character> s) {
    if ((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(s)) {
      return (s).drop(java.math.BigInteger.valueOf((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).length()));
    } else {
      return s;
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> UnbeaconKeySchemaAttributeName(dafny.DafnySequence<? extends Character> s) {
    if ((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(s)) {
      dafny.DafnySequence<? extends Character> _1418_ret = (s).drop(java.math.BigInteger.valueOf((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).length()));
      if (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__KeySchemaAttributeName(_1418_ret)) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1418_ret);
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("KeySchemaAttributeName "), s), dafny.DafnySequence.asString(" is invalid after removing prefix"))));
      }
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(s);
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> UnbeaconKeySchemaElement(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement s) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1419_valueOrError0 = __default.UnbeaconKeySchemaAttributeName((s).dtor_AttributeName());
    if ((_1419_valueOrError0).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaAttributeName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1419_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaAttributeName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _1420_name = (_1419_valueOrError0).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaAttributeName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>Let(s, boxed36 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement _pat_let18_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(boxed36));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>Let(_pat_let18_0, boxed37 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement _1421_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(boxed37));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>Let(_1420_name, boxed38 -> {
      dafny.DafnySequence<? extends Character> _pat_let19_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed38));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>Let(_pat_let19_0, boxed39 -> {
        dafny.DafnySequence<? extends Character> _1422_dt__update_hAttributeName_h0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed39));
        return Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement.create(_1422_dt__update_hAttributeName_h0, (_1421_dt__update__tmp_h0).dtor_KeyType());
      }
      )));
    }
    )));
  }
  )));
}
))));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> UnbeaconKeySchema(dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> schema) {
    return Seq_Compile.__default.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapWithResult(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>)(_1423_k_boxed0) -> {
      Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement _1423_k = ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(_1423_k_boxed0));
      return __default.UnbeaconKeySchemaElement(_1423_k);
    }), schema);
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> UnbeaconProjection(Dafny.Com.Amazonaws.Dynamodb.Types.Projection projection) {
    if (((projection).dtor_NonKeyAttributes()).is_None()) {
      return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(projection);
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1424_newAttributes = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(Dafny.Com.Amazonaws.Dynamodb.Types.NonKeyAttributeName._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_1425_k_boxed0) -> {
        dafny.DafnySequence<? extends Character> _1425_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1425_k_boxed0));
        return !((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(_1425_k));
      }), ((projection).dtor_NonKeyAttributes()).dtor_value());
      if (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__NonKeyAttributeNameList(_1424_newAttributes)) {
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.Projection>Let(projection, boxed40 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.Projection _pat_let20_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed40));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.Projection>Let(_pat_let20_0, boxed41 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1426_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed41));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>, Dafny.Com.Amazonaws.Dynamodb.Types.Projection>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_Some(_1424_newAttributes), boxed42 -> {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _pat_let21_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed42));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>, Dafny.Com.Amazonaws.Dynamodb.Types.Projection>Let(_pat_let21_0, boxed43 -> {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _1427_dt__update_hNonKeyAttributes_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed43));
        return Dafny.Com.Amazonaws.Dynamodb.Types.Projection.create((_1426_dt__update__tmp_h0).dtor_ProjectionType(), _1427_dt__update_hNonKeyAttributes_h0);
      }
      )));
    }
    )));
  }
  )));
}
))));
      } else {
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Project had invalid attribute name list")));
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformOneLocalIndexDescription(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription index) {
    Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1428_valueOrError0 = ((((index).dtor_KeySchema()).is_None()) ? (Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>create_None())) : (((Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>, Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(__default.UnbeaconKeySchema(((index).dtor_KeySchema()).dtor_value()), boxed44 -> {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _pat_let22_0 = ((Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(boxed44));
      return ((Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>, Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(_pat_let22_0, boxed45 -> {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1429_valueOrError1 = ((Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(boxed45));
        return (((_1429_valueOrError1).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) ? ((_1429_valueOrError1).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor()))) : (((Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let((_1429_valueOrError1).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor()), boxed46 -> {
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _pat_let23_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed46));
          return ((Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(_pat_let23_0, boxed47 -> {
            dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1430_schema = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed47));
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>create_Some(_1430_schema));
          }
          )));
        }
        )))));
      }
      )));
    }
    )))));
    if ((_1428_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1428_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor());
    } else {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>> _1431_newKeySchema = (_1428_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1432_valueOrError2 = ((((index).dtor_Projection()).is_None()) ? (Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>create_None())) : (((Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>, Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(__default.UnbeaconProjection(((index).dtor_Projection()).dtor_value()), boxed48 -> {
        Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _pat_let24_0 = ((Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(boxed48));
        return ((Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>, Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(_pat_let24_0, boxed49 -> {
          Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1433_valueOrError3 = ((Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(boxed49));
          return (((_1433_valueOrError3).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) ? ((_1433_valueOrError3).<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor()))) : (((Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let((_1433_valueOrError3).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor()), boxed50 -> {
            Dafny.Com.Amazonaws.Dynamodb.Types.Projection _pat_let25_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed50));
            return ((Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(_pat_let25_0, boxed51 -> {
              Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1434_projection = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed51));
              return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>create_Some(_1434_projection));
            }
            )));
          }
          )))));
        }
        )));
      }
      )))));
      if ((_1432_valueOrError2).IsFailure(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1432_valueOrError2).<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>PropagateFailure(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor());
      } else {
        Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection> _1435_newProjection = (_1432_valueOrError2).Extract(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>Let(index, boxed52 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription _pat_let26_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(boxed52));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>Let(_pat_let26_0, boxed53 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription _1436_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(boxed53));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>Let(_1435_newProjection, boxed54 -> {
      Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection> _pat_let27_0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>)(java.lang.Object)(boxed54));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>Let(_pat_let27_0, boxed55 -> {
        Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection> _1437_dt__update_hProjection_h0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>)(java.lang.Object)(boxed55));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>Let(_1431_newKeySchema, boxed56 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>> _pat_let28_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>)(java.lang.Object)(boxed56));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>Let(_pat_let28_0, boxed57 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>> _1438_dt__update_hKeySchema_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>)(java.lang.Object)(boxed57));
            return Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription.create((_1436_dt__update__tmp_h0).dtor_IndexName(), _1438_dt__update_hKeySchema_h0, _1437_dt__update_hProjection_h0, (_1436_dt__update__tmp_h0).dtor_IndexSizeBytes(), (_1436_dt__update__tmp_h0).dtor_ItemCount(), (_1436_dt__update__tmp_h0).dtor_IndexArn());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformOneGlobalIndexDescription(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription index) {
    Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1439_valueOrError0 = ((((index).dtor_KeySchema()).is_None()) ? (Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>create_None())) : (((Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>, Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(__default.UnbeaconKeySchema(((index).dtor_KeySchema()).dtor_value()), boxed58 -> {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _pat_let29_0 = ((Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(boxed58));
      return ((Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>, Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(_pat_let29_0, boxed59 -> {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1440_valueOrError1 = ((Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(boxed59));
        return (((_1440_valueOrError1).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) ? ((_1440_valueOrError1).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor()))) : (((Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let((_1440_valueOrError1).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor()), boxed60 -> {
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _pat_let30_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed60));
          return ((Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(_pat_let30_0, boxed61 -> {
            dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1441_schema = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed61));
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>create_Some(_1441_schema));
          }
          )));
        }
        )))));
      }
      )));
    }
    )))));
    if ((_1439_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1439_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor());
    } else {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>> _1442_newKeySchema = (_1439_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1443_valueOrError2 = ((((index).dtor_Projection()).is_None()) ? (Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>create_None())) : (((Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>, Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(__default.UnbeaconProjection(((index).dtor_Projection()).dtor_value()), boxed62 -> {
        Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _pat_let31_0 = ((Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(boxed62));
        return ((Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>, Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(_pat_let31_0, boxed63 -> {
          Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1444_valueOrError3 = ((Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(boxed63));
          return (((_1444_valueOrError3).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) ? ((_1444_valueOrError3).<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor()))) : (((Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let((_1444_valueOrError3).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor()), boxed64 -> {
            Dafny.Com.Amazonaws.Dynamodb.Types.Projection _pat_let32_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed64));
            return ((Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>Let(_pat_let32_0, boxed65 -> {
              Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1445_projection = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed65));
              return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>create_Some(_1445_projection));
            }
            )));
          }
          )))));
        }
        )));
      }
      )))));
      if ((_1443_valueOrError2).IsFailure(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1443_valueOrError2).<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>PropagateFailure(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor());
      } else {
        Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection> _1446_newProjection = (_1443_valueOrError2).Extract(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>Let(index, boxed66 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription _pat_let33_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(boxed66));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>Let(_pat_let33_0, boxed67 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription _1447_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(boxed67));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>Let(_1446_newProjection, boxed68 -> {
      Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection> _pat_let34_0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>)(java.lang.Object)(boxed68));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>Let(_pat_let34_0, boxed69 -> {
        Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection> _1448_dt__update_hProjection_h0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Projection>)(java.lang.Object)(boxed69));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>Let(_1442_newKeySchema, boxed70 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>> _pat_let35_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>)(java.lang.Object)(boxed70));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>Let(_pat_let35_0, boxed71 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>> _1449_dt__update_hKeySchema_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>>)(java.lang.Object)(boxed71));
            return Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription.create((_1447_dt__update__tmp_h0).dtor_IndexName(), _1449_dt__update_hKeySchema_h0, _1448_dt__update_hProjection_h0, (_1447_dt__update__tmp_h0).dtor_IndexStatus(), (_1447_dt__update__tmp_h0).dtor_Backfilling(), (_1447_dt__update__tmp_h0).dtor_ProvisionedThroughput(), (_1447_dt__update__tmp_h0).dtor_IndexSizeBytes(), (_1447_dt__update__tmp_h0).dtor_ItemCount(), (_1447_dt__update__tmp_h0).dtor_IndexArn());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformLocalIndexDescription(Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>> req) {
    if ((req).is_None()) {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(req);
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1450_valueOrError0 = Seq_Compile.__default.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapWithResult(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription, Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>)(_1451_d_boxed0) -> {
        Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription _1451_d = ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription)(java.lang.Object)(_1451_d_boxed0));
        return __default.TransformOneLocalIndexDescription(_1451_d);
      }), (req).dtor_value());
      if ((_1450_valueOrError0).IsFailure(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1450_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>>PropagateFailure(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor())));
      } else {
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription> _1452_nList = (_1450_valueOrError0).Extract(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndexDescription>>create_Some(_1452_nList));
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformGlobalIndexDescription(Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>> req) {
    if ((req).is_None()) {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(req);
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1453_valueOrError0 = Seq_Compile.__default.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapWithResult(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription, Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>)(_1454_d_boxed0) -> {
        Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription _1454_d = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription)(java.lang.Object)(_1454_d_boxed0));
        return __default.TransformOneGlobalIndexDescription(_1454_d);
      }), (req).dtor_value());
      if ((_1453_valueOrError0).IsFailure(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1453_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>>PropagateFailure(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor())));
      } else {
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription> _1455_nList = (_1453_valueOrError0).Extract(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexDescription>>create_Some(_1455_nList));
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> MakeBeaconName(dafny.DafnySequence<? extends Character> name) {
    return dafny.DafnySequence.<Character>concatenate(DynamoDbEncryptionUtil_Compile.__default.BeaconPrefix(), name);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeKeySchemaBeaconName(dafny.DafnySequence<? extends Character> name) {
    dafny.DafnySequence<? extends Character> _1456_newName = __default.MakeBeaconName(name);
    if (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__KeySchemaAttributeName(_1456_newName)) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1456_newName);
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Can't make valid KeySchemaAttributeName from beacon for "), name)));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeNonKeyBeaconName(dafny.DafnySequence<? extends Character> name) {
    dafny.DafnySequence<? extends Character> _1457_newName = __default.MakeBeaconName(name);
    if (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__NonKeyAttributeName(_1457_newName)) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1457_newName);
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Can't make valid NonKeySchemaAttributeName from beacon for "), name)));
    }
  }
  public static dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> ReplaceAttrDef(dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs, dafny.DafnySequence<? extends Character> oldName, dafny.DafnySequence<? extends Character> newName)
  {
    dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1458___accumulator = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> empty(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((attrs).length())).signum() == 0) {
        return dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>concatenate(_1458___accumulator, attrs);
      } else if (((((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition)(java.lang.Object)((attrs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_AttributeName()).equals(oldName)) {
        Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition _1459_newAttr = Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition.create(newName, Dafny.Com.Amazonaws.Dynamodb.Types.ScalarAttributeType.create_S());
        _1458___accumulator = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>concatenate(_1458___accumulator, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor(), _1459_newAttr));
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _in377 = (attrs).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in378 = oldName;
        dafny.DafnySequence<? extends Character> _in379 = newName;
        attrs = _in377;
        oldName = _in378;
        newName = _in379;
        continue TAIL_CALL_START;
      } else {
        _1458___accumulator = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>concatenate(_1458___accumulator, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor(), ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition)(java.lang.Object)((attrs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _in380 = (attrs).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in381 = oldName;
        dafny.DafnySequence<? extends Character> _in382 = newName;
        attrs = _in380;
        oldName = _in381;
        newName = _in382;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean IsEncrypted(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, dafny.DafnySequence<? extends Character> attr)
  {
    return ((actions).<dafny.DafnySequence<? extends Character>>contains(attr)) && (java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)((actions).get(attr))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN()));
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddBeaconsToKeySchemaElement(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement element, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs)
  {
    if ((search).IsBeacon((element).dtor_AttributeName())) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1460_valueOrError0 = __default.MakeKeySchemaBeaconName((element).dtor_AttributeName());
      if ((_1460_valueOrError0).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaAttributeName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1460_valueOrError0).<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaAttributeName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
      } else {
        dafny.DafnySequence<? extends Character> _1461_newName = (_1460_valueOrError0).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaAttributeName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1462_newAttrs = __default.ReplaceAttrDef(attrs, (element).dtor_AttributeName(), _1461_newName);
        return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>Let(element, boxed72 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement _pat_let36_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(boxed72));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>Let(_pat_let36_0, boxed73 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement _1463_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(boxed73));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>Let(_1461_newName, boxed74 -> {
      dafny.DafnySequence<? extends Character> _pat_let37_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed74));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>Let(_pat_let37_0, boxed75 -> {
        dafny.DafnySequence<? extends Character> _1464_dt__update_hAttributeName_h0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed75));
        return Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement.create(_1464_dt__update_hAttributeName_h0, (_1463_dt__update__tmp_h0).dtor_KeyType());
      }
      )));
    }
    )));
  }
  )));
}
))), _1462_newAttrs));
      }
    } else if (__default.IsEncrypted(actions, (element).dtor_AttributeName())) {
      return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("You can't make an index on an encrypted attribute, unless you've configured a beacon for that attribute.")));
    } else {
      return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(element, attrs));
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddBeaconsToProjection(SearchableEncryptionInfo_Compile.SearchInfo search, Dafny.Com.Amazonaws.Dynamodb.Types.Projection proj)
  {
    if (((proj).dtor_NonKeyAttributes()).is_None()) {
      return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(proj);
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1465_newAttributes = (search).GenerateClosure(((proj).dtor_NonKeyAttributes()).dtor_value());
      if ((((java.util.function.Function<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Boolean>)(_1466_newAttributes) -> dafny.Helpers.Quantifier((_1466_newAttributes).UniqueElements(), true, ((_forall_var_14_boxed0) -> {
        dafny.DafnySequence<? extends Character> _forall_var_14 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_14_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _1467_a = (dafny.DafnySequence<? extends Character>)_forall_var_14;
          return !((_1466_newAttributes).contains(_1467_a)) || (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__NonKeyAttributeName(_1467_a));
        } else {
          return true;
        }
      }))).apply(_1465_newAttributes)) && (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__NonKeyAttributeNameList(_1465_newAttributes))) {
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.Projection>Let(proj, boxed76 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.Projection _pat_let38_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed76));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.Projection>Let(_pat_let38_0, boxed77 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1468_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed77));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>, Dafny.Com.Amazonaws.Dynamodb.Types.Projection>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_Some(_1465_newAttributes), boxed78 -> {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _pat_let39_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed78));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>, Dafny.Com.Amazonaws.Dynamodb.Types.Projection>Let(_pat_let39_0, boxed79 -> {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> _1469_dt__update_hNonKeyAttributes_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed79));
        return Dafny.Com.Amazonaws.Dynamodb.Types.Projection.create((_1468_dt__update__tmp_h0).dtor_ProjectionType(), _1469_dt__update_hNonKeyAttributes_h0);
      }
      )));
    }
    )));
  }
  )));
}
))));
      } else {
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Adding beacons to NonKeyAttributes of Projection in CreateGlobalSecondaryIndexAction exceeded the allowed number of projected attributes.")));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformCreateGSIAction(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction index, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs)
  {
    Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1470_valueOrError0 = __default.AddBeaconsToKeySchema(search, actions, (index).dtor_KeySchema(), attrs, dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> empty(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor()), java.math.BigInteger.valueOf(((index).dtor_KeySchema()).length()));
    if ((_1470_valueOrError0).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1470_valueOrError0).<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
    } else {
      dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs5 = (_1470_valueOrError0).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1471_newKeySchema = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs5).dtor__0()));
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1472_attrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs5).dtor__1()));
      Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1473_valueOrError1 = __default.AddBeaconsToProjection(search, (index).dtor_Projection());
      if ((_1473_valueOrError1).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1473_valueOrError1).<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
      } else {
        Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1474_newProjection = (_1473_valueOrError1).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>Let(index, boxed80 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction _pat_let40_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(boxed80));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>Let(_pat_let40_0, boxed81 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction _1475_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(boxed81));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>Let(_1474_newProjection, boxed82 -> {
      Dafny.Com.Amazonaws.Dynamodb.Types.Projection _pat_let41_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed82));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>Let(_pat_let41_0, boxed83 -> {
        Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1476_dt__update_hProjection_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed83));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>Let(_1471_newKeySchema, boxed84 -> {
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _pat_let42_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed84));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>Let(_pat_let42_0, boxed85 -> {
            dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1477_dt__update_hKeySchema_h0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed85));
            return Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction.create((_1475_dt__update__tmp_h0).dtor_IndexName(), _1477_dt__update_hKeySchema_h0, _1476_dt__update_hProjection_h0, (_1475_dt__update__tmp_h0).dtor_ProvisionedThroughput());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))), _1472_attrs));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformGlobalSecondaryIndexUpdate(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate index, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs)
  {
    if (((index).dtor_Create()).is_None()) {
      return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(index, attrs));
    } else {
      Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1478_valueOrError0 = __default.TransformCreateGSIAction(search, actions, ((index).dtor_Create()).dtor_value(), attrs);
      if ((_1478_valueOrError0).IsFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1478_valueOrError0).<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
      } else {
        dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs6 = (_1478_valueOrError0).Extract(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction _1479_create = ((Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs6).dtor__0()));
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1480_attrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs6).dtor__1()));
        return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>Let(index, boxed86 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate _pat_let43_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate)(java.lang.Object)(boxed86));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>Let(_pat_let43_0, boxed87 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate _1481_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate)(java.lang.Object)(boxed87));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>Let(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>create_Some(_1479_create), boxed88 -> {
      Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction> _pat_let44_0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>)(java.lang.Object)(boxed88));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>Let(_pat_let44_0, boxed89 -> {
        Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction> _1482_dt__update_hCreate_h0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.CreateGlobalSecondaryIndexAction>)(java.lang.Object)(boxed89));
        return Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate.create((_1481_dt__update__tmp_h0).dtor_Update(), _1482_dt__update_hCreate_h0, (_1481_dt__update__tmp_h0).dtor_Delete());
      }
      )));
    }
    )));
  }
  )));
}
))), _1480_attrs));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformIndexUpdates(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate> indexes, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate> acc)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((indexes).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(acc, attrs));
      } else {
        Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1483_valueOrError0 = __default.TransformGlobalSecondaryIndexUpdate(search, actions, ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate)(java.lang.Object)((indexes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), attrs);
        if ((_1483_valueOrError0).IsFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1483_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
        } else {
          dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs7 = (_1483_valueOrError0).Extract(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate _1484_newIndex = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs7).dtor__0()));
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1485_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs7).dtor__1()));
          SearchableEncryptionInfo_Compile.SearchInfo _in383 = search;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _in384 = actions;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate> _in385 = (indexes).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _in386 = _1485_newAttrs;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate> _in387 = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate>concatenate(acc, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndexUpdate._typeDescriptor(), _1484_newIndex));
          search = _in383;
          actions = _in384;
          indexes = _in385;
          attrs = _in386;
          acc = _in387;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddBeaconsToKeySchema(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> schema, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> acc, java.math.BigInteger origSize)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((schema).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(acc, attrs));
      } else {
        Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1486_valueOrError0 = __default.AddBeaconsToKeySchemaElement(search, actions, ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)((schema).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), attrs);
        if ((_1486_valueOrError0).IsFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1486_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
        } else {
          dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs8 = (_1486_valueOrError0).Extract(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement _1487_newSchema = ((Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs8).dtor__0()));
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1488_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs8).dtor__1()));
          SearchableEncryptionInfo_Compile.SearchInfo _in388 = search;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _in389 = actions;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _in390 = (schema).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _in391 = _1488_newAttrs;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _in392 = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>concatenate(acc, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor(), _1487_newSchema));
          java.math.BigInteger _in393 = origSize;
          search = _in388;
          actions = _in389;
          schema = _in390;
          attrs = _in391;
          acc = _in392;
          origSize = _in393;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformOneLsi(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex index, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs)
  {
    Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1489_valueOrError0 = __default.AddBeaconsToKeySchema(search, actions, (index).dtor_KeySchema(), attrs, dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> empty(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor()), java.math.BigInteger.valueOf(((index).dtor_KeySchema()).length()));
    if ((_1489_valueOrError0).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1489_valueOrError0).<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
    } else {
      dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs9 = (_1489_valueOrError0).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1490_newSchema = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs9).dtor__0()));
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1491_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs9).dtor__1()));
      Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1492_valueOrError1 = __default.AddBeaconsToProjection(search, (index).dtor_Projection());
      if ((_1492_valueOrError1).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1492_valueOrError1).<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
      } else {
        Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1493_newProjection = (_1492_valueOrError1).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>Let(index, boxed90 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex _pat_let45_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(boxed90));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>Let(_pat_let45_0, boxed91 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex _1494_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(boxed91));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>Let(_1493_newProjection, boxed92 -> {
      Dafny.Com.Amazonaws.Dynamodb.Types.Projection _pat_let46_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed92));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>Let(_pat_let46_0, boxed93 -> {
        Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1495_dt__update_hProjection_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed93));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>Let(_1490_newSchema, boxed94 -> {
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _pat_let47_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed94));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>Let(_pat_let47_0, boxed95 -> {
            dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1496_dt__update_hKeySchema_h0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed95));
            return Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex.create((_1494_dt__update__tmp_h0).dtor_IndexName(), _1496_dt__update_hKeySchema_h0, _1495_dt__update_hProjection_h0);
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))), _1491_newAttrs));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TransformOneGsi(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex index, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs)
  {
    Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1497_valueOrError0 = __default.AddBeaconsToKeySchema(search, actions, (index).dtor_KeySchema(), attrs, dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> empty(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement._typeDescriptor()), java.math.BigInteger.valueOf(((index).dtor_KeySchema()).length()));
    if ((_1497_valueOrError0).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1497_valueOrError0).<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
    } else {
      dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs10 = (_1497_valueOrError0).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.KeySchema._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1498_newSchema = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs10).dtor__0()));
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1499_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs10).dtor__1()));
      Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1500_valueOrError1 = __default.AddBeaconsToProjection(search, (index).dtor_Projection());
      if ((_1500_valueOrError1).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1500_valueOrError1).<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
      } else {
        Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1501_newProjection = (_1500_valueOrError1).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.Projection._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>Let(index, boxed96 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex _pat_let48_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(boxed96));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>Let(_pat_let48_0, boxed97 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex _1502_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(boxed97));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>Let(_1501_newProjection, boxed98 -> {
      Dafny.Com.Amazonaws.Dynamodb.Types.Projection _pat_let49_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed98));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Projection, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>Let(_pat_let49_0, boxed99 -> {
        Dafny.Com.Amazonaws.Dynamodb.Types.Projection _1503_dt__update_hProjection_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Projection)(java.lang.Object)(boxed99));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>Let(_1498_newSchema, boxed100 -> {
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _pat_let50_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed100));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>, Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>Let(_pat_let50_0, boxed101 -> {
            dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement> _1504_dt__update_hKeySchema_h0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.KeySchemaElement>)(java.lang.Object)(boxed101));
            return Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex.create((_1502_dt__update__tmp_h0).dtor_IndexName(), _1504_dt__update_hKeySchema_h0, _1503_dt__update_hProjection_h0, (_1502_dt__update__tmp_h0).dtor_ProvisionedThroughput());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))), _1499_newAttrs));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> LsiWithAttrs(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex> indexes, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex> acc)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((indexes).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(acc, attrs));
      } else {
        Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1505_valueOrError0 = __default.TransformOneLsi(search, actions, ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)((indexes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), attrs);
        if ((_1505_valueOrError0).IsFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1505_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
        } else {
          dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs11 = (_1505_valueOrError0).Extract(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex _1506_newIndex = ((Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs11).dtor__0()));
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1507_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs11).dtor__1()));
          SearchableEncryptionInfo_Compile.SearchInfo _in394 = search;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _in395 = actions;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex> _in396 = (indexes).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _in397 = _1507_newAttrs;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex> _in398 = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex>concatenate(acc, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.LocalSecondaryIndex._typeDescriptor(), _1506_newIndex));
          search = _in394;
          actions = _in395;
          indexes = _in396;
          attrs = _in397;
          acc = _in398;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GsiWithAttrs(SearchableEncryptionInfo_Compile.SearchInfo search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex> indexes, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> attrs, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex> acc)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((indexes).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>create(acc, attrs));
      } else {
        Wrappers_Compile.Result<dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1508_valueOrError0 = __default.TransformOneGsi(search, actions, ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)((indexes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), attrs);
        if ((_1508_valueOrError0).IsFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1508_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>>PropagateFailure(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor()), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())));
        } else {
          dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>> _let_tmp_rhs12 = (_1508_valueOrError0).Extract(dafny.Tuple2.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor(), dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition._typeDescriptor())), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex _1509_newIndex = ((Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs12).dtor__0()));
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _1510_newAttrs = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>)(java.lang.Object)(((dafny.Tuple2<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition>>)_let_tmp_rhs12).dtor__1()));
          SearchableEncryptionInfo_Compile.SearchInfo _in399 = search;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _in400 = actions;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex> _in401 = (indexes).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeDefinition> _in402 = _1510_newAttrs;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex> _in403 = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex>concatenate(acc, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.GlobalSecondaryIndex._typeDescriptor(), _1509_newIndex));
          search = _in399;
          actions = _in400;
          indexes = _in401;
          attrs = _in402;
          acc = _in403;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDBIndexSupport_Compile._default";
  }
}
