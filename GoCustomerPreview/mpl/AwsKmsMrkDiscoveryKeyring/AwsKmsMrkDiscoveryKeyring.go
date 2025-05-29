// Package AwsKmsMrkDiscoveryKeyring
// Dafny module AwsKmsMrkDiscoveryKeyring compiled into Go

package AwsKmsMrkDiscoveryKeyring

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
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CacheConstants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CacheConstants"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
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
	m_RawAESKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawAESKeyring"
	m_RawECDHKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawECDHKeyring"
	m_RawRSAKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawRSAKeyring"
	m_StormTracker "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	m_StormTrackingCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTrackingCMC"
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
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
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
var _ m_StandardLibrary_MemoryMath.Dummy__
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
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_Constants.Dummy__
var _ m_EcdhEdkWrapping.Dummy__
var _ m_RawECDHKeyring.Dummy__
var _ m_RawRSAKeyring.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_AwsKmsEcdhKeyring.Dummy__
var _ m_LocalCMC.Dummy__
var _ m_SynchronizedLocalCMC.Dummy__
var _ m_StormTracker.Dummy__
var _ m_StormTrackingCMC.Dummy__
var _ m_CacheConstants.Dummy__
var _ m_AwsKmsHierarchicalKeyring.Dummy__

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
	return "AwsKmsMrkDiscoveryKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ToStringForRegion(arn m_AwsArnParsing.AwsArn, region _dafny.Sequence) _dafny.Sequence {
	if m_AwsArnParsing.Companion_Default___.IsMultiRegionAwsKmsArn(arn) {
		return (arn).ToArnString(m_Wrappers.Companion_Option_.Create_Some_(region))
	} else {
		return (arn).ToString()
	}
}
func (_static *CompanionStruct_Default___) DiscoveryMatch(arn m_AwsArnParsing.AwsArn, discoveryFilter m_Wrappers.Option, region _dafny.Sequence) bool {
	return (func() bool {
		var _source0 m_Wrappers.Option = discoveryFilter
		_ = _source0
		{
			if _source0.Is_Some() {
				var _0_filter m_AwsCryptographyMaterialProvidersTypes.DiscoveryFilter = _source0.Get_().(m_Wrappers.Option_Some).Value.(m_AwsCryptographyMaterialProvidersTypes.DiscoveryFilter)
				_ = _0_filter
				return (_dafny.Companion_Sequence_.Equal((_0_filter).Dtor_partition(), (arn).Dtor_partition())) && (_dafny.Companion_Sequence_.Contains((_0_filter).Dtor_accountIds(), (arn).Dtor_account()))
			}
		}
		{
			return true
		}
	}()) && ((func() bool {
		if !(m_AwsArnParsing.Companion_Default___.IsMultiRegionAwsKmsArn(arn)) {
			return _dafny.Companion_Sequence_.Equal(region, (arn).Dtor_region())
		}
		return true
	})())
}

// End of class Default__

// Definition of class AwsKmsMrkDiscoveryKeyring
type AwsKmsMrkDiscoveryKeyring struct {
	_client          m_ComAmazonawsKmsTypes.IKMSClient
	_region          _dafny.Sequence
	_discoveryFilter m_Wrappers.Option
	_grantTokens     _dafny.Sequence
}

