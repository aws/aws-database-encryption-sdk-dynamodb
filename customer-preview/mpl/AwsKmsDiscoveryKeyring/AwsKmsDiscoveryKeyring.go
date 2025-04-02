// Package AwsKmsDiscoveryKeyring
// Dafny module AwsKmsDiscoveryKeyring compiled into Go

package AwsKmsDiscoveryKeyring

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
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_EdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EdkWrapping"
	m_ErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/ErrorMessages"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_IntermediateKeyWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/IntermediateKeyWrapping"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
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
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_StrictMultiKeyring.Dummy__

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
	return "AwsKmsDiscoveryKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DiscoveryMatch(arn m_AwsArnParsing.AwsArn, discoveryFilter m_Wrappers.Option) bool {
	return (true) && (func() bool {
		var _source0 m_Wrappers.Option = discoveryFilter
		_ = _source0
		{
			if _source0.Is_Some() {
				var _0_filter m_AwsCryptographyMaterialProvidersTypes.DiscoveryFilter = _source0.Get_().(m_Wrappers.Option_Some).Value.(m_AwsCryptographyMaterialProvidersTypes.DiscoveryFilter)
				_ = _0_filter
				return (_dafny.Companion_Sequence_.Equal((_0_filter).Dtor_partition(), (arn).Dtor_partition())) && (_dafny.Companion_Sequence_.IsPrefixOf((_0_filter).Dtor_accountIds(), _dafny.SeqOf((arn).Dtor_account())))
			}
		}
		{
			return true
		}
	}())
}

// End of class Default__

// Definition of class AwsKmsDiscoveryKeyring
type AwsKmsDiscoveryKeyring struct {
	_client          m_ComAmazonawsKmsTypes.IKMSClient
	_discoveryFilter m_Wrappers.Option
	_grantTokens     _dafny.Sequence
}

