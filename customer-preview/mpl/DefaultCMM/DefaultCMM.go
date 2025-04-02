// Package DefaultCMM
// Dafny module DefaultCMM compiled into Go

package DefaultCMM

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

type Dummy__ struct{}

// Definition of class DefaultCMM
type DefaultCMM struct {
	_keyring          m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_DefaultCMM_() *DefaultCMM {
	_this := DefaultCMM{}

	_this._keyring = (m_AwsCryptographyMaterialProvidersTypes.IKeyring)(nil)
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_DefaultCMM_ struct {
}

var Companion_DefaultCMM_ = CompanionStruct_DefaultCMM_{}

func (_this *DefaultCMM) Equals(other *DefaultCMM) bool {
	return _this == other
}

func (_this *DefaultCMM) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*DefaultCMM)
	return ok && _this.Equals(other)
}

func (*DefaultCMM) String() string {
	return "DefaultCMM.DefaultCMM"
}

func Type_DefaultCMM_() _dafny.TypeDescriptor {
	return type_DefaultCMM_{}
}

type type_DefaultCMM_ struct {
}

func (_this type_DefaultCMM_) Default() interface{} {
	return (*DefaultCMM)(nil)
}

func (_this type_DefaultCMM_) String() string {
	return "DefaultCMM.DefaultCMM"
}
func (_this *DefaultCMM) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_CMM.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.TraitID_}
}

var _ m_CMM.VerifiableInterface = &DefaultCMM{}
var _ m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager = &DefaultCMM{}
var _ _dafny.TraitOffspring = &DefaultCMM{}

