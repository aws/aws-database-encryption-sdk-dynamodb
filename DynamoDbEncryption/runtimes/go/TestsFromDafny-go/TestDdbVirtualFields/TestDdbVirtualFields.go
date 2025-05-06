// Package TestDdbVirtualFields
// Dafny module TestDdbVirtualFields compiled into Go

package TestDdbVirtualFields

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
	return "TestDdbVirtualFields.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) TestUpper() {
	var _0_t m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_t
	_0_t = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_upper_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Upper_.Create_Upper_())
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_t, _dafny.SeqOfString("")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(18,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_t, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfChars(65, 66, 67, 68, 241, 209, 69, 70))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(19,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestLower() {
	var _0_t m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_t
	_0_t = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_lower_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Lower_.Create_Lower_())
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_t, _dafny.SeqOfString("")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(23,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_t, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfChars(97, 98, 99, 100, 241, 209, 101, 102))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(24,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestInsert() {
	var _0_t m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_t
	_0_t = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_insert_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Insert_.Create_Insert_(_dafny.SeqOfString("_foo")))
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_t, _dafny.SeqOfString("")), _dafny.SeqOfString("_foo"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(28,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_t, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70, 95, 102, 111, 111))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(29,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestPrefix() {
	var _0_p0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_p0
	_0_p0 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_prefix_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetPrefix_.Create_GetPrefix_(int32(0)))
	var _1_p3 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _1_p3
	_1_p3 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_prefix_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetPrefix_.Create_GetPrefix_(int32(3)))
	var _2_pn3 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _2_pn3
	_2_pn3 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_prefix_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetPrefix_.Create_GetPrefix_(int32(-3)))
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfString("")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(35,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p3, _dafny.SeqOfString("")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(36,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn3, _dafny.SeqOfString("")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(37,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfString("a")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(38,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p3, _dafny.SeqOfString("a")), _dafny.SeqOfString("a"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(39,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn3, _dafny.SeqOfString("a")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(40,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfString("abc")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(41,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p3, _dafny.SeqOfString("abc")), _dafny.SeqOfString("abc"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(42,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn3, _dafny.SeqOfString("abc")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(43,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(44,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p3, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfString("aBc"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(45,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn3, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfChars(97, 66, 99, 68, 241))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(46,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSuffix() {
	var _0_p0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_p0
	_0_p0 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_suffix_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSuffix_.Create_GetSuffix_(int32(0)))
	var _1_p3 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _1_p3
	_1_p3 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_suffix_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSuffix_.Create_GetSuffix_(int32(3)))
	var _2_pn3 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _2_pn3
	_2_pn3 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_suffix_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSuffix_.Create_GetSuffix_(int32(-3)))
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfString("")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(52,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p3, _dafny.SeqOfString("")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(53,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn3, _dafny.SeqOfString("")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(54,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfString("a")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(55,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p3, _dafny.SeqOfString("a")), _dafny.SeqOfString("a"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(56,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn3, _dafny.SeqOfString("a")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(57,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfString("abc")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(58,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p3, _dafny.SeqOfString("abc")), _dafny.SeqOfString("abc"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(59,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn3, _dafny.SeqOfString("abc")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(60,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(61,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p3, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfChars(209, 101, 70))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(62,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn3, _dafny.SeqOfChars(97, 66, 99, 68, 241, 209, 101, 70)), _dafny.SeqOfChars(68, 241, 209, 101, 70))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(63,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSubstring() {
	var _0_p24 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_p24
	_0_p24 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_substring_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSubstring_.Create_GetSubstring_(int32(2), int32(4)))
	var _1_p42 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _1_p42
	_1_p42 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_substring_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSubstring_.Create_GetSubstring_(int32(4), int32(2)))
	var _2_p2n2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _2_p2n2
	_2_p2n2 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_substring_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSubstring_.Create_GetSubstring_(int32(2), int32(-2)))
	var _3_pn44 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _3_pn44
	_3_pn44 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_substring_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSubstring_.Create_GetSubstring_(int32(-4), int32(4)))
	var _4_pn4n2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _4_pn4n2
	_4_pn4n2 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_substring_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSubstring_.Create_GetSubstring_(int32(-4), int32(-2)))
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p24, _dafny.SeqOfString("abcdef")), _dafny.SeqOfString("cd"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(72,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p42, _dafny.SeqOfString("abcdef")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(73,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_p2n2, _dafny.SeqOfString("abcdef")), _dafny.SeqOfString("cd"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(74,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_3_pn44, _dafny.SeqOfString("abcdef")), _dafny.SeqOfString("cd"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(75,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_4_pn4n2, _dafny.SeqOfString("abcdef")), _dafny.SeqOfString("cd"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(76,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSegment() {
	var _0_p0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_p0
	_0_p0 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(0)))
	var _1_p1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _1_p1
	_1_p1 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(1)))
	var _2_p2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _2_p2
	_2_p2 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(2)))
	var _3_p3 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _3_p3
	_3_p3 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(3)))
	var _4_p4 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _4_p4
	_4_p4 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(4)))
	var _5_p5 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _5_p5
	_5_p5 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(5)))
	var _6_pn1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _6_pn1
	_6_pn1 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(-1)))
	var _7_pn2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _7_pn2
	_7_pn2 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(-2)))
	var _8_pn3 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _8_pn3
	_8_pn3 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(-3)))
	var _9_pn4 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _9_pn4
	_9_pn4 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(-4)))
	var _10_pn5 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _10_pn5
	_10_pn5 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(-5)))
	var _11_pn6 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _11_pn6
	_11_pn6 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_(_dafny.SeqOfString("."), int32(-6)))
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p0, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("1"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(92,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p1, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("23"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(93,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_p2, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("456"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(94,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_3_p3, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("7890"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(95,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_4_p4, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(96,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_5_p5, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(97,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_6_pn1, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("7890"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(98,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_7_pn2, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("456"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(99,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_8_pn3, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("23"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(100,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_9_pn4, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("1"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(101,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_10_pn5, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(102,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_11_pn6, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(103,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSegments() {
	var _0_p00 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_p00
	_0_p00 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segments_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegments_.Create_GetSegments_(_dafny.SeqOfString("."), int32(0), int32(0)))
	var _1_p12 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _1_p12
	_1_p12 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segments_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegments_.Create_GetSegments_(_dafny.SeqOfString("."), int32(1), int32(2)))
	var _2_pn32 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _2_pn32
	_2_pn32 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segments_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegments_.Create_GetSegments_(_dafny.SeqOfString("."), int32(-3), int32(2)))
	var _3_p13 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _3_p13
	_3_p13 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segments_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegments_.Create_GetSegments_(_dafny.SeqOfString("."), int32(1), int32(3)))
	var _4_p0n1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _4_p0n1
	_4_p0n1 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segments_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegments_.Create_GetSegments_(_dafny.SeqOfString("."), int32(0), int32(-1)))
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_0_p00, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString(""))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(112,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_1_p12, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("23"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(113,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_3_p13, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("23.456"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(114,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_2_pn32, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("23"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(115,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(m_DdbVirtualFields.Companion_Default___.DoTransform(_4_p0n1, _dafny.SeqOfString("1.23.456.7890")), _dafny.SeqOfString("1.23.456"))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(116,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestVirtualField() {
	var _0_lowTrans m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
	_ = _0_lowTrans
	_0_lowTrans = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_lower_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Lower_.Create_Lower_())
	var _1_part1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart
	_ = _1_part1
	_1_part1 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualPart_.Create_VirtualPart_(_dafny.SeqOfString("foo"), m_Wrappers.Companion_Option_.Create_None_())
	var _2_part2 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart
	_ = _2_part2
	_2_part2 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualPart_.Create_VirtualPart_(_dafny.SeqOfString("bar"), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(_0_lowTrans)))
	var _3_part3 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart
	_ = _3_part3
	_3_part3 = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualPart_.Create_VirtualPart_(_dafny.SeqOfString("baz[2].florn"), m_Wrappers.Companion_Option_.Create_None_())
	var _4_virtualField m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField
	_ = _4_virtualField
	_4_virtualField = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualField_.Create_VirtualField_(_dafny.SeqOfString("myField"), _dafny.SeqOf(_1_part1, _2_part2, _3_part3))
	var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DdbVirtualFields.Companion_VirtField_.Default())
	_ = _5_valueOrError0
	_5_valueOrError0 = m_DdbVirtualFields.Companion_Default___.ParseVirtualFieldConfig(_4_virtualField)
	if !(!((_5_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(124,21): " + (_5_valueOrError0).String())
	}
	var _6_virtField m_DdbVirtualFields.VirtField
	_ = _6_virtField
	_6_virtField = (_5_valueOrError0).Extract().(m_DdbVirtualFields.VirtField)
	var _7_fooString m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _7_fooString
	_7_fooString = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1.23"))
	var _8_barString m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _8_barString
	_8_barString = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("BarString"))
	var _9_flornString m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _9_flornString
	_9_flornString = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("FlornString"))
	var _10_flornMap m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _10_flornMap
	_10_flornMap = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("florn"), _9_flornString))
	var _11_bazList m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _11_bazList
	_11_bazList = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_7_fooString, _8_barString, _10_flornMap))
	var _12_item _dafny.Map
	_ = _12_item
	_12_item = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("foo"), _7_fooString).UpdateUnsafe(_dafny.SeqOfString("bar"), _8_barString).UpdateUnsafe(_dafny.SeqOfString("baz"), _11_bazList)
	var _13_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_Wrappers.Companion_Option_.Default())
	_ = _13_valueOrError1
	_13_valueOrError1 = m_DdbVirtualFields.Companion_Default___.GetVirtField(_6_virtField, _12_item)
	if !(!((_13_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(131,15): " + (_13_valueOrError1).String())
	}
	var _14_str m_Wrappers.Option
	_ = _14_str
	_14_str = (_13_valueOrError1).Extract().(m_Wrappers.Option)
	if !((_14_str).Equals(m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("1.23barstringFlornString")))) {
		panic("dafny/DynamoDbEncryption/test/Virtual.dfy(132,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}

// End of class Default__
