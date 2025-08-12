// Package AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
// Dafny module AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes compiled into Go

package AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes

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
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/BaseBeacon"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Canonize"
	m_CompoundBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/CompoundBeacon"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DdbVirtualFields"
	m_DynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDBFilterExpr"
	m_DynamoDBSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDBSupport"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsDummySubsetType(x _dafny.Int) bool {
	return (x).Sign() == 1
}

// End of class Default__

// Definition of datatype DafnyCallEvent
type DafnyCallEvent struct {
	Data_DafnyCallEvent_
}

func (_this DafnyCallEvent) Get_() Data_DafnyCallEvent_ {
	return _this.Data_DafnyCallEvent_
}

type Data_DafnyCallEvent_ interface {
	isDafnyCallEvent()
}

type CompanionStruct_DafnyCallEvent_ struct {
}

var Companion_DafnyCallEvent_ = CompanionStruct_DafnyCallEvent_{}

type DafnyCallEvent_DafnyCallEvent struct {
	Input  interface{}
	Output interface{}
}

func (DafnyCallEvent_DafnyCallEvent) isDafnyCallEvent() {}

func (CompanionStruct_DafnyCallEvent_) Create_DafnyCallEvent_(Input interface{}, Output interface{}) DafnyCallEvent {
	return DafnyCallEvent{DafnyCallEvent_DafnyCallEvent{Input, Output}}
}

func (_this DafnyCallEvent) Is_DafnyCallEvent() bool {
	_, ok := _this.Get_().(DafnyCallEvent_DafnyCallEvent)
	return ok
}

func (CompanionStruct_DafnyCallEvent_) Default(_default_I interface{}, _default_O interface{}) DafnyCallEvent {
	return Companion_DafnyCallEvent_.Create_DafnyCallEvent_(_default_I, _default_O)
}

func (_this DafnyCallEvent) Dtor_input() interface{} {
	return _this.Get_().(DafnyCallEvent_DafnyCallEvent).Input
}

func (_this DafnyCallEvent) Dtor_output() interface{} {
	return _this.Get_().(DafnyCallEvent_DafnyCallEvent).Output
}

func (_this DafnyCallEvent) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DafnyCallEvent_DafnyCallEvent:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DafnyCallEvent.DafnyCallEvent" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DafnyCallEvent) Equals(other DafnyCallEvent) bool {
	switch data1 := _this.Get_().(type) {
	case DafnyCallEvent_DafnyCallEvent:
		{
			data2, ok := other.Get_().(DafnyCallEvent_DafnyCallEvent)
			return ok && _dafny.AreEqual(data1.Input, data2.Input) && _dafny.AreEqual(data1.Output, data2.Output)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DafnyCallEvent) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DafnyCallEvent)
	return ok && _this.Equals(typed)
}

func Type_DafnyCallEvent_(Type_I_ _dafny.TypeDescriptor, Type_O_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_DafnyCallEvent_{Type_I_, Type_O_}
}

type type_DafnyCallEvent_ struct {
	Type_I_ _dafny.TypeDescriptor
	Type_O_ _dafny.TypeDescriptor
}

func (_this type_DafnyCallEvent_) Default() interface{} {
	Type_I_ := _this.Type_I_
	_ = Type_I_
	Type_O_ := _this.Type_O_
	_ = Type_O_
	return Companion_DafnyCallEvent_.Default(Type_I_.Default(), Type_O_.Default())
}

func (_this type_DafnyCallEvent_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DafnyCallEvent"
}
func (_this DafnyCallEvent) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DafnyCallEvent{}

// End of datatype DafnyCallEvent

// Definition of datatype BatchExecuteStatementInputTransformInput
type BatchExecuteStatementInputTransformInput struct {
	Data_BatchExecuteStatementInputTransformInput_
}

func (_this BatchExecuteStatementInputTransformInput) Get_() Data_BatchExecuteStatementInputTransformInput_ {
	return _this.Data_BatchExecuteStatementInputTransformInput_
}

type Data_BatchExecuteStatementInputTransformInput_ interface {
	isBatchExecuteStatementInputTransformInput()
}

type CompanionStruct_BatchExecuteStatementInputTransformInput_ struct {
}

var Companion_BatchExecuteStatementInputTransformInput_ = CompanionStruct_BatchExecuteStatementInputTransformInput_{}

type BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput
}

func (BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput) isBatchExecuteStatementInputTransformInput() {
}

func (CompanionStruct_BatchExecuteStatementInputTransformInput_) Create_BatchExecuteStatementInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput) BatchExecuteStatementInputTransformInput {
	return BatchExecuteStatementInputTransformInput{BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput{SdkInput}}
}

func (_this BatchExecuteStatementInputTransformInput) Is_BatchExecuteStatementInputTransformInput() bool {
	_, ok := _this.Get_().(BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput)
	return ok
}

func (CompanionStruct_BatchExecuteStatementInputTransformInput_) Default() BatchExecuteStatementInputTransformInput {
	return Companion_BatchExecuteStatementInputTransformInput_.Create_BatchExecuteStatementInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_BatchExecuteStatementInput_.Default())
}

