// Class Footer
// Dafny class Footer compiled into Java
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
    s.append("StructuredEncryptionFooter_Compile.Footer.Footer");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tags));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._sig));
    s.append(")");
    return s.toString();
  }

  private static final Footer theDefault = StructuredEncryptionFooter_Compile.Footer.create(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(RecipientTag._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>Default());
  public static Footer Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Footer> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Footer.class, () -> Default());
  public static dafny.TypeDescriptor<Footer> _typeDescriptor() {
    return (dafny.TypeDescriptor<Footer>) (dafny.TypeDescriptor<?>) _TYPE;
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
  public Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData makeTerminal() {
    return StructuredEncryptionUtil_Compile.__default.ValueToData((this).serialize(), StructuredEncryptionUtil_Compile.__default.BYTES__TYPE__ID());
  }
  public Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> validate(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.DecryptionMaterials mat, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> edks, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> signedFields, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> encFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> encData, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> allData, dafny.DafnySequence<? extends java.lang.Byte> header)
  {
    Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(false);
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _445_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _445_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((edks).length()), java.math.BigInteger.valueOf(((this).dtor_tags()).length())), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("There are a different number of recipient tags in the stored header than there are in the decryption materials.")));
    if ((_445_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_445_valueOrError0).<Boolean>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _446_canonicalHash;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _447_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out4;
    _out4 = __default.CanonHash(signedFields, encFields, encData, allData, header, (mat).dtor_encryptionContext());
    _447_valueOrError1 = _out4;
    if ((_447_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_447_valueOrError1).<Boolean>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    _446_canonicalHash = (_447_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.Primitives.Types.HMacInput _448_input;
    _448_input = Dafny.Aws.Cryptography.Primitives.Types.HMacInput.create((((mat).dtor_algorithmSuite()).dtor_symmetricSignature()).dtor_HMAC(), ((mat).dtor_symmetricSigningKey()).dtor_value(), _446_canonicalHash);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.Primitives.Types.Error> _449_hashR;
    _449_hashR = (client).HMac(_448_input);
    dafny.DafnySequence<? extends java.lang.Byte> _450_hash;
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _451_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    _451_valueOrError2 = (_449_hashR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_452_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _452_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_452_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_452_e);
    }));
    if ((_451_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_451_valueOrError2).<Boolean>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    _450_hash = (_451_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _453_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _453_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((_450_hash).length()), java.math.BigInteger.valueOf(48L)), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Bad hash length")));
    if ((_453_valueOrError3).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_453_valueOrError3).<Boolean>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    boolean _454_foundTag;
    _454_foundTag = false;
    goto_0: {
      java.math.BigInteger _hi0 = java.math.BigInteger.valueOf(((this).dtor_tags()).length());
      for (java.math.BigInteger _455_i = java.math.BigInteger.ZERO; _455_i.compareTo(_hi0) < 0; _455_i = _455_i.add(java.math.BigInteger.ONE)) {
        continue_0: {
          if (StructuredEncryptionUtil_Compile.__default.ConstantTimeEquals(_450_hash, ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(((this).dtor_tags()).select(dafny.Helpers.toInt((_455_i))))))) {
            _454_foundTag = true;
            break goto_0;
          }
        }
      }
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _456_valueOrError4 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _456_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), _454_foundTag, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("No recipient tag matched.")));
    if ((_456_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_456_valueOrError4).<Boolean>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _457_valueOrError5 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
    _457_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (((this).dtor_sig()).is_Some()) == ((((mat).dtor_algorithmSuite()).dtor_signature()).is_ECDSA()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Internal error. Signature both does and does not exist.")));
    if ((_457_valueOrError5).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      ret = (_457_valueOrError5).<Boolean>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      return ret;
    }
    if (((this).dtor_sig()).is_Some()) {
      Dafny.Aws.Cryptography.Primitives.Types.ECDSAVerifyInput _458_verInput;
      _458_verInput = Dafny.Aws.Cryptography.Primitives.Types.ECDSAVerifyInput.create(((((mat).dtor_algorithmSuite()).dtor_signature()).dtor_ECDSA()).dtor_curve(), ((mat).dtor_verificationKey()).dtor_value(), _446_canonicalHash, ((this).dtor_sig()).dtor_value());
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.Primitives.Types.Error> _459_verR;
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.Primitives.Types.Error> _out5;
      _out5 = (client).ECDSAVerify(_458_verInput);
      _459_verR = _out5;
      boolean _460_ver;
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _461_valueOrError6 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default(false);
      _461_valueOrError6 = (_459_verR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_462_e_boxed0) -> {
        Dafny.Aws.Cryptography.Primitives.Types.Error _462_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_462_e_boxed0));
        return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_462_e);
      }));
      if ((_461_valueOrError6).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        ret = (_461_valueOrError6).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        return ret;
      }
      _460_ver = (_461_valueOrError6).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _463_valueOrError7 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
      _463_valueOrError7 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), _460_ver, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Signature did not verify")));
      if ((_463_valueOrError7).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        ret = (_463_valueOrError7).<Boolean>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        return ret;
      }
    }
    ret = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(true);
    return ret;
  }
}