func New_AwsKmsDiscoveryKeyring_() *AwsKmsDiscoveryKeyring {
	_this := AwsKmsDiscoveryKeyring{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._discoveryFilter = m_Wrappers.Companion_Option_.Default()
	_this._grantTokens = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_AwsKmsDiscoveryKeyring_ struct {
}

var Companion_AwsKmsDiscoveryKeyring_ = CompanionStruct_AwsKmsDiscoveryKeyring_{}

func (_this *AwsKmsDiscoveryKeyring) Equals(other *AwsKmsDiscoveryKeyring) bool {
	return _this == other
}

func (_this *AwsKmsDiscoveryKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsDiscoveryKeyring)
	return ok && _this.Equals(other)
}

func (*AwsKmsDiscoveryKeyring) String() string {
	return "AwsKmsDiscoveryKeyring.AwsKmsDiscoveryKeyring"
}

func Type_AwsKmsDiscoveryKeyring_() _dafny.TypeDescriptor {
	return type_AwsKmsDiscoveryKeyring_{}
}

type type_AwsKmsDiscoveryKeyring_ struct {
}

func (_this type_AwsKmsDiscoveryKeyring_) Default() interface{} {
	return (*AwsKmsDiscoveryKeyring)(nil)
}

func (_this type_AwsKmsDiscoveryKeyring_) String() string {
	return "AwsKmsDiscoveryKeyring.AwsKmsDiscoveryKeyring"
}
func (_this *AwsKmsDiscoveryKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &AwsKmsDiscoveryKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &AwsKmsDiscoveryKeyring{}
var _ _dafny.TraitOffspring = &AwsKmsDiscoveryKeyring{}

func (_this *AwsKmsDiscoveryKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out3
}
func (_this *AwsKmsDiscoveryKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out3
}
func (_this *AwsKmsDiscoveryKeyring) Ctor__(client m_ComAmazonawsKmsTypes.IKMSClient, discoveryFilter m_Wrappers.Option, grantTokens _dafny.Sequence) {
	{
		(_this)._client = client
		(_this)._discoveryFilter = discoveryFilter
		(_this)._grantTokens = grantTokens
	}
}
func (_this *AwsKmsDiscoveryKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption is not supported with a Discovery Keyring.")))
		return output
		return output
	}
}
func (_this *AwsKmsDiscoveryKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
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
			res = (_3_valueOrError0).PropagateFailure()
			return res
		}
		var _4_edkFilter *AwsKmsEncryptedDataKeyFilter
		_ = _4_edkFilter
		var _nw0 *AwsKmsEncryptedDataKeyFilter = New_AwsKmsEncryptedDataKeyFilter_()
		_ = _nw0
		_nw0.Ctor__((_this).DiscoveryFilter())
		_4_edkFilter = _nw0
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _5_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_Actions.Companion_Default___.FilterWithResult(_4_edkFilter, _1_encryptedDataKeys)
		_5_valueOrError1 = _out0
		if (_5_valueOrError1).IsFailure() {
			res = (_5_valueOrError1).PropagateFailure()
			return res
		}
		var _6_matchingEdks _dafny.Sequence
		_ = _6_matchingEdks
		_6_matchingEdks = (_5_valueOrError1).Extract().(_dafny.Sequence)
		var _7_edkTransform *AwsKmsEncryptedDataKeyTransformer
		_ = _7_edkTransform
		var _nw1 *AwsKmsEncryptedDataKeyTransformer = New_AwsKmsEncryptedDataKeyTransformer_()
		_ = _nw1
		_nw1.Ctor__()
		_7_edkTransform = _nw1
		var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _8_valueOrError2
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_Actions.Companion_Default___.DeterministicFlatMapWithResult(_7_edkTransform, _6_matchingEdks)
		_8_valueOrError2 = _out1
		if (_8_valueOrError2).IsFailure() {
			res = (_8_valueOrError2).PropagateFailure()
			return res
		}
		var _9_edksToAttempt _dafny.Sequence
		_ = _9_edksToAttempt
		_9_edksToAttempt = (_8_valueOrError2).Extract().(_dafny.Sequence)
		if (_dafny.IntOfUint32((_9_edksToAttempt).Cardinality())).Sign() == 0 {
			var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _10_valueOrError3
			_10_valueOrError3 = m_ErrorMessages.Companion_Default___.IncorrectDataKeys((input).Dtor_encryptedDataKeys(), ((input).Dtor_materials()).Dtor_algorithmSuite(), _dafny.SeqOfString(""))
			if (_10_valueOrError3).IsFailure() {
				res = (_10_valueOrError3).PropagateFailure()
				return res
			}
			var _11_errorMessage _dafny.Sequence
			_ = _11_errorMessage
			_11_errorMessage = (_10_valueOrError3).Extract().(_dafny.Sequence)
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_11_errorMessage))
			return res
		}
		var _12_decryptAction *AwsKmsEncryptedDataKeyDecryptor
		_ = _12_decryptAction
		var _nw2 *AwsKmsEncryptedDataKeyDecryptor = New_AwsKmsEncryptedDataKeyDecryptor_()
		_ = _nw2
		_nw2.Ctor__(_0_materials, (_this).Client(), (_this).GrantTokens())
		_12_decryptAction = _nw2
		var _13_outcome m_Wrappers.Result
		_ = _13_outcome
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_Actions.Companion_Default___.ReduceToSuccess(_12_decryptAction, _9_edksToAttempt)
		_13_outcome = _out2
		var _source0 m_Wrappers.Result = _13_outcome
		_ = _source0
		{
			{
				if _source0.Is_Success() {
					var _14_mat m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials = _source0.Get_().(m_Wrappers.Result_Success).Value.(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
					_ = _14_mat
					res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_14_mat))
					goto Lmatch0
				}
			}
			{
				var _15_errors _dafny.Sequence = _source0.Get_().(m_Wrappers.Result_Failure).Error.(_dafny.Sequence)
				_ = _15_errors
				res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_15_errors, _dafny.SeqOfString("No Configured KMS Key was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`.")))
			}
			goto Lmatch0
		}
	Lmatch0:
		return res
		return res
	}
}
func (_this *AwsKmsDiscoveryKeyring) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *AwsKmsDiscoveryKeyring) DiscoveryFilter() m_Wrappers.Option {
	{
		return _this._discoveryFilter
	}
}
func (_this *AwsKmsDiscoveryKeyring) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class AwsKmsDiscoveryKeyring

