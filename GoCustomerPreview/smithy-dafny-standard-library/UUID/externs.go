package UUID

import (
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
	"github.com/google/uuid"
)

func ToByteArray(seq dafny.Sequence) Wrappers.Result {
	var s string
	for i := dafny.Iterate(seq); ; {
		val, notEndOfSequence := i()
		if notEndOfSequence {
			s = s + string(val.(dafny.Char))
		} else {
			break
		}
	}
	uuidString := uuid.MustParse(s)
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(uuidString[:]))
}

func FromByteArray(seq dafny.Sequence) Wrappers.Result {
	byteArray := dafny.ToByteArray(seq)
	fromBytes, err := uuid.FromBytes(byteArray)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(err)
	}
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfChars([]dafny.Char(fromBytes.String())...))
}

func GenerateUUID() Wrappers.Result {
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfChars([]dafny.Char(uuid.NewString())...))
}
