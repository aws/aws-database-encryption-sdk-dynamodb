// Package BeaconTestFixtures
// Dafny module BeaconTestFixtures compiled into Go

package BeaconTestFixtures

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
	m_TestHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestHeader"
	m_TestStructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestStructuredEncryptionCrypt"
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
var _ m_TestHeader.Dummy__
var _ m_TestStructuredEncryptionCrypt.Dummy__

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
	return "BeaconTestFixtures.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Expect__equal(a interface{}, b interface{}) {
	if !_dafny.AreEqual(a, b) {
		_dafny.Print((_dafny.SeqOfString("Not equal: ")).SetString())
		_dafny.Print(a)
		_dafny.Print((_dafny.SeqOfString(", ")).SetString())
		_dafny.Print(b)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !(_dafny.AreEqual(a, b)) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(31,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) GetKeyStore() m_AwsCryptographyKeyStoreTypes.IKeyStoreClient {
	var output m_AwsCryptographyKeyStoreTypes.IKeyStoreClient = (m_AwsCryptographyKeyStoreTypes.IKeyStoreClient)(nil)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_Com_Amazonaws_Kms.Companion_Default___.KMSClient()
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(125,21): " + (_0_valueOrError0).String())
	}
	var _1_kmsClient m_ComAmazonawsKmsTypes.IKMSClient
	_ = _1_kmsClient
	_1_kmsClient = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_0_valueOrError0).Extract())
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_Com_Amazonaws_Dynamodb.Companion_Default___.DynamoDBClient()
	_2_valueOrError1 = _out1
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(126,21): " + (_2_valueOrError1).String())
	}
	var _3_ddbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
	_ = _3_ddbClient
	_3_ddbClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_2_valueOrError1).Extract())
	var _4_kmsConfig m_AwsCryptographyKeyStoreTypes.KMSConfiguration
	_ = _4_kmsConfig
	_4_kmsConfig = m_AwsCryptographyKeyStoreTypes.Companion_KMSConfiguration_.Create_kmsKeyArn_(_dafny.SeqOfString("arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126"))
	var _5_keyStoreConfig m_AwsCryptographyKeyStoreTypes.KeyStoreConfig
	_ = _5_keyStoreConfig
	_5_keyStoreConfig = m_AwsCryptographyKeyStoreTypes.Companion_KeyStoreConfig_.Create_KeyStoreConfig_(_dafny.SeqOfString("KeyStoreDdbTable"), _4_kmsConfig, _dafny.SeqOfString("KeyStoreDdbTable"), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_3_ddbClient), m_Wrappers.Companion_Option_.Create_Some_(_1_kmsClient))
	var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _6_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_KeyStore.Companion_Default___.KeyStore(_5_keyStoreConfig)
	_6_valueOrError2 = _out2
	if !(!((_6_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(140,17): " + (_6_valueOrError2).String())
	}
	var _7_store *m_KeyStore.KeyStoreClient
	_ = _7_store
	_7_store = (_6_valueOrError2).Extract().(*m_KeyStore.KeyStoreClient)
	output = _7_store
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetBadKeyStore() m_AwsCryptographyKeyStoreTypes.IKeyStoreClient {
	var output m_AwsCryptographyKeyStoreTypes.IKeyStoreClient = (m_AwsCryptographyKeyStoreTypes.IKeyStoreClient)(nil)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_Com_Amazonaws_Kms.Companion_Default___.KMSClient()
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(152,21): " + (_0_valueOrError0).String())
	}
	var _1_kmsClient m_ComAmazonawsKmsTypes.IKMSClient
	_ = _1_kmsClient
	_1_kmsClient = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_0_valueOrError0).Extract())
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_Com_Amazonaws_Dynamodb.Companion_Default___.DynamoDBClient()
	_2_valueOrError1 = _out1
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(153,21): " + (_2_valueOrError1).String())
	}
	var _3_ddbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
	_ = _3_ddbClient
	_3_ddbClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_2_valueOrError1).Extract())
	var _4_kmsConfig m_AwsCryptographyKeyStoreTypes.KMSConfiguration
	_ = _4_kmsConfig
	_4_kmsConfig = m_AwsCryptographyKeyStoreTypes.Companion_KMSConfiguration_.Create_kmsKeyArn_(_dafny.SeqOfString("arn:aws:kms:us-west-2:370957321024:key/bad-arn"))
	var _5_keyStoreConfig m_AwsCryptographyKeyStoreTypes.KeyStoreConfig
	_ = _5_keyStoreConfig
	_5_keyStoreConfig = m_AwsCryptographyKeyStoreTypes.Companion_KeyStoreConfig_.Create_KeyStoreConfig_(_dafny.SeqOfString("bad-table-name"), _4_kmsConfig, _dafny.SeqOfString("KeyStoreDdbTable"), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_3_ddbClient), m_Wrappers.Companion_Option_.Create_Some_(_1_kmsClient))
	var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _6_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_KeyStore.Companion_Default___.KeyStore(_5_keyStoreConfig)
	_6_valueOrError2 = _out2
	if !(!((_6_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(171,17): " + (_6_valueOrError2).String())
	}
	var _7_store *m_KeyStore.KeyStoreClient
	_ = _7_store
	_7_store = (_6_valueOrError2).Extract().(*m_KeyStore.KeyStoreClient)
	output = _7_store
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetEmptyBeacons() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion{}
	_ = output
	var _0_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _0_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = Companion_Default___.GetKeyStore()
	_0_store = _out0
	output = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _0_store, m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_single_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SingleKeyStore_.Create_SingleKeyStore_(_dafny.SeqOfString("foo"), int32(42), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())), _dafny.SeqOf(Companion_Default___.Std2()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetLotsaBeacons() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion{}
	_ = output
	var _0_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _0_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = Companion_Default___.GetKeyStore()
	_0_store = _out0
	output = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _0_store, m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_single_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SingleKeyStore_.Create_SingleKeyStore_(_dafny.SeqOfString("foo"), int32(42), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())), _dafny.SeqOf(Companion_Default___.Std2(), Companion_Default___.Std4(), Companion_Default___.Std6(), Companion_Default___.NameTitleBeacon(), Companion_Default___.NameB(), Companion_Default___.TitleB()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitle(), Companion_Default___.YearName(), Companion_Default___.Mixed(), Companion_Default___.JustSigned())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitleField())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetLotsaBeaconsMulti() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion{}
	_ = output
	var _0_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _0_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = Companion_Default___.GetKeyStore()
	_0_store = _out0
	output = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _0_store, m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_multi_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_MultiKeyStore_.Create_MultiKeyStore_(_dafny.SeqOfString("TheKeyField"), int32(42), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())), _dafny.SeqOf(Companion_Default___.Std2(), Companion_Default___.Std4(), Companion_Default___.Std6(), Companion_Default___.NameTitleBeacon(), Companion_Default___.NameB(), Companion_Default___.TitleB()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitle(), Companion_Default___.YearName(), Companion_Default___.Mixed(), Companion_Default___.JustSigned())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitleField())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetLotsaBeaconsSingleWithSharedCache(cache m_AwsCryptographyMaterialProvidersTypes.CacheType, partitionId m_Wrappers.Option) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion{}
	_ = output
	var _0_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _0_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = Companion_Default___.GetKeyStore()
	_0_store = _out0
	output = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _0_store, m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_single_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SingleKeyStore_.Create_SingleKeyStore_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73"), int32(42), m_Wrappers.Companion_Option_.Create_Some_(cache), partitionId)), _dafny.SeqOf(Companion_Default___.Std2(), Companion_Default___.Std4(), Companion_Default___.Std6(), Companion_Default___.NameTitleBeacon(), Companion_Default___.NameB(), Companion_Default___.TitleB()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitle(), Companion_Default___.YearName(), Companion_Default___.Mixed(), Companion_Default___.JustSigned())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitleField())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(cache m_AwsCryptographyMaterialProvidersTypes.CacheType, partitionId m_Wrappers.Option) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion{}
	_ = output
	var _0_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _0_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = Companion_Default___.GetBadKeyStore()
	_0_store = _out0
	output = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _0_store, m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_single_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SingleKeyStore_.Create_SingleKeyStore_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73"), int32(42), m_Wrappers.Companion_Option_.Create_Some_(cache), partitionId)), _dafny.SeqOf(Companion_Default___.Std2(), Companion_Default___.Std4(), Companion_Default___.Std6(), Companion_Default___.NameTitleBeacon(), Companion_Default___.NameB(), Companion_Default___.TitleB()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitle(), Companion_Default___.YearName(), Companion_Default___.Mixed(), Companion_Default___.JustSigned())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitleField())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetLotsaBeaconsMultiWithSharedCache(cache m_AwsCryptographyMaterialProvidersTypes.CacheType, partitionId m_Wrappers.Option) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion{}
	_ = output
	var _0_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _0_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = Companion_Default___.GetKeyStore()
	_0_store = _out0
	output = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _0_store, m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_multi_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_MultiKeyStore_.Create_MultiKeyStore_(_dafny.SeqOfString("TheKeyField"), int32(42), m_Wrappers.Companion_Option_.Create_Some_(cache), partitionId)), _dafny.SeqOf(Companion_Default___.Std2(), Companion_Default___.Std4(), Companion_Default___.Std6(), Companion_Default___.NameTitleBeacon(), Companion_Default___.NameB(), Companion_Default___.TitleB()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitle(), Companion_Default___.YearName(), Companion_Default___.Mixed(), Companion_Default___.JustSigned())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitleField())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(cache m_AwsCryptographyMaterialProvidersTypes.CacheType, partitionId m_Wrappers.Option) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion{}
	_ = output
	var _0_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _0_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = Companion_Default___.GetBadKeyStore()
	_0_store = _out0
	output = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _0_store, m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_multi_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_MultiKeyStore_.Create_MultiKeyStore_(_dafny.SeqOfString("TheKeyField"), int32(42), m_Wrappers.Companion_Option_.Create_Some_(cache), partitionId)), _dafny.SeqOf(Companion_Default___.Std2(), Companion_Default___.Std4(), Companion_Default___.Std6(), Companion_Default___.NameTitleBeacon(), Companion_Default___.NameB(), Companion_Default___.TitleB()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitle(), Companion_Default___.YearName(), Companion_Default___.Mixed(), Companion_Default___.JustSigned())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.NameTitleField())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetSharedCache() m_AwsCryptographyMaterialProvidersTypes.CacheType {
	var cache m_AwsCryptographyMaterialProvidersTypes.CacheType = m_AwsCryptographyMaterialProvidersTypes.CacheType{}
	_ = cache
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(330,15): " + (_0_valueOrError0).String())
	}
	var _1_mpl *m_MaterialProviders.MaterialProvidersClient
	_ = _1_mpl
	_1_mpl = (_0_valueOrError0).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (_1_mpl).CreateCryptographicMaterialsCache(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateCryptographicMaterialsCacheInput_.Create_CreateCryptographicMaterialsCacheInput_(m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_Default_(m_AwsCryptographyMaterialProvidersTypes.Companion_DefaultCache_.Create_DefaultCache_(int32(100)))))
	_2_valueOrError1 = _out1
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(332,23): " + (_2_valueOrError1).String())
	}
	var _3_sharedCache m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache
	_ = _3_sharedCache
	_3_sharedCache = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.CastTo_((_2_valueOrError1).Extract())
	cache = m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_Shared_(_3_sharedCache)
	return cache
}
func (_static *CompanionStruct_Default___) GetLiteralSource(key _dafny.Sequence, version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion) m_SearchableEncryptionInfo.KeySource {
	var output m_SearchableEncryptionInfo.KeySource = m_SearchableEncryptionInfo.KeySource{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(385,18): " + (_0_valueOrError0).String())
	}
	var _1_client *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _1_client
	_1_client = (_0_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _2_keyNameSet _dafny.Set
	_ = _2_keyNameSet
	_2_keyNameSet = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter0 := _dafny.Iterate(((version).Dtor_standardBeacons()).Elements()); ; {
			_compr_0, _ok0 := _iter0()
			if !_ok0 {
				break
			}
			var _3_b m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
			_3_b = interface{}(_compr_0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)
			if _dafny.Companion_Sequence_.Contains((version).Dtor_standardBeacons(), _3_b) {
				_coll0.Add((_3_b).Dtor_name())
			}
		}
		return _coll0.ToSet()
	}()
	var _4_keyNames _dafny.Sequence
	_ = _4_keyNames
	_4_keyNames = m_SortedSets.SetToOrderedSequence2(_2_keyNameSet, func(coer0 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg0 interface{}, arg1 interface{}) bool {
			return coer0(arg0.(_dafny.Char), arg1.(_dafny.Char))
		}
	}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _5_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_SearchableEncryptionInfo.Companion_Default___.GetHmacKeys(_1_client, _4_keyNames, _4_keyNames, key, _dafny.NewMapBuilder().ToMap())
	_5_valueOrError1 = _out1
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(389,16): " + (_5_valueOrError1).String())
	}
	var _6_keys _dafny.Map
	_ = _6_keys
	_6_keys = (_5_valueOrError1).Extract().(_dafny.Map)
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_7_valueOrError2 = _out2
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(390,15): " + (_7_valueOrError2).String())
	}
	var _8_mpl *m_MaterialProviders.MaterialProvidersClient
	_ = _8_mpl
	_8_mpl = (_7_valueOrError2).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _9_input m_AwsCryptographyMaterialProvidersTypes.CreateCryptographicMaterialsCacheInput
	_ = _9_input
	_9_input = m_AwsCryptographyMaterialProvidersTypes.Companion_CreateCryptographicMaterialsCacheInput_.Create_CreateCryptographicMaterialsCacheInput_(m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_Default_(m_AwsCryptographyMaterialProvidersTypes.Companion_DefaultCache_.Create_DefaultCache_(int32(3))))
	var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _10_valueOrError3
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_8_mpl).CreateCryptographicMaterialsCache(_9_input)
	_10_valueOrError3 = _out3
	if !(!((_10_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(394,17): " + (_10_valueOrError3).String())
	}
	var _11_cache m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache
	_ = _11_cache
	_11_cache = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.CastTo_((_10_valueOrError3).Extract())
	var _12_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _12_valueOrError4
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchableEncryptionInfo.Companion_Default___.GenerateUuidBytes()
	_12_valueOrError4 = _out4
	if !(!((_12_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(396,41): " + (_12_valueOrError4).String())
	}
	var _13_partitionIdBytes _dafny.Sequence
	_ = _13_partitionIdBytes
	_13_partitionIdBytes = (_12_valueOrError4).Extract().(_dafny.Sequence)
	var _14_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _14_valueOrError5
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_SearchableEncryptionInfo.Companion_Default___.GenerateUuidBytes()
	_14_valueOrError5 = _out5
	if !(!((_14_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(407,49): " + (_14_valueOrError5).String())
	}
	var _15_logicalKeyStoreNameBytes _dafny.Sequence
	_ = _15_logicalKeyStoreNameBytes
	_15_logicalKeyStoreNameBytes = (_14_valueOrError5).Extract().(_dafny.Sequence)
	output = m_SearchableEncryptionInfo.Companion_KeySource_.Create_KeySource_(_1_client, (version).Dtor_keyStore(), m_SearchableEncryptionInfo.Companion_KeyLocation_.Create_LiteralLoc_(_6_keys), _11_cache, uint32(0), _13_partitionIdBytes, _15_logicalKeyStoreNameBytes)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetMultiSource(keyName _dafny.Sequence, version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion) m_SearchableEncryptionInfo.KeySource {
	var output m_SearchableEncryptionInfo.KeySource = m_SearchableEncryptionInfo.KeySource{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(421,18): " + (_0_valueOrError0).String())
	}
	var _1_client *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _1_client
	_1_client = (_0_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_2_valueOrError1 = _out1
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(422,15): " + (_2_valueOrError1).String())
	}
	var _3_mpl *m_MaterialProviders.MaterialProvidersClient
	_ = _3_mpl
	_3_mpl = (_2_valueOrError1).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _4_input m_AwsCryptographyMaterialProvidersTypes.CreateCryptographicMaterialsCacheInput
	_ = _4_input
	_4_input = m_AwsCryptographyMaterialProvidersTypes.Companion_CreateCryptographicMaterialsCacheInput_.Create_CreateCryptographicMaterialsCacheInput_(m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_Default_(m_AwsCryptographyMaterialProvidersTypes.Companion_DefaultCache_.Create_DefaultCache_(int32(3))))
	var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_3_mpl).CreateCryptographicMaterialsCache(_4_input)
	_5_valueOrError2 = _out2
	if !(!((_5_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(426,17): " + (_5_valueOrError2).String())
	}
	var _6_cache m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache
	_ = _6_cache
	_6_cache = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.CastTo_((_5_valueOrError2).Extract())
	var _7_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError3
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_SearchableEncryptionInfo.Companion_Default___.GenerateUuidBytes()
	_7_valueOrError3 = _out3
	if !(!((_7_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(428,41): " + (_7_valueOrError3).String())
	}
	var _8_partitionIdBytes _dafny.Sequence
	_ = _8_partitionIdBytes
	_8_partitionIdBytes = (_7_valueOrError3).Extract().(_dafny.Sequence)
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError4
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchableEncryptionInfo.Companion_Default___.GenerateUuidBytes()
	_9_valueOrError4 = _out4
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/BeaconTestFixtures.dfy(439,49): " + (_9_valueOrError4).String())
	}
	var _10_logicalKeyStoreNameBytes _dafny.Sequence
	_ = _10_logicalKeyStoreNameBytes
	_10_logicalKeyStoreNameBytes = (_9_valueOrError4).Extract().(_dafny.Sequence)
	output = m_SearchableEncryptionInfo.Companion_KeySource_.Create_KeySource_(_1_client, (version).Dtor_keyStore(), m_SearchableEncryptionInfo.Companion_KeyLocation_.Create_MultiLoc_(keyName, false), _6_cache, uint32(0), _8_partitionIdBytes, _10_logicalKeyStoreNameBytes)
	return output
	return output
}
func (_static *CompanionStruct_Default___) Name() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.SeqOfString("Name"), _dafny.SeqOfString("N_"))
}
func (_static *CompanionStruct_Default___) Title() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.SeqOfString("Title"), _dafny.SeqOfString("T_"))
}
func (_static *CompanionStruct_Default___) NameTitle() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("NameTitle"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Name(), Companion_Default___.Title())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) Year() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SignedPart_.Create_SignedPart_(_dafny.SeqOfString("Year"), _dafny.SeqOfString("Y_"), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) YearName() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("YearName"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Name())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Year())), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) TooBad() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.SeqOfString("TooBad"), _dafny.SeqOfString("T"))
}
func (_static *CompanionStruct_Default___) BadPrefix() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("BadPrefix"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Name(), Companion_Default___.Title(), Companion_Default___.TooBad())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) Nothing() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SignedPart_.Create_SignedPart_(_dafny.SeqOfString("Nothing"), _dafny.SeqOfString("N__"), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) BadPrefix2() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("BadPrefix2"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Name())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Nothing())), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) Month() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SignedPart_.Create_SignedPart_(_dafny.SeqOfString("Month"), _dafny.SeqOfString("M_"), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("Date.Month")))
}
func (_static *CompanionStruct_Default___) JustSigned() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("JustSigned"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Year(), Companion_Default___.Month())), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) Mixed() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("Mixed"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Name(), Companion_Default___.Title())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(Companion_Default___.Year(), Companion_Default___.Month())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Constructor_.Create_Constructor_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.SeqOfString("Name"), true), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.SeqOfString("Year"), true))), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Constructor_.Create_Constructor_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.SeqOfString("Title"), true), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.SeqOfString("Month"), false))))))
}
func (_static *CompanionStruct_Default___) Std6String() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("666"))
}
func (_static *CompanionStruct_Default___) Std6List() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(Companion_Default___.Std6String()))
}
func (_static *CompanionStruct_Default___) MonthString() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("May"))
}
func (_static *CompanionStruct_Default___) YearString() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1984"))
}
func (_static *CompanionStruct_Default___) DateMap() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("Month"), Companion_Default___.MonthString()).UpdateUnsafe(_dafny.SeqOfString("Year"), Companion_Default___.YearString()))
}
func (_static *CompanionStruct_Default___) VPart1() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualPart_.Create_VirtualPart_(_dafny.SeqOfString("Name"), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_insert_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Insert_.Create_Insert_(_dafny.SeqOfString("__"))))))
}
func (_static *CompanionStruct_Default___) VPart2() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualPart_.Create_VirtualPart_(_dafny.SeqOfString("Title"), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_lower_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Lower_.Create_Lower_()))))
}
func (_static *CompanionStruct_Default___) NameTitleField() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualField_.Create_VirtualField_(_dafny.SeqOfString("NameTitleField"), _dafny.SeqOf(Companion_Default___.VPart1(), Companion_Default___.VPart2()))
}
func (_static *CompanionStruct_Default___) NameVirtField() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualField_.Create_VirtualField_(_dafny.SeqOfString("NameVirtField"), _dafny.SeqOf(Companion_Default___.VPart1()))
}
func (_static *CompanionStruct_Default___) Std2() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("std2"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) Std4() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("std4"), int32(24), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std4")), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) Std6() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("std6"), int32(26), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std6[0]")), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) NameTitleBeacon() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("NameTitleField"), int32(28), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) NameB() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("Name"), int32(32), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) TitleB() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("Title"), int32(32), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) EmptyTableConfig() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_(_dafny.SeqOfString("Foo"), _dafny.SeqOfString("foo"), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), _dafny.NewMapBuilder().ToMap(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) FullTableConfig() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig {
	var _0_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = Companion_Default___.EmptyTableConfig()
	_ = _0_dt__update__tmp_h0
	var _1_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("std2"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("std4"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("std6"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("Name"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("Title"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("TooBad"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("Year"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("Date"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("TheKeyField"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_())
	_ = _1_dt__update_hattributeActionsOnEncrypt_h0
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_0_dt__update__tmp_h0).Dtor_logicalTableName(), (_0_dt__update__tmp_h0).Dtor_partitionKeyName(), (_0_dt__update__tmp_h0).Dtor_sortKeyName(), (_0_dt__update__tmp_h0).Dtor_search(), _1_dt__update_hattributeActionsOnEncrypt_h0, (_0_dt__update__tmp_h0).Dtor_allowedUnsignedAttributes(), (_0_dt__update__tmp_h0).Dtor_allowedUnsignedAttributePrefix(), (_0_dt__update__tmp_h0).Dtor_algorithmSuiteId(), (_0_dt__update__tmp_h0).Dtor_keyring(), (_0_dt__update__tmp_h0).Dtor_cmm(), (_0_dt__update__tmp_h0).Dtor_legacyOverride(), (_0_dt__update__tmp_h0).Dtor_plaintextOverride())
}
func (_static *CompanionStruct_Default___) Std2String() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1.23"))
}
func (_static *CompanionStruct_Default___) Std4String() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc"))
}
func (_static *CompanionStruct_Default___) NameString() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("MyName"))
}
func (_static *CompanionStruct_Default___) TitleString() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("MyTitle"))
}
func (_static *CompanionStruct_Default___) SimpleItem() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("std2"), Companion_Default___.Std2String()).UpdateUnsafe(_dafny.SeqOfString("std4"), Companion_Default___.Std4String()).UpdateUnsafe(_dafny.SeqOfString("std6"), Companion_Default___.Std6List()).UpdateUnsafe(_dafny.SeqOfString("Date"), Companion_Default___.DateMap()).UpdateUnsafe(_dafny.SeqOfString("Year"), Companion_Default___.YearString()).UpdateUnsafe(_dafny.SeqOfString("Name"), Companion_Default___.NameString()).UpdateUnsafe(_dafny.SeqOfString("Title"), Companion_Default___.TitleString())
}
func (_static *CompanionStruct_Default___) TooBadB() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("TooBad"), int32(32), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) Std2__beacon() _dafny.Sequence {
	return _dafny.SeqOfString("ac6f5d")
}
func (_static *CompanionStruct_Default___) Name__beacon() _dafny.Sequence {
	return _dafny.SeqOfString("7d9bfa40")
}
func (_static *CompanionStruct_Default___) Title__beacon() _dafny.Sequence {
	return _dafny.SeqOfString("e4feb833")
}
func (_static *CompanionStruct_Default___) Std4__beacon() _dafny.Sequence {
	return _dafny.SeqOfString("0e9064")
}
func (_static *CompanionStruct_Default___) Std6__beacon() _dafny.Sequence {
	return _dafny.SeqOfString("2d99222")
}
func (_static *CompanionStruct_Default___) NameTitle__beacon() _dafny.Sequence {
	return _dafny.SeqOfString("4c577d7")
}
func (_static *CompanionStruct_Default___) EmptyName__beacon() _dafny.Sequence {
	return _dafny.SeqOfString("e0e88994")
}
func (_static *CompanionStruct_Default___) EmptyTitle__beacon() _dafny.Sequence {
	return _dafny.SeqOfString("af34f26f")
}

// End of class Default__
