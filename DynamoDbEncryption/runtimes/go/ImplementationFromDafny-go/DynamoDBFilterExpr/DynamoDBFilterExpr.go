// Package DynamoDBFilterExpr
// Dafny module DynamoDBFilterExpr compiled into Go

package DynamoDBFilterExpr

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
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/BaseBeacon"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m_CompoundBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/CompoundBeacon"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbVirtualFields"
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryption"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptorUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbNormalizeNumber"
	m_DynamoDbUpdateExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbUpdateExpr"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoToStruct"
	m_InternalLegacyOverride "github.com/aws/aws-database-encryption-sdk-dynamodb/InternalLegacyOverride"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/Maps_"
	m_MemoryMath "github.com/aws/aws-database-encryption-sdk-dynamodb/MemoryMath"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_SearchableEncryptionInfo "github.com/aws/aws-database-encryption-sdk-dynamodb/SearchableEncryptionInfo"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/SortCanon"
	m_StructuredEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryption"
	m_StructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionCrypt"
	m_StructuredEncryptionFooter "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionFooter"
	m_StructuredEncryptionHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionHeader"
	m_StructuredEncryptionPaths "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionPaths"
	m_StructuredEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionUtil"
	m_TermLoc "github.com/aws/aws-database-encryption-sdk-dynamodb/TermLoc"
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
var _ m_MemoryMath.Dummy__
var _ m_DynamoToStruct.Dummy__
var _ m_DynamoDbItemEncryptorUtil.Dummy__
var _ m_InternalLegacyOverride.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Dummy__
var _ m_DynamoDbItemEncryptor.Dummy__
var _ m_DynamoDbEncryptionBranchKeyIdSupplier.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbOperations.Dummy__
var _ m_DynamoDbEncryption.Dummy__
var _ m_TermLoc.Dummy__
var _ m_DdbVirtualFields.Dummy__
var _ m_DynamoDbUpdateExpr.Dummy__
var _ m_BaseBeacon.Dummy__
var _ m_CompoundBeacon.Dummy__
var _ m_SearchableEncryptionInfo.Dummy__

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
	return "DynamoDBFilterExpr.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ExtractAttributes(s _dafny.Sequence, ex m_Wrappers.Option) _dafny.Sequence {
	var _0_tokens _dafny.Sequence = Companion_Default___.ParseExpr(s)
	_ = _0_tokens
	return Companion_Default___.ExtractAttributes2(_0_tokens, ex, _dafny.IntOfInt64(-1))
}
func (_static *CompanionStruct_Default___) IsSpecial(t Token) bool {
	return (((t).Is_AttributeExists()) || ((t).Is_AttributeNotExists())) || ((t).Is_Size())
}
func (_static *CompanionStruct_Default___) ExtractAttributes2(tokens _dafny.Sequence, names m_Wrappers.Option, tokensUntilSkip _dafny.Int) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((tokens).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else if Companion_Default___.IsSpecial((tokens).Select(0).(Token)) {
		var _in0 _dafny.Sequence = (tokens).Drop(1)
		_ = _in0
		var _in1 m_Wrappers.Option = names
		_ = _in1
		var _in2 _dafny.Int = _dafny.One
		_ = _in2
		tokens = _in0
		names = _in1
		tokensUntilSkip = _in2
		goto TAIL_CALL_START
	} else if (((tokens).Select(0).(Token)).Is_Attr()) && ((tokensUntilSkip).Sign() == 0) {
		var _in3 _dafny.Sequence = (tokens).Drop(1)
		_ = _in3
		var _in4 m_Wrappers.Option = names
		_ = _in4
		var _in5 _dafny.Int = _dafny.IntOfInt64(-1)
		_ = _in5
		tokens = _in3
		names = _in4
		tokensUntilSkip = _in5
		goto TAIL_CALL_START
	} else if ((tokens).Select(0).(Token)).Is_Attr() {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf(Companion_Default___.GetAttrName((tokens).Select(0).(Token), names)))
		var _in6 _dafny.Sequence = (tokens).Drop(1)
		_ = _in6
		var _in7 m_Wrappers.Option = names
		_ = _in7
		var _in8 _dafny.Int = _dafny.IntOfInt64(-1)
		_ = _in8
		tokens = _in6
		names = _in7
		tokensUntilSkip = _in8
		goto TAIL_CALL_START
	} else {
		var _in9 _dafny.Sequence = (tokens).Drop(1)
		_ = _in9
		var _in10 m_Wrappers.Option = names
		_ = _in10
		var _in11 _dafny.Int = (tokensUntilSkip).Minus(_dafny.One)
		_ = _in11
		tokens = _in9
		names = _in10
		tokensUntilSkip = _in11
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) IsEquality(t Token) bool {
	return (((t).Is_Eq()) || ((t).Is_Ne())) || ((t).Is_In())
}
func (_static *CompanionStruct_Default___) IsInequality(t Token) bool {
	return ((((t).Is_Lt()) || ((t).Is_Le())) || ((t).Is_Gt())) || ((t).Is_Ge())
}
func (_static *CompanionStruct_Default___) TokenToString(t Token) _dafny.Sequence {
	var _source0 Token = t
	_ = _source0
	{
		if _source0.Is_Attr() {
			var _0_s _dafny.Sequence = _source0.Get_().(Token_Attr).S
			_ = _0_s
			var _1_l _dafny.Sequence = _source0.Get_().(Token_Attr).Loc
			_ = _1_l
			return _0_s
		}
	}
	{
		if _source0.Is_Value() {
			var _2_s _dafny.Sequence = _source0.Get_().(Token_Value).S
			_ = _2_s
			return _2_s
		}
	}
	{
		if _source0.Is_Eq() {
			return _dafny.SeqOfString("=")
		}
	}
	{
		if _source0.Is_Ne() {
			return _dafny.SeqOfString("<>")
		}
	}
	{
		if _source0.Is_Lt() {
			return _dafny.SeqOfString("<")
		}
	}
	{
		if _source0.Is_Gt() {
			return _dafny.SeqOfString(">")
		}
	}
	{
		if _source0.Is_Le() {
			return _dafny.SeqOfString("<=")
		}
	}
	{
		if _source0.Is_Ge() {
			return _dafny.SeqOfString(">=")
		}
	}
	{
		if _source0.Is_Between() {
			return _dafny.SeqOfString("BETWEEN")
		}
	}
	{
		if _source0.Is_In() {
			return _dafny.SeqOfString("IN")
		}
	}
	{
		if _source0.Is_Open() {
			return _dafny.SeqOfString("(")
		}
	}
	{
		if _source0.Is_Close() {
			return _dafny.SeqOfString(")")
		}
	}
	{
		if _source0.Is_Comma() {
			return _dafny.SeqOfString(",")
		}
	}
	{
		if _source0.Is_Not() {
			return _dafny.SeqOfString("NOT")
		}
	}
	{
		if _source0.Is_And() {
			return _dafny.SeqOfString("AND")
		}
	}
	{
		if _source0.Is_Or() {
			return _dafny.SeqOfString("OR")
		}
	}
	{
		if _source0.Is_AttributeExists() {
			return _dafny.SeqOfString("attribute_exists")
		}
	}
	{
		if _source0.Is_AttributeNotExists() {
			return _dafny.SeqOfString("attribute_not_exists")
		}
	}
	{
		if _source0.Is_AttributeType() {
			return _dafny.SeqOfString("attribute_type")
		}
	}
	{
		if _source0.Is_BeginsWith() {
			return _dafny.SeqOfString("begins_with")
		}
	}
	{
		if _source0.Is_Contains() {
			return _dafny.SeqOfString("contains")
		}
	}
	{
		return _dafny.SeqOfString("size")
	}
}
func (_static *CompanionStruct_Default___) GetInPos(expr _dafny.Sequence, pos _dafny.Int) m_Wrappers.Option {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (pos).Cmp(_dafny.IntOfInt64(3)) < 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else if (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Open()) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_In()) {
		return m_Wrappers.Companion_Option_.Create_Some_((pos).Minus(_dafny.IntOfInt64(2)))
	} else if (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Comma()) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_Value()) {
		var _in0 _dafny.Sequence = expr
		_ = _in0
		var _in1 _dafny.Int = (pos).Minus(_dafny.IntOfInt64(2))
		_ = _in1
		expr = _in0
		pos = _in1
		goto TAIL_CALL_START
	} else {
		return m_Wrappers.Companion_Option_.Create_None_()
	}
}
func (_static *CompanionStruct_Default___) RealName(s _dafny.Sequence) _dafny.Sequence {
	if _dafny.Companion_Sequence_.IsProperPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.BeaconPrefix(), s) {
		return (s).Drop((_dafny.IntOfUint32((m_DynamoDbEncryptionUtil.Companion_Default___.BeaconPrefix()).Cardinality())).Uint32())
	} else {
		return s
	}
}
func (_static *CompanionStruct_Default___) HasBeacon(b m_SearchableEncryptionInfo.BeaconVersion, t Token, names m_Wrappers.Option) bool {
	if (t).Is_Attr() {
		var _0_name _dafny.Sequence = Companion_Default___.RealName((t).Dtor_s())
		_ = _0_name
		return (((((b).Dtor_beacons()).Contains(_0_name)) || ((((names).Is_Some()) && (((names).Dtor_value().(_dafny.Map)).Contains(_0_name))) && (((b).Dtor_beacons()).Contains(Companion_Default___.RealName(((names).Dtor_value().(_dafny.Map)).Get(_0_name).(_dafny.Sequence)))))) || (((b).Dtor_encryptedFields()).Contains(_0_name))) || ((((names).Is_Some()) && (((names).Dtor_value().(_dafny.Map)).Contains(_0_name))) && (((b).Dtor_encryptedFields()).Contains(Companion_Default___.RealName(((names).Dtor_value().(_dafny.Map)).Get(_0_name).(_dafny.Sequence)))))
	} else {
		return false
	}
}
func (_static *CompanionStruct_Default___) GetBeacon2(b m_SearchableEncryptionInfo.BeaconVersion, t Token, names m_Wrappers.Option) m_Wrappers.Result {
	var _0_name _dafny.Sequence = Companion_Default___.RealName((t).Dtor_s())
	_ = _0_name
	if ((b).Dtor_beacons()).Contains(_0_name) {
		if m_SearchableEncryptionInfo.Companion_Default___.IsPartOnly(((b).Dtor_beacons()).Get(_0_name).(m_SearchableEncryptionInfo.Beacon)) {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Field "), _0_name), _dafny.SeqOfString(" is encrypted, and has a PartOnly beacon, and so can only be used as part of a compound beacon."))))
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(((b).Dtor_beacons()).Get(_0_name).(m_SearchableEncryptionInfo.Beacon))
		}
	} else if (((names).Is_Some()) && (((names).Dtor_value().(_dafny.Map)).Contains(_0_name))) && (((b).Dtor_beacons()).Contains(Companion_Default___.RealName(((names).Dtor_value().(_dafny.Map)).Get(_0_name).(_dafny.Sequence)))) {
		var _1_name2 _dafny.Sequence = Companion_Default___.RealName(((names).Dtor_value().(_dafny.Map)).Get(_0_name).(_dafny.Sequence))
		_ = _1_name2
		return m_Wrappers.Companion_Result_.Create_Success_(((b).Dtor_beacons()).Get(_1_name2).(m_SearchableEncryptionInfo.Beacon))
	} else if ((b).Dtor_encryptedFields()).Contains(_0_name) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Field "), _0_name), _dafny.SeqOfString(" is encrypted, and cannot be searched without a beacon."))))
	} else {
		var _2_name2 _dafny.Sequence = Companion_Default___.RealName(((names).Dtor_value().(_dafny.Map)).Get(_0_name).(_dafny.Sequence))
		_ = _2_name2
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Field "), _2_name2), _dafny.SeqOfString(" is encrypted, and cannot be searched without a beacon."))))
	}
}
func (_static *CompanionStruct_Default___) GetBeacon(bv m_SearchableEncryptionInfo.BeaconVersion, t Token, op Token, value Token, names m_Wrappers.Option, values _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetBeacon2(bv, t, names)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_b m_SearchableEncryptionInfo.Beacon = (_0_valueOrError0).Extract().(m_SearchableEncryptionInfo.Beacon)
		_ = _1_b
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.CanBeacon(_1_b, op, (value).Dtor_s(), values)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3___v0 bool = (_2_valueOrError1).Extract().(bool)
			_ = _3___v0
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_EqualityBeacon_.Create_EqualityBeacon_(m_Wrappers.Companion_Option_.Create_Some_(_1_b), Companion_Default___.IsEquality(op), (op).Equals(Companion_Token_.Create_Contains_())))
		}
	}
}
func (_static *CompanionStruct_Default___) GetBetweenBeacon(bv m_SearchableEncryptionInfo.BeaconVersion, t Token, op Token, leftValue Token, rightValue Token, names m_Wrappers.Option, values _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetBeacon2(bv, t, names)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_b m_SearchableEncryptionInfo.Beacon = (_0_valueOrError0).Extract().(m_SearchableEncryptionInfo.Beacon)
		_ = _1_b
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.CanBetween(_1_b, op, (leftValue).Dtor_s(), (rightValue).Dtor_s(), values)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3___v1 bool = (_2_valueOrError1).Extract().(bool)
			_ = _3___v1
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_EqualityBeacon_.Create_EqualityBeacon_(m_Wrappers.Companion_Option_.Create_Some_(_1_b), false, false))
		}
	}
}
func (_static *CompanionStruct_Default___) CanStandardBeacon(op Token) m_Wrappers.Result {
	var _source0 Token = op
	_ = _source0
	{
		var disjunctiveMatch0 bool = false
		_ = disjunctiveMatch0
		if _source0.Is_Ne() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Lt() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Gt() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Le() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Ge() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Between() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_BeginsWith() {
			disjunctiveMatch0 = true
		}
		if disjunctiveMatch0 {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("The operation '"), Companion_Default___.TokenToString(op)), _dafny.SeqOfString("' cannot be used with a standard beacon."))))
		}
	}
	{
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	}
}
func (_static *CompanionStruct_Default___) CanCompoundBeacon(b m_SearchableEncryptionInfo.Beacon, op Token, value _dafny.Sequence) m_Wrappers.Result {
	var _source0 Token = op
	_ = _source0
	{
		var disjunctiveMatch0 bool = false
		_ = disjunctiveMatch0
		if _source0.Is_Lt() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Gt() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Le() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Ge() {
			disjunctiveMatch0 = true
		}
		if disjunctiveMatch0 {
			var _0_pieces _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(value, ((b).Dtor_cmp()).Dtor_split())
			_ = _0_pieces
			var _1_valueOrError0 m_Wrappers.Result = ((b).Dtor_cmp()).IsLessThanComparable(_0_pieces)
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _2_canLess bool = (_1_valueOrError0).Extract().(bool)
				_ = _2_canLess
				if _2_canLess {
					return m_Wrappers.Companion_Result_.Create_Success_(true)
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("The operation '"), Companion_Default___.TokenToString(op)), _dafny.SeqOfString("' cannot be used with a compound beacon, unless the value is LessThanComparable : ")), value)))
				}
			}
		}
	}
	{
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	}
}
func (_static *CompanionStruct_Default___) GetStringFromValue(value _dafny.Sequence, values _dafny.Map, b m_SearchableEncryptionInfo.Beacon) m_Wrappers.Result {
	if (values).Contains(value) {
		var _0_val m_ComAmazonawsDynamodbTypes.AttributeValue = (values).Get(value).(m_ComAmazonawsDynamodbTypes.AttributeValue)
		_ = _0_val
		if (_0_val).Is_S() {
			return m_Wrappers.Companion_Result_.Create_Success_((_0_val).Dtor_S())
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Value "), value), _dafny.SeqOfString(" supplied for compound beacon ")), (((b).Dtor_cmp()).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" is of type ")), m_DynamoDbEncryptionUtil.Companion_Default___.AttrTypeToStr(_0_val)), _dafny.SeqOfString(" but must be of type S (string)."))))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Value "), value), _dafny.SeqOfString(" used in query string, but not supplied in value map."))))
	}
}
func (_static *CompanionStruct_Default___) CanBeacon(b m_SearchableEncryptionInfo.Beacon, op Token, value _dafny.Sequence, values _dafny.Map) m_Wrappers.Result {
	if (b).Is_Standard() {
		return Companion_Default___.CanStandardBeacon(op)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetStringFromValue(value, values, b)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_val _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_val
			return Companion_Default___.CanCompoundBeacon(b, op, _1_val)
		}
	}
}
func (_static *CompanionStruct_Default___) RemoveCommonPrefix(x _dafny.Sequence, y _dafny.Sequence) _dafny.Tuple {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (((_dafny.IntOfUint32((x).Cardinality())).Sign() == 0) || ((_dafny.IntOfUint32((y).Cardinality())).Sign() == 0)) || (!_dafny.Companion_Sequence_.Equal((x).Select(0).(_dafny.Sequence), (y).Select(0).(_dafny.Sequence))) {
		return _dafny.TupleOf(x, y)
	} else {
		var _in0 _dafny.Sequence = (x).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = (y).Drop(1)
		_ = _in1
		x = _in0
		y = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) CanBetween(b m_SearchableEncryptionInfo.Beacon, op Token, leftValue _dafny.Sequence, rightValue _dafny.Sequence, values _dafny.Map) m_Wrappers.Result {
	if (b).Is_Standard() {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("The operation BETWEEN cannot be used with a standard beacon.")))
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetStringFromValue(leftValue, values, b)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_leftVal _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_leftVal
			var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.GetStringFromValue(rightValue, values, b)
			_ = _2_valueOrError1
			if (_2_valueOrError1).IsFailure() {
				return (_2_valueOrError1).PropagateFailure()
			} else {
				var _3_rightVal _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
				_ = _3_rightVal
				var _4_leftParts _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(_1_leftVal, ((b).Dtor_cmp()).Dtor_split())
				_ = _4_leftParts
				var _5_rightParts _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(_3_rightVal, ((b).Dtor_cmp()).Dtor_split())
				_ = _5_rightParts
				var _let_tmp_rhs0 _dafny.Tuple = Companion_Default___.RemoveCommonPrefix(_4_leftParts, _5_rightParts)
				_ = _let_tmp_rhs0
				var _6_newLeft _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Sequence)
				_ = _6_newLeft
				var _7_newRight _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Sequence)
				_ = _7_newRight
				var _8_valueOrError2 m_Wrappers.Result = ((b).Dtor_cmp()).IsLessThanComparable(_6_newLeft)
				_ = _8_valueOrError2
				if (_8_valueOrError2).IsFailure() {
					return (_8_valueOrError2).PropagateFailure()
				} else {
					var _9_leftCanLess bool = (_8_valueOrError2).Extract().(bool)
					_ = _9_leftCanLess
					var _10_valueOrError3 m_Wrappers.Result = ((b).Dtor_cmp()).IsLessThanComparable(_7_newRight)
					_ = _10_valueOrError3
					if (_10_valueOrError3).IsFailure() {
						return (_10_valueOrError3).PropagateFailure()
					} else {
						var _11_rightCanLess bool = (_10_valueOrError3).Extract().(bool)
						_ = _11_rightCanLess
						var _12_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_9_leftCanLess) && (_11_rightCanLess), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("To use BETWEEN with a compound beacon, the part after any common prefix must be LessThanComparable : "), _dafny.SeqOfString("BETWEEN ")), _1_leftVal), _dafny.SeqOfString(" AND ")), _3_rightVal)))
						_ = _12_valueOrError4
						if (_12_valueOrError4).IsFailure() {
							return (_12_valueOrError4).PropagateFailure()
						} else {
							return m_Wrappers.Companion_Result_.Create_Success_(true)
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) BeaconForValue(b m_SearchableEncryptionInfo.BeaconVersion, expr _dafny.Sequence, pos _dafny.Int, names m_Wrappers.Option, values _dafny.Map) m_Wrappers.Result {
	if ((((pos).Plus(_dafny.IntOfInt64(2))).Cmp(_dafny.IntOfUint32((expr).Cardinality())) < 0) && (Companion_Default___.IsComp((expr).Select(((pos).Plus(_dafny.One)).Uint32()).(Token)))) && (Companion_Default___.HasBeacon(b, (expr).Select(((pos).Plus(_dafny.IntOfInt64(2))).Uint32()).(Token), names)) {
		return Companion_Default___.GetBeacon(b, (expr).Select(((pos).Plus(_dafny.IntOfInt64(2))).Uint32()).(Token), (expr).Select(((pos).Plus(_dafny.One)).Uint32()).(Token), (expr).Select((pos).Uint32()).(Token), names, values)
	} else if (((_dafny.IntOfInt64(2)).Cmp(pos) <= 0) && (Companion_Default___.IsComp((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)))) && (Companion_Default___.HasBeacon(b, (expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token), names)) {
		return Companion_Default___.GetBeacon(b, (expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token), (expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token), (expr).Select((pos).Uint32()).(Token), names, values)
	} else if (((((_dafny.IntOfInt64(4)).Cmp(pos) <= 0) && ((((expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token)).Is_Contains()) || (((expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token)).Is_BeginsWith()))) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(3))).Uint32()).(Token)).Is_Open())) && (Companion_Default___.HasBeacon(b, (expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token), names))) && (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Comma()) {
		return Companion_Default___.GetBeacon(b, (expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token), (expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token), (expr).Select((pos).Uint32()).(Token), names, values)
	} else if ((((((_dafny.IntOfInt64(2)).Cmp(pos) <= 0) && ((pos).Cmp((_dafny.IntOfUint32((expr).Cardinality())).Minus(_dafny.IntOfInt64(2))) < 0)) && ((((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_Contains()) || (((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_BeginsWith()))) && (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Open())) && (Companion_Default___.HasBeacon(b, (expr).Select(((pos).Plus(_dafny.IntOfInt64(2))).Uint32()).(Token), names))) && (((expr).Select(((pos).Plus(_dafny.One)).Uint32()).(Token)).Is_Comma()) {
		return Companion_Default___.GetBeacon(b, (expr).Select(((pos).Plus(_dafny.IntOfInt64(2))).Uint32()).(Token), (expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token), (expr).Select((pos).Uint32()).(Token), names, values)
	} else if (((((_dafny.IntOfInt64(2)).Cmp(pos) <= 0) && ((pos).Cmp((_dafny.IntOfUint32((expr).Cardinality())).Minus(_dafny.IntOfInt64(2))) < 0)) && (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Between())) && (Companion_Default___.HasBeacon(b, (expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token), names))) && (((expr).Select(((pos).Plus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_Value()) {
		return Companion_Default___.GetBetweenBeacon(b, (expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token), (expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token), (expr).Select((pos).Uint32()).(Token), (expr).Select(((pos).Plus(_dafny.IntOfInt64(2))).Uint32()).(Token), names, values)
	} else if (((((_dafny.IntOfInt64(4)).Cmp(pos) <= 0) && (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_And())) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(3))).Uint32()).(Token)).Is_Between())) && (Companion_Default___.HasBeacon(b, (expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token), names))) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_Value()) {
		return Companion_Default___.GetBetweenBeacon(b, (expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token), (expr).Select(((pos).Minus(_dafny.IntOfInt64(3))).Uint32()).(Token), (expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token), (expr).Select((pos).Uint32()).(Token), names, values)
	} else if ((expr).Select((pos).Uint32()).(Token)).Is_Value() {
		var _0_in__pos m_Wrappers.Option = Companion_Default___.GetInPos(expr, pos)
		_ = _0_in__pos
		if (_0_in__pos).Is_None() {
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_EqualityBeacon_.Create_EqualityBeacon_(m_Wrappers.Companion_Option_.Create_None_(), true, false))
		} else if Companion_Default___.HasBeacon(b, (expr).Select((((_0_in__pos).Dtor_value().(_dafny.Int)).Minus(_dafny.One)).Uint32()).(Token), names) {
			return Companion_Default___.GetBeacon(b, (expr).Select((((_0_in__pos).Dtor_value().(_dafny.Int)).Minus(_dafny.One)).Uint32()).(Token), (expr).Select(((_0_in__pos).Dtor_value().(_dafny.Int)).Uint32()).(Token), (expr).Select((pos).Uint32()).(Token), names, values)
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_EqualityBeacon_.Create_EqualityBeacon_(m_Wrappers.Companion_Option_.Create_None_(), true, false))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_EqualityBeacon_.Create_EqualityBeacon_(m_Wrappers.Companion_Option_.Create_None_(), true, false))
	}
}
func (_static *CompanionStruct_Default___) AttrForValue(expr _dafny.Sequence, pos _dafny.Int) m_Wrappers.Option {
	if ((((pos).Plus(_dafny.IntOfInt64(2))).Cmp(_dafny.IntOfUint32((expr).Cardinality())) < 0) && (Companion_Default___.IsComp((expr).Select(((pos).Plus(_dafny.One)).Uint32()).(Token)))) && (((expr).Select(((pos).Plus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_Attr()) {
		return m_Wrappers.Companion_Option_.Create_Some_((expr).Select(((pos).Plus(_dafny.IntOfInt64(2))).Uint32()).(Token))
	} else if (((_dafny.IntOfInt64(2)).Cmp(pos) <= 0) && (Companion_Default___.IsComp((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)))) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_Attr()) {
		return m_Wrappers.Companion_Option_.Create_Some_((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token))
	} else if (((((_dafny.IntOfInt64(4)).Cmp(pos) <= 0) && ((((expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token)).Is_Contains()) || (((expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token)).Is_BeginsWith()))) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(3))).Uint32()).(Token)).Is_Open())) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_Attr())) && (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Comma()) {
		return m_Wrappers.Companion_Option_.Create_Some_((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token))
	} else if (((_dafny.IntOfInt64(2)).Cmp(pos) <= 0) && (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Between())) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)).Is_Attr()) {
		return m_Wrappers.Companion_Option_.Create_Some_((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token))
	} else if ((((_dafny.IntOfInt64(4)).Cmp(pos) <= 0) && (((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_And())) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(3))).Uint32()).(Token)).Is_Between())) && (((expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token)).Is_Attr()) {
		return m_Wrappers.Companion_Option_.Create_Some_((expr).Select(((pos).Minus(_dafny.IntOfInt64(4))).Uint32()).(Token))
	} else {
		var _0_in__pos m_Wrappers.Option = Companion_Default___.GetInPos(expr, pos)
		_ = _0_in__pos
		if (_0_in__pos).Is_None() {
			return m_Wrappers.Companion_Option_.Create_None_()
		} else if ((expr).Select((((_0_in__pos).Dtor_value().(_dafny.Int)).Minus(_dafny.One)).Uint32()).(Token)).Is_Attr() {
			return m_Wrappers.Companion_Option_.Create_Some_((expr).Select((((_0_in__pos).Dtor_value().(_dafny.Int)).Minus(_dafny.One)).Uint32()).(Token))
		} else {
			return m_Wrappers.Companion_Option_.Create_None_()
		}
	}
}
func (_static *CompanionStruct_Default___) OpNeedsBeacon(expr _dafny.Sequence, pos _dafny.Int) bool {
	if (pos).Cmp(_dafny.IntOfInt64(2)) < 0 {
		return true
	} else if !(((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Open()) {
		return true
	} else {
		return Companion_Default___.TokenNeedsBeacon((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token))
	}
}
func (_static *CompanionStruct_Default___) IsAllowedOnBeaconPred(expr _dafny.Sequence, pos _dafny.Int) bool {
	if (pos).Cmp(_dafny.IntOfInt64(2)) < 0 {
		return true
	} else if !(((expr).Select(((pos).Minus(_dafny.One)).Uint32()).(Token)).Is_Open()) {
		return true
	} else if Companion_Default___.TokenAllowsBeacon((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token)) {
		return true
	} else {
		return false
	}
}
func (_static *CompanionStruct_Default___) IsAllowedOnBeacon(expr _dafny.Sequence, pos _dafny.Int, name _dafny.Sequence) m_Wrappers.Result {
	if Companion_Default___.IsAllowedOnBeaconPred(expr, pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Function "), Companion_Default___.TokenToString((expr).Select(((pos).Minus(_dafny.IntOfInt64(2))).Uint32()).(Token))), _dafny.SeqOfString(" cannot be used on encrypted fields, but it is being used with ")), name)))
	}
}
func (_static *CompanionStruct_Default___) TokenNeedsBeacon(t Token) bool {
	return !(((t).Is_AttributeExists()) || ((t).Is_AttributeNotExists()))
}
func (_static *CompanionStruct_Default___) TokenAllowsBeacon(t Token) bool {
	return !(((t).Is_AttributeType()) || ((t).Is_Size()))
}
func (_static *CompanionStruct_Default___) BeaconizeParsedExpr(b m_SearchableEncryptionInfo.BeaconVersion, expr _dafny.Sequence, pos _dafny.Int, oldValues _dafny.Map, names m_Wrappers.Option, keys m_DynamoDbEncryptionUtil.MaybeKeyMap, newValues _dafny.Map, acc _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (pos).Cmp(_dafny.IntOfUint32((expr).Cardinality())) == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_ParsedContext_.Create_ParsedContext_(acc, newValues, names))
	} else if ((expr).Select((pos).Uint32()).(Token)).Is_Attr() {
		var _0_isIndirectName bool = _dafny.Companion_Sequence_.IsPrefixOf(_dafny.SeqOfString("#"), ((expr).Select((pos).Uint32()).(Token)).Dtor_s())
		_ = _0_isIndirectName
		var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((!(_0_isIndirectName)) || (((names).Is_Some()) && (((names).Dtor_value().(_dafny.Map)).Contains(((expr).Select((pos).Uint32()).(Token)).Dtor_s()))), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Name "), ((expr).Select((pos).Uint32()).(Token)).Dtor_s()), _dafny.SeqOfString(" not in ExpressionAttributeNameMap."))))
		_ = _1_valueOrError0
		if (_1_valueOrError0).IsFailure() {
			return (_1_valueOrError0).PropagateFailure()
		} else {
			var _2_oldName _dafny.Sequence = (func() _dafny.Sequence {
				if _0_isIndirectName {
					return ((names).Dtor_value().(_dafny.Map)).Get(((expr).Select((pos).Uint32()).(Token)).Dtor_s()).(_dafny.Sequence)
				}
				return ((expr).Select((pos).Uint32()).(Token)).Dtor_s()
			})()
			_ = _2_oldName
			var _3_exclude bool = ((keys).Is_DontUseKeys()) && (!(Companion_Default___.IsAllowedOnBeaconPred(expr, pos)))
			_ = _3_exclude
			if ((b).IsBeacon(_2_oldName)) && (!(_3_exclude)) {
				var _4_valueOrError1 m_Wrappers.Result = Companion_Default___.IsAllowedOnBeacon(expr, pos, _2_oldName)
				_ = _4_valueOrError1
				if (_4_valueOrError1).IsFailure() {
					return (_4_valueOrError1).PropagateFailure()
				} else {
					var _5___v4 bool = (_4_valueOrError1).Extract().(bool)
					_ = _5___v4
					if Companion_Default___.OpNeedsBeacon(expr, pos) {
						var _6_newName _dafny.Sequence = (((b).Dtor_beacons()).Get(_2_oldName).(m_SearchableEncryptionInfo.Beacon)).GetBeaconName()
						_ = _6_newName
						if _0_isIndirectName {
							var _in0 m_SearchableEncryptionInfo.BeaconVersion = b
							_ = _in0
							var _in1 _dafny.Sequence = expr
							_ = _in1
							var _in2 _dafny.Int = (pos).Plus(_dafny.One)
							_ = _in2
							var _in3 _dafny.Map = oldValues
							_ = _in3
							var _in4 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(((names).Dtor_value().(_dafny.Map)).Update(((expr).Select((pos).Uint32()).(Token)).Dtor_s(), _6_newName))
							_ = _in4
							var _in5 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
							_ = _in5
							var _in6 _dafny.Map = newValues
							_ = _in6
							var _in7 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf((expr).Select((pos).Uint32()).(Token)))
							_ = _in7
							b = _in0
							expr = _in1
							pos = _in2
							oldValues = _in3
							names = _in4
							keys = _in5
							newValues = _in6
							acc = _in7
							goto TAIL_CALL_START
						} else {
							var _in8 m_SearchableEncryptionInfo.BeaconVersion = b
							_ = _in8
							var _in9 _dafny.Sequence = expr
							_ = _in9
							var _in10 _dafny.Int = (pos).Plus(_dafny.One)
							_ = _in10
							var _in11 _dafny.Map = oldValues
							_ = _in11
							var _in12 m_Wrappers.Option = names
							_ = _in12
							var _in13 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
							_ = _in13
							var _in14 _dafny.Map = newValues
							_ = _in14
							var _in15 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(Companion_Token_.Create_Attr_(_6_newName, m_TermLoc.Companion_Default___.TermLocMap(_6_newName))))
							_ = _in15
							b = _in8
							expr = _in9
							pos = _in10
							oldValues = _in11
							names = _in12
							keys = _in13
							newValues = _in14
							acc = _in15
							goto TAIL_CALL_START
						}
					} else {
						var _in16 m_SearchableEncryptionInfo.BeaconVersion = b
						_ = _in16
						var _in17 _dafny.Sequence = expr
						_ = _in17
						var _in18 _dafny.Int = (pos).Plus(_dafny.One)
						_ = _in18
						var _in19 _dafny.Map = oldValues
						_ = _in19
						var _in20 m_Wrappers.Option = names
						_ = _in20
						var _in21 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
						_ = _in21
						var _in22 _dafny.Map = newValues
						_ = _in22
						var _in23 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf((expr).Select((pos).Uint32()).(Token)))
						_ = _in23
						b = _in16
						expr = _in17
						pos = _in18
						oldValues = _in19
						names = _in20
						keys = _in21
						newValues = _in22
						acc = _in23
						goto TAIL_CALL_START
					}
				}
			} else {
				var _in24 m_SearchableEncryptionInfo.BeaconVersion = b
				_ = _in24
				var _in25 _dafny.Sequence = expr
				_ = _in25
				var _in26 _dafny.Int = (pos).Plus(_dafny.One)
				_ = _in26
				var _in27 _dafny.Map = oldValues
				_ = _in27
				var _in28 m_Wrappers.Option = names
				_ = _in28
				var _in29 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
				_ = _in29
				var _in30 _dafny.Map = newValues
				_ = _in30
				var _in31 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf((expr).Select((pos).Uint32()).(Token)))
				_ = _in31
				b = _in24
				expr = _in25
				pos = _in26
				oldValues = _in27
				names = _in28
				keys = _in29
				newValues = _in30
				acc = _in31
				goto TAIL_CALL_START
			}
		}
	} else if ((expr).Select((pos).Uint32()).(Token)).Is_Value() {
		var _7_name _dafny.Sequence = ((expr).Select((pos).Uint32()).(Token)).Dtor_s()
		_ = _7_name
		var _8_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((oldValues).Contains(_7_name), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_7_name, _dafny.SeqOfString(" not found in ExpressionAttributeValueMap"))))
		_ = _8_valueOrError2
		if (_8_valueOrError2).IsFailure() {
			return (_8_valueOrError2).PropagateFailure()
		} else {
			var _9_oldValue m_ComAmazonawsDynamodbTypes.AttributeValue = (oldValues).Get(_7_name).(m_ComAmazonawsDynamodbTypes.AttributeValue)
			_ = _9_oldValue
			var _10_valueOrError3 m_Wrappers.Result = Companion_Default___.BeaconForValue(b, expr, pos, names, oldValues)
			_ = _10_valueOrError3
			if (_10_valueOrError3).IsFailure() {
				return (_10_valueOrError3).PropagateFailure()
			} else {
				var _11_eb EqualityBeacon = (_10_valueOrError3).Extract().(EqualityBeacon)
				_ = _11_eb
				var _12_valueOrError4 m_Wrappers.Result = (func() m_Wrappers.Result {
					if ((_11_eb).Dtor_beacon()).Is_None() {
						return m_Wrappers.Companion_Result_.Create_Success_(_9_oldValue)
					}
					return (((_11_eb).Dtor_beacon()).Dtor_value().(m_SearchableEncryptionInfo.Beacon)).GetBeaconValue(_9_oldValue, keys, (_11_eb).Dtor_forEquality(), (_11_eb).Dtor_forContains())
				})()
				_ = _12_valueOrError4
				if (_12_valueOrError4).IsFailure() {
					return (_12_valueOrError4).PropagateFailure()
				} else {
					var _13_newValue m_ComAmazonawsDynamodbTypes.AttributeValue = (_12_valueOrError4).Extract().(m_ComAmazonawsDynamodbTypes.AttributeValue)
					_ = _13_newValue
					var _14_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((!(newValues).Contains(_7_name)) || (((newValues).Get(_7_name).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_13_newValue)), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_7_name, _dafny.SeqOfString(" used in two different contexts, which is not allowed."))))
					_ = _14_valueOrError5
					if (_14_valueOrError5).IsFailure() {
						return (_14_valueOrError5).PropagateFailure()
					} else {
						var _in32 m_SearchableEncryptionInfo.BeaconVersion = b
						_ = _in32
						var _in33 _dafny.Sequence = expr
						_ = _in33
						var _in34 _dafny.Int = (pos).Plus(_dafny.One)
						_ = _in34
						var _in35 _dafny.Map = oldValues
						_ = _in35
						var _in36 m_Wrappers.Option = names
						_ = _in36
						var _in37 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
						_ = _in37
						var _in38 _dafny.Map = (newValues).Update(_7_name, _13_newValue)
						_ = _in38
						var _in39 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf((expr).Select((pos).Uint32()).(Token)))
						_ = _in39
						b = _in32
						expr = _in33
						pos = _in34
						oldValues = _in35
						names = _in36
						keys = _in37
						newValues = _in38
						acc = _in39
						goto TAIL_CALL_START
					}
				}
			}
		}
	} else {
		var _in40 m_SearchableEncryptionInfo.BeaconVersion = b
		_ = _in40
		var _in41 _dafny.Sequence = expr
		_ = _in41
		var _in42 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in42
		var _in43 _dafny.Map = oldValues
		_ = _in43
		var _in44 m_Wrappers.Option = names
		_ = _in44
		var _in45 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
		_ = _in45
		var _in46 _dafny.Map = newValues
		_ = _in46
		var _in47 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf((expr).Select((pos).Uint32()).(Token)))
		_ = _in47
		b = _in40
		expr = _in41
		pos = _in42
		oldValues = _in43
		names = _in44
		keys = _in45
		newValues = _in46
		acc = _in47
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) ParsedExprToString(t _dafny.Sequence) _dafny.Sequence {
	var _0_x _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer114 func(Token) _dafny.Sequence) func(interface{}) interface{} {
		return func(arg146 interface{}) interface{} {
			return coer114(arg146.(Token))
		}
	}(func(_1_x Token) _dafny.Sequence {
		return Companion_Default___.TokenToString(_1_x)
	}), t)
	_ = _0_x
	if (_dafny.IntOfUint32((_0_x).Cardinality())).Sign() == 0 {
		return _dafny.SeqOfString("")
	} else {
		return m_StandardLibrary.Companion_Default___.Join(_0_x, _dafny.SeqOfString(" "))
	}
}
func (_static *CompanionStruct_Default___) IsUnary(t Token) bool {
	var _source0 Token = t
	_ = _source0
	{
		if _source0.Is_Not() {
			return true
		}
	}
	{
		return false
	}
}
func (_static *CompanionStruct_Default___) IsComp(t Token) bool {
	var _source0 Token = t
	_ = _source0
	{
		var disjunctiveMatch0 bool = false
		_ = disjunctiveMatch0
		if _source0.Is_Eq() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Ne() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Lt() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Gt() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Le() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Ge() {
			disjunctiveMatch0 = true
		}
		if disjunctiveMatch0 {
			return true
		}
	}
	{
		return false
	}
}
func (_static *CompanionStruct_Default___) IsBinaryBool(t Token) bool {
	var _source0 Token = t
	_ = _source0
	{
		var disjunctiveMatch0 bool = false
		_ = disjunctiveMatch0
		if _source0.Is_And() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Or() {
			disjunctiveMatch0 = true
		}
		if disjunctiveMatch0 {
			return true
		}
	}
	{
		return false
	}
}
func (_static *CompanionStruct_Default___) IsBinary(t Token) bool {
	return (Companion_Default___.IsComp(t)) || (Companion_Default___.IsBinaryBool(t))
}
func (_static *CompanionStruct_Default___) IsVar(t Token) bool {
	var _source0 Token = t
	_ = _source0
	{
		if _source0.Is_Value() {
			var _0_s _dafny.Sequence = _source0.Get_().(Token_Value).S
			_ = _0_s
			return true
		}
	}
	{
		if _source0.Is_Attr() {
			var _1_s _dafny.Sequence = _source0.Get_().(Token_Attr).S
			_ = _1_s
			var _2_loc _dafny.Sequence = _source0.Get_().(Token_Attr).Loc
			_ = _2_loc
			return true
		}
	}
	{
		return false
	}
}
func (_static *CompanionStruct_Default___) IsFunction(t Token) bool {
	var _source0 Token = t
	_ = _source0
	{
		var disjunctiveMatch0 bool = false
		_ = disjunctiveMatch0
		if _source0.Is_Between() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_In() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_AttributeExists() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_AttributeNotExists() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_AttributeType() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_BeginsWith() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Contains() {
			disjunctiveMatch0 = true
		}
		if _source0.Is_Size() {
			disjunctiveMatch0 = true
		}
		if disjunctiveMatch0 {
			return true
		}
	}
	{
		return false
	}
}
func (_static *CompanionStruct_Default___) Precedence(t Token) _dafny.Int {
	var _source0 Token = t
	_ = _source0
	{
		if _source0.Is_Open() {
			return _dafny.IntOfInt64(11)
		}
	}
	{
		if _source0.Is_Close() {
			return _dafny.IntOfInt64(11)
		}
	}
	{
		if _source0.Is_Comma() {
			return _dafny.IntOfInt64(11)
		}
	}
	{
		if _source0.Is_Attr() {
			var _0_s _dafny.Sequence = _source0.Get_().(Token_Attr).S
			_ = _0_s
			var _1_loc _dafny.Sequence = _source0.Get_().(Token_Attr).Loc
			_ = _1_loc
			return _dafny.IntOfInt64(10)
		}
	}
	{
		if _source0.Is_Value() {
			var _2_s _dafny.Sequence = _source0.Get_().(Token_Value).S
			_ = _2_s
			return _dafny.IntOfInt64(10)
		}
	}
	{
		if _source0.Is_Eq() {
			return _dafny.IntOfInt64(9)
		}
	}
	{
		if _source0.Is_Ne() {
			return _dafny.IntOfInt64(9)
		}
	}
	{
		if _source0.Is_Lt() {
			return _dafny.IntOfInt64(9)
		}
	}
	{
		if _source0.Is_Gt() {
			return _dafny.IntOfInt64(9)
		}
	}
	{
		if _source0.Is_Le() {
			return _dafny.IntOfInt64(9)
		}
	}
	{
		if _source0.Is_Ge() {
			return _dafny.IntOfInt64(9)
		}
	}
	{
		if _source0.Is_In() {
			return _dafny.IntOfInt64(8)
		}
	}
	{
		if _source0.Is_Between() {
			return _dafny.IntOfInt64(7)
		}
	}
	{
		if _source0.Is_AttributeExists() {
			return _dafny.IntOfInt64(6)
		}
	}
	{
		if _source0.Is_AttributeNotExists() {
			return _dafny.IntOfInt64(6)
		}
	}
	{
		if _source0.Is_AttributeType() {
			return _dafny.IntOfInt64(6)
		}
	}
	{
		if _source0.Is_BeginsWith() {
			return _dafny.IntOfInt64(6)
		}
	}
	{
		if _source0.Is_Contains() {
			return _dafny.IntOfInt64(6)
		}
	}
	{
		if _source0.Is_Size() {
			return _dafny.IntOfInt64(6)
		}
	}
	{
		if _source0.Is_Not() {
			return _dafny.IntOfInt64(5)
		}
	}
	{
		if _source0.Is_And() {
			return _dafny.IntOfInt64(4)
		}
	}
	{
		return _dafny.IntOfInt64(3)
	}
}
func (_static *CompanionStruct_Default___) ParseExpr(s _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	var _1_tup _dafny.Tuple = Companion_Default___.FindIndexToken(s)
	_ = _1_tup
	if ((*(_1_tup).IndexInt(0)).(_dafny.Int)).Sign() == 1 {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf((*(_1_tup).IndexInt(1)).(Token)))
		var _in0 _dafny.Sequence = (s).Drop(((*(_1_tup).IndexInt(0)).(_dafny.Int)).Uint32())
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	} else {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	}
}
func (_static *CompanionStruct_Default___) ByteLower(ch uint8) uint8 {
	if ((uint8(_dafny.Char('A'))) <= (ch)) && ((ch) <= (uint8(_dafny.Char('Z')))) {
		return ((ch) - (func() uint8 { return (uint8(_dafny.Char('A'))) })()) + (uint8(_dafny.Char('a')))
	} else {
		return ch
	}
}
func (_static *CompanionStruct_Default___) CharLower(ch _dafny.Char) _dafny.Char {
	if ((_dafny.Char('A')) <= (ch)) && ((ch) <= (_dafny.Char('Z'))) {
		return ((ch) - (_dafny.Char('A'))) + (_dafny.Char('a'))
	} else {
		return ch
	}
}
func (_static *CompanionStruct_Default___) StrLower(s _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, s)
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfChars(Companion_Default___.CharLower((s).Select(0).(_dafny.Char))))
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) PrefixLower(pre _dafny.Sequence, s _dafny.Sequence) bool {
	return _dafny.Companion_Sequence_.IsPrefixOf(Companion_Default___.StrLower(pre), Companion_Default___.StrLower(s))
}
func (_static *CompanionStruct_Default___) ValueChar(ch _dafny.Char) bool {
	if ((_dafny.Char('a')) <= (ch)) && ((ch) <= (_dafny.Char('z'))) {
		return true
	} else if ((_dafny.Char('A')) <= (ch)) && ((ch) <= (_dafny.Char('Z'))) {
		return true
	} else if ((_dafny.Char('0')) <= (ch)) && ((ch) <= (_dafny.Char('9'))) {
		return true
	} else if (ch) == (_dafny.Char('_')) {
		return true
	} else {
		return false
	}
}
func (_static *CompanionStruct_Default___) AttributeChar(ch _dafny.Char) bool {
	if Companion_Default___.ValueChar(ch) {
		return true
	} else if _dafny.Companion_Sequence_.Contains(_dafny.SeqOfChars(_dafny.Char(':'), _dafny.Char('['), _dafny.Char(']'), _dafny.Char('.'), _dafny.Char('#')), ch) {
		return true
	} else {
		return false
	}
}
func (_static *CompanionStruct_Default___) ValueLen(s _dafny.Sequence) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else if Companion_Default___.ValueChar((s).Select(0).(_dafny.Char)) {
		_0___accumulator = (_dafny.One).Plus(_0___accumulator)
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	} else {
		return (_dafny.Zero).Plus(_0___accumulator)
	}
}
func (_static *CompanionStruct_Default___) AttributeLen(s _dafny.Sequence) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else if Companion_Default___.AttributeChar((s).Select(0).(_dafny.Char)) {
		_0___accumulator = (_dafny.One).Plus(_0___accumulator)
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	} else {
		return (_dafny.Zero).Plus(_0___accumulator)
	}
}
func (_static *CompanionStruct_Default___) MakeAttr(s _dafny.Sequence) Token {
	var _0_loc m_Wrappers.Result = m_TermLoc.Companion_Default___.MakeTermLoc(s)
	_ = _0_loc
	if (_0_loc).Is_Success() {
		return Companion_Token_.Create_Attr_(s, (_0_loc).Dtor_value().(_dafny.Sequence))
	} else {
		return Companion_Token_.Create_Attr_(s, m_TermLoc.Companion_Default___.TermLocMap(s))
	}
}
func (_static *CompanionStruct_Default___) FindIndexToken(s _dafny.Sequence) _dafny.Tuple {
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return _dafny.TupleOf(_dafny.Zero, Companion_Token_.Create_Close_())
	} else {
		var _0_ch _dafny.Char = (s).Select(0).(_dafny.Char)
		_ = _0_ch
		if (_0_ch) == (_dafny.Char(' ')) {
			var _1_foo _dafny.Tuple = Companion_Default___.FindIndexToken((s).Drop(1))
			_ = _1_foo
			if ((*(_1_foo).IndexInt(0)).(_dafny.Int)).Sign() == 0 {
				return _dafny.TupleOf((*(_1_foo).IndexInt(0)).(_dafny.Int), (*(_1_foo).IndexInt(1)).(Token))
			} else {
				return _dafny.TupleOf(((*(_1_foo).IndexInt(0)).(_dafny.Int)).Plus(_dafny.One), (*(_1_foo).IndexInt(1)).(Token))
			}
		} else if (_0_ch) == (_dafny.Char('(')) {
			return _dafny.TupleOf(_dafny.One, Companion_Token_.Create_Open_())
		} else if (_0_ch) == (_dafny.Char(')')) {
			return _dafny.TupleOf(_dafny.One, Companion_Token_.Create_Close_())
		} else if (_0_ch) == (_dafny.Char(',')) {
			return _dafny.TupleOf(_dafny.One, Companion_Token_.Create_Comma_())
		} else if (_0_ch) == (_dafny.Char('=')) {
			return _dafny.TupleOf(_dafny.One, Companion_Token_.Create_Eq_())
		} else if (_0_ch) == (_dafny.Char('<')) {
			if _dafny.Companion_Sequence_.IsPrefixOf(_dafny.SeqOfString("<="), s) {
				return _dafny.TupleOf(_dafny.IntOfInt64(2), Companion_Token_.Create_Le_())
			} else if _dafny.Companion_Sequence_.IsPrefixOf(_dafny.SeqOfString("<>"), s) {
				return _dafny.TupleOf(_dafny.IntOfInt64(2), Companion_Token_.Create_Ne_())
			} else {
				return _dafny.TupleOf(_dafny.One, Companion_Token_.Create_Lt_())
			}
		} else if (_0_ch) == (_dafny.Char('>')) {
			if _dafny.Companion_Sequence_.IsPrefixOf(_dafny.SeqOfString(">="), s) {
				return _dafny.TupleOf(_dafny.IntOfInt64(2), Companion_Token_.Create_Ge_())
			} else {
				return _dafny.TupleOf(_dafny.One, Companion_Token_.Create_Gt_())
			}
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("in"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(2), Companion_Token_.Create_In_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("between"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(7), Companion_Token_.Create_Between_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("and"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(3), Companion_Token_.Create_And_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("or"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(2), Companion_Token_.Create_Or_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("not"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(3), Companion_Token_.Create_Not_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("attribute_not_exists"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(20), Companion_Token_.Create_AttributeNotExists_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("attribute_type"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(14), Companion_Token_.Create_AttributeType_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("begins_with"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(11), Companion_Token_.Create_BeginsWith_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("attribute_exists"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(16), Companion_Token_.Create_AttributeExists_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("contains"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(8), Companion_Token_.Create_Contains_())
		} else if Companion_Default___.PrefixLower(_dafny.SeqOfString("size"), s) {
			return _dafny.TupleOf(_dafny.IntOfInt64(4), Companion_Token_.Create_Size_())
		} else if (_0_ch) == (_dafny.Char(':')) {
			var _2_x _dafny.Int = (Companion_Default___.ValueLen((s).Drop(1))).Plus(_dafny.One)
			_ = _2_x
			return _dafny.TupleOf(_2_x, Companion_Token_.Create_Value_((s).Subsequence(0, (_2_x).Uint32())))
		} else if (_0_ch) == (_dafny.Char('#')) {
			var _3_x _dafny.Int = (Companion_Default___.ValueLen((s).Drop(1))).Plus(_dafny.One)
			_ = _3_x
			return _dafny.TupleOf(_3_x, Companion_Default___.MakeAttr((s).Subsequence(0, (_3_x).Uint32())))
		} else {
			var _4_x _dafny.Int = Companion_Default___.AttributeLen(s)
			_ = _4_x
			return _dafny.TupleOf(_4_x, Companion_Default___.MakeAttr((s).Subsequence(0, (_4_x).Uint32())))
		}
	}
}
func (_static *CompanionStruct_Default___) VarOrSize(input _dafny.Sequence) _dafny.Int {
	if (_dafny.IntOfUint32((input).Cardinality())).Sign() == 0 {
		return _dafny.Zero
	} else if (((input).Select(0).(Token)).Is_Value()) || (((input).Select(0).(Token)).Is_Attr()) {
		return _dafny.One
	} else if (((((_dafny.IntOfInt64(3)).Cmp(_dafny.IntOfUint32((input).Cardinality())) < 0) && (((input).Select(0).(Token)).Is_Size())) && (((input).Select(1).(Token)).Is_Open())) && (Companion_Default___.IsVar((input).Select(2).(Token)))) && (((input).Select(3).(Token)).Is_Close()) {
		return _dafny.IntOfInt64(4)
	} else {
		return _dafny.Zero
	}
}
func (_static *CompanionStruct_Default___) IsBetween(input _dafny.Sequence) m_Wrappers.Option {
	if (_dafny.IntOfUint32((input).Cardinality())).Cmp(_dafny.IntOfInt64(5)) < 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _0_p1 _dafny.Int = Companion_Default___.VarOrSize(input)
		_ = _0_p1
		if (((_0_p1).Sign() == 1) && (((_0_p1).Plus(_dafny.One)).Cmp(_dafny.IntOfUint32((input).Cardinality())) < 0)) && (((input).Select((_0_p1).Uint32()).(Token)).Is_Between()) {
			var _1_p2 _dafny.Int = Companion_Default___.VarOrSize((input).Drop(((_0_p1).Plus(_dafny.One)).Uint32()))
			_ = _1_p2
			if (((_1_p2).Sign() == 1) && ((((_0_p1).Plus(_1_p2)).Plus(_dafny.IntOfInt64(2))).Cmp(_dafny.IntOfUint32((input).Cardinality())) < 0)) && (((input).Select((((_0_p1).Plus(_1_p2)).Plus(_dafny.One)).Uint32()).(Token)).Is_And()) {
				var _2_p3 _dafny.Int = Companion_Default___.VarOrSize((input).Drop((((_0_p1).Plus(_1_p2)).Plus(_dafny.IntOfInt64(2))).Uint32()))
				_ = _2_p3
				if (_2_p3).Sign() == 1 {
					return m_Wrappers.Companion_Option_.Create_Some_(_dafny.TupleOf(_0_p1, _1_p2, _2_p3))
				} else {
					return m_Wrappers.Companion_Option_.Create_None_()
				}
			} else {
				return m_Wrappers.Companion_Option_.Create_None_()
			}
		} else {
			return m_Wrappers.Companion_Option_.Create_None_()
		}
	}
}
func (_static *CompanionStruct_Default___) IsIN(input _dafny.Sequence) bool {
	if (_dafny.IntOfUint32((input).Cardinality())).Cmp(_dafny.IntOfInt64(3)) < 0 {
		return false
	} else if !(Companion_Default___.IsVar((input).Select(0).(Token))) {
		return false
	} else if !((input).Select(1).(Token)).Equals(Companion_Token_.Create_In_()) {
		return false
	} else if !((input).Select(2).(Token)).Equals(Companion_Token_.Create_Open_()) {
		return false
	} else {
		return true
	}
}
func (_static *CompanionStruct_Default___) ConvertToPrefix(input _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	var _1_between m_Wrappers.Option = Companion_Default___.IsBetween(input)
	_ = _1_between
	if (_dafny.IntOfUint32((input).Cardinality())).Cmp(_dafny.IntOfInt64(5)) < 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, input)
	} else if Companion_Default___.IsIN(input) {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf((input).Select(1).(Token), (input).Select(2).(Token), (input).Select(0).(Token), Companion_Token_.Create_Comma_()))
		var _in0 _dafny.Sequence = (input).Drop(3)
		_ = _in0
		input = _in0
		goto TAIL_CALL_START
	} else if (_1_between).Is_Some() {
		var _2_b _dafny.Tuple = (_1_between).Dtor_value().(_dafny.Tuple)
		_ = _2_b
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(Companion_Token_.Create_Between_(), Companion_Token_.Create_Open_()), (input).Subsequence(0, ((*(_2_b).IndexInt(0)).(_dafny.Int)).Uint32())), _dafny.SeqOf(Companion_Token_.Create_Comma_())), (input).Subsequence((((*(_2_b).IndexInt(0)).(_dafny.Int)).Plus(_dafny.One)).Uint32(), ((((*(_2_b).IndexInt(0)).(_dafny.Int)).Plus((*(_2_b).IndexInt(1)).(_dafny.Int))).Plus(_dafny.One)).Uint32())), _dafny.SeqOf(Companion_Token_.Create_Comma_())), (input).Subsequence(((((*(_2_b).IndexInt(0)).(_dafny.Int)).Plus((*(_2_b).IndexInt(1)).(_dafny.Int))).Plus(_dafny.IntOfInt64(2))).Uint32(), (((((*(_2_b).IndexInt(0)).(_dafny.Int)).Plus((*(_2_b).IndexInt(1)).(_dafny.Int))).Plus((*(_2_b).IndexInt(2)).(_dafny.Int))).Plus(_dafny.IntOfInt64(2))).Uint32())), _dafny.SeqOf(Companion_Token_.Create_Close_())))
		var _in1 _dafny.Sequence = (input).Drop((((((*(_2_b).IndexInt(0)).(_dafny.Int)).Plus((*(_2_b).IndexInt(1)).(_dafny.Int))).Plus((*(_2_b).IndexInt(2)).(_dafny.Int))).Plus(_dafny.IntOfInt64(2))).Uint32())
		_ = _in1
		input = _in1
		goto TAIL_CALL_START
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf((input).Select(0).(Token)))
		var _in2 _dafny.Sequence = (input).Drop(1)
		_ = _in2
		input = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) ConvertToRpn(input _dafny.Sequence) _dafny.Sequence {
	var _0_stack _dafny.Sequence = _dafny.SeqOf()
	_ = _0_stack
	return Companion_Default___.ConvertToRpn__inner(input, _0_stack)
}
func (_static *CompanionStruct_Default___) ConvertToRpn__inner(input _dafny.Sequence, stack _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((input).Cardinality())).Sign() == 0 {
		if (_dafny.IntOfUint32((stack).Cardinality())).Sign() == 0 {
			return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
		} else {
			_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(Token)))
			var _in0 _dafny.Sequence = input
			_ = _in0
			var _in1 _dafny.Sequence = (stack).Take(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32())
			_ = _in1
			input = _in0
			stack = _in1
			goto TAIL_CALL_START
		}
	} else {
		var _source0 Token = (input).Select(0).(Token)
		_ = _source0
		{
			if _source0.Is_Attr() {
				var _1_s _dafny.Sequence = _source0.Get_().(Token_Attr).S
				_ = _1_s
				var _2_loc _dafny.Sequence = _source0.Get_().(Token_Attr).Loc
				_ = _2_loc
				return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf((input).Select(0).(Token)), Companion_Default___.ConvertToRpn__inner((input).Drop(1), stack))
			}
		}
		{
			if _source0.Is_Value() {
				var _3_s _dafny.Sequence = _source0.Get_().(Token_Value).S
				_ = _3_s
				return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf((input).Select(0).(Token)), Companion_Default___.ConvertToRpn__inner((input).Drop(1), stack))
			}
		}
		{
			var disjunctiveMatch0 bool = false
			_ = disjunctiveMatch0
			if _source0.Is_Between() {
				disjunctiveMatch0 = true
			}
			if _source0.Is_In() {
				disjunctiveMatch0 = true
			}
			if _source0.Is_Not() {
				disjunctiveMatch0 = true
			}
			if _source0.Is_AttributeExists() {
				disjunctiveMatch0 = true
			}
			if _source0.Is_AttributeNotExists() {
				disjunctiveMatch0 = true
			}
			if _source0.Is_AttributeType() {
				disjunctiveMatch0 = true
			}
			if _source0.Is_BeginsWith() {
				disjunctiveMatch0 = true
			}
			if _source0.Is_Contains() {
				disjunctiveMatch0 = true
			}
			if _source0.Is_Size() {
				disjunctiveMatch0 = true
			}
			if disjunctiveMatch0 {
				var _in2 _dafny.Sequence = (input).Drop(1)
				_ = _in2
				var _in3 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(stack, _dafny.SeqOf((input).Select(0).(Token)))
				_ = _in3
				input = _in2
				stack = _in3
				goto TAIL_CALL_START
			}
		}
		{
			if _source0.Is_Comma() {
				if (_dafny.IntOfUint32((stack).Cardinality())).Sign() == 1 {
					if Companion_Default___.IsFunction((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(Token)) {
						var _in4 _dafny.Sequence = (input).Drop(1)
						_ = _in4
						var _in5 _dafny.Sequence = stack
						_ = _in5
						input = _in4
						stack = _in5
						goto TAIL_CALL_START
					} else {
						return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(Token)), Companion_Default___.ConvertToRpn__inner((input).Drop(1), (stack).Take(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32())))
					}
				} else {
					var _in6 _dafny.Sequence = (input).Drop(1)
					_ = _in6
					var _in7 _dafny.Sequence = stack
					_ = _in7
					input = _in6
					stack = _in7
					goto TAIL_CALL_START
				}
			}
		}
		{
			if _source0.Is_Close() {
				if (_dafny.IntOfUint32((stack).Cardinality())).Sign() == 0 {
					var _in8 _dafny.Sequence = (input).Drop(1)
					_ = _in8
					var _in9 _dafny.Sequence = stack
					_ = _in9
					input = _in8
					stack = _in9
					goto TAIL_CALL_START
				} else if ((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(Token)).Equals(Companion_Token_.Create_Open_()) {
					var _in10 _dafny.Sequence = (input).Drop(1)
					_ = _in10
					var _in11 _dafny.Sequence = (stack).Take(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32())
					_ = _in11
					input = _in10
					stack = _in11
					goto TAIL_CALL_START
				} else {
					return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(Token)), Companion_Default___.ConvertToRpn__inner((input).Drop(1), (stack).Take(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32())))
				}
			}
		}
		{
			var disjunctiveMatch1 bool = false
			_ = disjunctiveMatch1
			if _source0.Is_Eq() {
				disjunctiveMatch1 = true
			}
			if _source0.Is_Ne() {
				disjunctiveMatch1 = true
			}
			if _source0.Is_Lt() {
				disjunctiveMatch1 = true
			}
			if _source0.Is_Gt() {
				disjunctiveMatch1 = true
			}
			if _source0.Is_Le() {
				disjunctiveMatch1 = true
			}
			if _source0.Is_Ge() {
				disjunctiveMatch1 = true
			}
			if _source0.Is_And() {
				disjunctiveMatch1 = true
			}
			if _source0.Is_Or() {
				disjunctiveMatch1 = true
			}
			if disjunctiveMatch1 {
				if (_dafny.IntOfUint32((stack).Cardinality())).Sign() == 0 {
					var _in12 _dafny.Sequence = (input).Drop(1)
					_ = _in12
					var _in13 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(stack, _dafny.SeqOf((input).Select(0).(Token)))
					_ = _in13
					input = _in12
					stack = _in13
					goto TAIL_CALL_START
				} else if (Companion_Default___.Precedence((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(Token))).Cmp(Companion_Default___.Precedence((input).Select(0).(Token))) >= 0 {
					return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(Token)), Companion_Default___.ConvertToRpn__inner(input, (stack).Take(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32())))
				} else {
					var _in14 _dafny.Sequence = (input).Drop(1)
					_ = _in14
					var _in15 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(stack, _dafny.SeqOf((input).Select(0).(Token)))
					_ = _in15
					input = _in14
					stack = _in15
					goto TAIL_CALL_START
				}
			}
		}
		{
			var _in16 _dafny.Sequence = (input).Drop(1)
			_ = _in16
			var _in17 _dafny.Sequence = stack
			_ = _in17
			input = _in16
			stack = _in17
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) GetSize(value m_ComAmazonawsDynamodbTypes.AttributeValue) _dafny.Int {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = value
	_ = _source0
	{
		if _source0.Is_S() {
			var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
			_ = _0_s
			return _dafny.IntOfUint32((_0_s).Cardinality())
		}
	}
	{
		if _source0.Is_N() {
			var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _1_n
			return _dafny.IntOfUint32((_1_n).Cardinality())
		}
	}
	{
		if _source0.Is_B() {
			var _2_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
			_ = _2_n
			return _dafny.IntOfUint32((_2_n).Cardinality())
		}
	}
	{
		if _source0.Is_SS() {
			var _3_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
			_ = _3_n
			return _dafny.IntOfUint32((_3_n).Cardinality())
		}
	}
	{
		if _source0.Is_NS() {
			var _4_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
			_ = _4_n
			return _dafny.IntOfUint32((_4_n).Cardinality())
		}
	}
	{
		if _source0.Is_BS() {
			var _5_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
			_ = _5_n
			return _dafny.IntOfUint32((_5_n).Cardinality())
		}
	}
	{
		if _source0.Is_M() {
			var _6_n _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
			_ = _6_n
			return (_6_n).Cardinality()
		}
	}
	{
		if _source0.Is_L() {
			var _7_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
			_ = _7_n
			return _dafny.IntOfUint32((_7_n).Cardinality())
		}
	}
	{
		if _source0.Is_NULL() {
			var _8_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
			_ = _8_n
			return _dafny.One
		}
	}
	{
		var _9_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
		_ = _9_n
		return _dafny.One
	}
}
func (_static *CompanionStruct_Default___) GetStr(s StackValue) m_ComAmazonawsDynamodbTypes.AttributeValue {
	var _source0 StackValue = s
	_ = _source0
	{
		if _source0.Is_Bool() {
			var _0_b bool = _source0.Get_().(StackValue_Bool).B
			_ = _0_b
			return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)
		}
	}
	{
		if _source0.Is_Str() {
			var _1_s m_ComAmazonawsDynamodbTypes.AttributeValue = _source0.Get_().(StackValue_Str).S
			_ = _1_s
			return _1_s
		}
	}
	{
		return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)
	}
}
func (_static *CompanionStruct_Default___) AsStr(s _dafny.Sequence) StackValue {
	return Companion_StackValue_.Create_Str_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(s))
}
func (_static *CompanionStruct_Default___) StackValueFromValue(s _dafny.Sequence, values _dafny.Map) StackValue {
	if (values).Contains(s) {
		return Companion_StackValue_.Create_Str_((values).Get(s).(m_ComAmazonawsDynamodbTypes.AttributeValue))
	} else {
		return Companion_StackValue_.Create_DoesNotExist_()
	}
}
func (_static *CompanionStruct_Default___) StackValueFromItem(s _dafny.Sequence, item _dafny.Map) StackValue {
	if (item).Contains(s) {
		return Companion_StackValue_.Create_Str_((item).Get(s).(m_ComAmazonawsDynamodbTypes.AttributeValue))
	} else {
		return Companion_StackValue_.Create_DoesNotExist_()
	}
}
func (_static *CompanionStruct_Default___) StackValueFromAttr(t Token, item _dafny.Map, names m_Wrappers.Option) StackValue {
	if ((names).Is_Some()) && (((names).Dtor_value().(_dafny.Map)).Contains((t).Dtor_s())) {
		return Companion_Default___.StackValueFromItem(((names).Dtor_value().(_dafny.Map)).Get((t).Dtor_s()).(_dafny.Sequence), item)
	} else {
		var _0_attr m_Wrappers.Option = m_TermLoc.Companion_Default___.TermToAttr((t).Dtor_loc(), item, names)
		_ = _0_attr
		if (_0_attr).Is_Some() {
			return Companion_StackValue_.Create_Str_((_0_attr).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue))
		} else {
			return Companion_StackValue_.Create_DoesNotExist_()
		}
	}
}
func (_static *CompanionStruct_Default___) GetParsedExpr(input _dafny.Sequence) m_Wrappers.Result {
	var _0_seq1 _dafny.Sequence = Companion_Default___.ParseExpr(input)
	_ = _0_seq1
	var _1_seq2 _dafny.Sequence = Companion_Default___.ConvertToPrefix(_0_seq1)
	_ = _1_seq2
	return m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.ConvertToRpn(_1_seq2))
}
func (_static *CompanionStruct_Default___) EvalExpr(input _dafny.Sequence, item _dafny.Map, names m_Wrappers.Option, values _dafny.Map) m_Wrappers.Result {
	return Companion_Default___.InnerEvalExpr(input, _dafny.SeqOf(), item, names, values)
}
func (_static *CompanionStruct_Default___) StringsFollowing(input _dafny.Sequence) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((input).Cardinality())).Sign() == 0 {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else if !(((input).Select(((_dafny.IntOfUint32((input).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Is_Str()) {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else {
		_0___accumulator = (_0___accumulator).Plus(_dafny.One)
		var _in0 _dafny.Sequence = (input).Take(((_dafny.IntOfUint32((input).Cardinality())).Minus(_dafny.One)).Uint32())
		_ = _in0
		input = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Seq__contains(haystack _dafny.Sequence, needle _dafny.Sequence) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((needle).Cardinality())).Sign() == 0 {
		return true
	} else if (_dafny.IntOfUint32((haystack).Cardinality())).Sign() == 0 {
		return false
	} else if (_dafny.IntOfUint32((haystack).Cardinality())).Cmp(_dafny.IntOfUint32((needle).Cardinality())) < 0 {
		return false
	} else if (_dafny.AreEqual((needle).Select(0).(interface{}), (haystack).Select(0).(interface{}))) && (_dafny.Companion_Sequence_.IsPrefixOf((needle).Drop(1), (haystack).Drop(1))) {
		return true
	} else {
		var _in0 _dafny.Sequence = (haystack).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = needle
		_ = _in1
		haystack = _in0
		needle = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Does__contain(haystack m_ComAmazonawsDynamodbTypes.AttributeValue, needle m_ComAmazonawsDynamodbTypes.AttributeValue) bool {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = haystack
	_ = _source0
	{
		if _source0.Is_S() {
			var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
			_ = _0_s
			if (needle).Is_S() {
				return Companion_Default___.Seq__contains((haystack).Dtor_S(), (needle).Dtor_S())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_N() {
			var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _1_n
			if (needle).Is_N() {
				return Companion_Default___.Seq__contains((haystack).Dtor_N(), (needle).Dtor_N())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_B() {
			var _2_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
			_ = _2_n
			if (needle).Is_B() {
				return Companion_Default___.Seq__contains((haystack).Dtor_B(), (needle).Dtor_B())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_SS() {
			var _3_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
			_ = _3_s
			if (needle).Is_S() {
				return _dafny.Companion_Sequence_.Contains((haystack).Dtor_SS(), (needle).Dtor_S())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_NS() {
			var _4_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
			_ = _4_s
			if (needle).Is_N() {
				return _dafny.Companion_Sequence_.Contains((haystack).Dtor_NS(), (needle).Dtor_N())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_BS() {
			var _5_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
			_ = _5_s
			if (needle).Is_B() {
				return _dafny.Companion_Sequence_.Contains((haystack).Dtor_BS(), (needle).Dtor_B())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_L() {
			var _6_list _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
			_ = _6_list
			return _dafny.Companion_Sequence_.Contains(_6_list, needle)
		}
	}
	{
		return false
	}
}
func (_static *CompanionStruct_Default___) Begins__with(haystack m_ComAmazonawsDynamodbTypes.AttributeValue, needle m_ComAmazonawsDynamodbTypes.AttributeValue) bool {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = haystack
	_ = _source0
	{
		if _source0.Is_S() {
			var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
			_ = _0_s
			if (needle).Is_S() {
				return _dafny.Companion_Sequence_.IsPrefixOf((needle).Dtor_S(), (haystack).Dtor_S())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_N() {
			var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _1_n
			if (needle).Is_N() {
				return _dafny.Companion_Sequence_.IsPrefixOf((needle).Dtor_N(), (haystack).Dtor_N())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_B() {
			var _2_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
			_ = _2_n
			if (needle).Is_B() {
				return _dafny.Companion_Sequence_.IsPrefixOf((needle).Dtor_B(), (haystack).Dtor_B())
			} else {
				return false
			}
		}
	}
	{
		if _source0.Is_L() {
			var _3_list _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
			_ = _3_list
			if (_dafny.IntOfUint32((_3_list).Cardinality())).Sign() == 0 {
				return false
			} else if ((_3_list).Select(0).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(needle) {
				return true
			} else if (needle).Is_L() {
				return _dafny.Companion_Sequence_.IsPrefixOf((needle).Dtor_L(), _3_list)
			} else {
				return false
			}
		}
	}
	{
		return false
	}
}
func (_static *CompanionStruct_Default___) Is__between(middle m_ComAmazonawsDynamodbTypes.AttributeValue, left m_ComAmazonawsDynamodbTypes.AttributeValue, right m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.AttributeLE(left, middle)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_leftRet bool = (_0_valueOrError0).Extract().(bool)
		_ = _1_leftRet
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.AttributeLE(middle, right)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_rightRet bool = (_2_valueOrError1).Extract().(bool)
			_ = _3_rightRet
			return m_Wrappers.Companion_Result_.Create_Success_((_1_leftRet) && (_3_rightRet))
		}
	}
}
func (_static *CompanionStruct_Default___) Is__in(target m_ComAmazonawsDynamodbTypes.AttributeValue, list _dafny.Sequence) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((list).Cardinality())).Sign() == 0 {
		return false
	} else if (Companion_Default___.GetStr((list).Select(0).(StackValue))).Equals(target) {
		return true
	} else {
		var _in0 m_ComAmazonawsDynamodbTypes.AttributeValue = target
		_ = _in0
		var _in1 _dafny.Sequence = (list).Drop(1)
		_ = _in1
		target = _in0
		list = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) AttrToStr(attr m_ComAmazonawsDynamodbTypes.AttributeValue) _dafny.Sequence {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = attr
	_ = _source0
	{
		if _source0.Is_S() {
			var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
			_ = _0_s
			return _0_s
		}
	}
	{
		if _source0.Is_N() {
			var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _1_n
			return _1_n
		}
	}
	{
		return _dafny.SeqOfString("")
	}
}
func (_static *CompanionStruct_Default___) IsAttrType(attr StackValue, typeStr StackValue) bool {
	return _dafny.Companion_Sequence_.Equal(m_DynamoDbEncryptionUtil.Companion_Default___.AttrTypeToStr(Companion_Default___.GetStr(attr)), Companion_Default___.AttrToStr(Companion_Default___.GetStr(typeStr)))
}
func (_static *CompanionStruct_Default___) Apply__function(input Token, stack _dafny.Sequence, num__args _dafny.Int) m_Wrappers.Result {
	var _source0 Token = input
	_ = _source0
	{
		if _source0.Is_Between() {
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_dafny.IntOfInt64(3)) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("No Stack for Between")))
			} else if ((((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Is_Str()) && (((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()).(StackValue)).Is_Str())) && (((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(3))).Uint32()).(StackValue)).Is_Str()) {
				var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.Is__between(((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(3))).Uint32()).(StackValue)).Dtor_s(), ((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()).(StackValue)).Dtor_s(), ((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Dtor_s())
				_ = _0_valueOrError0
				if (_0_valueOrError0).IsFailure() {
					return (_0_valueOrError0).PropagateFailure()
				} else {
					var _1_ret bool = (_0_valueOrError0).Extract().(bool)
					_ = _1_ret
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(_1_ret))
				}
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Wrong Types for contains")))
			}
		}
	}
	{
		if _source0.Is_In() {
			var _2_num _dafny.Int = Companion_Default___.StringsFollowing(stack)
			_ = _2_num
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_2_num) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Tautology False")))
			} else if (_2_num).Sign() == 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("In has no args")))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(Companion_Default___.Is__in(Companion_Default___.GetStr((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_2_num)).Uint32()).(StackValue)), (stack).Drop((((_dafny.IntOfUint32((stack).Cardinality())).Minus(_2_num)).Plus(_dafny.One)).Uint32()))))
			}
		}
	}
	{
		if _source0.Is_AttributeExists() {
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_dafny.One) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("No Stack for AttributeExists")))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(!(((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Is_DoesNotExist())))
			}
		}
	}
	{
		if _source0.Is_AttributeNotExists() {
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_dafny.One) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("No Stack for AttributeExists")))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Is_DoesNotExist()))
			}
		}
	}
	{
		if _source0.Is_AttributeType() {
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_dafny.IntOfInt64(2)) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("No Stack for AttributeType")))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(Companion_Default___.IsAttrType((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()).(StackValue), (stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue))))
			}
		}
	}
	{
		if _source0.Is_BeginsWith() {
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_dafny.IntOfInt64(2)) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("No Stack for BeginsWith")))
			} else if (((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Is_Str()) && (((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()).(StackValue)).Is_Str()) {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(Companion_Default___.Begins__with(((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()).(StackValue)).Dtor_s(), ((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Dtor_s())))
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Wrong Types for BeginsWith")))
			}
		}
	}
	{
		if _source0.Is_Contains() {
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_dafny.IntOfInt64(2)) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("No Stack for contains")))
			} else if (((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Is_Str()) && (((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()).(StackValue)).Is_Str()) {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(Companion_Default___.Does__contain(((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()).(StackValue)).Dtor_s(), ((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Dtor_s())))
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Wrong Types for contains")))
			}
		}
	}
	{
		if _source0.Is_Size() {
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_dafny.One) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("No Stack for Size")))
			} else if !(((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Is_Str()) {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Wrong Types for Size")))
			} else {
				var _3_n _dafny.Int = Companion_Default___.GetSize(((stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue)).Dtor_s())
				_ = _3_n
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Str_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(m_StandardLibrary_String.Companion_Default___.Base10Int2String(_3_n))))
			}
		}
	}
	{
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(true))
	}
}
func (_static *CompanionStruct_Default___) Apply__unary(input Token, stack StackValue) m_Wrappers.Result {
	if (stack).Is_Bool() {
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(!((stack).Dtor_b())))
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("wrong type for Not")))
	}
}
func (_static *CompanionStruct_Default___) Apply__binary__bool(input Token, x bool, y bool) m_Wrappers.Result {
	var _source0 Token = input
	_ = _source0
	{
		if _source0.Is_And() {
			return m_Wrappers.Companion_Result_.Create_Success_((x) && (y))
		}
	}
	{
		if _source0.Is_Or() {
			return m_Wrappers.Companion_Result_.Create_Success_((x) || (y))
		}
	}
	{
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("invalid op in apply_binary_bool")))
	}
}
func (_static *CompanionStruct_Default___) IsHighSurrogate(ch _dafny.Char) bool {
	return ((_dafny.Char((_dafny.IntOfInt64(55296)).Int32())) <= (ch)) && ((ch) <= (_dafny.Char((_dafny.IntOfInt64(56319)).Int32())))
}
func (_static *CompanionStruct_Default___) UnicodeLess(a _dafny.Sequence, b _dafny.Sequence, pos _dafny.Int) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if ((_dafny.IntOfUint32((a).Cardinality())).Cmp(pos) == 0) && ((_dafny.IntOfUint32((b).Cardinality())).Cmp(pos) == 0) {
		return false
	} else if (_dafny.IntOfUint32((a).Cardinality())).Cmp(pos) == 0 {
		return true
	} else if (_dafny.IntOfUint32((b).Cardinality())).Cmp(pos) == 0 {
		return false
	} else if ((a).Select((pos).Uint32()).(_dafny.Char)) == ((b).Select((pos).Uint32()).(_dafny.Char)) {
		var _in0 _dafny.Sequence = a
		_ = _in0
		var _in1 _dafny.Sequence = b
		_ = _in1
		var _in2 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in2
		a = _in0
		b = _in1
		pos = _in2
		goto TAIL_CALL_START
	} else {
		var _0_aIsHighSurrogate bool = Companion_Default___.IsHighSurrogate((a).Select((pos).Uint32()).(_dafny.Char))
		_ = _0_aIsHighSurrogate
		var _1_bIsHighSurrogate bool = Companion_Default___.IsHighSurrogate((b).Select((pos).Uint32()).(_dafny.Char))
		_ = _1_bIsHighSurrogate
		if (_0_aIsHighSurrogate) == (_1_bIsHighSurrogate) {
			return ((a).Select((pos).Uint32()).(_dafny.Char)) < ((b).Select((pos).Uint32()).(_dafny.Char))
		} else {
			return _1_bIsHighSurrogate
		}
	}
}
func (_static *CompanionStruct_Default___) UnicodeLessOrEqual(a _dafny.Sequence, b _dafny.Sequence) bool {
	return !(Companion_Default___.UnicodeLess(b, a, _dafny.Zero))
}
func (_static *CompanionStruct_Default___) CompareFloat(x _dafny.Sequence, y _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(x)).MapFailure(func(coer115 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg147 interface{}) interface{} {
			return coer115(arg147.(_dafny.Sequence))
		}
	}(func(_1_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_DynamoDbEncryptionUtil.Companion_Default___.E(_1_e)
	}))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _2_newX _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _2_newX
		var _3_valueOrError1 m_Wrappers.Result = (m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(y)).MapFailure(func(coer116 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg148 interface{}) interface{} {
				return coer116(arg148.(_dafny.Sequence))
			}
		}(func(_4_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_DynamoDbEncryptionUtil.Companion_Default___.E(_4_e)
		}))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _5_newY _dafny.Sequence = (_3_valueOrError1).Extract().(_dafny.Sequence)
			_ = _5_newY
			return m_Wrappers.Companion_Result_.Create_Success_(m_FloatCompare.Companion_Default___.CompareFloat(_2_newX, _5_newY))
		}
	}
}
func (_static *CompanionStruct_Default___) AttributeEQ(a m_ComAmazonawsDynamodbTypes.AttributeValue, b m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	if ((a).Is_N()) && ((b).Is_N()) {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.CompareFloat((a).Dtor_N(), (b).Dtor_N())
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_ret int8 = (_0_valueOrError0).Extract().(int8)
			_ = _1_ret
			return m_Wrappers.Companion_Result_.Create_Success_((_1_ret) == (int8(0)))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_((a).Equals(b))
	}
}
func (_static *CompanionStruct_Default___) AttributeNE(a m_ComAmazonawsDynamodbTypes.AttributeValue, b m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.AttributeEQ(a, b)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_ret bool = (_0_valueOrError0).Extract().(bool)
		_ = _1_ret
		return m_Wrappers.Companion_Result_.Create_Success_(!(_1_ret))
	}
}
func (_static *CompanionStruct_Default___) AttributeLE(a m_ComAmazonawsDynamodbTypes.AttributeValue, b m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	if ((a).Is_N()) && ((b).Is_N()) {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.CompareFloat((a).Dtor_N(), (b).Dtor_N())
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_ret int8 = (_0_valueOrError0).Extract().(int8)
			_ = _1_ret
			return m_Wrappers.Companion_Result_.Create_Success_((_1_ret) <= (int8(0)))
		}
	} else if ((a).Is_S()) && ((b).Is_S()) {
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.UnicodeLessOrEqual((a).Dtor_S(), (b).Dtor_S()))
	} else if ((a).Is_B()) && ((b).Is_B()) {
		return m_Wrappers.Companion_Result_.Create_Success_(m_StandardLibrary.Companion_Default___.LexicographicLessOrEqual((a).Dtor_B(), (b).Dtor_B(), func(coer117 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
			return func(arg149 interface{}, arg150 interface{}) bool {
				return coer117(arg149.(uint8), arg150.(uint8))
			}
		}(m_DynamoDbEncryptionUtil.Companion_Default___.ByteLess)))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(false)
	}
}
func (_static *CompanionStruct_Default___) AttributeLT(a m_ComAmazonawsDynamodbTypes.AttributeValue, b m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.AttributeLE(b, a)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_ret bool = (_0_valueOrError0).Extract().(bool)
		_ = _1_ret
		return m_Wrappers.Companion_Result_.Create_Success_(!(_1_ret))
	}
}
func (_static *CompanionStruct_Default___) AttributeGT(a m_ComAmazonawsDynamodbTypes.AttributeValue, b m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.AttributeLE(a, b)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_ret bool = (_0_valueOrError0).Extract().(bool)
		_ = _1_ret
		return m_Wrappers.Companion_Result_.Create_Success_(!(_1_ret))
	}
}
func (_static *CompanionStruct_Default___) AttributeGE(a m_ComAmazonawsDynamodbTypes.AttributeValue, b m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.AttributeLE(b, a)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_ret bool = (_0_valueOrError0).Extract().(bool)
		_ = _1_ret
		return m_Wrappers.Companion_Result_.Create_Success_(_1_ret)
	}
}
func (_static *CompanionStruct_Default___) Apply__binary__comp(input Token, x m_ComAmazonawsDynamodbTypes.AttributeValue, y m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _source0 Token = input
	_ = _source0
	{
		if _source0.Is_Eq() {
			return Companion_Default___.AttributeEQ(x, y)
		}
	}
	{
		if _source0.Is_Ne() {
			return Companion_Default___.AttributeNE(x, y)
		}
	}
	{
		if _source0.Is_Le() {
			return Companion_Default___.AttributeLE(x, y)
		}
	}
	{
		if _source0.Is_Lt() {
			return Companion_Default___.AttributeLT(x, y)
		}
	}
	{
		if _source0.Is_Ge() {
			return Companion_Default___.AttributeGE(x, y)
		}
	}
	{
		if _source0.Is_Gt() {
			return Companion_Default___.AttributeGT(x, y)
		}
	}
	{
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("invalid op in apply_binary_bool")))
	}
}
func (_static *CompanionStruct_Default___) Apply__binary(input Token, x StackValue, y StackValue) m_Wrappers.Result {
	if Companion_Default___.IsComp(input) {
		if ((x).Is_Str()) && ((y).Is_Str()) {
			var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.Apply__binary__comp(input, (x).Dtor_s(), (y).Dtor_s())
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_val bool = (_0_valueOrError0).Extract().(bool)
				_ = _1_val
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(_1_val))
			}
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("wrong types for comparison")))
		}
	} else if ((x).Is_Bool()) && ((y).Is_Bool()) {
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.Apply__binary__bool(input, (x).Dtor_b(), (y).Dtor_b())
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_val bool = (_2_valueOrError1).Extract().(bool)
			_ = _3_val
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_StackValue_.Create_Bool_(_3_val))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("wrong types for boolean binary")))
	}
}
func (_static *CompanionStruct_Default___) NumArgs(t Token, stack _dafny.Sequence) _dafny.Int {
	var _source0 Token = t
	_ = _source0
	{
		if _source0.Is_Between() {
			return _dafny.IntOfInt64(3)
		}
	}
	{
		if _source0.Is_In() {
			return Companion_Default___.StringsFollowing(stack)
		}
	}
	{
		if _source0.Is_AttributeExists() {
			return _dafny.One
		}
	}
	{
		if _source0.Is_AttributeNotExists() {
			return _dafny.One
		}
	}
	{
		if _source0.Is_AttributeType() {
			return _dafny.IntOfInt64(2)
		}
	}
	{
		if _source0.Is_BeginsWith() {
			return _dafny.IntOfInt64(2)
		}
	}
	{
		if _source0.Is_Contains() {
			return _dafny.IntOfInt64(2)
		}
	}
	{
		if _source0.Is_Size() {
			return _dafny.One
		}
	}
	{
		return _dafny.Zero
	}
}
func (_static *CompanionStruct_Default___) InnerEvalExpr(input _dafny.Sequence, stack _dafny.Sequence, item _dafny.Map, names m_Wrappers.Option, values _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((input).Cardinality())).Sign() == 0 {
		if ((_dafny.One).Cmp(_dafny.IntOfUint32((stack).Cardinality())) == 0) && (((stack).Select(0).(StackValue)).Is_Bool()) {
			return m_Wrappers.Companion_Result_.Create_Success_(((stack).Select(0).(StackValue)).Dtor_b())
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("ended with bad stack")))
		}
	} else {
		var _0_t Token = (input).Select(0).(Token)
		_ = _0_t
		if (_0_t).Is_Value() {
			var _in0 _dafny.Sequence = (input).Drop(1)
			_ = _in0
			var _in1 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(stack, _dafny.SeqOf(Companion_Default___.StackValueFromValue((_0_t).Dtor_s(), values)))
			_ = _in1
			var _in2 _dafny.Map = item
			_ = _in2
			var _in3 m_Wrappers.Option = names
			_ = _in3
			var _in4 _dafny.Map = values
			_ = _in4
			input = _in0
			stack = _in1
			item = _in2
			names = _in3
			values = _in4
			goto TAIL_CALL_START
		} else if (_0_t).Is_Attr() {
			var _in5 _dafny.Sequence = (input).Drop(1)
			_ = _in5
			var _in6 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(stack, _dafny.SeqOf(Companion_Default___.StackValueFromAttr(_0_t, item, names)))
			_ = _in6
			var _in7 _dafny.Map = item
			_ = _in7
			var _in8 m_Wrappers.Option = names
			_ = _in8
			var _in9 _dafny.Map = values
			_ = _in9
			input = _in5
			stack = _in6
			item = _in7
			names = _in8
			values = _in9
			goto TAIL_CALL_START
		} else if Companion_Default___.IsUnary(_0_t) {
			if (_dafny.IntOfUint32((stack).Cardinality())).Sign() == 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Empty stack for unary op")))
			} else {
				var _1_valueOrError0 m_Wrappers.Result = Companion_Default___.Apply__unary(_0_t, (stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue))
				_ = _1_valueOrError0
				if (_1_valueOrError0).IsFailure() {
					return (_1_valueOrError0).PropagateFailure()
				} else {
					var _2_val StackValue = (_1_valueOrError0).Extract().(StackValue)
					_ = _2_val
					var _in10 _dafny.Sequence = (input).Drop(1)
					_ = _in10
					var _in11 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((stack).Take(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()), _dafny.SeqOf(_2_val))
					_ = _in11
					var _in12 _dafny.Map = item
					_ = _in12
					var _in13 m_Wrappers.Option = names
					_ = _in13
					var _in14 _dafny.Map = values
					_ = _in14
					input = _in10
					stack = _in11
					item = _in12
					names = _in13
					values = _in14
					goto TAIL_CALL_START
				}
			}
		} else if Companion_Default___.IsBinary(_0_t) {
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_dafny.IntOfInt64(2)) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Empty stack for binary op")))
			} else {
				var _3_valueOrError1 m_Wrappers.Result = Companion_Default___.Apply__binary(_0_t, (stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()).(StackValue), (stack).Select(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.One)).Uint32()).(StackValue))
				_ = _3_valueOrError1
				if (_3_valueOrError1).IsFailure() {
					return (_3_valueOrError1).PropagateFailure()
				} else {
					var _4_val StackValue = (_3_valueOrError1).Extract().(StackValue)
					_ = _4_val
					var _in15 _dafny.Sequence = (input).Drop(1)
					_ = _in15
					var _in16 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((stack).Take(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint32()), _dafny.SeqOf(_4_val))
					_ = _in16
					var _in17 _dafny.Map = item
					_ = _in17
					var _in18 m_Wrappers.Option = names
					_ = _in18
					var _in19 _dafny.Map = values
					_ = _in19
					input = _in15
					stack = _in16
					item = _in17
					names = _in18
					values = _in19
					goto TAIL_CALL_START
				}
			}
		} else if Companion_Default___.IsFunction(_0_t) {
			var _5_num__args _dafny.Int = Companion_Default___.NumArgs(_0_t, stack)
			_ = _5_num__args
			if (_dafny.IntOfUint32((stack).Cardinality())).Cmp(_5_num__args) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Empty stack for function call")))
			} else {
				var _6_valueOrError2 m_Wrappers.Result = Companion_Default___.Apply__function(_0_t, stack, _5_num__args)
				_ = _6_valueOrError2
				if (_6_valueOrError2).IsFailure() {
					return (_6_valueOrError2).PropagateFailure()
				} else {
					var _7_val StackValue = (_6_valueOrError2).Extract().(StackValue)
					_ = _7_val
					var _in20 _dafny.Sequence = (input).Drop(1)
					_ = _in20
					var _in21 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((stack).Take(((_dafny.IntOfUint32((stack).Cardinality())).Minus(_5_num__args)).Uint32()), _dafny.SeqOf(_7_val))
					_ = _in21
					var _in22 _dafny.Map = item
					_ = _in22
					var _in23 m_Wrappers.Option = names
					_ = _in23
					var _in24 _dafny.Map = values
					_ = _in24
					input = _in20
					stack = _in21
					item = _in22
					names = _in23
					values = _in24
					goto TAIL_CALL_START
				}
			}
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(true)
		}
	}
}
func (_static *CompanionStruct_Default___) FilterItems(b m_SearchableEncryptionInfo.BeaconVersion, parsed _dafny.Sequence, ItemList _dafny.Sequence, names m_Wrappers.Option, values _dafny.Map) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_acc _dafny.Sequence
	_ = _0_acc
	_0_acc = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32((ItemList).Cardinality())
	_ = _hi0
	for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _2_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (b).GeneratePlainBeacons((ItemList).Select((_1_i).Uint32()).(_dafny.Map))
		_2_valueOrError0 = _out0
		if (_2_valueOrError0).IsFailure() {
			output = (_2_valueOrError0).PropagateFailure()
			return output
		}
		var _3_newAttrs _dafny.Map
		_ = _3_newAttrs
		_3_newAttrs = (_2_valueOrError0).Extract().(_dafny.Map)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _4_valueOrError1
		_4_valueOrError1 = Companion_Default___.EvalExpr(parsed, ((ItemList).Select((_1_i).Uint32()).(_dafny.Map)).Merge(_3_newAttrs), names, values)
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_doesMatch bool
		_ = _5_doesMatch
		_5_doesMatch = (_4_valueOrError1).Extract().(bool)
		if _5_doesMatch {
			_0_acc = _dafny.Companion_Sequence_.Concatenate(_0_acc, _dafny.SeqOf((ItemList).Select((_1_i).Uint32()).(_dafny.Map)))
		}
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_0_acc)
	return output
	return output
}
func (_static *CompanionStruct_Default___) FilterResults(b m_SearchableEncryptionInfo.BeaconVersion, ItemList _dafny.Sequence, KeyExpression m_Wrappers.Option, FilterExpression m_Wrappers.Option, names m_Wrappers.Option, values m_Wrappers.Option) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	if ((_dafny.IntOfUint32((ItemList).Cardinality())).Sign() == 0) || (((KeyExpression).Is_None()) && ((FilterExpression).Is_None())) {
		output = m_Wrappers.Companion_Result_.Create_Success_(ItemList)
		return output
	} else {
		var _0_afterKeys _dafny.Sequence = _dafny.EmptySeq
		_ = _0_afterKeys
		if (KeyExpression).Is_Some() {
			var _1_parsed _dafny.Sequence
			_ = _1_parsed
			_1_parsed = Companion_Default___.ParseExpr((KeyExpression).Dtor_value().(_dafny.Sequence))
			var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ParsedContext_.Default())
			_ = _2_valueOrError0
			_2_valueOrError0 = Companion_Default___.BeaconizeParsedExpr(b, _1_parsed, _dafny.Zero, (values).UnwrapOr(_dafny.NewMapBuilder().ToMap()).(_dafny.Map), names, m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_DontUseKeys_(), _dafny.NewMapBuilder().ToMap(), _dafny.SeqOf())
			if (_2_valueOrError0).IsFailure() {
				output = (_2_valueOrError0).PropagateFailure()
				return output
			}
			var _3_expr ParsedContext
			_ = _3_expr
			_3_expr = (_2_valueOrError0).Extract().(ParsedContext)
			var _4_expr1 _dafny.Sequence
			_ = _4_expr1
			_4_expr1 = Companion_Default___.ConvertToPrefix((_3_expr).Dtor_expr())
			var _5_expr2 _dafny.Sequence
			_ = _5_expr2
			_5_expr2 = Companion_Default___.ConvertToRpn(_4_expr1)
			var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
			_ = _6_valueOrError1
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = Companion_Default___.FilterItems(b, _5_expr2, ItemList, (_3_expr).Dtor_names(), (_3_expr).Dtor_values())
			_6_valueOrError1 = _out0
			if (_6_valueOrError1).IsFailure() {
				output = (_6_valueOrError1).PropagateFailure()
				return output
			}
			_0_afterKeys = (_6_valueOrError1).Extract().(_dafny.Sequence)
		} else {
			_0_afterKeys = ItemList
		}
		if (FilterExpression).Is_Some() {
			var _7_parsed _dafny.Sequence
			_ = _7_parsed
			_7_parsed = Companion_Default___.ParseExpr((FilterExpression).Dtor_value().(_dafny.Sequence))
			var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ParsedContext_.Default())
			_ = _8_valueOrError2
			_8_valueOrError2 = Companion_Default___.BeaconizeParsedExpr(b, _7_parsed, _dafny.Zero, (values).UnwrapOr(_dafny.NewMapBuilder().ToMap()).(_dafny.Map), names, m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_DontUseKeys_(), _dafny.NewMapBuilder().ToMap(), _dafny.SeqOf())
			if (_8_valueOrError2).IsFailure() {
				output = (_8_valueOrError2).PropagateFailure()
				return output
			}
			var _9_expr ParsedContext
			_ = _9_expr
			_9_expr = (_8_valueOrError2).Extract().(ParsedContext)
			var _10_expr1 _dafny.Sequence
			_ = _10_expr1
			_10_expr1 = Companion_Default___.ConvertToPrefix((_9_expr).Dtor_expr())
			var _11_expr2 _dafny.Sequence
			_ = _11_expr2
			_11_expr2 = Companion_Default___.ConvertToRpn(_10_expr1)
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = Companion_Default___.FilterItems(b, _11_expr2, _0_afterKeys, (_9_expr).Dtor_names(), (_9_expr).Dtor_values())
			output = _out1
		} else {
			output = m_Wrappers.Companion_Result_.Create_Success_(_0_afterKeys)
			return output
		}
	}
	return output
}
func (_static *CompanionStruct_Default___) KeyIdFromPart(bv m_SearchableEncryptionInfo.BeaconVersion, keyIdField _dafny.Sequence, attr _dafny.Sequence, value _dafny.Sequence) m_Wrappers.Option {
	if (!((bv).Dtor_beacons()).Contains(attr)) || ((((bv).Dtor_beacons()).Get(attr).(m_SearchableEncryptionInfo.Beacon)).Is_Standard()) {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _0_parts _dafny.Sequence = ((((bv).Dtor_beacons()).Get(attr).(m_SearchableEncryptionInfo.Beacon)).Dtor_cmp()).Dtor_parts()
		_ = _0_parts
		var _1_theParts _dafny.Sequence = m_Seq.Companion_Default___.Filter(func(coer118 func(m_CompoundBeacon.BeaconPart) bool) func(interface{}) bool {
			return func(arg151 interface{}) bool {
				return coer118(arg151.(m_CompoundBeacon.BeaconPart))
			}
		}((func(_2_keyIdField _dafny.Sequence) func(m_CompoundBeacon.BeaconPart) bool {
			return func(_3_p m_CompoundBeacon.BeaconPart) bool {
				return ((_3_p).Is_Signed()) && (_dafny.Companion_Sequence_.Equal((((_3_p).Dtor_loc()).Select(0).(m_TermLoc.Selector)).Dtor_key(), _2_keyIdField))
			}
		})(keyIdField)), _0_parts)
		_ = _1_theParts
		if (_dafny.IntOfUint32((_1_theParts).Cardinality())).Cmp(_dafny.One) != 0 {
			return m_Wrappers.Companion_Option_.Create_None_()
		} else {
			var _4_pieces _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(value, ((((bv).Dtor_beacons()).Get(attr).(m_SearchableEncryptionInfo.Beacon)).Dtor_cmp()).Dtor_split())
			_ = _4_pieces
			var _5_piece _dafny.Sequence = m_Seq.Companion_Default___.Filter(func(coer119 func(_dafny.Sequence) bool) func(interface{}) bool {
				return func(arg152 interface{}) bool {
					return coer119(arg152.(_dafny.Sequence))
				}
			}((func(_6_theParts _dafny.Sequence) func(_dafny.Sequence) bool {
				return func(_7_s _dafny.Sequence) bool {
					return _dafny.Companion_Sequence_.IsPrefixOf(((_6_theParts).Select(0).(m_CompoundBeacon.BeaconPart)).Dtor_prefix(), _7_s)
				}
			})(_1_theParts)), _4_pieces)
			_ = _5_piece
			if (_dafny.IntOfUint32((_5_piece).Cardinality())).Cmp(_dafny.One) != 0 {
				return m_Wrappers.Companion_Option_.Create_None_()
			} else {
				var _8_p _dafny.Sequence = (_5_piece).Select(0).(_dafny.Sequence)
				_ = _8_p
				return m_Wrappers.Companion_Option_.Create_Some_((_8_p).Drop((_dafny.IntOfUint32((((_1_theParts).Select(0).(m_CompoundBeacon.BeaconPart)).Dtor_prefix()).Cardinality())).Uint32()))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) KeyIdFromAttr(bv m_SearchableEncryptionInfo.BeaconVersion, attr m_Wrappers.Option, value _dafny.Sequence, names m_Wrappers.Option) m_Wrappers.Option {
	if (attr).Is_None() {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _0_name _dafny.Sequence = (func() _dafny.Sequence {
			if ((names).Is_Some()) && (((names).Dtor_value().(_dafny.Map)).Contains(((attr).Dtor_value().(Token)).Dtor_s())) {
				return ((names).Dtor_value().(_dafny.Map)).Get(((attr).Dtor_value().(Token)).Dtor_s()).(_dafny.Sequence)
			}
			return ((attr).Dtor_value().(Token)).Dtor_s()
		})()
		_ = _0_name
		var _1_keyIdField _dafny.Sequence = (((bv).Dtor_keySource()).Dtor_keyLoc()).Dtor_keyName()
		_ = _1_keyIdField
		if _dafny.Companion_Sequence_.Equal(_1_keyIdField, _0_name) {
			return m_Wrappers.Companion_Option_.Create_Some_(value)
		} else {
			return Companion_Default___.KeyIdFromPart(bv, _1_keyIdField, ((attr).Dtor_value().(Token)).Dtor_s(), value)
		}
	}
}
func (_static *CompanionStruct_Default___) GetBeaconKeyIds2(pos _dafny.Int, bv m_SearchableEncryptionInfo.BeaconVersion, expr _dafny.Sequence, values _dafny.Map, names m_Wrappers.Option, soFar _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (pos).Cmp(_dafny.IntOfUint32((expr).Cardinality())) == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(soFar)
	} else if ((expr).Select((pos).Uint32()).(Token)).Is_Value() {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((values).Contains(((expr).Select((pos).Uint32()).(Token)).Dtor_s()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(((expr).Select((pos).Uint32()).(Token)).Dtor_s(), _dafny.SeqOfString(" not found in ExpressionAttributeValueMap"))))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_oldValue m_ComAmazonawsDynamodbTypes.AttributeValue = (values).Get(((expr).Select((pos).Uint32()).(Token)).Dtor_s()).(m_ComAmazonawsDynamodbTypes.AttributeValue)
			_ = _1_oldValue
			if (_1_oldValue).Is_S() {
				var _2_attr m_Wrappers.Option = Companion_Default___.AttrForValue(expr, pos)
				_ = _2_attr
				var _3_keyId m_Wrappers.Option = Companion_Default___.KeyIdFromAttr(bv, _2_attr, (_1_oldValue).Dtor_S(), names)
				_ = _3_keyId
				if ((_3_keyId).Is_None()) || (_dafny.Companion_Sequence_.Contains(soFar, (_3_keyId).Dtor_value().(_dafny.Sequence))) {
					var _in0 _dafny.Int = (pos).Plus(_dafny.One)
					_ = _in0
					var _in1 m_SearchableEncryptionInfo.BeaconVersion = bv
					_ = _in1
					var _in2 _dafny.Sequence = expr
					_ = _in2
					var _in3 _dafny.Map = values
					_ = _in3
					var _in4 m_Wrappers.Option = names
					_ = _in4
					var _in5 _dafny.Sequence = soFar
					_ = _in5
					pos = _in0
					bv = _in1
					expr = _in2
					values = _in3
					names = _in4
					soFar = _in5
					goto TAIL_CALL_START
				} else {
					var _in6 _dafny.Int = (pos).Plus(_dafny.One)
					_ = _in6
					var _in7 m_SearchableEncryptionInfo.BeaconVersion = bv
					_ = _in7
					var _in8 _dafny.Sequence = expr
					_ = _in8
					var _in9 _dafny.Map = values
					_ = _in9
					var _in10 m_Wrappers.Option = names
					_ = _in10
					var _in11 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(soFar, _dafny.SeqOf((_3_keyId).Dtor_value().(_dafny.Sequence)))
					_ = _in11
					pos = _in6
					bv = _in7
					expr = _in8
					values = _in9
					names = _in10
					soFar = _in11
					goto TAIL_CALL_START
				}
			} else {
				var _in12 _dafny.Int = (pos).Plus(_dafny.One)
				_ = _in12
				var _in13 m_SearchableEncryptionInfo.BeaconVersion = bv
				_ = _in13
				var _in14 _dafny.Sequence = expr
				_ = _in14
				var _in15 _dafny.Map = values
				_ = _in15
				var _in16 m_Wrappers.Option = names
				_ = _in16
				var _in17 _dafny.Sequence = soFar
				_ = _in17
				pos = _in12
				bv = _in13
				expr = _in14
				values = _in15
				names = _in16
				soFar = _in17
				goto TAIL_CALL_START
			}
		}
	} else {
		var _in18 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in18
		var _in19 m_SearchableEncryptionInfo.BeaconVersion = bv
		_ = _in19
		var _in20 _dafny.Sequence = expr
		_ = _in20
		var _in21 _dafny.Map = values
		_ = _in21
		var _in22 m_Wrappers.Option = names
		_ = _in22
		var _in23 _dafny.Sequence = soFar
		_ = _in23
		pos = _in18
		bv = _in19
		expr = _in20
		values = _in21
		names = _in22
		soFar = _in23
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetBeaconKeyIds(bv m_SearchableEncryptionInfo.BeaconVersion, expr m_Wrappers.Option, values _dafny.Map, names m_Wrappers.Option, soFar _dafny.Sequence) m_Wrappers.Result {
	if (expr).Is_None() {
		return m_Wrappers.Companion_Result_.Create_Success_(soFar)
	} else {
		var _0_parsed _dafny.Sequence = Companion_Default___.ParseExpr((expr).Dtor_value().(_dafny.Sequence))
		_ = _0_parsed
		return Companion_Default___.GetBeaconKeyIds2(_dafny.Zero, bv, _0_parsed, values, names, soFar)
	}
}
func (_static *CompanionStruct_Default___) GetBeaconKeyId(bv m_SearchableEncryptionInfo.BeaconVersion, keyExpr m_Wrappers.Option, filterExpr m_Wrappers.Option, values m_Wrappers.Option, names m_Wrappers.Option) m_Wrappers.Result {
	if !((((bv).Dtor_keySource()).Dtor_keyLoc()).Is_MultiLoc()) {
		return m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	} else if (values).Is_None() {
		return m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_ShouldHaveKeyId_())
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetBeaconKeyIds(bv, keyExpr, (values).Dtor_value().(_dafny.Map), names, _dafny.SeqOf())
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_soFar _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_soFar
			var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.GetBeaconKeyIds(bv, filterExpr, (values).Dtor_value().(_dafny.Map), names, _1_soFar)
			_ = _2_valueOrError1
			if (_2_valueOrError1).IsFailure() {
				return (_2_valueOrError1).PropagateFailure()
			} else {
				var _3_final _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
				_ = _3_final
				if (_dafny.IntOfUint32((_3_final).Cardinality())).Cmp(_dafny.One) == 0 {
					return m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_((_3_final).Select(0).(_dafny.Sequence)))
				} else if (_dafny.IntOfUint32((_3_final).Cardinality())).Sign() == 0 {
					return m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_ShouldHaveKeyId_())
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Multiple values found for "), (((bv).Dtor_keySource()).Dtor_keyLoc()).Dtor_keyName()), _dafny.SeqOfString(" in query : ")), m_StandardLibrary.Companion_Default___.Join(_3_final, _dafny.SeqOfString(", ")))))
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) Beaconize(b m_SearchableEncryptionInfo.BeaconVersion, context ExprContext, keyId m_DynamoDbEncryptionUtil.MaybeKeyId, naked bool) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ExprContext_.Default())
	_ = output
	if (((context).Dtor_keyExpr()).Is_None()) && (((context).Dtor_filterExpr()).Is_None()) {
		output = m_Wrappers.Companion_Result_.Create_Success_(context)
		return output
	} else {
		var _0_keys m_DynamoDbEncryptionUtil.MaybeKeyMap
		_ = _0_keys
		_0_keys = m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_DontUseKeys_()
		if !(naked) {
			var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Default())
			_ = _1_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = (b).GetKeyMap(keyId)
			_1_valueOrError0 = _out0
			if (_1_valueOrError0).IsFailure() {
				output = (_1_valueOrError0).PropagateFailure()
				return output
			}
			_0_keys = (_1_valueOrError0).Extract().(m_DynamoDbEncryptionUtil.MaybeKeyMap)
		}
		var _2_values _dafny.Map
		_ = _2_values
		if ((context).Dtor_values()).Is_Some() {
			_2_values = ((context).Dtor_values()).Dtor_value().(_dafny.Map)
		} else {
			_2_values = _dafny.NewMapBuilder().ToMap()
		}
		var _3_newValues _dafny.Map
		_ = _3_newValues
		_3_newValues = _dafny.NewMapBuilder().ToMap()
		var _4_newKeyExpr m_Wrappers.Option
		_ = _4_newKeyExpr
		_4_newKeyExpr = (context).Dtor_keyExpr()
		var _5_newFilterExpr m_Wrappers.Option
		_ = _5_newFilterExpr
		_5_newFilterExpr = (context).Dtor_filterExpr()
		var _6_newNames m_Wrappers.Option
		_ = _6_newNames
		_6_newNames = (context).Dtor_names()
		if ((context).Dtor_keyExpr()).Is_Some() {
			var _7_parsed _dafny.Sequence
			_ = _7_parsed
			_7_parsed = Companion_Default___.ParseExpr(((context).Dtor_keyExpr()).Dtor_value().(_dafny.Sequence))
			var _8_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ParsedContext_.Default())
			_ = _8_valueOrError1
			_8_valueOrError1 = Companion_Default___.BeaconizeParsedExpr(b, _7_parsed, _dafny.Zero, _2_values, _6_newNames, _0_keys, _3_newValues, _dafny.SeqOf())
			if (_8_valueOrError1).IsFailure() {
				output = (_8_valueOrError1).PropagateFailure()
				return output
			}
			var _9_newContext ParsedContext
			_ = _9_newContext
			_9_newContext = (_8_valueOrError1).Extract().(ParsedContext)
			_4_newKeyExpr = m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.ParsedExprToString((_9_newContext).Dtor_expr()))
			_3_newValues = (_9_newContext).Dtor_values()
			_6_newNames = (_9_newContext).Dtor_names()
		}
		if ((context).Dtor_filterExpr()).Is_Some() {
			var _10_parsed _dafny.Sequence
			_ = _10_parsed
			_10_parsed = Companion_Default___.ParseExpr(((context).Dtor_filterExpr()).Dtor_value().(_dafny.Sequence))
			var _11_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ParsedContext_.Default())
			_ = _11_valueOrError2
			_11_valueOrError2 = Companion_Default___.BeaconizeParsedExpr(b, _10_parsed, _dafny.Zero, _2_values, _6_newNames, _0_keys, _3_newValues, _dafny.SeqOf())
			if (_11_valueOrError2).IsFailure() {
				output = (_11_valueOrError2).PropagateFailure()
				return output
			}
			var _12_newContext ParsedContext
			_ = _12_newContext
			_12_newContext = (_11_valueOrError2).Extract().(ParsedContext)
			_5_newFilterExpr = m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.ParsedExprToString((_12_newContext).Dtor_expr()))
			_3_newValues = (_12_newContext).Dtor_values()
			_6_newNames = (_12_newContext).Dtor_names()
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(Companion_ExprContext_.Create_ExprContext_(_4_newKeyExpr, _5_newFilterExpr, (func() m_Wrappers.Option {
			if ((_3_newValues).Cardinality()).Sign() == 0 {
				return m_Wrappers.Companion_Option_.Create_None_()
			}
			return m_Wrappers.Companion_Option_.Create_Some_(_3_newValues)
		})(), _6_newNames))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) GetAttrName(t Token, names m_Wrappers.Option) _dafny.Sequence {
	if ((names).Is_Some()) && (((names).Dtor_value().(_dafny.Map)).Contains((t).Dtor_s())) {
		return ((names).Dtor_value().(_dafny.Map)).Get((t).Dtor_s()).(_dafny.Sequence)
	} else {
		return (t).Dtor_s()
	}
}
func (_static *CompanionStruct_Default___) TestParsedExpr(expr _dafny.Sequence, encrypted _dafny.Set, names m_Wrappers.Option) m_Wrappers.Outcome {
	var output m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = output
	var _hi0 _dafny.Int = _dafny.IntOfUint32((expr).Cardinality())
	_ = _hi0
	for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
		if ((expr).Select((_0_i).Uint32()).(Token)).Is_Attr() {
			var _1_name _dafny.Sequence
			_ = _1_name
			_1_name = Companion_Default___.GetAttrName((expr).Select((_0_i).Uint32()).(Token), names)
			if (encrypted).Contains(_1_name) {
				output = m_Wrappers.Companion_Outcome_.Create_Fail_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Query is using encrypted field : "), _1_name), _dafny.SeqOfString("."))))
				return output
			}
		}
	}
	output = m_Wrappers.Companion_Outcome_.Create_Pass_()
	return output
	return output
}
func (_static *CompanionStruct_Default___) TestBeaconize(actions _dafny.Map, keyExpr m_Wrappers.Option, filterExpr m_Wrappers.Option, names m_Wrappers.Option) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = output
	var _0_encrypted _dafny.Set
	_ = _0_encrypted
	_0_encrypted = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter28 := _dafny.Iterate((actions).Keys().Elements()); ; {
			_compr_0, _ok28 := _iter28()
			if !_ok28 {
				break
			}
			var _1_k _dafny.Sequence
			_1_k = interface{}(_compr_0).(_dafny.Sequence)
			if ((actions).Contains(_1_k)) && (((actions).Get(_1_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())) {
				_coll0.Add(_1_k)
			}
		}
		return _coll0.ToSet()
	}()
	if (keyExpr).Is_Some() {
		var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError0
		var _out0 m_Wrappers.Outcome
		_ = _out0
		_out0 = Companion_Default___.TestParsedExpr(Companion_Default___.ParseExpr((keyExpr).Dtor_value().(_dafny.Sequence)), _0_encrypted, names)
		_2_valueOrError0 = _out0
		if (_2_valueOrError0).IsFailure() {
			output = (_2_valueOrError0).PropagateFailure()
			return output
		}
	}
	if (filterExpr).Is_Some() {
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError1
		var _out1 m_Wrappers.Outcome
		_ = _out1
		_out1 = Companion_Default___.TestParsedExpr(Companion_Default___.ParseExpr((filterExpr).Dtor_value().(_dafny.Sequence)), _0_encrypted, names)
		_3_valueOrError1 = _out1
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(true)
	return output
	return output
}

