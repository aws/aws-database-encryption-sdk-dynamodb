// Package CompoundBeacon
// Dafny module CompoundBeacon compiled into Go

package CompoundBeacon

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
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/BaseBeacon"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
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
	m_MemoryMath "github.com/aws/aws-database-encryption-sdk-dynamodb/MemoryMath"
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
	return "CompoundBeacon.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) MakeCompoundBeacon(base m_BaseBeacon.BeaconBase, split _dafny.Char, parts _dafny.Sequence, numSigned _dafny.Int, construct _dafny.Sequence) m_Wrappers.Result {
	var _0_x CompoundBeacon = Companion_CompoundBeacon_.Create_CompoundBeacon_(base, split, parts, numSigned, construct)
	_ = _0_x
	var _1_valueOrError0 m_Wrappers.Result = (_0_x).ValidPrefixSetResult()
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2___v0 bool = (_1_valueOrError0).Extract().(bool)
		_ = _2___v0
		return m_Wrappers.Companion_Result_.Create_Success_(_0_x)
	}
}
func (_static *CompanionStruct_Default___) MakeDefaultConstructor(parts _dafny.Sequence) Constructor {
	var _0_cons _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer93 func(BeaconPart) ConstructorPart) func(interface{}) interface{} {
		return func(arg124 interface{}) interface{} {
			return coer93(arg124.(BeaconPart))
		}
	}(func(_1_x BeaconPart) ConstructorPart {
		return Companion_ConstructorPart_.Create_ConstructorPart_(_1_x, true)
	}), parts)
	_ = _0_cons
	return Companion_Constructor_.Create_Constructor_(_0_cons)
}

// End of class Default__

// Definition of class Prefix
type Prefix struct {
}

func New_Prefix_() *Prefix {
	_this := Prefix{}

	return &_this
}

type CompanionStruct_Prefix_ struct {
}

var Companion_Prefix_ = CompanionStruct_Prefix_{}

func (*Prefix) String() string {
	return "CompoundBeacon.Prefix"
}

// End of class Prefix

func Type_Prefix_() _dafny.TypeDescriptor {
	return type_Prefix_{}
}

type type_Prefix_ struct {
}

func (_this type_Prefix_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_Prefix_) String() string {
	return "CompoundBeacon.Prefix"
}
func (_this *CompanionStruct_Prefix_) Is_(__source _dafny.Sequence) bool {
	var _2_x _dafny.Sequence = (__source)
	_ = _2_x
	return (_dafny.IntOfUint32((_2_x).Cardinality())).Sign() == 1
}

// Definition of datatype BeaconPart
type BeaconPart struct {
	Data_BeaconPart_
}

func (_this BeaconPart) Get_() Data_BeaconPart_ {
	return _this.Data_BeaconPart_
}

type Data_BeaconPart_ interface {
	isBeaconPart()
}

type CompanionStruct_BeaconPart_ struct {
}

var Companion_BeaconPart_ = CompanionStruct_BeaconPart_{}

type BeaconPart_Encrypted struct {
	Prefix _dafny.Sequence
	Beacon m_BaseBeacon.StandardBeacon
}

func (BeaconPart_Encrypted) isBeaconPart() {}

func (CompanionStruct_BeaconPart_) Create_Encrypted_(Prefix _dafny.Sequence, Beacon m_BaseBeacon.StandardBeacon) BeaconPart {
	return BeaconPart{BeaconPart_Encrypted{Prefix, Beacon}}
}

func (_this BeaconPart) Is_Encrypted() bool {
	_, ok := _this.Get_().(BeaconPart_Encrypted)
	return ok
}

type BeaconPart_Signed struct {
	Prefix _dafny.Sequence
	Name   _dafny.Sequence
	Loc    _dafny.Sequence
}

func (BeaconPart_Signed) isBeaconPart() {}

func (CompanionStruct_BeaconPart_) Create_Signed_(Prefix _dafny.Sequence, Name _dafny.Sequence, Loc _dafny.Sequence) BeaconPart {
	return BeaconPart{BeaconPart_Signed{Prefix, Name, Loc}}
}

func (_this BeaconPart) Is_Signed() bool {
	_, ok := _this.Get_().(BeaconPart_Signed)
	return ok
}

func (CompanionStruct_BeaconPart_) Default() BeaconPart {
	return Companion_BeaconPart_.Create_Encrypted_(_dafny.EmptySeq.SetString(), m_BaseBeacon.Companion_StandardBeacon_.Default())
}

func (_this BeaconPart) Dtor_prefix() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case BeaconPart_Encrypted:
		return data.Prefix
	default:
		return data.(BeaconPart_Signed).Prefix
	}
}

func (_this BeaconPart) Dtor_beacon() m_BaseBeacon.StandardBeacon {
	return _this.Get_().(BeaconPart_Encrypted).Beacon
}

func (_this BeaconPart) Dtor_name() _dafny.Sequence {
	return _this.Get_().(BeaconPart_Signed).Name
}

func (_this BeaconPart) Dtor_loc() _dafny.Sequence {
	return _this.Get_().(BeaconPart_Signed).Loc
}

