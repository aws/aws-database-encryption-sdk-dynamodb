// Package StandardLibrary_Sequence
// Dafny module StandardLibrary_Sequence compiled into Go

package StandardLibrary_Sequence

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_DivInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternals"
	m_DivInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternalsNonlinear"
	m_DivMod "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivMod"
	m_FileIO "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FileIO"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m_GeneralInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GeneralInternals"
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
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
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
	return "StandardLibrary_Sequence.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) MapWithResult(f func(interface{}) m_Wrappers.Result, xs _dafny.Sequence, pos uint64, acc _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((xs).Cardinality())) == (pos) {
		return m_Wrappers.Companion_Result_.Create_Success_(acc)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = (f)((xs).Select(uint32(pos)).(interface{}))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_head interface{} = (_0_valueOrError0).Extract()
			_ = _1_head
			var _in0 func(interface{}) m_Wrappers.Result = f
			_ = _in0
			var _in1 _dafny.Sequence = xs
			_ = _in1
			var _in2 uint64 = (pos) + (uint64(1))
			_ = _in2
			var _in3 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(_1_head))
			_ = _in3
			f = _in0
			xs = _in1
			pos = _in2
			acc = _in3
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) Flatten(xs _dafny.Sequence, pos uint64, acc _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((xs).Cardinality())) == (pos) {
		return acc
	} else {
		var _in0 _dafny.Sequence = xs
		_ = _in0
		var _in1 uint64 = (pos) + (uint64(1))
		_ = _in1
		var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, (xs).Select(uint32(pos)).(_dafny.Sequence))
		_ = _in2
		xs = _in0
		pos = _in1
		acc = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) SequenceEqualNat(seq1 _dafny.Sequence, seq2 _dafny.Sequence, start1 _dafny.Int, start2 _dafny.Int, size _dafny.Int) bool {
	return Companion_Default___.SequenceEqual(seq1, seq2, (start1).Uint64(), (start2).Uint64(), (size).Uint64())
}
func (_static *CompanionStruct_Default___) SequenceEqual(seq1 _dafny.Sequence, seq2 _dafny.Sequence, start1 uint64, start2 uint64, size uint64) bool {
	var ret bool = false
	_ = ret
	var _0_j uint64
	_ = _0_j
	_0_j = start2
	var _hi0 uint64 = (start1) + (size)
	_ = _hi0
	for _1_i := start1; _1_i < _hi0; _1_i++ {
		if !_dafny.AreEqual((seq1).Select(uint32(_1_i)).(interface{}), (seq2).Select(uint32(_0_j)).(interface{})) {
			ret = false
			return ret
		}
		_0_j = (_0_j) + (uint64(1))
	}
	ret = true
	return ret
	return ret
}

// End of class Default__
