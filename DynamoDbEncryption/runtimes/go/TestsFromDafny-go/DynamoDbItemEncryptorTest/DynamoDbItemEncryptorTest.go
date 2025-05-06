// Package DynamoDbItemEncryptorTest
// Dafny module DynamoDbItemEncryptorTest compiled into Go

package DynamoDbItemEncryptorTest

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
	return "DynamoDbItemEncryptorTest.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DDBS(x _dafny.Sequence) m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(x)
}
func (_static *CompanionStruct_Default___) TestUnexpectedField() {
	var _0_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _0_encryptor
	var _out0 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptor()
	_0_encryptor = _out0
	var _1_inputItem _dafny.Map
	_ = _1_inputItem
	_1_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), Companion_Default___.DDBS(_dafny.SeqOfString("key"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), Companion_Default___.DDBS(_dafny.SeqOfString("foo"))).UpdateUnsafe(_dafny.SeqOfString("sign"), Companion_Default___.DDBS(_dafny.SeqOfString("bar"))).UpdateUnsafe(_dafny.SeqOfString("nothing"), Companion_Default___.DDBS(_dafny.SeqOfString("baz"))).UpdateUnsafe(_dafny.SeqOfString("unknown"), Companion_Default___.DDBS(_dafny.SeqOfString("other")))
	var _2_encryptRes m_Wrappers.Result
	_ = _2_encryptRes
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (_0_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_1_inputItem))
	_2_encryptRes = _out1
	if !((_2_encryptRes).Is_Failure()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(45,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_2_encryptRes).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error)).Equals(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(_dafny.SeqOfString("No Crypto Action configured for attribute unknown"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(46,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestMissingSortKey() {
	var _0_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _0_config
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetEncryptorConfig()
	_0_config = _out0
	var _1_inputItem _dafny.Map
	_ = _1_inputItem
	_1_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), Companion_Default___.DDBS(_dafny.SeqOfString("key"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), Companion_Default___.DDBS(_dafny.SeqOfString("foo"))).UpdateUnsafe(_dafny.SeqOfString("sign"), Companion_Default___.DDBS(_dafny.SeqOfString("bar"))).UpdateUnsafe(_dafny.SeqOfString("nothing"), Companion_Default___.DDBS(_dafny.SeqOfString("baz")))
	var _2_config2 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _2_config2
	var _3_dt__update__tmp_h0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig = _0_config
	_ = _3_dt__update__tmp_h0
	var _4_dt__update_hattributeActionsOnEncrypt_h0 _dafny.Map = ((_0_config).Dtor_attributeActionsOnEncrypt()).Update(_dafny.SeqOfString("sort"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_())
	_ = _4_dt__update_hattributeActionsOnEncrypt_h0
	var _5_dt__update_hsortKeyName_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("sort"))
	_ = _5_dt__update_hsortKeyName_h0
	_2_config2 = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DynamoDbItemEncryptorConfig_.Create_DynamoDbItemEncryptorConfig_((_3_dt__update__tmp_h0).Dtor_logicalTableName(), (_3_dt__update__tmp_h0).Dtor_partitionKeyName(), _5_dt__update_hsortKeyName_h0, _4_dt__update_hattributeActionsOnEncrypt_h0, (_3_dt__update__tmp_h0).Dtor_allowedUnsignedAttributes(), (_3_dt__update__tmp_h0).Dtor_allowedUnsignedAttributePrefix(), (_3_dt__update__tmp_h0).Dtor_algorithmSuiteId(), (_3_dt__update__tmp_h0).Dtor_keyring(), (_3_dt__update__tmp_h0).Dtor_cmm(), (_3_dt__update__tmp_h0).Dtor_legacyOverride(), (_3_dt__update__tmp_h0).Dtor_plaintextOverride())
	var _6_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _6_encryptor
	var _out1 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptorFrom(_2_config2)
	_6_encryptor = _out1
	var _7_encryptRes m_Wrappers.Result
	_ = _7_encryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_6_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_1_inputItem))
	_7_encryptRes = _out2
	if !((_7_encryptRes).Is_Failure()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(63,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_7_encryptRes).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error)).Equals(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.SeqOfString("On Encrypt : Sort key 'sort' does not exist in item. Item contains these attributes : bar encrypt nothing sign.")))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(64,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) GetAttrName(s _dafny.Sequence) _dafny.Sequence {
	if m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(s) {
		return s
	} else {
		return _dafny.SeqOfString("spoo")
	}
}
func (_static *CompanionStruct_Default___) TestV2RoundTripComplexSwitch() {
	var _0_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _0_config
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetEncryptorConfigFromActions(Companion_Default___.Actions1(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("sortKey")))
	_0_config = _out0
	var _1_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _1_encryptor
	var _out1 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptorFrom(_0_config)
	_1_encryptor = _out1
	var _2_inputItem _dafny.Map
	_ = _2_inputItem
	_2_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("00001234"))).UpdateUnsafe(_dafny.SeqOfString("sortKey"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4)))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), Companion_Default___.DDBS(_dafny.SeqOfString("text"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(true)).UpdateUnsafe(_dafny.SeqOfString("sign3"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(false)).UpdateUnsafe(_dafny.SeqOfString("sign4"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)).UpdateUnsafe(_dafny.SeqOfString("nothing"), Companion_Default___.DDBS(_dafny.SeqOfString("baz")))
	var _3_encryptRes m_Wrappers.Result
	_ = _3_encryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_1_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_2_inputItem))
	_3_encryptRes = _out2
	if (_3_encryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
		_dafny.Print(_3_encryptRes)
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
	}
	if !((_3_encryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(122,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_3_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Keys()).Equals(((_2_inputItem).Keys()).Union(_dafny.SetOf(m_StructuredEncryptionUtil.Companion_Default___.HeaderField(), m_StructuredEncryptionUtil.Companion_Default___.FooterField())))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(123,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_3_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_2_inputItem).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(124,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(!((((_3_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("encrypt")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_2_inputItem).Get(_dafny.SeqOfString("encrypt")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(125,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_3_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("sign")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_2_inputItem).Get(_dafny.SeqOfString("sign")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(126,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_3_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("sign3")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_2_inputItem).Get(_dafny.SeqOfString("sign3")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(127,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_3_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("sign4")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_2_inputItem).Get(_dafny.SeqOfString("sign4")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(128,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_3_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("nothing")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_2_inputItem).Get(_dafny.SeqOfString("nothing")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(129,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _4_config2 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _4_config2
	var _out3 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out3
	_out3 = m_TestFixtures.Companion_Default___.GetEncryptorConfigFromActions(Companion_Default___.Actions2(), m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("sortKey")))
	_4_config2 = _out3
	var _5_encryptor2 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _5_encryptor2
	var _out4 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out4
	_out4 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptorFrom(_4_config2)
	_5_encryptor2 = _out4
	var _6_decryptRes m_Wrappers.Result
	_ = _6_decryptRes
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_5_encryptor2).DecryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemInput_.Create_DecryptItemInput_(((_3_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()))
	_6_decryptRes = _out5
	if (_6_decryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_6_decryptRes).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error))
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_6_decryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(143,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_2_inputItem) {
		_dafny.Print((_dafny.SeqOfString("\ninputItem :\n")).SetString())
		_dafny.Print(_2_inputItem)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_dafny.SeqOfString("\nOutput Item :\n")).SetString())
		_dafny.Print(((_6_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem())
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((((_6_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_2_inputItem)) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(148,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_parsedHeader m_Wrappers.Option
	_ = _7_parsedHeader
	_7_parsedHeader = ((_6_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_parsedHeader()
	if !((_7_parsedHeader).Is_Some()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(151,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_algorithmSuiteId()).Equals(((m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).Dtor_id()).Dtor_DBE())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(152,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_attributeActionsOnEncrypt()).Equals((Companion_Default___.Actions1()).Subtract(_dafny.SetOf(_dafny.SeqOfString("nothing"), _dafny.SeqOfString("sign2"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(153,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Cardinality()).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(155,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Keys()).Contains(Companion_Default___.PublicKeyUtf8())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(156,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_dafny.IntOfUint32((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptedDataKeys()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(157,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_strEC _dafny.Map
	_ = _8_strEC
	var _out6 _dafny.Map
	_ = _out6
	_out6 = m_StructuredEncryptionUtil.Companion_Default___.EcAsString(((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptionContext())
	_8_strEC = _out6
	if !(((_8_strEC).Keys()).Contains(_dafny.SeqOfString("aws-crypto-public-key"))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(160,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_8_strEC = (_8_strEC).Subtract(_dafny.SetOf(_dafny.SeqOfString("aws-crypto-public-key")))
	if !((_8_strEC).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws-crypto-legend"), _dafny.SeqOfString("NLLLB")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.bar"), _dafny.SeqOfString("1234")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sortKey"), _dafny.SeqOfString("//8BAgME")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sign"), _dafny.SeqOfString("true")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sign3"), _dafny.SeqOfString("false")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sign4"), _dafny.SeqOfString("null")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-partition-name"), _dafny.SeqOfString("bar")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-sort-name"), _dafny.SeqOfString("sortKey")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-table-name"), _dafny.SeqOfString("foo")))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(162,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_selectorContext()).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1234"))).UpdateUnsafe(_dafny.SeqOfString("sortKey"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4)))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(true)).UpdateUnsafe(_dafny.SeqOfString("sign3"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(false)).UpdateUnsafe(_dafny.SeqOfString("sign4"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_table_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("foo"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_partition_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_sort_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sortKey"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(173,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestV2RoundTripComplex() {
	var _0_actions _dafny.Map
	_ = _0_actions
	_0_actions = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("sortKey"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("sign"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("sign2"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("sign3"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("sign4"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("nothing"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
	var _1_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _1_config
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetEncryptorConfigFromActions(_0_actions, m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("sortKey")))
	_1_config = _out0
	var _2_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _2_encryptor
	var _out1 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptorFrom(_1_config)
	_2_encryptor = _out1
	var _3_inputItem _dafny.Map
	_ = _3_inputItem
	_3_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1234"))).UpdateUnsafe(_dafny.SeqOfString("sortKey"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4)))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), Companion_Default___.DDBS(_dafny.SeqOfString("text"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(true)).UpdateUnsafe(_dafny.SeqOfString("sign3"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(false)).UpdateUnsafe(_dafny.SeqOfString("sign4"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)).UpdateUnsafe(_dafny.SeqOfString("nothing"), Companion_Default___.DDBS(_dafny.SeqOfString("baz")))
	var _4_encryptRes m_Wrappers.Result
	_ = _4_encryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_2_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_3_inputItem))
	_4_encryptRes = _out2
	if (_4_encryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
		_dafny.Print(_4_encryptRes)
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
	}
	if !((_4_encryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(221,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Keys()).Equals(((_3_inputItem).Keys()).Union(_dafny.SetOf(m_StructuredEncryptionUtil.Companion_Default___.HeaderField(), m_StructuredEncryptionUtil.Companion_Default___.FooterField())))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(222,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(223,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(!((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("encrypt")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("encrypt")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(224,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("sign")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("sign")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(225,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("sign3")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("sign3")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(226,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("sign4")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("sign4")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(227,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("nothing")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("nothing")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(228,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _5_decryptRes m_Wrappers.Result
	_ = _5_decryptRes
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_2_encryptor).DecryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemInput_.Create_DecryptItemInput_(((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()))
	_5_decryptRes = _out3
	if (_5_decryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_5_decryptRes).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error))
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_5_decryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(239,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_3_inputItem) {
		_dafny.Print((_dafny.SeqOfString("\nInput Item :\n")).SetString())
		_dafny.Print(_3_inputItem)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_dafny.SeqOfString("\nOutput Item :\n")).SetString())
		_dafny.Print(((_5_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem())
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((((_5_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_3_inputItem)) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(244,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_parsedHeader m_Wrappers.Option
	_ = _6_parsedHeader
	_6_parsedHeader = ((_5_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_parsedHeader()
	if !((_6_parsedHeader).Is_Some()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(247,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_algorithmSuiteId()).Equals(((m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).Dtor_id()).Dtor_DBE())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(248,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_attributeActionsOnEncrypt()).Equals((_0_actions).Subtract(_dafny.SetOf(_dafny.SeqOfString("nothing"), _dafny.SeqOfString("sign2"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(249,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Cardinality()).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(256,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Keys()).Contains(Companion_Default___.PublicKeyUtf8())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(257,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_dafny.IntOfUint32((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptedDataKeys()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(258,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_strEC _dafny.Map
	_ = _7_strEC
	var _out4 _dafny.Map
	_ = _out4
	_out4 = m_StructuredEncryptionUtil.Companion_Default___.EcAsString(((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptionContext())
	_7_strEC = _out4
	if !(((_7_strEC).Keys()).Contains(_dafny.SeqOfString("aws-crypto-public-key"))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(261,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_7_strEC = (_7_strEC).Subtract(_dafny.SetOf(_dafny.SeqOfString("aws-crypto-public-key")))
	if !((_7_strEC).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws-crypto-legend"), _dafny.SeqOfString("NLLLB")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.bar"), _dafny.SeqOfString("1234")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sortKey"), _dafny.SeqOfString("//8BAgME")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sign"), _dafny.SeqOfString("true")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sign3"), _dafny.SeqOfString("false")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sign4"), _dafny.SeqOfString("null")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-partition-name"), _dafny.SeqOfString("bar")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-sort-name"), _dafny.SeqOfString("sortKey")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-table-name"), _dafny.SeqOfString("foo")))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(290,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_selectorContext()).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_dafny.SeqOfString("1234"))).UpdateUnsafe(_dafny.SeqOfString("sortKey"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4)))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(true)).UpdateUnsafe(_dafny.SeqOfString("sign3"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(false)).UpdateUnsafe(_dafny.SeqOfString("sign4"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true)).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_table_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("foo"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_partition_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_sort_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("sortKey"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(301,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestMissingContext() {
	var _0_actions _dafny.Map
	_ = _0_actions
	_0_actions = m_TestFixtures.Companion_Default___.GetV2AttributeActions()
	var _1_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _1_config
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetEncryptorConfigFromActions(_0_actions, m_Wrappers.Companion_Option_.Create_None_())
	_1_config = _out0
	var _2_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _2_encryptor
	var _out1 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptorFrom(_1_config)
	_2_encryptor = _out1
	var _3_inputItem _dafny.Map
	_ = _3_inputItem
	_3_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), Companion_Default___.DDBS(_dafny.SeqOfString("key"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), Companion_Default___.DDBS(_dafny.SeqOfString("text"))).UpdateUnsafe(_dafny.SeqOfString("nothing"), Companion_Default___.DDBS(_dafny.SeqOfString("baz")))
	var _4_encryptRes m_Wrappers.Result
	_ = _4_encryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_2_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_3_inputItem))
	_4_encryptRes = _out2
	if !((_4_encryptRes).Is_Failure()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(331,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_4_encryptRes).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error)).Equals(m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("Attribute sign was configured with SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT but was not present in item to be encrypted.")))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(332,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestV2RoundTrip() {
	var _0_actions _dafny.Map
	_ = _0_actions
	_0_actions = m_TestFixtures.Companion_Default___.GetV2AttributeActions()
	var _1_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _1_config
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetEncryptorConfigFromActions(_0_actions, m_Wrappers.Companion_Option_.Create_None_())
	_1_config = _out0
	var _2_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _2_encryptor
	var _out1 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptorFrom(_1_config)
	_2_encryptor = _out1
	var _3_inputItem _dafny.Map
	_ = _3_inputItem
	_3_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), Companion_Default___.DDBS(_dafny.SeqOfString("key"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), Companion_Default___.DDBS(_dafny.SeqOfString("text"))).UpdateUnsafe(_dafny.SeqOfString("sign"), Companion_Default___.DDBS(_dafny.SeqOfString("barsoom"))).UpdateUnsafe(_dafny.SeqOfString("nothing"), Companion_Default___.DDBS(_dafny.SeqOfString("baz")))
	var _4_encryptRes m_Wrappers.Result
	_ = _4_encryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_2_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_3_inputItem))
	_4_encryptRes = _out2
	if (_4_encryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
		_dafny.Print(_4_encryptRes)
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
	}
	if !((_4_encryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(356,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Keys()).Equals(((_3_inputItem).Keys()).Union(_dafny.SetOf(m_StructuredEncryptionUtil.Companion_Default___.HeaderField(), m_StructuredEncryptionUtil.Companion_Default___.FooterField())))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(357,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(358,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(!((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("encrypt")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("encrypt")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(359,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("sign")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("sign")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(360,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("nothing")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_3_inputItem).Get(_dafny.SeqOfString("nothing")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(361,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _5_decryptRes m_Wrappers.Result
	_ = _5_decryptRes
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_2_encryptor).DecryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemInput_.Create_DecryptItemInput_(((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()))
	_5_decryptRes = _out3
	if (_5_decryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_5_decryptRes).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error))
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_5_decryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(372,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_5_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_3_inputItem) {
		_dafny.Print((_dafny.SeqOfString("\nInput Item :\n")).SetString())
		_dafny.Print(_3_inputItem)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_dafny.SeqOfString("\nOutput Item :\n")).SetString())
		_dafny.Print(((_5_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem())
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((((_5_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_3_inputItem)) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(377,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_parsedHeader m_Wrappers.Option
	_ = _6_parsedHeader
	_6_parsedHeader = ((_5_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_parsedHeader()
	if !((_6_parsedHeader).Is_Some()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(380,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_algorithmSuiteId()).Equals(((m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).Dtor_id()).Dtor_DBE())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(381,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_attributeActionsOnEncrypt()).Equals((_0_actions).Subtract(_dafny.SetOf(_dafny.SeqOfString("nothing"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(382,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Cardinality()).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(384,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Keys()).Contains(Companion_Default___.PublicKeyUtf8())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(385,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_dafny.IntOfUint32((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptedDataKeys()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(386,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_strEC _dafny.Map
	_ = _7_strEC
	var _out4 _dafny.Map
	_ = _out4
	_out4 = m_StructuredEncryptionUtil.Companion_Default___.EcAsString(((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptionContext())
	_7_strEC = _out4
	if !(((_7_strEC).Keys()).Contains(_dafny.SeqOfString("aws-crypto-public-key"))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(389,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_7_strEC = (_7_strEC).Subtract(_dafny.SetOf(_dafny.SeqOfString("aws-crypto-public-key")))
	if !((_7_strEC).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws-crypto-legend"), _dafny.SeqOfString("SS")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.bar"), _dafny.SeqOfString("key")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.sign"), _dafny.SeqOfString("barsoom")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-partition-name"), _dafny.SeqOfString("bar")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-table-name"), _dafny.SeqOfString("foo")))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(391,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_6_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_selectorContext()).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("key"))).UpdateUnsafe(_dafny.SeqOfString("sign"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("barsoom"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_table_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("foo"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_partition_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(398,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestV2RoundTripSpecial() {
	var _0_actions _dafny.Map
	_ = _0_actions
	_0_actions = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("a.b"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString(".a"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("a."), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString(".a."), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("a[2]"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("a#b"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$a"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$a.b"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$[a]"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$['a']"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$[\"a\"]"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("(a)"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$['"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$'a'"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$\"a\""), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$(a)"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("$(a"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_())
	var _1_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _1_config
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetEncryptorConfigFromActions(_0_actions, m_Wrappers.Companion_Option_.Create_None_())
	_1_config = _out0
	var _2_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _2_encryptor
	var _out1 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptorFrom(_1_config)
	_2_encryptor = _out1
	var _3_inputItem _dafny.Map
	_ = _3_inputItem
	_3_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), Companion_Default___.DDBS(_dafny.SeqOfString("key"))).UpdateUnsafe(_dafny.SeqOfString("a.b"), Companion_Default___.DDBS(_dafny.SeqOfString("aaa"))).UpdateUnsafe(_dafny.SeqOfString(".a"), Companion_Default___.DDBS(_dafny.SeqOfString("bbb"))).UpdateUnsafe(_dafny.SeqOfString("a."), Companion_Default___.DDBS(_dafny.SeqOfString("ccc"))).UpdateUnsafe(_dafny.SeqOfString(".a."), Companion_Default___.DDBS(_dafny.SeqOfString("ddd"))).UpdateUnsafe(_dafny.SeqOfString("a[2]"), Companion_Default___.DDBS(_dafny.SeqOfString("eee"))).UpdateUnsafe(_dafny.SeqOfString("a#b"), Companion_Default___.DDBS(_dafny.SeqOfString("fff"))).UpdateUnsafe(_dafny.SeqOfString("$"), Companion_Default___.DDBS(_dafny.SeqOfString("ggg"))).UpdateUnsafe(_dafny.SeqOfString("$a"), Companion_Default___.DDBS(_dafny.SeqOfString("hhh"))).UpdateUnsafe(_dafny.SeqOfString("$a.b"), Companion_Default___.DDBS(_dafny.SeqOfString("iii"))).UpdateUnsafe(_dafny.SeqOfString("$[a]"), Companion_Default___.DDBS(_dafny.SeqOfString("jjj"))).UpdateUnsafe(_dafny.SeqOfString("$['a']"), Companion_Default___.DDBS(_dafny.SeqOfString("kkk"))).UpdateUnsafe(_dafny.SeqOfString("$[\"a\"]"), Companion_Default___.DDBS(_dafny.SeqOfString("lll"))).UpdateUnsafe(_dafny.SeqOfString("(a)"), Companion_Default___.DDBS(_dafny.SeqOfString("mmm"))).UpdateUnsafe(_dafny.SeqOfString("$['"), Companion_Default___.DDBS(_dafny.SeqOfString("nnn"))).UpdateUnsafe(_dafny.SeqOfString("$'a'"), Companion_Default___.DDBS(_dafny.SeqOfString("ooo"))).UpdateUnsafe(_dafny.SeqOfString("$\"a\""), Companion_Default___.DDBS(_dafny.SeqOfString("ppp"))).UpdateUnsafe(_dafny.SeqOfString("$(a)"), Companion_Default___.DDBS(_dafny.SeqOfString("qqq"))).UpdateUnsafe(_dafny.SeqOfString("$(a"), Companion_Default___.DDBS(_dafny.SeqOfString("rrr")))
	var _4_encryptRes m_Wrappers.Result
	_ = _4_encryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_2_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_3_inputItem))
	_4_encryptRes = _out2
	if (_4_encryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
		_dafny.Print(_4_encryptRes)
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
	}
	if !((_4_encryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(464,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Keys()).Equals(((_3_inputItem).Keys()).Union(_dafny.SetOf(m_StructuredEncryptionUtil.Companion_Default___.HeaderField(), m_StructuredEncryptionUtil.Companion_Default___.FooterField())))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(465,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _5_smallEncrypted _dafny.Map
	_ = _5_smallEncrypted
	_5_smallEncrypted = (((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Subtract(_dafny.SetOf(m_StructuredEncryptionUtil.Companion_Default___.HeaderField(), m_StructuredEncryptionUtil.Companion_Default___.FooterField()))
	if !((_5_smallEncrypted).Equals(_3_inputItem)) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(467,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _6_decryptRes m_Wrappers.Result
	_ = _6_decryptRes
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_2_encryptor).DecryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemInput_.Create_DecryptItemInput_(((_4_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()))
	_6_decryptRes = _out3
	if (_6_decryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_6_decryptRes).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error))
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((_6_decryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(478,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((_6_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_3_inputItem) {
		_dafny.Print((_dafny.SeqOfString("\nInput Item :\n")).SetString())
		_dafny.Print(_3_inputItem)
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		_dafny.Print((_dafny.SeqOfString("\nOutput Item :\n")).SetString())
		_dafny.Print(((_6_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem())
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	if !((((_6_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_3_inputItem)) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(483,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_parsedHeader m_Wrappers.Option
	_ = _7_parsedHeader
	_7_parsedHeader = ((_6_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_parsedHeader()
	if !((_7_parsedHeader).Is_Some()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(486,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_algorithmSuiteId()).Equals(((m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).Dtor_id()).Dtor_DBE())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(487,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_attributeActionsOnEncrypt()).Equals((_0_actions).Subtract(_dafny.SetOf(_dafny.SeqOfString("nothing"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(488,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Cardinality()).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(490,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Keys()).Contains(Companion_Default___.PublicKeyUtf8())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(491,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_dafny.IntOfUint32((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptedDataKeys()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(492,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_strEC _dafny.Map
	_ = _8_strEC
	var _out4 _dafny.Map
	_ = _out4
	_out4 = m_StructuredEncryptionUtil.Companion_Default___.EcAsString(((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptionContext())
	_8_strEC = _out4
	if !(((_8_strEC).Keys()).Contains(_dafny.SeqOfString("aws-crypto-public-key"))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(495,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_8_strEC = (_8_strEC).Subtract(_dafny.SetOf(_dafny.SeqOfString("aws-crypto-public-key")))
	if !((_8_strEC).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws-crypto-legend"), _dafny.SeqOfString("SSSSSSSSSSSSSSSSSSS")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.bar"), _dafny.SeqOfString("key")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.a.b"), _dafny.SeqOfString("aaa")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr..a"), _dafny.SeqOfString("bbb")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.a."), _dafny.SeqOfString("ccc")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr..a."), _dafny.SeqOfString("ddd")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.a[2]"), _dafny.SeqOfString("eee")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.a#b"), _dafny.SeqOfString("fff")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$"), _dafny.SeqOfString("ggg")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$a"), _dafny.SeqOfString("hhh")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$a.b"), _dafny.SeqOfString("iii")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$[a]"), _dafny.SeqOfString("jjj")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$['a']"), _dafny.SeqOfString("kkk")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$[\"a\"]"), _dafny.SeqOfString("lll")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.(a)"), _dafny.SeqOfString("mmm")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$['"), _dafny.SeqOfString("nnn")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$'a'"), _dafny.SeqOfString("ooo")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$\"a\""), _dafny.SeqOfString("ppp")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$(a)"), _dafny.SeqOfString("qqq")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.$(a"), _dafny.SeqOfString("rrr")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-partition-name"), _dafny.SeqOfString("bar")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-table-name"), _dafny.SeqOfString("foo")))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(497,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_selectorContext()).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), Companion_Default___.DDBS(_dafny.SeqOfString("key"))).UpdateUnsafe(_dafny.SeqOfString("a.b"), Companion_Default___.DDBS(_dafny.SeqOfString("aaa"))).UpdateUnsafe(_dafny.SeqOfString(".a"), Companion_Default___.DDBS(_dafny.SeqOfString("bbb"))).UpdateUnsafe(_dafny.SeqOfString("a."), Companion_Default___.DDBS(_dafny.SeqOfString("ccc"))).UpdateUnsafe(_dafny.SeqOfString(".a."), Companion_Default___.DDBS(_dafny.SeqOfString("ddd"))).UpdateUnsafe(_dafny.SeqOfString("a[2]"), Companion_Default___.DDBS(_dafny.SeqOfString("eee"))).UpdateUnsafe(_dafny.SeqOfString("a#b"), Companion_Default___.DDBS(_dafny.SeqOfString("fff"))).UpdateUnsafe(_dafny.SeqOfString("$"), Companion_Default___.DDBS(_dafny.SeqOfString("ggg"))).UpdateUnsafe(_dafny.SeqOfString("$a"), Companion_Default___.DDBS(_dafny.SeqOfString("hhh"))).UpdateUnsafe(_dafny.SeqOfString("$a.b"), Companion_Default___.DDBS(_dafny.SeqOfString("iii"))).UpdateUnsafe(_dafny.SeqOfString("$[a]"), Companion_Default___.DDBS(_dafny.SeqOfString("jjj"))).UpdateUnsafe(_dafny.SeqOfString("$['a']"), Companion_Default___.DDBS(_dafny.SeqOfString("kkk"))).UpdateUnsafe(_dafny.SeqOfString("$[\"a\"]"), Companion_Default___.DDBS(_dafny.SeqOfString("lll"))).UpdateUnsafe(_dafny.SeqOfString("(a)"), Companion_Default___.DDBS(_dafny.SeqOfString("mmm"))).UpdateUnsafe(_dafny.SeqOfString("$['"), Companion_Default___.DDBS(_dafny.SeqOfString("nnn"))).UpdateUnsafe(_dafny.SeqOfString("$'a'"), Companion_Default___.DDBS(_dafny.SeqOfString("ooo"))).UpdateUnsafe(_dafny.SeqOfString("$\"a\""), Companion_Default___.DDBS(_dafny.SeqOfString("ppp"))).UpdateUnsafe(_dafny.SeqOfString("$(a)"), Companion_Default___.DDBS(_dafny.SeqOfString("qqq"))).UpdateUnsafe(_dafny.SeqOfString("$(a"), Companion_Default___.DDBS(_dafny.SeqOfString("rrr"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_table_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("foo"))).UpdateUnsafe(_dafny.SeqOfString("aws_dbe_partition_name"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("bar"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(522,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestRoundTrip() {
	var _0_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _0_encryptor
	var _out0 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptor()
	_0_encryptor = _out0
	var _1_inputItem _dafny.Map
	_ = _1_inputItem
	_1_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), Companion_Default___.DDBS(_dafny.SeqOfString("key"))).UpdateUnsafe(_dafny.SeqOfString("encrypt"), Companion_Default___.DDBS(_dafny.SeqOfString("text"))).UpdateUnsafe(_dafny.SeqOfString("sign"), Companion_Default___.DDBS(_dafny.SeqOfString("bar"))).UpdateUnsafe(_dafny.SeqOfString("nothing"), Companion_Default___.DDBS(_dafny.SeqOfString("baz")))
	var _2_encryptRes m_Wrappers.Result
	_ = _2_encryptRes
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = (_0_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_1_inputItem))
	_2_encryptRes = _out1
	if (_2_encryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
		_dafny.Print(_2_encryptRes)
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
	}
	if !((_2_encryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(566,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_2_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Keys()).Equals(((_1_inputItem).Keys()).Union(_dafny.SetOf(m_StructuredEncryptionUtil.Companion_Default___.HeaderField(), m_StructuredEncryptionUtil.Companion_Default___.FooterField())))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(567,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_2_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_1_inputItem).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(568,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(!((((_2_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("encrypt")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_1_inputItem).Get(_dafny.SeqOfString("encrypt")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(569,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_2_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("sign")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_1_inputItem).Get(_dafny.SeqOfString("sign")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(570,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_2_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("nothing")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_1_inputItem).Get(_dafny.SeqOfString("nothing")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(571,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _3_decryptRes m_Wrappers.Result
	_ = _3_decryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_0_encryptor).DecryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemInput_.Create_DecryptItemInput_(((_2_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()))
	_3_decryptRes = _out2
	if !((_3_decryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(579,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_3_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_1_inputItem)) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(580,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _4_parsedHeader m_Wrappers.Option
	_ = _4_parsedHeader
	_4_parsedHeader = ((_3_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_parsedHeader()
	if !((_4_parsedHeader).Is_Some()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(583,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_4_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_algorithmSuiteId()).Equals(((m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).Dtor_id()).Dtor_DBE())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(584,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_4_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_attributeActionsOnEncrypt()).Equals(m_TestFixtures.Companion_Default___.GetSignedAttributeActions())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(585,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Cardinality()).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(587,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_4_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Keys()).Contains(Companion_Default___.PublicKeyUtf8())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(588,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_dafny.IntOfUint32((((_4_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptedDataKeys()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(589,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _5_strEC _dafny.Map
	_ = _5_strEC
	var _out3 _dafny.Map
	_ = _out3
	_out3 = m_StructuredEncryptionUtil.Companion_Default___.EcAsString(((_4_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptionContext())
	_5_strEC = _out3
	if !(((_5_strEC).Keys()).Contains(_dafny.SeqOfString("aws-crypto-public-key"))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(597,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	_5_strEC = (_5_strEC).Subtract(_dafny.SetOf(_dafny.SeqOfString("aws-crypto-public-key")))
	if !((_5_strEC).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("aws-crypto-attr.bar"), _dafny.SeqOfString("AAFrZXk=")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-partition-name"), _dafny.SeqOfString("bar")).UpdateUnsafe(_dafny.SeqOfString("aws-crypto-table-name"), _dafny.SeqOfString("foo")))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(599,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_4_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_selectorContext()).Equals(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_dafny.SeqOfString("key"))))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(604,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) TestLargeRoundTrip() {
	var _0_inputItem _dafny.Map
	_ = _0_inputItem
	_0_inputItem = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), Companion_Default___.DDBS(_dafny.SeqOfString("key")))
	var _1_actions _dafny.Map
	_ = _1_actions
	_1_actions = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_())
	var _hi0 _dafny.Int = _dafny.IntOfInt64(500)
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_str _dafny.Sequence
		_ = _3_str
		_3_str = m_StandardLibrary_String.Companion_Default___.Base10Int2String(_2_i)
		if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_3_str)) {
			panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(612,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		_0_inputItem = (_0_inputItem).Update(_3_str, Companion_Default___.DDBS(_3_str))
		_1_actions = (_1_actions).Update(_3_str, m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
	}
	var _4_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _4_config
	var _out0 m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _out0
	_out0 = m_TestFixtures.Companion_Default___.GetEncryptorConfigFromActions(_1_actions, m_Wrappers.Companion_Option_.Create_None_())
	_4_config = _out0
	var _5_encryptor *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _5_encryptor
	var _out1 *m_DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
	_ = _out1
	_out1 = m_TestFixtures.Companion_Default___.GetDynamoDbItemEncryptorFrom(_4_config)
	_5_encryptor = _out1
	var _6_encryptRes m_Wrappers.Result
	_ = _6_encryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_5_encryptor).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_0_inputItem))
	_6_encryptRes = _out2
	if (_6_encryptRes).Is_Failure() {
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
		_dafny.Print(_6_encryptRes)
		_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
	}
	if !((_6_encryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(628,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Keys()).Equals(((_0_inputItem).Keys()).Union(_dafny.SetOf(m_StructuredEncryptionUtil.Companion_Default___.HeaderField(), m_StructuredEncryptionUtil.Companion_Default___.FooterField())))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(629,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_6_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Contains(_dafny.SeqOfString("bar"))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(630,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_0_inputItem).Contains(_dafny.SeqOfString("bar"))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(631,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_6_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_0_inputItem).Get(_dafny.SeqOfString("bar")).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(632,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _7_decryptRes m_Wrappers.Result
	_ = _7_decryptRes
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_5_encryptor).DecryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemInput_.Create_DecryptItemInput_(((_6_encryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)).Dtor_encryptedItem()))
	_7_decryptRes = _out3
	if !((_7_decryptRes).Is_Success()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(640,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_7_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_plaintextItem()).Equals(_0_inputItem)) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(641,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	var _8_parsedHeader m_Wrappers.Option
	_ = _8_parsedHeader
	_8_parsedHeader = ((_7_decryptRes).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)).Dtor_parsedHeader()
	if !((_8_parsedHeader).Is_Some()) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(644,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((((_8_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_algorithmSuiteId()).Equals(((m_AlgorithmSuites.Companion_Default___.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384()).Dtor_id()).Dtor_DBE())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(645,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_8_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Cardinality()).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(647,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !(((((_8_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_storedEncryptionContext()).Keys()).Contains(Companion_Default___.PublicKeyUtf8())) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(648,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	if !((_dafny.IntOfUint32((((_8_parsedHeader).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader)).Dtor_encryptedDataKeys()).Cardinality())).Cmp(_dafny.One) == 0) {
		panic("dafny/DynamoDbItemEncryptor/test/DynamoDBItemEncryptorTest.dfy(649,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
}
func (_static *CompanionStruct_Default___) Actions2() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.GetAttrName(_dafny.SeqOfString("bar")), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(Companion_Default___.GetAttrName(_dafny.SeqOfString("sortKey")), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(Companion_Default___.GetAttrName(_dafny.SeqOfString("encrypt")), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(Companion_Default___.GetAttrName(_dafny.SeqOfString("sign")), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(Companion_Default___.GetAttrName(_dafny.SeqOfString("sign2")), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(Companion_Default___.GetAttrName(_dafny.SeqOfString("sign3")), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(Companion_Default___.GetAttrName(_dafny.SeqOfString("sign4")), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(Companion_Default___.GetAttrName(_dafny.SeqOfString("nothing")), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
}
func (_static *CompanionStruct_Default___) Actions1() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("bar"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("sortKey"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("encrypt"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()).UpdateUnsafe(_dafny.SeqOfString("sign"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("sign2"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()).UpdateUnsafe(_dafny.SeqOfString("sign3"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("sign4"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()).UpdateUnsafe(_dafny.SeqOfString("nothing"), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
}
func (_static *CompanionStruct_Default___) PublicKeyUtf8() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(112), uint8(117), uint8(98), uint8(108), uint8(105), uint8(99), uint8(45), uint8(107), uint8(101), uint8(121))
	_ = _0_s
	return _0_s
}

// End of class Default__
