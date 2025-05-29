// Package AwsKmsUtils
// Dafny module AwsKmsUtils compiled into Go

package AwsKmsUtils

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
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
	return "AwsKmsUtils.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) OkForDecrypt(id m_AwsArnParsing.AwsKmsIdentifier, arn _dafny.Sequence) m_Wrappers.Outcome {
	if !((id).Is_AwsKmsArnIdentifier()) {
		return m_Wrappers.Companion_Outcome_.Create_Fail_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("KeyID cannot be used for Decrypt : "), arn)))
	} else if !_dafny.Companion_Sequence_.Equal((((id).Dtor_a()).Dtor_resource()).Dtor_resourceType(), _dafny.SeqOfString("key")) {
		return m_Wrappers.Companion_Outcome_.Create_Fail_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Alias cannot be used for Decrypt : "), arn)))
	} else {
		return m_Wrappers.Companion_Outcome_.Create_Pass_()
	}
}
func (_static *CompanionStruct_Default___) StringifyEncryptionContext(utf8EncCtx _dafny.Map) m_Wrappers.Result {
	if (uint64((utf8EncCtx).CardinalityInt())) == (uint64(0)) {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.NewMapBuilder().ToMap())
	} else {
		var _0_stringifyResults _dafny.Map = func() _dafny.Map {
			var _coll0 = _dafny.NewMapBuilder()
			_ = _coll0
			for _iter0 := _dafny.Iterate(((utf8EncCtx).Keys()).Elements()); ; {
				_compr_0, _ok0 := _iter0()
				if !_ok0 {
					break
				}
				var _1_utf8Key _dafny.Sequence
				_1_utf8Key = interface{}(_compr_0).(_dafny.Sequence)
				if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_1_utf8Key) {
					if ((utf8EncCtx).Keys()).Contains(_1_utf8Key) {
						_coll0.Add(_1_utf8Key, Companion_Default___.StringifyEncryptionContextPair(_1_utf8Key, (utf8EncCtx).Get(_1_utf8Key).(_dafny.Sequence)))
					}
				}
			}
			return _coll0.ToMap()
		}()
		_ = _0_stringifyResults
		if _dafny.Quantifier(((_0_stringifyResults).Values()).Elements(), false, func(_exists_var_0 m_Wrappers.Result) bool {
			var _2_r m_Wrappers.Result
			_2_r = interface{}(_exists_var_0).(m_Wrappers.Result)
			return (((_0_stringifyResults).Values()).Contains(_2_r)) && ((_2_r).Is_Failure())
		}) {
			return m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption context contains invalid UTF8")))
		} else {
			var _3_stringKeysUnique bool = _dafny.Quantifier((_0_stringifyResults).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
				var _4_k _dafny.Sequence
				_4_k = interface{}(_forall_var_0).(_dafny.Sequence)
				return _dafny.Quantifier((_0_stringifyResults).Keys().Elements(), true, func(_forall_var_1 _dafny.Sequence) bool {
					var _5_k_k _dafny.Sequence
					_5_k_k = interface{}(_forall_var_1).(_dafny.Sequence)
					return !(((_0_stringifyResults).Contains(_4_k)) && ((_0_stringifyResults).Contains(_5_k_k))) || (!(!_dafny.Companion_Sequence_.Equal(_4_k, _5_k_k)) || (!_dafny.Companion_Sequence_.Equal((*(((_0_stringifyResults).Get(_4_k).(m_Wrappers.Result)).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence), (*(((_0_stringifyResults).Get(_5_k_k).(m_Wrappers.Result)).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence))))
				})
			})
			_ = _3_stringKeysUnique
			if !(_3_stringKeysUnique) {
				return m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption context keys are not unique")))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(func() _dafny.Map {
					var _coll1 = _dafny.NewMapBuilder()
					_ = _coll1
					for _iter1 := _dafny.Iterate(((_0_stringifyResults).Values()).Elements()); ; {
						_compr_1, _ok1 := _iter1()
						if !_ok1 {
							break
						}
						var _6_r m_Wrappers.Result
						_6_r = interface{}(_compr_1).(m_Wrappers.Result)
						if ((_0_stringifyResults).Values()).Contains(_6_r) {
							_coll1.Add((*((_6_r).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence), (*((_6_r).Dtor_value().(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence))
						}
					}
					return _coll1.ToMap()
				}())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) StringifyEncryptionContextPair(utf8Key _dafny.Sequence, utf8Value _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (m_UTF8.Decode(utf8Key)).MapFailure(func(coer1 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg1 interface{}) interface{} {
			return coer1(arg1.(_dafny.Sequence))
		}
	}(Companion_Default___.WrapStringToError))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_key _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_key
		var _2_valueOrError1 m_Wrappers.Result = (m_UTF8.Decode(utf8Value)).MapFailure(func(coer2 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg2 interface{}) interface{} {
				return coer2(arg2.(_dafny.Sequence))
			}
		}(Companion_Default___.WrapStringToError))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_value _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_value
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_1_key, _3_value))
		}
	}
}
func (_static *CompanionStruct_Default___) WrapStringToError(e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(e)
}
func (_static *CompanionStruct_Default___) ValidateKmsKeyId(keyId _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (m_AwsArnParsing.Companion_Default___.ParseAwsKmsIdentifier(keyId)).MapFailure(func(coer3 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg3 interface{}) interface{} {
			return coer3(arg3.(_dafny.Sequence))
		}
	}(Companion_Default___.WrapStringToError))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1___v0 m_AwsArnParsing.AwsKmsIdentifier = (_0_valueOrError0).Extract().(m_AwsArnParsing.AwsKmsIdentifier)
		_ = _1___v0
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.IsASCIIString(keyId), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Key identifier is not ASCII")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((uint64(0)) < (uint64((keyId).Cardinality()))) && ((uint64((keyId).Cardinality())) <= (m_AwsArnParsing.Companion_Default___.MAX__AWS__KMS__IDENTIFIER__LENGTH())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Key identifier is too long")))
			_ = _3_valueOrError2
			if (_3_valueOrError2).IsFailure() {
				return (_3_valueOrError2).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) GetValidGrantTokens(grantTokens m_Wrappers.Option) m_Wrappers.Result {
	var _0_tokens _dafny.Sequence = (grantTokens).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence)
	_ = _0_tokens
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((uint64(0)) <= (uint64((_0_tokens).Cardinality()))) && ((uint64((_0_tokens).Cardinality())) <= (uint64(10))), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Grant token list can have no more than 10 tokens")))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((_0_tokens).UniqueElements(), true, func(_forall_var_0 _dafny.Sequence) bool {
			var _3_token _dafny.Sequence
			_3_token = interface{}(_forall_var_0).(_dafny.Sequence)
			return !(_dafny.Companion_Sequence_.Contains(_0_tokens, _3_token)) || (((uint64(1)) <= (uint64((_3_token).Cardinality()))) && ((uint64((_3_token).Cardinality())) <= (uint64(8192))))
		}), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Grant token list contains a grant token with invalid length")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(_0_tokens)
		}
	}
}
func (_static *CompanionStruct_Default___) GetEcdhPublicKey(client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_getPublicKeyRequest m_ComAmazonawsKmsTypes.GetPublicKeyRequest
	_ = _0_getPublicKeyRequest
	_0_getPublicKeyRequest = m_ComAmazonawsKmsTypes.Companion_GetPublicKeyRequest_.Create_GetPublicKeyRequest_(awsKmsKey, m_Wrappers.Companion_Option_.Create_None_())
	var _1_maybePublicKeyResponse m_Wrappers.Result
	_ = _1_maybePublicKeyResponse
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (client).GetPublicKey(_0_getPublicKeyRequest)
	_1_maybePublicKeyResponse = _out0
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_GetPublicKeyResponse_.Default())
	_ = _2_valueOrError0
	_2_valueOrError0 = (_1_maybePublicKeyResponse).MapFailure(func(coer4 func(m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg4 interface{}) interface{} {
			return coer4(arg4.(m_ComAmazonawsKmsTypes.Error))
		}
	}(func(_3_e m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_ComAmazonawsKms_(_3_e)
	}))
	if (_2_valueOrError0).IsFailure() {
		res = (_2_valueOrError0).PropagateFailure()
		return res
	}
	var _4_getPublicKeyResponse m_ComAmazonawsKmsTypes.GetPublicKeyResponse
	_ = _4_getPublicKeyResponse
	_4_getPublicKeyResponse = (_2_valueOrError0).Extract().(m_ComAmazonawsKmsTypes.GetPublicKeyResponse)
	var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _5_valueOrError1
	_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((((((_4_getPublicKeyResponse).Dtor_KeyId()).Is_Some()) && (_dafny.Companion_Sequence_.Equal(((_4_getPublicKeyResponse).Dtor_KeyId()).Dtor_value().(_dafny.Sequence), awsKmsKey))) && (((_4_getPublicKeyResponse).Dtor_KeyUsage()).Is_Some())) && ((((_4_getPublicKeyResponse).Dtor_KeyUsage()).Dtor_value().(m_ComAmazonawsKmsTypes.KeyUsageType)).Equals(m_ComAmazonawsKmsTypes.Companion_KeyUsageType_.Create_KEY__AGREEMENT_()))) && (((_4_getPublicKeyResponse).Dtor_PublicKey()).Is_Some()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from KMS GetPublicKey")))
	if (_5_valueOrError1).IsFailure() {
		res = (_5_valueOrError1).PropagateFailure()
		return res
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(((_4_getPublicKeyResponse).Dtor_PublicKey()).Dtor_value().(_dafny.Sequence))
	return res
	return res
}
func (_static *CompanionStruct_Default___) ParseKeyNamespaceAndName(keyNamespace _dafny.Sequence, keyName _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (m_UTF8.Encode(keyNamespace)).MapFailure(func(coer5 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg5 interface{}) interface{} {
			return coer5(arg5.(_dafny.Sequence))
		}
	}(func(_1_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Key namespace could not be UTF8-encoded"), _1_e))
	}))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _2_namespace _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _2_namespace
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64((_2_namespace).Cardinality())) < ((m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()).Uint64()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Key namespace too long")))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_valueOrError2 m_Wrappers.Result = (m_UTF8.Encode(keyName)).MapFailure(func(coer6 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
				return func(arg6 interface{}) interface{} {
					return coer6(arg6.(_dafny.Sequence))
				}
			}(func(_5_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
				return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Key name could not be UTF8-encoded"), _5_e))
			}))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _6_name _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
				_ = _6_name
				var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64((_6_name).Cardinality())) < ((m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()).Uint64()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Key name too long")))
				_ = _7_valueOrError3
				if (_7_valueOrError3).IsFailure() {
					return (_7_valueOrError3).PropagateFailure()
				} else {
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_2_namespace, _6_name))
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ValidateDiscoveryFilter(filter m_AwsCryptographyMaterialProvidersTypes.DiscoveryFilter) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(((filter).Dtor_accountIds()).Cardinality())) > (uint64(0)), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Discovery filter must have at least one account ID")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((filter).Dtor_accountIds()).UniqueElements(), true, func(_forall_var_0 _dafny.Sequence) bool {
			var _2_accountId _dafny.Sequence
			_2_accountId = interface{}(_forall_var_0).(_dafny.Sequence)
			return !(_dafny.Companion_Sequence_.Contains((filter).Dtor_accountIds(), _2_accountId)) || ((uint64((_2_accountId).Cardinality())) > (uint64(0)))
		}), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Discovery filter account IDs cannot be blank")))
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(((filter).Dtor_partition()).Cardinality())) > (uint64(0)), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Discovery filter partition cannot be blank")))
			_ = _3_valueOrError2
			if (_3_valueOrError2).IsFailure() {
				return (_3_valueOrError2).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
			}
		}
	}
}

