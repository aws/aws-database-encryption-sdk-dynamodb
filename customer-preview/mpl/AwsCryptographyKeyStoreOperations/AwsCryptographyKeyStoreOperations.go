// Package AwsCryptographyKeyStoreOperations
// Dafny module AwsCryptographyKeyStoreOperations compiled into Go

package AwsCryptographyKeyStoreOperations

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
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
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
	m__Time "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Time_"
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
	return "AwsCryptographyKeyStoreOperations.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) GetKeyStoreInfo(config Config) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_GetKeyStoreInfoOutput_.Create_GetKeyStoreInfoOutput_((config).Dtor_id(), (config).Dtor_ddbTableName(), (config).Dtor_logicalKeyStoreName(), (config).Dtor_grantTokens(), (config).Dtor_kmsConfiguration()))
	return output
}
func (_static *CompanionStruct_Default___) CreateKeyStore(config Config, input m_AwsCryptographyKeyStoreTypes.CreateKeyStoreInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_CreateKeyStoreTable.Companion_Default___.CreateKeyStoreTable((config).Dtor_ddbTableName(), (config).Dtor_ddbClient())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_ddbTableArn _dafny.Sequence
	_ = _1_ddbTableArn
	_1_ddbTableArn = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_tableName m_Wrappers.Result
	_ = _2_tableName
	_2_tableName = m_AwsArnParsing.Companion_Default___.ParseAmazonDynamodbTableName(_1_ddbTableArn)
	var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError1
	_3_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_2_tableName).Is_Success()) && (_dafny.Companion_Sequence_.Equal((_2_tableName).Dtor_value().(_dafny.Sequence), (config).Dtor_ddbTableName())), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("Configured DDB Table Name does not match parsed Table Name from DDB Table Arn.")))
	if (_3_valueOrError1).IsFailure() {
		output = (_3_valueOrError1).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_CreateKeyStoreOutput_.Create_CreateKeyStoreOutput_(_1_ddbTableArn))
	return output
}
func (_static *CompanionStruct_Default___) CreateKey(config Config, input m_AwsCryptographyKeyStoreTypes.CreateKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_CreateKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(!(((input).Dtor_branchKeyIdentifier()).Is_Some()) || ((((input).Dtor_encryptionContext()).Is_Some()) && (((((input).Dtor_encryptionContext()).Dtor_value().(_dafny.Map)).Cardinality()).Sign() == 1)), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.CUSTOM__BRANCH__KEY__ID__NEED__EC()))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_KMSKeystoreOperations.Companion_Default___.HasKeyId((config).Dtor_kmsConfiguration()), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.DISCOVERY__CREATE__KEY__NOT__SUPPORTED()))
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_branchKeyIdentifier _dafny.Sequence = _dafny.EmptySeq.SetString()
	_ = _2_branchKeyIdentifier
	if ((input).Dtor_branchKeyIdentifier()).Is_None() {
		var _3_maybeBranchKeyId m_Wrappers.Result
		_ = _3_maybeBranchKeyId
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_UUID.GenerateUUID()
		_3_maybeBranchKeyId = _out0
		var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _4_valueOrError2
		_4_valueOrError2 = (_3_maybeBranchKeyId).MapFailure(func(coer19 func(_dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
			return func(arg19 interface{}) interface{} {
				return coer19(arg19.(_dafny.Sequence))
			}
		}(func(_5_e _dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error {
			return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_5_e)
		}))
		if (_4_valueOrError2).IsFailure() {
			output = (_4_valueOrError2).PropagateFailure()
			return output
		}
		_2_branchKeyIdentifier = (_4_valueOrError2).Extract().(_dafny.Sequence)
	} else {
		var _6_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _6_valueOrError3
		_6_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((((input).Dtor_branchKeyIdentifier()).Dtor_value().(_dafny.Sequence)).Cardinality())).Sign() == 1, m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("Custom branch key id can not be an empty string.")))
		if (_6_valueOrError3).IsFailure() {
			output = (_6_valueOrError3).PropagateFailure()
			return output
		}
		_2_branchKeyIdentifier = ((input).Dtor_branchKeyIdentifier()).Dtor_value().(_dafny.Sequence)
	}
	var _7_timestamp_q m_Wrappers.Result
	_ = _7_timestamp_q
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m__Time.GetCurrentTimeStamp()
	_7_timestamp_q = _out1
	var _8_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _8_valueOrError4
	_8_valueOrError4 = (_7_timestamp_q).MapFailure(func(coer20 func(_dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
		return func(arg20 interface{}) interface{} {
			return coer20(arg20.(_dafny.Sequence))
		}
	}(func(_9_e _dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error {
		return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_9_e)
	}))
	if (_8_valueOrError4).IsFailure() {
		output = (_8_valueOrError4).PropagateFailure()
		return output
	}
	var _10_timestamp _dafny.Sequence
	_ = _10_timestamp
	_10_timestamp = (_8_valueOrError4).Extract().(_dafny.Sequence)
	var _11_maybeBranchKeyVersion m_Wrappers.Result
	_ = _11_maybeBranchKeyVersion
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_UUID.GenerateUUID()
	_11_maybeBranchKeyVersion = _out2
	var _12_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _12_valueOrError5
	_12_valueOrError5 = (_11_maybeBranchKeyVersion).MapFailure(func(coer21 func(_dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
		return func(arg21 interface{}) interface{} {
			return coer21(arg21.(_dafny.Sequence))
		}
	}(func(_13_e _dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error {
		return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_13_e)
	}))
	if (_12_valueOrError5).IsFailure() {
		output = (_12_valueOrError5).PropagateFailure()
		return output
	}
	var _14_branchKeyVersion _dafny.Sequence
	_ = _14_branchKeyVersion
	_14_branchKeyVersion = (_12_valueOrError5).Extract().(_dafny.Sequence)
	var _15_unwrapEncryptionContext _dafny.Map
	_ = _15_unwrapEncryptionContext
	_15_unwrapEncryptionContext = ((input).Dtor_encryptionContext()).UnwrapOr(_dafny.NewMapBuilder().ToMap()).(_dafny.Map)
	var _16_encodedEncryptionContext _dafny.Set
	_ = _16_encodedEncryptionContext
	_16_encodedEncryptionContext = func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter7 := _dafny.Iterate((_15_unwrapEncryptionContext).Keys().Elements()); ; {
			_compr_0, _ok7 := _iter7()
			if !_ok7 {
				break
			}
			var _17_k _dafny.Sequence
			_17_k = interface{}(_compr_0).(_dafny.Sequence)
			if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_17_k) {
				if (_15_unwrapEncryptionContext).Contains(_17_k) {
					_coll0.Add(_dafny.TupleOf(m_UTF8.Decode(_17_k), m_UTF8.Decode((_15_unwrapEncryptionContext).Get(_17_k).(_dafny.Sequence)), _17_k))
				}
			}
		}
		return _coll0.ToSet()
	}()
	var _18_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _18_valueOrError6
	_18_valueOrError6 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((_16_encodedEncryptionContext).Elements(), true, func(_forall_var_0 _dafny.Tuple) bool {
		var _19_i _dafny.Tuple
		_19_i = interface{}(_forall_var_0).(_dafny.Tuple)
		return !((_16_encodedEncryptionContext).Contains(_19_i)) || ((((((*(_19_i).IndexInt(0)).(m_Wrappers.Result)).Is_Success()) && (((*(_19_i).IndexInt(1)).(m_Wrappers.Result)).Is_Success())) && (m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_dafny.Companion_Sequence_.Concatenate(m_Structure.Companion_Default___.ENCRYPTION__CONTEXT__PREFIX(), ((*(_19_i).IndexInt(0)).(m_Wrappers.Result)).Dtor_value().(_dafny.Sequence))))) && (func(_pat_let1_0 m_Wrappers.Result) bool {
			return func(_20_encoded m_Wrappers.Result) bool {
				return ((_20_encoded).Is_Success()) && (_dafny.Companion_Sequence_.Equal((*(_19_i).IndexInt(2)).(_dafny.Sequence), (_20_encoded).Dtor_value().(_dafny.Sequence)))
			}(_pat_let1_0)
		}(m_UTF8.Encode(((*(_19_i).IndexInt(0)).(m_Wrappers.Result)).Dtor_value().(_dafny.Sequence)))))
	}), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.UTF8__ENCODING__ENCRYPTION__CONTEXT__ERROR()))
	if (_18_valueOrError6).IsFailure() {
		output = (_18_valueOrError6).PropagateFailure()
		return output
	}
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_CreateKeys.Companion_Default___.CreateBranchAndBeaconKeys(_2_branchKeyIdentifier, func() _dafny.Map {
		var _coll1 = _dafny.NewMapBuilder()
		_ = _coll1
		for _iter8 := _dafny.Iterate((_16_encodedEncryptionContext).Elements()); ; {
			_compr_1, _ok8 := _iter8()
			if !_ok8 {
				break
			}
			var _21_i _dafny.Tuple
			_21_i = interface{}(_compr_1).(_dafny.Tuple)
			if (_16_encodedEncryptionContext).Contains(_21_i) {
				_coll1.Add(((*(_21_i).IndexInt(0)).(m_Wrappers.Result)).Dtor_value().(_dafny.Sequence), ((*(_21_i).IndexInt(1)).(m_Wrappers.Result)).Dtor_value().(_dafny.Sequence))
			}
		}
		return _coll1.ToMap()
	}(), _10_timestamp, _14_branchKeyVersion, (config).Dtor_ddbTableName(), (config).Dtor_logicalKeyStoreName(), (config).Dtor_kmsConfiguration(), (config).Dtor_grantTokens(), (config).Dtor_kmsClient(), (config).Dtor_ddbClient())
	output = _out3
	return output
}
func (_static *CompanionStruct_Default___) VersionKey(config Config, input m_AwsCryptographyKeyStoreTypes.VersionKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_VersionKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_KMSKeystoreOperations.Companion_Default___.HasKeyId((config).Dtor_kmsConfiguration()), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.DISCOVERY__VERSION__KEY__NOT__SUPPORTED()))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((input).Dtor_branchKeyIdentifier()).Cardinality())).Sign() == 1, m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.BRANCH__KEY__ID__NEEDED()))
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_timestamp_q m_Wrappers.Result
	_ = _2_timestamp_q
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m__Time.GetCurrentTimeStamp()
	_2_timestamp_q = _out0
	var _3_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _3_valueOrError2
	_3_valueOrError2 = (_2_timestamp_q).MapFailure(func(coer22 func(_dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
		return func(arg22 interface{}) interface{} {
			return coer22(arg22.(_dafny.Sequence))
		}
	}(func(_4_e _dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error {
		return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_4_e)
	}))
	if (_3_valueOrError2).IsFailure() {
		output = (_3_valueOrError2).PropagateFailure()
		return output
	}
	var _5_timestamp _dafny.Sequence
	_ = _5_timestamp
	_5_timestamp = (_3_valueOrError2).Extract().(_dafny.Sequence)
	var _6_maybeBranchKeyVersion m_Wrappers.Result
	_ = _6_maybeBranchKeyVersion
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_UUID.GenerateUUID()
	_6_maybeBranchKeyVersion = _out1
	var _7_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _7_valueOrError3
	_7_valueOrError3 = (_6_maybeBranchKeyVersion).MapFailure(func(coer23 func(_dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
		return func(arg23 interface{}) interface{} {
			return coer23(arg23.(_dafny.Sequence))
		}
	}(func(_8_e _dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error {
		return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_8_e)
	}))
	if (_7_valueOrError3).IsFailure() {
		output = (_7_valueOrError3).PropagateFailure()
		return output
	}
	var _9_branchKeyVersion _dafny.Sequence
	_ = _9_branchKeyVersion
	_9_branchKeyVersion = (_7_valueOrError3).Extract().(_dafny.Sequence)
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_CreateKeys.Companion_Default___.VersionActiveBranchKey(input, _5_timestamp, _9_branchKeyVersion, (config).Dtor_ddbTableName(), (config).Dtor_logicalKeyStoreName(), (config).Dtor_kmsConfiguration(), (config).Dtor_grantTokens(), (config).Dtor_kmsClient(), (config).Dtor_ddbClient())
	output = _out2
	return output
}
func (_static *CompanionStruct_Default___) GetActiveBranchKey(config Config, input m_AwsCryptographyKeyStoreTypes.GetActiveBranchKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetActiveBranchKeyOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_GetKeys.Companion_Default___.GetActiveKeyAndUnwrap(input, (config).Dtor_ddbTableName(), (config).Dtor_logicalKeyStoreName(), (config).Dtor_kmsConfiguration(), (config).Dtor_grantTokens(), (config).Dtor_kmsClient(), (config).Dtor_ddbClient())
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) GetBranchKeyVersion(config Config, input m_AwsCryptographyKeyStoreTypes.GetBranchKeyVersionInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetBranchKeyVersionOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_GetKeys.Companion_Default___.GetBranchKeyVersion(input, (config).Dtor_ddbTableName(), (config).Dtor_logicalKeyStoreName(), (config).Dtor_kmsConfiguration(), (config).Dtor_grantTokens(), (config).Dtor_kmsClient(), (config).Dtor_ddbClient())
	output = _out0
	return output
}
func (_static *CompanionStruct_Default___) GetBeaconKey(config Config, input m_AwsCryptographyKeyStoreTypes.GetBeaconKeyInput) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetBeaconKeyOutput_.Default())
	_ = output
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_GetKeys.Companion_Default___.GetBeaconKeyAndUnwrap(input, (config).Dtor_ddbTableName(), (config).Dtor_logicalKeyStoreName(), (config).Dtor_kmsConfiguration(), (config).Dtor_grantTokens(), (config).Dtor_kmsClient(), (config).Dtor_ddbClient())
	output = _out0
	return output
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
	Id                  _dafny.Sequence
	DdbTableName        _dafny.Sequence
	LogicalKeyStoreName _dafny.Sequence
	KmsConfiguration    m_AwsCryptographyKeyStoreTypes.KMSConfiguration
	GrantTokens         _dafny.Sequence
	KmsClient           m_ComAmazonawsKmsTypes.IKMSClient
	DdbClient           m_ComAmazonawsDynamodbTypes.IDynamoDBClient
}

