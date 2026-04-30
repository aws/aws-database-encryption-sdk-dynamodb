// Class Footer
// Dafny class Footer compiled into Java
package StructuredEncryptionFooter_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Footer {
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _tags;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> _sig;
  public Footer (dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> tags, Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> sig) {
    this._tags = tags;
    this._sig = sig;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Footer o = (Footer)other;
    return true && java.util.Objects.equals(this._tags, o._tags) && java.util.Objects.equals(this._sig, o._sig);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tags);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sig);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("StructuredEncryptionFooter.Footer.Footer");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tags));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._sig));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<Footer> _TYPE = dafny.TypeDescriptor.<Footer>referenceWithInitializer(Footer.class, () -> Footer.Default());
  public static dafny.TypeDescriptor<Footer> _typeDescriptor() {
    return (dafny.TypeDescriptor<Footer>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Footer theDefault = Footer.create(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(RecipientTag._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>Default(Signature._typeDescriptor()));
  public static Footer Default() {
    return theDefault;
  }
  public static Footer create(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> tags, Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> sig) {
    return new Footer(tags, sig);
  }
  public static Footer create_Footer(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> tags, Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> sig) {
    return create(tags, sig);
  }
  public boolean is_Footer() { return true; }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_tags() {
    return this._tags;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>> dtor_sig() {
    return this._sig;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> serialize() {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(__default.SerializeTags((this).dtor_tags()), __default.SerializeSig((this).dtor_sig()));
  }
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal makeTerminal() {
    return StructuredEncryptionUtil_Compile.__default.ValueToData((this).serialize(), StructuredEncryptionUtil_Compile.__default.BYTES__TYPE__ID());
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> validate(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, software.amazon.cryptography.materialproviders.internaldafny.types.DecryptionMaterials mat, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> edks, dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> data, dafny.DafnySequence<? extends java.lang.Byte> header)
  {
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), false);
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((long) (edks).cardinalityInt()) == ((long) ((this).dtor_tags()).cardinalityInt()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("There are a different number of recipient tags in the stored header than there are in the decryption materials.")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      ret = (_0_valueOrError0).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out0;
    _out0 = __default.CanonHash(data, header, (mat).dtor_encryptionContext());
    _1_valueOrError1 = _out0;
    if ((_1_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      ret = (_1_valueOrError1).<Boolean>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _2_canonicalHash;
    _2_canonicalHash = (_1_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.primitives.internaldafny.types.HMacInput _3_input;
    _3_input = software.amazon.cryptography.primitives.internaldafny.types.HMacInput.create((((mat).dtor_algorithmSuite()).dtor_symmetricSignature()).dtor_HMAC(), ((mat).dtor_symmetricSigningKey()).dtor_value(), _2_canonicalHash);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.primitives.internaldafny.types.Error> _4_hashR;
    _4_hashR = (client).HMac(_3_input);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _5_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _5_valueOrError2 = (_4_hashR).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_6_e_boxed0) -> {
      software.amazon.cryptography.primitives.internaldafny.types.Error _6_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_6_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyPrimitives(_6_e);
    }));
    if ((_5_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      ret = (_5_valueOrError2).<Boolean>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _7_hash;
    _7_hash = (_5_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _8_valueOrError3 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    _8_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((long) (_7_hash).cardinalityInt()) == ((long) 48L), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad hash length")));
    if ((_8_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      ret = (_8_valueOrError3).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    boolean _9_foundTag;
    _9_foundTag = false;
    goto_0: {
      long _hi0 = (long) ((this).dtor_tags()).cardinalityInt();
      for (long _10_i = (long) 0L; java.lang.Long.compareUnsigned(_10_i, _hi0) < 0; _10_i++) {
        continue_0: {
          if (StructuredEncryptionUtil_Compile.__default.ConstantTimeEquals(_7_hash, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(((this).dtor_tags()).select(dafny.Helpers.unsignedToInt(_10_i)))))) {
            _9_foundTag = true;
            break goto_0;
          }
        }
      }
    }
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _11_valueOrError4 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    _11_valueOrError4 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), _9_foundTag, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Signature of record does not match the signature computed when the record was encrypted.")));
    if ((_11_valueOrError4).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      ret = (_11_valueOrError4).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _12_valueOrError5 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    _12_valueOrError5 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (((this).dtor_sig()).is_Some()) == ((((mat).dtor_algorithmSuite()).dtor_signature()).is_ECDSA()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Internal error. Signature both does and does not exist.")));
    if ((_12_valueOrError5).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      ret = (_12_valueOrError5).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    if (((this).dtor_sig()).is_Some()) {
      software.amazon.cryptography.primitives.internaldafny.types.ECDSAVerifyInput _13_verInput;
      _13_verInput = software.amazon.cryptography.primitives.internaldafny.types.ECDSAVerifyInput.create(((((mat).dtor_algorithmSuite()).dtor_signature()).dtor_ECDSA()).dtor_curve(), ((mat).dtor_verificationKey()).dtor_value(), _2_canonicalHash, ((this).dtor_sig()).dtor_value());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.primitives.internaldafny.types.Error> _14_verR;
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.primitives.internaldafny.types.Error> _out1;
      _out1 = (client).ECDSAVerify(_13_verInput);
      _14_verR = _out1;
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _15_valueOrError6 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), false);
      _15_valueOrError6 = (_14_verR).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_16_e_boxed0) -> {
        software.amazon.cryptography.primitives.internaldafny.types.Error _16_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_16_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyPrimitives(_16_e);
      }));
      if ((_15_valueOrError6).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        ret = (_15_valueOrError6).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        return ret;
      }
      boolean _17_ver;
      _17_ver = (_15_valueOrError6).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _18_valueOrError7 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
      _18_valueOrError7 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), _17_ver, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Signature did not verify")));
      if ((_18_valueOrError7).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        ret = (_18_valueOrError7).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        return ret;
      }
    }
    ret = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), true);
    return ret;
  }
}