// End of class Default__

// Definition of class OnDecryptMrkAwareEncryptedDataKeyFilter
type OnDecryptMrkAwareEncryptedDataKeyFilter struct {
	_awsKmsKey  m_AwsArnParsing.AwsKmsIdentifier
	_providerId _dafny.Sequence
}

func New_OnDecryptMrkAwareEncryptedDataKeyFilter_() *OnDecryptMrkAwareEncryptedDataKeyFilter {
	_this := OnDecryptMrkAwareEncryptedDataKeyFilter{}

	_this._awsKmsKey = m_AwsArnParsing.AwsKmsIdentifier{}
	_this._providerId = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
	return &_this
}

type CompanionStruct_OnDecryptMrkAwareEncryptedDataKeyFilter_ struct {
}

var Companion_OnDecryptMrkAwareEncryptedDataKeyFilter_ = CompanionStruct_OnDecryptMrkAwareEncryptedDataKeyFilter_{}

func (_this *OnDecryptMrkAwareEncryptedDataKeyFilter) Equals(other *OnDecryptMrkAwareEncryptedDataKeyFilter) bool {
	return _this == other
}

func (_this *OnDecryptMrkAwareEncryptedDataKeyFilter) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*OnDecryptMrkAwareEncryptedDataKeyFilter)
	return ok && _this.Equals(other)
}

