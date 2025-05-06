// Package TestHeader
// Dafny module TestHeader compiled into Go

package TestHeader

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
	m_AttributeResolver "github.com/aws/aws-database-encryption-sdk-dynamodb/AttributeResolver"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/BaseBeacon"
	m_BatchExecuteStatementTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/BatchExecuteStatementTransform"
	m_BatchGetItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/BatchGetItemTransform"
	m_BatchWriteItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/BatchWriteItemTransform"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m_CompoundBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/CompoundBeacon"
	m_DdbMiddlewareConfig "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbMiddlewareConfig"
	m_DdbStatement "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbStatement"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbVirtualFields"
	m_DeleteItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/DeleteItemTransform"
	m_DynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBFilterExpr"
	m_DynamoDBSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBSupport"
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryption"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionTransforms "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionTransforms"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptorUtil"
	m_DynamoDbMiddlewareSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbMiddlewareSupport"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbNormalizeNumber"
	m_DynamoDbUpdateExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbUpdateExpr"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoToStruct"
	m_ExecuteStatementTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/ExecuteStatementTransform"
	m_ExecuteTransactionTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/ExecuteTransactionTransform"
	m_GetItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/GetItemTransform"
	m_InternalLegacyOverride "github.com/aws/aws-database-encryption-sdk-dynamodb/InternalLegacyOverride"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/Maps_"
	m_MemoryMath "github.com/aws/aws-database-encryption-sdk-dynamodb/MemoryMath"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_PutItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/PutItemTransform"
	m_QueryTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/QueryTransform"
	m_ScanTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/ScanTransform"
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
	m_TransactGetItemsTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/TransactGetItemsTransform"
	m_TransactWriteItemsTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/TransactWriteItemsTransform"
	m_UpdateItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/UpdateItemTransform"
	m_HappyCaseTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/HappyCaseTests"
	m_PathsTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PathsTests"
	m_StructuredDataTestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/StructuredDataTestFixtures"
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
var _ m_ComAmazonawsDynamodbTypes.Dummy__
var _ m_ComAmazonawsKmsTypes.Dummy__
var _ m_AwsCryptographyKeyStoreTypes.Dummy__
var _ m_AwsCryptographyPrimitivesTypes.Dummy__
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Base64.Dummy__
var _ m_StructuredEncryptionUtil.Dummy__
var _ m_DynamoDbEncryptionUtil.Dummy__
var _ m_DynamoDbNormalizeNumber.Dummy__
var _ m_MemoryMath.Dummy__
var _ m_DynamoToStruct.Dummy__
var _ m_DynamoDbItemEncryptorUtil.Dummy__
var _ m_DynamoDbEncryptionBranchKeyIdSupplier.Dummy__
var _ m_Actions.Dummy__
var _ m_Random.Dummy__
var _ m_Digest.Dummy__
var _ m_WrappedHMAC.Dummy__
var _ m_HKDF.Dummy__
var _ m_WrappedHKDF.Dummy__
var _ m_KdfCtr.Dummy__
var _ m_AwsCryptographyPrimitivesOperations.Dummy__
var _ m_AtomicPrimitives.Dummy__
var _ m_Materials.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_Functions.Dummy__
var _ m_Sets.Dummy__
var _ m_StructuredEncryptionPaths.Dummy__
var _ m_Keyring.Dummy__
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
var _ m_StructuredEncryptionHeader.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbOperations.Dummy__
var _ m_DynamoDbEncryption.Dummy__
var _ m_StructuredEncryptionFooter.Dummy__
var _ m_OptimizedMergeSort.Dummy__
var _ m_SortCanon.Dummy__
var _ m_Canonize.Dummy__
var _ m_StructuredEncryptionCrypt.Dummy__
var _ m__Maps.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Dummy__
var _ m_StructuredEncryption.Dummy__
var _ m_InternalLegacyOverride.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Dummy__
var _ m_DynamoDbItemEncryptor.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Dummy__
var _ m_HexStrings.Dummy__
var _ m_TermLoc.Dummy__
var _ m_DdbVirtualFields.Dummy__
var _ m_BaseBeacon.Dummy__
var _ m_CompoundBeacon.Dummy__
var _ m_SearchableEncryptionInfo.Dummy__
var _ m_DdbMiddlewareConfig.Dummy__
var _ m_DdbStatement.Dummy__
var _ m_DynamoDbUpdateExpr.Dummy__
var _ m_FloatCompare.Dummy__
var _ m_DynamoDBFilterExpr.Dummy__
var _ m_DynamoDBSupport.Dummy__
var _ m_DynamoDbMiddlewareSupport.Dummy__
var _ m_PutItemTransform.Dummy__
var _ m_GetItemTransform.Dummy__
var _ m_UpdateItemTransform.Dummy__
var _ m_BatchWriteItemTransform.Dummy__
var _ m_TransactWriteItemsTransform.Dummy__
var _ m_BatchGetItemTransform.Dummy__
var _ m_ScanTransform.Dummy__
var _ m_QueryTransform.Dummy__
var _ m_TransactGetItemsTransform.Dummy__
var _ m_DeleteItemTransform.Dummy__
var _ m_ExecuteStatementTransform.Dummy__
var _ m_BatchExecuteStatementTransform.Dummy__
var _ m_ExecuteTransactionTransform.Dummy__
var _ m_AttributeResolver.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations.Dummy__
var _ m_SearchConfigToInfo.Dummy__
var _ m_DynamoDbEncryptionTransforms.Dummy__
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
var _ m_GetOpt.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_StructuredDataTestFixtures.Dummy__
var _ m_HappyCaseTests.Dummy__
var _ m_PathsTests.Dummy__

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
	return "TestHeader.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) TestRoundTrip() {
	var _0_head m_StructuredEncryptionHeader.PartialHeader
	_ = _0_head
	_0_head = m_StructuredEncryptionHeader.Companion_PartialHeader_.Create_PartialHeader_(uint8(1), uint8(1), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(6), uint8(7), uint8(8), uint8(9), uint8(10), uint8(11), uint8(12), uint8(13), uint8(14), uint8(15), uint8(16), uint8(17), uint8(18), uint8(19), uint8(20), uint8(21), uint8(22), uint8(23), uint8(24), uint8(25), uint8(26), uint8(27), uint8(28), uint8(29), uint8(30), uint8(31), uint8(32)), _dafny.SeqOf(uint8(101), uint8(115)), _dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.Abc(), Companion_Default___.Def()), _dafny.SeqOf(m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(Companion_Default___.ProvID(), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOf(uint8(6), uint8(7), uint8(8), uint8(9)))))
	var _1_ser _dafny.Sequence
	_ = _1_ser
	_1_ser = _dafny.Companion_Sequence_.Concatenate((_0_head).Serialize(), (_0_head).Dtor_msgID())
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	_2_valueOrError0 = m_StructuredEncryptionHeader.Companion_Default___.PartialDeserialize(_1_ser)
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(63,16): " + (_2_valueOrError0).String())
	}
	var _3_orig m_StructuredEncryptionHeader.PartialHeader
	_ = _3_orig
	_3_orig = (_2_valueOrError0).Extract().(m_StructuredEncryptionHeader.PartialHeader)
	if !((_3_orig).Equals(_0_head)) {
		panic("dafny/StructuredEncryption/test/Header.dfy(64,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestRoundTripWithCommit() {
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(68,18): " + (_0_valueOrError0).String())
	}
	var _1_client *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _1_client
	_1_client = (_0_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _2_head m_StructuredEncryptionHeader.PartialHeader
	_ = _2_head
	_2_head = m_StructuredEncryptionHeader.Companion_PartialHeader_.Create_PartialHeader_(uint8(1), uint8(1), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(6), uint8(7), uint8(8), uint8(9), uint8(10), uint8(11), uint8(12), uint8(13), uint8(14), uint8(15), uint8(16), uint8(17), uint8(18), uint8(19), uint8(20), uint8(21), uint8(22), uint8(23), uint8(24), uint8(25), uint8(26), uint8(27), uint8(28), uint8(29), uint8(30), uint8(31), uint8(32)), _dafny.SeqOf(uint8(101), uint8(115)), _dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.Abc(), Companion_Default___.Def()), _dafny.SeqOf(m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(Companion_Default___.ProvID(), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOf(uint8(6), uint8(7), uint8(8), uint8(9)))))
	var _3_key _dafny.Sequence
	_ = _3_key
	_3_key = (_2_head).Dtor_msgID()
	var _4_alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	_ = _4_alg
	_4_alg = m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _5_valueOrError1
	_5_valueOrError1 = m_StructuredEncryptionHeader.Companion_Default___.Serialize(_1_client, _4_alg, _3_key, _2_head)
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(82,15): " + (_5_valueOrError1).String())
	}
	var _6_ser _dafny.Sequence
	_ = _6_ser
	_6_ser = (_5_valueOrError1).Extract().(_dafny.Sequence)
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError2
	_7_valueOrError2 = m_StructuredEncryptionHeader.Companion_Default___.PartialDeserialize(_6_ser)
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(83,16): " + (_7_valueOrError2).String())
	}
	var _8_orig m_StructuredEncryptionHeader.PartialHeader
	_ = _8_orig
	_8_orig = (_7_valueOrError2).Extract().(m_StructuredEncryptionHeader.PartialHeader)
	if !((_8_orig).Equals(_2_head)) {
		panic("dafny/StructuredEncryption/test/Header.dfy(84,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = _9_valueOrError3
	_9_valueOrError3 = (_2_head).VerifyCommitment(_1_client, _4_alg, _3_key, _6_ser)
	if !(!((_9_valueOrError3).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(85,22): " + (_9_valueOrError3).String())
	}
	var _10_goodResult bool
	_ = _10_goodResult
	_10_goodResult = (_9_valueOrError3).Extract().(bool)
	var _11_lastByte uint8
	_ = _11_lastByte
	_11_lastByte = (_6_ser).Select(((_dafny.IntOfUint32((_6_ser).Cardinality())).Minus(_dafny.One)).Uint32()).(uint8)
	var _12_badByte uint8
	_ = _12_badByte
	if (_11_lastByte) == (uint8(0)) {
		_12_badByte = uint8(255)
	} else {
		_12_badByte = (_11_lastByte) - (func() uint8 { return (uint8(1)) })()
	}
	var _13_badSer _dafny.Sequence
	_ = _13_badSer
	_13_badSer = _dafny.Companion_Sequence_.Concatenate((_6_ser).Take(((_dafny.IntOfUint32((_6_ser).Cardinality())).Minus(_dafny.One)).Uint32()), _dafny.SeqOf(_12_badByte))
	var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _14_valueOrError4
	_14_valueOrError4 = m_StructuredEncryptionHeader.Companion_Default___.PartialDeserialize(_13_badSer)
	if !(!((_14_valueOrError4).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(90,17): " + (_14_valueOrError4).String())
	}
	var _15_head2 m_StructuredEncryptionHeader.PartialHeader
	_ = _15_head2
	_15_head2 = (_14_valueOrError4).Extract().(m_StructuredEncryptionHeader.PartialHeader)
	if !((_15_head2).Equals(_2_head)) {
		panic("dafny/StructuredEncryption/test/Header.dfy(91,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _16_badResult m_Wrappers.Result
	_ = _16_badResult
	_16_badResult = (_2_head).VerifyCommitment(_1_client, _4_alg, _3_key, _13_badSer)
	if !((_16_badResult).Is_Failure()) {
		panic("dafny/StructuredEncryption/test/Header.dfy(94,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_16_badResult).Dtor_error().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error)).Equals(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Key commitment mismatch.")))) {
		panic("dafny/StructuredEncryption/test/Header.dfy(95,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestDuplicateContext() {
	var _0_cont _dafny.Map
	_ = _0_cont
	_0_cont = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.Abc(), Companion_Default___.Def()).UpdateUnsafe(Companion_Default___.Cba(), Companion_Default___.Fed())
	var _1_serCont _dafny.Sequence
	_ = _1_serCont
	_1_serCont = m_StructuredEncryptionHeader.Companion_Default___.SerializeContext(_0_cont)
	if !(_dafny.Companion_Sequence_.Equal(_1_serCont, _dafny.SeqOf(uint8(0), uint8(2), uint8(0), uint8(3), Companion_Default___.A(), Companion_Default___.B(), Companion_Default___.C(), uint8(0), uint8(3), Companion_Default___.D(), Companion_Default___.E(), Companion_Default___.F(), uint8(0), uint8(3), Companion_Default___.C(), Companion_Default___.B(), Companion_Default___.A(), uint8(0), uint8(3), Companion_Default___.F(), Companion_Default___.E(), Companion_Default___.D()))) {
		panic("dafny/StructuredEncryption/test/Header.dfy(107,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _2_newCont m_Wrappers.Result
	_ = _2_newCont
	_2_newCont = m_StructuredEncryptionHeader.Companion_Default___.GetContext(_1_serCont)
	if !((_2_newCont).Is_Success()) {
		panic("dafny/StructuredEncryption/test/Header.dfy(115,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((*((_2_newCont).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(_dafny.Map)).Equals(_0_cont)) {
		panic("dafny/StructuredEncryption/test/Header.dfy(116,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((*((_2_newCont).Dtor_value().(_dafny.Tuple)).IndexInt(1)).(_dafny.Int)).Cmp(_dafny.IntOfUint32((_1_serCont).Cardinality())) == 0) {
		panic("dafny/StructuredEncryption/test/Header.dfy(117,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_badSerCont _dafny.Sequence
	_ = _3_badSerCont
	_3_badSerCont = _dafny.SeqOf(uint8(0), uint8(3), uint8(0), uint8(3), Companion_Default___.A(), Companion_Default___.B(), Companion_Default___.C(), uint8(0), uint8(3), Companion_Default___.D(), Companion_Default___.E(), Companion_Default___.F(), uint8(0), uint8(3), Companion_Default___.C(), Companion_Default___.B(), Companion_Default___.A(), uint8(0), uint8(3), Companion_Default___.F(), Companion_Default___.E(), Companion_Default___.D(), uint8(0), uint8(3), Companion_Default___.A(), Companion_Default___.B(), Companion_Default___.C(), uint8(0), uint8(3), Companion_Default___.E(), Companion_Default___.D(), Companion_Default___.F())
	var _4_newBadCont m_Wrappers.Result
	_ = _4_newBadCont
	_4_newBadCont = m_StructuredEncryptionHeader.Companion_Default___.GetContext(_3_badSerCont)
	if !((_4_newBadCont).Equals(m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Context keys out of order."))))) {
		panic("dafny/StructuredEncryption/test/Header.dfy(132,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestOutOfOrderContext() {
	var _0_badSerCont _dafny.Sequence
	_ = _0_badSerCont
	_0_badSerCont = _dafny.SeqOf(uint8(0), uint8(2), uint8(0), uint8(3), Companion_Default___.C(), Companion_Default___.B(), Companion_Default___.A(), uint8(0), uint8(3), Companion_Default___.F(), Companion_Default___.E(), Companion_Default___.D(), uint8(0), uint8(3), Companion_Default___.A(), Companion_Default___.B(), Companion_Default___.C(), uint8(0), uint8(3), Companion_Default___.D(), Companion_Default___.E(), Companion_Default___.F())
	var _1_newBadCont m_Wrappers.Result
	_ = _1_newBadCont
	_1_newBadCont = m_StructuredEncryptionHeader.Companion_Default___.GetContext(_0_badSerCont)
	if !((_1_newBadCont).Equals(m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Context keys out of order."))))) {
		panic("dafny/StructuredEncryption/test/Header.dfy(148,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) MakeCrypto(s _dafny.Sequence, a m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem {
	return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoItem_.Create_CryptoItem_(m_StructuredEncryptionPaths.Companion_Default___.StringToUniPath(s), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(), _dafny.SeqOf(uint8(1), uint8(2))), a)
}
func (_static *CompanionStruct_Default___) TestSchemaOrderAlpha() {
	var _0_schemaMap _dafny.Sequence
	_ = _0_schemaMap
	_0_schemaMap = _dafny.SeqOf(Companion_Default___.MakeCrypto(_dafny.SeqOfString("abc"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("def"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("ghi"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("jkl"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("mno"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("pqr"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()))
	var _1_tableName _dafny.Sequence
	_ = _1_tableName
	_1_tableName = _dafny.SeqOfString("name")
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError0
	_2_valueOrError0 = m_Canonize.Companion_Default___.ForEncrypt(_1_tableName, _0_schemaMap)
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(166,23): " + (_2_valueOrError0).String())
	}
	var _3_canonSchema _dafny.Sequence
	_ = _3_canonSchema
	_3_canonSchema = (_2_valueOrError0).Extract().(_dafny.Sequence)
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError1
	_4_valueOrError1 = m_StructuredEncryptionHeader.Companion_Default___.MakeLegend(_3_canonSchema)
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(167,18): " + (_4_valueOrError1).String())
	}
	var _5_legend _dafny.Sequence
	_ = _5_legend
	_5_legend = (_4_valueOrError1).Extract().(_dafny.Sequence)
	if !(_dafny.Companion_Sequence_.Equal(_5_legend, _dafny.SeqOf(m_StructuredEncryptionHeader.Companion_Default___.ENCRYPT__AND__SIGN__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.SIGN__ONLY__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.ENCRYPT__AND__SIGN__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.SIGN__ONLY__LEGEND()))) {
		panic("dafny/StructuredEncryption/test/Header.dfy(175,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSchemaOrderLength() {
	var _0_schemaMap _dafny.Sequence
	_ = _0_schemaMap
	_0_schemaMap = _dafny.SeqOf(Companion_Default___.MakeCrypto(_dafny.SeqOfString("aa"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("zz"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("aaa"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("zzz"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("aaaa"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("zzzz"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()))
	var _1_tableName _dafny.Sequence
	_ = _1_tableName
	_1_tableName = _dafny.SeqOfString("name")
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError0
	_2_valueOrError0 = m_Canonize.Companion_Default___.ForEncrypt(_1_tableName, _0_schemaMap)
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(188,23): " + (_2_valueOrError0).String())
	}
	var _3_canonSchema _dafny.Sequence
	_ = _3_canonSchema
	_3_canonSchema = (_2_valueOrError0).Extract().(_dafny.Sequence)
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError1
	_4_valueOrError1 = m_StructuredEncryptionHeader.Companion_Default___.MakeLegend(_3_canonSchema)
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(189,18): " + (_4_valueOrError1).String())
	}
	var _5_legend _dafny.Sequence
	_ = _5_legend
	_5_legend = (_4_valueOrError1).Extract().(_dafny.Sequence)
	if !(_dafny.Companion_Sequence_.Equal(_5_legend, _dafny.SeqOf(m_StructuredEncryptionHeader.Companion_Default___.ENCRYPT__AND__SIGN__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.SIGN__ONLY__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.ENCRYPT__AND__SIGN__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.SIGN__ONLY__LEGEND()))) {
		panic("dafny/StructuredEncryption/test/Header.dfy(197,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSchemaOrderLength2() {
	var _0_schemaMap _dafny.Sequence
	_ = _0_schemaMap
	_0_schemaMap = _dafny.SeqOf(Companion_Default___.MakeCrypto(_dafny.SeqOfString("aa"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("zzz"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("zzzz"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("aaa"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("zz"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()), Companion_Default___.MakeCrypto(_dafny.SeqOfString("aaaa"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()))
	var _1_tableName _dafny.Sequence
	_ = _1_tableName
	_1_tableName = _dafny.SeqOfString("name")
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError0
	_2_valueOrError0 = m_Canonize.Companion_Default___.ForEncrypt(_1_tableName, _0_schemaMap)
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(210,23): " + (_2_valueOrError0).String())
	}
	var _3_canonSchema _dafny.Sequence
	_ = _3_canonSchema
	_3_canonSchema = (_2_valueOrError0).Extract().(_dafny.Sequence)
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError1
	_4_valueOrError1 = m_StructuredEncryptionHeader.Companion_Default___.MakeLegend(_3_canonSchema)
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/StructuredEncryption/test/Header.dfy(211,18): " + (_4_valueOrError1).String())
	}
	var _5_legend _dafny.Sequence
	_ = _5_legend
	_5_legend = (_4_valueOrError1).Extract().(_dafny.Sequence)
	if !(_dafny.Companion_Sequence_.Equal(_5_legend, _dafny.SeqOf(m_StructuredEncryptionHeader.Companion_Default___.ENCRYPT__AND__SIGN__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.SIGN__ONLY__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.ENCRYPT__AND__SIGN__LEGEND(), m_StructuredEncryptionHeader.Companion_Default___.SIGN__ONLY__LEGEND()))) {
		panic("dafny/StructuredEncryption/test/Header.dfy(219,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) Abc() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(98), uint8(99))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) Def() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(100), uint8(101), uint8(102))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) ProvID() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(112), uint8(114), uint8(111), uint8(118), uint8(73), uint8(68))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) Cba() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(99), uint8(98), uint8(97))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) Fed() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(102), uint8(101), uint8(100))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) A() uint8 {
	return uint8(_dafny.Char('a'))
}
func (_static *CompanionStruct_Default___) B() uint8 {
	return uint8(_dafny.Char('b'))
}
func (_static *CompanionStruct_Default___) C() uint8 {
	return uint8(_dafny.Char('c'))
}
func (_static *CompanionStruct_Default___) D() uint8 {
	return uint8(_dafny.Char('d'))
}
func (_static *CompanionStruct_Default___) E() uint8 {
	return uint8(_dafny.Char('e'))
}
func (_static *CompanionStruct_Default___) F() uint8 {
	return uint8(_dafny.Char('f'))
}

// End of class Default__
