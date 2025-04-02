// Package ComAmazonawsKmsTypes
// Dafny module ComAmazonawsKmsTypes compiled into Go

package ComAmazonawsKmsTypes

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
	return "ComAmazonawsKmsTypes.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsValid__AliasNameType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(256)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__ArnType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(20)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(2048)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__AttestationDocumentType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(262144)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__CiphertextType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(6144)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__CloudHsmClusterIdType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(19)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(24)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__CustomKeyStoreIdType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(64)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__CustomKeyStoreNameType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(256)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__DescriptionType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfUint32((x).Cardinality())).Sign() != -1) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(8192)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__GrantIdType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(128)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__GrantNameType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(256)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__GrantTokenList(x _dafny.Sequence) bool {
	return ((_dafny.IntOfUint32((x).Cardinality())).Sign() != -1) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(10)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__GrantTokenType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(8192)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__KeyIdType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(2048)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__KeyStorePasswordType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(7)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(32)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__LimitType(x int32) bool {
	return ((int32(1)) <= (x)) && ((x) <= (int32(1000)))
}
func (_static *CompanionStruct_Default___) IsValid__MarkerType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(1024)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__NumberOfBytesType(x int32) bool {
	return ((int32(1)) <= (x)) && ((x) <= (int32(1024)))
}
func (_static *CompanionStruct_Default___) IsValid__PendingWindowInDaysType(x int32) bool {
	return ((int32(1)) <= (x)) && ((x) <= (int32(365)))
}
func (_static *CompanionStruct_Default___) IsValid__PlaintextType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(4096)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__PolicyNameType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(128)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__PolicyType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(131072)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__PrincipalIdType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(256)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__PublicKeyType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(8192)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__RegionType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(32)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__RotationPeriodInDaysType(x int32) bool {
	return ((int32(90)) <= (x)) && ((x) <= (int32(2560)))
}
func (_static *CompanionStruct_Default___) IsValid__TagKeyType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(128)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__TagValueType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfUint32((x).Cardinality())).Sign() != -1) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(256)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__TrustAnchorCertificateType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(5000)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__XksKeyIdType(x _dafny.Sequence) bool {
	return ((_dafny.One).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(128)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__XksProxyAuthenticationAccessKeyIdType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(20)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(30)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__XksProxyAuthenticationRawSecretAccessKeyType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(43)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(64)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__XksProxyUriEndpointType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(10)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(128)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__XksProxyUriPathType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(10)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(128)) <= 0)
}
func (_static *CompanionStruct_Default___) IsValid__XksProxyVpcEndpointServiceNameType(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(20)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(64)) <= 0)
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
			return "ComAmazonawsKmsTypes.DafnyCallEvent.DafnyCallEvent" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
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
	return "ComAmazonawsKmsTypes.DafnyCallEvent"
}
func (_this DafnyCallEvent) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DafnyCallEvent{}

// End of datatype DafnyCallEvent

// Definition of datatype AlgorithmSpec
type AlgorithmSpec struct {
	Data_AlgorithmSpec_
}

func (_this AlgorithmSpec) Get_() Data_AlgorithmSpec_ {
	return _this.Data_AlgorithmSpec_
}

type Data_AlgorithmSpec_ interface {
	isAlgorithmSpec()
}

type CompanionStruct_AlgorithmSpec_ struct {
}

var Companion_AlgorithmSpec_ = CompanionStruct_AlgorithmSpec_{}

type AlgorithmSpec_RSAES__PKCS1__V1__5 struct {
}

func (AlgorithmSpec_RSAES__PKCS1__V1__5) isAlgorithmSpec() {}

func (CompanionStruct_AlgorithmSpec_) Create_RSAES__PKCS1__V1__5_() AlgorithmSpec {
	return AlgorithmSpec{AlgorithmSpec_RSAES__PKCS1__V1__5{}}
}

func (_this AlgorithmSpec) Is_RSAES__PKCS1__V1__5() bool {
	_, ok := _this.Get_().(AlgorithmSpec_RSAES__PKCS1__V1__5)
	return ok
}

type AlgorithmSpec_RSAES__OAEP__SHA__1 struct {
}

func (AlgorithmSpec_RSAES__OAEP__SHA__1) isAlgorithmSpec() {}

func (CompanionStruct_AlgorithmSpec_) Create_RSAES__OAEP__SHA__1_() AlgorithmSpec {
	return AlgorithmSpec{AlgorithmSpec_RSAES__OAEP__SHA__1{}}
}

func (_this AlgorithmSpec) Is_RSAES__OAEP__SHA__1() bool {
	_, ok := _this.Get_().(AlgorithmSpec_RSAES__OAEP__SHA__1)
	return ok
}

type AlgorithmSpec_RSAES__OAEP__SHA__256 struct {
}

func (AlgorithmSpec_RSAES__OAEP__SHA__256) isAlgorithmSpec() {}

func (CompanionStruct_AlgorithmSpec_) Create_RSAES__OAEP__SHA__256_() AlgorithmSpec {
	return AlgorithmSpec{AlgorithmSpec_RSAES__OAEP__SHA__256{}}
}

func (_this AlgorithmSpec) Is_RSAES__OAEP__SHA__256() bool {
	_, ok := _this.Get_().(AlgorithmSpec_RSAES__OAEP__SHA__256)
	return ok
}

type AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__1 struct {
}

func (AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__1) isAlgorithmSpec() {}

func (CompanionStruct_AlgorithmSpec_) Create_RSA__AES__KEY__WRAP__SHA__1_() AlgorithmSpec {
	return AlgorithmSpec{AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__1{}}
}

func (_this AlgorithmSpec) Is_RSA__AES__KEY__WRAP__SHA__1() bool {
	_, ok := _this.Get_().(AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__1)
	return ok
}

type AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__256 struct {
}

func (AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__256) isAlgorithmSpec() {}

func (CompanionStruct_AlgorithmSpec_) Create_RSA__AES__KEY__WRAP__SHA__256_() AlgorithmSpec {
	return AlgorithmSpec{AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__256{}}
}

func (_this AlgorithmSpec) Is_RSA__AES__KEY__WRAP__SHA__256() bool {
	_, ok := _this.Get_().(AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__256)
	return ok
}

type AlgorithmSpec_SM2PKE struct {
}

func (AlgorithmSpec_SM2PKE) isAlgorithmSpec() {}

func (CompanionStruct_AlgorithmSpec_) Create_SM2PKE_() AlgorithmSpec {
	return AlgorithmSpec{AlgorithmSpec_SM2PKE{}}
}

func (_this AlgorithmSpec) Is_SM2PKE() bool {
	_, ok := _this.Get_().(AlgorithmSpec_SM2PKE)
	return ok
}

func (CompanionStruct_AlgorithmSpec_) Default() AlgorithmSpec {
	return Companion_AlgorithmSpec_.Create_RSAES__PKCS1__V1__5_()
}

func (_ CompanionStruct_AlgorithmSpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_AlgorithmSpec_.Create_RSAES__PKCS1__V1__5_(), true
		case 1:
			return Companion_AlgorithmSpec_.Create_RSAES__OAEP__SHA__1_(), true
		case 2:
			return Companion_AlgorithmSpec_.Create_RSAES__OAEP__SHA__256_(), true
		case 3:
			return Companion_AlgorithmSpec_.Create_RSA__AES__KEY__WRAP__SHA__1_(), true
		case 4:
			return Companion_AlgorithmSpec_.Create_RSA__AES__KEY__WRAP__SHA__256_(), true
		case 5:
			return Companion_AlgorithmSpec_.Create_SM2PKE_(), true
		default:
			return AlgorithmSpec{}, false
		}
	}
}

func (_this AlgorithmSpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case AlgorithmSpec_RSAES__PKCS1__V1__5:
		{
			return "ComAmazonawsKmsTypes.AlgorithmSpec.RSAES_PKCS1_V1_5"
		}
	case AlgorithmSpec_RSAES__OAEP__SHA__1:
		{
			return "ComAmazonawsKmsTypes.AlgorithmSpec.RSAES_OAEP_SHA_1"
		}
	case AlgorithmSpec_RSAES__OAEP__SHA__256:
		{
			return "ComAmazonawsKmsTypes.AlgorithmSpec.RSAES_OAEP_SHA_256"
		}
	case AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__1:
		{
			return "ComAmazonawsKmsTypes.AlgorithmSpec.RSA_AES_KEY_WRAP_SHA_1"
		}
	case AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__256:
		{
			return "ComAmazonawsKmsTypes.AlgorithmSpec.RSA_AES_KEY_WRAP_SHA_256"
		}
	case AlgorithmSpec_SM2PKE:
		{
			return "ComAmazonawsKmsTypes.AlgorithmSpec.SM2PKE"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AlgorithmSpec) Equals(other AlgorithmSpec) bool {
	switch _this.Get_().(type) {
	case AlgorithmSpec_RSAES__PKCS1__V1__5:
		{
			_, ok := other.Get_().(AlgorithmSpec_RSAES__PKCS1__V1__5)
			return ok
		}
	case AlgorithmSpec_RSAES__OAEP__SHA__1:
		{
			_, ok := other.Get_().(AlgorithmSpec_RSAES__OAEP__SHA__1)
			return ok
		}
	case AlgorithmSpec_RSAES__OAEP__SHA__256:
		{
			_, ok := other.Get_().(AlgorithmSpec_RSAES__OAEP__SHA__256)
			return ok
		}
	case AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__1:
		{
			_, ok := other.Get_().(AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__1)
			return ok
		}
	case AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__256:
		{
			_, ok := other.Get_().(AlgorithmSpec_RSA__AES__KEY__WRAP__SHA__256)
			return ok
		}
	case AlgorithmSpec_SM2PKE:
		{
			_, ok := other.Get_().(AlgorithmSpec_SM2PKE)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AlgorithmSpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AlgorithmSpec)
	return ok && _this.Equals(typed)
}

func Type_AlgorithmSpec_() _dafny.TypeDescriptor {
	return type_AlgorithmSpec_{}
}

type type_AlgorithmSpec_ struct {
}

func (_this type_AlgorithmSpec_) Default() interface{} {
	return Companion_AlgorithmSpec_.Default()
}

func (_this type_AlgorithmSpec_) String() string {
	return "ComAmazonawsKmsTypes.AlgorithmSpec"
}
func (_this AlgorithmSpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AlgorithmSpec{}

// End of datatype AlgorithmSpec

// Definition of datatype AliasListEntry
type AliasListEntry struct {
	Data_AliasListEntry_
}

func (_this AliasListEntry) Get_() Data_AliasListEntry_ {
	return _this.Data_AliasListEntry_
}

type Data_AliasListEntry_ interface {
	isAliasListEntry()
}

type CompanionStruct_AliasListEntry_ struct {
}

var Companion_AliasListEntry_ = CompanionStruct_AliasListEntry_{}

type AliasListEntry_AliasListEntry struct {
	AliasName       m_Wrappers.Option
	AliasArn        m_Wrappers.Option
	TargetKeyId     m_Wrappers.Option
	CreationDate    m_Wrappers.Option
	LastUpdatedDate m_Wrappers.Option
}

func (AliasListEntry_AliasListEntry) isAliasListEntry() {}

func (CompanionStruct_AliasListEntry_) Create_AliasListEntry_(AliasName m_Wrappers.Option, AliasArn m_Wrappers.Option, TargetKeyId m_Wrappers.Option, CreationDate m_Wrappers.Option, LastUpdatedDate m_Wrappers.Option) AliasListEntry {
	return AliasListEntry{AliasListEntry_AliasListEntry{AliasName, AliasArn, TargetKeyId, CreationDate, LastUpdatedDate}}
}

func (_this AliasListEntry) Is_AliasListEntry() bool {
	_, ok := _this.Get_().(AliasListEntry_AliasListEntry)
	return ok
}

func (CompanionStruct_AliasListEntry_) Default() AliasListEntry {
	return Companion_AliasListEntry_.Create_AliasListEntry_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this AliasListEntry) Dtor_AliasName() m_Wrappers.Option {
	return _this.Get_().(AliasListEntry_AliasListEntry).AliasName
}

func (_this AliasListEntry) Dtor_AliasArn() m_Wrappers.Option {
	return _this.Get_().(AliasListEntry_AliasListEntry).AliasArn
}

func (_this AliasListEntry) Dtor_TargetKeyId() m_Wrappers.Option {
	return _this.Get_().(AliasListEntry_AliasListEntry).TargetKeyId
}

func (_this AliasListEntry) Dtor_CreationDate() m_Wrappers.Option {
	return _this.Get_().(AliasListEntry_AliasListEntry).CreationDate
}

func (_this AliasListEntry) Dtor_LastUpdatedDate() m_Wrappers.Option {
	return _this.Get_().(AliasListEntry_AliasListEntry).LastUpdatedDate
}

func (_this AliasListEntry) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AliasListEntry_AliasListEntry:
		{
			return "ComAmazonawsKmsTypes.AliasListEntry.AliasListEntry" + "(" + _dafny.String(data.AliasName) + ", " + _dafny.String(data.AliasArn) + ", " + _dafny.String(data.TargetKeyId) + ", " + _dafny.String(data.CreationDate) + ", " + _dafny.String(data.LastUpdatedDate) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AliasListEntry) Equals(other AliasListEntry) bool {
	switch data1 := _this.Get_().(type) {
	case AliasListEntry_AliasListEntry:
		{
			data2, ok := other.Get_().(AliasListEntry_AliasListEntry)
			return ok && data1.AliasName.Equals(data2.AliasName) && data1.AliasArn.Equals(data2.AliasArn) && data1.TargetKeyId.Equals(data2.TargetKeyId) && data1.CreationDate.Equals(data2.CreationDate) && data1.LastUpdatedDate.Equals(data2.LastUpdatedDate)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AliasListEntry) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AliasListEntry)
	return ok && _this.Equals(typed)
}

func Type_AliasListEntry_() _dafny.TypeDescriptor {
	return type_AliasListEntry_{}
}

type type_AliasListEntry_ struct {
}

func (_this type_AliasListEntry_) Default() interface{} {
	return Companion_AliasListEntry_.Default()
}

func (_this type_AliasListEntry_) String() string {
	return "ComAmazonawsKmsTypes.AliasListEntry"
}
func (_this AliasListEntry) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AliasListEntry{}

// End of datatype AliasListEntry

// Definition of class AliasNameType
type AliasNameType struct {
}

func New_AliasNameType_() *AliasNameType {
	_this := AliasNameType{}

	return &_this
}

type CompanionStruct_AliasNameType_ struct {
}

var Companion_AliasNameType_ = CompanionStruct_AliasNameType_{}

func (*AliasNameType) String() string {
	return "ComAmazonawsKmsTypes.AliasNameType"
}

// End of class AliasNameType

func Type_AliasNameType_() _dafny.TypeDescriptor {
	return type_AliasNameType_{}
}

type type_AliasNameType_ struct {
}

func (_this type_AliasNameType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_AliasNameType_) String() string {
	return "ComAmazonawsKmsTypes.AliasNameType"
}
func (_this *CompanionStruct_AliasNameType_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return Companion_Default___.IsValid__AliasNameType(_0_x)
}

// Definition of class ArnType
type ArnType struct {
}

func New_ArnType_() *ArnType {
	_this := ArnType{}

	return &_this
}

type CompanionStruct_ArnType_ struct {
}

var Companion_ArnType_ = CompanionStruct_ArnType_{}

func (*ArnType) String() string {
	return "ComAmazonawsKmsTypes.ArnType"
}

// End of class ArnType

func Type_ArnType_() _dafny.TypeDescriptor {
	return type_ArnType_{}
}

type type_ArnType_ struct {
}

func (_this type_ArnType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_ArnType_) String() string {
	return "ComAmazonawsKmsTypes.ArnType"
}
func (_this *CompanionStruct_ArnType_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return Companion_Default___.IsValid__ArnType(_1_x)
}

// Definition of class AttestationDocumentType
type AttestationDocumentType struct {
}

func New_AttestationDocumentType_() *AttestationDocumentType {
	_this := AttestationDocumentType{}

	return &_this
}

type CompanionStruct_AttestationDocumentType_ struct {
}

var Companion_AttestationDocumentType_ = CompanionStruct_AttestationDocumentType_{}

func (*AttestationDocumentType) String() string {
	return "ComAmazonawsKmsTypes.AttestationDocumentType"
}

// End of class AttestationDocumentType

func Type_AttestationDocumentType_() _dafny.TypeDescriptor {
	return type_AttestationDocumentType_{}
}

type type_AttestationDocumentType_ struct {
}

func (_this type_AttestationDocumentType_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_AttestationDocumentType_) String() string {
	return "ComAmazonawsKmsTypes.AttestationDocumentType"
}
func (_this *CompanionStruct_AttestationDocumentType_) Is_(__source _dafny.Sequence) bool {
	var _2_x _dafny.Sequence = (__source)
	_ = _2_x
	return Companion_Default___.IsValid__AttestationDocumentType(_2_x)
}

// Definition of datatype CancelKeyDeletionRequest
type CancelKeyDeletionRequest struct {
	Data_CancelKeyDeletionRequest_
}

func (_this CancelKeyDeletionRequest) Get_() Data_CancelKeyDeletionRequest_ {
	return _this.Data_CancelKeyDeletionRequest_
}

type Data_CancelKeyDeletionRequest_ interface {
	isCancelKeyDeletionRequest()
}

type CompanionStruct_CancelKeyDeletionRequest_ struct {
}

var Companion_CancelKeyDeletionRequest_ = CompanionStruct_CancelKeyDeletionRequest_{}

type CancelKeyDeletionRequest_CancelKeyDeletionRequest struct {
	KeyId _dafny.Sequence
}

func (CancelKeyDeletionRequest_CancelKeyDeletionRequest) isCancelKeyDeletionRequest() {}

func (CompanionStruct_CancelKeyDeletionRequest_) Create_CancelKeyDeletionRequest_(KeyId _dafny.Sequence) CancelKeyDeletionRequest {
	return CancelKeyDeletionRequest{CancelKeyDeletionRequest_CancelKeyDeletionRequest{KeyId}}
}

func (_this CancelKeyDeletionRequest) Is_CancelKeyDeletionRequest() bool {
	_, ok := _this.Get_().(CancelKeyDeletionRequest_CancelKeyDeletionRequest)
	return ok
}

func (CompanionStruct_CancelKeyDeletionRequest_) Default() CancelKeyDeletionRequest {
	return Companion_CancelKeyDeletionRequest_.Create_CancelKeyDeletionRequest_(_dafny.EmptySeq.SetString())
}

func (_this CancelKeyDeletionRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(CancelKeyDeletionRequest_CancelKeyDeletionRequest).KeyId
}

func (_this CancelKeyDeletionRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CancelKeyDeletionRequest_CancelKeyDeletionRequest:
		{
			return "ComAmazonawsKmsTypes.CancelKeyDeletionRequest.CancelKeyDeletionRequest" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CancelKeyDeletionRequest) Equals(other CancelKeyDeletionRequest) bool {
	switch data1 := _this.Get_().(type) {
	case CancelKeyDeletionRequest_CancelKeyDeletionRequest:
		{
			data2, ok := other.Get_().(CancelKeyDeletionRequest_CancelKeyDeletionRequest)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CancelKeyDeletionRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CancelKeyDeletionRequest)
	return ok && _this.Equals(typed)
}

func Type_CancelKeyDeletionRequest_() _dafny.TypeDescriptor {
	return type_CancelKeyDeletionRequest_{}
}

type type_CancelKeyDeletionRequest_ struct {
}

func (_this type_CancelKeyDeletionRequest_) Default() interface{} {
	return Companion_CancelKeyDeletionRequest_.Default()
}

func (_this type_CancelKeyDeletionRequest_) String() string {
	return "ComAmazonawsKmsTypes.CancelKeyDeletionRequest"
}
func (_this CancelKeyDeletionRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CancelKeyDeletionRequest{}

// End of datatype CancelKeyDeletionRequest

// Definition of datatype CancelKeyDeletionResponse
type CancelKeyDeletionResponse struct {
	Data_CancelKeyDeletionResponse_
}

func (_this CancelKeyDeletionResponse) Get_() Data_CancelKeyDeletionResponse_ {
	return _this.Data_CancelKeyDeletionResponse_
}

type Data_CancelKeyDeletionResponse_ interface {
	isCancelKeyDeletionResponse()
}

type CompanionStruct_CancelKeyDeletionResponse_ struct {
}

var Companion_CancelKeyDeletionResponse_ = CompanionStruct_CancelKeyDeletionResponse_{}

type CancelKeyDeletionResponse_CancelKeyDeletionResponse struct {
	KeyId m_Wrappers.Option
}

func (CancelKeyDeletionResponse_CancelKeyDeletionResponse) isCancelKeyDeletionResponse() {}

func (CompanionStruct_CancelKeyDeletionResponse_) Create_CancelKeyDeletionResponse_(KeyId m_Wrappers.Option) CancelKeyDeletionResponse {
	return CancelKeyDeletionResponse{CancelKeyDeletionResponse_CancelKeyDeletionResponse{KeyId}}
}

func (_this CancelKeyDeletionResponse) Is_CancelKeyDeletionResponse() bool {
	_, ok := _this.Get_().(CancelKeyDeletionResponse_CancelKeyDeletionResponse)
	return ok
}

func (CompanionStruct_CancelKeyDeletionResponse_) Default() CancelKeyDeletionResponse {
	return Companion_CancelKeyDeletionResponse_.Create_CancelKeyDeletionResponse_(m_Wrappers.Companion_Option_.Default())
}

func (_this CancelKeyDeletionResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(CancelKeyDeletionResponse_CancelKeyDeletionResponse).KeyId
}

func (_this CancelKeyDeletionResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CancelKeyDeletionResponse_CancelKeyDeletionResponse:
		{
			return "ComAmazonawsKmsTypes.CancelKeyDeletionResponse.CancelKeyDeletionResponse" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CancelKeyDeletionResponse) Equals(other CancelKeyDeletionResponse) bool {
	switch data1 := _this.Get_().(type) {
	case CancelKeyDeletionResponse_CancelKeyDeletionResponse:
		{
			data2, ok := other.Get_().(CancelKeyDeletionResponse_CancelKeyDeletionResponse)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CancelKeyDeletionResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CancelKeyDeletionResponse)
	return ok && _this.Equals(typed)
}

func Type_CancelKeyDeletionResponse_() _dafny.TypeDescriptor {
	return type_CancelKeyDeletionResponse_{}
}

type type_CancelKeyDeletionResponse_ struct {
}

func (_this type_CancelKeyDeletionResponse_) Default() interface{} {
	return Companion_CancelKeyDeletionResponse_.Default()
}

func (_this type_CancelKeyDeletionResponse_) String() string {
	return "ComAmazonawsKmsTypes.CancelKeyDeletionResponse"
}
func (_this CancelKeyDeletionResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CancelKeyDeletionResponse{}

// End of datatype CancelKeyDeletionResponse

// Definition of class CiphertextType
type CiphertextType struct {
}

func New_CiphertextType_() *CiphertextType {
	_this := CiphertextType{}

	return &_this
}

type CompanionStruct_CiphertextType_ struct {
}

var Companion_CiphertextType_ = CompanionStruct_CiphertextType_{}

func (*CiphertextType) String() string {
	return "ComAmazonawsKmsTypes.CiphertextType"
}

// End of class CiphertextType

func Type_CiphertextType_() _dafny.TypeDescriptor {
	return type_CiphertextType_{}
}

type type_CiphertextType_ struct {
}

func (_this type_CiphertextType_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_CiphertextType_) String() string {
	return "ComAmazonawsKmsTypes.CiphertextType"
}
func (_this *CompanionStruct_CiphertextType_) Is_(__source _dafny.Sequence) bool {
	var _3_x _dafny.Sequence = (__source)
	_ = _3_x
	return Companion_Default___.IsValid__CiphertextType(_3_x)
}

// Definition of class CloudHsmClusterIdType
type CloudHsmClusterIdType struct {
}

func New_CloudHsmClusterIdType_() *CloudHsmClusterIdType {
	_this := CloudHsmClusterIdType{}

	return &_this
}

type CompanionStruct_CloudHsmClusterIdType_ struct {
}

var Companion_CloudHsmClusterIdType_ = CompanionStruct_CloudHsmClusterIdType_{}

func (*CloudHsmClusterIdType) String() string {
	return "ComAmazonawsKmsTypes.CloudHsmClusterIdType"
}

// End of class CloudHsmClusterIdType

func Type_CloudHsmClusterIdType_() _dafny.TypeDescriptor {
	return type_CloudHsmClusterIdType_{}
}

type type_CloudHsmClusterIdType_ struct {
}

func (_this type_CloudHsmClusterIdType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_CloudHsmClusterIdType_) String() string {
	return "ComAmazonawsKmsTypes.CloudHsmClusterIdType"
}
func (_this *CompanionStruct_CloudHsmClusterIdType_) Is_(__source _dafny.Sequence) bool {
	var _4_x _dafny.Sequence = (__source)
	_ = _4_x
	return Companion_Default___.IsValid__CloudHsmClusterIdType(_4_x)
}

// Definition of datatype ConnectCustomKeyStoreRequest
type ConnectCustomKeyStoreRequest struct {
	Data_ConnectCustomKeyStoreRequest_
}

func (_this ConnectCustomKeyStoreRequest) Get_() Data_ConnectCustomKeyStoreRequest_ {
	return _this.Data_ConnectCustomKeyStoreRequest_
}

type Data_ConnectCustomKeyStoreRequest_ interface {
	isConnectCustomKeyStoreRequest()
}

type CompanionStruct_ConnectCustomKeyStoreRequest_ struct {
}

var Companion_ConnectCustomKeyStoreRequest_ = CompanionStruct_ConnectCustomKeyStoreRequest_{}

type ConnectCustomKeyStoreRequest_ConnectCustomKeyStoreRequest struct {
	CustomKeyStoreId _dafny.Sequence
}

func (ConnectCustomKeyStoreRequest_ConnectCustomKeyStoreRequest) isConnectCustomKeyStoreRequest() {}

func (CompanionStruct_ConnectCustomKeyStoreRequest_) Create_ConnectCustomKeyStoreRequest_(CustomKeyStoreId _dafny.Sequence) ConnectCustomKeyStoreRequest {
	return ConnectCustomKeyStoreRequest{ConnectCustomKeyStoreRequest_ConnectCustomKeyStoreRequest{CustomKeyStoreId}}
}

func (_this ConnectCustomKeyStoreRequest) Is_ConnectCustomKeyStoreRequest() bool {
	_, ok := _this.Get_().(ConnectCustomKeyStoreRequest_ConnectCustomKeyStoreRequest)
	return ok
}

func (CompanionStruct_ConnectCustomKeyStoreRequest_) Default() ConnectCustomKeyStoreRequest {
	return Companion_ConnectCustomKeyStoreRequest_.Create_ConnectCustomKeyStoreRequest_(_dafny.EmptySeq.SetString())
}

func (_this ConnectCustomKeyStoreRequest) Dtor_CustomKeyStoreId() _dafny.Sequence {
	return _this.Get_().(ConnectCustomKeyStoreRequest_ConnectCustomKeyStoreRequest).CustomKeyStoreId
}

func (_this ConnectCustomKeyStoreRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ConnectCustomKeyStoreRequest_ConnectCustomKeyStoreRequest:
		{
			return "ComAmazonawsKmsTypes.ConnectCustomKeyStoreRequest.ConnectCustomKeyStoreRequest" + "(" + _dafny.String(data.CustomKeyStoreId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ConnectCustomKeyStoreRequest) Equals(other ConnectCustomKeyStoreRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ConnectCustomKeyStoreRequest_ConnectCustomKeyStoreRequest:
		{
			data2, ok := other.Get_().(ConnectCustomKeyStoreRequest_ConnectCustomKeyStoreRequest)
			return ok && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ConnectCustomKeyStoreRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ConnectCustomKeyStoreRequest)
	return ok && _this.Equals(typed)
}

func Type_ConnectCustomKeyStoreRequest_() _dafny.TypeDescriptor {
	return type_ConnectCustomKeyStoreRequest_{}
}

type type_ConnectCustomKeyStoreRequest_ struct {
}

func (_this type_ConnectCustomKeyStoreRequest_) Default() interface{} {
	return Companion_ConnectCustomKeyStoreRequest_.Default()
}

func (_this type_ConnectCustomKeyStoreRequest_) String() string {
	return "ComAmazonawsKmsTypes.ConnectCustomKeyStoreRequest"
}
func (_this ConnectCustomKeyStoreRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ConnectCustomKeyStoreRequest{}

// End of datatype ConnectCustomKeyStoreRequest

// Definition of datatype ConnectCustomKeyStoreResponse
type ConnectCustomKeyStoreResponse struct {
	Data_ConnectCustomKeyStoreResponse_
}

func (_this ConnectCustomKeyStoreResponse) Get_() Data_ConnectCustomKeyStoreResponse_ {
	return _this.Data_ConnectCustomKeyStoreResponse_
}

type Data_ConnectCustomKeyStoreResponse_ interface {
	isConnectCustomKeyStoreResponse()
}

type CompanionStruct_ConnectCustomKeyStoreResponse_ struct {
}

var Companion_ConnectCustomKeyStoreResponse_ = CompanionStruct_ConnectCustomKeyStoreResponse_{}

type ConnectCustomKeyStoreResponse_ConnectCustomKeyStoreResponse struct {
}

func (ConnectCustomKeyStoreResponse_ConnectCustomKeyStoreResponse) isConnectCustomKeyStoreResponse() {
}

func (CompanionStruct_ConnectCustomKeyStoreResponse_) Create_ConnectCustomKeyStoreResponse_() ConnectCustomKeyStoreResponse {
	return ConnectCustomKeyStoreResponse{ConnectCustomKeyStoreResponse_ConnectCustomKeyStoreResponse{}}
}

func (_this ConnectCustomKeyStoreResponse) Is_ConnectCustomKeyStoreResponse() bool {
	_, ok := _this.Get_().(ConnectCustomKeyStoreResponse_ConnectCustomKeyStoreResponse)
	return ok
}

func (CompanionStruct_ConnectCustomKeyStoreResponse_) Default() ConnectCustomKeyStoreResponse {
	return Companion_ConnectCustomKeyStoreResponse_.Create_ConnectCustomKeyStoreResponse_()
}

func (_ CompanionStruct_ConnectCustomKeyStoreResponse_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ConnectCustomKeyStoreResponse_.Create_ConnectCustomKeyStoreResponse_(), true
		default:
			return ConnectCustomKeyStoreResponse{}, false
		}
	}
}

func (_this ConnectCustomKeyStoreResponse) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ConnectCustomKeyStoreResponse_ConnectCustomKeyStoreResponse:
		{
			return "ComAmazonawsKmsTypes.ConnectCustomKeyStoreResponse.ConnectCustomKeyStoreResponse"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ConnectCustomKeyStoreResponse) Equals(other ConnectCustomKeyStoreResponse) bool {
	switch _this.Get_().(type) {
	case ConnectCustomKeyStoreResponse_ConnectCustomKeyStoreResponse:
		{
			_, ok := other.Get_().(ConnectCustomKeyStoreResponse_ConnectCustomKeyStoreResponse)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ConnectCustomKeyStoreResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ConnectCustomKeyStoreResponse)
	return ok && _this.Equals(typed)
}

func Type_ConnectCustomKeyStoreResponse_() _dafny.TypeDescriptor {
	return type_ConnectCustomKeyStoreResponse_{}
}

type type_ConnectCustomKeyStoreResponse_ struct {
}

func (_this type_ConnectCustomKeyStoreResponse_) Default() interface{} {
	return Companion_ConnectCustomKeyStoreResponse_.Default()
}

func (_this type_ConnectCustomKeyStoreResponse_) String() string {
	return "ComAmazonawsKmsTypes.ConnectCustomKeyStoreResponse"
}
func (_this ConnectCustomKeyStoreResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ConnectCustomKeyStoreResponse{}

// End of datatype ConnectCustomKeyStoreResponse

// Definition of datatype ConnectionErrorCodeType
type ConnectionErrorCodeType struct {
	Data_ConnectionErrorCodeType_
}

func (_this ConnectionErrorCodeType) Get_() Data_ConnectionErrorCodeType_ {
	return _this.Data_ConnectionErrorCodeType_
}

type Data_ConnectionErrorCodeType_ interface {
	isConnectionErrorCodeType()
}

type CompanionStruct_ConnectionErrorCodeType_ struct {
}

var Companion_ConnectionErrorCodeType_ = CompanionStruct_ConnectionErrorCodeType_{}

type ConnectionErrorCodeType_INVALID__CREDENTIALS struct {
}

func (ConnectionErrorCodeType_INVALID__CREDENTIALS) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_INVALID__CREDENTIALS_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_INVALID__CREDENTIALS{}}
}

func (_this ConnectionErrorCodeType) Is_INVALID__CREDENTIALS() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_INVALID__CREDENTIALS)
	return ok
}

type ConnectionErrorCodeType_CLUSTER__NOT__FOUND struct {
}

func (ConnectionErrorCodeType_CLUSTER__NOT__FOUND) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_CLUSTER__NOT__FOUND_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_CLUSTER__NOT__FOUND{}}
}

func (_this ConnectionErrorCodeType) Is_CLUSTER__NOT__FOUND() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_CLUSTER__NOT__FOUND)
	return ok
}

type ConnectionErrorCodeType_NETWORK__ERRORS struct {
}

func (ConnectionErrorCodeType_NETWORK__ERRORS) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_NETWORK__ERRORS_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_NETWORK__ERRORS{}}
}

func (_this ConnectionErrorCodeType) Is_NETWORK__ERRORS() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_NETWORK__ERRORS)
	return ok
}

type ConnectionErrorCodeType_INTERNAL__ERROR struct {
}

func (ConnectionErrorCodeType_INTERNAL__ERROR) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_INTERNAL__ERROR_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_INTERNAL__ERROR{}}
}

func (_this ConnectionErrorCodeType) Is_INTERNAL__ERROR() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_INTERNAL__ERROR)
	return ok
}

type ConnectionErrorCodeType_INSUFFICIENT__CLOUDHSM__HSMS struct {
}

func (ConnectionErrorCodeType_INSUFFICIENT__CLOUDHSM__HSMS) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_INSUFFICIENT__CLOUDHSM__HSMS_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_INSUFFICIENT__CLOUDHSM__HSMS{}}
}

func (_this ConnectionErrorCodeType) Is_INSUFFICIENT__CLOUDHSM__HSMS() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_INSUFFICIENT__CLOUDHSM__HSMS)
	return ok
}

type ConnectionErrorCodeType_USER__LOCKED__OUT struct {
}

func (ConnectionErrorCodeType_USER__LOCKED__OUT) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_USER__LOCKED__OUT_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_USER__LOCKED__OUT{}}
}

func (_this ConnectionErrorCodeType) Is_USER__LOCKED__OUT() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_USER__LOCKED__OUT)
	return ok
}

type ConnectionErrorCodeType_USER__NOT__FOUND struct {
}

func (ConnectionErrorCodeType_USER__NOT__FOUND) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_USER__NOT__FOUND_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_USER__NOT__FOUND{}}
}

func (_this ConnectionErrorCodeType) Is_USER__NOT__FOUND() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_USER__NOT__FOUND)
	return ok
}

type ConnectionErrorCodeType_USER__LOGGED__IN struct {
}

func (ConnectionErrorCodeType_USER__LOGGED__IN) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_USER__LOGGED__IN_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_USER__LOGGED__IN{}}
}

func (_this ConnectionErrorCodeType) Is_USER__LOGGED__IN() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_USER__LOGGED__IN)
	return ok
}

type ConnectionErrorCodeType_SUBNET__NOT__FOUND struct {
}

func (ConnectionErrorCodeType_SUBNET__NOT__FOUND) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_SUBNET__NOT__FOUND_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_SUBNET__NOT__FOUND{}}
}

func (_this ConnectionErrorCodeType) Is_SUBNET__NOT__FOUND() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_SUBNET__NOT__FOUND)
	return ok
}

type ConnectionErrorCodeType_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET struct {
}

func (ConnectionErrorCodeType_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET) isConnectionErrorCodeType() {
}

func (CompanionStruct_ConnectionErrorCodeType_) Create_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET{}}
}

func (_this ConnectionErrorCodeType) Is_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET)
	return ok
}

type ConnectionErrorCodeType_XKS__PROXY__ACCESS__DENIED struct {
}

func (ConnectionErrorCodeType_XKS__PROXY__ACCESS__DENIED) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_XKS__PROXY__ACCESS__DENIED_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_XKS__PROXY__ACCESS__DENIED{}}
}

func (_this ConnectionErrorCodeType) Is_XKS__PROXY__ACCESS__DENIED() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_XKS__PROXY__ACCESS__DENIED)
	return ok
}

type ConnectionErrorCodeType_XKS__PROXY__NOT__REACHABLE struct {
}

func (ConnectionErrorCodeType_XKS__PROXY__NOT__REACHABLE) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_XKS__PROXY__NOT__REACHABLE_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_XKS__PROXY__NOT__REACHABLE{}}
}

func (_this ConnectionErrorCodeType) Is_XKS__PROXY__NOT__REACHABLE() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_XKS__PROXY__NOT__REACHABLE)
	return ok
}

type ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND struct {
}

func (ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND{}}
}

func (_this ConnectionErrorCodeType) Is_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND)
	return ok
}

type ConnectionErrorCodeType_XKS__PROXY__INVALID__RESPONSE struct {
}

func (ConnectionErrorCodeType_XKS__PROXY__INVALID__RESPONSE) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_XKS__PROXY__INVALID__RESPONSE_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_XKS__PROXY__INVALID__RESPONSE{}}
}

func (_this ConnectionErrorCodeType) Is_XKS__PROXY__INVALID__RESPONSE() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_XKS__PROXY__INVALID__RESPONSE)
	return ok
}

type ConnectionErrorCodeType_XKS__PROXY__INVALID__CONFIGURATION struct {
}

func (ConnectionErrorCodeType_XKS__PROXY__INVALID__CONFIGURATION) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_XKS__PROXY__INVALID__CONFIGURATION_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_XKS__PROXY__INVALID__CONFIGURATION{}}
}

func (_this ConnectionErrorCodeType) Is_XKS__PROXY__INVALID__CONFIGURATION() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_XKS__PROXY__INVALID__CONFIGURATION)
	return ok
}

type ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION struct {
}

func (ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION) isConnectionErrorCodeType() {
}

func (CompanionStruct_ConnectionErrorCodeType_) Create_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION{}}
}

func (_this ConnectionErrorCodeType) Is_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION)
	return ok
}

type ConnectionErrorCodeType_XKS__PROXY__TIMED__OUT struct {
}

func (ConnectionErrorCodeType_XKS__PROXY__TIMED__OUT) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_XKS__PROXY__TIMED__OUT_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_XKS__PROXY__TIMED__OUT{}}
}

func (_this ConnectionErrorCodeType) Is_XKS__PROXY__TIMED__OUT() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_XKS__PROXY__TIMED__OUT)
	return ok
}

type ConnectionErrorCodeType_XKS__PROXY__INVALID__TLS__CONFIGURATION struct {
}

func (ConnectionErrorCodeType_XKS__PROXY__INVALID__TLS__CONFIGURATION) isConnectionErrorCodeType() {}

func (CompanionStruct_ConnectionErrorCodeType_) Create_XKS__PROXY__INVALID__TLS__CONFIGURATION_() ConnectionErrorCodeType {
	return ConnectionErrorCodeType{ConnectionErrorCodeType_XKS__PROXY__INVALID__TLS__CONFIGURATION{}}
}

func (_this ConnectionErrorCodeType) Is_XKS__PROXY__INVALID__TLS__CONFIGURATION() bool {
	_, ok := _this.Get_().(ConnectionErrorCodeType_XKS__PROXY__INVALID__TLS__CONFIGURATION)
	return ok
}

func (CompanionStruct_ConnectionErrorCodeType_) Default() ConnectionErrorCodeType {
	return Companion_ConnectionErrorCodeType_.Create_INVALID__CREDENTIALS_()
}

func (_ CompanionStruct_ConnectionErrorCodeType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ConnectionErrorCodeType_.Create_INVALID__CREDENTIALS_(), true
		case 1:
			return Companion_ConnectionErrorCodeType_.Create_CLUSTER__NOT__FOUND_(), true
		case 2:
			return Companion_ConnectionErrorCodeType_.Create_NETWORK__ERRORS_(), true
		case 3:
			return Companion_ConnectionErrorCodeType_.Create_INTERNAL__ERROR_(), true
		case 4:
			return Companion_ConnectionErrorCodeType_.Create_INSUFFICIENT__CLOUDHSM__HSMS_(), true
		case 5:
			return Companion_ConnectionErrorCodeType_.Create_USER__LOCKED__OUT_(), true
		case 6:
			return Companion_ConnectionErrorCodeType_.Create_USER__NOT__FOUND_(), true
		case 7:
			return Companion_ConnectionErrorCodeType_.Create_USER__LOGGED__IN_(), true
		case 8:
			return Companion_ConnectionErrorCodeType_.Create_SUBNET__NOT__FOUND_(), true
		case 9:
			return Companion_ConnectionErrorCodeType_.Create_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET_(), true
		case 10:
			return Companion_ConnectionErrorCodeType_.Create_XKS__PROXY__ACCESS__DENIED_(), true
		case 11:
			return Companion_ConnectionErrorCodeType_.Create_XKS__PROXY__NOT__REACHABLE_(), true
		case 12:
			return Companion_ConnectionErrorCodeType_.Create_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND_(), true
		case 13:
			return Companion_ConnectionErrorCodeType_.Create_XKS__PROXY__INVALID__RESPONSE_(), true
		case 14:
			return Companion_ConnectionErrorCodeType_.Create_XKS__PROXY__INVALID__CONFIGURATION_(), true
		case 15:
			return Companion_ConnectionErrorCodeType_.Create_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION_(), true
		case 16:
			return Companion_ConnectionErrorCodeType_.Create_XKS__PROXY__TIMED__OUT_(), true
		case 17:
			return Companion_ConnectionErrorCodeType_.Create_XKS__PROXY__INVALID__TLS__CONFIGURATION_(), true
		default:
			return ConnectionErrorCodeType{}, false
		}
	}
}

func (_this ConnectionErrorCodeType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ConnectionErrorCodeType_INVALID__CREDENTIALS:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.INVALID_CREDENTIALS"
		}
	case ConnectionErrorCodeType_CLUSTER__NOT__FOUND:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.CLUSTER_NOT_FOUND"
		}
	case ConnectionErrorCodeType_NETWORK__ERRORS:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.NETWORK_ERRORS"
		}
	case ConnectionErrorCodeType_INTERNAL__ERROR:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.INTERNAL_ERROR"
		}
	case ConnectionErrorCodeType_INSUFFICIENT__CLOUDHSM__HSMS:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.INSUFFICIENT_CLOUDHSM_HSMS"
		}
	case ConnectionErrorCodeType_USER__LOCKED__OUT:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.USER_LOCKED_OUT"
		}
	case ConnectionErrorCodeType_USER__NOT__FOUND:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.USER_NOT_FOUND"
		}
	case ConnectionErrorCodeType_USER__LOGGED__IN:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.USER_LOGGED_IN"
		}
	case ConnectionErrorCodeType_SUBNET__NOT__FOUND:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.SUBNET_NOT_FOUND"
		}
	case ConnectionErrorCodeType_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET"
		}
	case ConnectionErrorCodeType_XKS__PROXY__ACCESS__DENIED:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.XKS_PROXY_ACCESS_DENIED"
		}
	case ConnectionErrorCodeType_XKS__PROXY__NOT__REACHABLE:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.XKS_PROXY_NOT_REACHABLE"
		}
	case ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND"
		}
	case ConnectionErrorCodeType_XKS__PROXY__INVALID__RESPONSE:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.XKS_PROXY_INVALID_RESPONSE"
		}
	case ConnectionErrorCodeType_XKS__PROXY__INVALID__CONFIGURATION:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.XKS_PROXY_INVALID_CONFIGURATION"
		}
	case ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION"
		}
	case ConnectionErrorCodeType_XKS__PROXY__TIMED__OUT:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.XKS_PROXY_TIMED_OUT"
		}
	case ConnectionErrorCodeType_XKS__PROXY__INVALID__TLS__CONFIGURATION:
		{
			return "ComAmazonawsKmsTypes.ConnectionErrorCodeType.XKS_PROXY_INVALID_TLS_CONFIGURATION"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ConnectionErrorCodeType) Equals(other ConnectionErrorCodeType) bool {
	switch _this.Get_().(type) {
	case ConnectionErrorCodeType_INVALID__CREDENTIALS:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_INVALID__CREDENTIALS)
			return ok
		}
	case ConnectionErrorCodeType_CLUSTER__NOT__FOUND:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_CLUSTER__NOT__FOUND)
			return ok
		}
	case ConnectionErrorCodeType_NETWORK__ERRORS:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_NETWORK__ERRORS)
			return ok
		}
	case ConnectionErrorCodeType_INTERNAL__ERROR:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_INTERNAL__ERROR)
			return ok
		}
	case ConnectionErrorCodeType_INSUFFICIENT__CLOUDHSM__HSMS:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_INSUFFICIENT__CLOUDHSM__HSMS)
			return ok
		}
	case ConnectionErrorCodeType_USER__LOCKED__OUT:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_USER__LOCKED__OUT)
			return ok
		}
	case ConnectionErrorCodeType_USER__NOT__FOUND:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_USER__NOT__FOUND)
			return ok
		}
	case ConnectionErrorCodeType_USER__LOGGED__IN:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_USER__LOGGED__IN)
			return ok
		}
	case ConnectionErrorCodeType_SUBNET__NOT__FOUND:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_SUBNET__NOT__FOUND)
			return ok
		}
	case ConnectionErrorCodeType_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_INSUFFICIENT__FREE__ADDRESSES__IN__SUBNET)
			return ok
		}
	case ConnectionErrorCodeType_XKS__PROXY__ACCESS__DENIED:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_XKS__PROXY__ACCESS__DENIED)
			return ok
		}
	case ConnectionErrorCodeType_XKS__PROXY__NOT__REACHABLE:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_XKS__PROXY__NOT__REACHABLE)
			return ok
		}
	case ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__NOT__FOUND)
			return ok
		}
	case ConnectionErrorCodeType_XKS__PROXY__INVALID__RESPONSE:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_XKS__PROXY__INVALID__RESPONSE)
			return ok
		}
	case ConnectionErrorCodeType_XKS__PROXY__INVALID__CONFIGURATION:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_XKS__PROXY__INVALID__CONFIGURATION)
			return ok
		}
	case ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_XKS__VPC__ENDPOINT__SERVICE__INVALID__CONFIGURATION)
			return ok
		}
	case ConnectionErrorCodeType_XKS__PROXY__TIMED__OUT:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_XKS__PROXY__TIMED__OUT)
			return ok
		}
	case ConnectionErrorCodeType_XKS__PROXY__INVALID__TLS__CONFIGURATION:
		{
			_, ok := other.Get_().(ConnectionErrorCodeType_XKS__PROXY__INVALID__TLS__CONFIGURATION)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ConnectionErrorCodeType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ConnectionErrorCodeType)
	return ok && _this.Equals(typed)
}

func Type_ConnectionErrorCodeType_() _dafny.TypeDescriptor {
	return type_ConnectionErrorCodeType_{}
}

type type_ConnectionErrorCodeType_ struct {
}

func (_this type_ConnectionErrorCodeType_) Default() interface{} {
	return Companion_ConnectionErrorCodeType_.Default()
}

func (_this type_ConnectionErrorCodeType_) String() string {
	return "ComAmazonawsKmsTypes.ConnectionErrorCodeType"
}
func (_this ConnectionErrorCodeType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ConnectionErrorCodeType{}

// End of datatype ConnectionErrorCodeType

// Definition of datatype ConnectionStateType
type ConnectionStateType struct {
	Data_ConnectionStateType_
}

func (_this ConnectionStateType) Get_() Data_ConnectionStateType_ {
	return _this.Data_ConnectionStateType_
}

type Data_ConnectionStateType_ interface {
	isConnectionStateType()
}

type CompanionStruct_ConnectionStateType_ struct {
}

var Companion_ConnectionStateType_ = CompanionStruct_ConnectionStateType_{}

type ConnectionStateType_CONNECTED struct {
}

func (ConnectionStateType_CONNECTED) isConnectionStateType() {}

func (CompanionStruct_ConnectionStateType_) Create_CONNECTED_() ConnectionStateType {
	return ConnectionStateType{ConnectionStateType_CONNECTED{}}
}

func (_this ConnectionStateType) Is_CONNECTED() bool {
	_, ok := _this.Get_().(ConnectionStateType_CONNECTED)
	return ok
}

type ConnectionStateType_CONNECTING struct {
}

func (ConnectionStateType_CONNECTING) isConnectionStateType() {}

func (CompanionStruct_ConnectionStateType_) Create_CONNECTING_() ConnectionStateType {
	return ConnectionStateType{ConnectionStateType_CONNECTING{}}
}

func (_this ConnectionStateType) Is_CONNECTING() bool {
	_, ok := _this.Get_().(ConnectionStateType_CONNECTING)
	return ok
}

type ConnectionStateType_FAILED struct {
}

func (ConnectionStateType_FAILED) isConnectionStateType() {}

func (CompanionStruct_ConnectionStateType_) Create_FAILED_() ConnectionStateType {
	return ConnectionStateType{ConnectionStateType_FAILED{}}
}

func (_this ConnectionStateType) Is_FAILED() bool {
	_, ok := _this.Get_().(ConnectionStateType_FAILED)
	return ok
}

type ConnectionStateType_DISCONNECTED struct {
}

func (ConnectionStateType_DISCONNECTED) isConnectionStateType() {}

func (CompanionStruct_ConnectionStateType_) Create_DISCONNECTED_() ConnectionStateType {
	return ConnectionStateType{ConnectionStateType_DISCONNECTED{}}
}

func (_this ConnectionStateType) Is_DISCONNECTED() bool {
	_, ok := _this.Get_().(ConnectionStateType_DISCONNECTED)
	return ok
}

type ConnectionStateType_DISCONNECTING struct {
}

func (ConnectionStateType_DISCONNECTING) isConnectionStateType() {}

func (CompanionStruct_ConnectionStateType_) Create_DISCONNECTING_() ConnectionStateType {
	return ConnectionStateType{ConnectionStateType_DISCONNECTING{}}
}

func (_this ConnectionStateType) Is_DISCONNECTING() bool {
	_, ok := _this.Get_().(ConnectionStateType_DISCONNECTING)
	return ok
}

func (CompanionStruct_ConnectionStateType_) Default() ConnectionStateType {
	return Companion_ConnectionStateType_.Create_CONNECTED_()
}

func (_ CompanionStruct_ConnectionStateType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ConnectionStateType_.Create_CONNECTED_(), true
		case 1:
			return Companion_ConnectionStateType_.Create_CONNECTING_(), true
		case 2:
			return Companion_ConnectionStateType_.Create_FAILED_(), true
		case 3:
			return Companion_ConnectionStateType_.Create_DISCONNECTED_(), true
		case 4:
			return Companion_ConnectionStateType_.Create_DISCONNECTING_(), true
		default:
			return ConnectionStateType{}, false
		}
	}
}

func (_this ConnectionStateType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ConnectionStateType_CONNECTED:
		{
			return "ComAmazonawsKmsTypes.ConnectionStateType.CONNECTED"
		}
	case ConnectionStateType_CONNECTING:
		{
			return "ComAmazonawsKmsTypes.ConnectionStateType.CONNECTING"
		}
	case ConnectionStateType_FAILED:
		{
			return "ComAmazonawsKmsTypes.ConnectionStateType.FAILED"
		}
	case ConnectionStateType_DISCONNECTED:
		{
			return "ComAmazonawsKmsTypes.ConnectionStateType.DISCONNECTED"
		}
	case ConnectionStateType_DISCONNECTING:
		{
			return "ComAmazonawsKmsTypes.ConnectionStateType.DISCONNECTING"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ConnectionStateType) Equals(other ConnectionStateType) bool {
	switch _this.Get_().(type) {
	case ConnectionStateType_CONNECTED:
		{
			_, ok := other.Get_().(ConnectionStateType_CONNECTED)
			return ok
		}
	case ConnectionStateType_CONNECTING:
		{
			_, ok := other.Get_().(ConnectionStateType_CONNECTING)
			return ok
		}
	case ConnectionStateType_FAILED:
		{
			_, ok := other.Get_().(ConnectionStateType_FAILED)
			return ok
		}
	case ConnectionStateType_DISCONNECTED:
		{
			_, ok := other.Get_().(ConnectionStateType_DISCONNECTED)
			return ok
		}
	case ConnectionStateType_DISCONNECTING:
		{
			_, ok := other.Get_().(ConnectionStateType_DISCONNECTING)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ConnectionStateType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ConnectionStateType)
	return ok && _this.Equals(typed)
}

func Type_ConnectionStateType_() _dafny.TypeDescriptor {
	return type_ConnectionStateType_{}
}

type type_ConnectionStateType_ struct {
}

func (_this type_ConnectionStateType_) Default() interface{} {
	return Companion_ConnectionStateType_.Default()
}

func (_this type_ConnectionStateType_) String() string {
	return "ComAmazonawsKmsTypes.ConnectionStateType"
}
func (_this ConnectionStateType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ConnectionStateType{}

// End of datatype ConnectionStateType

// Definition of datatype CreateAliasRequest
type CreateAliasRequest struct {
	Data_CreateAliasRequest_
}

func (_this CreateAliasRequest) Get_() Data_CreateAliasRequest_ {
	return _this.Data_CreateAliasRequest_
}

type Data_CreateAliasRequest_ interface {
	isCreateAliasRequest()
}

type CompanionStruct_CreateAliasRequest_ struct {
}

var Companion_CreateAliasRequest_ = CompanionStruct_CreateAliasRequest_{}

type CreateAliasRequest_CreateAliasRequest struct {
	AliasName   _dafny.Sequence
	TargetKeyId _dafny.Sequence
}

func (CreateAliasRequest_CreateAliasRequest) isCreateAliasRequest() {}

func (CompanionStruct_CreateAliasRequest_) Create_CreateAliasRequest_(AliasName _dafny.Sequence, TargetKeyId _dafny.Sequence) CreateAliasRequest {
	return CreateAliasRequest{CreateAliasRequest_CreateAliasRequest{AliasName, TargetKeyId}}
}

func (_this CreateAliasRequest) Is_CreateAliasRequest() bool {
	_, ok := _this.Get_().(CreateAliasRequest_CreateAliasRequest)
	return ok
}

func (CompanionStruct_CreateAliasRequest_) Default() CreateAliasRequest {
	return Companion_CreateAliasRequest_.Create_CreateAliasRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this CreateAliasRequest) Dtor_AliasName() _dafny.Sequence {
	return _this.Get_().(CreateAliasRequest_CreateAliasRequest).AliasName
}

func (_this CreateAliasRequest) Dtor_TargetKeyId() _dafny.Sequence {
	return _this.Get_().(CreateAliasRequest_CreateAliasRequest).TargetKeyId
}

func (_this CreateAliasRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateAliasRequest_CreateAliasRequest:
		{
			return "ComAmazonawsKmsTypes.CreateAliasRequest.CreateAliasRequest" + "(" + _dafny.String(data.AliasName) + ", " + _dafny.String(data.TargetKeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateAliasRequest) Equals(other CreateAliasRequest) bool {
	switch data1 := _this.Get_().(type) {
	case CreateAliasRequest_CreateAliasRequest:
		{
			data2, ok := other.Get_().(CreateAliasRequest_CreateAliasRequest)
			return ok && data1.AliasName.Equals(data2.AliasName) && data1.TargetKeyId.Equals(data2.TargetKeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateAliasRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateAliasRequest)
	return ok && _this.Equals(typed)
}

func Type_CreateAliasRequest_() _dafny.TypeDescriptor {
	return type_CreateAliasRequest_{}
}

type type_CreateAliasRequest_ struct {
}

func (_this type_CreateAliasRequest_) Default() interface{} {
	return Companion_CreateAliasRequest_.Default()
}

func (_this type_CreateAliasRequest_) String() string {
	return "ComAmazonawsKmsTypes.CreateAliasRequest"
}
func (_this CreateAliasRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateAliasRequest{}

// End of datatype CreateAliasRequest

// Definition of datatype CreateCustomKeyStoreRequest
type CreateCustomKeyStoreRequest struct {
	Data_CreateCustomKeyStoreRequest_
}

func (_this CreateCustomKeyStoreRequest) Get_() Data_CreateCustomKeyStoreRequest_ {
	return _this.Data_CreateCustomKeyStoreRequest_
}

type Data_CreateCustomKeyStoreRequest_ interface {
	isCreateCustomKeyStoreRequest()
}

type CompanionStruct_CreateCustomKeyStoreRequest_ struct {
}

var Companion_CreateCustomKeyStoreRequest_ = CompanionStruct_CreateCustomKeyStoreRequest_{}

type CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest struct {
	CustomKeyStoreName               _dafny.Sequence
	CloudHsmClusterId                m_Wrappers.Option
	TrustAnchorCertificate           m_Wrappers.Option
	KeyStorePassword                 m_Wrappers.Option
	CustomKeyStoreType               m_Wrappers.Option
	XksProxyUriEndpoint              m_Wrappers.Option
	XksProxyUriPath                  m_Wrappers.Option
	XksProxyVpcEndpointServiceName   m_Wrappers.Option
	XksProxyAuthenticationCredential m_Wrappers.Option
	XksProxyConnectivity             m_Wrappers.Option
}

func (CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest) isCreateCustomKeyStoreRequest() {}

func (CompanionStruct_CreateCustomKeyStoreRequest_) Create_CreateCustomKeyStoreRequest_(CustomKeyStoreName _dafny.Sequence, CloudHsmClusterId m_Wrappers.Option, TrustAnchorCertificate m_Wrappers.Option, KeyStorePassword m_Wrappers.Option, CustomKeyStoreType m_Wrappers.Option, XksProxyUriEndpoint m_Wrappers.Option, XksProxyUriPath m_Wrappers.Option, XksProxyVpcEndpointServiceName m_Wrappers.Option, XksProxyAuthenticationCredential m_Wrappers.Option, XksProxyConnectivity m_Wrappers.Option) CreateCustomKeyStoreRequest {
	return CreateCustomKeyStoreRequest{CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest{CustomKeyStoreName, CloudHsmClusterId, TrustAnchorCertificate, KeyStorePassword, CustomKeyStoreType, XksProxyUriEndpoint, XksProxyUriPath, XksProxyVpcEndpointServiceName, XksProxyAuthenticationCredential, XksProxyConnectivity}}
}

func (_this CreateCustomKeyStoreRequest) Is_CreateCustomKeyStoreRequest() bool {
	_, ok := _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest)
	return ok
}

func (CompanionStruct_CreateCustomKeyStoreRequest_) Default() CreateCustomKeyStoreRequest {
	return Companion_CreateCustomKeyStoreRequest_.Create_CreateCustomKeyStoreRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateCustomKeyStoreRequest) Dtor_CustomKeyStoreName() _dafny.Sequence {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).CustomKeyStoreName
}

func (_this CreateCustomKeyStoreRequest) Dtor_CloudHsmClusterId() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).CloudHsmClusterId
}

func (_this CreateCustomKeyStoreRequest) Dtor_TrustAnchorCertificate() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).TrustAnchorCertificate
}

func (_this CreateCustomKeyStoreRequest) Dtor_KeyStorePassword() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).KeyStorePassword
}

func (_this CreateCustomKeyStoreRequest) Dtor_CustomKeyStoreType() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).CustomKeyStoreType
}

func (_this CreateCustomKeyStoreRequest) Dtor_XksProxyUriEndpoint() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).XksProxyUriEndpoint
}

func (_this CreateCustomKeyStoreRequest) Dtor_XksProxyUriPath() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).XksProxyUriPath
}

func (_this CreateCustomKeyStoreRequest) Dtor_XksProxyVpcEndpointServiceName() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).XksProxyVpcEndpointServiceName
}

func (_this CreateCustomKeyStoreRequest) Dtor_XksProxyAuthenticationCredential() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).XksProxyAuthenticationCredential
}

func (_this CreateCustomKeyStoreRequest) Dtor_XksProxyConnectivity() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest).XksProxyConnectivity
}

func (_this CreateCustomKeyStoreRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest:
		{
			return "ComAmazonawsKmsTypes.CreateCustomKeyStoreRequest.CreateCustomKeyStoreRequest" + "(" + _dafny.String(data.CustomKeyStoreName) + ", " + _dafny.String(data.CloudHsmClusterId) + ", " + _dafny.String(data.TrustAnchorCertificate) + ", " + _dafny.String(data.KeyStorePassword) + ", " + _dafny.String(data.CustomKeyStoreType) + ", " + _dafny.String(data.XksProxyUriEndpoint) + ", " + _dafny.String(data.XksProxyUriPath) + ", " + _dafny.String(data.XksProxyVpcEndpointServiceName) + ", " + _dafny.String(data.XksProxyAuthenticationCredential) + ", " + _dafny.String(data.XksProxyConnectivity) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateCustomKeyStoreRequest) Equals(other CreateCustomKeyStoreRequest) bool {
	switch data1 := _this.Get_().(type) {
	case CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest:
		{
			data2, ok := other.Get_().(CreateCustomKeyStoreRequest_CreateCustomKeyStoreRequest)
			return ok && data1.CustomKeyStoreName.Equals(data2.CustomKeyStoreName) && data1.CloudHsmClusterId.Equals(data2.CloudHsmClusterId) && data1.TrustAnchorCertificate.Equals(data2.TrustAnchorCertificate) && data1.KeyStorePassword.Equals(data2.KeyStorePassword) && data1.CustomKeyStoreType.Equals(data2.CustomKeyStoreType) && data1.XksProxyUriEndpoint.Equals(data2.XksProxyUriEndpoint) && data1.XksProxyUriPath.Equals(data2.XksProxyUriPath) && data1.XksProxyVpcEndpointServiceName.Equals(data2.XksProxyVpcEndpointServiceName) && data1.XksProxyAuthenticationCredential.Equals(data2.XksProxyAuthenticationCredential) && data1.XksProxyConnectivity.Equals(data2.XksProxyConnectivity)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateCustomKeyStoreRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateCustomKeyStoreRequest)
	return ok && _this.Equals(typed)
}

func Type_CreateCustomKeyStoreRequest_() _dafny.TypeDescriptor {
	return type_CreateCustomKeyStoreRequest_{}
}

type type_CreateCustomKeyStoreRequest_ struct {
}

func (_this type_CreateCustomKeyStoreRequest_) Default() interface{} {
	return Companion_CreateCustomKeyStoreRequest_.Default()
}

func (_this type_CreateCustomKeyStoreRequest_) String() string {
	return "ComAmazonawsKmsTypes.CreateCustomKeyStoreRequest"
}
func (_this CreateCustomKeyStoreRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateCustomKeyStoreRequest{}

// End of datatype CreateCustomKeyStoreRequest

// Definition of datatype CreateCustomKeyStoreResponse
type CreateCustomKeyStoreResponse struct {
	Data_CreateCustomKeyStoreResponse_
}

func (_this CreateCustomKeyStoreResponse) Get_() Data_CreateCustomKeyStoreResponse_ {
	return _this.Data_CreateCustomKeyStoreResponse_
}

type Data_CreateCustomKeyStoreResponse_ interface {
	isCreateCustomKeyStoreResponse()
}

type CompanionStruct_CreateCustomKeyStoreResponse_ struct {
}

var Companion_CreateCustomKeyStoreResponse_ = CompanionStruct_CreateCustomKeyStoreResponse_{}

type CreateCustomKeyStoreResponse_CreateCustomKeyStoreResponse struct {
	CustomKeyStoreId m_Wrappers.Option
}

func (CreateCustomKeyStoreResponse_CreateCustomKeyStoreResponse) isCreateCustomKeyStoreResponse() {}

func (CompanionStruct_CreateCustomKeyStoreResponse_) Create_CreateCustomKeyStoreResponse_(CustomKeyStoreId m_Wrappers.Option) CreateCustomKeyStoreResponse {
	return CreateCustomKeyStoreResponse{CreateCustomKeyStoreResponse_CreateCustomKeyStoreResponse{CustomKeyStoreId}}
}

func (_this CreateCustomKeyStoreResponse) Is_CreateCustomKeyStoreResponse() bool {
	_, ok := _this.Get_().(CreateCustomKeyStoreResponse_CreateCustomKeyStoreResponse)
	return ok
}

func (CompanionStruct_CreateCustomKeyStoreResponse_) Default() CreateCustomKeyStoreResponse {
	return Companion_CreateCustomKeyStoreResponse_.Create_CreateCustomKeyStoreResponse_(m_Wrappers.Companion_Option_.Default())
}

func (_this CreateCustomKeyStoreResponse) Dtor_CustomKeyStoreId() m_Wrappers.Option {
	return _this.Get_().(CreateCustomKeyStoreResponse_CreateCustomKeyStoreResponse).CustomKeyStoreId
}

func (_this CreateCustomKeyStoreResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateCustomKeyStoreResponse_CreateCustomKeyStoreResponse:
		{
			return "ComAmazonawsKmsTypes.CreateCustomKeyStoreResponse.CreateCustomKeyStoreResponse" + "(" + _dafny.String(data.CustomKeyStoreId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateCustomKeyStoreResponse) Equals(other CreateCustomKeyStoreResponse) bool {
	switch data1 := _this.Get_().(type) {
	case CreateCustomKeyStoreResponse_CreateCustomKeyStoreResponse:
		{
			data2, ok := other.Get_().(CreateCustomKeyStoreResponse_CreateCustomKeyStoreResponse)
			return ok && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateCustomKeyStoreResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateCustomKeyStoreResponse)
	return ok && _this.Equals(typed)
}

func Type_CreateCustomKeyStoreResponse_() _dafny.TypeDescriptor {
	return type_CreateCustomKeyStoreResponse_{}
}

type type_CreateCustomKeyStoreResponse_ struct {
}

func (_this type_CreateCustomKeyStoreResponse_) Default() interface{} {
	return Companion_CreateCustomKeyStoreResponse_.Default()
}

func (_this type_CreateCustomKeyStoreResponse_) String() string {
	return "ComAmazonawsKmsTypes.CreateCustomKeyStoreResponse"
}
func (_this CreateCustomKeyStoreResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateCustomKeyStoreResponse{}

// End of datatype CreateCustomKeyStoreResponse

// Definition of datatype CreateGrantRequest
type CreateGrantRequest struct {
	Data_CreateGrantRequest_
}

func (_this CreateGrantRequest) Get_() Data_CreateGrantRequest_ {
	return _this.Data_CreateGrantRequest_
}

type Data_CreateGrantRequest_ interface {
	isCreateGrantRequest()
}

type CompanionStruct_CreateGrantRequest_ struct {
}

var Companion_CreateGrantRequest_ = CompanionStruct_CreateGrantRequest_{}

type CreateGrantRequest_CreateGrantRequest struct {
	KeyId             _dafny.Sequence
	GranteePrincipal  _dafny.Sequence
	RetiringPrincipal m_Wrappers.Option
	Operations        _dafny.Sequence
	Constraints       m_Wrappers.Option
	GrantTokens       m_Wrappers.Option
	Name              m_Wrappers.Option
	DryRun            m_Wrappers.Option
}

func (CreateGrantRequest_CreateGrantRequest) isCreateGrantRequest() {}

func (CompanionStruct_CreateGrantRequest_) Create_CreateGrantRequest_(KeyId _dafny.Sequence, GranteePrincipal _dafny.Sequence, RetiringPrincipal m_Wrappers.Option, Operations _dafny.Sequence, Constraints m_Wrappers.Option, GrantTokens m_Wrappers.Option, Name m_Wrappers.Option, DryRun m_Wrappers.Option) CreateGrantRequest {
	return CreateGrantRequest{CreateGrantRequest_CreateGrantRequest{KeyId, GranteePrincipal, RetiringPrincipal, Operations, Constraints, GrantTokens, Name, DryRun}}
}

func (_this CreateGrantRequest) Is_CreateGrantRequest() bool {
	_, ok := _this.Get_().(CreateGrantRequest_CreateGrantRequest)
	return ok
}

func (CompanionStruct_CreateGrantRequest_) Default() CreateGrantRequest {
	return Companion_CreateGrantRequest_.Create_CreateGrantRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateGrantRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(CreateGrantRequest_CreateGrantRequest).KeyId
}

func (_this CreateGrantRequest) Dtor_GranteePrincipal() _dafny.Sequence {
	return _this.Get_().(CreateGrantRequest_CreateGrantRequest).GranteePrincipal
}

func (_this CreateGrantRequest) Dtor_RetiringPrincipal() m_Wrappers.Option {
	return _this.Get_().(CreateGrantRequest_CreateGrantRequest).RetiringPrincipal
}

func (_this CreateGrantRequest) Dtor_Operations() _dafny.Sequence {
	return _this.Get_().(CreateGrantRequest_CreateGrantRequest).Operations
}

func (_this CreateGrantRequest) Dtor_Constraints() m_Wrappers.Option {
	return _this.Get_().(CreateGrantRequest_CreateGrantRequest).Constraints
}

func (_this CreateGrantRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(CreateGrantRequest_CreateGrantRequest).GrantTokens
}

func (_this CreateGrantRequest) Dtor_Name() m_Wrappers.Option {
	return _this.Get_().(CreateGrantRequest_CreateGrantRequest).Name
}

func (_this CreateGrantRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(CreateGrantRequest_CreateGrantRequest).DryRun
}

func (_this CreateGrantRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateGrantRequest_CreateGrantRequest:
		{
			return "ComAmazonawsKmsTypes.CreateGrantRequest.CreateGrantRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.GranteePrincipal) + ", " + _dafny.String(data.RetiringPrincipal) + ", " + _dafny.String(data.Operations) + ", " + _dafny.String(data.Constraints) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.Name) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateGrantRequest) Equals(other CreateGrantRequest) bool {
	switch data1 := _this.Get_().(type) {
	case CreateGrantRequest_CreateGrantRequest:
		{
			data2, ok := other.Get_().(CreateGrantRequest_CreateGrantRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.GranteePrincipal.Equals(data2.GranteePrincipal) && data1.RetiringPrincipal.Equals(data2.RetiringPrincipal) && data1.Operations.Equals(data2.Operations) && data1.Constraints.Equals(data2.Constraints) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.Name.Equals(data2.Name) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateGrantRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateGrantRequest)
	return ok && _this.Equals(typed)
}

func Type_CreateGrantRequest_() _dafny.TypeDescriptor {
	return type_CreateGrantRequest_{}
}

type type_CreateGrantRequest_ struct {
}

func (_this type_CreateGrantRequest_) Default() interface{} {
	return Companion_CreateGrantRequest_.Default()
}

func (_this type_CreateGrantRequest_) String() string {
	return "ComAmazonawsKmsTypes.CreateGrantRequest"
}
func (_this CreateGrantRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateGrantRequest{}

// End of datatype CreateGrantRequest

// Definition of datatype CreateGrantResponse
type CreateGrantResponse struct {
	Data_CreateGrantResponse_
}

func (_this CreateGrantResponse) Get_() Data_CreateGrantResponse_ {
	return _this.Data_CreateGrantResponse_
}

type Data_CreateGrantResponse_ interface {
	isCreateGrantResponse()
}

type CompanionStruct_CreateGrantResponse_ struct {
}

var Companion_CreateGrantResponse_ = CompanionStruct_CreateGrantResponse_{}

type CreateGrantResponse_CreateGrantResponse struct {
	GrantToken m_Wrappers.Option
	GrantId    m_Wrappers.Option
}

func (CreateGrantResponse_CreateGrantResponse) isCreateGrantResponse() {}

func (CompanionStruct_CreateGrantResponse_) Create_CreateGrantResponse_(GrantToken m_Wrappers.Option, GrantId m_Wrappers.Option) CreateGrantResponse {
	return CreateGrantResponse{CreateGrantResponse_CreateGrantResponse{GrantToken, GrantId}}
}

func (_this CreateGrantResponse) Is_CreateGrantResponse() bool {
	_, ok := _this.Get_().(CreateGrantResponse_CreateGrantResponse)
	return ok
}

func (CompanionStruct_CreateGrantResponse_) Default() CreateGrantResponse {
	return Companion_CreateGrantResponse_.Create_CreateGrantResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateGrantResponse) Dtor_GrantToken() m_Wrappers.Option {
	return _this.Get_().(CreateGrantResponse_CreateGrantResponse).GrantToken
}

func (_this CreateGrantResponse) Dtor_GrantId() m_Wrappers.Option {
	return _this.Get_().(CreateGrantResponse_CreateGrantResponse).GrantId
}

func (_this CreateGrantResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateGrantResponse_CreateGrantResponse:
		{
			return "ComAmazonawsKmsTypes.CreateGrantResponse.CreateGrantResponse" + "(" + _dafny.String(data.GrantToken) + ", " + _dafny.String(data.GrantId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateGrantResponse) Equals(other CreateGrantResponse) bool {
	switch data1 := _this.Get_().(type) {
	case CreateGrantResponse_CreateGrantResponse:
		{
			data2, ok := other.Get_().(CreateGrantResponse_CreateGrantResponse)
			return ok && data1.GrantToken.Equals(data2.GrantToken) && data1.GrantId.Equals(data2.GrantId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateGrantResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateGrantResponse)
	return ok && _this.Equals(typed)
}

func Type_CreateGrantResponse_() _dafny.TypeDescriptor {
	return type_CreateGrantResponse_{}
}

type type_CreateGrantResponse_ struct {
}

func (_this type_CreateGrantResponse_) Default() interface{} {
	return Companion_CreateGrantResponse_.Default()
}

func (_this type_CreateGrantResponse_) String() string {
	return "ComAmazonawsKmsTypes.CreateGrantResponse"
}
func (_this CreateGrantResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateGrantResponse{}

// End of datatype CreateGrantResponse

// Definition of datatype CreateKeyRequest
type CreateKeyRequest struct {
	Data_CreateKeyRequest_
}

func (_this CreateKeyRequest) Get_() Data_CreateKeyRequest_ {
	return _this.Data_CreateKeyRequest_
}

type Data_CreateKeyRequest_ interface {
	isCreateKeyRequest()
}

type CompanionStruct_CreateKeyRequest_ struct {
}

var Companion_CreateKeyRequest_ = CompanionStruct_CreateKeyRequest_{}

type CreateKeyRequest_CreateKeyRequest struct {
	Policy                         m_Wrappers.Option
	Description                    m_Wrappers.Option
	KeyUsage                       m_Wrappers.Option
	CustomerMasterKeySpec          m_Wrappers.Option
	KeySpec                        m_Wrappers.Option
	Origin                         m_Wrappers.Option
	CustomKeyStoreId               m_Wrappers.Option
	BypassPolicyLockoutSafetyCheck m_Wrappers.Option
	Tags                           m_Wrappers.Option
	MultiRegion                    m_Wrappers.Option
	XksKeyId                       m_Wrappers.Option
}

func (CreateKeyRequest_CreateKeyRequest) isCreateKeyRequest() {}

func (CompanionStruct_CreateKeyRequest_) Create_CreateKeyRequest_(Policy m_Wrappers.Option, Description m_Wrappers.Option, KeyUsage m_Wrappers.Option, CustomerMasterKeySpec m_Wrappers.Option, KeySpec m_Wrappers.Option, Origin m_Wrappers.Option, CustomKeyStoreId m_Wrappers.Option, BypassPolicyLockoutSafetyCheck m_Wrappers.Option, Tags m_Wrappers.Option, MultiRegion m_Wrappers.Option, XksKeyId m_Wrappers.Option) CreateKeyRequest {
	return CreateKeyRequest{CreateKeyRequest_CreateKeyRequest{Policy, Description, KeyUsage, CustomerMasterKeySpec, KeySpec, Origin, CustomKeyStoreId, BypassPolicyLockoutSafetyCheck, Tags, MultiRegion, XksKeyId}}
}

func (_this CreateKeyRequest) Is_CreateKeyRequest() bool {
	_, ok := _this.Get_().(CreateKeyRequest_CreateKeyRequest)
	return ok
}

func (CompanionStruct_CreateKeyRequest_) Default() CreateKeyRequest {
	return Companion_CreateKeyRequest_.Create_CreateKeyRequest_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CreateKeyRequest) Dtor_Policy() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).Policy
}

func (_this CreateKeyRequest) Dtor_Description() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).Description
}

func (_this CreateKeyRequest) Dtor_KeyUsage() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).KeyUsage
}

func (_this CreateKeyRequest) Dtor_CustomerMasterKeySpec() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).CustomerMasterKeySpec
}

func (_this CreateKeyRequest) Dtor_KeySpec() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).KeySpec
}

func (_this CreateKeyRequest) Dtor_Origin() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).Origin
}

func (_this CreateKeyRequest) Dtor_CustomKeyStoreId() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).CustomKeyStoreId
}

func (_this CreateKeyRequest) Dtor_BypassPolicyLockoutSafetyCheck() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).BypassPolicyLockoutSafetyCheck
}

func (_this CreateKeyRequest) Dtor_Tags() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).Tags
}

func (_this CreateKeyRequest) Dtor_MultiRegion() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).MultiRegion
}

func (_this CreateKeyRequest) Dtor_XksKeyId() m_Wrappers.Option {
	return _this.Get_().(CreateKeyRequest_CreateKeyRequest).XksKeyId
}

func (_this CreateKeyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateKeyRequest_CreateKeyRequest:
		{
			return "ComAmazonawsKmsTypes.CreateKeyRequest.CreateKeyRequest" + "(" + _dafny.String(data.Policy) + ", " + _dafny.String(data.Description) + ", " + _dafny.String(data.KeyUsage) + ", " + _dafny.String(data.CustomerMasterKeySpec) + ", " + _dafny.String(data.KeySpec) + ", " + _dafny.String(data.Origin) + ", " + _dafny.String(data.CustomKeyStoreId) + ", " + _dafny.String(data.BypassPolicyLockoutSafetyCheck) + ", " + _dafny.String(data.Tags) + ", " + _dafny.String(data.MultiRegion) + ", " + _dafny.String(data.XksKeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateKeyRequest) Equals(other CreateKeyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case CreateKeyRequest_CreateKeyRequest:
		{
			data2, ok := other.Get_().(CreateKeyRequest_CreateKeyRequest)
			return ok && data1.Policy.Equals(data2.Policy) && data1.Description.Equals(data2.Description) && data1.KeyUsage.Equals(data2.KeyUsage) && data1.CustomerMasterKeySpec.Equals(data2.CustomerMasterKeySpec) && data1.KeySpec.Equals(data2.KeySpec) && data1.Origin.Equals(data2.Origin) && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId) && data1.BypassPolicyLockoutSafetyCheck.Equals(data2.BypassPolicyLockoutSafetyCheck) && data1.Tags.Equals(data2.Tags) && data1.MultiRegion.Equals(data2.MultiRegion) && data1.XksKeyId.Equals(data2.XksKeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateKeyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateKeyRequest)
	return ok && _this.Equals(typed)
}

func Type_CreateKeyRequest_() _dafny.TypeDescriptor {
	return type_CreateKeyRequest_{}
}

type type_CreateKeyRequest_ struct {
}

func (_this type_CreateKeyRequest_) Default() interface{} {
	return Companion_CreateKeyRequest_.Default()
}

func (_this type_CreateKeyRequest_) String() string {
	return "ComAmazonawsKmsTypes.CreateKeyRequest"
}
func (_this CreateKeyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateKeyRequest{}

// End of datatype CreateKeyRequest

// Definition of datatype CreateKeyResponse
type CreateKeyResponse struct {
	Data_CreateKeyResponse_
}

func (_this CreateKeyResponse) Get_() Data_CreateKeyResponse_ {
	return _this.Data_CreateKeyResponse_
}

type Data_CreateKeyResponse_ interface {
	isCreateKeyResponse()
}

type CompanionStruct_CreateKeyResponse_ struct {
}

var Companion_CreateKeyResponse_ = CompanionStruct_CreateKeyResponse_{}

type CreateKeyResponse_CreateKeyResponse struct {
	KeyMetadata m_Wrappers.Option
}

func (CreateKeyResponse_CreateKeyResponse) isCreateKeyResponse() {}

func (CompanionStruct_CreateKeyResponse_) Create_CreateKeyResponse_(KeyMetadata m_Wrappers.Option) CreateKeyResponse {
	return CreateKeyResponse{CreateKeyResponse_CreateKeyResponse{KeyMetadata}}
}

func (_this CreateKeyResponse) Is_CreateKeyResponse() bool {
	_, ok := _this.Get_().(CreateKeyResponse_CreateKeyResponse)
	return ok
}

func (CompanionStruct_CreateKeyResponse_) Default() CreateKeyResponse {
	return Companion_CreateKeyResponse_.Create_CreateKeyResponse_(m_Wrappers.Companion_Option_.Default())
}

func (_this CreateKeyResponse) Dtor_KeyMetadata() m_Wrappers.Option {
	return _this.Get_().(CreateKeyResponse_CreateKeyResponse).KeyMetadata
}

func (_this CreateKeyResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CreateKeyResponse_CreateKeyResponse:
		{
			return "ComAmazonawsKmsTypes.CreateKeyResponse.CreateKeyResponse" + "(" + _dafny.String(data.KeyMetadata) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CreateKeyResponse) Equals(other CreateKeyResponse) bool {
	switch data1 := _this.Get_().(type) {
	case CreateKeyResponse_CreateKeyResponse:
		{
			data2, ok := other.Get_().(CreateKeyResponse_CreateKeyResponse)
			return ok && data1.KeyMetadata.Equals(data2.KeyMetadata)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CreateKeyResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CreateKeyResponse)
	return ok && _this.Equals(typed)
}

func Type_CreateKeyResponse_() _dafny.TypeDescriptor {
	return type_CreateKeyResponse_{}
}

type type_CreateKeyResponse_ struct {
}

func (_this type_CreateKeyResponse_) Default() interface{} {
	return Companion_CreateKeyResponse_.Default()
}

func (_this type_CreateKeyResponse_) String() string {
	return "ComAmazonawsKmsTypes.CreateKeyResponse"
}
func (_this CreateKeyResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CreateKeyResponse{}

// End of datatype CreateKeyResponse

// Definition of datatype CustomerMasterKeySpec
type CustomerMasterKeySpec struct {
	Data_CustomerMasterKeySpec_
}

func (_this CustomerMasterKeySpec) Get_() Data_CustomerMasterKeySpec_ {
	return _this.Data_CustomerMasterKeySpec_
}

type Data_CustomerMasterKeySpec_ interface {
	isCustomerMasterKeySpec()
}

type CompanionStruct_CustomerMasterKeySpec_ struct {
}

var Companion_CustomerMasterKeySpec_ = CompanionStruct_CustomerMasterKeySpec_{}

type CustomerMasterKeySpec_RSA__2048 struct {
}

func (CustomerMasterKeySpec_RSA__2048) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_RSA__2048_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_RSA__2048{}}
}

func (_this CustomerMasterKeySpec) Is_RSA__2048() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_RSA__2048)
	return ok
}

type CustomerMasterKeySpec_RSA__3072 struct {
}

func (CustomerMasterKeySpec_RSA__3072) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_RSA__3072_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_RSA__3072{}}
}

func (_this CustomerMasterKeySpec) Is_RSA__3072() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_RSA__3072)
	return ok
}

type CustomerMasterKeySpec_RSA__4096 struct {
}

func (CustomerMasterKeySpec_RSA__4096) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_RSA__4096_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_RSA__4096{}}
}

func (_this CustomerMasterKeySpec) Is_RSA__4096() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_RSA__4096)
	return ok
}

type CustomerMasterKeySpec_ECC__NIST__P256 struct {
}

func (CustomerMasterKeySpec_ECC__NIST__P256) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_ECC__NIST__P256_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_ECC__NIST__P256{}}
}

func (_this CustomerMasterKeySpec) Is_ECC__NIST__P256() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_ECC__NIST__P256)
	return ok
}

type CustomerMasterKeySpec_ECC__NIST__P384 struct {
}

func (CustomerMasterKeySpec_ECC__NIST__P384) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_ECC__NIST__P384_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_ECC__NIST__P384{}}
}

func (_this CustomerMasterKeySpec) Is_ECC__NIST__P384() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_ECC__NIST__P384)
	return ok
}

type CustomerMasterKeySpec_ECC__NIST__P521 struct {
}

func (CustomerMasterKeySpec_ECC__NIST__P521) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_ECC__NIST__P521_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_ECC__NIST__P521{}}
}

func (_this CustomerMasterKeySpec) Is_ECC__NIST__P521() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_ECC__NIST__P521)
	return ok
}

type CustomerMasterKeySpec_ECC__SECG__P256K1 struct {
}

func (CustomerMasterKeySpec_ECC__SECG__P256K1) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_ECC__SECG__P256K1_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_ECC__SECG__P256K1{}}
}

func (_this CustomerMasterKeySpec) Is_ECC__SECG__P256K1() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_ECC__SECG__P256K1)
	return ok
}

type CustomerMasterKeySpec_SYMMETRIC__DEFAULT struct {
}

func (CustomerMasterKeySpec_SYMMETRIC__DEFAULT) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_SYMMETRIC__DEFAULT_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_SYMMETRIC__DEFAULT{}}
}

func (_this CustomerMasterKeySpec) Is_SYMMETRIC__DEFAULT() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_SYMMETRIC__DEFAULT)
	return ok
}

type CustomerMasterKeySpec_HMAC__224 struct {
}

func (CustomerMasterKeySpec_HMAC__224) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_HMAC__224_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_HMAC__224{}}
}

func (_this CustomerMasterKeySpec) Is_HMAC__224() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_HMAC__224)
	return ok
}

type CustomerMasterKeySpec_HMAC__256 struct {
}

func (CustomerMasterKeySpec_HMAC__256) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_HMAC__256_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_HMAC__256{}}
}

func (_this CustomerMasterKeySpec) Is_HMAC__256() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_HMAC__256)
	return ok
}

type CustomerMasterKeySpec_HMAC__384 struct {
}

func (CustomerMasterKeySpec_HMAC__384) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_HMAC__384_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_HMAC__384{}}
}

func (_this CustomerMasterKeySpec) Is_HMAC__384() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_HMAC__384)
	return ok
}

type CustomerMasterKeySpec_HMAC__512 struct {
}

func (CustomerMasterKeySpec_HMAC__512) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_HMAC__512_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_HMAC__512{}}
}

func (_this CustomerMasterKeySpec) Is_HMAC__512() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_HMAC__512)
	return ok
}

type CustomerMasterKeySpec_SM2 struct {
}

func (CustomerMasterKeySpec_SM2) isCustomerMasterKeySpec() {}

func (CompanionStruct_CustomerMasterKeySpec_) Create_SM2_() CustomerMasterKeySpec {
	return CustomerMasterKeySpec{CustomerMasterKeySpec_SM2{}}
}

func (_this CustomerMasterKeySpec) Is_SM2() bool {
	_, ok := _this.Get_().(CustomerMasterKeySpec_SM2)
	return ok
}

func (CompanionStruct_CustomerMasterKeySpec_) Default() CustomerMasterKeySpec {
	return Companion_CustomerMasterKeySpec_.Create_RSA__2048_()
}

func (_ CompanionStruct_CustomerMasterKeySpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_CustomerMasterKeySpec_.Create_RSA__2048_(), true
		case 1:
			return Companion_CustomerMasterKeySpec_.Create_RSA__3072_(), true
		case 2:
			return Companion_CustomerMasterKeySpec_.Create_RSA__4096_(), true
		case 3:
			return Companion_CustomerMasterKeySpec_.Create_ECC__NIST__P256_(), true
		case 4:
			return Companion_CustomerMasterKeySpec_.Create_ECC__NIST__P384_(), true
		case 5:
			return Companion_CustomerMasterKeySpec_.Create_ECC__NIST__P521_(), true
		case 6:
			return Companion_CustomerMasterKeySpec_.Create_ECC__SECG__P256K1_(), true
		case 7:
			return Companion_CustomerMasterKeySpec_.Create_SYMMETRIC__DEFAULT_(), true
		case 8:
			return Companion_CustomerMasterKeySpec_.Create_HMAC__224_(), true
		case 9:
			return Companion_CustomerMasterKeySpec_.Create_HMAC__256_(), true
		case 10:
			return Companion_CustomerMasterKeySpec_.Create_HMAC__384_(), true
		case 11:
			return Companion_CustomerMasterKeySpec_.Create_HMAC__512_(), true
		case 12:
			return Companion_CustomerMasterKeySpec_.Create_SM2_(), true
		default:
			return CustomerMasterKeySpec{}, false
		}
	}
}

func (_this CustomerMasterKeySpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case CustomerMasterKeySpec_RSA__2048:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.RSA_2048"
		}
	case CustomerMasterKeySpec_RSA__3072:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.RSA_3072"
		}
	case CustomerMasterKeySpec_RSA__4096:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.RSA_4096"
		}
	case CustomerMasterKeySpec_ECC__NIST__P256:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.ECC_NIST_P256"
		}
	case CustomerMasterKeySpec_ECC__NIST__P384:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.ECC_NIST_P384"
		}
	case CustomerMasterKeySpec_ECC__NIST__P521:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.ECC_NIST_P521"
		}
	case CustomerMasterKeySpec_ECC__SECG__P256K1:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.ECC_SECG_P256K1"
		}
	case CustomerMasterKeySpec_SYMMETRIC__DEFAULT:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.SYMMETRIC_DEFAULT"
		}
	case CustomerMasterKeySpec_HMAC__224:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.HMAC_224"
		}
	case CustomerMasterKeySpec_HMAC__256:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.HMAC_256"
		}
	case CustomerMasterKeySpec_HMAC__384:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.HMAC_384"
		}
	case CustomerMasterKeySpec_HMAC__512:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.HMAC_512"
		}
	case CustomerMasterKeySpec_SM2:
		{
			return "ComAmazonawsKmsTypes.CustomerMasterKeySpec.SM2"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CustomerMasterKeySpec) Equals(other CustomerMasterKeySpec) bool {
	switch _this.Get_().(type) {
	case CustomerMasterKeySpec_RSA__2048:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_RSA__2048)
			return ok
		}
	case CustomerMasterKeySpec_RSA__3072:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_RSA__3072)
			return ok
		}
	case CustomerMasterKeySpec_RSA__4096:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_RSA__4096)
			return ok
		}
	case CustomerMasterKeySpec_ECC__NIST__P256:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_ECC__NIST__P256)
			return ok
		}
	case CustomerMasterKeySpec_ECC__NIST__P384:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_ECC__NIST__P384)
			return ok
		}
	case CustomerMasterKeySpec_ECC__NIST__P521:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_ECC__NIST__P521)
			return ok
		}
	case CustomerMasterKeySpec_ECC__SECG__P256K1:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_ECC__SECG__P256K1)
			return ok
		}
	case CustomerMasterKeySpec_SYMMETRIC__DEFAULT:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_SYMMETRIC__DEFAULT)
			return ok
		}
	case CustomerMasterKeySpec_HMAC__224:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_HMAC__224)
			return ok
		}
	case CustomerMasterKeySpec_HMAC__256:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_HMAC__256)
			return ok
		}
	case CustomerMasterKeySpec_HMAC__384:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_HMAC__384)
			return ok
		}
	case CustomerMasterKeySpec_HMAC__512:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_HMAC__512)
			return ok
		}
	case CustomerMasterKeySpec_SM2:
		{
			_, ok := other.Get_().(CustomerMasterKeySpec_SM2)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CustomerMasterKeySpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CustomerMasterKeySpec)
	return ok && _this.Equals(typed)
}

func Type_CustomerMasterKeySpec_() _dafny.TypeDescriptor {
	return type_CustomerMasterKeySpec_{}
}

type type_CustomerMasterKeySpec_ struct {
}

func (_this type_CustomerMasterKeySpec_) Default() interface{} {
	return Companion_CustomerMasterKeySpec_.Default()
}

func (_this type_CustomerMasterKeySpec_) String() string {
	return "ComAmazonawsKmsTypes.CustomerMasterKeySpec"
}
func (_this CustomerMasterKeySpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CustomerMasterKeySpec{}

// End of datatype CustomerMasterKeySpec

// Definition of class CustomKeyStoreIdType
type CustomKeyStoreIdType struct {
}

func New_CustomKeyStoreIdType_() *CustomKeyStoreIdType {
	_this := CustomKeyStoreIdType{}

	return &_this
}

type CompanionStruct_CustomKeyStoreIdType_ struct {
}

var Companion_CustomKeyStoreIdType_ = CompanionStruct_CustomKeyStoreIdType_{}

func (*CustomKeyStoreIdType) String() string {
	return "ComAmazonawsKmsTypes.CustomKeyStoreIdType"
}

// End of class CustomKeyStoreIdType

func Type_CustomKeyStoreIdType_() _dafny.TypeDescriptor {
	return type_CustomKeyStoreIdType_{}
}

type type_CustomKeyStoreIdType_ struct {
}

func (_this type_CustomKeyStoreIdType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_CustomKeyStoreIdType_) String() string {
	return "ComAmazonawsKmsTypes.CustomKeyStoreIdType"
}
func (_this *CompanionStruct_CustomKeyStoreIdType_) Is_(__source _dafny.Sequence) bool {
	var _5_x _dafny.Sequence = (__source)
	_ = _5_x
	return Companion_Default___.IsValid__CustomKeyStoreIdType(_5_x)
}

// Definition of class CustomKeyStoreNameType
type CustomKeyStoreNameType struct {
}

func New_CustomKeyStoreNameType_() *CustomKeyStoreNameType {
	_this := CustomKeyStoreNameType{}

	return &_this
}

type CompanionStruct_CustomKeyStoreNameType_ struct {
}

var Companion_CustomKeyStoreNameType_ = CompanionStruct_CustomKeyStoreNameType_{}

func (*CustomKeyStoreNameType) String() string {
	return "ComAmazonawsKmsTypes.CustomKeyStoreNameType"
}

// End of class CustomKeyStoreNameType

func Type_CustomKeyStoreNameType_() _dafny.TypeDescriptor {
	return type_CustomKeyStoreNameType_{}
}

type type_CustomKeyStoreNameType_ struct {
}

func (_this type_CustomKeyStoreNameType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_CustomKeyStoreNameType_) String() string {
	return "ComAmazonawsKmsTypes.CustomKeyStoreNameType"
}
func (_this *CompanionStruct_CustomKeyStoreNameType_) Is_(__source _dafny.Sequence) bool {
	var _6_x _dafny.Sequence = (__source)
	_ = _6_x
	return Companion_Default___.IsValid__CustomKeyStoreNameType(_6_x)
}

// Definition of datatype CustomKeyStoresListEntry
type CustomKeyStoresListEntry struct {
	Data_CustomKeyStoresListEntry_
}

func (_this CustomKeyStoresListEntry) Get_() Data_CustomKeyStoresListEntry_ {
	return _this.Data_CustomKeyStoresListEntry_
}

type Data_CustomKeyStoresListEntry_ interface {
	isCustomKeyStoresListEntry()
}

type CompanionStruct_CustomKeyStoresListEntry_ struct {
}

var Companion_CustomKeyStoresListEntry_ = CompanionStruct_CustomKeyStoresListEntry_{}

type CustomKeyStoresListEntry_CustomKeyStoresListEntry struct {
	CustomKeyStoreId       m_Wrappers.Option
	CustomKeyStoreName     m_Wrappers.Option
	CloudHsmClusterId      m_Wrappers.Option
	TrustAnchorCertificate m_Wrappers.Option
	ConnectionState        m_Wrappers.Option
	ConnectionErrorCode    m_Wrappers.Option
	CreationDate           m_Wrappers.Option
	CustomKeyStoreType     m_Wrappers.Option
	XksProxyConfiguration  m_Wrappers.Option
}

func (CustomKeyStoresListEntry_CustomKeyStoresListEntry) isCustomKeyStoresListEntry() {}

func (CompanionStruct_CustomKeyStoresListEntry_) Create_CustomKeyStoresListEntry_(CustomKeyStoreId m_Wrappers.Option, CustomKeyStoreName m_Wrappers.Option, CloudHsmClusterId m_Wrappers.Option, TrustAnchorCertificate m_Wrappers.Option, ConnectionState m_Wrappers.Option, ConnectionErrorCode m_Wrappers.Option, CreationDate m_Wrappers.Option, CustomKeyStoreType m_Wrappers.Option, XksProxyConfiguration m_Wrappers.Option) CustomKeyStoresListEntry {
	return CustomKeyStoresListEntry{CustomKeyStoresListEntry_CustomKeyStoresListEntry{CustomKeyStoreId, CustomKeyStoreName, CloudHsmClusterId, TrustAnchorCertificate, ConnectionState, ConnectionErrorCode, CreationDate, CustomKeyStoreType, XksProxyConfiguration}}
}

func (_this CustomKeyStoresListEntry) Is_CustomKeyStoresListEntry() bool {
	_, ok := _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry)
	return ok
}

func (CompanionStruct_CustomKeyStoresListEntry_) Default() CustomKeyStoresListEntry {
	return Companion_CustomKeyStoresListEntry_.Create_CustomKeyStoresListEntry_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this CustomKeyStoresListEntry) Dtor_CustomKeyStoreId() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).CustomKeyStoreId
}

func (_this CustomKeyStoresListEntry) Dtor_CustomKeyStoreName() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).CustomKeyStoreName
}

func (_this CustomKeyStoresListEntry) Dtor_CloudHsmClusterId() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).CloudHsmClusterId
}

func (_this CustomKeyStoresListEntry) Dtor_TrustAnchorCertificate() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).TrustAnchorCertificate
}

func (_this CustomKeyStoresListEntry) Dtor_ConnectionState() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).ConnectionState
}

func (_this CustomKeyStoresListEntry) Dtor_ConnectionErrorCode() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).ConnectionErrorCode
}

func (_this CustomKeyStoresListEntry) Dtor_CreationDate() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).CreationDate
}

func (_this CustomKeyStoresListEntry) Dtor_CustomKeyStoreType() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).CustomKeyStoreType
}

func (_this CustomKeyStoresListEntry) Dtor_XksProxyConfiguration() m_Wrappers.Option {
	return _this.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry).XksProxyConfiguration
}

func (_this CustomKeyStoresListEntry) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CustomKeyStoresListEntry_CustomKeyStoresListEntry:
		{
			return "ComAmazonawsKmsTypes.CustomKeyStoresListEntry.CustomKeyStoresListEntry" + "(" + _dafny.String(data.CustomKeyStoreId) + ", " + _dafny.String(data.CustomKeyStoreName) + ", " + _dafny.String(data.CloudHsmClusterId) + ", " + _dafny.String(data.TrustAnchorCertificate) + ", " + _dafny.String(data.ConnectionState) + ", " + _dafny.String(data.ConnectionErrorCode) + ", " + _dafny.String(data.CreationDate) + ", " + _dafny.String(data.CustomKeyStoreType) + ", " + _dafny.String(data.XksProxyConfiguration) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CustomKeyStoresListEntry) Equals(other CustomKeyStoresListEntry) bool {
	switch data1 := _this.Get_().(type) {
	case CustomKeyStoresListEntry_CustomKeyStoresListEntry:
		{
			data2, ok := other.Get_().(CustomKeyStoresListEntry_CustomKeyStoresListEntry)
			return ok && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId) && data1.CustomKeyStoreName.Equals(data2.CustomKeyStoreName) && data1.CloudHsmClusterId.Equals(data2.CloudHsmClusterId) && data1.TrustAnchorCertificate.Equals(data2.TrustAnchorCertificate) && data1.ConnectionState.Equals(data2.ConnectionState) && data1.ConnectionErrorCode.Equals(data2.ConnectionErrorCode) && data1.CreationDate.Equals(data2.CreationDate) && data1.CustomKeyStoreType.Equals(data2.CustomKeyStoreType) && data1.XksProxyConfiguration.Equals(data2.XksProxyConfiguration)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CustomKeyStoresListEntry) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CustomKeyStoresListEntry)
	return ok && _this.Equals(typed)
}

func Type_CustomKeyStoresListEntry_() _dafny.TypeDescriptor {
	return type_CustomKeyStoresListEntry_{}
}

type type_CustomKeyStoresListEntry_ struct {
}

func (_this type_CustomKeyStoresListEntry_) Default() interface{} {
	return Companion_CustomKeyStoresListEntry_.Default()
}

func (_this type_CustomKeyStoresListEntry_) String() string {
	return "ComAmazonawsKmsTypes.CustomKeyStoresListEntry"
}
func (_this CustomKeyStoresListEntry) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CustomKeyStoresListEntry{}

// End of datatype CustomKeyStoresListEntry

// Definition of datatype CustomKeyStoreType
type CustomKeyStoreType struct {
	Data_CustomKeyStoreType_
}

func (_this CustomKeyStoreType) Get_() Data_CustomKeyStoreType_ {
	return _this.Data_CustomKeyStoreType_
}

type Data_CustomKeyStoreType_ interface {
	isCustomKeyStoreType()
}

type CompanionStruct_CustomKeyStoreType_ struct {
}

var Companion_CustomKeyStoreType_ = CompanionStruct_CustomKeyStoreType_{}

type CustomKeyStoreType_AWS__CLOUDHSM struct {
}

func (CustomKeyStoreType_AWS__CLOUDHSM) isCustomKeyStoreType() {}

func (CompanionStruct_CustomKeyStoreType_) Create_AWS__CLOUDHSM_() CustomKeyStoreType {
	return CustomKeyStoreType{CustomKeyStoreType_AWS__CLOUDHSM{}}
}

func (_this CustomKeyStoreType) Is_AWS__CLOUDHSM() bool {
	_, ok := _this.Get_().(CustomKeyStoreType_AWS__CLOUDHSM)
	return ok
}

type CustomKeyStoreType_EXTERNAL__KEY__STORE struct {
}

func (CustomKeyStoreType_EXTERNAL__KEY__STORE) isCustomKeyStoreType() {}

func (CompanionStruct_CustomKeyStoreType_) Create_EXTERNAL__KEY__STORE_() CustomKeyStoreType {
	return CustomKeyStoreType{CustomKeyStoreType_EXTERNAL__KEY__STORE{}}
}

func (_this CustomKeyStoreType) Is_EXTERNAL__KEY__STORE() bool {
	_, ok := _this.Get_().(CustomKeyStoreType_EXTERNAL__KEY__STORE)
	return ok
}

func (CompanionStruct_CustomKeyStoreType_) Default() CustomKeyStoreType {
	return Companion_CustomKeyStoreType_.Create_AWS__CLOUDHSM_()
}

func (_ CompanionStruct_CustomKeyStoreType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_CustomKeyStoreType_.Create_AWS__CLOUDHSM_(), true
		case 1:
			return Companion_CustomKeyStoreType_.Create_EXTERNAL__KEY__STORE_(), true
		default:
			return CustomKeyStoreType{}, false
		}
	}
}

func (_this CustomKeyStoreType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case CustomKeyStoreType_AWS__CLOUDHSM:
		{
			return "ComAmazonawsKmsTypes.CustomKeyStoreType.AWS_CLOUDHSM"
		}
	case CustomKeyStoreType_EXTERNAL__KEY__STORE:
		{
			return "ComAmazonawsKmsTypes.CustomKeyStoreType.EXTERNAL_KEY_STORE"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CustomKeyStoreType) Equals(other CustomKeyStoreType) bool {
	switch _this.Get_().(type) {
	case CustomKeyStoreType_AWS__CLOUDHSM:
		{
			_, ok := other.Get_().(CustomKeyStoreType_AWS__CLOUDHSM)
			return ok
		}
	case CustomKeyStoreType_EXTERNAL__KEY__STORE:
		{
			_, ok := other.Get_().(CustomKeyStoreType_EXTERNAL__KEY__STORE)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CustomKeyStoreType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CustomKeyStoreType)
	return ok && _this.Equals(typed)
}

func Type_CustomKeyStoreType_() _dafny.TypeDescriptor {
	return type_CustomKeyStoreType_{}
}

type type_CustomKeyStoreType_ struct {
}

func (_this type_CustomKeyStoreType_) Default() interface{} {
	return Companion_CustomKeyStoreType_.Default()
}

func (_this type_CustomKeyStoreType_) String() string {
	return "ComAmazonawsKmsTypes.CustomKeyStoreType"
}
func (_this CustomKeyStoreType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CustomKeyStoreType{}

// End of datatype CustomKeyStoreType

// Definition of datatype DataKeyPairSpec
type DataKeyPairSpec struct {
	Data_DataKeyPairSpec_
}

func (_this DataKeyPairSpec) Get_() Data_DataKeyPairSpec_ {
	return _this.Data_DataKeyPairSpec_
}

type Data_DataKeyPairSpec_ interface {
	isDataKeyPairSpec()
}

type CompanionStruct_DataKeyPairSpec_ struct {
}

var Companion_DataKeyPairSpec_ = CompanionStruct_DataKeyPairSpec_{}

type DataKeyPairSpec_RSA__2048 struct {
}

func (DataKeyPairSpec_RSA__2048) isDataKeyPairSpec() {}

func (CompanionStruct_DataKeyPairSpec_) Create_RSA__2048_() DataKeyPairSpec {
	return DataKeyPairSpec{DataKeyPairSpec_RSA__2048{}}
}

func (_this DataKeyPairSpec) Is_RSA__2048() bool {
	_, ok := _this.Get_().(DataKeyPairSpec_RSA__2048)
	return ok
}

type DataKeyPairSpec_RSA__3072 struct {
}

func (DataKeyPairSpec_RSA__3072) isDataKeyPairSpec() {}

func (CompanionStruct_DataKeyPairSpec_) Create_RSA__3072_() DataKeyPairSpec {
	return DataKeyPairSpec{DataKeyPairSpec_RSA__3072{}}
}

func (_this DataKeyPairSpec) Is_RSA__3072() bool {
	_, ok := _this.Get_().(DataKeyPairSpec_RSA__3072)
	return ok
}

type DataKeyPairSpec_RSA__4096 struct {
}

func (DataKeyPairSpec_RSA__4096) isDataKeyPairSpec() {}

func (CompanionStruct_DataKeyPairSpec_) Create_RSA__4096_() DataKeyPairSpec {
	return DataKeyPairSpec{DataKeyPairSpec_RSA__4096{}}
}

func (_this DataKeyPairSpec) Is_RSA__4096() bool {
	_, ok := _this.Get_().(DataKeyPairSpec_RSA__4096)
	return ok
}

type DataKeyPairSpec_ECC__NIST__P256 struct {
}

func (DataKeyPairSpec_ECC__NIST__P256) isDataKeyPairSpec() {}

func (CompanionStruct_DataKeyPairSpec_) Create_ECC__NIST__P256_() DataKeyPairSpec {
	return DataKeyPairSpec{DataKeyPairSpec_ECC__NIST__P256{}}
}

func (_this DataKeyPairSpec) Is_ECC__NIST__P256() bool {
	_, ok := _this.Get_().(DataKeyPairSpec_ECC__NIST__P256)
	return ok
}

type DataKeyPairSpec_ECC__NIST__P384 struct {
}

func (DataKeyPairSpec_ECC__NIST__P384) isDataKeyPairSpec() {}

func (CompanionStruct_DataKeyPairSpec_) Create_ECC__NIST__P384_() DataKeyPairSpec {
	return DataKeyPairSpec{DataKeyPairSpec_ECC__NIST__P384{}}
}

func (_this DataKeyPairSpec) Is_ECC__NIST__P384() bool {
	_, ok := _this.Get_().(DataKeyPairSpec_ECC__NIST__P384)
	return ok
}

type DataKeyPairSpec_ECC__NIST__P521 struct {
}

func (DataKeyPairSpec_ECC__NIST__P521) isDataKeyPairSpec() {}

func (CompanionStruct_DataKeyPairSpec_) Create_ECC__NIST__P521_() DataKeyPairSpec {
	return DataKeyPairSpec{DataKeyPairSpec_ECC__NIST__P521{}}
}

func (_this DataKeyPairSpec) Is_ECC__NIST__P521() bool {
	_, ok := _this.Get_().(DataKeyPairSpec_ECC__NIST__P521)
	return ok
}

type DataKeyPairSpec_ECC__SECG__P256K1 struct {
}

func (DataKeyPairSpec_ECC__SECG__P256K1) isDataKeyPairSpec() {}

func (CompanionStruct_DataKeyPairSpec_) Create_ECC__SECG__P256K1_() DataKeyPairSpec {
	return DataKeyPairSpec{DataKeyPairSpec_ECC__SECG__P256K1{}}
}

func (_this DataKeyPairSpec) Is_ECC__SECG__P256K1() bool {
	_, ok := _this.Get_().(DataKeyPairSpec_ECC__SECG__P256K1)
	return ok
}

type DataKeyPairSpec_SM2 struct {
}

func (DataKeyPairSpec_SM2) isDataKeyPairSpec() {}

func (CompanionStruct_DataKeyPairSpec_) Create_SM2_() DataKeyPairSpec {
	return DataKeyPairSpec{DataKeyPairSpec_SM2{}}
}

func (_this DataKeyPairSpec) Is_SM2() bool {
	_, ok := _this.Get_().(DataKeyPairSpec_SM2)
	return ok
}

func (CompanionStruct_DataKeyPairSpec_) Default() DataKeyPairSpec {
	return Companion_DataKeyPairSpec_.Create_RSA__2048_()
}

func (_ CompanionStruct_DataKeyPairSpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DataKeyPairSpec_.Create_RSA__2048_(), true
		case 1:
			return Companion_DataKeyPairSpec_.Create_RSA__3072_(), true
		case 2:
			return Companion_DataKeyPairSpec_.Create_RSA__4096_(), true
		case 3:
			return Companion_DataKeyPairSpec_.Create_ECC__NIST__P256_(), true
		case 4:
			return Companion_DataKeyPairSpec_.Create_ECC__NIST__P384_(), true
		case 5:
			return Companion_DataKeyPairSpec_.Create_ECC__NIST__P521_(), true
		case 6:
			return Companion_DataKeyPairSpec_.Create_ECC__SECG__P256K1_(), true
		case 7:
			return Companion_DataKeyPairSpec_.Create_SM2_(), true
		default:
			return DataKeyPairSpec{}, false
		}
	}
}

func (_this DataKeyPairSpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DataKeyPairSpec_RSA__2048:
		{
			return "ComAmazonawsKmsTypes.DataKeyPairSpec.RSA_2048"
		}
	case DataKeyPairSpec_RSA__3072:
		{
			return "ComAmazonawsKmsTypes.DataKeyPairSpec.RSA_3072"
		}
	case DataKeyPairSpec_RSA__4096:
		{
			return "ComAmazonawsKmsTypes.DataKeyPairSpec.RSA_4096"
		}
	case DataKeyPairSpec_ECC__NIST__P256:
		{
			return "ComAmazonawsKmsTypes.DataKeyPairSpec.ECC_NIST_P256"
		}
	case DataKeyPairSpec_ECC__NIST__P384:
		{
			return "ComAmazonawsKmsTypes.DataKeyPairSpec.ECC_NIST_P384"
		}
	case DataKeyPairSpec_ECC__NIST__P521:
		{
			return "ComAmazonawsKmsTypes.DataKeyPairSpec.ECC_NIST_P521"
		}
	case DataKeyPairSpec_ECC__SECG__P256K1:
		{
			return "ComAmazonawsKmsTypes.DataKeyPairSpec.ECC_SECG_P256K1"
		}
	case DataKeyPairSpec_SM2:
		{
			return "ComAmazonawsKmsTypes.DataKeyPairSpec.SM2"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DataKeyPairSpec) Equals(other DataKeyPairSpec) bool {
	switch _this.Get_().(type) {
	case DataKeyPairSpec_RSA__2048:
		{
			_, ok := other.Get_().(DataKeyPairSpec_RSA__2048)
			return ok
		}
	case DataKeyPairSpec_RSA__3072:
		{
			_, ok := other.Get_().(DataKeyPairSpec_RSA__3072)
			return ok
		}
	case DataKeyPairSpec_RSA__4096:
		{
			_, ok := other.Get_().(DataKeyPairSpec_RSA__4096)
			return ok
		}
	case DataKeyPairSpec_ECC__NIST__P256:
		{
			_, ok := other.Get_().(DataKeyPairSpec_ECC__NIST__P256)
			return ok
		}
	case DataKeyPairSpec_ECC__NIST__P384:
		{
			_, ok := other.Get_().(DataKeyPairSpec_ECC__NIST__P384)
			return ok
		}
	case DataKeyPairSpec_ECC__NIST__P521:
		{
			_, ok := other.Get_().(DataKeyPairSpec_ECC__NIST__P521)
			return ok
		}
	case DataKeyPairSpec_ECC__SECG__P256K1:
		{
			_, ok := other.Get_().(DataKeyPairSpec_ECC__SECG__P256K1)
			return ok
		}
	case DataKeyPairSpec_SM2:
		{
			_, ok := other.Get_().(DataKeyPairSpec_SM2)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DataKeyPairSpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DataKeyPairSpec)
	return ok && _this.Equals(typed)
}

func Type_DataKeyPairSpec_() _dafny.TypeDescriptor {
	return type_DataKeyPairSpec_{}
}

type type_DataKeyPairSpec_ struct {
}

func (_this type_DataKeyPairSpec_) Default() interface{} {
	return Companion_DataKeyPairSpec_.Default()
}

func (_this type_DataKeyPairSpec_) String() string {
	return "ComAmazonawsKmsTypes.DataKeyPairSpec"
}
func (_this DataKeyPairSpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DataKeyPairSpec{}

// End of datatype DataKeyPairSpec

// Definition of datatype DataKeySpec
type DataKeySpec struct {
	Data_DataKeySpec_
}

func (_this DataKeySpec) Get_() Data_DataKeySpec_ {
	return _this.Data_DataKeySpec_
}

type Data_DataKeySpec_ interface {
	isDataKeySpec()
}

type CompanionStruct_DataKeySpec_ struct {
}

var Companion_DataKeySpec_ = CompanionStruct_DataKeySpec_{}

type DataKeySpec_AES__256 struct {
}

func (DataKeySpec_AES__256) isDataKeySpec() {}

func (CompanionStruct_DataKeySpec_) Create_AES__256_() DataKeySpec {
	return DataKeySpec{DataKeySpec_AES__256{}}
}

func (_this DataKeySpec) Is_AES__256() bool {
	_, ok := _this.Get_().(DataKeySpec_AES__256)
	return ok
}

type DataKeySpec_AES__128 struct {
}

func (DataKeySpec_AES__128) isDataKeySpec() {}

func (CompanionStruct_DataKeySpec_) Create_AES__128_() DataKeySpec {
	return DataKeySpec{DataKeySpec_AES__128{}}
}

func (_this DataKeySpec) Is_AES__128() bool {
	_, ok := _this.Get_().(DataKeySpec_AES__128)
	return ok
}

func (CompanionStruct_DataKeySpec_) Default() DataKeySpec {
	return Companion_DataKeySpec_.Create_AES__256_()
}

func (_ CompanionStruct_DataKeySpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DataKeySpec_.Create_AES__256_(), true
		case 1:
			return Companion_DataKeySpec_.Create_AES__128_(), true
		default:
			return DataKeySpec{}, false
		}
	}
}

func (_this DataKeySpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DataKeySpec_AES__256:
		{
			return "ComAmazonawsKmsTypes.DataKeySpec.AES_256"
		}
	case DataKeySpec_AES__128:
		{
			return "ComAmazonawsKmsTypes.DataKeySpec.AES_128"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DataKeySpec) Equals(other DataKeySpec) bool {
	switch _this.Get_().(type) {
	case DataKeySpec_AES__256:
		{
			_, ok := other.Get_().(DataKeySpec_AES__256)
			return ok
		}
	case DataKeySpec_AES__128:
		{
			_, ok := other.Get_().(DataKeySpec_AES__128)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DataKeySpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DataKeySpec)
	return ok && _this.Equals(typed)
}

func Type_DataKeySpec_() _dafny.TypeDescriptor {
	return type_DataKeySpec_{}
}

type type_DataKeySpec_ struct {
}

func (_this type_DataKeySpec_) Default() interface{} {
	return Companion_DataKeySpec_.Default()
}

func (_this type_DataKeySpec_) String() string {
	return "ComAmazonawsKmsTypes.DataKeySpec"
}
func (_this DataKeySpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DataKeySpec{}

// End of datatype DataKeySpec

// Definition of datatype DecryptRequest
type DecryptRequest struct {
	Data_DecryptRequest_
}

func (_this DecryptRequest) Get_() Data_DecryptRequest_ {
	return _this.Data_DecryptRequest_
}

type Data_DecryptRequest_ interface {
	isDecryptRequest()
}

type CompanionStruct_DecryptRequest_ struct {
}

var Companion_DecryptRequest_ = CompanionStruct_DecryptRequest_{}

type DecryptRequest_DecryptRequest struct {
	CiphertextBlob      _dafny.Sequence
	EncryptionContext   m_Wrappers.Option
	GrantTokens         m_Wrappers.Option
	KeyId               m_Wrappers.Option
	EncryptionAlgorithm m_Wrappers.Option
	Recipient           m_Wrappers.Option
	DryRun              m_Wrappers.Option
}

func (DecryptRequest_DecryptRequest) isDecryptRequest() {}

func (CompanionStruct_DecryptRequest_) Create_DecryptRequest_(CiphertextBlob _dafny.Sequence, EncryptionContext m_Wrappers.Option, GrantTokens m_Wrappers.Option, KeyId m_Wrappers.Option, EncryptionAlgorithm m_Wrappers.Option, Recipient m_Wrappers.Option, DryRun m_Wrappers.Option) DecryptRequest {
	return DecryptRequest{DecryptRequest_DecryptRequest{CiphertextBlob, EncryptionContext, GrantTokens, KeyId, EncryptionAlgorithm, Recipient, DryRun}}
}

func (_this DecryptRequest) Is_DecryptRequest() bool {
	_, ok := _this.Get_().(DecryptRequest_DecryptRequest)
	return ok
}

func (CompanionStruct_DecryptRequest_) Default() DecryptRequest {
	return Companion_DecryptRequest_.Create_DecryptRequest_(_dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DecryptRequest) Dtor_CiphertextBlob() _dafny.Sequence {
	return _this.Get_().(DecryptRequest_DecryptRequest).CiphertextBlob
}

func (_this DecryptRequest) Dtor_EncryptionContext() m_Wrappers.Option {
	return _this.Get_().(DecryptRequest_DecryptRequest).EncryptionContext
}

func (_this DecryptRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(DecryptRequest_DecryptRequest).GrantTokens
}

func (_this DecryptRequest) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(DecryptRequest_DecryptRequest).KeyId
}

func (_this DecryptRequest) Dtor_EncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(DecryptRequest_DecryptRequest).EncryptionAlgorithm
}

func (_this DecryptRequest) Dtor_Recipient() m_Wrappers.Option {
	return _this.Get_().(DecryptRequest_DecryptRequest).Recipient
}

func (_this DecryptRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(DecryptRequest_DecryptRequest).DryRun
}

func (_this DecryptRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptRequest_DecryptRequest:
		{
			return "ComAmazonawsKmsTypes.DecryptRequest.DecryptRequest" + "(" + _dafny.String(data.CiphertextBlob) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.EncryptionAlgorithm) + ", " + _dafny.String(data.Recipient) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptRequest) Equals(other DecryptRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptRequest_DecryptRequest:
		{
			data2, ok := other.Get_().(DecryptRequest_DecryptRequest)
			return ok && data1.CiphertextBlob.Equals(data2.CiphertextBlob) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.KeyId.Equals(data2.KeyId) && data1.EncryptionAlgorithm.Equals(data2.EncryptionAlgorithm) && data1.Recipient.Equals(data2.Recipient) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptRequest)
	return ok && _this.Equals(typed)
}

func Type_DecryptRequest_() _dafny.TypeDescriptor {
	return type_DecryptRequest_{}
}

type type_DecryptRequest_ struct {
}

func (_this type_DecryptRequest_) Default() interface{} {
	return Companion_DecryptRequest_.Default()
}

func (_this type_DecryptRequest_) String() string {
	return "ComAmazonawsKmsTypes.DecryptRequest"
}
func (_this DecryptRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptRequest{}

// End of datatype DecryptRequest

// Definition of datatype DecryptResponse
type DecryptResponse struct {
	Data_DecryptResponse_
}

func (_this DecryptResponse) Get_() Data_DecryptResponse_ {
	return _this.Data_DecryptResponse_
}

type Data_DecryptResponse_ interface {
	isDecryptResponse()
}

type CompanionStruct_DecryptResponse_ struct {
}

var Companion_DecryptResponse_ = CompanionStruct_DecryptResponse_{}

type DecryptResponse_DecryptResponse struct {
	KeyId                  m_Wrappers.Option
	Plaintext              m_Wrappers.Option
	EncryptionAlgorithm    m_Wrappers.Option
	CiphertextForRecipient m_Wrappers.Option
}

func (DecryptResponse_DecryptResponse) isDecryptResponse() {}

func (CompanionStruct_DecryptResponse_) Create_DecryptResponse_(KeyId m_Wrappers.Option, Plaintext m_Wrappers.Option, EncryptionAlgorithm m_Wrappers.Option, CiphertextForRecipient m_Wrappers.Option) DecryptResponse {
	return DecryptResponse{DecryptResponse_DecryptResponse{KeyId, Plaintext, EncryptionAlgorithm, CiphertextForRecipient}}
}

func (_this DecryptResponse) Is_DecryptResponse() bool {
	_, ok := _this.Get_().(DecryptResponse_DecryptResponse)
	return ok
}

func (CompanionStruct_DecryptResponse_) Default() DecryptResponse {
	return Companion_DecryptResponse_.Create_DecryptResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DecryptResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(DecryptResponse_DecryptResponse).KeyId
}

func (_this DecryptResponse) Dtor_Plaintext() m_Wrappers.Option {
	return _this.Get_().(DecryptResponse_DecryptResponse).Plaintext
}

func (_this DecryptResponse) Dtor_EncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(DecryptResponse_DecryptResponse).EncryptionAlgorithm
}

func (_this DecryptResponse) Dtor_CiphertextForRecipient() m_Wrappers.Option {
	return _this.Get_().(DecryptResponse_DecryptResponse).CiphertextForRecipient
}

func (_this DecryptResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptResponse_DecryptResponse:
		{
			return "ComAmazonawsKmsTypes.DecryptResponse.DecryptResponse" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Plaintext) + ", " + _dafny.String(data.EncryptionAlgorithm) + ", " + _dafny.String(data.CiphertextForRecipient) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptResponse) Equals(other DecryptResponse) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptResponse_DecryptResponse:
		{
			data2, ok := other.Get_().(DecryptResponse_DecryptResponse)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Plaintext.Equals(data2.Plaintext) && data1.EncryptionAlgorithm.Equals(data2.EncryptionAlgorithm) && data1.CiphertextForRecipient.Equals(data2.CiphertextForRecipient)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptResponse)
	return ok && _this.Equals(typed)
}

func Type_DecryptResponse_() _dafny.TypeDescriptor {
	return type_DecryptResponse_{}
}

type type_DecryptResponse_ struct {
}

func (_this type_DecryptResponse_) Default() interface{} {
	return Companion_DecryptResponse_.Default()
}

func (_this type_DecryptResponse_) String() string {
	return "ComAmazonawsKmsTypes.DecryptResponse"
}
func (_this DecryptResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptResponse{}

// End of datatype DecryptResponse

// Definition of datatype DeleteAliasRequest
type DeleteAliasRequest struct {
	Data_DeleteAliasRequest_
}

func (_this DeleteAliasRequest) Get_() Data_DeleteAliasRequest_ {
	return _this.Data_DeleteAliasRequest_
}

type Data_DeleteAliasRequest_ interface {
	isDeleteAliasRequest()
}

type CompanionStruct_DeleteAliasRequest_ struct {
}

var Companion_DeleteAliasRequest_ = CompanionStruct_DeleteAliasRequest_{}

type DeleteAliasRequest_DeleteAliasRequest struct {
	AliasName _dafny.Sequence
}

func (DeleteAliasRequest_DeleteAliasRequest) isDeleteAliasRequest() {}

func (CompanionStruct_DeleteAliasRequest_) Create_DeleteAliasRequest_(AliasName _dafny.Sequence) DeleteAliasRequest {
	return DeleteAliasRequest{DeleteAliasRequest_DeleteAliasRequest{AliasName}}
}

func (_this DeleteAliasRequest) Is_DeleteAliasRequest() bool {
	_, ok := _this.Get_().(DeleteAliasRequest_DeleteAliasRequest)
	return ok
}

func (CompanionStruct_DeleteAliasRequest_) Default() DeleteAliasRequest {
	return Companion_DeleteAliasRequest_.Create_DeleteAliasRequest_(_dafny.EmptySeq.SetString())
}

func (_this DeleteAliasRequest) Dtor_AliasName() _dafny.Sequence {
	return _this.Get_().(DeleteAliasRequest_DeleteAliasRequest).AliasName
}

func (_this DeleteAliasRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteAliasRequest_DeleteAliasRequest:
		{
			return "ComAmazonawsKmsTypes.DeleteAliasRequest.DeleteAliasRequest" + "(" + _dafny.String(data.AliasName) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteAliasRequest) Equals(other DeleteAliasRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DeleteAliasRequest_DeleteAliasRequest:
		{
			data2, ok := other.Get_().(DeleteAliasRequest_DeleteAliasRequest)
			return ok && data1.AliasName.Equals(data2.AliasName)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteAliasRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteAliasRequest)
	return ok && _this.Equals(typed)
}

func Type_DeleteAliasRequest_() _dafny.TypeDescriptor {
	return type_DeleteAliasRequest_{}
}

type type_DeleteAliasRequest_ struct {
}

func (_this type_DeleteAliasRequest_) Default() interface{} {
	return Companion_DeleteAliasRequest_.Default()
}

func (_this type_DeleteAliasRequest_) String() string {
	return "ComAmazonawsKmsTypes.DeleteAliasRequest"
}
func (_this DeleteAliasRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteAliasRequest{}

// End of datatype DeleteAliasRequest

// Definition of datatype DeleteCustomKeyStoreRequest
type DeleteCustomKeyStoreRequest struct {
	Data_DeleteCustomKeyStoreRequest_
}

func (_this DeleteCustomKeyStoreRequest) Get_() Data_DeleteCustomKeyStoreRequest_ {
	return _this.Data_DeleteCustomKeyStoreRequest_
}

type Data_DeleteCustomKeyStoreRequest_ interface {
	isDeleteCustomKeyStoreRequest()
}

type CompanionStruct_DeleteCustomKeyStoreRequest_ struct {
}

var Companion_DeleteCustomKeyStoreRequest_ = CompanionStruct_DeleteCustomKeyStoreRequest_{}

type DeleteCustomKeyStoreRequest_DeleteCustomKeyStoreRequest struct {
	CustomKeyStoreId _dafny.Sequence
}

func (DeleteCustomKeyStoreRequest_DeleteCustomKeyStoreRequest) isDeleteCustomKeyStoreRequest() {}

func (CompanionStruct_DeleteCustomKeyStoreRequest_) Create_DeleteCustomKeyStoreRequest_(CustomKeyStoreId _dafny.Sequence) DeleteCustomKeyStoreRequest {
	return DeleteCustomKeyStoreRequest{DeleteCustomKeyStoreRequest_DeleteCustomKeyStoreRequest{CustomKeyStoreId}}
}

func (_this DeleteCustomKeyStoreRequest) Is_DeleteCustomKeyStoreRequest() bool {
	_, ok := _this.Get_().(DeleteCustomKeyStoreRequest_DeleteCustomKeyStoreRequest)
	return ok
}

func (CompanionStruct_DeleteCustomKeyStoreRequest_) Default() DeleteCustomKeyStoreRequest {
	return Companion_DeleteCustomKeyStoreRequest_.Create_DeleteCustomKeyStoreRequest_(_dafny.EmptySeq.SetString())
}

func (_this DeleteCustomKeyStoreRequest) Dtor_CustomKeyStoreId() _dafny.Sequence {
	return _this.Get_().(DeleteCustomKeyStoreRequest_DeleteCustomKeyStoreRequest).CustomKeyStoreId
}

func (_this DeleteCustomKeyStoreRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteCustomKeyStoreRequest_DeleteCustomKeyStoreRequest:
		{
			return "ComAmazonawsKmsTypes.DeleteCustomKeyStoreRequest.DeleteCustomKeyStoreRequest" + "(" + _dafny.String(data.CustomKeyStoreId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteCustomKeyStoreRequest) Equals(other DeleteCustomKeyStoreRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DeleteCustomKeyStoreRequest_DeleteCustomKeyStoreRequest:
		{
			data2, ok := other.Get_().(DeleteCustomKeyStoreRequest_DeleteCustomKeyStoreRequest)
			return ok && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteCustomKeyStoreRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteCustomKeyStoreRequest)
	return ok && _this.Equals(typed)
}

func Type_DeleteCustomKeyStoreRequest_() _dafny.TypeDescriptor {
	return type_DeleteCustomKeyStoreRequest_{}
}

type type_DeleteCustomKeyStoreRequest_ struct {
}

func (_this type_DeleteCustomKeyStoreRequest_) Default() interface{} {
	return Companion_DeleteCustomKeyStoreRequest_.Default()
}

func (_this type_DeleteCustomKeyStoreRequest_) String() string {
	return "ComAmazonawsKmsTypes.DeleteCustomKeyStoreRequest"
}
func (_this DeleteCustomKeyStoreRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteCustomKeyStoreRequest{}

// End of datatype DeleteCustomKeyStoreRequest

// Definition of datatype DeleteCustomKeyStoreResponse
type DeleteCustomKeyStoreResponse struct {
	Data_DeleteCustomKeyStoreResponse_
}

func (_this DeleteCustomKeyStoreResponse) Get_() Data_DeleteCustomKeyStoreResponse_ {
	return _this.Data_DeleteCustomKeyStoreResponse_
}

type Data_DeleteCustomKeyStoreResponse_ interface {
	isDeleteCustomKeyStoreResponse()
}

type CompanionStruct_DeleteCustomKeyStoreResponse_ struct {
}

var Companion_DeleteCustomKeyStoreResponse_ = CompanionStruct_DeleteCustomKeyStoreResponse_{}

type DeleteCustomKeyStoreResponse_DeleteCustomKeyStoreResponse struct {
}

func (DeleteCustomKeyStoreResponse_DeleteCustomKeyStoreResponse) isDeleteCustomKeyStoreResponse() {}

func (CompanionStruct_DeleteCustomKeyStoreResponse_) Create_DeleteCustomKeyStoreResponse_() DeleteCustomKeyStoreResponse {
	return DeleteCustomKeyStoreResponse{DeleteCustomKeyStoreResponse_DeleteCustomKeyStoreResponse{}}
}

func (_this DeleteCustomKeyStoreResponse) Is_DeleteCustomKeyStoreResponse() bool {
	_, ok := _this.Get_().(DeleteCustomKeyStoreResponse_DeleteCustomKeyStoreResponse)
	return ok
}

func (CompanionStruct_DeleteCustomKeyStoreResponse_) Default() DeleteCustomKeyStoreResponse {
	return Companion_DeleteCustomKeyStoreResponse_.Create_DeleteCustomKeyStoreResponse_()
}

func (_ CompanionStruct_DeleteCustomKeyStoreResponse_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DeleteCustomKeyStoreResponse_.Create_DeleteCustomKeyStoreResponse_(), true
		default:
			return DeleteCustomKeyStoreResponse{}, false
		}
	}
}

func (_this DeleteCustomKeyStoreResponse) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteCustomKeyStoreResponse_DeleteCustomKeyStoreResponse:
		{
			return "ComAmazonawsKmsTypes.DeleteCustomKeyStoreResponse.DeleteCustomKeyStoreResponse"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteCustomKeyStoreResponse) Equals(other DeleteCustomKeyStoreResponse) bool {
	switch _this.Get_().(type) {
	case DeleteCustomKeyStoreResponse_DeleteCustomKeyStoreResponse:
		{
			_, ok := other.Get_().(DeleteCustomKeyStoreResponse_DeleteCustomKeyStoreResponse)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteCustomKeyStoreResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteCustomKeyStoreResponse)
	return ok && _this.Equals(typed)
}

func Type_DeleteCustomKeyStoreResponse_() _dafny.TypeDescriptor {
	return type_DeleteCustomKeyStoreResponse_{}
}

type type_DeleteCustomKeyStoreResponse_ struct {
}

func (_this type_DeleteCustomKeyStoreResponse_) Default() interface{} {
	return Companion_DeleteCustomKeyStoreResponse_.Default()
}

func (_this type_DeleteCustomKeyStoreResponse_) String() string {
	return "ComAmazonawsKmsTypes.DeleteCustomKeyStoreResponse"
}
func (_this DeleteCustomKeyStoreResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteCustomKeyStoreResponse{}

// End of datatype DeleteCustomKeyStoreResponse

// Definition of datatype DeleteImportedKeyMaterialRequest
type DeleteImportedKeyMaterialRequest struct {
	Data_DeleteImportedKeyMaterialRequest_
}

func (_this DeleteImportedKeyMaterialRequest) Get_() Data_DeleteImportedKeyMaterialRequest_ {
	return _this.Data_DeleteImportedKeyMaterialRequest_
}

type Data_DeleteImportedKeyMaterialRequest_ interface {
	isDeleteImportedKeyMaterialRequest()
}

type CompanionStruct_DeleteImportedKeyMaterialRequest_ struct {
}

var Companion_DeleteImportedKeyMaterialRequest_ = CompanionStruct_DeleteImportedKeyMaterialRequest_{}

type DeleteImportedKeyMaterialRequest_DeleteImportedKeyMaterialRequest struct {
	KeyId _dafny.Sequence
}

func (DeleteImportedKeyMaterialRequest_DeleteImportedKeyMaterialRequest) isDeleteImportedKeyMaterialRequest() {
}

func (CompanionStruct_DeleteImportedKeyMaterialRequest_) Create_DeleteImportedKeyMaterialRequest_(KeyId _dafny.Sequence) DeleteImportedKeyMaterialRequest {
	return DeleteImportedKeyMaterialRequest{DeleteImportedKeyMaterialRequest_DeleteImportedKeyMaterialRequest{KeyId}}
}

func (_this DeleteImportedKeyMaterialRequest) Is_DeleteImportedKeyMaterialRequest() bool {
	_, ok := _this.Get_().(DeleteImportedKeyMaterialRequest_DeleteImportedKeyMaterialRequest)
	return ok
}

func (CompanionStruct_DeleteImportedKeyMaterialRequest_) Default() DeleteImportedKeyMaterialRequest {
	return Companion_DeleteImportedKeyMaterialRequest_.Create_DeleteImportedKeyMaterialRequest_(_dafny.EmptySeq.SetString())
}

func (_this DeleteImportedKeyMaterialRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(DeleteImportedKeyMaterialRequest_DeleteImportedKeyMaterialRequest).KeyId
}

func (_this DeleteImportedKeyMaterialRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeleteImportedKeyMaterialRequest_DeleteImportedKeyMaterialRequest:
		{
			return "ComAmazonawsKmsTypes.DeleteImportedKeyMaterialRequest.DeleteImportedKeyMaterialRequest" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeleteImportedKeyMaterialRequest) Equals(other DeleteImportedKeyMaterialRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DeleteImportedKeyMaterialRequest_DeleteImportedKeyMaterialRequest:
		{
			data2, ok := other.Get_().(DeleteImportedKeyMaterialRequest_DeleteImportedKeyMaterialRequest)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeleteImportedKeyMaterialRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeleteImportedKeyMaterialRequest)
	return ok && _this.Equals(typed)
}

func Type_DeleteImportedKeyMaterialRequest_() _dafny.TypeDescriptor {
	return type_DeleteImportedKeyMaterialRequest_{}
}

type type_DeleteImportedKeyMaterialRequest_ struct {
}

func (_this type_DeleteImportedKeyMaterialRequest_) Default() interface{} {
	return Companion_DeleteImportedKeyMaterialRequest_.Default()
}

func (_this type_DeleteImportedKeyMaterialRequest_) String() string {
	return "ComAmazonawsKmsTypes.DeleteImportedKeyMaterialRequest"
}
func (_this DeleteImportedKeyMaterialRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeleteImportedKeyMaterialRequest{}

// End of datatype DeleteImportedKeyMaterialRequest

// Definition of datatype DeriveSharedSecretRequest
type DeriveSharedSecretRequest struct {
	Data_DeriveSharedSecretRequest_
}

func (_this DeriveSharedSecretRequest) Get_() Data_DeriveSharedSecretRequest_ {
	return _this.Data_DeriveSharedSecretRequest_
}

type Data_DeriveSharedSecretRequest_ interface {
	isDeriveSharedSecretRequest()
}

type CompanionStruct_DeriveSharedSecretRequest_ struct {
}

var Companion_DeriveSharedSecretRequest_ = CompanionStruct_DeriveSharedSecretRequest_{}

type DeriveSharedSecretRequest_DeriveSharedSecretRequest struct {
	KeyId                 _dafny.Sequence
	KeyAgreementAlgorithm KeyAgreementAlgorithmSpec
	PublicKey             _dafny.Sequence
	GrantTokens           m_Wrappers.Option
	DryRun                m_Wrappers.Option
	Recipient             m_Wrappers.Option
}

func (DeriveSharedSecretRequest_DeriveSharedSecretRequest) isDeriveSharedSecretRequest() {}

func (CompanionStruct_DeriveSharedSecretRequest_) Create_DeriveSharedSecretRequest_(KeyId _dafny.Sequence, KeyAgreementAlgorithm KeyAgreementAlgorithmSpec, PublicKey _dafny.Sequence, GrantTokens m_Wrappers.Option, DryRun m_Wrappers.Option, Recipient m_Wrappers.Option) DeriveSharedSecretRequest {
	return DeriveSharedSecretRequest{DeriveSharedSecretRequest_DeriveSharedSecretRequest{KeyId, KeyAgreementAlgorithm, PublicKey, GrantTokens, DryRun, Recipient}}
}

func (_this DeriveSharedSecretRequest) Is_DeriveSharedSecretRequest() bool {
	_, ok := _this.Get_().(DeriveSharedSecretRequest_DeriveSharedSecretRequest)
	return ok
}

func (CompanionStruct_DeriveSharedSecretRequest_) Default() DeriveSharedSecretRequest {
	return Companion_DeriveSharedSecretRequest_.Create_DeriveSharedSecretRequest_(_dafny.EmptySeq.SetString(), Companion_KeyAgreementAlgorithmSpec_.Default(), _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DeriveSharedSecretRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(DeriveSharedSecretRequest_DeriveSharedSecretRequest).KeyId
}

func (_this DeriveSharedSecretRequest) Dtor_KeyAgreementAlgorithm() KeyAgreementAlgorithmSpec {
	return _this.Get_().(DeriveSharedSecretRequest_DeriveSharedSecretRequest).KeyAgreementAlgorithm
}

func (_this DeriveSharedSecretRequest) Dtor_PublicKey() _dafny.Sequence {
	return _this.Get_().(DeriveSharedSecretRequest_DeriveSharedSecretRequest).PublicKey
}

func (_this DeriveSharedSecretRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(DeriveSharedSecretRequest_DeriveSharedSecretRequest).GrantTokens
}

func (_this DeriveSharedSecretRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(DeriveSharedSecretRequest_DeriveSharedSecretRequest).DryRun
}

func (_this DeriveSharedSecretRequest) Dtor_Recipient() m_Wrappers.Option {
	return _this.Get_().(DeriveSharedSecretRequest_DeriveSharedSecretRequest).Recipient
}

func (_this DeriveSharedSecretRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeriveSharedSecretRequest_DeriveSharedSecretRequest:
		{
			return "ComAmazonawsKmsTypes.DeriveSharedSecretRequest.DeriveSharedSecretRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.KeyAgreementAlgorithm) + ", " + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.DryRun) + ", " + _dafny.String(data.Recipient) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeriveSharedSecretRequest) Equals(other DeriveSharedSecretRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DeriveSharedSecretRequest_DeriveSharedSecretRequest:
		{
			data2, ok := other.Get_().(DeriveSharedSecretRequest_DeriveSharedSecretRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.KeyAgreementAlgorithm.Equals(data2.KeyAgreementAlgorithm) && data1.PublicKey.Equals(data2.PublicKey) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.DryRun.Equals(data2.DryRun) && data1.Recipient.Equals(data2.Recipient)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeriveSharedSecretRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeriveSharedSecretRequest)
	return ok && _this.Equals(typed)
}

func Type_DeriveSharedSecretRequest_() _dafny.TypeDescriptor {
	return type_DeriveSharedSecretRequest_{}
}

type type_DeriveSharedSecretRequest_ struct {
}

func (_this type_DeriveSharedSecretRequest_) Default() interface{} {
	return Companion_DeriveSharedSecretRequest_.Default()
}

func (_this type_DeriveSharedSecretRequest_) String() string {
	return "ComAmazonawsKmsTypes.DeriveSharedSecretRequest"
}
func (_this DeriveSharedSecretRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeriveSharedSecretRequest{}

// End of datatype DeriveSharedSecretRequest

// Definition of datatype DeriveSharedSecretResponse
type DeriveSharedSecretResponse struct {
	Data_DeriveSharedSecretResponse_
}

func (_this DeriveSharedSecretResponse) Get_() Data_DeriveSharedSecretResponse_ {
	return _this.Data_DeriveSharedSecretResponse_
}

type Data_DeriveSharedSecretResponse_ interface {
	isDeriveSharedSecretResponse()
}

type CompanionStruct_DeriveSharedSecretResponse_ struct {
}

var Companion_DeriveSharedSecretResponse_ = CompanionStruct_DeriveSharedSecretResponse_{}

type DeriveSharedSecretResponse_DeriveSharedSecretResponse struct {
	KeyId                  m_Wrappers.Option
	SharedSecret           m_Wrappers.Option
	CiphertextForRecipient m_Wrappers.Option
	KeyAgreementAlgorithm  m_Wrappers.Option
	KeyOrigin              m_Wrappers.Option
}

func (DeriveSharedSecretResponse_DeriveSharedSecretResponse) isDeriveSharedSecretResponse() {}

func (CompanionStruct_DeriveSharedSecretResponse_) Create_DeriveSharedSecretResponse_(KeyId m_Wrappers.Option, SharedSecret m_Wrappers.Option, CiphertextForRecipient m_Wrappers.Option, KeyAgreementAlgorithm m_Wrappers.Option, KeyOrigin m_Wrappers.Option) DeriveSharedSecretResponse {
	return DeriveSharedSecretResponse{DeriveSharedSecretResponse_DeriveSharedSecretResponse{KeyId, SharedSecret, CiphertextForRecipient, KeyAgreementAlgorithm, KeyOrigin}}
}

func (_this DeriveSharedSecretResponse) Is_DeriveSharedSecretResponse() bool {
	_, ok := _this.Get_().(DeriveSharedSecretResponse_DeriveSharedSecretResponse)
	return ok
}

func (CompanionStruct_DeriveSharedSecretResponse_) Default() DeriveSharedSecretResponse {
	return Companion_DeriveSharedSecretResponse_.Create_DeriveSharedSecretResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DeriveSharedSecretResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(DeriveSharedSecretResponse_DeriveSharedSecretResponse).KeyId
}

func (_this DeriveSharedSecretResponse) Dtor_SharedSecret() m_Wrappers.Option {
	return _this.Get_().(DeriveSharedSecretResponse_DeriveSharedSecretResponse).SharedSecret
}

func (_this DeriveSharedSecretResponse) Dtor_CiphertextForRecipient() m_Wrappers.Option {
	return _this.Get_().(DeriveSharedSecretResponse_DeriveSharedSecretResponse).CiphertextForRecipient
}

func (_this DeriveSharedSecretResponse) Dtor_KeyAgreementAlgorithm() m_Wrappers.Option {
	return _this.Get_().(DeriveSharedSecretResponse_DeriveSharedSecretResponse).KeyAgreementAlgorithm
}

func (_this DeriveSharedSecretResponse) Dtor_KeyOrigin() m_Wrappers.Option {
	return _this.Get_().(DeriveSharedSecretResponse_DeriveSharedSecretResponse).KeyOrigin
}

func (_this DeriveSharedSecretResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DeriveSharedSecretResponse_DeriveSharedSecretResponse:
		{
			return "ComAmazonawsKmsTypes.DeriveSharedSecretResponse.DeriveSharedSecretResponse" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.SharedSecret) + ", " + _dafny.String(data.CiphertextForRecipient) + ", " + _dafny.String(data.KeyAgreementAlgorithm) + ", " + _dafny.String(data.KeyOrigin) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DeriveSharedSecretResponse) Equals(other DeriveSharedSecretResponse) bool {
	switch data1 := _this.Get_().(type) {
	case DeriveSharedSecretResponse_DeriveSharedSecretResponse:
		{
			data2, ok := other.Get_().(DeriveSharedSecretResponse_DeriveSharedSecretResponse)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.SharedSecret.Equals(data2.SharedSecret) && data1.CiphertextForRecipient.Equals(data2.CiphertextForRecipient) && data1.KeyAgreementAlgorithm.Equals(data2.KeyAgreementAlgorithm) && data1.KeyOrigin.Equals(data2.KeyOrigin)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DeriveSharedSecretResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DeriveSharedSecretResponse)
	return ok && _this.Equals(typed)
}

func Type_DeriveSharedSecretResponse_() _dafny.TypeDescriptor {
	return type_DeriveSharedSecretResponse_{}
}

type type_DeriveSharedSecretResponse_ struct {
}

func (_this type_DeriveSharedSecretResponse_) Default() interface{} {
	return Companion_DeriveSharedSecretResponse_.Default()
}

func (_this type_DeriveSharedSecretResponse_) String() string {
	return "ComAmazonawsKmsTypes.DeriveSharedSecretResponse"
}
func (_this DeriveSharedSecretResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DeriveSharedSecretResponse{}

// End of datatype DeriveSharedSecretResponse

// Definition of datatype DescribeCustomKeyStoresRequest
type DescribeCustomKeyStoresRequest struct {
	Data_DescribeCustomKeyStoresRequest_
}

func (_this DescribeCustomKeyStoresRequest) Get_() Data_DescribeCustomKeyStoresRequest_ {
	return _this.Data_DescribeCustomKeyStoresRequest_
}

type Data_DescribeCustomKeyStoresRequest_ interface {
	isDescribeCustomKeyStoresRequest()
}

type CompanionStruct_DescribeCustomKeyStoresRequest_ struct {
}

var Companion_DescribeCustomKeyStoresRequest_ = CompanionStruct_DescribeCustomKeyStoresRequest_{}

type DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest struct {
	CustomKeyStoreId   m_Wrappers.Option
	CustomKeyStoreName m_Wrappers.Option
	Limit              m_Wrappers.Option
	Marker             m_Wrappers.Option
}

func (DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest) isDescribeCustomKeyStoresRequest() {
}

func (CompanionStruct_DescribeCustomKeyStoresRequest_) Create_DescribeCustomKeyStoresRequest_(CustomKeyStoreId m_Wrappers.Option, CustomKeyStoreName m_Wrappers.Option, Limit m_Wrappers.Option, Marker m_Wrappers.Option) DescribeCustomKeyStoresRequest {
	return DescribeCustomKeyStoresRequest{DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest{CustomKeyStoreId, CustomKeyStoreName, Limit, Marker}}
}

func (_this DescribeCustomKeyStoresRequest) Is_DescribeCustomKeyStoresRequest() bool {
	_, ok := _this.Get_().(DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest)
	return ok
}

func (CompanionStruct_DescribeCustomKeyStoresRequest_) Default() DescribeCustomKeyStoresRequest {
	return Companion_DescribeCustomKeyStoresRequest_.Create_DescribeCustomKeyStoresRequest_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DescribeCustomKeyStoresRequest) Dtor_CustomKeyStoreId() m_Wrappers.Option {
	return _this.Get_().(DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest).CustomKeyStoreId
}

func (_this DescribeCustomKeyStoresRequest) Dtor_CustomKeyStoreName() m_Wrappers.Option {
	return _this.Get_().(DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest).CustomKeyStoreName
}

func (_this DescribeCustomKeyStoresRequest) Dtor_Limit() m_Wrappers.Option {
	return _this.Get_().(DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest).Limit
}

func (_this DescribeCustomKeyStoresRequest) Dtor_Marker() m_Wrappers.Option {
	return _this.Get_().(DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest).Marker
}

func (_this DescribeCustomKeyStoresRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest:
		{
			return "ComAmazonawsKmsTypes.DescribeCustomKeyStoresRequest.DescribeCustomKeyStoresRequest" + "(" + _dafny.String(data.CustomKeyStoreId) + ", " + _dafny.String(data.CustomKeyStoreName) + ", " + _dafny.String(data.Limit) + ", " + _dafny.String(data.Marker) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DescribeCustomKeyStoresRequest) Equals(other DescribeCustomKeyStoresRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest:
		{
			data2, ok := other.Get_().(DescribeCustomKeyStoresRequest_DescribeCustomKeyStoresRequest)
			return ok && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId) && data1.CustomKeyStoreName.Equals(data2.CustomKeyStoreName) && data1.Limit.Equals(data2.Limit) && data1.Marker.Equals(data2.Marker)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DescribeCustomKeyStoresRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DescribeCustomKeyStoresRequest)
	return ok && _this.Equals(typed)
}

func Type_DescribeCustomKeyStoresRequest_() _dafny.TypeDescriptor {
	return type_DescribeCustomKeyStoresRequest_{}
}

type type_DescribeCustomKeyStoresRequest_ struct {
}

func (_this type_DescribeCustomKeyStoresRequest_) Default() interface{} {
	return Companion_DescribeCustomKeyStoresRequest_.Default()
}

func (_this type_DescribeCustomKeyStoresRequest_) String() string {
	return "ComAmazonawsKmsTypes.DescribeCustomKeyStoresRequest"
}
func (_this DescribeCustomKeyStoresRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DescribeCustomKeyStoresRequest{}

// End of datatype DescribeCustomKeyStoresRequest

// Definition of datatype DescribeCustomKeyStoresResponse
type DescribeCustomKeyStoresResponse struct {
	Data_DescribeCustomKeyStoresResponse_
}

func (_this DescribeCustomKeyStoresResponse) Get_() Data_DescribeCustomKeyStoresResponse_ {
	return _this.Data_DescribeCustomKeyStoresResponse_
}

type Data_DescribeCustomKeyStoresResponse_ interface {
	isDescribeCustomKeyStoresResponse()
}

type CompanionStruct_DescribeCustomKeyStoresResponse_ struct {
}

var Companion_DescribeCustomKeyStoresResponse_ = CompanionStruct_DescribeCustomKeyStoresResponse_{}

type DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse struct {
	CustomKeyStores m_Wrappers.Option
	NextMarker      m_Wrappers.Option
	Truncated       m_Wrappers.Option
}

func (DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse) isDescribeCustomKeyStoresResponse() {
}

func (CompanionStruct_DescribeCustomKeyStoresResponse_) Create_DescribeCustomKeyStoresResponse_(CustomKeyStores m_Wrappers.Option, NextMarker m_Wrappers.Option, Truncated m_Wrappers.Option) DescribeCustomKeyStoresResponse {
	return DescribeCustomKeyStoresResponse{DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse{CustomKeyStores, NextMarker, Truncated}}
}

func (_this DescribeCustomKeyStoresResponse) Is_DescribeCustomKeyStoresResponse() bool {
	_, ok := _this.Get_().(DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse)
	return ok
}

func (CompanionStruct_DescribeCustomKeyStoresResponse_) Default() DescribeCustomKeyStoresResponse {
	return Companion_DescribeCustomKeyStoresResponse_.Create_DescribeCustomKeyStoresResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this DescribeCustomKeyStoresResponse) Dtor_CustomKeyStores() m_Wrappers.Option {
	return _this.Get_().(DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse).CustomKeyStores
}

func (_this DescribeCustomKeyStoresResponse) Dtor_NextMarker() m_Wrappers.Option {
	return _this.Get_().(DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse).NextMarker
}

func (_this DescribeCustomKeyStoresResponse) Dtor_Truncated() m_Wrappers.Option {
	return _this.Get_().(DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse).Truncated
}

func (_this DescribeCustomKeyStoresResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse:
		{
			return "ComAmazonawsKmsTypes.DescribeCustomKeyStoresResponse.DescribeCustomKeyStoresResponse" + "(" + _dafny.String(data.CustomKeyStores) + ", " + _dafny.String(data.NextMarker) + ", " + _dafny.String(data.Truncated) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DescribeCustomKeyStoresResponse) Equals(other DescribeCustomKeyStoresResponse) bool {
	switch data1 := _this.Get_().(type) {
	case DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse:
		{
			data2, ok := other.Get_().(DescribeCustomKeyStoresResponse_DescribeCustomKeyStoresResponse)
			return ok && data1.CustomKeyStores.Equals(data2.CustomKeyStores) && data1.NextMarker.Equals(data2.NextMarker) && data1.Truncated.Equals(data2.Truncated)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DescribeCustomKeyStoresResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DescribeCustomKeyStoresResponse)
	return ok && _this.Equals(typed)
}

func Type_DescribeCustomKeyStoresResponse_() _dafny.TypeDescriptor {
	return type_DescribeCustomKeyStoresResponse_{}
}

type type_DescribeCustomKeyStoresResponse_ struct {
}

func (_this type_DescribeCustomKeyStoresResponse_) Default() interface{} {
	return Companion_DescribeCustomKeyStoresResponse_.Default()
}

func (_this type_DescribeCustomKeyStoresResponse_) String() string {
	return "ComAmazonawsKmsTypes.DescribeCustomKeyStoresResponse"
}
func (_this DescribeCustomKeyStoresResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DescribeCustomKeyStoresResponse{}

// End of datatype DescribeCustomKeyStoresResponse

// Definition of datatype DescribeKeyRequest
type DescribeKeyRequest struct {
	Data_DescribeKeyRequest_
}

func (_this DescribeKeyRequest) Get_() Data_DescribeKeyRequest_ {
	return _this.Data_DescribeKeyRequest_
}

type Data_DescribeKeyRequest_ interface {
	isDescribeKeyRequest()
}

type CompanionStruct_DescribeKeyRequest_ struct {
}

var Companion_DescribeKeyRequest_ = CompanionStruct_DescribeKeyRequest_{}

type DescribeKeyRequest_DescribeKeyRequest struct {
	KeyId       _dafny.Sequence
	GrantTokens m_Wrappers.Option
}

func (DescribeKeyRequest_DescribeKeyRequest) isDescribeKeyRequest() {}

func (CompanionStruct_DescribeKeyRequest_) Create_DescribeKeyRequest_(KeyId _dafny.Sequence, GrantTokens m_Wrappers.Option) DescribeKeyRequest {
	return DescribeKeyRequest{DescribeKeyRequest_DescribeKeyRequest{KeyId, GrantTokens}}
}

func (_this DescribeKeyRequest) Is_DescribeKeyRequest() bool {
	_, ok := _this.Get_().(DescribeKeyRequest_DescribeKeyRequest)
	return ok
}

func (CompanionStruct_DescribeKeyRequest_) Default() DescribeKeyRequest {
	return Companion_DescribeKeyRequest_.Create_DescribeKeyRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this DescribeKeyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(DescribeKeyRequest_DescribeKeyRequest).KeyId
}

func (_this DescribeKeyRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(DescribeKeyRequest_DescribeKeyRequest).GrantTokens
}

func (_this DescribeKeyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DescribeKeyRequest_DescribeKeyRequest:
		{
			return "ComAmazonawsKmsTypes.DescribeKeyRequest.DescribeKeyRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DescribeKeyRequest) Equals(other DescribeKeyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DescribeKeyRequest_DescribeKeyRequest:
		{
			data2, ok := other.Get_().(DescribeKeyRequest_DescribeKeyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DescribeKeyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DescribeKeyRequest)
	return ok && _this.Equals(typed)
}

func Type_DescribeKeyRequest_() _dafny.TypeDescriptor {
	return type_DescribeKeyRequest_{}
}

type type_DescribeKeyRequest_ struct {
}

func (_this type_DescribeKeyRequest_) Default() interface{} {
	return Companion_DescribeKeyRequest_.Default()
}

func (_this type_DescribeKeyRequest_) String() string {
	return "ComAmazonawsKmsTypes.DescribeKeyRequest"
}
func (_this DescribeKeyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DescribeKeyRequest{}

// End of datatype DescribeKeyRequest

// Definition of datatype DescribeKeyResponse
type DescribeKeyResponse struct {
	Data_DescribeKeyResponse_
}

func (_this DescribeKeyResponse) Get_() Data_DescribeKeyResponse_ {
	return _this.Data_DescribeKeyResponse_
}

type Data_DescribeKeyResponse_ interface {
	isDescribeKeyResponse()
}

type CompanionStruct_DescribeKeyResponse_ struct {
}

var Companion_DescribeKeyResponse_ = CompanionStruct_DescribeKeyResponse_{}

type DescribeKeyResponse_DescribeKeyResponse struct {
	KeyMetadata m_Wrappers.Option
}

func (DescribeKeyResponse_DescribeKeyResponse) isDescribeKeyResponse() {}

func (CompanionStruct_DescribeKeyResponse_) Create_DescribeKeyResponse_(KeyMetadata m_Wrappers.Option) DescribeKeyResponse {
	return DescribeKeyResponse{DescribeKeyResponse_DescribeKeyResponse{KeyMetadata}}
}

func (_this DescribeKeyResponse) Is_DescribeKeyResponse() bool {
	_, ok := _this.Get_().(DescribeKeyResponse_DescribeKeyResponse)
	return ok
}

func (CompanionStruct_DescribeKeyResponse_) Default() DescribeKeyResponse {
	return Companion_DescribeKeyResponse_.Create_DescribeKeyResponse_(m_Wrappers.Companion_Option_.Default())
}

func (_this DescribeKeyResponse) Dtor_KeyMetadata() m_Wrappers.Option {
	return _this.Get_().(DescribeKeyResponse_DescribeKeyResponse).KeyMetadata
}

func (_this DescribeKeyResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DescribeKeyResponse_DescribeKeyResponse:
		{
			return "ComAmazonawsKmsTypes.DescribeKeyResponse.DescribeKeyResponse" + "(" + _dafny.String(data.KeyMetadata) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DescribeKeyResponse) Equals(other DescribeKeyResponse) bool {
	switch data1 := _this.Get_().(type) {
	case DescribeKeyResponse_DescribeKeyResponse:
		{
			data2, ok := other.Get_().(DescribeKeyResponse_DescribeKeyResponse)
			return ok && data1.KeyMetadata.Equals(data2.KeyMetadata)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DescribeKeyResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DescribeKeyResponse)
	return ok && _this.Equals(typed)
}

func Type_DescribeKeyResponse_() _dafny.TypeDescriptor {
	return type_DescribeKeyResponse_{}
}

type type_DescribeKeyResponse_ struct {
}

func (_this type_DescribeKeyResponse_) Default() interface{} {
	return Companion_DescribeKeyResponse_.Default()
}

func (_this type_DescribeKeyResponse_) String() string {
	return "ComAmazonawsKmsTypes.DescribeKeyResponse"
}
func (_this DescribeKeyResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DescribeKeyResponse{}

// End of datatype DescribeKeyResponse

// Definition of class DescriptionType
type DescriptionType struct {
}

func New_DescriptionType_() *DescriptionType {
	_this := DescriptionType{}

	return &_this
}

type CompanionStruct_DescriptionType_ struct {
}

var Companion_DescriptionType_ = CompanionStruct_DescriptionType_{}

func (*DescriptionType) String() string {
	return "ComAmazonawsKmsTypes.DescriptionType"
}

// End of class DescriptionType

func Type_DescriptionType_() _dafny.TypeDescriptor {
	return type_DescriptionType_{}
}

type type_DescriptionType_ struct {
}

func (_this type_DescriptionType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_DescriptionType_) String() string {
	return "ComAmazonawsKmsTypes.DescriptionType"
}
func (_this *CompanionStruct_DescriptionType_) Is_(__source _dafny.Sequence) bool {
	var _7_x _dafny.Sequence = (__source)
	_ = _7_x
	return Companion_Default___.IsValid__DescriptionType(_7_x)
}

// Definition of datatype DisableKeyRequest
type DisableKeyRequest struct {
	Data_DisableKeyRequest_
}

func (_this DisableKeyRequest) Get_() Data_DisableKeyRequest_ {
	return _this.Data_DisableKeyRequest_
}

type Data_DisableKeyRequest_ interface {
	isDisableKeyRequest()
}

type CompanionStruct_DisableKeyRequest_ struct {
}

var Companion_DisableKeyRequest_ = CompanionStruct_DisableKeyRequest_{}

type DisableKeyRequest_DisableKeyRequest struct {
	KeyId _dafny.Sequence
}

func (DisableKeyRequest_DisableKeyRequest) isDisableKeyRequest() {}

func (CompanionStruct_DisableKeyRequest_) Create_DisableKeyRequest_(KeyId _dafny.Sequence) DisableKeyRequest {
	return DisableKeyRequest{DisableKeyRequest_DisableKeyRequest{KeyId}}
}

func (_this DisableKeyRequest) Is_DisableKeyRequest() bool {
	_, ok := _this.Get_().(DisableKeyRequest_DisableKeyRequest)
	return ok
}

func (CompanionStruct_DisableKeyRequest_) Default() DisableKeyRequest {
	return Companion_DisableKeyRequest_.Create_DisableKeyRequest_(_dafny.EmptySeq.SetString())
}

func (_this DisableKeyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(DisableKeyRequest_DisableKeyRequest).KeyId
}

func (_this DisableKeyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DisableKeyRequest_DisableKeyRequest:
		{
			return "ComAmazonawsKmsTypes.DisableKeyRequest.DisableKeyRequest" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DisableKeyRequest) Equals(other DisableKeyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DisableKeyRequest_DisableKeyRequest:
		{
			data2, ok := other.Get_().(DisableKeyRequest_DisableKeyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DisableKeyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DisableKeyRequest)
	return ok && _this.Equals(typed)
}

func Type_DisableKeyRequest_() _dafny.TypeDescriptor {
	return type_DisableKeyRequest_{}
}

type type_DisableKeyRequest_ struct {
}

func (_this type_DisableKeyRequest_) Default() interface{} {
	return Companion_DisableKeyRequest_.Default()
}

func (_this type_DisableKeyRequest_) String() string {
	return "ComAmazonawsKmsTypes.DisableKeyRequest"
}
func (_this DisableKeyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DisableKeyRequest{}

// End of datatype DisableKeyRequest

// Definition of datatype DisableKeyRotationRequest
type DisableKeyRotationRequest struct {
	Data_DisableKeyRotationRequest_
}

func (_this DisableKeyRotationRequest) Get_() Data_DisableKeyRotationRequest_ {
	return _this.Data_DisableKeyRotationRequest_
}

type Data_DisableKeyRotationRequest_ interface {
	isDisableKeyRotationRequest()
}

type CompanionStruct_DisableKeyRotationRequest_ struct {
}

var Companion_DisableKeyRotationRequest_ = CompanionStruct_DisableKeyRotationRequest_{}

type DisableKeyRotationRequest_DisableKeyRotationRequest struct {
	KeyId _dafny.Sequence
}

func (DisableKeyRotationRequest_DisableKeyRotationRequest) isDisableKeyRotationRequest() {}

func (CompanionStruct_DisableKeyRotationRequest_) Create_DisableKeyRotationRequest_(KeyId _dafny.Sequence) DisableKeyRotationRequest {
	return DisableKeyRotationRequest{DisableKeyRotationRequest_DisableKeyRotationRequest{KeyId}}
}

func (_this DisableKeyRotationRequest) Is_DisableKeyRotationRequest() bool {
	_, ok := _this.Get_().(DisableKeyRotationRequest_DisableKeyRotationRequest)
	return ok
}

func (CompanionStruct_DisableKeyRotationRequest_) Default() DisableKeyRotationRequest {
	return Companion_DisableKeyRotationRequest_.Create_DisableKeyRotationRequest_(_dafny.EmptySeq.SetString())
}

func (_this DisableKeyRotationRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(DisableKeyRotationRequest_DisableKeyRotationRequest).KeyId
}

func (_this DisableKeyRotationRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DisableKeyRotationRequest_DisableKeyRotationRequest:
		{
			return "ComAmazonawsKmsTypes.DisableKeyRotationRequest.DisableKeyRotationRequest" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DisableKeyRotationRequest) Equals(other DisableKeyRotationRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DisableKeyRotationRequest_DisableKeyRotationRequest:
		{
			data2, ok := other.Get_().(DisableKeyRotationRequest_DisableKeyRotationRequest)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DisableKeyRotationRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DisableKeyRotationRequest)
	return ok && _this.Equals(typed)
}

func Type_DisableKeyRotationRequest_() _dafny.TypeDescriptor {
	return type_DisableKeyRotationRequest_{}
}

type type_DisableKeyRotationRequest_ struct {
}

func (_this type_DisableKeyRotationRequest_) Default() interface{} {
	return Companion_DisableKeyRotationRequest_.Default()
}

func (_this type_DisableKeyRotationRequest_) String() string {
	return "ComAmazonawsKmsTypes.DisableKeyRotationRequest"
}
func (_this DisableKeyRotationRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DisableKeyRotationRequest{}

// End of datatype DisableKeyRotationRequest

// Definition of datatype DisconnectCustomKeyStoreRequest
type DisconnectCustomKeyStoreRequest struct {
	Data_DisconnectCustomKeyStoreRequest_
}

func (_this DisconnectCustomKeyStoreRequest) Get_() Data_DisconnectCustomKeyStoreRequest_ {
	return _this.Data_DisconnectCustomKeyStoreRequest_
}

type Data_DisconnectCustomKeyStoreRequest_ interface {
	isDisconnectCustomKeyStoreRequest()
}

type CompanionStruct_DisconnectCustomKeyStoreRequest_ struct {
}

var Companion_DisconnectCustomKeyStoreRequest_ = CompanionStruct_DisconnectCustomKeyStoreRequest_{}

type DisconnectCustomKeyStoreRequest_DisconnectCustomKeyStoreRequest struct {
	CustomKeyStoreId _dafny.Sequence
}

func (DisconnectCustomKeyStoreRequest_DisconnectCustomKeyStoreRequest) isDisconnectCustomKeyStoreRequest() {
}

func (CompanionStruct_DisconnectCustomKeyStoreRequest_) Create_DisconnectCustomKeyStoreRequest_(CustomKeyStoreId _dafny.Sequence) DisconnectCustomKeyStoreRequest {
	return DisconnectCustomKeyStoreRequest{DisconnectCustomKeyStoreRequest_DisconnectCustomKeyStoreRequest{CustomKeyStoreId}}
}

func (_this DisconnectCustomKeyStoreRequest) Is_DisconnectCustomKeyStoreRequest() bool {
	_, ok := _this.Get_().(DisconnectCustomKeyStoreRequest_DisconnectCustomKeyStoreRequest)
	return ok
}

func (CompanionStruct_DisconnectCustomKeyStoreRequest_) Default() DisconnectCustomKeyStoreRequest {
	return Companion_DisconnectCustomKeyStoreRequest_.Create_DisconnectCustomKeyStoreRequest_(_dafny.EmptySeq.SetString())
}

func (_this DisconnectCustomKeyStoreRequest) Dtor_CustomKeyStoreId() _dafny.Sequence {
	return _this.Get_().(DisconnectCustomKeyStoreRequest_DisconnectCustomKeyStoreRequest).CustomKeyStoreId
}

func (_this DisconnectCustomKeyStoreRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DisconnectCustomKeyStoreRequest_DisconnectCustomKeyStoreRequest:
		{
			return "ComAmazonawsKmsTypes.DisconnectCustomKeyStoreRequest.DisconnectCustomKeyStoreRequest" + "(" + _dafny.String(data.CustomKeyStoreId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DisconnectCustomKeyStoreRequest) Equals(other DisconnectCustomKeyStoreRequest) bool {
	switch data1 := _this.Get_().(type) {
	case DisconnectCustomKeyStoreRequest_DisconnectCustomKeyStoreRequest:
		{
			data2, ok := other.Get_().(DisconnectCustomKeyStoreRequest_DisconnectCustomKeyStoreRequest)
			return ok && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DisconnectCustomKeyStoreRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DisconnectCustomKeyStoreRequest)
	return ok && _this.Equals(typed)
}

func Type_DisconnectCustomKeyStoreRequest_() _dafny.TypeDescriptor {
	return type_DisconnectCustomKeyStoreRequest_{}
}

type type_DisconnectCustomKeyStoreRequest_ struct {
}

func (_this type_DisconnectCustomKeyStoreRequest_) Default() interface{} {
	return Companion_DisconnectCustomKeyStoreRequest_.Default()
}

func (_this type_DisconnectCustomKeyStoreRequest_) String() string {
	return "ComAmazonawsKmsTypes.DisconnectCustomKeyStoreRequest"
}
func (_this DisconnectCustomKeyStoreRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DisconnectCustomKeyStoreRequest{}

// End of datatype DisconnectCustomKeyStoreRequest

// Definition of datatype DisconnectCustomKeyStoreResponse
type DisconnectCustomKeyStoreResponse struct {
	Data_DisconnectCustomKeyStoreResponse_
}

func (_this DisconnectCustomKeyStoreResponse) Get_() Data_DisconnectCustomKeyStoreResponse_ {
	return _this.Data_DisconnectCustomKeyStoreResponse_
}

type Data_DisconnectCustomKeyStoreResponse_ interface {
	isDisconnectCustomKeyStoreResponse()
}

type CompanionStruct_DisconnectCustomKeyStoreResponse_ struct {
}

var Companion_DisconnectCustomKeyStoreResponse_ = CompanionStruct_DisconnectCustomKeyStoreResponse_{}

type DisconnectCustomKeyStoreResponse_DisconnectCustomKeyStoreResponse struct {
}

func (DisconnectCustomKeyStoreResponse_DisconnectCustomKeyStoreResponse) isDisconnectCustomKeyStoreResponse() {
}

func (CompanionStruct_DisconnectCustomKeyStoreResponse_) Create_DisconnectCustomKeyStoreResponse_() DisconnectCustomKeyStoreResponse {
	return DisconnectCustomKeyStoreResponse{DisconnectCustomKeyStoreResponse_DisconnectCustomKeyStoreResponse{}}
}

func (_this DisconnectCustomKeyStoreResponse) Is_DisconnectCustomKeyStoreResponse() bool {
	_, ok := _this.Get_().(DisconnectCustomKeyStoreResponse_DisconnectCustomKeyStoreResponse)
	return ok
}

func (CompanionStruct_DisconnectCustomKeyStoreResponse_) Default() DisconnectCustomKeyStoreResponse {
	return Companion_DisconnectCustomKeyStoreResponse_.Create_DisconnectCustomKeyStoreResponse_()
}

func (_ CompanionStruct_DisconnectCustomKeyStoreResponse_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_DisconnectCustomKeyStoreResponse_.Create_DisconnectCustomKeyStoreResponse_(), true
		default:
			return DisconnectCustomKeyStoreResponse{}, false
		}
	}
}

func (_this DisconnectCustomKeyStoreResponse) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case DisconnectCustomKeyStoreResponse_DisconnectCustomKeyStoreResponse:
		{
			return "ComAmazonawsKmsTypes.DisconnectCustomKeyStoreResponse.DisconnectCustomKeyStoreResponse"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DisconnectCustomKeyStoreResponse) Equals(other DisconnectCustomKeyStoreResponse) bool {
	switch _this.Get_().(type) {
	case DisconnectCustomKeyStoreResponse_DisconnectCustomKeyStoreResponse:
		{
			_, ok := other.Get_().(DisconnectCustomKeyStoreResponse_DisconnectCustomKeyStoreResponse)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DisconnectCustomKeyStoreResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DisconnectCustomKeyStoreResponse)
	return ok && _this.Equals(typed)
}

func Type_DisconnectCustomKeyStoreResponse_() _dafny.TypeDescriptor {
	return type_DisconnectCustomKeyStoreResponse_{}
}

type type_DisconnectCustomKeyStoreResponse_ struct {
}

func (_this type_DisconnectCustomKeyStoreResponse_) Default() interface{} {
	return Companion_DisconnectCustomKeyStoreResponse_.Default()
}

func (_this type_DisconnectCustomKeyStoreResponse_) String() string {
	return "ComAmazonawsKmsTypes.DisconnectCustomKeyStoreResponse"
}
func (_this DisconnectCustomKeyStoreResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DisconnectCustomKeyStoreResponse{}

// End of datatype DisconnectCustomKeyStoreResponse

// Definition of datatype EnableKeyRequest
type EnableKeyRequest struct {
	Data_EnableKeyRequest_
}

func (_this EnableKeyRequest) Get_() Data_EnableKeyRequest_ {
	return _this.Data_EnableKeyRequest_
}

type Data_EnableKeyRequest_ interface {
	isEnableKeyRequest()
}

type CompanionStruct_EnableKeyRequest_ struct {
}

var Companion_EnableKeyRequest_ = CompanionStruct_EnableKeyRequest_{}

type EnableKeyRequest_EnableKeyRequest struct {
	KeyId _dafny.Sequence
}

func (EnableKeyRequest_EnableKeyRequest) isEnableKeyRequest() {}

func (CompanionStruct_EnableKeyRequest_) Create_EnableKeyRequest_(KeyId _dafny.Sequence) EnableKeyRequest {
	return EnableKeyRequest{EnableKeyRequest_EnableKeyRequest{KeyId}}
}

func (_this EnableKeyRequest) Is_EnableKeyRequest() bool {
	_, ok := _this.Get_().(EnableKeyRequest_EnableKeyRequest)
	return ok
}

func (CompanionStruct_EnableKeyRequest_) Default() EnableKeyRequest {
	return Companion_EnableKeyRequest_.Create_EnableKeyRequest_(_dafny.EmptySeq.SetString())
}

func (_this EnableKeyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(EnableKeyRequest_EnableKeyRequest).KeyId
}

func (_this EnableKeyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EnableKeyRequest_EnableKeyRequest:
		{
			return "ComAmazonawsKmsTypes.EnableKeyRequest.EnableKeyRequest" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EnableKeyRequest) Equals(other EnableKeyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case EnableKeyRequest_EnableKeyRequest:
		{
			data2, ok := other.Get_().(EnableKeyRequest_EnableKeyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EnableKeyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EnableKeyRequest)
	return ok && _this.Equals(typed)
}

func Type_EnableKeyRequest_() _dafny.TypeDescriptor {
	return type_EnableKeyRequest_{}
}

type type_EnableKeyRequest_ struct {
}

func (_this type_EnableKeyRequest_) Default() interface{} {
	return Companion_EnableKeyRequest_.Default()
}

func (_this type_EnableKeyRequest_) String() string {
	return "ComAmazonawsKmsTypes.EnableKeyRequest"
}
func (_this EnableKeyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EnableKeyRequest{}

// End of datatype EnableKeyRequest

// Definition of datatype EnableKeyRotationRequest
type EnableKeyRotationRequest struct {
	Data_EnableKeyRotationRequest_
}

func (_this EnableKeyRotationRequest) Get_() Data_EnableKeyRotationRequest_ {
	return _this.Data_EnableKeyRotationRequest_
}

type Data_EnableKeyRotationRequest_ interface {
	isEnableKeyRotationRequest()
}

type CompanionStruct_EnableKeyRotationRequest_ struct {
}

var Companion_EnableKeyRotationRequest_ = CompanionStruct_EnableKeyRotationRequest_{}

type EnableKeyRotationRequest_EnableKeyRotationRequest struct {
	KeyId                _dafny.Sequence
	RotationPeriodInDays m_Wrappers.Option
}

func (EnableKeyRotationRequest_EnableKeyRotationRequest) isEnableKeyRotationRequest() {}

func (CompanionStruct_EnableKeyRotationRequest_) Create_EnableKeyRotationRequest_(KeyId _dafny.Sequence, RotationPeriodInDays m_Wrappers.Option) EnableKeyRotationRequest {
	return EnableKeyRotationRequest{EnableKeyRotationRequest_EnableKeyRotationRequest{KeyId, RotationPeriodInDays}}
}

func (_this EnableKeyRotationRequest) Is_EnableKeyRotationRequest() bool {
	_, ok := _this.Get_().(EnableKeyRotationRequest_EnableKeyRotationRequest)
	return ok
}

func (CompanionStruct_EnableKeyRotationRequest_) Default() EnableKeyRotationRequest {
	return Companion_EnableKeyRotationRequest_.Create_EnableKeyRotationRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this EnableKeyRotationRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(EnableKeyRotationRequest_EnableKeyRotationRequest).KeyId
}

func (_this EnableKeyRotationRequest) Dtor_RotationPeriodInDays() m_Wrappers.Option {
	return _this.Get_().(EnableKeyRotationRequest_EnableKeyRotationRequest).RotationPeriodInDays
}

func (_this EnableKeyRotationRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EnableKeyRotationRequest_EnableKeyRotationRequest:
		{
			return "ComAmazonawsKmsTypes.EnableKeyRotationRequest.EnableKeyRotationRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.RotationPeriodInDays) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EnableKeyRotationRequest) Equals(other EnableKeyRotationRequest) bool {
	switch data1 := _this.Get_().(type) {
	case EnableKeyRotationRequest_EnableKeyRotationRequest:
		{
			data2, ok := other.Get_().(EnableKeyRotationRequest_EnableKeyRotationRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.RotationPeriodInDays.Equals(data2.RotationPeriodInDays)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EnableKeyRotationRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EnableKeyRotationRequest)
	return ok && _this.Equals(typed)
}

func Type_EnableKeyRotationRequest_() _dafny.TypeDescriptor {
	return type_EnableKeyRotationRequest_{}
}

type type_EnableKeyRotationRequest_ struct {
}

func (_this type_EnableKeyRotationRequest_) Default() interface{} {
	return Companion_EnableKeyRotationRequest_.Default()
}

func (_this type_EnableKeyRotationRequest_) String() string {
	return "ComAmazonawsKmsTypes.EnableKeyRotationRequest"
}
func (_this EnableKeyRotationRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EnableKeyRotationRequest{}

// End of datatype EnableKeyRotationRequest

// Definition of datatype EncryptionAlgorithmSpec
type EncryptionAlgorithmSpec struct {
	Data_EncryptionAlgorithmSpec_
}

func (_this EncryptionAlgorithmSpec) Get_() Data_EncryptionAlgorithmSpec_ {
	return _this.Data_EncryptionAlgorithmSpec_
}

type Data_EncryptionAlgorithmSpec_ interface {
	isEncryptionAlgorithmSpec()
}

type CompanionStruct_EncryptionAlgorithmSpec_ struct {
}

var Companion_EncryptionAlgorithmSpec_ = CompanionStruct_EncryptionAlgorithmSpec_{}

type EncryptionAlgorithmSpec_SYMMETRIC__DEFAULT struct {
}

func (EncryptionAlgorithmSpec_SYMMETRIC__DEFAULT) isEncryptionAlgorithmSpec() {}

func (CompanionStruct_EncryptionAlgorithmSpec_) Create_SYMMETRIC__DEFAULT_() EncryptionAlgorithmSpec {
	return EncryptionAlgorithmSpec{EncryptionAlgorithmSpec_SYMMETRIC__DEFAULT{}}
}

func (_this EncryptionAlgorithmSpec) Is_SYMMETRIC__DEFAULT() bool {
	_, ok := _this.Get_().(EncryptionAlgorithmSpec_SYMMETRIC__DEFAULT)
	return ok
}

type EncryptionAlgorithmSpec_RSAES__OAEP__SHA__1 struct {
}

func (EncryptionAlgorithmSpec_RSAES__OAEP__SHA__1) isEncryptionAlgorithmSpec() {}

func (CompanionStruct_EncryptionAlgorithmSpec_) Create_RSAES__OAEP__SHA__1_() EncryptionAlgorithmSpec {
	return EncryptionAlgorithmSpec{EncryptionAlgorithmSpec_RSAES__OAEP__SHA__1{}}
}

func (_this EncryptionAlgorithmSpec) Is_RSAES__OAEP__SHA__1() bool {
	_, ok := _this.Get_().(EncryptionAlgorithmSpec_RSAES__OAEP__SHA__1)
	return ok
}

type EncryptionAlgorithmSpec_RSAES__OAEP__SHA__256 struct {
}

func (EncryptionAlgorithmSpec_RSAES__OAEP__SHA__256) isEncryptionAlgorithmSpec() {}

func (CompanionStruct_EncryptionAlgorithmSpec_) Create_RSAES__OAEP__SHA__256_() EncryptionAlgorithmSpec {
	return EncryptionAlgorithmSpec{EncryptionAlgorithmSpec_RSAES__OAEP__SHA__256{}}
}

func (_this EncryptionAlgorithmSpec) Is_RSAES__OAEP__SHA__256() bool {
	_, ok := _this.Get_().(EncryptionAlgorithmSpec_RSAES__OAEP__SHA__256)
	return ok
}

func (CompanionStruct_EncryptionAlgorithmSpec_) Default() EncryptionAlgorithmSpec {
	return Companion_EncryptionAlgorithmSpec_.Create_SYMMETRIC__DEFAULT_()
}

func (_ CompanionStruct_EncryptionAlgorithmSpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_EncryptionAlgorithmSpec_.Create_SYMMETRIC__DEFAULT_(), true
		case 1:
			return Companion_EncryptionAlgorithmSpec_.Create_RSAES__OAEP__SHA__1_(), true
		case 2:
			return Companion_EncryptionAlgorithmSpec_.Create_RSAES__OAEP__SHA__256_(), true
		default:
			return EncryptionAlgorithmSpec{}, false
		}
	}
}

func (_this EncryptionAlgorithmSpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptionAlgorithmSpec_SYMMETRIC__DEFAULT:
		{
			return "ComAmazonawsKmsTypes.EncryptionAlgorithmSpec.SYMMETRIC_DEFAULT"
		}
	case EncryptionAlgorithmSpec_RSAES__OAEP__SHA__1:
		{
			return "ComAmazonawsKmsTypes.EncryptionAlgorithmSpec.RSAES_OAEP_SHA_1"
		}
	case EncryptionAlgorithmSpec_RSAES__OAEP__SHA__256:
		{
			return "ComAmazonawsKmsTypes.EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptionAlgorithmSpec) Equals(other EncryptionAlgorithmSpec) bool {
	switch _this.Get_().(type) {
	case EncryptionAlgorithmSpec_SYMMETRIC__DEFAULT:
		{
			_, ok := other.Get_().(EncryptionAlgorithmSpec_SYMMETRIC__DEFAULT)
			return ok
		}
	case EncryptionAlgorithmSpec_RSAES__OAEP__SHA__1:
		{
			_, ok := other.Get_().(EncryptionAlgorithmSpec_RSAES__OAEP__SHA__1)
			return ok
		}
	case EncryptionAlgorithmSpec_RSAES__OAEP__SHA__256:
		{
			_, ok := other.Get_().(EncryptionAlgorithmSpec_RSAES__OAEP__SHA__256)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptionAlgorithmSpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptionAlgorithmSpec)
	return ok && _this.Equals(typed)
}

func Type_EncryptionAlgorithmSpec_() _dafny.TypeDescriptor {
	return type_EncryptionAlgorithmSpec_{}
}

type type_EncryptionAlgorithmSpec_ struct {
}

func (_this type_EncryptionAlgorithmSpec_) Default() interface{} {
	return Companion_EncryptionAlgorithmSpec_.Default()
}

func (_this type_EncryptionAlgorithmSpec_) String() string {
	return "ComAmazonawsKmsTypes.EncryptionAlgorithmSpec"
}
func (_this EncryptionAlgorithmSpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptionAlgorithmSpec{}

// End of datatype EncryptionAlgorithmSpec

// Definition of datatype EncryptRequest
type EncryptRequest struct {
	Data_EncryptRequest_
}

func (_this EncryptRequest) Get_() Data_EncryptRequest_ {
	return _this.Data_EncryptRequest_
}

type Data_EncryptRequest_ interface {
	isEncryptRequest()
}

type CompanionStruct_EncryptRequest_ struct {
}

var Companion_EncryptRequest_ = CompanionStruct_EncryptRequest_{}

type EncryptRequest_EncryptRequest struct {
	KeyId               _dafny.Sequence
	Plaintext           _dafny.Sequence
	EncryptionContext   m_Wrappers.Option
	GrantTokens         m_Wrappers.Option
	EncryptionAlgorithm m_Wrappers.Option
	DryRun              m_Wrappers.Option
}

func (EncryptRequest_EncryptRequest) isEncryptRequest() {}

func (CompanionStruct_EncryptRequest_) Create_EncryptRequest_(KeyId _dafny.Sequence, Plaintext _dafny.Sequence, EncryptionContext m_Wrappers.Option, GrantTokens m_Wrappers.Option, EncryptionAlgorithm m_Wrappers.Option, DryRun m_Wrappers.Option) EncryptRequest {
	return EncryptRequest{EncryptRequest_EncryptRequest{KeyId, Plaintext, EncryptionContext, GrantTokens, EncryptionAlgorithm, DryRun}}
}

func (_this EncryptRequest) Is_EncryptRequest() bool {
	_, ok := _this.Get_().(EncryptRequest_EncryptRequest)
	return ok
}

func (CompanionStruct_EncryptRequest_) Default() EncryptRequest {
	return Companion_EncryptRequest_.Create_EncryptRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this EncryptRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(EncryptRequest_EncryptRequest).KeyId
}

func (_this EncryptRequest) Dtor_Plaintext() _dafny.Sequence {
	return _this.Get_().(EncryptRequest_EncryptRequest).Plaintext
}

func (_this EncryptRequest) Dtor_EncryptionContext() m_Wrappers.Option {
	return _this.Get_().(EncryptRequest_EncryptRequest).EncryptionContext
}

func (_this EncryptRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(EncryptRequest_EncryptRequest).GrantTokens
}

func (_this EncryptRequest) Dtor_EncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(EncryptRequest_EncryptRequest).EncryptionAlgorithm
}

func (_this EncryptRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(EncryptRequest_EncryptRequest).DryRun
}

func (_this EncryptRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptRequest_EncryptRequest:
		{
			return "ComAmazonawsKmsTypes.EncryptRequest.EncryptRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Plaintext) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.EncryptionAlgorithm) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptRequest) Equals(other EncryptRequest) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptRequest_EncryptRequest:
		{
			data2, ok := other.Get_().(EncryptRequest_EncryptRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Plaintext.Equals(data2.Plaintext) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.EncryptionAlgorithm.Equals(data2.EncryptionAlgorithm) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptRequest)
	return ok && _this.Equals(typed)
}

func Type_EncryptRequest_() _dafny.TypeDescriptor {
	return type_EncryptRequest_{}
}

type type_EncryptRequest_ struct {
}

func (_this type_EncryptRequest_) Default() interface{} {
	return Companion_EncryptRequest_.Default()
}

func (_this type_EncryptRequest_) String() string {
	return "ComAmazonawsKmsTypes.EncryptRequest"
}
func (_this EncryptRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptRequest{}

// End of datatype EncryptRequest

// Definition of datatype EncryptResponse
type EncryptResponse struct {
	Data_EncryptResponse_
}

func (_this EncryptResponse) Get_() Data_EncryptResponse_ {
	return _this.Data_EncryptResponse_
}

type Data_EncryptResponse_ interface {
	isEncryptResponse()
}

type CompanionStruct_EncryptResponse_ struct {
}

var Companion_EncryptResponse_ = CompanionStruct_EncryptResponse_{}

type EncryptResponse_EncryptResponse struct {
	CiphertextBlob      m_Wrappers.Option
	KeyId               m_Wrappers.Option
	EncryptionAlgorithm m_Wrappers.Option
}

func (EncryptResponse_EncryptResponse) isEncryptResponse() {}

func (CompanionStruct_EncryptResponse_) Create_EncryptResponse_(CiphertextBlob m_Wrappers.Option, KeyId m_Wrappers.Option, EncryptionAlgorithm m_Wrappers.Option) EncryptResponse {
	return EncryptResponse{EncryptResponse_EncryptResponse{CiphertextBlob, KeyId, EncryptionAlgorithm}}
}

func (_this EncryptResponse) Is_EncryptResponse() bool {
	_, ok := _this.Get_().(EncryptResponse_EncryptResponse)
	return ok
}

func (CompanionStruct_EncryptResponse_) Default() EncryptResponse {
	return Companion_EncryptResponse_.Create_EncryptResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this EncryptResponse) Dtor_CiphertextBlob() m_Wrappers.Option {
	return _this.Get_().(EncryptResponse_EncryptResponse).CiphertextBlob
}

func (_this EncryptResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(EncryptResponse_EncryptResponse).KeyId
}

func (_this EncryptResponse) Dtor_EncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(EncryptResponse_EncryptResponse).EncryptionAlgorithm
}

func (_this EncryptResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptResponse_EncryptResponse:
		{
			return "ComAmazonawsKmsTypes.EncryptResponse.EncryptResponse" + "(" + _dafny.String(data.CiphertextBlob) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.EncryptionAlgorithm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptResponse) Equals(other EncryptResponse) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptResponse_EncryptResponse:
		{
			data2, ok := other.Get_().(EncryptResponse_EncryptResponse)
			return ok && data1.CiphertextBlob.Equals(data2.CiphertextBlob) && data1.KeyId.Equals(data2.KeyId) && data1.EncryptionAlgorithm.Equals(data2.EncryptionAlgorithm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptResponse)
	return ok && _this.Equals(typed)
}

func Type_EncryptResponse_() _dafny.TypeDescriptor {
	return type_EncryptResponse_{}
}

type type_EncryptResponse_ struct {
}

func (_this type_EncryptResponse_) Default() interface{} {
	return Companion_EncryptResponse_.Default()
}

func (_this type_EncryptResponse_) String() string {
	return "ComAmazonawsKmsTypes.EncryptResponse"
}
func (_this EncryptResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptResponse{}

// End of datatype EncryptResponse

// Definition of datatype ExpirationModelType
type ExpirationModelType struct {
	Data_ExpirationModelType_
}

func (_this ExpirationModelType) Get_() Data_ExpirationModelType_ {
	return _this.Data_ExpirationModelType_
}

type Data_ExpirationModelType_ interface {
	isExpirationModelType()
}

type CompanionStruct_ExpirationModelType_ struct {
}

var Companion_ExpirationModelType_ = CompanionStruct_ExpirationModelType_{}

type ExpirationModelType_KEY__MATERIAL__EXPIRES struct {
}

func (ExpirationModelType_KEY__MATERIAL__EXPIRES) isExpirationModelType() {}

func (CompanionStruct_ExpirationModelType_) Create_KEY__MATERIAL__EXPIRES_() ExpirationModelType {
	return ExpirationModelType{ExpirationModelType_KEY__MATERIAL__EXPIRES{}}
}

func (_this ExpirationModelType) Is_KEY__MATERIAL__EXPIRES() bool {
	_, ok := _this.Get_().(ExpirationModelType_KEY__MATERIAL__EXPIRES)
	return ok
}

type ExpirationModelType_KEY__MATERIAL__DOES__NOT__EXPIRE struct {
}

func (ExpirationModelType_KEY__MATERIAL__DOES__NOT__EXPIRE) isExpirationModelType() {}

func (CompanionStruct_ExpirationModelType_) Create_KEY__MATERIAL__DOES__NOT__EXPIRE_() ExpirationModelType {
	return ExpirationModelType{ExpirationModelType_KEY__MATERIAL__DOES__NOT__EXPIRE{}}
}

func (_this ExpirationModelType) Is_KEY__MATERIAL__DOES__NOT__EXPIRE() bool {
	_, ok := _this.Get_().(ExpirationModelType_KEY__MATERIAL__DOES__NOT__EXPIRE)
	return ok
}

func (CompanionStruct_ExpirationModelType_) Default() ExpirationModelType {
	return Companion_ExpirationModelType_.Create_KEY__MATERIAL__EXPIRES_()
}

func (_ CompanionStruct_ExpirationModelType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ExpirationModelType_.Create_KEY__MATERIAL__EXPIRES_(), true
		case 1:
			return Companion_ExpirationModelType_.Create_KEY__MATERIAL__DOES__NOT__EXPIRE_(), true
		default:
			return ExpirationModelType{}, false
		}
	}
}

func (_this ExpirationModelType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ExpirationModelType_KEY__MATERIAL__EXPIRES:
		{
			return "ComAmazonawsKmsTypes.ExpirationModelType.KEY_MATERIAL_EXPIRES"
		}
	case ExpirationModelType_KEY__MATERIAL__DOES__NOT__EXPIRE:
		{
			return "ComAmazonawsKmsTypes.ExpirationModelType.KEY_MATERIAL_DOES_NOT_EXPIRE"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ExpirationModelType) Equals(other ExpirationModelType) bool {
	switch _this.Get_().(type) {
	case ExpirationModelType_KEY__MATERIAL__EXPIRES:
		{
			_, ok := other.Get_().(ExpirationModelType_KEY__MATERIAL__EXPIRES)
			return ok
		}
	case ExpirationModelType_KEY__MATERIAL__DOES__NOT__EXPIRE:
		{
			_, ok := other.Get_().(ExpirationModelType_KEY__MATERIAL__DOES__NOT__EXPIRE)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ExpirationModelType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ExpirationModelType)
	return ok && _this.Equals(typed)
}

func Type_ExpirationModelType_() _dafny.TypeDescriptor {
	return type_ExpirationModelType_{}
}

type type_ExpirationModelType_ struct {
}

func (_this type_ExpirationModelType_) Default() interface{} {
	return Companion_ExpirationModelType_.Default()
}

func (_this type_ExpirationModelType_) String() string {
	return "ComAmazonawsKmsTypes.ExpirationModelType"
}
func (_this ExpirationModelType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ExpirationModelType{}

// End of datatype ExpirationModelType

// Definition of datatype GenerateDataKeyPairRequest
type GenerateDataKeyPairRequest struct {
	Data_GenerateDataKeyPairRequest_
}

func (_this GenerateDataKeyPairRequest) Get_() Data_GenerateDataKeyPairRequest_ {
	return _this.Data_GenerateDataKeyPairRequest_
}

type Data_GenerateDataKeyPairRequest_ interface {
	isGenerateDataKeyPairRequest()
}

type CompanionStruct_GenerateDataKeyPairRequest_ struct {
}

var Companion_GenerateDataKeyPairRequest_ = CompanionStruct_GenerateDataKeyPairRequest_{}

type GenerateDataKeyPairRequest_GenerateDataKeyPairRequest struct {
	EncryptionContext m_Wrappers.Option
	KeyId             _dafny.Sequence
	KeyPairSpec       DataKeyPairSpec
	GrantTokens       m_Wrappers.Option
	Recipient         m_Wrappers.Option
	DryRun            m_Wrappers.Option
}

func (GenerateDataKeyPairRequest_GenerateDataKeyPairRequest) isGenerateDataKeyPairRequest() {}

func (CompanionStruct_GenerateDataKeyPairRequest_) Create_GenerateDataKeyPairRequest_(EncryptionContext m_Wrappers.Option, KeyId _dafny.Sequence, KeyPairSpec DataKeyPairSpec, GrantTokens m_Wrappers.Option, Recipient m_Wrappers.Option, DryRun m_Wrappers.Option) GenerateDataKeyPairRequest {
	return GenerateDataKeyPairRequest{GenerateDataKeyPairRequest_GenerateDataKeyPairRequest{EncryptionContext, KeyId, KeyPairSpec, GrantTokens, Recipient, DryRun}}
}

func (_this GenerateDataKeyPairRequest) Is_GenerateDataKeyPairRequest() bool {
	_, ok := _this.Get_().(GenerateDataKeyPairRequest_GenerateDataKeyPairRequest)
	return ok
}

func (CompanionStruct_GenerateDataKeyPairRequest_) Default() GenerateDataKeyPairRequest {
	return Companion_GenerateDataKeyPairRequest_.Create_GenerateDataKeyPairRequest_(m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq.SetString(), Companion_DataKeyPairSpec_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateDataKeyPairRequest) Dtor_EncryptionContext() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairRequest_GenerateDataKeyPairRequest).EncryptionContext
}

func (_this GenerateDataKeyPairRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GenerateDataKeyPairRequest_GenerateDataKeyPairRequest).KeyId
}

func (_this GenerateDataKeyPairRequest) Dtor_KeyPairSpec() DataKeyPairSpec {
	return _this.Get_().(GenerateDataKeyPairRequest_GenerateDataKeyPairRequest).KeyPairSpec
}

func (_this GenerateDataKeyPairRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairRequest_GenerateDataKeyPairRequest).GrantTokens
}

func (_this GenerateDataKeyPairRequest) Dtor_Recipient() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairRequest_GenerateDataKeyPairRequest).Recipient
}

func (_this GenerateDataKeyPairRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairRequest_GenerateDataKeyPairRequest).DryRun
}

func (_this GenerateDataKeyPairRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateDataKeyPairRequest_GenerateDataKeyPairRequest:
		{
			return "ComAmazonawsKmsTypes.GenerateDataKeyPairRequest.GenerateDataKeyPairRequest" + "(" + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.KeyPairSpec) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.Recipient) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateDataKeyPairRequest) Equals(other GenerateDataKeyPairRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateDataKeyPairRequest_GenerateDataKeyPairRequest:
		{
			data2, ok := other.Get_().(GenerateDataKeyPairRequest_GenerateDataKeyPairRequest)
			return ok && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.KeyId.Equals(data2.KeyId) && data1.KeyPairSpec.Equals(data2.KeyPairSpec) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.Recipient.Equals(data2.Recipient) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateDataKeyPairRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateDataKeyPairRequest)
	return ok && _this.Equals(typed)
}

func Type_GenerateDataKeyPairRequest_() _dafny.TypeDescriptor {
	return type_GenerateDataKeyPairRequest_{}
}

type type_GenerateDataKeyPairRequest_ struct {
}

func (_this type_GenerateDataKeyPairRequest_) Default() interface{} {
	return Companion_GenerateDataKeyPairRequest_.Default()
}

func (_this type_GenerateDataKeyPairRequest_) String() string {
	return "ComAmazonawsKmsTypes.GenerateDataKeyPairRequest"
}
func (_this GenerateDataKeyPairRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateDataKeyPairRequest{}

// End of datatype GenerateDataKeyPairRequest

// Definition of datatype GenerateDataKeyPairResponse
type GenerateDataKeyPairResponse struct {
	Data_GenerateDataKeyPairResponse_
}

func (_this GenerateDataKeyPairResponse) Get_() Data_GenerateDataKeyPairResponse_ {
	return _this.Data_GenerateDataKeyPairResponse_
}

type Data_GenerateDataKeyPairResponse_ interface {
	isGenerateDataKeyPairResponse()
}

type CompanionStruct_GenerateDataKeyPairResponse_ struct {
}

var Companion_GenerateDataKeyPairResponse_ = CompanionStruct_GenerateDataKeyPairResponse_{}

type GenerateDataKeyPairResponse_GenerateDataKeyPairResponse struct {
	PrivateKeyCiphertextBlob m_Wrappers.Option
	PrivateKeyPlaintext      m_Wrappers.Option
	PublicKey                m_Wrappers.Option
	KeyId                    m_Wrappers.Option
	KeyPairSpec              m_Wrappers.Option
	CiphertextForRecipient   m_Wrappers.Option
}

func (GenerateDataKeyPairResponse_GenerateDataKeyPairResponse) isGenerateDataKeyPairResponse() {}

func (CompanionStruct_GenerateDataKeyPairResponse_) Create_GenerateDataKeyPairResponse_(PrivateKeyCiphertextBlob m_Wrappers.Option, PrivateKeyPlaintext m_Wrappers.Option, PublicKey m_Wrappers.Option, KeyId m_Wrappers.Option, KeyPairSpec m_Wrappers.Option, CiphertextForRecipient m_Wrappers.Option) GenerateDataKeyPairResponse {
	return GenerateDataKeyPairResponse{GenerateDataKeyPairResponse_GenerateDataKeyPairResponse{PrivateKeyCiphertextBlob, PrivateKeyPlaintext, PublicKey, KeyId, KeyPairSpec, CiphertextForRecipient}}
}

func (_this GenerateDataKeyPairResponse) Is_GenerateDataKeyPairResponse() bool {
	_, ok := _this.Get_().(GenerateDataKeyPairResponse_GenerateDataKeyPairResponse)
	return ok
}

func (CompanionStruct_GenerateDataKeyPairResponse_) Default() GenerateDataKeyPairResponse {
	return Companion_GenerateDataKeyPairResponse_.Create_GenerateDataKeyPairResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateDataKeyPairResponse) Dtor_PrivateKeyCiphertextBlob() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairResponse_GenerateDataKeyPairResponse).PrivateKeyCiphertextBlob
}

func (_this GenerateDataKeyPairResponse) Dtor_PrivateKeyPlaintext() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairResponse_GenerateDataKeyPairResponse).PrivateKeyPlaintext
}

func (_this GenerateDataKeyPairResponse) Dtor_PublicKey() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairResponse_GenerateDataKeyPairResponse).PublicKey
}

func (_this GenerateDataKeyPairResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairResponse_GenerateDataKeyPairResponse).KeyId
}

func (_this GenerateDataKeyPairResponse) Dtor_KeyPairSpec() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairResponse_GenerateDataKeyPairResponse).KeyPairSpec
}

func (_this GenerateDataKeyPairResponse) Dtor_CiphertextForRecipient() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairResponse_GenerateDataKeyPairResponse).CiphertextForRecipient
}

func (_this GenerateDataKeyPairResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateDataKeyPairResponse_GenerateDataKeyPairResponse:
		{
			return "ComAmazonawsKmsTypes.GenerateDataKeyPairResponse.GenerateDataKeyPairResponse" + "(" + _dafny.String(data.PrivateKeyCiphertextBlob) + ", " + _dafny.String(data.PrivateKeyPlaintext) + ", " + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.KeyPairSpec) + ", " + _dafny.String(data.CiphertextForRecipient) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateDataKeyPairResponse) Equals(other GenerateDataKeyPairResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateDataKeyPairResponse_GenerateDataKeyPairResponse:
		{
			data2, ok := other.Get_().(GenerateDataKeyPairResponse_GenerateDataKeyPairResponse)
			return ok && data1.PrivateKeyCiphertextBlob.Equals(data2.PrivateKeyCiphertextBlob) && data1.PrivateKeyPlaintext.Equals(data2.PrivateKeyPlaintext) && data1.PublicKey.Equals(data2.PublicKey) && data1.KeyId.Equals(data2.KeyId) && data1.KeyPairSpec.Equals(data2.KeyPairSpec) && data1.CiphertextForRecipient.Equals(data2.CiphertextForRecipient)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateDataKeyPairResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateDataKeyPairResponse)
	return ok && _this.Equals(typed)
}

func Type_GenerateDataKeyPairResponse_() _dafny.TypeDescriptor {
	return type_GenerateDataKeyPairResponse_{}
}

type type_GenerateDataKeyPairResponse_ struct {
}

func (_this type_GenerateDataKeyPairResponse_) Default() interface{} {
	return Companion_GenerateDataKeyPairResponse_.Default()
}

func (_this type_GenerateDataKeyPairResponse_) String() string {
	return "ComAmazonawsKmsTypes.GenerateDataKeyPairResponse"
}
func (_this GenerateDataKeyPairResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateDataKeyPairResponse{}

// End of datatype GenerateDataKeyPairResponse

// Definition of datatype GenerateDataKeyPairWithoutPlaintextRequest
type GenerateDataKeyPairWithoutPlaintextRequest struct {
	Data_GenerateDataKeyPairWithoutPlaintextRequest_
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) Get_() Data_GenerateDataKeyPairWithoutPlaintextRequest_ {
	return _this.Data_GenerateDataKeyPairWithoutPlaintextRequest_
}

type Data_GenerateDataKeyPairWithoutPlaintextRequest_ interface {
	isGenerateDataKeyPairWithoutPlaintextRequest()
}

type CompanionStruct_GenerateDataKeyPairWithoutPlaintextRequest_ struct {
}

var Companion_GenerateDataKeyPairWithoutPlaintextRequest_ = CompanionStruct_GenerateDataKeyPairWithoutPlaintextRequest_{}

type GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest struct {
	EncryptionContext m_Wrappers.Option
	KeyId             _dafny.Sequence
	KeyPairSpec       DataKeyPairSpec
	GrantTokens       m_Wrappers.Option
	DryRun            m_Wrappers.Option
}

func (GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest) isGenerateDataKeyPairWithoutPlaintextRequest() {
}

func (CompanionStruct_GenerateDataKeyPairWithoutPlaintextRequest_) Create_GenerateDataKeyPairWithoutPlaintextRequest_(EncryptionContext m_Wrappers.Option, KeyId _dafny.Sequence, KeyPairSpec DataKeyPairSpec, GrantTokens m_Wrappers.Option, DryRun m_Wrappers.Option) GenerateDataKeyPairWithoutPlaintextRequest {
	return GenerateDataKeyPairWithoutPlaintextRequest{GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest{EncryptionContext, KeyId, KeyPairSpec, GrantTokens, DryRun}}
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) Is_GenerateDataKeyPairWithoutPlaintextRequest() bool {
	_, ok := _this.Get_().(GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest)
	return ok
}

func (CompanionStruct_GenerateDataKeyPairWithoutPlaintextRequest_) Default() GenerateDataKeyPairWithoutPlaintextRequest {
	return Companion_GenerateDataKeyPairWithoutPlaintextRequest_.Create_GenerateDataKeyPairWithoutPlaintextRequest_(m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq.SetString(), Companion_DataKeyPairSpec_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) Dtor_EncryptionContext() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest).EncryptionContext
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest).KeyId
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) Dtor_KeyPairSpec() DataKeyPairSpec {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest).KeyPairSpec
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest).GrantTokens
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest).DryRun
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest:
		{
			return "ComAmazonawsKmsTypes.GenerateDataKeyPairWithoutPlaintextRequest.GenerateDataKeyPairWithoutPlaintextRequest" + "(" + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.KeyPairSpec) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) Equals(other GenerateDataKeyPairWithoutPlaintextRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest:
		{
			data2, ok := other.Get_().(GenerateDataKeyPairWithoutPlaintextRequest_GenerateDataKeyPairWithoutPlaintextRequest)
			return ok && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.KeyId.Equals(data2.KeyId) && data1.KeyPairSpec.Equals(data2.KeyPairSpec) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateDataKeyPairWithoutPlaintextRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateDataKeyPairWithoutPlaintextRequest)
	return ok && _this.Equals(typed)
}

func Type_GenerateDataKeyPairWithoutPlaintextRequest_() _dafny.TypeDescriptor {
	return type_GenerateDataKeyPairWithoutPlaintextRequest_{}
}

type type_GenerateDataKeyPairWithoutPlaintextRequest_ struct {
}

func (_this type_GenerateDataKeyPairWithoutPlaintextRequest_) Default() interface{} {
	return Companion_GenerateDataKeyPairWithoutPlaintextRequest_.Default()
}

func (_this type_GenerateDataKeyPairWithoutPlaintextRequest_) String() string {
	return "ComAmazonawsKmsTypes.GenerateDataKeyPairWithoutPlaintextRequest"
}
func (_this GenerateDataKeyPairWithoutPlaintextRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateDataKeyPairWithoutPlaintextRequest{}

// End of datatype GenerateDataKeyPairWithoutPlaintextRequest

// Definition of datatype GenerateDataKeyPairWithoutPlaintextResponse
type GenerateDataKeyPairWithoutPlaintextResponse struct {
	Data_GenerateDataKeyPairWithoutPlaintextResponse_
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) Get_() Data_GenerateDataKeyPairWithoutPlaintextResponse_ {
	return _this.Data_GenerateDataKeyPairWithoutPlaintextResponse_
}

type Data_GenerateDataKeyPairWithoutPlaintextResponse_ interface {
	isGenerateDataKeyPairWithoutPlaintextResponse()
}

type CompanionStruct_GenerateDataKeyPairWithoutPlaintextResponse_ struct {
}

var Companion_GenerateDataKeyPairWithoutPlaintextResponse_ = CompanionStruct_GenerateDataKeyPairWithoutPlaintextResponse_{}

type GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse struct {
	PrivateKeyCiphertextBlob m_Wrappers.Option
	PublicKey                m_Wrappers.Option
	KeyId                    m_Wrappers.Option
	KeyPairSpec              m_Wrappers.Option
}

func (GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse) isGenerateDataKeyPairWithoutPlaintextResponse() {
}

func (CompanionStruct_GenerateDataKeyPairWithoutPlaintextResponse_) Create_GenerateDataKeyPairWithoutPlaintextResponse_(PrivateKeyCiphertextBlob m_Wrappers.Option, PublicKey m_Wrappers.Option, KeyId m_Wrappers.Option, KeyPairSpec m_Wrappers.Option) GenerateDataKeyPairWithoutPlaintextResponse {
	return GenerateDataKeyPairWithoutPlaintextResponse{GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse{PrivateKeyCiphertextBlob, PublicKey, KeyId, KeyPairSpec}}
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) Is_GenerateDataKeyPairWithoutPlaintextResponse() bool {
	_, ok := _this.Get_().(GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse)
	return ok
}

func (CompanionStruct_GenerateDataKeyPairWithoutPlaintextResponse_) Default() GenerateDataKeyPairWithoutPlaintextResponse {
	return Companion_GenerateDataKeyPairWithoutPlaintextResponse_.Create_GenerateDataKeyPairWithoutPlaintextResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) Dtor_PrivateKeyCiphertextBlob() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse).PrivateKeyCiphertextBlob
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) Dtor_PublicKey() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse).PublicKey
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse).KeyId
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) Dtor_KeyPairSpec() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse).KeyPairSpec
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse:
		{
			return "ComAmazonawsKmsTypes.GenerateDataKeyPairWithoutPlaintextResponse.GenerateDataKeyPairWithoutPlaintextResponse" + "(" + _dafny.String(data.PrivateKeyCiphertextBlob) + ", " + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.KeyPairSpec) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) Equals(other GenerateDataKeyPairWithoutPlaintextResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse:
		{
			data2, ok := other.Get_().(GenerateDataKeyPairWithoutPlaintextResponse_GenerateDataKeyPairWithoutPlaintextResponse)
			return ok && data1.PrivateKeyCiphertextBlob.Equals(data2.PrivateKeyCiphertextBlob) && data1.PublicKey.Equals(data2.PublicKey) && data1.KeyId.Equals(data2.KeyId) && data1.KeyPairSpec.Equals(data2.KeyPairSpec)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateDataKeyPairWithoutPlaintextResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateDataKeyPairWithoutPlaintextResponse)
	return ok && _this.Equals(typed)
}

func Type_GenerateDataKeyPairWithoutPlaintextResponse_() _dafny.TypeDescriptor {
	return type_GenerateDataKeyPairWithoutPlaintextResponse_{}
}

type type_GenerateDataKeyPairWithoutPlaintextResponse_ struct {
}

func (_this type_GenerateDataKeyPairWithoutPlaintextResponse_) Default() interface{} {
	return Companion_GenerateDataKeyPairWithoutPlaintextResponse_.Default()
}

func (_this type_GenerateDataKeyPairWithoutPlaintextResponse_) String() string {
	return "ComAmazonawsKmsTypes.GenerateDataKeyPairWithoutPlaintextResponse"
}
func (_this GenerateDataKeyPairWithoutPlaintextResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateDataKeyPairWithoutPlaintextResponse{}

// End of datatype GenerateDataKeyPairWithoutPlaintextResponse

// Definition of datatype GenerateDataKeyRequest
type GenerateDataKeyRequest struct {
	Data_GenerateDataKeyRequest_
}

func (_this GenerateDataKeyRequest) Get_() Data_GenerateDataKeyRequest_ {
	return _this.Data_GenerateDataKeyRequest_
}

type Data_GenerateDataKeyRequest_ interface {
	isGenerateDataKeyRequest()
}

type CompanionStruct_GenerateDataKeyRequest_ struct {
}

var Companion_GenerateDataKeyRequest_ = CompanionStruct_GenerateDataKeyRequest_{}

type GenerateDataKeyRequest_GenerateDataKeyRequest struct {
	KeyId             _dafny.Sequence
	EncryptionContext m_Wrappers.Option
	NumberOfBytes     m_Wrappers.Option
	KeySpec           m_Wrappers.Option
	GrantTokens       m_Wrappers.Option
	Recipient         m_Wrappers.Option
	DryRun            m_Wrappers.Option
}

func (GenerateDataKeyRequest_GenerateDataKeyRequest) isGenerateDataKeyRequest() {}

func (CompanionStruct_GenerateDataKeyRequest_) Create_GenerateDataKeyRequest_(KeyId _dafny.Sequence, EncryptionContext m_Wrappers.Option, NumberOfBytes m_Wrappers.Option, KeySpec m_Wrappers.Option, GrantTokens m_Wrappers.Option, Recipient m_Wrappers.Option, DryRun m_Wrappers.Option) GenerateDataKeyRequest {
	return GenerateDataKeyRequest{GenerateDataKeyRequest_GenerateDataKeyRequest{KeyId, EncryptionContext, NumberOfBytes, KeySpec, GrantTokens, Recipient, DryRun}}
}

func (_this GenerateDataKeyRequest) Is_GenerateDataKeyRequest() bool {
	_, ok := _this.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest)
	return ok
}

func (CompanionStruct_GenerateDataKeyRequest_) Default() GenerateDataKeyRequest {
	return Companion_GenerateDataKeyRequest_.Create_GenerateDataKeyRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateDataKeyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest).KeyId
}

func (_this GenerateDataKeyRequest) Dtor_EncryptionContext() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest).EncryptionContext
}

func (_this GenerateDataKeyRequest) Dtor_NumberOfBytes() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest).NumberOfBytes
}

func (_this GenerateDataKeyRequest) Dtor_KeySpec() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest).KeySpec
}

func (_this GenerateDataKeyRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest).GrantTokens
}

func (_this GenerateDataKeyRequest) Dtor_Recipient() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest).Recipient
}

func (_this GenerateDataKeyRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest).DryRun
}

func (_this GenerateDataKeyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateDataKeyRequest_GenerateDataKeyRequest:
		{
			return "ComAmazonawsKmsTypes.GenerateDataKeyRequest.GenerateDataKeyRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.NumberOfBytes) + ", " + _dafny.String(data.KeySpec) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.Recipient) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateDataKeyRequest) Equals(other GenerateDataKeyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateDataKeyRequest_GenerateDataKeyRequest:
		{
			data2, ok := other.Get_().(GenerateDataKeyRequest_GenerateDataKeyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.NumberOfBytes.Equals(data2.NumberOfBytes) && data1.KeySpec.Equals(data2.KeySpec) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.Recipient.Equals(data2.Recipient) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateDataKeyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateDataKeyRequest)
	return ok && _this.Equals(typed)
}

func Type_GenerateDataKeyRequest_() _dafny.TypeDescriptor {
	return type_GenerateDataKeyRequest_{}
}

type type_GenerateDataKeyRequest_ struct {
}

func (_this type_GenerateDataKeyRequest_) Default() interface{} {
	return Companion_GenerateDataKeyRequest_.Default()
}

func (_this type_GenerateDataKeyRequest_) String() string {
	return "ComAmazonawsKmsTypes.GenerateDataKeyRequest"
}
func (_this GenerateDataKeyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateDataKeyRequest{}

// End of datatype GenerateDataKeyRequest

// Definition of datatype GenerateDataKeyResponse
type GenerateDataKeyResponse struct {
	Data_GenerateDataKeyResponse_
}

func (_this GenerateDataKeyResponse) Get_() Data_GenerateDataKeyResponse_ {
	return _this.Data_GenerateDataKeyResponse_
}

type Data_GenerateDataKeyResponse_ interface {
	isGenerateDataKeyResponse()
}

type CompanionStruct_GenerateDataKeyResponse_ struct {
}

var Companion_GenerateDataKeyResponse_ = CompanionStruct_GenerateDataKeyResponse_{}

type GenerateDataKeyResponse_GenerateDataKeyResponse struct {
	CiphertextBlob         m_Wrappers.Option
	Plaintext              m_Wrappers.Option
	KeyId                  m_Wrappers.Option
	CiphertextForRecipient m_Wrappers.Option
}

func (GenerateDataKeyResponse_GenerateDataKeyResponse) isGenerateDataKeyResponse() {}

func (CompanionStruct_GenerateDataKeyResponse_) Create_GenerateDataKeyResponse_(CiphertextBlob m_Wrappers.Option, Plaintext m_Wrappers.Option, KeyId m_Wrappers.Option, CiphertextForRecipient m_Wrappers.Option) GenerateDataKeyResponse {
	return GenerateDataKeyResponse{GenerateDataKeyResponse_GenerateDataKeyResponse{CiphertextBlob, Plaintext, KeyId, CiphertextForRecipient}}
}

func (_this GenerateDataKeyResponse) Is_GenerateDataKeyResponse() bool {
	_, ok := _this.Get_().(GenerateDataKeyResponse_GenerateDataKeyResponse)
	return ok
}

func (CompanionStruct_GenerateDataKeyResponse_) Default() GenerateDataKeyResponse {
	return Companion_GenerateDataKeyResponse_.Create_GenerateDataKeyResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateDataKeyResponse) Dtor_CiphertextBlob() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyResponse_GenerateDataKeyResponse).CiphertextBlob
}

func (_this GenerateDataKeyResponse) Dtor_Plaintext() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyResponse_GenerateDataKeyResponse).Plaintext
}

func (_this GenerateDataKeyResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyResponse_GenerateDataKeyResponse).KeyId
}

func (_this GenerateDataKeyResponse) Dtor_CiphertextForRecipient() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyResponse_GenerateDataKeyResponse).CiphertextForRecipient
}

func (_this GenerateDataKeyResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateDataKeyResponse_GenerateDataKeyResponse:
		{
			return "ComAmazonawsKmsTypes.GenerateDataKeyResponse.GenerateDataKeyResponse" + "(" + _dafny.String(data.CiphertextBlob) + ", " + _dafny.String(data.Plaintext) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.CiphertextForRecipient) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateDataKeyResponse) Equals(other GenerateDataKeyResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateDataKeyResponse_GenerateDataKeyResponse:
		{
			data2, ok := other.Get_().(GenerateDataKeyResponse_GenerateDataKeyResponse)
			return ok && data1.CiphertextBlob.Equals(data2.CiphertextBlob) && data1.Plaintext.Equals(data2.Plaintext) && data1.KeyId.Equals(data2.KeyId) && data1.CiphertextForRecipient.Equals(data2.CiphertextForRecipient)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateDataKeyResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateDataKeyResponse)
	return ok && _this.Equals(typed)
}

func Type_GenerateDataKeyResponse_() _dafny.TypeDescriptor {
	return type_GenerateDataKeyResponse_{}
}

type type_GenerateDataKeyResponse_ struct {
}

func (_this type_GenerateDataKeyResponse_) Default() interface{} {
	return Companion_GenerateDataKeyResponse_.Default()
}

func (_this type_GenerateDataKeyResponse_) String() string {
	return "ComAmazonawsKmsTypes.GenerateDataKeyResponse"
}
func (_this GenerateDataKeyResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateDataKeyResponse{}

// End of datatype GenerateDataKeyResponse

// Definition of datatype GenerateDataKeyWithoutPlaintextRequest
type GenerateDataKeyWithoutPlaintextRequest struct {
	Data_GenerateDataKeyWithoutPlaintextRequest_
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Get_() Data_GenerateDataKeyWithoutPlaintextRequest_ {
	return _this.Data_GenerateDataKeyWithoutPlaintextRequest_
}

type Data_GenerateDataKeyWithoutPlaintextRequest_ interface {
	isGenerateDataKeyWithoutPlaintextRequest()
}

type CompanionStruct_GenerateDataKeyWithoutPlaintextRequest_ struct {
}

var Companion_GenerateDataKeyWithoutPlaintextRequest_ = CompanionStruct_GenerateDataKeyWithoutPlaintextRequest_{}

type GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest struct {
	KeyId             _dafny.Sequence
	EncryptionContext m_Wrappers.Option
	KeySpec           m_Wrappers.Option
	NumberOfBytes     m_Wrappers.Option
	GrantTokens       m_Wrappers.Option
	DryRun            m_Wrappers.Option
}

func (GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest) isGenerateDataKeyWithoutPlaintextRequest() {
}

func (CompanionStruct_GenerateDataKeyWithoutPlaintextRequest_) Create_GenerateDataKeyWithoutPlaintextRequest_(KeyId _dafny.Sequence, EncryptionContext m_Wrappers.Option, KeySpec m_Wrappers.Option, NumberOfBytes m_Wrappers.Option, GrantTokens m_Wrappers.Option, DryRun m_Wrappers.Option) GenerateDataKeyWithoutPlaintextRequest {
	return GenerateDataKeyWithoutPlaintextRequest{GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest{KeyId, EncryptionContext, KeySpec, NumberOfBytes, GrantTokens, DryRun}}
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Is_GenerateDataKeyWithoutPlaintextRequest() bool {
	_, ok := _this.Get_().(GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest)
	return ok
}

func (CompanionStruct_GenerateDataKeyWithoutPlaintextRequest_) Default() GenerateDataKeyWithoutPlaintextRequest {
	return Companion_GenerateDataKeyWithoutPlaintextRequest_.Create_GenerateDataKeyWithoutPlaintextRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest).KeyId
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Dtor_EncryptionContext() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest).EncryptionContext
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Dtor_KeySpec() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest).KeySpec
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Dtor_NumberOfBytes() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest).NumberOfBytes
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest).GrantTokens
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest).DryRun
}

func (_this GenerateDataKeyWithoutPlaintextRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest:
		{
			return "ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextRequest.GenerateDataKeyWithoutPlaintextRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.EncryptionContext) + ", " + _dafny.String(data.KeySpec) + ", " + _dafny.String(data.NumberOfBytes) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateDataKeyWithoutPlaintextRequest) Equals(other GenerateDataKeyWithoutPlaintextRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest:
		{
			data2, ok := other.Get_().(GenerateDataKeyWithoutPlaintextRequest_GenerateDataKeyWithoutPlaintextRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.EncryptionContext.Equals(data2.EncryptionContext) && data1.KeySpec.Equals(data2.KeySpec) && data1.NumberOfBytes.Equals(data2.NumberOfBytes) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateDataKeyWithoutPlaintextRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateDataKeyWithoutPlaintextRequest)
	return ok && _this.Equals(typed)
}

func Type_GenerateDataKeyWithoutPlaintextRequest_() _dafny.TypeDescriptor {
	return type_GenerateDataKeyWithoutPlaintextRequest_{}
}

type type_GenerateDataKeyWithoutPlaintextRequest_ struct {
}

func (_this type_GenerateDataKeyWithoutPlaintextRequest_) Default() interface{} {
	return Companion_GenerateDataKeyWithoutPlaintextRequest_.Default()
}

func (_this type_GenerateDataKeyWithoutPlaintextRequest_) String() string {
	return "ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextRequest"
}
func (_this GenerateDataKeyWithoutPlaintextRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateDataKeyWithoutPlaintextRequest{}

// End of datatype GenerateDataKeyWithoutPlaintextRequest

// Definition of datatype GenerateDataKeyWithoutPlaintextResponse
type GenerateDataKeyWithoutPlaintextResponse struct {
	Data_GenerateDataKeyWithoutPlaintextResponse_
}

func (_this GenerateDataKeyWithoutPlaintextResponse) Get_() Data_GenerateDataKeyWithoutPlaintextResponse_ {
	return _this.Data_GenerateDataKeyWithoutPlaintextResponse_
}

type Data_GenerateDataKeyWithoutPlaintextResponse_ interface {
	isGenerateDataKeyWithoutPlaintextResponse()
}

type CompanionStruct_GenerateDataKeyWithoutPlaintextResponse_ struct {
}

var Companion_GenerateDataKeyWithoutPlaintextResponse_ = CompanionStruct_GenerateDataKeyWithoutPlaintextResponse_{}

type GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse struct {
	CiphertextBlob m_Wrappers.Option
	KeyId          m_Wrappers.Option
}

func (GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse) isGenerateDataKeyWithoutPlaintextResponse() {
}

func (CompanionStruct_GenerateDataKeyWithoutPlaintextResponse_) Create_GenerateDataKeyWithoutPlaintextResponse_(CiphertextBlob m_Wrappers.Option, KeyId m_Wrappers.Option) GenerateDataKeyWithoutPlaintextResponse {
	return GenerateDataKeyWithoutPlaintextResponse{GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse{CiphertextBlob, KeyId}}
}

func (_this GenerateDataKeyWithoutPlaintextResponse) Is_GenerateDataKeyWithoutPlaintextResponse() bool {
	_, ok := _this.Get_().(GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse)
	return ok
}

func (CompanionStruct_GenerateDataKeyWithoutPlaintextResponse_) Default() GenerateDataKeyWithoutPlaintextResponse {
	return Companion_GenerateDataKeyWithoutPlaintextResponse_.Create_GenerateDataKeyWithoutPlaintextResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateDataKeyWithoutPlaintextResponse) Dtor_CiphertextBlob() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse).CiphertextBlob
}

func (_this GenerateDataKeyWithoutPlaintextResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse).KeyId
}

func (_this GenerateDataKeyWithoutPlaintextResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse:
		{
			return "ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextResponse.GenerateDataKeyWithoutPlaintextResponse" + "(" + _dafny.String(data.CiphertextBlob) + ", " + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateDataKeyWithoutPlaintextResponse) Equals(other GenerateDataKeyWithoutPlaintextResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse:
		{
			data2, ok := other.Get_().(GenerateDataKeyWithoutPlaintextResponse_GenerateDataKeyWithoutPlaintextResponse)
			return ok && data1.CiphertextBlob.Equals(data2.CiphertextBlob) && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateDataKeyWithoutPlaintextResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateDataKeyWithoutPlaintextResponse)
	return ok && _this.Equals(typed)
}

func Type_GenerateDataKeyWithoutPlaintextResponse_() _dafny.TypeDescriptor {
	return type_GenerateDataKeyWithoutPlaintextResponse_{}
}

type type_GenerateDataKeyWithoutPlaintextResponse_ struct {
}

func (_this type_GenerateDataKeyWithoutPlaintextResponse_) Default() interface{} {
	return Companion_GenerateDataKeyWithoutPlaintextResponse_.Default()
}

func (_this type_GenerateDataKeyWithoutPlaintextResponse_) String() string {
	return "ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextResponse"
}
func (_this GenerateDataKeyWithoutPlaintextResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateDataKeyWithoutPlaintextResponse{}

// End of datatype GenerateDataKeyWithoutPlaintextResponse

// Definition of datatype GenerateMacRequest
type GenerateMacRequest struct {
	Data_GenerateMacRequest_
}

func (_this GenerateMacRequest) Get_() Data_GenerateMacRequest_ {
	return _this.Data_GenerateMacRequest_
}

type Data_GenerateMacRequest_ interface {
	isGenerateMacRequest()
}

type CompanionStruct_GenerateMacRequest_ struct {
}

var Companion_GenerateMacRequest_ = CompanionStruct_GenerateMacRequest_{}

type GenerateMacRequest_GenerateMacRequest struct {
	Message      _dafny.Sequence
	KeyId        _dafny.Sequence
	MacAlgorithm MacAlgorithmSpec
	GrantTokens  m_Wrappers.Option
	DryRun       m_Wrappers.Option
}

func (GenerateMacRequest_GenerateMacRequest) isGenerateMacRequest() {}

func (CompanionStruct_GenerateMacRequest_) Create_GenerateMacRequest_(Message _dafny.Sequence, KeyId _dafny.Sequence, MacAlgorithm MacAlgorithmSpec, GrantTokens m_Wrappers.Option, DryRun m_Wrappers.Option) GenerateMacRequest {
	return GenerateMacRequest{GenerateMacRequest_GenerateMacRequest{Message, KeyId, MacAlgorithm, GrantTokens, DryRun}}
}

func (_this GenerateMacRequest) Is_GenerateMacRequest() bool {
	_, ok := _this.Get_().(GenerateMacRequest_GenerateMacRequest)
	return ok
}

func (CompanionStruct_GenerateMacRequest_) Default() GenerateMacRequest {
	return Companion_GenerateMacRequest_.Create_GenerateMacRequest_(_dafny.EmptySeq, _dafny.EmptySeq.SetString(), Companion_MacAlgorithmSpec_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateMacRequest) Dtor_Message() _dafny.Sequence {
	return _this.Get_().(GenerateMacRequest_GenerateMacRequest).Message
}

func (_this GenerateMacRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GenerateMacRequest_GenerateMacRequest).KeyId
}

func (_this GenerateMacRequest) Dtor_MacAlgorithm() MacAlgorithmSpec {
	return _this.Get_().(GenerateMacRequest_GenerateMacRequest).MacAlgorithm
}

func (_this GenerateMacRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(GenerateMacRequest_GenerateMacRequest).GrantTokens
}

func (_this GenerateMacRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(GenerateMacRequest_GenerateMacRequest).DryRun
}

func (_this GenerateMacRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateMacRequest_GenerateMacRequest:
		{
			return "ComAmazonawsKmsTypes.GenerateMacRequest.GenerateMacRequest" + "(" + _dafny.String(data.Message) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.MacAlgorithm) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateMacRequest) Equals(other GenerateMacRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateMacRequest_GenerateMacRequest:
		{
			data2, ok := other.Get_().(GenerateMacRequest_GenerateMacRequest)
			return ok && data1.Message.Equals(data2.Message) && data1.KeyId.Equals(data2.KeyId) && data1.MacAlgorithm.Equals(data2.MacAlgorithm) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateMacRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateMacRequest)
	return ok && _this.Equals(typed)
}

func Type_GenerateMacRequest_() _dafny.TypeDescriptor {
	return type_GenerateMacRequest_{}
}

type type_GenerateMacRequest_ struct {
}

func (_this type_GenerateMacRequest_) Default() interface{} {
	return Companion_GenerateMacRequest_.Default()
}

func (_this type_GenerateMacRequest_) String() string {
	return "ComAmazonawsKmsTypes.GenerateMacRequest"
}
func (_this GenerateMacRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateMacRequest{}

// End of datatype GenerateMacRequest

// Definition of datatype GenerateMacResponse
type GenerateMacResponse struct {
	Data_GenerateMacResponse_
}

func (_this GenerateMacResponse) Get_() Data_GenerateMacResponse_ {
	return _this.Data_GenerateMacResponse_
}

type Data_GenerateMacResponse_ interface {
	isGenerateMacResponse()
}

type CompanionStruct_GenerateMacResponse_ struct {
}

var Companion_GenerateMacResponse_ = CompanionStruct_GenerateMacResponse_{}

type GenerateMacResponse_GenerateMacResponse struct {
	Mac          m_Wrappers.Option
	MacAlgorithm m_Wrappers.Option
	KeyId        m_Wrappers.Option
}

func (GenerateMacResponse_GenerateMacResponse) isGenerateMacResponse() {}

func (CompanionStruct_GenerateMacResponse_) Create_GenerateMacResponse_(Mac m_Wrappers.Option, MacAlgorithm m_Wrappers.Option, KeyId m_Wrappers.Option) GenerateMacResponse {
	return GenerateMacResponse{GenerateMacResponse_GenerateMacResponse{Mac, MacAlgorithm, KeyId}}
}

func (_this GenerateMacResponse) Is_GenerateMacResponse() bool {
	_, ok := _this.Get_().(GenerateMacResponse_GenerateMacResponse)
	return ok
}

func (CompanionStruct_GenerateMacResponse_) Default() GenerateMacResponse {
	return Companion_GenerateMacResponse_.Create_GenerateMacResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateMacResponse) Dtor_Mac() m_Wrappers.Option {
	return _this.Get_().(GenerateMacResponse_GenerateMacResponse).Mac
}

func (_this GenerateMacResponse) Dtor_MacAlgorithm() m_Wrappers.Option {
	return _this.Get_().(GenerateMacResponse_GenerateMacResponse).MacAlgorithm
}

func (_this GenerateMacResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GenerateMacResponse_GenerateMacResponse).KeyId
}

func (_this GenerateMacResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateMacResponse_GenerateMacResponse:
		{
			return "ComAmazonawsKmsTypes.GenerateMacResponse.GenerateMacResponse" + "(" + _dafny.String(data.Mac) + ", " + _dafny.String(data.MacAlgorithm) + ", " + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateMacResponse) Equals(other GenerateMacResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateMacResponse_GenerateMacResponse:
		{
			data2, ok := other.Get_().(GenerateMacResponse_GenerateMacResponse)
			return ok && data1.Mac.Equals(data2.Mac) && data1.MacAlgorithm.Equals(data2.MacAlgorithm) && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateMacResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateMacResponse)
	return ok && _this.Equals(typed)
}

func Type_GenerateMacResponse_() _dafny.TypeDescriptor {
	return type_GenerateMacResponse_{}
}

type type_GenerateMacResponse_ struct {
}

func (_this type_GenerateMacResponse_) Default() interface{} {
	return Companion_GenerateMacResponse_.Default()
}

func (_this type_GenerateMacResponse_) String() string {
	return "ComAmazonawsKmsTypes.GenerateMacResponse"
}
func (_this GenerateMacResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateMacResponse{}

// End of datatype GenerateMacResponse

// Definition of datatype GenerateRandomRequest
type GenerateRandomRequest struct {
	Data_GenerateRandomRequest_
}

func (_this GenerateRandomRequest) Get_() Data_GenerateRandomRequest_ {
	return _this.Data_GenerateRandomRequest_
}

type Data_GenerateRandomRequest_ interface {
	isGenerateRandomRequest()
}

type CompanionStruct_GenerateRandomRequest_ struct {
}

var Companion_GenerateRandomRequest_ = CompanionStruct_GenerateRandomRequest_{}

type GenerateRandomRequest_GenerateRandomRequest struct {
	NumberOfBytes    m_Wrappers.Option
	CustomKeyStoreId m_Wrappers.Option
	Recipient        m_Wrappers.Option
}

func (GenerateRandomRequest_GenerateRandomRequest) isGenerateRandomRequest() {}

func (CompanionStruct_GenerateRandomRequest_) Create_GenerateRandomRequest_(NumberOfBytes m_Wrappers.Option, CustomKeyStoreId m_Wrappers.Option, Recipient m_Wrappers.Option) GenerateRandomRequest {
	return GenerateRandomRequest{GenerateRandomRequest_GenerateRandomRequest{NumberOfBytes, CustomKeyStoreId, Recipient}}
}

func (_this GenerateRandomRequest) Is_GenerateRandomRequest() bool {
	_, ok := _this.Get_().(GenerateRandomRequest_GenerateRandomRequest)
	return ok
}

func (CompanionStruct_GenerateRandomRequest_) Default() GenerateRandomRequest {
	return Companion_GenerateRandomRequest_.Create_GenerateRandomRequest_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateRandomRequest) Dtor_NumberOfBytes() m_Wrappers.Option {
	return _this.Get_().(GenerateRandomRequest_GenerateRandomRequest).NumberOfBytes
}

func (_this GenerateRandomRequest) Dtor_CustomKeyStoreId() m_Wrappers.Option {
	return _this.Get_().(GenerateRandomRequest_GenerateRandomRequest).CustomKeyStoreId
}

func (_this GenerateRandomRequest) Dtor_Recipient() m_Wrappers.Option {
	return _this.Get_().(GenerateRandomRequest_GenerateRandomRequest).Recipient
}

func (_this GenerateRandomRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateRandomRequest_GenerateRandomRequest:
		{
			return "ComAmazonawsKmsTypes.GenerateRandomRequest.GenerateRandomRequest" + "(" + _dafny.String(data.NumberOfBytes) + ", " + _dafny.String(data.CustomKeyStoreId) + ", " + _dafny.String(data.Recipient) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateRandomRequest) Equals(other GenerateRandomRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateRandomRequest_GenerateRandomRequest:
		{
			data2, ok := other.Get_().(GenerateRandomRequest_GenerateRandomRequest)
			return ok && data1.NumberOfBytes.Equals(data2.NumberOfBytes) && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId) && data1.Recipient.Equals(data2.Recipient)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateRandomRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateRandomRequest)
	return ok && _this.Equals(typed)
}

func Type_GenerateRandomRequest_() _dafny.TypeDescriptor {
	return type_GenerateRandomRequest_{}
}

type type_GenerateRandomRequest_ struct {
}

func (_this type_GenerateRandomRequest_) Default() interface{} {
	return Companion_GenerateRandomRequest_.Default()
}

func (_this type_GenerateRandomRequest_) String() string {
	return "ComAmazonawsKmsTypes.GenerateRandomRequest"
}
func (_this GenerateRandomRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateRandomRequest{}

// End of datatype GenerateRandomRequest

// Definition of datatype GenerateRandomResponse
type GenerateRandomResponse struct {
	Data_GenerateRandomResponse_
}

func (_this GenerateRandomResponse) Get_() Data_GenerateRandomResponse_ {
	return _this.Data_GenerateRandomResponse_
}

type Data_GenerateRandomResponse_ interface {
	isGenerateRandomResponse()
}

type CompanionStruct_GenerateRandomResponse_ struct {
}

var Companion_GenerateRandomResponse_ = CompanionStruct_GenerateRandomResponse_{}

type GenerateRandomResponse_GenerateRandomResponse struct {
	Plaintext              m_Wrappers.Option
	CiphertextForRecipient m_Wrappers.Option
}

func (GenerateRandomResponse_GenerateRandomResponse) isGenerateRandomResponse() {}

func (CompanionStruct_GenerateRandomResponse_) Create_GenerateRandomResponse_(Plaintext m_Wrappers.Option, CiphertextForRecipient m_Wrappers.Option) GenerateRandomResponse {
	return GenerateRandomResponse{GenerateRandomResponse_GenerateRandomResponse{Plaintext, CiphertextForRecipient}}
}

func (_this GenerateRandomResponse) Is_GenerateRandomResponse() bool {
	_, ok := _this.Get_().(GenerateRandomResponse_GenerateRandomResponse)
	return ok
}

func (CompanionStruct_GenerateRandomResponse_) Default() GenerateRandomResponse {
	return Companion_GenerateRandomResponse_.Create_GenerateRandomResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GenerateRandomResponse) Dtor_Plaintext() m_Wrappers.Option {
	return _this.Get_().(GenerateRandomResponse_GenerateRandomResponse).Plaintext
}

func (_this GenerateRandomResponse) Dtor_CiphertextForRecipient() m_Wrappers.Option {
	return _this.Get_().(GenerateRandomResponse_GenerateRandomResponse).CiphertextForRecipient
}

func (_this GenerateRandomResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GenerateRandomResponse_GenerateRandomResponse:
		{
			return "ComAmazonawsKmsTypes.GenerateRandomResponse.GenerateRandomResponse" + "(" + _dafny.String(data.Plaintext) + ", " + _dafny.String(data.CiphertextForRecipient) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GenerateRandomResponse) Equals(other GenerateRandomResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GenerateRandomResponse_GenerateRandomResponse:
		{
			data2, ok := other.Get_().(GenerateRandomResponse_GenerateRandomResponse)
			return ok && data1.Plaintext.Equals(data2.Plaintext) && data1.CiphertextForRecipient.Equals(data2.CiphertextForRecipient)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GenerateRandomResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GenerateRandomResponse)
	return ok && _this.Equals(typed)
}

func Type_GenerateRandomResponse_() _dafny.TypeDescriptor {
	return type_GenerateRandomResponse_{}
}

type type_GenerateRandomResponse_ struct {
}

func (_this type_GenerateRandomResponse_) Default() interface{} {
	return Companion_GenerateRandomResponse_.Default()
}

func (_this type_GenerateRandomResponse_) String() string {
	return "ComAmazonawsKmsTypes.GenerateRandomResponse"
}
func (_this GenerateRandomResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GenerateRandomResponse{}

// End of datatype GenerateRandomResponse

// Definition of datatype GetKeyPolicyRequest
type GetKeyPolicyRequest struct {
	Data_GetKeyPolicyRequest_
}

func (_this GetKeyPolicyRequest) Get_() Data_GetKeyPolicyRequest_ {
	return _this.Data_GetKeyPolicyRequest_
}

type Data_GetKeyPolicyRequest_ interface {
	isGetKeyPolicyRequest()
}

type CompanionStruct_GetKeyPolicyRequest_ struct {
}

var Companion_GetKeyPolicyRequest_ = CompanionStruct_GetKeyPolicyRequest_{}

type GetKeyPolicyRequest_GetKeyPolicyRequest struct {
	KeyId      _dafny.Sequence
	PolicyName m_Wrappers.Option
}

func (GetKeyPolicyRequest_GetKeyPolicyRequest) isGetKeyPolicyRequest() {}

func (CompanionStruct_GetKeyPolicyRequest_) Create_GetKeyPolicyRequest_(KeyId _dafny.Sequence, PolicyName m_Wrappers.Option) GetKeyPolicyRequest {
	return GetKeyPolicyRequest{GetKeyPolicyRequest_GetKeyPolicyRequest{KeyId, PolicyName}}
}

func (_this GetKeyPolicyRequest) Is_GetKeyPolicyRequest() bool {
	_, ok := _this.Get_().(GetKeyPolicyRequest_GetKeyPolicyRequest)
	return ok
}

func (CompanionStruct_GetKeyPolicyRequest_) Default() GetKeyPolicyRequest {
	return Companion_GetKeyPolicyRequest_.Create_GetKeyPolicyRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this GetKeyPolicyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GetKeyPolicyRequest_GetKeyPolicyRequest).KeyId
}

func (_this GetKeyPolicyRequest) Dtor_PolicyName() m_Wrappers.Option {
	return _this.Get_().(GetKeyPolicyRequest_GetKeyPolicyRequest).PolicyName
}

func (_this GetKeyPolicyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetKeyPolicyRequest_GetKeyPolicyRequest:
		{
			return "ComAmazonawsKmsTypes.GetKeyPolicyRequest.GetKeyPolicyRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.PolicyName) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetKeyPolicyRequest) Equals(other GetKeyPolicyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GetKeyPolicyRequest_GetKeyPolicyRequest:
		{
			data2, ok := other.Get_().(GetKeyPolicyRequest_GetKeyPolicyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.PolicyName.Equals(data2.PolicyName)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetKeyPolicyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetKeyPolicyRequest)
	return ok && _this.Equals(typed)
}

func Type_GetKeyPolicyRequest_() _dafny.TypeDescriptor {
	return type_GetKeyPolicyRequest_{}
}

type type_GetKeyPolicyRequest_ struct {
}

func (_this type_GetKeyPolicyRequest_) Default() interface{} {
	return Companion_GetKeyPolicyRequest_.Default()
}

func (_this type_GetKeyPolicyRequest_) String() string {
	return "ComAmazonawsKmsTypes.GetKeyPolicyRequest"
}
func (_this GetKeyPolicyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetKeyPolicyRequest{}

// End of datatype GetKeyPolicyRequest

// Definition of datatype GetKeyPolicyResponse
type GetKeyPolicyResponse struct {
	Data_GetKeyPolicyResponse_
}

func (_this GetKeyPolicyResponse) Get_() Data_GetKeyPolicyResponse_ {
	return _this.Data_GetKeyPolicyResponse_
}

type Data_GetKeyPolicyResponse_ interface {
	isGetKeyPolicyResponse()
}

type CompanionStruct_GetKeyPolicyResponse_ struct {
}

var Companion_GetKeyPolicyResponse_ = CompanionStruct_GetKeyPolicyResponse_{}

type GetKeyPolicyResponse_GetKeyPolicyResponse struct {
	Policy     m_Wrappers.Option
	PolicyName m_Wrappers.Option
}

func (GetKeyPolicyResponse_GetKeyPolicyResponse) isGetKeyPolicyResponse() {}

func (CompanionStruct_GetKeyPolicyResponse_) Create_GetKeyPolicyResponse_(Policy m_Wrappers.Option, PolicyName m_Wrappers.Option) GetKeyPolicyResponse {
	return GetKeyPolicyResponse{GetKeyPolicyResponse_GetKeyPolicyResponse{Policy, PolicyName}}
}

func (_this GetKeyPolicyResponse) Is_GetKeyPolicyResponse() bool {
	_, ok := _this.Get_().(GetKeyPolicyResponse_GetKeyPolicyResponse)
	return ok
}

func (CompanionStruct_GetKeyPolicyResponse_) Default() GetKeyPolicyResponse {
	return Companion_GetKeyPolicyResponse_.Create_GetKeyPolicyResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GetKeyPolicyResponse) Dtor_Policy() m_Wrappers.Option {
	return _this.Get_().(GetKeyPolicyResponse_GetKeyPolicyResponse).Policy
}

func (_this GetKeyPolicyResponse) Dtor_PolicyName() m_Wrappers.Option {
	return _this.Get_().(GetKeyPolicyResponse_GetKeyPolicyResponse).PolicyName
}

func (_this GetKeyPolicyResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetKeyPolicyResponse_GetKeyPolicyResponse:
		{
			return "ComAmazonawsKmsTypes.GetKeyPolicyResponse.GetKeyPolicyResponse" + "(" + _dafny.String(data.Policy) + ", " + _dafny.String(data.PolicyName) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetKeyPolicyResponse) Equals(other GetKeyPolicyResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GetKeyPolicyResponse_GetKeyPolicyResponse:
		{
			data2, ok := other.Get_().(GetKeyPolicyResponse_GetKeyPolicyResponse)
			return ok && data1.Policy.Equals(data2.Policy) && data1.PolicyName.Equals(data2.PolicyName)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetKeyPolicyResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetKeyPolicyResponse)
	return ok && _this.Equals(typed)
}

func Type_GetKeyPolicyResponse_() _dafny.TypeDescriptor {
	return type_GetKeyPolicyResponse_{}
}

type type_GetKeyPolicyResponse_ struct {
}

func (_this type_GetKeyPolicyResponse_) Default() interface{} {
	return Companion_GetKeyPolicyResponse_.Default()
}

func (_this type_GetKeyPolicyResponse_) String() string {
	return "ComAmazonawsKmsTypes.GetKeyPolicyResponse"
}
func (_this GetKeyPolicyResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetKeyPolicyResponse{}

// End of datatype GetKeyPolicyResponse

// Definition of datatype GetKeyRotationStatusRequest
type GetKeyRotationStatusRequest struct {
	Data_GetKeyRotationStatusRequest_
}

func (_this GetKeyRotationStatusRequest) Get_() Data_GetKeyRotationStatusRequest_ {
	return _this.Data_GetKeyRotationStatusRequest_
}

type Data_GetKeyRotationStatusRequest_ interface {
	isGetKeyRotationStatusRequest()
}

type CompanionStruct_GetKeyRotationStatusRequest_ struct {
}

var Companion_GetKeyRotationStatusRequest_ = CompanionStruct_GetKeyRotationStatusRequest_{}

type GetKeyRotationStatusRequest_GetKeyRotationStatusRequest struct {
	KeyId _dafny.Sequence
}

func (GetKeyRotationStatusRequest_GetKeyRotationStatusRequest) isGetKeyRotationStatusRequest() {}

func (CompanionStruct_GetKeyRotationStatusRequest_) Create_GetKeyRotationStatusRequest_(KeyId _dafny.Sequence) GetKeyRotationStatusRequest {
	return GetKeyRotationStatusRequest{GetKeyRotationStatusRequest_GetKeyRotationStatusRequest{KeyId}}
}

func (_this GetKeyRotationStatusRequest) Is_GetKeyRotationStatusRequest() bool {
	_, ok := _this.Get_().(GetKeyRotationStatusRequest_GetKeyRotationStatusRequest)
	return ok
}

func (CompanionStruct_GetKeyRotationStatusRequest_) Default() GetKeyRotationStatusRequest {
	return Companion_GetKeyRotationStatusRequest_.Create_GetKeyRotationStatusRequest_(_dafny.EmptySeq.SetString())
}

func (_this GetKeyRotationStatusRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GetKeyRotationStatusRequest_GetKeyRotationStatusRequest).KeyId
}

func (_this GetKeyRotationStatusRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetKeyRotationStatusRequest_GetKeyRotationStatusRequest:
		{
			return "ComAmazonawsKmsTypes.GetKeyRotationStatusRequest.GetKeyRotationStatusRequest" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetKeyRotationStatusRequest) Equals(other GetKeyRotationStatusRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GetKeyRotationStatusRequest_GetKeyRotationStatusRequest:
		{
			data2, ok := other.Get_().(GetKeyRotationStatusRequest_GetKeyRotationStatusRequest)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetKeyRotationStatusRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetKeyRotationStatusRequest)
	return ok && _this.Equals(typed)
}

func Type_GetKeyRotationStatusRequest_() _dafny.TypeDescriptor {
	return type_GetKeyRotationStatusRequest_{}
}

type type_GetKeyRotationStatusRequest_ struct {
}

func (_this type_GetKeyRotationStatusRequest_) Default() interface{} {
	return Companion_GetKeyRotationStatusRequest_.Default()
}

func (_this type_GetKeyRotationStatusRequest_) String() string {
	return "ComAmazonawsKmsTypes.GetKeyRotationStatusRequest"
}
func (_this GetKeyRotationStatusRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetKeyRotationStatusRequest{}

// End of datatype GetKeyRotationStatusRequest

// Definition of datatype GetKeyRotationStatusResponse
type GetKeyRotationStatusResponse struct {
	Data_GetKeyRotationStatusResponse_
}

func (_this GetKeyRotationStatusResponse) Get_() Data_GetKeyRotationStatusResponse_ {
	return _this.Data_GetKeyRotationStatusResponse_
}

type Data_GetKeyRotationStatusResponse_ interface {
	isGetKeyRotationStatusResponse()
}

type CompanionStruct_GetKeyRotationStatusResponse_ struct {
}

var Companion_GetKeyRotationStatusResponse_ = CompanionStruct_GetKeyRotationStatusResponse_{}

type GetKeyRotationStatusResponse_GetKeyRotationStatusResponse struct {
	KeyRotationEnabled        m_Wrappers.Option
	KeyId                     m_Wrappers.Option
	RotationPeriodInDays      m_Wrappers.Option
	NextRotationDate          m_Wrappers.Option
	OnDemandRotationStartDate m_Wrappers.Option
}

func (GetKeyRotationStatusResponse_GetKeyRotationStatusResponse) isGetKeyRotationStatusResponse() {}

func (CompanionStruct_GetKeyRotationStatusResponse_) Create_GetKeyRotationStatusResponse_(KeyRotationEnabled m_Wrappers.Option, KeyId m_Wrappers.Option, RotationPeriodInDays m_Wrappers.Option, NextRotationDate m_Wrappers.Option, OnDemandRotationStartDate m_Wrappers.Option) GetKeyRotationStatusResponse {
	return GetKeyRotationStatusResponse{GetKeyRotationStatusResponse_GetKeyRotationStatusResponse{KeyRotationEnabled, KeyId, RotationPeriodInDays, NextRotationDate, OnDemandRotationStartDate}}
}

func (_this GetKeyRotationStatusResponse) Is_GetKeyRotationStatusResponse() bool {
	_, ok := _this.Get_().(GetKeyRotationStatusResponse_GetKeyRotationStatusResponse)
	return ok
}

func (CompanionStruct_GetKeyRotationStatusResponse_) Default() GetKeyRotationStatusResponse {
	return Companion_GetKeyRotationStatusResponse_.Create_GetKeyRotationStatusResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GetKeyRotationStatusResponse) Dtor_KeyRotationEnabled() m_Wrappers.Option {
	return _this.Get_().(GetKeyRotationStatusResponse_GetKeyRotationStatusResponse).KeyRotationEnabled
}

func (_this GetKeyRotationStatusResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GetKeyRotationStatusResponse_GetKeyRotationStatusResponse).KeyId
}

func (_this GetKeyRotationStatusResponse) Dtor_RotationPeriodInDays() m_Wrappers.Option {
	return _this.Get_().(GetKeyRotationStatusResponse_GetKeyRotationStatusResponse).RotationPeriodInDays
}

func (_this GetKeyRotationStatusResponse) Dtor_NextRotationDate() m_Wrappers.Option {
	return _this.Get_().(GetKeyRotationStatusResponse_GetKeyRotationStatusResponse).NextRotationDate
}

func (_this GetKeyRotationStatusResponse) Dtor_OnDemandRotationStartDate() m_Wrappers.Option {
	return _this.Get_().(GetKeyRotationStatusResponse_GetKeyRotationStatusResponse).OnDemandRotationStartDate
}

func (_this GetKeyRotationStatusResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetKeyRotationStatusResponse_GetKeyRotationStatusResponse:
		{
			return "ComAmazonawsKmsTypes.GetKeyRotationStatusResponse.GetKeyRotationStatusResponse" + "(" + _dafny.String(data.KeyRotationEnabled) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.RotationPeriodInDays) + ", " + _dafny.String(data.NextRotationDate) + ", " + _dafny.String(data.OnDemandRotationStartDate) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetKeyRotationStatusResponse) Equals(other GetKeyRotationStatusResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GetKeyRotationStatusResponse_GetKeyRotationStatusResponse:
		{
			data2, ok := other.Get_().(GetKeyRotationStatusResponse_GetKeyRotationStatusResponse)
			return ok && data1.KeyRotationEnabled.Equals(data2.KeyRotationEnabled) && data1.KeyId.Equals(data2.KeyId) && data1.RotationPeriodInDays.Equals(data2.RotationPeriodInDays) && data1.NextRotationDate.Equals(data2.NextRotationDate) && data1.OnDemandRotationStartDate.Equals(data2.OnDemandRotationStartDate)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetKeyRotationStatusResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetKeyRotationStatusResponse)
	return ok && _this.Equals(typed)
}

func Type_GetKeyRotationStatusResponse_() _dafny.TypeDescriptor {
	return type_GetKeyRotationStatusResponse_{}
}

type type_GetKeyRotationStatusResponse_ struct {
}

func (_this type_GetKeyRotationStatusResponse_) Default() interface{} {
	return Companion_GetKeyRotationStatusResponse_.Default()
}

func (_this type_GetKeyRotationStatusResponse_) String() string {
	return "ComAmazonawsKmsTypes.GetKeyRotationStatusResponse"
}
func (_this GetKeyRotationStatusResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetKeyRotationStatusResponse{}

// End of datatype GetKeyRotationStatusResponse

// Definition of datatype GetParametersForImportRequest
type GetParametersForImportRequest struct {
	Data_GetParametersForImportRequest_
}

func (_this GetParametersForImportRequest) Get_() Data_GetParametersForImportRequest_ {
	return _this.Data_GetParametersForImportRequest_
}

type Data_GetParametersForImportRequest_ interface {
	isGetParametersForImportRequest()
}

type CompanionStruct_GetParametersForImportRequest_ struct {
}

var Companion_GetParametersForImportRequest_ = CompanionStruct_GetParametersForImportRequest_{}

type GetParametersForImportRequest_GetParametersForImportRequest struct {
	KeyId             _dafny.Sequence
	WrappingAlgorithm AlgorithmSpec
	WrappingKeySpec   WrappingKeySpec
}

func (GetParametersForImportRequest_GetParametersForImportRequest) isGetParametersForImportRequest() {
}

func (CompanionStruct_GetParametersForImportRequest_) Create_GetParametersForImportRequest_(KeyId _dafny.Sequence, WrappingAlgorithm AlgorithmSpec, WrappingKeySpec WrappingKeySpec) GetParametersForImportRequest {
	return GetParametersForImportRequest{GetParametersForImportRequest_GetParametersForImportRequest{KeyId, WrappingAlgorithm, WrappingKeySpec}}
}

func (_this GetParametersForImportRequest) Is_GetParametersForImportRequest() bool {
	_, ok := _this.Get_().(GetParametersForImportRequest_GetParametersForImportRequest)
	return ok
}

func (CompanionStruct_GetParametersForImportRequest_) Default() GetParametersForImportRequest {
	return Companion_GetParametersForImportRequest_.Create_GetParametersForImportRequest_(_dafny.EmptySeq.SetString(), Companion_AlgorithmSpec_.Default(), Companion_WrappingKeySpec_.Default())
}

func (_this GetParametersForImportRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GetParametersForImportRequest_GetParametersForImportRequest).KeyId
}

func (_this GetParametersForImportRequest) Dtor_WrappingAlgorithm() AlgorithmSpec {
	return _this.Get_().(GetParametersForImportRequest_GetParametersForImportRequest).WrappingAlgorithm
}

func (_this GetParametersForImportRequest) Dtor_WrappingKeySpec() WrappingKeySpec {
	return _this.Get_().(GetParametersForImportRequest_GetParametersForImportRequest).WrappingKeySpec
}

func (_this GetParametersForImportRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetParametersForImportRequest_GetParametersForImportRequest:
		{
			return "ComAmazonawsKmsTypes.GetParametersForImportRequest.GetParametersForImportRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.WrappingAlgorithm) + ", " + _dafny.String(data.WrappingKeySpec) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetParametersForImportRequest) Equals(other GetParametersForImportRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GetParametersForImportRequest_GetParametersForImportRequest:
		{
			data2, ok := other.Get_().(GetParametersForImportRequest_GetParametersForImportRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.WrappingAlgorithm.Equals(data2.WrappingAlgorithm) && data1.WrappingKeySpec.Equals(data2.WrappingKeySpec)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetParametersForImportRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetParametersForImportRequest)
	return ok && _this.Equals(typed)
}

func Type_GetParametersForImportRequest_() _dafny.TypeDescriptor {
	return type_GetParametersForImportRequest_{}
}

type type_GetParametersForImportRequest_ struct {
}

func (_this type_GetParametersForImportRequest_) Default() interface{} {
	return Companion_GetParametersForImportRequest_.Default()
}

func (_this type_GetParametersForImportRequest_) String() string {
	return "ComAmazonawsKmsTypes.GetParametersForImportRequest"
}
func (_this GetParametersForImportRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetParametersForImportRequest{}

// End of datatype GetParametersForImportRequest

// Definition of datatype GetParametersForImportResponse
type GetParametersForImportResponse struct {
	Data_GetParametersForImportResponse_
}

func (_this GetParametersForImportResponse) Get_() Data_GetParametersForImportResponse_ {
	return _this.Data_GetParametersForImportResponse_
}

type Data_GetParametersForImportResponse_ interface {
	isGetParametersForImportResponse()
}

type CompanionStruct_GetParametersForImportResponse_ struct {
}

var Companion_GetParametersForImportResponse_ = CompanionStruct_GetParametersForImportResponse_{}

type GetParametersForImportResponse_GetParametersForImportResponse struct {
	KeyId             m_Wrappers.Option
	ImportToken       m_Wrappers.Option
	PublicKey         m_Wrappers.Option
	ParametersValidTo m_Wrappers.Option
}

func (GetParametersForImportResponse_GetParametersForImportResponse) isGetParametersForImportResponse() {
}

func (CompanionStruct_GetParametersForImportResponse_) Create_GetParametersForImportResponse_(KeyId m_Wrappers.Option, ImportToken m_Wrappers.Option, PublicKey m_Wrappers.Option, ParametersValidTo m_Wrappers.Option) GetParametersForImportResponse {
	return GetParametersForImportResponse{GetParametersForImportResponse_GetParametersForImportResponse{KeyId, ImportToken, PublicKey, ParametersValidTo}}
}

func (_this GetParametersForImportResponse) Is_GetParametersForImportResponse() bool {
	_, ok := _this.Get_().(GetParametersForImportResponse_GetParametersForImportResponse)
	return ok
}

func (CompanionStruct_GetParametersForImportResponse_) Default() GetParametersForImportResponse {
	return Companion_GetParametersForImportResponse_.Create_GetParametersForImportResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GetParametersForImportResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GetParametersForImportResponse_GetParametersForImportResponse).KeyId
}

func (_this GetParametersForImportResponse) Dtor_ImportToken() m_Wrappers.Option {
	return _this.Get_().(GetParametersForImportResponse_GetParametersForImportResponse).ImportToken
}

func (_this GetParametersForImportResponse) Dtor_PublicKey() m_Wrappers.Option {
	return _this.Get_().(GetParametersForImportResponse_GetParametersForImportResponse).PublicKey
}

func (_this GetParametersForImportResponse) Dtor_ParametersValidTo() m_Wrappers.Option {
	return _this.Get_().(GetParametersForImportResponse_GetParametersForImportResponse).ParametersValidTo
}

func (_this GetParametersForImportResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetParametersForImportResponse_GetParametersForImportResponse:
		{
			return "ComAmazonawsKmsTypes.GetParametersForImportResponse.GetParametersForImportResponse" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.ImportToken) + ", " + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.ParametersValidTo) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetParametersForImportResponse) Equals(other GetParametersForImportResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GetParametersForImportResponse_GetParametersForImportResponse:
		{
			data2, ok := other.Get_().(GetParametersForImportResponse_GetParametersForImportResponse)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.ImportToken.Equals(data2.ImportToken) && data1.PublicKey.Equals(data2.PublicKey) && data1.ParametersValidTo.Equals(data2.ParametersValidTo)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetParametersForImportResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetParametersForImportResponse)
	return ok && _this.Equals(typed)
}

func Type_GetParametersForImportResponse_() _dafny.TypeDescriptor {
	return type_GetParametersForImportResponse_{}
}

type type_GetParametersForImportResponse_ struct {
}

func (_this type_GetParametersForImportResponse_) Default() interface{} {
	return Companion_GetParametersForImportResponse_.Default()
}

func (_this type_GetParametersForImportResponse_) String() string {
	return "ComAmazonawsKmsTypes.GetParametersForImportResponse"
}
func (_this GetParametersForImportResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetParametersForImportResponse{}

// End of datatype GetParametersForImportResponse

// Definition of datatype GetPublicKeyRequest
type GetPublicKeyRequest struct {
	Data_GetPublicKeyRequest_
}

func (_this GetPublicKeyRequest) Get_() Data_GetPublicKeyRequest_ {
	return _this.Data_GetPublicKeyRequest_
}

type Data_GetPublicKeyRequest_ interface {
	isGetPublicKeyRequest()
}

type CompanionStruct_GetPublicKeyRequest_ struct {
}

var Companion_GetPublicKeyRequest_ = CompanionStruct_GetPublicKeyRequest_{}

type GetPublicKeyRequest_GetPublicKeyRequest struct {
	KeyId       _dafny.Sequence
	GrantTokens m_Wrappers.Option
}

func (GetPublicKeyRequest_GetPublicKeyRequest) isGetPublicKeyRequest() {}

func (CompanionStruct_GetPublicKeyRequest_) Create_GetPublicKeyRequest_(KeyId _dafny.Sequence, GrantTokens m_Wrappers.Option) GetPublicKeyRequest {
	return GetPublicKeyRequest{GetPublicKeyRequest_GetPublicKeyRequest{KeyId, GrantTokens}}
}

func (_this GetPublicKeyRequest) Is_GetPublicKeyRequest() bool {
	_, ok := _this.Get_().(GetPublicKeyRequest_GetPublicKeyRequest)
	return ok
}

func (CompanionStruct_GetPublicKeyRequest_) Default() GetPublicKeyRequest {
	return Companion_GetPublicKeyRequest_.Create_GetPublicKeyRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this GetPublicKeyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(GetPublicKeyRequest_GetPublicKeyRequest).KeyId
}

func (_this GetPublicKeyRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyRequest_GetPublicKeyRequest).GrantTokens
}

func (_this GetPublicKeyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetPublicKeyRequest_GetPublicKeyRequest:
		{
			return "ComAmazonawsKmsTypes.GetPublicKeyRequest.GetPublicKeyRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.GrantTokens) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetPublicKeyRequest) Equals(other GetPublicKeyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case GetPublicKeyRequest_GetPublicKeyRequest:
		{
			data2, ok := other.Get_().(GetPublicKeyRequest_GetPublicKeyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.GrantTokens.Equals(data2.GrantTokens)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetPublicKeyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetPublicKeyRequest)
	return ok && _this.Equals(typed)
}

func Type_GetPublicKeyRequest_() _dafny.TypeDescriptor {
	return type_GetPublicKeyRequest_{}
}

type type_GetPublicKeyRequest_ struct {
}

func (_this type_GetPublicKeyRequest_) Default() interface{} {
	return Companion_GetPublicKeyRequest_.Default()
}

func (_this type_GetPublicKeyRequest_) String() string {
	return "ComAmazonawsKmsTypes.GetPublicKeyRequest"
}
func (_this GetPublicKeyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetPublicKeyRequest{}

// End of datatype GetPublicKeyRequest

// Definition of datatype GetPublicKeyResponse
type GetPublicKeyResponse struct {
	Data_GetPublicKeyResponse_
}

func (_this GetPublicKeyResponse) Get_() Data_GetPublicKeyResponse_ {
	return _this.Data_GetPublicKeyResponse_
}

type Data_GetPublicKeyResponse_ interface {
	isGetPublicKeyResponse()
}

type CompanionStruct_GetPublicKeyResponse_ struct {
}

var Companion_GetPublicKeyResponse_ = CompanionStruct_GetPublicKeyResponse_{}

type GetPublicKeyResponse_GetPublicKeyResponse struct {
	KeyId                  m_Wrappers.Option
	PublicKey              m_Wrappers.Option
	CustomerMasterKeySpec  m_Wrappers.Option
	KeySpec                m_Wrappers.Option
	KeyUsage               m_Wrappers.Option
	EncryptionAlgorithms   m_Wrappers.Option
	SigningAlgorithms      m_Wrappers.Option
	KeyAgreementAlgorithms m_Wrappers.Option
}

func (GetPublicKeyResponse_GetPublicKeyResponse) isGetPublicKeyResponse() {}

func (CompanionStruct_GetPublicKeyResponse_) Create_GetPublicKeyResponse_(KeyId m_Wrappers.Option, PublicKey m_Wrappers.Option, CustomerMasterKeySpec m_Wrappers.Option, KeySpec m_Wrappers.Option, KeyUsage m_Wrappers.Option, EncryptionAlgorithms m_Wrappers.Option, SigningAlgorithms m_Wrappers.Option, KeyAgreementAlgorithms m_Wrappers.Option) GetPublicKeyResponse {
	return GetPublicKeyResponse{GetPublicKeyResponse_GetPublicKeyResponse{KeyId, PublicKey, CustomerMasterKeySpec, KeySpec, KeyUsage, EncryptionAlgorithms, SigningAlgorithms, KeyAgreementAlgorithms}}
}

func (_this GetPublicKeyResponse) Is_GetPublicKeyResponse() bool {
	_, ok := _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse)
	return ok
}

func (CompanionStruct_GetPublicKeyResponse_) Default() GetPublicKeyResponse {
	return Companion_GetPublicKeyResponse_.Create_GetPublicKeyResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GetPublicKeyResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse).KeyId
}

func (_this GetPublicKeyResponse) Dtor_PublicKey() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse).PublicKey
}

func (_this GetPublicKeyResponse) Dtor_CustomerMasterKeySpec() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse).CustomerMasterKeySpec
}

func (_this GetPublicKeyResponse) Dtor_KeySpec() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse).KeySpec
}

func (_this GetPublicKeyResponse) Dtor_KeyUsage() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse).KeyUsage
}

func (_this GetPublicKeyResponse) Dtor_EncryptionAlgorithms() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse).EncryptionAlgorithms
}

func (_this GetPublicKeyResponse) Dtor_SigningAlgorithms() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse).SigningAlgorithms
}

func (_this GetPublicKeyResponse) Dtor_KeyAgreementAlgorithms() m_Wrappers.Option {
	return _this.Get_().(GetPublicKeyResponse_GetPublicKeyResponse).KeyAgreementAlgorithms
}

func (_this GetPublicKeyResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GetPublicKeyResponse_GetPublicKeyResponse:
		{
			return "ComAmazonawsKmsTypes.GetPublicKeyResponse.GetPublicKeyResponse" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.PublicKey) + ", " + _dafny.String(data.CustomerMasterKeySpec) + ", " + _dafny.String(data.KeySpec) + ", " + _dafny.String(data.KeyUsage) + ", " + _dafny.String(data.EncryptionAlgorithms) + ", " + _dafny.String(data.SigningAlgorithms) + ", " + _dafny.String(data.KeyAgreementAlgorithms) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GetPublicKeyResponse) Equals(other GetPublicKeyResponse) bool {
	switch data1 := _this.Get_().(type) {
	case GetPublicKeyResponse_GetPublicKeyResponse:
		{
			data2, ok := other.Get_().(GetPublicKeyResponse_GetPublicKeyResponse)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.PublicKey.Equals(data2.PublicKey) && data1.CustomerMasterKeySpec.Equals(data2.CustomerMasterKeySpec) && data1.KeySpec.Equals(data2.KeySpec) && data1.KeyUsage.Equals(data2.KeyUsage) && data1.EncryptionAlgorithms.Equals(data2.EncryptionAlgorithms) && data1.SigningAlgorithms.Equals(data2.SigningAlgorithms) && data1.KeyAgreementAlgorithms.Equals(data2.KeyAgreementAlgorithms)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GetPublicKeyResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GetPublicKeyResponse)
	return ok && _this.Equals(typed)
}

func Type_GetPublicKeyResponse_() _dafny.TypeDescriptor {
	return type_GetPublicKeyResponse_{}
}

type type_GetPublicKeyResponse_ struct {
}

func (_this type_GetPublicKeyResponse_) Default() interface{} {
	return Companion_GetPublicKeyResponse_.Default()
}

func (_this type_GetPublicKeyResponse_) String() string {
	return "ComAmazonawsKmsTypes.GetPublicKeyResponse"
}
func (_this GetPublicKeyResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GetPublicKeyResponse{}

// End of datatype GetPublicKeyResponse

// Definition of datatype GrantConstraints
type GrantConstraints struct {
	Data_GrantConstraints_
}

func (_this GrantConstraints) Get_() Data_GrantConstraints_ {
	return _this.Data_GrantConstraints_
}

type Data_GrantConstraints_ interface {
	isGrantConstraints()
}

type CompanionStruct_GrantConstraints_ struct {
}

var Companion_GrantConstraints_ = CompanionStruct_GrantConstraints_{}

type GrantConstraints_GrantConstraints struct {
	EncryptionContextSubset m_Wrappers.Option
	EncryptionContextEquals m_Wrappers.Option
}

func (GrantConstraints_GrantConstraints) isGrantConstraints() {}

func (CompanionStruct_GrantConstraints_) Create_GrantConstraints_(EncryptionContextSubset m_Wrappers.Option, EncryptionContextEquals m_Wrappers.Option) GrantConstraints {
	return GrantConstraints{GrantConstraints_GrantConstraints{EncryptionContextSubset, EncryptionContextEquals}}
}

func (_this GrantConstraints) Is_GrantConstraints() bool {
	_, ok := _this.Get_().(GrantConstraints_GrantConstraints)
	return ok
}

func (CompanionStruct_GrantConstraints_) Default() GrantConstraints {
	return Companion_GrantConstraints_.Create_GrantConstraints_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GrantConstraints) Dtor_EncryptionContextSubset() m_Wrappers.Option {
	return _this.Get_().(GrantConstraints_GrantConstraints).EncryptionContextSubset
}

func (_this GrantConstraints) Dtor_EncryptionContextEquals() m_Wrappers.Option {
	return _this.Get_().(GrantConstraints_GrantConstraints).EncryptionContextEquals
}

func (_this GrantConstraints) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GrantConstraints_GrantConstraints:
		{
			return "ComAmazonawsKmsTypes.GrantConstraints.GrantConstraints" + "(" + _dafny.String(data.EncryptionContextSubset) + ", " + _dafny.String(data.EncryptionContextEquals) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GrantConstraints) Equals(other GrantConstraints) bool {
	switch data1 := _this.Get_().(type) {
	case GrantConstraints_GrantConstraints:
		{
			data2, ok := other.Get_().(GrantConstraints_GrantConstraints)
			return ok && data1.EncryptionContextSubset.Equals(data2.EncryptionContextSubset) && data1.EncryptionContextEquals.Equals(data2.EncryptionContextEquals)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GrantConstraints) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GrantConstraints)
	return ok && _this.Equals(typed)
}

func Type_GrantConstraints_() _dafny.TypeDescriptor {
	return type_GrantConstraints_{}
}

type type_GrantConstraints_ struct {
}

func (_this type_GrantConstraints_) Default() interface{} {
	return Companion_GrantConstraints_.Default()
}

func (_this type_GrantConstraints_) String() string {
	return "ComAmazonawsKmsTypes.GrantConstraints"
}
func (_this GrantConstraints) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GrantConstraints{}

// End of datatype GrantConstraints

// Definition of class GrantIdType
type GrantIdType struct {
}

func New_GrantIdType_() *GrantIdType {
	_this := GrantIdType{}

	return &_this
}

type CompanionStruct_GrantIdType_ struct {
}

var Companion_GrantIdType_ = CompanionStruct_GrantIdType_{}

func (*GrantIdType) String() string {
	return "ComAmazonawsKmsTypes.GrantIdType"
}

// End of class GrantIdType

func Type_GrantIdType_() _dafny.TypeDescriptor {
	return type_GrantIdType_{}
}

type type_GrantIdType_ struct {
}

func (_this type_GrantIdType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_GrantIdType_) String() string {
	return "ComAmazonawsKmsTypes.GrantIdType"
}
func (_this *CompanionStruct_GrantIdType_) Is_(__source _dafny.Sequence) bool {
	var _8_x _dafny.Sequence = (__source)
	_ = _8_x
	return Companion_Default___.IsValid__GrantIdType(_8_x)
}

// Definition of datatype GrantListEntry
type GrantListEntry struct {
	Data_GrantListEntry_
}

func (_this GrantListEntry) Get_() Data_GrantListEntry_ {
	return _this.Data_GrantListEntry_
}

type Data_GrantListEntry_ interface {
	isGrantListEntry()
}

type CompanionStruct_GrantListEntry_ struct {
}

var Companion_GrantListEntry_ = CompanionStruct_GrantListEntry_{}

type GrantListEntry_GrantListEntry struct {
	KeyId             m_Wrappers.Option
	GrantId           m_Wrappers.Option
	Name              m_Wrappers.Option
	CreationDate      m_Wrappers.Option
	GranteePrincipal  m_Wrappers.Option
	RetiringPrincipal m_Wrappers.Option
	IssuingAccount    m_Wrappers.Option
	Operations        m_Wrappers.Option
	Constraints       m_Wrappers.Option
}

func (GrantListEntry_GrantListEntry) isGrantListEntry() {}

func (CompanionStruct_GrantListEntry_) Create_GrantListEntry_(KeyId m_Wrappers.Option, GrantId m_Wrappers.Option, Name m_Wrappers.Option, CreationDate m_Wrappers.Option, GranteePrincipal m_Wrappers.Option, RetiringPrincipal m_Wrappers.Option, IssuingAccount m_Wrappers.Option, Operations m_Wrappers.Option, Constraints m_Wrappers.Option) GrantListEntry {
	return GrantListEntry{GrantListEntry_GrantListEntry{KeyId, GrantId, Name, CreationDate, GranteePrincipal, RetiringPrincipal, IssuingAccount, Operations, Constraints}}
}

func (_this GrantListEntry) Is_GrantListEntry() bool {
	_, ok := _this.Get_().(GrantListEntry_GrantListEntry)
	return ok
}

func (CompanionStruct_GrantListEntry_) Default() GrantListEntry {
	return Companion_GrantListEntry_.Create_GrantListEntry_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this GrantListEntry) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).KeyId
}

func (_this GrantListEntry) Dtor_GrantId() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).GrantId
}

func (_this GrantListEntry) Dtor_Name() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).Name
}

func (_this GrantListEntry) Dtor_CreationDate() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).CreationDate
}

func (_this GrantListEntry) Dtor_GranteePrincipal() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).GranteePrincipal
}

func (_this GrantListEntry) Dtor_RetiringPrincipal() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).RetiringPrincipal
}

func (_this GrantListEntry) Dtor_IssuingAccount() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).IssuingAccount
}

func (_this GrantListEntry) Dtor_Operations() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).Operations
}

func (_this GrantListEntry) Dtor_Constraints() m_Wrappers.Option {
	return _this.Get_().(GrantListEntry_GrantListEntry).Constraints
}

func (_this GrantListEntry) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case GrantListEntry_GrantListEntry:
		{
			return "ComAmazonawsKmsTypes.GrantListEntry.GrantListEntry" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.GrantId) + ", " + _dafny.String(data.Name) + ", " + _dafny.String(data.CreationDate) + ", " + _dafny.String(data.GranteePrincipal) + ", " + _dafny.String(data.RetiringPrincipal) + ", " + _dafny.String(data.IssuingAccount) + ", " + _dafny.String(data.Operations) + ", " + _dafny.String(data.Constraints) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GrantListEntry) Equals(other GrantListEntry) bool {
	switch data1 := _this.Get_().(type) {
	case GrantListEntry_GrantListEntry:
		{
			data2, ok := other.Get_().(GrantListEntry_GrantListEntry)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.GrantId.Equals(data2.GrantId) && data1.Name.Equals(data2.Name) && data1.CreationDate.Equals(data2.CreationDate) && data1.GranteePrincipal.Equals(data2.GranteePrincipal) && data1.RetiringPrincipal.Equals(data2.RetiringPrincipal) && data1.IssuingAccount.Equals(data2.IssuingAccount) && data1.Operations.Equals(data2.Operations) && data1.Constraints.Equals(data2.Constraints)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GrantListEntry) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GrantListEntry)
	return ok && _this.Equals(typed)
}

func Type_GrantListEntry_() _dafny.TypeDescriptor {
	return type_GrantListEntry_{}
}

type type_GrantListEntry_ struct {
}

func (_this type_GrantListEntry_) Default() interface{} {
	return Companion_GrantListEntry_.Default()
}

func (_this type_GrantListEntry_) String() string {
	return "ComAmazonawsKmsTypes.GrantListEntry"
}
func (_this GrantListEntry) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GrantListEntry{}

// End of datatype GrantListEntry

// Definition of class GrantNameType
type GrantNameType struct {
}

func New_GrantNameType_() *GrantNameType {
	_this := GrantNameType{}

	return &_this
}

type CompanionStruct_GrantNameType_ struct {
}

var Companion_GrantNameType_ = CompanionStruct_GrantNameType_{}

func (*GrantNameType) String() string {
	return "ComAmazonawsKmsTypes.GrantNameType"
}

// End of class GrantNameType

func Type_GrantNameType_() _dafny.TypeDescriptor {
	return type_GrantNameType_{}
}

type type_GrantNameType_ struct {
}

func (_this type_GrantNameType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_GrantNameType_) String() string {
	return "ComAmazonawsKmsTypes.GrantNameType"
}
func (_this *CompanionStruct_GrantNameType_) Is_(__source _dafny.Sequence) bool {
	var _9_x _dafny.Sequence = (__source)
	_ = _9_x
	return Companion_Default___.IsValid__GrantNameType(_9_x)
}

// Definition of datatype GrantOperation
type GrantOperation struct {
	Data_GrantOperation_
}

func (_this GrantOperation) Get_() Data_GrantOperation_ {
	return _this.Data_GrantOperation_
}

type Data_GrantOperation_ interface {
	isGrantOperation()
}

type CompanionStruct_GrantOperation_ struct {
}

var Companion_GrantOperation_ = CompanionStruct_GrantOperation_{}

type GrantOperation_Decrypt struct {
}

func (GrantOperation_Decrypt) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_Decrypt_() GrantOperation {
	return GrantOperation{GrantOperation_Decrypt{}}
}

func (_this GrantOperation) Is_Decrypt() bool {
	_, ok := _this.Get_().(GrantOperation_Decrypt)
	return ok
}

type GrantOperation_Encrypt struct {
}

func (GrantOperation_Encrypt) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_Encrypt_() GrantOperation {
	return GrantOperation{GrantOperation_Encrypt{}}
}

func (_this GrantOperation) Is_Encrypt() bool {
	_, ok := _this.Get_().(GrantOperation_Encrypt)
	return ok
}

type GrantOperation_GenerateDataKey struct {
}

func (GrantOperation_GenerateDataKey) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_GenerateDataKey_() GrantOperation {
	return GrantOperation{GrantOperation_GenerateDataKey{}}
}

func (_this GrantOperation) Is_GenerateDataKey() bool {
	_, ok := _this.Get_().(GrantOperation_GenerateDataKey)
	return ok
}

type GrantOperation_GenerateDataKeyWithoutPlaintext struct {
}

func (GrantOperation_GenerateDataKeyWithoutPlaintext) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_GenerateDataKeyWithoutPlaintext_() GrantOperation {
	return GrantOperation{GrantOperation_GenerateDataKeyWithoutPlaintext{}}
}

func (_this GrantOperation) Is_GenerateDataKeyWithoutPlaintext() bool {
	_, ok := _this.Get_().(GrantOperation_GenerateDataKeyWithoutPlaintext)
	return ok
}

type GrantOperation_ReEncryptFrom struct {
}

func (GrantOperation_ReEncryptFrom) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_ReEncryptFrom_() GrantOperation {
	return GrantOperation{GrantOperation_ReEncryptFrom{}}
}

func (_this GrantOperation) Is_ReEncryptFrom() bool {
	_, ok := _this.Get_().(GrantOperation_ReEncryptFrom)
	return ok
}

type GrantOperation_ReEncryptTo struct {
}

func (GrantOperation_ReEncryptTo) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_ReEncryptTo_() GrantOperation {
	return GrantOperation{GrantOperation_ReEncryptTo{}}
}

func (_this GrantOperation) Is_ReEncryptTo() bool {
	_, ok := _this.Get_().(GrantOperation_ReEncryptTo)
	return ok
}

type GrantOperation_Sign struct {
}

func (GrantOperation_Sign) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_Sign_() GrantOperation {
	return GrantOperation{GrantOperation_Sign{}}
}

func (_this GrantOperation) Is_Sign() bool {
	_, ok := _this.Get_().(GrantOperation_Sign)
	return ok
}

type GrantOperation_Verify struct {
}

func (GrantOperation_Verify) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_Verify_() GrantOperation {
	return GrantOperation{GrantOperation_Verify{}}
}

func (_this GrantOperation) Is_Verify() bool {
	_, ok := _this.Get_().(GrantOperation_Verify)
	return ok
}

type GrantOperation_GetPublicKey struct {
}

func (GrantOperation_GetPublicKey) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_GetPublicKey_() GrantOperation {
	return GrantOperation{GrantOperation_GetPublicKey{}}
}

func (_this GrantOperation) Is_GetPublicKey() bool {
	_, ok := _this.Get_().(GrantOperation_GetPublicKey)
	return ok
}

type GrantOperation_CreateGrant struct {
}

func (GrantOperation_CreateGrant) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_CreateGrant_() GrantOperation {
	return GrantOperation{GrantOperation_CreateGrant{}}
}

func (_this GrantOperation) Is_CreateGrant() bool {
	_, ok := _this.Get_().(GrantOperation_CreateGrant)
	return ok
}

type GrantOperation_RetireGrant struct {
}

func (GrantOperation_RetireGrant) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_RetireGrant_() GrantOperation {
	return GrantOperation{GrantOperation_RetireGrant{}}
}

func (_this GrantOperation) Is_RetireGrant() bool {
	_, ok := _this.Get_().(GrantOperation_RetireGrant)
	return ok
}

type GrantOperation_DescribeKey struct {
}

func (GrantOperation_DescribeKey) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_DescribeKey_() GrantOperation {
	return GrantOperation{GrantOperation_DescribeKey{}}
}

func (_this GrantOperation) Is_DescribeKey() bool {
	_, ok := _this.Get_().(GrantOperation_DescribeKey)
	return ok
}

type GrantOperation_GenerateDataKeyPair struct {
}

func (GrantOperation_GenerateDataKeyPair) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_GenerateDataKeyPair_() GrantOperation {
	return GrantOperation{GrantOperation_GenerateDataKeyPair{}}
}

func (_this GrantOperation) Is_GenerateDataKeyPair() bool {
	_, ok := _this.Get_().(GrantOperation_GenerateDataKeyPair)
	return ok
}

type GrantOperation_GenerateDataKeyPairWithoutPlaintext struct {
}

func (GrantOperation_GenerateDataKeyPairWithoutPlaintext) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_GenerateDataKeyPairWithoutPlaintext_() GrantOperation {
	return GrantOperation{GrantOperation_GenerateDataKeyPairWithoutPlaintext{}}
}

func (_this GrantOperation) Is_GenerateDataKeyPairWithoutPlaintext() bool {
	_, ok := _this.Get_().(GrantOperation_GenerateDataKeyPairWithoutPlaintext)
	return ok
}

type GrantOperation_GenerateMac struct {
}

func (GrantOperation_GenerateMac) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_GenerateMac_() GrantOperation {
	return GrantOperation{GrantOperation_GenerateMac{}}
}

func (_this GrantOperation) Is_GenerateMac() bool {
	_, ok := _this.Get_().(GrantOperation_GenerateMac)
	return ok
}

type GrantOperation_VerifyMac struct {
}

func (GrantOperation_VerifyMac) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_VerifyMac_() GrantOperation {
	return GrantOperation{GrantOperation_VerifyMac{}}
}

func (_this GrantOperation) Is_VerifyMac() bool {
	_, ok := _this.Get_().(GrantOperation_VerifyMac)
	return ok
}

type GrantOperation_DeriveSharedSecret struct {
}

func (GrantOperation_DeriveSharedSecret) isGrantOperation() {}

func (CompanionStruct_GrantOperation_) Create_DeriveSharedSecret_() GrantOperation {
	return GrantOperation{GrantOperation_DeriveSharedSecret{}}
}

func (_this GrantOperation) Is_DeriveSharedSecret() bool {
	_, ok := _this.Get_().(GrantOperation_DeriveSharedSecret)
	return ok
}

func (CompanionStruct_GrantOperation_) Default() GrantOperation {
	return Companion_GrantOperation_.Create_Decrypt_()
}

func (_ CompanionStruct_GrantOperation_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_GrantOperation_.Create_Decrypt_(), true
		case 1:
			return Companion_GrantOperation_.Create_Encrypt_(), true
		case 2:
			return Companion_GrantOperation_.Create_GenerateDataKey_(), true
		case 3:
			return Companion_GrantOperation_.Create_GenerateDataKeyWithoutPlaintext_(), true
		case 4:
			return Companion_GrantOperation_.Create_ReEncryptFrom_(), true
		case 5:
			return Companion_GrantOperation_.Create_ReEncryptTo_(), true
		case 6:
			return Companion_GrantOperation_.Create_Sign_(), true
		case 7:
			return Companion_GrantOperation_.Create_Verify_(), true
		case 8:
			return Companion_GrantOperation_.Create_GetPublicKey_(), true
		case 9:
			return Companion_GrantOperation_.Create_CreateGrant_(), true
		case 10:
			return Companion_GrantOperation_.Create_RetireGrant_(), true
		case 11:
			return Companion_GrantOperation_.Create_DescribeKey_(), true
		case 12:
			return Companion_GrantOperation_.Create_GenerateDataKeyPair_(), true
		case 13:
			return Companion_GrantOperation_.Create_GenerateDataKeyPairWithoutPlaintext_(), true
		case 14:
			return Companion_GrantOperation_.Create_GenerateMac_(), true
		case 15:
			return Companion_GrantOperation_.Create_VerifyMac_(), true
		case 16:
			return Companion_GrantOperation_.Create_DeriveSharedSecret_(), true
		default:
			return GrantOperation{}, false
		}
	}
}

func (_this GrantOperation) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case GrantOperation_Decrypt:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.Decrypt"
		}
	case GrantOperation_Encrypt:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.Encrypt"
		}
	case GrantOperation_GenerateDataKey:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.GenerateDataKey"
		}
	case GrantOperation_GenerateDataKeyWithoutPlaintext:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.GenerateDataKeyWithoutPlaintext"
		}
	case GrantOperation_ReEncryptFrom:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.ReEncryptFrom"
		}
	case GrantOperation_ReEncryptTo:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.ReEncryptTo"
		}
	case GrantOperation_Sign:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.Sign"
		}
	case GrantOperation_Verify:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.Verify"
		}
	case GrantOperation_GetPublicKey:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.GetPublicKey"
		}
	case GrantOperation_CreateGrant:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.CreateGrant"
		}
	case GrantOperation_RetireGrant:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.RetireGrant"
		}
	case GrantOperation_DescribeKey:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.DescribeKey"
		}
	case GrantOperation_GenerateDataKeyPair:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.GenerateDataKeyPair"
		}
	case GrantOperation_GenerateDataKeyPairWithoutPlaintext:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.GenerateDataKeyPairWithoutPlaintext"
		}
	case GrantOperation_GenerateMac:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.GenerateMac"
		}
	case GrantOperation_VerifyMac:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.VerifyMac"
		}
	case GrantOperation_DeriveSharedSecret:
		{
			return "ComAmazonawsKmsTypes.GrantOperation.DeriveSharedSecret"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this GrantOperation) Equals(other GrantOperation) bool {
	switch _this.Get_().(type) {
	case GrantOperation_Decrypt:
		{
			_, ok := other.Get_().(GrantOperation_Decrypt)
			return ok
		}
	case GrantOperation_Encrypt:
		{
			_, ok := other.Get_().(GrantOperation_Encrypt)
			return ok
		}
	case GrantOperation_GenerateDataKey:
		{
			_, ok := other.Get_().(GrantOperation_GenerateDataKey)
			return ok
		}
	case GrantOperation_GenerateDataKeyWithoutPlaintext:
		{
			_, ok := other.Get_().(GrantOperation_GenerateDataKeyWithoutPlaintext)
			return ok
		}
	case GrantOperation_ReEncryptFrom:
		{
			_, ok := other.Get_().(GrantOperation_ReEncryptFrom)
			return ok
		}
	case GrantOperation_ReEncryptTo:
		{
			_, ok := other.Get_().(GrantOperation_ReEncryptTo)
			return ok
		}
	case GrantOperation_Sign:
		{
			_, ok := other.Get_().(GrantOperation_Sign)
			return ok
		}
	case GrantOperation_Verify:
		{
			_, ok := other.Get_().(GrantOperation_Verify)
			return ok
		}
	case GrantOperation_GetPublicKey:
		{
			_, ok := other.Get_().(GrantOperation_GetPublicKey)
			return ok
		}
	case GrantOperation_CreateGrant:
		{
			_, ok := other.Get_().(GrantOperation_CreateGrant)
			return ok
		}
	case GrantOperation_RetireGrant:
		{
			_, ok := other.Get_().(GrantOperation_RetireGrant)
			return ok
		}
	case GrantOperation_DescribeKey:
		{
			_, ok := other.Get_().(GrantOperation_DescribeKey)
			return ok
		}
	case GrantOperation_GenerateDataKeyPair:
		{
			_, ok := other.Get_().(GrantOperation_GenerateDataKeyPair)
			return ok
		}
	case GrantOperation_GenerateDataKeyPairWithoutPlaintext:
		{
			_, ok := other.Get_().(GrantOperation_GenerateDataKeyPairWithoutPlaintext)
			return ok
		}
	case GrantOperation_GenerateMac:
		{
			_, ok := other.Get_().(GrantOperation_GenerateMac)
			return ok
		}
	case GrantOperation_VerifyMac:
		{
			_, ok := other.Get_().(GrantOperation_VerifyMac)
			return ok
		}
	case GrantOperation_DeriveSharedSecret:
		{
			_, ok := other.Get_().(GrantOperation_DeriveSharedSecret)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this GrantOperation) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(GrantOperation)
	return ok && _this.Equals(typed)
}

func Type_GrantOperation_() _dafny.TypeDescriptor {
	return type_GrantOperation_{}
}

type type_GrantOperation_ struct {
}

func (_this type_GrantOperation_) Default() interface{} {
	return Companion_GrantOperation_.Default()
}

func (_this type_GrantOperation_) String() string {
	return "ComAmazonawsKmsTypes.GrantOperation"
}
func (_this GrantOperation) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = GrantOperation{}

// End of datatype GrantOperation

// Definition of class GrantTokenList
type GrantTokenList struct {
}

func New_GrantTokenList_() *GrantTokenList {
	_this := GrantTokenList{}

	return &_this
}

type CompanionStruct_GrantTokenList_ struct {
}

var Companion_GrantTokenList_ = CompanionStruct_GrantTokenList_{}

func (*GrantTokenList) String() string {
	return "ComAmazonawsKmsTypes.GrantTokenList"
}

// End of class GrantTokenList

func Type_GrantTokenList_() _dafny.TypeDescriptor {
	return type_GrantTokenList_{}
}

type type_GrantTokenList_ struct {
}

func (_this type_GrantTokenList_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_GrantTokenList_) String() string {
	return "ComAmazonawsKmsTypes.GrantTokenList"
}
func (_this *CompanionStruct_GrantTokenList_) Is_(__source _dafny.Sequence) bool {
	var _10_x _dafny.Sequence = (__source)
	_ = _10_x
	return Companion_Default___.IsValid__GrantTokenList(_10_x)
}

// Definition of class GrantTokenType
type GrantTokenType struct {
}

func New_GrantTokenType_() *GrantTokenType {
	_this := GrantTokenType{}

	return &_this
}

type CompanionStruct_GrantTokenType_ struct {
}

var Companion_GrantTokenType_ = CompanionStruct_GrantTokenType_{}

func (*GrantTokenType) String() string {
	return "ComAmazonawsKmsTypes.GrantTokenType"
}

// End of class GrantTokenType

func Type_GrantTokenType_() _dafny.TypeDescriptor {
	return type_GrantTokenType_{}
}

type type_GrantTokenType_ struct {
}

func (_this type_GrantTokenType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_GrantTokenType_) String() string {
	return "ComAmazonawsKmsTypes.GrantTokenType"
}
func (_this *CompanionStruct_GrantTokenType_) Is_(__source _dafny.Sequence) bool {
	var _11_x _dafny.Sequence = (__source)
	_ = _11_x
	return Companion_Default___.IsValid__GrantTokenType(_11_x)
}

// Definition of datatype ImportKeyMaterialRequest
type ImportKeyMaterialRequest struct {
	Data_ImportKeyMaterialRequest_
}

func (_this ImportKeyMaterialRequest) Get_() Data_ImportKeyMaterialRequest_ {
	return _this.Data_ImportKeyMaterialRequest_
}

type Data_ImportKeyMaterialRequest_ interface {
	isImportKeyMaterialRequest()
}

type CompanionStruct_ImportKeyMaterialRequest_ struct {
}

var Companion_ImportKeyMaterialRequest_ = CompanionStruct_ImportKeyMaterialRequest_{}

type ImportKeyMaterialRequest_ImportKeyMaterialRequest struct {
	KeyId                _dafny.Sequence
	ImportToken          _dafny.Sequence
	EncryptedKeyMaterial _dafny.Sequence
	ValidTo              m_Wrappers.Option
	ExpirationModel      m_Wrappers.Option
}

func (ImportKeyMaterialRequest_ImportKeyMaterialRequest) isImportKeyMaterialRequest() {}

func (CompanionStruct_ImportKeyMaterialRequest_) Create_ImportKeyMaterialRequest_(KeyId _dafny.Sequence, ImportToken _dafny.Sequence, EncryptedKeyMaterial _dafny.Sequence, ValidTo m_Wrappers.Option, ExpirationModel m_Wrappers.Option) ImportKeyMaterialRequest {
	return ImportKeyMaterialRequest{ImportKeyMaterialRequest_ImportKeyMaterialRequest{KeyId, ImportToken, EncryptedKeyMaterial, ValidTo, ExpirationModel}}
}

func (_this ImportKeyMaterialRequest) Is_ImportKeyMaterialRequest() bool {
	_, ok := _this.Get_().(ImportKeyMaterialRequest_ImportKeyMaterialRequest)
	return ok
}

func (CompanionStruct_ImportKeyMaterialRequest_) Default() ImportKeyMaterialRequest {
	return Companion_ImportKeyMaterialRequest_.Create_ImportKeyMaterialRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ImportKeyMaterialRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(ImportKeyMaterialRequest_ImportKeyMaterialRequest).KeyId
}

func (_this ImportKeyMaterialRequest) Dtor_ImportToken() _dafny.Sequence {
	return _this.Get_().(ImportKeyMaterialRequest_ImportKeyMaterialRequest).ImportToken
}

func (_this ImportKeyMaterialRequest) Dtor_EncryptedKeyMaterial() _dafny.Sequence {
	return _this.Get_().(ImportKeyMaterialRequest_ImportKeyMaterialRequest).EncryptedKeyMaterial
}

func (_this ImportKeyMaterialRequest) Dtor_ValidTo() m_Wrappers.Option {
	return _this.Get_().(ImportKeyMaterialRequest_ImportKeyMaterialRequest).ValidTo
}

func (_this ImportKeyMaterialRequest) Dtor_ExpirationModel() m_Wrappers.Option {
	return _this.Get_().(ImportKeyMaterialRequest_ImportKeyMaterialRequest).ExpirationModel
}

func (_this ImportKeyMaterialRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ImportKeyMaterialRequest_ImportKeyMaterialRequest:
		{
			return "ComAmazonawsKmsTypes.ImportKeyMaterialRequest.ImportKeyMaterialRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.ImportToken) + ", " + _dafny.String(data.EncryptedKeyMaterial) + ", " + _dafny.String(data.ValidTo) + ", " + _dafny.String(data.ExpirationModel) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ImportKeyMaterialRequest) Equals(other ImportKeyMaterialRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ImportKeyMaterialRequest_ImportKeyMaterialRequest:
		{
			data2, ok := other.Get_().(ImportKeyMaterialRequest_ImportKeyMaterialRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.ImportToken.Equals(data2.ImportToken) && data1.EncryptedKeyMaterial.Equals(data2.EncryptedKeyMaterial) && data1.ValidTo.Equals(data2.ValidTo) && data1.ExpirationModel.Equals(data2.ExpirationModel)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ImportKeyMaterialRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ImportKeyMaterialRequest)
	return ok && _this.Equals(typed)
}

func Type_ImportKeyMaterialRequest_() _dafny.TypeDescriptor {
	return type_ImportKeyMaterialRequest_{}
}

type type_ImportKeyMaterialRequest_ struct {
}

func (_this type_ImportKeyMaterialRequest_) Default() interface{} {
	return Companion_ImportKeyMaterialRequest_.Default()
}

func (_this type_ImportKeyMaterialRequest_) String() string {
	return "ComAmazonawsKmsTypes.ImportKeyMaterialRequest"
}
func (_this ImportKeyMaterialRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ImportKeyMaterialRequest{}

// End of datatype ImportKeyMaterialRequest

// Definition of datatype ImportKeyMaterialResponse
type ImportKeyMaterialResponse struct {
	Data_ImportKeyMaterialResponse_
}

func (_this ImportKeyMaterialResponse) Get_() Data_ImportKeyMaterialResponse_ {
	return _this.Data_ImportKeyMaterialResponse_
}

type Data_ImportKeyMaterialResponse_ interface {
	isImportKeyMaterialResponse()
}

type CompanionStruct_ImportKeyMaterialResponse_ struct {
}

var Companion_ImportKeyMaterialResponse_ = CompanionStruct_ImportKeyMaterialResponse_{}

type ImportKeyMaterialResponse_ImportKeyMaterialResponse struct {
}

func (ImportKeyMaterialResponse_ImportKeyMaterialResponse) isImportKeyMaterialResponse() {}

func (CompanionStruct_ImportKeyMaterialResponse_) Create_ImportKeyMaterialResponse_() ImportKeyMaterialResponse {
	return ImportKeyMaterialResponse{ImportKeyMaterialResponse_ImportKeyMaterialResponse{}}
}

func (_this ImportKeyMaterialResponse) Is_ImportKeyMaterialResponse() bool {
	_, ok := _this.Get_().(ImportKeyMaterialResponse_ImportKeyMaterialResponse)
	return ok
}

func (CompanionStruct_ImportKeyMaterialResponse_) Default() ImportKeyMaterialResponse {
	return Companion_ImportKeyMaterialResponse_.Create_ImportKeyMaterialResponse_()
}

func (_ CompanionStruct_ImportKeyMaterialResponse_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_ImportKeyMaterialResponse_.Create_ImportKeyMaterialResponse_(), true
		default:
			return ImportKeyMaterialResponse{}, false
		}
	}
}

func (_this ImportKeyMaterialResponse) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case ImportKeyMaterialResponse_ImportKeyMaterialResponse:
		{
			return "ComAmazonawsKmsTypes.ImportKeyMaterialResponse.ImportKeyMaterialResponse"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ImportKeyMaterialResponse) Equals(other ImportKeyMaterialResponse) bool {
	switch _this.Get_().(type) {
	case ImportKeyMaterialResponse_ImportKeyMaterialResponse:
		{
			_, ok := other.Get_().(ImportKeyMaterialResponse_ImportKeyMaterialResponse)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ImportKeyMaterialResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ImportKeyMaterialResponse)
	return ok && _this.Equals(typed)
}

func Type_ImportKeyMaterialResponse_() _dafny.TypeDescriptor {
	return type_ImportKeyMaterialResponse_{}
}

type type_ImportKeyMaterialResponse_ struct {
}

func (_this type_ImportKeyMaterialResponse_) Default() interface{} {
	return Companion_ImportKeyMaterialResponse_.Default()
}

func (_this type_ImportKeyMaterialResponse_) String() string {
	return "ComAmazonawsKmsTypes.ImportKeyMaterialResponse"
}
func (_this ImportKeyMaterialResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ImportKeyMaterialResponse{}

// End of datatype ImportKeyMaterialResponse

// Definition of datatype KeyAgreementAlgorithmSpec
type KeyAgreementAlgorithmSpec struct {
	Data_KeyAgreementAlgorithmSpec_
}

func (_this KeyAgreementAlgorithmSpec) Get_() Data_KeyAgreementAlgorithmSpec_ {
	return _this.Data_KeyAgreementAlgorithmSpec_
}

type Data_KeyAgreementAlgorithmSpec_ interface {
	isKeyAgreementAlgorithmSpec()
}

type CompanionStruct_KeyAgreementAlgorithmSpec_ struct {
}

var Companion_KeyAgreementAlgorithmSpec_ = CompanionStruct_KeyAgreementAlgorithmSpec_{}

type KeyAgreementAlgorithmSpec_ECDH struct {
}

func (KeyAgreementAlgorithmSpec_ECDH) isKeyAgreementAlgorithmSpec() {}

func (CompanionStruct_KeyAgreementAlgorithmSpec_) Create_ECDH_() KeyAgreementAlgorithmSpec {
	return KeyAgreementAlgorithmSpec{KeyAgreementAlgorithmSpec_ECDH{}}
}

func (_this KeyAgreementAlgorithmSpec) Is_ECDH() bool {
	_, ok := _this.Get_().(KeyAgreementAlgorithmSpec_ECDH)
	return ok
}

func (CompanionStruct_KeyAgreementAlgorithmSpec_) Default() KeyAgreementAlgorithmSpec {
	return Companion_KeyAgreementAlgorithmSpec_.Create_ECDH_()
}

func (_ CompanionStruct_KeyAgreementAlgorithmSpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KeyAgreementAlgorithmSpec_.Create_ECDH_(), true
		default:
			return KeyAgreementAlgorithmSpec{}, false
		}
	}
}

func (_this KeyAgreementAlgorithmSpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KeyAgreementAlgorithmSpec_ECDH:
		{
			return "ComAmazonawsKmsTypes.KeyAgreementAlgorithmSpec.ECDH"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyAgreementAlgorithmSpec) Equals(other KeyAgreementAlgorithmSpec) bool {
	switch _this.Get_().(type) {
	case KeyAgreementAlgorithmSpec_ECDH:
		{
			_, ok := other.Get_().(KeyAgreementAlgorithmSpec_ECDH)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyAgreementAlgorithmSpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyAgreementAlgorithmSpec)
	return ok && _this.Equals(typed)
}

func Type_KeyAgreementAlgorithmSpec_() _dafny.TypeDescriptor {
	return type_KeyAgreementAlgorithmSpec_{}
}

type type_KeyAgreementAlgorithmSpec_ struct {
}

func (_this type_KeyAgreementAlgorithmSpec_) Default() interface{} {
	return Companion_KeyAgreementAlgorithmSpec_.Default()
}

func (_this type_KeyAgreementAlgorithmSpec_) String() string {
	return "ComAmazonawsKmsTypes.KeyAgreementAlgorithmSpec"
}
func (_this KeyAgreementAlgorithmSpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyAgreementAlgorithmSpec{}

// End of datatype KeyAgreementAlgorithmSpec

// Definition of datatype KeyEncryptionMechanism
type KeyEncryptionMechanism struct {
	Data_KeyEncryptionMechanism_
}

func (_this KeyEncryptionMechanism) Get_() Data_KeyEncryptionMechanism_ {
	return _this.Data_KeyEncryptionMechanism_
}

type Data_KeyEncryptionMechanism_ interface {
	isKeyEncryptionMechanism()
}

type CompanionStruct_KeyEncryptionMechanism_ struct {
}

var Companion_KeyEncryptionMechanism_ = CompanionStruct_KeyEncryptionMechanism_{}

type KeyEncryptionMechanism_RSAES__OAEP__SHA__256 struct {
}

func (KeyEncryptionMechanism_RSAES__OAEP__SHA__256) isKeyEncryptionMechanism() {}

func (CompanionStruct_KeyEncryptionMechanism_) Create_RSAES__OAEP__SHA__256_() KeyEncryptionMechanism {
	return KeyEncryptionMechanism{KeyEncryptionMechanism_RSAES__OAEP__SHA__256{}}
}

func (_this KeyEncryptionMechanism) Is_RSAES__OAEP__SHA__256() bool {
	_, ok := _this.Get_().(KeyEncryptionMechanism_RSAES__OAEP__SHA__256)
	return ok
}

func (CompanionStruct_KeyEncryptionMechanism_) Default() KeyEncryptionMechanism {
	return Companion_KeyEncryptionMechanism_.Create_RSAES__OAEP__SHA__256_()
}

func (_ CompanionStruct_KeyEncryptionMechanism_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KeyEncryptionMechanism_.Create_RSAES__OAEP__SHA__256_(), true
		default:
			return KeyEncryptionMechanism{}, false
		}
	}
}

func (_this KeyEncryptionMechanism) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KeyEncryptionMechanism_RSAES__OAEP__SHA__256:
		{
			return "ComAmazonawsKmsTypes.KeyEncryptionMechanism.RSAES_OAEP_SHA_256"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyEncryptionMechanism) Equals(other KeyEncryptionMechanism) bool {
	switch _this.Get_().(type) {
	case KeyEncryptionMechanism_RSAES__OAEP__SHA__256:
		{
			_, ok := other.Get_().(KeyEncryptionMechanism_RSAES__OAEP__SHA__256)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyEncryptionMechanism) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyEncryptionMechanism)
	return ok && _this.Equals(typed)
}

func Type_KeyEncryptionMechanism_() _dafny.TypeDescriptor {
	return type_KeyEncryptionMechanism_{}
}

type type_KeyEncryptionMechanism_ struct {
}

func (_this type_KeyEncryptionMechanism_) Default() interface{} {
	return Companion_KeyEncryptionMechanism_.Default()
}

func (_this type_KeyEncryptionMechanism_) String() string {
	return "ComAmazonawsKmsTypes.KeyEncryptionMechanism"
}
func (_this KeyEncryptionMechanism) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyEncryptionMechanism{}

// End of datatype KeyEncryptionMechanism

// Definition of class KeyIdType
type KeyIdType struct {
}

func New_KeyIdType_() *KeyIdType {
	_this := KeyIdType{}

	return &_this
}

type CompanionStruct_KeyIdType_ struct {
}

var Companion_KeyIdType_ = CompanionStruct_KeyIdType_{}

func (*KeyIdType) String() string {
	return "ComAmazonawsKmsTypes.KeyIdType"
}

// End of class KeyIdType

func Type_KeyIdType_() _dafny.TypeDescriptor {
	return type_KeyIdType_{}
}

type type_KeyIdType_ struct {
}

func (_this type_KeyIdType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_KeyIdType_) String() string {
	return "ComAmazonawsKmsTypes.KeyIdType"
}
func (_this *CompanionStruct_KeyIdType_) Is_(__source _dafny.Sequence) bool {
	var _12_x _dafny.Sequence = (__source)
	_ = _12_x
	return Companion_Default___.IsValid__KeyIdType(_12_x)
}

// Definition of datatype KeyListEntry
type KeyListEntry struct {
	Data_KeyListEntry_
}

func (_this KeyListEntry) Get_() Data_KeyListEntry_ {
	return _this.Data_KeyListEntry_
}

type Data_KeyListEntry_ interface {
	isKeyListEntry()
}

type CompanionStruct_KeyListEntry_ struct {
}

var Companion_KeyListEntry_ = CompanionStruct_KeyListEntry_{}

type KeyListEntry_KeyListEntry struct {
	KeyId  m_Wrappers.Option
	KeyArn m_Wrappers.Option
}

func (KeyListEntry_KeyListEntry) isKeyListEntry() {}

func (CompanionStruct_KeyListEntry_) Create_KeyListEntry_(KeyId m_Wrappers.Option, KeyArn m_Wrappers.Option) KeyListEntry {
	return KeyListEntry{KeyListEntry_KeyListEntry{KeyId, KeyArn}}
}

func (_this KeyListEntry) Is_KeyListEntry() bool {
	_, ok := _this.Get_().(KeyListEntry_KeyListEntry)
	return ok
}

func (CompanionStruct_KeyListEntry_) Default() KeyListEntry {
	return Companion_KeyListEntry_.Create_KeyListEntry_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this KeyListEntry) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(KeyListEntry_KeyListEntry).KeyId
}

func (_this KeyListEntry) Dtor_KeyArn() m_Wrappers.Option {
	return _this.Get_().(KeyListEntry_KeyListEntry).KeyArn
}

func (_this KeyListEntry) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KeyListEntry_KeyListEntry:
		{
			return "ComAmazonawsKmsTypes.KeyListEntry.KeyListEntry" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.KeyArn) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyListEntry) Equals(other KeyListEntry) bool {
	switch data1 := _this.Get_().(type) {
	case KeyListEntry_KeyListEntry:
		{
			data2, ok := other.Get_().(KeyListEntry_KeyListEntry)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.KeyArn.Equals(data2.KeyArn)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyListEntry) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyListEntry)
	return ok && _this.Equals(typed)
}

func Type_KeyListEntry_() _dafny.TypeDescriptor {
	return type_KeyListEntry_{}
}

type type_KeyListEntry_ struct {
}

func (_this type_KeyListEntry_) Default() interface{} {
	return Companion_KeyListEntry_.Default()
}

func (_this type_KeyListEntry_) String() string {
	return "ComAmazonawsKmsTypes.KeyListEntry"
}
func (_this KeyListEntry) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyListEntry{}

// End of datatype KeyListEntry

// Definition of datatype KeyManagerType
type KeyManagerType struct {
	Data_KeyManagerType_
}

func (_this KeyManagerType) Get_() Data_KeyManagerType_ {
	return _this.Data_KeyManagerType_
}

type Data_KeyManagerType_ interface {
	isKeyManagerType()
}

type CompanionStruct_KeyManagerType_ struct {
}

var Companion_KeyManagerType_ = CompanionStruct_KeyManagerType_{}

type KeyManagerType_AWS struct {
}

func (KeyManagerType_AWS) isKeyManagerType() {}

func (CompanionStruct_KeyManagerType_) Create_AWS_() KeyManagerType {
	return KeyManagerType{KeyManagerType_AWS{}}
}

func (_this KeyManagerType) Is_AWS() bool {
	_, ok := _this.Get_().(KeyManagerType_AWS)
	return ok
}

type KeyManagerType_CUSTOMER struct {
}

func (KeyManagerType_CUSTOMER) isKeyManagerType() {}

func (CompanionStruct_KeyManagerType_) Create_CUSTOMER_() KeyManagerType {
	return KeyManagerType{KeyManagerType_CUSTOMER{}}
}

func (_this KeyManagerType) Is_CUSTOMER() bool {
	_, ok := _this.Get_().(KeyManagerType_CUSTOMER)
	return ok
}

func (CompanionStruct_KeyManagerType_) Default() KeyManagerType {
	return Companion_KeyManagerType_.Create_AWS_()
}

func (_ CompanionStruct_KeyManagerType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KeyManagerType_.Create_AWS_(), true
		case 1:
			return Companion_KeyManagerType_.Create_CUSTOMER_(), true
		default:
			return KeyManagerType{}, false
		}
	}
}

func (_this KeyManagerType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KeyManagerType_AWS:
		{
			return "ComAmazonawsKmsTypes.KeyManagerType.AWS"
		}
	case KeyManagerType_CUSTOMER:
		{
			return "ComAmazonawsKmsTypes.KeyManagerType.CUSTOMER"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyManagerType) Equals(other KeyManagerType) bool {
	switch _this.Get_().(type) {
	case KeyManagerType_AWS:
		{
			_, ok := other.Get_().(KeyManagerType_AWS)
			return ok
		}
	case KeyManagerType_CUSTOMER:
		{
			_, ok := other.Get_().(KeyManagerType_CUSTOMER)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyManagerType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyManagerType)
	return ok && _this.Equals(typed)
}

func Type_KeyManagerType_() _dafny.TypeDescriptor {
	return type_KeyManagerType_{}
}

type type_KeyManagerType_ struct {
}

func (_this type_KeyManagerType_) Default() interface{} {
	return Companion_KeyManagerType_.Default()
}

func (_this type_KeyManagerType_) String() string {
	return "ComAmazonawsKmsTypes.KeyManagerType"
}
func (_this KeyManagerType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyManagerType{}

// End of datatype KeyManagerType

// Definition of datatype KeyMetadata
type KeyMetadata struct {
	Data_KeyMetadata_
}

func (_this KeyMetadata) Get_() Data_KeyMetadata_ {
	return _this.Data_KeyMetadata_
}

type Data_KeyMetadata_ interface {
	isKeyMetadata()
}

type CompanionStruct_KeyMetadata_ struct {
}

var Companion_KeyMetadata_ = CompanionStruct_KeyMetadata_{}

type KeyMetadata_KeyMetadata struct {
	AWSAccountId                m_Wrappers.Option
	KeyId                       _dafny.Sequence
	Arn                         m_Wrappers.Option
	CreationDate                m_Wrappers.Option
	Enabled                     m_Wrappers.Option
	Description                 m_Wrappers.Option
	KeyUsage                    m_Wrappers.Option
	KeyState                    m_Wrappers.Option
	DeletionDate                m_Wrappers.Option
	ValidTo                     m_Wrappers.Option
	Origin                      m_Wrappers.Option
	CustomKeyStoreId            m_Wrappers.Option
	CloudHsmClusterId           m_Wrappers.Option
	ExpirationModel             m_Wrappers.Option
	KeyManager                  m_Wrappers.Option
	CustomerMasterKeySpec       m_Wrappers.Option
	KeySpec                     m_Wrappers.Option
	EncryptionAlgorithms        m_Wrappers.Option
	SigningAlgorithms           m_Wrappers.Option
	KeyAgreementAlgorithms      m_Wrappers.Option
	MultiRegion                 m_Wrappers.Option
	MultiRegionConfiguration    m_Wrappers.Option
	PendingDeletionWindowInDays m_Wrappers.Option
	MacAlgorithms               m_Wrappers.Option
	XksKeyConfiguration         m_Wrappers.Option
}

func (KeyMetadata_KeyMetadata) isKeyMetadata() {}

func (CompanionStruct_KeyMetadata_) Create_KeyMetadata_(AWSAccountId m_Wrappers.Option, KeyId _dafny.Sequence, Arn m_Wrappers.Option, CreationDate m_Wrappers.Option, Enabled m_Wrappers.Option, Description m_Wrappers.Option, KeyUsage m_Wrappers.Option, KeyState m_Wrappers.Option, DeletionDate m_Wrappers.Option, ValidTo m_Wrappers.Option, Origin m_Wrappers.Option, CustomKeyStoreId m_Wrappers.Option, CloudHsmClusterId m_Wrappers.Option, ExpirationModel m_Wrappers.Option, KeyManager m_Wrappers.Option, CustomerMasterKeySpec m_Wrappers.Option, KeySpec m_Wrappers.Option, EncryptionAlgorithms m_Wrappers.Option, SigningAlgorithms m_Wrappers.Option, KeyAgreementAlgorithms m_Wrappers.Option, MultiRegion m_Wrappers.Option, MultiRegionConfiguration m_Wrappers.Option, PendingDeletionWindowInDays m_Wrappers.Option, MacAlgorithms m_Wrappers.Option, XksKeyConfiguration m_Wrappers.Option) KeyMetadata {
	return KeyMetadata{KeyMetadata_KeyMetadata{AWSAccountId, KeyId, Arn, CreationDate, Enabled, Description, KeyUsage, KeyState, DeletionDate, ValidTo, Origin, CustomKeyStoreId, CloudHsmClusterId, ExpirationModel, KeyManager, CustomerMasterKeySpec, KeySpec, EncryptionAlgorithms, SigningAlgorithms, KeyAgreementAlgorithms, MultiRegion, MultiRegionConfiguration, PendingDeletionWindowInDays, MacAlgorithms, XksKeyConfiguration}}
}

func (_this KeyMetadata) Is_KeyMetadata() bool {
	_, ok := _this.Get_().(KeyMetadata_KeyMetadata)
	return ok
}

func (CompanionStruct_KeyMetadata_) Default() KeyMetadata {
	return Companion_KeyMetadata_.Create_KeyMetadata_(m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this KeyMetadata) Dtor_AWSAccountId() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).AWSAccountId
}

func (_this KeyMetadata) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(KeyMetadata_KeyMetadata).KeyId
}

func (_this KeyMetadata) Dtor_Arn() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).Arn
}

func (_this KeyMetadata) Dtor_CreationDate() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).CreationDate
}

func (_this KeyMetadata) Dtor_Enabled() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).Enabled
}

func (_this KeyMetadata) Dtor_Description() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).Description
}

func (_this KeyMetadata) Dtor_KeyUsage() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).KeyUsage
}

func (_this KeyMetadata) Dtor_KeyState() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).KeyState
}

func (_this KeyMetadata) Dtor_DeletionDate() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).DeletionDate
}

func (_this KeyMetadata) Dtor_ValidTo() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).ValidTo
}

func (_this KeyMetadata) Dtor_Origin() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).Origin
}

func (_this KeyMetadata) Dtor_CustomKeyStoreId() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).CustomKeyStoreId
}

func (_this KeyMetadata) Dtor_CloudHsmClusterId() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).CloudHsmClusterId
}

func (_this KeyMetadata) Dtor_ExpirationModel() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).ExpirationModel
}

func (_this KeyMetadata) Dtor_KeyManager() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).KeyManager
}

func (_this KeyMetadata) Dtor_CustomerMasterKeySpec() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).CustomerMasterKeySpec
}

func (_this KeyMetadata) Dtor_KeySpec() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).KeySpec
}

func (_this KeyMetadata) Dtor_EncryptionAlgorithms() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).EncryptionAlgorithms
}

func (_this KeyMetadata) Dtor_SigningAlgorithms() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).SigningAlgorithms
}

func (_this KeyMetadata) Dtor_KeyAgreementAlgorithms() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).KeyAgreementAlgorithms
}

func (_this KeyMetadata) Dtor_MultiRegion() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).MultiRegion
}

func (_this KeyMetadata) Dtor_MultiRegionConfiguration() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).MultiRegionConfiguration
}

func (_this KeyMetadata) Dtor_PendingDeletionWindowInDays() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).PendingDeletionWindowInDays
}

func (_this KeyMetadata) Dtor_MacAlgorithms() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).MacAlgorithms
}

func (_this KeyMetadata) Dtor_XksKeyConfiguration() m_Wrappers.Option {
	return _this.Get_().(KeyMetadata_KeyMetadata).XksKeyConfiguration
}

func (_this KeyMetadata) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KeyMetadata_KeyMetadata:
		{
			return "ComAmazonawsKmsTypes.KeyMetadata.KeyMetadata" + "(" + _dafny.String(data.AWSAccountId) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Arn) + ", " + _dafny.String(data.CreationDate) + ", " + _dafny.String(data.Enabled) + ", " + _dafny.String(data.Description) + ", " + _dafny.String(data.KeyUsage) + ", " + _dafny.String(data.KeyState) + ", " + _dafny.String(data.DeletionDate) + ", " + _dafny.String(data.ValidTo) + ", " + _dafny.String(data.Origin) + ", " + _dafny.String(data.CustomKeyStoreId) + ", " + _dafny.String(data.CloudHsmClusterId) + ", " + _dafny.String(data.ExpirationModel) + ", " + _dafny.String(data.KeyManager) + ", " + _dafny.String(data.CustomerMasterKeySpec) + ", " + _dafny.String(data.KeySpec) + ", " + _dafny.String(data.EncryptionAlgorithms) + ", " + _dafny.String(data.SigningAlgorithms) + ", " + _dafny.String(data.KeyAgreementAlgorithms) + ", " + _dafny.String(data.MultiRegion) + ", " + _dafny.String(data.MultiRegionConfiguration) + ", " + _dafny.String(data.PendingDeletionWindowInDays) + ", " + _dafny.String(data.MacAlgorithms) + ", " + _dafny.String(data.XksKeyConfiguration) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyMetadata) Equals(other KeyMetadata) bool {
	switch data1 := _this.Get_().(type) {
	case KeyMetadata_KeyMetadata:
		{
			data2, ok := other.Get_().(KeyMetadata_KeyMetadata)
			return ok && data1.AWSAccountId.Equals(data2.AWSAccountId) && data1.KeyId.Equals(data2.KeyId) && data1.Arn.Equals(data2.Arn) && data1.CreationDate.Equals(data2.CreationDate) && data1.Enabled.Equals(data2.Enabled) && data1.Description.Equals(data2.Description) && data1.KeyUsage.Equals(data2.KeyUsage) && data1.KeyState.Equals(data2.KeyState) && data1.DeletionDate.Equals(data2.DeletionDate) && data1.ValidTo.Equals(data2.ValidTo) && data1.Origin.Equals(data2.Origin) && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId) && data1.CloudHsmClusterId.Equals(data2.CloudHsmClusterId) && data1.ExpirationModel.Equals(data2.ExpirationModel) && data1.KeyManager.Equals(data2.KeyManager) && data1.CustomerMasterKeySpec.Equals(data2.CustomerMasterKeySpec) && data1.KeySpec.Equals(data2.KeySpec) && data1.EncryptionAlgorithms.Equals(data2.EncryptionAlgorithms) && data1.SigningAlgorithms.Equals(data2.SigningAlgorithms) && data1.KeyAgreementAlgorithms.Equals(data2.KeyAgreementAlgorithms) && data1.MultiRegion.Equals(data2.MultiRegion) && data1.MultiRegionConfiguration.Equals(data2.MultiRegionConfiguration) && data1.PendingDeletionWindowInDays.Equals(data2.PendingDeletionWindowInDays) && data1.MacAlgorithms.Equals(data2.MacAlgorithms) && data1.XksKeyConfiguration.Equals(data2.XksKeyConfiguration)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyMetadata) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyMetadata)
	return ok && _this.Equals(typed)
}

func Type_KeyMetadata_() _dafny.TypeDescriptor {
	return type_KeyMetadata_{}
}

type type_KeyMetadata_ struct {
}

func (_this type_KeyMetadata_) Default() interface{} {
	return Companion_KeyMetadata_.Default()
}

func (_this type_KeyMetadata_) String() string {
	return "ComAmazonawsKmsTypes.KeyMetadata"
}
func (_this KeyMetadata) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyMetadata{}

// End of datatype KeyMetadata

// Definition of datatype KeySpec
type KeySpec struct {
	Data_KeySpec_
}

func (_this KeySpec) Get_() Data_KeySpec_ {
	return _this.Data_KeySpec_
}

type Data_KeySpec_ interface {
	isKeySpec()
}

type CompanionStruct_KeySpec_ struct {
}

var Companion_KeySpec_ = CompanionStruct_KeySpec_{}

type KeySpec_RSA__2048 struct {
}

func (KeySpec_RSA__2048) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_RSA__2048_() KeySpec {
	return KeySpec{KeySpec_RSA__2048{}}
}

func (_this KeySpec) Is_RSA__2048() bool {
	_, ok := _this.Get_().(KeySpec_RSA__2048)
	return ok
}

type KeySpec_RSA__3072 struct {
}

func (KeySpec_RSA__3072) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_RSA__3072_() KeySpec {
	return KeySpec{KeySpec_RSA__3072{}}
}

func (_this KeySpec) Is_RSA__3072() bool {
	_, ok := _this.Get_().(KeySpec_RSA__3072)
	return ok
}

type KeySpec_RSA__4096 struct {
}

func (KeySpec_RSA__4096) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_RSA__4096_() KeySpec {
	return KeySpec{KeySpec_RSA__4096{}}
}

func (_this KeySpec) Is_RSA__4096() bool {
	_, ok := _this.Get_().(KeySpec_RSA__4096)
	return ok
}

type KeySpec_ECC__NIST__P256 struct {
}

func (KeySpec_ECC__NIST__P256) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_ECC__NIST__P256_() KeySpec {
	return KeySpec{KeySpec_ECC__NIST__P256{}}
}

func (_this KeySpec) Is_ECC__NIST__P256() bool {
	_, ok := _this.Get_().(KeySpec_ECC__NIST__P256)
	return ok
}

type KeySpec_ECC__NIST__P384 struct {
}

func (KeySpec_ECC__NIST__P384) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_ECC__NIST__P384_() KeySpec {
	return KeySpec{KeySpec_ECC__NIST__P384{}}
}

func (_this KeySpec) Is_ECC__NIST__P384() bool {
	_, ok := _this.Get_().(KeySpec_ECC__NIST__P384)
	return ok
}

type KeySpec_ECC__NIST__P521 struct {
}

func (KeySpec_ECC__NIST__P521) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_ECC__NIST__P521_() KeySpec {
	return KeySpec{KeySpec_ECC__NIST__P521{}}
}

func (_this KeySpec) Is_ECC__NIST__P521() bool {
	_, ok := _this.Get_().(KeySpec_ECC__NIST__P521)
	return ok
}

type KeySpec_ECC__SECG__P256K1 struct {
}

func (KeySpec_ECC__SECG__P256K1) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_ECC__SECG__P256K1_() KeySpec {
	return KeySpec{KeySpec_ECC__SECG__P256K1{}}
}

func (_this KeySpec) Is_ECC__SECG__P256K1() bool {
	_, ok := _this.Get_().(KeySpec_ECC__SECG__P256K1)
	return ok
}

type KeySpec_SYMMETRIC__DEFAULT struct {
}

func (KeySpec_SYMMETRIC__DEFAULT) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_SYMMETRIC__DEFAULT_() KeySpec {
	return KeySpec{KeySpec_SYMMETRIC__DEFAULT{}}
}

func (_this KeySpec) Is_SYMMETRIC__DEFAULT() bool {
	_, ok := _this.Get_().(KeySpec_SYMMETRIC__DEFAULT)
	return ok
}

type KeySpec_HMAC__224 struct {
}

func (KeySpec_HMAC__224) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_HMAC__224_() KeySpec {
	return KeySpec{KeySpec_HMAC__224{}}
}

func (_this KeySpec) Is_HMAC__224() bool {
	_, ok := _this.Get_().(KeySpec_HMAC__224)
	return ok
}

type KeySpec_HMAC__256 struct {
}

func (KeySpec_HMAC__256) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_HMAC__256_() KeySpec {
	return KeySpec{KeySpec_HMAC__256{}}
}

func (_this KeySpec) Is_HMAC__256() bool {
	_, ok := _this.Get_().(KeySpec_HMAC__256)
	return ok
}

type KeySpec_HMAC__384 struct {
}

func (KeySpec_HMAC__384) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_HMAC__384_() KeySpec {
	return KeySpec{KeySpec_HMAC__384{}}
}

func (_this KeySpec) Is_HMAC__384() bool {
	_, ok := _this.Get_().(KeySpec_HMAC__384)
	return ok
}

type KeySpec_HMAC__512 struct {
}

func (KeySpec_HMAC__512) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_HMAC__512_() KeySpec {
	return KeySpec{KeySpec_HMAC__512{}}
}

func (_this KeySpec) Is_HMAC__512() bool {
	_, ok := _this.Get_().(KeySpec_HMAC__512)
	return ok
}

type KeySpec_SM2 struct {
}

func (KeySpec_SM2) isKeySpec() {}

func (CompanionStruct_KeySpec_) Create_SM2_() KeySpec {
	return KeySpec{KeySpec_SM2{}}
}

func (_this KeySpec) Is_SM2() bool {
	_, ok := _this.Get_().(KeySpec_SM2)
	return ok
}

func (CompanionStruct_KeySpec_) Default() KeySpec {
	return Companion_KeySpec_.Create_RSA__2048_()
}

func (_ CompanionStruct_KeySpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KeySpec_.Create_RSA__2048_(), true
		case 1:
			return Companion_KeySpec_.Create_RSA__3072_(), true
		case 2:
			return Companion_KeySpec_.Create_RSA__4096_(), true
		case 3:
			return Companion_KeySpec_.Create_ECC__NIST__P256_(), true
		case 4:
			return Companion_KeySpec_.Create_ECC__NIST__P384_(), true
		case 5:
			return Companion_KeySpec_.Create_ECC__NIST__P521_(), true
		case 6:
			return Companion_KeySpec_.Create_ECC__SECG__P256K1_(), true
		case 7:
			return Companion_KeySpec_.Create_SYMMETRIC__DEFAULT_(), true
		case 8:
			return Companion_KeySpec_.Create_HMAC__224_(), true
		case 9:
			return Companion_KeySpec_.Create_HMAC__256_(), true
		case 10:
			return Companion_KeySpec_.Create_HMAC__384_(), true
		case 11:
			return Companion_KeySpec_.Create_HMAC__512_(), true
		case 12:
			return Companion_KeySpec_.Create_SM2_(), true
		default:
			return KeySpec{}, false
		}
	}
}

func (_this KeySpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KeySpec_RSA__2048:
		{
			return "ComAmazonawsKmsTypes.KeySpec.RSA_2048"
		}
	case KeySpec_RSA__3072:
		{
			return "ComAmazonawsKmsTypes.KeySpec.RSA_3072"
		}
	case KeySpec_RSA__4096:
		{
			return "ComAmazonawsKmsTypes.KeySpec.RSA_4096"
		}
	case KeySpec_ECC__NIST__P256:
		{
			return "ComAmazonawsKmsTypes.KeySpec.ECC_NIST_P256"
		}
	case KeySpec_ECC__NIST__P384:
		{
			return "ComAmazonawsKmsTypes.KeySpec.ECC_NIST_P384"
		}
	case KeySpec_ECC__NIST__P521:
		{
			return "ComAmazonawsKmsTypes.KeySpec.ECC_NIST_P521"
		}
	case KeySpec_ECC__SECG__P256K1:
		{
			return "ComAmazonawsKmsTypes.KeySpec.ECC_SECG_P256K1"
		}
	case KeySpec_SYMMETRIC__DEFAULT:
		{
			return "ComAmazonawsKmsTypes.KeySpec.SYMMETRIC_DEFAULT"
		}
	case KeySpec_HMAC__224:
		{
			return "ComAmazonawsKmsTypes.KeySpec.HMAC_224"
		}
	case KeySpec_HMAC__256:
		{
			return "ComAmazonawsKmsTypes.KeySpec.HMAC_256"
		}
	case KeySpec_HMAC__384:
		{
			return "ComAmazonawsKmsTypes.KeySpec.HMAC_384"
		}
	case KeySpec_HMAC__512:
		{
			return "ComAmazonawsKmsTypes.KeySpec.HMAC_512"
		}
	case KeySpec_SM2:
		{
			return "ComAmazonawsKmsTypes.KeySpec.SM2"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeySpec) Equals(other KeySpec) bool {
	switch _this.Get_().(type) {
	case KeySpec_RSA__2048:
		{
			_, ok := other.Get_().(KeySpec_RSA__2048)
			return ok
		}
	case KeySpec_RSA__3072:
		{
			_, ok := other.Get_().(KeySpec_RSA__3072)
			return ok
		}
	case KeySpec_RSA__4096:
		{
			_, ok := other.Get_().(KeySpec_RSA__4096)
			return ok
		}
	case KeySpec_ECC__NIST__P256:
		{
			_, ok := other.Get_().(KeySpec_ECC__NIST__P256)
			return ok
		}
	case KeySpec_ECC__NIST__P384:
		{
			_, ok := other.Get_().(KeySpec_ECC__NIST__P384)
			return ok
		}
	case KeySpec_ECC__NIST__P521:
		{
			_, ok := other.Get_().(KeySpec_ECC__NIST__P521)
			return ok
		}
	case KeySpec_ECC__SECG__P256K1:
		{
			_, ok := other.Get_().(KeySpec_ECC__SECG__P256K1)
			return ok
		}
	case KeySpec_SYMMETRIC__DEFAULT:
		{
			_, ok := other.Get_().(KeySpec_SYMMETRIC__DEFAULT)
			return ok
		}
	case KeySpec_HMAC__224:
		{
			_, ok := other.Get_().(KeySpec_HMAC__224)
			return ok
		}
	case KeySpec_HMAC__256:
		{
			_, ok := other.Get_().(KeySpec_HMAC__256)
			return ok
		}
	case KeySpec_HMAC__384:
		{
			_, ok := other.Get_().(KeySpec_HMAC__384)
			return ok
		}
	case KeySpec_HMAC__512:
		{
			_, ok := other.Get_().(KeySpec_HMAC__512)
			return ok
		}
	case KeySpec_SM2:
		{
			_, ok := other.Get_().(KeySpec_SM2)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeySpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeySpec)
	return ok && _this.Equals(typed)
}

func Type_KeySpec_() _dafny.TypeDescriptor {
	return type_KeySpec_{}
}

type type_KeySpec_ struct {
}

func (_this type_KeySpec_) Default() interface{} {
	return Companion_KeySpec_.Default()
}

func (_this type_KeySpec_) String() string {
	return "ComAmazonawsKmsTypes.KeySpec"
}
func (_this KeySpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeySpec{}

// End of datatype KeySpec

// Definition of datatype KeyState
type KeyState struct {
	Data_KeyState_
}

func (_this KeyState) Get_() Data_KeyState_ {
	return _this.Data_KeyState_
}

type Data_KeyState_ interface {
	isKeyState()
}

type CompanionStruct_KeyState_ struct {
}

var Companion_KeyState_ = CompanionStruct_KeyState_{}

type KeyState_Creating struct {
}

func (KeyState_Creating) isKeyState() {}

func (CompanionStruct_KeyState_) Create_Creating_() KeyState {
	return KeyState{KeyState_Creating{}}
}

func (_this KeyState) Is_Creating() bool {
	_, ok := _this.Get_().(KeyState_Creating)
	return ok
}

type KeyState_Enabled struct {
}

func (KeyState_Enabled) isKeyState() {}

func (CompanionStruct_KeyState_) Create_Enabled_() KeyState {
	return KeyState{KeyState_Enabled{}}
}

func (_this KeyState) Is_Enabled() bool {
	_, ok := _this.Get_().(KeyState_Enabled)
	return ok
}

type KeyState_Disabled struct {
}

func (KeyState_Disabled) isKeyState() {}

func (CompanionStruct_KeyState_) Create_Disabled_() KeyState {
	return KeyState{KeyState_Disabled{}}
}

func (_this KeyState) Is_Disabled() bool {
	_, ok := _this.Get_().(KeyState_Disabled)
	return ok
}

type KeyState_PendingDeletion struct {
}

func (KeyState_PendingDeletion) isKeyState() {}

func (CompanionStruct_KeyState_) Create_PendingDeletion_() KeyState {
	return KeyState{KeyState_PendingDeletion{}}
}

func (_this KeyState) Is_PendingDeletion() bool {
	_, ok := _this.Get_().(KeyState_PendingDeletion)
	return ok
}

type KeyState_PendingImport struct {
}

func (KeyState_PendingImport) isKeyState() {}

func (CompanionStruct_KeyState_) Create_PendingImport_() KeyState {
	return KeyState{KeyState_PendingImport{}}
}

func (_this KeyState) Is_PendingImport() bool {
	_, ok := _this.Get_().(KeyState_PendingImport)
	return ok
}

type KeyState_PendingReplicaDeletion struct {
}

func (KeyState_PendingReplicaDeletion) isKeyState() {}

func (CompanionStruct_KeyState_) Create_PendingReplicaDeletion_() KeyState {
	return KeyState{KeyState_PendingReplicaDeletion{}}
}

func (_this KeyState) Is_PendingReplicaDeletion() bool {
	_, ok := _this.Get_().(KeyState_PendingReplicaDeletion)
	return ok
}

type KeyState_Unavailable struct {
}

func (KeyState_Unavailable) isKeyState() {}

func (CompanionStruct_KeyState_) Create_Unavailable_() KeyState {
	return KeyState{KeyState_Unavailable{}}
}

func (_this KeyState) Is_Unavailable() bool {
	_, ok := _this.Get_().(KeyState_Unavailable)
	return ok
}

type KeyState_Updating struct {
}

func (KeyState_Updating) isKeyState() {}

func (CompanionStruct_KeyState_) Create_Updating_() KeyState {
	return KeyState{KeyState_Updating{}}
}

func (_this KeyState) Is_Updating() bool {
	_, ok := _this.Get_().(KeyState_Updating)
	return ok
}

func (CompanionStruct_KeyState_) Default() KeyState {
	return Companion_KeyState_.Create_Creating_()
}

func (_ CompanionStruct_KeyState_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KeyState_.Create_Creating_(), true
		case 1:
			return Companion_KeyState_.Create_Enabled_(), true
		case 2:
			return Companion_KeyState_.Create_Disabled_(), true
		case 3:
			return Companion_KeyState_.Create_PendingDeletion_(), true
		case 4:
			return Companion_KeyState_.Create_PendingImport_(), true
		case 5:
			return Companion_KeyState_.Create_PendingReplicaDeletion_(), true
		case 6:
			return Companion_KeyState_.Create_Unavailable_(), true
		case 7:
			return Companion_KeyState_.Create_Updating_(), true
		default:
			return KeyState{}, false
		}
	}
}

func (_this KeyState) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KeyState_Creating:
		{
			return "ComAmazonawsKmsTypes.KeyState.Creating"
		}
	case KeyState_Enabled:
		{
			return "ComAmazonawsKmsTypes.KeyState.Enabled"
		}
	case KeyState_Disabled:
		{
			return "ComAmazonawsKmsTypes.KeyState.Disabled"
		}
	case KeyState_PendingDeletion:
		{
			return "ComAmazonawsKmsTypes.KeyState.PendingDeletion"
		}
	case KeyState_PendingImport:
		{
			return "ComAmazonawsKmsTypes.KeyState.PendingImport"
		}
	case KeyState_PendingReplicaDeletion:
		{
			return "ComAmazonawsKmsTypes.KeyState.PendingReplicaDeletion"
		}
	case KeyState_Unavailable:
		{
			return "ComAmazonawsKmsTypes.KeyState.Unavailable"
		}
	case KeyState_Updating:
		{
			return "ComAmazonawsKmsTypes.KeyState.Updating"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyState) Equals(other KeyState) bool {
	switch _this.Get_().(type) {
	case KeyState_Creating:
		{
			_, ok := other.Get_().(KeyState_Creating)
			return ok
		}
	case KeyState_Enabled:
		{
			_, ok := other.Get_().(KeyState_Enabled)
			return ok
		}
	case KeyState_Disabled:
		{
			_, ok := other.Get_().(KeyState_Disabled)
			return ok
		}
	case KeyState_PendingDeletion:
		{
			_, ok := other.Get_().(KeyState_PendingDeletion)
			return ok
		}
	case KeyState_PendingImport:
		{
			_, ok := other.Get_().(KeyState_PendingImport)
			return ok
		}
	case KeyState_PendingReplicaDeletion:
		{
			_, ok := other.Get_().(KeyState_PendingReplicaDeletion)
			return ok
		}
	case KeyState_Unavailable:
		{
			_, ok := other.Get_().(KeyState_Unavailable)
			return ok
		}
	case KeyState_Updating:
		{
			_, ok := other.Get_().(KeyState_Updating)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyState) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyState)
	return ok && _this.Equals(typed)
}

func Type_KeyState_() _dafny.TypeDescriptor {
	return type_KeyState_{}
}

type type_KeyState_ struct {
}

func (_this type_KeyState_) Default() interface{} {
	return Companion_KeyState_.Default()
}

func (_this type_KeyState_) String() string {
	return "ComAmazonawsKmsTypes.KeyState"
}
func (_this KeyState) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyState{}

// End of datatype KeyState

// Definition of class KeyStorePasswordType
type KeyStorePasswordType struct {
}

func New_KeyStorePasswordType_() *KeyStorePasswordType {
	_this := KeyStorePasswordType{}

	return &_this
}

type CompanionStruct_KeyStorePasswordType_ struct {
}

var Companion_KeyStorePasswordType_ = CompanionStruct_KeyStorePasswordType_{}

func (*KeyStorePasswordType) String() string {
	return "ComAmazonawsKmsTypes.KeyStorePasswordType"
}

// End of class KeyStorePasswordType

func Type_KeyStorePasswordType_() _dafny.TypeDescriptor {
	return type_KeyStorePasswordType_{}
}

type type_KeyStorePasswordType_ struct {
}

func (_this type_KeyStorePasswordType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_KeyStorePasswordType_) String() string {
	return "ComAmazonawsKmsTypes.KeyStorePasswordType"
}
func (_this *CompanionStruct_KeyStorePasswordType_) Is_(__source _dafny.Sequence) bool {
	var _13_x _dafny.Sequence = (__source)
	_ = _13_x
	return Companion_Default___.IsValid__KeyStorePasswordType(_13_x)
}

// Definition of datatype KeyUsageType
type KeyUsageType struct {
	Data_KeyUsageType_
}

func (_this KeyUsageType) Get_() Data_KeyUsageType_ {
	return _this.Data_KeyUsageType_
}

type Data_KeyUsageType_ interface {
	isKeyUsageType()
}

type CompanionStruct_KeyUsageType_ struct {
}

var Companion_KeyUsageType_ = CompanionStruct_KeyUsageType_{}

type KeyUsageType_SIGN__VERIFY struct {
}

func (KeyUsageType_SIGN__VERIFY) isKeyUsageType() {}

func (CompanionStruct_KeyUsageType_) Create_SIGN__VERIFY_() KeyUsageType {
	return KeyUsageType{KeyUsageType_SIGN__VERIFY{}}
}

func (_this KeyUsageType) Is_SIGN__VERIFY() bool {
	_, ok := _this.Get_().(KeyUsageType_SIGN__VERIFY)
	return ok
}

type KeyUsageType_ENCRYPT__DECRYPT struct {
}

func (KeyUsageType_ENCRYPT__DECRYPT) isKeyUsageType() {}

func (CompanionStruct_KeyUsageType_) Create_ENCRYPT__DECRYPT_() KeyUsageType {
	return KeyUsageType{KeyUsageType_ENCRYPT__DECRYPT{}}
}

func (_this KeyUsageType) Is_ENCRYPT__DECRYPT() bool {
	_, ok := _this.Get_().(KeyUsageType_ENCRYPT__DECRYPT)
	return ok
}

type KeyUsageType_GENERATE__VERIFY__MAC struct {
}

func (KeyUsageType_GENERATE__VERIFY__MAC) isKeyUsageType() {}

func (CompanionStruct_KeyUsageType_) Create_GENERATE__VERIFY__MAC_() KeyUsageType {
	return KeyUsageType{KeyUsageType_GENERATE__VERIFY__MAC{}}
}

func (_this KeyUsageType) Is_GENERATE__VERIFY__MAC() bool {
	_, ok := _this.Get_().(KeyUsageType_GENERATE__VERIFY__MAC)
	return ok
}

type KeyUsageType_KEY__AGREEMENT struct {
}

func (KeyUsageType_KEY__AGREEMENT) isKeyUsageType() {}

func (CompanionStruct_KeyUsageType_) Create_KEY__AGREEMENT_() KeyUsageType {
	return KeyUsageType{KeyUsageType_KEY__AGREEMENT{}}
}

func (_this KeyUsageType) Is_KEY__AGREEMENT() bool {
	_, ok := _this.Get_().(KeyUsageType_KEY__AGREEMENT)
	return ok
}

func (CompanionStruct_KeyUsageType_) Default() KeyUsageType {
	return Companion_KeyUsageType_.Create_SIGN__VERIFY_()
}

func (_ CompanionStruct_KeyUsageType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KeyUsageType_.Create_SIGN__VERIFY_(), true
		case 1:
			return Companion_KeyUsageType_.Create_ENCRYPT__DECRYPT_(), true
		case 2:
			return Companion_KeyUsageType_.Create_GENERATE__VERIFY__MAC_(), true
		case 3:
			return Companion_KeyUsageType_.Create_KEY__AGREEMENT_(), true
		default:
			return KeyUsageType{}, false
		}
	}
}

func (_this KeyUsageType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KeyUsageType_SIGN__VERIFY:
		{
			return "ComAmazonawsKmsTypes.KeyUsageType.SIGN_VERIFY"
		}
	case KeyUsageType_ENCRYPT__DECRYPT:
		{
			return "ComAmazonawsKmsTypes.KeyUsageType.ENCRYPT_DECRYPT"
		}
	case KeyUsageType_GENERATE__VERIFY__MAC:
		{
			return "ComAmazonawsKmsTypes.KeyUsageType.GENERATE_VERIFY_MAC"
		}
	case KeyUsageType_KEY__AGREEMENT:
		{
			return "ComAmazonawsKmsTypes.KeyUsageType.KEY_AGREEMENT"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KeyUsageType) Equals(other KeyUsageType) bool {
	switch _this.Get_().(type) {
	case KeyUsageType_SIGN__VERIFY:
		{
			_, ok := other.Get_().(KeyUsageType_SIGN__VERIFY)
			return ok
		}
	case KeyUsageType_ENCRYPT__DECRYPT:
		{
			_, ok := other.Get_().(KeyUsageType_ENCRYPT__DECRYPT)
			return ok
		}
	case KeyUsageType_GENERATE__VERIFY__MAC:
		{
			_, ok := other.Get_().(KeyUsageType_GENERATE__VERIFY__MAC)
			return ok
		}
	case KeyUsageType_KEY__AGREEMENT:
		{
			_, ok := other.Get_().(KeyUsageType_KEY__AGREEMENT)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KeyUsageType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KeyUsageType)
	return ok && _this.Equals(typed)
}

func Type_KeyUsageType_() _dafny.TypeDescriptor {
	return type_KeyUsageType_{}
}

type type_KeyUsageType_ struct {
}

func (_this type_KeyUsageType_) Default() interface{} {
	return Companion_KeyUsageType_.Default()
}

func (_this type_KeyUsageType_) String() string {
	return "ComAmazonawsKmsTypes.KeyUsageType"
}
func (_this KeyUsageType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KeyUsageType{}

// End of datatype KeyUsageType

// Definition of class LimitType
type LimitType struct {
}

func New_LimitType_() *LimitType {
	_this := LimitType{}

	return &_this
}

type CompanionStruct_LimitType_ struct {
}

var Companion_LimitType_ = CompanionStruct_LimitType_{}

func (*LimitType) String() string {
	return "ComAmazonawsKmsTypes.LimitType"
}

// End of class LimitType

func Type_LimitType_() _dafny.TypeDescriptor {
	return type_LimitType_{}
}

type type_LimitType_ struct {
}

func (_this type_LimitType_) Default() interface{} {
	return int32(0)
}

func (_this type_LimitType_) String() string {
	return "ComAmazonawsKmsTypes.LimitType"
}
func (_this *CompanionStruct_LimitType_) Is_(__source int32) bool {
	var _14_x int32 = (__source)
	_ = _14_x
	if true {
		return Companion_Default___.IsValid__LimitType(_14_x)
	}
	return false
}

// Definition of datatype ListAliasesRequest
type ListAliasesRequest struct {
	Data_ListAliasesRequest_
}

func (_this ListAliasesRequest) Get_() Data_ListAliasesRequest_ {
	return _this.Data_ListAliasesRequest_
}

type Data_ListAliasesRequest_ interface {
	isListAliasesRequest()
}

type CompanionStruct_ListAliasesRequest_ struct {
}

var Companion_ListAliasesRequest_ = CompanionStruct_ListAliasesRequest_{}

type ListAliasesRequest_ListAliasesRequest struct {
	KeyId  m_Wrappers.Option
	Limit  m_Wrappers.Option
	Marker m_Wrappers.Option
}

func (ListAliasesRequest_ListAliasesRequest) isListAliasesRequest() {}

func (CompanionStruct_ListAliasesRequest_) Create_ListAliasesRequest_(KeyId m_Wrappers.Option, Limit m_Wrappers.Option, Marker m_Wrappers.Option) ListAliasesRequest {
	return ListAliasesRequest{ListAliasesRequest_ListAliasesRequest{KeyId, Limit, Marker}}
}

func (_this ListAliasesRequest) Is_ListAliasesRequest() bool {
	_, ok := _this.Get_().(ListAliasesRequest_ListAliasesRequest)
	return ok
}

func (CompanionStruct_ListAliasesRequest_) Default() ListAliasesRequest {
	return Companion_ListAliasesRequest_.Create_ListAliasesRequest_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListAliasesRequest) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(ListAliasesRequest_ListAliasesRequest).KeyId
}

func (_this ListAliasesRequest) Dtor_Limit() m_Wrappers.Option {
	return _this.Get_().(ListAliasesRequest_ListAliasesRequest).Limit
}

func (_this ListAliasesRequest) Dtor_Marker() m_Wrappers.Option {
	return _this.Get_().(ListAliasesRequest_ListAliasesRequest).Marker
}

func (_this ListAliasesRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListAliasesRequest_ListAliasesRequest:
		{
			return "ComAmazonawsKmsTypes.ListAliasesRequest.ListAliasesRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Limit) + ", " + _dafny.String(data.Marker) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListAliasesRequest) Equals(other ListAliasesRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ListAliasesRequest_ListAliasesRequest:
		{
			data2, ok := other.Get_().(ListAliasesRequest_ListAliasesRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Limit.Equals(data2.Limit) && data1.Marker.Equals(data2.Marker)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListAliasesRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListAliasesRequest)
	return ok && _this.Equals(typed)
}

func Type_ListAliasesRequest_() _dafny.TypeDescriptor {
	return type_ListAliasesRequest_{}
}

type type_ListAliasesRequest_ struct {
}

func (_this type_ListAliasesRequest_) Default() interface{} {
	return Companion_ListAliasesRequest_.Default()
}

func (_this type_ListAliasesRequest_) String() string {
	return "ComAmazonawsKmsTypes.ListAliasesRequest"
}
func (_this ListAliasesRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListAliasesRequest{}

// End of datatype ListAliasesRequest

// Definition of datatype ListAliasesResponse
type ListAliasesResponse struct {
	Data_ListAliasesResponse_
}

func (_this ListAliasesResponse) Get_() Data_ListAliasesResponse_ {
	return _this.Data_ListAliasesResponse_
}

type Data_ListAliasesResponse_ interface {
	isListAliasesResponse()
}

type CompanionStruct_ListAliasesResponse_ struct {
}

var Companion_ListAliasesResponse_ = CompanionStruct_ListAliasesResponse_{}

type ListAliasesResponse_ListAliasesResponse struct {
	Aliases    m_Wrappers.Option
	NextMarker m_Wrappers.Option
	Truncated  m_Wrappers.Option
}

func (ListAliasesResponse_ListAliasesResponse) isListAliasesResponse() {}

func (CompanionStruct_ListAliasesResponse_) Create_ListAliasesResponse_(Aliases m_Wrappers.Option, NextMarker m_Wrappers.Option, Truncated m_Wrappers.Option) ListAliasesResponse {
	return ListAliasesResponse{ListAliasesResponse_ListAliasesResponse{Aliases, NextMarker, Truncated}}
}

func (_this ListAliasesResponse) Is_ListAliasesResponse() bool {
	_, ok := _this.Get_().(ListAliasesResponse_ListAliasesResponse)
	return ok
}

func (CompanionStruct_ListAliasesResponse_) Default() ListAliasesResponse {
	return Companion_ListAliasesResponse_.Create_ListAliasesResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListAliasesResponse) Dtor_Aliases() m_Wrappers.Option {
	return _this.Get_().(ListAliasesResponse_ListAliasesResponse).Aliases
}

func (_this ListAliasesResponse) Dtor_NextMarker() m_Wrappers.Option {
	return _this.Get_().(ListAliasesResponse_ListAliasesResponse).NextMarker
}

func (_this ListAliasesResponse) Dtor_Truncated() m_Wrappers.Option {
	return _this.Get_().(ListAliasesResponse_ListAliasesResponse).Truncated
}

func (_this ListAliasesResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListAliasesResponse_ListAliasesResponse:
		{
			return "ComAmazonawsKmsTypes.ListAliasesResponse.ListAliasesResponse" + "(" + _dafny.String(data.Aliases) + ", " + _dafny.String(data.NextMarker) + ", " + _dafny.String(data.Truncated) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListAliasesResponse) Equals(other ListAliasesResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ListAliasesResponse_ListAliasesResponse:
		{
			data2, ok := other.Get_().(ListAliasesResponse_ListAliasesResponse)
			return ok && data1.Aliases.Equals(data2.Aliases) && data1.NextMarker.Equals(data2.NextMarker) && data1.Truncated.Equals(data2.Truncated)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListAliasesResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListAliasesResponse)
	return ok && _this.Equals(typed)
}

func Type_ListAliasesResponse_() _dafny.TypeDescriptor {
	return type_ListAliasesResponse_{}
}

type type_ListAliasesResponse_ struct {
}

func (_this type_ListAliasesResponse_) Default() interface{} {
	return Companion_ListAliasesResponse_.Default()
}

func (_this type_ListAliasesResponse_) String() string {
	return "ComAmazonawsKmsTypes.ListAliasesResponse"
}
func (_this ListAliasesResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListAliasesResponse{}

// End of datatype ListAliasesResponse

// Definition of datatype ListGrantsRequest
type ListGrantsRequest struct {
	Data_ListGrantsRequest_
}

func (_this ListGrantsRequest) Get_() Data_ListGrantsRequest_ {
	return _this.Data_ListGrantsRequest_
}

type Data_ListGrantsRequest_ interface {
	isListGrantsRequest()
}

type CompanionStruct_ListGrantsRequest_ struct {
}

var Companion_ListGrantsRequest_ = CompanionStruct_ListGrantsRequest_{}

type ListGrantsRequest_ListGrantsRequest struct {
	Limit            m_Wrappers.Option
	Marker           m_Wrappers.Option
	KeyId            _dafny.Sequence
	GrantId          m_Wrappers.Option
	GranteePrincipal m_Wrappers.Option
}

func (ListGrantsRequest_ListGrantsRequest) isListGrantsRequest() {}

func (CompanionStruct_ListGrantsRequest_) Create_ListGrantsRequest_(Limit m_Wrappers.Option, Marker m_Wrappers.Option, KeyId _dafny.Sequence, GrantId m_Wrappers.Option, GranteePrincipal m_Wrappers.Option) ListGrantsRequest {
	return ListGrantsRequest{ListGrantsRequest_ListGrantsRequest{Limit, Marker, KeyId, GrantId, GranteePrincipal}}
}

func (_this ListGrantsRequest) Is_ListGrantsRequest() bool {
	_, ok := _this.Get_().(ListGrantsRequest_ListGrantsRequest)
	return ok
}

func (CompanionStruct_ListGrantsRequest_) Default() ListGrantsRequest {
	return Companion_ListGrantsRequest_.Create_ListGrantsRequest_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListGrantsRequest) Dtor_Limit() m_Wrappers.Option {
	return _this.Get_().(ListGrantsRequest_ListGrantsRequest).Limit
}

func (_this ListGrantsRequest) Dtor_Marker() m_Wrappers.Option {
	return _this.Get_().(ListGrantsRequest_ListGrantsRequest).Marker
}

func (_this ListGrantsRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(ListGrantsRequest_ListGrantsRequest).KeyId
}

func (_this ListGrantsRequest) Dtor_GrantId() m_Wrappers.Option {
	return _this.Get_().(ListGrantsRequest_ListGrantsRequest).GrantId
}

func (_this ListGrantsRequest) Dtor_GranteePrincipal() m_Wrappers.Option {
	return _this.Get_().(ListGrantsRequest_ListGrantsRequest).GranteePrincipal
}

func (_this ListGrantsRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListGrantsRequest_ListGrantsRequest:
		{
			return "ComAmazonawsKmsTypes.ListGrantsRequest.ListGrantsRequest" + "(" + _dafny.String(data.Limit) + ", " + _dafny.String(data.Marker) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.GrantId) + ", " + _dafny.String(data.GranteePrincipal) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListGrantsRequest) Equals(other ListGrantsRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ListGrantsRequest_ListGrantsRequest:
		{
			data2, ok := other.Get_().(ListGrantsRequest_ListGrantsRequest)
			return ok && data1.Limit.Equals(data2.Limit) && data1.Marker.Equals(data2.Marker) && data1.KeyId.Equals(data2.KeyId) && data1.GrantId.Equals(data2.GrantId) && data1.GranteePrincipal.Equals(data2.GranteePrincipal)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListGrantsRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListGrantsRequest)
	return ok && _this.Equals(typed)
}

func Type_ListGrantsRequest_() _dafny.TypeDescriptor {
	return type_ListGrantsRequest_{}
}

type type_ListGrantsRequest_ struct {
}

func (_this type_ListGrantsRequest_) Default() interface{} {
	return Companion_ListGrantsRequest_.Default()
}

func (_this type_ListGrantsRequest_) String() string {
	return "ComAmazonawsKmsTypes.ListGrantsRequest"
}
func (_this ListGrantsRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListGrantsRequest{}

// End of datatype ListGrantsRequest

// Definition of datatype ListGrantsResponse
type ListGrantsResponse struct {
	Data_ListGrantsResponse_
}

func (_this ListGrantsResponse) Get_() Data_ListGrantsResponse_ {
	return _this.Data_ListGrantsResponse_
}

type Data_ListGrantsResponse_ interface {
	isListGrantsResponse()
}

type CompanionStruct_ListGrantsResponse_ struct {
}

var Companion_ListGrantsResponse_ = CompanionStruct_ListGrantsResponse_{}

type ListGrantsResponse_ListGrantsResponse struct {
	Grants     m_Wrappers.Option
	NextMarker m_Wrappers.Option
	Truncated  m_Wrappers.Option
}

func (ListGrantsResponse_ListGrantsResponse) isListGrantsResponse() {}

func (CompanionStruct_ListGrantsResponse_) Create_ListGrantsResponse_(Grants m_Wrappers.Option, NextMarker m_Wrappers.Option, Truncated m_Wrappers.Option) ListGrantsResponse {
	return ListGrantsResponse{ListGrantsResponse_ListGrantsResponse{Grants, NextMarker, Truncated}}
}

func (_this ListGrantsResponse) Is_ListGrantsResponse() bool {
	_, ok := _this.Get_().(ListGrantsResponse_ListGrantsResponse)
	return ok
}

func (CompanionStruct_ListGrantsResponse_) Default() ListGrantsResponse {
	return Companion_ListGrantsResponse_.Create_ListGrantsResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListGrantsResponse) Dtor_Grants() m_Wrappers.Option {
	return _this.Get_().(ListGrantsResponse_ListGrantsResponse).Grants
}

func (_this ListGrantsResponse) Dtor_NextMarker() m_Wrappers.Option {
	return _this.Get_().(ListGrantsResponse_ListGrantsResponse).NextMarker
}

func (_this ListGrantsResponse) Dtor_Truncated() m_Wrappers.Option {
	return _this.Get_().(ListGrantsResponse_ListGrantsResponse).Truncated
}

func (_this ListGrantsResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListGrantsResponse_ListGrantsResponse:
		{
			return "ComAmazonawsKmsTypes.ListGrantsResponse.ListGrantsResponse" + "(" + _dafny.String(data.Grants) + ", " + _dafny.String(data.NextMarker) + ", " + _dafny.String(data.Truncated) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListGrantsResponse) Equals(other ListGrantsResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ListGrantsResponse_ListGrantsResponse:
		{
			data2, ok := other.Get_().(ListGrantsResponse_ListGrantsResponse)
			return ok && data1.Grants.Equals(data2.Grants) && data1.NextMarker.Equals(data2.NextMarker) && data1.Truncated.Equals(data2.Truncated)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListGrantsResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListGrantsResponse)
	return ok && _this.Equals(typed)
}

func Type_ListGrantsResponse_() _dafny.TypeDescriptor {
	return type_ListGrantsResponse_{}
}

type type_ListGrantsResponse_ struct {
}

func (_this type_ListGrantsResponse_) Default() interface{} {
	return Companion_ListGrantsResponse_.Default()
}

func (_this type_ListGrantsResponse_) String() string {
	return "ComAmazonawsKmsTypes.ListGrantsResponse"
}
func (_this ListGrantsResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListGrantsResponse{}

// End of datatype ListGrantsResponse

// Definition of datatype ListKeyPoliciesRequest
type ListKeyPoliciesRequest struct {
	Data_ListKeyPoliciesRequest_
}

func (_this ListKeyPoliciesRequest) Get_() Data_ListKeyPoliciesRequest_ {
	return _this.Data_ListKeyPoliciesRequest_
}

type Data_ListKeyPoliciesRequest_ interface {
	isListKeyPoliciesRequest()
}

type CompanionStruct_ListKeyPoliciesRequest_ struct {
}

var Companion_ListKeyPoliciesRequest_ = CompanionStruct_ListKeyPoliciesRequest_{}

type ListKeyPoliciesRequest_ListKeyPoliciesRequest struct {
	KeyId  _dafny.Sequence
	Limit  m_Wrappers.Option
	Marker m_Wrappers.Option
}

func (ListKeyPoliciesRequest_ListKeyPoliciesRequest) isListKeyPoliciesRequest() {}

func (CompanionStruct_ListKeyPoliciesRequest_) Create_ListKeyPoliciesRequest_(KeyId _dafny.Sequence, Limit m_Wrappers.Option, Marker m_Wrappers.Option) ListKeyPoliciesRequest {
	return ListKeyPoliciesRequest{ListKeyPoliciesRequest_ListKeyPoliciesRequest{KeyId, Limit, Marker}}
}

func (_this ListKeyPoliciesRequest) Is_ListKeyPoliciesRequest() bool {
	_, ok := _this.Get_().(ListKeyPoliciesRequest_ListKeyPoliciesRequest)
	return ok
}

func (CompanionStruct_ListKeyPoliciesRequest_) Default() ListKeyPoliciesRequest {
	return Companion_ListKeyPoliciesRequest_.Create_ListKeyPoliciesRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListKeyPoliciesRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(ListKeyPoliciesRequest_ListKeyPoliciesRequest).KeyId
}

func (_this ListKeyPoliciesRequest) Dtor_Limit() m_Wrappers.Option {
	return _this.Get_().(ListKeyPoliciesRequest_ListKeyPoliciesRequest).Limit
}

func (_this ListKeyPoliciesRequest) Dtor_Marker() m_Wrappers.Option {
	return _this.Get_().(ListKeyPoliciesRequest_ListKeyPoliciesRequest).Marker
}

func (_this ListKeyPoliciesRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListKeyPoliciesRequest_ListKeyPoliciesRequest:
		{
			return "ComAmazonawsKmsTypes.ListKeyPoliciesRequest.ListKeyPoliciesRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Limit) + ", " + _dafny.String(data.Marker) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListKeyPoliciesRequest) Equals(other ListKeyPoliciesRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ListKeyPoliciesRequest_ListKeyPoliciesRequest:
		{
			data2, ok := other.Get_().(ListKeyPoliciesRequest_ListKeyPoliciesRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Limit.Equals(data2.Limit) && data1.Marker.Equals(data2.Marker)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListKeyPoliciesRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListKeyPoliciesRequest)
	return ok && _this.Equals(typed)
}

func Type_ListKeyPoliciesRequest_() _dafny.TypeDescriptor {
	return type_ListKeyPoliciesRequest_{}
}

type type_ListKeyPoliciesRequest_ struct {
}

func (_this type_ListKeyPoliciesRequest_) Default() interface{} {
	return Companion_ListKeyPoliciesRequest_.Default()
}

func (_this type_ListKeyPoliciesRequest_) String() string {
	return "ComAmazonawsKmsTypes.ListKeyPoliciesRequest"
}
func (_this ListKeyPoliciesRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListKeyPoliciesRequest{}

// End of datatype ListKeyPoliciesRequest

// Definition of datatype ListKeyPoliciesResponse
type ListKeyPoliciesResponse struct {
	Data_ListKeyPoliciesResponse_
}

func (_this ListKeyPoliciesResponse) Get_() Data_ListKeyPoliciesResponse_ {
	return _this.Data_ListKeyPoliciesResponse_
}

type Data_ListKeyPoliciesResponse_ interface {
	isListKeyPoliciesResponse()
}

type CompanionStruct_ListKeyPoliciesResponse_ struct {
}

var Companion_ListKeyPoliciesResponse_ = CompanionStruct_ListKeyPoliciesResponse_{}

type ListKeyPoliciesResponse_ListKeyPoliciesResponse struct {
	PolicyNames m_Wrappers.Option
	NextMarker  m_Wrappers.Option
	Truncated   m_Wrappers.Option
}

func (ListKeyPoliciesResponse_ListKeyPoliciesResponse) isListKeyPoliciesResponse() {}

func (CompanionStruct_ListKeyPoliciesResponse_) Create_ListKeyPoliciesResponse_(PolicyNames m_Wrappers.Option, NextMarker m_Wrappers.Option, Truncated m_Wrappers.Option) ListKeyPoliciesResponse {
	return ListKeyPoliciesResponse{ListKeyPoliciesResponse_ListKeyPoliciesResponse{PolicyNames, NextMarker, Truncated}}
}

func (_this ListKeyPoliciesResponse) Is_ListKeyPoliciesResponse() bool {
	_, ok := _this.Get_().(ListKeyPoliciesResponse_ListKeyPoliciesResponse)
	return ok
}

func (CompanionStruct_ListKeyPoliciesResponse_) Default() ListKeyPoliciesResponse {
	return Companion_ListKeyPoliciesResponse_.Create_ListKeyPoliciesResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListKeyPoliciesResponse) Dtor_PolicyNames() m_Wrappers.Option {
	return _this.Get_().(ListKeyPoliciesResponse_ListKeyPoliciesResponse).PolicyNames
}

func (_this ListKeyPoliciesResponse) Dtor_NextMarker() m_Wrappers.Option {
	return _this.Get_().(ListKeyPoliciesResponse_ListKeyPoliciesResponse).NextMarker
}

func (_this ListKeyPoliciesResponse) Dtor_Truncated() m_Wrappers.Option {
	return _this.Get_().(ListKeyPoliciesResponse_ListKeyPoliciesResponse).Truncated
}

func (_this ListKeyPoliciesResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListKeyPoliciesResponse_ListKeyPoliciesResponse:
		{
			return "ComAmazonawsKmsTypes.ListKeyPoliciesResponse.ListKeyPoliciesResponse" + "(" + _dafny.String(data.PolicyNames) + ", " + _dafny.String(data.NextMarker) + ", " + _dafny.String(data.Truncated) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListKeyPoliciesResponse) Equals(other ListKeyPoliciesResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ListKeyPoliciesResponse_ListKeyPoliciesResponse:
		{
			data2, ok := other.Get_().(ListKeyPoliciesResponse_ListKeyPoliciesResponse)
			return ok && data1.PolicyNames.Equals(data2.PolicyNames) && data1.NextMarker.Equals(data2.NextMarker) && data1.Truncated.Equals(data2.Truncated)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListKeyPoliciesResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListKeyPoliciesResponse)
	return ok && _this.Equals(typed)
}

func Type_ListKeyPoliciesResponse_() _dafny.TypeDescriptor {
	return type_ListKeyPoliciesResponse_{}
}

type type_ListKeyPoliciesResponse_ struct {
}

func (_this type_ListKeyPoliciesResponse_) Default() interface{} {
	return Companion_ListKeyPoliciesResponse_.Default()
}

func (_this type_ListKeyPoliciesResponse_) String() string {
	return "ComAmazonawsKmsTypes.ListKeyPoliciesResponse"
}
func (_this ListKeyPoliciesResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListKeyPoliciesResponse{}

// End of datatype ListKeyPoliciesResponse

// Definition of datatype ListKeyRotationsRequest
type ListKeyRotationsRequest struct {
	Data_ListKeyRotationsRequest_
}

func (_this ListKeyRotationsRequest) Get_() Data_ListKeyRotationsRequest_ {
	return _this.Data_ListKeyRotationsRequest_
}

type Data_ListKeyRotationsRequest_ interface {
	isListKeyRotationsRequest()
}

type CompanionStruct_ListKeyRotationsRequest_ struct {
}

var Companion_ListKeyRotationsRequest_ = CompanionStruct_ListKeyRotationsRequest_{}

type ListKeyRotationsRequest_ListKeyRotationsRequest struct {
	KeyId  _dafny.Sequence
	Limit  m_Wrappers.Option
	Marker m_Wrappers.Option
}

func (ListKeyRotationsRequest_ListKeyRotationsRequest) isListKeyRotationsRequest() {}

func (CompanionStruct_ListKeyRotationsRequest_) Create_ListKeyRotationsRequest_(KeyId _dafny.Sequence, Limit m_Wrappers.Option, Marker m_Wrappers.Option) ListKeyRotationsRequest {
	return ListKeyRotationsRequest{ListKeyRotationsRequest_ListKeyRotationsRequest{KeyId, Limit, Marker}}
}

func (_this ListKeyRotationsRequest) Is_ListKeyRotationsRequest() bool {
	_, ok := _this.Get_().(ListKeyRotationsRequest_ListKeyRotationsRequest)
	return ok
}

func (CompanionStruct_ListKeyRotationsRequest_) Default() ListKeyRotationsRequest {
	return Companion_ListKeyRotationsRequest_.Create_ListKeyRotationsRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListKeyRotationsRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(ListKeyRotationsRequest_ListKeyRotationsRequest).KeyId
}

func (_this ListKeyRotationsRequest) Dtor_Limit() m_Wrappers.Option {
	return _this.Get_().(ListKeyRotationsRequest_ListKeyRotationsRequest).Limit
}

func (_this ListKeyRotationsRequest) Dtor_Marker() m_Wrappers.Option {
	return _this.Get_().(ListKeyRotationsRequest_ListKeyRotationsRequest).Marker
}

func (_this ListKeyRotationsRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListKeyRotationsRequest_ListKeyRotationsRequest:
		{
			return "ComAmazonawsKmsTypes.ListKeyRotationsRequest.ListKeyRotationsRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Limit) + ", " + _dafny.String(data.Marker) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListKeyRotationsRequest) Equals(other ListKeyRotationsRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ListKeyRotationsRequest_ListKeyRotationsRequest:
		{
			data2, ok := other.Get_().(ListKeyRotationsRequest_ListKeyRotationsRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Limit.Equals(data2.Limit) && data1.Marker.Equals(data2.Marker)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListKeyRotationsRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListKeyRotationsRequest)
	return ok && _this.Equals(typed)
}

func Type_ListKeyRotationsRequest_() _dafny.TypeDescriptor {
	return type_ListKeyRotationsRequest_{}
}

type type_ListKeyRotationsRequest_ struct {
}

func (_this type_ListKeyRotationsRequest_) Default() interface{} {
	return Companion_ListKeyRotationsRequest_.Default()
}

func (_this type_ListKeyRotationsRequest_) String() string {
	return "ComAmazonawsKmsTypes.ListKeyRotationsRequest"
}
func (_this ListKeyRotationsRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListKeyRotationsRequest{}

// End of datatype ListKeyRotationsRequest

// Definition of datatype ListKeyRotationsResponse
type ListKeyRotationsResponse struct {
	Data_ListKeyRotationsResponse_
}

func (_this ListKeyRotationsResponse) Get_() Data_ListKeyRotationsResponse_ {
	return _this.Data_ListKeyRotationsResponse_
}

type Data_ListKeyRotationsResponse_ interface {
	isListKeyRotationsResponse()
}

type CompanionStruct_ListKeyRotationsResponse_ struct {
}

var Companion_ListKeyRotationsResponse_ = CompanionStruct_ListKeyRotationsResponse_{}

type ListKeyRotationsResponse_ListKeyRotationsResponse struct {
	Rotations  m_Wrappers.Option
	NextMarker m_Wrappers.Option
	Truncated  m_Wrappers.Option
}

func (ListKeyRotationsResponse_ListKeyRotationsResponse) isListKeyRotationsResponse() {}

func (CompanionStruct_ListKeyRotationsResponse_) Create_ListKeyRotationsResponse_(Rotations m_Wrappers.Option, NextMarker m_Wrappers.Option, Truncated m_Wrappers.Option) ListKeyRotationsResponse {
	return ListKeyRotationsResponse{ListKeyRotationsResponse_ListKeyRotationsResponse{Rotations, NextMarker, Truncated}}
}

func (_this ListKeyRotationsResponse) Is_ListKeyRotationsResponse() bool {
	_, ok := _this.Get_().(ListKeyRotationsResponse_ListKeyRotationsResponse)
	return ok
}

func (CompanionStruct_ListKeyRotationsResponse_) Default() ListKeyRotationsResponse {
	return Companion_ListKeyRotationsResponse_.Create_ListKeyRotationsResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListKeyRotationsResponse) Dtor_Rotations() m_Wrappers.Option {
	return _this.Get_().(ListKeyRotationsResponse_ListKeyRotationsResponse).Rotations
}

func (_this ListKeyRotationsResponse) Dtor_NextMarker() m_Wrappers.Option {
	return _this.Get_().(ListKeyRotationsResponse_ListKeyRotationsResponse).NextMarker
}

func (_this ListKeyRotationsResponse) Dtor_Truncated() m_Wrappers.Option {
	return _this.Get_().(ListKeyRotationsResponse_ListKeyRotationsResponse).Truncated
}

func (_this ListKeyRotationsResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListKeyRotationsResponse_ListKeyRotationsResponse:
		{
			return "ComAmazonawsKmsTypes.ListKeyRotationsResponse.ListKeyRotationsResponse" + "(" + _dafny.String(data.Rotations) + ", " + _dafny.String(data.NextMarker) + ", " + _dafny.String(data.Truncated) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListKeyRotationsResponse) Equals(other ListKeyRotationsResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ListKeyRotationsResponse_ListKeyRotationsResponse:
		{
			data2, ok := other.Get_().(ListKeyRotationsResponse_ListKeyRotationsResponse)
			return ok && data1.Rotations.Equals(data2.Rotations) && data1.NextMarker.Equals(data2.NextMarker) && data1.Truncated.Equals(data2.Truncated)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListKeyRotationsResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListKeyRotationsResponse)
	return ok && _this.Equals(typed)
}

func Type_ListKeyRotationsResponse_() _dafny.TypeDescriptor {
	return type_ListKeyRotationsResponse_{}
}

type type_ListKeyRotationsResponse_ struct {
}

func (_this type_ListKeyRotationsResponse_) Default() interface{} {
	return Companion_ListKeyRotationsResponse_.Default()
}

func (_this type_ListKeyRotationsResponse_) String() string {
	return "ComAmazonawsKmsTypes.ListKeyRotationsResponse"
}
func (_this ListKeyRotationsResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListKeyRotationsResponse{}

// End of datatype ListKeyRotationsResponse

// Definition of datatype ListKeysRequest
type ListKeysRequest struct {
	Data_ListKeysRequest_
}

func (_this ListKeysRequest) Get_() Data_ListKeysRequest_ {
	return _this.Data_ListKeysRequest_
}

type Data_ListKeysRequest_ interface {
	isListKeysRequest()
}

type CompanionStruct_ListKeysRequest_ struct {
}

var Companion_ListKeysRequest_ = CompanionStruct_ListKeysRequest_{}

type ListKeysRequest_ListKeysRequest struct {
	Limit  m_Wrappers.Option
	Marker m_Wrappers.Option
}

func (ListKeysRequest_ListKeysRequest) isListKeysRequest() {}

func (CompanionStruct_ListKeysRequest_) Create_ListKeysRequest_(Limit m_Wrappers.Option, Marker m_Wrappers.Option) ListKeysRequest {
	return ListKeysRequest{ListKeysRequest_ListKeysRequest{Limit, Marker}}
}

func (_this ListKeysRequest) Is_ListKeysRequest() bool {
	_, ok := _this.Get_().(ListKeysRequest_ListKeysRequest)
	return ok
}

func (CompanionStruct_ListKeysRequest_) Default() ListKeysRequest {
	return Companion_ListKeysRequest_.Create_ListKeysRequest_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListKeysRequest) Dtor_Limit() m_Wrappers.Option {
	return _this.Get_().(ListKeysRequest_ListKeysRequest).Limit
}

func (_this ListKeysRequest) Dtor_Marker() m_Wrappers.Option {
	return _this.Get_().(ListKeysRequest_ListKeysRequest).Marker
}

func (_this ListKeysRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListKeysRequest_ListKeysRequest:
		{
			return "ComAmazonawsKmsTypes.ListKeysRequest.ListKeysRequest" + "(" + _dafny.String(data.Limit) + ", " + _dafny.String(data.Marker) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListKeysRequest) Equals(other ListKeysRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ListKeysRequest_ListKeysRequest:
		{
			data2, ok := other.Get_().(ListKeysRequest_ListKeysRequest)
			return ok && data1.Limit.Equals(data2.Limit) && data1.Marker.Equals(data2.Marker)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListKeysRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListKeysRequest)
	return ok && _this.Equals(typed)
}

func Type_ListKeysRequest_() _dafny.TypeDescriptor {
	return type_ListKeysRequest_{}
}

type type_ListKeysRequest_ struct {
}

func (_this type_ListKeysRequest_) Default() interface{} {
	return Companion_ListKeysRequest_.Default()
}

func (_this type_ListKeysRequest_) String() string {
	return "ComAmazonawsKmsTypes.ListKeysRequest"
}
func (_this ListKeysRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListKeysRequest{}

// End of datatype ListKeysRequest

// Definition of datatype ListKeysResponse
type ListKeysResponse struct {
	Data_ListKeysResponse_
}

func (_this ListKeysResponse) Get_() Data_ListKeysResponse_ {
	return _this.Data_ListKeysResponse_
}

type Data_ListKeysResponse_ interface {
	isListKeysResponse()
}

type CompanionStruct_ListKeysResponse_ struct {
}

var Companion_ListKeysResponse_ = CompanionStruct_ListKeysResponse_{}

type ListKeysResponse_ListKeysResponse struct {
	Keys       m_Wrappers.Option
	NextMarker m_Wrappers.Option
	Truncated  m_Wrappers.Option
}

func (ListKeysResponse_ListKeysResponse) isListKeysResponse() {}

func (CompanionStruct_ListKeysResponse_) Create_ListKeysResponse_(Keys m_Wrappers.Option, NextMarker m_Wrappers.Option, Truncated m_Wrappers.Option) ListKeysResponse {
	return ListKeysResponse{ListKeysResponse_ListKeysResponse{Keys, NextMarker, Truncated}}
}

func (_this ListKeysResponse) Is_ListKeysResponse() bool {
	_, ok := _this.Get_().(ListKeysResponse_ListKeysResponse)
	return ok
}

func (CompanionStruct_ListKeysResponse_) Default() ListKeysResponse {
	return Companion_ListKeysResponse_.Create_ListKeysResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListKeysResponse) Dtor_Keys() m_Wrappers.Option {
	return _this.Get_().(ListKeysResponse_ListKeysResponse).Keys
}

func (_this ListKeysResponse) Dtor_NextMarker() m_Wrappers.Option {
	return _this.Get_().(ListKeysResponse_ListKeysResponse).NextMarker
}

func (_this ListKeysResponse) Dtor_Truncated() m_Wrappers.Option {
	return _this.Get_().(ListKeysResponse_ListKeysResponse).Truncated
}

func (_this ListKeysResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListKeysResponse_ListKeysResponse:
		{
			return "ComAmazonawsKmsTypes.ListKeysResponse.ListKeysResponse" + "(" + _dafny.String(data.Keys) + ", " + _dafny.String(data.NextMarker) + ", " + _dafny.String(data.Truncated) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListKeysResponse) Equals(other ListKeysResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ListKeysResponse_ListKeysResponse:
		{
			data2, ok := other.Get_().(ListKeysResponse_ListKeysResponse)
			return ok && data1.Keys.Equals(data2.Keys) && data1.NextMarker.Equals(data2.NextMarker) && data1.Truncated.Equals(data2.Truncated)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListKeysResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListKeysResponse)
	return ok && _this.Equals(typed)
}

func Type_ListKeysResponse_() _dafny.TypeDescriptor {
	return type_ListKeysResponse_{}
}

type type_ListKeysResponse_ struct {
}

func (_this type_ListKeysResponse_) Default() interface{} {
	return Companion_ListKeysResponse_.Default()
}

func (_this type_ListKeysResponse_) String() string {
	return "ComAmazonawsKmsTypes.ListKeysResponse"
}
func (_this ListKeysResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListKeysResponse{}

// End of datatype ListKeysResponse

// Definition of datatype ListResourceTagsRequest
type ListResourceTagsRequest struct {
	Data_ListResourceTagsRequest_
}

func (_this ListResourceTagsRequest) Get_() Data_ListResourceTagsRequest_ {
	return _this.Data_ListResourceTagsRequest_
}

type Data_ListResourceTagsRequest_ interface {
	isListResourceTagsRequest()
}

type CompanionStruct_ListResourceTagsRequest_ struct {
}

var Companion_ListResourceTagsRequest_ = CompanionStruct_ListResourceTagsRequest_{}

type ListResourceTagsRequest_ListResourceTagsRequest struct {
	KeyId  _dafny.Sequence
	Limit  m_Wrappers.Option
	Marker m_Wrappers.Option
}

func (ListResourceTagsRequest_ListResourceTagsRequest) isListResourceTagsRequest() {}

func (CompanionStruct_ListResourceTagsRequest_) Create_ListResourceTagsRequest_(KeyId _dafny.Sequence, Limit m_Wrappers.Option, Marker m_Wrappers.Option) ListResourceTagsRequest {
	return ListResourceTagsRequest{ListResourceTagsRequest_ListResourceTagsRequest{KeyId, Limit, Marker}}
}

func (_this ListResourceTagsRequest) Is_ListResourceTagsRequest() bool {
	_, ok := _this.Get_().(ListResourceTagsRequest_ListResourceTagsRequest)
	return ok
}

func (CompanionStruct_ListResourceTagsRequest_) Default() ListResourceTagsRequest {
	return Companion_ListResourceTagsRequest_.Create_ListResourceTagsRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListResourceTagsRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(ListResourceTagsRequest_ListResourceTagsRequest).KeyId
}

func (_this ListResourceTagsRequest) Dtor_Limit() m_Wrappers.Option {
	return _this.Get_().(ListResourceTagsRequest_ListResourceTagsRequest).Limit
}

func (_this ListResourceTagsRequest) Dtor_Marker() m_Wrappers.Option {
	return _this.Get_().(ListResourceTagsRequest_ListResourceTagsRequest).Marker
}

func (_this ListResourceTagsRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListResourceTagsRequest_ListResourceTagsRequest:
		{
			return "ComAmazonawsKmsTypes.ListResourceTagsRequest.ListResourceTagsRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Limit) + ", " + _dafny.String(data.Marker) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListResourceTagsRequest) Equals(other ListResourceTagsRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ListResourceTagsRequest_ListResourceTagsRequest:
		{
			data2, ok := other.Get_().(ListResourceTagsRequest_ListResourceTagsRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Limit.Equals(data2.Limit) && data1.Marker.Equals(data2.Marker)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListResourceTagsRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListResourceTagsRequest)
	return ok && _this.Equals(typed)
}

func Type_ListResourceTagsRequest_() _dafny.TypeDescriptor {
	return type_ListResourceTagsRequest_{}
}

type type_ListResourceTagsRequest_ struct {
}

func (_this type_ListResourceTagsRequest_) Default() interface{} {
	return Companion_ListResourceTagsRequest_.Default()
}

func (_this type_ListResourceTagsRequest_) String() string {
	return "ComAmazonawsKmsTypes.ListResourceTagsRequest"
}
func (_this ListResourceTagsRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListResourceTagsRequest{}

// End of datatype ListResourceTagsRequest

// Definition of datatype ListResourceTagsResponse
type ListResourceTagsResponse struct {
	Data_ListResourceTagsResponse_
}

func (_this ListResourceTagsResponse) Get_() Data_ListResourceTagsResponse_ {
	return _this.Data_ListResourceTagsResponse_
}

type Data_ListResourceTagsResponse_ interface {
	isListResourceTagsResponse()
}

type CompanionStruct_ListResourceTagsResponse_ struct {
}

var Companion_ListResourceTagsResponse_ = CompanionStruct_ListResourceTagsResponse_{}

type ListResourceTagsResponse_ListResourceTagsResponse struct {
	Tags       m_Wrappers.Option
	NextMarker m_Wrappers.Option
	Truncated  m_Wrappers.Option
}

func (ListResourceTagsResponse_ListResourceTagsResponse) isListResourceTagsResponse() {}

func (CompanionStruct_ListResourceTagsResponse_) Create_ListResourceTagsResponse_(Tags m_Wrappers.Option, NextMarker m_Wrappers.Option, Truncated m_Wrappers.Option) ListResourceTagsResponse {
	return ListResourceTagsResponse{ListResourceTagsResponse_ListResourceTagsResponse{Tags, NextMarker, Truncated}}
}

func (_this ListResourceTagsResponse) Is_ListResourceTagsResponse() bool {
	_, ok := _this.Get_().(ListResourceTagsResponse_ListResourceTagsResponse)
	return ok
}

func (CompanionStruct_ListResourceTagsResponse_) Default() ListResourceTagsResponse {
	return Companion_ListResourceTagsResponse_.Create_ListResourceTagsResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ListResourceTagsResponse) Dtor_Tags() m_Wrappers.Option {
	return _this.Get_().(ListResourceTagsResponse_ListResourceTagsResponse).Tags
}

func (_this ListResourceTagsResponse) Dtor_NextMarker() m_Wrappers.Option {
	return _this.Get_().(ListResourceTagsResponse_ListResourceTagsResponse).NextMarker
}

func (_this ListResourceTagsResponse) Dtor_Truncated() m_Wrappers.Option {
	return _this.Get_().(ListResourceTagsResponse_ListResourceTagsResponse).Truncated
}

func (_this ListResourceTagsResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ListResourceTagsResponse_ListResourceTagsResponse:
		{
			return "ComAmazonawsKmsTypes.ListResourceTagsResponse.ListResourceTagsResponse" + "(" + _dafny.String(data.Tags) + ", " + _dafny.String(data.NextMarker) + ", " + _dafny.String(data.Truncated) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ListResourceTagsResponse) Equals(other ListResourceTagsResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ListResourceTagsResponse_ListResourceTagsResponse:
		{
			data2, ok := other.Get_().(ListResourceTagsResponse_ListResourceTagsResponse)
			return ok && data1.Tags.Equals(data2.Tags) && data1.NextMarker.Equals(data2.NextMarker) && data1.Truncated.Equals(data2.Truncated)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ListResourceTagsResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ListResourceTagsResponse)
	return ok && _this.Equals(typed)
}

func Type_ListResourceTagsResponse_() _dafny.TypeDescriptor {
	return type_ListResourceTagsResponse_{}
}

type type_ListResourceTagsResponse_ struct {
}

func (_this type_ListResourceTagsResponse_) Default() interface{} {
	return Companion_ListResourceTagsResponse_.Default()
}

func (_this type_ListResourceTagsResponse_) String() string {
	return "ComAmazonawsKmsTypes.ListResourceTagsResponse"
}
func (_this ListResourceTagsResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ListResourceTagsResponse{}

// End of datatype ListResourceTagsResponse

// Definition of datatype MacAlgorithmSpec
type MacAlgorithmSpec struct {
	Data_MacAlgorithmSpec_
}

func (_this MacAlgorithmSpec) Get_() Data_MacAlgorithmSpec_ {
	return _this.Data_MacAlgorithmSpec_
}

type Data_MacAlgorithmSpec_ interface {
	isMacAlgorithmSpec()
}

type CompanionStruct_MacAlgorithmSpec_ struct {
}

var Companion_MacAlgorithmSpec_ = CompanionStruct_MacAlgorithmSpec_{}

type MacAlgorithmSpec_HMAC__SHA__224 struct {
}

func (MacAlgorithmSpec_HMAC__SHA__224) isMacAlgorithmSpec() {}

func (CompanionStruct_MacAlgorithmSpec_) Create_HMAC__SHA__224_() MacAlgorithmSpec {
	return MacAlgorithmSpec{MacAlgorithmSpec_HMAC__SHA__224{}}
}

func (_this MacAlgorithmSpec) Is_HMAC__SHA__224() bool {
	_, ok := _this.Get_().(MacAlgorithmSpec_HMAC__SHA__224)
	return ok
}

type MacAlgorithmSpec_HMAC__SHA__256 struct {
}

func (MacAlgorithmSpec_HMAC__SHA__256) isMacAlgorithmSpec() {}

func (CompanionStruct_MacAlgorithmSpec_) Create_HMAC__SHA__256_() MacAlgorithmSpec {
	return MacAlgorithmSpec{MacAlgorithmSpec_HMAC__SHA__256{}}
}

func (_this MacAlgorithmSpec) Is_HMAC__SHA__256() bool {
	_, ok := _this.Get_().(MacAlgorithmSpec_HMAC__SHA__256)
	return ok
}

type MacAlgorithmSpec_HMAC__SHA__384 struct {
}

func (MacAlgorithmSpec_HMAC__SHA__384) isMacAlgorithmSpec() {}

func (CompanionStruct_MacAlgorithmSpec_) Create_HMAC__SHA__384_() MacAlgorithmSpec {
	return MacAlgorithmSpec{MacAlgorithmSpec_HMAC__SHA__384{}}
}

func (_this MacAlgorithmSpec) Is_HMAC__SHA__384() bool {
	_, ok := _this.Get_().(MacAlgorithmSpec_HMAC__SHA__384)
	return ok
}

type MacAlgorithmSpec_HMAC__SHA__512 struct {
}

func (MacAlgorithmSpec_HMAC__SHA__512) isMacAlgorithmSpec() {}

func (CompanionStruct_MacAlgorithmSpec_) Create_HMAC__SHA__512_() MacAlgorithmSpec {
	return MacAlgorithmSpec{MacAlgorithmSpec_HMAC__SHA__512{}}
}

func (_this MacAlgorithmSpec) Is_HMAC__SHA__512() bool {
	_, ok := _this.Get_().(MacAlgorithmSpec_HMAC__SHA__512)
	return ok
}

func (CompanionStruct_MacAlgorithmSpec_) Default() MacAlgorithmSpec {
	return Companion_MacAlgorithmSpec_.Create_HMAC__SHA__224_()
}

func (_ CompanionStruct_MacAlgorithmSpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_MacAlgorithmSpec_.Create_HMAC__SHA__224_(), true
		case 1:
			return Companion_MacAlgorithmSpec_.Create_HMAC__SHA__256_(), true
		case 2:
			return Companion_MacAlgorithmSpec_.Create_HMAC__SHA__384_(), true
		case 3:
			return Companion_MacAlgorithmSpec_.Create_HMAC__SHA__512_(), true
		default:
			return MacAlgorithmSpec{}, false
		}
	}
}

func (_this MacAlgorithmSpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case MacAlgorithmSpec_HMAC__SHA__224:
		{
			return "ComAmazonawsKmsTypes.MacAlgorithmSpec.HMAC_SHA_224"
		}
	case MacAlgorithmSpec_HMAC__SHA__256:
		{
			return "ComAmazonawsKmsTypes.MacAlgorithmSpec.HMAC_SHA_256"
		}
	case MacAlgorithmSpec_HMAC__SHA__384:
		{
			return "ComAmazonawsKmsTypes.MacAlgorithmSpec.HMAC_SHA_384"
		}
	case MacAlgorithmSpec_HMAC__SHA__512:
		{
			return "ComAmazonawsKmsTypes.MacAlgorithmSpec.HMAC_SHA_512"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MacAlgorithmSpec) Equals(other MacAlgorithmSpec) bool {
	switch _this.Get_().(type) {
	case MacAlgorithmSpec_HMAC__SHA__224:
		{
			_, ok := other.Get_().(MacAlgorithmSpec_HMAC__SHA__224)
			return ok
		}
	case MacAlgorithmSpec_HMAC__SHA__256:
		{
			_, ok := other.Get_().(MacAlgorithmSpec_HMAC__SHA__256)
			return ok
		}
	case MacAlgorithmSpec_HMAC__SHA__384:
		{
			_, ok := other.Get_().(MacAlgorithmSpec_HMAC__SHA__384)
			return ok
		}
	case MacAlgorithmSpec_HMAC__SHA__512:
		{
			_, ok := other.Get_().(MacAlgorithmSpec_HMAC__SHA__512)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MacAlgorithmSpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MacAlgorithmSpec)
	return ok && _this.Equals(typed)
}

func Type_MacAlgorithmSpec_() _dafny.TypeDescriptor {
	return type_MacAlgorithmSpec_{}
}

type type_MacAlgorithmSpec_ struct {
}

func (_this type_MacAlgorithmSpec_) Default() interface{} {
	return Companion_MacAlgorithmSpec_.Default()
}

func (_this type_MacAlgorithmSpec_) String() string {
	return "ComAmazonawsKmsTypes.MacAlgorithmSpec"
}
func (_this MacAlgorithmSpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MacAlgorithmSpec{}

// End of datatype MacAlgorithmSpec

// Definition of class MarkerType
type MarkerType struct {
}

func New_MarkerType_() *MarkerType {
	_this := MarkerType{}

	return &_this
}

type CompanionStruct_MarkerType_ struct {
}

var Companion_MarkerType_ = CompanionStruct_MarkerType_{}

func (*MarkerType) String() string {
	return "ComAmazonawsKmsTypes.MarkerType"
}

// End of class MarkerType

func Type_MarkerType_() _dafny.TypeDescriptor {
	return type_MarkerType_{}
}

type type_MarkerType_ struct {
}

func (_this type_MarkerType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_MarkerType_) String() string {
	return "ComAmazonawsKmsTypes.MarkerType"
}
func (_this *CompanionStruct_MarkerType_) Is_(__source _dafny.Sequence) bool {
	var _15_x _dafny.Sequence = (__source)
	_ = _15_x
	return Companion_Default___.IsValid__MarkerType(_15_x)
}

// Definition of datatype MessageType
type MessageType struct {
	Data_MessageType_
}

func (_this MessageType) Get_() Data_MessageType_ {
	return _this.Data_MessageType_
}

type Data_MessageType_ interface {
	isMessageType()
}

type CompanionStruct_MessageType_ struct {
}

var Companion_MessageType_ = CompanionStruct_MessageType_{}

type MessageType_RAW struct {
}

func (MessageType_RAW) isMessageType() {}

func (CompanionStruct_MessageType_) Create_RAW_() MessageType {
	return MessageType{MessageType_RAW{}}
}

func (_this MessageType) Is_RAW() bool {
	_, ok := _this.Get_().(MessageType_RAW)
	return ok
}

type MessageType_DIGEST struct {
}

func (MessageType_DIGEST) isMessageType() {}

func (CompanionStruct_MessageType_) Create_DIGEST_() MessageType {
	return MessageType{MessageType_DIGEST{}}
}

func (_this MessageType) Is_DIGEST() bool {
	_, ok := _this.Get_().(MessageType_DIGEST)
	return ok
}

func (CompanionStruct_MessageType_) Default() MessageType {
	return Companion_MessageType_.Create_RAW_()
}

func (_ CompanionStruct_MessageType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_MessageType_.Create_RAW_(), true
		case 1:
			return Companion_MessageType_.Create_DIGEST_(), true
		default:
			return MessageType{}, false
		}
	}
}

func (_this MessageType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case MessageType_RAW:
		{
			return "ComAmazonawsKmsTypes.MessageType.RAW"
		}
	case MessageType_DIGEST:
		{
			return "ComAmazonawsKmsTypes.MessageType.DIGEST"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MessageType) Equals(other MessageType) bool {
	switch _this.Get_().(type) {
	case MessageType_RAW:
		{
			_, ok := other.Get_().(MessageType_RAW)
			return ok
		}
	case MessageType_DIGEST:
		{
			_, ok := other.Get_().(MessageType_DIGEST)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MessageType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MessageType)
	return ok && _this.Equals(typed)
}

func Type_MessageType_() _dafny.TypeDescriptor {
	return type_MessageType_{}
}

type type_MessageType_ struct {
}

func (_this type_MessageType_) Default() interface{} {
	return Companion_MessageType_.Default()
}

func (_this type_MessageType_) String() string {
	return "ComAmazonawsKmsTypes.MessageType"
}
func (_this MessageType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MessageType{}

// End of datatype MessageType

// Definition of datatype MultiRegionConfiguration
type MultiRegionConfiguration struct {
	Data_MultiRegionConfiguration_
}

func (_this MultiRegionConfiguration) Get_() Data_MultiRegionConfiguration_ {
	return _this.Data_MultiRegionConfiguration_
}

type Data_MultiRegionConfiguration_ interface {
	isMultiRegionConfiguration()
}

type CompanionStruct_MultiRegionConfiguration_ struct {
}

var Companion_MultiRegionConfiguration_ = CompanionStruct_MultiRegionConfiguration_{}

type MultiRegionConfiguration_MultiRegionConfiguration struct {
	MultiRegionKeyType m_Wrappers.Option
	PrimaryKey         m_Wrappers.Option
	ReplicaKeys        m_Wrappers.Option
}

func (MultiRegionConfiguration_MultiRegionConfiguration) isMultiRegionConfiguration() {}

func (CompanionStruct_MultiRegionConfiguration_) Create_MultiRegionConfiguration_(MultiRegionKeyType m_Wrappers.Option, PrimaryKey m_Wrappers.Option, ReplicaKeys m_Wrappers.Option) MultiRegionConfiguration {
	return MultiRegionConfiguration{MultiRegionConfiguration_MultiRegionConfiguration{MultiRegionKeyType, PrimaryKey, ReplicaKeys}}
}

func (_this MultiRegionConfiguration) Is_MultiRegionConfiguration() bool {
	_, ok := _this.Get_().(MultiRegionConfiguration_MultiRegionConfiguration)
	return ok
}

func (CompanionStruct_MultiRegionConfiguration_) Default() MultiRegionConfiguration {
	return Companion_MultiRegionConfiguration_.Create_MultiRegionConfiguration_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this MultiRegionConfiguration) Dtor_MultiRegionKeyType() m_Wrappers.Option {
	return _this.Get_().(MultiRegionConfiguration_MultiRegionConfiguration).MultiRegionKeyType
}

func (_this MultiRegionConfiguration) Dtor_PrimaryKey() m_Wrappers.Option {
	return _this.Get_().(MultiRegionConfiguration_MultiRegionConfiguration).PrimaryKey
}

func (_this MultiRegionConfiguration) Dtor_ReplicaKeys() m_Wrappers.Option {
	return _this.Get_().(MultiRegionConfiguration_MultiRegionConfiguration).ReplicaKeys
}

func (_this MultiRegionConfiguration) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case MultiRegionConfiguration_MultiRegionConfiguration:
		{
			return "ComAmazonawsKmsTypes.MultiRegionConfiguration.MultiRegionConfiguration" + "(" + _dafny.String(data.MultiRegionKeyType) + ", " + _dafny.String(data.PrimaryKey) + ", " + _dafny.String(data.ReplicaKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MultiRegionConfiguration) Equals(other MultiRegionConfiguration) bool {
	switch data1 := _this.Get_().(type) {
	case MultiRegionConfiguration_MultiRegionConfiguration:
		{
			data2, ok := other.Get_().(MultiRegionConfiguration_MultiRegionConfiguration)
			return ok && data1.MultiRegionKeyType.Equals(data2.MultiRegionKeyType) && data1.PrimaryKey.Equals(data2.PrimaryKey) && data1.ReplicaKeys.Equals(data2.ReplicaKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MultiRegionConfiguration) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MultiRegionConfiguration)
	return ok && _this.Equals(typed)
}

func Type_MultiRegionConfiguration_() _dafny.TypeDescriptor {
	return type_MultiRegionConfiguration_{}
}

type type_MultiRegionConfiguration_ struct {
}

func (_this type_MultiRegionConfiguration_) Default() interface{} {
	return Companion_MultiRegionConfiguration_.Default()
}

func (_this type_MultiRegionConfiguration_) String() string {
	return "ComAmazonawsKmsTypes.MultiRegionConfiguration"
}
func (_this MultiRegionConfiguration) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MultiRegionConfiguration{}

// End of datatype MultiRegionConfiguration

// Definition of datatype MultiRegionKey
type MultiRegionKey struct {
	Data_MultiRegionKey_
}

func (_this MultiRegionKey) Get_() Data_MultiRegionKey_ {
	return _this.Data_MultiRegionKey_
}

type Data_MultiRegionKey_ interface {
	isMultiRegionKey()
}

type CompanionStruct_MultiRegionKey_ struct {
}

var Companion_MultiRegionKey_ = CompanionStruct_MultiRegionKey_{}

type MultiRegionKey_MultiRegionKey struct {
	Arn    m_Wrappers.Option
	Region m_Wrappers.Option
}

func (MultiRegionKey_MultiRegionKey) isMultiRegionKey() {}

func (CompanionStruct_MultiRegionKey_) Create_MultiRegionKey_(Arn m_Wrappers.Option, Region m_Wrappers.Option) MultiRegionKey {
	return MultiRegionKey{MultiRegionKey_MultiRegionKey{Arn, Region}}
}

func (_this MultiRegionKey) Is_MultiRegionKey() bool {
	_, ok := _this.Get_().(MultiRegionKey_MultiRegionKey)
	return ok
}

func (CompanionStruct_MultiRegionKey_) Default() MultiRegionKey {
	return Companion_MultiRegionKey_.Create_MultiRegionKey_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this MultiRegionKey) Dtor_Arn() m_Wrappers.Option {
	return _this.Get_().(MultiRegionKey_MultiRegionKey).Arn
}

func (_this MultiRegionKey) Dtor_Region() m_Wrappers.Option {
	return _this.Get_().(MultiRegionKey_MultiRegionKey).Region
}

func (_this MultiRegionKey) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case MultiRegionKey_MultiRegionKey:
		{
			return "ComAmazonawsKmsTypes.MultiRegionKey.MultiRegionKey" + "(" + _dafny.String(data.Arn) + ", " + _dafny.String(data.Region) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MultiRegionKey) Equals(other MultiRegionKey) bool {
	switch data1 := _this.Get_().(type) {
	case MultiRegionKey_MultiRegionKey:
		{
			data2, ok := other.Get_().(MultiRegionKey_MultiRegionKey)
			return ok && data1.Arn.Equals(data2.Arn) && data1.Region.Equals(data2.Region)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MultiRegionKey) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MultiRegionKey)
	return ok && _this.Equals(typed)
}

func Type_MultiRegionKey_() _dafny.TypeDescriptor {
	return type_MultiRegionKey_{}
}

type type_MultiRegionKey_ struct {
}

func (_this type_MultiRegionKey_) Default() interface{} {
	return Companion_MultiRegionKey_.Default()
}

func (_this type_MultiRegionKey_) String() string {
	return "ComAmazonawsKmsTypes.MultiRegionKey"
}
func (_this MultiRegionKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MultiRegionKey{}

// End of datatype MultiRegionKey

// Definition of datatype MultiRegionKeyType
type MultiRegionKeyType struct {
	Data_MultiRegionKeyType_
}

func (_this MultiRegionKeyType) Get_() Data_MultiRegionKeyType_ {
	return _this.Data_MultiRegionKeyType_
}

type Data_MultiRegionKeyType_ interface {
	isMultiRegionKeyType()
}

type CompanionStruct_MultiRegionKeyType_ struct {
}

var Companion_MultiRegionKeyType_ = CompanionStruct_MultiRegionKeyType_{}

type MultiRegionKeyType_PRIMARY struct {
}

func (MultiRegionKeyType_PRIMARY) isMultiRegionKeyType() {}

func (CompanionStruct_MultiRegionKeyType_) Create_PRIMARY_() MultiRegionKeyType {
	return MultiRegionKeyType{MultiRegionKeyType_PRIMARY{}}
}

func (_this MultiRegionKeyType) Is_PRIMARY() bool {
	_, ok := _this.Get_().(MultiRegionKeyType_PRIMARY)
	return ok
}

type MultiRegionKeyType_REPLICA struct {
}

func (MultiRegionKeyType_REPLICA) isMultiRegionKeyType() {}

func (CompanionStruct_MultiRegionKeyType_) Create_REPLICA_() MultiRegionKeyType {
	return MultiRegionKeyType{MultiRegionKeyType_REPLICA{}}
}

func (_this MultiRegionKeyType) Is_REPLICA() bool {
	_, ok := _this.Get_().(MultiRegionKeyType_REPLICA)
	return ok
}

func (CompanionStruct_MultiRegionKeyType_) Default() MultiRegionKeyType {
	return Companion_MultiRegionKeyType_.Create_PRIMARY_()
}

func (_ CompanionStruct_MultiRegionKeyType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_MultiRegionKeyType_.Create_PRIMARY_(), true
		case 1:
			return Companion_MultiRegionKeyType_.Create_REPLICA_(), true
		default:
			return MultiRegionKeyType{}, false
		}
	}
}

func (_this MultiRegionKeyType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case MultiRegionKeyType_PRIMARY:
		{
			return "ComAmazonawsKmsTypes.MultiRegionKeyType.PRIMARY"
		}
	case MultiRegionKeyType_REPLICA:
		{
			return "ComAmazonawsKmsTypes.MultiRegionKeyType.REPLICA"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MultiRegionKeyType) Equals(other MultiRegionKeyType) bool {
	switch _this.Get_().(type) {
	case MultiRegionKeyType_PRIMARY:
		{
			_, ok := other.Get_().(MultiRegionKeyType_PRIMARY)
			return ok
		}
	case MultiRegionKeyType_REPLICA:
		{
			_, ok := other.Get_().(MultiRegionKeyType_REPLICA)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MultiRegionKeyType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MultiRegionKeyType)
	return ok && _this.Equals(typed)
}

func Type_MultiRegionKeyType_() _dafny.TypeDescriptor {
	return type_MultiRegionKeyType_{}
}

type type_MultiRegionKeyType_ struct {
}

func (_this type_MultiRegionKeyType_) Default() interface{} {
	return Companion_MultiRegionKeyType_.Default()
}

func (_this type_MultiRegionKeyType_) String() string {
	return "ComAmazonawsKmsTypes.MultiRegionKeyType"
}
func (_this MultiRegionKeyType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MultiRegionKeyType{}

// End of datatype MultiRegionKeyType

// Definition of class NumberOfBytesType
type NumberOfBytesType struct {
}

func New_NumberOfBytesType_() *NumberOfBytesType {
	_this := NumberOfBytesType{}

	return &_this
}

type CompanionStruct_NumberOfBytesType_ struct {
}

var Companion_NumberOfBytesType_ = CompanionStruct_NumberOfBytesType_{}

func (*NumberOfBytesType) String() string {
	return "ComAmazonawsKmsTypes.NumberOfBytesType"
}

// End of class NumberOfBytesType

func Type_NumberOfBytesType_() _dafny.TypeDescriptor {
	return type_NumberOfBytesType_{}
}

type type_NumberOfBytesType_ struct {
}

func (_this type_NumberOfBytesType_) Default() interface{} {
	return int32(0)
}

func (_this type_NumberOfBytesType_) String() string {
	return "ComAmazonawsKmsTypes.NumberOfBytesType"
}
func (_this *CompanionStruct_NumberOfBytesType_) Is_(__source int32) bool {
	var _16_x int32 = (__source)
	_ = _16_x
	if true {
		return Companion_Default___.IsValid__NumberOfBytesType(_16_x)
	}
	return false
}

// Definition of datatype OriginType
type OriginType struct {
	Data_OriginType_
}

func (_this OriginType) Get_() Data_OriginType_ {
	return _this.Data_OriginType_
}

type Data_OriginType_ interface {
	isOriginType()
}

type CompanionStruct_OriginType_ struct {
}

var Companion_OriginType_ = CompanionStruct_OriginType_{}

type OriginType_AWS__KMS struct {
}

func (OriginType_AWS__KMS) isOriginType() {}

func (CompanionStruct_OriginType_) Create_AWS__KMS_() OriginType {
	return OriginType{OriginType_AWS__KMS{}}
}

func (_this OriginType) Is_AWS__KMS() bool {
	_, ok := _this.Get_().(OriginType_AWS__KMS)
	return ok
}

type OriginType_EXTERNAL struct {
}

func (OriginType_EXTERNAL) isOriginType() {}

func (CompanionStruct_OriginType_) Create_EXTERNAL_() OriginType {
	return OriginType{OriginType_EXTERNAL{}}
}

func (_this OriginType) Is_EXTERNAL() bool {
	_, ok := _this.Get_().(OriginType_EXTERNAL)
	return ok
}

type OriginType_AWS__CLOUDHSM struct {
}

func (OriginType_AWS__CLOUDHSM) isOriginType() {}

func (CompanionStruct_OriginType_) Create_AWS__CLOUDHSM_() OriginType {
	return OriginType{OriginType_AWS__CLOUDHSM{}}
}

func (_this OriginType) Is_AWS__CLOUDHSM() bool {
	_, ok := _this.Get_().(OriginType_AWS__CLOUDHSM)
	return ok
}

type OriginType_EXTERNAL__KEY__STORE struct {
}

func (OriginType_EXTERNAL__KEY__STORE) isOriginType() {}

func (CompanionStruct_OriginType_) Create_EXTERNAL__KEY__STORE_() OriginType {
	return OriginType{OriginType_EXTERNAL__KEY__STORE{}}
}

func (_this OriginType) Is_EXTERNAL__KEY__STORE() bool {
	_, ok := _this.Get_().(OriginType_EXTERNAL__KEY__STORE)
	return ok
}

func (CompanionStruct_OriginType_) Default() OriginType {
	return Companion_OriginType_.Create_AWS__KMS_()
}

func (_ CompanionStruct_OriginType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_OriginType_.Create_AWS__KMS_(), true
		case 1:
			return Companion_OriginType_.Create_EXTERNAL_(), true
		case 2:
			return Companion_OriginType_.Create_AWS__CLOUDHSM_(), true
		case 3:
			return Companion_OriginType_.Create_EXTERNAL__KEY__STORE_(), true
		default:
			return OriginType{}, false
		}
	}
}

func (_this OriginType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case OriginType_AWS__KMS:
		{
			return "ComAmazonawsKmsTypes.OriginType.AWS_KMS"
		}
	case OriginType_EXTERNAL:
		{
			return "ComAmazonawsKmsTypes.OriginType.EXTERNAL"
		}
	case OriginType_AWS__CLOUDHSM:
		{
			return "ComAmazonawsKmsTypes.OriginType.AWS_CLOUDHSM"
		}
	case OriginType_EXTERNAL__KEY__STORE:
		{
			return "ComAmazonawsKmsTypes.OriginType.EXTERNAL_KEY_STORE"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this OriginType) Equals(other OriginType) bool {
	switch _this.Get_().(type) {
	case OriginType_AWS__KMS:
		{
			_, ok := other.Get_().(OriginType_AWS__KMS)
			return ok
		}
	case OriginType_EXTERNAL:
		{
			_, ok := other.Get_().(OriginType_EXTERNAL)
			return ok
		}
	case OriginType_AWS__CLOUDHSM:
		{
			_, ok := other.Get_().(OriginType_AWS__CLOUDHSM)
			return ok
		}
	case OriginType_EXTERNAL__KEY__STORE:
		{
			_, ok := other.Get_().(OriginType_EXTERNAL__KEY__STORE)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this OriginType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(OriginType)
	return ok && _this.Equals(typed)
}

func Type_OriginType_() _dafny.TypeDescriptor {
	return type_OriginType_{}
}

type type_OriginType_ struct {
}

func (_this type_OriginType_) Default() interface{} {
	return Companion_OriginType_.Default()
}

func (_this type_OriginType_) String() string {
	return "ComAmazonawsKmsTypes.OriginType"
}
func (_this OriginType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = OriginType{}

// End of datatype OriginType

// Definition of class PendingWindowInDaysType
type PendingWindowInDaysType struct {
}

func New_PendingWindowInDaysType_() *PendingWindowInDaysType {
	_this := PendingWindowInDaysType{}

	return &_this
}

type CompanionStruct_PendingWindowInDaysType_ struct {
}

var Companion_PendingWindowInDaysType_ = CompanionStruct_PendingWindowInDaysType_{}

func (*PendingWindowInDaysType) String() string {
	return "ComAmazonawsKmsTypes.PendingWindowInDaysType"
}

// End of class PendingWindowInDaysType

func Type_PendingWindowInDaysType_() _dafny.TypeDescriptor {
	return type_PendingWindowInDaysType_{}
}

type type_PendingWindowInDaysType_ struct {
}

func (_this type_PendingWindowInDaysType_) Default() interface{} {
	return int32(0)
}

func (_this type_PendingWindowInDaysType_) String() string {
	return "ComAmazonawsKmsTypes.PendingWindowInDaysType"
}
func (_this *CompanionStruct_PendingWindowInDaysType_) Is_(__source int32) bool {
	var _17_x int32 = (__source)
	_ = _17_x
	if true {
		return Companion_Default___.IsValid__PendingWindowInDaysType(_17_x)
	}
	return false
}

// Definition of class PlaintextType
type PlaintextType struct {
}

func New_PlaintextType_() *PlaintextType {
	_this := PlaintextType{}

	return &_this
}

type CompanionStruct_PlaintextType_ struct {
}

var Companion_PlaintextType_ = CompanionStruct_PlaintextType_{}

func (*PlaintextType) String() string {
	return "ComAmazonawsKmsTypes.PlaintextType"
}

// End of class PlaintextType

func Type_PlaintextType_() _dafny.TypeDescriptor {
	return type_PlaintextType_{}
}

type type_PlaintextType_ struct {
}

func (_this type_PlaintextType_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_PlaintextType_) String() string {
	return "ComAmazonawsKmsTypes.PlaintextType"
}
func (_this *CompanionStruct_PlaintextType_) Is_(__source _dafny.Sequence) bool {
	var _18_x _dafny.Sequence = (__source)
	_ = _18_x
	return Companion_Default___.IsValid__PlaintextType(_18_x)
}

// Definition of class PolicyNameType
type PolicyNameType struct {
}

func New_PolicyNameType_() *PolicyNameType {
	_this := PolicyNameType{}

	return &_this
}

type CompanionStruct_PolicyNameType_ struct {
}

var Companion_PolicyNameType_ = CompanionStruct_PolicyNameType_{}

func (*PolicyNameType) String() string {
	return "ComAmazonawsKmsTypes.PolicyNameType"
}

// End of class PolicyNameType

func Type_PolicyNameType_() _dafny.TypeDescriptor {
	return type_PolicyNameType_{}
}

type type_PolicyNameType_ struct {
}

func (_this type_PolicyNameType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_PolicyNameType_) String() string {
	return "ComAmazonawsKmsTypes.PolicyNameType"
}
func (_this *CompanionStruct_PolicyNameType_) Is_(__source _dafny.Sequence) bool {
	var _19_x _dafny.Sequence = (__source)
	_ = _19_x
	return Companion_Default___.IsValid__PolicyNameType(_19_x)
}

// Definition of class PolicyType
type PolicyType struct {
}

func New_PolicyType_() *PolicyType {
	_this := PolicyType{}

	return &_this
}

type CompanionStruct_PolicyType_ struct {
}

var Companion_PolicyType_ = CompanionStruct_PolicyType_{}

func (*PolicyType) String() string {
	return "ComAmazonawsKmsTypes.PolicyType"
}

// End of class PolicyType

func Type_PolicyType_() _dafny.TypeDescriptor {
	return type_PolicyType_{}
}

type type_PolicyType_ struct {
}

func (_this type_PolicyType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_PolicyType_) String() string {
	return "ComAmazonawsKmsTypes.PolicyType"
}
func (_this *CompanionStruct_PolicyType_) Is_(__source _dafny.Sequence) bool {
	var _20_x _dafny.Sequence = (__source)
	_ = _20_x
	return Companion_Default___.IsValid__PolicyType(_20_x)
}

// Definition of class PrincipalIdType
type PrincipalIdType struct {
}

func New_PrincipalIdType_() *PrincipalIdType {
	_this := PrincipalIdType{}

	return &_this
}

type CompanionStruct_PrincipalIdType_ struct {
}

var Companion_PrincipalIdType_ = CompanionStruct_PrincipalIdType_{}

func (*PrincipalIdType) String() string {
	return "ComAmazonawsKmsTypes.PrincipalIdType"
}

// End of class PrincipalIdType

func Type_PrincipalIdType_() _dafny.TypeDescriptor {
	return type_PrincipalIdType_{}
}

type type_PrincipalIdType_ struct {
}

func (_this type_PrincipalIdType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_PrincipalIdType_) String() string {
	return "ComAmazonawsKmsTypes.PrincipalIdType"
}
func (_this *CompanionStruct_PrincipalIdType_) Is_(__source _dafny.Sequence) bool {
	var _21_x _dafny.Sequence = (__source)
	_ = _21_x
	return Companion_Default___.IsValid__PrincipalIdType(_21_x)
}

// Definition of class PublicKeyType
type PublicKeyType struct {
}

func New_PublicKeyType_() *PublicKeyType {
	_this := PublicKeyType{}

	return &_this
}

type CompanionStruct_PublicKeyType_ struct {
}

var Companion_PublicKeyType_ = CompanionStruct_PublicKeyType_{}

func (*PublicKeyType) String() string {
	return "ComAmazonawsKmsTypes.PublicKeyType"
}

// End of class PublicKeyType

func Type_PublicKeyType_() _dafny.TypeDescriptor {
	return type_PublicKeyType_{}
}

type type_PublicKeyType_ struct {
}

func (_this type_PublicKeyType_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_PublicKeyType_) String() string {
	return "ComAmazonawsKmsTypes.PublicKeyType"
}
func (_this *CompanionStruct_PublicKeyType_) Is_(__source _dafny.Sequence) bool {
	var _22_x _dafny.Sequence = (__source)
	_ = _22_x
	return Companion_Default___.IsValid__PublicKeyType(_22_x)
}

// Definition of datatype PutKeyPolicyRequest
type PutKeyPolicyRequest struct {
	Data_PutKeyPolicyRequest_
}

func (_this PutKeyPolicyRequest) Get_() Data_PutKeyPolicyRequest_ {
	return _this.Data_PutKeyPolicyRequest_
}

type Data_PutKeyPolicyRequest_ interface {
	isPutKeyPolicyRequest()
}

type CompanionStruct_PutKeyPolicyRequest_ struct {
}

var Companion_PutKeyPolicyRequest_ = CompanionStruct_PutKeyPolicyRequest_{}

type PutKeyPolicyRequest_PutKeyPolicyRequest struct {
	KeyId                          _dafny.Sequence
	PolicyName                     m_Wrappers.Option
	Policy                         _dafny.Sequence
	BypassPolicyLockoutSafetyCheck m_Wrappers.Option
}

func (PutKeyPolicyRequest_PutKeyPolicyRequest) isPutKeyPolicyRequest() {}

func (CompanionStruct_PutKeyPolicyRequest_) Create_PutKeyPolicyRequest_(KeyId _dafny.Sequence, PolicyName m_Wrappers.Option, Policy _dafny.Sequence, BypassPolicyLockoutSafetyCheck m_Wrappers.Option) PutKeyPolicyRequest {
	return PutKeyPolicyRequest{PutKeyPolicyRequest_PutKeyPolicyRequest{KeyId, PolicyName, Policy, BypassPolicyLockoutSafetyCheck}}
}

func (_this PutKeyPolicyRequest) Is_PutKeyPolicyRequest() bool {
	_, ok := _this.Get_().(PutKeyPolicyRequest_PutKeyPolicyRequest)
	return ok
}

func (CompanionStruct_PutKeyPolicyRequest_) Default() PutKeyPolicyRequest {
	return Companion_PutKeyPolicyRequest_.Create_PutKeyPolicyRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this PutKeyPolicyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(PutKeyPolicyRequest_PutKeyPolicyRequest).KeyId
}

func (_this PutKeyPolicyRequest) Dtor_PolicyName() m_Wrappers.Option {
	return _this.Get_().(PutKeyPolicyRequest_PutKeyPolicyRequest).PolicyName
}

func (_this PutKeyPolicyRequest) Dtor_Policy() _dafny.Sequence {
	return _this.Get_().(PutKeyPolicyRequest_PutKeyPolicyRequest).Policy
}

func (_this PutKeyPolicyRequest) Dtor_BypassPolicyLockoutSafetyCheck() m_Wrappers.Option {
	return _this.Get_().(PutKeyPolicyRequest_PutKeyPolicyRequest).BypassPolicyLockoutSafetyCheck
}

func (_this PutKeyPolicyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PutKeyPolicyRequest_PutKeyPolicyRequest:
		{
			return "ComAmazonawsKmsTypes.PutKeyPolicyRequest.PutKeyPolicyRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.PolicyName) + ", " + _dafny.String(data.Policy) + ", " + _dafny.String(data.BypassPolicyLockoutSafetyCheck) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PutKeyPolicyRequest) Equals(other PutKeyPolicyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case PutKeyPolicyRequest_PutKeyPolicyRequest:
		{
			data2, ok := other.Get_().(PutKeyPolicyRequest_PutKeyPolicyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.PolicyName.Equals(data2.PolicyName) && data1.Policy.Equals(data2.Policy) && data1.BypassPolicyLockoutSafetyCheck.Equals(data2.BypassPolicyLockoutSafetyCheck)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PutKeyPolicyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PutKeyPolicyRequest)
	return ok && _this.Equals(typed)
}

func Type_PutKeyPolicyRequest_() _dafny.TypeDescriptor {
	return type_PutKeyPolicyRequest_{}
}

type type_PutKeyPolicyRequest_ struct {
}

func (_this type_PutKeyPolicyRequest_) Default() interface{} {
	return Companion_PutKeyPolicyRequest_.Default()
}

func (_this type_PutKeyPolicyRequest_) String() string {
	return "ComAmazonawsKmsTypes.PutKeyPolicyRequest"
}
func (_this PutKeyPolicyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PutKeyPolicyRequest{}

// End of datatype PutKeyPolicyRequest

// Definition of datatype RecipientInfo
type RecipientInfo struct {
	Data_RecipientInfo_
}

func (_this RecipientInfo) Get_() Data_RecipientInfo_ {
	return _this.Data_RecipientInfo_
}

type Data_RecipientInfo_ interface {
	isRecipientInfo()
}

type CompanionStruct_RecipientInfo_ struct {
}

var Companion_RecipientInfo_ = CompanionStruct_RecipientInfo_{}

type RecipientInfo_RecipientInfo struct {
	KeyEncryptionAlgorithm m_Wrappers.Option
	AttestationDocument    m_Wrappers.Option
}

func (RecipientInfo_RecipientInfo) isRecipientInfo() {}

func (CompanionStruct_RecipientInfo_) Create_RecipientInfo_(KeyEncryptionAlgorithm m_Wrappers.Option, AttestationDocument m_Wrappers.Option) RecipientInfo {
	return RecipientInfo{RecipientInfo_RecipientInfo{KeyEncryptionAlgorithm, AttestationDocument}}
}

func (_this RecipientInfo) Is_RecipientInfo() bool {
	_, ok := _this.Get_().(RecipientInfo_RecipientInfo)
	return ok
}

func (CompanionStruct_RecipientInfo_) Default() RecipientInfo {
	return Companion_RecipientInfo_.Create_RecipientInfo_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this RecipientInfo) Dtor_KeyEncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(RecipientInfo_RecipientInfo).KeyEncryptionAlgorithm
}

func (_this RecipientInfo) Dtor_AttestationDocument() m_Wrappers.Option {
	return _this.Get_().(RecipientInfo_RecipientInfo).AttestationDocument
}

func (_this RecipientInfo) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RecipientInfo_RecipientInfo:
		{
			return "ComAmazonawsKmsTypes.RecipientInfo.RecipientInfo" + "(" + _dafny.String(data.KeyEncryptionAlgorithm) + ", " + _dafny.String(data.AttestationDocument) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RecipientInfo) Equals(other RecipientInfo) bool {
	switch data1 := _this.Get_().(type) {
	case RecipientInfo_RecipientInfo:
		{
			data2, ok := other.Get_().(RecipientInfo_RecipientInfo)
			return ok && data1.KeyEncryptionAlgorithm.Equals(data2.KeyEncryptionAlgorithm) && data1.AttestationDocument.Equals(data2.AttestationDocument)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RecipientInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RecipientInfo)
	return ok && _this.Equals(typed)
}

func Type_RecipientInfo_() _dafny.TypeDescriptor {
	return type_RecipientInfo_{}
}

type type_RecipientInfo_ struct {
}

func (_this type_RecipientInfo_) Default() interface{} {
	return Companion_RecipientInfo_.Default()
}

func (_this type_RecipientInfo_) String() string {
	return "ComAmazonawsKmsTypes.RecipientInfo"
}
func (_this RecipientInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RecipientInfo{}

// End of datatype RecipientInfo

// Definition of datatype ReEncryptRequest
type ReEncryptRequest struct {
	Data_ReEncryptRequest_
}

func (_this ReEncryptRequest) Get_() Data_ReEncryptRequest_ {
	return _this.Data_ReEncryptRequest_
}

type Data_ReEncryptRequest_ interface {
	isReEncryptRequest()
}

type CompanionStruct_ReEncryptRequest_ struct {
}

var Companion_ReEncryptRequest_ = CompanionStruct_ReEncryptRequest_{}

type ReEncryptRequest_ReEncryptRequest struct {
	CiphertextBlob                 _dafny.Sequence
	SourceEncryptionContext        m_Wrappers.Option
	SourceKeyId                    m_Wrappers.Option
	DestinationKeyId               _dafny.Sequence
	DestinationEncryptionContext   m_Wrappers.Option
	SourceEncryptionAlgorithm      m_Wrappers.Option
	DestinationEncryptionAlgorithm m_Wrappers.Option
	GrantTokens                    m_Wrappers.Option
	DryRun                         m_Wrappers.Option
}

func (ReEncryptRequest_ReEncryptRequest) isReEncryptRequest() {}

func (CompanionStruct_ReEncryptRequest_) Create_ReEncryptRequest_(CiphertextBlob _dafny.Sequence, SourceEncryptionContext m_Wrappers.Option, SourceKeyId m_Wrappers.Option, DestinationKeyId _dafny.Sequence, DestinationEncryptionContext m_Wrappers.Option, SourceEncryptionAlgorithm m_Wrappers.Option, DestinationEncryptionAlgorithm m_Wrappers.Option, GrantTokens m_Wrappers.Option, DryRun m_Wrappers.Option) ReEncryptRequest {
	return ReEncryptRequest{ReEncryptRequest_ReEncryptRequest{CiphertextBlob, SourceEncryptionContext, SourceKeyId, DestinationKeyId, DestinationEncryptionContext, SourceEncryptionAlgorithm, DestinationEncryptionAlgorithm, GrantTokens, DryRun}}
}

func (_this ReEncryptRequest) Is_ReEncryptRequest() bool {
	_, ok := _this.Get_().(ReEncryptRequest_ReEncryptRequest)
	return ok
}

func (CompanionStruct_ReEncryptRequest_) Default() ReEncryptRequest {
	return Companion_ReEncryptRequest_.Create_ReEncryptRequest_(_dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ReEncryptRequest) Dtor_CiphertextBlob() _dafny.Sequence {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).CiphertextBlob
}

func (_this ReEncryptRequest) Dtor_SourceEncryptionContext() m_Wrappers.Option {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).SourceEncryptionContext
}

func (_this ReEncryptRequest) Dtor_SourceKeyId() m_Wrappers.Option {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).SourceKeyId
}

func (_this ReEncryptRequest) Dtor_DestinationKeyId() _dafny.Sequence {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).DestinationKeyId
}

func (_this ReEncryptRequest) Dtor_DestinationEncryptionContext() m_Wrappers.Option {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).DestinationEncryptionContext
}

func (_this ReEncryptRequest) Dtor_SourceEncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).SourceEncryptionAlgorithm
}

func (_this ReEncryptRequest) Dtor_DestinationEncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).DestinationEncryptionAlgorithm
}

func (_this ReEncryptRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).GrantTokens
}

func (_this ReEncryptRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(ReEncryptRequest_ReEncryptRequest).DryRun
}

func (_this ReEncryptRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ReEncryptRequest_ReEncryptRequest:
		{
			return "ComAmazonawsKmsTypes.ReEncryptRequest.ReEncryptRequest" + "(" + _dafny.String(data.CiphertextBlob) + ", " + _dafny.String(data.SourceEncryptionContext) + ", " + _dafny.String(data.SourceKeyId) + ", " + _dafny.String(data.DestinationKeyId) + ", " + _dafny.String(data.DestinationEncryptionContext) + ", " + _dafny.String(data.SourceEncryptionAlgorithm) + ", " + _dafny.String(data.DestinationEncryptionAlgorithm) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ReEncryptRequest) Equals(other ReEncryptRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ReEncryptRequest_ReEncryptRequest:
		{
			data2, ok := other.Get_().(ReEncryptRequest_ReEncryptRequest)
			return ok && data1.CiphertextBlob.Equals(data2.CiphertextBlob) && data1.SourceEncryptionContext.Equals(data2.SourceEncryptionContext) && data1.SourceKeyId.Equals(data2.SourceKeyId) && data1.DestinationKeyId.Equals(data2.DestinationKeyId) && data1.DestinationEncryptionContext.Equals(data2.DestinationEncryptionContext) && data1.SourceEncryptionAlgorithm.Equals(data2.SourceEncryptionAlgorithm) && data1.DestinationEncryptionAlgorithm.Equals(data2.DestinationEncryptionAlgorithm) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ReEncryptRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ReEncryptRequest)
	return ok && _this.Equals(typed)
}

func Type_ReEncryptRequest_() _dafny.TypeDescriptor {
	return type_ReEncryptRequest_{}
}

type type_ReEncryptRequest_ struct {
}

func (_this type_ReEncryptRequest_) Default() interface{} {
	return Companion_ReEncryptRequest_.Default()
}

func (_this type_ReEncryptRequest_) String() string {
	return "ComAmazonawsKmsTypes.ReEncryptRequest"
}
func (_this ReEncryptRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ReEncryptRequest{}

// End of datatype ReEncryptRequest

// Definition of datatype ReEncryptResponse
type ReEncryptResponse struct {
	Data_ReEncryptResponse_
}

func (_this ReEncryptResponse) Get_() Data_ReEncryptResponse_ {
	return _this.Data_ReEncryptResponse_
}

type Data_ReEncryptResponse_ interface {
	isReEncryptResponse()
}

type CompanionStruct_ReEncryptResponse_ struct {
}

var Companion_ReEncryptResponse_ = CompanionStruct_ReEncryptResponse_{}

type ReEncryptResponse_ReEncryptResponse struct {
	CiphertextBlob                 m_Wrappers.Option
	SourceKeyId                    m_Wrappers.Option
	KeyId                          m_Wrappers.Option
	SourceEncryptionAlgorithm      m_Wrappers.Option
	DestinationEncryptionAlgorithm m_Wrappers.Option
}

func (ReEncryptResponse_ReEncryptResponse) isReEncryptResponse() {}

func (CompanionStruct_ReEncryptResponse_) Create_ReEncryptResponse_(CiphertextBlob m_Wrappers.Option, SourceKeyId m_Wrappers.Option, KeyId m_Wrappers.Option, SourceEncryptionAlgorithm m_Wrappers.Option, DestinationEncryptionAlgorithm m_Wrappers.Option) ReEncryptResponse {
	return ReEncryptResponse{ReEncryptResponse_ReEncryptResponse{CiphertextBlob, SourceKeyId, KeyId, SourceEncryptionAlgorithm, DestinationEncryptionAlgorithm}}
}

func (_this ReEncryptResponse) Is_ReEncryptResponse() bool {
	_, ok := _this.Get_().(ReEncryptResponse_ReEncryptResponse)
	return ok
}

func (CompanionStruct_ReEncryptResponse_) Default() ReEncryptResponse {
	return Companion_ReEncryptResponse_.Create_ReEncryptResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ReEncryptResponse) Dtor_CiphertextBlob() m_Wrappers.Option {
	return _this.Get_().(ReEncryptResponse_ReEncryptResponse).CiphertextBlob
}

func (_this ReEncryptResponse) Dtor_SourceKeyId() m_Wrappers.Option {
	return _this.Get_().(ReEncryptResponse_ReEncryptResponse).SourceKeyId
}

func (_this ReEncryptResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(ReEncryptResponse_ReEncryptResponse).KeyId
}

func (_this ReEncryptResponse) Dtor_SourceEncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(ReEncryptResponse_ReEncryptResponse).SourceEncryptionAlgorithm
}

func (_this ReEncryptResponse) Dtor_DestinationEncryptionAlgorithm() m_Wrappers.Option {
	return _this.Get_().(ReEncryptResponse_ReEncryptResponse).DestinationEncryptionAlgorithm
}

func (_this ReEncryptResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ReEncryptResponse_ReEncryptResponse:
		{
			return "ComAmazonawsKmsTypes.ReEncryptResponse.ReEncryptResponse" + "(" + _dafny.String(data.CiphertextBlob) + ", " + _dafny.String(data.SourceKeyId) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.SourceEncryptionAlgorithm) + ", " + _dafny.String(data.DestinationEncryptionAlgorithm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ReEncryptResponse) Equals(other ReEncryptResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ReEncryptResponse_ReEncryptResponse:
		{
			data2, ok := other.Get_().(ReEncryptResponse_ReEncryptResponse)
			return ok && data1.CiphertextBlob.Equals(data2.CiphertextBlob) && data1.SourceKeyId.Equals(data2.SourceKeyId) && data1.KeyId.Equals(data2.KeyId) && data1.SourceEncryptionAlgorithm.Equals(data2.SourceEncryptionAlgorithm) && data1.DestinationEncryptionAlgorithm.Equals(data2.DestinationEncryptionAlgorithm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ReEncryptResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ReEncryptResponse)
	return ok && _this.Equals(typed)
}

func Type_ReEncryptResponse_() _dafny.TypeDescriptor {
	return type_ReEncryptResponse_{}
}

type type_ReEncryptResponse_ struct {
}

func (_this type_ReEncryptResponse_) Default() interface{} {
	return Companion_ReEncryptResponse_.Default()
}

func (_this type_ReEncryptResponse_) String() string {
	return "ComAmazonawsKmsTypes.ReEncryptResponse"
}
func (_this ReEncryptResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ReEncryptResponse{}

// End of datatype ReEncryptResponse

// Definition of class RegionType
type RegionType struct {
}

func New_RegionType_() *RegionType {
	_this := RegionType{}

	return &_this
}

type CompanionStruct_RegionType_ struct {
}

var Companion_RegionType_ = CompanionStruct_RegionType_{}

func (*RegionType) String() string {
	return "ComAmazonawsKmsTypes.RegionType"
}

// End of class RegionType

func Type_RegionType_() _dafny.TypeDescriptor {
	return type_RegionType_{}
}

type type_RegionType_ struct {
}

func (_this type_RegionType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_RegionType_) String() string {
	return "ComAmazonawsKmsTypes.RegionType"
}
func (_this *CompanionStruct_RegionType_) Is_(__source _dafny.Sequence) bool {
	var _23_x _dafny.Sequence = (__source)
	_ = _23_x
	return Companion_Default___.IsValid__RegionType(_23_x)
}

// Definition of datatype ReplicateKeyRequest
type ReplicateKeyRequest struct {
	Data_ReplicateKeyRequest_
}

func (_this ReplicateKeyRequest) Get_() Data_ReplicateKeyRequest_ {
	return _this.Data_ReplicateKeyRequest_
}

type Data_ReplicateKeyRequest_ interface {
	isReplicateKeyRequest()
}

type CompanionStruct_ReplicateKeyRequest_ struct {
}

var Companion_ReplicateKeyRequest_ = CompanionStruct_ReplicateKeyRequest_{}

type ReplicateKeyRequest_ReplicateKeyRequest struct {
	KeyId                          _dafny.Sequence
	ReplicaRegion                  _dafny.Sequence
	Policy                         m_Wrappers.Option
	BypassPolicyLockoutSafetyCheck m_Wrappers.Option
	Description                    m_Wrappers.Option
	Tags                           m_Wrappers.Option
}

func (ReplicateKeyRequest_ReplicateKeyRequest) isReplicateKeyRequest() {}

func (CompanionStruct_ReplicateKeyRequest_) Create_ReplicateKeyRequest_(KeyId _dafny.Sequence, ReplicaRegion _dafny.Sequence, Policy m_Wrappers.Option, BypassPolicyLockoutSafetyCheck m_Wrappers.Option, Description m_Wrappers.Option, Tags m_Wrappers.Option) ReplicateKeyRequest {
	return ReplicateKeyRequest{ReplicateKeyRequest_ReplicateKeyRequest{KeyId, ReplicaRegion, Policy, BypassPolicyLockoutSafetyCheck, Description, Tags}}
}

func (_this ReplicateKeyRequest) Is_ReplicateKeyRequest() bool {
	_, ok := _this.Get_().(ReplicateKeyRequest_ReplicateKeyRequest)
	return ok
}

func (CompanionStruct_ReplicateKeyRequest_) Default() ReplicateKeyRequest {
	return Companion_ReplicateKeyRequest_.Create_ReplicateKeyRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ReplicateKeyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(ReplicateKeyRequest_ReplicateKeyRequest).KeyId
}

func (_this ReplicateKeyRequest) Dtor_ReplicaRegion() _dafny.Sequence {
	return _this.Get_().(ReplicateKeyRequest_ReplicateKeyRequest).ReplicaRegion
}

func (_this ReplicateKeyRequest) Dtor_Policy() m_Wrappers.Option {
	return _this.Get_().(ReplicateKeyRequest_ReplicateKeyRequest).Policy
}

func (_this ReplicateKeyRequest) Dtor_BypassPolicyLockoutSafetyCheck() m_Wrappers.Option {
	return _this.Get_().(ReplicateKeyRequest_ReplicateKeyRequest).BypassPolicyLockoutSafetyCheck
}

func (_this ReplicateKeyRequest) Dtor_Description() m_Wrappers.Option {
	return _this.Get_().(ReplicateKeyRequest_ReplicateKeyRequest).Description
}

func (_this ReplicateKeyRequest) Dtor_Tags() m_Wrappers.Option {
	return _this.Get_().(ReplicateKeyRequest_ReplicateKeyRequest).Tags
}

func (_this ReplicateKeyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ReplicateKeyRequest_ReplicateKeyRequest:
		{
			return "ComAmazonawsKmsTypes.ReplicateKeyRequest.ReplicateKeyRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.ReplicaRegion) + ", " + _dafny.String(data.Policy) + ", " + _dafny.String(data.BypassPolicyLockoutSafetyCheck) + ", " + _dafny.String(data.Description) + ", " + _dafny.String(data.Tags) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ReplicateKeyRequest) Equals(other ReplicateKeyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ReplicateKeyRequest_ReplicateKeyRequest:
		{
			data2, ok := other.Get_().(ReplicateKeyRequest_ReplicateKeyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.ReplicaRegion.Equals(data2.ReplicaRegion) && data1.Policy.Equals(data2.Policy) && data1.BypassPolicyLockoutSafetyCheck.Equals(data2.BypassPolicyLockoutSafetyCheck) && data1.Description.Equals(data2.Description) && data1.Tags.Equals(data2.Tags)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ReplicateKeyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ReplicateKeyRequest)
	return ok && _this.Equals(typed)
}

func Type_ReplicateKeyRequest_() _dafny.TypeDescriptor {
	return type_ReplicateKeyRequest_{}
}

type type_ReplicateKeyRequest_ struct {
}

func (_this type_ReplicateKeyRequest_) Default() interface{} {
	return Companion_ReplicateKeyRequest_.Default()
}

func (_this type_ReplicateKeyRequest_) String() string {
	return "ComAmazonawsKmsTypes.ReplicateKeyRequest"
}
func (_this ReplicateKeyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ReplicateKeyRequest{}

// End of datatype ReplicateKeyRequest

// Definition of datatype ReplicateKeyResponse
type ReplicateKeyResponse struct {
	Data_ReplicateKeyResponse_
}

func (_this ReplicateKeyResponse) Get_() Data_ReplicateKeyResponse_ {
	return _this.Data_ReplicateKeyResponse_
}

type Data_ReplicateKeyResponse_ interface {
	isReplicateKeyResponse()
}

type CompanionStruct_ReplicateKeyResponse_ struct {
}

var Companion_ReplicateKeyResponse_ = CompanionStruct_ReplicateKeyResponse_{}

type ReplicateKeyResponse_ReplicateKeyResponse struct {
	ReplicaKeyMetadata m_Wrappers.Option
	ReplicaPolicy      m_Wrappers.Option
	ReplicaTags        m_Wrappers.Option
}

func (ReplicateKeyResponse_ReplicateKeyResponse) isReplicateKeyResponse() {}

func (CompanionStruct_ReplicateKeyResponse_) Create_ReplicateKeyResponse_(ReplicaKeyMetadata m_Wrappers.Option, ReplicaPolicy m_Wrappers.Option, ReplicaTags m_Wrappers.Option) ReplicateKeyResponse {
	return ReplicateKeyResponse{ReplicateKeyResponse_ReplicateKeyResponse{ReplicaKeyMetadata, ReplicaPolicy, ReplicaTags}}
}

func (_this ReplicateKeyResponse) Is_ReplicateKeyResponse() bool {
	_, ok := _this.Get_().(ReplicateKeyResponse_ReplicateKeyResponse)
	return ok
}

func (CompanionStruct_ReplicateKeyResponse_) Default() ReplicateKeyResponse {
	return Companion_ReplicateKeyResponse_.Create_ReplicateKeyResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ReplicateKeyResponse) Dtor_ReplicaKeyMetadata() m_Wrappers.Option {
	return _this.Get_().(ReplicateKeyResponse_ReplicateKeyResponse).ReplicaKeyMetadata
}

func (_this ReplicateKeyResponse) Dtor_ReplicaPolicy() m_Wrappers.Option {
	return _this.Get_().(ReplicateKeyResponse_ReplicateKeyResponse).ReplicaPolicy
}

func (_this ReplicateKeyResponse) Dtor_ReplicaTags() m_Wrappers.Option {
	return _this.Get_().(ReplicateKeyResponse_ReplicateKeyResponse).ReplicaTags
}

func (_this ReplicateKeyResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ReplicateKeyResponse_ReplicateKeyResponse:
		{
			return "ComAmazonawsKmsTypes.ReplicateKeyResponse.ReplicateKeyResponse" + "(" + _dafny.String(data.ReplicaKeyMetadata) + ", " + _dafny.String(data.ReplicaPolicy) + ", " + _dafny.String(data.ReplicaTags) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ReplicateKeyResponse) Equals(other ReplicateKeyResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ReplicateKeyResponse_ReplicateKeyResponse:
		{
			data2, ok := other.Get_().(ReplicateKeyResponse_ReplicateKeyResponse)
			return ok && data1.ReplicaKeyMetadata.Equals(data2.ReplicaKeyMetadata) && data1.ReplicaPolicy.Equals(data2.ReplicaPolicy) && data1.ReplicaTags.Equals(data2.ReplicaTags)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ReplicateKeyResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ReplicateKeyResponse)
	return ok && _this.Equals(typed)
}

func Type_ReplicateKeyResponse_() _dafny.TypeDescriptor {
	return type_ReplicateKeyResponse_{}
}

type type_ReplicateKeyResponse_ struct {
}

func (_this type_ReplicateKeyResponse_) Default() interface{} {
	return Companion_ReplicateKeyResponse_.Default()
}

func (_this type_ReplicateKeyResponse_) String() string {
	return "ComAmazonawsKmsTypes.ReplicateKeyResponse"
}
func (_this ReplicateKeyResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ReplicateKeyResponse{}

// End of datatype ReplicateKeyResponse

// Definition of datatype RetireGrantRequest
type RetireGrantRequest struct {
	Data_RetireGrantRequest_
}

func (_this RetireGrantRequest) Get_() Data_RetireGrantRequest_ {
	return _this.Data_RetireGrantRequest_
}

type Data_RetireGrantRequest_ interface {
	isRetireGrantRequest()
}

type CompanionStruct_RetireGrantRequest_ struct {
}

var Companion_RetireGrantRequest_ = CompanionStruct_RetireGrantRequest_{}

type RetireGrantRequest_RetireGrantRequest struct {
	GrantToken m_Wrappers.Option
	KeyId      m_Wrappers.Option
	GrantId    m_Wrappers.Option
	DryRun     m_Wrappers.Option
}

func (RetireGrantRequest_RetireGrantRequest) isRetireGrantRequest() {}

func (CompanionStruct_RetireGrantRequest_) Create_RetireGrantRequest_(GrantToken m_Wrappers.Option, KeyId m_Wrappers.Option, GrantId m_Wrappers.Option, DryRun m_Wrappers.Option) RetireGrantRequest {
	return RetireGrantRequest{RetireGrantRequest_RetireGrantRequest{GrantToken, KeyId, GrantId, DryRun}}
}

func (_this RetireGrantRequest) Is_RetireGrantRequest() bool {
	_, ok := _this.Get_().(RetireGrantRequest_RetireGrantRequest)
	return ok
}

func (CompanionStruct_RetireGrantRequest_) Default() RetireGrantRequest {
	return Companion_RetireGrantRequest_.Create_RetireGrantRequest_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this RetireGrantRequest) Dtor_GrantToken() m_Wrappers.Option {
	return _this.Get_().(RetireGrantRequest_RetireGrantRequest).GrantToken
}

func (_this RetireGrantRequest) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(RetireGrantRequest_RetireGrantRequest).KeyId
}

func (_this RetireGrantRequest) Dtor_GrantId() m_Wrappers.Option {
	return _this.Get_().(RetireGrantRequest_RetireGrantRequest).GrantId
}

func (_this RetireGrantRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(RetireGrantRequest_RetireGrantRequest).DryRun
}

func (_this RetireGrantRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RetireGrantRequest_RetireGrantRequest:
		{
			return "ComAmazonawsKmsTypes.RetireGrantRequest.RetireGrantRequest" + "(" + _dafny.String(data.GrantToken) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.GrantId) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RetireGrantRequest) Equals(other RetireGrantRequest) bool {
	switch data1 := _this.Get_().(type) {
	case RetireGrantRequest_RetireGrantRequest:
		{
			data2, ok := other.Get_().(RetireGrantRequest_RetireGrantRequest)
			return ok && data1.GrantToken.Equals(data2.GrantToken) && data1.KeyId.Equals(data2.KeyId) && data1.GrantId.Equals(data2.GrantId) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RetireGrantRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RetireGrantRequest)
	return ok && _this.Equals(typed)
}

func Type_RetireGrantRequest_() _dafny.TypeDescriptor {
	return type_RetireGrantRequest_{}
}

type type_RetireGrantRequest_ struct {
}

func (_this type_RetireGrantRequest_) Default() interface{} {
	return Companion_RetireGrantRequest_.Default()
}

func (_this type_RetireGrantRequest_) String() string {
	return "ComAmazonawsKmsTypes.RetireGrantRequest"
}
func (_this RetireGrantRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RetireGrantRequest{}

// End of datatype RetireGrantRequest

// Definition of datatype RevokeGrantRequest
type RevokeGrantRequest struct {
	Data_RevokeGrantRequest_
}

func (_this RevokeGrantRequest) Get_() Data_RevokeGrantRequest_ {
	return _this.Data_RevokeGrantRequest_
}

type Data_RevokeGrantRequest_ interface {
	isRevokeGrantRequest()
}

type CompanionStruct_RevokeGrantRequest_ struct {
}

var Companion_RevokeGrantRequest_ = CompanionStruct_RevokeGrantRequest_{}

type RevokeGrantRequest_RevokeGrantRequest struct {
	KeyId   _dafny.Sequence
	GrantId _dafny.Sequence
	DryRun  m_Wrappers.Option
}

func (RevokeGrantRequest_RevokeGrantRequest) isRevokeGrantRequest() {}

func (CompanionStruct_RevokeGrantRequest_) Create_RevokeGrantRequest_(KeyId _dafny.Sequence, GrantId _dafny.Sequence, DryRun m_Wrappers.Option) RevokeGrantRequest {
	return RevokeGrantRequest{RevokeGrantRequest_RevokeGrantRequest{KeyId, GrantId, DryRun}}
}

func (_this RevokeGrantRequest) Is_RevokeGrantRequest() bool {
	_, ok := _this.Get_().(RevokeGrantRequest_RevokeGrantRequest)
	return ok
}

func (CompanionStruct_RevokeGrantRequest_) Default() RevokeGrantRequest {
	return Companion_RevokeGrantRequest_.Create_RevokeGrantRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this RevokeGrantRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(RevokeGrantRequest_RevokeGrantRequest).KeyId
}

func (_this RevokeGrantRequest) Dtor_GrantId() _dafny.Sequence {
	return _this.Get_().(RevokeGrantRequest_RevokeGrantRequest).GrantId
}

func (_this RevokeGrantRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(RevokeGrantRequest_RevokeGrantRequest).DryRun
}

func (_this RevokeGrantRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RevokeGrantRequest_RevokeGrantRequest:
		{
			return "ComAmazonawsKmsTypes.RevokeGrantRequest.RevokeGrantRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.GrantId) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RevokeGrantRequest) Equals(other RevokeGrantRequest) bool {
	switch data1 := _this.Get_().(type) {
	case RevokeGrantRequest_RevokeGrantRequest:
		{
			data2, ok := other.Get_().(RevokeGrantRequest_RevokeGrantRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.GrantId.Equals(data2.GrantId) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RevokeGrantRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RevokeGrantRequest)
	return ok && _this.Equals(typed)
}

func Type_RevokeGrantRequest_() _dafny.TypeDescriptor {
	return type_RevokeGrantRequest_{}
}

type type_RevokeGrantRequest_ struct {
}

func (_this type_RevokeGrantRequest_) Default() interface{} {
	return Companion_RevokeGrantRequest_.Default()
}

func (_this type_RevokeGrantRequest_) String() string {
	return "ComAmazonawsKmsTypes.RevokeGrantRequest"
}
func (_this RevokeGrantRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RevokeGrantRequest{}

// End of datatype RevokeGrantRequest

// Definition of datatype RotateKeyOnDemandRequest
type RotateKeyOnDemandRequest struct {
	Data_RotateKeyOnDemandRequest_
}

func (_this RotateKeyOnDemandRequest) Get_() Data_RotateKeyOnDemandRequest_ {
	return _this.Data_RotateKeyOnDemandRequest_
}

type Data_RotateKeyOnDemandRequest_ interface {
	isRotateKeyOnDemandRequest()
}

type CompanionStruct_RotateKeyOnDemandRequest_ struct {
}

var Companion_RotateKeyOnDemandRequest_ = CompanionStruct_RotateKeyOnDemandRequest_{}

type RotateKeyOnDemandRequest_RotateKeyOnDemandRequest struct {
	KeyId _dafny.Sequence
}

func (RotateKeyOnDemandRequest_RotateKeyOnDemandRequest) isRotateKeyOnDemandRequest() {}

func (CompanionStruct_RotateKeyOnDemandRequest_) Create_RotateKeyOnDemandRequest_(KeyId _dafny.Sequence) RotateKeyOnDemandRequest {
	return RotateKeyOnDemandRequest{RotateKeyOnDemandRequest_RotateKeyOnDemandRequest{KeyId}}
}

func (_this RotateKeyOnDemandRequest) Is_RotateKeyOnDemandRequest() bool {
	_, ok := _this.Get_().(RotateKeyOnDemandRequest_RotateKeyOnDemandRequest)
	return ok
}

func (CompanionStruct_RotateKeyOnDemandRequest_) Default() RotateKeyOnDemandRequest {
	return Companion_RotateKeyOnDemandRequest_.Create_RotateKeyOnDemandRequest_(_dafny.EmptySeq.SetString())
}

func (_this RotateKeyOnDemandRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(RotateKeyOnDemandRequest_RotateKeyOnDemandRequest).KeyId
}

func (_this RotateKeyOnDemandRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RotateKeyOnDemandRequest_RotateKeyOnDemandRequest:
		{
			return "ComAmazonawsKmsTypes.RotateKeyOnDemandRequest.RotateKeyOnDemandRequest" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RotateKeyOnDemandRequest) Equals(other RotateKeyOnDemandRequest) bool {
	switch data1 := _this.Get_().(type) {
	case RotateKeyOnDemandRequest_RotateKeyOnDemandRequest:
		{
			data2, ok := other.Get_().(RotateKeyOnDemandRequest_RotateKeyOnDemandRequest)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RotateKeyOnDemandRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RotateKeyOnDemandRequest)
	return ok && _this.Equals(typed)
}

func Type_RotateKeyOnDemandRequest_() _dafny.TypeDescriptor {
	return type_RotateKeyOnDemandRequest_{}
}

type type_RotateKeyOnDemandRequest_ struct {
}

func (_this type_RotateKeyOnDemandRequest_) Default() interface{} {
	return Companion_RotateKeyOnDemandRequest_.Default()
}

func (_this type_RotateKeyOnDemandRequest_) String() string {
	return "ComAmazonawsKmsTypes.RotateKeyOnDemandRequest"
}
func (_this RotateKeyOnDemandRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RotateKeyOnDemandRequest{}

// End of datatype RotateKeyOnDemandRequest

// Definition of datatype RotateKeyOnDemandResponse
type RotateKeyOnDemandResponse struct {
	Data_RotateKeyOnDemandResponse_
}

func (_this RotateKeyOnDemandResponse) Get_() Data_RotateKeyOnDemandResponse_ {
	return _this.Data_RotateKeyOnDemandResponse_
}

type Data_RotateKeyOnDemandResponse_ interface {
	isRotateKeyOnDemandResponse()
}

type CompanionStruct_RotateKeyOnDemandResponse_ struct {
}

var Companion_RotateKeyOnDemandResponse_ = CompanionStruct_RotateKeyOnDemandResponse_{}

type RotateKeyOnDemandResponse_RotateKeyOnDemandResponse struct {
	KeyId m_Wrappers.Option
}

func (RotateKeyOnDemandResponse_RotateKeyOnDemandResponse) isRotateKeyOnDemandResponse() {}

func (CompanionStruct_RotateKeyOnDemandResponse_) Create_RotateKeyOnDemandResponse_(KeyId m_Wrappers.Option) RotateKeyOnDemandResponse {
	return RotateKeyOnDemandResponse{RotateKeyOnDemandResponse_RotateKeyOnDemandResponse{KeyId}}
}

func (_this RotateKeyOnDemandResponse) Is_RotateKeyOnDemandResponse() bool {
	_, ok := _this.Get_().(RotateKeyOnDemandResponse_RotateKeyOnDemandResponse)
	return ok
}

func (CompanionStruct_RotateKeyOnDemandResponse_) Default() RotateKeyOnDemandResponse {
	return Companion_RotateKeyOnDemandResponse_.Create_RotateKeyOnDemandResponse_(m_Wrappers.Companion_Option_.Default())
}

func (_this RotateKeyOnDemandResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(RotateKeyOnDemandResponse_RotateKeyOnDemandResponse).KeyId
}

func (_this RotateKeyOnDemandResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RotateKeyOnDemandResponse_RotateKeyOnDemandResponse:
		{
			return "ComAmazonawsKmsTypes.RotateKeyOnDemandResponse.RotateKeyOnDemandResponse" + "(" + _dafny.String(data.KeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RotateKeyOnDemandResponse) Equals(other RotateKeyOnDemandResponse) bool {
	switch data1 := _this.Get_().(type) {
	case RotateKeyOnDemandResponse_RotateKeyOnDemandResponse:
		{
			data2, ok := other.Get_().(RotateKeyOnDemandResponse_RotateKeyOnDemandResponse)
			return ok && data1.KeyId.Equals(data2.KeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RotateKeyOnDemandResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RotateKeyOnDemandResponse)
	return ok && _this.Equals(typed)
}

func Type_RotateKeyOnDemandResponse_() _dafny.TypeDescriptor {
	return type_RotateKeyOnDemandResponse_{}
}

type type_RotateKeyOnDemandResponse_ struct {
}

func (_this type_RotateKeyOnDemandResponse_) Default() interface{} {
	return Companion_RotateKeyOnDemandResponse_.Default()
}

func (_this type_RotateKeyOnDemandResponse_) String() string {
	return "ComAmazonawsKmsTypes.RotateKeyOnDemandResponse"
}
func (_this RotateKeyOnDemandResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RotateKeyOnDemandResponse{}

// End of datatype RotateKeyOnDemandResponse

// Definition of class RotationPeriodInDaysType
type RotationPeriodInDaysType struct {
}

func New_RotationPeriodInDaysType_() *RotationPeriodInDaysType {
	_this := RotationPeriodInDaysType{}

	return &_this
}

type CompanionStruct_RotationPeriodInDaysType_ struct {
}

var Companion_RotationPeriodInDaysType_ = CompanionStruct_RotationPeriodInDaysType_{}

func (*RotationPeriodInDaysType) String() string {
	return "ComAmazonawsKmsTypes.RotationPeriodInDaysType"
}

// End of class RotationPeriodInDaysType

func Type_RotationPeriodInDaysType_() _dafny.TypeDescriptor {
	return type_RotationPeriodInDaysType_{}
}

type type_RotationPeriodInDaysType_ struct {
}

func (_this type_RotationPeriodInDaysType_) Default() interface{} {
	return int32(0)
}

func (_this type_RotationPeriodInDaysType_) String() string {
	return "ComAmazonawsKmsTypes.RotationPeriodInDaysType"
}
func (_this *CompanionStruct_RotationPeriodInDaysType_) Is_(__source int32) bool {
	var _24_x int32 = (__source)
	_ = _24_x
	if true {
		return Companion_Default___.IsValid__RotationPeriodInDaysType(_24_x)
	}
	return false
}

// Definition of datatype RotationsListEntry
type RotationsListEntry struct {
	Data_RotationsListEntry_
}

func (_this RotationsListEntry) Get_() Data_RotationsListEntry_ {
	return _this.Data_RotationsListEntry_
}

type Data_RotationsListEntry_ interface {
	isRotationsListEntry()
}

type CompanionStruct_RotationsListEntry_ struct {
}

var Companion_RotationsListEntry_ = CompanionStruct_RotationsListEntry_{}

type RotationsListEntry_RotationsListEntry struct {
	KeyId        m_Wrappers.Option
	RotationDate m_Wrappers.Option
	RotationType m_Wrappers.Option
}

func (RotationsListEntry_RotationsListEntry) isRotationsListEntry() {}

func (CompanionStruct_RotationsListEntry_) Create_RotationsListEntry_(KeyId m_Wrappers.Option, RotationDate m_Wrappers.Option, RotationType m_Wrappers.Option) RotationsListEntry {
	return RotationsListEntry{RotationsListEntry_RotationsListEntry{KeyId, RotationDate, RotationType}}
}

func (_this RotationsListEntry) Is_RotationsListEntry() bool {
	_, ok := _this.Get_().(RotationsListEntry_RotationsListEntry)
	return ok
}

func (CompanionStruct_RotationsListEntry_) Default() RotationsListEntry {
	return Companion_RotationsListEntry_.Create_RotationsListEntry_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this RotationsListEntry) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(RotationsListEntry_RotationsListEntry).KeyId
}

func (_this RotationsListEntry) Dtor_RotationDate() m_Wrappers.Option {
	return _this.Get_().(RotationsListEntry_RotationsListEntry).RotationDate
}

func (_this RotationsListEntry) Dtor_RotationType() m_Wrappers.Option {
	return _this.Get_().(RotationsListEntry_RotationsListEntry).RotationType
}

func (_this RotationsListEntry) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RotationsListEntry_RotationsListEntry:
		{
			return "ComAmazonawsKmsTypes.RotationsListEntry.RotationsListEntry" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.RotationDate) + ", " + _dafny.String(data.RotationType) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RotationsListEntry) Equals(other RotationsListEntry) bool {
	switch data1 := _this.Get_().(type) {
	case RotationsListEntry_RotationsListEntry:
		{
			data2, ok := other.Get_().(RotationsListEntry_RotationsListEntry)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.RotationDate.Equals(data2.RotationDate) && data1.RotationType.Equals(data2.RotationType)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RotationsListEntry) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RotationsListEntry)
	return ok && _this.Equals(typed)
}

func Type_RotationsListEntry_() _dafny.TypeDescriptor {
	return type_RotationsListEntry_{}
}

type type_RotationsListEntry_ struct {
}

func (_this type_RotationsListEntry_) Default() interface{} {
	return Companion_RotationsListEntry_.Default()
}

func (_this type_RotationsListEntry_) String() string {
	return "ComAmazonawsKmsTypes.RotationsListEntry"
}
func (_this RotationsListEntry) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RotationsListEntry{}

// End of datatype RotationsListEntry

// Definition of datatype RotationType
type RotationType struct {
	Data_RotationType_
}

func (_this RotationType) Get_() Data_RotationType_ {
	return _this.Data_RotationType_
}

type Data_RotationType_ interface {
	isRotationType()
}

type CompanionStruct_RotationType_ struct {
}

var Companion_RotationType_ = CompanionStruct_RotationType_{}

type RotationType_AUTOMATIC struct {
}

func (RotationType_AUTOMATIC) isRotationType() {}

func (CompanionStruct_RotationType_) Create_AUTOMATIC_() RotationType {
	return RotationType{RotationType_AUTOMATIC{}}
}

func (_this RotationType) Is_AUTOMATIC() bool {
	_, ok := _this.Get_().(RotationType_AUTOMATIC)
	return ok
}

type RotationType_ON__DEMAND struct {
}

func (RotationType_ON__DEMAND) isRotationType() {}

func (CompanionStruct_RotationType_) Create_ON__DEMAND_() RotationType {
	return RotationType{RotationType_ON__DEMAND{}}
}

func (_this RotationType) Is_ON__DEMAND() bool {
	_, ok := _this.Get_().(RotationType_ON__DEMAND)
	return ok
}

func (CompanionStruct_RotationType_) Default() RotationType {
	return Companion_RotationType_.Create_AUTOMATIC_()
}

func (_ CompanionStruct_RotationType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_RotationType_.Create_AUTOMATIC_(), true
		case 1:
			return Companion_RotationType_.Create_ON__DEMAND_(), true
		default:
			return RotationType{}, false
		}
	}
}

func (_this RotationType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case RotationType_AUTOMATIC:
		{
			return "ComAmazonawsKmsTypes.RotationType.AUTOMATIC"
		}
	case RotationType_ON__DEMAND:
		{
			return "ComAmazonawsKmsTypes.RotationType.ON_DEMAND"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RotationType) Equals(other RotationType) bool {
	switch _this.Get_().(type) {
	case RotationType_AUTOMATIC:
		{
			_, ok := other.Get_().(RotationType_AUTOMATIC)
			return ok
		}
	case RotationType_ON__DEMAND:
		{
			_, ok := other.Get_().(RotationType_ON__DEMAND)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RotationType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RotationType)
	return ok && _this.Equals(typed)
}

func Type_RotationType_() _dafny.TypeDescriptor {
	return type_RotationType_{}
}

type type_RotationType_ struct {
}

func (_this type_RotationType_) Default() interface{} {
	return Companion_RotationType_.Default()
}

func (_this type_RotationType_) String() string {
	return "ComAmazonawsKmsTypes.RotationType"
}
func (_this RotationType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RotationType{}

// End of datatype RotationType

// Definition of datatype ScheduleKeyDeletionRequest
type ScheduleKeyDeletionRequest struct {
	Data_ScheduleKeyDeletionRequest_
}

func (_this ScheduleKeyDeletionRequest) Get_() Data_ScheduleKeyDeletionRequest_ {
	return _this.Data_ScheduleKeyDeletionRequest_
}

type Data_ScheduleKeyDeletionRequest_ interface {
	isScheduleKeyDeletionRequest()
}

type CompanionStruct_ScheduleKeyDeletionRequest_ struct {
}

var Companion_ScheduleKeyDeletionRequest_ = CompanionStruct_ScheduleKeyDeletionRequest_{}

type ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest struct {
	KeyId               _dafny.Sequence
	PendingWindowInDays m_Wrappers.Option
}

func (ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest) isScheduleKeyDeletionRequest() {}

func (CompanionStruct_ScheduleKeyDeletionRequest_) Create_ScheduleKeyDeletionRequest_(KeyId _dafny.Sequence, PendingWindowInDays m_Wrappers.Option) ScheduleKeyDeletionRequest {
	return ScheduleKeyDeletionRequest{ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest{KeyId, PendingWindowInDays}}
}

func (_this ScheduleKeyDeletionRequest) Is_ScheduleKeyDeletionRequest() bool {
	_, ok := _this.Get_().(ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest)
	return ok
}

func (CompanionStruct_ScheduleKeyDeletionRequest_) Default() ScheduleKeyDeletionRequest {
	return Companion_ScheduleKeyDeletionRequest_.Create_ScheduleKeyDeletionRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this ScheduleKeyDeletionRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest).KeyId
}

func (_this ScheduleKeyDeletionRequest) Dtor_PendingWindowInDays() m_Wrappers.Option {
	return _this.Get_().(ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest).PendingWindowInDays
}

func (_this ScheduleKeyDeletionRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest:
		{
			return "ComAmazonawsKmsTypes.ScheduleKeyDeletionRequest.ScheduleKeyDeletionRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.PendingWindowInDays) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ScheduleKeyDeletionRequest) Equals(other ScheduleKeyDeletionRequest) bool {
	switch data1 := _this.Get_().(type) {
	case ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest:
		{
			data2, ok := other.Get_().(ScheduleKeyDeletionRequest_ScheduleKeyDeletionRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.PendingWindowInDays.Equals(data2.PendingWindowInDays)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ScheduleKeyDeletionRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ScheduleKeyDeletionRequest)
	return ok && _this.Equals(typed)
}

func Type_ScheduleKeyDeletionRequest_() _dafny.TypeDescriptor {
	return type_ScheduleKeyDeletionRequest_{}
}

type type_ScheduleKeyDeletionRequest_ struct {
}

func (_this type_ScheduleKeyDeletionRequest_) Default() interface{} {
	return Companion_ScheduleKeyDeletionRequest_.Default()
}

func (_this type_ScheduleKeyDeletionRequest_) String() string {
	return "ComAmazonawsKmsTypes.ScheduleKeyDeletionRequest"
}
func (_this ScheduleKeyDeletionRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ScheduleKeyDeletionRequest{}

// End of datatype ScheduleKeyDeletionRequest

// Definition of datatype ScheduleKeyDeletionResponse
type ScheduleKeyDeletionResponse struct {
	Data_ScheduleKeyDeletionResponse_
}

func (_this ScheduleKeyDeletionResponse) Get_() Data_ScheduleKeyDeletionResponse_ {
	return _this.Data_ScheduleKeyDeletionResponse_
}

type Data_ScheduleKeyDeletionResponse_ interface {
	isScheduleKeyDeletionResponse()
}

type CompanionStruct_ScheduleKeyDeletionResponse_ struct {
}

var Companion_ScheduleKeyDeletionResponse_ = CompanionStruct_ScheduleKeyDeletionResponse_{}

type ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse struct {
	KeyId               m_Wrappers.Option
	DeletionDate        m_Wrappers.Option
	KeyState            m_Wrappers.Option
	PendingWindowInDays m_Wrappers.Option
}

func (ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse) isScheduleKeyDeletionResponse() {}

func (CompanionStruct_ScheduleKeyDeletionResponse_) Create_ScheduleKeyDeletionResponse_(KeyId m_Wrappers.Option, DeletionDate m_Wrappers.Option, KeyState m_Wrappers.Option, PendingWindowInDays m_Wrappers.Option) ScheduleKeyDeletionResponse {
	return ScheduleKeyDeletionResponse{ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse{KeyId, DeletionDate, KeyState, PendingWindowInDays}}
}

func (_this ScheduleKeyDeletionResponse) Is_ScheduleKeyDeletionResponse() bool {
	_, ok := _this.Get_().(ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse)
	return ok
}

func (CompanionStruct_ScheduleKeyDeletionResponse_) Default() ScheduleKeyDeletionResponse {
	return Companion_ScheduleKeyDeletionResponse_.Create_ScheduleKeyDeletionResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this ScheduleKeyDeletionResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse).KeyId
}

func (_this ScheduleKeyDeletionResponse) Dtor_DeletionDate() m_Wrappers.Option {
	return _this.Get_().(ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse).DeletionDate
}

func (_this ScheduleKeyDeletionResponse) Dtor_KeyState() m_Wrappers.Option {
	return _this.Get_().(ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse).KeyState
}

func (_this ScheduleKeyDeletionResponse) Dtor_PendingWindowInDays() m_Wrappers.Option {
	return _this.Get_().(ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse).PendingWindowInDays
}

func (_this ScheduleKeyDeletionResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse:
		{
			return "ComAmazonawsKmsTypes.ScheduleKeyDeletionResponse.ScheduleKeyDeletionResponse" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.DeletionDate) + ", " + _dafny.String(data.KeyState) + ", " + _dafny.String(data.PendingWindowInDays) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ScheduleKeyDeletionResponse) Equals(other ScheduleKeyDeletionResponse) bool {
	switch data1 := _this.Get_().(type) {
	case ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse:
		{
			data2, ok := other.Get_().(ScheduleKeyDeletionResponse_ScheduleKeyDeletionResponse)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.DeletionDate.Equals(data2.DeletionDate) && data1.KeyState.Equals(data2.KeyState) && data1.PendingWindowInDays.Equals(data2.PendingWindowInDays)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ScheduleKeyDeletionResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ScheduleKeyDeletionResponse)
	return ok && _this.Equals(typed)
}

func Type_ScheduleKeyDeletionResponse_() _dafny.TypeDescriptor {
	return type_ScheduleKeyDeletionResponse_{}
}

type type_ScheduleKeyDeletionResponse_ struct {
}

func (_this type_ScheduleKeyDeletionResponse_) Default() interface{} {
	return Companion_ScheduleKeyDeletionResponse_.Default()
}

func (_this type_ScheduleKeyDeletionResponse_) String() string {
	return "ComAmazonawsKmsTypes.ScheduleKeyDeletionResponse"
}
func (_this ScheduleKeyDeletionResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ScheduleKeyDeletionResponse{}

// End of datatype ScheduleKeyDeletionResponse

// Definition of datatype SigningAlgorithmSpec
type SigningAlgorithmSpec struct {
	Data_SigningAlgorithmSpec_
}

func (_this SigningAlgorithmSpec) Get_() Data_SigningAlgorithmSpec_ {
	return _this.Data_SigningAlgorithmSpec_
}

type Data_SigningAlgorithmSpec_ interface {
	isSigningAlgorithmSpec()
}

type CompanionStruct_SigningAlgorithmSpec_ struct {
}

var Companion_SigningAlgorithmSpec_ = CompanionStruct_SigningAlgorithmSpec_{}

type SigningAlgorithmSpec_RSASSA__PSS__SHA__256 struct {
}

func (SigningAlgorithmSpec_RSASSA__PSS__SHA__256) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_RSASSA__PSS__SHA__256_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_RSASSA__PSS__SHA__256{}}
}

func (_this SigningAlgorithmSpec) Is_RSASSA__PSS__SHA__256() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_RSASSA__PSS__SHA__256)
	return ok
}

type SigningAlgorithmSpec_RSASSA__PSS__SHA__384 struct {
}

func (SigningAlgorithmSpec_RSASSA__PSS__SHA__384) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_RSASSA__PSS__SHA__384_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_RSASSA__PSS__SHA__384{}}
}

func (_this SigningAlgorithmSpec) Is_RSASSA__PSS__SHA__384() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_RSASSA__PSS__SHA__384)
	return ok
}

type SigningAlgorithmSpec_RSASSA__PSS__SHA__512 struct {
}

func (SigningAlgorithmSpec_RSASSA__PSS__SHA__512) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_RSASSA__PSS__SHA__512_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_RSASSA__PSS__SHA__512{}}
}

func (_this SigningAlgorithmSpec) Is_RSASSA__PSS__SHA__512() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_RSASSA__PSS__SHA__512)
	return ok
}

type SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__256 struct {
}

func (SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__256) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_RSASSA__PKCS1__V1__5__SHA__256_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__256{}}
}

func (_this SigningAlgorithmSpec) Is_RSASSA__PKCS1__V1__5__SHA__256() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__256)
	return ok
}

type SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__384 struct {
}

func (SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__384) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_RSASSA__PKCS1__V1__5__SHA__384_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__384{}}
}

func (_this SigningAlgorithmSpec) Is_RSASSA__PKCS1__V1__5__SHA__384() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__384)
	return ok
}

type SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__512 struct {
}

func (SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__512) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_RSASSA__PKCS1__V1__5__SHA__512_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__512{}}
}

func (_this SigningAlgorithmSpec) Is_RSASSA__PKCS1__V1__5__SHA__512() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__512)
	return ok
}

type SigningAlgorithmSpec_ECDSA__SHA__256 struct {
}

func (SigningAlgorithmSpec_ECDSA__SHA__256) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_ECDSA__SHA__256_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_ECDSA__SHA__256{}}
}

func (_this SigningAlgorithmSpec) Is_ECDSA__SHA__256() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_ECDSA__SHA__256)
	return ok
}

type SigningAlgorithmSpec_ECDSA__SHA__384 struct {
}

func (SigningAlgorithmSpec_ECDSA__SHA__384) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_ECDSA__SHA__384_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_ECDSA__SHA__384{}}
}

func (_this SigningAlgorithmSpec) Is_ECDSA__SHA__384() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_ECDSA__SHA__384)
	return ok
}

type SigningAlgorithmSpec_ECDSA__SHA__512 struct {
}

func (SigningAlgorithmSpec_ECDSA__SHA__512) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_ECDSA__SHA__512_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_ECDSA__SHA__512{}}
}

func (_this SigningAlgorithmSpec) Is_ECDSA__SHA__512() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_ECDSA__SHA__512)
	return ok
}

type SigningAlgorithmSpec_SM2DSA struct {
}

func (SigningAlgorithmSpec_SM2DSA) isSigningAlgorithmSpec() {}

func (CompanionStruct_SigningAlgorithmSpec_) Create_SM2DSA_() SigningAlgorithmSpec {
	return SigningAlgorithmSpec{SigningAlgorithmSpec_SM2DSA{}}
}

func (_this SigningAlgorithmSpec) Is_SM2DSA() bool {
	_, ok := _this.Get_().(SigningAlgorithmSpec_SM2DSA)
	return ok
}

func (CompanionStruct_SigningAlgorithmSpec_) Default() SigningAlgorithmSpec {
	return Companion_SigningAlgorithmSpec_.Create_RSASSA__PSS__SHA__256_()
}

func (_ CompanionStruct_SigningAlgorithmSpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_SigningAlgorithmSpec_.Create_RSASSA__PSS__SHA__256_(), true
		case 1:
			return Companion_SigningAlgorithmSpec_.Create_RSASSA__PSS__SHA__384_(), true
		case 2:
			return Companion_SigningAlgorithmSpec_.Create_RSASSA__PSS__SHA__512_(), true
		case 3:
			return Companion_SigningAlgorithmSpec_.Create_RSASSA__PKCS1__V1__5__SHA__256_(), true
		case 4:
			return Companion_SigningAlgorithmSpec_.Create_RSASSA__PKCS1__V1__5__SHA__384_(), true
		case 5:
			return Companion_SigningAlgorithmSpec_.Create_RSASSA__PKCS1__V1__5__SHA__512_(), true
		case 6:
			return Companion_SigningAlgorithmSpec_.Create_ECDSA__SHA__256_(), true
		case 7:
			return Companion_SigningAlgorithmSpec_.Create_ECDSA__SHA__384_(), true
		case 8:
			return Companion_SigningAlgorithmSpec_.Create_ECDSA__SHA__512_(), true
		case 9:
			return Companion_SigningAlgorithmSpec_.Create_SM2DSA_(), true
		default:
			return SigningAlgorithmSpec{}, false
		}
	}
}

func (_this SigningAlgorithmSpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case SigningAlgorithmSpec_RSASSA__PSS__SHA__256:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.RSASSA_PSS_SHA_256"
		}
	case SigningAlgorithmSpec_RSASSA__PSS__SHA__384:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.RSASSA_PSS_SHA_384"
		}
	case SigningAlgorithmSpec_RSASSA__PSS__SHA__512:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.RSASSA_PSS_SHA_512"
		}
	case SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__256:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.RSASSA_PKCS1_V1_5_SHA_256"
		}
	case SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__384:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.RSASSA_PKCS1_V1_5_SHA_384"
		}
	case SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__512:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.RSASSA_PKCS1_V1_5_SHA_512"
		}
	case SigningAlgorithmSpec_ECDSA__SHA__256:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.ECDSA_SHA_256"
		}
	case SigningAlgorithmSpec_ECDSA__SHA__384:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.ECDSA_SHA_384"
		}
	case SigningAlgorithmSpec_ECDSA__SHA__512:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.ECDSA_SHA_512"
		}
	case SigningAlgorithmSpec_SM2DSA:
		{
			return "ComAmazonawsKmsTypes.SigningAlgorithmSpec.SM2DSA"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SigningAlgorithmSpec) Equals(other SigningAlgorithmSpec) bool {
	switch _this.Get_().(type) {
	case SigningAlgorithmSpec_RSASSA__PSS__SHA__256:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_RSASSA__PSS__SHA__256)
			return ok
		}
	case SigningAlgorithmSpec_RSASSA__PSS__SHA__384:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_RSASSA__PSS__SHA__384)
			return ok
		}
	case SigningAlgorithmSpec_RSASSA__PSS__SHA__512:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_RSASSA__PSS__SHA__512)
			return ok
		}
	case SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__256:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__256)
			return ok
		}
	case SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__384:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__384)
			return ok
		}
	case SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__512:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_RSASSA__PKCS1__V1__5__SHA__512)
			return ok
		}
	case SigningAlgorithmSpec_ECDSA__SHA__256:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_ECDSA__SHA__256)
			return ok
		}
	case SigningAlgorithmSpec_ECDSA__SHA__384:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_ECDSA__SHA__384)
			return ok
		}
	case SigningAlgorithmSpec_ECDSA__SHA__512:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_ECDSA__SHA__512)
			return ok
		}
	case SigningAlgorithmSpec_SM2DSA:
		{
			_, ok := other.Get_().(SigningAlgorithmSpec_SM2DSA)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SigningAlgorithmSpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SigningAlgorithmSpec)
	return ok && _this.Equals(typed)
}

func Type_SigningAlgorithmSpec_() _dafny.TypeDescriptor {
	return type_SigningAlgorithmSpec_{}
}

type type_SigningAlgorithmSpec_ struct {
}

func (_this type_SigningAlgorithmSpec_) Default() interface{} {
	return Companion_SigningAlgorithmSpec_.Default()
}

func (_this type_SigningAlgorithmSpec_) String() string {
	return "ComAmazonawsKmsTypes.SigningAlgorithmSpec"
}
func (_this SigningAlgorithmSpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SigningAlgorithmSpec{}

// End of datatype SigningAlgorithmSpec

// Definition of datatype SignRequest
type SignRequest struct {
	Data_SignRequest_
}

func (_this SignRequest) Get_() Data_SignRequest_ {
	return _this.Data_SignRequest_
}

type Data_SignRequest_ interface {
	isSignRequest()
}

type CompanionStruct_SignRequest_ struct {
}

var Companion_SignRequest_ = CompanionStruct_SignRequest_{}

type SignRequest_SignRequest struct {
	KeyId            _dafny.Sequence
	Message          _dafny.Sequence
	MessageType      m_Wrappers.Option
	GrantTokens      m_Wrappers.Option
	SigningAlgorithm SigningAlgorithmSpec
	DryRun           m_Wrappers.Option
}

func (SignRequest_SignRequest) isSignRequest() {}

func (CompanionStruct_SignRequest_) Create_SignRequest_(KeyId _dafny.Sequence, Message _dafny.Sequence, MessageType m_Wrappers.Option, GrantTokens m_Wrappers.Option, SigningAlgorithm SigningAlgorithmSpec, DryRun m_Wrappers.Option) SignRequest {
	return SignRequest{SignRequest_SignRequest{KeyId, Message, MessageType, GrantTokens, SigningAlgorithm, DryRun}}
}

func (_this SignRequest) Is_SignRequest() bool {
	_, ok := _this.Get_().(SignRequest_SignRequest)
	return ok
}

func (CompanionStruct_SignRequest_) Default() SignRequest {
	return Companion_SignRequest_.Create_SignRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), Companion_SigningAlgorithmSpec_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this SignRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(SignRequest_SignRequest).KeyId
}

func (_this SignRequest) Dtor_Message() _dafny.Sequence {
	return _this.Get_().(SignRequest_SignRequest).Message
}

func (_this SignRequest) Dtor_MessageType() m_Wrappers.Option {
	return _this.Get_().(SignRequest_SignRequest).MessageType
}

func (_this SignRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(SignRequest_SignRequest).GrantTokens
}

func (_this SignRequest) Dtor_SigningAlgorithm() SigningAlgorithmSpec {
	return _this.Get_().(SignRequest_SignRequest).SigningAlgorithm
}

func (_this SignRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(SignRequest_SignRequest).DryRun
}

func (_this SignRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SignRequest_SignRequest:
		{
			return "ComAmazonawsKmsTypes.SignRequest.SignRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Message) + ", " + _dafny.String(data.MessageType) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.SigningAlgorithm) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SignRequest) Equals(other SignRequest) bool {
	switch data1 := _this.Get_().(type) {
	case SignRequest_SignRequest:
		{
			data2, ok := other.Get_().(SignRequest_SignRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Message.Equals(data2.Message) && data1.MessageType.Equals(data2.MessageType) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.SigningAlgorithm.Equals(data2.SigningAlgorithm) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SignRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SignRequest)
	return ok && _this.Equals(typed)
}

func Type_SignRequest_() _dafny.TypeDescriptor {
	return type_SignRequest_{}
}

type type_SignRequest_ struct {
}

func (_this type_SignRequest_) Default() interface{} {
	return Companion_SignRequest_.Default()
}

func (_this type_SignRequest_) String() string {
	return "ComAmazonawsKmsTypes.SignRequest"
}
func (_this SignRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SignRequest{}

// End of datatype SignRequest

// Definition of datatype SignResponse
type SignResponse struct {
	Data_SignResponse_
}

func (_this SignResponse) Get_() Data_SignResponse_ {
	return _this.Data_SignResponse_
}

type Data_SignResponse_ interface {
	isSignResponse()
}

type CompanionStruct_SignResponse_ struct {
}

var Companion_SignResponse_ = CompanionStruct_SignResponse_{}

type SignResponse_SignResponse struct {
	KeyId            m_Wrappers.Option
	Signature        m_Wrappers.Option
	SigningAlgorithm m_Wrappers.Option
}

func (SignResponse_SignResponse) isSignResponse() {}

func (CompanionStruct_SignResponse_) Create_SignResponse_(KeyId m_Wrappers.Option, Signature m_Wrappers.Option, SigningAlgorithm m_Wrappers.Option) SignResponse {
	return SignResponse{SignResponse_SignResponse{KeyId, Signature, SigningAlgorithm}}
}

func (_this SignResponse) Is_SignResponse() bool {
	_, ok := _this.Get_().(SignResponse_SignResponse)
	return ok
}

func (CompanionStruct_SignResponse_) Default() SignResponse {
	return Companion_SignResponse_.Create_SignResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this SignResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(SignResponse_SignResponse).KeyId
}

func (_this SignResponse) Dtor_Signature() m_Wrappers.Option {
	return _this.Get_().(SignResponse_SignResponse).Signature
}

func (_this SignResponse) Dtor_SigningAlgorithm() m_Wrappers.Option {
	return _this.Get_().(SignResponse_SignResponse).SigningAlgorithm
}

func (_this SignResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SignResponse_SignResponse:
		{
			return "ComAmazonawsKmsTypes.SignResponse.SignResponse" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Signature) + ", " + _dafny.String(data.SigningAlgorithm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SignResponse) Equals(other SignResponse) bool {
	switch data1 := _this.Get_().(type) {
	case SignResponse_SignResponse:
		{
			data2, ok := other.Get_().(SignResponse_SignResponse)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Signature.Equals(data2.Signature) && data1.SigningAlgorithm.Equals(data2.SigningAlgorithm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SignResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SignResponse)
	return ok && _this.Equals(typed)
}

func Type_SignResponse_() _dafny.TypeDescriptor {
	return type_SignResponse_{}
}

type type_SignResponse_ struct {
}

func (_this type_SignResponse_) Default() interface{} {
	return Companion_SignResponse_.Default()
}

func (_this type_SignResponse_) String() string {
	return "ComAmazonawsKmsTypes.SignResponse"
}
func (_this SignResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SignResponse{}

// End of datatype SignResponse

// Definition of datatype Tag
type Tag struct {
	Data_Tag_
}

func (_this Tag) Get_() Data_Tag_ {
	return _this.Data_Tag_
}

type Data_Tag_ interface {
	isTag()
}

type CompanionStruct_Tag_ struct {
}

var Companion_Tag_ = CompanionStruct_Tag_{}

type Tag_Tag struct {
	TagKey   _dafny.Sequence
	TagValue _dafny.Sequence
}

func (Tag_Tag) isTag() {}

func (CompanionStruct_Tag_) Create_Tag_(TagKey _dafny.Sequence, TagValue _dafny.Sequence) Tag {
	return Tag{Tag_Tag{TagKey, TagValue}}
}

func (_this Tag) Is_Tag() bool {
	_, ok := _this.Get_().(Tag_Tag)
	return ok
}

func (CompanionStruct_Tag_) Default() Tag {
	return Companion_Tag_.Create_Tag_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this Tag) Dtor_TagKey() _dafny.Sequence {
	return _this.Get_().(Tag_Tag).TagKey
}

func (_this Tag) Dtor_TagValue() _dafny.Sequence {
	return _this.Get_().(Tag_Tag).TagValue
}

func (_this Tag) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Tag_Tag:
		{
			return "ComAmazonawsKmsTypes.Tag.Tag" + "(" + _dafny.String(data.TagKey) + ", " + _dafny.String(data.TagValue) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Tag) Equals(other Tag) bool {
	switch data1 := _this.Get_().(type) {
	case Tag_Tag:
		{
			data2, ok := other.Get_().(Tag_Tag)
			return ok && data1.TagKey.Equals(data2.TagKey) && data1.TagValue.Equals(data2.TagValue)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Tag) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Tag)
	return ok && _this.Equals(typed)
}

func Type_Tag_() _dafny.TypeDescriptor {
	return type_Tag_{}
}

type type_Tag_ struct {
}

func (_this type_Tag_) Default() interface{} {
	return Companion_Tag_.Default()
}

func (_this type_Tag_) String() string {
	return "ComAmazonawsKmsTypes.Tag"
}
func (_this Tag) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Tag{}

// End of datatype Tag

// Definition of class TagKeyType
type TagKeyType struct {
}

func New_TagKeyType_() *TagKeyType {
	_this := TagKeyType{}

	return &_this
}

type CompanionStruct_TagKeyType_ struct {
}

var Companion_TagKeyType_ = CompanionStruct_TagKeyType_{}

func (*TagKeyType) String() string {
	return "ComAmazonawsKmsTypes.TagKeyType"
}

// End of class TagKeyType

func Type_TagKeyType_() _dafny.TypeDescriptor {
	return type_TagKeyType_{}
}

type type_TagKeyType_ struct {
}

func (_this type_TagKeyType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_TagKeyType_) String() string {
	return "ComAmazonawsKmsTypes.TagKeyType"
}
func (_this *CompanionStruct_TagKeyType_) Is_(__source _dafny.Sequence) bool {
	var _25_x _dafny.Sequence = (__source)
	_ = _25_x
	return Companion_Default___.IsValid__TagKeyType(_25_x)
}

// Definition of datatype TagResourceRequest
type TagResourceRequest struct {
	Data_TagResourceRequest_
}

func (_this TagResourceRequest) Get_() Data_TagResourceRequest_ {
	return _this.Data_TagResourceRequest_
}

type Data_TagResourceRequest_ interface {
	isTagResourceRequest()
}

type CompanionStruct_TagResourceRequest_ struct {
}

var Companion_TagResourceRequest_ = CompanionStruct_TagResourceRequest_{}

type TagResourceRequest_TagResourceRequest struct {
	KeyId _dafny.Sequence
	Tags  _dafny.Sequence
}

func (TagResourceRequest_TagResourceRequest) isTagResourceRequest() {}

func (CompanionStruct_TagResourceRequest_) Create_TagResourceRequest_(KeyId _dafny.Sequence, Tags _dafny.Sequence) TagResourceRequest {
	return TagResourceRequest{TagResourceRequest_TagResourceRequest{KeyId, Tags}}
}

func (_this TagResourceRequest) Is_TagResourceRequest() bool {
	_, ok := _this.Get_().(TagResourceRequest_TagResourceRequest)
	return ok
}

func (CompanionStruct_TagResourceRequest_) Default() TagResourceRequest {
	return Companion_TagResourceRequest_.Create_TagResourceRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq)
}

func (_this TagResourceRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(TagResourceRequest_TagResourceRequest).KeyId
}

func (_this TagResourceRequest) Dtor_Tags() _dafny.Sequence {
	return _this.Get_().(TagResourceRequest_TagResourceRequest).Tags
}

func (_this TagResourceRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TagResourceRequest_TagResourceRequest:
		{
			return "ComAmazonawsKmsTypes.TagResourceRequest.TagResourceRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Tags) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TagResourceRequest) Equals(other TagResourceRequest) bool {
	switch data1 := _this.Get_().(type) {
	case TagResourceRequest_TagResourceRequest:
		{
			data2, ok := other.Get_().(TagResourceRequest_TagResourceRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Tags.Equals(data2.Tags)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TagResourceRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TagResourceRequest)
	return ok && _this.Equals(typed)
}

func Type_TagResourceRequest_() _dafny.TypeDescriptor {
	return type_TagResourceRequest_{}
}

type type_TagResourceRequest_ struct {
}

func (_this type_TagResourceRequest_) Default() interface{} {
	return Companion_TagResourceRequest_.Default()
}

func (_this type_TagResourceRequest_) String() string {
	return "ComAmazonawsKmsTypes.TagResourceRequest"
}
func (_this TagResourceRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TagResourceRequest{}

// End of datatype TagResourceRequest

// Definition of class TagValueType
type TagValueType struct {
}

func New_TagValueType_() *TagValueType {
	_this := TagValueType{}

	return &_this
}

type CompanionStruct_TagValueType_ struct {
}

var Companion_TagValueType_ = CompanionStruct_TagValueType_{}

func (*TagValueType) String() string {
	return "ComAmazonawsKmsTypes.TagValueType"
}

// End of class TagValueType

func Type_TagValueType_() _dafny.TypeDescriptor {
	return type_TagValueType_{}
}

type type_TagValueType_ struct {
}

func (_this type_TagValueType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_TagValueType_) String() string {
	return "ComAmazonawsKmsTypes.TagValueType"
}
func (_this *CompanionStruct_TagValueType_) Is_(__source _dafny.Sequence) bool {
	var _26_x _dafny.Sequence = (__source)
	_ = _26_x
	return Companion_Default___.IsValid__TagValueType(_26_x)
}

// Definition of class IKMSClientCallHistory
type IKMSClientCallHistory struct {
	dummy byte
}

func New_IKMSClientCallHistory_() *IKMSClientCallHistory {
	_this := IKMSClientCallHistory{}

	return &_this
}

type CompanionStruct_IKMSClientCallHistory_ struct {
}

var Companion_IKMSClientCallHistory_ = CompanionStruct_IKMSClientCallHistory_{}

func (_this *IKMSClientCallHistory) Equals(other *IKMSClientCallHistory) bool {
	return _this == other
}

func (_this *IKMSClientCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IKMSClientCallHistory)
	return ok && _this.Equals(other)
}

func (*IKMSClientCallHistory) String() string {
	return "ComAmazonawsKmsTypes.IKMSClientCallHistory"
}

func Type_IKMSClientCallHistory_() _dafny.TypeDescriptor {
	return type_IKMSClientCallHistory_{}
}

type type_IKMSClientCallHistory_ struct {
}

func (_this type_IKMSClientCallHistory_) Default() interface{} {
	return (*IKMSClientCallHistory)(nil)
}

func (_this type_IKMSClientCallHistory_) String() string {
	return "ComAmazonawsKmsTypes.IKMSClientCallHistory"
}
func (_this *IKMSClientCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IKMSClientCallHistory{}

// End of class IKMSClientCallHistory

// Definition of trait IKMSClient
type IKMSClient interface {
	String() string
	CancelKeyDeletion(input CancelKeyDeletionRequest) m_Wrappers.Result
	ConnectCustomKeyStore(input ConnectCustomKeyStoreRequest) m_Wrappers.Result
	CreateAlias(input CreateAliasRequest) m_Wrappers.Result
	CreateCustomKeyStore(input CreateCustomKeyStoreRequest) m_Wrappers.Result
	CreateGrant(input CreateGrantRequest) m_Wrappers.Result
	CreateKey(input CreateKeyRequest) m_Wrappers.Result
	Decrypt(input DecryptRequest) m_Wrappers.Result
	DeleteAlias(input DeleteAliasRequest) m_Wrappers.Result
	DeleteCustomKeyStore(input DeleteCustomKeyStoreRequest) m_Wrappers.Result
	DeleteImportedKeyMaterial(input DeleteImportedKeyMaterialRequest) m_Wrappers.Result
	DeriveSharedSecret(input DeriveSharedSecretRequest) m_Wrappers.Result
	DescribeCustomKeyStores(input DescribeCustomKeyStoresRequest) m_Wrappers.Result
	DescribeKey(input DescribeKeyRequest) m_Wrappers.Result
	DisableKey(input DisableKeyRequest) m_Wrappers.Result
	DisableKeyRotation(input DisableKeyRotationRequest) m_Wrappers.Result
	DisconnectCustomKeyStore(input DisconnectCustomKeyStoreRequest) m_Wrappers.Result
	EnableKey(input EnableKeyRequest) m_Wrappers.Result
	EnableKeyRotation(input EnableKeyRotationRequest) m_Wrappers.Result
	Encrypt(input EncryptRequest) m_Wrappers.Result
	GenerateDataKey(input GenerateDataKeyRequest) m_Wrappers.Result
	GenerateDataKeyPair(input GenerateDataKeyPairRequest) m_Wrappers.Result
	GenerateDataKeyPairWithoutPlaintext(input GenerateDataKeyPairWithoutPlaintextRequest) m_Wrappers.Result
	GenerateDataKeyWithoutPlaintext(input GenerateDataKeyWithoutPlaintextRequest) m_Wrappers.Result
	GenerateMac(input GenerateMacRequest) m_Wrappers.Result
	GenerateRandom(input GenerateRandomRequest) m_Wrappers.Result
	GetKeyPolicy(input GetKeyPolicyRequest) m_Wrappers.Result
	GetKeyRotationStatus(input GetKeyRotationStatusRequest) m_Wrappers.Result
	GetParametersForImport(input GetParametersForImportRequest) m_Wrappers.Result
	GetPublicKey(input GetPublicKeyRequest) m_Wrappers.Result
	ImportKeyMaterial(input ImportKeyMaterialRequest) m_Wrappers.Result
	ListAliases(input ListAliasesRequest) m_Wrappers.Result
	ListGrants(input ListGrantsRequest) m_Wrappers.Result
	ListKeyPolicies(input ListKeyPoliciesRequest) m_Wrappers.Result
	ListKeyRotations(input ListKeyRotationsRequest) m_Wrappers.Result
	ListKeys(input ListKeysRequest) m_Wrappers.Result
	ListResourceTags(input ListResourceTagsRequest) m_Wrappers.Result
	PutKeyPolicy(input PutKeyPolicyRequest) m_Wrappers.Result
	ReEncrypt(input ReEncryptRequest) m_Wrappers.Result
	ReplicateKey(input ReplicateKeyRequest) m_Wrappers.Result
	RetireGrant(input RetireGrantRequest) m_Wrappers.Result
	RevokeGrant(input RevokeGrantRequest) m_Wrappers.Result
	RotateKeyOnDemand(input RotateKeyOnDemandRequest) m_Wrappers.Result
	ScheduleKeyDeletion(input ScheduleKeyDeletionRequest) m_Wrappers.Result
	Sign(input SignRequest) m_Wrappers.Result
	TagResource(input TagResourceRequest) m_Wrappers.Result
	UntagResource(input UntagResourceRequest) m_Wrappers.Result
	UpdateAlias(input UpdateAliasRequest) m_Wrappers.Result
	UpdateCustomKeyStore(input UpdateCustomKeyStoreRequest) m_Wrappers.Result
	UpdateKeyDescription(input UpdateKeyDescriptionRequest) m_Wrappers.Result
	UpdatePrimaryRegion(input UpdatePrimaryRegionRequest) m_Wrappers.Result
	Verify(input VerifyRequest) m_Wrappers.Result
	VerifyMac(input VerifyMacRequest) m_Wrappers.Result
}
type CompanionStruct_IKMSClient_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IKMSClient_ = CompanionStruct_IKMSClient_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IKMSClient_) CastTo_(x interface{}) IKMSClient {
	var t IKMSClient
	t, _ = x.(IKMSClient)
	return t
}

// End of trait IKMSClient

// Definition of class TrustAnchorCertificateType
type TrustAnchorCertificateType struct {
}

func New_TrustAnchorCertificateType_() *TrustAnchorCertificateType {
	_this := TrustAnchorCertificateType{}

	return &_this
}

type CompanionStruct_TrustAnchorCertificateType_ struct {
}

var Companion_TrustAnchorCertificateType_ = CompanionStruct_TrustAnchorCertificateType_{}

func (*TrustAnchorCertificateType) String() string {
	return "ComAmazonawsKmsTypes.TrustAnchorCertificateType"
}

// End of class TrustAnchorCertificateType

func Type_TrustAnchorCertificateType_() _dafny.TypeDescriptor {
	return type_TrustAnchorCertificateType_{}
}

type type_TrustAnchorCertificateType_ struct {
}

func (_this type_TrustAnchorCertificateType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_TrustAnchorCertificateType_) String() string {
	return "ComAmazonawsKmsTypes.TrustAnchorCertificateType"
}
func (_this *CompanionStruct_TrustAnchorCertificateType_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return Companion_Default___.IsValid__TrustAnchorCertificateType(_0_x)
}

// Definition of datatype UntagResourceRequest
type UntagResourceRequest struct {
	Data_UntagResourceRequest_
}

func (_this UntagResourceRequest) Get_() Data_UntagResourceRequest_ {
	return _this.Data_UntagResourceRequest_
}

type Data_UntagResourceRequest_ interface {
	isUntagResourceRequest()
}

type CompanionStruct_UntagResourceRequest_ struct {
}

var Companion_UntagResourceRequest_ = CompanionStruct_UntagResourceRequest_{}

type UntagResourceRequest_UntagResourceRequest struct {
	KeyId   _dafny.Sequence
	TagKeys _dafny.Sequence
}

func (UntagResourceRequest_UntagResourceRequest) isUntagResourceRequest() {}

func (CompanionStruct_UntagResourceRequest_) Create_UntagResourceRequest_(KeyId _dafny.Sequence, TagKeys _dafny.Sequence) UntagResourceRequest {
	return UntagResourceRequest{UntagResourceRequest_UntagResourceRequest{KeyId, TagKeys}}
}

func (_this UntagResourceRequest) Is_UntagResourceRequest() bool {
	_, ok := _this.Get_().(UntagResourceRequest_UntagResourceRequest)
	return ok
}

func (CompanionStruct_UntagResourceRequest_) Default() UntagResourceRequest {
	return Companion_UntagResourceRequest_.Create_UntagResourceRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq)
}

func (_this UntagResourceRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(UntagResourceRequest_UntagResourceRequest).KeyId
}

func (_this UntagResourceRequest) Dtor_TagKeys() _dafny.Sequence {
	return _this.Get_().(UntagResourceRequest_UntagResourceRequest).TagKeys
}

func (_this UntagResourceRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UntagResourceRequest_UntagResourceRequest:
		{
			return "ComAmazonawsKmsTypes.UntagResourceRequest.UntagResourceRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.TagKeys) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UntagResourceRequest) Equals(other UntagResourceRequest) bool {
	switch data1 := _this.Get_().(type) {
	case UntagResourceRequest_UntagResourceRequest:
		{
			data2, ok := other.Get_().(UntagResourceRequest_UntagResourceRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.TagKeys.Equals(data2.TagKeys)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UntagResourceRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UntagResourceRequest)
	return ok && _this.Equals(typed)
}

func Type_UntagResourceRequest_() _dafny.TypeDescriptor {
	return type_UntagResourceRequest_{}
}

type type_UntagResourceRequest_ struct {
}

func (_this type_UntagResourceRequest_) Default() interface{} {
	return Companion_UntagResourceRequest_.Default()
}

func (_this type_UntagResourceRequest_) String() string {
	return "ComAmazonawsKmsTypes.UntagResourceRequest"
}
func (_this UntagResourceRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UntagResourceRequest{}

// End of datatype UntagResourceRequest

// Definition of datatype UpdateAliasRequest
type UpdateAliasRequest struct {
	Data_UpdateAliasRequest_
}

func (_this UpdateAliasRequest) Get_() Data_UpdateAliasRequest_ {
	return _this.Data_UpdateAliasRequest_
}

type Data_UpdateAliasRequest_ interface {
	isUpdateAliasRequest()
}

type CompanionStruct_UpdateAliasRequest_ struct {
}

var Companion_UpdateAliasRequest_ = CompanionStruct_UpdateAliasRequest_{}

type UpdateAliasRequest_UpdateAliasRequest struct {
	AliasName   _dafny.Sequence
	TargetKeyId _dafny.Sequence
}

func (UpdateAliasRequest_UpdateAliasRequest) isUpdateAliasRequest() {}

func (CompanionStruct_UpdateAliasRequest_) Create_UpdateAliasRequest_(AliasName _dafny.Sequence, TargetKeyId _dafny.Sequence) UpdateAliasRequest {
	return UpdateAliasRequest{UpdateAliasRequest_UpdateAliasRequest{AliasName, TargetKeyId}}
}

func (_this UpdateAliasRequest) Is_UpdateAliasRequest() bool {
	_, ok := _this.Get_().(UpdateAliasRequest_UpdateAliasRequest)
	return ok
}

func (CompanionStruct_UpdateAliasRequest_) Default() UpdateAliasRequest {
	return Companion_UpdateAliasRequest_.Create_UpdateAliasRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this UpdateAliasRequest) Dtor_AliasName() _dafny.Sequence {
	return _this.Get_().(UpdateAliasRequest_UpdateAliasRequest).AliasName
}

func (_this UpdateAliasRequest) Dtor_TargetKeyId() _dafny.Sequence {
	return _this.Get_().(UpdateAliasRequest_UpdateAliasRequest).TargetKeyId
}

func (_this UpdateAliasRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateAliasRequest_UpdateAliasRequest:
		{
			return "ComAmazonawsKmsTypes.UpdateAliasRequest.UpdateAliasRequest" + "(" + _dafny.String(data.AliasName) + ", " + _dafny.String(data.TargetKeyId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateAliasRequest) Equals(other UpdateAliasRequest) bool {
	switch data1 := _this.Get_().(type) {
	case UpdateAliasRequest_UpdateAliasRequest:
		{
			data2, ok := other.Get_().(UpdateAliasRequest_UpdateAliasRequest)
			return ok && data1.AliasName.Equals(data2.AliasName) && data1.TargetKeyId.Equals(data2.TargetKeyId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateAliasRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateAliasRequest)
	return ok && _this.Equals(typed)
}

func Type_UpdateAliasRequest_() _dafny.TypeDescriptor {
	return type_UpdateAliasRequest_{}
}

type type_UpdateAliasRequest_ struct {
}

func (_this type_UpdateAliasRequest_) Default() interface{} {
	return Companion_UpdateAliasRequest_.Default()
}

func (_this type_UpdateAliasRequest_) String() string {
	return "ComAmazonawsKmsTypes.UpdateAliasRequest"
}
func (_this UpdateAliasRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateAliasRequest{}

// End of datatype UpdateAliasRequest

// Definition of datatype UpdateCustomKeyStoreRequest
type UpdateCustomKeyStoreRequest struct {
	Data_UpdateCustomKeyStoreRequest_
}

func (_this UpdateCustomKeyStoreRequest) Get_() Data_UpdateCustomKeyStoreRequest_ {
	return _this.Data_UpdateCustomKeyStoreRequest_
}

type Data_UpdateCustomKeyStoreRequest_ interface {
	isUpdateCustomKeyStoreRequest()
}

type CompanionStruct_UpdateCustomKeyStoreRequest_ struct {
}

var Companion_UpdateCustomKeyStoreRequest_ = CompanionStruct_UpdateCustomKeyStoreRequest_{}

type UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest struct {
	CustomKeyStoreId                 _dafny.Sequence
	NewCustomKeyStoreName            m_Wrappers.Option
	KeyStorePassword                 m_Wrappers.Option
	CloudHsmClusterId                m_Wrappers.Option
	XksProxyUriEndpoint              m_Wrappers.Option
	XksProxyUriPath                  m_Wrappers.Option
	XksProxyVpcEndpointServiceName   m_Wrappers.Option
	XksProxyAuthenticationCredential m_Wrappers.Option
	XksProxyConnectivity             m_Wrappers.Option
}

func (UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest) isUpdateCustomKeyStoreRequest() {}

func (CompanionStruct_UpdateCustomKeyStoreRequest_) Create_UpdateCustomKeyStoreRequest_(CustomKeyStoreId _dafny.Sequence, NewCustomKeyStoreName m_Wrappers.Option, KeyStorePassword m_Wrappers.Option, CloudHsmClusterId m_Wrappers.Option, XksProxyUriEndpoint m_Wrappers.Option, XksProxyUriPath m_Wrappers.Option, XksProxyVpcEndpointServiceName m_Wrappers.Option, XksProxyAuthenticationCredential m_Wrappers.Option, XksProxyConnectivity m_Wrappers.Option) UpdateCustomKeyStoreRequest {
	return UpdateCustomKeyStoreRequest{UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest{CustomKeyStoreId, NewCustomKeyStoreName, KeyStorePassword, CloudHsmClusterId, XksProxyUriEndpoint, XksProxyUriPath, XksProxyVpcEndpointServiceName, XksProxyAuthenticationCredential, XksProxyConnectivity}}
}

func (_this UpdateCustomKeyStoreRequest) Is_UpdateCustomKeyStoreRequest() bool {
	_, ok := _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest)
	return ok
}

func (CompanionStruct_UpdateCustomKeyStoreRequest_) Default() UpdateCustomKeyStoreRequest {
	return Companion_UpdateCustomKeyStoreRequest_.Create_UpdateCustomKeyStoreRequest_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this UpdateCustomKeyStoreRequest) Dtor_CustomKeyStoreId() _dafny.Sequence {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).CustomKeyStoreId
}

func (_this UpdateCustomKeyStoreRequest) Dtor_NewCustomKeyStoreName() m_Wrappers.Option {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).NewCustomKeyStoreName
}

func (_this UpdateCustomKeyStoreRequest) Dtor_KeyStorePassword() m_Wrappers.Option {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).KeyStorePassword
}

func (_this UpdateCustomKeyStoreRequest) Dtor_CloudHsmClusterId() m_Wrappers.Option {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).CloudHsmClusterId
}

func (_this UpdateCustomKeyStoreRequest) Dtor_XksProxyUriEndpoint() m_Wrappers.Option {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).XksProxyUriEndpoint
}

func (_this UpdateCustomKeyStoreRequest) Dtor_XksProxyUriPath() m_Wrappers.Option {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).XksProxyUriPath
}

func (_this UpdateCustomKeyStoreRequest) Dtor_XksProxyVpcEndpointServiceName() m_Wrappers.Option {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).XksProxyVpcEndpointServiceName
}

func (_this UpdateCustomKeyStoreRequest) Dtor_XksProxyAuthenticationCredential() m_Wrappers.Option {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).XksProxyAuthenticationCredential
}

func (_this UpdateCustomKeyStoreRequest) Dtor_XksProxyConnectivity() m_Wrappers.Option {
	return _this.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest).XksProxyConnectivity
}

func (_this UpdateCustomKeyStoreRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest:
		{
			return "ComAmazonawsKmsTypes.UpdateCustomKeyStoreRequest.UpdateCustomKeyStoreRequest" + "(" + _dafny.String(data.CustomKeyStoreId) + ", " + _dafny.String(data.NewCustomKeyStoreName) + ", " + _dafny.String(data.KeyStorePassword) + ", " + _dafny.String(data.CloudHsmClusterId) + ", " + _dafny.String(data.XksProxyUriEndpoint) + ", " + _dafny.String(data.XksProxyUriPath) + ", " + _dafny.String(data.XksProxyVpcEndpointServiceName) + ", " + _dafny.String(data.XksProxyAuthenticationCredential) + ", " + _dafny.String(data.XksProxyConnectivity) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateCustomKeyStoreRequest) Equals(other UpdateCustomKeyStoreRequest) bool {
	switch data1 := _this.Get_().(type) {
	case UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest:
		{
			data2, ok := other.Get_().(UpdateCustomKeyStoreRequest_UpdateCustomKeyStoreRequest)
			return ok && data1.CustomKeyStoreId.Equals(data2.CustomKeyStoreId) && data1.NewCustomKeyStoreName.Equals(data2.NewCustomKeyStoreName) && data1.KeyStorePassword.Equals(data2.KeyStorePassword) && data1.CloudHsmClusterId.Equals(data2.CloudHsmClusterId) && data1.XksProxyUriEndpoint.Equals(data2.XksProxyUriEndpoint) && data1.XksProxyUriPath.Equals(data2.XksProxyUriPath) && data1.XksProxyVpcEndpointServiceName.Equals(data2.XksProxyVpcEndpointServiceName) && data1.XksProxyAuthenticationCredential.Equals(data2.XksProxyAuthenticationCredential) && data1.XksProxyConnectivity.Equals(data2.XksProxyConnectivity)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateCustomKeyStoreRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateCustomKeyStoreRequest)
	return ok && _this.Equals(typed)
}

func Type_UpdateCustomKeyStoreRequest_() _dafny.TypeDescriptor {
	return type_UpdateCustomKeyStoreRequest_{}
}

type type_UpdateCustomKeyStoreRequest_ struct {
}

func (_this type_UpdateCustomKeyStoreRequest_) Default() interface{} {
	return Companion_UpdateCustomKeyStoreRequest_.Default()
}

func (_this type_UpdateCustomKeyStoreRequest_) String() string {
	return "ComAmazonawsKmsTypes.UpdateCustomKeyStoreRequest"
}
func (_this UpdateCustomKeyStoreRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateCustomKeyStoreRequest{}

// End of datatype UpdateCustomKeyStoreRequest

// Definition of datatype UpdateCustomKeyStoreResponse
type UpdateCustomKeyStoreResponse struct {
	Data_UpdateCustomKeyStoreResponse_
}

func (_this UpdateCustomKeyStoreResponse) Get_() Data_UpdateCustomKeyStoreResponse_ {
	return _this.Data_UpdateCustomKeyStoreResponse_
}

type Data_UpdateCustomKeyStoreResponse_ interface {
	isUpdateCustomKeyStoreResponse()
}

type CompanionStruct_UpdateCustomKeyStoreResponse_ struct {
}

var Companion_UpdateCustomKeyStoreResponse_ = CompanionStruct_UpdateCustomKeyStoreResponse_{}

type UpdateCustomKeyStoreResponse_UpdateCustomKeyStoreResponse struct {
}

func (UpdateCustomKeyStoreResponse_UpdateCustomKeyStoreResponse) isUpdateCustomKeyStoreResponse() {}

func (CompanionStruct_UpdateCustomKeyStoreResponse_) Create_UpdateCustomKeyStoreResponse_() UpdateCustomKeyStoreResponse {
	return UpdateCustomKeyStoreResponse{UpdateCustomKeyStoreResponse_UpdateCustomKeyStoreResponse{}}
}

func (_this UpdateCustomKeyStoreResponse) Is_UpdateCustomKeyStoreResponse() bool {
	_, ok := _this.Get_().(UpdateCustomKeyStoreResponse_UpdateCustomKeyStoreResponse)
	return ok
}

func (CompanionStruct_UpdateCustomKeyStoreResponse_) Default() UpdateCustomKeyStoreResponse {
	return Companion_UpdateCustomKeyStoreResponse_.Create_UpdateCustomKeyStoreResponse_()
}

func (_ CompanionStruct_UpdateCustomKeyStoreResponse_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_UpdateCustomKeyStoreResponse_.Create_UpdateCustomKeyStoreResponse_(), true
		default:
			return UpdateCustomKeyStoreResponse{}, false
		}
	}
}

func (_this UpdateCustomKeyStoreResponse) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateCustomKeyStoreResponse_UpdateCustomKeyStoreResponse:
		{
			return "ComAmazonawsKmsTypes.UpdateCustomKeyStoreResponse.UpdateCustomKeyStoreResponse"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateCustomKeyStoreResponse) Equals(other UpdateCustomKeyStoreResponse) bool {
	switch _this.Get_().(type) {
	case UpdateCustomKeyStoreResponse_UpdateCustomKeyStoreResponse:
		{
			_, ok := other.Get_().(UpdateCustomKeyStoreResponse_UpdateCustomKeyStoreResponse)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateCustomKeyStoreResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateCustomKeyStoreResponse)
	return ok && _this.Equals(typed)
}

func Type_UpdateCustomKeyStoreResponse_() _dafny.TypeDescriptor {
	return type_UpdateCustomKeyStoreResponse_{}
}

type type_UpdateCustomKeyStoreResponse_ struct {
}

func (_this type_UpdateCustomKeyStoreResponse_) Default() interface{} {
	return Companion_UpdateCustomKeyStoreResponse_.Default()
}

func (_this type_UpdateCustomKeyStoreResponse_) String() string {
	return "ComAmazonawsKmsTypes.UpdateCustomKeyStoreResponse"
}
func (_this UpdateCustomKeyStoreResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateCustomKeyStoreResponse{}

// End of datatype UpdateCustomKeyStoreResponse

// Definition of datatype UpdateKeyDescriptionRequest
type UpdateKeyDescriptionRequest struct {
	Data_UpdateKeyDescriptionRequest_
}

func (_this UpdateKeyDescriptionRequest) Get_() Data_UpdateKeyDescriptionRequest_ {
	return _this.Data_UpdateKeyDescriptionRequest_
}

type Data_UpdateKeyDescriptionRequest_ interface {
	isUpdateKeyDescriptionRequest()
}

type CompanionStruct_UpdateKeyDescriptionRequest_ struct {
}

var Companion_UpdateKeyDescriptionRequest_ = CompanionStruct_UpdateKeyDescriptionRequest_{}

type UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest struct {
	KeyId       _dafny.Sequence
	Description _dafny.Sequence
}

func (UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest) isUpdateKeyDescriptionRequest() {}

func (CompanionStruct_UpdateKeyDescriptionRequest_) Create_UpdateKeyDescriptionRequest_(KeyId _dafny.Sequence, Description _dafny.Sequence) UpdateKeyDescriptionRequest {
	return UpdateKeyDescriptionRequest{UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest{KeyId, Description}}
}

func (_this UpdateKeyDescriptionRequest) Is_UpdateKeyDescriptionRequest() bool {
	_, ok := _this.Get_().(UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest)
	return ok
}

func (CompanionStruct_UpdateKeyDescriptionRequest_) Default() UpdateKeyDescriptionRequest {
	return Companion_UpdateKeyDescriptionRequest_.Create_UpdateKeyDescriptionRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this UpdateKeyDescriptionRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest).KeyId
}

func (_this UpdateKeyDescriptionRequest) Dtor_Description() _dafny.Sequence {
	return _this.Get_().(UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest).Description
}

func (_this UpdateKeyDescriptionRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest:
		{
			return "ComAmazonawsKmsTypes.UpdateKeyDescriptionRequest.UpdateKeyDescriptionRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Description) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdateKeyDescriptionRequest) Equals(other UpdateKeyDescriptionRequest) bool {
	switch data1 := _this.Get_().(type) {
	case UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest:
		{
			data2, ok := other.Get_().(UpdateKeyDescriptionRequest_UpdateKeyDescriptionRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Description.Equals(data2.Description)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdateKeyDescriptionRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdateKeyDescriptionRequest)
	return ok && _this.Equals(typed)
}

func Type_UpdateKeyDescriptionRequest_() _dafny.TypeDescriptor {
	return type_UpdateKeyDescriptionRequest_{}
}

type type_UpdateKeyDescriptionRequest_ struct {
}

func (_this type_UpdateKeyDescriptionRequest_) Default() interface{} {
	return Companion_UpdateKeyDescriptionRequest_.Default()
}

func (_this type_UpdateKeyDescriptionRequest_) String() string {
	return "ComAmazonawsKmsTypes.UpdateKeyDescriptionRequest"
}
func (_this UpdateKeyDescriptionRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdateKeyDescriptionRequest{}

// End of datatype UpdateKeyDescriptionRequest

// Definition of datatype UpdatePrimaryRegionRequest
type UpdatePrimaryRegionRequest struct {
	Data_UpdatePrimaryRegionRequest_
}

func (_this UpdatePrimaryRegionRequest) Get_() Data_UpdatePrimaryRegionRequest_ {
	return _this.Data_UpdatePrimaryRegionRequest_
}

type Data_UpdatePrimaryRegionRequest_ interface {
	isUpdatePrimaryRegionRequest()
}

type CompanionStruct_UpdatePrimaryRegionRequest_ struct {
}

var Companion_UpdatePrimaryRegionRequest_ = CompanionStruct_UpdatePrimaryRegionRequest_{}

type UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest struct {
	KeyId         _dafny.Sequence
	PrimaryRegion _dafny.Sequence
}

func (UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest) isUpdatePrimaryRegionRequest() {}

func (CompanionStruct_UpdatePrimaryRegionRequest_) Create_UpdatePrimaryRegionRequest_(KeyId _dafny.Sequence, PrimaryRegion _dafny.Sequence) UpdatePrimaryRegionRequest {
	return UpdatePrimaryRegionRequest{UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest{KeyId, PrimaryRegion}}
}

func (_this UpdatePrimaryRegionRequest) Is_UpdatePrimaryRegionRequest() bool {
	_, ok := _this.Get_().(UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest)
	return ok
}

func (CompanionStruct_UpdatePrimaryRegionRequest_) Default() UpdatePrimaryRegionRequest {
	return Companion_UpdatePrimaryRegionRequest_.Create_UpdatePrimaryRegionRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this UpdatePrimaryRegionRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest).KeyId
}

func (_this UpdatePrimaryRegionRequest) Dtor_PrimaryRegion() _dafny.Sequence {
	return _this.Get_().(UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest).PrimaryRegion
}

func (_this UpdatePrimaryRegionRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest:
		{
			return "ComAmazonawsKmsTypes.UpdatePrimaryRegionRequest.UpdatePrimaryRegionRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.PrimaryRegion) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this UpdatePrimaryRegionRequest) Equals(other UpdatePrimaryRegionRequest) bool {
	switch data1 := _this.Get_().(type) {
	case UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest:
		{
			data2, ok := other.Get_().(UpdatePrimaryRegionRequest_UpdatePrimaryRegionRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.PrimaryRegion.Equals(data2.PrimaryRegion)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this UpdatePrimaryRegionRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(UpdatePrimaryRegionRequest)
	return ok && _this.Equals(typed)
}

func Type_UpdatePrimaryRegionRequest_() _dafny.TypeDescriptor {
	return type_UpdatePrimaryRegionRequest_{}
}

type type_UpdatePrimaryRegionRequest_ struct {
}

func (_this type_UpdatePrimaryRegionRequest_) Default() interface{} {
	return Companion_UpdatePrimaryRegionRequest_.Default()
}

func (_this type_UpdatePrimaryRegionRequest_) String() string {
	return "ComAmazonawsKmsTypes.UpdatePrimaryRegionRequest"
}
func (_this UpdatePrimaryRegionRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = UpdatePrimaryRegionRequest{}

// End of datatype UpdatePrimaryRegionRequest

// Definition of datatype VerifyMacRequest
type VerifyMacRequest struct {
	Data_VerifyMacRequest_
}

func (_this VerifyMacRequest) Get_() Data_VerifyMacRequest_ {
	return _this.Data_VerifyMacRequest_
}

type Data_VerifyMacRequest_ interface {
	isVerifyMacRequest()
}

type CompanionStruct_VerifyMacRequest_ struct {
}

var Companion_VerifyMacRequest_ = CompanionStruct_VerifyMacRequest_{}

type VerifyMacRequest_VerifyMacRequest struct {
	Message      _dafny.Sequence
	KeyId        _dafny.Sequence
	MacAlgorithm MacAlgorithmSpec
	Mac          _dafny.Sequence
	GrantTokens  m_Wrappers.Option
	DryRun       m_Wrappers.Option
}

func (VerifyMacRequest_VerifyMacRequest) isVerifyMacRequest() {}

func (CompanionStruct_VerifyMacRequest_) Create_VerifyMacRequest_(Message _dafny.Sequence, KeyId _dafny.Sequence, MacAlgorithm MacAlgorithmSpec, Mac _dafny.Sequence, GrantTokens m_Wrappers.Option, DryRun m_Wrappers.Option) VerifyMacRequest {
	return VerifyMacRequest{VerifyMacRequest_VerifyMacRequest{Message, KeyId, MacAlgorithm, Mac, GrantTokens, DryRun}}
}

func (_this VerifyMacRequest) Is_VerifyMacRequest() bool {
	_, ok := _this.Get_().(VerifyMacRequest_VerifyMacRequest)
	return ok
}

func (CompanionStruct_VerifyMacRequest_) Default() VerifyMacRequest {
	return Companion_VerifyMacRequest_.Create_VerifyMacRequest_(_dafny.EmptySeq, _dafny.EmptySeq.SetString(), Companion_MacAlgorithmSpec_.Default(), _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this VerifyMacRequest) Dtor_Message() _dafny.Sequence {
	return _this.Get_().(VerifyMacRequest_VerifyMacRequest).Message
}

func (_this VerifyMacRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(VerifyMacRequest_VerifyMacRequest).KeyId
}

func (_this VerifyMacRequest) Dtor_MacAlgorithm() MacAlgorithmSpec {
	return _this.Get_().(VerifyMacRequest_VerifyMacRequest).MacAlgorithm
}

func (_this VerifyMacRequest) Dtor_Mac() _dafny.Sequence {
	return _this.Get_().(VerifyMacRequest_VerifyMacRequest).Mac
}

func (_this VerifyMacRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(VerifyMacRequest_VerifyMacRequest).GrantTokens
}

func (_this VerifyMacRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(VerifyMacRequest_VerifyMacRequest).DryRun
}

func (_this VerifyMacRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VerifyMacRequest_VerifyMacRequest:
		{
			return "ComAmazonawsKmsTypes.VerifyMacRequest.VerifyMacRequest" + "(" + _dafny.String(data.Message) + ", " + _dafny.String(data.KeyId) + ", " + _dafny.String(data.MacAlgorithm) + ", " + _dafny.String(data.Mac) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VerifyMacRequest) Equals(other VerifyMacRequest) bool {
	switch data1 := _this.Get_().(type) {
	case VerifyMacRequest_VerifyMacRequest:
		{
			data2, ok := other.Get_().(VerifyMacRequest_VerifyMacRequest)
			return ok && data1.Message.Equals(data2.Message) && data1.KeyId.Equals(data2.KeyId) && data1.MacAlgorithm.Equals(data2.MacAlgorithm) && data1.Mac.Equals(data2.Mac) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VerifyMacRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VerifyMacRequest)
	return ok && _this.Equals(typed)
}

func Type_VerifyMacRequest_() _dafny.TypeDescriptor {
	return type_VerifyMacRequest_{}
}

type type_VerifyMacRequest_ struct {
}

func (_this type_VerifyMacRequest_) Default() interface{} {
	return Companion_VerifyMacRequest_.Default()
}

func (_this type_VerifyMacRequest_) String() string {
	return "ComAmazonawsKmsTypes.VerifyMacRequest"
}
func (_this VerifyMacRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VerifyMacRequest{}

// End of datatype VerifyMacRequest

// Definition of datatype VerifyMacResponse
type VerifyMacResponse struct {
	Data_VerifyMacResponse_
}

func (_this VerifyMacResponse) Get_() Data_VerifyMacResponse_ {
	return _this.Data_VerifyMacResponse_
}

type Data_VerifyMacResponse_ interface {
	isVerifyMacResponse()
}

type CompanionStruct_VerifyMacResponse_ struct {
}

var Companion_VerifyMacResponse_ = CompanionStruct_VerifyMacResponse_{}

type VerifyMacResponse_VerifyMacResponse struct {
	KeyId        m_Wrappers.Option
	MacValid     m_Wrappers.Option
	MacAlgorithm m_Wrappers.Option
}

func (VerifyMacResponse_VerifyMacResponse) isVerifyMacResponse() {}

func (CompanionStruct_VerifyMacResponse_) Create_VerifyMacResponse_(KeyId m_Wrappers.Option, MacValid m_Wrappers.Option, MacAlgorithm m_Wrappers.Option) VerifyMacResponse {
	return VerifyMacResponse{VerifyMacResponse_VerifyMacResponse{KeyId, MacValid, MacAlgorithm}}
}

func (_this VerifyMacResponse) Is_VerifyMacResponse() bool {
	_, ok := _this.Get_().(VerifyMacResponse_VerifyMacResponse)
	return ok
}

func (CompanionStruct_VerifyMacResponse_) Default() VerifyMacResponse {
	return Companion_VerifyMacResponse_.Create_VerifyMacResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this VerifyMacResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(VerifyMacResponse_VerifyMacResponse).KeyId
}

func (_this VerifyMacResponse) Dtor_MacValid() m_Wrappers.Option {
	return _this.Get_().(VerifyMacResponse_VerifyMacResponse).MacValid
}

func (_this VerifyMacResponse) Dtor_MacAlgorithm() m_Wrappers.Option {
	return _this.Get_().(VerifyMacResponse_VerifyMacResponse).MacAlgorithm
}

func (_this VerifyMacResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VerifyMacResponse_VerifyMacResponse:
		{
			return "ComAmazonawsKmsTypes.VerifyMacResponse.VerifyMacResponse" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.MacValid) + ", " + _dafny.String(data.MacAlgorithm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VerifyMacResponse) Equals(other VerifyMacResponse) bool {
	switch data1 := _this.Get_().(type) {
	case VerifyMacResponse_VerifyMacResponse:
		{
			data2, ok := other.Get_().(VerifyMacResponse_VerifyMacResponse)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.MacValid.Equals(data2.MacValid) && data1.MacAlgorithm.Equals(data2.MacAlgorithm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VerifyMacResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VerifyMacResponse)
	return ok && _this.Equals(typed)
}

func Type_VerifyMacResponse_() _dafny.TypeDescriptor {
	return type_VerifyMacResponse_{}
}

type type_VerifyMacResponse_ struct {
}

func (_this type_VerifyMacResponse_) Default() interface{} {
	return Companion_VerifyMacResponse_.Default()
}

func (_this type_VerifyMacResponse_) String() string {
	return "ComAmazonawsKmsTypes.VerifyMacResponse"
}
func (_this VerifyMacResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VerifyMacResponse{}

// End of datatype VerifyMacResponse

// Definition of datatype VerifyRequest
type VerifyRequest struct {
	Data_VerifyRequest_
}

func (_this VerifyRequest) Get_() Data_VerifyRequest_ {
	return _this.Data_VerifyRequest_
}

type Data_VerifyRequest_ interface {
	isVerifyRequest()
}

type CompanionStruct_VerifyRequest_ struct {
}

var Companion_VerifyRequest_ = CompanionStruct_VerifyRequest_{}

type VerifyRequest_VerifyRequest struct {
	KeyId            _dafny.Sequence
	Message          _dafny.Sequence
	MessageType      m_Wrappers.Option
	Signature        _dafny.Sequence
	SigningAlgorithm SigningAlgorithmSpec
	GrantTokens      m_Wrappers.Option
	DryRun           m_Wrappers.Option
}

func (VerifyRequest_VerifyRequest) isVerifyRequest() {}

func (CompanionStruct_VerifyRequest_) Create_VerifyRequest_(KeyId _dafny.Sequence, Message _dafny.Sequence, MessageType m_Wrappers.Option, Signature _dafny.Sequence, SigningAlgorithm SigningAlgorithmSpec, GrantTokens m_Wrappers.Option, DryRun m_Wrappers.Option) VerifyRequest {
	return VerifyRequest{VerifyRequest_VerifyRequest{KeyId, Message, MessageType, Signature, SigningAlgorithm, GrantTokens, DryRun}}
}

func (_this VerifyRequest) Is_VerifyRequest() bool {
	_, ok := _this.Get_().(VerifyRequest_VerifyRequest)
	return ok
}

func (CompanionStruct_VerifyRequest_) Default() VerifyRequest {
	return Companion_VerifyRequest_.Create_VerifyRequest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq, Companion_SigningAlgorithmSpec_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this VerifyRequest) Dtor_KeyId() _dafny.Sequence {
	return _this.Get_().(VerifyRequest_VerifyRequest).KeyId
}

func (_this VerifyRequest) Dtor_Message() _dafny.Sequence {
	return _this.Get_().(VerifyRequest_VerifyRequest).Message
}

func (_this VerifyRequest) Dtor_MessageType() m_Wrappers.Option {
	return _this.Get_().(VerifyRequest_VerifyRequest).MessageType
}

func (_this VerifyRequest) Dtor_Signature() _dafny.Sequence {
	return _this.Get_().(VerifyRequest_VerifyRequest).Signature
}

func (_this VerifyRequest) Dtor_SigningAlgorithm() SigningAlgorithmSpec {
	return _this.Get_().(VerifyRequest_VerifyRequest).SigningAlgorithm
}

func (_this VerifyRequest) Dtor_GrantTokens() m_Wrappers.Option {
	return _this.Get_().(VerifyRequest_VerifyRequest).GrantTokens
}

func (_this VerifyRequest) Dtor_DryRun() m_Wrappers.Option {
	return _this.Get_().(VerifyRequest_VerifyRequest).DryRun
}

func (_this VerifyRequest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VerifyRequest_VerifyRequest:
		{
			return "ComAmazonawsKmsTypes.VerifyRequest.VerifyRequest" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.Message) + ", " + _dafny.String(data.MessageType) + ", " + _dafny.String(data.Signature) + ", " + _dafny.String(data.SigningAlgorithm) + ", " + _dafny.String(data.GrantTokens) + ", " + _dafny.String(data.DryRun) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VerifyRequest) Equals(other VerifyRequest) bool {
	switch data1 := _this.Get_().(type) {
	case VerifyRequest_VerifyRequest:
		{
			data2, ok := other.Get_().(VerifyRequest_VerifyRequest)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.Message.Equals(data2.Message) && data1.MessageType.Equals(data2.MessageType) && data1.Signature.Equals(data2.Signature) && data1.SigningAlgorithm.Equals(data2.SigningAlgorithm) && data1.GrantTokens.Equals(data2.GrantTokens) && data1.DryRun.Equals(data2.DryRun)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VerifyRequest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VerifyRequest)
	return ok && _this.Equals(typed)
}

func Type_VerifyRequest_() _dafny.TypeDescriptor {
	return type_VerifyRequest_{}
}

type type_VerifyRequest_ struct {
}

func (_this type_VerifyRequest_) Default() interface{} {
	return Companion_VerifyRequest_.Default()
}

func (_this type_VerifyRequest_) String() string {
	return "ComAmazonawsKmsTypes.VerifyRequest"
}
func (_this VerifyRequest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VerifyRequest{}

// End of datatype VerifyRequest

// Definition of datatype VerifyResponse
type VerifyResponse struct {
	Data_VerifyResponse_
}

func (_this VerifyResponse) Get_() Data_VerifyResponse_ {
	return _this.Data_VerifyResponse_
}

type Data_VerifyResponse_ interface {
	isVerifyResponse()
}

type CompanionStruct_VerifyResponse_ struct {
}

var Companion_VerifyResponse_ = CompanionStruct_VerifyResponse_{}

type VerifyResponse_VerifyResponse struct {
	KeyId            m_Wrappers.Option
	SignatureValid   m_Wrappers.Option
	SigningAlgorithm m_Wrappers.Option
}

func (VerifyResponse_VerifyResponse) isVerifyResponse() {}

func (CompanionStruct_VerifyResponse_) Create_VerifyResponse_(KeyId m_Wrappers.Option, SignatureValid m_Wrappers.Option, SigningAlgorithm m_Wrappers.Option) VerifyResponse {
	return VerifyResponse{VerifyResponse_VerifyResponse{KeyId, SignatureValid, SigningAlgorithm}}
}

func (_this VerifyResponse) Is_VerifyResponse() bool {
	_, ok := _this.Get_().(VerifyResponse_VerifyResponse)
	return ok
}

func (CompanionStruct_VerifyResponse_) Default() VerifyResponse {
	return Companion_VerifyResponse_.Create_VerifyResponse_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this VerifyResponse) Dtor_KeyId() m_Wrappers.Option {
	return _this.Get_().(VerifyResponse_VerifyResponse).KeyId
}

func (_this VerifyResponse) Dtor_SignatureValid() m_Wrappers.Option {
	return _this.Get_().(VerifyResponse_VerifyResponse).SignatureValid
}

func (_this VerifyResponse) Dtor_SigningAlgorithm() m_Wrappers.Option {
	return _this.Get_().(VerifyResponse_VerifyResponse).SigningAlgorithm
}

func (_this VerifyResponse) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case VerifyResponse_VerifyResponse:
		{
			return "ComAmazonawsKmsTypes.VerifyResponse.VerifyResponse" + "(" + _dafny.String(data.KeyId) + ", " + _dafny.String(data.SignatureValid) + ", " + _dafny.String(data.SigningAlgorithm) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this VerifyResponse) Equals(other VerifyResponse) bool {
	switch data1 := _this.Get_().(type) {
	case VerifyResponse_VerifyResponse:
		{
			data2, ok := other.Get_().(VerifyResponse_VerifyResponse)
			return ok && data1.KeyId.Equals(data2.KeyId) && data1.SignatureValid.Equals(data2.SignatureValid) && data1.SigningAlgorithm.Equals(data2.SigningAlgorithm)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this VerifyResponse) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(VerifyResponse)
	return ok && _this.Equals(typed)
}

func Type_VerifyResponse_() _dafny.TypeDescriptor {
	return type_VerifyResponse_{}
}

type type_VerifyResponse_ struct {
}

func (_this type_VerifyResponse_) Default() interface{} {
	return Companion_VerifyResponse_.Default()
}

func (_this type_VerifyResponse_) String() string {
	return "ComAmazonawsKmsTypes.VerifyResponse"
}
func (_this VerifyResponse) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = VerifyResponse{}

// End of datatype VerifyResponse

// Definition of datatype WrappingKeySpec
type WrappingKeySpec struct {
	Data_WrappingKeySpec_
}

func (_this WrappingKeySpec) Get_() Data_WrappingKeySpec_ {
	return _this.Data_WrappingKeySpec_
}

type Data_WrappingKeySpec_ interface {
	isWrappingKeySpec()
}

type CompanionStruct_WrappingKeySpec_ struct {
}

var Companion_WrappingKeySpec_ = CompanionStruct_WrappingKeySpec_{}

type WrappingKeySpec_RSA__2048 struct {
}

func (WrappingKeySpec_RSA__2048) isWrappingKeySpec() {}

func (CompanionStruct_WrappingKeySpec_) Create_RSA__2048_() WrappingKeySpec {
	return WrappingKeySpec{WrappingKeySpec_RSA__2048{}}
}

func (_this WrappingKeySpec) Is_RSA__2048() bool {
	_, ok := _this.Get_().(WrappingKeySpec_RSA__2048)
	return ok
}

type WrappingKeySpec_RSA__3072 struct {
}

func (WrappingKeySpec_RSA__3072) isWrappingKeySpec() {}

func (CompanionStruct_WrappingKeySpec_) Create_RSA__3072_() WrappingKeySpec {
	return WrappingKeySpec{WrappingKeySpec_RSA__3072{}}
}

func (_this WrappingKeySpec) Is_RSA__3072() bool {
	_, ok := _this.Get_().(WrappingKeySpec_RSA__3072)
	return ok
}

type WrappingKeySpec_RSA__4096 struct {
}

func (WrappingKeySpec_RSA__4096) isWrappingKeySpec() {}

func (CompanionStruct_WrappingKeySpec_) Create_RSA__4096_() WrappingKeySpec {
	return WrappingKeySpec{WrappingKeySpec_RSA__4096{}}
}

func (_this WrappingKeySpec) Is_RSA__4096() bool {
	_, ok := _this.Get_().(WrappingKeySpec_RSA__4096)
	return ok
}

type WrappingKeySpec_SM2 struct {
}

func (WrappingKeySpec_SM2) isWrappingKeySpec() {}

func (CompanionStruct_WrappingKeySpec_) Create_SM2_() WrappingKeySpec {
	return WrappingKeySpec{WrappingKeySpec_SM2{}}
}

func (_this WrappingKeySpec) Is_SM2() bool {
	_, ok := _this.Get_().(WrappingKeySpec_SM2)
	return ok
}

func (CompanionStruct_WrappingKeySpec_) Default() WrappingKeySpec {
	return Companion_WrappingKeySpec_.Create_RSA__2048_()
}

func (_ CompanionStruct_WrappingKeySpec_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_WrappingKeySpec_.Create_RSA__2048_(), true
		case 1:
			return Companion_WrappingKeySpec_.Create_RSA__3072_(), true
		case 2:
			return Companion_WrappingKeySpec_.Create_RSA__4096_(), true
		case 3:
			return Companion_WrappingKeySpec_.Create_SM2_(), true
		default:
			return WrappingKeySpec{}, false
		}
	}
}

func (_this WrappingKeySpec) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case WrappingKeySpec_RSA__2048:
		{
			return "ComAmazonawsKmsTypes.WrappingKeySpec.RSA_2048"
		}
	case WrappingKeySpec_RSA__3072:
		{
			return "ComAmazonawsKmsTypes.WrappingKeySpec.RSA_3072"
		}
	case WrappingKeySpec_RSA__4096:
		{
			return "ComAmazonawsKmsTypes.WrappingKeySpec.RSA_4096"
		}
	case WrappingKeySpec_SM2:
		{
			return "ComAmazonawsKmsTypes.WrappingKeySpec.SM2"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this WrappingKeySpec) Equals(other WrappingKeySpec) bool {
	switch _this.Get_().(type) {
	case WrappingKeySpec_RSA__2048:
		{
			_, ok := other.Get_().(WrappingKeySpec_RSA__2048)
			return ok
		}
	case WrappingKeySpec_RSA__3072:
		{
			_, ok := other.Get_().(WrappingKeySpec_RSA__3072)
			return ok
		}
	case WrappingKeySpec_RSA__4096:
		{
			_, ok := other.Get_().(WrappingKeySpec_RSA__4096)
			return ok
		}
	case WrappingKeySpec_SM2:
		{
			_, ok := other.Get_().(WrappingKeySpec_SM2)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this WrappingKeySpec) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(WrappingKeySpec)
	return ok && _this.Equals(typed)
}

func Type_WrappingKeySpec_() _dafny.TypeDescriptor {
	return type_WrappingKeySpec_{}
}

type type_WrappingKeySpec_ struct {
}

func (_this type_WrappingKeySpec_) Default() interface{} {
	return Companion_WrappingKeySpec_.Default()
}

func (_this type_WrappingKeySpec_) String() string {
	return "ComAmazonawsKmsTypes.WrappingKeySpec"
}
func (_this WrappingKeySpec) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = WrappingKeySpec{}

// End of datatype WrappingKeySpec

// Definition of datatype XksKeyConfigurationType
type XksKeyConfigurationType struct {
	Data_XksKeyConfigurationType_
}

func (_this XksKeyConfigurationType) Get_() Data_XksKeyConfigurationType_ {
	return _this.Data_XksKeyConfigurationType_
}

type Data_XksKeyConfigurationType_ interface {
	isXksKeyConfigurationType()
}

type CompanionStruct_XksKeyConfigurationType_ struct {
}

var Companion_XksKeyConfigurationType_ = CompanionStruct_XksKeyConfigurationType_{}

type XksKeyConfigurationType_XksKeyConfigurationType struct {
	Id m_Wrappers.Option
}

func (XksKeyConfigurationType_XksKeyConfigurationType) isXksKeyConfigurationType() {}

func (CompanionStruct_XksKeyConfigurationType_) Create_XksKeyConfigurationType_(Id m_Wrappers.Option) XksKeyConfigurationType {
	return XksKeyConfigurationType{XksKeyConfigurationType_XksKeyConfigurationType{Id}}
}

func (_this XksKeyConfigurationType) Is_XksKeyConfigurationType() bool {
	_, ok := _this.Get_().(XksKeyConfigurationType_XksKeyConfigurationType)
	return ok
}

func (CompanionStruct_XksKeyConfigurationType_) Default() XksKeyConfigurationType {
	return Companion_XksKeyConfigurationType_.Create_XksKeyConfigurationType_(m_Wrappers.Companion_Option_.Default())
}

func (_this XksKeyConfigurationType) Dtor_Id() m_Wrappers.Option {
	return _this.Get_().(XksKeyConfigurationType_XksKeyConfigurationType).Id
}

func (_this XksKeyConfigurationType) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case XksKeyConfigurationType_XksKeyConfigurationType:
		{
			return "ComAmazonawsKmsTypes.XksKeyConfigurationType.XksKeyConfigurationType" + "(" + _dafny.String(data.Id) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this XksKeyConfigurationType) Equals(other XksKeyConfigurationType) bool {
	switch data1 := _this.Get_().(type) {
	case XksKeyConfigurationType_XksKeyConfigurationType:
		{
			data2, ok := other.Get_().(XksKeyConfigurationType_XksKeyConfigurationType)
			return ok && data1.Id.Equals(data2.Id)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this XksKeyConfigurationType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(XksKeyConfigurationType)
	return ok && _this.Equals(typed)
}

func Type_XksKeyConfigurationType_() _dafny.TypeDescriptor {
	return type_XksKeyConfigurationType_{}
}

type type_XksKeyConfigurationType_ struct {
}

func (_this type_XksKeyConfigurationType_) Default() interface{} {
	return Companion_XksKeyConfigurationType_.Default()
}

func (_this type_XksKeyConfigurationType_) String() string {
	return "ComAmazonawsKmsTypes.XksKeyConfigurationType"
}
func (_this XksKeyConfigurationType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = XksKeyConfigurationType{}

// End of datatype XksKeyConfigurationType

// Definition of class XksKeyIdType
type XksKeyIdType struct {
}

func New_XksKeyIdType_() *XksKeyIdType {
	_this := XksKeyIdType{}

	return &_this
}

type CompanionStruct_XksKeyIdType_ struct {
}

var Companion_XksKeyIdType_ = CompanionStruct_XksKeyIdType_{}

func (*XksKeyIdType) String() string {
	return "ComAmazonawsKmsTypes.XksKeyIdType"
}

// End of class XksKeyIdType

func Type_XksKeyIdType_() _dafny.TypeDescriptor {
	return type_XksKeyIdType_{}
}

type type_XksKeyIdType_ struct {
}

func (_this type_XksKeyIdType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_XksKeyIdType_) String() string {
	return "ComAmazonawsKmsTypes.XksKeyIdType"
}
func (_this *CompanionStruct_XksKeyIdType_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return Companion_Default___.IsValid__XksKeyIdType(_1_x)
}

// Definition of class XksProxyAuthenticationAccessKeyIdType
type XksProxyAuthenticationAccessKeyIdType struct {
}

func New_XksProxyAuthenticationAccessKeyIdType_() *XksProxyAuthenticationAccessKeyIdType {
	_this := XksProxyAuthenticationAccessKeyIdType{}

	return &_this
}

type CompanionStruct_XksProxyAuthenticationAccessKeyIdType_ struct {
}

var Companion_XksProxyAuthenticationAccessKeyIdType_ = CompanionStruct_XksProxyAuthenticationAccessKeyIdType_{}

func (*XksProxyAuthenticationAccessKeyIdType) String() string {
	return "ComAmazonawsKmsTypes.XksProxyAuthenticationAccessKeyIdType"
}

// End of class XksProxyAuthenticationAccessKeyIdType

func Type_XksProxyAuthenticationAccessKeyIdType_() _dafny.TypeDescriptor {
	return type_XksProxyAuthenticationAccessKeyIdType_{}
}

type type_XksProxyAuthenticationAccessKeyIdType_ struct {
}

func (_this type_XksProxyAuthenticationAccessKeyIdType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_XksProxyAuthenticationAccessKeyIdType_) String() string {
	return "ComAmazonawsKmsTypes.XksProxyAuthenticationAccessKeyIdType"
}
func (_this *CompanionStruct_XksProxyAuthenticationAccessKeyIdType_) Is_(__source _dafny.Sequence) bool {
	var _2_x _dafny.Sequence = (__source)
	_ = _2_x
	return Companion_Default___.IsValid__XksProxyAuthenticationAccessKeyIdType(_2_x)
}

// Definition of datatype XksProxyAuthenticationCredentialType
type XksProxyAuthenticationCredentialType struct {
	Data_XksProxyAuthenticationCredentialType_
}

func (_this XksProxyAuthenticationCredentialType) Get_() Data_XksProxyAuthenticationCredentialType_ {
	return _this.Data_XksProxyAuthenticationCredentialType_
}

type Data_XksProxyAuthenticationCredentialType_ interface {
	isXksProxyAuthenticationCredentialType()
}

type CompanionStruct_XksProxyAuthenticationCredentialType_ struct {
}

var Companion_XksProxyAuthenticationCredentialType_ = CompanionStruct_XksProxyAuthenticationCredentialType_{}

type XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType struct {
	AccessKeyId        _dafny.Sequence
	RawSecretAccessKey _dafny.Sequence
}

func (XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType) isXksProxyAuthenticationCredentialType() {
}

func (CompanionStruct_XksProxyAuthenticationCredentialType_) Create_XksProxyAuthenticationCredentialType_(AccessKeyId _dafny.Sequence, RawSecretAccessKey _dafny.Sequence) XksProxyAuthenticationCredentialType {
	return XksProxyAuthenticationCredentialType{XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType{AccessKeyId, RawSecretAccessKey}}
}

func (_this XksProxyAuthenticationCredentialType) Is_XksProxyAuthenticationCredentialType() bool {
	_, ok := _this.Get_().(XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType)
	return ok
}

func (CompanionStruct_XksProxyAuthenticationCredentialType_) Default() XksProxyAuthenticationCredentialType {
	return Companion_XksProxyAuthenticationCredentialType_.Create_XksProxyAuthenticationCredentialType_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString())
}

func (_this XksProxyAuthenticationCredentialType) Dtor_AccessKeyId() _dafny.Sequence {
	return _this.Get_().(XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType).AccessKeyId
}

func (_this XksProxyAuthenticationCredentialType) Dtor_RawSecretAccessKey() _dafny.Sequence {
	return _this.Get_().(XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType).RawSecretAccessKey
}

func (_this XksProxyAuthenticationCredentialType) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType:
		{
			return "ComAmazonawsKmsTypes.XksProxyAuthenticationCredentialType.XksProxyAuthenticationCredentialType" + "(" + _dafny.String(data.AccessKeyId) + ", " + _dafny.String(data.RawSecretAccessKey) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this XksProxyAuthenticationCredentialType) Equals(other XksProxyAuthenticationCredentialType) bool {
	switch data1 := _this.Get_().(type) {
	case XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType:
		{
			data2, ok := other.Get_().(XksProxyAuthenticationCredentialType_XksProxyAuthenticationCredentialType)
			return ok && data1.AccessKeyId.Equals(data2.AccessKeyId) && data1.RawSecretAccessKey.Equals(data2.RawSecretAccessKey)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this XksProxyAuthenticationCredentialType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(XksProxyAuthenticationCredentialType)
	return ok && _this.Equals(typed)
}

func Type_XksProxyAuthenticationCredentialType_() _dafny.TypeDescriptor {
	return type_XksProxyAuthenticationCredentialType_{}
}

type type_XksProxyAuthenticationCredentialType_ struct {
}

func (_this type_XksProxyAuthenticationCredentialType_) Default() interface{} {
	return Companion_XksProxyAuthenticationCredentialType_.Default()
}

func (_this type_XksProxyAuthenticationCredentialType_) String() string {
	return "ComAmazonawsKmsTypes.XksProxyAuthenticationCredentialType"
}
func (_this XksProxyAuthenticationCredentialType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = XksProxyAuthenticationCredentialType{}

// End of datatype XksProxyAuthenticationCredentialType

// Definition of class XksProxyAuthenticationRawSecretAccessKeyType
type XksProxyAuthenticationRawSecretAccessKeyType struct {
}

func New_XksProxyAuthenticationRawSecretAccessKeyType_() *XksProxyAuthenticationRawSecretAccessKeyType {
	_this := XksProxyAuthenticationRawSecretAccessKeyType{}

	return &_this
}

type CompanionStruct_XksProxyAuthenticationRawSecretAccessKeyType_ struct {
}

var Companion_XksProxyAuthenticationRawSecretAccessKeyType_ = CompanionStruct_XksProxyAuthenticationRawSecretAccessKeyType_{}

func (*XksProxyAuthenticationRawSecretAccessKeyType) String() string {
	return "ComAmazonawsKmsTypes.XksProxyAuthenticationRawSecretAccessKeyType"
}

// End of class XksProxyAuthenticationRawSecretAccessKeyType

func Type_XksProxyAuthenticationRawSecretAccessKeyType_() _dafny.TypeDescriptor {
	return type_XksProxyAuthenticationRawSecretAccessKeyType_{}
}

type type_XksProxyAuthenticationRawSecretAccessKeyType_ struct {
}

func (_this type_XksProxyAuthenticationRawSecretAccessKeyType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_XksProxyAuthenticationRawSecretAccessKeyType_) String() string {
	return "ComAmazonawsKmsTypes.XksProxyAuthenticationRawSecretAccessKeyType"
}
func (_this *CompanionStruct_XksProxyAuthenticationRawSecretAccessKeyType_) Is_(__source _dafny.Sequence) bool {
	var _3_x _dafny.Sequence = (__source)
	_ = _3_x
	return Companion_Default___.IsValid__XksProxyAuthenticationRawSecretAccessKeyType(_3_x)
}

// Definition of datatype XksProxyConfigurationType
type XksProxyConfigurationType struct {
	Data_XksProxyConfigurationType_
}

func (_this XksProxyConfigurationType) Get_() Data_XksProxyConfigurationType_ {
	return _this.Data_XksProxyConfigurationType_
}

type Data_XksProxyConfigurationType_ interface {
	isXksProxyConfigurationType()
}

type CompanionStruct_XksProxyConfigurationType_ struct {
}

var Companion_XksProxyConfigurationType_ = CompanionStruct_XksProxyConfigurationType_{}

type XksProxyConfigurationType_XksProxyConfigurationType struct {
	Connectivity           m_Wrappers.Option
	AccessKeyId            m_Wrappers.Option
	UriEndpoint            m_Wrappers.Option
	UriPath                m_Wrappers.Option
	VpcEndpointServiceName m_Wrappers.Option
}

func (XksProxyConfigurationType_XksProxyConfigurationType) isXksProxyConfigurationType() {}

func (CompanionStruct_XksProxyConfigurationType_) Create_XksProxyConfigurationType_(Connectivity m_Wrappers.Option, AccessKeyId m_Wrappers.Option, UriEndpoint m_Wrappers.Option, UriPath m_Wrappers.Option, VpcEndpointServiceName m_Wrappers.Option) XksProxyConfigurationType {
	return XksProxyConfigurationType{XksProxyConfigurationType_XksProxyConfigurationType{Connectivity, AccessKeyId, UriEndpoint, UriPath, VpcEndpointServiceName}}
}

func (_this XksProxyConfigurationType) Is_XksProxyConfigurationType() bool {
	_, ok := _this.Get_().(XksProxyConfigurationType_XksProxyConfigurationType)
	return ok
}

func (CompanionStruct_XksProxyConfigurationType_) Default() XksProxyConfigurationType {
	return Companion_XksProxyConfigurationType_.Create_XksProxyConfigurationType_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this XksProxyConfigurationType) Dtor_Connectivity() m_Wrappers.Option {
	return _this.Get_().(XksProxyConfigurationType_XksProxyConfigurationType).Connectivity
}

func (_this XksProxyConfigurationType) Dtor_AccessKeyId() m_Wrappers.Option {
	return _this.Get_().(XksProxyConfigurationType_XksProxyConfigurationType).AccessKeyId
}

func (_this XksProxyConfigurationType) Dtor_UriEndpoint() m_Wrappers.Option {
	return _this.Get_().(XksProxyConfigurationType_XksProxyConfigurationType).UriEndpoint
}

func (_this XksProxyConfigurationType) Dtor_UriPath() m_Wrappers.Option {
	return _this.Get_().(XksProxyConfigurationType_XksProxyConfigurationType).UriPath
}

func (_this XksProxyConfigurationType) Dtor_VpcEndpointServiceName() m_Wrappers.Option {
	return _this.Get_().(XksProxyConfigurationType_XksProxyConfigurationType).VpcEndpointServiceName
}

func (_this XksProxyConfigurationType) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case XksProxyConfigurationType_XksProxyConfigurationType:
		{
			return "ComAmazonawsKmsTypes.XksProxyConfigurationType.XksProxyConfigurationType" + "(" + _dafny.String(data.Connectivity) + ", " + _dafny.String(data.AccessKeyId) + ", " + _dafny.String(data.UriEndpoint) + ", " + _dafny.String(data.UriPath) + ", " + _dafny.String(data.VpcEndpointServiceName) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this XksProxyConfigurationType) Equals(other XksProxyConfigurationType) bool {
	switch data1 := _this.Get_().(type) {
	case XksProxyConfigurationType_XksProxyConfigurationType:
		{
			data2, ok := other.Get_().(XksProxyConfigurationType_XksProxyConfigurationType)
			return ok && data1.Connectivity.Equals(data2.Connectivity) && data1.AccessKeyId.Equals(data2.AccessKeyId) && data1.UriEndpoint.Equals(data2.UriEndpoint) && data1.UriPath.Equals(data2.UriPath) && data1.VpcEndpointServiceName.Equals(data2.VpcEndpointServiceName)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this XksProxyConfigurationType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(XksProxyConfigurationType)
	return ok && _this.Equals(typed)
}

func Type_XksProxyConfigurationType_() _dafny.TypeDescriptor {
	return type_XksProxyConfigurationType_{}
}

type type_XksProxyConfigurationType_ struct {
}

func (_this type_XksProxyConfigurationType_) Default() interface{} {
	return Companion_XksProxyConfigurationType_.Default()
}

func (_this type_XksProxyConfigurationType_) String() string {
	return "ComAmazonawsKmsTypes.XksProxyConfigurationType"
}
func (_this XksProxyConfigurationType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = XksProxyConfigurationType{}

// End of datatype XksProxyConfigurationType

// Definition of datatype XksProxyConnectivityType
type XksProxyConnectivityType struct {
	Data_XksProxyConnectivityType_
}

func (_this XksProxyConnectivityType) Get_() Data_XksProxyConnectivityType_ {
	return _this.Data_XksProxyConnectivityType_
}

type Data_XksProxyConnectivityType_ interface {
	isXksProxyConnectivityType()
}

type CompanionStruct_XksProxyConnectivityType_ struct {
}

var Companion_XksProxyConnectivityType_ = CompanionStruct_XksProxyConnectivityType_{}

type XksProxyConnectivityType_PUBLIC__ENDPOINT struct {
}

func (XksProxyConnectivityType_PUBLIC__ENDPOINT) isXksProxyConnectivityType() {}

func (CompanionStruct_XksProxyConnectivityType_) Create_PUBLIC__ENDPOINT_() XksProxyConnectivityType {
	return XksProxyConnectivityType{XksProxyConnectivityType_PUBLIC__ENDPOINT{}}
}

func (_this XksProxyConnectivityType) Is_PUBLIC__ENDPOINT() bool {
	_, ok := _this.Get_().(XksProxyConnectivityType_PUBLIC__ENDPOINT)
	return ok
}

type XksProxyConnectivityType_VPC__ENDPOINT__SERVICE struct {
}

func (XksProxyConnectivityType_VPC__ENDPOINT__SERVICE) isXksProxyConnectivityType() {}

func (CompanionStruct_XksProxyConnectivityType_) Create_VPC__ENDPOINT__SERVICE_() XksProxyConnectivityType {
	return XksProxyConnectivityType{XksProxyConnectivityType_VPC__ENDPOINT__SERVICE{}}
}

func (_this XksProxyConnectivityType) Is_VPC__ENDPOINT__SERVICE() bool {
	_, ok := _this.Get_().(XksProxyConnectivityType_VPC__ENDPOINT__SERVICE)
	return ok
}

func (CompanionStruct_XksProxyConnectivityType_) Default() XksProxyConnectivityType {
	return Companion_XksProxyConnectivityType_.Create_PUBLIC__ENDPOINT_()
}

func (_ CompanionStruct_XksProxyConnectivityType_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_XksProxyConnectivityType_.Create_PUBLIC__ENDPOINT_(), true
		case 1:
			return Companion_XksProxyConnectivityType_.Create_VPC__ENDPOINT__SERVICE_(), true
		default:
			return XksProxyConnectivityType{}, false
		}
	}
}

func (_this XksProxyConnectivityType) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case XksProxyConnectivityType_PUBLIC__ENDPOINT:
		{
			return "ComAmazonawsKmsTypes.XksProxyConnectivityType.PUBLIC_ENDPOINT"
		}
	case XksProxyConnectivityType_VPC__ENDPOINT__SERVICE:
		{
			return "ComAmazonawsKmsTypes.XksProxyConnectivityType.VPC_ENDPOINT_SERVICE"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this XksProxyConnectivityType) Equals(other XksProxyConnectivityType) bool {
	switch _this.Get_().(type) {
	case XksProxyConnectivityType_PUBLIC__ENDPOINT:
		{
			_, ok := other.Get_().(XksProxyConnectivityType_PUBLIC__ENDPOINT)
			return ok
		}
	case XksProxyConnectivityType_VPC__ENDPOINT__SERVICE:
		{
			_, ok := other.Get_().(XksProxyConnectivityType_VPC__ENDPOINT__SERVICE)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this XksProxyConnectivityType) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(XksProxyConnectivityType)
	return ok && _this.Equals(typed)
}

func Type_XksProxyConnectivityType_() _dafny.TypeDescriptor {
	return type_XksProxyConnectivityType_{}
}

type type_XksProxyConnectivityType_ struct {
}

func (_this type_XksProxyConnectivityType_) Default() interface{} {
	return Companion_XksProxyConnectivityType_.Default()
}

func (_this type_XksProxyConnectivityType_) String() string {
	return "ComAmazonawsKmsTypes.XksProxyConnectivityType"
}
func (_this XksProxyConnectivityType) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = XksProxyConnectivityType{}

// End of datatype XksProxyConnectivityType

// Definition of class XksProxyUriEndpointType
type XksProxyUriEndpointType struct {
}

func New_XksProxyUriEndpointType_() *XksProxyUriEndpointType {
	_this := XksProxyUriEndpointType{}

	return &_this
}

type CompanionStruct_XksProxyUriEndpointType_ struct {
}

var Companion_XksProxyUriEndpointType_ = CompanionStruct_XksProxyUriEndpointType_{}

func (*XksProxyUriEndpointType) String() string {
	return "ComAmazonawsKmsTypes.XksProxyUriEndpointType"
}

// End of class XksProxyUriEndpointType

func Type_XksProxyUriEndpointType_() _dafny.TypeDescriptor {
	return type_XksProxyUriEndpointType_{}
}

type type_XksProxyUriEndpointType_ struct {
}

func (_this type_XksProxyUriEndpointType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_XksProxyUriEndpointType_) String() string {
	return "ComAmazonawsKmsTypes.XksProxyUriEndpointType"
}
func (_this *CompanionStruct_XksProxyUriEndpointType_) Is_(__source _dafny.Sequence) bool {
	var _4_x _dafny.Sequence = (__source)
	_ = _4_x
	return Companion_Default___.IsValid__XksProxyUriEndpointType(_4_x)
}

// Definition of class XksProxyUriPathType
type XksProxyUriPathType struct {
}

func New_XksProxyUriPathType_() *XksProxyUriPathType {
	_this := XksProxyUriPathType{}

	return &_this
}

type CompanionStruct_XksProxyUriPathType_ struct {
}

var Companion_XksProxyUriPathType_ = CompanionStruct_XksProxyUriPathType_{}

func (*XksProxyUriPathType) String() string {
	return "ComAmazonawsKmsTypes.XksProxyUriPathType"
}

// End of class XksProxyUriPathType

func Type_XksProxyUriPathType_() _dafny.TypeDescriptor {
	return type_XksProxyUriPathType_{}
}

type type_XksProxyUriPathType_ struct {
}

func (_this type_XksProxyUriPathType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_XksProxyUriPathType_) String() string {
	return "ComAmazonawsKmsTypes.XksProxyUriPathType"
}
func (_this *CompanionStruct_XksProxyUriPathType_) Is_(__source _dafny.Sequence) bool {
	var _5_x _dafny.Sequence = (__source)
	_ = _5_x
	return Companion_Default___.IsValid__XksProxyUriPathType(_5_x)
}

// Definition of class XksProxyVpcEndpointServiceNameType
type XksProxyVpcEndpointServiceNameType struct {
}

func New_XksProxyVpcEndpointServiceNameType_() *XksProxyVpcEndpointServiceNameType {
	_this := XksProxyVpcEndpointServiceNameType{}

	return &_this
}

type CompanionStruct_XksProxyVpcEndpointServiceNameType_ struct {
}

var Companion_XksProxyVpcEndpointServiceNameType_ = CompanionStruct_XksProxyVpcEndpointServiceNameType_{}

func (*XksProxyVpcEndpointServiceNameType) String() string {
	return "ComAmazonawsKmsTypes.XksProxyVpcEndpointServiceNameType"
}

// End of class XksProxyVpcEndpointServiceNameType

func Type_XksProxyVpcEndpointServiceNameType_() _dafny.TypeDescriptor {
	return type_XksProxyVpcEndpointServiceNameType_{}
}

type type_XksProxyVpcEndpointServiceNameType_ struct {
}

func (_this type_XksProxyVpcEndpointServiceNameType_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_XksProxyVpcEndpointServiceNameType_) String() string {
	return "ComAmazonawsKmsTypes.XksProxyVpcEndpointServiceNameType"
}
func (_this *CompanionStruct_XksProxyVpcEndpointServiceNameType_) Is_(__source _dafny.Sequence) bool {
	var _6_x _dafny.Sequence = (__source)
	_ = _6_x
	return Companion_Default___.IsValid__XksProxyVpcEndpointServiceNameType(_6_x)
}

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

type Error_AlreadyExistsException struct {
	Message m_Wrappers.Option
}

func (Error_AlreadyExistsException) isError() {}

func (CompanionStruct_Error_) Create_AlreadyExistsException_(Message m_Wrappers.Option) Error {
	return Error{Error_AlreadyExistsException{Message}}
}

func (_this Error) Is_AlreadyExistsException() bool {
	_, ok := _this.Get_().(Error_AlreadyExistsException)
	return ok
}

type Error_CloudHsmClusterInUseException struct {
	Message m_Wrappers.Option
}

func (Error_CloudHsmClusterInUseException) isError() {}

func (CompanionStruct_Error_) Create_CloudHsmClusterInUseException_(Message m_Wrappers.Option) Error {
	return Error{Error_CloudHsmClusterInUseException{Message}}
}

func (_this Error) Is_CloudHsmClusterInUseException() bool {
	_, ok := _this.Get_().(Error_CloudHsmClusterInUseException)
	return ok
}

type Error_CloudHsmClusterInvalidConfigurationException struct {
	Message m_Wrappers.Option
}

func (Error_CloudHsmClusterInvalidConfigurationException) isError() {}

func (CompanionStruct_Error_) Create_CloudHsmClusterInvalidConfigurationException_(Message m_Wrappers.Option) Error {
	return Error{Error_CloudHsmClusterInvalidConfigurationException{Message}}
}

func (_this Error) Is_CloudHsmClusterInvalidConfigurationException() bool {
	_, ok := _this.Get_().(Error_CloudHsmClusterInvalidConfigurationException)
	return ok
}

type Error_CloudHsmClusterNotActiveException struct {
	Message m_Wrappers.Option
}

func (Error_CloudHsmClusterNotActiveException) isError() {}

func (CompanionStruct_Error_) Create_CloudHsmClusterNotActiveException_(Message m_Wrappers.Option) Error {
	return Error{Error_CloudHsmClusterNotActiveException{Message}}
}

func (_this Error) Is_CloudHsmClusterNotActiveException() bool {
	_, ok := _this.Get_().(Error_CloudHsmClusterNotActiveException)
	return ok
}

type Error_CloudHsmClusterNotFoundException struct {
	Message m_Wrappers.Option
}

func (Error_CloudHsmClusterNotFoundException) isError() {}

func (CompanionStruct_Error_) Create_CloudHsmClusterNotFoundException_(Message m_Wrappers.Option) Error {
	return Error{Error_CloudHsmClusterNotFoundException{Message}}
}

func (_this Error) Is_CloudHsmClusterNotFoundException() bool {
	_, ok := _this.Get_().(Error_CloudHsmClusterNotFoundException)
	return ok
}

type Error_CloudHsmClusterNotRelatedException struct {
	Message m_Wrappers.Option
}

func (Error_CloudHsmClusterNotRelatedException) isError() {}

func (CompanionStruct_Error_) Create_CloudHsmClusterNotRelatedException_(Message m_Wrappers.Option) Error {
	return Error{Error_CloudHsmClusterNotRelatedException{Message}}
}

func (_this Error) Is_CloudHsmClusterNotRelatedException() bool {
	_, ok := _this.Get_().(Error_CloudHsmClusterNotRelatedException)
	return ok
}

type Error_ConflictException struct {
	Message m_Wrappers.Option
}

func (Error_ConflictException) isError() {}

func (CompanionStruct_Error_) Create_ConflictException_(Message m_Wrappers.Option) Error {
	return Error{Error_ConflictException{Message}}
}

func (_this Error) Is_ConflictException() bool {
	_, ok := _this.Get_().(Error_ConflictException)
	return ok
}

type Error_CustomKeyStoreHasCMKsException struct {
	Message m_Wrappers.Option
}

func (Error_CustomKeyStoreHasCMKsException) isError() {}

func (CompanionStruct_Error_) Create_CustomKeyStoreHasCMKsException_(Message m_Wrappers.Option) Error {
	return Error{Error_CustomKeyStoreHasCMKsException{Message}}
}

func (_this Error) Is_CustomKeyStoreHasCMKsException() bool {
	_, ok := _this.Get_().(Error_CustomKeyStoreHasCMKsException)
	return ok
}

type Error_CustomKeyStoreInvalidStateException struct {
	Message m_Wrappers.Option
}

func (Error_CustomKeyStoreInvalidStateException) isError() {}

func (CompanionStruct_Error_) Create_CustomKeyStoreInvalidStateException_(Message m_Wrappers.Option) Error {
	return Error{Error_CustomKeyStoreInvalidStateException{Message}}
}

func (_this Error) Is_CustomKeyStoreInvalidStateException() bool {
	_, ok := _this.Get_().(Error_CustomKeyStoreInvalidStateException)
	return ok
}

type Error_CustomKeyStoreNameInUseException struct {
	Message m_Wrappers.Option
}

func (Error_CustomKeyStoreNameInUseException) isError() {}

func (CompanionStruct_Error_) Create_CustomKeyStoreNameInUseException_(Message m_Wrappers.Option) Error {
	return Error{Error_CustomKeyStoreNameInUseException{Message}}
}

func (_this Error) Is_CustomKeyStoreNameInUseException() bool {
	_, ok := _this.Get_().(Error_CustomKeyStoreNameInUseException)
	return ok
}

type Error_CustomKeyStoreNotFoundException struct {
	Message m_Wrappers.Option
}

func (Error_CustomKeyStoreNotFoundException) isError() {}

func (CompanionStruct_Error_) Create_CustomKeyStoreNotFoundException_(Message m_Wrappers.Option) Error {
	return Error{Error_CustomKeyStoreNotFoundException{Message}}
}

func (_this Error) Is_CustomKeyStoreNotFoundException() bool {
	_, ok := _this.Get_().(Error_CustomKeyStoreNotFoundException)
	return ok
}

type Error_DependencyTimeoutException struct {
	Message m_Wrappers.Option
}

func (Error_DependencyTimeoutException) isError() {}

func (CompanionStruct_Error_) Create_DependencyTimeoutException_(Message m_Wrappers.Option) Error {
	return Error{Error_DependencyTimeoutException{Message}}
}

func (_this Error) Is_DependencyTimeoutException() bool {
	_, ok := _this.Get_().(Error_DependencyTimeoutException)
	return ok
}

type Error_DisabledException struct {
	Message m_Wrappers.Option
}

func (Error_DisabledException) isError() {}

func (CompanionStruct_Error_) Create_DisabledException_(Message m_Wrappers.Option) Error {
	return Error{Error_DisabledException{Message}}
}

func (_this Error) Is_DisabledException() bool {
	_, ok := _this.Get_().(Error_DisabledException)
	return ok
}

type Error_DryRunOperationException struct {
	Message m_Wrappers.Option
}

func (Error_DryRunOperationException) isError() {}

func (CompanionStruct_Error_) Create_DryRunOperationException_(Message m_Wrappers.Option) Error {
	return Error{Error_DryRunOperationException{Message}}
}

func (_this Error) Is_DryRunOperationException() bool {
	_, ok := _this.Get_().(Error_DryRunOperationException)
	return ok
}

type Error_ExpiredImportTokenException struct {
	Message m_Wrappers.Option
}

func (Error_ExpiredImportTokenException) isError() {}

func (CompanionStruct_Error_) Create_ExpiredImportTokenException_(Message m_Wrappers.Option) Error {
	return Error{Error_ExpiredImportTokenException{Message}}
}

func (_this Error) Is_ExpiredImportTokenException() bool {
	_, ok := _this.Get_().(Error_ExpiredImportTokenException)
	return ok
}

type Error_IncorrectKeyException struct {
	Message m_Wrappers.Option
}

func (Error_IncorrectKeyException) isError() {}

func (CompanionStruct_Error_) Create_IncorrectKeyException_(Message m_Wrappers.Option) Error {
	return Error{Error_IncorrectKeyException{Message}}
}

func (_this Error) Is_IncorrectKeyException() bool {
	_, ok := _this.Get_().(Error_IncorrectKeyException)
	return ok
}

type Error_IncorrectKeyMaterialException struct {
	Message m_Wrappers.Option
}

func (Error_IncorrectKeyMaterialException) isError() {}

func (CompanionStruct_Error_) Create_IncorrectKeyMaterialException_(Message m_Wrappers.Option) Error {
	return Error{Error_IncorrectKeyMaterialException{Message}}
}

func (_this Error) Is_IncorrectKeyMaterialException() bool {
	_, ok := _this.Get_().(Error_IncorrectKeyMaterialException)
	return ok
}

type Error_IncorrectTrustAnchorException struct {
	Message m_Wrappers.Option
}

func (Error_IncorrectTrustAnchorException) isError() {}

func (CompanionStruct_Error_) Create_IncorrectTrustAnchorException_(Message m_Wrappers.Option) Error {
	return Error{Error_IncorrectTrustAnchorException{Message}}
}

func (_this Error) Is_IncorrectTrustAnchorException() bool {
	_, ok := _this.Get_().(Error_IncorrectTrustAnchorException)
	return ok
}

type Error_InvalidAliasNameException struct {
	Message m_Wrappers.Option
}

func (Error_InvalidAliasNameException) isError() {}

func (CompanionStruct_Error_) Create_InvalidAliasNameException_(Message m_Wrappers.Option) Error {
	return Error{Error_InvalidAliasNameException{Message}}
}

func (_this Error) Is_InvalidAliasNameException() bool {
	_, ok := _this.Get_().(Error_InvalidAliasNameException)
	return ok
}

type Error_InvalidArnException struct {
	Message m_Wrappers.Option
}

func (Error_InvalidArnException) isError() {}

func (CompanionStruct_Error_) Create_InvalidArnException_(Message m_Wrappers.Option) Error {
	return Error{Error_InvalidArnException{Message}}
}

func (_this Error) Is_InvalidArnException() bool {
	_, ok := _this.Get_().(Error_InvalidArnException)
	return ok
}

type Error_InvalidCiphertextException struct {
	Message m_Wrappers.Option
}

func (Error_InvalidCiphertextException) isError() {}

func (CompanionStruct_Error_) Create_InvalidCiphertextException_(Message m_Wrappers.Option) Error {
	return Error{Error_InvalidCiphertextException{Message}}
}

func (_this Error) Is_InvalidCiphertextException() bool {
	_, ok := _this.Get_().(Error_InvalidCiphertextException)
	return ok
}

type Error_InvalidGrantIdException struct {
	Message m_Wrappers.Option
}

func (Error_InvalidGrantIdException) isError() {}

func (CompanionStruct_Error_) Create_InvalidGrantIdException_(Message m_Wrappers.Option) Error {
	return Error{Error_InvalidGrantIdException{Message}}
}

func (_this Error) Is_InvalidGrantIdException() bool {
	_, ok := _this.Get_().(Error_InvalidGrantIdException)
	return ok
}

type Error_InvalidGrantTokenException struct {
	Message m_Wrappers.Option
}

func (Error_InvalidGrantTokenException) isError() {}

func (CompanionStruct_Error_) Create_InvalidGrantTokenException_(Message m_Wrappers.Option) Error {
	return Error{Error_InvalidGrantTokenException{Message}}
}

func (_this Error) Is_InvalidGrantTokenException() bool {
	_, ok := _this.Get_().(Error_InvalidGrantTokenException)
	return ok
}

type Error_InvalidImportTokenException struct {
	Message m_Wrappers.Option
}

func (Error_InvalidImportTokenException) isError() {}

func (CompanionStruct_Error_) Create_InvalidImportTokenException_(Message m_Wrappers.Option) Error {
	return Error{Error_InvalidImportTokenException{Message}}
}

func (_this Error) Is_InvalidImportTokenException() bool {
	_, ok := _this.Get_().(Error_InvalidImportTokenException)
	return ok
}

type Error_InvalidKeyUsageException struct {
	Message m_Wrappers.Option
}

func (Error_InvalidKeyUsageException) isError() {}

func (CompanionStruct_Error_) Create_InvalidKeyUsageException_(Message m_Wrappers.Option) Error {
	return Error{Error_InvalidKeyUsageException{Message}}
}

func (_this Error) Is_InvalidKeyUsageException() bool {
	_, ok := _this.Get_().(Error_InvalidKeyUsageException)
	return ok
}

type Error_InvalidMarkerException struct {
	Message m_Wrappers.Option
}

func (Error_InvalidMarkerException) isError() {}

func (CompanionStruct_Error_) Create_InvalidMarkerException_(Message m_Wrappers.Option) Error {
	return Error{Error_InvalidMarkerException{Message}}
}

func (_this Error) Is_InvalidMarkerException() bool {
	_, ok := _this.Get_().(Error_InvalidMarkerException)
	return ok
}

type Error_KeyUnavailableException struct {
	Message m_Wrappers.Option
}

func (Error_KeyUnavailableException) isError() {}

func (CompanionStruct_Error_) Create_KeyUnavailableException_(Message m_Wrappers.Option) Error {
	return Error{Error_KeyUnavailableException{Message}}
}

func (_this Error) Is_KeyUnavailableException() bool {
	_, ok := _this.Get_().(Error_KeyUnavailableException)
	return ok
}

type Error_KMSInternalException struct {
	Message m_Wrappers.Option
}

func (Error_KMSInternalException) isError() {}

func (CompanionStruct_Error_) Create_KMSInternalException_(Message m_Wrappers.Option) Error {
	return Error{Error_KMSInternalException{Message}}
}

func (_this Error) Is_KMSInternalException() bool {
	_, ok := _this.Get_().(Error_KMSInternalException)
	return ok
}

type Error_KMSInvalidMacException struct {
	Message m_Wrappers.Option
}

func (Error_KMSInvalidMacException) isError() {}

func (CompanionStruct_Error_) Create_KMSInvalidMacException_(Message m_Wrappers.Option) Error {
	return Error{Error_KMSInvalidMacException{Message}}
}

func (_this Error) Is_KMSInvalidMacException() bool {
	_, ok := _this.Get_().(Error_KMSInvalidMacException)
	return ok
}

type Error_KMSInvalidSignatureException struct {
	Message m_Wrappers.Option
}

func (Error_KMSInvalidSignatureException) isError() {}

func (CompanionStruct_Error_) Create_KMSInvalidSignatureException_(Message m_Wrappers.Option) Error {
	return Error{Error_KMSInvalidSignatureException{Message}}
}

func (_this Error) Is_KMSInvalidSignatureException() bool {
	_, ok := _this.Get_().(Error_KMSInvalidSignatureException)
	return ok
}

type Error_KMSInvalidStateException struct {
	Message m_Wrappers.Option
}

func (Error_KMSInvalidStateException) isError() {}

func (CompanionStruct_Error_) Create_KMSInvalidStateException_(Message m_Wrappers.Option) Error {
	return Error{Error_KMSInvalidStateException{Message}}
}

func (_this Error) Is_KMSInvalidStateException() bool {
	_, ok := _this.Get_().(Error_KMSInvalidStateException)
	return ok
}

type Error_LimitExceededException struct {
	Message m_Wrappers.Option
}

func (Error_LimitExceededException) isError() {}

func (CompanionStruct_Error_) Create_LimitExceededException_(Message m_Wrappers.Option) Error {
	return Error{Error_LimitExceededException{Message}}
}

func (_this Error) Is_LimitExceededException() bool {
	_, ok := _this.Get_().(Error_LimitExceededException)
	return ok
}

type Error_MalformedPolicyDocumentException struct {
	Message m_Wrappers.Option
}

func (Error_MalformedPolicyDocumentException) isError() {}

func (CompanionStruct_Error_) Create_MalformedPolicyDocumentException_(Message m_Wrappers.Option) Error {
	return Error{Error_MalformedPolicyDocumentException{Message}}
}

func (_this Error) Is_MalformedPolicyDocumentException() bool {
	_, ok := _this.Get_().(Error_MalformedPolicyDocumentException)
	return ok
}

type Error_NotFoundException struct {
	Message m_Wrappers.Option
}

func (Error_NotFoundException) isError() {}

func (CompanionStruct_Error_) Create_NotFoundException_(Message m_Wrappers.Option) Error {
	return Error{Error_NotFoundException{Message}}
}

func (_this Error) Is_NotFoundException() bool {
	_, ok := _this.Get_().(Error_NotFoundException)
	return ok
}

type Error_TagException struct {
	Message m_Wrappers.Option
}

func (Error_TagException) isError() {}

func (CompanionStruct_Error_) Create_TagException_(Message m_Wrappers.Option) Error {
	return Error{Error_TagException{Message}}
}

func (_this Error) Is_TagException() bool {
	_, ok := _this.Get_().(Error_TagException)
	return ok
}

type Error_UnsupportedOperationException struct {
	Message m_Wrappers.Option
}

func (Error_UnsupportedOperationException) isError() {}

func (CompanionStruct_Error_) Create_UnsupportedOperationException_(Message m_Wrappers.Option) Error {
	return Error{Error_UnsupportedOperationException{Message}}
}

func (_this Error) Is_UnsupportedOperationException() bool {
	_, ok := _this.Get_().(Error_UnsupportedOperationException)
	return ok
}

type Error_XksKeyAlreadyInUseException struct {
	Message m_Wrappers.Option
}

func (Error_XksKeyAlreadyInUseException) isError() {}

func (CompanionStruct_Error_) Create_XksKeyAlreadyInUseException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksKeyAlreadyInUseException{Message}}
}

func (_this Error) Is_XksKeyAlreadyInUseException() bool {
	_, ok := _this.Get_().(Error_XksKeyAlreadyInUseException)
	return ok
}

type Error_XksKeyInvalidConfigurationException struct {
	Message m_Wrappers.Option
}

func (Error_XksKeyInvalidConfigurationException) isError() {}

func (CompanionStruct_Error_) Create_XksKeyInvalidConfigurationException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksKeyInvalidConfigurationException{Message}}
}

func (_this Error) Is_XksKeyInvalidConfigurationException() bool {
	_, ok := _this.Get_().(Error_XksKeyInvalidConfigurationException)
	return ok
}

type Error_XksKeyNotFoundException struct {
	Message m_Wrappers.Option
}

func (Error_XksKeyNotFoundException) isError() {}

func (CompanionStruct_Error_) Create_XksKeyNotFoundException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksKeyNotFoundException{Message}}
}

func (_this Error) Is_XksKeyNotFoundException() bool {
	_, ok := _this.Get_().(Error_XksKeyNotFoundException)
	return ok
}

type Error_XksProxyIncorrectAuthenticationCredentialException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyIncorrectAuthenticationCredentialException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyIncorrectAuthenticationCredentialException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyIncorrectAuthenticationCredentialException{Message}}
}

func (_this Error) Is_XksProxyIncorrectAuthenticationCredentialException() bool {
	_, ok := _this.Get_().(Error_XksProxyIncorrectAuthenticationCredentialException)
	return ok
}

type Error_XksProxyInvalidConfigurationException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyInvalidConfigurationException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyInvalidConfigurationException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyInvalidConfigurationException{Message}}
}

func (_this Error) Is_XksProxyInvalidConfigurationException() bool {
	_, ok := _this.Get_().(Error_XksProxyInvalidConfigurationException)
	return ok
}

type Error_XksProxyInvalidResponseException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyInvalidResponseException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyInvalidResponseException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyInvalidResponseException{Message}}
}

func (_this Error) Is_XksProxyInvalidResponseException() bool {
	_, ok := _this.Get_().(Error_XksProxyInvalidResponseException)
	return ok
}

type Error_XksProxyUriEndpointInUseException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyUriEndpointInUseException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyUriEndpointInUseException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyUriEndpointInUseException{Message}}
}

func (_this Error) Is_XksProxyUriEndpointInUseException() bool {
	_, ok := _this.Get_().(Error_XksProxyUriEndpointInUseException)
	return ok
}

type Error_XksProxyUriInUseException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyUriInUseException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyUriInUseException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyUriInUseException{Message}}
}

func (_this Error) Is_XksProxyUriInUseException() bool {
	_, ok := _this.Get_().(Error_XksProxyUriInUseException)
	return ok
}

type Error_XksProxyUriUnreachableException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyUriUnreachableException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyUriUnreachableException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyUriUnreachableException{Message}}
}

func (_this Error) Is_XksProxyUriUnreachableException() bool {
	_, ok := _this.Get_().(Error_XksProxyUriUnreachableException)
	return ok
}

type Error_XksProxyVpcEndpointServiceInUseException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyVpcEndpointServiceInUseException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyVpcEndpointServiceInUseException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyVpcEndpointServiceInUseException{Message}}
}

func (_this Error) Is_XksProxyVpcEndpointServiceInUseException() bool {
	_, ok := _this.Get_().(Error_XksProxyVpcEndpointServiceInUseException)
	return ok
}

type Error_XksProxyVpcEndpointServiceInvalidConfigurationException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyVpcEndpointServiceInvalidConfigurationException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyVpcEndpointServiceInvalidConfigurationException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyVpcEndpointServiceInvalidConfigurationException{Message}}
}

func (_this Error) Is_XksProxyVpcEndpointServiceInvalidConfigurationException() bool {
	_, ok := _this.Get_().(Error_XksProxyVpcEndpointServiceInvalidConfigurationException)
	return ok
}

type Error_XksProxyVpcEndpointServiceNotFoundException struct {
	Message m_Wrappers.Option
}

func (Error_XksProxyVpcEndpointServiceNotFoundException) isError() {}

func (CompanionStruct_Error_) Create_XksProxyVpcEndpointServiceNotFoundException_(Message m_Wrappers.Option) Error {
	return Error{Error_XksProxyVpcEndpointServiceNotFoundException{Message}}
}

func (_this Error) Is_XksProxyVpcEndpointServiceNotFoundException() bool {
	_, ok := _this.Get_().(Error_XksProxyVpcEndpointServiceNotFoundException)
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
	return Companion_Error_.Create_AlreadyExistsException_(m_Wrappers.Companion_Option_.Default())
}

func (_this Error) Dtor_message() m_Wrappers.Option {
	switch data := _this.Get_().(type) {
	case Error_AlreadyExistsException:
		return data.Message
	case Error_CloudHsmClusterInUseException:
		return data.Message
	case Error_CloudHsmClusterInvalidConfigurationException:
		return data.Message
	case Error_CloudHsmClusterNotActiveException:
		return data.Message
	case Error_CloudHsmClusterNotFoundException:
		return data.Message
	case Error_CloudHsmClusterNotRelatedException:
		return data.Message
	case Error_ConflictException:
		return data.Message
	case Error_CustomKeyStoreHasCMKsException:
		return data.Message
	case Error_CustomKeyStoreInvalidStateException:
		return data.Message
	case Error_CustomKeyStoreNameInUseException:
		return data.Message
	case Error_CustomKeyStoreNotFoundException:
		return data.Message
	case Error_DependencyTimeoutException:
		return data.Message
	case Error_DisabledException:
		return data.Message
	case Error_DryRunOperationException:
		return data.Message
	case Error_ExpiredImportTokenException:
		return data.Message
	case Error_IncorrectKeyException:
		return data.Message
	case Error_IncorrectKeyMaterialException:
		return data.Message
	case Error_IncorrectTrustAnchorException:
		return data.Message
	case Error_InvalidAliasNameException:
		return data.Message
	case Error_InvalidArnException:
		return data.Message
	case Error_InvalidCiphertextException:
		return data.Message
	case Error_InvalidGrantIdException:
		return data.Message
	case Error_InvalidGrantTokenException:
		return data.Message
	case Error_InvalidImportTokenException:
		return data.Message
	case Error_InvalidKeyUsageException:
		return data.Message
	case Error_InvalidMarkerException:
		return data.Message
	case Error_KeyUnavailableException:
		return data.Message
	case Error_KMSInternalException:
		return data.Message
	case Error_KMSInvalidMacException:
		return data.Message
	case Error_KMSInvalidSignatureException:
		return data.Message
	case Error_KMSInvalidStateException:
		return data.Message
	case Error_LimitExceededException:
		return data.Message
	case Error_MalformedPolicyDocumentException:
		return data.Message
	case Error_NotFoundException:
		return data.Message
	case Error_TagException:
		return data.Message
	case Error_UnsupportedOperationException:
		return data.Message
	case Error_XksKeyAlreadyInUseException:
		return data.Message
	case Error_XksKeyInvalidConfigurationException:
		return data.Message
	case Error_XksKeyNotFoundException:
		return data.Message
	case Error_XksProxyIncorrectAuthenticationCredentialException:
		return data.Message
	case Error_XksProxyInvalidConfigurationException:
		return data.Message
	case Error_XksProxyInvalidResponseException:
		return data.Message
	case Error_XksProxyUriEndpointInUseException:
		return data.Message
	case Error_XksProxyUriInUseException:
		return data.Message
	case Error_XksProxyUriUnreachableException:
		return data.Message
	case Error_XksProxyVpcEndpointServiceInUseException:
		return data.Message
	case Error_XksProxyVpcEndpointServiceInvalidConfigurationException:
		return data.Message
	default:
		return data.(Error_XksProxyVpcEndpointServiceNotFoundException).Message
	}
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
	case Error_AlreadyExistsException:
		{
			return "ComAmazonawsKmsTypes.Error.AlreadyExistsException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CloudHsmClusterInUseException:
		{
			return "ComAmazonawsKmsTypes.Error.CloudHsmClusterInUseException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CloudHsmClusterInvalidConfigurationException:
		{
			return "ComAmazonawsKmsTypes.Error.CloudHsmClusterInvalidConfigurationException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CloudHsmClusterNotActiveException:
		{
			return "ComAmazonawsKmsTypes.Error.CloudHsmClusterNotActiveException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CloudHsmClusterNotFoundException:
		{
			return "ComAmazonawsKmsTypes.Error.CloudHsmClusterNotFoundException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CloudHsmClusterNotRelatedException:
		{
			return "ComAmazonawsKmsTypes.Error.CloudHsmClusterNotRelatedException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_ConflictException:
		{
			return "ComAmazonawsKmsTypes.Error.ConflictException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CustomKeyStoreHasCMKsException:
		{
			return "ComAmazonawsKmsTypes.Error.CustomKeyStoreHasCMKsException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CustomKeyStoreInvalidStateException:
		{
			return "ComAmazonawsKmsTypes.Error.CustomKeyStoreInvalidStateException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CustomKeyStoreNameInUseException:
		{
			return "ComAmazonawsKmsTypes.Error.CustomKeyStoreNameInUseException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_CustomKeyStoreNotFoundException:
		{
			return "ComAmazonawsKmsTypes.Error.CustomKeyStoreNotFoundException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_DependencyTimeoutException:
		{
			return "ComAmazonawsKmsTypes.Error.DependencyTimeoutException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_DisabledException:
		{
			return "ComAmazonawsKmsTypes.Error.DisabledException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_DryRunOperationException:
		{
			return "ComAmazonawsKmsTypes.Error.DryRunOperationException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_ExpiredImportTokenException:
		{
			return "ComAmazonawsKmsTypes.Error.ExpiredImportTokenException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_IncorrectKeyException:
		{
			return "ComAmazonawsKmsTypes.Error.IncorrectKeyException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_IncorrectKeyMaterialException:
		{
			return "ComAmazonawsKmsTypes.Error.IncorrectKeyMaterialException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_IncorrectTrustAnchorException:
		{
			return "ComAmazonawsKmsTypes.Error.IncorrectTrustAnchorException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidAliasNameException:
		{
			return "ComAmazonawsKmsTypes.Error.InvalidAliasNameException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidArnException:
		{
			return "ComAmazonawsKmsTypes.Error.InvalidArnException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidCiphertextException:
		{
			return "ComAmazonawsKmsTypes.Error.InvalidCiphertextException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidGrantIdException:
		{
			return "ComAmazonawsKmsTypes.Error.InvalidGrantIdException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidGrantTokenException:
		{
			return "ComAmazonawsKmsTypes.Error.InvalidGrantTokenException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidImportTokenException:
		{
			return "ComAmazonawsKmsTypes.Error.InvalidImportTokenException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidKeyUsageException:
		{
			return "ComAmazonawsKmsTypes.Error.InvalidKeyUsageException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_InvalidMarkerException:
		{
			return "ComAmazonawsKmsTypes.Error.InvalidMarkerException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_KeyUnavailableException:
		{
			return "ComAmazonawsKmsTypes.Error.KeyUnavailableException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_KMSInternalException:
		{
			return "ComAmazonawsKmsTypes.Error.KMSInternalException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_KMSInvalidMacException:
		{
			return "ComAmazonawsKmsTypes.Error.KMSInvalidMacException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_KMSInvalidSignatureException:
		{
			return "ComAmazonawsKmsTypes.Error.KMSInvalidSignatureException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_KMSInvalidStateException:
		{
			return "ComAmazonawsKmsTypes.Error.KMSInvalidStateException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_LimitExceededException:
		{
			return "ComAmazonawsKmsTypes.Error.LimitExceededException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_MalformedPolicyDocumentException:
		{
			return "ComAmazonawsKmsTypes.Error.MalformedPolicyDocumentException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_NotFoundException:
		{
			return "ComAmazonawsKmsTypes.Error.NotFoundException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_TagException:
		{
			return "ComAmazonawsKmsTypes.Error.TagException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_UnsupportedOperationException:
		{
			return "ComAmazonawsKmsTypes.Error.UnsupportedOperationException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksKeyAlreadyInUseException:
		{
			return "ComAmazonawsKmsTypes.Error.XksKeyAlreadyInUseException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksKeyInvalidConfigurationException:
		{
			return "ComAmazonawsKmsTypes.Error.XksKeyInvalidConfigurationException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksKeyNotFoundException:
		{
			return "ComAmazonawsKmsTypes.Error.XksKeyNotFoundException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyIncorrectAuthenticationCredentialException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyIncorrectAuthenticationCredentialException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyInvalidConfigurationException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyInvalidConfigurationException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyInvalidResponseException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyInvalidResponseException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyUriEndpointInUseException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyUriEndpointInUseException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyUriInUseException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyUriInUseException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyUriUnreachableException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyUriUnreachableException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyVpcEndpointServiceInUseException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyVpcEndpointServiceInUseException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyVpcEndpointServiceInvalidConfigurationException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyVpcEndpointServiceInvalidConfigurationException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_XksProxyVpcEndpointServiceNotFoundException:
		{
			return "ComAmazonawsKmsTypes.Error.XksProxyVpcEndpointServiceNotFoundException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_Opaque:
		{
			return "ComAmazonawsKmsTypes.Error.Opaque" + "(" + _dafny.String(data.Obj) + ")"
		}
	case Error_OpaqueWithText:
		{
			return "ComAmazonawsKmsTypes.Error.OpaqueWithText" + "(" + _dafny.String(data.Obj) + ", " + _dafny.String(data.ObjMessage) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Error) Equals(other Error) bool {
	switch data1 := _this.Get_().(type) {
	case Error_AlreadyExistsException:
		{
			data2, ok := other.Get_().(Error_AlreadyExistsException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CloudHsmClusterInUseException:
		{
			data2, ok := other.Get_().(Error_CloudHsmClusterInUseException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CloudHsmClusterInvalidConfigurationException:
		{
			data2, ok := other.Get_().(Error_CloudHsmClusterInvalidConfigurationException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CloudHsmClusterNotActiveException:
		{
			data2, ok := other.Get_().(Error_CloudHsmClusterNotActiveException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CloudHsmClusterNotFoundException:
		{
			data2, ok := other.Get_().(Error_CloudHsmClusterNotFoundException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CloudHsmClusterNotRelatedException:
		{
			data2, ok := other.Get_().(Error_CloudHsmClusterNotRelatedException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_ConflictException:
		{
			data2, ok := other.Get_().(Error_ConflictException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CustomKeyStoreHasCMKsException:
		{
			data2, ok := other.Get_().(Error_CustomKeyStoreHasCMKsException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CustomKeyStoreInvalidStateException:
		{
			data2, ok := other.Get_().(Error_CustomKeyStoreInvalidStateException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CustomKeyStoreNameInUseException:
		{
			data2, ok := other.Get_().(Error_CustomKeyStoreNameInUseException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_CustomKeyStoreNotFoundException:
		{
			data2, ok := other.Get_().(Error_CustomKeyStoreNotFoundException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_DependencyTimeoutException:
		{
			data2, ok := other.Get_().(Error_DependencyTimeoutException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_DisabledException:
		{
			data2, ok := other.Get_().(Error_DisabledException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_DryRunOperationException:
		{
			data2, ok := other.Get_().(Error_DryRunOperationException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_ExpiredImportTokenException:
		{
			data2, ok := other.Get_().(Error_ExpiredImportTokenException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_IncorrectKeyException:
		{
			data2, ok := other.Get_().(Error_IncorrectKeyException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_IncorrectKeyMaterialException:
		{
			data2, ok := other.Get_().(Error_IncorrectKeyMaterialException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_IncorrectTrustAnchorException:
		{
			data2, ok := other.Get_().(Error_IncorrectTrustAnchorException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidAliasNameException:
		{
			data2, ok := other.Get_().(Error_InvalidAliasNameException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidArnException:
		{
			data2, ok := other.Get_().(Error_InvalidArnException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidCiphertextException:
		{
			data2, ok := other.Get_().(Error_InvalidCiphertextException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidGrantIdException:
		{
			data2, ok := other.Get_().(Error_InvalidGrantIdException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidGrantTokenException:
		{
			data2, ok := other.Get_().(Error_InvalidGrantTokenException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidImportTokenException:
		{
			data2, ok := other.Get_().(Error_InvalidImportTokenException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidKeyUsageException:
		{
			data2, ok := other.Get_().(Error_InvalidKeyUsageException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_InvalidMarkerException:
		{
			data2, ok := other.Get_().(Error_InvalidMarkerException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_KeyUnavailableException:
		{
			data2, ok := other.Get_().(Error_KeyUnavailableException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_KMSInternalException:
		{
			data2, ok := other.Get_().(Error_KMSInternalException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_KMSInvalidMacException:
		{
			data2, ok := other.Get_().(Error_KMSInvalidMacException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_KMSInvalidSignatureException:
		{
			data2, ok := other.Get_().(Error_KMSInvalidSignatureException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_KMSInvalidStateException:
		{
			data2, ok := other.Get_().(Error_KMSInvalidStateException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_LimitExceededException:
		{
			data2, ok := other.Get_().(Error_LimitExceededException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_MalformedPolicyDocumentException:
		{
			data2, ok := other.Get_().(Error_MalformedPolicyDocumentException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_NotFoundException:
		{
			data2, ok := other.Get_().(Error_NotFoundException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_TagException:
		{
			data2, ok := other.Get_().(Error_TagException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_UnsupportedOperationException:
		{
			data2, ok := other.Get_().(Error_UnsupportedOperationException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksKeyAlreadyInUseException:
		{
			data2, ok := other.Get_().(Error_XksKeyAlreadyInUseException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksKeyInvalidConfigurationException:
		{
			data2, ok := other.Get_().(Error_XksKeyInvalidConfigurationException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksKeyNotFoundException:
		{
			data2, ok := other.Get_().(Error_XksKeyNotFoundException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyIncorrectAuthenticationCredentialException:
		{
			data2, ok := other.Get_().(Error_XksProxyIncorrectAuthenticationCredentialException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyInvalidConfigurationException:
		{
			data2, ok := other.Get_().(Error_XksProxyInvalidConfigurationException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyInvalidResponseException:
		{
			data2, ok := other.Get_().(Error_XksProxyInvalidResponseException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyUriEndpointInUseException:
		{
			data2, ok := other.Get_().(Error_XksProxyUriEndpointInUseException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyUriInUseException:
		{
			data2, ok := other.Get_().(Error_XksProxyUriInUseException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyUriUnreachableException:
		{
			data2, ok := other.Get_().(Error_XksProxyUriUnreachableException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyVpcEndpointServiceInUseException:
		{
			data2, ok := other.Get_().(Error_XksProxyVpcEndpointServiceInUseException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyVpcEndpointServiceInvalidConfigurationException:
		{
			data2, ok := other.Get_().(Error_XksProxyVpcEndpointServiceInvalidConfigurationException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_XksProxyVpcEndpointServiceNotFoundException:
		{
			data2, ok := other.Get_().(Error_XksProxyVpcEndpointServiceNotFoundException)
			return ok && data1.Message.Equals(data2.Message)
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
	return "ComAmazonawsKmsTypes.Error"
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
	return "ComAmazonawsKmsTypes.OpaqueError"
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
	return "ComAmazonawsKmsTypes.OpaqueError"
}
func (_this *CompanionStruct_OpaqueError_) Is_(__source Error) bool {
	var _7_e Error = (__source)
	_ = _7_e
	return ((_7_e).Is_Opaque()) || ((_7_e).Is_OpaqueWithText())
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
	return "ComAmazonawsKmsTypes.DummySubsetType"
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
	return "ComAmazonawsKmsTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Is_(__source _dafny.Int) bool {
	var _8_x _dafny.Int = (__source)
	_ = _8_x
	return Companion_Default___.IsDummySubsetType(_8_x)
}