func (*OnDecryptMrkAwareEncryptedDataKeyFilter) String() string {
	return "AwsKmsUtils.OnDecryptMrkAwareEncryptedDataKeyFilter"
}

func Type_OnDecryptMrkAwareEncryptedDataKeyFilter_() _dafny.TypeDescriptor {
	return type_OnDecryptMrkAwareEncryptedDataKeyFilter_{}
}

type type_OnDecryptMrkAwareEncryptedDataKeyFilter_ struct {
}

func (_this type_OnDecryptMrkAwareEncryptedDataKeyFilter_) Default() interface{} {
	return (*OnDecryptMrkAwareEncryptedDataKeyFilter)(nil)
}

func (_this type_OnDecryptMrkAwareEncryptedDataKeyFilter_) String() string {
	return "AwsKmsUtils.OnDecryptMrkAwareEncryptedDataKeyFilter"
}
func (_this *OnDecryptMrkAwareEncryptedDataKeyFilter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_DeterministicActionWithResult_.TraitID_, m_Actions.Companion_DeterministicAction_.TraitID_}
}

var _ m_Actions.DeterministicActionWithResult = &OnDecryptMrkAwareEncryptedDataKeyFilter{}
var _ m_Actions.DeterministicAction = &OnDecryptMrkAwareEncryptedDataKeyFilter{}
var _ _dafny.TraitOffspring = &OnDecryptMrkAwareEncryptedDataKeyFilter{}

