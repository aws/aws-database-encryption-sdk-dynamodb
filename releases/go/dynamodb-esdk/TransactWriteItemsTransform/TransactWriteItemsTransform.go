// Package TransactWriteItemsTransform
// Dafny module TransactWriteItemsTransform compiled into Go

package TransactWriteItemsTransform

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
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/BaseBeacon"
	m_BatchWriteItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/BatchWriteItemTransform"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Canonize"
	m_CompoundBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/CompoundBeacon"
	m_DdbMiddlewareConfig "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DdbMiddlewareConfig"
	m_DdbStatement "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DdbStatement"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DdbVirtualFields"
	m_DynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDBFilterExpr"
	m_DynamoDBSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDBSupport"
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryption"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbItemEncryptorUtil"
	m_DynamoDbMiddlewareSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbMiddlewareSupport"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbNormalizeNumber"
	m_DynamoDbUpdateExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbUpdateExpr"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoToStruct"
	m_GetItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/GetItemTransform"
	m_InternalLegacyOverride "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/InternalLegacyOverride"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Maps_"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/OptimizedMergeSort"
	m_PutItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/PutItemTransform"
	m_SearchConfigToInfo "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/SearchConfigToInfo"
	m_SearchableEncryptionInfo "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/SearchableEncryptionInfo"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/SortCanon"
	m_StructuredEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryption"
	m_StructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionCrypt"
	m_StructuredEncryptionFooter "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionFooter"
	m_StructuredEncryptionHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionHeader"
	m_StructuredEncryptionPaths "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionPaths"
	m_StructuredEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionUtil"
	m_TermLoc "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/TermLoc"
	m_UpdateItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/UpdateItemTransform"
	m__System "github.com/dafny-lang/DafnyRuntimeGo/v4/System_"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