// End of class Default__

// Definition of datatype Token
type Token struct {
	Data_Token_
}

func (_this Token) Get_() Data_Token_ {
	return _this.Data_Token_
}

type Data_Token_ interface {
	isToken()
}

type CompanionStruct_Token_ struct {
}

var Companion_Token_ = CompanionStruct_Token_{}

type Token_Attr struct {
	S   _dafny.Sequence
	Loc _dafny.Sequence
}

func (Token_Attr) isToken() {}

func (CompanionStruct_Token_) Create_Attr_(S _dafny.Sequence, Loc _dafny.Sequence) Token {
	return Token{Token_Attr{S, Loc}}
}

func (_this Token) Is_Attr() bool {
	_, ok := _this.Get_().(Token_Attr)
	return ok
}

type Token_Value struct {
	S _dafny.Sequence
}

func (Token_Value) isToken() {}

func (CompanionStruct_Token_) Create_Value_(S _dafny.Sequence) Token {
	return Token{Token_Value{S}}
}

func (_this Token) Is_Value() bool {
	_, ok := _this.Get_().(Token_Value)
	return ok
}

type Token_Eq struct {
}

func (Token_Eq) isToken() {}

func (CompanionStruct_Token_) Create_Eq_() Token {
	return Token{Token_Eq{}}
}

