// Package SearchableEncryptionInfo
// Dafny module SearchableEncryptionInfo compiled into Go

package SearchableEncryptionInfo

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
	m__Time "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Time_"
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
	m_UUID "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UUID"
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
	return "SearchableEncryptionInfo.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) GetAllKeys(client *m_AtomicPrimitives.AtomicPrimitivesClient, stdNames _dafny.Sequence, key _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.GetHmacKeys(client, stdNames, stdNames, key, _dafny.NewMapBuilder().ToMap())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_newKeys _dafny.Map
	_ = _1_newKeys
	_1_newKeys = (_0_valueOrError0).Extract().(_dafny.Map)
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_newKeys)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetHmacKeys(client *m_AtomicPrimitives.AtomicPrimitivesClient, allKeys _dafny.Sequence, keysLeft _dafny.Sequence, key _dafny.Sequence, acc _dafny.Map) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	if (_dafny.IntOfUint32((keysLeft).Cardinality())).Sign() == 0 {
		output = m_Wrappers.Companion_Result_.Create_Success_(acc)
		return output
	} else {
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetBeaconKey(client, key, (keysLeft).Select(0).(_dafny.Sequence))
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_newKey _dafny.Sequence
		_ = _1_newKey
		_1_newKey = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.GetHmacKeys(client, allKeys, (keysLeft).Drop(1), key, (acc).Update((keysLeft).Select(0).(_dafny.Sequence), _1_newKey))
		output = _out1
	}
	return output
}
func (_static *CompanionStruct_Default___) GetBeaconKey(client *m_AtomicPrimitives.AtomicPrimitivesClient, key _dafny.Sequence, name _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _0_valueOrError0
	_0_valueOrError0 = (m_UTF8.Encode(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("AWS_DBE_SCAN_BEACON"), name))).MapFailure(func(coer103 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg131 interface{}) interface{} {
			return coer103(arg131.(_dafny.Sequence))
		}
	}(func(_1_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_DynamoDbEncryptionUtil.Companion_Default___.E(_1_e)
	}))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _2_info _dafny.Sequence
	_ = _2_info
	_2_info = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _3_keyR m_Wrappers.Result
	_ = _3_keyR
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (client).Hkdf(m_AwsCryptographyPrimitivesTypes.Companion_HkdfInput_.Create_HkdfInput_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__512_(), m_Wrappers.Companion_Option_.Create_None_(), key, _2_info, int32(64)))
	_3_keyR = _out0
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError1
	_4_valueOrError1 = (_3_keyR).MapFailure(func(coer104 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg132 interface{}) interface{} {
			return coer104(arg132.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_5_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_5_e)
	}))
	if (_4_valueOrError1).IsFailure() {
		output = (_4_valueOrError1).PropagateFailure()
		return output
	}
	var _6_newKey _dafny.Sequence
	_ = _6_newKey
	_6_newKey = (_4_valueOrError1).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(_6_newKey)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GenerateUuidBytes() m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_uuid_q m_Wrappers.Result
	_ = _0_uuid_q
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_UUID.GenerateUUID()
	_0_uuid_q = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_uuid_q).MapFailure(func(coer105 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg133 interface{}) interface{} {
			return coer105(arg133.(_dafny.Sequence))
		}
	}(func(_2_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		output = (_1_valueOrError0).PropagateFailure()
		return output
	}
	var _3_uuid _dafny.Sequence
	_ = _3_uuid
	_3_uuid = (_1_valueOrError0).Extract().(_dafny.Sequence)
	output = (m_UUID.ToByteArray(_3_uuid)).MapFailure(func(coer106 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
		return func(arg134 interface{}) interface{} {
			return coer106(arg134.(_dafny.Sequence))
		}
	}(func(_4_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(_4_e)
	}))
	return output
}
func (_static *CompanionStruct_Default___) MakeSearchInfo(version BeaconVersion) SearchInfo {
	return Companion_SearchInfo_.Create_SearchInfo_(_dafny.SeqOf(version), _dafny.Zero)
}
func (_static *CompanionStruct_Default___) IsPartOnly(b Beacon) bool {
	return ((b).Is_Standard()) && (((b).Dtor_std()).Dtor_partOnly())
}
func (_static *CompanionStruct_Default___) IsBeaconOfType(b Beacon, t BeaconType) bool {
	var _source0 BeaconType = t
	_ = _source0
	{
		if _source0.Is_AnyBeacon() {
			return true
		}
	}
	{
		if _source0.Is_SignedBeacon() {
			return !((b).IsEncrypted())
		}
	}
	{
		return (b).IsEncrypted()
	}
}
func (_static *CompanionStruct_Default___) MakeBeaconVersion(version uint8, keySource KeySource, beacons _dafny.Map, virtualFields _dafny.Map, actions _dafny.Map) m_Wrappers.Result {
	var _0_beaconNames _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((beacons).Keys(), func(coer107 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg135 interface{}, arg136 interface{}) bool {
			return coer107(arg135.(_dafny.Char), arg136.(_dafny.Char))
		}
	}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
	_ = _0_beaconNames
	var _1_stdKeys _dafny.Sequence = m_Seq.Companion_Default___.Filter(func(coer108 func(_dafny.Sequence) bool) func(interface{}) bool {
		return func(arg137 interface{}) bool {
			return coer108(arg137.(_dafny.Sequence))
		}
	}((func(_2_beacons _dafny.Map) func(_dafny.Sequence) bool {
		return func(_3_k _dafny.Sequence) bool {
			return ((_2_beacons).Contains(_3_k)) && (((_2_beacons).Get(_3_k).(Beacon)).Is_Standard())
		}
	})(beacons)), _0_beaconNames)
	_ = _1_stdKeys
	var _4_encrypted _dafny.Set = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter21 := _dafny.Iterate((actions).Keys().Elements()); ; {
			_compr_0, _ok21 := _iter21()
			if !_ok21 {
				break
			}
			var _5_k _dafny.Sequence
			_5_k = interface{}(_compr_0).(_dafny.Sequence)
			if ((actions).Contains(_5_k)) && (((actions).Get(_5_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())) {
				_coll0.Add(_5_k)
			}
		}
		return _coll0.ToSet()
	}()
	_ = _4_encrypted
	var _6_bv BeaconVersion = Companion_BeaconVersion_.Create_BeaconVersion_(version, keySource, virtualFields, beacons, _0_beaconNames, _1_stdKeys, _4_encrypted)
	_ = _6_bv
	return m_Wrappers.Companion_Result_.Create_Success_(_6_bv)
}

// End of class Default__

// Definition of class VersionNumber
type VersionNumber struct {
}

func New_VersionNumber_() *VersionNumber {
	_this := VersionNumber{}

	return &_this
}

type CompanionStruct_VersionNumber_ struct {
}

var Companion_VersionNumber_ = CompanionStruct_VersionNumber_{}

func (*VersionNumber) String() string {
	return "SearchableEncryptionInfo.VersionNumber"
}
func (_this *VersionNumber) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &VersionNumber{}

func (_this *CompanionStruct_VersionNumber_) IntegerRange(lo _dafny.Int, hi _dafny.Int) _dafny.Iterator {
	iter := _dafny.IntegerRange(lo, hi)
	return func() (interface{}, bool) {
		next, ok := iter()
		if !ok {
			return uint8(0), false
		}
		return next.(_dafny.Int).Uint8(), true
	}
}
func (_this *CompanionStruct_VersionNumber_) Witness() uint8 {
	return (_dafny.One).Uint8()
}

// End of class VersionNumber

func Type_VersionNumber_() _dafny.TypeDescriptor {
	return type_VersionNumber_{}
}

type type_VersionNumber_ struct {
}

func (_this type_VersionNumber_) Default() interface{} {
	return Companion_VersionNumber_.Witness()
}

