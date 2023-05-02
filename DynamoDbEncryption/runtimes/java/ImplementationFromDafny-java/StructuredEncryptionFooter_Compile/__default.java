// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionFooter_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetCanonicalType(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal value, boolean isEncrypted)
  {
    if (isEncrypted) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _464_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf(((value).dtor_value()).length())) <= 0) && ((java.math.BigInteger.valueOf(((value).dtor_value()).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad length.")));
      if ((_464_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_464_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt64ToSeq(((java.math.BigInteger.valueOf(((value).dtor_value()).length())).subtract(java.math.BigInteger.valueOf(2L))).longValue()), UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("ENCRYPTED"))));
      }
    } else {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _465_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((value).dtor_value()).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad length.")));
      if ((_465_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_465_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt64ToSeq(((value).dtor_value()).cardinalityInt()), UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("PLAINTEXT"))), (value).dtor_typeId()));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetCanonicalEncryptedField(dafny.DafnySequence<? extends java.lang.Byte> fieldName, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal value)
  {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _466_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf(((value).dtor_value()).length())) <= 0) && ((java.math.BigInteger.valueOf(((value).dtor_value()).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad length.")));
    if ((_466_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_466_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(fieldName, StandardLibrary_mUInt_Compile.__default.UInt64ToSeq(((java.math.BigInteger.valueOf(((value).dtor_value()).length())).subtract(java.math.BigInteger.valueOf(2L))).longValue())), UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("ENCRYPTED"))), (value).dtor_value()));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetCanonicalPlaintextField(dafny.DafnySequence<? extends java.lang.Byte> fieldName, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal value)
  {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _467_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((value).dtor_value()).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad length.")));
    if ((_467_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_467_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(fieldName, StandardLibrary_mUInt_Compile.__default.UInt64ToSeq(((value).dtor_value()).cardinalityInt())), UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("PLAINTEXT"))), (value).dtor_typeId()), (value).dtor_value()));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetCanonicalItem(dafny.DafnySequence<? extends java.lang.Byte> fieldName, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData value, boolean isEncrypted)
  {
    if (isEncrypted) {
      return __default.GetCanonicalEncryptedField(fieldName, ((value).dtor_content()).dtor_Terminal());
    } else {
      return __default.GetCanonicalPlaintextField(fieldName, ((value).dtor_content()).dtor_Terminal());
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> CanonContent(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> fields, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> encFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> encData, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> allData, dafny.DafnySequence<? extends java.lang.Byte> canonized)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((fields).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(canonized);
      } else {
        Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _468_data = (((encData).<dafny.DafnySequence<? extends java.lang.Byte>>contains(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) ? (((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((encData).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))) : (((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((allData).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _469_valueOrError0 = __default.GetCanonicalItem(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), _468_data, (encFields).contains(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        if ((_469_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_469_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _470_newPart = (_469_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in54 = (fields).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in55 = encFields;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _in56 = encData;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _in57 = allData;
          dafny.DafnySequence<? extends java.lang.Byte> _in58 = dafny.DafnySequence.<java.lang.Byte>concatenate(canonized, _470_newPart);
          fields = _in54;
          encFields = _in55;
          encData = _in56;
          allData = _in57;
          canonized = _in58;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> CanonRecord(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> signedFields, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> encFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> encData, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> allData, dafny.DafnySequence<? extends java.lang.Byte> header, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> enc)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _471_valueOrError0 = __default.CanonContent(signedFields, encFields, encData, allData, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    if ((_471_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_471_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _472_canon = (_471_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends java.lang.Byte> _473_AAD = StructuredEncryptionHeader_Compile.__default.SerializeContext(enc);
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _474_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_473_AAD).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("AAD too long.")));
      if ((_474_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_474_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _475_len = StandardLibrary_mUInt_Compile.__default.UInt64ToSeq((_473_AAD).cardinalityInt());
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(header, _475_len), _473_AAD), _472_canon));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> CanonHash(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> signedFields, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> encFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> encData, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> allData, dafny.DafnySequence<? extends java.lang.Byte> header, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> enc)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    dafny.DafnySequence<? extends java.lang.Byte> _476_data;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _477_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _477_valueOrError0 = __default.CanonRecord(signedFields, encFields, encData, allData, header, enc);
    if ((_477_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_477_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      return ret;
    }
    _476_data = (_477_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _478_resultR;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _out6;
    _out6 = Digest_Compile.__default.Digest(Dafny.Aws.Cryptography.Primitives.Types.DigestInput.create(Dafny.Aws.Cryptography.Primitives.Types.DigestAlgorithm.create_SHA__384(), _476_data));
    _478_resultR = _out6;
    ret = (_478_resultR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_479_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _479_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_479_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_479_e);
    }));
    return ret;
  }
  public static Wrappers_Compile.Result<Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> CreateFooter(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptionMaterials mat, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> signedFields, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> encFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> encData, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> allData, dafny.DafnySequence<? extends java.lang.Byte> header)
  {
    Wrappers_Compile.Result<Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = Wrappers_Compile.Result.<Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(Footer.Default());
    if(true) {
      dafny.DafnySequence<? extends java.lang.Byte> _480_canonicalHash;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _481_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out7;
      _out7 = __default.CanonHash(signedFields, encFields, encData, allData, header, (mat).dtor_encryptionContext());
      _481_valueOrError0 = _out7;
      if ((_481_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        ret = (_481_valueOrError0).<Footer>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
        return ret;
      }
      _480_canonicalHash = (_481_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _482_tags;
      _482_tags = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(RecipientTag._typeDescriptor());
      java.math.BigInteger _hi1 = java.math.BigInteger.valueOf(((mat).dtor_encryptedDataKeys()).length());
      for (java.math.BigInteger _483_i = java.math.BigInteger.ZERO; _483_i.compareTo(_hi1) < 0; _483_i = _483_i.add(java.math.BigInteger.ONE)) {
        Dafny.Aws.Cryptography.Primitives.Types.HMacInput _484_input;
        _484_input = Dafny.Aws.Cryptography.Primitives.Types.HMacInput.create((((mat).dtor_algorithmSuite()).dtor_symmetricSignature()).dtor_HMAC(), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((((mat).dtor_symmetricSigningKeys()).dtor_value()).select(dafny.Helpers.toInt((_483_i))))), _480_canonicalHash);
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _485_hashR;
        _485_hashR = (client).HMac(_484_input);
        dafny.DafnySequence<? extends java.lang.Byte> _486_hash;
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _487_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        _487_valueOrError1 = (_485_hashR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_488_e_boxed0) -> {
          Dafny.Aws.Cryptography.Primitives.Types.Error _488_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_488_e_boxed0));
          return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_488_e);
        }));
        if ((_487_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          ret = (_487_valueOrError1).<Footer>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
          return ret;
        }
        _486_hash = (_487_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _489_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
        _489_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((_486_hash).length()), java.math.BigInteger.valueOf(48L)), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad hash length")));
        if ((_489_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          ret = (_489_valueOrError2).<Footer>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
          return ret;
        }
        _482_tags = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_482_tags, dafny.DafnySequence.of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), _486_hash));
      }
      if ((((mat).dtor_algorithmSuite()).dtor_signature()).is_ECDSA()) {
        Dafny.Aws.Cryptography.Primitives.Types.ECDSASignInput _490_verInput;
        _490_verInput = Dafny.Aws.Cryptography.Primitives.Types.ECDSASignInput.create(((((mat).dtor_algorithmSuite()).dtor_signature()).dtor_ECDSA()).dtor_curve(), ((mat).dtor_signingKey()).dtor_value(), _480_canonicalHash);
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _491_sigR;
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _out8;
        _out8 = (client).ECDSASign(_490_verInput);
        _491_sigR = _out8;
        dafny.DafnySequence<? extends java.lang.Byte> _492_sig;
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _493_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        _493_valueOrError3 = (_491_sigR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_494_e_boxed0) -> {
          Dafny.Aws.Cryptography.Primitives.Types.Error _494_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_494_e_boxed0));
          return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_494_e);
        }));
        if ((_493_valueOrError3).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          ret = (_493_valueOrError3).<Footer>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
          return ret;
        }
        _492_sig = (_493_valueOrError3).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _495_valueOrError4 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
        _495_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((_492_sig).length()), __default.SignatureSize()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Signature is "), String_Compile.__default.Base10Int2String(java.math.BigInteger.valueOf((_492_sig).length()))), dafny.DafnySequence.asString(" bytes, should have been ")), String_Compile.__default.Base10Int2String(__default.SignatureSize())), dafny.DafnySequence.asString(" bytes."))));
        if ((_495_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          ret = (_495_valueOrError4).<Footer>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
          return ret;
        }
        ret = Wrappers_Compile.Result.<Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(StructuredEncryptionFooter_Compile.Footer.create(_482_tags, Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some(_492_sig)));
        return ret;
      } else {
        ret = Wrappers_Compile.Result.<Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(StructuredEncryptionFooter_Compile.Footer.create(_482_tags, Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None()));
        return ret;
      }
    }
    return ret;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeTags(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> tags) {
    dafny.DafnySequence<? extends java.lang.Byte> _496___accumulator = dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((tags).length())).signum() == 0) {
        return dafny.DafnySequence.<java.lang.Byte>concatenate(_496___accumulator, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        _496___accumulator = dafny.DafnySequence.<java.lang.Byte>concatenate(_496___accumulator, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((tags).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in59 = (tags).drop(java.math.BigInteger.ONE);
        tags = _in59;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeSig(Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> sig) {
    if ((sig).is_Some()) {
      return (sig).dtor_value();
    } else {
      return dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor());
    }
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> GatherTags(dafny.DafnySequence<? extends java.lang.Byte> data) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _497___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(RecipientTag._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((data).length())).signum() == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_497___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
      } else {
        _497___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_497___accumulator, dafny.DafnySequence.of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), (data).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((__default.RecipientTagSize())))));
        dafny.DafnySequence<? extends java.lang.Byte> _in60 = (data).drop(__default.RecipientTagSize());
        data = _in60;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> DeserializeFooter(dafny.DafnySequence<? extends java.lang.Byte> data, boolean hasSig)
  {
    if (hasSig) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _498_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (dafny.DafnyEuclidean.EuclideanModulus((java.math.BigInteger.valueOf((data).length())).subtract(__default.SignatureSize()), __default.RecipientTagSize())).signum() == 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Mangled signed footer has strange size")));
      if ((_498_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_498_valueOrError0).<Footer>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _499_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((data).length())).compareTo((__default.RecipientTagSize()).add(__default.SignatureSize())) >= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Footer too short.")));
        if ((_499_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_499_valueOrError1).<Footer>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(StructuredEncryptionFooter_Compile.Footer.create(__default.GatherTags((data).take((java.math.BigInteger.valueOf((data).length())).subtract(__default.SignatureSize()))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some((data).drop((java.math.BigInteger.valueOf((data).length())).subtract(__default.SignatureSize())))));
        }
      }
    } else {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _500_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (dafny.DafnyEuclidean.EuclideanModulus(java.math.BigInteger.valueOf((data).length()), __default.RecipientTagSize())).signum() == 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Mangled unsigned footer has strange size")));
      if ((_500_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_500_valueOrError2).<Footer>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _501_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((data).length())).compareTo(__default.RecipientTagSize()) >= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Footer too short.")));
        if ((_501_valueOrError3).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_501_valueOrError3).<Footer>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Footer._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<Footer, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(StructuredEncryptionFooter_Compile.Footer.create(__default.GatherTags(data), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None()));
        }
      }
    }
  }
  public static java.math.BigInteger RecipientTagSize()
  {
    return java.math.BigInteger.valueOf(48L);
  }
  public static java.math.BigInteger SignatureSize()
  {
    return java.math.BigInteger.valueOf(103L);
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionFooter_Compile._default";
  }
}
