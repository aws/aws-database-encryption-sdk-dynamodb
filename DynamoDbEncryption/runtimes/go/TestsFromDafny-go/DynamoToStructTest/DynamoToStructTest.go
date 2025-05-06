// Package DynamoToStructTest
// Dafny module DynamoToStructTest compiled into Go

package DynamoToStructTest

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
	m_TestBaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestBaseBeacon"
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
var _ m_TestBaseBeacon.Dummy__

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
	return "DynamoToStructTest.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DoFail(data _dafny.Sequence, typeId _dafny.Sequence) {
	var _0_data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _0_data
	_0_data = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(data, typeId)
	var _1_result m_Wrappers.Result
	_ = _1_result
	_1_result = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_0_data)
	if !((_1_result).Is_Failure()) {
		_dafny.Print((_dafny.SeqOfString("\nStructuredToAttr should have failed with this data : ")).SetString())
		_dafny.Print(_0_data)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_1_result).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(24,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) DoSucceed(data _dafny.Sequence, typeId _dafny.Sequence, pos _dafny.Int) {
	var _0_data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _0_data
	_0_data = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(data, typeId)
	var _1_result m_Wrappers.Result
	_ = _1_result
	_1_result = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_0_data)
	if !((_1_result).Is_Success()) {
		_dafny.Print((_dafny.SeqOfString("\nUnexpected failure of StructuredToAttr : (")).SetString())
		_dafny.Print(pos)
		_dafny.Print((_dafny.SeqOfString(") : ")).SetString())
		_dafny.Print(_1_result)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_1_result).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(33,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestZeroBytes() {
	Companion_Default___.DoSucceed(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.NULL(), _dafny.One)
	Companion_Default___.DoSucceed(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.STRING(), _dafny.IntOfInt64(2))
	Companion_Default___.DoSucceed(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.NUMBER(), _dafny.IntOfInt64(3))
	Companion_Default___.DoSucceed(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.BINARY(), _dafny.IntOfInt64(4))
	Companion_Default___.DoFail(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.BOOLEAN())
	Companion_Default___.DoFail(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.STRING__SET())
	Companion_Default___.DoFail(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.NUMBER__SET())
	Companion_Default___.DoFail(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.BINARY__SET())
	Companion_Default___.DoFail(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.MAP())
	Companion_Default___.DoFail(_dafny.SeqOf(), m_StructuredEncryptionUtil.Companion_Default___.LIST())
}
func (_static *CompanionStruct_Default___) TestBadType() {
	Companion_Default___.DoSucceed(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0)), m_StructuredEncryptionUtil.Companion_Default___.LIST(), _dafny.IntOfInt64(5))
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(3), uint8(1), uint8(0), uint8(0), uint8(0), uint8(0)), m_StructuredEncryptionUtil.Companion_Default___.LIST())
}
func (_static *CompanionStruct_Default___) TestBadLengthList() {
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(2), uint8(1)), m_StructuredEncryptionUtil.Companion_Default___.LIST())
	Companion_Default___.DoSucceed(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(2), uint8(1), uint8(2)), m_StructuredEncryptionUtil.Companion_Default___.LIST(), _dafny.IntOfInt64(6))
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(2), uint8(1), uint8(2), uint8(3)), m_StructuredEncryptionUtil.Companion_Default___.LIST())
}
func (_static *CompanionStruct_Default___) TestBadLengthMap() {
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), Companion_Default___.K(), Companion_Default___.E(), Companion_Default___.Y(), Companion_Default___.A(), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4)), m_StructuredEncryptionUtil.Companion_Default___.MAP())
	Companion_Default___.DoSucceed(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), Companion_Default___.K(), Companion_Default___.E(), Companion_Default___.Y(), Companion_Default___.A(), uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), m_StructuredEncryptionUtil.Companion_Default___.MAP(), _dafny.IntOfInt64(7))
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), Companion_Default___.K(), Companion_Default___.E(), Companion_Default___.Y(), Companion_Default___.A(), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(6)), m_StructuredEncryptionUtil.Companion_Default___.MAP())
}
func (_static *CompanionStruct_Default___) TestBadDupKeys() {
	Companion_Default___.DoSucceed(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), Companion_Default___.K(), Companion_Default___.E(), Companion_Default___.Y(), Companion_Default___.A(), uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), Companion_Default___.K(), Companion_Default___.E(), Companion_Default___.Y(), Companion_Default___.B(), uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), m_StructuredEncryptionUtil.Companion_Default___.MAP(), _dafny.IntOfInt64(8))
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), Companion_Default___.K(), Companion_Default___.E(), Companion_Default___.Y(), Companion_Default___.A(), uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), Companion_Default___.K(), Companion_Default___.E(), Companion_Default___.Y(), Companion_Default___.A(), uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), m_StructuredEncryptionUtil.Companion_Default___.MAP())
	Companion_Default___.DoSucceed(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51), uint8(0), uint8(0), uint8(0), uint8(3), uint8(52), uint8(53), uint8(54)), m_StructuredEncryptionUtil.Companion_Default___.BINARY__SET(), _dafny.IntOfInt64(9))
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51)), m_StructuredEncryptionUtil.Companion_Default___.BINARY__SET())
	Companion_Default___.DoSucceed(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51), uint8(0), uint8(0), uint8(0), uint8(3), uint8(52), uint8(53), uint8(54)), m_StructuredEncryptionUtil.Companion_Default___.NUMBER__SET(), _dafny.IntOfInt64(10))
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51)), m_StructuredEncryptionUtil.Companion_Default___.NUMBER__SET())
	Companion_Default___.DoSucceed(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51), uint8(0), uint8(0), uint8(0), uint8(3), uint8(52), uint8(53), uint8(54)), m_StructuredEncryptionUtil.Companion_Default___.STRING__SET(), _dafny.IntOfInt64(11))
	Companion_Default___.DoFail(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51)), m_StructuredEncryptionUtil.Companion_Default___.STRING__SET())
}
func (_static *CompanionStruct_Default___) TestEncode2() {
	var _0_stringValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_stringValue
	_0_stringValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("abc"))
	var _1_encodedStringData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _1_encodedStringData
	_1_encodedStringData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(97), uint8(98), uint8(99)), _dafny.SeqOf(uint8(0), uint8(1)))
	var _2_stringStruct m_Wrappers.Result
	_ = _2_stringStruct
	_2_stringStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_0_stringValue)
	if !((_2_stringStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(100,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_stringStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_1_encodedStringData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(101,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newStringValue m_Wrappers.Result
	_ = _3_newStringValue
	_3_newStringValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_1_encodedStringData)
	if !((_3_newStringValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(104,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_newStringValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_0_stringValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(105,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _4_numberValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _4_numberValue
	_4_numberValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("123"))
	var _5_encodedNumberData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _5_encodedNumberData
	_5_encodedNumberData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(49), uint8(50), uint8(51)), _dafny.SeqOf(uint8(0), uint8(2)))
	var _6_numberStruct m_Wrappers.Result
	_ = _6_numberStruct
	_6_numberStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_4_numberValue)
	if !((_6_numberStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(110,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_numberStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_5_encodedNumberData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(111,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_newNumberValue m_Wrappers.Result
	_ = _7_newNumberValue
	_7_newNumberValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_5_encodedNumberData)
	if !((_7_newNumberValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(114,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_7_newNumberValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_4_numberValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(115,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_numberSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _8_numberSetValue
	_8_numberSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("123"), _dafny.SeqOfString("45")))
	var _9_encodedNumberSetData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _9_encodedNumberSetData
	_9_encodedNumberSetData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(49), uint8(50), uint8(51), uint8(0), uint8(0), uint8(0), uint8(2), uint8(52), uint8(53)), _dafny.SeqOf(uint8(1), uint8(2)))
	var _10_numberSetStruct m_Wrappers.Result
	_ = _10_numberSetStruct
	_10_numberSetStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_8_numberSetValue)
	if !((_10_numberSetStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(120,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_10_numberSetStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_9_encodedNumberSetData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(121,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _11_newNumberSetValue m_Wrappers.Result
	_ = _11_newNumberSetValue
	_11_newNumberSetValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_9_encodedNumberSetData)
	if !((_11_newNumberSetValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(124,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_11_newNumberSetValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_8_numberSetValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(125,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _12_stringSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _12_stringSetValue
	_12_stringSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("abc"), _dafny.SeqOfString("de")))
	var _13_encodedStringSetData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _13_encodedStringSetData
	_13_encodedStringSetData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(97), uint8(98), uint8(99), uint8(0), uint8(0), uint8(0), uint8(2), uint8(100), uint8(101)), _dafny.SeqOf(uint8(1), uint8(1)))
	var _14_stringSetStruct m_Wrappers.Result
	_ = _14_stringSetStruct
	_14_stringSetStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_12_stringSetValue)
	if !((_14_stringSetStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(130,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_14_stringSetStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_13_encodedStringSetData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(131,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _15_newStringSetValue m_Wrappers.Result
	_ = _15_newStringSetValue
	_15_newStringSetValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_13_encodedStringSetData)
	if !((_15_newStringSetValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(134,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_15_newStringSetValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_12_stringSetValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(135,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _16_binarySetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _16_binarySetValue
	_16_binarySetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf(_dafny.SeqOf(uint8(1), uint8(2), uint8(3)), _dafny.SeqOf(uint8(4), uint8(5))))
	var _17_encodedBinarySetData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _17_encodedBinarySetData
	_17_encodedBinarySetData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(3), uint8(1), uint8(2), uint8(3), uint8(0), uint8(0), uint8(0), uint8(2), uint8(4), uint8(5)), _dafny.SeqOf(uint8(1), uint8(255)))
	var _18_binarySetStruct m_Wrappers.Result
	_ = _18_binarySetStruct
	_18_binarySetStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_16_binarySetValue)
	if !((_18_binarySetStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(140,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_18_binarySetStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_17_encodedBinarySetData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(141,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _19_newBinarySetValue m_Wrappers.Result
	_ = _19_newBinarySetValue
	_19_newBinarySetValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_17_encodedBinarySetData)
	if !((_19_newBinarySetValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(144,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_19_newBinarySetValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_16_binarySetValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(145,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestEncode() {
	var _0_binaryValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_binaryValue
	_0_binaryValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)))
	var _1_encodedBinaryData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _1_encodedBinaryData
	_1_encodedBinaryData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOf(uint8(255), uint8(255)))
	var _2_binaryStruct m_Wrappers.Result
	_ = _2_binaryStruct
	_2_binaryStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_0_binaryValue)
	if !((_2_binaryStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(152,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_binaryStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_1_encodedBinaryData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(153,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newBinaryValue m_Wrappers.Result
	_ = _3_newBinaryValue
	_3_newBinaryValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_1_encodedBinaryData)
	if !((_3_newBinaryValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(156,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_newBinaryValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_0_binaryValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(157,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _4_nullValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _4_nullValue
	_4_nullValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)
	var _5_encodedNullData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _5_encodedNullData
	_5_encodedNullData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(), _dafny.SeqOf(uint8(0), uint8(0)))
	var _6_nullStruct m_Wrappers.Result
	_ = _6_nullStruct
	_6_nullStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_4_nullValue)
	if !((_6_nullStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(162,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_nullStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_5_encodedNullData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(163,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_newNullValue m_Wrappers.Result
	_ = _7_newNullValue
	_7_newNullValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_6_nullStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_7_newNullValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(166,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_7_newNullValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_4_nullValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(167,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_boolValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _8_boolValue
	_8_boolValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(false)
	var _9_encodedBoolData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _9_encodedBoolData
	_9_encodedBoolData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0)), _dafny.SeqOf(uint8(0), uint8(4)))
	var _10_boolStruct m_Wrappers.Result
	_ = _10_boolStruct
	_10_boolStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_8_boolValue)
	if !((_10_boolStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(172,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_10_boolStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_9_encodedBoolData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(173,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _11_newBoolValue m_Wrappers.Result
	_ = _11_newBoolValue
	_11_newBoolValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_10_boolStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_11_newBoolValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(176,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_11_newBoolValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_8_boolValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(177,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _12_listValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _12_listValue
	_12_listValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_0_binaryValue, _4_nullValue, _8_boolValue))
	var _13_encodedListData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _13_encodedListData
	_13_encodedListData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(3), uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(4), uint8(0), uint8(0), uint8(0), uint8(1), uint8(0)), _dafny.SeqOf(uint8(3), uint8(0)))
	var _14_listStruct m_Wrappers.Result
	_ = _14_listStruct
	_14_listStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_12_listValue)
	if !((_14_listStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(210,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_14_listStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_13_encodedListData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(211,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _15_newListValue m_Wrappers.Result
	_ = _15_newListValue
	_15_newListValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_14_listStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_15_newListValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(214,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_15_newListValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_12_listValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(215,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _16_mapValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _16_mapValue
	_16_mapValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("keyA"), _0_binaryValue).UpdateUnsafe(_dafny.SeqOfString("keyB"), _4_nullValue).UpdateUnsafe(_dafny.SeqOfString("keyC"), _8_boolValue).UpdateUnsafe(_dafny.SeqOfString("keyD"), _12_listValue))
	var _17_k uint8
	_ = _17_k
	_17_k = uint8(_dafny.Char('k'))
	var _18_e uint8
	_ = _18_e
	_18_e = uint8(_dafny.Char('e'))
	var _19_y uint8
	_ = _19_y
	_19_y = uint8(_dafny.Char('y'))
	var _20_A uint8
	_ = _20_A
	_20_A = uint8(_dafny.Char('A'))
	var _21_B uint8
	_ = _21_B
	_21_B = uint8(_dafny.Char('B'))
	var _22_C uint8
	_ = _22_C
	_22_C = uint8(_dafny.Char('C'))
	var _23_D uint8
	_ = _23_D
	_23_D = uint8(_dafny.Char('D'))
	var _24_encodedMapData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _24_encodedMapData
	_24_encodedMapData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(4), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), _17_k, _18_e, _19_y, _20_A, uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), _17_k, _18_e, _19_y, _21_B, uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), _17_k, _18_e, _19_y, _22_C, uint8(0), uint8(4), uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), _17_k, _18_e, _19_y, _23_D, uint8(3), uint8(0), uint8(0), uint8(0), uint8(0), uint8(28), uint8(0), uint8(0), uint8(0), uint8(3), uint8(255), uint8(255), uint8(0), uint8(0), uint8(0), uint8(5), uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(4), uint8(0), uint8(0), uint8(0), uint8(1), uint8(0)), _dafny.SeqOf(uint8(2), uint8(0)))
	var _25_mapStruct m_Wrappers.Result
	_ = _25_mapStruct
	_25_mapStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_16_mapValue)
	if !((_25_mapStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(266,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_25_mapStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_24_encodedMapData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(267,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _26_newMapValue m_Wrappers.Result
	_ = _26_newMapValue
	_26_newMapValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_25_mapStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_26_newMapValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(270,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_26_newMapValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_16_mapValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(271,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestNormalizeNAttr() {
	var _0_numberValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_numberValue
	_0_numberValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("000123.000"))
	var _1_encodedNumberData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _1_encodedNumberData
	_1_encodedNumberData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(49), uint8(50), uint8(51)), _dafny.SeqOf(uint8(0), uint8(2)))
	var _2_numberStruct m_Wrappers.Result
	_ = _2_numberStruct
	_2_numberStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_0_numberValue)
	if !((_2_numberStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(278,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_numberStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_1_encodedNumberData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(279,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newNumberValue m_Wrappers.Result
	_ = _3_newNumberValue
	_3_newNumberValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_1_encodedNumberData)
	if !((_3_newNumberValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(282,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_newNumberValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("123")))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(283,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestNormalizeNInSet() {
	var _0_numberSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_numberSetValue
	_0_numberSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("001.00")))
	var _1_encodedNumberSetData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _1_encodedNumberSetData
	_1_encodedNumberSetData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(1), uint8(49)), _dafny.SeqOf(uint8(1), uint8(2)))
	var _2_numberSetStruct m_Wrappers.Result
	_ = _2_numberSetStruct
	_2_numberSetStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_0_numberSetValue)
	if !((_2_numberSetStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(290,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_numberSetStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_1_encodedNumberSetData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(291,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newNumberSetValue m_Wrappers.Result
	_ = _3_newNumberSetValue
	_3_newNumberSetValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_1_encodedNumberSetData)
	if !((_3_newNumberSetValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(294,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_newNumberSetValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("1"))))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(295,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestNormalizeNInList() {
	var _0_nValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_nValue
	_0_nValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("001.00"))
	var _1_normalizedNValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _1_normalizedNValue
	_1_normalizedNValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1"))
	var _2_listValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _2_listValue
	_2_listValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_0_nValue))
	var _3_encodedListData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _3_encodedListData
	_3_encodedListData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(1), uint8(49)), _dafny.SeqOf(uint8(3), uint8(0)))
	var _4_listStruct m_Wrappers.Result
	_ = _4_listStruct
	_4_listStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_2_listValue)
	if !((_4_listStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(309,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_4_listStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_3_encodedListData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(310,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _5_newListValue m_Wrappers.Result
	_ = _5_newListValue
	_5_newListValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_4_listStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_5_newListValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(313,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_newListValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_1_normalizedNValue)))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(314,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestNormalizeNInMap() {
	var _0_nValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_nValue
	_0_nValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("001.00"))
	var _1_normalizedNValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _1_normalizedNValue
	_1_normalizedNValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1"))
	var _2_mapValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _2_mapValue
	_2_mapValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("keyA"), _0_nValue))
	var _3_k uint8
	_ = _3_k
	_3_k = uint8(_dafny.Char('k'))
	var _4_e uint8
	_ = _4_e
	_4_e = uint8(_dafny.Char('e'))
	var _5_y uint8
	_ = _5_y
	_5_y = uint8(_dafny.Char('y'))
	var _6_A uint8
	_ = _6_A
	_6_A = uint8(_dafny.Char('A'))
	var _7_encodedMapData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _7_encodedMapData
	_7_encodedMapData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), _3_k, _4_e, _5_y, _6_A, uint8(0), uint8(2), uint8(0), uint8(0), uint8(0), uint8(1), uint8(49)), _dafny.SeqOf(uint8(2), uint8(0)))
	var _8_mapStruct m_Wrappers.Result
	_ = _8_mapStruct
	_8_mapStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_2_mapValue)
	if !((_8_mapStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(337,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_8_mapStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_7_encodedMapData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(338,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _9_newMapValue m_Wrappers.Result
	_ = _9_newMapValue
	_9_newMapValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_8_mapStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_9_newMapValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(341,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_9_newMapValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("keyA"), _1_normalizedNValue)))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(342,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSortNSAttr() {
	var _0_numberSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_numberSetValue
	_0_numberSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("1"), _dafny.SeqOfString("2"), _dafny.SeqOfString("10")))
	var _1_encodedNumberSetData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _1_encodedNumberSetData
	_1_encodedNumberSetData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(49), uint8(0), uint8(0), uint8(0), uint8(2), uint8(49), uint8(48), uint8(0), uint8(0), uint8(0), uint8(1), uint8(50)), _dafny.SeqOf(uint8(1), uint8(2)))
	var _2_numberSetStruct m_Wrappers.Result
	_ = _2_numberSetStruct
	_2_numberSetStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_0_numberSetValue)
	if !((_2_numberSetStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(352,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_numberSetStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_1_encodedNumberSetData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(353,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newNumberSetValue m_Wrappers.Result
	_ = _3_newNumberSetValue
	_3_newNumberSetValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_1_encodedNumberSetData)
	if !((_3_newNumberSetValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(356,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_newNumberSetValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("1"), _dafny.SeqOfString("10"), _dafny.SeqOfString("2"))))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(357,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSortNSAfterNormalize() {
	var _0_numberSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_numberSetValue
	_0_numberSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("1"), _dafny.SeqOfString("02"), _dafny.SeqOfString("10")))
	var _1_encodedNumberSetData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _1_encodedNumberSetData
	_1_encodedNumberSetData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(49), uint8(0), uint8(0), uint8(0), uint8(2), uint8(49), uint8(48), uint8(0), uint8(0), uint8(0), uint8(1), uint8(50)), _dafny.SeqOf(uint8(1), uint8(2)))
	var _2_numberSetStruct m_Wrappers.Result
	_ = _2_numberSetStruct
	_2_numberSetStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_0_numberSetValue)
	if !((_2_numberSetStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(367,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_numberSetStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_1_encodedNumberSetData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(368,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newNumberSetValue m_Wrappers.Result
	_ = _3_newNumberSetValue
	_3_newNumberSetValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_1_encodedNumberSetData)
	if !((_3_newNumberSetValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(371,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_newNumberSetValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("1"), _dafny.SeqOfString("10"), _dafny.SeqOfString("2"))))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(372,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSortSSAttr() {
	var _0_stringSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_stringSetValue
	_0_stringSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("&"), _dafny.SeqOfChars(65377), _dafny.SeqOfChars(55296, 56322)))
	var _1_encodedStringSetData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _1_encodedStringSetData
	_1_encodedStringSetData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(38), uint8(0), uint8(0), uint8(0), uint8(4), uint8(240), uint8(144), uint8(128), uint8(130), uint8(0), uint8(0), uint8(0), uint8(3), uint8(239), uint8(189), uint8(161)), _dafny.SeqOf(uint8(1), uint8(1)))
	var _2_stringSetStruct m_Wrappers.Result
	_ = _2_stringSetStruct
	_2_stringSetStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_0_stringSetValue)
	if !((_2_stringSetStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(393,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_stringSetStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_1_encodedStringSetData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(394,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newStringSetValue m_Wrappers.Result
	_ = _3_newStringSetValue
	_3_newStringSetValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_1_encodedStringSetData)
	if !((_3_newStringSetValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(397,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_newStringSetValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("&"), _dafny.SeqOfChars(55296, 56322), _dafny.SeqOfChars(65377))))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(398,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSortBSAttr() {
	var _0_binarySetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_binarySetValue
	_0_binarySetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf(_dafny.SeqOf(uint8(1)), _dafny.SeqOf(uint8(2)), _dafny.SeqOf(uint8(1), uint8(0))))
	var _1_encodedBinarySetData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _1_encodedBinarySetData
	_1_encodedBinarySetData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(1), uint8(0), uint8(0), uint8(0), uint8(2), uint8(1), uint8(0), uint8(0), uint8(0), uint8(0), uint8(1), uint8(2)), _dafny.SeqOf(uint8(1), uint8(255)))
	var _2_binarySetStruct m_Wrappers.Result
	_ = _2_binarySetStruct
	_2_binarySetStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_0_binarySetValue)
	if !((_2_binarySetStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(408,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_binarySetStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_1_encodedBinarySetData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(409,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_newBinarySetValue m_Wrappers.Result
	_ = _3_newBinarySetValue
	_3_newBinarySetValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr(_1_encodedBinarySetData)
	if !((_3_newBinarySetValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(412,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_newBinarySetValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf(_dafny.SeqOf(uint8(1)), _dafny.SeqOf(uint8(1), uint8(0)), _dafny.SeqOf(uint8(2)))))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(413,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSetsInListAreSorted() {
	var _0_nSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_nSetValue
	_0_nSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("2"), _dafny.SeqOfString("1"), _dafny.SeqOfString("10")))
	var _1_sSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _1_sSetValue
	_1_sSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("&"), _dafny.SeqOfChars(65377), _dafny.SeqOfChars(55296, 56322)))
	var _2_bSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _2_bSetValue
	_2_bSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf(_dafny.SeqOf(uint8(1), uint8(0)), _dafny.SeqOf(uint8(1)), _dafny.SeqOf(uint8(2))))
	var _3_sortedNSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _3_sortedNSetValue
	_3_sortedNSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("1"), _dafny.SeqOfString("10"), _dafny.SeqOfString("2")))
	var _4_sortedSSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _4_sortedSSetValue
	_4_sortedSSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("&"), _dafny.SeqOfChars(55296, 56322), _dafny.SeqOfChars(65377)))
	var _5_sortedBSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _5_sortedBSetValue
	_5_sortedBSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf(_dafny.SeqOf(uint8(1)), _dafny.SeqOf(uint8(1), uint8(0)), _dafny.SeqOf(uint8(2))))
	var _6_listValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _6_listValue
	_6_listValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_0_nSetValue, _1_sSetValue, _2_bSetValue))
	var _7_encodedListData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _7_encodedListData
	_7_encodedListData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(3), uint8(1), uint8(2), uint8(0), uint8(0), uint8(0), uint8(20), uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(49), uint8(0), uint8(0), uint8(0), uint8(2), uint8(49), uint8(48), uint8(0), uint8(0), uint8(0), uint8(1), uint8(50), uint8(1), uint8(1), uint8(0), uint8(0), uint8(0), uint8(24), uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(38), uint8(0), uint8(0), uint8(0), uint8(4), uint8(240), uint8(144), uint8(128), uint8(130), uint8(0), uint8(0), uint8(0), uint8(3), uint8(239), uint8(189), uint8(161), uint8(1), uint8(255), uint8(0), uint8(0), uint8(0), uint8(20), uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(1), uint8(0), uint8(0), uint8(0), uint8(2), uint8(1), uint8(0), uint8(0), uint8(0), uint8(0), uint8(1), uint8(2)), _dafny.SeqOf(uint8(3), uint8(0)))
	var _8_listStruct m_Wrappers.Result
	_ = _8_listStruct
	_8_listStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_6_listValue)
	if !((_8_listStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(437,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_8_listStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_7_encodedListData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(438,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _9_newListValue m_Wrappers.Result
	_ = _9_newListValue
	_9_newListValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_8_listStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_9_newListValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(441,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_9_newListValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_3_sortedNSetValue, _4_sortedSSetValue, _5_sortedBSetValue)))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(442,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSetsInMapAreSorted() {
	var _0_nSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_nSetValue
	_0_nSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("2"), _dafny.SeqOfString("1"), _dafny.SeqOfString("10")))
	var _1_sSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _1_sSetValue
	_1_sSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("&"), _dafny.SeqOfChars(65377), _dafny.SeqOfChars(55296, 56322)))
	var _2_bSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _2_bSetValue
	_2_bSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf(_dafny.SeqOf(uint8(1), uint8(0)), _dafny.SeqOf(uint8(1)), _dafny.SeqOf(uint8(2))))
	var _3_sortedNSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _3_sortedNSetValue
	_3_sortedNSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("1"), _dafny.SeqOfString("10"), _dafny.SeqOfString("2")))
	var _4_sortedSSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _4_sortedSSetValue
	_4_sortedSSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("&"), _dafny.SeqOfChars(55296, 56322), _dafny.SeqOfChars(65377)))
	var _5_sortedBSetValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _5_sortedBSetValue
	_5_sortedBSetValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf(_dafny.SeqOf(uint8(1)), _dafny.SeqOf(uint8(1), uint8(0)), _dafny.SeqOf(uint8(2))))
	var _6_mapValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _6_mapValue
	_6_mapValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("keyA"), _1_sSetValue).UpdateUnsafe(_dafny.SeqOfString("keyB"), _0_nSetValue).UpdateUnsafe(_dafny.SeqOfString("keyC"), _2_bSetValue))
	var _7_k uint8
	_ = _7_k
	_7_k = uint8(_dafny.Char('k'))
	var _8_e uint8
	_ = _8_e
	_8_e = uint8(_dafny.Char('e'))
	var _9_y uint8
	_ = _9_y
	_9_y = uint8(_dafny.Char('y'))
	var _10_A uint8
	_ = _10_A
	_10_A = uint8(_dafny.Char('A'))
	var _11_B uint8
	_ = _11_B
	_11_B = uint8(_dafny.Char('B'))
	var _12_C uint8
	_ = _12_C
	_12_C = uint8(_dafny.Char('C'))
	var _13_encodedMapData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _13_encodedMapData
	_13_encodedMapData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), _7_k, _8_e, _9_y, _10_A, uint8(1), uint8(1), uint8(0), uint8(0), uint8(0), uint8(24), uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(38), uint8(0), uint8(0), uint8(0), uint8(4), uint8(240), uint8(144), uint8(128), uint8(130), uint8(0), uint8(0), uint8(0), uint8(3), uint8(239), uint8(189), uint8(161), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), _7_k, _8_e, _9_y, _11_B, uint8(1), uint8(2), uint8(0), uint8(0), uint8(0), uint8(20), uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(49), uint8(0), uint8(0), uint8(0), uint8(2), uint8(49), uint8(48), uint8(0), uint8(0), uint8(0), uint8(1), uint8(50), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), _7_k, _8_e, _9_y, _12_C, uint8(1), uint8(255), uint8(0), uint8(0), uint8(0), uint8(20), uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(0), uint8(0), uint8(1), uint8(1), uint8(0), uint8(0), uint8(0), uint8(2), uint8(1), uint8(0), uint8(0), uint8(0), uint8(0), uint8(1), uint8(2)), _dafny.SeqOf(uint8(2), uint8(0)))
	var _14_mapStruct m_Wrappers.Result
	_ = _14_mapStruct
	_14_mapStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_6_mapValue)
	if !((_14_mapStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(478,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_14_mapStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_13_encodedMapData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(479,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _15_newMapValue m_Wrappers.Result
	_ = _15_newMapValue
	_15_newMapValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_14_mapStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_15_newMapValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(482,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_15_newMapValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("keyA"), _4_sortedSSetValue).UpdateUnsafe(_dafny.SeqOfString("keyB"), _3_sortedNSetValue).UpdateUnsafe(_dafny.SeqOfString("keyC"), _5_sortedBSetValue)))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(483,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestSortMapKeys() {
	var _0_nullValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_nullValue
	_0_nullValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)
	var _1_mapValue m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _1_mapValue
	_1_mapValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("&"), _0_nullValue).UpdateUnsafe(_dafny.SeqOfChars(65377), _0_nullValue).UpdateUnsafe(_dafny.SeqOfChars(55296, 56322), _0_nullValue))
	var _2_encodedMapData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _2_encodedMapData
	_2_encodedMapData = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.SeqOf(uint8(0), uint8(0), uint8(0), uint8(3), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(1), uint8(38), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(4), uint8(240), uint8(144), uint8(128), uint8(130), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(1), uint8(0), uint8(0), uint8(0), uint8(3), uint8(239), uint8(189), uint8(161), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0), uint8(0)), _dafny.SeqOf(uint8(2), uint8(0)))
	var _3_mapStruct m_Wrappers.Result
	_ = _3_mapStruct
	_3_mapStruct = m_DynamoToStruct.Companion_Default___.AttrToStructured(_1_mapValue)
	if !((_3_mapStruct).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(511,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_mapStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)).Equals(_2_encodedMapData)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(512,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _4_newMapValue m_Wrappers.Result
	_ = _4_newMapValue
	_4_newMapValue = m_DynamoToStruct.Companion_Default___.StructuredToAttr((_3_mapStruct).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
	if !((_4_newMapValue).Is_Success()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(515,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_4_newMapValue).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(_1_mapValue)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(516,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestRoundTrip() {
	var _0_val1 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_val1
	_0_val1 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("astring"))
	var _1_val2 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _1_val2
	_1_val2 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("12345"))
	var _2_val3 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _2_val3
	_2_val3 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)))
	var _3_val4 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _3_val4
	_3_val4 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(true)
	var _4_val5 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _4_val5
	_4_val5 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)
	var _5_val6 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _5_val6
	_5_val6 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOf(uint8(2), uint8(3), uint8(4), uint8(5), uint8(6)), _dafny.SeqOf(uint8(3), uint8(4), uint8(5), uint8(6), uint8(7))))
	var _6_val7 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _6_val7
	_6_val7 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf(_dafny.SeqOfString("ab"), _dafny.SeqOfString("cdef"), _dafny.SeqOfString("ghijk")))
	var _7_val8 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _7_val8
	_7_val8 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf(_dafny.SeqOfString("0"), _dafny.SeqOfString("1"), _dafny.SeqOfString("234.567")))
	var _8_val9a m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _8_val9a
	_8_val9a = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_7_val8, _6_val7, _5_val6))
	var _9_val9b m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _9_val9b
	_9_val9b = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_4_val5, _3_val4, _2_val3))
	var _10_val9c m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _10_val9c
	_10_val9c = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_1_val2, _0_val1))
	var _11_val9 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _11_val9
	_11_val9 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_8_val9a, _9_val9b, _10_val9c))
	var _12_val10 m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _12_val10
	_12_val10 = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("key1"), _0_val1).UpdateUnsafe(_dafny.SeqOfString("key2"), _1_val2).UpdateUnsafe(_dafny.SeqOfString("key3"), _2_val3).UpdateUnsafe(_dafny.SeqOfString("key4"), _3_val4).UpdateUnsafe(_dafny.SeqOfString("key5"), _4_val5).UpdateUnsafe(_dafny.SeqOfString("key6"), _5_val6).UpdateUnsafe(_dafny.SeqOfString("key7"), _6_val7).UpdateUnsafe(_dafny.SeqOfString("key8"), _7_val8).UpdateUnsafe(_dafny.SeqOfString("key9"), _11_val9))
	var _13_attrMap _dafny.Map
	_ = _13_attrMap
	_13_attrMap = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("key1"), _0_val1).UpdateUnsafe(_dafny.SeqOfString("key2"), _1_val2).UpdateUnsafe(_dafny.SeqOfString("key3"), _2_val3).UpdateUnsafe(_dafny.SeqOfString("key4"), _3_val4).UpdateUnsafe(_dafny.SeqOfString("key5"), _4_val5).UpdateUnsafe(_dafny.SeqOfString("key6"), _5_val6).UpdateUnsafe(_dafny.SeqOfString("key7"), _6_val7).UpdateUnsafe(_dafny.SeqOfString("key8"), _7_val8).UpdateUnsafe(_dafny.SeqOfString("key9"), _11_val9).UpdateUnsafe(_dafny.SeqOfString("key10"), _12_val10)
	var _14_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _14_valueOrError0
	_14_valueOrError0 = m_DynamoToStruct.Companion_Default___.ItemToStructured(_13_attrMap)
	if !(!((_14_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(537,18): " + (_14_valueOrError0).String())
	}
	var _15_struct _dafny.Map
	_ = _15_struct
	_15_struct = (_14_valueOrError0).Extract().(_dafny.Map)
	var _16_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _16_valueOrError1
	_16_valueOrError1 = m_DynamoToStruct.Companion_Default___.StructuredToItem(_15_struct)
	if !(!((_16_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(538,20): " + (_16_valueOrError1).String())
	}
	var _17_nAttrMap _dafny.Map
	_ = _17_nAttrMap
	_17_nAttrMap = (_16_valueOrError1).Extract().(_dafny.Map)
	if !((_13_attrMap).Equals(_17_nAttrMap)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(539,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestMaxDepth() {
	var _0_value m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_value
	_0_value = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("hello"))
	var _hi0 uint64 = (m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH()) - (func() uint64 { return (uint64(1)) })()
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		if ((_1_i) % (uint64(2))) == (uint64(0)) {
			_0_value = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("key"), _0_value))
		} else {
			_0_value = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_0_value))
		}
	}
	var _2_attrMap _dafny.Map
	_ = _2_attrMap
	_2_attrMap = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("key1"), _0_value)
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _3_valueOrError0
	_3_valueOrError0 = m_DynamoToStruct.Companion_Default___.ItemToStructured(_2_attrMap)
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(552,18): " + (_3_valueOrError0).String())
	}
	var _4_struct _dafny.Map
	_ = _4_struct
	_4_struct = (_3_valueOrError0).Extract().(_dafny.Map)
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _5_valueOrError1
	_5_valueOrError1 = m_DynamoToStruct.Companion_Default___.StructuredToItem(_4_struct)
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(553,20): " + (_5_valueOrError1).String())
	}
	var _6_nAttrMap _dafny.Map
	_ = _6_nAttrMap
	_6_nAttrMap = (_5_valueOrError1).Extract().(_dafny.Map)
	if !((_2_attrMap).Equals(_6_nAttrMap)) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(554,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestTooDeep() {
	var _0_value m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _0_value
	_0_value = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("hello"))
	var _hi0 uint64 = m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH()
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		if ((_1_i) % (uint64(2))) == (uint64(0)) {
			_0_value = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("key"), _0_value))
		} else {
			_0_value = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf(_0_value))
		}
	}
	var _2_attrMap _dafny.Map
	_ = _2_attrMap
	_2_attrMap = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("key1"), _0_value)
	var _3_struct m_Wrappers.Result
	_ = _3_struct
	_3_struct = m_DynamoToStruct.Companion_Default___.ItemToStructured(_2_attrMap)
	if !((_3_struct).Is_Failure()) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(568,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_3_struct).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Equals(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Depth of attribute structure to serialize exceeds limit of 32")))) {
		panic("dafny/DynamoDbEncryption/test/DynamoToStruct.dfy(569,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) K() uint8 {
	return uint8(_dafny.Char('k'))
}
func (_static *CompanionStruct_Default___) E() uint8 {
	return uint8(_dafny.Char('e'))
}
func (_static *CompanionStruct_Default___) Y() uint8 {
	return uint8(_dafny.Char('y'))
}
func (_static *CompanionStruct_Default___) A() uint8 {
	return uint8(_dafny.Char('A'))
}
func (_static *CompanionStruct_Default___) B() uint8 {
	return uint8(_dafny.Char('B'))
}
func (_static *CompanionStruct_Default___) C() uint8 {
	return uint8(_dafny.Char('C'))
}
func (_static *CompanionStruct_Default___) D() uint8 {
	return uint8(_dafny.Char('D'))
}

// End of class Default__