func New_AwsKmsMrkDiscoveryKeyring_() *AwsKmsMrkDiscoveryKeyring {
	_this := AwsKmsMrkDiscoveryKeyring{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._region = _dafny.EmptySeq.SetString()
	_this._discoveryFilter = m_Wrappers.Companion_Option_.Default()
	_this._grantTokens = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_AwsKmsMrkDiscoveryKeyring_ struct {
}

var Companion_AwsKmsMrkDiscoveryKeyring_ = CompanionStruct_AwsKmsMrkDiscoveryKeyring_{}

func (_this *AwsKmsMrkDiscoveryKeyring) Equals(other *AwsKmsMrkDiscoveryKeyring) bool {
	return _this == other
}

func (_this *AwsKmsMrkDiscoveryKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsMrkDiscoveryKeyring)
	return ok && _this.Equals(other)
}

func (*AwsKmsMrkDiscoveryKeyring) String() string {
	return "AwsKmsMrkDiscoveryKeyring.AwsKmsMrkDiscoveryKeyring"
}

func Type_AwsKmsMrkDiscoveryKeyring_() _dafny.TypeDescriptor {
	return type_AwsKmsMrkDiscoveryKeyring_{}
}

type type_AwsKmsMrkDiscoveryKeyring_ struct {
}

func (_this type_AwsKmsMrkDiscoveryKeyring_) Default() interface{} {
	return (*AwsKmsMrkDiscoveryKeyring)(nil)
}

func (_this type_AwsKmsMrkDiscoveryKeyring_) String() string {
	return "AwsKmsMrkDiscoveryKeyring.AwsKmsMrkDiscoveryKeyring"
}
func (_this *AwsKmsMrkDiscoveryKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &AwsKmsMrkDiscoveryKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &AwsKmsMrkDiscoveryKeyring{}
var _ _dafny.TraitOffspring = &AwsKmsMrkDiscoveryKeyring{}

func (_this *AwsKmsMrkDiscoveryKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out8
}
func (_this *AwsKmsMrkDiscoveryKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out8
}
func (_this *AwsKmsMrkDiscoveryKeyring) Ctor__(client m_ComAmazonawsKmsTypes.IKMSClient, region _dafny.Sequence, discoveryFilter m_Wrappers.Option, grantTokens _dafny.Sequence) {
	{
		(_this)._client = client
		(_this)._region = region
		(_this)._discoveryFilter = discoveryFilter
		(_this)._grantTokens = grantTokens
	}
}
func (_this *AwsKmsMrkDiscoveryKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption is not supported with a Discovery Keyring.")))
		return output
		return output
	}
}
func (_this *AwsKmsMrkDiscoveryKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_encryptedDataKeys _dafny.Sequence
		_ = _1_encryptedDataKeys
		_1_encryptedDataKeys = (input).Dtor_encryptedDataKeys()
		var _2_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _2_suite
		_2_suite = ((input).Dtor_materials()).Dtor_algorithmSuite()
		var _3_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError0
		_3_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_0_materials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_3_valueOrError0).IsFailure() {
			output = (_3_valueOrError0).PropagateFailure()
			return output
		}
		var _4_edkFilterTransform *AwsKmsEncryptedDataKeyFilterTransform
		_ = _4_edkFilterTransform
		var _nw0 *AwsKmsEncryptedDataKeyFilterTransform = New_AwsKmsEncryptedDataKeyFilterTransform_()
		_ = _nw0
		_nw0.Ctor__((_this).Region(), (_this).DiscoveryFilter())
		_4_edkFilterTransform = _nw0
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _5_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_Actions.Companion_Default___.DeterministicFlatMapWithResult(_4_edkFilterTransform, _1_encryptedDataKeys)
		_5_valueOrError1 = _out0
		if (_5_valueOrError1).IsFailure() {
			output = (_5_valueOrError1).PropagateFailure()
			return output
		}
		var _6_edksToAttempt _dafny.Sequence
		_ = _6_edksToAttempt
		_6_edksToAttempt = (_5_valueOrError1).Extract().(_dafny.Sequence)
		if (uint64(0)) == (uint64((_6_edksToAttempt).Cardinality())) {
			var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _7_valueOrError2
			_7_valueOrError2 = m_ErrorMessages.Companion_Default___.IncorrectDataKeys((input).Dtor_encryptedDataKeys(), ((input).Dtor_materials()).Dtor_algorithmSuite(), _dafny.SeqOfString(""))
			if (_7_valueOrError2).IsFailure() {
				output = (_7_valueOrError2).PropagateFailure()
				return output
			}
			var _8_errorMessage _dafny.Sequence
			_ = _8_errorMessage
			_8_errorMessage = (_7_valueOrError2).Extract().(_dafny.Sequence)
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_8_errorMessage))
			return output
		}
		var _9_decryptAction *AwsKmsEncryptedDataKeyDecryptor
		_ = _9_decryptAction
		var _nw1 *AwsKmsEncryptedDataKeyDecryptor = New_AwsKmsEncryptedDataKeyDecryptor_()
		_ = _nw1
		_nw1.Ctor__(_0_materials, (_this).Client(), (_this).Region(), (_this).GrantTokens())
		_9_decryptAction = _nw1
		var _10_outcome m_Wrappers.Result
		_ = _10_outcome
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_Actions.Companion_Default___.ReduceToSuccess(_9_decryptAction, _6_edksToAttempt)
		_10_outcome = _out1
		var _source0 m_Wrappers.Result = _10_outcome
		_ = _source0
		{
			{
				if _source0.Is_Success() {
					var _11_mat m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials = _source0.Get_().(m_Wrappers.Result_Success).Value.(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
					_ = _11_mat
					output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_11_mat))
					goto Lmatch0
				}
			}
			{
				var _12_errors _dafny.Sequence = _source0.Get_().(m_Wrappers.Result_Failure).Error.(_dafny.Sequence)
				_ = _12_errors
				output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_12_errors, _dafny.SeqOfString("No Configured KMS Key was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`.")))
			}
			goto Lmatch0
		}
	Lmatch0:
		return output
		return output
	}
}
func (_this *AwsKmsMrkDiscoveryKeyring) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *AwsKmsMrkDiscoveryKeyring) Region() _dafny.Sequence {
	{
		return _this._region
	}
}
func (_this *AwsKmsMrkDiscoveryKeyring) DiscoveryFilter() m_Wrappers.Option {
	{
		return _this._discoveryFilter
	}
}
func (_this *AwsKmsMrkDiscoveryKeyring) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class AwsKmsMrkDiscoveryKeyring