func (Config_Config) isConfig() {}

func (CompanionStruct_Config_) Create_Config_(Id _dafny.Sequence, DdbTableName _dafny.Sequence, LogicalKeyStoreName _dafny.Sequence, KmsConfiguration m_AwsCryptographyKeyStoreTypes.KMSConfiguration, GrantTokens _dafny.Sequence, KmsClient m_ComAmazonawsKmsTypes.IKMSClient, DdbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient) Config {
	return Config{Config_Config{Id, DdbTableName, LogicalKeyStoreName, KmsConfiguration, GrantTokens, KmsClient, DdbClient}}
}

func (_this Config) Is_Config() bool {
	_, ok := _this.Get_().(Config_Config)
	return ok
}

func (CompanionStruct_Config_) Default() Config {
	return Companion_Config_.Create_Config_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_AwsCryptographyKeyStoreTypes.Companion_KMSConfiguration_.Default(), _dafny.EmptySeq, (m_ComAmazonawsKmsTypes.IKMSClient)(nil), (m_ComAmazonawsDynamodbTypes.IDynamoDBClient)(nil))
}

func (_this Config) Dtor_id() _dafny.Sequence {
	return _this.Get_().(Config_Config).Id
}

func (_this Config) Dtor_ddbTableName() _dafny.Sequence {
	return _this.Get_().(Config_Config).DdbTableName
}

