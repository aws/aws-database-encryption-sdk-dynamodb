// Package AwsCryptographyMaterialProvidersOperations
// Dafny module AwsCryptographyMaterialProvidersOperations compiled into Go

package AwsCryptographyMaterialProvidersOperations

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
	m_UUID "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UUID"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
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
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m__Unicode.Dummy__
var _ m_Functions.Dummy__
var _ m_Utf8EncodingForm.Dummy__
var _ m_Utf16EncodingForm.Dummy__
var _ m_UnicodeStrings.Dummy__
var _ m_FileIO.Dummy__
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
var _ m_Base64.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_Actions.Dummy__
var _ m_AwsCryptographyKeyStoreTypes.Dummy__
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_AwsArnParsing.Dummy__
var _ m_AwsKmsMrkMatchForDecrypt.Dummy__
var _ m_AwsKmsUtils.Dummy__
var _ m_KeyStoreErrorMessages.Dummy__
var _ m_KmsArn.Dummy__
var _ m_Structure.Dummy__
var _ m_KMSKeystoreOperations.Dummy__
var _ m_DDBKeystoreOperations.Dummy__
var _ m_CreateKeys.Dummy__
var _ m_CreateKeyStoreTable.Dummy__
var _ m_GetKeys.Dummy__
var _ m_AwsCryptographyKeyStoreOperations.Dummy__
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
var _ m_KeyStore.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_MultiKeyring.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_Constants.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_DiscoveryMultiKeyring.Dummy__
var _ m_AwsKmsMrkDiscoveryKeyring.Dummy__
var _ m_MrkAwareDiscoveryMultiKeyring.Dummy__
var _ m_AwsKmsMrkKeyring.Dummy__
var _ m_MrkAwareStrictMultiKeyring.Dummy__
var _ m_LocalCMC.Dummy__
var _ m_SynchronizedLocalCMC.Dummy__
var _ m_StormTracker.Dummy__
var _ m_StormTrackingCMC.Dummy__
var _ m_CacheConstants.Dummy__
var _ m_AwsKmsHierarchicalKeyring.Dummy__
var _ m_AwsKmsRsaKeyring.Dummy__
var _ m_EcdhEdkWrapping.Dummy__
var _ m_RawECDHKeyring.Dummy__
var _ m_AwsKmsEcdhKeyring.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_RawRSAKeyring.Dummy__
var _ m_CMM.Dummy__
var _ m_Defaults.Dummy__
var _ m_Commitment.Dummy__
var _ m_DefaultCMM.Dummy__
var _ m_DefaultClientSupplier.Dummy__
var _ m_Utils.Dummy__
var _ m_RequiredEncryptionContextCMM.Dummy__

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
	return "AwsCryptographyMaterialProvidersOperations.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) CreateAwsKmsKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
	_ = _0_valueOrError0
	_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId((input).Dtor_kmsKeyId())
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1___v0 _dafny.Tuple
	_ = _1___v0
	_1___v0 = (_0_valueOrError0).Extract().(_dafny.Tuple)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError1
	_2_valueOrError1 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _3_grantTokens _dafny.Sequence
	_ = _3_grantTokens
	_3_grantTokens = (_2_valueOrError1).Extract().(_dafny.Sequence)
	var _4_keyring *m_AwsKmsKeyring.AwsKmsKeyring
	_ = _4_keyring
	var _nw0 *m_AwsKmsKeyring.AwsKmsKeyring = m_AwsKmsKeyring.New_AwsKmsKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_kmsClient(), (input).Dtor_kmsKeyId(), _3_grantTokens)
	_4_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_4_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsDiscoveryKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsDiscoveryKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	if ((input).Dtor_discoveryFilter()).Is_Some() {
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = _0_valueOrError0
		_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.ValidateDiscoveryFilter(((input).Dtor_discoveryFilter()).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.DiscoveryFilter))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1___v1 _dafny.Tuple
		_ = _1___v1
		_1___v1 = (_0_valueOrError0).Extract().(_dafny.Tuple)
	}
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError1
	_2_valueOrError1 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _3_grantTokens _dafny.Sequence
	_ = _3_grantTokens
	_3_grantTokens = (_2_valueOrError1).Extract().(_dafny.Sequence)
	var _4_keyring *m_AwsKmsDiscoveryKeyring.AwsKmsDiscoveryKeyring
	_ = _4_keyring
	var _nw0 *m_AwsKmsDiscoveryKeyring.AwsKmsDiscoveryKeyring = m_AwsKmsDiscoveryKeyring.New_AwsKmsDiscoveryKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_kmsClient(), (input).Dtor_discoveryFilter(), _3_grantTokens)
	_4_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_4_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsMultiKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_grantTokens _dafny.Sequence
	_ = _1_grantTokens
	_1_grantTokens = (_0_valueOrError0).Extract().(_dafny.Sequence)
	if ((input).Dtor_clientSupplier()).Is_Some() {
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_StrictMultiKeyring.Companion_Default___.StrictMultiKeyring((input).Dtor_generator(), (input).Dtor_kmsKeyIds(), m_AwsCryptographyMaterialProvidersTypes.Companion_IClientSupplier_.CastTo_(((input).Dtor_clientSupplier()).Dtor_value()), m_Wrappers.Companion_Option_.Create_Some_(_1_grantTokens))
		output = _out0
	} else {
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError1
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.CreateDefaultClientSupplier(config, m_AwsCryptographyMaterialProvidersTypes.Companion_CreateDefaultClientSupplierInput_.Create_CreateDefaultClientSupplierInput_())
		_2_valueOrError1 = _out1
		if (_2_valueOrError1).IsFailure() {
			output = (_2_valueOrError1).PropagateFailure()
			return output
		}
		var _3_clientSupplier m_AwsCryptographyMaterialProvidersTypes.IClientSupplier
		_ = _3_clientSupplier
		_3_clientSupplier = m_AwsCryptographyMaterialProvidersTypes.Companion_IClientSupplier_.CastTo_((_2_valueOrError1).Extract())
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_StrictMultiKeyring.Companion_Default___.StrictMultiKeyring((input).Dtor_generator(), (input).Dtor_kmsKeyIds(), _3_clientSupplier, m_Wrappers.Companion_Option_.Create_Some_(_1_grantTokens))
		output = _out2
	}
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsDiscoveryMultiKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsDiscoveryMultiKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_grantTokens _dafny.Sequence
	_ = _1_grantTokens
	_1_grantTokens = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_clientSupplier m_AwsCryptographyMaterialProvidersTypes.IClientSupplier = (m_AwsCryptographyMaterialProvidersTypes.IClientSupplier)(nil)
	_ = _2_clientSupplier
	if ((input).Dtor_clientSupplier()).Is_None() {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.CreateDefaultClientSupplier(config, m_AwsCryptographyMaterialProvidersTypes.Companion_CreateDefaultClientSupplierInput_.Create_CreateDefaultClientSupplierInput_())
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		_2_clientSupplier = m_AwsCryptographyMaterialProvidersTypes.Companion_IClientSupplier_.CastTo_((_3_valueOrError1).Extract())
	} else {
		_2_clientSupplier = m_AwsCryptographyMaterialProvidersTypes.Companion_IClientSupplier_.CastTo_(((input).Dtor_clientSupplier()).Dtor_value())
	}
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_DiscoveryMultiKeyring.Companion_Default___.DiscoveryMultiKeyring((input).Dtor_regions(), (input).Dtor_discoveryFilter(), _2_clientSupplier, m_Wrappers.Companion_Option_.Create_Some_(_1_grantTokens))
	output = _out1
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsMrkKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
	_ = _0_valueOrError0
	_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId((input).Dtor_kmsKeyId())
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1___v2 _dafny.Tuple
	_ = _1___v2
	_1___v2 = (_0_valueOrError0).Extract().(_dafny.Tuple)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError1
	_2_valueOrError1 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _3_grantTokens _dafny.Sequence
	_ = _3_grantTokens
	_3_grantTokens = (_2_valueOrError1).Extract().(_dafny.Sequence)
	var _4_keyring *m_AwsKmsMrkKeyring.AwsKmsMrkKeyring
	_ = _4_keyring
	var _nw0 *m_AwsKmsMrkKeyring.AwsKmsMrkKeyring = m_AwsKmsMrkKeyring.New_AwsKmsMrkKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_kmsClient(), (input).Dtor_kmsKeyId(), _3_grantTokens)
	_4_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_4_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsMrkMultiKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkMultiKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_grantTokens _dafny.Sequence
	_ = _1_grantTokens
	_1_grantTokens = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_clientSupplier m_AwsCryptographyMaterialProvidersTypes.IClientSupplier = (m_AwsCryptographyMaterialProvidersTypes.IClientSupplier)(nil)
	_ = _2_clientSupplier
	if ((input).Dtor_clientSupplier()).Is_None() {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.CreateDefaultClientSupplier(config, m_AwsCryptographyMaterialProvidersTypes.Companion_CreateDefaultClientSupplierInput_.Create_CreateDefaultClientSupplierInput_())
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		_2_clientSupplier = m_AwsCryptographyMaterialProvidersTypes.Companion_IClientSupplier_.CastTo_((_3_valueOrError1).Extract())
	} else {
		_2_clientSupplier = m_AwsCryptographyMaterialProvidersTypes.Companion_IClientSupplier_.CastTo_(((input).Dtor_clientSupplier()).Dtor_value())
	}
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_MrkAwareStrictMultiKeyring.Companion_Default___.MrkAwareStrictMultiKeyring((input).Dtor_generator(), (input).Dtor_kmsKeyIds(), _2_clientSupplier, m_Wrappers.Companion_Option_.Create_Some_(_1_grantTokens))
	output = _out1
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsMrkDiscoveryKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkDiscoveryKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	if ((input).Dtor_discoveryFilter()).Is_Some() {
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = _0_valueOrError0
		_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.ValidateDiscoveryFilter(((input).Dtor_discoveryFilter()).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.DiscoveryFilter))
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1___v3 _dafny.Tuple
		_ = _1___v3
		_1___v3 = (_0_valueOrError0).Extract().(_dafny.Tuple)
	}
	var _2_regionMatch m_Wrappers.Option
	_ = _2_regionMatch
	_2_regionMatch = m_Com_Amazonaws_Kms.Companion_Default___.RegionMatch((input).Dtor_kmsClient(), (input).Dtor_region())
	var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError1
	_3_valueOrError1 = m_Wrappers.Companion_Default___.Need(!(_2_regionMatch).Equals(m_Wrappers.Companion_Option_.Create_Some_(false)), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Provided client and region do not match")))
	if (_3_valueOrError1).IsFailure() {
		output = (_3_valueOrError1).PropagateFailure()
		return output
	}
	var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError2
	_4_valueOrError2 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5_grantTokens _dafny.Sequence
	_ = _5_grantTokens
	_5_grantTokens = (_4_valueOrError2).Extract().(_dafny.Sequence)
	var _6_keyring *m_AwsKmsMrkDiscoveryKeyring.AwsKmsMrkDiscoveryKeyring
	_ = _6_keyring
	var _nw0 *m_AwsKmsMrkDiscoveryKeyring.AwsKmsMrkDiscoveryKeyring = m_AwsKmsMrkDiscoveryKeyring.New_AwsKmsMrkDiscoveryKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_kmsClient(), (input).Dtor_region(), (input).Dtor_discoveryFilter(), _5_grantTokens)
	_6_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_6_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsMrkDiscoveryMultiKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMrkDiscoveryMultiKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_grantTokens _dafny.Sequence
	_ = _1_grantTokens
	_1_grantTokens = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_clientSupplier m_AwsCryptographyMaterialProvidersTypes.IClientSupplier = (m_AwsCryptographyMaterialProvidersTypes.IClientSupplier)(nil)
	_ = _2_clientSupplier
	if ((input).Dtor_clientSupplier()).Is_None() {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.CreateDefaultClientSupplier(config, m_AwsCryptographyMaterialProvidersTypes.Companion_CreateDefaultClientSupplierInput_.Create_CreateDefaultClientSupplierInput_())
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		_2_clientSupplier = m_AwsCryptographyMaterialProvidersTypes.Companion_IClientSupplier_.CastTo_((_3_valueOrError1).Extract())
	} else {
		_2_clientSupplier = m_AwsCryptographyMaterialProvidersTypes.Companion_IClientSupplier_.CastTo_(((input).Dtor_clientSupplier()).Dtor_value())
	}
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_MrkAwareDiscoveryMultiKeyring.Companion_Default___.MrkAwareDiscoveryMultiKeyring((input).Dtor_regions(), (input).Dtor_discoveryFilter(), _2_clientSupplier, m_Wrappers.Companion_Option_.Create_Some_(_1_grantTokens))
	output = _out1
	return output
}
func (_static *CompanionStruct_Default___) N(n int64) _dafny.Sequence {
	return m_StandardLibrary_String.Companion_Default___.Base10Int2String(_dafny.IntOfInt64(n))
}
func (_static *CompanionStruct_Default___) CheckCache(cache m_AwsCryptographyMaterialProvidersTypes.CacheType, ttlSeconds int64) m_Wrappers.Outcome {
	var output m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = output
	if (cache).Is_StormTracking() {
		var _0_gracePeriod int64
		_ = _0_gracePeriod
		if ((((cache).Dtor_StormTracking()).Dtor_timeUnits()).UnwrapOr(m_AwsCryptographyMaterialProvidersTypes.Companion_TimeUnits_.Create_Seconds_()).(m_AwsCryptographyMaterialProvidersTypes.TimeUnits)).Is_Seconds() {
			_0_gracePeriod = int64(((cache).Dtor_StormTracking()).Dtor_gracePeriod())
		} else {
			_0_gracePeriod = _dafny.DivInt64(int64(((cache).Dtor_StormTracking()).Dtor_gracePeriod()), int64(1000))
		}
		var _1_storm m_AwsCryptographyMaterialProvidersTypes.StormTrackingCache
		_ = _1_storm
		_1_storm = (cache).Dtor_StormTracking()
		if (ttlSeconds) <= (_0_gracePeriod) {
			var _2_msg _dafny.Sequence
			_ = _2_msg
			_2_msg = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("When creating an AwsKmsHierarchicalKeyring with a StormCache, "), _dafny.SeqOfString("the ttlSeconds of the KeyRing must be greater than the gracePeriod of the StormCache ")), _dafny.SeqOfString("yet the ttlSeconds is ")), Companion_Default___.N(ttlSeconds)), _dafny.SeqOfString(" and the gracePeriod is ")), Companion_Default___.N(_0_gracePeriod)), _dafny.SeqOfString("."))
			output = m_Wrappers.Companion_Outcome_.Create_Fail_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_2_msg))
			return output
		}
		output = m_Wrappers.Companion_Outcome_.Create_Pass_()
		return output
	} else {
		output = m_Wrappers.Companion_Outcome_.Create_Pass_()
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsHierarchicalKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsHierarchicalKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_cmc m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache = (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache)(nil)
	_ = _0_cmc
	if ((input).Dtor_cache()).Is_Some() {
		var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _1_valueOrError0
		var _out0 m_Wrappers.Outcome
		_ = _out0
		_out0 = Companion_Default___.CheckCache(((input).Dtor_cache()).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.CacheType), (input).Dtor_ttlSeconds())
		_1_valueOrError0 = _out0
		if (_1_valueOrError0).IsFailure() {
			output = (_1_valueOrError0).PropagateFailure()
			return output
		}
		var _source0 m_AwsCryptographyMaterialProvidersTypes.CacheType = ((input).Dtor_cache()).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.CacheType)
		_ = _source0
		{
			{
				if _source0.Is_Shared() {
					var _2_c m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.CacheType_Shared).Shared
					_ = _2_c
					_0_cmc = _2_c
					goto Lmatch0
				}
			}
			{
				var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _3_valueOrError1
				var _out1 m_Wrappers.Result
				_ = _out1
				_out1 = Companion_Default___.CreateCryptographicMaterialsCache(config, m_AwsCryptographyMaterialProvidersTypes.Companion_CreateCryptographicMaterialsCacheInput_.Create_CreateCryptographicMaterialsCacheInput_(((input).Dtor_cache()).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.CacheType)))
				_3_valueOrError1 = _out1
				if (_3_valueOrError1).IsFailure() {
					output = (_3_valueOrError1).PropagateFailure()
					return output
				}
				_0_cmc = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.CastTo_((_3_valueOrError1).Extract())
			}
			goto Lmatch0
		}
	Lmatch0:
	} else {
		var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError2
		var _out2 m_Wrappers.Outcome
		_ = _out2
		_out2 = Companion_Default___.CheckCache(m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_StormTracking_(m_StormTracker.Companion_Default___.DefaultStorm()), (input).Dtor_ttlSeconds())
		_4_valueOrError2 = _out2
		if (_4_valueOrError2).IsFailure() {
			output = (_4_valueOrError2).PropagateFailure()
			return output
		}
		var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _5_valueOrError3
		var _out3 m_Wrappers.Result
		_ = _out3
		_out3 = Companion_Default___.CreateCryptographicMaterialsCache(config, m_AwsCryptographyMaterialProvidersTypes.Companion_CreateCryptographicMaterialsCacheInput_.Create_CreateCryptographicMaterialsCacheInput_(m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_Default_(m_AwsCryptographyMaterialProvidersTypes.Companion_DefaultCache_.Create_DefaultCache_(int32(1000)))))
		_5_valueOrError3 = _out3
		if (_5_valueOrError3).IsFailure() {
			output = (_5_valueOrError3).PropagateFailure()
			return output
		}
		_0_cmc = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.CastTo_((_5_valueOrError3).Extract())
	}
	var _6_partitionIdBytes _dafny.Sequence = _dafny.EmptySeq
	_ = _6_partitionIdBytes
	if ((input).Dtor_partitionId()).Is_Some() {
		var _7_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _7_valueOrError4
		_7_valueOrError4 = (m_UTF8.Encode(((input).Dtor_partitionId()).Dtor_value().(_dafny.Sequence))).MapFailure(func(coer132 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg133 interface{}) interface{} {
				return coer132(arg133.(_dafny.Sequence))
			}
		}(func(_8_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Could not UTF-8 Encode Partition ID: "), _8_e))
		}))
		if (_7_valueOrError4).IsFailure() {
			output = (_7_valueOrError4).PropagateFailure()
			return output
		}
		_6_partitionIdBytes = (_7_valueOrError4).Extract().(_dafny.Sequence)
	} else {
		var _9_uuid_q m_Wrappers.Result
		_ = _9_uuid_q
		var _out4 m_Wrappers.Result
		_ = _out4
		_out4 = m_UUID.GenerateUUID()
		_9_uuid_q = _out4
		var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _10_valueOrError5
		_10_valueOrError5 = (_9_uuid_q).MapFailure(func(coer133 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg134 interface{}) interface{} {
				return coer133(arg134.(_dafny.Sequence))
			}
		}(func(_11_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_11_e)
		}))
		if (_10_valueOrError5).IsFailure() {
			output = (_10_valueOrError5).PropagateFailure()
			return output
		}
		var _12_uuid _dafny.Sequence
		_ = _12_uuid
		_12_uuid = (_10_valueOrError5).Extract().(_dafny.Sequence)
		var _13_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _13_valueOrError6
		_13_valueOrError6 = (m_UUID.ToByteArray(_12_uuid)).MapFailure(func(coer134 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg135 interface{}) interface{} {
				return coer134(arg135.(_dafny.Sequence))
			}
		}(func(_14_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_14_e)
		}))
		if (_13_valueOrError6).IsFailure() {
			output = (_13_valueOrError6).PropagateFailure()
			return output
		}
		_6_partitionIdBytes = (_13_valueOrError6).Extract().(_dafny.Sequence)
	}
	var _15_getKeyStoreInfoOutput_q m_Wrappers.Result
	_ = _15_getKeyStoreInfoOutput_q
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = ((input).Dtor_keyStore()).GetKeyStoreInfo()
	_15_getKeyStoreInfoOutput_q = _out5
	var _16_valueOrError7 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _16_valueOrError7
	_16_valueOrError7 = (_15_getKeyStoreInfoOutput_q).MapFailure(func(coer135 func(m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg136 interface{}) interface{} {
			return coer135(arg136.(m_AwsCryptographyKeyStoreTypes.Error))
		}
	}(func(_17_e m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyKeyStore_(_17_e)
	}))
	if (_16_valueOrError7).IsFailure() {
		output = (_16_valueOrError7).PropagateFailure()
		return output
	}
	var _18_getKeyStoreInfoOutput m_AwsCryptographyKeyStoreTypes.GetKeyStoreInfoOutput
	_ = _18_getKeyStoreInfoOutput
	_18_getKeyStoreInfoOutput = (_16_valueOrError7).Extract().(m_AwsCryptographyKeyStoreTypes.GetKeyStoreInfoOutput)
	var _19_logicalKeyStoreName _dafny.Sequence
	_ = _19_logicalKeyStoreName
	_19_logicalKeyStoreName = (_18_getKeyStoreInfoOutput).Dtor_logicalKeyStoreName()
	var _20_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _20_valueOrError8
	_20_valueOrError8 = (m_UTF8.Encode(_19_logicalKeyStoreName)).MapFailure(func(coer136 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg137 interface{}) interface{} {
			return coer136(arg137.(_dafny.Sequence))
		}
	}(func(_21_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Could not UTF-8 Encode Logical Key Store Name: "), _21_e))
	}))
	if (_20_valueOrError8).IsFailure() {
		output = (_20_valueOrError8).PropagateFailure()
		return output
	}
	var _22_logicalKeyStoreNameBytes _dafny.Sequence
	_ = _22_logicalKeyStoreNameBytes
	_22_logicalKeyStoreNameBytes = (_20_valueOrError8).Extract().(_dafny.Sequence)
	var _23_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _23_valueOrError9
	_23_valueOrError9 = m_Wrappers.Companion_Default___.Need((((input).Dtor_branchKeyId()).Is_None()) || (((input).Dtor_branchKeyIdSupplier()).Is_None()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Cannot initialize keyring with both a branchKeyId and BranchKeyIdSupplier.")))
	if (_23_valueOrError9).IsFailure() {
		output = (_23_valueOrError9).PropagateFailure()
		return output
	}
	var _24_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _24_valueOrError10
	_24_valueOrError10 = m_Wrappers.Companion_Default___.Need((((input).Dtor_branchKeyId()).Is_Some()) || (((input).Dtor_branchKeyIdSupplier()).Is_Some()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Must initialize keyring with either branchKeyId or BranchKeyIdSupplier.")))
	if (_24_valueOrError10).IsFailure() {
		output = (_24_valueOrError10).PropagateFailure()
		return output
	}
	var _25_keyring *m_AwsKmsHierarchicalKeyring.AwsKmsHierarchicalKeyring
	_ = _25_keyring
	var _nw0 *m_AwsKmsHierarchicalKeyring.AwsKmsHierarchicalKeyring = m_AwsKmsHierarchicalKeyring.New_AwsKmsHierarchicalKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_keyStore(), (input).Dtor_branchKeyId(), (input).Dtor_branchKeyIdSupplier(), (input).Dtor_ttlSeconds(), _0_cmc, _6_partitionIdBytes, _22_logicalKeyStoreNameBytes, (config).Dtor_crypto())
	_25_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_25_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsEcdhKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsEcdhKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_grantTokens _dafny.Sequence
	_ = _1_grantTokens
	_1_grantTokens = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_recipientPublicKey _dafny.Sequence = _dafny.EmptySeq
	_ = _2_recipientPublicKey
	var _3_senderPublicKey m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = _3_senderPublicKey
	var _4_compressedSenderPublicKey m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = _4_compressedSenderPublicKey
	var _source0 m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations = (input).Dtor_KeyAgreementScheme()
	_ = _source0
	{
		{
			if _source0.Is_KmsPublicKeyDiscovery() {
				var _5_kmsPublicKeyDiscovery m_AwsCryptographyMaterialProvidersTypes.KmsPublicKeyDiscoveryInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery).KmsPublicKeyDiscovery
				_ = _5_kmsPublicKeyDiscovery
				{
					var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
					_ = _6_valueOrError1
					_6_valueOrError1 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId((_5_kmsPublicKeyDiscovery).Dtor_recipientKmsIdentifier())
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
					var _7___v5 _dafny.Tuple
					_ = _7___v5
					_7___v5 = (_6_valueOrError1).Extract().(_dafny.Tuple)
					var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _8_valueOrError2
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = m_AwsKmsUtils.Companion_Default___.GetEcdhPublicKey((input).Dtor_kmsClient(), (_5_kmsPublicKeyDiscovery).Dtor_recipientKmsIdentifier())
					_8_valueOrError2 = _out0
					if (_8_valueOrError2).IsFailure() {
						output = (_8_valueOrError2).PropagateFailure()
						return output
					}
					_2_recipientPublicKey = (_8_valueOrError2).Extract().(_dafny.Sequence)
					_3_senderPublicKey = m_Wrappers.Companion_Option_.Create_None_()
					_4_compressedSenderPublicKey = m_Wrappers.Companion_Option_.Create_None_()
				}
				goto Lmatch0
			}
		}
		{
			var _9_kmsPrivateKeyToStaticPublicKey m_AwsCryptographyMaterialProvidersTypes.KmsPrivateKeyToStaticPublicKeyInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey).KmsPrivateKeyToStaticPublicKey
			_ = _9_kmsPrivateKeyToStaticPublicKey
			{
				if ((_9_kmsPrivateKeyToStaticPublicKey).Dtor_senderPublicKey()).Is_Some() {
					var _10_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _10_valueOrError3
					_10_valueOrError3 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__PublicKeyType(((_9_kmsPrivateKeyToStaticPublicKey).Dtor_senderPublicKey()).Dtor_value().(_dafny.Sequence)), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid SenderPublicKey length.")))
					if (_10_valueOrError3).IsFailure() {
						output = (_10_valueOrError3).PropagateFailure()
						return output
					}
					_3_senderPublicKey = m_Wrappers.Companion_Option_.Create_Some_(((_9_kmsPrivateKeyToStaticPublicKey).Dtor_senderPublicKey()).Dtor_value().(_dafny.Sequence))
					var _11_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _11_valueOrError4
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = m_RawECDHKeyring.Companion_Default___.CompressPublicKey(m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_((_3_senderPublicKey).Dtor_value().(_dafny.Sequence)), (input).Dtor_curveSpec(), (config).Dtor_crypto())
					_11_valueOrError4 = _out1
					if (_11_valueOrError4).IsFailure() {
						output = (_11_valueOrError4).PropagateFailure()
						return output
					}
					var _12_compressedPKU _dafny.Sequence
					_ = _12_compressedPKU
					_12_compressedPKU = (_11_valueOrError4).Extract().(_dafny.Sequence)
					_4_compressedSenderPublicKey = m_Wrappers.Companion_Option_.Create_Some_(_12_compressedPKU)
				} else {
					var _13_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
					_ = _13_valueOrError5
					_13_valueOrError5 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId((_9_kmsPrivateKeyToStaticPublicKey).Dtor_senderKmsIdentifier())
					if (_13_valueOrError5).IsFailure() {
						output = (_13_valueOrError5).PropagateFailure()
						return output
					}
					var _14___v6 _dafny.Tuple
					_ = _14___v6
					_14___v6 = (_13_valueOrError5).Extract().(_dafny.Tuple)
					var _15_valueOrError6 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _15_valueOrError6
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = m_AwsKmsUtils.Companion_Default___.GetEcdhPublicKey((input).Dtor_kmsClient(), (_9_kmsPrivateKeyToStaticPublicKey).Dtor_senderKmsIdentifier())
					_15_valueOrError6 = _out2
					if (_15_valueOrError6).IsFailure() {
						output = (_15_valueOrError6).PropagateFailure()
						return output
					}
					var _16_senderPublicKeyResponse _dafny.Sequence
					_ = _16_senderPublicKeyResponse
					_16_senderPublicKeyResponse = (_15_valueOrError6).Extract().(_dafny.Sequence)
					var _17_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _17_valueOrError7
					var _out3 m_Wrappers.Result
					_ = _out3
					_out3 = m_RawECDHKeyring.Companion_Default___.CompressPublicKey(m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(_16_senderPublicKeyResponse), (input).Dtor_curveSpec(), (config).Dtor_crypto())
					_17_valueOrError7 = _out3
					if (_17_valueOrError7).IsFailure() {
						output = (_17_valueOrError7).PropagateFailure()
						return output
					}
					var _18_compressedPKU _dafny.Sequence
					_ = _18_compressedPKU
					_18_compressedPKU = (_17_valueOrError7).Extract().(_dafny.Sequence)
					_3_senderPublicKey = m_Wrappers.Companion_Option_.Create_Some_(_16_senderPublicKeyResponse)
					_4_compressedSenderPublicKey = m_Wrappers.Companion_Option_.Create_Some_(_18_compressedPKU)
				}
				var _19_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _19_valueOrError8
				_19_valueOrError8 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__PublicKeyType((_9_kmsPrivateKeyToStaticPublicKey).Dtor_recipientPublicKey()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid RecipientPublicKey length.")))
				if (_19_valueOrError8).IsFailure() {
					output = (_19_valueOrError8).PropagateFailure()
					return output
				}
				_2_recipientPublicKey = (_9_kmsPrivateKeyToStaticPublicKey).Dtor_recipientPublicKey()
			}
		}
		goto Lmatch0
	}
Lmatch0:
	var _20_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = _20_valueOrError9
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_RawECDHKeyring.Companion_Default___.ValidatePublicKey((config).Dtor_crypto(), (input).Dtor_curveSpec(), _2_recipientPublicKey)
	_20_valueOrError9 = _out4
	if (_20_valueOrError9).IsFailure() {
		output = (_20_valueOrError9).PropagateFailure()
		return output
	}
	var _21___v7 bool
	_ = _21___v7
	_21___v7 = (_20_valueOrError9).Extract().(bool)
	var _22_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _22_valueOrError10
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_RawECDHKeyring.Companion_Default___.CompressPublicKey(m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(_2_recipientPublicKey), (input).Dtor_curveSpec(), (config).Dtor_crypto())
	_22_valueOrError10 = _out5
	if (_22_valueOrError10).IsFailure() {
		output = (_22_valueOrError10).PropagateFailure()
		return output
	}
	var _23_compressedRecipientPublicKey _dafny.Sequence
	_ = _23_compressedRecipientPublicKey
	_23_compressedRecipientPublicKey = (_22_valueOrError10).Extract().(_dafny.Sequence)
	var _24_senderKmsKeyId m_Wrappers.Option
	_ = _24_senderKmsKeyId
	if ((input).Dtor_KeyAgreementScheme()).Is_KmsPublicKeyDiscovery() {
		_24_senderKmsKeyId = m_Wrappers.Companion_Option_.Create_None_()
	} else {
		_24_senderKmsKeyId = m_Wrappers.Companion_Option_.Create_Some_((((input).Dtor_KeyAgreementScheme()).Dtor_KmsPrivateKeyToStaticPublicKey()).Dtor_senderKmsIdentifier())
	}
	if (_24_senderKmsKeyId).Is_Some() {
		var _25_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = _25_valueOrError11
		_25_valueOrError11 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId((_24_senderKmsKeyId).Dtor_value().(_dafny.Sequence))
		if (_25_valueOrError11).IsFailure() {
			output = (_25_valueOrError11).PropagateFailure()
			return output
		}
		var _26___v8 _dafny.Tuple
		_ = _26___v8
		_26___v8 = (_25_valueOrError11).Extract().(_dafny.Tuple)
	}
	if (_3_senderPublicKey).Is_Some() {
		var _27_valueOrError12 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _27_valueOrError12
		var _out6 m_Wrappers.Result
		_ = _out6
		_out6 = m_RawECDHKeyring.Companion_Default___.ValidatePublicKey((config).Dtor_crypto(), (input).Dtor_curveSpec(), (_3_senderPublicKey).Dtor_value().(_dafny.Sequence))
		_27_valueOrError12 = _out6
		if (_27_valueOrError12).IsFailure() {
			output = (_27_valueOrError12).PropagateFailure()
			return output
		}
		var _28___v9 bool
		_ = _28___v9
		_28___v9 = (_27_valueOrError12).Extract().(bool)
	}
	var _29_keyring *m_AwsKmsEcdhKeyring.AwsKmsEcdhKeyring
	_ = _29_keyring
	var _nw0 *m_AwsKmsEcdhKeyring.AwsKmsEcdhKeyring = m_AwsKmsEcdhKeyring.New_AwsKmsEcdhKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_KeyAgreementScheme(), (input).Dtor_curveSpec(), (input).Dtor_kmsClient(), _1_grantTokens, _24_senderKmsKeyId, _3_senderPublicKey, _2_recipientPublicKey, _4_compressedSenderPublicKey, _23_compressedRecipientPublicKey, (config).Dtor_crypto())
	_29_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_29_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateMultiKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateMultiKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_generator()).Is_Some()) || ((_dafny.IntOfUint32(((input).Dtor_childKeyrings()).Cardinality())).Sign() == 1), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Must include a generator keyring and/or at least one child keyring")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_keyring *m_MultiKeyring.MultiKeyring
	_ = _1_keyring
	var _nw0 *m_MultiKeyring.MultiKeyring = m_MultiKeyring.New_MultiKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_generator(), (input).Dtor_childKeyrings())
	_1_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateRawAesKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateRawAesKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(!_dafny.Companion_Sequence_.Equal((input).Dtor_keyNamespace(), _dafny.SeqOfString("aws-kms")), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("keyNamespace must not be `aws-kms`")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_wrappingAlg m_AwsCryptographyPrimitivesTypes.AES__GCM
	_ = _1_wrappingAlg
	var _source0 m_AwsCryptographyMaterialProvidersTypes.AesWrappingAlg = (input).Dtor_wrappingAlg()
	_ = _source0
	{
		{
			if _source0.Is_ALG__AES128__GCM__IV12__TAG16() {
				_1_wrappingAlg = m_AwsCryptographyPrimitivesTypes.Companion_AES__GCM_.Create_AES__GCM_(int32(16), int32(16), int32(12))
				goto Lmatch0
			}
		}
		{
			if _source0.Is_ALG__AES192__GCM__IV12__TAG16() {
				_1_wrappingAlg = m_AwsCryptographyPrimitivesTypes.Companion_AES__GCM_.Create_AES__GCM_(int32(24), int32(16), int32(12))
				goto Lmatch0
			}
		}
		{
			_1_wrappingAlg = m_AwsCryptographyPrimitivesTypes.Companion_AES__GCM_.Create_AES__GCM_(int32(32), int32(16), int32(12))
		}
		goto Lmatch0
	}
Lmatch0:
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf(m_UTF8.Companion_ValidUTF8Bytes_.Witness(), m_UTF8.Companion_ValidUTF8Bytes_.Witness()))
	_ = _2_valueOrError1
	_2_valueOrError1 = m_AwsKmsUtils.Companion_Default___.ParseKeyNamespaceAndName((input).Dtor_keyNamespace(), (input).Dtor_keyName())
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _3_namespaceAndName _dafny.Tuple
	_ = _3_namespaceAndName
	_3_namespaceAndName = (_2_valueOrError1).Extract().(_dafny.Tuple)
	var _let_tmp_rhs0 _dafny.Tuple = _3_namespaceAndName
	_ = _let_tmp_rhs0
	var _4_namespace _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Sequence)
	_ = _4_namespace
	var _5_name _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Sequence)
	_ = _5_name
	var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _6_valueOrError2
	_6_valueOrError2 = m_Wrappers.Companion_Default___.Need((((_dafny.IntOfUint32(((input).Dtor_wrappingKey()).Cardinality())).Cmp(_dafny.IntOfInt64(16)) == 0) || ((_dafny.IntOfUint32(((input).Dtor_wrappingKey()).Cardinality())).Cmp(_dafny.IntOfInt64(24)) == 0)) || ((_dafny.IntOfUint32(((input).Dtor_wrappingKey()).Cardinality())).Cmp(_dafny.IntOfInt64(32)) == 0), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid wrapping key length")))
	if (_6_valueOrError2).IsFailure() {
		output = (_6_valueOrError2).PropagateFailure()
		return output
	}
	var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _7_valueOrError3
	_7_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((input).Dtor_wrappingKey()).Cardinality())).Cmp(_dafny.IntOfInt32((_1_wrappingAlg).Dtor_keyLength())) == 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Wrapping key length does not match specified wrapping algorithm")))
	if (_7_valueOrError3).IsFailure() {
		output = (_7_valueOrError3).PropagateFailure()
		return output
	}
	var _8_keyring *m_RawAESKeyring.RawAESKeyring
	_ = _8_keyring
	var _nw0 *m_RawAESKeyring.RawAESKeyring = m_RawAESKeyring.New_RawAESKeyring_()
	_ = _nw0
	_nw0.Ctor__(_4_namespace, _5_name, (input).Dtor_wrappingKey(), _1_wrappingAlg, (config).Dtor_crypto())
	_8_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_8_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateRawRsaKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateRawRsaKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(!_dafny.Companion_Sequence_.Equal((input).Dtor_keyNamespace(), _dafny.SeqOfString("aws-kms")), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("keyNamespace must not be `aws-kms`")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need((((input).Dtor_publicKey()).Is_Some()) || (((input).Dtor_privateKey()).Is_Some()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("A publicKey or a privateKey is required")))
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_padding m_AwsCryptographyPrimitivesTypes.RSAPaddingMode
	_ = _2_padding
	var _source0 m_AwsCryptographyMaterialProvidersTypes.PaddingScheme = (input).Dtor_paddingScheme()
	_ = _source0
	{
		{
			if _source0.Is_PKCS1() {
				_2_padding = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_PKCS1_()
				goto Lmatch0
			}
		}
		{
			if _source0.Is_OAEP__SHA1__MGF1() {
				_2_padding = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA1_()
				goto Lmatch0
			}
		}
		{
			if _source0.Is_OAEP__SHA256__MGF1() {
				_2_padding = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA256_()
				goto Lmatch0
			}
		}
		{
			if _source0.Is_OAEP__SHA384__MGF1() {
				_2_padding = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA384_()
				goto Lmatch0
			}
		}
		{
			_2_padding = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA512_()
		}
		goto Lmatch0
	}
Lmatch0:
	var _3_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf(m_UTF8.Companion_ValidUTF8Bytes_.Witness(), m_UTF8.Companion_ValidUTF8Bytes_.Witness()))
	_ = _3_valueOrError2
	_3_valueOrError2 = m_AwsKmsUtils.Companion_Default___.ParseKeyNamespaceAndName((input).Dtor_keyNamespace(), (input).Dtor_keyName())
	if (_3_valueOrError2).IsFailure() {
		output = (_3_valueOrError2).PropagateFailure()
		return output
	}
	var _4_namespaceAndName _dafny.Tuple
	_ = _4_namespaceAndName
	_4_namespaceAndName = (_3_valueOrError2).Extract().(_dafny.Tuple)
	var _let_tmp_rhs0 _dafny.Tuple = _4_namespaceAndName
	_ = _let_tmp_rhs0
	var _5_namespace _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Sequence)
	_ = _5_namespace
	var _6_name _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Sequence)
	_ = _6_name
	var _7_keyring *m_RawRSAKeyring.RawRSAKeyring
	_ = _7_keyring
	var _nw0 *m_RawRSAKeyring.RawRSAKeyring = m_RawRSAKeyring.New_RawRSAKeyring_()
	_ = _nw0
	_nw0.Ctor__(_5_namespace, _6_name, (input).Dtor_publicKey(), (input).Dtor_privateKey(), _2_padding, (config).Dtor_crypto())
	_7_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_7_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateRawEcdhKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateRawEcdhKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_recipientPublicKey _dafny.Sequence = _dafny.EmptySeq
	_ = _0_recipientPublicKey
	var _1_senderPrivateKey m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = _1_senderPrivateKey
	var _2_senderPublicKey m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = _2_senderPublicKey
	var _3_compressedSenderPublicKey m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = _3_compressedSenderPublicKey
	var _source0 m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations = (input).Dtor_KeyAgreementScheme()
	_ = _source0
	{
		{
			if _source0.Is_RawPrivateKeyToStaticPublicKey() {
				var _4_rawPrivateKeyToStaticPublicKey m_AwsCryptographyMaterialProvidersTypes.RawPrivateKeyToStaticPublicKeyInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey).RawPrivateKeyToStaticPublicKey
				_ = _4_rawPrivateKeyToStaticPublicKey
				{
					_0_recipientPublicKey = (_4_rawPrivateKeyToStaticPublicKey).Dtor_recipientPublicKey()
					_1_senderPrivateKey = m_Wrappers.Companion_Option_.Create_Some_((_4_rawPrivateKeyToStaticPublicKey).Dtor_senderStaticPrivateKey())
					var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _5_valueOrError0
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = m_Utils.Companion_Default___.GetPublicKey((input).Dtor_curveSpec(), m_AwsCryptographyPrimitivesTypes.Companion_ECCPrivateKey_.Create_ECCPrivateKey_((_1_senderPrivateKey).Dtor_value().(_dafny.Sequence)), (config).Dtor_crypto())
					_5_valueOrError0 = _out0
					if (_5_valueOrError0).IsFailure() {
						output = (_5_valueOrError0).PropagateFailure()
						return output
					}
					var _6_reproducedPublicKey _dafny.Sequence
					_ = _6_reproducedPublicKey
					_6_reproducedPublicKey = (_5_valueOrError0).Extract().(_dafny.Sequence)
					var _7_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
					_ = _7_valueOrError1
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = m_RawECDHKeyring.Companion_Default___.ValidatePublicKey((config).Dtor_crypto(), (input).Dtor_curveSpec(), _6_reproducedPublicKey)
					_7_valueOrError1 = _out1
					if (_7_valueOrError1).IsFailure() {
						output = (_7_valueOrError1).PropagateFailure()
						return output
					}
					var _8___v10 bool
					_ = _8___v10
					_8___v10 = (_7_valueOrError1).Extract().(bool)
					_2_senderPublicKey = m_Wrappers.Companion_Option_.Create_Some_(_6_reproducedPublicKey)
					var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _9_valueOrError2
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = m_RawECDHKeyring.Companion_Default___.CompressPublicKey(m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(_6_reproducedPublicKey), (input).Dtor_curveSpec(), (config).Dtor_crypto())
					_9_valueOrError2 = _out2
					if (_9_valueOrError2).IsFailure() {
						output = (_9_valueOrError2).PropagateFailure()
						return output
					}
					var _10_compressedSenderPublicKey_q _dafny.Sequence
					_ = _10_compressedSenderPublicKey_q
					_10_compressedSenderPublicKey_q = (_9_valueOrError2).Extract().(_dafny.Sequence)
					_3_compressedSenderPublicKey = m_Wrappers.Companion_Option_.Create_Some_(_10_compressedSenderPublicKey_q)
				}
				goto Lmatch0
			}
		}
		{
			if _source0.Is_EphemeralPrivateKeyToStaticPublicKey() {
				var _11_ephemeralPrivateKeyToStaticPublicKey m_AwsCryptographyMaterialProvidersTypes.EphemeralPrivateKeyToStaticPublicKeyInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations_EphemeralPrivateKeyToStaticPublicKey).EphemeralPrivateKeyToStaticPublicKey
				_ = _11_ephemeralPrivateKeyToStaticPublicKey
				{
					_0_recipientPublicKey = (_11_ephemeralPrivateKeyToStaticPublicKey).Dtor_recipientPublicKey()
					_1_senderPrivateKey = m_Wrappers.Companion_Option_.Create_None_()
					_2_senderPublicKey = m_Wrappers.Companion_Option_.Create_None_()
					_3_compressedSenderPublicKey = m_Wrappers.Companion_Option_.Create_None_()
				}
				goto Lmatch0
			}
		}
		{
			var _12_publicKeyDiscovery m_AwsCryptographyMaterialProvidersTypes.PublicKeyDiscoveryInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations_PublicKeyDiscovery).PublicKeyDiscovery
			_ = _12_publicKeyDiscovery
			{
				var _13_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
				_ = _13_valueOrError3
				var _out3 m_Wrappers.Result
				_ = _out3
				_out3 = m_Utils.Companion_Default___.GetPublicKey((input).Dtor_curveSpec(), m_AwsCryptographyPrimitivesTypes.Companion_ECCPrivateKey_.Create_ECCPrivateKey_((_12_publicKeyDiscovery).Dtor_recipientStaticPrivateKey()), (config).Dtor_crypto())
				_13_valueOrError3 = _out3
				if (_13_valueOrError3).IsFailure() {
					output = (_13_valueOrError3).PropagateFailure()
					return output
				}
				var _14_reproducedPublicKey _dafny.Sequence
				_ = _14_reproducedPublicKey
				_14_reproducedPublicKey = (_13_valueOrError3).Extract().(_dafny.Sequence)
				_0_recipientPublicKey = _14_reproducedPublicKey
				_1_senderPrivateKey = m_Wrappers.Companion_Option_.Create_None_()
				_2_senderPublicKey = m_Wrappers.Companion_Option_.Create_None_()
				_3_compressedSenderPublicKey = m_Wrappers.Companion_Option_.Create_None_()
			}
		}
		goto Lmatch0
	}
