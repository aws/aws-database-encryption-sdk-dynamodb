// Package GetOpt
// Dafny module GetOpt compiled into Go

package GetOpt

import (
	os "os"

	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_DivInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternals"
	m_DivInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternalsNonlinear"
	m_DivMod "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivMod"
	m_FileIO "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FileIO"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m_GeneralInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GeneralInternals"
	m_HexStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/HexStrings"
	m_Logarithm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Logarithm"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_ModInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/ModInternals"
	m_ModInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/ModInternalsNonlinear"
	m_Mul "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Mul"
	m_MulInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/MulInternals"
	m_MulInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/MulInternalsNonlinear"
	m_Power "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Power"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq"
	m_Seq_MergeSort "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq_MergeSort"
	m_Sorting "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Sorting"
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m__System "github.com/dafny-lang/DafnyRuntimeGo/v4/System_"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

var _ = os.Args
var _ _dafny.Dummy__
var _ m__System.Dummy__
var _ m_Wrappers.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m_BoundedInts.Dummy__
var _ m__Unicode.Dummy__
var _ m_Functions.Dummy__
var _ m_Utf8EncodingForm.Dummy__
var _ m_Utf16EncodingForm.Dummy__
var _ m_UnicodeStrings.Dummy__
var _ m_FileIO.Dummy__
var _ m_GeneralInternals.Dummy__
var _ m_MulInternalsNonlinear.Dummy__
var _ m_MulInternals.Dummy__
var _ m_Mul.Dummy__
var _ m_ModInternalsNonlinear.Dummy__
var _ m_DivInternalsNonlinear.Dummy__
var _ m_ModInternals.Dummy__
var _ m_DivInternals.Dummy__
var _ m_DivMod.Dummy__
var _ m_Power.Dummy__
var _ m_Logarithm.Dummy__
var _ m_StandardLibraryInterop.Dummy__
var _ m_StandardLibrary_UInt.Dummy__
var _ m_StandardLibrary_MemoryMath.Dummy__
var _ m_StandardLibrary_Sequence.Dummy__
var _ m_StandardLibrary_String.Dummy__
var _ m_StandardLibrary.Dummy__
var _ m_Streams.Dummy__
var _ m_Sorting.Dummy__
var _ m_HexStrings.Dummy__

type Dummy__ struct{}

// Definition of class Default__
type Default__ struct {
	dummy byte
}

func New_Default___() *Default__ {
	_this := Default__{}

	return &_this
}

type CompanionStruct_Default___ struct {
}

var Companion_Default___ = CompanionStruct_Default___{}

func (_this *Default__) Equals(other *Default__) bool {
	return _this == other
}

func (_this *Default__) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*Default__)
	return ok && _this.Equals(other)
}

