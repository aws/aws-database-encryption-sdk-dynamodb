// Package RawRSAKeyring
// Dafny module RawRSAKeyring compiled into Go

package RawRSAKeyring

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
	m_AwsKmsDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsDiscoveryKeyring"
	m_AwsKmsEcdhKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsEcdhKeyring"
	m_AwsKmsHierarchicalKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsHierarchicalKeyring"
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkDiscoveryKeyring"
	m_AwsKmsMrkKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkKeyring"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsRsaKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsRsaKeyring"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CacheConstants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CacheConstants"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_DiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DiscoveryMultiKeyring"
	m_EcdhEdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EcdhEdkWrapping"
	m_EdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EdkWrapping"
	m_ErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/ErrorMessages"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_IntermediateKeyWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/IntermediateKeyWrapping"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_LocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/LocalCMC"
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_MrkAwareDiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareDiscoveryMultiKeyring"
	m_MrkAwareStrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareStrictMultiKeyring"
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_RawAESKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawAESKeyring"
	m_RawECDHKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawECDHKeyring"
	m_StormTracker "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	m_StormTrackingCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTrackingCMC"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
	m_SynchronizedLocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/SynchronizedLocalCMC"
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
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_DiscoveryMultiKeyring.Dummy__
var _ m_AwsKmsMrkDiscoveryKeyring.Dummy__
var _ m_MrkAwareDiscoveryMultiKeyring.Dummy__
var _ m_AwsKmsMrkKeyring.Dummy__
var _ m_MrkAwareStrictMultiKeyring.Dummy__
var _ m_LocalCMC.Dummy__
var _ m_SynchronizedLocalCMC.Dummy__
var _ m_StormTracker.Dummy__
var _ m_StormTrackingCMC.Dummy__
var _ m_CacheConstants.Dummy__
var _ m_AwsKmsHierarchicalKeyring.Dummy__
var _ m_AwsKmsRsaKeyring.Dummy__
var _ m_EcdhEdkWrapping.Dummy__
var _ m_RawECDHKeyring.Dummy__
var _ m_AwsKmsEcdhKeyring.Dummy__
var _ m_RawAESKeyring.Dummy__

type Dummy__ struct{}

// Definition of class RawRSAKeyring
type RawRSAKeyring struct {
	_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_keyNamespace     _dafny.Sequence
	_keyName          _dafny.Sequence
	_paddingScheme    m_AwsCryptographyPrimitivesTypes.RSAPaddingMode
	_publicKey        m_Wrappers.Option
	_privateKey       m_Wrappers.Option
}

func New_RawRSAKeyring_() *RawRSAKeyring {
	_this := RawRSAKeyring{}

	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._keyNamespace = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
	_this._keyName = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
	_this._paddingScheme = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Default()
	_this._publicKey = m_Wrappers.Companion_Option_.Default()
	_this._privateKey = m_Wrappers.Companion_Option_.Default()
	return &_this
}

type CompanionStruct_RawRSAKeyring_ struct {
}

var Companion_RawRSAKeyring_ = CompanionStruct_RawRSAKeyring_{}

func (_this *RawRSAKeyring) Equals(other *RawRSAKeyring) bool {
	return _this == other
}

func (_this *RawRSAKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*RawRSAKeyring)
	return ok && _this.Equals(other)
}

func (*RawRSAKeyring) String() string {
	return "RawRSAKeyring.RawRSAKeyring"
}

func Type_RawRSAKeyring_() _dafny.TypeDescriptor {
	return type_RawRSAKeyring_{}
}

type type_RawRSAKeyring_ struct {
}

func (_this type_RawRSAKeyring_) Default() interface{} {
	return (*RawRSAKeyring)(nil)
}

