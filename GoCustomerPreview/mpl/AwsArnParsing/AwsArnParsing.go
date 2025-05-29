// Package AwsArnParsing
// Dafny module AwsArnParsing compiled into Go

package AwsArnParsing

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
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
	return "AwsArnParsing.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ValidAwsKmsResource(resource AwsResource) bool {
	return ((resource).Valid()) && ((_dafny.Companion_Sequence_.Equal((resource).Dtor_resourceType(), _dafny.SeqOfString("key"))) || (_dafny.Companion_Sequence_.Equal((resource).Dtor_resourceType(), _dafny.SeqOfString("alias"))))
}
func (_static *CompanionStruct_Default___) ValidAwsKmsArn(arn AwsArn) bool {
	return (((arn).Valid()) && (_dafny.Companion_Sequence_.Equal((arn).Dtor_service(), _dafny.SeqOfString("kms")))) && (Companion_Default___.ValidAwsKmsResource((arn).Dtor_resource()))
}
func (_static *CompanionStruct_Default___) ParseAwsKmsRawResources(identifier _dafny.Sequence) m_Wrappers.Result {
	var _0_info _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(identifier, _dafny.Char('/'))
	_ = _0_info
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!_dafny.Companion_Sequence_.Equal((_0_info).Select(uint32(uint32(0))).(_dafny.Sequence), _dafny.SeqOfString("key")), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed raw key id: "), identifier))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		if (uint64((_0_info).Cardinality())) == (uint64(1)) {
			return Companion_Default___.ParseAwsKmsResources(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("key/"), identifier))
		} else {
			return Companion_Default___.ParseAwsKmsResources(identifier)
		}
	}
}
func (_static *CompanionStruct_Default___) ParseAwsKmsResources(identifier _dafny.Sequence) m_Wrappers.Result {
	var _0_info _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(identifier, _dafny.Char('/'))
	_ = _0_info
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64((_0_info).Cardinality())) > (uint64(1)), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed resource: "), identifier))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_resourceType _dafny.Sequence = (_0_info).Select(uint32(uint32(0))).(_dafny.Sequence)
		_ = _2_resourceType
		var _3_value _dafny.Sequence = m_StandardLibrary.Companion_Default___.Join((_0_info).Drop(uint32(uint32(1))), _dafny.SeqOfString("/"))
		_ = _3_value
		var _4_resource AwsResource = Companion_AwsResource_.Create_AwsResource_(_2_resourceType, _3_value)
		_ = _4_resource
		var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidAwsKmsResource(_4_resource), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed resource: "), identifier))
		_ = _5_valueOrError1
		if (_5_valueOrError1).IsFailure() {
			return (_5_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(_4_resource)
		}
	}
}
func (_static *CompanionStruct_Default___) ValidAmazonDynamodbResource(resource AwsResource) bool {
	return ((resource).Valid()) && (_dafny.Companion_Sequence_.Equal((resource).Dtor_resourceType(), _dafny.SeqOfString("table")))
}
func (_static *CompanionStruct_Default___) ValidAmazonDynamodbArn(arn AwsArn) bool {
	return (((arn).Valid()) && (_dafny.Companion_Sequence_.Equal((arn).Dtor_service(), _dafny.SeqOfString("dynamodb")))) && (Companion_Default___.ValidAmazonDynamodbResource((arn).Dtor_resource()))
}
func (_static *CompanionStruct_Default___) ParseAmazonDynamodbResources(identifier _dafny.Sequence) m_Wrappers.Result {
	var _0_info m_Wrappers.Option = m_StandardLibrary.Companion_Default___.SplitOnce_q(identifier, _dafny.Char('/'))
	_ = _0_info
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_0_info).Is_Some(), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed resource: "), identifier))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_resourceType _dafny.Sequence = (*((_0_info).Dtor_value().(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)
		_ = _2_resourceType
		var _3_value _dafny.Sequence = (*((_0_info).Dtor_value().(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence)
		_ = _3_value
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TableName(_3_value), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Table Name invalid: "), identifier))
		_ = _4_valueOrError1
		if (_4_valueOrError1).IsFailure() {
			return (_4_valueOrError1).PropagateFailure()
		} else {
			var _5_resource AwsResource = Companion_AwsResource_.Create_AwsResource_(_2_resourceType, _3_value)
			_ = _5_resource
			var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidAmazonDynamodbResource(_5_resource), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed resource: "), identifier))
			_ = _6_valueOrError2
			if (_6_valueOrError2).IsFailure() {
				return (_6_valueOrError2).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_5_resource)
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ParseAwsKmsArn(identifier _dafny.Sequence) m_Wrappers.Result {
	var _0_components _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(identifier, _dafny.Char(':'))
	_ = _0_components
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(6)) == (uint64((_0_components).Cardinality())), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed arn: "), identifier))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.ParseAwsKmsResources((_0_components).Select(uint32(uint32(5))).(_dafny.Sequence))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_resource AwsResource = (_2_valueOrError1).Extract().(AwsResource)
			_ = _3_resource
			var _4_arn AwsArn = Companion_AwsArn_.Create_AwsArn_((_0_components).Select(uint32(uint32(0))).(_dafny.Sequence), (_0_components).Select(uint32(uint32(1))).(_dafny.Sequence), (_0_components).Select(uint32(uint32(2))).(_dafny.Sequence), (_0_components).Select(uint32(uint32(3))).(_dafny.Sequence), (_0_components).Select(uint32(uint32(4))).(_dafny.Sequence), _3_resource)
			_ = _4_arn
			var _5_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidAwsKmsArn(_4_arn), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed Arn:"), identifier))
			_ = _5_valueOrError2
			if (_5_valueOrError2).IsFailure() {
				return (_5_valueOrError2).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_4_arn)
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ParseAmazonDynamodbTableArn(identifier _dafny.Sequence) m_Wrappers.Result {
	var _0_components _dafny.Sequence = m_StandardLibrary.Companion_Default___.Split(identifier, _dafny.Char(':'))
	_ = _0_components
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(6)) == (uint64((_0_components).Cardinality())), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed arn: "), identifier))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.ParseAmazonDynamodbResources((_0_components).Select(uint32(uint32(5))).(_dafny.Sequence))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_resource AwsResource = (_2_valueOrError1).Extract().(AwsResource)
			_ = _3_resource
			var _4_arn AwsArn = Companion_AwsArn_.Create_AwsArn_((_0_components).Select(uint32(uint32(0))).(_dafny.Sequence), (_0_components).Select(uint32(uint32(1))).(_dafny.Sequence), (_0_components).Select(uint32(uint32(2))).(_dafny.Sequence), (_0_components).Select(uint32(uint32(3))).(_dafny.Sequence), (_0_components).Select(uint32(uint32(4))).(_dafny.Sequence), _3_resource)
			_ = _4_arn
			var _5_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidAmazonDynamodbArn(_4_arn), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Malformed Arn:"), identifier))
			_ = _5_valueOrError2
			if (_5_valueOrError2).IsFailure() {
				return (_5_valueOrError2).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_4_arn)
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ParseAwsKmsIdentifier(identifier _dafny.Sequence) m_Wrappers.Result {
	if _dafny.Companion_Sequence_.IsPrefixOf(_dafny.SeqOfString("arn:"), identifier) {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.ParseAwsKmsArn(identifier)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_arn AwsArn = (_0_valueOrError0).Extract().(AwsArn)
			_ = _1_arn
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_AwsKmsIdentifier_.Create_AwsKmsArnIdentifier_(_1_arn))
		}
	} else {
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.ParseAwsKmsRawResources(identifier)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_r AwsResource = (_2_valueOrError1).Extract().(AwsResource)
			_ = _3_r
			return m_Wrappers.Companion_Result_.Create_Success_(Companion_AwsKmsIdentifier_.Create_AwsKmsRawResourceIdentifier_(_3_r))
		}
	}
}
func (_static *CompanionStruct_Default___) ParseAmazonDynamodbTableName(identifier _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.ParseAmazonDynamodbTableArn(identifier)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_arn AwsArn = (_0_valueOrError0).Extract().(AwsArn)
		_ = _1_arn
		var _2_tableArn AmazonDynamodbTableName = Companion_AmazonDynamodbTableName_.Create_AmazonDynamodbTableArn_(_1_arn)
		_ = _2_tableArn
		var _3_tableName _dafny.Sequence = (_2_tableArn).GetTableName()
		_ = _3_tableName
		return m_Wrappers.Companion_Result_.Create_Success_(_3_tableName)
	}
}
func (_static *CompanionStruct_Default___) IsMultiRegionAwsKmsArn(arn AwsArn) bool {
	return Companion_Default___.IsMultiRegionAwsKmsResource((arn).Dtor_resource())
}
func (_static *CompanionStruct_Default___) IsMultiRegionAwsKmsIdentifier(identifier AwsKmsIdentifier) bool {
	var _source0 AwsKmsIdentifier = identifier
	_ = _source0
	{
		if _source0.Is_AwsKmsArnIdentifier() {
			var _0_arn AwsArn = _source0.Get_().(AwsKmsIdentifier_AwsKmsArnIdentifier).A
			_ = _0_arn
			return Companion_Default___.IsMultiRegionAwsKmsArn(_0_arn)
		}
	}
	{
		var _1_r AwsResource = _source0.Get_().(AwsKmsIdentifier_AwsKmsRawResourceIdentifier).R
		_ = _1_r
		return Companion_Default___.IsMultiRegionAwsKmsResource(_1_r)
	}
}
func (_static *CompanionStruct_Default___) IsMultiRegionAwsKmsResource(resource AwsResource) bool {
	return (_dafny.Companion_Sequence_.Equal((resource).Dtor_resourceType(), _dafny.SeqOfString("key"))) && (_dafny.Companion_Sequence_.IsPrefixOf(_dafny.SeqOfString("mrk-"), (resource).Dtor_value()))
}
func (_static *CompanionStruct_Default___) GetRegion(identifier AwsKmsIdentifier) m_Wrappers.Option {
	var _source0 AwsKmsIdentifier = identifier
	_ = _source0
	{
		if _source0.Is_AwsKmsArnIdentifier() {
			var _0_a AwsArn = _source0.Get_().(AwsKmsIdentifier_AwsKmsArnIdentifier).A
			_ = _0_a
			return m_Wrappers.Companion_Option_.Create_Some_((_0_a).Dtor_region())
		}
	}
	{
		return m_Wrappers.Companion_Option_.Create_None_()
	}
}
func (_static *CompanionStruct_Default___) IsAwsKmsIdentifierString(s _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.IsASCIIString(s), _dafny.SeqOfString("Not a valid ASCII string."))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((uint64(0)) < (uint64((s).Cardinality()))) && ((uint64((s).Cardinality())) <= (Companion_Default___.MAX__AWS__KMS__IDENTIFIER__LENGTH())), _dafny.SeqOfString("Identifier exceeds maximum length."))
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			return Companion_Default___.ParseAwsKmsIdentifier(s)
		}
	}
}
func (_static *CompanionStruct_Default___) Error(s _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(s)
}
func (_static *CompanionStruct_Default___) ValidateDdbTableArn(tableArn _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = (Companion_Default___.ParseAmazonDynamodbTableName(tableArn)).MapFailure(func(coer0 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg0 interface{}) interface{} {
			return coer0(arg0.(_dafny.Sequence))
		}
	}(Companion_Default___.Error))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1___v1 _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1___v1
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.IsASCIIString(tableArn), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Table Arn is not ASCII")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TableName((Companion_Default___.ParseAmazonDynamodbTableName(tableArn)).Dtor_value().(_dafny.Sequence)), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Table Name is too long")))
			_ = _3_valueOrError2
			if (_3_valueOrError2).IsFailure() {
				return (_3_valueOrError2).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) MAX__AWS__KMS__IDENTIFIER__LENGTH() uint64 {
	return uint64(2048)
}

