// Package TestDynamoDBConfigToInfo
// Dafny module TestDynamoDBConfigToInfo compiled into Go

package TestDynamoDBConfigToInfo

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
	m_DynamoToStructTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/DynamoToStructTest"
	m_ExecuteStatementTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ExecuteStatementTransformTest"
	m_ExecuteTransactionTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ExecuteTransactionTransformTest"
	m_GetItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/GetItemTransformTest"
	m_HappyCaseTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/HappyCaseTests"
	m_PathsTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PathsTests"
	m_PutItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PutItemTransformTest"
	m_QueryTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/QueryTransformTest"
	m_ScanTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ScanTransformTest"
	m_StructuredDataTestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/StructuredDataTestFixtures"
	m_TestBaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestBaseBeacon"
	m_TestDdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestDdbVirtualFields"
	m_TestDynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestDynamoDBFilterExpr"
	m_TestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestFixtures"
	m_TestHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestHeader"
	m_TestStructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestStructuredEncryptionCrypt"
	m_TestUpdateExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestUpdateExpr"
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
var _ m_TestDynamoDBFilterExpr.Dummy__
var _ m_TestBaseBeacon.Dummy__
var _ m_DynamoToStructTest.Dummy__
var _ m_TestUpdateExpr.Dummy__
var _ m_TestDdbVirtualFields.Dummy__

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
	return "TestDynamoDBConfigToInfo.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) TestTwoBeaconsOneLoc() {
	var _0_fred m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _0_fred
	_0_fred = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("fred"), int32(16), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("std6[0]")), m_Wrappers.Companion_Option_.Create_None_())
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
	var _3_newBeacons m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_newBeacons
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _1_version
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Std2(), m_BeaconTestFixtures.Companion_Default___.Std4(), m_BeaconTestFixtures.Companion_Default___.Std6(), m_BeaconTestFixtures.Companion_Default___.NameTitleBeacon(), m_BeaconTestFixtures.Companion_Default___.NameB(), m_BeaconTestFixtures.Companion_Default___.TitleB(), _0_fred)
	_ = _5_dt__update_hstandardBeacons_h0
	_3_newBeacons = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_4_dt__update__tmp_h0).Dtor_version(), (_4_dt__update__tmp_h0).Dtor_keyStore(), (_4_dt__update__tmp_h0).Dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).Dtor_compoundBeacons(), (_4_dt__update__tmp_h0).Dtor_virtualFields(), (_4_dt__update__tmp_h0).Dtor_encryptedParts(), (_4_dt__update__tmp_h0).Dtor_signedParts())
	var _6_beaconVersion m_Wrappers.Result
	_ = _6_beaconVersion
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _3_newBeacons, _2_src)
	_6_beaconVersion = _out2
	if !((_6_beaconVersion).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(24,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_beaconVersion).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon fred is defined on location std6[0], but beacon std6 is already defined on that location.")))) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(25,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestTwoVirtOneLoc() {
	var _0_TitleNameField m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField
	_ = _0_TitleNameField
	_0_TitleNameField = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualField_.Create_VirtualField_(_dafny.SeqOfString("TitleNameField"), _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.VPart2(), m_BeaconTestFixtures.Companion_Default___.VPart1()))
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
	var _3_newBeacons m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_newBeacons
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _1_version
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hvirtualFields_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.NameTitleField(), _0_TitleNameField))
	_ = _5_dt__update_hvirtualFields_h0
	_3_newBeacons = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_4_dt__update__tmp_h0).Dtor_version(), (_4_dt__update__tmp_h0).Dtor_keyStore(), (_4_dt__update__tmp_h0).Dtor_keySource(), (_4_dt__update__tmp_h0).Dtor_standardBeacons(), (_4_dt__update__tmp_h0).Dtor_compoundBeacons(), _5_dt__update_hvirtualFields_h0, (_4_dt__update__tmp_h0).Dtor_encryptedParts(), (_4_dt__update__tmp_h0).Dtor_signedParts())
	var _6_beaconVersion m_Wrappers.Result
	_ = _6_beaconVersion
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _3_newBeacons, _2_src)
	_6_beaconVersion = _out2
	if !((_6_beaconVersion).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(33,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_beaconVersion).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Virtual field TitleNameField is defined on the same locations as NameTitleField.")))) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(34,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestVirtAndBeaconSameLoc() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_src m_SearchableEncryptionInfo.KeySource
	_ = _1_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_1_src = _out1
	var _2_newBeacons m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_newBeacons
	var _3_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _3_dt__update__tmp_h0
	var _4_dt__update_hvirtualFields_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.NameVirtField(), m_BeaconTestFixtures.Companion_Default___.NameTitleField()))
	_ = _4_dt__update_hvirtualFields_h0
	_2_newBeacons = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_3_dt__update__tmp_h0).Dtor_version(), (_3_dt__update__tmp_h0).Dtor_keyStore(), (_3_dt__update__tmp_h0).Dtor_keySource(), (_3_dt__update__tmp_h0).Dtor_standardBeacons(), (_3_dt__update__tmp_h0).Dtor_compoundBeacons(), _4_dt__update_hvirtualFields_h0, (_3_dt__update__tmp_h0).Dtor_encryptedParts(), (_3_dt__update__tmp_h0).Dtor_signedParts())
	var _5_beaconVersion m_Wrappers.Result
	_ = _5_beaconVersion
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_newBeacons, _1_src)
	_5_beaconVersion = _out2
	if !((_5_beaconVersion).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(41,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_beaconVersion).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon Name is defined on location Name, but virtual field NameVirtField is already defined on that single location.")))) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(42,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestNSwithEB() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_src m_SearchableEncryptionInfo.KeySource
	_ = _1_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_1_src = _out1
	var _2_DupNameNS m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon
	_ = _2_DupNameNS
	_2_DupNameNS = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("Name"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Year(), m_BeaconTestFixtures.Companion_Default___.Month())), m_Wrappers.Companion_Option_.Create_None_())
	var _3_DupNameS m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon
	_ = _3_DupNameS
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon = _2_DupNameNS
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hencrypted_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Title()))
	_ = _5_dt__update_hencrypted_h0
	_3_DupNameS = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_((_4_dt__update__tmp_h0).Dtor_name(), (_4_dt__update__tmp_h0).Dtor_split(), _5_dt__update_hencrypted_h0, (_4_dt__update__tmp_h0).Dtor_signed(), (_4_dt__update__tmp_h0).Dtor_constructors())
	var _6_newBeacons m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _6_newBeacons
	var _7_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _7_dt__update__tmp_h1
	var _8_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Std2(), m_BeaconTestFixtures.Companion_Default___.Std4(), m_BeaconTestFixtures.Companion_Default___.Std6(), m_BeaconTestFixtures.Companion_Default___.NameTitleBeacon(), m_BeaconTestFixtures.Companion_Default___.TitleB())
	_ = _8_dt__update_hstandardBeacons_h0
	var _9_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_3_DupNameS))
	_ = _9_dt__update_hcompoundBeacons_h0
	_6_newBeacons = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_7_dt__update__tmp_h1).Dtor_version(), (_7_dt__update__tmp_h1).Dtor_keyStore(), (_7_dt__update__tmp_h1).Dtor_keySource(), _8_dt__update_hstandardBeacons_h0, _9_dt__update_hcompoundBeacons_h0, (_7_dt__update__tmp_h1).Dtor_virtualFields(), (_7_dt__update__tmp_h1).Dtor_encryptedParts(), (_7_dt__update__tmp_h1).Dtor_signedParts())
	var _10_beaconVersion m_Wrappers.Result
	_ = _10_beaconVersion
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _6_newBeacons, _1_src)
	_10_beaconVersion = _out2
	if !((_10_beaconVersion).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(58,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _11_dt__update__tmp_h2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _6_newBeacons
	_ = _11_dt__update__tmp_h2
	var _12_dt__update_hcompoundBeacons_h1 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_2_DupNameNS))
	_ = _12_dt__update_hcompoundBeacons_h1
	_6_newBeacons = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_11_dt__update__tmp_h2).Dtor_version(), (_11_dt__update__tmp_h2).Dtor_keyStore(), (_11_dt__update__tmp_h2).Dtor_keySource(), (_11_dt__update__tmp_h2).Dtor_standardBeacons(), _12_dt__update_hcompoundBeacons_h1, (_11_dt__update__tmp_h2).Dtor_virtualFields(), (_11_dt__update__tmp_h2).Dtor_encryptedParts(), (_11_dt__update__tmp_h2).Dtor_signedParts())
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _6_newBeacons, _1_src)
	_10_beaconVersion = _out3
	if !((_10_beaconVersion).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(62,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_10_beaconVersion).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Name not allowed as a CompoundBeacon because a fully signed beacon cannot have the same name as an existing attribute.")))) {
		panic("dafny/DynamoDbEncryption/test/ConfigToInfo.dfy(63,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}

// End of class Default__
