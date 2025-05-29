// Package SearchConfigToInfo
// Dafny module SearchConfigToInfo compiled into Go

package SearchConfigToInfo

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
	m_SortedSets "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/SortedSets"
	m_Sorting "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Sorting"
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
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
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/BaseBeacon"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m_CompoundBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/CompoundBeacon"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbVirtualFields"
	m_DynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBFilterExpr"
	m_DynamoDBSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBSupport"
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryption"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptorUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbNormalizeNumber"
	m_DynamoDbUpdateExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbUpdateExpr"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoToStruct"
	m_InternalLegacyOverride "github.com/aws/aws-database-encryption-sdk-dynamodb/InternalLegacyOverride"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/Maps_"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
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
	return "SearchConfigToInfo.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Convert(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_Wrappers.Companion_Option_.Default())
	_ = output
	if ((outer).Dtor_search()).Is_None() {
		output = m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
		return output
	} else {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(((((outer).Dtor_search()).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig)).Dtor_writeVersion()) == (int32(1)), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("writeVersion must be '1'.")))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _1_valueOrError1
		_1_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((((outer).Dtor_search()).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig)).Dtor_versions()).Cardinality())).Cmp(_dafny.One) == 0, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("search config must be have exactly one version.")))
		if (_1_valueOrError1).IsFailure() {
			output = (_1_valueOrError1).PropagateFailure()
			return output
		}
		var _2_beaconVersionConfig m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
		_ = _2_beaconVersionConfig
		_2_beaconVersionConfig = ((((outer).Dtor_search()).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig)).Dtor_versions()).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion)
		var _3_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError2
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.ConvertVersion(outer, _2_beaconVersionConfig)
		_3_valueOrError2 = _out0
		if (_3_valueOrError2).IsFailure() {
			output = (_3_valueOrError2).PropagateFailure()
			return output
		}
		var _4_version m_SearchableEncryptionInfo.BeaconVersion
		_ = _4_version
		_4_version = (_3_valueOrError2).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
		var _5_info m_SearchableEncryptionInfo.SearchInfo
		_ = _5_info
		_5_info = m_SearchableEncryptionInfo.Companion_Default___.MakeSearchInfo(_4_version)
		output = m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(_5_info))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) ShouldDeleteKeyField(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, keyFieldName _dafny.Sequence) m_Wrappers.Result {
	if !((outer).Dtor_attributeActionsOnEncrypt()).Contains(keyFieldName) {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	} else {
		var _source0 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction = ((outer).Dtor_attributeActionsOnEncrypt()).Get(keyFieldName).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)
		_ = _source0
		{
			if _source0.Is_DO__NOTHING() {
				return m_Wrappers.Companion_Result_.Create_Success_(true)
			}
		}
		{
			if _source0.Is_SIGN__ONLY() {
				return m_Wrappers.Companion_Result_.Create_Success_(false)
			}
		}
		{
			if _source0.Is_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT() {
				return m_Wrappers.Companion_Result_.Create_Success_(false)
			}
		}
		{
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon key field name "), keyFieldName), _dafny.SeqOfString(" is configured as ENCRYPT_AND_SIGN which is not allowed."))))
		}
	}
}
func (_static *CompanionStruct_Default___) MakeKeySource(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, keyStore m_AwsCryptographyKeyStoreTypes.IKeyStoreClient, config m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource, client *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_mplR m_Wrappers.Result
	_ = _0_mplR
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_0_mplR = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_mplR).MapFailure(func(coer129 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg163 interface{}) interface{} {
			return coer129(arg163.(m_AwsCryptographyMaterialProvidersTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		output = (_1_valueOrError0).PropagateFailure()
		return output
	}
	var _3_mpl *m_MaterialProviders.MaterialProvidersClient
	_ = _3_mpl
	_3_mpl = (_1_valueOrError0).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _4_cacheType m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _4_cacheType
	if (config).Is_multi() {
		if (((config).Dtor_multi()).Dtor_cache()).Is_Some() {
			_4_cacheType = (((config).Dtor_multi()).Dtor_cache()).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.CacheType)
		} else {
			_4_cacheType = m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_Default_(m_AwsCryptographyMaterialProvidersTypes.Companion_DefaultCache_.Create_DefaultCache_(int32(1000)))
		}
	} else if (((config).Dtor_single()).Dtor_cache()).Is_Some() {
		_4_cacheType = (((config).Dtor_single()).Dtor_cache()).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.CacheType)
	} else {
		_4_cacheType = m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_Default_(m_AwsCryptographyMaterialProvidersTypes.Companion_DefaultCache_.Create_DefaultCache_(int32(1)))
	}
	var _5_cache m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache = (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache)(nil)
	_ = _5_cache
	if (_4_cacheType).Is_Shared() {
		_5_cache = (_4_cacheType).Dtor_Shared()
	} else {
		var _6_input m_AwsCryptographyMaterialProvidersTypes.CreateCryptographicMaterialsCacheInput
		_ = _6_input
		_6_input = m_AwsCryptographyMaterialProvidersTypes.Companion_CreateCryptographicMaterialsCacheInput_.Create_CreateCryptographicMaterialsCacheInput_(_4_cacheType)
		var _7_maybeCache m_Wrappers.Result
		_ = _7_maybeCache
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = (_3_mpl).CreateCryptographicMaterialsCache(_6_input)
		_7_maybeCache = _out1
		var _8_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _8_valueOrError1
		_8_valueOrError1 = (_7_maybeCache).MapFailure(func(coer130 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg164 interface{}) interface{} {
				return coer130(arg164.(m_AwsCryptographyMaterialProvidersTypes.Error))
			}
		}(func(_9_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_9_e)
		}))
		if (_8_valueOrError1).IsFailure() {
			output = (_8_valueOrError1).PropagateFailure()
			return output
		}
		_5_cache = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.CastTo_((_8_valueOrError1).Extract())
	}
	var _10_partitionIdBytes _dafny.Sequence = _dafny.EmptySeq
	_ = _10_partitionIdBytes
	if ((config).Is_multi()) && ((((config).Dtor_multi()).Dtor_partitionId()).Is_Some()) {
		var _11_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _11_valueOrError2
		_11_valueOrError2 = (m_UTF8.Encode((((config).Dtor_multi()).Dtor_partitionId()).Dtor_value().(_dafny.Sequence))).MapFailure(func(coer131 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg165 interface{}) interface{} {
				return coer131(arg165.(_dafny.Sequence))
			}
		}(func(_12_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Could not UTF-8 Encode Partition ID from MultiKeyStore: "), _12_e))
		}))
		if (_11_valueOrError2).IsFailure() {
			output = (_11_valueOrError2).PropagateFailure()
			return output
		}
		_10_partitionIdBytes = (_11_valueOrError2).Extract().(_dafny.Sequence)
	} else if ((config).Is_single()) && ((((config).Dtor_single()).Dtor_partitionId()).Is_Some()) {
		var _13_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _13_valueOrError3
		_13_valueOrError3 = (m_UTF8.Encode((((config).Dtor_single()).Dtor_partitionId()).Dtor_value().(_dafny.Sequence))).MapFailure(func(coer132 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg166 interface{}) interface{} {
				return coer132(arg166.(_dafny.Sequence))
			}
		}(func(_14_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Could not UTF-8 Encode Partition ID from SingleKeyStore: "), _14_e))
		}))
		if (_13_valueOrError3).IsFailure() {
			output = (_13_valueOrError3).PropagateFailure()
			return output
		}
		_10_partitionIdBytes = (_13_valueOrError3).Extract().(_dafny.Sequence)
	} else {
		var _15_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _15_valueOrError4
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_SearchableEncryptionInfo.Companion_Default___.GenerateUuidBytes()
		_15_valueOrError4 = _out2
		if (_15_valueOrError4).IsFailure() {
			output = (_15_valueOrError4).PropagateFailure()
			return output
		}
		_10_partitionIdBytes = (_15_valueOrError4).Extract().(_dafny.Sequence)
	}
	var _16_getKeyStoreInfoOutput_q m_Wrappers.Result
	_ = _16_getKeyStoreInfoOutput_q
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (keyStore).GetKeyStoreInfo()
	_16_getKeyStoreInfoOutput_q = _out3
	var _17_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _17_valueOrError5
	_17_valueOrError5 = (_16_getKeyStoreInfoOutput_q).MapFailure(func(coer133 func(m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg167 interface{}) interface{} {
			return coer133(arg167.(m_AwsCryptographyKeyStoreTypes.Error))
		}
	}(func(_18_e m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyKeyStore_(_18_e)
	}))
	if (_17_valueOrError5).IsFailure() {
		output = (_17_valueOrError5).PropagateFailure()
		return output
	}
	var _19_getKeyStoreInfoOutput m_AwsCryptographyKeyStoreTypes.GetKeyStoreInfoOutput
	_ = _19_getKeyStoreInfoOutput
	_19_getKeyStoreInfoOutput = (_17_valueOrError5).Extract().(m_AwsCryptographyKeyStoreTypes.GetKeyStoreInfoOutput)
	var _20_logicalKeyStoreName _dafny.Sequence
	_ = _20_logicalKeyStoreName
	_20_logicalKeyStoreName = (_19_getKeyStoreInfoOutput).Dtor_logicalKeyStoreName()
	var _21_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _21_valueOrError6
	_21_valueOrError6 = (m_UTF8.Encode(_20_logicalKeyStoreName)).MapFailure(func(coer134 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg168 interface{}) interface{} {
			return coer134(arg168.(_dafny.Sequence))
		}
	}(func(_22_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Could not UTF-8 Encode Logical Key Store Name: "), _22_e))
	}))
	if (_21_valueOrError6).IsFailure() {
		output = (_21_valueOrError6).PropagateFailure()
		return output
	}
	var _23_logicalKeyStoreNameBytes _dafny.Sequence
	_ = _23_logicalKeyStoreNameBytes
	_23_logicalKeyStoreNameBytes = (_21_valueOrError6).Extract().(_dafny.Sequence)
	if (config).Is_multi() {
		var _24_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _24_valueOrError7
		_24_valueOrError7 = m_Wrappers.Companion_Default___.Need((int32(0)) < (((config).Dtor_multi()).Dtor_cacheTTL()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon Cache TTL must be at least 1.")))
		if (_24_valueOrError7).IsFailure() {
			output = (_24_valueOrError7).PropagateFailure()
			return output
		}
		var _25_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _25_valueOrError8
		_25_valueOrError8 = Companion_Default___.ShouldDeleteKeyField(outer, ((config).Dtor_multi()).Dtor_keyFieldName())
		if (_25_valueOrError8).IsFailure() {
			output = (_25_valueOrError8).PropagateFailure()
			return output
		}
		var _26_deleteKey bool
		_ = _26_deleteKey
		_26_deleteKey = (_25_valueOrError8).Extract().(bool)
		output = m_Wrappers.Companion_Result_.Create_Success_(m_SearchableEncryptionInfo.Companion_KeySource_.Create_KeySource_(client, keyStore, m_SearchableEncryptionInfo.Companion_KeyLocation_.Create_MultiLoc_(((config).Dtor_multi()).Dtor_keyFieldName(), _26_deleteKey), _5_cache, uint32(((config).Dtor_multi()).Dtor_cacheTTL()), _10_partitionIdBytes, _23_logicalKeyStoreNameBytes))
	} else {
		var _27_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _27_valueOrError9
		_27_valueOrError9 = m_Wrappers.Companion_Default___.Need((int32(0)) < (((config).Dtor_single()).Dtor_cacheTTL()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Beacon Cache TTL must be at least 1.")))
		if (_27_valueOrError9).IsFailure() {
			output = (_27_valueOrError9).PropagateFailure()
			return output
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(m_SearchableEncryptionInfo.Companion_KeySource_.Create_KeySource_(client, keyStore, m_SearchableEncryptionInfo.Companion_KeyLocation_.Create_SingleLoc_(((config).Dtor_single()).Dtor_keyId()), _5_cache, uint32(((config).Dtor_single()).Dtor_cacheTTL()), _10_partitionIdBytes, _23_logicalKeyStoreNameBytes))
	}
	return output
}
func (_static *CompanionStruct_Default___) ConvertVersion(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, config m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(((config).Dtor_version()) == (int32(1)), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Version number in BeaconVersion must be '1'.")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((config).Dtor_standardBeacons()).Cardinality())).Sign() == 1, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("At least one standard beacon must be configured.")))
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_maybePrimitives m_Wrappers.Result
	_ = _2_maybePrimitives
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_2_maybePrimitives = _out0
	var _3_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError2
	_3_valueOrError2 = (_2_maybePrimitives).MapFailure(func(coer135 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg169 interface{}) interface{} {
			return coer135(arg169.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_4_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_4_e)
	}))
	if (_3_valueOrError2).IsFailure() {
		output = (_3_valueOrError2).PropagateFailure()
		return output
	}
	var _5_primitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _5_primitives
	_5_primitives = (_3_valueOrError2).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _6_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _6_valueOrError3
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = Companion_Default___.MakeKeySource(outer, (config).Dtor_keyStore(), (config).Dtor_keySource(), _5_primitives)
	_6_valueOrError3 = _out1
	if (_6_valueOrError3).IsFailure() {
		output = (_6_valueOrError3).PropagateFailure()
		return output
	}
	var _7_source m_SearchableEncryptionInfo.KeySource
	_ = _7_source
	_7_source = (_6_valueOrError3).Extract().(m_SearchableEncryptionInfo.KeySource)
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = Companion_Default___.ConvertVersionWithSource(outer, config, _7_source)
	output = _out2
	return output
}
func (_static *CompanionStruct_Default___) ConvertVersionWithSource(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, config m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion, source m_SearchableEncryptionInfo.KeySource) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _0_valueOrError0
	_0_valueOrError0 = Companion_Default___.ConvertVirtualFields(outer, (config).Dtor_virtualFields())
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_virtualFields _dafny.Map
	_ = _1_virtualFields
	_1_virtualFields = (_0_valueOrError0).Extract().(_dafny.Map)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.AddStandardBeacons((config).Dtor_standardBeacons(), outer, (source).Dtor_client(), _1_virtualFields, _dafny.NewMapBuilder().ToMap())
	_2_valueOrError1 = _out0
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _3_std _dafny.Map
	_ = _3_std
	_3_std = (_2_valueOrError1).Extract().(_dafny.Map)
	var _4_signed _dafny.Sequence
	_ = _4_signed
	if ((config).Dtor_signedParts()).Is_Some() {
		_4_signed = ((config).Dtor_signedParts()).Dtor_value().(_dafny.Sequence)
	} else {
		_4_signed = _dafny.SeqOf()
	}
	var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_PartSet_.Default())
	_ = _5_valueOrError2
	_5_valueOrError2 = Companion_Default___.GetSignedParts(_4_signed, outer, _dafny.SeqOfString("Global Parts List"), Companion_PartSet_.Create_PartSet_(_dafny.SeqOf(), _dafny.SetOf(), _dafny.SetOf()))
	if (_5_valueOrError2).IsFailure() {
		output = (_5_valueOrError2).PropagateFailure()
		return output
	}
	var _6_globalSignedParts PartSet
	_ = _6_globalSignedParts
	_6_globalSignedParts = (_5_valueOrError2).Extract().(PartSet)
	var _7_globalEncryptedParts PartSet
	_ = _7_globalEncryptedParts
	_7_globalEncryptedParts = Companion_PartSet_.Create_PartSet_(_dafny.SeqOf(), _dafny.SetOf(), _dafny.SetOf())
	if ((config).Dtor_encryptedParts()).Is_Some() {
		var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_PartSet_.Default())
		_ = _8_valueOrError3
		_8_valueOrError3 = Companion_Default___.GetEncryptedParts(((config).Dtor_encryptedParts()).Dtor_value().(_dafny.Sequence), _3_std, _dafny.SeqOfString("Global Parts List"), Companion_PartSet_.Create_PartSet_(_dafny.SeqOf(), _dafny.SetOf(), _dafny.SetOf()))
		if (_8_valueOrError3).IsFailure() {
			output = (_8_valueOrError3).PropagateFailure()
			return output
		}
		_7_globalEncryptedParts = (_8_valueOrError3).Extract().(PartSet)
	}
	var _9_beacons _dafny.Map = _dafny.EmptyMap
	_ = _9_beacons
	if ((config).Dtor_compoundBeacons()).Is_Some() {
		var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _10_valueOrError4
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.AddCompoundBeacons(((config).Dtor_compoundBeacons()).Dtor_value().(_dafny.Sequence), outer, (source).Dtor_client(), _1_virtualFields, _3_std, _6_globalSignedParts, _7_globalEncryptedParts)
		_10_valueOrError4 = _out1
		if (_10_valueOrError4).IsFailure() {
			output = (_10_valueOrError4).PropagateFailure()
			return output
		}
		_9_beacons = (_10_valueOrError4).Extract().(_dafny.Map)
	} else {
		_9_beacons = _3_std
	}
	var _11_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = _11_valueOrError5
	_11_valueOrError5 = Companion_Default___.CheckBeacons(_9_beacons)
	if (_11_valueOrError5).IsFailure() {
		output = (_11_valueOrError5).PropagateFailure()
		return output
	}
	var _12___v0 bool
	_ = _12___v0
	_12___v0 = (_11_valueOrError5).Extract().(bool)
	if ((source).Dtor_keyLoc()).Is_MultiLoc() {
		var _13_name _dafny.Sequence
		_ = _13_name
		_13_name = ((source).Dtor_keyLoc()).Dtor_keyName()
		if (_9_beacons).Contains(_13_name) {
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("A beacon key field name of "), _13_name), _dafny.SeqOfString(" was configured, but there's also a beacon of that name."))))
			return output
		}
		if (_1_virtualFields).Contains(_13_name) {
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("A beacon key field name of "), _13_name), _dafny.SeqOfString(" was configured, but there's also a virtual field of that name."))))
			return output
		}
	}
	output = m_SearchableEncryptionInfo.Companion_Default___.MakeBeaconVersion(uint8((config).Dtor_version()), source, _9_beacons, _1_virtualFields, (outer).Dtor_attributeActionsOnEncrypt())
	return output
	return output
}
func (_static *CompanionStruct_Default___) ConvertVirtualFields(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, vf m_Wrappers.Option) m_Wrappers.Result {
	if (vf).Is_None() {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.NewMapBuilder().ToMap())
	} else {
		return Companion_Default___.AddVirtualFields((vf).Dtor_value().(_dafny.Sequence), outer, _dafny.NewMapBuilder().ToMap())
	}
}
func (_static *CompanionStruct_Default___) IsSigned(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, loc _dafny.Sequence) bool {
	var _pat_let_tv0 = outer
	_ = _pat_let_tv0
	var _pat_let_tv1 = outer
	_ = _pat_let_tv1
	return (true) && (func(_pat_let20_0 _dafny.Sequence) bool {
		return func(_0_name _dafny.Sequence) bool {
			return (((_pat_let_tv0).Dtor_attributeActionsOnEncrypt()).Contains(_0_name)) && (!(((_pat_let_tv1).Dtor_attributeActionsOnEncrypt()).Get(_0_name).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()))
		}(_pat_let20_0)
	}(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key()))
}
func (_static *CompanionStruct_Default___) IsSignOnly(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, loc _dafny.Sequence) bool {
	var _pat_let_tv0 = outer
	_ = _pat_let_tv0
	var _pat_let_tv1 = outer
	_ = _pat_let_tv1
	var _pat_let_tv2 = outer
	_ = _pat_let_tv2
	return (true) && (func(_pat_let21_0 _dafny.Sequence) bool {
		return func(_0_name _dafny.Sequence) bool {
			return (((_pat_let_tv0).Dtor_attributeActionsOnEncrypt()).Contains(_0_name)) && (((((_pat_let_tv1).Dtor_attributeActionsOnEncrypt()).Get(_0_name).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_())) || ((((_pat_let_tv2).Dtor_attributeActionsOnEncrypt()).Get(_0_name).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_())))
		}(_pat_let21_0)
	}(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key()))
}
func (_static *CompanionStruct_Default___) IsEncrypted(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, loc _dafny.Sequence) bool {
	var _pat_let_tv0 = outer
	_ = _pat_let_tv0
	var _pat_let_tv1 = outer
	_ = _pat_let_tv1
	return (true) && (func(_pat_let22_0 _dafny.Sequence) bool {
		return func(_0_name _dafny.Sequence) bool {
			return (((_pat_let_tv0).Dtor_attributeActionsOnEncrypt()).Contains(_0_name)) && ((((_pat_let_tv1).Dtor_attributeActionsOnEncrypt()).Get(_0_name).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()))
		}(_pat_let22_0)
	}(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key()))
}
func (_static *CompanionStruct_Default___) IsEncryptedV(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, virtualFields _dafny.Map, loc _dafny.Sequence) bool {
	return (Companion_Default___.IsEncrypted(outer, loc)) || (((virtualFields).Contains(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key())) && (((virtualFields).Get(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key()).(m_DdbVirtualFields.VirtField)).Examine((func(_0_outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig) func(_dafny.Sequence) bool {
		return func(_1_t _dafny.Sequence) bool {
			return Companion_Default___.IsEncrypted(_0_outer, _1_t)
		}
	})(outer))))
}
func (_static *CompanionStruct_Default___) BeaconNameAllowed(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, virtualFields _dafny.Map, name _dafny.Sequence, context _dafny.Sequence, isSignedBeacon bool) m_Wrappers.Result {
	if (((outer).Dtor_attributeActionsOnEncrypt()).Contains(name)) && (!(((outer).Dtor_attributeActionsOnEncrypt()).Get(name).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a ")), context), _dafny.SeqOfString(" because it is already an unencrypted attribute."))))
	} else if (isSignedBeacon) && (((outer).Dtor_attributeActionsOnEncrypt()).Contains(name)) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a ")), context), _dafny.SeqOfString(" because a fully signed beacon cannot have the same name as an existing attribute."))))
	} else if (((outer).Dtor_allowedUnsignedAttributes()).Is_Some()) && (_dafny.Companion_Sequence_.Contains(((outer).Dtor_allowedUnsignedAttributes()).Dtor_value().(_dafny.Sequence), name)) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a ")), context), _dafny.SeqOfString(" because it is already an allowed unauthenticated attribute."))))
	} else if (((outer).Dtor_allowedUnsignedAttributePrefix()).Is_Some()) && (_dafny.Companion_Sequence_.IsPrefixOf(((outer).Dtor_allowedUnsignedAttributePrefix()).Dtor_value().(_dafny.Sequence), name)) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a ")), context), _dafny.SeqOfString(" because it begins with the allowed unauthenticated prefix."))))
	} else if _dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.ReservedPrefix(), name) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a ")), context), _dafny.SeqOfString(" because it begins with the reserved prefix."))))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	}
}
func (_static *CompanionStruct_Default___) VirtualFieldNameAllowed(outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, name _dafny.Sequence) m_Wrappers.Result {
	if ((outer).Dtor_attributeActionsOnEncrypt()).Contains(name) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a Virtual Field because it is already a configured attribute."))))
	} else if (((outer).Dtor_allowedUnsignedAttributes()).Is_Some()) && (_dafny.Companion_Sequence_.Contains(((outer).Dtor_allowedUnsignedAttributes()).Dtor_value().(_dafny.Sequence), name)) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a Virtual Field because it is already an allowed unauthenticated attribute."))))
	} else if (((outer).Dtor_allowedUnsignedAttributePrefix()).Is_Some()) && (_dafny.Companion_Sequence_.IsPrefixOf(((outer).Dtor_allowedUnsignedAttributePrefix()).Dtor_value().(_dafny.Sequence), name)) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a Virtual Field because it begins with the allowed unauthenticated prefix."))))
	} else if _dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.ReservedPrefix(), name) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" not allowed as a Virtual Field because it begins with the reserved prefix."))))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	}
}
func (_static *CompanionStruct_Default___) FindVirtualFieldWithThisLocation(fields _dafny.Map, locs _dafny.Set) m_Wrappers.Option {
	var _0_badNames _dafny.Set = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter27 := _dafny.Iterate((fields).Keys().Elements()); ; {
			_compr_0, _ok27 := _iter27()
			if !_ok27 {
				break
			}
			var _1_b _dafny.Sequence
			_1_b = interface{}(_compr_0).(_dafny.Sequence)
			if ((fields).Contains(_1_b)) && ((((fields).Get(_1_b).(m_DdbVirtualFields.VirtField)).GetLocs()).Equals(locs)) {
				_coll0.Add(_1_b)
			}
		}
		return _coll0.ToSet()
	}()
	_ = _0_badNames
	if ((_0_badNames).Cardinality()).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _2_badSeq _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_0_badNames, func(coer136 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg170 interface{}, arg171 interface{}) bool {
				return coer136(arg170.(_dafny.Char), arg171.(_dafny.Char))
			}
		}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
		_ = _2_badSeq
		return m_Wrappers.Companion_Option_.Create_Some_((_2_badSeq).Select(0).(_dafny.Sequence))
	}
}
func (_static *CompanionStruct_Default___) ExistsConstructorWithTheseRequired(cons _dafny.Sequence, locs _dafny.Set) bool {
	return (Companion_Default___.SeqCount(func(coer137 func(m_CompoundBeacon.Constructor) bool) func(interface{}) bool {
		return func(arg172 interface{}) bool {
			return coer137(arg172.(m_CompoundBeacon.Constructor))
		}
	}((func(_0_locs _dafny.Set) func(m_CompoundBeacon.Constructor) bool {
		return func(_1_c m_CompoundBeacon.Constructor) bool {
			return ((_1_c).GetReqParts()).Equals(_0_locs)
		}
	})(locs)), cons)).Sign() == 1
}
func (_static *CompanionStruct_Default___) GetPartsString(c m_CompoundBeacon.Constructor) _dafny.Sequence {
	var _0_req _dafny.Sequence = m_Seq.Companion_Default___.Filter(func(coer138 func(m_CompoundBeacon.ConstructorPart) bool) func(interface{}) bool {
		return func(arg173 interface{}) bool {
			return coer138(arg173.(m_CompoundBeacon.ConstructorPart))
		}
	}(func(_1_p m_CompoundBeacon.ConstructorPart) bool {
		return (_1_p).Dtor_required()
	}), (c).Dtor_parts())
	_ = _0_req
	var _2_names _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer139 func(m_CompoundBeacon.ConstructorPart) _dafny.Sequence) func(interface{}) interface{} {
		return func(arg174 interface{}) interface{} {
			return coer139(arg174.(m_CompoundBeacon.ConstructorPart))
		}
	}(func(_3_p m_CompoundBeacon.ConstructorPart) _dafny.Sequence {
		return ((_3_p).Dtor_part()).GetName()
	}), _0_req)
	_ = _2_names
	if (_dafny.IntOfUint32((_2_names).Cardinality())).Sign() == 0 {
		return _dafny.SeqOfString("")
	} else {
		return m_StandardLibrary.Companion_Default___.Join(_2_names, _dafny.SeqOfString(", "))
	}
}
func (_static *CompanionStruct_Default___) AddVirtualFields(vf _dafny.Sequence, outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, converted _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((vf).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(converted)
	} else {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!(converted).Contains(((vf).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField)).Dtor_name()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate VirtualField name : "), ((vf).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField)).Dtor_name())))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.VirtualFieldNameAllowed(outer, ((vf).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField)).Dtor_name())
			_ = _1_valueOrError1
			if (_1_valueOrError1).IsFailure() {
				return (_1_valueOrError1).PropagateFailure()
			} else {
				var _2___v1 bool = (_1_valueOrError1).Extract().(bool)
				_ = _2___v1
				var _3_valueOrError2 m_Wrappers.Result = m_DdbVirtualFields.Companion_Default___.ParseVirtualFieldConfig((vf).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField))
				_ = _3_valueOrError2
				if (_3_valueOrError2).IsFailure() {
					return (_3_valueOrError2).PropagateFailure()
				} else {
					var _4_newField m_DdbVirtualFields.VirtField = (_3_valueOrError2).Extract().(m_DdbVirtualFields.VirtField)
					_ = _4_newField
					var _5_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!((_4_newField).Examine((func(_6_outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig) func(_dafny.Sequence) bool {
						return func(_7_t _dafny.Sequence) bool {
							return !(Companion_Default___.IsSigned(_6_outer, _7_t))
						}
					})(outer))), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("VirtualField "), ((vf).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField)).Dtor_name()), _dafny.SeqOfString(" must be defined on signed fields."))))
					_ = _5_valueOrError3
					if (_5_valueOrError3).IsFailure() {
						return (_5_valueOrError3).PropagateFailure()
					} else {
						var _8_badField m_Wrappers.Option = Companion_Default___.FindVirtualFieldWithThisLocation(converted, (_4_newField).GetLocs())
						_ = _8_badField
						if (_8_badField).Is_Some() {
							return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Virtual field "), ((vf).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField)).Dtor_name()), _dafny.SeqOfString(" is defined on the same locations as ")), (_8_badField).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString("."))))
						} else {
							var _in0 _dafny.Sequence = (vf).Drop(1)
							_ = _in0
							var _in1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = outer
							_ = _in1
							var _in2 _dafny.Map = (converted).Update(((vf).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField)).Dtor_name(), _4_newField)
							_ = _in2
							vf = _in0
							outer = _in1
							converted = _in2
							goto TAIL_CALL_START
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) FindBeaconWithThisLocation(beacons _dafny.Map, loc _dafny.Sequence) m_Wrappers.Option {
	var _0_badNames _dafny.Set = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter28 := _dafny.Iterate((beacons).Keys().Elements()); ; {
			_compr_0, _ok28 := _iter28()
			if !_ok28 {
				break
			}
			var _1_b _dafny.Sequence
			_1_b = interface{}(_compr_0).(_dafny.Sequence)
			if (((beacons).Contains(_1_b)) && (((beacons).Get(_1_b).(m_SearchableEncryptionInfo.Beacon)).Is_Standard())) && (_dafny.Companion_Sequence_.Equal((((beacons).Get(_1_b).(m_SearchableEncryptionInfo.Beacon)).Dtor_std()).Dtor_loc(), loc)) {
				_coll0.Add(_1_b)
			}
		}
		return _coll0.ToSet()
	}()
	_ = _0_badNames
	if ((_0_badNames).Cardinality()).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _2_badSeq _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_0_badNames, func(coer140 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg175 interface{}, arg176 interface{}) bool {
				return coer140(arg175.(_dafny.Char), arg176.(_dafny.Char))
			}
		}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
		_ = _2_badSeq
		return m_Wrappers.Companion_Option_.Create_Some_((_2_badSeq).Select(0).(_dafny.Sequence))
	}
}
func (_static *CompanionStruct_Default___) IsValidShare(converted _dafny.Map, name _dafny.Sequence, length uint8, share _dafny.Sequence) m_Wrappers.Result {
	if (converted).Contains(share) {
		var _0_tb m_SearchableEncryptionInfo.Beacon = (converted).Get(share).(m_SearchableEncryptionInfo.Beacon)
		_ = _0_tb
		if (_0_tb).Is_Standard() {
			if (((_0_tb).Dtor_std()).Dtor_share()).Is_Some() {
				if _dafny.Companion_Sequence_.Equal(name, share) {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon "), name), _dafny.SeqOfString(" is shared to itself."))))
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon "), name), _dafny.SeqOfString(" is shared to ")), share), _dafny.SeqOfString(" which is in turn shared to ")), (((_0_tb).Dtor_std()).Dtor_share()).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString(". Share chains are not allowed."))))
				}
			} else if (((_0_tb).Dtor_std()).Dtor_length()) == (length) {
				return m_Wrappers.Companion_Result_.Create_Success_(true)
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon "), name), _dafny.SeqOfString(" is shared to ")), share), _dafny.SeqOfString(" but ")), name), _dafny.SeqOfString(" has length ")), m_StandardLibrary_String.Companion_Default___.Base10Int2String(_dafny.IntOfUint8(length))), _dafny.SeqOfString(" and ")), share), _dafny.SeqOfString(" has length ")), m_StandardLibrary_String.Companion_Default___.Base10Int2String(_dafny.IntOfUint8(((_0_tb).Dtor_std()).Dtor_length()))), _dafny.SeqOfString("."))))
			}
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon "), name), _dafny.SeqOfString(" is shared to ")), share), _dafny.SeqOfString(" but ")), share), _dafny.SeqOfString(" is a compound beacon."))))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon "), name), _dafny.SeqOfString(" is shared to ")), share), _dafny.SeqOfString(" which is not defined."))))
	}
}
func (_static *CompanionStruct_Default___) AddStandardBeacons(beacons _dafny.Sequence, outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, client *m_AtomicPrimitives.AtomicPrimitivesClient, virtualFields _dafny.Map, converted _dafny.Map) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	if (_dafny.IntOfUint32((beacons).Cardinality())).Sign() == 0 {
		output = m_Wrappers.Companion_Result_.Create_Success_(converted)
		return output
	}
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(!(converted).Contains(((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate StandardBeacon name : "), ((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name())))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = _1_valueOrError1
	_1_valueOrError1 = Companion_Default___.BeaconNameAllowed(outer, virtualFields, ((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name(), _dafny.SeqOfString("StandardBeacon"), false)
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2___v2 bool
	_ = _2___v2
	_2___v2 = (_1_valueOrError1).Extract().(bool)
	var _3_locString _dafny.Sequence
	_ = _3_locString
	_3_locString = Companion_Default___.GetLocStr(((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name(), ((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_loc())
	var _4_isPartOnly bool
	_ = _4_isPartOnly
	_4_isPartOnly = false
	var _5_isAsSet bool
	_ = _5_isAsSet
	_5_isAsSet = false
	var _6_share m_Wrappers.Option
	_ = _6_share
	_6_share = m_Wrappers.Companion_Option_.Create_None_()
	if (((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_style()).Is_Some() {
		var _source0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle = (((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_style()).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle)
		_ = _source0
		{
			{
				if _source0.Is_partOnly() {
					var _7_t m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PartOnly = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle_partOnly).PartOnly
					_ = _7_t
					_4_isPartOnly = true
					goto Lmatch0
				}
			}
			{
				if _source0.Is_shared() {
					var _8_t m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Shared = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle_shared).Shared
					_ = _8_t
					_6_share = m_Wrappers.Companion_Option_.Create_Some_((_8_t).Dtor_other())
					goto Lmatch0
				}
			}
			{
				if _source0.Is_asSet() {
					var _9_t m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.AsSet = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle_asSet).AsSet
					_ = _9_t
					_5_isAsSet = true
					goto Lmatch0
				}
			}
			{
				var _10_t m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SharedSet = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconStyle_sharedSet).SharedSet
				_ = _10_t
				_6_share = m_Wrappers.Companion_Option_.Create_Some_((_10_t).Dtor_other())
				_5_isAsSet = true
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _11_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _11_valueOrError2
	_11_valueOrError2 = m_BaseBeacon.Companion_Default___.MakeStandardBeacon(client, ((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name(), uint8(((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_length()), _3_locString, _4_isPartOnly, _5_isAsSet, _6_share)
	if (_11_valueOrError2).IsFailure() {
		output = (_11_valueOrError2).PropagateFailure()
		return output
	}
	var _12_newBeacon m_BaseBeacon.StandardBeacon
	_ = _12_newBeacon
	_12_newBeacon = (_11_valueOrError2).Extract().(m_BaseBeacon.StandardBeacon)
	var _13_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _13_valueOrError3
	_13_valueOrError3 = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsEncryptedV(outer, virtualFields, (_12_newBeacon).Dtor_loc()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("StandardBeacon "), ((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name()), _dafny.SeqOfString(" not defined on an encrypted field."))))
	if (_13_valueOrError3).IsFailure() {
		output = (_13_valueOrError3).PropagateFailure()
		return output
	}
	var _14_badBeacon m_Wrappers.Option
	_ = _14_badBeacon
	_14_badBeacon = Companion_Default___.FindBeaconWithThisLocation(converted, (_12_newBeacon).Dtor_loc())
	if (_14_badBeacon).Is_Some() {
		output = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon "), ((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name()), _dafny.SeqOfString(" is defined on location ")), m_TermLoc.Companion_Default___.TermLocToString((_12_newBeacon).Dtor_loc())), _dafny.SeqOfString(", but beacon ")), (_14_badBeacon).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString(" is already defined on that location."))))
		return output
	}
	var _15_badField m_Wrappers.Option
	_ = _15_badField
	_15_badField = Companion_Default___.FindVirtualFieldWithThisLocation(virtualFields, _dafny.SetOf((_12_newBeacon).Dtor_loc()))
	if (_15_badField).Is_Some() {
		output = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon "), ((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name()), _dafny.SeqOfString(" is defined on location ")), m_TermLoc.Companion_Default___.TermLocToString((_12_newBeacon).Dtor_loc())), _dafny.SeqOfString(", but virtual field ")), (_15_badField).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString(" is already defined on that single location."))))
		return output
	}
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.AddStandardBeacons((beacons).Drop(1), outer, client, virtualFields, (converted).Update(((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)).Dtor_name(), m_SearchableEncryptionInfo.Companion_Beacon_.Create_Standard_(_12_newBeacon)))
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) GetLoc(name _dafny.Sequence, loc m_Wrappers.Option) m_Wrappers.Result {
	if (loc).Is_None() {
		return m_Wrappers.Companion_Result_.Create_Success_(m_TermLoc.Companion_Default___.TermLocMap(name))
	} else {
		return m_TermLoc.Companion_Default___.MakeTermLoc((loc).Dtor_value().(_dafny.Sequence))
	}
}
func (_static *CompanionStruct_Default___) GetLocStr(name _dafny.Sequence, loc m_Wrappers.Option) _dafny.Sequence {
	if (loc).Is_None() {
		return name
	} else {
		return (loc).Dtor_value().(_dafny.Sequence)
	}
}
func (_static *CompanionStruct_Default___) GetSignedParts(parts _dafny.Sequence, outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, name _dafny.Sequence, converted PartSet) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((parts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(converted)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetLoc(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_name(), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_loc())
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_loc _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_loc
			var _2_newPart m_CompoundBeacon.BeaconPart = m_CompoundBeacon.Companion_BeaconPart_.Create_Signed_(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_prefix(), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_name(), _1_loc)
			_ = _2_newPart
			var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsSignOnly(outer, (_2_newPart).Dtor_loc()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Signed Part "), (_2_newPart).Dtor_name()), _dafny.SeqOfString(" is built from ")), Companion_Default___.GetLocStr(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_name(), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_loc())), _dafny.SeqOfString(" which is not SIGN_ONLY."))))
			_ = _3_valueOrError1
			if (_3_valueOrError1).IsFailure() {
				return (_3_valueOrError1).PropagateFailure()
			} else {
				var _4_valueOrError2 m_Wrappers.Result = (converted).Add(_2_newPart, name)
				_ = _4_valueOrError2
				if (_4_valueOrError2).IsFailure() {
					return (_4_valueOrError2).PropagateFailure()
				} else {
					var _5_newParts PartSet = (_4_valueOrError2).Extract().(PartSet)
					_ = _5_newParts
					var _in0 _dafny.Sequence = (parts).Drop(1)
					_ = _in0
					var _in1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig = outer
					_ = _in1
					var _in2 _dafny.Sequence = name
					_ = _in2
					var _in3 PartSet = _5_newParts
					_ = _in3
					parts = _in0
					outer = _in1
					name = _in2
					converted = _in3
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) GetEncryptedParts(parts _dafny.Sequence, std _dafny.Map, name _dafny.Sequence, converted PartSet) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((parts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(converted)
	} else if (((std).Contains(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name())) && (((std).Get(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()).(m_SearchableEncryptionInfo.Beacon)).Is_Standard())) && ((((std).Get(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()).(m_SearchableEncryptionInfo.Beacon)).Dtor_std()).Dtor_asSet()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" uses ")), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()), _dafny.SeqOfString(" which is an AsSet beacon, and therefore cannot be used in a Compound Beacon."))))
	} else if ((std).Contains(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name())) && (((std).Get(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()).(m_SearchableEncryptionInfo.Beacon)).Is_Standard()) {
		var _0_newPart m_CompoundBeacon.BeaconPart = m_CompoundBeacon.Companion_BeaconPart_.Create_Encrypted_(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_prefix(), ((std).Get(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()).(m_SearchableEncryptionInfo.Beacon)).Dtor_std())
		_ = _0_newPart
		var _1_valueOrError0 m_Wrappers.Result = (converted).Add(_0_newPart, name)
		_ = _1_valueOrError0
		if (_1_valueOrError0).IsFailure() {
			return (_1_valueOrError0).PropagateFailure()
		} else {
			var _2_newParts PartSet = (_1_valueOrError0).Extract().(PartSet)
			_ = _2_newParts
			var _in0 _dafny.Sequence = (parts).Drop(1)
			_ = _in0
			var _in1 _dafny.Map = std
			_ = _in1
			var _in2 _dafny.Sequence = name
			_ = _in2
			var _in3 PartSet = _2_newParts
			_ = _in3
			parts = _in0
			std = _in1
			name = _in2
			converted = _in3
			goto TAIL_CALL_START
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(name, _dafny.SeqOfString(" refers to standard beacon ")), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()), _dafny.SeqOfString(" which is not configured."))))
	}
}
func (_static *CompanionStruct_Default___) MakeDefaultConstructor(parts _dafny.Sequence, converted _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((parts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(m_CompoundBeacon.Companion_Constructor_.Create_Constructor_(converted)))
	} else {
		var _in0 _dafny.Sequence = (parts).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(converted, _dafny.SeqOf(m_CompoundBeacon.Companion_ConstructorPart_.Create_ConstructorPart_((parts).Select(0).(m_CompoundBeacon.BeaconPart), true)))
		_ = _in1
		parts = _in0
		converted = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) MyFilter(f func(interface{}) bool, xs _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, (func() _dafny.Sequence {
			if (f)((xs).Select(0).(interface{})) {
				return _dafny.SeqOf((xs).Select(0).(interface{}))
			}
			return _dafny.SeqOf()
		})())
		var _in0 func(interface{}) bool = f
		_ = _in0
		var _in1 _dafny.Sequence = (xs).Drop(1)
		_ = _in1
		f = _in0
		xs = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) SeqCount(f func(interface{}) bool, xs _dafny.Sequence) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else {
		_0___accumulator = (_0___accumulator).Plus((func() _dafny.Int {
			if (f)((xs).Select(0).(interface{})) {
				return _dafny.One
			}
			return _dafny.Zero
		})())
		var _in0 func(interface{}) bool = f
		_ = _in0
		var _in1 _dafny.Sequence = (xs).Drop(1)
		_ = _in1
		f = _in0
		xs = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) MakeConstructor2(c _dafny.Sequence, parts _dafny.Sequence, origSize _dafny.Int, converted _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((c).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(converted)
	} else {
		var _0_thePart _dafny.Sequence = Companion_Default___.MyFilter(func(coer141 func(m_CompoundBeacon.BeaconPart) bool) func(interface{}) bool {
			return func(arg177 interface{}) bool {
				return coer141(arg177.(m_CompoundBeacon.BeaconPart))
			}
		}((func(_1_c _dafny.Sequence) func(m_CompoundBeacon.BeaconPart) bool {
			return func(_2_p m_CompoundBeacon.BeaconPart) bool {
				return _dafny.Companion_Sequence_.Equal((_2_p).GetName(), ((_1_c).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart)).Dtor_name())
			}
		})(c)), parts)
		_ = _0_thePart
		var _3_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_0_thePart).Cardinality())).Sign() == 1, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Constructor refers to part name "), ((c).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart)).Dtor_name()), _dafny.SeqOfString(" but there is no part by that name."))))
		_ = _3_valueOrError0
		if (_3_valueOrError0).IsFailure() {
			return (_3_valueOrError0).PropagateFailure()
		} else {
			var _4_newPart m_CompoundBeacon.ConstructorPart = m_CompoundBeacon.Companion_ConstructorPart_.Create_ConstructorPart_((_0_thePart).Select(0).(m_CompoundBeacon.BeaconPart), ((c).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart)).Dtor_required())
			_ = _4_newPart
			var _in0 _dafny.Sequence = (c).Drop(1)
			_ = _in0
			var _in1 _dafny.Sequence = parts
			_ = _in1
			var _in2 _dafny.Int = origSize
			_ = _in2
			var _in3 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(converted, _dafny.SeqOf(_4_newPart))
			_ = _in3
			c = _in0
			parts = _in1
			origSize = _in2
			converted = _in3
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) MakeConstructor(c m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Constructor, parts _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.MakeConstructor2((c).Dtor_parts(), parts, _dafny.IntOfUint32(((c).Dtor_parts()).Cardinality()), _dafny.SeqOf())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_newParts _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_newParts
		return m_Wrappers.Companion_Result_.Create_Success_(m_CompoundBeacon.Companion_Constructor_.Create_Constructor_(_1_newParts))
	}
}
func (_static *CompanionStruct_Default___) AddConstructors2(constructors _dafny.Sequence, name _dafny.Sequence, parts _dafny.Sequence, origSize _dafny.Int, converted _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((constructors).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(converted)
	} else {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((((constructors).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Constructor)).Dtor_parts()).Cardinality())).Sign() == 1, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Every constructor must have at least one part.")))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((Companion_Default___.SeqCount(func(coer142 func(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart) bool) func(interface{}) bool {
				return func(arg178 interface{}) bool {
					return coer142(arg178.(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart))
				}
			}(func(_2_p m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart) bool {
				return (_2_p).Dtor_required()
			}), ((constructors).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Constructor)).Dtor_parts())).Sign() == 1, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("A Constructor for beacon "), name), _dafny.SeqOfString(" lacks any required parts"))))
			_ = _1_valueOrError1
			if (_1_valueOrError1).IsFailure() {
				return (_1_valueOrError1).PropagateFailure()
			} else {
				var _3_valueOrError2 m_Wrappers.Result = Companion_Default___.MakeConstructor((constructors).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Constructor), parts)
				_ = _3_valueOrError2
				if (_3_valueOrError2).IsFailure() {
					return (_3_valueOrError2).PropagateFailure()
				} else {
					var _4_c m_CompoundBeacon.Constructor = (_3_valueOrError2).Extract().(m_CompoundBeacon.Constructor)
					_ = _4_c
					if Companion_Default___.ExistsConstructorWithTheseRequired(converted, (_4_c).GetReqParts()) {
						var _5_p _dafny.Sequence = Companion_Default___.GetPartsString(_4_c)
						_ = _5_p
						return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Multiple constructors for "), name), _dafny.SeqOfString(" have the same set of required parts : ")), _5_p)))
					} else {
						var _in0 _dafny.Sequence = (constructors).Drop(1)
						_ = _in0
						var _in1 _dafny.Sequence = name
						_ = _in1
						var _in2 _dafny.Sequence = parts
						_ = _in2
						var _in3 _dafny.Int = origSize
						_ = _in3
						var _in4 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(converted, _dafny.SeqOf(_4_c))
						_ = _in4
						constructors = _in0
						name = _in1
						parts = _in2
						origSize = _in3
						converted = _in4
						goto TAIL_CALL_START
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) AddConstructors(constructors m_Wrappers.Option, name _dafny.Sequence, parts _dafny.Sequence) m_Wrappers.Result {
	if (constructors).Is_None() {
		return Companion_Default___.MakeDefaultConstructor(parts, _dafny.SeqOf())
	} else {
		return Companion_Default___.AddConstructors2((constructors).Dtor_value().(_dafny.Sequence), name, parts, _dafny.IntOfUint32(((constructors).Dtor_value().(_dafny.Sequence)).Cardinality()), _dafny.SeqOf())
	}
}
func (_static *CompanionStruct_Default___) GetGlobalPartsFrom(cons _dafny.Sequence, globalParts PartSet, signed bool, parts PartSet) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((cons).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(parts)
	} else {
		var _0_newPart m_Wrappers.Option = Companion_Default___.FindGlobalPart((globalParts).Dtor_parts(), (cons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart), signed)
		_ = _0_newPart
		if (_0_newPart).Is_Some() {
			var _1_valueOrError0 m_Wrappers.Result = (parts).Add((_0_newPart).Dtor_value().(m_CompoundBeacon.BeaconPart), _dafny.SeqOfString("Global Parts List"))
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _2_newParts PartSet = (_1_valueOrError0).Extract().(PartSet)
				_ = _2_newParts
				var _in0 _dafny.Sequence = (cons).Drop(1)
				_ = _in0
				var _in1 PartSet = globalParts
				_ = _in1
				var _in2 bool = signed
				_ = _in2
				var _in3 PartSet = _2_newParts
				_ = _in3
				cons = _in0
				globalParts = _in1
				signed = _in2
				parts = _in3
				goto TAIL_CALL_START
			}
		} else {
			var _in4 _dafny.Sequence = (cons).Drop(1)
			_ = _in4
			var _in5 PartSet = globalParts
			_ = _in5
			var _in6 bool = signed
			_ = _in6
			var _in7 PartSet = parts
			_ = _in7
			cons = _in4
			globalParts = _in5
			signed = _in6
			parts = _in7
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) GetGlobalParts(cons _dafny.Sequence, globalParts PartSet, signed bool, parts PartSet) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((cons).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(parts)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetGlobalPartsFrom(((cons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Constructor)).Dtor_parts(), globalParts, signed, parts)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_newParts PartSet = (_0_valueOrError0).Extract().(PartSet)
			_ = _1_newParts
			var _in0 _dafny.Sequence = (cons).Drop(1)
			_ = _in0
			var _in1 PartSet = globalParts
			_ = _in1
			var _in2 bool = signed
			_ = _in2
			var _in3 PartSet = _1_newParts
			_ = _in3
			cons = _in0
			globalParts = _in1
			signed = _in2
			parts = _in3
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) GetAllEncryptedParts(parts _dafny.Sequence, cons _dafny.Sequence, globalEncryptedParts PartSet, name _dafny.Sequence, std _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetEncryptedParts(parts, std, _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Compound beacon "), name), Companion_PartSet_.Create_PartSet_(_dafny.SeqOf(), _dafny.SetOf(), _dafny.SetOf()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_p1 PartSet = (_0_valueOrError0).Extract().(PartSet)
		_ = _1_p1
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.GetGlobalParts(cons, globalEncryptedParts, false, Companion_PartSet_.Create_PartSet_(_dafny.SeqOf(), _dafny.SetOf(), _dafny.SetOf()))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_p2 PartSet = (_2_valueOrError1).Extract().(PartSet)
			_ = _3_p2
			var _4_valueOrError2 m_Wrappers.Result = (_1_p1).Combine(_3_p2, name, _dafny.SeqOfString("Global Parts List"))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_both PartSet = (_4_valueOrError2).Extract().(PartSet)
				_ = _5_both
				return m_Wrappers.Companion_Result_.Create_Success_((_5_both).Dtor_parts())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) IsSignedPart(part m_CompoundBeacon.BeaconPart, signed bool) bool {
	if signed {
		return (part).Is_Signed()
	} else {
		return (part).Is_Encrypted()
	}
}
func (_static *CompanionStruct_Default___) FindGlobalPart(globalParts _dafny.Sequence, cons m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart, signed bool) m_Wrappers.Option {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((globalParts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else if (Companion_Default___.IsSignedPart((globalParts).Select(0).(m_CompoundBeacon.BeaconPart), signed)) && (_dafny.Companion_Sequence_.Equal(((globalParts).Select(0).(m_CompoundBeacon.BeaconPart)).GetName(), (cons).Dtor_name())) {
		return m_Wrappers.Companion_Option_.Create_Some_((globalParts).Select(0).(m_CompoundBeacon.BeaconPart))
	} else {
		var _in0 _dafny.Sequence = (globalParts).Drop(1)
		_ = _in0
		var _in1 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart = cons
		_ = _in1
		var _in2 bool = signed
		_ = _in2
		globalParts = _in0
		cons = _in1
		signed = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetAllSignedParts(parts _dafny.Sequence, cons _dafny.Sequence, globalSignedParts PartSet, name _dafny.Sequence, outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetSignedParts(parts, outer, name, Companion_PartSet_.Create_PartSet_(_dafny.SeqOf(), _dafny.SetOf(), _dafny.SetOf()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_p1 PartSet = (_0_valueOrError0).Extract().(PartSet)
		_ = _1_p1
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.GetGlobalParts(cons, globalSignedParts, true, Companion_PartSet_.Create_PartSet_(_dafny.SeqOf(), _dafny.SetOf(), _dafny.SetOf()))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_p2 PartSet = (_2_valueOrError1).Extract().(PartSet)
			_ = _3_p2
			var _4_valueOrError2 m_Wrappers.Result = (_1_p1).Combine(_3_p2, name, _dafny.SeqOfString("Global Parts List"))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_both PartSet = (_4_valueOrError2).Extract().(PartSet)
				_ = _5_both
				return m_Wrappers.Companion_Result_.Create_Success_((_5_both).Dtor_parts())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) CheckSignedParts(parts _dafny.Sequence, globals PartSet, name _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((parts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	} else if ((globals).Dtor_names()).Contains(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_name()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Compound beacon "), name), _dafny.SeqOfString(" defines signed part ")), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_name()), _dafny.SeqOfString(" which is already defined as a global part."))))
	} else if ((globals).Dtor_prefixes()).Contains(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_prefix()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Compound beacon "), name), _dafny.SeqOfString(" defines signed part ")), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_name()), _dafny.SeqOfString(" with prefix ")), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)).Dtor_prefix()), _dafny.SeqOfString(" which is already defined as the prefix of a global part."))))
	} else {
		var _in0 _dafny.Sequence = (parts).Drop(1)
		_ = _in0
		var _in1 PartSet = globals
		_ = _in1
		var _in2 _dafny.Sequence = name
		_ = _in2
		parts = _in0
		globals = _in1
		name = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) CheckEncryptedParts(parts _dafny.Sequence, globals PartSet, name _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((parts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	} else if ((globals).Dtor_names()).Contains(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Compound beacon "), name), _dafny.SeqOfString(" defines encrypted part ")), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()), _dafny.SeqOfString(" which is already defined as a global part."))))
	} else if ((globals).Dtor_prefixes()).Contains(((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_prefix()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Compound beacon "), name), _dafny.SeqOfString(" defines encrypted part ")), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_name()), _dafny.SeqOfString(" with prefix ")), ((parts).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)).Dtor_prefix()), _dafny.SeqOfString(" which is already defined as the prefix of a global part."))))
	} else {
		var _in0 _dafny.Sequence = (parts).Drop(1)
		_ = _in0
		var _in1 PartSet = globals
		_ = _in1
		var _in2 _dafny.Sequence = name
		_ = _in2
		parts = _in0
		globals = _in1
		name = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) CreateCompoundBeacon(beacon m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon, outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, client *m_AtomicPrimitives.AtomicPrimitivesClient, virtualFields _dafny.Map, converted _dafny.Map, globalSignedParts PartSet, globalEncryptedParts PartSet) m_Wrappers.Result {
	var _0_signedParts _dafny.Sequence = (func() _dafny.Sequence {
		if ((beacon).Dtor_signed()).Is_Some() {
			return ((beacon).Dtor_signed()).Dtor_value().(_dafny.Sequence)
		}
		return _dafny.SeqOf()
	})()
	_ = _0_signedParts
	var _1_encryptedParts _dafny.Sequence = (func() _dafny.Sequence {
		if ((beacon).Dtor_encrypted()).Is_Some() {
			return ((beacon).Dtor_encrypted()).Dtor_value().(_dafny.Sequence)
		}
		return _dafny.SeqOf()
	})()
	_ = _1_encryptedParts
	var _2_constructors _dafny.Sequence = (func() _dafny.Sequence {
		if ((beacon).Dtor_constructors()).Is_Some() {
			return ((beacon).Dtor_constructors()).Dtor_value().(_dafny.Sequence)
		}
		return _dafny.SeqOf()
	})()
	_ = _2_constructors
	var _3_valueOrError0 m_Wrappers.Result = (globalSignedParts).Combine(globalEncryptedParts, _dafny.SeqOfString("Global Signed Parts List"), _dafny.SeqOfString("Global Encrypted Parts List"))
	_ = _3_valueOrError0
	if (_3_valueOrError0).IsFailure() {
		return (_3_valueOrError0).PropagateFailure()
	} else {
		var _4_globalParts PartSet = (_3_valueOrError0).Extract().(PartSet)
		_ = _4_globalParts
		var _5_valueOrError1 m_Wrappers.Result = Companion_Default___.CheckSignedParts(_0_signedParts, _4_globalParts, (beacon).Dtor_name())
		_ = _5_valueOrError1
		if (_5_valueOrError1).IsFailure() {
			return (_5_valueOrError1).PropagateFailure()
		} else {
			var _6___v3 bool = (_5_valueOrError1).Extract().(bool)
			_ = _6___v3
			var _7_valueOrError2 m_Wrappers.Result = Companion_Default___.CheckEncryptedParts(_1_encryptedParts, _4_globalParts, (beacon).Dtor_name())
			_ = _7_valueOrError2
			if (_7_valueOrError2).IsFailure() {
				return (_7_valueOrError2).PropagateFailure()
			} else {
				var _8___v4 bool = (_7_valueOrError2).Extract().(bool)
				_ = _8___v4
				var _9_valueOrError3 m_Wrappers.Result = Companion_Default___.GetAllSignedParts(_0_signedParts, _2_constructors, globalSignedParts, (beacon).Dtor_name(), outer)
				_ = _9_valueOrError3
				if (_9_valueOrError3).IsFailure() {
					return (_9_valueOrError3).PropagateFailure()
				} else {
					var _10_signed _dafny.Sequence = (_9_valueOrError3).Extract().(_dafny.Sequence)
					_ = _10_signed
					var _11_valueOrError4 m_Wrappers.Result = Companion_Default___.GetAllEncryptedParts(_1_encryptedParts, _2_constructors, globalEncryptedParts, (beacon).Dtor_name(), converted)
					_ = _11_valueOrError4
					if (_11_valueOrError4).IsFailure() {
						return (_11_valueOrError4).PropagateFailure()
					} else {
						var _12_encrypted _dafny.Sequence = (_11_valueOrError4).Extract().(_dafny.Sequence)
						_ = _12_encrypted
						var _13_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!(converted).Contains((beacon).Dtor_name()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate CompoundBeacon name : "), (beacon).Dtor_name())))
						_ = _13_valueOrError5
						if (_13_valueOrError5).IsFailure() {
							return (_13_valueOrError5).PropagateFailure()
						} else {
							var _14_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((beacon).Dtor_constructors()).Is_None()) || ((_dafny.IntOfUint32((((beacon).Dtor_constructors()).Dtor_value().(_dafny.Sequence)).Cardinality())).Sign() == 1), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("For beacon "), (beacon).Dtor_name()), _dafny.SeqOfString(" an empty constructor list was supplied."))))
							_ = _14_valueOrError6
							if (_14_valueOrError6).IsFailure() {
								return (_14_valueOrError6).PropagateFailure()
							} else {
								var _15_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((((beacon).Dtor_constructors()).Is_Some()) || ((_dafny.IntOfUint32((_0_signedParts).Cardinality())).Sign() != 0)) || ((_dafny.IntOfUint32((_1_encryptedParts).Cardinality())).Sign() != 0), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Compound beacon "), (beacon).Dtor_name()), _dafny.SeqOfString(" defines no constructors, and also no local parts. Cannot make a default constructor from global parts."))))
								_ = _15_valueOrError7
								if (_15_valueOrError7).IsFailure() {
									return (_15_valueOrError7).PropagateFailure()
								} else {
									var _16_numNon uint64 = uint64((_10_signed).Cardinality())
									_ = _16_numNon
									var _17_allParts _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_10_signed, _12_encrypted)
									_ = _17_allParts
									var _18_isSignedBeacon bool = (_dafny.IntOfUint32((_12_encrypted).Cardinality())).Sign() == 0
									_ = _18_isSignedBeacon
									var _19_valueOrError8 m_Wrappers.Result = Companion_Default___.BeaconNameAllowed(outer, virtualFields, (beacon).Dtor_name(), _dafny.SeqOfString("CompoundBeacon"), _18_isSignedBeacon)
									_ = _19_valueOrError8
									if (_19_valueOrError8).IsFailure() {
										return (_19_valueOrError8).PropagateFailure()
									} else {
										var _20___v5 bool = (_19_valueOrError8).Extract().(bool)
										_ = _20___v5
										var _21_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_17_allParts).Cardinality())).Sign() == 1, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("For beacon "), (beacon).Dtor_name()), _dafny.SeqOfString(" no parts were supplied."))))
										_ = _21_valueOrError9
										if (_21_valueOrError9).IsFailure() {
											return (_21_valueOrError9).PropagateFailure()
										} else {
											var _22_valueOrError10 m_Wrappers.Result = Companion_Default___.AddConstructors((beacon).Dtor_constructors(), (beacon).Dtor_name(), _17_allParts)
											_ = _22_valueOrError10
											if (_22_valueOrError10).IsFailure() {
												return (_22_valueOrError10).PropagateFailure()
											} else {
												var _23_constructors _dafny.Sequence = (_22_valueOrError10).Extract().(_dafny.Sequence)
												_ = _23_constructors
												var _24_beaconName _dafny.Sequence = (func() _dafny.Sequence {
													if _18_isSignedBeacon {
														return (beacon).Dtor_name()
													}
													return _dafny.Companion_Sequence_.Concatenate(m_DynamoDbEncryptionUtil.Companion_Default___.BeaconPrefix(), (beacon).Dtor_name())
												})()
												_ = _24_beaconName
												var _25_valueOrError11 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_24_beaconName), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_24_beaconName, _dafny.SeqOfString(" is not a valid attribute name."))))
												_ = _25_valueOrError11
												if (_25_valueOrError11).IsFailure() {
													return (_25_valueOrError11).PropagateFailure()
												} else {
													return m_CompoundBeacon.Companion_Default___.MakeCompoundBeacon(m_BaseBeacon.Companion_BeaconBase_.Create_BeaconBase_(client, (beacon).Dtor_name(), _24_beaconName), ((beacon).Dtor_split()).Select(0).(_dafny.Char), _17_allParts, _dafny.IntOfUint64(_16_numNon), _23_constructors)
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) AddCompoundBeacons(beacons _dafny.Sequence, outer m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, client *m_AtomicPrimitives.AtomicPrimitivesClient, virtualFields _dafny.Map, converted _dafny.Map, globalSignedParts PartSet, globalEncryptedParts PartSet) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	if (_dafny.IntOfUint32((beacons).Cardinality())).Sign() == 0 {
		output = m_Wrappers.Companion_Result_.Create_Success_(converted)
		return output
	}
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	_0_valueOrError0 = Companion_Default___.CreateCompoundBeacon((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon), outer, client, virtualFields, converted, globalSignedParts, globalEncryptedParts)
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_newBeacon m_CompoundBeacon.CompoundBeacon
	_ = _1_newBeacon
	_1_newBeacon = (_0_valueOrError0).Extract().(m_CompoundBeacon.CompoundBeacon)
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.AddCompoundBeacons((beacons).Drop(1), outer, client, virtualFields, (converted).Update(((beacons).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon)).Dtor_name(), m_SearchableEncryptionInfo.Companion_Beacon_.Create_Compound_(_1_newBeacon)), globalSignedParts, globalEncryptedParts)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) ExistsInCompound(names _dafny.Sequence, name _dafny.Sequence, data _dafny.Map) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((names).Cardinality())).Sign() == 0 {
		return false
	} else {
		var _0_b m_SearchableEncryptionInfo.Beacon = (data).Get((names).Select(0).(_dafny.Sequence)).(m_SearchableEncryptionInfo.Beacon)
		_ = _0_b
		if ((_0_b).Is_Compound()) && (((_0_b).Dtor_cmp()).HasBeacon(name)) {
			return true
		} else {
			var _in0 _dafny.Sequence = (names).Drop(1)
			_ = _in0
			var _in1 _dafny.Sequence = name
			_ = _in1
			var _in2 _dafny.Map = data
			_ = _in2
			names = _in0
			name = _in1
			data = _in2
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) CheckAllBeacons(names _dafny.Sequence, allNames _dafny.Sequence, data _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((names).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	} else {
		var _0_b m_SearchableEncryptionInfo.Beacon = (data).Get((names).Select(0).(_dafny.Sequence)).(m_SearchableEncryptionInfo.Beacon)
		_ = _0_b
		if (m_SearchableEncryptionInfo.Companion_Default___.IsPartOnly(_0_b)) && (!(Companion_Default___.ExistsInCompound(allNames, (names).Select(0).(_dafny.Sequence), data))) {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("PartOnly beacon "), (names).Select(0).(_dafny.Sequence)), _dafny.SeqOfString(" MUST be used in a compound beacon."))))
		} else if ((_0_b).Is_Standard()) && ((((_0_b).Dtor_std()).Dtor_share()).Is_Some()) {
			var _1_valueOrError0 m_Wrappers.Result = Companion_Default___.IsValidShare(data, (names).Select(0).(_dafny.Sequence), ((_0_b).Dtor_std()).Dtor_length(), (((_0_b).Dtor_std()).Dtor_share()).Dtor_value().(_dafny.Sequence))
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _2___v6 bool = (_1_valueOrError0).Extract().(bool)
				_ = _2___v6
				var _in0 _dafny.Sequence = (names).Drop(1)
				_ = _in0
				var _in1 _dafny.Sequence = allNames
				_ = _in1
				var _in2 _dafny.Map = data
				_ = _in2
				names = _in0
				allNames = _in1
				data = _in2
				goto TAIL_CALL_START
			}
		} else {
			var _in3 _dafny.Sequence = (names).Drop(1)
			_ = _in3
			var _in4 _dafny.Sequence = allNames
			_ = _in4
			var _in5 _dafny.Map = data
			_ = _in5
			names = _in3
			allNames = _in4
			data = _in5
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) CheckBeacons(data _dafny.Map) m_Wrappers.Result {
	var _0_beaconNames _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((data).Keys(), func(coer143 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg179 interface{}, arg180 interface{}) bool {
			return coer143(arg179.(_dafny.Char), arg180.(_dafny.Char))
		}
	}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
	_ = _0_beaconNames
	return Companion_Default___.CheckAllBeacons(_0_beaconNames, _0_beaconNames, data)
}

// End of class Default__

// Definition of datatype PartSet
type PartSet struct {
	Data_PartSet_
}

func (_this PartSet) Get_() Data_PartSet_ {
	return _this.Data_PartSet_
}

type Data_PartSet_ interface {
	isPartSet()
}

type CompanionStruct_PartSet_ struct {
}

var Companion_PartSet_ = CompanionStruct_PartSet_{}

type PartSet_PartSet struct {
	Parts    _dafny.Sequence
	Names    _dafny.Set
	Prefixes _dafny.Set
}

func (PartSet_PartSet) isPartSet() {}

func (CompanionStruct_PartSet_) Create_PartSet_(Parts _dafny.Sequence, Names _dafny.Set, Prefixes _dafny.Set) PartSet {
	return PartSet{PartSet_PartSet{Parts, Names, Prefixes}}
}

func (_this PartSet) Is_PartSet() bool {
	_, ok := _this.Get_().(PartSet_PartSet)
	return ok
}

func (CompanionStruct_PartSet_) Default() PartSet {
	return Companion_PartSet_.Create_PartSet_(_dafny.EmptySeq, _dafny.EmptySet, _dafny.EmptySet)
}

func (_this PartSet) Dtor_parts() _dafny.Sequence {
	return _this.Get_().(PartSet_PartSet).Parts
}

func (_this PartSet) Dtor_names() _dafny.Set {
	return _this.Get_().(PartSet_PartSet).Names
}

func (_this PartSet) Dtor_prefixes() _dafny.Set {
	return _this.Get_().(PartSet_PartSet).Prefixes
}

func (_this PartSet) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PartSet_PartSet:
		{
			return "SearchConfigToInfo.PartSet.PartSet" + "(" + _dafny.String(data.Parts) + ", " + _dafny.String(data.Names) + ", " + _dafny.String(data.Prefixes) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PartSet) Equals(other PartSet) bool {
	switch data1 := _this.Get_().(type) {
	case PartSet_PartSet:
		{
			data2, ok := other.Get_().(PartSet_PartSet)
			return ok && data1.Parts.Equals(data2.Parts) && data1.Names.Equals(data2.Names) && data1.Prefixes.Equals(data2.Prefixes)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PartSet) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PartSet)
	return ok && _this.Equals(typed)
}

func Type_PartSet_() _dafny.TypeDescriptor {
	return type_PartSet_{}
}

type type_PartSet_ struct {
}

func (_this type_PartSet_) Default() interface{} {
	return Companion_PartSet_.Default()
}

func (_this type_PartSet_) String() string {
	return "SearchConfigToInfo.PartSet"
}
func (_this PartSet) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PartSet{}

func (_this PartSet) Add(part m_CompoundBeacon.BeaconPart, name _dafny.Sequence) m_Wrappers.Result {
	{
		if ((_this).Dtor_names()).Contains((part).GetName()) {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate part name "), (part).GetName()), _dafny.SeqOfString(" in ")), name), _dafny.SeqOfString("."))))
		} else if ((_this).Dtor_prefixes()).Contains((part).GetPrefix()) {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate prefix "), (part).GetPrefix()), _dafny.SeqOfString(" in ")), name), _dafny.SeqOfString("."))))
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_PartSet_.Create_PartSet_(_dafny.Companion_Sequence_.Concatenate((_this).Dtor_parts(), _dafny.SeqOf(part)), ((_this).Dtor_names()).Union(_dafny.SetOf((part).GetName())), ((_this).Dtor_prefixes()).Union(_dafny.SetOf((part).GetPrefix()))))
		}
	}
}
func (_this PartSet) GetSetAsString(strings _dafny.Set) _dafny.Sequence {
	{
		var _0_names _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(strings, func(coer144 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg181 interface{}, arg182 interface{}) bool {
				return coer144(arg181.(_dafny.Char), arg182.(_dafny.Char))
			}
		}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
		_ = _0_names
		return m_StandardLibrary.Companion_Default___.Join(_0_names, _dafny.SeqOfString(", "))
	}
}
func (_this PartSet) Combine(other PartSet, name _dafny.Sequence, otherName _dafny.Sequence) m_Wrappers.Result {
	{
		if ((((_this).Dtor_names()).Intersection((other).Dtor_names())).Cardinality()).Sign() != 0 {
			var _0_tags _dafny.Sequence = (_this).GetSetAsString(((_this).Dtor_names()).Intersection((other).Dtor_names()))
			_ = _0_tags
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate part name(s) "), _0_tags), _dafny.SeqOfString(" between ")), name), _dafny.SeqOfString(" and ")), otherName), _dafny.SeqOfString("."))))
		} else if ((((_this).Dtor_prefixes()).Intersection((other).Dtor_prefixes())).Cardinality()).Sign() != 0 {
			var _1_tags _dafny.Sequence = (_this).GetSetAsString(((_this).Dtor_prefixes()).Intersection((other).Dtor_prefixes()))
			_ = _1_tags
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate prefix(es) "), _1_tags), _dafny.SeqOfString(" between ")), name), _dafny.SeqOfString(" and ")), otherName), _dafny.SeqOfString("."))))
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_PartSet_.Create_PartSet_(_dafny.Companion_Sequence_.Concatenate((_this).Dtor_parts(), (other).Dtor_parts()), ((_this).Dtor_names()).Union((other).Dtor_names()), ((_this).Dtor_prefixes()).Union((other).Dtor_prefixes())))
		}
	}
}

// End of datatype PartSet
