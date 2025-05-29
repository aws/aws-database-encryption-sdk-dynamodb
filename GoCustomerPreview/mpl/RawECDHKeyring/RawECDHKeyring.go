// Package RawECDHKeyring
// Dafny module RawECDHKeyring compiled into Go

package RawECDHKeyring

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
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
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
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_RawAESKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawAESKeyring"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
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
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_Constants.Dummy__
var _ m_EcdhEdkWrapping.Dummy__

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
	return "RawECDHKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ValidPublicKeyLength(p _dafny.Sequence) bool {
	var _0_len uint64 = uint64((p).Cardinality())
	_ = _0_len
	return (true) && ((((_0_len) == (m_Constants.Companion_Default___.ECDH__PUBLIC__KEY__LEN__ECC__NIST__256())) || ((_0_len) == (m_Constants.Companion_Default___.ECDH__PUBLIC__KEY__LEN__ECC__NIST__384()))) || ((_0_len) == (m_Constants.Companion_Default___.ECDH__PUBLIC__KEY__LEN__ECC__NIST__521())))
}
func (_static *CompanionStruct_Default___) ValidCompressedPublicKeyLength(p _dafny.Sequence) bool {
	var _0_len uint64 = uint64((p).Cardinality())
	_ = _0_len
	return (true) && ((((_0_len) == (m_Constants.Companion_Default___.ECDH__PUBLIC__KEY__COMPRESSED__LEN__ECC__NIST__256())) || ((_0_len) == (m_Constants.Companion_Default___.ECDH__PUBLIC__KEY__COMPRESSED__LEN__ECC__NIST__384()))) || ((_0_len) == (m_Constants.Companion_Default___.ECDH__PUBLIC__KEY__COMPRESSED__LEN__ECC__NIST__521())))
}
func (_static *CompanionStruct_Default___) ValidProviderInfoLength(p _dafny.Sequence) bool {
	var _0_len uint64 = uint64((p).Cardinality())
	_ = _0_len
	return (((_0_len) == (uint64(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__256__LEN()))) || ((_0_len) == (uint64(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__384__LEN())))) || ((_0_len) == (uint64(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__521__LEN())))
}
func (_static *CompanionStruct_Default___) LocalDeriveSharedSecret(senderPrivateKey m_AwsCryptographyPrimitivesTypes.ECCPrivateKey, recipientPublicKey m_AwsCryptographyPrimitivesTypes.ECCPublicKey, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_maybeSharedSecret m_Wrappers.Result
	_ = _0_maybeSharedSecret
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (crypto).DeriveSharedSecret(m_AwsCryptographyPrimitivesTypes.Companion_DeriveSharedSecretInput_.Create_DeriveSharedSecretInput_(curveSpec, senderPrivateKey, recipientPublicKey))
	_0_maybeSharedSecret = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_DeriveSharedSecretOutput_.Default())
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeSharedSecret).MapFailure(func(coer60 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg61 interface{}) interface{} {
			return coer60(arg61.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_sharedSecretOutput m_AwsCryptographyPrimitivesTypes.DeriveSharedSecretOutput
	_ = _3_sharedSecretOutput
	_3_sharedSecretOutput = (_1_valueOrError0).Extract().(m_AwsCryptographyPrimitivesTypes.DeriveSharedSecretOutput)
	res = m_Wrappers.Companion_Result_.Create_Success_((_3_sharedSecretOutput).Dtor_sharedSecret())
	return res
	return res
}
func (_static *CompanionStruct_Default___) CompressPublicKey(publicKey m_AwsCryptographyPrimitivesTypes.ECCPublicKey, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_maybeCompressedPublicKey m_Wrappers.Result
	_ = _0_maybeCompressedPublicKey
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (crypto).CompressPublicKey(m_AwsCryptographyPrimitivesTypes.Companion_CompressPublicKeyInput_.Create_CompressPublicKeyInput_(publicKey, curveSpec))
	_0_maybeCompressedPublicKey = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_CompressPublicKeyOutput_.Default())
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeCompressedPublicKey).MapFailure(func(coer61 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg62 interface{}) interface{} {
			return coer61(arg62.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_compressedPublicKey m_AwsCryptographyPrimitivesTypes.CompressPublicKeyOutput
	_ = _3_compressedPublicKey
	_3_compressedPublicKey = (_1_valueOrError0).Extract().(m_AwsCryptographyPrimitivesTypes.CompressPublicKeyOutput)
	res = m_Wrappers.Companion_Result_.Create_Success_((_3_compressedPublicKey).Dtor_compressedPublicKey())
	return res
	return res
}
func (_static *CompanionStruct_Default___) DecompressPublicKey(publicKey _dafny.Sequence, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_maybePublicKey m_Wrappers.Result
	_ = _0_maybePublicKey
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (crypto).DecompressPublicKey(m_AwsCryptographyPrimitivesTypes.Companion_DecompressPublicKeyInput_.Create_DecompressPublicKeyInput_(publicKey, curveSpec))
	_0_maybePublicKey = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_DecompressPublicKeyOutput_.Default())
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybePublicKey).MapFailure(func(coer62 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg63 interface{}) interface{} {
			return coer62(arg63.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_publicKey m_AwsCryptographyPrimitivesTypes.DecompressPublicKeyOutput
	_ = _3_publicKey
	_3_publicKey = (_1_valueOrError0).Extract().(m_AwsCryptographyPrimitivesTypes.DecompressPublicKeyOutput)
	res = m_Wrappers.Companion_Result_.Create_Success_(((_3_publicKey).Dtor_publicKey()).Dtor_der())
	return res
	return res
}
func (_static *CompanionStruct_Default___) SerializeProviderInfo(senderPublicKey _dafny.Sequence, recipientPublicKey _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.RAW__ECDH__KEYRING__VERSION(), m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(uint32((recipientPublicKey).Cardinality()))), recipientPublicKey), m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(uint32((senderPublicKey).Cardinality()))), senderPublicKey)
}
func (_static *CompanionStruct_Default___) GenerateEphemeralEccKeyPair(curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECCKeyPairOutput_.Default())
	_ = res
	var _0_maybeKeyPair m_Wrappers.Result
	_ = _0_maybeKeyPair
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (crypto).GenerateECCKeyPair(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECCKeyPairInput_.Create_GenerateECCKeyPairInput_(curveSpec))
	_0_maybeKeyPair = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECCKeyPairOutput_.Default())
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeKeyPair).MapFailure(func(coer63 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg64 interface{}) interface{} {
			return coer63(arg64.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_keyPair m_AwsCryptographyPrimitivesTypes.GenerateECCKeyPairOutput
	_ = _3_keyPair
	_3_keyPair = (_1_valueOrError0).Extract().(m_AwsCryptographyPrimitivesTypes.GenerateECCKeyPairOutput)
	res = m_Wrappers.Companion_Result_.Create_Success_(_3_keyPair)
	return res
}
func (_static *CompanionStruct_Default___) ValidatePublicKey(crypto *m_AtomicPrimitives.AtomicPrimitivesClient, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, publicKey _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = res
	var _0_maybeValidate m_Wrappers.Result
	_ = _0_maybeValidate
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (crypto).ValidatePublicKey(m_AwsCryptographyPrimitivesTypes.Companion_ValidatePublicKeyInput_.Create_ValidatePublicKeyInput_(curveSpec, publicKey))
	_0_maybeValidate = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_ValidatePublicKeyOutput_.Default())
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeValidate).MapFailure(func(coer64 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg65 interface{}) interface{} {
			return coer64(arg65.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_validate m_AwsCryptographyPrimitivesTypes.ValidatePublicKeyOutput
	_ = _3_validate
	_3_validate = (_1_valueOrError0).Extract().(m_AwsCryptographyPrimitivesTypes.ValidatePublicKeyOutput)
	res = m_Wrappers.Companion_Result_.Create_Success_((_3_validate).Dtor_success())
	return res
}
func (_static *CompanionStruct_Default___) CurveSpecTypeToString(c m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec) _dafny.Sequence {
	var _source0 m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec = c
	_ = _source0
	{
		if _source0.Is_ECC__NIST__P256() {
			return _dafny.SeqOfString("p256")
		}
	}
	{
		if _source0.Is_ECC__NIST__P384() {
			return _dafny.SeqOfString("p384")
		}
	}
	{
		if _source0.Is_ECC__NIST__P521() {
			return _dafny.SeqOfString("p521")
		}
	}
	{
		return _dafny.SeqOfString("sm2")
	}
}
func (_static *CompanionStruct_Default___) E(s _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(s)
}
func (_static *CompanionStruct_Default___) RAW__ECDH__KEYRING__VERSION() _dafny.Sequence {
	return _dafny.SeqOf(uint8(1))
}

// End of class Default__

// Definition of class RawEcdhKeyring
type RawEcdhKeyring struct {
	_cryptoPrimitives             *m_AtomicPrimitives.AtomicPrimitivesClient
	_keyAgreementScheme           m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations
	_curveSpec                    m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec
	_recipientPublicKey           m_AwsCryptographyPrimitivesTypes.ECCPublicKey
	_compressedRecipientPublicKey _dafny.Sequence
	_senderPublicKey              m_AwsCryptographyPrimitivesTypes.ECCPublicKey
	_senderPrivateKey             m_AwsCryptographyPrimitivesTypes.ECCPrivateKey
	_compressedSenderPublicKey    _dafny.Sequence
}

func New_RawEcdhKeyring_() *RawEcdhKeyring {
	_this := RawEcdhKeyring{}

	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._keyAgreementScheme = m_AwsCryptographyMaterialProvidersTypes.Companion_RawEcdhStaticConfigurations_.Default()
	_this._curveSpec = m_AwsCryptographyPrimitivesTypes.Companion_ECDHCurveSpec_.Default()
	_this._recipientPublicKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Default()
	_this._compressedRecipientPublicKey = _dafny.EmptySeq
	_this._senderPublicKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Default()
	_this._senderPrivateKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPrivateKey_.Default()
	_this._compressedSenderPublicKey = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_RawEcdhKeyring_ struct {
}

var Companion_RawEcdhKeyring_ = CompanionStruct_RawEcdhKeyring_{}

func (_this *RawEcdhKeyring) Equals(other *RawEcdhKeyring) bool {
	return _this == other
}

func (_this *RawEcdhKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*RawEcdhKeyring)
	return ok && _this.Equals(other)
}

func (*RawEcdhKeyring) String() string {
	return "RawECDHKeyring.RawEcdhKeyring"
}

func Type_RawEcdhKeyring_() _dafny.TypeDescriptor {
	return type_RawEcdhKeyring_{}
}

type type_RawEcdhKeyring_ struct {
}

func (_this type_RawEcdhKeyring_) Default() interface{} {
	return (*RawEcdhKeyring)(nil)
}

func (_this type_RawEcdhKeyring_) String() string {
	return "RawECDHKeyring.RawEcdhKeyring"
}
func (_this *RawEcdhKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &RawEcdhKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &RawEcdhKeyring{}
var _ _dafny.TraitOffspring = &RawEcdhKeyring{}

func (_this *RawEcdhKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out2
}
func (_this *RawEcdhKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out2
}
func (_this *RawEcdhKeyring) Ctor__(keyAgreementScheme m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, senderPrivateKey m_Wrappers.Option, senderPublicKey m_Wrappers.Option, recipientPublicKey _dafny.Sequence, compressedSenderPublicKey m_Wrappers.Option, compressedRecipientPublicKey _dafny.Sequence, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._keyAgreementScheme = keyAgreementScheme
		(_this)._curveSpec = curveSpec
		(_this)._cryptoPrimitives = cryptoPrimitives
		(_this)._recipientPublicKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(recipientPublicKey)
		(_this)._compressedRecipientPublicKey = compressedRecipientPublicKey
		if (((senderPublicKey).Is_Some()) && ((senderPrivateKey).Is_Some())) && ((compressedSenderPublicKey).Is_Some()) {
			(_this)._senderPublicKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_((senderPublicKey).Dtor_value().(_dafny.Sequence))
			(_this)._senderPrivateKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPrivateKey_.Create_ECCPrivateKey_((senderPrivateKey).Dtor_value().(_dafny.Sequence))
			(_this)._compressedSenderPublicKey = (compressedSenderPublicKey).Dtor_value().(_dafny.Sequence)
		} else {
			(_this)._senderPublicKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(_dafny.SeqOf())
			(_this)._senderPrivateKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPrivateKey_.Create_ECCPrivateKey_(_dafny.SeqOf())
			(_this)._compressedSenderPublicKey = _dafny.SeqOf()
		}
	}
}
func (_this *RawEcdhKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		if ((_this).KeyAgreementScheme()).Is_PublicKeyDiscovery() {
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("PublicKeyDiscovery Key Agreement Scheme is forbidden on encrypt.")))
			return res
		}
		var _0_operationSenderPrivateKey m_AwsCryptographyPrimitivesTypes.ECCPrivateKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPrivateKey_.Default()
		_ = _0_operationSenderPrivateKey
		var _1_operationSenderPublicKey m_AwsCryptographyPrimitivesTypes.ECCPublicKey = m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Default()
		_ = _1_operationSenderPublicKey
		var _2_operationCompressedSenderPublicKey _dafny.Sequence = _dafny.EmptySeq
		_ = _2_operationCompressedSenderPublicKey
		if ((_this).KeyAgreementScheme()).Is_EphemeralPrivateKeyToStaticPublicKey() {
			var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_GenerateECCKeyPairOutput_.Default())
			_ = _3_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = Companion_Default___.GenerateEphemeralEccKeyPair((_this).CurveSpec(), (_this).CryptoPrimitives())
			_3_valueOrError0 = _out0
			if (_3_valueOrError0).IsFailure() {
				res = (_3_valueOrError0).PropagateFailure()
				return res
			}
			var _4_ephemeralKeyPair m_AwsCryptographyPrimitivesTypes.GenerateECCKeyPairOutput
			_ = _4_ephemeralKeyPair
			_4_ephemeralKeyPair = (_3_valueOrError0).Extract().(m_AwsCryptographyPrimitivesTypes.GenerateECCKeyPairOutput)
			_0_operationSenderPrivateKey = (_4_ephemeralKeyPair).Dtor_privateKey()
			_1_operationSenderPublicKey = (_4_ephemeralKeyPair).Dtor_publicKey()
			var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
			_ = _5_valueOrError1
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = Companion_Default___.CompressPublicKey(m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_((_1_operationSenderPublicKey).Dtor_der()), (_this).CurveSpec(), (_this).CryptoPrimitives())
			_5_valueOrError1 = _out1
			if (_5_valueOrError1).IsFailure() {
				res = (_5_valueOrError1).PropagateFailure()
				return res
			}
			var _6_operationCompressedSenderPublicKey_q _dafny.Sequence
			_ = _6_operationCompressedSenderPublicKey_q
			_6_operationCompressedSenderPublicKey_q = (_5_valueOrError1).Extract().(_dafny.Sequence)
			_2_operationCompressedSenderPublicKey = _6_operationCompressedSenderPublicKey_q
		} else {
			_0_operationSenderPrivateKey = (_this).SenderPrivateKey()
			_1_operationSenderPublicKey = (_this).SenderPublicKey()
			_2_operationCompressedSenderPublicKey = (_this).CompressedSenderPublicKey()
		}
		var _7_materials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
		_ = _7_materials
		_7_materials = (input).Dtor_materials()
		var _8_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _8_suite
		_8_suite = ((input).Dtor_materials()).Dtor_algorithmSuite()
		var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _9_valueOrError2
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = Companion_Default___.LocalDeriveSharedSecret(_0_operationSenderPrivateKey, (_this).RecipientPublicKey(), (_this).CurveSpec(), (_this).CryptoPrimitives())
		_9_valueOrError2 = _out2
		if (_9_valueOrError2).IsFailure() {
			res = (_9_valueOrError2).PropagateFailure()
			return res
		}
		var _10_sharedSecret _dafny.Sequence
		_ = _10_sharedSecret
		_10_sharedSecret = (_9_valueOrError2).Extract().(_dafny.Sequence)
		var _11_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _11_valueOrError3
		_11_valueOrError3 = (m_UTF8.Encode(Companion_Default___.CurveSpecTypeToString((_this).CurveSpec()))).MapFailure(func(coer65 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg66 interface{}) interface{} {
				return coer65(arg66.(_dafny.Sequence))
			}
		}(Companion_Default___.E))
		if (_11_valueOrError3).IsFailure() {
			res = (_11_valueOrError3).PropagateFailure()
			return res
		}
		var _12_curveSpecUtf8 _dafny.Sequence
		_ = _12_curveSpecUtf8
		_12_curveSpecUtf8 = (_11_valueOrError3).Extract().(_dafny.Sequence)
		var _13_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _13_valueOrError4
		_13_valueOrError4 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD(((input).Dtor_materials()).Dtor_encryptionContext())
		if (_13_valueOrError4).IsFailure() {
			res = (_13_valueOrError4).PropagateFailure()
			return res
		}
		var _14_canonicalizedEC _dafny.Sequence
		_ = _14_canonicalizedEC
		_14_canonicalizedEC = (_13_valueOrError4).Extract().(_dafny.Sequence)
		var _15_fixedInfo _dafny.Sequence
		_ = _15_fixedInfo
		_15_fixedInfo = m_EcdhEdkWrapping.Companion_Default___.SerializeFixedInfo(m_Constants.Companion_Default___.ECDH__KDF__UTF8(), _12_curveSpecUtf8, _2_operationCompressedSenderPublicKey, (_this).CompressedRecipientPublicKey(), _14_canonicalizedEC, Companion_Default___.RAW__ECDH__KEYRING__VERSION())
		var _16_ecdhGenerateAndWrap *m_EcdhEdkWrapping.EcdhGenerateAndWrapKeyMaterial
		_ = _16_ecdhGenerateAndWrap
		var _nw0 *m_EcdhEdkWrapping.EcdhGenerateAndWrapKeyMaterial = m_EcdhEdkWrapping.New_EcdhGenerateAndWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__(_10_sharedSecret, _15_fixedInfo, (_this).CryptoPrimitives())
		_16_ecdhGenerateAndWrap = _nw0
		var _17_ecdhWrap *m_EcdhEdkWrapping.EcdhWrapKeyMaterial
		_ = _17_ecdhWrap
		var _nw1 *m_EcdhEdkWrapping.EcdhWrapKeyMaterial = m_EcdhEdkWrapping.New_EcdhWrapKeyMaterial_()
		_ = _nw1
		_nw1.Ctor__(_10_sharedSecret, _15_fixedInfo, (_this).CryptoPrimitives())
		_17_ecdhWrap = _nw1
		var _18_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_WrapEdkMaterialOutput_.Default(m_EcdhEdkWrapping.Companion_EcdhWrapInfo_.Default()))
		_ = _18_valueOrError5
		var _out3 m_Wrappers.Result
		_ = _out3
		_out3 = m_EdkWrapping.Companion_Default___.WrapEdkMaterial(_7_materials, _17_ecdhWrap, _16_ecdhGenerateAndWrap)
		_18_valueOrError5 = _out3
		if (_18_valueOrError5).IsFailure() {
			res = (_18_valueOrError5).PropagateFailure()
			return res
		}
		var _19_wrapOutput m_EdkWrapping.WrapEdkMaterialOutput
		_ = _19_wrapOutput
		_19_wrapOutput = (_18_valueOrError5).Extract().(m_EdkWrapping.WrapEdkMaterialOutput)
		var _20_symmetricSigningKeyList m_Wrappers.Option
		_ = _20_symmetricSigningKeyList
		if ((_19_wrapOutput).Dtor_symmetricSigningKey()).Is_Some() {
			_20_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(((_19_wrapOutput).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence)))
		} else {
			_20_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _21_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _21_valueOrError6
		_21_valueOrError6 = m_Wrappers.Companion_Default___.Need((Companion_Default___.ValidCompressedPublicKeyLength(_2_operationCompressedSenderPublicKey)) && (Companion_Default___.ValidCompressedPublicKeyLength((_this).CompressedRecipientPublicKey())), Companion_Default___.E(_dafny.SeqOfString("Invalid compressed public key length.")))
		if (_21_valueOrError6).IsFailure() {
			res = (_21_valueOrError6).PropagateFailure()
			return res
		}
		var _22_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
		_ = _22_edk
		_22_edk = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(m_Constants.Companion_Default___.RAW__ECDH__PROVIDER__ID(), Companion_Default___.SerializeProviderInfo(_2_operationCompressedSenderPublicKey, (_this).CompressedRecipientPublicKey()), (_19_wrapOutput).Dtor_wrappedMaterial())
		if (_19_wrapOutput).Is_GenerateAndWrapEdkMaterialOutput() {
			var _23_valueOrError7 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _23_valueOrError7
			_23_valueOrError7 = m_Materials.Companion_Default___.EncryptionMaterialAddDataKey(_7_materials, (_19_wrapOutput).Dtor_plaintextDataKey(), _dafny.SeqOf(_22_edk), _20_symmetricSigningKeyList)
			if (_23_valueOrError7).IsFailure() {
				res = (_23_valueOrError7).PropagateFailure()
				return res
			}
			var _24_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _24_result
			_24_result = (_23_valueOrError7).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_24_result))
			return res
		} else if (_19_wrapOutput).Is_WrapOnlyEdkMaterialOutput() {
			var _25_valueOrError8 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _25_valueOrError8
			_25_valueOrError8 = m_Materials.Companion_Default___.EncryptionMaterialAddEncryptedDataKeys(_7_materials, _dafny.SeqOf(_22_edk), _20_symmetricSigningKeyList)
			if (_25_valueOrError8).IsFailure() {
				res = (_25_valueOrError8).PropagateFailure()
				return res
			}
			var _26_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _26_result
			_26_result = (_25_valueOrError8).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_26_result))
			return res
		}
		return res
	}
}
func (_this *RawEcdhKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		if ((_this).KeyAgreementScheme()).Is_EphemeralPrivateKeyToStaticPublicKey() {
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("EphemeralPrivateKeyToStaticPublicKey Key Agreement Scheme is forbidden on decrypt.")))
			return res
		}
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
		var _3_operationCompressedSenderPublicKey m_Wrappers.Option
		_ = _3_operationCompressedSenderPublicKey
		if _dafny.Companion_Sequence_.Equal((_this).CompressedSenderPublicKey(), _dafny.SeqOf()) {
			_3_operationCompressedSenderPublicKey = m_Wrappers.Companion_Option_.Create_None_()
		} else {
			_3_operationCompressedSenderPublicKey = m_Wrappers.Companion_Option_.Create_Some_((_this).CompressedSenderPublicKey())
		}
		var _4_filter *OnDecryptEcdhDataKeyFilter
		_ = _4_filter
		var _nw0 *OnDecryptEcdhDataKeyFilter = New_OnDecryptEcdhDataKeyFilter_()
		_ = _nw0
		_nw0.Ctor__((_this).KeyAgreementScheme(), (_this).CompressedRecipientPublicKey(), _3_operationCompressedSenderPublicKey)
		_4_filter = _nw0
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _5_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_Actions.Companion_Default___.FilterWithResult(_4_filter, (input).Dtor_encryptedDataKeys())
		_5_valueOrError1 = _out0
		if (_5_valueOrError1).IsFailure() {
			res = (_5_valueOrError1).PropagateFailure()
			return res
		}
		var _6_edksToAttempt _dafny.Sequence
		_ = _6_edksToAttempt
		_6_edksToAttempt = (_5_valueOrError1).Extract().(_dafny.Sequence)
		if (uint64(0)) == (uint64((_6_edksToAttempt).Cardinality())) {
			var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _7_valueOrError2
			_7_valueOrError2 = m_ErrorMessages.Companion_Default___.IncorrectDataKeys((input).Dtor_encryptedDataKeys(), ((input).Dtor_materials()).Dtor_algorithmSuite(), _dafny.SeqOfString(""))
			if (_7_valueOrError2).IsFailure() {
				res = (_7_valueOrError2).PropagateFailure()
				return res
			}
			var _8_errorMessage _dafny.Sequence
			_ = _8_errorMessage
			_8_errorMessage = (_7_valueOrError2).Extract().(_dafny.Sequence)
			res = m_Wrappers.Companion_Result_.Create_Failure_(Companion_Default___.E(_8_errorMessage))
			return res
		}
		var _9_decryptClosure m_Actions.ActionWithResult
		_ = _9_decryptClosure
		var _nw1 *DecryptSingleEncryptedDataKey = New_DecryptSingleEncryptedDataKey_()
		_ = _nw1
		_nw1.Ctor__(_0_materials, (_this).CryptoPrimitives(), (_this).CompressedSenderPublicKey(), (_this).CompressedRecipientPublicKey(), (_this).KeyAgreementScheme(), (_this).CurveSpec())
		_9_decryptClosure = _nw1
		var _10_outcome m_Wrappers.Result
		_ = _10_outcome
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_Actions.Companion_Default___.ReduceToSuccess(_9_decryptClosure, _6_edksToAttempt)
		_10_outcome = _out1
		var _11_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _11_valueOrError3
		_11_valueOrError3 = (_10_outcome).MapFailure(func(coer66 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg67 interface{}) interface{} {
				return coer66(arg67.(_dafny.Sequence))
			}
		}(func(_12_errors _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_12_errors, _dafny.SeqOfString("No Configured Key was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`."))
		}))
		if (_11_valueOrError3).IsFailure() {
			res = (_11_valueOrError3).PropagateFailure()
			return res
		}
		var _13_SealedDecryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _13_SealedDecryptionMaterials
		_13_SealedDecryptionMaterials = (_11_valueOrError3).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_13_SealedDecryptionMaterials))
		return res
		return res
	}
}
func (_this *RawEcdhKeyring) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *RawEcdhKeyring) KeyAgreementScheme() m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations {
	{
		return _this._keyAgreementScheme
	}
}
func (_this *RawEcdhKeyring) CurveSpec() m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec {
	{
		return _this._curveSpec
	}
}
func (_this *RawEcdhKeyring) RecipientPublicKey() m_AwsCryptographyPrimitivesTypes.ECCPublicKey {
	{
		return _this._recipientPublicKey
	}
}
func (_this *RawEcdhKeyring) CompressedRecipientPublicKey() _dafny.Sequence {
	{
		return _this._compressedRecipientPublicKey
	}
}
func (_this *RawEcdhKeyring) SenderPublicKey() m_AwsCryptographyPrimitivesTypes.ECCPublicKey {
	{
		return _this._senderPublicKey
	}
}
func (_this *RawEcdhKeyring) SenderPrivateKey() m_AwsCryptographyPrimitivesTypes.ECCPrivateKey {
	{
		return _this._senderPrivateKey
	}
}
func (_this *RawEcdhKeyring) CompressedSenderPublicKey() _dafny.Sequence {
	{
		return _this._compressedSenderPublicKey
	}
}

