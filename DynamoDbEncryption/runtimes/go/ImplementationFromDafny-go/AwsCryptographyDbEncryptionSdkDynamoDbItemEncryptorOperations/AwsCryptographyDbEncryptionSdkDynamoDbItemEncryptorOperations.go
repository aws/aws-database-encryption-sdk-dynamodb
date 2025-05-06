// Package AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations
// Dafny module AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations compiled into Go

package AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations

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
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptorUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbNormalizeNumber"
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
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) AllowedUnsigned(unauthenticatedAttributes m_Wrappers.Option, unauthenticatedPrefix m_Wrappers.Option, attr _dafny.Sequence) bool {
	return ((((unauthenticatedAttributes).Is_Some()) && (_dafny.Companion_Sequence_.Contains((unauthenticatedAttributes).Dtor_value().(_dafny.Sequence), attr))) || (((unauthenticatedPrefix).Is_Some()) && (_dafny.Companion_Sequence_.IsPrefixOf((unauthenticatedPrefix).Dtor_value().(_dafny.Sequence), attr)))) || (_dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbItemEncryptorUtil.Companion_Default___.ReservedPrefix(), attr))
}
func (_static *CompanionStruct_Default___) ForwardCompatibleAttributeAction(attribute _dafny.Sequence, action m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction, unauthenticatedAttributes m_Wrappers.Option, unauthenticatedPrefix m_Wrappers.Option) bool {
	if (action).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()) {
		return Companion_Default___.AllowedUnsigned(unauthenticatedAttributes, unauthenticatedPrefix, attribute)
	} else {
		return !(Companion_Default___.AllowedUnsigned(unauthenticatedAttributes, unauthenticatedPrefix, attribute))
	}
}
func (_static *CompanionStruct_Default___) CryptoActionString(action m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction) _dafny.Sequence {
	if (action).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()) {
		return _dafny.SeqOfString("DO_NOTHING")
	} else if (action).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()) {
		return _dafny.SeqOfString("SIGN_ONLY")
	} else if (action).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()) {
		return _dafny.SeqOfString("SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT")
	} else if (action).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()) {
		return _dafny.SeqOfString("ENCRYPT_AND_SIGN")
	} else {
		return _dafny.SeqOfString("internal error")
	}
}
func (_static *CompanionStruct_Default___) ExplainNotForwardCompatible(attr _dafny.Sequence, action m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction, unauthenticatedAttributes m_Wrappers.Option, unauthenticatedPrefix m_Wrappers.Option) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Attribute "), attr), _dafny.SeqOfString(" is configured as ")), Companion_Default___.CryptoActionString(action)), _dafny.SeqOfString(" but ")), (func() _dafny.Sequence {
		if (action).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()) {
			return _dafny.SeqOfString("it must also be in unauthenticatedAttributes or begin with the unauthenticatedPrefix.")
		}
		return (func() _dafny.Sequence {
			if ((unauthenticatedAttributes).Is_Some()) && (_dafny.Companion_Sequence_.Contains((unauthenticatedAttributes).Dtor_value().(_dafny.Sequence), attr)) {
				return _dafny.SeqOfString("it is also in unauthenticatedAttributes.")
			}
			return (func() _dafny.Sequence {
				if ((unauthenticatedPrefix).Is_Some()) && (_dafny.Companion_Sequence_.IsPrefixOf((unauthenticatedPrefix).Dtor_value().(_dafny.Sequence), attr)) {
					return _dafny.SeqOfString("it also begins with the unauthenticatedPrefix.")
				}
				return _dafny.SeqOfString("it also begins with the reserved prefix.")
			})()
		})()
	})())
}
func (_static *CompanionStruct_Default___) UnknownAttribute(config Config, attr _dafny.Sequence) bool {
	return (Companion_Default___.InSignatureScope(config, attr)) && (!((config).Dtor_attributeActionsOnEncrypt()).Contains(attr))
}
func (_static *CompanionStruct_Default___) InSignatureScope(config Config, attr _dafny.Sequence) bool {
	return !(Companion_Default___.AllowedUnsigned((config).Dtor_allowedUnsignedAttributes(), (config).Dtor_allowedUnsignedAttributePrefix(), attr))
}
func (_static *CompanionStruct_Default___) EncodeName(k _dafny.Sequence) m_Wrappers.Result {
	return Companion_Default___.DDBEncode(_dafny.Companion_Sequence_.Concatenate(m_StructuredEncryptionUtil.Companion_Default___.ATTR__PREFIX(), k))
}
func (_static *CompanionStruct_Default___) MakeEncryptionContextForEncrypt(config Config, item _dafny.Map) m_Wrappers.Result {
	if ((config).Dtor_version()) == (uint8(2)) {
		return Companion_Default___.MakeEncryptionContextV2(config, item)
	} else {
		return Companion_Default___.MakeEncryptionContextV1(config, item)
	}
}
func (_static *CompanionStruct_Default___) MakeEncryptionContextForDecrypt(config Config, header _dafny.Sequence, item _dafny.Map) m_Wrappers.Result {
	if ((header).Select(0).(uint8)) == (uint8(2)) {
		return Companion_Default___.MakeEncryptionContextV2(config, item)
	} else if ((header).Select(0).(uint8)) == (uint8(1)) {
		return Companion_Default___.MakeEncryptionContextV1(config, item)
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("Header attribute has unexpected version number")))
	}
}
func (_static *CompanionStruct_Default___) MakeEncryptionContextV1(config Config, item _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((item).Contains((config).Dtor_partitionKeyName()), Companion_Default___.DDBError(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Partition key "), (config).Dtor_partitionKeyName()), _dafny.SeqOfString(" not found in Item to be encrypted or decrypted"))))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.DDBEncode((config).Dtor_logicalTableName())
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_logicalTableName _dafny.Sequence = (_1_valueOrError1).Extract().(_dafny.Sequence)
			_ = _2_logicalTableName
			var _3_valueOrError2 m_Wrappers.Result = Companion_Default___.DDBEncode((config).Dtor_partitionKeyName())
			_ = _3_valueOrError2
			if (_3_valueOrError2).IsFailure() {
				return (_3_valueOrError2).PropagateFailure()
			} else {
				var _4_partitionName _dafny.Sequence = (_3_valueOrError2).Extract().(_dafny.Sequence)
				_ = _4_partitionName
				var _5_valueOrError3 m_Wrappers.Result = Companion_Default___.EncodeName((config).Dtor_partitionKeyName())
				_ = _5_valueOrError3
				if (_5_valueOrError3).IsFailure() {
					return (_5_valueOrError3).PropagateFailure()
				} else {
					var _6_partitionKeyName _dafny.Sequence = (_5_valueOrError3).Extract().(_dafny.Sequence)
					_ = _6_partitionKeyName
					var _7_partitionKeyValue _dafny.Sequence = m_StructuredEncryptionUtil.Companion_Default___.EncodeTerminal((item).Get((config).Dtor_partitionKeyName()).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
					_ = _7_partitionKeyValue
					if ((config).Dtor_sortKeyName()).Is_None() {
						var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.SetOf(m_DynamoDbItemEncryptorUtil.Companion_Default___.TABLE__NAME(), m_DynamoDbItemEncryptorUtil.Companion_Default___.PARTITION__NAME(), m_DynamoDbItemEncryptorUtil.Companion_Default___.SORT__NAME(), _6_partitionKeyName)).Cardinality()).Cmp(_dafny.IntOfInt64(4)) == 0, m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error")))
						_ = _8_valueOrError4
						if (_8_valueOrError4).IsFailure() {
							return (_8_valueOrError4).PropagateFailure()
						} else {
							var _9_ec _dafny.Map = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.TABLE__NAME(), _2_logicalTableName).UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.PARTITION__NAME(), _4_partitionName).UpdateUnsafe(_6_partitionKeyName, _7_partitionKeyValue)
							_ = _9_ec
							return m_Wrappers.Companion_Result_.Create_Success_(_9_ec)
						}
					} else {
						var _10_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((item).Contains(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)), Companion_Default___.DDBError(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Sort key "), ((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString(" not found in Item to be encrypted or decrypted"))))
						_ = _10_valueOrError5
						if (_10_valueOrError5).IsFailure() {
							return (_10_valueOrError5).PropagateFailure()
						} else {
							var _11_valueOrError6 m_Wrappers.Result = Companion_Default___.DDBEncode(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence))
							_ = _11_valueOrError6
							if (_11_valueOrError6).IsFailure() {
								return (_11_valueOrError6).PropagateFailure()
							} else {
								var _12_sortName _dafny.Sequence = (_11_valueOrError6).Extract().(_dafny.Sequence)
								_ = _12_sortName
								var _13_valueOrError7 m_Wrappers.Result = Companion_Default___.EncodeName(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence))
								_ = _13_valueOrError7
								if (_13_valueOrError7).IsFailure() {
									return (_13_valueOrError7).PropagateFailure()
								} else {
									var _14_sortKeyName _dafny.Sequence = (_13_valueOrError7).Extract().(_dafny.Sequence)
									_ = _14_sortKeyName
									var _15_sortKeyValue _dafny.Sequence = m_StructuredEncryptionUtil.Companion_Default___.EncodeTerminal((item).Get(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
									_ = _15_sortKeyValue
									var _16_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.SetOf(m_DynamoDbItemEncryptorUtil.Companion_Default___.TABLE__NAME(), m_DynamoDbItemEncryptorUtil.Companion_Default___.PARTITION__NAME(), _6_partitionKeyName, m_DynamoDbItemEncryptorUtil.Companion_Default___.SORT__NAME(), _14_sortKeyName)).Cardinality()).Cmp(_dafny.IntOfInt64(5)) == 0, m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error")))
									_ = _16_valueOrError8
									if (_16_valueOrError8).IsFailure() {
										return (_16_valueOrError8).PropagateFailure()
									} else {
										var _17_ec _dafny.Map = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.TABLE__NAME(), _2_logicalTableName).UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.PARTITION__NAME(), _4_partitionName).UpdateUnsafe(_6_partitionKeyName, _7_partitionKeyValue).UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.SORT__NAME(), _12_sortName).UpdateUnsafe(_14_sortKeyName, _15_sortKeyValue)
										_ = _17_ec
										return m_Wrappers.Companion_Result_.Create_Success_(_17_ec)
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
func (_static *CompanionStruct_Default___) MakeEncryptionContextV2(config Config, item _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((item).Contains((config).Dtor_partitionKeyName()), Companion_Default___.DDBError(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Partition key "), (config).Dtor_partitionKeyName()), _dafny.SeqOfString(" not found in Item to be encrypted or decrypted"))))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.DDBEncode((config).Dtor_logicalTableName())
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_logicalTableName _dafny.Sequence = (_1_valueOrError1).Extract().(_dafny.Sequence)
			_ = _2_logicalTableName
			var _3_valueOrError2 m_Wrappers.Result = Companion_Default___.DDBEncode((config).Dtor_partitionKeyName())
			_ = _3_valueOrError2
			if (_3_valueOrError2).IsFailure() {
				return (_3_valueOrError2).PropagateFailure()
			} else {
				var _4_partitionName _dafny.Sequence = (_3_valueOrError2).Extract().(_dafny.Sequence)
				_ = _4_partitionName
				var _5_valueOrError3 m_Wrappers.Result = Companion_Default___.EncodeName((config).Dtor_partitionKeyName())
				_ = _5_valueOrError3
				if (_5_valueOrError3).IsFailure() {
					return (_5_valueOrError3).PropagateFailure()
				} else {
					var _6_partitionKeyName _dafny.Sequence = (_5_valueOrError3).Extract().(_dafny.Sequence)
					_ = _6_partitionKeyName
					if ((config).Dtor_sortKeyName()).Is_None() {
						var _7_ec _dafny.Map = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.TABLE__NAME(), _2_logicalTableName).UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.PARTITION__NAME(), _4_partitionName)
						_ = _7_ec
						return m_Wrappers.Companion_Result_.Create_Success_(_7_ec)
					} else {
						var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((item).Contains(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)), Companion_Default___.DDBError(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Sort key "), ((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString(" not found in Item to be encrypted or decrypted"))))
						_ = _8_valueOrError4
						if (_8_valueOrError4).IsFailure() {
							return (_8_valueOrError4).PropagateFailure()
						} else {
							var _9_valueOrError5 m_Wrappers.Result = Companion_Default___.DDBEncode(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence))
							_ = _9_valueOrError5
							if (_9_valueOrError5).IsFailure() {
								return (_9_valueOrError5).PropagateFailure()
							} else {
								var _10_sortName _dafny.Sequence = (_9_valueOrError5).Extract().(_dafny.Sequence)
								_ = _10_sortName
								var _11_valueOrError6 m_Wrappers.Result = Companion_Default___.EncodeName(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence))
								_ = _11_valueOrError6
								if (_11_valueOrError6).IsFailure() {
									return (_11_valueOrError6).PropagateFailure()
								} else {
									var _12_sortKeyName _dafny.Sequence = (_11_valueOrError6).Extract().(_dafny.Sequence)
									_ = _12_sortKeyName
									var _13_ec _dafny.Map = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.TABLE__NAME(), _2_logicalTableName).UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.PARTITION__NAME(), _4_partitionName).UpdateUnsafe(m_DynamoDbItemEncryptorUtil.Companion_Default___.SORT__NAME(), _10_sortName)
									_ = _13_ec
									return m_Wrappers.Companion_Result_.Create_Success_(_13_ec)
								}
							}
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DDBError(s _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(s)
}
func (_static *CompanionStruct_Default___) DDBEncode(s _dafny.Sequence) m_Wrappers.Result {
	return (m_UTF8.Encode(s)).MapFailure(func(coer55 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg81 interface{}) interface{} {
			return coer55(arg81.(_dafny.Sequence))
		}
	}(func(_0_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return Companion_Default___.DDBError(_0_e)
	}))
}
func (_static *CompanionStruct_Default___) IsVersion2Schema(actions _dafny.Map) bool {
	return _dafny.Quantifier((actions).Keys().Elements(), false, func(_exists_var_0 _dafny.Sequence) bool {
		var _0_x _dafny.Sequence
		_0_x = interface{}(_exists_var_0).(_dafny.Sequence)
		return ((actions).Contains(_0_x)) && (((actions).Get(_0_x).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()))
	})
}
func (_static *CompanionStruct_Default___) VersionFromActions(actions _dafny.Map) uint8 {
	if Companion_Default___.IsVersion2Schema(actions) {
		return uint8(2)
	} else {
		return uint8(1)
	}
}
func (_static *CompanionStruct_Default___) KeyActionFromVersion(version uint8) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction {
	if (version) == (uint8(2)) {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()
	} else {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()
	}
}
func (_static *CompanionStruct_Default___) KeyActionStringFromVersion(version uint8) _dafny.Sequence {
	if (version) == (uint8(2)) {
		return _dafny.SeqOfString("SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT")
	} else {
		return _dafny.SeqOfString("SIGN_ONLY")
	}
}
func (_static *CompanionStruct_Default___) GetCryptoSchemaActionInner(config Config, attr _dafny.Sequence) m_Wrappers.Result {
	if ((config).Dtor_attributeActionsOnEncrypt()).Contains(attr) {
		return m_Wrappers.Companion_Result_.Create_Success_(((config).Dtor_attributeActionsOnEncrypt()).Get(attr).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction))
	} else if !(Companion_Default___.InSignatureScope(config, attr)) {
		return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("No Crypto Action configured for attribute "), attr))
	}
}
func (_static *CompanionStruct_Default___) GetCryptoSchemaAction(config Config, attr _dafny.Sequence) m_Wrappers.Result {
	return Companion_Default___.GetCryptoSchemaActionInner(config, attr)
}
func (_static *CompanionStruct_Default___) GetAuthenticateSchemaAction(config Config, attr _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction {
	if Companion_Default___.InSignatureScope(config, attr) {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_AuthenticateAction_.Create_SIGN_()
	} else {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_AuthenticateAction_.Create_DO__NOT__SIGN_()
	}
}
func (_static *CompanionStruct_Default___) ConfigToCryptoSchema(config Config, item _dafny.Map) m_Wrappers.Result {
	var _0_schema _dafny.Map = func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter22 := _dafny.Iterate((item).Keys().Elements()); ; {
			_compr_0, _ok22 := _iter22()
			if !_ok22 {
				break
			}
			var _1_k _dafny.Sequence
			_1_k = interface{}(_compr_0).(_dafny.Sequence)
			if (item).Contains(_1_k) {
				_coll0.Add(_1_k, Companion_Default___.GetCryptoSchemaAction(config, _1_k))
			}
		}
		return _coll0.ToMap()
	}()
	_ = _0_schema
	var _2_actionMapRes m_Wrappers.Result = m_DynamoToStruct.Companion_Default___.SimplifyMapValue(_0_schema)
	_ = _2_actionMapRes
	return m_DynamoToStruct.Companion_Default___.MapError(_2_actionMapRes)
}
func (_static *CompanionStruct_Default___) ConfigToAuthenticateSchema(config Config, item _dafny.Map) _dafny.Map {
	return func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter23 := _dafny.Iterate((item).Keys().Elements()); ; {
			_compr_0, _ok23 := _iter23()
			if !_ok23 {
				break
			}
			var _0_k _dafny.Sequence
			_0_k = interface{}(_compr_0).(_dafny.Sequence)
			if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_0_k) {
				if (item).Contains(_0_k) {
					_coll0.Add(_0_k, Companion_Default___.GetAuthenticateSchemaAction(config, _0_k))
				}
			}
		}
		return _coll0.ToMap()
	}()
}
func (_static *CompanionStruct_Default___) IsPlaintextItem(ddbItem _dafny.Map) bool {
	return (!(ddbItem).Contains(m_StructuredEncryptionUtil.Companion_Default___.HeaderField())) && (!(ddbItem).Contains(m_StructuredEncryptionUtil.Companion_Default___.FooterField()))
}
func (_static *CompanionStruct_Default___) ConvertCryptoSchemaToAttributeActions(config Config, schema _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((schema).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _1_k _dafny.Sequence
		_1_k = interface{}(_forall_var_0).(_dafny.Sequence)
		if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_1_k) {
			return !((schema).Contains(_1_k)) || (Companion_Default___.InSignatureScope(config, _1_k))
		} else {
			return true
		}
	}), m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.SeqOfString("Received unexpected Crypto Schema: mismatch with signature scope")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((schema).Keys().Elements(), true, func(_forall_var_1 _dafny.Sequence) bool {
			var _3_k _dafny.Sequence
			_3_k = interface{}(_forall_var_1).(_dafny.Sequence)
			return !((schema).Contains(_3_k)) || (m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_3_k))
		}), m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.SeqOfString("Received unexpected Crypto Schema: Invalid attribute names")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(schema)
		}
	}
}
func (_static *CompanionStruct_Default___) GetItemNames(item _dafny.Map) _dafny.Sequence {
	var _0_keys _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((item).Keys(), func(coer56 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg82 interface{}, arg83 interface{}) bool {
			return coer56(arg82.(_dafny.Char), arg83.(_dafny.Char))
		}
	}(m_DynamoDbItemEncryptorUtil.Companion_Default___.CharLess))
	_ = _0_keys
	if (_dafny.IntOfUint32((_0_keys).Cardinality())).Sign() == 0 {
		return _dafny.SeqOfString("item is empty")
	} else {
		return m_StandardLibrary.Companion_Default___.Join(_0_keys, _dafny.SeqOfString(" "))
	}
}
func (_static *CompanionStruct_Default___) KeyMissingMsg(config Config, item _dafny.Map, tag _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("On "), tag), _dafny.SeqOfString(" : ")), (func() _dafny.Sequence {
		if !(item).Contains((config).Dtor_partitionKeyName()) {
			return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Partition key '"), (config).Dtor_partitionKeyName()), _dafny.SeqOfString("' does not exist in item. "))
		}
		return _dafny.SeqOfString("")
	})()), (func() _dafny.Sequence {
		if (((config).Dtor_sortKeyName()).Is_Some()) && (!(item).Contains(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence))) {
			return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Sort key '"), ((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString("' does not exist in item. "))
		}
		return _dafny.SeqOfString("")
	})()), _dafny.SeqOfString("Item contains these attributes : ")), Companion_Default___.GetItemNames(item)), _dafny.SeqOfString("."))
}
func (_static *CompanionStruct_Default___) ContextAttrsExist(actions _dafny.Map, item _dafny.Map) bool {
	return _dafny.Quantifier((actions).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _0_k _dafny.Sequence
		_0_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !((actions).Contains(_0_k)) || (!(((actions).Get(_0_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_())) || ((item).Contains(_0_k)))
	})
}
func (_static *CompanionStruct_Default___) ContextMissingMsg(actions _dafny.Map, item _dafny.Map) _dafny.Sequence {
	var _0_s _dafny.Set = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter24 := _dafny.Iterate((actions).Keys().Elements()); ; {
			_compr_0, _ok24 := _iter24()
			if !_ok24 {
				break
			}
			var _1_k _dafny.Sequence
			_1_k = interface{}(_compr_0).(_dafny.Sequence)
			if (((actions).Contains(_1_k)) && (((actions).Get(_1_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()))) && (!(item).Contains(_1_k)) {
				_coll0.Add(_1_k)
			}
		}
		return _coll0.ToSet()
	}()
	_ = _0_s
	var _2_missing _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_0_s, func(coer57 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg84 interface{}, arg85 interface{}) bool {
			return coer57(arg84.(_dafny.Char), arg85.(_dafny.Char))
		}
	}(m_DynamoDbItemEncryptorUtil.Companion_Default___.CharLess))
	_ = _2_missing
	if (_dafny.IntOfUint32((_2_missing).Cardinality())).Sign() == 0 {
		return _dafny.SeqOfString("No missing SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attributes.")
	} else if (_dafny.IntOfUint32((_2_missing).Cardinality())).Cmp(_dafny.One) == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Attribute "), (_2_missing).Select(0).(_dafny.Sequence)), _dafny.SeqOfString(" was configured with SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT but was not present in item to be encrypted."))
	} else {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("These attributes were configured with SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT but were not present in item to be encrypted."), m_StandardLibrary.Companion_Default___.Join(_2_missing, _dafny.SeqOfString(",")))
	}
}
func (_static *CompanionStruct_Default___) EncryptItem(config Config, input m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_plaintextItem()).Contains((config).Dtor_partitionKeyName())) && ((((config).Dtor_sortKeyName()).Is_None()) || (((input).Dtor_plaintextItem()).Contains(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)))), m_DynamoDbItemEncryptorUtil.Companion_Default___.E(Companion_Default___.KeyMissingMsg(config, (input).Dtor_plaintextItem(), _dafny.SeqOfString("Encrypt"))))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need(Companion_Default___.ContextAttrsExist((config).Dtor_attributeActionsOnEncrypt(), (input).Dtor_plaintextItem()), m_DynamoDbItemEncryptorUtil.Companion_Default___.E(Companion_Default___.ContextMissingMsg((config).Dtor_attributeActionsOnEncrypt(), (input).Dtor_plaintextItem())))
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	if (((config).Dtor_internalLegacyOverride()).Is_Some()) && (((((config).Dtor_internalLegacyOverride()).Dtor_value().(*m_InternalLegacyOverride.InternalLegacyOverride)).Policy()).Is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT()) {
		var _2_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemOutput_.Default())
		_ = _2_valueOrError2
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (((config).Dtor_internalLegacyOverride()).Dtor_value().(*m_InternalLegacyOverride.InternalLegacyOverride)).EncryptItem(input)
		_2_valueOrError2 = _out0
		if (_2_valueOrError2).IsFailure() {
			output = (_2_valueOrError2).PropagateFailure()
			return output
		}
		var _3_encryptItemOutput m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput
		_ = _3_encryptItemOutput
		_3_encryptItemOutput = (_2_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput)
		output = m_Wrappers.Companion_Result_.Create_Success_(_3_encryptItemOutput)
		return output
	}
	if ((config).Dtor_plaintextOverride()).Is_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ() {
		var _4_passthroughOutput m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput
		_ = _4_passthroughOutput
		_4_passthroughOutput = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemOutput_.Create_EncryptItemOutput_((input).Dtor_plaintextItem(), m_Wrappers.Companion_Option_.Create_None_())
		output = m_Wrappers.Companion_Result_.Create_Success_(_4_passthroughOutput)
		return output
	}
	var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _5_valueOrError3
	_5_valueOrError3 = (m_DynamoToStruct.Companion_Default___.ItemToStructured2((input).Dtor_plaintextItem(), (config).Dtor_attributeActionsOnEncrypt())).MapFailure(func(coer58 func(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg86 interface{}) interface{} {
			return coer58(arg86.(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
		}
	}(func(_6_e m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(_6_e)
	}))
	if (_5_valueOrError3).IsFailure() {
		output = (_5_valueOrError3).PropagateFailure()
		return output
	}
	var _7_plaintextStructure _dafny.Map
	_ = _7_plaintextStructure
	_7_plaintextStructure = (_5_valueOrError3).Extract().(_dafny.Map)
	var _8_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _8_valueOrError4
	_8_valueOrError4 = Companion_Default___.MakeEncryptionContextForEncrypt(config, _7_plaintextStructure)
	if (_8_valueOrError4).IsFailure() {
		output = (_8_valueOrError4).PropagateFailure()
		return output
	}
	var _9_context _dafny.Map
	_ = _9_context
	_9_context = (_8_valueOrError4).Extract().(_dafny.Map)
	var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _10_valueOrError5
	_10_valueOrError5 = (Companion_Default___.ConfigToCryptoSchema(config, _7_plaintextStructure)).MapFailure(func(coer59 func(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg87 interface{}) interface{} {
			return coer59(arg87.(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
		}
	}(func(_11_e m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(_11_e)
	}))
	if (_10_valueOrError5).IsFailure() {
		output = (_10_valueOrError5).PropagateFailure()
		return output
	}
	var _12_cryptoSchema _dafny.Map
	_ = _12_cryptoSchema
	_12_cryptoSchema = (_10_valueOrError5).Extract().(_dafny.Map)
	var _13_contextKeysX _dafny.Sequence
	_ = _13_contextKeysX
	_13_contextKeysX = m_SortedSets.SetToOrderedSequence2((_9_context).Keys(), func(coer60 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
		return func(arg88 interface{}, arg89 interface{}) bool {
			return coer60(arg88.(uint8), arg89.(uint8))
		}
	}(m_DynamoDbItemEncryptorUtil.Companion_Default___.ByteLess))
	var _14_contextKeys _dafny.Sequence
	_ = _14_contextKeys
	_14_contextKeys = _13_contextKeysX
	var _15_reqCMMR m_Wrappers.Result
	_ = _15_reqCMMR
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = ((config).Dtor_cmpClient()).CreateRequiredEncryptionContextCMM(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateRequiredEncryptionContextCMMInput_.Create_CreateRequiredEncryptionContextCMMInput_(m_Wrappers.Companion_Option_.Create_Some_((config).Dtor_cmm()), m_Wrappers.Companion_Option_.Create_None_(), _14_contextKeys))
	_15_reqCMMR = _out1
	var _16_valueOrError6 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _16_valueOrError6
	_16_valueOrError6 = (_15_reqCMMR).MapFailure(func(coer61 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg90 interface{}) interface{} {
			return coer61(arg90.(m_AwsCryptographyMaterialProvidersTypes.Error))
		}
	}(func(_17_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_17_e)
	}))
	if (_16_valueOrError6).IsFailure() {
		output = (_16_valueOrError6).PropagateFailure()
		return output
	}
	var _18_reqCMM m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	_ = _18_reqCMM
	_18_reqCMM = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.CastTo_((_16_valueOrError6).Extract())
	var _19_encryptRes m_Wrappers.Result
	_ = _19_encryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = ((config).Dtor_structuredEncryption()).EncryptStructure(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_EncryptStructureInput_.Create_EncryptStructureInput_((config).Dtor_logicalTableName(), _7_plaintextStructure, _12_cryptoSchema, _18_reqCMM, (config).Dtor_algorithmSuiteId(), m_Wrappers.Companion_Option_.Create_Some_(_9_context)))
	_19_encryptRes = _out2
	var _20_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_EncryptStructureOutput_.Default())
	_ = _20_valueOrError7
	_20_valueOrError7 = (_19_encryptRes).MapFailure(func(coer62 func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg91 interface{}) interface{} {
			return coer62(arg91.(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error))
		}
	}(func(_21_e m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkStructuredEncryption_(_21_e))
	}))
	if (_20_valueOrError7).IsFailure() {
		output = (_20_valueOrError7).PropagateFailure()
		return output
	}
	var _22_encryptVal m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureOutput
	_ = _22_encryptVal
	_22_encryptVal = (_20_valueOrError7).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureOutput)
	var _23_encryptedData _dafny.Map
	_ = _23_encryptedData
	_23_encryptedData = (_22_encryptVal).Dtor_encryptedStructure()
	var _24_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _24_valueOrError8
	_24_valueOrError8 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((_23_encryptedData).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _25_k _dafny.Sequence
		_25_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !((_23_encryptedData).Contains(_25_k)) || (m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_25_k))
	}), m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("")))
	if (_24_valueOrError8).IsFailure() {
		output = (_24_valueOrError8).PropagateFailure()
		return output
	}
	var _26_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _26_valueOrError9
	_26_valueOrError9 = (m_DynamoToStruct.Companion_Default___.StructuredToItemEncrypt(_23_encryptedData, (input).Dtor_plaintextItem(), (config).Dtor_attributeActionsOnEncrypt())).MapFailure(func(coer63 func(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg92 interface{}) interface{} {
			return coer63(arg92.(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
		}
	}(func(_27_e m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(_27_e)
	}))
	if (_26_valueOrError9).IsFailure() {
		output = (_26_valueOrError9).PropagateFailure()
		return output
	}
	var _28_ddbKey _dafny.Map
	_ = _28_ddbKey
	_28_ddbKey = (_26_valueOrError9).Extract().(_dafny.Map)
	var _29_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _29_valueOrError10
	_29_valueOrError10 = Companion_Default___.ConvertCryptoSchemaToAttributeActions(config, (_22_encryptVal).Dtor_cryptoSchema())
	if (_29_valueOrError10).IsFailure() {
		output = (_29_valueOrError10).PropagateFailure()
		return output
	}
	var _30_parsedActions _dafny.Map
	_ = _30_parsedActions
	_30_parsedActions = (_29_valueOrError10).Extract().(_dafny.Map)
	var _31_selectorContextR m_Wrappers.Result
	_ = _31_selectorContextR
	_31_selectorContextR = m_DynamoDbItemEncryptorUtil.Companion_Default___.ConvertContextForSelector(((_22_encryptVal).Dtor_parsedHeader()).Dtor_encryptionContext())
	var _32_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _32_valueOrError11
	_32_valueOrError11 = (_31_selectorContextR).MapFailure(func(coer64 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg93 interface{}) interface{} {
			return coer64(arg93.(_dafny.Sequence))
		}
	}(func(_33_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_33_e)
	}))
	if (_32_valueOrError11).IsFailure() {
		output = (_32_valueOrError11).PropagateFailure()
		return output
	}
	var _34_selectorContext _dafny.Map
	_ = _34_selectorContext
	_34_selectorContext = (_32_valueOrError11).Extract().(_dafny.Map)
	var _35_parsedHeader m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader
	_ = _35_parsedHeader
	_35_parsedHeader = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_ParsedHeader_.Create_ParsedHeader_(_30_parsedActions, ((_22_encryptVal).Dtor_parsedHeader()).Dtor_algorithmSuiteId(), ((_22_encryptVal).Dtor_parsedHeader()).Dtor_encryptedDataKeys(), ((_22_encryptVal).Dtor_parsedHeader()).Dtor_storedEncryptionContext(), ((_22_encryptVal).Dtor_parsedHeader()).Dtor_encryptionContext(), _34_selectorContext)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_EncryptItemOutput_.Create_EncryptItemOutput_(_28_ddbKey, m_Wrappers.Companion_Option_.Create_Some_(_35_parsedHeader)))
	return output
}
func (_static *CompanionStruct_Default___) DecryptItem(config Config, input m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_encryptedItem()).Contains((config).Dtor_partitionKeyName())) && ((((config).Dtor_sortKeyName()).Is_None()) || (((input).Dtor_encryptedItem()).Contains(((config).Dtor_sortKeyName()).Dtor_value().(_dafny.Sequence)))), m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(Companion_Default___.KeyMissingMsg(config, (input).Dtor_encryptedItem(), _dafny.SeqOfString("Decrypt"))))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	if (((config).Dtor_internalLegacyOverride()).Is_Some()) && ((((config).Dtor_internalLegacyOverride()).Dtor_value().(*m_InternalLegacyOverride.InternalLegacyOverride)).IsLegacyInput(input)) {
		var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemOutput_.Default())
		_ = _1_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (((config).Dtor_internalLegacyOverride()).Dtor_value().(*m_InternalLegacyOverride.InternalLegacyOverride)).DecryptItem(input)
		_1_valueOrError1 = _out0
		if (_1_valueOrError1).IsFailure() {
			output = (_1_valueOrError1).PropagateFailure()
			return output
		}
		var _2_decryptItemOutput m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput
		_ = _2_decryptItemOutput
		_2_decryptItemOutput = (_1_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)
		output = m_Wrappers.Companion_Result_.Create_Success_(_2_decryptItemOutput)
		return output
	}
	if ((((config).Dtor_plaintextOverride()).Is_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ()) || (((config).Dtor_plaintextOverride()).Is_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ())) && (Companion_Default___.IsPlaintextItem((input).Dtor_encryptedItem())) {
		var _3_passthroughOutput m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput
		_ = _3_passthroughOutput
		_3_passthroughOutput = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemOutput_.Create_DecryptItemOutput_((input).Dtor_encryptedItem(), m_Wrappers.Companion_Option_.Create_None_())
		output = m_Wrappers.Companion_Result_.Create_Success_(_3_passthroughOutput)
		return output
	}
	var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError2
	_4_valueOrError2 = m_Wrappers.Companion_Default___.Need(!(Companion_Default___.IsPlaintextItem((input).Dtor_encryptedItem())), m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_DynamoDbItemEncryptorException_(_dafny.SeqOfString("Encrypted item missing expected header and footer attributes")))
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _5_valueOrError3
	_5_valueOrError3 = (m_DynamoToStruct.Companion_Default___.ItemToStructured2((input).Dtor_encryptedItem(), (config).Dtor_attributeActionsOnEncrypt())).MapFailure(func(coer65 func(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg94 interface{}) interface{} {
			return coer65(arg94.(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
		}
	}(func(_6_e m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(_6_e)
	}))
	if (_5_valueOrError3).IsFailure() {
		output = (_5_valueOrError3).PropagateFailure()
		return output
	}
	var _7_encryptedStructure _dafny.Map
	_ = _7_encryptedStructure
	_7_encryptedStructure = (_5_valueOrError3).Extract().(_dafny.Map)
	var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError4
	_8_valueOrError4 = m_Wrappers.Companion_Default___.Need(((input).Dtor_encryptedItem()).Contains(m_StructuredEncryptionUtil.Companion_Default___.HeaderField()), m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("Header field, \"aws_dbe_head\", not in item.")))
	if (_8_valueOrError4).IsFailure() {
		output = (_8_valueOrError4).PropagateFailure()
		return output
	}
	var _9_header m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _9_header
	_9_header = ((input).Dtor_encryptedItem()).Get(m_StructuredEncryptionUtil.Companion_Default___.HeaderField()).(m_ComAmazonawsDynamodbTypes.AttributeValue)
	var _10_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _10_valueOrError5
	_10_valueOrError5 = m_Wrappers.Companion_Default___.Need((_9_header).Is_B(), m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("Header field, \"aws_dbe_head\", not binary")))
	if (_10_valueOrError5).IsFailure() {
		output = (_10_valueOrError5).PropagateFailure()
		return output
	}
	var _11_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _11_valueOrError6
	_11_valueOrError6 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((_9_header).Dtor_B()).Cardinality())).Sign() == 1, m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected empty header field.")))
	if (_11_valueOrError6).IsFailure() {
		output = (_11_valueOrError6).PropagateFailure()
		return output
	}
	var _12_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _12_valueOrError7
	_12_valueOrError7 = Companion_Default___.MakeEncryptionContextForDecrypt(config, (_9_header).Dtor_B(), _7_encryptedStructure)
	if (_12_valueOrError7).IsFailure() {
		output = (_12_valueOrError7).PropagateFailure()
		return output
	}
	var _13_context _dafny.Map
	_ = _13_context
	_13_context = (_12_valueOrError7).Extract().(_dafny.Map)
	var _14_authenticateSchema _dafny.Map
	_ = _14_authenticateSchema
	_14_authenticateSchema = Companion_Default___.ConfigToAuthenticateSchema(config, _7_encryptedStructure)
	var _15_reqCMMR m_Wrappers.Result
	_ = _15_reqCMMR
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = ((config).Dtor_cmpClient()).CreateRequiredEncryptionContextCMM(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateRequiredEncryptionContextCMMInput_.Create_CreateRequiredEncryptionContextCMMInput_(m_Wrappers.Companion_Option_.Create_Some_((config).Dtor_cmm()), m_Wrappers.Companion_Option_.Create_None_(), m_SortedSets.SetToOrderedSequence2((_13_context).Keys(), func(coer66 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
		return func(arg95 interface{}, arg96 interface{}) bool {
			return coer66(arg95.(uint8), arg96.(uint8))
		}
	}(m_DynamoDbItemEncryptorUtil.Companion_Default___.ByteLess))))
	_15_reqCMMR = _out1
	var _16_valueOrError8 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _16_valueOrError8
	_16_valueOrError8 = (_15_reqCMMR).MapFailure(func(coer67 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg97 interface{}) interface{} {
			return coer67(arg97.(m_AwsCryptographyMaterialProvidersTypes.Error))
		}
	}(func(_17_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_17_e)
	}))
	if (_16_valueOrError8).IsFailure() {
		output = (_16_valueOrError8).PropagateFailure()
		return output
	}
	var _18_reqCMM m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	_ = _18_reqCMM
	_18_reqCMM = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.CastTo_((_16_valueOrError8).Extract())
	var _19_decryptRes m_Wrappers.Result
	_ = _19_decryptRes
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = ((config).Dtor_structuredEncryption()).DecryptStructure(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_DecryptStructureInput_.Create_DecryptStructureInput_((config).Dtor_logicalTableName(), _7_encryptedStructure, _14_authenticateSchema, _18_reqCMM, m_Wrappers.Companion_Option_.Create_Some_(_13_context)))
	_19_decryptRes = _out2
	var _20_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_DecryptStructureOutput_.Default())
	_ = _20_valueOrError9
	_20_valueOrError9 = (_19_decryptRes).MapFailure(func(coer68 func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg98 interface{}) interface{} {
			return coer68(arg98.(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error))
		}
	}(func(_21_e m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkStructuredEncryption_(_21_e))
	}))
	if (_20_valueOrError9).IsFailure() {
		output = (_20_valueOrError9).PropagateFailure()
		return output
	}
	var _22_decryptVal m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureOutput
	_ = _22_decryptVal
	_22_decryptVal = (_20_valueOrError9).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureOutput)
	var _23_decryptedData _dafny.Map
	_ = _23_decryptedData
	_23_decryptedData = (_22_decryptVal).Dtor_plaintextStructure()
	var _24_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _24_valueOrError10
	_24_valueOrError10 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((_23_decryptedData).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _25_k _dafny.Sequence
		_25_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !((_23_decryptedData).Contains(_25_k)) || (m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_25_k))
	}), m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_dafny.SeqOfString("")))
	if (_24_valueOrError10).IsFailure() {
		output = (_24_valueOrError10).PropagateFailure()
		return output
	}
	var _26_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _26_valueOrError11
	_26_valueOrError11 = (m_DynamoToStruct.Companion_Default___.StructuredToItemDecrypt(_23_decryptedData, (input).Dtor_encryptedItem(), (_22_decryptVal).Dtor_cryptoSchema())).MapFailure(func(coer69 func(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg99 interface{}) interface{} {
			return coer69(arg99.(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
		}
	}(func(_27_e m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_Error_.Create_AwsCryptographyDbEncryptionSdkDynamoDb_(_27_e)
	}))
	if (_26_valueOrError11).IsFailure() {
		output = (_26_valueOrError11).PropagateFailure()
		return output
	}
	var _28_ddbItem _dafny.Map
	_ = _28_ddbItem
	_28_ddbItem = (_26_valueOrError11).Extract().(_dafny.Map)
	var _29_schemaToConvert _dafny.Map
	_ = _29_schemaToConvert
	_29_schemaToConvert = (_22_decryptVal).Dtor_cryptoSchema()
	var _30_valueOrError12 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _30_valueOrError12
	_30_valueOrError12 = Companion_Default___.ConvertCryptoSchemaToAttributeActions(config, _29_schemaToConvert)
	if (_30_valueOrError12).IsFailure() {
		output = (_30_valueOrError12).PropagateFailure()
		return output
	}
	var _31_parsedAuthActions _dafny.Map
	_ = _31_parsedAuthActions
	_31_parsedAuthActions = (_30_valueOrError12).Extract().(_dafny.Map)
	var _32_selectorContextR m_Wrappers.Result
	_ = _32_selectorContextR
	_32_selectorContextR = m_DynamoDbItemEncryptorUtil.Companion_Default___.ConvertContextForSelector(((_22_decryptVal).Dtor_parsedHeader()).Dtor_encryptionContext())
	var _33_valueOrError13 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _33_valueOrError13
	_33_valueOrError13 = (_32_selectorContextR).MapFailure(func(coer70 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error) func(interface{}) interface{} {
		return func(arg100 interface{}) interface{} {
			return coer70(arg100.(_dafny.Sequence))
		}
	}(func(_34_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Error {
		return m_DynamoDbItemEncryptorUtil.Companion_Default___.E(_34_e)
	}))
	if (_33_valueOrError13).IsFailure() {
		output = (_33_valueOrError13).PropagateFailure()
		return output
	}
	var _35_selectorContext _dafny.Map
	_ = _35_selectorContext
	_35_selectorContext = (_33_valueOrError13).Extract().(_dafny.Map)
	var _36_parsedHeader m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.ParsedHeader
	_ = _36_parsedHeader
	_36_parsedHeader = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_ParsedHeader_.Create_ParsedHeader_(_31_parsedAuthActions, ((_22_decryptVal).Dtor_parsedHeader()).Dtor_algorithmSuiteId(), ((_22_decryptVal).Dtor_parsedHeader()).Dtor_encryptedDataKeys(), ((_22_decryptVal).Dtor_parsedHeader()).Dtor_storedEncryptionContext(), ((_22_decryptVal).Dtor_parsedHeader()).Dtor_encryptionContext(), _35_selectorContext)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemOutput_.Create_DecryptItemOutput_(_28_ddbItem, m_Wrappers.Companion_Option_.Create_Some_(_36_parsedHeader)))
	return output
}

// End of class Default__

// Definition of datatype Config
type Config struct {
	Data_Config_
}

func (_this Config) Get_() Data_Config_ {
	return _this.Data_Config_
}

type Data_Config_ interface {
	isConfig()
}

type CompanionStruct_Config_ struct {
}

var Companion_Config_ = CompanionStruct_Config_{}

type Config_Config struct {
	Version                        uint8
	CmpClient                      *m_MaterialProviders.MaterialProvidersClient
	LogicalTableName               _dafny.Sequence
	PartitionKeyName               _dafny.Sequence
	SortKeyName                    m_Wrappers.Option
	Cmm                            m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	AttributeActionsOnEncrypt      _dafny.Map
	AllowedUnsignedAttributes      m_Wrappers.Option
	AllowedUnsignedAttributePrefix m_Wrappers.Option
	AlgorithmSuiteId               m_Wrappers.Option
	StructuredEncryption           *m_StructuredEncryption.StructuredEncryptionClient
	PlaintextOverride              m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride
	InternalLegacyOverride         m_Wrappers.Option
}

func (Config_Config) isConfig() {}

func (CompanionStruct_Config_) Create_Config_(Version uint8, CmpClient *m_MaterialProviders.MaterialProvidersClient, LogicalTableName _dafny.Sequence, PartitionKeyName _dafny.Sequence, SortKeyName m_Wrappers.Option, Cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager, AttributeActionsOnEncrypt _dafny.Map, AllowedUnsignedAttributes m_Wrappers.Option, AllowedUnsignedAttributePrefix m_Wrappers.Option, AlgorithmSuiteId m_Wrappers.Option, StructuredEncryption *m_StructuredEncryption.StructuredEncryptionClient, PlaintextOverride m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride, InternalLegacyOverride m_Wrappers.Option) Config {
	return Config{Config_Config{Version, CmpClient, LogicalTableName, PartitionKeyName, SortKeyName, Cmm, AttributeActionsOnEncrypt, AllowedUnsignedAttributes, AllowedUnsignedAttributePrefix, AlgorithmSuiteId, StructuredEncryption, PlaintextOverride, InternalLegacyOverride}}
}

func (_this Config) Is_Config() bool {
	_, ok := _this.Get_().(Config_Config)
	return ok
}

func (CompanionStruct_Config_) Default() Config {
	return Companion_Config_.Create_Config_(m_StructuredEncryptionHeader.Companion_Version_.Witness(), (*m_MaterialProviders.MaterialProvidersClient)(nil), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)(nil), _dafny.EmptyMap, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), (*m_StructuredEncryption.StructuredEncryptionClient)(nil), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this Config) Dtor_version() uint8 {
	return _this.Get_().(Config_Config).Version
}

