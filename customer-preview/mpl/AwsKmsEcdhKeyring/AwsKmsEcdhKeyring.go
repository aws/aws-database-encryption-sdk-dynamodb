// Package AwsKmsEcdhKeyring
// Dafny module AwsKmsEcdhKeyring compiled into Go

package AwsKmsEcdhKeyring

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
	m_AwsKmsHierarchicalKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsHierarchicalKeyring"
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkDiscoveryKeyring"
	m_AwsKmsMrkKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkKeyring"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsRsaKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsRsaKeyring"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CacheConstants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CacheConstants"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
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
	m_RawECDHKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawECDHKeyring"
	m_StormTracker "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	m_StormTrackingCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTrackingCMC"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
	m_SynchronizedLocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/SynchronizedLocalCMC"
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
	return "AwsKmsEcdhKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DeriveSharedSecret(client m_ComAmazonawsKmsTypes.IKMSClient, senderAwsKmsKey _dafny.Sequence, recipientPublicKey _dafny.Sequence, grantTokens _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_deriveSharedSecretRequest m_ComAmazonawsKmsTypes.DeriveSharedSecretRequest
	_ = _0_deriveSharedSecretRequest
	_0_deriveSharedSecretRequest = m_ComAmazonawsKmsTypes.Companion_DeriveSharedSecretRequest_.Create_DeriveSharedSecretRequest_(senderAwsKmsKey, m_ComAmazonawsKmsTypes.Companion_KeyAgreementAlgorithmSpec_.Create_ECDH_(), recipientPublicKey, m_Wrappers.Companion_Option_.Create_Some_(grantTokens), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _1_maybeDeriveSharedSecret m_Wrappers.Result
	_ = _1_maybeDeriveSharedSecret
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (client).DeriveSharedSecret(_0_deriveSharedSecretRequest)
	_1_maybeDeriveSharedSecret = _out0
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_DeriveSharedSecretResponse_.Default())
	_ = _2_valueOrError0
	_2_valueOrError0 = (_1_maybeDeriveSharedSecret).MapFailure(func(coer117 func(m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg118 interface{}) interface{} {
			return coer117(arg118.(m_ComAmazonawsKmsTypes.Error))
		}
	}(func(_3_e m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_ComAmazonawsKms_(_3_e)
	}))
	if (_2_valueOrError0).IsFailure() {
		res = (_2_valueOrError0).PropagateFailure()
		return res
	}
	var _4_deriveSharedSecretResponse m_ComAmazonawsKmsTypes.DeriveSharedSecretResponse
	_ = _4_deriveSharedSecretResponse
	_4_deriveSharedSecretResponse = (_2_valueOrError0).Extract().(m_ComAmazonawsKmsTypes.DeriveSharedSecretResponse)
	var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _5_valueOrError1
	_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((((((_4_deriveSharedSecretResponse).Dtor_KeyId()).Is_Some()) && (((_4_deriveSharedSecretResponse).Dtor_SharedSecret()).Is_Some())) && (((_4_deriveSharedSecretResponse).Dtor_KeyAgreementAlgorithm()).Is_Some())) && (_dafny.Companion_Sequence_.Equal(((_4_deriveSharedSecretResponse).Dtor_KeyId()).Dtor_value().(_dafny.Sequence), senderAwsKmsKey))) && ((((_4_deriveSharedSecretResponse).Dtor_KeyAgreementAlgorithm()).Dtor_value().(m_ComAmazonawsKmsTypes.KeyAgreementAlgorithmSpec)).Equals(m_ComAmazonawsKmsTypes.Companion_KeyAgreementAlgorithmSpec_.Create_ECDH_())), Companion_Default___.E(_dafny.SeqOfString("Invalid response from KMS DeriveSharedSecret")))
	if (_5_valueOrError1).IsFailure() {
		res = (_5_valueOrError1).PropagateFailure()
		return res
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(((_4_deriveSharedSecretResponse).Dtor_SharedSecret()).Dtor_value().(_dafny.Sequence))
	return res
	return res
}
func (_static *CompanionStruct_Default___) E(s _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(s)
}
func (_static *CompanionStruct_Default___) AWS__KMS__ECDH__KEYRING__VERSION() _dafny.Sequence {
	return m_RawECDHKeyring.Companion_Default___.RAW__ECDH__KEYRING__VERSION()
}

// End of class Default__

// Definition of class AwsKmsEcdhKeyring
type AwsKmsEcdhKeyring struct {
	_client                       m_ComAmazonawsKmsTypes.IKMSClient
	_cryptoPrimitives             *m_AtomicPrimitives.AtomicPrimitivesClient
	_keyAgreementScheme           m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations
	_curveSpec                    m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec
	_grantTokens                  _dafny.Sequence
	_recipientPublicKey           _dafny.Sequence
	_senderPublicKey              m_Wrappers.Option
	_compressedSenderPublicKey    m_Wrappers.Option
	_compressedRecipientPublicKey _dafny.Sequence
	_senderKmsKeyId               m_Wrappers.Option
}

func New_AwsKmsEcdhKeyring_() *AwsKmsEcdhKeyring {
	_this := AwsKmsEcdhKeyring{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._keyAgreementScheme = m_AwsCryptographyMaterialProvidersTypes.Companion_KmsEcdhStaticConfigurations_.Default()
	_this._curveSpec = m_AwsCryptographyPrimitivesTypes.Companion_ECDHCurveSpec_.Default()
	_this._grantTokens = _dafny.EmptySeq
	_this._recipientPublicKey = _dafny.EmptySeq
	_this._senderPublicKey = m_Wrappers.Companion_Option_.Default()
	_this._compressedSenderPublicKey = m_Wrappers.Companion_Option_.Default()
	_this._compressedRecipientPublicKey = _dafny.EmptySeq
	_this._senderKmsKeyId = m_Wrappers.Companion_Option_.Default()
	return &_this
}

type CompanionStruct_AwsKmsEcdhKeyring_ struct {
}

var Companion_AwsKmsEcdhKeyring_ = CompanionStruct_AwsKmsEcdhKeyring_{}

func (_this *AwsKmsEcdhKeyring) Equals(other *AwsKmsEcdhKeyring) bool {
	return _this == other
}

func (_this *AwsKmsEcdhKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsEcdhKeyring)
	return ok && _this.Equals(other)
}