// End of class RawEcdhKeyring

// Definition of class OnDecryptEcdhDataKeyFilter
type OnDecryptEcdhDataKeyFilter struct {
	_keyAgreementScheme           m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations
	_compressedRecipientPublicKey _dafny.Sequence
	_compressedSenderPublicKey    _dafny.Sequence
}

func New_OnDecryptEcdhDataKeyFilter_() *OnDecryptEcdhDataKeyFilter {
	_this := OnDecryptEcdhDataKeyFilter{}

	_this._keyAgreementScheme = m_AwsCryptographyMaterialProvidersTypes.Companion_RawEcdhStaticConfigurations_.Default()
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
	return "RawECDHKeyring.OnDecryptEcdhDataKeyFilter"
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
	return "RawECDHKeyring.OnDecryptEcdhDataKeyFilter"
}
func (_this *OnDecryptEcdhDataKeyFilter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_DeterministicActionWithResult_.TraitID_, m_Actions.Companion_DeterministicAction_.TraitID_}
}

var _ m_Actions.DeterministicActionWithResult = &OnDecryptEcdhDataKeyFilter{}
var _ m_Actions.DeterministicAction = &OnDecryptEcdhDataKeyFilter{}
var _ _dafny.TraitOffspring = &OnDecryptEcdhDataKeyFilter{}

