// Package DdbMiddlewareConfig
// Dafny module DdbMiddlewareConfig compiled into Go

package DdbMiddlewareConfig

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
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/BaseBeacon"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m_CompoundBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/CompoundBeacon"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbVirtualFields"
	m_DynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBFilterExpr"
	m_DynamoDBSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBSupport"
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
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_SearchConfigToInfo "github.com/aws/aws-database-encryption-sdk-dynamodb/SearchConfigToInfo"
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
var _ m_TermLoc.Dummy__
var _ m_DdbVirtualFields.Dummy__
var _ m_DynamoDbUpdateExpr.Dummy__
var _ m_BaseBeacon.Dummy__
var _ m_CompoundBeacon.Dummy__
var _ m_SearchableEncryptionInfo.Dummy__
var _ m_DynamoDBFilterExpr.Dummy__
var _ m_DynamoDBSupport.Dummy__
var _ m_SearchConfigToInfo.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Dummy__

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
	return "DdbMiddlewareConfig.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsPlainWrite(config Config, tableName _dafny.Sequence) bool {
	return (!((config).Dtor_tableEncryptionConfigs()).Contains(tableName)) || (((((config).Dtor_tableEncryptionConfigs()).Get(tableName).(TableConfig)).Dtor_plaintextOverride()).Equals(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_()))
}
func (_static *CompanionStruct_Default___) AttrToString(attr m_ComAmazonawsDynamodbTypes.AttributeValue) _dafny.Sequence {
	if (attr).Is_S() {
		return (attr).Dtor_S()
	} else if (attr).Is_N() {
		return (attr).Dtor_N()
	} else if (attr).Is_B() {
		return m_HexStrings.Companion_Default___.ToHexString((attr).Dtor_B())
	} else {
		return _dafny.SeqOfString("unexpected key type")
	}
}
func (_static *CompanionStruct_Default___) KeyString(config TableConfig, item _dafny.Map) _dafny.Sequence {
	var _0_partition _dafny.Sequence = (func() _dafny.Sequence {
		if (item).Contains((config).Dtor_partitionKeyName()) {
			return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((config).Dtor_partitionKeyName(), _dafny.SeqOfString(" = ")), Companion_Default___.AttrToString((item).Get((config).Dtor_partitionKeyName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)))
		}
		return _dafny.SeqOfString("")
	})()
	_ = _0_partition
	var _1_sort _dafny.Sequence = (func() _dafny.Sequence {
		if (((config).Dtor_sortKeyName()).Is_Some()) && ((item).Contains(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence))) {
			return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("; "), ((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString(" = ")), Companion_Default___.AttrToString((item).Get(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)).(m_ComAmazonawsDynamodbTypes.AttributeValue)))
		}
		return _dafny.SeqOfString("")
	})()
	_ = _1_sort
	return _dafny.Companion_Sequence_.Concatenate(_0_partition, _1_sort)
}
func (_static *CompanionStruct_Default___) MapError(r m_Wrappers.Result) m_Wrappers.Result {
	return (r).MapFailure(func(coer145 func(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error) func(interface{}) interface{} {
		return func(arg183 interface{}) interface{} {
			return coer145(arg183.(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error))
		}
	}(func(_0_e m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor_(_0_e)
	}))
}
func (_static *CompanionStruct_Default___) MapString(r m_Wrappers.Result) m_Wrappers.Result {
	return (r).MapFailure(func(coer146 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error) func(interface{}) interface{} {
		return func(arg184 interface{}) interface{} {
			return coer146(arg184.(_dafny.Sequence))
		}
	}(func(_0_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_Error_.Create_DynamoDbEncryptionTransformsException_(_0_e)
	}))
}
func (_static *CompanionStruct_Default___) E(s _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_Error_.Create_DynamoDbEncryptionTransformsException_(s)
}
func (_static *CompanionStruct_Default___) MakeError(s _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_Error_.Create_DynamoDbEncryptionTransformsException_(s))
}

// End of class Default__

// Definition of datatype TableConfig
type TableConfig struct {
	Data_TableConfig_
}

func (_this TableConfig) Get_() Data_TableConfig_ {
	return _this.Data_TableConfig_
}

type Data_TableConfig_ interface {
	isTableConfig()
}

type CompanionStruct_TableConfig_ struct {
}

var Companion_TableConfig_ = CompanionStruct_TableConfig_{}

type TableConfig_TableConfig struct {
	PhysicalTableName _dafny.Sequence
	LogicalTableName  _dafny.Sequence
	PartitionKeyName  _dafny.Sequence
	SortKeyName       m_Wrappers.Option
	ItemEncryptor     *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	Search            m_Wrappers.Option
	PlaintextOverride m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride
}

func (TableConfig_TableConfig) isTableConfig() {}

func (CompanionStruct_TableConfig_) Create_TableConfig_(PhysicalTableName _dafny.Sequence, LogicalTableName _dafny.Sequence, PartitionKeyName _dafny.Sequence, SortKeyName m_Wrappers.Option, ItemEncryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient, Search m_Wrappers.Option, PlaintextOverride m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride) TableConfig {
	return TableConfig{TableConfig_TableConfig{PhysicalTableName, LogicalTableName, PartitionKeyName, SortKeyName, ItemEncryptor, Search, PlaintextOverride}}
}