func (_this type_RawRSAKeyring_) String() string {
	return "RawRSAKeyring.RawRSAKeyring"
}
func (_this *RawRSAKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &RawRSAKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &RawRSAKeyring{}
var _ _dafny.TraitOffspring = &RawRSAKeyring{}

func (_this *RawRSAKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out11 m_Wrappers.Result
	_ = _out11
	_out11 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out11
}
func (_this *RawRSAKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out11 m_Wrappers.Result
	_ = _out11
	_out11 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out11
}
func (_this *RawRSAKeyring) Ctor__(namespace _dafny.Sequence, name _dafny.Sequence, publicKey m_Wrappers.Option, privateKey m_Wrappers.Option, paddingScheme m_AwsCryptographyPrimitivesTypes.RSAPaddingMode, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._keyNamespace = namespace
		(_this)._keyName = name
		(_this)._paddingScheme = paddingScheme
		(_this)._publicKey = publicKey
		(_this)._privateKey = privateKey
		(_this)._cryptoPrimitives = cryptoPrimitives
	}
}
func (_this *RawRSAKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((_this).PublicKey()).Is_Some()) && ((_dafny.IntOfUint32((((_this).PublicKey()).Extract().(_dafny.Sequence)).Cardinality())).Sign() == 1), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("A RawRSAKeyring without a public key cannot provide OnEncrypt")))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_materials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
		_ = _1_materials
		_1_materials = (input).Dtor_materials()
		var _2_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _2_suite
		_2_suite = (_1_materials).Dtor_algorithmSuite()
		var _3_wrap *RsaWrapKeyMaterial
		_ = _3_wrap
		var _nw0 *RsaWrapKeyMaterial = New_RsaWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__(((_this).PublicKey()).Dtor_value().(_dafny.Sequence), (_this).PaddingScheme(), (_this).CryptoPrimitives())
		_3_wrap = _nw0
		var _4_generateAndWrap *RsaGenerateAndWrapKeyMaterial
		_ = _4_generateAndWrap
		var _nw1 *RsaGenerateAndWrapKeyMaterial = New_RsaGenerateAndWrapKeyMaterial_()
		_ = _nw1
		_nw1.Ctor__(((_this).PublicKey()).Dtor_value().(_dafny.Sequence), (_this).PaddingScheme(), (_this).CryptoPrimitives())
		_4_generateAndWrap = _nw1
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_WrapEdkMaterialOutput_.Default(Companion_RsaWrapInfo_.Default()))
		_ = _5_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.WrapEdkMaterial(_1_materials, _3_wrap, _4_generateAndWrap)
		_5_valueOrError1 = _out0
		if (_5_valueOrError1).IsFailure() {
			output = (_5_valueOrError1).PropagateFailure()
			return output
		}
		var _6_wrapOutput m_EdkWrapping.WrapEdkMaterialOutput
		_ = _6_wrapOutput
		_6_wrapOutput = (_5_valueOrError1).Extract().(m_EdkWrapping.WrapEdkMaterialOutput)
		var _7_symmetricSigningKeyList m_Wrappers.Option
		_ = _7_symmetricSigningKeyList
		if ((_6_wrapOutput).Dtor_symmetricSigningKey()).Is_Some() {
			_7_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(((_6_wrapOutput).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence)))
		} else {
			_7_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _8_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
		_ = _8_edk
		_8_edk = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_((_this).KeyNamespace(), (_this).KeyName(), (_6_wrapOutput).Dtor_wrappedMaterial())
		if (_6_wrapOutput).Is_GenerateAndWrapEdkMaterialOutput() {
			var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _9_valueOrError2
			_9_valueOrError2 = m_Materials.Companion_Default___.EncryptionMaterialAddDataKey(_1_materials, (_6_wrapOutput).Dtor_plaintextDataKey(), _dafny.SeqOf(_8_edk), _7_symmetricSigningKeyList)
			if (_9_valueOrError2).IsFailure() {
				output = (_9_valueOrError2).PropagateFailure()
				return output
			}
			var _10_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _10_result
			_10_result = (_9_valueOrError2).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_10_result))
			return output
		} else if (_6_wrapOutput).Is_WrapOnlyEdkMaterialOutput() {
			var _11_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _11_valueOrError3
			_11_valueOrError3 = m_Materials.Companion_Default___.EncryptionMaterialAddEncryptedDataKeys(_1_materials, _dafny.SeqOf(_8_edk), _7_symmetricSigningKeyList)
			if (_11_valueOrError3).IsFailure() {
				output = (_11_valueOrError3).PropagateFailure()
				return output
			}
			var _12_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _12_result
			_12_result = (_11_valueOrError3).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_12_result))
			return output
		}
		return output
	}
}
func (_this *RawRSAKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((_this).PrivateKey()).Is_Some()) && ((_dafny.IntOfUint32((((_this).PrivateKey()).Extract().(_dafny.Sequence)).Cardinality())).Sign() == 1), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("A RawRSAKeyring without a private key cannot provide OnEncrypt")))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _1_materials
		_1_materials = (input).Dtor_materials()
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError1
		_2_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_1_materials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_2_valueOrError1).IsFailure() {
			output = (_2_valueOrError1).PropagateFailure()
			return output
		}
		var _3_errors _dafny.Sequence
		_ = _3_errors
		_3_errors = _dafny.SeqOf()
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((input).Dtor_encryptedDataKeys()).Cardinality())
		_ = _hi0
		for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
			if (_this).ShouldDecryptEDK(((input).Dtor_encryptedDataKeys()).Select((_4_i).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)) {
				var _5_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
				_ = _5_edk
				_5_edk = ((input).Dtor_encryptedDataKeys()).Select((_4_i).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
				var _6_unwrap *RsaUnwrapKeyMaterial
				_ = _6_unwrap
				var _nw0 *RsaUnwrapKeyMaterial = New_RsaUnwrapKeyMaterial_()
				_ = _nw0
				_nw0.Ctor__(((_this).PrivateKey()).Extract().(_dafny.Sequence), (_this).PaddingScheme(), (_this).CryptoPrimitives())
				_6_unwrap = _nw0
				var _7_unwrapOutput m_Wrappers.Result
				_ = _7_unwrapOutput
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial((_5_edk).Dtor_ciphertext(), _1_materials, _6_unwrap)
				_7_unwrapOutput = _out0
				if (_7_unwrapOutput).Is_Success() {
					var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _8_valueOrError2
					_8_valueOrError2 = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey(_1_materials, ((_7_unwrapOutput).Dtor_value().(m_EdkWrapping.UnwrapEdkMaterialOutput)).Dtor_plaintextDataKey(), ((_7_unwrapOutput).Dtor_value().(m_EdkWrapping.UnwrapEdkMaterialOutput)).Dtor_symmetricSigningKey())
					if (_8_valueOrError2).IsFailure() {
						output = (_8_valueOrError2).PropagateFailure()
						return output
					}
					var _9_returnMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
					_ = _9_returnMaterials
					_9_returnMaterials = (_8_valueOrError2).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
					output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_9_returnMaterials))
					return output
				} else {
					_3_errors = _dafny.Companion_Sequence_.Concatenate(_3_errors, _dafny.SeqOf((_7_unwrapOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)))
				}
			} else {
				var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
				_ = _10_valueOrError3
				_10_valueOrError3 = (m_UTF8.Decode((((input).Dtor_encryptedDataKeys()).Select((_4_i).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)).Dtor_keyProviderId())).MapFailure(func(coer125 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
					return func(arg126 interface{}) interface{} {
						return coer125(arg126.(_dafny.Sequence))
					}
				}(func(_11_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
					return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_11_e)
				}))
				if (_10_valueOrError3).IsFailure() {
					output = (_10_valueOrError3).PropagateFailure()
					return output
				}
				var _12_extractedKeyProviderId _dafny.Sequence
				_ = _12_extractedKeyProviderId
				_12_extractedKeyProviderId = (_10_valueOrError3).Extract().(_dafny.Sequence)
				_3_errors = _dafny.Companion_Sequence_.Concatenate(_3_errors, _dafny.SeqOf(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(m_ErrorMessages.Companion_Default___.IncorrectRawDataKeys(m_StandardLibrary_String.Companion_Default___.Base10Int2String(_4_i), _dafny.SeqOfString("RSAKeyring"), _12_extractedKeyProviderId))))
			}
		}
		output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_3_errors, _dafny.SeqOfString("Raw RSA Key was unable to decrypt any encrypted data key. The list of encountered Exceptions is avaible via `list`.")))
		return output
		return output
	}
}
func (_this *RawRSAKeyring) ShouldDecryptEDK(edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey) bool {
	{
		return (((m_UTF8.Companion_Default___.ValidUTF8Seq((edk).Dtor_keyProviderInfo())) && (_dafny.Companion_Sequence_.Equal((edk).Dtor_keyProviderInfo(), (_this).KeyName()))) && (_dafny.Companion_Sequence_.Equal((edk).Dtor_keyProviderId(), (_this).KeyNamespace()))) && ((_dafny.IntOfUint32(((edk).Dtor_ciphertext()).Cardinality())).Sign() == 1)
	}
}
func (_this *RawRSAKeyring) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *RawRSAKeyring) KeyNamespace() _dafny.Sequence {
	{
		return _this._keyNamespace
	}
}
func (_this *RawRSAKeyring) KeyName() _dafny.Sequence {
	{
		return _this._keyName
	}
}
func (_this *RawRSAKeyring) PaddingScheme() m_AwsCryptographyPrimitivesTypes.RSAPaddingMode {
	{
		return _this._paddingScheme
	}
}
func (_this *RawRSAKeyring) PublicKey() m_Wrappers.Option {
	{
		return _this._publicKey
	}
}
func (_this *RawRSAKeyring) PrivateKey() m_Wrappers.Option {
	{
		return _this._privateKey
	}
}