func (*Default__) String() string {
	return "GetOpt.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Example(args _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = output
	var _0_MyOptions _dafny.Sequence
	_ = _0_MyOptions
	_0_MyOptions = _dafny.SeqOf(Companion_Param_.Create_Flag_(_dafny.SeqOfString("foo"), _dafny.SeqOfString("Does foo things"), Companion_Default___.NullChar(), false, false, Companion_Visibility_.Create_Normal_(), _dafny.SeqOfChars(), _dafny.SeqOf()), Companion_Param_.Create_Opt_(_dafny.SeqOfString("two"), _dafny.SeqOfString("Does bar things to thingy"), _dafny.SeqOfString("thingy"), _dafny.Char('t'), Companion_Unused_.Create_UnusedOk_(), false, Companion_Visibility_.Create_Normal_(), _dafny.SeqOfChars(), _dafny.SeqOf(), Companion_Tri_.Create_No_()), Companion_Param_.Create_Command_(Companion_Options_.Create_Options_(_dafny.SeqOfString("command"), _dafny.SeqOfString("Does command stuff"), _dafny.SeqOf(Companion_Param_.Create_Opt_(_dafny.SeqOfString("two"), _dafny.SeqOfString("Does bar things to thingy"), _dafny.SeqOfString("thingy"), _dafny.Char('t'), Companion_Unused_.Create_UnusedOk_(), false, Companion_Visibility_.Create_Normal_(), _dafny.SeqOfChars(), _dafny.SeqOf(), Companion_Tri_.Create_No_()), Companion_Param_.Create_Flag_(_dafny.SeqOfString("foo"), _dafny.SeqOfString("Does foo things"), Companion_Default___.NullChar(), false, false, Companion_Visibility_.Create_Normal_(), _dafny.SeqOfChars(), _dafny.SeqOf())))))
	var _1_opts Options
	_ = _1_opts
	_1_opts = Companion_Options_.Create_Options_(_dafny.SeqOfString("myProg"), _dafny.SeqOfString("does prog stuff"), _0_MyOptions)
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_Parsed_.Default())
	_ = _2_valueOrError0
	_2_valueOrError0 = Companion_Default___.GetOptions(_1_opts, args)
	if (_2_valueOrError0).IsFailure() {
		output = (_2_valueOrError0).PropagateFailure()
		return output
	}
	var _3_x Parsed
	_ = _3_x
	_3_x = (_2_valueOrError0).Extract().(Parsed)
	var _4_h m_Wrappers.Option
	_ = _4_h
	_4_h = Companion_Default___.NeedsHelp(_1_opts, _3_x, _dafny.SeqOfString(""))
	if (_4_h).Is_Some() {
		_dafny.Print(((_4_h).Dtor_value().(_dafny.Sequence)).SetString())
		output = m_Wrappers.Companion_Result_.Create_Success_(true)
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(true)
	return output
	return output
}
func (_static *CompanionStruct_Default___) Filter(f func(interface{}) bool, xs _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, (func() _dafny.Sequence {
			if (f)((xs).Select(0).(interface{})) {
				return _dafny.SeqOf((xs).Select(0).(interface{}))
			}
			return _dafny.SeqOf()
		})())
		var _in0 func(interface{}) bool = f
		_ = _in0
		var _in1 _dafny.Sequence = (xs).Drop(1)
		_ = _in1
		f = _in0
		xs = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) IsHelp(args Parsed) bool {
	return ((_dafny.IntOfUint32(((args).Dtor_params()).Cardinality())).Sign() != 0) && (_dafny.Companion_Sequence_.Equal((((args).Dtor_params()).Select(0).(OneArg)).Dtor_name(), Companion_Default___.HELP__STR()))
}
func (_static *CompanionStruct_Default___) NeedsHelp(opts Options, args Parsed, prefix _dafny.Sequence) m_Wrappers.Option {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if Companion_Default___.IsHelp(args) {
		return m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.GetHelp(opts, prefix))
	} else if ((args).Dtor_subcommand()).Is_Some() {
		var _0_valueOrError0 m_Wrappers.Option = Companion_Default___.GetSubOptions((opts).Dtor_params(), (((args).Dtor_subcommand()).Dtor_value().(Parsed)).Dtor_command(), _dafny.Zero)
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_pos _dafny.Int = (_0_valueOrError0).Extract().(_dafny.Int)
			_ = _1_pos
			var _in0 Options = (((opts).Dtor_params()).Select((_1_pos).Uint32()).(Param)).Dtor_options()
			_ = _in0
			var _in1 Parsed = ((args).Dtor_subcommand()).Dtor_value().(Parsed)
			_ = _in1
			var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(prefix, (args).Dtor_command()), _dafny.SeqOfString(" "))
			_ = _in2
			opts = _in0
			args = _in1
			prefix = _in2
			goto TAIL_CALL_START
		}
	} else {
		return m_Wrappers.Companion_Option_.Create_None_()
	}
}
func (_static *CompanionStruct_Default___) GetHelp(opts Options, prefix _dafny.Sequence) _dafny.Sequence {
	var _0_newOpts _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((opts).Dtor_params(), _dafny.SeqOf(Companion_Default___.HELP__PARAM()))
	_ = _0_newOpts
	var _1_longLen _dafny.Int = Companion_Default___.GetLongLen(_0_newOpts, _dafny.IntOfInt64(6))
	_ = _1_longLen
	var _2_commandLen _dafny.Int = Companion_Default___.GetCommandLen(_0_newOpts, _dafny.Zero)
	_ = _2_commandLen
	if (_2_commandLen).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("USAGE : "), prefix), (opts).Dtor_name()), _dafny.SeqOfString(" [args...]\n")), (opts).Dtor_help()), _dafny.SeqOfString("\n")), Companion_Default___.GetHelp2(_0_newOpts, _1_longLen))
	} else {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("USAGE : "), (opts).Dtor_name()), _dafny.SeqOfString(" [args...] command [args...]\n")), (opts).Dtor_help()), _dafny.SeqOfString("\n")), _dafny.SeqOfString("\nAvailable Commands:\n")), Companion_Default___.GetCmdHelp(_0_newOpts, _2_commandLen)), _dafny.SeqOfString("\nAvailable Options:\n")), Companion_Default___.GetHelp2(_0_newOpts, _1_longLen))
	}
}
func (_static *CompanionStruct_Default___) OptValue(args _dafny.Sequence, arg _dafny.Sequence) m_Wrappers.Option {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else if _dafny.Companion_Sequence_.Equal(((args).Select(0).(OneArg)).Dtor_name(), arg) {
		return ((args).Select(0).(OneArg)).Dtor_value()
	} else {
		var _in0 _dafny.Sequence = (args).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = arg
		_ = _in1
		args = _in0
		arg = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FlagCount(args _dafny.Sequence, arg _dafny.Sequence) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else if _dafny.Companion_Sequence_.Equal(((args).Select(0).(OneArg)).Dtor_name(), arg) {
		_0___accumulator = (_0___accumulator).Plus(_dafny.One)
		var _in0 _dafny.Sequence = (args).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = arg
		_ = _in1
		args = _in0
		arg = _in1
		goto TAIL_CALL_START
	} else {
		var _in2 _dafny.Sequence = (args).Drop(1)
		_ = _in2
		var _in3 _dafny.Sequence = arg
		_ = _in3
		args = _in2
		arg = _in3
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) OptMapLast(args _dafny.Sequence, theMap _dafny.Map) _dafny.Map {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return theMap
	} else if (((args).Select(0).(OneArg)).Dtor_value()).Is_Some() {
		var _in0 _dafny.Sequence = (args).Drop(1)
		_ = _in0
		var _in1 _dafny.Map = (theMap).Update(((args).Select(0).(OneArg)).Dtor_name(), (((args).Select(0).(OneArg)).Dtor_value()).Dtor_value().(_dafny.Sequence))
		_ = _in1
		args = _in0
		theMap = _in1
		goto TAIL_CALL_START
	} else {
		var _in2 _dafny.Sequence = (args).Drop(1)
		_ = _in2
		var _in3 _dafny.Map = theMap
		_ = _in3
		args = _in2
		theMap = _in3
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FlagsSet(args _dafny.Sequence, theSet _dafny.Set) _dafny.Set {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return theSet
	} else if (((args).Select(0).(OneArg)).Dtor_value()).Is_Some() {
		var _in0 _dafny.Sequence = (args).Drop(1)
		_ = _in0
		var _in1 _dafny.Set = theSet
		_ = _in1
		args = _in0
		theSet = _in1
		goto TAIL_CALL_START
	} else {
		var _in2 _dafny.Sequence = (args).Drop(1)
		_ = _in2
		var _in3 _dafny.Set = (theSet).Union(_dafny.SetOf(((args).Select(0).(OneArg)).Dtor_name()))
		_ = _in3
		args = _in2
		theSet = _in3
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) OptMapList(args _dafny.Sequence, theMap _dafny.Map) _dafny.Map {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return theMap
	} else if (((args).Select(0).(OneArg)).Dtor_value()).Is_Some() {
		if (theMap).Contains(((args).Select(0).(OneArg)).Dtor_name()) {
			var _in0 _dafny.Sequence = (args).Drop(1)
			_ = _in0
			var _in1 _dafny.Map = (theMap).Update(((args).Select(0).(OneArg)).Dtor_name(), _dafny.Companion_Sequence_.Concatenate((theMap).Get(((args).Select(0).(OneArg)).Dtor_name()).(_dafny.Sequence), _dafny.SeqOf((((args).Select(0).(OneArg)).Dtor_value()).Dtor_value().(_dafny.Sequence))))
			_ = _in1
			args = _in0
			theMap = _in1
			goto TAIL_CALL_START
		} else {
			var _in2 _dafny.Sequence = (args).Drop(1)
			_ = _in2
			var _in3 _dafny.Map = (theMap).Update(((args).Select(0).(OneArg)).Dtor_name(), _dafny.SeqOf((((args).Select(0).(OneArg)).Dtor_value()).Dtor_value().(_dafny.Sequence)))
			_ = _in3
			args = _in2
			theMap = _in3
			goto TAIL_CALL_START
		}
	} else {
		var _in4 _dafny.Sequence = (args).Drop(1)
		_ = _in4
		var _in5 _dafny.Map = theMap
		_ = _in5
		args = _in4
		theMap = _in5
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FlagMapCount(args _dafny.Sequence, theMap _dafny.Map) _dafny.Map {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return theMap
	} else if (((args).Select(0).(OneArg)).Dtor_value()).Is_Some() {
		var _in0 _dafny.Sequence = (args).Drop(1)
		_ = _in0
		var _in1 _dafny.Map = theMap
		_ = _in1
		args = _in0
		theMap = _in1
		goto TAIL_CALL_START
	} else if (theMap).Contains(((args).Select(0).(OneArg)).Dtor_name()) {
		var _in2 _dafny.Sequence = (args).Drop(1)
		_ = _in2
		var _in3 _dafny.Map = (theMap).Update(((args).Select(0).(OneArg)).Dtor_name(), ((theMap).Get(((args).Select(0).(OneArg)).Dtor_name()).(_dafny.Int)).Plus(_dafny.One))
		_ = _in3
		args = _in2
		theMap = _in3
		goto TAIL_CALL_START
	} else {
		var _in4 _dafny.Sequence = (args).Drop(1)
		_ = _in4
		var _in5 _dafny.Map = (theMap).Update(((args).Select(0).(OneArg)).Dtor_name(), _dafny.One)
		_ = _in5
		args = _in4
		theMap = _in5
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) FlagSetCheck(args _dafny.Sequence, theSet _dafny.Set) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(theSet)
	} else if (((args).Select(0).(OneArg)).Dtor_value()).Is_Some() {
		if (theSet).Contains(((args).Select(0).(OneArg)).Dtor_name()) {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate arg : "), ((args).Select(0).(OneArg)).Dtor_name()))
		} else {
			var _in0 _dafny.Sequence = (args).Drop(1)
			_ = _in0
			var _in1 _dafny.Set = (theSet).Union(_dafny.SetOf(((args).Select(0).(OneArg)).Dtor_name()))
			_ = _in1
			args = _in0
			theSet = _in1
			goto TAIL_CALL_START
		}
	} else {
		var _in2 _dafny.Sequence = (args).Drop(1)
		_ = _in2
		var _in3 _dafny.Set = theSet
		_ = _in3
		args = _in2
		theSet = _in3
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) OptMapCheck(args _dafny.Sequence, theMap _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(theMap)
	} else if (((args).Select(0).(OneArg)).Dtor_value()).Is_Some() {
		if (theMap).Contains(((args).Select(0).(OneArg)).Dtor_name()) {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate arg : "), ((args).Select(0).(OneArg)).Dtor_name()))
		} else {
			var _in0 _dafny.Sequence = (args).Drop(1)
			_ = _in0
			var _in1 _dafny.Map = (theMap).Update(((args).Select(0).(OneArg)).Dtor_name(), (((args).Select(0).(OneArg)).Dtor_value()).Dtor_value().(_dafny.Sequence))
			_ = _in1
			args = _in0
			theMap = _in1
			goto TAIL_CALL_START
		}
	} else {
		var _in2 _dafny.Sequence = (args).Drop(1)
		_ = _in2
		var _in3 _dafny.Map = theMap
		_ = _in3
		args = _in2
		theMap = _in3
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetHelpHelp(opt Param) _dafny.Sequence {
	if (opt).Is_Command() {
		return _dafny.SeqOfString("")
	} else if (opt).Is_Flag() {
		return (opt).Dtor_help()
	} else {
		return _dafny.Companion_Sequence_.Concatenate((opt).Dtor_help(), (func() _dafny.Sequence {
			if (opt).Required() {
				return _dafny.SeqOfString(" (required)")
			}
			return (func() _dafny.Sequence {
				if (opt).HasDefault() {
					return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString(" (default : "), ((opt).Dtor_unused()).Dtor_val()), _dafny.SeqOfString(")"))
				}
				return _dafny.SeqOfString("")
			})()
		})())
	}
}
func (_static *CompanionStruct_Default___) OneHelp(opt Param, longLen _dafny.Int) _dafny.Sequence {
	if ((opt).Is_Command()) || (!((opt).ShowHelp())) {
		return _dafny.SeqOfString("")
	} else {
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.GetShortHelp(opt), _dafny.SeqOfString("  ")), Companion_Default___.GetLongHelp(opt, longLen)), _dafny.SeqOfString("  ")), Companion_Default___.GetHelpHelp(opt)), _dafny.SeqOfString("\n"))
	}
}
func (_static *CompanionStruct_Default___) GetCommandHelp(opt Param, commandLen _dafny.Int) _dafny.Sequence {
	var _0_name _dafny.Sequence = (func() _dafny.Sequence {
		if (_dafny.IntOfUint32((((opt).Dtor_options()).Dtor_name()).Cardinality())).Cmp(commandLen) < 0 {
			return _dafny.Companion_Sequence_.Concatenate(((opt).Dtor_options()).Dtor_name(), _dafny.SeqCreate(((commandLen).Minus(_dafny.IntOfUint32((((opt).Dtor_options()).Dtor_name()).Cardinality()))).Uint32(), func(coer21 func(_dafny.Int) _dafny.Char) func(_dafny.Int) interface{} {
				return func(arg24 _dafny.Int) interface{} {
					return coer21(arg24)
				}
			}(func(_1_i _dafny.Int) _dafny.Char {
				return _dafny.Char(' ')
			})).SetString())
		}
		return ((opt).Dtor_options()).Dtor_name()
	})()
	_ = _0_name
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_0_name, _dafny.SeqOfString("  ")), ((opt).Dtor_options()).Dtor_help()), _dafny.SeqOfString("\n"))
}
func (_static *CompanionStruct_Default___) GetShortHelp(opt Param) _dafny.Sequence {
	if ((opt).Is_Opt()) || ((opt).Is_Flag()) {
		if ((opt).Dtor_short()) != (Companion_Default___.NullChar()) /* dircomp */ {
			return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("-"), _dafny.SeqOfChars((opt).Dtor_short()))
		} else {
			return _dafny.SeqOfString("  ")
		}
	} else {
		return _dafny.SeqOfString("")
	}
}
func (_static *CompanionStruct_Default___) GetLongHelp(opt Param, longLen _dafny.Int) _dafny.Sequence {
	if ((opt).Is_Opt()) || ((opt).Is_Flag()) {
		var _0_tmp _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("--"), (opt).Dtor_name()), (func() _dafny.Sequence {
			if (opt).Is_Opt() {
				return _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("="), (opt).Dtor_argName())
			}
			return _dafny.SeqOfString("")
		})())
		_ = _0_tmp
		if (_dafny.IntOfUint32((_0_tmp).Cardinality())).Cmp(longLen) < 0 {
			return _dafny.Companion_Sequence_.Concatenate(_0_tmp, _dafny.SeqCreate(((longLen).Minus(_dafny.IntOfUint32((_0_tmp).Cardinality()))).Uint32(), func(coer22 func(_dafny.Int) _dafny.Char) func(_dafny.Int) interface{} {
				return func(arg25 _dafny.Int) interface{} {
					return coer22(arg25)
				}
			}(func(_1_i _dafny.Int) _dafny.Char {
				return _dafny.Char(' ')
			})).SetString())
		} else {
			return _0_tmp
		}
	} else {
		return _dafny.SeqOfString("")
	}
}
func (_static *CompanionStruct_Default___) GetHelp2(opts _dafny.Sequence, longLen _dafny.Int) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfString(""))
	} else {
		var _1_x _dafny.Sequence = Companion_Default___.OneHelp((opts).Select(0).(Param), longLen)
		_ = _1_x
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _1_x)
		var _in0 _dafny.Sequence = (opts).Drop(1)
		_ = _in0
		var _in1 _dafny.Int = longLen
		_ = _in1
		opts = _in0
		longLen = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetCmdHelp(opts _dafny.Sequence, commandLen _dafny.Int) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOfChars()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOfString(""))
	} else {
		var _1_x _dafny.Sequence = (func() _dafny.Sequence {
			if ((opts).Select(0).(Param)).Is_Command() {
				return Companion_Default___.GetCommandHelp((opts).Select(0).(Param), commandLen)
			}
			return _dafny.SeqOfString("")
		})()
		_ = _1_x
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _1_x)
		var _in0 _dafny.Sequence = (opts).Drop(1)
		_ = _in0
		var _in1 _dafny.Int = commandLen
		_ = _in1
		opts = _in0
		commandLen = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetLongLen(opts _dafny.Sequence, max _dafny.Int) _dafny.Int {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Sign() == 0 {
		return max
	} else {
		var _0_x _dafny.Int = _dafny.IntOfUint32((Companion_Default___.GetLongHelp((opts).Select(0).(Param), _dafny.Zero)).Cardinality())
		_ = _0_x
		var _1_newMax _dafny.Int = (func() _dafny.Int {
			if (_0_x).Cmp(max) > 0 {
				return _0_x
			}
			return max
		})()
		_ = _1_newMax
		var _in0 _dafny.Sequence = (opts).Drop(1)
		_ = _in0
		var _in1 _dafny.Int = _1_newMax
		_ = _in1
		opts = _in0
		max = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetCommandLen(opts _dafny.Sequence, max _dafny.Int) _dafny.Int {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Sign() == 0 {
		return max
	} else {
		var _0_x _dafny.Int = (func() _dafny.Int {
			if ((opts).Select(0).(Param)).Is_Command() {
				return _dafny.IntOfUint32(((((opts).Select(0).(Param)).Dtor_options()).Dtor_name()).Cardinality())
			}
			return _dafny.Zero
		})()
		_ = _0_x
		var _1_newMax _dafny.Int = (func() _dafny.Int {
			if (_0_x).Cmp(max) > 0 {
				return _0_x
			}
			return max
		})()
		_ = _1_newMax
		var _in0 _dafny.Sequence = (opts).Drop(1)
		_ = _in0
		var _in1 _dafny.Int = _1_newMax
		_ = _in1
		opts = _in0
		max = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) AddShortAlias(aliases _dafny.Sequence, shortMap _dafny.Map, name _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((aliases).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(shortMap)
	} else if (shortMap).Contains((aliases).Select(0).(_dafny.Char)) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Short alias '"), (aliases).Subsequence(0, 1)), _dafny.SeqOfString("' for '")), name), _dafny.SeqOfString("' already in use as a short option.")))
	} else {
		var _in0 _dafny.Sequence = (aliases).Drop(1)
		_ = _in0
		var _in1 _dafny.Map = (shortMap).Update((aliases).Select(0).(_dafny.Char), name)
		_ = _in1
		var _in2 _dafny.Sequence = name
		_ = _in2
		aliases = _in0
		shortMap = _in1
		name = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) AddLongAlias(aliases _dafny.Sequence, longMap _dafny.Map, opt Param) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((aliases).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(longMap)
	} else if (longMap).Contains((aliases).Select(0).(_dafny.Sequence)) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Long alias '"), (aliases).Select(0).(_dafny.Sequence)), _dafny.SeqOfString("' already in use as a long option.")))
	} else {
		var _in0 _dafny.Sequence = (aliases).Drop(1)
		_ = _in0
		var _in1 _dafny.Map = (longMap).Update((aliases).Select(0).(_dafny.Sequence), opt)
		_ = _in1
		var _in2 Param = opt
		_ = _in2
		aliases = _in0
		longMap = _in1
		opt = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetMaps(opts _dafny.Sequence, longMap _dafny.Map, shortMap _dafny.Map, commandMap _dafny.Map) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(longMap, shortMap, commandMap))
	} else {
		var _0_opt Param = (opts).Select(0).(Param)
		_ = _0_opt
		if (_0_opt).Is_Command() {
			var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!(commandMap).Contains(((_0_opt).Dtor_options()).Dtor_name()), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate command in options : "), ((_0_opt).Dtor_options()).Dtor_name()))
			_ = _1_valueOrError0
			if (_1_valueOrError0).IsFailure() {
				return (_1_valueOrError0).PropagateFailure()
			} else {
				var _in0 _dafny.Sequence = (opts).Drop(1)
				_ = _in0
				var _in1 _dafny.Map = longMap
				_ = _in1
				var _in2 _dafny.Map = shortMap
				_ = _in2
				var _in3 _dafny.Map = (commandMap).Update(((_0_opt).Dtor_options()).Dtor_name(), (_0_opt).Dtor_options())
				_ = _in3
				opts = _in0
				longMap = _in1
				shortMap = _in2
				commandMap = _in3
				goto TAIL_CALL_START
			}
		} else {
			var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!(longMap).Contains((_0_opt).Dtor_name()), _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate long name in options : "), (_0_opt).Dtor_name()))
			_ = _2_valueOrError1
			if (_2_valueOrError1).IsFailure() {
				return (_2_valueOrError1).PropagateFailure()
			} else {
				var _3_newLongMap _dafny.Map = (longMap).Update((_0_opt).Dtor_name(), _0_opt)
				_ = _3_newLongMap
				var _4_valueOrError2 m_Wrappers.Result = Companion_Default___.AddShortAlias((_0_opt).ShortAlias(), shortMap, (_0_opt).Dtor_name())
				_ = _4_valueOrError2
				if (_4_valueOrError2).IsFailure() {
					return (_4_valueOrError2).PropagateFailure()
				} else {
					var _5_newShortMap _dafny.Map = (_4_valueOrError2).Extract().(_dafny.Map)
					_ = _5_newShortMap
					var _6_valueOrError3 m_Wrappers.Result = Companion_Default___.AddLongAlias((_0_opt).LongAlias(), _3_newLongMap, _0_opt)
					_ = _6_valueOrError3
					if (_6_valueOrError3).IsFailure() {
						return (_6_valueOrError3).PropagateFailure()
					} else {
						var _7_newLongMap _dafny.Map = (_6_valueOrError3).Extract().(_dafny.Map)
						_ = _7_newLongMap
						if ((_0_opt).Dtor_short()) != (Companion_Default___.NullChar()) /* dircomp */ {
							var _8_short _dafny.Char = (_0_opt).Dtor_short()
							_ = _8_short
							if (_5_newShortMap).Contains(_8_short) {
								return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Duplicate short char in options : '"), _dafny.SeqOfChars(_8_short)), _dafny.SeqOfString("' for ")), (_0_opt).Dtor_name()), _dafny.SeqOfString(" and ")), (_5_newShortMap).Get(_8_short).(_dafny.Sequence)))
							} else {
								var _in4 _dafny.Sequence = (opts).Drop(1)
								_ = _in4
								var _in5 _dafny.Map = (_7_newLongMap).Update((_0_opt).Dtor_name(), _0_opt)
								_ = _in5
								var _in6 _dafny.Map = (_5_newShortMap).Update(_8_short, (_0_opt).Dtor_name())
								_ = _in6
								var _in7 _dafny.Map = commandMap
								_ = _in7
								opts = _in4
								longMap = _in5
								shortMap = _in6
								commandMap = _in7
								goto TAIL_CALL_START
							}
						} else {
							var _in8 _dafny.Sequence = (opts).Drop(1)
							_ = _in8
							var _in9 _dafny.Map = (_7_newLongMap).Update((_0_opt).Dtor_name(), _0_opt)
							_ = _in9
							var _in10 _dafny.Map = _5_newShortMap
							_ = _in10
							var _in11 _dafny.Map = commandMap
							_ = _in11
							opts = _in8
							longMap = _in9
							shortMap = _in10
							commandMap = _in11
							goto TAIL_CALL_START
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) Print(x interface{}) m_Wrappers.Outcome {
	var _hresult m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _hresult
	_dafny.Print(x)
	_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	_hresult = m_Wrappers.Companion_Outcome_.Create_Pass_()
	return _hresult
	return _hresult
}
func (_static *CompanionStruct_Default___) ArgExists(args _dafny.Sequence, name _dafny.Sequence) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return false
	} else if _dafny.Companion_Sequence_.Equal(((args).Select(0).(OneArg)).Dtor_name(), name) {
		return true
	} else {
		var _in0 _dafny.Sequence = (args).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = name
		_ = _in1
		args = _in0
		name = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) PostProcess2(opts _dafny.Sequence, args _dafny.Sequence, newArgs _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(newArgs)
	} else if ((((opts).Select(0).(Param)).Is_Opt()) && (((opts).Select(0).(Param)).Required())) && (!(Companion_Default___.ArgExists(args, ((opts).Select(0).(Param)).Dtor_name()))) {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Option '"), ((opts).Select(0).(Param)).Dtor_name()), _dafny.SeqOfString("' is required, but was not used.")))
	} else if ((((opts).Select(0).(Param)).Is_Opt()) && (((opts).Select(0).(Param)).HasDefault())) && (!(Companion_Default___.ArgExists(args, ((opts).Select(0).(Param)).Dtor_name()))) {
		var _in0 _dafny.Sequence = (opts).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = args
		_ = _in1
		var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(newArgs, _dafny.SeqOf(Companion_OneArg_.Create_OneArg_(((opts).Select(0).(Param)).Dtor_name(), m_Wrappers.Companion_Option_.Create_Some_((((opts).Select(0).(Param)).Dtor_unused()).Dtor_val()))))
		_ = _in2
		opts = _in0
		args = _in1
		newArgs = _in2
		goto TAIL_CALL_START
	} else {
		var _in3 _dafny.Sequence = (opts).Drop(1)
		_ = _in3
		var _in4 _dafny.Sequence = args
		_ = _in4
		var _in5 _dafny.Sequence = newArgs
		_ = _in5
		opts = _in3
		args = _in4
		newArgs = _in5
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) GetSubOptions(opts _dafny.Sequence, name _dafny.Sequence, pos _dafny.Int) m_Wrappers.Option {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Cmp(pos) == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else if (((opts).Select((pos).Uint32()).(Param)).Is_Command()) && (_dafny.Companion_Sequence_.Equal((((opts).Select((pos).Uint32()).(Param)).Dtor_options()).Dtor_name(), name)) {
		return m_Wrappers.Companion_Option_.Create_Some_(pos)
	} else {
		var _in0 _dafny.Sequence = opts
		_ = _in0
		var _in1 _dafny.Sequence = name
		_ = _in1
		var _in2 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in2
		opts = _in0
		name = _in1
		pos = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) PostProcess(opts Options, args Parsed) m_Wrappers.Result {
	var _pat_let_tv0 = args
	_ = _pat_let_tv0
	var _pat_let_tv1 = args
	_ = _pat_let_tv1
	if Companion_Default___.IsHelp(args) {
		return m_Wrappers.Companion_Result_.Create_Success_(args)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.PostProcess2((opts).Dtor_params(), (args).Dtor_params(), _dafny.SeqOf())
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_newParams _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_newParams
			if ((args).Dtor_subcommand()).Is_Some() {
				var _2_optPos m_Wrappers.Option = Companion_Default___.GetSubOptions((opts).Dtor_params(), (((args).Dtor_subcommand()).Dtor_value().(Parsed)).Dtor_command(), _dafny.Zero)
				_ = _2_optPos
				if (_2_optPos).Is_Some() {
					var _3_valueOrError1 m_Wrappers.Result = Companion_Default___.PostProcess((((opts).Dtor_params()).Select(((_2_optPos).Dtor_value().(_dafny.Int)).Uint32()).(Param)).Dtor_options(), ((args).Dtor_subcommand()).Dtor_value().(Parsed))
					_ = _3_valueOrError1
					if (_3_valueOrError1).IsFailure() {
						return (_3_valueOrError1).PropagateFailure()
					} else {
						var _4_sub Parsed = (_3_valueOrError1).Extract().(Parsed)
						_ = _4_sub
						return m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let0_0 Parsed) Parsed {
							return func(_5_dt__update__tmp_h0 Parsed) Parsed {
								return func(_pat_let1_0 m_Wrappers.Option) Parsed {
									return func(_6_dt__update_hsubcommand_h0 m_Wrappers.Option) Parsed {
										return func(_pat_let2_0 _dafny.Sequence) Parsed {
											return func(_7_dt__update_hparams_h0 _dafny.Sequence) Parsed {
												return Companion_Parsed_.Create_Parsed_((_5_dt__update__tmp_h0).Dtor_command(), _7_dt__update_hparams_h0, (_5_dt__update__tmp_h0).Dtor_files(), _6_dt__update_hsubcommand_h0)
											}(_pat_let2_0)
										}(_dafny.Companion_Sequence_.Concatenate((_pat_let_tv0).Dtor_params(), _1_newParams))
									}(_pat_let1_0)
								}(m_Wrappers.Companion_Option_.Create_Some_(_4_sub))
							}(_pat_let0_0)
						}(args))
					}
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Internal error in GetOpt::PostProcess"))
				}
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let3_0 Parsed) Parsed {
					return func(_8_dt__update__tmp_h1 Parsed) Parsed {
						return func(_pat_let4_0 _dafny.Sequence) Parsed {
							return func(_9_dt__update_hparams_h1 _dafny.Sequence) Parsed {
								return Companion_Parsed_.Create_Parsed_((_8_dt__update__tmp_h1).Dtor_command(), _9_dt__update_hparams_h1, (_8_dt__update__tmp_h1).Dtor_files(), (_8_dt__update__tmp_h1).Dtor_subcommand())
							}(_pat_let4_0)
						}(_dafny.Companion_Sequence_.Concatenate((_pat_let_tv1).Dtor_params(), _1_newParams))
					}(_pat_let3_0)
				}(args))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) AllDigits(s _dafny.Sequence) bool {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return true
	} else if ((_dafny.Char('0')) <= ((s).Select(0).(_dafny.Char))) && (((s).Select(0).(_dafny.Char)) <= (_dafny.Char('9'))) {
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		s = _in0
		goto TAIL_CALL_START
	} else {
		return false
	}
}
func (_static *CompanionStruct_Default___) ValidPositional(s _dafny.Sequence) bool {
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return true
	} else if ((s).Select(0).(_dafny.Char)) != (_dafny.Char('-')) /* dircomp */ {
		return true
	} else {
		return Companion_Default___.AllDigits((s).Drop(1))
	}
}
func (_static *CompanionStruct_Default___) TestPositionals(opts _dafny.Sequence, optional m_Wrappers.Option) m_Wrappers.Outcome {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Outcome_.Create_Pass_()
	} else if !(((opts).Select(0).(Param)).Is_Opt()) {
		var _in0 _dafny.Sequence = (opts).Drop(1)
		_ = _in0
		var _in1 m_Wrappers.Option = optional
		_ = _in1
		opts = _in0
		optional = _in1
		goto TAIL_CALL_START
	} else if (((opts).Select(0).(Param)).Dtor_positional()).Equals(Companion_Tri_.Create_No_()) {
		var _in2 _dafny.Sequence = (opts).Drop(1)
		_ = _in2
		var _in3 m_Wrappers.Option = optional
		_ = _in3
		opts = _in2
		optional = _in3
		goto TAIL_CALL_START
	} else if (((opts).Select(0).(Param)).Dtor_positional()).Equals(Companion_Tri_.Create_Maybe_()) {
		var _in4 _dafny.Sequence = (opts).Drop(1)
		_ = _in4
		var _in5 m_Wrappers.Option = m_Wrappers.Companion_Option_.Create_Some_(((opts).Select(0).(Param)).Dtor_name())
		_ = _in5
		opts = _in4
		optional = _in5
		goto TAIL_CALL_START
	} else if (optional).Is_None() {
		var _in6 _dafny.Sequence = (opts).Drop(1)
		_ = _in6
		var _in7 m_Wrappers.Option = optional
		_ = _in7
		opts = _in6
		optional = _in7
		goto TAIL_CALL_START
	} else {
		return m_Wrappers.Companion_Outcome_.Create_Fail_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Required positional argument '"), ((opts).Select(0).(Param)).Dtor_name()), _dafny.SeqOfString("' follows optional positional argument '")), (optional).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString("'.")))
	}
}
func (_static *CompanionStruct_Default___) GetPositionals(opts _dafny.Sequence, args _dafny.Sequence, params _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((opts).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(args, params))
	} else if !(((opts).Select(0).(Param)).Is_Opt()) {
		var _in0 _dafny.Sequence = (opts).Drop(1)
		_ = _in0
		var _in1 _dafny.Sequence = args
		_ = _in1
		var _in2 _dafny.Sequence = params
		_ = _in2
		opts = _in0
		args = _in1
		params = _in2
		goto TAIL_CALL_START
	} else if (((opts).Select(0).(Param)).Dtor_positional()).Equals(Companion_Tri_.Create_No_()) {
		var _in3 _dafny.Sequence = (opts).Drop(1)
		_ = _in3
		var _in4 _dafny.Sequence = args
		_ = _in4
		var _in5 _dafny.Sequence = params
		_ = _in5
		opts = _in3
		args = _in4
		params = _in5
		goto TAIL_CALL_START
	} else if (((opts).Select(0).(Param)).Dtor_positional()).Equals(Companion_Tri_.Create_Yes_()) {
		if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Positional arg '"), ((opts).Select(0).(Param)).Dtor_name()), _dafny.SeqOfString("' is required, but we've run out of arguments.")))
		} else if Companion_Default___.ValidPositional((args).Select(0).(_dafny.Sequence)) {
			var _in6 _dafny.Sequence = (opts).Drop(1)
			_ = _in6
			var _in7 _dafny.Sequence = (args).Drop(1)
			_ = _in7
			var _in8 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(params, _dafny.SeqOf(Companion_OneArg_.Create_OneArg_(((opts).Select(0).(Param)).Dtor_name(), m_Wrappers.Companion_Option_.Create_Some_((args).Select(0).(_dafny.Sequence)))))
			_ = _in8
			opts = _in6
			args = _in7
			params = _in8
			goto TAIL_CALL_START
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Positional arg "), ((opts).Select(0).(Param)).Dtor_name()), _dafny.SeqOfString(" matched with invalid positional value '")), (args).Select(0).(_dafny.Sequence)), _dafny.SeqOfString("'.")))
		}
	} else {
		if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(args, params))
		} else if Companion_Default___.ValidPositional((args).Select(0).(_dafny.Sequence)) {
			var _in9 _dafny.Sequence = (opts).Drop(1)
			_ = _in9
			var _in10 _dafny.Sequence = (args).Drop(1)
			_ = _in10
			var _in11 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(params, _dafny.SeqOf(Companion_OneArg_.Create_OneArg_(((opts).Select(0).(Param)).Dtor_name(), m_Wrappers.Companion_Option_.Create_Some_((args).Select(0).(_dafny.Sequence)))))
			_ = _in11
			opts = _in9
			args = _in10
			params = _in11
			goto TAIL_CALL_START
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(args, params))
		}
	}
}
func (_static *CompanionStruct_Default___) GetOptions(opts Options, args _dafny.Sequence) m_Wrappers.Result {
	var _0_newOpts _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((opts).Dtor_params(), _dafny.SeqOf(Companion_Default___.HELP__PARAM()))
	_ = _0_newOpts
	var _1_inherits _dafny.Sequence = Companion_Default___.Filter(func(coer23 func(Param) bool) func(interface{}) bool {
		return func(arg26 interface{}) bool {
			return coer23(arg26.(Param))
		}
	}(func(_2_o Param) bool {
		return (_2_o).Inherits()
	}), _0_newOpts)
	_ = _1_inherits
	var _3_valueOrError0 m_Wrappers.Outcome = Companion_Default___.TestPositionals(_0_newOpts, m_Wrappers.Companion_Option_.Create_None_())
	_ = _3_valueOrError0
	if (_3_valueOrError0).IsFailure() {
		return (_3_valueOrError0).PropagateFailure()
	} else {
		var _4_valueOrError1 m_Wrappers.Result = Companion_Default___.GetPositionals(_0_newOpts, (args).Drop(1), _dafny.SeqOf())
		_ = _4_valueOrError1
		if (_4_valueOrError1).IsFailure() {
			return (_4_valueOrError1).PropagateFailure()
		} else {
			var _let_tmp_rhs0 _dafny.Tuple = (_4_valueOrError1).Extract().(_dafny.Tuple)
			_ = _let_tmp_rhs0
			var _5_newArgs _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Sequence)
			_ = _5_newArgs
			var _6_params _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Sequence)
			_ = _6_params
			var _7_valueOrError2 m_Wrappers.Result = Companion_Default___.GetMaps(_0_newOpts, _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap())
			_ = _7_valueOrError2
			if (_7_valueOrError2).IsFailure() {
				return (_7_valueOrError2).PropagateFailure()
			} else {
				var _let_tmp_rhs1 _dafny.Tuple = (_7_valueOrError2).Extract().(_dafny.Tuple)
				_ = _let_tmp_rhs1
				var _8_longMap _dafny.Map = (*(_let_tmp_rhs1).IndexInt(0)).(_dafny.Map)
				_ = _8_longMap
				var _9_shortMap _dafny.Map = (*(_let_tmp_rhs1).IndexInt(1)).(_dafny.Map)
				_ = _9_shortMap
				var _10_commandMap _dafny.Map = (*(_let_tmp_rhs1).IndexInt(2)).(_dafny.Map)
				_ = _10_commandMap
				var _11_context Context = Companion_Context_.Create_Context_(_8_longMap, _9_shortMap, _1_inherits, _10_commandMap, (args).Select(0).(_dafny.Sequence))
				_ = _11_context
				var _12_valueOrError3 m_Wrappers.Result = Companion_Default___.GetOptions2(_5_newArgs, _11_context, _6_params, _dafny.SeqOf())
				_ = _12_valueOrError3
				if (_12_valueOrError3).IsFailure() {
					return (_12_valueOrError3).PropagateFailure()
				} else {
					var _13_result Parsed = (_12_valueOrError3).Extract().(Parsed)
					_ = _13_result
					return Companion_Default___.PostProcess(opts, _13_result)
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) IndexOf(xs _dafny.Sequence, v interface{}) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.Zero
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if _dafny.AreEqual((xs).Select(0).(interface{}), v) {
		return (_dafny.Zero).Plus(_0___accumulator)
	} else {
		_0___accumulator = (_0___accumulator).Plus(_dafny.One)
		var _in0 _dafny.Sequence = (xs).Drop(1)
		_ = _in0
		var _in1 interface{} = v
		_ = _in1
		xs = _in0
		v = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) SplitOnce(s _dafny.Sequence, delim interface{}) _dafny.Tuple {
	var _0_i _dafny.Int = Companion_Default___.IndexOf(s, delim)
	_ = _0_i
	return _dafny.TupleOf((s).Take((_0_i).Uint32()), (s).Drop(((_0_i).Plus(_dafny.One)).Uint32()))
}
func (_static *CompanionStruct_Default___) GetOptions2(args _dafny.Sequence, context Context, parms _dafny.Sequence, files _dafny.Sequence) m_Wrappers.Result {
	if (_dafny.IntOfUint32((args).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_Parsed_.Create_Parsed_((context).Dtor_command(), parms, files, m_Wrappers.Companion_Option_.Create_None_()))
	} else if ((context).Dtor_commands()).Contains((args).Select(0).(_dafny.Sequence)) {
		var _0_inherits _dafny.Sequence = Companion_Default___.Filter(func(coer24 func(Param) bool) func(interface{}) bool {
			return func(arg27 interface{}) bool {
				return coer24(arg27.(Param))
			}
		}(func(_1_o Param) bool {
			return (_1_o).Inherits()
		}), (((context).Dtor_commands()).Get((args).Select(0).(_dafny.Sequence)).(Options)).Dtor_params())
		_ = _0_inherits
		var _2_newOpts _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate((((context).Dtor_commands()).Get((args).Select(0).(_dafny.Sequence)).(Options)).Dtor_params(), (context).Dtor_inherits())
		_ = _2_newOpts
		var _3_valueOrError0 m_Wrappers.Outcome = Companion_Default___.TestPositionals(_2_newOpts, m_Wrappers.Companion_Option_.Create_None_())
		_ = _3_valueOrError0
		if (_3_valueOrError0).IsFailure() {
			return (_3_valueOrError0).PropagateFailure()
		} else {
			var _4_valueOrError1 m_Wrappers.Result = Companion_Default___.GetPositionals(_2_newOpts, (args).Drop(1), _dafny.SeqOf())
			_ = _4_valueOrError1
			if (_4_valueOrError1).IsFailure() {
				return (_4_valueOrError1).PropagateFailure()
			} else {
				var _let_tmp_rhs0 _dafny.Tuple = (_4_valueOrError1).Extract().(_dafny.Tuple)
				_ = _let_tmp_rhs0
				var _5_newArgs _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Sequence)
				_ = _5_newArgs
				var _6_params _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Sequence)
				_ = _6_params
				var _7_valueOrError2 m_Wrappers.Result = Companion_Default___.GetMaps(_2_newOpts, _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap())
				_ = _7_valueOrError2
				if (_7_valueOrError2).IsFailure() {
					return (_7_valueOrError2).PropagateFailure()
				} else {
					var _let_tmp_rhs1 _dafny.Tuple = (_7_valueOrError2).Extract().(_dafny.Tuple)
					_ = _let_tmp_rhs1
					var _8_longMap _dafny.Map = (*(_let_tmp_rhs1).IndexInt(0)).(_dafny.Map)
					_ = _8_longMap
					var _9_shortMap _dafny.Map = (*(_let_tmp_rhs1).IndexInt(1)).(_dafny.Map)
					_ = _9_shortMap
					var _10_commandSet _dafny.Map = (*(_let_tmp_rhs1).IndexInt(2)).(_dafny.Map)
					_ = _10_commandSet
					var _11_newContext Context = Companion_Context_.Create_Context_(_8_longMap, _9_shortMap, _dafny.Companion_Sequence_.Concatenate((context).Dtor_inherits(), _0_inherits), _10_commandSet, (args).Select(0).(_dafny.Sequence))
					_ = _11_newContext
					var _12_lostArgs _dafny.Int = (_dafny.IntOfUint32((args).Cardinality())).Minus(_dafny.IntOfUint32((_5_newArgs).Cardinality()))
					_ = _12_lostArgs
					var _13_valueOrError3 m_Wrappers.Result = Companion_Default___.GetOptions2((args).Drop((_12_lostArgs).Uint32()), _11_newContext, _6_params, _dafny.SeqOf())
					_ = _13_valueOrError3
					if (_13_valueOrError3).IsFailure() {
						return (_13_valueOrError3).PropagateFailure()
					} else {
						var _14_result Parsed = (_13_valueOrError3).Extract().(Parsed)
						_ = _14_result
						return m_Wrappers.Companion_Result_.Create_Success_(Companion_Parsed_.Create_Parsed_((context).Dtor_command(), parms, files, m_Wrappers.Companion_Option_.Create_Some_(_14_result)))
					}
				}
			}
		}
	} else if _dafny.Companion_Sequence_.Equal((args).Select(0).(_dafny.Sequence), _dafny.SeqOfString("--")) {
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_Parsed_.Create_Parsed_((context).Dtor_command(), parms, _dafny.Companion_Sequence_.Concatenate(files, (args).Drop(1)), m_Wrappers.Companion_Option_.Create_None_()))
	} else if _dafny.Companion_Sequence_.IsProperPrefixOf(_dafny.SeqOfString("--"), (args).Select(0).(_dafny.Sequence)) {
		var _15_longOpt _dafny.Sequence = ((args).Select(0).(_dafny.Sequence)).Drop(2)
		_ = _15_longOpt
		if _dafny.Companion_Sequence_.Contains(_15_longOpt, _dafny.Char('=')) {
			var _let_tmp_rhs2 _dafny.Tuple = Companion_Default___.SplitOnce(_15_longOpt, _dafny.Char('='))
			_ = _let_tmp_rhs2
			var _16_opt _dafny.Sequence = (*(_let_tmp_rhs2).IndexInt(0)).(_dafny.Sequence)
			_ = _16_opt
			var _17_arg _dafny.Sequence = (*(_let_tmp_rhs2).IndexInt(1)).(_dafny.Sequence)
			_ = _17_arg
			if ((context).Dtor_longMap()).Contains(_16_opt) {
				if (((context).Dtor_longMap()).Get(_16_opt).(Param)).NeedsArg() {
					return Companion_Default___.GetOptions2((args).Drop(1), context, _dafny.Companion_Sequence_.Concatenate(parms, (((context).Dtor_longMap()).Get(_16_opt).(Param)).MakeArg(m_Wrappers.Companion_Option_.Create_Some_(_17_arg))), files)
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Option "), _16_opt), _dafny.SeqOfString(" does not take an argument, but it got one.")))
				}
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Option "), _16_opt), _dafny.SeqOfString(" not recognized.")))
			}
		} else if ((context).Dtor_longMap()).Contains(_15_longOpt) {
			var _18_opt Param = ((context).Dtor_longMap()).Get(_15_longOpt).(Param)
			_ = _18_opt
			if (_18_opt).NeedsArg() {
				if (_dafny.IntOfUint32((args).Cardinality())).Cmp(_dafny.IntOfInt64(2)) < 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Option "), _15_longOpt), _dafny.SeqOfString(" requires an argument, but didn't get one.")))
				} else {
					return Companion_Default___.GetOptions2((args).Drop(2), context, _dafny.Companion_Sequence_.Concatenate(parms, (_18_opt).MakeArg(m_Wrappers.Companion_Option_.Create_Some_((args).Select(1).(_dafny.Sequence)))), files)
				}
			} else if (((_18_opt).Is_Flag()) && ((_18_opt).Dtor_solo())) && ((((_dafny.IntOfUint32((args).Cardinality())).Cmp(_dafny.One) != 0) || ((_dafny.IntOfUint32((parms).Cardinality())).Sign() != 0)) || ((_dafny.IntOfUint32((files).Cardinality())).Sign() != 0)) {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Option '"), _15_longOpt), _dafny.SeqOfString("' used with other stuff, but must only be used alone.")))
			} else {
				return Companion_Default___.GetOptions2((args).Drop(1), context, _dafny.Companion_Sequence_.Concatenate(parms, (_18_opt).MakeArg(m_Wrappers.Companion_Option_.Create_None_())), files)
			}
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Option "), _15_longOpt), _dafny.SeqOfString(" not recognized.")))
		}
	} else if _dafny.Companion_Sequence_.Equal(_dafny.SeqOfString("-"), (args).Select(0).(_dafny.Sequence)) {
		return Companion_Default___.GetOptions2((args).Drop(1), context, parms, _dafny.Companion_Sequence_.Concatenate(files, _dafny.SeqOf((args).Select(0).(_dafny.Sequence))))
	} else if _dafny.Companion_Sequence_.IsProperPrefixOf(_dafny.SeqOfString("-"), (args).Select(0).(_dafny.Sequence)) {
		var _19_valueOrError4 m_Wrappers.Result = Companion_Default___.GetShort(((args).Select(0).(_dafny.Sequence)).Drop(1), (context).Dtor_longMap(), (context).Dtor_shortMap(), _dafny.SeqOf())
		_ = _19_valueOrError4
		if (_19_valueOrError4).IsFailure() {
			return (_19_valueOrError4).PropagateFailure()
		} else {
			var _let_tmp_rhs3 _dafny.Tuple = (_19_valueOrError4).Extract().(_dafny.Tuple)
			_ = _let_tmp_rhs3
			var _20_newParms _dafny.Sequence = (*(_let_tmp_rhs3).IndexInt(0)).(_dafny.Sequence)
			_ = _20_newParms
			var _21_nextParm m_Wrappers.Option = (*(_let_tmp_rhs3).IndexInt(1)).(m_Wrappers.Option)
			_ = _21_nextParm
			if (_21_nextParm).Is_None() {
				return Companion_Default___.GetOptions2((args).Drop(1), context, _dafny.Companion_Sequence_.Concatenate(parms, _20_newParms), files)
			} else if (_dafny.IntOfUint32((args).Cardinality())).Cmp(_dafny.One) == 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Short option "), _dafny.SeqOfChars((_21_nextParm).Dtor_value().(_dafny.Char))), _dafny.SeqOfString(" requires argument but didn't get one.")))
			} else {
				var _22_longOpt _dafny.Sequence = ((context).Dtor_shortMap()).Get((_21_nextParm).Dtor_value().(_dafny.Char)).(_dafny.Sequence)
				_ = _22_longOpt
				var _23_opt Param = ((context).Dtor_longMap()).Get(_22_longOpt).(Param)
				_ = _23_opt
				return Companion_Default___.GetOptions2((args).Drop(2), context, _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(parms, _20_newParms), (_23_opt).MakeArg(m_Wrappers.Companion_Option_.Create_Some_((args).Select(1).(_dafny.Sequence)))), files)
			}
		}
	} else if (((context).Dtor_commands()).Cardinality()).Sign() == 0 {
		return Companion_Default___.GetOptions2((args).Drop(1), context, parms, _dafny.Companion_Sequence_.Concatenate(files, _dafny.SeqOf((args).Select(0).(_dafny.Sequence))))
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unrecognized command "), (args).Select(0).(_dafny.Sequence)), _dafny.SeqOfString(" for ")), (context).Dtor_command()), _dafny.SeqOfString("\nRun '")), (context).Dtor_command()), _dafny.SeqOfString(" --help' for usage.")))
	}
}
func (_static *CompanionStruct_Default___) GetShort(arg _dafny.Sequence, longMap _dafny.Map, shortMap _dafny.Map, parms _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((arg).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(parms, m_Wrappers.Companion_Option_.Create_None_()))
	} else {
		var _0_ch _dafny.Char = (arg).Select(0).(_dafny.Char)
		_ = _0_ch
		if (shortMap).Contains(_0_ch) {
			var _1_opt _dafny.Sequence = (shortMap).Get(_0_ch).(_dafny.Sequence)
			_ = _1_opt
			if ((longMap).Get(_1_opt).(Param)).NeedsArg() {
				if (_dafny.IntOfUint32((arg).Cardinality())).Cmp(_dafny.One) == 0 {
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(parms, m_Wrappers.Companion_Option_.Create_Some_(_0_ch)))
				} else {
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_dafny.Companion_Sequence_.Concatenate(parms, ((longMap).Get(_1_opt).(Param)).MakeArg(m_Wrappers.Companion_Option_.Create_Some_((arg).Drop(1)))), m_Wrappers.Companion_Option_.Create_None_()))
				}
			} else {
				var _in0 _dafny.Sequence = (arg).Drop(1)
				_ = _in0
				var _in1 _dafny.Map = longMap
				_ = _in1
				var _in2 _dafny.Map = shortMap
				_ = _in2
				var _in3 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(parms, ((longMap).Get(_1_opt).(Param)).MakeArg(m_Wrappers.Companion_Option_.Create_None_()))
				_ = _in3
				arg = _in0
				longMap = _in1
				shortMap = _in2
				parms = _in3
				goto TAIL_CALL_START
			}
		} else {
			return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Short option '"), _dafny.SeqOfChars(_0_ch)), _dafny.SeqOfString("' not recognized.")))
		}
	}
}
func (_static *CompanionStruct_Default___) NullChar() _dafny.Char {
	return _dafny.Char((_dafny.Zero).Int32())
}
func (_static *CompanionStruct_Default___) HELP__STR() _dafny.Sequence {
	return _dafny.SeqOfString("help")
}
func (_static *CompanionStruct_Default___) HELP__PARAM() Param {
	return Companion_Param_.Create_Flag_(Companion_Default___.HELP__STR(), _dafny.SeqOfString("This help text."), Companion_Default___.NullChar(), true, true, Companion_Visibility_.Create_Normal_(), _dafny.SeqOfChars(), _dafny.SeqOf())
}