func (_this Token) Is_Eq() bool {
	_, ok := _this.Get_().(Token_Eq)
	return ok
}

type Token_Ne struct {
}

func (Token_Ne) isToken() {}

func (CompanionStruct_Token_) Create_Ne_() Token {
	return Token{Token_Ne{}}
}

func (_this Token) Is_Ne() bool {
	_, ok := _this.Get_().(Token_Ne)
	return ok
}

type Token_Lt struct {
}

func (Token_Lt) isToken() {}

func (CompanionStruct_Token_) Create_Lt_() Token {
	return Token{Token_Lt{}}
}

func (_this Token) Is_Lt() bool {
	_, ok := _this.Get_().(Token_Lt)
	return ok
}

type Token_Gt struct {
}

func (Token_Gt) isToken() {}

func (CompanionStruct_Token_) Create_Gt_() Token {
	return Token{Token_Gt{}}
}

func (_this Token) Is_Gt() bool {
	_, ok := _this.Get_().(Token_Gt)
	return ok
}

type Token_Le struct {
}

func (Token_Le) isToken() {}

func (CompanionStruct_Token_) Create_Le_() Token {
	return Token{Token_Le{}}
}

func (_this Token) Is_Le() bool {
	_, ok := _this.Get_().(Token_Le)
	return ok
}