func (_this BeaconPart) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case BeaconPart_Encrypted:
		{
			return "CompoundBeacon.BeaconPart.Encrypted" + "(" + _dafny.String(data.Prefix) + ", " + _dafny.String(data.Beacon) + ")"
		}
	case BeaconPart_Signed:
		{
			return "CompoundBeacon.BeaconPart.Signed" + "(" + _dafny.String(data.Prefix) + ", " + _dafny.String(data.Name) + ", " + _dafny.String(data.Loc) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this BeaconPart) Equals(other BeaconPart) bool {
	switch data1 := _this.Get_().(type) {
	case BeaconPart_Encrypted:
		{
			data2, ok := other.Get_().(BeaconPart_Encrypted)
			return ok && data1.Prefix.Equals(data2.Prefix) && data1.Beacon.Equals(data2.Beacon)
		}
	case BeaconPart_Signed:
		{
			data2, ok := other.Get_().(BeaconPart_Signed)
			return ok && data1.Prefix.Equals(data2.Prefix) && data1.Name.Equals(data2.Name) && data1.Loc.Equals(data2.Loc)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this BeaconPart) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(BeaconPart)
	return ok && _this.Equals(typed)
}

func Type_BeaconPart_() _dafny.TypeDescriptor {
	return type_BeaconPart_{}
}

type type_BeaconPart_ struct {
}

func (_this type_BeaconPart_) Default() interface{} {
	return Companion_BeaconPart_.Default()
}

func (_this type_BeaconPart_) String() string {
	return "CompoundBeacon.BeaconPart"
}
func (_this BeaconPart) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = BeaconPart{}

func (_this BeaconPart) GetPrefix() _dafny.Sequence {
	{
		var _source0 BeaconPart = _this
		_ = _source0
		{
			if _source0.Is_Encrypted() {
				var _0_p _dafny.Sequence = _source0.Get_().(BeaconPart_Encrypted).Prefix
				_ = _0_p
				var _1_b m_BaseBeacon.StandardBeacon = _source0.Get_().(BeaconPart_Encrypted).Beacon
				_ = _1_b
				return _0_p
			}
		}
		{
			var _2_p _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Prefix
			_ = _2_p
			var _3_n _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Name
			_ = _3_n
			var _4_l _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Loc
			_ = _4_l
			return _2_p
		}
	}
}
func (_this BeaconPart) GetName() _dafny.Sequence {
	{
		var _source0 BeaconPart = _this
		_ = _source0
		{
			if _source0.Is_Encrypted() {
				var _0_p _dafny.Sequence = _source0.Get_().(BeaconPart_Encrypted).Prefix
				_ = _0_p
				var _1_b m_BaseBeacon.StandardBeacon = _source0.Get_().(BeaconPart_Encrypted).Beacon
				_ = _1_b
				return ((_1_b).Dtor_base()).Dtor_name()
			}
		}
		{
			var _2_p _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Prefix
			_ = _2_p
			var _3_n _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Name
			_ = _3_n
			var _4_l _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Loc
			_ = _4_l
			return _3_n
		}
	}
}
func (_this BeaconPart) GetString(item _dafny.Map, vf _dafny.Map) m_Wrappers.Result {
	{
		var _source0 BeaconPart = _this
		_ = _source0
		{
			if _source0.Is_Encrypted() {
				var _0_p _dafny.Sequence = _source0.Get_().(BeaconPart_Encrypted).Prefix
				_ = _0_p
				var _1_b m_BaseBeacon.StandardBeacon = _source0.Get_().(BeaconPart_Encrypted).Beacon
				_ = _1_b
				return m_DdbVirtualFields.Companion_Default___.VirtToString((_1_b).Dtor_loc(), item, vf)
			}
		}
		{
			var _2_p _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Prefix
			_ = _2_p
			var _3_n _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Name
			_ = _3_n
			var _4_l _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Loc
			_ = _4_l
			return m_DdbVirtualFields.Companion_Default___.VirtToString(_4_l, item, vf)
		}
	}
}
func (_this BeaconPart) GetFields(virtualFields _dafny.Map) _dafny.Sequence {
	{
		var _source0 BeaconPart = _this
		_ = _source0
		{
			if _source0.Is_Encrypted() {
				var _0_p _dafny.Sequence = _source0.Get_().(BeaconPart_Encrypted).Prefix
				_ = _0_p
				var _1_b m_BaseBeacon.StandardBeacon = _source0.Get_().(BeaconPart_Encrypted).Beacon
				_ = _1_b
				return (_1_b).GetFields(virtualFields)
			}
		}
		{
			var _2_p _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Prefix
			_ = _2_p
			var _3_n _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Name
			_ = _3_n
			var _4_l _dafny.Sequence = _source0.Get_().(BeaconPart_Signed).Loc
			_ = _4_l
			if (virtualFields).Contains((((_this).Dtor_loc()).Select(0).(m_TermLoc.Selector)).Dtor_key()) {
				return ((virtualFields).Get((((_this).Dtor_loc()).Select(0).(m_TermLoc.Selector)).Dtor_key()).(m_DdbVirtualFields.VirtField)).GetFields()
			} else {
				return _dafny.SeqOf((((_this).Dtor_loc()).Select(0).(m_TermLoc.Selector)).Dtor_key())
			}
		}
	}
}

// End of datatype BeaconPart

// Definition of datatype ConstructorPart
type ConstructorPart struct {
	Data_ConstructorPart_
}

func (_this ConstructorPart) Get_() Data_ConstructorPart_ {
	return _this.Data_ConstructorPart_
}

type Data_ConstructorPart_ interface {
	isConstructorPart()
}

type CompanionStruct_ConstructorPart_ struct {
}

var Companion_ConstructorPart_ = CompanionStruct_ConstructorPart_{}

type ConstructorPart_ConstructorPart struct {
	Part     BeaconPart
	Required bool
}

func (ConstructorPart_ConstructorPart) isConstructorPart() {}

func (CompanionStruct_ConstructorPart_) Create_ConstructorPart_(Part BeaconPart, Required bool) ConstructorPart {
	return ConstructorPart{ConstructorPart_ConstructorPart{Part, Required}}
}

func (_this ConstructorPart) Is_ConstructorPart() bool {
	_, ok := _this.Get_().(ConstructorPart_ConstructorPart)
	return ok
}

func (CompanionStruct_ConstructorPart_) Default() ConstructorPart {
	return Companion_ConstructorPart_.Create_ConstructorPart_(Companion_BeaconPart_.Default(), false)
}

func (_this ConstructorPart) Dtor_part() BeaconPart {
	return _this.Get_().(ConstructorPart_ConstructorPart).Part
}

func (_this ConstructorPart) Dtor_required() bool {
	return _this.Get_().(ConstructorPart_ConstructorPart).Required
}

func (_this ConstructorPart) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ConstructorPart_ConstructorPart:
		{
			return "CompoundBeacon.ConstructorPart.ConstructorPart" + "(" + _dafny.String(data.Part) + ", " + _dafny.String(data.Required) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ConstructorPart) Equals(other ConstructorPart) bool {
	switch data1 := _this.Get_().(type) {
	case ConstructorPart_ConstructorPart:
		{
			data2, ok := other.Get_().(ConstructorPart_ConstructorPart)
			return ok && data1.Part.Equals(data2.Part) && data1.Required == data2.Required
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ConstructorPart) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ConstructorPart)
	return ok && _this.Equals(typed)
}

func Type_ConstructorPart_() _dafny.TypeDescriptor {
	return type_ConstructorPart_{}
}

type type_ConstructorPart_ struct {
}

func (_this type_ConstructorPart_) Default() interface{} {
	return Companion_ConstructorPart_.Default()
}

func (_this type_ConstructorPart_) String() string {
	return "CompoundBeacon.ConstructorPart"
}
func (_this ConstructorPart) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ConstructorPart{}

// End of datatype ConstructorPart

// Definition of class ConstructorPartList
type ConstructorPartList struct {
}

func New_ConstructorPartList_() *ConstructorPartList {
	_this := ConstructorPartList{}

	return &_this
}

type CompanionStruct_ConstructorPartList_ struct {
}

var Companion_ConstructorPartList_ = CompanionStruct_ConstructorPartList_{}

func (*ConstructorPartList) String() string {
	return "CompoundBeacon.ConstructorPartList"
}

// End of class ConstructorPartList

func Type_ConstructorPartList_() _dafny.TypeDescriptor {
	return type_ConstructorPartList_{}
}

type type_ConstructorPartList_ struct {
}

func (_this type_ConstructorPartList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_ConstructorPartList_) String() string {
	return "CompoundBeacon.ConstructorPartList"
}
func (_this *CompanionStruct_ConstructorPartList_) Is_(__source _dafny.Sequence) bool {
	var _5_x _dafny.Sequence = (__source)
	_ = _5_x
	return (_dafny.IntOfUint32((_5_x).Cardinality())).Sign() == 1
}

// Definition of datatype Constructor
type Constructor struct {
	Data_Constructor_
}

func (_this Constructor) Get_() Data_Constructor_ {
	return _this.Data_Constructor_
}

type Data_Constructor_ interface {
	isConstructor()
}

type CompanionStruct_Constructor_ struct {
}

var Companion_Constructor_ = CompanionStruct_Constructor_{}

type Constructor_Constructor struct {
	Parts _dafny.Sequence
}

func (Constructor_Constructor) isConstructor() {}

func (CompanionStruct_Constructor_) Create_Constructor_(Parts _dafny.Sequence) Constructor {
	return Constructor{Constructor_Constructor{Parts}}
}

func (_this Constructor) Is_Constructor() bool {
	_, ok := _this.Get_().(Constructor_Constructor)
	return ok
}

func (CompanionStruct_Constructor_) Default() Constructor {
	return Companion_Constructor_.Create_Constructor_(_dafny.EmptySeq)
}

func (_this Constructor) Dtor_parts() _dafny.Sequence {
	return _this.Get_().(Constructor_Constructor).Parts
}

func (_this Constructor) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Constructor_Constructor:
		{
			return "CompoundBeacon.Constructor.Constructor" + "(" + _dafny.String(data.Parts) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Constructor) Equals(other Constructor) bool {
	switch data1 := _this.Get_().(type) {
	case Constructor_Constructor:
		{
			data2, ok := other.Get_().(Constructor_Constructor)
			return ok && data1.Parts.Equals(data2.Parts)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Constructor) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Constructor)
	return ok && _this.Equals(typed)
}

func Type_Constructor_() _dafny.TypeDescriptor {
	return type_Constructor_{}
}

type type_Constructor_ struct {
}

func (_this type_Constructor_) Default() interface{} {
	return Companion_Constructor_.Default()
}

func (_this type_Constructor_) String() string {
	return "CompoundBeacon.Constructor"
}
func (_this Constructor) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Constructor{}

func (_this Constructor) GetReqParts() _dafny.Set {
	{
		return func() _dafny.Set {
			var _coll0 = _dafny.NewBuilder()
			_ = _coll0
			for _iter26 := _dafny.Iterate(((_this).Dtor_parts()).Elements()); ; {
				_compr_0, _ok26 := _iter26()
				if !_ok26 {
					break
				}
				var _0_k ConstructorPart
				_0_k = interface{}(_compr_0).(ConstructorPart)
				if (_dafny.Companion_Sequence_.Contains((_this).Dtor_parts(), _0_k)) && ((_0_k).Dtor_required()) {
					_coll0.Add((_0_k).Dtor_part())
				}
			}
			return _coll0.ToSet()
		}()
	}
}

// End of datatype Constructor

// Definition of class ConstructorList
type ConstructorList struct {
}

func New_ConstructorList_() *ConstructorList {
	_this := ConstructorList{}

	return &_this
}

type CompanionStruct_ConstructorList_ struct {
}

var Companion_ConstructorList_ = CompanionStruct_ConstructorList_{}

func (*ConstructorList) String() string {
	return "CompoundBeacon.ConstructorList"
}

// End of class ConstructorList

func Type_ConstructorList_() _dafny.TypeDescriptor {
	return type_ConstructorList_{}
}

type type_ConstructorList_ struct {
}

func (_this type_ConstructorList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_ConstructorList_) String() string {
	return "CompoundBeacon.ConstructorList"
}
func (_this *CompanionStruct_ConstructorList_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return (_dafny.IntOfUint32((_1_x).Cardinality())).Sign() == 1
}

// Definition of class ValidCompoundBeacon
type ValidCompoundBeacon struct {
}

func New_ValidCompoundBeacon_() *ValidCompoundBeacon {
	_this := ValidCompoundBeacon{}

	return &_this
}

type CompanionStruct_ValidCompoundBeacon_ struct {
}

var Companion_ValidCompoundBeacon_ = CompanionStruct_ValidCompoundBeacon_{}

func (*ValidCompoundBeacon) String() string {
	return "CompoundBeacon.ValidCompoundBeacon"
}

// End of class ValidCompoundBeacon

func Type_ValidCompoundBeacon_() _dafny.TypeDescriptor {
	return type_ValidCompoundBeacon_{}
}

type type_ValidCompoundBeacon_ struct {
}

func (_this type_ValidCompoundBeacon_) Default() interface{} {
	return Companion_CompoundBeacon_.Default()
}

func (_this type_ValidCompoundBeacon_) String() string {
	return "CompoundBeacon.ValidCompoundBeacon"
}

// Definition of datatype CompoundBeacon
type CompoundBeacon struct {
	Data_CompoundBeacon_
}

func (_this CompoundBeacon) Get_() Data_CompoundBeacon_ {
	return _this.Data_CompoundBeacon_
}

type Data_CompoundBeacon_ interface {
	isCompoundBeacon()
}

type CompanionStruct_CompoundBeacon_ struct {
}

var Companion_CompoundBeacon_ = CompanionStruct_CompoundBeacon_{}

type CompoundBeacon_CompoundBeacon struct {
	Base      m_BaseBeacon.BeaconBase
	Split     _dafny.Char
	Parts     _dafny.Sequence
	NumSigned _dafny.Int
	Construct _dafny.Sequence
}

func (CompoundBeacon_CompoundBeacon) isCompoundBeacon() {}

func (CompanionStruct_CompoundBeacon_) Create_CompoundBeacon_(Base m_BaseBeacon.BeaconBase, Split _dafny.Char, Parts _dafny.Sequence, NumSigned _dafny.Int, Construct _dafny.Sequence) CompoundBeacon {
	return CompoundBeacon{CompoundBeacon_CompoundBeacon{Base, Split, Parts, NumSigned, Construct}}
}

func (_this CompoundBeacon) Is_CompoundBeacon() bool {
	_, ok := _this.Get_().(CompoundBeacon_CompoundBeacon)
	return ok
}

func (CompanionStruct_CompoundBeacon_) Default() CompoundBeacon {
	return Companion_CompoundBeacon_.Create_CompoundBeacon_(m_BaseBeacon.Companion_BeaconBase_.Default(), _dafny.Char('D'), _dafny.EmptySeq, _dafny.Zero, _dafny.EmptySeq)
}

func (_this CompoundBeacon) Dtor_base() m_BaseBeacon.BeaconBase {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Base
}

func (_this CompoundBeacon) Dtor_split() _dafny.Char {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Split
}

func (_this CompoundBeacon) Dtor_parts() _dafny.Sequence {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Parts
}

func (_this CompoundBeacon) Dtor_numSigned() _dafny.Int {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).NumSigned
}