// End of class Default__

// Definition of datatype Tri
type Tri struct {
	Data_Tri_
}

func (_this Tri) Get_() Data_Tri_ {
	return _this.Data_Tri_
}

type Data_Tri_ interface {
	isTri()
}

type CompanionStruct_Tri_ struct {
}

var Companion_Tri_ = CompanionStruct_Tri_{}

type Tri_Yes struct {
}

func (Tri_Yes) isTri() {}

func (CompanionStruct_Tri_) Create_Yes_() Tri {
	return Tri{Tri_Yes{}}
}

func (_this Tri) Is_Yes() bool {
	_, ok := _this.Get_().(Tri_Yes)
	return ok
}

type Tri_No struct {
}

func (Tri_No) isTri() {}

func (CompanionStruct_Tri_) Create_No_() Tri {
	return Tri{Tri_No{}}
}

func (_this Tri) Is_No() bool {
	_, ok := _this.Get_().(Tri_No)
	return ok
}

type Tri_Maybe struct {
}

func (Tri_Maybe) isTri() {}

func (CompanionStruct_Tri_) Create_Maybe_() Tri {
	return Tri{Tri_Maybe{}}
}

func (_this Tri) Is_Maybe() bool {
	_, ok := _this.Get_().(Tri_Maybe)
	return ok
}