type Token_Ge struct {
}

func (Token_Ge) isToken() {}

func (CompanionStruct_Token_) Create_Ge_() Token {
	return Token{Token_Ge{}}
}

func (_this Token) Is_Ge() bool {
	_, ok := _this.Get_().(Token_Ge)
	return ok
}

type Token_Between struct {
}

func (Token_Between) isToken() {}

func (CompanionStruct_Token_) Create_Between_() Token {
	return Token{Token_Between{}}
}

func (_this Token) Is_Between() bool {
	_, ok := _this.Get_().(Token_Between)
	return ok
}

type Token_In struct {
}

func (Token_In) isToken() {}

func (CompanionStruct_Token_) Create_In_() Token {
	return Token{Token_In{}}
}

func (_this Token) Is_In() bool {
	_, ok := _this.Get_().(Token_In)
	return ok
}

type Token_Open struct {
}

func (Token_Open) isToken() {}

func (CompanionStruct_Token_) Create_Open_() Token {
	return Token{Token_Open{}}
}

func (_this Token) Is_Open() bool {
	_, ok := _this.Get_().(Token_Open)
	return ok
}

type Token_Close struct {
}

func (Token_Close) isToken() {}

func (CompanionStruct_Token_) Create_Close_() Token {
	return Token{Token_Close{}}
}

