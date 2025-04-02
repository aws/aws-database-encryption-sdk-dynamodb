// Package RequiredEncryptionContextCMM
// Dafny module RequiredEncryptionContextCMM compiled into Go

package RequiredEncryptionContextCMM

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
	m_CMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CMM"
	m_CacheConstants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CacheConstants"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Commitment "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Commitment"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_DefaultCMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DefaultCMM"
	m_DefaultClientSupplier "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DefaultClientSupplier"
	m_Defaults "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Defaults"
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
	m_RawRSAKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawRSAKeyring"
	m_StormTracker "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	m_StormTrackingCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTrackingCMC"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
	m_SynchronizedLocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/SynchronizedLocalCMC"
	m_Utils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Utils"
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
	m_SortedSets "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/SortedSets"
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
var _ m_RawRSAKeyring.Dummy__
var _ m_CMM.Dummy__
var _ m_Defaults.Dummy__
var _ m_Commitment.Dummy__
var _ m_DefaultCMM.Dummy__
var _ m_DefaultClientSupplier.Dummy__
var _ m_Utils.Dummy__

type Dummy__ struct{}

// Definition of class RequiredEncryptionContextCMM
type RequiredEncryptionContextCMM struct {
	_underlyingCMM                 m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	_requiredEncryptionContextKeys _dafny.Sequence
}

func New_RequiredEncryptionContextCMM_() *RequiredEncryptionContextCMM {
	_this := RequiredEncryptionContextCMM{}

	_this._underlyingCMM = (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)(nil)
	_this._requiredEncryptionContextKeys = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_RequiredEncryptionContextCMM_ struct {
}

var Companion_RequiredEncryptionContextCMM_ = CompanionStruct_RequiredEncryptionContextCMM_{}

func (_this *RequiredEncryptionContextCMM) Equals(other *RequiredEncryptionContextCMM) bool {
	return _this == other
}

func (_this *RequiredEncryptionContextCMM) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*RequiredEncryptionContextCMM)
	return ok && _this.Equals(other)
}

func (*RequiredEncryptionContextCMM) String() string {
	return "RequiredEncryptionContextCMM.RequiredEncryptionContextCMM"
}

func Type_RequiredEncryptionContextCMM_() _dafny.TypeDescriptor {
	return type_RequiredEncryptionContextCMM_{}
}

type type_RequiredEncryptionContextCMM_ struct {
}

func (_this type_RequiredEncryptionContextCMM_) Default() interface{} {
	return (*RequiredEncryptionContextCMM)(nil)
}

func (_this type_RequiredEncryptionContextCMM_) String() string {
	return "RequiredEncryptionContextCMM.RequiredEncryptionContextCMM"
}
func (_this *RequiredEncryptionContextCMM) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_CMM.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.TraitID_}
}

var _ m_CMM.VerifiableInterface = &RequiredEncryptionContextCMM{}
var _ m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager = &RequiredEncryptionContextCMM{}
var _ _dafny.TraitOffspring = &RequiredEncryptionContextCMM{}

