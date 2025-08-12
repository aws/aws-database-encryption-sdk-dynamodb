// Package DynamoDbItemEncryptor
// Dafny module DynamoDbItemEncryptor compiled into Go

package DynamoDbItemEncryptor

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
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Canonize"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionUtil"
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
	return "DynamoDbItemEncryptor.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DefaultDynamoDbItemEncryptorConfig() m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DynamoDbItemEncryptorConfig_.Create_DynamoDbItemEncryptorConfig_(_dafny.SeqOfString("foo"), _dafny.SeqOfString("bar"), m_Wrappers.Companion_Option_.Create_None_(), _dafny.NewMapBuilder().ToMap(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) UnreservedPrefix(attr _dafny.Sequence) bool {
	return (!(_dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbItemEncryptorUtil.Companion_Default___.ReservedPrefix(), attr))) && (!(_dafny.Companion_Sequence_.IsPrefixOf(m_StructuredEncryptionUtil.Companion_Default___.ReservedCryptoContextPrefixString(), attr)))
}
func (_static *CompanionStruct_Default___) DynamoDbItemEncryptor(config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((config).Dtor_keyring()).Is_None()) || (((config).Dtor_cmm()).Is_None()), m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.SeqOfString("Cannot provide both a keyring and a CMM")))
	if (_0_valueOrError0).IsFailure() {
		res = (_0_valueOrError0).PropagateFailure()
		return res
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need((((config).Dtor_keyring()).Is_Some()) || (((config).Dtor_cmm()).Is_Some()), m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.SeqOfString("Must provide either a keyring or a CMM")))
	if (_1_valueOrError1).IsFailure() {
		res = (_1_valueOrError1).PropagateFailure()
		return res
	}
	var _2_version uint8
	_ = _2_version
	_2_version = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Companion_Default___.VersionFromActions((config).Dtor_attributeActionsOnEncrypt())
	var _3_keyAction m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction
	_ = _3_keyAction
	_3_keyAction = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Companion_Default___.KeyActionFromVersion(_2_version)
	var _4_keyActionStr _dafny.Sequence
	_ = _4_keyActionStr
	_4_keyActionStr = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Companion_Default___.KeyActionStringFromVersion(_2_version)
	var _5_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _5_valueOrError2
	_5_valueOrError2 = m_Wrappers.Companion_Default___.Need((((config).Dtor_attributeActionsOnEncrypt()).Contains((config).Dtor_partitionKeyName())) && ((((config).Dtor_attributeActionsOnEncrypt()).Get((config).Dtor_partitionKeyName()).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(_3_keyAction)), m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Partition key attribute action MUST be "), _4_keyActionStr)))
	if (_5_valueOrError2).IsFailure() {
		res = (_5_valueOrError2).PropagateFailure()
		return res
	}
	var _6_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _6_valueOrError3
	_6_valueOrError3 = m_Wrappers.Companion_Default___.Need(!(((config).Dtor_sortKeyName()).Is_Some()) || ((((config).Dtor_attributeActionsOnEncrypt()).Contains(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence))) && ((((config).Dtor_attributeActionsOnEncrypt()).Get(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(_3_keyAction))), m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Sort key attribute action MUST be "), _4_keyActionStr)))
	if (_6_valueOrError3).IsFailure() {
		res = (_6_valueOrError3).PropagateFailure()
		return res
	}
	var _7_attributeNames _dafny.Sequence
	_ = _7_attributeNames
	_7_attributeNames = m_SortedSets.SetToOrderedSequence2(((config).Dtor_attributeActionsOnEncrypt()).Keys(), func(coer70 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg97 interface{}, arg98 interface{}) bool {
			return coer70(arg97.(_dafny.Char), arg98.(_dafny.Char))
		}
	}(m_DynamoDbItemEncryptorUtil.Companion_Default___.CharLess))
	var _hi0 _dafny.Int = _dafny.IntOfUint32((_7_attributeNames).Cardinality())
	_ = _hi0
	for _8_i := _dafny.Zero; _8_i.Cmp(_hi0) < 0; _8_i = _8_i.Plus(_dafny.One) {
		var _9_attributeName _dafny.Sequence
		_ = _9_attributeName
		_9_attributeName = (_7_attributeNames).Select((_8_i).Uint32()).(_dafny.Sequence)
		var _10_action m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction
		_ = _10_action
		_10_action = ((config).Dtor_attributeActionsOnEncrypt()).Get(_9_attributeName).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)
		if !(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Companion_Default___.ForwardCompatibleAttributeAction(_9_attributeName, _10_action, (config).Dtor_allowedUnsignedAttributes(), (config).Dtor_allowedUnsignedAttributePrefix())) {
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Companion_Default___.ExplainNotForwardCompatible(_9_attributeName, _10_action, (config).Dtor_allowedUnsignedAttributes(), (config).Dtor_allowedUnsignedAttributePrefix())))
			return res
		}
		if !(Companion_Default___.UnreservedPrefix(_9_attributeName)) {
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Attribute: "), _9_attributeName), _dafny.SeqOfString(" is reserved, and may not be configured."))))
			return res
		}
	}
	var _11_structuredEncryptionRes m_Wrappers.Result
	_ = _11_structuredEncryptionRes
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_StructuredEncryption.Companion_Default___.StructuredEncryption(m_StructuredEncryption.Companion_Default___.DefaultStructuredEncryptionConfig())
	_11_structuredEncryptionRes = _out0
	var _12_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _12_valueOrError4
	_12_valueOrError4 = (_11_structuredEncryptionRes).MapFailure(func(coer71 func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg99 interface{}) interface{} {
			return coer71(arg99.(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error))
		}
	}(func(_13_e m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkStructuredEncryption_(_13_e))
	}))
	if (_12_valueOrError4).IsFailure() {
		res = (_12_valueOrError4).PropagateFailure()
		return res
	}
	var _14_structuredEncryptionX m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.IStructuredEncryptionClient
	_ = _14_structuredEncryptionX
	_14_structuredEncryptionX = (_12_valueOrError4).Extract().(*m_StructuredEncryption.StructuredEncryptionClient)
	var _15_structuredEncryption *m_StructuredEncryption.StructuredEncryptionClient
	_ = _15_structuredEncryption
	_15_structuredEncryption = _14_structuredEncryptionX.(*m_StructuredEncryption.StructuredEncryptionClient)
	var _16_cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager = (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)(nil)
	_ = _16_cmm
	if ((config).Dtor_cmm()).Is_Some() {
		_16_cmm = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.CastTo_(((config).Dtor_cmm()).Dtor_value())
	} else {
		var _17_keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
		_ = _17_keyring
		_17_keyring = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.CastTo_(((config).Dtor_keyring()).Dtor_value())
		var _18_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _18_valueOrError5
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
		_18_valueOrError5 = _out1
		if !(!((_18_valueOrError5).IsFailure())) {
			panic("dafny/DynamoDbItemEncryptor/src/Index.dfy(158,21): " + (_18_valueOrError5).String())
		}
		var _19_matProv *m_MaterialProviders.MaterialProvidersClient
		_ = _19_matProv
		_19_matProv = (_18_valueOrError5).Extract().(*m_MaterialProviders.MaterialProvidersClient)
		var _20_maybeCmm m_Wrappers.Result
		_ = _20_maybeCmm
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = (_19_matProv).CreateDefaultCryptographicMaterialsManager(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateDefaultCryptographicMaterialsManagerInput_.Create_CreateDefaultCryptographicMaterialsManagerInput_(_17_keyring))
		_20_maybeCmm = _out2
		var _21_valueOrError6 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _21_valueOrError6
		_21_valueOrError6 = (_20_maybeCmm).MapFailure(func(coer72 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
			return func(arg100 interface{}) interface{} {
				return coer72(arg100.(m_AwsCryptographyMaterialProvidersTypes.Error))
			}
		}(func(_22_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_22_e)
		}))
		if (_21_valueOrError6).IsFailure() {
			res = (_21_valueOrError6).PropagateFailure()
			return res
		}
		_16_cmm = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.CastTo_((_21_valueOrError6).Extract())
	}
	var _23_maybeCmpClient m_Wrappers.Result
	_ = _23_maybeCmpClient
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_23_maybeCmpClient = _out3
	var _24_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_Wrappers.Companion_Option_.Default())
	_ = _24_valueOrError7
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_InternalLegacyOverride.Companion_InternalLegacyOverride_.Build(config)
	_24_valueOrError7 = _out4
	if (_24_valueOrError7).IsFailure() {
		res = (_24_valueOrError7).PropagateFailure()
		return res
	}
	var _25_internalLegacyOverride m_Wrappers.Option
	_ = _25_internalLegacyOverride
	_25_internalLegacyOverride = (_24_valueOrError7).Extract().(m_Wrappers.Option)
	var _26_valueOrError8 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _26_valueOrError8
	_26_valueOrError8 = (_23_maybeCmpClient).MapFailure(func(coer73 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg101 interface{}) interface{} {
			return coer73(arg101.(m_AwsCryptographyMaterialProvidersTypes.Error))
		}
	}(func(_27_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_27_e)
	}))
	if (_26_valueOrError8).IsFailure() {
		res = (_26_valueOrError8).PropagateFailure()
		return res
	}
	var _28_cmpClient *m_MaterialProviders.MaterialProvidersClient
	_ = _28_cmpClient
	_28_cmpClient = (_26_valueOrError8).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	if !(((_25_internalLegacyOverride).Is_None()) || (((config).Dtor_plaintextOverride()).Is_None())) {
		res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.SeqOfString("Cannot configure both a plaintext policy and a legacy config.")))
		return res
	}
	var _29_plaintextOverride m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride
	_ = _29_plaintextOverride
	if ((config).Dtor_plaintextOverride()).Is_Some() {
		_29_plaintextOverride = ((config).Dtor_plaintextOverride()).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride)
	} else {
		_29_plaintextOverride = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ_()
	}
	var _30_internalConfig m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Config
	_ = _30_internalConfig
	_30_internalConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Companion_Config_.Create_Config_(_2_version, _28_cmpClient, (config).Dtor_logicalTableName(), (config).Dtor_partitionKeyName(), (config).Dtor_sortKeyName(), _16_cmm, (config).Dtor_attributeActionsOnEncrypt(), (config).Dtor_allowedUnsignedAttributes(), (config).Dtor_allowedUnsignedAttributePrefix(), (config).Dtor_algorithmSuiteId(), _15_structuredEncryption, _29_plaintextOverride, _25_internalLegacyOverride)
	var _31_client *DynamoDbItemEncryptorClient
	_ = _31_client
	var _nw0 *DynamoDbItemEncryptorClient = New_DynamoDbItemEncryptorClient_()
	_ = _nw0
	_nw0.Ctor__(_30_internalConfig)
	_31_client = _nw0
	res = m_Wrappers.Companion_Result_.Create_Success_(_31_client)
	return res
	return res
}
func (_static *CompanionStruct_Default___) CreateSuccessOfClient(client m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClient) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(client)
}
func (_static *CompanionStruct_Default___) CreateFailureOfError(error_ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}

