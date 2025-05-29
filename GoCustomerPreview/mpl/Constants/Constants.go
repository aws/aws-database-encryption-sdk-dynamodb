// Package Constants
// Dafny module Constants compiled into Go

package Constants

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
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
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
	return "Constants.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ECDH__PROVIDER__INFO__RPL__INDEX() uint32 {
	return uint32(1)
}
func (_static *CompanionStruct_Default___) ECDH__PROVIDER__INFO__PUBLIC__KEY__LEN() uint64 {
	return uint64(4)
}
func (_static *CompanionStruct_Default___) ECDH__PROVIDER__INFO__RPK__INDEX() uint32 {
	return (Companion_Default___.ECDH__PROVIDER__INFO__RPL__INDEX()) + (uint32(Companion_Default___.ECDH__PROVIDER__INFO__PUBLIC__KEY__LEN()))
}
func (_static *CompanionStruct_Default___) ECDH__AES__256__ENC__KEY__LENGTH() int32 {
	return int32(32)
}
func (_static *CompanionStruct_Default___) ECDH__AES__256__ENC__TAG__LENGTH() int32 {
	return int32(16)
}
func (_static *CompanionStruct_Default___) ECDH__AES__256__ENC__IV__LENGTH() int32 {
	return int32(12)
}
func (_static *CompanionStruct_Default___) ECDH__AES__256__ENC__ALG() m_AwsCryptographyPrimitivesTypes.AES__GCM {
	return m_AwsCryptographyPrimitivesTypes.Companion_AES__GCM_.Create_AES__GCM_(Companion_Default___.ECDH__AES__256__ENC__KEY__LENGTH(), Companion_Default___.ECDH__AES__256__ENC__TAG__LENGTH(), Companion_Default___.ECDH__AES__256__ENC__IV__LENGTH())
}
func (_static *CompanionStruct_Default___) PROVIDER__ID() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(107), uint8(109), uint8(115))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) UINT32__TO__SEQ__LEN() uint64 {
	return uint64(4)
}
func (_static *CompanionStruct_Default___) KDF__SALT__LEN() int32 {
	return int32(32)
}
func (_static *CompanionStruct_Default___) KDF__EXPECTED__LEN() int32 {
	return int32(64)
}
func (_static *CompanionStruct_Default___) ECDH__COMMITMENT__KEY__LENGTH() uint64 {
	return uint64(32)
}
func (_static *CompanionStruct_Default___) ECDH__COMMITMENT__KEY__INDEX() uint64 {
	return uint64(32)
}
func (_static *CompanionStruct_Default___) ECDH__WRAPPED__KEY__MATERIAL__INDEX() uint64 {
	return uint64(64)
}
func (_static *CompanionStruct_Default___) ECDH__KDF__STRING() _dafny.Sequence {
	return _dafny.SeqOfString("ecdh-key-derivation")
}
func (_static *CompanionStruct_Default___) ECDH__KDF__PRF__STRING() _dafny.Sequence {
	return _dafny.SeqOfString("HMAC_SHA384")
}
func (_static *CompanionStruct_Default___) ECDH__KDF__DELIMITER() _dafny.Sequence {
	return _dafny.SeqOf(uint8(0))
}
func (_static *CompanionStruct_Default___) ECDH__PROVIDER__INFO__256__LEN() uint32 {
	return uint32(75)
}
func (_static *CompanionStruct_Default___) ECDH__PROVIDER__INFO__384__LEN() uint32 {
	return uint32(107)
}
func (_static *CompanionStruct_Default___) ECDH__PROVIDER__INFO__521__LEN() uint32 {
	return uint32(143)
}
func (_static *CompanionStruct_Default___) ECDH__PUBLIC__KEY__LEN__ECC__NIST__256() uint64 {
	return uint64(91)
}
func (_static *CompanionStruct_Default___) ECDH__PUBLIC__KEY__LEN__ECC__NIST__384() uint64 {
	return uint64(120)
}
func (_static *CompanionStruct_Default___) ECDH__PUBLIC__KEY__LEN__ECC__NIST__521() uint64 {
	return uint64(158)
}
func (_static *CompanionStruct_Default___) ECDH__PUBLIC__KEY__COMPRESSED__LEN__ECC__NIST__256() uint64 {
	return uint64(33)
}
func (_static *CompanionStruct_Default___) ECDH__PUBLIC__KEY__COMPRESSED__LEN__ECC__NIST__384() uint64 {
	return uint64(49)
}
func (_static *CompanionStruct_Default___) ECDH__PUBLIC__KEY__COMPRESSED__LEN__ECC__NIST__521() uint64 {
	return uint64(67)
}
func (_static *CompanionStruct_Default___) CIPHERTEXT__WRAPPED__MATERIAL__INDEX() uint64 {
	return uint64(68)
}
func (_static *CompanionStruct_Default___) PROVIDER__ID__HIERARCHY() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(107), uint8(109), uint8(115), uint8(45), uint8(104), uint8(105), uint8(101), uint8(114), uint8(97), uint8(114), uint8(99), uint8(104), uint8(121))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) RSA__PROVIDER__ID() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(107), uint8(109), uint8(115), uint8(45), uint8(114), uint8(115), uint8(97))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) KMS__ECDH__PROVIDER__ID() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(107), uint8(109), uint8(115), uint8(45), uint8(101), uint8(99), uint8(100), uint8(104))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) RAW__ECDH__PROVIDER__ID() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(114), uint8(97), uint8(119), uint8(45), uint8(101), uint8(99), uint8(100), uint8(104))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) ECDH__KDF__PRF__NAME() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(72), uint8(77), uint8(65), uint8(67), uint8(95), uint8(83), uint8(72), uint8(65), uint8(51), uint8(56), uint8(52))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) ECDH__KDF__UTF8() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(101), uint8(99), uint8(100), uint8(104), uint8(45), uint8(107), uint8(101), uint8(121), uint8(45), uint8(100), uint8(101), uint8(114), uint8(105), uint8(118), uint8(97), uint8(116), uint8(105), uint8(111), uint8(110))
	_ = _0_s
	return _0_s
}

