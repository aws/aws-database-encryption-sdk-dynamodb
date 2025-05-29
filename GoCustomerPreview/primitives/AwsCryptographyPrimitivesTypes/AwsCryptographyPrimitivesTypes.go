// Package AwsCryptographyPrimitivesTypes
// Dafny module AwsCryptographyPrimitivesTypes compiled into Go

package AwsCryptographyPrimitivesTypes

import (
	os "os"

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
	return "AwsCryptographyPrimitivesTypes.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsValid__PositiveInteger(x int32) bool {
	return (int32(0)) <= (x)
}
func (_static *CompanionStruct_Default___) IsValid__RSAModulusLengthBits(x int32) bool {
	return (int32(81)) <= (x)
}
func (_static *CompanionStruct_Default___) IsValid__RSAModulusLengthBitsToGenerate(x int32) bool {
	return ((int32(81)) <= (x)) && ((x) <= (int32(4096)))
}
func (_static *CompanionStruct_Default___) IsValid__SymmetricKeyLength(x int32) bool {
	return ((int32(1)) <= (x)) && ((x) <= (int32(32)))
}
func (_static *CompanionStruct_Default___) IsValid__Uint8Bits(x int32) bool {
	return ((int32(0)) <= (x)) && ((x) <= (int32(255)))
}
func (_static *CompanionStruct_Default___) IsValid__Uint8Bytes(x int32) bool {
	return ((int32(0)) <= (x)) && ((x) <= (int32(32)))
}
func (_static *CompanionStruct_Default___) IsDummySubsetType(x _dafny.Int) bool {
	return (x).Sign() == 1
}

// End of class Default__

// Definition of datatype DafnyCallEvent
type DafnyCallEvent struct {
	Data_DafnyCallEvent_
}

func (_this DafnyCallEvent) Get_() Data_DafnyCallEvent_ {
	return _this.Data_DafnyCallEvent_
}

type Data_DafnyCallEvent_ interface {
	isDafnyCallEvent()
}

type CompanionStruct_DafnyCallEvent_ struct {
}

var Companion_DafnyCallEvent_ = CompanionStruct_DafnyCallEvent_{}

type DafnyCallEvent_DafnyCallEvent struct {
	Input  interface{}
	Output interface{}
}

func (DafnyCallEvent_DafnyCallEvent) isDafnyCallEvent() {}

func (CompanionStruct_DafnyCallEvent_) Create_DafnyCallEvent_(Input interface{}, Output interface{}) DafnyCallEvent {
	return DafnyCallEvent{DafnyCallEvent_DafnyCallEvent{Input, Output}}
}

func (_this DafnyCallEvent) Is_DafnyCallEvent() bool {
	_, ok := _this.Get_().(DafnyCallEvent_DafnyCallEvent)
	return ok
}

func (CompanionStruct_DafnyCallEvent_) Default(_default_I interface{}, _default_O interface{}) DafnyCallEvent {
	return Companion_DafnyCallEvent_.Create_DafnyCallEvent_(_default_I, _default_O)
}

func (_this DafnyCallEvent) Dtor_input() interface{} {
	return _this.Get_().(DafnyCallEvent_DafnyCallEvent).Input
}

func (_this DafnyCallEvent) Dtor_output() interface{} {
	return _this.Get_().(DafnyCallEvent_DafnyCallEvent).Output
}

func (_this DafnyCallEvent) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DafnyCallEvent_DafnyCallEvent:
		{
			return "AwsCryptographyPrimitivesTypes.DafnyCallEvent.DafnyCallEvent" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DafnyCallEvent) Equals(other DafnyCallEvent) bool {
	switch data1 := _this.Get_().(type) {
	case DafnyCallEvent_DafnyCallEvent:
		{
			data2, ok := other.Get_().(DafnyCallEvent_DafnyCallEvent)
			return ok && _dafny.AreEqual(data1.Input, data2.Input) && _dafny.AreEqual(data1.Output, data2.Output)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DafnyCallEvent) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DafnyCallEvent)
	return ok && _this.Equals(typed)
}

func Type_DafnyCallEvent_(Type_I_ _dafny.TypeDescriptor, Type_O_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_DafnyCallEvent_{Type_I_, Type_O_}
}

type type_DafnyCallEvent_ struct {
	Type_I_ _dafny.TypeDescriptor
	Type_O_ _dafny.TypeDescriptor
}

func (_this type_DafnyCallEvent_) Default() interface{} {
	Type_I_ := _this.Type_I_
	_ = Type_I_
	Type_O_ := _this.Type_O_
	_ = Type_O_
	return Companion_DafnyCallEvent_.Default(Type_I_.Default(), Type_O_.Default())
}

func (_this type_DafnyCallEvent_) String() string {
	return "AwsCryptographyPrimitivesTypes.DafnyCallEvent"
}
func (_this DafnyCallEvent) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DafnyCallEvent{}

// End of datatype DafnyCallEvent

// Definition of datatype AES__CTR
type AES__CTR struct {
	Data_AES__CTR_
}

func (_this AES__CTR) Get_() Data_AES__CTR_ {
	return _this.Data_AES__CTR_
}

type Data_AES__CTR_ interface {
	isAES__CTR()
}

type CompanionStruct_AES__CTR_ struct {
}

var Companion_AES__CTR_ = CompanionStruct_AES__CTR_{}

type AES__CTR_AES__CTR struct {
	KeyLength   int32
	NonceLength int32
}

func (AES__CTR_AES__CTR) isAES__CTR() {}

func (CompanionStruct_AES__CTR_) Create_AES__CTR_(KeyLength int32, NonceLength int32) AES__CTR {
	return AES__CTR{AES__CTR_AES__CTR{KeyLength, NonceLength}}
}

func (_this AES__CTR) Is_AES__CTR() bool {
	_, ok := _this.Get_().(AES__CTR_AES__CTR)
	return ok
}

func (CompanionStruct_AES__CTR_) Default() AES__CTR {
	return Companion_AES__CTR_.Create_AES__CTR_(int32(0), int32(0))
}

func (_this AES__CTR) Dtor_keyLength() int32 {
	return _this.Get_().(AES__CTR_AES__CTR).KeyLength
}

func (_this AES__CTR) Dtor_nonceLength() int32 {
	return _this.Get_().(AES__CTR_AES__CTR).NonceLength
}

func (_this AES__CTR) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AES__CTR_AES__CTR:
		{
			return "AwsCryptographyPrimitivesTypes.AES_CTR.AES_CTR" + "(" + _dafny.String(data.KeyLength) + ", " + _dafny.String(data.NonceLength) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AES__CTR) Equals(other AES__CTR) bool {
	switch data1 := _this.Get_().(type) {
	case AES__CTR_AES__CTR:
		{
			data2, ok := other.Get_().(AES__CTR_AES__CTR)
			return ok && data1.KeyLength == data2.KeyLength && data1.NonceLength == data2.NonceLength
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AES__CTR) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AES__CTR)
	return ok && _this.Equals(typed)
}

func Type_AES__CTR_() _dafny.TypeDescriptor {
	return type_AES__CTR_{}
}

type type_AES__CTR_ struct {
}

func (_this type_AES__CTR_) Default() interface{} {
	return Companion_AES__CTR_.Default()
}

func (_this type_AES__CTR_) String() string {
	return "AwsCryptographyPrimitivesTypes.AES__CTR"
}
func (_this AES__CTR) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AES__CTR{}

// End of datatype AES__CTR

// Definition of datatype AES__GCM
type AES__GCM struct {
	Data_AES__GCM_
}

func (_this AES__GCM) Get_() Data_AES__GCM_ {
	return _this.Data_AES__GCM_
}

type Data_AES__GCM_ interface {
	isAES__GCM()
}

type CompanionStruct_AES__GCM_ struct {
}

var Companion_AES__GCM_ = CompanionStruct_AES__GCM_{}

type AES__GCM_AES__GCM struct {
	KeyLength int32
	TagLength int32
	IvLength  int32
}

func (AES__GCM_AES__GCM) isAES__GCM() {}

func (CompanionStruct_AES__GCM_) Create_AES__GCM_(KeyLength int32, TagLength int32, IvLength int32) AES__GCM {
	return AES__GCM{AES__GCM_AES__GCM{KeyLength, TagLength, IvLength}}
}

func (_this AES__GCM) Is_AES__GCM() bool {
	_, ok := _this.Get_().(AES__GCM_AES__GCM)
	return ok
}

func (CompanionStruct_AES__GCM_) Default() AES__GCM {
	return Companion_AES__GCM_.Create_AES__GCM_(int32(0), int32(0), int32(0))
}

func (_this AES__GCM) Dtor_keyLength() int32 {
	return _this.Get_().(AES__GCM_AES__GCM).KeyLength
}

func (_this AES__GCM) Dtor_tagLength() int32 {
	return _this.Get_().(AES__GCM_AES__GCM).TagLength
}

func (_this AES__GCM) Dtor_ivLength() int32 {
	return _this.Get_().(AES__GCM_AES__GCM).IvLength
}

func (_this AES__GCM) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AES__GCM_AES__GCM:
		{
			return "AwsCryptographyPrimitivesTypes.AES_GCM.AES_GCM" + "(" + _dafny.String(data.KeyLength) + ", " + _dafny.String(data.TagLength) + ", " + _dafny.String(data.IvLength) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AES__GCM) Equals(other AES__GCM) bool {
	switch data1 := _this.Get_().(type) {
	case AES__GCM_AES__GCM:
		{
			data2, ok := other.Get_().(AES__GCM_AES__GCM)
			return ok && data1.KeyLength == data2.KeyLength && data1.TagLength == data2.TagLength && data1.IvLength == data2.IvLength
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AES__GCM) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AES__GCM)
	return ok && _this.Equals(typed)
}

func Type_AES__GCM_() _dafny.TypeDescriptor {
	return type_AES__GCM_{}
}

type type_AES__GCM_ struct {
}

func (_this type_AES__GCM_) Default() interface{} {
	return Companion_AES__GCM_.Default()
}

func (_this type_AES__GCM_) String() string {
	return "AwsCryptographyPrimitivesTypes.AES__GCM"
}
func (_this AES__GCM) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AES__GCM{}

// End of datatype AES__GCM

// Definition of datatype AESDecryptInput
type AESDecryptInput struct {
	Data_AESDecryptInput_
}

func (_this AESDecryptInput) Get_() Data_AESDecryptInput_ {
	return _this.Data_AESDecryptInput_
}

type Data_AESDecryptInput_ interface {
	isAESDecryptInput()
}

type CompanionStruct_AESDecryptInput_ struct {
}

var Companion_AESDecryptInput_ = CompanionStruct_AESDecryptInput_{}

type AESDecryptInput_AESDecryptInput struct {
	EncAlg    AES__GCM
	Key       _dafny.Sequence
	CipherTxt _dafny.Sequence
	AuthTag   _dafny.Sequence
	Iv        _dafny.Sequence
	Aad       _dafny.Sequence
}

func (AESDecryptInput_AESDecryptInput) isAESDecryptInput() {}

func (CompanionStruct_AESDecryptInput_) Create_AESDecryptInput_(EncAlg AES__GCM, Key _dafny.Sequence, CipherTxt _dafny.Sequence, AuthTag _dafny.Sequence, Iv _dafny.Sequence, Aad _dafny.Sequence) AESDecryptInput {
	return AESDecryptInput{AESDecryptInput_AESDecryptInput{EncAlg, Key, CipherTxt, AuthTag, Iv, Aad}}
}

func (_this AESDecryptInput) Is_AESDecryptInput() bool {
	_, ok := _this.Get_().(AESDecryptInput_AESDecryptInput)
	return ok
}

