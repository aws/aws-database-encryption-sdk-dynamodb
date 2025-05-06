// Package StructuredEncryptionPaths
// Dafny module StructuredEncryptionPaths compiled into Go

package StructuredEncryptionPaths

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
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
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
	return "StructuredEncryptionPaths.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ValidTerminalSelector(s _dafny.Sequence) bool {
	return (((_dafny.IntOfUint32((s).Cardinality())).Sign() == 1) && ((_dafny.IntOfUint32((s).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT64__LIMIT()) < 0)) && (((s).Select(0).(Selector)).Is_Map())
}
func (_static *CompanionStruct_Default___) StringToUniPath(x _dafny.Sequence) _dafny.Sequence {
	return _dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_PathSegment_.Create_member_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructureSegment_.Create_StructureSegment_(x)))
}
func (_static *CompanionStruct_Default___) UniPathToString(x _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_((((x).Select(0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment)).Dtor_member()).Dtor_key())
}
func (_static *CompanionStruct_Default___) ValidPath(path _dafny.Sequence) bool {
	return ((_dafny.IntOfUint32((path).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT64__LIMIT()) < 0) && (_dafny.Quantifier((path).UniqueElements(), true, func(_forall_var_0 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment) bool {
		var _0_x m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment
		_0_x = interface{}(_forall_var_0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment)
		return !(_dafny.Companion_Sequence_.Contains(path, _0_x)) || (m_StructuredEncryptionUtil.Companion_Default___.ValidString(((_0_x).Dtor_member()).Dtor_key()))
	}))
}
func (_static *CompanionStruct_Default___) CanonPath(table _dafny.Sequence, path _dafny.Sequence) _dafny.Sequence {
	var _0_tableName _dafny.Sequence = (m_UTF8.Encode(table)).Dtor_value().(_dafny.Sequence)
	_ = _0_tableName
	var _1_depth _dafny.Sequence = m_StandardLibrary_UInt.Companion_Default___.UInt64ToSeq(uint64((path).Cardinality()))
	_ = _1_depth
	var _2_path _dafny.Sequence = Companion_Default___.MakeCanonicalPath(path)
	_ = _2_path
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_0_tableName, _1_depth), _2_path)
}
func (_static *CompanionStruct_Default___) TermLocMap_q(attr _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_StructuredEncryptionUtil.Companion_Default___.ValidString(attr), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("invalid string : "), attr)))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_PathSegment_.Create_member_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructureSegment_.Create_StructureSegment_(attr))))
	}
}
func (_static *CompanionStruct_Default___) TermLocMap(attr _dafny.Sequence) _dafny.Sequence {
	return _dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_PathSegment_.Create_member_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructureSegment_.Create_StructureSegment_(attr)))
}
func (_static *CompanionStruct_Default___) SimpleCanon(table _dafny.Sequence, attr _dafny.Sequence) _dafny.Sequence {
	return Companion_Default___.CanonPath(table, Companion_Default___.TermLocMap(attr))
}
func (_static *CompanionStruct_Default___) CanonicalPart(s m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(Companion_Default___.MAP__TAG()), m_StandardLibrary_UInt.Companion_Default___.UInt64ToSeq(uint64((((s).Dtor_member()).Dtor_key()).Cardinality()))), (m_UTF8.Encode(((s).Dtor_member()).Dtor_key())).Dtor_value().(_dafny.Sequence))
}
func (_static *CompanionStruct_Default___) MakeCanonicalPath(path _dafny.Sequence) _dafny.Sequence {
	var ret _dafny.Sequence = _dafny.EmptySeq
	_ = ret
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf()
	var _lo0 _dafny.Int = _dafny.Zero
	_ = _lo0
	for _1_i := _dafny.IntOfUint32((path).Cardinality()); _lo0.Cmp(_1_i) < 0; {
		_1_i = _1_i.Minus(_dafny.One)
		_0_result = _dafny.Companion_Sequence_.Concatenate(Companion_Default___.CanonicalPart((path).Select((_1_i).Uint32()).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment)), _0_result)
	}
	ret = _0_result
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) PathToString(path _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((path).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfString(""))
	} else if (_dafny.IntOfUint32((path).Cardinality())).Cmp(_dafny.One) == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, (((path).Select(0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment)).Dtor_member()).Dtor_key())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.Companion_Sequence_.Concatenate((((path).Select(0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment)).Dtor_member()).Dtor_key(), _dafny.SeqOfString(".")))
		var _in0 _dafny.Sequence = (path).Drop(1)
		_ = _in0
		path = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) MAP__TAG() uint8 {
	return uint8(_dafny.Char('$'))
}
func (_static *CompanionStruct_Default___) ARRAY__TAG() uint8 {
	return uint8(_dafny.Char('#'))
}