func (_this type_VersionNumber_) String() string {
	return "SearchableEncryptionInfo.VersionNumber"
}
func (_this *CompanionStruct_VersionNumber_) Is_(__source uint8) bool {
	var _7_x _dafny.Int = _dafny.IntOfUint8(__source)
	_ = _7_x
	return (_7_x).Cmp(_dafny.One) == 0
}

// Definition of class ValidSearchInfo
type ValidSearchInfo struct {
}

func New_ValidSearchInfo_() *ValidSearchInfo {
	_this := ValidSearchInfo{}

	return &_this
}

type CompanionStruct_ValidSearchInfo_ struct {
}

var Companion_ValidSearchInfo_ = CompanionStruct_ValidSearchInfo_{}

func (*ValidSearchInfo) String() string {
	return "SearchableEncryptionInfo.ValidSearchInfo"
}

// End of class ValidSearchInfo

func Type_ValidSearchInfo_() _dafny.TypeDescriptor {
	return type_ValidSearchInfo_{}
}

type type_ValidSearchInfo_ struct {
}

func (_this type_ValidSearchInfo_) Default() interface{} {
	return Companion_SearchInfo_.Default()
}

func (_this type_ValidSearchInfo_) String() string {
	return "SearchableEncryptionInfo.ValidSearchInfo"
}

// Definition of class ValidStore
type ValidStore struct {
}

func New_ValidStore_() *ValidStore {
	_this := ValidStore{}

	return &_this
}

type CompanionStruct_ValidStore_ struct {
}

var Companion_ValidStore_ = CompanionStruct_ValidStore_{}

func (*ValidStore) String() string {
	return "SearchableEncryptionInfo.ValidStore"
}

// End of class ValidStore

func Type_ValidStore_() _dafny.TypeDescriptor {
	return type_ValidStore_{}
}

type type_ValidStore_ struct {
}

func (_this type_ValidStore_) Default() interface{} {
	return (m_AwsCryptographyKeyStoreTypes.IKeyStoreClient)(nil)
}

func (_this type_ValidStore_) String() string {
	return "SearchableEncryptionInfo.ValidStore"
}

// Definition of datatype KeyLocation
type KeyLocation struct {
	Data_KeyLocation_
}

func (_this KeyLocation) Get_() Data_KeyLocation_ {
	return _this.Data_KeyLocation_
}

type Data_KeyLocation_ interface {
	isKeyLocation()
}

type CompanionStruct_KeyLocation_ struct {
}

var Companion_KeyLocation_ = CompanionStruct_KeyLocation_{}

type KeyLocation_LiteralLoc struct {
	Keys _dafny.Map
}

func (KeyLocation_LiteralLoc) isKeyLocation() {}

func (CompanionStruct_KeyLocation_) Create_LiteralLoc_(Keys _dafny.Map) KeyLocation {
	return KeyLocation{KeyLocation_LiteralLoc{Keys}}
}

func (_this KeyLocation) Is_LiteralLoc() bool {
	_, ok := _this.Get_().(KeyLocation_LiteralLoc)
	return ok
}

type KeyLocation_SingleLoc struct {
	KeyId _dafny.Sequence
}

func (KeyLocation_SingleLoc) isKeyLocation() {}

func (CompanionStruct_KeyLocation_) Create_SingleLoc_(KeyId _dafny.Sequence) KeyLocation {
	return KeyLocation{KeyLocation_SingleLoc{KeyId}}
}

func (_this KeyLocation) Is_SingleLoc() bool {
	_, ok := _this.Get_().(KeyLocation_SingleLoc)
	return ok
}

type KeyLocation_MultiLoc struct {
	KeyName   _dafny.Sequence
	DeleteKey bool
}

func (KeyLocation_MultiLoc) isKeyLocation() {}

func (CompanionStruct_KeyLocation_) Create_MultiLoc_(KeyName _dafny.Sequence, DeleteKey bool) KeyLocation {
	return KeyLocation{KeyLocation_MultiLoc{KeyName, DeleteKey}}
}

func (_this KeyLocation) Is_MultiLoc() bool {
	_, ok := _this.Get_().(KeyLocation_MultiLoc)
	return ok
}

func (CompanionStruct_KeyLocation_) Default() KeyLocation {
	return Companion_KeyLocation_.Create_LiteralLoc_(_dafny.EmptyMap)
}

func (_this KeyLocation) Dtor_keys() _dafny.Map {
	return _this.Get_().(KeyLocation_LiteralLoc).Keys
}

func (_this KeyLocation) Dtor_keyId() _dafny.Sequence {
	return _this.Get_().(KeyLocation_SingleLoc).KeyId
}

func (_this KeyLocation) Dtor_keyName() _dafny.Sequence {
	return _this.Get_().(KeyLocation_MultiLoc).KeyName
}

func (_this KeyLocation) Dtor_deleteKey() bool {
	return _this.Get_().(KeyLocation_MultiLoc).DeleteKey
}

