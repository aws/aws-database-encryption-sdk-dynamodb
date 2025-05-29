// Package AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations
// Dafny module AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations compiled into Go

package AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations

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
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/Maps_"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/SortCanon"
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
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ResolveAuthActions(config Config, input m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ResolveAuthActionsInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_ResolveAuthActionsOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.AuthListHasNoDuplicatesFromSet((input).Dtor_authActions()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Duplicate Paths")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _1_valueOrError1
	_1_valueOrError1 = m_StructuredEncryptionHeader.Companion_Default___.PartialDeserialize((input).Dtor_headerBytes())
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_head m_StructuredEncryptionHeader.PartialHeader
	_ = _2_head
	_2_head = (_1_valueOrError1).Extract().(m_StructuredEncryptionHeader.PartialHeader)
	var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError2
	_3_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.ValidString((input).Dtor_tableName()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad Table Name")))
	if (_3_valueOrError2).IsFailure() {
		output = (_3_valueOrError2).PropagateFailure()
		return output
	}
	var _4_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError3
	_4_valueOrError3 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((input).Dtor_authActions()).UniqueElements(), false, func(_exists_var_0 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem) bool {
		var _5_x m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem
		_5_x = interface{}(_exists_var_0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)
		return (_dafny.Companion_Sequence_.Contains((input).Dtor_authActions(), _5_x)) && (_dafny.Companion_Sequence_.Equal((_5_x).Dtor_key(), m_StructuredEncryptionUtil.Companion_Default___.HeaderPath()))
	}), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Header Required")))
	if (_4_valueOrError3).IsFailure() {
		output = (_4_valueOrError3).PropagateFailure()
		return output
	}
	var _6_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _6_valueOrError4
	_6_valueOrError4 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((input).Dtor_authActions()).UniqueElements(), false, func(_exists_var_1 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem) bool {
		var _7_x m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem
		_7_x = interface{}(_exists_var_1).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)
		return (_dafny.Companion_Sequence_.Contains((input).Dtor_authActions(), _7_x)) && (_dafny.Companion_Sequence_.Equal((_7_x).Dtor_key(), m_StructuredEncryptionUtil.Companion_Default___.FooterPath()))
	}), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Footer Required")))
	if (_6_valueOrError4).IsFailure() {
		output = (_6_valueOrError4).PropagateFailure()
		return output
	}
	var _8_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError5
	_8_valueOrError5 = m_Canonize.Companion_Default___.ForDecrypt((input).Dtor_tableName(), (input).Dtor_authActions(), (_2_head).Dtor_legend())
	if (_8_valueOrError5).IsFailure() {
		output = (_8_valueOrError5).PropagateFailure()
		return output
	}
	var _9_canonData _dafny.Sequence
	_ = _9_canonData
	_9_canonData = (_8_valueOrError5).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_ResolveAuthActionsOutput_.Create_ResolveAuthActionsOutput_(m_Canonize.Companion_Default___.UnCanon(_9_canonData, uint64(0), _dafny.SeqOf())))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetBinary(data _dafny.Sequence, path _dafny.Sequence) m_Wrappers.Result {
	var _0_pos m_Wrappers.Option = Companion_Default___.FindAuth(data, path, uint64(0))
	_ = _0_pos
	if (_0_pos).Is_None() {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("The field name "), m_StructuredEncryptionPaths.Companion_Default___.PathToString(path)), _dafny.SeqOfString(" is required."))))
	} else if !_dafny.Companion_Sequence_.Equal((((data).Select(uint32((_0_pos).Dtor_value().(uint64))).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)).Dtor_data()).Dtor_typeId(), m_StructuredEncryptionUtil.Companion_Default___.BYTES__TYPE__ID()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(m_StructuredEncryptionPaths.Companion_Default___.PathToString(path), _dafny.SeqOfString(" must be a binary Terminal."))))
	} else if !(((data).Select(uint32((_0_pos).Dtor_value().(uint64))).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_AuthenticateAction_.Create_DO__NOT__SIGN_()) {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(m_StructuredEncryptionPaths.Companion_Default___.PathToString(path), _dafny.SeqOfString(" must be DO_NOT_SIGN."))))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(((data).Select(uint32((_0_pos).Dtor_value().(uint64))).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)).Dtor_data())
	}
}
func (_static *CompanionStruct_Default___) SumValueSize(fields _dafny.Sequence) uint64 {
	var _hresult uint64 = uint64(0)
	_ = _hresult
	var _0_sum uint64
	_ = _0_sum
	_0_sum = uint64(0)
	var _lo0 uint64 = uint64(0)
	_ = _lo0
	for _1_i := uint64((fields).Cardinality()); _lo0 < _1_i; {
		_1_i--
		if (((fields).Select(uint32(_1_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()) {
			_0_sum = m_StandardLibrary_MemoryMath.Companion_Default___.Add(uint64(((((fields).Select(uint32(_1_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_data()).Dtor_value()).Cardinality()), _0_sum)
		}
	}
	_hresult = _0_sum
	return _hresult
	return _hresult
}
func (_static *CompanionStruct_Default___) GetAlgorithmSuiteId(alg m_Wrappers.Option) m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId {
	if (alg).Is_Some() {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_AlgorithmSuiteId_.Create_DBE_((alg).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId))
	} else {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_AlgorithmSuiteId_.Create_DBE_(m_AwsCryptographyMaterialProvidersTypes.Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384_())
	}
}
func (_static *CompanionStruct_Default___) GetStructuredEncryptionMaterials(cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager, encryptionContext m_Wrappers.Option, algorithmSuiteId m_Wrappers.Option, encryptedTerminalDataNum uint64, totalEncryptedTerminalValuesSize uint64) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Result{}
	_ = ret
	var _0_maxLength uint64
	_ = _0_maxLength
	_0_maxLength = m_StandardLibrary_MemoryMath.Companion_Default___.Add3(encryptedTerminalDataNum, encryptedTerminalDataNum, totalEncryptedTerminalValuesSize)
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError0
	_1_valueOrError0 = m_Wrappers.Companion_Default___.Need((_0_maxLength) < ((m_StandardLibrary_UInt.Companion_Default___.INT64__MAX__LIMIT()).Uint64()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Encrypted Size too long.")))
	if (_1_valueOrError0).IsFailure() {
		ret = (_1_valueOrError0).PropagateFailure()
		return ret
	}
	var _2_algId m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteId
	_ = _2_algId
	_2_algId = Companion_Default___.GetAlgorithmSuiteId(algorithmSuiteId)
	var _3_matR m_Wrappers.Result
	_ = _3_matR
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (cmm).GetEncryptionMaterials(m_AwsCryptographyMaterialProvidersTypes.Companion_GetEncryptionMaterialsInput_.Create_GetEncryptionMaterialsInput_((encryptionContext).UnwrapOr(_dafny.NewMapBuilder().ToMap()).(_dafny.Map), Companion_Default___.DBE__COMMITMENT__POLICY(), m_Wrappers.Companion_Option_.Create_Some_(_2_algId), m_Wrappers.Companion_Option_.Create_Some_(int64(_0_maxLength)), m_Wrappers.Companion_Option_.Create_None_()))
	_3_matR = _out0
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError1
	_4_valueOrError1 = (_3_matR).MapFailure(func(coer23 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg32 interface{}) interface{} {
			return coer23(arg32.(m_AwsCryptographyMaterialProvidersTypes.Error))
		}
	}(func(_5_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_5_e)
	}))
	if (_4_valueOrError1).IsFailure() {
		ret = (_4_valueOrError1).PropagateFailure()
		return ret
	}
	var _6_matOutput m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsOutput
	_ = _6_matOutput
	_6_matOutput = (_4_valueOrError1).Extract().(m_AwsCryptographyMaterialProvidersTypes.GetEncryptionMaterialsOutput)
	var _7_mat m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
	_ = _7_mat
	_7_mat = (_6_matOutput).Dtor_encryptionMaterials()
	var _8_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError2
	_8_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.EncryptionMaterialsHasPlaintextDataKey(_7_mat), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Encryption material has no key")))
	if (_8_valueOrError2).IsFailure() {
		ret = (_8_valueOrError2).PropagateFailure()
		return ret
	}
	var _9_alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	_ = _9_alg
	_9_alg = (_7_mat).Dtor_algorithmSuite()
	var _10_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _10_valueOrError3
	_10_valueOrError3 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.ValidSuite(_9_alg), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Algorithm Suite")))
	if (_10_valueOrError3).IsFailure() {
		ret = (_10_valueOrError3).PropagateFailure()
		return ret
	}
	var _11_key _dafny.Sequence
	_ = _11_key
	_11_key = ((_7_mat).Dtor_plaintextDataKey()).Dtor_value().(_dafny.Sequence)
	ret = m_Wrappers.Companion_Result_.Create_Success_(_7_mat)
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) GetV2EncryptionContextCanon(schema _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_canonAttrs _dafny.Sequence
	_ = _0_canonAttrs
	_0_canonAttrs = m_Seq.Companion_Default___.Filter(func(coer24 func(m_StructuredEncryptionUtil.CanonCryptoItem) bool) func(interface{}) bool {
		return func(arg33 interface{}) bool {
			return coer24(arg33.(m_StructuredEncryptionUtil.CanonCryptoItem))
		}
	}(func(_1_s m_StructuredEncryptionUtil.CanonCryptoItem) bool {
		return ((_1_s).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_())
	}), schema)
	var _2_contextAttrs _dafny.Sequence
	_ = _2_contextAttrs
	_2_contextAttrs = m_Seq.Companion_Default___.Map(func(coer25 func(m_StructuredEncryptionUtil.CanonCryptoItem) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) func(interface{}) interface{} {
		return func(arg34 interface{}) interface{} {
			return coer25(arg34.(m_StructuredEncryptionUtil.CanonCryptoItem))
		}
	}(func(_3_s m_StructuredEncryptionUtil.CanonCryptoItem) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoItem_.Create_CryptoItem_((_3_s).Dtor_origKey(), (_3_s).Dtor_data(), (_3_s).Dtor_action())
	}), _0_canonAttrs)
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.GetV2EncryptionContext2(_2_contextAttrs)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) GetV2EncryptionContext(schema _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_contextAttrs _dafny.Sequence
	_ = _0_contextAttrs
	_0_contextAttrs = m_Seq.Companion_Default___.Filter(func(coer26 func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) bool) func(interface{}) bool {
		return func(arg35 interface{}) bool {
			return coer26(arg35.(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem))
		}
	}(func(_1_s m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) bool {
		return ((_1_s).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_())
	}), schema)
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.GetV2EncryptionContext2(_0_contextAttrs)
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) Find(haystack _dafny.Sequence, needle _dafny.Sequence, start uint64) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(uint64(0))
	_ = res
	var _hi0 uint64 = uint64((haystack).Cardinality())
	_ = _hi0
	for _0_i := uint64(0); _0_i < _hi0; _0_i++ {
		if _dafny.Companion_Sequence_.Equal(((haystack).Select(uint32(_0_i)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_key(), needle) {
			res = m_Wrappers.Companion_Result_.Create_Success_(_0_i)
			return res
		}
	}
	res = m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Not Found")))
	return res
	return res
}
func (_static *CompanionStruct_Default___) FindAuth(haystack _dafny.Sequence, needle _dafny.Sequence, start uint64) m_Wrappers.Option {
	var res m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = res
	var _hi0 uint64 = uint64((haystack).Cardinality())
	_ = _hi0
	for _0_i := uint64(0); _0_i < _hi0; _0_i++ {
		if _dafny.Companion_Sequence_.Equal(((haystack).Select(uint32(_0_i)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)).Dtor_key(), needle) {
			res = m_Wrappers.Companion_Option_.Create_Some_(_0_i)
			return res
		}
	}
	res = m_Wrappers.Companion_Option_.Create_None_()
	return res
	return res
}
func (_static *CompanionStruct_Default___) CountEncrypted(list _dafny.Sequence) uint64 {
	var _hresult uint64 = uint64(0)
	_ = _hresult
	var _0_result uint64
	_ = _0_result
	_0_result = uint64(0)
	var _lo0 uint64 = uint64(0)
	_ = _lo0
	for _1_i := uint64((list).Cardinality()); _lo0 < _1_i; {
		_1_i--
		if (((list).Select(uint32(_1_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()) {
			_0_result = m_StandardLibrary_MemoryMath.Companion_Default___.Add(_0_result, uint64(1))
		}
	}
	_hresult = _0_result
	return _hresult
	return _hresult
}
func (_static *CompanionStruct_Default___) GetV2EncryptionContext2(fields _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_fieldMap _dafny.Map
	_ = _0_fieldMap
	_0_fieldMap = _dafny.NewMapBuilder().ToMap()
	var _hi0 uint64 = uint64((fields).Cardinality())
	_ = _hi0
	for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
		var _2_keyVal _dafny.Sequence
		_ = _2_keyVal
		_2_keyVal = _dafny.Companion_Sequence_.Concatenate(m_StructuredEncryptionUtil.Companion_Default___.ATTR__PREFIX(), m_StructuredEncryptionPaths.Companion_Default___.PathToString(((fields).Select(uint32(_1_i)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_key()))
		var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _3_valueOrError0
		_3_valueOrError0 = (m_UTF8.Encode(_2_keyVal)).MapFailure(func(coer27 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
			return func(arg36 interface{}) interface{} {
				return coer27(arg36.(_dafny.Sequence))
			}
		}(func(_4_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
			return m_StructuredEncryptionUtil.Companion_Default___.E(_4_e)
		}))
		if (_3_valueOrError0).IsFailure() {
			output = (_3_valueOrError0).PropagateFailure()
			return output
		}
		var _5_utf8Value _dafny.Sequence
		_ = _5_utf8Value
		_5_utf8Value = (_3_valueOrError0).Extract().(_dafny.Sequence)
		if (_0_fieldMap).Contains(_5_utf8Value) {
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_2_keyVal, _dafny.SeqOfString(" appears twice in encryption context."))))
			return output
		}
		_0_fieldMap = (_0_fieldMap).Update(_5_utf8Value, ((fields).Select(uint32(_1_i)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_key())
	}
	var _6_keys _dafny.Sequence
	_ = _6_keys
	_6_keys = m_SortedSets.SetToOrderedSequence2((_0_fieldMap).Keys(), func(coer28 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
		return func(arg37 interface{}, arg38 interface{}) bool {
			return coer28(arg37.(uint8), arg38.(uint8))
		}
	}(m_StructuredEncryptionUtil.Companion_Default___.ByteLess))
	var _7_newContext _dafny.Map
	_ = _7_newContext
	_7_newContext = _dafny.NewMapBuilder().ToMap()
	var _8_legend _dafny.Sequence
	_ = _8_legend
	_8_legend = _dafny.SeqOfString("")
	var _hi1 uint64 = uint64((_6_keys).Cardinality())
	_ = _hi1
	for _9_i := uint64(0); _9_i < _hi1; _9_i++ {
		var _10_fieldUtf8 _dafny.Sequence
		_ = _10_fieldUtf8
		_10_fieldUtf8 = (_6_keys).Select(uint32(_9_i)).(_dafny.Sequence)
		var _11_fieldStr _dafny.Sequence
		_ = _11_fieldStr
		_11_fieldStr = (_0_fieldMap).Get(_10_fieldUtf8).(_dafny.Sequence)
		var _12_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(uint64(0))
		_ = _12_valueOrError1
		_12_valueOrError1 = Companion_Default___.Find(fields, (_0_fieldMap).Get(_10_fieldUtf8).(_dafny.Sequence), uint64(0))
		if (_12_valueOrError1).IsFailure() {
			output = (_12_valueOrError1).PropagateFailure()
			return output
		}
		var _13_item uint64
		_ = _13_item
		_13_item = (_12_valueOrError1).Extract().(uint64)
		var _14_attr m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
		_ = _14_attr
		_14_attr = ((fields).Select(uint32(_13_item)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_data()
		var _15_attrStr _dafny.Sequence = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
		_ = _15_attrStr
		var _16_legendChar _dafny.Char = _dafny.Char('D')
		_ = _16_legendChar
		if _dafny.Companion_Sequence_.Equal((_14_attr).Dtor_typeId(), m_StructuredEncryptionUtil.Companion_Default___.NULL()) {
			_16_legendChar = m_StructuredEncryptionUtil.Companion_Default___.LEGEND__LITERAL()
			_15_attrStr = m_StructuredEncryptionUtil.Companion_Default___.NULL__UTF8()
		} else if _dafny.Companion_Sequence_.Equal((_14_attr).Dtor_typeId(), m_StructuredEncryptionUtil.Companion_Default___.STRING()) {
			_16_legendChar = m_StructuredEncryptionUtil.Companion_Default___.LEGEND__STRING()
			var _17_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _17_valueOrError2
			_17_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq((_14_attr).Dtor_value()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error : string was not UTF8.")))
			if (_17_valueOrError2).IsFailure() {
				output = (_17_valueOrError2).PropagateFailure()
				return output
			}
			_15_attrStr = (_14_attr).Dtor_value()
			var _18_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _18_valueOrError3
			_18_valueOrError3 = m_UTF8.Decode(_15_attrStr)
			if !(!((_18_valueOrError3).IsFailure())) {
				panic("dafny/StructuredEncryption/src/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.dfy(428,18): " + (_18_valueOrError3).String())
			}
			var _19_yy _dafny.Sequence
			_ = _19_yy
			_19_yy = (_18_valueOrError3).Extract().(_dafny.Sequence)
		} else if _dafny.Companion_Sequence_.Equal((_14_attr).Dtor_typeId(), m_StructuredEncryptionUtil.Companion_Default___.NUMBER()) {
			_16_legendChar = m_StructuredEncryptionUtil.Companion_Default___.LEGEND__NUMBER()
			var _20_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _20_valueOrError4
			_20_valueOrError4 = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq((_14_attr).Dtor_value()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error : number was not UTF8.")))
			if (_20_valueOrError4).IsFailure() {
				output = (_20_valueOrError4).PropagateFailure()
				return output
			}
			_15_attrStr = (_14_attr).Dtor_value()
		} else if _dafny.Companion_Sequence_.Equal((_14_attr).Dtor_typeId(), m_StructuredEncryptionUtil.Companion_Default___.BOOLEAN()) {
			_16_legendChar = m_StructuredEncryptionUtil.Companion_Default___.LEGEND__LITERAL()
			var _21_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _21_valueOrError5
			_21_valueOrError5 = m_Wrappers.Companion_Default___.Need((uint64(((_14_attr).Dtor_value()).Cardinality())) == (uint64(1)), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error : boolean was not of length 1.")))
			if (_21_valueOrError5).IsFailure() {
				output = (_21_valueOrError5).PropagateFailure()
				return output
			}
			if (((_14_attr).Dtor_value()).Select(uint32(uint32(0))).(uint8)) == (uint8(0)) {
				_15_attrStr = m_StructuredEncryptionUtil.Companion_Default___.FALSE__UTF8()
			} else {
				_15_attrStr = m_StructuredEncryptionUtil.Companion_Default___.TRUE__UTF8()
			}
		} else {
			_16_legendChar = m_StructuredEncryptionUtil.Companion_Default___.LEGEND__BINARY()
			_15_attrStr = m_StructuredEncryptionUtil.Companion_Default___.EncodeTerminal(_14_attr)
		}
		_7_newContext = (_7_newContext).Update(_10_fieldUtf8, _15_attrStr)
		_8_legend = _dafny.Companion_Sequence_.Concatenate(_8_legend, _dafny.SeqOfChars(_16_legendChar))
	}
	var _22_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _22_valueOrError6
	_22_valueOrError6 = (m_UTF8.Encode(_8_legend)).MapFailure(func(coer29 func(_dafny.Sequence) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg39 interface{}) interface{} {
			return coer29(arg39.(_dafny.Sequence))
		}
	}(func(_23_e _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_StructuredEncryptionUtil.Companion_Default___.E(_23_e)
	}))
	if (_22_valueOrError6).IsFailure() {
		output = (_22_valueOrError6).PropagateFailure()
		return output
	}
	var _24_utf8Legend _dafny.Sequence
	_ = _24_utf8Legend
	_24_utf8Legend = (_22_valueOrError6).Extract().(_dafny.Sequence)
	_7_newContext = (_7_newContext).Update(m_StructuredEncryptionUtil.Companion_Default___.LEGEND__UTF8(), _24_utf8Legend)
	output = m_Wrappers.Companion_Result_.Create_Success_(_7_newContext)
	return output
	return output
}
func (_static *CompanionStruct_Default___) BuildCryptoMap2(keys _dafny.Sequence, plaintextStructure _dafny.Map, cryptoSchema _dafny.Map, pos uint64, acc _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((keys).Cardinality())) == (pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(acc)
	} else {
		var _0_key _dafny.Sequence = (keys).Select(uint32(pos)).(_dafny.Sequence)
		_ = _0_key
		var _1_path _dafny.Sequence = m_StructuredEncryptionPaths.Companion_Default___.StringToUniPath(_0_key)
		_ = _1_path
		var _2_item m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoItem_.Create_CryptoItem_(_1_path, (plaintextStructure).Get(_0_key).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal), (cryptoSchema).Get(_0_key).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction))
		_ = _2_item
		var _3_newAcc _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(_2_item))
		_ = _3_newAcc
		var _in0 _dafny.Sequence = keys
		_ = _in0
		var _in1 _dafny.Map = plaintextStructure
		_ = _in1
		var _in2 _dafny.Map = cryptoSchema
		_ = _in2
		var _in3 uint64 = (pos) + (uint64(1))
		_ = _in3
		var _in4 _dafny.Sequence = _3_newAcc
		_ = _in4
		keys = _in0
		plaintextStructure = _in1
		cryptoSchema = _in2
		pos = _in3
		acc = _in4
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) BuildCryptoMap(plaintextStructure _dafny.Map, cryptoSchema _dafny.Map) m_Wrappers.Result {
	var _0_keys _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((plaintextStructure).Keys(), func(coer30 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg40 interface{}, arg41 interface{}) bool {
			return coer30(arg40.(_dafny.Char), arg41.(_dafny.Char))
		}
	}(m_StructuredEncryptionUtil.Companion_Default___.CharLess))
	_ = _0_keys
	return Companion_Default___.BuildCryptoMap2(_0_keys, plaintextStructure, cryptoSchema, uint64(0), _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) BuildAuthMap2(keys _dafny.Sequence, plaintextStructure _dafny.Map, authSchema _dafny.Map, pos uint64, acc _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((keys).Cardinality())) == (pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(acc)
	} else {
		var _0_key _dafny.Sequence = (keys).Select(uint32(pos)).(_dafny.Sequence)
		_ = _0_key
		var _1_path _dafny.Sequence = m_StructuredEncryptionPaths.Companion_Default___.StringToUniPath(_0_key)
		_ = _1_path
		var _2_item m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_AuthItem_.Create_AuthItem_(_1_path, (plaintextStructure).Get(_0_key).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal), (authSchema).Get(_0_key).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction))
		_ = _2_item
		var _3_newAcc _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(_2_item))
		_ = _3_newAcc
		var _in0 _dafny.Sequence = keys
		_ = _in0
		var _in1 _dafny.Map = plaintextStructure
		_ = _in1
		var _in2 _dafny.Map = authSchema
		_ = _in2
		var _in3 uint64 = (pos) + (uint64(1))
		_ = _in3
		var _in4 _dafny.Sequence = _3_newAcc
		_ = _in4
		keys = _in0
		plaintextStructure = _in1
		authSchema = _in2
		pos = _in3
		acc = _in4
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) BuildAuthMap(plaintextStructure _dafny.Map, authSchema _dafny.Map) m_Wrappers.Result {
	var _0_keys _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((plaintextStructure).Keys(), func(coer31 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg42 interface{}, arg43 interface{}) bool {
			return coer31(arg42.(_dafny.Char), arg43.(_dafny.Char))
		}
	}(m_StructuredEncryptionUtil.Companion_Default___.CharLess))
	_ = _0_keys
	return Companion_Default___.BuildAuthMap2(_0_keys, plaintextStructure, authSchema, uint64(0), _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) UnBuildCryptoMap(list _dafny.Sequence, pos uint64, dataSoFar _dafny.Map, actionsSoFar _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((list).Cardinality())) == (pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(dataSoFar, actionsSoFar))
	} else {
		var _0_valueOrError0 m_Wrappers.Result = m_StructuredEncryptionPaths.Companion_Default___.UniPathToString(((list).Select(uint32(pos)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_key())
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_key _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_key
			var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!(dataSoFar).Contains(_1_key), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate Key "), _1_key)))
			_ = _2_valueOrError1
			if (_2_valueOrError1).IsFailure() {
				return (_2_valueOrError1).PropagateFailure()
			} else if m_StructuredEncryptionUtil.Companion_Default___.IsAuthAttr(((list).Select(uint32(pos)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_action()) {
				var _in0 _dafny.Sequence = list
				_ = _in0
				var _in1 uint64 = (pos) + (uint64(1))
				_ = _in1
				var _in2 _dafny.Map = (dataSoFar).Update(_1_key, ((list).Select(uint32(pos)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_data())
				_ = _in2
				var _in3 _dafny.Map = (actionsSoFar).Update(_1_key, ((list).Select(uint32(pos)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_action())
				_ = _in3
				list = _in0
				pos = _in1
				dataSoFar = _in2
				actionsSoFar = _in3
				goto TAIL_CALL_START
			} else {
				var _in4 _dafny.Sequence = list
				_ = _in4
				var _in5 uint64 = (pos) + (uint64(1))
				_ = _in5
				var _in6 _dafny.Map = (dataSoFar).Update(_1_key, ((list).Select(uint32(pos)).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_data())
				_ = _in6
				var _in7 _dafny.Map = actionsSoFar
				_ = _in7
				list = _in4
				pos = _in5
				dataSoFar = _in6
				actionsSoFar = _in7
				goto TAIL_CALL_START
			}
		}
	}
}
func (_static *CompanionStruct_Default___) EncryptStructure(config Config, input m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_EncryptStructureOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_plaintextStructure()).Keys()).Equals(((input).Dtor_cryptoSchema()).Keys()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Crypto Keys don't match.")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _1_valueOrError1
	_1_valueOrError1 = Companion_Default___.BuildCryptoMap((input).Dtor_plaintextStructure(), (input).Dtor_cryptoSchema())
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_cryptoMap _dafny.Sequence
	_ = _2_cryptoMap
	_2_cryptoMap = (_1_valueOrError1).Extract().(_dafny.Sequence)
	var _3_pathInput m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureInput
	_ = _3_pathInput
	_3_pathInput = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_EncryptPathStructureInput_.Create_EncryptPathStructureInput_((input).Dtor_tableName(), _2_cryptoMap, (input).Dtor_cmm(), (input).Dtor_algorithmSuiteId(), (input).Dtor_encryptionContext())
	var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_EncryptPathStructureOutput_.Default())
	_ = _4_valueOrError2
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.EncryptPathStructure(config, _3_pathInput)
	_4_valueOrError2 = _out0
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5_pathOutput m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureOutput
	_ = _5_pathOutput
	_5_pathOutput = (_4_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureOutput)
	var _6_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf(_dafny.EmptyMap, _dafny.EmptyMap))
	_ = _6_valueOrError3
	_6_valueOrError3 = Companion_Default___.UnBuildCryptoMap((_5_pathOutput).Dtor_encryptedStructure(), uint64(0), _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap())
	if (_6_valueOrError3).IsFailure() {
		output = (_6_valueOrError3).PropagateFailure()
		return output
	}
	var _7_parts _dafny.Tuple
	_ = _7_parts
	_7_parts = (_6_valueOrError3).Extract().(_dafny.Tuple)
	var _8_plainOutput m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureOutput
	_ = _8_plainOutput
	_8_plainOutput = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_EncryptStructureOutput_.Create_EncryptStructureOutput_((*(_7_parts).IndexInt(0)).(_dafny.Map), (*(_7_parts).IndexInt(1)).(_dafny.Map), (_5_pathOutput).Dtor_parsedHeader())
	output = m_Wrappers.Companion_Result_.Create_Success_(_8_plainOutput)
	return output
	return output
}
func (_static *CompanionStruct_Default___) EncryptPathStructure(config Config, input m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_EncryptPathStructureOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_encryptionContext()).Is_None()) || (!(_dafny.Quantifier((((input).Dtor_encryptionContext()).Dtor_value().(_dafny.Map)).Keys().Elements(), false, func(_exists_var_0 _dafny.Sequence) bool {
		var _1_k _dafny.Sequence
		_1_k = interface{}(_exists_var_0).(_dafny.Sequence)
		return ((((input).Dtor_encryptionContext()).Dtor_value().(_dafny.Map)).Contains(_1_k)) && (_dafny.Companion_Sequence_.IsPrefixOf(m_StructuredEncryptionUtil.Companion_Default___.ReservedCryptoContextPrefixUTF8(), (((input).Dtor_encryptionContext()).Dtor_value().(_dafny.Map)).Get(_1_k).(_dafny.Sequence)))
	}))), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Encryption Context must not contain members beginning with "), m_StructuredEncryptionUtil.Companion_Default___.ReservedCryptoContextPrefixString())))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _2_valueOrError1
	_2_valueOrError1 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((input).Dtor_plaintextStructure()).UniqueElements(), false, func(_exists_var_1 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) bool {
		var _3_k m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem
		_3_k = interface{}(_exists_var_1).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)
		return (_dafny.Companion_Sequence_.Contains((input).Dtor_plaintextStructure(), _3_k)) && (m_StructuredEncryptionUtil.Companion_Default___.IsAuthAttr((_3_k).Dtor_action()))
	}), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("At least one field in the Crypto Schema must be ENCRYPT_AND_SIGN, SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT or SIGN_ONLY.")))
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError2
	_4_valueOrError2 = m_Wrappers.Companion_Default___.Need(!(_dafny.Quantifier(((input).Dtor_plaintextStructure()).UniqueElements(), false, func(_exists_var_2 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) bool {
		var _5_x m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem
		_5_x = interface{}(_exists_var_2).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)
		return (_dafny.Companion_Sequence_.Contains((input).Dtor_plaintextStructure(), _5_x)) && (_dafny.Companion_Sequence_.Contains(m_StructuredEncryptionUtil.Companion_Default___.HeaderPaths(), (_5_x).Dtor_key()))
	})), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("The paths "), m_StructuredEncryptionUtil.Companion_Default___.HeaderField()), _dafny.SeqOfString(" and ")), m_StructuredEncryptionUtil.Companion_Default___.FooterField()), _dafny.SeqOfString(" are reserved."))))
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _6_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _6_valueOrError3
	_6_valueOrError3 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.CryptoListHasNoDuplicatesFromSet((input).Dtor_plaintextStructure()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Duplicate Paths")))
	if (_6_valueOrError3).IsFailure() {
		output = (_6_valueOrError3).PropagateFailure()
		return output
	}
	var _7_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _7_valueOrError4
	_7_valueOrError4 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.ValidString((input).Dtor_tableName()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad Table Name")))
	if (_7_valueOrError4).IsFailure() {
		output = (_7_valueOrError4).PropagateFailure()
		return output
	}
	var _8_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError5
	_8_valueOrError5 = m_Canonize.Companion_Default___.ForEncrypt((input).Dtor_tableName(), (input).Dtor_plaintextStructure())
	if (_8_valueOrError5).IsFailure() {
		output = (_8_valueOrError5).PropagateFailure()
		return output
	}
	var _9_canonData _dafny.Sequence
	_ = _9_canonData
	_9_canonData = (_8_valueOrError5).Extract().(_dafny.Sequence)
	var _10_encryptionContext _dafny.Map
	_ = _10_encryptionContext
	_10_encryptionContext = ((input).Dtor_encryptionContext()).UnwrapOr(_dafny.NewMapBuilder().ToMap()).(_dafny.Map)
	var _11_cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	_ = _11_cmm
	_11_cmm = (input).Dtor_cmm()
	if _dafny.Quantifier(((input).Dtor_plaintextStructure()).UniqueElements(), false, func(_exists_var_3 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) bool {
		var _12_x m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem
		_12_x = interface{}(_exists_var_3).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)
		return (_dafny.Companion_Sequence_.Contains((input).Dtor_plaintextStructure(), _12_x)) && (((_12_x).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()))
	}) {
		var _13_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _13_valueOrError6
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetV2EncryptionContext((input).Dtor_plaintextStructure())
		_13_valueOrError6 = _out0
		if (_13_valueOrError6).IsFailure() {
			output = (_13_valueOrError6).PropagateFailure()
			return output
		}
		var _14_newEncryptionContext _dafny.Map
		_ = _14_newEncryptionContext
		_14_newEncryptionContext = (_13_valueOrError6).Extract().(_dafny.Map)
		if (uint64((_14_newEncryptionContext).CardinalityInt())) != (uint64(0)) /* dircomp */ {
			var _15_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _15_valueOrError7
			_15_valueOrError7 = m_Wrappers.Companion_Default___.Need(((_10_encryptionContext).Keys()).IsDisjointFrom((_14_newEncryptionContext).Keys()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error - Structured Encryption encryption context overlaps with Item Encryptor encryption context.")))
			if (_15_valueOrError7).IsFailure() {
				output = (_15_valueOrError7).PropagateFailure()
				return output
			}
			_10_encryptionContext = (_10_encryptionContext).Merge(_14_newEncryptionContext)
			var _16_contextKeysX _dafny.Sequence
			_ = _16_contextKeysX
			_16_contextKeysX = m_SortedSets.SetToOrderedSequence2((_14_newEncryptionContext).Keys(), func(coer32 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
				return func(arg44 interface{}, arg45 interface{}) bool {
					return coer32(arg44.(uint8), arg45.(uint8))
				}
			}(m_StructuredEncryptionUtil.Companion_Default___.ByteLess))
			var _17_contextKeys _dafny.Sequence
			_ = _17_contextKeys
			_17_contextKeys = _16_contextKeysX
			var _18_cmmR m_Wrappers.Result
			_ = _18_cmmR
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = ((config).Dtor_materialProviders()).CreateRequiredEncryptionContextCMM(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateRequiredEncryptionContextCMMInput_.Create_CreateRequiredEncryptionContextCMMInput_(m_Wrappers.Companion_Option_.Create_Some_((input).Dtor_cmm()), m_Wrappers.Companion_Option_.Create_None_(), _17_contextKeys))
			_18_cmmR = _out1
			var _19_valueOrError8 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _19_valueOrError8
			_19_valueOrError8 = (_18_cmmR).MapFailure(func(coer33 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
				return func(arg46 interface{}) interface{} {
					return coer33(arg46.(m_AwsCryptographyMaterialProvidersTypes.Error))
				}
			}(func(_20_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
				return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_20_e)
			}))
			if (_19_valueOrError8).IsFailure() {
				output = (_19_valueOrError8).PropagateFailure()
				return output
			}
			_11_cmm = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.CastTo_((_19_valueOrError8).Extract())
		}
	}
	var _21_valueOrError9 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _21_valueOrError9
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = Companion_Default___.GetStructuredEncryptionMaterials(_11_cmm, m_Wrappers.Companion_Option_.Create_Some_(_10_encryptionContext), (input).Dtor_algorithmSuiteId(), Companion_Default___.CountEncrypted(_9_canonData), Companion_Default___.SumValueSize(_9_canonData))
	_21_valueOrError9 = _out2
	if (_21_valueOrError9).IsFailure() {
		output = (_21_valueOrError9).PropagateFailure()
		return output
	}
	var _22_mat m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
	_ = _22_mat
	_22_mat = (_21_valueOrError9).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
	var _23_key _dafny.Sequence
	_ = _23_key
	_23_key = ((_22_mat).Dtor_plaintextDataKey()).Dtor_value().(_dafny.Sequence)
	var _24_alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	_ = _24_alg
	_24_alg = (_22_mat).Dtor_algorithmSuite()
	var _25_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _25_valueOrError10
	_25_valueOrError10 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionHeader.Companion_Default___.ValidEncryptionContext((_22_mat).Dtor_encryptionContext()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad encryption context")))
	if (_25_valueOrError10).IsFailure() {
		output = (_25_valueOrError10).PropagateFailure()
		return output
	}
	var _26_randBytes m_Wrappers.Result
	_ = _26_randBytes
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_Random.Companion_Default___.GenerateBytes(int32(m_StructuredEncryptionUtil.Companion_Default___.MSGID__LEN64()))
	_26_randBytes = _out3
	var _27_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _27_valueOrError11
	_27_valueOrError11 = (_26_randBytes).MapFailure(func(coer34 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg47 interface{}) interface{} {
			return coer34(arg47.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_28_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_28_e)
	}))
	if (_27_valueOrError11).IsFailure() {
		output = (_27_valueOrError11).PropagateFailure()
		return output
	}
	var _29_msgID _dafny.Sequence
	_ = _29_msgID
	_29_msgID = (_27_valueOrError11).Extract().(_dafny.Sequence)
	var _30_valueOrError12 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _30_valueOrError12
	_30_valueOrError12 = m_StructuredEncryptionHeader.Companion_Default___.Create((input).Dtor_tableName(), _9_canonData, _29_msgID, _22_mat)
	if (_30_valueOrError12).IsFailure() {
		output = (_30_valueOrError12).PropagateFailure()
		return output
	}
	var _31_head m_StructuredEncryptionHeader.PartialHeader
	_ = _31_head
	_31_head = (_30_valueOrError12).Extract().(m_StructuredEncryptionHeader.PartialHeader)
	var _32_valueOrError13 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _32_valueOrError13
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_StructuredEncryptionCrypt.Companion_Default___.GetCommitKey((config).Dtor_primitives(), _24_alg, _23_key, (_31_head).Dtor_msgID())
	_32_valueOrError13 = _out4
	if (_32_valueOrError13).IsFailure() {
		output = (_32_valueOrError13).PropagateFailure()
		return output
	}
	var _33_commitKey _dafny.Sequence
	_ = _33_commitKey
	_33_commitKey = (_32_valueOrError13).Extract().(_dafny.Sequence)
	var _34_valueOrError14 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _34_valueOrError14
	_34_valueOrError14 = m_StructuredEncryptionHeader.Companion_Default___.Serialize((config).Dtor_primitives(), _24_alg, _33_commitKey, _31_head)
	if (_34_valueOrError14).IsFailure() {
		output = (_34_valueOrError14).PropagateFailure()
		return output
	}
	var _35_headerSerialized _dafny.Sequence
	_ = _35_headerSerialized
	_35_headerSerialized = (_34_valueOrError14).Extract().(_dafny.Sequence)
	var _36_headerAttribute m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _36_headerAttribute
	_36_headerAttribute = m_StructuredEncryptionUtil.Companion_Default___.ValueToData(_35_headerSerialized, m_StructuredEncryptionUtil.Companion_Default___.BYTES__TYPE__ID())
	var _37_valueOrError15 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _37_valueOrError15
	_37_valueOrError15 = m_Wrappers.Companion_Default___.Need((uint64((_9_canonData).Cardinality())) < (uint64(m_StructuredEncryptionCrypt.Companion_Default___.ONE__THIRD__MAX__INT())), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Too many encrypted fields")))
	if (_37_valueOrError15).IsFailure() {
		output = (_37_valueOrError15).PropagateFailure()
		return output
	}
	var _38_valueOrError16 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _38_valueOrError16
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_StructuredEncryptionCrypt.Companion_Default___.Encrypt((config).Dtor_primitives(), _24_alg, _23_key, _31_head, _9_canonData)
	_38_valueOrError16 = _out5
	if (_38_valueOrError16).IsFailure() {
		output = (_38_valueOrError16).PropagateFailure()
		return output
	}
	var _39_encryptedItems _dafny.Sequence
	_ = _39_encryptedItems
	_39_encryptedItems = (_38_valueOrError16).Extract().(_dafny.Sequence)
	var _40_smallResult _dafny.Sequence
	_ = _40_smallResult
	_40_smallResult = m_Canonize.Companion_Default___.UnCanonEncrypt(_39_encryptedItems)
	var _41_valueOrError17 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_StructuredEncryptionFooter.Companion_Footer_.Default())
	_ = _41_valueOrError17
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_StructuredEncryptionFooter.Companion_Default___.CreateFooter((config).Dtor_primitives(), _22_mat, _39_encryptedItems, _35_headerSerialized)
	_41_valueOrError17 = _out6
	if (_41_valueOrError17).IsFailure() {
		output = (_41_valueOrError17).PropagateFailure()
		return output
	}
	var _42_footer m_StructuredEncryptionFooter.Footer
	_ = _42_footer
	_42_footer = (_41_valueOrError17).Extract().(m_StructuredEncryptionFooter.Footer)
	var _43_footerAttribute m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _43_footerAttribute
	_43_footerAttribute = (_42_footer).MakeTerminal()
	var _44_largeResult _dafny.Sequence
	_ = _44_largeResult
	_44_largeResult = m_Canonize.Companion_Default___.AddHeaders(_40_smallResult, _36_headerAttribute, _43_footerAttribute)
	var _45_valueOrError18 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _45_valueOrError18
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = (_31_head).GetAlgorithmSuite((config).Dtor_materialProviders())
	_45_valueOrError18 = _out7
	if (_45_valueOrError18).IsFailure() {
		output = (_45_valueOrError18).PropagateFailure()
		return output
	}
	var _46_headerAlgorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	_ = _46_headerAlgorithmSuite
	_46_headerAlgorithmSuite = (_45_valueOrError18).Extract().(m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo)
	var _47_parsedHeader m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ParsedHeader
	_ = _47_parsedHeader
	_47_parsedHeader = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_ParsedHeader_.Create_ParsedHeader_(((_46_headerAlgorithmSuite).Dtor_id()).Dtor_DBE(), (_31_head).Dtor_dataKeys(), (_31_head).Dtor_encContext(), (_22_mat).Dtor_encryptionContext())
	var _48_encryptOutput m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureOutput
	_ = _48_encryptOutput
	_48_encryptOutput = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_EncryptPathStructureOutput_.Create_EncryptPathStructureOutput_(_44_largeResult, _47_parsedHeader)
	output = m_Wrappers.Companion_Result_.Create_Success_(_48_encryptOutput)
	return output
	return output
}
func (_static *CompanionStruct_Default___) SafeDecode(data _dafny.Sequence) _dafny.Sequence {
	var _0_x m_Wrappers.Result = m_UTF8.Decode(data)
	_ = _0_x
	if (_0_x).Is_Success() {
		return (_0_x).Dtor_value().(_dafny.Sequence)
	} else {
		return _dafny.SeqOfString("[corrupt value]")
	}
}
func (_static *CompanionStruct_Default___) DescribeMismatch(inputFields _dafny.Sequence, inputContext _dafny.Map, headContext _dafny.Map) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((inputFields).Cardinality())) == (uint64(0)) {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfString(""))
	} else {
		var _1_key _dafny.Sequence = (inputFields).Select(uint32(uint32(0))).(_dafny.Sequence)
		_ = _1_key
		if ((headContext).Contains(_1_key)) && (!_dafny.Companion_Sequence_.Equal((headContext).Get(_1_key).(_dafny.Sequence), (inputContext).Get(_1_key).(_dafny.Sequence))) {
			var _2_keyStr _dafny.Sequence = Companion_Default___.SafeDecode(_1_key)
			_ = _2_keyStr
			var _3_headStr _dafny.Sequence = Companion_Default___.SafeDecode((headContext).Get(_1_key).(_dafny.Sequence))
			_ = _3_headStr
			var _4_inputStr _dafny.Sequence = Companion_Default___.SafeDecode((inputContext).Get(_1_key).(_dafny.Sequence))
			_ = _4_inputStr
			var _5_msg _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("input context for "), _2_keyStr), _dafny.SeqOfString(" was ")), _4_inputStr), _dafny.SeqOfString(" but stored context had ")), _3_headStr), _dafny.SeqOfString("\n"))
			_ = _5_msg
			_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _5_msg)
			var _in0 _dafny.Sequence = (inputFields).Drop(uint32(uint32(1)))
			_ = _in0
			var _in1 _dafny.Map = inputContext
			_ = _in1
			var _in2 _dafny.Map = headContext
			_ = _in2
			inputFields = _in0
			inputContext = _in1
			headContext = _in2
			goto TAIL_CALL_START
		} else {
			var _in3 _dafny.Sequence = (inputFields).Drop(uint32(uint32(1)))
			_ = _in3
			var _in4 _dafny.Map = inputContext
			_ = _in4
			var _in5 _dafny.Map = headContext
			_ = _in5
			inputFields = _in3
			inputContext = _in4
			headContext = _in5
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) DetectMismatch(inputContext _dafny.Map, headContext _dafny.Map) m_Wrappers.Outcome {
	var _0_inputFields _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((inputContext).Keys(), func(coer35 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
		return func(arg48 interface{}, arg49 interface{}) bool {
			return coer35(arg48.(uint8), arg49.(uint8))
		}
	}(m_StructuredEncryptionUtil.Companion_Default___.ByteLess))
	_ = _0_inputFields
	var _1_str _dafny.Sequence = Companion_Default___.DescribeMismatch(_0_inputFields, inputContext, headContext)
	_ = _1_str
	if (uint64((_1_str).Cardinality())) == (uint64(0)) {
		return m_Wrappers.Companion_Outcome_.Create_Pass_()
	} else {
		return m_Wrappers.Companion_Outcome_.Create_Fail_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Encryption Context Mismatch\n"), _1_str)))
	}
}
func (_static *CompanionStruct_Default___) NewCmm(config Config, cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager, context _dafny.Map) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Result{}
	_ = ret
	var _0_contextKeysX _dafny.Sequence
	_ = _0_contextKeysX
	_0_contextKeysX = m_SortedSets.SetToOrderedSequence2((context).Keys(), func(coer36 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
		return func(arg50 interface{}, arg51 interface{}) bool {
			return coer36(arg50.(uint8), arg51.(uint8))
		}
	}(m_StructuredEncryptionUtil.Companion_Default___.ByteLess))
	var _1_contextKeys _dafny.Sequence
	_ = _1_contextKeys
	_1_contextKeys = _0_contextKeysX
	var _2_cmmR m_Wrappers.Result
	_ = _2_cmmR
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = ((config).Dtor_materialProviders()).CreateRequiredEncryptionContextCMM(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateRequiredEncryptionContextCMMInput_.Create_CreateRequiredEncryptionContextCMMInput_(m_Wrappers.Companion_Option_.Create_Some_(cmm), m_Wrappers.Companion_Option_.Create_None_(), _1_contextKeys))
	_2_cmmR = _out0
	var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError0
	_3_valueOrError0 = (_2_cmmR).MapFailure(func(coer37 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg52 interface{}) interface{} {
			return coer37(arg52.(m_AwsCryptographyMaterialProvidersTypes.Error))
		}
	}(func(_4_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_4_e)
	}))
	if (_3_valueOrError0).IsFailure() {
		ret = (_3_valueOrError0).PropagateFailure()
		return ret
	}
	var _5_newCmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	_ = _5_newCmm
	_5_newCmm = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.CastTo_((_3_valueOrError0).Extract())
	ret = m_Wrappers.Companion_Result_.Create_Success_(_5_newCmm)
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) DecryptStructure(config Config, input m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_DecryptStructureOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_encryptedStructure()).Keys()).Equals(((input).Dtor_authenticateSchema()).Keys()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("DecryptStructure requires encryptedStructure and authenticateSchema have the same keys.")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _1_valueOrError1
	_1_valueOrError1 = Companion_Default___.BuildAuthMap((input).Dtor_encryptedStructure(), (input).Dtor_authenticateSchema())
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_cryptoMap _dafny.Sequence
	_ = _2_cryptoMap
	_2_cryptoMap = (_1_valueOrError1).Extract().(_dafny.Sequence)
	var _3_pathInput m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureInput
	_ = _3_pathInput
	_3_pathInput = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_DecryptPathStructureInput_.Create_DecryptPathStructureInput_((input).Dtor_tableName(), _2_cryptoMap, (input).Dtor_cmm(), (input).Dtor_encryptionContext())
	var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_DecryptPathStructureOutput_.Default())
	_ = _4_valueOrError2
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.DecryptPathStructure(config, _3_pathInput)
	_4_valueOrError2 = _out0
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5_pathOutput m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureOutput
	_ = _5_pathOutput
	_5_pathOutput = (_4_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureOutput)
	var _6_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf(_dafny.EmptyMap, _dafny.EmptyMap))
	_ = _6_valueOrError3
	_6_valueOrError3 = Companion_Default___.UnBuildCryptoMap((_5_pathOutput).Dtor_plaintextStructure(), uint64(0), _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap())
	if (_6_valueOrError3).IsFailure() {
		output = (_6_valueOrError3).PropagateFailure()
		return output
	}
	var _7_parts _dafny.Tuple
	_ = _7_parts
	_7_parts = (_6_valueOrError3).Extract().(_dafny.Tuple)
	var _8_plainOutput m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureOutput
	_ = _8_plainOutput
	_8_plainOutput = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_DecryptStructureOutput_.Create_DecryptStructureOutput_((*(_7_parts).IndexInt(0)).(_dafny.Map), (*(_7_parts).IndexInt(1)).(_dafny.Map), (_5_pathOutput).Dtor_parsedHeader())
	output = m_Wrappers.Companion_Result_.Create_Success_(_8_plainOutput)
	return output
	return output
}
func (_static *CompanionStruct_Default___) DecryptPathStructure(config Config, input m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_DecryptPathStructureOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((input).Dtor_encryptedStructure()).UniqueElements(), false, func(_exists_var_0 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem) bool {
		var _1_x m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem
		_1_x = interface{}(_exists_var_0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)
		return (_dafny.Companion_Sequence_.Contains((input).Dtor_encryptedStructure(), _1_x)) && (((_1_x).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_AuthenticateAction_.Create_SIGN_()))
	}), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("At least one Authenticate Action must be SIGN")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _2_valueOrError1
	_2_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.AuthListHasNoDuplicatesFromSet((input).Dtor_encryptedStructure()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Duplicate Paths")))
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _3_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _3_valueOrError2
	_3_valueOrError2 = Companion_Default___.GetBinary((input).Dtor_encryptedStructure(), m_StructuredEncryptionUtil.Companion_Default___.HeaderPath())
	if (_3_valueOrError2).IsFailure() {
		output = (_3_valueOrError2).PropagateFailure()
		return output
	}
	var _4_headerSerialized m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _4_headerSerialized
	_4_headerSerialized = (_3_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)
	var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _5_valueOrError3
	_5_valueOrError3 = Companion_Default___.GetBinary((input).Dtor_encryptedStructure(), m_StructuredEncryptionUtil.Companion_Default___.FooterPath())
	if (_5_valueOrError3).IsFailure() {
		output = (_5_valueOrError3).PropagateFailure()
		return output
	}
	var _6_footerSerialized m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	_ = _6_footerSerialized
	_6_footerSerialized = (_5_valueOrError3).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)
	var _7_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _7_valueOrError4
	_7_valueOrError4 = m_StructuredEncryptionHeader.Companion_Default___.PartialDeserialize((_4_headerSerialized).Dtor_value())
	if (_7_valueOrError4).IsFailure() {
		output = (_7_valueOrError4).PropagateFailure()
		return output
	}
	var _8_head m_StructuredEncryptionHeader.PartialHeader
	_ = _8_head
	_8_head = (_7_valueOrError4).Extract().(m_StructuredEncryptionHeader.PartialHeader)
	var _9_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _9_valueOrError5
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (_8_head).GetAlgorithmSuite((config).Dtor_materialProviders())
	_9_valueOrError5 = _out0
	if (_9_valueOrError5).IsFailure() {
		output = (_9_valueOrError5).PropagateFailure()
		return output
	}
	var _10_headerAlgorithmSuite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	_ = _10_headerAlgorithmSuite
	_10_headerAlgorithmSuite = (_9_valueOrError5).Extract().(m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo)
	var _11_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _11_valueOrError6
	_11_valueOrError6 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.ValidString((input).Dtor_tableName()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad Table Name")))
	if (_11_valueOrError6).IsFailure() {
		output = (_11_valueOrError6).PropagateFailure()
		return output
	}
	var _12_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _12_valueOrError7
	_12_valueOrError7 = m_Canonize.Companion_Default___.ForDecrypt((input).Dtor_tableName(), (input).Dtor_encryptedStructure(), (_8_head).Dtor_legend())
	if (_12_valueOrError7).IsFailure() {
		output = (_12_valueOrError7).PropagateFailure()
		return output
	}
	var _13_canonData _dafny.Sequence
	_ = _13_canonData
	_13_canonData = (_12_valueOrError7).Extract().(_dafny.Sequence)
	var _14_encryptionContext _dafny.Map
	_ = _14_encryptionContext
	_14_encryptionContext = ((input).Dtor_encryptionContext()).UnwrapOr(_dafny.NewMapBuilder().ToMap()).(_dafny.Map)
	var _15_cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	_ = _15_cmm
	_15_cmm = (input).Dtor_cmm()
	if ((_8_head).Dtor_version()) == (uint8(2)) {
		var _16_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _16_valueOrError8
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.GetV2EncryptionContext(m_Canonize.Companion_Default___.UnCanon(_13_canonData, uint64(0), _dafny.SeqOf()))
		_16_valueOrError8 = _out1
		if (_16_valueOrError8).IsFailure() {
			output = (_16_valueOrError8).PropagateFailure()
			return output
		}
		var _17_newEncryptionContext _dafny.Map
		_ = _17_newEncryptionContext
		_17_newEncryptionContext = (_16_valueOrError8).Extract().(_dafny.Map)
		if (uint64((_17_newEncryptionContext).CardinalityInt())) != (uint64(0)) /* dircomp */ {
			var _18_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _18_valueOrError9
			_18_valueOrError9 = m_Wrappers.Companion_Default___.Need(((_14_encryptionContext).Keys()).IsDisjointFrom((_17_newEncryptionContext).Keys()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error - Structured Encryption encryption context overlaps with Item Encryptor encryption context.")))
			if (_18_valueOrError9).IsFailure() {
				output = (_18_valueOrError9).PropagateFailure()
				return output
			}
			_14_encryptionContext = (_14_encryptionContext).Merge(_17_newEncryptionContext)
			var _19_contextKeysX _dafny.Sequence
			_ = _19_contextKeysX
			_19_contextKeysX = m_SortedSets.SetToOrderedSequence2((_17_newEncryptionContext).Keys(), func(coer38 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
				return func(arg53 interface{}, arg54 interface{}) bool {
					return coer38(arg53.(uint8), arg54.(uint8))
				}
			}(m_StructuredEncryptionUtil.Companion_Default___.ByteLess))
			var _20_contextKeys _dafny.Sequence
			_ = _20_contextKeys
			_20_contextKeys = _19_contextKeysX
			var _21_cmmR m_Wrappers.Result
			_ = _21_cmmR
			var _out2 m_Wrappers.Result
			_ = _out2
			_out2 = ((config).Dtor_materialProviders()).CreateRequiredEncryptionContextCMM(m_AwsCryptographyMaterialProvidersTypes.Companion_CreateRequiredEncryptionContextCMMInput_.Create_CreateRequiredEncryptionContextCMMInput_(m_Wrappers.Companion_Option_.Create_Some_((input).Dtor_cmm()), m_Wrappers.Companion_Option_.Create_None_(), _20_contextKeys))
			_21_cmmR = _out2
			var _22_valueOrError10 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _22_valueOrError10
			_22_valueOrError10 = (_21_cmmR).MapFailure(func(coer39 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
				return func(arg55 interface{}) interface{} {
					return coer39(arg55.(m_AwsCryptographyMaterialProvidersTypes.Error))
				}
			}(func(_23_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
				return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_23_e)
			}))
			if (_22_valueOrError10).IsFailure() {
				output = (_22_valueOrError10).PropagateFailure()
				return output
			}
			_15_cmm = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.CastTo_((_22_valueOrError10).Extract())
		}
	}
	var _24_matR m_Wrappers.Result
	_ = _24_matR
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_15_cmm).DecryptMaterials(m_AwsCryptographyMaterialProvidersTypes.Companion_DecryptMaterialsInput_.Create_DecryptMaterialsInput_((_10_headerAlgorithmSuite).Dtor_id(), Companion_Default___.DBE__COMMITMENT__POLICY(), (_8_head).Dtor_dataKeys(), (_8_head).Dtor_encContext(), m_Wrappers.Companion_Option_.Create_Some_(_14_encryptionContext)))
	_24_matR = _out3
	var _25_valueOrError11 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _25_valueOrError11
	_25_valueOrError11 = (_24_matR).MapFailure(func(coer40 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg56 interface{}) interface{} {
			return coer40(arg56.(m_AwsCryptographyMaterialProvidersTypes.Error))
		}
	}(func(_26_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_26_e)
	}))
	if (_25_valueOrError11).IsFailure() {
		output = (_25_valueOrError11).PropagateFailure()
		return output
	}
	var _27_matOutput m_AwsCryptographyMaterialProvidersTypes.DecryptMaterialsOutput
	_ = _27_matOutput
	_27_matOutput = (_25_valueOrError11).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptMaterialsOutput)
	var _28_mat m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_ = _28_mat
	_28_mat = (_27_matOutput).Dtor_decryptionMaterials()
	var _29_valueOrError12 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _29_valueOrError12
	_29_valueOrError12 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionHeader.Companion_Default___.ValidEncryptionContext((_28_mat).Dtor_encryptionContext()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad encryption context")))
	if (_29_valueOrError12).IsFailure() {
		output = (_29_valueOrError12).PropagateFailure()
		return output
	}
	var _30_valueOrError13 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _30_valueOrError13
	_30_valueOrError13 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithPlaintextDataKey(_28_mat), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Encryption material has no key")))
	if (_30_valueOrError13).IsFailure() {
		output = (_30_valueOrError13).PropagateFailure()
		return output
	}
	var _31_valueOrError14 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _31_valueOrError14
	_31_valueOrError14 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.ValidSuite((_28_mat).Dtor_algorithmSuite()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Algorithm Suite")))
	if (_31_valueOrError14).IsFailure() {
		output = (_31_valueOrError14).PropagateFailure()
		return output
	}
	var _32_postCMMAlg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
	_ = _32_postCMMAlg
	_32_postCMMAlg = (_28_mat).Dtor_algorithmSuite()
	var _33_key _dafny.Sequence
	_ = _33_key
	_33_key = ((_28_mat).Dtor_plaintextDataKey()).Dtor_value().(_dafny.Sequence)
	var _34_valueOrError15 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _34_valueOrError15
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_StructuredEncryptionCrypt.Companion_Default___.GetCommitKey((config).Dtor_primitives(), _32_postCMMAlg, _33_key, (_8_head).Dtor_msgID())
	_34_valueOrError15 = _out4
	if (_34_valueOrError15).IsFailure() {
		output = (_34_valueOrError15).PropagateFailure()
		return output
	}
	var _35_commitKey _dafny.Sequence
	_ = _35_commitKey
	_35_commitKey = (_34_valueOrError15).Extract().(_dafny.Sequence)
	var _36_valueOrError16 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = _36_valueOrError16
	_36_valueOrError16 = (_8_head).VerifyCommitment((config).Dtor_primitives(), _32_postCMMAlg, _35_commitKey, (_4_headerSerialized).Dtor_value())
	if (_36_valueOrError16).IsFailure() {
		output = (_36_valueOrError16).PropagateFailure()
		return output
	}
	var _37_ok bool
	_ = _37_ok
	_37_ok = (_36_valueOrError16).Extract().(bool)
	var _38_valueOrError17 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_StructuredEncryptionFooter.Companion_Footer_.Default())
	_ = _38_valueOrError17
	_38_valueOrError17 = m_StructuredEncryptionFooter.Companion_Default___.DeserializeFooter((_6_footerSerialized).Dtor_value(), ((_32_postCMMAlg).Dtor_signature()).Is_ECDSA())
	if (_38_valueOrError17).IsFailure() {
		output = (_38_valueOrError17).PropagateFailure()
		return output
	}
	var _39_footer m_StructuredEncryptionFooter.Footer
	_ = _39_footer
	_39_footer = (_38_valueOrError17).Extract().(m_StructuredEncryptionFooter.Footer)
	var _40_valueOrError18 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = _40_valueOrError18
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = (_39_footer).Validate((config).Dtor_primitives(), _28_mat, (_8_head).Dtor_dataKeys(), _13_canonData, (_4_headerSerialized).Dtor_value())
	_40_valueOrError18 = _out5
	if (_40_valueOrError18).IsFailure() {
		output = (_40_valueOrError18).PropagateFailure()
		return output
	}
	var _41___v0 bool
	_ = _41___v0
	_41___v0 = (_40_valueOrError18).Extract().(bool)
	var _42_valueOrError19 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _42_valueOrError19
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m_StructuredEncryptionCrypt.Companion_Default___.Decrypt((config).Dtor_primitives(), _32_postCMMAlg, _33_key, _8_head, _13_canonData)
	_42_valueOrError19 = _out6
	if (_42_valueOrError19).IsFailure() {
		output = (_42_valueOrError19).PropagateFailure()
		return output
	}
	var _43_decryptedItems _dafny.Sequence
	_ = _43_decryptedItems
	_43_decryptedItems = (_42_valueOrError19).Extract().(_dafny.Sequence)
	var _44_largeResult _dafny.Sequence
	_ = _44_largeResult
	_44_largeResult = m_Canonize.Companion_Default___.UnCanonDecrypt(_43_decryptedItems)
	var _45_smallResult _dafny.Sequence
	_ = _45_smallResult
	_45_smallResult = m_Canonize.Companion_Default___.RemoveHeaders(_44_largeResult)
	var _46_parsedHeader m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ParsedHeader
	_ = _46_parsedHeader
	_46_parsedHeader = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_ParsedHeader_.Create_ParsedHeader_(((_10_headerAlgorithmSuite).Dtor_id()).Dtor_DBE(), (_8_head).Dtor_dataKeys(), (_8_head).Dtor_encContext(), (_28_mat).Dtor_encryptionContext())
	var _47_decryptOutput m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureOutput
	_ = _47_decryptOutput
	_47_decryptOutput = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_DecryptPathStructureOutput_.Create_DecryptPathStructureOutput_(_45_smallResult, _46_parsedHeader)
	output = m_Wrappers.Companion_Result_.Create_Success_(_47_decryptOutput)
	return output
}
func (_static *CompanionStruct_Default___) DBE__COMMITMENT__POLICY() m_AwsCryptographyMaterialProvidersTypes.CommitmentPolicy {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_CommitmentPolicy_.Create_DBE_(m_AwsCryptographyMaterialProvidersTypes.Companion_DBECommitmentPolicy_.Create_REQUIRE__ENCRYPT__REQUIRE__DECRYPT_())
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
	Primitives        *m_AtomicPrimitives.AtomicPrimitivesClient
	MaterialProviders *m_MaterialProviders.MaterialProvidersClient
}

