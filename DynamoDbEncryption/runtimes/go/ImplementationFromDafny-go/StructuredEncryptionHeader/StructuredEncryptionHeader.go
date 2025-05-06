// Package StructuredEncryptionHeader
// Dafny module StructuredEncryptionHeader compiled into Go

package StructuredEncryptionHeader

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
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
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
	return "StructuredEncryptionHeader.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ValidVersion(x uint8) bool {
	return ((x) == (uint8(1))) || ((x) == (uint8(2)))
}
func (_static *CompanionStruct_Default___) IsVersion2Schema(data _dafny.Sequence, pos uint32) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (pos) == (uint32((data).Cardinality())) {
		return false
	} else if (((data).Select(uint32(pos)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()) {
		return true
	} else {
		var _in0 _dafny.Sequence = data
		_ = _in0
		var _in1 uint32 = (pos) + (uint32(1))
		_ = _in1
		data = _in0
		pos = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) VersionFromSchema(data _dafny.Sequence) uint8 {
	if Companion_Default___.IsVersion2Schema(data, uint32(0)) {
		return uint8(2)
	} else {
		return uint8(1)
	}
}
func (_static *CompanionStruct_Default___) ValidFlavor(x uint8) bool {
	return _dafny.Companion_Sequence_.Contains(_dafny.SeqOf(uint8(0), uint8(1)), x)
}
func (_static *CompanionStruct_Default___) ValidLegendByte(x uint8) bool {
	return _dafny.Companion_Sequence_.Contains(_dafny.SeqOf(Companion_Default___.ENCRYPT__AND__SIGN__LEGEND(), Companion_Default___.SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT__LEGEND(), Companion_Default___.SIGN__ONLY__LEGEND()), x)
}
func (_static *CompanionStruct_Default___) ValidEncryptionContext(x _dafny.Map) bool {
	return (((x).Cardinality()).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0) && (_dafny.Quantifier((x).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _0_k _dafny.Sequence
		_0_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !((x).Contains(_0_k)) || (((_dafny.IntOfUint32((_0_k).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0) && ((_dafny.IntOfUint32(((x).Get(_0_k).(_dafny.Sequence)).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0))
	}))
}
func (_static *CompanionStruct_Default___) ValidEncryptedDataKey(x m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey) bool {
	return (((_dafny.IntOfUint32(((x).Dtor_keyProviderId()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0) && ((_dafny.IntOfUint32(((x).Dtor_keyProviderInfo()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0)) && ((_dafny.IntOfUint32(((x).Dtor_ciphertext()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0)
}
func (_static *CompanionStruct_Default___) Serialize(client m_AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, commitKey _dafny.Sequence, PartialHeader PartialHeader) m_Wrappers.Result {
	var _0_body _dafny.Sequence = (PartialHeader).Serialize()
	_ = _0_body
	var _1_valueOrError0 m_Wrappers.Result = Companion_Default___.CalculateHeaderCommitment(client, alg, commitKey, _0_body)
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_commitment _dafny.Sequence = (_1_valueOrError0).Extract().(_dafny.Sequence)
		_ = _2_commitment
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_0_body, _2_commitment))
	}
}
func (_static *CompanionStruct_Default___) Create(tableName _dafny.Sequence, schema _dafny.Sequence, msgID _dafny.Sequence, mat m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((schema).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT32__LIMIT()) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected large schema")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidEncryptionContext((mat).Dtor_encryptionContext()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Encryption Context")))
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((mat).Dtor_encryptedDataKeys()).Cardinality())).Sign() == 1, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("There must be at least one data key")))
			_ = _2_valueOrError2
			if (_2_valueOrError2).IsFailure() {
				return (_2_valueOrError2).PropagateFailure()
			} else {
				var _3_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((mat).Dtor_encryptedDataKeys()).Cardinality())).Cmp(Companion_Default___.UINT8__LIMIT()) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Too many data keys.")))
				_ = _3_valueOrError3
				if (_3_valueOrError3).IsFailure() {
					return (_3_valueOrError3).PropagateFailure()
				} else {
					var _4_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((mat).Dtor_encryptedDataKeys()).UniqueElements(), true, func(_forall_var_0 m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey) bool {
						var _5_x m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
						_5_x = interface{}(_forall_var_0).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
						return !(_dafny.Companion_Sequence_.Contains((mat).Dtor_encryptedDataKeys(), _5_x)) || (Companion_Default___.ValidEncryptedDataKey(_5_x))
					}), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Data Key")))
					_ = _4_valueOrError4
					if (_4_valueOrError4).IsFailure() {
						return (_4_valueOrError4).PropagateFailure()
					} else {
						var _6_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((((mat).Dtor_algorithmSuite()).Dtor_binaryId()).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Algorithm Suite Binary ID")))
						_ = _6_valueOrError5
						if (_6_valueOrError5).IsFailure() {
							return (_6_valueOrError5).PropagateFailure()
						} else {
							var _7_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((((mat).Dtor_algorithmSuite()).Dtor_binaryId()).Select(0).(uint8)) == (m_StructuredEncryptionUtil.Companion_Default___.DbeAlgorithmFamily()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Algorithm Suite not suitable for structured encryption.")))
							_ = _7_valueOrError6
							if (_7_valueOrError6).IsFailure() {
								return (_7_valueOrError6).PropagateFailure()
							} else {
								var _8_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidFlavor((((mat).Dtor_algorithmSuite()).Dtor_binaryId()).Select(1).(uint8)), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Algorithm Suite has unexpected flavor.")))
								_ = _8_valueOrError7
								if (_8_valueOrError7).IsFailure() {
									return (_8_valueOrError7).PropagateFailure()
								} else {
									var _9_valueOrError8 m_Wrappers.Result = Companion_Default___.MakeLegend(schema)
									_ = _9_valueOrError8
									if (_9_valueOrError8).IsFailure() {
										return (_9_valueOrError8).PropagateFailure()
									} else {
										var _10_legend _dafny.Sequence = (_9_valueOrError8).Extract().(_dafny.Sequence)
										_ = _10_legend
										var _11_storedEC _dafny.Map = func() _dafny.Map {
											var _coll0 = _dafny.NewMapBuilder()
											_ = _coll0
											for _iter6 := _dafny.Iterate(((mat).Dtor_encryptionContext()).Keys().Elements()); ; {
												_compr_0, _ok6 := _iter6()
												if !_ok6 {
													break
												}
												var _12_k _dafny.Sequence
												_12_k = interface{}(_compr_0).(_dafny.Sequence)
												if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_12_k) {
													if (((mat).Dtor_encryptionContext()).Contains(_12_k)) && (!_dafny.Companion_Sequence_.Contains((mat).Dtor_requiredEncryptionContextKeys(), _12_k)) {
														_coll0.Add(_12_k, ((mat).Dtor_encryptionContext()).Get(_12_k).(_dafny.Sequence))
													}
												}
											}
											return _coll0.ToMap()
										}()
										_ = _11_storedEC
										var _13_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidEncryptionContext(_11_storedEC), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Encryption Context")))
										_ = _13_valueOrError9
										if (_13_valueOrError9).IsFailure() {
											return (_13_valueOrError9).PropagateFailure()
										} else {
											return m_Wrappers.Companion_Result_.Create_Success_(Companion_PartialHeader_.Create_PartialHeader_(Companion_Default___.VersionFromSchema(schema), (((mat).Dtor_algorithmSuite()).Dtor_binaryId()).Select(1).(uint8), msgID, _10_legend, _11_storedEC, (mat).Dtor_encryptedDataKeys()))
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
}
func (_static *CompanionStruct_Default___) PartialDeserialize(data _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((Companion_Default___.PREFIX__LEN()).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Serialized PartialHeader too short.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_version uint8 = (data).Select(0).(uint8)
		_ = _1_version
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidVersion(_1_version), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Version Number")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_flavor uint8 = (data).Select(1).(uint8)
			_ = _3_flavor
			var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidFlavor(_3_flavor), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Flavor")))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_msgID _dafny.Sequence = (data).Subsequence(2, (Companion_Default___.PREFIX__LEN()).Uint32())
				_ = _5_msgID
				var _6_legendData _dafny.Sequence = (data).Drop((Companion_Default___.PREFIX__LEN()).Uint32())
				_ = _6_legendData
				var _7_valueOrError3 m_Wrappers.Result = Companion_Default___.GetLegend(_6_legendData)
				_ = _7_valueOrError3
				if (_7_valueOrError3).IsFailure() {
					return (_7_valueOrError3).PropagateFailure()
				} else {
					var _8_legendAndLen _dafny.Tuple = (_7_valueOrError3).Extract().(_dafny.Tuple)
					_ = _8_legendAndLen
					var _9_legend _dafny.Sequence = (*(_8_legendAndLen).IndexInt(0)).(_dafny.Sequence)
					_ = _9_legend
					var _10_contextData _dafny.Sequence = (_6_legendData).Drop(((*(_8_legendAndLen).IndexInt(1)).(_dafny.Int)).Uint32())
					_ = _10_contextData
					var _11_valueOrError4 m_Wrappers.Result = Companion_Default___.GetContext(_10_contextData)
					_ = _11_valueOrError4
					if (_11_valueOrError4).IsFailure() {
						return (_11_valueOrError4).PropagateFailure()
					} else {
						var _12_contextAndLen _dafny.Tuple = (_11_valueOrError4).Extract().(_dafny.Tuple)
						_ = _12_contextAndLen
						var _13_encContext _dafny.Map = (*(_12_contextAndLen).IndexInt(0)).(_dafny.Map)
						_ = _13_encContext
						var _14_keysData _dafny.Sequence = (_10_contextData).Drop(((*(_12_contextAndLen).IndexInt(1)).(_dafny.Int)).Uint32())
						_ = _14_keysData
						var _15_valueOrError5 m_Wrappers.Result = Companion_Default___.GetDataKeys(_14_keysData)
						_ = _15_valueOrError5
						if (_15_valueOrError5).IsFailure() {
							return (_15_valueOrError5).PropagateFailure()
						} else {
							var _16_keysAndLen _dafny.Tuple = (_15_valueOrError5).Extract().(_dafny.Tuple)
							_ = _16_keysAndLen
							var _17_dataKeys _dafny.Sequence = (*(_16_keysAndLen).IndexInt(0)).(_dafny.Sequence)
							_ = _17_dataKeys
							var _18_trailingData _dafny.Sequence = (_14_keysData).Drop(((*(_16_keysAndLen).IndexInt(1)).(_dafny.Int)).Uint32())
							_ = _18_trailingData
							var _19_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_18_trailingData).Cardinality())).Cmp(Companion_Default___.COMMITMENT__LEN()) >= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid header serialization: unexpected end of data.")))
							_ = _19_valueOrError6
							if (_19_valueOrError6).IsFailure() {
								return (_19_valueOrError6).PropagateFailure()
							} else {
								var _20_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_18_trailingData).Cardinality())).Cmp(Companion_Default___.COMMITMENT__LEN()) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid header serialization: unexpected bytes.")))
								_ = _20_valueOrError7
								if (_20_valueOrError7).IsFailure() {
									return (_20_valueOrError7).PropagateFailure()
								} else {
									return m_Wrappers.Companion_Result_.Create_Success_(Companion_PartialHeader_.Create_PartialHeader_(_1_version, _3_flavor, _5_msgID, _9_legend, _13_encContext, _17_dataKeys))
								}
							}
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) CalculateHeaderCommitment(client m_AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, commitKey _dafny.Sequence, data _dafny.Sequence) m_Wrappers.Result {
	var _0_input m_AwsCryptographyPrimitivesTypes.HMacInput = m_AwsCryptographyPrimitivesTypes.Companion_HMacInput_.Create_HMacInput_((((alg).Dtor_commitment()).Dtor_HKDF()).Dtor_hmac(), commitKey, data)
	_ = _0_input
	var _1_outputR m_Wrappers.Result = (client).HMac(_0_input)
	_ = _1_outputR
	var _2_valueOrError0 m_Wrappers.Result = (_1_outputR).MapFailure(func(coer2 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg4 interface{}) interface{} {
			return coer2(arg4.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_3_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_3_e)
	}))
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		var _4_output _dafny.Sequence = (_2_valueOrError0).Extract().(_dafny.Sequence)
		_ = _4_output
		if (_dafny.IntOfUint32((_4_output).Cardinality())).Cmp(Companion_Default___.COMMITMENT__LEN()) < 0 {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("HMAC did not produce enough bits")))
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_((_4_output).Take((Companion_Default___.COMMITMENT__LEN()).Uint32()))
		}
	}
}
func (_static *CompanionStruct_Default___) ToUInt16(x _dafny.Int) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((x).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Value too big for 16 bits")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_((x).Uint16())
	}
}
func (_static *CompanionStruct_Default___) MyMap(f func(interface{}) interface{}, m _dafny.Map) _dafny.Map {
	return func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter7 := _dafny.Iterate((m).Keys().Elements()); ; {
			_compr_0, _ok7 := _iter7()
			if !_ok7 {
				break
			}
			var _0_k interface{}
			_0_k = interface{}(_compr_0).(interface{})
			if (m).Contains(_0_k) {
				_coll0.Add((f)(_0_k), (m).Get(_0_k).(interface{}))
			}
		}
		return _coll0.ToMap()
	}()
}
func (_static *CompanionStruct_Default___) MakeLegend(schema _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.MakeLegend2(schema, _dafny.Zero, Companion_Default___.EmptyLegend())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_legend _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_legend
		var _2_authCount _dafny.Int = Companion_Default___.CountAuthAttrs(schema, _dafny.Zero, _dafny.Zero)
		_ = _2_authCount
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_2_authCount).Cmp(_dafny.IntOfUint32((_1_legend).Cardinality())) == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal Error : bad legend calculation.")))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(_1_legend)
		}
	}
}
func (_static *CompanionStruct_Default___) MakeLegend2(data _dafny.Sequence, pos _dafny.Int, serialized _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((data).Cardinality())).Cmp(pos) == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(serialized)
	} else if m_StructuredEncryptionUtil.Companion_Default___.IsAuthAttr(((data).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action()) {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfUint32((serialized).Cardinality())).Plus(_dafny.One)).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Legend Too Long.")))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_legendChar uint8 = Companion_Default___.GetActionLegend(((data).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action())
			_ = _1_legendChar
			var _in0 _dafny.Sequence = data
			_ = _in0
			var _in1 _dafny.Int = (pos).Plus(_dafny.One)
			_ = _in1
			var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(serialized, _dafny.SeqOf(_1_legendChar))
			_ = _in2
			data = _in0
			pos = _in1
			serialized = _in2
			goto TAIL_CALL_START
		}
	} else {
		var _in3 _dafny.Sequence = data
		_ = _in3
		var _in4 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in4
		var _in5 _dafny.Sequence = serialized
		_ = _in5
		data = _in3
		pos = _in4
		serialized = _in5
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetActionLegend(x m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction) uint8 {
	var _source0 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction = x
	_ = _source0
	{
		if _source0.Is_ENCRYPT__AND__SIGN() {
			return Companion_Default___.ENCRYPT__AND__SIGN__LEGEND()
		}
	}
	{
		if _source0.Is_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT() {
			return Companion_Default___.SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT__LEGEND()
		}
	}
	{
		return Companion_Default___.SIGN__ONLY__LEGEND()
	}
}
func (_static *CompanionStruct_Default___) CountAuthAttrs(data _dafny.Sequence, pos _dafny.Int, acc _dafny.Int) _dafny.Int {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((data).Cardinality())).Cmp(pos) == 0 {
		return acc
	} else if m_StructuredEncryptionUtil.Companion_Default___.IsAuthAttr(((data).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action()) {
		var _in0 _dafny.Sequence = data
		_ = _in0
		var _in1 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in1
		var _in2 _dafny.Int = (acc).Plus(_dafny.One)
		_ = _in2
		data = _in0
		pos = _in1
		acc = _in2
		goto TAIL_CALL_START
	} else {
		var _in3 _dafny.Sequence = data
		_ = _in3
		var _in4 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in4
		var _in5 _dafny.Int = acc
		_ = _in5
		data = _in3
		pos = _in4
		acc = _in5
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) SerializeLegend(x _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(m_StandardLibrary_UInt.Companion_Default___.UInt16ToSeq(uint16((x).Cardinality())), x)
}
func (_static *CompanionStruct_Default___) GetLegend(data _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfInt64(2)).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_len uint16 = m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt16(data, _dafny.Zero)
		_ = _1_len
		var _2_size _dafny.Int = (_dafny.IntOfUint16(_1_len)).Plus(_dafny.IntOfInt64(2))
		_ = _2_size
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_2_size).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_legend _dafny.Sequence = (data).Subsequence(2, (_2_size).Uint32())
			_ = _4_legend
			var _5_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((_4_legend).UniqueElements(), true, func(_forall_var_0 uint8) bool {
				var _6_x uint8
				_6_x = interface{}(_forall_var_0).(uint8)
				if true {
					return !(_dafny.Companion_Sequence_.Contains(_4_legend, _6_x)) || (Companion_Default___.ValidLegendByte(_6_x))
				} else {
					return true
				}
			}), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid byte in stored legend")))
			_ = _5_valueOrError2
			if (_5_valueOrError2).IsFailure() {
				return (_5_valueOrError2).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_4_legend, _2_size))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) GetContext(data _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfInt64(2)).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_count _dafny.Int = _dafny.IntOfUint16(m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt16(data, _dafny.Zero))
		_ = _1_count
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.GetContext2(_1_count, data, _dafny.TupleOf(_dafny.NewMapBuilder().ToMap(), _dafny.IntOfInt64(2)), _dafny.SeqOf())
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_context _dafny.Tuple = (_2_valueOrError1).Extract().(_dafny.Tuple)
			_ = _3_context
			return m_Wrappers.Companion_Result_.Create_Success_(_3_context)
		}
	}
}
func (_static *CompanionStruct_Default___) GetOneKVPair(data _dafny.Sequence, pos _dafny.Int) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfInt64(2)).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_keyLen _dafny.Int = _dafny.IntOfUint16(m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt16(data, pos))
		_ = _1_keyLen
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_1_keyLen).Plus(_dafny.IntOfInt64(4))).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_key _dafny.Sequence = (data).Subsequence(((_dafny.IntOfInt64(2)).Plus(pos)).Uint32(), (((_1_keyLen).Plus(_dafny.IntOfInt64(2))).Plus(pos)).Uint32())
			_ = _3_key
			var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq(_3_key), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid UTF8 found in header.")))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_valueLen _dafny.Int = _dafny.IntOfUint16(m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt16(data, ((_1_keyLen).Plus(_dafny.IntOfInt64(2))).Plus(pos)))
				_ = _5_valueLen
				var _6_kvLen _dafny.Int = (((_dafny.IntOfInt64(2)).Plus(_1_keyLen)).Plus(_dafny.IntOfInt64(2))).Plus(_5_valueLen)
				_ = _6_kvLen
				var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_6_kvLen).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
				_ = _7_valueOrError3
				if (_7_valueOrError3).IsFailure() {
					return (_7_valueOrError3).PropagateFailure()
				} else {
					var _8_value _dafny.Sequence = (data).Subsequence((((_1_keyLen).Plus(_dafny.IntOfInt64(4))).Plus(pos)).Uint32(), ((_6_kvLen).Plus(pos)).Uint32())
					_ = _8_value
					var _9_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq(_8_value), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid UTF8 found in header.")))
					_ = _9_valueOrError4
					if (_9_valueOrError4).IsFailure() {
						return (_9_valueOrError4).PropagateFailure()
					} else {
						return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_3_key, _8_value, _6_kvLen))
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) BytesLess(a _dafny.Sequence, b _dafny.Sequence, pos _dafny.Int) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if _dafny.Companion_Sequence_.Equal(a, b) {
		return false
	} else if (_dafny.IntOfUint32((a).Cardinality())).Cmp(pos) == 0 {
		return true
	} else if (_dafny.IntOfUint32((b).Cardinality())).Cmp(pos) == 0 {
		return false
	} else if ((a).Select((pos).Uint32()).(uint8)) != ((b).Select((pos).Uint32()).(uint8)) /* dircomp */ {
		return ((a).Select((pos).Uint32()).(uint8)) < ((b).Select((pos).Uint32()).(uint8))
	} else {
		var _in0 _dafny.Sequence = a
		_ = _in0
		var _in1 _dafny.Sequence = b
		_ = _in1
		var _in2 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in2
		a = _in0
		b = _in1
		pos = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetContext2(count _dafny.Int, data _dafny.Sequence, deserialized _dafny.Tuple, prevKey _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (count).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(deserialized)
	} else {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((((*(deserialized).IndexInt(0)).(_dafny.Map)).Cardinality()).Plus(_dafny.One)).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Too much context")))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.GetOneKVPair(data, (*(deserialized).IndexInt(1)).(_dafny.Int))
			_ = _1_valueOrError1
			if (_1_valueOrError1).IsFailure() {
				return (_1_valueOrError1).PropagateFailure()
			} else {
				var _2_kv _dafny.Tuple = (_1_valueOrError1).Extract().(_dafny.Tuple)
				_ = _2_kv
				var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.BytesLess(prevKey, (*(_2_kv).IndexInt(0)).(_dafny.Sequence), _dafny.Zero), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Context keys out of order.")))
				_ = _3_valueOrError2
				if (_3_valueOrError2).IsFailure() {
					return (_3_valueOrError2).PropagateFailure()
				} else {
					var _in0 _dafny.Int = (count).Minus(_dafny.One)
					_ = _in0
					var _in1 _dafny.Sequence = data
					_ = _in1
					var _in2 _dafny.Tuple = _dafny.TupleOf(((*(deserialized).IndexInt(0)).(_dafny.Map)).Update((*(_2_kv).IndexInt(0)).(_dafny.Sequence), (*(_2_kv).IndexInt(1)).(_dafny.Sequence)), ((*(deserialized).IndexInt(1)).(_dafny.Int)).Plus((*(_2_kv).IndexInt(2)).(_dafny.Int)))
					_ = _in2
					var _in3 _dafny.Sequence = (*(_2_kv).IndexInt(0)).(_dafny.Sequence)
					_ = _in3
					count = _in0
					data = _in1
					deserialized = _in2
					prevKey = _in3
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) SerializeContext(x _dafny.Map) _dafny.Sequence {
	var _0_keys _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((x).Keys(), func(coer3 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
		return func(arg5 interface{}, arg6 interface{}) bool {
			return coer3(arg5.(uint8), arg6.(uint8))
		}
	}(m_StructuredEncryptionUtil.Companion_Default___.ByteLess))
	_ = _0_keys
	return _dafny.Companion_Sequence_.Concatenate(m_StandardLibrary_UInt.Companion_Default___.UInt16ToSeq(uint16((x).CardinalityInt())), Companion_Default___.SerializeContext2(_0_keys, x, _dafny.Zero, _dafny.SeqOf()))
}
func (_static *CompanionStruct_Default___) SerializeOneKVPair(key _dafny.Sequence, value _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_StandardLibrary_UInt.Companion_Default___.UInt16ToSeq(uint16((key).Cardinality())), key), m_StandardLibrary_UInt.Companion_Default___.UInt16ToSeq(uint16((value).Cardinality()))), value)
}
func (_static *CompanionStruct_Default___) SerializeOneDataKey(k m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_StandardLibrary_UInt.Companion_Default___.UInt16ToSeq(uint16(((k).Dtor_keyProviderId()).Cardinality())), (k).Dtor_keyProviderId()), m_StandardLibrary_UInt.Companion_Default___.UInt16ToSeq(uint16(((k).Dtor_keyProviderInfo()).Cardinality()))), (k).Dtor_keyProviderInfo()), m_StandardLibrary_UInt.Companion_Default___.UInt16ToSeq(uint16(((k).Dtor_ciphertext()).Cardinality()))), (k).Dtor_ciphertext())
}
func (_static *CompanionStruct_Default___) GetOneDataKey(data _dafny.Sequence, pos _dafny.Int) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfInt64(2)).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_provIdSize _dafny.Int = _dafny.IntOfUint16(m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt16(data, pos))
		_ = _1_provIdSize
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_1_provIdSize).Plus(_dafny.IntOfInt64(2))).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_provId _dafny.Sequence = (data).Subsequence(((pos).Plus(_dafny.IntOfInt64(2))).Uint32(), (((pos).Plus(_dafny.IntOfInt64(2))).Plus(_1_provIdSize)).Uint32())
			_ = _3_provId
			var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq(_3_provId), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid UTF8 found in header.")))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_part1Size _dafny.Int = (_dafny.IntOfInt64(2)).Plus(_1_provIdSize)
				_ = _5_part1Size
				var _6_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_5_part1Size).Plus(_dafny.IntOfInt64(2))).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
				_ = _6_valueOrError3
				if (_6_valueOrError3).IsFailure() {
					return (_6_valueOrError3).PropagateFailure()
				} else {
					var _7_provInfoSize _dafny.Int = _dafny.IntOfUint16(m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt16(data, (pos).Plus(_5_part1Size)))
					_ = _7_provInfoSize
					var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((((_5_part1Size).Plus(_7_provInfoSize)).Plus(_dafny.IntOfInt64(2))).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
					_ = _8_valueOrError4
					if (_8_valueOrError4).IsFailure() {
						return (_8_valueOrError4).PropagateFailure()
					} else {
						var _9_provInfo _dafny.Sequence = (data).Subsequence((((pos).Plus(_5_part1Size)).Plus(_dafny.IntOfInt64(2))).Uint32(), ((((pos).Plus(_5_part1Size)).Plus(_dafny.IntOfInt64(2))).Plus(_7_provInfoSize)).Uint32())
						_ = _9_provInfo
						var _10_part2Size _dafny.Int = ((_5_part1Size).Plus(_dafny.IntOfInt64(2))).Plus(_7_provInfoSize)
						_ = _10_part2Size
						var _11_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_10_part2Size).Plus(_dafny.IntOfInt64(2))).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
						_ = _11_valueOrError5
						if (_11_valueOrError5).IsFailure() {
							return (_11_valueOrError5).PropagateFailure()
						} else {
							var _12_cipherSize _dafny.Int = _dafny.IntOfUint16(m_StandardLibrary_UInt.Companion_Default___.SeqPosToUInt16(data, (pos).Plus(_10_part2Size)))
							_ = _12_cipherSize
							var _13_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((((_10_part2Size).Plus(_12_cipherSize)).Plus(_dafny.IntOfInt64(2))).Plus(pos)).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
							_ = _13_valueOrError6
							if (_13_valueOrError6).IsFailure() {
								return (_13_valueOrError6).PropagateFailure()
							} else {
								var _14_cipher _dafny.Sequence = (data).Subsequence((((pos).Plus(_10_part2Size)).Plus(_dafny.IntOfInt64(2))).Uint32(), ((((pos).Plus(_10_part2Size)).Plus(_dafny.IntOfInt64(2))).Plus(_12_cipherSize)).Uint32())
								_ = _14_cipher
								var _15_part3Size _dafny.Int = ((_10_part2Size).Plus(_dafny.IntOfInt64(2))).Plus(_12_cipherSize)
								_ = _15_part3Size
								var _16_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(_3_provId, _9_provInfo, _14_cipher)
								_ = _16_edk
								return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_16_edk, _15_part3Size))
							}
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) SerializeContext2(keys _dafny.Sequence, x _dafny.Map, pos _dafny.Int, acc _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((keys).Cardinality())).Cmp(pos) == 0 {
		return acc
	} else {
		var _in0 _dafny.Sequence = keys
		_ = _in0
		var _in1 _dafny.Map = x
		_ = _in1
		var _in2 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in2
		var _in3 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, Companion_Default___.SerializeOneKVPair((keys).Select((pos).Uint32()).(_dafny.Sequence), (x).Get((keys).Select((pos).Uint32()).(_dafny.Sequence)).(_dafny.Sequence)))
		_ = _in3
		keys = _in0
		x = _in1
		pos = _in2
		acc = _in3
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) SerializeDataKeys(x _dafny.Sequence) _dafny.Sequence {
	var _0_body _dafny.Sequence = Companion_Default___.SerializeDataKeys2(x, _dafny.Zero, _dafny.SeqOf())
	_ = _0_body
	return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(uint8((x).Cardinality())), _0_body)
}
func (_static *CompanionStruct_Default___) SerializeDataKeys2(x _dafny.Sequence, pos _dafny.Int, acc _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((x).Cardinality())).Cmp(pos) == 0 {
		return acc
	} else {
		var _in0 _dafny.Sequence = x
		_ = _in0
		var _in1 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in1
		var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, Companion_Default___.SerializeOneDataKey((x).Select((pos).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)))
		_ = _in2
		x = _in0
		pos = _in1
		acc = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetDataKeys(data _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.One).Cmp(_dafny.IntOfUint32((data).Cardinality())) <= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Unexpected end of header data.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_count _dafny.Int = _dafny.IntOfUint8((data).Select(0).(uint8))
		_ = _1_count
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.GetDataKeys2(_1_count, _1_count, data, _dafny.TupleOf(_dafny.SeqOf(), _dafny.One))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_keys _dafny.Tuple = (_2_valueOrError1).Extract().(_dafny.Tuple)
			_ = _3_keys
			if (_dafny.IntOfUint32(((*(_3_keys).IndexInt(0)).(_dafny.Sequence)).Cardinality())).Sign() == 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("At least one Data Key required")))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_3_keys)
			}
		}
	}
}
func (_static *CompanionStruct_Default___) GetDataKeys2(count _dafny.Int, origCount _dafny.Int, data _dafny.Sequence, deserialized _dafny.Tuple) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (count).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(deserialized)
	} else if (_dafny.IntOfUint32(((*(deserialized).IndexInt(0)).(_dafny.Sequence)).Cardinality())).Cmp(_dafny.IntOfInt64(255)) >= 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Too Many Data Keys")))
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.GetOneDataKey(data, (*(deserialized).IndexInt(1)).(_dafny.Int))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_edk _dafny.Tuple = (_0_valueOrError0).Extract().(_dafny.Tuple)
			_ = _1_edk
			var _in0 _dafny.Int = (count).Minus(_dafny.One)
			_ = _in0
			var _in1 _dafny.Int = origCount
			_ = _in1
			var _in2 _dafny.Sequence = data
			_ = _in2
			var _in3 _dafny.Tuple = _dafny.TupleOf(_dafny.Companion_Sequence_.Concatenate((*(deserialized).IndexInt(0)).(_dafny.Sequence), _dafny.SeqOf((*(_1_edk).IndexInt(0)).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey))), ((*(deserialized).IndexInt(1)).(_dafny.Int)).Plus((*(_1_edk).IndexInt(1)).(_dafny.Int)))
			_ = _in3
			count = _in0
			origCount = _in1
			data = _in2
			deserialized = _in3
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) VERSION__LEN() _dafny.Int {
	return _dafny.One
}
func (_static *CompanionStruct_Default___) FLAVOR__LEN() _dafny.Int {
	return _dafny.One
}
func (_static *CompanionStruct_Default___) PREFIX__LEN() _dafny.Int {
	return ((Companion_Default___.VERSION__LEN()).Plus(Companion_Default___.FLAVOR__LEN())).Plus(m_StructuredEncryptionUtil.Companion_Default___.MSGID__LEN())
}
func (_static *CompanionStruct_Default___) ENCRYPT__AND__SIGN__LEGEND() uint8 {
	return uint8(101)
}
func (_static *CompanionStruct_Default___) SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT__LEGEND() uint8 {
	return uint8(99)
}
func (_static *CompanionStruct_Default___) SIGN__ONLY__LEGEND() uint8 {
	return uint8(115)
}
func (_static *CompanionStruct_Default___) UINT8__LIMIT() _dafny.Int {
	return _dafny.IntOfInt64(256)
}
func (_static *CompanionStruct_Default___) COMMITMENT__LEN() _dafny.Int {
	return _dafny.IntOfInt64(32)
}
func (_static *CompanionStruct_Default___) EmptyLegend() _dafny.Sequence {
	return _dafny.SeqOf()
}

