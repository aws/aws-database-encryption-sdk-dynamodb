// Package TestFixtures
// Dafny module TestFixtures compiled into Go

package TestFixtures

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
	m_BeaconTestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/BeaconTestFixtures"
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
var _ m_BeaconTestFixtures.Dummy__

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
	return "TestFixtures.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) GetTableName(s _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq.SetString()
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TableName(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(24,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetAttrName(s _dafny.Sequence) _dafny.Sequence {
	if m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(s) {
		return s
	} else {
		return _dafny.SeqOfString("abc")
	}
}
func (_static *CompanionStruct_Default___) GetStatement(s _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq.SetString()
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__PartiQLStatement(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(36,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetPStatements(s _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__ParameterizedStatements(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(41,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetTransactWriteItemList(s _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TransactWriteItemList(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(47,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetBatchWriteItemRequestMap(s _dafny.Map) _dafny.Map {
	var output _dafny.Map = _dafny.EmptyMap
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__BatchWriteItemRequestMap(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(52,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetWriteRequests(s _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__WriteRequests(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(57,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetBatchGetRequestMap(s _dafny.Map) _dafny.Map {
	var output _dafny.Map = _dafny.EmptyMap
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__BatchGetRequestMap(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(62,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetKeyList(s _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__KeyList(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(67,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetTransactGetItemList(s _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TransactGetItemList(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(72,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetPartiQLBatchRequest(s _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq
	_ = output
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__PartiQLBatchRequest(s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(77,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = s
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetAttributeActions() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("sign"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("nothing"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
}
func (_static *CompanionStruct_Default___) GetV2AttributeActions() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("sign"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("nothing"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
}
func (_static *CompanionStruct_Default___) GetSignedAttributeActions() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("sign"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_())
}
func (_static *CompanionStruct_Default___) GetEncryptorConfigFromActions(actions _dafny.Map, sortKeyName m_Wrappers.Option) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig{}
	_ = output
	var _0_keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _0_keyring
	var _out0 m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _out0
	_out0 = Companion_Default___.GetKmsKeyring()
	_0_keyring = _out0
	var _1_logicalTableName _dafny.Sequence
	_ = _1_logicalTableName
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = Companion_Default___.GetTableName(_dafny.SeqOfString("foo"))
	_1_logicalTableName = _out1
	output = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DynamoDbItemEncryptorConfig_.Create_DynamoDbItemEncryptorConfig_(_1_logicalTableName, _dafny.SeqOfString("bar"), sortKeyName, actions, m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_dafny.SeqOfString("nothing"))), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_keyring), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	return output
}
func (_static *CompanionStruct_Default___) GetEncryptorConfig() m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig {
	var output m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig{}
	_ = output
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = Companion_Default___.GetEncryptorConfigFromActions(Companion_Default___.GetAttributeActions(), m_Wrappers.Companion_Option_.Create_None_())
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) GetDynamoDbItemEncryptorFrom(config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig) *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient {
	var encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient = (*m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)(nil)
	_ = encryptor
	var _0_keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _0_keyring
	var _out0 m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _out0
	_out0 = Companion_Default___.GetKmsKeyring()
	_0_keyring = _out0
	var _1_encryptorConfig m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _1_encryptorConfig
	_1_encryptorConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DynamoDbItemEncryptorConfig_.Create_DynamoDbItemEncryptorConfig_((config).Dtor_logicalTableName(), (config).Dtor_partitionKeyName(), (config).Dtor_sortKeyName(), (config).Dtor_attributeActionsOnEncrypt(), (config).Dtor_allowedUnsignedAttributes(), (config).Dtor_allowedUnsignedAttributePrefix(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_keyring), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbItemEncryptor.Companion_Default___.DynamoDbItemEncryptor(_1_encryptorConfig)
	_2_valueOrError0 = _out1
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(132,53): " + (_2_valueOrError0).String())
	}
	var _3_encryptor2 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClient
	_ = _3_encryptor2
	_3_encryptor2 = (_2_valueOrError0).Extract().(*m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)
	encryptor = _3_encryptor2.(*m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)
	return encryptor
}
func (_static *CompanionStruct_Default___) GetDynamoDbItemEncryptor() *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient {
	var encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient = (*m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)(nil)
	_ = encryptor
	var _0_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _0_config
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = Companion_Default___.GetEncryptorConfig()
	_0_config = _out0
	var _out1 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out1
	_out1 = Companion_Default___.GetDynamoDbItemEncryptorFrom(_0_config)
	encryptor = _out1
	return encryptor
}
func (_static *CompanionStruct_Default___) Expect__ok(tag _dafny.Sequence, actual m_Wrappers.Result) {
	if (actual).Is_Failure() {
		_dafny.Print((tag).SetString())
		_dafny.Print((_dafny.SeqOfString("\t")).SetString())
		_dafny.Print(actual)
	}
	if !((actual).Is_Success()) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(154,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) Expect__equal(tag _dafny.Sequence, actual interface{}, expected interface{}) {
	if !_dafny.AreEqual(actual, expected) {
		_dafny.Print((tag).SetString())
		_dafny.Print((_dafny.SeqOfString("\texpected\n")).SetString())
		_dafny.Print(expected)
		_dafny.Print((_dafny.SeqOfString("\ngot\n")).SetString())
		_dafny.Print(actual)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !(_dafny.AreEqual(actual, expected)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(161,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) ExpectFailure(ret m_Wrappers.Result, s _dafny.Sequence) {
	if !((ret).Is_Failure()) {
		_dafny.Print((_dafny.SeqOfString("Got Success when expected failure ")).SetString())
		_dafny.Print((s).SetString())
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((ret).Is_Failure()) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(169,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((ret).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error)).Is_DynamoDbEncryptionTransformsException()) {
		_dafny.Print((_dafny.SeqOfString("Error type not DynamoDbEncryptionTransformsException : ")).SetString())
		_dafny.Print(ret)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !(((ret).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error)).Is_DynamoDbEncryptionTransformsException()) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(173,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !_dafny.Companion_Sequence_.Equal(((ret).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error)).Dtor_message(), s) {
		_dafny.Print((_dafny.SeqOfString("Expected error message '")).SetString())
		_dafny.Print((s).SetString())
		_dafny.Print((_dafny.SeqOfString("' got message '")).SetString())
		_dafny.Print((((ret).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error)).Dtor_message()).SetString())
		_dafny.Print((_dafny.SeqOfString("'\n")).SetString())
	}
	if !(_dafny.Companion_Sequence_.Equal(((ret).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error)).Dtor_message(), s)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(177,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) GetKmsKeyring() m_AwsCryptographyMaterialProvidersTypes.IKeyring {
	var keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring = (m_AwsCryptographyMaterialProvidersTypes.IKeyring)(nil)
	_ = keyring
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(186,19): " + (_0_valueOrError0).String())
	}
	var _1_matProv *m_MaterialProviders.MaterialProvidersClient
	_ = _1_matProv
	_1_matProv = (_0_valueOrError0).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _2_keyringInput m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput
	_ = _2_keyringInput
	_2_keyringInput = m_AwsCryptographyMaterialProvidersTypes.Companion_CreateAwsKmsMultiKeyringInput_.Create_CreateAwsKmsMultiKeyringInput_(m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.PUBLIC__US__WEST__2__KMS__TEST__KEY()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (_1_matProv).CreateAwsKmsMultiKeyring(_2_keyringInput)
	_3_valueOrError1 = _out1
	if !(!((_3_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(190,15): " + (_3_valueOrError1).String())
	}
	keyring = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.CastTo_((_3_valueOrError1).Extract())
	return keyring
}
func (_static *CompanionStruct_Default___) GetStaticKeyring() m_AwsCryptographyMaterialProvidersTypes.IKeyring {
	var keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring = (m_AwsCryptographyMaterialProvidersTypes.IKeyring)(nil)
	_ = keyring
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(199,19): " + (_0_valueOrError0).String())
	}
	var _1_matProv *m_MaterialProviders.MaterialProvidersClient
	_ = _1_matProv
	_1_matProv = (_0_valueOrError0).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (_1_matProv).CreateRawAesKeyring(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateRawAesKeyringInput_.Create_CreateRawAesKeyringInput_(_dafny.SeqOfString("foo"), _dafny.SeqOfString("bar"), _dafny.SeqCreate(32, func(coer1 func(_dafny.Int) uint8) func(_dafny.Int) interface{} {
		return func(arg2 _dafny.Int) interface{} {
			return coer1(arg2)
		}
	}(func(_3_i _dafny.Int) uint8 {
		return uint8(0)
	})), m_AwsCryptographyMaterialProvidersTypes.Companion_AesWrappingAlg_.Create_ALG__AES256__GCM__IV12__TAG16_()))
	_2_valueOrError1 = _out1
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(200,15): " + (_2_valueOrError1).String())
	}
	keyring = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.CastTo_((_2_valueOrError1).Extract())
	return keyring
}
func (_static *CompanionStruct_Default___) GetDynamoDbEncryptionTransforms() *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient {
	var encryption *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient = (*m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)(nil)
	_ = encryption
	var _0_keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _0_keyring
	var _out0 m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _out0
	_out0 = Companion_Default___.GetKmsKeyring()
	_0_keyring = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryptionTransforms.Companion_Default___.DynamoDbEncryptionTransforms(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTablesEncryptionConfig_.Create_DynamoDbTablesEncryptionConfig_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("foo"), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_(_dafny.SeqOfString("foo"), _dafny.SeqOfString("bar"), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("sign"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("plain"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_dafny.SeqOfString("plain"))), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_keyring), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))))
	_1_valueOrError0 = _out1
	if !(!((_1_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(217,18): " + (_1_valueOrError0).String())
	}
	encryption = (_1_valueOrError0).Extract().(*m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)
	return encryption
}
func (_static *CompanionStruct_Default___) GetDynamoDbEncryptionTransforms2() *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient {
	var encryption *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient = (*m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)(nil)
	_ = encryption
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TableName(_dafny.SeqOfString("foo"))) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(247,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _0_keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _0_keyring
	var _out0 m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _out0
	_out0 = Companion_Default___.GetKmsKeyring()
	_0_keyring = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryptionTransforms.Companion_Default___.DynamoDbEncryptionTransforms(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTablesEncryptionConfig_.Create_DynamoDbTablesEncryptionConfig_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("foo"), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_(_dafny.SeqOfString("foo"), _dafny.SeqOfString("bar"), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("sign")), m_Wrappers.Companion_Option_.Create_None_(), _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("sign"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("plain"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_dafny.SeqOfString("plain"))), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_keyring), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))))
	_1_valueOrError0 = _out1
	if !(!((_1_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(249,18): " + (_1_valueOrError0).String())
	}
	encryption = (_1_valueOrError0).Extract().(*m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)
	return encryption
}
func (_static *CompanionStruct_Default___) GetDynamoDbEncryptionTransformsMulti(plaintextOverride m_Wrappers.Option) *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient {
	var encryption *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient = (*m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)(nil)
	_ = encryption
	var _0_keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _0_keyring
	var _out0 m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _out0
	_out0 = Companion_Default___.GetKmsKeyring()
	_0_keyring = _out0
	var _1_beacons m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_beacons
	var _out1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsMulti()
	_1_beacons = _out1
	var _2_search m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig
	_ = _2_search
	_2_search = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SearchConfig_.Create_SearchConfig_(_dafny.SeqOf(_1_beacons), int32(1))
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_DynamoDbEncryptionTransforms.Companion_Default___.DynamoDbEncryptionTransforms(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTablesEncryptionConfig_.Create_DynamoDbTablesEncryptionConfig_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("foo"), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_(_dafny.SeqOfString("foo"), _dafny.SeqOfString("bar"), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_2_search), Companion_Default___.MultiActions(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_dafny.SeqOfString("plain"))), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_keyring), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), plaintextOverride))))
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(301,18): " + (_3_valueOrError0).String())
	}
	encryption = (_3_valueOrError0).Extract().(*m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)
	return encryption
}
func (_static *CompanionStruct_Default___) PUBLIC__US__WEST__2__KMS__TEST__KEY() _dafny.Sequence {
	return _dafny.SeqOfString("arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f")
}
func (_static *CompanionStruct_Default___) MultiActions() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("std2"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("std4"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("std6"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("Name"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("Title"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("TooBad"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("Year"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("Date"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("TheKeyField"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_())
}

// End of class Default__
