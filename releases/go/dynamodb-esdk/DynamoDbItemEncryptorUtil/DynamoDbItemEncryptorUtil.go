// Package DynamoDbItemEncryptorUtil
// Dafny module DynamoDbItemEncryptorUtil compiled into Go

package DynamoDbItemEncryptorUtil

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
	m_MaterialProviders "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialProviders"
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
	m_SortedSets "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/SortedSets"
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
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Canonize"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbNormalizeNumber"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoToStruct"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Maps_"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/OptimizedMergeSort"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/SortCanon"
	m_StructuredEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryption"
	m_StructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionCrypt"
	m_StructuredEncryptionFooter "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionFooter"
	m_StructuredEncryptionHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionHeader"
	m_StructuredEncryptionPaths "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionPaths"
	m_StructuredEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionUtil"
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
var _ m_AwsCryptographyKeyStoreTypes.Dummy__
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_Base64.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m_Actions.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_AwsArnParsing.Dummy__
var _ m_Constants.Dummy__
var _ m_EcdhEdkWrapping.Dummy__
var _ m_RawECDHKeyring.Dummy__
var _ m_RawRSAKeyring.Dummy__
var _ m_AwsKmsMrkMatchForDecrypt.Dummy__
var _ m_AwsKmsUtils.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_AwsKmsEcdhKeyring.Dummy__
var _ m_FileIO.Dummy__
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
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
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
var _ m_MaterialProviders.Dummy__
var _ m_KeyStoreErrorMessages.Dummy__
var _ m_KmsArn.Dummy__
var _ m_Structure.Dummy__
var _ m_KMSKeystoreOperations.Dummy__
var _ m_DDBKeystoreOperations.Dummy__
var _ m_CreateKeys.Dummy__
var _ m_CreateKeyStoreTable.Dummy__
var _ m_GetKeys.Dummy__
var _ m_AwsCryptographyKeyStoreOperations.Dummy__
var _ m_KeyStore.Dummy__
var _ m__Unicode.Dummy__
var _ m_Functions.Dummy__
var _ m_Utf8EncodingForm.Dummy__
var _ m_Utf16EncodingForm.Dummy__
var _ m_UnicodeStrings.Dummy__
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
var _ m_Base64Lemmas.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Dummy__
var _ m_StructuredEncryptionUtil.Dummy__
var _ m_Sets.Dummy__
var _ m_StructuredEncryptionPaths.Dummy__
var _ m_StructuredEncryptionHeader.Dummy__
var _ m_StructuredEncryptionFooter.Dummy__
var _ m_OptimizedMergeSort.Dummy__
var _ m_SortCanon.Dummy__
var _ m_Canonize.Dummy__
var _ m_StructuredEncryptionCrypt.Dummy__
var _ m__Maps.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Dummy__
var _ m_StructuredEncryption.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Dummy__
var _ m_DynamoDbEncryptionUtil.Dummy__
var _ m_DynamoDbNormalizeNumber.Dummy__
var _ m_DynamoToStruct.Dummy__

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
	return "DynamoDbItemEncryptorUtil.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) E(msg _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(msg)
}
func (_static *CompanionStruct_Default___) ByteLess(x uint8, y uint8) bool {
	return (x) < (y)
}
func (_static *CompanionStruct_Default___) CharLess(x _dafny.Char, y _dafny.Char) bool {
	return (x) < (y)
}
func (_static *CompanionStruct_Default___) GetLiteralValue(x _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_UTF8.Decode(x)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_str _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_str
		if _dafny.Companion_Sequence_.Equal(_1_str, m_StructuredEncryptionUtil.Companion_Default___.TRUE__STR()) {
			return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(true))
		} else if _dafny.Companion_Sequence_.Equal(_1_str, m_StructuredEncryptionUtil.Companion_Default___.FALSE__STR()) {
			return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(false))
		} else if _dafny.Companion_Sequence_.Equal(_1_str, m_StructuredEncryptionUtil.Companion_Default___.NULL__STR()) {
			return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true))
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Encryption Context literal value has unexpected value : '"), _1_str), _dafny.SeqOfString("'.")))
		}
	}
}
func (_static *CompanionStruct_Default___) GetSortKey(context _dafny.Map) m_Wrappers.Result {
	if ((context).Keys()).Contains(Companion_Default___.SORT__NAME()) {
		var _0_sortName _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(m_StructuredEncryptionUtil.Companion_Default___.EC__ATTR__PREFIX(), (context).Get(Companion_Default___.SORT__NAME()).(_dafny.Sequence))
		_ = _0_sortName
		var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq(_0_sortName), _dafny.SeqOfString("Internal Error : bad utf8 in sortName"))
		_ = _1_valueOrError0
		if (_1_valueOrError0).IsFailure() {
			return (_1_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(_0_sortName))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
	}
}
func (_static *CompanionStruct_Default___) ConvertContextForSelector(context _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((context).Keys()).Contains(Companion_Default___.PARTITION__NAME()), _dafny.SeqOfString("Invalid encryption context: Missing partition name"))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_partitionName _dafny.Sequence = (context).Get(Companion_Default___.PARTITION__NAME()).(_dafny.Sequence)
		_ = _1_partitionName
		var _2_partitionValueKey _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(m_StructuredEncryptionUtil.Companion_Default___.EC__ATTR__PREFIX(), _1_partitionName)
		_ = _2_partitionValueKey
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((context).Keys()).Contains(_2_partitionValueKey), _dafny.SeqOfString("Invalid encryption context: Missing partition value"))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_valueOrError2 m_Wrappers.Result = Companion_Default___.GetSortKey(context)
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_sortValueKey m_Wrappers.Option = (_4_valueOrError2).Extract().(m_Wrappers.Option)
				_ = _5_sortValueKey
				var _6_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_5_sortValueKey).Is_None()) || ((context).Contains((_5_sortValueKey).Dtor_value().(_dafny.Sequence))), _dafny.SeqOfString("Invalid encryption context: Missing sort value"))
				_ = _6_valueOrError3
				if (_6_valueOrError3).IsFailure() {
					return (_6_valueOrError3).PropagateFailure()
				} else {
					var _7_keys _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((context).Keys(), func(coer52 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
						return func(arg75 interface{}, arg76 interface{}) bool {
							return coer52(arg75.(uint8), arg76.(uint8))
						}
					}(m_StructuredEncryptionUtil.Companion_Default___.ByteLess))
					_ = _7_keys
					if (context).Contains(m_StructuredEncryptionUtil.Companion_Default___.LEGEND__UTF8()) {
						var _8_valueOrError4 m_Wrappers.Result = m_UTF8.Decode((context).Get(m_StructuredEncryptionUtil.Companion_Default___.LEGEND__UTF8()).(_dafny.Sequence))
						_ = _8_valueOrError4
						if (_8_valueOrError4).IsFailure() {
							return (_8_valueOrError4).PropagateFailure()
						} else {
							var _9_legend _dafny.Sequence = (_8_valueOrError4).Extract().(_dafny.Sequence)
							_ = _9_legend
							var _10_valueOrError5 m_Wrappers.Result = Companion_Default___.GetV2AttrMap(_7_keys, context, _9_legend, uint64(0), uint64(0), _dafny.NewMapBuilder().ToMap())
							_ = _10_valueOrError5
							if (_10_valueOrError5).IsFailure() {
								return (_10_valueOrError5).PropagateFailure()
							} else {
								var _11_attrMap _dafny.Map = (_10_valueOrError5).Extract().(_dafny.Map)
								_ = _11_attrMap
								var _12_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((context).Contains(Companion_Default___.TABLE__NAME()), _dafny.SeqOfString("Internal error, table name not in encryption context."))
								_ = _12_valueOrError6
								if (_12_valueOrError6).IsFailure() {
									return (_12_valueOrError6).PropagateFailure()
								} else {
									var _13_valueOrError7 m_Wrappers.Result = m_UTF8.Decode((context).Get(Companion_Default___.TABLE__NAME()).(_dafny.Sequence))
									_ = _13_valueOrError7
									if (_13_valueOrError7).IsFailure() {
										return (_13_valueOrError7).PropagateFailure()
									} else {
										var _14_tableName _dafny.Sequence = (_13_valueOrError7).Extract().(_dafny.Sequence)
										_ = _14_tableName
										var _15_attrMap2 _dafny.Map = (_11_attrMap).Update(Companion_Default___.SELECTOR__TABLE__NAME(), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_14_tableName))
										_ = _15_attrMap2
										var _16_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((context).Contains(Companion_Default___.PARTITION__NAME()), _dafny.SeqOfString("Internal error, table name not in encryption context."))
										_ = _16_valueOrError8
										if (_16_valueOrError8).IsFailure() {
											return (_16_valueOrError8).PropagateFailure()
										} else {
											var _17_valueOrError9 m_Wrappers.Result = m_UTF8.Decode((context).Get(Companion_Default___.PARTITION__NAME()).(_dafny.Sequence))
											_ = _17_valueOrError9
											if (_17_valueOrError9).IsFailure() {
												return (_17_valueOrError9).PropagateFailure()
											} else {
												var _18_partitionName _dafny.Sequence = (_17_valueOrError9).Extract().(_dafny.Sequence)
												_ = _18_partitionName
												var _19_attrMap3 _dafny.Map = (_15_attrMap2).Update(Companion_Default___.SELECTOR__PARTITION__NAME(), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_18_partitionName))
												_ = _19_attrMap3
												if (context).Contains(Companion_Default___.SORT__NAME()) {
													var _20_valueOrError10 m_Wrappers.Result = m_UTF8.Decode((context).Get(Companion_Default___.SORT__NAME()).(_dafny.Sequence))
													_ = _20_valueOrError10
													if (_20_valueOrError10).IsFailure() {
														return (_20_valueOrError10).PropagateFailure()
													} else {
														var _21_sortName _dafny.Sequence = (_20_valueOrError10).Extract().(_dafny.Sequence)
														_ = _21_sortName
														return m_Wrappers.Companion_Result_.Create_Success_((_19_attrMap3).Update(Companion_Default___.SELECTOR__SORT__NAME(), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_21_sortName)))
													}
												} else {
													return m_Wrappers.Companion_Result_.Create_Success_(_19_attrMap3)
												}
											}
										}
									}
								}
							}
						}
					} else if (_5_sortValueKey).Is_None() {
						return Companion_Default___.AddAttributeToMap(_2_partitionValueKey, (context).Get(_2_partitionValueKey).(_dafny.Sequence), _dafny.NewMapBuilder().ToMap())
					} else {
						var _22_valueOrError11 m_Wrappers.Result = Companion_Default___.AddAttributeToMap(_2_partitionValueKey, (context).Get(_2_partitionValueKey).(_dafny.Sequence), _dafny.NewMapBuilder().ToMap())
						_ = _22_valueOrError11
						if (_22_valueOrError11).IsFailure() {
							return (_22_valueOrError11).PropagateFailure()
						} else {
							var _23_attrMap _dafny.Map = (_22_valueOrError11).Extract().(_dafny.Map)
							_ = _23_attrMap
							return Companion_Default___.AddAttributeToMap((_5_sortValueKey).Dtor_value().(_dafny.Sequence), (context).Get((_5_sortValueKey).Dtor_value().(_dafny.Sequence)).(_dafny.Sequence), _23_attrMap)
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) GetAttrValue(ecValue _dafny.Sequence, legend _dafny.Char) m_Wrappers.Result {
	if (legend) == (m_StructuredEncryptionUtil.Companion_Default___.LEGEND__STRING()) {
		var _0_valueOrError0 m_Wrappers.Result = m_UTF8.Decode(ecValue)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_value _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_value
			return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_1_value))
		}
	} else if (legend) == (m_StructuredEncryptionUtil.Companion_Default___.LEGEND__NUMBER()) {
		var _2_valueOrError1 m_Wrappers.Result = m_UTF8.Decode(ecValue)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_value _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_value
			return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_3_value))
		}
	} else if (legend) == (m_StructuredEncryptionUtil.Companion_Default___.LEGEND__LITERAL()) {
		var _4_valueOrError2 m_Wrappers.Result = Companion_Default___.GetLiteralValue(ecValue)
		_ = _4_valueOrError2
		if (_4_valueOrError2).IsFailure() {
			return (_4_valueOrError2).PropagateFailure()
		} else {
			var _5_value m_ComAmazonawsDynamodbTypes.AttributeValue = (_4_valueOrError2).Extract().(m_ComAmazonawsDynamodbTypes.AttributeValue)
			_ = _5_value
			return m_Wrappers.Companion_Result_.Create_Success_(_5_value)
		}
	} else if (legend) == (m_StructuredEncryptionUtil.Companion_Default___.LEGEND__BINARY()) {
		var _6_valueOrError3 m_Wrappers.Result = m_StructuredEncryptionUtil.Companion_Default___.DecodeTerminal(ecValue)
		_ = _6_valueOrError3
		if (_6_valueOrError3).IsFailure() {
			return (_6_valueOrError3).PropagateFailure()
		} else {
			var _7_terminal m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal = (_6_valueOrError3).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)
			_ = _7_terminal
			var _8_valueOrError4 m_Wrappers.Result = m_DynamoToStruct.Companion_Default___.BytesToAttr((_7_terminal).Dtor_value(), (_7_terminal).Dtor_typeId(), m_Wrappers.Companion_Option_.Create_Some_(uint64(((_7_terminal).Dtor_value()).Cardinality())), uint64(1), uint64(0))
			_ = _8_valueOrError4
			if (_8_valueOrError4).IsFailure() {
				return (_8_valueOrError4).PropagateFailure()
			} else {
				var _9_ddbAttrValue m_DynamoToStruct.AttrValueAndLength = (_8_valueOrError4).Extract().(m_DynamoToStruct.AttrValueAndLength)
				_ = _9_ddbAttrValue
				return m_Wrappers.Companion_Result_.Create_Success_((_9_ddbAttrValue).Dtor_val())
			}
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Encryption Context Legend has unexpected character : '"), _dafny.SeqOfChars(legend)), _dafny.SeqOfString("'.")))
	}
}
func (_static *CompanionStruct_Default___) GetV2AttrMap(keys _dafny.Sequence, context _dafny.Map, legend _dafny.Sequence, keyPos uint64, legendPos uint64, attrMap _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((keys).Cardinality())) == (keyPos) {
		if (uint64((legend).Cardinality())) == (legendPos) {
			return m_Wrappers.Companion_Result_.Create_Success_(attrMap)
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Encryption Context Legend is too long."))
		}
	} else {
		var _0_key _dafny.Sequence = (keys).Select(uint32(keyPos)).(_dafny.Sequence)
		_ = _0_key
		if _dafny.Companion_Sequence_.IsProperPrefixOf(m_StructuredEncryptionUtil.Companion_Default___.EC__ATTR__PREFIX(), _0_key) {
			var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((legendPos) < (uint64((legend).Cardinality())), _dafny.SeqOfString("Encryption Context Legend is too short."))
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.GetAttributeName(_0_key)
				_ = _2_valueOrError1
				if (_2_valueOrError1).IsFailure() {
					return (_2_valueOrError1).PropagateFailure()
				} else {
					var _3_attrName _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
					_ = _3_attrName
					var _4_valueOrError2 m_Wrappers.Result = Companion_Default___.GetAttrValue((context).Get(_0_key).(_dafny.Sequence), (legend).Select(uint32(legendPos)).(_dafny.Char))
					_ = _4_valueOrError2
					if (_4_valueOrError2).IsFailure() {
						return (_4_valueOrError2).PropagateFailure()
					} else {
						var _5_attrValue m_ComAmazonawsDynamodbTypes.AttributeValue = (_4_valueOrError2).Extract().(m_ComAmazonawsDynamodbTypes.AttributeValue)
						_ = _5_attrValue
						var _in0 _dafny.Sequence = keys
						_ = _in0
						var _in1 _dafny.Map = context
						_ = _in1
						var _in2 _dafny.Sequence = legend
						_ = _in2
						var _in3 uint64 = (keyPos) + (uint64(1))
						_ = _in3
						var _in4 uint64 = (legendPos) + (uint64(1))
						_ = _in4
						var _in5 _dafny.Map = (attrMap).Update(_3_attrName, _5_attrValue)
						_ = _in5
						keys = _in0
						context = _in1
						legend = _in2
						keyPos = _in3
						legendPos = _in4
						attrMap = _in5
						goto TAIL_CALL_START
					}
				}
			}
		} else {
			var _in6 _dafny.Sequence = keys
			_ = _in6
			var _in7 _dafny.Map = context
			_ = _in7
			var _in8 _dafny.Sequence = legend
			_ = _in8
			var _in9 uint64 = (keyPos) + (uint64(1))
			_ = _in9
			var _in10 uint64 = legendPos
			_ = _in10
			var _in11 _dafny.Map = attrMap
			_ = _in11
			keys = _in6
			context = _in7
			legend = _in8
			keyPos = _in9
			legendPos = _in10
			attrMap = _in11
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) GetAttributeName(ddbAttrKey _dafny.Sequence) m_Wrappers.Result {
	var _0_ddbAttrNameBytes _dafny.Sequence = (ddbAttrKey).Drop((_dafny.IntOfUint32((m_StructuredEncryptionUtil.Companion_Default___.EC__ATTR__PREFIX()).Cardinality())).Uint32())
	_ = _0_ddbAttrNameBytes
	var _1_valueOrError0 m_Wrappers.Result = m_UTF8.Decode(_0_ddbAttrNameBytes)
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_ddbAttrName _dafny.Sequence = (_1_valueOrError0).Extract().(_dafny.Sequence)
		_ = _2_ddbAttrName
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_2_ddbAttrName), _dafny.SeqOfString("Invalid serialization of DDB Attribute in encryption context."))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(_2_ddbAttrName)
		}
	}
}
func (_static *CompanionStruct_Default___) AddAttributeToMap(ddbAttrKey _dafny.Sequence, encodedAttrValue _dafny.Sequence, attrMap _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetAttributeName(ddbAttrKey)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_ddbAttrName _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_ddbAttrName
		var _2_valueOrError1 m_Wrappers.Result = m_StructuredEncryptionUtil.Companion_Default___.DecodeTerminal(encodedAttrValue)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_terminal m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal = (_2_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)
			_ = _3_terminal
			var _4_valueOrError2 m_Wrappers.Result = m_DynamoToStruct.Companion_Default___.BytesToAttr((_3_terminal).Dtor_value(), (_3_terminal).Dtor_typeId(), m_Wrappers.Companion_Option_.Create_Some_(uint64(((_3_terminal).Dtor_value()).Cardinality())), uint64(1), uint64(0))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_ddbAttrValue m_DynamoToStruct.AttrValueAndLength = (_4_valueOrError2).Extract().(m_DynamoToStruct.AttrValueAndLength)
				_ = _5_ddbAttrValue
				return m_Wrappers.Companion_Result_.Create_Success_((attrMap).Update(_1_ddbAttrName, (_5_ddbAttrValue).Dtor_val()))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ReservedPrefix() _dafny.Sequence {
	return _dafny.SeqOfString("aws_dbe_")
}
func (_static *CompanionStruct_Default___) BeaconPrefix() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.ReservedPrefix(), _dafny.SeqOfString("b_"))
}
func (_static *CompanionStruct_Default___) VersionPrefix() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.ReservedPrefix(), _dafny.SeqOfString("v_"))
}
func (_static *CompanionStruct_Default___) SORT__NAME() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(115), uint8(111), uint8(114), uint8(116), uint8(45), uint8(110), uint8(97), uint8(109), uint8(101))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) PARTITION__NAME() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(112), uint8(97), uint8(114), uint8(116), uint8(105), uint8(116), uint8(105), uint8(111), uint8(110), uint8(45), uint8(110), uint8(97), uint8(109), uint8(101))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) TABLE__NAME() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(116), uint8(97), uint8(98), uint8(108), uint8(101), uint8(45), uint8(110), uint8(97), uint8(109), uint8(101))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) SELECTOR__TABLE__NAME() _dafny.Sequence {
	return _dafny.SeqOfString("aws_dbe_table_name")
}
func (_static *CompanionStruct_Default___) SELECTOR__PARTITION__NAME() _dafny.Sequence {
	return _dafny.SeqOfString("aws_dbe_partition_name")
}
func (_static *CompanionStruct_Default___) SELECTOR__SORT__NAME() _dafny.Sequence {
	return _dafny.SeqOfString("aws_dbe_sort_name")
}

// End of class Default__