// Definition of class AwsKmsEncryptedDataKeyFilter
type AwsKmsEncryptedDataKeyFilter struct {
	_discoveryFilter m_Wrappers.Option
}

func New_AwsKmsEncryptedDataKeyFilter_() *AwsKmsEncryptedDataKeyFilter {
	_this := AwsKmsEncryptedDataKeyFilter{}

	_this._discoveryFilter = m_Wrappers.Companion_Option_.Default()
	return &_this
}

type CompanionStruct_AwsKmsEncryptedDataKeyFilter_ struct {
}

var Companion_AwsKmsEncryptedDataKeyFilter_ = CompanionStruct_AwsKmsEncryptedDataKeyFilter_{}

func (_this *AwsKmsEncryptedDataKeyFilter) Equals(other *AwsKmsEncryptedDataKeyFilter) bool {
	return _this == other
}

func (_this *AwsKmsEncryptedDataKeyFilter) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsEncryptedDataKeyFilter)
	return ok && _this.Equals(other)
}

func (*AwsKmsEncryptedDataKeyFilter) String() string {
	return "AwsKmsDiscoveryKeyring.AwsKmsEncryptedDataKeyFilter"
}

func Type_AwsKmsEncryptedDataKeyFilter_() _dafny.TypeDescriptor {
	return type_AwsKmsEncryptedDataKeyFilter_{}
}

type type_AwsKmsEncryptedDataKeyFilter_ struct {
}

func (_this type_AwsKmsEncryptedDataKeyFilter_) Default() interface{} {
	return (*AwsKmsEncryptedDataKeyFilter)(nil)
}

func (_this type_AwsKmsEncryptedDataKeyFilter_) String() string {
	return "AwsKmsDiscoveryKeyring.AwsKmsEncryptedDataKeyFilter"
}
func (_this *AwsKmsEncryptedDataKeyFilter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_DeterministicActionWithResult_.TraitID_, m_Actions.Companion_DeterministicAction_.TraitID_}
}

var _ m_Actions.DeterministicActionWithResult = &AwsKmsEncryptedDataKeyFilter{}
var _ m_Actions.DeterministicAction = &AwsKmsEncryptedDataKeyFilter{}
var _ _dafny.TraitOffspring = &AwsKmsEncryptedDataKeyFilter{}