// End of class Default__

// Definition of class DynamoDbItemEncryptorClient
type DynamoDbItemEncryptorClient struct {
	_config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Config
}

func New_DynamoDbItemEncryptorClient_() *DynamoDbItemEncryptorClient {
	_this := DynamoDbItemEncryptorClient{}

	_this._config = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Config{}
	return &_this
}

type CompanionStruct_DynamoDbItemEncryptorClient_ struct {
}

var Companion_DynamoDbItemEncryptorClient_ = CompanionStruct_DynamoDbItemEncryptorClient_{}

func (_this *DynamoDbItemEncryptorClient) Equals(other *DynamoDbItemEncryptorClient) bool {
	return _this == other
}

func (_this *DynamoDbItemEncryptorClient) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*DynamoDbItemEncryptorClient)
	return ok && _this.Equals(other)
}

func (*DynamoDbItemEncryptorClient) String() string {
	return "DynamoDbItemEncryptor.DynamoDbItemEncryptorClient"
}

func Type_DynamoDbItemEncryptorClient_() _dafny.TypeDescriptor {
	return type_DynamoDbItemEncryptorClient_{}
}

type type_DynamoDbItemEncryptorClient_ struct {
}

func (_this type_DynamoDbItemEncryptorClient_) Default() interface{} {
	return (*DynamoDbItemEncryptorClient)(nil)
}

func (_this type_DynamoDbItemEncryptorClient_) String() string {
	return "DynamoDbItemEncryptor.DynamoDbItemEncryptorClient"
}
func (_this *DynamoDbItemEncryptorClient) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_IDynamoDbItemEncryptorClient_.TraitID_}
}

var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClient = &DynamoDbItemEncryptorClient{}
var _ _dafny.TraitOffspring = &DynamoDbItemEncryptorClient{}

func (_this *DynamoDbItemEncryptorClient) Ctor__(config m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Config) {
	{
		(_this)._config = config
	}
}
func (_this *DynamoDbItemEncryptorClient) EncryptItem(input m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Companion_Default___.EncryptItem((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *DynamoDbItemEncryptorClient) DecryptItem(input m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Companion_Default___.DecryptItem((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *DynamoDbItemEncryptorClient) Config() m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Config {
	{
		return _this._config
	}
}

// End of class DynamoDbItemEncryptorClient
