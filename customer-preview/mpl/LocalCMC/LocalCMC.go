// Package LocalCMC
// Dafny module LocalCMC compiled into Go

package LocalCMC

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_Com_Amazonaws_Dynamodb "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/Com_Amazonaws_Dynamodb"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_Com_Amazonaws_Kms "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/Com_Amazonaws_Kms"
	m_AlgorithmSuites "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AlgorithmSuites"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreOperations"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsDiscoveryKeyring"
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkDiscoveryKeyring"
	m_AwsKmsMrkKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkKeyring"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_DiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DiscoveryMultiKeyring"
	m_EdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EdkWrapping"
	m_ErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/ErrorMessages"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_IntermediateKeyWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/IntermediateKeyWrapping"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_MrkAwareDiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareDiscoveryMultiKeyring"
	m_MrkAwareStrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareStrictMultiKeyring"
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
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
	m_DafnyLibraries "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DafnyLibraries"
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
var _ m_AwsCryptographyKeyStoreOperations.Dummy__
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
var _ m_KeyStore.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_MultiKeyring.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_Constants.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_DiscoveryMultiKeyring.Dummy__
var _ m_AwsKmsMrkDiscoveryKeyring.Dummy__
var _ m_MrkAwareDiscoveryMultiKeyring.Dummy__
var _ m_AwsKmsMrkKeyring.Dummy__
var _ m_MrkAwareStrictMultiKeyring.Dummy__

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
	return "LocalCMC.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) RemoveValue(k0 interface{}, m _dafny.Map) {
	var _0_m_k _dafny.Map
	_ = _0_m_k
	_0_m_k = (m).Subtract(_dafny.SetOf(k0))
}
func (_static *CompanionStruct_Default___) NULL() Ref {
	return Companion_Ref_.Create_Null_()
}
func (_static *CompanionStruct_Default___) INT32__MAX__VALUE() int32 {
	return int32(2040109465)
}
func (_static *CompanionStruct_Default___) INT64__MAX__VALUE() int64 {
	return int64(8762203435012037017)
}

// End of class Default__

// Definition of datatype Ref
type Ref struct {
	Data_Ref_
}

func (_this Ref) Get_() Data_Ref_ {
	return _this.Data_Ref_
}

type Data_Ref_ interface {
	isRef()
}

type CompanionStruct_Ref_ struct {
}

var Companion_Ref_ = CompanionStruct_Ref_{}

type Ref_Ptr struct {
	Deref interface{}
}

func (Ref_Ptr) isRef() {}

func (CompanionStruct_Ref_) Create_Ptr_(Deref interface{}) Ref {
	return Ref{Ref_Ptr{Deref}}
}

func (_this Ref) Is_Ptr() bool {
	_, ok := _this.Get_().(Ref_Ptr)
	return ok
}

type Ref_Null struct {
}

func (Ref_Null) isRef() {}

func (CompanionStruct_Ref_) Create_Null_() Ref {
	return Ref{Ref_Null{}}
}

func (_this Ref) Is_Null() bool {
	_, ok := _this.Get_().(Ref_Null)
	return ok
}

func (CompanionStruct_Ref_) Default() Ref {
	return Companion_Ref_.Create_Null_()
}

func (_this Ref) Dtor_deref() interface{} {
	return _this.Get_().(Ref_Ptr).Deref
}

func (_this Ref) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Ref_Ptr:
		{
			return "LocalCMC.Ref.Ptr" + "(" + _dafny.String(data.Deref) + ")"
		}
	case Ref_Null:
		{
			return "LocalCMC.Ref.Null"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Ref) Equals(other Ref) bool {
	switch data1 := _this.Get_().(type) {
	case Ref_Ptr:
		{
			data2, ok := other.Get_().(Ref_Ptr)
			return ok && _dafny.AreEqual(data1.Deref, data2.Deref)
		}
	case Ref_Null:
		{
			_, ok := other.Get_().(Ref_Null)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Ref) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Ref)
	return ok && _this.Equals(typed)
}

func Type_Ref_() _dafny.TypeDescriptor {
	return type_Ref_{}
}

type type_Ref_ struct {
}

func (_this type_Ref_) Default() interface{} {
	return Companion_Ref_.Default()
}

func (_this type_Ref_) String() string {
	return "LocalCMC.Ref"
}
func (_this Ref) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Ref{}

// End of datatype Ref

// Definition of class CacheEntry
type CacheEntry struct {
	Prev          Ref
	Next          Ref
	MessagesUsed  int32
	BytesUsed     int32
	_identifier   _dafny.Sequence
	_materials    m_AwsCryptographyMaterialProvidersTypes.Materials
	_creationTime int64
	_expiryTime   int64
}