func (CompanionStruct_Tri_) Default() Tri {
	return Companion_Tri_.Create_Yes_()
}

func (_ CompanionStruct_Tri_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_Tri_.Create_Yes_(), true
		case 1:
			return Companion_Tri_.Create_No_(), true
		case 2:
			return Companion_Tri_.Create_Maybe_(), true
		default:
			return Tri{}, false
		}
	}
}

func (_this Tri) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case Tri_Yes:
		{
			return "GetOpt.Tri.Yes"
		}
	case Tri_No:
		{
			return "GetOpt.Tri.No"
		}
	case Tri_Maybe:
		{
			return "GetOpt.Tri.Maybe"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Tri) Equals(other Tri) bool {
	switch _this.Get_().(type) {
	case Tri_Yes:
		{
			_, ok := other.Get_().(Tri_Yes)
			return ok
		}
	case Tri_No:
		{
			_, ok := other.Get_().(Tri_No)
			return ok
		}
	case Tri_Maybe:
		{
			_, ok := other.Get_().(Tri_Maybe)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Tri) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Tri)
	return ok && _this.Equals(typed)
}

func Type_Tri_() _dafny.TypeDescriptor {
	return type_Tri_{}
}

type type_Tri_ struct {
}

func (_this type_Tri_) Default() interface{} {
	return Companion_Tri_.Default()
}