func (CompanionStruct_AESDecryptInput_) Default() AESDecryptInput {
	return Companion_AESDecryptInput_.Create_AESDecryptInput_(Companion_AES__GCM_.Default(), _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this AESDecryptInput) Dtor_encAlg() AES__GCM {
	return _this.Get_().(AESDecryptInput_AESDecryptInput).EncAlg
}

func (_this AESDecryptInput) Dtor_key() _dafny.Sequence {
	return _this.Get_().(AESDecryptInput_AESDecryptInput).Key
}

func (_this AESDecryptInput) Dtor_cipherTxt() _dafny.Sequence {
	return _this.Get_().(AESDecryptInput_AESDecryptInput).CipherTxt
}

func (_this AESDecryptInput) Dtor_authTag() _dafny.Sequence {
	return _this.Get_().(AESDecryptInput_AESDecryptInput).AuthTag
}

func (_this AESDecryptInput) Dtor_iv() _dafny.Sequence {
	return _this.Get_().(AESDecryptInput_AESDecryptInput).Iv
}

func (_this AESDecryptInput) Dtor_aad() _dafny.Sequence {
	return _this.Get_().(AESDecryptInput_AESDecryptInput).Aad
}

func (_this AESDecryptInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AESDecryptInput_AESDecryptInput:
		{
			return "AwsCryptographyPrimitivesTypes.AESDecryptInput.AESDecryptInput" + "(" + _dafny.String(data.EncAlg) + ", " + _dafny.String(data.Key) + ", " + _dafny.String(data.CipherTxt) + ", " + _dafny.String(data.AuthTag) + ", " + _dafny.String(data.Iv) + ", " + _dafny.String(data.Aad) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AESDecryptInput) Equals(other AESDecryptInput) bool {
	switch data1 := _this.Get_().(type) {
	case AESDecryptInput_AESDecryptInput:
		{
			data2, ok := other.Get_().(AESDecryptInput_AESDecryptInput)
			return ok && data1.EncAlg.Equals(data2.EncAlg) && data1.Key.Equals(data2.Key) && data1.CipherTxt.Equals(data2.CipherTxt) && data1.AuthTag.Equals(data2.AuthTag) && data1.Iv.Equals(data2.Iv) && data1.Aad.Equals(data2.Aad)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AESDecryptInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AESDecryptInput)
	return ok && _this.Equals(typed)
}

func Type_AESDecryptInput_() _dafny.TypeDescriptor {
	return type_AESDecryptInput_{}
}

type type_AESDecryptInput_ struct {
}

func (_this type_AESDecryptInput_) Default() interface{} {
	return Companion_AESDecryptInput_.Default()
}

func (_this type_AESDecryptInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.AESDecryptInput"
}
func (_this AESDecryptInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AESDecryptInput{}

// End of datatype AESDecryptInput

// Definition of datatype AESEncryptInput
type AESEncryptInput struct {
	Data_AESEncryptInput_
}

func (_this AESEncryptInput) Get_() Data_AESEncryptInput_ {
	return _this.Data_AESEncryptInput_
}

type Data_AESEncryptInput_ interface {
	isAESEncryptInput()
}

type CompanionStruct_AESEncryptInput_ struct {
}

var Companion_AESEncryptInput_ = CompanionStruct_AESEncryptInput_{}

type AESEncryptInput_AESEncryptInput struct {
	EncAlg AES__GCM
	Iv     _dafny.Sequence
	Key    _dafny.Sequence
	Msg    _dafny.Sequence
	Aad    _dafny.Sequence
}

func (AESEncryptInput_AESEncryptInput) isAESEncryptInput() {}

func (CompanionStruct_AESEncryptInput_) Create_AESEncryptInput_(EncAlg AES__GCM, Iv _dafny.Sequence, Key _dafny.Sequence, Msg _dafny.Sequence, Aad _dafny.Sequence) AESEncryptInput {
	return AESEncryptInput{AESEncryptInput_AESEncryptInput{EncAlg, Iv, Key, Msg, Aad}}
}

func (_this AESEncryptInput) Is_AESEncryptInput() bool {
	_, ok := _this.Get_().(AESEncryptInput_AESEncryptInput)
	return ok
}

func (CompanionStruct_AESEncryptInput_) Default() AESEncryptInput {
	return Companion_AESEncryptInput_.Create_AESEncryptInput_(Companion_AES__GCM_.Default(), _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this AESEncryptInput) Dtor_encAlg() AES__GCM {
	return _this.Get_().(AESEncryptInput_AESEncryptInput).EncAlg
}

func (_this AESEncryptInput) Dtor_iv() _dafny.Sequence {
	return _this.Get_().(AESEncryptInput_AESEncryptInput).Iv
}

func (_this AESEncryptInput) Dtor_key() _dafny.Sequence {
	return _this.Get_().(AESEncryptInput_AESEncryptInput).Key
}

func (_this AESEncryptInput) Dtor_msg() _dafny.Sequence {
	return _this.Get_().(AESEncryptInput_AESEncryptInput).Msg
}

func (_this AESEncryptInput) Dtor_aad() _dafny.Sequence {
	return _this.Get_().(AESEncryptInput_AESEncryptInput).Aad
}

func (_this AESEncryptInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AESEncryptInput_AESEncryptInput:
		{
			return "AwsCryptographyPrimitivesTypes.AESEncryptInput.AESEncryptInput" + "(" + _dafny.String(data.EncAlg) + ", " + _dafny.String(data.Iv) + ", " + _dafny.String(data.Key) + ", " + _dafny.String(data.Msg) + ", " + _dafny.String(data.Aad) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AESEncryptInput) Equals(other AESEncryptInput) bool {
	switch data1 := _this.Get_().(type) {
	case AESEncryptInput_AESEncryptInput:
		{
			data2, ok := other.Get_().(AESEncryptInput_AESEncryptInput)
			return ok && data1.EncAlg.Equals(data2.EncAlg) && data1.Iv.Equals(data2.Iv) && data1.Key.Equals(data2.Key) && data1.Msg.Equals(data2.Msg) && data1.Aad.Equals(data2.Aad)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AESEncryptInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AESEncryptInput)
	return ok && _this.Equals(typed)
}

func Type_AESEncryptInput_() _dafny.TypeDescriptor {
	return type_AESEncryptInput_{}
}

type type_AESEncryptInput_ struct {
}

func (_this type_AESEncryptInput_) Default() interface{} {
	return Companion_AESEncryptInput_.Default()
}

func (_this type_AESEncryptInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.AESEncryptInput"
}
func (_this AESEncryptInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AESEncryptInput{}

// End of datatype AESEncryptInput

// Definition of datatype AESEncryptOutput
type AESEncryptOutput struct {
	Data_AESEncryptOutput_
}

func (_this AESEncryptOutput) Get_() Data_AESEncryptOutput_ {
	return _this.Data_AESEncryptOutput_
}

type Data_AESEncryptOutput_ interface {
	isAESEncryptOutput()
}

type CompanionStruct_AESEncryptOutput_ struct {
}

var Companion_AESEncryptOutput_ = CompanionStruct_AESEncryptOutput_{}

type AESEncryptOutput_AESEncryptOutput struct {
	CipherText _dafny.Sequence
	AuthTag    _dafny.Sequence
}

func (AESEncryptOutput_AESEncryptOutput) isAESEncryptOutput() {}

func (CompanionStruct_AESEncryptOutput_) Create_AESEncryptOutput_(CipherText _dafny.Sequence, AuthTag _dafny.Sequence) AESEncryptOutput {
	return AESEncryptOutput{AESEncryptOutput_AESEncryptOutput{CipherText, AuthTag}}
}

func (_this AESEncryptOutput) Is_AESEncryptOutput() bool {
	_, ok := _this.Get_().(AESEncryptOutput_AESEncryptOutput)
	return ok
}

func (CompanionStruct_AESEncryptOutput_) Default() AESEncryptOutput {
	return Companion_AESEncryptOutput_.Create_AESEncryptOutput_(_dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this AESEncryptOutput) Dtor_cipherText() _dafny.Sequence {
	return _this.Get_().(AESEncryptOutput_AESEncryptOutput).CipherText
}

func (_this AESEncryptOutput) Dtor_authTag() _dafny.Sequence {
	return _this.Get_().(AESEncryptOutput_AESEncryptOutput).AuthTag
}

func (_this AESEncryptOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AESEncryptOutput_AESEncryptOutput:
		{
			return "AwsCryptographyPrimitivesTypes.AESEncryptOutput.AESEncryptOutput" + "(" + _dafny.String(data.CipherText) + ", " + _dafny.String(data.AuthTag) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AESEncryptOutput) Equals(other AESEncryptOutput) bool {
	switch data1 := _this.Get_().(type) {
	case AESEncryptOutput_AESEncryptOutput:
		{
			data2, ok := other.Get_().(AESEncryptOutput_AESEncryptOutput)
			return ok && data1.CipherText.Equals(data2.CipherText) && data1.AuthTag.Equals(data2.AuthTag)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AESEncryptOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AESEncryptOutput)
	return ok && _this.Equals(typed)
}

func Type_AESEncryptOutput_() _dafny.TypeDescriptor {
	return type_AESEncryptOutput_{}
}

type type_AESEncryptOutput_ struct {
}

func (_this type_AESEncryptOutput_) Default() interface{} {
	return Companion_AESEncryptOutput_.Default()
}

func (_this type_AESEncryptOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.AESEncryptOutput"
}
func (_this AESEncryptOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AESEncryptOutput{}

// End of datatype AESEncryptOutput

// Definition of datatype AesKdfCtrInput
type AesKdfCtrInput struct {
	Data_AesKdfCtrInput_
}

func (_this AesKdfCtrInput) Get_() Data_AesKdfCtrInput_ {
	return _this.Data_AesKdfCtrInput_
}

type Data_AesKdfCtrInput_ interface {
	isAesKdfCtrInput()
}

type CompanionStruct_AesKdfCtrInput_ struct {
}

var Companion_AesKdfCtrInput_ = CompanionStruct_AesKdfCtrInput_{}

type AesKdfCtrInput_AesKdfCtrInput struct {
	Ikm            _dafny.Sequence
	ExpectedLength int32
	Nonce          m_Wrappers.Option
}

func (AesKdfCtrInput_AesKdfCtrInput) isAesKdfCtrInput() {}

func (CompanionStruct_AesKdfCtrInput_) Create_AesKdfCtrInput_(Ikm _dafny.Sequence, ExpectedLength int32, Nonce m_Wrappers.Option) AesKdfCtrInput {
	return AesKdfCtrInput{AesKdfCtrInput_AesKdfCtrInput{Ikm, ExpectedLength, Nonce}}
}

func (_this AesKdfCtrInput) Is_AesKdfCtrInput() bool {
	_, ok := _this.Get_().(AesKdfCtrInput_AesKdfCtrInput)
	return ok
}

func (CompanionStruct_AesKdfCtrInput_) Default() AesKdfCtrInput {
	return Companion_AesKdfCtrInput_.Create_AesKdfCtrInput_(_dafny.EmptySeq, int32(0), m_Wrappers.Companion_Option_.Default())
}

func (_this AesKdfCtrInput) Dtor_ikm() _dafny.Sequence {
	return _this.Get_().(AesKdfCtrInput_AesKdfCtrInput).Ikm
}

func (_this AesKdfCtrInput) Dtor_expectedLength() int32 {
	return _this.Get_().(AesKdfCtrInput_AesKdfCtrInput).ExpectedLength
}

func (_this AesKdfCtrInput) Dtor_nonce() m_Wrappers.Option {
	return _this.Get_().(AesKdfCtrInput_AesKdfCtrInput).Nonce
}

func (_this AesKdfCtrInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AesKdfCtrInput_AesKdfCtrInput:
		{
			return "AwsCryptographyPrimitivesTypes.AesKdfCtrInput.AesKdfCtrInput" + "(" + _dafny.String(data.Ikm) + ", " + _dafny.String(data.ExpectedLength) + ", " + _dafny.String(data.Nonce) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AesKdfCtrInput) Equals(other AesKdfCtrInput) bool {
	switch data1 := _this.Get_().(type) {
	case AesKdfCtrInput_AesKdfCtrInput:
		{
			data2, ok := other.Get_().(AesKdfCtrInput_AesKdfCtrInput)
			return ok && data1.Ikm.Equals(data2.Ikm) && data1.ExpectedLength == data2.ExpectedLength && data1.Nonce.Equals(data2.Nonce)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AesKdfCtrInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AesKdfCtrInput)
	return ok && _this.Equals(typed)
}

func Type_AesKdfCtrInput_() _dafny.TypeDescriptor {
	return type_AesKdfCtrInput_{}
}

type type_AesKdfCtrInput_ struct {
}

func (_this type_AesKdfCtrInput_) Default() interface{} {
	return Companion_AesKdfCtrInput_.Default()
}

func (_this type_AesKdfCtrInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.AesKdfCtrInput"
}
func (_this AesKdfCtrInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AesKdfCtrInput{}

// End of datatype AesKdfCtrInput

// Definition of class IAwsCryptographicPrimitivesClientCallHistory
type IAwsCryptographicPrimitivesClientCallHistory struct {
	dummy byte
}

func New_IAwsCryptographicPrimitivesClientCallHistory_() *IAwsCryptographicPrimitivesClientCallHistory {
	_this := IAwsCryptographicPrimitivesClientCallHistory{}

	return &_this
}

type CompanionStruct_IAwsCryptographicPrimitivesClientCallHistory_ struct {
}

var Companion_IAwsCryptographicPrimitivesClientCallHistory_ = CompanionStruct_IAwsCryptographicPrimitivesClientCallHistory_{}

func (_this *IAwsCryptographicPrimitivesClientCallHistory) Equals(other *IAwsCryptographicPrimitivesClientCallHistory) bool {
	return _this == other
}

func (_this *IAwsCryptographicPrimitivesClientCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IAwsCryptographicPrimitivesClientCallHistory)
	return ok && _this.Equals(other)
}

func (*IAwsCryptographicPrimitivesClientCallHistory) String() string {
	return "AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClientCallHistory"
}

func Type_IAwsCryptographicPrimitivesClientCallHistory_() _dafny.TypeDescriptor {
	return type_IAwsCryptographicPrimitivesClientCallHistory_{}
}

type type_IAwsCryptographicPrimitivesClientCallHistory_ struct {
}

func (_this type_IAwsCryptographicPrimitivesClientCallHistory_) Default() interface{} {
	return (*IAwsCryptographicPrimitivesClientCallHistory)(nil)
}

func (_this type_IAwsCryptographicPrimitivesClientCallHistory_) String() string {
	return "AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClientCallHistory"
}
func (_this *IAwsCryptographicPrimitivesClientCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IAwsCryptographicPrimitivesClientCallHistory{}

// End of class IAwsCryptographicPrimitivesClientCallHistory

// Definition of trait IAwsCryptographicPrimitivesClient
type IAwsCryptographicPrimitivesClient interface {
	String() string
	GenerateRandomBytes(input GenerateRandomBytesInput) m_Wrappers.Result
	Digest(input DigestInput) m_Wrappers.Result
	HMac(input HMacInput) m_Wrappers.Result
	HkdfExtract(input HkdfExtractInput) m_Wrappers.Result
	HkdfExpand(input HkdfExpandInput) m_Wrappers.Result
	Hkdf(input HkdfInput) m_Wrappers.Result
	KdfCounterMode(input KdfCtrInput) m_Wrappers.Result
	AesKdfCounterMode(input AesKdfCtrInput) m_Wrappers.Result
	AESEncrypt(input AESEncryptInput) m_Wrappers.Result
	AESDecrypt(input AESDecryptInput) m_Wrappers.Result
	GenerateRSAKeyPair(input GenerateRSAKeyPairInput) m_Wrappers.Result
	GetRSAKeyModulusLength(input GetRSAKeyModulusLengthInput) m_Wrappers.Result
	RSADecrypt(input RSADecryptInput) m_Wrappers.Result
	RSAEncrypt(input RSAEncryptInput) m_Wrappers.Result
	GenerateECDSASignatureKey(input GenerateECDSASignatureKeyInput) m_Wrappers.Result
	ECDSASign(input ECDSASignInput) m_Wrappers.Result
	ECDSAVerify(input ECDSAVerifyInput) m_Wrappers.Result
	GenerateECCKeyPair(input GenerateECCKeyPairInput) m_Wrappers.Result
	GetPublicKeyFromPrivateKey(input GetPublicKeyFromPrivateKeyInput) m_Wrappers.Result
	ValidatePublicKey(input ValidatePublicKeyInput) m_Wrappers.Result
	DeriveSharedSecret(input DeriveSharedSecretInput) m_Wrappers.Result
	CompressPublicKey(input CompressPublicKeyInput) m_Wrappers.Result
	DecompressPublicKey(input DecompressPublicKeyInput) m_Wrappers.Result
	ParsePublicKey(input ParsePublicKeyInput) m_Wrappers.Result
}
type CompanionStruct_IAwsCryptographicPrimitivesClient_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IAwsCryptographicPrimitivesClient_ = CompanionStruct_IAwsCryptographicPrimitivesClient_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IAwsCryptographicPrimitivesClient_) CastTo_(x interface{}) IAwsCryptographicPrimitivesClient {
	var t IAwsCryptographicPrimitivesClient
	t, _ = x.(IAwsCryptographicPrimitivesClient)
	return t
}

// End of trait IAwsCryptographicPrimitivesClient

// Definition of datatype CompressPublicKeyInput
type CompressPublicKeyInput struct {
	Data_CompressPublicKeyInput_
}

func (_this CompressPublicKeyInput) Get_() Data_CompressPublicKeyInput_ {
	return _this.Data_CompressPublicKeyInput_
}

type Data_CompressPublicKeyInput_ interface {
	isCompressPublicKeyInput()
}

type CompanionStruct_CompressPublicKeyInput_ struct {
}

var Companion_CompressPublicKeyInput_ = CompanionStruct_CompressPublicKeyInput_{}

type CompressPublicKeyInput_CompressPublicKeyInput struct {
	PublicKey ECCPublicKey
	EccCurve  ECDHCurveSpec
}

func (CompressPublicKeyInput_CompressPublicKeyInput) isCompressPublicKeyInput() {}

func (CompanionStruct_CompressPublicKeyInput_) Create_CompressPublicKeyInput_(PublicKey ECCPublicKey, EccCurve ECDHCurveSpec) CompressPublicKeyInput {
	return CompressPublicKeyInput{CompressPublicKeyInput_CompressPublicKeyInput{PublicKey, EccCurve}}
}

func (_this CompressPublicKeyInput) Is_CompressPublicKeyInput() bool {
	_, ok := _this.Get_().(CompressPublicKeyInput_CompressPublicKeyInput)
	return ok
}

func (CompanionStruct_CompressPublicKeyInput_) Default() CompressPublicKeyInput {
	return Companion_CompressPublicKeyInput_.Create_CompressPublicKeyInput_(Companion_ECCPublicKey_.Default(), Companion_ECDHCurveSpec_.Default())
}

func (_this CompressPublicKeyInput) Dtor_publicKey() ECCPublicKey {
	return _this.Get_().(CompressPublicKeyInput_CompressPublicKeyInput).PublicKey
}

func (_this CompressPublicKeyInput) Dtor_eccCurve() ECDHCurveSpec {
	return _this.Get_().(CompressPublicKeyInput_CompressPublicKeyInput).EccCurve
}

func (_this CompressPublicKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CompressPublicKeyInput_CompressPublicKeyInput:
		{
			return "AwsCryptographyPrimitivesTypes.CompressPublicKeyInput.CompressPublicKeyInput" + "(" + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.EccCurve) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CompressPublicKeyInput) Equals(other CompressPublicKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case CompressPublicKeyInput_CompressPublicKeyInput:
		{
			data2, ok := other.Get_().(CompressPublicKeyInput_CompressPublicKeyInput)
			return ok && data1.PublicKey.Equals(data2.PublicKey) && data1.EccCurve.Equals(data2.EccCurve)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CompressPublicKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CompressPublicKeyInput)
	return ok && _this.Equals(typed)
}

func Type_CompressPublicKeyInput_() _dafny.TypeDescriptor {
	return type_CompressPublicKeyInput_{}
}

type type_CompressPublicKeyInput_ struct {
}

func (_this type_CompressPublicKeyInput_) Default() interface{} {
	return Companion_CompressPublicKeyInput_.Default()
}

func (_this type_CompressPublicKeyInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.CompressPublicKeyInput"
}
func (_this CompressPublicKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CompressPublicKeyInput{}

// End of datatype CompressPublicKeyInput

// Definition of datatype CompressPublicKeyOutput
type CompressPublicKeyOutput struct {
	Data_CompressPublicKeyOutput_
}

func (_this CompressPublicKeyOutput) Get_() Data_CompressPublicKeyOutput_ {
	return _this.Data_CompressPublicKeyOutput_
}

type Data_CompressPublicKeyOutput_ interface {
	isCompressPublicKeyOutput()
}

type CompanionStruct_CompressPublicKeyOutput_ struct {
}

var Companion_CompressPublicKeyOutput_ = CompanionStruct_CompressPublicKeyOutput_{}

type CompressPublicKeyOutput_CompressPublicKeyOutput struct {
	CompressedPublicKey _dafny.Sequence
}

func (CompressPublicKeyOutput_CompressPublicKeyOutput) isCompressPublicKeyOutput() {}

func (CompanionStruct_CompressPublicKeyOutput_) Create_CompressPublicKeyOutput_(CompressedPublicKey _dafny.Sequence) CompressPublicKeyOutput {
	return CompressPublicKeyOutput{CompressPublicKeyOutput_CompressPublicKeyOutput{CompressedPublicKey}}
}

func (_this CompressPublicKeyOutput) Is_CompressPublicKeyOutput() bool {
	_, ok := _this.Get_().(CompressPublicKeyOutput_CompressPublicKeyOutput)
	return ok
}

func (CompanionStruct_CompressPublicKeyOutput_) Default() CompressPublicKeyOutput {
	return Companion_CompressPublicKeyOutput_.Create_CompressPublicKeyOutput_(_dafny.EmptySeq)
}

func (_this CompressPublicKeyOutput) Dtor_compressedPublicKey() _dafny.Sequence {
	return _this.Get_().(CompressPublicKeyOutput_CompressPublicKeyOutput).CompressedPublicKey
}

func (_this CompressPublicKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CompressPublicKeyOutput_CompressPublicKeyOutput:
		{
			return "AwsCryptographyPrimitivesTypes.CompressPublicKeyOutput.CompressPublicKeyOutput" + "(" + _dafny.String(data.CompressedPublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CompressPublicKeyOutput) Equals(other CompressPublicKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case CompressPublicKeyOutput_CompressPublicKeyOutput:
		{
			data2, ok := other.Get_().(CompressPublicKeyOutput_CompressPublicKeyOutput)
			return ok && data1.CompressedPublicKey.Equals(data2.CompressedPublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CompressPublicKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CompressPublicKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_CompressPublicKeyOutput_() _dafny.TypeDescriptor {
	return type_CompressPublicKeyOutput_{}
}

type type_CompressPublicKeyOutput_ struct {
}

func (_this type_CompressPublicKeyOutput_) Default() interface{} {
	return Companion_CompressPublicKeyOutput_.Default()
}

func (_this type_CompressPublicKeyOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.CompressPublicKeyOutput"
}
func (_this CompressPublicKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CompressPublicKeyOutput{}

// End of datatype CompressPublicKeyOutput

// Definition of datatype CryptoConfig
type CryptoConfig struct {
	Data_CryptoConfig_
}

func (_this CryptoConfig) Get_() Data_CryptoConfig_ {
	return _this.Data_CryptoConfig_
}

type Data_CryptoConfig_ interface {
	isCryptoConfig()
}

type CompanionStruct_CryptoConfig_ struct {
}

var Companion_CryptoConfig_ = CompanionStruct_CryptoConfig_{}

type CryptoConfig_CryptoConfig struct {
}

func (CryptoConfig_CryptoConfig) isCryptoConfig() {}

func (CompanionStruct_CryptoConfig_) Create_CryptoConfig_() CryptoConfig {
	return CryptoConfig{CryptoConfig_CryptoConfig{}}
}

func (_this CryptoConfig) Is_CryptoConfig() bool {
	_, ok := _this.Get_().(CryptoConfig_CryptoConfig)
	return ok
}

func (CompanionStruct_CryptoConfig_) Default() CryptoConfig {
	return Companion_CryptoConfig_.Create_CryptoConfig_()
}

func (_ CompanionStruct_CryptoConfig_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_CryptoConfig_.Create_CryptoConfig_(), true
		default:
			return CryptoConfig{}, false
		}
	}
}

func (_this CryptoConfig) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case CryptoConfig_CryptoConfig:
		{
			return "AwsCryptographyPrimitivesTypes.CryptoConfig.CryptoConfig"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CryptoConfig) Equals(other CryptoConfig) bool {
	switch _this.Get_().(type) {
	case CryptoConfig_CryptoConfig:
		{
			_, ok := other.Get_().(CryptoConfig_CryptoConfig)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CryptoConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CryptoConfig)
	return ok && _this.Equals(typed)
}

func Type_CryptoConfig_() _dafny.TypeDescriptor {
	return type_CryptoConfig_{}
}

type type_CryptoConfig_ struct {
}

func (_this type_CryptoConfig_) Default() interface{} {
	return Companion_CryptoConfig_.Default()
}

func (_this type_CryptoConfig_) String() string {
	return "AwsCryptographyPrimitivesTypes.CryptoConfig"
}
func (_this CryptoConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CryptoConfig{}

// End of datatype CryptoConfig

// Definition of datatype DecompressPublicKeyInput
type DecompressPublicKeyInput struct {
	Data_DecompressPublicKeyInput_
}

func (_this DecompressPublicKeyInput) Get_() Data_DecompressPublicKeyInput_ {
	return _this.Data_DecompressPublicKeyInput_
}

type Data_DecompressPublicKeyInput_ interface {
	isDecompressPublicKeyInput()
}

type CompanionStruct_DecompressPublicKeyInput_ struct {
}

var Companion_DecompressPublicKeyInput_ = CompanionStruct_DecompressPublicKeyInput_{}

type DecompressPublicKeyInput_DecompressPublicKeyInput struct {
	CompressedPublicKey _dafny.Sequence
	EccCurve            ECDHCurveSpec
}

func (DecompressPublicKeyInput_DecompressPublicKeyInput) isDecompressPublicKeyInput() {}

func (CompanionStruct_DecompressPublicKeyInput_) Create_DecompressPublicKeyInput_(CompressedPublicKey _dafny.Sequence, EccCurve ECDHCurveSpec) DecompressPublicKeyInput {
	return DecompressPublicKeyInput{DecompressPublicKeyInput_DecompressPublicKeyInput{CompressedPublicKey, EccCurve}}
}

func (_this DecompressPublicKeyInput) Is_DecompressPublicKeyInput() bool {
	_, ok := _this.Get_().(DecompressPublicKeyInput_DecompressPublicKeyInput)
	return ok
}

func (CompanionStruct_DecompressPublicKeyInput_) Default() DecompressPublicKeyInput {
	return Companion_DecompressPublicKeyInput_.Create_DecompressPublicKeyInput_(_dafny.EmptySeq, Companion_ECDHCurveSpec_.Default())
}

func (_this DecompressPublicKeyInput) Dtor_compressedPublicKey() _dafny.Sequence {
	return _this.Get_().(DecompressPublicKeyInput_DecompressPublicKeyInput).CompressedPublicKey
}

func (_this DecompressPublicKeyInput) Dtor_eccCurve() ECDHCurveSpec {
	return _this.Get_().(DecompressPublicKeyInput_DecompressPublicKeyInput).EccCurve
}

func (_this DecompressPublicKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecompressPublicKeyInput_DecompressPublicKeyInput:
		{
			return "AwsCryptographyPrimitivesTypes.DecompressPublicKeyInput.DecompressPublicKeyInput" + "(" + _dafny.String(data.CompressedPublicKey) + ", " + _dafny.String(data.EccCurve) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecompressPublicKeyInput) Equals(other DecompressPublicKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case DecompressPublicKeyInput_DecompressPublicKeyInput:
		{
			data2, ok := other.Get_().(DecompressPublicKeyInput_DecompressPublicKeyInput)
			return ok && data1.CompressedPublicKey.Equals(data2.CompressedPublicKey) && data1.EccCurve.Equals(data2.EccCurve)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecompressPublicKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecompressPublicKeyInput)
	return ok && _this.Equals(typed)
}

func Type_DecompressPublicKeyInput_() _dafny.TypeDescriptor {
	return type_DecompressPublicKeyInput_{}
}

type type_DecompressPublicKeyInput_ struct {
}

func (_this type_DecompressPublicKeyInput_) Default() interface{} {
	return Companion_DecompressPublicKeyInput_.Default()
}

func (_this type_DecompressPublicKeyInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.DecompressPublicKeyInput"
}
func (_this DecompressPublicKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecompressPublicKeyInput{}

// End of datatype DecompressPublicKeyInput

// Definition of datatype DecompressPublicKeyOutput
type DecompressPublicKeyOutput struct {
	Data_DecompressPublicKeyOutput_
}

func (_this DecompressPublicKeyOutput) Get_() Data_DecompressPublicKeyOutput_ {
	return _this.Data_DecompressPublicKeyOutput_
}

type Data_DecompressPublicKeyOutput_ interface {
	isDecompressPublicKeyOutput()
}

type CompanionStruct_DecompressPublicKeyOutput_ struct {
}

var Companion_DecompressPublicKeyOutput_ = CompanionStruct_DecompressPublicKeyOutput_{}

type DecompressPublicKeyOutput_DecompressPublicKeyOutput struct {
	PublicKey ECCPublicKey
}

func (DecompressPublicKeyOutput_DecompressPublicKeyOutput) isDecompressPublicKeyOutput() {}

func (CompanionStruct_DecompressPublicKeyOutput_) Create_DecompressPublicKeyOutput_(PublicKey ECCPublicKey) DecompressPublicKeyOutput {
	return DecompressPublicKeyOutput{DecompressPublicKeyOutput_DecompressPublicKeyOutput{PublicKey}}
}

func (_this DecompressPublicKeyOutput) Is_DecompressPublicKeyOutput() bool {
	_, ok := _this.Get_().(DecompressPublicKeyOutput_DecompressPublicKeyOutput)
	return ok
}

func (CompanionStruct_DecompressPublicKeyOutput_) Default() DecompressPublicKeyOutput {
	return Companion_DecompressPublicKeyOutput_.Create_DecompressPublicKeyOutput_(Companion_ECCPublicKey_.Default())
}

func (_this DecompressPublicKeyOutput) Dtor_publicKey() ECCPublicKey {
	return _this.Get_().(DecompressPublicKeyOutput_DecompressPublicKeyOutput).PublicKey
}

func (_this DecompressPublicKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecompressPublicKeyOutput_DecompressPublicKeyOutput:
		{
			return "AwsCryptographyPrimitivesTypes.DecompressPublicKeyOutput.DecompressPublicKeyOutput" + "(" + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecompressPublicKeyOutput) Equals(other DecompressPublicKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case DecompressPublicKeyOutput_DecompressPublicKeyOutput:
		{
			data2, ok := other.Get_().(DecompressPublicKeyOutput_DecompressPublicKeyOutput)
			return ok && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecompressPublicKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecompressPublicKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_DecompressPublicKeyOutput_() _dafny.TypeDescriptor {
	return type_DecompressPublicKeyOutput_{}
}

type type_DecompressPublicKeyOutput_ struct {
}

func (_this type_DecompressPublicKeyOutput_) Default() interface{} {
	return Companion_DecompressPublicKeyOutput_.Default()
}

func (_this type_DecompressPublicKeyOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.DecompressPublicKeyOutput"
}
func (_this DecompressPublicKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecompressPublicKeyOutput{}

// End of datatype DecompressPublicKeyOutput

// Definition of datatype DeriveSharedSecretInput
type DeriveSharedSecretInput struct {
	Data_DeriveSharedSecretInput_
}

func (_this DeriveSharedSecretInput) Get_() Data_DeriveSharedSecretInput_ {
	return _this.Data_DeriveSharedSecretInput_
}

type Data_DeriveSharedSecretInput_ interface {
	isDeriveSharedSecretInput()
}

type CompanionStruct_DeriveSharedSecretInput_ struct {
}

var Companion_DeriveSharedSecretInput_ = CompanionStruct_DeriveSharedSecretInput_{}

type DeriveSharedSecretInput_DeriveSharedSecretInput struct {
	EccCurve   ECDHCurveSpec
	PrivateKey ECCPrivateKey
	PublicKey  ECCPublicKey
}

func (DeriveSharedSecretInput_DeriveSharedSecretInput) isDeriveSharedSecretInput() {}

func (CompanionStruct_DeriveSharedSecretInput_) Create_DeriveSharedSecretInput_(EccCurve ECDHCurveSpec, PrivateKey ECCPrivateKey, PublicKey ECCPublicKey) DeriveSharedSecretInput {
	return DeriveSharedSecretInput{DeriveSharedSecretInput_DeriveSharedSecretInput{EccCurve, PrivateKey, PublicKey}}
}

func (_this DeriveSharedSecretInput) Is_DeriveSharedSecretInput() bool {
	_, ok := _this.Get_().(DeriveSharedSecretInput_DeriveSharedSecretInput)
	return ok
}

func (CompanionStruct_DeriveSharedSecretInput_) Default() DeriveSharedSecretInput {
	return Companion_DeriveSharedSecretInput_.Create_DeriveSharedSecretInput_(Companion_ECDHCurveSpec_.Default(), Companion_ECCPrivateKey_.Default(), Companion_ECCPublicKey_.Default())
}

func (_this DeriveSharedSecretInput) Dtor_eccCurve() ECDHCurveSpec {
	return _this.Get_().(DeriveSharedSecretInput_DeriveSharedSecretInput).EccCurve
}

func (_this DeriveSharedSecretInput) Dtor_privateKey() ECCPrivateKey {
	return _this.Get_().(DeriveSharedSecretInput_DeriveSharedSecretInput).PrivateKey
}

func (_this DeriveSharedSecretInput) Dtor_publicKey() ECCPublicKey {
	return _this.Get_().(DeriveSharedSecretInput_DeriveSharedSecretInput).PublicKey
}

func (_this DeriveSharedSecretInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeriveSharedSecretInput_DeriveSharedSecretInput:
		{
			return "AwsCryptographyPrimitivesTypes.DeriveSharedSecretInput.DeriveSharedSecretInput" + "(" + _dafny.String(data.EccCurve) + ", " + _dafny.String(data.PrivateKey) + ", " + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeriveSharedSecretInput) Equals(other DeriveSharedSecretInput) bool {
	switch data1 := _this.Get_().(type) {
	case DeriveSharedSecretInput_DeriveSharedSecretInput:
		{
			data2, ok := other.Get_().(DeriveSharedSecretInput_DeriveSharedSecretInput)
			return ok && data1.EccCurve.Equals(data2.EccCurve) && data1.PrivateKey.Equals(data2.PrivateKey) && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeriveSharedSecretInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeriveSharedSecretInput)
	return ok && _this.Equals(typed)
}

func Type_DeriveSharedSecretInput_() _dafny.TypeDescriptor {
	return type_DeriveSharedSecretInput_{}
}

type type_DeriveSharedSecretInput_ struct {
}

func (_this type_DeriveSharedSecretInput_) Default() interface{} {
	return Companion_DeriveSharedSecretInput_.Default()
}

func (_this type_DeriveSharedSecretInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.DeriveSharedSecretInput"
}
func (_this DeriveSharedSecretInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeriveSharedSecretInput{}

// End of datatype DeriveSharedSecretInput

// Definition of datatype DeriveSharedSecretOutput
type DeriveSharedSecretOutput struct {
	Data_DeriveSharedSecretOutput_
}

func (_this DeriveSharedSecretOutput) Get_() Data_DeriveSharedSecretOutput_ {
	return _this.Data_DeriveSharedSecretOutput_
}

type Data_DeriveSharedSecretOutput_ interface {
	isDeriveSharedSecretOutput()
}

type CompanionStruct_DeriveSharedSecretOutput_ struct {
}

var Companion_DeriveSharedSecretOutput_ = CompanionStruct_DeriveSharedSecretOutput_{}

type DeriveSharedSecretOutput_DeriveSharedSecretOutput struct {
	SharedSecret _dafny.Sequence
}

func (DeriveSharedSecretOutput_DeriveSharedSecretOutput) isDeriveSharedSecretOutput() {}

func (CompanionStruct_DeriveSharedSecretOutput_) Create_DeriveSharedSecretOutput_(SharedSecret _dafny.Sequence) DeriveSharedSecretOutput {
	return DeriveSharedSecretOutput{DeriveSharedSecretOutput_DeriveSharedSecretOutput{SharedSecret}}
}

func (_this DeriveSharedSecretOutput) Is_DeriveSharedSecretOutput() bool {
	_, ok := _this.Get_().(DeriveSharedSecretOutput_DeriveSharedSecretOutput)
	return ok
}

func (CompanionStruct_DeriveSharedSecretOutput_) Default() DeriveSharedSecretOutput {
	return Companion_DeriveSharedSecretOutput_.Create_DeriveSharedSecretOutput_(_dafny.EmptySeq)
}

func (_this DeriveSharedSecretOutput) Dtor_sharedSecret() _dafny.Sequence {
	return _this.Get_().(DeriveSharedSecretOutput_DeriveSharedSecretOutput).SharedSecret
}

func (_this DeriveSharedSecretOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeriveSharedSecretOutput_DeriveSharedSecretOutput:
		{
			return "AwsCryptographyPrimitivesTypes.DeriveSharedSecretOutput.DeriveSharedSecretOutput" + "(" + _dafny.String(data.SharedSecret) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeriveSharedSecretOutput) Equals(other DeriveSharedSecretOutput) bool {
	switch data1 := _this.Get_().(type) {
	case DeriveSharedSecretOutput_DeriveSharedSecretOutput:
		{
			data2, ok := other.Get_().(DeriveSharedSecretOutput_DeriveSharedSecretOutput)
			return ok && data1.SharedSecret.Equals(data2.SharedSecret)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeriveSharedSecretOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeriveSharedSecretOutput)
	return ok && _this.Equals(typed)
}

func Type_DeriveSharedSecretOutput_() _dafny.TypeDescriptor {
	return type_DeriveSharedSecretOutput_{}
}

type type_DeriveSharedSecretOutput_ struct {
}

func (_this type_DeriveSharedSecretOutput_) Default() interface{} {
	return Companion_DeriveSharedSecretOutput_.Default()
}

func (_this type_DeriveSharedSecretOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.DeriveSharedSecretOutput"
}
func (_this DeriveSharedSecretOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeriveSharedSecretOutput{}

// End of datatype DeriveSharedSecretOutput

// Definition of datatype DigestAlgorithm
type DigestAlgorithm struct {
	Data_DigestAlgorithm_
}

func (_this DigestAlgorithm) Get_() Data_DigestAlgorithm_ {
	return _this.Data_DigestAlgorithm_
}

type Data_DigestAlgorithm_ interface {
	isDigestAlgorithm()
}

type CompanionStruct_DigestAlgorithm_ struct {
}

var Companion_DigestAlgorithm_ = CompanionStruct_DigestAlgorithm_{}

type DigestAlgorithm_SHA__512 struct {
}

func (DigestAlgorithm_SHA__512) isDigestAlgorithm() {}

func (CompanionStruct_DigestAlgorithm_) Create_SHA__512_() DigestAlgorithm {
	return DigestAlgorithm{DigestAlgorithm_SHA__512{}}
}

func (_this DigestAlgorithm) Is_SHA__512() bool {
	_, ok := _this.Get_().(DigestAlgorithm_SHA__512)
	return ok
}

type DigestAlgorithm_SHA__384 struct {
}

func (DigestAlgorithm_SHA__384) isDigestAlgorithm() {}

func (CompanionStruct_DigestAlgorithm_) Create_SHA__384_() DigestAlgorithm {
	return DigestAlgorithm{DigestAlgorithm_SHA__384{}}
}

func (_this DigestAlgorithm) Is_SHA__384() bool {
	_, ok := _this.Get_().(DigestAlgorithm_SHA__384)
	return ok
}

type DigestAlgorithm_SHA__256 struct {
}

func (DigestAlgorithm_SHA__256) isDigestAlgorithm() {}

func (CompanionStruct_DigestAlgorithm_) Create_SHA__256_() DigestAlgorithm {
	return DigestAlgorithm{DigestAlgorithm_SHA__256{}}
}

func (_this DigestAlgorithm) Is_SHA__256() bool {
	_, ok := _this.Get_().(DigestAlgorithm_SHA__256)
	return ok
}

func (CompanionStruct_DigestAlgorithm_) Default() DigestAlgorithm {
	return Companion_DigestAlgorithm_.Create_SHA__512_()
}

func (_ CompanionStruct_DigestAlgorithm_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DigestAlgorithm_.Create_SHA__512_(), true
		case 1:
			return Companion_DigestAlgorithm_.Create_SHA__384_(), true
		case 2:
			return Companion_DigestAlgorithm_.Create_SHA__256_(), true
		default:
			return DigestAlgorithm{}, false
		}
	}
}

func (_this DigestAlgorithm) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DigestAlgorithm_SHA__512:
		{
			return "AwsCryptographyPrimitivesTypes.DigestAlgorithm.SHA_512"
		}
	case DigestAlgorithm_SHA__384:
		{
			return "AwsCryptographyPrimitivesTypes.DigestAlgorithm.SHA_384"
		}
	case DigestAlgorithm_SHA__256:
		{
			return "AwsCryptographyPrimitivesTypes.DigestAlgorithm.SHA_256"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DigestAlgorithm) Equals(other DigestAlgorithm) bool {
	switch _this.Get_().(type) {
	case DigestAlgorithm_SHA__512:
		{
			_, ok := other.Get_().(DigestAlgorithm_SHA__512)
			return ok
		}
	case DigestAlgorithm_SHA__384:
		{
			_, ok := other.Get_().(DigestAlgorithm_SHA__384)
			return ok
		}
	case DigestAlgorithm_SHA__256:
		{
			_, ok := other.Get_().(DigestAlgorithm_SHA__256)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DigestAlgorithm) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DigestAlgorithm)
	return ok && _this.Equals(typed)
}

func Type_DigestAlgorithm_() _dafny.TypeDescriptor {
	return type_DigestAlgorithm_{}
}

type type_DigestAlgorithm_ struct {
}

func (_this type_DigestAlgorithm_) Default() interface{} {
	return Companion_DigestAlgorithm_.Default()
}

func (_this type_DigestAlgorithm_) String() string {
	return "AwsCryptographyPrimitivesTypes.DigestAlgorithm"
}
func (_this DigestAlgorithm) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DigestAlgorithm{}

// End of datatype DigestAlgorithm

// Definition of datatype DigestInput
type DigestInput struct {
	Data_DigestInput_
}

func (_this DigestInput) Get_() Data_DigestInput_ {
	return _this.Data_DigestInput_
}

type Data_DigestInput_ interface {
	isDigestInput()
}

type CompanionStruct_DigestInput_ struct {
}

var Companion_DigestInput_ = CompanionStruct_DigestInput_{}

type DigestInput_DigestInput struct {
	DigestAlgorithm DigestAlgorithm
	Message         _dafny.Sequence
}

func (DigestInput_DigestInput) isDigestInput() {}

func (CompanionStruct_DigestInput_) Create_DigestInput_(DigestAlgorithm DigestAlgorithm, Message _dafny.Sequence) DigestInput {
	return DigestInput{DigestInput_DigestInput{DigestAlgorithm, Message}}
}

func (_this DigestInput) Is_DigestInput() bool {
	_, ok := _this.Get_().(DigestInput_DigestInput)
	return ok
}

func (CompanionStruct_DigestInput_) Default() DigestInput {
	return Companion_DigestInput_.Create_DigestInput_(Companion_DigestAlgorithm_.Default(), _dafny.EmptySeq)
}

func (_this DigestInput) Dtor_digestAlgorithm() DigestAlgorithm {
	return _this.Get_().(DigestInput_DigestInput).DigestAlgorithm
}

func (_this DigestInput) Dtor_message() _dafny.Sequence {
	return _this.Get_().(DigestInput_DigestInput).Message
}

func (_this DigestInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DigestInput_DigestInput:
		{
			return "AwsCryptographyPrimitivesTypes.DigestInput.DigestInput" + "(" + _dafny.String(data.DigestAlgorithm) + ", " + _dafny.String(data.Message) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DigestInput) Equals(other DigestInput) bool {
	switch data1 := _this.Get_().(type) {
	case DigestInput_DigestInput:
		{
			data2, ok := other.Get_().(DigestInput_DigestInput)
			return ok && data1.DigestAlgorithm.Equals(data2.DigestAlgorithm) && data1.Message.Equals(data2.Message)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DigestInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DigestInput)
	return ok && _this.Equals(typed)
}

func Type_DigestInput_() _dafny.TypeDescriptor {
	return type_DigestInput_{}
}

type type_DigestInput_ struct {
}

func (_this type_DigestInput_) Default() interface{} {
	return Companion_DigestInput_.Default()
}

func (_this type_DigestInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.DigestInput"
}
func (_this DigestInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DigestInput{}

// End of datatype DigestInput

// Definition of datatype ECCPrivateKey
type ECCPrivateKey struct {
	Data_ECCPrivateKey_
}

func (_this ECCPrivateKey) Get_() Data_ECCPrivateKey_ {
	return _this.Data_ECCPrivateKey_
}

type Data_ECCPrivateKey_ interface {
	isECCPrivateKey()
}

type CompanionStruct_ECCPrivateKey_ struct {
}

var Companion_ECCPrivateKey_ = CompanionStruct_ECCPrivateKey_{}

type ECCPrivateKey_ECCPrivateKey struct {
	Pem _dafny.Sequence
}

func (ECCPrivateKey_ECCPrivateKey) isECCPrivateKey() {}

func (CompanionStruct_ECCPrivateKey_) Create_ECCPrivateKey_(Pem _dafny.Sequence) ECCPrivateKey {
	return ECCPrivateKey{ECCPrivateKey_ECCPrivateKey{Pem}}
}

func (_this ECCPrivateKey) Is_ECCPrivateKey() bool {
	_, ok := _this.Get_().(ECCPrivateKey_ECCPrivateKey)
	return ok
}

func (CompanionStruct_ECCPrivateKey_) Default() ECCPrivateKey {
	return Companion_ECCPrivateKey_.Create_ECCPrivateKey_(_dafny.EmptySeq)
}

func (_this ECCPrivateKey) Dtor_pem() _dafny.Sequence {
	return _this.Get_().(ECCPrivateKey_ECCPrivateKey).Pem
}

func (_this ECCPrivateKey) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ECCPrivateKey_ECCPrivateKey:
		{
			return "AwsCryptographyPrimitivesTypes.ECCPrivateKey.ECCPrivateKey" + "(" + _dafny.String(data.Pem) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ECCPrivateKey) Equals(other ECCPrivateKey) bool {
	switch data1 := _this.Get_().(type) {
	case ECCPrivateKey_ECCPrivateKey:
		{
			data2, ok := other.Get_().(ECCPrivateKey_ECCPrivateKey)
			return ok && data1.Pem.Equals(data2.Pem)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ECCPrivateKey) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ECCPrivateKey)
	return ok && _this.Equals(typed)
}

func Type_ECCPrivateKey_() _dafny.TypeDescriptor {
	return type_ECCPrivateKey_{}
}

type type_ECCPrivateKey_ struct {
}

func (_this type_ECCPrivateKey_) Default() interface{} {
	return Companion_ECCPrivateKey_.Default()
}

func (_this type_ECCPrivateKey_) String() string {
	return "AwsCryptographyPrimitivesTypes.ECCPrivateKey"
}
func (_this ECCPrivateKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ECCPrivateKey{}

// End of datatype ECCPrivateKey

// Definition of datatype ECCPublicKey
type ECCPublicKey struct {
	Data_ECCPublicKey_
}

func (_this ECCPublicKey) Get_() Data_ECCPublicKey_ {
	return _this.Data_ECCPublicKey_
}

type Data_ECCPublicKey_ interface {
	isECCPublicKey()
}

type CompanionStruct_ECCPublicKey_ struct {
}

var Companion_ECCPublicKey_ = CompanionStruct_ECCPublicKey_{}

type ECCPublicKey_ECCPublicKey struct {
	Der _dafny.Sequence
}

func (ECCPublicKey_ECCPublicKey) isECCPublicKey() {}

func (CompanionStruct_ECCPublicKey_) Create_ECCPublicKey_(Der _dafny.Sequence) ECCPublicKey {
	return ECCPublicKey{ECCPublicKey_ECCPublicKey{Der}}
}

func (_this ECCPublicKey) Is_ECCPublicKey() bool {
	_, ok := _this.Get_().(ECCPublicKey_ECCPublicKey)
	return ok
}

func (CompanionStruct_ECCPublicKey_) Default() ECCPublicKey {
	return Companion_ECCPublicKey_.Create_ECCPublicKey_(_dafny.EmptySeq)
}

func (_this ECCPublicKey) Dtor_der() _dafny.Sequence {
	return _this.Get_().(ECCPublicKey_ECCPublicKey).Der
}

func (_this ECCPublicKey) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ECCPublicKey_ECCPublicKey:
		{
			return "AwsCryptographyPrimitivesTypes.ECCPublicKey.ECCPublicKey" + "(" + _dafny.String(data.Der) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ECCPublicKey) Equals(other ECCPublicKey) bool {
	switch data1 := _this.Get_().(type) {
	case ECCPublicKey_ECCPublicKey:
		{
			data2, ok := other.Get_().(ECCPublicKey_ECCPublicKey)
			return ok && data1.Der.Equals(data2.Der)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ECCPublicKey) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ECCPublicKey)
	return ok && _this.Equals(typed)
}

func Type_ECCPublicKey_() _dafny.TypeDescriptor {
	return type_ECCPublicKey_{}
}

type type_ECCPublicKey_ struct {
}

func (_this type_ECCPublicKey_) Default() interface{} {
	return Companion_ECCPublicKey_.Default()
}

func (_this type_ECCPublicKey_) String() string {
	return "AwsCryptographyPrimitivesTypes.ECCPublicKey"
}
func (_this ECCPublicKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ECCPublicKey{}

// End of datatype ECCPublicKey

// Definition of datatype ECDHCurveSpec
type ECDHCurveSpec struct {
	Data_ECDHCurveSpec_
}

func (_this ECDHCurveSpec) Get_() Data_ECDHCurveSpec_ {
	return _this.Data_ECDHCurveSpec_
}

type Data_ECDHCurveSpec_ interface {
	isECDHCurveSpec()
}

type CompanionStruct_ECDHCurveSpec_ struct {
}

var Companion_ECDHCurveSpec_ = CompanionStruct_ECDHCurveSpec_{}

type ECDHCurveSpec_ECC__NIST__P256 struct {
}

func (ECDHCurveSpec_ECC__NIST__P256) isECDHCurveSpec() {}

func (CompanionStruct_ECDHCurveSpec_) Create_ECC__NIST__P256_() ECDHCurveSpec {
	return ECDHCurveSpec{ECDHCurveSpec_ECC__NIST__P256{}}
}

func (_this ECDHCurveSpec) Is_ECC__NIST__P256() bool {
	_, ok := _this.Get_().(ECDHCurveSpec_ECC__NIST__P256)
	return ok
}

type ECDHCurveSpec_ECC__NIST__P384 struct {
}

func (ECDHCurveSpec_ECC__NIST__P384) isECDHCurveSpec() {}

func (CompanionStruct_ECDHCurveSpec_) Create_ECC__NIST__P384_() ECDHCurveSpec {
	return ECDHCurveSpec{ECDHCurveSpec_ECC__NIST__P384{}}
}

func (_this ECDHCurveSpec) Is_ECC__NIST__P384() bool {
	_, ok := _this.Get_().(ECDHCurveSpec_ECC__NIST__P384)
	return ok
}

type ECDHCurveSpec_ECC__NIST__P521 struct {
}

func (ECDHCurveSpec_ECC__NIST__P521) isECDHCurveSpec() {}

func (CompanionStruct_ECDHCurveSpec_) Create_ECC__NIST__P521_() ECDHCurveSpec {
	return ECDHCurveSpec{ECDHCurveSpec_ECC__NIST__P521{}}
}

func (_this ECDHCurveSpec) Is_ECC__NIST__P521() bool {
	_, ok := _this.Get_().(ECDHCurveSpec_ECC__NIST__P521)
	return ok
}

type ECDHCurveSpec_SM2 struct {
}

func (ECDHCurveSpec_SM2) isECDHCurveSpec() {}

func (CompanionStruct_ECDHCurveSpec_) Create_SM2_() ECDHCurveSpec {
	return ECDHCurveSpec{ECDHCurveSpec_SM2{}}
}

func (_this ECDHCurveSpec) Is_SM2() bool {
	_, ok := _this.Get_().(ECDHCurveSpec_SM2)
	return ok
}

func (CompanionStruct_ECDHCurveSpec_) Default() ECDHCurveSpec {
	return Companion_ECDHCurveSpec_.Create_ECC__NIST__P256_()
}

func (_ CompanionStruct_ECDHCurveSpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ECDHCurveSpec_.Create_ECC__NIST__P256_(), true
		case 1:
			return Companion_ECDHCurveSpec_.Create_ECC__NIST__P384_(), true
		case 2:
			return Companion_ECDHCurveSpec_.Create_ECC__NIST__P521_(), true
		case 3:
			return Companion_ECDHCurveSpec_.Create_SM2_(), true
		default:
			return ECDHCurveSpec{}, false
		}
	}
}

func (_this ECDHCurveSpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ECDHCurveSpec_ECC__NIST__P256:
		{
			return "AwsCryptographyPrimitivesTypes.ECDHCurveSpec.ECC_NIST_P256"
		}
	case ECDHCurveSpec_ECC__NIST__P384:
		{
			return "AwsCryptographyPrimitivesTypes.ECDHCurveSpec.ECC_NIST_P384"
		}
	case ECDHCurveSpec_ECC__NIST__P521:
		{
			return "AwsCryptographyPrimitivesTypes.ECDHCurveSpec.ECC_NIST_P521"
		}
	case ECDHCurveSpec_SM2:
		{
			return "AwsCryptographyPrimitivesTypes.ECDHCurveSpec.SM2"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ECDHCurveSpec) Equals(other ECDHCurveSpec) bool {
	switch _this.Get_().(type) {
	case ECDHCurveSpec_ECC__NIST__P256:
		{
			_, ok := other.Get_().(ECDHCurveSpec_ECC__NIST__P256)
			return ok
		}
	case ECDHCurveSpec_ECC__NIST__P384:
		{
			_, ok := other.Get_().(ECDHCurveSpec_ECC__NIST__P384)
			return ok
		}
	case ECDHCurveSpec_ECC__NIST__P521:
		{
			_, ok := other.Get_().(ECDHCurveSpec_ECC__NIST__P521)
			return ok
		}
	case ECDHCurveSpec_SM2:
		{
			_, ok := other.Get_().(ECDHCurveSpec_SM2)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ECDHCurveSpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ECDHCurveSpec)
	return ok && _this.Equals(typed)
}

func Type_ECDHCurveSpec_() _dafny.TypeDescriptor {
	return type_ECDHCurveSpec_{}
}

type type_ECDHCurveSpec_ struct {
}

func (_this type_ECDHCurveSpec_) Default() interface{} {
	return Companion_ECDHCurveSpec_.Default()
}

func (_this type_ECDHCurveSpec_) String() string {
	return "AwsCryptographyPrimitivesTypes.ECDHCurveSpec"
}
func (_this ECDHCurveSpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ECDHCurveSpec{}

// End of datatype ECDHCurveSpec

// Definition of datatype ECDSASignatureAlgorithm
type ECDSASignatureAlgorithm struct {
	Data_ECDSASignatureAlgorithm_
}

func (_this ECDSASignatureAlgorithm) Get_() Data_ECDSASignatureAlgorithm_ {
	return _this.Data_ECDSASignatureAlgorithm_
}

type Data_ECDSASignatureAlgorithm_ interface {
	isECDSASignatureAlgorithm()
}

type CompanionStruct_ECDSASignatureAlgorithm_ struct {
}

var Companion_ECDSASignatureAlgorithm_ = CompanionStruct_ECDSASignatureAlgorithm_{}

type ECDSASignatureAlgorithm_ECDSA__P384 struct {
}

func (ECDSASignatureAlgorithm_ECDSA__P384) isECDSASignatureAlgorithm() {}

func (CompanionStruct_ECDSASignatureAlgorithm_) Create_ECDSA__P384_() ECDSASignatureAlgorithm {
	return ECDSASignatureAlgorithm{ECDSASignatureAlgorithm_ECDSA__P384{}}
}

func (_this ECDSASignatureAlgorithm) Is_ECDSA__P384() bool {
	_, ok := _this.Get_().(ECDSASignatureAlgorithm_ECDSA__P384)
	return ok
}

type ECDSASignatureAlgorithm_ECDSA__P256 struct {
}

func (ECDSASignatureAlgorithm_ECDSA__P256) isECDSASignatureAlgorithm() {}

func (CompanionStruct_ECDSASignatureAlgorithm_) Create_ECDSA__P256_() ECDSASignatureAlgorithm {
	return ECDSASignatureAlgorithm{ECDSASignatureAlgorithm_ECDSA__P256{}}
}

func (_this ECDSASignatureAlgorithm) Is_ECDSA__P256() bool {
	_, ok := _this.Get_().(ECDSASignatureAlgorithm_ECDSA__P256)
	return ok
}

func (CompanionStruct_ECDSASignatureAlgorithm_) Default() ECDSASignatureAlgorithm {
	return Companion_ECDSASignatureAlgorithm_.Create_ECDSA__P384_()
}

func (_ CompanionStruct_ECDSASignatureAlgorithm_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ECDSASignatureAlgorithm_.Create_ECDSA__P384_(), true
		case 1:
			return Companion_ECDSASignatureAlgorithm_.Create_ECDSA__P256_(), true
		default:
			return ECDSASignatureAlgorithm{}, false
		}
	}
}

func (_this ECDSASignatureAlgorithm) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ECDSASignatureAlgorithm_ECDSA__P384:
		{
			return "AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm.ECDSA_P384"
		}
	case ECDSASignatureAlgorithm_ECDSA__P256:
		{
			return "AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm.ECDSA_P256"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ECDSASignatureAlgorithm) Equals(other ECDSASignatureAlgorithm) bool {
	switch _this.Get_().(type) {
	case ECDSASignatureAlgorithm_ECDSA__P384:
		{
			_, ok := other.Get_().(ECDSASignatureAlgorithm_ECDSA__P384)
			return ok
		}
	case ECDSASignatureAlgorithm_ECDSA__P256:
		{
			_, ok := other.Get_().(ECDSASignatureAlgorithm_ECDSA__P256)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ECDSASignatureAlgorithm) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ECDSASignatureAlgorithm)
	return ok && _this.Equals(typed)
}

func Type_ECDSASignatureAlgorithm_() _dafny.TypeDescriptor {
	return type_ECDSASignatureAlgorithm_{}
}

type type_ECDSASignatureAlgorithm_ struct {
}

func (_this type_ECDSASignatureAlgorithm_) Default() interface{} {
	return Companion_ECDSASignatureAlgorithm_.Default()
}

func (_this type_ECDSASignatureAlgorithm_) String() string {
	return "AwsCryptographyPrimitivesTypes.ECDSASignatureAlgorithm"
}
func (_this ECDSASignatureAlgorithm) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ECDSASignatureAlgorithm{}

// End of datatype ECDSASignatureAlgorithm

// Definition of datatype ECDSASignInput
type ECDSASignInput struct {
	Data_ECDSASignInput_
}

func (_this ECDSASignInput) Get_() Data_ECDSASignInput_ {
	return _this.Data_ECDSASignInput_
}

type Data_ECDSASignInput_ interface {
	isECDSASignInput()
}

type CompanionStruct_ECDSASignInput_ struct {
}

var Companion_ECDSASignInput_ = CompanionStruct_ECDSASignInput_{}

type ECDSASignInput_ECDSASignInput struct {
	SignatureAlgorithm ECDSASignatureAlgorithm
	SigningKey         _dafny.Sequence
	Message            _dafny.Sequence
}

func (ECDSASignInput_ECDSASignInput) isECDSASignInput() {}

func (CompanionStruct_ECDSASignInput_) Create_ECDSASignInput_(SignatureAlgorithm ECDSASignatureAlgorithm, SigningKey _dafny.Sequence, Message _dafny.Sequence) ECDSASignInput {
	return ECDSASignInput{ECDSASignInput_ECDSASignInput{SignatureAlgorithm, SigningKey, Message}}
}

func (_this ECDSASignInput) Is_ECDSASignInput() bool {
	_, ok := _this.Get_().(ECDSASignInput_ECDSASignInput)
	return ok
}

func (CompanionStruct_ECDSASignInput_) Default() ECDSASignInput {
	return Companion_ECDSASignInput_.Create_ECDSASignInput_(Companion_ECDSASignatureAlgorithm_.Default(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this ECDSASignInput) Dtor_signatureAlgorithm() ECDSASignatureAlgorithm {
	return _this.Get_().(ECDSASignInput_ECDSASignInput).SignatureAlgorithm
}

func (_this ECDSASignInput) Dtor_signingKey() _dafny.Sequence {
	return _this.Get_().(ECDSASignInput_ECDSASignInput).SigningKey
}

func (_this ECDSASignInput) Dtor_message() _dafny.Sequence {
	return _this.Get_().(ECDSASignInput_ECDSASignInput).Message
}

func (_this ECDSASignInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ECDSASignInput_ECDSASignInput:
		{
			return "AwsCryptographyPrimitivesTypes.ECDSASignInput.ECDSASignInput" + "(" + _dafny.String(data.SignatureAlgorithm) + ", " + _dafny.String(data.SigningKey) + ", " + _dafny.String(data.Message) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ECDSASignInput) Equals(other ECDSASignInput) bool {
	switch data1 := _this.Get_().(type) {
	case ECDSASignInput_ECDSASignInput:
		{
			data2, ok := other.Get_().(ECDSASignInput_ECDSASignInput)
			return ok && data1.SignatureAlgorithm.Equals(data2.SignatureAlgorithm) && data1.SigningKey.Equals(data2.SigningKey) && data1.Message.Equals(data2.Message)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ECDSASignInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ECDSASignInput)
	return ok && _this.Equals(typed)
}

func Type_ECDSASignInput_() _dafny.TypeDescriptor {
	return type_ECDSASignInput_{}
}

type type_ECDSASignInput_ struct {
}

func (_this type_ECDSASignInput_) Default() interface{} {
	return Companion_ECDSASignInput_.Default()
}

func (_this type_ECDSASignInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.ECDSASignInput"
}
func (_this ECDSASignInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ECDSASignInput{}

// End of datatype ECDSASignInput

// Definition of datatype ECDSAVerifyInput
type ECDSAVerifyInput struct {
	Data_ECDSAVerifyInput_
}

func (_this ECDSAVerifyInput) Get_() Data_ECDSAVerifyInput_ {
	return _this.Data_ECDSAVerifyInput_
}

type Data_ECDSAVerifyInput_ interface {
	isECDSAVerifyInput()
}

type CompanionStruct_ECDSAVerifyInput_ struct {
}

var Companion_ECDSAVerifyInput_ = CompanionStruct_ECDSAVerifyInput_{}

type ECDSAVerifyInput_ECDSAVerifyInput struct {
	SignatureAlgorithm ECDSASignatureAlgorithm
	VerificationKey    _dafny.Sequence
	Message            _dafny.Sequence
	Signature          _dafny.Sequence
}

func (ECDSAVerifyInput_ECDSAVerifyInput) isECDSAVerifyInput() {}

func (CompanionStruct_ECDSAVerifyInput_) Create_ECDSAVerifyInput_(SignatureAlgorithm ECDSASignatureAlgorithm, VerificationKey _dafny.Sequence, Message _dafny.Sequence, Signature _dafny.Sequence) ECDSAVerifyInput {
	return ECDSAVerifyInput{ECDSAVerifyInput_ECDSAVerifyInput{SignatureAlgorithm, VerificationKey, Message, Signature}}
}

func (_this ECDSAVerifyInput) Is_ECDSAVerifyInput() bool {
	_, ok := _this.Get_().(ECDSAVerifyInput_ECDSAVerifyInput)
	return ok
}

func (CompanionStruct_ECDSAVerifyInput_) Default() ECDSAVerifyInput {
	return Companion_ECDSAVerifyInput_.Create_ECDSAVerifyInput_(Companion_ECDSASignatureAlgorithm_.Default(), _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this ECDSAVerifyInput) Dtor_signatureAlgorithm() ECDSASignatureAlgorithm {
	return _this.Get_().(ECDSAVerifyInput_ECDSAVerifyInput).SignatureAlgorithm
}

func (_this ECDSAVerifyInput) Dtor_verificationKey() _dafny.Sequence {
	return _this.Get_().(ECDSAVerifyInput_ECDSAVerifyInput).VerificationKey
}

func (_this ECDSAVerifyInput) Dtor_message() _dafny.Sequence {
	return _this.Get_().(ECDSAVerifyInput_ECDSAVerifyInput).Message
}

func (_this ECDSAVerifyInput) Dtor_signature() _dafny.Sequence {
	return _this.Get_().(ECDSAVerifyInput_ECDSAVerifyInput).Signature
}

func (_this ECDSAVerifyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ECDSAVerifyInput_ECDSAVerifyInput:
		{
			return "AwsCryptographyPrimitivesTypes.ECDSAVerifyInput.ECDSAVerifyInput" + "(" + _dafny.String(data.SignatureAlgorithm) + ", " + _dafny.String(data.VerificationKey) + ", " + _dafny.String(data.Message) + ", " + _dafny.String(data.Signature) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ECDSAVerifyInput) Equals(other ECDSAVerifyInput) bool {
	switch data1 := _this.Get_().(type) {
	case ECDSAVerifyInput_ECDSAVerifyInput:
		{
			data2, ok := other.Get_().(ECDSAVerifyInput_ECDSAVerifyInput)
			return ok && data1.SignatureAlgorithm.Equals(data2.SignatureAlgorithm) && data1.VerificationKey.Equals(data2.VerificationKey) && data1.Message.Equals(data2.Message) && data1.Signature.Equals(data2.Signature)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ECDSAVerifyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ECDSAVerifyInput)
	return ok && _this.Equals(typed)
}

func Type_ECDSAVerifyInput_() _dafny.TypeDescriptor {
	return type_ECDSAVerifyInput_{}
}

type type_ECDSAVerifyInput_ struct {
}

func (_this type_ECDSAVerifyInput_) Default() interface{} {
	return Companion_ECDSAVerifyInput_.Default()
}

func (_this type_ECDSAVerifyInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.ECDSAVerifyInput"
}
func (_this ECDSAVerifyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ECDSAVerifyInput{}

// End of datatype ECDSAVerifyInput

// Definition of datatype GenerateECCKeyPairInput
type GenerateECCKeyPairInput struct {
	Data_GenerateECCKeyPairInput_
}

func (_this GenerateECCKeyPairInput) Get_() Data_GenerateECCKeyPairInput_ {
	return _this.Data_GenerateECCKeyPairInput_
}

type Data_GenerateECCKeyPairInput_ interface {
	isGenerateECCKeyPairInput()
}

type CompanionStruct_GenerateECCKeyPairInput_ struct {
}

var Companion_GenerateECCKeyPairInput_ = CompanionStruct_GenerateECCKeyPairInput_{}

type GenerateECCKeyPairInput_GenerateECCKeyPairInput struct {
	EccCurve ECDHCurveSpec
}

func (GenerateECCKeyPairInput_GenerateECCKeyPairInput) isGenerateECCKeyPairInput() {}

func (CompanionStruct_GenerateECCKeyPairInput_) Create_GenerateECCKeyPairInput_(EccCurve ECDHCurveSpec) GenerateECCKeyPairInput {
	return GenerateECCKeyPairInput{GenerateECCKeyPairInput_GenerateECCKeyPairInput{EccCurve}}
}

func (_this GenerateECCKeyPairInput) Is_GenerateECCKeyPairInput() bool {
	_, ok := _this.Get_().(GenerateECCKeyPairInput_GenerateECCKeyPairInput)
	return ok
}

func (CompanionStruct_GenerateECCKeyPairInput_) Default() GenerateECCKeyPairInput {
	return Companion_GenerateECCKeyPairInput_.Create_GenerateECCKeyPairInput_(Companion_ECDHCurveSpec_.Default())
}

func (_this GenerateECCKeyPairInput) Dtor_eccCurve() ECDHCurveSpec {
	return _this.Get_().(GenerateECCKeyPairInput_GenerateECCKeyPairInput).EccCurve
}

func (_this GenerateECCKeyPairInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateECCKeyPairInput_GenerateECCKeyPairInput:
		{
			return "AwsCryptographyPrimitivesTypes.GenerateECCKeyPairInput.GenerateECCKeyPairInput" + "(" + _dafny.String(data.EccCurve) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateECCKeyPairInput) Equals(other GenerateECCKeyPairInput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateECCKeyPairInput_GenerateECCKeyPairInput:
		{
			data2, ok := other.Get_().(GenerateECCKeyPairInput_GenerateECCKeyPairInput)
			return ok && data1.EccCurve.Equals(data2.EccCurve)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateECCKeyPairInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateECCKeyPairInput)
	return ok && _this.Equals(typed)
}

func Type_GenerateECCKeyPairInput_() _dafny.TypeDescriptor {
	return type_GenerateECCKeyPairInput_{}
}

type type_GenerateECCKeyPairInput_ struct {
}

func (_this type_GenerateECCKeyPairInput_) Default() interface{} {
	return Companion_GenerateECCKeyPairInput_.Default()
}

func (_this type_GenerateECCKeyPairInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GenerateECCKeyPairInput"
}
func (_this GenerateECCKeyPairInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateECCKeyPairInput{}

// End of datatype GenerateECCKeyPairInput

// Definition of datatype GenerateECCKeyPairOutput
type GenerateECCKeyPairOutput struct {
	Data_GenerateECCKeyPairOutput_
}

func (_this GenerateECCKeyPairOutput) Get_() Data_GenerateECCKeyPairOutput_ {
	return _this.Data_GenerateECCKeyPairOutput_
}

type Data_GenerateECCKeyPairOutput_ interface {
	isGenerateECCKeyPairOutput()
}

type CompanionStruct_GenerateECCKeyPairOutput_ struct {
}

var Companion_GenerateECCKeyPairOutput_ = CompanionStruct_GenerateECCKeyPairOutput_{}

type GenerateECCKeyPairOutput_GenerateECCKeyPairOutput struct {
	EccCurve   ECDHCurveSpec
	PrivateKey ECCPrivateKey
	PublicKey  ECCPublicKey
}

func (GenerateECCKeyPairOutput_GenerateECCKeyPairOutput) isGenerateECCKeyPairOutput() {}

func (CompanionStruct_GenerateECCKeyPairOutput_) Create_GenerateECCKeyPairOutput_(EccCurve ECDHCurveSpec, PrivateKey ECCPrivateKey, PublicKey ECCPublicKey) GenerateECCKeyPairOutput {
	return GenerateECCKeyPairOutput{GenerateECCKeyPairOutput_GenerateECCKeyPairOutput{EccCurve, PrivateKey, PublicKey}}
}

func (_this GenerateECCKeyPairOutput) Is_GenerateECCKeyPairOutput() bool {
	_, ok := _this.Get_().(GenerateECCKeyPairOutput_GenerateECCKeyPairOutput)
	return ok
}

func (CompanionStruct_GenerateECCKeyPairOutput_) Default() GenerateECCKeyPairOutput {
	return Companion_GenerateECCKeyPairOutput_.Create_GenerateECCKeyPairOutput_(Companion_ECDHCurveSpec_.Default(), Companion_ECCPrivateKey_.Default(), Companion_ECCPublicKey_.Default())
}

func (_this GenerateECCKeyPairOutput) Dtor_eccCurve() ECDHCurveSpec {
	return _this.Get_().(GenerateECCKeyPairOutput_GenerateECCKeyPairOutput).EccCurve
}

func (_this GenerateECCKeyPairOutput) Dtor_privateKey() ECCPrivateKey {
	return _this.Get_().(GenerateECCKeyPairOutput_GenerateECCKeyPairOutput).PrivateKey
}

func (_this GenerateECCKeyPairOutput) Dtor_publicKey() ECCPublicKey {
	return _this.Get_().(GenerateECCKeyPairOutput_GenerateECCKeyPairOutput).PublicKey
}

func (_this GenerateECCKeyPairOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateECCKeyPairOutput_GenerateECCKeyPairOutput:
		{
			return "AwsCryptographyPrimitivesTypes.GenerateECCKeyPairOutput.GenerateECCKeyPairOutput" + "(" + _dafny.String(data.EccCurve) + ", " + _dafny.String(data.PrivateKey) + ", " + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateECCKeyPairOutput) Equals(other GenerateECCKeyPairOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateECCKeyPairOutput_GenerateECCKeyPairOutput:
		{
			data2, ok := other.Get_().(GenerateECCKeyPairOutput_GenerateECCKeyPairOutput)
			return ok && data1.EccCurve.Equals(data2.EccCurve) && data1.PrivateKey.Equals(data2.PrivateKey) && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateECCKeyPairOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateECCKeyPairOutput)
	return ok && _this.Equals(typed)
}

func Type_GenerateECCKeyPairOutput_() _dafny.TypeDescriptor {
	return type_GenerateECCKeyPairOutput_{}
}

type type_GenerateECCKeyPairOutput_ struct {
}

func (_this type_GenerateECCKeyPairOutput_) Default() interface{} {
	return Companion_GenerateECCKeyPairOutput_.Default()
}

func (_this type_GenerateECCKeyPairOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GenerateECCKeyPairOutput"
}
func (_this GenerateECCKeyPairOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateECCKeyPairOutput{}

// End of datatype GenerateECCKeyPairOutput

// Definition of datatype GenerateECDSASignatureKeyInput
type GenerateECDSASignatureKeyInput struct {
	Data_GenerateECDSASignatureKeyInput_
}

func (_this GenerateECDSASignatureKeyInput) Get_() Data_GenerateECDSASignatureKeyInput_ {
	return _this.Data_GenerateECDSASignatureKeyInput_
}

type Data_GenerateECDSASignatureKeyInput_ interface {
	isGenerateECDSASignatureKeyInput()
}

type CompanionStruct_GenerateECDSASignatureKeyInput_ struct {
}

var Companion_GenerateECDSASignatureKeyInput_ = CompanionStruct_GenerateECDSASignatureKeyInput_{}

type GenerateECDSASignatureKeyInput_GenerateECDSASignatureKeyInput struct {
	SignatureAlgorithm ECDSASignatureAlgorithm
}

func (GenerateECDSASignatureKeyInput_GenerateECDSASignatureKeyInput) isGenerateECDSASignatureKeyInput() {
}

func (CompanionStruct_GenerateECDSASignatureKeyInput_) Create_GenerateECDSASignatureKeyInput_(SignatureAlgorithm ECDSASignatureAlgorithm) GenerateECDSASignatureKeyInput {
	return GenerateECDSASignatureKeyInput{GenerateECDSASignatureKeyInput_GenerateECDSASignatureKeyInput{SignatureAlgorithm}}
}

func (_this GenerateECDSASignatureKeyInput) Is_GenerateECDSASignatureKeyInput() bool {
	_, ok := _this.Get_().(GenerateECDSASignatureKeyInput_GenerateECDSASignatureKeyInput)
	return ok
}

func (CompanionStruct_GenerateECDSASignatureKeyInput_) Default() GenerateECDSASignatureKeyInput {
	return Companion_GenerateECDSASignatureKeyInput_.Create_GenerateECDSASignatureKeyInput_(Companion_ECDSASignatureAlgorithm_.Default())
}

func (_this GenerateECDSASignatureKeyInput) Dtor_signatureAlgorithm() ECDSASignatureAlgorithm {
	return _this.Get_().(GenerateECDSASignatureKeyInput_GenerateECDSASignatureKeyInput).SignatureAlgorithm
}

func (_this GenerateECDSASignatureKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateECDSASignatureKeyInput_GenerateECDSASignatureKeyInput:
		{
			return "AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyInput.GenerateECDSASignatureKeyInput" + "(" + _dafny.String(data.SignatureAlgorithm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateECDSASignatureKeyInput) Equals(other GenerateECDSASignatureKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateECDSASignatureKeyInput_GenerateECDSASignatureKeyInput:
		{
			data2, ok := other.Get_().(GenerateECDSASignatureKeyInput_GenerateECDSASignatureKeyInput)
			return ok && data1.SignatureAlgorithm.Equals(data2.SignatureAlgorithm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateECDSASignatureKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateECDSASignatureKeyInput)
	return ok && _this.Equals(typed)
}

func Type_GenerateECDSASignatureKeyInput_() _dafny.TypeDescriptor {
	return type_GenerateECDSASignatureKeyInput_{}
}

type type_GenerateECDSASignatureKeyInput_ struct {
}

func (_this type_GenerateECDSASignatureKeyInput_) Default() interface{} {
	return Companion_GenerateECDSASignatureKeyInput_.Default()
}

func (_this type_GenerateECDSASignatureKeyInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyInput"
}
func (_this GenerateECDSASignatureKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateECDSASignatureKeyInput{}

// End of datatype GenerateECDSASignatureKeyInput

// Definition of datatype GenerateECDSASignatureKeyOutput
type GenerateECDSASignatureKeyOutput struct {
	Data_GenerateECDSASignatureKeyOutput_
}

func (_this GenerateECDSASignatureKeyOutput) Get_() Data_GenerateECDSASignatureKeyOutput_ {
	return _this.Data_GenerateECDSASignatureKeyOutput_
}

type Data_GenerateECDSASignatureKeyOutput_ interface {
	isGenerateECDSASignatureKeyOutput()
}

type CompanionStruct_GenerateECDSASignatureKeyOutput_ struct {
}

var Companion_GenerateECDSASignatureKeyOutput_ = CompanionStruct_GenerateECDSASignatureKeyOutput_{}

type GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput struct {
	SignatureAlgorithm ECDSASignatureAlgorithm
	VerificationKey    _dafny.Sequence
	SigningKey         _dafny.Sequence
}

func (GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput) isGenerateECDSASignatureKeyOutput() {
}

func (CompanionStruct_GenerateECDSASignatureKeyOutput_) Create_GenerateECDSASignatureKeyOutput_(SignatureAlgorithm ECDSASignatureAlgorithm, VerificationKey _dafny.Sequence, SigningKey _dafny.Sequence) GenerateECDSASignatureKeyOutput {
	return GenerateECDSASignatureKeyOutput{GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput{SignatureAlgorithm, VerificationKey, SigningKey}}
}

func (_this GenerateECDSASignatureKeyOutput) Is_GenerateECDSASignatureKeyOutput() bool {
	_, ok := _this.Get_().(GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput)
	return ok
}

func (CompanionStruct_GenerateECDSASignatureKeyOutput_) Default() GenerateECDSASignatureKeyOutput {
	return Companion_GenerateECDSASignatureKeyOutput_.Create_GenerateECDSASignatureKeyOutput_(Companion_ECDSASignatureAlgorithm_.Default(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this GenerateECDSASignatureKeyOutput) Dtor_signatureAlgorithm() ECDSASignatureAlgorithm {
	return _this.Get_().(GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput).SignatureAlgorithm
}

func (_this GenerateECDSASignatureKeyOutput) Dtor_verificationKey() _dafny.Sequence {
	return _this.Get_().(GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput).VerificationKey
}

func (_this GenerateECDSASignatureKeyOutput) Dtor_signingKey() _dafny.Sequence {
	return _this.Get_().(GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput).SigningKey
}

func (_this GenerateECDSASignatureKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput:
		{
			return "AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyOutput.GenerateECDSASignatureKeyOutput" + "(" + _dafny.String(data.SignatureAlgorithm) + ", " + _dafny.String(data.VerificationKey) + ", " + _dafny.String(data.SigningKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateECDSASignatureKeyOutput) Equals(other GenerateECDSASignatureKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput:
		{
			data2, ok := other.Get_().(GenerateECDSASignatureKeyOutput_GenerateECDSASignatureKeyOutput)
			return ok && data1.SignatureAlgorithm.Equals(data2.SignatureAlgorithm) && data1.VerificationKey.Equals(data2.VerificationKey) && data1.SigningKey.Equals(data2.SigningKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateECDSASignatureKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateECDSASignatureKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_GenerateECDSASignatureKeyOutput_() _dafny.TypeDescriptor {
	return type_GenerateECDSASignatureKeyOutput_{}
}

type type_GenerateECDSASignatureKeyOutput_ struct {
}

func (_this type_GenerateECDSASignatureKeyOutput_) Default() interface{} {
	return Companion_GenerateECDSASignatureKeyOutput_.Default()
}

func (_this type_GenerateECDSASignatureKeyOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GenerateECDSASignatureKeyOutput"
}
func (_this GenerateECDSASignatureKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateECDSASignatureKeyOutput{}

// End of datatype GenerateECDSASignatureKeyOutput

// Definition of datatype GenerateRandomBytesInput
type GenerateRandomBytesInput struct {
	Data_GenerateRandomBytesInput_
}

func (_this GenerateRandomBytesInput) Get_() Data_GenerateRandomBytesInput_ {
	return _this.Data_GenerateRandomBytesInput_
}

type Data_GenerateRandomBytesInput_ interface {
	isGenerateRandomBytesInput()
}

type CompanionStruct_GenerateRandomBytesInput_ struct {
}

var Companion_GenerateRandomBytesInput_ = CompanionStruct_GenerateRandomBytesInput_{}

type GenerateRandomBytesInput_GenerateRandomBytesInput struct {
	Length int32
}

func (GenerateRandomBytesInput_GenerateRandomBytesInput) isGenerateRandomBytesInput() {}

func (CompanionStruct_GenerateRandomBytesInput_) Create_GenerateRandomBytesInput_(Length int32) GenerateRandomBytesInput {
	return GenerateRandomBytesInput{GenerateRandomBytesInput_GenerateRandomBytesInput{Length}}
}

func (_this GenerateRandomBytesInput) Is_GenerateRandomBytesInput() bool {
	_, ok := _this.Get_().(GenerateRandomBytesInput_GenerateRandomBytesInput)
	return ok
}

func (CompanionStruct_GenerateRandomBytesInput_) Default() GenerateRandomBytesInput {
	return Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_(int32(0))
}

func (_this GenerateRandomBytesInput) Dtor_length() int32 {
	return _this.Get_().(GenerateRandomBytesInput_GenerateRandomBytesInput).Length
}

func (_this GenerateRandomBytesInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateRandomBytesInput_GenerateRandomBytesInput:
		{
			return "AwsCryptographyPrimitivesTypes.GenerateRandomBytesInput.GenerateRandomBytesInput" + "(" + _dafny.String(data.Length) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateRandomBytesInput) Equals(other GenerateRandomBytesInput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateRandomBytesInput_GenerateRandomBytesInput:
		{
			data2, ok := other.Get_().(GenerateRandomBytesInput_GenerateRandomBytesInput)
			return ok && data1.Length == data2.Length
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateRandomBytesInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateRandomBytesInput)
	return ok && _this.Equals(typed)
}

func Type_GenerateRandomBytesInput_() _dafny.TypeDescriptor {
	return type_GenerateRandomBytesInput_{}
}

type type_GenerateRandomBytesInput_ struct {
}

func (_this type_GenerateRandomBytesInput_) Default() interface{} {
	return Companion_GenerateRandomBytesInput_.Default()
}

func (_this type_GenerateRandomBytesInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GenerateRandomBytesInput"
}
func (_this GenerateRandomBytesInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateRandomBytesInput{}

// End of datatype GenerateRandomBytesInput

// Definition of datatype GenerateRSAKeyPairInput
type GenerateRSAKeyPairInput struct {
	Data_GenerateRSAKeyPairInput_
}

func (_this GenerateRSAKeyPairInput) Get_() Data_GenerateRSAKeyPairInput_ {
	return _this.Data_GenerateRSAKeyPairInput_
}

type Data_GenerateRSAKeyPairInput_ interface {
	isGenerateRSAKeyPairInput()
}

type CompanionStruct_GenerateRSAKeyPairInput_ struct {
}

var Companion_GenerateRSAKeyPairInput_ = CompanionStruct_GenerateRSAKeyPairInput_{}

type GenerateRSAKeyPairInput_GenerateRSAKeyPairInput struct {
	LengthBits int32
}

func (GenerateRSAKeyPairInput_GenerateRSAKeyPairInput) isGenerateRSAKeyPairInput() {}

func (CompanionStruct_GenerateRSAKeyPairInput_) Create_GenerateRSAKeyPairInput_(LengthBits int32) GenerateRSAKeyPairInput {
	return GenerateRSAKeyPairInput{GenerateRSAKeyPairInput_GenerateRSAKeyPairInput{LengthBits}}
}

func (_this GenerateRSAKeyPairInput) Is_GenerateRSAKeyPairInput() bool {
	_, ok := _this.Get_().(GenerateRSAKeyPairInput_GenerateRSAKeyPairInput)
	return ok
}

func (CompanionStruct_GenerateRSAKeyPairInput_) Default() GenerateRSAKeyPairInput {
	return Companion_GenerateRSAKeyPairInput_.Create_GenerateRSAKeyPairInput_(int32(0))
}

func (_this GenerateRSAKeyPairInput) Dtor_lengthBits() int32 {
	return _this.Get_().(GenerateRSAKeyPairInput_GenerateRSAKeyPairInput).LengthBits
}

func (_this GenerateRSAKeyPairInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateRSAKeyPairInput_GenerateRSAKeyPairInput:
		{
			return "AwsCryptographyPrimitivesTypes.GenerateRSAKeyPairInput.GenerateRSAKeyPairInput" + "(" + _dafny.String(data.LengthBits) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateRSAKeyPairInput) Equals(other GenerateRSAKeyPairInput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateRSAKeyPairInput_GenerateRSAKeyPairInput:
		{
			data2, ok := other.Get_().(GenerateRSAKeyPairInput_GenerateRSAKeyPairInput)
			return ok && data1.LengthBits == data2.LengthBits
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateRSAKeyPairInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateRSAKeyPairInput)
	return ok && _this.Equals(typed)
}

func Type_GenerateRSAKeyPairInput_() _dafny.TypeDescriptor {
	return type_GenerateRSAKeyPairInput_{}
}

type type_GenerateRSAKeyPairInput_ struct {
}

func (_this type_GenerateRSAKeyPairInput_) Default() interface{} {
	return Companion_GenerateRSAKeyPairInput_.Default()
}

func (_this type_GenerateRSAKeyPairInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GenerateRSAKeyPairInput"
}
func (_this GenerateRSAKeyPairInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateRSAKeyPairInput{}

// End of datatype GenerateRSAKeyPairInput

// Definition of datatype GenerateRSAKeyPairOutput
type GenerateRSAKeyPairOutput struct {
	Data_GenerateRSAKeyPairOutput_
}

func (_this GenerateRSAKeyPairOutput) Get_() Data_GenerateRSAKeyPairOutput_ {
	return _this.Data_GenerateRSAKeyPairOutput_
}

type Data_GenerateRSAKeyPairOutput_ interface {
	isGenerateRSAKeyPairOutput()
}

type CompanionStruct_GenerateRSAKeyPairOutput_ struct {
}

var Companion_GenerateRSAKeyPairOutput_ = CompanionStruct_GenerateRSAKeyPairOutput_{}

type GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput struct {
	PublicKey  RSAPublicKey
	PrivateKey RSAPrivateKey
}

func (GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput) isGenerateRSAKeyPairOutput() {}

func (CompanionStruct_GenerateRSAKeyPairOutput_) Create_GenerateRSAKeyPairOutput_(PublicKey RSAPublicKey, PrivateKey RSAPrivateKey) GenerateRSAKeyPairOutput {
	return GenerateRSAKeyPairOutput{GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput{PublicKey, PrivateKey}}
}

func (_this GenerateRSAKeyPairOutput) Is_GenerateRSAKeyPairOutput() bool {
	_, ok := _this.Get_().(GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput)
	return ok
}

func (CompanionStruct_GenerateRSAKeyPairOutput_) Default() GenerateRSAKeyPairOutput {
	return Companion_GenerateRSAKeyPairOutput_.Create_GenerateRSAKeyPairOutput_(Companion_RSAPublicKey_.Default(), Companion_RSAPrivateKey_.Default())
}

func (_this GenerateRSAKeyPairOutput) Dtor_publicKey() RSAPublicKey {
	return _this.Get_().(GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput).PublicKey
}

func (_this GenerateRSAKeyPairOutput) Dtor_privateKey() RSAPrivateKey {
	return _this.Get_().(GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput).PrivateKey
}

func (_this GenerateRSAKeyPairOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput:
		{
			return "AwsCryptographyPrimitivesTypes.GenerateRSAKeyPairOutput.GenerateRSAKeyPairOutput" + "(" + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.PrivateKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateRSAKeyPairOutput) Equals(other GenerateRSAKeyPairOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput:
		{
			data2, ok := other.Get_().(GenerateRSAKeyPairOutput_GenerateRSAKeyPairOutput)
			return ok && data1.PublicKey.Equals(data2.PublicKey) && data1.PrivateKey.Equals(data2.PrivateKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateRSAKeyPairOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateRSAKeyPairOutput)
	return ok && _this.Equals(typed)
}

func Type_GenerateRSAKeyPairOutput_() _dafny.TypeDescriptor {
	return type_GenerateRSAKeyPairOutput_{}
}

type type_GenerateRSAKeyPairOutput_ struct {
}

func (_this type_GenerateRSAKeyPairOutput_) Default() interface{} {
	return Companion_GenerateRSAKeyPairOutput_.Default()
}

func (_this type_GenerateRSAKeyPairOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GenerateRSAKeyPairOutput"
}
func (_this GenerateRSAKeyPairOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateRSAKeyPairOutput{}

// End of datatype GenerateRSAKeyPairOutput

// Definition of datatype GetPublicKeyFromPrivateKeyInput
type GetPublicKeyFromPrivateKeyInput struct {
	Data_GetPublicKeyFromPrivateKeyInput_
}

func (_this GetPublicKeyFromPrivateKeyInput) Get_() Data_GetPublicKeyFromPrivateKeyInput_ {
	return _this.Data_GetPublicKeyFromPrivateKeyInput_
}

type Data_GetPublicKeyFromPrivateKeyInput_ interface {
	isGetPublicKeyFromPrivateKeyInput()
}

type CompanionStruct_GetPublicKeyFromPrivateKeyInput_ struct {
}

var Companion_GetPublicKeyFromPrivateKeyInput_ = CompanionStruct_GetPublicKeyFromPrivateKeyInput_{}

type GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput struct {
	EccCurve   ECDHCurveSpec
	PrivateKey ECCPrivateKey
}

func (GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput) isGetPublicKeyFromPrivateKeyInput() {
}

func (CompanionStruct_GetPublicKeyFromPrivateKeyInput_) Create_GetPublicKeyFromPrivateKeyInput_(EccCurve ECDHCurveSpec, PrivateKey ECCPrivateKey) GetPublicKeyFromPrivateKeyInput {
	return GetPublicKeyFromPrivateKeyInput{GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput{EccCurve, PrivateKey}}
}

func (_this GetPublicKeyFromPrivateKeyInput) Is_GetPublicKeyFromPrivateKeyInput() bool {
	_, ok := _this.Get_().(GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput)
	return ok
}

func (CompanionStruct_GetPublicKeyFromPrivateKeyInput_) Default() GetPublicKeyFromPrivateKeyInput {
	return Companion_GetPublicKeyFromPrivateKeyInput_.Create_GetPublicKeyFromPrivateKeyInput_(Companion_ECDHCurveSpec_.Default(), Companion_ECCPrivateKey_.Default())
}

func (_this GetPublicKeyFromPrivateKeyInput) Dtor_eccCurve() ECDHCurveSpec {
	return _this.Get_().(GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput).EccCurve
}

func (_this GetPublicKeyFromPrivateKeyInput) Dtor_privateKey() ECCPrivateKey {
	return _this.Get_().(GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput).PrivateKey
}

func (_this GetPublicKeyFromPrivateKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput:
		{
			return "AwsCryptographyPrimitivesTypes.GetPublicKeyFromPrivateKeyInput.GetPublicKeyFromPrivateKeyInput" + "(" + _dafny.String(data.EccCurve) + ", " + _dafny.String(data.PrivateKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetPublicKeyFromPrivateKeyInput) Equals(other GetPublicKeyFromPrivateKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput:
		{
			data2, ok := other.Get_().(GetPublicKeyFromPrivateKeyInput_GetPublicKeyFromPrivateKeyInput)
			return ok && data1.EccCurve.Equals(data2.EccCurve) && data1.PrivateKey.Equals(data2.PrivateKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetPublicKeyFromPrivateKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetPublicKeyFromPrivateKeyInput)
	return ok && _this.Equals(typed)
}

func Type_GetPublicKeyFromPrivateKeyInput_() _dafny.TypeDescriptor {
	return type_GetPublicKeyFromPrivateKeyInput_{}
}

type type_GetPublicKeyFromPrivateKeyInput_ struct {
}

func (_this type_GetPublicKeyFromPrivateKeyInput_) Default() interface{} {
	return Companion_GetPublicKeyFromPrivateKeyInput_.Default()
}

func (_this type_GetPublicKeyFromPrivateKeyInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GetPublicKeyFromPrivateKeyInput"
}
func (_this GetPublicKeyFromPrivateKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetPublicKeyFromPrivateKeyInput{}

// End of datatype GetPublicKeyFromPrivateKeyInput

// Definition of datatype GetPublicKeyFromPrivateKeyOutput
type GetPublicKeyFromPrivateKeyOutput struct {
	Data_GetPublicKeyFromPrivateKeyOutput_
}

func (_this GetPublicKeyFromPrivateKeyOutput) Get_() Data_GetPublicKeyFromPrivateKeyOutput_ {
	return _this.Data_GetPublicKeyFromPrivateKeyOutput_
}

type Data_GetPublicKeyFromPrivateKeyOutput_ interface {
	isGetPublicKeyFromPrivateKeyOutput()
}

type CompanionStruct_GetPublicKeyFromPrivateKeyOutput_ struct {
}

var Companion_GetPublicKeyFromPrivateKeyOutput_ = CompanionStruct_GetPublicKeyFromPrivateKeyOutput_{}

type GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput struct {
	EccCurve   ECDHCurveSpec
	PrivateKey ECCPrivateKey
	PublicKey  _dafny.Sequence
}

func (GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput) isGetPublicKeyFromPrivateKeyOutput() {
}

func (CompanionStruct_GetPublicKeyFromPrivateKeyOutput_) Create_GetPublicKeyFromPrivateKeyOutput_(EccCurve ECDHCurveSpec, PrivateKey ECCPrivateKey, PublicKey _dafny.Sequence) GetPublicKeyFromPrivateKeyOutput {
	return GetPublicKeyFromPrivateKeyOutput{GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput{EccCurve, PrivateKey, PublicKey}}
}

func (_this GetPublicKeyFromPrivateKeyOutput) Is_GetPublicKeyFromPrivateKeyOutput() bool {
	_, ok := _this.Get_().(GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput)
	return ok
}

func (CompanionStruct_GetPublicKeyFromPrivateKeyOutput_) Default() GetPublicKeyFromPrivateKeyOutput {
	return Companion_GetPublicKeyFromPrivateKeyOutput_.Create_GetPublicKeyFromPrivateKeyOutput_(Companion_ECDHCurveSpec_.Default(), Companion_ECCPrivateKey_.Default(), _dafny.EmptySeq)
}

func (_this GetPublicKeyFromPrivateKeyOutput) Dtor_eccCurve() ECDHCurveSpec {
	return _this.Get_().(GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput).EccCurve
}

func (_this GetPublicKeyFromPrivateKeyOutput) Dtor_privateKey() ECCPrivateKey {
	return _this.Get_().(GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput).PrivateKey
}

func (_this GetPublicKeyFromPrivateKeyOutput) Dtor_publicKey() _dafny.Sequence {
	return _this.Get_().(GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput).PublicKey
}

func (_this GetPublicKeyFromPrivateKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput:
		{
			return "AwsCryptographyPrimitivesTypes.GetPublicKeyFromPrivateKeyOutput.GetPublicKeyFromPrivateKeyOutput" + "(" + _dafny.String(data.EccCurve) + ", " + _dafny.String(data.PrivateKey) + ", " + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetPublicKeyFromPrivateKeyOutput) Equals(other GetPublicKeyFromPrivateKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput:
		{
			data2, ok := other.Get_().(GetPublicKeyFromPrivateKeyOutput_GetPublicKeyFromPrivateKeyOutput)
			return ok && data1.EccCurve.Equals(data2.EccCurve) && data1.PrivateKey.Equals(data2.PrivateKey) && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetPublicKeyFromPrivateKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetPublicKeyFromPrivateKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_GetPublicKeyFromPrivateKeyOutput_() _dafny.TypeDescriptor {
	return type_GetPublicKeyFromPrivateKeyOutput_{}
}

type type_GetPublicKeyFromPrivateKeyOutput_ struct {
}

func (_this type_GetPublicKeyFromPrivateKeyOutput_) Default() interface{} {
	return Companion_GetPublicKeyFromPrivateKeyOutput_.Default()
}

func (_this type_GetPublicKeyFromPrivateKeyOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GetPublicKeyFromPrivateKeyOutput"
}
func (_this GetPublicKeyFromPrivateKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetPublicKeyFromPrivateKeyOutput{}

// End of datatype GetPublicKeyFromPrivateKeyOutput

// Definition of datatype GetRSAKeyModulusLengthInput
type GetRSAKeyModulusLengthInput struct {
	Data_GetRSAKeyModulusLengthInput_
}

func (_this GetRSAKeyModulusLengthInput) Get_() Data_GetRSAKeyModulusLengthInput_ {
	return _this.Data_GetRSAKeyModulusLengthInput_
}

type Data_GetRSAKeyModulusLengthInput_ interface {
	isGetRSAKeyModulusLengthInput()
}

type CompanionStruct_GetRSAKeyModulusLengthInput_ struct {
}

var Companion_GetRSAKeyModulusLengthInput_ = CompanionStruct_GetRSAKeyModulusLengthInput_{}

type GetRSAKeyModulusLengthInput_GetRSAKeyModulusLengthInput struct {
	PublicKey _dafny.Sequence
}

func (GetRSAKeyModulusLengthInput_GetRSAKeyModulusLengthInput) isGetRSAKeyModulusLengthInput() {}

func (CompanionStruct_GetRSAKeyModulusLengthInput_) Create_GetRSAKeyModulusLengthInput_(PublicKey _dafny.Sequence) GetRSAKeyModulusLengthInput {
	return GetRSAKeyModulusLengthInput{GetRSAKeyModulusLengthInput_GetRSAKeyModulusLengthInput{PublicKey}}
}

func (_this GetRSAKeyModulusLengthInput) Is_GetRSAKeyModulusLengthInput() bool {
	_, ok := _this.Get_().(GetRSAKeyModulusLengthInput_GetRSAKeyModulusLengthInput)
	return ok
}

func (CompanionStruct_GetRSAKeyModulusLengthInput_) Default() GetRSAKeyModulusLengthInput {
	return Companion_GetRSAKeyModulusLengthInput_.Create_GetRSAKeyModulusLengthInput_(_dafny.EmptySeq)
}

func (_this GetRSAKeyModulusLengthInput) Dtor_publicKey() _dafny.Sequence {
	return _this.Get_().(GetRSAKeyModulusLengthInput_GetRSAKeyModulusLengthInput).PublicKey
}

func (_this GetRSAKeyModulusLengthInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetRSAKeyModulusLengthInput_GetRSAKeyModulusLengthInput:
		{
			return "AwsCryptographyPrimitivesTypes.GetRSAKeyModulusLengthInput.GetRSAKeyModulusLengthInput" + "(" + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetRSAKeyModulusLengthInput) Equals(other GetRSAKeyModulusLengthInput) bool {
	switch data1 := _this.Get_().(type) {
	case GetRSAKeyModulusLengthInput_GetRSAKeyModulusLengthInput:
		{
			data2, ok := other.Get_().(GetRSAKeyModulusLengthInput_GetRSAKeyModulusLengthInput)
			return ok && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetRSAKeyModulusLengthInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetRSAKeyModulusLengthInput)
	return ok && _this.Equals(typed)
}

func Type_GetRSAKeyModulusLengthInput_() _dafny.TypeDescriptor {
	return type_GetRSAKeyModulusLengthInput_{}
}

type type_GetRSAKeyModulusLengthInput_ struct {
}

func (_this type_GetRSAKeyModulusLengthInput_) Default() interface{} {
	return Companion_GetRSAKeyModulusLengthInput_.Default()
}

func (_this type_GetRSAKeyModulusLengthInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GetRSAKeyModulusLengthInput"
}
func (_this GetRSAKeyModulusLengthInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetRSAKeyModulusLengthInput{}

// End of datatype GetRSAKeyModulusLengthInput

// Definition of datatype GetRSAKeyModulusLengthOutput
type GetRSAKeyModulusLengthOutput struct {
	Data_GetRSAKeyModulusLengthOutput_
}

func (_this GetRSAKeyModulusLengthOutput) Get_() Data_GetRSAKeyModulusLengthOutput_ {
	return _this.Data_GetRSAKeyModulusLengthOutput_
}

type Data_GetRSAKeyModulusLengthOutput_ interface {
	isGetRSAKeyModulusLengthOutput()
}

type CompanionStruct_GetRSAKeyModulusLengthOutput_ struct {
}

var Companion_GetRSAKeyModulusLengthOutput_ = CompanionStruct_GetRSAKeyModulusLengthOutput_{}

type GetRSAKeyModulusLengthOutput_GetRSAKeyModulusLengthOutput struct {
	Length int32
}

func (GetRSAKeyModulusLengthOutput_GetRSAKeyModulusLengthOutput) isGetRSAKeyModulusLengthOutput() {}

func (CompanionStruct_GetRSAKeyModulusLengthOutput_) Create_GetRSAKeyModulusLengthOutput_(Length int32) GetRSAKeyModulusLengthOutput {
	return GetRSAKeyModulusLengthOutput{GetRSAKeyModulusLengthOutput_GetRSAKeyModulusLengthOutput{Length}}
}

func (_this GetRSAKeyModulusLengthOutput) Is_GetRSAKeyModulusLengthOutput() bool {
	_, ok := _this.Get_().(GetRSAKeyModulusLengthOutput_GetRSAKeyModulusLengthOutput)
	return ok
}

func (CompanionStruct_GetRSAKeyModulusLengthOutput_) Default() GetRSAKeyModulusLengthOutput {
	return Companion_GetRSAKeyModulusLengthOutput_.Create_GetRSAKeyModulusLengthOutput_(int32(0))
}

func (_this GetRSAKeyModulusLengthOutput) Dtor_length() int32 {
	return _this.Get_().(GetRSAKeyModulusLengthOutput_GetRSAKeyModulusLengthOutput).Length
}

func (_this GetRSAKeyModulusLengthOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetRSAKeyModulusLengthOutput_GetRSAKeyModulusLengthOutput:
		{
			return "AwsCryptographyPrimitivesTypes.GetRSAKeyModulusLengthOutput.GetRSAKeyModulusLengthOutput" + "(" + _dafny.String(data.Length) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetRSAKeyModulusLengthOutput) Equals(other GetRSAKeyModulusLengthOutput) bool {
	switch data1 := _this.Get_().(type) {
	case GetRSAKeyModulusLengthOutput_GetRSAKeyModulusLengthOutput:
		{
			data2, ok := other.Get_().(GetRSAKeyModulusLengthOutput_GetRSAKeyModulusLengthOutput)
			return ok && data1.Length == data2.Length
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetRSAKeyModulusLengthOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetRSAKeyModulusLengthOutput)
	return ok && _this.Equals(typed)
}

func Type_GetRSAKeyModulusLengthOutput_() _dafny.TypeDescriptor {
	return type_GetRSAKeyModulusLengthOutput_{}
}

type type_GetRSAKeyModulusLengthOutput_ struct {
}

func (_this type_GetRSAKeyModulusLengthOutput_) Default() interface{} {
	return Companion_GetRSAKeyModulusLengthOutput_.Default()
}

func (_this type_GetRSAKeyModulusLengthOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.GetRSAKeyModulusLengthOutput"
}
func (_this GetRSAKeyModulusLengthOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetRSAKeyModulusLengthOutput{}

// End of datatype GetRSAKeyModulusLengthOutput

// Definition of datatype HkdfExpandInput
type HkdfExpandInput struct {
	Data_HkdfExpandInput_
}

func (_this HkdfExpandInput) Get_() Data_HkdfExpandInput_ {
	return _this.Data_HkdfExpandInput_
}

type Data_HkdfExpandInput_ interface {
	isHkdfExpandInput()
}

type CompanionStruct_HkdfExpandInput_ struct {
}

var Companion_HkdfExpandInput_ = CompanionStruct_HkdfExpandInput_{}

type HkdfExpandInput_HkdfExpandInput struct {
	DigestAlgorithm DigestAlgorithm
	Prk             _dafny.Sequence
	Info            _dafny.Sequence
	ExpectedLength  int32
}

func (HkdfExpandInput_HkdfExpandInput) isHkdfExpandInput() {}

func (CompanionStruct_HkdfExpandInput_) Create_HkdfExpandInput_(DigestAlgorithm DigestAlgorithm, Prk _dafny.Sequence, Info _dafny.Sequence, ExpectedLength int32) HkdfExpandInput {
	return HkdfExpandInput{HkdfExpandInput_HkdfExpandInput{DigestAlgorithm, Prk, Info, ExpectedLength}}
}

func (_this HkdfExpandInput) Is_HkdfExpandInput() bool {
	_, ok := _this.Get_().(HkdfExpandInput_HkdfExpandInput)
	return ok
}

func (CompanionStruct_HkdfExpandInput_) Default() HkdfExpandInput {
	return Companion_HkdfExpandInput_.Create_HkdfExpandInput_(Companion_DigestAlgorithm_.Default(), _dafny.EmptySeq, _dafny.EmptySeq, int32(0))
}

func (_this HkdfExpandInput) Dtor_digestAlgorithm() DigestAlgorithm {
	return _this.Get_().(HkdfExpandInput_HkdfExpandInput).DigestAlgorithm
}

func (_this HkdfExpandInput) Dtor_prk() _dafny.Sequence {
	return _this.Get_().(HkdfExpandInput_HkdfExpandInput).Prk
}

func (_this HkdfExpandInput) Dtor_info() _dafny.Sequence {
	return _this.Get_().(HkdfExpandInput_HkdfExpandInput).Info
}

func (_this HkdfExpandInput) Dtor_expectedLength() int32 {
	return _this.Get_().(HkdfExpandInput_HkdfExpandInput).ExpectedLength
}

func (_this HkdfExpandInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case HkdfExpandInput_HkdfExpandInput:
		{
			return "AwsCryptographyPrimitivesTypes.HkdfExpandInput.HkdfExpandInput" + "(" + _dafny.String(data.DigestAlgorithm) + ", " + _dafny.String(data.Prk) + ", " + _dafny.String(data.Info) + ", " + _dafny.String(data.ExpectedLength) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this HkdfExpandInput) Equals(other HkdfExpandInput) bool {
	switch data1 := _this.Get_().(type) {
	case HkdfExpandInput_HkdfExpandInput:
		{
			data2, ok := other.Get_().(HkdfExpandInput_HkdfExpandInput)
			return ok && data1.DigestAlgorithm.Equals(data2.DigestAlgorithm) && data1.Prk.Equals(data2.Prk) && data1.Info.Equals(data2.Info) && data1.ExpectedLength == data2.ExpectedLength
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this HkdfExpandInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(HkdfExpandInput)
	return ok && _this.Equals(typed)
}

func Type_HkdfExpandInput_() _dafny.TypeDescriptor {
	return type_HkdfExpandInput_{}
}

type type_HkdfExpandInput_ struct {
}

func (_this type_HkdfExpandInput_) Default() interface{} {
	return Companion_HkdfExpandInput_.Default()
}

func (_this type_HkdfExpandInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.HkdfExpandInput"
}
func (_this HkdfExpandInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = HkdfExpandInput{}

// End of datatype HkdfExpandInput

// Definition of datatype HkdfExtractInput
type HkdfExtractInput struct {
	Data_HkdfExtractInput_
}

func (_this HkdfExtractInput) Get_() Data_HkdfExtractInput_ {
	return _this.Data_HkdfExtractInput_
}

type Data_HkdfExtractInput_ interface {
	isHkdfExtractInput()
}

type CompanionStruct_HkdfExtractInput_ struct {
}

var Companion_HkdfExtractInput_ = CompanionStruct_HkdfExtractInput_{}

type HkdfExtractInput_HkdfExtractInput struct {
	DigestAlgorithm DigestAlgorithm
	Salt            m_Wrappers.Option
	Ikm             _dafny.Sequence
}

func (HkdfExtractInput_HkdfExtractInput) isHkdfExtractInput() {}

func (CompanionStruct_HkdfExtractInput_) Create_HkdfExtractInput_(DigestAlgorithm DigestAlgorithm, Salt m_Wrappers.Option, Ikm _dafny.Sequence) HkdfExtractInput {
	return HkdfExtractInput{HkdfExtractInput_HkdfExtractInput{DigestAlgorithm, Salt, Ikm}}
}

func (_this HkdfExtractInput) Is_HkdfExtractInput() bool {
	_, ok := _this.Get_().(HkdfExtractInput_HkdfExtractInput)
	return ok
}

func (CompanionStruct_HkdfExtractInput_) Default() HkdfExtractInput {
	return Companion_HkdfExtractInput_.Create_HkdfExtractInput_(Companion_DigestAlgorithm_.Default(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq)
}

func (_this HkdfExtractInput) Dtor_digestAlgorithm() DigestAlgorithm {
	return _this.Get_().(HkdfExtractInput_HkdfExtractInput).DigestAlgorithm
}

func (_this HkdfExtractInput) Dtor_salt() m_Wrappers.Option {
	return _this.Get_().(HkdfExtractInput_HkdfExtractInput).Salt
}

func (_this HkdfExtractInput) Dtor_ikm() _dafny.Sequence {
	return _this.Get_().(HkdfExtractInput_HkdfExtractInput).Ikm
}

func (_this HkdfExtractInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case HkdfExtractInput_HkdfExtractInput:
		{
			return "AwsCryptographyPrimitivesTypes.HkdfExtractInput.HkdfExtractInput" + "(" + _dafny.String(data.DigestAlgorithm) + ", " + _dafny.String(data.Salt) + ", " + _dafny.String(data.Ikm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this HkdfExtractInput) Equals(other HkdfExtractInput) bool {
	switch data1 := _this.Get_().(type) {
	case HkdfExtractInput_HkdfExtractInput:
		{
			data2, ok := other.Get_().(HkdfExtractInput_HkdfExtractInput)
			return ok && data1.DigestAlgorithm.Equals(data2.DigestAlgorithm) && data1.Salt.Equals(data2.Salt) && data1.Ikm.Equals(data2.Ikm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this HkdfExtractInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(HkdfExtractInput)
	return ok && _this.Equals(typed)
}

func Type_HkdfExtractInput_() _dafny.TypeDescriptor {
	return type_HkdfExtractInput_{}
}

type type_HkdfExtractInput_ struct {
}

func (_this type_HkdfExtractInput_) Default() interface{} {
	return Companion_HkdfExtractInput_.Default()
}

func (_this type_HkdfExtractInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.HkdfExtractInput"
}
func (_this HkdfExtractInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = HkdfExtractInput{}

// End of datatype HkdfExtractInput

// Definition of datatype HkdfInput
type HkdfInput struct {
	Data_HkdfInput_
}

func (_this HkdfInput) Get_() Data_HkdfInput_ {
	return _this.Data_HkdfInput_
}

type Data_HkdfInput_ interface {
	isHkdfInput()
}

type CompanionStruct_HkdfInput_ struct {
}

var Companion_HkdfInput_ = CompanionStruct_HkdfInput_{}

type HkdfInput_HkdfInput struct {
	DigestAlgorithm DigestAlgorithm
	Salt            m_Wrappers.Option
	Ikm             _dafny.Sequence
	Info            _dafny.Sequence
	ExpectedLength  int32
}

func (HkdfInput_HkdfInput) isHkdfInput() {}

func (CompanionStruct_HkdfInput_) Create_HkdfInput_(DigestAlgorithm DigestAlgorithm, Salt m_Wrappers.Option, Ikm _dafny.Sequence, Info _dafny.Sequence, ExpectedLength int32) HkdfInput {
	return HkdfInput{HkdfInput_HkdfInput{DigestAlgorithm, Salt, Ikm, Info, ExpectedLength}}
}

func (_this HkdfInput) Is_HkdfInput() bool {
	_, ok := _this.Get_().(HkdfInput_HkdfInput)
	return ok
}

func (CompanionStruct_HkdfInput_) Default() HkdfInput {
	return Companion_HkdfInput_.Create_HkdfInput_(Companion_DigestAlgorithm_.Default(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq, _dafny.EmptySeq, int32(0))
}

func (_this HkdfInput) Dtor_digestAlgorithm() DigestAlgorithm {
	return _this.Get_().(HkdfInput_HkdfInput).DigestAlgorithm
}

func (_this HkdfInput) Dtor_salt() m_Wrappers.Option {
	return _this.Get_().(HkdfInput_HkdfInput).Salt
}

func (_this HkdfInput) Dtor_ikm() _dafny.Sequence {
	return _this.Get_().(HkdfInput_HkdfInput).Ikm
}

func (_this HkdfInput) Dtor_info() _dafny.Sequence {
	return _this.Get_().(HkdfInput_HkdfInput).Info
}

func (_this HkdfInput) Dtor_expectedLength() int32 {
	return _this.Get_().(HkdfInput_HkdfInput).ExpectedLength
}

func (_this HkdfInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case HkdfInput_HkdfInput:
		{
			return "AwsCryptographyPrimitivesTypes.HkdfInput.HkdfInput" + "(" + _dafny.String(data.DigestAlgorithm) + ", " + _dafny.String(data.Salt) + ", " + _dafny.String(data.Ikm) + ", " + _dafny.String(data.Info) + ", " + _dafny.String(data.ExpectedLength) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this HkdfInput) Equals(other HkdfInput) bool {
	switch data1 := _this.Get_().(type) {
	case HkdfInput_HkdfInput:
		{
			data2, ok := other.Get_().(HkdfInput_HkdfInput)
			return ok && data1.DigestAlgorithm.Equals(data2.DigestAlgorithm) && data1.Salt.Equals(data2.Salt) && data1.Ikm.Equals(data2.Ikm) && data1.Info.Equals(data2.Info) && data1.ExpectedLength == data2.ExpectedLength
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this HkdfInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(HkdfInput)
	return ok && _this.Equals(typed)
}

func Type_HkdfInput_() _dafny.TypeDescriptor {
	return type_HkdfInput_{}
}

type type_HkdfInput_ struct {
}

func (_this type_HkdfInput_) Default() interface{} {
	return Companion_HkdfInput_.Default()
}

func (_this type_HkdfInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.HkdfInput"
}
func (_this HkdfInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = HkdfInput{}

// End of datatype HkdfInput

// Definition of datatype HMacInput
type HMacInput struct {
	Data_HMacInput_
}

func (_this HMacInput) Get_() Data_HMacInput_ {
	return _this.Data_HMacInput_
}

type Data_HMacInput_ interface {
	isHMacInput()
}

type CompanionStruct_HMacInput_ struct {
}

var Companion_HMacInput_ = CompanionStruct_HMacInput_{}

type HMacInput_HMacInput struct {
	DigestAlgorithm DigestAlgorithm
	Key             _dafny.Sequence
	Message         _dafny.Sequence
}

func (HMacInput_HMacInput) isHMacInput() {}

func (CompanionStruct_HMacInput_) Create_HMacInput_(DigestAlgorithm DigestAlgorithm, Key _dafny.Sequence, Message _dafny.Sequence) HMacInput {
	return HMacInput{HMacInput_HMacInput{DigestAlgorithm, Key, Message}}
}

func (_this HMacInput) Is_HMacInput() bool {
	_, ok := _this.Get_().(HMacInput_HMacInput)
	return ok
}

func (CompanionStruct_HMacInput_) Default() HMacInput {
	return Companion_HMacInput_.Create_HMacInput_(Companion_DigestAlgorithm_.Default(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this HMacInput) Dtor_digestAlgorithm() DigestAlgorithm {
	return _this.Get_().(HMacInput_HMacInput).DigestAlgorithm
}

func (_this HMacInput) Dtor_key() _dafny.Sequence {
	return _this.Get_().(HMacInput_HMacInput).Key
}

func (_this HMacInput) Dtor_message() _dafny.Sequence {
	return _this.Get_().(HMacInput_HMacInput).Message
}

func (_this HMacInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case HMacInput_HMacInput:
		{
			return "AwsCryptographyPrimitivesTypes.HMacInput.HMacInput" + "(" + _dafny.String(data.DigestAlgorithm) + ", " + _dafny.String(data.Key) + ", " + _dafny.String(data.Message) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this HMacInput) Equals(other HMacInput) bool {
	switch data1 := _this.Get_().(type) {
	case HMacInput_HMacInput:
		{
			data2, ok := other.Get_().(HMacInput_HMacInput)
			return ok && data1.DigestAlgorithm.Equals(data2.DigestAlgorithm) && data1.Key.Equals(data2.Key) && data1.Message.Equals(data2.Message)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this HMacInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(HMacInput)
	return ok && _this.Equals(typed)
}

func Type_HMacInput_() _dafny.TypeDescriptor {
	return type_HMacInput_{}
}

type type_HMacInput_ struct {
}

func (_this type_HMacInput_) Default() interface{} {
	return Companion_HMacInput_.Default()
}

func (_this type_HMacInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.HMacInput"
}
func (_this HMacInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = HMacInput{}

// End of datatype HMacInput

// Definition of datatype KdfCtrInput
type KdfCtrInput struct {
	Data_KdfCtrInput_
}

func (_this KdfCtrInput) Get_() Data_KdfCtrInput_ {
	return _this.Data_KdfCtrInput_
}

type Data_KdfCtrInput_ interface {
	isKdfCtrInput()
}

type CompanionStruct_KdfCtrInput_ struct {
}

var Companion_KdfCtrInput_ = CompanionStruct_KdfCtrInput_{}

type KdfCtrInput_KdfCtrInput struct {
	DigestAlgorithm DigestAlgorithm
	Ikm             _dafny.Sequence
	ExpectedLength  int32
	Purpose         m_Wrappers.Option
	Nonce           m_Wrappers.Option
}

func (KdfCtrInput_KdfCtrInput) isKdfCtrInput() {}

func (CompanionStruct_KdfCtrInput_) Create_KdfCtrInput_(DigestAlgorithm DigestAlgorithm, Ikm _dafny.Sequence, ExpectedLength int32, Purpose m_Wrappers.Option, Nonce m_Wrappers.Option) KdfCtrInput {
	return KdfCtrInput{KdfCtrInput_KdfCtrInput{DigestAlgorithm, Ikm, ExpectedLength, Purpose, Nonce}}
}

func (_this KdfCtrInput) Is_KdfCtrInput() bool {
	_, ok := _this.Get_().(KdfCtrInput_KdfCtrInput)
	return ok
}

func (CompanionStruct_KdfCtrInput_) Default() KdfCtrInput {
	return Companion_KdfCtrInput_.Create_KdfCtrInput_(Companion_DigestAlgorithm_.Default(), _dafny.EmptySeq, int32(0), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this KdfCtrInput) Dtor_digestAlgorithm() DigestAlgorithm {
	return _this.Get_().(KdfCtrInput_KdfCtrInput).DigestAlgorithm
}

func (_this KdfCtrInput) Dtor_ikm() _dafny.Sequence {
	return _this.Get_().(KdfCtrInput_KdfCtrInput).Ikm
}

func (_this KdfCtrInput) Dtor_expectedLength() int32 {
	return _this.Get_().(KdfCtrInput_KdfCtrInput).ExpectedLength
}

func (_this KdfCtrInput) Dtor_purpose() m_Wrappers.Option {
	return _this.Get_().(KdfCtrInput_KdfCtrInput).Purpose
}

func (_this KdfCtrInput) Dtor_nonce() m_Wrappers.Option {
	return _this.Get_().(KdfCtrInput_KdfCtrInput).Nonce
}

func (_this KdfCtrInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KdfCtrInput_KdfCtrInput:
		{
			return "AwsCryptographyPrimitivesTypes.KdfCtrInput.KdfCtrInput" + "(" + _dafny.String(data.DigestAlgorithm) + ", " + _dafny.String(data.Ikm) + ", " + _dafny.String(data.ExpectedLength) + ", " + _dafny.String(data.Purpose) + ", " + _dafny.String(data.Nonce) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KdfCtrInput) Equals(other KdfCtrInput) bool {
	switch data1 := _this.Get_().(type) {
	case KdfCtrInput_KdfCtrInput:
		{
			data2, ok := other.Get_().(KdfCtrInput_KdfCtrInput)
			return ok && data1.DigestAlgorithm.Equals(data2.DigestAlgorithm) && data1.Ikm.Equals(data2.Ikm) && data1.ExpectedLength == data2.ExpectedLength && data1.Purpose.Equals(data2.Purpose) && data1.Nonce.Equals(data2.Nonce)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KdfCtrInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KdfCtrInput)
	return ok && _this.Equals(typed)
}

func Type_KdfCtrInput_() _dafny.TypeDescriptor {
	return type_KdfCtrInput_{}
}

type type_KdfCtrInput_ struct {
}

func (_this type_KdfCtrInput_) Default() interface{} {
	return Companion_KdfCtrInput_.Default()
}

func (_this type_KdfCtrInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.KdfCtrInput"
}
func (_this KdfCtrInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KdfCtrInput{}

// End of datatype KdfCtrInput

// Definition of datatype ParsePublicKeyInput
type ParsePublicKeyInput struct {
	Data_ParsePublicKeyInput_
}

func (_this ParsePublicKeyInput) Get_() Data_ParsePublicKeyInput_ {
	return _this.Data_ParsePublicKeyInput_
}

type Data_ParsePublicKeyInput_ interface {
	isParsePublicKeyInput()
}

type CompanionStruct_ParsePublicKeyInput_ struct {
}

var Companion_ParsePublicKeyInput_ = CompanionStruct_ParsePublicKeyInput_{}

type ParsePublicKeyInput_ParsePublicKeyInput struct {
	PublicKey _dafny.Sequence
}

func (ParsePublicKeyInput_ParsePublicKeyInput) isParsePublicKeyInput() {}

func (CompanionStruct_ParsePublicKeyInput_) Create_ParsePublicKeyInput_(PublicKey _dafny.Sequence) ParsePublicKeyInput {
	return ParsePublicKeyInput{ParsePublicKeyInput_ParsePublicKeyInput{PublicKey}}
}

func (_this ParsePublicKeyInput) Is_ParsePublicKeyInput() bool {
	_, ok := _this.Get_().(ParsePublicKeyInput_ParsePublicKeyInput)
	return ok
}

func (CompanionStruct_ParsePublicKeyInput_) Default() ParsePublicKeyInput {
	return Companion_ParsePublicKeyInput_.Create_ParsePublicKeyInput_(_dafny.EmptySeq)
}

func (_this ParsePublicKeyInput) Dtor_publicKey() _dafny.Sequence {
	return _this.Get_().(ParsePublicKeyInput_ParsePublicKeyInput).PublicKey
}

func (_this ParsePublicKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ParsePublicKeyInput_ParsePublicKeyInput:
		{
			return "AwsCryptographyPrimitivesTypes.ParsePublicKeyInput.ParsePublicKeyInput" + "(" + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ParsePublicKeyInput) Equals(other ParsePublicKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case ParsePublicKeyInput_ParsePublicKeyInput:
		{
			data2, ok := other.Get_().(ParsePublicKeyInput_ParsePublicKeyInput)
			return ok && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ParsePublicKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ParsePublicKeyInput)
	return ok && _this.Equals(typed)
}

func Type_ParsePublicKeyInput_() _dafny.TypeDescriptor {
	return type_ParsePublicKeyInput_{}
}

type type_ParsePublicKeyInput_ struct {
}

func (_this type_ParsePublicKeyInput_) Default() interface{} {
	return Companion_ParsePublicKeyInput_.Default()
}

func (_this type_ParsePublicKeyInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.ParsePublicKeyInput"
}
func (_this ParsePublicKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ParsePublicKeyInput{}

// End of datatype ParsePublicKeyInput

// Definition of datatype ParsePublicKeyOutput
type ParsePublicKeyOutput struct {
	Data_ParsePublicKeyOutput_
}

func (_this ParsePublicKeyOutput) Get_() Data_ParsePublicKeyOutput_ {
	return _this.Data_ParsePublicKeyOutput_
}

type Data_ParsePublicKeyOutput_ interface {
	isParsePublicKeyOutput()
}

type CompanionStruct_ParsePublicKeyOutput_ struct {
}

var Companion_ParsePublicKeyOutput_ = CompanionStruct_ParsePublicKeyOutput_{}

type ParsePublicKeyOutput_ParsePublicKeyOutput struct {
	PublicKey ECCPublicKey
}

func (ParsePublicKeyOutput_ParsePublicKeyOutput) isParsePublicKeyOutput() {}

func (CompanionStruct_ParsePublicKeyOutput_) Create_ParsePublicKeyOutput_(PublicKey ECCPublicKey) ParsePublicKeyOutput {
	return ParsePublicKeyOutput{ParsePublicKeyOutput_ParsePublicKeyOutput{PublicKey}}
}

func (_this ParsePublicKeyOutput) Is_ParsePublicKeyOutput() bool {
	_, ok := _this.Get_().(ParsePublicKeyOutput_ParsePublicKeyOutput)
	return ok
}

func (CompanionStruct_ParsePublicKeyOutput_) Default() ParsePublicKeyOutput {
	return Companion_ParsePublicKeyOutput_.Create_ParsePublicKeyOutput_(Companion_ECCPublicKey_.Default())
}

func (_this ParsePublicKeyOutput) Dtor_publicKey() ECCPublicKey {
	return _this.Get_().(ParsePublicKeyOutput_ParsePublicKeyOutput).PublicKey
}

func (_this ParsePublicKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ParsePublicKeyOutput_ParsePublicKeyOutput:
		{
			return "AwsCryptographyPrimitivesTypes.ParsePublicKeyOutput.ParsePublicKeyOutput" + "(" + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ParsePublicKeyOutput) Equals(other ParsePublicKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ParsePublicKeyOutput_ParsePublicKeyOutput:
		{
			data2, ok := other.Get_().(ParsePublicKeyOutput_ParsePublicKeyOutput)
			return ok && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ParsePublicKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ParsePublicKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_ParsePublicKeyOutput_() _dafny.TypeDescriptor {
	return type_ParsePublicKeyOutput_{}
}

type type_ParsePublicKeyOutput_ struct {
}

func (_this type_ParsePublicKeyOutput_) Default() interface{} {
	return Companion_ParsePublicKeyOutput_.Default()
}

func (_this type_ParsePublicKeyOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.ParsePublicKeyOutput"
}
func (_this ParsePublicKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ParsePublicKeyOutput{}

// End of datatype ParsePublicKeyOutput

// Definition of class PositiveInteger
type PositiveInteger struct {
}

func New_PositiveInteger_() *PositiveInteger {
	_this := PositiveInteger{}

	return &_this
}

type CompanionStruct_PositiveInteger_ struct {
}

var Companion_PositiveInteger_ = CompanionStruct_PositiveInteger_{}

func (*PositiveInteger) String() string {
	return "AwsCryptographyPrimitivesTypes.PositiveInteger"
}

// End of class PositiveInteger

func Type_PositiveInteger_() _dafny.TypeDescriptor {
	return type_PositiveInteger_{}
}

type type_PositiveInteger_ struct {
}

func (_this type_PositiveInteger_) Default() interface{} {
	return int32(0)
}

func (_this type_PositiveInteger_) String() string {
	return "AwsCryptographyPrimitivesTypes.PositiveInteger"
}
func (_this *CompanionStruct_PositiveInteger_) Is_(__source int32) bool {
	var _0_x int32 = (__source)
	_ = _0_x
	if true {
		return Companion_Default___.IsValid__PositiveInteger(_0_x)
	}
	return false
}

// Definition of datatype RSADecryptInput
type RSADecryptInput struct {
	Data_RSADecryptInput_
}

func (_this RSADecryptInput) Get_() Data_RSADecryptInput_ {
	return _this.Data_RSADecryptInput_
}

type Data_RSADecryptInput_ interface {
	isRSADecryptInput()
}

type CompanionStruct_RSADecryptInput_ struct {
}

var Companion_RSADecryptInput_ = CompanionStruct_RSADecryptInput_{}

type RSADecryptInput_RSADecryptInput struct {
	Padding    RSAPaddingMode
	PrivateKey _dafny.Sequence
	CipherText _dafny.Sequence
}

func (RSADecryptInput_RSADecryptInput) isRSADecryptInput() {}

func (CompanionStruct_RSADecryptInput_) Create_RSADecryptInput_(Padding RSAPaddingMode, PrivateKey _dafny.Sequence, CipherText _dafny.Sequence) RSADecryptInput {
	return RSADecryptInput{RSADecryptInput_RSADecryptInput{Padding, PrivateKey, CipherText}}
}

func (_this RSADecryptInput) Is_RSADecryptInput() bool {
	_, ok := _this.Get_().(RSADecryptInput_RSADecryptInput)
	return ok
}

func (CompanionStruct_RSADecryptInput_) Default() RSADecryptInput {
	return Companion_RSADecryptInput_.Create_RSADecryptInput_(Companion_RSAPaddingMode_.Default(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this RSADecryptInput) Dtor_padding() RSAPaddingMode {
	return _this.Get_().(RSADecryptInput_RSADecryptInput).Padding
}

func (_this RSADecryptInput) Dtor_privateKey() _dafny.Sequence {
	return _this.Get_().(RSADecryptInput_RSADecryptInput).PrivateKey
}

func (_this RSADecryptInput) Dtor_cipherText() _dafny.Sequence {
	return _this.Get_().(RSADecryptInput_RSADecryptInput).CipherText
}

func (_this RSADecryptInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RSADecryptInput_RSADecryptInput:
		{
			return "AwsCryptographyPrimitivesTypes.RSADecryptInput.RSADecryptInput" + "(" + _dafny.String(data.Padding) + ", " + _dafny.String(data.PrivateKey) + ", " + _dafny.String(data.CipherText) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RSADecryptInput) Equals(other RSADecryptInput) bool {
	switch data1 := _this.Get_().(type) {
	case RSADecryptInput_RSADecryptInput:
		{
			data2, ok := other.Get_().(RSADecryptInput_RSADecryptInput)
			return ok && data1.Padding.Equals(data2.Padding) && data1.PrivateKey.Equals(data2.PrivateKey) && data1.CipherText.Equals(data2.CipherText)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RSADecryptInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RSADecryptInput)
	return ok && _this.Equals(typed)
}

func Type_RSADecryptInput_() _dafny.TypeDescriptor {
	return type_RSADecryptInput_{}
}

type type_RSADecryptInput_ struct {
}

func (_this type_RSADecryptInput_) Default() interface{} {
	return Companion_RSADecryptInput_.Default()
}

func (_this type_RSADecryptInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.RSADecryptInput"
}
func (_this RSADecryptInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RSADecryptInput{}

// End of datatype RSADecryptInput

// Definition of datatype RSAEncryptInput
type RSAEncryptInput struct {
	Data_RSAEncryptInput_
}

func (_this RSAEncryptInput) Get_() Data_RSAEncryptInput_ {
	return _this.Data_RSAEncryptInput_
}

type Data_RSAEncryptInput_ interface {
	isRSAEncryptInput()
}

type CompanionStruct_RSAEncryptInput_ struct {
}

var Companion_RSAEncryptInput_ = CompanionStruct_RSAEncryptInput_{}

type RSAEncryptInput_RSAEncryptInput struct {
	Padding   RSAPaddingMode
	PublicKey _dafny.Sequence
	Plaintext _dafny.Sequence
}

func (RSAEncryptInput_RSAEncryptInput) isRSAEncryptInput() {}

func (CompanionStruct_RSAEncryptInput_) Create_RSAEncryptInput_(Padding RSAPaddingMode, PublicKey _dafny.Sequence, Plaintext _dafny.Sequence) RSAEncryptInput {
	return RSAEncryptInput{RSAEncryptInput_RSAEncryptInput{Padding, PublicKey, Plaintext}}
}

func (_this RSAEncryptInput) Is_RSAEncryptInput() bool {
	_, ok := _this.Get_().(RSAEncryptInput_RSAEncryptInput)
	return ok
}

func (CompanionStruct_RSAEncryptInput_) Default() RSAEncryptInput {
	return Companion_RSAEncryptInput_.Create_RSAEncryptInput_(Companion_RSAPaddingMode_.Default(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this RSAEncryptInput) Dtor_padding() RSAPaddingMode {
	return _this.Get_().(RSAEncryptInput_RSAEncryptInput).Padding
}

func (_this RSAEncryptInput) Dtor_publicKey() _dafny.Sequence {
	return _this.Get_().(RSAEncryptInput_RSAEncryptInput).PublicKey
}

func (_this RSAEncryptInput) Dtor_plaintext() _dafny.Sequence {
	return _this.Get_().(RSAEncryptInput_RSAEncryptInput).Plaintext
}

func (_this RSAEncryptInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RSAEncryptInput_RSAEncryptInput:
		{
			return "AwsCryptographyPrimitivesTypes.RSAEncryptInput.RSAEncryptInput" + "(" + _dafny.String(data.Padding) + ", " + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.Plaintext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RSAEncryptInput) Equals(other RSAEncryptInput) bool {
	switch data1 := _this.Get_().(type) {
	case RSAEncryptInput_RSAEncryptInput:
		{
			data2, ok := other.Get_().(RSAEncryptInput_RSAEncryptInput)
			return ok && data1.Padding.Equals(data2.Padding) && data1.PublicKey.Equals(data2.PublicKey) && data1.Plaintext.Equals(data2.Plaintext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RSAEncryptInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RSAEncryptInput)
	return ok && _this.Equals(typed)
}

func Type_RSAEncryptInput_() _dafny.TypeDescriptor {
	return type_RSAEncryptInput_{}
}

type type_RSAEncryptInput_ struct {
}

func (_this type_RSAEncryptInput_) Default() interface{} {
	return Companion_RSAEncryptInput_.Default()
}

func (_this type_RSAEncryptInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.RSAEncryptInput"
}
func (_this RSAEncryptInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RSAEncryptInput{}

// End of datatype RSAEncryptInput

// Definition of class RSAModulusLengthBits
type RSAModulusLengthBits struct {
}

func New_RSAModulusLengthBits_() *RSAModulusLengthBits {
	_this := RSAModulusLengthBits{}

	return &_this
}

type CompanionStruct_RSAModulusLengthBits_ struct {
}

var Companion_RSAModulusLengthBits_ = CompanionStruct_RSAModulusLengthBits_{}

func (*RSAModulusLengthBits) String() string {
	return "AwsCryptographyPrimitivesTypes.RSAModulusLengthBits"
}

// End of class RSAModulusLengthBits

func Type_RSAModulusLengthBits_() _dafny.TypeDescriptor {
	return type_RSAModulusLengthBits_{}
}

type type_RSAModulusLengthBits_ struct {
}

func (_this type_RSAModulusLengthBits_) Default() interface{} {
	return int32(0)
}

func (_this type_RSAModulusLengthBits_) String() string {
	return "AwsCryptographyPrimitivesTypes.RSAModulusLengthBits"
}
func (_this *CompanionStruct_RSAModulusLengthBits_) Is_(__source int32) bool {
	var _1_x int32 = (__source)
	_ = _1_x
	if true {
		return Companion_Default___.IsValid__RSAModulusLengthBits(_1_x)
	}
	return false
}

// Definition of class RSAModulusLengthBitsToGenerate
type RSAModulusLengthBitsToGenerate struct {
}

func New_RSAModulusLengthBitsToGenerate_() *RSAModulusLengthBitsToGenerate {
	_this := RSAModulusLengthBitsToGenerate{}

	return &_this
}

type CompanionStruct_RSAModulusLengthBitsToGenerate_ struct {
}

var Companion_RSAModulusLengthBitsToGenerate_ = CompanionStruct_RSAModulusLengthBitsToGenerate_{}

func (*RSAModulusLengthBitsToGenerate) String() string {
	return "AwsCryptographyPrimitivesTypes.RSAModulusLengthBitsToGenerate"
}

// End of class RSAModulusLengthBitsToGenerate

func Type_RSAModulusLengthBitsToGenerate_() _dafny.TypeDescriptor {
	return type_RSAModulusLengthBitsToGenerate_{}
}

type type_RSAModulusLengthBitsToGenerate_ struct {
}

func (_this type_RSAModulusLengthBitsToGenerate_) Default() interface{} {
	return int32(0)
}

func (_this type_RSAModulusLengthBitsToGenerate_) String() string {
	return "AwsCryptographyPrimitivesTypes.RSAModulusLengthBitsToGenerate"
}
func (_this *CompanionStruct_RSAModulusLengthBitsToGenerate_) Is_(__source int32) bool {
	var _2_x int32 = (__source)
	_ = _2_x
	if true {
		return Companion_Default___.IsValid__RSAModulusLengthBitsToGenerate(_2_x)
	}
	return false
}

// Definition of datatype RSAPaddingMode
type RSAPaddingMode struct {
	Data_RSAPaddingMode_
}

func (_this RSAPaddingMode) Get_() Data_RSAPaddingMode_ {
	return _this.Data_RSAPaddingMode_
}

type Data_RSAPaddingMode_ interface {
	isRSAPaddingMode()
}

type CompanionStruct_RSAPaddingMode_ struct {
}

var Companion_RSAPaddingMode_ = CompanionStruct_RSAPaddingMode_{}

type RSAPaddingMode_PKCS1 struct {
}

func (RSAPaddingMode_PKCS1) isRSAPaddingMode() {}

func (CompanionStruct_RSAPaddingMode_) Create_PKCS1_() RSAPaddingMode {
	return RSAPaddingMode{RSAPaddingMode_PKCS1{}}
}

func (_this RSAPaddingMode) Is_PKCS1() bool {
	_, ok := _this.Get_().(RSAPaddingMode_PKCS1)
	return ok
}

type RSAPaddingMode_OAEP__SHA1 struct {
}

func (RSAPaddingMode_OAEP__SHA1) isRSAPaddingMode() {}

func (CompanionStruct_RSAPaddingMode_) Create_OAEP__SHA1_() RSAPaddingMode {
	return RSAPaddingMode{RSAPaddingMode_OAEP__SHA1{}}
}

func (_this RSAPaddingMode) Is_OAEP__SHA1() bool {
	_, ok := _this.Get_().(RSAPaddingMode_OAEP__SHA1)
	return ok
}

type RSAPaddingMode_OAEP__SHA256 struct {
}

func (RSAPaddingMode_OAEP__SHA256) isRSAPaddingMode() {}

func (CompanionStruct_RSAPaddingMode_) Create_OAEP__SHA256_() RSAPaddingMode {
	return RSAPaddingMode{RSAPaddingMode_OAEP__SHA256{}}
}

func (_this RSAPaddingMode) Is_OAEP__SHA256() bool {
	_, ok := _this.Get_().(RSAPaddingMode_OAEP__SHA256)
	return ok
}

type RSAPaddingMode_OAEP__SHA384 struct {
}

func (RSAPaddingMode_OAEP__SHA384) isRSAPaddingMode() {}

func (CompanionStruct_RSAPaddingMode_) Create_OAEP__SHA384_() RSAPaddingMode {
	return RSAPaddingMode{RSAPaddingMode_OAEP__SHA384{}}
}

func (_this RSAPaddingMode) Is_OAEP__SHA384() bool {
	_, ok := _this.Get_().(RSAPaddingMode_OAEP__SHA384)
	return ok
}

type RSAPaddingMode_OAEP__SHA512 struct {
}

func (RSAPaddingMode_OAEP__SHA512) isRSAPaddingMode() {}

func (CompanionStruct_RSAPaddingMode_) Create_OAEP__SHA512_() RSAPaddingMode {
	return RSAPaddingMode{RSAPaddingMode_OAEP__SHA512{}}
}

func (_this RSAPaddingMode) Is_OAEP__SHA512() bool {
	_, ok := _this.Get_().(RSAPaddingMode_OAEP__SHA512)
	return ok
}

func (CompanionStruct_RSAPaddingMode_) Default() RSAPaddingMode {
	return Companion_RSAPaddingMode_.Create_PKCS1_()
}

func (_ CompanionStruct_RSAPaddingMode_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_RSAPaddingMode_.Create_PKCS1_(), true
		case 1:
			return Companion_RSAPaddingMode_.Create_OAEP__SHA1_(), true
		case 2:
			return Companion_RSAPaddingMode_.Create_OAEP__SHA256_(), true
		case 3:
			return Companion_RSAPaddingMode_.Create_OAEP__SHA384_(), true
		case 4:
			return Companion_RSAPaddingMode_.Create_OAEP__SHA512_(), true
		default:
			return RSAPaddingMode{}, false
		}
	}
}

func (_this RSAPaddingMode) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case RSAPaddingMode_PKCS1:
		{
			return "AwsCryptographyPrimitivesTypes.RSAPaddingMode.PKCS1"
		}
	case RSAPaddingMode_OAEP__SHA1:
		{
			return "AwsCryptographyPrimitivesTypes.RSAPaddingMode.OAEP_SHA1"
		}
	case RSAPaddingMode_OAEP__SHA256:
		{
			return "AwsCryptographyPrimitivesTypes.RSAPaddingMode.OAEP_SHA256"
		}
	case RSAPaddingMode_OAEP__SHA384:
		{
			return "AwsCryptographyPrimitivesTypes.RSAPaddingMode.OAEP_SHA384"
		}
	case RSAPaddingMode_OAEP__SHA512:
		{
			return "AwsCryptographyPrimitivesTypes.RSAPaddingMode.OAEP_SHA512"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RSAPaddingMode) Equals(other RSAPaddingMode) bool {
	switch _this.Get_().(type) {
	case RSAPaddingMode_PKCS1:
		{
			_, ok := other.Get_().(RSAPaddingMode_PKCS1)
			return ok
		}
	case RSAPaddingMode_OAEP__SHA1:
		{
			_, ok := other.Get_().(RSAPaddingMode_OAEP__SHA1)
			return ok
		}
	case RSAPaddingMode_OAEP__SHA256:
		{
			_, ok := other.Get_().(RSAPaddingMode_OAEP__SHA256)
			return ok
		}
	case RSAPaddingMode_OAEP__SHA384:
		{
			_, ok := other.Get_().(RSAPaddingMode_OAEP__SHA384)
			return ok
		}
	case RSAPaddingMode_OAEP__SHA512:
		{
			_, ok := other.Get_().(RSAPaddingMode_OAEP__SHA512)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RSAPaddingMode) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RSAPaddingMode)
	return ok && _this.Equals(typed)
}

func Type_RSAPaddingMode_() _dafny.TypeDescriptor {
	return type_RSAPaddingMode_{}
}

type type_RSAPaddingMode_ struct {
}

func (_this type_RSAPaddingMode_) Default() interface{} {
	return Companion_RSAPaddingMode_.Default()
}

func (_this type_RSAPaddingMode_) String() string {
	return "AwsCryptographyPrimitivesTypes.RSAPaddingMode"
}
func (_this RSAPaddingMode) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RSAPaddingMode{}

// End of datatype RSAPaddingMode

// Definition of datatype RSAPrivateKey
type RSAPrivateKey struct {
	Data_RSAPrivateKey_
}

func (_this RSAPrivateKey) Get_() Data_RSAPrivateKey_ {
	return _this.Data_RSAPrivateKey_
}

type Data_RSAPrivateKey_ interface {
	isRSAPrivateKey()
}

type CompanionStruct_RSAPrivateKey_ struct {
}

var Companion_RSAPrivateKey_ = CompanionStruct_RSAPrivateKey_{}

type RSAPrivateKey_RSAPrivateKey struct {
	LengthBits int32
	Pem        _dafny.Sequence
}

func (RSAPrivateKey_RSAPrivateKey) isRSAPrivateKey() {}

func (CompanionStruct_RSAPrivateKey_) Create_RSAPrivateKey_(LengthBits int32, Pem _dafny.Sequence) RSAPrivateKey {
	return RSAPrivateKey{RSAPrivateKey_RSAPrivateKey{LengthBits, Pem}}
}

func (_this RSAPrivateKey) Is_RSAPrivateKey() bool {
	_, ok := _this.Get_().(RSAPrivateKey_RSAPrivateKey)
	return ok
}

func (CompanionStruct_RSAPrivateKey_) Default() RSAPrivateKey {
	return Companion_RSAPrivateKey_.Create_RSAPrivateKey_(int32(0), _dafny.EmptySeq)
}

func (_this RSAPrivateKey) Dtor_lengthBits() int32 {
	return _this.Get_().(RSAPrivateKey_RSAPrivateKey).LengthBits
}

func (_this RSAPrivateKey) Dtor_pem() _dafny.Sequence {
	return _this.Get_().(RSAPrivateKey_RSAPrivateKey).Pem
}

func (_this RSAPrivateKey) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RSAPrivateKey_RSAPrivateKey:
		{
			return "AwsCryptographyPrimitivesTypes.RSAPrivateKey.RSAPrivateKey" + "(" + _dafny.String(data.LengthBits) + ", " + _dafny.String(data.Pem) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RSAPrivateKey) Equals(other RSAPrivateKey) bool {
	switch data1 := _this.Get_().(type) {
	case RSAPrivateKey_RSAPrivateKey:
		{
			data2, ok := other.Get_().(RSAPrivateKey_RSAPrivateKey)
			return ok && data1.LengthBits == data2.LengthBits && data1.Pem.Equals(data2.Pem)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RSAPrivateKey) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RSAPrivateKey)
	return ok && _this.Equals(typed)
}

func Type_RSAPrivateKey_() _dafny.TypeDescriptor {
	return type_RSAPrivateKey_{}
}

type type_RSAPrivateKey_ struct {
}

func (_this type_RSAPrivateKey_) Default() interface{} {
	return Companion_RSAPrivateKey_.Default()
}

func (_this type_RSAPrivateKey_) String() string {
	return "AwsCryptographyPrimitivesTypes.RSAPrivateKey"
}
func (_this RSAPrivateKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RSAPrivateKey{}

// End of datatype RSAPrivateKey

// Definition of datatype RSAPublicKey
type RSAPublicKey struct {
	Data_RSAPublicKey_
}

func (_this RSAPublicKey) Get_() Data_RSAPublicKey_ {
	return _this.Data_RSAPublicKey_
}

type Data_RSAPublicKey_ interface {
	isRSAPublicKey()
}

type CompanionStruct_RSAPublicKey_ struct {
}

var Companion_RSAPublicKey_ = CompanionStruct_RSAPublicKey_{}

type RSAPublicKey_RSAPublicKey struct {
	LengthBits int32
	Pem        _dafny.Sequence
}

func (RSAPublicKey_RSAPublicKey) isRSAPublicKey() {}

func (CompanionStruct_RSAPublicKey_) Create_RSAPublicKey_(LengthBits int32, Pem _dafny.Sequence) RSAPublicKey {
	return RSAPublicKey{RSAPublicKey_RSAPublicKey{LengthBits, Pem}}
}

func (_this RSAPublicKey) Is_RSAPublicKey() bool {
	_, ok := _this.Get_().(RSAPublicKey_RSAPublicKey)
	return ok
}

func (CompanionStruct_RSAPublicKey_) Default() RSAPublicKey {
	return Companion_RSAPublicKey_.Create_RSAPublicKey_(int32(0), _dafny.EmptySeq)
}

func (_this RSAPublicKey) Dtor_lengthBits() int32 {
	return _this.Get_().(RSAPublicKey_RSAPublicKey).LengthBits
}

func (_this RSAPublicKey) Dtor_pem() _dafny.Sequence {
	return _this.Get_().(RSAPublicKey_RSAPublicKey).Pem
}

func (_this RSAPublicKey) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RSAPublicKey_RSAPublicKey:
		{
			return "AwsCryptographyPrimitivesTypes.RSAPublicKey.RSAPublicKey" + "(" + _dafny.String(data.LengthBits) + ", " + _dafny.String(data.Pem) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RSAPublicKey) Equals(other RSAPublicKey) bool {
	switch data1 := _this.Get_().(type) {
	case RSAPublicKey_RSAPublicKey:
		{
			data2, ok := other.Get_().(RSAPublicKey_RSAPublicKey)
			return ok && data1.LengthBits == data2.LengthBits && data1.Pem.Equals(data2.Pem)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RSAPublicKey) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RSAPublicKey)
	return ok && _this.Equals(typed)
}

func Type_RSAPublicKey_() _dafny.TypeDescriptor {
	return type_RSAPublicKey_{}
}

type type_RSAPublicKey_ struct {
}

func (_this type_RSAPublicKey_) Default() interface{} {
	return Companion_RSAPublicKey_.Default()
}

func (_this type_RSAPublicKey_) String() string {
	return "AwsCryptographyPrimitivesTypes.RSAPublicKey"
}
func (_this RSAPublicKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RSAPublicKey{}

// End of datatype RSAPublicKey

// Definition of class SymmetricKeyLength
type SymmetricKeyLength struct {
}

func New_SymmetricKeyLength_() *SymmetricKeyLength {
	_this := SymmetricKeyLength{}

	return &_this
}

type CompanionStruct_SymmetricKeyLength_ struct {
}

var Companion_SymmetricKeyLength_ = CompanionStruct_SymmetricKeyLength_{}

func (*SymmetricKeyLength) String() string {
	return "AwsCryptographyPrimitivesTypes.SymmetricKeyLength"
}

// End of class SymmetricKeyLength

func Type_SymmetricKeyLength_() _dafny.TypeDescriptor {
	return type_SymmetricKeyLength_{}
}

type type_SymmetricKeyLength_ struct {
}

func (_this type_SymmetricKeyLength_) Default() interface{} {
	return int32(0)
}

func (_this type_SymmetricKeyLength_) String() string {
	return "AwsCryptographyPrimitivesTypes.SymmetricKeyLength"
}
func (_this *CompanionStruct_SymmetricKeyLength_) Is_(__source int32) bool {
	var _3_x int32 = (__source)
	_ = _3_x
	if true {
		return Companion_Default___.IsValid__SymmetricKeyLength(_3_x)
	}
	return false
}

// Definition of class Uint8Bits
type Uint8Bits struct {
}

func New_Uint8Bits_() *Uint8Bits {
	_this := Uint8Bits{}

	return &_this
}

type CompanionStruct_Uint8Bits_ struct {
}

var Companion_Uint8Bits_ = CompanionStruct_Uint8Bits_{}

func (*Uint8Bits) String() string {
	return "AwsCryptographyPrimitivesTypes.Uint8Bits"
}

// End of class Uint8Bits

func Type_Uint8Bits_() _dafny.TypeDescriptor {
	return type_Uint8Bits_{}
}

type type_Uint8Bits_ struct {
}

func (_this type_Uint8Bits_) Default() interface{} {
	return int32(0)
}

func (_this type_Uint8Bits_) String() string {
	return "AwsCryptographyPrimitivesTypes.Uint8Bits"
}
func (_this *CompanionStruct_Uint8Bits_) Is_(__source int32) bool {
	var _4_x int32 = (__source)
	_ = _4_x
	if true {
		return Companion_Default___.IsValid__Uint8Bits(_4_x)
	}
	return false
}

// Definition of class Uint8Bytes
type Uint8Bytes struct {
}

func New_Uint8Bytes_() *Uint8Bytes {
	_this := Uint8Bytes{}

	return &_this
}

type CompanionStruct_Uint8Bytes_ struct {
}

var Companion_Uint8Bytes_ = CompanionStruct_Uint8Bytes_{}

func (*Uint8Bytes) String() string {
	return "AwsCryptographyPrimitivesTypes.Uint8Bytes"
}

// End of class Uint8Bytes

func Type_Uint8Bytes_() _dafny.TypeDescriptor {
	return type_Uint8Bytes_{}
}

type type_Uint8Bytes_ struct {
}

func (_this type_Uint8Bytes_) Default() interface{} {
	return int32(0)
}

func (_this type_Uint8Bytes_) String() string {
	return "AwsCryptographyPrimitivesTypes.Uint8Bytes"
}
func (_this *CompanionStruct_Uint8Bytes_) Is_(__source int32) bool {
	var _5_x int32 = (__source)
	_ = _5_x
	if true {
		return Companion_Default___.IsValid__Uint8Bytes(_5_x)
	}
	return false
}

// Definition of datatype ValidatePublicKeyInput
type ValidatePublicKeyInput struct {
	Data_ValidatePublicKeyInput_
}

func (_this ValidatePublicKeyInput) Get_() Data_ValidatePublicKeyInput_ {
	return _this.Data_ValidatePublicKeyInput_
}

type Data_ValidatePublicKeyInput_ interface {
	isValidatePublicKeyInput()
}

type CompanionStruct_ValidatePublicKeyInput_ struct {
}

var Companion_ValidatePublicKeyInput_ = CompanionStruct_ValidatePublicKeyInput_{}

type ValidatePublicKeyInput_ValidatePublicKeyInput struct {
	EccCurve  ECDHCurveSpec
	PublicKey _dafny.Sequence
}

func (ValidatePublicKeyInput_ValidatePublicKeyInput) isValidatePublicKeyInput() {}

func (CompanionStruct_ValidatePublicKeyInput_) Create_ValidatePublicKeyInput_(EccCurve ECDHCurveSpec, PublicKey _dafny.Sequence) ValidatePublicKeyInput {
	return ValidatePublicKeyInput{ValidatePublicKeyInput_ValidatePublicKeyInput{EccCurve, PublicKey}}
}

func (_this ValidatePublicKeyInput) Is_ValidatePublicKeyInput() bool {
	_, ok := _this.Get_().(ValidatePublicKeyInput_ValidatePublicKeyInput)
	return ok
}

func (CompanionStruct_ValidatePublicKeyInput_) Default() ValidatePublicKeyInput {
	return Companion_ValidatePublicKeyInput_.Create_ValidatePublicKeyInput_(Companion_ECDHCurveSpec_.Default(), _dafny.EmptySeq)
}

func (_this ValidatePublicKeyInput) Dtor_eccCurve() ECDHCurveSpec {
	return _this.Get_().(ValidatePublicKeyInput_ValidatePublicKeyInput).EccCurve
}

func (_this ValidatePublicKeyInput) Dtor_publicKey() _dafny.Sequence {
	return _this.Get_().(ValidatePublicKeyInput_ValidatePublicKeyInput).PublicKey
}

func (_this ValidatePublicKeyInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ValidatePublicKeyInput_ValidatePublicKeyInput:
		{
			return "AwsCryptographyPrimitivesTypes.ValidatePublicKeyInput.ValidatePublicKeyInput" + "(" + _dafny.String(data.EccCurve) + ", " + _dafny.String(data.PublicKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ValidatePublicKeyInput) Equals(other ValidatePublicKeyInput) bool {
	switch data1 := _this.Get_().(type) {
	case ValidatePublicKeyInput_ValidatePublicKeyInput:
		{
			data2, ok := other.Get_().(ValidatePublicKeyInput_ValidatePublicKeyInput)
			return ok && data1.EccCurve.Equals(data2.EccCurve) && data1.PublicKey.Equals(data2.PublicKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ValidatePublicKeyInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ValidatePublicKeyInput)
	return ok && _this.Equals(typed)
}

func Type_ValidatePublicKeyInput_() _dafny.TypeDescriptor {
	return type_ValidatePublicKeyInput_{}
}

type type_ValidatePublicKeyInput_ struct {
}

func (_this type_ValidatePublicKeyInput_) Default() interface{} {
	return Companion_ValidatePublicKeyInput_.Default()
}

func (_this type_ValidatePublicKeyInput_) String() string {
	return "AwsCryptographyPrimitivesTypes.ValidatePublicKeyInput"
}
func (_this ValidatePublicKeyInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ValidatePublicKeyInput{}

// End of datatype ValidatePublicKeyInput

// Definition of datatype ValidatePublicKeyOutput
type ValidatePublicKeyOutput struct {
	Data_ValidatePublicKeyOutput_
}

func (_this ValidatePublicKeyOutput) Get_() Data_ValidatePublicKeyOutput_ {
	return _this.Data_ValidatePublicKeyOutput_
}

type Data_ValidatePublicKeyOutput_ interface {
	isValidatePublicKeyOutput()
}

type CompanionStruct_ValidatePublicKeyOutput_ struct {
}

var Companion_ValidatePublicKeyOutput_ = CompanionStruct_ValidatePublicKeyOutput_{}

type ValidatePublicKeyOutput_ValidatePublicKeyOutput struct {
	Success bool
}

func (ValidatePublicKeyOutput_ValidatePublicKeyOutput) isValidatePublicKeyOutput() {}

func (CompanionStruct_ValidatePublicKeyOutput_) Create_ValidatePublicKeyOutput_(Success bool) ValidatePublicKeyOutput {
	return ValidatePublicKeyOutput{ValidatePublicKeyOutput_ValidatePublicKeyOutput{Success}}
}

func (_this ValidatePublicKeyOutput) Is_ValidatePublicKeyOutput() bool {
	_, ok := _this.Get_().(ValidatePublicKeyOutput_ValidatePublicKeyOutput)
	return ok
}

func (CompanionStruct_ValidatePublicKeyOutput_) Default() ValidatePublicKeyOutput {
	return Companion_ValidatePublicKeyOutput_.Create_ValidatePublicKeyOutput_(false)
}

func (_this ValidatePublicKeyOutput) Dtor_success() bool {
	return _this.Get_().(ValidatePublicKeyOutput_ValidatePublicKeyOutput).Success
}

func (_this ValidatePublicKeyOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ValidatePublicKeyOutput_ValidatePublicKeyOutput:
		{
			return "AwsCryptographyPrimitivesTypes.ValidatePublicKeyOutput.ValidatePublicKeyOutput" + "(" + _dafny.String(data.Success) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ValidatePublicKeyOutput) Equals(other ValidatePublicKeyOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ValidatePublicKeyOutput_ValidatePublicKeyOutput:
		{
			data2, ok := other.Get_().(ValidatePublicKeyOutput_ValidatePublicKeyOutput)
			return ok && data1.Success == data2.Success
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ValidatePublicKeyOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ValidatePublicKeyOutput)
	return ok && _this.Equals(typed)
}

func Type_ValidatePublicKeyOutput_() _dafny.TypeDescriptor {
	return type_ValidatePublicKeyOutput_{}
}

type type_ValidatePublicKeyOutput_ struct {
}

func (_this type_ValidatePublicKeyOutput_) Default() interface{} {
	return Companion_ValidatePublicKeyOutput_.Default()
}

func (_this type_ValidatePublicKeyOutput_) String() string {
	return "AwsCryptographyPrimitivesTypes.ValidatePublicKeyOutput"
}
func (_this ValidatePublicKeyOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ValidatePublicKeyOutput{}

// End of datatype ValidatePublicKeyOutput

// Definition of datatype Error
type Error struct {
	Data_Error_
}

func (_this Error) Get_() Data_Error_ {
	return _this.Data_Error_
}

type Data_Error_ interface {
	isError()
}

type CompanionStruct_Error_ struct {
}

var Companion_Error_ = CompanionStruct_Error_{}

type Error_AwsCryptographicPrimitivesError struct {
	Message _dafny.Sequence
}

func (Error_AwsCryptographicPrimitivesError) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographicPrimitivesError_(Message _dafny.Sequence) Error {
	return Error{Error_AwsCryptographicPrimitivesError{Message}}
}

func (_this Error) Is_AwsCryptographicPrimitivesError() bool {
	_, ok := _this.Get_().(Error_AwsCryptographicPrimitivesError)
	return ok
}

type Error_CollectionOfErrors struct {
	List    _dafny.Sequence
	Message _dafny.Sequence
}

func (Error_CollectionOfErrors) isError() {}

func (CompanionStruct_Error_) Create_CollectionOfErrors_(List _dafny.Sequence, Message _dafny.Sequence) Error {
	return Error{Error_CollectionOfErrors{List, Message}}
}

func (_this Error) Is_CollectionOfErrors() bool {
	_, ok := _this.Get_().(Error_CollectionOfErrors)
	return ok
}

type Error_Opaque struct {
	Obj interface{}
}

func (Error_Opaque) isError() {}

func (CompanionStruct_Error_) Create_Opaque_(Obj interface{}) Error {
	return Error{Error_Opaque{Obj}}
}

func (_this Error) Is_Opaque() bool {
	_, ok := _this.Get_().(Error_Opaque)
	return ok
}

type Error_OpaqueWithText struct {
	Obj        interface{}
	ObjMessage _dafny.Sequence
}

func (Error_OpaqueWithText) isError() {}

func (CompanionStruct_Error_) Create_OpaqueWithText_(Obj interface{}, ObjMessage _dafny.Sequence) Error {
	return Error{Error_OpaqueWithText{Obj, ObjMessage}}
}

func (_this Error) Is_OpaqueWithText() bool {
	_, ok := _this.Get_().(Error_OpaqueWithText)
	return ok
}

func (CompanionStruct_Error_) Default() Error {
	return Companion_Error_.Create_AwsCryptographicPrimitivesError_(_dafny.EmptySeq.SetString())
}

func (_this Error) Dtor_message() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Error_AwsCryptographicPrimitivesError:
		return data.Message
	default:
		return data.(Error_CollectionOfErrors).Message
	}
}

func (_this Error) Dtor_list() _dafny.Sequence {
	return _this.Get_().(Error_CollectionOfErrors).List
}

func (_this Error) Dtor_obj() interface{} {
	switch data := _this.Get_().(type) {
	case Error_Opaque:
		return data.Obj
	default:
		return data.(Error_OpaqueWithText).Obj
	}
}

func (_this Error) Dtor_objMessage() _dafny.Sequence {
	return _this.Get_().(Error_OpaqueWithText).ObjMessage
}

func (_this Error) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Error_AwsCryptographicPrimitivesError:
		{
			return "AwsCryptographyPrimitivesTypes.Error.AwsCryptographicPrimitivesError" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CollectionOfErrors:
		{
			return "AwsCryptographyPrimitivesTypes.Error.CollectionOfErrors" + "(" + _dafny.String(data.List) + ", " + _dafny.String(data.Message) + ")"
		}
	case Error_Opaque:
		{
			return "AwsCryptographyPrimitivesTypes.Error.Opaque" + "(" + _dafny.String(data.Obj) + ")"
		}
	case Error_OpaqueWithText:
		{
			return "AwsCryptographyPrimitivesTypes.Error.OpaqueWithText" + "(" + _dafny.String(data.Obj) + ", " + _dafny.String(data.ObjMessage) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Error) Equals(other Error) bool {
	switch data1 := _this.Get_().(type) {
	case Error_AwsCryptographicPrimitivesError:
		{
			data2, ok := other.Get_().(Error_AwsCryptographicPrimitivesError)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CollectionOfErrors:
		{
			data2, ok := other.Get_().(Error_CollectionOfErrors)
			return ok && data1.List.Equals(data2.List) && data1.Message.Equals(data2.Message)
		}
	case Error_Opaque:
		{
			data2, ok := other.Get_().(Error_Opaque)
			return ok && _dafny.AreEqual(data1.Obj, data2.Obj)
		}
	case Error_OpaqueWithText:
		{
			data2, ok := other.Get_().(Error_OpaqueWithText)
			return ok && _dafny.AreEqual(data1.Obj, data2.Obj) && data1.ObjMessage.Equals(data2.ObjMessage)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Error) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Error)
	return ok && _this.Equals(typed)
}

func Type_Error_() _dafny.TypeDescriptor {
	return type_Error_{}
}

type type_Error_ struct {
}

func (_this type_Error_) Default() interface{} {
	return Companion_Error_.Default()
}

func (_this type_Error_) String() string {
	return "AwsCryptographyPrimitivesTypes.Error"
}
func (_this Error) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Error{}

// End of datatype Error

// Definition of class OpaqueError
type OpaqueError struct {
}

func New_OpaqueError_() *OpaqueError {
	_this := OpaqueError{}

	return &_this
}

type CompanionStruct_OpaqueError_ struct {
}

var Companion_OpaqueError_ = CompanionStruct_OpaqueError_{}

func (*OpaqueError) String() string {
	return "AwsCryptographyPrimitivesTypes.OpaqueError"
}

// End of class OpaqueError

func Type_OpaqueError_() _dafny.TypeDescriptor {
	return type_OpaqueError_{}
}

type type_OpaqueError_ struct {
}

func (_this type_OpaqueError_) Default() interface{} {
	return Companion_Error_.Default()
}

func (_this type_OpaqueError_) String() string {
	return "AwsCryptographyPrimitivesTypes.OpaqueError"
}
func (_this *CompanionStruct_OpaqueError_) Is_(__source Error) bool {
	var _6_e Error = (__source)
	_ = _6_e
	return ((_6_e).Is_Opaque()) || ((_6_e).Is_OpaqueWithText())
}

// Definition of class DummySubsetType
type DummySubsetType struct {
}

func New_DummySubsetType_() *DummySubsetType {
	_this := DummySubsetType{}

	return &_this
}

type CompanionStruct_DummySubsetType_ struct {
}

var Companion_DummySubsetType_ = CompanionStruct_DummySubsetType_{}

func (*DummySubsetType) String() string {
	return "AwsCryptographyPrimitivesTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Witness() _dafny.Int {
	return _dafny.One
}

// End of class DummySubsetType

func Type_DummySubsetType_() _dafny.TypeDescriptor {
	return type_DummySubsetType_{}
}

type type_DummySubsetType_ struct {
}

func (_this type_DummySubsetType_) Default() interface{} {
	return Companion_DummySubsetType_.Witness()
}

func (_this type_DummySubsetType_) String() string {
	return "AwsCryptographyPrimitivesTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Is_(__source _dafny.Int) bool {
	var _7_x _dafny.Int = (__source)
	_ = _7_x
	return Companion_Default___.IsDummySubsetType(_7_x)
}
