package StormTrackingCMC

import (
	"sync"
	"time"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	DafnyTime "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Time_"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

type StormTrackingCMC struct {
	stormTracker *StormTracker.StormTracker
	//The Lock contention is not tested.
	sync.Mutex
}

func New_StormTrackingCMC_(stormTracker *StormTracker.StormTracker) *StormTrackingCMC {
	return &StormTrackingCMC{stormTracker: stormTracker}
}

func (cmc *StormTrackingCMC) PutCacheEntry(input AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.stormTracker.PutCacheEntry(input)
}
func (cmc *StormTrackingCMC) PutCacheEntry_k(input AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.stormTracker.PutCacheEntry(input)
}
func (cmc *StormTrackingCMC) UpdateUsageMetadata(input AwsCryptographyMaterialProvidersTypes.UpdateUsageMetadataInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.stormTracker.UpdateUsageMetadata(input)
}
func (cmc *StormTrackingCMC) UpdateUsageMetadata_k(input AwsCryptographyMaterialProvidersTypes.UpdateUsageMetadataInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.stormTracker.UpdateUsageMetadata(input)
}
func (cmc *StormTrackingCMC) GetCacheEntry(input AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput) Wrappers.Result {
	return cmc.GetCacheEntry_k(input)
}
func (cmc *StormTrackingCMC) GetCacheEntry_k(input AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput) Wrappers.Result {
	maxInFlight := DafnyTime.CurrentRelativeTimeMilli() + cmc.stormTracker.InFlightTTL
	for {
		res := cmc.GetFromInner(input)
		if res.IsFailure() {
			return Companion_Default___.CreateGetCacheEntryFailure(res.Dtor_error().(AwsCryptographyMaterialProvidersTypes.Error))
		} else if res.Dtor_value().(StormTracker.CacheState).Is_Full() {
			return Companion_Default___.CreateGetCacheEntrySuccess(res.Dtor_value().(StormTracker.CacheState).Dtor_data())
		} else if res.Dtor_value().(StormTracker.CacheState).Is_EmptyFetch() {
			return Companion_Default___.CreateGetCacheEntryFailure(AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_EntryDoesNotExist_(_dafny.SeqOfChars([]_dafny.Char("Entry doesn't exists")...)))
		} else {
			if DafnyTime.CurrentRelativeTimeMilli() <= maxInFlight {
				time.Sleep(time.Duration(cmc.stormTracker.SleepMilli))
			} else {
				return Companion_Default___.CreateGetCacheEntryFailure(AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InFlightTTLExceeded_(_dafny.SeqOfChars([]_dafny.Char("Storm cache inFlightTTL exceeded.")...)))
			}
		}
	}
}
func (cmc *StormTrackingCMC) DeleteCacheEntry(input AwsCryptographyMaterialProvidersTypes.DeleteCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.stormTracker.DeleteCacheEntry(input)

}
func (cmc *StormTrackingCMC) DeleteCacheEntry_k(input AwsCryptographyMaterialProvidersTypes.DeleteCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.stormTracker.DeleteCacheEntry(input)
}

func (cmc *StormTrackingCMC) String() string {
	return "StormTrackerCMC"
}

func (cmc *StormTrackingCMC) GetFromInner(input AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.stormTracker.GetFromCache(input)
}