func (_this Token) Is_Close() bool {
	_, ok := _this.Get_().(Token_Close)
	return ok
}

type Token_Comma struct {
}

func (Token_Comma) isToken() {}

func (CompanionStruct_Token_) Create_Comma_() Token {
	return Token{Token_Comma{}}
}

func (_this Token) Is_Comma() bool {
	_, ok := _this.Get_().(Token_Comma)
	return ok
}

type Token_Not struct {
}

func (Token_Not) isToken() {}

func (CompanionStruct_Token_) Create_Not_() Token {
	return Token{Token_Not{}}
}

func (_this Token) Is_Not() bool {
	_, ok := _this.Get_().(Token_Not)
	return ok
}

type Token_And struct {
}

func (Token_And) isToken() {}

func (CompanionStruct_Token_) Create_And_() Token {
	return Token{Token_And{}}
}

func (_this Token) Is_And() bool {
	_, ok := _this.Get_().(Token_And)
	return ok
}

type Token_Or struct {
}

func (Token_Or) isToken() {}

func (CompanionStruct_Token_) Create_Or_() Token {
	return Token{Token_Or{}}
}

func (_this Token) Is_Or() bool {
	_, ok := _this.Get_().(Token_Or)
	return ok
}

type Token_AttributeExists struct {
}