func (_this type_Tri_) String() string {
	return "GetOpt.Tri"
}
func (_this Tri) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Tri{}

// End of datatype Tri

// Definition of datatype Visibility
type Visibility struct {
	Data_Visibility_
}

func (_this Visibility) Get_() Data_Visibility_ {
	return _this.Data_Visibility_
}

type Data_Visibility_ interface {
	isVisibility()
}

type CompanionStruct_Visibility_ struct {
}

var Companion_Visibility_ = CompanionStruct_Visibility_{}

type Visibility_Normal struct {
}

func (Visibility_Normal) isVisibility() {}

func (CompanionStruct_Visibility_) Create_Normal_() Visibility {
	return Visibility{Visibility_Normal{}}
}

func (_this Visibility) Is_Normal() bool {
	_, ok := _this.Get_().(Visibility_Normal)
	return ok
}

type Visibility_Hidden struct {
}

func (Visibility_Hidden) isVisibility() {}

func (CompanionStruct_Visibility_) Create_Hidden_() Visibility {
	return Visibility{Visibility_Hidden{}}
}

func (_this Visibility) Is_Hidden() bool {
	_, ok := _this.Get_().(Visibility_Hidden)
	return ok
}

type Visibility_Deprecated struct {
}

func (Visibility_Deprecated) isVisibility() {}