var _ = os.Args
var _ _dafny.Dummy__
var _ m__System.Dummy__
var _ m_Wrappers.Dummy__
var _ m_BoundedInts.Dummy__
var _ m_StandardLibrary_UInt.Dummy__
var _ m_StandardLibrary_MemoryMath.Dummy__
var _ m_StandardLibrary_Sequence.Dummy__
var _ m_StandardLibrary_String.Dummy__
var _ m_StandardLibrary.Dummy__
var _ m_AwsCryptographyPrimitivesTypes.Dummy__
var _ m_Random.Dummy__
var _ m_Digest.Dummy__
var _ m_WrappedHMAC.Dummy__
var _ m_HKDF.Dummy__
var _ m_WrappedHKDF.Dummy__
var _ m_KdfCtr.Dummy__
var _ m_AwsCryptographyPrimitivesOperations.Dummy__
var _ m_AtomicPrimitives.Dummy__
var _ m_ComAmazonawsDynamodbTypes.Dummy__
var _ m_ComAmazonawsKmsTypes.Dummy__
var _ m_AwsCryptographyKeyStoreTypes.Dummy__
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_Base64.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m_Actions.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
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
var _ m_Functions.Dummy__
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
var _ m_HexStrings.Dummy__
var _ m_GetOpt.Dummy__
var _ m_FloatCompare.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Dummy__
var _ m_StructuredEncryptionUtil.Dummy__
var _ m_Sets.Dummy__
var _ m_StructuredEncryptionPaths.Dummy__
var _ m_StructuredEncryptionHeader.Dummy__
var _ m_StructuredEncryptionFooter.Dummy__
var _ m_OptimizedMergeSort.Dummy__
var _ m_SortCanon.Dummy__
var _ m_Canonize.Dummy__
var _ m_StructuredEncryptionCrypt.Dummy__
var _ m__Maps.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Dummy__
var _ m_StructuredEncryption.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Dummy__
var _ m_DynamoDbEncryptionUtil.Dummy__
var _ m_DynamoDbNormalizeNumber.Dummy__
var _ m_DynamoToStruct.Dummy__
var _ m_DynamoDbItemEncryptorUtil.Dummy__
var _ m_InternalLegacyOverride.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Dummy__
var _ m_DynamoDbItemEncryptor.Dummy__
var _ m_DynamoDbEncryptionBranchKeyIdSupplier.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbOperations.Dummy__
var _ m_DynamoDbEncryption.Dummy__
var _ m_TermLoc.Dummy__
var _ m_DdbVirtualFields.Dummy__
var _ m_DynamoDbUpdateExpr.Dummy__
var _ m_BaseBeacon.Dummy__
var _ m_CompoundBeacon.Dummy__
var _ m_SearchableEncryptionInfo.Dummy__
var _ m_DynamoDBFilterExpr.Dummy__
var _ m_DynamoDBSupport.Dummy__
var _ m_SearchConfigToInfo.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Dummy__
var _ m_DdbMiddlewareConfig.Dummy__
var _ m_DdbStatement.Dummy__
var _ m_DynamoDbMiddlewareSupport.Dummy__
var _ m_PutItemTransform.Dummy__
var _ m_GetItemTransform.Dummy__
var _ m_UpdateItemTransform.Dummy__
var _ m_BatchWriteItemTransform.Dummy__

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
	return "TransactWriteItemsTransform.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsValid(item m_ComAmazonawsDynamodbTypes.TransactWriteItem) bool {
	return (((((item).Dtor_Put()).Is_Some()) || (((item).Dtor_Update()).Is_Some())) || (((item).Dtor_Delete()).Is_Some())) || (((item).Dtor_ConditionCheck()).Is_Some())
}
func (_static *CompanionStruct_Default___) Input(config m_DdbMiddlewareConfig.Config, input m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((((input).Dtor_sdkInput()).Dtor_TransactItems()).UniqueElements(), true, func(_forall_var_0 m_ComAmazonawsDynamodbTypes.TransactWriteItem) bool {
		var _1_item m_ComAmazonawsDynamodbTypes.TransactWriteItem
		_1_item = interface{}(_forall_var_0).(m_ComAmazonawsDynamodbTypes.TransactWriteItem)
		return !(_dafny.Companion_Sequence_.Contains(((input).Dtor_sdkInput()).Dtor_TransactItems(), _1_item)) || (Companion_Default___.IsValid(_1_item))
	}), m_DdbMiddlewareConfig.Companion_Default___.E(_dafny.SeqOfString("Each item in TransactWriteItems must specify at least one supported operation")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _2_result _dafny.Sequence
	_ = _2_result
	_2_result = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32((((input).Dtor_sdkInput()).Dtor_TransactItems()).Cardinality())
	_ = _hi0
	for _3_x := _dafny.Zero; _3_x.Cmp(_hi0) < 0; _3_x = _3_x.Plus(_dafny.One) {
		var _4_item m_ComAmazonawsDynamodbTypes.TransactWriteItem
		_ = _4_item
		_4_item = (((input).Dtor_sdkInput()).Dtor_TransactItems()).Select((_3_x).Uint32()).(m_ComAmazonawsDynamodbTypes.TransactWriteItem)
		if (((_4_item).Dtor_ConditionCheck()).Is_Some()) && (((config).Dtor_tableEncryptionConfigs()).Contains((((_4_item).Dtor_ConditionCheck()).Dtor_value().(m_ComAmazonawsDynamodbTypes.ConditionCheck)).Dtor_TableName())) {
			var _5_tableConfig m_DdbMiddlewareConfig.TableConfig
			_ = _5_tableConfig
			_5_tableConfig = ((config).Dtor_tableEncryptionConfigs()).Get((((_4_item).Dtor_ConditionCheck()).Dtor_value().(m_ComAmazonawsDynamodbTypes.ConditionCheck)).Dtor_TableName()).(m_DdbMiddlewareConfig.TableConfig)
			var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
			_ = _6_valueOrError1
			_6_valueOrError1 = m_DynamoDbMiddlewareSupport.Companion_Default___.TestConditionExpression(_5_tableConfig, m_Wrappers.Companion_Option_.Create_Some_((((_4_item).Dtor_ConditionCheck()).Dtor_value().(m_ComAmazonawsDynamodbTypes.ConditionCheck)).Dtor_ConditionExpression()), (((_4_item).Dtor_ConditionCheck()).Dtor_value().(m_ComAmazonawsDynamodbTypes.ConditionCheck)).Dtor_ExpressionAttributeNames(), (((_4_item).Dtor_ConditionCheck()).Dtor_value().(m_ComAmazonawsDynamodbTypes.ConditionCheck)).Dtor_ExpressionAttributeValues())
			if (_6_valueOrError1).IsFailure() {
				output = (_6_valueOrError1).PropagateFailure()
				return output
			}
			var _7___v0 bool
			_ = _7___v0
			_7___v0 = (_6_valueOrError1).Extract().(bool)
		}
		if (((_4_item).Dtor_Delete()).Is_Some()) && (((config).Dtor_tableEncryptionConfigs()).Contains((((_4_item).Dtor_Delete()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Delete)).Dtor_TableName())) {
			var _8_tableConfig m_DdbMiddlewareConfig.TableConfig
			_ = _8_tableConfig
			_8_tableConfig = ((config).Dtor_tableEncryptionConfigs()).Get((((_4_item).Dtor_Delete()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Delete)).Dtor_TableName()).(m_DdbMiddlewareConfig.TableConfig)
			var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
			_ = _9_valueOrError2
			_9_valueOrError2 = m_DynamoDbMiddlewareSupport.Companion_Default___.TestConditionExpression(_8_tableConfig, (((_4_item).Dtor_Delete()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Delete)).Dtor_ConditionExpression(), (((_4_item).Dtor_Delete()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Delete)).Dtor_ExpressionAttributeNames(), (((_4_item).Dtor_Delete()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Delete)).Dtor_ExpressionAttributeValues())
			if (_9_valueOrError2).IsFailure() {
				output = (_9_valueOrError2).PropagateFailure()
				return output
			}
			var _10___v1 bool
			_ = _10___v1
			_10___v1 = (_9_valueOrError2).Extract().(bool)
		}
		if (((_4_item).Dtor_Update()).Is_Some()) && (((config).Dtor_tableEncryptionConfigs()).Contains((((_4_item).Dtor_Update()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Update)).Dtor_TableName())) {
			var _11_tableConfig m_DdbMiddlewareConfig.TableConfig
			_ = _11_tableConfig
			_11_tableConfig = ((config).Dtor_tableEncryptionConfigs()).Get((((_4_item).Dtor_Update()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Update)).Dtor_TableName()).(m_DdbMiddlewareConfig.TableConfig)
			var _12_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
			_ = _12_valueOrError3
			_12_valueOrError3 = m_DynamoDbMiddlewareSupport.Companion_Default___.TestUpdateExpression(_11_tableConfig, m_Wrappers.Companion_Option_.Create_Some_((((_4_item).Dtor_Update()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Update)).Dtor_UpdateExpression()), (((_4_item).Dtor_Update()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Update)).Dtor_ExpressionAttributeNames(), (((_4_item).Dtor_Update()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Update)).Dtor_ExpressionAttributeValues())
			if (_12_valueOrError3).IsFailure() {
				output = (_12_valueOrError3).PropagateFailure()
				return output
			}
			var _13___v2 bool
			_ = _13___v2
			_13___v2 = (_12_valueOrError3).Extract().(bool)
			var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
			_ = _14_valueOrError4
			_14_valueOrError4 = m_DynamoDbMiddlewareSupport.Companion_Default___.TestConditionExpression(_11_tableConfig, (((_4_item).Dtor_Update()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Update)).Dtor_ConditionExpression(), (((_4_item).Dtor_Update()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Update)).Dtor_ExpressionAttributeNames(), (((_4_item).Dtor_Update()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Update)).Dtor_ExpressionAttributeValues())
			if (_14_valueOrError4).IsFailure() {
				output = (_14_valueOrError4).PropagateFailure()
				return output
			}
			var _15___v3 bool
			_ = _15___v3
			_15___v3 = (_14_valueOrError4).Extract().(bool)
		}
		if (((_4_item).Dtor_Put()).Is_Some()) && (!(m_DdbMiddlewareConfig.Companion_Default___.IsPlainWrite(config, (((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)).Dtor_TableName()))) {
			var _16_tableConfig m_DdbMiddlewareConfig.TableConfig
			_ = _16_tableConfig
			_16_tableConfig = ((config).Dtor_tableEncryptionConfigs()).Get((((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)).Dtor_TableName()).(m_DdbMiddlewareConfig.TableConfig)
			var _17_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
			_ = _17_valueOrError5
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = m_DynamoDbMiddlewareSupport.Companion_Default___.IsWriteable(_16_tableConfig, (((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)).Dtor_Item())
			_17_valueOrError5 = _out0
			if (_17_valueOrError5).IsFailure() {
				output = (_17_valueOrError5).PropagateFailure()
				return output
			}
			var _18___v4 bool
			_ = _18___v4
			_18___v4 = (_17_valueOrError5).Extract().(bool)
			var _19_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
			_ = _19_valueOrError6
			_19_valueOrError6 = m_DynamoDbMiddlewareSupport.Companion_Default___.TestConditionExpression(_16_tableConfig, (((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)).Dtor_ConditionExpression(), (((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)).Dtor_ExpressionAttributeNames(), (((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)).Dtor_ExpressionAttributeValues())
			if (_19_valueOrError6).IsFailure() {
				output = (_19_valueOrError6).PropagateFailure()
				return output
			}
			var _20___v5 bool
			_ = _20___v5
			_20___v5 = (_19_valueOrError6).Extract().(bool)
			var _21_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
			_ = _21_valueOrError7
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = m_DynamoDbMiddlewareSupport.Companion_Default___.AddSignedBeacons(_16_tableConfig, (((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)).Dtor_Item())
			_21_valueOrError7 = _out1
			if (_21_valueOrError7).IsFailure() {
				output = (_21_valueOrError7).PropagateFailure()
				return output
			}
			var _22_beaconItem _dafny.Map
			_ = _22_beaconItem
			_22_beaconItem = (_21_valueOrError7).Extract().(_dafny.Map)
			var _23_encryptRes m_Wrappers.Result
			_ = _23_encryptRes
			var _out2 m_Wrappers.Result
			_ = _out2
			_out2 = ((_16_tableConfig).Dtor_itemEncryptor()).EncryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemInput_.Create_EncryptItemInput_(_22_beaconItem))
			_23_encryptRes = _out2
			var _24_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemOutput_.Default())
			_ = _24_valueOrError8
			_24_valueOrError8 = m_DdbMiddlewareConfig.Companion_Default___.MapError(_23_encryptRes)
			if (_24_valueOrError8).IsFailure() {
				output = (_24_valueOrError8).PropagateFailure()
				return output
			}
			var _25_encrypted m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput
			_ = _25_encrypted
			_25_encrypted = (_24_valueOrError8).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)
			var _26_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_Wrappers.Companion_Option_.Default())
			_ = _26_valueOrError9
			_26_valueOrError9 = m_DynamoDbMiddlewareSupport.Companion_Default___.GetKeyIdFromHeader(_16_tableConfig, _25_encrypted)
			if (_26_valueOrError9).IsFailure() {
				output = (_26_valueOrError9).PropagateFailure()
				return output
			}
			var _27_keyId m_Wrappers.Option
			_ = _27_keyId
			_27_keyId = (_26_valueOrError9).Extract().(m_Wrappers.Option)
			var _28_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
			_ = _28_valueOrError10
			var _out3 m_Wrappers.Result
			_ = _out3
			_out3 = m_DynamoDbMiddlewareSupport.Companion_Default___.GetEncryptedBeacons(_16_tableConfig, (((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)).Dtor_Item(), m_DynamoDbEncryptionUtil.Companion_Default___.MaybeFromOptionKeyId(_27_keyId))
			_28_valueOrError10 = _out3
			if (_28_valueOrError10).IsFailure() {
				output = (_28_valueOrError10).PropagateFailure()
				return output
			}
			var _29_beaconAttrs _dafny.Map
			_ = _29_beaconAttrs
			_29_beaconAttrs = (_28_valueOrError10).Extract().(_dafny.Map)
			var _pat_let_tv0 = _25_encrypted
			_ = _pat_let_tv0
			var _pat_let_tv1 = _29_beaconAttrs
			_ = _pat_let_tv1
			var _30_put m_Wrappers.Option
			_ = _30_put
			_30_put = m_Wrappers.Companion_Option_.Create_Some_(func(_pat_let35_0 m_ComAmazonawsDynamodbTypes.Put) m_ComAmazonawsDynamodbTypes.Put {
				return func(_31_dt__update__tmp_h0 m_ComAmazonawsDynamodbTypes.Put) m_ComAmazonawsDynamodbTypes.Put {
					return func(_pat_let36_0 _dafny.Map) m_ComAmazonawsDynamodbTypes.Put {
						return func(_32_dt__update_hItem_h0 _dafny.Map) m_ComAmazonawsDynamodbTypes.Put {
							return m_ComAmazonawsDynamodbTypes.Companion_Put_.Create_Put_(_32_dt__update_hItem_h0, (_31_dt__update__tmp_h0).Dtor_TableName(), (_31_dt__update__tmp_h0).Dtor_ConditionExpression(), (_31_dt__update__tmp_h0).Dtor_ExpressionAttributeNames(), (_31_dt__update__tmp_h0).Dtor_ExpressionAttributeValues(), (_31_dt__update__tmp_h0).Dtor_ReturnValuesOnConditionCheckFailure())
						}(_pat_let36_0)
					}(((_pat_let_tv0).Dtor_encryptedItem()).Merge(_pat_let_tv1))
				}(_pat_let35_0)
			}(((_4_item).Dtor_Put()).Dtor_value().(m_ComAmazonawsDynamodbTypes.Put)))
			var _33_newItem m_ComAmazonawsDynamodbTypes.TransactWriteItem
			_ = _33_newItem
			var _34_dt__update__tmp_h1 m_ComAmazonawsDynamodbTypes.TransactWriteItem = _4_item
			_ = _34_dt__update__tmp_h1
			var _35_dt__update_hPut_h0 m_Wrappers.Option = _30_put
			_ = _35_dt__update_hPut_h0
			_33_newItem = m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItem_.Create_TransactWriteItem_((_34_dt__update__tmp_h1).Dtor_ConditionCheck(), _35_dt__update_hPut_h0, (_34_dt__update__tmp_h1).Dtor_Delete(), (_34_dt__update__tmp_h1).Dtor_Update())
			_2_result = _dafny.Companion_Sequence_.Concatenate(_2_result, _dafny.SeqOf(_33_newItem))
		} else {
			_2_result = _dafny.Companion_Sequence_.Concatenate(_2_result, _dafny.SeqOf(_4_item))
		}
	}
	var _36_valueOrError11 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _36_valueOrError11
	_36_valueOrError11 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((((input).Dtor_sdkInput()).Dtor_TransactItems()).Cardinality())).Cmp(_dafny.IntOfUint32((_2_result).Cardinality())) == 0, m_DdbMiddlewareConfig.Companion_Default___.E(_dafny.SeqOfString("")))
	if (_36_valueOrError11).IsFailure() {
		output = (_36_valueOrError11).PropagateFailure()
		return output
	}
	var _pat_let_tv2 = _2_result
	_ = _pat_let_tv2
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_TransactWriteItemsInputTransformOutput_.Create_TransactWriteItemsInputTransformOutput_(func(_pat_let37_0 m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput) m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput {
		return func(_37_dt__update__tmp_h2 m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput) m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput {
			return func(_pat_let38_0 _dafny.Sequence) m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput {
				return func(_38_dt__update_hTransactItems_h0 _dafny.Sequence) m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput {
					return m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsInput_.Create_TransactWriteItemsInput_(_38_dt__update_hTransactItems_h0, (_37_dt__update__tmp_h2).Dtor_ReturnConsumedCapacity(), (_37_dt__update__tmp_h2).Dtor_ReturnItemCollectionMetrics(), (_37_dt__update__tmp_h2).Dtor_ClientRequestToken())
				}(_pat_let38_0)
			}(_pat_let_tv2)
		}(_pat_let37_0)
	}((input).Dtor_sdkInput())))
	return output
	return output
}
func (_static *CompanionStruct_Default___) Output(config m_DdbMiddlewareConfig.Config, input m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsOutputTransformInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_TransactWriteItemsOutputTransformOutput_.Default())
	_ = output
	var _0_finalResult m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput
	_ = _0_finalResult
	_0_finalResult = (input).Dtor_sdkOutput()
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_TransactWriteItemsOutputTransformOutput_.Create_TransactWriteItemsOutputTransformOutput_(_0_finalResult))
	return output
	return output
}

// End of class Default__
