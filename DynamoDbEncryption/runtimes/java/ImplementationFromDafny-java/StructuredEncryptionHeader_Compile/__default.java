// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionHeader_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean ValidVersion(byte x) {
    return (x) == ((byte) 1);
  }
  public static boolean ValidFlavor(byte x) {
    return (dafny.DafnySequence.of((byte) 0, (byte) 1)).contains(x);
  }
  public static boolean ValidLegendByte(byte x) {
    return (dafny.DafnySequence.of(__default.ENCRYPT__AND__SIGN__LEGEND(), __default.SIGN__ONLY__LEGEND())).contains(x);
  }
  public static boolean ValidEncryptionContext(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> x) {
    return ((java.math.BigInteger.valueOf((x).size())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0) && (((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Boolean>)(_323_x) -> dafny.Helpers.Quantifier((_323_x).keySet().Elements(), true, ((_forall_var_5_boxed0) -> {
      dafny.DafnySequence<? extends java.lang.Byte> _forall_var_5 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(_forall_var_5_boxed0));
      if (true) {
        dafny.DafnySequence<? extends java.lang.Byte> _324_k = (dafny.DafnySequence<? extends java.lang.Byte>)_forall_var_5;
        return !((_323_x).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_324_k)) || (((java.math.BigInteger.valueOf((_324_k).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0) && ((java.math.BigInteger.valueOf((((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_323_x).get(_324_k)))).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0));
      } else {
        return true;
      }
    }))).apply(x));
  }
  public static boolean ValidEncryptedDataKey(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey x) {
    return (((java.math.BigInteger.valueOf(((x).dtor_keyProviderId()).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0) && ((java.math.BigInteger.valueOf(((x).dtor_keyProviderInfo()).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0)) && ((java.math.BigInteger.valueOf(((x).dtor_ciphertext()).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> Serialize(Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> commitKey, PartialHeader PartialHeader)
  {
    dafny.DafnySequence<? extends java.lang.Byte> _325_body = (PartialHeader).serialize();
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _326_valueOrError0 = __default.CalculateHeaderCommitment(client, alg, commitKey, _325_body);
    if ((_326_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_326_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _327_commitment = (_326_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(_325_body, _327_commitment));
    }
  }
  public static Wrappers_Compile.Result<PartialHeader, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> Create(dafny.DafnySequence<? extends Character> tableName, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema schema, dafny.DafnySequence<? extends java.lang.Byte> msgID, Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials mat)
  {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _328_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidString(tableName), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid table name.")));
    if ((_328_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_328_valueOrError0).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
    } else {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _329_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), __default.ValidEncryptionContext((mat).dtor_encryptionContext()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Encryption Context")));
      if ((_329_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_329_valueOrError1).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _330_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((mat).dtor_encryptedDataKeys()).length())).signum() == 1, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("There must be at least one data key")));
        if ((_330_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_330_valueOrError2).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
        } else {
          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _331_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((mat).dtor_encryptedDataKeys()).length())).compareTo(__default.UINT8__LIMIT()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Too many data keys.")));
          if ((_331_valueOrError3).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
            return (_331_valueOrError3).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
          } else {
            Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _332_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, Boolean>)(_333_mat) -> dafny.Helpers.Quantifier(((_333_mat).dtor_encryptedDataKeys()).UniqueElements(), true, ((_forall_var_6_boxed0) -> {
              Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey _forall_var_6 = ((Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey)(java.lang.Object)(_forall_var_6_boxed0));
              if (true) {
                Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey _334_x = (Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey)_forall_var_6;
                return !(((_333_mat).dtor_encryptedDataKeys()).contains(_334_x)) || (__default.ValidEncryptedDataKey(_334_x));
              } else {
                return true;
              }
            }))).apply(mat), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Data Key")));
            if ((_332_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
              return (_332_valueOrError4).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
            } else {
              Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _335_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((schema).dtor_content()).is_SchemaMap(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema must be a Map")));
              if ((_335_valueOrError5).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                return (_335_valueOrError5).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
              } else {
                Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _336_valueOrError6 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.CryptoSchemaMapIsFlat(((schema).dtor_content()).dtor_SchemaMap()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema must be flat.")));
                if ((_336_valueOrError6).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                  return (_336_valueOrError6).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                } else {
                  Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _337_valueOrError7 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((((mat).dtor_algorithmSuite()).dtor_binaryId()).length()), java.math.BigInteger.valueOf(2L)), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Algorithm Suite Binary ID")));
                  if ((_337_valueOrError7).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                    return (_337_valueOrError7).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                  } else {
                    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _338_valueOrError8 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((byte)(java.lang.Object)((((mat).dtor_algorithmSuite()).dtor_binaryId()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == (StructuredEncryptionUtil_Compile.__default.DbeAlgorithmFamily()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Algorithm Suite not suitable for structured encryption.")));
                    if ((_338_valueOrError8).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                      return (_338_valueOrError8).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                    } else {
                      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _339_valueOrError9 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), __default.ValidFlavor(((byte)(java.lang.Object)((((mat).dtor_algorithmSuite()).dtor_binaryId()).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Algorithm Suite has unexpected flavor.")));
                      if ((_339_valueOrError9).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                        return (_339_valueOrError9).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                      } else {
                        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _340_valueOrError10 = __default.MakeLegend(tableName, schema);
                        if ((_340_valueOrError10).IsFailure(Legend._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                          return (_340_valueOrError10).<PartialHeader>PropagateFailure(Legend._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                        } else {
                          dafny.DafnySequence<? extends java.lang.Byte> _341_legend = (_340_valueOrError10).Extract(Legend._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
                          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _342_storedEC = ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>)(_343_mat) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>)(() -> {
                            java.util.HashMap<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>> _coll9 = new java.util.HashMap<>();
                            for (dafny.DafnySequence<? extends java.lang.Byte> _compr_9_boxed0 : ((_343_mat).dtor_encryptionContext()).keySet().Elements()) {
                              dafny.DafnySequence<? extends java.lang.Byte> _compr_9 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(_compr_9_boxed0));
                              if (true) {
                                dafny.DafnySequence<? extends java.lang.Byte> _344_k = (dafny.DafnySequence<? extends java.lang.Byte>)_compr_9;
                                if ((((_343_mat).dtor_encryptionContext()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_344_k)) && (!((_343_mat).dtor_requiredEncryptionContextKeys()).contains(_344_k))) {
                                  _coll9.put(_344_k,((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(((_343_mat).dtor_encryptionContext()).get(_344_k))));
                                }
                              }
                            }
                            return new dafny.DafnyMap<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>>(_coll9);
                          })).apply()).apply(mat);
                          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _345_valueOrError11 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), __default.ValidEncryptionContext(_342_storedEC), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Encryption Context")));
                          if ((_345_valueOrError11).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                            return (_345_valueOrError11).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                          } else {
                            return Wrappers_Compile.Result.<PartialHeader, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(StructuredEncryptionHeader_Compile.PartialHeader.create((byte) 1, ((byte)(java.lang.Object)((((mat).dtor_algorithmSuite()).dtor_binaryId()).select(dafny.Helpers.toInt((java.math.BigInteger.ONE))))), msgID, _341_legend, _342_storedEC, (mat).dtor_encryptedDataKeys()));
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<PartialHeader, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> PartialDeserialize(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _346_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (__default.PREFIX__LEN()).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Serialized PartialHeader too short.")));
    if ((_346_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_346_valueOrError0).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
    } else {
      byte _347_version = ((byte)(java.lang.Object)((data).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _348_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), __default.ValidVersion(_347_version), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Version Number")));
      if ((_348_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_348_valueOrError1).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
      } else {
        byte _349_flavor = ((byte)(java.lang.Object)((data).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))));
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _350_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), __default.ValidFlavor(_349_flavor), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Flavor")));
        if ((_350_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_350_valueOrError2).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _351_msgID = (data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))), dafny.Helpers.toInt((__default.PREFIX__LEN())));
          dafny.DafnySequence<? extends java.lang.Byte> _352_legendData = (data).drop(__default.PREFIX__LEN());
          Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _353_valueOrError3 = __default.GetLegend(_352_legendData);
          if ((_353_valueOrError3).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(Legend._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
            return (_353_valueOrError3).<PartialHeader>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(Legend._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
          } else {
            dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger> _354_legendAndLen = (_353_valueOrError3).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(Legend._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
            dafny.DafnySequence<? extends java.lang.Byte> _355_legend = (_354_legendAndLen).dtor__0();
            dafny.DafnySequence<? extends java.lang.Byte> _356_contextData = (_352_legendData).drop((_354_legendAndLen).dtor__1());
            Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _357_valueOrError4 = __default.GetContext(_356_contextData);
            if ((_357_valueOrError4).IsFailure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
              return (_357_valueOrError4).<PartialHeader>PropagateFailure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
            } else {
              dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger> _358_contextAndLen = (_357_valueOrError4).Extract(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _359_encContext = (_358_contextAndLen).dtor__0();
              dafny.DafnySequence<? extends java.lang.Byte> _360_keysData = (_356_contextData).drop((_358_contextAndLen).dtor__1());
              Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _361_valueOrError5 = __default.GetDataKeys(_360_keysData);
              if ((_361_valueOrError5).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyList._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                return (_361_valueOrError5).<PartialHeader>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyList._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
              } else {
                dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger> _362_keysAndLen = (_361_valueOrError5).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyList._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
                dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> _363_dataKeys = (_362_keysAndLen).dtor__0();
                dafny.DafnySequence<? extends java.lang.Byte> _364_trailingData = (_360_keysData).drop((_362_keysAndLen).dtor__1());
                Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _365_valueOrError6 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_364_trailingData).length())).compareTo(__default.COMMITMENT__LEN()) >= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid header serialization: unexpected end of data.")));
                if ((_365_valueOrError6).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                  return (_365_valueOrError6).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                } else {
                  Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _366_valueOrError7 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_364_trailingData).length())).compareTo(__default.COMMITMENT__LEN()) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid header serialization: unexpected bytes.")));
                  if ((_366_valueOrError7).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                    return (_366_valueOrError7).<PartialHeader>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                  } else {
                    return Wrappers_Compile.Result.<PartialHeader, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(StructuredEncryptionHeader_Compile.PartialHeader.create(_347_version, _349_flavor, _351_msgID, _355_legend, _359_encContext, _363_dataKeys));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> CalculateHeaderCommitment(Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> commitKey, dafny.DafnySequence<? extends java.lang.Byte> data)
  {
    Dafny.Aws.Cryptography.Primitives.Types.HMacInput _367_input = Dafny.Aws.Cryptography.Primitives.Types.HMacInput.create((((alg).dtor_commitment()).dtor_HKDF()).dtor_hmac(), commitKey, data);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _368_outputR = (client).HMac(_367_input);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _369_valueOrError0 = (_368_outputR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_370_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _370_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_370_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_370_e);
    }));
    if ((_369_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_369_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _371_output = (_369_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      if ((java.math.BigInteger.valueOf((_371_output).length())).compareTo(__default.COMMITMENT__LEN()) < 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Failure(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("HMAC did not produce enough bits")));
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success((_371_output).take(__default.COMMITMENT__LEN()));
      }
    }
  }
  public static Wrappers_Compile.Result<java.lang.Short, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ToUInt16(java.math.BigInteger x) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _372_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (x).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Value too big for 16 bits")));
    if ((_372_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_372_valueOrError0).<java.lang.Short>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StandardLibrary_mUInt_Compile.uint16._typeDescriptor());
    } else {
      return Wrappers_Compile.Result.<java.lang.Short, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success((x).shortValue());
    }
  }
  public static <__X, __Y, __Z> dafny.DafnyMap<? extends __Y, ? extends __Z> MyMap(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.TypeDescriptor<__Z> _td___Z, java.util.function.Function<__X, __Y> f, dafny.DafnyMap<? extends __X, ? extends __Z> m)
  {
    return ((dafny.Function2<dafny.DafnyMap<? extends __X, ? extends __Z>, java.util.function.Function<__X, __Y>, dafny.DafnyMap<? extends __Y, ? extends __Z>>)(_373_m, _374_f) -> ((dafny.Function0<dafny.DafnyMap<? extends __Y, ? extends __Z>>)(() -> {
      java.util.HashMap<__Y, __Z> _coll10 = new java.util.HashMap<>();
      for (__X _compr_10_boxed0 : ((_373_m).keySet()).Elements()) {
        __X _compr_10 = ((__X)(java.lang.Object)(_compr_10_boxed0));
        if (true) {
          __X _375_k = (__X)_compr_10;
          if (((_373_m).keySet()).<__X>contains(_375_k)) {
            _coll10.put(((__Y)(java.lang.Object)((_374_f).apply(_375_k))),((__Z)(java.lang.Object)((_373_m).get(_375_k))));
          }
        }
      }
      return new dafny.DafnyMap<__Y,__Z>(_coll10);
    })).apply()).apply(m, f);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> MakeLegend(dafny.DafnySequence<? extends Character> tableName, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema schema)
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _376_data = ((schema).dtor_content()).dtor_SchemaMap();
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _377_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, Boolean>)(_378_data) -> dafny.Helpers.Quantifier((_378_data).keySet().Elements(), true, ((_forall_var_7_boxed0) -> {
      dafny.DafnySequence<? extends Character> _forall_var_7 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_7_boxed0));
      if (true) {
        dafny.DafnySequence<? extends Character> _379_k = (dafny.DafnySequence<? extends Character>)_forall_var_7;
        return !((_378_data).<dafny.DafnySequence<? extends Character>>contains(_379_k)) || (StructuredEncryptionUtil_Compile.__default.ValidString(_379_k));
      } else {
        return true;
      }
    }))).apply(_376_data), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("bad attribute name")));
    if ((_377_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_377_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Legend._typeDescriptor());
    } else {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _380_authSchema = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>Let(__default.RestrictAuthAttrs(_376_data), boxed24 -> {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _pat_let12_0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>)(java.lang.Object)(boxed24));
        return ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>Let(_pat_let12_0, boxed25 -> {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _381_rawSchema = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>)(java.lang.Object)(boxed25));
          return _381_rawSchema;
        }
        )));
      }
      )));
      java.util.function.Function<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>> _382_fn = ((java.util.function.Function<dafny.DafnySequence<? extends Character>, java.util.function.Function<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>>)(_383_tableName) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>)(_384_k_boxed0) -> {
        dafny.DafnySequence<? extends Character> _384_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_384_k_boxed0));
        return StructuredEncryptionPaths_Compile.__default.SimpleCanon(_383_tableName, _384_k);
      })).apply(tableName);
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _385_canonSchema = __default.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>MyMap(StructuredEncryptionUtil_Compile.GoodString._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor(), _382_fn, _380_authSchema);
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _386_attrs = Sets.__default.<java.lang.Byte>SetToOrderedSequence2(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (_385_canonSchema).keySet(), StructuredEncryptionUtil_Compile.__default::ByteLess);
      return __default.MakeLegend2(_386_attrs, _385_canonSchema, __default.EmptyLegend());
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> MakeLegend2(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> attrs, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> data, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((attrs).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(serialized);
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _387_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.math.BigInteger.valueOf((serialized).length())).add(java.math.BigInteger.ONE)).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Legend Too Long.")));
        if ((_387_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_387_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Legend._typeDescriptor());
        } else {
          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _388_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((data).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((attrs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))).dtor_content()).is_Action(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema must be flat")));
          if ((_388_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
            return (_388_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Legend._typeDescriptor());
          } else {
            byte _389_legendChar = __default.GetActionLegend(((((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((data).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((attrs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))).dtor_content()).dtor_Action());
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in36 = (attrs).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _in37 = data;
            dafny.DafnySequence<? extends java.lang.Byte> _in38 = dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, dafny.DafnySequence.of(_389_legendChar));
            attrs = _in36;
            data = _in37;
            serialized = _in38;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public static byte GetActionLegend(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction x) {
    Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction _source4 = x;
    if (_source4.is_ENCRYPT__AND__SIGN()) {
      return __default.ENCRYPT__AND__SIGN__LEGEND();
    } else {
      return __default.SIGN__ONLY__LEGEND();
    }
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> RestrictAuthAttrs(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> data) {
    return ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>)(_390_data) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _coll11 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends Character> _compr_11_boxed0 : (_390_data).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_11 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_11_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _391_k = (dafny.DafnySequence<? extends Character>)_compr_11;
          if (((_390_data).<dafny.DafnySequence<? extends Character>>contains(_391_k)) && (StructuredEncryptionUtil_Compile.__default.IsAuthAttr(((((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((_390_data).get(_391_k)))).dtor_content()).dtor_Action()))) {
            _coll11.put(_391_k,((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((_390_data).get(_391_k))));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>(_coll11);
    })).apply()).apply(data);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeLegend(dafny.DafnySequence<? extends java.lang.Byte> x) {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) (x).cardinalityInt()), x);
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetLegend(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _392_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_392_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_392_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.TypeDescriptor.BIG_INTEGER));
    } else {
      short _393_len = StandardLibrary_mUInt_Compile.__default.SeqToUInt16((data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L)))));
      java.math.BigInteger _394_size = (java.math.BigInteger.valueOf(java.lang.Short.toUnsignedLong(_393_len))).add(java.math.BigInteger.valueOf(2L));
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _395_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (_394_size).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
      if ((_395_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_395_valueOrError1).<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.TypeDescriptor.BIG_INTEGER));
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _396_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((dafny.Function2<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger, Boolean>)(_397_data, _398_size) -> dafny.Helpers.Quantifier(((_397_data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))), dafny.Helpers.toInt((_398_size)))).UniqueElements(), true, ((_forall_var_8_boxed0) -> {
          byte _forall_var_8 = ((byte)(java.lang.Object)(_forall_var_8_boxed0));
          if (true) {
            byte _399_x = (byte)_forall_var_8;
            return !(((_397_data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))), dafny.Helpers.toInt((_398_size)))).contains(_399_x)) || (__default.ValidLegendByte(_399_x));
          } else {
            return true;
          }
        }))).apply(data, _394_size), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid byte in stored legend")));
        if ((_396_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_396_valueOrError2).<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.TypeDescriptor.BIG_INTEGER));
        } else {
          return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>create((data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))), dafny.Helpers.toInt((_394_size))), _394_size));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetContext(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _400_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_400_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_400_valueOrError0).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()));
    } else {
      java.math.BigInteger _401_count = java.math.BigInteger.valueOf(java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqToUInt16((data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L)))))));
      Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _402_valueOrError1 = __default.GetContext2(_401_count, data, (data).drop(java.math.BigInteger.valueOf(2L)), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>create(dafny.DafnyMap.fromElements(), java.math.BigInteger.valueOf(2L)), dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      if ((_402_valueOrError1).IsFailure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_402_valueOrError1).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>>PropagateFailure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()));
      } else {
        dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger> _403_context = (_402_valueOrError1).Extract(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(_403_context);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetOneKVPair(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _404_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_404_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_404_valueOrError0).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.TypeDescriptor.BIG_INTEGER));
    } else {
      java.math.BigInteger _405_keyLen = java.math.BigInteger.valueOf(java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqToUInt16((data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L)))))));
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _406_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((_405_keyLen).add(java.math.BigInteger.valueOf(4L))).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
      if ((_406_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_406_valueOrError1).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.TypeDescriptor.BIG_INTEGER));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _407_key = (data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))), dafny.Helpers.toInt(((_405_keyLen).add(java.math.BigInteger.valueOf(2L)))));
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _408_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), UTF8.__default.ValidUTF8Seq(_407_key), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid UTF8 found in header.")));
        if ((_408_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_408_valueOrError2).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.TypeDescriptor.BIG_INTEGER));
        } else {
          java.math.BigInteger _409_valueLen = java.math.BigInteger.valueOf(java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqToUInt16((data).subsequence(dafny.Helpers.toInt(((_405_keyLen).add(java.math.BigInteger.valueOf(2L)))), dafny.Helpers.toInt(((_405_keyLen).add(java.math.BigInteger.valueOf(4L))))))));
          java.math.BigInteger _410_kvLen = (((java.math.BigInteger.valueOf(2L)).add(_405_keyLen)).add(java.math.BigInteger.valueOf(2L))).add(_409_valueLen);
          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _411_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (_410_kvLen).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
          if ((_411_valueOrError3).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
            return (_411_valueOrError3).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.TypeDescriptor.BIG_INTEGER));
          } else {
            dafny.DafnySequence<? extends java.lang.Byte> _412_value = (data).subsequence(dafny.Helpers.toInt(((_405_keyLen).add(java.math.BigInteger.valueOf(4L)))), dafny.Helpers.toInt((_410_kvLen)));
            Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _413_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), UTF8.__default.ValidUTF8Seq(_412_value), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid UTF8 found in header.")));
            if ((_413_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
              return (_413_valueOrError4).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.TypeDescriptor.BIG_INTEGER));
            } else {
              return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>create(_407_key, _412_value, _410_kvLen));
            }
          }
        }
      }
    }
  }
  public static boolean BytesLess(dafny.DafnySequence<? extends java.lang.Byte> a, dafny.DafnySequence<? extends java.lang.Byte> b)
  {
    TAIL_CALL_START: while (true) {
      if ((a).equals(b)) {
        return false;
      } else if ((java.math.BigInteger.valueOf((a).length())).signum() == 0) {
        return true;
      } else if ((java.math.BigInteger.valueOf((b).length())).signum() == 0) {
        return false;
      } else if ((((byte)(java.lang.Object)((a).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) != (((byte)(java.lang.Object)((b).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) {
        return java.lang.Integer.compareUnsigned(((byte)(java.lang.Object)((a).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), ((byte)(java.lang.Object)((b).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) < 0;
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _in39 = (a).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends java.lang.Byte> _in40 = (b).drop(java.math.BigInteger.ONE);
        a = _in39;
        b = _in40;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetContext2(java.math.BigInteger count, dafny.DafnySequence<? extends java.lang.Byte> origData, dafny.DafnySequence<? extends java.lang.Byte> data, dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger> deserialized, dafny.DafnySequence<? extends java.lang.Byte> prevKey)
  {
    TAIL_CALL_START: while (true) {
      if ((count).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(deserialized);
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _414_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.math.BigInteger.valueOf(((deserialized).dtor__0()).size())).add(java.math.BigInteger.ONE)).compareTo(StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Too much context")));
        if ((_414_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_414_valueOrError0).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()));
        } else {
          Wrappers_Compile.Result<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _415_valueOrError1 = __default.GetOneKVPair(data);
          if ((_415_valueOrError1).IsFailure(dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(CMPUtf8Bytes._typeDescriptor(), CMPUtf8Bytes._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
            return (_415_valueOrError1).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>>PropagateFailure(dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(CMPUtf8Bytes._typeDescriptor(), CMPUtf8Bytes._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()));
          } else {
            dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger> _416_kv = (_415_valueOrError1).Extract(dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.math.BigInteger>_typeDescriptor(CMPUtf8Bytes._typeDescriptor(), CMPUtf8Bytes._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
            Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _417_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), __default.BytesLess(prevKey, (_416_kv).dtor__0()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Context keys out of order.")));
            if ((_417_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
              return (_417_valueOrError2).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), _System.nat._typeDescriptor()));
            } else {
              java.math.BigInteger _in41 = (count).subtract(java.math.BigInteger.ONE);
              dafny.DafnySequence<? extends java.lang.Byte> _in42 = origData;
              dafny.DafnySequence<? extends java.lang.Byte> _in43 = (data).drop((((java.math.BigInteger.valueOf(2L)).add(java.math.BigInteger.valueOf(((_416_kv).dtor__0()).length()))).add(java.math.BigInteger.valueOf(2L))).add(java.math.BigInteger.valueOf(((_416_kv).dtor__1()).length())));
              dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger> _in44 = dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.math.BigInteger>create(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>update((deserialized).dtor__0(), (_416_kv).dtor__0(), (_416_kv).dtor__1()), ((deserialized).dtor__1()).add((_416_kv).dtor__2()));
              dafny.DafnySequence<? extends java.lang.Byte> _in45 = (_416_kv).dtor__0();
              count = _in41;
              origData = _in42;
              data = _in43;
              deserialized = _in44;
              prevKey = _in45;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeContext(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> x) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _418_keys = Sets.__default.<java.lang.Byte>SetToOrderedSequence2(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (x).keySet(), StructuredEncryptionUtil_Compile.__default::ByteLess);
    return dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) (x).cardinalityInt()), __default.SerializeContext2(_418_keys, x));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeOneKVPair(dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends java.lang.Byte> value)
  {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) (key).cardinalityInt()), key), StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) (value).cardinalityInt())), value);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeOneDataKey(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey k) {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) ((k).dtor_keyProviderId()).cardinalityInt()), (k).dtor_keyProviderId()), StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) ((k).dtor_keyProviderInfo()).cardinalityInt())), (k).dtor_keyProviderInfo()), StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) ((k).dtor_ciphertext()).cardinalityInt())), (k).dtor_ciphertext());
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetOneDataKey(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _419_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf((data).length())) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_419_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_419_valueOrError0).<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
    } else {
      java.math.BigInteger _420_provIdSize = java.math.BigInteger.valueOf(java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqToUInt16((data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L)))))));
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _421_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((_420_provIdSize).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((data).length())) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
      if ((_421_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_421_valueOrError1).<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _422_provId = (data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))), dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L)).add(_420_provIdSize))));
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _423_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), UTF8.__default.ValidUTF8Seq(_422_provId), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid UTF8 found in header.")));
        if ((_423_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_423_valueOrError2).<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
        } else {
          java.math.BigInteger _424_part1Size = (java.math.BigInteger.valueOf(2L)).add(_420_provIdSize);
          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _425_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((_424_part1Size).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
          if ((_425_valueOrError3).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
            return (_425_valueOrError3).<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
          } else {
            java.math.BigInteger _426_provInfoSize = java.math.BigInteger.valueOf(java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqToUInt16((data).subsequence(dafny.Helpers.toInt((_424_part1Size)), dafny.Helpers.toInt(((_424_part1Size).add(java.math.BigInteger.valueOf(2L))))))));
            Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _427_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((_424_part1Size).add(_426_provInfoSize)).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((data).length())) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
            if ((_427_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
              return (_427_valueOrError4).<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
            } else {
              dafny.DafnySequence<? extends java.lang.Byte> _428_provInfo = (data).subsequence(dafny.Helpers.toInt(((_424_part1Size).add(java.math.BigInteger.valueOf(2L)))), dafny.Helpers.toInt((((_424_part1Size).add(java.math.BigInteger.valueOf(2L))).add(_426_provInfoSize))));
              java.math.BigInteger _429_part2Size = ((_424_part1Size).add(java.math.BigInteger.valueOf(2L))).add(_426_provInfoSize);
              Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _430_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((_429_part2Size).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
              if ((_430_valueOrError5).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                return (_430_valueOrError5).<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
              } else {
                java.math.BigInteger _431_cipherSize = java.math.BigInteger.valueOf(java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqToUInt16((data).subsequence(dafny.Helpers.toInt((_429_part2Size)), dafny.Helpers.toInt(((_429_part2Size).add(java.math.BigInteger.valueOf(2L))))))));
                Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _432_valueOrError6 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((_429_part2Size).add(_431_cipherSize)).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
                if ((_432_valueOrError6).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
                  return (_432_valueOrError6).<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor(), dafny.TypeDescriptor.BIG_INTEGER));
                } else {
                  dafny.DafnySequence<? extends java.lang.Byte> _433_cipher = (data).subsequence(dafny.Helpers.toInt(((_429_part2Size).add(java.math.BigInteger.valueOf(2L)))), dafny.Helpers.toInt((((_429_part2Size).add(java.math.BigInteger.valueOf(2L))).add(_431_cipherSize))));
                  java.math.BigInteger _434_part3Size = ((_429_part2Size).add(java.math.BigInteger.valueOf(2L))).add(_431_cipherSize);
                  Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey _435_edk = Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey.create(_422_provId, _428_provInfo, _433_cipher);
                  return Wrappers_Compile.Result.<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>create(_435_edk, _434_part3Size));
                }
              }
            }
          }
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeContext2(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> keys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> x)
  {
    dafny.DafnySequence<? extends java.lang.Byte> _436___accumulator = dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((keys).length())).signum() == 0) {
        return dafny.DafnySequence.<java.lang.Byte>concatenate(_436___accumulator, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        _436___accumulator = dafny.DafnySequence.<java.lang.Byte>concatenate(_436___accumulator, __default.SerializeOneKVPair(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((keys).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((x).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((keys).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))));
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in46 = (keys).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in47 = x;
        keys = _in46;
        x = _in47;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeDataKeys(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> x) {
    dafny.DafnySequence<? extends java.lang.Byte> _437_body = __default.SerializeDataKeys2(x);
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.of((byte) (x).cardinalityInt()), _437_body);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeDataKeys2(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> x) {
    dafny.DafnySequence<? extends java.lang.Byte> _438___accumulator = dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((x).length())).signum() == 0) {
        return dafny.DafnySequence.<java.lang.Byte>concatenate(_438___accumulator, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        _438___accumulator = dafny.DafnySequence.<java.lang.Byte>concatenate(_438___accumulator, __default.SerializeOneDataKey(((Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey)(java.lang.Object)((x).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> _in48 = (x).drop(java.math.BigInteger.ONE);
        x = _in48;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetDataKeys(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _439_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((data).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_439_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_439_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), _System.nat._typeDescriptor()));
    } else {
      java.math.BigInteger _440_count = java.math.BigInteger.valueOf(java.lang.Byte.toUnsignedLong(((byte)(java.lang.Object)((data).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
      Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _441_valueOrError1 = __default.GetDataKeys2(_440_count, _440_count, data, (data).drop(java.math.BigInteger.ONE), dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>create(dafny.DafnySequence.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> empty(CMPEncryptedDataKey._typeDescriptor()), java.math.BigInteger.ONE));
      if ((_441_valueOrError1).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_441_valueOrError1).<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), _System.nat._typeDescriptor()));
      } else {
        dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger> _442_keys = (_441_valueOrError1).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
        if ((java.math.BigInteger.valueOf(((_442_keys).dtor__0()).length())).signum() == 0) {
          return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Failure(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("At least one Data Key required")));
        } else {
          return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(_442_keys);
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetDataKeys2(java.math.BigInteger count, java.math.BigInteger origCount, dafny.DafnySequence<? extends java.lang.Byte> origData, dafny.DafnySequence<? extends java.lang.Byte> data, dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger> deserialized)
  {
    TAIL_CALL_START: while (true) {
      if ((count).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(deserialized);
      } else if ((java.math.BigInteger.valueOf(((deserialized).dtor__0()).length())).compareTo(java.math.BigInteger.valueOf(255L)) >= 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Failure(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Too Many Data Keys")));
      } else {
        Wrappers_Compile.Result<dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _443_valueOrError0 = __default.GetOneDataKey(data);
        if ((_443_valueOrError0).IsFailure(dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_443_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>>PropagateFailure(dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), _System.nat._typeDescriptor()));
        } else {
          dafny.Tuple2<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger> _444_edk = (_443_valueOrError0).Extract(dafny.Tuple2.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey, java.math.BigInteger>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), _System.nat._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
          java.math.BigInteger _in49 = (count).subtract(java.math.BigInteger.ONE);
          java.math.BigInteger _in50 = origCount;
          dafny.DafnySequence<? extends java.lang.Byte> _in51 = origData;
          dafny.DafnySequence<? extends java.lang.Byte> _in52 = (data).drop((_444_edk).dtor__1());
          dafny.Tuple2<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger> _in53 = dafny.Tuple2.<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>, java.math.BigInteger>create(dafny.DafnySequence.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey>concatenate((deserialized).dtor__0(), dafny.DafnySequence.of(CMPEncryptedDataKey._typeDescriptor(), (_444_edk).dtor__0())), ((deserialized).dtor__1()).add((_444_edk).dtor__1()));
          count = _in49;
          origCount = _in50;
          origData = _in51;
          data = _in52;
          deserialized = _in53;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static java.math.BigInteger UINT8__LIMIT()
  {
    return java.math.BigInteger.valueOf(256L);
  }
  public static java.math.BigInteger COMMITMENT__LEN()
  {
    return java.math.BigInteger.valueOf(32L);
  }
  public static byte ENCRYPT__AND__SIGN__LEGEND()
  {
    return (byte) 101;
  }
  public static byte SIGN__ONLY__LEGEND()
  {
    return (byte) 115;
  }
  public static java.math.BigInteger VERSION__LEN()
  {
    return java.math.BigInteger.ONE;
  }
  public static java.math.BigInteger FLAVOR__LEN()
  {
    return java.math.BigInteger.ONE;
  }
  public static java.math.BigInteger PREFIX__LEN()
  {
    return ((__default.VERSION__LEN()).add(__default.FLAVOR__LEN())).add(StructuredEncryptionUtil_Compile.__default.MSGID__LEN());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> EmptyLegend()
  {
    return dafny.DafnySequence.<java.lang.Byte> empty(LegendByte._typeDescriptor());
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionHeader_Compile._default";
  }
}
