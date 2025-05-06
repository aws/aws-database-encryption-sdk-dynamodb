// Package TestNormalizeNumber
// Dafny module TestNormalizeNumber compiled into Go

package TestNormalizeNumber

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
	m_TestDDBSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestDDBSupport"
	m_TestDdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestDdbVirtualFields"
	m_TestDynamoDBConfigToInfo "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestDynamoDBConfigToInfo"
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
var _ m_TestDynamoDBConfigToInfo.Dummy__
var _ m_TestDDBSupport.Dummy__

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
	return "TestNormalizeNumber.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Check__normal(input _dafny.Sequence, expected _dafny.Sequence) {
	var _0_actualR m_Wrappers.Result
	_ = _0_actualR
	_0_actualR = m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(input)
	if (_0_actualR).Is_Failure() {
		_dafny.Print((_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("\nUnexpected failure normalizing '"), input), _dafny.SeqOfString("'\n"))).SetString())
		_dafny.Print(((_0_actualR).Dtor_error().(_dafny.Sequence)).SetString())
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_0_actualR).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/NormalizeNumber.dfy(16,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _1_actual _dafny.Sequence
	_ = _1_actual
	_1_actual = (_0_actualR).Dtor_value().(_dafny.Sequence)
	if !_dafny.Companion_Sequence_.Equal(_1_actual, expected) {
		_dafny.Print((_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("\n\nNormalizeNumber of '"), input), _dafny.SeqOfString("' should have been '")), expected), _dafny.SeqOfString("' but was '")), _1_actual), _dafny.SeqOfString("'\n\n"))).SetString())
	}
	if !(_dafny.Companion_Sequence_.Equal(_1_actual, expected)) {
		panic("dafny/DynamoDbEncryption/test/NormalizeNumber.dfy(21,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) Check__failure(input _dafny.Sequence) {
	var _0_actual m_Wrappers.Result
	_ = _0_actual
	_0_actual = m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(input)
	if (_0_actual).Is_Success() {
		_dafny.Print((_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Expected failure from '"), input), _dafny.SeqOfString("' but it succeeded with '")), (_0_actual).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString("'."))).SetString())
	}
	if !((_0_actual).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/NormalizeNumber.dfy(30,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestExtremes() {
	Companion_Default___.Check__normal(_dafny.SeqOfString("123456789.01234567890123456789012345678"), _dafny.SeqOfString("123456789.01234567890123456789012345678"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("123456789.012345678901234567890123456789"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("1234567890123456789012345678901234567800000000000000000000000000000"), _dafny.SeqOfString("1234567890123456789012345678901234567800000000000000000000000000000"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1234567890123456789012345678901234567890000000000000000000000000000"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".000000000000000000000000012345678901234567890123456789012345678"), _dafny.SeqOfString("0.000000000000000000000000012345678901234567890123456789012345678"))
	Companion_Default___.Check__failure(_dafny.SeqOfString(".0000000000000000000000000123456789012345678901234567890123456789"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0000000000000000000000000012345.67e121"), _dafny.SeqOfString("123456700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("12345.67e121"), _dafny.SeqOfString("123456700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("12345.67e122"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("00000000000000000000000000012345.67e122"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.00000001e133"), _dafny.SeqOfString("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("0.00000001e134"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.00000001e-122"), _dafny.SeqOfString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("0.00000001e-123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("1234567e-136"), _dafny.SeqOfString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001234567"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1234567e-137"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("9.9999999999999999999999999999999999999E+125"), _dafny.SeqOfString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".99999999999999999999999999999999999999E+126"), _dafny.SeqOfString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), _dafny.SeqOfString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1E+126"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("10E+125"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), _dafny.SeqOfString("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("9.99999999999999999999999999999999999991E+125"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("1E-130"), _dafny.SeqOfString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("10E-131"), _dafny.SeqOfString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"), _dafny.SeqOfString("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("9.9999999999999999999999999999999999999E-131"))
	Companion_Default___.Check__failure(_dafny.SeqOfString(".99999999999999999999999999999999999999E-130"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000099999999999999999999999999999999999999"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-9.9999999999999999999999999999999999999E+125"), _dafny.SeqOfString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-.99999999999999999999999999999999999999E+126"), _dafny.SeqOfString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), _dafny.SeqOfString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-1E+126"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-10E+125"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-9.99999999999999999999999999999999999991E+125"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-1E-130"), _dafny.SeqOfString("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-10E-131"), _dafny.SeqOfString("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"), _dafny.SeqOfString("-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-9.9999999999999999999999999999999999999E-131"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-.99999999999999999999999999999999999999E-130"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000099999999999999999999999999999999999999"))
}
func (_static *CompanionStruct_Default___) TestFailures() {
	Companion_Default___.Check__failure(_dafny.SeqOfString(""))
	Companion_Default___.Check__failure(_dafny.SeqOfString("."))
	Companion_Default___.Check__failure(_dafny.SeqOfString("+"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("e"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("E"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1.2.3"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1.2e3e4"))
	Companion_Default___.Check__failure(_dafny.SeqOfString(".e4"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1.2e4."))
	Companion_Default___.Check__failure(_dafny.SeqOfString("e99"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("e-99"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1.2e--99"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1.2e+-99"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1.2e-+99"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("--1.2"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("++1.2"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("+-1.2"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("-+1.2"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1e"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1e-"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1e+"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1e1.1"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("e0"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1a1"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1-1"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1+1"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1.-2"))
	Companion_Default___.Check__failure(_dafny.SeqOfString("1.+2"))
}
func (_static *CompanionStruct_Default___) TestExamples() {
	Companion_Default___.Check__normal(_dafny.SeqOfString("0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("000"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".000"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0."), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("000.000"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0e99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.e99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".0e99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.0e99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0e-99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".0e-99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.0e-99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.0e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".0e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0e-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.0e-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.e-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".0e-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0e999"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0e-999"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-000"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-.000"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0."), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-000.000"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-.0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0e99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.e99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-.0e99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.0e99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0e-99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-.0e-99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.0e-99"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.0e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-.0e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0e-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.0e-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0.e-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-.0e-0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("+0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("+0e+0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("+0e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0e+0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0e+0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-0e0"), _dafny.SeqOfString("0"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("1.2e2"), _dafny.SeqOfString("120"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("+1.2e2"), _dafny.SeqOfString("120"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("+1.2e+2"), _dafny.SeqOfString("120"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("1.2e+2"), _dafny.SeqOfString("120"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-1.2e2"), _dafny.SeqOfString("-120"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-1.2e+2"), _dafny.SeqOfString("-120"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("+123.456"), _dafny.SeqOfString("123.456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("-123.456"), _dafny.SeqOfString("-123.456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("12.34"), _dafny.SeqOfString("12.34"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("00012.34"), _dafny.SeqOfString("12.34"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("12.34000"), _dafny.SeqOfString("12.34"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("012.340"), _dafny.SeqOfString("12.34"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456"), _dafny.SeqOfString("123.456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e0"), _dafny.SeqOfString("123.456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e-0"), _dafny.SeqOfString("123.456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e1"), _dafny.SeqOfString("1234.56"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e-1"), _dafny.SeqOfString("12.3456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e2"), _dafny.SeqOfString("12345.6"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e-2"), _dafny.SeqOfString("1.23456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e3"), _dafny.SeqOfString("123456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e-3"), _dafny.SeqOfString("0.123456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e4"), _dafny.SeqOfString("1234560"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e-4"), _dafny.SeqOfString("0.0123456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e5"), _dafny.SeqOfString("12345600"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.456e-5"), _dafny.SeqOfString("0.00123456"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123"), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e0"), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e-0"), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e1"), _dafny.SeqOfString("1230"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e2"), _dafny.SeqOfString("12300"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e3"), _dafny.SeqOfString("123000"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e-1"), _dafny.SeqOfString("12.3"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e-2"), _dafny.SeqOfString("1.23"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e-3"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123e-4"), _dafny.SeqOfString("0.0123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e0"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e-0"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e1"), _dafny.SeqOfString("1.23"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e-1"), _dafny.SeqOfString("0.0123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e2"), _dafny.SeqOfString("12.3"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e-2"), _dafny.SeqOfString("0.00123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e3"), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e-3"), _dafny.SeqOfString("0.000123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123."), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.e0"), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.e-0"), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.e1"), _dafny.SeqOfString("1230"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.e-1"), _dafny.SeqOfString("12.3"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.e2"), _dafny.SeqOfString("12300"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.e-2"), _dafny.SeqOfString("1.23"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.e3"), _dafny.SeqOfString("123000"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("123.e-3"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123e0"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123e-0"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123e1"), _dafny.SeqOfString("1.23"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123e2"), _dafny.SeqOfString("12.3"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123e3"), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123e4"), _dafny.SeqOfString("1230"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123e-1"), _dafny.SeqOfString("0.0123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString("0.123e-2"), _dafny.SeqOfString("0.00123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e0"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e-0"), _dafny.SeqOfString("0.123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e1"), _dafny.SeqOfString("1.23"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e2"), _dafny.SeqOfString("12.3"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e3"), _dafny.SeqOfString("123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e4"), _dafny.SeqOfString("1230"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e-1"), _dafny.SeqOfString("0.0123"))
	Companion_Default___.Check__normal(_dafny.SeqOfString(".123e-2"), _dafny.SeqOfString("0.00123"))
}

// End of class Default__