func (_this *AwsKmsEncryptedDataKeyFilter) Ctor__(discoveryFilter m_Wrappers.Option) {
	{
		(_this)._discoveryFilter = discoveryFilter
	}
}
func (_this *AwsKmsEncryptedDataKeyFilter) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = output
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq((edk).Dtor_keyProviderInfo()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid AWS KMS encoding, provider info is not UTF8.")))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _1_valueOrError1
		_1_valueOrError1 = (m_UTF8.Decode((edk).Dtor_keyProviderInfo())).MapFailure(func(coer63 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg64 interface{}) interface{} {
				return coer63(arg64.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_1_valueOrError1).IsFailure() {
			output = (_1_valueOrError1).PropagateFailure()
			return output
		}
		var _2_keyId _dafny.Sequence
		_ = _2_keyId
		_2_keyId = (_1_valueOrError1).Extract().(_dafny.Sequence)
		var _3_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError2
		_3_valueOrError2 = (m_AwsArnParsing.Companion_Default___.ParseAwsKmsArn(_2_keyId)).MapFailure(func(coer64 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg65 interface{}) interface{} {
				return coer64(arg65.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_3_valueOrError2).IsFailure() {
			output = (_3_valueOrError2).PropagateFailure()
			return output
		}
		var _4_arn m_AwsArnParsing.AwsArn
		_ = _4_arn
		_4_arn = (_3_valueOrError2).Extract().(m_AwsArnParsing.AwsArn)
		var _5_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _5_valueOrError3
		_5_valueOrError3 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(((_4_arn).Dtor_resource()).Dtor_resourceType(), _dafny.SeqOfString("key")), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Only AWS KMS Keys supported")))
		if (_5_valueOrError3).IsFailure() {
			output = (_5_valueOrError3).PropagateFailure()
			return output
		}
		if !_dafny.Companion_Sequence_.Equal((edk).Dtor_keyProviderId(), m_Constants.Companion_Default___.PROVIDER__ID()) {
			output = m_Wrappers.Companion_Result_.Create_Success_(false)
			return output
		}
		if !(Companion_Default___.DiscoveryMatch(_4_arn, (_this).DiscoveryFilter())) {
			output = m_Wrappers.Companion_Result_.Create_Success_(false)
			return output
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(true)
		return output
		return output
	}
}
func (_this *AwsKmsEncryptedDataKeyFilter) DiscoveryFilter() m_Wrappers.Option {
	{
		return _this._discoveryFilter
	}
}

// End of class AwsKmsEncryptedDataKeyFilter

// Definition of class AwsKmsEncryptedDataKeyTransformer
type AwsKmsEncryptedDataKeyTransformer struct {
	dummy byte
}

func New_AwsKmsEncryptedDataKeyTransformer_() *AwsKmsEncryptedDataKeyTransformer {
	_this := AwsKmsEncryptedDataKeyTransformer{}

	return &_this
}

type CompanionStruct_AwsKmsEncryptedDataKeyTransformer_ struct {
}

var Companion_AwsKmsEncryptedDataKeyTransformer_ = CompanionStruct_AwsKmsEncryptedDataKeyTransformer_{}

func (_this *AwsKmsEncryptedDataKeyTransformer) Equals(other *AwsKmsEncryptedDataKeyTransformer) bool {
	return _this == other
}

func (_this *AwsKmsEncryptedDataKeyTransformer) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsEncryptedDataKeyTransformer)
	return ok && _this.Equals(other)
}

func (*AwsKmsEncryptedDataKeyTransformer) String() string {
	return "AwsKmsDiscoveryKeyring.AwsKmsEncryptedDataKeyTransformer"
}

func Type_AwsKmsEncryptedDataKeyTransformer_() _dafny.TypeDescriptor {
	return type_AwsKmsEncryptedDataKeyTransformer_{}
}

type type_AwsKmsEncryptedDataKeyTransformer_ struct {
}

func (_this type_AwsKmsEncryptedDataKeyTransformer_) Default() interface{} {
	return (*AwsKmsEncryptedDataKeyTransformer)(nil)
}

func (_this type_AwsKmsEncryptedDataKeyTransformer_) String() string {
	return "AwsKmsDiscoveryKeyring.AwsKmsEncryptedDataKeyTransformer"
}
func (_this *AwsKmsEncryptedDataKeyTransformer) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_DeterministicActionWithResult_.TraitID_, m_Actions.Companion_DeterministicAction_.TraitID_}
}

var _ m_Actions.DeterministicActionWithResult = &AwsKmsEncryptedDataKeyTransformer{}
var _ m_Actions.DeterministicAction = &AwsKmsEncryptedDataKeyTransformer{}
var _ _dafny.TraitOffspring = &AwsKmsEncryptedDataKeyTransformer{}

