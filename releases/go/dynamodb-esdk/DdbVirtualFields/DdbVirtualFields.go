// Package DdbVirtualFields
// Dafny module DdbVirtualFields compiled into Go

package DdbVirtualFields

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
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryption"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbItemEncryptorUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbNormalizeNumber"
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
	return "DdbVirtualFields.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ParseVirtualFieldConfig(vf m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_StandardLibrary_Sequence.Companion_Default___.MapWithResult(func(coer82 func(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
		return func(arg110 interface{}) m_Wrappers.Result {
			return coer82(arg110.(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart))
		}
	}(func(_1_p m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart) m_Wrappers.Result {
		return Companion_Default___.ParseVirtualPartConfig(_1_p)
	}), (vf).Dtor_parts(), uint64(0), _dafny.SeqOf())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _2_parts _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _2_parts
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_VirtField_.Create_VirtField_((vf).Dtor_name(), _2_parts))
	}
}
func (_static *CompanionStruct_Default___) ParseVirtualPartConfig(part m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_TermLoc.Companion_Default___.MakeTermLoc((part).Dtor_loc())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_loc _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_loc
		if ((part).Dtor_trans()).Is_None() {
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_VirtPart_.Create_VirtPart_(_1_loc, _dafny.SeqOf()))
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_VirtPart_.Create_VirtPart_(_1_loc, ((part).Dtor_trans()).Dtor_value().(_dafny.Sequence)))
		}
	}
}
func (_static *CompanionStruct_Default___) Examine(parts _dafny.Sequence, exam func(_dafny.Sequence) bool) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((parts).Cardinality())).Sign() == 0 {
		return false
	} else if (exam)(((parts).Select(0).(VirtPart)).Dtor_loc()) {
		return true
	} else {
		var _in0 _dafny.Sequence = (parts).Drop(1)
		_ = _in0
		var _in1 func(_dafny.Sequence) bool = exam
		_ = _in1
		parts = _in0
		exam = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) Min(x _dafny.Int, y _dafny.Int) _dafny.Int {
	if (y).Cmp(x) < 0 {
		return y
	} else {
		return x
	}
}
func (_static *CompanionStruct_Default___) GetPrefix(s _dafny.Sequence, length _dafny.Int) _dafny.Sequence {
	if (length).Sign() != -1 {
		return (s).Take((Companion_Default___.Min(length, _dafny.IntOfUint32((s).Cardinality()))).Uint32())
	} else {
		return (s).Take(((_dafny.IntOfUint32((s).Cardinality())).Minus(Companion_Default___.Min((_dafny.Zero).Minus(length), _dafny.IntOfUint32((s).Cardinality())))).Uint32())
	}
}
func (_static *CompanionStruct_Default___) GetSuffix(s _dafny.Sequence, length _dafny.Int) _dafny.Sequence {
	if (length).Sign() != -1 {
		return (s).Drop(((_dafny.IntOfUint32((s).Cardinality())).Minus(Companion_Default___.Min(length, _dafny.IntOfUint32((s).Cardinality())))).Uint32())
	} else {
		return (s).Drop((Companion_Default___.Min((_dafny.Zero).Minus(length), _dafny.IntOfUint32((s).Cardinality()))).Uint32())
	}
}
func (_static *CompanionStruct_Default___) GetPos(pos _dafny.Int, limit _dafny.Int) _dafny.Int {
	if (limit).Sign() == 0 {
		return _dafny.Zero
	} else if (pos).Sign() != -1 {
		return Companion_Default___.Min(pos, (limit).Minus(_dafny.One))
	} else if ((limit).Plus(pos)).Sign() == -1 {
		return _dafny.Zero
	} else {
		return (limit).Plus(pos)
	}
}
func (_static *CompanionStruct_Default___) GetSubstring(s _dafny.Sequence, low _dafny.Int, high _dafny.Int) _dafny.Sequence {
	var _0_lo _dafny.Int = Companion_Default___.GetPos(low, _dafny.IntOfUint32((s).Cardinality()))
	_ = _0_lo
	var _1_hi _dafny.Int = Companion_Default___.GetPos(high, _dafny.IntOfUint32((s).Cardinality()))
	_ = _1_hi
	if (_0_lo).Cmp(_1_hi) < 0 {
		return (s).Subsequence((_0_lo).Uint32(), (_1_hi).Uint32())
	} else {
		return _dafny.SeqOfString("")
	}
}
func (_static *CompanionStruct_Default___) UpperChar(ch _dafny.Char) _dafny.Char {
	if ((_dafny.Char('a')) <= (ch)) && ((ch) <= (_dafny.Char('z'))) {
		return ((ch) - (_dafny.Char('a'))) + (_dafny.Char('A'))
	} else {
		return ch
	}
}
func (_static *CompanionStruct_Default___) UpperCase(s _dafny.Sequence) _dafny.Sequence {
	return m_Seq.Companion_Default___.Map(func(coer83 func(_dafny.Char) _dafny.Char) func(interface{}) interface{} {
		return func(arg111 interface{}) interface{} {
			return coer83(arg111.(_dafny.Char))
		}
	}(func(_0_c _dafny.Char) _dafny.Char {
		return Companion_Default___.UpperChar(_0_c)
	}), s)
}
func (_static *CompanionStruct_Default___) LowerChar(ch _dafny.Char) _dafny.Char {
	if ((_dafny.Char('A')) <= (ch)) && ((ch) <= (_dafny.Char('Z'))) {
		return ((ch) - (_dafny.Char('A'))) + (_dafny.Char('a'))
	} else {
		return ch
	}
}
func (_static *CompanionStruct_Default___) LowerCase(s _dafny.Sequence) _dafny.Sequence {
	return m_Seq.Companion_Default___.Map(func(coer84 func(_dafny.Char) _dafny.Char) func(interface{}) interface{} {
		return func(arg112 interface{}) interface{} {
			return coer84(arg112.(_dafny.Char))
		}
	}(func(_0_c _dafny.Char) _dafny.Char {
		return Companion_Default___.LowerChar(_0_c)
	}), s)
}
func (_static *CompanionStruct_Default___) GetSegment(s _dafny.Sequence, split _dafny.Char, index _dafny.Int) _dafny.Sequence {
	var _0_parts _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(s, split)
	_ = _0_parts
	if ((index).Cmp(_dafny.IntOfUint32((_0_parts).Cardinality())) >= 0) || (((_dafny.Zero).Minus(index)).Cmp(_dafny.IntOfUint32((_0_parts).Cardinality())) > 0) {
		return _dafny.SeqOfString("")
	} else {
		return (_0_parts).Select((Companion_Default___.GetPos(index, _dafny.IntOfUint32((_0_parts).Cardinality()))).Uint32()).(_dafny.Sequence)
	}
}
func (_static *CompanionStruct_Default___) GetSegments(s _dafny.Sequence, split _dafny.Char, low _dafny.Int, high _dafny.Int) _dafny.Sequence {
	var _0_parts _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(s, split)
	_ = _0_parts
	var _1_lo _dafny.Int = Companion_Default___.GetPos(low, _dafny.IntOfUint32((_0_parts).Cardinality()))
	_ = _1_lo
	var _2_hi _dafny.Int = Companion_Default___.GetPos(high, _dafny.IntOfUint32((_0_parts).Cardinality()))
	_ = _2_hi
	if (_1_lo).Cmp(_2_hi) < 0 {
		return m_StandardLibrary.Companion_Default___.Join((_0_parts).Subsequence((_1_lo).Uint32(), (_2_hi).Uint32()), _dafny.SeqOfChars(split))
	} else {
		return _dafny.SeqOfString("")
	}
}
func (_static *CompanionStruct_Default___) DoTransform(t m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform, s _dafny.Sequence) _dafny.Sequence {
	var _source0 m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform = t
	_ = _source0
	{
		if _source0.Is_upper() {
			var _0_up m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Upper = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform_upper).Upper
			_ = _0_up
			return Companion_Default___.UpperCase(s)
		}
	}
	{
		if _source0.Is_lower() {
			var _1_lo m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Lower = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform_lower).Lower
			_ = _1_lo
			return Companion_Default___.LowerCase(s)
		}
	}
	{
		if _source0.Is_insert() {
			var _2_ins m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Insert = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform_insert).Insert
			_ = _2_ins
			return _dafny.Companion_Sequence_.Concatenate(s, (_2_ins).Dtor_literal())
		}
	}
	{
		if _source0.Is_prefix() {
			var _3_pre m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetPrefix = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform_prefix).Prefix
			_ = _3_pre
			return Companion_Default___.GetPrefix(s, _dafny.IntOfInt32((_3_pre).Dtor_length()))
		}
	}
	{
		if _source0.Is_suffix() {
			var _4_suf m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSuffix = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform_suffix).Suffix
			_ = _4_suf
			return Companion_Default___.GetSuffix(s, _dafny.IntOfInt32((_4_suf).Dtor_length()))
		}
	}
	{
		if _source0.Is_substring() {
			var _5_sub m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSubstring = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform_substring).Substring
			_ = _5_sub
			return Companion_Default___.GetSubstring(s, _dafny.IntOfInt32((_5_sub).Dtor_low()), _dafny.IntOfInt32((_5_sub).Dtor_high()))
		}
	}
	{
		if _source0.Is_segment() {
			var _6_seg m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSegment = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform_segment).Segment
			_ = _6_seg
			return Companion_Default___.GetSegment(s, ((_6_seg).Dtor_split()).Select(0).(_dafny.Char), _dafny.IntOfInt32((_6_seg).Dtor_index()))
		}
	}
	{
		var _7_seg m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetSegments = _source0.Get_().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform_segments).Segments
		_ = _7_seg
		return Companion_Default___.GetSegments(s, ((_7_seg).Dtor_split()).Select(0).(_dafny.Char), _dafny.IntOfInt32((_7_seg).Dtor_low()), _dafny.IntOfInt32((_7_seg).Dtor_high()))
	}
}
func (_static *CompanionStruct_Default___) FullTransform(t _dafny.Sequence, s _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((t).Cardinality())).Sign() == 0 {
		return s
	} else {
		var _in0 _dafny.Sequence = (t).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = Companion_Default___.DoTransform((t).Select(0).(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform), s)
		_ = _in1
		t = _in0
		s = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetVirtField(vf VirtField, item _dafny.Map) m_Wrappers.Result {
	return Companion_Default___.GetVirtField2((vf).Dtor_parts(), item, _dafny.SeqOfString(""))
}
func (_static *CompanionStruct_Default___) GetVirtField2(parts _dafny.Sequence, item _dafny.Map, acc _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((parts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(acc))
	} else {
		var _0_valueOrError0 m_Wrappers.Result = m_TermLoc.Companion_Default___.TermToString(((parts).Select(0).(VirtPart)).Dtor_loc(), item)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_value m_Wrappers.Option = (_0_valueOrError0).Extract().(m_Wrappers.Option)
			_ = _1_value
			if (_1_value).Is_None() {
				return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
			} else {
				var _2_trans _dafny.Sequence = Companion_Default___.FullTransform(((parts).Select(0).(VirtPart)).Dtor_trans(), (_1_value).Dtor_value().(_dafny.Sequence))
				_ = _2_trans
				var _in0 _dafny.Sequence = (parts).Drop(1)
				_ = _in0
				var _in1 _dafny.Map = item
				_ = _in1
				var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _2_trans)
				_ = _in2
				parts = _in0
				item = _in1
				acc = _in2
				goto TAIL_CALL_START
			}
		}
	}
}
func (_static *CompanionStruct_Default___) VirtToAttr(loc _dafny.Sequence, item _dafny.Map, vf _dafny.Map) m_Wrappers.Result {
	if ((_dafny.IntOfUint32((loc).Cardinality())).Cmp(_dafny.One) == 0) && ((vf).Contains(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key())) {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetVirtField((vf).Get(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key()).(VirtField), item)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_str m_Wrappers.Option = (_0_valueOrError0).Extract().(m_Wrappers.Option)
			_ = _1_str
			if (_1_str).Is_None() {
				return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.DS((_1_str).Dtor_value().(_dafny.Sequence))))
			}
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(m_TermLoc.Companion_Default___.TermToAttr(loc, item, m_Wrappers.Companion_Option_.Create_None_()))
	}
}
func (_static *CompanionStruct_Default___) VirtToBytes(loc _dafny.Sequence, item _dafny.Map, vf _dafny.Map) m_Wrappers.Result {
	if ((_dafny.IntOfUint32((loc).Cardinality())).Cmp(_dafny.One) == 0) && ((vf).Contains(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key())) {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetVirtField((vf).Get(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key()).(VirtField), item)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_str m_Wrappers.Option = (_0_valueOrError0).Extract().(m_Wrappers.Option)
			_ = _1_str
			if (_1_str).Is_None() {
				return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
			} else {
				var _2_valueOrError1 m_Wrappers.Result = (m_UTF8.Encode((_1_str).Dtor_value().(_dafny.Sequence))).MapFailure(func(coer85 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) func(interface{}) interface{} {
					return func(arg113 interface{}) interface{} {
						return coer85(arg113.(_dafny.Sequence))
					}
				}(func(_3_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
					return m_DynamoDbEncryptionUtil.Companion_Default___.E(_3_e)
				}))
				_ = _2_valueOrError1
				if (_2_valueOrError1).IsFailure() {
					return (_2_valueOrError1).PropagateFailure()
				} else {
					var _4_ustr _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
					_ = _4_ustr
					return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(_4_ustr))
				}
			}
		}
	} else {
		return m_TermLoc.Companion_Default___.TermToBytes(loc, item)
	}
}
func (_static *CompanionStruct_Default___) VirtToString(loc _dafny.Sequence, item _dafny.Map, vf _dafny.Map) m_Wrappers.Result {
	if ((_dafny.IntOfUint32((loc).Cardinality())).Cmp(_dafny.One) == 0) && ((vf).Contains(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key())) {
		return Companion_Default___.GetVirtField((vf).Get(((loc).Select(0).(m_TermLoc.Selector)).Dtor_key()).(VirtField), item)
	} else {
		return m_TermLoc.Companion_Default___.TermToString(loc, item)
	}
}
func (_static *CompanionStruct_Default___) DS(s _dafny.Sequence) m_ComAmazonawsDynamodbTypes.AttributeValue {
	return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(s)
}