func (_this Config) Dtor_cmpClient() *m_MaterialProviders.MaterialProvidersClient {
	return _this.Get_().(Config_Config).CmpClient
}

func (_this Config) Dtor_logicalTableName() _dafny.Sequence {
	return _this.Get_().(Config_Config).LogicalTableName
}

func (_this Config) Dtor_partitionKeyName() _dafny.Sequence {
	return _this.Get_().(Config_Config).PartitionKeyName
}

func (_this Config) Dtor_sortKeyName() m_Wrappers.Option {
	return _this.Get_().(Config_Config).SortKeyName
}

func (_this Config) Dtor_cmm() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager {
	return _this.Get_().(Config_Config).Cmm
}

func (_this Config) Dtor_attributeActionsOnEncrypt() _dafny.Map {
	return _this.Get_().(Config_Config).AttributeActionsOnEncrypt
}

func (_this Config) Dtor_allowedUnsignedAttributes() m_Wrappers.Option {
	return _this.Get_().(Config_Config).AllowedUnsignedAttributes
}

func (_this Config) Dtor_allowedUnsignedAttributePrefix() m_Wrappers.Option {
	return _this.Get_().(Config_Config).AllowedUnsignedAttributePrefix
}

func (_this Config) Dtor_algorithmSuiteId() m_Wrappers.Option {
	return _this.Get_().(Config_Config).AlgorithmSuiteId
}

