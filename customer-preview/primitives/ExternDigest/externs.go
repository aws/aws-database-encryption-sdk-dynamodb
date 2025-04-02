package ExternDigest

import (
	"crypto"
	"fmt"
	"hash"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

func Digest(algorithm AwsCryptographyPrimitivesTypes.DigestAlgorithm, message dafny.Sequence) Wrappers.Result {
	hash, _ := getNativeDigestAlgorithm(algorithm)
	hash.Write(dafny.ToByteArray(message))
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(hash.Sum(nil)))
}

func getNativeDigestAlgorithm(algorithm AwsCryptographyPrimitivesTypes.DigestAlgorithm) (hash.Hash, error) {
	switch algorithm {
	case AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__256_():
		return crypto.SHA256.New(), nil
	case AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_():
		return crypto.SHA384.New(), nil
	case AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__512_():
		return crypto.SHA512.New(), nil
	default:
		return nil, fmt.Errorf("invalid curve specification: %s not supported", algorithm)
	}
}
