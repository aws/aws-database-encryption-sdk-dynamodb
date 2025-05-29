package HMAC

import (
	"crypto/hmac"
	"crypto/sha256"
	"crypto/sha512"
	"hash"

	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
)

type HMac struct {
	algo func() hash.Hash
	hash hash.Hash
}

type CompanionStruct_HMac_ struct {
}

var Companion_HMac_ = CompanionStruct_HMac_{}

func Digest(hMacInput AwsCryptographyPrimitivesTypes.HMacInput) Wrappers.Result {
	hMac := Companion_HMac_.Build(hMacInput.Dtor_digestAlgorithm()).Dtor_value().(*HMac)
	hMac.Init(hMacInput.Dtor_key())
	hMac.BlockUpdate(hMacInput.Dtor_message())
	return Companion_Default___.CreateDigestSuccess(hMac.GetResult())
}

func (hMac *HMac) Init(key dafny.Sequence) {
	keyBytes := dafny.ToByteArray(key)
	hMac.hash = hmac.New(hMac.algo, keyBytes)
}

func (hMac *HMac) BlockUpdate(message dafny.Sequence) {
	_, err := hMac.hash.Write(dafny.ToByteArray(message))
	if err != nil {
		panic(err)
	}
}

func (hMac *HMac) GetResult() dafny.Sequence {
	res := hMac.hash.Sum(nil)
	// reset the hash for future use. or maybe reinit it like rust?
	hMac.hash.Reset()
	return dafny.SeqOfBytes(res)
}

func (CompanionStruct_HMac_) Build(digestAlgo AwsCryptographyPrimitivesTypes.DigestAlgorithm) Wrappers.Result {
	var algo func() hash.Hash
	if digestAlgo.Is_SHA__256() {
		algo = sha256.New
	}
	if digestAlgo.Is_SHA__384() {
		algo = sha512.New384
	}
	if digestAlgo.Is_SHA__512() {
		algo = sha512.New
	}

	native := HMac{
		algo: algo,
	}
	return Wrappers.Companion_Result_.Create_Success_(&native)
}