// End of class Default__

// Definition of class VirtualFieldMap
type VirtualFieldMap struct {
}

func New_VirtualFieldMap_() *VirtualFieldMap {
	_this := VirtualFieldMap{}

	return &_this
}

type CompanionStruct_VirtualFieldMap_ struct {
}

var Companion_VirtualFieldMap_ = CompanionStruct_VirtualFieldMap_{}

func (*VirtualFieldMap) String() string {
	return "DdbVirtualFields.VirtualFieldMap"
}

// End of class VirtualFieldMap

func Type_VirtualFieldMap_() _dafny.TypeDescriptor {
	return type_VirtualFieldMap_{}
}

type type_VirtualFieldMap_ struct {
}

func (_this type_VirtualFieldMap_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_VirtualFieldMap_) String() string {
	return "DdbVirtualFields.VirtualFieldMap"
}

// Definition of class ValidVirtualField
type ValidVirtualField struct {
}

func New_ValidVirtualField_() *ValidVirtualField {
	_this := ValidVirtualField{}

	return &_this
}

type CompanionStruct_ValidVirtualField_ struct {
}

var Companion_ValidVirtualField_ = CompanionStruct_ValidVirtualField_{}

func (*ValidVirtualField) String() string {
	return "DdbVirtualFields.ValidVirtualField"
}

