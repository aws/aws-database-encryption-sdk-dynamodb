// Package BatchWriteItemTransformTest
// Dafny module BatchWriteItemTransformTest compiled into Go

package BatchWriteItemTransformTest

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
	m_DdbStatementTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/DdbStatementTest"
	m_DynamoDbItemEncryptorTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/DynamoDbItemEncryptorTest"
	m_ExecuteTransactionTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/ExecuteTransactionTransformTest"
	m_GetItemTransformTest "github.com/aws/aws-database-encryption-sdk-dynamodb/test/GetItemTransformTest"
	m_HappyCaseTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/HappyCaseTests"
	m_PathsTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PathsTests"
	m_StructuredDataTestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/StructuredDataTestFixtures"
	m_TestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestFixtures"
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
var _ m_TestFixtures.Dummy__
var _ m_DynamoDbItemEncryptorTest.Dummy__
var _ m_GetItemTransformTest.Dummy__
var _ m_DdbStatementTest.Dummy__
var _ m_ExecuteTransactionTransformTest.Dummy__

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
	return "BatchWriteItemTransformTest.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) TestBatchWriteItemInputTransform() {
	var _0_middlewareUnderTest *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _0_middlewareUnderTest
	var _out0 *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetDynamoDbEncryptionTransforms()
	_0_middlewareUnderTest = _out0
	var _1_tableName _dafny.Sequence
	_ = _1_tableName
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("foo"))
	_1_tableName = _out1
	var _2_request m_ComAmazonawsDynamodbTypes.WriteRequest
	_ = _2_request
	_2_request = m_ComAmazonawsDynamodbTypes.Companion_WriteRequest_.Create_WriteRequest_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _3_requests _dafny.Sequence
	_ = _3_requests
	var _out2 _dafny.Sequence
	_ = _out2
	_out2 = m_TestFixtures.Companion_Default___.GetWriteRequests(_dafny.SeqOf(_2_request))
	_3_requests = _out2
	var _4_theMap _dafny.Map
	_ = _4_theMap
	var _out3 _dafny.Map
	_ = _out3
	_out3 = m_TestFixtures.Companion_Default___.GetBatchWriteItemRequestMap(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_1_tableName, _3_requests))
	_4_theMap = _out3
	var _5_input m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
	_ = _5_input
	_5_input = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Create_BatchWriteItemInput_(_4_theMap, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _6_transformed m_Wrappers.Result
	_ = _6_transformed
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_0_middlewareUnderTest).BatchWriteItemInputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemInputTransformInput_.Create_BatchWriteItemInputTransformInput_(_5_input))
	_6_transformed = _out4
	m_TestFixtures.Companion_Default___.Expect__ok(_dafny.SeqOfString("BatchWriteItemInput"), _6_transformed)
	m_TestFixtures.Companion_Default___.Expect__equal(_dafny.SeqOfString("BatchWriteItemInput"), ((_6_transformed).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput)).Dtor_transformedInput(), _5_input)
}
func (_static *CompanionStruct_Default___) TestBatchWriteItemOutputTransform() {
	var _0_middlewareUnderTest *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _0_middlewareUnderTest
	var _out0 *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetDynamoDbEncryptionTransforms()
	_0_middlewareUnderTest = _out0
	var _1_output m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
	_ = _1_output
	_1_output = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Create_BatchWriteItemOutput_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _2_tableName _dafny.Sequence
	_ = _2_tableName
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("foo"))
	_2_tableName = _out1
	var _3_request m_ComAmazonawsDynamodbTypes.WriteRequest
	_ = _3_request
	_3_request = m_ComAmazonawsDynamodbTypes.Companion_WriteRequest_.Create_WriteRequest_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _4_requests _dafny.Sequence
	_ = _4_requests
	var _out2 _dafny.Sequence
	_ = _out2
	_out2 = m_TestFixtures.Companion_Default___.GetWriteRequests(_dafny.SeqOf(_3_request))
	_4_requests = _out2
	var _5_theMap _dafny.Map
	_ = _5_theMap
	var _out3 _dafny.Map
	_ = _out3
	_out3 = m_TestFixtures.Companion_Default___.GetBatchWriteItemRequestMap(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_2_tableName, _4_requests))
	_5_theMap = _out3
	var _6_input m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
	_ = _6_input
	_6_input = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Create_BatchWriteItemInput_(_5_theMap, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _7_transformed m_Wrappers.Result
	_ = _7_transformed
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_0_middlewareUnderTest).BatchWriteItemOutputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformInput_.Create_BatchWriteItemOutputTransformInput_(_1_output, _6_input))
	_7_transformed = _out4
	m_TestFixtures.Companion_Default___.Expect__ok(_dafny.SeqOfString("BatchWriteItemOutput"), _7_transformed)
	m_TestFixtures.Companion_Default___.Expect__equal(_dafny.SeqOfString("BatchWriteItemOutput"), ((_7_transformed).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput)).Dtor_transformedOutput(), _1_output)
}
func (_static *CompanionStruct_Default___) MakePut(item _dafny.Map) m_ComAmazonawsDynamodbTypes.WriteRequest {
	return m_ComAmazonawsDynamodbTypes.Companion_WriteRequest_.Create_WriteRequest_(m_Wrappers.Companion_Option_.Create_Some_(m_ComAmazonawsDynamodbTypes.Companion_PutRequest_.Create_PutRequest_(item)), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) TestBatchWriteItemOutputTransformUnprocessed() {
	var _0_middlewareUnderTest *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _0_middlewareUnderTest
	var _out0 *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetDynamoDbEncryptionTransforms()
	_0_middlewareUnderTest = _out0
	var _1_tableName _dafny.Sequence
	_ = _1_tableName
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("foo"))
	_1_tableName = _out1
	var _2_theRequests _dafny.Map
	_ = _2_theRequests
	var _out2 _dafny.Map
	_ = _out2
	_out2 = m_TestFixtures.Companion_Default___.GetBatchWriteItemRequestMap(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_1_tableName, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item1()), Companion_Default___.MakePut(Companion_Default___.Item2()), Companion_Default___.MakePut(Companion_Default___.Item3()), Companion_Default___.MakePut(Companion_Default___.Item4()))))
	_2_theRequests = _out2
	var _3_input m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
	_ = _3_input
	_3_input = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Create_BatchWriteItemInput_(_2_theRequests, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_0_middlewareUnderTest).BatchWriteItemInputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemInputTransformInput_.Create_BatchWriteItemInputTransformInput_(_3_input))
	_4_valueOrError0 = _out3
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(114,22): " + (_4_valueOrError0).String())
	}
	var _5_transInput m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput
	_ = _5_transInput
	_5_transInput = (_4_valueOrError0).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput)
	var _6_unProcessed _dafny.Map
	_ = _6_unProcessed
	_6_unProcessed = ((_5_transInput).Dtor_transformedInput()).Dtor_RequestItems()
	if !(!(_6_unProcessed).Equals((_3_input).Dtor_RequestItems())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(121,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_output m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
	_ = _7_output
	_7_output = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Create_BatchWriteItemOutput_(m_Wrappers.Companion_Option_.Create_Some_(_6_unProcessed), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _8_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformOutput_.Default())
	_ = _8_valueOrError1
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_0_middlewareUnderTest).BatchWriteItemOutputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformInput_.Create_BatchWriteItemOutputTransformInput_(_7_output, _3_input))
	_8_valueOrError1 = _out4
	if !(!((_8_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(126,23): " + (_8_valueOrError1).String())
	}
	var _9_transOutput m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput
	_ = _9_transOutput
	_9_transOutput = (_8_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput)
	m_TestFixtures.Companion_Default___.Expect__equal(_dafny.SeqOfString("BatchWriteOutput"), ((_9_transOutput).Dtor_transformedOutput()).Dtor_UnprocessedItems(), m_Wrappers.Companion_Option_.Create_Some_(_2_theRequests))
}
func (_static *CompanionStruct_Default___) TestBatchWriteItemOutputTransformUnprocessed2() {
	var _0_middlewareUnderTest *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _0_middlewareUnderTest
	var _out0 *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetDynamoDbEncryptionTransforms()
	_0_middlewareUnderTest = _out0
	var _1_tableName1 _dafny.Sequence
	_ = _1_tableName1
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("foo"))
	_1_tableName1 = _out1
	var _2_tableName2 _dafny.Sequence
	_ = _2_tableName2
	var _out2 _dafny.Sequence
	_ = _out2
	_out2 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("baz"))
	_2_tableName2 = _out2
	var _3_theRequests _dafny.Map
	_ = _3_theRequests
	var _out3 _dafny.Map
	_ = _out3
	_out3 = m_TestFixtures.Companion_Default___.GetBatchWriteItemRequestMap(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_1_tableName1, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item1()), Companion_Default___.MakePut(Companion_Default___.Item2()))).UpdateUnsafe(_2_tableName2, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item3()), Companion_Default___.MakePut(Companion_Default___.Item4()))))
	_3_theRequests = _out3
	var _4_input m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
	_ = _4_input
	_4_input = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Create_BatchWriteItemInput_(_3_theRequests, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError0
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_0_middlewareUnderTest).BatchWriteItemInputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemInputTransformInput_.Create_BatchWriteItemInputTransformInput_(_4_input))
	_5_valueOrError0 = _out4
	if !(!((_5_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(146,22): " + (_5_valueOrError0).String())
	}
	var _6_transInput m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput
	_ = _6_transInput
	_6_transInput = (_5_valueOrError0).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput)
	var _7_unProcessed _dafny.Map
	_ = _7_unProcessed
	_7_unProcessed = ((_6_transInput).Dtor_transformedInput()).Dtor_RequestItems()
	if !(!(_7_unProcessed).Equals((_4_input).Dtor_RequestItems())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(153,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_output m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
	_ = _8_output
	_8_output = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Create_BatchWriteItemOutput_(m_Wrappers.Companion_Option_.Create_Some_(_7_unProcessed), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _9_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformOutput_.Default())
	_ = _9_valueOrError1
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_0_middlewareUnderTest).BatchWriteItemOutputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformInput_.Create_BatchWriteItemOutputTransformInput_(_8_output, _4_input))
	_9_valueOrError1 = _out5
	if !(!((_9_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(158,23): " + (_9_valueOrError1).String())
	}
	var _10_transOutput m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput
	_ = _10_transOutput
	_10_transOutput = (_9_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput)
	m_TestFixtures.Companion_Default___.Expect__equal(_dafny.SeqOfString("BatchWriteOutput"), ((_10_transOutput).Dtor_transformedOutput()).Dtor_UnprocessedItems(), m_Wrappers.Companion_Option_.Create_Some_(_3_theRequests))
}
func (_static *CompanionStruct_Default___) TestBatchWriteItemOutputTransformUnprocessed3() {
	var _0_middlewareUnderTest *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _0_middlewareUnderTest
	var _out0 *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetDynamoDbEncryptionTransforms()
	_0_middlewareUnderTest = _out0
	var _1_tableName1 _dafny.Sequence
	_ = _1_tableName1
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("foo"))
	_1_tableName1 = _out1
	var _2_tableName2 _dafny.Sequence
	_ = _2_tableName2
	var _out2 _dafny.Sequence
	_ = _out2
	_out2 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("baz"))
	_2_tableName2 = _out2
	var _3_theRequests _dafny.Map
	_ = _3_theRequests
	var _out3 _dafny.Map
	_ = _out3
	_out3 = m_TestFixtures.Companion_Default___.GetBatchWriteItemRequestMap(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_1_tableName1, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item1()), Companion_Default___.MakePut(Companion_Default___.Item2()))).UpdateUnsafe(_2_tableName2, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item3()), Companion_Default___.MakePut(Companion_Default___.Item4()))))
	_3_theRequests = _out3
	var _4_input m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
	_ = _4_input
	_4_input = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Create_BatchWriteItemInput_(_3_theRequests, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError0
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_0_middlewareUnderTest).BatchWriteItemInputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemInputTransformInput_.Create_BatchWriteItemInputTransformInput_(_4_input))
	_5_valueOrError0 = _out4
	if !(!((_5_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(178,22): " + (_5_valueOrError0).String())
	}
	var _6_transInput m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput
	_ = _6_transInput
	_6_transInput = (_5_valueOrError0).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput)
	if !((((_6_transInput).Dtor_transformedInput()).Dtor_RequestItems()).Contains(_1_tableName1)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(184,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_6_transInput).Dtor_transformedInput()).Dtor_RequestItems()).Contains(_2_tableName2)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(185,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_list _dafny.Map
	_ = _7_list
	_7_list = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_1_tableName1, ((((_6_transInput).Dtor_transformedInput()).Dtor_RequestItems()).Get(_1_tableName1).(_dafny.Sequence)).Subsequence(0, 1)).UpdateUnsafe(_2_tableName2, ((((_6_transInput).Dtor_transformedInput()).Dtor_RequestItems()).Get(_2_tableName2).(_dafny.Sequence)).Subsequence(0, 1))
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__BatchWriteItemRequestMap(_7_list)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(191,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_unProcessed _dafny.Map
	_ = _8_unProcessed
	_8_unProcessed = _7_list
	var _9_orig__list _dafny.Map
	_ = _9_orig__list
	_9_orig__list = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_1_tableName1, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item1()))).UpdateUnsafe(_2_tableName2, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item3())))
	if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__BatchWriteItemRequestMap(_9_orig__list)) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(198,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _10_originalUnProcessed _dafny.Map
	_ = _10_originalUnProcessed
	_10_originalUnProcessed = _9_orig__list
	if !(!(_8_unProcessed).Equals((_4_input).Dtor_RequestItems())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(201,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _11_output m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
	_ = _11_output
	_11_output = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Create_BatchWriteItemOutput_(m_Wrappers.Companion_Option_.Create_Some_(_8_unProcessed), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _12_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformOutput_.Default())
	_ = _12_valueOrError1
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_0_middlewareUnderTest).BatchWriteItemOutputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformInput_.Create_BatchWriteItemOutputTransformInput_(_11_output, _4_input))
	_12_valueOrError1 = _out5
	if !(!((_12_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(206,23): " + (_12_valueOrError1).String())
	}
	var _13_transOutput m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput
	_ = _13_transOutput
	_13_transOutput = (_12_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput)
	m_TestFixtures.Companion_Default___.Expect__equal(_dafny.SeqOfString("BatchWriteOutput"), ((_13_transOutput).Dtor_transformedOutput()).Dtor_UnprocessedItems(), m_Wrappers.Companion_Option_.Create_Some_(_10_originalUnProcessed))
}
func (_static *CompanionStruct_Default___) TestBatchWriteItemOutputTransformUnprocessed4() {
	var _0_middlewareUnderTest *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _0_middlewareUnderTest
	var _out0 *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetDynamoDbEncryptionTransforms2()
	_0_middlewareUnderTest = _out0
	var _1_tableName1 _dafny.Sequence
	_ = _1_tableName1
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("foo"))
	_1_tableName1 = _out1
	var _2_tableName2 _dafny.Sequence
	_ = _2_tableName2
	var _out2 _dafny.Sequence
	_ = _out2
	_out2 = m_TestFixtures.Companion_Default___.GetTableName(_dafny.SeqOfString("baz"))
	_2_tableName2 = _out2
	var _3_theRequests _dafny.Map
	_ = _3_theRequests
	var _out3 _dafny.Map
	_ = _out3
	_out3 = m_TestFixtures.Companion_Default___.GetBatchWriteItemRequestMap(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_1_tableName1, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item1()), Companion_Default___.MakePut(Companion_Default___.Item1a()))).UpdateUnsafe(_2_tableName2, _dafny.SeqOf(Companion_Default___.MakePut(Companion_Default___.Item1b()), Companion_Default___.MakePut(Companion_Default___.Item1c()))))
	_3_theRequests = _out3
	var _4_input m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
	_ = _4_input
	_4_input = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Create_BatchWriteItemInput_(_3_theRequests, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError0
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = (_0_middlewareUnderTest).BatchWriteItemInputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemInputTransformInput_.Create_BatchWriteItemInputTransformInput_(_4_input))
	_5_valueOrError0 = _out4
	if !(!((_5_valueOrError0).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(247,22): " + (_5_valueOrError0).String())
	}
	var _6_transInput m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput
	_ = _6_transInput
	_6_transInput = (_5_valueOrError0).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput)
	var _7_unProcessed _dafny.Map
	_ = _7_unProcessed
	_7_unProcessed = ((_6_transInput).Dtor_transformedInput()).Dtor_RequestItems()
	if !(!(_7_unProcessed).Equals((_4_input).Dtor_RequestItems())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(254,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_output m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
	_ = _8_output
	_8_output = m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Create_BatchWriteItemOutput_(m_Wrappers.Companion_Option_.Create_Some_(_7_unProcessed), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _9_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformOutput_.Default())
	_ = _9_valueOrError1
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_0_middlewareUnderTest).BatchWriteItemOutputTransform(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_BatchWriteItemOutputTransformInput_.Create_BatchWriteItemOutputTransformInput_(_8_output, _4_input))
	_9_valueOrError1 = _out5
	if !(!((_9_valueOrError1).IsFailure())) {
		panic("dafny/DynamoDbEncryptionTransforms/test/BatchWriteItemTransform.dfy(259,23): " + (_9_valueOrError1).String())
	}
	var _10_transOutput m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput
	_ = _10_transOutput
	_10_transOutput = (_9_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput)
	m_TestFixtures.Companion_Default___.Expect__equal(_dafny.SeqOfString("BatchWriteOutput"), ((_10_transOutput).Dtor_transformedOutput()).Dtor_UnprocessedItems(), m_Wrappers.Companion_Option_.Create_Some_(_3_theRequests))
}
func (_static *CompanionStruct_Default___) Item1() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar1"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sign1"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("encrypt1"))).UpdateUnsafe(_dafny.SeqOfString("plain"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("plain1")))
}
func (_static *CompanionStruct_Default___) Item2() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar2"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sign2"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("encrypt2"))).UpdateUnsafe(_dafny.SeqOfString("plain"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("plain2")))
}
func (_static *CompanionStruct_Default___) Item3() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar3"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sign3"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("encrypt3"))).UpdateUnsafe(_dafny.SeqOfString("plain"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("plain3")))
}
func (_static *CompanionStruct_Default___) Item4() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar4"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sign4"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("encrypt4"))).UpdateUnsafe(_dafny.SeqOfString("plain"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("plain4")))
}
func (_static *CompanionStruct_Default___) Item1a() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar1"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sign2"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("encrypt2"))).UpdateUnsafe(_dafny.SeqOfString("plain"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("plain2")))
}
func (_static *CompanionStruct_Default___) Item1b() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar1"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sign3"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("encrypt3"))).UpdateUnsafe(_dafny.SeqOfString("plain"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("plain3")))
}
func (_static *CompanionStruct_Default___) Item1c() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar1"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sign4"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("encrypt4"))).UpdateUnsafe(_dafny.SeqOfString("plain"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("plain4")))
}

// End of class Default__