// End of class Default__

// Definition of class Version
type Version struct {
}

func New_Version_() *Version {
	_this := Version{}

	return &_this
}

type CompanionStruct_Version_ struct {
}

var Companion_Version_ = CompanionStruct_Version_{}

func (*Version) String() string {
	return "StructuredEncryptionHeader.Version"
}
func (_this *CompanionStruct_Version_) Witness() uint8 {
	return uint8(1)
}

// End of class Version

func Type_Version_() _dafny.TypeDescriptor {
	return type_Version_{}
}

type type_Version_ struct {
}

func (_this type_Version_) Default() interface{} {
	return Companion_Version_.Witness()
}

func (_this type_Version_) String() string {
	return "StructuredEncryptionHeader.Version"
}
func (_this *CompanionStruct_Version_) Is_(__source uint8) bool {
	var _0_x uint8 = (__source)
	_ = _0_x
	if true {
		return Companion_Default___.ValidVersion(_0_x)
	}
	return false
}

// Definition of class Flavor
type Flavor struct {
}

func New_Flavor_() *Flavor {
	_this := Flavor{}

	return &_this
}

type CompanionStruct_Flavor_ struct {
}

var Companion_Flavor_ = CompanionStruct_Flavor_{}

func (*Flavor) String() string {
	return "StructuredEncryptionHeader.Flavor"
}

