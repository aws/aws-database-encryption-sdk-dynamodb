// Package TermLoc
// Dafny module TermLoc compiled into Go

package TermLoc

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
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Canonize"
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryption"
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
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbOperations.Dummy__
var _ m_DynamoDbEncryption.Dummy__

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
	return "TermLoc.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ValidTermLoc(s _dafny.Sequence) bool {
	return ((uint64(0)) < (uint64((s).Cardinality()))) && (((s).Select(uint32(uint32(0))).(Selector)).Is_Map())
}
func (_static *CompanionStruct_Default___) TermLocToString(t _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(((t).Select(uint32(uint32(0))).(Selector)).Dtor_key(), Companion_Default___.SelectorListToString((t).Drop(uint32(uint32(1)))))
}
func (_static *CompanionStruct_Default___) SelectorListToString(s _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((s).Cardinality())) == (uint64(0)) {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfString(""))
	} else if ((s).Select(uint32(uint32(0))).(Selector)).Is_Map() {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("."), ((s).Select(uint32(uint32(0))).(Selector)).Dtor_key()))
		var _in0 _dafny.Sequence = (s).Drop(uint32(uint32(1)))
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("["), m_StandardLibrary_String.Companion_Default___.Base10Int2String(_dafny.IntOfUint64(((s).Select(uint32(uint32(0))).(Selector)).Dtor_pos()))), _dafny.SeqOfString("]")))
		var _in1 _dafny.Sequence = (s).Drop(uint32(uint32(1)))
		_ = _in1
		s = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) LacksAttribute(t _dafny.Sequence, item _dafny.Map) bool {
	return !(item).Contains(((t).Select(uint32(uint32(0))).(Selector)).Dtor_key())
}
func (_static *CompanionStruct_Default___) TermToAttr(t _dafny.Sequence, item _dafny.Map, names m_Wrappers.Option) m_Wrappers.Option {
	if !(item).Contains(((t).Select(uint32(uint32(0))).(Selector)).Dtor_key()) {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _0_res m_Wrappers.Result = Companion_Default___.GetTerminal((item).Get(((t).Select(uint32(uint32(0))).(Selector)).Dtor_key()).(m_ComAmazonawsDynamodbTypes.AttributeValue), (t).Drop(uint32(uint32(1))), names)
		_ = _0_res
		if (_0_res).Is_Success() {
			return m_Wrappers.Companion_Option_.Create_Some_((_0_res).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue))
		} else {
			return m_Wrappers.Companion_Option_.Create_None_()
		}
	}
}
func (_static *CompanionStruct_Default___) TermToString(t _dafny.Sequence, item _dafny.Map) m_Wrappers.Result {
	var _0_part m_Wrappers.Option = Companion_Default___.TermToAttr(t, item, m_Wrappers.Companion_Option_.Create_None_())
	_ = _0_part
	if (_0_part).Is_None() {
		return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
	} else {
		var _1_valueOrError0 m_Wrappers.Result = Companion_Default___.AttrValueToString((_0_part).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue))
		_ = _1_valueOrError0
		if (_1_valueOrError0).IsFailure() {
			return (_1_valueOrError0).PropagateFailure()
		} else {
			var _2_res _dafny.Sequence = (_1_valueOrError0).Extract().(_dafny.Sequence)
			_ = _2_res
			return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(_2_res))
		}
	}
}
func (_static *CompanionStruct_Default___) TermToBytes(t _dafny.Sequence, item _dafny.Map) m_Wrappers.Result {
	var _0_part m_Wrappers.Option = Companion_Default___.TermToAttr(t, item, m_Wrappers.Companion_Option_.Create_None_())
	_ = _0_part
	if (_0_part).Is_None() {
		return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
	} else {
		var _1_valueOrError0 m_Wrappers.Result = (m_DynamoToStruct.Companion_Default___.TopLevelAttributeToBytes((_0_part).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue))).MapFailure(func(coer81 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg109 interface{}) interface{} {
				return coer81(arg109.(_dafny.Sequence))
			}
		}(func(_2_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_DynamoDbEncryptionUtil.Companion_Default___.E(_2_e)
		}))
		_ = _1_valueOrError0
		if (_1_valueOrError0).IsFailure() {
			return (_1_valueOrError0).PropagateFailure()
		} else {
			var _3_res _dafny.Sequence = (_1_valueOrError0).Extract().(_dafny.Sequence)
			_ = _3_res
			return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(_3_res))
		}
	}
}
func (_static *CompanionStruct_Default___) GetTerminal(v m_ComAmazonawsDynamodbTypes.AttributeValue, parts _dafny.Sequence, names m_Wrappers.Option) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((parts).Cardinality())) == (uint64(0)) {
		return m_Wrappers.Companion_Result_.Create_Success_(v)
	} else {
		var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = v
		_ = _source0
		{
			if _source0.Is_S() {
				var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
				_ = _0_s
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Found string with parts left over.")))
			}
		}
		{
			if _source0.Is_N() {
				var _1_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
				_ = _1_s
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Found number with parts left over.")))
			}
		}
		{
			if _source0.Is_B() {
				var _2_b _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
				_ = _2_b
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Found binary with parts left over.")))
			}
		}
		{
			if _source0.Is_SS() {
				var _3_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
				_ = _3_s
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Found string set with parts left over.")))
			}
		}
		{
			if _source0.Is_NS() {
				var _4_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
				_ = _4_s
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Found number set with parts left over.")))
			}
		}
		{
			if _source0.Is_BS() {
				var _5_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
				_ = _5_s
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Found binary set with parts left over.")))
			}
		}
		{
			if _source0.Is_BOOL() {
				var _6_b bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
				_ = _6_b
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Found boolean with parts left over.")))
			}
		}
		{
			if _source0.Is_NULL() {
				var _7_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
				_ = _7_n
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Found null with parts left over.")))
			}
		}
		{
			if _source0.Is_L() {
				var _8_l _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
				_ = _8_l
				if !(((parts).Select(uint32(uint32(0))).(Selector)).Is_List()) {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Tried to access list with key")))
				} else if (uint64((_8_l).Cardinality())) <= (((parts).Select(uint32(uint32(0))).(Selector)).Dtor_pos()) {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Tried to access beyond the end of the list")))
				} else {
					var _in0 m_ComAmazonawsDynamodbTypes.AttributeValue = (_8_l).Select(uint32(((parts).Select(uint32(uint32(0))).(Selector)).Dtor_pos())).(m_ComAmazonawsDynamodbTypes.AttributeValue)
					_ = _in0
					var _in1 _dafny.Sequence = (parts).Drop(uint32(uint32(1)))
					_ = _in1
					var _in2 m_Wrappers.Option = names
					_ = _in2
					v = _in0
					parts = _in1
					names = _in2
					goto TAIL_CALL_START
				}
			}
		}
		{
			var _9_m _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
			_ = _9_m
			if !(((parts).Select(uint32(uint32(0))).(Selector)).Is_Map()) {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Tried to access map with index")))
			} else if !(_9_m).Contains(((parts).Select(uint32(uint32(0))).(Selector)).Dtor_key()) {
				if (((names).Is_Some()) && (((names).Dtor_value().(_dafny.Map)).Contains(((parts).Select(uint32(uint32(0))).(Selector)).Dtor_key()))) && ((_9_m).Contains(((names).Dtor_value().(_dafny.Map)).Get(((parts).Select(uint32(uint32(0))).(Selector)).Dtor_key()).(_dafny.Sequence))) {
					var _in3 m_ComAmazonawsDynamodbTypes.AttributeValue = (_9_m).Get(((names).Dtor_value().(_dafny.Map)).Get(((parts).Select(uint32(uint32(0))).(Selector)).Dtor_key()).(_dafny.Sequence)).(m_ComAmazonawsDynamodbTypes.AttributeValue)
					_ = _in3
					var _in4 _dafny.Sequence = (parts).Drop(uint32(uint32(1)))
					_ = _in4
					var _in5 m_Wrappers.Option = names
					_ = _in5
					v = _in3
					parts = _in4
					names = _in5
					goto TAIL_CALL_START
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Tried to access "), ((parts).Select(uint32(uint32(0))).(Selector)).Dtor_key()), _dafny.SeqOfString(" which is not in the map."))))
				}
			} else {
				var _in6 m_ComAmazonawsDynamodbTypes.AttributeValue = (_9_m).Get(((parts).Select(uint32(uint32(0))).(Selector)).Dtor_key()).(m_ComAmazonawsDynamodbTypes.AttributeValue)
				_ = _in6
				var _in7 _dafny.Sequence = (parts).Drop(uint32(uint32(1)))
				_ = _in7
				var _in8 m_Wrappers.Option = names
				_ = _in8
				v = _in6
				parts = _in7
				names = _in8
				goto TAIL_CALL_START
			}
		}
	}
}
func (_static *CompanionStruct_Default___) AttrValueToString(v m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = v
	_ = _source0
	{
		if _source0.Is_S() {
			var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
			_ = _0_s
			return m_Wrappers.Companion_Result_.Create_Success_(_0_s)
		}
	}
	{
		if _source0.Is_N() {
			var _1_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _1_s
			return m_Wrappers.Companion_Result_.Create_Success_(_1_s)
		}
	}
	{
		if _source0.Is_B() {
			var _2_b _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
			_ = _2_b
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Can't convert Binary to string")))
		}
	}
	{
		if _source0.Is_SS() {
			var _3_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
			_ = _3_s
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Can't convert String Set to string.")))
		}
	}
	{
		if _source0.Is_NS() {
			var _4_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
			_ = _4_s
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Can't convert Number Set to string.")))
		}
	}
	{
		if _source0.Is_BS() {
			var _5_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
			_ = _5_s
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Can't convert Binary Set to string.")))
		}
	}
	{
		if _source0.Is_BOOL() {
			var _6_b bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
			_ = _6_b
			return m_Wrappers.Companion_Result_.Create_Success_((func() _dafny.Sequence {
				if _6_b {
					return _dafny.SeqOfString("true")
				}
				return _dafny.SeqOfString("false")
			})())
		}
	}
	{
		if _source0.Is_NULL() {
			var _7_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
			_ = _7_n
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOfString("null"))
		}
	}
	{
		if _source0.Is_L() {
			var _8_l _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
			_ = _8_l
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Can't convert List to string.")))
		}
	}
	{
		var _9_m _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
		_ = _9_m
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Can't convert Map to string.")))
	}
}
func (_static *CompanionStruct_Default___) FindStartOfNext(s _dafny.Sequence) m_Wrappers.Option {
	var _0_dot m_Wrappers.Option = m_StandardLibrary.Companion_Default___.FindIndexMatching(s, _dafny.Char('.'), uint64(0))
	_ = _0_dot
	var _1_bracket m_Wrappers.Option = m_StandardLibrary.Companion_Default___.FindIndexMatching(s, _dafny.Char('['), uint64(0))
	_ = _1_bracket
	if ((_0_dot).Is_None()) && ((_1_bracket).Is_None()) {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else if ((_0_dot).Is_Some()) && ((_1_bracket).Is_Some()) {
		if ((_0_dot).Dtor_value().(uint64)) < ((_1_bracket).Dtor_value().(uint64)) {
			return _0_dot
		} else {
			return _1_bracket
		}
	} else if (_0_dot).Is_Some() {
		return _0_dot
	} else {
		return _1_bracket
	}
}
func (_static *CompanionStruct_Default___) GetNumber(s _dafny.Sequence, acc uint64, pos uint64) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((s).Cardinality())) == (pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(acc)
	} else if ((_dafny.Char('0')) <= ((s).Select(uint32(uint32(0))).(_dafny.Char))) && (((s).Select(uint32(uint32(0))).(_dafny.Char)) <= (_dafny.Char('9'))) {
		if (acc) < (uint64(1152921504606846975)) {
			var _in0 _dafny.Sequence = s
			_ = _in0
			var _in1 uint64 = (((acc) * (uint64(10))) + (uint64((s).Select(uint32(uint32(0))).(_dafny.Char)))) - (func() uint64 { return (uint64(_dafny.Char('0'))) })()
			_ = _in1
			var _in2 uint64 = m_StandardLibrary_MemoryMath.Companion_Default___.Add(pos, uint64(1))
			_ = _in2
			s = _in0
			acc = _in1
			pos = _in2
			goto TAIL_CALL_START
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Number is too big for list index : "), s)))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected character in number : "), _dafny.SeqOfChars((s).Select(uint32(uint32(0))).(_dafny.Char)))))
	}
}
func (_static *CompanionStruct_Default___) GetSelector(s _dafny.Sequence) m_Wrappers.Result {
	if ((s).Select(uint32(uint32(0))).(_dafny.Char)) == (_dafny.Char('.')) {
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_Selector_.Create_Map_((s).Drop(uint32(uint32(1)))))
	} else if ((s).Select(uint32((uint64((s).Cardinality())) - (func() uint64 { return (uint64(1)) })())).(_dafny.Char)) != (_dafny.Char(']')) /* dircomp */ {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("List index must end with ]")))
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetNumber((s).Subsequence(uint32(uint32(1)), uint32((uint64((s).Cardinality()))-(func() uint64 { return (uint64(1)) })())), uint64(0), uint64(0))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_num uint64 = (_0_valueOrError0).Extract().(uint64)
			_ = _1_num
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_Selector_.Create_List_(_1_num))
		}
	}
}
func (_static *CompanionStruct_Default___) GetSelectors(s _dafny.Sequence, acc _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	var _0_pos m_Wrappers.Option = Companion_Default___.FindStartOfNext((s).Drop(uint32(uint32(1))))
	_ = _0_pos
	var _1_end uint64 = (func() uint64 {
		if (_0_pos).Is_None() {
			return uint64((s).Cardinality())
		}
		return m_StandardLibrary_MemoryMath.Companion_Default___.Add((_0_pos).Dtor_value().(uint64), uint64(1))
	})()
	_ = _1_end
	var _2_valueOrError0 m_Wrappers.Result = Companion_Default___.GetSelector((s).Take(uint32(_1_end)))
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		var _3_sel Selector = (_2_valueOrError0).Extract().(Selector)
		_ = _3_sel
		if (_0_pos).Is_None() {
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(_3_sel)))
		} else {
			var _in0 _dafny.Sequence = (s).Drop(uint32(_1_end))
			_ = _in0
			var _in1 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(_3_sel))
			_ = _in1
			s = _in0
			acc = _in1
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) MakeTermLoc(s _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(0)) < (uint64((s).Cardinality())), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Path specification must not be empty.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_pos m_Wrappers.Option = Companion_Default___.FindStartOfNext(s)
		_ = _1_pos
		if (_1_pos).Is_None() {
			var _2_m Selector = Companion_Selector_.Create_Map_(s)
			_ = _2_m
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(Companion_Selector_.Create_Map_(s)))
		} else {
			var _3_name _dafny.Sequence = (s).Take(uint32((_1_pos).Dtor_value().(uint64)))
			_ = _3_name
			var _4_valueOrError1 m_Wrappers.Result = Companion_Default___.GetSelectors((s).Drop(uint32((_1_pos).Dtor_value().(uint64))), _dafny.SeqOf())
			_ = _4_valueOrError1
			if (_4_valueOrError1).IsFailure() {
				return (_4_valueOrError1).PropagateFailure()
			} else {
				var _5_selectors _dafny.Sequence = (_4_valueOrError1).Extract().(_dafny.Sequence)
				_ = _5_selectors
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(Companion_Selector_.Create_Map_(_3_name)), _5_selectors))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) TermLocMap(attr _dafny.Sequence) _dafny.Sequence {
	return _dafny.SeqOf(Companion_Selector_.Create_Map_(attr))
}

