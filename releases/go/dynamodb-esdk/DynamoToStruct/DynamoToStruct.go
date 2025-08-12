// Package DynamoToStruct
// Dafny module DynamoToStruct compiled into Go

package DynamoToStruct

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
	m_DafnyLibraries "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DafnyLibraries"
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
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/Canonize"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbEncryptionUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/DynamoDbNormalizeNumber"
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
	return "DynamoToStruct.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ItemToStructured2(item _dafny.Map, actions _dafny.Map) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = ret
	var _0_attrNames _dafny.Sequence
	_ = _0_attrNames
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = m_SortedSets.SetToSequence((item).Keys())
	_0_attrNames = _out0
	var _1_m *m_DafnyLibraries.MutableMap
	_ = _1_m
	var _nw0 *m_DafnyLibraries.MutableMap = m_DafnyLibraries.New_MutableMap_()
	_ = _nw0
	_1_m = _nw0
	var _hi0 uint64 = uint64((_0_attrNames).Cardinality())
	_ = _hi0
	for _2_i := uint64(0); _2_i < _hi0; _2_i++ {
		var _3_k _dafny.Sequence
		_ = _3_k
		_3_k = (_0_attrNames).Select(uint32(_2_i)).(_dafny.Sequence)
		if ((!(actions).Contains(_3_k)) || (!((actions).Get(_3_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()))) || (_dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.ReservedPrefix(), _3_k)) {
			var _4_val m_Wrappers.Result
			_ = _4_val
			_4_val = Companion_Default___.AttrToStructured((item).Get(_3_k).(m_ComAmazonawsDynamodbTypes.AttributeValue))
			if (_4_val).Is_Failure() {
				var _5_result m_Wrappers.Result
				_ = _5_result
				_5_result = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E((_4_val).Dtor_error().(_dafny.Sequence)))
				ret = _5_result
				return ret
			}
			(_1_m).Put(_3_k, (_4_val).Dtor_value().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
		}
	}
	var _6_result m_Wrappers.Result
	_ = _6_result
	_6_result = m_Wrappers.Companion_Result_.Create_Success_((_1_m).Content())
	ret = _6_result
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) StructuredToItemEncrypt(s _dafny.Map, orig _dafny.Map, actions _dafny.Map) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = ret
	var _0_attrNames _dafny.Sequence
	_ = _0_attrNames
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = m_SortedSets.SetToSequence((orig).Keys())
	_0_attrNames = _out0
	var _1_m *m_DafnyLibraries.MutableMap
	_ = _1_m
	var _nw0 *m_DafnyLibraries.MutableMap = m_DafnyLibraries.New_MutableMap_()
	_ = _nw0
	_1_m = _nw0
	var _hi0 uint64 = uint64((_0_attrNames).Cardinality())
	_ = _hi0
	for _2_i := uint64(0); _2_i < _hi0; _2_i++ {
		var _3_k _dafny.Sequence
		_ = _3_k
		_3_k = (_0_attrNames).Select(uint32(_2_i)).(_dafny.Sequence)
		if !(_dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.ReservedPrefix(), _3_k)) {
			if (((s).Contains(_3_k)) && ((actions).Contains(_3_k))) && (((actions).Get(_3_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())) {
				var _4_val m_Wrappers.Result
				_ = _4_val
				_4_val = Companion_Default___.StructuredToAttr((s).Get(_3_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
				if (_4_val).Is_Failure() {
					var _5_result m_Wrappers.Result
					_ = _5_result
					_5_result = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E((_4_val).Dtor_error().(_dafny.Sequence)))
					ret = _5_result
					return ret
				}
				(_1_m).Put(_3_k, (_4_val).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue))
			} else {
				(_1_m).Put(_3_k, (orig).Get(_3_k).(m_ComAmazonawsDynamodbTypes.AttributeValue))
			}
		}
	}
	var _out1 _dafny.Sequence
	_ = _out1
	_out1 = m_SortedSets.SetToSequence((s).Keys())
	_0_attrNames = _out1
	var _hi1 uint64 = uint64((_0_attrNames).Cardinality())
	_ = _hi1
	for _6_i := uint64(0); _6_i < _hi1; _6_i++ {
		var _7_k _dafny.Sequence
		_ = _7_k
		_7_k = (_0_attrNames).Select(uint32(_6_i)).(_dafny.Sequence)
		if !(orig).Contains(_7_k) {
			var _8_val m_Wrappers.Result
			_ = _8_val
			_8_val = Companion_Default___.StructuredToAttr((s).Get(_7_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
			if (_8_val).Is_Failure() {
				var _9_result m_Wrappers.Result
				_ = _9_result
				_9_result = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E((_8_val).Dtor_error().(_dafny.Sequence)))
				ret = _9_result
				return ret
			}
			(_1_m).Put(_7_k, (_8_val).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue))
		}
	}
	var _10_result m_Wrappers.Result
	_ = _10_result
	_10_result = m_Wrappers.Companion_Result_.Create_Success_((_1_m).Content())
	ret = _10_result
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) StructuredToItemDecrypt(s _dafny.Map, orig _dafny.Map, actions _dafny.Map) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = ret
	var _0_attrNames _dafny.Sequence
	_ = _0_attrNames
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = m_SortedSets.SetToSequence((orig).Keys())
	_0_attrNames = _out0
	var _1_m *m_DafnyLibraries.MutableMap
	_ = _1_m
	var _nw0 *m_DafnyLibraries.MutableMap = m_DafnyLibraries.New_MutableMap_()
	_ = _nw0
	_1_m = _nw0
	var _hi0 uint64 = uint64((_0_attrNames).Cardinality())
	_ = _hi0
	for _2_i := uint64(0); _2_i < _hi0; _2_i++ {
		var _3_k _dafny.Sequence
		_ = _3_k
		_3_k = (_0_attrNames).Select(uint32(_2_i)).(_dafny.Sequence)
		if !(_dafny.Companion_Sequence_.IsPrefixOf(m_DynamoDbEncryptionUtil.Companion_Default___.ReservedPrefix(), _3_k)) {
			if (((s).Contains(_3_k)) && ((actions).Contains(_3_k))) && (((actions).Get(_3_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())) {
				var _4_val m_Wrappers.Result
				_ = _4_val
				_4_val = Companion_Default___.StructuredToAttr((s).Get(_3_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal))
				if (_4_val).Is_Failure() {
					var _5_result m_Wrappers.Result
					_ = _5_result
					_5_result = m_Wrappers.Companion_Result_.Create_Failure_(m_DynamoDbEncryptionUtil.Companion_Default___.E((_4_val).Dtor_error().(_dafny.Sequence)))
					ret = _5_result
					return ret
				}
				(_1_m).Put(_3_k, (_4_val).Dtor_value().(m_ComAmazonawsDynamodbTypes.AttributeValue))
			} else {
				(_1_m).Put(_3_k, (orig).Get(_3_k).(m_ComAmazonawsDynamodbTypes.AttributeValue))
			}
		}
	}
	var _6_result m_Wrappers.Result
	_ = _6_result
	_6_result = m_Wrappers.Companion_Result_.Create_Success_((_1_m).Content())
	ret = _6_result
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) ItemToStructured(item _dafny.Map) m_Wrappers.Result {
	var _0_structuredMap _dafny.Map = func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter11 := _dafny.Iterate((item).Keys().Elements()); ; {
			_compr_0, _ok11 := _iter11()
			if !_ok11 {
				break
			}
			var _1_k _dafny.Sequence
			_1_k = interface{}(_compr_0).(_dafny.Sequence)
			if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_1_k) {
				if (item).Contains(_1_k) {
					_coll0.Add(_1_k, Companion_Default___.AttrToStructured((item).Get(_1_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)))
				}
			}
		}
		return _coll0.ToMap()
	}()
	_ = _0_structuredMap
	return Companion_Default___.MapError(Companion_Default___.SimplifyMapValue(_0_structuredMap))
}
func (_static *CompanionStruct_Default___) StructuredToItem(s _dafny.Map) m_Wrappers.Result {
	if _dafny.Quantifier((s).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _0_k _dafny.Sequence
		_0_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !((s).Contains(_0_k)) || (m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_0_k))
	}) {
		var _1_structuredData _dafny.Map = func() _dafny.Map {
			var _coll0 = _dafny.NewMapBuilder()
			_ = _coll0
			for _iter12 := _dafny.Iterate((s).Keys().Elements()); ; {
				_compr_0, _ok12 := _iter12()
				if !_ok12 {
					break
				}
				var _2_k _dafny.Sequence
				_2_k = interface{}(_compr_0).(_dafny.Sequence)
				if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_2_k) {
					if (s).Contains(_2_k) {
						_coll0.Add(_2_k, Companion_Default___.StructuredToAttr((s).Get(_2_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)))
					}
				}
			}
			return _coll0.ToMap()
		}()
		_ = _1_structuredData
		return Companion_Default___.MapError(Companion_Default___.SimplifyMapValue(_1_structuredData))
	} else {
		var _3_badNames _dafny.Set = func() _dafny.Set {
			var _coll1 = _dafny.NewBuilder()
			_ = _coll1
			for _iter13 := _dafny.Iterate((s).Keys().Elements()); ; {
				_compr_1, _ok13 := _iter13()
				if !_ok13 {
					break
				}
				var _4_k _dafny.Sequence
				_4_k = interface{}(_compr_1).(_dafny.Sequence)
				if ((s).Contains(_4_k)) && (!(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_4_k))) {
					_coll1.Add(_4_k)
				}
			}
			return _coll1.ToSet()
		}()
		_ = _3_badNames
		var _5_orderedAttrNames _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_3_badNames, func(coer44 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg60 interface{}, arg61 interface{}) bool {
				return coer44(arg60.(_dafny.Char), arg61.(_dafny.Char))
			}
		}(Companion_Default___.CharLess))
		_ = _5_orderedAttrNames
		var _6_attrNameList _dafny.Sequence = m_StandardLibrary.Companion_Default___.Join(_5_orderedAttrNames, _dafny.SeqOfString(","))
		_ = _6_attrNameList
		return Companion_Default___.MakeError(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Not valid attribute names : "), _6_attrNameList))
	}
}
func (_static *CompanionStruct_Default___) BigEndianPosToU32(x _dafny.Sequence, pos uint64) m_Wrappers.Result {
	if (uint64((x).Cardinality())) < (m_StandardLibrary_MemoryMath.Companion_Default___.Add(pos, Companion_Default___.LENGTH__LEN64())) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Length of 4-byte integer was less than 4"))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt32(x, pos))
	}
}
func (_static *CompanionStruct_Default___) BigEndianPosToU32As64(x _dafny.Sequence, pos uint64) m_Wrappers.Result {
	if (uint64((x).Cardinality())) < (m_StandardLibrary_MemoryMath.Companion_Default___.Add(pos, Companion_Default___.LENGTH__LEN64())) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Length of 4-byte integer was less than 4"))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(uint64(m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt32(x, pos)))
	}
}
func (_static *CompanionStruct_Default___) MakeError(s _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(s))
}
func (_static *CompanionStruct_Default___) MapError(r m_Wrappers.Result) m_Wrappers.Result {
	if (r).Is_Success() {
		return m_Wrappers.Companion_Result_.Create_Success_((r).Dtor_value())
	} else {
		return Companion_Default___.MakeError((r).Dtor_error().(_dafny.Sequence))
	}
}
func (_static *CompanionStruct_Default___) TopLevelAttributeToBytes(a m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	return Companion_Default___.AttrToBytes(a, false, uint64(1))
}
func (_static *CompanionStruct_Default___) AttrToStructured(item m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.TopLevelAttributeToBytes(item)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_body _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_body
		return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_1_body, Companion_Default___.AttrToTypeId(item)))
	}
}
func (_static *CompanionStruct_Default___) StructuredToAttr(s m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(((s).Dtor_typeId()).Cardinality())) == (Companion_Default___.TYPEID__LEN64()), _dafny.SeqOfString("Type ID must be two bytes"))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.BytesToAttr((s).Dtor_value(), (s).Dtor_typeId(), m_Wrappers.Companion_Option_.Create_Some_(uint64(((s).Dtor_value()).Cardinality())), uint64(1), uint64(0))
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_attrValueAndLength AttrValueAndLength = (_1_valueOrError1).Extract().(AttrValueAndLength)
			_ = _2_attrValueAndLength
			if ((_2_attrValueAndLength).Dtor_len()) != (uint64(((s).Dtor_value()).Cardinality())) /* dircomp */ {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Mismatch between length of encoded data and length of data"))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_((_2_attrValueAndLength).Dtor_val())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) AttrToTypeId(a m_ComAmazonawsDynamodbTypes.AttributeValue) _dafny.Sequence {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = a
	_ = _source0
	{
		if _source0.Is_S() {
			var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
			_ = _0_s
			return m_StructuredEncryptionUtil.Companion_Default___.STRING()
		}
	}
	{
		if _source0.Is_N() {
			var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _1_n
			return m_StructuredEncryptionUtil.Companion_Default___.NUMBER()
		}
	}
	{
		if _source0.Is_B() {
			var _2_b _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
			_ = _2_b
			return m_StructuredEncryptionUtil.Companion_Default___.BINARY()
		}
	}
	{
		if _source0.Is_SS() {
			var _3_ss _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
			_ = _3_ss
			return m_StructuredEncryptionUtil.Companion_Default___.STRING__SET()
		}
	}
	{
		if _source0.Is_NS() {
			var _4_ns _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
			_ = _4_ns
			return m_StructuredEncryptionUtil.Companion_Default___.NUMBER__SET()
		}
	}
	{
		if _source0.Is_BS() {
			var _5_bs _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
			_ = _5_bs
			return m_StructuredEncryptionUtil.Companion_Default___.BINARY__SET()
		}
	}
	{
		if _source0.Is_M() {
			var _6_m _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
			_ = _6_m
			return m_StructuredEncryptionUtil.Companion_Default___.MAP()
		}
	}
	{
		if _source0.Is_L() {
			var _7_l _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
			_ = _7_l
			return m_StructuredEncryptionUtil.Companion_Default___.LIST()
		}
	}
	{
		if _source0.Is_NULL() {
			var _8_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
			_ = _8_n
			return m_StructuredEncryptionUtil.Companion_Default___.NULL()
		}
	}
	{
		var _9_b bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
		_ = _9_b
		return m_StructuredEncryptionUtil.Companion_Default___.BOOLEAN()
	}
}
func (_static *CompanionStruct_Default___) CharLess(x _dafny.Char, y _dafny.Char) bool {
	return (x) < (y)
}
func (_static *CompanionStruct_Default___) AttrToBytes(a m_ComAmazonawsDynamodbTypes.AttributeValue, prefix bool, depth uint64) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((depth) <= (m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH()), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Depth of attribute structure to serialize exceeds limit of "), m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH__STR()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Result = func() m_Wrappers.Result {
			var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = a
			_ = _source0
			{
				if _source0.Is_S() {
					var _2_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
					_ = _2_s
					return m_UTF8.Encode(_2_s)
				}
			}
			{
				if _source0.Is_N() {
					var _3_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
					_ = _3_n
					var _4_valueOrError2 m_Wrappers.Result = m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(_3_n)
					_ = _4_valueOrError2
					if (_4_valueOrError2).IsFailure() {
						return (_4_valueOrError2).PropagateFailure()
					} else {
						var _5_nn _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
						_ = _5_nn
						return m_UTF8.Encode(_5_nn)
					}
				}
			}
			{
				if _source0.Is_B() {
					var _6_b _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
					_ = _6_b
					return m_Wrappers.Companion_Result_.Create_Success_(_6_b)
				}
			}
			{
				if _source0.Is_SS() {
					var _7_ss _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
					_ = _7_ss
					return Companion_Default___.StringSetAttrToBytes(_7_ss)
				}
			}
			{
				if _source0.Is_NS() {
					var _8_ns _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
					_ = _8_ns
					return Companion_Default___.NumberSetAttrToBytes(_8_ns)
				}
			}
			{
				if _source0.Is_BS() {
					var _9_bs _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
					_ = _9_bs
					return Companion_Default___.BinarySetAttrToBytes(_9_bs)
				}
			}
			{
				if _source0.Is_M() {
					var _10_m _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
					_ = _10_m
					return Companion_Default___.MapAttrToBytes(a, _10_m, depth)
				}
			}
			{
				if _source0.Is_L() {
					var _11_l _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
					_ = _11_l
					return Companion_Default___.ListAttrToBytes(_11_l, depth)
				}
			}
			{
				if _source0.Is_NULL() {
					var _12_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
					_ = _12_n
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf())
				}
			}
			{
				var _13_b bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
				_ = _13_b
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(Companion_Default___.BoolToUint8(_13_b)))
			}
		}()
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _14_baseBytes _dafny.Sequence = (_1_valueOrError1).Extract().(_dafny.Sequence)
			_ = _14_baseBytes
			if prefix {
				var _15_valueOrError3 m_Wrappers.Result = Companion_Default___.U32ToBigEndian64(uint64((_14_baseBytes).Cardinality()))
				_ = _15_valueOrError3
				if (_15_valueOrError3).IsFailure() {
					return (_15_valueOrError3).PropagateFailure()
				} else {
					var _16_len _dafny.Sequence = (_15_valueOrError3).Extract().(_dafny.Sequence)
					_ = _16_len
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.AttrToTypeId(a), _16_len), _14_baseBytes))
				}
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_14_baseBytes)
			}
		}
	}
}
func (_static *CompanionStruct_Default___) StringSetAttrToBytes(ss _dafny.Sequence) m_Wrappers.Result {
	var _0_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(ss)
	_ = _0_asSet
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64((_0_asSet).CardinalityInt())) == (uint64((ss).Cardinality())), _dafny.SeqOfString("String Set had duplicate values"))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_sortedList _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_0_asSet, func(coer45 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg62 interface{}, arg63 interface{}) bool {
				return coer45(arg62.(_dafny.Char), arg63.(_dafny.Char))
			}
		}(Companion_Default___.CharLess))
		_ = _2_sortedList
		var _3_valueOrError1 m_Wrappers.Result = Companion_Default___.U32ToBigEndian64(uint64((_2_sortedList).Cardinality()))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_count _dafny.Sequence = (_3_valueOrError1).Extract().(_dafny.Sequence)
			_ = _4_count
			var _5_valueOrError2 m_Wrappers.Result = Companion_Default___.CollectString(_2_sortedList, uint64(0), _dafny.SeqOf())
			_ = _5_valueOrError2
			if (_5_valueOrError2).IsFailure() {
				return (_5_valueOrError2).PropagateFailure()
			} else {
				var _6_body _dafny.Sequence = (_5_valueOrError2).Extract().(_dafny.Sequence)
				_ = _6_body
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_4_count, _6_body))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) NumberSetAttrToBytes(ns _dafny.Sequence) m_Wrappers.Result {
	var _0_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(ns)
	_ = _0_asSet
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64((_0_asSet).CardinalityInt())) == (uint64((ns).Cardinality())), _dafny.SeqOfString("Number Set had duplicate values"))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Result = m_StandardLibrary_Sequence.Companion_Default___.MapWithResult(func(coer46 func(_dafny.Sequence) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
			return func(arg64 interface{}) m_Wrappers.Result {
				return coer46(arg64.(_dafny.Sequence))
			}
		}(func(_3_n _dafny.Sequence) m_Wrappers.Result {
			return m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(_3_n)
		}), ns, uint64(0), _dafny.SeqOf())
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _4_normList _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _4_normList
			var _5_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(_4_normList)
			_ = _5_asSet
			var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64((_5_asSet).CardinalityInt())) == (uint64((_4_normList).Cardinality())), _dafny.SeqOfString("Number Set had duplicate values after normalization."))
			_ = _6_valueOrError2
			if (_6_valueOrError2).IsFailure() {
				return (_6_valueOrError2).PropagateFailure()
			} else {
				var _7_sortedList _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_5_asSet, func(coer47 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
					return func(arg65 interface{}, arg66 interface{}) bool {
						return coer47(arg65.(_dafny.Char), arg66.(_dafny.Char))
					}
				}(Companion_Default___.CharLess))
				_ = _7_sortedList
				var _8_valueOrError3 m_Wrappers.Result = Companion_Default___.U32ToBigEndian64(uint64((_7_sortedList).Cardinality()))
				_ = _8_valueOrError3
				if (_8_valueOrError3).IsFailure() {
					return (_8_valueOrError3).PropagateFailure()
				} else {
					var _9_count _dafny.Sequence = (_8_valueOrError3).Extract().(_dafny.Sequence)
					_ = _9_count
					var _10_valueOrError4 m_Wrappers.Result = Companion_Default___.CollectString(_7_sortedList, uint64(0), _dafny.SeqOf())
					_ = _10_valueOrError4
					if (_10_valueOrError4).IsFailure() {
						return (_10_valueOrError4).PropagateFailure()
					} else {
						var _11_body _dafny.Sequence = (_10_valueOrError4).Extract().(_dafny.Sequence)
						_ = _11_body
						return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_9_count, _11_body))
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) BinarySetAttrToBytes(bs _dafny.Sequence) m_Wrappers.Result {
	var _0_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(bs)
	_ = _0_asSet
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64((_0_asSet).CardinalityInt())) == (uint64((bs).Cardinality())), _dafny.SeqOfString("Binary Set had duplicate values"))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_sortedList _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_0_asSet, func(coer48 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
			return func(arg67 interface{}, arg68 interface{}) bool {
				return coer48(arg67.(uint8), arg68.(uint8))
			}
		}(m_DynamoDbEncryptionUtil.Companion_Default___.ByteLess))
		_ = _2_sortedList
		var _3_valueOrError1 m_Wrappers.Result = Companion_Default___.U32ToBigEndian64(uint64((_2_sortedList).Cardinality()))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_count _dafny.Sequence = (_3_valueOrError1).Extract().(_dafny.Sequence)
			_ = _4_count
			var _5_valueOrError2 m_Wrappers.Result = Companion_Default___.CollectBinary(_2_sortedList, uint64(0), _dafny.SeqOf())
			_ = _5_valueOrError2
			if (_5_valueOrError2).IsFailure() {
				return (_5_valueOrError2).PropagateFailure()
			} else {
				var _6_body _dafny.Sequence = (_5_valueOrError2).Extract().(_dafny.Sequence)
				_ = _6_body
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_4_count, _6_body))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) MapAttrToBytes(parent m_ComAmazonawsDynamodbTypes.AttributeValue, m _dafny.Map, depth uint64) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = ret
	var _0_attrNames _dafny.Sequence
	_ = _0_attrNames
	_0_attrNames = m_SortedSets.SetToOrderedSequence2((m).Keys(), func(coer49 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg69 interface{}, arg70 interface{}) bool {
			return coer49(arg69.(_dafny.Char), arg70.(_dafny.Char))
		}
	}(Companion_Default___.CharLess))
	var _1_len uint64
	_ = _1_len
	_1_len = uint64((_0_attrNames).Cardinality())
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError0
	_2_valueOrError0 = Companion_Default___.U32ToBigEndian64(_1_len)
	if (_2_valueOrError0).IsFailure() {
		ret = (_2_valueOrError0).PropagateFailure()
		return ret
	}
	var _3_output _dafny.Sequence
	_ = _3_output
	_3_output = (_2_valueOrError0).Extract().(_dafny.Sequence)
	var _hi0 uint64 = _1_len
	_ = _hi0
	for _4_i := uint64(0); _4_i < _hi0; _4_i++ {
		var _5_k _dafny.Sequence
		_ = _5_k
		_5_k = (_0_attrNames).Select(uint32(_4_i)).(_dafny.Sequence)
		var _6_val m_Wrappers.Result
		_ = _6_val
		_6_val = Companion_Default___.AttrToBytes((m).Get(_5_k).(m_ComAmazonawsDynamodbTypes.AttributeValue), true, (depth)+(uint64(1)))
		if (_6_val).Is_Failure() {
			var _7_result m_Wrappers.Result
			_ = _7_result
			_7_result = m_Wrappers.Companion_Result_.Create_Failure_((_6_val).Dtor_error().(_dafny.Sequence))
			ret = _7_result
			return ret
		}
		var _8_data m_Wrappers.Result
		_ = _8_data
		_8_data = Companion_Default___.SerializeMapItem(_5_k, (_6_val).Dtor_value().(_dafny.Sequence))
		if (_8_data).Is_Failure() {
			var _9_result m_Wrappers.Result
			_ = _9_result
			_9_result = m_Wrappers.Companion_Result_.Create_Failure_((_8_data).Dtor_error().(_dafny.Sequence))
			ret = _9_result
			return ret
		}
		_3_output = _dafny.Companion_Sequence_.Concatenate(_3_output, (_8_data).Dtor_value().(_dafny.Sequence))
	}
	var _10_result m_Wrappers.Result
	_ = _10_result
	_10_result = m_Wrappers.Companion_Result_.Create_Success_(_3_output)
	ret = _10_result
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) ListAttrToBytes(l _dafny.Sequence, depth uint64) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.U32ToBigEndian64(uint64((l).Cardinality()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_count _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_count
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.CollectList(l, depth, _dafny.SeqOf())
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_body _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_body
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_1_count, _3_body))
		}
	}
}
func (_static *CompanionStruct_Default___) U32ToBigEndian64(x uint64) m_Wrappers.Result {
	if (x) > (uint64(4294967295)) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Length was too big"))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(uint32(x)))
	}
}
func (_static *CompanionStruct_Default___) BigEndianToU32As32(x _dafny.Sequence) m_Wrappers.Result {
	if (uint64((x).Cardinality())) < (Companion_Default___.LENGTH__LEN64()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Length of 4-byte integer was less than 4"))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((x).Take(uint32(Companion_Default___.LENGTH__LEN64()))))
	}
}
func (_static *CompanionStruct_Default___) BigEndianToU32As64(x _dafny.Sequence) m_Wrappers.Result {
	if (uint64((x).Cardinality())) < (Companion_Default___.LENGTH__LEN64()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Length of 4-byte integer was less than 4"))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(uint64(m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((x).Take(uint32(Companion_Default___.LENGTH__LEN64())))))
	}
}
func (_static *CompanionStruct_Default___) EncodeString(s _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_UTF8.Encode(s)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_val _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_val
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.U32ToBigEndian64(uint64((_1_val).Cardinality()))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_len _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_len
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_3_len, _1_val))
		}
	}
}
func (_static *CompanionStruct_Default___) CollectString(setToSerialize _dafny.Sequence, pos uint64, serialized _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((setToSerialize).Cardinality())) == (pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(serialized)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.EncodeString((setToSerialize).Select(uint32(pos)).(_dafny.Sequence))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_entry _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_entry
			var _in0 _dafny.Sequence = setToSerialize
			_ = _in0
			var _in1 uint64 = (pos) + (uint64(1))
			_ = _in1
			var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(serialized, _1_entry)
			_ = _in2
			setToSerialize = _in0
			pos = _in1
			serialized = _in2
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) SerializeBinaryValue(b _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.U32ToBigEndian64(uint64((b).Cardinality()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_len _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_len
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_1_len, b))
	}
}
func (_static *CompanionStruct_Default___) CollectBinary(setToSerialize _dafny.Sequence, pos uint64, serialized _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((setToSerialize).Cardinality())) == (pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(serialized)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.SerializeBinaryValue((setToSerialize).Select(uint32(pos)).(_dafny.Sequence))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_item _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_item
			var _in0 _dafny.Sequence = setToSerialize
			_ = _in0
			var _in1 uint64 = (pos) + (uint64(1))
			_ = _in1
			var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(serialized, _1_item)
			_ = _in2
			setToSerialize = _in0
			pos = _in1
			serialized = _in2
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) CollectList(listToSerialize _dafny.Sequence, depth uint64, serialized _dafny.Sequence) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = ret
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = serialized
	var _hi0 uint64 = uint64((listToSerialize).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_val m_Wrappers.Result
		_ = _2_val
		_2_val = Companion_Default___.AttrToBytes((listToSerialize).Select(uint32(_1_i)).(m_ComAmazonawsDynamodbTypes.AttributeValue), true, (depth)+(uint64(1)))
		if (_2_val).Is_Failure() {
			ret = m_Wrappers.Companion_Result_.Create_Failure_((_2_val).Dtor_error().(_dafny.Sequence))
			return ret
		}
		_0_result = _dafny.Companion_Sequence_.Concatenate(_0_result, (_2_val).Dtor_value().(_dafny.Sequence))
	}
	ret = m_Wrappers.Companion_Result_.Create_Success_(_0_result)
	return ret
}
func (_static *CompanionStruct_Default___) SerializeMapItem(key _dafny.Sequence, value _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_UTF8.Encode(key)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_name _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_name
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.U32ToBigEndian64(uint64((_1_name).Cardinality()))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_len _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_len
			var _4_serialized _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_StructuredEncryptionUtil.Companion_Default___.STRING(), _3_len), _1_name), value)
			_ = _4_serialized
			return m_Wrappers.Companion_Result_.Create_Success_(_4_serialized)
		}
	}
}
func (_static *CompanionStruct_Default___) CollectMap(mapToSerialize _dafny.Map, serialized _dafny.Sequence) m_Wrappers.Result {
	var _0_keys _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((mapToSerialize).Keys(), func(coer50 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg71 interface{}, arg72 interface{}) bool {
			return coer50(arg71.(_dafny.Char), arg72.(_dafny.Char))
		}
	}(Companion_Default___.CharLess))
	_ = _0_keys
	return Companion_Default___.CollectOrderedMapSubset(_0_keys, mapToSerialize, uint64(0), serialized)
}
func (_static *CompanionStruct_Default___) CollectOrderedMapSubset(keys _dafny.Sequence, mapToSerialize _dafny.Map, pos uint64, serialized _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((keys).Cardinality())) == (pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(serialized)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.SerializeMapItem((keys).Select(uint32(pos)).(_dafny.Sequence), (mapToSerialize).Get((keys).Select(uint32(pos)).(_dafny.Sequence)).(_dafny.Sequence))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_data _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_data
			var _in0 _dafny.Sequence = keys
			_ = _in0
			var _in1 _dafny.Map = mapToSerialize
			_ = _in1
			var _in2 uint64 = (pos) + (uint64(1))
			_ = _in2
			var _in3 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(serialized, _1_data)
			_ = _in3
			keys = _in0
			mapToSerialize = _in1
			pos = _in2
			serialized = _in3
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) BoolToUint8(b bool) uint8 {
	if b {
		return uint8(1)
	} else {
		return uint8(0)
	}
}
func (_static *CompanionStruct_Default___) IsUnique(s _dafny.Sequence) bool {
	var _0_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(s)
	_ = _0_asSet
	if (uint64((_0_asSet).CardinalityInt())) == (uint64((s).Cardinality())) {
		return true
	} else {
		return false
	}
}
func (_static *CompanionStruct_Default___) DeserializeBinarySet(serialized _dafny.Sequence, remainingCount uint64, origSerializedSize uint64, resultSet AttrValueAndLength) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (remainingCount) == (uint64(0)) {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsUnique(((resultSet).Dtor_val()).Dtor_BS()), _dafny.SeqOfString("Binary set values must not have duplicates"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(resultSet)
		}
	} else if (uint64((serialized).Cardinality())) < (Companion_Default___.LENGTH__LEN64()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading Binary Set"))
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.BigEndianToU32As64(serialized)
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_len uint64 = (_1_valueOrError1).Extract().(uint64)
			_ = _2_len
			var _3_serialized _dafny.Sequence = (serialized).Drop(uint32(Companion_Default___.LENGTH__LEN64()))
			_ = _3_serialized
			if (uint64((_3_serialized).Cardinality())) < (_2_len) {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Binary Set Structured Data has too few bytes"))
			} else {
				var _4_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.Companion_Sequence_.Concatenate(((resultSet).Dtor_val()).Dtor_BS(), _dafny.SeqOf((_3_serialized).Take(uint32(_2_len)))))
				_ = _4_nattr
				var _in0 _dafny.Sequence = (_3_serialized).Drop(uint32(_2_len))
				_ = _in0
				var _in1 uint64 = (remainingCount) - (func() uint64 { return (uint64(1)) })()
				_ = _in1
				var _in2 uint64 = origSerializedSize
				_ = _in2
				var _in3 AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_4_nattr, (((resultSet).Dtor_len())+(_2_len))+(Companion_Default___.LENGTH__LEN64()))
				_ = _in3
				serialized = _in0
				remainingCount = _in1
				origSerializedSize = _in2
				resultSet = _in3
				goto TAIL_CALL_START
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DeserializeStringSet(serialized _dafny.Sequence, remainingCount uint64, origSerializedSize uint64, resultSet AttrValueAndLength) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (remainingCount) == (uint64(0)) {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsUnique(((resultSet).Dtor_val()).Dtor_SS()), _dafny.SeqOfString("String set values must not have duplicates"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(resultSet)
		}
	} else if (uint64((serialized).Cardinality())) < (Companion_Default___.LENGTH__LEN64()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading String Set"))
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.BigEndianToU32As64(serialized)
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_len uint64 = (_1_valueOrError1).Extract().(uint64)
			_ = _2_len
			var _3_serialized _dafny.Sequence = (serialized).Drop(uint32(Companion_Default___.LENGTH__LEN64()))
			_ = _3_serialized
			if (uint64((_3_serialized).Cardinality())) < (_2_len) {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("String Set Structured Data has too few bytes"))
			} else {
				var _4_valueOrError2 m_Wrappers.Result = m_UTF8.Decode((_3_serialized).Take(uint32(_2_len)))
				_ = _4_valueOrError2
				if (_4_valueOrError2).IsFailure() {
					return (_4_valueOrError2).PropagateFailure()
				} else {
					var _5_nstring _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
					_ = _5_nstring
					var _6_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.Companion_Sequence_.Concatenate(((resultSet).Dtor_val()).Dtor_SS(), _dafny.SeqOf(_5_nstring)))
					_ = _6_nattr
					var _in0 _dafny.Sequence = (_3_serialized).Drop(uint32(_2_len))
					_ = _in0
					var _in1 uint64 = (remainingCount) - (func() uint64 { return (uint64(1)) })()
					_ = _in1
					var _in2 uint64 = origSerializedSize
					_ = _in2
					var _in3 AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_6_nattr, (((resultSet).Dtor_len())+(_2_len))+(Companion_Default___.LENGTH__LEN64()))
					_ = _in3
					serialized = _in0
					remainingCount = _in1
					origSerializedSize = _in2
					resultSet = _in3
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DeserializeNumberSet(serialized _dafny.Sequence, remainingCount uint64, origSerializedSize uint64, resultSet AttrValueAndLength) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (remainingCount) == (uint64(0)) {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsUnique(((resultSet).Dtor_val()).Dtor_NS()), _dafny.SeqOfString("Number set values must not have duplicates"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(resultSet)
		}
	} else if (uint64((serialized).Cardinality())) < (Companion_Default___.LENGTH__LEN64()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading String Set"))
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.BigEndianToU32As64(serialized)
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_len uint64 = (_1_valueOrError1).Extract().(uint64)
			_ = _2_len
			var _3_serialized _dafny.Sequence = (serialized).Drop(uint32(Companion_Default___.LENGTH__LEN64()))
			_ = _3_serialized
			if (uint64((_3_serialized).Cardinality())) < (_2_len) {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Number Set Structured Data has too few bytes"))
			} else {
				var _4_valueOrError2 m_Wrappers.Result = m_UTF8.Decode((_3_serialized).Take(uint32(_2_len)))
				_ = _4_valueOrError2
				if (_4_valueOrError2).IsFailure() {
					return (_4_valueOrError2).PropagateFailure()
				} else {
					var _5_nstring _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
					_ = _5_nstring
					var _6_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.Companion_Sequence_.Concatenate(((resultSet).Dtor_val()).Dtor_NS(), _dafny.SeqOf(_5_nstring)))
					_ = _6_nattr
					var _in0 _dafny.Sequence = (_3_serialized).Drop(uint32(_2_len))
					_ = _in0
					var _in1 uint64 = (remainingCount) - (func() uint64 { return (uint64(1)) })()
					_ = _in1
					var _in2 uint64 = origSerializedSize
					_ = _in2
					var _in3 AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_6_nattr, (((resultSet).Dtor_len())+(_2_len))+(Companion_Default___.LENGTH__LEN64()))
					_ = _in3
					serialized = _in0
					remainingCount = _in1
					origSerializedSize = _in2
					resultSet = _in3
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DeserializeListEntry(serialized _dafny.Sequence, pos uint64, depth uint64, resultList AttrValueAndLength) m_Wrappers.Result {
	var _0_serialized__size uint64 = uint64((serialized).Cardinality())
	_ = _0_serialized__size
	if ((_0_serialized__size) - (func() uint64 { return (pos) })()) < (Companion_Default___.PREFIX__LEN64()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading Type of List element"))
	} else {
		var _1_TerminalTypeId _dafny.Sequence = (serialized).Subsequence(uint32(pos), uint32((pos)+(uint64(2))))
		_ = _1_TerminalTypeId
		var _2_valueOrError0 m_Wrappers.Result = Companion_Default___.BigEndianPosToU32As64(serialized, (pos)+(uint64(2)))
		_ = _2_valueOrError0
		if (_2_valueOrError0).IsFailure() {
			return (_2_valueOrError0).PropagateFailure()
		} else {
			var _3_len uint64 = (_2_valueOrError0).Extract().(uint64)
			_ = _3_len
			var _4_new__pos uint64 = (pos) + (Companion_Default___.PREFIX__LEN64())
			_ = _4_new__pos
			if ((_0_serialized__size) - (func() uint64 { return (_4_new__pos) })()) < (_3_len) {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading Content of List element"))
			} else {
				var _5_valueOrError1 m_Wrappers.Result = Companion_Default___.BytesToAttr(serialized, _1_TerminalTypeId, m_Wrappers.Companion_Option_.Create_Some_(_3_len), (depth)+(uint64(1)), _4_new__pos)
				_ = _5_valueOrError1
				if (_5_valueOrError1).IsFailure() {
					return (_5_valueOrError1).PropagateFailure()
				} else {
					var _6_nval AttrValueAndLength = (_5_valueOrError1).Extract().(AttrValueAndLength)
					_ = _6_nval
					var _7_new__pos uint64 = m_StandardLibrary_MemoryMath.Companion_Default___.Add(_4_new__pos, (_6_nval).Dtor_len())
					_ = _7_new__pos
					var _8_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.Companion_Sequence_.Concatenate(((resultList).Dtor_val()).Dtor_L(), _dafny.SeqOf((_6_nval).Dtor_val())))
					_ = _8_nattr
					var _9_nResultList AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_8_nattr, m_StandardLibrary_MemoryMath.Companion_Default___.Add((resultList).Dtor_len(), (_7_new__pos)-(func() uint64 { return (pos) })()))
					_ = _9_nResultList
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_9_nResultList, _7_new__pos))
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DeserializeList(serialized _dafny.Sequence, pos uint64, remainingCount uint64, depth uint64, resultList AttrValueAndLength) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_AttrValueAndLength_.Default())
	_ = ret
	var _0_npos uint64
	_ = _0_npos
	_0_npos = pos
	var _1_newResultList AttrValueAndLength
	_ = _1_newResultList
	_1_newResultList = resultList
	var _hi0 uint64 = remainingCount
	_ = _hi0
	for _2_i := uint64(0); _2_i < _hi0; _2_i++ {
		var _3_test m_Wrappers.Result
		_ = _3_test
		_3_test = Companion_Default___.DeserializeListEntry(serialized, _0_npos, depth, _1_newResultList)
		if (_3_test).Is_Failure() {
			ret = m_Wrappers.Companion_Result_.Create_Failure_((_3_test).Dtor_error().(_dafny.Sequence))
			return ret
		}
		_1_newResultList = (*((_3_test).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(AttrValueAndLength)
		_0_npos = (*((_3_test).Dtor_value().(_dafny.Tuple)).IndexInt(1)).(uint64)
	}
	ret = m_Wrappers.Companion_Result_.Create_Success_(_1_newResultList)
	return ret
}
func (_static *CompanionStruct_Default___) DeserializeMapEntry(serialized _dafny.Sequence, pos uint64, depth uint64, resultMap AttrValueAndLength) m_Wrappers.Result {
	var _0_serialized__size uint64 = uint64((serialized).Cardinality())
	_ = _0_serialized__size
	var _1_orig__pos uint64 = pos
	_ = _1_orig__pos
	var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((Companion_Default___.PREFIX__LEN64()) <= ((_0_serialized__size)-(func() uint64 { return (pos) })()), _dafny.SeqOfString("Out of bytes reading Map Key"))
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		var _3_TerminalTypeId__key _dafny.Sequence = (serialized).Subsequence(uint32(pos), uint32((pos)+(Companion_Default___.TYPEID__LEN64())))
		_ = _3_TerminalTypeId__key
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(_3_TerminalTypeId__key, m_StructuredEncryptionUtil.Companion_Default___.STRING()), _dafny.SeqOfString("Key of Map is not String"))
		_ = _4_valueOrError1
		if (_4_valueOrError1).IsFailure() {
			return (_4_valueOrError1).PropagateFailure()
		} else {
			var _5_pos uint64 = (pos) + (Companion_Default___.TYPEID__LEN64())
			_ = _5_pos
			var _6_valueOrError2 m_Wrappers.Result = Companion_Default___.BigEndianPosToU32As64(serialized, _5_pos)
			_ = _6_valueOrError2
			if (_6_valueOrError2).IsFailure() {
				return (_6_valueOrError2).PropagateFailure()
			} else {
				var _7_len uint64 = (_6_valueOrError2).Extract().(uint64)
				_ = _7_len
				var _8_pos uint64 = (_5_pos) + (Companion_Default___.LENGTH__LEN64())
				_ = _8_pos
				var _9_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_7_len) <= ((_0_serialized__size)-(func() uint64 { return (_8_pos) })()), _dafny.SeqOfString("Key of Map of Structured Data has too few bytes"))
				_ = _9_valueOrError3
				if (_9_valueOrError3).IsFailure() {
					return (_9_valueOrError3).PropagateFailure()
				} else {
					var _10_valueOrError4 m_Wrappers.Result = m_UTF8.Decode((serialized).Subsequence(uint32(_8_pos), uint32((_8_pos)+(_7_len))))
					_ = _10_valueOrError4
					if (_10_valueOrError4).IsFailure() {
						return (_10_valueOrError4).PropagateFailure()
					} else {
						var _11_key _dafny.Sequence = (_10_valueOrError4).Extract().(_dafny.Sequence)
						_ = _11_key
						var _12_pos uint64 = (_8_pos) + (_7_len)
						_ = _12_pos
						var _13_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(2)) <= ((_0_serialized__size)-(func() uint64 { return (_12_pos) })()), _dafny.SeqOfString("Out of bytes reading Map Value"))
						_ = _13_valueOrError5
						if (_13_valueOrError5).IsFailure() {
							return (_13_valueOrError5).PropagateFailure()
						} else {
							var _14_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_11_key), _dafny.SeqOfString("Key is not valid AttributeName"))
							_ = _14_valueOrError6
							if (_14_valueOrError6).IsFailure() {
								return (_14_valueOrError6).PropagateFailure()
							} else {
								var _15_TerminalTypeId__value _dafny.Sequence = (serialized).Subsequence(uint32(_12_pos), uint32((_12_pos)+(Companion_Default___.TYPEID__LEN64())))
								_ = _15_TerminalTypeId__value
								var _16_pos uint64 = (_12_pos) + (Companion_Default___.TYPEID__LEN64())
								_ = _16_pos
								var _17_valueOrError7 m_Wrappers.Result = Companion_Default___.BytesToAttr(serialized, _15_TerminalTypeId__value, m_Wrappers.Companion_Option_.Create_None_(), (depth)+(uint64(1)), _16_pos)
								_ = _17_valueOrError7
								if (_17_valueOrError7).IsFailure() {
									return (_17_valueOrError7).PropagateFailure()
								} else {
									var _18_nval AttrValueAndLength = (_17_valueOrError7).Extract().(AttrValueAndLength)
									_ = _18_nval
									var _19_pos uint64 = m_StandardLibrary_MemoryMath.Companion_Default___.Add(_16_pos, (_18_nval).Dtor_len())
									_ = _19_pos
									var _20_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!(((resultMap).Dtor_val()).Dtor_M()).Contains(_11_key), _dafny.SeqOfString("Duplicate key in map."))
									_ = _20_valueOrError8
									if (_20_valueOrError8).IsFailure() {
										return (_20_valueOrError8).PropagateFailure()
									} else {
										var _21_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_((((resultMap).Dtor_val()).Dtor_M()).Update(_11_key, (_18_nval).Dtor_val()))
										_ = _21_nattr
										var _22_newResultMap AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_21_nattr, m_StandardLibrary_MemoryMath.Companion_Default___.Add((resultMap).Dtor_len(), (_19_pos)-(func() uint64 { return (_1_orig__pos) })()))
										_ = _22_newResultMap
										return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_22_newResultMap, _19_pos))
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
func (_static *CompanionStruct_Default___) DeserializeMap(serialized _dafny.Sequence, pos uint64, remainingCount uint64, depth uint64, resultMap AttrValueAndLength) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_AttrValueAndLength_.Default())
	_ = ret
	var _0_npos uint64
	_ = _0_npos
	_0_npos = pos
	var _1_newResultMap AttrValueAndLength
	_ = _1_newResultMap
	_1_newResultMap = resultMap
	var _hi0 uint64 = remainingCount
	_ = _hi0
	for _2_i := uint64(0); _2_i < _hi0; _2_i++ {
		var _3_test m_Wrappers.Result
		_ = _3_test
		_3_test = Companion_Default___.DeserializeMapEntry(serialized, _0_npos, depth, _1_newResultMap)
		if (_3_test).Is_Failure() {
			ret = m_Wrappers.Companion_Result_.Create_Failure_((_3_test).Dtor_error().(_dafny.Sequence))
			return ret
		}
		_1_newResultMap = (*((_3_test).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(AttrValueAndLength)
		_0_npos = (*((_3_test).Dtor_value().(_dafny.Tuple)).IndexInt(1)).(uint64)
	}
	ret = m_Wrappers.Companion_Result_.Create_Success_(_1_newResultMap)
	return ret
}
func (_static *CompanionStruct_Default___) BytesToAttr(value _dafny.Sequence, typeId _dafny.Sequence, totalBytes m_Wrappers.Option, depth uint64, pos uint64) m_Wrappers.Result {
	var _0_value__size uint64 = uint64((value).Cardinality())
	_ = _0_value__size
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((depth) <= (m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH()), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Depth of attribute structure to deserialize exceeds limit of "), m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH__STR()))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Result = (func() m_Wrappers.Result {
			if (totalBytes).Is_None() {
				return Companion_Default___.BigEndianPosToU32As64(value, pos)
			}
			return m_Wrappers.Companion_Result_.Create_Success_((totalBytes).Dtor_value().(uint64))
		})()
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_len uint64 = (_2_valueOrError1).Extract().(uint64)
			_ = _3_len
			var _4_pos uint64 = (func() uint64 {
				if (totalBytes).Is_None() {
					return m_StandardLibrary_MemoryMath.Companion_Default___.Add(pos, Companion_Default___.LENGTH__LEN64())
				}
				return pos
			})()
			_ = _4_pos
			var _5_lengthBytes uint64 = (func() uint64 {
				if (totalBytes).Is_None() {
					return Companion_Default___.LENGTH__LEN64()
				}
				return uint64(0)
			})()
			_ = _5_lengthBytes
			if ((_0_value__size) - (func() uint64 { return (_4_pos) })()) < (_3_len) {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Structured Data has too few bytes"))
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.NULL()) {
				if (_3_len) != (uint64(0)) /* dircomp */ {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("NULL type did not have length zero"))
				} else {
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true), _5_lengthBytes))
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.STRING()) {
				var _6_valueOrError2 m_Wrappers.Result = m_UTF8.Decode((value).Subsequence(uint32(_4_pos), uint32((_4_pos)+(_3_len))))
				_ = _6_valueOrError2
				if (_6_valueOrError2).IsFailure() {
					return (_6_valueOrError2).PropagateFailure()
				} else {
					var _7_str _dafny.Sequence = (_6_valueOrError2).Extract().(_dafny.Sequence)
					_ = _7_str
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_7_str), (_3_len)+(_5_lengthBytes)))
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.NUMBER()) {
				var _8_valueOrError3 m_Wrappers.Result = m_UTF8.Decode((value).Subsequence(uint32(_4_pos), uint32((_4_pos)+(_3_len))))
				_ = _8_valueOrError3
				if (_8_valueOrError3).IsFailure() {
					return (_8_valueOrError3).PropagateFailure()
				} else {
					var _9_str _dafny.Sequence = (_8_valueOrError3).Extract().(_dafny.Sequence)
					_ = _9_str
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_9_str), (_3_len)+(_5_lengthBytes)))
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.BINARY()) {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_((value).Subsequence(uint32(_4_pos), uint32((_4_pos)+(_3_len)))), (_3_len)+(_5_lengthBytes)))
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.BOOLEAN()) {
				if (_3_len) != (Companion_Default___.BOOL__LEN64()) /* dircomp */ {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Boolean Structured Data has more than one byte"))
				} else if ((value).Select(uint32(_4_pos)).(uint8)) == (uint8(0)) {
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(false), (Companion_Default___.BOOL__LEN64())+(_5_lengthBytes)))
				} else if ((value).Select(uint32(_4_pos)).(uint8)) == (uint8(1)) {
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(true), (Companion_Default___.BOOL__LEN64())+(_5_lengthBytes)))
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Boolean Structured Data had inappropriate value"))
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.STRING__SET()) {
				if ((_0_value__size) - (func() uint64 { return (_4_pos) })()) < (Companion_Default___.LENGTH__LEN64()) {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("String Set Structured Data has less than LENGTH_LEN bytes"))
				} else {
					var _10_valueOrError4 m_Wrappers.Result = Companion_Default___.BigEndianPosToU32As64(value, _4_pos)
					_ = _10_valueOrError4
					if (_10_valueOrError4).IsFailure() {
						return (_10_valueOrError4).PropagateFailure()
					} else {
						var _11_len uint64 = (_10_valueOrError4).Extract().(uint64)
						_ = _11_len
						var _12_pos uint64 = (_4_pos) + (Companion_Default___.LENGTH__LEN64())
						_ = _12_pos
						var _13_valueOrError5 m_Wrappers.Result = Companion_Default___.DeserializeStringSet((value).Drop(uint32(_12_pos)), _11_len, m_StandardLibrary_MemoryMath.Companion_Default___.Add3((_0_value__size)-(func() uint64 { return (_12_pos) })(), Companion_Default___.LENGTH__LEN64(), _5_lengthBytes), Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf()), (Companion_Default___.LENGTH__LEN64())+(_5_lengthBytes)))
						_ = _13_valueOrError5
						if (_13_valueOrError5).IsFailure() {
							return (_13_valueOrError5).PropagateFailure()
						} else {
							var _14_retval AttrValueAndLength = (_13_valueOrError5).Extract().(AttrValueAndLength)
							_ = _14_retval
							return m_Wrappers.Companion_Result_.Create_Success_(_14_retval)
						}
					}
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.NUMBER__SET()) {
				if ((_0_value__size) - (func() uint64 { return (_4_pos) })()) < (Companion_Default___.LENGTH__LEN64()) {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Number Set Structured Data has less than 4 bytes"))
				} else {
					var _15_valueOrError6 m_Wrappers.Result = Companion_Default___.BigEndianPosToU32As64(value, _4_pos)
					_ = _15_valueOrError6
					if (_15_valueOrError6).IsFailure() {
						return (_15_valueOrError6).PropagateFailure()
					} else {
						var _16_len uint64 = (_15_valueOrError6).Extract().(uint64)
						_ = _16_len
						var _17_pos uint64 = (_4_pos) + (Companion_Default___.LENGTH__LEN64())
						_ = _17_pos
						var _18_valueOrError7 m_Wrappers.Result = Companion_Default___.DeserializeNumberSet((value).Drop(uint32(_17_pos)), _16_len, m_StandardLibrary_MemoryMath.Companion_Default___.Add3((_0_value__size)-(func() uint64 { return (_17_pos) })(), Companion_Default___.LENGTH__LEN64(), _5_lengthBytes), Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf()), (Companion_Default___.LENGTH__LEN64())+(_5_lengthBytes)))
						_ = _18_valueOrError7
						if (_18_valueOrError7).IsFailure() {
							return (_18_valueOrError7).PropagateFailure()
						} else {
							var _19_retval AttrValueAndLength = (_18_valueOrError7).Extract().(AttrValueAndLength)
							_ = _19_retval
							return m_Wrappers.Companion_Result_.Create_Success_(_19_retval)
						}
					}
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.BINARY__SET()) {
				if ((_0_value__size) - (func() uint64 { return (_4_pos) })()) < (Companion_Default___.LENGTH__LEN64()) {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Binary Set Structured Data has less than LENGTH_LEN bytes"))
				} else {
					var _20_valueOrError8 m_Wrappers.Result = Companion_Default___.BigEndianPosToU32As64(value, _4_pos)
					_ = _20_valueOrError8
					if (_20_valueOrError8).IsFailure() {
						return (_20_valueOrError8).PropagateFailure()
					} else {
						var _21_len uint64 = (_20_valueOrError8).Extract().(uint64)
						_ = _21_len
						var _22_pos uint64 = (_4_pos) + (Companion_Default___.LENGTH__LEN64())
						_ = _22_pos
						var _23_valueOrError9 m_Wrappers.Result = Companion_Default___.DeserializeBinarySet((value).Drop(uint32(_22_pos)), _21_len, m_StandardLibrary_MemoryMath.Companion_Default___.Add3((_0_value__size)-(func() uint64 { return (_22_pos) })(), Companion_Default___.LENGTH__LEN64(), _5_lengthBytes), Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf()), (Companion_Default___.LENGTH__LEN64())+(_5_lengthBytes)))
						_ = _23_valueOrError9
						if (_23_valueOrError9).IsFailure() {
							return (_23_valueOrError9).PropagateFailure()
						} else {
							var _24_retval AttrValueAndLength = (_23_valueOrError9).Extract().(AttrValueAndLength)
							_ = _24_retval
							return m_Wrappers.Companion_Result_.Create_Success_(_24_retval)
						}
					}
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.MAP()) {
				if (_0_value__size) < (m_StandardLibrary_MemoryMath.Companion_Default___.Add(Companion_Default___.LENGTH__LEN64(), _4_pos)) {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("List Structured Data has less than 4 bytes"))
				} else {
					var _25_valueOrError10 m_Wrappers.Result = Companion_Default___.BigEndianPosToU32As64(value, _4_pos)
					_ = _25_valueOrError10
					if (_25_valueOrError10).IsFailure() {
						return (_25_valueOrError10).PropagateFailure()
					} else {
						var _26_len uint64 = (_25_valueOrError10).Extract().(uint64)
						_ = _26_len
						var _27_pos uint64 = (_4_pos) + (Companion_Default___.LENGTH__LEN64())
						_ = _27_pos
						var _28_resultMap AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap()), (Companion_Default___.LENGTH__LEN64())+(_5_lengthBytes))
						_ = _28_resultMap
						var _29_valueOrError11 m_Wrappers.Result = Companion_Default___.DeserializeMap(value, _27_pos, _26_len, depth, _28_resultMap)
						_ = _29_valueOrError11
						if (_29_valueOrError11).IsFailure() {
							return (_29_valueOrError11).PropagateFailure()
						} else {
							var _30_retval AttrValueAndLength = (_29_valueOrError11).Extract().(AttrValueAndLength)
							_ = _30_retval
							return m_Wrappers.Companion_Result_.Create_Success_(_30_retval)
						}
					}
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.LIST()) {
				if (_0_value__size) < (m_StandardLibrary_MemoryMath.Companion_Default___.Add(Companion_Default___.LENGTH__LEN64(), _4_pos)) {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("List Structured Data has less than 4 bytes"))
				} else {
					var _31_valueOrError12 m_Wrappers.Result = Companion_Default___.BigEndianPosToU32As64(value, _4_pos)
					_ = _31_valueOrError12
					if (_31_valueOrError12).IsFailure() {
						return (_31_valueOrError12).PropagateFailure()
					} else {
						var _32_len uint64 = (_31_valueOrError12).Extract().(uint64)
						_ = _32_len
						var _33_pos uint64 = (_4_pos) + (Companion_Default___.LENGTH__LEN64())
						_ = _33_pos
						var _34_resultList AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf()), (Companion_Default___.LENGTH__LEN64())+(_5_lengthBytes))
						_ = _34_resultList
						var _35_valueOrError13 m_Wrappers.Result = Companion_Default___.DeserializeList(value, _33_pos, _32_len, depth, _34_resultList)
						_ = _35_valueOrError13
						if (_35_valueOrError13).IsFailure() {
							return (_35_valueOrError13).PropagateFailure()
						} else {
							var _36_retval AttrValueAndLength = (_35_valueOrError13).Extract().(AttrValueAndLength)
							_ = _36_retval
							return m_Wrappers.Companion_Result_.Create_Success_(_36_retval)
						}
					}
				}
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Unsupported TerminalTypeId"))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) FlattenValueMap(m _dafny.Map) _dafny.Map {
	return func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter14 := _dafny.Iterate((m).Keys().Elements()); ; {
			_compr_0, _ok14 := _iter14()
			if !_ok14 {
				break
			}
			var _0_k interface{}
			_0_k = interface{}(_compr_0).(interface{})
			if ((m).Contains(_0_k)) && (((m).Get(_0_k).(m_Wrappers.Result)).Is_Success()) {
				_coll0.Add(_0_k, ((m).Get(_0_k).(m_Wrappers.Result)).Dtor_value())
			}
		}
		return _coll0.ToMap()
	}()
}
func (_static *CompanionStruct_Default___) FlattenErrors(m _dafny.Map) _dafny.Set {
	return func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter15 := _dafny.Iterate((m).Keys().Elements()); ; {
			_compr_0, _ok15 := _iter15()
			if !_ok15 {
				break
			}
			var _0_k interface{}
			_0_k = interface{}(_compr_0).(interface{})
			if ((m).Contains(_0_k)) && (((m).Get(_0_k).(m_Wrappers.Result)).Is_Failure()) {
				_coll0.Add(((m).Get(_0_k).(m_Wrappers.Result)).Dtor_error().(_dafny.Sequence))
			}
		}
		return _coll0.ToSet()
	}()
}
func (_static *CompanionStruct_Default___) SimplifyMapValue(m _dafny.Map) m_Wrappers.Result {
	if _dafny.Quantifier((m).Keys().Elements(), true, func(_forall_var_0 interface{}) bool {
		var _0_k interface{}
		_0_k = interface{}(_forall_var_0).(interface{})
		return !((m).Contains(_0_k)) || (((m).Get(_0_k).(m_Wrappers.Result)).Is_Success())
	}) {
		var _1_result _dafny.Map = Companion_Default___.FlattenValueMap(m)
		_ = _1_result
		return m_Wrappers.Companion_Result_.Create_Success_(_1_result)
	} else {
		var _2_badValues _dafny.Set = Companion_Default___.FlattenErrors(m)
		_ = _2_badValues
		var _3_badValueSeq _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_2_badValues, func(coer51 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg73 interface{}, arg74 interface{}) bool {
				return coer51(arg73.(_dafny.Char), arg74.(_dafny.Char))
			}
		}(Companion_Default___.CharLess))
		_ = _3_badValueSeq
		return m_Wrappers.Companion_Result_.Create_Failure_(m_StandardLibrary.Companion_Default___.Join(_3_badValueSeq, _dafny.SeqOfString("\n")))
	}
}
func (_static *CompanionStruct_Default___) LENGTH__LEN64() uint64 {
	return uint64(4)
}
func (_static *CompanionStruct_Default___) TYPEID__LEN64() uint64 {
	return uint64(2)
}
func (_static *CompanionStruct_Default___) BOOL__LEN64() uint64 {
	return uint64(1)
}
func (_static *CompanionStruct_Default___) PREFIX__LEN64() uint64 {
	return uint64(6)
}