// End of class Flavor

func Type_Flavor_() _dafny.TypeDescriptor {
	return type_Flavor_{}
}

type type_Flavor_ struct {
}

func (_this type_Flavor_) Default() interface{} {
	return uint8(0)
}

func (_this type_Flavor_) String() string {
	return "StructuredEncryptionHeader.Flavor"
}
func (_this *CompanionStruct_Flavor_) Is_(__source uint8) bool {
	var _1_x uint8 = (__source)
	_ = _1_x
	if true {
		return Companion_Default___.ValidFlavor(_1_x)
	}
	return false
}

// Definition of class CMPEncryptedDataKeyList
type CMPEncryptedDataKeyList struct {
}

func New_CMPEncryptedDataKeyList_() *CMPEncryptedDataKeyList {
	_this := CMPEncryptedDataKeyList{}

	return &_this
}

type CompanionStruct_CMPEncryptedDataKeyList_ struct {
}

var Companion_CMPEncryptedDataKeyList_ = CompanionStruct_CMPEncryptedDataKeyList_{}

func (*CMPEncryptedDataKeyList) String() string {
	return "StructuredEncryptionHeader.CMPEncryptedDataKeyList"
}

// End of class CMPEncryptedDataKeyList

func Type_CMPEncryptedDataKeyList_() _dafny.TypeDescriptor {
	return type_CMPEncryptedDataKeyList_{}
}

