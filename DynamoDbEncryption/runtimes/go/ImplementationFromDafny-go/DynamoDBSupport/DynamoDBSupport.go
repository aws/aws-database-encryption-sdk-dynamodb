// Package DynamoDBSupport
// Dafny module DynamoDBSupport compiled into Go

package DynamoDBSupport

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
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
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
	m_MemoryMath "github.com/aws/aws-database-encryption-sdk-dynamodb/MemoryMath"
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
var _ m_MemoryMath.Dummy__
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
	return "DynamoDBSupport.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsWriteable(item _dafny.Map) m_Wrappers.Result {
	if _dafny.Quantifier((item).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _0_k _dafny.Sequence
		_0_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !((item).Contains(_0_k)) || (!(_dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.ReservedPrefix(), _0_k)))
	}) {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	} else {
		var _1_bad _dafny.Set = func() _dafny.Set {
			var _coll0 = _dafny.NewBuilder()
			_ = _coll0
			for _iter29 := _dafny.Iterate((item).Keys().Elements()); ; {
				_compr_0, _ok29 := _iter29()
				if !_ok29 {
					break
				}
				var _2_k _dafny.Sequence
				_2_k = interface{}(_compr_0).(_dafny.Sequence)
				if ((item).Contains(_2_k)) && (_dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.ReservedPrefix(), _2_k)) {
					_coll0.Add(_2_k)
				}
			}
			return _coll0.ToSet()
		}()
		_ = _1_bad
		var _3_badSeq _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_1_bad, func(coer120 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg153 interface{}, arg154 interface{}) bool {
				return coer120(arg153.(_dafny.Char), arg154.(_dafny.Char))
			}
		}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
		_ = _3_badSeq
		if (_dafny.IntOfUint32((_3_badSeq).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString(""))
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Writing reserved attributes not allowed : "), m_StandardLibrary.Companion_Default___.Join(_3_badSeq, _dafny.SeqOfString("\n"))))
		}
	}
}
func (_static *CompanionStruct_Default___) GetEncryptedAttributes(actions _dafny.Map, expr m_Wrappers.Option, attrNames m_Wrappers.Option) _dafny.Sequence {
	if (expr).Is_None() {
		return _dafny.SeqOf()
	} else {
		var _0_attrs _dafny.Sequence = m_DynamoDBFilterExpr.Companion_Default___.ExtractAttributes((expr).Dtor_value().(_dafny.Sequence), attrNames)
		_ = _0_attrs
		return m_Seq.Companion_Default___.Filter(func(coer121 func(_dafny.Sequence) bool) func(interface{}) bool {
			return func(arg155 interface{}) bool {
				return coer121(arg155.(_dafny.Sequence))
			}
		}((func(_1_actions _dafny.Map) func(_dafny.Sequence) bool {
			return func(_2_attr _dafny.Sequence) bool {
				return Companion_Default___.IsEncrypted(_1_actions, _2_attr)
			}
		})(actions)), _0_attrs)
	}
}
func (_static *CompanionStruct_Default___) TestConditionExpression(actions _dafny.Map, expr m_Wrappers.Option, attrNames m_Wrappers.Option, attrValues m_Wrappers.Option) m_Wrappers.Result {
	if (expr).Is_Some() {
		var _0_attrs _dafny.Sequence = Companion_Default___.GetEncryptedAttributes(actions, expr, attrNames)
		_ = _0_attrs
		if (_dafny.IntOfUint32((_0_attrs).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(true)
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Condition Expressions forbidden on encrypted attributes : "), m_StandardLibrary.Companion_Default___.Join(_0_attrs, _dafny.SeqOfString(","))))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	}
}
func (_static *CompanionStruct_Default___) IsSigned(actions _dafny.Map, attr _dafny.Sequence) bool {
	return ((actions).Contains(attr)) && (!((actions).Get(attr).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()))
}
func (_static *CompanionStruct_Default___) IsEncrypted(actions _dafny.Map, attr _dafny.Sequence) bool {
	return ((actions).Contains(attr)) && (((actions).Get(attr).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()))
}
func (_static *CompanionStruct_Default___) TestUpdateExpression(actions _dafny.Map, expr m_Wrappers.Option, attrNames m_Wrappers.Option, attrValues m_Wrappers.Option) m_Wrappers.Result {
	if (expr).Is_Some() {
		var _0_attrs _dafny.Sequence = m_DynamoDbUpdateExpr.Companion_Default___.ExtractAttributes((expr).Dtor_value().(_dafny.Sequence), attrNames)
		_ = _0_attrs
		var _1_encryptedAttrs _dafny.Sequence = m_Seq.Companion_Default___.Filter(func(coer122 func(_dafny.Sequence) bool) func(interface{}) bool {
			return func(arg156 interface{}) bool {
				return coer122(arg156.(_dafny.Sequence))
			}
		}((func(_2_actions _dafny.Map) func(_dafny.Sequence) bool {
			return func(_3_s _dafny.Sequence) bool {
				return Companion_Default___.IsSigned(_2_actions, _3_s)
			}
		})(actions)), _0_attrs)
		_ = _1_encryptedAttrs
		if (_dafny.IntOfUint32((_1_encryptedAttrs).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(true)
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Update Expressions forbidden on signed attributes : "), m_StandardLibrary.Companion_Default___.Join(_1_encryptedAttrs, _dafny.SeqOfString(","))))
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(true)
	}
}
func (_static *CompanionStruct_Default___) GetEncryptedBeacons(search m_Wrappers.Option, item _dafny.Map, keyId m_DynamoDbEncryptionUtil.MaybeKeyId) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	if (search).Is_None() {
		output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.NewMapBuilder().ToMap())
		return output
	} else {
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).GenerateEncryptedBeacons(item, keyId)
		output = _out0
	}
	return output
}
func (_static *CompanionStruct_Default___) AddSignedBeacons(search m_Wrappers.Option, item _dafny.Map) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	if (search).Is_None() {
		output = m_Wrappers.Companion_Result_.Create_Success_(item)
		return output
	} else {
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).GenerateSignedBeacons(item)
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_newAttrs _dafny.Map
		_ = _1_newAttrs
		_1_newAttrs = (_0_valueOrError0).Extract().(_dafny.Map)
		var _2_badAttrs _dafny.Set
		_ = _2_badAttrs
		_2_badAttrs = func() _dafny.Set {
			var _coll0 = _dafny.NewBuilder()
			_ = _coll0
			for _iter30 := _dafny.Iterate((_1_newAttrs).Keys().Elements()); ; {
				_compr_0, _ok30 := _iter30()
				if !_ok30 {
					break
				}
				var _3_k _dafny.Sequence
				_3_k = interface{}(_compr_0).(_dafny.Sequence)
				if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_3_k) {
					if (((_1_newAttrs).Contains(_3_k)) && ((item).Contains(_3_k))) && (!((item).Get(_3_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((_1_newAttrs).Get(_3_k).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
						_coll0.Add(_3_k)
					}
				}
			}
			return _coll0.ToSet()
		}()
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError1
		_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_2_badAttrs).Cardinality()).Sign() == 0, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Signed beacons have generated values different from supplied values.")))
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_version _dafny.Map
		_ = _5_version
		_5_version = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.VersionTag(), m_DdbVirtualFields.Companion_Default___.DS(_dafny.SeqOfString(" ")))
		var _6_both _dafny.Set
		_ = _6_both
		_6_both = ((_1_newAttrs).Keys()).Intersection((item).Keys())
		var _7_bad _dafny.Set
		_ = _7_bad
		_7_bad = func() _dafny.Set {
			var _coll1 = _dafny.NewBuilder()
			_ = _coll1
			for _iter31 := _dafny.Iterate((_6_both).Elements()); ; {
				_compr_1, _ok31 := _iter31()
				if !_ok31 {
					break
				}
				var _8_k _dafny.Sequence
				_8_k = interface{}(_compr_1).(_dafny.Sequence)
				if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_8_k) {
					if ((_6_both).Contains(_8_k)) && (!((_1_newAttrs).Get(_8_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals((item).Get(_8_k).(m_ComAmazonawsDynamodbTypes.AttributeValue))) {
						_coll1.Add(_8_k)
					}
				}
			}
			return _coll1.ToSet()
		}()
		if ((_7_bad).Cardinality()).Sign() == 1 {
			var _9_badSeq _dafny.Sequence
			_ = _9_badSeq
			_9_badSeq = m_SortedSets.SetToOrderedSequence2(_7_bad, func(coer123 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
				return func(arg157 interface{}, arg158 interface{}) bool {
					return coer123(arg157.(_dafny.Char), arg158.(_dafny.Char))
				}
			}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Supplied Beacons do not match calculated beacons : "), m_StandardLibrary.Companion_Default___.Join(_9_badSeq, _dafny.SeqOfString(", ")))))
			return output
		}
		if ((((((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr()).Dtor_keySource()).Dtor_keyLoc()).Is_MultiLoc()) && ((((((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr()).Dtor_keySource()).Dtor_keyLoc()).Dtor_deleteKey()) {
			var _10_newItem _dafny.Map
			_ = _10_newItem
			_10_newItem = func() _dafny.Map {
				var _coll2 = _dafny.NewMapBuilder()
				_ = _coll2
				for _iter32 := _dafny.Iterate((item).Keys().Elements()); ; {
					_compr_2, _ok32 := _iter32()
					if !_ok32 {
						break
					}
					var _11_k _dafny.Sequence
					_11_k = interface{}(_compr_2).(_dafny.Sequence)
					if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_11_k) {
						if ((item).Contains(_11_k)) && (!_dafny.Companion_Sequence_.Equal(_11_k, (((((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr()).Dtor_keySource()).Dtor_keyLoc()).Dtor_keyName())) {
							_coll2.Add(_11_k, (item).Get(_11_k).(m_ComAmazonawsDynamodbTypes.AttributeValue))
						}
					}
				}
				return _coll2.ToMap()
			}()
			output = m_Wrappers.Companion_Result_.Create_Success_(((_10_newItem).Merge(_1_newAttrs)).Merge(_5_version))
			return output
		} else {
			output = m_Wrappers.Companion_Result_.Create_Success_(((item).Merge(_1_newAttrs)).Merge(_5_version))
			return output
		}
	}
	return output
}
func (_static *CompanionStruct_Default___) DoRemoveBeacons(item _dafny.Map) _dafny.Map {
	return func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter33 := _dafny.Iterate((item).Keys().Elements()); ; {
			_compr_0, _ok33 := _iter33()
			if !_ok33 {
				break
			}
			var _0_k _dafny.Sequence
			_0_k = interface{}(_compr_0).(_dafny.Sequence)
			if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_0_k) {
				if ((item).Contains(_0_k)) && (!(_dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.ReservedPrefix(), _0_k))) {
					_coll0.Add(_0_k, (item).Get(_0_k).(m_ComAmazonawsDynamodbTypes.AttributeValue))
				}
			}
		}
		return _coll0.ToMap()
	}()
}
func (_static *CompanionStruct_Default___) RemoveBeacons(search m_Wrappers.Option, item _dafny.Map) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DoRemoveBeacons(item))
}
func (_static *CompanionStruct_Default___) QueryInputForBeacons(search m_Wrappers.Option, actions _dafny.Map, req m_ComAmazonawsDynamodbTypes.QueryInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	if (search).Is_None() {
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_DynamoDBFilterExpr.Companion_Default___.TestBeaconize(actions, (req).Dtor_KeyConditionExpression(), (req).Dtor_FilterExpression(), (req).Dtor_ExpressionAttributeNames())
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1___v0 bool
		_ = _1___v0
		_1___v0 = (_0_valueOrError0).Extract().(bool)
		output = m_Wrappers.Companion_Result_.Create_Success_(req)
		return output
	} else {
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Default())
		_ = _2_valueOrError1
		_2_valueOrError1 = m_DynamoDBFilterExpr.Companion_Default___.GetBeaconKeyId(((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr(), (req).Dtor_KeyConditionExpression(), (req).Dtor_FilterExpression(), (req).Dtor_ExpressionAttributeValues(), (req).Dtor_ExpressionAttributeNames())
		if (_2_valueOrError1).IsFailure() {
			output = (_2_valueOrError1).PropagateFailure()
			return output
		}
		var _3_keyId m_DynamoDbEncryptionUtil.MaybeKeyId
		_ = _3_keyId
		_3_keyId = (_2_valueOrError1).Extract().(m_DynamoDbEncryptionUtil.MaybeKeyId)
		var _4_oldContext m_DynamoDBFilterExpr.ExprContext
		_ = _4_oldContext
		_4_oldContext = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_((req).Dtor_KeyConditionExpression(), (req).Dtor_FilterExpression(), (req).Dtor_ExpressionAttributeValues(), (req).Dtor_ExpressionAttributeNames())
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
		_ = _5_valueOrError2
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr(), _4_oldContext, _3_keyId, false)
		_5_valueOrError2 = _out1
		if (_5_valueOrError2).IsFailure() {
			output = (_5_valueOrError2).PropagateFailure()
			return output
		}
		var _6_newContext m_DynamoDBFilterExpr.ExprContext
		_ = _6_newContext
		_6_newContext = (_5_valueOrError2).Extract().(m_DynamoDBFilterExpr.ExprContext)
		var _pat_let_tv0 = _6_newContext
		_ = _pat_let_tv0
		var _pat_let_tv1 = _6_newContext
		_ = _pat_let_tv1
		var _pat_let_tv2 = _6_newContext
		_ = _pat_let_tv2
		var _pat_let_tv3 = _6_newContext
		_ = _pat_let_tv3
		output = m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let1_0 m_ComAmazonawsDynamodbTypes.QueryInput) m_ComAmazonawsDynamodbTypes.QueryInput {
			return func(_7_dt__update__tmp_h0 m_ComAmazonawsDynamodbTypes.QueryInput) m_ComAmazonawsDynamodbTypes.QueryInput {
				return func(_pat_let2_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
					return func(_8_dt__update_hExpressionAttributeValues_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
						return func(_pat_let3_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
							return func(_9_dt__update_hExpressionAttributeNames_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
								return func(_pat_let4_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
									return func(_10_dt__update_hFilterExpression_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
										return func(_pat_let5_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
											return func(_11_dt__update_hKeyConditionExpression_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
												return m_ComAmazonawsDynamodbTypes.Companion_QueryInput_.Create_QueryInput_((_7_dt__update__tmp_h0).Dtor_TableName(), (_7_dt__update__tmp_h0).Dtor_IndexName(), (_7_dt__update__tmp_h0).Dtor_Select(), (_7_dt__update__tmp_h0).Dtor_AttributesToGet(), (_7_dt__update__tmp_h0).Dtor_Limit(), (_7_dt__update__tmp_h0).Dtor_ConsistentRead(), (_7_dt__update__tmp_h0).Dtor_KeyConditions(), (_7_dt__update__tmp_h0).Dtor_QueryFilter(), (_7_dt__update__tmp_h0).Dtor_ConditionalOperator(), (_7_dt__update__tmp_h0).Dtor_ScanIndexForward(), (_7_dt__update__tmp_h0).Dtor_ExclusiveStartKey(), (_7_dt__update__tmp_h0).Dtor_ReturnConsumedCapacity(), (_7_dt__update__tmp_h0).Dtor_ProjectionExpression(), _10_dt__update_hFilterExpression_h0, _11_dt__update_hKeyConditionExpression_h0, _9_dt__update_hExpressionAttributeNames_h0, _8_dt__update_hExpressionAttributeValues_h0)
											}(_pat_let5_0)
										}((_pat_let_tv3).Dtor_keyExpr())
									}(_pat_let4_0)
								}((_pat_let_tv2).Dtor_filterExpr())
							}(_pat_let3_0)
						}((_pat_let_tv1).Dtor_names())
					}(_pat_let2_0)
				}((_pat_let_tv0).Dtor_values())
			}(_pat_let1_0)
		}(req))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) QueryOutputForBeacons(search m_Wrappers.Option, req m_ComAmazonawsDynamodbTypes.QueryInput, resp m_ComAmazonawsDynamodbTypes.QueryOutput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_QueryOutput_.Default())
	_ = output
	if (search).Is_None() {
		var _0_trimmedItems _dafny.Sequence
		_ = _0_trimmedItems
		_0_trimmedItems = m_Seq.Companion_Default___.Map(func(coer124 func(_dafny.Map) _dafny.Map) func(interface{}) interface{} {
			return func(arg159 interface{}) interface{} {
				return coer124(arg159.(_dafny.Map))
			}
		}(func(_1_i _dafny.Map) _dafny.Map {
			return Companion_Default___.DoRemoveBeacons(_1_i)
		}), ((resp).Dtor_Items()).Dtor_value().(_dafny.Sequence))
		var _pat_let_tv0 = _0_trimmedItems
		_ = _pat_let_tv0
		output = m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let6_0 m_ComAmazonawsDynamodbTypes.QueryOutput) m_ComAmazonawsDynamodbTypes.QueryOutput {
			return func(_2_dt__update__tmp_h0 m_ComAmazonawsDynamodbTypes.QueryOutput) m_ComAmazonawsDynamodbTypes.QueryOutput {
				return func(_pat_let7_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryOutput {
					return func(_3_dt__update_hItems_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryOutput {
						return m_ComAmazonawsDynamodbTypes.Companion_QueryOutput_.Create_QueryOutput_(_3_dt__update_hItems_h0, (_2_dt__update__tmp_h0).Dtor_Count(), (_2_dt__update__tmp_h0).Dtor_ScannedCount(), (_2_dt__update__tmp_h0).Dtor_LastEvaluatedKey(), (_2_dt__update__tmp_h0).Dtor_ConsumedCapacity())
					}(_pat_let7_0)
				}(m_Wrappers.Companion_Option_.Create_Some_(_pat_let_tv0))
			}(_pat_let6_0)
		}(resp))
		return output
	} else {
		var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr(), ((resp).Dtor_Items()).Dtor_value().(_dafny.Sequence), (req).Dtor_KeyConditionExpression(), (req).Dtor_FilterExpression(), (req).Dtor_ExpressionAttributeNames(), (req).Dtor_ExpressionAttributeValues())
		_4_valueOrError0 = _out0
		if (_4_valueOrError0).IsFailure() {
			output = (_4_valueOrError0).PropagateFailure()
			return output
		}
		var _5_newItems _dafny.Sequence
		_ = _5_newItems
		_5_newItems = (_4_valueOrError0).Extract().(_dafny.Sequence)
		var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _6_valueOrError1
		_6_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_5_newItems).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()) < 0, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("This is impossible.")))
		if (_6_valueOrError1).IsFailure() {
			output = (_6_valueOrError1).PropagateFailure()
			return output
		}
		var _7_trimmedItems _dafny.Sequence
		_ = _7_trimmedItems
		_7_trimmedItems = m_Seq.Companion_Default___.Map(func(coer125 func(_dafny.Map) _dafny.Map) func(interface{}) interface{} {
			return func(arg160 interface{}) interface{} {
				return coer125(arg160.(_dafny.Map))
			}
		}(func(_8_i _dafny.Map) _dafny.Map {
			return Companion_Default___.DoRemoveBeacons(_8_i)
		}), _5_newItems)
		var _9_count m_Wrappers.Option
		_ = _9_count
		if ((resp).Dtor_Count()).Is_Some() {
			_9_count = m_Wrappers.Companion_Option_.Create_Some_(int32((_7_trimmedItems).Cardinality()))
		} else {
			_9_count = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _pat_let_tv1 = _9_count
		_ = _pat_let_tv1
		var _pat_let_tv2 = _7_trimmedItems
		_ = _pat_let_tv2
		output = m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let8_0 m_ComAmazonawsDynamodbTypes.QueryOutput) m_ComAmazonawsDynamodbTypes.QueryOutput {
			return func(_10_dt__update__tmp_h1 m_ComAmazonawsDynamodbTypes.QueryOutput) m_ComAmazonawsDynamodbTypes.QueryOutput {
				return func(_pat_let9_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryOutput {
					return func(_11_dt__update_hCount_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryOutput {
						return func(_pat_let10_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryOutput {
							return func(_12_dt__update_hItems_h1 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryOutput {
								return m_ComAmazonawsDynamodbTypes.Companion_QueryOutput_.Create_QueryOutput_(_12_dt__update_hItems_h1, _11_dt__update_hCount_h0, (_10_dt__update__tmp_h1).Dtor_ScannedCount(), (_10_dt__update__tmp_h1).Dtor_LastEvaluatedKey(), (_10_dt__update__tmp_h1).Dtor_ConsumedCapacity())
							}(_pat_let10_0)
						}(m_Wrappers.Companion_Option_.Create_Some_(_pat_let_tv2))
					}(_pat_let9_0)
				}(_pat_let_tv1)
			}(_pat_let8_0)
		}(resp))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) GetBeaconKeyId(search m_Wrappers.Option, keyExpr m_Wrappers.Option, filterExpr m_Wrappers.Option, values m_Wrappers.Option, names m_Wrappers.Option) m_Wrappers.Result {
	if (search).Is_None() {
		return m_Wrappers.Companion_Result_.Create_Success_(m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Create_DontUseKeyId_())
	} else {
		return m_DynamoDBFilterExpr.Companion_Default___.GetBeaconKeyId(((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr(), keyExpr, filterExpr, values, names)
	}
}
func (_static *CompanionStruct_Default___) ScanInputForBeacons(search m_Wrappers.Option, actions _dafny.Map, req m_ComAmazonawsDynamodbTypes.ScanInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	if (search).Is_None() {
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_DynamoDBFilterExpr.Companion_Default___.TestBeaconize(actions, m_Wrappers.Companion_Option_.Create_None_(), (req).Dtor_FilterExpression(), (req).Dtor_ExpressionAttributeNames())
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1___v1 bool
		_ = _1___v1
		_1___v1 = (_0_valueOrError0).Extract().(bool)
		output = m_Wrappers.Companion_Result_.Create_Success_(req)
		return output
	} else {
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDbEncryptionUtil.Companion_MaybeKeyId_.Default())
		_ = _2_valueOrError1
		_2_valueOrError1 = m_DynamoDBFilterExpr.Companion_Default___.GetBeaconKeyId(((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr(), m_Wrappers.Companion_Option_.Create_None_(), (req).Dtor_FilterExpression(), (req).Dtor_ExpressionAttributeValues(), (req).Dtor_ExpressionAttributeNames())
		if (_2_valueOrError1).IsFailure() {
			output = (_2_valueOrError1).PropagateFailure()
			return output
		}
		var _3_keyId m_DynamoDbEncryptionUtil.MaybeKeyId
		_ = _3_keyId
		_3_keyId = (_2_valueOrError1).Extract().(m_DynamoDbEncryptionUtil.MaybeKeyId)
		var _4_context m_DynamoDBFilterExpr.ExprContext
		_ = _4_context
		_4_context = m_DynamoDBFilterExpr.Companion_ExprContext_.Create_ExprContext_(m_Wrappers.Companion_Option_.Create_None_(), (req).Dtor_FilterExpression(), (req).Dtor_ExpressionAttributeValues(), (req).Dtor_ExpressionAttributeNames())
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_DynamoDBFilterExpr.Companion_ExprContext_.Default())
		_ = _5_valueOrError2
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_DynamoDBFilterExpr.Companion_Default___.Beaconize(((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr(), _4_context, _3_keyId, false)
		_5_valueOrError2 = _out1
		if (_5_valueOrError2).IsFailure() {
			output = (_5_valueOrError2).PropagateFailure()
			return output
		}
		var _6_newContext m_DynamoDBFilterExpr.ExprContext
		_ = _6_newContext
		_6_newContext = (_5_valueOrError2).Extract().(m_DynamoDBFilterExpr.ExprContext)
		var _pat_let_tv0 = _6_newContext
		_ = _pat_let_tv0
		var _pat_let_tv1 = _6_newContext
		_ = _pat_let_tv1
		var _pat_let_tv2 = _6_newContext
		_ = _pat_let_tv2
		output = m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let11_0 m_ComAmazonawsDynamodbTypes.ScanInput) m_ComAmazonawsDynamodbTypes.ScanInput {
			return func(_7_dt__update__tmp_h0 m_ComAmazonawsDynamodbTypes.ScanInput) m_ComAmazonawsDynamodbTypes.ScanInput {
				return func(_pat_let12_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanInput {
					return func(_8_dt__update_hExpressionAttributeValues_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanInput {
						return func(_pat_let13_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanInput {
							return func(_9_dt__update_hExpressionAttributeNames_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanInput {
								return func(_pat_let14_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanInput {
									return func(_10_dt__update_hFilterExpression_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanInput {
										return m_ComAmazonawsDynamodbTypes.Companion_ScanInput_.Create_ScanInput_((_7_dt__update__tmp_h0).Dtor_TableName(), (_7_dt__update__tmp_h0).Dtor_IndexName(), (_7_dt__update__tmp_h0).Dtor_AttributesToGet(), (_7_dt__update__tmp_h0).Dtor_Limit(), (_7_dt__update__tmp_h0).Dtor_Select(), (_7_dt__update__tmp_h0).Dtor_ScanFilter(), (_7_dt__update__tmp_h0).Dtor_ConditionalOperator(), (_7_dt__update__tmp_h0).Dtor_ExclusiveStartKey(), (_7_dt__update__tmp_h0).Dtor_ReturnConsumedCapacity(), (_7_dt__update__tmp_h0).Dtor_TotalSegments(), (_7_dt__update__tmp_h0).Dtor_Segment(), (_7_dt__update__tmp_h0).Dtor_ProjectionExpression(), _10_dt__update_hFilterExpression_h0, _9_dt__update_hExpressionAttributeNames_h0, _8_dt__update_hExpressionAttributeValues_h0, (_7_dt__update__tmp_h0).Dtor_ConsistentRead())
									}(_pat_let14_0)
								}((_pat_let_tv2).Dtor_filterExpr())
							}(_pat_let13_0)
						}((_pat_let_tv1).Dtor_names())
					}(_pat_let12_0)
				}((_pat_let_tv0).Dtor_values())
			}(_pat_let11_0)
		}(req))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) ScanOutputForBeacons(search m_Wrappers.Option, req m_ComAmazonawsDynamodbTypes.ScanInput, resp m_ComAmazonawsDynamodbTypes.ScanOutput) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_ScanOutput_.Default())
	_ = ret
	if (search).Is_None() {
		var _0_trimmedItems _dafny.Sequence
		_ = _0_trimmedItems
		_0_trimmedItems = m_Seq.Companion_Default___.Map(func(coer126 func(_dafny.Map) _dafny.Map) func(interface{}) interface{} {
			return func(arg161 interface{}) interface{} {
				return coer126(arg161.(_dafny.Map))
			}
		}(func(_1_i _dafny.Map) _dafny.Map {
			return Companion_Default___.DoRemoveBeacons(_1_i)
		}), ((resp).Dtor_Items()).Dtor_value().(_dafny.Sequence))
		var _pat_let_tv0 = _0_trimmedItems
		_ = _pat_let_tv0
		ret = m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let15_0 m_ComAmazonawsDynamodbTypes.ScanOutput) m_ComAmazonawsDynamodbTypes.ScanOutput {
			return func(_2_dt__update__tmp_h0 m_ComAmazonawsDynamodbTypes.ScanOutput) m_ComAmazonawsDynamodbTypes.ScanOutput {
				return func(_pat_let16_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanOutput {
					return func(_3_dt__update_hItems_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanOutput {
						return m_ComAmazonawsDynamodbTypes.Companion_ScanOutput_.Create_ScanOutput_(_3_dt__update_hItems_h0, (_2_dt__update__tmp_h0).Dtor_Count(), (_2_dt__update__tmp_h0).Dtor_ScannedCount(), (_2_dt__update__tmp_h0).Dtor_LastEvaluatedKey(), (_2_dt__update__tmp_h0).Dtor_ConsumedCapacity())
					}(_pat_let16_0)
				}(m_Wrappers.Companion_Option_.Create_Some_(_pat_let_tv0))
			}(_pat_let15_0)
		}(resp))
		return ret
	} else {
		var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(((search).Dtor_value().(m_SearchableEncryptionInfo.SearchInfo)).Curr(), ((resp).Dtor_Items()).Dtor_value().(_dafny.Sequence), m_Wrappers.Companion_Option_.Create_None_(), (req).Dtor_FilterExpression(), (req).Dtor_ExpressionAttributeNames(), (req).Dtor_ExpressionAttributeValues())
		_4_valueOrError0 = _out0
		if (_4_valueOrError0).IsFailure() {
			ret = (_4_valueOrError0).PropagateFailure()
			return ret
		}
		var _5_newItems _dafny.Sequence
		_ = _5_newItems
		_5_newItems = (_4_valueOrError0).Extract().(_dafny.Sequence)
		var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _6_valueOrError1
		_6_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_5_newItems).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()) < 0, m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("This is impossible.")))
		if (_6_valueOrError1).IsFailure() {
			ret = (_6_valueOrError1).PropagateFailure()
			return ret
		}
		var _7_trimmedItems _dafny.Sequence
		_ = _7_trimmedItems
		_7_trimmedItems = m_Seq.Companion_Default___.Map(func(coer127 func(_dafny.Map) _dafny.Map) func(interface{}) interface{} {
			return func(arg162 interface{}) interface{} {
				return coer127(arg162.(_dafny.Map))
			}
		}(func(_8_i _dafny.Map) _dafny.Map {
			return Companion_Default___.DoRemoveBeacons(_8_i)
		}), _5_newItems)
		var _9_count m_Wrappers.Option
		_ = _9_count
		if ((resp).Dtor_Count()).Is_Some() {
			_9_count = m_Wrappers.Companion_Option_.Create_Some_(int32((_7_trimmedItems).Cardinality()))
		} else {
			_9_count = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _pat_let_tv1 = _9_count
		_ = _pat_let_tv1
		var _pat_let_tv2 = _7_trimmedItems
		_ = _pat_let_tv2
		ret = m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let17_0 m_ComAmazonawsDynamodbTypes.ScanOutput) m_ComAmazonawsDynamodbTypes.ScanOutput {
			return func(_10_dt__update__tmp_h1 m_ComAmazonawsDynamodbTypes.ScanOutput) m_ComAmazonawsDynamodbTypes.ScanOutput {
				return func(_pat_let18_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanOutput {
					return func(_11_dt__update_hCount_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanOutput {
						return func(_pat_let19_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanOutput {
							return func(_12_dt__update_hItems_h1 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanOutput {
								return m_ComAmazonawsDynamodbTypes.Companion_ScanOutput_.Create_ScanOutput_(_12_dt__update_hItems_h1, _11_dt__update_hCount_h0, (_10_dt__update__tmp_h1).Dtor_ScannedCount(), (_10_dt__update__tmp_h1).Dtor_LastEvaluatedKey(), (_10_dt__update__tmp_h1).Dtor_ConsumedCapacity())
							}(_pat_let19_0)
						}(m_Wrappers.Companion_Option_.Create_Some_(_pat_let_tv2))
					}(_pat_let18_0)
				}(_pat_let_tv1)
			}(_pat_let17_0)
		}(resp))
		return ret
	}
	return ret
}
func (_static *CompanionStruct_Default___) GetVirtualFieldsLoop(fields _dafny.Sequence, bv m_SearchableEncryptionInfo.BeaconVersion, item _dafny.Map, results _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((fields).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(results)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = m_DdbVirtualFields.Companion_Default___.GetVirtField(((bv).Dtor_virtualFields()).Get((fields).Select(0).(_dafny.Sequence)).(m_DdbVirtualFields.VirtField), item)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_optValue m_Wrappers.Option = (_0_valueOrError0).Extract().(m_Wrappers.Option)
			_ = _1_optValue
			if (_1_optValue).Is_Some() {
				var _in0 _dafny.Sequence = (fields).Drop(1)
				_ = _in0
				var _in1 m_SearchableEncryptionInfo.BeaconVersion = bv
				_ = _in1
				var _in2 _dafny.Map = item
				_ = _in2
				var _in3 _dafny.Map = (results).Update((fields).Select(0).(_dafny.Sequence), (_1_optValue).Dtor_value().(_dafny.Sequence))
				_ = _in3
				fields = _in0
				bv = _in1
				item = _in2
				results = _in3
				goto TAIL_CALL_START
			} else {
				var _in4 _dafny.Sequence = (fields).Drop(1)
				_ = _in4
				var _in5 m_SearchableEncryptionInfo.BeaconVersion = bv
				_ = _in5
				var _in6 _dafny.Map = item
				_ = _in6
				var _in7 _dafny.Map = results
				_ = _in7
				fields = _in4
				bv = _in5
				item = _in6
				results = _in7
				goto TAIL_CALL_START
			}
		}
	}
}
func (_static *CompanionStruct_Default___) GetVirtualFields(beaconVersion m_SearchableEncryptionInfo.BeaconVersion, item _dafny.Map) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_fieldNames _dafny.Sequence
	_ = _0_fieldNames
	_0_fieldNames = m_SortedSets.SetToOrderedSequence2(((beaconVersion).Dtor_virtualFields()).Keys(), func(coer128 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg163 interface{}, arg164 interface{}) bool {
			return coer128(arg163.(_dafny.Char), arg164.(_dafny.Char))
		}
	}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
	output = Companion_Default___.GetVirtualFieldsLoop(_0_fieldNames, beaconVersion, item, _dafny.NewMapBuilder().ToMap())
	return output
}
func (_static *CompanionStruct_Default___) GetCompoundBeaconsLoop(fields _dafny.Sequence, bv m_SearchableEncryptionInfo.BeaconVersion, item _dafny.Map, results _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((fields).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(results)
	} else {
		var _0_beacon m_SearchableEncryptionInfo.Beacon = ((bv).Dtor_beacons()).Get((fields).Select(0).(_dafny.Sequence)).(m_SearchableEncryptionInfo.Beacon)
		_ = _0_beacon
		if (_0_beacon).Is_Compound() {
			var _1_valueOrError0 m_Wrappers.Result = ((_0_beacon).Dtor_cmp()).GetNaked(item, (bv).Dtor_virtualFields())
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _2_optValue m_Wrappers.Option = (_1_valueOrError0).Extract().(m_Wrappers.Option)
				_ = _2_optValue
				if (_2_optValue).Is_Some() {
					var _in0 _dafny.Sequence = (fields).Drop(1)
					_ = _in0
					var _in1 m_SearchableEncryptionInfo.BeaconVersion = bv
					_ = _in1
					var _in2 _dafny.Map = item
					_ = _in2
					var _in3 _dafny.Map = (results).Update((fields).Select(0).(_dafny.Sequence), (_2_optValue).Dtor_value().(_dafny.Sequence))
					_ = _in3
					fields = _in0
					bv = _in1
					item = _in2
					results = _in3
					goto TAIL_CALL_START
				} else {
					var _in4 _dafny.Sequence = (fields).Drop(1)
					_ = _in4
					var _in5 m_SearchableEncryptionInfo.BeaconVersion = bv
					_ = _in5
					var _in6 _dafny.Map = item
					_ = _in6
					var _in7 _dafny.Map = results
					_ = _in7
					fields = _in4
					bv = _in5
					item = _in6
					results = _in7
					goto TAIL_CALL_START
				}
			}
		} else {
			var _in8 _dafny.Sequence = (fields).Drop(1)
			_ = _in8
			var _in9 m_SearchableEncryptionInfo.BeaconVersion = bv
			_ = _in9
			var _in10 _dafny.Map = item
			_ = _in10
			var _in11 _dafny.Map = results
			_ = _in11
			fields = _in8
			bv = _in9
			item = _in10
			results = _in11
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) GetCompoundBeacons(beaconVersion m_SearchableEncryptionInfo.BeaconVersion, item _dafny.Map) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_beaconNames _dafny.Sequence
	_ = _0_beaconNames
	_0_beaconNames = m_SortedSets.SetToOrderedSequence2(((beaconVersion).Dtor_beacons()).Keys(), func(coer129 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg165 interface{}, arg166 interface{}) bool {
			return coer129(arg165.(_dafny.Char), arg166.(_dafny.Char))
		}
	}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
	output = Companion_Default___.GetCompoundBeaconsLoop(_0_beaconNames, beaconVersion, item, _dafny.NewMapBuilder().ToMap())
	return output
}
func (_static *CompanionStruct_Default___) VersionTag() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(m_DynamoDbEncryptionUtil.Companion_Default___.VersionPrefix(), _dafny.SeqOfString("1"))
}

// End of class Default__