// End of class Default__

// Definition of datatype Selector
type Selector struct {
	Data_Selector_
}

func (_this Selector) Get_() Data_Selector_ {
	return _this.Data_Selector_
}

type Data_Selector_ interface {
	isSelector()
}

type CompanionStruct_Selector_ struct {
}

var Companion_Selector_ = CompanionStruct_Selector_{}

type Selector_List struct {
	Pos uint64
}

func (Selector_List) isSelector() {}

func (CompanionStruct_Selector_) Create_List_(Pos uint64) Selector {
	return Selector{Selector_List{Pos}}
}

func (_this Selector) Is_List() bool {
	_, ok := _this.Get_().(Selector_List)
	return ok
}

type Selector_Map struct {
	Key _dafny.Sequence
}

func (Selector_Map) isSelector() {}

func (CompanionStruct_Selector_) Create_Map_(Key _dafny.Sequence) Selector {
	return Selector{Selector_Map{Key}}
}

func (_this Selector) Is_Map() bool {
	_, ok := _this.Get_().(Selector_Map)
	return ok
}

func (CompanionStruct_Selector_) Default() Selector {
	return Companion_Selector_.Create_List_(uint64(0))
}

func (_this Selector) Dtor_pos() uint64 {
	return _this.Get_().(Selector_List).Pos
}

