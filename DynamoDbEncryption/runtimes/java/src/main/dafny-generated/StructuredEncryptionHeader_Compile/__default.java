// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean ValidVersion(byte x) {
    return ((x) == ((byte) 1)) || ((x) == ((byte) 2));
  }
  public static boolean IsVersion2Schema(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data, int pos)
  {
    TAIL_CALL_START: while (true) {
      if ((pos) == ((data).cardinalityInt())) {
        return false;
      } else if (java.util.Objects.equals((((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((data).select(pos)))).dtor_action(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT())) {
        return true;
      } else {
        dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _in0 = data;
        int _in1 = (int) ((pos) + (1));
        data = _in0;
        pos = _in1;
        continue TAIL_CALL_START;
      }
    }
  }
  public static byte VersionFromSchema(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data) {
    if (__default.IsVersion2Schema(data, 0)) {
      return (byte) 2;
    } else {
      return (byte) 1;
    }
  }
  public static boolean ValidFlavor(byte x) {
    return (dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 1)).contains(x);
  }
  public static boolean ValidLegendByte(byte x) {
    return (dafny.DafnySequence.<java.lang.Byte> of(__default.ENCRYPT__AND__SIGN__LEGEND(), __default.SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT__LEGEND(), __default.SIGN__ONLY__LEGEND())).contains(x);
  }
  public static boolean ValidEncryptionContext(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> x) {
    return (java.lang.Long.compareUnsigned((long) (x).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()).longValue()) < 0) && (((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Boolean>)(_0_x) -> dafny.Helpers.Quantifier((_0_x).keySet().Elements(), true, ((_forall_var_0_boxed0) -> {
      dafny.DafnySequence<? extends java.lang.Byte> _forall_var_0 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(_forall_var_0_boxed0));
      dafny.DafnySequence<? extends java.lang.Byte> _1_k = (dafny.DafnySequence<? extends java.lang.Byte>)_forall_var_0;
      return !((_0_x).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_1_k)) || ((java.lang.Long.compareUnsigned((long) (_1_k).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()).longValue()) < 0) && (java.lang.Long.compareUnsigned((long) (((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((_0_x).get(_1_k)))).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()).longValue()) < 0));
    }))).apply(x));
  }
  public static boolean ValidEncryptedDataKey(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey x) {
    return ((java.lang.Long.compareUnsigned((long) ((x).dtor_keyProviderId()).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()).longValue()) < 0) && (java.lang.Long.compareUnsigned((long) ((x).dtor_keyProviderInfo()).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()).longValue()) < 0)) && (java.lang.Long.compareUnsigned((long) ((x).dtor_ciphertext()).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()).longValue()) < 0);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> Serialize(software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient client, software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> commitKey, PartialHeader PartialHeader)
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_body = (PartialHeader).serialize();
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = __default.CalculateHeaderCommitment(client, alg, commitKey, _0_body);
    if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_1_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _2_commitment = (_1_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>concatenate(_0_body, _2_commitment));
    }
  }
  public static Wrappers_Compile.Result<PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> Create(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> schema, dafny.DafnySequence<? extends java.lang.Byte> msgID, software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials mat)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) (schema).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.UINT32__LIMIT()).longValue()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected large schema")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
    } else {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), __default.ValidEncryptionContext((mat).dtor_encryptionContext()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Encryption Context")));
      if ((_1_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_1_valueOrError1).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (((long) ((mat).dtor_encryptedDataKeys()).cardinalityInt()) == 0 ? 0 : 1) == 1, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("There must be at least one data key")));
        if ((_2_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_2_valueOrError2).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
        } else {
          Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _3_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) ((mat).dtor_encryptedDataKeys()).cardinalityInt(), __default.UINT8__LIMIT64()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Too many data keys.")));
          if ((_3_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
            return (_3_valueOrError3).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
          } else {
            Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_valueOrError4 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials, Boolean>)(_5_mat) -> dafny.Helpers.Quantifier(((_5_mat).dtor_encryptedDataKeys()).UniqueElements(), true, ((_forall_var_0_boxed0) -> {
              software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey _forall_var_0 = ((software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)(java.lang.Object)(_forall_var_0_boxed0));
              software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey _6_x = (software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)_forall_var_0;
              return !(((_5_mat).dtor_encryptedDataKeys()).contains(_6_x)) || (__default.ValidEncryptedDataKey(_6_x));
            }))).apply(mat), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Data Key")));
            if ((_4_valueOrError4).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
              return (_4_valueOrError4).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
            } else {
              Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _7_valueOrError5 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((long) (((mat).dtor_algorithmSuite()).dtor_binaryId()).cardinalityInt()) == ((long) 2L), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Algorithm Suite Binary ID")));
              if ((_7_valueOrError5).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                return (_7_valueOrError5).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
              } else {
                Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _8_valueOrError6 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (((byte)(java.lang.Object)((((mat).dtor_algorithmSuite()).dtor_binaryId()).select(0)))) == (StructuredEncryptionUtil_Compile.__default.DbeAlgorithmFamily()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Algorithm Suite not suitable for structured encryption.")));
                if ((_8_valueOrError6).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                  return (_8_valueOrError6).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                } else {
                  Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _9_valueOrError7 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), __default.ValidFlavor(((byte)(java.lang.Object)((((mat).dtor_algorithmSuite()).dtor_binaryId()).select(1)))), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Algorithm Suite has unexpected flavor.")));
                  if ((_9_valueOrError7).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                    return (_9_valueOrError7).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                  } else {
                    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _10_valueOrError8 = __default.MakeLegend(schema);
                    if ((_10_valueOrError8).IsFailure(Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                      return (_10_valueOrError8).<PartialHeader>PropagateFailure(Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                    } else {
                      dafny.DafnySequence<? extends java.lang.Byte> _11_legend = (_10_valueOrError8).Extract(Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
                      dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _12_storedEC = ((java.util.function.Function<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>)(_13_mat) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>)(() -> {
                        java.util.HashMap<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>> _coll0 = new java.util.HashMap<>();
                        for (dafny.DafnySequence<? extends java.lang.Byte> _compr_0_boxed0 : ((_13_mat).dtor_encryptionContext()).keySet().Elements()) {
                          dafny.DafnySequence<? extends java.lang.Byte> _compr_0 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(_compr_0_boxed0));
                          dafny.DafnySequence<? extends java.lang.Byte> _14_k = (dafny.DafnySequence<? extends java.lang.Byte>)_compr_0;
                          if (UTF8.ValidUTF8Bytes._Is(_14_k)) {
                            if ((((_13_mat).dtor_encryptionContext()).<dafny.DafnySequence<? extends java.lang.Byte>>contains(_14_k)) && (!((_13_mat).dtor_requiredEncryptionContextKeys()).contains(_14_k))) {
                              _coll0.put(_14_k,((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(((_13_mat).dtor_encryptionContext()).get(_14_k))));
                            }
                          }
                        }
                        return new dafny.DafnyMap<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>>(_coll0);
                      })).apply()).apply(mat);
                      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _15_valueOrError9 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), __default.ValidEncryptionContext(_12_storedEC), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Encryption Context")));
                      if ((_15_valueOrError9).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                        return (_15_valueOrError9).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                      } else {
                        return Wrappers_Compile.Result.<PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader.create(__default.VersionFromSchema(schema), ((byte)(java.lang.Object)((((mat).dtor_algorithmSuite()).dtor_binaryId()).select(1))), msgID, _11_legend, _12_storedEC, (mat).dtor_encryptedDataKeys()));
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
  public static Wrappers_Compile.Result<PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> PartialDeserialize(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(__default.PREFIX__LEN64(), (long) (data).cardinalityInt()) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Serialized PartialHeader too short.")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
    } else {
      byte _1_version = ((byte)(java.lang.Object)((data).select(0)));
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), __default.ValidVersion(_1_version), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Version Number")));
      if ((_2_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
      } else {
        byte _3_flavor = ((byte)(java.lang.Object)((data).select(1)));
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), __default.ValidFlavor(_3_flavor), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Flavor")));
        if ((_4_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_4_valueOrError2).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _5_msgID = (data).subsequence(2, dafny.Helpers.unsignedToInt(__default.PREFIX__LEN64()));
          dafny.DafnySequence<? extends java.lang.Byte> _6_legendData = (data).drop(__default.PREFIX__LEN64());
          Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _7_valueOrError3 = __default.GetLegend(_6_legendData);
          if ((_7_valueOrError3).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(Legend._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
            return (_7_valueOrError3).<PartialHeader>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(Legend._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
          } else {
            dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long> _8_legendAndLen = (_7_valueOrError3).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(Legend._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
            dafny.DafnySequence<? extends java.lang.Byte> _9_legend = (_8_legendAndLen).dtor__0();
            dafny.DafnySequence<? extends java.lang.Byte> _10_contextData = (_6_legendData).drop((_8_legendAndLen).dtor__1());
            Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _11_valueOrError4 = __default.GetContext(_10_contextData);
            if ((_11_valueOrError4).IsFailure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
              return (_11_valueOrError4).<PartialHeader>PropagateFailure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
            } else {
              dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long> _12_contextAndLen = (_11_valueOrError4).Extract(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _13_encContext = (_12_contextAndLen).dtor__0();
              dafny.DafnySequence<? extends java.lang.Byte> _14_keysData = (_10_contextData).drop((_12_contextAndLen).dtor__1());
              Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _15_valueOrError5 = __default.GetDataKeys(_14_keysData);
              if ((_15_valueOrError5).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyList._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                return (_15_valueOrError5).<PartialHeader>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyList._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
              } else {
                dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long> _16_keysAndLen = (_15_valueOrError5).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyList._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
                dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> _17_dataKeys = (_16_keysAndLen).dtor__0();
                dafny.DafnySequence<? extends java.lang.Byte> _18_trailingData = (_14_keysData).drop((_16_keysAndLen).dtor__1());
                Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _19_valueOrError6 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) (_18_trailingData).cardinalityInt(), __default.COMMITMENT__LEN64()) >= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid header serialization: unexpected end of data.")));
                if ((_19_valueOrError6).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                  return (_19_valueOrError6).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                } else {
                  Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _20_valueOrError7 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) (_18_trailingData).cardinalityInt(), __default.COMMITMENT__LEN64()) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid header serialization: unexpected bytes.")));
                  if ((_20_valueOrError7).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                    return (_20_valueOrError7).<PartialHeader>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader._typeDescriptor());
                  } else {
                    return Wrappers_Compile.Result.<PartialHeader, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), PartialHeader.create(_1_version, _3_flavor, _5_msgID, _9_legend, _13_encContext, _17_dataKeys));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> CalculateHeaderCommitment(software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient client, software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> commitKey, dafny.DafnySequence<? extends java.lang.Byte> data)
  {
    software.amazon.cryptography.primitives.internaldafny.types.HMacInput _0_input = software.amazon.cryptography.primitives.internaldafny.types.HMacInput.create((((alg).dtor_commitment()).dtor_HKDF()).dtor_hmac(), commitKey, data);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _1_outputR = (client).HMac(_0_input);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError0 = (_1_outputR).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_3_e_boxed0) -> {
      software.amazon.cryptography.primitives.internaldafny.types.Error _3_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_3_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyPrimitives(_3_e);
    }));
    if ((_2_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_2_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _4_output = (_2_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
      if (java.lang.Long.compareUnsigned((long) (_4_output).cardinalityInt(), __default.COMMITMENT__LEN64()) < 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("HMAC did not produce enough bits")));
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (_4_output).take(__default.COMMITMENT__LEN64()));
      }
    }
  }
  public static <__X, __Y, __Z> dafny.DafnyMap<? extends __Y, ? extends __Z> MyMap(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.TypeDescriptor<__Z> _td___Z, java.util.function.Function<__X, __Y> f, dafny.DafnyMap<? extends __X, ? extends __Z> m)
  {
    return ((dafny.Function2<dafny.DafnyMap<? extends __X, ? extends __Z>, java.util.function.Function<__X, __Y>, dafny.DafnyMap<? extends __Y, ? extends __Z>>)(_0_m, _1_f) -> ((dafny.Function0<dafny.DafnyMap<? extends __Y, ? extends __Z>>)(() -> {
      java.util.HashMap<__Y, __Z> _coll0 = new java.util.HashMap<>();
      for (__X _compr_0_boxed0 : (_0_m).keySet().Elements()) {
        __X _compr_0 = ((__X)(java.lang.Object)(_compr_0_boxed0));
        __X _2_k = (__X)_compr_0;
        if ((_0_m).<__X>contains(_2_k)) {
          _coll0.put(((__Y)(java.lang.Object)((_1_f).apply(_2_k))),((__Z)(java.lang.Object)((_0_m).get(_2_k))));
        }
      }
      return new dafny.DafnyMap<__Y,__Z>(_coll0);
    })).apply()).apply(m, f);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> MakeLegend(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> schema) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = __default.MakeLegend2(schema, (long) 0L, __default.EmptyLegend());
    if ((_0_valueOrError0).IsFailure(Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Legend._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_legend = (_0_valueOrError0).Extract(Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
      long _2_authCount = __default.CountAuthAttrs(schema, (long) 0L, (long) 0L);
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _3_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (_2_authCount) == ((long) (_1_legend).cardinalityInt()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Internal Error : bad legend calculation.")));
      if ((_3_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_3_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Legend._typeDescriptor());
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), _1_legend);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> MakeLegend2(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data, long pos, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (data).cardinalityInt()) == (pos)) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(Legend._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), serialized);
      } else if (StructuredEncryptionUtil_Compile.__default.IsAuthAttr((((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((data).select(dafny.Helpers.unsignedToInt(pos))))).dtor_action())) {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) (long) (((long) (serialized).cardinalityInt()) + ((long) 1L)), (StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()).longValue()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Legend Too Long.")));
        if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Legend._typeDescriptor());
        } else {
          byte _1_legendChar = __default.GetActionLegend((((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((data).select(dafny.Helpers.unsignedToInt(pos))))).dtor_action());
          dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _in0 = data;
          long _in1 = (long) (long) ((pos) + ((long) 1L));
          dafny.DafnySequence<? extends java.lang.Byte> _in2 = dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, dafny.DafnySequence.<java.lang.Byte> of(_1_legendChar));
          data = _in0;
          pos = _in1;
          serialized = _in2;
          continue TAIL_CALL_START;
        }
      } else {
        dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _in3 = data;
        long _in4 = (long) (long) ((pos) + ((long) 1L));
        dafny.DafnySequence<? extends java.lang.Byte> _in5 = serialized;
        data = _in3;
        pos = _in4;
        serialized = _in5;
        continue TAIL_CALL_START;
      }
    }
  }
  public static byte GetActionLegend(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction x) {
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction _source0 = x;
    if (_source0.is_ENCRYPT__AND__SIGN()) {
      return __default.ENCRYPT__AND__SIGN__LEGEND();
    } else if (_source0.is_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()) {
      return __default.SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT__LEGEND();
    } else {
      return __default.SIGN__ONLY__LEGEND();
    }
  }
  public static long CountAuthAttrs(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data, long pos, long acc)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (data).cardinalityInt()) == (pos)) {
        return acc;
      } else if (StructuredEncryptionUtil_Compile.__default.IsAuthAttr((((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((data).select(dafny.Helpers.unsignedToInt(pos))))).dtor_action())) {
        dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _in0 = data;
        long _in1 = (long) (long) ((pos) + ((long) 1L));
        long _in2 = StandardLibrary_mMemoryMath_Compile.__default.Add(acc, (long) 1L);
        data = _in0;
        pos = _in1;
        acc = _in2;
        continue TAIL_CALL_START;
      } else {
        dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _in3 = data;
        long _in4 = (long) (long) ((pos) + ((long) 1L));
        long _in5 = acc;
        data = _in3;
        pos = _in4;
        acc = _in5;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeLegend(dafny.DafnySequence<? extends java.lang.Byte> x) {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) (x).cardinalityInt()), x);
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetLegend(dafny.DafnySequence<? extends java.lang.Byte> data) {
    long _0_data__size = (long) (data).cardinalityInt();
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) 2L, _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_1_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()));
    } else {
      long _2_len = (long) java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqPosToUInt16(data, (long) 0L));
      long _3_size = StandardLibrary_mMemoryMath_Compile.__default.Add(_2_len, (long) 2L);
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(_3_size, _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
      if ((_4_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_4_valueOrError1).<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _5_legend = (data).subsequence(2, dafny.Helpers.unsignedToInt(_3_size));
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _6_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends java.lang.Byte>, Boolean>)(_7_legend) -> dafny.Helpers.Quantifier((_7_legend).UniqueElements(), true, ((_forall_var_0_boxed0) -> {
          byte _forall_var_0 = ((byte)(java.lang.Object)(_forall_var_0_boxed0));
          byte _8_x = (byte)_forall_var_0;
          return !((_7_legend).contains(_8_x)) || (__default.ValidLegendByte(_8_x));
        }))).apply(_5_legend), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid byte in stored legend")));
        if ((_6_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_6_valueOrError2).<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()));
        } else {
          return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>create(_5_legend, _3_size));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetContext(dafny.DafnySequence<? extends java.lang.Byte> data) {
    long _0_data__size = (long) (data).cardinalityInt();
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) 2L, _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_1_valueOrError0).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
    } else {
      long _2_count = (long) java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqPosToUInt16(data, (long) 0L));
      Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _3_valueOrError1 = __default.GetContext2(_2_count, data, dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>create(dafny.DafnyMap.fromElements(), (long) 2L), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
      if ((_3_valueOrError1).IsFailure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_3_valueOrError1).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>>PropagateFailure(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
      } else {
        dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long> _4_context = (_3_valueOrError1).Extract(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), _4_context);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetOneKVPair(dafny.DafnySequence<? extends java.lang.Byte> data, long pos)
  {
    long _0_data__size = (long) (data).cardinalityInt();
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add((long) 2L, pos), _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_1_valueOrError0).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()));
    } else {
      long _2_keyLen = (long) java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqPosToUInt16(data, pos));
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _3_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add3(_2_keyLen, (long) 4L, pos), _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
      if ((_3_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_3_valueOrError1).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _4_key = (data).subsequence(dafny.Helpers.unsignedToInt((long) (long) (((long) 2L) + (pos))), dafny.Helpers.unsignedToInt(StandardLibrary_mMemoryMath_Compile.__default.Add3(_2_keyLen, (long) 2L, pos)));
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _5_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), UTF8.__default.ValidUTF8Seq(_4_key), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid UTF8 found in header.")));
        if ((_5_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_5_valueOrError2).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()));
        } else {
          long _6_valueLen = (long) java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqPosToUInt16(data, StandardLibrary_mMemoryMath_Compile.__default.Add3(_2_keyLen, (long) 2L, pos)));
          long _7_kvLen = (long) (long) (((long) (long) (((long) (long) (((long) 2L) + (_2_keyLen))) + ((long) 2L))) + (_6_valueLen));
          Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _8_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add(_7_kvLen, pos), _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
          if ((_8_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
            return (_8_valueOrError3).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()));
          } else {
            dafny.DafnySequence<? extends java.lang.Byte> _9_value = (data).subsequence(dafny.Helpers.unsignedToInt((long) (long) (((long) (long) ((_2_keyLen) + ((long) 4L))) + (pos))), dafny.Helpers.unsignedToInt((long) (long) ((_7_kvLen) + (pos))));
            Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _10_valueOrError4 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), UTF8.__default.ValidUTF8Seq(_9_value), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid UTF8 found in header.")));
            if ((_10_valueOrError4).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
              return (_10_valueOrError4).<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()));
            } else {
              return Wrappers_Compile.Result.<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>create(_4_key, _9_value, _7_kvLen));
            }
          }
        }
      }
    }
  }
  public static boolean BytesLess(dafny.DafnySequence<? extends java.lang.Byte> a, dafny.DafnySequence<? extends java.lang.Byte> b, long pos)
  {
    TAIL_CALL_START: while (true) {
      if ((a).equals(b)) {
        return false;
      } else if (((long) (a).cardinalityInt()) == (pos)) {
        return true;
      } else if (((long) (b).cardinalityInt()) == (pos)) {
        return false;
      } else if ((((byte)(java.lang.Object)((a).select(dafny.Helpers.unsignedToInt(pos))))) != (((byte)(java.lang.Object)((b).select(dafny.Helpers.unsignedToInt(pos)))))) {
        return java.lang.Integer.compareUnsigned(((byte)(java.lang.Object)((a).select(dafny.Helpers.unsignedToInt(pos)))), ((byte)(java.lang.Object)((b).select(dafny.Helpers.unsignedToInt(pos))))) < 0;
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _in0 = a;
        dafny.DafnySequence<? extends java.lang.Byte> _in1 = b;
        long _in2 = (long) (long) ((pos) + ((long) 1L));
        a = _in0;
        b = _in1;
        pos = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetContext2(long count, dafny.DafnySequence<? extends java.lang.Byte> data, dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long> deserialized, dafny.DafnySequence<? extends java.lang.Byte> prevKey)
  {
    TAIL_CALL_START: while (true) {
      if (((count) == 0 ? 0 : 1) == 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), deserialized);
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) (long) (((long) ((deserialized).dtor__0()).cardinalityInt()) + ((long) 1L)), (StandardLibrary_mUInt_Compile.__default.UINT16__LIMIT()).longValue()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Too much context")));
        if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
        } else {
          Wrappers_Compile.Result<dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError1 = __default.GetOneKVPair(data, (deserialized).dtor__1());
          if ((_1_valueOrError1).IsFailure(dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(CMPUtf8Bytes._typeDescriptor(), CMPUtf8Bytes._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
            return (_1_valueOrError1).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>>PropagateFailure(dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(CMPUtf8Bytes._typeDescriptor(), CMPUtf8Bytes._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
          } else {
            dafny.Tuple3<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long> _2_kv = (_1_valueOrError1).Extract(dafny.Tuple3.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>, java.lang.Long>_typeDescriptor(CMPUtf8Bytes._typeDescriptor(), CMPUtf8Bytes._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _3_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), __default.BytesLess(prevKey, (_2_kv).dtor__0(), (long) 0L), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Context keys out of order.")));
            if ((_3_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
              return (_3_valueOrError2).<dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>_typeDescriptor(CMPEncryptionContext._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
            } else {
              long _in0 = (long) (long) ((count) - ((long) 1L));
              dafny.DafnySequence<? extends java.lang.Byte> _in1 = data;
              dafny.Tuple2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long> _in2 = dafny.Tuple2.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, java.lang.Long>create(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>update((deserialized).dtor__0(), (_2_kv).dtor__0(), (_2_kv).dtor__1()), StandardLibrary_mMemoryMath_Compile.__default.Add((deserialized).dtor__1(), (_2_kv).dtor__2()));
              dafny.DafnySequence<? extends java.lang.Byte> _in3 = (_2_kv).dtor__0();
              count = _in0;
              data = _in1;
              deserialized = _in2;
              prevKey = _in3;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeContext(dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> x) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _0_keys = SortedSets.__default.<java.lang.Byte>SetToOrderedSequence2(BoundedInts_Compile.uint8._typeDescriptor(), (x).keySet(), StructuredEncryptionUtil_Compile.__default::ByteLess);
    return dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) (x).cardinalityInt()), __default.SerializeContext2(_0_keys, x, (long) 0L, dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor())));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeOneKVPair(dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends java.lang.Byte> value)
  {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) (key).cardinalityInt()), key), StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) (value).cardinalityInt())), value);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeOneDataKey(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey k) {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) ((k).dtor_keyProviderId()).cardinalityInt()), (k).dtor_keyProviderId()), StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) ((k).dtor_keyProviderInfo()).cardinalityInt())), (k).dtor_keyProviderInfo()), StandardLibrary_mUInt_Compile.__default.UInt16ToSeq((short) ((k).dtor_ciphertext()).cardinalityInt())), (k).dtor_ciphertext());
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetOneDataKey(dafny.DafnySequence<? extends java.lang.Byte> data, long pos)
  {
    long _0_data__size = (long) (data).cardinalityInt();
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add((long) 2L, pos), _0_data__size) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_1_valueOrError0).<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
    } else {
      long _2_provIdSize = (long) java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqPosToUInt16(data, pos));
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _3_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add3(_2_provIdSize, (long) 2L, pos), _0_data__size) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
      if ((_3_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_3_valueOrError1).<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _4_provId = (data).subsequence(dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 2L))), dafny.Helpers.unsignedToInt((long) (long) (((long) (long) ((pos) + ((long) 2L))) + (_2_provIdSize))));
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _5_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), UTF8.__default.ValidUTF8Seq(_4_provId), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid UTF8 found in header.")));
        if ((_5_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_5_valueOrError2).<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
        } else {
          long _6_part1Size = (long) (long) (((long) 2L) + (_2_provIdSize));
          Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _7_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add3(_6_part1Size, (long) 2L, pos), _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
          if ((_7_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
            return (_7_valueOrError3).<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
          } else {
            long _8_provInfoSize = (long) java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqPosToUInt16(data, (long) (long) ((pos) + (_6_part1Size))));
            long _9_part2Size = (long) (long) (((long) (long) ((_6_part1Size) + ((long) 2L))) + (_8_provInfoSize));
            Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _10_valueOrError4 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add(_9_part2Size, pos), _0_data__size) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
            if ((_10_valueOrError4).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
              return (_10_valueOrError4).<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
            } else {
              dafny.DafnySequence<? extends java.lang.Byte> _11_provInfo = (data).subsequence(dafny.Helpers.unsignedToInt((long) (long) (((long) (long) ((pos) + (_6_part1Size))) + ((long) 2L))), dafny.Helpers.unsignedToInt((long) (long) ((pos) + (_9_part2Size))));
              Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _12_valueOrError5 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add3(_9_part2Size, (long) 2L, pos), _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
              if ((_12_valueOrError5).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                return (_12_valueOrError5).<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
              } else {
                long _13_cipherSize = (long) java.lang.Short.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqPosToUInt16(data, (long) (long) ((pos) + (_9_part2Size))));
                long _14_part3Size = (long) (long) (((long) (long) ((_9_part2Size) + ((long) 2L))) + (_13_cipherSize));
                Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _15_valueOrError6 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(StandardLibrary_mMemoryMath_Compile.__default.Add(_14_part3Size, pos), _0_data__size) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
                if ((_15_valueOrError6).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
                  return (_15_valueOrError6).<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
                } else {
                  dafny.DafnySequence<? extends java.lang.Byte> _16_cipher = (data).subsequence(dafny.Helpers.unsignedToInt((long) (long) (((long) (long) ((pos) + (_9_part2Size))) + ((long) 2L))), dafny.Helpers.unsignedToInt((long) (long) ((pos) + (_14_part3Size))));
                  software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey _17_edk = software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.create(_4_provId, _11_provInfo, _16_cipher);
                  return Wrappers_Compile.Result.<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>create(_17_edk, _14_part3Size));
                }
              }
            }
          }
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeContext2(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> keys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> x, long pos, dafny.DafnySequence<? extends java.lang.Byte> acc)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (keys).cardinalityInt()) == (pos)) {
        return acc;
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in0 = keys;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in1 = x;
        long _in2 = (long) (long) ((pos) + ((long) 1L));
        dafny.DafnySequence<? extends java.lang.Byte> _in3 = dafny.DafnySequence.<java.lang.Byte>concatenate(acc, __default.SerializeOneKVPair(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((keys).select(dafny.Helpers.unsignedToInt(pos)))), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((x).get(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((keys).select(dafny.Helpers.unsignedToInt(pos)))))))));
        keys = _in0;
        x = _in1;
        pos = _in2;
        acc = _in3;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeDataKeys(dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> x) {
    dafny.DafnySequence<? extends java.lang.Byte> _0_body = __default.SerializeDataKeys2(x, (long) 0L, dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte> of((byte) (x).cardinalityInt()), _0_body);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeDataKeys2(dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> x, long pos, dafny.DafnySequence<? extends java.lang.Byte> acc)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (x).cardinalityInt()) == (pos)) {
        return acc;
      } else {
        dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> _in0 = x;
        long _in1 = (long) (long) ((pos) + ((long) 1L));
        dafny.DafnySequence<? extends java.lang.Byte> _in2 = dafny.DafnySequence.<java.lang.Byte>concatenate(acc, __default.SerializeOneDataKey(((software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)(java.lang.Object)((x).select(dafny.Helpers.unsignedToInt(pos))))));
        x = _in0;
        pos = _in1;
        acc = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetDataKeys(dafny.DafnySequence<? extends java.lang.Byte> data) {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) 1L, (long) (data).cardinalityInt()) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Unexpected end of header data.")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
    } else {
      long _1_count = (long) java.lang.Byte.toUnsignedLong(((byte)(java.lang.Object)((data).select(0))));
      Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError1 = __default.GetDataKeys2(_1_count, _1_count, data, dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>create(dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> empty(CMPEncryptedDataKey._typeDescriptor()), (long) 1L));
      if ((_2_valueOrError1).IsFailure(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>>PropagateFailure(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
      } else {
        dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long> _3_keys = (_2_valueOrError1).Extract(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
        if ((((long) ((_3_keys).dtor__0()).cardinalityInt()) == 0 ? 0 : 1) == 0) {
          return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Failure(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("At least one Data Key required")));
        } else {
          return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), _3_keys);
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetDataKeys2(long count, long origCount, dafny.DafnySequence<? extends java.lang.Byte> data, dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long> deserialized)
  {
    TAIL_CALL_START: while (true) {
      if (((count) == 0 ? 0 : 1) == 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), deserialized);
      } else if (java.lang.Long.compareUnsigned((long) ((deserialized).dtor__0()).cardinalityInt(), (long) 255L) >= 0) {
        return Wrappers_Compile.Result.<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Failure(dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Too Many Data Keys")));
      } else {
        Wrappers_Compile.Result<dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = __default.GetOneDataKey(data, (deserialized).dtor__1());
        if ((_0_valueOrError0).IsFailure(dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>>PropagateFailure(dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>_typeDescriptor(CMPEncryptedDataKeyListEmptyOK._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
        } else {
          dafny.Tuple2<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long> _1_edk = (_0_valueOrError0).Extract(dafny.Tuple2.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey, java.lang.Long>_typeDescriptor(CMPEncryptedDataKey._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
          long _in0 = (long) (long) ((count) - ((long) 1L));
          long _in1 = origCount;
          dafny.DafnySequence<? extends java.lang.Byte> _in2 = data;
          dafny.Tuple2<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long> _in3 = dafny.Tuple2.<dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>, java.lang.Long>create(dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>concatenate((deserialized).dtor__0(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(CMPEncryptedDataKey._typeDescriptor(), (_1_edk).dtor__0())), (long) (long) (((deserialized).dtor__1()) + ((_1_edk).dtor__1())));
          count = _in0;
          origCount = _in1;
          data = _in2;
          deserialized = _in3;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static long VERSION__LEN64()
  {
    return (long) 1L;
  }
  public static long FLAVOR__LEN64()
  {
    return (long) 1L;
  }
  public static long PREFIX__LEN64()
  {
    return (long) (long) (((long) (long) ((__default.VERSION__LEN64()) + (__default.FLAVOR__LEN64()))) + (StructuredEncryptionUtil_Compile.__default.MSGID__LEN64()));
  }
  public static byte ENCRYPT__AND__SIGN__LEGEND()
  {
    return (byte) 101;
  }
  public static byte SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT__LEGEND()
  {
    return (byte) 99;
  }
  public static byte SIGN__ONLY__LEGEND()
  {
    return (byte) 115;
  }
  public static long COMMITMENT__LEN64()
  {
    return (long) 32L;
  }
  public static long UINT8__LIMIT64()
  {
    return (long) 256L;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> EmptyLegend()
  {
    return dafny.DafnySequence.<java.lang.Byte> empty(LegendByte._typeDescriptor());
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionHeader._default";
  }
}