func (CompanionStruct_Visibility_) Create_Deprecated_() Visibility {
	return Visibility{Visibility_Deprecated{}}
}

func (_this Visibility) Is_Deprecated() bool {
	_, ok := _this.Get_().(Visibility_Deprecated)
	return ok
}

func (CompanionStruct_Visibility_) Default() Visibility {
	return Companion_Visibility_.Create_Normal_()
}

func (_ CompanionStruct_Visibility_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_Visibility_.Create_Normal_(), true
		case 1:
			return Companion_Visibility_.Create_Hidden_(), true
		case 2:
			return Companion_Visibility_.Create_Deprecated_(), true
		default:
			return Visibility{}, false
		}
	}
}

func (_this Visibility) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case Visibility_Normal:
		{
			return "GetOpt.Visibility.Normal"
		}
	case Visibility_Hidden:
		{
			return "GetOpt.Visibility.Hidden"
		}
	case Visibility_Deprecated:
		{
			return "GetOpt.Visibility.Deprecated"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Visibility) Equals(other Visibility) bool {
	switch _this.Get_().(type) {
	case Visibility_Normal:
		{
			_, ok := other.Get_().(Visibility_Normal)
			return ok
		}
	case Visibility_Hidden:
		{
			_, ok := other.Get_().(Visibility_Hidden)
			return ok
		}
	case Visibility_Deprecated:
		{
			_, ok := other.Get_().(Visibility_Deprecated)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Visibility) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Visibility)
	return ok && _this.Equals(typed)
}

func Type_Visibility_() _dafny.TypeDescriptor {
	return type_Visibility_{}
}

type type_Visibility_ struct {
}

func (_this type_Visibility_) Default() interface{} {
	return Companion_Visibility_.Default()
}

func (_this type_Visibility_) String() string {
	return "GetOpt.Visibility"
}
func (_this Visibility) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Visibility{}

// End of datatype Visibility

// Definition of datatype Options
type Options struct {
	Data_Options_
}

func (_this Options) Get_() Data_Options_ {
	return _this.Data_Options_
}

type Data_Options_ interface {
	isOptions()
}

type CompanionStruct_Options_ struct {
}

var Companion_Options_ = CompanionStruct_Options_{}

type Options_Options struct {
	Name   _dafny.Sequence
	Help   _dafny.Sequence
	Params _dafny.Sequence
}

func (Options_Options) isOptions() {}

func (CompanionStruct_Options_) Create_Options_(Name _dafny.Sequence, Help _dafny.Sequence, Params _dafny.Sequence) Options {
	return Options{Options_Options{Name, Help, Params}}
}

func (_this Options) Is_Options() bool {
	_, ok := _this.Get_().(Options_Options)
	return ok
}

func (CompanionStruct_Options_) Default() Options {
	return Companion_Options_.Create_Options_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq)
}

func (_this Options) Dtor_name() _dafny.Sequence {
	return _this.Get_().(Options_Options).Name
}

func (_this Options) Dtor_help() _dafny.Sequence {
	return _this.Get_().(Options_Options).Help
}

func (_this Options) Dtor_params() _dafny.Sequence {
	return _this.Get_().(Options_Options).Params
}

func (_this Options) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Options_Options:
		{
			return "GetOpt.Options.Options" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Help) + ", " + _dafny.String(data.Params) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Options) Equals(other Options) bool {
	switch data1 := _this.Get_().(type) {
	case Options_Options:
		{
			data2, ok := other.Get_().(Options_Options)
			return ok && data1.Name.Equals(data2.Name) && data1.Help.Equals(data2.Help) && data1.Params.Equals(data2.Params)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Options) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Options)
	return ok && _this.Equals(typed)
}

