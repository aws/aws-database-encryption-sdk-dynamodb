// Package TestDynamoDBFilterExpr
// Dafny module TestDynamoDBFilterExpr compiled into Go

package TestDynamoDBFilterExpr

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
	m_BatchExecuteStatementTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/BatchExecuteStatementTransformTest"
	m_BatchGetItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/BatchGetItemTransformTest"
	m_BatchWriteItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/BatchWriteItemTransformTest"
	m_BeaconTestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/BeaconTestFixtures"
	m_DdbStatementTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/DdbStatementTest"
	m_DeleteItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/DeleteItemTransformTest"
	m_DynamoDbItemEncryptorTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/DynamoDbItemEncryptorTest"
	m_ExecuteStatementTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ExecuteStatementTransformTest"
	m_ExecuteTransactionTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ExecuteTransactionTransformTest"
	m_GetItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/GetItemTransformTest"
	m_HappyCaseTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/HappyCaseTests"
	m_PathsTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PathsTests"
	m_PutItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PutItemTransformTest"
	m_QueryTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/QueryTransformTest"
	m_ScanTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ScanTransformTest"
	m_StructuredDataTestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/StructuredDataTestFixtures"
	m_TestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestFixtures"
	m_TestHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestHeader"
	m_TestStructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestStructuredEncryptionCrypt"
	m_TransactGetItemsTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TransactGetItemsTransformTest"
	m_TransactWriteItemsTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TransactWriteItemsTransformTest"
	m_UpdateItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/UpdateItemTransformTest"
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
var _ m_TestFixtures.Dummy__
var _ m_DynamoDbItemEncryptorTest.Dummy__
var _ m_GetItemTransformTest.Dummy__
var _ m_DdbStatementTest.Dummy__
var _ m_ExecuteTransactionTransformTest.Dummy__
var _ m_BatchWriteItemTransformTest.Dummy__
var _ m_TransactGetItemsTransformTest.Dummy__
var _ m_BatchExecuteStatementTransformTest.Dummy__
var _ m_BatchGetItemTransformTest.Dummy__
var _ m_ScanTransformTest.Dummy__
var _ m_UpdateItemTransformTest.Dummy__
var _ m_ExecuteStatementTransformTest.Dummy__
var _ m_TransactWriteItemsTransformTest.Dummy__
var _ m_PutItemTransformTest.Dummy__
var _ m_DeleteItemTransformTest.Dummy__
var _ m_QueryTransformTest.Dummy__

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
	return "TestDynamoDBFilterExpr.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Expect__contains(haystack m_ComAmazonawsDynamodbTypes.AttributeValue, needle m_ComAmazonawsDynamodbTypes.AttributeValue, negate bool) {
	if (m_DynamoDBFilterExpr.Companion_Default___.Does__contain(haystack, needle)) != (negate) /* dircomp */ {
		if negate {
			_dafny.Print(haystack)
			_dafny.Print((_dafny.SeqOfString(" should not have contained ")).SetString())
			_dafny.Print(needle)
			_dafny.Print((_dafny.SeqOfString("but it did\n")).SetString())
		} else {
			_dafny.Print(haystack)
			_dafny.Print((_dafny.SeqOfString(" should have contained ")).SetString())
			_dafny.Print(needle)
			_dafny.Print((_dafny.SeqOfString("but it didn't\n")).SetString())
		}
	}
	if !((m_DynamoDBFilterExpr.Companion_Default___.Does__contain(haystack, needle)) == (negate)) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(29,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) UnicodeLessTest() {
	var _0_A _dafny.Sequence
	_ = _0_A
	_0_A = _dafny.SeqOfString("A")
	var _1_B _dafny.Sequence
	_ = _1_B
	_1_B = _dafny.SeqOfChars(53248)
	var _2_C _dafny.Sequence
	_ = _2_C
	_2_C = _dafny.SeqOfChars(65100)
	var _3_D _dafny.Sequence
	_ = _3_D
	_3_D = _dafny.SeqOfChars(55296, 56321)
	var _4_E _dafny.Sequence
	_ = _4_E
	_4_E = _dafny.SeqOfChars(55296, 56322)
	var _5_F _dafny.Sequence
	_ = _5_F
	_5_F = _dafny.SeqOfChars(55360, 56322)
	var _6_strs _dafny.Sequence
	_ = _6_strs
	_6_strs = _dafny.SeqOf(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_0_A, _1_B), _2_C), _3_D), _dafny.Companion_Sequence_.Concatenate(_1_B, _2_C), _dafny.Companion_Sequence_.Concatenate(_2_C, _3_D), _dafny.Companion_Sequence_.Concatenate(_3_D, _2_C), _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_3_D, _2_C), _1_B), _0_A), _dafny.Companion_Sequence_.Concatenate(_4_E, _3_D), _dafny.Companion_Sequence_.Concatenate(_5_F, _3_D))
	var _hi0 _dafny.Int = _dafny.IntOfUint32((_6_strs).Cardinality())
	_ = _hi0
	for _7_i := _dafny.Zero; _7_i.Cmp(_hi0) < 0; _7_i = _7_i.Plus(_dafny.One) {
		var _hi1 _dafny.Int = _dafny.IntOfUint32((_6_strs).Cardinality())
		_ = _hi1
		for _8_j := _dafny.Zero; _8_j.Cmp(_hi1) < 0; _8_j = _8_j.Plus(_dafny.One) {
			if !(((_7_i).Cmp(_8_j) < 0) == (m_DynamoDBFilterExpr.Companion_Default___.UnicodeLess((_6_strs).Select((_7_i).Uint32()).(_dafny.Sequence), (_6_strs).Select((_8_j).Uint32()).(_dafny.Sequence), _dafny.Zero))) {
				panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(52,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			if !(((_7_i).Cmp(_8_j) <= 0) == (!(m_DynamoDBFilterExpr.Companion_Default___.UnicodeLess((_6_strs).Select((_8_j).Uint32()).(_dafny.Sequence), (_6_strs).Select((_7_i).Uint32()).(_dafny.Sequence), _dafny.Zero)))) {
				panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(53,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) LowLevelTests() {
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ParseExpr(_dafny.SeqOfString("and")), _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Token_.Create_And_()))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ParseExpr(_dafny.SeqOfString("  AnD   ")), _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Token_.Create_And_()))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ParseExpr(_dafny.SeqOfString(" A  AnD  B ")), _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("A")), m_DynamoDBFilterExpr.Companion_Token_.Create_And_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("B"))))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ParseExpr(_dafny.SeqOfString(" A_B  AnD  B_C ")), _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("A_B")), m_DynamoDBFilterExpr.Companion_Token_.Create_And_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("B_C"))))
	var _0_input _dafny.Sequence
	_ = _0_input
	_0_input = _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Token_.Create_Not_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("A")), m_DynamoDBFilterExpr.Companion_Token_.Create_In_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Open_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("B")), m_DynamoDBFilterExpr.Companion_Token_.Create_Comma_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("C")), m_DynamoDBFilterExpr.Companion_Token_.Create_Close_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Or_())
	if !(m_DynamoDBFilterExpr.Companion_Default___.IsIN((_0_input).Drop(1))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(65,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ConvertToPrefix(_0_input), _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Token_.Create_Not_(), m_DynamoDBFilterExpr.Companion_Token_.Create_In_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Open_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("A")), m_DynamoDBFilterExpr.Companion_Token_.Create_Comma_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("B")), m_DynamoDBFilterExpr.Companion_Token_.Create_Comma_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("C")), m_DynamoDBFilterExpr.Companion_Token_.Create_Close_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Or_()))
	_0_input = _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Token_.Create_And_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Or_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Not_(), m_DynamoDBFilterExpr.Companion_Token_.Create_And_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Or_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Not_(), m_DynamoDBFilterExpr.Companion_Token_.Create_And_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Or_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Not_())
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ConvertToPrefix(_0_input), _0_input)
	_0_input = _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Token_.Create_Not_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("A")), m_DynamoDBFilterExpr.Companion_Token_.Create_In_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Open_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("B")), m_DynamoDBFilterExpr.Companion_Token_.Create_Comma_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("C")), m_DynamoDBFilterExpr.Companion_Token_.Create_Close_())
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ConvertToPrefix(_0_input), _dafny.SeqOf(m_DynamoDBFilterExpr.Companion_Token_.Create_Not_(), m_DynamoDBFilterExpr.Companion_Token_.Create_In_(), m_DynamoDBFilterExpr.Companion_Token_.Create_Open_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("A")), m_DynamoDBFilterExpr.Companion_Token_.Create_Comma_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("B")), m_DynamoDBFilterExpr.Companion_Token_.Create_Comma_(), m_DynamoDBFilterExpr.Companion_Default___.MakeAttr(_dafny.SeqOfString("C")), m_DynamoDBFilterExpr.Companion_Token_.Create_Close_()))
}
func (_static *CompanionStruct_Default___) TestExtractAttributes() {
	var _0_attrMap _dafny.Map
	_ = _0_attrMap
	_0_attrMap = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#one"), _dafny.SeqOfString("two")).UpdateUnsafe(_dafny.SeqOfString("#three"), _dafny.SeqOfString("four"))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString(""), m_Wrappers.Companion_Option_.Create_None_()), _dafny.SeqOf())
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString(""), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf())
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A < :b"), m_Wrappers.Companion_Option_.Create_None_()), _dafny.SeqOf(_dafny.SeqOfString("A")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A <= :b"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A < B"), m_Wrappers.Companion_Option_.Create_None_()), _dafny.SeqOf(_dafny.SeqOfString("A"), _dafny.SeqOfString("B")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A < B"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A"), _dafny.SeqOfString("B")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString(":a >= B"), m_Wrappers.Companion_Option_.Create_None_()), _dafny.SeqOf(_dafny.SeqOfString("B")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString(":a = B"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("B")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("#one <> B"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("two"), _dafny.SeqOfString("B")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A < #three"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A"), _dafny.SeqOfString("four")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("#one < #three"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("two"), _dafny.SeqOfString("four")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A in :a, :b, :c"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A between B and C"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A"), _dafny.SeqOfString("B"), _dafny.SeqOfString("C")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("not begins_with(A, :b)"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A < B or C <> D"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A"), _dafny.SeqOfString("B"), _dafny.SeqOfString("C"), _dafny.SeqOfString("D")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("contains(A, :b)"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("begins_with(A, :b)"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A")))
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("attribute_exists(A)"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf())
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("attribute_not_exists(A)"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf())
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("size(A)"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf())
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes(_dafny.SeqOfString("A < B or size(C) or D between E and F"), m_Wrappers.Companion_Option_.Create_Some_(_0_attrMap)), _dafny.SeqOf(_dafny.SeqOfString("A"), _dafny.SeqOfString("B"), _dafny.SeqOfString("D"), _dafny.SeqOfString("E"), _dafny.SeqOfString("F")))
}
func (_static *CompanionStruct_Default___) TestNoBeacons() {
	var _0_context m_DynamoDBFilterExpr.ExprContext
	_ = _0_context
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("A < :A AND B = :B")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":A"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1.23"))).UpdateUnsafe(_dafny.SeqOfString(":B"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc")))), m_Wrappers.Companion_Option_.Create_None_())
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetEmptyBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(117,25): " + (_3_valueOrError0).String())
	}
	var _4_beaconVersion m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_beaconVersion
	_4_beaconVersion = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(118,22): " + (_5_valueOrError1).String())
	}
	var _6_newContext m_DynamoDBFilterExpr.ExprContext
	_ = _6_newContext
	_6_newContext = (_5_valueOrError1).Extract().(m_DynamoDBFilterExpr.ExprContext)
	if !((_6_newContext).Equals(_0_context)) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(119,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestBasicParse() {
	var _0_context m_DynamoDBFilterExpr.ExprContext
	_ = _0_context
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :A AND #Field_4 = :B")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":A"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1.23"))).UpdateUnsafe(_dafny.SeqOfString(":B"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc")))), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#Field_4"), _dafny.SeqOfString("std4"))))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(136,25): " + (_3_valueOrError0).String())
	}
	var _4_beaconVersion m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_beaconVersion
	_4_beaconVersion = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_parsed _dafny.Sequence
	_ = _5_parsed
	_5_parsed = m_DynamoDBFilterExpr.Companion_Default___.ParseExpr(((_0_context).Dtor_filterExpr()).Dtor_value().(_dafny.Sequence))
	if !((_dafny.IntOfUint32((_5_parsed).Cardinality())).Cmp(_dafny.IntOfInt64(7)) == 0) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(138,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_parsed).Select(0).(m_DynamoDBFilterExpr.Token)).Is_Attr()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(139,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((_5_parsed).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s(), _dafny.SeqOfString("std2"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(140,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_4_beaconVersion).IsBeacon(((_5_parsed).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(141,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(m_DynamoDBFilterExpr.Companion_Default___.OpNeedsBeacon(_5_parsed, _dafny.Zero)) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(142,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_4_beaconVersion).Dtor_beacons()).Get(((_5_parsed).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s()).(m_SearchableEncryptionInfo.Beacon)).GetBeaconName(), _dafny.SeqOfString("aws_dbe_b_std2"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(143,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ParsedContext_.Default())
	_ = _6_valueOrError1
	_6_valueOrError1 = m_DynamoDBFilterExpr.Companion_Default___.BeaconizeParsedExpr(_4_beaconVersion, _5_parsed, _dafny.Zero, ((_0_context).Dtor_values()).Dtor_value().(_dafny.Map), (_0_context).Dtor_names(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_DontUseKeys_(), _dafny.NewMapBuilder().ToMap(), _dafny.SeqOf())
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(145,22): " + (_6_valueOrError1).String())
	}
	var _7_newContext m_DynamoDBFilterExpr.ParsedContext
	_ = _7_newContext
	_7_newContext = (_6_valueOrError1).Extract().(m_DynamoDBFilterExpr.ParsedContext)
	var _8_exprString _dafny.Sequence
	_ = _8_exprString
	_8_exprString = m_DynamoDBFilterExpr.Companion_Default___.ParsedExprToString((_7_newContext).Dtor_expr())
	if !(_dafny.Companion_Sequence_.Equal(_8_exprString, _dafny.SeqOfString("aws_dbe_b_std2 = :A AND #Field_4 = :B"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(147,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestNoBeaconFail() {
	var _0_context m_DynamoDBFilterExpr.ExprContext
	_ = _0_context
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :A AND #Field4 = :B")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":A"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1.23"))).UpdateUnsafe(_dafny.SeqOfString(":B"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc")))), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#Field4"), _dafny.SeqOfString("std4"))))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetEmptyBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(164,25): " + (_3_valueOrError0).String())
	}
	var _4_beaconVersion m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_beaconVersion
	_4_beaconVersion = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_parsed _dafny.Sequence
	_ = _5_parsed
	_5_parsed = m_DynamoDBFilterExpr.Companion_Default___.ParseExpr(((_0_context).Dtor_filterExpr()).Dtor_value().(_dafny.Sequence))
	if !((_dafny.IntOfUint32((_5_parsed).Cardinality())).Cmp(_dafny.IntOfInt64(7)) == 0) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(166,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_parsed).Select(0).(m_DynamoDBFilterExpr.Token)).Is_Attr()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(167,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((_5_parsed).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s(), _dafny.SeqOfString("std2"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(168,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_4_beaconVersion).IsBeacon(((_5_parsed).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(169,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(m_DynamoDBFilterExpr.Companion_Default___.OpNeedsBeacon(_5_parsed, _dafny.Zero)) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(170,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_4_beaconVersion).Dtor_beacons()).Get(((_5_parsed).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s()).(m_SearchableEncryptionInfo.Beacon)).GetBeaconName(), _dafny.SeqOfString("aws_dbe_b_std2"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(171,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_newContext m_Wrappers.Result
	_ = _6_newContext
	_6_newContext = m_DynamoDBFilterExpr.Companion_Default___.BeaconizeParsedExpr(_4_beaconVersion, _5_parsed, _dafny.Zero, ((_0_context).Dtor_values()).Dtor_value().(_dafny.Map), (_0_context).Dtor_names(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_DontUseKeys_(), _dafny.NewMapBuilder().ToMap(), _dafny.SeqOf())
	if !((_6_newContext).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(174,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_newContext).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Field std4 is encrypted, and cannot be searched without a beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(175,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_badBeacon m_Wrappers.Result
	_ = _7_badBeacon
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.TestBeaconize((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 <> :A AND #Field4 = :B")), m_Wrappers.Companion_Option_.Create_None_())
	_7_badBeacon = _out3
	if !((_7_badBeacon).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(178,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_7_badBeacon).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Query is using encrypted field : std2.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(179,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.TestBeaconize((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :A AND #Field4 = :B")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_7_badBeacon = _out4
	if !((_7_badBeacon).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(181,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_7_badBeacon).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Query is using encrypted field : std2.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(182,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestBasicBeacons() {
	var _0_context m_DynamoDBFilterExpr.ExprContext
	_ = _0_context
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :A AND #Field4 = :B")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":A"), m_BeaconTestFixtures.Companion_Default___.Std2String()).UpdateUnsafe(_dafny.SeqOfString(":B"), m_BeaconTestFixtures.Companion_Default___.Std4String())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#Field4"), _dafny.SeqOfString("std4"))))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(199,25): " + (_3_valueOrError0).String())
	}
	var _4_beaconVersion m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_beaconVersion
	_4_beaconVersion = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(200,22): " + (_5_valueOrError1).String())
	}
	var _6_newContext m_DynamoDBFilterExpr.ExprContext
	_ = _6_newContext
	_6_newContext = (_5_valueOrError1).Extract().(m_DynamoDBFilterExpr.ExprContext)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal((_6_newContext).Dtor_filterExpr(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("aws_dbe_b_std2 = :A AND #Field4 = :B")))
	var _7_newName _dafny.Sequence
	_ = _7_newName
	_7_newName = _dafny.SeqOfString("aws_dbe_b_std4")
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_7_newName)) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(203,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_expectedNames _dafny.Map
	_ = _8_expectedNames
	_8_expectedNames = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#Field4"), _7_newName)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal((_6_newContext).Dtor_names(), m_Wrappers.Companion_Option_.Create_Some_(_8_expectedNames))
	var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _9_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_4_beaconVersion).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_9_valueOrError2 = _out4
	if !(!((_9_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(206,23): " + (_9_valueOrError2).String())
	}
	var _10_itemBeacons _dafny.Map
	_ = _10_itemBeacons
	_10_itemBeacons = (_9_valueOrError2).Extract().(_dafny.Map)
	if !((_10_itemBeacons).Contains(_dafny.SeqOfString("aws_dbe_b_std2"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(207,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_10_itemBeacons).Contains(_dafny.SeqOfString("aws_dbe_b_std4"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(208,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	m_BeaconTestFixtures.Companion_Default___.Expect__equal((_6_newContext).Dtor_values(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":A"), (_10_itemBeacons).Get(_dafny.SeqOfString("aws_dbe_b_std2")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).UpdateUnsafe(_dafny.SeqOfString(":B"), (_10_itemBeacons).Get(_dafny.SeqOfString("aws_dbe_b_std4")).(m_ComAmazonawsDynamodbTypes.AttributeValue))))
}
func (_static *CompanionStruct_Default___) TestMultiContextFailures() {
	var _0_context m_DynamoDBFilterExpr.ExprContext
	_ = _0_context
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :A AND std4 = :A")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":A"), m_BeaconTestFixtures.Companion_Default___.Std2String())), m_Wrappers.Companion_Option_.Create_None_())
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(228,25): " + (_3_valueOrError0).String())
	}
	var _4_beaconVersion m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_beaconVersion
	_4_beaconVersion = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_newContext m_Wrappers.Result
	_ = _5_newContext
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_5_newContext = _out3
	if !((_5_newContext).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(230,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newContext).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString(":A used in two different contexts, which is not allowed.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(231,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :A AND std4 = :A")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":A"), m_BeaconTestFixtures.Companion_Default___.Std2String())), m_Wrappers.Companion_Option_.Create_None_())
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_5_newContext = _out4
	if !((_5_newContext).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(242,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newContext).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString(":A used in two different contexts, which is not allowed.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(243,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :A")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std4 = :A")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":A"), m_BeaconTestFixtures.Companion_Default___.Std2String())), m_Wrappers.Companion_Option_.Create_None_())
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_5_newContext = _out5
	if !((_5_newContext).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(254,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newContext).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString(":A used in two different contexts, which is not allowed.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(255,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) DS(x _dafny.Sequence) m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(x)
}
func (_static *CompanionStruct_Default___) DN(x _dafny.Sequence) m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(x)
}
func (_static *CompanionStruct_Default___) TestFilterCompare() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DS(_dafny.SeqOfString("abc"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DS(_dafny.SeqOfString("cde"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DS(_dafny.SeqOfString("cde")))
	var _1_values _dafny.Map
	_ = _1_values
	_1_values = _dafny.NewMapBuilder().ToMap()
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_3_src = _out1
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _3_src)
	_4_valueOrError0 = _out2
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(277,14): " + (_4_valueOrError0).String())
	}
	var _5_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _5_bv
	_5_bv = (_4_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _6_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one < two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_6_valueOrError1 = _out3
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(278,20): " + (_6_valueOrError1).String())
	}
	var _7_newItems _dafny.Sequence
	_ = _7_newItems
	_7_newItems = (_6_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one > two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_8_valueOrError2 = _out4
	if !(!((_8_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(280,16): " + (_8_valueOrError2).String())
	}
	_7_newItems = (_8_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one <= two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_9_valueOrError3 = _out5
	if !(!((_9_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(282,16): " + (_9_valueOrError3).String())
	}
	_7_newItems = (_9_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one >= two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_10_valueOrError4 = _out6
	if !(!((_10_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(284,16): " + (_10_valueOrError4).String())
	}
	_7_newItems = (_10_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _11_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _11_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one <> two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_11_valueOrError5 = _out7
	if !(!((_11_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(286,16): " + (_11_valueOrError5).String())
	}
	_7_newItems = (_11_valueOrError5).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _12_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _12_valueOrError6
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one = two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_12_valueOrError6 = _out8
	if !(!((_12_valueOrError6).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(288,16): " + (_12_valueOrError6).String())
	}
	_7_newItems = (_12_valueOrError6).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _13_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _13_valueOrError7
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three < two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_13_valueOrError7 = _out9
	if !(!((_13_valueOrError7).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(291,16): " + (_13_valueOrError7).String())
	}
	_7_newItems = (_13_valueOrError7).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _14_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _14_valueOrError8
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three > two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_14_valueOrError8 = _out10
	if !(!((_14_valueOrError8).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(293,16): " + (_14_valueOrError8).String())
	}
	_7_newItems = (_14_valueOrError8).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _15_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _15_valueOrError9
	var _out11 m_Wrappers.Result
	_ = _out11
	_out11 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three <= two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_15_valueOrError9 = _out11
	if !(!((_15_valueOrError9).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(295,16): " + (_15_valueOrError9).String())
	}
	_7_newItems = (_15_valueOrError9).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _16_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _16_valueOrError10
	var _out12 m_Wrappers.Result
	_ = _out12
	_out12 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three >= two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_16_valueOrError10 = _out12
	if !(!((_16_valueOrError10).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(297,16): " + (_16_valueOrError10).String())
	}
	_7_newItems = (_16_valueOrError10).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _17_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _17_valueOrError11
	var _out13 m_Wrappers.Result
	_ = _out13
	_out13 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three <> two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_17_valueOrError11 = _out13
	if !(!((_17_valueOrError11).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(299,16): " + (_17_valueOrError11).String())
	}
	_7_newItems = (_17_valueOrError11).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _18_valueOrError12 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _18_valueOrError12
	var _out14 m_Wrappers.Result
	_ = _out14
	_out14 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three = two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_18_valueOrError12 = _out14
	if !(!((_18_valueOrError12).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(301,16): " + (_18_valueOrError12).String())
	}
	_7_newItems = (_18_valueOrError12).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
}
func (_static *CompanionStruct_Default___) TestFilterFailNumeric() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DN(_dafny.SeqOfString("800")))
	var _1_values _dafny.Map
	_ = _1_values
	_1_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":two"), Companion_Default___.DN(_dafny.SeqOfString("foo")))
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_3_src = _out1
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _3_src)
	_4_valueOrError0 = _out2
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(314,14): " + (_4_valueOrError0).String())
	}
	var _5_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _5_bv
	_5_bv = (_4_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _6_newItems m_Wrappers.Result
	_ = _6_newItems
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one < :two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_6_newItems = _out3
	if !((_6_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(316,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_newItems).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Number needs digits either before or after the decimal point. when parsing 'foo'.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(317,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestFilterCompareNumeric() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DN(_dafny.SeqOfString("800")))
	var _1_values _dafny.Map
	_ = _1_values
	_1_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":two"), Companion_Default___.DN(_dafny.SeqOfString("0800.000e0")))
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_3_src = _out1
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _3_src)
	_4_valueOrError0 = _out2
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(329,14): " + (_4_valueOrError0).String())
	}
	var _5_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _5_bv
	_5_bv = (_4_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _6_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one < :two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_6_valueOrError1 = _out3
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(330,20): " + (_6_valueOrError1).String())
	}
	var _7_newItems _dafny.Sequence
	_ = _7_newItems
	_7_newItems = (_6_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one > :two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_8_valueOrError2 = _out4
	if !(!((_8_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(332,16): " + (_8_valueOrError2).String())
	}
	_7_newItems = (_8_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one <= :two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_9_valueOrError3 = _out5
	if !(!((_9_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(334,16): " + (_9_valueOrError3).String())
	}
	_7_newItems = (_9_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one >= :two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_10_valueOrError4 = _out6
	if !(!((_10_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(336,16): " + (_10_valueOrError4).String())
	}
	_7_newItems = (_10_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _11_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _11_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one <> :two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_11_valueOrError5 = _out7
	if !(!((_11_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(338,16): " + (_11_valueOrError5).String())
	}
	_7_newItems = (_11_valueOrError5).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _12_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _12_valueOrError6
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one = :two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_12_valueOrError6 = _out8
	if !(!((_12_valueOrError6).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(340,16): " + (_12_valueOrError6).String())
	}
	_7_newItems = (_12_valueOrError6).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _13_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _13_valueOrError7
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":two < one")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_13_valueOrError7 = _out9
	if !(!((_13_valueOrError7).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(343,16): " + (_13_valueOrError7).String())
	}
	_7_newItems = (_13_valueOrError7).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _14_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _14_valueOrError8
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":two > one")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_14_valueOrError8 = _out10
	if !(!((_14_valueOrError8).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(345,16): " + (_14_valueOrError8).String())
	}
	_7_newItems = (_14_valueOrError8).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _15_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _15_valueOrError9
	var _out11 m_Wrappers.Result
	_ = _out11
	_out11 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":two <= one")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_15_valueOrError9 = _out11
	if !(!((_15_valueOrError9).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(347,16): " + (_15_valueOrError9).String())
	}
	_7_newItems = (_15_valueOrError9).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _16_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _16_valueOrError10
	var _out12 m_Wrappers.Result
	_ = _out12
	_out12 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":two >= one")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_16_valueOrError10 = _out12
	if !(!((_16_valueOrError10).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(349,16): " + (_16_valueOrError10).String())
	}
	_7_newItems = (_16_valueOrError10).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _17_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _17_valueOrError11
	var _out13 m_Wrappers.Result
	_ = _out13
	_out13 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":two <> one")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_17_valueOrError11 = _out13
	if !(!((_17_valueOrError11).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(351,16): " + (_17_valueOrError11).String())
	}
	_7_newItems = (_17_valueOrError11).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _18_valueOrError12 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _18_valueOrError12
	var _out14 m_Wrappers.Result
	_ = _out14
	_out14 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":two = one")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_18_valueOrError12 = _out14
	if !(!((_18_valueOrError12).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(353,16): " + (_18_valueOrError12).String())
	}
	_7_newItems = (_18_valueOrError12).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
}
func (_static *CompanionStruct_Default___) TestFilterIn() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DS(_dafny.SeqOfString("abc"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DS(_dafny.SeqOfString("cde"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DS(_dafny.SeqOfString("cde")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(365,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one in (two, three)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(366,20): " + (_5_valueOrError1).String())
	}
	var _6_newItems _dafny.Sequence
	_ = _6_newItems
	_6_newItems = (_5_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two in (one, three)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(368,16): " + (_7_valueOrError2).String())
	}
	_6_newItems = (_7_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three in (two, one)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_8_valueOrError3 = _out5
	if !(!((_8_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(370,16): " + (_8_valueOrError3).String())
	}
	_6_newItems = (_8_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three in (one, one, one, one, two, one, one)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_9_valueOrError4 = _out6
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(372,16): " + (_9_valueOrError4).String())
	}
	_6_newItems = (_9_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("three in (one, one, one, one, one, one, one)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_10_valueOrError5 = _out7
	if !(!((_10_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(374,16): " + (_10_valueOrError5).String())
	}
	_6_newItems = (_10_valueOrError5).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) TestFilterBetweenAlpha() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DS(_dafny.SeqOfString("abc"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DS(_dafny.SeqOfString("bcd"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DS(_dafny.SeqOfString("cde")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(386,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one between two and three")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(387,20): " + (_5_valueOrError1).String())
	}
	var _6_newItems _dafny.Sequence
	_ = _6_newItems
	_6_newItems = (_5_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two between one and three")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(389,16): " + (_7_valueOrError2).String())
	}
	_6_newItems = (_7_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two between three and one")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_8_valueOrError3 = _out5
	if !(!((_8_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(391,16): " + (_8_valueOrError3).String())
	}
	_6_newItems = (_8_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two between two and three")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_9_valueOrError4 = _out6
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(393,16): " + (_9_valueOrError4).String())
	}
	_6_newItems = (_9_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two between one and two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_10_valueOrError5 = _out7
	if !(!((_10_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(395,16): " + (_10_valueOrError5).String())
	}
	_6_newItems = (_10_valueOrError5).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
}
func (_static *CompanionStruct_Default___) TestFilterBetweenNumber() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DN(_dafny.SeqOfString("9"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DN(_dafny.SeqOfString("52"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DN(_dafny.SeqOfString("185")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(407,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one between two and three")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(408,20): " + (_5_valueOrError1).String())
	}
	var _6_newItems _dafny.Sequence
	_ = _6_newItems
	_6_newItems = (_5_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two between one and three")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(410,16): " + (_7_valueOrError2).String())
	}
	_6_newItems = (_7_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two between three and one")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_8_valueOrError3 = _out5
	if !(!((_8_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(412,16): " + (_8_valueOrError3).String())
	}
	_6_newItems = (_8_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two between two and three")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_9_valueOrError4 = _out6
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(414,16): " + (_9_valueOrError4).String())
	}
	_6_newItems = (_9_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("two between one and two")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_10_valueOrError5 = _out7
	if !(!((_10_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(416,16): " + (_10_valueOrError5).String())
	}
	_6_newItems = (_10_valueOrError5).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
}
func (_static *CompanionStruct_Default___) TestFilterSize() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DN(_dafny.SeqOfString("9"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DN(_dafny.SeqOfString("52"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DN(_dafny.SeqOfString("185")))
	var _1_values m_Wrappers.Option
	_ = _1_values
	_1_values = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":uno"), Companion_Default___.DN(_dafny.SeqOfString("1"))).UpdateUnsafe(_dafny.SeqOfString(":dos"), Companion_Default___.DN(_dafny.SeqOfString("2"))).UpdateUnsafe(_dafny.SeqOfString(":tres"), Companion_Default___.DN(_dafny.SeqOfString("3"))))
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_3_src = _out1
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _3_src)
	_4_valueOrError0 = _out2
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(433,14): " + (_4_valueOrError0).String())
	}
	var _5_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _5_bv
	_5_bv = (_4_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _6_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("size(one) = :uno")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_6_valueOrError1 = _out3
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(434,20): " + (_6_valueOrError1).String())
	}
	var _7_newItems _dafny.Sequence
	_ = _7_newItems
	_7_newItems = (_6_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("size(two) between :uno and :tres")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_8_valueOrError2 = _out4
	if !(!((_8_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(436,16): " + (_8_valueOrError2).String())
	}
	_7_newItems = (_8_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("size(three) > :dos")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_9_valueOrError3 = _out5
	if !(!((_9_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(438,16): " + (_9_valueOrError3).String())
	}
	_7_newItems = (_9_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("size(two) in (:uno, :dos)")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_10_valueOrError4 = _out6
	if !(!((_10_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(440,16): " + (_10_valueOrError4).String())
	}
	_7_newItems = (_10_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _11_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _11_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("size(two) in (:uno, :tres)")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_11_valueOrError5 = _out7
	if !(!((_11_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(442,16): " + (_11_valueOrError5).String())
	}
	_7_newItems = (_11_valueOrError5).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) TestFilterContains() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DN(_dafny.SeqOfString("abcdef"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DN(_dafny.SeqOfString("a"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DN(_dafny.SeqOfString("f"))).UpdateUnsafe(_dafny.SeqOfString("four"), Companion_Default___.DN(_dafny.SeqOfString("cde"))).UpdateUnsafe(_dafny.SeqOfString("five"), Companion_Default___.DN(_dafny.SeqOfString("efg")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(456,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("contains(one, two)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(457,20): " + (_5_valueOrError1).String())
	}
	var _6_newItems _dafny.Sequence
	_ = _6_newItems
	_6_newItems = (_5_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("contains(one, three)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(459,16): " + (_7_valueOrError2).String())
	}
	_6_newItems = (_7_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("contains(one, four)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_8_valueOrError3 = _out5
	if !(!((_8_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(461,16): " + (_8_valueOrError3).String())
	}
	_6_newItems = (_8_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("contains(one, five)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_9_valueOrError4 = _out6
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(463,16): " + (_9_valueOrError4).String())
	}
	_6_newItems = (_9_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) TestFilterBegins() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DN(_dafny.SeqOfString("abcdef"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DN(_dafny.SeqOfString("a"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DN(_dafny.SeqOfString("f"))).UpdateUnsafe(_dafny.SeqOfString("four"), Companion_Default___.DN(_dafny.SeqOfString("abcd"))).UpdateUnsafe(_dafny.SeqOfString("five"), Companion_Default___.DN(_dafny.SeqOfString("abcdf")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(478,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("begins_with(one, two)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(479,20): " + (_5_valueOrError1).String())
	}
	var _6_newItems _dafny.Sequence
	_ = _6_newItems
	_6_newItems = (_5_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("begins_with(one, three)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(481,16): " + (_7_valueOrError2).String())
	}
	_6_newItems = (_7_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
	var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("begins_with(one, four)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_8_valueOrError3 = _out5
	if !(!((_8_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(483,16): " + (_8_valueOrError3).String())
	}
	_6_newItems = (_8_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(_0_item1))
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("begins_with(one, five)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	_9_valueOrError4 = _out6
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(485,16): " + (_9_valueOrError4).String())
	}
	_6_newItems = (_9_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) TestFilterComplex() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DN(_dafny.SeqOfString("1"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DN(_dafny.SeqOfString("2"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DN(_dafny.SeqOfString("3")))
	var _1_values m_Wrappers.Option
	_ = _1_values
	_1_values = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":four"), Companion_Default___.DN(_dafny.SeqOfString("4"))).UpdateUnsafe(_dafny.SeqOfString(":five"), Companion_Default___.DN(_dafny.SeqOfString("5"))).UpdateUnsafe(_dafny.SeqOfString(":six"), Companion_Default___.DN(_dafny.SeqOfString("6"))))
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_3_src = _out1
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _3_src)
	_4_valueOrError0 = _out2
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(502,14): " + (_4_valueOrError0).String())
	}
	var _5_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _5_bv
	_5_bv = (_4_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _6_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one < :four and two < :five")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_6_valueOrError1 = _out3
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(503,20): " + (_6_valueOrError1).String())
	}
	var _7_newItems _dafny.Sequence
	_ = _7_newItems
	_7_newItems = (_6_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one < :four or two > :five")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_8_valueOrError2 = _out4
	if !(!((_8_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(505,16): " + (_8_valueOrError2).String())
	}
	_7_newItems = (_8_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
}
func (_static *CompanionStruct_Default___) TestFilterIndirectNames() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DS(_dafny.SeqOfString("abc"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DS(_dafny.SeqOfString("cde"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DS(_dafny.SeqOfString("cde")))
	var _1_values _dafny.Map
	_ = _1_values
	_1_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":uno"), Companion_Default___.DS(_dafny.SeqOfString("ab"))).UpdateUnsafe(_dafny.SeqOfString(":dos"), Companion_Default___.DS(_dafny.SeqOfString("bc")))
	var _2_names _dafny.Map
	_ = _2_names
	_2_names = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#eine"), _dafny.SeqOfString("one")).UpdateUnsafe(_dafny.SeqOfString("#zwei"), _dafny.SeqOfString("two")).UpdateUnsafe(_dafny.SeqOfString("#drei"), _dafny.SeqOfString("three"))
	var _3_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_3_version = _out0
	var _4_src m_SearchableEncryptionInfo.KeySource
	_ = _4_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _3_version)
	_4_src = _out1
	var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _3_version, _4_src)
	_5_valueOrError0 = _out2
	if !(!((_5_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(528,14): " + (_5_valueOrError0).String())
	}
	var _6_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _6_bv
	_6_bv = (_5_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _7_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_6_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one < two")), m_Wrappers.Companion_Option_.Create_Some_(_2_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_7_valueOrError1 = _out3
	if !(!((_7_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(529,20): " + (_7_valueOrError1).String())
	}
	var _8_newItems _dafny.Sequence
	_ = _8_newItems
	_8_newItems = (_7_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_8_newItems, _dafny.SeqOf(_0_item1))
	var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_6_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("one > two")), m_Wrappers.Companion_Option_.Create_Some_(_2_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_9_valueOrError2 = _out4
	if !(!((_9_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(531,16): " + (_9_valueOrError2).String())
	}
	_8_newItems = (_9_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_8_newItems, _dafny.SeqOf())
	var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_6_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("#eine < #zwei")), m_Wrappers.Companion_Option_.Create_Some_(_2_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_10_valueOrError3 = _out5
	if !(!((_10_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(533,16): " + (_10_valueOrError3).String())
	}
	_8_newItems = (_10_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_8_newItems, _dafny.SeqOf(_0_item1))
	var _11_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _11_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_6_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("#eine > #zwei")), m_Wrappers.Companion_Option_.Create_Some_(_2_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_11_valueOrError4 = _out6
	if !(!((_11_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(535,16): " + (_11_valueOrError4).String())
	}
	_8_newItems = (_11_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_8_newItems, _dafny.SeqOf())
	var _12_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _12_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_6_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("#eine < :dos")), m_Wrappers.Companion_Option_.Create_Some_(_2_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_12_valueOrError5 = _out7
	if !(!((_12_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(537,16): " + (_12_valueOrError5).String())
	}
	_8_newItems = (_12_valueOrError5).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_8_newItems, _dafny.SeqOf(_0_item1))
	var _13_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _13_valueOrError6
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_6_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("#eine > :dos")), m_Wrappers.Companion_Option_.Create_Some_(_2_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_13_valueOrError6 = _out8
	if !(!((_13_valueOrError6).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(539,16): " + (_13_valueOrError6).String())
	}
	_8_newItems = (_13_valueOrError6).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_8_newItems, _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) TestFilterIndirectNamesWithLoc() {
	var _0_values _dafny.Map
	_ = _0_values
	_0_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":uno"), Companion_Default___.DS(_dafny.SeqOfString("ab"))).UpdateUnsafe(_dafny.SeqOfString(":dos"), Companion_Default___.DN(_dafny.SeqOfString("2")))
	var _1_names _dafny.Map
	_ = _1_names
	_1_names = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#eine"), _dafny.SeqOfString("Date")).UpdateUnsafe(_dafny.SeqOfString("#zwei"), _dafny.SeqOfString("Month")).UpdateUnsafe(_dafny.SeqOfString("#drei"), _dafny.SeqOfString("Year"))
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_3_src = _out1
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _3_src)
	_4_valueOrError0 = _out2
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(558,14): " + (_4_valueOrError0).String())
	}
	var _5_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _5_bv
	_5_bv = (_4_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _6_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("Date.Month < :uno")), m_Wrappers.Companion_Option_.Create_Some_(_1_names), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_6_valueOrError1 = _out3
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(559,20): " + (_6_valueOrError1).String())
	}
	var _7_newItems _dafny.Sequence
	_ = _7_newItems
	_7_newItems = (_6_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("Date.Month > :uno")), m_Wrappers.Companion_Option_.Create_Some_(_1_names), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_8_valueOrError2 = _out4
	if !(!((_8_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(561,16): " + (_8_valueOrError2).String())
	}
	_7_newItems = (_8_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("Date.#zwei < :uno")), m_Wrappers.Companion_Option_.Create_Some_(_1_names), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_9_valueOrError3 = _out5
	if !(!((_9_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(563,16): " + (_9_valueOrError3).String())
	}
	_7_newItems = (_9_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("Date.#zwei > :uno")), m_Wrappers.Companion_Option_.Create_Some_(_1_names), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_10_valueOrError4 = _out6
	if !(!((_10_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(565,16): " + (_10_valueOrError4).String())
	}
	_7_newItems = (_10_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) TestFilterAttrOps() {
	var _0_names _dafny.Map
	_ = _0_names
	_0_names = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#fecha"), _dafny.SeqOfString("Date"))
	var _1_values _dafny.Map
	_ = _1_values
	_1_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":m"), Companion_Default___.DS(_dafny.SeqOfString("M"))).UpdateUnsafe(_dafny.SeqOfString(":s"), Companion_Default___.DS(_dafny.SeqOfString("N")))
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_3_src = _out1
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _3_src)
	_4_valueOrError0 = _out2
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(580,14): " + (_4_valueOrError0).String())
	}
	var _5_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _5_bv
	_5_bv = (_4_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _6_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("attribute_exists(Date)")), m_Wrappers.Companion_Option_.Create_Some_(_0_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_6_valueOrError1 = _out3
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(581,20): " + (_6_valueOrError1).String())
	}
	var _7_newItems _dafny.Sequence
	_ = _7_newItems
	_7_newItems = (_6_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("attribute_exists(Nope)")), m_Wrappers.Companion_Option_.Create_Some_(_0_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_8_valueOrError2 = _out4
	if !(!((_8_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(583,16): " + (_8_valueOrError2).String())
	}
	_7_newItems = (_8_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("attribute_not_exists(Date)")), m_Wrappers.Companion_Option_.Create_Some_(_0_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_9_valueOrError3 = _out5
	if !(!((_9_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(585,16): " + (_9_valueOrError3).String())
	}
	_7_newItems = (_9_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("attribute_not_exists(Nope)")), m_Wrappers.Companion_Option_.Create_Some_(_0_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_10_valueOrError4 = _out6
	if !(!((_10_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(587,16): " + (_10_valueOrError4).String())
	}
	_7_newItems = (_10_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _11_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _11_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("attribute_type(Date, :m)")), m_Wrappers.Companion_Option_.Create_Some_(_0_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_11_valueOrError5 = _out7
	if !(!((_11_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(589,16): " + (_11_valueOrError5).String())
	}
	_7_newItems = (_11_valueOrError5).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _12_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _12_valueOrError6
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("attribute_type(std2, :s)")), m_Wrappers.Companion_Option_.Create_Some_(_0_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_12_valueOrError6 = _out8
	if !(!((_12_valueOrError6).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(591,16): " + (_12_valueOrError6).String())
	}
	_7_newItems = (_12_valueOrError6).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _13_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _13_valueOrError7
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("not attribute_exists(Date)")), m_Wrappers.Companion_Option_.Create_Some_(_0_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_13_valueOrError7 = _out9
	if !(!((_13_valueOrError7).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(593,16): " + (_13_valueOrError7).String())
	}
	_7_newItems = (_13_valueOrError7).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
	var _14_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _14_valueOrError8
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("not attribute_exists(Nope)")), m_Wrappers.Companion_Option_.Create_Some_(_0_names), m_Wrappers.Companion_Option_.Create_Some_(_1_values))
	_14_valueOrError8 = _out10
	if !(!((_14_valueOrError8).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(595,16): " + (_14_valueOrError8).String())
	}
	_7_newItems = (_14_valueOrError8).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
}
func (_static *CompanionStruct_Default___) TestFilterSizeIn() {
	var _0_item1 _dafny.Map
	_ = _0_item1
	_0_item1 = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("one"), Companion_Default___.DN(_dafny.SeqOfString("9"))).UpdateUnsafe(_dafny.SeqOfString("two"), Companion_Default___.DN(_dafny.SeqOfString("52"))).UpdateUnsafe(_dafny.SeqOfString("three"), Companion_Default___.DN(_dafny.SeqOfString("185")))
	var _1_values m_Wrappers.Option
	_ = _1_values
	_1_values = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":uno"), Companion_Default___.DN(_dafny.SeqOfString("1"))).UpdateUnsafe(_dafny.SeqOfString(":dos"), Companion_Default___.DN(_dafny.SeqOfString("2"))).UpdateUnsafe(_dafny.SeqOfString(":tres"), Companion_Default___.DN(_dafny.SeqOfString("3"))))
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_3_src = _out1
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _3_src)
	_4_valueOrError0 = _out2
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(612,14): " + (_4_valueOrError0).String())
	}
	var _5_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _5_bv
	_5_bv = (_4_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _6_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("size(one) in (:uno, :dos, :tres)")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_6_valueOrError1 = _out3
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(613,20): " + (_6_valueOrError1).String())
	}
	var _7_newItems _dafny.Sequence
	_ = _7_newItems
	_7_newItems = (_6_valueOrError1).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":uno in (size(one), :dos, :tres)")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_8_valueOrError2 = _out4
	if !(!((_8_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(615,16): " + (_8_valueOrError2).String())
	}
	_7_newItems = (_8_valueOrError2).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":uno in (:dos, :tres, size(one))")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_9_valueOrError3 = _out5
	if !(!((_9_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(617,16): " + (_9_valueOrError3).String())
	}
	_7_newItems = (_9_valueOrError3).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf(_0_item1))
	var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_5_bv, _dafny.SeqOf(_0_item1), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString(":uno in (:dos, :tres)")), m_Wrappers.Companion_Option_.Create_None_(), _1_values)
	_10_valueOrError4 = _out6
	if !(!((_10_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(619,16): " + (_10_valueOrError4).String())
	}
	_7_newItems = (_10_valueOrError4).Extract().(_dafny.Sequence)
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_7_newItems, _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) TestFilterBeacons() {
	var _0_values _dafny.Map
	_ = _0_values
	_0_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":val2"), Companion_Default___.DN(_dafny.SeqOfString("1.23"))).UpdateUnsafe(_dafny.SeqOfString(":val3"), Companion_Default___.DS(_dafny.SeqOfString("N_MyName.T_MyTitle"))).UpdateUnsafe(_dafny.SeqOfString(":val4"), Companion_Default___.DS(_dafny.SeqOfString("T_MyTitle"))).UpdateUnsafe(_dafny.SeqOfString(":val5"), Companion_Default___.DS(_dafny.SeqOfString("MyName__mytitle")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(634,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :val2")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(635,20): " + (_5_valueOrError1).String())
	}
	var _6_newItems _dafny.Sequence
	_ = _6_newItems
	_6_newItems = (_5_valueOrError1).Extract().(_dafny.Sequence)
	if !((_dafny.IntOfUint32((_6_newItems).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(636,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle = :val3")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(638,16): " + (_7_valueOrError2).String())
	}
	_6_newItems = (_7_valueOrError2).Extract().(_dafny.Sequence)
	if !((_dafny.IntOfUint32((_6_newItems).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(639,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("contains(NameTitle, :val4)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_8_valueOrError3 = _out5
	if !(!((_8_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(641,16): " + (_8_valueOrError3).String())
	}
	_6_newItems = (_8_valueOrError3).Extract().(_dafny.Sequence)
	if !((_dafny.IntOfUint32((_6_newItems).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(642,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitleField = :val5)")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_9_valueOrError4 = _out6
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(644,16): " + (_9_valueOrError4).String())
	}
	_6_newItems = (_9_valueOrError4).Extract().(_dafny.Sequence)
	if !((_dafny.IntOfUint32((_6_newItems).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(645,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	m_BeaconTestFixtures.Companion_Default___.Expect__equal(_6_newItems, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()))
}
func (_static *CompanionStruct_Default___) TestBadBetween() {
	var _0_values _dafny.Map
	_ = _0_values
	_0_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":val3"), Companion_Default___.DS(_dafny.SeqOfString("T_ATitle"))).UpdateUnsafe(_dafny.SeqOfString(":val4"), Companion_Default___.DS(_dafny.SeqOfString("T_MyTitle")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(658,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_newItems m_Wrappers.Result
	_ = _5_newItems
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle between :val3 and :val4")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out3
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(660,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newItems).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("To use BETWEEN with a compound beacon, the part after any common prefix must be LessThanComparable : BETWEEN T_ATitle AND T_MyTitle")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(661,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestBadStandard() {
	var _0_values _dafny.Map
	_ = _0_values
	_0_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":val"), Companion_Default___.DS(_dafny.SeqOfString("foo")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(672,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_newItems m_Wrappers.Result
	_ = _5_newItems
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 = :val")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out3
	if !((_5_newItems).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(674,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 <> :val")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out4
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(676,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newItems).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("The operation '<>' cannot be used with a standard beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(677,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 < :val")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out5
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(679,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newItems).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("The operation '<' cannot be used with a standard beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(680,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 > :val")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out6
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(682,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newItems).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("The operation '>' cannot be used with a standard beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(683,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 <= :val")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out7
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(685,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newItems).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("The operation '<=' cannot be used with a standard beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(686,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std2 >= :val")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out8
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(688,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newItems).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("The operation '>=' cannot be used with a standard beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(689,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestComparisons() {
	var _0_values _dafny.Map
	_ = _0_values
	_0_values = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":val1"), Companion_Default___.DS(_dafny.SeqOfString("N_"))).UpdateUnsafe(_dafny.SeqOfString(":val2"), Companion_Default___.DS(_dafny.SeqOfString("N_MyName"))).UpdateUnsafe(_dafny.SeqOfString(":val3"), Companion_Default___.DS(_dafny.SeqOfString("N_MyName.T_"))).UpdateUnsafe(_dafny.SeqOfString(":val4"), Companion_Default___.DS(_dafny.SeqOfString("N_MyName.T_Title"))).UpdateUnsafe(_dafny.SeqOfString(":val5"), Companion_Default___.DS(_dafny.SeqOfString("T_"))).UpdateUnsafe(_dafny.SeqOfString(":val6"), Companion_Default___.DS(_dafny.SeqOfString("N_MyName.N_")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_valueOrError0 = _out2
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(705,14): " + (_3_valueOrError0).String())
	}
	var _4_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_bv
	_4_bv = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_newItems m_Wrappers.Result
	_ = _5_newItems
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle between :val1 and :val5")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out3
	if !((_5_newItems).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(708,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle between :val3 and :val6")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out4
	if !((_5_newItems).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(710,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle between :val2 and :val3")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out5
	if !((_5_newItems).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(712,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle between :val1 and :val2")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out6
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(715,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle between :val1 and :val4")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out7
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(717,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle < :val1")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out8
	if !((_5_newItems).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(720,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle = :val1")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out9
	if !((_5_newItems).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(722,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle < :val2")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out10
	if !((_5_newItems).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(724,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out11 m_Wrappers.Result
	_ = _out11
	_out11 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_4_bv, _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.SimpleItem()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle = :val2")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_0_values))
	_5_newItems = _out11
	if !((_5_newItems).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(726,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _6_valueOrError1
	var _out12 m_Wrappers.Result
	_ = _out12
	_out12 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_bv, m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle = :val1")), m_Wrappers.Companion_Option_.Create_Some_(_0_values), m_Wrappers.Companion_Option_.Create_None_()), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_6_valueOrError1 = _out12
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(728,22): " + (_6_valueOrError1).String())
	}
	var _7_newContext m_DynamoDBFilterExpr.ExprContext
	_ = _7_newContext
	_7_newContext = (_6_valueOrError1).Extract().(m_DynamoDBFilterExpr.ExprContext)
	if !(((_7_newContext).Dtor_values()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(729,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_newContext).Dtor_values()).Dtor_value().(_dafny.Map)).Contains(_dafny.SeqOfString(":val1"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(730,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_newContext).Dtor_values()).Dtor_value().(_dafny.Map)).Get(_dafny.SeqOfString(":val1")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(Companion_Default___.DS(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("N_"), m_BeaconTestFixtures.Companion_Default___.EmptyName__beacon())))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(731,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _8_valueOrError2
	var _out13 m_Wrappers.Result
	_ = _out13
	_out13 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_bv, m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("NameTitle < :val1")), m_Wrappers.Companion_Option_.Create_Some_(_0_values), m_Wrappers.Companion_Option_.Create_None_()), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_8_valueOrError2 = _out13
	if !(!((_8_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(732,18): " + (_8_valueOrError2).String())
	}
	_7_newContext = (_8_valueOrError2).Extract().(m_DynamoDBFilterExpr.ExprContext)
	if !(((_7_newContext).Dtor_values()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(733,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_newContext).Dtor_values()).Dtor_value().(_dafny.Map)).Contains(_dafny.SeqOfString(":val1"))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(734,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_newContext).Dtor_values()).Dtor_value().(_dafny.Map)).Get(_dafny.SeqOfString(":val1")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(Companion_Default___.DS(_dafny.SeqOfString("N_")))) {
		panic("dafny/DynamoDbEncryption/test/FilterExpr.dfy(735,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}

// End of class Default__