// Definition of class AwsKmsEncryptedDataKeyFilterTransform
type AwsKmsEncryptedDataKeyFilterTransform struct {
	_region          _dafny.Sequence
	_discoveryFilter m_Wrappers.Option
}

func New_AwsKmsEncryptedDataKeyFilterTransform_() *AwsKmsEncryptedDataKeyFilterTransform {
	_this := AwsKmsEncryptedDataKeyFilterTransform{}

	_this._region = _dafny.EmptySeq.SetString()
	_this._discoveryFilter = m_Wrappers.Companion_Option_.Default()
	return &_this
}

type CompanionStruct_AwsKmsEncryptedDataKeyFilterTransform_ struct {
}

var Companion_AwsKmsEncryptedDataKeyFilterTransform_ = CompanionStruct_AwsKmsEncryptedDataKeyFilterTransform_{}

func (_this *AwsKmsEncryptedDataKeyFilterTransform) Equals(other *AwsKmsEncryptedDataKeyFilterTransform) bool {
	return _this == other
}

func (_this *AwsKmsEncryptedDataKeyFilterTransform) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsEncryptedDataKeyFilterTransform)
	return ok && _this.Equals(other)
}

func (*AwsKmsEncryptedDataKeyFilterTransform) String() string {
	return "AwsKmsMrkDiscoveryKeyring.AwsKmsEncryptedDataKeyFilterTransform"
}

func Type_AwsKmsEncryptedDataKeyFilterTransform_() _dafny.TypeDescriptor {
	return type_AwsKmsEncryptedDataKeyFilterTransform_{}
}

type type_AwsKmsEncryptedDataKeyFilterTransform_ struct {
}

func (_this type_AwsKmsEncryptedDataKeyFilterTransform_) Default() interface{} {
	return (*AwsKmsEncryptedDataKeyFilterTransform)(nil)
}

func (_this type_AwsKmsEncryptedDataKeyFilterTransform_) String() string {
	return "AwsKmsMrkDiscoveryKeyring.AwsKmsEncryptedDataKeyFilterTransform"
}
func (_this *AwsKmsEncryptedDataKeyFilterTransform) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_DeterministicActionWithResult_.TraitID_, m_Actions.Companion_DeterministicAction_.TraitID_}
}

var _ m_Actions.DeterministicActionWithResult = &AwsKmsEncryptedDataKeyFilterTransform{}
var _ m_Actions.DeterministicAction = &AwsKmsEncryptedDataKeyFilterTransform{}
var _ _dafny.TraitOffspring = &AwsKmsEncryptedDataKeyFilterTransform{}

