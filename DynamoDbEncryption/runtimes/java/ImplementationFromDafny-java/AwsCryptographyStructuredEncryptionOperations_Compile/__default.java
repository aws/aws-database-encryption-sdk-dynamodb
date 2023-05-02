// Class __default
// Dafny class __default compiled into Java
package AwsCryptographyStructuredEncryptionOperations_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> FilterEncrypted(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> fields, dafny.DafnySequence<? extends java.lang.Byte> legend)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _546___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((fields).length())).signum() == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_546___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
      } else if ((((byte)(java.lang.Object)((legend).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == (StructuredEncryptionHeader_Compile.__default.ENCRYPT__AND__SIGN__LEGEND())) {
        _546___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_546___accumulator, dafny.DafnySequence.of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in61 = (fields).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends java.lang.Byte> _in62 = (legend).drop(java.math.BigInteger.ONE);
        fields = _in61;
        legend = _in62;
        continue TAIL_CALL_START;
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in63 = (fields).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends java.lang.Byte> _in64 = (legend).drop(java.math.BigInteger.ONE);
        fields = _in63;
        legend = _in64;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> NeedBinary(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data, dafny.DafnySequence<? extends Character> field)
  {
    if (!(data).<dafny.DafnySequence<? extends Character>>contains(field)) {
      return Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Fail(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The field name "), field), dafny.DafnySequence.asString(" is required."))));
    } else if (!(((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((data).get(field)))).dtor_content()).is_Terminal())) {
      return Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Fail(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(field, dafny.DafnySequence.asString(" must be a Terminal."))));
    } else if (!((((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((data).get(field)))).dtor_content()).dtor_Terminal()).dtor_typeId()).equals(StructuredEncryptionUtil_Compile.__default.BYTES__TYPE__ID())) {
      return Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Fail(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(field, dafny.DafnySequence.asString(" must be a binary Terminal."))));
    } else {
      return Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Pass();
    }
  }
  public static java.math.BigInteger SumValueSize(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> fields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data)
  {
    java.math.BigInteger _547___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((fields).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_547___accumulator);
      } else {
        _547___accumulator = (_547___accumulator).add(java.math.BigInteger.valueOf(((((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((data).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))).dtor_content()).dtor_Terminal()).dtor_value()).length()));
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in65 = (fields).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _in66 = data;
        fields = _in65;
        data = _in66;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteId GetAlgorithmSuiteId(Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> alg) {
    if ((alg).is_Some()) {
      return Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteId.create_DBE((alg).dtor_value());
    } else {
      return Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteId.create_DBE(Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId.create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384());
    }
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetStructuredEncryptionMaterials(Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager cmm, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>> encryptionContext, Wrappers_Compile.Option<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId> algorithmSuiteId, java.math.BigInteger encryptedTerminalDataNum, java.math.BigInteger totalEncryptedTerminalValuesSize)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    java.math.BigInteger _548_maxLength = java.math.BigInteger.ZERO;
    _548_maxLength = ((encryptedTerminalDataNum).multiply(java.math.BigInteger.valueOf(2L))).add(totalEncryptedTerminalValuesSize);
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _549_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _549_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (_548_maxLength).compareTo(StandardLibrary_mUInt_Compile.__default.INT64__MAX__LIMIT()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Encrypted Size too long.")));
    if ((_549_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_549_valueOrError0).<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials._typeDescriptor());
      return ret;
    }
    Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteId _550_algId;
    _550_algId = __default.GetAlgorithmSuiteId(algorithmSuiteId);
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _551_matR;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out19;
    _out19 = (cmm).GetEncryptionMaterials(Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsInput.create((encryptionContext).UnwrapOr(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), dafny.DafnyMap.fromElements()), __default.DBE__COMMITMENT__POLICY(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteId>create_Some(_550_algId), Wrappers_Compile.Option.<java.lang.Long>create_Some((_548_maxLength).longValue()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>>>create_None()));
    _551_matR = _out19;
    Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput _552_matOutput;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _553_valueOrError1 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    _553_valueOrError1 = (_551_matR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_554_e_boxed0) -> {
      Dafny.Aws.Cryptography.MaterialProviders.Types.Error _554_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_554_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyMaterialProviders(_554_e);
    }));
    if ((_553_valueOrError1).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_553_valueOrError1).<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials._typeDescriptor());
      return ret;
    }
    _552_matOutput = (_553_valueOrError1).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types.GetEncryptionMaterialsOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials _555_mat;
    _555_mat = (_552_matOutput).dtor_encryptionMaterials();
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _556_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _556_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Materials_Compile.__default.EncryptionMaterialsHasPlaintextDataKey(_555_mat), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Encryption material has no key")));
    if ((_556_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_556_valueOrError2).<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials._typeDescriptor());
      return ret;
    }
    Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo _557_alg;
    _557_alg = (_555_mat).dtor_algorithmSuite();
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _558_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _558_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidSuite(_557_alg), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Algorithm Suite")));
    if ((_558_valueOrError3).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_558_valueOrError3).<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials._typeDescriptor());
      return ret;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _559_key;
    _559_key = ((_555_mat).dtor_plaintextDataKey()).dtor_value();
    ret = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(_555_mat);
    return ret;
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> FilterEncrypt(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> fields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>> fieldMap, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> schema)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _560___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((fields).length())).signum() == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_560___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
      } else {
        Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction _561_act = ((((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((schema).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((fieldMap).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))))))).dtor_content()).dtor_Action();
        if (java.util.Objects.equals(_561_act, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN())) {
          _560___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_560___accumulator, dafny.DafnySequence.of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in67 = (fields).drop(java.math.BigInteger.ONE);
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>> _in68 = fieldMap;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _in69 = schema;
          fields = _in67;
          fieldMap = _in68;
          schema = _in69;
          continue TAIL_CALL_START;
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in70 = (fields).drop(java.math.BigInteger.ONE);
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>> _in71 = fieldMap;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _in72 = schema;
          fields = _in70;
          fieldMap = _in71;
          schema = _in72;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>> GetFieldMap(dafny.DafnySequence<? extends Character> tableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> schema)
  {
    return ((dafny.Function3<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, dafny.DafnySequence<? extends Character>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>>>)(_562_data, _563_schema, _564_tableName) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _coll15 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends Character> _compr_15_boxed0 : ((_562_data).keySet()).Elements()) {
        dafny.DafnySequence<? extends Character> _compr_15 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_15_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _565_k = (dafny.DafnySequence<? extends Character>)_compr_15;
          if ((((_562_data).keySet()).<dafny.DafnySequence<? extends Character>>contains(_565_k)) && (!java.util.Objects.equals(((((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((_563_schema).get(_565_k)))).dtor_content()).dtor_Action(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING()))) {
            _coll15.put(StructuredEncryptionPaths_Compile.__default.SimpleCanon(_564_tableName, _565_k),_565_k);
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends Character>>(_coll15);
    })).apply()).apply(data, schema, tableName);
  }
  public static Wrappers_Compile.Result<EncryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> CanonizeForEncrypt(dafny.DafnySequence<? extends Character> tableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> schema)
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>> _566_fieldMap = __default.GetFieldMap(tableName, data, schema);
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _567_data__c = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>)(_568_fieldMap, _569_data) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _coll16 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends java.lang.Byte> _compr_16_boxed0 : (_568_fieldMap).keySet().Elements()) {
        dafny.DafnySequence<? extends java.lang.Byte> _compr_16 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(_compr_16_boxed0));
        if (true) {
          dafny.DafnySequence<? extends java.lang.Byte> _570_k = (dafny.DafnySequence<? extends java.lang.Byte>)_compr_16;
          if ((_568_fieldMap).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_570_k)) {
            _coll16.put(_570_k,((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_569_data).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_568_fieldMap).get(_570_k)))))));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>(_coll16);
    })).apply()).apply(_566_fieldMap, data);
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _571_signedFields__c = Sets.__default.<java.lang.Byte>SetToOrderedSequence2(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (_567_data__c).keySet(), StructuredEncryptionUtil_Compile.__default::ByteLess);
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _572_encFields__c = __default.FilterEncrypt(_571_signedFields__c, _566_fieldMap, schema);
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _573_trimmedSchema = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>)(_574_fieldMap, _575_schema) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _coll17 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends Character> _compr_17_boxed0 : ((_574_fieldMap).valueSet()).Elements()) {
        dafny.DafnySequence<? extends Character> _compr_17 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_17_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _576_k = (dafny.DafnySequence<? extends Character>)_compr_17;
          if (((_574_fieldMap).valueSet()).<dafny.DafnySequence<? extends Character>>contains(_576_k)) {
            _coll17.put(_576_k,((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((_575_schema).get(_576_k))));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>(_coll17);
    })).apply()).apply(_566_fieldMap, schema);
    return Wrappers_Compile.Result.<EncryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(AwsCryptographyStructuredEncryptionOperations_Compile.EncryptCanonData.create(_572_encFields__c, _571_signedFields__c, _567_data__c, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_SchemaMap(_573_trimmedSchema), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None())));
  }
  public static Wrappers_Compile.Result<DecryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> CanonizeForDecrypt(CanonizeForDecryptInput input) {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>> _577_fieldMap = ((java.util.function.Function<CanonizeForDecryptInput, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>>>)(_578_input) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _coll18 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends Character> _compr_18_boxed0 : (((_578_input).dtor_data()).keySet()).Elements()) {
        dafny.DafnySequence<? extends Character> _compr_18 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_18_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _579_k = (dafny.DafnySequence<? extends Character>)_compr_18;
          if (((((_578_input).dtor_data()).keySet()).<dafny.DafnySequence<? extends Character>>contains(_579_k)) && (java.util.Objects.equals(((((Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema)(java.lang.Object)(((_578_input).dtor_authSchema()).get(_579_k)))).dtor_content()).dtor_Action(), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.create_SIGN()))) {
            _coll18.put(StructuredEncryptionPaths_Compile.__default.SimpleCanon((_578_input).dtor_tableName(), _579_k),_579_k);
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends Character>>(_coll18);
    })).apply()).apply(input);
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _580_data__c = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>>, CanonizeForDecryptInput, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>)(_581_fieldMap, _582_input) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _coll19 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends java.lang.Byte> _compr_19_boxed0 : (_581_fieldMap).keySet().Elements()) {
        dafny.DafnySequence<? extends java.lang.Byte> _compr_19 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(_compr_19_boxed0));
        if (true) {
          dafny.DafnySequence<? extends java.lang.Byte> _583_k = (dafny.DafnySequence<? extends java.lang.Byte>)_compr_19;
          if ((_581_fieldMap).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_583_k)) {
            _coll19.put(_583_k,((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)(((_582_input).dtor_data()).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_581_fieldMap).get(_583_k)))))));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>(_coll19);
    })).apply()).apply(_577_fieldMap, input);
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _584_signedFields__c = Sets.__default.<java.lang.Byte>SetToOrderedSequence2(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (_580_data__c).keySet(), StructuredEncryptionUtil_Compile.__default::ByteLess);
    if ((java.math.BigInteger.valueOf(((input).dtor_legend()).length())).compareTo(java.math.BigInteger.valueOf((_584_signedFields__c).length())) < 0) {
      return Wrappers_Compile.Result.<DecryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Failure(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema changed : something that was unsigned is now signed.")));
    } else if ((java.math.BigInteger.valueOf(((input).dtor_legend()).length())).compareTo(java.math.BigInteger.valueOf((_584_signedFields__c).length())) > 0) {
      return Wrappers_Compile.Result.<DecryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Failure(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema changed : something that was signed is now unsigned.")));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _585_encFields__c = __default.FilterEncrypted(_584_signedFields__c, (input).dtor_legend());
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _586_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_585_encFields__c).length())).compareTo(dafny.DafnyEuclidean.EuclideanDivision(StandardLibrary_mUInt_Compile.__default.UINT32__LIMIT(), java.math.BigInteger.valueOf(3L))) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Too many encrypted fields.")));
      if ((_586_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_586_valueOrError0).<DecryptCanonData>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), DecryptCanonData._typeDescriptor());
      } else {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _587_actionMap = ((dafny.Function3<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends Character>>, CanonizeForDecryptInput, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>)(_588_fieldMap, _589_input, _590_encFields__c) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>)(() -> {
          java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _coll20 = new java.util.HashMap<>();
          for (dafny.DafnySequence<? extends Character> _compr_20_boxed0 : ((_588_fieldMap).valueSet()).Elements()) {
            dafny.DafnySequence<? extends Character> _compr_20 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_20_boxed0));
            if (true) {
              dafny.DafnySequence<? extends Character> _591_v = (dafny.DafnySequence<? extends Character>)_compr_20;
              if (((_588_fieldMap).valueSet()).<dafny.DafnySequence<? extends Character>>contains(_591_v)) {
                _coll20.put(_591_v,(((_590_encFields__c).contains(StructuredEncryptionPaths_Compile.__default.SimpleCanon((_589_input).dtor_tableName(), _591_v))) ? (Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None())) : (Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None()))));
              }
            }
          }
          return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>(_coll20);
        })).apply()).apply(_577_fieldMap, input, _585_encFields__c);
        Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema _592_cryptoSchema = Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_SchemaMap(_587_actionMap), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
        DecryptCanonData _593_c = AwsCryptographyStructuredEncryptionOperations_Compile.DecryptCanonData.create(_585_encFields__c, _584_signedFields__c, _580_data__c, _592_cryptoSchema);
        return Wrappers_Compile.Result.<DecryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(_593_c);
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> EncryptStructure(Config config, Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _594_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _594_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((input).dtor_plaintextStructure()).dtor_content()).is_DataMap(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Input structure must be a DataMap")));
    if ((_594_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_594_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _595_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _595_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((input).dtor_cryptoSchema()).dtor_content()).is_SchemaMap(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Input Crypto Schema must be a SchemaMap")));
    if ((_595_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_595_valueOrError1).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _596_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _596_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((input).dtor_encryptionContext()).is_None()) || (!(((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput, Boolean>)(_597_input) -> dafny.Helpers.Quantifier((((_597_input).dtor_encryptionContext()).dtor_value()).keySet().Elements(), false, ((_exists_var_0_boxed0) -> {
      dafny.DafnySequence<? extends java.lang.Byte> _exists_var_0 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(_exists_var_0_boxed0));
      if (true) {
        dafny.DafnySequence<? extends java.lang.Byte> _598_k = (dafny.DafnySequence<? extends java.lang.Byte>)_exists_var_0;
        return ((((_597_input).dtor_encryptionContext()).dtor_value()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_598_k)) && ((StructuredEncryptionUtil_Compile.__default.ReservedCryptoContextPrefixUTF8()).isPrefixOf(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((((_597_input).dtor_encryptionContext()).dtor_value()).get(_598_k)))));
      } else {
        return false;
      }
    }))).apply(input))), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Encryption Context must not contain members beginning with "), StructuredEncryptionUtil_Compile.__default.ReservedCryptoContextPrefixString())));
    if ((_596_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_596_valueOrError2).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _599_cryptoSchema;
    _599_cryptoSchema = (((input).dtor_cryptoSchema()).dtor_content()).dtor_SchemaMap();
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _600_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _600_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.CryptoSchemaMapIsFlat(_599_cryptoSchema), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema must be flat.")));
    if ((_600_valueOrError3).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_600_valueOrError3).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _601_valueOrError4 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _601_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, Boolean>)(_602_cryptoSchema) -> dafny.Helpers.Quantifier((_602_cryptoSchema).keySet().Elements(), true, ((_forall_var_9_boxed0) -> {
      dafny.DafnySequence<? extends Character> _forall_var_9 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_9_boxed0));
      if (true) {
        dafny.DafnySequence<? extends Character> _603_k = (dafny.DafnySequence<? extends Character>)_forall_var_9;
        return !((_602_cryptoSchema).<dafny.DafnySequence<? extends Character>>contains(_603_k)) || (StructuredEncryptionUtil_Compile.__default.ValidString(_603_k));
      } else {
        return true;
      }
    }))).apply(_599_cryptoSchema), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema has bad field name.")));
    if ((_601_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_601_valueOrError4).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _604_valueOrError5 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _604_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, Boolean>)(_605_cryptoSchema) -> dafny.Helpers.Quantifier((_605_cryptoSchema).keySet().Elements(), false, ((_exists_var_1_boxed0) -> {
      dafny.DafnySequence<? extends Character> _exists_var_1 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_exists_var_1_boxed0));
      if (true) {
        dafny.DafnySequence<? extends Character> _606_k = (dafny.DafnySequence<? extends Character>)_exists_var_1;
        return ((_605_cryptoSchema).<dafny.DafnySequence<? extends Character>>contains(_606_k)) && (java.util.Objects.equals(((((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((_605_cryptoSchema).get(_606_k)))).dtor_content()).dtor_Action(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN()));
      } else {
        return false;
      }
    }))).apply(_599_cryptoSchema), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema has bad field name.")));
    if ((_604_valueOrError5).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_604_valueOrError5).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _607_plainRecord;
    _607_plainRecord = (((input).dtor_plaintextStructure()).dtor_content()).dtor_DataMap();
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _608_valueOrError6 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _608_valueOrError6 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.DataMapIsFlat(_607_plainRecord), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Input DataMap must be flat.")));
    if ((_608_valueOrError6).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_608_valueOrError6).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _609_valueOrError7 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _609_valueOrError7 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), !(_607_plainRecord).<dafny.DafnySequence<? extends Character>>contains(StructuredEncryptionUtil_Compile.__default.HeaderField()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The field name "), StructuredEncryptionUtil_Compile.__default.HeaderField()), dafny.DafnySequence.asString(" is reserved."))));
    if ((_609_valueOrError7).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_609_valueOrError7).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _610_valueOrError8 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _610_valueOrError8 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), !(_607_plainRecord).<dafny.DafnySequence<? extends Character>>contains(StructuredEncryptionUtil_Compile.__default.FooterField()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("The field name "), StructuredEncryptionUtil_Compile.__default.FooterField()), dafny.DafnySequence.asString(" is reserved."))));
    if ((_610_valueOrError8).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_610_valueOrError8).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _611_valueOrError9 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _611_valueOrError9 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((_607_plainRecord).keySet()).equals((_599_cryptoSchema).keySet()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema must exactly match record")));
    if ((_611_valueOrError9).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_611_valueOrError9).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _612_valueOrError10 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _612_valueOrError10 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidString((input).dtor_tableName()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad Table Name")));
    if ((_612_valueOrError10).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_612_valueOrError10).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    EncryptCanonData _613_canonData;
    Wrappers_Compile.Result<EncryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _614_valueOrError11 = (Wrappers_Compile.Result<EncryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    _614_valueOrError11 = __default.CanonizeForEncrypt((input).dtor_tableName(), _607_plainRecord, _599_cryptoSchema);
    if ((_614_valueOrError11).IsFailure(EncryptCanon._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_614_valueOrError11).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(EncryptCanon._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _613_canonData = (_614_valueOrError11).Extract(EncryptCanon._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials _615_mat;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _616_valueOrError12 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out20;
    _out20 = __default.GetStructuredEncryptionMaterials((input).dtor_cmm(), (input).dtor_encryptionContext(), (input).dtor_algorithmSuiteId(), java.math.BigInteger.valueOf(((_613_canonData).dtor_encFields__c()).length()), __default.SumValueSize((_613_canonData).dtor_encFields__c(), (_613_canonData).dtor_data__c()));
    _616_valueOrError12 = _out20;
    if ((_616_valueOrError12).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_616_valueOrError12).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _615_mat = (_616_valueOrError12).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _617_key;
    _617_key = ((_615_mat).dtor_plaintextDataKey()).dtor_value();
    Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo _618_alg;
    _618_alg = (_615_mat).dtor_algorithmSuite();
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _619_valueOrError13 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _619_valueOrError13 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionHeader_Compile.__default.ValidEncryptionContext((_615_mat).dtor_encryptionContext()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad encryption context")));
    if ((_619_valueOrError13).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_619_valueOrError13).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _620_randBytes;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _out21;
    _out21 = Random_Compile.__default.GenerateBytes((StructuredEncryptionUtil_Compile.__default.MSGID__LEN()).intValue());
    _620_randBytes = _out21;
    dafny.DafnySequence<? extends java.lang.Byte> _621_msgID;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _622_valueOrError14 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _622_valueOrError14 = (_620_randBytes).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_623_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _623_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_623_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_623_e);
    }));
    if ((_622_valueOrError14).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_622_valueOrError14).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _621_msgID = (_622_valueOrError14).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    StructuredEncryptionHeader_Compile.PartialHeader _624_head;
    Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _625_valueOrError15 = (Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    _625_valueOrError15 = StructuredEncryptionHeader_Compile.__default.Create((input).dtor_tableName(), (input).dtor_cryptoSchema(), _621_msgID, _615_mat);
    if ((_625_valueOrError15).IsFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_625_valueOrError15).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _624_head = (_625_valueOrError15).Extract(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _626_commitKey;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _627_valueOrError16 = (Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out22;
    _out22 = StructuredEncryptionCrypt_Compile.__default.GetCommitKey((config).dtor_primitives(), _618_alg, _617_key, (_624_head).dtor_msgID());
    _627_valueOrError16 = _out22;
    if ((_627_valueOrError16).IsFailure(StructuredEncryptionUtil_Compile.Key._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_627_valueOrError16).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(StructuredEncryptionUtil_Compile.Key._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _626_commitKey = (_627_valueOrError16).Extract(StructuredEncryptionUtil_Compile.Key._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _628_headerSerialized;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _629_valueOrError17 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _629_valueOrError17 = StructuredEncryptionHeader_Compile.__default.Serialize((config).dtor_primitives(), _618_alg, _626_commitKey, _624_head);
    if ((_629_valueOrError17).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_629_valueOrError17).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _628_headerSerialized = (_629_valueOrError17).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _630_headerAttribute;
    _630_headerAttribute = StructuredEncryptionUtil_Compile.__default.ValueToData(_628_headerSerialized, StructuredEncryptionUtil_Compile.__default.BYTES__TYPE__ID());
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _631_valueOrError18 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _631_valueOrError18 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((_613_canonData).dtor_encFields__c()).length())).compareTo(dafny.DafnyEuclidean.EuclideanDivision(StandardLibrary_mUInt_Compile.__default.UINT32__LIMIT(), java.math.BigInteger.valueOf(3L))) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Too many encrypted fields")));
    if ((_631_valueOrError18).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_631_valueOrError18).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _632_encryptedItems;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _633_valueOrError19 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out23;
    _out23 = StructuredEncryptionCrypt_Compile.__default.Encrypt((config).dtor_primitives(), _618_alg, _617_key, _624_head, (_613_canonData).dtor_encFields__c(), (_613_canonData).dtor_data__c());
    _633_valueOrError19 = _out23;
    if ((_633_valueOrError19).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_633_valueOrError19).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _632_encryptedItems = (_633_valueOrError19).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _634_result;
    _634_result = ((dafny.Function3<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>)(_635_plainRecord, _636_input, _637_encryptedItems) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _coll21 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends Character> _compr_21_boxed0 : ((_635_plainRecord).keySet()).Elements()) {
        dafny.DafnySequence<? extends Character> _compr_21 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_21_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _638_k = (dafny.DafnySequence<? extends Character>)_compr_21;
          if (StructuredEncryptionUtil_Compile.__default.ValidString(_638_k)) {
            if (((_635_plainRecord).keySet()).<dafny.DafnySequence<? extends Character>>contains(_638_k)) {
              _coll21.put(_638_k,((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>Let(StructuredEncryptionPaths_Compile.__default.SimpleCanon((_636_input).dtor_tableName(), _638_k), boxed26 -> {
                dafny.DafnySequence<? extends java.lang.Byte> _pat_let13_0 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(boxed26));
                return ((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>Let(_pat_let13_0, boxed27 -> {
                  dafny.DafnySequence<? extends java.lang.Byte> _639_c = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(boxed27));
                  return (((_637_encryptedItems).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_639_c)) ? (((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_637_encryptedItems).get(_639_c)))) : (((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_635_plainRecord).get(_638_k)))));
                }
                )));
              }
              ))));
            }
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>(_coll21);
    })).apply()).apply(_607_plainRecord, input, _632_encryptedItems);
    StructuredEncryptionFooter_Compile.Footer _640_footer;
    Wrappers_Compile.Result<StructuredEncryptionFooter_Compile.Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _641_valueOrError20 = Wrappers_Compile.Result.<StructuredEncryptionFooter_Compile.Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(StructuredEncryptionFooter_Compile.Footer.Default());
    Wrappers_Compile.Result<StructuredEncryptionFooter_Compile.Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out24;
    _out24 = StructuredEncryptionFooter_Compile.__default.CreateFooter((config).dtor_primitives(), _615_mat, (_613_canonData).dtor_signedFields__c(), (_613_canonData).dtor_encFields__c(), _632_encryptedItems, (_613_canonData).dtor_data__c(), _628_headerSerialized);
    _641_valueOrError20 = _out24;
    if ((_641_valueOrError20).IsFailure(StructuredEncryptionFooter_Compile.Footer._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_641_valueOrError20).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(StructuredEncryptionFooter_Compile.Footer._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _640_footer = (_641_valueOrError20).Extract(StructuredEncryptionFooter_Compile.Footer._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _642_footerAttribute;
    _642_footerAttribute = (_640_footer).makeTerminal();
    _634_result = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>update(_634_result, StructuredEncryptionUtil_Compile.__default.HeaderField(), _630_headerAttribute);
    _634_result = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>update(_634_result, StructuredEncryptionUtil_Compile.__default.FooterField(), _642_footerAttribute);
    Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo _643_headerAlgorithmSuite;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _644_valueOrError21 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out25;
    _out25 = (_624_head).GetAlgorithmSuite((config).dtor_materialProviders());
    _644_valueOrError21 = _out25;
    if ((_644_valueOrError21).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      output = (_644_valueOrError21).<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor());
      return output;
    }
    _643_headerAlgorithmSuite = (_644_valueOrError21).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader _645_parsedHeader;
    _645_parsedHeader = Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader.create((_613_canonData).dtor_cryptoSchema(), ((_643_headerAlgorithmSuite).dtor_id()).dtor_DBE(), (_624_head).dtor_dataKeys(), (_624_head).dtor_encContext());
    Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput _646_encryptOutput;
    _646_encryptOutput = Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_DataMap(_634_result), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal>>create_None()), _645_parsedHeader);
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(_646_encryptOutput);
    return output;
  }
  public static dafny.DafnySequence<? extends Character> SafeDecode(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _647_x = UTF8.__default.Decode(data);
    if ((_647_x).is_Success()) {
      return (_647_x).dtor_value();
    } else {
      return dafny.DafnySequence.asString("[corrupt value]");
    }
  }
  public static dafny.DafnySequence<? extends Character> DescribeMismatch(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> inputFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> inputContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> headContext)
  {
    dafny.DafnySequence<? extends Character> _648___accumulator = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((inputFields).length())).signum() == 0) {
        return dafny.DafnySequence.<Character>concatenate(_648___accumulator, dafny.DafnySequence.asString(""));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _649_key = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((inputFields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
        if (((headContext).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_649_key)) && (!(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((headContext).get(_649_key)))).equals(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((inputContext).get(_649_key)))))) {
          dafny.DafnySequence<? extends Character> _650_keyStr = __default.SafeDecode(_649_key);
          dafny.DafnySequence<? extends Character> _651_headStr = __default.SafeDecode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((headContext).get(_649_key))));
          dafny.DafnySequence<? extends Character> _652_inputStr = __default.SafeDecode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((inputContext).get(_649_key))));
          dafny.DafnySequence<? extends Character> _653_msg = dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("input context for "), _650_keyStr), dafny.DafnySequence.asString(" was ")), _652_inputStr), dafny.DafnySequence.asString(" but stored context had ")), _651_headStr), dafny.DafnySequence.asString("\n"));
          _648___accumulator = dafny.DafnySequence.<Character>concatenate(_648___accumulator, _653_msg);
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in73 = (inputFields).drop(java.math.BigInteger.ONE);
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in74 = inputContext;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in75 = headContext;
          inputFields = _in73;
          inputContext = _in74;
          headContext = _in75;
          continue TAIL_CALL_START;
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in76 = (inputFields).drop(java.math.BigInteger.ONE);
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in77 = inputContext;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in78 = headContext;
          inputFields = _in76;
          inputContext = _in77;
          headContext = _in78;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> DetectMismatch(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> inputContext, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> headContext)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _654_inputFields = Sets.__default.<java.lang.Byte>SetToOrderedSequence2(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (inputContext).keySet(), StructuredEncryptionUtil_Compile.__default::ByteLess);
    dafny.DafnySequence<? extends Character> _655_str = __default.DescribeMismatch(_654_inputFields, inputContext, headContext);
    if ((java.math.BigInteger.valueOf((_655_str).length())).signum() == 0) {
      return Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Pass();
    } else {
      return Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Fail(StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Encryption Context Mismatch\n"), _655_str)));
    }
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> DecryptStructure(Config config, Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _656_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _656_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((input).dtor_authenticateSchema()).dtor_content()).is_SchemaMap(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Authenticate Schema must be a SchemaMap")));
      if ((_656_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_656_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _657_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _657_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.AuthSchemaIsFlat((((input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema must be flat.")));
      if ((_657_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_657_valueOrError1).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _658_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _658_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput, Boolean>)(_659_input) -> dafny.Helpers.Quantifier(((((_659_input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()).keySet().Elements(), true, ((_forall_var_10_boxed0) -> {
        dafny.DafnySequence<? extends Character> _forall_var_10 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_10_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _660_k = (dafny.DafnySequence<? extends Character>)_forall_var_10;
          return !(((((_659_input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()).<dafny.DafnySequence<? extends Character>>contains(_660_k)) || (StructuredEncryptionUtil_Compile.__default.ValidString(_660_k));
        } else {
          return true;
        }
      }))).apply(input), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema has bad field name.")));
      if ((_658_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_658_valueOrError2).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _661_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _661_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput, Boolean>)(_662_input) -> dafny.Helpers.Quantifier(((((_662_input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()).keySet().Elements(), true, ((_forall_var_11_boxed0) -> {
        dafny.DafnySequence<? extends Character> _forall_var_11 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_11_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _663_k = (dafny.DafnySequence<? extends Character>)_forall_var_11;
          return !((((((_662_input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()).<dafny.DafnySequence<? extends Character>>contains(_663_k)) && ((__default.ReservedAuthMap()).<dafny.DafnySequence<? extends Character>>contains(_663_k))) || (java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema)(java.lang.Object)(((((_662_input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()).get(_663_k))), ((Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema)(java.lang.Object)((__default.ReservedAuthMap()).get(_663_k)))));
        } else {
          return true;
        }
      }))).apply(input), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Reserved fields in Schema must be DO_NOT_SIGN.")));
      if ((_661_valueOrError3).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_661_valueOrError3).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> _664_authSchema;
      _664_authSchema = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>merge((((input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap(), __default.ReservedAuthMap());
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _665_valueOrError4 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _665_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((input).dtor_encryptedStructure()).dtor_content()).is_DataMap(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Input structure must be a DataMap")));
      if ((_665_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_665_valueOrError4).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _666_valueOrError5 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _666_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.DataMapIsFlat((((input).dtor_encryptedStructure()).dtor_content()).dtor_DataMap()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Input DataMap must be flat.")));
      if ((_666_valueOrError5).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_666_valueOrError5).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _667_valueOrError6 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _667_valueOrError6 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((_664_authSchema).keySet()).equals(((((input).dtor_encryptedStructure()).dtor_content()).dtor_DataMap()).keySet()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Authenticate schema must match encrypted structure exactly.")));
      if ((_667_valueOrError6).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_667_valueOrError6).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _668_encRecord;
      _668_encRecord = (((input).dtor_encryptedStructure()).dtor_content()).dtor_DataMap();
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _669_valueOrError7 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _669_valueOrError7 = __default.NeedBinary(_668_encRecord, StructuredEncryptionUtil_Compile.__default.HeaderField());
      if ((_669_valueOrError7).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_669_valueOrError7).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _670_valueOrError8 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _670_valueOrError8 = __default.NeedBinary(_668_encRecord, StructuredEncryptionUtil_Compile.__default.FooterField());
      if ((_670_valueOrError8).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_670_valueOrError8).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _671_valueOrError9 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _671_valueOrError9 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput, Boolean>)(_672_input) -> dafny.Helpers.Quantifier(((((_672_input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()).keySet().Elements(), false, ((_exists_var_2_boxed0) -> {
        dafny.DafnySequence<? extends Character> _exists_var_2 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_exists_var_2_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _673_x = (dafny.DafnySequence<? extends Character>)_exists_var_2;
          return (((((_672_input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()).<dafny.DafnySequence<? extends Character>>contains(_673_x)) && (java.util.Objects.equals(((((Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema)(java.lang.Object)(((((_672_input).dtor_authenticateSchema()).dtor_content()).dtor_SchemaMap()).get(_673_x)))).dtor_content()).dtor_Action(), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.create_SIGN()));
        } else {
          return false;
        }
      }))).apply(input), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("At least one Authenticate Action must be SIGN")));
      if ((_671_valueOrError9).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_671_valueOrError9).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      dafny.DafnySequence<? extends java.lang.Byte> _674_headerSerialized;
      _674_headerSerialized = (((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_668_encRecord).get(StructuredEncryptionUtil_Compile.__default.HeaderField())))).dtor_content()).dtor_Terminal()).dtor_value();
      dafny.DafnySequence<? extends java.lang.Byte> _675_footerSerialized;
      _675_footerSerialized = (((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_668_encRecord).get(StructuredEncryptionUtil_Compile.__default.FooterField())))).dtor_content()).dtor_Terminal()).dtor_value();
      StructuredEncryptionHeader_Compile.PartialHeader _676_head;
      Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _677_valueOrError10 = (Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
      _677_valueOrError10 = StructuredEncryptionHeader_Compile.__default.PartialDeserialize(_674_headerSerialized);
      if ((_677_valueOrError10).IsFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_677_valueOrError10).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _676_head = (_677_valueOrError10).Extract(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo _678_headerAlgorithmSuite;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _679_valueOrError11 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out26;
      _out26 = (_676_head).GetAlgorithmSuite((config).dtor_materialProviders());
      _679_valueOrError11 = _out26;
      if ((_679_valueOrError11).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_679_valueOrError11).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _678_headerAlgorithmSuite = (_679_valueOrError11).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _680_matR;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out27;
      _out27 = ((input).dtor_cmm()).DecryptMaterials(Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsInput.create((_678_headerAlgorithmSuite).dtor_id(), __default.DBE__COMMITMENT__POLICY(), (_676_head).dtor_dataKeys(), (_676_head).dtor_encContext(), (input).dtor_encryptionContext()));
      _680_matR = _out27;
      Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput _681_matOutput;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _682_valueOrError12 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
      _682_valueOrError12 = (_680_matR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_683_e_boxed0) -> {
        Dafny.Aws.Cryptography.MaterialProviders.Types.Error _683_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_683_e_boxed0));
        return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyMaterialProviders(_683_e);
      }));
      if ((_682_valueOrError12).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_682_valueOrError12).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _681_matOutput = (_682_valueOrError12).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptMaterialsOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptionMaterials _684_mat;
      _684_mat = (_681_matOutput).dtor_decryptionMaterials();
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _685_valueOrError13 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _685_valueOrError13 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionHeader_Compile.__default.ValidEncryptionContext((_684_mat).dtor_encryptionContext()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad encryption context")));
      if ((_685_valueOrError13).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_685_valueOrError13).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _686_valueOrError14 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _686_valueOrError14 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Materials_Compile.__default.DecryptionMaterialsWithPlaintextDataKey(_684_mat), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Encryption material has no key")));
      if ((_686_valueOrError14).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_686_valueOrError14).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _687_valueOrError15 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _687_valueOrError15 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidSuite((_684_mat).dtor_algorithmSuite()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Algorithm Suite")));
      if ((_687_valueOrError15).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_687_valueOrError15).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo _688_postCMMAlg;
      _688_postCMMAlg = (_684_mat).dtor_algorithmSuite();
      dafny.DafnySequence<? extends java.lang.Byte> _689_key;
      _689_key = ((_684_mat).dtor_plaintextDataKey()).dtor_value();
      dafny.DafnySequence<? extends java.lang.Byte> _690_commitKey;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _691_valueOrError16 = (Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out28;
      _out28 = StructuredEncryptionCrypt_Compile.__default.GetCommitKey((config).dtor_primitives(), _688_postCMMAlg, _689_key, (_676_head).dtor_msgID());
      _691_valueOrError16 = _out28;
      if ((_691_valueOrError16).IsFailure(StructuredEncryptionUtil_Compile.Key._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_691_valueOrError16).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(StructuredEncryptionUtil_Compile.Key._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _690_commitKey = (_691_valueOrError16).Extract(StructuredEncryptionUtil_Compile.Key._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      boolean _692_ok;
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _693_valueOrError17 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(false);
      _693_valueOrError17 = (_676_head).verifyCommitment((config).dtor_primitives(), _688_postCMMAlg, _690_commitKey, _674_headerSerialized);
      if ((_693_valueOrError17).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_693_valueOrError17).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _692_ok = (_693_valueOrError17).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _694_valueOrError18 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _694_valueOrError18 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidString((input).dtor_tableName()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad Table Name")));
      if ((_694_valueOrError18).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_694_valueOrError18).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      DecryptCanonData _695_canonData;
      Wrappers_Compile.Result<DecryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _696_valueOrError19 = (Wrappers_Compile.Result<DecryptCanonData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
      _696_valueOrError19 = __default.CanonizeForDecrypt(AwsCryptographyStructuredEncryptionOperations_Compile.CanonizeForDecryptInput.create((input).dtor_tableName(), _668_encRecord, _664_authSchema, (_676_head).dtor_legend()));
      if ((_696_valueOrError19).IsFailure(DecryptCanon._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_696_valueOrError19).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(DecryptCanon._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _695_canonData = (_696_valueOrError19).Extract(DecryptCanon._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      StructuredEncryptionFooter_Compile.Footer _697_footer;
      Wrappers_Compile.Result<StructuredEncryptionFooter_Compile.Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _698_valueOrError20 = Wrappers_Compile.Result.<StructuredEncryptionFooter_Compile.Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(StructuredEncryptionFooter_Compile.Footer.Default());
      _698_valueOrError20 = StructuredEncryptionFooter_Compile.__default.DeserializeFooter(_675_footerSerialized, ((_688_postCMMAlg).dtor_signature()).is_ECDSA());
      if ((_698_valueOrError20).IsFailure(StructuredEncryptionFooter_Compile.Footer._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_698_valueOrError20).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(StructuredEncryptionFooter_Compile.Footer._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _697_footer = (_698_valueOrError20).Extract(StructuredEncryptionFooter_Compile.Footer._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      boolean _699___v0;
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _700_valueOrError21 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(false);
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out29;
      _out29 = (_697_footer).validate((config).dtor_primitives(), _684_mat, (_676_head).dtor_dataKeys(), (_695_canonData).dtor_signedFields__c(), (_695_canonData).dtor_encFields__c(), dafny.DafnyMap.fromElements(), (_695_canonData).dtor_data__c(), _674_headerSerialized);
      _700_valueOrError21 = _out29;
      if ((_700_valueOrError21).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_700_valueOrError21).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _699___v0 = (_700_valueOrError21).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _701_decryptedItems;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _702_valueOrError22 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty());
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out30;
      _out30 = StructuredEncryptionCrypt_Compile.__default.Decrypt((config).dtor_primitives(), _688_postCMMAlg, _689_key, _676_head, (_695_canonData).dtor_encFields__c(), (_695_canonData).dtor_data__c());
      _702_valueOrError22 = _out30;
      if ((_702_valueOrError22).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        output = (_702_valueOrError22).<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor());
        return output;
      }
      _701_decryptedItems = (_702_valueOrError22).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _703_result;
      _703_result = ((dafny.Function3<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>)(_704_encRecord, _705_input, _706_decryptedItems) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>)(() -> {
        java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _coll22 = new java.util.HashMap<>();
        for (dafny.DafnySequence<? extends Character> _compr_22_boxed0 : ((_704_encRecord).keySet()).Elements()) {
          dafny.DafnySequence<? extends Character> _compr_22 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_22_boxed0));
          if (true) {
            dafny.DafnySequence<? extends Character> _707_k = (dafny.DafnySequence<? extends Character>)_compr_22;
            if (((_704_encRecord).keySet()).<dafny.DafnySequence<? extends Character>>contains(_707_k)) {
              _coll22.put(_707_k,((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>Let(StructuredEncryptionPaths_Compile.__default.SimpleCanon((_705_input).dtor_tableName(), _707_k), boxed28 -> {
                dafny.DafnySequence<? extends java.lang.Byte> _pat_let14_0 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(boxed28));
                return ((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>Let(_pat_let14_0, boxed29 -> {
                  dafny.DafnySequence<? extends java.lang.Byte> _708_c = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(boxed29));
                  return (((_706_decryptedItems).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_708_c)) ? (((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_706_decryptedItems).get(_708_c)))) : (((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_704_encRecord).get(_707_k)))));
                }
                )));
              }
              ))));
            }
          }
        }
        return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>(_coll22);
      })).apply()).apply(_668_encRecord, input, _701_decryptedItems);
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _709_smallResult;
      _709_smallResult = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>subtract(_703_result, dafny.DafnySet.of(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.FooterField()));
      Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader _710_parsedHeader;
      _710_parsedHeader = Dafny.Aws.Cryptography.StructuredEncryption.Types.ParsedHeader.create((_695_canonData).dtor_cryptoSchema(), ((_678_headerAlgorithmSuite).dtor_id()).dtor_DBE(), (_676_head).dtor_dataKeys(), (_676_head).dtor_encContext());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput _711_decryptOutput;
      _711_decryptOutput = Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_DataMap(_709_smallResult), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal>>create_None()), _710_parsedHeader);
      output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(_711_decryptOutput);
    }
    return output;
  }
  public static Dafny.Aws.Cryptography.MaterialProviders.Types.CommitmentPolicy DBE__COMMITMENT__POLICY()
  {
    return Dafny.Aws.Cryptography.MaterialProviders.Types.CommitmentPolicy.create_DBE(Dafny.Aws.Cryptography.MaterialProviders.Types.DBECommitmentPolicy.create());
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> ReservedAuthMap()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(StructuredEncryptionUtil_Compile.__default.HeaderField(), StructuredEncryptionUtil_Compile.__default.DoNotSign()), new dafny.Tuple2(StructuredEncryptionUtil_Compile.__default.FooterField(), StructuredEncryptionUtil_Compile.__default.DoNotSign()));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "AwsCryptographyStructuredEncryptionOperations_Compile._default";
  }
}