// End of class Default__

// Definition of datatype AttrValueAndLength
type AttrValueAndLength struct {
	Data_AttrValueAndLength_
}

func (_this AttrValueAndLength) Get_() Data_AttrValueAndLength_ {
	return _this.Data_AttrValueAndLength_
}

type Data_AttrValueAndLength_ interface {
	isAttrValueAndLength()
}

type CompanionStruct_AttrValueAndLength_ struct {
}

var Companion_AttrValueAndLength_ = CompanionStruct_AttrValueAndLength_{}

type AttrValueAndLength_AttrValueAndLength struct {
	Val m_ComAmazonawsDynamodbTypes.AttributeValue
	Len uint64
}

func (AttrValueAndLength_AttrValueAndLength) isAttrValueAndLength() {}

func (CompanionStruct_AttrValueAndLength_) Create_AttrValueAndLength_(Val m_ComAmazonawsDynamodbTypes.AttributeValue, Len uint64) AttrValueAndLength {
	return AttrValueAndLength{AttrValueAndLength_AttrValueAndLength{Val, Len}}
}

func (_this AttrValueAndLength) Is_AttrValueAndLength() bool {
	_, ok := _this.Get_().(AttrValueAndLength_AttrValueAndLength)
	return ok
}

func (CompanionStruct_AttrValueAndLength_) Default() AttrValueAndLength {
	return Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Default(), uint64(0))
}