func New_CacheEntry_() *CacheEntry {
	_this := CacheEntry{}

	_this.Prev = Companion_Ref_.Default()
	_this.Next = Companion_Ref_.Default()
	_this.MessagesUsed = int32(0)
	_this.BytesUsed = int32(0)
	_this._identifier = _dafny.EmptySeq
	_this._materials = m_AwsCryptographyMaterialProvidersTypes.Materials{}
	_this._creationTime = int64(0)
	_this._expiryTime = int64(0)
	return &_this
}

type CompanionStruct_CacheEntry_ struct {
}

var Companion_CacheEntry_ = CompanionStruct_CacheEntry_{}

func (_this *CacheEntry) Equals(other *CacheEntry) bool {
	return _this == other
}

func (_this *CacheEntry) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*CacheEntry)
	return ok && _this.Equals(other)
}

func (*CacheEntry) String() string {
	return "LocalCMC.CacheEntry"
}

func Type_CacheEntry_() _dafny.TypeDescriptor {
	return type_CacheEntry_{}
}

type type_CacheEntry_ struct {
}

func (_this type_CacheEntry_) Default() interface{} {
	return (*CacheEntry)(nil)
}

func (_this type_CacheEntry_) String() string {
	return "LocalCMC.CacheEntry"
}
func (_this *CacheEntry) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &CacheEntry{}

func (_this *CacheEntry) Ctor__(materials_k m_AwsCryptographyMaterialProvidersTypes.Materials, identifier_k _dafny.Sequence, creationTime_k int64, expiryTime_k int64, messagesUsed_k int32, bytesUsed_k int32) {
	{
		(_this)._materials = materials_k
		(_this)._identifier = identifier_k
		(_this)._creationTime = creationTime_k
		(_this)._expiryTime = expiryTime_k
		(_this).MessagesUsed = messagesUsed_k
		(_this).BytesUsed = bytesUsed_k
		(_this).Prev = Companion_Default___.NULL()
		(_this).Next = Companion_Default___.NULL()
	}
}
func (_this *CacheEntry) Identifier() _dafny.Sequence {
	{
		return _this._identifier
	}
}
func (_this *CacheEntry) Materials() m_AwsCryptographyMaterialProvidersTypes.Materials {
	{
		return _this._materials
	}
}
func (_this *CacheEntry) CreationTime() int64 {
	{
		return _this._creationTime
	}
}
func (_this *CacheEntry) ExpiryTime() int64 {
	{
		return _this._expiryTime
	}
}

// End of class CacheEntry

// Definition of class DoublyLinkedCacheEntryList
type DoublyLinkedCacheEntryList struct {
	Head Ref
	Tail Ref
}

func New_DoublyLinkedCacheEntryList_() *DoublyLinkedCacheEntryList {
	_this := DoublyLinkedCacheEntryList{}

	_this.Head = Companion_Ref_.Default()
	_this.Tail = Companion_Ref_.Default()
	return &_this
}

type CompanionStruct_DoublyLinkedCacheEntryList_ struct {
}

var Companion_DoublyLinkedCacheEntryList_ = CompanionStruct_DoublyLinkedCacheEntryList_{}

func (_this *DoublyLinkedCacheEntryList) Equals(other *DoublyLinkedCacheEntryList) bool {
	return _this == other
}

func (_this *DoublyLinkedCacheEntryList) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*DoublyLinkedCacheEntryList)
	return ok && _this.Equals(other)
}

func (*DoublyLinkedCacheEntryList) String() string {
	return "LocalCMC.DoublyLinkedCacheEntryList"
}

func Type_DoublyLinkedCacheEntryList_() _dafny.TypeDescriptor {
	return type_DoublyLinkedCacheEntryList_{}
}

type type_DoublyLinkedCacheEntryList_ struct {
}

func (_this type_DoublyLinkedCacheEntryList_) Default() interface{} {
	return (*DoublyLinkedCacheEntryList)(nil)
}

func (_this type_DoublyLinkedCacheEntryList_) String() string {
	return "LocalCMC.DoublyLinkedCacheEntryList"
}
func (_this *DoublyLinkedCacheEntryList) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &DoublyLinkedCacheEntryList{}