func (_this *DefaultCMM) DecryptMaterials(input m_AwsCryptographyMaterialProvidersTypes.DecryptMaterialsInput) m_Wrappers.Result {
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.DecryptMaterials(_this, input)
	return _out1
}
func (_this *DefaultCMM) GetEncryptionMaterials(input m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput) m_Wrappers.Result {
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.GetEncryptionMaterials(_this, input)
	return _out1
}
func (_this *DefaultCMM) OfKeyring(k m_AwsCryptographyMaterialProvidersTypes.IKeyring, c *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._keyring = k
		(_this)._cryptoPrimitives = c
	}
}
func (_this *DefaultCMM) GetEncryptionMaterials_k(input m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(!((input).Dtor_encryptionContext()).Contains(m_Materials.Companion_Default___.EC__PUBLIC__KEY__FIELD()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Reserved Field found in EncryptionContext keys.")))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_algorithmId m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId
		_ = _1_algorithmId
		if ((input).Dtor_algorithmSuiteId()).Is_Some() {
			_1_algorithmId = ((input).Dtor_algorithmSuiteId()).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId)
		} else {
			_1_algorithmId = m_Defaults.Companion_Default___.GetAlgorithmSuiteForCommitmentPolicy((input).Dtor_commitmentPolicy())
		}
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError1
		_2_valueOrError1 = m_Commitment.Companion_Default___.ValidateCommitmentPolicyOnEncrypt(_1_algorithmId, (input).Dtor_commitmentPolicy())
		if (_2_valueOrError1).IsFailure() {
			output = (_2_valueOrError1).PropagateFailure()
			return output
		}
		var _3_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _3_suite
		_3_suite = m_AlgorithmSuites.Companion_Default___.GetSuite(_1_algorithmId)
		var _4_signingKey m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
		_ = _4_signingKey
		var _5_verificationKey m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
		_ = _5_verificationKey
		if ((_3_suite).Dtor_signature()).Is_ECDSA() {
			var _6_maybeECDSAPair m_Wrappers.Result
			_ = _6_maybeECDSAPair
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = ((_this).CryptoPrimitives()).GenerateECDSASignatureKey(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECDSASignatureKeyInput_.Create_GenerateECDSASignatureKeyInput_((((_3_suite).Dtor_signature()).Dtor_ECDSA()).Dtor_curve()))
			_6_maybeECDSAPair = _out0
			var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECDSASignatureKeyOutput_.Default())
			_ = _7_valueOrError2
			_7_valueOrError2 = (_6_maybeECDSAPair).MapFailure(func(coer129 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
				return func(arg130 interface{}) interface{} {
					return coer129(arg130.(m_AwsCryptographyPrimitivesTypes.Error))
				}
			}(func(_8_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
				return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_8_e)
			}))
			if (_7_valueOrError2).IsFailure() {
				output = (_7_valueOrError2).PropagateFailure()
				return output
			}
			var _9_pair m_AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyOutput
			_ = _9_pair
			_9_pair = (_7_valueOrError2).Extract().(m_AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyOutput)
			_4_signingKey = m_Wrappers.Companion_Option_.Create_Some_((_9_pair).Dtor_signingKey())
			_5_verificationKey = m_Wrappers.Companion_Option_.Create_Some_((_9_pair).Dtor_verificationKey())
		} else {
			_4_signingKey = m_Wrappers.Companion_Option_.Create_None_()
			_5_verificationKey = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _10_valueOrError3
		_10_valueOrError3 = m_Materials.Companion_Default___.InitializeEncryptionMaterials(m_AwsCryptographyMaterialProvidersTypes.Companion_InitializeEncryptionMaterialsInput_.Create_InitializeEncryptionMaterialsInput_(_1_algorithmId, (input).Dtor_encryptionContext(), ((input).Dtor_requiredEncryptionContextKeys()).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence), _4_signingKey, _5_verificationKey))
		if (_10_valueOrError3).IsFailure() {
			output = (_10_valueOrError3).PropagateFailure()
			return output
		}
		var _11_materials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
		_ = _11_materials
		_11_materials = (_10_valueOrError3).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
		var _12_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _12_valueOrError4
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = ((_this).Keyring()).OnEncrypt(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptInput_.Create_OnEncryptInput_(_11_materials))
		_12_valueOrError4 = _out1
		if (_12_valueOrError4).IsFailure() {
			output = (_12_valueOrError4).PropagateFailure()
			return output
		}
		var _13_result m_AwsCryptographyMaterialProvidersTypes.OnEncryptOutput
		_ = _13_result
		_13_result = (_12_valueOrError4).Extract().(m_AwsCryptographyMaterialProvidersTypes.OnEncryptOutput)
		var _14_encryptionMaterialsOutput m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsOutput
		_ = _14_encryptionMaterialsOutput
		_14_encryptionMaterialsOutput = m_AwsCryptographyMaterialProvidersTypes.Companion_GetEncryptionMaterialsOutput_.Create_GetEncryptionMaterialsOutput_((_13_result).Dtor_materials())
		var _15_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _15_valueOrError5
		_15_valueOrError5 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.EncryptionMaterialsHasPlaintextDataKey((_14_encryptionMaterialsOutput).Dtor_encryptionMaterials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Could not retrieve materials required for encryption")))
		if (_15_valueOrError5).IsFailure() {
			output = (_15_valueOrError5).PropagateFailure()
			return output
		}
		var _16_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _16_valueOrError6
		_16_valueOrError6 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.ValidEncryptionMaterialsTransition(_11_materials, (_14_encryptionMaterialsOutput).Dtor_encryptionMaterials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring returned an invalid response")))
		if (_16_valueOrError6).IsFailure() {
			output = (_16_valueOrError6).PropagateFailure()
			return output
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(_14_encryptionMaterialsOutput)
		return output
	}
}
func (_this *DefaultCMM) DecryptMaterials_k(input m_AwsCryptographyMaterialProvidersTypes.DecryptMaterialsInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Commitment.Companion_Default___.ValidateCommitmentPolicyOnDecrypt((input).Dtor_algorithmSuiteId(), (input).Dtor_commitmentPolicy())
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_requiredEncryptionContextKeys _dafny.Sequence
		_ = _1_requiredEncryptionContextKeys
		_1_requiredEncryptionContextKeys = _dafny.SeqOf()
		if ((input).Dtor_reproducedEncryptionContext()).Is_Some() {
			var _2_keysSet _dafny.Set
			_ = _2_keysSet
			_2_keysSet = (((input).Dtor_reproducedEncryptionContext()).Dtor_value().(_dafny.Map)).Keys()
			var _3_keysSeq _dafny.Sequence
			_ = _3_keysSeq
			var _out0 _dafny.Sequence
			_ = _out0
			_out0 = m_SortedSets.SetToSequence(_2_keysSet)
			_3_keysSeq = _out0
			var _4_i _dafny.Int
			_ = _4_i
			_4_i = _dafny.Zero
			for (_4_i).Cmp(_dafny.IntOfUint32((_3_keysSeq).Cardinality())) < 0 {
				var _5_key _dafny.Sequence
				_ = _5_key
				_5_key = (_3_keysSeq).Select((_4_i).Uint32()).(_dafny.Sequence)
				if ((input).Dtor_encryptionContext()).Contains(_5_key) {
					var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _6_valueOrError1
					_6_valueOrError1 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal((((input).Dtor_reproducedEncryptionContext()).Dtor_value().(_dafny.Map)).Get(_5_key).(_dafny.Sequence), ((input).Dtor_encryptionContext()).Get(_5_key).(_dafny.Sequence)), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption context does not match reproduced encryption context.")))
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
				} else {
					_1_requiredEncryptionContextKeys = _dafny.Companion_Sequence_.Concatenate(_1_requiredEncryptionContextKeys, _dafny.SeqOf(_5_key))
				}
				_4_i = (_4_i).Plus(_dafny.One)
			}
		}
		var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _7_valueOrError2
		_7_valueOrError2 = m_Materials.Companion_Default___.InitializeDecryptionMaterials(m_AwsCryptographyMaterialProvidersTypes.Companion_InitializeDecryptionMaterialsInput_.Create_InitializeDecryptionMaterialsInput_((input).Dtor_algorithmSuiteId(), ((input).Dtor_encryptionContext()).Merge(((input).Dtor_reproducedEncryptionContext()).UnwrapOr(_dafny.NewMapBuilder().ToMap()).(_dafny.Map)), _1_requiredEncryptionContextKeys))
		if (_7_valueOrError2).IsFailure() {
			output = (_7_valueOrError2).PropagateFailure()
			return output
		}
		var _8_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _8_materials
		_8_materials = (_7_valueOrError2).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _9_valueOrError3
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = ((_this).Keyring()).OnDecrypt(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptInput_.Create_OnDecryptInput_(_8_materials, (input).Dtor_encryptedDataKeys()))
		_9_valueOrError3 = _out1
		if (_9_valueOrError3).IsFailure() {
			output = (_9_valueOrError3).PropagateFailure()
			return output
		}
		var _10_result m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput
		_ = _10_result
		_10_result = (_9_valueOrError3).Extract().(m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput)
		var _11_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _11_valueOrError4
		_11_valueOrError4 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsTransitionIsValid(_8_materials, (_10_result).Dtor_materials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring.OnDecrypt failed to decrypt the plaintext data key.")))
		if (_11_valueOrError4).IsFailure() {
			output = (_11_valueOrError4).PropagateFailure()
			return output
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_DecryptMaterialsOutput_.Create_DecryptMaterialsOutput_((_10_result).Dtor_materials()))
		return output
		return output
	}
}
func (_this *DefaultCMM) Keyring() m_AwsCryptographyMaterialProvidersTypes.IKeyring {
	{
		return _this._keyring
	}
}
func (_this *DefaultCMM) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}

// End of class DefaultCMM