// End of class Default__

// Definition of class AwsKmsEncryptedDataKey
type AwsKmsEncryptedDataKey struct {
}

func New_AwsKmsEncryptedDataKey_() *AwsKmsEncryptedDataKey {
	_this := AwsKmsEncryptedDataKey{}

	return &_this
}

type CompanionStruct_AwsKmsEncryptedDataKey_ struct {
}

var Companion_AwsKmsEncryptedDataKey_ = CompanionStruct_AwsKmsEncryptedDataKey_{}

func (*AwsKmsEncryptedDataKey) String() string {
	return "Constants.AwsKmsEncryptedDataKey"
}

// End of class AwsKmsEncryptedDataKey

func Type_AwsKmsEncryptedDataKey_() _dafny.TypeDescriptor {
	return type_AwsKmsEncryptedDataKey_{}
}

type type_AwsKmsEncryptedDataKey_ struct {
}

func (_this type_AwsKmsEncryptedDataKey_) Default() interface{} {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Default()
}

func (_this type_AwsKmsEncryptedDataKey_) String() string {
	return "Constants.AwsKmsEncryptedDataKey"
}
func (_this *CompanionStruct_AwsKmsEncryptedDataKey_) Is_(__source m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey) bool {
	var _1_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = (__source)
	_ = _1_edk
	return (_dafny.Companion_Sequence_.Equal((_1_edk).Dtor_keyProviderId(), Companion_Default___.PROVIDER__ID())) && (m_UTF8.Companion_Default___.ValidUTF8Seq((_1_edk).Dtor_keyProviderInfo()))
}

// Definition of datatype AwsKmsEdkHelper
type AwsKmsEdkHelper struct {
	Data_AwsKmsEdkHelper_
}

func (_this AwsKmsEdkHelper) Get_() Data_AwsKmsEdkHelper_ {
	return _this.Data_AwsKmsEdkHelper_
}

type Data_AwsKmsEdkHelper_ interface {
	isAwsKmsEdkHelper()
}

type CompanionStruct_AwsKmsEdkHelper_ struct {
}

var Companion_AwsKmsEdkHelper_ = CompanionStruct_AwsKmsEdkHelper_{}

type AwsKmsEdkHelper_AwsKmsEdkHelper struct {
	Edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
	Arn m_AwsArnParsing.AwsArn
}

func (AwsKmsEdkHelper_AwsKmsEdkHelper) isAwsKmsEdkHelper() {}

func (CompanionStruct_AwsKmsEdkHelper_) Create_AwsKmsEdkHelper_(Edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey, Arn m_AwsArnParsing.AwsArn) AwsKmsEdkHelper {
	return AwsKmsEdkHelper{AwsKmsEdkHelper_AwsKmsEdkHelper{Edk, Arn}}
}

func (_this AwsKmsEdkHelper) Is_AwsKmsEdkHelper() bool {
	_, ok := _this.Get_().(AwsKmsEdkHelper_AwsKmsEdkHelper)
	return ok
}

func (CompanionStruct_AwsKmsEdkHelper_) Default() AwsKmsEdkHelper {
	return Companion_AwsKmsEdkHelper_.Create_AwsKmsEdkHelper_(m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Default(), m_AwsArnParsing.Companion_AwsArn_.Default())
}

func (_this AwsKmsEdkHelper) Dtor_edk() m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey {
	return _this.Get_().(AwsKmsEdkHelper_AwsKmsEdkHelper).Edk
}

func (_this AwsKmsEdkHelper) Dtor_arn() m_AwsArnParsing.AwsArn {
	return _this.Get_().(AwsKmsEdkHelper_AwsKmsEdkHelper).Arn
}

func (_this AwsKmsEdkHelper) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AwsKmsEdkHelper_AwsKmsEdkHelper:
		{
			return "Constants.AwsKmsEdkHelper.AwsKmsEdkHelper" + "(" + _dafny.String(data.Edk) + ", " + _dafny.String(data.Arn) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AwsKmsEdkHelper) Equals(other AwsKmsEdkHelper) bool {
	switch data1 := _this.Get_().(type) {
	case AwsKmsEdkHelper_AwsKmsEdkHelper:
		{
			data2, ok := other.Get_().(AwsKmsEdkHelper_AwsKmsEdkHelper)
			return ok && data1.Edk.Equals(data2.Edk) && data1.Arn.Equals(data2.Arn)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AwsKmsEdkHelper) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AwsKmsEdkHelper)
	return ok && _this.Equals(typed)
}

func Type_AwsKmsEdkHelper_() _dafny.TypeDescriptor {
	return type_AwsKmsEdkHelper_{}
}

type type_AwsKmsEdkHelper_ struct {
}

func (_this type_AwsKmsEdkHelper_) Default() interface{} {
	return Companion_AwsKmsEdkHelper_.Default()
}

func (_this type_AwsKmsEdkHelper_) String() string {
	return "Constants.AwsKmsEdkHelper"
}
func (_this AwsKmsEdkHelper) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AwsKmsEdkHelper{}

// End of datatype AwsKmsEdkHelper
