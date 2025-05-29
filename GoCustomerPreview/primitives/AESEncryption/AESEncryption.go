// Package AESEncryption
// Dafny module AESEncryption compiled into Go

package AESEncryption

import (
	os "os"

	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Random "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Random"
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
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m_BoundedInts.Dummy__
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
var _ m_StandardLibrary_UInt.Dummy__
var _ m_StandardLibrary_MemoryMath.Dummy__
var _ m_StandardLibrary_Sequence.Dummy__
var _ m_StandardLibrary_String.Dummy__
var _ m_StandardLibrary.Dummy__
var _ m_Streams.Dummy__
var _ m_Sorting.Dummy__
var _ m_HexStrings.Dummy__
var _ m_GetOpt.Dummy__
var _ m_FloatCompare.Dummy__
var _ m_Base64.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_Actions.Dummy__
var _ m_AwsCryptographyPrimitivesTypes.Dummy__
var _ m_Random.Dummy__

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
	return "AESEncryption.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) EncryptionOutputFromByteSeq(s _dafny.Sequence, encAlg m_AwsCryptographyPrimitivesTypes.AES__GCM) m_AwsCryptographyPrimitivesTypes.AESEncryptOutput {
	var _0_pivot__point uint64 = (uint64((s).Cardinality())) - (func() uint64 { return (uint64((encAlg).Dtor_tagLength())) })()
	_ = _0_pivot__point
	var _1_cipherText _dafny.Sequence = (s).Take(uint32(_0_pivot__point))
	_ = _1_cipherText
	var _2_authTag _dafny.Sequence = (s).Drop(uint32(_0_pivot__point))
	_ = _2_authTag
	return m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Create_AESEncryptOutput_(_1_cipherText, _2_authTag)
}
func (_static *CompanionStruct_Default___) AESEncrypt(input m_AwsCryptographyPrimitivesTypes.AESEncryptInput) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
	_ = res
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(((uint64(((input).Dtor_iv()).Cardinality())) == (uint64(((input).Dtor_encAlg()).Dtor_ivLength()))) && ((uint64(((input).Dtor_key()).Cardinality())) == (uint64(((input).Dtor_encAlg()).Dtor_keyLength()))), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Request does not match algorithm.")))
	if (_0_valueOrError0).IsFailure() {
		res = (_0_valueOrError0).PropagateFailure()
		return res
	}
	var _let_tmp_rhs0 m_AwsCryptographyPrimitivesTypes.AESEncryptInput = input
	_ = _let_tmp_rhs0
	var _1_encAlg m_AwsCryptographyPrimitivesTypes.AES__GCM = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESEncryptInput_AESEncryptInput).EncAlg
	_ = _1_encAlg
	var _2_iv _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESEncryptInput_AESEncryptInput).Iv
	_ = _2_iv
	var _3_key _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESEncryptInput_AESEncryptInput).Key
	_ = _3_key
	var _4_msg _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESEncryptInput_AESEncryptInput).Msg
	_ = _4_msg
	var _5_aad _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESEncryptInput_AESEncryptInput).Aad
	_ = _5_aad
	var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
	_ = _6_valueOrError1
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AESEncryption.AES_GCM.AESEncryptExtern(_1_encAlg, _2_iv, _3_key, _4_msg, _5_aad)
	_6_valueOrError1 = _out0
	if (_6_valueOrError1).IsFailure() {
		res = (_6_valueOrError1).PropagateFailure()
		return res
	}
	var _7_value m_AwsCryptographyPrimitivesTypes.AESEncryptOutput
	_ = _7_value
	_7_value = (_6_valueOrError1).Extract().(m_AwsCryptographyPrimitivesTypes.AESEncryptOutput)
	var _8_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError2
	_8_valueOrError2 = m_Wrappers.Companion_Default___.Need((uint64(((_7_value).Dtor_cipherText()).Cardinality())) == (uint64((_4_msg).Cardinality())), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("AESEncrypt did not return cipherText of expected length")))
	if (_8_valueOrError2).IsFailure() {
		res = (_8_valueOrError2).PropagateFailure()
		return res
	}
	var _9_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _9_valueOrError3
	_9_valueOrError3 = m_Wrappers.Companion_Default___.Need((uint64(((_7_value).Dtor_authTag()).Cardinality())) == (uint64((_1_encAlg).Dtor_tagLength())), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("AESEncryption did not return valid tag")))
	if (_9_valueOrError3).IsFailure() {
		res = (_9_valueOrError3).PropagateFailure()
		return res
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(_7_value)
	return res
	return res
}
func (_static *CompanionStruct_Default___) AESDecrypt(input m_AwsCryptographyPrimitivesTypes.AESDecryptInput) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((uint64(((input).Dtor_key()).Cardinality())) == (uint64(((input).Dtor_encAlg()).Dtor_keyLength()))) && ((uint64(((input).Dtor_iv()).Cardinality())) == (uint64(((input).Dtor_encAlg()).Dtor_ivLength())))) && ((uint64(((input).Dtor_authTag()).Cardinality())) == (uint64(((input).Dtor_encAlg()).Dtor_tagLength()))), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("Request does not match algorithm.")))
	if (_0_valueOrError0).IsFailure() {
		res = (_0_valueOrError0).PropagateFailure()
		return res
	}
	var _let_tmp_rhs0 m_AwsCryptographyPrimitivesTypes.AESDecryptInput = input
	_ = _let_tmp_rhs0
	var _1_encAlg m_AwsCryptographyPrimitivesTypes.AES__GCM = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESDecryptInput_AESDecryptInput).EncAlg
	_ = _1_encAlg
	var _2_key _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESDecryptInput_AESDecryptInput).Key
	_ = _2_key
	var _3_cipherTxt _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESDecryptInput_AESDecryptInput).CipherTxt
	_ = _3_cipherTxt
	var _4_authTag _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESDecryptInput_AESDecryptInput).AuthTag
	_ = _4_authTag
	var _5_iv _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESDecryptInput_AESDecryptInput).Iv
	_ = _5_iv
	var _6_aad _dafny.Sequence = _let_tmp_rhs0.Get_().(m_AwsCryptographyPrimitivesTypes.AESDecryptInput_AESDecryptInput).Aad
	_ = _6_aad
	var _7_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _7_valueOrError1
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_AESEncryption.AES_GCM.AESDecryptExtern(_1_encAlg, _2_key, _3_cipherTxt, _4_authTag, _5_iv, _6_aad)
	_7_valueOrError1 = _out0
	if (_7_valueOrError1).IsFailure() {
		res = (_7_valueOrError1).PropagateFailure()
		return res
	}
	var _8_value _dafny.Sequence
	_ = _8_value
	_8_value = (_7_valueOrError1).Extract().(_dafny.Sequence)
	var _9_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _9_valueOrError2
	_9_valueOrError2 = m_Wrappers.Companion_Default___.Need((uint64((_3_cipherTxt).Cardinality())) == (uint64((_8_value).Cardinality())), m_AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.SeqOfString("AESDecrypt did not return plaintext of expected length")))
	if (_9_valueOrError2).IsFailure() {
		res = (_9_valueOrError2).PropagateFailure()
		return res
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(_8_value)
	return res
	return res
}
func (_static *CompanionStruct_Default___) CreateAESEncryptExternSuccess(output m_AwsCryptographyPrimitivesTypes.AESEncryptOutput) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(output)
}
func (_static *CompanionStruct_Default___) CreateAESEncryptExternFailure(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}
func (_static *CompanionStruct_Default___) CreateAESDecryptExternSuccess(bytes _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(bytes)
}
func (_static *CompanionStruct_Default___) CreateAESDecryptExternFailure(error_ m_AwsCryptographyPrimitivesTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}

// End of class Default__