// End of class Default__

// Definition of datatype AwsResource
type AwsResource struct {
	Data_AwsResource_
}

func (_this AwsResource) Get_() Data_AwsResource_ {
	return _this.Data_AwsResource_
}

type Data_AwsResource_ interface {
	isAwsResource()
}

type CompanionStruct_AwsResource_ struct {
}

var Companion_AwsResource_ = CompanionStruct_AwsResource_{}

type AwsResource_AwsResource struct {
	ResourceType _dafny.Sequence
	Value        _dafny.Sequence
}

func (AwsResource_AwsResource) isAwsResource() {}

func (CompanionStruct_AwsResource_) Create_AwsResource_(ResourceType _dafny.Sequence, Value _dafny.Sequence) AwsResource {
	return AwsResource{AwsResource_AwsResource{ResourceType, Value}}
}

func (_this AwsResource) Is_AwsResource() bool {
	_, ok := _this.Get_().(AwsResource_AwsResource)
	return ok
}

func (CompanionStruct_AwsResource_) Default() AwsResource {
	return Companion_AwsResource_.Create_AwsResource_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this AwsResource) Dtor_resourceType() _dafny.Sequence {
	return _this.Get_().(AwsResource_AwsResource).ResourceType
}

func (_this AwsResource) Dtor_value() _dafny.Sequence {
	return _this.Get_().(AwsResource_AwsResource).Value
}

