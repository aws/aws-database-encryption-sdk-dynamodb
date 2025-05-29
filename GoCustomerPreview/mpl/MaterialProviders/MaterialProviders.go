// Package MaterialProviders
// Dafny module MaterialProviders compiled into Go

package MaterialProviders

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
	m_AwsCryptographyMaterialProvidersOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersOperations"
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
	m_RequiredEncryptionContextCMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RequiredEncryptionContextCMM"
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
	m_Sorting "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Sorting"
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
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
var _ m_AwsKmsMrkDiscoveryKeyring.Dummy__
var _ m_AwsKmsMrkKeyring.Dummy__
var _ m_AwsKmsRsaKeyring.Dummy__
var _ m_MultiKeyring.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_DiscoveryMultiKeyring.Dummy__
var _ m_MrkAwareDiscoveryMultiKeyring.Dummy__
var _ m_MrkAwareStrictMultiKeyring.Dummy__
var _ m_CMM.Dummy__
var _ m_Defaults.Dummy__
var _ m_Commitment.Dummy__
var _ m_DefaultCMM.Dummy__
var _ m_DefaultClientSupplier.Dummy__
var _ m_Utils.Dummy__
var _ m_RequiredEncryptionContextCMM.Dummy__
var _ m_AwsCryptographyMaterialProvidersOperations.Dummy__

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
	return "MaterialProviders.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DefaultMaterialProvidersConfig() m_AwsCryptographyMaterialProvidersTypes.MaterialProvidersConfig {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_MaterialProvidersConfig_.Create_MaterialProvidersConfig_()
}
func (_static *CompanionStruct_Default___) MaterialProviders(config m_AwsCryptographyMaterialProvidersTypes.MaterialProvidersConfig) m_Wrappers.Result {
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
	_1_valueOrError0 = (_0_maybeCrypto).MapFailure(func(coer134 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg135 interface{}) interface{} {
			return coer134(arg135.(m_AwsCryptographyPrimitivesTypes.Error))
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
	var _5_client *MaterialProvidersClient
	_ = _5_client
	var _nw0 *MaterialProvidersClient = New_MaterialProvidersClient_()
	_ = _nw0
	_nw0.Ctor__(m_AwsCryptographyMaterialProvidersOperations.Companion_Config_.Create_Config_(_4_cryptoPrimitives))
	_5_client = _nw0
	res = m_Wrappers.Companion_Result_.Create_Success_(_5_client)
	return res
	return res
}
func (_static *CompanionStruct_Default___) CreateSuccessOfClient(client m_AwsCryptographyMaterialProvidersTypes.IAwsCryptographicMaterialProvidersClient) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(client)
}
func (_static *CompanionStruct_Default___) CreateFailureOfError(error_ m_AwsCryptographyMaterialProvidersTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}

// End of class Default__

// Definition of class MaterialProvidersClient
type MaterialProvidersClient struct {
	_config m_AwsCryptographyMaterialProvidersOperations.Config
}

func New_MaterialProvidersClient_() *MaterialProvidersClient {
	_this := MaterialProvidersClient{}

	_this._config = m_AwsCryptographyMaterialProvidersOperations.Config{}
	return &_this
}

type CompanionStruct_MaterialProvidersClient_ struct {
}

var Companion_MaterialProvidersClient_ = CompanionStruct_MaterialProvidersClient_{}

func (_this *MaterialProvidersClient) Equals(other *MaterialProvidersClient) bool {
	return _this == other
}

func (_this *MaterialProvidersClient) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*MaterialProvidersClient)
	return ok && _this.Equals(other)
}

func (*MaterialProvidersClient) String() string {
	return "MaterialProviders.MaterialProvidersClient"
}

func Type_MaterialProvidersClient_() _dafny.TypeDescriptor {
	return type_MaterialProvidersClient_{}
}

type type_MaterialProvidersClient_ struct {
}

func (_this type_MaterialProvidersClient_) Default() interface{} {
	return (*MaterialProvidersClient)(nil)
}

func (_this type_MaterialProvidersClient_) String() string {
	return "MaterialProviders.MaterialProvidersClient"
}
func (_this *MaterialProvidersClient) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_AwsCryptographyMaterialProvidersTypes.Companion_IAwsCryptographicMaterialProvidersClient_.TraitID_}
}