func (_this *OnDecryptEcdhDataKeyFilter) Ctor__(keyAgreementScheme m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations, compressedRecipientPublicKey _dafny.Sequence, compressedSenderPublicKey m_Wrappers.Option) {
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
		_2_valueOrError0 = m_Wrappers.Companion_Default___.Need(((uint64((_0_providerInfo).Cardinality())) <= (uint64(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__521__LEN()))) && (Companion_Default___.ValidProviderInfoLength(_0_providerInfo)), Companion_Default___.E(_dafny.SeqOfString("EDK ProviderInfo longer than expected")))
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_keyringVersion uint8
		_ = _3_keyringVersion
		_3_keyringVersion = (_0_providerInfo).Select(uint32(uint32(0))).(uint8)
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError1
		_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(_dafny.SeqOf(_3_keyringVersion), Companion_Default___.RAW__ECDH__KEYRING__VERSION()), Companion_Default___.E(_dafny.SeqOfString("Incorrect Keyring version found in provider info.")))
		if (_4_valueOrError1).IsFailure() {
			res = (_4_valueOrError1).PropagateFailure()
			return res
		}
		var _5_recipientPublicKeyLength uint32
		_ = _5_recipientPublicKeyLength
		_5_recipientPublicKeyLength = m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((_0_providerInfo).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPL__INDEX()), uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX())))
		var _6_recipientPublicKeyLengthIndex uint64
		_ = _6_recipientPublicKeyLengthIndex
		_6_recipientPublicKeyLengthIndex = (uint64(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX())) + (uint64(_5_recipientPublicKeyLength))
		var _7_senderPublicKeyIndex uint64
		_ = _7_senderPublicKeyIndex
		_7_senderPublicKeyIndex = (_6_recipientPublicKeyLengthIndex) + (m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__PUBLIC__KEY__LEN())
		var _8_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError2
		_8_valueOrError2 = m_Wrappers.Companion_Default___.Need(((_6_recipientPublicKeyLengthIndex)+(uint64(4))) < (uint64((_0_providerInfo).Cardinality())), Companion_Default___.E(_dafny.SeqOfString("Key Provider Info Serialization Error. Serialized length less than expected.")))
		if (_8_valueOrError2).IsFailure() {
			res = (_8_valueOrError2).PropagateFailure()
			return res
		}
		var _9_providerInfoRecipientPublicKey _dafny.Sequence
		_ = _9_providerInfoRecipientPublicKey
		_9_providerInfoRecipientPublicKey = (_0_providerInfo).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX()), uint32(_6_recipientPublicKeyLengthIndex))
		var _10_providerInfoSenderPublicKey _dafny.Sequence
		_ = _10_providerInfoSenderPublicKey
		_10_providerInfoSenderPublicKey = (_0_providerInfo).Drop(uint32(_7_senderPublicKeyIndex))
		if ((_this).KeyAgreementScheme()).Is_PublicKeyDiscovery() {
			res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Equal((_this).CompressedRecipientPublicKey(), _9_providerInfoRecipientPublicKey))
			return res
		} else {
			res = m_Wrappers.Companion_Result_.Create_Success_(((_dafny.Companion_Sequence_.Equal((_this).CompressedSenderPublicKey(), _10_providerInfoSenderPublicKey)) && (_dafny.Companion_Sequence_.Equal((_this).CompressedRecipientPublicKey(), _9_providerInfoRecipientPublicKey))) || ((_dafny.Companion_Sequence_.Equal((_this).CompressedSenderPublicKey(), _9_providerInfoRecipientPublicKey)) && (_dafny.Companion_Sequence_.Equal((_this).CompressedRecipientPublicKey(), _10_providerInfoSenderPublicKey))))
			return res
		}
		return res
	}
}
func (_this *OnDecryptEcdhDataKeyFilter) KeyAgreementScheme() m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations {
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

// Definition of class DecryptSingleEncryptedDataKey
type DecryptSingleEncryptedDataKey struct {
	_materials          m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_cryptoPrimitives   *m_AtomicPrimitives.AtomicPrimitivesClient
	_recipientPublicKey _dafny.Sequence
	_senderPublicKey    _dafny.Sequence
	_keyAgreementScheme m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations
	_curveSpec          m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec
}

func New_DecryptSingleEncryptedDataKey_() *DecryptSingleEncryptedDataKey {
	_this := DecryptSingleEncryptedDataKey{}

	_this._materials = m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials{}
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._recipientPublicKey = _dafny.EmptySeq
	_this._senderPublicKey = _dafny.EmptySeq
	_this._keyAgreementScheme = m_AwsCryptographyMaterialProvidersTypes.Companion_RawEcdhStaticConfigurations_.Default()
	_this._curveSpec = m_AwsCryptographyPrimitivesTypes.Companion_ECDHCurveSpec_.Default()
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
	return "RawECDHKeyring.DecryptSingleEncryptedDataKey"
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
	return "RawECDHKeyring.DecryptSingleEncryptedDataKey"
}
func (_this *DecryptSingleEncryptedDataKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_Actions.ActionWithResult = &DecryptSingleEncryptedDataKey{}
var _ m_Actions.Action = &DecryptSingleEncryptedDataKey{}
var _ _dafny.TraitOffspring = &DecryptSingleEncryptedDataKey{}

func (_this *DecryptSingleEncryptedDataKey) Ctor__(materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient, senderPublicKey _dafny.Sequence, recipientPublicKey _dafny.Sequence, keyAgreementScheme m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec) {
	{
		(_this)._materials = materials
		(_this)._cryptoPrimitives = cryptoPrimitives
		(_this)._recipientPublicKey = recipientPublicKey
		(_this)._senderPublicKey = senderPublicKey
		(_this)._keyAgreementScheme = keyAgreementScheme
		(_this)._curveSpec = curveSpec
	}
}
func (_this *DecryptSingleEncryptedDataKey) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = ((_this).Materials()).Dtor_algorithmSuite()
		var _1_keyProviderId _dafny.Sequence
		_ = _1_keyProviderId
		_1_keyProviderId = (edk).Dtor_keyProviderId()
		var _2_providerInfo _dafny.Sequence
		_ = _2_providerInfo
		_2_providerInfo = (edk).Dtor_keyProviderInfo()
		var _3_ciphertext _dafny.Sequence
		_ = _3_ciphertext
		_3_ciphertext = (edk).Dtor_ciphertext()
		var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError0
		_4_valueOrError0 = m_EdkWrapping.Companion_Default___.GetProviderWrappedMaterial(_3_ciphertext, _0_suite)
		if (_4_valueOrError0).IsFailure() {
			res = (_4_valueOrError0).PropagateFailure()
			return res
		}
		var _5_providerWrappedMaterial _dafny.Sequence
		_ = _5_providerWrappedMaterial
		_5_providerWrappedMaterial = (_4_valueOrError0).Extract().(_dafny.Sequence)
		var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _6_valueOrError1
		_6_valueOrError1 = m_Wrappers.Companion_Default___.Need(((uint64((_2_providerInfo).Cardinality())) <= (uint64(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__521__LEN()))) && (Companion_Default___.ValidProviderInfoLength(_2_providerInfo)), Companion_Default___.E(_dafny.SeqOfString("EDK ProviderInfo longer than expected")))
		if (_6_valueOrError1).IsFailure() {
			res = (_6_valueOrError1).PropagateFailure()
			return res
		}
		var _7_keyringVersion uint8
		_ = _7_keyringVersion
		_7_keyringVersion = (_2_providerInfo).Select(uint32(uint32(0))).(uint8)
		var _8_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError2
		_8_valueOrError2 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(_dafny.SeqOf(_7_keyringVersion), Companion_Default___.RAW__ECDH__KEYRING__VERSION()), Companion_Default___.E(_dafny.SeqOfString("Incorrect Keyring version found in provider info.")))
		if (_8_valueOrError2).IsFailure() {
			res = (_8_valueOrError2).PropagateFailure()
			return res
		}
		var _9_recipientPublicKeyLength uint32
		_ = _9_recipientPublicKeyLength
		_9_recipientPublicKeyLength = m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((_2_providerInfo).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPL__INDEX()), uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX())))
		var _10_recipientPublicKeyLengthIndex uint64
		_ = _10_recipientPublicKeyLengthIndex
		_10_recipientPublicKeyLengthIndex = (uint64(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX())) + (uint64(_9_recipientPublicKeyLength))
		var _11_senderPublicKeyIndex uint64
		_ = _11_senderPublicKeyIndex
		_11_senderPublicKeyIndex = (_10_recipientPublicKeyLengthIndex) + (m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__PUBLIC__KEY__LEN())
		var _12_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _12_valueOrError3
		_12_valueOrError3 = m_Wrappers.Companion_Default___.Need(((_10_recipientPublicKeyLengthIndex)+(uint64(4))) < (uint64((_2_providerInfo).Cardinality())), Companion_Default___.E(_dafny.SeqOfString("Key Provider Info Serialization Error. Serialized length less than expected.")))
		if (_12_valueOrError3).IsFailure() {
			res = (_12_valueOrError3).PropagateFailure()
			return res
		}
		var _13_providerInfoRecipientPublicKey _dafny.Sequence
		_ = _13_providerInfoRecipientPublicKey
		_13_providerInfoRecipientPublicKey = (_2_providerInfo).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__PROVIDER__INFO__RPK__INDEX()), uint32(_10_recipientPublicKeyLengthIndex))
		var _14_providerInfoSenderPublicKey _dafny.Sequence
		_ = _14_providerInfoSenderPublicKey
		_14_providerInfoSenderPublicKey = (_2_providerInfo).Drop(uint32(_11_senderPublicKeyIndex))
		var _15_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _15_valueOrError4
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.DecompressPublicKey(_14_providerInfoSenderPublicKey, (_this).CurveSpec(), (_this).CryptoPrimitives())
		_15_valueOrError4 = _out0
		if (_15_valueOrError4).IsFailure() {
			res = (_15_valueOrError4).PropagateFailure()
			return res
		}
		var _16_senderPublicKey _dafny.Sequence
		_ = _16_senderPublicKey
		_16_senderPublicKey = (_15_valueOrError4).Extract().(_dafny.Sequence)
		var _17_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _17_valueOrError5
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.DecompressPublicKey(_13_providerInfoRecipientPublicKey, (_this).CurveSpec(), (_this).CryptoPrimitives())
		_17_valueOrError5 = _out1
		if (_17_valueOrError5).IsFailure() {
			res = (_17_valueOrError5).PropagateFailure()
			return res
		}
		var _18_recipientPublicKey _dafny.Sequence
		_ = _18_recipientPublicKey
		_18_recipientPublicKey = (_17_valueOrError5).Extract().(_dafny.Sequence)
		var _19_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _19_valueOrError6
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = Companion_Default___.ValidatePublicKey((_this).CryptoPrimitives(), (_this).CurveSpec(), _16_senderPublicKey)
		_19_valueOrError6 = _out2
		if (_19_valueOrError6).IsFailure() {
			res = (_19_valueOrError6).PropagateFailure()
			return res
		}
		var _20___v0 bool
		_ = _20___v0
		_20___v0 = (_19_valueOrError6).Extract().(bool)
		var _21_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _21_valueOrError7
		var _out3 m_Wrappers.Result
		_ = _out3
		_out3 = Companion_Default___.ValidatePublicKey((_this).CryptoPrimitives(), (_this).CurveSpec(), _18_recipientPublicKey)
		_21_valueOrError7 = _out3
		if (_21_valueOrError7).IsFailure() {
			res = (_21_valueOrError7).PropagateFailure()
			return res
		}
		var _22___v1 bool
		_ = _22___v1
		_22___v1 = (_21_valueOrError7).Extract().(bool)
		var _23_sharedSecretPublicKey _dafny.Sequence = _dafny.EmptySeq
		_ = _23_sharedSecretPublicKey
		var _24_sharedSecretPrivateKey _dafny.Sequence = _dafny.EmptySeq
		_ = _24_sharedSecretPrivateKey
		var _source0 m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations = (_this).KeyAgreementScheme()
		_ = _source0
		{
			{
				if _source0.Is_PublicKeyDiscovery() {
					var _25_publicKeyDiscovery m_AwsCryptographyMaterialProvidersTypes.PublicKeyDiscoveryInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations_PublicKeyDiscovery).PublicKeyDiscovery
					_ = _25_publicKeyDiscovery
					{
						_23_sharedSecretPublicKey = _16_senderPublicKey
						_24_sharedSecretPrivateKey = (_25_publicKeyDiscovery).Dtor_recipientStaticPrivateKey()
					}
					goto Lmatch0
				}
			}
			{
				if _source0.Is_RawPrivateKeyToStaticPublicKey() {
					var _26_rawPrivateKeyToStaticPublicKey m_AwsCryptographyMaterialProvidersTypes.RawPrivateKeyToStaticPublicKeyInput = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations_RawPrivateKeyToStaticPublicKey).RawPrivateKeyToStaticPublicKey
					_ = _26_rawPrivateKeyToStaticPublicKey
					{
						_24_sharedSecretPrivateKey = (_26_rawPrivateKeyToStaticPublicKey).Dtor_senderStaticPrivateKey()
						if _dafny.Companion_Sequence_.Equal((_26_rawPrivateKeyToStaticPublicKey).Dtor_recipientPublicKey(), _18_recipientPublicKey) {
							_23_sharedSecretPublicKey = _18_recipientPublicKey
						} else {
							_23_sharedSecretPublicKey = _16_senderPublicKey
						}
					}
					goto Lmatch0
				}
			}
			{
				{
					res = m_Wrappers.Companion_Result_.Create_Failure_(Companion_Default___.E(_dafny.SeqOfString("EphemeralPrivateKeyToStaticPublicKey Not allowed on decrypt")))
					return res
				}
			}
			goto Lmatch0
		}
	Lmatch0:
		var _27_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _27_valueOrError8
		var _out4 m_Wrappers.Result
		_ = _out4
		_out4 = Companion_Default___.ValidatePublicKey((_this).CryptoPrimitives(), (_this).CurveSpec(), _23_sharedSecretPublicKey)
		_27_valueOrError8 = _out4
		if (_27_valueOrError8).IsFailure() {
			res = (_27_valueOrError8).PropagateFailure()
			return res
		}
		var _28___v3 bool
		_ = _28___v3
		_28___v3 = (_27_valueOrError8).Extract().(bool)
		var _29_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _29_valueOrError9
		var _out5 m_Wrappers.Result
		_ = _out5
		_out5 = Companion_Default___.LocalDeriveSharedSecret(m_AwsCryptographyPrimitivesTypes.Companion_ECCPrivateKey_.Create_ECCPrivateKey_(_24_sharedSecretPrivateKey), m_AwsCryptographyPrimitivesTypes.Companion_ECCPublicKey_.Create_ECCPublicKey_(_23_sharedSecretPublicKey), (_this).CurveSpec(), (_this).CryptoPrimitives())
		_29_valueOrError9 = _out5
		if (_29_valueOrError9).IsFailure() {
			res = (_29_valueOrError9).PropagateFailure()
			return res
		}
		var _30_sharedSecret _dafny.Sequence
		_ = _30_sharedSecret
		_30_sharedSecret = (_29_valueOrError9).Extract().(_dafny.Sequence)
		var _31_ecdhUnwrap *m_EcdhEdkWrapping.EcdhUnwrap
		_ = _31_ecdhUnwrap
		var _nw0 *m_EcdhEdkWrapping.EcdhUnwrap = m_EcdhEdkWrapping.New_EcdhUnwrap_()
		_ = _nw0
		_nw0.Ctor__(_14_providerInfoSenderPublicKey, _13_providerInfoRecipientPublicKey, _30_sharedSecret, Companion_Default___.RAW__ECDH__KEYRING__VERSION(), (_this).CurveSpec(), (_this).CryptoPrimitives())
		_31_ecdhUnwrap = _nw0
		var _32_unwrapOutputRes m_Wrappers.Result
		_ = _32_unwrapOutputRes
		var _out6 m_Wrappers.Result
		_ = _out6
		_out6 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial((edk).Dtor_ciphertext(), (_this).Materials(), _31_ecdhUnwrap)
		_32_unwrapOutputRes = _out6
		var _33_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_UnwrapEdkMaterialOutput_.Default(m_EcdhEdkWrapping.Companion_EcdhUnwrapInfo_.Default()))
		_ = _33_valueOrError10
		_33_valueOrError10 = _32_unwrapOutputRes
		if (_33_valueOrError10).IsFailure() {
			res = (_33_valueOrError10).PropagateFailure()
			return res
		}
		var _34_unwrapOutput m_EdkWrapping.UnwrapEdkMaterialOutput
		_ = _34_unwrapOutput
		_34_unwrapOutput = (_33_valueOrError10).Extract().(m_EdkWrapping.UnwrapEdkMaterialOutput)
		var _35_valueOrError11 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _35_valueOrError11
		_35_valueOrError11 = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey((_this).Materials(), (_34_unwrapOutput).Dtor_plaintextDataKey(), (_34_unwrapOutput).Dtor_symmetricSigningKey())
		if (_35_valueOrError11).IsFailure() {
			res = (_35_valueOrError11).PropagateFailure()
			return res
		}
		var _36_result m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _36_result
		_36_result = (_35_valueOrError11).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(_36_result)
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
func (_this *DecryptSingleEncryptedDataKey) SenderPublicKey() _dafny.Sequence {
	{
		return _this._senderPublicKey
	}
}
func (_this *DecryptSingleEncryptedDataKey) KeyAgreementScheme() m_AwsCryptographyMaterialProvidersTypes.RawEcdhStaticConfigurations {
	{
		return _this._keyAgreementScheme
	}
}
func (_this *DecryptSingleEncryptedDataKey) CurveSpec() m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec {
	{
		return _this._curveSpec
	}
}

// End of class DecryptSingleEncryptedDataKey