// End of class Default__

// Definition of datatype Selector
type Selector struct {
	Data_Selector_
}

func (_this Selector) Get_() Data_Selector_ {
	return _this.Data_Selector_
}

type Data_Selector_ interface {
	isSelector()
}

type CompanionStruct_Selector_ struct {
}

var Companion_Selector_ = CompanionStruct_Selector_{}

type Selector_List struct {
	Pos uint64
}

func (Selector_List) isSelector() {}

func (CompanionStruct_Selector_) Create_List_(Pos uint64) Selector {
	return Selector{Selector_List{Pos}}
}

func (_this Selector) Is_List() bool {
	_, ok := _this.Get_().(Selector_List)
	return ok
}

type Selector_Map struct {
	Key _dafny.Sequence
}

func (Selector_Map) isSelector() {}

func (CompanionStruct_Selector_) Create_Map_(Key _dafny.Sequence) Selector {
	return Selector{Selector_Map{Key}}
}

func (_this Selector) Is_Map() bool {
	_, ok := _this.Get_().(Selector_Map)
	return ok
}

func (CompanionStruct_Selector_) Default() Selector {
	return Companion_Selector_.Create_List_(uint64(0))
}

func (_this Selector) Dtor_pos() uint64 {
	return _this.Get_().(Selector_List).Pos
}

func (_this Selector) Dtor_key() _dafny.Sequence {
	return _this.Get_().(Selector_Map).Key
}

func (_this Selector) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Selector_List:
		{
			return "StructuredEncryptionPaths.Selector.List" + "(" + _dafny.String(data.Pos) + ")"
		}
	case Selector_Map:
		{
			return "StructuredEncryptionPaths.Selector.Map" + "(" + _dafny.String(data.Key) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Selector) Equals(other Selector) bool {
	switch data1 := _this.Get_().(type) {
	case Selector_List:
		{
			data2, ok := other.Get_().(Selector_List)
			return ok && data1.Pos == data2.Pos
		}
	case Selector_Map:
		{
			data2, ok := other.Get_().(Selector_Map)
			return ok && data1.Key.Equals(data2.Key)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Selector) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Selector)
	return ok && _this.Equals(typed)
}

func Type_Selector_() _dafny.TypeDescriptor {
	return type_Selector_{}
}

type type_Selector_ struct {
}

func (_this type_Selector_) Default() interface{} {
	return Companion_Selector_.Default()
}

func (_this type_Selector_) String() string {
	return "StructuredEncryptionPaths.Selector"
}
func (_this Selector) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Selector{}

// End of datatype Selector

// Definition of class SelectorList
type SelectorList struct {
}

func New_SelectorList_() *SelectorList {
	_this := SelectorList{}

	return &_this
}

type CompanionStruct_SelectorList_ struct {
}

var Companion_SelectorList_ = CompanionStruct_SelectorList_{}

func (*SelectorList) String() string {
	return "StructuredEncryptionPaths.SelectorList"
}

// End of class SelectorList

func Type_SelectorList_() _dafny.TypeDescriptor {
	return type_SelectorList_{}
}

type type_SelectorList_ struct {
}

func (_this type_SelectorList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_SelectorList_) String() string {
	return "StructuredEncryptionPaths.SelectorList"
}
func (_this *CompanionStruct_SelectorList_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return (_dafny.IntOfUint32((_0_x).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT64__LIMIT()) < 0
}

// Definition of class TerminalSelector
type TerminalSelector struct {
}

func New_TerminalSelector_() *TerminalSelector {
	_this := TerminalSelector{}

	return &_this
}

type CompanionStruct_TerminalSelector_ struct {
}

var Companion_TerminalSelector_ = CompanionStruct_TerminalSelector_{}

func (*TerminalSelector) String() string {
	return "StructuredEncryptionPaths.TerminalSelector"
}

// End of class TerminalSelector

func Type_TerminalSelector_() _dafny.TypeDescriptor {
	return type_TerminalSelector_{}
}

type type_TerminalSelector_ struct {
}

func (_this type_TerminalSelector_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_TerminalSelector_) String() string {
	return "StructuredEncryptionPaths.TerminalSelector"
}
func (_this *CompanionStruct_TerminalSelector_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return Companion_Default___.ValidTerminalSelector(_1_x)
}
