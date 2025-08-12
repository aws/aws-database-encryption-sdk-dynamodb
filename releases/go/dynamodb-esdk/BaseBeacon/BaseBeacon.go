// Package BaseBeacon
// Dafny module BaseBeacon compiled into Go

package BaseBeacon

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
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Canonize"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DdbVirtualFields"
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryption"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbItemEncryptorUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbNormalizeNumber"
	m_DynamoDbUpdateExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbUpdateExpr"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoToStruct"
	m_InternalLegacyOverride "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/InternalLegacyOverride"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Maps_"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/OptimizedMergeSort"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/SortCanon"
	m_StructuredEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryption"
	m_StructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionCrypt"
	m_StructuredEncryptionFooter "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionFooter"
	m_StructuredEncryptionHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionHeader"
	m_StructuredEncryptionPaths "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionPaths"
	m_StructuredEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/StructuredEncryptionUtil"
	m_TermLoc "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/TermLoc"
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
	return "BaseBeacon.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) MakeStandardBeacon(client *m_AtomicPrimitives.AtomicPrimitivesClient, name _dafny.Sequence, length uint8, loc _dafny.Sequence, partOnly bool, asSet bool, share m_Wrappers.Option) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_TermLoc.Companion_Default___.MakeTermLoc(loc)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_termLoc _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_termLoc
		var _2_beaconName _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(m_DynamoDbEncryptionUtil.Companion_Default___.BeaconPrefix(), name)
		_ = _2_beaconName
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_2_beaconName), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_2_beaconName, _dafny.SeqOfString(" is not a valid attribute name."))))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_StandardBeacon_.Create_StandardBeacon_(Companion_BeaconBase_.Create_BeaconBase_(client, name, _2_beaconName), length, _1_termLoc, partOnly, asSet, share))
		}
	}
}
func (_static *CompanionStruct_Default___) CharsFromBeaconLength(bits uint8) _dafny.Int {
	return _dafny.IntOfUint8(((uint8(bits)) + (uint8(3))) / (uint8(4)))
}
func (_static *CompanionStruct_Default___) TopBits(bits uint8) uint8 {
	var _0_x uint8 = (uint8(bits)) % (uint8(4))
	_ = _0_x
	if (_0_x) == (uint8(0)) {
		return uint8(4)
	} else {
		return _0_x
	}
}
func (_static *CompanionStruct_Default___) BytesFromBeaconLength(bits uint8) _dafny.Int {
	return _dafny.IntOfUint8(((uint8(bits)) + (uint8(7))) / (uint8(8)))
}
func (_static *CompanionStruct_Default___) TruncateNibble(nibble uint8, length uint8) uint8 {
	if (length) == (uint8(4)) {
		return nibble
	} else if (length) == (uint8(3)) {
		return (nibble) % (uint8(8))
	} else if (length) == (uint8(2)) {
		return (nibble) % (uint8(4))
	} else {
		return (nibble) % (uint8(2))
	}
}
func (_static *CompanionStruct_Default___) BytesToHex(bytes _dafny.Sequence, bits uint8) _dafny.Sequence {
	var _0_numBytes _dafny.Int = Companion_Default___.BytesFromBeaconLength(bits)
	_ = _0_numBytes
	var _1_numChars _dafny.Int = Companion_Default___.CharsFromBeaconLength(bits)
	_ = _1_numChars
	var _2_topBits uint8 = Companion_Default___.TopBits(bits)
	_ = _2_topBits
	var _3_bytes _dafny.Sequence = (bytes).Drop(((_dafny.IntOfInt64(8)).Minus(_0_numBytes)).Uint32())
	_ = _3_bytes
	if (_1_numChars).Cmp((_dafny.IntOfInt64(2)).Times(_0_numBytes)) == 0 {
		var _4_topNibble uint8 = ((_3_bytes).Select(0).(uint8)) / (uint8(16))
		_ = _4_topNibble
		var _5_bottomNibble uint8 = ((_3_bytes).Select(0).(uint8)) % (uint8(16))
		_ = _5_bottomNibble
		return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfChars(m_HexStrings.Companion_Default___.HexChar(Companion_Default___.TruncateNibble(_4_topNibble, _2_topBits)), m_HexStrings.Companion_Default___.HexChar(_5_bottomNibble)), m_HexStrings.Companion_Default___.ToHexString((_3_bytes).Drop(1)))
	} else {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfChars(m_HexStrings.Companion_Default___.HexChar(Companion_Default___.TruncateNibble(((_3_bytes).Select(0).(uint8))%(uint8(16)), _2_topBits))), m_HexStrings.Companion_Default___.ToHexString((_3_bytes).Drop(1)))
	}
}