func (_this AwsResource) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AwsResource_AwsResource:
		{
			return "AwsArnParsing.AwsResource.AwsResource" + "(" + _dafny.String(data.ResourceType) + ", " + _dafny.String(data.Value) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AwsResource) Equals(other AwsResource) bool {
	switch data1 := _this.Get_().(type) {
	case AwsResource_AwsResource:
		{
			data2, ok := other.Get_().(AwsResource_AwsResource)
			return ok && data1.ResourceType.Equals(data2.ResourceType) && data1.Value.Equals(data2.Value)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AwsResource) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AwsResource)
	return ok && _this.Equals(typed)
}

func Type_AwsResource_() _dafny.TypeDescriptor {
	return type_AwsResource_{}
}

type type_AwsResource_ struct {
}

func (_this type_AwsResource_) Default() interface{} {
	return Companion_AwsResource_.Default()
}

func (_this type_AwsResource_) String() string {
	return "AwsArnParsing.AwsResource"
}
func (_this AwsResource) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AwsResource{}

func (_this AwsResource) Valid() bool {
	{
		return (true) && ((uint64(0)) < (uint64(((_this).Dtor_value()).Cardinality())))
	}
}
func (_this AwsResource) ToString() _dafny.Sequence {
	{
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((_this).Dtor_resourceType(), _dafny.SeqOfString("/")), (_this).Dtor_value())
	}
}

