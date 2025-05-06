// Package DynamoDbEncryptionBranchKeyIdSupplierTest
// Dafny module DynamoDbEncryptionBranchKeyIdSupplierTest compiled into Go

package DynamoDbEncryptionBranchKeyIdSupplierTest

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
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
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
	m_TestNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestNormalizeNumber"
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
var _ m_TestNormalizeNumber.Dummy__

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
	return "DynamoDbEncryptionBranchKeyIdSupplierTest.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) TestHappyCase() {
	var _0_ddbKeyToBranchKeyId m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbKeyBranchKeyIdSupplier
	_ = _0_ddbKeyToBranchKeyId
	var _nw0 *TestBranchKeyIdSupplier = New_TestBranchKeyIdSupplier_()
	_ = _nw0
	_nw0.Ctor__()
	_0_ddbKeyToBranchKeyId = _nw0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_1_valueOrError0 = _out0
	if !(!((_1_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(70,27): " + (_1_valueOrError0).String())
	}
	var _2_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _2_ddbEncResources
	_2_ddbEncResources = (_1_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (_2_ddbEncResources).CreateDynamoDbEncryptionBranchKeyIdSupplier(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_.Create_CreateDynamoDbEncryptionBranchKeyIdSupplierInput_(_0_ddbKeyToBranchKeyId))
	_3_valueOrError1 = _out1
	if !(!((_3_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(71,34): " + (_3_valueOrError1).String())
	}
	var _4_branchKeyIdSupplierOut m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput
	_ = _4_branchKeyIdSupplierOut
	_4_branchKeyIdSupplierOut = (_3_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)
	var _5_branchKeyIdSupplier m_AwsCryptographyMaterialProvidersTypes.IBranchKeyIdSupplier
	_ = _5_branchKeyIdSupplier
	_5_branchKeyIdSupplier = (_4_branchKeyIdSupplierOut).Dtor_branchKeyIdSupplier()
	var _6_ttl int64
	_ = _6_ttl
	_6_ttl = ((int64(1)) * (int64(60000))) * (int64(10))
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_7_valueOrError2 = _out2
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(79,15): " + (_7_valueOrError2).String())
	}
	var _8_mpl *m_MaterialProviders.MaterialProvidersClient
	_ = _8_mpl
	_8_mpl = (_7_valueOrError2).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _9_valueOrError3
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_Com_Amazonaws_Kms.Companion_Default___.KMSClient()
	_9_valueOrError3 = _out3
	if !(!((_9_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(80,21): " + (_9_valueOrError3).String())
	}
	var _10_kmsClient m_ComAmazonawsKmsTypes.IKMSClient
	_ = _10_kmsClient
	_10_kmsClient = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_9_valueOrError3).Extract())
	var _11_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _11_valueOrError4
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_Com_Amazonaws_Dynamodb.Companion_Default___.DynamoDBClient()
	_11_valueOrError4 = _out4
	if !(!((_11_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(81,26): " + (_11_valueOrError4).String())
	}
	var _12_dynamodbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
	_ = _12_dynamodbClient
	_12_dynamodbClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_11_valueOrError4).Extract())
	var _13_kmsConfig m_AwsCryptographyKeyStoreTypes.KMSConfiguration
	_ = _13_kmsConfig
	_13_kmsConfig = m_AwsCryptographyKeyStoreTypes.Companion_KMSConfiguration_.Create_kmsKeyArn_(Companion_Default___.KeyArn())
	var _14_keyStoreConfig m_AwsCryptographyKeyStoreTypes.KeyStoreConfig
	_ = _14_keyStoreConfig
	_14_keyStoreConfig = m_AwsCryptographyKeyStoreTypes.Companion_KeyStoreConfig_.Create_KeyStoreConfig_(Companion_Default___.BranchKeyStoreName(), _13_kmsConfig, Companion_Default___.LogicalKeyStoreName(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_12_dynamodbClient), m_Wrappers.Companion_Option_.Create_Some_(_10_kmsClient))
	var _15_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _15_valueOrError5
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_KeyStore.Companion_Default___.KeyStore(_14_keyStoreConfig)
	_15_valueOrError5 = _out5
	if !(!((_15_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(92,20): " + (_15_valueOrError5).String())
	}
	var _16_keyStore *m_KeyStore.KeyStoreClient
	_ = _16_keyStore
	_16_keyStore = (_15_valueOrError5).Extract().(*m_KeyStore.KeyStoreClient)
	var _17_valueOrError6 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _17_valueOrError6
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = (_8_mpl).CreateAwsKmsHierarchicalKeyring(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateAwsKmsHierarchicalKeyringInput_.Create_CreateAwsKmsHierarchicalKeyringInput_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_5_branchKeyIdSupplier), _16_keyStore, _6_ttl, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
	_17_valueOrError6 = _out6
	if !(!((_17_valueOrError6).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(93,28): " + (_17_valueOrError6).String())
	}
	var _18_hierarchyKeyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _18_hierarchyKeyring
	_18_hierarchyKeyring = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.CastTo_((_17_valueOrError6).Extract())
	var _19_valueOrError7 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _19_valueOrError7
	_19_valueOrError7 = (_8_mpl).InitializeEncryptionMaterials(m_AwsCryptographyMaterialProvidersTypes.Companion_InitializeEncryptionMaterialsInput_.Create_InitializeEncryptionMaterialsInput_(Companion_Default___.TEST__DBE__ALG__SUITE__ID(), _dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.EC__PARTITION__NAME(), Companion_Default___.BRANCH__KEY__NAME()), _dafny.SeqOf(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
	if !(!((_19_valueOrError7).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(105,21): " + (_19_valueOrError7).String())
	}
	var _20_materials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
	_ = _20_materials
	_20_materials = (_19_valueOrError7).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
	var _21_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _21_valueOrError8
	_21_valueOrError8 = m_UTF8.Encode(m_Base64.Companion_Default___.Encode(Companion_Default___.CASE__A__BYTES()))
	if !(!((_21_valueOrError8).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(115,17): " + (_21_valueOrError8).String())
	}
	var _22_caseA _dafny.Sequence
	_ = _22_caseA
	_22_caseA = (_21_valueOrError8).Extract().(_dafny.Sequence)
	var _23_contextCaseA _dafny.Map
	_ = _23_contextCaseA
	_23_contextCaseA = ((_20_materials).Dtor_encryptionContext()).Update(Companion_Default___.KEY__ATTR__NAME(), _22_caseA)
	var _24_materialsA m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
	_ = _24_materialsA
	var _25_dt__update__tmp_h0 m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials = _20_materials
	_ = _25_dt__update__tmp_h0
	var _26_dt__update_hencryptionContext_h0 _dafny.Map = _23_contextCaseA
	_ = _26_dt__update_hencryptionContext_h0
	_24_materialsA = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptionMaterials_.Create_EncryptionMaterials_((_25_dt__update__tmp_h0).Dtor_algorithmSuite(), _26_dt__update_hencryptionContext_h0, (_25_dt__update__tmp_h0).Dtor_encryptedDataKeys(), (_25_dt__update__tmp_h0).Dtor_requiredEncryptionContextKeys(), (_25_dt__update__tmp_h0).Dtor_plaintextDataKey(), (_25_dt__update__tmp_h0).Dtor_signingKey(), (_25_dt__update__tmp_h0).Dtor_symmetricSigningKeys())
	Companion_Default___.TestRoundtrip(_18_hierarchyKeyring, _24_materialsA, Companion_Default___.TEST__DBE__ALG__SUITE__ID(), Companion_Default___.BRANCH__KEY__ID__A())
	var _27_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _27_valueOrError9
	_27_valueOrError9 = m_UTF8.Encode(m_Base64.Companion_Default___.Encode(Companion_Default___.CASE__B__BYTES()))
	if !(!((_27_valueOrError9).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(121,17): " + (_27_valueOrError9).String())
	}
	var _28_caseB _dafny.Sequence
	_ = _28_caseB
	_28_caseB = (_27_valueOrError9).Extract().(_dafny.Sequence)
	var _29_contextCaseB _dafny.Map
	_ = _29_contextCaseB
	_29_contextCaseB = ((_20_materials).Dtor_encryptionContext()).Update(Companion_Default___.KEY__ATTR__NAME(), _28_caseB)
	var _30_materialsB m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
	_ = _30_materialsB
	var _31_dt__update__tmp_h1 m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials = _20_materials
	_ = _31_dt__update__tmp_h1
	var _32_dt__update_hencryptionContext_h1 _dafny.Map = _29_contextCaseB
	_ = _32_dt__update_hencryptionContext_h1
	_30_materialsB = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptionMaterials_.Create_EncryptionMaterials_((_31_dt__update__tmp_h1).Dtor_algorithmSuite(), _32_dt__update_hencryptionContext_h1, (_31_dt__update__tmp_h1).Dtor_encryptedDataKeys(), (_31_dt__update__tmp_h1).Dtor_requiredEncryptionContextKeys(), (_31_dt__update__tmp_h1).Dtor_plaintextDataKey(), (_31_dt__update__tmp_h1).Dtor_signingKey(), (_31_dt__update__tmp_h1).Dtor_symmetricSigningKeys())
	Companion_Default___.TestRoundtrip(_18_hierarchyKeyring, _30_materialsB, Companion_Default___.TEST__DBE__ALG__SUITE__ID(), Companion_Default___.BRANCH__KEY__ID__B())
}
func (_static *CompanionStruct_Default___) TestRoundtrip(hierarchyKeyring m_AwsCryptographyMaterialProvidersTypes.IKeyring, encryptionMaterialsIn m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials, algorithmSuiteId m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId, expectedBranchKeyId _dafny.Sequence) {
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (hierarchyKeyring).OnEncrypt(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptInput_.Create_OnEncryptInput_(encryptionMaterialsIn))
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(137,34): " + (_0_valueOrError0).String())
	}
	var _1_encryptionMaterialsOut m_AwsCryptographyMaterialProvidersTypes.OnEncryptOutput
	_ = _1_encryptionMaterialsOut
	_1_encryptionMaterialsOut = (_0_valueOrError0).Extract().(m_AwsCryptographyMaterialProvidersTypes.OnEncryptOutput)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_2_valueOrError1 = _out1
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(141,15): " + (_2_valueOrError1).String())
	}
	var _3_mpl *m_MaterialProviders.MaterialProvidersClient
	_ = _3_mpl
	_3_mpl = (_2_valueOrError1).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
	_ = _4_valueOrError2
	_4_valueOrError2 = (_3_mpl).EncryptionMaterialsHasPlaintextDataKey((_1_encryptionMaterialsOut).Dtor_materials())
	if !(!((_4_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(142,13): " + (_4_valueOrError2).String())
	}
	var _5___v0 _dafny.Tuple
	_ = _5___v0
	_5___v0 = (_4_valueOrError2).Extract().(_dafny.Tuple)
	if !((_dafny.IntOfUint32((((_1_encryptionMaterialsOut).Dtor_materials()).Dtor_encryptedDataKeys()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(144,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
	_ = _6_edk
	_6_edk = (((_1_encryptionMaterialsOut).Dtor_materials()).Dtor_encryptedDataKeys()).Select(0).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
	var _7_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _7_valueOrError3
	_7_valueOrError3 = m_UTF8.Encode(expectedBranchKeyId)
	if !(!((_7_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(149,35): " + (_7_valueOrError3).String())
	}
	var _8_expectedBranchKeyIdUTF8 _dafny.Sequence
	_ = _8_expectedBranchKeyIdUTF8
	_8_expectedBranchKeyIdUTF8 = (_7_valueOrError3).Extract().(_dafny.Sequence)
	if !(_dafny.Companion_Sequence_.Equal((_6_edk).Dtor_keyProviderInfo(), _8_expectedBranchKeyIdUTF8)) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(150,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _9_valueOrError4
	_9_valueOrError4 = (_3_mpl).InitializeDecryptionMaterials(m_AwsCryptographyMaterialProvidersTypes.Companion_InitializeDecryptionMaterialsInput_.Create_InitializeDecryptionMaterialsInput_(algorithmSuiteId, (encryptionMaterialsIn).Dtor_encryptionContext(), _dafny.SeqOf()))
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(152,33): " + (_9_valueOrError4).String())
	}
	var _10_decryptionMaterialsIn m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_ = _10_decryptionMaterialsIn
	_10_decryptionMaterialsIn = (_9_valueOrError4).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
	var _11_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _11_valueOrError5
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (hierarchyKeyring).OnDecrypt(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptInput_.Create_OnDecryptInput_(_10_decryptionMaterialsIn, _dafny.SeqOf(_6_edk)))
	_11_valueOrError5 = _out2
	if !(!((_11_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(159,34): " + (_11_valueOrError5).String())
	}
	var _12_decryptionMaterialsOut m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput
	_ = _12_decryptionMaterialsOut
	_12_decryptionMaterialsOut = (_11_valueOrError5).Extract().(m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput)
	if !((((_1_encryptionMaterialsOut).Dtor_materials()).Dtor_plaintextDataKey()).Equals(((_12_decryptionMaterialsOut).Dtor_materials()).Dtor_plaintextDataKey())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbEncryptionBranchKeyIdSupplierTest.dfy(166,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) BranchKeyStoreName() _dafny.Sequence {
	return _dafny.SeqOfString("KeyStoreDdbTable")
}
func (_static *CompanionStruct_Default___) LogicalKeyStoreName() _dafny.Sequence {
	return Companion_Default___.BranchKeyStoreName()
}
func (_static *CompanionStruct_Default___) STRING__TYPE__ID() _dafny.Sequence {
	return _dafny.SeqOf(uint8(0), uint8(1))
}
func (_static *CompanionStruct_Default___) CASE__A__BYTES() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.STRING__TYPE__ID(), _dafny.SeqOf(uint8(67), uint8(65), uint8(83), uint8(69), uint8(95), uint8(65)))
}
func (_static *CompanionStruct_Default___) CASE__B__BYTES() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.STRING__TYPE__ID(), _dafny.SeqOf(uint8(67), uint8(65), uint8(83), uint8(69), uint8(95), uint8(66)))
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__ID() _dafny.Sequence {
	return _dafny.SeqOfString("3f43a9af-08c5-4317-b694-3d3e883dcaef")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__ID__A() _dafny.Sequence {
	return Companion_Default___.BRANCH__KEY__ID()
}
func (_static *CompanionStruct_Default___) ALTERNATE__BRANCH__KEY__ID() _dafny.Sequence {
	return _dafny.SeqOfString("4bb57643-07c1-419e-92ad-0df0df149d7c")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__ID__B() _dafny.Sequence {
	return Companion_Default___.ALTERNATE__BRANCH__KEY__ID()
}
func (_static *CompanionStruct_Default___) RESERVED__PREFIX() _dafny.Sequence {
	return _dafny.SeqOfString("aws-crypto-attr.")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY() _dafny.Sequence {
	return _dafny.SeqOfString("branchKey")
}
func (_static *CompanionStruct_Default___) KEY__ATTR__NAME() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(97), uint8(116), uint8(116), uint8(114), uint8(46), uint8(98), uint8(114), uint8(97), uint8(110), uint8(99), uint8(104), uint8(75), uint8(101), uint8(121))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__NAME() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(98), uint8(114), uint8(97), uint8(110), uint8(99), uint8(104), uint8(75), uint8(101), uint8(121))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) KeyArn() _dafny.Sequence {
	return _dafny.SeqOfString("arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126")
}
func (_static *CompanionStruct_Default___) TEST__DBE__ALG__SUITE__ID() m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_AlgorithmSuiteId_.Create_DBE_(m_AwsCryptographyMaterialProvidersTypes.Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384_())
}
func (_static *CompanionStruct_Default___) EC__PARTITION__NAME() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(112), uint8(97), uint8(114), uint8(116), uint8(105), uint8(116), uint8(105), uint8(111), uint8(110), uint8(45), uint8(110), uint8(97), uint8(109), uint8(101))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) CASE__A() _dafny.Sequence {
	return _dafny.SeqOfString("CASE_A")
}
func (_static *CompanionStruct_Default___) CASE__B() _dafny.Sequence {
	return _dafny.SeqOfString("CASE_B")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__ID__UTF8() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(51), uint8(102), uint8(52), uint8(51), uint8(97), uint8(57), uint8(97), uint8(102), uint8(45), uint8(48), uint8(56), uint8(99), uint8(53), uint8(45), uint8(52), uint8(51), uint8(49), uint8(55), uint8(45), uint8(98), uint8(54), uint8(57), uint8(52), uint8(45), uint8(51), uint8(100), uint8(51), uint8(101), uint8(56), uint8(56), uint8(51), uint8(100), uint8(99), uint8(97), uint8(101), uint8(102))
	_ = _0_s
	return _0_s
}

// End of class Default__

// Definition of class TestBranchKeyIdSupplier
type TestBranchKeyIdSupplier struct {
	dummy byte
}

func New_TestBranchKeyIdSupplier_() *TestBranchKeyIdSupplier {
	_this := TestBranchKeyIdSupplier{}

	return &_this
}

type CompanionStruct_TestBranchKeyIdSupplier_ struct {
}

var Companion_TestBranchKeyIdSupplier_ = CompanionStruct_TestBranchKeyIdSupplier_{}

func (_this *TestBranchKeyIdSupplier) Equals(other *TestBranchKeyIdSupplier) bool {
	return _this == other
}

func (_this *TestBranchKeyIdSupplier) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*TestBranchKeyIdSupplier)
	return ok && _this.Equals(other)
}

func (*TestBranchKeyIdSupplier) String() string {
	return "DynamoDbEncryptionBranchKeyIdSupplierTest.TestBranchKeyIdSupplier"
}

func Type_TestBranchKeyIdSupplier_() _dafny.TypeDescriptor {
	return type_TestBranchKeyIdSupplier_{}
}

type type_TestBranchKeyIdSupplier_ struct {
}

func (_this type_TestBranchKeyIdSupplier_) Default() interface{} {
	return (*TestBranchKeyIdSupplier)(nil)
}

func (_this type_TestBranchKeyIdSupplier_) String() string {
	return "DynamoDbEncryptionBranchKeyIdSupplierTest.TestBranchKeyIdSupplier"
}
func (_this *TestBranchKeyIdSupplier) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_IDynamoDbKeyBranchKeyIdSupplier_.TraitID_}
}

var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbKeyBranchKeyIdSupplier = &TestBranchKeyIdSupplier{}
var _ _dafny.TraitOffspring = &TestBranchKeyIdSupplier{}

func (_this *TestBranchKeyIdSupplier) GetBranchKeyIdFromDdbKey(input m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetBranchKeyIdFromDdbKeyInput) m_Wrappers.Result {
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_IDynamoDbKeyBranchKeyIdSupplier_.GetBranchKeyIdFromDdbKey(_this, input)
	return _out0
}
func (_this *TestBranchKeyIdSupplier) Ctor__() {
	{
	}
}
func (_this *TestBranchKeyIdSupplier) GetBranchKeyIdFromDdbKey_k(input m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetBranchKeyIdFromDdbKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetBranchKeyIdFromDdbKeyOutput_.Default())
		_ = output
		var _0_item _dafny.Map
		_ = _0_item
		_0_item = (input).Dtor_ddbKey()
		if ((((_0_item).Keys()).Contains(Companion_Default___.BRANCH__KEY())) && (((_0_item).Get(Companion_Default___.BRANCH__KEY()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_S())) && (_dafny.Companion_Sequence_.Equal(((_0_item).Get(Companion_Default___.BRANCH__KEY()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S(), Companion_Default___.CASE__A())) {
			output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetBranchKeyIdFromDdbKeyOutput_.Create_GetBranchKeyIdFromDdbKeyOutput_(Companion_Default___.BRANCH__KEY__ID__A()))
			return output
		} else if ((((_0_item).Keys()).Contains(Companion_Default___.BRANCH__KEY())) && (((_0_item).Get(Companion_Default___.BRANCH__KEY()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_S())) && (_dafny.Companion_Sequence_.Equal(((_0_item).Get(Companion_Default___.BRANCH__KEY()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S(), Companion_Default___.CASE__B())) {
			output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetBranchKeyIdFromDdbKeyOutput_.Create_GetBranchKeyIdFromDdbKeyOutput_(Companion_Default___.BRANCH__KEY__ID__B()))
			return output
		} else {
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(_dafny.SeqOfString("Can't determine branchKeyId from item")))
			return output
		}
		return output
	}
}

// End of class TestBranchKeyIdSupplier