// End of class Default__

// Definition of class BeaconLength
type BeaconLength struct {
}

func New_BeaconLength_() *BeaconLength {
	_this := BeaconLength{}

	return &_this
}

type CompanionStruct_BeaconLength_ struct {
}

var Companion_BeaconLength_ = CompanionStruct_BeaconLength_{}

func (*BeaconLength) String() string {
	return "BaseBeacon.BeaconLength"
}
func (_this *BeaconLength) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &BeaconLength{}

func (_this *CompanionStruct_BeaconLength_) IntegerRange(lo _dafny.Int, hi _dafny.Int) _dafny.Iterator {
	iter := _dafny.IntegerRange(lo, hi)
	return func() (interface{}, bool) {
		next, ok := iter()
		if !ok {
			return uint8(0), false
		}
		return next.(_dafny.Int).Uint8(), true
	}
}
func (_this *CompanionStruct_BeaconLength_) Witness() uint8 {
	return (_dafny.One).Uint8()
}

// End of class BeaconLength

func Type_BeaconLength_() _dafny.TypeDescriptor {
	return type_BeaconLength_{}
}

type type_BeaconLength_ struct {
}

func (_this type_BeaconLength_) Default() interface{} {
	return Companion_BeaconLength_.Witness()
}

func (_this type_BeaconLength_) String() string {
	return "BaseBeacon.BeaconLength"
}
func (_this *CompanionStruct_BeaconLength_) Is_(__source uint8) bool {
	var _6_x _dafny.Int = _dafny.IntOfUint8(__source)
	_ = _6_x
	return ((_dafny.One).Cmp(_6_x) <= 0) && ((_6_x).Cmp(_dafny.IntOfInt64(63)) <= 0)
}

// Definition of class Nibble
type Nibble struct {
}

func New_Nibble_() *Nibble {
	_this := Nibble{}

	return &_this
}

type CompanionStruct_Nibble_ struct {
}

var Companion_Nibble_ = CompanionStruct_Nibble_{}

func (*Nibble) String() string {
	return "BaseBeacon.Nibble"
}

// End of class Nibble

func Type_Nibble_() _dafny.TypeDescriptor {
	return type_Nibble_{}
}

type type_Nibble_ struct {
}

func (_this type_Nibble_) Default() interface{} {
	return uint8(0)
}

func (_this type_Nibble_) String() string {
	return "BaseBeacon.Nibble"
}
func (_this *CompanionStruct_Nibble_) Is_(__source uint8) bool {
	var _7_x uint8 = (__source)
	_ = _7_x
	if true {
		return ((uint8(0)) <= (_7_x)) && ((_7_x) < (uint8(16)))
	}
	return false
}

// Definition of datatype BeaconBase
type BeaconBase struct {
	Data_BeaconBase_
}

func (_this BeaconBase) Get_() Data_BeaconBase_ {
	return _this.Data_BeaconBase_
}

type Data_BeaconBase_ interface {
	isBeaconBase()
}

type CompanionStruct_BeaconBase_ struct {
}

var Companion_BeaconBase_ = CompanionStruct_BeaconBase_{}

type BeaconBase_BeaconBase struct {
	Client     *m_AtomicPrimitives.AtomicPrimitivesClient
	Name       _dafny.Sequence
	BeaconName _dafny.Sequence
}

func (BeaconBase_BeaconBase) isBeaconBase() {}

func (CompanionStruct_BeaconBase_) Create_BeaconBase_(Client *m_AtomicPrimitives.AtomicPrimitivesClient, Name _dafny.Sequence, BeaconName _dafny.Sequence) BeaconBase {
	return BeaconBase{BeaconBase_BeaconBase{Client, Name, BeaconName}}
}

func (_this BeaconBase) Is_BeaconBase() bool {
	_, ok := _this.Get_().(BeaconBase_BeaconBase)
	return ok
}