func (_this *DoublyLinkedCacheEntryList) Ctor__() {
	{
		(_this).Head = Companion_Ref_.Create_Null_()
		(_this).Tail = Companion_Ref_.Create_Null_()
	}
}
func (_this *DoublyLinkedCacheEntryList) PushCell(toPush *CacheEntry) {
	{
		var _0_cRef Ref
		_ = _0_cRef
		_0_cRef = Companion_Ref_.Create_Ptr_(toPush)
		if (_this.Head).Is_Ptr() {
			var _obj0 *CacheEntry = (_this.Head).Dtor_deref().(*CacheEntry)
			_ = _obj0
			_obj0.Prev = _0_cRef
			(toPush).Next = _this.Head
			(_this).Head = _0_cRef
		} else {
			(_this).Head = _0_cRef
			(_this).Tail = _this.Head
		}
	}
}
func (_this *DoublyLinkedCacheEntryList) MoveToFront(c *CacheEntry) {
	{
		if ((_this.Head).Dtor_deref().(*CacheEntry)) != (c) /* dircomp */ {
			var _0_toPush Ref
			_ = _0_toPush
			_0_toPush = Companion_Ref_.Create_Ptr_(c)
			(_this).Remove(c)
			if (_this.Head).Is_Ptr() {
				var _obj0 *CacheEntry = (_this.Head).Dtor_deref().(*CacheEntry)
				_ = _obj0
				_obj0.Prev = _0_toPush
				var _obj1 *CacheEntry = (_0_toPush).Dtor_deref().(*CacheEntry)
				_ = _obj1
				_obj1.Next = _this.Head
				(_this).Head = _0_toPush
			} else {
				(_this).Head = _0_toPush
				(_this).Tail = _this.Head
			}
		}
	}
}
func (_this *DoublyLinkedCacheEntryList) Remove(toRemove *CacheEntry) {
	{
		if (toRemove.Prev).Is_Null() {
			(_this).Head = toRemove.Next
		} else {
			var _obj0 *CacheEntry = (toRemove.Prev).Dtor_deref().(*CacheEntry)
			_ = _obj0
			_obj0.Next = toRemove.Next
		}
		if (toRemove.Next).Is_Null() {
			(_this).Tail = toRemove.Prev
		} else {
			var _obj1 *CacheEntry = (toRemove.Next).Dtor_deref().(*CacheEntry)
			_ = _obj1
			_obj1.Prev = toRemove.Prev
		}
		{
			goto L0
		}
	L0:
		(toRemove).Next = Companion_Default___.NULL()
		(toRemove).Prev = Companion_Default___.NULL()
	}
}

// End of class DoublyLinkedCacheEntryList

// Definition of class LocalCMC
type LocalCMC struct {
	Queue                 *DoublyLinkedCacheEntryList
	Cache                 *m_DafnyLibraries.MutableMap
	_entryCapacity        _dafny.Int
	_entryPruningTailSize _dafny.Int
}

func New_LocalCMC_() *LocalCMC {
	_this := LocalCMC{}

	_this.Queue = (*DoublyLinkedCacheEntryList)(nil)
	_this.Cache = (*m_DafnyLibraries.MutableMap)(nil)
	_this._entryCapacity = _dafny.Zero
	_this._entryPruningTailSize = _dafny.Zero
	return &_this
}

type CompanionStruct_LocalCMC_ struct {
}

var Companion_LocalCMC_ = CompanionStruct_LocalCMC_{}

func (_this *LocalCMC) Equals(other *LocalCMC) bool {
	return _this == other
}

func (_this *LocalCMC) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*LocalCMC)
	return ok && _this.Equals(other)
}

func (*LocalCMC) String() string {
	return "LocalCMC.LocalCMC"
}

func Type_LocalCMC_() _dafny.TypeDescriptor {
	return type_LocalCMC_{}
}

type type_LocalCMC_ struct {
}

func (_this type_LocalCMC_) Default() interface{} {
	return (*LocalCMC)(nil)
}

func (_this type_LocalCMC_) String() string {
	return "LocalCMC.LocalCMC"
}
func (_this *LocalCMC) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.TraitID_}
}

var _ m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache = &LocalCMC{}
var _ _dafny.TraitOffspring = &LocalCMC{}