// End of class RawRSAKeyring

// Definition of datatype RsaUnwrapInfo
type RsaUnwrapInfo struct {
	Data_RsaUnwrapInfo_
}

func (_this RsaUnwrapInfo) Get_() Data_RsaUnwrapInfo_ {
	return _this.Data_RsaUnwrapInfo_
}

type Data_RsaUnwrapInfo_ interface {
	isRsaUnwrapInfo()
}

type CompanionStruct_RsaUnwrapInfo_ struct {
}

var Companion_RsaUnwrapInfo_ = CompanionStruct_RsaUnwrapInfo_{}

type RsaUnwrapInfo_RsaUnwrapInfo struct {
}

func (RsaUnwrapInfo_RsaUnwrapInfo) isRsaUnwrapInfo() {}

func (CompanionStruct_RsaUnwrapInfo_) Create_RsaUnwrapInfo_() RsaUnwrapInfo {
	return RsaUnwrapInfo{RsaUnwrapInfo_RsaUnwrapInfo{}}
}

func (_this RsaUnwrapInfo) Is_RsaUnwrapInfo() bool {
	_, ok := _this.Get_().(RsaUnwrapInfo_RsaUnwrapInfo)
	return ok
}

func (CompanionStruct_RsaUnwrapInfo_) Default() RsaUnwrapInfo {
	return Companion_RsaUnwrapInfo_.Create_RsaUnwrapInfo_()
}