func (CompanionStruct_BeaconBase_) Default() BeaconBase {
	return Companion_BeaconBase_.Create_BeaconBase_((*m_AtomicPrimitives.AtomicPrimitivesClient)(nil), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this BeaconBase) Dtor_client() *m_AtomicPrimitives.AtomicPrimitivesClient {
	return _this.Get_().(BeaconBase_BeaconBase).Client
}

func (_this BeaconBase) Dtor_name() _dafny.Sequence {
	return _this.Get_().(BeaconBase_BeaconBase).Name
}

func (_this BeaconBase) Dtor_beaconName() _dafny.Sequence {
	return _this.Get_().(BeaconBase_BeaconBase).BeaconName
}

func (_this BeaconBase) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BeaconBase_BeaconBase:
		{
			return "BaseBeacon.BeaconBase.BeaconBase" + "(" + _dafny.String(data.Client) + ", " + _dafny.String(data.Name) + ", " + _dafny.String(data.BeaconName) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BeaconBase) Equals(other BeaconBase) bool {
	switch data1 := _this.Get_().(type) {
	case BeaconBase_BeaconBase:
		{
			data2, ok := other.Get_().(BeaconBase_BeaconBase)
			return ok && data1.Client == data2.Client && data1.Name.Equals(data2.Name) && data1.BeaconName.Equals(data2.BeaconName)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BeaconBase) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BeaconBase)
	return ok && _this.Equals(typed)
}

func Type_BeaconBase_() _dafny.TypeDescriptor {
	return type_BeaconBase_{}
}

type type_BeaconBase_ struct {
}

func (_this type_BeaconBase_) Default() interface{} {
	return Companion_BeaconBase_.Default()
}

func (_this type_BeaconBase_) String() string {
	return "BaseBeacon.BeaconBase"
}
func (_this BeaconBase) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BeaconBase{}

func (_this BeaconBase) Hash(val _dafny.Sequence, key _dafny.Sequence, length uint8) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Result = (_this).GetHmac(val, key)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_hash _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_hash
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.BytesToHex(_1_hash, length))
		}
	}
}
func (_this BeaconBase) HashStr(val _dafny.Sequence, key _dafny.Sequence, length uint8) m_Wrappers.Result {
	{
		var _0_str m_Wrappers.Result = m_UTF8.Encode(val)
		_ = _0_str
		if (_0_str).Is_Failure() {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E((_0_str).Dtor_error().(_dafny.Sequence)))
		} else {
			return (_this).Hash((_0_str).Dtor_value().(_dafny.Sequence), key, length)
		}
	}
}
func (_this BeaconBase) GetHmac(data _dafny.Sequence, key _dafny.Sequence) m_Wrappers.Result {
	{
		var _0_input m_AwsCryptographyPrimitivesTypes.HMacInput = m_AwsCryptographyPrimitivesTypes.Companion_HMacInput_.Create_HMacInput_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_(), key, data)
		_ = _0_input
		var _1_valueOrError0 m_Wrappers.Result = (((_this).Dtor_client()).HMac(_0_input)).MapFailure(func(coer87 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
			return func(arg115 interface{}) interface{} {
				return coer87(arg115.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
		}))
		_ = _1_valueOrError0
		if (_1_valueOrError0).IsFailure() {
			return (_1_valueOrError0).PropagateFailure()
		} else {
			var _3_output _dafny.Sequence = (_1_valueOrError0).Extract().(_dafny.Sequence)
			_ = _3_output
			return m_Wrappers.Companion_Result_.Create_Success_((_3_output).Take(8))
		}
	}
}

// End of datatype BeaconBase

// Definition of class ValidStandardBeacon
type ValidStandardBeacon struct {
}

func New_ValidStandardBeacon_() *ValidStandardBeacon {
	_this := ValidStandardBeacon{}

	return &_this
}

type CompanionStruct_ValidStandardBeacon_ struct {
}

var Companion_ValidStandardBeacon_ = CompanionStruct_ValidStandardBeacon_{}

func (*ValidStandardBeacon) String() string {
	return "BaseBeacon.ValidStandardBeacon"
}

// End of class ValidStandardBeacon

func Type_ValidStandardBeacon_() _dafny.TypeDescriptor {
	return type_ValidStandardBeacon_{}
}

type type_ValidStandardBeacon_ struct {
}