// End of datatype AwsResource

// Definition of datatype AwsArn
type AwsArn struct {
	Data_AwsArn_
}

func (_this AwsArn) Get_() Data_AwsArn_ {
	return _this.Data_AwsArn_
}

type Data_AwsArn_ interface {
	isAwsArn()
}

type CompanionStruct_AwsArn_ struct {
}

var Companion_AwsArn_ = CompanionStruct_AwsArn_{}

type AwsArn_AwsArn struct {
	ArnLiteral _dafny.Sequence
	Partition  _dafny.Sequence
	Service    _dafny.Sequence
	Region     _dafny.Sequence
	Account    _dafny.Sequence
	Resource   AwsResource
}

func (AwsArn_AwsArn) isAwsArn() {}

func (CompanionStruct_AwsArn_) Create_AwsArn_(ArnLiteral _dafny.Sequence, Partition _dafny.Sequence, Service _dafny.Sequence, Region _dafny.Sequence, Account _dafny.Sequence, Resource AwsResource) AwsArn {
	return AwsArn{AwsArn_AwsArn{ArnLiteral, Partition, Service, Region, Account, Resource}}
}

func (_this AwsArn) Is_AwsArn() bool {
	_, ok := _this.Get_().(AwsArn_AwsArn)
	return ok
}

func (CompanionStruct_AwsArn_) Default() AwsArn {
	return Companion_AwsArn_.Create_AwsArn_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), Companion_AwsResource_.Default())
}

func (_this AwsArn) Dtor_arnLiteral() _dafny.Sequence {
	return _this.Get_().(AwsArn_AwsArn).ArnLiteral
}

func (_this AwsArn) Dtor_partition() _dafny.Sequence {
	return _this.Get_().(AwsArn_AwsArn).Partition
}

func (_this AwsArn) Dtor_service() _dafny.Sequence {
	return _this.Get_().(AwsArn_AwsArn).Service
}

func (_this AwsArn) Dtor_region() _dafny.Sequence {
	return _this.Get_().(AwsArn_AwsArn).Region
}

func (_this AwsArn) Dtor_account() _dafny.Sequence {
	return _this.Get_().(AwsArn_AwsArn).Account
}

func (_this AwsArn) Dtor_resource() AwsResource {
	return _this.Get_().(AwsArn_AwsArn).Resource
}