func (_ CompanionStruct_RsaUnwrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_RsaUnwrapInfo_.Create_RsaUnwrapInfo_(), true
		default:
			return RsaUnwrapInfo{}, false
		}
	}
}

func (_this RsaUnwrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case RsaUnwrapInfo_RsaUnwrapInfo:
		{
			return "RawRSAKeyring.RsaUnwrapInfo.RsaUnwrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RsaUnwrapInfo) Equals(other RsaUnwrapInfo) bool {
	switch _this.Get_().(type) {
	case RsaUnwrapInfo_RsaUnwrapInfo:
		{
			_, ok := other.Get_().(RsaUnwrapInfo_RsaUnwrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RsaUnwrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RsaUnwrapInfo)
	return ok && _this.Equals(typed)
}

func Type_RsaUnwrapInfo_() _dafny.TypeDescriptor {
	return type_RsaUnwrapInfo_{}
}

type type_RsaUnwrapInfo_ struct {
}

func (_this type_RsaUnwrapInfo_) Default() interface{} {
	return Companion_RsaUnwrapInfo_.Default()
}

func (_this type_RsaUnwrapInfo_) String() string {
	return "RawRSAKeyring.RsaUnwrapInfo"
}
func (_this RsaUnwrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RsaUnwrapInfo{}

// End of datatype RsaUnwrapInfo

// Definition of datatype RsaWrapInfo
type RsaWrapInfo struct {
	Data_RsaWrapInfo_
}

func (_this RsaWrapInfo) Get_() Data_RsaWrapInfo_ {
	return _this.Data_RsaWrapInfo_
}

type Data_RsaWrapInfo_ interface {
	isRsaWrapInfo()
}

type CompanionStruct_RsaWrapInfo_ struct {
}

var Companion_RsaWrapInfo_ = CompanionStruct_RsaWrapInfo_{}

type RsaWrapInfo_RsaWrapInfo struct {
}

func (RsaWrapInfo_RsaWrapInfo) isRsaWrapInfo() {}

func (CompanionStruct_RsaWrapInfo_) Create_RsaWrapInfo_() RsaWrapInfo {
	return RsaWrapInfo{RsaWrapInfo_RsaWrapInfo{}}
}

func (_this RsaWrapInfo) Is_RsaWrapInfo() bool {
	_, ok := _this.Get_().(RsaWrapInfo_RsaWrapInfo)
	return ok
}

func (CompanionStruct_RsaWrapInfo_) Default() RsaWrapInfo {
	return Companion_RsaWrapInfo_.Create_RsaWrapInfo_()
}

func (_ CompanionStruct_RsaWrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_RsaWrapInfo_.Create_RsaWrapInfo_(), true
		default:
			return RsaWrapInfo{}, false
		}
	}
}

func (_this RsaWrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case RsaWrapInfo_RsaWrapInfo:
		{
			return "RawRSAKeyring.RsaWrapInfo.RsaWrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RsaWrapInfo) Equals(other RsaWrapInfo) bool {
	switch _this.Get_().(type) {
	case RsaWrapInfo_RsaWrapInfo:
		{
			_, ok := other.Get_().(RsaWrapInfo_RsaWrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RsaWrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RsaWrapInfo)
	return ok && _this.Equals(typed)
}

func Type_RsaWrapInfo_() _dafny.TypeDescriptor {
	return type_RsaWrapInfo_{}
}

type type_RsaWrapInfo_ struct {
}

func (_this type_RsaWrapInfo_) Default() interface{} {
	return Companion_RsaWrapInfo_.Default()
}

func (_this type_RsaWrapInfo_) String() string {
	return "RawRSAKeyring.RsaWrapInfo"
}
func (_this RsaWrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RsaWrapInfo{}

// End of datatype RsaWrapInfo

// Definition of class RsaGenerateAndWrapKeyMaterial
type RsaGenerateAndWrapKeyMaterial struct {
	_publicKey        _dafny.Sequence
	_paddingScheme    m_AwsCryptographyPrimitivesTypes.RSAPaddingMode
	_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_RsaGenerateAndWrapKeyMaterial_() *RsaGenerateAndWrapKeyMaterial {
	_this := RsaGenerateAndWrapKeyMaterial{}

	_this._publicKey = _dafny.EmptySeq
	_this._paddingScheme = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Default()
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_RsaGenerateAndWrapKeyMaterial_ struct {
}

var Companion_RsaGenerateAndWrapKeyMaterial_ = CompanionStruct_RsaGenerateAndWrapKeyMaterial_{}

func (_this *RsaGenerateAndWrapKeyMaterial) Equals(other *RsaGenerateAndWrapKeyMaterial) bool {
	return _this == other
}

func (_this *RsaGenerateAndWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*RsaGenerateAndWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*RsaGenerateAndWrapKeyMaterial) String() string {
	return "RawRSAKeyring.RsaGenerateAndWrapKeyMaterial"
}

func Type_RsaGenerateAndWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_RsaGenerateAndWrapKeyMaterial_{}
}

type type_RsaGenerateAndWrapKeyMaterial_ struct {
}

func (_this type_RsaGenerateAndWrapKeyMaterial_) Default() interface{} {
	return (*RsaGenerateAndWrapKeyMaterial)(nil)
}

func (_this type_RsaGenerateAndWrapKeyMaterial_) String() string {
	return "RawRSAKeyring.RsaGenerateAndWrapKeyMaterial"
}
func (_this *RsaGenerateAndWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_GenerateAndWrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.GenerateAndWrapMaterial = &RsaGenerateAndWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &RsaGenerateAndWrapKeyMaterial{}
var _ m_Actions.Action = &RsaGenerateAndWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &RsaGenerateAndWrapKeyMaterial{}

func (_this *RsaGenerateAndWrapKeyMaterial) Ctor__(publicKey _dafny.Sequence, paddingScheme m_AwsCryptographyPrimitivesTypes.RSAPaddingMode, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._publicKey = publicKey
		(_this)._paddingScheme = paddingScheme
		(_this)._cryptoPrimitives = cryptoPrimitives
	}
}
func (_this *RsaGenerateAndWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.GenerateAndWrapInput = input.(m_MaterialWrapping.GenerateAndWrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Default(Companion_RsaWrapInfo_.Default()))
		_ = res
		var _0_generateBytesResult m_Wrappers.Result
		_ = _0_generateBytesResult
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).CryptoPrimitives()).GenerateRandomBytes(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength((input).Dtor_algorithmSuite())))
		_0_generateBytesResult = _out0
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _1_valueOrError0
		_1_valueOrError0 = (_0_generateBytesResult).MapFailure(func(coer126 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg127 interface{}) interface{} {
				return coer126(arg127.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
		}))
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _3_plaintextMaterial _dafny.Sequence
		_ = _3_plaintextMaterial
		_3_plaintextMaterial = (_1_valueOrError0).Extract().(_dafny.Sequence)
		var _4_wrap *RsaWrapKeyMaterial
		_ = _4_wrap
		var _nw0 *RsaWrapKeyMaterial = New_RsaWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).PublicKey(), (_this).PaddingScheme(), (_this).CryptoPrimitives())
		_4_wrap = _nw0
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_RsaWrapInfo_.Default()))
		_ = _5_valueOrError1
		var _out1 interface{}
		_ = _out1
		_out1 = (_4_wrap).Invoke(m_MaterialWrapping.Companion_WrapInput_.Create_WrapInput_(_3_plaintextMaterial, (input).Dtor_algorithmSuite(), (input).Dtor_encryptionContext()))
		_5_valueOrError1 = _out1.(m_Wrappers.Result)
		if (_5_valueOrError1).IsFailure() {
			res = (_5_valueOrError1).PropagateFailure()
			return res
		}
		var _6_wrapOutput m_MaterialWrapping.WrapOutput
		_ = _6_wrapOutput
		_6_wrapOutput = (_5_valueOrError1).Extract().(m_MaterialWrapping.WrapOutput)
		var _7_output m_MaterialWrapping.GenerateAndWrapOutput
		_ = _7_output
		_7_output = m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Create_GenerateAndWrapOutput_(_3_plaintextMaterial, (_6_wrapOutput).Dtor_wrappedMaterial(), Companion_RsaWrapInfo_.Create_RsaWrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_7_output)
		return res
		return res
	}
}
func (_this *RsaGenerateAndWrapKeyMaterial) PublicKey() _dafny.Sequence {
	{
		return _this._publicKey
	}
}
func (_this *RsaGenerateAndWrapKeyMaterial) PaddingScheme() m_AwsCryptographyPrimitivesTypes.RSAPaddingMode {
	{
		return _this._paddingScheme
	}
}
func (_this *RsaGenerateAndWrapKeyMaterial) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}

