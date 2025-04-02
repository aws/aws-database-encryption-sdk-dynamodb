// Package IntermediateKeyWrapping
// Dafny module IntermediateKeyWrapping compiled into Go

package IntermediateKeyWrapping

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_Com_Amazonaws_Dynamodb "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/Com_Amazonaws_Dynamodb"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_Com_Amazonaws_Kms "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/Com_Amazonaws_Kms"
	m_AlgorithmSuites "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AlgorithmSuites"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreOperations"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
	m_AtomicPrimitives "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AtomicPrimitives"
	m_AwsCryptographyPrimitivesOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesOperations"
	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
	m_HKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HKDF"
	m_KdfCtr "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/KdfCtr"
	m_Random "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Random"
	m_WrappedHKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/WrappedHKDF"
	m_WrappedHMAC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/WrappedHMAC"
	m_Actions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Actions"
	m_Base64 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Base64"
	m_Base64Lemmas "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Base64Lemmas"
	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_DivInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternals"
	m_DivInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternalsNonlinear"
	m_DivMod "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivMod"
	m_FileIO "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FileIO"
	m_FloatCompare "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FloatCompare"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m_GeneralInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GeneralInternals"
	m_GetOpt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GetOpt"
	m_HexStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/HexStrings"
	m_Logarithm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Logarithm"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_ModInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/ModInternals"
	m_ModInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/ModInternalsNonlinear"
	m_Mul "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Mul"
	m_MulInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/MulInternals"
	m_MulInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/MulInternalsNonlinear"
	m_Power "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Power"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq"
	m_Seq_MergeSort "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq_MergeSort"
	m_Sorting "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Sorting"
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m__System "github.com/dafny-lang/DafnyRuntimeGo/v4/System_"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

var _ = os.Args
var _ _dafny.Dummy__
var _ m__System.Dummy__
var _ m_Wrappers.Dummy__
var _ m_BoundedInts.Dummy__
var _ m_StandardLibrary_UInt.Dummy__
var _ m_StandardLibrary_Sequence.Dummy__
var _ m_StandardLibrary_String.Dummy__
var _ m_StandardLibrary.Dummy__
var _ m_AwsCryptographyPrimitivesTypes.Dummy__
var _ m_Random.Dummy__
var _ m_Digest.Dummy__
var _ m_WrappedHMAC.Dummy__
var _ m_HKDF.Dummy__
var _ m_WrappedHKDF.Dummy__
var _ m_KdfCtr.Dummy__
var _ m_AwsCryptographyPrimitivesOperations.Dummy__
var _ m_AtomicPrimitives.Dummy__
var _ m_ComAmazonawsDynamodbTypes.Dummy__
var _ m_ComAmazonawsKmsTypes.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m__Unicode.Dummy__
var _ m_Functions.Dummy__
var _ m_Utf8EncodingForm.Dummy__
var _ m_Utf16EncodingForm.Dummy__
var _ m_UnicodeStrings.Dummy__
var _ m_FileIO.Dummy__
var _ m_GeneralInternals.Dummy__
var _ m_MulInternalsNonlinear.Dummy__
var _ m_MulInternals.Dummy__
var _ m_Mul.Dummy__
var _ m_ModInternalsNonlinear.Dummy__
var _ m_DivInternalsNonlinear.Dummy__
var _ m_ModInternals.Dummy__
var _ m_DivInternals.Dummy__
var _ m_DivMod.Dummy__
var _ m_Power.Dummy__
var _ m_Logarithm.Dummy__
var _ m_StandardLibraryInterop.Dummy__
var _ m_Streams.Dummy__
var _ m_Sorting.Dummy__
var _ m_HexStrings.Dummy__
var _ m_GetOpt.Dummy__
var _ m_FloatCompare.Dummy__
var _ m_Base64.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_Actions.Dummy__
var _ m_AwsCryptographyKeyStoreTypes.Dummy__
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_AwsArnParsing.Dummy__
var _ m_AwsKmsMrkMatchForDecrypt.Dummy__
var _ m_AwsKmsUtils.Dummy__
var _ m_KeyStoreErrorMessages.Dummy__
var _ m_KmsArn.Dummy__
var _ m_Structure.Dummy__
var _ m_KMSKeystoreOperations.Dummy__
var _ m_DDBKeystoreOperations.Dummy__
var _ m_CreateKeys.Dummy__
var _ m_CreateKeyStoreTable.Dummy__
var _ m_GetKeys.Dummy__
var _ m_AwsCryptographyKeyStoreOperations.Dummy__
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
var _ m_KeyStore.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_MultiKeyring.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_Constants.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__

type Dummy__ struct{}

// Definition of class Default__
type Default__ struct {
	dummy byte
}

func New_Default___() *Default__ {
	_this := Default__{}

	return &_this
}

type CompanionStruct_Default___ struct {
}

var Companion_Default___ = CompanionStruct_Default___{}

func (_this *Default__) Equals(other *Default__) bool {
	return _this == other
}

func (_this *Default__) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*Default__)
	return ok && _this.Equals(other)
}