type type_CMPEncryptedDataKeyList_ struct {
}

func (_this type_CMPEncryptedDataKeyList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_CMPEncryptedDataKeyList_) String() string {
	return "StructuredEncryptionHeader.CMPEncryptedDataKeyList"
}
func (_this *CompanionStruct_CMPEncryptedDataKeyList_) Is_(__source _dafny.Sequence) bool {
	var _2_x _dafny.Sequence = (__source)
	_ = _2_x
	return ((_dafny.IntOfUint32((_2_x).Cardinality())).Sign() == 1) && ((_dafny.IntOfUint32((_2_x).Cardinality())).Cmp(Companion_Default___.UINT8__LIMIT()) < 0)
}

// Definition of class Commitment
type Commitment struct {
}

func New_Commitment_() *Commitment {
	_this := Commitment{}

	return &_this
}

type CompanionStruct_Commitment_ struct {
}

var Companion_Commitment_ = CompanionStruct_Commitment_{}

func (*Commitment) String() string {
	return "StructuredEncryptionHeader.Commitment"
}

// End of class Commitment

func Type_Commitment_() _dafny.TypeDescriptor {
	return type_Commitment_{}
}

type type_Commitment_ struct {
}

func (_this type_Commitment_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_Commitment_) String() string {
	return "StructuredEncryptionHeader.Commitment"
}
func (_this *CompanionStruct_Commitment_) Is_(__source _dafny.Sequence) bool {
	var _3_x _dafny.Sequence = (__source)
	_ = _3_x
	return (_dafny.IntOfUint32((_3_x).Cardinality())).Cmp(Companion_Default___.COMMITMENT__LEN()) == 0
}

