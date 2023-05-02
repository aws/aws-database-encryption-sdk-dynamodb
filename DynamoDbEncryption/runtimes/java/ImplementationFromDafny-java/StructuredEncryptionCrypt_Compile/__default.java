// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionCrypt_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> FieldKey(dafny.DafnySequence<? extends java.lang.Byte> HKDFOutput, int offset)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _502_keyR = AesKdfCtr.__default.AesKdfCtrStream(__default.FieldKeyNonce((int)  ((offset) * (3))), HKDFOutput, ((StructuredEncryptionUtil_Compile.__default.KeySize()).add(StructuredEncryptionUtil_Compile.__default.NonceSize())).intValue());
    return (_502_keyR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.OpaqueError._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_503_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _503_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_503_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_503_e);
    }));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> FieldKeyNonce(int offset) {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("AwsDbeField")), dafny.DafnySequence.of(((StructuredEncryptionUtil_Compile.__default.KeySize()).add(StructuredEncryptionUtil_Compile.__default.NonceSize())).byteValue())), StandardLibrary_mUInt_Compile.__default.UInt32ToSeq(offset));
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetCommitKey(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends java.lang.Byte> msgID)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = (Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _504_commitKey;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _out9;
    _out9 = (client).Hkdf(Dafny.Aws.Cryptography.Primitives.Types.HkdfInput.create((((alg).dtor_commitment()).dtor_HKDF()).dtor_hmac(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(), key, dafny.DafnySequence.<java.lang.Byte>concatenate(__default.LABEL__COMMITMENT__KEY(), msgID), (((alg).dtor_commitment()).dtor_HKDF()).dtor_outputKeyLength()));
    _504_commitKey = _out9;
    ret = (_504_commitKey).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_505_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _505_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_505_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_505_e);
    }));
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> Encrypt(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> key, StructuredEncryptionHeader_Compile.PartialHeader head, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> fieldNames, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out10;
      _out10 = __default.Crypt(StructuredEncryptionCrypt_Compile.EncryptionSelector.create_DoEncrypt(), client, alg, key, head, fieldNames, data);
      ret = _out10;
    }
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> Decrypt(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> key, StructuredEncryptionHeader_Compile.PartialHeader head, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> fieldNames, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out11;
      _out11 = __default.Crypt(StructuredEncryptionCrypt_Compile.EncryptionSelector.create_DoDecrypt(), client, alg, key, head, fieldNames, data);
      ret = _out11;
    }
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> Crypt(EncryptionSelector mode, Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> key, StructuredEncryptionHeader_Compile.PartialHeader head, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> fieldNames, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _506_fieldRootKeyR;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _out12;
    _out12 = (client).Hkdf(Dafny.Aws.Cryptography.Primitives.Types.HkdfInput.create((((alg).dtor_kdf()).dtor_HKDF()).dtor_hmac(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(), key, dafny.DafnySequence.<java.lang.Byte>concatenate(__default.LABEL__ENCRYPTION__KEY(), (head).dtor_msgID()), (((alg).dtor_kdf()).dtor_HKDF()).dtor_outputKeyLength()));
    _506_fieldRootKeyR = _out12;
    dafny.DafnySequence<? extends java.lang.Byte> _507_fieldRootKey;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _508_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _508_valueOrError0 = (_506_fieldRootKeyR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_509_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _509_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_509_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_509_e);
    }));
    if ((_508_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_508_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()));
      return ret;
    }
    _507_fieldRootKey = (_508_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _510_result;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out13;
    _out13 = __default.CryptList(mode, client, alg, _507_fieldRootKey, 0, fieldNames, data, dafny.DafnyMap.fromElements());
    _510_result = _out13;
    ret = _510_result;
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> CryptList(EncryptionSelector mode, Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> fieldRootKey, int offset, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> fieldNames, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> input, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> output)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty());
    if ((java.math.BigInteger.valueOf((fieldNames).length())).signum() == 0) {
      ret = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(output);
      return ret;
    }
    Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _511_data = (Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)null;
    if (java.util.Objects.equals(mode, StructuredEncryptionCrypt_Compile.EncryptionSelector.create_DoEncrypt())) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _512_valueOrError0 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out14;
      _out14 = __default.EncryptTerminal(client, alg, fieldRootKey, offset, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fieldNames).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), ((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((input).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fieldNames).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))).dtor_content()).dtor_Terminal());
      _512_valueOrError0 = _out14;
      if ((_512_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        ret = (_512_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()));
        return ret;
      }
      _511_data = (_512_valueOrError0).Extract(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    } else {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _513_valueOrError1 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out15;
      _out15 = __default.DecryptTerminal(client, alg, fieldRootKey, offset, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fieldNames).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), ((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((input).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fieldNames).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))).dtor_content()).dtor_Terminal());
      _513_valueOrError1 = _out15;
      if ((_513_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        ret = (_513_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), StructuredEncryptionUtil_Compile.StructuredDataTerminalType._typeDescriptor()));
        return ret;
      }
      _511_data = (_513_valueOrError1).Extract(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    }
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _514_result;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out16;
    _out16 = __default.CryptList(mode, client, alg, fieldRootKey, (int)  ((offset) + (1)), (fieldNames).drop(java.math.BigInteger.ONE), input, dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>update(output, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((fieldNames).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), _511_data));
    _514_result = _out16;
    ret = _514_result;
    return ret;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> EncryptTerminal(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> fieldRootKey, int offset, dafny.DafnySequence<? extends java.lang.Byte> path, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal data)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    dafny.DafnySequence<? extends java.lang.Byte> _515_fieldKey;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _516_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _516_valueOrError0 = __default.FieldKey(fieldRootKey, offset);
    if ((_516_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_516_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor());
      return ret;
    }
    _515_fieldKey = (_516_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _517_cipherkey;
    _517_cipherkey = (_515_fieldKey).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((StructuredEncryptionUtil_Compile.__default.KeySize())));
    dafny.DafnySequence<? extends java.lang.Byte> _518_nonce;
    _518_nonce = (_515_fieldKey).drop(StructuredEncryptionUtil_Compile.__default.KeySize());
    dafny.DafnySequence<? extends java.lang.Byte> _519_value;
    _519_value = (data).dtor_value();
    Dafny.Aws.Cryptography.Primitives.Types.AESEncryptInput _520_encInput;
    _520_encInput = Dafny.Aws.Cryptography.Primitives.Types.AESEncryptInput.create(((alg).dtor_encrypt()).dtor_AES__GCM(), _518_nonce, _517_cipherkey, _519_value, path);
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput, Dafny.Aws.Cryptography.Primitives.Types.Error> _521_encOutR;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput, Dafny.Aws.Cryptography.Primitives.Types.Error> _out17;
    _out17 = (client).AESEncrypt(_520_encInput);
    _521_encOutR = _out17;
    Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput _522_encOut;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _523_valueOrError1 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput.Default());
    _523_valueOrError1 = (_521_encOutR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput._typeDescriptor(), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_524_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _524_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_524_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_524_e);
    }));
    if ((_523_valueOrError1).IsFailure(Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_523_valueOrError1).<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>PropagateFailure(Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor());
      return ret;
    }
    _522_encOut = (_523_valueOrError1).Extract(Dafny.Aws.Cryptography.Primitives.Types.AESEncryptOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _525_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _525_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf(((_522_encOut).dtor_authTag()).length()), StructuredEncryptionUtil_Compile.__default.AuthTagSize()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Auth Tag Wrong Size.")));
    if ((_525_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_525_valueOrError2).<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor());
      return ret;
    }
    ret = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(StructuredEncryptionUtil_Compile.__default.ValueToData(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate((data).dtor_typeId(), (_522_encOut).dtor_cipherText()), (_522_encOut).dtor_authTag()), StructuredEncryptionUtil_Compile.__default.BYTES__TYPE__ID()));
    return ret;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> DecryptTerminal(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> fieldRootKey, int offset, dafny.DafnySequence<? extends java.lang.Byte> path, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal data)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    dafny.DafnySequence<? extends java.lang.Byte> _526_dataKey;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _527_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _527_valueOrError0 = __default.FieldKey(fieldRootKey, offset);
    if ((_527_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_527_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor());
      return ret;
    }
    _526_dataKey = (_527_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _528_encryptionKey;
    _528_encryptionKey = (_526_dataKey).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((StructuredEncryptionUtil_Compile.__default.KeySize())));
    dafny.DafnySequence<? extends java.lang.Byte> _529_nonce;
    _529_nonce = (_526_dataKey).drop(StructuredEncryptionUtil_Compile.__default.KeySize());
    dafny.DafnySequence<? extends java.lang.Byte> _530_value;
    _530_value = (data).dtor_value();
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _531_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _531_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((StructuredEncryptionUtil_Compile.__default.AuthTagSize()).add(java.math.BigInteger.valueOf(2L))).compareTo(java.math.BigInteger.valueOf((_530_value).length())) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("cipherTxt too short.")));
    if ((_531_valueOrError1).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_531_valueOrError1).<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor());
      return ret;
    }
    Dafny.Aws.Cryptography.Primitives.Types.AESDecryptInput _532_decInput;
    _532_decInput = Dafny.Aws.Cryptography.Primitives.Types.AESDecryptInput.create(((alg).dtor_encrypt()).dtor_AES__GCM(), _528_encryptionKey, (_530_value).subsequence(dafny.Helpers.toInt((StructuredEncryptionUtil_Compile.__default.TYPEID__LEN())), dafny.Helpers.toInt(((java.math.BigInteger.valueOf((_530_value).length())).subtract(StructuredEncryptionUtil_Compile.__default.AuthTagSize())))), (_530_value).drop((java.math.BigInteger.valueOf((_530_value).length())).subtract(StructuredEncryptionUtil_Compile.__default.AuthTagSize())), _529_nonce, path);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _533_decOutR;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _out18;
    _out18 = (client).AESDecrypt(_532_decInput);
    _533_decOutR = _out18;
    dafny.DafnySequence<? extends java.lang.Byte> _534_decOut;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _535_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _535_valueOrError2 = (_533_decOutR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_536_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _536_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_536_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_536_e);
    }));
    if ((_535_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_535_valueOrError2).<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor());
      return ret;
    }
    _534_decOut = (_535_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    ret = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(StructuredEncryptionUtil_Compile.__default.ValueToData(_534_decOut, (_530_value).take(StructuredEncryptionUtil_Compile.__default.TYPEID__LEN())));
    return ret;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> LABEL__COMMITMENT__KEY()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("AWS_DBE_COMMIT_KEY"));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> LABEL__ENCRYPTION__KEY()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("AWS_DBE_DERIVE_KEY"));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionCrypt_Compile._default";
  }
}
