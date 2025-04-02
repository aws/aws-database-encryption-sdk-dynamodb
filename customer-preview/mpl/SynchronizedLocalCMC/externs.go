package SynchronizedLocalCMC

import (
	"sync"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/LocalCMC"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
)

type SynchronizedLocalCMC struct {
	localCMC *LocalCMC.LocalCMC
	sync.Mutex
}

func New_SynchronizedLocalCMC_(localCMC *LocalCMC.LocalCMC) *SynchronizedLocalCMC {
	return &SynchronizedLocalCMC{localCMC: localCMC}
}

func (cmc *SynchronizedLocalCMC) PutCacheEntry(input AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.localCMC.PutCacheEntry(input)
}
func (cmc *SynchronizedLocalCMC) PutCacheEntry_k(input AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.localCMC.PutCacheEntry_k(input)
}
func (cmc *SynchronizedLocalCMC) UpdateUsageMetadata(input AwsCryptographyMaterialProvidersTypes.UpdateUsageMetadataInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.localCMC.UpdateUsageMetadata(input)
}
func (cmc *SynchronizedLocalCMC) UpdateUsageMetadata_k(input AwsCryptographyMaterialProvidersTypes.UpdateUsageMetadataInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.localCMC.UpdateUsageMetadata_k(input)
}
func (cmc *SynchronizedLocalCMC) GetCacheEntry(input AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.localCMC.GetCacheEntry(input)
}
func (cmc *SynchronizedLocalCMC) GetCacheEntry_k(input AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.localCMC.GetCacheEntry_k(input)
}
func (cmc *SynchronizedLocalCMC) DeleteCacheEntry(input AwsCryptographyMaterialProvidersTypes.DeleteCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.localCMC.DeleteCacheEntry(input)
}
func (cmc *SynchronizedLocalCMC) DeleteCacheEntry_k(input AwsCryptographyMaterialProvidersTypes.DeleteCacheEntryInput) Wrappers.Result {
	cmc.Lock()
	defer cmc.Unlock()
	return cmc.localCMC.DeleteCacheEntry_k(input)
}

func (*SynchronizedLocalCMC) String() string {
	return "SynchronizedLocalCMC"
}