func (_this AwsArn) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AwsArn_AwsArn:
		{
			return "AwsArnParsing.AwsArn.AwsArn" + "(" + _dafny.String(data.ArnLiteral) + ", " + _dafny.String(data.Partition) + ", " + _dafny.String(data.Service) + ", " + _dafny.String(data.Region) + ", " + _dafny.String(data.Account) + ", " + _dafny.String(data.Resource) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AwsArn) Equals(other AwsArn) bool {
	switch data1 := _this.Get_().(type) {
	case AwsArn_AwsArn:
		{
			data2, ok := other.Get_().(AwsArn_AwsArn)
			return ok && data1.ArnLiteral.Equals(data2.ArnLiteral) && data1.Partition.Equals(data2.Partition) && data1.Service.Equals(data2.Service) && data1.Region.Equals(data2.Region) && data1.Account.Equals(data2.Account) && data1.Resource.Equals(data2.Resource)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AwsArn) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AwsArn)
	return ok && _this.Equals(typed)
}

func Type_AwsArn_() _dafny.TypeDescriptor {
	return type_AwsArn_{}
}

type type_AwsArn_ struct {
}

func (_this type_AwsArn_) Default() interface{} {
	return Companion_AwsArn_.Default()
}

func (_this type_AwsArn_) String() string {
	return "AwsArnParsing.AwsArn"
}
func (_this AwsArn) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AwsArn{}

func (_this AwsArn) Valid() bool {
	{
		return (((((_dafny.Companion_Sequence_.Equal((_this).Dtor_arnLiteral(), _dafny.SeqOfString("arn"))) && ((uint64(0)) < (uint64(((_this).Dtor_partition()).Cardinality())))) && ((uint64(0)) < (uint64(((_this).Dtor_service()).Cardinality())))) && ((uint64(0)) < (uint64(((_this).Dtor_region()).Cardinality())))) && ((uint64(0)) < (uint64(((_this).Dtor_account()).Cardinality())))) && (((_this).Dtor_resource()).Valid())
	}
}
func (_this AwsArn) ToString() _dafny.Sequence {
	{
		return (_this).ToArnString(m_Wrappers.Companion_Option_.Create_None_())
	}
}
func (_this AwsArn) ToArnString(customRegion m_Wrappers.Option) _dafny.Sequence {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		var _source0 m_Wrappers.Option = customRegion
		_ = _source0
		{
			if _source0.Is_None() {
				var _in0 AwsArn = _this
				_ = _in0
				var _in1 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_((_this).Dtor_region())
				_ = _in1
				_this = _in0

				customRegion = _in1
				goto TAIL_CALL_START
			}
		}
		{
			var _0_customRegion _dafny.Sequence = _source0.Get_().(m_Wrappers.Option_Some).Value.(_dafny.Sequence)
			_ = _0_customRegion
			return m_StandardLibrary.Companion_Default___.Join(_dafny.SeqOf((_this).Dtor_arnLiteral(), (_this).Dtor_partition(), (_this).Dtor_service(), _0_customRegion, (_this).Dtor_account(), ((_this).Dtor_resource()).ToString()), _dafny.SeqOfString(":"))
		}
	}
}

// End of datatype AwsArn

// Definition of class AwsKmsArn
type AwsKmsArn struct {
}

func New_AwsKmsArn_() *AwsKmsArn {
	_this := AwsKmsArn{}

	return &_this
}

type CompanionStruct_AwsKmsArn_ struct {
}

var Companion_AwsKmsArn_ = CompanionStruct_AwsKmsArn_{}

func (*AwsKmsArn) String() string {
	return "AwsArnParsing.AwsKmsArn"
}

// End of class AwsKmsArn

func Type_AwsKmsArn_() _dafny.TypeDescriptor {
	return type_AwsKmsArn_{}
}

type type_AwsKmsArn_ struct {
}

func (_this type_AwsKmsArn_) Default() interface{} {
	return Companion_AwsArn_.Default()
}

func (_this type_AwsKmsArn_) String() string {
	return "AwsArnParsing.AwsKmsArn"
}
func (_this *CompanionStruct_AwsKmsArn_) Is_(__source AwsArn) bool {
	var _1_a AwsArn = (__source)
	_ = _1_a
	return Companion_Default___.ValidAwsKmsArn(_1_a)
}

// Definition of class AwsKmsResource
type AwsKmsResource struct {
}

func New_AwsKmsResource_() *AwsKmsResource {
	_this := AwsKmsResource{}

	return &_this
}

type CompanionStruct_AwsKmsResource_ struct {
}

var Companion_AwsKmsResource_ = CompanionStruct_AwsKmsResource_{}

