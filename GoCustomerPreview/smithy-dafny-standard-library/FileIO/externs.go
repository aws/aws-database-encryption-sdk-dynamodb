package FileIO

import (
	"io/ioutil"
	os "os"
	"path/filepath"

	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

// TODO: Drop this once we fix the DafnyLibraries.FileIO extern
var m_DafnyLibraries struct {
	FileIO CompanionStruct_Default___
}

func (_static CompanionStruct_Default___) INTERNAL_ReadBytesFromFile(path _dafny.Sequence) (isError bool, bytesRead _dafny.Sequence, errorMsg _dafny.Sequence) {
	p := func() string {
		var s string
		for i := _dafny.Iterate(path); ; {
			val, notEndOfSequence := i()
			if notEndOfSequence {
				s = s + string(val.(_dafny.Char))
			} else {
				return s
			}
		}
	}()

	dat, err := ioutil.ReadFile(p)
	if err != nil {
		return true, _dafny.EmptySeq, _dafny.SeqOfChars([]dafny.Char(err.Error())...)
	}
	datAsSequence := _dafny.SeqOfBytes(dat)
	return false, datAsSequence, _dafny.EmptySeq
}

func (_static CompanionStruct_Default___) INTERNAL_WriteBytesToFile(path _dafny.Sequence, bytes _dafny.Sequence) (isError bool, errorMsg _dafny.Sequence) {
	p := func() string {
		var s string
		for i := _dafny.Iterate(path); ; {
			val, notEndOfSequence := i()
			if notEndOfSequence {
				s = s + string(val.(_dafny.Char))
			} else {
				return s
			}
		}
	}()

	// Create directories
	os.MkdirAll(filepath.Dir(p), os.ModePerm)
	bytesArray := _dafny.ToByteArray(bytes)
	err := ioutil.WriteFile(p, bytesArray, 0644)
	if err != nil {
		return true, _dafny.SeqOfChars([]dafny.Char(err.Error())...)
	}
	return false, _dafny.EmptySeq
}

func (_static CompanionStruct_Default___) INTERNAL_AppendBytesToFile(path _dafny.Sequence, bytes _dafny.Sequence) (isError bool, errorMsg _dafny.Sequence) {
	p := func() string {
		var s string
		for i := _dafny.Iterate(path); ; {
			val, notEndOfSequence := i()
			if notEndOfSequence {
				s = s + string(val.(_dafny.Char))
			} else {
				return s
			}
		}
	}()

	// Create directories
	err := os.MkdirAll(filepath.Dir(p), os.ModePerm)
	if err != nil {
		return true, _dafny.SeqOfChars([]dafny.Char(err.Error())...)
	}

	bytesArray := _dafny.ToByteArray(bytes)

	f, err := os.OpenFile(p, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		return true, _dafny.SeqOfChars([]dafny.Char(err.Error())...)
	}

	if _, err := f.Write(bytesArray); err != nil {
		return true, _dafny.SeqOfChars([]dafny.Char(err.Error())...)
	}

	if err := f.Close(); err != nil {
		return true, _dafny.SeqOfChars([]dafny.Char(err.Error())...)
	}

	return false, _dafny.EmptySeq
}
