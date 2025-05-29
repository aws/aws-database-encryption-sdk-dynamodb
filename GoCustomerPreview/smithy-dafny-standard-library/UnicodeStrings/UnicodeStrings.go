// Package UnicodeStrings
// Dafny module UnicodeStrings compiled into Go

package UnicodeStrings

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq"
	m_Seq_MergeSort "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq_MergeSort"
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
	return "UnicodeStrings.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsWellFormedString(s _dafny.Sequence) bool {
	return m_Utf16EncodingForm.Companion_Default___.IsWellFormedCodeUnitSequence(m_Seq.Companion_Default___.Map(func(coer6 func(_dafny.Char) uint16) func(interface{}) interface{} {
		return func(arg7 interface{}) interface{} {
			return coer6(arg7.(_dafny.Char))
		}
	}(func(_0_c _dafny.Char) uint16 {
		return uint16(_0_c)
	}), s))
}
func (_static *CompanionStruct_Default___) ToUTF8Checked(s _dafny.Sequence) m_Wrappers.Option {
	var _0_asCodeUnits _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer7 func(_dafny.Char) uint16) func(interface{}) interface{} {
		return func(arg8 interface{}) interface{} {
			return coer7(arg8.(_dafny.Char))
		}
	}(func(_1_c _dafny.Char) uint16 {
		return uint16(_1_c)
	}), s)
	_ = _0_asCodeUnits
	var _2_valueOrError0 m_Wrappers.Option = m_Utf16EncodingForm.Companion_Default___.DecodeCodeUnitSequenceChecked(_0_asCodeUnits)
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		var _3_utf32 _dafny.Sequence = (_2_valueOrError0).Extract().(_dafny.Sequence)
		_ = _3_utf32
		var _4_asUtf8CodeUnits _dafny.Sequence = m_Utf8EncodingForm.Companion_Default___.EncodeScalarSequence(_3_utf32)
		_ = _4_asUtf8CodeUnits
		return m_Wrappers.Companion_Option_.Create_Some_(m_Seq.Companion_Default___.Map(func(coer8 func(uint8) uint8) func(interface{}) interface{} {
			return func(arg9 interface{}) interface{} {
				return coer8(arg9.(uint8))
			}
		}(func(_5_c uint8) uint8 {
			return uint8(_5_c)
		}), _4_asUtf8CodeUnits))
	}
}
func (_static *CompanionStruct_Default___) FromUTF8Checked(bs _dafny.Sequence) m_Wrappers.Option {
	var _0_asCodeUnits _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer9 func(uint8) uint8) func(interface{}) interface{} {
		return func(arg10 interface{}) interface{} {
			return coer9(arg10.(uint8))
		}
	}(func(_1_c uint8) uint8 {
		return uint8(_1_c)
	}), bs)
	_ = _0_asCodeUnits
	var _2_valueOrError0 m_Wrappers.Option = m_Utf8EncodingForm.Companion_Default___.DecodeCodeUnitSequenceChecked(_0_asCodeUnits)
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		var _3_utf32 _dafny.Sequence = (_2_valueOrError0).Extract().(_dafny.Sequence)
		_ = _3_utf32
		var _4_asUtf16CodeUnits _dafny.Sequence = m_Utf16EncodingForm.Companion_Default___.EncodeScalarSequence(_3_utf32)
		_ = _4_asUtf16CodeUnits
		return m_Wrappers.Companion_Option_.Create_Some_(m_Seq.Companion_Default___.Map(func(coer10 func(uint16) _dafny.Char) func(interface{}) interface{} {
			return func(arg11 interface{}) interface{} {
				return coer10(arg11.(uint16))
			}
		}(func(_5_cu uint16) _dafny.Char {
			return _dafny.Char((_5_cu))
		}), _4_asUtf16CodeUnits))
	}
}
func (_static *CompanionStruct_Default___) ToUTF16Checked(s _dafny.Sequence) m_Wrappers.Option {
	if m_Utf16EncodingForm.Companion_Default___.IsWellFormedCodeUnitSequence(m_Seq.Companion_Default___.Map(func(coer11 func(_dafny.Char) uint16) func(interface{}) interface{} {
		return func(arg12 interface{}) interface{} {
			return coer11(arg12.(_dafny.Char))
		}
	}(func(_0_c _dafny.Char) uint16 {
		return uint16(_0_c)
	}), s)) {
		return m_Wrappers.Companion_Option_.Create_Some_(m_Seq.Companion_Default___.Map(func(coer12 func(_dafny.Char) uint16) func(interface{}) interface{} {
			return func(arg13 interface{}) interface{} {
				return coer12(arg13.(_dafny.Char))
			}
		}(func(_1_c _dafny.Char) uint16 {
			return uint16(_1_c)
		}), s))
	} else {
		return m_Wrappers.Companion_Option_.Create_None_()
	}
}
func (_static *CompanionStruct_Default___) FromUTF16Checked(bs _dafny.Sequence) m_Wrappers.Option {
	if m_Utf16EncodingForm.Companion_Default___.IsWellFormedCodeUnitSequence(m_Seq.Companion_Default___.Map(func(coer13 func(uint16) uint16) func(interface{}) interface{} {
		return func(arg14 interface{}) interface{} {
			return coer13(arg14.(uint16))
		}
	}(func(_0_c uint16) uint16 {
		return uint16(_0_c)
	}), bs)) {
		return m_Wrappers.Companion_Option_.Create_Some_(m_Seq.Companion_Default___.Map(func(coer14 func(uint16) _dafny.Char) func(interface{}) interface{} {
			return func(arg15 interface{}) interface{} {
				return coer14(arg15.(uint16))
			}
		}(func(_1_c uint16) _dafny.Char {
			return _dafny.Char((_1_c))
		}), bs))
	} else {
		return m_Wrappers.Companion_Option_.Create_None_()
	}
}
func (_static *CompanionStruct_Default___) ASCIIToUTF8(s _dafny.Sequence) _dafny.Sequence {
	return m_Seq.Companion_Default___.Map(func(coer15 func(_dafny.Char) uint8) func(interface{}) interface{} {
		return func(arg16 interface{}) interface{} {
			return coer15(arg16.(_dafny.Char))
		}
	}(func(_0_c _dafny.Char) uint8 {
		return uint8(_0_c)
	}), s)
}
func (_static *CompanionStruct_Default___) ASCIIToUTF16(s _dafny.Sequence) _dafny.Sequence {
	return m_Seq.Companion_Default___.Map(func(coer16 func(_dafny.Char) uint16) func(interface{}) interface{} {
		return func(arg17 interface{}) interface{} {
			return coer16(arg17.(_dafny.Char))
		}
	}(func(_0_c _dafny.Char) uint16 {
		return uint16(_0_c)
	}), s)
}

// End of class Default__