// End of class ValidVirtualField

func Type_ValidVirtualField_() _dafny.TypeDescriptor {
	return type_ValidVirtualField_{}
}

type type_ValidVirtualField_ struct {
}

func (_this type_ValidVirtualField_) Default() interface{} {
	return Companion_VirtField_.Default()
}

func (_this type_ValidVirtualField_) String() string {
	return "DdbVirtualFields.ValidVirtualField"
}

// Definition of datatype VirtField
type VirtField struct {
	Data_VirtField_
}

func (_this VirtField) Get_() Data_VirtField_ {
	return _this.Data_VirtField_
}

type Data_VirtField_ interface {
	isVirtField()
}

type CompanionStruct_VirtField_ struct {
}

var Companion_VirtField_ = CompanionStruct_VirtField_{}

type VirtField_VirtField struct {
	Name  _dafny.Sequence
	Parts _dafny.Sequence
}

func (VirtField_VirtField) isVirtField() {}

func (CompanionStruct_VirtField_) Create_VirtField_(Name _dafny.Sequence, Parts _dafny.Sequence) VirtField {
	return VirtField{VirtField_VirtField{Name, Parts}}
}

func (_this VirtField) Is_VirtField() bool {
	_, ok := _this.Get_().(VirtField_VirtField)
	return ok
}

