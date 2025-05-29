package OsLang

import (
	"runtime"

	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

var m_OsLang = CompanionStruct_Default___{}

func (CompanionStruct_Default___) GetOsShort() dafny.Sequence {
	return GetOsShort()
}
func GetOsShort() dafny.Sequence {
	var x = runtime.GOOS
	if x == "darwin" {
		x = "MacOS"
	} else if x == "windows" {
		x = "Windows"
	} else if x == "netbsd" {
		x = "Unix"
	} else if x == "openbsd" {
		x = "Unix"
	} else if x == "linux" {
		x = "Unix"
	} else if x == "freebsd" {
		x = "Unix"
	} else {
		x = "Other"
	}
	return dafny.SeqOfChars([]dafny.Char(x)...)
}

func (CompanionStruct_Default___) GetLanguageShort() dafny.Sequence {
	return GetLanguageShort()
}
func GetLanguageShort() dafny.Sequence {
	return dafny.SeqOfChars([]dafny.Char("Go")...)
}

func (CompanionStruct_Default___) GetOsLong() dafny.Sequence {
	return GetOsLong()
}
func GetOsLong() dafny.Sequence {
	return dafny.SeqOfChars([]dafny.Char(runtime.GOOS + " " + runtime.GOARCH)...)
}

func (CompanionStruct_Default___) GetLanguageLong() dafny.Sequence {
	return GetLanguageLong()
}
func GetLanguageLong() dafny.Sequence {
	return dafny.SeqOfChars([]dafny.Char(runtime.Version())...)
}
