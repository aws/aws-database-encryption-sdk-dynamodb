// Package DynamoDbGetEncryptedDataKeyDescriptionTest
// Dafny module DynamoDbGetEncryptedDataKeyDescriptionTest compiled into Go

package DynamoDbGetEncryptedDataKeyDescriptionTest

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
	m_DynamoDbEncryptionBranchKeyIdSupplierTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/DynamoDbEncryptionBranchKeyIdSupplierTest"
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
var _ m_DynamoDbEncryptionBranchKeyIdSupplierTest.Dummy__

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
	return "DynamoDbGetEncryptedDataKeyDescriptionTest.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) CreatePartialHeader(version uint8, flavor uint8, msgID _dafny.Sequence, legend _dafny.Sequence, encContext _dafny.Map, dataKeyList _dafny.Sequence) m_StructuredEncryptionHeader.PartialHeader {
	var result m_StructuredEncryptionHeader.PartialHeader = m_StructuredEncryptionHeader.PartialHeader{}
	_ = result
	result = m_StructuredEncryptionHeader.Companion_PartialHeader_.Create_PartialHeader_(version, flavor, msgID, legend, encContext, dataKeyList)
	return result
}
func (_static *CompanionStruct_Default___) TestHeaderInputAwsKmsDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_2_valueOrError0 = _out1
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(109,27): " + (_2_valueOrError0).String())
	}
	var _3_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _3_ddbEncResources
	_3_ddbEncResources = (_2_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _4_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _4_inputVariable
	_4_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_header_(_1_serializedHeader))
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _5_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable)
	_5_valueOrError1 = _out2
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(114,36): " + (_5_valueOrError1).String())
	}
	var _6_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _6_actualDataKeyDescription
	_6_actualDataKeyDescription = (_5_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(116,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(117,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(118,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(119,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestHeaderInputAwsKmsHDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsHDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_2_valueOrError0 = _out1
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(126,27): " + (_2_valueOrError0).String())
	}
	var _3_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _3_ddbEncResources
	_3_ddbEncResources = (_2_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _4_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _4_inputVariable
	_4_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_header_(_1_serializedHeader))
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _5_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable)
	_5_valueOrError1 = _out2
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(131,36): " + (_5_valueOrError1).String())
	}
	var _6_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _6_actualDataKeyDescription
	_6_actualDataKeyDescription = (_5_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(133,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms-hierarchy"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(134,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(135,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(136,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	Companion_Default___.AssertBranchKey(_6_actualDataKeyDescription)
}
func (_static *CompanionStruct_Default___) TestHeaderInputRawRsaDataKeyDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestRawRsaDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_2_valueOrError0 = _out1
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(145,27): " + (_2_valueOrError0).String())
	}
	var _3_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _3_ddbEncResources
	_3_ddbEncResources = (_2_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _4_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _4_inputVariable
	_4_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_header_(_1_serializedHeader))
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _5_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable)
	_5_valueOrError1 = _out2
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(150,36): " + (_5_valueOrError1).String())
	}
	var _6_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _6_actualDataKeyDescription
	_6_actualDataKeyDescription = (_5_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(152,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("raw-rsa"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(153,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestHeaderInputAwsKmsRsaDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsRsaDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_2_valueOrError0 = _out1
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(160,27): " + (_2_valueOrError0).String())
	}
	var _3_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _3_ddbEncResources
	_3_ddbEncResources = (_2_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _4_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _4_inputVariable
	_4_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_header_(_1_serializedHeader))
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _5_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable)
	_5_valueOrError1 = _out2
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(165,36): " + (_5_valueOrError1).String())
	}
	var _6_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _6_actualDataKeyDescription
	_6_actualDataKeyDescription = (_5_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(167,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms-rsa"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(168,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(169,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(170,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestDDBItemInputAwsKmsDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_attr _dafny.Map
	_ = _2_attr
	_2_attr = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_head"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_1_serializedHeader))
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_3_valueOrError0 = _out1
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(179,27): " + (_3_valueOrError0).String())
	}
	var _4_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _4_ddbEncResources
	_4_ddbEncResources = (_3_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _5_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _5_inputVariable
	_5_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_item_(_2_attr))
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _6_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable)
	_6_valueOrError1 = _out2
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(186,36): " + (_6_valueOrError1).String())
	}
	var _7_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _7_actualDataKeyDescription
	_7_actualDataKeyDescription = (_6_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(188,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(189,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(190,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(191,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestDDBItemInputAwsKmsHDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor0(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsHDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_attr _dafny.Map
	_ = _2_attr
	_2_attr = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_head"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_1_serializedHeader))
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_3_valueOrError0 = _out1
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(199,27): " + (_3_valueOrError0).String())
	}
	var _4_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _4_ddbEncResources
	_4_ddbEncResources = (_3_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _5_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _5_inputVariable
	_5_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_item_(_2_attr))
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _6_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable)
	_6_valueOrError1 = _out2
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(204,36): " + (_6_valueOrError1).String())
	}
	var _7_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _7_actualDataKeyDescription
	_7_actualDataKeyDescription = (_6_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(206,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms-hierarchy"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(207,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(208,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(209,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	Companion_Default___.AssertBranchKey(_7_actualDataKeyDescription)
}
func (_static *CompanionStruct_Default___) TestDDBItemInputRawRsaDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestRawRsaDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_attr _dafny.Map
	_ = _2_attr
	_2_attr = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_head"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_1_serializedHeader))
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_3_valueOrError0 = _out1
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(219,27): " + (_3_valueOrError0).String())
	}
	var _4_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _4_ddbEncResources
	_4_ddbEncResources = (_3_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _5_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _5_inputVariable
	_5_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_item_(_2_attr))
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _6_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable)
	_6_valueOrError1 = _out2
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(224,36): " + (_6_valueOrError1).String())
	}
	var _7_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _7_actualDataKeyDescription
	_7_actualDataKeyDescription = (_6_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(226,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("raw-rsa"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(227,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestDDBItemInputAwsKmsRsaDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsRsaDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_attr _dafny.Map
	_ = _2_attr
	_2_attr = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_head"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_1_serializedHeader))
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_3_valueOrError0 = _out1
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(235,27): " + (_3_valueOrError0).String())
	}
	var _4_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _4_ddbEncResources
	_4_ddbEncResources = (_3_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _5_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _5_inputVariable
	_5_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_item_(_2_attr))
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _6_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable)
	_6_valueOrError1 = _out2
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(240,36): " + (_6_valueOrError1).String())
	}
	var _7_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _7_actualDataKeyDescription
	_7_actualDataKeyDescription = (_6_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(242,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms-rsa"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(243,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(244,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(245,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestHeaderMultiDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsDataKey(), Companion_Default___.TestAwsKmsRsaDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_2_valueOrError0 = _out1
	if !(!((_2_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(252,27): " + (_2_valueOrError0).String())
	}
	var _3_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _3_ddbEncResources
	_3_ddbEncResources = (_2_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _4_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _4_inputVariable
	_4_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_header_(_1_serializedHeader))
	var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _5_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable)
	_5_valueOrError1 = _out2
	if !(!((_5_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(257,36): " + (_5_valueOrError1).String())
	}
	var _6_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _6_actualDataKeyDescription
	_6_actualDataKeyDescription = (_5_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(259,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(260,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(261,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(262,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(1).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(264,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(1).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms-rsa"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(265,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_6_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(1).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(266,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestDDBItemInputMultiDataKeyCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsDataKey(), Companion_Default___.TestAwsKmsRsaDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_attr _dafny.Map
	_ = _2_attr
	_2_attr = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws_dbe_head"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_1_serializedHeader))
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_3_valueOrError0 = _out1
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(274,27): " + (_3_valueOrError0).String())
	}
	var _4_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _4_ddbEncResources
	_4_ddbEncResources = (_3_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _5_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _5_inputVariable
	_5_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_item_(_2_attr))
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionOutput_.Default())
	_ = _6_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable)
	_6_valueOrError1 = _out2
	if !(!((_6_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(279,36): " + (_6_valueOrError1).String())
	}
	var _7_actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput
	_ = _7_actualDataKeyDescription
	_7_actualDataKeyDescription = (_6_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput)
	if !((_dafny.IntOfUint32(((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(281,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_dafny.IntOfUint32(((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(286,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(287,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(288,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(289,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(1).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(291,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(1).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderId(), _dafny.SeqOfString("aws-kms-rsa"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(292,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((_7_actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(1).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_keyProviderInfo()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(293,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestNoHeaderFailureCase() {
	var _0_expectedHead m_StructuredEncryptionHeader.PartialHeader
	_ = _0_expectedHead
	var _out0 m_StructuredEncryptionHeader.PartialHeader
	_ = _out0
	_out0 = Companion_Default___.CreatePartialHeader(Companion_Default___.TestVersion(), Companion_Default___.TestFlavor1(), Companion_Default___.TestMsgID(), Companion_Default___.TestLegend(), Companion_Default___.TestEncContext(), _dafny.SeqOf(Companion_Default___.TestAwsKmsDataKey()))
	_0_expectedHead = _out0
	var _1_serializedHeader _dafny.Sequence
	_ = _1_serializedHeader
	_1_serializedHeader = _dafny.Companion_Sequence_.Concatenate((_0_expectedHead).Serialize(), (_0_expectedHead).Dtor_msgID())
	var _2_attr _dafny.Map
	_ = _2_attr
	_2_attr = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("wrong_header_attribute"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_1_serializedHeader))
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DynamoDbEncryption.Companion_Default___.DynamoDbEncryption(m_DynamoDbEncryption.Companion_Default___.DefaultDynamoDbEncryptionConfig())
	_3_valueOrError0 = _out1
	if !(!((_3_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(301,27): " + (_3_valueOrError0).String())
	}
	var _4_ddbEncResources *m_DynamoDbEncryption.DynamoDbEncryptionClient
	_ = _4_ddbEncResources
	_4_ddbEncResources = (_3_valueOrError0).Extract().(*m_DynamoDbEncryption.DynamoDbEncryptionClient)
	var _5_inputVariable m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput
	_ = _5_inputVariable
	_5_inputVariable = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionInput_.Create_GetEncryptedDataKeyDescriptionInput_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetEncryptedDataKeyDescriptionUnion_.Create_item_(_2_attr))
	var _6_actualDataKeyDescription m_Wrappers.Result
	_ = _6_actualDataKeyDescription
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable)
	_6_actualDataKeyDescription = _out2
	if !((_6_actualDataKeyDescription).IsFailure()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(308,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_actualDataKeyDescription).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Is_DynamoDbEncryptionException()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(309,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((_6_actualDataKeyDescription).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error)).Dtor_message(), _dafny.SeqOfString("Header not found in the DynamoDB item."))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(310,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) AssertBranchKey(actualDataKeyDescription m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput) {
	if !((_dafny.IntOfUint32(((actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(315,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_branchKeyId()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(316,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_branchKeyVersion()).Is_Some()) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(317,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_branchKeyId()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("keyproviderInfo"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(319,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(_dafny.Companion_Sequence_.Equal(((((actualDataKeyDescription).Dtor_EncryptedDataKeyDescriptionOutput()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedDataKeyDescription)).Dtor_branchKeyVersion()).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("155b7a3d-7625-4826-4302-113d1179075a"))) {
		panic("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(320,4): " + (_dafny.SeqOfString("expectation violation")).String())
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
func (_static *CompanionStruct_Default___) TestEncContext() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.Abc(), Companion_Default___.Def())
}
func (_static *CompanionStruct_Default___) Aws__kms() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(107), uint8(109), uint8(115))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) KeyproviderInfo() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(107), uint8(101), uint8(121), uint8(112), uint8(114), uint8(111), uint8(118), uint8(105), uint8(100), uint8(101), uint8(114), uint8(73), uint8(110), uint8(102), uint8(111))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) TestAwsKmsDataKey() m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(Companion_Default___.Aws__kms(), Companion_Default___.KeyproviderInfo(), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)))
}
func (_static *CompanionStruct_Default___) Aws__kms__hierarchy() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(107), uint8(109), uint8(115), uint8(45), uint8(104), uint8(105), uint8(101), uint8(114), uint8(97), uint8(114), uint8(99), uint8(104), uint8(121))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) TestAwsKmsHDataKey() m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(Companion_Default___.Aws__kms__hierarchy(), Companion_Default___.KeyproviderInfo(), _dafny.SeqOf(uint8(64), uint8(92), uint8(115), uint8(7), uint8(85), uint8(121), uint8(112), uint8(79), uint8(69), uint8(12), uint8(82), uint8(25), uint8(67), uint8(34), uint8(11), uint8(66), uint8(93), uint8(45), uint8(40), uint8(23), uint8(90), uint8(61), uint8(16), uint8(28), uint8(59), uint8(114), uint8(52), uint8(122), uint8(50), uint8(23), uint8(11), uint8(101), uint8(48), uint8(53), uint8(30), uint8(120), uint8(51), uint8(74), uint8(77), uint8(53), uint8(57), uint8(99), uint8(53), uint8(13), uint8(30), uint8(21), uint8(109), uint8(85), uint8(15), uint8(86), uint8(47), uint8(84), uint8(91), uint8(85), uint8(87), uint8(60), uint8(4), uint8(56), uint8(67), uint8(74), uint8(29), uint8(87), uint8(85), uint8(106), uint8(8), uint8(82), uint8(63), uint8(114), uint8(100), uint8(110), uint8(68), uint8(58), uint8(83), uint8(24), uint8(111), uint8(41), uint8(21), uint8(91), uint8(122), uint8(61), uint8(118), uint8(37), uint8(72), uint8(38), uint8(67), uint8(2), uint8(17), uint8(61), uint8(17), uint8(121), uint8(7), uint8(90), uint8(117), uint8(49), uint8(30), uint8(20), uint8(89), uint8(68), uint8(33), uint8(111), uint8(107), uint8(5), uint8(120), uint8(20), uint8(95), uint8(78), uint8(70), uint8(2), uint8(49), uint8(84), uint8(39), uint8(50), uint8(40), uint8(40), uint8(115), uint8(114), uint8(76), uint8(18), uint8(103), uint8(84), uint8(34), uint8(123), uint8(1), uint8(125), uint8(61), uint8(33), uint8(13), uint8(18), uint8(81), uint8(24), uint8(53), uint8(53), uint8(26), uint8(60), uint8(52), uint8(85), uint8(81), uint8(96), uint8(85), uint8(72)))
}
func (_static *CompanionStruct_Default___) Raw__rsa() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(114), uint8(97), uint8(119), uint8(45), uint8(114), uint8(115), uint8(97))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) TestRawRsaDataKey() m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(Companion_Default___.Raw__rsa(), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOf(uint8(6), uint8(7), uint8(8), uint8(9)))
}
func (_static *CompanionStruct_Default___) Aws__kms__rsa() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(107), uint8(109), uint8(115), uint8(45), uint8(114), uint8(115), uint8(97))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) TestAwsKmsRsaDataKey() m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(Companion_Default___.Aws__kms__rsa(), Companion_Default___.KeyproviderInfo(), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)))
}
func (_static *CompanionStruct_Default___) TestVersion() uint8 {
	return uint8(1)
}
func (_static *CompanionStruct_Default___) TestFlavor1() uint8 {
	return uint8(1)
}
func (_static *CompanionStruct_Default___) TestMsgID() _dafny.Sequence {
	return _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5), uint8(6), uint8(7), uint8(8), uint8(9), uint8(10), uint8(11), uint8(12), uint8(13), uint8(14), uint8(15), uint8(16), uint8(17), uint8(18), uint8(19), uint8(20), uint8(21), uint8(22), uint8(23), uint8(24), uint8(25), uint8(26), uint8(27), uint8(28), uint8(29), uint8(30), uint8(31), uint8(32))
}
func (_static *CompanionStruct_Default___) TestLegend() _dafny.Sequence {
	return _dafny.SeqOf(uint8(101), uint8(115))
}
func (_static *CompanionStruct_Default___) TestFlavor0() uint8 {
	return uint8(0)
}

// End of class Default__