func (CompanionStruct_VirtField_) Default() VirtField {
	return Companion_VirtField_.Create_VirtField_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq)
}

func (_this VirtField) Dtor_name() _dafny.Sequence {
	return _this.Get_().(VirtField_VirtField).Name
}

func (_this VirtField) Dtor_parts() _dafny.Sequence {
	return _this.Get_().(VirtField_VirtField).Parts
}

func (_this VirtField) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VirtField_VirtField:
		{
			return "DdbVirtualFields.VirtField.VirtField" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Parts) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VirtField) Equals(other VirtField) bool {
	switch data1 := _this.Get_().(type) {
	case VirtField_VirtField:
		{
			data2, ok := other.Get_().(VirtField_VirtField)
			return ok && data1.Name.Equals(data2.Name) && data1.Parts.Equals(data2.Parts)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VirtField) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VirtField)
	return ok && _this.Equals(typed)
}

func Type_VirtField_() _dafny.TypeDescriptor {
	return type_VirtField_{}
}

type type_VirtField_ struct {
}

func (_this type_VirtField_) Default() interface{} {
	return Companion_VirtField_.Default()
}

func (_this type_VirtField_) String() string {
	return "DdbVirtualFields.VirtField"
}
func (_this VirtField) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VirtField{}

func (_this VirtField) Examine(exam func(_dafny.Sequence) bool) bool {
	{
		return Companion_Default___.Examine((_this).Dtor_parts(), exam)
	}
}
func (_this VirtField) GetFields() _dafny.Sequence {
	{
		return m_Seq.Companion_Default___.Map(func(coer86 func(VirtPart) _dafny.Sequence) func(interface{}) interface{} {
			return func(arg114 interface{}) interface{} {
				return coer86(arg114.(VirtPart))
			}
		}(func(_0_p VirtPart) _dafny.Sequence {
			return (((_0_p).Dtor_loc()).Select(0).(m_TermLoc.Selector)).Dtor_key()
		}), (_this).Dtor_parts())
	}
}
func (_this VirtField) GetLocs() _dafny.Set {
	{
		return func() _dafny.Set {
			var _coll0 = _dafny.NewBuilder()
			_ = _coll0
			for _iter19 := _dafny.Iterate(((_this).Dtor_parts()).Elements()); ; {
				_compr_0, _ok19 := _iter19()
				if !_ok19 {
					break
				}
				var _0_p VirtPart
				_0_p = interface{}(_compr_0).(VirtPart)
				if _dafny.Companion_Sequence_.Contains((_this).Dtor_parts(), _0_p) {
					_coll0.Add((_0_p).Dtor_loc())
				}
			}
			return _coll0.ToSet()
		}()
	}
}
func (_this VirtField) HasSingleLoc(loc _dafny.Sequence) bool {
	{
		return ((_dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())).Cmp(_dafny.One) == 0) && (_dafny.Companion_Sequence_.Equal((((_this).Dtor_parts()).Select(0).(VirtPart)).Dtor_loc(), loc))
	}
}