func (_this BatchExecuteStatementInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput {
	return _this.Get_().(BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput).SdkInput
}

func (_this BatchExecuteStatementInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementInputTransformInput.BatchExecuteStatementInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchExecuteStatementInputTransformInput) Equals(other BatchExecuteStatementInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput:
		{
			data2, ok := other.Get_().(BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchExecuteStatementInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchExecuteStatementInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_BatchExecuteStatementInputTransformInput_() _dafny.TypeDescriptor {
	return type_BatchExecuteStatementInputTransformInput_{}
}

type type_BatchExecuteStatementInputTransformInput_ struct {
}

func (_this type_BatchExecuteStatementInputTransformInput_) Default() interface{} {
	return Companion_BatchExecuteStatementInputTransformInput_.Default()
}

func (_this type_BatchExecuteStatementInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementInputTransformInput"
}
func (_this BatchExecuteStatementInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchExecuteStatementInputTransformInput{}

// End of datatype BatchExecuteStatementInputTransformInput

// Definition of datatype BatchExecuteStatementInputTransformOutput
type BatchExecuteStatementInputTransformOutput struct {
	Data_BatchExecuteStatementInputTransformOutput_
}

func (_this BatchExecuteStatementInputTransformOutput) Get_() Data_BatchExecuteStatementInputTransformOutput_ {
	return _this.Data_BatchExecuteStatementInputTransformOutput_
}

type Data_BatchExecuteStatementInputTransformOutput_ interface {
	isBatchExecuteStatementInputTransformOutput()
}

type CompanionStruct_BatchExecuteStatementInputTransformOutput_ struct {
}

var Companion_BatchExecuteStatementInputTransformOutput_ = CompanionStruct_BatchExecuteStatementInputTransformOutput_{}

type BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput
}

func (BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput) isBatchExecuteStatementInputTransformOutput() {
}

func (CompanionStruct_BatchExecuteStatementInputTransformOutput_) Create_BatchExecuteStatementInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput) BatchExecuteStatementInputTransformOutput {
	return BatchExecuteStatementInputTransformOutput{BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput{TransformedInput}}
}

func (_this BatchExecuteStatementInputTransformOutput) Is_BatchExecuteStatementInputTransformOutput() bool {
	_, ok := _this.Get_().(BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput)
	return ok
}

func (CompanionStruct_BatchExecuteStatementInputTransformOutput_) Default() BatchExecuteStatementInputTransformOutput {
	return Companion_BatchExecuteStatementInputTransformOutput_.Create_BatchExecuteStatementInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_BatchExecuteStatementInput_.Default())
}

func (_this BatchExecuteStatementInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput {
	return _this.Get_().(BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput).TransformedInput
}

func (_this BatchExecuteStatementInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementInputTransformOutput.BatchExecuteStatementInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchExecuteStatementInputTransformOutput) Equals(other BatchExecuteStatementInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput:
		{
			data2, ok := other.Get_().(BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchExecuteStatementInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchExecuteStatementInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_BatchExecuteStatementInputTransformOutput_() _dafny.TypeDescriptor {
	return type_BatchExecuteStatementInputTransformOutput_{}
}

type type_BatchExecuteStatementInputTransformOutput_ struct {
}

func (_this type_BatchExecuteStatementInputTransformOutput_) Default() interface{} {
	return Companion_BatchExecuteStatementInputTransformOutput_.Default()
}

func (_this type_BatchExecuteStatementInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementInputTransformOutput"
}
func (_this BatchExecuteStatementInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchExecuteStatementInputTransformOutput{}

// End of datatype BatchExecuteStatementInputTransformOutput

// Definition of datatype BatchExecuteStatementOutputTransformInput
type BatchExecuteStatementOutputTransformInput struct {
	Data_BatchExecuteStatementOutputTransformInput_
}

func (_this BatchExecuteStatementOutputTransformInput) Get_() Data_BatchExecuteStatementOutputTransformInput_ {
	return _this.Data_BatchExecuteStatementOutputTransformInput_
}

type Data_BatchExecuteStatementOutputTransformInput_ interface {
	isBatchExecuteStatementOutputTransformInput()
}

type CompanionStruct_BatchExecuteStatementOutputTransformInput_ struct {
}

var Companion_BatchExecuteStatementOutputTransformInput_ = CompanionStruct_BatchExecuteStatementOutputTransformInput_{}

type BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.BatchExecuteStatementOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput
}

func (BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput) isBatchExecuteStatementOutputTransformInput() {
}

func (CompanionStruct_BatchExecuteStatementOutputTransformInput_) Create_BatchExecuteStatementOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementOutput, OriginalInput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput) BatchExecuteStatementOutputTransformInput {
	return BatchExecuteStatementOutputTransformInput{BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this BatchExecuteStatementOutputTransformInput) Is_BatchExecuteStatementOutputTransformInput() bool {
	_, ok := _this.Get_().(BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput)
	return ok
}

func (CompanionStruct_BatchExecuteStatementOutputTransformInput_) Default() BatchExecuteStatementOutputTransformInput {
	return Companion_BatchExecuteStatementOutputTransformInput_.Create_BatchExecuteStatementOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_BatchExecuteStatementOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_BatchExecuteStatementInput_.Default())
}

func (_this BatchExecuteStatementOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.BatchExecuteStatementOutput {
	return _this.Get_().(BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput).SdkOutput
}

func (_this BatchExecuteStatementOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.BatchExecuteStatementInput {
	return _this.Get_().(BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput).OriginalInput
}

func (_this BatchExecuteStatementOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementOutputTransformInput.BatchExecuteStatementOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchExecuteStatementOutputTransformInput) Equals(other BatchExecuteStatementOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput:
		{
			data2, ok := other.Get_().(BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchExecuteStatementOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchExecuteStatementOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_BatchExecuteStatementOutputTransformInput_() _dafny.TypeDescriptor {
	return type_BatchExecuteStatementOutputTransformInput_{}
}

type type_BatchExecuteStatementOutputTransformInput_ struct {
}

func (_this type_BatchExecuteStatementOutputTransformInput_) Default() interface{} {
	return Companion_BatchExecuteStatementOutputTransformInput_.Default()
}

func (_this type_BatchExecuteStatementOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementOutputTransformInput"
}
func (_this BatchExecuteStatementOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchExecuteStatementOutputTransformInput{}

// End of datatype BatchExecuteStatementOutputTransformInput

// Definition of datatype BatchExecuteStatementOutputTransformOutput
type BatchExecuteStatementOutputTransformOutput struct {
	Data_BatchExecuteStatementOutputTransformOutput_
}

func (_this BatchExecuteStatementOutputTransformOutput) Get_() Data_BatchExecuteStatementOutputTransformOutput_ {
	return _this.Data_BatchExecuteStatementOutputTransformOutput_
}

type Data_BatchExecuteStatementOutputTransformOutput_ interface {
	isBatchExecuteStatementOutputTransformOutput()
}

type CompanionStruct_BatchExecuteStatementOutputTransformOutput_ struct {
}

var Companion_BatchExecuteStatementOutputTransformOutput_ = CompanionStruct_BatchExecuteStatementOutputTransformOutput_{}

type BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementOutput
}

func (BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput) isBatchExecuteStatementOutputTransformOutput() {
}

func (CompanionStruct_BatchExecuteStatementOutputTransformOutput_) Create_BatchExecuteStatementOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.BatchExecuteStatementOutput) BatchExecuteStatementOutputTransformOutput {
	return BatchExecuteStatementOutputTransformOutput{BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput{TransformedOutput}}
}

func (_this BatchExecuteStatementOutputTransformOutput) Is_BatchExecuteStatementOutputTransformOutput() bool {
	_, ok := _this.Get_().(BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput)
	return ok
}

func (CompanionStruct_BatchExecuteStatementOutputTransformOutput_) Default() BatchExecuteStatementOutputTransformOutput {
	return Companion_BatchExecuteStatementOutputTransformOutput_.Create_BatchExecuteStatementOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_BatchExecuteStatementOutput_.Default())
}

func (_this BatchExecuteStatementOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.BatchExecuteStatementOutput {
	return _this.Get_().(BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput).TransformedOutput
}

func (_this BatchExecuteStatementOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementOutputTransformOutput.BatchExecuteStatementOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchExecuteStatementOutputTransformOutput) Equals(other BatchExecuteStatementOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput:
		{
			data2, ok := other.Get_().(BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchExecuteStatementOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchExecuteStatementOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_BatchExecuteStatementOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_BatchExecuteStatementOutputTransformOutput_{}
}

type type_BatchExecuteStatementOutputTransformOutput_ struct {
}

func (_this type_BatchExecuteStatementOutputTransformOutput_) Default() interface{} {
	return Companion_BatchExecuteStatementOutputTransformOutput_.Default()
}

func (_this type_BatchExecuteStatementOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementOutputTransformOutput"
}
func (_this BatchExecuteStatementOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchExecuteStatementOutputTransformOutput{}

// End of datatype BatchExecuteStatementOutputTransformOutput

// Definition of datatype BatchGetItemInputTransformInput
type BatchGetItemInputTransformInput struct {
	Data_BatchGetItemInputTransformInput_
}

func (_this BatchGetItemInputTransformInput) Get_() Data_BatchGetItemInputTransformInput_ {
	return _this.Data_BatchGetItemInputTransformInput_
}

type Data_BatchGetItemInputTransformInput_ interface {
	isBatchGetItemInputTransformInput()
}

type CompanionStruct_BatchGetItemInputTransformInput_ struct {
}

var Companion_BatchGetItemInputTransformInput_ = CompanionStruct_BatchGetItemInputTransformInput_{}

type BatchGetItemInputTransformInput_BatchGetItemInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.BatchGetItemInput
}

func (BatchGetItemInputTransformInput_BatchGetItemInputTransformInput) isBatchGetItemInputTransformInput() {
}

func (CompanionStruct_BatchGetItemInputTransformInput_) Create_BatchGetItemInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.BatchGetItemInput) BatchGetItemInputTransformInput {
	return BatchGetItemInputTransformInput{BatchGetItemInputTransformInput_BatchGetItemInputTransformInput{SdkInput}}
}

func (_this BatchGetItemInputTransformInput) Is_BatchGetItemInputTransformInput() bool {
	_, ok := _this.Get_().(BatchGetItemInputTransformInput_BatchGetItemInputTransformInput)
	return ok
}

func (CompanionStruct_BatchGetItemInputTransformInput_) Default() BatchGetItemInputTransformInput {
	return Companion_BatchGetItemInputTransformInput_.Create_BatchGetItemInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_BatchGetItemInput_.Default())
}

func (_this BatchGetItemInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.BatchGetItemInput {
	return _this.Get_().(BatchGetItemInputTransformInput_BatchGetItemInputTransformInput).SdkInput
}

func (_this BatchGetItemInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchGetItemInputTransformInput_BatchGetItemInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemInputTransformInput.BatchGetItemInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchGetItemInputTransformInput) Equals(other BatchGetItemInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchGetItemInputTransformInput_BatchGetItemInputTransformInput:
		{
			data2, ok := other.Get_().(BatchGetItemInputTransformInput_BatchGetItemInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchGetItemInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchGetItemInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_BatchGetItemInputTransformInput_() _dafny.TypeDescriptor {
	return type_BatchGetItemInputTransformInput_{}
}

type type_BatchGetItemInputTransformInput_ struct {
}

func (_this type_BatchGetItemInputTransformInput_) Default() interface{} {
	return Companion_BatchGetItemInputTransformInput_.Default()
}

func (_this type_BatchGetItemInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemInputTransformInput"
}
func (_this BatchGetItemInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchGetItemInputTransformInput{}

// End of datatype BatchGetItemInputTransformInput

// Definition of datatype BatchGetItemInputTransformOutput
type BatchGetItemInputTransformOutput struct {
	Data_BatchGetItemInputTransformOutput_
}

func (_this BatchGetItemInputTransformOutput) Get_() Data_BatchGetItemInputTransformOutput_ {
	return _this.Data_BatchGetItemInputTransformOutput_
}

type Data_BatchGetItemInputTransformOutput_ interface {
	isBatchGetItemInputTransformOutput()
}

type CompanionStruct_BatchGetItemInputTransformOutput_ struct {
}

var Companion_BatchGetItemInputTransformOutput_ = CompanionStruct_BatchGetItemInputTransformOutput_{}

type BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.BatchGetItemInput
}

func (BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput) isBatchGetItemInputTransformOutput() {
}

func (CompanionStruct_BatchGetItemInputTransformOutput_) Create_BatchGetItemInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.BatchGetItemInput) BatchGetItemInputTransformOutput {
	return BatchGetItemInputTransformOutput{BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput{TransformedInput}}
}

func (_this BatchGetItemInputTransformOutput) Is_BatchGetItemInputTransformOutput() bool {
	_, ok := _this.Get_().(BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput)
	return ok
}

func (CompanionStruct_BatchGetItemInputTransformOutput_) Default() BatchGetItemInputTransformOutput {
	return Companion_BatchGetItemInputTransformOutput_.Create_BatchGetItemInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_BatchGetItemInput_.Default())
}

func (_this BatchGetItemInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.BatchGetItemInput {
	return _this.Get_().(BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput).TransformedInput
}

func (_this BatchGetItemInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemInputTransformOutput.BatchGetItemInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchGetItemInputTransformOutput) Equals(other BatchGetItemInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput:
		{
			data2, ok := other.Get_().(BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchGetItemInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchGetItemInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_BatchGetItemInputTransformOutput_() _dafny.TypeDescriptor {
	return type_BatchGetItemInputTransformOutput_{}
}

type type_BatchGetItemInputTransformOutput_ struct {
}

func (_this type_BatchGetItemInputTransformOutput_) Default() interface{} {
	return Companion_BatchGetItemInputTransformOutput_.Default()
}

func (_this type_BatchGetItemInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemInputTransformOutput"
}
func (_this BatchGetItemInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchGetItemInputTransformOutput{}

// End of datatype BatchGetItemInputTransformOutput

// Definition of datatype BatchGetItemOutputTransformInput
type BatchGetItemOutputTransformInput struct {
	Data_BatchGetItemOutputTransformInput_
}

func (_this BatchGetItemOutputTransformInput) Get_() Data_BatchGetItemOutputTransformInput_ {
	return _this.Data_BatchGetItemOutputTransformInput_
}

type Data_BatchGetItemOutputTransformInput_ interface {
	isBatchGetItemOutputTransformInput()
}

type CompanionStruct_BatchGetItemOutputTransformInput_ struct {
}

var Companion_BatchGetItemOutputTransformInput_ = CompanionStruct_BatchGetItemOutputTransformInput_{}

type BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.BatchGetItemOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.BatchGetItemInput
}

func (BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput) isBatchGetItemOutputTransformInput() {
}

func (CompanionStruct_BatchGetItemOutputTransformInput_) Create_BatchGetItemOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.BatchGetItemOutput, OriginalInput m_ComAmazonawsDynamodbTypes.BatchGetItemInput) BatchGetItemOutputTransformInput {
	return BatchGetItemOutputTransformInput{BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this BatchGetItemOutputTransformInput) Is_BatchGetItemOutputTransformInput() bool {
	_, ok := _this.Get_().(BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput)
	return ok
}

func (CompanionStruct_BatchGetItemOutputTransformInput_) Default() BatchGetItemOutputTransformInput {
	return Companion_BatchGetItemOutputTransformInput_.Create_BatchGetItemOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_BatchGetItemOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_BatchGetItemInput_.Default())
}

func (_this BatchGetItemOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.BatchGetItemOutput {
	return _this.Get_().(BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput).SdkOutput
}

func (_this BatchGetItemOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.BatchGetItemInput {
	return _this.Get_().(BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput).OriginalInput
}

func (_this BatchGetItemOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemOutputTransformInput.BatchGetItemOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchGetItemOutputTransformInput) Equals(other BatchGetItemOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput:
		{
			data2, ok := other.Get_().(BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchGetItemOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchGetItemOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_BatchGetItemOutputTransformInput_() _dafny.TypeDescriptor {
	return type_BatchGetItemOutputTransformInput_{}
}

type type_BatchGetItemOutputTransformInput_ struct {
}

func (_this type_BatchGetItemOutputTransformInput_) Default() interface{} {
	return Companion_BatchGetItemOutputTransformInput_.Default()
}

func (_this type_BatchGetItemOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemOutputTransformInput"
}
func (_this BatchGetItemOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchGetItemOutputTransformInput{}

// End of datatype BatchGetItemOutputTransformInput

// Definition of datatype BatchGetItemOutputTransformOutput
type BatchGetItemOutputTransformOutput struct {
	Data_BatchGetItemOutputTransformOutput_
}

func (_this BatchGetItemOutputTransformOutput) Get_() Data_BatchGetItemOutputTransformOutput_ {
	return _this.Data_BatchGetItemOutputTransformOutput_
}

type Data_BatchGetItemOutputTransformOutput_ interface {
	isBatchGetItemOutputTransformOutput()
}

type CompanionStruct_BatchGetItemOutputTransformOutput_ struct {
}

var Companion_BatchGetItemOutputTransformOutput_ = CompanionStruct_BatchGetItemOutputTransformOutput_{}

type BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.BatchGetItemOutput
}

func (BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput) isBatchGetItemOutputTransformOutput() {
}

func (CompanionStruct_BatchGetItemOutputTransformOutput_) Create_BatchGetItemOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.BatchGetItemOutput) BatchGetItemOutputTransformOutput {
	return BatchGetItemOutputTransformOutput{BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput{TransformedOutput}}
}

func (_this BatchGetItemOutputTransformOutput) Is_BatchGetItemOutputTransformOutput() bool {
	_, ok := _this.Get_().(BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput)
	return ok
}

func (CompanionStruct_BatchGetItemOutputTransformOutput_) Default() BatchGetItemOutputTransformOutput {
	return Companion_BatchGetItemOutputTransformOutput_.Create_BatchGetItemOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_BatchGetItemOutput_.Default())
}

func (_this BatchGetItemOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.BatchGetItemOutput {
	return _this.Get_().(BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput).TransformedOutput
}

func (_this BatchGetItemOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemOutputTransformOutput.BatchGetItemOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchGetItemOutputTransformOutput) Equals(other BatchGetItemOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput:
		{
			data2, ok := other.Get_().(BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchGetItemOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchGetItemOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_BatchGetItemOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_BatchGetItemOutputTransformOutput_{}
}

type type_BatchGetItemOutputTransformOutput_ struct {
}

func (_this type_BatchGetItemOutputTransformOutput_) Default() interface{} {
	return Companion_BatchGetItemOutputTransformOutput_.Default()
}

func (_this type_BatchGetItemOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemOutputTransformOutput"
}
func (_this BatchGetItemOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchGetItemOutputTransformOutput{}

// End of datatype BatchGetItemOutputTransformOutput

// Definition of datatype BatchWriteItemInputTransformInput
type BatchWriteItemInputTransformInput struct {
	Data_BatchWriteItemInputTransformInput_
}

func (_this BatchWriteItemInputTransformInput) Get_() Data_BatchWriteItemInputTransformInput_ {
	return _this.Data_BatchWriteItemInputTransformInput_
}

type Data_BatchWriteItemInputTransformInput_ interface {
	isBatchWriteItemInputTransformInput()
}

type CompanionStruct_BatchWriteItemInputTransformInput_ struct {
}

var Companion_BatchWriteItemInputTransformInput_ = CompanionStruct_BatchWriteItemInputTransformInput_{}

type BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
}

func (BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput) isBatchWriteItemInputTransformInput() {
}

func (CompanionStruct_BatchWriteItemInputTransformInput_) Create_BatchWriteItemInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.BatchWriteItemInput) BatchWriteItemInputTransformInput {
	return BatchWriteItemInputTransformInput{BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput{SdkInput}}
}

func (_this BatchWriteItemInputTransformInput) Is_BatchWriteItemInputTransformInput() bool {
	_, ok := _this.Get_().(BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput)
	return ok
}

func (CompanionStruct_BatchWriteItemInputTransformInput_) Default() BatchWriteItemInputTransformInput {
	return Companion_BatchWriteItemInputTransformInput_.Create_BatchWriteItemInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Default())
}

func (_this BatchWriteItemInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.BatchWriteItemInput {
	return _this.Get_().(BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput).SdkInput
}

func (_this BatchWriteItemInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformInput.BatchWriteItemInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchWriteItemInputTransformInput) Equals(other BatchWriteItemInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput:
		{
			data2, ok := other.Get_().(BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchWriteItemInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchWriteItemInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_BatchWriteItemInputTransformInput_() _dafny.TypeDescriptor {
	return type_BatchWriteItemInputTransformInput_{}
}

type type_BatchWriteItemInputTransformInput_ struct {
}

func (_this type_BatchWriteItemInputTransformInput_) Default() interface{} {
	return Companion_BatchWriteItemInputTransformInput_.Default()
}

func (_this type_BatchWriteItemInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformInput"
}
func (_this BatchWriteItemInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchWriteItemInputTransformInput{}

// End of datatype BatchWriteItemInputTransformInput

// Definition of datatype BatchWriteItemInputTransformOutput
type BatchWriteItemInputTransformOutput struct {
	Data_BatchWriteItemInputTransformOutput_
}

func (_this BatchWriteItemInputTransformOutput) Get_() Data_BatchWriteItemInputTransformOutput_ {
	return _this.Data_BatchWriteItemInputTransformOutput_
}

type Data_BatchWriteItemInputTransformOutput_ interface {
	isBatchWriteItemInputTransformOutput()
}

type CompanionStruct_BatchWriteItemInputTransformOutput_ struct {
}

var Companion_BatchWriteItemInputTransformOutput_ = CompanionStruct_BatchWriteItemInputTransformOutput_{}

type BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
}

func (BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput) isBatchWriteItemInputTransformOutput() {
}

func (CompanionStruct_BatchWriteItemInputTransformOutput_) Create_BatchWriteItemInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.BatchWriteItemInput) BatchWriteItemInputTransformOutput {
	return BatchWriteItemInputTransformOutput{BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput{TransformedInput}}
}

func (_this BatchWriteItemInputTransformOutput) Is_BatchWriteItemInputTransformOutput() bool {
	_, ok := _this.Get_().(BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput)
	return ok
}

func (CompanionStruct_BatchWriteItemInputTransformOutput_) Default() BatchWriteItemInputTransformOutput {
	return Companion_BatchWriteItemInputTransformOutput_.Create_BatchWriteItemInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Default())
}

func (_this BatchWriteItemInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.BatchWriteItemInput {
	return _this.Get_().(BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput).TransformedInput
}

func (_this BatchWriteItemInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput.BatchWriteItemInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchWriteItemInputTransformOutput) Equals(other BatchWriteItemInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput:
		{
			data2, ok := other.Get_().(BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchWriteItemInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchWriteItemInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_BatchWriteItemInputTransformOutput_() _dafny.TypeDescriptor {
	return type_BatchWriteItemInputTransformOutput_{}
}

type type_BatchWriteItemInputTransformOutput_ struct {
}

func (_this type_BatchWriteItemInputTransformOutput_) Default() interface{} {
	return Companion_BatchWriteItemInputTransformOutput_.Default()
}

func (_this type_BatchWriteItemInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput"
}
func (_this BatchWriteItemInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchWriteItemInputTransformOutput{}

// End of datatype BatchWriteItemInputTransformOutput

// Definition of datatype BatchWriteItemOutputTransformInput
type BatchWriteItemOutputTransformInput struct {
	Data_BatchWriteItemOutputTransformInput_
}

func (_this BatchWriteItemOutputTransformInput) Get_() Data_BatchWriteItemOutputTransformInput_ {
	return _this.Data_BatchWriteItemOutputTransformInput_
}

type Data_BatchWriteItemOutputTransformInput_ interface {
	isBatchWriteItemOutputTransformInput()
}

type CompanionStruct_BatchWriteItemOutputTransformInput_ struct {
}

var Companion_BatchWriteItemOutputTransformInput_ = CompanionStruct_BatchWriteItemOutputTransformInput_{}

type BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.BatchWriteItemInput
}

func (BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput) isBatchWriteItemOutputTransformInput() {
}

func (CompanionStruct_BatchWriteItemOutputTransformInput_) Create_BatchWriteItemOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput, OriginalInput m_ComAmazonawsDynamodbTypes.BatchWriteItemInput) BatchWriteItemOutputTransformInput {
	return BatchWriteItemOutputTransformInput{BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this BatchWriteItemOutputTransformInput) Is_BatchWriteItemOutputTransformInput() bool {
	_, ok := _this.Get_().(BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput)
	return ok
}

func (CompanionStruct_BatchWriteItemOutputTransformInput_) Default() BatchWriteItemOutputTransformInput {
	return Companion_BatchWriteItemOutputTransformInput_.Create_BatchWriteItemOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Default())
}

func (_this BatchWriteItemOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput {
	return _this.Get_().(BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput).SdkOutput
}

func (_this BatchWriteItemOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.BatchWriteItemInput {
	return _this.Get_().(BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput).OriginalInput
}

func (_this BatchWriteItemOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformInput.BatchWriteItemOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchWriteItemOutputTransformInput) Equals(other BatchWriteItemOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput:
		{
			data2, ok := other.Get_().(BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchWriteItemOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchWriteItemOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_BatchWriteItemOutputTransformInput_() _dafny.TypeDescriptor {
	return type_BatchWriteItemOutputTransformInput_{}
}

type type_BatchWriteItemOutputTransformInput_ struct {
}

func (_this type_BatchWriteItemOutputTransformInput_) Default() interface{} {
	return Companion_BatchWriteItemOutputTransformInput_.Default()
}

func (_this type_BatchWriteItemOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformInput"
}
func (_this BatchWriteItemOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchWriteItemOutputTransformInput{}

// End of datatype BatchWriteItemOutputTransformInput

// Definition of datatype BatchWriteItemOutputTransformOutput
type BatchWriteItemOutputTransformOutput struct {
	Data_BatchWriteItemOutputTransformOutput_
}

func (_this BatchWriteItemOutputTransformOutput) Get_() Data_BatchWriteItemOutputTransformOutput_ {
	return _this.Data_BatchWriteItemOutputTransformOutput_
}

type Data_BatchWriteItemOutputTransformOutput_ interface {
	isBatchWriteItemOutputTransformOutput()
}

type CompanionStruct_BatchWriteItemOutputTransformOutput_ struct {
}

var Companion_BatchWriteItemOutputTransformOutput_ = CompanionStruct_BatchWriteItemOutputTransformOutput_{}

type BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
}

func (BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput) isBatchWriteItemOutputTransformOutput() {
}

func (CompanionStruct_BatchWriteItemOutputTransformOutput_) Create_BatchWriteItemOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput) BatchWriteItemOutputTransformOutput {
	return BatchWriteItemOutputTransformOutput{BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput{TransformedOutput}}
}

func (_this BatchWriteItemOutputTransformOutput) Is_BatchWriteItemOutputTransformOutput() bool {
	_, ok := _this.Get_().(BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput)
	return ok
}

func (CompanionStruct_BatchWriteItemOutputTransformOutput_) Default() BatchWriteItemOutputTransformOutput {
	return Companion_BatchWriteItemOutputTransformOutput_.Create_BatchWriteItemOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Default())
}

func (_this BatchWriteItemOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput {
	return _this.Get_().(BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput).TransformedOutput
}

func (_this BatchWriteItemOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput.BatchWriteItemOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BatchWriteItemOutputTransformOutput) Equals(other BatchWriteItemOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput:
		{
			data2, ok := other.Get_().(BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BatchWriteItemOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BatchWriteItemOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_BatchWriteItemOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_BatchWriteItemOutputTransformOutput_{}
}

type type_BatchWriteItemOutputTransformOutput_ struct {
}

func (_this type_BatchWriteItemOutputTransformOutput_) Default() interface{} {
	return Companion_BatchWriteItemOutputTransformOutput_.Default()
}

func (_this type_BatchWriteItemOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput"
}
func (_this BatchWriteItemOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BatchWriteItemOutputTransformOutput{}

// End of datatype BatchWriteItemOutputTransformOutput

// Definition of datatype DeleteItemInputTransformInput
type DeleteItemInputTransformInput struct {
	Data_DeleteItemInputTransformInput_
}

func (_this DeleteItemInputTransformInput) Get_() Data_DeleteItemInputTransformInput_ {
	return _this.Data_DeleteItemInputTransformInput_
}

type Data_DeleteItemInputTransformInput_ interface {
	isDeleteItemInputTransformInput()
}

type CompanionStruct_DeleteItemInputTransformInput_ struct {
}

var Companion_DeleteItemInputTransformInput_ = CompanionStruct_DeleteItemInputTransformInput_{}

type DeleteItemInputTransformInput_DeleteItemInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.DeleteItemInput
}

func (DeleteItemInputTransformInput_DeleteItemInputTransformInput) isDeleteItemInputTransformInput() {
}

func (CompanionStruct_DeleteItemInputTransformInput_) Create_DeleteItemInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.DeleteItemInput) DeleteItemInputTransformInput {
	return DeleteItemInputTransformInput{DeleteItemInputTransformInput_DeleteItemInputTransformInput{SdkInput}}
}

func (_this DeleteItemInputTransformInput) Is_DeleteItemInputTransformInput() bool {
	_, ok := _this.Get_().(DeleteItemInputTransformInput_DeleteItemInputTransformInput)
	return ok
}

func (CompanionStruct_DeleteItemInputTransformInput_) Default() DeleteItemInputTransformInput {
	return Companion_DeleteItemInputTransformInput_.Create_DeleteItemInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_DeleteItemInput_.Default())
}

func (_this DeleteItemInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.DeleteItemInput {
	return _this.Get_().(DeleteItemInputTransformInput_DeleteItemInputTransformInput).SdkInput
}

func (_this DeleteItemInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteItemInputTransformInput_DeleteItemInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemInputTransformInput.DeleteItemInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteItemInputTransformInput) Equals(other DeleteItemInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case DeleteItemInputTransformInput_DeleteItemInputTransformInput:
		{
			data2, ok := other.Get_().(DeleteItemInputTransformInput_DeleteItemInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteItemInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteItemInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_DeleteItemInputTransformInput_() _dafny.TypeDescriptor {
	return type_DeleteItemInputTransformInput_{}
}

type type_DeleteItemInputTransformInput_ struct {
}

func (_this type_DeleteItemInputTransformInput_) Default() interface{} {
	return Companion_DeleteItemInputTransformInput_.Default()
}

func (_this type_DeleteItemInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemInputTransformInput"
}
func (_this DeleteItemInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteItemInputTransformInput{}

// End of datatype DeleteItemInputTransformInput

// Definition of datatype DeleteItemInputTransformOutput
type DeleteItemInputTransformOutput struct {
	Data_DeleteItemInputTransformOutput_
}

func (_this DeleteItemInputTransformOutput) Get_() Data_DeleteItemInputTransformOutput_ {
	return _this.Data_DeleteItemInputTransformOutput_
}

type Data_DeleteItemInputTransformOutput_ interface {
	isDeleteItemInputTransformOutput()
}

type CompanionStruct_DeleteItemInputTransformOutput_ struct {
}

var Companion_DeleteItemInputTransformOutput_ = CompanionStruct_DeleteItemInputTransformOutput_{}

type DeleteItemInputTransformOutput_DeleteItemInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.DeleteItemInput
}

func (DeleteItemInputTransformOutput_DeleteItemInputTransformOutput) isDeleteItemInputTransformOutput() {
}

func (CompanionStruct_DeleteItemInputTransformOutput_) Create_DeleteItemInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.DeleteItemInput) DeleteItemInputTransformOutput {
	return DeleteItemInputTransformOutput{DeleteItemInputTransformOutput_DeleteItemInputTransformOutput{TransformedInput}}
}

func (_this DeleteItemInputTransformOutput) Is_DeleteItemInputTransformOutput() bool {
	_, ok := _this.Get_().(DeleteItemInputTransformOutput_DeleteItemInputTransformOutput)
	return ok
}

func (CompanionStruct_DeleteItemInputTransformOutput_) Default() DeleteItemInputTransformOutput {
	return Companion_DeleteItemInputTransformOutput_.Create_DeleteItemInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_DeleteItemInput_.Default())
}

func (_this DeleteItemInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.DeleteItemInput {
	return _this.Get_().(DeleteItemInputTransformOutput_DeleteItemInputTransformOutput).TransformedInput
}

func (_this DeleteItemInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteItemInputTransformOutput_DeleteItemInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemInputTransformOutput.DeleteItemInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteItemInputTransformOutput) Equals(other DeleteItemInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case DeleteItemInputTransformOutput_DeleteItemInputTransformOutput:
		{
			data2, ok := other.Get_().(DeleteItemInputTransformOutput_DeleteItemInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteItemInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteItemInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_DeleteItemInputTransformOutput_() _dafny.TypeDescriptor {
	return type_DeleteItemInputTransformOutput_{}
}

type type_DeleteItemInputTransformOutput_ struct {
}

func (_this type_DeleteItemInputTransformOutput_) Default() interface{} {
	return Companion_DeleteItemInputTransformOutput_.Default()
}

func (_this type_DeleteItemInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemInputTransformOutput"
}
func (_this DeleteItemInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteItemInputTransformOutput{}

// End of datatype DeleteItemInputTransformOutput

// Definition of datatype DeleteItemOutputTransformInput
type DeleteItemOutputTransformInput struct {
	Data_DeleteItemOutputTransformInput_
}

func (_this DeleteItemOutputTransformInput) Get_() Data_DeleteItemOutputTransformInput_ {
	return _this.Data_DeleteItemOutputTransformInput_
}

type Data_DeleteItemOutputTransformInput_ interface {
	isDeleteItemOutputTransformInput()
}

type CompanionStruct_DeleteItemOutputTransformInput_ struct {
}

var Companion_DeleteItemOutputTransformInput_ = CompanionStruct_DeleteItemOutputTransformInput_{}

type DeleteItemOutputTransformInput_DeleteItemOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.DeleteItemOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.DeleteItemInput
}

func (DeleteItemOutputTransformInput_DeleteItemOutputTransformInput) isDeleteItemOutputTransformInput() {
}

func (CompanionStruct_DeleteItemOutputTransformInput_) Create_DeleteItemOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.DeleteItemOutput, OriginalInput m_ComAmazonawsDynamodbTypes.DeleteItemInput) DeleteItemOutputTransformInput {
	return DeleteItemOutputTransformInput{DeleteItemOutputTransformInput_DeleteItemOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this DeleteItemOutputTransformInput) Is_DeleteItemOutputTransformInput() bool {
	_, ok := _this.Get_().(DeleteItemOutputTransformInput_DeleteItemOutputTransformInput)
	return ok
}

func (CompanionStruct_DeleteItemOutputTransformInput_) Default() DeleteItemOutputTransformInput {
	return Companion_DeleteItemOutputTransformInput_.Create_DeleteItemOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_DeleteItemOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_DeleteItemInput_.Default())
}

func (_this DeleteItemOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.DeleteItemOutput {
	return _this.Get_().(DeleteItemOutputTransformInput_DeleteItemOutputTransformInput).SdkOutput
}

func (_this DeleteItemOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.DeleteItemInput {
	return _this.Get_().(DeleteItemOutputTransformInput_DeleteItemOutputTransformInput).OriginalInput
}

func (_this DeleteItemOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteItemOutputTransformInput_DeleteItemOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemOutputTransformInput.DeleteItemOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteItemOutputTransformInput) Equals(other DeleteItemOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case DeleteItemOutputTransformInput_DeleteItemOutputTransformInput:
		{
			data2, ok := other.Get_().(DeleteItemOutputTransformInput_DeleteItemOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteItemOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteItemOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_DeleteItemOutputTransformInput_() _dafny.TypeDescriptor {
	return type_DeleteItemOutputTransformInput_{}
}

type type_DeleteItemOutputTransformInput_ struct {
}

func (_this type_DeleteItemOutputTransformInput_) Default() interface{} {
	return Companion_DeleteItemOutputTransformInput_.Default()
}

func (_this type_DeleteItemOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemOutputTransformInput"
}
func (_this DeleteItemOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteItemOutputTransformInput{}

// End of datatype DeleteItemOutputTransformInput

// Definition of datatype DeleteItemOutputTransformOutput
type DeleteItemOutputTransformOutput struct {
	Data_DeleteItemOutputTransformOutput_
}

func (_this DeleteItemOutputTransformOutput) Get_() Data_DeleteItemOutputTransformOutput_ {
	return _this.Data_DeleteItemOutputTransformOutput_
}

type Data_DeleteItemOutputTransformOutput_ interface {
	isDeleteItemOutputTransformOutput()
}

type CompanionStruct_DeleteItemOutputTransformOutput_ struct {
}

var Companion_DeleteItemOutputTransformOutput_ = CompanionStruct_DeleteItemOutputTransformOutput_{}

type DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.DeleteItemOutput
}

func (DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput) isDeleteItemOutputTransformOutput() {
}

func (CompanionStruct_DeleteItemOutputTransformOutput_) Create_DeleteItemOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.DeleteItemOutput) DeleteItemOutputTransformOutput {
	return DeleteItemOutputTransformOutput{DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput{TransformedOutput}}
}

func (_this DeleteItemOutputTransformOutput) Is_DeleteItemOutputTransformOutput() bool {
	_, ok := _this.Get_().(DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput)
	return ok
}

func (CompanionStruct_DeleteItemOutputTransformOutput_) Default() DeleteItemOutputTransformOutput {
	return Companion_DeleteItemOutputTransformOutput_.Create_DeleteItemOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_DeleteItemOutput_.Default())
}

func (_this DeleteItemOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.DeleteItemOutput {
	return _this.Get_().(DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput).TransformedOutput
}

func (_this DeleteItemOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemOutputTransformOutput.DeleteItemOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteItemOutputTransformOutput) Equals(other DeleteItemOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput:
		{
			data2, ok := other.Get_().(DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteItemOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteItemOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_DeleteItemOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_DeleteItemOutputTransformOutput_{}
}

type type_DeleteItemOutputTransformOutput_ struct {
}

func (_this type_DeleteItemOutputTransformOutput_) Default() interface{} {
	return Companion_DeleteItemOutputTransformOutput_.Default()
}

func (_this type_DeleteItemOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemOutputTransformOutput"
}
func (_this DeleteItemOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteItemOutputTransformOutput{}

// End of datatype DeleteItemOutputTransformOutput

// Definition of class IDynamoDbEncryptionTransformsClientCallHistory
type IDynamoDbEncryptionTransformsClientCallHistory struct {
	dummy byte
}

func New_IDynamoDbEncryptionTransformsClientCallHistory_() *IDynamoDbEncryptionTransformsClientCallHistory {
	_this := IDynamoDbEncryptionTransformsClientCallHistory{}

	return &_this
}

type CompanionStruct_IDynamoDbEncryptionTransformsClientCallHistory_ struct {
}

var Companion_IDynamoDbEncryptionTransformsClientCallHistory_ = CompanionStruct_IDynamoDbEncryptionTransformsClientCallHistory_{}

func (_this *IDynamoDbEncryptionTransformsClientCallHistory) Equals(other *IDynamoDbEncryptionTransformsClientCallHistory) bool {
	return _this == other
}

func (_this *IDynamoDbEncryptionTransformsClientCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IDynamoDbEncryptionTransformsClientCallHistory)
	return ok && _this.Equals(other)
}

func (*IDynamoDbEncryptionTransformsClientCallHistory) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.IDynamoDbEncryptionTransformsClientCallHistory"
}

func Type_IDynamoDbEncryptionTransformsClientCallHistory_() _dafny.TypeDescriptor {
	return type_IDynamoDbEncryptionTransformsClientCallHistory_{}
}

type type_IDynamoDbEncryptionTransformsClientCallHistory_ struct {
}

func (_this type_IDynamoDbEncryptionTransformsClientCallHistory_) Default() interface{} {
	return (*IDynamoDbEncryptionTransformsClientCallHistory)(nil)
}

func (_this type_IDynamoDbEncryptionTransformsClientCallHistory_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.IDynamoDbEncryptionTransformsClientCallHistory"
}
func (_this *IDynamoDbEncryptionTransformsClientCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IDynamoDbEncryptionTransformsClientCallHistory{}

// End of class IDynamoDbEncryptionTransformsClientCallHistory

// Definition of trait IDynamoDbEncryptionTransformsClient
type IDynamoDbEncryptionTransformsClient interface {
	String() string
	PutItemInputTransform(input PutItemInputTransformInput) m_Wrappers.Result
	PutItemOutputTransform(input PutItemOutputTransformInput) m_Wrappers.Result
	GetItemInputTransform(input GetItemInputTransformInput) m_Wrappers.Result
	GetItemOutputTransform(input GetItemOutputTransformInput) m_Wrappers.Result
	BatchWriteItemInputTransform(input BatchWriteItemInputTransformInput) m_Wrappers.Result
	BatchWriteItemOutputTransform(input BatchWriteItemOutputTransformInput) m_Wrappers.Result
	BatchGetItemInputTransform(input BatchGetItemInputTransformInput) m_Wrappers.Result
	BatchGetItemOutputTransform(input BatchGetItemOutputTransformInput) m_Wrappers.Result
	ScanInputTransform(input ScanInputTransformInput) m_Wrappers.Result
	ScanOutputTransform(input ScanOutputTransformInput) m_Wrappers.Result
	QueryInputTransform(input QueryInputTransformInput) m_Wrappers.Result
	QueryOutputTransform(input QueryOutputTransformInput) m_Wrappers.Result
	TransactWriteItemsInputTransform(input TransactWriteItemsInputTransformInput) m_Wrappers.Result
	TransactWriteItemsOutputTransform(input TransactWriteItemsOutputTransformInput) m_Wrappers.Result
	UpdateItemInputTransform(input UpdateItemInputTransformInput) m_Wrappers.Result
	UpdateItemOutputTransform(input UpdateItemOutputTransformInput) m_Wrappers.Result
	DeleteItemInputTransform(input DeleteItemInputTransformInput) m_Wrappers.Result
	DeleteItemOutputTransform(input DeleteItemOutputTransformInput) m_Wrappers.Result
	TransactGetItemsInputTransform(input TransactGetItemsInputTransformInput) m_Wrappers.Result
	TransactGetItemsOutputTransform(input TransactGetItemsOutputTransformInput) m_Wrappers.Result
	ExecuteStatementInputTransform(input ExecuteStatementInputTransformInput) m_Wrappers.Result
	ExecuteStatementOutputTransform(input ExecuteStatementOutputTransformInput) m_Wrappers.Result
	BatchExecuteStatementInputTransform(input BatchExecuteStatementInputTransformInput) m_Wrappers.Result
	BatchExecuteStatementOutputTransform(input BatchExecuteStatementOutputTransformInput) m_Wrappers.Result
	ExecuteTransactionInputTransform(input ExecuteTransactionInputTransformInput) m_Wrappers.Result
	ExecuteTransactionOutputTransform(input ExecuteTransactionOutputTransformInput) m_Wrappers.Result
	ResolveAttributes(input ResolveAttributesInput) m_Wrappers.Result
}
type CompanionStruct_IDynamoDbEncryptionTransformsClient_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IDynamoDbEncryptionTransformsClient_ = CompanionStruct_IDynamoDbEncryptionTransformsClient_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IDynamoDbEncryptionTransformsClient_) CastTo_(x interface{}) IDynamoDbEncryptionTransformsClient {
	var t IDynamoDbEncryptionTransformsClient
	t, _ = x.(IDynamoDbEncryptionTransformsClient)
	return t
}

// End of trait IDynamoDbEncryptionTransformsClient

// Definition of datatype ExecuteStatementInputTransformInput
type ExecuteStatementInputTransformInput struct {
	Data_ExecuteStatementInputTransformInput_
}

func (_this ExecuteStatementInputTransformInput) Get_() Data_ExecuteStatementInputTransformInput_ {
	return _this.Data_ExecuteStatementInputTransformInput_
}

type Data_ExecuteStatementInputTransformInput_ interface {
	isExecuteStatementInputTransformInput()
}

type CompanionStruct_ExecuteStatementInputTransformInput_ struct {
}

var Companion_ExecuteStatementInputTransformInput_ = CompanionStruct_ExecuteStatementInputTransformInput_{}

type ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.ExecuteStatementInput
}

func (ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput) isExecuteStatementInputTransformInput() {
}

func (CompanionStruct_ExecuteStatementInputTransformInput_) Create_ExecuteStatementInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.ExecuteStatementInput) ExecuteStatementInputTransformInput {
	return ExecuteStatementInputTransformInput{ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput{SdkInput}}
}

func (_this ExecuteStatementInputTransformInput) Is_ExecuteStatementInputTransformInput() bool {
	_, ok := _this.Get_().(ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput)
	return ok
}

func (CompanionStruct_ExecuteStatementInputTransformInput_) Default() ExecuteStatementInputTransformInput {
	return Companion_ExecuteStatementInputTransformInput_.Create_ExecuteStatementInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_ExecuteStatementInput_.Default())
}

func (_this ExecuteStatementInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.ExecuteStatementInput {
	return _this.Get_().(ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput).SdkInput
}

func (_this ExecuteStatementInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementInputTransformInput.ExecuteStatementInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExecuteStatementInputTransformInput) Equals(other ExecuteStatementInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput:
		{
			data2, ok := other.Get_().(ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExecuteStatementInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExecuteStatementInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_ExecuteStatementInputTransformInput_() _dafny.TypeDescriptor {
	return type_ExecuteStatementInputTransformInput_{}
}

type type_ExecuteStatementInputTransformInput_ struct {
}

func (_this type_ExecuteStatementInputTransformInput_) Default() interface{} {
	return Companion_ExecuteStatementInputTransformInput_.Default()
}

func (_this type_ExecuteStatementInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementInputTransformInput"
}
func (_this ExecuteStatementInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExecuteStatementInputTransformInput{}

// End of datatype ExecuteStatementInputTransformInput

// Definition of datatype ExecuteStatementInputTransformOutput
type ExecuteStatementInputTransformOutput struct {
	Data_ExecuteStatementInputTransformOutput_
}

func (_this ExecuteStatementInputTransformOutput) Get_() Data_ExecuteStatementInputTransformOutput_ {
	return _this.Data_ExecuteStatementInputTransformOutput_
}

type Data_ExecuteStatementInputTransformOutput_ interface {
	isExecuteStatementInputTransformOutput()
}

type CompanionStruct_ExecuteStatementInputTransformOutput_ struct {
}

var Companion_ExecuteStatementInputTransformOutput_ = CompanionStruct_ExecuteStatementInputTransformOutput_{}

type ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.ExecuteStatementInput
}

func (ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput) isExecuteStatementInputTransformOutput() {
}

func (CompanionStruct_ExecuteStatementInputTransformOutput_) Create_ExecuteStatementInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.ExecuteStatementInput) ExecuteStatementInputTransformOutput {
	return ExecuteStatementInputTransformOutput{ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput{TransformedInput}}
}

func (_this ExecuteStatementInputTransformOutput) Is_ExecuteStatementInputTransformOutput() bool {
	_, ok := _this.Get_().(ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput)
	return ok
}

func (CompanionStruct_ExecuteStatementInputTransformOutput_) Default() ExecuteStatementInputTransformOutput {
	return Companion_ExecuteStatementInputTransformOutput_.Create_ExecuteStatementInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_ExecuteStatementInput_.Default())
}

func (_this ExecuteStatementInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.ExecuteStatementInput {
	return _this.Get_().(ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput).TransformedInput
}

func (_this ExecuteStatementInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementInputTransformOutput.ExecuteStatementInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExecuteStatementInputTransformOutput) Equals(other ExecuteStatementInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput:
		{
			data2, ok := other.Get_().(ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExecuteStatementInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExecuteStatementInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_ExecuteStatementInputTransformOutput_() _dafny.TypeDescriptor {
	return type_ExecuteStatementInputTransformOutput_{}
}

type type_ExecuteStatementInputTransformOutput_ struct {
}

func (_this type_ExecuteStatementInputTransformOutput_) Default() interface{} {
	return Companion_ExecuteStatementInputTransformOutput_.Default()
}

func (_this type_ExecuteStatementInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementInputTransformOutput"
}
func (_this ExecuteStatementInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExecuteStatementInputTransformOutput{}

// End of datatype ExecuteStatementInputTransformOutput

// Definition of datatype ExecuteStatementOutputTransformInput
type ExecuteStatementOutputTransformInput struct {
	Data_ExecuteStatementOutputTransformInput_
}

func (_this ExecuteStatementOutputTransformInput) Get_() Data_ExecuteStatementOutputTransformInput_ {
	return _this.Data_ExecuteStatementOutputTransformInput_
}

type Data_ExecuteStatementOutputTransformInput_ interface {
	isExecuteStatementOutputTransformInput()
}

type CompanionStruct_ExecuteStatementOutputTransformInput_ struct {
}

var Companion_ExecuteStatementOutputTransformInput_ = CompanionStruct_ExecuteStatementOutputTransformInput_{}

type ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.ExecuteStatementOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.ExecuteStatementInput
}

func (ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput) isExecuteStatementOutputTransformInput() {
}

func (CompanionStruct_ExecuteStatementOutputTransformInput_) Create_ExecuteStatementOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.ExecuteStatementOutput, OriginalInput m_ComAmazonawsDynamodbTypes.ExecuteStatementInput) ExecuteStatementOutputTransformInput {
	return ExecuteStatementOutputTransformInput{ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this ExecuteStatementOutputTransformInput) Is_ExecuteStatementOutputTransformInput() bool {
	_, ok := _this.Get_().(ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput)
	return ok
}

func (CompanionStruct_ExecuteStatementOutputTransformInput_) Default() ExecuteStatementOutputTransformInput {
	return Companion_ExecuteStatementOutputTransformInput_.Create_ExecuteStatementOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_ExecuteStatementOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_ExecuteStatementInput_.Default())
}

func (_this ExecuteStatementOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.ExecuteStatementOutput {
	return _this.Get_().(ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput).SdkOutput
}

func (_this ExecuteStatementOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.ExecuteStatementInput {
	return _this.Get_().(ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput).OriginalInput
}

func (_this ExecuteStatementOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementOutputTransformInput.ExecuteStatementOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExecuteStatementOutputTransformInput) Equals(other ExecuteStatementOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput:
		{
			data2, ok := other.Get_().(ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExecuteStatementOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExecuteStatementOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_ExecuteStatementOutputTransformInput_() _dafny.TypeDescriptor {
	return type_ExecuteStatementOutputTransformInput_{}
}

type type_ExecuteStatementOutputTransformInput_ struct {
}

func (_this type_ExecuteStatementOutputTransformInput_) Default() interface{} {
	return Companion_ExecuteStatementOutputTransformInput_.Default()
}

func (_this type_ExecuteStatementOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementOutputTransformInput"
}
func (_this ExecuteStatementOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExecuteStatementOutputTransformInput{}

// End of datatype ExecuteStatementOutputTransformInput

// Definition of datatype ExecuteStatementOutputTransformOutput
type ExecuteStatementOutputTransformOutput struct {
	Data_ExecuteStatementOutputTransformOutput_
}

func (_this ExecuteStatementOutputTransformOutput) Get_() Data_ExecuteStatementOutputTransformOutput_ {
	return _this.Data_ExecuteStatementOutputTransformOutput_
}

type Data_ExecuteStatementOutputTransformOutput_ interface {
	isExecuteStatementOutputTransformOutput()
}

type CompanionStruct_ExecuteStatementOutputTransformOutput_ struct {
}

var Companion_ExecuteStatementOutputTransformOutput_ = CompanionStruct_ExecuteStatementOutputTransformOutput_{}

type ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.ExecuteStatementOutput
}

func (ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput) isExecuteStatementOutputTransformOutput() {
}

func (CompanionStruct_ExecuteStatementOutputTransformOutput_) Create_ExecuteStatementOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.ExecuteStatementOutput) ExecuteStatementOutputTransformOutput {
	return ExecuteStatementOutputTransformOutput{ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput{TransformedOutput}}
}

func (_this ExecuteStatementOutputTransformOutput) Is_ExecuteStatementOutputTransformOutput() bool {
	_, ok := _this.Get_().(ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput)
	return ok
}

func (CompanionStruct_ExecuteStatementOutputTransformOutput_) Default() ExecuteStatementOutputTransformOutput {
	return Companion_ExecuteStatementOutputTransformOutput_.Create_ExecuteStatementOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_ExecuteStatementOutput_.Default())
}

func (_this ExecuteStatementOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.ExecuteStatementOutput {
	return _this.Get_().(ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput).TransformedOutput
}

func (_this ExecuteStatementOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementOutputTransformOutput.ExecuteStatementOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExecuteStatementOutputTransformOutput) Equals(other ExecuteStatementOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput:
		{
			data2, ok := other.Get_().(ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExecuteStatementOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExecuteStatementOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_ExecuteStatementOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_ExecuteStatementOutputTransformOutput_{}
}

type type_ExecuteStatementOutputTransformOutput_ struct {
}

func (_this type_ExecuteStatementOutputTransformOutput_) Default() interface{} {
	return Companion_ExecuteStatementOutputTransformOutput_.Default()
}

func (_this type_ExecuteStatementOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementOutputTransformOutput"
}
func (_this ExecuteStatementOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExecuteStatementOutputTransformOutput{}

// End of datatype ExecuteStatementOutputTransformOutput

// Definition of datatype ExecuteTransactionInputTransformInput
type ExecuteTransactionInputTransformInput struct {
	Data_ExecuteTransactionInputTransformInput_
}

func (_this ExecuteTransactionInputTransformInput) Get_() Data_ExecuteTransactionInputTransformInput_ {
	return _this.Data_ExecuteTransactionInputTransformInput_
}

type Data_ExecuteTransactionInputTransformInput_ interface {
	isExecuteTransactionInputTransformInput()
}

type CompanionStruct_ExecuteTransactionInputTransformInput_ struct {
}

var Companion_ExecuteTransactionInputTransformInput_ = CompanionStruct_ExecuteTransactionInputTransformInput_{}

type ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput
}

func (ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput) isExecuteTransactionInputTransformInput() {
}

func (CompanionStruct_ExecuteTransactionInputTransformInput_) Create_ExecuteTransactionInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput) ExecuteTransactionInputTransformInput {
	return ExecuteTransactionInputTransformInput{ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput{SdkInput}}
}

func (_this ExecuteTransactionInputTransformInput) Is_ExecuteTransactionInputTransformInput() bool {
	_, ok := _this.Get_().(ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput)
	return ok
}

func (CompanionStruct_ExecuteTransactionInputTransformInput_) Default() ExecuteTransactionInputTransformInput {
	return Companion_ExecuteTransactionInputTransformInput_.Create_ExecuteTransactionInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_ExecuteTransactionInput_.Default())
}

func (_this ExecuteTransactionInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput {
	return _this.Get_().(ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput).SdkInput
}

func (_this ExecuteTransactionInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionInputTransformInput.ExecuteTransactionInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExecuteTransactionInputTransformInput) Equals(other ExecuteTransactionInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput:
		{
			data2, ok := other.Get_().(ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExecuteTransactionInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExecuteTransactionInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_ExecuteTransactionInputTransformInput_() _dafny.TypeDescriptor {
	return type_ExecuteTransactionInputTransformInput_{}
}

type type_ExecuteTransactionInputTransformInput_ struct {
}

func (_this type_ExecuteTransactionInputTransformInput_) Default() interface{} {
	return Companion_ExecuteTransactionInputTransformInput_.Default()
}

func (_this type_ExecuteTransactionInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionInputTransformInput"
}
func (_this ExecuteTransactionInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExecuteTransactionInputTransformInput{}

// End of datatype ExecuteTransactionInputTransformInput

// Definition of datatype ExecuteTransactionInputTransformOutput
type ExecuteTransactionInputTransformOutput struct {
	Data_ExecuteTransactionInputTransformOutput_
}

func (_this ExecuteTransactionInputTransformOutput) Get_() Data_ExecuteTransactionInputTransformOutput_ {
	return _this.Data_ExecuteTransactionInputTransformOutput_
}

type Data_ExecuteTransactionInputTransformOutput_ interface {
	isExecuteTransactionInputTransformOutput()
}

type CompanionStruct_ExecuteTransactionInputTransformOutput_ struct {
}

var Companion_ExecuteTransactionInputTransformOutput_ = CompanionStruct_ExecuteTransactionInputTransformOutput_{}

type ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput
}

func (ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput) isExecuteTransactionInputTransformOutput() {
}

func (CompanionStruct_ExecuteTransactionInputTransformOutput_) Create_ExecuteTransactionInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput) ExecuteTransactionInputTransformOutput {
	return ExecuteTransactionInputTransformOutput{ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput{TransformedInput}}
}

func (_this ExecuteTransactionInputTransformOutput) Is_ExecuteTransactionInputTransformOutput() bool {
	_, ok := _this.Get_().(ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput)
	return ok
}

func (CompanionStruct_ExecuteTransactionInputTransformOutput_) Default() ExecuteTransactionInputTransformOutput {
	return Companion_ExecuteTransactionInputTransformOutput_.Create_ExecuteTransactionInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_ExecuteTransactionInput_.Default())
}

func (_this ExecuteTransactionInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput {
	return _this.Get_().(ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput).TransformedInput
}

func (_this ExecuteTransactionInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionInputTransformOutput.ExecuteTransactionInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExecuteTransactionInputTransformOutput) Equals(other ExecuteTransactionInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput:
		{
			data2, ok := other.Get_().(ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExecuteTransactionInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExecuteTransactionInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_ExecuteTransactionInputTransformOutput_() _dafny.TypeDescriptor {
	return type_ExecuteTransactionInputTransformOutput_{}
}

type type_ExecuteTransactionInputTransformOutput_ struct {
}

func (_this type_ExecuteTransactionInputTransformOutput_) Default() interface{} {
	return Companion_ExecuteTransactionInputTransformOutput_.Default()
}

func (_this type_ExecuteTransactionInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionInputTransformOutput"
}
func (_this ExecuteTransactionInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExecuteTransactionInputTransformOutput{}

// End of datatype ExecuteTransactionInputTransformOutput

// Definition of datatype ExecuteTransactionOutputTransformInput
type ExecuteTransactionOutputTransformInput struct {
	Data_ExecuteTransactionOutputTransformInput_
}

func (_this ExecuteTransactionOutputTransformInput) Get_() Data_ExecuteTransactionOutputTransformInput_ {
	return _this.Data_ExecuteTransactionOutputTransformInput_
}

type Data_ExecuteTransactionOutputTransformInput_ interface {
	isExecuteTransactionOutputTransformInput()
}

type CompanionStruct_ExecuteTransactionOutputTransformInput_ struct {
}

var Companion_ExecuteTransactionOutputTransformInput_ = CompanionStruct_ExecuteTransactionOutputTransformInput_{}

type ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.ExecuteTransactionOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput
}

func (ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput) isExecuteTransactionOutputTransformInput() {
}

func (CompanionStruct_ExecuteTransactionOutputTransformInput_) Create_ExecuteTransactionOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.ExecuteTransactionOutput, OriginalInput m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput) ExecuteTransactionOutputTransformInput {
	return ExecuteTransactionOutputTransformInput{ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this ExecuteTransactionOutputTransformInput) Is_ExecuteTransactionOutputTransformInput() bool {
	_, ok := _this.Get_().(ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput)
	return ok
}

func (CompanionStruct_ExecuteTransactionOutputTransformInput_) Default() ExecuteTransactionOutputTransformInput {
	return Companion_ExecuteTransactionOutputTransformInput_.Create_ExecuteTransactionOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_ExecuteTransactionOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_ExecuteTransactionInput_.Default())
}

func (_this ExecuteTransactionOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.ExecuteTransactionOutput {
	return _this.Get_().(ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput).SdkOutput
}

func (_this ExecuteTransactionOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.ExecuteTransactionInput {
	return _this.Get_().(ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput).OriginalInput
}

func (_this ExecuteTransactionOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionOutputTransformInput.ExecuteTransactionOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExecuteTransactionOutputTransformInput) Equals(other ExecuteTransactionOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput:
		{
			data2, ok := other.Get_().(ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExecuteTransactionOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExecuteTransactionOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_ExecuteTransactionOutputTransformInput_() _dafny.TypeDescriptor {
	return type_ExecuteTransactionOutputTransformInput_{}
}

type type_ExecuteTransactionOutputTransformInput_ struct {
}

func (_this type_ExecuteTransactionOutputTransformInput_) Default() interface{} {
	return Companion_ExecuteTransactionOutputTransformInput_.Default()
}

func (_this type_ExecuteTransactionOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionOutputTransformInput"
}
func (_this ExecuteTransactionOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExecuteTransactionOutputTransformInput{}

// End of datatype ExecuteTransactionOutputTransformInput

// Definition of datatype ExecuteTransactionOutputTransformOutput
type ExecuteTransactionOutputTransformOutput struct {
	Data_ExecuteTransactionOutputTransformOutput_
}

func (_this ExecuteTransactionOutputTransformOutput) Get_() Data_ExecuteTransactionOutputTransformOutput_ {
	return _this.Data_ExecuteTransactionOutputTransformOutput_
}

type Data_ExecuteTransactionOutputTransformOutput_ interface {
	isExecuteTransactionOutputTransformOutput()
}

type CompanionStruct_ExecuteTransactionOutputTransformOutput_ struct {
}

var Companion_ExecuteTransactionOutputTransformOutput_ = CompanionStruct_ExecuteTransactionOutputTransformOutput_{}

type ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.ExecuteTransactionOutput
}

func (ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput) isExecuteTransactionOutputTransformOutput() {
}

func (CompanionStruct_ExecuteTransactionOutputTransformOutput_) Create_ExecuteTransactionOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.ExecuteTransactionOutput) ExecuteTransactionOutputTransformOutput {
	return ExecuteTransactionOutputTransformOutput{ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput{TransformedOutput}}
}

func (_this ExecuteTransactionOutputTransformOutput) Is_ExecuteTransactionOutputTransformOutput() bool {
	_, ok := _this.Get_().(ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput)
	return ok
}

func (CompanionStruct_ExecuteTransactionOutputTransformOutput_) Default() ExecuteTransactionOutputTransformOutput {
	return Companion_ExecuteTransactionOutputTransformOutput_.Create_ExecuteTransactionOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_ExecuteTransactionOutput_.Default())
}

func (_this ExecuteTransactionOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.ExecuteTransactionOutput {
	return _this.Get_().(ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput).TransformedOutput
}

func (_this ExecuteTransactionOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionOutputTransformOutput.ExecuteTransactionOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExecuteTransactionOutputTransformOutput) Equals(other ExecuteTransactionOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput:
		{
			data2, ok := other.Get_().(ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExecuteTransactionOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExecuteTransactionOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_ExecuteTransactionOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_ExecuteTransactionOutputTransformOutput_{}
}

type type_ExecuteTransactionOutputTransformOutput_ struct {
}

func (_this type_ExecuteTransactionOutputTransformOutput_) Default() interface{} {
	return Companion_ExecuteTransactionOutputTransformOutput_.Default()
}

func (_this type_ExecuteTransactionOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionOutputTransformOutput"
}
func (_this ExecuteTransactionOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExecuteTransactionOutputTransformOutput{}

// End of datatype ExecuteTransactionOutputTransformOutput

// Definition of datatype GetItemInputTransformInput
type GetItemInputTransformInput struct {
	Data_GetItemInputTransformInput_
}

func (_this GetItemInputTransformInput) Get_() Data_GetItemInputTransformInput_ {
	return _this.Data_GetItemInputTransformInput_
}

type Data_GetItemInputTransformInput_ interface {
	isGetItemInputTransformInput()
}

type CompanionStruct_GetItemInputTransformInput_ struct {
}

var Companion_GetItemInputTransformInput_ = CompanionStruct_GetItemInputTransformInput_{}

type GetItemInputTransformInput_GetItemInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.GetItemInput
}

func (GetItemInputTransformInput_GetItemInputTransformInput) isGetItemInputTransformInput() {}

func (CompanionStruct_GetItemInputTransformInput_) Create_GetItemInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.GetItemInput) GetItemInputTransformInput {
	return GetItemInputTransformInput{GetItemInputTransformInput_GetItemInputTransformInput{SdkInput}}
}

func (_this GetItemInputTransformInput) Is_GetItemInputTransformInput() bool {
	_, ok := _this.Get_().(GetItemInputTransformInput_GetItemInputTransformInput)
	return ok
}

func (CompanionStruct_GetItemInputTransformInput_) Default() GetItemInputTransformInput {
	return Companion_GetItemInputTransformInput_.Create_GetItemInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_GetItemInput_.Default())
}

func (_this GetItemInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.GetItemInput {
	return _this.Get_().(GetItemInputTransformInput_GetItemInputTransformInput).SdkInput
}

func (_this GetItemInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetItemInputTransformInput_GetItemInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemInputTransformInput.GetItemInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetItemInputTransformInput) Equals(other GetItemInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetItemInputTransformInput_GetItemInputTransformInput:
		{
			data2, ok := other.Get_().(GetItemInputTransformInput_GetItemInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetItemInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetItemInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_GetItemInputTransformInput_() _dafny.TypeDescriptor {
	return type_GetItemInputTransformInput_{}
}

type type_GetItemInputTransformInput_ struct {
}

func (_this type_GetItemInputTransformInput_) Default() interface{} {
	return Companion_GetItemInputTransformInput_.Default()
}

func (_this type_GetItemInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemInputTransformInput"
}
func (_this GetItemInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetItemInputTransformInput{}

// End of datatype GetItemInputTransformInput

// Definition of datatype GetItemInputTransformOutput
type GetItemInputTransformOutput struct {
	Data_GetItemInputTransformOutput_
}

func (_this GetItemInputTransformOutput) Get_() Data_GetItemInputTransformOutput_ {
	return _this.Data_GetItemInputTransformOutput_
}

type Data_GetItemInputTransformOutput_ interface {
	isGetItemInputTransformOutput()
}

type CompanionStruct_GetItemInputTransformOutput_ struct {
}

var Companion_GetItemInputTransformOutput_ = CompanionStruct_GetItemInputTransformOutput_{}

type GetItemInputTransformOutput_GetItemInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.GetItemInput
}

func (GetItemInputTransformOutput_GetItemInputTransformOutput) isGetItemInputTransformOutput() {}

func (CompanionStruct_GetItemInputTransformOutput_) Create_GetItemInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.GetItemInput) GetItemInputTransformOutput {
	return GetItemInputTransformOutput{GetItemInputTransformOutput_GetItemInputTransformOutput{TransformedInput}}
}

func (_this GetItemInputTransformOutput) Is_GetItemInputTransformOutput() bool {
	_, ok := _this.Get_().(GetItemInputTransformOutput_GetItemInputTransformOutput)
	return ok
}

func (CompanionStruct_GetItemInputTransformOutput_) Default() GetItemInputTransformOutput {
	return Companion_GetItemInputTransformOutput_.Create_GetItemInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_GetItemInput_.Default())
}

func (_this GetItemInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.GetItemInput {
	return _this.Get_().(GetItemInputTransformOutput_GetItemInputTransformOutput).TransformedInput
}

func (_this GetItemInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetItemInputTransformOutput_GetItemInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemInputTransformOutput.GetItemInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetItemInputTransformOutput) Equals(other GetItemInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetItemInputTransformOutput_GetItemInputTransformOutput:
		{
			data2, ok := other.Get_().(GetItemInputTransformOutput_GetItemInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetItemInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetItemInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_GetItemInputTransformOutput_() _dafny.TypeDescriptor {
	return type_GetItemInputTransformOutput_{}
}

type type_GetItemInputTransformOutput_ struct {
}

func (_this type_GetItemInputTransformOutput_) Default() interface{} {
	return Companion_GetItemInputTransformOutput_.Default()
}

func (_this type_GetItemInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemInputTransformOutput"
}
func (_this GetItemInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetItemInputTransformOutput{}

// End of datatype GetItemInputTransformOutput

// Definition of datatype GetItemOutputTransformInput
type GetItemOutputTransformInput struct {
	Data_GetItemOutputTransformInput_
}

func (_this GetItemOutputTransformInput) Get_() Data_GetItemOutputTransformInput_ {
	return _this.Data_GetItemOutputTransformInput_
}

type Data_GetItemOutputTransformInput_ interface {
	isGetItemOutputTransformInput()
}

type CompanionStruct_GetItemOutputTransformInput_ struct {
}

var Companion_GetItemOutputTransformInput_ = CompanionStruct_GetItemOutputTransformInput_{}

type GetItemOutputTransformInput_GetItemOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.GetItemOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.GetItemInput
}

func (GetItemOutputTransformInput_GetItemOutputTransformInput) isGetItemOutputTransformInput() {}

func (CompanionStruct_GetItemOutputTransformInput_) Create_GetItemOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.GetItemOutput, OriginalInput m_ComAmazonawsDynamodbTypes.GetItemInput) GetItemOutputTransformInput {
	return GetItemOutputTransformInput{GetItemOutputTransformInput_GetItemOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this GetItemOutputTransformInput) Is_GetItemOutputTransformInput() bool {
	_, ok := _this.Get_().(GetItemOutputTransformInput_GetItemOutputTransformInput)
	return ok
}

func (CompanionStruct_GetItemOutputTransformInput_) Default() GetItemOutputTransformInput {
	return Companion_GetItemOutputTransformInput_.Create_GetItemOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_GetItemOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_GetItemInput_.Default())
}

func (_this GetItemOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.GetItemOutput {
	return _this.Get_().(GetItemOutputTransformInput_GetItemOutputTransformInput).SdkOutput
}

func (_this GetItemOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.GetItemInput {
	return _this.Get_().(GetItemOutputTransformInput_GetItemOutputTransformInput).OriginalInput
}

func (_this GetItemOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetItemOutputTransformInput_GetItemOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformInput.GetItemOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetItemOutputTransformInput) Equals(other GetItemOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetItemOutputTransformInput_GetItemOutputTransformInput:
		{
			data2, ok := other.Get_().(GetItemOutputTransformInput_GetItemOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetItemOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetItemOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_GetItemOutputTransformInput_() _dafny.TypeDescriptor {
	return type_GetItemOutputTransformInput_{}
}

type type_GetItemOutputTransformInput_ struct {
}

func (_this type_GetItemOutputTransformInput_) Default() interface{} {
	return Companion_GetItemOutputTransformInput_.Default()
}

func (_this type_GetItemOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformInput"
}
func (_this GetItemOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetItemOutputTransformInput{}

// End of datatype GetItemOutputTransformInput

// Definition of datatype GetItemOutputTransformOutput
type GetItemOutputTransformOutput struct {
	Data_GetItemOutputTransformOutput_
}

func (_this GetItemOutputTransformOutput) Get_() Data_GetItemOutputTransformOutput_ {
	return _this.Data_GetItemOutputTransformOutput_
}

type Data_GetItemOutputTransformOutput_ interface {
	isGetItemOutputTransformOutput()
}

type CompanionStruct_GetItemOutputTransformOutput_ struct {
}

var Companion_GetItemOutputTransformOutput_ = CompanionStruct_GetItemOutputTransformOutput_{}

type GetItemOutputTransformOutput_GetItemOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.GetItemOutput
}

func (GetItemOutputTransformOutput_GetItemOutputTransformOutput) isGetItemOutputTransformOutput() {}

func (CompanionStruct_GetItemOutputTransformOutput_) Create_GetItemOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.GetItemOutput) GetItemOutputTransformOutput {
	return GetItemOutputTransformOutput{GetItemOutputTransformOutput_GetItemOutputTransformOutput{TransformedOutput}}
}

func (_this GetItemOutputTransformOutput) Is_GetItemOutputTransformOutput() bool {
	_, ok := _this.Get_().(GetItemOutputTransformOutput_GetItemOutputTransformOutput)
	return ok
}

func (CompanionStruct_GetItemOutputTransformOutput_) Default() GetItemOutputTransformOutput {
	return Companion_GetItemOutputTransformOutput_.Create_GetItemOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_GetItemOutput_.Default())
}

func (_this GetItemOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.GetItemOutput {
	return _this.Get_().(GetItemOutputTransformOutput_GetItemOutputTransformOutput).TransformedOutput
}

func (_this GetItemOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetItemOutputTransformOutput_GetItemOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformOutput.GetItemOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetItemOutputTransformOutput) Equals(other GetItemOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetItemOutputTransformOutput_GetItemOutputTransformOutput:
		{
			data2, ok := other.Get_().(GetItemOutputTransformOutput_GetItemOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetItemOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetItemOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_GetItemOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_GetItemOutputTransformOutput_{}
}

type type_GetItemOutputTransformOutput_ struct {
}

func (_this type_GetItemOutputTransformOutput_) Default() interface{} {
	return Companion_GetItemOutputTransformOutput_.Default()
}

func (_this type_GetItemOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformOutput"
}
func (_this GetItemOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetItemOutputTransformOutput{}

// End of datatype GetItemOutputTransformOutput

// Definition of datatype PutItemInputTransformInput
type PutItemInputTransformInput struct {
	Data_PutItemInputTransformInput_
}

func (_this PutItemInputTransformInput) Get_() Data_PutItemInputTransformInput_ {
	return _this.Data_PutItemInputTransformInput_
}

type Data_PutItemInputTransformInput_ interface {
	isPutItemInputTransformInput()
}

type CompanionStruct_PutItemInputTransformInput_ struct {
}

var Companion_PutItemInputTransformInput_ = CompanionStruct_PutItemInputTransformInput_{}

type PutItemInputTransformInput_PutItemInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.PutItemInput
}

func (PutItemInputTransformInput_PutItemInputTransformInput) isPutItemInputTransformInput() {}

func (CompanionStruct_PutItemInputTransformInput_) Create_PutItemInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.PutItemInput) PutItemInputTransformInput {
	return PutItemInputTransformInput{PutItemInputTransformInput_PutItemInputTransformInput{SdkInput}}
}

func (_this PutItemInputTransformInput) Is_PutItemInputTransformInput() bool {
	_, ok := _this.Get_().(PutItemInputTransformInput_PutItemInputTransformInput)
	return ok
}

func (CompanionStruct_PutItemInputTransformInput_) Default() PutItemInputTransformInput {
	return Companion_PutItemInputTransformInput_.Create_PutItemInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_PutItemInput_.Default())
}

func (_this PutItemInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.PutItemInput {
	return _this.Get_().(PutItemInputTransformInput_PutItemInputTransformInput).SdkInput
}

func (_this PutItemInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PutItemInputTransformInput_PutItemInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput.PutItemInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PutItemInputTransformInput) Equals(other PutItemInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case PutItemInputTransformInput_PutItemInputTransformInput:
		{
			data2, ok := other.Get_().(PutItemInputTransformInput_PutItemInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PutItemInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PutItemInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_PutItemInputTransformInput_() _dafny.TypeDescriptor {
	return type_PutItemInputTransformInput_{}
}

type type_PutItemInputTransformInput_ struct {
}

func (_this type_PutItemInputTransformInput_) Default() interface{} {
	return Companion_PutItemInputTransformInput_.Default()
}

func (_this type_PutItemInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput"
}
func (_this PutItemInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PutItemInputTransformInput{}

// End of datatype PutItemInputTransformInput

// Definition of datatype PutItemInputTransformOutput
type PutItemInputTransformOutput struct {
	Data_PutItemInputTransformOutput_
}

func (_this PutItemInputTransformOutput) Get_() Data_PutItemInputTransformOutput_ {
	return _this.Data_PutItemInputTransformOutput_
}

type Data_PutItemInputTransformOutput_ interface {
	isPutItemInputTransformOutput()
}

type CompanionStruct_PutItemInputTransformOutput_ struct {
}

var Companion_PutItemInputTransformOutput_ = CompanionStruct_PutItemInputTransformOutput_{}

type PutItemInputTransformOutput_PutItemInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.PutItemInput
}

func (PutItemInputTransformOutput_PutItemInputTransformOutput) isPutItemInputTransformOutput() {}

func (CompanionStruct_PutItemInputTransformOutput_) Create_PutItemInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.PutItemInput) PutItemInputTransformOutput {
	return PutItemInputTransformOutput{PutItemInputTransformOutput_PutItemInputTransformOutput{TransformedInput}}
}

func (_this PutItemInputTransformOutput) Is_PutItemInputTransformOutput() bool {
	_, ok := _this.Get_().(PutItemInputTransformOutput_PutItemInputTransformOutput)
	return ok
}

func (CompanionStruct_PutItemInputTransformOutput_) Default() PutItemInputTransformOutput {
	return Companion_PutItemInputTransformOutput_.Create_PutItemInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_PutItemInput_.Default())
}

func (_this PutItemInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.PutItemInput {
	return _this.Get_().(PutItemInputTransformOutput_PutItemInputTransformOutput).TransformedInput
}

func (_this PutItemInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PutItemInputTransformOutput_PutItemInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformOutput.PutItemInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PutItemInputTransformOutput) Equals(other PutItemInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case PutItemInputTransformOutput_PutItemInputTransformOutput:
		{
			data2, ok := other.Get_().(PutItemInputTransformOutput_PutItemInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PutItemInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PutItemInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_PutItemInputTransformOutput_() _dafny.TypeDescriptor {
	return type_PutItemInputTransformOutput_{}
}

type type_PutItemInputTransformOutput_ struct {
}

func (_this type_PutItemInputTransformOutput_) Default() interface{} {
	return Companion_PutItemInputTransformOutput_.Default()
}

func (_this type_PutItemInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformOutput"
}
func (_this PutItemInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PutItemInputTransformOutput{}

// End of datatype PutItemInputTransformOutput

// Definition of datatype PutItemOutputTransformInput
type PutItemOutputTransformInput struct {
	Data_PutItemOutputTransformInput_
}

func (_this PutItemOutputTransformInput) Get_() Data_PutItemOutputTransformInput_ {
	return _this.Data_PutItemOutputTransformInput_
}

type Data_PutItemOutputTransformInput_ interface {
	isPutItemOutputTransformInput()
}

type CompanionStruct_PutItemOutputTransformInput_ struct {
}

var Companion_PutItemOutputTransformInput_ = CompanionStruct_PutItemOutputTransformInput_{}

type PutItemOutputTransformInput_PutItemOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.PutItemOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.PutItemInput
}

func (PutItemOutputTransformInput_PutItemOutputTransformInput) isPutItemOutputTransformInput() {}

func (CompanionStruct_PutItemOutputTransformInput_) Create_PutItemOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.PutItemOutput, OriginalInput m_ComAmazonawsDynamodbTypes.PutItemInput) PutItemOutputTransformInput {
	return PutItemOutputTransformInput{PutItemOutputTransformInput_PutItemOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this PutItemOutputTransformInput) Is_PutItemOutputTransformInput() bool {
	_, ok := _this.Get_().(PutItemOutputTransformInput_PutItemOutputTransformInput)
	return ok
}

func (CompanionStruct_PutItemOutputTransformInput_) Default() PutItemOutputTransformInput {
	return Companion_PutItemOutputTransformInput_.Create_PutItemOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_PutItemOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_PutItemInput_.Default())
}

func (_this PutItemOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.PutItemOutput {
	return _this.Get_().(PutItemOutputTransformInput_PutItemOutputTransformInput).SdkOutput
}

func (_this PutItemOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.PutItemInput {
	return _this.Get_().(PutItemOutputTransformInput_PutItemOutputTransformInput).OriginalInput
}

func (_this PutItemOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PutItemOutputTransformInput_PutItemOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemOutputTransformInput.PutItemOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PutItemOutputTransformInput) Equals(other PutItemOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case PutItemOutputTransformInput_PutItemOutputTransformInput:
		{
			data2, ok := other.Get_().(PutItemOutputTransformInput_PutItemOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PutItemOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PutItemOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_PutItemOutputTransformInput_() _dafny.TypeDescriptor {
	return type_PutItemOutputTransformInput_{}
}

type type_PutItemOutputTransformInput_ struct {
}

func (_this type_PutItemOutputTransformInput_) Default() interface{} {
	return Companion_PutItemOutputTransformInput_.Default()
}

func (_this type_PutItemOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemOutputTransformInput"
}
func (_this PutItemOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PutItemOutputTransformInput{}

// End of datatype PutItemOutputTransformInput

// Definition of datatype PutItemOutputTransformOutput
type PutItemOutputTransformOutput struct {
	Data_PutItemOutputTransformOutput_
}

func (_this PutItemOutputTransformOutput) Get_() Data_PutItemOutputTransformOutput_ {
	return _this.Data_PutItemOutputTransformOutput_
}

type Data_PutItemOutputTransformOutput_ interface {
	isPutItemOutputTransformOutput()
}

type CompanionStruct_PutItemOutputTransformOutput_ struct {
}

var Companion_PutItemOutputTransformOutput_ = CompanionStruct_PutItemOutputTransformOutput_{}

type PutItemOutputTransformOutput_PutItemOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.PutItemOutput
}

func (PutItemOutputTransformOutput_PutItemOutputTransformOutput) isPutItemOutputTransformOutput() {}

func (CompanionStruct_PutItemOutputTransformOutput_) Create_PutItemOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.PutItemOutput) PutItemOutputTransformOutput {
	return PutItemOutputTransformOutput{PutItemOutputTransformOutput_PutItemOutputTransformOutput{TransformedOutput}}
}

func (_this PutItemOutputTransformOutput) Is_PutItemOutputTransformOutput() bool {
	_, ok := _this.Get_().(PutItemOutputTransformOutput_PutItemOutputTransformOutput)
	return ok
}

func (CompanionStruct_PutItemOutputTransformOutput_) Default() PutItemOutputTransformOutput {
	return Companion_PutItemOutputTransformOutput_.Create_PutItemOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_PutItemOutput_.Default())
}

func (_this PutItemOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.PutItemOutput {
	return _this.Get_().(PutItemOutputTransformOutput_PutItemOutputTransformOutput).TransformedOutput
}

func (_this PutItemOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PutItemOutputTransformOutput_PutItemOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemOutputTransformOutput.PutItemOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PutItemOutputTransformOutput) Equals(other PutItemOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case PutItemOutputTransformOutput_PutItemOutputTransformOutput:
		{
			data2, ok := other.Get_().(PutItemOutputTransformOutput_PutItemOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PutItemOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PutItemOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_PutItemOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_PutItemOutputTransformOutput_{}
}

type type_PutItemOutputTransformOutput_ struct {
}

func (_this type_PutItemOutputTransformOutput_) Default() interface{} {
	return Companion_PutItemOutputTransformOutput_.Default()
}

func (_this type_PutItemOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemOutputTransformOutput"
}
func (_this PutItemOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PutItemOutputTransformOutput{}

// End of datatype PutItemOutputTransformOutput

// Definition of datatype QueryInputTransformInput
type QueryInputTransformInput struct {
	Data_QueryInputTransformInput_
}

func (_this QueryInputTransformInput) Get_() Data_QueryInputTransformInput_ {
	return _this.Data_QueryInputTransformInput_
}

type Data_QueryInputTransformInput_ interface {
	isQueryInputTransformInput()
}

type CompanionStruct_QueryInputTransformInput_ struct {
}

var Companion_QueryInputTransformInput_ = CompanionStruct_QueryInputTransformInput_{}

type QueryInputTransformInput_QueryInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.QueryInput
}

func (QueryInputTransformInput_QueryInputTransformInput) isQueryInputTransformInput() {}

func (CompanionStruct_QueryInputTransformInput_) Create_QueryInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.QueryInput) QueryInputTransformInput {
	return QueryInputTransformInput{QueryInputTransformInput_QueryInputTransformInput{SdkInput}}
}

func (_this QueryInputTransformInput) Is_QueryInputTransformInput() bool {
	_, ok := _this.Get_().(QueryInputTransformInput_QueryInputTransformInput)
	return ok
}

func (CompanionStruct_QueryInputTransformInput_) Default() QueryInputTransformInput {
	return Companion_QueryInputTransformInput_.Create_QueryInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_QueryInput_.Default())
}

func (_this QueryInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.QueryInput {
	return _this.Get_().(QueryInputTransformInput_QueryInputTransformInput).SdkInput
}

func (_this QueryInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case QueryInputTransformInput_QueryInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryInputTransformInput.QueryInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this QueryInputTransformInput) Equals(other QueryInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case QueryInputTransformInput_QueryInputTransformInput:
		{
			data2, ok := other.Get_().(QueryInputTransformInput_QueryInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this QueryInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(QueryInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_QueryInputTransformInput_() _dafny.TypeDescriptor {
	return type_QueryInputTransformInput_{}
}

type type_QueryInputTransformInput_ struct {
}

func (_this type_QueryInputTransformInput_) Default() interface{} {
	return Companion_QueryInputTransformInput_.Default()
}

func (_this type_QueryInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryInputTransformInput"
}
func (_this QueryInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = QueryInputTransformInput{}

// End of datatype QueryInputTransformInput

// Definition of datatype QueryInputTransformOutput
type QueryInputTransformOutput struct {
	Data_QueryInputTransformOutput_
}

func (_this QueryInputTransformOutput) Get_() Data_QueryInputTransformOutput_ {
	return _this.Data_QueryInputTransformOutput_
}

type Data_QueryInputTransformOutput_ interface {
	isQueryInputTransformOutput()
}

type CompanionStruct_QueryInputTransformOutput_ struct {
}

var Companion_QueryInputTransformOutput_ = CompanionStruct_QueryInputTransformOutput_{}

type QueryInputTransformOutput_QueryInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.QueryInput
}

func (QueryInputTransformOutput_QueryInputTransformOutput) isQueryInputTransformOutput() {}

func (CompanionStruct_QueryInputTransformOutput_) Create_QueryInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.QueryInput) QueryInputTransformOutput {
	return QueryInputTransformOutput{QueryInputTransformOutput_QueryInputTransformOutput{TransformedInput}}
}

func (_this QueryInputTransformOutput) Is_QueryInputTransformOutput() bool {
	_, ok := _this.Get_().(QueryInputTransformOutput_QueryInputTransformOutput)
	return ok
}

func (CompanionStruct_QueryInputTransformOutput_) Default() QueryInputTransformOutput {
	return Companion_QueryInputTransformOutput_.Create_QueryInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_QueryInput_.Default())
}

func (_this QueryInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.QueryInput {
	return _this.Get_().(QueryInputTransformOutput_QueryInputTransformOutput).TransformedInput
}

func (_this QueryInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case QueryInputTransformOutput_QueryInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryInputTransformOutput.QueryInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this QueryInputTransformOutput) Equals(other QueryInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case QueryInputTransformOutput_QueryInputTransformOutput:
		{
			data2, ok := other.Get_().(QueryInputTransformOutput_QueryInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this QueryInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(QueryInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_QueryInputTransformOutput_() _dafny.TypeDescriptor {
	return type_QueryInputTransformOutput_{}
}

type type_QueryInputTransformOutput_ struct {
}

func (_this type_QueryInputTransformOutput_) Default() interface{} {
	return Companion_QueryInputTransformOutput_.Default()
}

func (_this type_QueryInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryInputTransformOutput"
}
func (_this QueryInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = QueryInputTransformOutput{}

// End of datatype QueryInputTransformOutput

// Definition of datatype QueryOutputTransformInput
type QueryOutputTransformInput struct {
	Data_QueryOutputTransformInput_
}

func (_this QueryOutputTransformInput) Get_() Data_QueryOutputTransformInput_ {
	return _this.Data_QueryOutputTransformInput_
}

type Data_QueryOutputTransformInput_ interface {
	isQueryOutputTransformInput()
}

type CompanionStruct_QueryOutputTransformInput_ struct {
}

var Companion_QueryOutputTransformInput_ = CompanionStruct_QueryOutputTransformInput_{}

type QueryOutputTransformInput_QueryOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.QueryOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.QueryInput
}

func (QueryOutputTransformInput_QueryOutputTransformInput) isQueryOutputTransformInput() {}

func (CompanionStruct_QueryOutputTransformInput_) Create_QueryOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.QueryOutput, OriginalInput m_ComAmazonawsDynamodbTypes.QueryInput) QueryOutputTransformInput {
	return QueryOutputTransformInput{QueryOutputTransformInput_QueryOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this QueryOutputTransformInput) Is_QueryOutputTransformInput() bool {
	_, ok := _this.Get_().(QueryOutputTransformInput_QueryOutputTransformInput)
	return ok
}

func (CompanionStruct_QueryOutputTransformInput_) Default() QueryOutputTransformInput {
	return Companion_QueryOutputTransformInput_.Create_QueryOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_QueryOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_QueryInput_.Default())
}

func (_this QueryOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.QueryOutput {
	return _this.Get_().(QueryOutputTransformInput_QueryOutputTransformInput).SdkOutput
}

func (_this QueryOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.QueryInput {
	return _this.Get_().(QueryOutputTransformInput_QueryOutputTransformInput).OriginalInput
}

func (_this QueryOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case QueryOutputTransformInput_QueryOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformInput.QueryOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this QueryOutputTransformInput) Equals(other QueryOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case QueryOutputTransformInput_QueryOutputTransformInput:
		{
			data2, ok := other.Get_().(QueryOutputTransformInput_QueryOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this QueryOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(QueryOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_QueryOutputTransformInput_() _dafny.TypeDescriptor {
	return type_QueryOutputTransformInput_{}
}

type type_QueryOutputTransformInput_ struct {
}

func (_this type_QueryOutputTransformInput_) Default() interface{} {
	return Companion_QueryOutputTransformInput_.Default()
}

func (_this type_QueryOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformInput"
}
func (_this QueryOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = QueryOutputTransformInput{}

// End of datatype QueryOutputTransformInput

// Definition of datatype QueryOutputTransformOutput
type QueryOutputTransformOutput struct {
	Data_QueryOutputTransformOutput_
}

func (_this QueryOutputTransformOutput) Get_() Data_QueryOutputTransformOutput_ {
	return _this.Data_QueryOutputTransformOutput_
}

type Data_QueryOutputTransformOutput_ interface {
	isQueryOutputTransformOutput()
}

type CompanionStruct_QueryOutputTransformOutput_ struct {
}

var Companion_QueryOutputTransformOutput_ = CompanionStruct_QueryOutputTransformOutput_{}

type QueryOutputTransformOutput_QueryOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.QueryOutput
}

func (QueryOutputTransformOutput_QueryOutputTransformOutput) isQueryOutputTransformOutput() {}

func (CompanionStruct_QueryOutputTransformOutput_) Create_QueryOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.QueryOutput) QueryOutputTransformOutput {
	return QueryOutputTransformOutput{QueryOutputTransformOutput_QueryOutputTransformOutput{TransformedOutput}}
}

func (_this QueryOutputTransformOutput) Is_QueryOutputTransformOutput() bool {
	_, ok := _this.Get_().(QueryOutputTransformOutput_QueryOutputTransformOutput)
	return ok
}

func (CompanionStruct_QueryOutputTransformOutput_) Default() QueryOutputTransformOutput {
	return Companion_QueryOutputTransformOutput_.Create_QueryOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_QueryOutput_.Default())
}

func (_this QueryOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.QueryOutput {
	return _this.Get_().(QueryOutputTransformOutput_QueryOutputTransformOutput).TransformedOutput
}

func (_this QueryOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case QueryOutputTransformOutput_QueryOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformOutput.QueryOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this QueryOutputTransformOutput) Equals(other QueryOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case QueryOutputTransformOutput_QueryOutputTransformOutput:
		{
			data2, ok := other.Get_().(QueryOutputTransformOutput_QueryOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this QueryOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(QueryOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_QueryOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_QueryOutputTransformOutput_{}
}

type type_QueryOutputTransformOutput_ struct {
}

func (_this type_QueryOutputTransformOutput_) Default() interface{} {
	return Companion_QueryOutputTransformOutput_.Default()
}

func (_this type_QueryOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformOutput"
}
func (_this QueryOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = QueryOutputTransformOutput{}

// End of datatype QueryOutputTransformOutput

// Definition of datatype ResolveAttributesInput
type ResolveAttributesInput struct {
	Data_ResolveAttributesInput_
}

func (_this ResolveAttributesInput) Get_() Data_ResolveAttributesInput_ {
	return _this.Data_ResolveAttributesInput_
}

type Data_ResolveAttributesInput_ interface {
	isResolveAttributesInput()
}

type CompanionStruct_ResolveAttributesInput_ struct {
}

var Companion_ResolveAttributesInput_ = CompanionStruct_ResolveAttributesInput_{}

type ResolveAttributesInput_ResolveAttributesInput struct {
	TableName _dafny.Sequence
	Item      _dafny.Map
	Version   m_Wrappers.Option
}

func (ResolveAttributesInput_ResolveAttributesInput) isResolveAttributesInput() {}

func (CompanionStruct_ResolveAttributesInput_) Create_ResolveAttributesInput_(TableName _dafny.Sequence, Item _dafny.Map, Version m_Wrappers.Option) ResolveAttributesInput {
	return ResolveAttributesInput{ResolveAttributesInput_ResolveAttributesInput{TableName, Item, Version}}
}

func (_this ResolveAttributesInput) Is_ResolveAttributesInput() bool {
	_, ok := _this.Get_().(ResolveAttributesInput_ResolveAttributesInput)
	return ok
}

func (CompanionStruct_ResolveAttributesInput_) Default() ResolveAttributesInput {
	return Companion_ResolveAttributesInput_.Create_ResolveAttributesInput_(_dafny.EmptySeq.SetString(), _dafny.EmptyMap, m_Wrappers.Companion_Option_.Default())
}

func (_this ResolveAttributesInput) Dtor_TableName() _dafny.Sequence {
	return _this.Get_().(ResolveAttributesInput_ResolveAttributesInput).TableName
}

func (_this ResolveAttributesInput) Dtor_Item() _dafny.Map {
	return _this.Get_().(ResolveAttributesInput_ResolveAttributesInput).Item
}

func (_this ResolveAttributesInput) Dtor_Version() m_Wrappers.Option {
	return _this.Get_().(ResolveAttributesInput_ResolveAttributesInput).Version
}

func (_this ResolveAttributesInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ResolveAttributesInput_ResolveAttributesInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ResolveAttributesInput.ResolveAttributesInput" + "(" + _dafny.String(data.TableName) + ", " + _dafny.String(data.Item) + ", " + _dafny.String(data.Version) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ResolveAttributesInput) Equals(other ResolveAttributesInput) bool {
	switch data1 := _this.Get_().(type) {
	case ResolveAttributesInput_ResolveAttributesInput:
		{
			data2, ok := other.Get_().(ResolveAttributesInput_ResolveAttributesInput)
			return ok && data1.TableName.Equals(data2.TableName) && data1.Item.Equals(data2.Item) && data1.Version.Equals(data2.Version)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ResolveAttributesInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ResolveAttributesInput)
	return ok && _this.Equals(typed)
}

func Type_ResolveAttributesInput_() _dafny.TypeDescriptor {
	return type_ResolveAttributesInput_{}
}

type type_ResolveAttributesInput_ struct {
}

func (_this type_ResolveAttributesInput_) Default() interface{} {
	return Companion_ResolveAttributesInput_.Default()
}

func (_this type_ResolveAttributesInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ResolveAttributesInput"
}
func (_this ResolveAttributesInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ResolveAttributesInput{}

// End of datatype ResolveAttributesInput

// Definition of datatype ResolveAttributesOutput
type ResolveAttributesOutput struct {
	Data_ResolveAttributesOutput_
}

func (_this ResolveAttributesOutput) Get_() Data_ResolveAttributesOutput_ {
	return _this.Data_ResolveAttributesOutput_
}

type Data_ResolveAttributesOutput_ interface {
	isResolveAttributesOutput()
}

type CompanionStruct_ResolveAttributesOutput_ struct {
}

var Companion_ResolveAttributesOutput_ = CompanionStruct_ResolveAttributesOutput_{}

type ResolveAttributesOutput_ResolveAttributesOutput struct {
	VirtualFields   _dafny.Map
	CompoundBeacons _dafny.Map
}

func (ResolveAttributesOutput_ResolveAttributesOutput) isResolveAttributesOutput() {}

func (CompanionStruct_ResolveAttributesOutput_) Create_ResolveAttributesOutput_(VirtualFields _dafny.Map, CompoundBeacons _dafny.Map) ResolveAttributesOutput {
	return ResolveAttributesOutput{ResolveAttributesOutput_ResolveAttributesOutput{VirtualFields, CompoundBeacons}}
}

func (_this ResolveAttributesOutput) Is_ResolveAttributesOutput() bool {
	_, ok := _this.Get_().(ResolveAttributesOutput_ResolveAttributesOutput)
	return ok
}

func (CompanionStruct_ResolveAttributesOutput_) Default() ResolveAttributesOutput {
	return Companion_ResolveAttributesOutput_.Create_ResolveAttributesOutput_(_dafny.EmptyMap, _dafny.EmptyMap)
}

func (_this ResolveAttributesOutput) Dtor_VirtualFields() _dafny.Map {
	return _this.Get_().(ResolveAttributesOutput_ResolveAttributesOutput).VirtualFields
}

func (_this ResolveAttributesOutput) Dtor_CompoundBeacons() _dafny.Map {
	return _this.Get_().(ResolveAttributesOutput_ResolveAttributesOutput).CompoundBeacons
}

func (_this ResolveAttributesOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ResolveAttributesOutput_ResolveAttributesOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ResolveAttributesOutput.ResolveAttributesOutput" + "(" + _dafny.String(data.VirtualFields) + ", " + _dafny.String(data.CompoundBeacons) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ResolveAttributesOutput) Equals(other ResolveAttributesOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ResolveAttributesOutput_ResolveAttributesOutput:
		{
			data2, ok := other.Get_().(ResolveAttributesOutput_ResolveAttributesOutput)
			return ok && data1.VirtualFields.Equals(data2.VirtualFields) && data1.CompoundBeacons.Equals(data2.CompoundBeacons)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ResolveAttributesOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ResolveAttributesOutput)
	return ok && _this.Equals(typed)
}

func Type_ResolveAttributesOutput_() _dafny.TypeDescriptor {
	return type_ResolveAttributesOutput_{}
}

type type_ResolveAttributesOutput_ struct {
}

func (_this type_ResolveAttributesOutput_) Default() interface{} {
	return Companion_ResolveAttributesOutput_.Default()
}

func (_this type_ResolveAttributesOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ResolveAttributesOutput"
}
func (_this ResolveAttributesOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ResolveAttributesOutput{}

// End of datatype ResolveAttributesOutput

// Definition of datatype ScanInputTransformInput
type ScanInputTransformInput struct {
	Data_ScanInputTransformInput_
}

func (_this ScanInputTransformInput) Get_() Data_ScanInputTransformInput_ {
	return _this.Data_ScanInputTransformInput_
}

type Data_ScanInputTransformInput_ interface {
	isScanInputTransformInput()
}

type CompanionStruct_ScanInputTransformInput_ struct {
}

var Companion_ScanInputTransformInput_ = CompanionStruct_ScanInputTransformInput_{}

type ScanInputTransformInput_ScanInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.ScanInput
}

func (ScanInputTransformInput_ScanInputTransformInput) isScanInputTransformInput() {}

func (CompanionStruct_ScanInputTransformInput_) Create_ScanInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.ScanInput) ScanInputTransformInput {
	return ScanInputTransformInput{ScanInputTransformInput_ScanInputTransformInput{SdkInput}}
}

func (_this ScanInputTransformInput) Is_ScanInputTransformInput() bool {
	_, ok := _this.Get_().(ScanInputTransformInput_ScanInputTransformInput)
	return ok
}

func (CompanionStruct_ScanInputTransformInput_) Default() ScanInputTransformInput {
	return Companion_ScanInputTransformInput_.Create_ScanInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_ScanInput_.Default())
}

func (_this ScanInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.ScanInput {
	return _this.Get_().(ScanInputTransformInput_ScanInputTransformInput).SdkInput
}

func (_this ScanInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ScanInputTransformInput_ScanInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanInputTransformInput.ScanInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ScanInputTransformInput) Equals(other ScanInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case ScanInputTransformInput_ScanInputTransformInput:
		{
			data2, ok := other.Get_().(ScanInputTransformInput_ScanInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ScanInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ScanInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_ScanInputTransformInput_() _dafny.TypeDescriptor {
	return type_ScanInputTransformInput_{}
}

type type_ScanInputTransformInput_ struct {
}

func (_this type_ScanInputTransformInput_) Default() interface{} {
	return Companion_ScanInputTransformInput_.Default()
}

func (_this type_ScanInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanInputTransformInput"
}
func (_this ScanInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ScanInputTransformInput{}

// End of datatype ScanInputTransformInput

// Definition of datatype ScanInputTransformOutput
type ScanInputTransformOutput struct {
	Data_ScanInputTransformOutput_
}

func (_this ScanInputTransformOutput) Get_() Data_ScanInputTransformOutput_ {
	return _this.Data_ScanInputTransformOutput_
}

type Data_ScanInputTransformOutput_ interface {
	isScanInputTransformOutput()
}

type CompanionStruct_ScanInputTransformOutput_ struct {
}

var Companion_ScanInputTransformOutput_ = CompanionStruct_ScanInputTransformOutput_{}

type ScanInputTransformOutput_ScanInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.ScanInput
}

func (ScanInputTransformOutput_ScanInputTransformOutput) isScanInputTransformOutput() {}

func (CompanionStruct_ScanInputTransformOutput_) Create_ScanInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.ScanInput) ScanInputTransformOutput {
	return ScanInputTransformOutput{ScanInputTransformOutput_ScanInputTransformOutput{TransformedInput}}
}

func (_this ScanInputTransformOutput) Is_ScanInputTransformOutput() bool {
	_, ok := _this.Get_().(ScanInputTransformOutput_ScanInputTransformOutput)
	return ok
}

func (CompanionStruct_ScanInputTransformOutput_) Default() ScanInputTransformOutput {
	return Companion_ScanInputTransformOutput_.Create_ScanInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_ScanInput_.Default())
}

func (_this ScanInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.ScanInput {
	return _this.Get_().(ScanInputTransformOutput_ScanInputTransformOutput).TransformedInput
}

func (_this ScanInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ScanInputTransformOutput_ScanInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanInputTransformOutput.ScanInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ScanInputTransformOutput) Equals(other ScanInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ScanInputTransformOutput_ScanInputTransformOutput:
		{
			data2, ok := other.Get_().(ScanInputTransformOutput_ScanInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ScanInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ScanInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_ScanInputTransformOutput_() _dafny.TypeDescriptor {
	return type_ScanInputTransformOutput_{}
}

type type_ScanInputTransformOutput_ struct {
}

func (_this type_ScanInputTransformOutput_) Default() interface{} {
	return Companion_ScanInputTransformOutput_.Default()
}

func (_this type_ScanInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanInputTransformOutput"
}
func (_this ScanInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ScanInputTransformOutput{}

// End of datatype ScanInputTransformOutput

// Definition of datatype ScanOutputTransformInput
type ScanOutputTransformInput struct {
	Data_ScanOutputTransformInput_
}

func (_this ScanOutputTransformInput) Get_() Data_ScanOutputTransformInput_ {
	return _this.Data_ScanOutputTransformInput_
}

type Data_ScanOutputTransformInput_ interface {
	isScanOutputTransformInput()
}

type CompanionStruct_ScanOutputTransformInput_ struct {
}

var Companion_ScanOutputTransformInput_ = CompanionStruct_ScanOutputTransformInput_{}

type ScanOutputTransformInput_ScanOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.ScanOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.ScanInput
}

func (ScanOutputTransformInput_ScanOutputTransformInput) isScanOutputTransformInput() {}

func (CompanionStruct_ScanOutputTransformInput_) Create_ScanOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.ScanOutput, OriginalInput m_ComAmazonawsDynamodbTypes.ScanInput) ScanOutputTransformInput {
	return ScanOutputTransformInput{ScanOutputTransformInput_ScanOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this ScanOutputTransformInput) Is_ScanOutputTransformInput() bool {
	_, ok := _this.Get_().(ScanOutputTransformInput_ScanOutputTransformInput)
	return ok
}

func (CompanionStruct_ScanOutputTransformInput_) Default() ScanOutputTransformInput {
	return Companion_ScanOutputTransformInput_.Create_ScanOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_ScanOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_ScanInput_.Default())
}

func (_this ScanOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.ScanOutput {
	return _this.Get_().(ScanOutputTransformInput_ScanOutputTransformInput).SdkOutput
}

func (_this ScanOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.ScanInput {
	return _this.Get_().(ScanOutputTransformInput_ScanOutputTransformInput).OriginalInput
}

func (_this ScanOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ScanOutputTransformInput_ScanOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanOutputTransformInput.ScanOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ScanOutputTransformInput) Equals(other ScanOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case ScanOutputTransformInput_ScanOutputTransformInput:
		{
			data2, ok := other.Get_().(ScanOutputTransformInput_ScanOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ScanOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ScanOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_ScanOutputTransformInput_() _dafny.TypeDescriptor {
	return type_ScanOutputTransformInput_{}
}

type type_ScanOutputTransformInput_ struct {
}

func (_this type_ScanOutputTransformInput_) Default() interface{} {
	return Companion_ScanOutputTransformInput_.Default()
}

func (_this type_ScanOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanOutputTransformInput"
}
func (_this ScanOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ScanOutputTransformInput{}

// End of datatype ScanOutputTransformInput

// Definition of datatype ScanOutputTransformOutput
type ScanOutputTransformOutput struct {
	Data_ScanOutputTransformOutput_
}

func (_this ScanOutputTransformOutput) Get_() Data_ScanOutputTransformOutput_ {
	return _this.Data_ScanOutputTransformOutput_
}

type Data_ScanOutputTransformOutput_ interface {
	isScanOutputTransformOutput()
}

type CompanionStruct_ScanOutputTransformOutput_ struct {
}

var Companion_ScanOutputTransformOutput_ = CompanionStruct_ScanOutputTransformOutput_{}

type ScanOutputTransformOutput_ScanOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.ScanOutput
}

func (ScanOutputTransformOutput_ScanOutputTransformOutput) isScanOutputTransformOutput() {}

func (CompanionStruct_ScanOutputTransformOutput_) Create_ScanOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.ScanOutput) ScanOutputTransformOutput {
	return ScanOutputTransformOutput{ScanOutputTransformOutput_ScanOutputTransformOutput{TransformedOutput}}
}

func (_this ScanOutputTransformOutput) Is_ScanOutputTransformOutput() bool {
	_, ok := _this.Get_().(ScanOutputTransformOutput_ScanOutputTransformOutput)
	return ok
}

func (CompanionStruct_ScanOutputTransformOutput_) Default() ScanOutputTransformOutput {
	return Companion_ScanOutputTransformOutput_.Create_ScanOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_ScanOutput_.Default())
}

func (_this ScanOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.ScanOutput {
	return _this.Get_().(ScanOutputTransformOutput_ScanOutputTransformOutput).TransformedOutput
}

func (_this ScanOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ScanOutputTransformOutput_ScanOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanOutputTransformOutput.ScanOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ScanOutputTransformOutput) Equals(other ScanOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ScanOutputTransformOutput_ScanOutputTransformOutput:
		{
			data2, ok := other.Get_().(ScanOutputTransformOutput_ScanOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ScanOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ScanOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_ScanOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_ScanOutputTransformOutput_{}
}

type type_ScanOutputTransformOutput_ struct {
}

func (_this type_ScanOutputTransformOutput_) Default() interface{} {
	return Companion_ScanOutputTransformOutput_.Default()
}

func (_this type_ScanOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanOutputTransformOutput"
}
func (_this ScanOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ScanOutputTransformOutput{}

// End of datatype ScanOutputTransformOutput

// Definition of datatype TransactGetItemsInputTransformInput
type TransactGetItemsInputTransformInput struct {
	Data_TransactGetItemsInputTransformInput_
}

func (_this TransactGetItemsInputTransformInput) Get_() Data_TransactGetItemsInputTransformInput_ {
	return _this.Data_TransactGetItemsInputTransformInput_
}

type Data_TransactGetItemsInputTransformInput_ interface {
	isTransactGetItemsInputTransformInput()
}

type CompanionStruct_TransactGetItemsInputTransformInput_ struct {
}

var Companion_TransactGetItemsInputTransformInput_ = CompanionStruct_TransactGetItemsInputTransformInput_{}

type TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.TransactGetItemsInput
}

func (TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput) isTransactGetItemsInputTransformInput() {
}

func (CompanionStruct_TransactGetItemsInputTransformInput_) Create_TransactGetItemsInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.TransactGetItemsInput) TransactGetItemsInputTransformInput {
	return TransactGetItemsInputTransformInput{TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput{SdkInput}}
}

func (_this TransactGetItemsInputTransformInput) Is_TransactGetItemsInputTransformInput() bool {
	_, ok := _this.Get_().(TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput)
	return ok
}

func (CompanionStruct_TransactGetItemsInputTransformInput_) Default() TransactGetItemsInputTransformInput {
	return Companion_TransactGetItemsInputTransformInput_.Create_TransactGetItemsInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_TransactGetItemsInput_.Default())
}

func (_this TransactGetItemsInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.TransactGetItemsInput {
	return _this.Get_().(TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput).SdkInput
}

func (_this TransactGetItemsInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsInputTransformInput.TransactGetItemsInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TransactGetItemsInputTransformInput) Equals(other TransactGetItemsInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput:
		{
			data2, ok := other.Get_().(TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TransactGetItemsInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TransactGetItemsInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_TransactGetItemsInputTransformInput_() _dafny.TypeDescriptor {
	return type_TransactGetItemsInputTransformInput_{}
}

type type_TransactGetItemsInputTransformInput_ struct {
}

func (_this type_TransactGetItemsInputTransformInput_) Default() interface{} {
	return Companion_TransactGetItemsInputTransformInput_.Default()
}

func (_this type_TransactGetItemsInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsInputTransformInput"
}
func (_this TransactGetItemsInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TransactGetItemsInputTransformInput{}

// End of datatype TransactGetItemsInputTransformInput

// Definition of datatype TransactGetItemsInputTransformOutput
type TransactGetItemsInputTransformOutput struct {
	Data_TransactGetItemsInputTransformOutput_
}

func (_this TransactGetItemsInputTransformOutput) Get_() Data_TransactGetItemsInputTransformOutput_ {
	return _this.Data_TransactGetItemsInputTransformOutput_
}

type Data_TransactGetItemsInputTransformOutput_ interface {
	isTransactGetItemsInputTransformOutput()
}

type CompanionStruct_TransactGetItemsInputTransformOutput_ struct {
}

var Companion_TransactGetItemsInputTransformOutput_ = CompanionStruct_TransactGetItemsInputTransformOutput_{}

type TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.TransactGetItemsInput
}

func (TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput) isTransactGetItemsInputTransformOutput() {
}

func (CompanionStruct_TransactGetItemsInputTransformOutput_) Create_TransactGetItemsInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.TransactGetItemsInput) TransactGetItemsInputTransformOutput {
	return TransactGetItemsInputTransformOutput{TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput{TransformedInput}}
}

func (_this TransactGetItemsInputTransformOutput) Is_TransactGetItemsInputTransformOutput() bool {
	_, ok := _this.Get_().(TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput)
	return ok
}

func (CompanionStruct_TransactGetItemsInputTransformOutput_) Default() TransactGetItemsInputTransformOutput {
	return Companion_TransactGetItemsInputTransformOutput_.Create_TransactGetItemsInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_TransactGetItemsInput_.Default())
}

func (_this TransactGetItemsInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.TransactGetItemsInput {
	return _this.Get_().(TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput).TransformedInput
}

func (_this TransactGetItemsInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsInputTransformOutput.TransactGetItemsInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TransactGetItemsInputTransformOutput) Equals(other TransactGetItemsInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput:
		{
			data2, ok := other.Get_().(TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TransactGetItemsInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TransactGetItemsInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_TransactGetItemsInputTransformOutput_() _dafny.TypeDescriptor {
	return type_TransactGetItemsInputTransformOutput_{}
}

type type_TransactGetItemsInputTransformOutput_ struct {
}

func (_this type_TransactGetItemsInputTransformOutput_) Default() interface{} {
	return Companion_TransactGetItemsInputTransformOutput_.Default()
}

func (_this type_TransactGetItemsInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsInputTransformOutput"
}
func (_this TransactGetItemsInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TransactGetItemsInputTransformOutput{}

// End of datatype TransactGetItemsInputTransformOutput

// Definition of datatype TransactGetItemsOutputTransformInput
type TransactGetItemsOutputTransformInput struct {
	Data_TransactGetItemsOutputTransformInput_
}

func (_this TransactGetItemsOutputTransformInput) Get_() Data_TransactGetItemsOutputTransformInput_ {
	return _this.Data_TransactGetItemsOutputTransformInput_
}

type Data_TransactGetItemsOutputTransformInput_ interface {
	isTransactGetItemsOutputTransformInput()
}

type CompanionStruct_TransactGetItemsOutputTransformInput_ struct {
}

var Companion_TransactGetItemsOutputTransformInput_ = CompanionStruct_TransactGetItemsOutputTransformInput_{}

type TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.TransactGetItemsOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.TransactGetItemsInput
}

func (TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput) isTransactGetItemsOutputTransformInput() {
}

func (CompanionStruct_TransactGetItemsOutputTransformInput_) Create_TransactGetItemsOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.TransactGetItemsOutput, OriginalInput m_ComAmazonawsDynamodbTypes.TransactGetItemsInput) TransactGetItemsOutputTransformInput {
	return TransactGetItemsOutputTransformInput{TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this TransactGetItemsOutputTransformInput) Is_TransactGetItemsOutputTransformInput() bool {
	_, ok := _this.Get_().(TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput)
	return ok
}

func (CompanionStruct_TransactGetItemsOutputTransformInput_) Default() TransactGetItemsOutputTransformInput {
	return Companion_TransactGetItemsOutputTransformInput_.Create_TransactGetItemsOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_TransactGetItemsOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_TransactGetItemsInput_.Default())
}

func (_this TransactGetItemsOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.TransactGetItemsOutput {
	return _this.Get_().(TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput).SdkOutput
}

func (_this TransactGetItemsOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.TransactGetItemsInput {
	return _this.Get_().(TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput).OriginalInput
}

func (_this TransactGetItemsOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsOutputTransformInput.TransactGetItemsOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TransactGetItemsOutputTransformInput) Equals(other TransactGetItemsOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput:
		{
			data2, ok := other.Get_().(TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TransactGetItemsOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TransactGetItemsOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_TransactGetItemsOutputTransformInput_() _dafny.TypeDescriptor {
	return type_TransactGetItemsOutputTransformInput_{}
}

type type_TransactGetItemsOutputTransformInput_ struct {
}

func (_this type_TransactGetItemsOutputTransformInput_) Default() interface{} {
	return Companion_TransactGetItemsOutputTransformInput_.Default()
}

func (_this type_TransactGetItemsOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsOutputTransformInput"
}
func (_this TransactGetItemsOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TransactGetItemsOutputTransformInput{}

// End of datatype TransactGetItemsOutputTransformInput

// Definition of datatype TransactGetItemsOutputTransformOutput
type TransactGetItemsOutputTransformOutput struct {
	Data_TransactGetItemsOutputTransformOutput_
}

func (_this TransactGetItemsOutputTransformOutput) Get_() Data_TransactGetItemsOutputTransformOutput_ {
	return _this.Data_TransactGetItemsOutputTransformOutput_
}

type Data_TransactGetItemsOutputTransformOutput_ interface {
	isTransactGetItemsOutputTransformOutput()
}

type CompanionStruct_TransactGetItemsOutputTransformOutput_ struct {
}

var Companion_TransactGetItemsOutputTransformOutput_ = CompanionStruct_TransactGetItemsOutputTransformOutput_{}

type TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.TransactGetItemsOutput
}

func (TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput) isTransactGetItemsOutputTransformOutput() {
}

func (CompanionStruct_TransactGetItemsOutputTransformOutput_) Create_TransactGetItemsOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.TransactGetItemsOutput) TransactGetItemsOutputTransformOutput {
	return TransactGetItemsOutputTransformOutput{TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput{TransformedOutput}}
}

func (_this TransactGetItemsOutputTransformOutput) Is_TransactGetItemsOutputTransformOutput() bool {
	_, ok := _this.Get_().(TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput)
	return ok
}

func (CompanionStruct_TransactGetItemsOutputTransformOutput_) Default() TransactGetItemsOutputTransformOutput {
	return Companion_TransactGetItemsOutputTransformOutput_.Create_TransactGetItemsOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_TransactGetItemsOutput_.Default())
}

func (_this TransactGetItemsOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.TransactGetItemsOutput {
	return _this.Get_().(TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput).TransformedOutput
}

func (_this TransactGetItemsOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsOutputTransformOutput.TransactGetItemsOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TransactGetItemsOutputTransformOutput) Equals(other TransactGetItemsOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput:
		{
			data2, ok := other.Get_().(TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TransactGetItemsOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TransactGetItemsOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_TransactGetItemsOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_TransactGetItemsOutputTransformOutput_{}
}

type type_TransactGetItemsOutputTransformOutput_ struct {
}

func (_this type_TransactGetItemsOutputTransformOutput_) Default() interface{} {
	return Companion_TransactGetItemsOutputTransformOutput_.Default()
}

func (_this type_TransactGetItemsOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsOutputTransformOutput"
}
func (_this TransactGetItemsOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TransactGetItemsOutputTransformOutput{}

// End of datatype TransactGetItemsOutputTransformOutput

// Definition of datatype TransactWriteItemsInputTransformInput
type TransactWriteItemsInputTransformInput struct {
	Data_TransactWriteItemsInputTransformInput_
}

func (_this TransactWriteItemsInputTransformInput) Get_() Data_TransactWriteItemsInputTransformInput_ {
	return _this.Data_TransactWriteItemsInputTransformInput_
}

type Data_TransactWriteItemsInputTransformInput_ interface {
	isTransactWriteItemsInputTransformInput()
}

type CompanionStruct_TransactWriteItemsInputTransformInput_ struct {
}

var Companion_TransactWriteItemsInputTransformInput_ = CompanionStruct_TransactWriteItemsInputTransformInput_{}

type TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput
}

func (TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput) isTransactWriteItemsInputTransformInput() {
}

func (CompanionStruct_TransactWriteItemsInputTransformInput_) Create_TransactWriteItemsInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput) TransactWriteItemsInputTransformInput {
	return TransactWriteItemsInputTransformInput{TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput{SdkInput}}
}

func (_this TransactWriteItemsInputTransformInput) Is_TransactWriteItemsInputTransformInput() bool {
	_, ok := _this.Get_().(TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput)
	return ok
}

func (CompanionStruct_TransactWriteItemsInputTransformInput_) Default() TransactWriteItemsInputTransformInput {
	return Companion_TransactWriteItemsInputTransformInput_.Create_TransactWriteItemsInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsInput_.Default())
}

func (_this TransactWriteItemsInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput {
	return _this.Get_().(TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput).SdkInput
}

func (_this TransactWriteItemsInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformInput.TransactWriteItemsInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TransactWriteItemsInputTransformInput) Equals(other TransactWriteItemsInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput:
		{
			data2, ok := other.Get_().(TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TransactWriteItemsInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TransactWriteItemsInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_TransactWriteItemsInputTransformInput_() _dafny.TypeDescriptor {
	return type_TransactWriteItemsInputTransformInput_{}
}

type type_TransactWriteItemsInputTransformInput_ struct {
}

func (_this type_TransactWriteItemsInputTransformInput_) Default() interface{} {
	return Companion_TransactWriteItemsInputTransformInput_.Default()
}

func (_this type_TransactWriteItemsInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformInput"
}
func (_this TransactWriteItemsInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TransactWriteItemsInputTransformInput{}

// End of datatype TransactWriteItemsInputTransformInput

// Definition of datatype TransactWriteItemsInputTransformOutput
type TransactWriteItemsInputTransformOutput struct {
	Data_TransactWriteItemsInputTransformOutput_
}

func (_this TransactWriteItemsInputTransformOutput) Get_() Data_TransactWriteItemsInputTransformOutput_ {
	return _this.Data_TransactWriteItemsInputTransformOutput_
}

type Data_TransactWriteItemsInputTransformOutput_ interface {
	isTransactWriteItemsInputTransformOutput()
}

type CompanionStruct_TransactWriteItemsInputTransformOutput_ struct {
}

var Companion_TransactWriteItemsInputTransformOutput_ = CompanionStruct_TransactWriteItemsInputTransformOutput_{}

type TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput
}

func (TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput) isTransactWriteItemsInputTransformOutput() {
}

func (CompanionStruct_TransactWriteItemsInputTransformOutput_) Create_TransactWriteItemsInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput) TransactWriteItemsInputTransformOutput {
	return TransactWriteItemsInputTransformOutput{TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput{TransformedInput}}
}

func (_this TransactWriteItemsInputTransformOutput) Is_TransactWriteItemsInputTransformOutput() bool {
	_, ok := _this.Get_().(TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput)
	return ok
}

func (CompanionStruct_TransactWriteItemsInputTransformOutput_) Default() TransactWriteItemsInputTransformOutput {
	return Companion_TransactWriteItemsInputTransformOutput_.Create_TransactWriteItemsInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsInput_.Default())
}

func (_this TransactWriteItemsInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput {
	return _this.Get_().(TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput).TransformedInput
}

func (_this TransactWriteItemsInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformOutput.TransactWriteItemsInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TransactWriteItemsInputTransformOutput) Equals(other TransactWriteItemsInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput:
		{
			data2, ok := other.Get_().(TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TransactWriteItemsInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TransactWriteItemsInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_TransactWriteItemsInputTransformOutput_() _dafny.TypeDescriptor {
	return type_TransactWriteItemsInputTransformOutput_{}
}

type type_TransactWriteItemsInputTransformOutput_ struct {
}

func (_this type_TransactWriteItemsInputTransformOutput_) Default() interface{} {
	return Companion_TransactWriteItemsInputTransformOutput_.Default()
}

func (_this type_TransactWriteItemsInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformOutput"
}
func (_this TransactWriteItemsInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TransactWriteItemsInputTransformOutput{}

// End of datatype TransactWriteItemsInputTransformOutput

// Definition of datatype TransactWriteItemsOutputTransformInput
type TransactWriteItemsOutputTransformInput struct {
	Data_TransactWriteItemsOutputTransformInput_
}

func (_this TransactWriteItemsOutputTransformInput) Get_() Data_TransactWriteItemsOutputTransformInput_ {
	return _this.Data_TransactWriteItemsOutputTransformInput_
}

type Data_TransactWriteItemsOutputTransformInput_ interface {
	isTransactWriteItemsOutputTransformInput()
}

type CompanionStruct_TransactWriteItemsOutputTransformInput_ struct {
}

var Companion_TransactWriteItemsOutputTransformInput_ = CompanionStruct_TransactWriteItemsOutputTransformInput_{}

type TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput
}

func (TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput) isTransactWriteItemsOutputTransformInput() {
}

func (CompanionStruct_TransactWriteItemsOutputTransformInput_) Create_TransactWriteItemsOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput, OriginalInput m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput) TransactWriteItemsOutputTransformInput {
	return TransactWriteItemsOutputTransformInput{TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this TransactWriteItemsOutputTransformInput) Is_TransactWriteItemsOutputTransformInput() bool {
	_, ok := _this.Get_().(TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput)
	return ok
}

func (CompanionStruct_TransactWriteItemsOutputTransformInput_) Default() TransactWriteItemsOutputTransformInput {
	return Companion_TransactWriteItemsOutputTransformInput_.Create_TransactWriteItemsOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsInput_.Default())
}

func (_this TransactWriteItemsOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput {
	return _this.Get_().(TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput).SdkOutput
}

func (_this TransactWriteItemsOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.TransactWriteItemsInput {
	return _this.Get_().(TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput).OriginalInput
}

func (_this TransactWriteItemsOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsOutputTransformInput.TransactWriteItemsOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TransactWriteItemsOutputTransformInput) Equals(other TransactWriteItemsOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput:
		{
			data2, ok := other.Get_().(TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TransactWriteItemsOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TransactWriteItemsOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_TransactWriteItemsOutputTransformInput_() _dafny.TypeDescriptor {
	return type_TransactWriteItemsOutputTransformInput_{}
}

type type_TransactWriteItemsOutputTransformInput_ struct {
}

func (_this type_TransactWriteItemsOutputTransformInput_) Default() interface{} {
	return Companion_TransactWriteItemsOutputTransformInput_.Default()
}

func (_this type_TransactWriteItemsOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsOutputTransformInput"
}
func (_this TransactWriteItemsOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TransactWriteItemsOutputTransformInput{}

// End of datatype TransactWriteItemsOutputTransformInput

// Definition of datatype TransactWriteItemsOutputTransformOutput
type TransactWriteItemsOutputTransformOutput struct {
	Data_TransactWriteItemsOutputTransformOutput_
}

func (_this TransactWriteItemsOutputTransformOutput) Get_() Data_TransactWriteItemsOutputTransformOutput_ {
	return _this.Data_TransactWriteItemsOutputTransformOutput_
}

type Data_TransactWriteItemsOutputTransformOutput_ interface {
	isTransactWriteItemsOutputTransformOutput()
}

type CompanionStruct_TransactWriteItemsOutputTransformOutput_ struct {
}

var Companion_TransactWriteItemsOutputTransformOutput_ = CompanionStruct_TransactWriteItemsOutputTransformOutput_{}

type TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput
}

func (TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput) isTransactWriteItemsOutputTransformOutput() {
}

func (CompanionStruct_TransactWriteItemsOutputTransformOutput_) Create_TransactWriteItemsOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput) TransactWriteItemsOutputTransformOutput {
	return TransactWriteItemsOutputTransformOutput{TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput{TransformedOutput}}
}

func (_this TransactWriteItemsOutputTransformOutput) Is_TransactWriteItemsOutputTransformOutput() bool {
	_, ok := _this.Get_().(TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput)
	return ok
}

func (CompanionStruct_TransactWriteItemsOutputTransformOutput_) Default() TransactWriteItemsOutputTransformOutput {
	return Companion_TransactWriteItemsOutputTransformOutput_.Create_TransactWriteItemsOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsOutput_.Default())
}

func (_this TransactWriteItemsOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput {
	return _this.Get_().(TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput).TransformedOutput
}

func (_this TransactWriteItemsOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsOutputTransformOutput.TransactWriteItemsOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TransactWriteItemsOutputTransformOutput) Equals(other TransactWriteItemsOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput:
		{
			data2, ok := other.Get_().(TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TransactWriteItemsOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TransactWriteItemsOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_TransactWriteItemsOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_TransactWriteItemsOutputTransformOutput_{}
}

type type_TransactWriteItemsOutputTransformOutput_ struct {
}

func (_this type_TransactWriteItemsOutputTransformOutput_) Default() interface{} {
	return Companion_TransactWriteItemsOutputTransformOutput_.Default()
}

func (_this type_TransactWriteItemsOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsOutputTransformOutput"
}
func (_this TransactWriteItemsOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TransactWriteItemsOutputTransformOutput{}

// End of datatype TransactWriteItemsOutputTransformOutput

// Definition of datatype UpdateItemInputTransformInput
type UpdateItemInputTransformInput struct {
	Data_UpdateItemInputTransformInput_
}

func (_this UpdateItemInputTransformInput) Get_() Data_UpdateItemInputTransformInput_ {
	return _this.Data_UpdateItemInputTransformInput_
}

type Data_UpdateItemInputTransformInput_ interface {
	isUpdateItemInputTransformInput()
}

type CompanionStruct_UpdateItemInputTransformInput_ struct {
}

var Companion_UpdateItemInputTransformInput_ = CompanionStruct_UpdateItemInputTransformInput_{}

type UpdateItemInputTransformInput_UpdateItemInputTransformInput struct {
	SdkInput m_ComAmazonawsDynamodbTypes.UpdateItemInput
}

func (UpdateItemInputTransformInput_UpdateItemInputTransformInput) isUpdateItemInputTransformInput() {
}

func (CompanionStruct_UpdateItemInputTransformInput_) Create_UpdateItemInputTransformInput_(SdkInput m_ComAmazonawsDynamodbTypes.UpdateItemInput) UpdateItemInputTransformInput {
	return UpdateItemInputTransformInput{UpdateItemInputTransformInput_UpdateItemInputTransformInput{SdkInput}}
}

func (_this UpdateItemInputTransformInput) Is_UpdateItemInputTransformInput() bool {
	_, ok := _this.Get_().(UpdateItemInputTransformInput_UpdateItemInputTransformInput)
	return ok
}

func (CompanionStruct_UpdateItemInputTransformInput_) Default() UpdateItemInputTransformInput {
	return Companion_UpdateItemInputTransformInput_.Create_UpdateItemInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_UpdateItemInput_.Default())
}

func (_this UpdateItemInputTransformInput) Dtor_sdkInput() m_ComAmazonawsDynamodbTypes.UpdateItemInput {
	return _this.Get_().(UpdateItemInputTransformInput_UpdateItemInputTransformInput).SdkInput
}

func (_this UpdateItemInputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateItemInputTransformInput_UpdateItemInputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemInputTransformInput.UpdateItemInputTransformInput" + "(" + _dafny.String(data.SdkInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateItemInputTransformInput) Equals(other UpdateItemInputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case UpdateItemInputTransformInput_UpdateItemInputTransformInput:
		{
			data2, ok := other.Get_().(UpdateItemInputTransformInput_UpdateItemInputTransformInput)
			return ok && data1.SdkInput.Equals(data2.SdkInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateItemInputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateItemInputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_UpdateItemInputTransformInput_() _dafny.TypeDescriptor {
	return type_UpdateItemInputTransformInput_{}
}

type type_UpdateItemInputTransformInput_ struct {
}

func (_this type_UpdateItemInputTransformInput_) Default() interface{} {
	return Companion_UpdateItemInputTransformInput_.Default()
}

func (_this type_UpdateItemInputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemInputTransformInput"
}
func (_this UpdateItemInputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateItemInputTransformInput{}

// End of datatype UpdateItemInputTransformInput

// Definition of datatype UpdateItemInputTransformOutput
type UpdateItemInputTransformOutput struct {
	Data_UpdateItemInputTransformOutput_
}

func (_this UpdateItemInputTransformOutput) Get_() Data_UpdateItemInputTransformOutput_ {
	return _this.Data_UpdateItemInputTransformOutput_
}

type Data_UpdateItemInputTransformOutput_ interface {
	isUpdateItemInputTransformOutput()
}

type CompanionStruct_UpdateItemInputTransformOutput_ struct {
}

var Companion_UpdateItemInputTransformOutput_ = CompanionStruct_UpdateItemInputTransformOutput_{}

type UpdateItemInputTransformOutput_UpdateItemInputTransformOutput struct {
	TransformedInput m_ComAmazonawsDynamodbTypes.UpdateItemInput
}

func (UpdateItemInputTransformOutput_UpdateItemInputTransformOutput) isUpdateItemInputTransformOutput() {
}

func (CompanionStruct_UpdateItemInputTransformOutput_) Create_UpdateItemInputTransformOutput_(TransformedInput m_ComAmazonawsDynamodbTypes.UpdateItemInput) UpdateItemInputTransformOutput {
	return UpdateItemInputTransformOutput{UpdateItemInputTransformOutput_UpdateItemInputTransformOutput{TransformedInput}}
}

func (_this UpdateItemInputTransformOutput) Is_UpdateItemInputTransformOutput() bool {
	_, ok := _this.Get_().(UpdateItemInputTransformOutput_UpdateItemInputTransformOutput)
	return ok
}

func (CompanionStruct_UpdateItemInputTransformOutput_) Default() UpdateItemInputTransformOutput {
	return Companion_UpdateItemInputTransformOutput_.Create_UpdateItemInputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_UpdateItemInput_.Default())
}

func (_this UpdateItemInputTransformOutput) Dtor_transformedInput() m_ComAmazonawsDynamodbTypes.UpdateItemInput {
	return _this.Get_().(UpdateItemInputTransformOutput_UpdateItemInputTransformOutput).TransformedInput
}

func (_this UpdateItemInputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateItemInputTransformOutput_UpdateItemInputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemInputTransformOutput.UpdateItemInputTransformOutput" + "(" + _dafny.String(data.TransformedInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateItemInputTransformOutput) Equals(other UpdateItemInputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case UpdateItemInputTransformOutput_UpdateItemInputTransformOutput:
		{
			data2, ok := other.Get_().(UpdateItemInputTransformOutput_UpdateItemInputTransformOutput)
			return ok && data1.TransformedInput.Equals(data2.TransformedInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateItemInputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateItemInputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_UpdateItemInputTransformOutput_() _dafny.TypeDescriptor {
	return type_UpdateItemInputTransformOutput_{}
}

type type_UpdateItemInputTransformOutput_ struct {
}

func (_this type_UpdateItemInputTransformOutput_) Default() interface{} {
	return Companion_UpdateItemInputTransformOutput_.Default()
}

func (_this type_UpdateItemInputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemInputTransformOutput"
}
func (_this UpdateItemInputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateItemInputTransformOutput{}

// End of datatype UpdateItemInputTransformOutput

// Definition of datatype UpdateItemOutputTransformInput
type UpdateItemOutputTransformInput struct {
	Data_UpdateItemOutputTransformInput_
}

func (_this UpdateItemOutputTransformInput) Get_() Data_UpdateItemOutputTransformInput_ {
	return _this.Data_UpdateItemOutputTransformInput_
}

type Data_UpdateItemOutputTransformInput_ interface {
	isUpdateItemOutputTransformInput()
}

type CompanionStruct_UpdateItemOutputTransformInput_ struct {
}

var Companion_UpdateItemOutputTransformInput_ = CompanionStruct_UpdateItemOutputTransformInput_{}

type UpdateItemOutputTransformInput_UpdateItemOutputTransformInput struct {
	SdkOutput     m_ComAmazonawsDynamodbTypes.UpdateItemOutput
	OriginalInput m_ComAmazonawsDynamodbTypes.UpdateItemInput
}

func (UpdateItemOutputTransformInput_UpdateItemOutputTransformInput) isUpdateItemOutputTransformInput() {
}

func (CompanionStruct_UpdateItemOutputTransformInput_) Create_UpdateItemOutputTransformInput_(SdkOutput m_ComAmazonawsDynamodbTypes.UpdateItemOutput, OriginalInput m_ComAmazonawsDynamodbTypes.UpdateItemInput) UpdateItemOutputTransformInput {
	return UpdateItemOutputTransformInput{UpdateItemOutputTransformInput_UpdateItemOutputTransformInput{SdkOutput, OriginalInput}}
}

func (_this UpdateItemOutputTransformInput) Is_UpdateItemOutputTransformInput() bool {
	_, ok := _this.Get_().(UpdateItemOutputTransformInput_UpdateItemOutputTransformInput)
	return ok
}

func (CompanionStruct_UpdateItemOutputTransformInput_) Default() UpdateItemOutputTransformInput {
	return Companion_UpdateItemOutputTransformInput_.Create_UpdateItemOutputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_UpdateItemOutput_.Default(), m_ComAmazonawsDynamodbTypes.Companion_UpdateItemInput_.Default())
}

func (_this UpdateItemOutputTransformInput) Dtor_sdkOutput() m_ComAmazonawsDynamodbTypes.UpdateItemOutput {
	return _this.Get_().(UpdateItemOutputTransformInput_UpdateItemOutputTransformInput).SdkOutput
}

func (_this UpdateItemOutputTransformInput) Dtor_originalInput() m_ComAmazonawsDynamodbTypes.UpdateItemInput {
	return _this.Get_().(UpdateItemOutputTransformInput_UpdateItemOutputTransformInput).OriginalInput
}

func (_this UpdateItemOutputTransformInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateItemOutputTransformInput_UpdateItemOutputTransformInput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemOutputTransformInput.UpdateItemOutputTransformInput" + "(" + _dafny.String(data.SdkOutput) + ", " + _dafny.String(data.OriginalInput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateItemOutputTransformInput) Equals(other UpdateItemOutputTransformInput) bool {
	switch data1 := _this.Get_().(type) {
	case UpdateItemOutputTransformInput_UpdateItemOutputTransformInput:
		{
			data2, ok := other.Get_().(UpdateItemOutputTransformInput_UpdateItemOutputTransformInput)
			return ok && data1.SdkOutput.Equals(data2.SdkOutput) && data1.OriginalInput.Equals(data2.OriginalInput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateItemOutputTransformInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateItemOutputTransformInput)
	return ok && _this.Equals(typed)
}

func Type_UpdateItemOutputTransformInput_() _dafny.TypeDescriptor {
	return type_UpdateItemOutputTransformInput_{}
}

type type_UpdateItemOutputTransformInput_ struct {
}

func (_this type_UpdateItemOutputTransformInput_) Default() interface{} {
	return Companion_UpdateItemOutputTransformInput_.Default()
}

func (_this type_UpdateItemOutputTransformInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemOutputTransformInput"
}
func (_this UpdateItemOutputTransformInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateItemOutputTransformInput{}

// End of datatype UpdateItemOutputTransformInput

// Definition of datatype UpdateItemOutputTransformOutput
type UpdateItemOutputTransformOutput struct {
	Data_UpdateItemOutputTransformOutput_
}

func (_this UpdateItemOutputTransformOutput) Get_() Data_UpdateItemOutputTransformOutput_ {
	return _this.Data_UpdateItemOutputTransformOutput_
}

type Data_UpdateItemOutputTransformOutput_ interface {
	isUpdateItemOutputTransformOutput()
}

type CompanionStruct_UpdateItemOutputTransformOutput_ struct {
}

var Companion_UpdateItemOutputTransformOutput_ = CompanionStruct_UpdateItemOutputTransformOutput_{}

type UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput struct {
	TransformedOutput m_ComAmazonawsDynamodbTypes.UpdateItemOutput
}

func (UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput) isUpdateItemOutputTransformOutput() {
}

func (CompanionStruct_UpdateItemOutputTransformOutput_) Create_UpdateItemOutputTransformOutput_(TransformedOutput m_ComAmazonawsDynamodbTypes.UpdateItemOutput) UpdateItemOutputTransformOutput {
	return UpdateItemOutputTransformOutput{UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput{TransformedOutput}}
}

func (_this UpdateItemOutputTransformOutput) Is_UpdateItemOutputTransformOutput() bool {
	_, ok := _this.Get_().(UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput)
	return ok
}

func (CompanionStruct_UpdateItemOutputTransformOutput_) Default() UpdateItemOutputTransformOutput {
	return Companion_UpdateItemOutputTransformOutput_.Create_UpdateItemOutputTransformOutput_(m_ComAmazonawsDynamodbTypes.Companion_UpdateItemOutput_.Default())
}

func (_this UpdateItemOutputTransformOutput) Dtor_transformedOutput() m_ComAmazonawsDynamodbTypes.UpdateItemOutput {
	return _this.Get_().(UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput).TransformedOutput
}

func (_this UpdateItemOutputTransformOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemOutputTransformOutput.UpdateItemOutputTransformOutput" + "(" + _dafny.String(data.TransformedOutput) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateItemOutputTransformOutput) Equals(other UpdateItemOutputTransformOutput) bool {
	switch data1 := _this.Get_().(type) {
	case UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput:
		{
			data2, ok := other.Get_().(UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput)
			return ok && data1.TransformedOutput.Equals(data2.TransformedOutput)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateItemOutputTransformOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateItemOutputTransformOutput)
	return ok && _this.Equals(typed)
}

func Type_UpdateItemOutputTransformOutput_() _dafny.TypeDescriptor {
	return type_UpdateItemOutputTransformOutput_{}
}

type type_UpdateItemOutputTransformOutput_ struct {
}

func (_this type_UpdateItemOutputTransformOutput_) Default() interface{} {
	return Companion_UpdateItemOutputTransformOutput_.Default()
}

func (_this type_UpdateItemOutputTransformOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemOutputTransformOutput"
}
func (_this UpdateItemOutputTransformOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateItemOutputTransformOutput{}

// End of datatype UpdateItemOutputTransformOutput

// Definition of datatype Error
type Error struct {
	Data_Error_
}

func (_this Error) Get_() Data_Error_ {
	return _this.Data_Error_
}

type Data_Error_ interface {
	isError()
}

type CompanionStruct_Error_ struct {
}

var Companion_Error_ = CompanionStruct_Error_{}

type Error_DynamoDbEncryptionTransformsException struct {
	Message _dafny.Sequence
}

func (Error_DynamoDbEncryptionTransformsException) isError() {}

func (CompanionStruct_Error_) Create_DynamoDbEncryptionTransformsException_(Message _dafny.Sequence) Error {
	return Error{Error_DynamoDbEncryptionTransformsException{Message}}
}

func (_this Error) Is_DynamoDbEncryptionTransformsException() bool {
	_, ok := _this.Get_().(Error_DynamoDbEncryptionTransformsException)
	return ok
}

type Error_AwsCryptographyDbEncryptionSdkDynamoDb struct {
	AwsCryptographyDbEncryptionSdkDynamoDb m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error
}

func (Error_AwsCryptographyDbEncryptionSdkDynamoDb) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyDbEncryptionSdkDynamoDb_(AwsCryptographyDbEncryptionSdkDynamoDb m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) Error {
	return Error{Error_AwsCryptographyDbEncryptionSdkDynamoDb{AwsCryptographyDbEncryptionSdkDynamoDb}}
}

func (_this Error) Is_AwsCryptographyDbEncryptionSdkDynamoDb() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDb)
	return ok
}

type Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor struct {
	AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error
}

func (Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor_(AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) Error {
	return Error{Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor{AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor}}
}

func (_this Error) Is_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor)
	return ok
}

type Error_AwsCryptographyDbEncryptionSdkStructuredEncryption struct {
	AwsCryptographyDbEncryptionSdkStructuredEncryption m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error
}

func (Error_AwsCryptographyDbEncryptionSdkStructuredEncryption) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyDbEncryptionSdkStructuredEncryption_(AwsCryptographyDbEncryptionSdkStructuredEncryption m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) Error {
	return Error{Error_AwsCryptographyDbEncryptionSdkStructuredEncryption{AwsCryptographyDbEncryptionSdkStructuredEncryption}}
}

func (_this Error) Is_AwsCryptographyDbEncryptionSdkStructuredEncryption() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyDbEncryptionSdkStructuredEncryption)
	return ok
}

type Error_AwsCryptographyMaterialProviders struct {
	AwsCryptographyMaterialProviders m_AwsCryptographyMaterialProvidersTypes.Error
}

func (Error_AwsCryptographyMaterialProviders) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyMaterialProviders_(AwsCryptographyMaterialProviders m_AwsCryptographyMaterialProvidersTypes.Error) Error {
	return Error{Error_AwsCryptographyMaterialProviders{AwsCryptographyMaterialProviders}}
}

func (_this Error) Is_AwsCryptographyMaterialProviders() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyMaterialProviders)
	return ok
}

type Error_ComAmazonawsDynamodb struct {
	ComAmazonawsDynamodb m_ComAmazonawsDynamodbTypes.Error
}

func (Error_ComAmazonawsDynamodb) isError() {}

func (CompanionStruct_Error_) Create_ComAmazonawsDynamodb_(ComAmazonawsDynamodb m_ComAmazonawsDynamodbTypes.Error) Error {
	return Error{Error_ComAmazonawsDynamodb{ComAmazonawsDynamodb}}
}

func (_this Error) Is_ComAmazonawsDynamodb() bool {
	_, ok := _this.Get_().(Error_ComAmazonawsDynamodb)
	return ok
}

type Error_CollectionOfErrors struct {
	List    _dafny.Sequence
	Message _dafny.Sequence
}

func (Error_CollectionOfErrors) isError() {}

func (CompanionStruct_Error_) Create_CollectionOfErrors_(List _dafny.Sequence, Message _dafny.Sequence) Error {
	return Error{Error_CollectionOfErrors{List, Message}}
}

func (_this Error) Is_CollectionOfErrors() bool {
	_, ok := _this.Get_().(Error_CollectionOfErrors)
	return ok
}

type Error_Opaque struct {
	Obj interface{}
}

func (Error_Opaque) isError() {}

func (CompanionStruct_Error_) Create_Opaque_(Obj interface{}) Error {
	return Error{Error_Opaque{Obj}}
}

func (_this Error) Is_Opaque() bool {
	_, ok := _this.Get_().(Error_Opaque)
	return ok
}

type Error_OpaqueWithText struct {
	Obj        interface{}
	ObjMessage _dafny.Sequence
}

func (Error_OpaqueWithText) isError() {}

func (CompanionStruct_Error_) Create_OpaqueWithText_(Obj interface{}, ObjMessage _dafny.Sequence) Error {
	return Error{Error_OpaqueWithText{Obj, ObjMessage}}
}

func (_this Error) Is_OpaqueWithText() bool {
	_, ok := _this.Get_().(Error_OpaqueWithText)
	return ok
}

func (CompanionStruct_Error_) Default() Error {
	return Companion_Error_.Create_DynamoDbEncryptionTransformsException_(_dafny.EmptySeq.SetString())
}

func (_this Error) Dtor_message() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Error_DynamoDbEncryptionTransformsException:
		return data.Message
	default:
		return data.(Error_CollectionOfErrors).Message
	}
}

func (_this Error) Dtor_AwsCryptographyDbEncryptionSdkDynamoDb() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
	return _this.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDb).AwsCryptographyDbEncryptionSdkDynamoDb
}

func (_this Error) Dtor_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor() m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
	return _this.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor).AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor
}

func (_this Error) Dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption() m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
	return _this.Get_().(Error_AwsCryptographyDbEncryptionSdkStructuredEncryption).AwsCryptographyDbEncryptionSdkStructuredEncryption
}

func (_this Error) Dtor_AwsCryptographyMaterialProviders() m_AwsCryptographyMaterialProvidersTypes.Error {
	return _this.Get_().(Error_AwsCryptographyMaterialProviders).AwsCryptographyMaterialProviders
}

func (_this Error) Dtor_ComAmazonawsDynamodb() m_ComAmazonawsDynamodbTypes.Error {
	return _this.Get_().(Error_ComAmazonawsDynamodb).ComAmazonawsDynamodb
}

func (_this Error) Dtor_list() _dafny.Sequence {
	return _this.Get_().(Error_CollectionOfErrors).List
}

func (_this Error) Dtor_obj() interface{} {
	switch data := _this.Get_().(type) {
	case Error_Opaque:
		return data.Obj
	default:
		return data.(Error_OpaqueWithText).Obj
	}
}

func (_this Error) Dtor_objMessage() _dafny.Sequence {
	return _this.Get_().(Error_OpaqueWithText).ObjMessage
}

func (_this Error) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Error_DynamoDbEncryptionTransformsException:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.DynamoDbEncryptionTransformsException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_AwsCryptographyDbEncryptionSdkDynamoDb:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDb" + "(" + _dafny.String(data.AwsCryptographyDbEncryptionSdkDynamoDb) + ")"
		}
	case Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor" + "(" + _dafny.String(data.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor) + ")"
		}
	case Error_AwsCryptographyDbEncryptionSdkStructuredEncryption:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyDbEncryptionSdkStructuredEncryption" + "(" + _dafny.String(data.AwsCryptographyDbEncryptionSdkStructuredEncryption) + ")"
		}
	case Error_AwsCryptographyMaterialProviders:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.AwsCryptographyMaterialProviders" + "(" + _dafny.String(data.AwsCryptographyMaterialProviders) + ")"
		}
	case Error_ComAmazonawsDynamodb:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.ComAmazonawsDynamodb" + "(" + _dafny.String(data.ComAmazonawsDynamodb) + ")"
		}
	case Error_CollectionOfErrors:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.CollectionOfErrors" + "(" + _dafny.String(data.List) + ", " + _dafny.String(data.Message) + ")"
		}
	case Error_Opaque:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.Opaque" + "(" + _dafny.String(data.Obj) + ")"
		}
	case Error_OpaqueWithText:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error.OpaqueWithText" + "(" + _dafny.String(data.Obj) + ", " + _dafny.String(data.ObjMessage) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Error) Equals(other Error) bool {
	switch data1 := _this.Get_().(type) {
	case Error_DynamoDbEncryptionTransformsException:
		{
			data2, ok := other.Get_().(Error_DynamoDbEncryptionTransformsException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_AwsCryptographyDbEncryptionSdkDynamoDb:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDb)
			return ok && data1.AwsCryptographyDbEncryptionSdkDynamoDb.Equals(data2.AwsCryptographyDbEncryptionSdkDynamoDb)
		}
	case Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor)
			return ok && data1.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor.Equals(data2.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor)
		}
	case Error_AwsCryptographyDbEncryptionSdkStructuredEncryption:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyDbEncryptionSdkStructuredEncryption)
			return ok && data1.AwsCryptographyDbEncryptionSdkStructuredEncryption.Equals(data2.AwsCryptographyDbEncryptionSdkStructuredEncryption)
		}
	case Error_AwsCryptographyMaterialProviders:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyMaterialProviders)
			return ok && data1.AwsCryptographyMaterialProviders.Equals(data2.AwsCryptographyMaterialProviders)
		}
	case Error_ComAmazonawsDynamodb:
		{
			data2, ok := other.Get_().(Error_ComAmazonawsDynamodb)
			return ok && data1.ComAmazonawsDynamodb.Equals(data2.ComAmazonawsDynamodb)
		}
	case Error_CollectionOfErrors:
		{
			data2, ok := other.Get_().(Error_CollectionOfErrors)
			return ok && data1.List.Equals(data2.List) && data1.Message.Equals(data2.Message)
		}
	case Error_Opaque:
		{
			data2, ok := other.Get_().(Error_Opaque)
			return ok && _dafny.AreEqual(data1.Obj, data2.Obj)
		}
	case Error_OpaqueWithText:
		{
			data2, ok := other.Get_().(Error_OpaqueWithText)
			return ok && _dafny.AreEqual(data1.Obj, data2.Obj) && data1.ObjMessage.Equals(data2.ObjMessage)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Error) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Error)
	return ok && _this.Equals(typed)
}

func Type_Error_() _dafny.TypeDescriptor {
	return type_Error_{}
}

type type_Error_ struct {
}

func (_this type_Error_) Default() interface{} {
	return Companion_Error_.Default()
}

func (_this type_Error_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error"
}
func (_this Error) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Error{}

// End of datatype Error

// Definition of class OpaqueError
type OpaqueError struct {
}

func New_OpaqueError_() *OpaqueError {
	_this := OpaqueError{}

	return &_this
}

type CompanionStruct_OpaqueError_ struct {
}

var Companion_OpaqueError_ = CompanionStruct_OpaqueError_{}

func (*OpaqueError) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.OpaqueError"
}

// End of class OpaqueError

func Type_OpaqueError_() _dafny.TypeDescriptor {
	return type_OpaqueError_{}
}

type type_OpaqueError_ struct {
}

func (_this type_OpaqueError_) Default() interface{} {
	return Companion_Error_.Default()
}

func (_this type_OpaqueError_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.OpaqueError"
}
func (_this *CompanionStruct_OpaqueError_) Is_(__source Error) bool {
	var _0_e Error = (__source)
	_ = _0_e
	return ((_0_e).Is_Opaque()) || ((_0_e).Is_OpaqueWithText())
}

// Definition of class DummySubsetType
type DummySubsetType struct {
}

func New_DummySubsetType_() *DummySubsetType {
	_this := DummySubsetType{}

	return &_this
}

type CompanionStruct_DummySubsetType_ struct {
}

var Companion_DummySubsetType_ = CompanionStruct_DummySubsetType_{}

func (*DummySubsetType) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Witness() _dafny.Int {
	return _dafny.One
}

// End of class DummySubsetType

func Type_DummySubsetType_() _dafny.TypeDescriptor {
	return type_DummySubsetType_{}
}

type type_DummySubsetType_ struct {
}

func (_this type_DummySubsetType_) Default() interface{} {
	return Companion_DummySubsetType_.Witness()
}

func (_this type_DummySubsetType_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Is_(__source _dafny.Int) bool {
	var _1_x _dafny.Int = (__source)
	_ = _1_x
	return Companion_Default___.IsDummySubsetType(_1_x)
}