func (Config_Config) isConfig() {}

func (CompanionStruct_Config_) Create_Config_(Primitives *m_AtomicPrimitives.AtomicPrimitivesClient, MaterialProviders *m_MaterialProviders.MaterialProvidersClient) Config {
	return Config{Config_Config{Primitives, MaterialProviders}}
}

func (_this Config) Is_Config() bool {
	_, ok := _this.Get_().(Config_Config)
	return ok
}

func (CompanionStruct_Config_) Default() Config {
	return Companion_Config_.Create_Config_((*m_AtomicPrimitives.AtomicPrimitivesClient)(nil), (*m_MaterialProviders.MaterialProvidersClient)(nil))
}

func (_this Config) Dtor_primitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	return _this.Get_().(Config_Config).Primitives
}

func (_this Config) Dtor_materialProviders() *m_MaterialProviders.MaterialProvidersClient {
	return _this.Get_().(Config_Config).MaterialProviders
}

func (_this Config) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Config_Config:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Config.Config" + "(" + _dafny.String(data.Primitives) + ", " + _dafny.String(data.MaterialProviders) + ")"
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
			return ok && data1.Primitives == data2.Primitives && data1.MaterialProviders == data2.MaterialProviders
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
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Config"
}
func (_this Config) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Config{}

// End of datatype Config