// Definition of class CMPEncryptedDataKey
type CMPEncryptedDataKey struct {
}

func New_CMPEncryptedDataKey_() *CMPEncryptedDataKey {
	_this := CMPEncryptedDataKey{}

	return &_this
}

type CompanionStruct_CMPEncryptedDataKey_ struct {
}

var Companion_CMPEncryptedDataKey_ = CompanionStruct_CMPEncryptedDataKey_{}

func (*CMPEncryptedDataKey) String() string {
	return "StructuredEncryptionHeader.CMPEncryptedDataKey"
}

// End of class CMPEncryptedDataKey

func Type_CMPEncryptedDataKey_() _dafny.TypeDescriptor {
	return type_CMPEncryptedDataKey_{}
}

type type_CMPEncryptedDataKey_ struct {
}

func (_this type_CMPEncryptedDataKey_) Default() interface{} {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Default()
}

func (_this type_CMPEncryptedDataKey_) String() string {
	return "StructuredEncryptionHeader.CMPEncryptedDataKey"
}
func (_this *CompanionStruct_CMPEncryptedDataKey_) Is_(__source m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey) bool {
	var _4_x m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = (__source)
	_ = _4_x
	return Companion_Default___.ValidEncryptedDataKey(_4_x)
}

// Definition of class CMPEncryptionContext
type CMPEncryptionContext struct {
}