func (*Default__) String() string {
	return "IntermediateKeyWrapping.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IntermediateUnwrap(unwrap m_MaterialWrapping.UnwrapMaterial, wrappedMaterial _dafny.Sequence, algorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, encryptionContext _dafny.Map) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_maybeCrypto m_Wrappers.Result
	_ = _0_maybeCrypto
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_0_maybeCrypto = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeCrypto).MapFailure(func(coer38 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg39 interface{}) interface{} {
			return coer38(arg39.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_cryptoPrimitivesX m_AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClient
	_ = _3_cryptoPrimitivesX
	_3_cryptoPrimitivesX = (_1_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _4_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _4_cryptoPrimitives
	_4_cryptoPrimitives = _3_cryptoPrimitivesX.(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_DeserializedIntermediateWrappedMaterial_.Default())
	_ = _5_valueOrError1
	_5_valueOrError1 = Companion_Default___.DeserializeIntermediateWrappedMaterial(wrappedMaterial, algorithmSuite)
	if (_5_valueOrError1).IsFailure() {
		res = (_5_valueOrError1).PropagateFailure()
		return res
	}
	var _6_deserializedWrapped DeserializedIntermediateWrappedMaterial
	_ = _6_deserializedWrapped
	_6_deserializedWrapped = (_5_valueOrError1).Extract().(DeserializedIntermediateWrappedMaterial)
	var _let_tmp_rhs0 DeserializedIntermediateWrappedMaterial = _6_deserializedWrapped
	_ = _let_tmp_rhs0
	var _7_encryptedPdk _dafny.Sequence = _let_tmp_rhs0.Get_().(DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial).EncryptedPdk
	_ = _7_encryptedPdk
	var _8_providerWrappedIkm _dafny.Sequence = _let_tmp_rhs0.Get_().(DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial).ProviderWrappedIkm
	_ = _8_providerWrappedIkm
	var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _9_valueOrError2
	var _out1 interface{}
	_ = _out1
	_out1 = (unwrap).Invoke(m_MaterialWrapping.Companion_UnwrapInput_.Create_UnwrapInput_(_8_providerWrappedIkm, algorithmSuite, encryptionContext))
	_9_valueOrError2 = _out1.(m_Wrappers.Result)
	if (_9_valueOrError2).IsFailure() {
		res = (_9_valueOrError2).PropagateFailure()
		return res
	}
	var _10_unwrapOutput m_MaterialWrapping.UnwrapOutput
	_ = _10_unwrapOutput
	_10_unwrapOutput = (_9_valueOrError2).Extract().(m_MaterialWrapping.UnwrapOutput)
	var _let_tmp_rhs1 m_MaterialWrapping.UnwrapOutput = _10_unwrapOutput
	_ = _let_tmp_rhs1
	var _11_intermediateMaterial _dafny.Sequence = _let_tmp_rhs1.Get_().(m_MaterialWrapping.UnwrapOutput_UnwrapOutput).UnwrappedMaterial
	_ = _11_intermediateMaterial
	var _12_unwrapInfo interface{} = _let_tmp_rhs1.Get_().(m_MaterialWrapping.UnwrapOutput_UnwrapOutput).UnwrapInfo
	_ = _12_unwrapInfo
	var _13_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_PdkEncryptionAndSymmetricSigningKeys_.Default())
	_ = _13_valueOrError3
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = Companion_Default___.DeriveKeysFromIntermediateMaterial(_11_intermediateMaterial, algorithmSuite, encryptionContext, _4_cryptoPrimitives)
	_13_valueOrError3 = _out2
	if (_13_valueOrError3).IsFailure() {
		res = (_13_valueOrError3).PropagateFailure()
		return res
	}
	var _14_derivedKeys PdkEncryptionAndSymmetricSigningKeys
	_ = _14_derivedKeys
	_14_derivedKeys = (_13_valueOrError3).Extract().(PdkEncryptionAndSymmetricSigningKeys)
	var _let_tmp_rhs2 PdkEncryptionAndSymmetricSigningKeys = _14_derivedKeys
	_ = _let_tmp_rhs2
	var _15_pdkEncryptionKey _dafny.Sequence = _let_tmp_rhs2.Get_().(PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys).PdkEncryptionKey
	_ = _15_pdkEncryptionKey
	var _16_symmetricSigningKey _dafny.Sequence = _let_tmp_rhs2.Get_().(PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys).SymmetricSigningKey
	_ = _16_symmetricSigningKey
	var _17_iv _dafny.Sequence
	_ = _17_iv
	_17_iv = _dafny.SeqCreate((_dafny.IntOfInt32(m_AlgorithmSuites.Companion_Default___.GetEncryptIvLength(algorithmSuite))).Uint32(), func(coer39 func(_dafny.Int) uint8) func(_dafny.Int) interface{} {
		return func(arg40 _dafny.Int) interface{} {
			return coer39(arg40)
		}
	}(func(_18___v0 _dafny.Int) uint8 {
		return uint8(0)
	}))
	var _19_tagIndex _dafny.Int
	_ = _19_tagIndex
	_19_tagIndex = (_dafny.IntOfUint32((_7_encryptedPdk).Cardinality())).Minus(_dafny.IntOfInt32(m_AlgorithmSuites.Companion_Default___.GetEncryptTagLength(algorithmSuite)))
	var _20_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _20_valueOrError4
	_20_valueOrError4 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD(encryptionContext)
	if (_20_valueOrError4).IsFailure() {
		res = (_20_valueOrError4).PropagateFailure()
		return res
	}
	var _21_aad _dafny.Sequence
	_ = _21_aad
	_21_aad = (_20_valueOrError4).Extract().(_dafny.Sequence)
	var _22_decInput m_AwsCryptographyPrimitivesTypes.AESDecryptInput
	_ = _22_decInput
	_22_decInput = m_AwsCryptographyPrimitivesTypes.Companion_AESDecryptInput_.Create_AESDecryptInput_(((algorithmSuite).Dtor_encrypt()).Dtor_AES__GCM(), _15_pdkEncryptionKey, (_7_encryptedPdk).Take((_19_tagIndex).Uint32()), (_7_encryptedPdk).Drop((_19_tagIndex).Uint32()), _17_iv, _21_aad)
	var _23_decOutR m_Wrappers.Result
	_ = _23_decOutR
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_4_cryptoPrimitives).AESDecrypt(_22_decInput)
	_23_decOutR = _out3
	var _24_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _24_valueOrError5
	_24_valueOrError5 = (_23_decOutR).MapFailure(func(coer40 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg41 interface{}) interface{} {
			return coer40(arg41.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_25_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_25_e)
	}))
	if (_24_valueOrError5).IsFailure() {
		res = (_24_valueOrError5).PropagateFailure()
		return res
	}
	var _26_plaintextDataKey _dafny.Sequence
	_ = _26_plaintextDataKey
	_26_plaintextDataKey = (_24_valueOrError5).Extract().(_dafny.Sequence)
	var _27_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _27_valueOrError6
	_27_valueOrError6 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_26_plaintextDataKey).Cardinality())).Cmp(_dafny.IntOfInt32(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(algorithmSuite))) == 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Unexpected AES_GCM Decrypt length")))
	if (_27_valueOrError6).IsFailure() {
		res = (_27_valueOrError6).PropagateFailure()
		return res
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(Companion_IntermediateUnwrapOutput_.Create_IntermediateUnwrapOutput_(_26_plaintextDataKey, _16_symmetricSigningKey, _12_unwrapInfo))
	return res
	return res
}
func (_static *CompanionStruct_Default___) IntermediateWrap(generateAndWrap m_MaterialWrapping.GenerateAndWrapMaterial, plaintextDataKey _dafny.Sequence, algorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, encryptionContext _dafny.Map) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_maybeCrypto m_Wrappers.Result
	_ = _0_maybeCrypto
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_0_maybeCrypto = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeCrypto).MapFailure(func(coer41 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg42 interface{}) interface{} {
			return coer41(arg42.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_cryptoPrimitivesX m_AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClient
	_ = _3_cryptoPrimitivesX
	_3_cryptoPrimitivesX = (_1_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _4_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _4_cryptoPrimitives
	_4_cryptoPrimitives = _3_cryptoPrimitivesX.(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError1
	var _out1 interface{}
	_ = _out1
	_out1 = (generateAndWrap).Invoke(m_MaterialWrapping.Companion_GenerateAndWrapInput_.Create_GenerateAndWrapInput_(algorithmSuite, encryptionContext))
	_5_valueOrError1 = _out1.(m_Wrappers.Result)
	if (_5_valueOrError1).IsFailure() {
		res = (_5_valueOrError1).PropagateFailure()
		return res
	}
	var _6_generateAndWrapOutput m_MaterialWrapping.GenerateAndWrapOutput
	_ = _6_generateAndWrapOutput
	_6_generateAndWrapOutput = (_5_valueOrError1).Extract().(m_MaterialWrapping.GenerateAndWrapOutput)
	var _let_tmp_rhs0 m_MaterialWrapping.GenerateAndWrapOutput = _6_generateAndWrapOutput
	_ = _let_tmp_rhs0
	var _7_intermediateMaterial _dafny.Sequence = _let_tmp_rhs0.Get_().(m_MaterialWrapping.GenerateAndWrapOutput_GenerateAndWrapOutput).PlaintextMaterial
	_ = _7_intermediateMaterial
	var _8_providerWrappedIkm _dafny.Sequence = _let_tmp_rhs0.Get_().(m_MaterialWrapping.GenerateAndWrapOutput_GenerateAndWrapOutput).WrappedMaterial
	_ = _8_providerWrappedIkm
	var _9_wrapInfo interface{} = _let_tmp_rhs0.Get_().(m_MaterialWrapping.GenerateAndWrapOutput_GenerateAndWrapOutput).WrapInfo
	_ = _9_wrapInfo
	var _10_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_PdkEncryptionAndSymmetricSigningKeys_.Default())
	_ = _10_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = Companion_Default___.DeriveKeysFromIntermediateMaterial(_7_intermediateMaterial, algorithmSuite, encryptionContext, _4_cryptoPrimitives)
	_10_valueOrError2 = _out2
	if (_10_valueOrError2).IsFailure() {
		res = (_10_valueOrError2).PropagateFailure()
		return res
	}
	var _11_derivedKeys PdkEncryptionAndSymmetricSigningKeys
	_ = _11_derivedKeys
	_11_derivedKeys = (_10_valueOrError2).Extract().(PdkEncryptionAndSymmetricSigningKeys)
	var _let_tmp_rhs1 PdkEncryptionAndSymmetricSigningKeys = _11_derivedKeys
	_ = _let_tmp_rhs1
	var _12_pdkEncryptionKey _dafny.Sequence = _let_tmp_rhs1.Get_().(PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys).PdkEncryptionKey
	_ = _12_pdkEncryptionKey
	var _13_symmetricSigningKey _dafny.Sequence = _let_tmp_rhs1.Get_().(PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys).SymmetricSigningKey
	_ = _13_symmetricSigningKey
	var _14_iv _dafny.Sequence
	_ = _14_iv
	_14_iv = _dafny.SeqCreate((_dafny.IntOfInt32(m_AlgorithmSuites.Companion_Default___.GetEncryptIvLength(algorithmSuite))).Uint32(), func(coer42 func(_dafny.Int) uint8) func(_dafny.Int) interface{} {
		return func(arg43 _dafny.Int) interface{} {
			return coer42(arg43)
		}
	}(func(_15___v1 _dafny.Int) uint8 {
		return uint8(0)
	}))
	var _16_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _16_valueOrError3
	_16_valueOrError3 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD(encryptionContext)
	if (_16_valueOrError3).IsFailure() {
		res = (_16_valueOrError3).PropagateFailure()
		return res
	}
	var _17_aad _dafny.Sequence
	_ = _17_aad
	_17_aad = (_16_valueOrError3).Extract().(_dafny.Sequence)
	var _18_encInput m_AwsCryptographyPrimitivesTypes.AESEncryptInput
	_ = _18_encInput
	_18_encInput = m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptInput_.Create_AESEncryptInput_(((algorithmSuite).Dtor_encrypt()).Dtor_AES__GCM(), _14_iv, _12_pdkEncryptionKey, plaintextDataKey, _17_aad)
	var _19_encOutR m_Wrappers.Result
	_ = _19_encOutR
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_4_cryptoPrimitives).AESEncrypt(_18_encInput)
	_19_encOutR = _out3
	var _20_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
	_ = _20_valueOrError4
	_20_valueOrError4 = (_19_encOutR).MapFailure(func(coer43 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg44 interface{}) interface{} {
			return coer43(arg44.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_21_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_21_e)
	}))
	if (_20_valueOrError4).IsFailure() {
		res = (_20_valueOrError4).PropagateFailure()
		return res
	}
	var _22_encryptedPdk m_AwsCryptographyPrimitivesTypes.AESEncryptOutput
	_ = _22_encryptedPdk
	_22_encryptedPdk = (_20_valueOrError4).Extract().(m_AwsCryptographyPrimitivesTypes.AESEncryptOutput)
	var _23_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _23_valueOrError5
	_23_valueOrError5 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_dafny.Companion_Sequence_.Concatenate((_22_encryptedPdk).Dtor_cipherText(), (_22_encryptedPdk).Dtor_authTag())).Cardinality())).Cmp(_dafny.IntOfInt32((m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(algorithmSuite))+(m_AlgorithmSuites.Companion_Default___.GetEncryptTagLength(algorithmSuite)))) == 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Unexpected AES_GCM Encrypt length")))
	if (_23_valueOrError5).IsFailure() {
		res = (_23_valueOrError5).PropagateFailure()
		return res
	}
	var _24_serializedMaterial _dafny.Sequence
	_ = _24_serializedMaterial
	_24_serializedMaterial = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((_22_encryptedPdk).Dtor_cipherText(), (_22_encryptedPdk).Dtor_authTag()), _8_providerWrappedIkm)
	res = m_Wrappers.Companion_Result_.Create_Success_(Companion_IntermediateWrapOutput_.Create_IntermediateWrapOutput_(_24_serializedMaterial, _13_symmetricSigningKey, _9_wrapInfo))
	return res
	return res
}
func (_static *CompanionStruct_Default___) IntermediateGenerateAndWrap(generateAndWrap m_MaterialWrapping.GenerateAndWrapMaterial, algorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, encryptionContext _dafny.Map) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_maybeCrypto m_Wrappers.Result
	_ = _0_maybeCrypto
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_0_maybeCrypto = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeCrypto).MapFailure(func(coer44 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg45 interface{}) interface{} {
			return coer44(arg45.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _3_cryptoPrimitives
	_3_cryptoPrimitives = (_1_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _4_generateBytesResult m_Wrappers.Result
	_ = _4_generateBytesResult
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (_3_cryptoPrimitives).GenerateRandomBytes(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(algorithmSuite)))
	_4_generateBytesResult = _out1
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _5_valueOrError1
	_5_valueOrError1 = (_4_generateBytesResult).MapFailure(func(coer45 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg46 interface{}) interface{} {
			return coer45(arg46.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_6_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_6_e)
	}))
	if (_5_valueOrError1).IsFailure() {
		res = (_5_valueOrError1).PropagateFailure()
		return res
	}
	var _7_plaintextDataKey _dafny.Sequence
	_ = _7_plaintextDataKey
	_7_plaintextDataKey = (_5_valueOrError1).Extract().(_dafny.Sequence)
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _8_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = Companion_Default___.IntermediateWrap(generateAndWrap, _7_plaintextDataKey, algorithmSuite, encryptionContext)
	_8_valueOrError2 = _out2
	if (_8_valueOrError2).IsFailure() {
		res = (_8_valueOrError2).PropagateFailure()
		return res
	}
	var _9_wrapOutput IntermediateWrapOutput
	_ = _9_wrapOutput
	_9_wrapOutput = (_8_valueOrError2).Extract().(IntermediateWrapOutput)
	res = m_Wrappers.Companion_Result_.Create_Success_(Companion_IntermediateGenerateAndWrapOutput_.Create_IntermediateGenerateAndWrapOutput_(_7_plaintextDataKey, (_9_wrapOutput).Dtor_wrappedMaterial(), (_9_wrapOutput).Dtor_symmetricSigningKey(), (_9_wrapOutput).Dtor_wrapInfo()))
	return res
	return res
}
func (_static *CompanionStruct_Default___) DeserializeIntermediateWrappedMaterial(material _dafny.Sequence, algSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((material).Cardinality())).Cmp(_dafny.IntOfInt32((m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(algSuite))+(m_AlgorithmSuites.Companion_Default___.GetEncryptTagLength(algSuite)))) >= 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Unable to deserialize Intermediate Key Wrapped material: too short.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_encryptedPdkLen int32 = (m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(algSuite)) + (m_AlgorithmSuites.Companion_Default___.GetEncryptTagLength(algSuite))
		_ = _1_encryptedPdkLen
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_DeserializedIntermediateWrappedMaterial_.Create_DeserializedIntermediateWrappedMaterial_((material).Take(uint32(_1_encryptedPdkLen)), (material).Drop(uint32(_1_encryptedPdkLen))))
	}
}
func (_static *CompanionStruct_Default___) DeriveKeysFromIntermediateMaterial(intermediateMaterial _dafny.Sequence, algorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, encryptionContext _dafny.Map, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_PdkEncryptionAndSymmetricSigningKeys_.Default())
	_ = res
	var _0_hkdfExtractInput m_AwsCryptographyPrimitivesTypes.HkdfExtractInput
	_ = _0_hkdfExtractInput
	_0_hkdfExtractInput = m_AwsCryptographyPrimitivesTypes.Companion_HkdfExtractInput_.Create_HkdfExtractInput_((((algorithmSuite).Dtor_commitment()).Dtor_HKDF()).Dtor_hmac(), m_Wrappers.Companion_Option_.Create_None_(), intermediateMaterial)
	var _1_maybePseudoRandomKey m_Wrappers.Result
	_ = _1_maybePseudoRandomKey
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (cryptoPrimitives).HkdfExtract(_0_hkdfExtractInput)
	_1_maybePseudoRandomKey = _out0
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError0
	_2_valueOrError0 = (_1_maybePseudoRandomKey).MapFailure(func(coer46 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg47 interface{}) interface{} {
			return coer46(arg47.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_3_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_3_e)
	}))
	if (_2_valueOrError0).IsFailure() {
		res = (_2_valueOrError0).PropagateFailure()
		return res
	}
	var _4_pseudoRandomKey _dafny.Sequence
	_ = _4_pseudoRandomKey
	_4_pseudoRandomKey = (_2_valueOrError0).Extract().(_dafny.Sequence)
	var _5_symmetricSigningKeyInput m_AwsCryptographyPrimitivesTypes.HkdfExpandInput
	_ = _5_symmetricSigningKeyInput
	_5_symmetricSigningKeyInput = m_AwsCryptographyPrimitivesTypes.Companion_HkdfExpandInput_.Create_HkdfExpandInput_((((algorithmSuite).Dtor_commitment()).Dtor_HKDF()).Dtor_hmac(), _4_pseudoRandomKey, Companion_Default___.KEYWRAP__MAC__INFO(), (((algorithmSuite).Dtor_commitment()).Dtor_HKDF()).Dtor_outputKeyLength())
	var _6_pdkEncryptionKeyInput m_AwsCryptographyPrimitivesTypes.HkdfExpandInput
	_ = _6_pdkEncryptionKeyInput
	var _7_dt__update__tmp_h0 m_AwsCryptographyPrimitivesTypes.HkdfExpandInput = _5_symmetricSigningKeyInput
	_ = _7_dt__update__tmp_h0
	var _8_dt__update_hinfo_h0 _dafny.Sequence = Companion_Default___.KEYWRAP__ENC__INFO()
	_ = _8_dt__update_hinfo_h0
	_6_pdkEncryptionKeyInput = m_AwsCryptographyPrimitivesTypes.Companion_HkdfExpandInput_.Create_HkdfExpandInput_((_7_dt__update__tmp_h0).Dtor_digestAlgorithm(), (_7_dt__update__tmp_h0).Dtor_prk(), _8_dt__update_hinfo_h0, (_7_dt__update__tmp_h0).Dtor_expectedLength())
	var _9_maybeSymmetricSigningKey m_Wrappers.Result
	_ = _9_maybeSymmetricSigningKey
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (cryptoPrimitives).HkdfExpand(_5_symmetricSigningKeyInput)
	_9_maybeSymmetricSigningKey = _out1
	var _10_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError1
	_10_valueOrError1 = (_9_maybeSymmetricSigningKey).MapFailure(func(coer47 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg48 interface{}) interface{} {
			return coer47(arg48.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_11_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_11_e)
	}))
	if (_10_valueOrError1).IsFailure() {
		res = (_10_valueOrError1).PropagateFailure()
		return res
	}
	var _12_symmetricSigningKey _dafny.Sequence
	_ = _12_symmetricSigningKey
	_12_symmetricSigningKey = (_10_valueOrError1).Extract().(_dafny.Sequence)
	var _13_maybePdkEncryptionKey m_Wrappers.Result
	_ = _13_maybePdkEncryptionKey
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (cryptoPrimitives).HkdfExpand(_6_pdkEncryptionKeyInput)
	_13_maybePdkEncryptionKey = _out2
	var _14_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _14_valueOrError2
	_14_valueOrError2 = (_13_maybePdkEncryptionKey).MapFailure(func(coer48 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg49 interface{}) interface{} {
			return coer48(arg49.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_15_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_15_e)
	}))
	if (_14_valueOrError2).IsFailure() {
		res = (_14_valueOrError2).PropagateFailure()
		return res
	}
	var _16_pdkEncryptionKey _dafny.Sequence
	_ = _16_pdkEncryptionKey
	_16_pdkEncryptionKey = (_14_valueOrError2).Extract().(_dafny.Sequence)
	res = m_Wrappers.Companion_Result_.Create_Success_(Companion_PdkEncryptionAndSymmetricSigningKeys_.Create_PdkEncryptionAndSymmetricSigningKeys_(_16_pdkEncryptionKey, _12_symmetricSigningKey))
	return res
	return res
}
func (_static *CompanionStruct_Default___) KEYWRAP__MAC__INFO() _dafny.Sequence {
	return m_UTF8.Companion_Default___.EncodeAscii(_dafny.SeqOfString("AWS_MPL_INTERMEDIATE_KEYWRAP_MAC"))
}
func (_static *CompanionStruct_Default___) KEYWRAP__ENC__INFO() _dafny.Sequence {
	return m_UTF8.Companion_Default___.EncodeAscii(_dafny.SeqOfString("AWS_MPL_INTERMEDIATE_KEYWRAP_ENC"))
}

