// Package TestBaseBeacon
// Dafny module TestBaseBeacon compiled into Go

package TestBaseBeacon

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
	m_ExecuteStatementTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ExecuteStatementTransformTest"
	m_ExecuteTransactionTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ExecuteTransactionTransformTest"
	m_GetItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/GetItemTransformTest"
	m_HappyCaseTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/HappyCaseTests"
	m_PathsTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PathsTests"
	m_PutItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PutItemTransformTest"
	m_QueryTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/QueryTransformTest"
	m_ScanTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ScanTransformTest"
	m_StructuredDataTestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/StructuredDataTestFixtures"
	m_TestDynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestDynamoDBFilterExpr"
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
var _ m_TestDynamoDBFilterExpr.Dummy__

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
	return "TestBaseBeacon.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) TestBeacon() {
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(27,22): " + (_0_valueOrError0).String())
	}
	var _1_primitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _1_primitives
	_1_primitives = (_0_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _2_bb m_BaseBeacon.BeaconBase
	_ = _2_bb
	_2_bb = m_BaseBeacon.Companion_BeaconBase_.Create_BeaconBase_(_1_primitives, _dafny.SeqOfString("foo"), _dafny.SeqOfString("aws_dbe_b_foo"))
	var _3_b m_BaseBeacon.StandardBeacon
	_ = _3_b
	_3_b = m_BaseBeacon.Companion_StandardBeacon_.Create_StandardBeacon_(_2_bb, uint8(8), m_TermLoc.Companion_Default___.TermLocMap(_dafny.SeqOfString("foo")), false, false, m_Wrappers.Companion_Option_.Create_None_())
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError1
	_4_valueOrError1 = (_2_bb).GetHmac(_dafny.SeqOf(uint8(1), uint8(2), uint8(3)), _dafny.SeqOf(uint8(1), uint8(2)))
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(31,17): " + (_4_valueOrError1).String())
	}
	var _5_bytes _dafny.Sequence
	_ = _5_bytes
	_5_bytes = (_4_valueOrError1).Extract().(_dafny.Sequence)
	if !(_dafny.Companion_Sequence_.Equal(_5_bytes, _dafny.SeqOf(uint8(39), uint8(147), uint8(147), uint8(139), uint8(38), uint8(233), uint8(82), uint8(126)))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(32,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _6_valueOrError2
	_6_valueOrError2 = (_3_b).Hash(_dafny.SeqOf(uint8(1), uint8(2), uint8(3)), _dafny.SeqOf(uint8(1), uint8(2)))
	if !(!((_6_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(33,15): " + (_6_valueOrError2).String())
	}
	var _7_str _dafny.Sequence
	_ = _7_str
	_7_str = (_6_valueOrError2).Extract().(_dafny.Sequence)
	if !(_dafny.Companion_Sequence_.Equal(_7_str, _dafny.SeqOfString("7e"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(34,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError3
	_8_valueOrError3 = (_2_bb).GetHmac(_dafny.SeqOf(), _dafny.SeqOf(uint8(1), uint8(2)))
	if !(!((_8_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(35,13): " + (_8_valueOrError3).String())
	}
	_5_bytes = (_8_valueOrError3).Extract().(_dafny.Sequence)
	if !(((_5_bytes).Select(7).(uint8)) == (uint8(128))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(36,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _9_valueOrError4
	_9_valueOrError4 = (_3_b).Hash(_dafny.SeqOf(), _dafny.SeqOf(uint8(1), uint8(2)))
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(37,11): " + (_9_valueOrError4).String())
	}
	_7_str = (_9_valueOrError4).Extract().(_dafny.Sequence)
	if !(_dafny.Companion_Sequence_.Equal(_7_str, _dafny.SeqOfString("80"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(38,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError5
	_10_valueOrError5 = (_2_bb).GetHmac(Companion_Default___.X123(), _dafny.SeqOf(uint8(1), uint8(2)))
	if !(!((_10_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(39,13): " + (_10_valueOrError5).String())
	}
	_5_bytes = (_10_valueOrError5).Extract().(_dafny.Sequence)
	if !(((_5_bytes).Select(7).(uint8)) == (uint8(97))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(40,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestBadPrefix() {
	var _0_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _0_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetKeyStore()
	_0_store = _out0
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	_1_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _0_store, m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_single_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SingleKeyStore_.Create_SingleKeyStore_(_dafny.SeqOfString("foo"), int32(42), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())), _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.NameB(), m_BeaconTestFixtures.Companion_Default___.TitleB(), m_BeaconTestFixtures.Companion_Default___.TooBadB()), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.BadPrefix())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _2_src m_SearchableEncryptionInfo.KeySource
	_ = _2_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_2_src = _out1
	var _3_res m_Wrappers.Result
	_ = _3_res
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _2_src)
	_3_res = _out2
	if !((_3_res).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(58,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	m_BeaconTestFixtures.Companion_Default___.Expect__equal((_3_res).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound beacon BadPrefix defines part Title with prefix T_ which is incompatible with part TooBad which has a prefix of T.")))
}
func (_static *CompanionStruct_Default___) TestContainsSplit() {
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
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _1_src)
	_2_valueOrError0 = _out2
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(67,14): " + (_2_valueOrError0).String())
	}
	var _3_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _3_bv
	_3_bv = (_2_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _4_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_3_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_4_valueOrError1 = _out3
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(68,21): " + (_4_valueOrError1).String())
	}
	var _5_goodAttrs _dafny.Map
	_ = _5_goodAttrs
	_5_goodAttrs = (_4_valueOrError1).Extract().(_dafny.Map)
	var _6_badItem _dafny.Map
	_ = _6_badItem
	_6_badItem = (m_BeaconTestFixtures.Companion_Default___.SimpleItem()).Update(_dafny.SeqOfString("Name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("A.B")))
	var _7_badAttrs m_Wrappers.Result
	_ = _7_badAttrs
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_3_bv).GenerateEncryptedBeacons(_6_badItem, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_7_badAttrs = _out4
	if !((_7_badAttrs).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(71,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	m_BeaconTestFixtures.Companion_Default___.Expect__equal((_7_badAttrs).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Part Name for beacon Mixed has value 'A.B' which contains the split character .'.")))
}
func (_static *CompanionStruct_Default___) TestOneBeaconValue() {
	var _0_x _dafny.Sequence
	_ = _0_x
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = Companion_Default___.GetBeaconValue(_dafny.SeqOfString("std2"), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOfString("1.23"), uint8(24))
	_0_x = _out0
	if !(_dafny.Companion_Sequence_.Equal(_0_x, m_BeaconTestFixtures.Companion_Default___.Std2__beacon())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(79,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = Companion_Default___.GetBeaconValue(_dafny.SeqOfString("Name"), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOfString("MyName"), uint8(32))
	_0_x = _out1
	if !(_dafny.Companion_Sequence_.Equal(_0_x, m_BeaconTestFixtures.Companion_Default___.Name__beacon())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(81,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out2 _dafny.Sequence
	_ = _out2
	_out2 = Companion_Default___.GetBeaconValue(_dafny.SeqOfString("Title"), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOfString("MyTitle"), uint8(32))
	_0_x = _out2
	if !(_dafny.Companion_Sequence_.Equal(_0_x, m_BeaconTestFixtures.Companion_Default___.Title__beacon())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(83,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out3 _dafny.Sequence
	_ = _out3
	_out3 = Companion_Default___.GetBeaconValue(_dafny.SeqOfString("std4"), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOfString("abc"), uint8(24))
	_0_x = _out3
	if !(_dafny.Companion_Sequence_.Equal(_0_x, m_BeaconTestFixtures.Companion_Default___.Std4__beacon())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(85,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out4 _dafny.Sequence
	_ = _out4
	_out4 = Companion_Default___.GetBeaconValue(_dafny.SeqOfString("std6"), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOfString("666"), uint8(26))
	_0_x = _out4
	if !(_dafny.Companion_Sequence_.Equal(_0_x, m_BeaconTestFixtures.Companion_Default___.Std6__beacon())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(87,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out5 _dafny.Sequence
	_ = _out5
	_out5 = Companion_Default___.GetBeaconValue(_dafny.SeqOfString("NameTitleField"), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOfString("MyName__mytitle"), uint8(28))
	_0_x = _out5
	if !(_dafny.Companion_Sequence_.Equal(_0_x, m_BeaconTestFixtures.Companion_Default___.NameTitle__beacon())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(89,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out6 _dafny.Sequence
	_ = _out6
	_out6 = Companion_Default___.GetBeaconValue(_dafny.SeqOfString("Name"), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOfString(""), uint8(32))
	_0_x = _out6
	if !(_dafny.Companion_Sequence_.Equal(_0_x, m_BeaconTestFixtures.Companion_Default___.EmptyName__beacon())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(91,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _out7 _dafny.Sequence
	_ = _out7
	_out7 = Companion_Default___.GetBeaconValue(_dafny.SeqOfString("Title"), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOfString(""), uint8(32))
	_0_x = _out7
	if !(_dafny.Companion_Sequence_.Equal(_0_x, m_BeaconTestFixtures.Companion_Default___.EmptyTitle__beacon())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(93,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestNumbersNormalize() {
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
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _1_src)
	_2_valueOrError0 = _out2
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(100,14): " + (_2_valueOrError0).String())
	}
	var _3_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _3_bv
	_3_bv = (_2_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _4_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_3_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_4_valueOrError1 = _out3
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(101,21): " + (_4_valueOrError1).String())
	}
	var _5_goodAttrs _dafny.Map
	_ = _5_goodAttrs
	_5_goodAttrs = (_4_valueOrError1).Extract().(_dafny.Map)
	if !((_5_goodAttrs).Contains(_dafny.SeqOfString("aws_dbe_b_std2"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(105,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_goodAttrs).Get(_dafny.SeqOfString("aws_dbe_b_std2")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Std2__beacon()))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(106,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_newItem _dafny.Map
	_ = _6_newItem
	_6_newItem = (m_BeaconTestFixtures.Companion_Default___.SimpleItem()).Update(_dafny.SeqOfString("std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("000001.23000000")))
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_3_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(108,20): " + (_7_valueOrError2).String())
	}
	var _8_newAttrs _dafny.Map
	_ = _8_newAttrs
	_8_newAttrs = (_7_valueOrError2).Extract().(_dafny.Map)
	if !((_8_newAttrs).Contains(_dafny.SeqOfString("aws_dbe_b_std2"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(109,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_goodAttrs).Get(_dafny.SeqOfString("aws_dbe_b_std2")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_8_newAttrs).Get(_dafny.SeqOfString("aws_dbe_b_std2")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(110,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSharedCacheBeaconsSingleKeyStoreWithSamePartitionId() {
	var _0_partitionId _dafny.Sequence
	_ = _0_partitionId
	_0_partitionId = _dafny.SeqOfString("partitionId")
	var _1_sharedCache m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _1_sharedCache
	var _out0 m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetSharedCache()
	_1_sharedCache = _out0
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_2_valueOrError0 = _out1
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(117,22): " + (_2_valueOrError0).String())
	}
	var _3_primitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _3_primitives
	_3_primitives = (_2_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _4_badVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _4_badVersion
	var _out2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out2
	_out2 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(_1_sharedCache, m_Wrappers.Companion_Option_.Create_Some_(_0_partitionId))
	_4_badVersion = _out2
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_4_badVersion).Dtor_keyStore(), (_4_badVersion).Dtor_keySource(), _3_primitives)
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(133,18): " + (_5_valueOrError1).String())
	}
	var _6_badSrc m_SearchableEncryptionInfo.KeySource
	_ = _6_badSrc
	_6_badSrc = (_5_valueOrError1).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _4_badVersion, _6_badSrc)
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(134,17): " + (_7_valueOrError2).String())
	}
	var _8_badBv m_SearchableEncryptionInfo.BeaconVersion
	_ = _8_badBv
	_8_badBv = (_7_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _9_badAttrs m_Wrappers.Result
	_ = _9_badAttrs
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_8_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_9_badAttrs = _out5
	if !((_9_badAttrs).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(136,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _10_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _10_version
	var _out6 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out6
	_out6 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsSingleWithSharedCache(_1_sharedCache, m_Wrappers.Companion_Option_.Create_Some_(_0_partitionId))
	_10_version = _out6
	var _11_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _11_valueOrError3
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_10_version).Dtor_keyStore(), (_10_version).Dtor_keySource(), _3_primitives)
	_11_valueOrError3 = _out7
	if !(!((_11_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(140,15): " + (_11_valueOrError3).String())
	}
	var _12_src m_SearchableEncryptionInfo.KeySource
	_ = _12_src
	_12_src = (_11_valueOrError3).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _13_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _13_valueOrError4
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _10_version, _12_src)
	_13_valueOrError4 = _out8
	if !(!((_13_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(141,14): " + (_13_valueOrError4).String())
	}
	var _14_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _14_bv
	_14_bv = (_13_valueOrError4).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _15_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _15_valueOrError5
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = (_14_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_15_valueOrError5 = _out9
	if !(!((_15_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(142,21): " + (_15_valueOrError5).String())
	}
	var _16_goodAttrs _dafny.Map
	_ = _16_goodAttrs
	_16_goodAttrs = (_15_valueOrError5).Extract().(_dafny.Map)
	var _17_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _17_valueOrError6
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = (_8_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_17_valueOrError6 = _out10
	if !(!((_17_valueOrError6).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(146,29): " + (_17_valueOrError6).String())
	}
	var _18_badAttrsNowCached _dafny.Map
	_ = _18_badAttrsNowCached
	_18_badAttrsNowCached = (_17_valueOrError6).Extract().(_dafny.Map)
}
func (_static *CompanionStruct_Default___) TestSharedCacheBeaconsSingleKeyStoreWithDifferentPartitionId() {
	var _0_sharedCache m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _0_sharedCache
	var _out0 m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetSharedCache()
	_0_sharedCache = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_1_valueOrError0 = _out1
	if !(!((_1_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(152,22): " + (_1_valueOrError0).String())
	}
	var _2_primitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _2_primitives
	_2_primitives = (_1_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _3_partitionIdBadVersion _dafny.Sequence
	_ = _3_partitionIdBadVersion
	_3_partitionIdBadVersion = _dafny.SeqOfString("partitionIdBadVersion")
	var _4_badVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _4_badVersion
	var _out2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out2
	_out2 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(_0_sharedCache, m_Wrappers.Companion_Option_.Create_Some_(_3_partitionIdBadVersion))
	_4_badVersion = _out2
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_4_badVersion).Dtor_keyStore(), (_4_badVersion).Dtor_keySource(), _2_primitives)
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(169,18): " + (_5_valueOrError1).String())
	}
	var _6_badSrc m_SearchableEncryptionInfo.KeySource
	_ = _6_badSrc
	_6_badSrc = (_5_valueOrError1).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _4_badVersion, _6_badSrc)
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(170,17): " + (_7_valueOrError2).String())
	}
	var _8_badBv m_SearchableEncryptionInfo.BeaconVersion
	_ = _8_badBv
	_8_badBv = (_7_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _9_badAttrs m_Wrappers.Result
	_ = _9_badAttrs
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_8_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_9_badAttrs = _out5
	if !((_9_badAttrs).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(172,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _10_partitionIdGoodVersion _dafny.Sequence
	_ = _10_partitionIdGoodVersion
	_10_partitionIdGoodVersion = _dafny.SeqOfString("partitionIdGoodVersion")
	var _11_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _11_version
	var _out6 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out6
	_out6 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsSingleWithSharedCache(_0_sharedCache, m_Wrappers.Companion_Option_.Create_Some_(_10_partitionIdGoodVersion))
	_11_version = _out6
	var _12_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _12_valueOrError3
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_11_version).Dtor_keyStore(), (_11_version).Dtor_keySource(), _2_primitives)
	_12_valueOrError3 = _out7
	if !(!((_12_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(177,15): " + (_12_valueOrError3).String())
	}
	var _13_src m_SearchableEncryptionInfo.KeySource
	_ = _13_src
	_13_src = (_12_valueOrError3).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _14_valueOrError4
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _11_version, _13_src)
	_14_valueOrError4 = _out8
	if !(!((_14_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(178,14): " + (_14_valueOrError4).String())
	}
	var _15_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _15_bv
	_15_bv = (_14_valueOrError4).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _16_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _16_valueOrError5
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = (_15_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_16_valueOrError5 = _out9
	if !(!((_16_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(179,21): " + (_16_valueOrError5).String())
	}
	var _17_goodAttrs _dafny.Map
	_ = _17_goodAttrs
	_17_goodAttrs = (_16_valueOrError5).Extract().(_dafny.Map)
	var _18_badAttrsNowCached m_Wrappers.Result
	_ = _18_badAttrsNowCached
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = (_8_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_18_badAttrsNowCached = _out10
	if !((_18_badAttrsNowCached).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(183,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSharedCacheBeaconsSingleKeyStoreWithUnspecifiedPartitionId() {
	var _0_sharedCache m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _0_sharedCache
	var _out0 m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetSharedCache()
	_0_sharedCache = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_1_valueOrError0 = _out1
	if !(!((_1_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(189,22): " + (_1_valueOrError0).String())
	}
	var _2_primitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _2_primitives
	_2_primitives = (_1_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _3_badVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_badVersion
	var _out2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out2
	_out2 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsSingleWithSharedCacheWithBadKeyStore(_0_sharedCache, m_Wrappers.Companion_Option_.Create_None_())
	_3_badVersion = _out2
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_3_badVersion).Dtor_keyStore(), (_3_badVersion).Dtor_keySource(), _2_primitives)
	_4_valueOrError1 = _out3
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(205,18): " + (_4_valueOrError1).String())
	}
	var _5_badSrc m_SearchableEncryptionInfo.KeySource
	_ = _5_badSrc
	_5_badSrc = (_4_valueOrError1).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _6_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _3_badVersion, _5_badSrc)
	_6_valueOrError2 = _out4
	if !(!((_6_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(206,17): " + (_6_valueOrError2).String())
	}
	var _7_badBv m_SearchableEncryptionInfo.BeaconVersion
	_ = _7_badBv
	_7_badBv = (_6_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _8_badAttrs m_Wrappers.Result
	_ = _8_badAttrs
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_7_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_8_badAttrs = _out5
	if !((_8_badAttrs).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(208,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _9_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _9_version
	var _out6 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out6
	_out6 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsSingleWithSharedCache(_0_sharedCache, m_Wrappers.Companion_Option_.Create_None_())
	_9_version = _out6
	var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _10_valueOrError3
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_9_version).Dtor_keyStore(), (_9_version).Dtor_keySource(), _2_primitives)
	_10_valueOrError3 = _out7
	if !(!((_10_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(212,15): " + (_10_valueOrError3).String())
	}
	var _11_src m_SearchableEncryptionInfo.KeySource
	_ = _11_src
	_11_src = (_10_valueOrError3).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _12_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _12_valueOrError4
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _9_version, _11_src)
	_12_valueOrError4 = _out8
	if !(!((_12_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(213,14): " + (_12_valueOrError4).String())
	}
	var _13_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _13_bv
	_13_bv = (_12_valueOrError4).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _14_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _14_valueOrError5
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = (_13_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_14_valueOrError5 = _out9
	if !(!((_14_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(214,21): " + (_14_valueOrError5).String())
	}
	var _15_goodAttrs _dafny.Map
	_ = _15_goodAttrs
	_15_goodAttrs = (_14_valueOrError5).Extract().(_dafny.Map)
	var _16_badAttrsNowCached m_Wrappers.Result
	_ = _16_badAttrsNowCached
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = (_7_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_16_badAttrsNowCached = _out10
	if !((_16_badAttrsNowCached).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(219,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSharedCacheBeaconsMultiKeyStoreWithSamePartitionId() {
	var _0_partitionId _dafny.Sequence
	_ = _0_partitionId
	_0_partitionId = _dafny.SeqOfString("partitionId")
	var _1_sharedCache m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _1_sharedCache
	var _out0 m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetSharedCache()
	_1_sharedCache = _out0
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_2_valueOrError0 = _out1
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(226,22): " + (_2_valueOrError0).String())
	}
	var _3_primitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _3_primitives
	_3_primitives = (_2_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _4_badVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _4_badVersion
	var _out2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out2
	_out2 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(_1_sharedCache, m_Wrappers.Companion_Option_.Create_Some_(_0_partitionId))
	_4_badVersion = _out2
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_4_badVersion).Dtor_keyStore(), (_4_badVersion).Dtor_keySource(), _3_primitives)
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(242,18): " + (_5_valueOrError1).String())
	}
	var _6_badSrc m_SearchableEncryptionInfo.KeySource
	_ = _6_badSrc
	_6_badSrc = (_5_valueOrError1).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _4_badVersion, _6_badSrc)
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(243,17): " + (_7_valueOrError2).String())
	}
	var _8_badBv m_SearchableEncryptionInfo.BeaconVersion
	_ = _8_badBv
	_8_badBv = (_7_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _9_badAttrs m_Wrappers.Result
	_ = _9_badAttrs
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_8_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_9_badAttrs = _out5
	if !((_9_badAttrs).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(245,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _10_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _10_version
	var _out6 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out6
	_out6 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsMultiWithSharedCache(_1_sharedCache, m_Wrappers.Companion_Option_.Create_Some_(_0_partitionId))
	_10_version = _out6
	var _11_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _11_valueOrError3
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_10_version).Dtor_keyStore(), (_10_version).Dtor_keySource(), _3_primitives)
	_11_valueOrError3 = _out7
	if !(!((_11_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(249,15): " + (_11_valueOrError3).String())
	}
	var _12_src m_SearchableEncryptionInfo.KeySource
	_ = _12_src
	_12_src = (_11_valueOrError3).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _13_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _13_valueOrError4
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _10_version, _12_src)
	_13_valueOrError4 = _out8
	if !(!((_13_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(250,14): " + (_13_valueOrError4).String())
	}
	var _14_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _14_bv
	_14_bv = (_13_valueOrError4).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _15_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _15_valueOrError5
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = (_14_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_15_valueOrError5 = _out9
	if !(!((_15_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(251,21): " + (_15_valueOrError5).String())
	}
	var _16_goodAttrs _dafny.Map
	_ = _16_goodAttrs
	_16_goodAttrs = (_15_valueOrError5).Extract().(_dafny.Map)
	var _17_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _17_valueOrError6
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = (_8_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_17_valueOrError6 = _out10
	if !(!((_17_valueOrError6).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(255,29): " + (_17_valueOrError6).String())
	}
	var _18_badAttrsNowCached _dafny.Map
	_ = _18_badAttrsNowCached
	_18_badAttrsNowCached = (_17_valueOrError6).Extract().(_dafny.Map)
}
func (_static *CompanionStruct_Default___) TestSharedCacheBeaconsMultiKeyStoreWithDifferentPartitionId() {
	var _0_sharedCache m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _0_sharedCache
	var _out0 m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetSharedCache()
	_0_sharedCache = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_1_valueOrError0 = _out1
	if !(!((_1_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(262,22): " + (_1_valueOrError0).String())
	}
	var _2_primitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _2_primitives
	_2_primitives = (_1_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _3_partitionIdBadVersion _dafny.Sequence
	_ = _3_partitionIdBadVersion
	_3_partitionIdBadVersion = _dafny.SeqOfString("partitionIdBadVersion")
	var _4_badVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _4_badVersion
	var _out2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out2
	_out2 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(_0_sharedCache, m_Wrappers.Companion_Option_.Create_Some_(_3_partitionIdBadVersion))
	_4_badVersion = _out2
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_4_badVersion).Dtor_keyStore(), (_4_badVersion).Dtor_keySource(), _2_primitives)
	_5_valueOrError1 = _out3
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(279,18): " + (_5_valueOrError1).String())
	}
	var _6_badSrc m_SearchableEncryptionInfo.KeySource
	_ = _6_badSrc
	_6_badSrc = (_5_valueOrError1).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _4_badVersion, _6_badSrc)
	_7_valueOrError2 = _out4
	if !(!((_7_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(280,17): " + (_7_valueOrError2).String())
	}
	var _8_badBv m_SearchableEncryptionInfo.BeaconVersion
	_ = _8_badBv
	_8_badBv = (_7_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _9_badAttrs m_Wrappers.Result
	_ = _9_badAttrs
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_8_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_9_badAttrs = _out5
	if !((_9_badAttrs).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(285,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _10_partitionIdGoodVersion _dafny.Sequence
	_ = _10_partitionIdGoodVersion
	_10_partitionIdGoodVersion = _dafny.SeqOfString("partitionIdGoodVersion")
	var _11_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _11_version
	var _out6 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out6
	_out6 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsMultiWithSharedCache(_0_sharedCache, m_Wrappers.Companion_Option_.Create_Some_(_10_partitionIdGoodVersion))
	_11_version = _out6
	var _12_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _12_valueOrError3
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_11_version).Dtor_keyStore(), (_11_version).Dtor_keySource(), _2_primitives)
	_12_valueOrError3 = _out7
	if !(!((_12_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(290,15): " + (_12_valueOrError3).String())
	}
	var _13_src m_SearchableEncryptionInfo.KeySource
	_ = _13_src
	_13_src = (_12_valueOrError3).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _14_valueOrError4
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _11_version, _13_src)
	_14_valueOrError4 = _out8
	if !(!((_14_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(291,14): " + (_14_valueOrError4).String())
	}
	var _15_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _15_bv
	_15_bv = (_14_valueOrError4).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _16_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _16_valueOrError5
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = (_15_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_16_valueOrError5 = _out9
	if !(!((_16_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(292,21): " + (_16_valueOrError5).String())
	}
	var _17_goodAttrs _dafny.Map
	_ = _17_goodAttrs
	_17_goodAttrs = (_16_valueOrError5).Extract().(_dafny.Map)
	var _18_badAttrsNowCached m_Wrappers.Result
	_ = _18_badAttrsNowCached
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = (_8_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_18_badAttrsNowCached = _out10
	if !((_18_badAttrsNowCached).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(296,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSharedCacheBeaconsMultiKeyStoreWithUnspecifiedPartitionId() {
	var _0_sharedCache m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _0_sharedCache
	var _out0 m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetSharedCache()
	_0_sharedCache = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_1_valueOrError0 = _out1
	if !(!((_1_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(302,22): " + (_1_valueOrError0).String())
	}
	var _2_primitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _2_primitives
	_2_primitives = (_1_valueOrError0).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _3_badVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_badVersion
	var _out2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out2
	_out2 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsMultiWithSharedCacheWithBadKeyStore(_0_sharedCache, m_Wrappers.Companion_Option_.Create_None_())
	_3_badVersion = _out2
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_3_badVersion).Dtor_keyStore(), (_3_badVersion).Dtor_keySource(), _2_primitives)
	_4_valueOrError1 = _out3
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(318,18): " + (_4_valueOrError1).String())
	}
	var _5_badSrc m_SearchableEncryptionInfo.KeySource
	_ = _5_badSrc
	_5_badSrc = (_4_valueOrError1).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _6_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _3_badVersion, _5_badSrc)
	_6_valueOrError2 = _out4
	if !(!((_6_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(319,17): " + (_6_valueOrError2).String())
	}
	var _7_badBv m_SearchableEncryptionInfo.BeaconVersion
	_ = _7_badBv
	_7_badBv = (_6_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _8_badAttrs m_Wrappers.Result
	_ = _8_badAttrs
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_7_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_8_badAttrs = _out5
	if !((_8_badAttrs).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(324,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _9_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _9_version
	var _out6 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out6
	_out6 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeaconsMultiWithSharedCache(_0_sharedCache, m_Wrappers.Companion_Option_.Create_None_())
	_9_version = _out6
	var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _10_valueOrError3
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_SearchConfigToInfo.Companion_Default___.MakeKeySource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), (_9_version).Dtor_keyStore(), (_9_version).Dtor_keySource(), _2_primitives)
	_10_valueOrError3 = _out7
	if !(!((_10_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(328,15): " + (_10_valueOrError3).String())
	}
	var _11_src m_SearchableEncryptionInfo.KeySource
	_ = _11_src
	_11_src = (_10_valueOrError3).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _12_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _12_valueOrError4
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _9_version, _11_src)
	_12_valueOrError4 = _out8
	if !(!((_12_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(329,14): " + (_12_valueOrError4).String())
	}
	var _13_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _13_bv
	_13_bv = (_12_valueOrError4).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _14_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _14_valueOrError5
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = (_13_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_14_valueOrError5 = _out9
	if !(!((_14_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(330,21): " + (_14_valueOrError5).String())
	}
	var _15_goodAttrs _dafny.Map
	_ = _15_goodAttrs
	_15_goodAttrs = (_14_valueOrError5).Extract().(_dafny.Map)
	var _16_badAttrsNowCached m_Wrappers.Result
	_ = _16_badAttrsNowCached
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = (_7_badBv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_KeyId_(_dafny.SeqOfString("040a32a8-3737-4f16-a3ba-bd4449556d73")))
	_16_badAttrsNowCached = _out10
	if !((_16_badAttrsNowCached).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(335,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestBeaconValues() {
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
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _1_src)
	_2_valueOrError0 = _out2
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(342,14): " + (_2_valueOrError0).String())
	}
	var _3_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _3_bv
	_3_bv = (_2_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _4_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_3_bv).GenerateSignedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem())
	_4_valueOrError1 = _out3
	if !(!((_4_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(343,17): " + (_4_valueOrError1).String())
	}
	var _5_attrs _dafny.Map
	_ = _5_attrs
	_5_attrs = (_4_valueOrError1).Extract().(_dafny.Map)
	if !((_5_attrs).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("JustSigned"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("Y_1984.M_May"))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(344,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _6_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_3_bv).GenerateEncryptedBeacons(m_BeaconTestFixtures.Companion_Default___.SimpleItem(), m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_6_valueOrError2 = _out4
	if !(!((_6_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(345,13): " + (_6_valueOrError2).String())
	}
	_5_attrs = (_6_valueOrError2).Extract().(_dafny.Map)
	if !((_5_attrs).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_Mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("N_"), m_BeaconTestFixtures.Companion_Default___.Name__beacon()), _dafny.SeqOfString(".Y_1984")))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_Name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Name__beacon())).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_NameTitle"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("N_"), m_BeaconTestFixtures.Companion_Default___.Name__beacon()), _dafny.SeqOfString(".T_")), m_BeaconTestFixtures.Companion_Default___.Title__beacon()))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_NameTitleField"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("4c577d7"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Std2__beacon())).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_Title"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Title__beacon())).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std6"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Std6__beacon())).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std4"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Std4__beacon())).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_YearName"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Y_1984.N_"), m_BeaconTestFixtures.Companion_Default___.Name__beacon()))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(346,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) GetBeaconValue(name _dafny.Sequence, key _dafny.Sequence, value _dafny.Sequence, length uint8) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq.SetString()
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _0_valueOrError0
	_0_valueOrError0 = m_UTF8.Encode(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("AWS_DBE_SCAN_BEACON"), name))
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(370,16): " + (_0_valueOrError0).String())
	}
	var _1_info _dafny.Sequence
	_ = _1_info
	_1_info = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_2_valueOrError1 = _out0
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(371,18): " + (_2_valueOrError1).String())
	}
	var _3_client *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _3_client
	_3_client = (_2_valueOrError1).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError2
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (_3_client).Hkdf(m_AwsCryptographyPrimitivesTypes.Companion_HkdfInput_.Create_HkdfInput_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__512_(), m_Wrappers.Companion_Option_.Create_None_(), key, _1_info, int32(64)))
	_4_valueOrError2 = _out1
	if !(!((_4_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(373,15): " + (_4_valueOrError2).String())
	}
	var _5_key _dafny.Sequence
	_ = _5_key
	_5_key = (_4_valueOrError2).Extract().(_dafny.Sequence)
	var _6_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _6_valueOrError3
	_6_valueOrError3 = m_UTF8.Encode(value)
	if !(!((_6_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(381,16): " + (_6_valueOrError3).String())
	}
	var _7_data _dafny.Sequence
	_ = _7_data
	_7_data = (_6_valueOrError3).Extract().(_dafny.Sequence)
	var _8_input m_AwsCryptographyPrimitivesTypes.HMacInput
	_ = _8_input
	_8_input = m_AwsCryptographyPrimitivesTypes.Companion_HMacInput_.Create_HMacInput_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_(), _5_key, _7_data)
	var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _9_valueOrError4
	_9_valueOrError4 = (_3_client).HMac(_8_input)
	if !(!((_9_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(387,18): " + (_9_valueOrError4).String())
	}
	var _10_hmac48 _dafny.Sequence
	_ = _10_hmac48
	_10_hmac48 = (_9_valueOrError4).Extract().(_dafny.Sequence)
	var _11_hmac8 _dafny.Sequence
	_ = _11_hmac8
	_11_hmac8 = (_10_hmac48).Take(8)
	output = m_BaseBeacon.Companion_Default___.BytesToHex(_11_hmac8, length)
	return output
	return output
}
func (_static *CompanionStruct_Default___) TestCompoundQueries() {
	var _0_context m_DynamoDBFilterExpr.ExprContext
	_ = _0_context
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("Mixed = :mixed")), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
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
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(402,25): " + (_3_valueOrError0).String())
	}
	var _4_beaconVersion m_SearchableEncryptionInfo.BeaconVersion
	_ = _4_beaconVersion
	_4_beaconVersion = (_3_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _5_dt__update__tmp_h0 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _5_dt__update__tmp_h0
	var _6_dt__update_hvalues_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("N_MyName.Y_1984"))))
	_ = _6_dt__update_hvalues_h0
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_5_dt__update__tmp_h0).Dtor_keyExpr(), (_5_dt__update__tmp_h0).Dtor_filterExpr(), _6_dt__update_hvalues_h0, (_5_dt__update__tmp_h0).Dtor_names())
	var _7_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _7_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_7_valueOrError1 = _out3
	if !(!((_7_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(405,22): " + (_7_valueOrError1).String())
	}
	var _8_newContext m_DynamoDBFilterExpr.ExprContext
	_ = _8_newContext
	_8_newContext = (_7_valueOrError1).Extract().(m_DynamoDBFilterExpr.ExprContext)
	var _9_dt__update__tmp_h1 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _9_dt__update__tmp_h1
	var _10_dt__update_hvalues_h1 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("N_MyName"))))
	_ = _10_dt__update_hvalues_h1
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_9_dt__update__tmp_h1).Dtor_keyExpr(), (_9_dt__update__tmp_h1).Dtor_filterExpr(), _10_dt__update_hvalues_h1, (_9_dt__update__tmp_h1).Dtor_names())
	var _11_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _11_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_11_valueOrError2 = _out4
	if !(!((_11_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(407,18): " + (_11_valueOrError2).String())
	}
	_8_newContext = (_11_valueOrError2).Extract().(m_DynamoDBFilterExpr.ExprContext)
	var _12_dt__update__tmp_h2 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _12_dt__update__tmp_h2
	var _13_dt__update_hvalues_h2 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("Y_1984"))))
	_ = _13_dt__update_hvalues_h2
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_12_dt__update__tmp_h2).Dtor_keyExpr(), (_12_dt__update__tmp_h2).Dtor_filterExpr(), _13_dt__update_hvalues_h2, (_12_dt__update__tmp_h2).Dtor_names())
	var _14_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _14_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_14_valueOrError3 = _out5
	if !(!((_14_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(409,18): " + (_14_valueOrError3).String())
	}
	_8_newContext = (_14_valueOrError3).Extract().(m_DynamoDBFilterExpr.ExprContext)
	var _15_dt__update__tmp_h3 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _15_dt__update__tmp_h3
	var _16_dt__update_hvalues_h3 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("T_foo"))))
	_ = _16_dt__update_hvalues_h3
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_15_dt__update__tmp_h3).Dtor_keyExpr(), (_15_dt__update__tmp_h3).Dtor_filterExpr(), _16_dt__update_hvalues_h3, (_15_dt__update__tmp_h3).Dtor_names())
	var _17_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _17_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_17_valueOrError4 = _out6
	if !(!((_17_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(411,18): " + (_17_valueOrError4).String())
	}
	_8_newContext = (_17_valueOrError4).Extract().(m_DynamoDBFilterExpr.ExprContext)
	var _18_dt__update__tmp_h4 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _18_dt__update__tmp_h4
	var _19_dt__update_hvalues_h4 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("M_bar"))))
	_ = _19_dt__update_hvalues_h4
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_18_dt__update__tmp_h4).Dtor_keyExpr(), (_18_dt__update__tmp_h4).Dtor_filterExpr(), _19_dt__update_hvalues_h4, (_18_dt__update__tmp_h4).Dtor_names())
	var _20_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _20_valueOrError5
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_20_valueOrError5 = _out7
	if !(!((_20_valueOrError5).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(413,18): " + (_20_valueOrError5).String())
	}
	_8_newContext = (_20_valueOrError5).Extract().(m_DynamoDBFilterExpr.ExprContext)
	var _21_dt__update__tmp_h5 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _21_dt__update__tmp_h5
	var _22_dt__update_hvalues_h5 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("T_foo.M_bar"))))
	_ = _22_dt__update_hvalues_h5
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_21_dt__update__tmp_h5).Dtor_keyExpr(), (_21_dt__update__tmp_h5).Dtor_filterExpr(), _22_dt__update_hvalues_h5, (_21_dt__update__tmp_h5).Dtor_names())
	var _23_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _23_valueOrError6
	var _out8 m_Wrappers.Result
	_ = _out8
	_out8 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_23_valueOrError6 = _out8
	if !(!((_23_valueOrError6).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(415,18): " + (_23_valueOrError6).String())
	}
	_8_newContext = (_23_valueOrError6).Extract().(m_DynamoDBFilterExpr.ExprContext)
	var _24_dt__update__tmp_h6 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _24_dt__update__tmp_h6
	var _25_dt__update_hvalues_h6 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("N_MyName.N_MyName"))))
	_ = _25_dt__update_hvalues_h6
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_24_dt__update__tmp_h6).Dtor_keyExpr(), (_24_dt__update__tmp_h6).Dtor_filterExpr(), _25_dt__update_hvalues_h6, (_24_dt__update__tmp_h6).Dtor_names())
	var _26_badContext m_Wrappers.Result
	_ = _26_badContext
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_26_badContext = _out9
	if !((_26_badContext).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(419,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_26_badContext).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound Beacon value 'N_MyName.N_MyName' cannot be constructed from any available constructor for Mixed value parsed as N_N_ available constructors are N_Y_, T_[M_].")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(420,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _27_dt__update__tmp_h7 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _27_dt__update__tmp_h7
	var _28_dt__update_hvalues_h7 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("Y_1984.N_MyName"))))
	_ = _28_dt__update_hvalues_h7
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_27_dt__update__tmp_h7).Dtor_keyExpr(), (_27_dt__update__tmp_h7).Dtor_filterExpr(), _28_dt__update_hvalues_h7, (_27_dt__update__tmp_h7).Dtor_names())
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_26_badContext = _out10
	if !((_26_badContext).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(424,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_26_badContext).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound Beacon value 'Y_1984.N_MyName' cannot be constructed from any available constructor for Mixed value parsed as Y_N_ available constructors are N_Y_, T_[M_].")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(425,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _29_dt__update__tmp_h8 m_DynamoDBFilterExpr.ExprContext = _0_context
	_ = _29_dt__update__tmp_h8
	var _30_dt__update_hvalues_h8 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("M_bar.T_foo"))))
	_ = _30_dt__update_hvalues_h8
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((_29_dt__update__tmp_h8).Dtor_keyExpr(), (_29_dt__update__tmp_h8).Dtor_filterExpr(), _30_dt__update_hvalues_h8, (_29_dt__update__tmp_h8).Dtor_names())
	var _out11 m_Wrappers.Result
	_ = _out11
	_out11 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_4_beaconVersion, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_26_badContext = _out11
	if !((_26_badContext).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(429,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_26_badContext).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound Beacon value 'M_bar.T_foo' cannot be constructed from any available constructor for Mixed value parsed as M_T_ available constructors are N_Y_, T_[M_].")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(430,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestQueryBeacons() {
	var _0_context m_DynamoDBFilterExpr.ExprContext
	_ = _0_context
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("std2 = :std2 AND std4 = :std4 AND :std6 = std6 AND Name = :Name AND Mixed = :Mixed"), _dafny.SeqOfString(" AND :NameTitle = NameTitle AND NameTitle = :NameTitleN AND NameTitle = :NameTitleT AND NameTitle = :NameTitleTN")), _dafny.SeqOfString(" AND NameTitleField = :NameTitleField And Title = :Title AND YearName = :YearName"))), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":std2"), m_BeaconTestFixtures.Companion_Default___.Std2String()).UpdateUnsafe(_dafny.SeqOfString(":std4"), m_BeaconTestFixtures.Companion_Default___.Std4String()).UpdateUnsafe(_dafny.SeqOfString(":std6"), m_BeaconTestFixtures.Companion_Default___.Std6String()).UpdateUnsafe(_dafny.SeqOfString(":Name"), m_BeaconTestFixtures.Companion_Default___.NameString()).UpdateUnsafe(_dafny.SeqOfString(":Title"), m_BeaconTestFixtures.Companion_Default___.TitleString()).UpdateUnsafe(_dafny.SeqOfString(":Mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("N_MyName.Y_1984"))).UpdateUnsafe(_dafny.SeqOfString(":NameTitle"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("N_MyName.T_MyTitle"))).UpdateUnsafe(_dafny.SeqOfString(":NameTitleN"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("N_MyName"))).UpdateUnsafe(_dafny.SeqOfString(":NameTitleT"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("T_MyTitle"))).UpdateUnsafe(_dafny.SeqOfString(":NameTitleTN"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("N_MyName.T_MyTitle"))).UpdateUnsafe(_dafny.SeqOfString(":NameTitleField"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("MyName__mytitle"))).UpdateUnsafe(_dafny.SeqOfString(":YearName"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("Y_1984.N_MyName")))), m_Wrappers.Companion_Option_.Create_None_())
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
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(457,25): " + (_3_valueOrError0).String())
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
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(458,22): " + (_5_valueOrError1).String())
	}
	var _6_newContext m_DynamoDBFilterExpr.ExprContext
	_ = _6_newContext
	_6_newContext = (_5_valueOrError1).Extract().(m_DynamoDBFilterExpr.ExprContext)
	if !(((_6_newContext).Dtor_values()).Equals(m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":Mixed"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("N_"), m_BeaconTestFixtures.Companion_Default___.Name__beacon()), _dafny.SeqOfString(".Y_1984")))).UpdateUnsafe(_dafny.SeqOfString(":Name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Name__beacon())).UpdateUnsafe(_dafny.SeqOfString(":NameTitle"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("N_"), m_BeaconTestFixtures.Companion_Default___.Name__beacon()), _dafny.SeqOfString(".T_")), m_BeaconTestFixtures.Companion_Default___.Title__beacon()))).UpdateUnsafe(_dafny.SeqOfString(":NameTitleTN"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("N_"), m_BeaconTestFixtures.Companion_Default___.Name__beacon()), _dafny.SeqOfString(".T_")), m_BeaconTestFixtures.Companion_Default___.Title__beacon()))).UpdateUnsafe(_dafny.SeqOfString(":NameTitleN"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("N_"), m_BeaconTestFixtures.Companion_Default___.Name__beacon()))).UpdateUnsafe(_dafny.SeqOfString(":NameTitleT"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("T_"), m_BeaconTestFixtures.Companion_Default___.Title__beacon()))).UpdateUnsafe(_dafny.SeqOfString(":NameTitleField"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.NameTitle__beacon())).UpdateUnsafe(_dafny.SeqOfString(":std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Std2__beacon())).UpdateUnsafe(_dafny.SeqOfString(":Title"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Title__beacon())).UpdateUnsafe(_dafny.SeqOfString(":std6"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Std6__beacon())).UpdateUnsafe(_dafny.SeqOfString(":std4"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(m_BeaconTestFixtures.Companion_Default___.Std4__beacon())).UpdateUnsafe(_dafny.SeqOfString(":YearName"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Y_1984.N_"), m_BeaconTestFixtures.Companion_Default___.Name__beacon())))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(459,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_newContext).Dtor_names()).Equals(m_Wrappers.Companion_Option_.Create_None_())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(473,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestUnusedPartOnly() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_badBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _1_badBeacon
	_1_badBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("badBeacon"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_partOnly_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PartOnly_.Create_PartOnly_())))
	var _2_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _2_newConfig
	var _3_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _3_dt__update__tmp_h0
	var _4_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("badBeacon"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _4_dt__update_hattributeActionsOnEncrypt_h0
	_2_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_3_dt__update__tmp_h0).Dtor_logicalTableName(), (_3_dt__update__tmp_h0).Dtor_partitionKeyName(), (_3_dt__update__tmp_h0).Dtor_sortKeyName(), (_3_dt__update__tmp_h0).Dtor_search(), _4_dt__update_hattributeActionsOnEncrypt_h0, (_3_dt__update__tmp_h0).Dtor_allowedUnsignedAttributes(), (_3_dt__update__tmp_h0).Dtor_allowedUnsignedAttributePrefix(), (_3_dt__update__tmp_h0).Dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).Dtor_keyring(), (_3_dt__update__tmp_h0).Dtor_cmm(), (_3_dt__update__tmp_h0).Dtor_legacyOverride(), (_3_dt__update__tmp_h0).Dtor_plaintextOverride())
	var _5_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _5_dt__update__tmp_h1
	var _6_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_0_version).Dtor_standardBeacons(), _dafny.SeqOf(_1_badBeacon))
	_ = _6_dt__update_hstandardBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_5_dt__update__tmp_h1).Dtor_version(), (_5_dt__update__tmp_h1).Dtor_keyStore(), (_5_dt__update__tmp_h1).Dtor_keySource(), _6_dt__update_hstandardBeacons_h0, (_5_dt__update__tmp_h1).Dtor_compoundBeacons(), (_5_dt__update__tmp_h1).Dtor_virtualFields(), (_5_dt__update__tmp_h1).Dtor_encryptedParts(), (_5_dt__update__tmp_h1).Dtor_signedParts())
	var _7_src m_SearchableEncryptionInfo.KeySource
	_ = _7_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_7_src = _out1
	var _8_bv m_Wrappers.Result
	_ = _8_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_2_newConfig, _0_version, _7_src)
	_8_bv = _out2
	if !((_8_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(488,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_8_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("PartOnly beacon badBeacon MUST be used in a compound beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(489,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestCompoundWithUnknown() {
	var _0_Unknown m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart
	_ = _0_Unknown
	_0_Unknown = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.SeqOfString("Unknown"), _dafny.SeqOfString("U_"))
	var _1_NameUnknown m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon
	_ = _1_NameUnknown
	_1_NameUnknown = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("NameUnknown"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Name(), _0_Unknown)), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	if !(((_2_version).Dtor_compoundBeacons()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(504,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _2_version
	_ = _3_dt__update__tmp_h0
	var _4_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(((_2_version).Dtor_compoundBeacons()).Dtor_value().(_dafny.Sequence), _dafny.SeqOf(_1_NameUnknown)))
	_ = _4_dt__update_hcompoundBeacons_h0
	_2_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_3_dt__update__tmp_h0).Dtor_version(), (_3_dt__update__tmp_h0).Dtor_keyStore(), (_3_dt__update__tmp_h0).Dtor_keySource(), (_3_dt__update__tmp_h0).Dtor_standardBeacons(), _4_dt__update_hcompoundBeacons_h0, (_3_dt__update__tmp_h0).Dtor_virtualFields(), (_3_dt__update__tmp_h0).Dtor_encryptedParts(), (_3_dt__update__tmp_h0).Dtor_signedParts())
	var _5_src m_SearchableEncryptionInfo.KeySource
	_ = _5_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _2_version)
	_5_src = _out1
	var _6_bv m_Wrappers.Result
	_ = _6_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _2_version, _5_src)
	_6_bv = _out2
	if !((_6_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(508,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound beacon NameUnknown refers to standard beacon Unknown which is not configured.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(509,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TesSetInCompound() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_setBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _1_setBeacon
	_1_setBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("setBeacon"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_asSet_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_AsSet_.Create_AsSet_())))
	var _2_compoundSet m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon
	_ = _2_compoundSet
	_2_compoundSet = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("compoundSet"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Name(), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.SeqOfString("setBeacon"), _dafny.SeqOfString("S_")))), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	if !(((_0_version).Dtor_compoundBeacons()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(527,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _3_newConfig
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("setBeacon"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _5_dt__update_hattributeActionsOnEncrypt_h0
	_3_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_4_dt__update__tmp_h0).Dtor_logicalTableName(), (_4_dt__update__tmp_h0).Dtor_partitionKeyName(), (_4_dt__update__tmp_h0).Dtor_sortKeyName(), (_4_dt__update__tmp_h0).Dtor_search(), _5_dt__update_hattributeActionsOnEncrypt_h0, (_4_dt__update__tmp_h0).Dtor_allowedUnsignedAttributes(), (_4_dt__update__tmp_h0).Dtor_allowedUnsignedAttributePrefix(), (_4_dt__update__tmp_h0).Dtor_algorithmSuiteId(), (_4_dt__update__tmp_h0).Dtor_keyring(), (_4_dt__update__tmp_h0).Dtor_cmm(), (_4_dt__update__tmp_h0).Dtor_legacyOverride(), (_4_dt__update__tmp_h0).Dtor_plaintextOverride())
	var _6_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _6_dt__update__tmp_h1
	var _7_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(((_0_version).Dtor_compoundBeacons()).Dtor_value().(_dafny.Sequence), _dafny.SeqOf(_2_compoundSet)))
	_ = _7_dt__update_hcompoundBeacons_h0
	var _8_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_0_version).Dtor_standardBeacons(), _dafny.SeqOf(_1_setBeacon))
	_ = _8_dt__update_hstandardBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_6_dt__update__tmp_h1).Dtor_version(), (_6_dt__update__tmp_h1).Dtor_keyStore(), (_6_dt__update__tmp_h1).Dtor_keySource(), _8_dt__update_hstandardBeacons_h0, _7_dt__update_hcompoundBeacons_h0, (_6_dt__update__tmp_h1).Dtor_virtualFields(), (_6_dt__update__tmp_h1).Dtor_encryptedParts(), (_6_dt__update__tmp_h1).Dtor_signedParts())
	var _9_src m_SearchableEncryptionInfo.KeySource
	_ = _9_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_9_src = _out1
	var _10_bv m_Wrappers.Result
	_ = _10_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_3_newConfig, _0_version, _9_src)
	_10_bv = _out2
	if !((_10_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(533,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_10_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound beacon compoundSet uses setBeacon which is an AsSet beacon, and therefore cannot be used in a Compound Beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(534,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) SharedBadReferenceToCompound() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_shareBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _1_shareBeacon
	_1_shareBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("shareBeacon"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_shared_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Shared_.Create_Shared_(_dafny.SeqOfString("NameTitle")))))
	var _2_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _2_newConfig
	var _3_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _3_dt__update__tmp_h0
	var _4_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("shareBeacon"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _4_dt__update_hattributeActionsOnEncrypt_h0
	_2_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_3_dt__update__tmp_h0).Dtor_logicalTableName(), (_3_dt__update__tmp_h0).Dtor_partitionKeyName(), (_3_dt__update__tmp_h0).Dtor_sortKeyName(), (_3_dt__update__tmp_h0).Dtor_search(), _4_dt__update_hattributeActionsOnEncrypt_h0, (_3_dt__update__tmp_h0).Dtor_allowedUnsignedAttributes(), (_3_dt__update__tmp_h0).Dtor_allowedUnsignedAttributePrefix(), (_3_dt__update__tmp_h0).Dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).Dtor_keyring(), (_3_dt__update__tmp_h0).Dtor_cmm(), (_3_dt__update__tmp_h0).Dtor_legacyOverride(), (_3_dt__update__tmp_h0).Dtor_plaintextOverride())
	var _5_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _5_dt__update__tmp_h1
	var _6_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_0_version).Dtor_standardBeacons(), _dafny.SeqOf(_1_shareBeacon))
	_ = _6_dt__update_hstandardBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_5_dt__update__tmp_h1).Dtor_version(), (_5_dt__update__tmp_h1).Dtor_keyStore(), (_5_dt__update__tmp_h1).Dtor_keySource(), _6_dt__update_hstandardBeacons_h0, (_5_dt__update__tmp_h1).Dtor_compoundBeacons(), (_5_dt__update__tmp_h1).Dtor_virtualFields(), (_5_dt__update__tmp_h1).Dtor_encryptedParts(), (_5_dt__update__tmp_h1).Dtor_signedParts())
	var _7_src m_SearchableEncryptionInfo.KeySource
	_ = _7_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_7_src = _out1
	var _8_bv m_Wrappers.Result
	_ = _8_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_2_newConfig, _0_version, _7_src)
	_8_bv = _out2
	if !((_8_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(549,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_8_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon shareBeacon is shared to NameTitle but NameTitle is a compound beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(550,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) ChainedShare() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_shareBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _1_shareBeacon
	_1_shareBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("shareBeacon"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_shared_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Shared_.Create_Shared_(_dafny.SeqOfString("std2")))))
	var _2_other m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _2_other
	_2_other = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("std4"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_shared_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Shared_.Create_Shared_(_dafny.SeqOfString("shareBeacon")))))
	var _3_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _3_newConfig
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("shareBeacon"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _5_dt__update_hattributeActionsOnEncrypt_h0
	_3_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_4_dt__update__tmp_h0).Dtor_logicalTableName(), (_4_dt__update__tmp_h0).Dtor_partitionKeyName(), (_4_dt__update__tmp_h0).Dtor_sortKeyName(), (_4_dt__update__tmp_h0).Dtor_search(), _5_dt__update_hattributeActionsOnEncrypt_h0, (_4_dt__update__tmp_h0).Dtor_allowedUnsignedAttributes(), (_4_dt__update__tmp_h0).Dtor_allowedUnsignedAttributePrefix(), (_4_dt__update__tmp_h0).Dtor_algorithmSuiteId(), (_4_dt__update__tmp_h0).Dtor_keyring(), (_4_dt__update__tmp_h0).Dtor_cmm(), (_4_dt__update__tmp_h0).Dtor_legacyOverride(), (_4_dt__update__tmp_h0).Dtor_plaintextOverride())
	var _6_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _6_dt__update__tmp_h1
	var _7_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Std2(), _1_shareBeacon, _2_other)
	_ = _7_dt__update_hstandardBeacons_h0
	var _8_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_None_()
	_ = _8_dt__update_hcompoundBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_6_dt__update__tmp_h1).Dtor_version(), (_6_dt__update__tmp_h1).Dtor_keyStore(), (_6_dt__update__tmp_h1).Dtor_keySource(), _7_dt__update_hstandardBeacons_h0, _8_dt__update_hcompoundBeacons_h0, (_6_dt__update__tmp_h1).Dtor_virtualFields(), (_6_dt__update__tmp_h1).Dtor_encryptedParts(), (_6_dt__update__tmp_h1).Dtor_signedParts())
	var _9_src m_SearchableEncryptionInfo.KeySource
	_ = _9_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_9_src = _out1
	var _10_bv m_Wrappers.Result
	_ = _10_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_3_newConfig, _0_version, _9_src)
	_10_bv = _out2
	if !((_10_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(569,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_10_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon std4 is shared to shareBeacon which is in turn shared to std2. Share chains are not allowed.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(570,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) SelfShare() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_shareBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _1_shareBeacon
	_1_shareBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("shareBeacon"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_shared_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Shared_.Create_Shared_(_dafny.SeqOfString("shareBeacon")))))
	var _2_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _2_newConfig
	var _3_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _3_dt__update__tmp_h0
	var _4_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("shareBeacon"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _4_dt__update_hattributeActionsOnEncrypt_h0
	_2_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_3_dt__update__tmp_h0).Dtor_logicalTableName(), (_3_dt__update__tmp_h0).Dtor_partitionKeyName(), (_3_dt__update__tmp_h0).Dtor_sortKeyName(), (_3_dt__update__tmp_h0).Dtor_search(), _4_dt__update_hattributeActionsOnEncrypt_h0, (_3_dt__update__tmp_h0).Dtor_allowedUnsignedAttributes(), (_3_dt__update__tmp_h0).Dtor_allowedUnsignedAttributePrefix(), (_3_dt__update__tmp_h0).Dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).Dtor_keyring(), (_3_dt__update__tmp_h0).Dtor_cmm(), (_3_dt__update__tmp_h0).Dtor_legacyOverride(), (_3_dt__update__tmp_h0).Dtor_plaintextOverride())
	var _5_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _5_dt__update__tmp_h1
	var _6_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Std2(), _1_shareBeacon)
	_ = _6_dt__update_hstandardBeacons_h0
	var _7_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_None_()
	_ = _7_dt__update_hcompoundBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_5_dt__update__tmp_h1).Dtor_version(), (_5_dt__update__tmp_h1).Dtor_keyStore(), (_5_dt__update__tmp_h1).Dtor_keySource(), _6_dt__update_hstandardBeacons_h0, _7_dt__update_hcompoundBeacons_h0, (_5_dt__update__tmp_h1).Dtor_virtualFields(), (_5_dt__update__tmp_h1).Dtor_encryptedParts(), (_5_dt__update__tmp_h1).Dtor_signedParts())
	var _8_src m_SearchableEncryptionInfo.KeySource
	_ = _8_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_8_src = _out1
	var _9_bv m_Wrappers.Result
	_ = _9_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_2_newConfig, _0_version, _8_src)
	_9_bv = _out2
	if !((_9_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(585,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_9_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon shareBeacon is shared to itself.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(586,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) SharedBadReferenceNonExistent() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_shareBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _1_shareBeacon
	_1_shareBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("shareBeacon"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_shared_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Shared_.Create_Shared_(_dafny.SeqOfString("DoesNotExist")))))
	var _2_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _2_dt__update__tmp_h0
	var _3_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_0_version).Dtor_standardBeacons(), _dafny.SeqOf(_1_shareBeacon))
	_ = _3_dt__update_hstandardBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_2_dt__update__tmp_h0).Dtor_version(), (_2_dt__update__tmp_h0).Dtor_keyStore(), (_2_dt__update__tmp_h0).Dtor_keySource(), _3_dt__update_hstandardBeacons_h0, (_2_dt__update__tmp_h0).Dtor_compoundBeacons(), (_2_dt__update__tmp_h0).Dtor_virtualFields(), (_2_dt__update__tmp_h0).Dtor_encryptedParts(), (_2_dt__update__tmp_h0).Dtor_signedParts())
	var _4_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _4_newConfig
	var _5_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _5_dt__update__tmp_h1
	var _6_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("shareBeacon"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _6_dt__update_hattributeActionsOnEncrypt_h0
	_4_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_5_dt__update__tmp_h1).Dtor_logicalTableName(), (_5_dt__update__tmp_h1).Dtor_partitionKeyName(), (_5_dt__update__tmp_h1).Dtor_sortKeyName(), (_5_dt__update__tmp_h1).Dtor_search(), _6_dt__update_hattributeActionsOnEncrypt_h0, (_5_dt__update__tmp_h1).Dtor_allowedUnsignedAttributes(), (_5_dt__update__tmp_h1).Dtor_allowedUnsignedAttributePrefix(), (_5_dt__update__tmp_h1).Dtor_algorithmSuiteId(), (_5_dt__update__tmp_h1).Dtor_keyring(), (_5_dt__update__tmp_h1).Dtor_cmm(), (_5_dt__update__tmp_h1).Dtor_legacyOverride(), (_5_dt__update__tmp_h1).Dtor_plaintextOverride())
	var _7_src m_SearchableEncryptionInfo.KeySource
	_ = _7_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_7_src = _out1
	var _8_bv m_Wrappers.Result
	_ = _8_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_4_newConfig, _0_version, _7_src)
	_8_bv = _out2
	if !((_8_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(601,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_8_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon shareBeacon is shared to DoesNotExist which is not defined.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(602,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) SharedBadLength() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_shareBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _1_shareBeacon
	_1_shareBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("shareBeacon"), int32(23), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_shared_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Shared_.Create_Shared_(_dafny.SeqOfString("std2")))))
	var _2_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _2_dt__update__tmp_h0
	var _3_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_0_version).Dtor_standardBeacons(), _dafny.SeqOf(_1_shareBeacon))
	_ = _3_dt__update_hstandardBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_2_dt__update__tmp_h0).Dtor_version(), (_2_dt__update__tmp_h0).Dtor_keyStore(), (_2_dt__update__tmp_h0).Dtor_keySource(), _3_dt__update_hstandardBeacons_h0, (_2_dt__update__tmp_h0).Dtor_compoundBeacons(), (_2_dt__update__tmp_h0).Dtor_virtualFields(), (_2_dt__update__tmp_h0).Dtor_encryptedParts(), (_2_dt__update__tmp_h0).Dtor_signedParts())
	var _4_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _4_newConfig
	var _5_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _5_dt__update__tmp_h1
	var _6_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("shareBeacon"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _6_dt__update_hattributeActionsOnEncrypt_h0
	_4_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_5_dt__update__tmp_h1).Dtor_logicalTableName(), (_5_dt__update__tmp_h1).Dtor_partitionKeyName(), (_5_dt__update__tmp_h1).Dtor_sortKeyName(), (_5_dt__update__tmp_h1).Dtor_search(), _6_dt__update_hattributeActionsOnEncrypt_h0, (_5_dt__update__tmp_h1).Dtor_allowedUnsignedAttributes(), (_5_dt__update__tmp_h1).Dtor_allowedUnsignedAttributePrefix(), (_5_dt__update__tmp_h1).Dtor_algorithmSuiteId(), (_5_dt__update__tmp_h1).Dtor_keyring(), (_5_dt__update__tmp_h1).Dtor_cmm(), (_5_dt__update__tmp_h1).Dtor_legacyOverride(), (_5_dt__update__tmp_h1).Dtor_plaintextOverride())
	var _7_src m_SearchableEncryptionInfo.KeySource
	_ = _7_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_7_src = _out1
	var _8_bv m_Wrappers.Result
	_ = _8_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_4_newConfig, _0_version, _7_src)
	_8_bv = _out2
	if !((_8_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(618,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_8_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon shareBeacon is shared to std2 but shareBeacon has length 23 and std2 has length 24.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(619,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestPartOnlyNotStored() {
	var _0_MyItem _dafny.Map
	_ = _0_MyItem
	_0_MyItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc"))).UpdateUnsafe(_dafny.SeqOfString("partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("def")))
	var _1_compoundPart m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon
	_ = _1_compoundPart
	_1_compoundPart = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("compoundPart"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.SeqOfString("partOnly"), _dafny.SeqOfString("S_")))), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _2_context m_DynamoDBFilterExpr.ExprContext
	_ = _2_context
	_2_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("partOnly = :val")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":val"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("foo")))), m_Wrappers.Companion_Option_.Create_None_())
	var _3_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_3_version = _out0
	if !(((_3_version).Dtor_compoundBeacons()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(643,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _4_partBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _4_partBeacon
	_4_partBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("partOnly"), int32(23), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _5_newVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _5_newVersion
	var _6_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _3_version
	_ = _6_dt__update__tmp_h0
	var _7_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(((_3_version).Dtor_compoundBeacons()).Dtor_value().(_dafny.Sequence), _dafny.SeqOf(_1_compoundPart)))
	_ = _7_dt__update_hcompoundBeacons_h0
	var _8_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_3_version).Dtor_standardBeacons(), _dafny.SeqOf(_4_partBeacon))
	_ = _8_dt__update_hstandardBeacons_h0
	_5_newVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_6_dt__update__tmp_h0).Dtor_version(), (_6_dt__update__tmp_h0).Dtor_keyStore(), (_6_dt__update__tmp_h0).Dtor_keySource(), _8_dt__update_hstandardBeacons_h0, _7_dt__update_hcompoundBeacons_h0, (_6_dt__update__tmp_h0).Dtor_virtualFields(), (_6_dt__update__tmp_h0).Dtor_encryptedParts(), (_6_dt__update__tmp_h0).Dtor_signedParts())
	var _9_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _9_newConfig
	var _10_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _10_dt__update__tmp_h1
	var _11_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("partOnly"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _11_dt__update_hattributeActionsOnEncrypt_h0
	_9_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_10_dt__update__tmp_h1).Dtor_logicalTableName(), (_10_dt__update__tmp_h1).Dtor_partitionKeyName(), (_10_dt__update__tmp_h1).Dtor_sortKeyName(), (_10_dt__update__tmp_h1).Dtor_search(), _11_dt__update_hattributeActionsOnEncrypt_h0, (_10_dt__update__tmp_h1).Dtor_allowedUnsignedAttributes(), (_10_dt__update__tmp_h1).Dtor_allowedUnsignedAttributePrefix(), (_10_dt__update__tmp_h1).Dtor_algorithmSuiteId(), (_10_dt__update__tmp_h1).Dtor_keyring(), (_10_dt__update__tmp_h1).Dtor_cmm(), (_10_dt__update__tmp_h1).Dtor_legacyOverride(), (_10_dt__update__tmp_h1).Dtor_plaintextOverride())
	var _12_src m_SearchableEncryptionInfo.KeySource
	_ = _12_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _5_newVersion)
	_12_src = _out1
	var _13_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _13_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_9_newConfig, _5_newVersion, _12_src)
	_13_valueOrError0 = _out2
	if !(!((_13_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(652,14): " + (_13_valueOrError0).String())
	}
	var _14_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _14_bv
	_14_bv = (_13_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _15_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _15_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_14_bv).GenerateEncryptedBeacons(_0_MyItem, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_15_valueOrError1 = _out3
	if !(!((_15_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(654,21): " + (_15_valueOrError1).String())
	}
	var _16_goodAttrs _dafny.Map
	_ = _16_goodAttrs
	_16_goodAttrs = (_15_valueOrError1).Extract().(_dafny.Map)
	if !((_16_goodAttrs).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("51e1da"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("405a51"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_compoundPart"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("S_405a51"))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(655,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _17_goodQuery m_Wrappers.Result
	_ = _17_goodQuery
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_14_bv, _2_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_17_goodQuery = _out4
	if !((_17_goodQuery).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(661,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_4_partBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("partOnly"), int32(23), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_partOnly_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PartOnly_.Create_PartOnly_())))
	var _18_dt__update__tmp_h2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _3_version
	_ = _18_dt__update__tmp_h2
	var _19_dt__update_hcompoundBeacons_h1 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(((_3_version).Dtor_compoundBeacons()).Dtor_value().(_dafny.Sequence), _dafny.SeqOf(_1_compoundPart)))
	_ = _19_dt__update_hcompoundBeacons_h1
	var _20_dt__update_hstandardBeacons_h1 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_3_version).Dtor_standardBeacons(), _dafny.SeqOf(_4_partBeacon))
	_ = _20_dt__update_hstandardBeacons_h1
	_5_newVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_18_dt__update__tmp_h2).Dtor_version(), (_18_dt__update__tmp_h2).Dtor_keyStore(), (_18_dt__update__tmp_h2).Dtor_keySource(), _20_dt__update_hstandardBeacons_h1, _19_dt__update_hcompoundBeacons_h1, (_18_dt__update__tmp_h2).Dtor_virtualFields(), (_18_dt__update__tmp_h2).Dtor_encryptedParts(), (_18_dt__update__tmp_h2).Dtor_signedParts())
	var _21_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _21_valueOrError2
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_9_newConfig, _5_newVersion, _12_src)
	_21_valueOrError2 = _out5
	if !(!((_21_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(672,10): " + (_21_valueOrError2).String())
	}
	_14_bv = (_21_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _22_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _22_valueOrError3
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = (_14_bv).GenerateEncryptedBeacons(_0_MyItem, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_22_valueOrError3 = _out6
	if !(!((_22_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(673,17): " + (_22_valueOrError3).String())
	}
	_16_goodAttrs = (_22_valueOrError3).Extract().(_dafny.Map)
	if !((_16_goodAttrs).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("51e1da"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_compoundPart"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("S_405a51"))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(678,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _23_badQuery m_Wrappers.Result
	_ = _23_badQuery
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_14_bv, _2_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_23_badQuery = _out7
	if !((_23_badQuery).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(687,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_23_badQuery).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Field partOnly is encrypted, and has a PartOnly beacon, and so can only be used as part of a compound beacon.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(688,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestShareSameBeacon() {
	var _0_MyItem _dafny.Map
	_ = _0_MyItem
	_0_MyItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc"))).UpdateUnsafe(_dafny.SeqOfString("partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc")))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	if !(((_1_version).Dtor_compoundBeacons()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(699,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _2_partBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _2_partBeacon
	_2_partBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("partOnly"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _3_newVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_newVersion
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _1_version
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_1_version).Dtor_standardBeacons(), _dafny.SeqOf(_2_partBeacon))
	_ = _5_dt__update_hstandardBeacons_h0
	_3_newVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_4_dt__update__tmp_h0).Dtor_version(), (_4_dt__update__tmp_h0).Dtor_keyStore(), (_4_dt__update__tmp_h0).Dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).Dtor_compoundBeacons(), (_4_dt__update__tmp_h0).Dtor_virtualFields(), (_4_dt__update__tmp_h0).Dtor_encryptedParts(), (_4_dt__update__tmp_h0).Dtor_signedParts())
	var _6_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _6_newConfig
	var _7_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _7_dt__update__tmp_h1
	var _8_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("partOnly"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _8_dt__update_hattributeActionsOnEncrypt_h0
	_6_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_7_dt__update__tmp_h1).Dtor_logicalTableName(), (_7_dt__update__tmp_h1).Dtor_partitionKeyName(), (_7_dt__update__tmp_h1).Dtor_sortKeyName(), (_7_dt__update__tmp_h1).Dtor_search(), _8_dt__update_hattributeActionsOnEncrypt_h0, (_7_dt__update__tmp_h1).Dtor_allowedUnsignedAttributes(), (_7_dt__update__tmp_h1).Dtor_allowedUnsignedAttributePrefix(), (_7_dt__update__tmp_h1).Dtor_algorithmSuiteId(), (_7_dt__update__tmp_h1).Dtor_keyring(), (_7_dt__update__tmp_h1).Dtor_cmm(), (_7_dt__update__tmp_h1).Dtor_legacyOverride(), (_7_dt__update__tmp_h1).Dtor_plaintextOverride())
	var _9_src m_SearchableEncryptionInfo.KeySource
	_ = _9_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _3_newVersion)
	_9_src = _out1
	var _10_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _10_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src)
	_10_valueOrError0 = _out2
	if !(!((_10_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(707,14): " + (_10_valueOrError0).String())
	}
	var _11_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _11_bv
	_11_bv = (_10_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _12_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _12_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_11_bv).GenerateEncryptedBeacons(_0_MyItem, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_12_valueOrError1 = _out3
	if !(!((_12_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(709,21): " + (_12_valueOrError1).String())
	}
	var _13_goodAttrs _dafny.Map
	_ = _13_goodAttrs
	_13_goodAttrs = (_12_valueOrError1).Extract().(_dafny.Map)
	if !((_13_goodAttrs).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("51e1da"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("928d9b"))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(710,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_2_partBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("partOnly"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_shared_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Shared_.Create_Shared_(_dafny.SeqOfString("std2")))))
	var _14_dt__update__tmp_h2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _1_version
	_ = _14_dt__update__tmp_h2
	var _15_dt__update_hstandardBeacons_h1 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_1_version).Dtor_standardBeacons(), _dafny.SeqOf(_2_partBeacon))
	_ = _15_dt__update_hstandardBeacons_h1
	_3_newVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_14_dt__update__tmp_h2).Dtor_version(), (_14_dt__update__tmp_h2).Dtor_keyStore(), (_14_dt__update__tmp_h2).Dtor_keySource(), _15_dt__update_hstandardBeacons_h1, (_14_dt__update__tmp_h2).Dtor_compoundBeacons(), (_14_dt__update__tmp_h2).Dtor_virtualFields(), (_14_dt__update__tmp_h2).Dtor_encryptedParts(), (_14_dt__update__tmp_h2).Dtor_signedParts())
	var _16_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _16_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src)
	_16_valueOrError2 = _out4
	if !(!((_16_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(723,10): " + (_16_valueOrError2).String())
	}
	_11_bv = (_16_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _17_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _17_valueOrError3
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_11_bv).GenerateEncryptedBeacons(_0_MyItem, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_17_valueOrError3 = _out5
	if !(!((_17_valueOrError3).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(724,17): " + (_17_valueOrError3).String())
	}
	_13_goodAttrs = (_17_valueOrError3).Extract().(_dafny.Map)
	if !((_13_goodAttrs).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("51e1da"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("51e1da"))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(729,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _18_context m_DynamoDBFilterExpr.ExprContext
	_ = _18_context
	_18_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("partOnly = :pVal AND std2 = :sVal")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":pVal"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("foo"))).UpdateUnsafe(_dafny.SeqOfString(":sVal"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("foo")))), m_Wrappers.Companion_Option_.Create_None_())
	var _19_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _19_valueOrError4
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_11_bv, _18_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_19_valueOrError4 = _out6
	if !(!((_19_valueOrError4).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(741,21): " + (_19_valueOrError4).String())
	}
	var _20_goodQuery m_DynamoDBFilterExpr.ExprContext
	_ = _20_goodQuery
	_20_goodQuery = (_19_valueOrError4).Extract().(m_DynamoDBFilterExpr.ExprContext)
	if !(((_20_goodQuery).Dtor_values()).Equals(m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":pVal"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("4379a7"))).UpdateUnsafe(_dafny.SeqOfString(":sVal"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("4379a7")))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(742,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestBeaconSetQuery() {
	var _0_context m_DynamoDBFilterExpr.ExprContext
	_ = _0_context
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("setAttr = :setVal")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":setVal"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("abc"), _dafny.SeqOfString("def"), _dafny.SeqOfString("ghi"))))), m_Wrappers.Companion_Option_.Create_None_())
	var _1_setBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _1_setBeacon
	_1_setBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("setAttr"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_asSet_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_AsSet_.Create_AsSet_())))
	var _2_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _2_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_2_version = _out0
	var _3_newVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_newVersion
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _2_version
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_2_version).Dtor_standardBeacons(), _dafny.SeqOf(_1_setBeacon))
	_ = _5_dt__update_hstandardBeacons_h0
	_3_newVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_4_dt__update__tmp_h0).Dtor_version(), (_4_dt__update__tmp_h0).Dtor_keyStore(), (_4_dt__update__tmp_h0).Dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).Dtor_compoundBeacons(), (_4_dt__update__tmp_h0).Dtor_virtualFields(), (_4_dt__update__tmp_h0).Dtor_encryptedParts(), (_4_dt__update__tmp_h0).Dtor_signedParts())
	var _6_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _6_newConfig
	var _7_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _7_dt__update__tmp_h1
	var _8_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("setAttr"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _8_dt__update_hattributeActionsOnEncrypt_h0
	_6_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_7_dt__update__tmp_h1).Dtor_logicalTableName(), (_7_dt__update__tmp_h1).Dtor_partitionKeyName(), (_7_dt__update__tmp_h1).Dtor_sortKeyName(), (_7_dt__update__tmp_h1).Dtor_search(), _8_dt__update_hattributeActionsOnEncrypt_h0, (_7_dt__update__tmp_h1).Dtor_allowedUnsignedAttributes(), (_7_dt__update__tmp_h1).Dtor_allowedUnsignedAttributePrefix(), (_7_dt__update__tmp_h1).Dtor_algorithmSuiteId(), (_7_dt__update__tmp_h1).Dtor_keyring(), (_7_dt__update__tmp_h1).Dtor_cmm(), (_7_dt__update__tmp_h1).Dtor_legacyOverride(), (_7_dt__update__tmp_h1).Dtor_plaintextOverride())
	var _9_src m_SearchableEncryptionInfo.KeySource
	_ = _9_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _3_newVersion)
	_9_src = _out1
	var _10_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _10_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src)
	_10_valueOrError0 = _out2
	if !(!((_10_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(765,14): " + (_10_valueOrError0).String())
	}
	var _11_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _11_bv
	_11_bv = (_10_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	var _12_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _12_valueOrError1
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_11_bv, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_12_valueOrError1 = _out3
	if !(!((_12_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(768,21): " + (_12_valueOrError1).String())
	}
	var _13_goodQuery m_DynamoDBFilterExpr.ExprContext
	_ = _13_goodQuery
	_13_goodQuery = (_12_valueOrError1).Extract().(m_DynamoDBFilterExpr.ExprContext)
	if !(((_13_goodQuery).Dtor_values()).Equals(m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":setVal"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("43c4d8"), _dafny.SeqOfString("2f3278"), _dafny.SeqOfString("f1972e"))))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(769,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("setAttr = :setVal")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":setVal"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc")))), m_Wrappers.Companion_Option_.Create_None_())
	var _14_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
	_ = _14_valueOrError2
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_11_bv, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_14_valueOrError2 = _out4
	if !(!((_14_valueOrError2).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(777,17): " + (_14_valueOrError2).String())
	}
	_13_goodQuery = (_14_valueOrError2).Extract().(m_DynamoDBFilterExpr.ExprContext)
	_0_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("setAttr = :setVal")), m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":setVal"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf()))), m_Wrappers.Companion_Option_.Create_None_())
	var _15_badQuery m_Wrappers.Result
	_ = _15_badQuery
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(_11_bv, _0_context, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_(), false)
	_15_badQuery = _out5
	if !((_15_badQuery).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(786,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_15_badQuery).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon setAttr has style AsSet, but attribute has type L.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(787,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSetNotSet() {
	var _0_MyItem _dafny.Map
	_ = _0_MyItem
	_0_MyItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc"))).UpdateUnsafe(_dafny.SeqOfString("partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("abc"), _dafny.SeqOfString("def"), _dafny.SeqOfString("ghi"))))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	if !(((_1_version).Dtor_compoundBeacons()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(798,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _2_partBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _2_partBeacon
	_2_partBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("partOnly"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_asSet_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_AsSet_.Create_AsSet_())))
	var _3_newVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_newVersion
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _1_version
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_1_version).Dtor_standardBeacons(), _dafny.SeqOf(_2_partBeacon))
	_ = _5_dt__update_hstandardBeacons_h0
	_3_newVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_4_dt__update__tmp_h0).Dtor_version(), (_4_dt__update__tmp_h0).Dtor_keyStore(), (_4_dt__update__tmp_h0).Dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).Dtor_compoundBeacons(), (_4_dt__update__tmp_h0).Dtor_virtualFields(), (_4_dt__update__tmp_h0).Dtor_encryptedParts(), (_4_dt__update__tmp_h0).Dtor_signedParts())
	var _6_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _6_newConfig
	var _7_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _7_dt__update__tmp_h1
	var _8_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("partOnly"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _8_dt__update_hattributeActionsOnEncrypt_h0
	_6_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_7_dt__update__tmp_h1).Dtor_logicalTableName(), (_7_dt__update__tmp_h1).Dtor_partitionKeyName(), (_7_dt__update__tmp_h1).Dtor_sortKeyName(), (_7_dt__update__tmp_h1).Dtor_search(), _8_dt__update_hattributeActionsOnEncrypt_h0, (_7_dt__update__tmp_h1).Dtor_allowedUnsignedAttributes(), (_7_dt__update__tmp_h1).Dtor_allowedUnsignedAttributePrefix(), (_7_dt__update__tmp_h1).Dtor_algorithmSuiteId(), (_7_dt__update__tmp_h1).Dtor_keyring(), (_7_dt__update__tmp_h1).Dtor_cmm(), (_7_dt__update__tmp_h1).Dtor_legacyOverride(), (_7_dt__update__tmp_h1).Dtor_plaintextOverride())
	var _9_src m_SearchableEncryptionInfo.KeySource
	_ = _9_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _3_newVersion)
	_9_src = _out1
	var _10_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _10_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src)
	_10_valueOrError0 = _out2
	if !(!((_10_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(809,14): " + (_10_valueOrError0).String())
	}
	var _11_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _11_bv
	_11_bv = (_10_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	if !(((_11_bv).Dtor_beacons()).Contains(_dafny.SeqOfString("partOnly"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(810,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_11_bv).Dtor_beacons()).Get(_dafny.SeqOfString("partOnly")).(m_SearchableEncryptionInfo.Beacon)).Is_Standard()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(811,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _12_goodAttrs m_Wrappers.Result
	_ = _12_goodAttrs
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_11_bv).GenerateEncryptedBeacons(_0_MyItem, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_12_goodAttrs = _out3
	if (_12_goodAttrs).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_12_goodAttrs).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_12_goodAttrs).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(820,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_12_goodAttrs).Dtor_value().(_dafny.Map)).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("51e1da"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("928d9b"), _dafny.SeqOfString("405a51"), _dafny.SeqOfString("9c6c2e")))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(821,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _13_BadItem _dafny.Map
	_ = _13_BadItem
	_13_BadItem = (_0_MyItem).Update(_dafny.SeqOfString("partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc")))
	var _14_badAttrs m_Wrappers.Result
	_ = _14_badAttrs
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_11_bv).GenerateEncryptedBeacons(_13_BadItem, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_14_badAttrs = _out4
	if !((_14_badAttrs).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(832,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_14_badAttrs).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon partOnly has style AsSet, but attribute has type S.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(833,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSharedSet() {
	var _0_MyItem _dafny.Map
	_ = _0_MyItem
	_0_MyItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc"))).UpdateUnsafe(_dafny.SeqOfString("partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("abc"), _dafny.SeqOfString("def"), _dafny.SeqOfString("ghi"))))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	if !(((_1_version).Dtor_compoundBeacons()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(844,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _2_partBeacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _2_partBeacon
	_2_partBeacon = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("partOnly"), int32(24), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconStyle_.Create_sharedSet_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SharedSet_.Create_SharedSet_(_dafny.SeqOfString("std2")))))
	var _3_newVersion m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _3_newVersion
	var _4_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _1_version
	_ = _4_dt__update__tmp_h0
	var _5_dt__update_hstandardBeacons_h0 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((_1_version).Dtor_standardBeacons(), _dafny.SeqOf(_2_partBeacon))
	_ = _5_dt__update_hstandardBeacons_h0
	_3_newVersion = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_4_dt__update__tmp_h0).Dtor_version(), (_4_dt__update__tmp_h0).Dtor_keyStore(), (_4_dt__update__tmp_h0).Dtor_keySource(), _5_dt__update_hstandardBeacons_h0, (_4_dt__update__tmp_h0).Dtor_compoundBeacons(), (_4_dt__update__tmp_h0).Dtor_virtualFields(), (_4_dt__update__tmp_h0).Dtor_encryptedParts(), (_4_dt__update__tmp_h0).Dtor_signedParts())
	var _6_newConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _6_newConfig
	var _7_dt__update__tmp_h1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = m_BeaconTestFixtures.Companion_Default___.FullTableConfig()
	_ = _7_dt__update__tmp_h1
	var _8_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((m_BeaconTestFixtures.Companion_Default___.FullTableConfig()).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("partOnly"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	_ = _8_dt__update_hattributeActionsOnEncrypt_h0
	_6_newConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_((_7_dt__update__tmp_h1).Dtor_logicalTableName(), (_7_dt__update__tmp_h1).Dtor_partitionKeyName(), (_7_dt__update__tmp_h1).Dtor_sortKeyName(), (_7_dt__update__tmp_h1).Dtor_search(), _8_dt__update_hattributeActionsOnEncrypt_h0, (_7_dt__update__tmp_h1).Dtor_allowedUnsignedAttributes(), (_7_dt__update__tmp_h1).Dtor_allowedUnsignedAttributePrefix(), (_7_dt__update__tmp_h1).Dtor_algorithmSuiteId(), (_7_dt__update__tmp_h1).Dtor_keyring(), (_7_dt__update__tmp_h1).Dtor_cmm(), (_7_dt__update__tmp_h1).Dtor_legacyOverride(), (_7_dt__update__tmp_h1).Dtor_plaintextOverride())
	var _9_src m_SearchableEncryptionInfo.KeySource
	_ = _9_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _3_newVersion)
	_9_src = _out1
	var _10_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _10_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(_6_newConfig, _3_newVersion, _9_src)
	_10_valueOrError0 = _out2
	if !(!((_10_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(855,14): " + (_10_valueOrError0).String())
	}
	var _11_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _11_bv
	_11_bv = (_10_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	if !(((_11_bv).Dtor_beacons()).Contains(_dafny.SeqOfString("partOnly"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(856,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_11_bv).Dtor_beacons()).Get(_dafny.SeqOfString("partOnly")).(m_SearchableEncryptionInfo.Beacon)).Is_Standard()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(857,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _12_goodAttrs m_Wrappers.Result
	_ = _12_goodAttrs
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_11_bv).GenerateEncryptedBeacons(_0_MyItem, m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	_12_goodAttrs = _out3
	if (_12_goodAttrs).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_12_goodAttrs).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_12_goodAttrs).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(866,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_12_goodAttrs).Dtor_value().(_dafny.Map)).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_std2"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("51e1da"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_b_partOnly"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("51e1da"), _dafny.SeqOfString("39ef85"), _dafny.SeqOfString("3ff06a")))))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(867,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) GlobalPartNotExist() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_NotExist m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart
	_ = _1_NotExist
	_1_NotExist = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.SeqOfString("NotExist"), _dafny.SeqOfString("Q_"))
	var _2_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _2_dt__update__tmp_h0
	var _3_dt__update_hencryptedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_1_NotExist))
	_ = _3_dt__update_hencryptedParts_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_2_dt__update__tmp_h0).Dtor_version(), (_2_dt__update__tmp_h0).Dtor_keyStore(), (_2_dt__update__tmp_h0).Dtor_keySource(), (_2_dt__update__tmp_h0).Dtor_standardBeacons(), (_2_dt__update__tmp_h0).Dtor_compoundBeacons(), (_2_dt__update__tmp_h0).Dtor_virtualFields(), _3_dt__update_hencryptedParts_h0, (_2_dt__update__tmp_h0).Dtor_signedParts())
	var _4_src m_SearchableEncryptionInfo.KeySource
	_ = _4_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_4_src = _out1
	var _5_bv m_Wrappers.Result
	_ = _5_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _4_src)
	_5_bv = _out2
	if !((_5_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(881,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Global Parts List refers to standard beacon NotExist which is not configured.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(882,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) DuplicateGlobalSigned() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _1_dt__update__tmp_h0
	var _2_dt__update_hsignedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Year(), m_BeaconTestFixtures.Companion_Default___.Month(), m_BeaconTestFixtures.Companion_Default___.Year()))
	_ = _2_dt__update_hsignedParts_h0
	var _3_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_None_()
	_ = _3_dt__update_hcompoundBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_1_dt__update__tmp_h0).Dtor_version(), (_1_dt__update__tmp_h0).Dtor_keyStore(), (_1_dt__update__tmp_h0).Dtor_keySource(), (_1_dt__update__tmp_h0).Dtor_standardBeacons(), _3_dt__update_hcompoundBeacons_h0, (_1_dt__update__tmp_h0).Dtor_virtualFields(), (_1_dt__update__tmp_h0).Dtor_encryptedParts(), _2_dt__update_hsignedParts_h0)
	var _4_src m_SearchableEncryptionInfo.KeySource
	_ = _4_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_4_src = _out1
	var _5_bv m_Wrappers.Result
	_ = _5_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _4_src)
	_5_bv = _out2
	if !((_5_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(891,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Duplicate part name Year in Global Parts List.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(892,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) DuplicateGlobalEncrypted() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _1_dt__update__tmp_h0
	var _2_dt__update_hencryptedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Name(), m_BeaconTestFixtures.Companion_Default___.Title(), m_BeaconTestFixtures.Companion_Default___.Name()))
	_ = _2_dt__update_hencryptedParts_h0
	var _3_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_None_()
	_ = _3_dt__update_hcompoundBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_1_dt__update__tmp_h0).Dtor_version(), (_1_dt__update__tmp_h0).Dtor_keyStore(), (_1_dt__update__tmp_h0).Dtor_keySource(), (_1_dt__update__tmp_h0).Dtor_standardBeacons(), _3_dt__update_hcompoundBeacons_h0, (_1_dt__update__tmp_h0).Dtor_virtualFields(), _2_dt__update_hencryptedParts_h0, (_1_dt__update__tmp_h0).Dtor_signedParts())
	var _4_src m_SearchableEncryptionInfo.KeySource
	_ = _4_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_4_src = _out1
	var _5_bv m_Wrappers.Result
	_ = _5_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _4_src)
	_5_bv = _out2
	if !((_5_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(901,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Duplicate part name Name in Global Parts List.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(902,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) DuplicateGlobalPrefix() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_Std6 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart
	_ = _1_Std6
	_1_Std6 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_dafny.SeqOfString("std6"), _dafny.SeqOfString("N_"))
	var _2_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _2_dt__update__tmp_h0
	var _3_dt__update_hencryptedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Name(), m_BeaconTestFixtures.Companion_Default___.Title(), _1_Std6))
	_ = _3_dt__update_hencryptedParts_h0
	var _4_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_None_()
	_ = _4_dt__update_hcompoundBeacons_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_2_dt__update__tmp_h0).Dtor_version(), (_2_dt__update__tmp_h0).Dtor_keyStore(), (_2_dt__update__tmp_h0).Dtor_keySource(), (_2_dt__update__tmp_h0).Dtor_standardBeacons(), _4_dt__update_hcompoundBeacons_h0, (_2_dt__update__tmp_h0).Dtor_virtualFields(), _3_dt__update_hencryptedParts_h0, (_2_dt__update__tmp_h0).Dtor_signedParts())
	var _5_src m_SearchableEncryptionInfo.KeySource
	_ = _5_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_5_src = _out1
	var _6_bv m_Wrappers.Result
	_ = _6_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _5_src)
	_6_bv = _out2
	if !((_6_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(912,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Duplicate prefix N_ in Global Parts List.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(913,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) DuplicateGlobalVsLocalEncrypted() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _1_dt__update__tmp_h0
	var _2_dt__update_hencryptedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Name()))
	_ = _2_dt__update_hencryptedParts_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_1_dt__update__tmp_h0).Dtor_version(), (_1_dt__update__tmp_h0).Dtor_keyStore(), (_1_dt__update__tmp_h0).Dtor_keySource(), (_1_dt__update__tmp_h0).Dtor_standardBeacons(), (_1_dt__update__tmp_h0).Dtor_compoundBeacons(), (_1_dt__update__tmp_h0).Dtor_virtualFields(), _2_dt__update_hencryptedParts_h0, (_1_dt__update__tmp_h0).Dtor_signedParts())
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_3_src = _out1
	var _4_bv m_Wrappers.Result
	_ = _4_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _3_src)
	_4_bv = _out2
	if !((_4_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(922,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_4_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound beacon NameTitle defines encrypted part Name which is already defined as a global part.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(923,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) DuplicateGlobalVsLocalSigned() {
	var _0_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _0_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_0_version = _out0
	var _1_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _0_version
	_ = _1_dt__update__tmp_h0
	var _2_dt__update_hsignedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Month()))
	_ = _2_dt__update_hsignedParts_h0
	_0_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_1_dt__update__tmp_h0).Dtor_version(), (_1_dt__update__tmp_h0).Dtor_keyStore(), (_1_dt__update__tmp_h0).Dtor_keySource(), (_1_dt__update__tmp_h0).Dtor_standardBeacons(), (_1_dt__update__tmp_h0).Dtor_compoundBeacons(), (_1_dt__update__tmp_h0).Dtor_virtualFields(), (_1_dt__update__tmp_h0).Dtor_encryptedParts(), _2_dt__update_hsignedParts_h0)
	var _3_src m_SearchableEncryptionInfo.KeySource
	_ = _3_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _0_version)
	_3_src = _out1
	var _4_bv m_Wrappers.Result
	_ = _4_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _0_version, _3_src)
	_4_bv = _out2
	if !((_4_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(932,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_4_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound beacon Mixed defines signed part Month which is already defined as a global part.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(933,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) CompoundNoConstructor() {
	var _0_compoundDefault m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon
	_ = _0_compoundDefault
	_0_compoundDefault = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("compoundDefault"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _1_version
	_ = _2_dt__update__tmp_h0
	var _3_dt__update_hencryptedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Name(), m_BeaconTestFixtures.Companion_Default___.Title()))
	_ = _3_dt__update_hencryptedParts_h0
	var _4_dt__update_hsignedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Month()))
	_ = _4_dt__update_hsignedParts_h0
	var _5_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_0_compoundDefault))
	_ = _5_dt__update_hcompoundBeacons_h0
	_1_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_2_dt__update__tmp_h0).Dtor_version(), (_2_dt__update__tmp_h0).Dtor_keyStore(), (_2_dt__update__tmp_h0).Dtor_keySource(), (_2_dt__update__tmp_h0).Dtor_standardBeacons(), _5_dt__update_hcompoundBeacons_h0, (_2_dt__update__tmp_h0).Dtor_virtualFields(), _3_dt__update_hencryptedParts_h0, _4_dt__update_hsignedParts_h0)
	var _6_src m_SearchableEncryptionInfo.KeySource
	_ = _6_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_6_src = _out1
	var _7_bv m_Wrappers.Result
	_ = _7_bv
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _6_src)
	_7_bv = _out2
	if !((_7_bv).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(950,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_7_bv).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Compound beacon compoundDefault defines no constructors, and also no local parts. Cannot make a default constructor from global parts.")))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(951,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) CompoundMixed() {
	var _0_Mixed m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon
	_ = _0_Mixed
	_0_Mixed = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_dafny.SeqOfString("Mixed"), _dafny.SeqOfString("."), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Title())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Month())), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Constructor_.Create_Constructor_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.SeqOfString("Name"), true), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.SeqOfString("Year"), true))), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Constructor_.Create_Constructor_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.SeqOfString("Title"), true), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_dafny.SeqOfString("Month"), false))))))
	var _1_version m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _1_version
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
	_ = _out0
	_out0 = m_BeaconTestFixtures.Companion_Default___.GetLotsaBeacons()
	_1_version = _out0
	var _2_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion = _1_version
	_ = _2_dt__update__tmp_h0
	var _3_dt__update_hencryptedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Name()))
	_ = _3_dt__update_hencryptedParts_h0
	var _4_dt__update_hsignedParts_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(m_BeaconTestFixtures.Companion_Default___.Year()))
	_ = _4_dt__update_hsignedParts_h0
	var _5_dt__update_hcompoundBeacons_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_0_Mixed))
	_ = _5_dt__update_hcompoundBeacons_h0
	_1_version = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_((_2_dt__update__tmp_h0).Dtor_version(), (_2_dt__update__tmp_h0).Dtor_keyStore(), (_2_dt__update__tmp_h0).Dtor_keySource(), (_2_dt__update__tmp_h0).Dtor_standardBeacons(), _5_dt__update_hcompoundBeacons_h0, (_2_dt__update__tmp_h0).Dtor_virtualFields(), _3_dt__update_hencryptedParts_h0, _4_dt__update_hsignedParts_h0)
	var _6_src m_SearchableEncryptionInfo.KeySource
	_ = _6_src
	var _out1 m_SearchableEncryptionInfo.KeySource
	_ = _out1
	_out1 = m_BeaconTestFixtures.Companion_Default___.GetLiteralSource(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _1_version)
	_6_src = _out1
	var _7_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError0
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_SearchConfigToInfo.Companion_Default___.ConvertVersionWithSource(m_BeaconTestFixtures.Companion_Default___.FullTableConfig(), _1_version, _6_src)
	_7_valueOrError0 = _out2
	if !(!((_7_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(970,14): " + (_7_valueOrError0).String())
	}
	var _8_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _8_bv
	_8_bv = (_7_valueOrError0).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
}
func (_static *CompanionStruct_Default___) CheckBytesToHex() {
	var _0_bytes _dafny.Sequence
	_ = _0_bytes
	_0_bytes = _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(6), uint8(7), uint8(183))
	if !(_dafny.Companion_Sequence_.Equal(m_BaseBeacon.Companion_Default___.BytesToHex(_0_bytes, uint8(1)), _dafny.SeqOfString("1"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(979,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_BaseBeacon.Companion_Default___.BytesToHex(_0_bytes, uint8(2)), _dafny.SeqOfString("3"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(980,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_BaseBeacon.Companion_Default___.BytesToHex(_0_bytes, uint8(3)), _dafny.SeqOfString("7"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(981,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_BaseBeacon.Companion_Default___.BytesToHex(_0_bytes, uint8(4)), _dafny.SeqOfString("7"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(982,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_BaseBeacon.Companion_Default___.BytesToHex(_0_bytes, uint8(5)), _dafny.SeqOfString("17"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(983,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_BaseBeacon.Companion_Default___.BytesToHex(_0_bytes, uint8(6)), _dafny.SeqOfString("37"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(984,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_BaseBeacon.Companion_Default___.BytesToHex(_0_bytes, uint8(7)), _dafny.SeqOfString("37"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(985,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_BaseBeacon.Companion_Default___.BytesToHex(_0_bytes, uint8(8)), _dafny.SeqOfString("b7"))) {
		panic("dafny/DynamoDbEncryption/test/Beacon.dfy(986,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) X123() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(49), uint8(50), uint8(51))
	_ = _0_s
	return _0_s
}

// End of class Default__