func (*AwsKmsEcdhKeyring) String() string {
	return "AwsKmsEcdhKeyring.AwsKmsEcdhKeyring"
}

func Type_AwsKmsEcdhKeyring_() _dafny.TypeDescriptor {
	return type_AwsKmsEcdhKeyring_{}
}

type type_AwsKmsEcdhKeyring_ struct {
}

func (_this type_AwsKmsEcdhKeyring_) Default() interface{} {
	return (*AwsKmsEcdhKeyring)(nil)
}

func (_this type_AwsKmsEcdhKeyring_) String() string {
	return "AwsKmsEcdhKeyring.AwsKmsEcdhKeyring"
}
func (_this *AwsKmsEcdhKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &AwsKmsEcdhKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &AwsKmsEcdhKeyring{}
var _ _dafny.TraitOffspring = &AwsKmsEcdhKeyring{}

func (_this *AwsKmsEcdhKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out9
}
func (_this *AwsKmsEcdhKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out9 m_Wrappers.Result
	_ = _out9
	_out9 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out9
}
func (_this *AwsKmsEcdhKeyring) Ctor__(KeyAgreementScheme m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, client m_ComAmazonawsKmsTypes.IKMSClient, grantTokens _dafny.Sequence, senderKmsKeyId m_Wrappers.Option, senderPublicKey m_Wrappers.Option, recipientPublicKey _dafny.Sequence, compressedSenderPublicKey m_Wrappers.Option, compressedRecipientPublicKey _dafny.Sequence, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._keyAgreementScheme = KeyAgreementScheme
		(_this)._curveSpec = curveSpec
		(_this)._client = client
		(_this)._grantTokens = grantTokens
		(_this)._recipientPublicKey = recipientPublicKey
		(_this)._senderPublicKey = senderPublicKey
		(_this)._compressedSenderPublicKey = compressedSenderPublicKey
		(_this)._compressedRecipientPublicKey = compressedRecipientPublicKey
		(_this)._senderKmsKeyId = senderKmsKeyId
		(_this)._cryptoPrimitives = cryptoPrimitives
	}
}
func (_this *AwsKmsEcdhKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(!(((_this).KeyAgreementScheme()).Is_KmsPublicKeyDiscovery()), Companion_Default___.E(_dafny.SeqOfString("KmsPublicKeyDiscovery Key Agreement Scheme is forbidden on encrypt.")))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _1_valueOrError1
		_1_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_this).SenderKmsKeyId()).Is_Some(), Companion_Default___.E(_dafny.SeqOfString("Keyring MUST be configured with a sender KMS Key ID")))
		if (_1_valueOrError1).IsFailure() {
			res = (_1_valueOrError1).PropagateFailure()
			return res
		}
		var _2_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError2
		_2_valueOrError2 = m_Wrappers.Companion_Default___.Need(((_this).SenderPublicKey()).Is_Some(), Companion_Default___.E(_dafny.SeqOfString("Keyring MUST be configured with a senderPublicKey")))
		if (_2_valueOrError2).IsFailure() {
			res = (_2_valueOrError2).PropagateFailure()
			return res
		}
		var _3_senderKmsKeyId _dafny.Sequence
		_ = _3_senderKmsKeyId
		_3_senderKmsKeyId = ((_this).SenderKmsKeyId()).Dtor_value().(_dafny.Sequence)
		var _4_materials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
		_ = _4_materials
		_4_materials = (input).Dtor_materials()
		var _5_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _5_suite
		_5_suite = ((input).Dtor_materials()).Dtor_algorithmSuite()
		var _6_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _6_valueOrError3
		_6_valueOrError3 = m_AwsKmsUtils.Companion_Default___.StringifyEncryptionContext(((input).Dtor_materials()).Dtor_encryptionContext())
		if (_6_valueOrError3).IsFailure() {
			res = (_6_valueOrError3).PropagateFailure()
			return res
		}
		var _7_stringifiedEncCtx _dafny.Map
		_ = _7_stringifiedEncCtx
		_7_stringifiedEncCtx = (_6_valueOrError3).Extract().(_dafny.Map)
		var _8_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _8_valueOrError4
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.DeriveSharedSecret((_this).Client(), _3_senderKmsKeyId, (_this).RecipientPublicKey(), (_this).GrantTokens())
		_8_valueOrError4 = _out0
		if (_8_valueOrError4).IsFailure() {
			res = (_8_valueOrError4).PropagateFailure()
			return res
		}
		var _9_sharedSecret _dafny.Sequence
		_ = _9_sharedSecret
		_9_sharedSecret = (_8_valueOrError4).Extract().(_dafny.Sequence)
		var _10_operationCompressedSenderPublicKey _dafny.Sequence
		_ = _10_operationCompressedSenderPublicKey
		if ((_this).CompressedSenderPublicKey()).Is_None() {
			_10_operationCompressedSenderPublicKey = _dafny.SeqOf()
		} else {
			_10_operationCompressedSenderPublicKey = ((_this).CompressedSenderPublicKey()).Dtor_value().(_dafny.Sequence)
		}
		var _11_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _11_valueOrError5
		_11_valueOrError5 = (m_UTF8.Encode(m_RawECDHKeyring.Companion_Default___.CurveSpecTypeToString((_this).CurveSpec()))).MapFailure(func(coer118 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg119 interface{}) interface{} {
				return coer118(arg119.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_11_valueOrError5).IsFailure() {
			res = (_11_valueOrError5).PropagateFailure()
			return res
		}
		var _12_curveSpecUtf8 _dafny.Sequence
		_ = _12_curveSpecUtf8
		_12_curveSpecUtf8 = (_11_valueOrError5).Extract().(_dafny.Sequence)
		var _13_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _13_valueOrError6
		_13_valueOrError6 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD(((input).Dtor_materials()).Dtor_encryptionContext())
		if (_13_valueOrError6).IsFailure() {
			res = (_13_valueOrError6).PropagateFailure()
			return res
		}
		var _14_canonicalizedEC _dafny.Sequence
		_ = _14_canonicalizedEC
		_14_canonicalizedEC = (_13_valueOrError6).Extract().(_dafny.Sequence)
		var _15_fixedInfo _dafny.Sequence
		_ = _15_fixedInfo
		_15_fixedInfo = m_EcdhEdkWrapping.Companion_Default___.SerializeFixedInfo(m_Constants.Companion_Default___.ECDH__KDF__UTF8(), _12_curveSpecUtf8, _10_operationCompressedSenderPublicKey, (_this).CompressedRecipientPublicKey(), _14_canonicalizedEC, Companion_Default___.AWS__KMS__ECDH__KEYRING__VERSION())
		var _16_ecdhGenerateAndWrap *m_EcdhEdkWrapping.EcdhGenerateAndWrapKeyMaterial
		_ = _16_ecdhGenerateAndWrap
		var _nw0 *m_EcdhEdkWrapping.EcdhGenerateAndWrapKeyMaterial = m_EcdhEdkWrapping.New_EcdhGenerateAndWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__(_9_sharedSecret, _15_fixedInfo, (_this).CryptoPrimitives())
		_16_ecdhGenerateAndWrap = _nw0
		var _17_ecdhWrap *m_EcdhEdkWrapping.EcdhWrapKeyMaterial
		_ = _17_ecdhWrap
		var _nw1 *m_EcdhEdkWrapping.EcdhWrapKeyMaterial = m_EcdhEdkWrapping.New_EcdhWrapKeyMaterial_()
		_ = _nw1
		_nw1.Ctor__(_9_sharedSecret, _15_fixedInfo, (_this).CryptoPrimitives())
		_17_ecdhWrap = _nw1
		var _18_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_WrapEdkMaterialOutput_.Default(m_EcdhEdkWrapping.Companion_EcdhWrapInfo_.Default()))
		_ = _18_valueOrError7
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_EdkWrapping.Companion_Default___.WrapEdkMaterial(_4_materials, _17_ecdhWrap, _16_ecdhGenerateAndWrap)
		_18_valueOrError7 = _out1
		if (_18_valueOrError7).IsFailure() {
			res = (_18_valueOrError7).PropagateFailure()
			return res
		}
		var _19_wrapOutput m_EdkWrapping.WrapEdkMaterialOutput
		_ = _19_wrapOutput
		_19_wrapOutput = (_18_valueOrError7).Extract().(m_EdkWrapping.WrapEdkMaterialOutput)
		var _20_symmetricSigningKeyList m_Wrappers.Option
		_ = _20_symmetricSigningKeyList
		if ((_19_wrapOutput).Dtor_symmetricSigningKey()).Is_Some() {
			_20_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(((_19_wrapOutput).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence)))
		} else {
			_20_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _21_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _21_valueOrError8
		_21_valueOrError8 = m_Wrappers.Companion_Default___.Need((m_RawECDHKeyring.Companion_Default___.ValidCompressedPublicKeyLength(_10_operationCompressedSenderPublicKey)) && (m_RawECDHKeyring.Companion_Default___.ValidCompressedPublicKeyLength((_this).CompressedRecipientPublicKey())), Companion_Default___.E(_dafny.SeqOfString("Invalid compressed public key length.")))
		if (_21_valueOrError8).IsFailure() {
			res = (_21_valueOrError8).PropagateFailure()
			return res
		}
		var _22_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
		_ = _22_edk
		_22_edk = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(m_Constants.Companion_Default___.KMS__ECDH__PROVIDER__ID(), m_RawECDHKeyring.Companion_Default___.SerializeProviderInfo(_10_operationCompressedSenderPublicKey, (_this).CompressedRecipientPublicKey()), (_19_wrapOutput).Dtor_wrappedMaterial())
		if (_19_wrapOutput).Is_GenerateAndWrapEdkMaterialOutput() {
			var _23_valueOrError9 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _23_valueOrError9
			_23_valueOrError9 = m_Materials.Companion_Default___.EncryptionMaterialAddDataKey(_4_materials, (_19_wrapOutput).Dtor_plaintextDataKey(), _dafny.SeqOf(_22_edk), _20_symmetricSigningKeyList)
			if (_23_valueOrError9).IsFailure() {
				res = (_23_valueOrError9).PropagateFailure()
				return res
			}
			var _24_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _24_result
			_24_result = (_23_valueOrError9).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_24_result))
			return res
		} else if (_19_wrapOutput).Is_WrapOnlyEdkMaterialOutput() {
			var _25_valueOrError10 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _25_valueOrError10
			_25_valueOrError10 = m_Materials.Companion_Default___.EncryptionMaterialAddEncryptedDataKeys(_4_materials, _dafny.SeqOf(_22_edk), _20_symmetricSigningKeyList)
			if (_25_valueOrError10).IsFailure() {
				res = (_25_valueOrError10).PropagateFailure()
				return res
			}
			var _26_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _26_result
			_26_result = (_25_valueOrError10).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_26_result))
			return res
		}
		return res
	}
}
func (_this *AwsKmsEcdhKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _1_suite
		_1_suite = ((input).Dtor_materials()).Dtor_algorithmSuite()
		var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError0
		_2_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_0_materials), Companion_Default___.E(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_filter *OnDecryptEcdhDataKeyFilter
		_ = _3_filter
		var _nw0 *OnDecryptEcdhDataKeyFilter = New_OnDecryptEcdhDataKeyFilter_()
		_ = _nw0
		_nw0.Ctor__((_this).KeyAgreementScheme(), (_this).CompressedRecipientPublicKey(), (_this).CompressedSenderPublicKey())
		_3_filter = _nw0
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_Actions.Companion_Default___.FilterWithResult(_3_filter, (input).Dtor_encryptedDataKeys())
		_4_valueOrError1 = _out0
		if (_4_valueOrError1).IsFailure() {
			res = (_4_valueOrError1).PropagateFailure()
			return res
		}
		var _5_edksToAttempt _dafny.Sequence
		_ = _5_edksToAttempt
		_5_edksToAttempt = (_4_valueOrError1).Extract().(_dafny.Sequence)
		if (_dafny.IntOfUint32((_5_edksToAttempt).Cardinality())).Sign() == 0 {
			var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _6_valueOrError2
			_6_valueOrError2 = m_ErrorMessages.Companion_Default___.IncorrectDataKeys((input).Dtor_encryptedDataKeys(), ((input).Dtor_materials()).Dtor_algorithmSuite(), _dafny.SeqOfString(""))
			if (_6_valueOrError2).IsFailure() {
				res = (_6_valueOrError2).PropagateFailure()
				return res
			}
			var _7_errorMessage _dafny.Sequence
			_ = _7_errorMessage
			_7_errorMessage = (_6_valueOrError2).Extract().(_dafny.Sequence)
			res = m_Wrappers.Companion_Result_.Create_Failure_(Companion_Default___.E(_7_errorMessage))
			return res
		}
		var _8_decryptClosure m_Actions.ActionWithResult
		_ = _8_decryptClosure
		var _nw1 *DecryptSingleEncryptedDataKey = New_DecryptSingleEncryptedDataKey_()
		_ = _nw1
		_nw1.Ctor__(_0_materials, (_this).CryptoPrimitives(), (_this).CompressedRecipientPublicKey(), (_this).Client(), (_this).GrantTokens(), (_this).KeyAgreementScheme(), (_this).CurveSpec())
		_8_decryptClosure = _nw1
		var _9_outcome m_Wrappers.Result
		_ = _9_outcome
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_Actions.Companion_Default___.ReduceToSuccess(_8_decryptClosure, _5_edksToAttempt)
		_9_outcome = _out1
		var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _10_valueOrError3
		_10_valueOrError3 = (_9_outcome).MapFailure(func(coer119 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg120 interface{}) interface{} {
				return coer119(arg120.(_dafny.Sequence))
			}
		}(func(_11_errors _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_11_errors, _dafny.SeqOfString("No Configured KMS Key was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`."))
		}))
		if (_10_valueOrError3).IsFailure() {
			res = (_10_valueOrError3).PropagateFailure()
			return res
		}
		var _12_SealedDecryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _12_SealedDecryptionMaterials
		_12_SealedDecryptionMaterials = (_10_valueOrError3).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_12_SealedDecryptionMaterials))
		return res
		return res
	}
}
func (_this *AwsKmsEcdhKeyring) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *AwsKmsEcdhKeyring) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *AwsKmsEcdhKeyring) KeyAgreementScheme() m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations {
	{
		return _this._keyAgreementScheme
	}
}
func (_this *AwsKmsEcdhKeyring) CurveSpec() m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec {
	{
		return _this._curveSpec
	}
}
func (_this *AwsKmsEcdhKeyring) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}
func (_this *AwsKmsEcdhKeyring) RecipientPublicKey() _dafny.Sequence {
	{
		return _this._recipientPublicKey
	}
}
func (_this *AwsKmsEcdhKeyring) SenderPublicKey() m_Wrappers.Option {
	{
		return _this._senderPublicKey
	}
}
func (_this *AwsKmsEcdhKeyring) CompressedSenderPublicKey() m_Wrappers.Option {
	{
		return _this._compressedSenderPublicKey
	}
}
func (_this *AwsKmsEcdhKeyring) CompressedRecipientPublicKey() _dafny.Sequence {
	{
		return _this._compressedRecipientPublicKey
	}
}
func (_this *AwsKmsEcdhKeyring) SenderKmsKeyId() m_Wrappers.Option {
	{
		return _this._senderKmsKeyId
	}
}