func (*AwsKmsResource) String() string {
	return "AwsArnParsing.AwsKmsResource"
}

// End of class AwsKmsResource

func Type_AwsKmsResource_() _dafny.TypeDescriptor {
	return type_AwsKmsResource_{}
}

type type_AwsKmsResource_ struct {
}

func (_this type_AwsKmsResource_) Default() interface{} {
	return Companion_AwsResource_.Default()
}

func (_this type_AwsKmsResource_) String() string {
	return "AwsArnParsing.AwsKmsResource"
}
func (_this *CompanionStruct_AwsKmsResource_) Is_(__source AwsResource) bool {
	var _2_r AwsResource = (__source)
	_ = _2_r
	return Companion_Default___.ValidAwsKmsResource(_2_r)
}

// Definition of datatype AwsKmsIdentifier
type AwsKmsIdentifier struct {
	Data_AwsKmsIdentifier_
}

func (_this AwsKmsIdentifier) Get_() Data_AwsKmsIdentifier_ {
	return _this.Data_AwsKmsIdentifier_
}

type Data_AwsKmsIdentifier_ interface {
	isAwsKmsIdentifier()
}

type CompanionStruct_AwsKmsIdentifier_ struct {
}

var Companion_AwsKmsIdentifier_ = CompanionStruct_AwsKmsIdentifier_{}

type AwsKmsIdentifier_AwsKmsArnIdentifier struct {
	A AwsArn
}

func (AwsKmsIdentifier_AwsKmsArnIdentifier) isAwsKmsIdentifier() {}

func (CompanionStruct_AwsKmsIdentifier_) Create_AwsKmsArnIdentifier_(A AwsArn) AwsKmsIdentifier {
	return AwsKmsIdentifier{AwsKmsIdentifier_AwsKmsArnIdentifier{A}}
}

func (_this AwsKmsIdentifier) Is_AwsKmsArnIdentifier() bool {
	_, ok := _this.Get_().(AwsKmsIdentifier_AwsKmsArnIdentifier)
	return ok
}

type AwsKmsIdentifier_AwsKmsRawResourceIdentifier struct {
	R AwsResource
}

func (AwsKmsIdentifier_AwsKmsRawResourceIdentifier) isAwsKmsIdentifier() {}

func (CompanionStruct_AwsKmsIdentifier_) Create_AwsKmsRawResourceIdentifier_(R AwsResource) AwsKmsIdentifier {
	return AwsKmsIdentifier{AwsKmsIdentifier_AwsKmsRawResourceIdentifier{R}}
}

func (_this AwsKmsIdentifier) Is_AwsKmsRawResourceIdentifier() bool {
	_, ok := _this.Get_().(AwsKmsIdentifier_AwsKmsRawResourceIdentifier)
	return ok
}

func (CompanionStruct_AwsKmsIdentifier_) Default() AwsKmsIdentifier {
	return Companion_AwsKmsIdentifier_.Create_AwsKmsArnIdentifier_(Companion_AwsArn_.Default())
}

func (_this AwsKmsIdentifier) Dtor_a() AwsArn {
	return _this.Get_().(AwsKmsIdentifier_AwsKmsArnIdentifier).A
}

func (_this AwsKmsIdentifier) Dtor_r() AwsResource {
	return _this.Get_().(AwsKmsIdentifier_AwsKmsRawResourceIdentifier).R
}

func (_this AwsKmsIdentifier) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AwsKmsIdentifier_AwsKmsArnIdentifier:
		{
			return "AwsArnParsing.AwsKmsIdentifier.AwsKmsArnIdentifier" + "(" + _dafny.String(data.A) + ")"
		}
	case AwsKmsIdentifier_AwsKmsRawResourceIdentifier:
		{
			return "AwsArnParsing.AwsKmsIdentifier.AwsKmsRawResourceIdentifier" + "(" + _dafny.String(data.R) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AwsKmsIdentifier) Equals(other AwsKmsIdentifier) bool {
	switch data1 := _this.Get_().(type) {
	case AwsKmsIdentifier_AwsKmsArnIdentifier:
		{
			data2, ok := other.Get_().(AwsKmsIdentifier_AwsKmsArnIdentifier)
			return ok && data1.A.Equals(data2.A)
		}
	case AwsKmsIdentifier_AwsKmsRawResourceIdentifier:
		{
			data2, ok := other.Get_().(AwsKmsIdentifier_AwsKmsRawResourceIdentifier)
			return ok && data1.R.Equals(data2.R)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AwsKmsIdentifier) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AwsKmsIdentifier)
	return ok && _this.Equals(typed)
}