func (_this TableConfig) Is_TableConfig() bool {
	_, ok := _this.Get_().(TableConfig_TableConfig)
	return ok
}

func (CompanionStruct_TableConfig_) Default() TableConfig {
	return Companion_TableConfig_.Create_TableConfig_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), (*m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)(nil), m_Wrappers.Companion_Option_.Default(), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Default())
}

func (_this TableConfig) Dtor_physicalTableName() _dafny.Sequence {
	return _this.Get_().(TableConfig_TableConfig).PhysicalTableName
}

func (_this TableConfig) Dtor_logicalTableName() _dafny.Sequence {
	return _this.Get_().(TableConfig_TableConfig).LogicalTableName
}

func (_this TableConfig) Dtor_partitionKeyName() _dafny.Sequence {
	return _this.Get_().(TableConfig_TableConfig).PartitionKeyName
}

func (_this TableConfig) Dtor_sortKeyName() m_Wrappers.Option {
	return _this.Get_().(TableConfig_TableConfig).SortKeyName
}

func (_this TableConfig) Dtor_itemEncryptor() *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient {
	return _this.Get_().(TableConfig_TableConfig).ItemEncryptor
}

func (_this TableConfig) Dtor_search() m_Wrappers.Option {
	return _this.Get_().(TableConfig_TableConfig).Search
}

func (_this TableConfig) Dtor_plaintextOverride() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride {
	return _this.Get_().(TableConfig_TableConfig).PlaintextOverride
}

func (_this TableConfig) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TableConfig_TableConfig:
		{
			return "DdbMiddlewareConfig.TableConfig.TableConfig" + "(" + _dafny.String(data.PhysicalTableName) + ", " + _dafny.String(data.LogicalTableName) + ", " + _dafny.String(data.PartitionKeyName) + ", " + _dafny.String(data.SortKeyName) + ", " + _dafny.String(data.ItemEncryptor) + ", " + _dafny.String(data.Search) + ", " + _dafny.String(data.PlaintextOverride) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TableConfig) Equals(other TableConfig) bool {
	switch data1 := _this.Get_().(type) {
	case TableConfig_TableConfig:
		{
			data2, ok := other.Get_().(TableConfig_TableConfig)
			return ok && data1.PhysicalTableName.Equals(data2.PhysicalTableName) && data1.LogicalTableName.Equals(data2.LogicalTableName) && data1.PartitionKeyName.Equals(data2.PartitionKeyName) && data1.SortKeyName.Equals(data2.SortKeyName) && data1.ItemEncryptor == data2.ItemEncryptor && data1.Search.Equals(data2.Search) && data1.PlaintextOverride.Equals(data2.PlaintextOverride)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TableConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TableConfig)
	return ok && _this.Equals(typed)
}

func Type_TableConfig_() _dafny.TypeDescriptor {
	return type_TableConfig_{}
}

type type_TableConfig_ struct {
}

func (_this type_TableConfig_) Default() interface{} {
	return Companion_TableConfig_.Default()
}

func (_this type_TableConfig_) String() string {
	return "DdbMiddlewareConfig.TableConfig"
}
func (_this TableConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TableConfig{}

// End of datatype TableConfig

// Definition of class ValidTableConfig
type ValidTableConfig struct {
}

func New_ValidTableConfig_() *ValidTableConfig {
	_this := ValidTableConfig{}

	return &_this
}

type CompanionStruct_ValidTableConfig_ struct {
}

var Companion_ValidTableConfig_ = CompanionStruct_ValidTableConfig_{}

func (*ValidTableConfig) String() string {
	return "DdbMiddlewareConfig.ValidTableConfig"
}

// End of class ValidTableConfig

func Type_ValidTableConfig_() _dafny.TypeDescriptor {
	return type_ValidTableConfig_{}
}

type type_ValidTableConfig_ struct {
}

func (_this type_ValidTableConfig_) Default() interface{} {
	return Companion_TableConfig_.Default()
}

func (_this type_ValidTableConfig_) String() string {
	return "DdbMiddlewareConfig.ValidTableConfig"
}

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
	TableEncryptionConfigs _dafny.Map
}

func (Config_Config) isConfig() {}

func (CompanionStruct_Config_) Create_Config_(TableEncryptionConfigs _dafny.Map) Config {
	return Config{Config_Config{TableEncryptionConfigs}}
}

func (_this Config) Is_Config() bool {
	_, ok := _this.Get_().(Config_Config)
	return ok
}

func (CompanionStruct_Config_) Default() Config {
	return Companion_Config_.Create_Config_(_dafny.EmptyMap)
}

func (_this Config) Dtor_tableEncryptionConfigs() _dafny.Map {
	return _this.Get_().(Config_Config).TableEncryptionConfigs
}

func (_this Config) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Config_Config:
		{
			return "DdbMiddlewareConfig.Config.Config" + "(" + _dafny.String(data.TableEncryptionConfigs) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Config) Equals(other Config) bool {
	switch data1 := _this.Get_().(type) {
	case Config_Config:
		{
			data2, ok := other.Get_().(Config_Config)
			return ok && data1.TableEncryptionConfigs.Equals(data2.TableEncryptionConfigs)
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
	return "DdbMiddlewareConfig.Config"
}
func (_this Config) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Config{}

// End of datatype Config