func (Token_AttributeExists) isToken() {}

func (CompanionStruct_Token_) Create_AttributeExists_() Token {
	return Token{Token_AttributeExists{}}
}

func (_this Token) Is_AttributeExists() bool {
	_, ok := _this.Get_().(Token_AttributeExists)
	return ok
}

type Token_AttributeNotExists struct {
}

func (Token_AttributeNotExists) isToken() {}

func (CompanionStruct_Token_) Create_AttributeNotExists_() Token {
	return Token{Token_AttributeNotExists{}}
}

func (_this Token) Is_AttributeNotExists() bool {
	_, ok := _this.Get_().(Token_AttributeNotExists)
	return ok
}

type Token_AttributeType struct {
}

func (Token_AttributeType) isToken() {}

func (CompanionStruct_Token_) Create_AttributeType_() Token {
	return Token{Token_AttributeType{}}
}

func (_this Token) Is_AttributeType() bool {
	_, ok := _this.Get_().(Token_AttributeType)
	return ok
}

type Token_BeginsWith struct {
}

func (Token_BeginsWith) isToken() {}

func (CompanionStruct_Token_) Create_BeginsWith_() Token {
	return Token{Token_BeginsWith{}}
}

func (_this Token) Is_BeginsWith() bool {
	_, ok := _this.Get_().(Token_BeginsWith)
	return ok
}

