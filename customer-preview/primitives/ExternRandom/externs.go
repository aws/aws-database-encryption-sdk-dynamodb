package ExternRandom

import (
	"crypto/rand"
	"fmt"

	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
)

func GenerateBytes(length int32) Wrappers.Result {
	buffer := make([]byte, length)
	n, err := rand.Read(buffer)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(fmt.Errorf("failed to generate random bytes: %w", err))
	}
	// Check if the number of bytes read is equal to the requested length
	if int32(n) != length {
		return Wrappers.Companion_Result_.Create_Failure_(fmt.Errorf("failed to generate random bytes: read %d bytes instead of %d", n, length))
	}
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(buffer))
}