func (_this *AwsKmsEncryptedDataKeyFilterTransform) Ctor__(region _dafny.Sequence, discoveryFilter m_Wrappers.Option) {
	{
		(_this)._region = region
		(_this)._discoveryFilter = discoveryFilter
	}
}
func (_this *AwsKmsEncryptedDataKeyFilterTransform) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = res
		if !_dafny.Companion_Sequence_.Equal((edk).Dtor_keyProviderId(), m_Constants.Companion_Default___.PROVIDER__ID()) {
			res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf())
			return res
		}
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq((edk).Dtor_keyProviderInfo()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid AWS KMS encoding, provider info is not UTF8.")))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _1_valueOrError1
		_1_valueOrError1 = (m_UTF8.Decode((edk).Dtor_keyProviderInfo())).MapFailure(func(coer104 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg105 interface{}) interface{} {
				return coer104(arg105.(_dafny.Sequence))
			}
		}(func(_2_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_2_e)
		}))
		if (_1_valueOrError1).IsFailure() {
			res = (_1_valueOrError1).PropagateFailure()
			return res
		}
		var _3_keyId _dafny.Sequence
		_ = _3_keyId
		_3_keyId = (_1_valueOrError1).Extract().(_dafny.Sequence)
		var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError2
		_4_valueOrError2 = (m_AwsArnParsing.Companion_Default___.ParseAwsKmsArn(_3_keyId)).MapFailure(func(coer105 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg106 interface{}) interface{} {
				return coer105(arg106.(_dafny.Sequence))
			}
		}(func(_5_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_5_e)
		}))
		if (_4_valueOrError2).IsFailure() {
			res = (_4_valueOrError2).PropagateFailure()
			return res
		}
		var _6_arn m_AwsArnParsing.AwsArn
		_ = _6_arn
		_6_arn = (_4_valueOrError2).Extract().(m_AwsArnParsing.AwsArn)
		var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _7_valueOrError3
		_7_valueOrError3 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(((_6_arn).Dtor_resource()).Dtor_resourceType(), _dafny.SeqOfString("key")), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Only AWS KMS Keys supported")))
		if (_7_valueOrError3).IsFailure() {
			res = (_7_valueOrError3).PropagateFailure()
			return res
		}
		if !(Companion_Default___.DiscoveryMatch(_6_arn, (_this).DiscoveryFilter(), (_this).Region())) {
			res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf())
			return res
		}
		res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(m_Constants.Companion_AwsKmsEdkHelper_.Create_AwsKmsEdkHelper_(edk, _6_arn)))
		return res
		return res
	}
}
func (_this *AwsKmsEncryptedDataKeyFilterTransform) Region() _dafny.Sequence {
	{
		return _this._region
	}
}
func (_this *AwsKmsEncryptedDataKeyFilterTransform) DiscoveryFilter() m_Wrappers.Option {
	{
		return _this._discoveryFilter
	}
}

// End of class AwsKmsEncryptedDataKeyFilterTransform

// Definition of class AwsKmsEncryptedDataKeyDecryptor
type AwsKmsEncryptedDataKeyDecryptor struct {
	_materials   m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_client      m_ComAmazonawsKmsTypes.IKMSClient
	_region      _dafny.Sequence
	_grantTokens _dafny.Sequence
}

func New_AwsKmsEncryptedDataKeyDecryptor_() *AwsKmsEncryptedDataKeyDecryptor {
	_this := AwsKmsEncryptedDataKeyDecryptor{}

	_this._materials = m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials{}
	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._region = _dafny.EmptySeq.SetString()
	_this._grantTokens = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_AwsKmsEncryptedDataKeyDecryptor_ struct {
}

var Companion_AwsKmsEncryptedDataKeyDecryptor_ = CompanionStruct_AwsKmsEncryptedDataKeyDecryptor_{}

func (_this *AwsKmsEncryptedDataKeyDecryptor) Equals(other *AwsKmsEncryptedDataKeyDecryptor) bool {
	return _this == other
}

func (_this *AwsKmsEncryptedDataKeyDecryptor) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsEncryptedDataKeyDecryptor)
	return ok && _this.Equals(other)
}

func (*AwsKmsEncryptedDataKeyDecryptor) String() string {
	return "AwsKmsMrkDiscoveryKeyring.AwsKmsEncryptedDataKeyDecryptor"
}