func (_this *LocalCMC) DeleteCacheEntry(input m_AwsCryptographyMaterialProvidersTypes.DeleteCacheEntryInput) m_Wrappers.Result {
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.DeleteCacheEntry(_this, input)
	return _out1
}
func (_this *LocalCMC) GetCacheEntry(input m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput) m_Wrappers.Result {
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.GetCacheEntry(_this, input)
	return _out1
}
func (_this *LocalCMC) PutCacheEntry(input m_AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput) m_Wrappers.Result {
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.PutCacheEntry(_this, input)
	return _out1
}
func (_this *LocalCMC) UpdateUsageMetadata(input m_AwsCryptographyMaterialProvidersTypes.UpdateUsageMetadataInput) m_Wrappers.Result {
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.UpdateUsageMetadata(_this, input)
	return _out1
}
func (_this *LocalCMC) Ctor__(entryCapacity_k _dafny.Int, entryPruningTailSize_k _dafny.Int) {
	{
		(_this)._entryCapacity = entryCapacity_k
		(_this)._entryPruningTailSize = entryPruningTailSize_k
		var _nw0 *m_DafnyLibraries.MutableMap = m_DafnyLibraries.New_MutableMap_()
		_ = _nw0
		(_this).Cache = _nw0
		var _nw1 *DoublyLinkedCacheEntryList = New_DoublyLinkedCacheEntryList_()
		_ = _nw1
		_nw1.Ctor__()
		(_this).Queue = _nw1
	}
}
func (_this *LocalCMC) GetCacheEntry_k(input m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_now int64
		_ = _0_now
		var _out0 int64
		_ = _out0
		_out0 = m__Time.CurrentRelativeTime()
		_0_now = _out0
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = (_this).GetCacheEntryWithTime(input, _0_now)
		output = _out1
		return output
	}
}
func (_this *LocalCMC) GetCacheEntryWithTime(input m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput, now int64) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		if (_this.Cache).HasKey((input).Dtor_identifier()) {
			var _0_entry *CacheEntry
			_ = _0_entry
			_0_entry = (_this.Cache).Select((input).Dtor_identifier()).(*CacheEntry)
			if (now) <= ((_0_entry).ExpiryTime()) {
				(_this.Queue).MoveToFront(_0_entry)
				output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_GetCacheEntryOutput_.Create_GetCacheEntryOutput_((_0_entry).Materials(), (_0_entry).CreationTime(), (_0_entry).ExpiryTime(), _0_entry.MessagesUsed, _0_entry.BytesUsed))
				var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
				_ = _1_valueOrError0
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = (_this).Pruning(now)
				_1_valueOrError0 = _out0
				if (_1_valueOrError0).IsFailure() {
					output = (_1_valueOrError0).PropagateFailure()
					return output
				}
				var _2___v0 _dafny.Tuple
				_ = _2___v0
				_2___v0 = (_1_valueOrError0).Extract().(_dafny.Tuple)
			} else {
				var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
				_ = _3_valueOrError1
				var _out1 m_Wrappers.Result
				_ = _out1
				_out1 = (_this).DeleteCacheEntry_k(m_AwsCryptographyMaterialProvidersTypes.Companion_DeleteCacheEntryInput_.Create_DeleteCacheEntryInput_((input).Dtor_identifier()))
				_3_valueOrError1 = _out1
				if (_3_valueOrError1).IsFailure() {
					output = (_3_valueOrError1).PropagateFailure()
					return output
				}
				var _4___v1 _dafny.Tuple
				_ = _4___v1
				_4___v1 = (_3_valueOrError1).Extract().(_dafny.Tuple)
				output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_EntryDoesNotExist_(_dafny.SeqOfString("Entry past TTL")))
			}
		} else {
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_EntryDoesNotExist_(_dafny.SeqOfString("Entry does not exist")))
		}
		return output
	}
}
func (_this *LocalCMC) PutCacheEntry_k(input m_AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = output
		if ((_this).EntryCapacity()).Sign() == 0 {
			output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
			return output
		}
		if (_this.Cache).HasKey((input).Dtor_identifier()) {
			var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
			_ = _0_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = (_this).DeleteCacheEntry_k(m_AwsCryptographyMaterialProvidersTypes.Companion_DeleteCacheEntryInput_.Create_DeleteCacheEntryInput_((input).Dtor_identifier()))
			_0_valueOrError0 = _out0
			if (_0_valueOrError0).IsFailure() {
				output = (_0_valueOrError0).PropagateFailure()
				return output
			}
			var _1___v2 _dafny.Tuple
			_ = _1___v2
			_1___v2 = (_0_valueOrError0).Extract().(_dafny.Tuple)
		}
		if ((_this).EntryCapacity()).Cmp((_this.Cache).Size()) == 0 {
			var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
			_ = _2_valueOrError1
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (_this).DeleteCacheEntry_k(m_AwsCryptographyMaterialProvidersTypes.Companion_DeleteCacheEntryInput_.Create_DeleteCacheEntryInput_(((_this.Queue.Tail).Dtor_deref().(*CacheEntry)).Identifier()))
			_2_valueOrError1 = _out1
			if (_2_valueOrError1).IsFailure() {
				output = (_2_valueOrError1).PropagateFailure()
				return output
			}
			var _3___v3 _dafny.Tuple
			_ = _3___v3
			_3___v3 = (_2_valueOrError1).Extract().(_dafny.Tuple)
		}
		var _4_cell *CacheEntry
		_ = _4_cell
		var _nw0 *CacheEntry = New_CacheEntry_()
		_ = _nw0
		_nw0.Ctor__((input).Dtor_materials(), (input).Dtor_identifier(), (input).Dtor_creationTime(), (input).Dtor_expiryTime(), ((input).Dtor_messagesUsed()).UnwrapOr(int32(0)).(int32), ((input).Dtor_bytesUsed()).UnwrapOr(int32(0)).(int32))
		_4_cell = _nw0
		(_this.Queue).PushCell(_4_cell)
		(_this.Cache).Put((input).Dtor_identifier(), _4_cell)
		output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
		return output
	}
}
func (_this *LocalCMC) DeleteCacheEntry_k(input m_AwsCryptographyMaterialProvidersTypes.DeleteCacheEntryInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = output
		if (_this.Cache).HasKey((input).Dtor_identifier()) {
			var _0_cell *CacheEntry
			_ = _0_cell
			_0_cell = (_this.Cache).Select((input).Dtor_identifier()).(*CacheEntry)
			{
				(_this.Cache).Remove((input).Dtor_identifier())
				goto L1
			}
		L1:
			(_this.Queue).Remove(_0_cell)
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
		return output
	}
}
func (_this *LocalCMC) UpdateUsageMetadata_k(input m_AwsCryptographyMaterialProvidersTypes.UpdateUsageMetadataInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = output
		if (_this.Cache).HasKey((input).Dtor_identifier()) {
			var _0_cell *CacheEntry
			_ = _0_cell
			_0_cell = (_this.Cache).Select((input).Dtor_identifier()).(*CacheEntry)
			if ((_0_cell.MessagesUsed) <= ((Companion_Default___.INT32__MAX__VALUE()) - (int32(1)))) && ((_0_cell.BytesUsed) <= ((Companion_Default___.INT32__MAX__VALUE()) - ((input).Dtor_bytesUsed()))) {
				var _rhs0 int32 = (_0_cell.MessagesUsed) + (int32(1))
				_ = _rhs0
				var _rhs1 int32 = (_0_cell.BytesUsed) + ((input).Dtor_bytesUsed())
				_ = _rhs1
				var _lhs0 *CacheEntry = _0_cell
				_ = _lhs0
				var _lhs1 *CacheEntry = _0_cell
				_ = _lhs1
				_lhs0.MessagesUsed = _rhs0
				_lhs1.BytesUsed = _rhs1
			} else {
				var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
				_ = _1_valueOrError0
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = (_this).DeleteCacheEntry_k(m_AwsCryptographyMaterialProvidersTypes.Companion_DeleteCacheEntryInput_.Create_DeleteCacheEntryInput_((input).Dtor_identifier()))
				_1_valueOrError0 = _out0
				if (_1_valueOrError0).IsFailure() {
					output = (_1_valueOrError0).PropagateFailure()
					return output
				}
				var _2___v4 _dafny.Tuple
				_ = _2___v4
				_2___v4 = (_1_valueOrError0).Extract().(_dafny.Tuple)
			}
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
		return output
		return output
	}
}
func (_this *LocalCMC) Pruning(now int64) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
		_ = output
		var _hi0 _dafny.Int = (_this).EntryPruningTailSize()
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			if (_this.Queue.Tail).Is_Ptr() {
				if (((_this.Queue.Tail).Dtor_deref().(*CacheEntry)).ExpiryTime()) < (now) {
					var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf())
					_ = _1_valueOrError0
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = (_this).DeleteCacheEntry_k(m_AwsCryptographyMaterialProvidersTypes.Companion_DeleteCacheEntryInput_.Create_DeleteCacheEntryInput_(((_this.Queue.Tail).Dtor_deref().(*CacheEntry)).Identifier()))
					_1_valueOrError0 = _out0
					if (_1_valueOrError0).IsFailure() {
						output = (_1_valueOrError0).PropagateFailure()
						return output
					}
					var _2___v5 _dafny.Tuple
					_ = _2___v5
					_2___v5 = (_1_valueOrError0).Extract().(_dafny.Tuple)
				} else {
					output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
					return output
				}
			} else {
				output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
				return output
			}
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf())
		return output
		return output
	}
}
func (_this *LocalCMC) EntryCapacity() _dafny.Int {
	{
		return _this._entryCapacity
	}
}
func (_this *LocalCMC) EntryPruningTailSize() _dafny.Int {
	{
		return _this._entryPruningTailSize
	}
}

// End of class LocalCMC