func New_CMPEncryptionContext_() *CMPEncryptionContext {
	_this := CMPEncryptionContext{}

	return &_this
}

type CompanionStruct_CMPEncryptionContext_ struct {
}

var Companion_CMPEncryptionContext_ = CompanionStruct_CMPEncryptionContext_{}

func (*CMPEncryptionContext) String() string {
	return "StructuredEncryptionHeader.CMPEncryptionContext"
}

// End of class CMPEncryptionContext

func Type_CMPEncryptionContext_() _dafny.TypeDescriptor {
	return type_CMPEncryptionContext_{}
}

type type_CMPEncryptionContext_ struct {
}

func (_this type_CMPEncryptionContext_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_CMPEncryptionContext_) String() string {
	return "StructuredEncryptionHeader.CMPEncryptionContext"
}
func (_this *CompanionStruct_CMPEncryptionContext_) Is_(__source _dafny.Map) bool {
	var _5_x _dafny.Map = (__source)
	_ = _5_x
	return Companion_Default___.ValidEncryptionContext(_5_x)
}

// Definition of class CMPEncryptedDataKeyListEmptyOK
type CMPEncryptedDataKeyListEmptyOK struct {
}

func New_CMPEncryptedDataKeyListEmptyOK_() *CMPEncryptedDataKeyListEmptyOK {
	_this := CMPEncryptedDataKeyListEmptyOK{}

	return &_this
}