type Token_Contains struct {
}

func (Token_Contains) isToken() {}

func (CompanionStruct_Token_) Create_Contains_() Token {
	return Token{Token_Contains{}}
}

func (_this Token) Is_Contains() bool {
	_, ok := _this.Get_().(Token_Contains)
	return ok
}

type Token_Size struct {
}

func (Token_Size) isToken() {}

func (CompanionStruct_Token_) Create_Size_() Token {
	return Token{Token_Size{}}
}

func (_this Token) Is_Size() bool {
	_, ok := _this.Get_().(Token_Size)
	return ok
}

func (CompanionStruct_Token_) Default() Token {
	return Companion_Token_.Create_Attr_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq)
}

func (_this Token) Dtor_s() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Token_Attr:
		return data.S
	default:
		return data.(Token_Value).S
	}
}

func (_this Token) Dtor_loc() _dafny.Sequence {
	return _this.Get_().(Token_Attr).Loc
}

func (_this Token) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Token_Attr:
		{
			return "DynamoDBFilterExpr.Token.Attr" + "(" + _dafny.String(data.S) + ", " + _dafny.String(data.Loc) + ")"
		}
	case Token_Value:
		{
			return "DynamoDBFilterExpr.Token.Value" + "(" + _dafny.String(data.S) + ")"
		}
	case Token_Eq:
		{
			return "DynamoDBFilterExpr.Token.Eq"
		}
	case Token_Ne:
		{
			return "DynamoDBFilterExpr.Token.Ne"
		}
	case Token_Lt:
		{
			return "DynamoDBFilterExpr.Token.Lt"
		}
	case Token_Gt:
		{
			return "DynamoDBFilterExpr.Token.Gt"
		}
	case Token_Le:
		{
			return "DynamoDBFilterExpr.Token.Le"
		}
	case Token_Ge:
		{
			return "DynamoDBFilterExpr.Token.Ge"
		}
	case Token_Between:
		{
			return "DynamoDBFilterExpr.Token.Between"
		}
	case Token_In:
		{
			return "DynamoDBFilterExpr.Token.In"
		}
	case Token_Open:
		{
			return "DynamoDBFilterExpr.Token.Open"
		}
	case Token_Close:
		{
			return "DynamoDBFilterExpr.Token.Close"
		}
	case Token_Comma:
		{
			return "DynamoDBFilterExpr.Token.Comma"
		}
	case Token_Not:
		{
			return "DynamoDBFilterExpr.Token.Not"
		}
	case Token_And:
		{
			return "DynamoDBFilterExpr.Token.And"
		}
	case Token_Or:
		{
			return "DynamoDBFilterExpr.Token.Or"
		}
	case Token_AttributeExists:
		{
			return "DynamoDBFilterExpr.Token.AttributeExists"
		}
	case Token_AttributeNotExists:
		{
			return "DynamoDBFilterExpr.Token.AttributeNotExists"
		}
	case Token_AttributeType:
		{
			return "DynamoDBFilterExpr.Token.AttributeType"
		}
	case Token_BeginsWith:
		{
			return "DynamoDBFilterExpr.Token.BeginsWith"
		}
	case Token_Contains:
		{
			return "DynamoDBFilterExpr.Token.Contains"
		}
	case Token_Size:
		{
			return "DynamoDBFilterExpr.Token.Size"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Token) Equals(other Token) bool {
	switch data1 := _this.Get_().(type) {
	case Token_Attr:
		{
			data2, ok := other.Get_().(Token_Attr)
			return ok && data1.S.Equals(data2.S) && data1.Loc.Equals(data2.Loc)
		}
	case Token_Value:
		{
			data2, ok := other.Get_().(Token_Value)
			return ok && data1.S.Equals(data2.S)
		}
	case Token_Eq:
		{
			_, ok := other.Get_().(Token_Eq)
			return ok
		}
	case Token_Ne:
		{
			_, ok := other.Get_().(Token_Ne)
			return ok
		}
	case Token_Lt:
		{
			_, ok := other.Get_().(Token_Lt)
			return ok
		}
	case Token_Gt:
		{
			_, ok := other.Get_().(Token_Gt)
			return ok
		}
	case Token_Le:
		{
			_, ok := other.Get_().(Token_Le)
			return ok
		}
	case Token_Ge:
		{
			_, ok := other.Get_().(Token_Ge)
			return ok
		}
	case Token_Between:
		{
			_, ok := other.Get_().(Token_Between)
			return ok
		}
	case Token_In:
		{
			_, ok := other.Get_().(Token_In)
			return ok
		}
	case Token_Open:
		{
			_, ok := other.Get_().(Token_Open)
			return ok
		}
	case Token_Close:
		{
			_, ok := other.Get_().(Token_Close)
			return ok
		}
	case Token_Comma:
		{
			_, ok := other.Get_().(Token_Comma)
			return ok
		}
	case Token_Not:
		{
			_, ok := other.Get_().(Token_Not)
			return ok
		}
	case Token_And:
		{
			_, ok := other.Get_().(Token_And)
			return ok
		}
	case Token_Or:
		{
			_, ok := other.Get_().(Token_Or)
			return ok
		}
	case Token_AttributeExists:
		{
			_, ok := other.Get_().(Token_AttributeExists)
			return ok
		}
	case Token_AttributeNotExists:
		{
			_, ok := other.Get_().(Token_AttributeNotExists)
			return ok
		}
	case Token_AttributeType:
		{
			_, ok := other.Get_().(Token_AttributeType)
			return ok
		}
	case Token_BeginsWith:
		{
			_, ok := other.Get_().(Token_BeginsWith)
			return ok
		}
	case Token_Contains:
		{
			_, ok := other.Get_().(Token_Contains)
			return ok
		}
	case Token_Size:
		{
			_, ok := other.Get_().(Token_Size)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Token) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Token)
	return ok && _this.Equals(typed)
}