// End of datatype VirtField

// Definition of datatype VirtPart
type VirtPart struct {
	Data_VirtPart_
}

func (_this VirtPart) Get_() Data_VirtPart_ {
	return _this.Data_VirtPart_
}

type Data_VirtPart_ interface {
	isVirtPart()
}

type CompanionStruct_VirtPart_ struct {
}

var Companion_VirtPart_ = CompanionStruct_VirtPart_{}

type VirtPart_VirtPart struct {
	Loc   _dafny.Sequence
	Trans _dafny.Sequence
}

func (VirtPart_VirtPart) isVirtPart() {}

func (CompanionStruct_VirtPart_) Create_VirtPart_(Loc _dafny.Sequence, Trans _dafny.Sequence) VirtPart {
	return VirtPart{VirtPart_VirtPart{Loc, Trans}}
}

func (_this VirtPart) Is_VirtPart() bool {
	_, ok := _this.Get_().(VirtPart_VirtPart)
	return ok
}

func (CompanionStruct_VirtPart_) Default() VirtPart {
	return Companion_VirtPart_.Create_VirtPart_(_dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this VirtPart) Dtor_loc() _dafny.Sequence {
	return _this.Get_().(VirtPart_VirtPart).Loc
}

func (_this VirtPart) Dtor_trans() _dafny.Sequence {
	return _this.Get_().(VirtPart_VirtPart).Trans
}

func (_this VirtPart) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VirtPart_VirtPart:
		{
			return "DdbVirtualFields.VirtPart.VirtPart" + "(" + _dafny.String(data.Loc) + ", " + _dafny.String(data.Trans) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VirtPart) Equals(other VirtPart) bool {
	switch data1 := _this.Get_().(type) {
	case VirtPart_VirtPart:
		{
			data2, ok := other.Get_().(VirtPart_VirtPart)
			return ok && data1.Loc.Equals(data2.Loc) && data1.Trans.Equals(data2.Trans)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VirtPart) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VirtPart)
	return ok && _this.Equals(typed)
}

func Type_VirtPart_() _dafny.TypeDescriptor {
	return type_VirtPart_{}
}

type type_VirtPart_ struct {
}

func (_this type_VirtPart_) Default() interface{} {
	return Companion_VirtPart_.Default()
}

func (_this type_VirtPart_) String() string {
	return "DdbVirtualFields.VirtPart"
}
func (_this VirtPart) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VirtPart{}

// End of datatype VirtPart