func Type_Options_() _dafny.TypeDescriptor {
	return type_Options_{}
}

type type_Options_ struct {
}

func (_this type_Options_) Default() interface{} {
	return Companion_Options_.Default()
}

func (_this type_Options_) String() string {
	return "GetOpt.Options"
}
func (_this Options) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Options{}

// End of datatype Options

// Definition of datatype Unused
type Unused struct {
	Data_Unused_
}

func (_this Unused) Get_() Data_Unused_ {
	return _this.Data_Unused_
}

type Data_Unused_ interface {
	isUnused()
}

type CompanionStruct_Unused_ struct {
}

var Companion_Unused_ = CompanionStruct_Unused_{}

type Unused_UnusedOk struct {
}

func (Unused_UnusedOk) isUnused() {}

func (CompanionStruct_Unused_) Create_UnusedOk_() Unused {
	return Unused{Unused_UnusedOk{}}
}

func (_this Unused) Is_UnusedOk() bool {
	_, ok := _this.Get_().(Unused_UnusedOk)
	return ok
}

type Unused_Required struct {
}

func (Unused_Required) isUnused() {}

func (CompanionStruct_Unused_) Create_Required_() Unused {
	return Unused{Unused_Required{}}
}

func (_this Unused) Is_Required() bool {
	_, ok := _this.Get_().(Unused_Required)
	return ok
}

type Unused_Default struct {
	Val _dafny.Sequence
}

func (Unused_Default) isUnused() {}

func (CompanionStruct_Unused_) Create_Default_(Val _dafny.Sequence) Unused {
	return Unused{Unused_Default{Val}}
}

func (_this Unused) Is_Default() bool {
	_, ok := _this.Get_().(Unused_Default)
	return ok
}

func (CompanionStruct_Unused_) Default() Unused {
	return Companion_Unused_.Create_UnusedOk_()
}

func (_this Unused) Dtor_val() _dafny.Sequence {
	return _this.Get_().(Unused_Default).Val
}

func (_this Unused) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Unused_UnusedOk:
		{
			return "GetOpt.Unused.UnusedOk"
		}
	case Unused_Required:
		{
			return "GetOpt.Unused.Required"
		}
	case Unused_Default:
		{
			return "GetOpt.Unused.Default" + "(" + _dafny.String(data.Val) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Unused) Equals(other Unused) bool {
	switch data1 := _this.Get_().(type) {
	case Unused_UnusedOk:
		{
			_, ok := other.Get_().(Unused_UnusedOk)
			return ok
		}
	case Unused_Required:
		{
			_, ok := other.Get_().(Unused_Required)
			return ok
		}
	case Unused_Default:
		{
			data2, ok := other.Get_().(Unused_Default)
			return ok && data1.Val.Equals(data2.Val)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Unused) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Unused)
	return ok && _this.Equals(typed)
}

func Type_Unused_() _dafny.TypeDescriptor {
	return type_Unused_{}
}

type type_Unused_ struct {
}

func (_this type_Unused_) Default() interface{} {
	return Companion_Unused_.Default()
}

func (_this type_Unused_) String() string {
	return "GetOpt.Unused"
}
func (_this Unused) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Unused{}

// End of datatype Unused

// Definition of datatype Param
type Param struct {
	Data_Param_
}

func (_this Param) Get_() Data_Param_ {
	return _this.Data_Param_
}

type Data_Param_ interface {
	isParam()
}

type CompanionStruct_Param_ struct {
}

var Companion_Param_ = CompanionStruct_Param_{}

type Param_Opt struct {
	Name       _dafny.Sequence
	Help       _dafny.Sequence
	ArgName    _dafny.Sequence
	Short      _dafny.Char
	Unused     Unused
	Inherit    bool
	Vis        Visibility
	ShortAlias _dafny.Sequence
	LongAlias  _dafny.Sequence
	Positional Tri
}

func (Param_Opt) isParam() {}

func (CompanionStruct_Param_) Create_Opt_(Name _dafny.Sequence, Help _dafny.Sequence, ArgName _dafny.Sequence, Short _dafny.Char, Unused Unused, Inherit bool, Vis Visibility, ShortAlias _dafny.Sequence, LongAlias _dafny.Sequence, Positional Tri) Param {
	return Param{Param_Opt{Name, Help, ArgName, Short, Unused, Inherit, Vis, ShortAlias, LongAlias, Positional}}
}

func (_this Param) Is_Opt() bool {
	_, ok := _this.Get_().(Param_Opt)
	return ok
}

type Param_Flag struct {
	Name       _dafny.Sequence
	Help       _dafny.Sequence
	Short      _dafny.Char
	Solo       bool
	Inherit    bool
	Vis        Visibility
	ShortAlias _dafny.Sequence
	LongAlias  _dafny.Sequence
}

func (Param_Flag) isParam() {}

func (CompanionStruct_Param_) Create_Flag_(Name _dafny.Sequence, Help _dafny.Sequence, Short _dafny.Char, Solo bool, Inherit bool, Vis Visibility, ShortAlias _dafny.Sequence, LongAlias _dafny.Sequence) Param {
	return Param{Param_Flag{Name, Help, Short, Solo, Inherit, Vis, ShortAlias, LongAlias}}
}

func (_this Param) Is_Flag() bool {
	_, ok := _this.Get_().(Param_Flag)
	return ok
}

type Param_Command struct {
	Options Options
}

func (Param_Command) isParam() {}

func (CompanionStruct_Param_) Create_Command_(Options Options) Param {
	return Param{Param_Command{Options}}
}

func (_this Param) Is_Command() bool {
	_, ok := _this.Get_().(Param_Command)
	return ok
}

func (CompanionStruct_Param_) Default() Param {
	return Companion_Param_.Create_Opt_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString(), _dafny.Char('D'), Companion_Unused_.Default(), false, Companion_Visibility_.Default(), _dafny.EmptySeq.SetString(), _dafny.EmptySeq, Companion_Tri_.Default())
}

func (_this Param) Dtor_name() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Param_Opt:
		return data.Name
	default:
		return data.(Param_Flag).Name
	}
}

func (_this Param) Dtor_help() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Param_Opt:
		return data.Help
	default:
		return data.(Param_Flag).Help
	}
}

func (_this Param) Dtor_argName() _dafny.Sequence {
	return _this.Get_().(Param_Opt).ArgName
}

func (_this Param) Dtor_short() _dafny.Char {
	switch data := _this.Get_().(type) {
	case Param_Opt:
		return data.Short
	default:
		return data.(Param_Flag).Short
	}
}

func (_this Param) Dtor_unused() Unused {
	return _this.Get_().(Param_Opt).Unused
}

func (_this Param) Dtor_inherit() bool {
	switch data := _this.Get_().(type) {
	case Param_Opt:
		return data.Inherit
	default:
		return data.(Param_Flag).Inherit
	}
}

func (_this Param) Dtor_vis() Visibility {
	switch data := _this.Get_().(type) {
	case Param_Opt:
		return data.Vis
	default:
		return data.(Param_Flag).Vis
	}
}

func (_this Param) Dtor_shortAlias() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Param_Opt:
		return data.ShortAlias
	default:
		return data.(Param_Flag).ShortAlias
	}
}

func (_this Param) Dtor_longAlias() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Param_Opt:
		return data.LongAlias
	default:
		return data.(Param_Flag).LongAlias
	}
}

func (_this Param) Dtor_positional() Tri {
	return _this.Get_().(Param_Opt).Positional
}

func (_this Param) Dtor_solo() bool {
	return _this.Get_().(Param_Flag).Solo
}

func (_this Param) Dtor_options() Options {
	return _this.Get_().(Param_Command).Options
}

func (_this Param) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Param_Opt:
		{
			return "GetOpt.Param.Opt" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Help) + ", " + _dafny.String(data.ArgName) + ", " + _dafny.String(data.Short) + ", " + _dafny.String(data.Unused) + ", " + _dafny.String(data.Inherit) + ", " + _dafny.String(data.Vis) + ", " + _dafny.String(data.ShortAlias) + ", " + _dafny.String(data.LongAlias) + ", " + _dafny.String(data.Positional) + ")"
		}
	case Param_Flag:
		{
			return "GetOpt.Param.Flag" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Help) + ", " + _dafny.String(data.Short) + ", " + _dafny.String(data.Solo) + ", " + _dafny.String(data.Inherit) + ", " + _dafny.String(data.Vis) + ", " + _dafny.String(data.ShortAlias) + ", " + _dafny.String(data.LongAlias) + ")"
		}
	case Param_Command:
		{
			return "GetOpt.Param.Command" + "(" + _dafny.String(data.Options) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Param) Equals(other Param) bool {
	switch data1 := _this.Get_().(type) {
	case Param_Opt:
		{
			data2, ok := other.Get_().(Param_Opt)
			return ok && data1.Name.Equals(data2.Name) && data1.Help.Equals(data2.Help) && data1.ArgName.Equals(data2.ArgName) && data1.Short == data2.Short && data1.Unused.Equals(data2.Unused) && data1.Inherit == data2.Inherit && data1.Vis.Equals(data2.Vis) && data1.ShortAlias.Equals(data2.ShortAlias) && data1.LongAlias.Equals(data2.LongAlias) && data1.Positional.Equals(data2.Positional)
		}
	case Param_Flag:
		{
			data2, ok := other.Get_().(Param_Flag)
			return ok && data1.Name.Equals(data2.Name) && data1.Help.Equals(data2.Help) && data1.Short == data2.Short && data1.Solo == data2.Solo && data1.Inherit == data2.Inherit && data1.Vis.Equals(data2.Vis) && data1.ShortAlias.Equals(data2.ShortAlias) && data1.LongAlias.Equals(data2.LongAlias)
		}
	case Param_Command:
		{
			data2, ok := other.Get_().(Param_Command)
			return ok && data1.Options.Equals(data2.Options)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Param) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Param)
	return ok && _this.Equals(typed)
}

func Type_Param_() _dafny.TypeDescriptor {
	return type_Param_{}
}

type type_Param_ struct {
}

func (_this type_Param_) Default() interface{} {
	return Companion_Param_.Default()
}

func (_this type_Param_) String() string {
	return "GetOpt.Param"
}
func (_this Param) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Param{}

