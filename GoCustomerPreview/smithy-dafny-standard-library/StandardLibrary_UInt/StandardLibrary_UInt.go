// Package StandardLibrary_UInt
// Dafny module StandardLibrary_UInt compiled into Go

package StandardLibrary_UInt

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
	return "StandardLibrary_UInt.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) UInt8Less(a uint8, b uint8) bool {
	return (a) < (b)
}
func (_static *CompanionStruct_Default___) HasUint16Len(s _dafny.Sequence) bool {
	return (_dafny.IntOfUint32((s).Cardinality())).Cmp(Companion_Default___.UINT16__LIMIT()) < 0
}
func (_static *CompanionStruct_Default___) HasUint32Len(s _dafny.Sequence) bool {
	return (_dafny.IntOfUint32((s).Cardinality())).Cmp(Companion_Default___.UINT32__LIMIT()) < 0
}
func (_static *CompanionStruct_Default___) HasUint64Len(s _dafny.Sequence) bool {
	return (_dafny.IntOfUint32((s).Cardinality())).Cmp(Companion_Default___.UINT64__LIMIT()) < 0
}
func (_static *CompanionStruct_Default___) HasUint16Size(s _dafny.Int) bool {
	return (s).Cmp(Companion_Default___.UINT16__LIMIT()) < 0
}
func (_static *CompanionStruct_Default___) HasUint32Size(s _dafny.Int) bool {
	return (s).Cmp(Companion_Default___.UINT32__LIMIT()) < 0
}
func (_static *CompanionStruct_Default___) HasUint64Size(s _dafny.Int) bool {
	return (s).Cmp(Companion_Default___.UINT64__LIMIT()) < 0
}
func (_static *CompanionStruct_Default___) UInt16ToSeq(x uint16) _dafny.Sequence {
	var _0_b0 uint8 = uint8((x) / (uint16(256)))
	_ = _0_b0
	var _1_b1 uint8 = uint8((x) % (uint16(256)))
	_ = _1_b1
	return _dafny.SeqOf(_0_b0, _1_b1)
}
func (_static *CompanionStruct_Default___) SeqToUInt16(s _dafny.Sequence) uint16 {
	var _0_x0 uint16 = (uint16((s).Select(uint32(uint32(0))).(uint8))) * (uint16(256))
	_ = _0_x0
	return (_0_x0) + (uint16((s).Select(uint32(uint32(1))).(uint8)))
}
func (_static *CompanionStruct_Default___) SeqPosToUInt16(s _dafny.Sequence, pos uint64) uint16 {
	var _0_x0 uint16 = (uint16((s).Select(uint32(pos)).(uint8))) * (uint16(256))
	_ = _0_x0
	return (_0_x0) + (uint16((s).Select(uint32((pos) + (uint64(1)))).(uint8)))
}
func (_static *CompanionStruct_Default___) SeqPosToUInt32(s _dafny.Sequence, pos uint64) uint32 {
	var _0_x0 uint32 = (uint32((s).Select(uint32(pos)).(uint8))) * (uint32(16777216))
	_ = _0_x0
	var _1_x1 uint32 = (_0_x0) + ((uint32((s).Select(uint32((pos) + (uint64(1)))).(uint8))) * (uint32(65536)))
	_ = _1_x1
	var _2_x2 uint32 = (_1_x1) + ((uint32((s).Select(uint32((pos) + (uint64(2)))).(uint8))) * (uint32(256)))
	_ = _2_x2
	return (_2_x2) + (uint32((s).Select(uint32((pos) + (uint64(3)))).(uint8)))
}
func (_static *CompanionStruct_Default___) SeqPosToUInt64(s _dafny.Sequence, pos uint64) uint64 {
	var _0_x0 uint64 = (uint64((s).Select(uint32(pos)).(uint8))) * (uint64(72057594037927936))
	_ = _0_x0
	var _1_x1 uint64 = (_0_x0) + ((uint64((s).Select(uint32((pos) + (uint64(1)))).(uint8))) * (uint64(281474976710656)))
	_ = _1_x1
	var _2_x2 uint64 = (_1_x1) + ((uint64((s).Select(uint32((pos) + (uint64(2)))).(uint8))) * (uint64(1099511627776)))
	_ = _2_x2
	var _3_x3 uint64 = (_2_x2) + ((uint64((s).Select(uint32((pos) + (uint64(3)))).(uint8))) * (uint64(4294967296)))
	_ = _3_x3
	var _4_x4 uint64 = (_3_x3) + ((uint64((s).Select(uint32((pos) + (uint64(4)))).(uint8))) * (uint64(16777216)))
	_ = _4_x4
	var _5_x5 uint64 = (_4_x4) + ((uint64((s).Select(uint32((pos) + (uint64(5)))).(uint8))) * (uint64(65536)))
	_ = _5_x5
	var _6_x6 uint64 = (_5_x5) + ((uint64((s).Select(uint32((pos) + (uint64(6)))).(uint8))) * (uint64(256)))
	_ = _6_x6
	var _7_x uint64 = (_6_x6) + (uint64((s).Select(uint32((pos) + (uint64(7)))).(uint8)))
	_ = _7_x
	return _7_x
}
func (_static *CompanionStruct_Default___) UInt32ToSeq(x uint32) _dafny.Sequence {
	var _0_b0 uint8 = uint8((x) / (uint32(16777216)))
	_ = _0_b0
	var _1_x0 uint32 = (x) - (func() uint32 { return ((uint32(_0_b0)) * (uint32(16777216))) })()
	_ = _1_x0
	var _2_b1 uint8 = uint8((_1_x0) / (uint32(65536)))
	_ = _2_b1
	var _3_x1 uint32 = (_1_x0) - (func() uint32 { return ((uint32(_2_b1)) * (uint32(65536))) })()
	_ = _3_x1
	var _4_b2 uint8 = uint8((_3_x1) / (uint32(256)))
	_ = _4_b2
	var _5_b3 uint8 = uint8((_3_x1) % (uint32(256)))
	_ = _5_b3
	return _dafny.SeqOf(_0_b0, _2_b1, _4_b2, _5_b3)
}
func (_static *CompanionStruct_Default___) SeqToUInt32(s _dafny.Sequence) uint32 {
	var _0_x0 uint32 = (uint32((s).Select(uint32(uint32(0))).(uint8))) * (uint32(16777216))
	_ = _0_x0
	var _1_x1 uint32 = (_0_x0) + ((uint32((s).Select(uint32(uint32(1))).(uint8))) * (uint32(65536)))
	_ = _1_x1
	var _2_x2 uint32 = (_1_x1) + ((uint32((s).Select(uint32(uint32(2))).(uint8))) * (uint32(256)))
	_ = _2_x2
	return (_2_x2) + (uint32((s).Select(uint32(uint32(3))).(uint8)))
}
func (_static *CompanionStruct_Default___) UInt64ToSeq(x uint64) _dafny.Sequence {
	var _0_b0 uint8 = uint8((x) / (uint64(72057594037927936)))
	_ = _0_b0
	var _1_x0 uint64 = (x) - (func() uint64 { return ((uint64(_0_b0)) * (uint64(72057594037927936))) })()
	_ = _1_x0
	var _2_b1 uint8 = uint8((_1_x0) / (uint64(281474976710656)))
	_ = _2_b1
	var _3_x1 uint64 = (_1_x0) - (func() uint64 { return ((uint64(_2_b1)) * (uint64(281474976710656))) })()
	_ = _3_x1
	var _4_b2 uint8 = uint8((_3_x1) / (uint64(1099511627776)))
	_ = _4_b2
	var _5_x2 uint64 = (_3_x1) - (func() uint64 { return ((uint64(_4_b2)) * (uint64(1099511627776))) })()
	_ = _5_x2
	var _6_b3 uint8 = uint8((_5_x2) / (uint64(4294967296)))
	_ = _6_b3
	var _7_x3 uint64 = (_5_x2) - (func() uint64 { return ((uint64(_6_b3)) * (uint64(4294967296))) })()
	_ = _7_x3
	var _8_b4 uint8 = uint8((_7_x3) / (uint64(16777216)))
	_ = _8_b4
	var _9_x4 uint64 = (_7_x3) - (func() uint64 { return ((uint64(_8_b4)) * (uint64(16777216))) })()
	_ = _9_x4
	var _10_b5 uint8 = uint8((_9_x4) / (uint64(65536)))
	_ = _10_b5
	var _11_x5 uint64 = (_9_x4) - (func() uint64 { return ((uint64(_10_b5)) * (uint64(65536))) })()
	_ = _11_x5
	var _12_b6 uint8 = uint8((_11_x5) / (uint64(256)))
	_ = _12_b6
	var _13_b7 uint8 = uint8((_11_x5) % (uint64(256)))
	_ = _13_b7
	return _dafny.SeqOf(_0_b0, _2_b1, _4_b2, _6_b3, _8_b4, _10_b5, _12_b6, _13_b7)
}
func (_static *CompanionStruct_Default___) SeqToUInt64(s _dafny.Sequence) uint64 {
	var _0_x0 uint64 = (uint64((s).Select(uint32(uint32(0))).(uint8))) * (uint64(72057594037927936))
	_ = _0_x0
	var _1_x1 uint64 = (_0_x0) + ((uint64((s).Select(uint32(uint32(1))).(uint8))) * (uint64(281474976710656)))
	_ = _1_x1
	var _2_x2 uint64 = (_1_x1) + ((uint64((s).Select(uint32(uint32(2))).(uint8))) * (uint64(1099511627776)))
	_ = _2_x2
	var _3_x3 uint64 = (_2_x2) + ((uint64((s).Select(uint32(uint32(3))).(uint8))) * (uint64(4294967296)))
	_ = _3_x3
	var _4_x4 uint64 = (_3_x3) + ((uint64((s).Select(uint32(uint32(4))).(uint8))) * (uint64(16777216)))
	_ = _4_x4
	var _5_x5 uint64 = (_4_x4) + ((uint64((s).Select(uint32(uint32(5))).(uint8))) * (uint64(65536)))
	_ = _5_x5
	var _6_x6 uint64 = (_5_x5) + ((uint64((s).Select(uint32(uint32(6))).(uint8))) * (uint64(256)))
	_ = _6_x6
	var _7_x uint64 = (_6_x6) + (uint64((s).Select(uint32(uint32(7))).(uint8)))
	_ = _7_x
	return _7_x
}
func (_static *CompanionStruct_Default___) UINT16__LIMIT() _dafny.Int {
	return (_dafny.IntOfUint16(m_BoundedInts.Companion_Default___.UINT16__MAX())).Plus(_dafny.One)
}
func (_static *CompanionStruct_Default___) UINT32__LIMIT() _dafny.Int {
	return (_dafny.IntOfUint32(m_BoundedInts.Companion_Default___.UINT32__MAX())).Plus(_dafny.One)
}
func (_static *CompanionStruct_Default___) UINT64__LIMIT() _dafny.Int {
	return (_dafny.IntOfUint64(m_BoundedInts.Companion_Default___.UINT64__MAX())).Plus(_dafny.One)
}
func (_static *CompanionStruct_Default___) INT32__MAX__LIMIT() _dafny.Int {
	return _dafny.IntOfInt32(m_BoundedInts.Companion_Default___.INT32__MAX())
}
func (_static *CompanionStruct_Default___) INT64__MAX__LIMIT() _dafny.Int {
	return _dafny.IntOfInt64(m_BoundedInts.Companion_Default___.INT64__MAX())
}
func (_static *CompanionStruct_Default___) UINT64__MAX__LIMIT() _dafny.Int {
	return _dafny.IntOfUint64(m_BoundedInts.Companion_Default___.UINT64__MAX())
}