func (_this Selector) Dtor_key() _dafny.Sequence {
	return _this.Get_().(Selector_Map).Key
}

func (_this Selector) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Selector_List:
		{
			return "TermLoc.Selector.List" + "(" + _dafny.String(data.Pos) + ")"
		}
	case Selector_Map:
		{
			return "TermLoc.Selector.Map" + "(" + _dafny.String(data.Key) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Selector) Equals(other Selector) bool {
	switch data1 := _this.Get_().(type) {
	case Selector_List:
		{
			data2, ok := other.Get_().(Selector_List)
			return ok && data1.Pos == data2.Pos
		}
	case Selector_Map:
		{
			data2, ok := other.Get_().(Selector_Map)
			return ok && data1.Key.Equals(data2.Key)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Selector) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Selector)
	return ok && _this.Equals(typed)
}

func Type_Selector_() _dafny.TypeDescriptor {
	return type_Selector_{}
}

type type_Selector_ struct {
}

func (_this type_Selector_) Default() interface{} {
	return Companion_Selector_.Default()
}

func (_this type_Selector_) String() string {
	return "TermLoc.Selector"
}
func (_this Selector) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Selector{}

// End of datatype Selector

// Definition of class TermLoc
type TermLoc struct {
}

func New_TermLoc_() *TermLoc {
	_this := TermLoc{}

	return &_this
}

type CompanionStruct_TermLoc_ struct {
}

var Companion_TermLoc_ = CompanionStruct_TermLoc_{}

func (*TermLoc) String() string {
	return "TermLoc.TermLoc"
}

// End of class TermLoc

func Type_TermLoc_() _dafny.TypeDescriptor {
	return type_TermLoc_{}
}

type type_TermLoc_ struct {
}

func (_this type_TermLoc_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_TermLoc_) String() string {
	return "TermLoc.TermLoc"
}
func (_this *CompanionStruct_TermLoc_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return Companion_Default___.ValidTermLoc(_0_x)
}
