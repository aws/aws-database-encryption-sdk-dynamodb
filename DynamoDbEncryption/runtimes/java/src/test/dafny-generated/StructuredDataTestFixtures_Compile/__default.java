// Class __default
// Dafny class __default compiled into Java
package StructuredDataTestFixtures_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager GetDefaultCMMWithKMSKeyring()
  {
    software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager cmm = null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out0;
      _out0 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
      _0_valueOrError0 = _out0;
      if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/StructuredDataTestFixtures.dfy(62,19): " + java.lang.String.valueOf(_0_valueOrError0));
      }
      software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _1_matProv;
      _1_matProv = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
      software.amazon.cryptography.materialproviders.internaldafny.types.CreateAwsKmsMultiKeyringInput _2_keyringInput;
      _2_keyringInput = software.amazon.cryptography.materialproviders.internaldafny.types.CreateAwsKmsMultiKeyringInput.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.PUBLIC__US__WEST__2__KMS__TEST__KEY()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IClientSupplier>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IClientSupplier>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IClientSupplier.class))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))));
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _3_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
      _out1 = (_1_matProv).CreateAwsKmsMultiKeyring(_2_keyringInput);
      _3_valueOrError1 = _out1;
      if (!(!((_3_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/StructuredDataTestFixtures.dfy(69,19): " + java.lang.String.valueOf(_3_valueOrError1));
      }
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _4_keyring;
      _4_keyring = (_3_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
      software.amazon.cryptography.materialproviders.internaldafny.types.CreateDefaultCryptographicMaterialsManagerInput _5_cmmInput;
      _5_cmmInput = software.amazon.cryptography.materialproviders.internaldafny.types.CreateDefaultCryptographicMaterialsManagerInput.create(_4_keyring);
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _6_valueOrError2 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out2;
      _out2 = (_1_matProv).CreateDefaultCryptographicMaterialsManager(_5_cmmInput);
      _6_valueOrError2 = _out2;
      if (!(!((_6_valueOrError2).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/StructuredDataTestFixtures.dfy(73,11): " + java.lang.String.valueOf(_6_valueOrError2));
      }
      cmm = (_6_valueOrError2).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    }
    return cmm;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> TEST__BLOB__VALUE()
  {
    return dafny.DafnySequence.<java.lang.Byte> of((byte) 33, (byte) 100, (byte) 108, (byte) 114, (byte) 111, (byte) 119, (byte) 32, (byte) 44, (byte) 111, (byte) 108, (byte) 108, (byte) 101, (byte) 104);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> TEST__TYPE__ID()
  {
    return dafny.DafnySequence.<java.lang.Byte> of((byte) 255, (byte) 255);
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> TEST__STRUCTURED__DATA()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("foo"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(__default.TEST__BLOB__VALUE(), __default.TEST__TYPE__ID())), new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(__default.TEST__BLOB__VALUE(), __default.TEST__TYPE__ID())), new dafny.Tuple2(dafny.DafnySequence.asString("fizzbuzz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(__default.TEST__BLOB__VALUE(), __default.TEST__TYPE__ID())));
  }
  public static dafny.DafnySequence<? extends Character> PUBLIC__US__WEST__2__KMS__TEST__KEY()
  {
    return dafny.DafnySequence.asString("arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f");
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> TEST__CRYPTO__SCHEMA()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("foo"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("fizzbuzz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> TEST__CRYPTO__SCHEMA__AUTH__ONLY()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("foo"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()));
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction> TEST__AUTHENTICATE__SCHEMA()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("foo"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.create_SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.create_SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("fizzbuzz"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.create_DO__NOT__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_head"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.create_DO__NOT__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_foot"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.create_DO__NOT__SIGN()));
  }
  @Override
  public java.lang.String toString() {
    return "StructuredDataTestFixtures._default";
  }
}