// End of class Default__

// Definition of class Seq16
type Seq16 struct {
}

func New_Seq16_() *Seq16 {
	_this := Seq16{}

	return &_this
}

type CompanionStruct_Seq16_ struct {
}

var Companion_Seq16_ = CompanionStruct_Seq16_{}

func (*Seq16) String() string {
	return "StandardLibrary_UInt.Seq16"
}

// End of class Seq16

func Type_Seq16_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_Seq16_{Type_T_}
}

type type_Seq16_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_Seq16_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return _dafny.EmptySeq
}

func (_this type_Seq16_) String() string {
	return "StandardLibrary_UInt.Seq16"
}
func (_this *CompanionStruct_Seq16_) Is_(__source _dafny.Sequence) bool {
	var _0_s _dafny.Sequence = (__source)
	_ = _0_s
	return Companion_Default___.HasUint16Len(_0_s)
}

// Definition of class Seq32
type Seq32 struct {
}

func New_Seq32_() *Seq32 {
	_this := Seq32{}

	return &_this
}

type CompanionStruct_Seq32_ struct {
}

var Companion_Seq32_ = CompanionStruct_Seq32_{}

func (*Seq32) String() string {
	return "StandardLibrary_UInt.Seq32"
}

// End of class Seq32

func Type_Seq32_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_Seq32_{Type_T_}
}

