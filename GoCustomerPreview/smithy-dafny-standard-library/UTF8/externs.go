package UTF8

import (
	"fmt"
	"math"
	"unicode/utf16"
	"unicode/utf8"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

// The following constants are copied from the Go utf16 lib and are used
// to check the validity of the utf16 surrogate pairs.
const (
	// 0xd800-0xdc00 encodes the high 10 bits of a pair.
	// 0xdc00-0xe000 encodes the low 10 bits of a pair.
	surr1 = 0xd800
	surr2 = 0xdc00
	surr3 = 0xe000
)

//IMP: The below extern implementations are only compatible
//with unicode-char:false transpiled code.

// Decode decodes utf8 encoded Go rune to dafny encoded utf16 char sequence
// Anything we receive here is supposed to be utf8 encoded Go rune.
// And since this extern is for unicode-char:false,
// we need to encode the result in compatible dafny utf16 string before returning
// the result.
func Decode(utf8EncodedDafnySeq dafny.Sequence) Wrappers.Result {
	res, err := DecodeFromNativeGoByteArray(dafny.ToByteArray(utf8EncodedDafnySeq))
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(dafny.SeqOfString(err.Error()))
	}

	return Wrappers.Companion_Result_.Create_Success_(res)
}

// Encode encodes utf16 encoded dafny char (rune) to utf-8 Go rune sequence.
// Anything we receive here is supposed to be utf16 encoded Go rune
// since this extern is for unicode-char:false.
func Encode(utf16EncodedDafnySeq dafny.Sequence) Wrappers.Result {
	utf8EncodedBytes, err := decodeUtf16(utf16EncodedDafnySeq)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(dafny.SeqOfString(err.Error()))
	}
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(utf8EncodedBytes))
}

// This method is to be called from the Type Conversion layer.
// We reuse the same method so that all conversions are consistent.
func DecodeFromNativeGoByteArray(utf8EncodedByteArray []byte) (dafny.Sequence, error) {
	if !utf8.Valid(utf8EncodedByteArray) {
		return nil, fmt.Errorf("invalid utf8 encoded sequence: %v", utf8EncodedByteArray)
	}
	utf16Encoded := utf16.Encode([]rune(string(utf8EncodedByteArray)))
	var dafnyCharArray []dafny.Char
	for _, c := range utf16Encoded {
		dafnyCharArray = append(dafnyCharArray, dafny.Char(c))
	}
	return dafny.SeqOfChars(dafnyCharArray...), nil
}

// decode appends to buf the Unicode code point sequence represented
// by the UTF-16 encoding seq, then encode the code point as utf8 and return the utf8 buffer
func decodeUtf16(seq dafny.Sequence) ([]byte, error) {
	utf8EncodedBytes := []byte{}

	for i := dafny.Iterate(seq); ; {
		firstVal, firstValExists := i()
		if !firstValExists {
			// Iterator has finished, return the buffer
			return utf8EncodedBytes, nil
		} else {
			var ar rune

			// We should be able to rely on dafny that anything inside the seq is utf16 encoded
			// with unicode-char: false. But given the Long Psi issue, it's better to be safe.
			// First check if it's a dafny.Char type, then check if it's within the limits of uint16.
			firstChar, firstValIsAChar := firstVal.(dafny.Char)
			if !firstValIsAChar || firstChar > math.MaxUint16 || firstChar < 0 {
				return nil, fmt.Errorf("invalid utf16 encoded sequence: %v", seq)
			}

			// Downcast to uint16
			switch r1 := uint16(firstChar); {

			case r1 < surr1, surr3 <= r1:
				// normal rune
				ar = rune(r1)

			case utf16.IsSurrogate(rune(r1)):
				// If firstVal is surrogate, then we need the secondVal to construct the pair
				secondVal, ok := i()

				// Same sanity check as line 84
				secondChar, secondValIsAChar := secondVal.(dafny.Char)
				if !ok || !secondValIsAChar || secondChar > math.MaxUint16 || secondChar < 0 {
					return nil, fmt.Errorf("invalid utf16 encoded sequence: %v", seq)
				}

				// Check if the secondVal is within the valid low surrogate range
				if surr2 <= uint16(secondChar) && uint16(secondChar) < surr3 {
					// valid surrogate sequence
					ar = utf16.DecodeRune(rune(r1), rune(uint16(secondChar)))
				} else {
					return nil, fmt.Errorf("invalid utf16 encoded sequence: %v", seq)
				}
			default:
				return nil, fmt.Errorf("invalid utf16 encoded sequence: %v", seq)
			}

			// Create the buffer (upto 4 bytes) to hold the utf8 rune
			buf := make([]byte, utf8.RuneLen(ar))
			n := utf8.EncodeRune(buf, ar)

			// Append to the result
			utf8EncodedBytes = append(utf8EncodedBytes, buf[:n]...)
		}
	}
}