func Type_Token_() _dafny.TypeDescriptor {
	return type_Token_{}
}

type type_Token_ struct {
}

func (_this type_Token_) Default() interface{} {
	return Companion_Token_.Default()
}

func (_this type_Token_) String() string {
	return "DynamoDBFilterExpr.Token"
}
func (_this Token) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Token{}

// End of datatype Token

// Definition of datatype EqualityBeacon
type EqualityBeacon struct {
	Data_EqualityBeacon_
}

func (_this EqualityBeacon) Get_() Data_EqualityBeacon_ {
	return _this.Data_EqualityBeacon_
}

type Data_EqualityBeacon_ interface {
	isEqualityBeacon()
}

type CompanionStruct_EqualityBeacon_ struct {
}

var Companion_EqualityBeacon_ = CompanionStruct_EqualityBeacon_{}

type EqualityBeacon_EqualityBeacon struct {
	Beacon      m_Wrappers.Option
	ForEquality bool
	ForContains bool
}

func (EqualityBeacon_EqualityBeacon) isEqualityBeacon() {}

func (CompanionStruct_EqualityBeacon_) Create_EqualityBeacon_(Beacon m_Wrappers.Option, ForEquality bool, ForContains bool) EqualityBeacon {
	return EqualityBeacon{EqualityBeacon_EqualityBeacon{Beacon, ForEquality, ForContains}}
}

func (_this EqualityBeacon) Is_EqualityBeacon() bool {
	_, ok := _this.Get_().(EqualityBeacon_EqualityBeacon)
	return ok
}

func (CompanionStruct_EqualityBeacon_) Default() EqualityBeacon {
	return Companion_EqualityBeacon_.Create_EqualityBeacon_(m_Wrappers.Companion_Option_.Default(), false, false)
}

func (_this EqualityBeacon) Dtor_beacon() m_Wrappers.Option {
	return _this.Get_().(EqualityBeacon_EqualityBeacon).Beacon
}

func (_this EqualityBeacon) Dtor_forEquality() bool {
	return _this.Get_().(EqualityBeacon_EqualityBeacon).ForEquality
}

func (_this EqualityBeacon) Dtor_forContains() bool {
	return _this.Get_().(EqualityBeacon_EqualityBeacon).ForContains
}

func (_this EqualityBeacon) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EqualityBeacon_EqualityBeacon:
		{
			return "DynamoDBFilterExpr.EqualityBeacon.EqualityBeacon" + "(" + _dafny.String(data.Beacon) + ", " + _dafny.String(data.ForEquality) + ", " + _dafny.String(data.ForContains) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EqualityBeacon) Equals(other EqualityBeacon) bool {
	switch data1 := _this.Get_().(type) {
	case EqualityBeacon_EqualityBeacon:
		{
			data2, ok := other.Get_().(EqualityBeacon_EqualityBeacon)
			return ok && data1.Beacon.Equals(data2.Beacon) && data1.ForEquality == data2.ForEquality && data1.ForContains == data2.ForContains
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EqualityBeacon) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EqualityBeacon)
	return ok && _this.Equals(typed)
}

func Type_EqualityBeacon_() _dafny.TypeDescriptor {
	return type_EqualityBeacon_{}
}

type type_EqualityBeacon_ struct {
}

func (_this type_EqualityBeacon_) Default() interface{} {
	return Companion_EqualityBeacon_.Default()
}

func (_this type_EqualityBeacon_) String() string {
	return "DynamoDBFilterExpr.EqualityBeacon"
}
func (_this EqualityBeacon) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EqualityBeacon{}

// End of datatype EqualityBeacon

// Definition of datatype StackValue
type StackValue struct {
	Data_StackValue_
}

func (_this StackValue) Get_() Data_StackValue_ {
	return _this.Data_StackValue_
}

type Data_StackValue_ interface {
	isStackValue()
}

type CompanionStruct_StackValue_ struct {
}

var Companion_StackValue_ = CompanionStruct_StackValue_{}

type StackValue_Bool struct {
	B bool
}

func (StackValue_Bool) isStackValue() {}

func (CompanionStruct_StackValue_) Create_Bool_(B bool) StackValue {
	return StackValue{StackValue_Bool{B}}
}

func (_this StackValue) Is_Bool() bool {
	_, ok := _this.Get_().(StackValue_Bool)
	return ok
}

type StackValue_Str struct {
	S m_ComAmazonawsDynamodbTypes.AttributeValue
}

func (StackValue_Str) isStackValue() {}

func (CompanionStruct_StackValue_) Create_Str_(S m_ComAmazonawsDynamodbTypes.AttributeValue) StackValue {
	return StackValue{StackValue_Str{S}}
}

func (_this StackValue) Is_Str() bool {
	_, ok := _this.Get_().(StackValue_Str)
	return ok
}

type StackValue_DoesNotExist struct {
}

func (StackValue_DoesNotExist) isStackValue() {}

func (CompanionStruct_StackValue_) Create_DoesNotExist_() StackValue {
	return StackValue{StackValue_DoesNotExist{}}
}

func (_this StackValue) Is_DoesNotExist() bool {
	_, ok := _this.Get_().(StackValue_DoesNotExist)
	return ok
}

func (CompanionStruct_StackValue_) Default() StackValue {
	return Companion_StackValue_.Create_Bool_(false)
}

func (_this StackValue) Dtor_b() bool {
	return _this.Get_().(StackValue_Bool).B
}

func (_this StackValue) Dtor_s() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return _this.Get_().(StackValue_Str).S
}

func (_this StackValue) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case StackValue_Bool:
		{
			return "DynamoDBFilterExpr.StackValue.Bool" + "(" + _dafny.String(data.B) + ")"
		}
	case StackValue_Str:
		{
			return "DynamoDBFilterExpr.StackValue.Str" + "(" + _dafny.String(data.S) + ")"
		}
	case StackValue_DoesNotExist:
		{
			return "DynamoDBFilterExpr.StackValue.DoesNotExist"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this StackValue) Equals(other StackValue) bool {
	switch data1 := _this.Get_().(type) {
	case StackValue_Bool:
		{
			data2, ok := other.Get_().(StackValue_Bool)
			return ok && data1.B == data2.B
		}
	case StackValue_Str:
		{
			data2, ok := other.Get_().(StackValue_Str)
			return ok && data1.S.Equals(data2.S)
		}
	case StackValue_DoesNotExist:
		{
			_, ok := other.Get_().(StackValue_DoesNotExist)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this StackValue) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(StackValue)
	return ok && _this.Equals(typed)
}

func Type_StackValue_() _dafny.TypeDescriptor {
	return type_StackValue_{}
}

type type_StackValue_ struct {
}

func (_this type_StackValue_) Default() interface{} {
	return Companion_StackValue_.Default()
}

func (_this type_StackValue_) String() string {
	return "DynamoDBFilterExpr.StackValue"
}
func (_this StackValue) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = StackValue{}

// End of datatype StackValue

// Definition of datatype ExprContext
type ExprContext struct {
	Data_ExprContext_
}

func (_this ExprContext) Get_() Data_ExprContext_ {
	return _this.Data_ExprContext_
}

type Data_ExprContext_ interface {
	isExprContext()
}

type CompanionStruct_ExprContext_ struct {
}

var Companion_ExprContext_ = CompanionStruct_ExprContext_{}

type ExprContext_ExprContext struct {
	KeyExpr    m_Wrappers.Option
	FilterExpr m_Wrappers.Option
	Values     m_Wrappers.Option
	Names      m_Wrappers.Option
}

func (ExprContext_ExprContext) isExprContext() {}

func (CompanionStruct_ExprContext_) Create_ExprContext_(KeyExpr m_Wrappers.Option, FilterExpr m_Wrappers.Option, Values m_Wrappers.Option, Names m_Wrappers.Option) ExprContext {
	return ExprContext{ExprContext_ExprContext{KeyExpr, FilterExpr, Values, Names}}
}

func (_this ExprContext) Is_ExprContext() bool {
	_, ok := _this.Get_().(ExprContext_ExprContext)
	return ok
}

func (CompanionStruct_ExprContext_) Default() ExprContext {
	return Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ExprContext) Dtor_keyExpr() m_Wrappers.Option {
	return _this.Get_().(ExprContext_ExprContext).KeyExpr
}

func (_this ExprContext) Dtor_filterExpr() m_Wrappers.Option {
	return _this.Get_().(ExprContext_ExprContext).FilterExpr
}

func (_this ExprContext) Dtor_values() m_Wrappers.Option {
	return _this.Get_().(ExprContext_ExprContext).Values
}

func (_this ExprContext) Dtor_names() m_Wrappers.Option {
	return _this.Get_().(ExprContext_ExprContext).Names
}

func (_this ExprContext) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExprContext_ExprContext:
		{
			return "DynamoDBFilterExpr.ExprContext.ExprContext" + "(" + _dafny.String(data.KeyExpr) + ", " + _dafny.String(data.FilterExpr) + ", " + _dafny.String(data.Values) + ", " + _dafny.String(data.Names) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExprContext) Equals(other ExprContext) bool {
	switch data1 := _this.Get_().(type) {
	case ExprContext_ExprContext:
		{
			data2, ok := other.Get_().(ExprContext_ExprContext)
			return ok && data1.KeyExpr.Equals(data2.KeyExpr) && data1.FilterExpr.Equals(data2.FilterExpr) && data1.Values.Equals(data2.Values) && data1.Names.Equals(data2.Names)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExprContext) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExprContext)
	return ok && _this.Equals(typed)
}

func Type_ExprContext_() _dafny.TypeDescriptor {
	return type_ExprContext_{}
}

type type_ExprContext_ struct {
}

func (_this type_ExprContext_) Default() interface{} {
	return Companion_ExprContext_.Default()
}

func (_this type_ExprContext_) String() string {
	return "DynamoDBFilterExpr.ExprContext"
}
func (_this ExprContext) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExprContext{}

// End of datatype ExprContext

// Definition of datatype ParsedContext
type ParsedContext struct {
	Data_ParsedContext_
}

func (_this ParsedContext) Get_() Data_ParsedContext_ {
	return _this.Data_ParsedContext_
}

type Data_ParsedContext_ interface {
	isParsedContext()
}

type CompanionStruct_ParsedContext_ struct {
}

var Companion_ParsedContext_ = CompanionStruct_ParsedContext_{}

type ParsedContext_ParsedContext struct {
	Expr   _dafny.Sequence
	Values _dafny.Map
	Names  m_Wrappers.Option
}

func (ParsedContext_ParsedContext) isParsedContext() {}

func (CompanionStruct_ParsedContext_) Create_ParsedContext_(Expr _dafny.Sequence, Values _dafny.Map, Names m_Wrappers.Option) ParsedContext {
	return ParsedContext{ParsedContext_ParsedContext{Expr, Values, Names}}
}

func (_this ParsedContext) Is_ParsedContext() bool {
	_, ok := _this.Get_().(ParsedContext_ParsedContext)
	return ok
}

func (CompanionStruct_ParsedContext_) Default() ParsedContext {
	return Companion_ParsedContext_.Create_ParsedContext_(_dafny.EmptySeq, _dafny.EmptyMap, m_Wrappers.Companion_Option_.Default())
}

func (_this ParsedContext) Dtor_expr() _dafny.Sequence {
	return _this.Get_().(ParsedContext_ParsedContext).Expr
}

func (_this ParsedContext) Dtor_values() _dafny.Map {
	return _this.Get_().(ParsedContext_ParsedContext).Values
}

func (_this ParsedContext) Dtor_names() m_Wrappers.Option {
	return _this.Get_().(ParsedContext_ParsedContext).Names
}

func (_this ParsedContext) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ParsedContext_ParsedContext:
		{
			return "DynamoDBFilterExpr.ParsedContext.ParsedContext" + "(" + _dafny.String(data.Expr) + ", " + _dafny.String(data.Values) + ", " + _dafny.String(data.Names) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ParsedContext) Equals(other ParsedContext) bool {
	switch data1 := _this.Get_().(type) {
	case ParsedContext_ParsedContext:
		{
			data2, ok := other.Get_().(ParsedContext_ParsedContext)
			return ok && data1.Expr.Equals(data2.Expr) && data1.Values.Equals(data2.Values) && data1.Names.Equals(data2.Names)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ParsedContext) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ParsedContext)
	return ok && _this.Equals(typed)
}

func Type_ParsedContext_() _dafny.TypeDescriptor {
	return type_ParsedContext_{}
}

type type_ParsedContext_ struct {
}

func (_this type_ParsedContext_) Default() interface{} {
	return Companion_ParsedContext_.Default()
}

func (_this type_ParsedContext_) String() string {
	return "DynamoDBFilterExpr.ParsedContext"
}
func (_this ParsedContext) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ParsedContext{}

// End of datatype ParsedContext
