// Class PartialHeader
// Dafny class PartialHeader compiled into Java
package StructuredEncryptionHeader_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class PartialHeader {
  public byte _version;
  public byte _flavor;
  public dafny.DafnySequence<? extends java.lang.Byte> _msgID;
  public dafny.DafnySequence<? extends java.lang.Byte> _legend;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _encContext;
  public dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> _dataKeys;
  public PartialHeader (byte version, byte flavor, dafny.DafnySequence<? extends java.lang.Byte> msgID, dafny.DafnySequence<? extends java.lang.Byte> legend, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encContext, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> dataKeys) {
    this._version = version;
    this._flavor = flavor;
    this._msgID = msgID;
    this._legend = legend;
    this._encContext = encContext;
    this._dataKeys = dataKeys;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PartialHeader o = (PartialHeader)other;
    return true && this._version == o._version && this._flavor == o._flavor && java.util.Objects.equals(this._msgID, o._msgID) && java.util.Objects.equals(this._legend, o._legend) && java.util.Objects.equals(this._encContext, o._encContext) && java.util.Objects.equals(this._dataKeys, o._dataKeys);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Byte.hashCode(this._version);
    hash = ((hash << 5) + hash) + java.lang.Byte.hashCode(this._flavor);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._msgID);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._legend);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encContext);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._dataKeys);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("StructuredEncryptionHeader_Compile.PartialHeader.PartialHeader");
    s.append("(");
    s.append(this._version);
    s.append(", ");
    s.append(this._flavor);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._msgID));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._legend));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encContext));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._dataKeys));
    s.append(")");
    return s.toString();
  }

  private static final PartialHeader theDefault = StructuredEncryptionHeader_Compile.PartialHeader.create(Version.defaultValue(), (byte) 0, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> empty(LegendByte._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty(), dafny.DafnySequence.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> empty(CMPEncryptedDataKey._typeDescriptor()));
  public static PartialHeader Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<PartialHeader> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(PartialHeader.class, () -> Default());
  public static dafny.TypeDescriptor<PartialHeader> _typeDescriptor() {
    return (dafny.TypeDescriptor<PartialHeader>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static PartialHeader create(byte version, byte flavor, dafny.DafnySequence<? extends java.lang.Byte> msgID, dafny.DafnySequence<? extends java.lang.Byte> legend, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encContext, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> dataKeys) {
    return new PartialHeader(version, flavor, msgID, legend, encContext, dataKeys);
  }
  public static PartialHeader create_PartialHeader(byte version, byte flavor, dafny.DafnySequence<? extends java.lang.Byte> msgID, dafny.DafnySequence<? extends java.lang.Byte> legend, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encContext, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> dataKeys) {
    return create(version, flavor, msgID, legend, encContext, dataKeys);
  }
  public boolean is_PartialHeader() { return true; }
  public byte dtor_version() {
    return this._version;
  }
  public byte dtor_flavor() {
    return this._flavor;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_msgID() {
    return this._msgID;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_legend() {
    return this._legend;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_encContext() {
    return this._encContext;
  }
  public dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> dtor_dataKeys() {
    return this._dataKeys;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> serialize() {
    dafny.DafnySequence<? extends java.lang.Byte> _312_context = __default.SerializeContext((this).dtor_encContext());
    dafny.DafnySequence<? extends java.lang.Byte> _313_keys = __default.SerializeDataKeys((this).dtor_dataKeys());
    dafny.DafnySequence<? extends java.lang.Byte> _314_leg = __default.SerializeLegend((this).dtor_legend());
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.of((this).dtor_version()), dafny.DafnySequence.of((this).dtor_flavor())), (this).dtor_msgID()), _314_leg), _312_context), _313_keys);
  }
  public Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> verifyCommitment(Dafny.Aws.Cryptography.Primitives.Types.IAwsCryptographicPrimitivesClient client, Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> commitKey, dafny.DafnySequence<? extends java.lang.Byte> data)
  {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _315_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), (__default.COMMITMENT__LEN()).compareTo(java.math.BigInteger.valueOf((data).length())) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Serialized header too short")));
    if ((_315_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      return (_315_valueOrError0).<Boolean>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _316_storedCommitment = (data).drop((java.math.BigInteger.valueOf((data).length())).subtract(__default.COMMITMENT__LEN()));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _317_valueOrError1 = __default.CalculateHeaderCommitment(client, alg, commitKey, (data).take((java.math.BigInteger.valueOf((data).length())).subtract(__default.COMMITMENT__LEN())));
      if ((_317_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
        return (_317_valueOrError1).<Boolean>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _318_calcCommitment = (_317_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _319_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ConstantTimeEquals(_316_storedCommitment, _318_calcCommitment), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Key commitment mismatch.")));
        if ((_319_valueOrError2).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          return (_319_valueOrError2).<Boolean>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        } else {
          return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(true);
        }
      }
    }
  }
  public Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> GetAlgorithmSuite(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient matProv)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> ret = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _320_algorithmSuiteR;
      _320_algorithmSuiteR = (matProv).GetAlgorithmSuiteInfo(dafny.DafnySequence.of(StructuredEncryptionUtil_Compile.__default.DbeAlgorithmFamily(), ((this).dtor_flavor())));
      if ((_320_algorithmSuiteR).is_Success()) {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _321_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Default();
        _321_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>Need(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidSuite((_320_algorithmSuiteR).dtor_value()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Algorithm Suite")));
        if ((_321_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
          ret = (_321_valueOrError0).<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo._typeDescriptor());
          return ret;
        }
        ret = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success((_320_algorithmSuiteR).dtor_value());
        return ret;
      } else {
        ret = (_320_algorithmSuiteR).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.Types.AlgorithmSuiteInfo._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_322_e_boxed0) -> {
          Dafny.Aws.Cryptography.MaterialProviders.Types.Error _322_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_322_e_boxed0));
          return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyMaterialProviders(_322_e);
        }));
        return ret;
      }
    }
    return ret;
  }
}