// End of class AwsKmsEcdhKeyring

// Definition of class DecryptSingleEncryptedDataKey
type DecryptSingleEncryptedDataKey struct {
	_materials          m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_cryptoPrimitives   *m_AtomicPrimitives.AtomicPrimitivesClient
	_recipientPublicKey _dafny.Sequence
	_keyAgreementScheme m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations
	_client             m_ComAmazonawsKmsTypes.IKMSClient
	_curveSpec          m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec
	_grantTokens        _dafny.Sequence
}

func New_DecryptSingleEncryptedDataKey_() *DecryptSingleEncryptedDataKey {
	_this := DecryptSingleEncryptedDataKey{}

	_this._materials = m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials{}
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._recipientPublicKey = _dafny.EmptySeq
	_this._keyAgreementScheme = m_AwsCryptographyMaterialProvidersTypes.Companion_KmsEcdhStaticConfigurations_.Default()
	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._curveSpec = m_AwsCryptographyPrimitivesTypes.Companion_ECDHCurveSpec_.Default()
	_this._grantTokens = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_DecryptSingleEncryptedDataKey_ struct {
}

var Companion_DecryptSingleEncryptedDataKey_ = CompanionStruct_DecryptSingleEncryptedDataKey_{}

func (_this *DecryptSingleEncryptedDataKey) Equals(other *DecryptSingleEncryptedDataKey) bool {
	return _this == other
}

func (_this *DecryptSingleEncryptedDataKey) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*DecryptSingleEncryptedDataKey)
	return ok && _this.Equals(other)
}