func (_this *OnDecryptMrkAwareEncryptedDataKeyFilter) Ctor__(awsKmsKey m_AwsArnParsing.AwsKmsIdentifier, providerId _dafny.Sequence) {
	{
		(_this)._awsKmsKey = awsKmsKey
		(_this)._providerId = providerId
	}
}
func (_this *OnDecryptMrkAwareEncryptedDataKeyFilter) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = res
		if !_dafny.Companion_Sequence_.Equal((edk).Dtor_keyProviderId(), (_this).ProviderId()) {
			res = m_Wrappers.Companion_Result_.Create_Success_(false)
			return res
		}
		if !(m_UTF8.Companion_Default___.ValidUTF8Seq((edk).Dtor_keyProviderInfo())) {
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid AWS KMS encoding, provider info is not UTF8.")))
			return res
		}
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _0_valueOrError0
		_0_valueOrError0 = (m_UTF8.Decode((edk).Dtor_keyProviderInfo())).MapFailure(func(coer7 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg7 interface{}) interface{} {
				return coer7(arg7.(_dafny.Sequence))
			}
		}(Companion_Default___.WrapStringToError))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_keyId _dafny.Sequence
		_ = _1_keyId
		_1_keyId = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError1
		_2_valueOrError1 = (m_AwsArnParsing.Companion_Default___.ParseAwsKmsArn(_1_keyId)).MapFailure(func(coer8 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg8 interface{}) interface{} {
				return coer8(arg8.(_dafny.Sequence))
			}
		}(Companion_Default___.WrapStringToError))
		if (_2_valueOrError1).IsFailure() {
			res = (_2_valueOrError1).PropagateFailure()
			return res
		}
		var _3_arn m_AwsArnParsing.AwsArn
		_ = _3_arn
		_3_arn = (_2_valueOrError1).Extract().(m_AwsArnParsing.AwsArn)
		res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsKmsMrkMatchForDecrypt.Companion_Default___.AwsKmsMrkMatchForDecrypt((_this).AwsKmsKey(), m_AwsArnParsing.Companion_AwsKmsIdentifier_.Create_AwsKmsArnIdentifier_(_3_arn)))
		return res
		return res
	}
}
func (_this *OnDecryptMrkAwareEncryptedDataKeyFilter) AwsKmsKey() m_AwsArnParsing.AwsKmsIdentifier {
	{
		return _this._awsKmsKey
	}
}
func (_this *OnDecryptMrkAwareEncryptedDataKeyFilter) ProviderId() _dafny.Sequence {
	{
		return _this._providerId
	}
}

// End of class OnDecryptMrkAwareEncryptedDataKeyFilter
