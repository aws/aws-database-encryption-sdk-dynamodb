// Package DdbStatement
// Dafny module DdbStatement compiled into Go

package DdbStatement

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
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/BaseBeacon"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m_CompoundBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/CompoundBeacon"
	m_DdbMiddlewareConfig "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbMiddlewareConfig"
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
	return "DdbStatement.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) UnQuote(s _dafny.Sequence) _dafny.Sequence {
	var _0_s _dafny.Sequence = (func() _dafny.Sequence {
		if ((_dafny.IntOfUint32((s).Cardinality())).Sign() == 1) && (((s).Select(0).(_dafny.Char)) == (_dafny.Char('"'))) {
			return (s).Drop(1)
		}
		return s
	})()
	_ = _0_s
	if ((_dafny.IntOfUint32((_0_s).Cardinality())).Sign() == 1) && (((_0_s).Select(((_dafny.IntOfUint32((_0_s).Cardinality())).Minus(_dafny.One)).Uint32()).(_dafny.Char)) == (_dafny.Char('"'))) {
		return (_0_s).Subsequence(0, ((_dafny.IntOfUint32((_0_s).Cardinality())).Minus(_dafny.One)).Uint32())
	} else {
		return _0_s
	}
}
func (_static *CompanionStruct_Default___) GetTableName(s _dafny.Sequence) m_Wrappers.Option {
	var _0_s _dafny.Sequence = Companion_Default___.UnQuote(s)
	_ = _0_s
	if m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TableName(_0_s) {
		return m_Wrappers.Companion_Option_.Create_Some_(_0_s)
	} else {
		return m_Wrappers.Companion_Option_.Create_None_()
	}
}
func (_static *CompanionStruct_Default___) TableFromStatement(s _dafny.Sequence) m_Wrappers.Result {
	var _0_ret m_Wrappers.Option = Companion_Default___.TableFromStatementInner(s)
	_ = _0_ret
	if (_0_ret).Is_Some() {
		return m_Wrappers.Companion_Result_.Create_Success_((_0_ret).Dtor_value().(_dafny.Sequence))
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Unable to extract table name from PartiQL statement."))
	}
}
func (_static *CompanionStruct_Default___) TableFromStatementInner(s _dafny.Sequence) m_Wrappers.Option {
	var _0_s _dafny.Sequence = Companion_Default___.StripLeadingWhitespace(s)
	_ = _0_s
	if ((_dafny.IntOfUint32((_0_s).Cardinality())).Cmp(_dafny.IntOfInt64(6)) > 0) && (_dafny.Companion_Sequence_.Equal(Companion_Default___.AsciiLower((_0_s).Subsequence(0, 6)), _dafny.SeqOfString("exists"))) {
		return Companion_Default___.TableFromExistsStatement((_0_s).Drop(6))
	} else {
		var _1_len _dafny.Int = Companion_Default___.FindTokenLen(_0_s)
		_ = _1_len
		var _2_cmd _dafny.Sequence = Companion_Default___.AsciiLower((_0_s).Take((_1_len).Uint32()))
		_ = _2_cmd
		if _dafny.Companion_Sequence_.Equal(_2_cmd, _dafny.SeqOfString("select")) {
			return Companion_Default___.TableFromSelectStatement((_0_s).Drop((_1_len).Uint32()))
		} else if _dafny.Companion_Sequence_.Equal(_2_cmd, _dafny.SeqOfString("update")) {
			return Companion_Default___.TableFromUpdateStatement((_0_s).Drop((_1_len).Uint32()))
		} else if _dafny.Companion_Sequence_.Equal(_2_cmd, _dafny.SeqOfString("delete")) {
			return Companion_Default___.TableFromDeleteStatement((_0_s).Drop((_1_len).Uint32()))
		} else if _dafny.Companion_Sequence_.Equal(_2_cmd, _dafny.SeqOfString("insert")) {
			return Companion_Default___.TableFromInsertStatement((_0_s).Drop((_1_len).Uint32()))
		} else {
			return m_Wrappers.Companion_Option_.Create_None_()
		}
	}
}
func (_static *CompanionStruct_Default___) TableFromSelectStatementInner(s _dafny.Sequence) m_Wrappers.Option {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _0_t _dafny.Sequence = Companion_Default___.StripLeadingWhitespace(s)
		_ = _0_t
		var _1_len _dafny.Int = Companion_Default___.FindTokenLen(_0_t)
		_ = _1_len
		if _dafny.Companion_Sequence_.Equal(Companion_Default___.AsciiLower((_0_t).Take((_1_len).Uint32())), _dafny.SeqOfString("from")) {
			var _2_t _dafny.Sequence = Companion_Default___.StripLeadingWhitespace((_0_t).Drop((_1_len).Uint32()))
			_ = _2_t
			var _3_len _dafny.Int = Companion_Default___.FindTokenLen(_2_t)
			_ = _3_len
			return m_Wrappers.Companion_Option_.Create_Some_((_2_t).Take((_3_len).Uint32()))
		} else if (_1_len).Sign() == 0 {
			return m_Wrappers.Companion_Option_.Create_None_()
		} else {
			var _in0 _dafny.Sequence = (_0_t).Drop((_1_len).Uint32())
			_ = _in0
			s = _in0
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) TableFromExistsStatement(s _dafny.Sequence) m_Wrappers.Option {
	var _0_s _dafny.Sequence = Companion_Default___.StripLeadingWhitespace(s)
	_ = _0_s
	if ((_dafny.IntOfUint32((_0_s).Cardinality())).Sign() == 0) || (((_0_s).Select(0).(_dafny.Char)) != (_dafny.Char('(')) /* dircomp */) {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _1_s _dafny.Sequence = Companion_Default___.StripLeadingWhitespace((_0_s).Drop(1))
		_ = _1_s
		var _2_len _dafny.Int = Companion_Default___.FindTokenLen(_1_s)
		_ = _2_len
		if _dafny.Companion_Sequence_.Equal(Companion_Default___.AsciiLower((_1_s).Take((_2_len).Uint32())), _dafny.SeqOfString("select")) {
			return Companion_Default___.TableFromSelectStatement((_1_s).Drop((_2_len).Uint32()))
		} else {
			return m_Wrappers.Companion_Option_.Create_None_()
		}
	}
}
func (_static *CompanionStruct_Default___) TableFromSelectStatement(s _dafny.Sequence) m_Wrappers.Option {
	var _0_valueOrError0 m_Wrappers.Option = Companion_Default___.TableFromSelectStatementInner(s)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_name _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_name
		if _dafny.Companion_Sequence_.Contains(_1_name, _dafny.Char('.')) {
			var _2_x _dafny.Tuple = m_StandardLibrary.Companion_Default___.SplitOnce(_1_name, _dafny.Char('.'))
			_ = _2_x
			return Companion_Default___.GetTableName((*(_2_x).IndexInt(0)).(_dafny.Sequence))
		} else {
			return Companion_Default___.GetTableName(_1_name)
		}
	}
}
func (_static *CompanionStruct_Default___) TableFromUpdateStatement(s _dafny.Sequence) m_Wrappers.Option {
	var _0_s _dafny.Sequence = Companion_Default___.StripLeadingWhitespace(s)
	_ = _0_s
	var _1_len _dafny.Int = Companion_Default___.FindTokenLen(_0_s)
	_ = _1_len
	if (_1_len).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		return Companion_Default___.GetTableName((_0_s).Take((_1_len).Uint32()))
	}
}
func (_static *CompanionStruct_Default___) TableFromDeleteStatement(s _dafny.Sequence) m_Wrappers.Option {
	var _0_s _dafny.Sequence = Companion_Default___.StripLeadingWhitespace(s)
	_ = _0_s
	var _1_len _dafny.Int = Companion_Default___.FindTokenLen(_0_s)
	_ = _1_len
	if !_dafny.Companion_Sequence_.Equal(Companion_Default___.AsciiLower((_0_s).Take((_1_len).Uint32())), _dafny.SeqOfString("from")) {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _2_s _dafny.Sequence = Companion_Default___.StripLeadingWhitespace((_0_s).Drop((_1_len).Uint32()))
		_ = _2_s
		var _3_len _dafny.Int = Companion_Default___.FindTokenLen(_2_s)
		_ = _3_len
		if (_3_len).Sign() == 0 {
			return m_Wrappers.Companion_Option_.Create_None_()
		} else {
			return Companion_Default___.GetTableName((_2_s).Take((_3_len).Uint32()))
		}
	}
}
func (_static *CompanionStruct_Default___) TableFromInsertStatement(s _dafny.Sequence) m_Wrappers.Option {
	var _0_s _dafny.Sequence = Companion_Default___.StripLeadingWhitespace(s)
	_ = _0_s
	var _1_len _dafny.Int = Companion_Default___.FindTokenLen(_0_s)
	_ = _1_len
	if !_dafny.Companion_Sequence_.Equal(Companion_Default___.AsciiLower((_0_s).Take((_1_len).Uint32())), _dafny.SeqOfString("into")) {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		var _2_s _dafny.Sequence = Companion_Default___.StripLeadingWhitespace((_0_s).Drop((_1_len).Uint32()))
		_ = _2_s
		var _3_len _dafny.Int = Companion_Default___.FindTokenLen(_2_s)
		_ = _3_len
		if (_3_len).Sign() == 0 {
			return m_Wrappers.Companion_Option_.Create_None_()
		} else {
			return Companion_Default___.GetTableName((_2_s).Take((_3_len).Uint32()))
		}
	}
}
func (_static *CompanionStruct_Default___) IsWhitespace(ch _dafny.Char) bool {
	return (ch) <= (_dafny.Char(' '))
}
func (_static *CompanionStruct_Default___) StripLeadingWhitespace(s _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if ((_dafny.IntOfUint32((s).Cardinality())).Sign() == 0) || (!(Companion_Default___.IsWhitespace((s).Select(0).(_dafny.Char)))) {
		return s
	} else {
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) AsciiLowerChar(ch _dafny.Char) _dafny.Char {
	if ((_dafny.Char('A')) <= (ch)) && ((ch) <= (_dafny.Char('Z'))) {
		return ((ch) - (_dafny.Char('A'))) + (_dafny.Char('a'))
	} else {
		return ch
	}
}
func (_static *CompanionStruct_Default___) AsciiLower(s _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, s)
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfChars(Companion_Default___.AsciiLowerChar((s).Select(0).(_dafny.Char))))
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FindTokenLen(s _dafny.Sequence) _dafny.Int {
	if ((_dafny.IntOfUint32((s).Cardinality())).Sign() == 0) || (Companion_Default___.IsWhitespace((s).Select(0).(_dafny.Char))) {
		return _dafny.Zero
	} else if ((s).Select(0).(_dafny.Char)) == (_dafny.Char('"')) {
		return (_dafny.One).Plus(Companion_Default___.FindTokenLenQuoted((s).Drop(1)))
	} else {
		return Companion_Default___.FindTokenLenPlain(s)
	}
}
func (_static *CompanionStruct_Default___) FindTokenLenPlain(s _dafny.Sequence) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if ((_dafny.IntOfUint32((s).Cardinality())).Sign() == 0) || (Companion_Default___.IsWhitespace((s).Select(0).(_dafny.Char))) {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else {
		_0___accumulator = (_0___accumulator).Plus(_dafny.One)
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FindTokenLenQuoted(s _dafny.Sequence) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else if ((s).Select(0).(_dafny.Char)) == (_dafny.Char('"')) {
		return (_dafny.One).Plus(_0___accumulator)
	} else {
		_0___accumulator = (_0___accumulator).Plus(_dafny.One)
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	}
}

// End of class Default__