// End of class RsaGenerateAndWrapKeyMaterial

// Definition of class RsaWrapKeyMaterial
type RsaWrapKeyMaterial struct {
	_publicKey        _dafny.Sequence
	_paddingScheme    m_AwsCryptographyPrimitivesTypes.RSAPaddingMode
	_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_RsaWrapKeyMaterial_() *RsaWrapKeyMaterial {
	_this := RsaWrapKeyMaterial{}

	_this._publicKey = _dafny.EmptySeq
	_this._paddingScheme = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Default()
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_RsaWrapKeyMaterial_ struct {
}

var Companion_RsaWrapKeyMaterial_ = CompanionStruct_RsaWrapKeyMaterial_{}

func (_this *RsaWrapKeyMaterial) Equals(other *RsaWrapKeyMaterial) bool {
	return _this == other
}

func (_this *RsaWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*RsaWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*RsaWrapKeyMaterial) String() string {
	return "RawRSAKeyring.RsaWrapKeyMaterial"
}

func Type_RsaWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_RsaWrapKeyMaterial_{}
}

type type_RsaWrapKeyMaterial_ struct {
}

func (_this type_RsaWrapKeyMaterial_) Default() interface{} {
	return (*RsaWrapKeyMaterial)(nil)
}

func (_this type_RsaWrapKeyMaterial_) String() string {
	return "RawRSAKeyring.RsaWrapKeyMaterial"
}
func (_this *RsaWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_WrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.WrapMaterial = &RsaWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &RsaWrapKeyMaterial{}
var _ m_Actions.Action = &RsaWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &RsaWrapKeyMaterial{}

func (_this *RsaWrapKeyMaterial) Ctor__(publicKey _dafny.Sequence, paddingScheme m_AwsCryptographyPrimitivesTypes.RSAPaddingMode, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._publicKey = publicKey
		(_this)._paddingScheme = paddingScheme
		(_this)._cryptoPrimitives = cryptoPrimitives
	}
}
func (_this *RsaWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.WrapInput = input.(m_MaterialWrapping.WrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_RsaWrapInfo_.Default()))
		_ = res
		var _0_RSAEncryptOutput m_Wrappers.Result
		_ = _0_RSAEncryptOutput
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).CryptoPrimitives()).RSAEncrypt(m_AwsCryptographyPrimitivesTypes.Companion_RSAEncryptInput_.Create_RSAEncryptInput_((_this).PaddingScheme(), (_this).PublicKey(), (input).Dtor_plaintextMaterial()))
		_0_RSAEncryptOutput = _out0
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _1_valueOrError0
		_1_valueOrError0 = (_0_RSAEncryptOutput).MapFailure(func(coer127 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg128 interface{}) interface{} {
				return coer127(arg128.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
		}))
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _3_ciphertext _dafny.Sequence
		_ = _3_ciphertext
		_3_ciphertext = (_1_valueOrError0).Extract().(_dafny.Sequence)
		var _4_output m_MaterialWrapping.WrapOutput
		_ = _4_output
		_4_output = m_MaterialWrapping.Companion_WrapOutput_.Create_WrapOutput_(_3_ciphertext, Companion_RsaWrapInfo_.Create_RsaWrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_4_output)
		return res
		return res
	}
}
func (_this *RsaWrapKeyMaterial) PublicKey() _dafny.Sequence {
	{
		return _this._publicKey
	}
}
func (_this *RsaWrapKeyMaterial) PaddingScheme() m_AwsCryptographyPrimitivesTypes.RSAPaddingMode {
	{
		return _this._paddingScheme
	}
}
func (_this *RsaWrapKeyMaterial) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}