func (_this CompoundBeacon) Dtor_construct() _dafny.Sequence {
	return _this.Get_().(CompoundBeacon_CompoundBeacon).Construct
}

func (_this CompoundBeacon) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CompoundBeacon_CompoundBeacon:
		{
			return "CompoundBeacon.CompoundBeacon.CompoundBeacon" + "(" + _dafny.String(data.Base) + ", " + _dafny.String(data.Split) + ", " + _dafny.String(data.Parts) + ", " + _dafny.String(data.NumSigned) + ", " + _dafny.String(data.Construct) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CompoundBeacon) Equals(other CompoundBeacon) bool {
	switch data1 := _this.Get_().(type) {
	case CompoundBeacon_CompoundBeacon:
		{
			data2, ok := other.Get_().(CompoundBeacon_CompoundBeacon)
			return ok && data1.Base.Equals(data2.Base) && data1.Split == data2.Split && data1.Parts.Equals(data2.Parts) && data1.NumSigned.Cmp(data2.NumSigned) == 0 && data1.Construct.Equals(data2.Construct)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CompoundBeacon) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CompoundBeacon)
	return ok && _this.Equals(typed)
}

func Type_CompoundBeacon_() _dafny.TypeDescriptor {
	return type_CompoundBeacon_{}
}

type type_CompoundBeacon_ struct {
}