type type_Seq32_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_Seq32_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return _dafny.EmptySeq
}

func (_this type_Seq32_) String() string {
	return "StandardLibrary_UInt.Seq32"
}
func (_this *CompanionStruct_Seq32_) Is_(__source _dafny.Sequence) bool {
	var _1_s _dafny.Sequence = (__source)
	_ = _1_s
	return Companion_Default___.HasUint32Len(_1_s)
}

// Definition of class Seq64
type Seq64 struct {
}

func New_Seq64_() *Seq64 {
	_this := Seq64{}

	return &_this
}

type CompanionStruct_Seq64_ struct {
}

var Companion_Seq64_ = CompanionStruct_Seq64_{}

func (*Seq64) String() string {
	return "StandardLibrary_UInt.Seq64"
}

// End of class Seq64

func Type_Seq64_(Type_T_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_Seq64_{Type_T_}
}

type type_Seq64_ struct {
	Type_T_ _dafny.TypeDescriptor
}

func (_this type_Seq64_) Default() interface{} {
	Type_T_ := _this.Type_T_
	_ = Type_T_
	return _dafny.EmptySeq
}

func (_this type_Seq64_) String() string {
	return "StandardLibrary_UInt.Seq64"
}
func (_this *CompanionStruct_Seq64_) Is_(__source _dafny.Sequence) bool {
	var _2_s _dafny.Sequence = (__source)
	_ = _2_s
	return Companion_Default___.HasUint64Len(_2_s)
}
