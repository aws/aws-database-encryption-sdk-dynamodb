// Package BatchWriteItemTransform
// Dafny module BatchWriteItemTransform compiled into Go

package BatchWriteItemTransform

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
	m_DdbMiddlewareConfig "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbMiddlewareConfig"
	m_DdbStatement "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbStatement"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbVirtualFields"
	m_DynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBFilterExpr"
	m_DynamoDBSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBSupport"
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryption"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptorUtil"
	m_DynamoDbMiddlewareSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbMiddlewareSupport"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbNormalizeNumber"
	m_DynamoDbUpdateExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbUpdateExpr"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoToStruct"
	m_GetItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/GetItemTransform"
	m_InternalLegacyOverride "github.com/aws/aws-database-encryption-sdk-dynamodb/InternalLegacyOverride"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/Maps_"
	m_MemoryMath "github.com/aws/aws-database-encryption-sdk-dynamodb/MemoryMath"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_PutItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/PutItemTransform"
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
	m_UpdateItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/UpdateItemTransform"
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
var _ m_DynamoDBFilterExpr.Dummy__
var _ m_DynamoDBSupport.Dummy__
var _ m_SearchConfigToInfo.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Dummy__
var _ m_DdbMiddlewareConfig.Dummy__
var _ m_DdbStatement.Dummy__
var _ m_DynamoDbMiddlewareSupport.Dummy__
var _ m_PutItemTransform.Dummy__
var _ m_GetItemTransform.Dummy__
var _ m_UpdateItemTransform.Dummy__

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
	return "BatchWriteItemTransform.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Input(config m_DdbMiddlewareConfig.Config, input m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_tableNames _dafny.Set
	_ = _0_tableNames
	_0_tableNames = (((input).Dtor_sdkInput()).Dtor_RequestItems()).Keys()
	var _1_result _dafny.Map
	_ = _1_result
	_1_result = _dafny.NewMapBuilder().ToMap()
	var _2_tableNamesSeq _dafny.Sequence
	_ = _2_tableNamesSeq
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = m_SortedSets.SetToSequence(_0_tableNames)
	_2_tableNamesSeq = _out0
	var _3_i _dafny.Int
	_ = _3_i
	_3_i = _dafny.Zero
	for (_3_i).Cmp(_dafny.IntOfUint32((_2_tableNamesSeq).Cardinality())) < 0 {
		var _4_tableName _dafny.Sequence
		_ = _4_tableName
		_4_tableName = (_2_tableNamesSeq).Select((_3_i).Uint32()).(_dafny.Sequence)
		var _5_writeRequests _dafny.Sequence
		_ = _5_writeRequests
		_5_writeRequests = (((input).Dtor_sdkInput()).Dtor_RequestItems()).Get(_4_tableName).(_dafny.Sequence)
		if !(m_DdbMiddlewareConfig.Companion_Default___.IsPlainWrite(config, _4_tableName)) {
			var _6_tableConfig m_DdbMiddlewareConfig.TableConfig
			_ = _6_tableConfig
			_6_tableConfig = ((config).Dtor_tableEncryptionConfigs()).Get(_4_tableName).(m_DdbMiddlewareConfig.TableConfig)
			var _7_encryptedItems _dafny.Sequence
			_ = _7_encryptedItems
			_7_encryptedItems = _dafny.SeqOf()
			var _hi0 _dafny.Int = _dafny.IntOfUint32((_5_writeRequests).Cardinality())
			_ = _hi0
			for _8_x := _dafny.Zero; _8_x.Cmp(_hi0) < 0; _8_x = _8_x.Plus(_dafny.One) {
				var _9_req m_ComAmazonawsDynamodbTypes.WriteRequest
				_ = _9_req
				_9_req = (_5_writeRequests).Select((_8_x).Uint32()).(m_ComAmazonawsDynamodbTypes.WriteRequest)
				if ((_9_req).Dtor_PutRequest()).Is_None() {
					_7_encryptedItems = _dafny.Companion_Sequence_.Concatenate(_7_encryptedItems, _dafny.SeqOf(_9_req))
				} else {
					var _10_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
					_ = _10_valueOrError0
					_10_valueOrError0 = m_DynamoDbMiddlewareSupport.Companion_Default___.IsWriteable(_6_tableConfig, (((_9_req).Dtor_PutRequest()).Dtor_value().(m_ComAmazonawsDynamodbTypes.PutRequest)).Dtor_Item())
					if (_10_valueOrError0).IsFailure() {
						output = (_10_valueOrError0).PropagateFailure()
						return output
					}
					var _11___v0 bool
					_ = _11___v0
					_11___v0 = (_10_valueOrError0).Extract().(bool)
					var _12_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _12_valueOrError1
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = m_DynamoDbMiddlewareSupport.Companion_Default___.AddSignedBeacons(_6_tableConfig, (((_9_req).Dtor_PutRequest()).Dtor_value().(m_ComAmazonawsDynamodbTypes.PutRequest)).Dtor_Item())
					_12_valueOrError1 = _out1
					if (_12_valueOrError1).IsFailure() {
						output = (_12_valueOrError1).PropagateFailure()
						return output
					}
					var _13_item _dafny.Map
					_ = _13_item
					_13_item = (_12_valueOrError1).Extract().(_dafny.Map)
					var _14_encryptRes m_Wrappers.Result
					_ = _14_encryptRes
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = ((_6_tableConfig).Dtor_itemEncryptor()).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_13_item))
					_14_encryptRes = _out2
					var _15_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemOutput_.Default())
					_ = _15_valueOrError2
					_15_valueOrError2 = m_DdbMiddlewareConfig.Companion_Default___.MapError(_14_encryptRes)
					if (_15_valueOrError2).IsFailure() {
						output = (_15_valueOrError2).PropagateFailure()
						return output
					}
					var _16_encrypted m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput
					_ = _16_encrypted
					_16_encrypted = (_15_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)
					var _17_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_Wrappers.Companion_Option_.Default())
					_ = _17_valueOrError3
					_17_valueOrError3 = m_DynamoDbMiddlewareSupport.Companion_Default___.GetKeyIdFromHeader(_6_tableConfig, _16_encrypted)
					if (_17_valueOrError3).IsFailure() {
						output = (_17_valueOrError3).PropagateFailure()
						return output
					}
					var _18_keyId m_Wrappers.Option
					_ = _18_keyId
					_18_keyId = (_17_valueOrError3).Extract().(m_Wrappers.Option)
					var _19_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _19_valueOrError4
					var _out3 m_Wrappers.Result
					_ = _out3
					_out3 = m_DynamoDbMiddlewareSupport.Companion_Default___.GetEncryptedBeacons(_6_tableConfig, (((_9_req).Dtor_PutRequest()).Dtor_value().(m_ComAmazonawsDynamodbTypes.PutRequest)).Dtor_Item(), m_DynamoDbEncryptionUtil.Companion_Default___.MaybeFromOptionKeyId(_18_keyId))
					_19_valueOrError4 = _out3
					if (_19_valueOrError4).IsFailure() {
						output = (_19_valueOrError4).PropagateFailure()
						return output
					}
					var _20_beaconAttrs _dafny.Map
					_ = _20_beaconAttrs
					_20_beaconAttrs = (_19_valueOrError4).Extract().(_dafny.Map)
					var _pat_let_tv0 = _16_encrypted
					_ = _pat_let_tv0
					var _pat_let_tv1 = _20_beaconAttrs
					_ = _pat_let_tv1
					_7_encryptedItems = _dafny.Companion_Sequence_.Concatenate(_7_encryptedItems, _dafny.SeqOf(func(_pat_let31_0 m_ComAmazonawsDynamodbTypes.WriteRequest) m_ComAmazonawsDynamodbTypes.WriteRequest {
						return func(_21_dt__update__tmp_h0 m_ComAmazonawsDynamodbTypes.WriteRequest) m_ComAmazonawsDynamodbTypes.WriteRequest {
							return func(_pat_let32_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.WriteRequest {
								return func(_22_dt__update_hPutRequest_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.WriteRequest {
									return m_ComAmazonawsDynamodbTypes.Companion_WriteRequest_.Create_WriteRequest_(_22_dt__update_hPutRequest_h0, (_21_dt__update__tmp_h0).Dtor_DeleteRequest())
								}(_pat_let32_0)
							}(m_Wrappers.Companion_Option_.Create_Some_(m_ComAmazonawsDynamodbTypes.Companion_PutRequest_.Create_PutRequest_(((_pat_let_tv0).Dtor_encryptedItem()).Merge(_pat_let_tv1))))
						}(_pat_let31_0)
					}(_9_req)))
				}
			}
			_5_writeRequests = _7_encryptedItems
		}
		_3_i = (_3_i).Plus(_dafny.One)
		_1_result = (_1_result).Update(_4_tableName, _5_writeRequests)
	}
	var _23_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _23_valueOrError5
	_23_valueOrError5 = m_Wrappers.Companion_Default___.Need(((_1_result).Cardinality()).Cmp((((input).Dtor_sdkInput()).Dtor_RequestItems()).Cardinality()) == 0, m_DdbMiddlewareConfig.Companion_Default___.E(_dafny.SeqOfString("Internal Error")))
	if (_23_valueOrError5).IsFailure() {
		output = (_23_valueOrError5).PropagateFailure()
		return output
	}
	var _pat_let_tv2 = _1_result
	_ = _pat_let_tv2
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemInputTransformOutput_.Create_BatchWriteItemInputTransformOutput_(func(_pat_let33_0 m_ComAmazonawsDynamodbTypes.BatchWriteItemInput) m_ComAmazonawsDynamodbTypes.BatchWriteItemInput {
		return func(_24_dt__update__tmp_h1 m_ComAmazonawsDynamodbTypes.BatchWriteItemInput) m_ComAmazonawsDynamodbTypes.BatchWriteItemInput {
			return func(_pat_let34_0 _dafny.Map) m_ComAmazonawsDynamodbTypes.BatchWriteItemInput {
				return func(_25_dt__update_hRequestItems_h0 _dafny.Map) m_ComAmazonawsDynamodbTypes.BatchWriteItemInput {
					return m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Create_BatchWriteItemInput_(_25_dt__update_hRequestItems_h0, (_24_dt__update__tmp_h1).Dtor_ReturnConsumedCapacity(), (_24_dt__update__tmp_h1).Dtor_ReturnItemCollectionMetrics())
				}(_pat_let34_0)
			}(_pat_let_tv2)
		}(_pat_let33_0)
	}((input).Dtor_sdkInput())))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOrigItem(tableConfig m_DdbMiddlewareConfig.TableConfig, srcRequests _dafny.Sequence, itemReq m_ComAmazonawsDynamodbTypes.WriteRequest) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_WriteRequest_.Default())
	_ = ret
	var _0_partKey _dafny.Sequence
	_ = _0_partKey
	_0_partKey = (tableConfig).Dtor_partitionKeyName()
	var _1_sortKey m_Wrappers.Option
	_ = _1_sortKey
	_1_sortKey = (tableConfig).Dtor_sortKeyName()
	var _2_item _dafny.Map
	_ = _2_item
	_2_item = (((itemReq).Dtor_PutRequest()).Dtor_value().(m_ComAmazonawsDynamodbTypes.PutRequest)).Dtor_Item()
	var _3_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError0
	_3_valueOrError0 = m_Wrappers.Companion_Default___.Need((_2_item).Contains(_0_partKey), m_DdbMiddlewareConfig.Companion_Default___.E(_dafny.SeqOfString("Required partition key not in unprocessed item")))
	if (_3_valueOrError0).IsFailure() {
		ret = (_3_valueOrError0).PropagateFailure()
		return ret
	}
	var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError1
	_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_1_sortKey).Is_None()) || ((_2_item).Contains((_1_sortKey).Dtor_value().(_dafny.Sequence))), m_DdbMiddlewareConfig.Companion_Default___.E(_dafny.SeqOfString("Required sort key not in unprocessed item")))
	if (_4_valueOrError1).IsFailure() {
		ret = (_4_valueOrError1).PropagateFailure()
		return ret
	}
	var _hi0 _dafny.Int = _dafny.IntOfUint32((srcRequests).Cardinality())
	_ = _hi0
	for _5_i := _dafny.Zero; _5_i.Cmp(_hi0) < 0; _5_i = _5_i.Plus(_dafny.One) {
		if (((srcRequests).Select((_5_i).Uint32()).(m_ComAmazonawsDynamodbTypes.WriteRequest)).Dtor_PutRequest()).Is_Some() {
			var _6_req _dafny.Map
			_ = _6_req
			_6_req = ((((srcRequests).Select((_5_i).Uint32()).(m_ComAmazonawsDynamodbTypes.WriteRequest)).Dtor_PutRequest()).Dtor_value().(m_ComAmazonawsDynamodbTypes.PutRequest)).Dtor_Item()
			if ((_6_req).Contains(_0_partKey)) && (((_6_req).Get(_0_partKey).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_2_item).Get(_0_partKey).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
				if ((_1_sortKey).Is_None()) || (((_6_req).Contains((_1_sortKey).Dtor_value().(_dafny.Sequence))) && (((_6_req).Get((_1_sortKey).Dtor_value().(_dafny.Sequence)).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_2_item).Get((_1_sortKey).Dtor_value().(_dafny.Sequence)).(m_ComAmazonawsDynamodbTypes.AttributeValue)))) {
					ret = m_Wrappers.Companion_Result_.Create_Success_((srcRequests).Select((_5_i).Uint32()).(m_ComAmazonawsDynamodbTypes.WriteRequest))
					return ret
				}
			}
		}
	}
	ret = m_Wrappers.Companion_Result_.Create_Failure_(m_DdbMiddlewareConfig.Companion_Default___.E(_dafny.SeqOfString("Item in UnprocessedItems not found in original request.")))
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) Output(config m_DdbMiddlewareConfig.Config, input m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformOutput_.Default())
	_ = output
	if (((input).Dtor_sdkOutput()).Dtor_UnprocessedItems()).Is_None() {
		output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformOutput_.Create_BatchWriteItemOutputTransformOutput_((input).Dtor_sdkOutput()))
		return output
	}
	var _0_srcItems _dafny.Map
	_ = _0_srcItems
	_0_srcItems = ((input).Dtor_originalInput()).Dtor_RequestItems()
	var _1_unprocessed _dafny.Map
	_ = _1_unprocessed
	_1_unprocessed = (((input).Dtor_sdkOutput()).Dtor_UnprocessedItems()).Dtor_value().(_dafny.Map)
	var _2_tableNames _dafny.Set
	_ = _2_tableNames
	_2_tableNames = (_1_unprocessed).Keys()
	var _3_result _dafny.Map
	_ = _3_result
	_3_result = _dafny.NewMapBuilder().ToMap()
	var _4_tableNamesSeq _dafny.Sequence
	_ = _4_tableNamesSeq
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = m_SortedSets.SetToSequence(_2_tableNames)
	_4_tableNamesSeq = _out0
	var _5_i _dafny.Int
	_ = _5_i
	_5_i = _dafny.Zero
	for (_5_i).Cmp(_dafny.IntOfUint32((_4_tableNamesSeq).Cardinality())) < 0 {
		var _6_tableName _dafny.Sequence
		_ = _6_tableName
		_6_tableName = (_4_tableNamesSeq).Select((_5_i).Uint32()).(_dafny.Sequence)
		var _7_writeRequests _dafny.Sequence
		_ = _7_writeRequests
		_7_writeRequests = (_1_unprocessed).Get(_6_tableName).(_dafny.Sequence)
		if !(m_DdbMiddlewareConfig.Companion_Default___.IsPlainWrite(config, _6_tableName)) {
			if !(_0_srcItems).Contains(_6_tableName) {
				output = m_Wrappers.Companion_Result_.Create_Failure_(m_DdbMiddlewareConfig.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_6_tableName, _dafny.SeqOfString(" in UnprocessedItems for BatchWriteItem response, but not in original request."))))
				return output
			}
			var _8_srcRequests _dafny.Sequence
			_ = _8_srcRequests
			_8_srcRequests = (_0_srcItems).Get(_6_tableName).(_dafny.Sequence)
			var _9_tableConfig m_DdbMiddlewareConfig.TableConfig
			_ = _9_tableConfig
			_9_tableConfig = ((config).Dtor_tableEncryptionConfigs()).Get(_6_tableName).(m_DdbMiddlewareConfig.TableConfig)
			var _10_origItems _dafny.Sequence
			_ = _10_origItems
			_10_origItems = _dafny.SeqOf()
			var _hi0 _dafny.Int = _dafny.IntOfUint32((_7_writeRequests).Cardinality())
			_ = _hi0
			for _11_x := _dafny.Zero; _11_x.Cmp(_hi0) < 0; _11_x = _11_x.Plus(_dafny.One) {
				var _12_req m_ComAmazonawsDynamodbTypes.WriteRequest
				_ = _12_req
				_12_req = (_7_writeRequests).Select((_11_x).Uint32()).(m_ComAmazonawsDynamodbTypes.WriteRequest)
				if ((_12_req).Dtor_PutRequest()).Is_None() {
					_10_origItems = _dafny.Companion_Sequence_.Concatenate(_10_origItems, _dafny.SeqOf(_12_req))
				} else {
					var _13_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_WriteRequest_.Default())
					_ = _13_valueOrError0
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetOrigItem(_9_tableConfig, _8_srcRequests, _12_req)
					_13_valueOrError0 = _out1
					if (_13_valueOrError0).IsFailure() {
						output = (_13_valueOrError0).PropagateFailure()
						return output
					}
					var _14_orig__item m_ComAmazonawsDynamodbTypes.WriteRequest
					_ = _14_orig__item
					_14_orig__item = (_13_valueOrError0).Extract().(m_ComAmazonawsDynamodbTypes.WriteRequest)
					_10_origItems = _dafny.Companion_Sequence_.Concatenate(_10_origItems, _dafny.SeqOf(_14_orig__item))
				}
			}
			_7_writeRequests = _10_origItems
		}
		_5_i = (_5_i).Plus(_dafny.One)
		_3_result = (_3_result).Update(_6_tableName, _7_writeRequests)
	}
	var _15_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _15_valueOrError1
	_15_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_3_result).Cardinality()).Cmp((_1_unprocessed).Cardinality()) == 0, m_DdbMiddlewareConfig.Companion_Default___.E(_dafny.SeqOfString("Internal Error")))
	if (_15_valueOrError1).IsFailure() {
		output = (_15_valueOrError1).PropagateFailure()
		return output
	}
	var _16_new__output m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
	_ = _16_new__output
	var _17_dt__update__tmp_h0 m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput = (input).Dtor_sdkOutput()
	_ = _17_dt__update__tmp_h0
	var _18_dt__update_hUnprocessedItems_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_3_result)
	_ = _18_dt__update_hUnprocessedItems_h0
	_16_new__output = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Create_BatchWriteItemOutput_(_18_dt__update_hUnprocessedItems_h0, (_17_dt__update__tmp_h0).Dtor_ItemCollectionMetrics(), (_17_dt__update__tmp_h0).Dtor_ConsumedCapacity())
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformOutput_.Create_BatchWriteItemOutputTransformOutput_(_16_new__output))
	return output
	return output
}

// End of class Default__