func (*DecryptSingleEncryptedDataKey) String() string {
	return "AwsKmsEcdhKeyring.DecryptSingleEncryptedDataKey"
}

func Type_DecryptSingleEncryptedDataKey_() _dafny.TypeDescriptor {
	return type_DecryptSingleEncryptedDataKey_{}
}

type type_DecryptSingleEncryptedDataKey_ struct {
}

func (_this type_DecryptSingleEncryptedDataKey_) Default() interface{} {
	return (*DecryptSingleEncryptedDataKey)(nil)
}

func (_this type_DecryptSingleEncryptedDataKey_) String() string {
	return "AwsKmsEcdhKeyring.DecryptSingleEncryptedDataKey"
}
func (_this *DecryptSingleEncryptedDataKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_Actions.ActionWithResult = &DecryptSingleEncryptedDataKey{}
var _ m_Actions.Action = &DecryptSingleEncryptedDataKey{}
var _ _dafny.TraitOffspring = &DecryptSingleEncryptedDataKey{}

func (_this *DecryptSingleEncryptedDataKey) Ctor__(materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient, recipientPublicKey _dafny.Sequence, client m_ComAmazonawsKmsTypes.IKMSClient, grantTokens _dafny.Sequence, keyAgreementScheme m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec) {
	{
		(_this)._materials = materials
		(_this)._cryptoPrimitives = cryptoPrimitives
		(_this)._recipientPublicKey = recipientPublicKey
		(_this)._keyAgreementScheme = keyAgreementScheme
		(_this)._client = client
		(_this)._curveSpec = curveSpec
		(_this)._grantTokens = grantTokens
	}
}
func (_this *DecryptSingleEncryptedDataKey) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.ValidUTF8Seq((edk).Dtor_keyProviderId()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Received invalid EDK provider id for AWS KMS ECDH Keyring")))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _1_suite
		_1_suite = ((_this).Materials()).Dtor_algorithmSuite()
		var _2_keyProviderId _dafny.Sequence
		_ = _2_keyProviderId
		_2_keyProviderId = (edk).Dtor_keyProviderId()
		var _3_providerInfo _dafny.Sequence
		_ = _3_providerInfo
		_3_providerInfo = (edk).Dtor_keyProviderInfo()
		var _4_ciphertext _dafny.Sequence
		_ = _4_ciphertext
		_4_ciphertext = (edk).Dtor_ciphertext()
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _5_valueOrError1
		_5_valueOrError1 = m_EdkWrapping.Companion_Default___.GetProviderWrappedMaterial(_4_ciphertext, _1_suite)
		if (_5_valueOrError1).IsFailure() {
			res = (_5_valueOrError1).PropagateFailure()
			return res
		}
		var _6_providerWrappedMaterial _dafny.Sequence
		_ = _6_providerWrappedMaterial
		_6_providerWrappedMaterial = (_5_valueOrError1).Extract().(_dafny.Sequence)
		var _7_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _7_valueOrError2
		_7_valueOrError2 = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfUint32((_3_providerInfo).Cardinality())).Cmp(_dafny.IntOfUint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__521__LEN())) <= 0) && (m_RawECDHKeyring.Companion_Default___.ValidProviderInfoLength(_3_providerInfo)), Companion_Default___.E(_dafny.SeqOfString("EDK ProviderInfo longer than expected")))
		if (_7_valueOrError2).IsFailure() {
			res = (_7_valueOrError2).PropagateFailure()
			return res
		}
		var _8_keyringVersion uint8
		_ = _8_keyringVersion
		_8_keyringVersion = (_3_providerInfo).Select(0).(uint8)
		var _9_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _9_valueOrError3
		_9_valueOrError3 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(_dafny.SeqOf(_8_keyringVersion), Companion_Default___.AWS__KMS__ECDH__KEYRING__VERSION()), Companion_Default___.E(_dafny.SeqOfString("Incorrect Keyring version found in provider info.")))
		if (_9_valueOrError3).IsFailure() {
			res = (_9_valueOrError3).PropagateFailure()
			return res
		}
		var _10_recipientPublicKeyLength _dafny.Int
		_ = _10_recipientPublicKeyLength
		_10_recipientPublicKeyLength = _dafny.IntOfUint32(m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((_3_providerInfo).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPL__INDEX()), uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX()))))
		var _11_recipientPublicKeyLengthIndex _dafny.Int
		_ = _11_recipientPublicKeyLengthIndex
		_11_recipientPublicKeyLengthIndex = (_dafny.IntOfUint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX())).Plus(_10_recipientPublicKeyLength)
		var _12_senderPublicKeyIndex _dafny.Int
		_ = _12_senderPublicKeyIndex
		_12_senderPublicKeyIndex = (_11_recipientPublicKeyLengthIndex).Plus(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__PUBLIC__KEY__LEN())
		var _13_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _13_valueOrError4
		_13_valueOrError4 = m_Wrappers.Companion_Default___.Need(((_11_recipientPublicKeyLengthIndex).Plus(_dafny.IntOfInt64(4))).Cmp(_dafny.IntOfUint32((_3_providerInfo).Cardinality())) < 0, Companion_Default___.E(_dafny.SeqOfString("Key Provider Info Serialization Error. Serialized length less than expected.")))
		if (_13_valueOrError4).IsFailure() {
			res = (_13_valueOrError4).PropagateFailure()
			return res
		}
		var _14_providerInfoRecipientPublicKey _dafny.Sequence
		_ = _14_providerInfoRecipientPublicKey
		_14_providerInfoRecipientPublicKey = (_3_providerInfo).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX()), (_11_recipientPublicKeyLengthIndex).Uint32())
		var _15_providerInfoSenderPublicKey _dafny.Sequence
		_ = _15_providerInfoSenderPublicKey
		_15_providerInfoSenderPublicKey = (_3_providerInfo).Drop((_12_senderPublicKeyIndex).Uint32())
		var _16_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _16_valueOrError5
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_RawECDHKeyring.Companion_Default___.DecompressPublicKey(_15_providerInfoSenderPublicKey, (_this).CurveSpec(), (_this).CryptoPrimitives())
		_16_valueOrError5 = _out0
		if (_16_valueOrError5).IsFailure() {
			res = (_16_valueOrError5).PropagateFailure()
			return res
		}
		var _17_senderPublicKey _dafny.Sequence
		_ = _17_senderPublicKey
		_17_senderPublicKey = (_16_valueOrError5).Extract().(_dafny.Sequence)
		var _18_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _18_valueOrError6
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_RawECDHKeyring.Companion_Default___.DecompressPublicKey(_14_providerInfoRecipientPublicKey, (_this).CurveSpec(), (_this).CryptoPrimitives())
		_18_valueOrError6 = _out1
		if (_18_valueOrError6).IsFailure() {
			res = (_18_valueOrError6).PropagateFailure()
			return res
		}
		var _19_recipientPublicKey _dafny.Sequence
		_ = _19_recipientPublicKey
		_19_recipientPublicKey = (_18_valueOrError6).Extract().(_dafny.Sequence)
		var _20_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _20_valueOrError7
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_RawECDHKeyring.Companion_Default___.ValidatePublicKey((_this).CryptoPrimitives(), (_this).CurveSpec(), _17_senderPublicKey)
		_20_valueOrError7 = _out2
		if (_20_valueOrError7).IsFailure() {
			res = (_20_valueOrError7).PropagateFailure()
			return res
		}
		var _21___v0 bool
		_ = _21___v0
		_21___v0 = (_20_valueOrError7).Extract().(bool)
		var _22_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _22_valueOrError8
		var _out3 m_Wrappers.Result
		_ = _out3
		_out3 = m_RawECDHKeyring.Companion_Default___.ValidatePublicKey((_this).CryptoPrimitives(), (_this).CurveSpec(), _19_recipientPublicKey)
		_22_valueOrError8 = _out3
		if (_22_valueOrError8).IsFailure() {
			res = (_22_valueOrError8).PropagateFailure()
			return res
		}
		var _23___v1 bool
		_ = _23___v1
		_23___v1 = (_22_valueOrError8).Extract().(bool)
		var _24_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _24_valueOrError9
		_24_valueOrError9 = m_Wrappers.Companion_Default___.Need((m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__PublicKeyType(_17_senderPublicKey)) && (m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__PublicKeyType((_this).RecipientPublicKey())), Companion_Default___.E(_dafny.SeqOfString("Received serialized sender public key of incorrect length")))
		if (_24_valueOrError9).IsFailure() {
			res = (_24_valueOrError9).PropagateFailure()
			return res
		}
		var _25_sharedSecretPublicKey _dafny.Sequence = _dafny.EmptySeq
		_ = _25_sharedSecretPublicKey
		var _26_sharedSecretKmsKeyId _dafny.Sequence = _dafny.EmptySeq.SetString()
		_ = _26_sharedSecretKmsKeyId
		var _source0 m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations = (_this).KeyAgreementScheme()
		_ = _source0
		{
			{
				if _source0.Is_KmsPublicKeyDiscovery() {
					var _27_kmsPublicKeyDiscovery m_AwsCryptographyMaterialProvidersTypes.KmsPublicKeyDiscoveryInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations_KmsPublicKeyDiscovery).KmsPublicKeyDiscovery
					_ = _27_kmsPublicKeyDiscovery
					{
						var _28_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
						_ = _28_valueOrError10
						_28_valueOrError10 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId((_27_kmsPublicKeyDiscovery).Dtor_recipientKmsIdentifier())
						if (_28_valueOrError10).IsFailure() {
							res = (_28_valueOrError10).PropagateFailure()
							return res
						}
						var _29___v2 _dafny.Tuple
						_ = _29___v2
						_29___v2 = (_28_valueOrError10).Extract().(_dafny.Tuple)
						_25_sharedSecretPublicKey = _17_senderPublicKey
						_26_sharedSecretKmsKeyId = (_27_kmsPublicKeyDiscovery).Dtor_recipientKmsIdentifier()
					}
					goto Lmatch0
				}
			}
			{
				var _30_kmsPrivateKeyToStaticPublicKey m_AwsCryptographyMaterialProvidersTypes.KmsPrivateKeyToStaticPublicKeyInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations_KmsPrivateKeyToStaticPublicKey).KmsPrivateKeyToStaticPublicKey
				_ = _30_kmsPrivateKeyToStaticPublicKey
				{
					var _31_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
					_ = _31_valueOrError11
					_31_valueOrError11 = m_AwsKmsUtils.Companion_Default___.ValidateKmsKeyId((_30_kmsPrivateKeyToStaticPublicKey).Dtor_senderKmsIdentifier())
					if (_31_valueOrError11).IsFailure() {
						res = (_31_valueOrError11).PropagateFailure()
						return res
					}
					var _32___v3 _dafny.Tuple
					_ = _32___v3
					_32___v3 = (_31_valueOrError11).Extract().(_dafny.Tuple)
					_26_sharedSecretKmsKeyId = (_30_kmsPrivateKeyToStaticPublicKey).Dtor_senderKmsIdentifier()
					if _dafny.Companion_Sequence_.Equal((_30_kmsPrivateKeyToStaticPublicKey).Dtor_recipientPublicKey(), _19_recipientPublicKey) {
						_25_sharedSecretPublicKey = _19_recipientPublicKey
					} else {
						_25_sharedSecretPublicKey = _17_senderPublicKey
					}
				}
			}
			goto Lmatch0
		}
	Lmatch0:
		var _33_valueOrError12 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _33_valueOrError12
		_33_valueOrError12 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__PublicKeyType(_25_sharedSecretPublicKey), Companion_Default___.E(_dafny.SeqOfString("Received Recipient Public Key of incorrect expected length")))
		if (_33_valueOrError12).IsFailure() {
			res = (_33_valueOrError12).PropagateFailure()
			return res
		}
		var _34_valueOrError13 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _34_valueOrError13
		var _out4 m_Wrappers.Result
		_ = _out4
		_out4 = Companion_Default___.DeriveSharedSecret((_this).Client(), _26_sharedSecretKmsKeyId, _25_sharedSecretPublicKey, (_this).GrantTokens())
		_34_valueOrError13 = _out4
		if (_34_valueOrError13).IsFailure() {
			res = (_34_valueOrError13).PropagateFailure()
			return res
		}
		var _35_sharedSecret _dafny.Sequence
		_ = _35_sharedSecret
		_35_sharedSecret = (_34_valueOrError13).Extract().(_dafny.Sequence)
		var _36_ecdhUnwrap *m_EcdhEdkWrapping.EcdhUnwrap
		_ = _36_ecdhUnwrap
		var _nw0 *m_EcdhEdkWrapping.EcdhUnwrap = m_EcdhEdkWrapping.New_EcdhUnwrap_()
		_ = _nw0
		_nw0.Ctor__(_15_providerInfoSenderPublicKey, _14_providerInfoRecipientPublicKey, _35_sharedSecret, Companion_Default___.AWS__KMS__ECDH__KEYRING__VERSION(), (_this).CurveSpec(), (_this).CryptoPrimitives())
		_36_ecdhUnwrap = _nw0
		var _37_unwrapOutputRes m_Wrappers.Result
		_ = _37_unwrapOutputRes
		var _out5 m_Wrappers.Result
		_ = _out5
		_out5 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial((edk).Dtor_ciphertext(), (_this).Materials(), _36_ecdhUnwrap)
		_37_unwrapOutputRes = _out5
		var _38_valueOrError14 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_UnwrapEdkMaterialOutput_.Default(m_EcdhEdkWrapping.Companion_EcdhUnwrapInfo_.Default()))
		_ = _38_valueOrError14
		_38_valueOrError14 = _37_unwrapOutputRes
		if (_38_valueOrError14).IsFailure() {
			res = (_38_valueOrError14).PropagateFailure()
			return res
		}
		var _39_unwrapOutput m_EdkWrapping.UnwrapEdkMaterialOutput
		_ = _39_unwrapOutput
		_39_unwrapOutput = (_38_valueOrError14).Extract().(m_EdkWrapping.UnwrapEdkMaterialOutput)
		var _40_valueOrError15 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _40_valueOrError15
		_40_valueOrError15 = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey((_this).Materials(), (_39_unwrapOutput).Dtor_plaintextDataKey(), (_39_unwrapOutput).Dtor_symmetricSigningKey())
		if (_40_valueOrError15).IsFailure() {
			res = (_40_valueOrError15).PropagateFailure()
			return res
		}
		var _41_result m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _41_result
		_41_result = (_40_valueOrError15).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(_41_result)
		return res
		return res
	}
}
func (_this *DecryptSingleEncryptedDataKey) Materials() m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials {
	{
		return _this._materials
	}
}
func (_this *DecryptSingleEncryptedDataKey) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *DecryptSingleEncryptedDataKey) RecipientPublicKey() _dafny.Sequence {
	{
		return _this._recipientPublicKey
	}
}
func (_this *DecryptSingleEncryptedDataKey) KeyAgreementScheme() m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations {
	{
		return _this._keyAgreementScheme
	}
}
func (_this *DecryptSingleEncryptedDataKey) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *DecryptSingleEncryptedDataKey) CurveSpec() m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec {
	{
		return _this._curveSpec
	}
}
func (_this *DecryptSingleEncryptedDataKey) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class DecryptSingleEncryptedDataKey

