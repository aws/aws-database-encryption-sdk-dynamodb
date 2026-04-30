// Class __default
// Dafny class __default compiled into Java
package DynamoDbItemEncryptorUtil_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error E(dafny.DafnySequence<? extends Character> msg) {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error.create_DynamoDbItemEncryptorException(msg);
  }
  public static boolean ByteLess(byte x, byte y)
  {
    return java.lang.Integer.compareUnsigned(x, y) < 0;
  }
  public static boolean CharLess(char x, char y)
  {
    return (x) < (y);
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> GetLiteralValue(dafny.DafnySequence<? extends java.lang.Byte> x) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = UTF8.__default.Decode(x);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends Character> _1_str = (_0_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      if ((_1_str).equals(StructuredEncryptionUtil_Compile.__default.TRUE__STR())) {
        return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(true));
      } else if ((_1_str).equals(StructuredEncryptionUtil_Compile.__default.FALSE__STR())) {
        return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(false));
      } else if ((_1_str).equals(StructuredEncryptionUtil_Compile.__default.NULL__STR())) {
        return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true));
      } else {
        return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Encryption Context literal value has unexpected value : '"), _1_str), dafny.DafnySequence.asString("'.")));
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, dafny.DafnySequence<? extends Character>> GetSortKey(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> context) {
    if (((context).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.SORT__NAME())) {
      dafny.DafnySequence<? extends java.lang.Byte> _0_sortName = dafny.DafnySequence.<java.lang.Byte>concatenate(StructuredEncryptionUtil_Compile.__default.EC__ATTR__PREFIX(), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(__default.SORT__NAME()))));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _1_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), UTF8.__default.ValidUTF8Seq(_0_sortName), dafny.DafnySequence.asString("Internal Error : bad utf8 in sortName"));
      if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_1_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
      } else {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, dafny.DafnySequence<? extends Character>>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), _0_sortName));
      }
    } else {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, dafny.DafnySequence<? extends Character>>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>> ConvertContextForSelector(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> context) {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((context).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.PARTITION__NAME()), dafny.DafnySequence.asString("Invalid encryption context: Missing partition name"));
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_partitionName = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(__default.PARTITION__NAME())));
      dafny.DafnySequence<? extends java.lang.Byte> _2_partitionValueKey = dafny.DafnySequence.<java.lang.Byte>concatenate(StructuredEncryptionUtil_Compile.__default.EC__ATTR__PREFIX(), _1_partitionName);
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _3_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((context).keySet()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_2_partitionValueKey), dafny.DafnySequence.asString("Invalid encryption context: Missing partition value"));
      if ((_3_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_3_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, dafny.DafnySequence<? extends Character>> _4_valueOrError2 = __default.GetSortKey(context);
        if ((_4_valueOrError2).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_4_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> _5_sortValueKey = (_4_valueOrError2).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _6_valueOrError3 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((_5_sortValueKey).is_None()) || ((context).<dafny.DafnySequence<? extends java.lang.Byte>>contains((_5_sortValueKey).dtor_value())), dafny.DafnySequence.asString("Invalid encryption context: Missing sort value"));
          if ((_6_valueOrError3).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_6_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
          } else {
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _7_keys = SortedSets.__default.<java.lang.Byte>SetToOrderedSequence2(BoundedInts_Compile.uint8._typeDescriptor(), (context).keySet(), StructuredEncryptionUtil_Compile.__default::ByteLess);
            if ((context).<dafny.DafnySequence<? extends java.lang.Byte>>contains(StructuredEncryptionUtil_Compile.__default.LEGEND__UTF8())) {
              Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _8_valueOrError4 = UTF8.__default.Decode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(StructuredEncryptionUtil_Compile.__default.LEGEND__UTF8()))));
              if ((_8_valueOrError4).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_8_valueOrError4).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
              } else {
                dafny.DafnySequence<? extends Character> _9_legend = (_8_valueOrError4).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>> _10_valueOrError5 = __default.GetV2AttrMap(_7_keys, context, _9_legend, (long) 0L, (long) 0L, dafny.DafnyMap.fromElements());
                if ((_10_valueOrError5).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                  return (_10_valueOrError5).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
                } else {
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _11_attrMap = (_10_valueOrError5).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                  Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _12_valueOrError6 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (context).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.TABLE__NAME()), dafny.DafnySequence.asString("Internal error, table name not in encryption context."));
                  if ((_12_valueOrError6).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                    return (_12_valueOrError6).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
                  } else {
                    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _13_valueOrError7 = UTF8.__default.Decode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(__default.TABLE__NAME()))));
                    if ((_13_valueOrError7).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                      return (_13_valueOrError7).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
                    } else {
                      dafny.DafnySequence<? extends Character> _14_tableName = (_13_valueOrError7).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_attrMap2 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(_11_attrMap, __default.SELECTOR__TABLE__NAME(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_14_tableName));
                      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _16_valueOrError8 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (context).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.PARTITION__NAME()), dafny.DafnySequence.asString("Internal error, table name not in encryption context."));
                      if ((_16_valueOrError8).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                        return (_16_valueOrError8).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
                      } else {
                        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _17_valueOrError9 = UTF8.__default.Decode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(__default.PARTITION__NAME()))));
                        if ((_17_valueOrError9).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                          return (_17_valueOrError9).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
                        } else {
                          dafny.DafnySequence<? extends Character> _18_partitionName = (_17_valueOrError9).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _19_attrMap3 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(_15_attrMap2, __default.SELECTOR__PARTITION__NAME(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_18_partitionName));
                          if ((context).<dafny.DafnySequence<? extends java.lang.Byte>>contains(__default.SORT__NAME())) {
                            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _20_valueOrError10 = UTF8.__default.Decode(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(__default.SORT__NAME()))));
                            if ((_20_valueOrError10).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                              return (_20_valueOrError10).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
                            } else {
                              dafny.DafnySequence<? extends Character> _21_sortName = (_20_valueOrError10).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                              return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(_19_attrMap3, __default.SELECTOR__SORT__NAME(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_21_sortName)));
                            }
                          } else {
                            return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _19_attrMap3);
                          }
                        }
                      }
                    }
                  }
                }
              }
            } else if ((_5_sortValueKey).is_None()) {
              return __default.AddAttributeToMap(_2_partitionValueKey, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(_2_partitionValueKey))), dafny.DafnyMap.fromElements());
            } else {
              Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>> _22_valueOrError11 = __default.AddAttributeToMap(_2_partitionValueKey, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(_2_partitionValueKey))), dafny.DafnyMap.fromElements());
              if ((_22_valueOrError11).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_22_valueOrError11).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
              } else {
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _23_attrMap = (_22_valueOrError11).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                return __default.AddAttributeToMap((_5_sortValueKey).dtor_value(), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get((_5_sortValueKey).dtor_value()))), _23_attrMap);
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> GetAttrValue(dafny.DafnySequence<? extends java.lang.Byte> ecValue, char legend)
  {
    if ((legend) == (StructuredEncryptionUtil_Compile.__default.LEGEND__STRING())) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = UTF8.__default.Decode(ecValue);
      if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_0_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends Character> _1_value = (_0_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_1_value));
      }
    } else if ((legend) == (StructuredEncryptionUtil_Compile.__default.LEGEND__NUMBER())) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = UTF8.__default.Decode(ecValue);
      if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends Character> _3_value = (_2_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(_3_value));
      }
    } else if ((legend) == (StructuredEncryptionUtil_Compile.__default.LEGEND__LITERAL())) {
      Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _4_valueOrError2 = __default.GetLiteralValue(ecValue);
      if ((_4_valueOrError2).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_4_valueOrError2).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      } else {
        software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _5_value = (_4_valueOrError2).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _5_value);
      }
    } else if ((legend) == (StructuredEncryptionUtil_Compile.__default.LEGEND__BINARY())) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _6_valueOrError3 = StructuredEncryptionUtil_Compile.__default.DecodeTerminal(ecValue);
      if ((_6_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_6_valueOrError3).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      } else {
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _7_terminal = (_6_valueOrError3).Extract(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Result<DynamoToStruct_Compile.AttrValueAndLength, dafny.DafnySequence<? extends Character>> _8_valueOrError4 = DynamoToStruct_Compile.__default.BytesToAttr((_7_terminal).dtor_value(), (_7_terminal).dtor_typeId(), Wrappers_Compile.Option.<java.lang.Long>create_Some(BoundedInts_Compile.uint64._typeDescriptor(), (long) ((_7_terminal).dtor_value()).cardinalityInt()), (long) 1L, (long) 0L);
        if ((_8_valueOrError4).IsFailure(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_8_valueOrError4).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
        } else {
          DynamoToStruct_Compile.AttrValueAndLength _9_ddbAttrValue = (_8_valueOrError4).Extract(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_9_ddbAttrValue).dtor_val());
        }
      }
    } else {
      return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Encryption Context Legend has unexpected character : '"), dafny.DafnySequence.<Character> of(legend)), dafny.DafnySequence.asString("'.")));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>> GetV2AttrMap(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> keys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> context, dafny.DafnySequence<? extends Character> legend, long keyPos, long legendPos, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> attrMap)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (keys).cardinalityInt()) == (keyPos)) {
        if (((long) (legend).cardinalityInt()) == (legendPos)) {
          return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), attrMap);
        } else {
          return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Encryption Context Legend is too long."));
        }
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _0_key = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((keys).select(dafny.Helpers.unsignedToInt(keyPos))));
        if ((StructuredEncryptionUtil_Compile.__default.EC__ATTR__PREFIX()).isProperPrefixOf(_0_key)) {
          Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _1_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.lang.Long.compareUnsigned(legendPos, (long) (legend).cardinalityInt()) < 0, dafny.DafnySequence.asString("Encryption Context Legend is too short."));
          if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_1_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
          } else {
            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = __default.GetAttributeName(_0_key);
            if ((_2_valueOrError1).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_2_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
            } else {
              dafny.DafnySequence<? extends Character> _3_attrName = (_2_valueOrError1).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _4_valueOrError2 = __default.GetAttrValue(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((context).get(_0_key))), ((char)(java.lang.Object)((legend).select(dafny.Helpers.unsignedToInt(legendPos)))));
              if ((_4_valueOrError2).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_4_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
              } else {
                software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _5_attrValue = (_4_valueOrError2).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in0 = keys;
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in1 = context;
                dafny.DafnySequence<? extends Character> _in2 = legend;
                long _in3 = (long) (long) ((keyPos) + ((long) 1L));
                long _in4 = (long) (long) ((legendPos) + ((long) 1L));
                dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in5 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(attrMap, _3_attrName, _5_attrValue);
                keys = _in0;
                context = _in1;
                legend = _in2;
                keyPos = _in3;
                legendPos = _in4;
                attrMap = _in5;
                continue TAIL_CALL_START;
              }
            }
          }
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in6 = keys;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in7 = context;
          dafny.DafnySequence<? extends Character> _in8 = legend;
          long _in9 = (long) (long) ((keyPos) + ((long) 1L));
          long _in10 = legendPos;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in11 = attrMap;
          keys = _in6;
          context = _in7;
          legend = _in8;
          keyPos = _in9;
          legendPos = _in10;
          attrMap = _in11;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> GetAttributeName(dafny.DafnySequence<? extends java.lang.Byte> ddbAttrKey) {
    dafny.DafnySequence<? extends java.lang.Byte> _0_ddbAttrNameBytes = (ddbAttrKey).drop(java.math.BigInteger.valueOf((StructuredEncryptionUtil_Compile.__default.EC__ATTR__PREFIX()).length()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _1_valueOrError0 = UTF8.__default.Decode(_0_ddbAttrNameBytes);
    if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1_valueOrError0).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends Character> _2_ddbAttrName = (_1_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _3_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(_2_ddbAttrName), dafny.DafnySequence.asString("Invalid serialization of DDB Attribute in encryption context."));
      if ((_3_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_3_valueOrError1).<dafny.DafnySequence<? extends Character>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _2_ddbAttrName);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>> AddAttributeToMap(dafny.DafnySequence<? extends java.lang.Byte> ddbAttrKey, dafny.DafnySequence<? extends java.lang.Byte> encodedAttrValue, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> attrMap)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.GetAttributeName(ddbAttrKey);
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends Character> _1_ddbAttrName = (_0_valueOrError0).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = StructuredEncryptionUtil_Compile.__default.DecodeTerminal(encodedAttrValue);
      if ((_2_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
      } else {
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _3_terminal = (_2_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Result<DynamoToStruct_Compile.AttrValueAndLength, dafny.DafnySequence<? extends Character>> _4_valueOrError2 = DynamoToStruct_Compile.__default.BytesToAttr((_3_terminal).dtor_value(), (_3_terminal).dtor_typeId(), Wrappers_Compile.Option.<java.lang.Long>create_Some(BoundedInts_Compile.uint64._typeDescriptor(), (long) ((_3_terminal).dtor_value()).cardinalityInt()), (long) 1L, (long) 0L);
        if ((_4_valueOrError2).IsFailure(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_4_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        } else {
          DynamoToStruct_Compile.AttrValueAndLength _5_ddbAttrValue = (_4_valueOrError2).Extract(DynamoToStruct_Compile.AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(attrMap, _1_ddbAttrName, (_5_ddbAttrValue).dtor_val()));
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> ReservedPrefix()
  {
    return dafny.DafnySequence.asString("aws_dbe_");
  }
  public static dafny.DafnySequence<? extends Character> BeaconPrefix()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedPrefix(), dafny.DafnySequence.asString("b_"));
  }
  public static dafny.DafnySequence<? extends Character> VersionPrefix()
  {
    return dafny.DafnySequence.<Character>concatenate(__default.ReservedPrefix(), dafny.DafnySequence.asString("v_"));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SORT__NAME()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45, (byte) 115, (byte) 111, (byte) 114, (byte) 116, (byte) 45, (byte) 110, (byte) 97, (byte) 109, (byte) 101);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> PARTITION__NAME()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45, (byte) 112, (byte) 97, (byte) 114, (byte) 116, (byte) 105, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 45, (byte) 110, (byte) 97, (byte) 109, (byte) 101);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> TABLE__NAME()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 111, (byte) 45, (byte) 116, (byte) 97, (byte) 98, (byte) 108, (byte) 101, (byte) 45, (byte) 110, (byte) 97, (byte) 109, (byte) 101);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends Character> SELECTOR__TABLE__NAME()
  {
    return dafny.DafnySequence.asString("aws_dbe_table_name");
  }
  public static dafny.DafnySequence<? extends Character> SELECTOR__PARTITION__NAME()
  {
    return dafny.DafnySequence.asString("aws_dbe_partition_name");
  }
  public static dafny.DafnySequence<? extends Character> SELECTOR__SORT__NAME()
  {
    return dafny.DafnySequence.asString("aws_dbe_sort_name");
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbItemEncryptorUtil._default";
  }
}