func (_this type_CompoundBeacon_) Default() interface{} {
	return Companion_CompoundBeacon_.Default()
}

func (_this type_CompoundBeacon_) String() string {
	return "CompoundBeacon.CompoundBeacon"
}
func (_this CompoundBeacon) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CompoundBeacon{}

func (_this CompoundBeacon) HasBeacon2(parts _dafny.Sequence, name _dafny.Sequence) bool {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((parts).Cardinality())).Sign() == 0 {
			return false
		} else if _dafny.Companion_Sequence_.Equal(((parts).Select(0).(BeaconPart)).GetName(), name) {
			return true
		} else {
			var _in0 CompoundBeacon = _this
			_ = _in0
			var _in1 _dafny.Sequence = (parts).Drop(1)
			_ = _in1
			var _in2 _dafny.Sequence = name
			_ = _in2
			_this = _in0

			parts = _in1
			name = _in2
			goto TAIL_CALL_START
		}
	}
}
func (_this CompoundBeacon) HasBeacon(name _dafny.Sequence) bool {
	{
		return (_this).HasBeacon2((_this).Dtor_parts(), name)
	}
}
func (_this CompoundBeacon) IsEncrypted() bool {
	{
		return ((_this).Dtor_numSigned()).Cmp(_dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())) < 0
	}
}
func (_this CompoundBeacon) GetPartFromPrefix(value _dafny.Sequence) m_Wrappers.Result {
	{
		return (_this).PartFromPrefix((_this).Dtor_parts(), value)
	}
}
func (_this CompoundBeacon) PartsToString(p _dafny.Sequence) _dafny.Sequence {
	{
		var _0_beaconParts _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer94 func(BeaconPart) _dafny.Sequence) func(interface{}) interface{} {
			return func(arg125 interface{}) interface{} {
				return coer94(arg125.(BeaconPart))
			}
		}(func(_1_s BeaconPart) _dafny.Sequence {
			return (_1_s).GetPrefix()
		}), p)
		_ = _0_beaconParts
		if (_dafny.IntOfUint32((_0_beaconParts).Cardinality())).Sign() == 0 {
			return _dafny.SeqOfString("")
		} else {
			return m_StandardLibrary.Companion_Default___.Join(_0_beaconParts, _dafny.SeqOfString(""))
		}
	}
}
func (_this CompoundBeacon) CPartToString(s ConstructorPart) _dafny.Sequence {
	{
		if (s).Dtor_required() {
			return ((s).Dtor_part()).GetPrefix()
		} else {
			return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("["), ((s).Dtor_part()).GetPrefix()), _dafny.SeqOfString("]"))
		}
	}
}
func (_this CompoundBeacon) CPartsToString(p _dafny.Sequence) _dafny.Sequence {
	{
		var _0_beaconParts _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer95 func(ConstructorPart) _dafny.Sequence) func(interface{}) interface{} {
			return func(arg126 interface{}) interface{} {
				return coer95(arg126.(ConstructorPart))
			}
		}(func(_1_s ConstructorPart) _dafny.Sequence {
			return (_this).CPartToString(_1_s)
		}), p)
		_ = _0_beaconParts
		if (_dafny.IntOfUint32((_0_beaconParts).Cardinality())).Sign() == 0 {
			return _dafny.SeqOfString("")
		} else {
			return m_StandardLibrary.Companion_Default___.Join(_0_beaconParts, _dafny.SeqOfString(""))
		}
	}
}
func (_this CompoundBeacon) CListToString(p _dafny.Sequence) _dafny.Sequence {
	{
		var _0_beaconParts _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer96 func(Constructor) _dafny.Sequence) func(interface{}) interface{} {
			return func(arg127 interface{}) interface{} {
				return coer96(arg127.(Constructor))
			}
		}(func(_1_s Constructor) _dafny.Sequence {
			return (_this).CPartsToString((_1_s).Dtor_parts())
		}), p)
		_ = _0_beaconParts
		return m_StandardLibrary.Companion_Default___.Join(_0_beaconParts, _dafny.SeqOfString(", "))
	}
}
func (_this CompoundBeacon) CanConstruct(con _dafny.Sequence, inParts _dafny.Sequence, matched bool) bool {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((inParts).Cardinality())).Sign() == 0 {
			return true
		} else if (_dafny.IntOfUint32((con).Cardinality())).Sign() == 0 {
			return false
		} else if (((con).Select(0).(ConstructorPart)).Dtor_part()).Equals((inParts).Select(0).(BeaconPart)) {
			var _in0 CompoundBeacon = _this
			_ = _in0
			var _in1 _dafny.Sequence = (con).Drop(1)
			_ = _in1
			var _in2 _dafny.Sequence = (inParts).Drop(1)
			_ = _in2
			var _in3 bool = true
			_ = _in3
			_this = _in0

			con = _in1
			inParts = _in2
			matched = _in3
			goto TAIL_CALL_START
		} else if (!(((con).Select(0).(ConstructorPart)).Dtor_required())) || (!(matched)) {
			var _in4 CompoundBeacon = _this
			_ = _in4
			var _in5 _dafny.Sequence = (con).Drop(1)
			_ = _in5
			var _in6 _dafny.Sequence = inParts
			_ = _in6
			var _in7 bool = matched
			_ = _in7
			_this = _in4

			con = _in5
			inParts = _in6
			matched = _in7
			goto TAIL_CALL_START
		} else {
			return false
		}
	}
}
func (_this CompoundBeacon) IsValidPartOrder(candidates _dafny.Sequence, inParts _dafny.Sequence) bool {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((candidates).Cardinality())).Sign() == 0 {
			return false
		} else if (_this).CanConstruct(((candidates).Select(0).(Constructor)).Dtor_parts(), inParts, false) {
			return true
		} else {
			var _in0 CompoundBeacon = _this
			_ = _in0
			var _in1 _dafny.Sequence = (candidates).Drop(1)
			_ = _in1
			var _in2 _dafny.Sequence = inParts
			_ = _in2
			_this = _in0

			candidates = _in1
			inParts = _in2
			goto TAIL_CALL_START
		}
	}
}
func (_this CompoundBeacon) ValidatePartOrder(inParts _dafny.Sequence, orig _dafny.Sequence) m_Wrappers.Result {
	{
		if (_this).IsValidPartOrder((_this).Dtor_construct(), inParts) {
			return m_Wrappers.Companion_Result_.Create_Success_(true)
		} else {
			var _0_msg _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Compound Beacon value '"), orig), _dafny.SeqOfString("' cannot be constructed from any available constructor for ")), ((_this).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" value parsed as ")), (_this).PartsToString(inParts)), _dafny.SeqOfString(" available constructors are ")), (_this).CListToString((_this).Dtor_construct())), _dafny.SeqOfString("."))
			_ = _0_msg
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_0_msg))
		}
	}
}
func (_this CompoundBeacon) PartFromPrefix(p _dafny.Sequence, value _dafny.Sequence) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((p).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Value "), value), _dafny.SeqOfString(" for beacon ")), ((_this).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" does not match the prefix of any configured part."))))
		} else if _dafny.Companion_Sequence_.IsPrefixOf(((p).Select(0).(BeaconPart)).Dtor_prefix(), value) {
			return m_Wrappers.Companion_Result_.Create_Success_((p).Select(0).(BeaconPart))
		} else {
			var _in0 CompoundBeacon = _this
			_ = _in0
			var _in1 _dafny.Sequence = (p).Drop(1)
			_ = _in1
			var _in2 _dafny.Sequence = value
			_ = _in2
			_this = _in0

			p = _in1
			value = _in2
			goto TAIL_CALL_START
		}
	}
}
func (_this CompoundBeacon) SkipSignedPieces(pieces _dafny.Sequence) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((pieces).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(pieces)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (_this).PartFromPrefix((_this).Dtor_parts(), (pieces).Select(0).(_dafny.Sequence))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_p BeaconPart = (_0_valueOrError0).Extract().(BeaconPart)
				_ = _1_p
				if (_1_p).Is_Encrypted() {
					return m_Wrappers.Companion_Result_.Create_Success_(pieces)
				} else {
					var _in0 CompoundBeacon = _this
					_ = _in0
					var _in1 _dafny.Sequence = (pieces).Drop(1)
					_ = _in1
					_this = _in0

					pieces = _in1
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_this CompoundBeacon) IsLessThanComparable(pieces _dafny.Sequence) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Result = (_this).SkipSignedPieces(pieces)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_rest _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_rest
			if (_dafny.IntOfUint32((_1_rest).Cardinality())).Sign() == 0 {
				return m_Wrappers.Companion_Result_.Create_Success_(true)
			} else if (_dafny.IntOfUint32((_1_rest).Cardinality())).Cmp(_dafny.One) != 0 {
				return m_Wrappers.Companion_Result_.Create_Success_(false)
			} else {
				var _2_valueOrError1 m_Wrappers.Result = (_this).PartFromPrefix((_this).Dtor_parts(), (_1_rest).Select(0).(_dafny.Sequence))
				_ = _2_valueOrError1
				if (_2_valueOrError1).IsFailure() {
					return (_2_valueOrError1).PropagateFailure()
				} else {
					var _3_p BeaconPart = (_2_valueOrError1).Extract().(BeaconPart)
					_ = _3_p
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Equal((_3_p).Dtor_prefix(), (_1_rest).Select(0).(_dafny.Sequence)))
				}
			}
		}
	}
}
func (_this CompoundBeacon) GetFields(virtualFields _dafny.Map) _dafny.Sequence {
	{
		return m_StandardLibrary_Sequence.Companion_Default___.Flatten(m_Seq.Companion_Default___.Map(func(coer97 func(BeaconPart) _dafny.Sequence) func(interface{}) interface{} {
			return func(arg128 interface{}) interface{} {
				return coer97(arg128.(BeaconPart))
			}
		}((func(_0_virtualFields _dafny.Map) func(BeaconPart) _dafny.Sequence {
			return func(_1_p BeaconPart) _dafny.Sequence {
				return (_1_p).GetFields(_0_virtualFields)
			}
		})(virtualFields)), (_this).Dtor_parts()), _dafny.Zero, _dafny.SeqOf())
	}
}
func (_this CompoundBeacon) FindAndCalcPart(value _dafny.Sequence, keys m_DynamoDbEncryptionUtil.MaybeKeyMap) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Result = (_this).PartFromPrefix((_this).Dtor_parts(), value)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_part BeaconPart = (_0_valueOrError0).Extract().(BeaconPart)
			_ = _1_part
			return (_this).PartValueCalc((value).Drop((_dafny.IntOfUint32(((_1_part).Dtor_prefix()).Cardinality())).Uint32()), keys, _1_part)
		}
	}
}
func (_this CompoundBeacon) JustPrefix(value _dafny.Sequence) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Result = (_this).PartFromPrefix((_this).Dtor_parts(), value)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_part BeaconPart = (_0_valueOrError0).Extract().(BeaconPart)
			_ = _1_part
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Equal(value, (_1_part).Dtor_prefix()))
		}
	}
}
func (_this CompoundBeacon) GetBeaconValue(value m_ComAmazonawsDynamodbTypes.AttributeValue, keys m_DynamoDbEncryptionUtil.MaybeKeyMap, forEquality bool) m_Wrappers.Result {
	{
		if !((value).Is_S()) {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("CompoundBeacon "), ((_this).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" can only be queried as a string, not as ")), m_DynamoDbEncryptionUtil.Companion_Default___.AttrTypeToStr(value))))
		} else {
			var _0_parts _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split((value).Dtor_S(), (_this).Dtor_split())
			_ = _0_parts
			var _1_valueOrError0 m_Wrappers.Result = m_StandardLibrary_Sequence.Companion_Default___.MapWithResult(func(coer98 func(_dafny.Sequence) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
				return func(arg129 interface{}) m_Wrappers.Result {
					return coer98(arg129.(_dafny.Sequence))
				}
			}(func(_2_s _dafny.Sequence) m_Wrappers.Result {
				return (_this).GetPartFromPrefix(_2_s)
			}), _0_parts, _dafny.Zero, _dafny.SeqOf())
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _3_partsUsed _dafny.Sequence = (_1_valueOrError0).Extract().(_dafny.Sequence)
				_ = _3_partsUsed
				var _4_valueOrError1 m_Wrappers.Result = (_this).ValidatePartOrder(_3_partsUsed, (value).Dtor_S())
				_ = _4_valueOrError1
				if (_4_valueOrError1).IsFailure() {
					return (_4_valueOrError1).PropagateFailure()
				} else {
					var _5___v1 bool = (_4_valueOrError1).Extract().(bool)
					_ = _5___v1
					var _6_valueOrError2 m_Wrappers.Result = m_StandardLibrary_Sequence.Companion_Default___.MapWithResult(func(coer99 func(_dafny.Sequence) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
						return func(arg130 interface{}) m_Wrappers.Result {
							return coer99(arg130.(_dafny.Sequence))
						}
					}((func(_7_keys m_DynamoDbEncryptionUtil.MaybeKeyMap) func(_dafny.Sequence) m_Wrappers.Result {
						return func(_8_s _dafny.Sequence) m_Wrappers.Result {
							return (_this).FindAndCalcPart(_8_s, _7_keys)
						}
					})(keys)), _0_parts, _dafny.Zero, _dafny.SeqOf())
					_ = _6_valueOrError2
					if (_6_valueOrError2).IsFailure() {
						return (_6_valueOrError2).PropagateFailure()
					} else {
						var _9_beaconParts _dafny.Sequence = (_6_valueOrError2).Extract().(_dafny.Sequence)
						_ = _9_beaconParts
						var _10_valueOrError3 m_Wrappers.Result = (_this).JustPrefix(m_Seq.Companion_Default___.Last(_0_parts).(_dafny.Sequence))
						_ = _10_valueOrError3
						if (_10_valueOrError3).IsFailure() {
							return (_10_valueOrError3).PropagateFailure()
						} else {
							var _11_lastIsPrefix bool = (_10_valueOrError3).Extract().(bool)
							_ = _11_lastIsPrefix
							if (!(forEquality)) && (_11_lastIsPrefix) {
								var _12_result _dafny.Sequence = m_StandardLibrary.Companion_Default___.Join(_dafny.Companion_Sequence_.Concatenate((_9_beaconParts).Take(((_dafny.IntOfUint32((_0_parts).Cardinality())).Minus(_dafny.One)).Uint32()), _dafny.SeqOf(m_Seq.Companion_Default___.Last(_0_parts).(_dafny.Sequence))), _dafny.SeqOfChars((_this).Dtor_split()))
								_ = _12_result
								return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_12_result))
							} else {
								var _13_result _dafny.Sequence = m_StandardLibrary.Companion_Default___.Join(_9_beaconParts, _dafny.SeqOfChars((_this).Dtor_split()))
								_ = _13_result
								return m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_13_result))
							}
						}
					}
				}
			}
		}
	}
}
func (_this CompoundBeacon) TryConstructor(consFields _dafny.Sequence, item _dafny.Map, vf _dafny.Map, keys m_DynamoDbEncryptionUtil.MaybeKeyMap, acc _dafny.Sequence) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((consFields).Cardinality())).Sign() == 0 {
			if (_dafny.IntOfUint32((acc).Cardinality())).Sign() == 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error : Empty beacon created.")))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(acc))
			}
		} else {
			var _0_part BeaconPart = ((consFields).Select(0).(ConstructorPart)).Dtor_part()
			_ = _0_part
			var _1_valueOrError0 m_Wrappers.Result = (_0_part).GetString(item, vf)
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _2_strValue m_Wrappers.Option = (_1_valueOrError0).Extract().(m_Wrappers.Option)
				_ = _2_strValue
				if (_2_strValue).Is_Some() {
					var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!_dafny.Companion_Sequence_.Contains((_2_strValue).Dtor_value().(_dafny.Sequence), (_this).Dtor_split()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Part "), (_0_part).GetName()), _dafny.SeqOfString(" for beacon ")), ((_this).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" has value '")), (_2_strValue).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString("' which contains the split character ")), _dafny.SeqOfChars((_this).Dtor_split())), _dafny.SeqOfString("'."))))
					_ = _3_valueOrError1
					if (_3_valueOrError1).IsFailure() {
						return (_3_valueOrError1).PropagateFailure()
					} else {
						var _4_valueOrError2 m_Wrappers.Result = (func() m_Wrappers.Result {
							if (keys).Is_DontUseKeys() {
								return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate((_0_part).Dtor_prefix(), (_2_strValue).Dtor_value().(_dafny.Sequence)))
							}
							return (_this).PartValueCalc((_2_strValue).Dtor_value().(_dafny.Sequence), keys, _0_part)
						})()
						_ = _4_valueOrError2
						if (_4_valueOrError2).IsFailure() {
							return (_4_valueOrError2).PropagateFailure()
						} else {
							var _5_val _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
							_ = _5_val
							if (_dafny.IntOfUint32((acc).Cardinality())).Sign() == 0 {
								var _in0 CompoundBeacon = _this
								_ = _in0
								var _in1 _dafny.Sequence = (consFields).Drop(1)
								_ = _in1
								var _in2 _dafny.Map = item
								_ = _in2
								var _in3 _dafny.Map = vf
								_ = _in3
								var _in4 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
								_ = _in4
								var _in5 _dafny.Sequence = _5_val
								_ = _in5
								_this = _in0

								consFields = _in1
								item = _in2
								vf = _in3
								keys = _in4
								acc = _in5
								goto TAIL_CALL_START
							} else {
								var _in6 CompoundBeacon = _this
								_ = _in6
								var _in7 _dafny.Sequence = (consFields).Drop(1)
								_ = _in7
								var _in8 _dafny.Map = item
								_ = _in8
								var _in9 _dafny.Map = vf
								_ = _in9
								var _in10 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
								_ = _in10
								var _in11 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOfChars((_this).Dtor_split())), _5_val)
								_ = _in11
								_this = _in6

								consFields = _in7
								item = _in8
								vf = _in9
								keys = _in10
								acc = _in11
								goto TAIL_CALL_START
							}
						}
					}
				} else if ((consFields).Select(0).(ConstructorPart)).Dtor_required() {
					return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
				} else {
					var _in12 CompoundBeacon = _this
					_ = _in12
					var _in13 _dafny.Sequence = (consFields).Drop(1)
					_ = _in13
					var _in14 _dafny.Map = item
					_ = _in14
					var _in15 _dafny.Map = vf
					_ = _in15
					var _in16 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
					_ = _in16
					var _in17 _dafny.Sequence = acc
					_ = _in17
					_this = _in12

					consFields = _in13
					item = _in14
					vf = _in15
					keys = _in16
					acc = _in17
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_this CompoundBeacon) TryConstructors(construct _dafny.Sequence, item _dafny.Map, vf _dafny.Map, keys m_DynamoDbEncryptionUtil.MaybeKeyMap) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((construct).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (_this).TryConstructor(((construct).Select(0).(Constructor)).Dtor_parts(), item, vf, keys, _dafny.SeqOfString(""))
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_x m_Wrappers.Option = (_0_valueOrError0).Extract().(m_Wrappers.Option)
				_ = _1_x
				if (_1_x).Is_Some() {
					return m_Wrappers.Companion_Result_.Create_Success_(_1_x)
				} else {
					var _in0 CompoundBeacon = _this
					_ = _in0
					var _in1 _dafny.Sequence = (construct).Drop(1)
					_ = _in1
					var _in2 _dafny.Map = item
					_ = _in2
					var _in3 _dafny.Map = vf
					_ = _in3
					var _in4 m_DynamoDbEncryptionUtil.MaybeKeyMap = keys
					_ = _in4
					_this = _in0

					construct = _in1
					item = _in2
					vf = _in3
					keys = _in4
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_this CompoundBeacon) Hash(item _dafny.Map, vf _dafny.Map, keys m_DynamoDbEncryptionUtil.MaybeKeyMap) m_Wrappers.Result {
	{
		return (_this).TryConstructors((_this).Dtor_construct(), item, vf, keys)
	}
}
func (_this CompoundBeacon) GetNaked(item _dafny.Map, vf _dafny.Map) m_Wrappers.Result {
	{
		return (_this).TryConstructors((_this).Dtor_construct(), item, vf, m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_DontUseKeys_())
	}
}
func (_this CompoundBeacon) FindPart(val _dafny.Sequence) m_Wrappers.Result {
	{
		var _0_thePart _dafny.Sequence = m_Seq.Companion_Default___.Filter(func(coer100 func(BeaconPart) bool) func(interface{}) bool {
			return func(arg131 interface{}) bool {
				return coer100(arg131.(BeaconPart))
			}
		}((func(_1_val _dafny.Sequence) func(BeaconPart) bool {
			return func(_2_x BeaconPart) bool {
				return _dafny.Companion_Sequence_.IsPrefixOf((_2_x).Dtor_prefix(), _1_val)
			}
		})(val)), (_this).Dtor_parts())
		_ = _0_thePart
		if (_dafny.IntOfUint32((_0_thePart).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("No part found in beacon "), ((_this).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" match prefix ")), val)))
		} else if (_dafny.IntOfUint32((_0_thePart).Cardinality())).Cmp(_dafny.One) > 0 {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Internal error. Multiple parts for beacon "), ((_this).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" matched prefix of ")), val)))
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_((_0_thePart).Select(0).(BeaconPart))
		}
	}
}
func (_this CompoundBeacon) GetPart(val _dafny.Sequence, keys _dafny.Map) m_Wrappers.Result {
	{
		var _0_pieces _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(val, (_this).Dtor_split())
		_ = _0_pieces
		return (_this).CalcParts(_0_pieces, keys, _dafny.SeqOfChars())
	}
}
func (_this CompoundBeacon) CalcPart(piece _dafny.Sequence, keys _dafny.Map) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Result = (_this).FindPart(piece)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_thePart BeaconPart = (_0_valueOrError0).Extract().(BeaconPart)
			_ = _1_thePart
			return (_this).PartValueCalc(piece, m_DynamoDbEncryptionUtil.Companion_MaybeKeyMap_.Create_Keys_(keys), _1_thePart)
		}
	}
}
func (_this CompoundBeacon) CalcParts(pieces _dafny.Sequence, keys _dafny.Map, acc _dafny.Sequence) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32((pieces).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(acc)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (_this).CalcPart((pieces).Select(0).(_dafny.Sequence), keys)
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1_theBeacon _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
				_ = _1_theBeacon
				if (_dafny.IntOfUint32((acc).Cardinality())).Sign() == 0 {
					var _in0 CompoundBeacon = _this
					_ = _in0
					var _in1 _dafny.Sequence = (pieces).Drop(1)
					_ = _in1
					var _in2 _dafny.Map = keys
					_ = _in2
					var _in3 _dafny.Sequence = _1_theBeacon
					_ = _in3
					_this = _in0

					pieces = _in1
					keys = _in2
					acc = _in3
					goto TAIL_CALL_START
				} else {
					var _in4 CompoundBeacon = _this
					_ = _in4
					var _in5 _dafny.Sequence = (pieces).Drop(1)
					_ = _in5
					var _in6 _dafny.Map = keys
					_ = _in6
					var _in7 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOfChars((_this).Dtor_split())), _1_theBeacon)
					_ = _in7
					_this = _in4

					pieces = _in5
					keys = _in6
					acc = _in7
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_static CompanionStruct_CompoundBeacon_) OkPrefixStringPair(x _dafny.Sequence, y _dafny.Sequence) bool {
	return (!(_dafny.Companion_Sequence_.IsPrefixOf(x, y))) && (!(_dafny.Companion_Sequence_.IsPrefixOf(y, x)))
}
func (_this CompoundBeacon) OkPrefixPair(pos1 _dafny.Int, pos2 _dafny.Int) bool {
	{
		return ((pos1).Cmp(pos2) == 0) || (Companion_CompoundBeacon_.OkPrefixStringPair((((_this).Dtor_parts()).Select((pos1).Uint32()).(BeaconPart)).Dtor_prefix(), (((_this).Dtor_parts()).Select((pos2).Uint32()).(BeaconPart)).Dtor_prefix()))
	}
}
func (_this CompoundBeacon) CheckOnePrefixPart(pos1 _dafny.Int, pos2 _dafny.Int) m_Wrappers.Result {
	{
		if !((_this).OkPrefixPair(pos1, pos2)) {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Compound beacon "), ((_this).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" defines part ")), (((_this).Dtor_parts()).Select((pos1).Uint32()).(BeaconPart)).GetName()), _dafny.SeqOfString(" with prefix ")), (((_this).Dtor_parts()).Select((pos1).Uint32()).(BeaconPart)).Dtor_prefix()), _dafny.SeqOfString(" which is incompatible with part ")), (((_this).Dtor_parts()).Select((pos2).Uint32()).(BeaconPart)).GetName()), _dafny.SeqOfString(" which has a prefix of ")), (((_this).Dtor_parts()).Select((pos2).Uint32()).(BeaconPart)).Dtor_prefix()), _dafny.SeqOfString("."))))
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(true)
		}
	}
}
func (_this CompoundBeacon) CheckOnePrefix(pos _dafny.Int) m_Wrappers.Result {
	{
		var _0_partNumbers _dafny.Sequence = _dafny.SeqCreate((_dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())).Uint32(), func(coer101 func(_dafny.Int) _dafny.Int) func(_dafny.Int) interface{} {
			return func(arg132 _dafny.Int) interface{} {
				return coer101(arg132)
			}
		}(func(_1_i _dafny.Int) _dafny.Int {
			return _1_i
		}))
		_ = _0_partNumbers
		var _2_valueOrError0 m_Wrappers.Result = m_StandardLibrary_Sequence.Companion_Default___.MapWithResult(func(coer102 func(_dafny.Int) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
			return func(arg133 interface{}) m_Wrappers.Result {
				return coer102(arg133.(_dafny.Int))
			}
		}((func(_3_pos _dafny.Int) func(_dafny.Int) m_Wrappers.Result {
			return func(_4_p _dafny.Int) m_Wrappers.Result {
				return (_this).CheckOnePrefixPart(_3_pos, _4_p)
			}
		})(pos)), _dafny.SeqCreate((_dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())).Uint32(), func(coer103 func(_dafny.Int) _dafny.Int) func(_dafny.Int) interface{} {
			return func(arg134 _dafny.Int) interface{} {
				return coer103(arg134)
			}
		}(func(_5_i _dafny.Int) _dafny.Int {
			return _5_i
		})), _dafny.Zero, _dafny.SeqOf())
		_ = _2_valueOrError0
		if (_2_valueOrError0).IsFailure() {
			return (_2_valueOrError0).PropagateFailure()
		} else {
			var _6___v2 _dafny.Sequence = (_2_valueOrError0).Extract().(_dafny.Sequence)
			_ = _6___v2
			return m_Wrappers.Companion_Result_.Create_Success_(true)
		}
	}
}
func (_this CompoundBeacon) ValidPrefixSetResultPos(index _dafny.Int) m_Wrappers.Result {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		if (_dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())).Cmp(index) <= 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(true)
		} else {
			var _0_valueOrError0 m_Wrappers.Result = (_this).CheckOnePrefix(index)
			_ = _0_valueOrError0
			if (_0_valueOrError0).IsFailure() {
				return (_0_valueOrError0).PropagateFailure()
			} else {
				var _1___v3 bool = (_0_valueOrError0).Extract().(bool)
				_ = _1___v3
				var _in0 CompoundBeacon = _this
				_ = _in0
				var _in1 _dafny.Int = (index).Plus(_dafny.One)
				_ = _in1
				_this = _in0

				index = _in1
				goto TAIL_CALL_START
			}
		}
	}
}
func (_this CompoundBeacon) ValidPrefixSetResult() m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Result = (_this).ValidPrefixSetResultPos(_dafny.Zero)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1___v4 bool = (_0_valueOrError0).Extract().(bool)
			_ = _1___v4
			if _dafny.Quantifier(_dafny.IntegerRange(_dafny.Zero, _dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())), true, func(_forall_var_0 _dafny.Int) bool {
				var _2_x _dafny.Int
				_2_x = interface{}(_forall_var_0).(_dafny.Int)
				if m__System.Companion_Nat_.Is_(_2_x) {
					return _dafny.Quantifier(_dafny.IntegerRange(_dafny.Zero, _dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())), true, func(_forall_var_1 _dafny.Int) bool {
						var _3_y _dafny.Int
						_3_y = interface{}(_forall_var_1).(_dafny.Int)
						if m__System.Companion_Nat_.Is_(_3_y) {
							return !((((_2_x).Sign() != -1) && ((_2_x).Cmp(_dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())) < 0)) && (((_2_x).Cmp(_3_y) < 0) && ((_3_y).Cmp(_dafny.IntOfUint32(((_this).Dtor_parts()).Cardinality())) < 0))) || ((_this).OkPrefixPair(_2_x, _3_y))
						} else {
							return true
						}
					})
				} else {
					return true
				}
			}) {
				return m_Wrappers.Companion_Result_.Create_Success_(true)
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error")))
			}
		}
	}
}
func (_this CompoundBeacon) PartValueCalc(data _dafny.Sequence, keys m_DynamoDbEncryptionUtil.MaybeKeyMap, part BeaconPart) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!_dafny.Companion_Sequence_.Contains(data, (_this).Dtor_split()), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Value '"), data), _dafny.SeqOfString("' for beacon part ")), (part).GetName()), _dafny.SeqOfString(" contains the split character '")), _dafny.SeqOfChars((_this).Dtor_split())), _dafny.SeqOfString("'."))))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _source0 BeaconPart = part
			_ = _source0
			{
				if _source0.Is_Encrypted() {
					var _1_p _dafny.Sequence = _source0.Get_().(BeaconPart_Encrypted).Prefix
					_ = _1_p
					var _2_b m_BaseBeacon.StandardBeacon = _source0.Get_().(BeaconPart_Encrypted).Beacon
					_ = _2_b
					var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((keys).Is_Keys(), m_DynamoDbEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Need KeyId for beacon "), ((_2_b).Dtor_base()).Dtor_name()), _dafny.SeqOfString(" but no KeyId found in query."))))
					_ = _3_valueOrError1
					if (_3_valueOrError1).IsFailure() {
						return (_3_valueOrError1).PropagateFailure()
					} else {
						var _4_valueOrError2 m_Wrappers.Result = (_2_b).HashStr(data, (keys).Dtor_value())
						_ = _4_valueOrError2
						if (_4_valueOrError2).IsFailure() {
							return (_4_valueOrError2).PropagateFailure()
						} else {
							var _5_hash _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
							_ = _5_hash
							return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate((part).Dtor_prefix(), _5_hash))
						}
					}
				}
			}
			{
				var _6_Signed BeaconPart = _source0
				_ = _6_Signed
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate((part).Dtor_prefix(), data))
			}
		}
	}
}

// End of datatype CompoundBeacon