func (_this KeyLocation) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KeyLocation_LiteralLoc:
		{
			return "SearchableEncryptionInfo.KeyLocation.LiteralLoc" + "(" + _dafny.String(data.Keys) + ")"
		}
	case KeyLocation_SingleLoc:
		{
			return "SearchableEncryptionInfo.KeyLocation.SingleLoc" + "(" + _dafny.String(data.KeyId) + ")"
		}
	case KeyLocation_MultiLoc:
		{
			return "SearchableEncryptionInfo.KeyLocation.MultiLoc" + "(" + _dafny.String(data.KeyName) + ", " + _dafny.String(data.DeleteKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyLocation) Equals(other KeyLocation) bool {
	switch data1 := _this.Get_().(type) {
	case KeyLocation_LiteralLoc:
		{
			data2, ok := other.Get_().(KeyLocation_LiteralLoc)
			return ok && data1.Keys.Equals(data2.Keys)
		}
	case KeyLocation_SingleLoc:
		{
			data2, ok := other.Get_().(KeyLocation_SingleLoc)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	case KeyLocation_MultiLoc:
		{
			data2, ok := other.Get_().(KeyLocation_MultiLoc)
			return ok && data1.KeyName.Equals(data2.KeyName) && data1.DeleteKey == data2.DeleteKey
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyLocation) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyLocation)
	return ok && _this.Equals(typed)
}

func Type_KeyLocation_() _dafny.TypeDescriptor {
	return type_KeyLocation_{}
}

type type_KeyLocation_ struct {
}

func (_this type_KeyLocation_) Default() interface{} {
	return Companion_KeyLocation_.Default()
}

func (_this type_KeyLocation_) String() string {
	return "SearchableEncryptionInfo.KeyLocation"
}
func (_this KeyLocation) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyLocation{}

// End of datatype KeyLocation

// Definition of datatype KeySource
type KeySource struct {
	Data_KeySource_
}

func (_this KeySource) Get_() Data_KeySource_ {
	return _this.Data_KeySource_
}

type Data_KeySource_ interface {
	isKeySource()
}

type CompanionStruct_KeySource_ struct {
}

var Companion_KeySource_ = CompanionStruct_KeySource_{}

type KeySource_KeySource struct {
	Client                   *m_AtomicPrimitives.AtomicPrimitivesClient
	Store                    m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	KeyLoc                   KeyLocation
	Cache                    m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache
	CacheTTL                 uint32
	PartitionIdBytes         _dafny.Sequence
	LogicalKeyStoreNameBytes _dafny.Sequence
}

func (KeySource_KeySource) isKeySource() {}

func (CompanionStruct_KeySource_) Create_KeySource_(Client *m_AtomicPrimitives.AtomicPrimitivesClient, Store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient, KeyLoc KeyLocation, Cache m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache, CacheTTL uint32, PartitionIdBytes _dafny.Sequence, LogicalKeyStoreNameBytes _dafny.Sequence) KeySource {
	return KeySource{KeySource_KeySource{Client, Store, KeyLoc, Cache, CacheTTL, PartitionIdBytes, LogicalKeyStoreNameBytes}}
}

func (_this KeySource) Is_KeySource() bool {
	_, ok := _this.Get_().(KeySource_KeySource)
	return ok
}

func (CompanionStruct_KeySource_) Default() KeySource {
	return Companion_KeySource_.Create_KeySource_((*m_AtomicPrimitives.AtomicPrimitivesClient)(nil), (m_AwsCryptographyKeyStoreTypes.IKeyStoreClient)(nil), Companion_KeyLocation_.Default(), (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache)(nil), uint32(0), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this KeySource) Dtor_client() *m_AtomicPrimitives.AtomicPrimitivesClient {
	return _this.Get_().(KeySource_KeySource).Client
}

func (_this KeySource) Dtor_store() m_AwsCryptographyKeyStoreTypes.IKeyStoreClient {
	return _this.Get_().(KeySource_KeySource).Store
}

func (_this KeySource) Dtor_keyLoc() KeyLocation {
	return _this.Get_().(KeySource_KeySource).KeyLoc
}

func (_this KeySource) Dtor_cache() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache {
	return _this.Get_().(KeySource_KeySource).Cache
}

func (_this KeySource) Dtor_cacheTTL() uint32 {
	return _this.Get_().(KeySource_KeySource).CacheTTL
}

func (_this KeySource) Dtor_partitionIdBytes() _dafny.Sequence {
	return _this.Get_().(KeySource_KeySource).PartitionIdBytes
}

func (_this KeySource) Dtor_logicalKeyStoreNameBytes() _dafny.Sequence {
	return _this.Get_().(KeySource_KeySource).LogicalKeyStoreNameBytes
}

func (_this KeySource) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KeySource_KeySource:
		{
			return "SearchableEncryptionInfo.KeySource.KeySource" + "(" + _dafny.String(data.Client) + ", " + _dafny.String(data.Store) + ", " + _dafny.String(data.KeyLoc) + ", " + _dafny.String(data.Cache) + ", " + _dafny.String(data.CacheTTL) + ", " + _dafny.String(data.PartitionIdBytes) + ", " + _dafny.String(data.LogicalKeyStoreNameBytes) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeySource) Equals(other KeySource) bool {
	switch data1 := _this.Get_().(type) {
	case KeySource_KeySource:
		{
			data2, ok := other.Get_().(KeySource_KeySource)
			return ok && data1.Client == data2.Client && _dafny.AreEqual(data1.Store, data2.Store) && data1.KeyLoc.Equals(data2.KeyLoc) && _dafny.AreEqual(data1.Cache, data2.Cache) && data1.CacheTTL == data2.CacheTTL && data1.PartitionIdBytes.Equals(data2.PartitionIdBytes) && data1.LogicalKeyStoreNameBytes.Equals(data2.LogicalKeyStoreNameBytes)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeySource) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeySource)
	return ok && _this.Equals(typed)
}

func Type_KeySource_() _dafny.TypeDescriptor {
	return type_KeySource_{}
}

type type_KeySource_ struct {
}

func (_this type_KeySource_) Default() interface{} {
	return Companion_KeySource_.Default()
}

func (_this type_KeySource_) String() string {
	return "SearchableEncryptionInfo.KeySource"
}
func (_this KeySource) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeySource{}

func (_this KeySource) GetKeyMap(stdNames _dafny.Sequence, keyId m_DynamoDbEncryptionUtil.MaybeKeyId) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Default())
		_ = output
		if ((_this).Dtor_keyLoc()).Is_SingleLoc() {
			var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _0_valueOrError0
			_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((keyId).Is_DontUseKeyId(), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("KeyID should not be supplied with a SingleKeyStore")))
			if (_0_valueOrError0).IsFailure() {
				output = (_0_valueOrError0).PropagateFailure()
				return output
			}
			var _1_now int64
			_ = _1_now
			var _out0 int64
			_ = _out0
			_out0 = m__Time.CurrentRelativeTime()
			_1_now = _out0
			var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
			_ = _2_valueOrError1
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (_this).GetKeysCache((_this).Dtor_client(), stdNames, ((_this).Dtor_keyLoc()).Dtor_keyId(), int64((_this).Dtor_cacheTTL()), (_this).Dtor_partitionIdBytes(), (_this).Dtor_logicalKeyStoreNameBytes(), (_1_now))
			_2_valueOrError1 = _out1
			if (_2_valueOrError1).IsFailure() {
				output = (_2_valueOrError1).PropagateFailure()
				return output
			}
			var _3_theMap _dafny.Map
			_ = _3_theMap
			_3_theMap = (_2_valueOrError1).Extract().(_dafny.Map)
			output = m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_Keys_(_3_theMap))
			return output
		} else if ((_this).Dtor_keyLoc()).Is_LiteralLoc() {
			var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _4_valueOrError2
			_4_valueOrError2 = m_Wrappers.Companion_Default___.Need((keyId).Is_DontUseKeyId(), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("KeyID should not be supplied with a LiteralKeyStore")))
			if (_4_valueOrError2).IsFailure() {
				output = (_4_valueOrError2).PropagateFailure()
				return output
			}
			var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
			_ = _5_valueOrError3
			var _out2 m_Wrappers.Result
			_ = _out2
			_out2 = (_this).GetKeysLiteral()
			_5_valueOrError3 = _out2
			if (_5_valueOrError3).IsFailure() {
				output = (_5_valueOrError3).PropagateFailure()
				return output
			}
			var _6_theMap _dafny.Map
			_ = _6_theMap
			_6_theMap = (_5_valueOrError3).Extract().(_dafny.Map)
			output = m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_Keys_(_6_theMap))
			return output
		} else {
			var _source0 m_DynamoDbEncryptionUtil.MaybeKeyId = keyId
			_ = _source0
			{
				{
					if _source0.Is_DontUseKeyId() {
						output = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Fixed KeyID must not be supplied with a MultiKeyStore")))
						return output
						goto Lmatch0
					}
				}
				{
					if _source0.Is_ShouldHaveKeyId() {
						output = m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_ShouldHaveKeys_())
						return output
						goto Lmatch0
					}
				}
				{
					var _7_id _dafny.Sequence = _source0.Get_().(m_DynamoDbEncryptionUtil.MaybeKeyId_KeyId).Value
					_ = _7_id
					var _8_now int64
					_ = _8_now
					var _out3 int64
					_ = _out3
					_out3 = m__Time.CurrentRelativeTime()
					_8_now = _out3
					var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _9_valueOrError4
					var _out4 m_Wrappers.Result
					_ = _out4
					_out4 = (_this).GetKeysCache((_this).Dtor_client(), stdNames, _7_id, int64((_this).Dtor_cacheTTL()), (_this).Dtor_partitionIdBytes(), (_this).Dtor_logicalKeyStoreNameBytes(), (_8_now))
					_9_valueOrError4 = _out4
					if (_9_valueOrError4).IsFailure() {
						output = (_9_valueOrError4).PropagateFailure()
						return output
					}
					var _10_theMap _dafny.Map
					_ = _10_theMap
					_10_theMap = (_9_valueOrError4).Extract().(_dafny.Map)
					output = m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_Keys_(_10_theMap))
					return output
				}
				goto Lmatch0
			}
		Lmatch0:
		}
		return output
	}
}
func (_this KeySource) GetKeysLiteral() m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		output = m_Wrappers.Companion_Result_.Create_Success_(((_this).Dtor_keyLoc()).Dtor_keys())
		return output
		return output
	}
}
func (_this KeySource) PosLongAdd(x int64, y int64) int64 {
	{
		if ((_dafny.IntOfInt64(x)).Plus(_dafny.IntOfInt64(y))).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT64__MAX__LIMIT()) < 0 {
			return (x) + (y)
		} else {
			return (m_StandardLibrary_UInt.Companion_Default___.INT64__MAX__LIMIT()).Int64()
		}
	}
}
func (_this KeySource) PosLongSub(x int64, y int64) int64 {
	{
		if (x) <= (y) {
			return int64(0)
		} else {
			return (x) - (y)
		}
	}
}
func (_this KeySource) CacheEntryWithinLimits(creationTime int64, now int64, ttlSeconds int64) bool {
	{
		if (now) <= (creationTime) {
			return true
		} else {
			return ((_this).PosLongSub(now, creationTime)) <= (ttlSeconds)
		}
	}
}
func (_this KeySource) GetKeysCache(client *m_AtomicPrimitives.AtomicPrimitivesClient, stdNames _dafny.Sequence, keyId _dafny.Sequence, cacheTTL int64, partitionIdBytes _dafny.Sequence, logicalKeyStoreNameBytes _dafny.Sequence, now int64) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		var _0_resourceId _dafny.Sequence
		_ = _0_resourceId
		_0_resourceId = m_CacheConstants.Companion_Default___.RESOURCE__ID__HIERARCHICAL__KEYRING()
		var _1_scopeId _dafny.Sequence
		_ = _1_scopeId
		_1_scopeId = m_CacheConstants.Companion_Default___.SCOPE__ID__SEARCHABLE__ENCRYPTION()
		var _2_keyIdBytesR m_Wrappers.Result
		_ = _2_keyIdBytesR
		_2_keyIdBytesR = m_UTF8.Encode(keyId)
		var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _3_valueOrError0
		_3_valueOrError0 = (_2_keyIdBytesR).MapFailure(func(coer109 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg138 interface{}) interface{} {
				return coer109(arg138.(_dafny.Sequence))
			}
		}(func(_4_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_DynamoDbEncryptionUtil.Companion_Default___.E(_4_e)
		}))
		if (_3_valueOrError0).IsFailure() {
			output = (_3_valueOrError0).PropagateFailure()
			return output
		}
		var _5_keyIdBytes _dafny.Sequence
		_ = _5_keyIdBytes
		_5_keyIdBytes = (_3_valueOrError0).Extract().(_dafny.Sequence)
		var _6_suffix _dafny.Sequence
		_ = _6_suffix
		_6_suffix = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(logicalKeyStoreNameBytes, m_CacheConstants.Companion_Default___.NULL__BYTE()), _5_keyIdBytes)
		var _7_identifier _dafny.Sequence
		_ = _7_identifier
		_7_identifier = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_0_resourceId, m_CacheConstants.Companion_Default___.NULL__BYTE()), _1_scopeId), m_CacheConstants.Companion_Default___.NULL__BYTE()), partitionIdBytes), m_CacheConstants.Companion_Default___.NULL__BYTE()), _6_suffix)
		var _8_hashAlgorithm m_AwsCryptographyPrimitivesTypes.DigestAlgorithm
		_ = _8_hashAlgorithm
		_8_hashAlgorithm = m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_()
		var _9_identifierDigestInput m_AwsCryptographyPrimitivesTypes.DigestInput
		_ = _9_identifierDigestInput
		_9_identifierDigestInput = m_AwsCryptographyPrimitivesTypes.Companion_DigestInput_.Create_DigestInput_(_8_hashAlgorithm, _7_identifier)
		var _10_maybeCacheDigest m_Wrappers.Result
		_ = _10_maybeCacheDigest
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (client).Digest(_9_identifierDigestInput)
		_10_maybeCacheDigest = _out0
		var _11_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _11_valueOrError1
		_11_valueOrError1 = (_10_maybeCacheDigest).MapFailure(func(coer110 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg139 interface{}) interface{} {
				return coer110(arg139.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_12_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_12_e)
		}))
		if (_11_valueOrError1).IsFailure() {
			output = (_11_valueOrError1).PropagateFailure()
			return output
		}
		var _13_cacheDigest _dafny.Sequence
		_ = _13_cacheDigest
		_13_cacheDigest = (_11_valueOrError1).Extract().(_dafny.Sequence)
		var _14_getCacheInput m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput
		_ = _14_getCacheInput
		_14_getCacheInput = m_AwsCryptographyMaterialProvidersTypes.Companion_GetCacheEntryInput_.Create_GetCacheEntryInput_(_13_cacheDigest, m_Wrappers.Companion_Option_.Create_None_())
		var _15_getCacheOutput m_Wrappers.Result
		_ = _15_getCacheOutput
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = ((_this).Dtor_cache()).GetCacheEntry(_14_getCacheInput)
		_15_getCacheOutput = _out1
		if ((_15_getCacheOutput).Is_Failure()) && (!(((_15_getCacheOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)).Is_EntryDoesNotExist())) {
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_((_15_getCacheOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)))
			return output
		}
		if ((_15_getCacheOutput).Is_Failure()) || (!((_this).CacheEntryWithinLimits(((_15_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_creationTime(), now, cacheTTL))) {
			var _16_maybeRawBeaconKeyMaterials m_Wrappers.Result
			_ = _16_maybeRawBeaconKeyMaterials
			var _out2 m_Wrappers.Result
			_ = _out2
			_out2 = ((_this).Dtor_store()).GetBeaconKey(m_AwsCryptographyKeyStoreTypes.Companion_GetBeaconKeyInput_.Create_GetBeaconKeyInput_(keyId))
			_16_maybeRawBeaconKeyMaterials = _out2
			var _17_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetBeaconKeyOutput_.Default())
			_ = _17_valueOrError2
			_17_valueOrError2 = (_16_maybeRawBeaconKeyMaterials).MapFailure(func(coer111 func(m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
				return func(arg140 interface{}) interface{} {
					return coer111(arg140.(m_AwsCryptographyKeyStoreTypes.Error))
				}
			}(func(_18_e m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
				return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyKeyStore_(_18_e)
			}))
			if (_17_valueOrError2).IsFailure() {
				output = (_17_valueOrError2).PropagateFailure()
				return output
			}
			var _19_rawBeaconKeyMaterials m_AwsCryptographyKeyStoreTypes.GetBeaconKeyOutput
			_ = _19_rawBeaconKeyMaterials
			_19_rawBeaconKeyMaterials = (_17_valueOrError2).Extract().(m_AwsCryptographyKeyStoreTypes.GetBeaconKeyOutput)
			var _20_key m_Wrappers.Option
			_ = _20_key
			_20_key = ((_19_rawBeaconKeyMaterials).Dtor_beaconKeyMaterials()).Dtor_beaconKey()
			var _21_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _21_valueOrError3
			_21_valueOrError3 = m_Wrappers.Companion_Default___.Need((_20_key).Is_Some(), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("beacon key unexpectedly empty")))
			if (_21_valueOrError3).IsFailure() {
				output = (_21_valueOrError3).PropagateFailure()
				return output
			}
			var _22_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
			_ = _22_valueOrError4
			var _out3 m_Wrappers.Result
			_ = _out3
			_out3 = (_this).GetAllKeys(stdNames, (_20_key).Dtor_value().(_dafny.Sequence))
			_22_valueOrError4 = _out3
			if (_22_valueOrError4).IsFailure() {
				output = (_22_valueOrError4).PropagateFailure()
				return output
			}
			var _23_keyMap _dafny.Map
			_ = _23_keyMap
			_23_keyMap = (_22_valueOrError4).Extract().(_dafny.Map)
			var _24_beaconKeyMaterials m_AwsCryptographyKeyStoreTypes.BeaconKeyMaterials
			_ = _24_beaconKeyMaterials
			var _25_dt__update__tmp_h0 m_AwsCryptographyKeyStoreTypes.BeaconKeyMaterials = (_19_rawBeaconKeyMaterials).Dtor_beaconKeyMaterials()
			_ = _25_dt__update__tmp_h0
			var _26_dt__update_hhmacKeys_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(_23_keyMap)
			_ = _26_dt__update_hhmacKeys_h0
			var _27_dt__update_hbeaconKey_h0 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_None_()
			_ = _27_dt__update_hbeaconKey_h0
			_24_beaconKeyMaterials = m_AwsCryptographyKeyStoreTypes.Companion_BeaconKeyMaterials_.Create_BeaconKeyMaterials_((_25_dt__update__tmp_h0).Dtor_beaconKeyIdentifier(), (_25_dt__update__tmp_h0).Dtor_encryptionContext(), _27_dt__update_hbeaconKey_h0, _26_dt__update_hhmacKeys_h0)
			var _28_putCacheEntryInput m_AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput
			_ = _28_putCacheEntryInput
			_28_putCacheEntryInput = m_AwsCryptographyMaterialProvidersTypes.Companion_PutCacheEntryInput_.Create_PutCacheEntryInput_(_13_cacheDigest, m_AwsCryptographyMaterialProvidersTypes.Companion_Materials_.Create_BeaconKey_(_24_beaconKeyMaterials), now, (_this).PosLongAdd(now, cacheTTL), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			var _29_putResult m_Wrappers.Result
			_ = _29_putResult
			var _out4 m_Wrappers.Result
			_ = _out4
			_out4 = ((_this).Dtor_cache()).PutCacheEntry(_28_putCacheEntryInput)
			_29_putResult = _out4
			if ((_29_putResult).Is_Failure()) && (!(((_29_putResult).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)).Is_EntryAlreadyExists())) {
				output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_((_29_putResult).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)))
				return output
			}
			output = m_Wrappers.Companion_Result_.Create_Success_(_23_keyMap)
			return output
		} else {
			var _30_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _30_valueOrError5
			_30_valueOrError5 = m_Wrappers.Companion_Default___.Need(((((((_15_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Is_BeaconKey()) && ((((((_15_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Dtor_BeaconKey()).Dtor_hmacKeys()).Is_Some())) && (_dafny.Companion_Sequence_.Equal(((((_15_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Dtor_BeaconKey()).Dtor_beaconKeyIdentifier(), keyId))) && ((((((_15_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Dtor_BeaconKey()).Dtor_hmacKeys()).Is_Some()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Material Type.")))
			if (_30_valueOrError5).IsFailure() {
				output = (_30_valueOrError5).PropagateFailure()
				return output
			}
			output = m_Wrappers.Companion_Result_.Create_Success_((((((_15_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Dtor_BeaconKey()).Dtor_hmacKeys()).Dtor_value().(_dafny.Map))
			return output
		}
		return output
	}
}
func (_this KeySource) GetAllKeys(stdNames _dafny.Sequence, key _dafny.Sequence) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetAllKeys((_this).Dtor_client(), stdNames, key)
		output = _out0
		return output
	}
}

// End of datatype KeySource

// Definition of datatype SearchInfo
type SearchInfo struct {
	Data_SearchInfo_
}

func (_this SearchInfo) Get_() Data_SearchInfo_ {
	return _this.Data_SearchInfo_
}

type Data_SearchInfo_ interface {
	isSearchInfo()
}

type CompanionStruct_SearchInfo_ struct {
}

var Companion_SearchInfo_ = CompanionStruct_SearchInfo_{}

type SearchInfo_SearchInfo struct {
	Versions  _dafny.Sequence
	CurrWrite _dafny.Int
}

func (SearchInfo_SearchInfo) isSearchInfo() {}

func (CompanionStruct_SearchInfo_) Create_SearchInfo_(Versions _dafny.Sequence, CurrWrite _dafny.Int) SearchInfo {
	return SearchInfo{SearchInfo_SearchInfo{Versions, CurrWrite}}
}

func (_this SearchInfo) Is_SearchInfo() bool {
	_, ok := _this.Get_().(SearchInfo_SearchInfo)
	return ok
}

func (CompanionStruct_SearchInfo_) Default() SearchInfo {
	return Companion_SearchInfo_.Create_SearchInfo_(_dafny.EmptySeq, _dafny.Zero)
}

func (_this SearchInfo) Dtor_versions() _dafny.Sequence {
	return _this.Get_().(SearchInfo_SearchInfo).Versions
}

func (_this SearchInfo) Dtor_currWrite() _dafny.Int {
	return _this.Get_().(SearchInfo_SearchInfo).CurrWrite
}

func (_this SearchInfo) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SearchInfo_SearchInfo:
		{
			return "SearchableEncryptionInfo.SearchInfo.SearchInfo" + "(" + _dafny.String(data.Versions) + ", " + _dafny.String(data.CurrWrite) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SearchInfo) Equals(other SearchInfo) bool {
	switch data1 := _this.Get_().(type) {
	case SearchInfo_SearchInfo:
		{
			data2, ok := other.Get_().(SearchInfo_SearchInfo)
			return ok && data1.Versions.Equals(data2.Versions) && data1.CurrWrite.Cmp(data2.CurrWrite) == 0
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SearchInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SearchInfo)
	return ok && _this.Equals(typed)
}

func Type_SearchInfo_() _dafny.TypeDescriptor {
	return type_SearchInfo_{}
}

type type_SearchInfo_ struct {
}

func (_this type_SearchInfo_) Default() interface{} {
	return Companion_SearchInfo_.Default()
}

func (_this type_SearchInfo_) String() string {
	return "SearchableEncryptionInfo.SearchInfo"
}
func (_this SearchInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SearchInfo{}

func (_this SearchInfo) Curr() BeaconVersion {
	{
		return ((_this).Dtor_versions()).Select(((_this).Dtor_currWrite()).Uint32()).(BeaconVersion)
	}
}
func (_this SearchInfo) IsBeacon(field _dafny.Sequence) bool {
	{
		return (((_this).Dtor_versions()).Select(((_this).Dtor_currWrite()).Uint32()).(BeaconVersion)).IsBeacon(field)
	}
}
func (_this SearchInfo) IsVirtualField(field _dafny.Sequence) bool {
	{
		return (((_this).Dtor_versions()).Select(((_this).Dtor_currWrite()).Uint32()).(BeaconVersion)).IsVirtualField(field)
	}
}
func (_this SearchInfo) GeneratePlainBeacons(item _dafny.Map) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (((_this).Dtor_versions()).Select(((_this).Dtor_currWrite()).Uint32()).(BeaconVersion)).GeneratePlainBeacons(item)
		output = _out0
		return output
	}
}
func (_this SearchInfo) GenerateSignedBeacons(item _dafny.Map) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (((_this).Dtor_versions()).Select(((_this).Dtor_currWrite()).Uint32()).(BeaconVersion)).GenerateSignedBeacons(item)
		output = _out0
		return output
	}
}
func (_this SearchInfo) GenerateEncryptedBeacons(item _dafny.Map, keyId m_DynamoDbEncryptionUtil.MaybeKeyId) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (((_this).Dtor_versions()).Select(((_this).Dtor_currWrite()).Uint32()).(BeaconVersion)).GenerateEncryptedBeacons(item, keyId)
		output = _out0
		return output
	}
}

// End of datatype SearchInfo

// Definition of datatype Beacon
type Beacon struct {
	Data_Beacon_
}

func (_this Beacon) Get_() Data_Beacon_ {
	return _this.Data_Beacon_
}

type Data_Beacon_ interface {
	isBeacon()
}

type CompanionStruct_Beacon_ struct {
}

var Companion_Beacon_ = CompanionStruct_Beacon_{}

type Beacon_Standard struct {
	Std m_BaseBeacon.StandardBeacon
}

func (Beacon_Standard) isBeacon() {}

func (CompanionStruct_Beacon_) Create_Standard_(Std m_BaseBeacon.StandardBeacon) Beacon {
	return Beacon{Beacon_Standard{Std}}
}

func (_this Beacon) Is_Standard() bool {
	_, ok := _this.Get_().(Beacon_Standard)
	return ok
}

type Beacon_Compound struct {
	Cmp m_CompoundBeacon.CompoundBeacon
}

func (Beacon_Compound) isBeacon() {}

func (CompanionStruct_Beacon_) Create_Compound_(Cmp m_CompoundBeacon.CompoundBeacon) Beacon {
	return Beacon{Beacon_Compound{Cmp}}
}

func (_this Beacon) Is_Compound() bool {
	_, ok := _this.Get_().(Beacon_Compound)
	return ok
}

func (CompanionStruct_Beacon_) Default() Beacon {
	return Companion_Beacon_.Create_Standard_(m_BaseBeacon.Companion_StandardBeacon_.Default())
}

func (_this Beacon) Dtor_std() m_BaseBeacon.StandardBeacon {
	return _this.Get_().(Beacon_Standard).Std
}

func (_this Beacon) Dtor_cmp() m_CompoundBeacon.CompoundBeacon {
	return _this.Get_().(Beacon_Compound).Cmp
}

func (_this Beacon) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Beacon_Standard:
		{
			return "SearchableEncryptionInfo.Beacon.Standard" + "(" + _dafny.String(data.Std) + ")"
		}
	case Beacon_Compound:
		{
			return "SearchableEncryptionInfo.Beacon.Compound" + "(" + _dafny.String(data.Cmp) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Beacon) Equals(other Beacon) bool {
	switch data1 := _this.Get_().(type) {
	case Beacon_Standard:
		{
			data2, ok := other.Get_().(Beacon_Standard)
			return ok && data1.Std.Equals(data2.Std)
		}
	case Beacon_Compound:
		{
			data2, ok := other.Get_().(Beacon_Compound)
			return ok && data1.Cmp.Equals(data2.Cmp)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Beacon) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Beacon)
	return ok && _this.Equals(typed)
}

func Type_Beacon_() _dafny.TypeDescriptor {
	return type_Beacon_{}
}

type type_Beacon_ struct {
}

func (_this type_Beacon_) Default() interface{} {
	return Companion_Beacon_.Default()
}

func (_this type_Beacon_) String() string {
	return "SearchableEncryptionInfo.Beacon"
}
func (_this Beacon) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Beacon{}

func (_this Beacon) IsEncrypted() bool {
	{
		if (_this).Is_Standard() {
			return true
		} else {
			return ((_this).Dtor_cmp()).IsEncrypted()
		}
	}
}
func (_this Beacon) Hash(item _dafny.Map, vf _dafny.Map, keys m_DynamoDbEncryptionUtil.MaybeKeyMap) m_Wrappers.Result {
	{
		if (_this).Is_Standard() {
			var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((keys).Is_Keys(), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Need key for beacon "), ((_this).Dtor_std()).KeyName()), _dafny.SeqOfString(" but no keyId found in query."))))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else if ((keys).Dtor_value()).Contains(((_this).Dtor_std()).KeyName()) {
				return ((_this).Dtor_std()).GetHash(item, vf, ((keys).Dtor_value()).Get(((_this).Dtor_std()).KeyName()).(_dafny.Sequence))
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Internal error. Beacon "), ((_this).Dtor_std()).KeyName()), _dafny.SeqOfString(" has no key!"))))
			}
		} else {
			var _1_valueOrError1 m_Wrappers.Result = ((_this).Dtor_cmp()).Hash(item, vf, keys)
			_ = _1_valueOrError1
			if (_1_valueOrError1).IsFailure() {
				return (_1_valueOrError1).PropagateFailure()
			} else {
				var _2_strHash m_Wrappers.Option = (_1_valueOrError1).Extract().(m_Wrappers.Option)
				_ = _2_strHash
				if (_2_strHash).Is_None() {
					return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
				} else {
					return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_((_2_strHash).Dtor_value().(_dafny.Sequence))))
				}
			}
		}
	}
}
func (_this Beacon) Naked(item _dafny.Map, vf _dafny.Map) m_Wrappers.Result {
	{
		if (_this).Is_Standard() {
			return ((_this).Dtor_std()).GetNaked(item, vf)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = ((_this).Dtor_cmp()).GetNaked(item, vf)
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_str m_Wrappers.Option = (_0_valueOrError0).Extract().(m_Wrappers.Option)
				_ = _1_str
				if (_1_str).Is_None() {
					return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
				} else {
					return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(m_DdbVirtualFields.Companion_Default___.DS((_1_str).Dtor_value().(_dafny.Sequence))))
				}
			}
		}
	}
}
func (_this Beacon) AttrHash(item _dafny.Map, vf _dafny.Map, keys m_DynamoDbEncryptionUtil.MaybeKeyMap) m_Wrappers.Result {
	{
		if (keys).Is_DontUseKeys() {
			return (_this).Naked(item, vf)
		} else {
			return (_this).Hash(item, vf, keys)
		}
	}
}
func (_this Beacon) GetName() _dafny.Sequence {
	{
		if (_this).Is_Standard() {
			return (((_this).Dtor_std()).Dtor_base()).Dtor_name()
		} else {
			return (((_this).Dtor_cmp()).Dtor_base()).Dtor_name()
		}
	}
}
func (_this Beacon) GetBeaconName() _dafny.Sequence {
	{
		if (_this).Is_Standard() {
			return (((_this).Dtor_std()).Dtor_base()).Dtor_beaconName()
		} else {
			return (((_this).Dtor_cmp()).Dtor_base()).Dtor_beaconName()
		}
	}
}
func (_this Beacon) GetFields(virtualFields _dafny.Map) _dafny.Sequence {
	{
		if (_this).Is_Standard() {
			return ((_this).Dtor_std()).GetFields(virtualFields)
		} else {
			return ((_this).Dtor_cmp()).GetFields(virtualFields)
		}
	}
}
func (_this Beacon) GetBeaconValue(value m_ComAmazonawsDynamodbTypes.AttributeValue, keys m_DynamoDbEncryptionUtil.MaybeKeyMap, forEquality bool, forContains bool) m_Wrappers.Result {
	{
		if (keys).Is_DontUseKeys() {
			return m_Wrappers.Companion_Result_.Create_Success_(value)
		} else if (_this).Is_Standard() {
			var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!((keys).Is_ShouldHaveKeys()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Need KeyId because of beacon "), ((_this).Dtor_std()).KeyName()), _dafny.SeqOfString(" but no KeyId found in query"))))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_keys _dafny.Map = (keys).Dtor_value()
				_ = _1_keys
				if (_1_keys).Contains(((_this).Dtor_std()).KeyName()) {
					return ((_this).Dtor_std()).GetBeaconValue(value, (_1_keys).Get(((_this).Dtor_std()).KeyName()).(_dafny.Sequence), forContains)
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Internal error. Beacon "), ((_this).Dtor_std()).KeyName()), _dafny.SeqOfString(" has no key."))))
				}
			}
		} else {
			return ((_this).Dtor_cmp()).GetBeaconValue(value, keys, forEquality)
		}
	}
}

// End of datatype Beacon

// Definition of class BeaconMap
type BeaconMap struct {
}

func New_BeaconMap_() *BeaconMap {
	_this := BeaconMap{}

	return &_this
}

type CompanionStruct_BeaconMap_ struct {
}

var Companion_BeaconMap_ = CompanionStruct_BeaconMap_{}

func (*BeaconMap) String() string {
	return "SearchableEncryptionInfo.BeaconMap"
}

// End of class BeaconMap

func Type_BeaconMap_() _dafny.TypeDescriptor {
	return type_BeaconMap_{}
}

type type_BeaconMap_ struct {
}

func (_this type_BeaconMap_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_BeaconMap_) String() string {
	return "SearchableEncryptionInfo.BeaconMap"
}

// Definition of datatype BeaconType
type BeaconType struct {
	Data_BeaconType_
}

func (_this BeaconType) Get_() Data_BeaconType_ {
	return _this.Data_BeaconType_
}

type Data_BeaconType_ interface {
	isBeaconType()
}

type CompanionStruct_BeaconType_ struct {
}

var Companion_BeaconType_ = CompanionStruct_BeaconType_{}

type BeaconType_AnyBeacon struct {
}

func (BeaconType_AnyBeacon) isBeaconType() {}

func (CompanionStruct_BeaconType_) Create_AnyBeacon_() BeaconType {
	return BeaconType{BeaconType_AnyBeacon{}}
}

func (_this BeaconType) Is_AnyBeacon() bool {
	_, ok := _this.Get_().(BeaconType_AnyBeacon)
	return ok
}

type BeaconType_SignedBeacon struct {
}

func (BeaconType_SignedBeacon) isBeaconType() {}

func (CompanionStruct_BeaconType_) Create_SignedBeacon_() BeaconType {
	return BeaconType{BeaconType_SignedBeacon{}}
}

func (_this BeaconType) Is_SignedBeacon() bool {
	_, ok := _this.Get_().(BeaconType_SignedBeacon)
	return ok
}

type BeaconType_EncryptedBeacon struct {
}

func (BeaconType_EncryptedBeacon) isBeaconType() {}

func (CompanionStruct_BeaconType_) Create_EncryptedBeacon_() BeaconType {
	return BeaconType{BeaconType_EncryptedBeacon{}}
}

func (_this BeaconType) Is_EncryptedBeacon() bool {
	_, ok := _this.Get_().(BeaconType_EncryptedBeacon)
	return ok
}

func (CompanionStruct_BeaconType_) Default() BeaconType {
	return Companion_BeaconType_.Create_AnyBeacon_()
}

func (_ CompanionStruct_BeaconType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_BeaconType_.Create_AnyBeacon_(), true
		case 1:
			return Companion_BeaconType_.Create_SignedBeacon_(), true
		case 2:
			return Companion_BeaconType_.Create_EncryptedBeacon_(), true
		default:
			return BeaconType{}, false
		}
	}
}

func (_this BeaconType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case BeaconType_AnyBeacon:
		{
			return "SearchableEncryptionInfo.BeaconType.AnyBeacon"
		}
	case BeaconType_SignedBeacon:
		{
			return "SearchableEncryptionInfo.BeaconType.SignedBeacon"
		}
	case BeaconType_EncryptedBeacon:
		{
			return "SearchableEncryptionInfo.BeaconType.EncryptedBeacon"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BeaconType) Equals(other BeaconType) bool {
	switch _this.Get_().(type) {
	case BeaconType_AnyBeacon:
		{
			_, ok := other.Get_().(BeaconType_AnyBeacon)
			return ok
		}
	case BeaconType_SignedBeacon:
		{
			_, ok := other.Get_().(BeaconType_SignedBeacon)
			return ok
		}
	case BeaconType_EncryptedBeacon:
		{
			_, ok := other.Get_().(BeaconType_EncryptedBeacon)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BeaconType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BeaconType)
	return ok && _this.Equals(typed)
}

func Type_BeaconType_() _dafny.TypeDescriptor {
	return type_BeaconType_{}
}

type type_BeaconType_ struct {
}

func (_this type_BeaconType_) Default() interface{} {
	return Companion_BeaconType_.Default()
}

func (_this type_BeaconType_) String() string {
	return "SearchableEncryptionInfo.BeaconType"
}
func (_this BeaconType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BeaconType{}

// End of datatype BeaconType

// Definition of class ValidBeaconVersion
type ValidBeaconVersion struct {
}

func New_ValidBeaconVersion_() *ValidBeaconVersion {
	_this := ValidBeaconVersion{}

	return &_this
}

type CompanionStruct_ValidBeaconVersion_ struct {
}

var Companion_ValidBeaconVersion_ = CompanionStruct_ValidBeaconVersion_{}

func (*ValidBeaconVersion) String() string {
	return "SearchableEncryptionInfo.ValidBeaconVersion"
}

// End of class ValidBeaconVersion

func Type_ValidBeaconVersion_() _dafny.TypeDescriptor {
	return type_ValidBeaconVersion_{}
}

type type_ValidBeaconVersion_ struct {
}

func (_this type_ValidBeaconVersion_) Default() interface{} {
	return Companion_BeaconVersion_.Default()
}

func (_this type_ValidBeaconVersion_) String() string {
	return "SearchableEncryptionInfo.ValidBeaconVersion"
}

// Definition of datatype BeaconVersion
type BeaconVersion struct {
	Data_BeaconVersion_
}

func (_this BeaconVersion) Get_() Data_BeaconVersion_ {
	return _this.Data_BeaconVersion_
}

type Data_BeaconVersion_ interface {
	isBeaconVersion()
}

type CompanionStruct_BeaconVersion_ struct {
}

var Companion_BeaconVersion_ = CompanionStruct_BeaconVersion_{}

type BeaconVersion_BeaconVersion struct {
	Version         uint8
	KeySource       KeySource
	VirtualFields   _dafny.Map
	Beacons         _dafny.Map
	BeaconNames     _dafny.Sequence
	StdNames        _dafny.Sequence
	EncryptedFields _dafny.Set
}

func (BeaconVersion_BeaconVersion) isBeaconVersion() {}

func (CompanionStruct_BeaconVersion_) Create_BeaconVersion_(Version uint8, KeySource KeySource, VirtualFields _dafny.Map, Beacons _dafny.Map, BeaconNames _dafny.Sequence, StdNames _dafny.Sequence, EncryptedFields _dafny.Set) BeaconVersion {
	return BeaconVersion{BeaconVersion_BeaconVersion{Version, KeySource, VirtualFields, Beacons, BeaconNames, StdNames, EncryptedFields}}
}

func (_this BeaconVersion) Is_BeaconVersion() bool {
	_, ok := _this.Get_().(BeaconVersion_BeaconVersion)
	return ok
}

func (CompanionStruct_BeaconVersion_) Default() BeaconVersion {
	return Companion_BeaconVersion_.Create_BeaconVersion_(Companion_VersionNumber_.Witness(), Companion_KeySource_.Default(), _dafny.EmptyMap, _dafny.EmptyMap, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySet)
}

func (_this BeaconVersion) Dtor_version() uint8 {
	return _this.Get_().(BeaconVersion_BeaconVersion).Version
}

func (_this BeaconVersion) Dtor_keySource() KeySource {
	return _this.Get_().(BeaconVersion_BeaconVersion).KeySource
}

func (_this BeaconVersion) Dtor_virtualFields() _dafny.Map {
	return _this.Get_().(BeaconVersion_BeaconVersion).VirtualFields
}

func (_this BeaconVersion) Dtor_beacons() _dafny.Map {
	return _this.Get_().(BeaconVersion_BeaconVersion).Beacons
}

func (_this BeaconVersion) Dtor_beaconNames() _dafny.Sequence {
	return _this.Get_().(BeaconVersion_BeaconVersion).BeaconNames
}

func (_this BeaconVersion) Dtor_stdNames() _dafny.Sequence {
	return _this.Get_().(BeaconVersion_BeaconVersion).StdNames
}

func (_this BeaconVersion) Dtor_encryptedFields() _dafny.Set {
	return _this.Get_().(BeaconVersion_BeaconVersion).EncryptedFields
}

func (_this BeaconVersion) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BeaconVersion_BeaconVersion:
		{
			return "SearchableEncryptionInfo.BeaconVersion.BeaconVersion" + "(" + _dafny.String(data.Version) + ", " + _dafny.String(data.KeySource) + ", " + _dafny.String(data.VirtualFields) + ", " + _dafny.String(data.Beacons) + ", " + _dafny.String(data.BeaconNames) + ", " + _dafny.String(data.StdNames) + ", " + _dafny.String(data.EncryptedFields) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BeaconVersion) Equals(other BeaconVersion) bool {
	switch data1 := _this.Get_().(type) {
	case BeaconVersion_BeaconVersion:
		{
			data2, ok := other.Get_().(BeaconVersion_BeaconVersion)
			return ok && data1.Version == data2.Version && data1.KeySource.Equals(data2.KeySource) && data1.VirtualFields.Equals(data2.VirtualFields) && data1.Beacons.Equals(data2.Beacons) && data1.BeaconNames.Equals(data2.BeaconNames) && data1.StdNames.Equals(data2.StdNames) && data1.EncryptedFields.Equals(data2.EncryptedFields)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BeaconVersion) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BeaconVersion)
	return ok && _this.Equals(typed)
}

func Type_BeaconVersion_() _dafny.TypeDescriptor {
	return type_BeaconVersion_{}
}

type type_BeaconVersion_ struct {
}

func (_this type_BeaconVersion_) Default() interface{} {
	return Companion_BeaconVersion_.Default()
}

func (_this type_BeaconVersion_) String() string {
	return "SearchableEncryptionInfo.BeaconVersion"
}
func (_this BeaconVersion) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BeaconVersion{}

func (_this BeaconVersion) IsBeacon(field _dafny.Sequence) bool {
	{
		return ((_this).Dtor_beacons()).Contains(field)
	}
}
func (_this BeaconVersion) IsVirtualField(field _dafny.Sequence) bool {
	{
		return ((_this).Dtor_virtualFields()).Contains(field)
	}
}
func (_this BeaconVersion) GetFields(field _dafny.Sequence) _dafny.Sequence {
	{
		if (_this).IsBeacon(field) {
			return _dafny.Companion_Sequence_.Concatenate((((_this).Dtor_beacons()).Get(field).(Beacon)).GetFields((_this).Dtor_virtualFields()), _dafny.SeqOf(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("aws_dbe_b_"), field)))
		} else {
			return _dafny.SeqOf(field)
		}
	}
}
func (_this BeaconVersion) GetKeyMap(keyId m_DynamoDbEncryptionUtil.MaybeKeyId) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Dtor_keySource()).GetKeyMap((_this).Dtor_stdNames(), keyId)
		output = _out0
		return output
	}
}
func (_this BeaconVersion) ListSignedBeacons() _dafny.Sequence {
	{
		return m_Seq.Companion_Default___.Filter(func(coer112 func(_dafny.Sequence) bool) func(interface{}) bool {
			return func(arg141 interface{}) bool {
				return coer112(arg141.(_dafny.Sequence))
			}
		}(func(_0_s _dafny.Sequence) bool {
			return Companion_Default___.IsBeaconOfType(((_this).Dtor_beacons()).Get(_0_s).(Beacon), Companion_BeaconType_.Create_SignedBeacon_())
		}), (_this).Dtor_beaconNames())
	}
}
func (_this BeaconVersion) GeneratePlainBeacons(item _dafny.Map) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		output = (_this).GenerateBeacons2((_this).Dtor_beaconNames(), item, m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_DontUseKeys_(), Companion_BeaconType_.Create_AnyBeacon_(), _dafny.NewMapBuilder().ToMap())
		return output
	}
}
func (_this BeaconVersion) GenerateSignedBeacons(item _dafny.Map) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		output = (_this).GenerateBeacons2((_this).Dtor_beaconNames(), item, m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_DontUseKeys_(), Companion_BeaconType_.Create_SignedBeacon_(), _dafny.NewMapBuilder().ToMap())
		return output
	}
}
func (_this BeaconVersion) GenerateEncryptedBeacons(item _dafny.Map, keyId m_DynamoDbEncryptionUtil.MaybeKeyId) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = output
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Default())
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetKeyMap(keyId)
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_hmacKeys m_DynamoDbEncryptionUtil.MaybeKeyMap
		_ = _1_hmacKeys
		_1_hmacKeys = (_0_valueOrError0).Extract().(m_DynamoDbEncryptionUtil.MaybeKeyMap)
		output = (_this).GenerateBeacons2((_this).Dtor_beaconNames(), item, _1_hmacKeys, Companion_BeaconType_.Create_EncryptedBeacon_(), _dafny.NewMapBuilder().ToMap())
		return output
	}
}
func (_this BeaconVersion) GenerateBeacon(name _dafny.Sequence, item _dafny.Map, keys m_DynamoDbEncryptionUtil.MaybeKeyMap) m_Wrappers.Result {
	{
		return (((_this).Dtor_beacons()).Get(name).(Beacon)).AttrHash(item, (_this).Dtor_virtualFields(), keys)
	}
}
func (_this BeaconVersion) GenerateBeacons2(names _dafny.Sequence, item _dafny.Map, keys m_DynamoDbEncryptionUtil.MaybeKeyMap, bType BeaconType, acc _dafny.Map) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((names).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(acc)
		} else if (Companion_Default___.IsBeaconOfType(((_this).Dtor_beacons()).Get((names).Select(0).(_dafny.Sequence)).(Beacon), bType)) && (!(Companion_Default___.IsPartOnly(((_this).Dtor_beacons()).Get((names).Select(0).(_dafny.Sequence)).(Beacon)))) {
			var _0_valueOrError0 m_Wrappers.Result = (_this).GenerateBeacon((names).Select(0).(_dafny.Sequence), item, keys)
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_value m_Wrappers.Option = (_0_valueOrError0).Extract().(m_Wrappers.Option)
				_ = _1_value
				if (_1_value).Is_Some() {
					var _in0 BeaconVersion = _this
					_ = _in0
					var _in1 _dafny.Sequence = (names).Drop(1)
					_ = _in1
					var _in2 _dafny.Map = item
					_ = _in2
					var _in3 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
					_ = _in3
					var _in4 BeaconType = bType
					_ = _in4
					var _in5 _dafny.Map = (acc).Update((((_this).Dtor_beacons()).Get((names).Select(0).(_dafny.Sequence)).(Beacon)).GetBeaconName(), (_1_value).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue))
					_ = _in5
					_this = _in0

					names = _in1
					item = _in2
					keys = _in3
					bType = _in4
					acc = _in5
					goto TAIL_CALL_START
				} else {
					var _in6 BeaconVersion = _this
					_ = _in6
					var _in7 _dafny.Sequence = (names).Drop(1)
					_ = _in7
					var _in8 _dafny.Map = item
					_ = _in8
					var _in9 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
					_ = _in9
					var _in10 BeaconType = bType
					_ = _in10
					var _in11 _dafny.Map = acc
					_ = _in11
					_this = _in6

					names = _in7
					item = _in8
					keys = _in9
					bType = _in10
					acc = _in11
					goto TAIL_CALL_START
				}
			}
		} else {
			var _in12 BeaconVersion = _this
			_ = _in12
			var _in13 _dafny.Sequence = (names).Drop(1)
			_ = _in13
			var _in14 _dafny.Map = item
			_ = _in14
			var _in15 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
			_ = _in15
			var _in16 BeaconType = bType
			_ = _in16
			var _in17 _dafny.Map = acc
			_ = _in17
			_this = _in12

			names = _in13
			item = _in14
			keys = _in15
			bType = _in16
			acc = _in17
			goto TAIL_CALL_START
		}
	}
}

// End of datatype BeaconVersion