func (_this AttrValueAndLength) Dtor_val() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return _this.Get_().(AttrValueAndLength_AttrValueAndLength).Val
}

func (_this AttrValueAndLength) Dtor_len() uint64 {
	return _this.Get_().(AttrValueAndLength_AttrValueAndLength).Len
}

func (_this AttrValueAndLength) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AttrValueAndLength_AttrValueAndLength:
		{
			return "DynamoToStruct.AttrValueAndLength.AttrValueAndLength" + "(" + _dafny.String(data.Val) + ", " + _dafny.String(data.Len) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AttrValueAndLength) Equals(other AttrValueAndLength) bool {
	switch data1 := _this.Get_().(type) {
	case AttrValueAndLength_AttrValueAndLength:
		{
			data2, ok := other.Get_().(AttrValueAndLength_AttrValueAndLength)
			return ok && data1.Val.Equals(data2.Val) && data1.Len == data2.Len
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AttrValueAndLength) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AttrValueAndLength)
	return ok && _this.Equals(typed)
}

func Type_AttrValueAndLength_() _dafny.TypeDescriptor {
	return type_AttrValueAndLength_{}
}

type type_AttrValueAndLength_ struct {
}

func (_this type_AttrValueAndLength_) Default() interface{} {
	return Companion_AttrValueAndLength_.Default()
}

func (_this type_AttrValueAndLength_) String() string {
	return "DynamoToStruct.AttrValueAndLength"
}
func (_this AttrValueAndLength) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AttrValueAndLength{}

// End of datatype AttrValueAndLength