var _ m_AwsCryptographyMaterialProvidersTypes.IAwsCryptographicMaterialProvidersClient = &MaterialProvidersClient{}
var _ _dafny.TraitOffspring = &MaterialProvidersClient{}

func (_this *MaterialProvidersClient) Ctor__(config m_AwsCryptographyMaterialProvidersOperations.Config) {
	{
		(_this)._config = config
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsDiscoveryKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsDiscoveryKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsDiscoveryKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsMultiKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsMultiKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsDiscoveryMultiKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsDiscoveryMultiKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsDiscoveryMultiKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsMrkKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsMrkKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsMrkMultiKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkMultiKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsMrkMultiKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsMrkDiscoveryKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkDiscoveryKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsMrkDiscoveryKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsMrkDiscoveryMultiKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkDiscoveryMultiKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsMrkDiscoveryMultiKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsHierarchicalKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsHierarchicalKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsHierarchicalKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsRsaKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsRsaKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsRsaKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateAwsKmsEcdhKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsEcdhKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateAwsKmsEcdhKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateMultiKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateMultiKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateMultiKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateRawAesKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateRawAesKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateRawAesKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateRawRsaKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateRawRsaKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateRawRsaKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateRawEcdhKeyring(input m_AwsCryptographyMaterialProvidersTypes.CreateRawEcdhKeyringInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateRawEcdhKeyring((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateDefaultCryptographicMaterialsManager(input m_AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateDefaultCryptographicMaterialsManager((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateRequiredEncryptionContextCMM(input m_AwsCryptographyMaterialProvidersTypes.CreateRequiredEncryptionContextCMMInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateRequiredEncryptionContextCMM((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateCryptographicMaterialsCache(input m_AwsCryptographyMaterialProvidersTypes.CreateCryptographicMaterialsCacheInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateCryptographicMaterialsCache((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) CreateDefaultClientSupplier(input m_AwsCryptographyMaterialProvidersTypes.CreateDefaultClientSupplierInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.CreateDefaultClientSupplier((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *MaterialProvidersClient) InitializeEncryptionMaterials(input m_AwsCryptographyMaterialProvidersTypes.InitializeEncryptionMaterialsInput) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.InitializeEncryptionMaterials((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) InitializeDecryptionMaterials(input m_AwsCryptographyMaterialProvidersTypes.InitializeDecryptionMaterialsInput) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.InitializeDecryptionMaterials((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) ValidEncryptionMaterialsTransition(input m_AwsCryptographyMaterialProvidersTypes.ValidEncryptionMaterialsTransitionInput) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.ValidEncryptionMaterialsTransition((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) ValidDecryptionMaterialsTransition(input m_AwsCryptographyMaterialProvidersTypes.ValidDecryptionMaterialsTransitionInput) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.ValidDecryptionMaterialsTransition((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) EncryptionMaterialsHasPlaintextDataKey(input m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.EncryptionMaterialsHasPlaintextDataKey((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) DecryptionMaterialsWithPlaintextDataKey(input m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.DecryptionMaterialsWithPlaintextDataKey((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) GetAlgorithmSuiteInfo(input _dafny.Sequence) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.GetAlgorithmSuiteInfo((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) ValidAlgorithmSuiteInfo(input m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.ValidAlgorithmSuiteInfo((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) ValidateCommitmentPolicyOnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.ValidateCommitmentPolicyOnEncryptInput) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.ValidateCommitmentPolicyOnEncrypt((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) ValidateCommitmentPolicyOnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.ValidateCommitmentPolicyOnDecryptInput) m_Wrappers.Result {
	{
		return m_AwsCryptographyMaterialProvidersOperations.Companion_Default___.ValidateCommitmentPolicyOnDecrypt((_this).Config(), input)
	}
}
func (_this *MaterialProvidersClient) Config() m_AwsCryptographyMaterialProvidersOperations.Config {
	{
		return _this._config
	}
}

// End of class MaterialProvidersClient
