// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionUtil_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean ValidSuite(Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg) {
    return (((alg).dtor_id()).is_DBE()) && (AlgorithmSuites_Compile.__default.DBEAlgorithmSuite_q(alg));
  }
  public static boolean ValidString(dafny.DafnySequence<? extends Character> x) {
    return ((java.math.BigInteger.valueOf((x).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0) && ((UTF8.__default.Encode(x)).is_Success());
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.Error E(dafny.DafnySequence<? extends Character> s) {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_StructuredEncryptionException(s);
  }
  public static byte ConstantTimeCompare(dafny.DafnySequence<? extends java.lang.Byte> a, dafny.DafnySequence<? extends java.lang.Byte> b, byte acc)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((a).length())).signum() == 0) {
        return acc;
      } else {
        byte _287_x = (byte) (byte)  ((byte)(((((byte)(java.lang.Object)((a).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) ^ ((((byte)(java.lang.Object)((b).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))));
        dafny.DafnySequence<? extends java.lang.Byte> _in30 = (a).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends java.lang.Byte> _in31 = (b).drop(java.math.BigInteger.ONE);
        byte _in32 = (byte) (byte)  ((byte)((_287_x) | (acc)));
        a = _in30;
        b = _in31;
        acc = _in32;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean ConstantTimeEquals(dafny.DafnySequence<? extends java.lang.Byte> a, dafny.DafnySequence<? extends java.lang.Byte> b)
  {
    return ((__default.ConstantTimeCompare(a, b, (byte) 0)) == 0 ? 0 : 1) == 0;
  }
  public static boolean CryptoSchemaMapIsFlat(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> data) {
    return ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, Boolean>)(_288_data) -> dafny.Helpers.Quantifier(((_288_data).valueSet()).Elements(), true, ((_forall_var_2_boxed0) -> {
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema _forall_var_2 = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)(_forall_var_2_boxed0));
      if (true) {
        Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema _289_v = (Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)_forall_var_2;
        return !(((_288_data).valueSet()).<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>contains(_289_v)) || (((_289_v).dtor_content()).is_Action());
      } else {
        return true;
      }
    }))).apply(data);
  }
  public static boolean AuthSchemaIsFlat(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> data) {
    return ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>, Boolean>)(_290_data) -> dafny.Helpers.Quantifier(((_290_data).valueSet()).Elements(), true, ((_forall_var_3_boxed0) -> {
      Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema _forall_var_3 = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema)(java.lang.Object)(_forall_var_3_boxed0));
      if (true) {
        Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema _291_v = (Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema)_forall_var_3;
        return !(((_290_data).valueSet()).<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>contains(_291_v)) || (((_291_v).dtor_content()).is_Action());
      } else {
        return true;
      }
    }))).apply(data);
  }
  public static boolean DataMapIsFlat(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data) {
    return ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Boolean>)(_292_data) -> dafny.Helpers.Quantifier(((_292_data).valueSet()).Elements(), true, ((_forall_var_4_boxed0) -> {
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _forall_var_4 = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)(_forall_var_4_boxed0));
      if (true) {
        Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _293_v = (Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)_forall_var_4;
        return !(((_292_data).valueSet()).<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>contains(_293_v)) || (((_293_v).dtor_content()).is_Terminal());
      } else {
        return true;
      }
    }))).apply(data);
  }
  public static boolean IsAuthAttr(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction x) {
    return ((x).is_ENCRYPT__AND__SIGN()) || ((x).is_SIGN__ONLY());
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData ValueToData(dafny.DafnySequence<? extends java.lang.Byte> value, dafny.DafnySequence<? extends java.lang.Byte> typeId)
  {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_Terminal(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal.create(value, typeId)), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal>>create_None());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> GetValue(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData data) {
    return (((data).dtor_content()).dtor_Terminal()).dtor_value();
  }
  public static boolean ByteLess(byte x, byte y)
  {
    return java.lang.Integer.compareUnsigned(x, y) < 0;
  }
  public static boolean CharLess(char x, char y)
  {
    return (x) < (y);
  }
  public static java.math.BigInteger KeySize()
  {
    return java.math.BigInteger.valueOf(32L);
  }
  public static java.math.BigInteger NonceSize()
  {
    return java.math.BigInteger.valueOf(12L);
  }
  public static java.math.BigInteger AuthTagSize()
  {
    return java.math.BigInteger.valueOf(16L);
  }
  public static java.math.BigInteger MSGID__LEN()
  {
    return java.math.BigInteger.valueOf(32L);
  }
  public static dafny.DafnySequence<? extends Character> ReservedPrefix()
  {
    return dafny.DafnySequence.asString("aws_dbe_");
  }
  public static dafny.DafnySequence<? extends Character> HeaderField()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedPrefix(), dafny.DafnySequence.asString("head"));
  }
  public static dafny.DafnySequence<? extends Character> FooterField()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedPrefix(), dafny.DafnySequence.asString("foot"));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BYTES__TYPE__ID()
  {
    return dafny.DafnySequence.of((byte) 255, (byte) 255);
  }
  public static java.math.BigInteger TYPEID__LEN()
  {
    return java.math.BigInteger.valueOf(2L);
  }
  public static dafny.DafnySequence<? extends Character> ReservedCryptoContextPrefixString()
  {
    return dafny.DafnySequence.asString("aws-crypto-");
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> ReservedCryptoContextPrefixUTF8()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("aws-crypto-"));
  }
  public static byte DbeAlgorithmFamily()
  {
    return (byte) 103;
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema DoNotSign()
  {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.create_DO__NOT__SIGN()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema DoSign()
  {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.create_SIGN()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema EncryptAndSign()
  {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema SignOnly()
  {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema DoNothing()
  {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionUtil_Compile._default";
  }
}