func Type_AwsKmsIdentifier_() _dafny.TypeDescriptor {
	return type_AwsKmsIdentifier_{}
}

type type_AwsKmsIdentifier_ struct {
}

func (_this type_AwsKmsIdentifier_) Default() interface{} {
	return Companion_AwsKmsIdentifier_.Default()
}

func (_this type_AwsKmsIdentifier_) String() string {
	return "AwsArnParsing.AwsKmsIdentifier"
}
func (_this AwsKmsIdentifier) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AwsKmsIdentifier{}

func (_this AwsKmsIdentifier) ToString() _dafny.Sequence {
	{
		var _source0 AwsKmsIdentifier = _this
		_ = _source0
		{
			if _source0.Is_AwsKmsArnIdentifier() {
				var _0_a AwsArn = _source0.Get_().(AwsKmsIdentifier_AwsKmsArnIdentifier).A
				_ = _0_a
				return (_0_a).ToString()
			}
		}
		{
			var _1_r AwsResource = _source0.Get_().(AwsKmsIdentifier_AwsKmsRawResourceIdentifier).R
			_ = _1_r
			return (_1_r).ToString()
		}
	}
}

// End of datatype AwsKmsIdentifier

// Definition of class AmazonDynamodbTableArn
type AmazonDynamodbTableArn struct {
}

func New_AmazonDynamodbTableArn_() *AmazonDynamodbTableArn {
	_this := AmazonDynamodbTableArn{}

	return &_this
}

type CompanionStruct_AmazonDynamodbTableArn_ struct {
}

var Companion_AmazonDynamodbTableArn_ = CompanionStruct_AmazonDynamodbTableArn_{}

func (*AmazonDynamodbTableArn) String() string {
	return "AwsArnParsing.AmazonDynamodbTableArn"
}

// End of class AmazonDynamodbTableArn

func Type_AmazonDynamodbTableArn_() _dafny.TypeDescriptor {
	return type_AmazonDynamodbTableArn_{}
}

type type_AmazonDynamodbTableArn_ struct {
}

func (_this type_AmazonDynamodbTableArn_) Default() interface{} {
	return Companion_AwsArn_.Default()
}

func (_this type_AmazonDynamodbTableArn_) String() string {
	return "AwsArnParsing.AmazonDynamodbTableArn"
}
func (_this *CompanionStruct_AmazonDynamodbTableArn_) Is_(__source AwsArn) bool {
	var _2_a AwsArn = (__source)
	_ = _2_a
	return Companion_Default___.ValidAmazonDynamodbArn(_2_a)
}

// Definition of class AmazonDynamodbResource
type AmazonDynamodbResource struct {
}

func New_AmazonDynamodbResource_() *AmazonDynamodbResource {
	_this := AmazonDynamodbResource{}

	return &_this
}

type CompanionStruct_AmazonDynamodbResource_ struct {
}

var Companion_AmazonDynamodbResource_ = CompanionStruct_AmazonDynamodbResource_{}

func (*AmazonDynamodbResource) String() string {
	return "AwsArnParsing.AmazonDynamodbResource"
}

// End of class AmazonDynamodbResource

func Type_AmazonDynamodbResource_() _dafny.TypeDescriptor {
	return type_AmazonDynamodbResource_{}
}

type type_AmazonDynamodbResource_ struct {
}

func (_this type_AmazonDynamodbResource_) Default() interface{} {
	return Companion_AwsResource_.Default()
}

func (_this type_AmazonDynamodbResource_) String() string {
	return "AwsArnParsing.AmazonDynamodbResource"
}
func (_this *CompanionStruct_AmazonDynamodbResource_) Is_(__source AwsResource) bool {
	var _3_r AwsResource = (__source)
	_ = _3_r
	return Companion_Default___.ValidAmazonDynamodbResource(_3_r)
}

// Definition of datatype AmazonDynamodbTableName
type AmazonDynamodbTableName struct {
	Data_AmazonDynamodbTableName_
}

func (_this AmazonDynamodbTableName) Get_() Data_AmazonDynamodbTableName_ {
	return _this.Data_AmazonDynamodbTableName_
}

type Data_AmazonDynamodbTableName_ interface {
	isAmazonDynamodbTableName()
}