func (_this Config) Dtor_logicalKeyStoreName() _dafny.Sequence {
	return _this.Get_().(Config_Config).LogicalKeyStoreName
}

func (_this Config) Dtor_kmsConfiguration() m_AwsCryptographyKeyStoreTypes.KMSConfiguration {
	return _this.Get_().(Config_Config).KmsConfiguration
}

func (_this Config) Dtor_grantTokens() _dafny.Sequence {
	return _this.Get_().(Config_Config).GrantTokens
}

func (_this Config) Dtor_kmsClient() m_ComAmazonawsKmsTypes.IKMSClient {
	return _this.Get_().(Config_Config).KmsClient
}

func (_this Config) Dtor_ddbClient() m_ComAmazonawsDynamodbTypes.IDynamoDBClient {
	return _this.Get_().(Config_Config).DdbClient
}

func (_this Config) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Config_Config:
		{
			return "AwsCryptographyKeyStoreOperations.Config.Config" + "(" + _dafny.String(data.Id) + ", " + _dafny.String(data.DdbTableName) + ", " + _dafny.String(data.LogicalKeyStoreName) + ", " + _dafny.String(data.KmsConfiguration) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.KmsClient) + ", " + _dafny.String(data.DdbClient) + ")"
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
			return ok && data1.Id.Equals(data2.Id) && data1.DdbTableName.Equals(data2.DdbTableName) && data1.LogicalKeyStoreName.Equals(data2.LogicalKeyStoreName) && data1.KmsConfiguration.Equals(data2.KmsConfiguration) && data1.GrantTokens.Equals(data2.GrantTokens) && _dafny.AreEqual(data1.KmsClient, data2.KmsClient) && _dafny.AreEqual(data1.DdbClient, data2.DdbClient)
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
	return "AwsCryptographyKeyStoreOperations.Config"
}
func (_this Config) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Config{}

// End of datatype Config