// End of class Default__

// Definition of datatype IntermediateUnwrapOutput
type IntermediateUnwrapOutput struct {
	Data_IntermediateUnwrapOutput_
}

func (_this IntermediateUnwrapOutput) Get_() Data_IntermediateUnwrapOutput_ {
	return _this.Data_IntermediateUnwrapOutput_
}

type Data_IntermediateUnwrapOutput_ interface {
	isIntermediateUnwrapOutput()
}

type CompanionStruct_IntermediateUnwrapOutput_ struct {
}

var Companion_IntermediateUnwrapOutput_ = CompanionStruct_IntermediateUnwrapOutput_{}

type IntermediateUnwrapOutput_IntermediateUnwrapOutput struct {
	PlaintextDataKey    _dafny.Sequence
	SymmetricSigningKey _dafny.Sequence
	UnwrapInfo          interface{}
}

func (IntermediateUnwrapOutput_IntermediateUnwrapOutput) isIntermediateUnwrapOutput() {}

func (CompanionStruct_IntermediateUnwrapOutput_) Create_IntermediateUnwrapOutput_(PlaintextDataKey _dafny.Sequence, SymmetricSigningKey _dafny.Sequence, UnwrapInfo interface{}) IntermediateUnwrapOutput {
	return IntermediateUnwrapOutput{IntermediateUnwrapOutput_IntermediateUnwrapOutput{PlaintextDataKey, SymmetricSigningKey, UnwrapInfo}}
}