Lmatch0:
	var _15_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _15_valueOrError4
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_RawECDHKeyring.Companion_Default___.CompressPublicKey(m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(_0_recipientPublicKey), (input).Dtor_curveSpec(), (config).Dtor_crypto())
	_15_valueOrError4 = _out4
	if (_15_valueOrError4).IsFailure() {
		output = (_15_valueOrError4).PropagateFailure()
		return output
	}
	var _16_compressedRecipientPublicKey _dafny.Sequence
	_ = _16_compressedRecipientPublicKey
	_16_compressedRecipientPublicKey = (_15_valueOrError4).Extract().(_dafny.Sequence)
	var _17_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = _17_valueOrError5
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_RawECDHKeyring.Companion_Default___.ValidatePublicKey((config).Dtor_crypto(), (input).Dtor_curveSpec(), _0_recipientPublicKey)
	_17_valueOrError5 = _out5
	if (_17_valueOrError5).IsFailure() {
		output = (_17_valueOrError5).PropagateFailure()
		return output
	}
	var _18___v11 bool
	_ = _18___v11
	_18___v11 = (_17_valueOrError5).Extract().(bool)
	if (_2_senderPublicKey).Is_Some() {
		var _19_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _19_valueOrError6
		var _out6 m_Wrappers.Result
		_ = _out6
		_out6 = m_RawECDHKeyring.Companion_Default___.ValidatePublicKey((config).Dtor_crypto(), (input).Dtor_curveSpec(), (_2_senderPublicKey).Dtor_value().(_dafny.Sequence))
		_19_valueOrError6 = _out6
		if (_19_valueOrError6).IsFailure() {
			output = (_19_valueOrError6).PropagateFailure()
			return output
		}
		var _20___v12 bool
		_ = _20___v12
		_20___v12 = (_19_valueOrError6).Extract().(bool)
		var _21_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _21_valueOrError7
		_21_valueOrError7 = m_Wrappers.Companion_Default___.Need(m_RawECDHKeyring.Companion_Default___.ValidPublicKeyLength((_2_senderPublicKey).Dtor_value().(_dafny.Sequence)), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid sender public key length")))
		if (_21_valueOrError7).IsFailure() {
			output = (_21_valueOrError7).PropagateFailure()
			return output
		}
	}
	var _22_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _22_valueOrError8
	_22_valueOrError8 = m_Wrappers.Companion_Default___.Need(m_RawECDHKeyring.Companion_Default___.ValidPublicKeyLength(_0_recipientPublicKey), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid recipient public key length")))
	if (_22_valueOrError8).IsFailure() {
		output = (_22_valueOrError8).PropagateFailure()
		return output
	}
	var _23_keyring *m_RawECDHKeyring.RawEcdhKeyring
	_ = _23_keyring
	var _nw0 *m_RawECDHKeyring.RawEcdhKeyring = m_RawECDHKeyring.New_RawEcdhKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_KeyAgreementScheme(), (input).Dtor_curveSpec(), _1_senderPrivateKey, _2_senderPublicKey, _0_recipientPublicKey, _3_compressedSenderPublicKey, _16_compressedRecipientPublicKey, (config).Dtor_crypto())
	_23_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_23_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateAwsKmsRsaKeyring(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateAwsKmsRsaKeyringInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_publicKey()).Is_Some()) || (((input).Dtor_kmsClient()).Is_Some()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("A publicKey or a kmsClient is required")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need((((input).Dtor_encryptionAlgorithm()).Is_RSAES__OAEP__SHA__1()) || (((input).Dtor_encryptionAlgorithm()).Is_RSAES__OAEP__SHA__256()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Unsupported EncryptionAlgorithmSpec")))
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _2_valueOrError2
	_2_valueOrError2 = m_Wrappers.Companion_Default___.Need((m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__KeyIdType((input).Dtor_kmsKeyId())) && ((m_AwsArnParsing.Companion_Default___.ParseAwsKmsArn((input).Dtor_kmsKeyId())).Is_Success()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Kms Key ID must be a KMS Key ARN")))
	if (_2_valueOrError2).IsFailure() {
		output = (_2_valueOrError2).PropagateFailure()
		return output
	}
	if ((input).Dtor_publicKey()).Is_Some() {
		var _3_lengthOutputRes m_Wrappers.Result
		_ = _3_lengthOutputRes
		_3_lengthOutputRes = ((config).Dtor_crypto()).GetRSAKeyModulusLength(m_AwsCryptographyPrimitivesTypes.Companion_GetRSAKeyModulusLengthInput_.Create_GetRSAKeyModulusLengthInput_(((input).Dtor_publicKey()).Dtor_value().(_dafny.Sequence)))
		var _4_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError3
		_4_valueOrError3 = (_3_lengthOutputRes).MapFailure(func(coer137 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg138 interface{}) interface{} {
				return coer137(arg138.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_5_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_5_e)
		}))
		if (_4_valueOrError3).IsFailure() {
			output = (_4_valueOrError3).PropagateFailure()
			return output
		}
		var _6_lengthOutput m_AwsCryptographyPrimitivesTypes.GetRSAKeyModulusLengthOutput
		_ = _6_lengthOutput
		_6_lengthOutput = (_4_valueOrError3).Extract().(m_AwsCryptographyPrimitivesTypes.GetRSAKeyModulusLengthOutput)
		var _7_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _7_valueOrError4
		_7_valueOrError4 = m_Wrappers.Companion_Default___.Need(((_6_lengthOutput).Dtor_length()) >= (m_AwsKmsRsaKeyring.Companion_Default___.MIN__KMS__RSA__KEY__LEN()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid public key length")))
		if (_7_valueOrError4).IsFailure() {
			output = (_7_valueOrError4).PropagateFailure()
			return output
		}
	}
	var _8_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
	_ = _8_valueOrError5
	_8_valueOrError5 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId((input).Dtor_kmsKeyId())
	if (_8_valueOrError5).IsFailure() {
		output = (_8_valueOrError5).PropagateFailure()
		return output
	}
	var _9___v13 _dafny.Tuple
	_ = _9___v13
	_9___v13 = (_8_valueOrError5).Extract().(_dafny.Tuple)
	var _10_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _10_valueOrError6
	_10_valueOrError6 = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((input).Dtor_grantTokens())
	if (_10_valueOrError6).IsFailure() {
		output = (_10_valueOrError6).PropagateFailure()
		return output
	}
	var _11_grantTokens _dafny.Sequence
	_ = _11_grantTokens
	_11_grantTokens = (_10_valueOrError6).Extract().(_dafny.Sequence)
	var _12_keyring *m_AwsKmsRsaKeyring.AwsKmsRsaKeyring
	_ = _12_keyring
	var _nw0 *m_AwsKmsRsaKeyring.AwsKmsRsaKeyring = m_AwsKmsRsaKeyring.New_AwsKmsRsaKeyring_()
	_ = _nw0
	_nw0.Ctor__((input).Dtor_publicKey(), (input).Dtor_kmsKeyId(), (input).Dtor_encryptionAlgorithm(), (input).Dtor_kmsClient(), (config).Dtor_crypto(), _11_grantTokens)
	_12_keyring = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_12_keyring)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateDefaultCryptographicMaterialsManager(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateDefaultCryptographicMaterialsManagerInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_cmm *m_DefaultCMM.DefaultCMM
	_ = _0_cmm
	var _nw0 *m_DefaultCMM.DefaultCMM = m_DefaultCMM.New_DefaultCMM_()
	_ = _nw0
	_nw0.OfKeyring((input).Dtor_keyring(), (config).Dtor_crypto())
	_0_cmm = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_0_cmm)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CmpError(s _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(s)
}
func (_static *CompanionStruct_Default___) CreateRequiredEncryptionContextCMM(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateRequiredEncryptionContextCMMInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_underlyingCMM()).Is_Some()) && (((input).Dtor_keyring()).Is_None()), Companion_Default___.CmpError(_dafny.SeqOfString("CreateRequiredEncryptionContextCMM currently only supports cmm.")))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_keySet _dafny.Set
	_ = _1_keySet
	_1_keySet = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter10 := _dafny.Iterate(((input).Dtor_requiredEncryptionContextKeys()).Elements()); ; {
			_compr_0, _ok10 := _iter10()
			if !_ok10 {
				break
			}
			var _2_k _dafny.Sequence
			_2_k = interface{}(_compr_0).(_dafny.Sequence)
			if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_2_k) {
				if _dafny.Companion_Sequence_.Contains((input).Dtor_requiredEncryptionContextKeys(), _2_k) {
					_coll0.Add(_2_k)
				}
			}
		}
		return _coll0.ToSet()
	}()
	var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError1
	_3_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_1_keySet).Cardinality()).Sign() == 1, Companion_Default___.CmpError(_dafny.SeqOfString("RequiredEncryptionContextCMM needs at least one requiredEncryptionContextKey.")))
	if (_3_valueOrError1).IsFailure() {
		output = (_3_valueOrError1).PropagateFailure()
		return output
	}
	var _4_cmm *m_RequiredEncryptionContextCMM.RequiredEncryptionContextCMM
	_ = _4_cmm
	var _nw0 *m_RequiredEncryptionContextCMM.RequiredEncryptionContextCMM = m_RequiredEncryptionContextCMM.New_RequiredEncryptionContextCMM_()
	_ = _nw0
	_nw0.Ctor__(m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsManager_.CastTo_(((input).Dtor_underlyingCMM()).Dtor_value()), _1_keySet)
	_4_cmm = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_4_cmm)
	return output
	return output
}
func (_static *CompanionStruct_Default___) CreateCryptographicMaterialsCache(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateCryptographicMaterialsCacheInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _source0 m_AwsCryptographyMaterialProvidersTypes.CacheType = (input).Dtor_cache()
	_ = _source0
	{
		{
			if _source0.Is_Default() {
				var _0_c m_AwsCryptographyMaterialProvidersTypes.DefaultCache = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.CacheType_Default).Default
				_ = _0_c
				var _1_cache m_AwsCryptographyMaterialProvidersTypes.StormTrackingCache
				_ = _1_cache
				var _2_dt__update__tmp_h0 m_AwsCryptographyMaterialProvidersTypes.StormTrackingCache = m_StormTracker.Companion_Default___.DefaultStorm()
				_ = _2_dt__update__tmp_h0
				var _3_dt__update_hentryCapacity_h0 int32 = (_0_c).Dtor_entryCapacity()
				_ = _3_dt__update_hentryCapacity_h0
				_1_cache = m_AwsCryptographyMaterialProvidersTypes.Companion_StormTrackingCache_.Create_StormTrackingCache_(_3_dt__update_hentryCapacity_h0, (_2_dt__update__tmp_h0).Dtor_entryPruningTailSize(), (_2_dt__update__tmp_h0).Dtor_gracePeriod(), (_2_dt__update__tmp_h0).Dtor_graceInterval(), (_2_dt__update__tmp_h0).Dtor_fanOut(), (_2_dt__update__tmp_h0).Dtor_inFlightTTL(), (_2_dt__update__tmp_h0).Dtor_sleepMilli(), (_2_dt__update__tmp_h0).Dtor_timeUnits())
				var _4_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _4_valueOrError0
				_4_valueOrError0 = m_StormTracker.Companion_Default___.CheckSettings(_1_cache)
				if (_4_valueOrError0).IsFailure() {
					output = (_4_valueOrError0).PropagateFailure()
					return output
				}
				var _5_cmc *m_StormTracker.StormTracker
				_ = _5_cmc
				var _nw0 *m_StormTracker.StormTracker = m_StormTracker.New_StormTracker_()
				_ = _nw0
				_nw0.Ctor__(_1_cache)
				_5_cmc = _nw0
				var _6_synCmc *m_StormTrackingCMC.StormTrackingCMC
				_ = _6_synCmc
				var _nw1 *m_StormTrackingCMC.StormTrackingCMC = m_StormTrackingCMC.New_StormTrackingCMC_(_5_cmc)
				_ = _nw1
				_6_synCmc = _nw1
				output = m_Wrappers.Companion_Result_.Create_Success_(_6_synCmc)
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_No() {
				var _7_cmc *m_LocalCMC.LocalCMC
				_ = _7_cmc
				var _nw2 *m_LocalCMC.LocalCMC = m_LocalCMC.New_LocalCMC_()
				_ = _nw2
				_nw2.Ctor__(_dafny.Zero, _dafny.One)
				_7_cmc = _nw2
				output = m_Wrappers.Companion_Result_.Create_Success_(_7_cmc)
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_SingleThreaded() {
				var _8_c m_AwsCryptographyMaterialProvidersTypes.SingleThreadedCache = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.CacheType_SingleThreaded).SingleThreaded
				_ = _8_c
				var _9_cmc *m_LocalCMC.LocalCMC
				_ = _9_cmc
				var _nw3 *m_LocalCMC.LocalCMC = m_LocalCMC.New_LocalCMC_()
				_ = _nw3
				_nw3.Ctor__(_dafny.IntOfInt32((_8_c).Dtor_entryCapacity()), _dafny.IntOfInt32((Companion_Default___.OptionalCountingNumber((_8_c).Dtor_entryPruningTailSize())).UnwrapOr(int32(1)).(int32)))
				_9_cmc = _nw3
				output = m_Wrappers.Companion_Result_.Create_Success_(_9_cmc)
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_MultiThreaded() {
				var _10_c m_AwsCryptographyMaterialProvidersTypes.MultiThreadedCache = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.CacheType_MultiThreaded).MultiThreaded
				_ = _10_c
				var _11_cmc *m_LocalCMC.LocalCMC
				_ = _11_cmc
				var _nw4 *m_LocalCMC.LocalCMC = m_LocalCMC.New_LocalCMC_()
				_ = _nw4
				_nw4.Ctor__(_dafny.IntOfInt32((_10_c).Dtor_entryCapacity()), _dafny.IntOfInt32((Companion_Default___.OptionalCountingNumber((_10_c).Dtor_entryPruningTailSize())).UnwrapOr(int32(1)).(int32)))
				_11_cmc = _nw4
				var _12_synCmc *m_SynchronizedLocalCMC.SynchronizedLocalCMC
				_ = _12_synCmc
				var _nw5 *m_SynchronizedLocalCMC.SynchronizedLocalCMC = m_SynchronizedLocalCMC.New_SynchronizedLocalCMC_(_11_cmc)
				_ = _nw5
				_12_synCmc = _nw5
				output = m_Wrappers.Companion_Result_.Create_Success_(_12_synCmc)
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_StormTracking() {
				var _13_c m_AwsCryptographyMaterialProvidersTypes.StormTrackingCache = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.CacheType_StormTracking).StormTracking
				_ = _13_c
				var _14_cache m_AwsCryptographyMaterialProvidersTypes.StormTrackingCache
				_ = _14_cache
				var _15_dt__update__tmp_h1 m_AwsCryptographyMaterialProvidersTypes.StormTrackingCache = _13_c
				_ = _15_dt__update__tmp_h1
				var _16_dt__update_hentryPruningTailSize_h0 m_Wrappers.Option = Companion_Default___.OptionalCountingNumber((_13_c).Dtor_entryPruningTailSize())
				_ = _16_dt__update_hentryPruningTailSize_h0
				_14_cache = m_AwsCryptographyMaterialProvidersTypes.Companion_StormTrackingCache_.Create_StormTrackingCache_((_15_dt__update__tmp_h1).Dtor_entryCapacity(), _16_dt__update_hentryPruningTailSize_h0, (_15_dt__update__tmp_h1).Dtor_gracePeriod(), (_15_dt__update__tmp_h1).Dtor_graceInterval(), (_15_dt__update__tmp_h1).Dtor_fanOut(), (_15_dt__update__tmp_h1).Dtor_inFlightTTL(), (_15_dt__update__tmp_h1).Dtor_sleepMilli(), (_15_dt__update__tmp_h1).Dtor_timeUnits())
				var _17_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _17_valueOrError1
				_17_valueOrError1 = m_StormTracker.Companion_Default___.CheckSettings(_14_cache)
				if (_17_valueOrError1).IsFailure() {
					output = (_17_valueOrError1).PropagateFailure()
					return output
				}
				var _18_cmc *m_StormTracker.StormTracker
				_ = _18_cmc
				var _nw6 *m_StormTracker.StormTracker = m_StormTracker.New_StormTracker_()
				_ = _nw6
				_nw6.Ctor__(_14_cache)
				_18_cmc = _nw6
				var _19_synCmc *m_StormTrackingCMC.StormTrackingCMC
				_ = _19_synCmc
				var _nw7 *m_StormTrackingCMC.StormTrackingCMC = m_StormTrackingCMC.New_StormTrackingCMC_(_18_cmc)
				_ = _nw7
				_19_synCmc = _nw7
				output = m_Wrappers.Companion_Result_.Create_Success_(_19_synCmc)
				return output
				goto Lmatch0
			}
		}
		{
			var _20_c m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.CacheType_Shared).Shared
			_ = _20_c
			var _21_exception m_AwsCryptographyMaterialProvidersTypes.Error
			_ = _21_exception
			_21_exception = m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("CreateCryptographicMaterialsCache should never be called with Shared CacheType."))
			output = m_Wrappers.Companion_Result_.Create_Failure_(_21_exception)
			return output
		}
		goto Lmatch0
	}
