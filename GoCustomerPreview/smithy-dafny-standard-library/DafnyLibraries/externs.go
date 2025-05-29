package DafnyLibraries

import (
	sync "sync"

	Std_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

// Definition of class MutableMap copied over from
// https://github.com/dafny-lang/dafny/blob/master/Source/DafnyStandardLibraries/src/Std_Concurrent/Std_Concurrent.go
type MutableMap struct {
	mu sync.Mutex

	Internal _dafny.Map
}

func New_MutableMap_() *MutableMap {
	return &MutableMap{}
}

type CompanionStruct_MutableMap_ struct {
}

var Companion_MutableMap_ = CompanionStruct_MutableMap_{}

func (_this *MutableMap) Equals(other *MutableMap) bool {
	return _this == other
}

// If you use the returned value, and ALSO continue to modify the MutableMap
// Then things might get weird.
func (_this *MutableMap) Content() _dafny.Map {
	return _this.Internal
}

func (_this *MutableMap) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*MutableMap)
	return ok && _this.Equals(other)
}

func (*MutableMap) String() string {
	return "ExternConcurrent.MutableMap"
}

func Type_MutableMap_(Type_K_ _dafny.TypeDescriptor, Type_V_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_MutableMap_{Type_K_, Type_V_}
}

type type_MutableMap_ struct {
	Type_K_ _dafny.TypeDescriptor
	Type_V_ _dafny.TypeDescriptor
}

func (_this type_MutableMap_) Default() interface{} {
	return (*MutableMap)(nil)
}

func (_this type_MutableMap_) String() string {
	return "ExternConcurrent.MutableMap"
}
func (_this *MutableMap) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &MutableMap{}

func (_this *MutableMap) Ctor__() {
	{
	}
}
func (_this *MutableMap) Keys() _dafny.Set {
	{
		_this.mu.Lock()
		defer _this.mu.Unlock()

		return _this.Internal.Keys()
	}
}
func (_this *MutableMap) HasKey(k interface{}) bool {
	{
		_this.mu.Lock()
		defer _this.mu.Unlock()

		return _this.Internal.Contains(k)
	}
}
func (_this *MutableMap) Values() _dafny.Set {
	{
		_this.mu.Lock()
		defer _this.mu.Unlock()

		return _this.Internal.Values()
	}
}
func (_this *MutableMap) Items() _dafny.Set {
	{
		_this.mu.Lock()
		defer _this.mu.Unlock()

		return _this.Internal.Items()
	}
}
func (_this *MutableMap) Get(k interface{}) Std_Wrappers.Option {
	{
		_this.mu.Lock()
		defer _this.mu.Unlock()

		value, ok := _this.Internal.Find(k)
		if ok {
			return Std_Wrappers.Companion_Option_.Create_Some_(value)
		} else {
			return Std_Wrappers.Companion_Option_.Create_None_()
		}
	}
}
func (_this *MutableMap) Put(k interface{}, v interface{}) {
	{
		_this.mu.Lock()
		defer _this.mu.Unlock()

		_this.Internal = _this.Internal.UpdateUnsafe(k, v)
	}
}
func (_this *MutableMap) Remove(k interface{}) {
	{
		_this.mu.Lock()
		defer _this.mu.Unlock()

		// This could be special-cased for a single remove to be a bit faster,
		// but it's still going to be O(n) so likely not worth it.
		_this.Internal = _this.Internal.Subtract(_dafny.SetOf(k))
	}
}
func (_this *MutableMap) Size() _dafny.Int {
	{
		_this.mu.Lock()
		defer _this.mu.Unlock()

		return _this.Internal.Cardinality()
	}
}

// End of class MutableMap

// This is handrolled extern
func (_this *MutableMap) Select(k interface{}) interface{} {
	r := _this.Get(k)
	if r.Is_None() {
		return nil
	}
	return r.Dtor_value()
}