func (_this type_ValidStandardBeacon_) Default() interface{} {
	return Companion_StandardBeacon_.Default()
}

func (_this type_ValidStandardBeacon_) String() string {
	return "BaseBeacon.ValidStandardBeacon"
}

// Definition of datatype StandardBeacon
type StandardBeacon struct {
	Data_StandardBeacon_
}

func (_this StandardBeacon) Get_() Data_StandardBeacon_ {
	return _this.Data_StandardBeacon_
}

type Data_StandardBeacon_ interface {
	isStandardBeacon()
}

type CompanionStruct_StandardBeacon_ struct {
}

var Companion_StandardBeacon_ = CompanionStruct_StandardBeacon_{}

type StandardBeacon_StandardBeacon struct {
	Base     BeaconBase
	Length   uint8
	Loc      _dafny.Sequence
	PartOnly bool
	AsSet    bool
	Share    m_Wrappers.Option
}

func (StandardBeacon_StandardBeacon) isStandardBeacon() {}

func (CompanionStruct_StandardBeacon_) Create_StandardBeacon_(Base BeaconBase, Length uint8, Loc _dafny.Sequence, PartOnly bool, AsSet bool, Share m_Wrappers.Option) StandardBeacon {
	return StandardBeacon{StandardBeacon_StandardBeacon{Base, Length, Loc, PartOnly, AsSet, Share}}
}

func (_this StandardBeacon) Is_StandardBeacon() bool {
	_, ok := _this.Get_().(StandardBeacon_StandardBeacon)
	return ok
}

func (CompanionStruct_StandardBeacon_) Default() StandardBeacon {
	return Companion_StandardBeacon_.Create_StandardBeacon_(Companion_BeaconBase_.Default(), Companion_BeaconLength_.Witness(), _dafny.EmptySeq, false, false, m_Wrappers.Companion_Option_.Default())
}

func (_this StandardBeacon) Dtor_base() BeaconBase {
	return _this.Get_().(StandardBeacon_StandardBeacon).Base
}

func (_this StandardBeacon) Dtor_length() uint8 {
	return _this.Get_().(StandardBeacon_StandardBeacon).Length
}

func (_this StandardBeacon) Dtor_loc() _dafny.Sequence {
	return _this.Get_().(StandardBeacon_StandardBeacon).Loc
}

func (_this StandardBeacon) Dtor_partOnly() bool {
	return _this.Get_().(StandardBeacon_StandardBeacon).PartOnly
}

func (_this StandardBeacon) Dtor_asSet() bool {
	return _this.Get_().(StandardBeacon_StandardBeacon).AsSet
}

func (_this StandardBeacon) Dtor_share() m_Wrappers.Option {
	return _this.Get_().(StandardBeacon_StandardBeacon).Share
}