type CompanionStruct_CMPEncryptedDataKeyListEmptyOK_ struct {
}

var Companion_CMPEncryptedDataKeyListEmptyOK_ = CompanionStruct_CMPEncryptedDataKeyListEmptyOK_{}

func (*CMPEncryptedDataKeyListEmptyOK) String() string {
	return "StructuredEncryptionHeader.CMPEncryptedDataKeyListEmptyOK"
}

// End of class CMPEncryptedDataKeyListEmptyOK

func Type_CMPEncryptedDataKeyListEmptyOK_() _dafny.TypeDescriptor {
	return type_CMPEncryptedDataKeyListEmptyOK_{}
}

type type_CMPEncryptedDataKeyListEmptyOK_ struct {
}

func (_this type_CMPEncryptedDataKeyListEmptyOK_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_CMPEncryptedDataKeyListEmptyOK_) String() string {
	return "StructuredEncryptionHeader.CMPEncryptedDataKeyListEmptyOK"
}
func (_this *CompanionStruct_CMPEncryptedDataKeyListEmptyOK_) Is_(__source _dafny.Sequence) bool {
	var _6_x _dafny.Sequence = (__source)
	_ = _6_x
	return (_dafny.IntOfUint32((_6_x).Cardinality())).Cmp(Companion_Default___.UINT8__LIMIT()) < 0
}

// Definition of class LegendByte
type LegendByte struct {
}

func New_LegendByte_() *LegendByte {
	_this := LegendByte{}

	return &_this
}

type CompanionStruct_LegendByte_ struct {
}

var Companion_LegendByte_ = CompanionStruct_LegendByte_{}

func (*LegendByte) String() string {
	return "StructuredEncryptionHeader.LegendByte"
}
func (_this *CompanionStruct_LegendByte_) Witness() uint8 {
	return Companion_Default___.SIGN__ONLY__LEGEND()
}

// End of class LegendByte

func Type_LegendByte_() _dafny.TypeDescriptor {
	return type_LegendByte_{}
}

type type_LegendByte_ struct {
}

func (_this type_LegendByte_) Default() interface{} {
	return Companion_LegendByte_.Witness()
}

func (_this type_LegendByte_) String() string {
	return "StructuredEncryptionHeader.LegendByte"
}
func (_this *CompanionStruct_LegendByte_) Is_(__source uint8) bool {
	var _7_x uint8 = (__source)
	_ = _7_x
	if true {
		return Companion_Default___.ValidLegendByte(_7_x)
	}
	return false
}

// Definition of class Legend
type Legend struct {
}

func New_Legend_() *Legend {
	_this := Legend{}

	return &_this
}

type CompanionStruct_Legend_ struct {
}

var Companion_Legend_ = CompanionStruct_Legend_{}

func (*Legend) String() string {
	return "StructuredEncryptionHeader.Legend"
}

// End of class Legend

func Type_Legend_() _dafny.TypeDescriptor {
	return type_Legend_{}
}

type type_Legend_ struct {
}