func Type_AwsKmsEncryptedDataKeyDecryptor_() _dafny.TypeDescriptor {
	return type_AwsKmsEncryptedDataKeyDecryptor_{}
}

type type_AwsKmsEncryptedDataKeyDecryptor_ struct {
}

func (_this type_AwsKmsEncryptedDataKeyDecryptor_) Default() interface{} {
	return (*AwsKmsEncryptedDataKeyDecryptor)(nil)
}

func (_this type_AwsKmsEncryptedDataKeyDecryptor_) String() string {
	return "AwsKmsMrkDiscoveryKeyring.AwsKmsEncryptedDataKeyDecryptor"
}
func (_this *AwsKmsEncryptedDataKeyDecryptor) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_Actions.ActionWithResult = &AwsKmsEncryptedDataKeyDecryptor{}
var _ m_Actions.Action = &AwsKmsEncryptedDataKeyDecryptor{}
var _ _dafny.TraitOffspring = &AwsKmsEncryptedDataKeyDecryptor{}

func (_this *AwsKmsEncryptedDataKeyDecryptor) Ctor__(materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, client m_ComAmazonawsKmsTypes.IKMSClient, region _dafny.Sequence, grantTokens _dafny.Sequence) {
	{
		(_this)._materials = materials
		(_this)._client = client
		(_this)._region = region
		(_this)._grantTokens = grantTokens
	}
}
func (_this *AwsKmsEncryptedDataKeyDecryptor) Invoke(helper interface{}) interface{} {
	{
		var helper m_Constants.AwsKmsEdkHelper = helper.(m_Constants.AwsKmsEdkHelper)
		_ = helper
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_awsKmsKey _dafny.Sequence
		_ = _0_awsKmsKey
		_0_awsKmsKey = Companion_Default___.ToStringForRegion((helper).Dtor_arn(), (_this).Region())
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = _1_valueOrError0
		_1_valueOrError0 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId(_0_awsKmsKey)
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _2___v0 _dafny.Tuple
		_ = _2___v0
		_2___v0 = (_1_valueOrError0).Extract().(_dafny.Tuple)
		var _3_kmsUnwrap *m_AwsKmsKeyring.KmsUnwrapKeyMaterial
		_ = _3_kmsUnwrap
		var _nw0 *m_AwsKmsKeyring.KmsUnwrapKeyMaterial = m_AwsKmsKeyring.New_KmsUnwrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).Client(), _0_awsKmsKey, (_this).GrantTokens())
		_3_kmsUnwrap = _nw0
		var _4_unwrapOutputRes m_Wrappers.Result
		_ = _4_unwrapOutputRes
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial(((helper).Dtor_edk()).Dtor_ciphertext(), (_this).Materials(), _3_kmsUnwrap)
		_4_unwrapOutputRes = _out0
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_UnwrapEdkMaterialOutput_.Default(m_AwsKmsKeyring.Companion_KmsUnwrapInfo_.Default()))
		_ = _5_valueOrError1
		_5_valueOrError1 = _4_unwrapOutputRes
		if (_5_valueOrError1).IsFailure() {
			res = (_5_valueOrError1).PropagateFailure()
			return res
		}
		var _6_unwrapOutput m_EdkWrapping.UnwrapEdkMaterialOutput
		_ = _6_unwrapOutput
		_6_unwrapOutput = (_5_valueOrError1).Extract().(m_EdkWrapping.UnwrapEdkMaterialOutput)
		res = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey((_this).Materials(), (_6_unwrapOutput).Dtor_plaintextDataKey(), (_6_unwrapOutput).Dtor_symmetricSigningKey())
		return res
	}
}
func (_this *AwsKmsEncryptedDataKeyDecryptor) Materials() m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials {
	{
		return _this._materials
	}
}
func (_this *AwsKmsEncryptedDataKeyDecryptor) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *AwsKmsEncryptedDataKeyDecryptor) Region() _dafny.Sequence {
	{
		return _this._region
	}
}
func (_this *AwsKmsEncryptedDataKeyDecryptor) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class AwsKmsEncryptedDataKeyDecryptor