func (_this Config) Dtor_structuredEncryption() *m_StructuredEncryption.StructuredEncryptionClient {
	return _this.Get_().(Config_Config).StructuredEncryption
}

func (_this Config) Dtor_plaintextOverride() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.PlaintextOverride {
	return _this.Get_().(Config_Config).PlaintextOverride
}

func (_this Config) Dtor_internalLegacyOverride() m_Wrappers.Option {
	return _this.Get_().(Config_Config).InternalLegacyOverride
}

func (_this Config) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Config_Config:
		{
			return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Config.Config" + "(" + _dafny.String(data.Version) + ", " + _dafny.String(data.CmpClient) + ", " + _dafny.String(data.LogicalTableName) + ", " + _dafny.String(data.PartitionKeyName) + ", " + _dafny.String(data.SortKeyName) + ", " + _dafny.String(data.Cmm) + ", " + _dafny.String(data.AttributeActionsOnEncrypt) + ", " + _dafny.String(data.AllowedUnsignedAttributes) + ", " + _dafny.String(data.AllowedUnsignedAttributePrefix) + ", " + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.StructuredEncryption) + ", " + _dafny.String(data.PlaintextOverride) + ", " + _dafny.String(data.InternalLegacyOverride) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Config) Equals(other Config) bool {
	switch data1 := _this.Get_().(type) {
	case Config_Config:
		{
			data2, ok := other.Get_().(Config_Config)
			return ok && data1.Version == data2.Version && data1.CmpClient == data2.CmpClient && data1.LogicalTableName.Equals(data2.LogicalTableName) && data1.PartitionKeyName.Equals(data2.PartitionKeyName) && data1.SortKeyName.Equals(data2.SortKeyName) && _dafny.AreEqual(data1.Cmm, data2.Cmm) && data1.AttributeActionsOnEncrypt.Equals(data2.AttributeActionsOnEncrypt) && data1.AllowedUnsignedAttributes.Equals(data2.AllowedUnsignedAttributes) && data1.AllowedUnsignedAttributePrefix.Equals(data2.AllowedUnsignedAttributePrefix) && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.StructuredEncryption == data2.StructuredEncryption && data1.PlaintextOverride.Equals(data2.PlaintextOverride) && data1.InternalLegacyOverride.Equals(data2.InternalLegacyOverride)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Config) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Config)
	return ok && _this.Equals(typed)
}

func Type_Config_() _dafny.TypeDescriptor {
	return type_Config_{}
}

type type_Config_ struct {
}

func (_this type_Config_) Default() interface{} {
	return Companion_Config_.Default()
}

func (_this type_Config_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Config"
}
func (_this Config) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Config{}

// End of datatype Config

// Definition of class ValidConfig
type ValidConfig struct {
}

func New_ValidConfig_() *ValidConfig {
	_this := ValidConfig{}

	return &_this
}

type CompanionStruct_ValidConfig_ struct {
}

var Companion_ValidConfig_ = CompanionStruct_ValidConfig_{}

func (*ValidConfig) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.ValidConfig"
}

// End of class ValidConfig

func Type_ValidConfig_() _dafny.TypeDescriptor {
	return type_ValidConfig_{}
}

type type_ValidConfig_ struct {
}

func (_this type_ValidConfig_) Default() interface{} {
	return Companion_Config_.Default()
}

func (_this type_ValidConfig_) String() string {
	return "AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.ValidConfig"
}