// Definition of class OnDecryptEcdhDataKeyFilter
type OnDecryptEcdhDataKeyFilter struct {
	_keyAgreementScheme           m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations
	_compressedRecipientPublicKey _dafny.Sequence
	_compressedSenderPublicKey    _dafny.Sequence
}

func New_OnDecryptEcdhDataKeyFilter_() *OnDecryptEcdhDataKeyFilter {
	_this := OnDecryptEcdhDataKeyFilter{}

	_this._keyAgreementScheme = m_AwsCryptographyMaterialProvidersTypes.Companion_KmsEcdhStaticConfigurations_.Default()
	_this._compressedRecipientPublicKey = _dafny.EmptySeq
	_this._compressedSenderPublicKey = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_OnDecryptEcdhDataKeyFilter_ struct {
}

var Companion_OnDecryptEcdhDataKeyFilter_ = CompanionStruct_OnDecryptEcdhDataKeyFilter_{}

func (_this *OnDecryptEcdhDataKeyFilter) Equals(other *OnDecryptEcdhDataKeyFilter) bool {
	return _this == other
}

func (_this *OnDecryptEcdhDataKeyFilter) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*OnDecryptEcdhDataKeyFilter)
	return ok && _this.Equals(other)
}

func (*OnDecryptEcdhDataKeyFilter) String() string {
	return "AwsKmsEcdhKeyring.OnDecryptEcdhDataKeyFilter"
}