type CompanionStruct_AmazonDynamodbTableName_ struct {
}

var Companion_AmazonDynamodbTableName_ = CompanionStruct_AmazonDynamodbTableName_{}

type AmazonDynamodbTableName_AmazonDynamodbTableArn struct {
	A AwsArn
}

func (AmazonDynamodbTableName_AmazonDynamodbTableArn) isAmazonDynamodbTableName() {}

func (CompanionStruct_AmazonDynamodbTableName_) Create_AmazonDynamodbTableArn_(A AwsArn) AmazonDynamodbTableName {
	return AmazonDynamodbTableName{AmazonDynamodbTableName_AmazonDynamodbTableArn{A}}
}

func (_this AmazonDynamodbTableName) Is_AmazonDynamodbTableArn() bool {
	_, ok := _this.Get_().(AmazonDynamodbTableName_AmazonDynamodbTableArn)
	return ok
}

func (CompanionStruct_AmazonDynamodbTableName_) Default() AmazonDynamodbTableName {
	return Companion_AmazonDynamodbTableName_.Create_AmazonDynamodbTableArn_(Companion_AwsArn_.Default())
}

func (_this AmazonDynamodbTableName) Dtor_a() AwsArn {
	return _this.Get_().(AmazonDynamodbTableName_AmazonDynamodbTableArn).A
}

func (_this AmazonDynamodbTableName) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AmazonDynamodbTableName_AmazonDynamodbTableArn:
		{
			return "AwsArnParsing.AmazonDynamodbTableName.AmazonDynamodbTableArn" + "(" + _dafny.String(data.A) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AmazonDynamodbTableName) Equals(other AmazonDynamodbTableName) bool {
	switch data1 := _this.Get_().(type) {
	case AmazonDynamodbTableName_AmazonDynamodbTableArn:
		{
			data2, ok := other.Get_().(AmazonDynamodbTableName_AmazonDynamodbTableArn)
			return ok && data1.A.Equals(data2.A)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AmazonDynamodbTableName) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AmazonDynamodbTableName)
	return ok && _this.Equals(typed)
}

func Type_AmazonDynamodbTableName_() _dafny.TypeDescriptor {
	return type_AmazonDynamodbTableName_{}
}

type type_AmazonDynamodbTableName_ struct {
}

func (_this type_AmazonDynamodbTableName_) Default() interface{} {
	return Companion_AmazonDynamodbTableName_.Default()
}

func (_this type_AmazonDynamodbTableName_) String() string {
	return "AwsArnParsing.AmazonDynamodbTableName"
}
func (_this AmazonDynamodbTableName) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AmazonDynamodbTableName{}

func (_this AmazonDynamodbTableName) GetTableName() _dafny.Sequence {
	{
		var _source0 AmazonDynamodbTableName = _this
		_ = _source0
		{
			var _0_a AwsArn = _source0.Get_().(AmazonDynamodbTableName_AmazonDynamodbTableArn).A
			_ = _0_a
			return ((_0_a).Dtor_resource()).Dtor_value()
		}
	}
}

// End of datatype AmazonDynamodbTableName

// Definition of class AwsKmsIdentifierString
type AwsKmsIdentifierString struct {
}

func New_AwsKmsIdentifierString_() *AwsKmsIdentifierString {
	_this := AwsKmsIdentifierString{}

	return &_this
}

type CompanionStruct_AwsKmsIdentifierString_ struct {
}

var Companion_AwsKmsIdentifierString_ = CompanionStruct_AwsKmsIdentifierString_{}

func (*AwsKmsIdentifierString) String() string {
	return "AwsArnParsing.AwsKmsIdentifierString"
}

// End of class AwsKmsIdentifierString

func Type_AwsKmsIdentifierString_() _dafny.TypeDescriptor {
	return type_AwsKmsIdentifierString_{}
}

type type_AwsKmsIdentifierString_ struct {
}

func (_this type_AwsKmsIdentifierString_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_AwsKmsIdentifierString_) String() string {
	return "AwsArnParsing.AwsKmsIdentifierString"
}
func (_this *CompanionStruct_AwsKmsIdentifierString_) Is_(__source _dafny.Sequence) bool {
	var _1_s _dafny.Sequence = (__source)
	_ = _1_s
	return (Companion_Default___.IsAwsKmsIdentifierString(_1_s)).Is_Success()
}
