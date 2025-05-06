// Package TestStructuredEncryptionCrypt
// Dafny module TestStructuredEncryptionCrypt compiled into Go

package TestStructuredEncryptionCrypt

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
	m_HappyCaseTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/HappyCaseTests"
	m_PathsTests "github.com/aws/aws-database-encryption-sdk-dynamodb/test/PathsTests"
	m_StructuredDataTestFixtures "github.com/aws/aws-database-encryption-sdk-dynamodb/test/StructuredDataTestFixtures"
	m_TestHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/test/TestHeader"
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
	return "TestStructuredEncryptionCrypt.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) TestFieldKey() {
	var _hi0 _dafny.Int = _dafny.IntOfUint32((Companion_Default___.FieldKeyTestVector()).Cardinality())
	_ = _hi0
	for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
		if !(m_HexStrings.Companion_Default___.IsHexString(((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_input())) {
			panic("dafny/StructuredEncryption/test/Crypt.dfy(224,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		var _1_input _dafny.Sequence
		_ = _1_input
		_1_input = m_HexStrings.Companion_Default___.FromHexString(((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_input())
		if !(_dafny.Companion_Sequence_.Equal(m_HexStrings.Companion_Default___.ToHexString(_1_input), ((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_input())) {
			panic("dafny/StructuredEncryption/test/Crypt.dfy(226,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		if !((_dafny.IntOfUint32((_1_input).Cardinality())).Cmp(m_StructuredEncryptionUtil.Companion_Default___.KeySize()) == 0) {
			panic("dafny/StructuredEncryption/test/Crypt.dfy(227,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		if !(((_dafny.IntOfUint32(((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_offset())).Times(_dafny.IntOfInt64(3))).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT32__LIMIT()) < 0) {
			panic("dafny/StructuredEncryption/test/Crypt.dfy(228,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _2_valueOrError0
		_2_valueOrError0 = m_StructuredEncryptionCrypt.Companion_Default___.FieldKey(_1_input, ((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_offset())
		if !(!((_2_valueOrError0).IsFailure())) {
			panic("dafny/StructuredEncryption/test/Crypt.dfy(229,20): " + (_2_valueOrError0).String())
		}
		var _3_result _dafny.Sequence
		_ = _3_result
		_3_result = (_2_valueOrError0).Extract().(_dafny.Sequence)
		if !_dafny.Companion_Sequence_.Equal(m_HexStrings.Companion_Default___.ToHexString(_3_result), ((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_output()) {
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			_dafny.Print((((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_input()).SetString())
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			_dafny.Print(((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_offset())
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			_dafny.Print((m_HexStrings.Companion_Default___.ToHexString(_3_result)).SetString())
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			_dafny.Print((((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_output()).SetString())
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		}
		if !(_dafny.Companion_Sequence_.Equal(m_HexStrings.Companion_Default___.ToHexString(_3_result), ((Companion_Default___.FieldKeyTestVector()).Select((_0_i).Uint32()).(FieldKeyTestItem)).Dtor_output())) {
			panic("dafny/StructuredEncryption/test/Crypt.dfy(234,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
	}
}
func (_static *CompanionStruct_Default___) FieldKeyTestVector() _dafny.Sequence {
	return _dafny.SeqOf(Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000000"), uint32(0), _dafny.SeqOfString("4d17ac4f80763c4f5c1523ca2322b89918d5ad8b728aea9e052b177e41570f7be7ff404ace5e9b22aa1e8968")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000000"), uint32(1), _dafny.SeqOfString("18fcefe222b4d2a414c908f35c2e09153068198ad2b33fd0921596e5b02e7c1a48b2c6e720dc75167db54f46")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000000"), uint32(2), _dafny.SeqOfString("ec387607afb264f56ba44abd037c469fdfff9d5861a976a4261083e6dfa48d883b6c85c440003ed094a1eee7")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000000"), uint32(3), _dafny.SeqOfString("7124e0a5e057d168d17c76be6d61efff694048b301786d7952f463b509d2a542fe5cdf045f096f99ec3dca5b")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000000"), uint32(4), _dafny.SeqOfString("56e053ebe6f7a937b9fec2847e82b3a9c5daa20d49d9e6eb7951595e68a0bb826277d52685464da6cf8271d8")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000000"), uint32(5), _dafny.SeqOfString("8aacffc78d68c3350f510883394edfb1caaf21ddf363485dc4f6bcb4aef7a4dfaf8a0a0b9f647accc39db0f6")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000000"), uint32(6), _dafny.SeqOfString("7fb8a9f5b5e8c838523944fe7da143ef0dab663df66ef22c0cec7653b541115dfda3a55fae43c4a27459909d")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000000"), uint32(7), _dafny.SeqOfString("edfa5a6c99e14d131753163c2b890b135b8a6d4e310884d7d365a0670ef46686ef44b77c1c5a945797f17dd5")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000001"), uint32(0), _dafny.SeqOfString("c6a8b4e10a23bac8e13ae2d4edc0311509a5ce01b4d2357f8b1e667eeef77066cb9a2c4481d66ad1ede3d50f")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000001"), uint32(1), _dafny.SeqOfString("d54d4fe8e8295a523644dd49698f637a30f0c1e868c47a2a38e0e756ca0fcdee8e5aa355796debbb8fcb898b")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000001"), uint32(2), _dafny.SeqOfString("254489ab5be234d848f4fb21cba3ea27962c50363c9924054fffe34bd4f87d641fdb793224ccbf3e6ca9fa60")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000001"), uint32(3), _dafny.SeqOfString("b600f98e1c868209de7d563362ab8131bc8d0a5b58bf2590a8309889a94ee505515a02692824f7e32a31142f")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000001"), uint32(4), _dafny.SeqOfString("0af797f151dca40bd6db2cf69d5f3fdb98f34a3efe5f4af778cb3f8b942b507bd6eca848dd8e4b62e9d2db42")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000001"), uint32(5), _dafny.SeqOfString("9207c0c3dacd1b015d92689b78ba0bd49a1547f670d20097cc94cd35e569af02597a187f2ff7402f92149a19")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000001"), uint32(6), _dafny.SeqOfString("ca14fb5a292ec5f76669a04811532d3ed0d09421bdce95d629b0d3259b35888cf17e28e1ed4c1c136b4e5866")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0000000000000000000000000000000000000000000000000000000000000001"), uint32(7), _dafny.SeqOfString("da1188242ab66975027f11e49ecca9e7e23aaf1215855c263460a24f7d000cab89600be8ad6781d226190bed")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"), uint32(0), _dafny.SeqOfString("0c7e451b952b793d95c66bef5df16a7e42cd70bca33d5f9e01651751b4dbff0e4f9524335caef55a68d55f2a")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"), uint32(1), _dafny.SeqOfString("de3cdd84c99d3f6c011469433b2c24994e1836f2c923ee1fab47c3bedca95c1dd0fc547887cf9948efe1ffb6")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"), uint32(2), _dafny.SeqOfString("a088b21f062333d7a588da26ae30e11239949abd30b8a971621f2d664e5f2406212a4d51a04e63d314de54c3")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"), uint32(3), _dafny.SeqOfString("dc3448317b6d74b6dd662a9270fe808ab1dd7faf0f009e6e5e9f3aaac969d947d81e5bbc933819b8d6f2d76e")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"), uint32(4), _dafny.SeqOfString("87c5acfda18b650896588cd1f67e8f69cab31aed59df54b49c0748f4646e4789153bccb33b96ed760e9dfd44")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"), uint32(5), _dafny.SeqOfString("392d11b7e0884a5e42ef50f408cd79cbb0b96f792d67025527fd0ff0cfacad33c4dcead6021b34e4d0d1a3a2")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"), uint32(6), _dafny.SeqOfString("6092ee61588d3b1013b82c05ea7a894cdb9649d2fa8695f731c946aa75c47c4db0996bff661f8a796533c348")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"), uint32(7), _dafny.SeqOfString("d0270cfa0da88692a057c39b39644970786367da64008206e51a799af19f65db5b1531d01c52216431c451e5")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef"), uint32(0), _dafny.SeqOfString("772cb513bc2bebfed36dfa3c22dec2c5cb09466dd1b5275cd1f2713339b32e9c7993c521808a0bd6faa4cb4f")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef"), uint32(1), _dafny.SeqOfString("e93a3a5dd1633af15027c2ec078fc536ddf295110dfa5053592842a8c1f1010ad15c2462d0371ff27d98e99b")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef"), uint32(2), _dafny.SeqOfString("66f92041859c2000b8ff492629ae1ef875666c360fcfadeefe11e9f9f257887c4d1289c43ac1a442ec14a426")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef"), uint32(3), _dafny.SeqOfString("02dd4a565fcc6d308ce3f9a2818c8426c3476b2fb6ea66f1c4688c313b061177a6c69a2663122e4c5f3895dd")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef"), uint32(4), _dafny.SeqOfString("010a7cd17c89ac7668ba45332bdd956e388113f1ee9d01f387c5574ffdd86ade24b0430300d4009b0802335f")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef"), uint32(5), _dafny.SeqOfString("aecfa53a5f05f6b3b5185584573d527790c8d3504d5a0deb2af3d58c35164d58f232704851f7c9f357dcfb5b")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef"), uint32(6), _dafny.SeqOfString("3482b90bb7ddbed3d2b1f270ea648043539d7d6797861ec12c3d0797a07d31ecf3b160aab844008934823436")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef"), uint32(7), _dafny.SeqOfString("5c82960fb8370644b7fb7fd41f090e0098f52130379381ed4c21379fa65884e6e1367326c067856388b57589")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc"), uint32(0), _dafny.SeqOfString("d7d8c2e84dd5f56663b98501bf702a04f32451e62a1c30177d89bbf51beadd1090718c72ba120f7f20cf1e97")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc"), uint32(1), _dafny.SeqOfString("fadae5fa4f62e4cbec50d3b4572166fbccc114cb800ed066a4632e966fa18f1189a1fb7cd20ad1c93f29531d")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc"), uint32(2), _dafny.SeqOfString("14db82fab8f6f8e49a8061cf1689172b5bd37508560a8e9d42c21c507657a64a47545b155304c73198847429")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc"), uint32(3), _dafny.SeqOfString("4d83002cf87da3f9670999c707ee4ed8483c297390eb5abb989ea8cb514f4bf27e43bf1f92e6b76c3045080e")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc"), uint32(4), _dafny.SeqOfString("06fbc86f1e9716f218823710ef51b4558476a1cff4e5d706baac5ad14de544eb7e94197677f99cb46e12d63c")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc"), uint32(5), _dafny.SeqOfString("12ede6750d1f02e0aca4b159f4b7aac9fca85355ac7f21e39f44b37e4157dea6f76b9fd44aa7fe540256522b")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc"), uint32(6), _dafny.SeqOfString("7bfd555c3be12c57402b5db97cbfd897aefec952c3ba878642e5b22005cf1074ce854d210ac3c48c5fd0fbe2")), Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.SeqOfString("59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc"), uint32(7), _dafny.SeqOfString("20847d5de204cb578f3012940fa9876ddb3386ae9719cf9adcbdd611385011b2e7d5375fb6d3fd5ea77ba461")))
}

// End of class Default__

// Definition of datatype FieldKeyTestItem
type FieldKeyTestItem struct {
	Data_FieldKeyTestItem_
}

func (_this FieldKeyTestItem) Get_() Data_FieldKeyTestItem_ {
	return _this.Data_FieldKeyTestItem_
}

type Data_FieldKeyTestItem_ interface {
	isFieldKeyTestItem()
}

type CompanionStruct_FieldKeyTestItem_ struct {
}

var Companion_FieldKeyTestItem_ = CompanionStruct_FieldKeyTestItem_{}

type FieldKeyTestItem_FieldKeyTestItem struct {
	Input  _dafny.Sequence
	Offset uint32
	Output _dafny.Sequence
}

func (FieldKeyTestItem_FieldKeyTestItem) isFieldKeyTestItem() {}

func (CompanionStruct_FieldKeyTestItem_) Create_FieldKeyTestItem_(Input _dafny.Sequence, Offset uint32, Output _dafny.Sequence) FieldKeyTestItem {
	return FieldKeyTestItem{FieldKeyTestItem_FieldKeyTestItem{Input, Offset, Output}}
}

func (_this FieldKeyTestItem) Is_FieldKeyTestItem() bool {
	_, ok := _this.Get_().(FieldKeyTestItem_FieldKeyTestItem)
	return ok
}

func (CompanionStruct_FieldKeyTestItem_) Default() FieldKeyTestItem {
	return Companion_FieldKeyTestItem_.Create_FieldKeyTestItem_(_dafny.EmptySeq.SetString(), uint32(0), _dafny.EmptySeq.SetString())
}

func (_this FieldKeyTestItem) Dtor_input() _dafny.Sequence {
	return _this.Get_().(FieldKeyTestItem_FieldKeyTestItem).Input
}

func (_this FieldKeyTestItem) Dtor_offset() uint32 {
	return _this.Get_().(FieldKeyTestItem_FieldKeyTestItem).Offset
}

func (_this FieldKeyTestItem) Dtor_output() _dafny.Sequence {
	return _this.Get_().(FieldKeyTestItem_FieldKeyTestItem).Output
}

func (_this FieldKeyTestItem) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case FieldKeyTestItem_FieldKeyTestItem:
		{
			return "TestStructuredEncryptionCrypt.FieldKeyTestItem.FieldKeyTestItem" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Offset) + ", " + _dafny.String(data.Output) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this FieldKeyTestItem) Equals(other FieldKeyTestItem) bool {
	switch data1 := _this.Get_().(type) {
	case FieldKeyTestItem_FieldKeyTestItem:
		{
			data2, ok := other.Get_().(FieldKeyTestItem_FieldKeyTestItem)
			return ok && data1.Input.Equals(data2.Input) && data1.Offset == data2.Offset && data1.Output.Equals(data2.Output)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this FieldKeyTestItem) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(FieldKeyTestItem)
	return ok && _this.Equals(typed)
}

func Type_FieldKeyTestItem_() _dafny.TypeDescriptor {
	return type_FieldKeyTestItem_{}
}

type type_FieldKeyTestItem_ struct {
}

func (_this type_FieldKeyTestItem_) Default() interface{} {
	return Companion_FieldKeyTestItem_.Default()
}

func (_this type_FieldKeyTestItem_) String() string {
	return "TestStructuredEncryptionCrypt.FieldKeyTestItem"
}
func (_this FieldKeyTestItem) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = FieldKeyTestItem{}

// End of datatype FieldKeyTestItem