func (_this *AwsKmsEncryptedDataKeyTransformer) Ctor__() {
	{
	}
}
func (_this *AwsKmsEncryptedDataKeyTransformer) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = res
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal((edk).Dtor_keyProviderId(), m_Constants.Companion_Default___.PROVIDER__ID()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encrypted data key was not generated by KMS")))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _1_valueOrError1
		_1_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq((edk).Dtor_keyProviderInfo()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid AWS KMS encoding, provider info is not UTF8.")))
		if (_1_valueOrError1).IsFailure() {
			res = (_1_valueOrError1).PropagateFailure()
			return res
		}
		var _2_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _2_valueOrError2
		_2_valueOrError2 = (m_UTF8.Decode((edk).Dtor_keyProviderInfo())).MapFailure(func(coer65 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg66 interface{}) interface{} {
				return coer65(arg66.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_2_valueOrError2).IsFailure() {
			res = (_2_valueOrError2).PropagateFailure()
			return res
		}
		var _3_keyId _dafny.Sequence
		_ = _3_keyId
		_3_keyId = (_2_valueOrError2).Extract().(_dafny.Sequence)
		var _4_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError3
		_4_valueOrError3 = (m_AwsArnParsing.Companion_Default___.ParseAwsKmsArn(_3_keyId)).MapFailure(func(coer66 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg67 interface{}) interface{} {
				return coer66(arg67.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_4_valueOrError3).IsFailure() {
			res = (_4_valueOrError3).PropagateFailure()
			return res
		}
		var _5_arn m_AwsArnParsing.AwsArn
		_ = _5_arn
		_5_arn = (_4_valueOrError3).Extract().(m_AwsArnParsing.AwsArn)
		res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(m_Constants.Companion_AwsKmsEdkHelper_.Create_AwsKmsEdkHelper_(edk, _5_arn)))
		return res
		return res
	}
}

// End of class AwsKmsEncryptedDataKeyTransformer

// Definition of class AwsKmsEncryptedDataKeyDecryptor
type AwsKmsEncryptedDataKeyDecryptor struct {
	_materials   m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_client      m_ComAmazonawsKmsTypes.IKMSClient
	_grantTokens _dafny.Sequence
}

func New_AwsKmsEncryptedDataKeyDecryptor_() *AwsKmsEncryptedDataKeyDecryptor {
	_this := AwsKmsEncryptedDataKeyDecryptor{}

	_this._materials = m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials{}
	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
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
	return "AwsKmsDiscoveryKeyring.AwsKmsEncryptedDataKeyDecryptor"
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
	return "AwsKmsDiscoveryKeyring.AwsKmsEncryptedDataKeyDecryptor"
}
func (_this *AwsKmsEncryptedDataKeyDecryptor) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_Actions.ActionWithResult = &AwsKmsEncryptedDataKeyDecryptor{}
var _ m_Actions.Action = &AwsKmsEncryptedDataKeyDecryptor{}
var _ _dafny.TraitOffspring = &AwsKmsEncryptedDataKeyDecryptor{}

func (_this *AwsKmsEncryptedDataKeyDecryptor) Ctor__(materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, client m_ComAmazonawsKmsTypes.IKMSClient, grantTokens _dafny.Sequence) {
	{
		(_this)._materials = materials
		(_this)._client = client
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
		_0_awsKmsKey = ((helper).Dtor_arn()).ToString()
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = _1_valueOrError0
		_1_valueOrError0 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId(((helper).Dtor_arn()).ToString())
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
		var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _7_valueOrError2
		_7_valueOrError2 = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey((_this).Materials(), (_6_unwrapOutput).Dtor_plaintextDataKey(), (_6_unwrapOutput).Dtor_symmetricSigningKey())
		if (_7_valueOrError2).IsFailure() {
			res = (_7_valueOrError2).PropagateFailure()
			return res
		}
		var _8_result m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _8_result
		_8_result = (_7_valueOrError2).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(_8_result)
		return res
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
func (_this *AwsKmsEncryptedDataKeyDecryptor) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class AwsKmsEncryptedDataKeyDecryptor