func (_this IntermediateUnwrapOutput) Is_IntermediateUnwrapOutput() bool {
	_, ok := _this.Get_().(IntermediateUnwrapOutput_IntermediateUnwrapOutput)
	return ok
}

func (CompanionStruct_IntermediateUnwrapOutput_) Default(_default_T interface{}) IntermediateUnwrapOutput {
	return Companion_IntermediateUnwrapOutput_.Create_IntermediateUnwrapOutput_(_dafny.EmptySeq, _dafny.EmptySeq, _default_T)
}

func (_this IntermediateUnwrapOutput) Dtor_plaintextDataKey() _dafny.Sequence {
	return _this.Get_().(IntermediateUnwrapOutput_IntermediateUnwrapOutput).PlaintextDataKey
}

func (_this IntermediateUnwrapOutput) Dtor_symmetricSigningKey() _dafny.Sequence {
	return _this.Get_().(IntermediateUnwrapOutput_IntermediateUnwrapOutput).SymmetricSigningKey
}

func (_this IntermediateUnwrapOutput) Dtor_unwrapInfo() interface{} {
	return _this.Get_().(IntermediateUnwrapOutput_IntermediateUnwrapOutput).UnwrapInfo
}

func (_this IntermediateUnwrapOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case IntermediateUnwrapOutput_IntermediateUnwrapOutput:
		{
			return "IntermediateKeyWrapping.IntermediateUnwrapOutput.IntermediateUnwrapOutput" + "(" + _dafny.String(data.PlaintextDataKey) + ", " + _dafny.String(data.SymmetricSigningKey) + ", " + _dafny.String(data.UnwrapInfo) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this IntermediateUnwrapOutput) Equals(other IntermediateUnwrapOutput) bool {
	switch data1 := _this.Get_().(type) {
	case IntermediateUnwrapOutput_IntermediateUnwrapOutput:
		{
			data2, ok := other.Get_().(IntermediateUnwrapOutput_IntermediateUnwrapOutput)
			return ok && data1.PlaintextDataKey.Equals(data2.PlaintextDataKey) && data1.SymmetricSigningKey.Equals(data2.SymmetricSigningKey) && _dafny.AreEqual(data1.UnwrapInfo, data2.UnwrapInfo)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this IntermediateUnwrapOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(IntermediateUnwrapOutput)
	return ok && _this.Equals(typed)
}

func Type_IntermediateUnwrapOutput_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_IntermediateUnwrapOutput_{Type_T_}
}

type type_IntermediateUnwrapOutput_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_IntermediateUnwrapOutput_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return Companion_IntermediateUnwrapOutput_.Default(Type_T_.Default())
}

func (_this type_IntermediateUnwrapOutput_) String() string {
	return "IntermediateKeyWrapping.IntermediateUnwrapOutput"
}
func (_this IntermediateUnwrapOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = IntermediateUnwrapOutput{}

// End of datatype IntermediateUnwrapOutput

// Definition of datatype IntermediateGenerateAndWrapOutput
type IntermediateGenerateAndWrapOutput struct {
	Data_IntermediateGenerateAndWrapOutput_
}

func (_this IntermediateGenerateAndWrapOutput) Get_() Data_IntermediateGenerateAndWrapOutput_ {
	return _this.Data_IntermediateGenerateAndWrapOutput_
}

type Data_IntermediateGenerateAndWrapOutput_ interface {
	isIntermediateGenerateAndWrapOutput()
}

type CompanionStruct_IntermediateGenerateAndWrapOutput_ struct {
}

var Companion_IntermediateGenerateAndWrapOutput_ = CompanionStruct_IntermediateGenerateAndWrapOutput_{}

type IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput struct {
	PlaintextDataKey    _dafny.Sequence
	WrappedMaterial     _dafny.Sequence
	SymmetricSigningKey _dafny.Sequence
	WrapInfo            interface{}
}

func (IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput) isIntermediateGenerateAndWrapOutput() {
}

func (CompanionStruct_IntermediateGenerateAndWrapOutput_) Create_IntermediateGenerateAndWrapOutput_(PlaintextDataKey _dafny.Sequence, WrappedMaterial _dafny.Sequence, SymmetricSigningKey _dafny.Sequence, WrapInfo interface{}) IntermediateGenerateAndWrapOutput {
	return IntermediateGenerateAndWrapOutput{IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput{PlaintextDataKey, WrappedMaterial, SymmetricSigningKey, WrapInfo}}
}

func (_this IntermediateGenerateAndWrapOutput) Is_IntermediateGenerateAndWrapOutput() bool {
	_, ok := _this.Get_().(IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput)
	return ok
}

func (CompanionStruct_IntermediateGenerateAndWrapOutput_) Default(_default_T interface{}) IntermediateGenerateAndWrapOutput {
	return Companion_IntermediateGenerateAndWrapOutput_.Create_IntermediateGenerateAndWrapOutput_(_dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _default_T)
}

func (_this IntermediateGenerateAndWrapOutput) Dtor_plaintextDataKey() _dafny.Sequence {
	return _this.Get_().(IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput).PlaintextDataKey
}

func (_this IntermediateGenerateAndWrapOutput) Dtor_wrappedMaterial() _dafny.Sequence {
	return _this.Get_().(IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput).WrappedMaterial
}

func (_this IntermediateGenerateAndWrapOutput) Dtor_symmetricSigningKey() _dafny.Sequence {
	return _this.Get_().(IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput).SymmetricSigningKey
}

func (_this IntermediateGenerateAndWrapOutput) Dtor_wrapInfo() interface{} {
	return _this.Get_().(IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput).WrapInfo
}

func (_this IntermediateGenerateAndWrapOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput:
		{
			return "IntermediateKeyWrapping.IntermediateGenerateAndWrapOutput.IntermediateGenerateAndWrapOutput" + "(" + _dafny.String(data.PlaintextDataKey) + ", " + _dafny.String(data.WrappedMaterial) + ", " + _dafny.String(data.SymmetricSigningKey) + ", " + _dafny.String(data.WrapInfo) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this IntermediateGenerateAndWrapOutput) Equals(other IntermediateGenerateAndWrapOutput) bool {
	switch data1 := _this.Get_().(type) {
	case IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput:
		{
			data2, ok := other.Get_().(IntermediateGenerateAndWrapOutput_IntermediateGenerateAndWrapOutput)
			return ok && data1.PlaintextDataKey.Equals(data2.PlaintextDataKey) && data1.WrappedMaterial.Equals(data2.WrappedMaterial) && data1.SymmetricSigningKey.Equals(data2.SymmetricSigningKey) && _dafny.AreEqual(data1.WrapInfo, data2.WrapInfo)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this IntermediateGenerateAndWrapOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(IntermediateGenerateAndWrapOutput)
	return ok && _this.Equals(typed)
}

func Type_IntermediateGenerateAndWrapOutput_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_IntermediateGenerateAndWrapOutput_{Type_T_}
}

type type_IntermediateGenerateAndWrapOutput_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_IntermediateGenerateAndWrapOutput_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return Companion_IntermediateGenerateAndWrapOutput_.Default(Type_T_.Default())
}

func (_this type_IntermediateGenerateAndWrapOutput_) String() string {
	return "IntermediateKeyWrapping.IntermediateGenerateAndWrapOutput"
}
func (_this IntermediateGenerateAndWrapOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = IntermediateGenerateAndWrapOutput{}

// End of datatype IntermediateGenerateAndWrapOutput

// Definition of datatype IntermediateWrapOutput
type IntermediateWrapOutput struct {
	Data_IntermediateWrapOutput_
}

func (_this IntermediateWrapOutput) Get_() Data_IntermediateWrapOutput_ {
	return _this.Data_IntermediateWrapOutput_
}

type Data_IntermediateWrapOutput_ interface {
	isIntermediateWrapOutput()
}

type CompanionStruct_IntermediateWrapOutput_ struct {
}

var Companion_IntermediateWrapOutput_ = CompanionStruct_IntermediateWrapOutput_{}

type IntermediateWrapOutput_IntermediateWrapOutput struct {
	WrappedMaterial     _dafny.Sequence
	SymmetricSigningKey _dafny.Sequence
	WrapInfo            interface{}
}

func (IntermediateWrapOutput_IntermediateWrapOutput) isIntermediateWrapOutput() {}

func (CompanionStruct_IntermediateWrapOutput_) Create_IntermediateWrapOutput_(WrappedMaterial _dafny.Sequence, SymmetricSigningKey _dafny.Sequence, WrapInfo interface{}) IntermediateWrapOutput {
	return IntermediateWrapOutput{IntermediateWrapOutput_IntermediateWrapOutput{WrappedMaterial, SymmetricSigningKey, WrapInfo}}
}

func (_this IntermediateWrapOutput) Is_IntermediateWrapOutput() bool {
	_, ok := _this.Get_().(IntermediateWrapOutput_IntermediateWrapOutput)
	return ok
}

func (CompanionStruct_IntermediateWrapOutput_) Default(_default_T interface{}) IntermediateWrapOutput {
	return Companion_IntermediateWrapOutput_.Create_IntermediateWrapOutput_(_dafny.EmptySeq, _dafny.EmptySeq, _default_T)
}

func (_this IntermediateWrapOutput) Dtor_wrappedMaterial() _dafny.Sequence {
	return _this.Get_().(IntermediateWrapOutput_IntermediateWrapOutput).WrappedMaterial
}

func (_this IntermediateWrapOutput) Dtor_symmetricSigningKey() _dafny.Sequence {
	return _this.Get_().(IntermediateWrapOutput_IntermediateWrapOutput).SymmetricSigningKey
}

func (_this IntermediateWrapOutput) Dtor_wrapInfo() interface{} {
	return _this.Get_().(IntermediateWrapOutput_IntermediateWrapOutput).WrapInfo
}

func (_this IntermediateWrapOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case IntermediateWrapOutput_IntermediateWrapOutput:
		{
			return "IntermediateKeyWrapping.IntermediateWrapOutput.IntermediateWrapOutput" + "(" + _dafny.String(data.WrappedMaterial) + ", " + _dafny.String(data.SymmetricSigningKey) + ", " + _dafny.String(data.WrapInfo) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this IntermediateWrapOutput) Equals(other IntermediateWrapOutput) bool {
	switch data1 := _this.Get_().(type) {
	case IntermediateWrapOutput_IntermediateWrapOutput:
		{
			data2, ok := other.Get_().(IntermediateWrapOutput_IntermediateWrapOutput)
			return ok && data1.WrappedMaterial.Equals(data2.WrappedMaterial) && data1.SymmetricSigningKey.Equals(data2.SymmetricSigningKey) && _dafny.AreEqual(data1.WrapInfo, data2.WrapInfo)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this IntermediateWrapOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(IntermediateWrapOutput)
	return ok && _this.Equals(typed)
}

func Type_IntermediateWrapOutput_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_IntermediateWrapOutput_{Type_T_}
}

type type_IntermediateWrapOutput_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_IntermediateWrapOutput_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return Companion_IntermediateWrapOutput_.Default(Type_T_.Default())
}

func (_this type_IntermediateWrapOutput_) String() string {
	return "IntermediateKeyWrapping.IntermediateWrapOutput"
}
func (_this IntermediateWrapOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = IntermediateWrapOutput{}

// End of datatype IntermediateWrapOutput

// Definition of datatype DeserializedIntermediateWrappedMaterial
type DeserializedIntermediateWrappedMaterial struct {
	Data_DeserializedIntermediateWrappedMaterial_
}

func (_this DeserializedIntermediateWrappedMaterial) Get_() Data_DeserializedIntermediateWrappedMaterial_ {
	return _this.Data_DeserializedIntermediateWrappedMaterial_
}

type Data_DeserializedIntermediateWrappedMaterial_ interface {
	isDeserializedIntermediateWrappedMaterial()
}

type CompanionStruct_DeserializedIntermediateWrappedMaterial_ struct {
}

var Companion_DeserializedIntermediateWrappedMaterial_ = CompanionStruct_DeserializedIntermediateWrappedMaterial_{}

type DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial struct {
	EncryptedPdk       _dafny.Sequence
	ProviderWrappedIkm _dafny.Sequence
}

func (DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial) isDeserializedIntermediateWrappedMaterial() {
}

func (CompanionStruct_DeserializedIntermediateWrappedMaterial_) Create_DeserializedIntermediateWrappedMaterial_(EncryptedPdk _dafny.Sequence, ProviderWrappedIkm _dafny.Sequence) DeserializedIntermediateWrappedMaterial {
	return DeserializedIntermediateWrappedMaterial{DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial{EncryptedPdk, ProviderWrappedIkm}}
}

func (_this DeserializedIntermediateWrappedMaterial) Is_DeserializedIntermediateWrappedMaterial() bool {
	_, ok := _this.Get_().(DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial)
	return ok
}

func (CompanionStruct_DeserializedIntermediateWrappedMaterial_) Default() DeserializedIntermediateWrappedMaterial {
	return Companion_DeserializedIntermediateWrappedMaterial_.Create_DeserializedIntermediateWrappedMaterial_(_dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this DeserializedIntermediateWrappedMaterial) Dtor_encryptedPdk() _dafny.Sequence {
	return _this.Get_().(DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial).EncryptedPdk
}

func (_this DeserializedIntermediateWrappedMaterial) Dtor_providerWrappedIkm() _dafny.Sequence {
	return _this.Get_().(DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial).ProviderWrappedIkm
}

func (_this DeserializedIntermediateWrappedMaterial) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial:
		{
			return "IntermediateKeyWrapping.DeserializedIntermediateWrappedMaterial.DeserializedIntermediateWrappedMaterial" + "(" + _dafny.String(data.EncryptedPdk) + ", " + _dafny.String(data.ProviderWrappedIkm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeserializedIntermediateWrappedMaterial) Equals(other DeserializedIntermediateWrappedMaterial) bool {
	switch data1 := _this.Get_().(type) {
	case DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial:
		{
			data2, ok := other.Get_().(DeserializedIntermediateWrappedMaterial_DeserializedIntermediateWrappedMaterial)
			return ok && data1.EncryptedPdk.Equals(data2.EncryptedPdk) && data1.ProviderWrappedIkm.Equals(data2.ProviderWrappedIkm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeserializedIntermediateWrappedMaterial) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeserializedIntermediateWrappedMaterial)
	return ok && _this.Equals(typed)
}

func Type_DeserializedIntermediateWrappedMaterial_() _dafny.TypeDescriptor {
	return type_DeserializedIntermediateWrappedMaterial_{}
}

type type_DeserializedIntermediateWrappedMaterial_ struct {
}

func (_this type_DeserializedIntermediateWrappedMaterial_) Default() interface{} {
	return Companion_DeserializedIntermediateWrappedMaterial_.Default()
}

func (_this type_DeserializedIntermediateWrappedMaterial_) String() string {
	return "IntermediateKeyWrapping.DeserializedIntermediateWrappedMaterial"
}
func (_this DeserializedIntermediateWrappedMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeserializedIntermediateWrappedMaterial{}

// End of datatype DeserializedIntermediateWrappedMaterial

// Definition of datatype PdkEncryptionAndSymmetricSigningKeys
type PdkEncryptionAndSymmetricSigningKeys struct {
	Data_PdkEncryptionAndSymmetricSigningKeys_
}

func (_this PdkEncryptionAndSymmetricSigningKeys) Get_() Data_PdkEncryptionAndSymmetricSigningKeys_ {
	return _this.Data_PdkEncryptionAndSymmetricSigningKeys_
}

type Data_PdkEncryptionAndSymmetricSigningKeys_ interface {
	isPdkEncryptionAndSymmetricSigningKeys()
}

type CompanionStruct_PdkEncryptionAndSymmetricSigningKeys_ struct {
}

var Companion_PdkEncryptionAndSymmetricSigningKeys_ = CompanionStruct_PdkEncryptionAndSymmetricSigningKeys_{}

type PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys struct {
	PdkEncryptionKey    _dafny.Sequence
	SymmetricSigningKey _dafny.Sequence
}

func (PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys) isPdkEncryptionAndSymmetricSigningKeys() {
}

func (CompanionStruct_PdkEncryptionAndSymmetricSigningKeys_) Create_PdkEncryptionAndSymmetricSigningKeys_(PdkEncryptionKey _dafny.Sequence, SymmetricSigningKey _dafny.Sequence) PdkEncryptionAndSymmetricSigningKeys {
	return PdkEncryptionAndSymmetricSigningKeys{PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys{PdkEncryptionKey, SymmetricSigningKey}}
}

func (_this PdkEncryptionAndSymmetricSigningKeys) Is_PdkEncryptionAndSymmetricSigningKeys() bool {
	_, ok := _this.Get_().(PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys)
	return ok
}

func (CompanionStruct_PdkEncryptionAndSymmetricSigningKeys_) Default() PdkEncryptionAndSymmetricSigningKeys {
	return Companion_PdkEncryptionAndSymmetricSigningKeys_.Create_PdkEncryptionAndSymmetricSigningKeys_(_dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this PdkEncryptionAndSymmetricSigningKeys) Dtor_pdkEncryptionKey() _dafny.Sequence {
	return _this.Get_().(PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys).PdkEncryptionKey
}

func (_this PdkEncryptionAndSymmetricSigningKeys) Dtor_symmetricSigningKey() _dafny.Sequence {
	return _this.Get_().(PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys).SymmetricSigningKey
}

func (_this PdkEncryptionAndSymmetricSigningKeys) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys:
		{
			return "IntermediateKeyWrapping.PdkEncryptionAndSymmetricSigningKeys.PdkEncryptionAndSymmetricSigningKeys" + "(" + _dafny.String(data.PdkEncryptionKey) + ", " + _dafny.String(data.SymmetricSigningKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PdkEncryptionAndSymmetricSigningKeys) Equals(other PdkEncryptionAndSymmetricSigningKeys) bool {
	switch data1 := _this.Get_().(type) {
	case PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys:
		{
			data2, ok := other.Get_().(PdkEncryptionAndSymmetricSigningKeys_PdkEncryptionAndSymmetricSigningKeys)
			return ok && data1.PdkEncryptionKey.Equals(data2.PdkEncryptionKey) && data1.SymmetricSigningKey.Equals(data2.SymmetricSigningKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PdkEncryptionAndSymmetricSigningKeys) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PdkEncryptionAndSymmetricSigningKeys)
	return ok && _this.Equals(typed)
}

func Type_PdkEncryptionAndSymmetricSigningKeys_() _dafny.TypeDescriptor {
	return type_PdkEncryptionAndSymmetricSigningKeys_{}
}

type type_PdkEncryptionAndSymmetricSigningKeys_ struct {
}

func (_this type_PdkEncryptionAndSymmetricSigningKeys_) Default() interface{} {
	return Companion_PdkEncryptionAndSymmetricSigningKeys_.Default()
}

func (_this type_PdkEncryptionAndSymmetricSigningKeys_) String() string {
	return "IntermediateKeyWrapping.PdkEncryptionAndSymmetricSigningKeys"
}
func (_this PdkEncryptionAndSymmetricSigningKeys) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PdkEncryptionAndSymmetricSigningKeys{}

// End of datatype PdkEncryptionAndSymmetricSigningKeys