func (_this Param) NeedsArg() bool {
	{
		return (_this).Is_Opt()
	}
}
func (_this Param) Inherits() bool {
	{
		return (((_this).Is_Opt()) || ((_this).Is_Flag())) && ((_this).Dtor_inherit())
	}
}
func (_this Param) ShowHelp() bool {
	{
		return ((_this).Is_Command()) || (((_this).Dtor_vis()).Equals(Companion_Visibility_.Create_Normal_()))
	}
}
func (_this Param) KeepResult() bool {
	{
		return ((_this).Is_Command()) || (!((_this).Dtor_vis()).Equals(Companion_Visibility_.Create_Deprecated_()))
	}
}
func (_this Param) Name() _dafny.Sequence {
	{
		if (_this).Is_Command() {
			return ((_this).Dtor_options()).Dtor_name()
		} else {
			return (_this).Dtor_name()
		}
	}
}
func (_this Param) MakeArg(value m_Wrappers.Option) _dafny.Sequence {
	{
		if (_this).KeepResult() {
			return _dafny.SeqOf(Companion_OneArg_.Create_OneArg_((_this).Name(), value))
		} else {
			return _dafny.SeqOf()
		}
	}
}
func (_this Param) ShortAlias() _dafny.Sequence {
	{
		if (_this).Is_Command() {
			return _dafny.SeqOfChars()
		} else {
			return (_this).Dtor_shortAlias()
		}
	}
}
func (_this Param) LongAlias() _dafny.Sequence {
	{
		if (_this).Is_Command() {
			return _dafny.SeqOf()
		} else {
			return (_this).Dtor_longAlias()
		}
	}
}
func (_this Param) Required() bool {
	{
		return ((_this).Is_Opt()) && (((_this).Dtor_unused()).Is_Required())
	}
}
func (_this Param) HasDefault() bool {
	{
		return ((_this).Is_Opt()) && (((_this).Dtor_unused()).Is_Default())
	}
}

// End of datatype Param

// Definition of datatype OneArg
type OneArg struct {
	Data_OneArg_
}

func (_this OneArg) Get_() Data_OneArg_ {
	return _this.Data_OneArg_
}

type Data_OneArg_ interface {
	isOneArg()
}

type CompanionStruct_OneArg_ struct {
}

var Companion_OneArg_ = CompanionStruct_OneArg_{}

type OneArg_OneArg struct {
	Name  _dafny.Sequence
	Value m_Wrappers.Option
}

func (OneArg_OneArg) isOneArg() {}

func (CompanionStruct_OneArg_) Create_OneArg_(Name _dafny.Sequence, Value m_Wrappers.Option) OneArg {
	return OneArg{OneArg_OneArg{Name, Value}}
}

func (_this OneArg) Is_OneArg() bool {
	_, ok := _this.Get_().(OneArg_OneArg)
	return ok
}

func (CompanionStruct_OneArg_) Default() OneArg {
	return Companion_OneArg_.Create_OneArg_(_dafny.EmptySeq.SetString(), m_Wrappers.Companion_Option_.Default())
}

func (_this OneArg) Dtor_name() _dafny.Sequence {
	return _this.Get_().(OneArg_OneArg).Name
}

func (_this OneArg) Dtor_value() m_Wrappers.Option {
	return _this.Get_().(OneArg_OneArg).Value
}

func (_this OneArg) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case OneArg_OneArg:
		{
			return "GetOpt.OneArg.OneArg" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Value) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this OneArg) Equals(other OneArg) bool {
	switch data1 := _this.Get_().(type) {
	case OneArg_OneArg:
		{
			data2, ok := other.Get_().(OneArg_OneArg)
			return ok && data1.Name.Equals(data2.Name) && data1.Value.Equals(data2.Value)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this OneArg) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(OneArg)
	return ok && _this.Equals(typed)
}

func Type_OneArg_() _dafny.TypeDescriptor {
	return type_OneArg_{}
}

type type_OneArg_ struct {
}

func (_this type_OneArg_) Default() interface{} {
	return Companion_OneArg_.Default()
}

func (_this type_OneArg_) String() string {
	return "GetOpt.OneArg"
}
func (_this OneArg) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = OneArg{}

// End of datatype OneArg

// Definition of datatype Parsed
type Parsed struct {
	Data_Parsed_
}

func (_this Parsed) Get_() Data_Parsed_ {
	return _this.Data_Parsed_
}

type Data_Parsed_ interface {
	isParsed()
}

type CompanionStruct_Parsed_ struct {
}

var Companion_Parsed_ = CompanionStruct_Parsed_{}

type Parsed_Parsed struct {
	Command    _dafny.Sequence
	Params     _dafny.Sequence
	Files      _dafny.Sequence
	Subcommand m_Wrappers.Option
}

func (Parsed_Parsed) isParsed() {}

func (CompanionStruct_Parsed_) Create_Parsed_(Command _dafny.Sequence, Params _dafny.Sequence, Files _dafny.Sequence, Subcommand m_Wrappers.Option) Parsed {
	return Parsed{Parsed_Parsed{Command, Params, Files, Subcommand}}
}

func (_this Parsed) Is_Parsed() bool {
	_, ok := _this.Get_().(Parsed_Parsed)
	return ok
}

func (CompanionStruct_Parsed_) Default() Parsed {
	return Companion_Parsed_.Create_Parsed_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, _dafny.EmptySeq, m_Wrappers.Companion_Option_.Default())
}

func (_this Parsed) Dtor_command() _dafny.Sequence {
	return _this.Get_().(Parsed_Parsed).Command
}

func (_this Parsed) Dtor_params() _dafny.Sequence {
	return _this.Get_().(Parsed_Parsed).Params
}

func (_this Parsed) Dtor_files() _dafny.Sequence {
	return _this.Get_().(Parsed_Parsed).Files
}

func (_this Parsed) Dtor_subcommand() m_Wrappers.Option {
	return _this.Get_().(Parsed_Parsed).Subcommand
}

func (_this Parsed) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Parsed_Parsed:
		{
			return "GetOpt.Parsed.Parsed" + "(" + _dafny.String(data.Command) + ", " + _dafny.String(data.Params) + ", " + _dafny.String(data.Files) + ", " + _dafny.String(data.Subcommand) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Parsed) Equals(other Parsed) bool {
	switch data1 := _this.Get_().(type) {
	case Parsed_Parsed:
		{
			data2, ok := other.Get_().(Parsed_Parsed)
			return ok && data1.Command.Equals(data2.Command) && data1.Params.Equals(data2.Params) && data1.Files.Equals(data2.Files) && data1.Subcommand.Equals(data2.Subcommand)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Parsed) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Parsed)
	return ok && _this.Equals(typed)
}

func Type_Parsed_() _dafny.TypeDescriptor {
	return type_Parsed_{}
}

type type_Parsed_ struct {
}

func (_this type_Parsed_) Default() interface{} {
	return Companion_Parsed_.Default()
}

func (_this type_Parsed_) String() string {
	return "GetOpt.Parsed"
}
func (_this Parsed) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Parsed{}

// End of datatype Parsed

// Definition of class CommandMap
type CommandMap struct {
}

func New_CommandMap_() *CommandMap {
	_this := CommandMap{}

	return &_this
}

type CompanionStruct_CommandMap_ struct {
}

var Companion_CommandMap_ = CompanionStruct_CommandMap_{}

func (*CommandMap) String() string {
	return "GetOpt.CommandMap"
}

// End of class CommandMap

func Type_CommandMap_() _dafny.TypeDescriptor {
	return type_CommandMap_{}
}

type type_CommandMap_ struct {
}

func (_this type_CommandMap_) Default() interface{} {
	return _dafny.EmptyMap
}

func (_this type_CommandMap_) String() string {
	return "GetOpt.CommandMap"
}
func (_this *CompanionStruct_CommandMap_) Is_(__source _dafny.Map) bool {
	var _0_x _dafny.Map = (__source)
	_ = _0_x
	return _dafny.Quantifier((_0_x).Keys().Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _1_k _dafny.Sequence
		_1_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !((_0_x).Contains(_1_k)) || (_dafny.Companion_Sequence_.Equal(((_0_x).Get(_1_k).(Options)).Dtor_name(), _1_k))
	})
}

// Definition of datatype Context
type Context struct {
	Data_Context_
}

func (_this Context) Get_() Data_Context_ {
	return _this.Data_Context_
}

type Data_Context_ interface {
	isContext()
}

type CompanionStruct_Context_ struct {
}

var Companion_Context_ = CompanionStruct_Context_{}

type Context_Context struct {
	LongMap  _dafny.Map
	ShortMap _dafny.Map
	Inherits _dafny.Sequence
	Commands _dafny.Map
	Command  _dafny.Sequence
}

func (Context_Context) isContext() {}

func (CompanionStruct_Context_) Create_Context_(LongMap _dafny.Map, ShortMap _dafny.Map, Inherits _dafny.Sequence, Commands _dafny.Map, Command _dafny.Sequence) Context {
	return Context{Context_Context{LongMap, ShortMap, Inherits, Commands, Command}}
}

func (_this Context) Is_Context() bool {
	_, ok := _this.Get_().(Context_Context)
	return ok
}

func (CompanionStruct_Context_) Default() Context {
	return Companion_Context_.Create_Context_(_dafny.EmptyMap, _dafny.EmptyMap, _dafny.EmptySeq, _dafny.EmptyMap, _dafny.EmptySeq.SetString())
}

func (_this Context) Dtor_longMap() _dafny.Map {
	return _this.Get_().(Context_Context).LongMap
}

func (_this Context) Dtor_shortMap() _dafny.Map {
	return _this.Get_().(Context_Context).ShortMap
}

func (_this Context) Dtor_inherits() _dafny.Sequence {
	return _this.Get_().(Context_Context).Inherits
}

func (_this Context) Dtor_commands() _dafny.Map {
	return _this.Get_().(Context_Context).Commands
}

func (_this Context) Dtor_command() _dafny.Sequence {
	return _this.Get_().(Context_Context).Command
}

func (_this Context) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Context_Context:
		{
			return "GetOpt.Context.Context" + "(" + _dafny.String(data.LongMap) + ", " + _dafny.String(data.ShortMap) + ", " + _dafny.String(data.Inherits) + ", " + _dafny.String(data.Commands) + ", " + _dafny.String(data.Command) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Context) Equals(other Context) bool {
	switch data1 := _this.Get_().(type) {
	case Context_Context:
		{
			data2, ok := other.Get_().(Context_Context)
			return ok && data1.LongMap.Equals(data2.LongMap) && data1.ShortMap.Equals(data2.ShortMap) && data1.Inherits.Equals(data2.Inherits) && data1.Commands.Equals(data2.Commands) && data1.Command.Equals(data2.Command)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Context) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Context)
	return ok && _this.Equals(typed)
}

func Type_Context_() _dafny.TypeDescriptor {
	return type_Context_{}
}

type type_Context_ struct {
}

func (_this type_Context_) Default() interface{} {
	return Companion_Context_.Default()
}

func (_this type_Context_) String() string {
	return "GetOpt.Context"
}
func (_this Context) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Context{}

// End of datatype Context