Lmatch0:
	return output
}
func (_static *CompanionStruct_Default___) OptionalCountingNumber(c m_Wrappers.Option) m_Wrappers.Option {
	if ((c).Is_Some()) && (((c).Dtor_value().(int32)) <= (int32(0))) {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		return c
	}
}
func (_static *CompanionStruct_Default___) CreateDefaultClientSupplier(config Config, input m_AwsCryptographyMaterialProvidersTypes.CreateDefaultClientSupplierInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_clientSupplier *m_DefaultClientSupplier.DefaultClientSupplier
	_ = _0_clientSupplier
	var _nw0 *m_DefaultClientSupplier.DefaultClientSupplier = m_DefaultClientSupplier.New_DefaultClientSupplier_()
	_ = _nw0
	_nw0.Ctor__()
	_0_clientSupplier = _nw0
	output = m_Wrappers.Companion_Result_.Create_Success_(_0_clientSupplier)
	return output
	return output
}
func (_static *CompanionStruct_Default___) InitializeEncryptionMaterials(config Config, input m_AwsCryptographyMaterialProvidersTypes.InitializeEncryptionMaterialsInput) m_Wrappers.Result {
	return m_Materials.Companion_Default___.InitializeEncryptionMaterials(input)
}
func (_static *CompanionStruct_Default___) InitializeDecryptionMaterials(config Config, input m_AwsCryptographyMaterialProvidersTypes.InitializeDecryptionMaterialsInput) m_Wrappers.Result {
	return m_Materials.Companion_Default___.InitializeDecryptionMaterials(input)
}
func (_static *CompanionStruct_Default___) ValidEncryptionMaterialsTransition(config Config, input m_AwsCryptographyMaterialProvidersTypes.ValidEncryptionMaterialsTransitionInput) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.ValidEncryptionMaterialsTransition((input).Dtor_start(), (input).Dtor_stop()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Invalid Encryption Materials Transition")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
}
func (_static *CompanionStruct_Default___) ValidDecryptionMaterialsTransition(config Config, input m_AwsCryptographyMaterialProvidersTypes.ValidDecryptionMaterialsTransitionInput) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsTransitionIsValid((input).Dtor_start(), (input).Dtor_stop()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidDecryptionMaterialsTransition_(_dafny.SeqOfString("Invalid Decryption Materials Transition")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
}
func (_static *CompanionStruct_Default___) EncryptionMaterialsHasPlaintextDataKey(config Config, input m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.EncryptionMaterialsHasPlaintextDataKey(input), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidDecryptionMaterials_(_dafny.SeqOfString("Invalid Encryption Materials")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
}
func (_static *CompanionStruct_Default___) DecryptionMaterialsWithPlaintextDataKey(config Config, input m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithPlaintextDataKey(input), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidDecryptionMaterials_(_dafny.SeqOfString("Invalid Decryption Materials")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
}
func (_static *CompanionStruct_Default___) GetAlgorithmSuiteInfo(config Config, input _dafny.Sequence) m_Wrappers.Result {
	return m_AlgorithmSuites.Companion_Default___.GetAlgorithmSuiteInfo(input)
}
func (_static *CompanionStruct_Default___) ValidAlgorithmSuiteInfo(config Config, input m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_AlgorithmSuites.Companion_Default___.AlgorithmSuite_q(input), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidAlgorithmSuiteInfo_(_dafny.SeqOfString("Invalid AlgorithmSuiteInfo")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
}
func (_static *CompanionStruct_Default___) ValidateCommitmentPolicyOnEncrypt(config Config, input m_AwsCryptographyMaterialProvidersTypes.ValidateCommitmentPolicyOnEncryptInput) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Commitment.Companion_Default___.ValidateCommitmentPolicyOnEncrypt((input).Dtor_algorithm(), (input).Dtor_commitmentPolicy())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
}
func (_static *CompanionStruct_Default___) ValidateCommitmentPolicyOnDecrypt(config Config, input m_AwsCryptographyMaterialProvidersTypes.ValidateCommitmentPolicyOnDecryptInput) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Commitment.Companion_Default___.ValidateCommitmentPolicyOnDecrypt((input).Dtor_algorithm(), (input).Dtor_commitmentPolicy())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
	}
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
	Crypto *m_AtomicPrimitives.AtomicPrimitivesClient
}

func (Config_Config) isConfig() {}

func (CompanionStruct_Config_) Create_Config_(Crypto *m_AtomicPrimitives.AtomicPrimitivesClient) Config {
	return Config{Config_Config{Crypto}}
}

func (_this Config) Is_Config() bool {
	_, ok := _this.Get_().(Config_Config)
	return ok
}

func (CompanionStruct_Config_) Default() Config {
	return Companion_Config_.Create_Config_((*m_AtomicPrimitives.AtomicPrimitivesClient)(nil))
}

func (_this Config) Dtor_crypto() *m_AtomicPrimitives.AtomicPrimitivesClient {
	return _this.Get_().(Config_Config).Crypto
}

func (_this Config) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Config_Config:
		{
			return "AwsCryptographyMaterialProvidersOperations.Config.Config" + "(" + _dafny.String(data.Crypto) + ")"
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
			return ok && data1.Crypto == data2.Crypto
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
	return "AwsCryptographyMaterialProvidersOperations.Config"
}
func (_this Config) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Config{}

// End of datatype Config
