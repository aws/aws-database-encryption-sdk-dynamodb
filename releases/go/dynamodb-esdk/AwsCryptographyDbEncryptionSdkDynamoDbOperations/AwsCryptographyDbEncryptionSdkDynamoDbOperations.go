// Package AwsCryptographyDbEncryptionSdkDynamoDbOperations
// Dafny module AwsCryptographyDbEncryptionSdkDynamoDbOperations compiled into Go

package AwsCryptographyDbEncryptionSdkDynamoDbOperations

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
	m_Sorting "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Sorting"
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
	m_UUID "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UUID"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Canonize"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbItemEncryptorUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbNormalizeNumber"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoToStruct"
	m_InternalLegacyOverride "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/InternalLegacyOverride"
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
var _ m_DynamoDbItemEncryptorUtil.Dummy__
var _ m_InternalLegacyOverride.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Dummy__
var _ m_DynamoDbItemEncryptor.Dummy__
var _ m_DynamoDbEncryptionBranchKeyIdSupplier.Dummy__

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
	return "AwsCryptographyDbEncryptionSdkDynamoDbOperations.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) CreateDynamoDbEncryptionBranchKeyIdSupplier(config Config, input m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CreateDynamoDbEncryptionBranchKeyIdSupplierInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_supplier *m_DynamoDbEncryptionBranchKeyIdSupplier.DynamoDbEncryptionBranchKeyIdSupplier
	_ = _0_supplier
	var _nw0 *m_DynamoDbEncryptionBranchKeyIdSupplier.DynamoDbEncryptionBranchKeyIdSupplier = m_DynamoDbEncryptionBranchKeyIdSupplier.New_DynamoDbEncryptionBranchKeyIdSupplier_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_ddbKeyBranchKeyIdSupplier())
	_0_supplier = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_.Create_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_(_0_supplier))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetEncryptedDataKeyDescription(config Config, input m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = output
	var _0_header _dafny.Sequence = _dafny.EmptySeq
	_ = _0_header
	var _source0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionUnion = (input).Dtor_input()
	_ = _source0
	{
		{
			if _source0.Is_item() {
				var _1_item _dafny.Map = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionUnion_item).Item
				_ = _1_item
				{
					var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _2_valueOrError0
					_2_valueOrError0 = m_Wrappers.Companion_Default___.Need(((_1_item).Contains(_dafny.SeqOfString("aws_dbe_head"))) && (((_1_item).Get(_dafny.SeqOfString("aws_dbe_head")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_B()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Header not found in the DynamoDB item.")))
					if (_2_valueOrError0).IsFailure() {
						output = (_2_valueOrError0).PropagateFailure()
						return output
					}
					_0_header = ((_1_item).Get(_dafny.SeqOfString("aws_dbe_head")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_B()
				}
				goto Lmatch0
			}
		}
		{
			var _3_headerItem _dafny.Sequence = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionUnion_header).Header
			_ = _3_headerItem
			_0_header = _3_headerItem
		}
		goto Lmatch0
	}
Lmatch0:
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError1
	_4_valueOrError1 = (m_StructuredEncryptionHeader.Companion_Default___.PartialDeserialize(_0_header)).MapFailure(func(coer76 func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg104 interface{}) interface{} {
			return coer76(arg104.(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error))
		}
	}(func(_5_e m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkStructuredEncryption_(_5_e)
	}))
	if (_4_valueOrError1).IsFailure() {
		output = (_4_valueOrError1).PropagateFailure()
		return output
	}
	var _6_deserializedHeader m_StructuredEncryptionHeader.PartialHeader
	_ = _6_deserializedHeader
	_6_deserializedHeader = (_4_valueOrError1).Extract().(m_StructuredEncryptionHeader.PartialHeader)
	var _7_datakeys _dafny.Sequence
	_ = _7_datakeys
	_7_datakeys = (_6_deserializedHeader).Dtor_dataKeys()
	var _8_list _dafny.Sequence
	_ = _8_list
	_8_list = _dafny.SeqOf()
	var _hi0 uint64 = uint64((_7_datakeys).Cardinality())
	_ = _hi0
	for _9_i := uint64(0); _9_i < _hi0; _9_i++ {
		var _10_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _10_valueOrError2
		_10_valueOrError2 = (m_UTF8.Decode(((_7_datakeys).Select(uint32(_9_i)).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)).Dtor_keyProviderId())).MapFailure(func(coer77 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg105 interface{}) interface{} {
				return coer77(arg105.(_dafny.Sequence))
			}
		}(func(_11_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_DynamoDbEncryptionUtil.Companion_Default___.E(_11_e)
		}))
		if (_10_valueOrError2).IsFailure() {
			output = (_10_valueOrError2).PropagateFailure()
			return output
		}
		var _12_extractedKeyProviderId _dafny.Sequence
		_ = _12_extractedKeyProviderId
		_12_extractedKeyProviderId = (_10_valueOrError2).Extract().(_dafny.Sequence)
		var _13_extractedKeyProviderIdInfo m_Wrappers.Option
		_ = _13_extractedKeyProviderIdInfo
		_13_extractedKeyProviderIdInfo = m_Wrappers.Companion_Option_.Create_None_()
		var _14_expectedBranchKeyVersion m_Wrappers.Option
		_ = _14_expectedBranchKeyVersion
		_14_expectedBranchKeyVersion = m_Wrappers.Companion_Option_.Create_None_()
		if _dafny.Companion_Sequence_.IsPrefixOf(_dafny.SeqOfString("aws-kms"), _12_extractedKeyProviderId) {
			var _15_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _15_valueOrError3
			_15_valueOrError3 = m_Wrappers.Companion_Default___.Need((((_6_deserializedHeader).Dtor_flavor()) == (uint8(0))) || (((_6_deserializedHeader).Dtor_flavor()) == (uint8(1))), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid format flavor.")))
			if (_15_valueOrError3).IsFailure() {
				output = (_15_valueOrError3).PropagateFailure()
				return output
			}
			var _16_algorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo = m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo{}
			_ = _16_algorithmSuite
			if ((_6_deserializedHeader).Dtor_flavor()) == (uint8(0)) {
				_16_algorithmSuite = m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384()
			} else {
				_16_algorithmSuite = m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()
			}
			var _17_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _17_valueOrError4
			_17_valueOrError4 = (m_UTF8.Decode(((_7_datakeys).Select(uint32(_9_i)).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)).Dtor_keyProviderInfo())).MapFailure(func(coer78 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
				return func(arg106 interface{}) interface{} {
					return coer78(arg106.(_dafny.Sequence))
				}
			}(func(_18_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
				return m_DynamoDbEncryptionUtil.Companion_Default___.E(_18_e)
			}))
			if (_17_valueOrError4).IsFailure() {
				output = (_17_valueOrError4).PropagateFailure()
				return output
			}
			var _19_maybeKeyProviderIdInfo _dafny.Sequence
			_ = _19_maybeKeyProviderIdInfo
			_19_maybeKeyProviderIdInfo = (_17_valueOrError4).Extract().(_dafny.Sequence)
			_13_extractedKeyProviderIdInfo = m_Wrappers.Companion_Option_.Create_Some_(_19_maybeKeyProviderIdInfo)
			if _dafny.Companion_Sequence_.Equal(_12_extractedKeyProviderId, _dafny.SeqOfString("aws-kms-hierarchy")) {
				var _20_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
				_ = _20_valueOrError5
				_20_valueOrError5 = (m_EdkWrapping.Companion_Default___.GetProviderWrappedMaterial(((_7_datakeys).Select(uint32(_9_i)).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)).Dtor_ciphertext(), _16_algorithmSuite)).MapFailure(func(coer79 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
					return func(arg107 interface{}) interface{} {
						return coer79(arg107.(m_AwsCryptographyMaterialProvidersTypes.Error))
					}
				}(func(_21_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
					return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_21_e)
				}))
				if (_20_valueOrError5).IsFailure() {
					output = (_20_valueOrError5).PropagateFailure()
					return output
				}
				var _22_providerWrappedMaterial _dafny.Sequence
				_ = _22_providerWrappedMaterial
				_22_providerWrappedMaterial = (_20_valueOrError5).Extract().(_dafny.Sequence)
				var _23_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX uint64
				_ = _23_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX
				_23_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX = (Companion_Default___.SALT__LENGTH()) + (Companion_Default___.IV__LENGTH())
				var _24_EDK__CIPHERTEXT__VERSION__INDEX uint64
				_ = _24_EDK__CIPHERTEXT__VERSION__INDEX
				_24_EDK__CIPHERTEXT__VERSION__INDEX = (_23_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX) + (Companion_Default___.VERSION__LENGTH())
				var _25_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _25_valueOrError6
				_25_valueOrError6 = m_Wrappers.Companion_Default___.Need((_23_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX) < (_24_EDK__CIPHERTEXT__VERSION__INDEX), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Wrong branch key version index.")))
				if (_25_valueOrError6).IsFailure() {
					output = (_25_valueOrError6).PropagateFailure()
					return output
				}
				var _26_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _26_valueOrError7
				_26_valueOrError7 = m_Wrappers.Companion_Default___.Need((uint64((_22_providerWrappedMaterial).Cardinality())) >= (_24_EDK__CIPHERTEXT__VERSION__INDEX), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Incorrect ciphertext structure length.")))
				if (_26_valueOrError7).IsFailure() {
					output = (_26_valueOrError7).PropagateFailure()
					return output
				}
				var _27_branchKeyVersionUuid _dafny.Sequence
				_ = _27_branchKeyVersionUuid
				_27_branchKeyVersionUuid = (_22_providerWrappedMaterial).Subsequence(uint32(_23_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX), uint32(_24_EDK__CIPHERTEXT__VERSION__INDEX))
				var _28_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
				_ = _28_valueOrError8
				_28_valueOrError8 = (m_UUID.FromByteArray(_27_branchKeyVersionUuid)).MapFailure(func(coer80 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
					return func(arg108 interface{}) interface{} {
						return coer80(arg108.(_dafny.Sequence))
					}
				}(func(_29_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
					return m_DynamoDbEncryptionUtil.Companion_Default___.E(_29_e)
				}))
				if (_28_valueOrError8).IsFailure() {
					output = (_28_valueOrError8).PropagateFailure()
					return output
				}
				var _30_maybeBranchKeyVersion _dafny.Sequence
				_ = _30_maybeBranchKeyVersion
				_30_maybeBranchKeyVersion = (_28_valueOrError8).Extract().(_dafny.Sequence)
				_14_expectedBranchKeyVersion = m_Wrappers.Companion_Option_.Create_Some_(_30_maybeBranchKeyVersion)
			}
		}
		var _31_singleDataKeyOutput m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription
		_ = _31_singleDataKeyOutput
		_31_singleDataKeyOutput = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedDataKeyDescription_.Create_EncryptedDataKeyDescription_(_12_extractedKeyProviderId, _13_extractedKeyProviderIdInfo, _13_extractedKeyProviderIdInfo, _14_expectedBranchKeyVersion)
		_8_list = _dafny.Companion_Sequence_.Concatenate(_8_list, _dafny.SeqOf(_31_singleDataKeyOutput))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Create_GetEncryptedDataKeyDescriptionOutput_(_8_list))
	return output
}
func (_static *CompanionStruct_Default___) SALT__LENGTH() uint64 {
	return uint64(16)
}
func (_static *CompanionStruct_Default___) IV__LENGTH() uint64 {
	return uint64(12)
}
func (_static *CompanionStruct_Default___) VERSION__LENGTH() uint64 {
	return uint64(16)
}

// End of class Default__

// Definition of datatype Config
type Config struct {
	Data_Config_
}

func (_this Config) Get_() Data_Config_ {
	return _this.Data_Config_
}

type Data_Config_ interface {
	isConfig()
}

type CompanionStruct_Config_ struct {
}

var Companion_Config_ = CompanionStruct_Config_{}

type Config_Config struct {
}

func (Config_Config) isConfig() {}

func (CompanionStruct_Config_) Create_Config_() Config {
	return Config{Config_Config{}}
}

func (_this Config) Is_Config() bool {
	_, ok := _this.Get_().(Config_Config)
	return ok
}

func (CompanionStruct_Config_) Default() Config {
	return Companion_Config_.Create_Config_()
}

func (_ CompanionStruct_Config_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_Config_.Create_Config_(), true
		default:
			return Config{}, false
		}
	}
}

func (_this Config) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case Config_Config:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbOperations.Config.Config"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Config) Equals(other Config) bool {
	switch _this.Get_().(type) {
	case Config_Config:
		{
			_, ok := other.Get_().(Config_Config)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Config) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Config)
	return ok && _this.Equals(typed)
}

func Type_Config_() _dafny.TypeDescriptor {
	return type_Config_{}
}

type type_Config_ struct {
}

func (_this type_Config_) Default() interface{} {
	return Companion_Config_.Default()
}

func (_this type_Config_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbOperations.Config"
}
func (_this Config) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Config{}

// End of datatype Config