func (_this *RequiredEncryptionContextCMM) DecryptMaterials(input m_AwsCryptographyMaterialProvidersTypes.DecryptMaterialsInput) m_Wrappers.Result {
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.DecryptMaterials(_this, input)
	return _out2
}
func (_this *RequiredEncryptionContextCMM) GetEncryptionMaterials(input m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput) m_Wrappers.Result {
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.GetEncryptionMaterials(_this, input)
	return _out2
}
func (_this *RequiredEncryptionContextCMM) Ctor__(inputCMM m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager, inputKeys _dafny.Set) {
	{
		var _0_keySet _dafny.Set
		_ = _0_keySet
		_0_keySet = inputKeys
		var _1_keySeq _dafny.Sequence
		_ = _1_keySeq
		var _out0 _dafny.Sequence
		_ = _out0
		_out0 = m_SortedSets.SetToSequence(_0_keySet)
		_1_keySeq = _out0
		(_this)._underlyingCMM = inputCMM
		(_this)._requiredEncryptionContextKeys = _1_keySeq
	}
}
func (_this *RequiredEncryptionContextCMM) GetEncryptionMaterials_k(input m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((_this).RequiredEncryptionContextKeys()).UniqueElements(), true, func(_forall_var_0 _dafny.Sequence) bool {
			var _1_k _dafny.Sequence
			_1_k = interface{}(_forall_var_0).(_dafny.Sequence)
			if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_1_k) {
				return !(_dafny.Companion_Sequence_.Contains((_this).RequiredEncryptionContextKeys(), _1_k)) || (((input).Dtor_encryptionContext()).Contains(_1_k))
			} else {
				return true
			}
		}), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption context does not contain required keys.")))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError1
		var _pat_let_tv0 = input
		_ = _pat_let_tv0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).UnderlyingCMM()).GetEncryptionMaterials(func(_pat_let8_0 m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput) m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput {
			return func(_3_dt__update__tmp_h0 m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput) m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput {
				return func(_pat_let9_0 m_Wrappers.Option) m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput {
					return func(_4_dt__update_hrequiredEncryptionContextKeys_h0 m_Wrappers.Option) m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput {
						return m_AwsCryptographyMaterialProvidersTypes.Companion_GetEncryptionMaterialsInput_.Create_GetEncryptionMaterialsInput_((_3_dt__update__tmp_h0).Dtor_encryptionContext(), (_3_dt__update__tmp_h0).Dtor_commitmentPolicy(), (_3_dt__update__tmp_h0).Dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).Dtor_maxPlaintextLength(), _4_dt__update_hrequiredEncryptionContextKeys_h0)
					}(_pat_let9_0)
				}(m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(((_pat_let_tv0).Dtor_requiredEncryptionContextKeys()).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence), (_this).RequiredEncryptionContextKeys())))
			}(_pat_let8_0)
		}(input))
		_2_valueOrError1 = _out0
		if (_2_valueOrError1).IsFailure() {
			output = (_2_valueOrError1).PropagateFailure()
			return output
		}
		var _5_result m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsOutput
		_ = _5_result
		_5_result = (_2_valueOrError1).Extract().(m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsOutput)
		var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _6_valueOrError2
		_6_valueOrError2 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((_this).RequiredEncryptionContextKeys()).UniqueElements(), true, func(_forall_var_1 _dafny.Sequence) bool {
			var _7_k _dafny.Sequence
			_7_k = interface{}(_forall_var_1).(_dafny.Sequence)
			if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_7_k) {
				return !(_dafny.Companion_Sequence_.Contains((_this).RequiredEncryptionContextKeys(), _7_k)) || (_dafny.Companion_Sequence_.Contains(((_5_result).Dtor_encryptionMaterials()).Dtor_requiredEncryptionContextKeys(), _7_k))
			} else {
				return true
			}
		}), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Expected encryption context keys do not exist in keys to only authenticate.")))
		if (_6_valueOrError2).IsFailure() {
			output = (_6_valueOrError2).PropagateFailure()
			return output
		}
		var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError3
		_8_valueOrError3 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.EncryptionMaterialsHasPlaintextDataKey((_5_result).Dtor_encryptionMaterials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Could not retrieve materials required for encryption")))
		if (_8_valueOrError3).IsFailure() {
			output = (_8_valueOrError3).PropagateFailure()
			return output
		}
		var _9_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _9_valueOrError4
		_9_valueOrError4 = m_Wrappers.Companion_Default___.Need(m_CMM.Companion_Default___.RequiredEncryptionContextKeys_q((input).Dtor_requiredEncryptionContextKeys(), (_5_result).Dtor_encryptionMaterials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring returned an invalid response")))
		if (_9_valueOrError4).IsFailure() {
			output = (_9_valueOrError4).PropagateFailure()
			return output
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(_5_result)
		return output
	}
}
func (_this *RequiredEncryptionContextCMM) DecryptMaterials_k(input m_AwsCryptographyMaterialProvidersTypes.DecryptMaterialsInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(((input).Dtor_reproducedEncryptionContext()).Is_Some(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("No reproduced encryption context on decrypt.")))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _1_valueOrError1
		_1_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_CMM.Companion_Default___.ReproducedEncryptionContext_q(input), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption context does not match reproduced encryption context.")))
		if (_1_valueOrError1).IsFailure() {
			output = (_1_valueOrError1).PropagateFailure()
			return output
		}
		var _2_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError2
		_2_valueOrError2 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((_this).RequiredEncryptionContextKeys()).UniqueElements(), true, func(_forall_var_0 _dafny.Sequence) bool {
			var _3_k _dafny.Sequence
			_3_k = interface{}(_forall_var_0).(_dafny.Sequence)
			if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_3_k) {
				return !(_dafny.Companion_Sequence_.Contains((_this).RequiredEncryptionContextKeys(), _3_k)) || ((((input).Dtor_reproducedEncryptionContext()).Dtor_value().(_dafny.Map)).Contains(_3_k))
			} else {
				return true
			}
		}), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Reproduced encryption context missing required keys.")))
		if (_2_valueOrError2).IsFailure() {
			output = (_2_valueOrError2).PropagateFailure()
			return output
		}
		var _4_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError3
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).UnderlyingCMM()).DecryptMaterials(input)
		_4_valueOrError3 = _out0
		if (_4_valueOrError3).IsFailure() {
			output = (_4_valueOrError3).PropagateFailure()
			return output
		}
		var _5_result m_AwsCryptographyMaterialProvidersTypes.DecryptMaterialsOutput
		_ = _5_result
		_5_result = (_4_valueOrError3).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptMaterialsOutput)
		var _6_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _6_valueOrError4
		_6_valueOrError4 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((_this).RequiredEncryptionContextKeys()).UniqueElements(), true, func(_forall_var_1 _dafny.Sequence) bool {
			var _7_k _dafny.Sequence
			_7_k = interface{}(_forall_var_1).(_dafny.Sequence)
			if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_7_k) {
				return !(_dafny.Companion_Sequence_.Contains((_this).RequiredEncryptionContextKeys(), _7_k)) || ((((_5_result).Dtor_decryptionMaterials()).Dtor_encryptionContext()).Contains(_7_k))
			} else {
				return true
			}
		}), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Final encryption context missing required keys.")))
		if (_6_valueOrError4).IsFailure() {
			output = (_6_valueOrError4).PropagateFailure()
			return output
		}
		var _8_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError5
		_8_valueOrError5 = m_Wrappers.Companion_Default___.Need(m_CMM.Companion_Default___.EncryptionContextComplete(input, (_5_result).Dtor_decryptionMaterials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Reproduced encryption context missing from encryption context.")))
		if (_8_valueOrError5).IsFailure() {
			output = (_8_valueOrError5).PropagateFailure()
			return output
		}
		var _9_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _9_valueOrError6
		_9_valueOrError6 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithPlaintextDataKey((_5_result).Dtor_decryptionMaterials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring.OnDecrypt failed to decrypt the plaintext data key.")))
		if (_9_valueOrError6).IsFailure() {
			output = (_9_valueOrError6).PropagateFailure()
			return output
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(_5_result)
		return output
		return output
	}
}
func (_this *RequiredEncryptionContextCMM) UnderlyingCMM() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager {
	{
		return _this._underlyingCMM
	}
}
func (_this *RequiredEncryptionContextCMM) RequiredEncryptionContextKeys() _dafny.Sequence {
	{
		return _this._requiredEncryptionContextKeys
	}
}

// End of class RequiredEncryptionContextCMM