func (_this StandardBeacon) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case StandardBeacon_StandardBeacon:
		{
			return "BaseBeacon.StandardBeacon.StandardBeacon" + "(" + _dafny.String(data.Base) + ", " + _dafny.String(data.Length) + ", " + _dafny.String(data.Loc) + ", " + _dafny.String(data.PartOnly) + ", " + _dafny.String(data.AsSet) + ", " + _dafny.String(data.Share) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this StandardBeacon) Equals(other StandardBeacon) bool {
	switch data1 := _this.Get_().(type) {
	case StandardBeacon_StandardBeacon:
		{
			data2, ok := other.Get_().(StandardBeacon_StandardBeacon)
			return ok && data1.Base.Equals(data2.Base) && data1.Length == data2.Length && data1.Loc.Equals(data2.Loc) && data1.PartOnly == data2.PartOnly && data1.AsSet == data2.AsSet && data1.Share.Equals(data2.Share)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this StandardBeacon) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(StandardBeacon)
	return ok && _this.Equals(typed)
}

func Type_StandardBeacon_() _dafny.TypeDescriptor {
	return type_StandardBeacon_{}
}

type type_StandardBeacon_ struct {
}

func (_this type_StandardBeacon_) Default() interface{} {
	return Companion_StandardBeacon_.Default()
}

func (_this type_StandardBeacon_) String() string {
	return "BaseBeacon.StandardBeacon"
}
func (_this StandardBeacon) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = StandardBeacon{}

func (_this StandardBeacon) Hash(val _dafny.Sequence, key _dafny.Sequence) m_Wrappers.Result {
	{
		return ((_this).Dtor_base()).Hash(val, key, (_this).Dtor_length())
	}
}
func (_this StandardBeacon) KeyName() _dafny.Sequence {
	{
		if ((_this).Dtor_share()).Is_Some() {
			return ((_this).Dtor_share()).Dtor_value().(_dafny.Sequence)
		} else {
			return ((_this).Dtor_base()).Dtor_name()
		}
	}
}
func (_this StandardBeacon) HashStr(val _dafny.Sequence, keys _dafny.Map) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((keys).Contains((_this).KeyName()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Internal Error, no key for "), (_this).KeyName())))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_str m_Wrappers.Result = m_UTF8.Encode(val)
			_ = _1_str
			if (_1_str).Is_Failure() {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E((_1_str).Dtor_error().(_dafny.Sequence)))
			} else {
				return (_this).Hash((_1_str).Dtor_value().(_dafny.Sequence), (keys).Get((_this).KeyName()).(_dafny.Sequence))
			}
		}
	}
}
func (_this StandardBeacon) ValueToSet(value m_ComAmazonawsDynamodbTypes.AttributeValue, key _dafny.Sequence) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Result = func() m_Wrappers.Result {
			var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = value
			_ = _source0
			{
				if _source0.Is_SS() {
					var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
					_ = _1_n
					return (_this).BeaconizeStringSet(_1_n, key, _dafny.SeqOf())
				}
			}
			{
				if _source0.Is_NS() {
					var _2_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
					_ = _2_n
					return (_this).BeaconizeNumberSet(_2_n, key, _dafny.SeqOf())
				}
			}
			{
				if _source0.Is_BS() {
					var _3_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
					_ = _3_n
					return (_this).BeaconizeBinarySet(_3_n, key, _dafny.SeqOf())
				}
			}
			{
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Beacon "), ((_this).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" has style AsSet, but attribute has type ")), m_DynamoDbEncryptionUtil.Companion_Default___.AttrTypeToStr(value)), _dafny.SeqOfString("."))))
			}
		}()
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _4_beaconSeq _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _4_beaconSeq
			return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_4_beaconSeq))
		}
	}
}
func (_this StandardBeacon) GetHash(item _dafny.Map, vf _dafny.Map, key _dafny.Sequence) m_Wrappers.Result {
	{
		if (_this).Dtor_asSet() {
			return (_this).GetHashSet(item, key)
		} else {
			return (_this).GetHashNonSet(item, vf, key)
		}
	}
}
func (_this StandardBeacon) GetHashSet(item _dafny.Map, key _dafny.Sequence) m_Wrappers.Result {
	{
		var _0_value m_Wrappers.Option = m_TermLoc.Companion_Default___.TermToAttr((_this).Dtor_loc(), item, m_Wrappers.Companion_Option_.Create_None_())
		_ = _0_value
		if (_0_value).Is_None() {
			return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
		} else {
			var _1_valueOrError0 m_Wrappers.Result = (_this).ValueToSet((_0_value).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue), key)
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _2_setValue m_ComAmazonawsDynamodbTypes.AttributeValue = (_1_valueOrError0).Extract().(m_ComAmazonawsDynamodbTypes.AttributeValue)
				_ = _2_setValue
				return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(_2_setValue))
			}
		}
	}
}
func (_this StandardBeacon) GetHashNonSet(item _dafny.Map, vf _dafny.Map, key _dafny.Sequence) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Result = m_DdbVirtualFields.Companion_Default___.VirtToBytes((_this).Dtor_loc(), item, vf)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_bytes m_Wrappers.Option = (_0_valueOrError0).Extract().(m_Wrappers.Option)
			_ = _1_bytes
			if (_1_bytes).Is_None() {
				return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
			} else {
				var _2_valueOrError1 m_Wrappers.Result = (_this).Hash((_1_bytes).Dtor_value().(_dafny.Sequence), key)
				_ = _2_valueOrError1
				if (_2_valueOrError1).IsFailure() {
					return (_2_valueOrError1).PropagateFailure()
				} else {
					var _3_res _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
					_ = _3_res
					return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_3_res)))
				}
			}
		}
	}
}
func (_this StandardBeacon) GetNaked(item _dafny.Map, vf _dafny.Map) m_Wrappers.Result {
	{
		return m_DdbVirtualFields.Companion_Default___.VirtToAttr((_this).Dtor_loc(), item, vf)
	}
}
func (_this StandardBeacon) GetFields(virtualFields _dafny.Map) _dafny.Sequence {
	{
		if (virtualFields).Contains((((_this).Dtor_loc()).Select(0).(m_TermLoc.Selector)).Dtor_key()) {
			return ((virtualFields).Get((((_this).Dtor_loc()).Select(0).(m_TermLoc.Selector)).Dtor_key()).(m_DdbVirtualFields.VirtField)).GetFields()
		} else {
			return _dafny.SeqOf((((_this).Dtor_loc()).Select(0).(m_TermLoc.Selector)).Dtor_key())
		}
	}
}
func (_this StandardBeacon) BeaconizeStringSet(value _dafny.Sequence, key _dafny.Sequence, converted _dafny.Sequence) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((value).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(converted)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (m_DynamoToStruct.Companion_Default___.TopLevelAttributeToBytes(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_((value).Select(0).(_dafny.Sequence)))).MapFailure(func(coer88 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
				return func(arg116 interface{}) interface{} {
					return coer88(arg116.(_dafny.Sequence))
				}
			}((func(_1___this0 StandardBeacon) func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
				return func(_2_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
					return m_DynamoDbEncryptionUtil.Companion_Default___.E(_2_e)
				}
			})(_this)))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _3_bytes _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
				_ = _3_bytes
				var _4_valueOrError1 m_Wrappers.Result = (_this).Hash(_3_bytes, key)
				_ = _4_valueOrError1
				if (_4_valueOrError1).IsFailure() {
					return (_4_valueOrError1).PropagateFailure()
				} else {
					var _5_h _dafny.Sequence = (_4_valueOrError1).Extract().(_dafny.Sequence)
					_ = _5_h
					if _dafny.Companion_Sequence_.Contains(converted, _5_h) {
						var _in0 StandardBeacon = _this
						_ = _in0
						var _in1 _dafny.Sequence = (value).Drop(1)
						_ = _in1
						var _in2 _dafny.Sequence = key
						_ = _in2
						var _in3 _dafny.Sequence = converted
						_ = _in3
						_this = _in0

						value = _in1
						key = _in2
						converted = _in3
						goto TAIL_CALL_START
					} else {
						var _in4 StandardBeacon = _this
						_ = _in4
						var _in5 _dafny.Sequence = (value).Drop(1)
						_ = _in5
						var _in6 _dafny.Sequence = key
						_ = _in6
						var _in7 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(converted, _dafny.SeqOf(_5_h))
						_ = _in7
						_this = _in4

						value = _in5
						key = _in6
						converted = _in7
						goto TAIL_CALL_START
					}
				}
			}
		}
	}
}
func (_this StandardBeacon) BeaconizeNumberSet(value _dafny.Sequence, key _dafny.Sequence, converted _dafny.Sequence) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((value).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(converted)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (m_DynamoToStruct.Companion_Default___.TopLevelAttributeToBytes(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_((value).Select(0).(_dafny.Sequence)))).MapFailure(func(coer89 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
				return func(arg117 interface{}) interface{} {
					return coer89(arg117.(_dafny.Sequence))
				}
			}((func(_1___this0 StandardBeacon) func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
				return func(_2_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
					return m_DynamoDbEncryptionUtil.Companion_Default___.E(_2_e)
				}
			})(_this)))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _3_bytes _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
				_ = _3_bytes
				var _4_valueOrError1 m_Wrappers.Result = (_this).Hash(_3_bytes, key)
				_ = _4_valueOrError1
				if (_4_valueOrError1).IsFailure() {
					return (_4_valueOrError1).PropagateFailure()
				} else {
					var _5_h _dafny.Sequence = (_4_valueOrError1).Extract().(_dafny.Sequence)
					_ = _5_h
					if _dafny.Companion_Sequence_.Contains(converted, _5_h) {
						var _in0 StandardBeacon = _this
						_ = _in0
						var _in1 _dafny.Sequence = (value).Drop(1)
						_ = _in1
						var _in2 _dafny.Sequence = key
						_ = _in2
						var _in3 _dafny.Sequence = converted
						_ = _in3
						_this = _in0

						value = _in1
						key = _in2
						converted = _in3
						goto TAIL_CALL_START
					} else {
						var _in4 StandardBeacon = _this
						_ = _in4
						var _in5 _dafny.Sequence = (value).Drop(1)
						_ = _in5
						var _in6 _dafny.Sequence = key
						_ = _in6
						var _in7 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(converted, _dafny.SeqOf(_5_h))
						_ = _in7
						_this = _in4

						value = _in5
						key = _in6
						converted = _in7
						goto TAIL_CALL_START
					}
				}
			}
		}
	}
}
func (_this StandardBeacon) BeaconizeBinarySet(value _dafny.Sequence, key _dafny.Sequence, converted _dafny.Sequence) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((value).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(converted)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (m_DynamoToStruct.Companion_Default___.TopLevelAttributeToBytes(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_((value).Select(0).(_dafny.Sequence)))).MapFailure(func(coer90 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
				return func(arg118 interface{}) interface{} {
					return coer90(arg118.(_dafny.Sequence))
				}
			}((func(_1___this0 StandardBeacon) func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
				return func(_2_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
					return m_DynamoDbEncryptionUtil.Companion_Default___.E(_2_e)
				}
			})(_this)))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _3_bytes _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
				_ = _3_bytes
				var _4_valueOrError1 m_Wrappers.Result = (_this).Hash(_3_bytes, key)
				_ = _4_valueOrError1
				if (_4_valueOrError1).IsFailure() {
					return (_4_valueOrError1).PropagateFailure()
				} else {
					var _5_h _dafny.Sequence = (_4_valueOrError1).Extract().(_dafny.Sequence)
					_ = _5_h
					if _dafny.Companion_Sequence_.Contains(converted, _5_h) {
						var _in0 StandardBeacon = _this
						_ = _in0
						var _in1 _dafny.Sequence = (value).Drop(1)
						_ = _in1
						var _in2 _dafny.Sequence = key
						_ = _in2
						var _in3 _dafny.Sequence = converted
						_ = _in3
						_this = _in0

						value = _in1
						key = _in2
						converted = _in3
						goto TAIL_CALL_START
					} else {
						var _in4 StandardBeacon = _this
						_ = _in4
						var _in5 _dafny.Sequence = (value).Drop(1)
						_ = _in5
						var _in6 _dafny.Sequence = key
						_ = _in6
						var _in7 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(converted, _dafny.SeqOf(_5_h))
						_ = _in7
						_this = _in4

						value = _in5
						key = _in6
						converted = _in7
						goto TAIL_CALL_START
					}
				}
			}
		}
	}
}
func (_this StandardBeacon) GetBeaconValue(value m_ComAmazonawsDynamodbTypes.AttributeValue, key _dafny.Sequence, forContains bool) m_Wrappers.Result {
	{
		if ((((_this).Dtor_asSet()) && (!((value).Is_S()))) && (!((value).Is_N()))) && (!((value).Is_B())) {
			return (_this).ValueToSet(value, key)
		} else if (forContains) && ((((value).Is_SS()) || ((value).Is_NS())) || ((value).Is_BS())) {
			return (_this).ValueToSet(value, key)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (m_DynamoToStruct.Companion_Default___.TopLevelAttributeToBytes(value)).MapFailure(func(coer91 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
				return func(arg119 interface{}) interface{} {
					return coer91(arg119.(_dafny.Sequence))
				}
			}(func(_1_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
				return m_DynamoDbEncryptionUtil.Companion_Default___.E(_1_e)
			}))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _2_bytes _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
				_ = _2_bytes
				var _3_valueOrError1 m_Wrappers.Result = (_this).Hash(_2_bytes, key)
				_ = _3_valueOrError1
				if (_3_valueOrError1).IsFailure() {
					return (_3_valueOrError1).PropagateFailure()
				} else {
					var _4_h _dafny.Sequence = (_3_valueOrError1).Extract().(_dafny.Sequence)
					_ = _4_h
					return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_4_h))
				}
			}
		}
	}
}
func (_this StandardBeacon) GetPart(val _dafny.Sequence, key _dafny.Sequence) m_Wrappers.Result {
	{
		return ((_this).Dtor_base()).Hash(val, key, (_this).Dtor_length())
	}
}

// End of datatype StandardBeacon