// End of class RsaWrapKeyMaterial

// Definition of class RsaUnwrapKeyMaterial
type RsaUnwrapKeyMaterial struct {
	_privateKey       _dafny.Sequence
	_paddingScheme    m_AwsCryptographyPrimitivesTypes.RSAPaddingMode
	_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_RsaUnwrapKeyMaterial_() *RsaUnwrapKeyMaterial {
	_this := RsaUnwrapKeyMaterial{}

	_this._privateKey = _dafny.EmptySeq
	_this._paddingScheme = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Default()
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_RsaUnwrapKeyMaterial_ struct {
}

var Companion_RsaUnwrapKeyMaterial_ = CompanionStruct_RsaUnwrapKeyMaterial_{}

func (_this *RsaUnwrapKeyMaterial) Equals(other *RsaUnwrapKeyMaterial) bool {
	return _this == other
}

func (_this *RsaUnwrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*RsaUnwrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*RsaUnwrapKeyMaterial) String() string {
	return "RawRSAKeyring.RsaUnwrapKeyMaterial"
}

func Type_RsaUnwrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_RsaUnwrapKeyMaterial_{}
}

type type_RsaUnwrapKeyMaterial_ struct {
}

func (_this type_RsaUnwrapKeyMaterial_) Default() interface{} {
	return (*RsaUnwrapKeyMaterial)(nil)
}

func (_this type_RsaUnwrapKeyMaterial_) String() string {
	return "RawRSAKeyring.RsaUnwrapKeyMaterial"
}
func (_this *RsaUnwrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_UnwrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.UnwrapMaterial = &RsaUnwrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &RsaUnwrapKeyMaterial{}
var _ m_Actions.Action = &RsaUnwrapKeyMaterial{}
var _ _dafny.TraitOffspring = &RsaUnwrapKeyMaterial{}

func (_this *RsaUnwrapKeyMaterial) Ctor__(privateKey _dafny.Sequence, paddingScheme m_AwsCryptographyPrimitivesTypes.RSAPaddingMode, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._privateKey = privateKey
		(_this)._paddingScheme = paddingScheme
		(_this)._cryptoPrimitives = cryptoPrimitives
	}
}
func (_this *RsaUnwrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.UnwrapInput = input.(m_MaterialWrapping.UnwrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_UnwrapOutput_.Default(Companion_RsaUnwrapInfo_.Default()))
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = (input).Dtor_algorithmSuite()
		var _1_wrappedMaterial _dafny.Sequence
		_ = _1_wrappedMaterial
		_1_wrappedMaterial = (input).Dtor_wrappedMaterial()
		var _2_aad _dafny.Map
		_ = _2_aad
		_2_aad = (input).Dtor_encryptionContext()
		var _3_maybeDecryptResult m_Wrappers.Result
		_ = _3_maybeDecryptResult
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).CryptoPrimitives()).RSADecrypt(m_AwsCryptographyPrimitivesTypes.Companion_RSADecryptInput_.Create_RSADecryptInput_((_this).PaddingScheme(), (_this).PrivateKey(), _1_wrappedMaterial))
		_3_maybeDecryptResult = _out0
		var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError0
		_4_valueOrError0 = (_3_maybeDecryptResult).MapFailure(func(coer128 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg129 interface{}) interface{} {
				return coer128(arg129.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_5_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_5_e)
		}))
		if (_4_valueOrError0).IsFailure() {
			res = (_4_valueOrError0).PropagateFailure()
			return res
		}
		var _6_decryptResult _dafny.Sequence
		_ = _6_decryptResult
		_6_decryptResult = (_4_valueOrError0).Extract().(_dafny.Sequence)
		var _7_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _7_valueOrError1
		_7_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_6_decryptResult).Cardinality())).Cmp(_dafny.IntOfInt32(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite))) == 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid plaintext length.")))
		if (_7_valueOrError1).IsFailure() {
			res = (_7_valueOrError1).PropagateFailure()
			return res
		}
		var _8_output m_MaterialWrapping.UnwrapOutput
		_ = _8_output
		_8_output = m_MaterialWrapping.Companion_UnwrapOutput_.Create_UnwrapOutput_(_6_decryptResult, Companion_RsaUnwrapInfo_.Create_RsaUnwrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_8_output)
		return res
		return res
	}
}
func (_this *RsaUnwrapKeyMaterial) PrivateKey() _dafny.Sequence {
	{
		return _this._privateKey
	}
}
func (_this *RsaUnwrapKeyMaterial) PaddingScheme() m_AwsCryptographyPrimitivesTypes.RSAPaddingMode {
	{
		return _this._paddingScheme
	}
}
func (_this *RsaUnwrapKeyMaterial) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}

// End of class RsaUnwrapKeyMaterial
