// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionPaths_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean ValidTerminalSelector(dafny.DafnySequence<? extends Selector> s) {
    return (((java.math.BigInteger.valueOf((s).length())).signum() == 1) && ((java.math.BigInteger.valueOf((s).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0)) && ((((Selector)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Map());
  }
  public static Wrappers_Compile.Result<TerminalLocation, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> TermLocMap_q(dafny.DafnySequence<? extends Character> attr) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _306_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidString(attr), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("invalid string : "), attr)));
    if ((_306_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_306_valueOrError0).<TerminalLocation>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), TerminalLocation._typeDescriptor());
    } else {
      return Wrappers_Compile.Result.<TerminalLocation, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(__default.TermLocMap(attr));
    }
  }
  public static TerminalLocation TermLocMap(dafny.DafnySequence<? extends Character> attr) {
    return StructuredEncryptionPaths_Compile.TerminalLocation.create(dafny.DafnySequence.of(Selector._typeDescriptor(), StructuredEncryptionPaths_Compile.Selector.create_Map(attr)));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SimpleCanon(dafny.DafnySequence<? extends Character> table, dafny.DafnySequence<? extends Character> attr)
  {
    return (__default.TermLocMap(attr)).canonicalPath(table);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> CanonicalPart(Selector s) {
    Selector _source3 = s;
    if (_source3.is_List()) {
      long _307___mcc_h0 = ((StructuredEncryptionPaths_Compile.Selector_List)_source3)._pos;
      long _308_pos = _307___mcc_h0;
      return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.of(__default.ARRAY__TAG()), StandardLibrary_mUInt_Compile.__default.UInt64ToSeq(_308_pos));
    } else {
      dafny.DafnySequence<? extends Character> _309___mcc_h1 = ((StructuredEncryptionPaths_Compile.Selector_Map)_source3)._key;
      dafny.DafnySequence<? extends Character> _310_key = _309___mcc_h1;
      return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.of(__default.MAP__TAG()), StandardLibrary_mUInt_Compile.__default.UInt64ToSeq((_310_key).cardinalityInt())), (UTF8.__default.Encode(_310_key)).dtor_value());
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> MakeCanonicalPath(dafny.DafnySequence<? extends Selector> src) {
    dafny.DafnySequence<? extends java.lang.Byte> _311___accumulator = dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((src).length())).signum() == 0) {
        return dafny.DafnySequence.<java.lang.Byte>concatenate(_311___accumulator, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        _311___accumulator = dafny.DafnySequence.<java.lang.Byte>concatenate(_311___accumulator, __default.CanonicalPart(((Selector)(java.lang.Object)((src).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))));
        dafny.DafnySequence<? extends Selector> _in35 = (src).drop(java.math.BigInteger.ONE);
        src = _in35;
        continue TAIL_CALL_START;
      }
    }
  }
  public static byte MAP__TAG()
  {
    return ((byte) ('$'));
  }
  public static byte ARRAY__TAG()
  {
    return ((byte) ('#'));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionPaths_Compile._default";
  }
}
