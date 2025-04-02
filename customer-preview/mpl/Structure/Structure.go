// Package Structure
// Dafny module Structure compiled into Go

package Structure

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
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
	return "Structure.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) BranchKeyContext_q(m _dafny.Map) bool {
	return ((((((((((((((m).Contains(Companion_Default___.BRANCH__KEY__IDENTIFIER__FIELD())) && ((m).Contains(Companion_Default___.TYPE__FIELD()))) && ((m).Contains(Companion_Default___.KEY__CREATE__TIME()))) && ((m).Contains(Companion_Default___.HIERARCHY__VERSION()))) && ((m).Contains(Companion_Default___.TABLE__FIELD()))) && ((m).Contains(Companion_Default___.KMS__FIELD()))) && (m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__KeyIdType((m).Get(Companion_Default___.KMS__FIELD()).(_dafny.Sequence)))) && (!((m).Keys()).Contains(Companion_Default___.BRANCH__KEY__FIELD()))) && ((_dafny.IntOfUint32(((m).Get(Companion_Default___.BRANCH__KEY__IDENTIFIER__FIELD()).(_dafny.Sequence)).Cardinality())).Sign() == 1)) && ((_dafny.IntOfUint32(((m).Get(Companion_Default___.TYPE__FIELD()).(_dafny.Sequence)).Cardinality())).Sign() == 1)) && (_dafny.Quantifier(((m).Keys()).Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _0_k _dafny.Sequence
		_0_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !(((m).Keys()).Contains(_0_k)) || (m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_0_k))
	}))) && (((m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD())) == ((true) && (_dafny.Companion_Sequence_.Equal((m).Get(Companion_Default___.TYPE__FIELD()).(_dafny.Sequence), Companion_Default___.BRANCH__KEY__ACTIVE__TYPE()))))) && (!((m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD())) || ((true) && (_dafny.Companion_Sequence_.IsProperPrefixOf(Companion_Default___.BRANCH__KEY__TYPE__PREFIX(), (m).Get(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()).(_dafny.Sequence)))))) && ((!(m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD())) == ((_dafny.Companion_Sequence_.Equal((m).Get(Companion_Default___.TYPE__FIELD()).(_dafny.Sequence), Companion_Default___.BEACON__KEY__TYPE__VALUE())) || (_dafny.Companion_Sequence_.IsProperPrefixOf(Companion_Default___.BRANCH__KEY__TYPE__PREFIX(), (m).Get(Companion_Default___.TYPE__FIELD()).(_dafny.Sequence)))))
}
func (_static *CompanionStruct_Default___) ToAttributeMap(encryptionContext _dafny.Map, encryptedKey _dafny.Sequence) _dafny.Map {
	return func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter2 := _dafny.Iterate(((((encryptionContext).Keys()).Union(_dafny.SetOf(Companion_Default___.BRANCH__KEY__FIELD()))).Difference(_dafny.SetOf(Companion_Default___.TABLE__FIELD()))).Elements()); ; {
			_compr_0, _ok2 := _iter2()
			if !_ok2 {
				break
			}
			var _0_k _dafny.Sequence
			_0_k = interface{}(_compr_0).(_dafny.Sequence)
			if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_0_k) {
				if ((((encryptionContext).Keys()).Union(_dafny.SetOf(Companion_Default___.BRANCH__KEY__FIELD()))).Difference(_dafny.SetOf(Companion_Default___.TABLE__FIELD()))).Contains(_0_k) {
					_coll0.Add(_0_k, (func() m_ComAmazonawsDynamodbTypes.AttributeValue {
						if _dafny.Companion_Sequence_.Equal(_0_k, Companion_Default___.HIERARCHY__VERSION()) {
							return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_((encryptionContext).Get(Companion_Default___.HIERARCHY__VERSION()).(_dafny.Sequence))
						}
						return (func() m_ComAmazonawsDynamodbTypes.AttributeValue {
							if _dafny.Companion_Sequence_.Equal(_0_k, Companion_Default___.BRANCH__KEY__FIELD()) {
								return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(encryptedKey)
							}
							return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_((encryptionContext).Get(_0_k).(_dafny.Sequence))
						})()
					})())
				}
			}
		}
		return _coll0.ToMap()
	}()
}
func (_static *CompanionStruct_Default___) ToBranchKeyContext(item _dafny.Map, logicalKeyStoreName _dafny.Sequence) _dafny.Map {
	return func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter3 := _dafny.Iterate(((((item).Keys()).Difference(_dafny.SetOf(Companion_Default___.BRANCH__KEY__FIELD()))).Union(_dafny.SetOf(Companion_Default___.TABLE__FIELD()))).Elements()); ; {
			_compr_0, _ok3 := _iter3()
			if !_ok3 {
				break
			}
			var _0_k _dafny.Sequence
			_0_k = interface{}(_compr_0).(_dafny.Sequence)
			if ((((item).Keys()).Difference(_dafny.SetOf(Companion_Default___.BRANCH__KEY__FIELD()))).Union(_dafny.SetOf(Companion_Default___.TABLE__FIELD()))).Contains(_0_k) {
				_coll0.Add(_0_k, (func() _dafny.Sequence {
					if _dafny.Companion_Sequence_.Equal(_0_k, Companion_Default___.HIERARCHY__VERSION()) {
						return ((item).Get(_0_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_N()
					}
					return (func() _dafny.Sequence {
						if _dafny.Companion_Sequence_.Equal(_0_k, Companion_Default___.TABLE__FIELD()) {
							return logicalKeyStoreName
						}
						return ((item).Get(_0_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S()
					})()
				})())
			}
		}
		return _coll0.ToMap()
	}()
}
func (_static *CompanionStruct_Default___) ToBranchKeyMaterials(encryptionContext _dafny.Map, plaintextKey _dafny.Sequence) m_Wrappers.Result {
	var _0_versionInformation _dafny.Sequence = (func() _dafny.Sequence {
		if (encryptionContext).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()) {
			return (encryptionContext).Get(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()).(_dafny.Sequence)
		}
		return (encryptionContext).Get(Companion_Default___.TYPE__FIELD()).(_dafny.Sequence)
	})()
	_ = _0_versionInformation
	var _1_branchKeyVersion _dafny.Sequence = (_0_versionInformation).Drop((_dafny.IntOfUint32((Companion_Default___.BRANCH__KEY__TYPE__PREFIX()).Cardinality())).Uint32())
	_ = _1_branchKeyVersion
	var _2_valueOrError0 m_Wrappers.Result = (m_UTF8.Encode(_1_branchKeyVersion)).MapFailure(func(coer10 func(_dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
		return func(arg10 interface{}) interface{} {
			return coer10(arg10.(_dafny.Sequence))
		}
	}(func(_3_e _dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error {
		return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_3_e)
	}))
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		var _4_branchKeyVersionUtf8 _dafny.Sequence = (_2_valueOrError0).Extract().(_dafny.Sequence)
		_ = _4_branchKeyVersionUtf8
		var _5_valueOrError1 m_Wrappers.Result = Companion_Default___.ExtractCustomEncryptionContext(encryptionContext)
		_ = _5_valueOrError1
		if (_5_valueOrError1).IsFailure() {
			return (_5_valueOrError1).PropagateFailure()
		} else {
			var _6_customEncryptionContext _dafny.Map = (_5_valueOrError1).Extract().(_dafny.Map)
			_ = _6_customEncryptionContext
			return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_BranchKeyMaterials_.Create_BranchKeyMaterials_((encryptionContext).Get(Companion_Default___.BRANCH__KEY__IDENTIFIER__FIELD()).(_dafny.Sequence), _4_branchKeyVersionUtf8, _6_customEncryptionContext, plaintextKey))
		}
	}
}
func (_static *CompanionStruct_Default___) ToBeaconKeyMaterials(encryptionContext _dafny.Map, plaintextKey _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.ExtractCustomEncryptionContext(encryptionContext)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_customEncryptionContext _dafny.Map = (_0_valueOrError0).Extract().(_dafny.Map)
		_ = _1_customEncryptionContext
		return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_BeaconKeyMaterials_.Create_BeaconKeyMaterials_((encryptionContext).Get(Companion_Default___.BRANCH__KEY__IDENTIFIER__FIELD()).(_dafny.Sequence), _1_customEncryptionContext, m_Wrappers.Companion_Option_.Create_Some_(plaintextKey), m_Wrappers.Companion_Option_.Create_None_()))
	}
}
func (_static *CompanionStruct_Default___) ExtractCustomEncryptionContext(encryptionContext _dafny.Map) m_Wrappers.Result {
	var _0_encodedEncryptionContext _dafny.Set = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter4 := _dafny.Iterate((encryptionContext).Keys().Elements()); ; {
			_compr_0, _ok4 := _iter4()
			if !_ok4 {
				break
			}
			var _1_k _dafny.Sequence
			_1_k = interface{}(_compr_0).(_dafny.Sequence)
			if ((encryptionContext).Contains(_1_k)) && (_dafny.Companion_Sequence_.IsProperPrefixOf(Companion_Default___.ENCRYPTION__CONTEXT__PREFIX(), _1_k)) {
				_coll0.Add(_dafny.TupleOf(m_UTF8.Encode((_1_k).Drop((_dafny.IntOfUint32((Companion_Default___.ENCRYPTION__CONTEXT__PREFIX()).Cardinality())).Uint32())), m_UTF8.Encode((encryptionContext).Get(_1_k).(_dafny.Sequence))))
			}
		}
		return _coll0.ToSet()
	}()
	_ = _0_encodedEncryptionContext
	var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((_0_encodedEncryptionContext).Elements(), true, func(_forall_var_0 _dafny.Tuple) bool {
		var _3_i _dafny.Tuple
		_3_i = interface{}(_forall_var_0).(_dafny.Tuple)
		return !((_0_encodedEncryptionContext).Contains(_3_i)) || ((((*(_3_i).IndexInt(0)).(m_Wrappers.Result)).Is_Success()) && (((*(_3_i).IndexInt(1)).(m_Wrappers.Result)).Is_Success()))
	}), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("Unable to encode string")))
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(func() _dafny.Map {
			var _coll1 = _dafny.NewMapBuilder()
			_ = _coll1
			for _iter5 := _dafny.Iterate((_0_encodedEncryptionContext).Elements()); ; {
				_compr_1, _ok5 := _iter5()
				if !_ok5 {
					break
				}
				var _4_i _dafny.Tuple
				_4_i = interface{}(_compr_1).(_dafny.Tuple)
				if (_0_encodedEncryptionContext).Contains(_4_i) {
					_coll1.Add(((*(_4_i).IndexInt(0)).(m_Wrappers.Result)).Dtor_value().(_dafny.Sequence), ((*(_4_i).IndexInt(1)).(m_Wrappers.Result)).Dtor_value().(_dafny.Sequence))
				}
			}
			return _coll1.ToMap()
		}())
	}
}
func (_static *CompanionStruct_Default___) DecryptOnlyBranchKeyEncryptionContext(branchKeyId _dafny.Sequence, branchKeyVersion _dafny.Sequence, timestamp _dafny.Sequence, logicalKeyStoreName _dafny.Sequence, kmsKeyArn _dafny.Sequence, customEncryptionContext _dafny.Map) _dafny.Map {
	return (_dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.BRANCH__KEY__IDENTIFIER__FIELD(), branchKeyId).UpdateUnsafe(Companion_Default___.TYPE__FIELD(), _dafny.Companion_Sequence_.Concatenate(Companion_Default___.BRANCH__KEY__TYPE__PREFIX(), branchKeyVersion)).UpdateUnsafe(Companion_Default___.KEY__CREATE__TIME(), timestamp).UpdateUnsafe(Companion_Default___.TABLE__FIELD(), logicalKeyStoreName).UpdateUnsafe(Companion_Default___.KMS__FIELD(), kmsKeyArn).UpdateUnsafe(Companion_Default___.HIERARCHY__VERSION(), _dafny.SeqOfString("1"))).Merge(func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter6 := _dafny.Iterate((customEncryptionContext).Keys().Elements()); ; {
			_compr_0, _ok6 := _iter6()
			if !_ok6 {
				break
			}
			var _0_k _dafny.Sequence
			_0_k = interface{}(_compr_0).(_dafny.Sequence)
			if (customEncryptionContext).Contains(_0_k) {
				_coll0.Add(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.ENCRYPTION__CONTEXT__PREFIX(), _0_k), (customEncryptionContext).Get(_0_k).(_dafny.Sequence))
			}
		}
		return _coll0.ToMap()
	}())
}
func (_static *CompanionStruct_Default___) ActiveBranchKeyEncryptionContext(decryptOnlyEncryptionContext _dafny.Map) _dafny.Map {
	return (decryptOnlyEncryptionContext).Merge(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD(), (decryptOnlyEncryptionContext).Get(Companion_Default___.TYPE__FIELD()).(_dafny.Sequence)).UpdateUnsafe(Companion_Default___.TYPE__FIELD(), Companion_Default___.BRANCH__KEY__ACTIVE__TYPE()))
}
func (_static *CompanionStruct_Default___) BeaconKeyEncryptionContext(decryptOnlyEncryptionContext _dafny.Map) _dafny.Map {
	return (decryptOnlyEncryptionContext).Merge(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.TYPE__FIELD(), Companion_Default___.BEACON__KEY__TYPE__VALUE()))
}
func (_static *CompanionStruct_Default___) NewVersionFromActiveBranchKeyEncryptionContext(activeBranchKeyEncryptionContext _dafny.Map, branchKeyVersion _dafny.Sequence, timestamp _dafny.Sequence) _dafny.Map {
	return ((activeBranchKeyEncryptionContext).Merge(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.TYPE__FIELD(), _dafny.Companion_Sequence_.Concatenate(Companion_Default___.BRANCH__KEY__TYPE__PREFIX(), branchKeyVersion)).UpdateUnsafe(Companion_Default___.KEY__CREATE__TIME(), timestamp))).Subtract(_dafny.SetOf(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()))
}
func (_static *CompanionStruct_Default___) BranchKeyItem_q(m _dafny.Map) bool {
	return (((((((((((((((((((((m).Contains(Companion_Default___.BRANCH__KEY__IDENTIFIER__FIELD())) && (((m).Get(Companion_Default___.BRANCH__KEY__IDENTIFIER__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_S())) && ((m).Contains(Companion_Default___.TYPE__FIELD()))) && (((m).Get(Companion_Default___.TYPE__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_S())) && ((m).Contains(Companion_Default___.KEY__CREATE__TIME()))) && (((m).Get(Companion_Default___.KEY__CREATE__TIME()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_S())) && ((m).Contains(Companion_Default___.HIERARCHY__VERSION()))) && (((m).Get(Companion_Default___.HIERARCHY__VERSION()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_N())) && (!(m).Contains(Companion_Default___.TABLE__FIELD()))) && ((m).Contains(Companion_Default___.KMS__FIELD()))) && (((m).Get(Companion_Default___.KMS__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_S())) && (m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__KeyIdType(((m).Get(Companion_Default___.KMS__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S()))) && ((m).Contains(Companion_Default___.BRANCH__KEY__FIELD()))) && (((m).Get(Companion_Default___.BRANCH__KEY__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_B())) && ((_dafny.IntOfUint32((((m).Get(Companion_Default___.BRANCH__KEY__IDENTIFIER__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S()).Cardinality())).Sign() == 1)) && ((_dafny.IntOfUint32((((m).Get(Companion_Default___.TYPE__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S()).Cardinality())).Sign() == 1)) && (_dafny.Quantifier((((m).Keys()).Difference(_dafny.SetOf(Companion_Default___.BRANCH__KEY__FIELD(), Companion_Default___.HIERARCHY__VERSION()))).Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _0_k _dafny.Sequence
		_0_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !((((m).Keys()).Difference(_dafny.SetOf(Companion_Default___.BRANCH__KEY__FIELD(), Companion_Default___.HIERARCHY__VERSION()))).Contains(_0_k)) || (((m).Get(_0_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_S())
	}))) && (((m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD())) == ((true) && (_dafny.Companion_Sequence_.Equal(((m).Get(Companion_Default___.TYPE__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S(), Companion_Default___.BRANCH__KEY__ACTIVE__TYPE()))))) && (!((m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD())) || ((true) && (_dafny.Companion_Sequence_.IsProperPrefixOf(Companion_Default___.BRANCH__KEY__TYPE__PREFIX(), ((m).Get(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S()))))) && ((!(m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD())) == ((_dafny.Companion_Sequence_.Equal(((m).Get(Companion_Default___.TYPE__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S(), Companion_Default___.BEACON__KEY__TYPE__VALUE())) || (_dafny.Companion_Sequence_.IsProperPrefixOf(Companion_Default___.BRANCH__KEY__TYPE__PREFIX(), ((m).Get(Companion_Default___.TYPE__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S()))))) && (m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__CiphertextType(((m).Get(Companion_Default___.BRANCH__KEY__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_B()))
}
func (_static *CompanionStruct_Default___) ActiveBranchKeyItem_q(m _dafny.Map) bool {
	return ((((Companion_Default___.BranchKeyItem_q(m)) && (_dafny.Companion_Sequence_.Equal(((m).Get(Companion_Default___.TYPE__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S(), Companion_Default___.BRANCH__KEY__ACTIVE__TYPE()))) && ((m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()))) && (((m).Get(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Is_S())) && (_dafny.Companion_Sequence_.IsProperPrefixOf(Companion_Default___.BRANCH__KEY__TYPE__PREFIX(), ((m).Get(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S()))
}
func (_static *CompanionStruct_Default___) VersionBranchKeyItem_q(m _dafny.Map) bool {
	return ((Companion_Default___.BranchKeyItem_q(m)) && (!(m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()))) && (_dafny.Companion_Sequence_.IsProperPrefixOf(Companion_Default___.BRANCH__KEY__TYPE__PREFIX(), ((m).Get(Companion_Default___.TYPE__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S()))
}
func (_static *CompanionStruct_Default___) BeaconKeyItem_q(m _dafny.Map) bool {
	return ((Companion_Default___.BranchKeyItem_q(m)) && (!(m).Contains(Companion_Default___.BRANCH__KEY__ACTIVE__VERSION__FIELD()))) && (_dafny.Companion_Sequence_.Equal(((m).Get(Companion_Default___.TYPE__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_S(), Companion_Default___.BEACON__KEY__TYPE__VALUE()))
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__IDENTIFIER__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("branch-key-id")
}
func (_static *CompanionStruct_Default___) TYPE__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("type")
}
func (_static *CompanionStruct_Default___) KEY__CREATE__TIME() _dafny.Sequence {
	return _dafny.SeqOfString("create-time")
}
func (_static *CompanionStruct_Default___) HIERARCHY__VERSION() _dafny.Sequence {
	return _dafny.SeqOfString("hierarchy-version")
}
func (_static *CompanionStruct_Default___) TABLE__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("tablename")
}
func (_static *CompanionStruct_Default___) KMS__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("kms-arn")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("enc")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__ACTIVE__VERSION__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("version")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__ACTIVE__TYPE() _dafny.Sequence {
	return _dafny.SeqOfString("branch:ACTIVE")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__TYPE__PREFIX() _dafny.Sequence {
	return _dafny.SeqOfString("branch:version:")
}
func (_static *CompanionStruct_Default___) BEACON__KEY__TYPE__VALUE() _dafny.Sequence {
	return _dafny.SeqOfString("beacon:ACTIVE")
}
func (_static *CompanionStruct_Default___) ENCRYPTION__CONTEXT__PREFIX() _dafny.Sequence {
	return _dafny.SeqOfString("aws-crypto-ec:")
}

// End of class Default__

// Definition of class BranchKeyContext
type BranchKeyContext struct {
}

func New_BranchKeyContext_() *BranchKeyContext {
	_this := BranchKeyContext{}

	return &_this
}

type CompanionStruct_BranchKeyContext_ struct {
}

var Companion_BranchKeyContext_ = CompanionStruct_BranchKeyContext_{}

func (*BranchKeyContext) String() string {
	return "Structure.BranchKeyContext"
}

// End of class BranchKeyContext

func Type_BranchKeyContext_() _dafny.TypeDescriptor {
	return type_BranchKeyContext_{}
}

type type_BranchKeyContext_ struct {
}

func (_this type_BranchKeyContext_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_BranchKeyContext_) String() string {
	return "Structure.BranchKeyContext"
}
func (_this *CompanionStruct_BranchKeyContext_) Is_(__source _dafny.Map) bool {
	var _0_m _dafny.Map = (__source)
	_ = _0_m
	return Companion_Default___.BranchKeyContext_q(_0_m)
}

// Definition of class BranchKeyItem
type BranchKeyItem struct {
}

func New_BranchKeyItem_() *BranchKeyItem {
	_this := BranchKeyItem{}

	return &_this
}

type CompanionStruct_BranchKeyItem_ struct {
}

var Companion_BranchKeyItem_ = CompanionStruct_BranchKeyItem_{}

func (*BranchKeyItem) String() string {
	return "Structure.BranchKeyItem"
}

// End of class BranchKeyItem

func Type_BranchKeyItem_() _dafny.TypeDescriptor {
	return type_BranchKeyItem_{}
}

type type_BranchKeyItem_ struct {
}

func (_this type_BranchKeyItem_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_BranchKeyItem_) String() string {
	return "Structure.BranchKeyItem"
}
func (_this *CompanionStruct_BranchKeyItem_) Is_(__source _dafny.Map) bool {
	var _1_m _dafny.Map = (__source)
	_ = _1_m
	return Companion_Default___.BranchKeyItem_q(_1_m)
}

// Definition of class ActiveBranchKeyItem
type ActiveBranchKeyItem struct {
}

func New_ActiveBranchKeyItem_() *ActiveBranchKeyItem {
	_this := ActiveBranchKeyItem{}

	return &_this
}

type CompanionStruct_ActiveBranchKeyItem_ struct {
}

var Companion_ActiveBranchKeyItem_ = CompanionStruct_ActiveBranchKeyItem_{}

func (*ActiveBranchKeyItem) String() string {
	return "Structure.ActiveBranchKeyItem"
}

// End of class ActiveBranchKeyItem

func Type_ActiveBranchKeyItem_() _dafny.TypeDescriptor {
	return type_ActiveBranchKeyItem_{}
}

type type_ActiveBranchKeyItem_ struct {
}

func (_this type_ActiveBranchKeyItem_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_ActiveBranchKeyItem_) String() string {
	return "Structure.ActiveBranchKeyItem"
}
func (_this *CompanionStruct_ActiveBranchKeyItem_) Is_(__source _dafny.Map) bool {
	var _2_m _dafny.Map = (__source)
	_ = _2_m
	return Companion_Default___.ActiveBranchKeyItem_q(_2_m)
}

// Definition of class VersionBranchKeyItem
type VersionBranchKeyItem struct {
}

func New_VersionBranchKeyItem_() *VersionBranchKeyItem {
	_this := VersionBranchKeyItem{}

	return &_this
}

type CompanionStruct_VersionBranchKeyItem_ struct {
}

var Companion_VersionBranchKeyItem_ = CompanionStruct_VersionBranchKeyItem_{}

func (*VersionBranchKeyItem) String() string {
	return "Structure.VersionBranchKeyItem"
}

// End of class VersionBranchKeyItem

func Type_VersionBranchKeyItem_() _dafny.TypeDescriptor {
	return type_VersionBranchKeyItem_{}
}

type type_VersionBranchKeyItem_ struct {
}

func (_this type_VersionBranchKeyItem_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_VersionBranchKeyItem_) String() string {
	return "Structure.VersionBranchKeyItem"
}
func (_this *CompanionStruct_VersionBranchKeyItem_) Is_(__source _dafny.Map) bool {
	var _3_m _dafny.Map = (__source)
	_ = _3_m
	return Companion_Default___.VersionBranchKeyItem_q(_3_m)
}

// Definition of class BeaconKeyItem
type BeaconKeyItem struct {
}

func New_BeaconKeyItem_() *BeaconKeyItem {
	_this := BeaconKeyItem{}

	return &_this
}

type CompanionStruct_BeaconKeyItem_ struct {
}

var Companion_BeaconKeyItem_ = CompanionStruct_BeaconKeyItem_{}

func (*BeaconKeyItem) String() string {
	return "Structure.BeaconKeyItem"
}

// End of class BeaconKeyItem

func Type_BeaconKeyItem_() _dafny.TypeDescriptor {
	return type_BeaconKeyItem_{}
}

type type_BeaconKeyItem_ struct {
}

func (_this type_BeaconKeyItem_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_BeaconKeyItem_) String() string {
	return "Structure.BeaconKeyItem"
}
func (_this *CompanionStruct_BeaconKeyItem_) Is_(__source _dafny.Map) bool {
	var _4_m _dafny.Map = (__source)
	_ = _4_m
	return Companion_Default___.BeaconKeyItem_q(_4_m)
}
