// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionFooter_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetCanonicalType(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal value, boolean isEncrypted)
  {
    long _0_value__len = (long) ((value).dtor_value()).cardinalityInt();
    if (isEncrypted) {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) 2L, _0_value__len) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad length.")));
      if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_1_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt64ToSeq((long) (long) ((_0_value__len) - ((long) 2L))), __default.ENCRYPTED()));
      }
    } else {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StandardLibrary_mUInt_Compile.__default.<java.lang.Byte>HasUint64Len(BoundedInts_Compile.uint8._typeDescriptor(), (value).dtor_value()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad length.")));
      if ((_2_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(StandardLibrary_mUInt_Compile.__default.UInt64ToSeq(_0_value__len), __default.PLAINTEXT()), (value).dtor_typeId()));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetCanonicalEncryptedField(dafny.DafnySequence<? extends java.lang.Byte> fieldName, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal value)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) 2L, (long) ((value).dtor_value()).cardinalityInt()) <= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad length.")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(fieldName, StandardLibrary_mUInt_Compile.__default.UInt64ToSeq((long) (long) (((long) ((value).dtor_value()).cardinalityInt()) - ((long) 2L)))), __default.ENCRYPTED()), (value).dtor_value()));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetCanonicalPlaintextField(dafny.DafnySequence<? extends java.lang.Byte> fieldName, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal value)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StandardLibrary_mUInt_Compile.__default.<java.lang.Byte>HasUint64Len(BoundedInts_Compile.uint8._typeDescriptor(), (value).dtor_value()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad length.")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(fieldName, StandardLibrary_mUInt_Compile.__default.UInt64ToSeq((long) ((value).dtor_value()).cardinalityInt())), __default.PLAINTEXT()), (value).dtor_typeId()), (value).dtor_value()));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetCanonicalItem(StructuredEncryptionUtil_Compile.CanonCryptoItem data) {
    if (java.util.Objects.equals((data).dtor_action(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN())) {
      return __default.GetCanonicalEncryptedField((data).dtor_key(), (data).dtor_data());
    } else {
      return __default.GetCanonicalPlaintextField((data).dtor_key(), (data).dtor_data());
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> CanonContent(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _hresult = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    long _0_i;
    _0_i = (long) (data).cardinalityInt();
    dafny.DafnySequence<? extends java.lang.Byte> _1_vectors;
    _1_vectors = dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor());
    while (((_0_i) == 0 ? 0 : 1) != 0) {
      _0_i = (long) (long) ((_0_i) - ((long) 1L));
      if (!java.util.Objects.equals((((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((data).select(dafny.Helpers.unsignedToInt(_0_i))))).dtor_action(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING())) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_test;
        _2_test = __default.GetCanonicalItem(((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((data).select(dafny.Helpers.unsignedToInt(_0_i)))));
        if ((_2_test).is_Failure()) {
          _hresult = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (_2_test).dtor_error());
          return _hresult;
        }
        _1_vectors = dafny.DafnySequence.<java.lang.Byte>concatenate((_2_test).dtor_value(), _1_vectors);
      }
    }
    _hresult = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), _1_vectors);
    return _hresult;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> CanonRecord(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data, dafny.DafnySequence<? extends java.lang.Byte> header, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> enc)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = __default.CanonContent(data);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_canon = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
      dafny.DafnySequence<? extends java.lang.Byte> _2_AAD = StructuredEncryptionHeader_Compile.__default.SerializeContext(enc);
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _3_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StandardLibrary_mUInt_Compile.__default.<java.lang.Byte>HasUint64Len(BoundedInts_Compile.uint8._typeDescriptor(), _2_AAD), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("AAD too long.")));
      if ((_3_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_3_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _4_len = StandardLibrary_mUInt_Compile.__default.UInt64ToSeq((long) (_2_AAD).cardinalityInt());
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(header, _4_len), _2_AAD), _1_canon));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> CanonHash(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data, dafny.DafnySequence<? extends java.lang.Byte> header, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> enc)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> ret = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _0_valueOrError0 = __default.CanonRecord(data, header, enc);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      ret = (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      return ret;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _1_data;
    _1_data = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _2_resultR;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
    _out0 = Digest_Compile.__default.Digest(software.amazon.cryptography.primitives.internaldafny.types.DigestInput.create(software.amazon.cryptography.primitives.internaldafny.types.DigestAlgorithm.create_SHA__384(), _1_data));
    _2_resultR = _out0;
    ret = (_2_resultR).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_3_e_boxed0) -> {
      software.amazon.cryptography.primitives.internaldafny.types.Error _3_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_3_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyPrimitives(_3_e);
    }));
    return ret;
  }
  public static Wrappers_Compile.Result<Footer, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> CreateFooter(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, software.amazon.cryptography.materialproviders.internaldafny.types.EncryptionMaterials mat, dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data, dafny.DafnySequence<? extends java.lang.Byte> header)
  {
    Wrappers_Compile.Result<Footer, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> ret = Wrappers_Compile.Result.<Footer, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(Footer._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer.Default());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out0;
      _out0 = __default.CanonHash(data, header, (mat).dtor_encryptionContext());
      _0_valueOrError0 = _out0;
      if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        ret = (_0_valueOrError0).<Footer>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
        return ret;
      }
      dafny.DafnySequence<? extends java.lang.Byte> _1_canonicalHash;
      _1_canonicalHash = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _2_tags;
      _2_tags = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(RecipientTag._typeDescriptor());
      long _hi0 = (long) ((mat).dtor_encryptedDataKeys()).cardinalityInt();
      for (long _3_i = (long) 0L; java.lang.Long.compareUnsigned(_3_i, _hi0) < 0; _3_i++) {
        software.amazon.cryptography.primitives.internaldafny.types.HMacInput _4_input;
        _4_input = software.amazon.cryptography.primitives.internaldafny.types.HMacInput.create((((mat).dtor_algorithmSuite()).dtor_symmetricSignature()).dtor_HMAC(), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((((mat).dtor_symmetricSigningKeys()).dtor_value()).select(dafny.Helpers.unsignedToInt(_3_i)))), _1_canonicalHash);
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _5_hashR;
        _5_hashR = (client).HMac(_4_input);
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
        _6_valueOrError1 = (_5_hashR).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_7_e_boxed0) -> {
          software.amazon.cryptography.primitives.internaldafny.types.Error _7_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_7_e_boxed0));
          return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyPrimitives(_7_e);
        }));
        if ((_6_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          ret = (_6_valueOrError1).<Footer>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
          return ret;
        }
        dafny.DafnySequence<? extends java.lang.Byte> _8_hash;
        _8_hash = (_6_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _9_valueOrError2 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
        _9_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((long) (_8_hash).cardinalityInt()) == ((long) 48L), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad hash length")));
        if ((_9_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          ret = (_9_valueOrError2).<Footer>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
          return ret;
        }
        _2_tags = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_2_tags, dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), _8_hash));
      }
      if ((((mat).dtor_algorithmSuite()).dtor_signature()).is_ECDSA()) {
        software.amazon.cryptography.primitives.internaldafny.types.ECDSASignInput _10_verInput;
        _10_verInput = software.amazon.cryptography.primitives.internaldafny.types.ECDSASignInput.create(((((mat).dtor_algorithmSuite()).dtor_signature()).dtor_ECDSA()).dtor_curve(), ((mat).dtor_signingKey()).dtor_value(), _1_canonicalHash);
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _11_sigR;
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
        _out1 = (client).ECDSASign(_10_verInput);
        _11_sigR = _out1;
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _12_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
        _12_valueOrError3 = (_11_sigR).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_13_e_boxed0) -> {
          software.amazon.cryptography.primitives.internaldafny.types.Error _13_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_13_e_boxed0));
          return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyPrimitives(_13_e);
        }));
        if ((_12_valueOrError3).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          ret = (_12_valueOrError3).<Footer>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
          return ret;
        }
        dafny.DafnySequence<? extends java.lang.Byte> _14_sig;
        _14_sig = (_12_valueOrError3).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _15_valueOrError4 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
        _15_valueOrError4 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((long) (_14_sig).cardinalityInt()) == (__default.SignatureSize()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Signature is "), StandardLibrary_mString_Compile.__default.Base10Int2String(java.math.BigInteger.valueOf((_14_sig).length()))), dafny.DafnySequence.asString(" bytes, should have been ")), StandardLibrary_mString_Compile.__default.Base10Int2String(dafny.Helpers.unsignedToBigInteger(__default.SignatureSize()))), dafny.DafnySequence.asString(" bytes."))));
        if ((_15_valueOrError4).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          ret = (_15_valueOrError4).<Footer>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
          return ret;
        }
        ret = Wrappers_Compile.Result.<Footer, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(Footer._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer.create(_2_tags, Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), _14_sig)));
        return ret;
      } else {
        ret = Wrappers_Compile.Result.<Footer, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(Footer._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer.create(_2_tags, Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(Signature._typeDescriptor())));
        return ret;
      }
    }
    return ret;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeTags(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> tags)
  {
    dafny.DafnySequence<? extends java.lang.Byte> _hresult = dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _0_result;
    _0_result = dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor());
    long _lo0 = (long) 0L;
    for (long _1_i = (long) (tags).cardinalityInt(); java.lang.Long.compareUnsigned(_lo0, _1_i) < 0; ) {
      _1_i--;
      _0_result = dafny.DafnySequence.<java.lang.Byte>concatenate(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((tags).select(dafny.Helpers.unsignedToInt(_1_i)))), _0_result);
    }
    _hresult = _0_result;
    return _hresult;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SerializeSig(Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> sig) {
    if ((sig).is_Some()) {
      return (sig).dtor_value();
    } else {
      return dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor());
    }
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> GatherTags(dafny.DafnySequence<? extends java.lang.Byte> data) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(RecipientTag._typeDescriptor());
    TAIL_CALL_START: while (true) {
      if ((((long) (data).cardinalityInt()) == 0 ? 0 : 1) == 0) {
        return dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
      } else {
        _0___accumulator = dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(_0___accumulator, dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), (data).subsequence(0, dafny.Helpers.unsignedToInt(__default.RecipientTagSize()))));
        dafny.DafnySequence<? extends java.lang.Byte> _in0 = (data).drop(__default.RecipientTagSize());
        data = _in0;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<Footer, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> DeserializeFooter(dafny.DafnySequence<? extends java.lang.Byte> data, boolean hasSig)
  {
    long _0_data__len = (long) (data).cardinalityInt();
    if (hasSig) {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(_0_data__len, (long) (long) ((__default.RecipientTagSize()) + (__default.SignatureSize()))) >= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Footer too short.")));
      if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_1_valueOrError0).<Footer>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (((long) java.lang.Long.remainderUnsigned((long) (long) ((_0_data__len) - (__default.SignatureSize())), __default.RecipientTagSize())) == 0 ? 0 : 1) == 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Mangled signed footer has strange size")));
        if ((_2_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_2_valueOrError1).<Footer>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<Footer, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(Footer._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer.create(__default.GatherTags((data).take((long) (long) ((_0_data__len) - (__default.SignatureSize())))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), (data).drop((long) (long) ((_0_data__len) - (__default.SignatureSize()))))));
        }
      }
    } else {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _3_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (((long) java.lang.Long.remainderUnsigned(_0_data__len, __default.RecipientTagSize())) == 0 ? 0 : 1) == 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Mangled unsigned footer has strange size")));
      if ((_3_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_3_valueOrError2).<Footer>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(_0_data__len, __default.RecipientTagSize()) >= 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Footer too short.")));
        if ((_4_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_4_valueOrError3).<Footer>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<Footer, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(Footer._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), Footer.create(__default.GatherTags(data), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(Signature._typeDescriptor())));
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> ENCRYPTED()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 69, (byte) 78, (byte) 67, (byte) 82, (byte) 89, (byte) 80, (byte) 84, (byte) 69, (byte) 68);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> PLAINTEXT()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 80, (byte) 76, (byte) 65, (byte) 73, (byte) 78, (byte) 84, (byte) 69, (byte) 88, (byte) 84);
    return _0_s;
  }
  public static long RecipientTagSize()
  {
    return (long) 48L;
  }
  public static long SignatureSize()
  {
    return (long) 103L;
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionFooter._default";
  }
}