func (_this type_Legend_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_Legend_) String() string {
	return "StructuredEncryptionHeader.Legend"
}
func (_this *CompanionStruct_Legend_) Is_(__source _dafny.Sequence) bool {
	var _8_x _dafny.Sequence = (__source)
	_ = _8_x
	return (_dafny.IntOfUint32((_8_x).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0
}

// Definition of class CMPUtf8Bytes
type CMPUtf8Bytes struct {
}

func New_CMPUtf8Bytes_() *CMPUtf8Bytes {
	_this := CMPUtf8Bytes{}

	return &_this
}

type CompanionStruct_CMPUtf8Bytes_ struct {
}

var Companion_CMPUtf8Bytes_ = CompanionStruct_CMPUtf8Bytes_{}

func (*CMPUtf8Bytes) String() string {
	return "StructuredEncryptionHeader.CMPUtf8Bytes"
}

// End of class CMPUtf8Bytes

func Type_CMPUtf8Bytes_() _dafny.TypeDescriptor {
	return type_CMPUtf8Bytes_{}
}

type type_CMPUtf8Bytes_ struct {
}

func (_this type_CMPUtf8Bytes_) Default() interface{} {
	return m_UTF8.Companion_ValidUTF8Bytes_.Witness()
}

func (_this type_CMPUtf8Bytes_) String() string {
	return "StructuredEncryptionHeader.CMPUtf8Bytes"
}
func (_this *CompanionStruct_CMPUtf8Bytes_) Is_(__source _dafny.Sequence) bool {
	var _9_x _dafny.Sequence = (__source)
	_ = _9_x
	if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_9_x) {
		return (_dafny.IntOfUint32((_9_x).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0
	}
	return false
}

// Definition of datatype PartialHeader
type PartialHeader struct {
	Data_PartialHeader_
}

func (_this PartialHeader) Get_() Data_PartialHeader_ {
	return _this.Data_PartialHeader_
}

type Data_PartialHeader_ interface {
	isPartialHeader()
}

type CompanionStruct_PartialHeader_ struct {
}

var Companion_PartialHeader_ = CompanionStruct_PartialHeader_{}

type PartialHeader_PartialHeader struct {
	Version    uint8
	Flavor     uint8
	MsgID      _dafny.Sequence
	Legend     _dafny.Sequence
	EncContext _dafny.Map
	DataKeys   _dafny.Sequence
}

func (PartialHeader_PartialHeader) isPartialHeader() {}

func (CompanionStruct_PartialHeader_) Create_PartialHeader_(Version uint8, Flavor uint8, MsgID _dafny.Sequence, Legend _dafny.Sequence, EncContext _dafny.Map, DataKeys _dafny.Sequence) PartialHeader {
	return PartialHeader{PartialHeader_PartialHeader{Version, Flavor, MsgID, Legend, EncContext, DataKeys}}
}

func (_this PartialHeader) Is_PartialHeader() bool {
	_, ok := _this.Get_().(PartialHeader_PartialHeader)
	return ok
}

func (CompanionStruct_PartialHeader_) Default() PartialHeader {
	return Companion_PartialHeader_.Create_PartialHeader_(Companion_Version_.Witness(), uint8(0), _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptyMap, _dafny.EmptySeq)
}

func (_this PartialHeader) Dtor_version() uint8 {
	return _this.Get_().(PartialHeader_PartialHeader).Version
}

func (_this PartialHeader) Dtor_flavor() uint8 {
	return _this.Get_().(PartialHeader_PartialHeader).Flavor
}

func (_this PartialHeader) Dtor_msgID() _dafny.Sequence {
	return _this.Get_().(PartialHeader_PartialHeader).MsgID
}

func (_this PartialHeader) Dtor_legend() _dafny.Sequence {
	return _this.Get_().(PartialHeader_PartialHeader).Legend
}

func (_this PartialHeader) Dtor_encContext() _dafny.Map {
	return _this.Get_().(PartialHeader_PartialHeader).EncContext
}

func (_this PartialHeader) Dtor_dataKeys() _dafny.Sequence {
	return _this.Get_().(PartialHeader_PartialHeader).DataKeys
}

func (_this PartialHeader) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PartialHeader_PartialHeader:
		{
			return "StructuredEncryptionHeader.PartialHeader.PartialHeader" + "(" + _dafny.String(data.Version) + ", " + _dafny.String(data.Flavor) + ", " + _dafny.String(data.MsgID) + ", " + _dafny.String(data.Legend) + ", " + _dafny.String(data.EncContext) + ", " + _dafny.String(data.DataKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PartialHeader) Equals(other PartialHeader) bool {
	switch data1 := _this.Get_().(type) {
	case PartialHeader_PartialHeader:
		{
			data2, ok := other.Get_().(PartialHeader_PartialHeader)
			return ok && data1.Version == data2.Version && data1.Flavor == data2.Flavor && data1.MsgID.Equals(data2.MsgID) && data1.Legend.Equals(data2.Legend) && data1.EncContext.Equals(data2.EncContext) && data1.DataKeys.Equals(data2.DataKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PartialHeader) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PartialHeader)
	return ok && _this.Equals(typed)
}

func Type_PartialHeader_() _dafny.TypeDescriptor {
	return type_PartialHeader_{}
}

type type_PartialHeader_ struct {
}

func (_this type_PartialHeader_) Default() interface{} {
	return Companion_PartialHeader_.Default()
}

func (_this type_PartialHeader_) String() string {
	return "StructuredEncryptionHeader.PartialHeader"
}
func (_this PartialHeader) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PartialHeader{}

func (_this PartialHeader) Serialize() _dafny.Sequence {
	{
		var _0_context _dafny.Sequence = Companion_Default___.SerializeContext((_this).Dtor_encContext())
		_ = _0_context
		var _1_keys _dafny.Sequence = Companion_Default___.SerializeDataKeys((_this).Dtor_dataKeys())
		_ = _1_keys
		var _2_leg _dafny.Sequence = Companion_Default___.SerializeLegend((_this).Dtor_legend())
		_ = _2_leg
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf((_this).Dtor_version()), _dafny.SeqOf((_this).Dtor_flavor())), (_this).Dtor_msgID()), _2_leg), _0_context), _1_keys)
	}
}
func (_this PartialHeader) VerifyCommitment(client m_AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, commitKey _dafny.Sequence, data _dafny.Sequence) m_Wrappers.Result {
	{
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((Companion_Default___.COMMITMENT__LEN()).Cmp(_dafny.IntOfUint32((data).Cardinality())) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Serialized header too short")))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_storedCommitment _dafny.Sequence = (data).Drop(((_dafny.IntOfUint32((data).Cardinality())).Minus(Companion_Default___.COMMITMENT__LEN())).Uint32())
			_ = _1_storedCommitment
			var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.CalculateHeaderCommitment(client, alg, commitKey, (data).Take(((_dafny.IntOfUint32((data).Cardinality())).Minus(Companion_Default___.COMMITMENT__LEN())).Uint32()))
			_ = _2_valueOrError1
			if (_2_valueOrError1).IsFailure() {
				return (_2_valueOrError1).PropagateFailure()
			} else {
				var _3_calcCommitment _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
				_ = _3_calcCommitment
				var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.ConstantTimeEquals(_1_storedCommitment, _3_calcCommitment), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Key commitment mismatch.")))
				_ = _4_valueOrError2
				if (_4_valueOrError2).IsFailure() {
					return (_4_valueOrError2).PropagateFailure()
				} else {
					return m_Wrappers.Companion_Result_.Create_Success_(true)
				}
			}
		}
	}
}
func (_this PartialHeader) GetAlgorithmSuite(matProv *m_MaterialProviders.MaterialProvidersClient) m_Wrappers.Result {
	{
		var ret m_Wrappers.Result = m_Wrappers.Result{}
		_ = ret
		var _0_algorithmSuiteR m_Wrappers.Result
		_ = _0_algorithmSuiteR
		_0_algorithmSuiteR = (matProv).GetAlgorithmSuiteInfo(_dafny.SeqOf(m_StructuredEncryptionUtil.Companion_Default___.DbeAlgorithmFamily(), (_this).Dtor_flavor()))
		if (_0_algorithmSuiteR).Is_Success() {
			var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _1_valueOrError0
			_1_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.ValidSuite((_0_algorithmSuiteR).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo)), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Algorithm Suite")))
			if (_1_valueOrError0).IsFailure() {
				ret = (_1_valueOrError0).PropagateFailure()
				return ret
			}
			ret = m_Wrappers.Companion_Result_.Create_Success_((_0_algorithmSuiteR).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo))
			return ret
		} else {
			ret = (_0_algorithmSuiteR).MapFailure(func(coer4 func(m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
				return func(arg7 interface{}) interface{} {
					return coer4(arg7.(m_AwsCryptographyMaterialProvidersTypes.Error))
				}
			}(func(_2_e m_AwsCryptographyMaterialProvidersTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
				return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyMaterialProviders_(_2_e)
			}))
			return ret
		}
		return ret
	}
}

// End of datatype PartialHeader