func Type_OnDecryptEcdhDataKeyFilter_() _dafny.TypeDescriptor {
	return type_OnDecryptEcdhDataKeyFilter_{}
}

type type_OnDecryptEcdhDataKeyFilter_ struct {
}

func (_this type_OnDecryptEcdhDataKeyFilter_) Default() interface{} {
	return (*OnDecryptEcdhDataKeyFilter)(nil)
}

func (_this type_OnDecryptEcdhDataKeyFilter_) String() string {
	return "AwsKmsEcdhKeyring.OnDecryptEcdhDataKeyFilter"
}
func (_this *OnDecryptEcdhDataKeyFilter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_DeterministicActionWithResult_.TraitID_, m_Actions.Companion_DeterministicAction_.TraitID_}
}

var _ m_Actions.DeterministicActionWithResult = &OnDecryptEcdhDataKeyFilter{}
var _ m_Actions.DeterministicAction = &OnDecryptEcdhDataKeyFilter{}
var _ _dafny.TraitOffspring = &OnDecryptEcdhDataKeyFilter{}

func (_this *OnDecryptEcdhDataKeyFilter) Ctor__(keyAgreementScheme m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations, compressedRecipientPublicKey _dafny.Sequence, compressedSenderPublicKey m_Wrappers.Option) {
	{
		(_this)._keyAgreementScheme = keyAgreementScheme
		(_this)._compressedRecipientPublicKey = compressedRecipientPublicKey
		if (compressedSenderPublicKey).Is_Some() {
			(_this)._compressedSenderPublicKey = (compressedSenderPublicKey).Dtor_value().(_dafny.Sequence)
		} else {
			(_this)._compressedSenderPublicKey = _dafny.SeqOf()
		}
	}
}
func (_this *OnDecryptEcdhDataKeyFilter) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = res
		var _0_providerInfo _dafny.Sequence
		_ = _0_providerInfo
		_0_providerInfo = (edk).Dtor_keyProviderInfo()
		var _1_providerId _dafny.Sequence
		_ = _1_providerId
		_1_providerId = (edk).Dtor_keyProviderId()
		if (!_dafny.Companion_Sequence_.Equal(_1_providerId, m_Constants.Companion_Default___.RAW__ECDH__PROVIDER__ID())) && (!_dafny.Companion_Sequence_.Equal(_1_providerId, m_Constants.Companion_Default___.KMS__ECDH__PROVIDER__ID())) {
			res = m_Wrappers.Companion_Result_.Create_Success_(false)
			return res
		}
		var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError0
		_2_valueOrError0 = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfUint32((_0_providerInfo).Cardinality())).Cmp(_dafny.IntOfUint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__521__LEN())) <= 0) && (m_RawECDHKeyring.Companion_Default___.ValidProviderInfoLength(_0_providerInfo)), Companion_Default___.E(_dafny.SeqOfString("EDK ProviderInfo longer than expected")))
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_keyringVersion uint8
		_ = _3_keyringVersion
		_3_keyringVersion = (_0_providerInfo).Select(0).(uint8)
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError1
		_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(_dafny.SeqOf(_3_keyringVersion), Companion_Default___.AWS__KMS__ECDH__KEYRING__VERSION()), Companion_Default___.E(_dafny.SeqOfString("Incorrect Keyring version found in provider info.")))
		if (_4_valueOrError1).IsFailure() {
			res = (_4_valueOrError1).PropagateFailure()
			return res
		}
		var _5_recipientPublicKeyLength _dafny.Int
		_ = _5_recipientPublicKeyLength
		_5_recipientPublicKeyLength = _dafny.IntOfUint32(m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((_0_providerInfo).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPL__INDEX()), uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX()))))
		var _6_recipientPublicKeyLengthIndex _dafny.Int
		_ = _6_recipientPublicKeyLengthIndex
		_6_recipientPublicKeyLengthIndex = (_dafny.IntOfUint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX())).Plus(_5_recipientPublicKeyLength)
		var _7_senderPublicKeyIndex _dafny.Int
		_ = _7_senderPublicKeyIndex
		_7_senderPublicKeyIndex = (_6_recipientPublicKeyLengthIndex).Plus(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__PUBLIC__KEY__LEN())
		var _8_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError2
		_8_valueOrError2 = m_Wrappers.Companion_Default___.Need(((_6_recipientPublicKeyLengthIndex).Plus(_dafny.IntOfInt64(4))).Cmp(_dafny.IntOfUint32((_0_providerInfo).Cardinality())) < 0, Companion_Default___.E(_dafny.SeqOfString("Key Provider Info Serialization Error. Serialized length less than expected.")))
		if (_8_valueOrError2).IsFailure() {
			res = (_8_valueOrError2).PropagateFailure()
			return res
		}
		var _9_providerInfoRecipientPublicKey _dafny.Sequence
		_ = _9_providerInfoRecipientPublicKey
		_9_providerInfoRecipientPublicKey = (_0_providerInfo).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX()), (_6_recipientPublicKeyLengthIndex).Uint32())
		var _10_providerInfoSenderPublicKey _dafny.Sequence
		_ = _10_providerInfoSenderPublicKey
		_10_providerInfoSenderPublicKey = (_0_providerInfo).Drop((_7_senderPublicKeyIndex).Uint32())
		if ((_this).KeyAgreementScheme()).Is_KmsPublicKeyDiscovery() {
			res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Equal((_this).CompressedRecipientPublicKey(), _9_providerInfoRecipientPublicKey))
			return res
		} else {
			res = m_Wrappers.Companion_Result_.Create_Success_(((_dafny.Companion_Sequence_.Equal((_this).CompressedSenderPublicKey(), _10_providerInfoSenderPublicKey)) && (_dafny.Companion_Sequence_.Equal((_this).CompressedRecipientPublicKey(), _9_providerInfoRecipientPublicKey))) || ((_dafny.Companion_Sequence_.Equal((_this).CompressedSenderPublicKey(), _9_providerInfoRecipientPublicKey)) && (_dafny.Companion_Sequence_.Equal((_this).CompressedRecipientPublicKey(), _10_providerInfoSenderPublicKey))))
			return res
		}
		return res
	}
}
func (_this *OnDecryptEcdhDataKeyFilter) KeyAgreementScheme() m_AwsCryptographyMaterialProvidersTypes.KmsEcdhStaticConfigurations {
	{
		return _this._keyAgreementScheme
	}
}
func (_this *OnDecryptEcdhDataKeyFilter) CompressedRecipientPublicKey() _dafny.Sequence {
	{
		return _this._compressedRecipientPublicKey
	}
}
func (_this *OnDecryptEcdhDataKeyFilter) CompressedSenderPublicKey() _dafny.Sequence {
	{
		return _this._compressedSenderPublicKey
	}
}

// End of class OnDecryptEcdhDataKeyFilter
