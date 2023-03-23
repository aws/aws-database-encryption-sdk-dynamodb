// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "AwsCryptographyDynamoDbItemEncryptorOperations.dfy"
include "../../StructuredEncryption/src/SearchInfo.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/FloatCompare.dfy"

module DynamoDBFilterExpr {
  import opened SearchableEncryptionInfo
  import opened UTF8
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbItemEncryptorOperations
  import opened AwsCryptographyStructuredEncryptionTypes
  import FloatCompare
  import Seq

  function method ExtractAttributes(s : string, ex : Option<ExpressionAttributeNameMap>) : seq<string>
  {
    var tokens := ParseExpr(s);
    var attrs := Seq.Filter((t : token) => t.Attr? && |t.s| > 0 && t.s[0] != ':', tokens);
    assert forall t <- attrs :: t.Attr?;
    var attrNames := Seq.Map((t : token) requires t.Attr? => t.s, attrs);
    Seq.Map((t : string) => GetName(t, ex), attrNames)
  }

  datatype token =
    | Attr(s:string)
    | Value(s:string)
    | Eq | Ne | Lt | Gt | Le | Ge
    | Between
    | In
    | Open
    | Close
    | Comma
    | Not
    | And
    | Or
    | AttributeExists
    | AttributeNotExists
    | AttributeType
    | BeginsWith
    | Contains
    | Size

  function method TokenToString(t : token) : string
  {
    match t {
      case Attr(s) => s
      case Value(s) => s
      case Eq => "="
      case Ne => "<>"
      case Lt =>"<"
      case Gt => ">"
      case Le => "<="
      case Ge => ">="
      case Between => "BETWEEN"
      case In => "IN"
      case Open => "("
      case Close => ")"
      case Comma => ","
      case Not => "NOT"
      case And => "AND"
      case Or => "OR"
      case AttributeExists => "attribute_exists"
      case AttributeNotExists => "attribute_not_exists"
      case AttributeType => "attribute_type"
      case BeginsWith => "begins_with"
      case Contains => "contains"
      case Size => "size"
    }
  }
  /*
  function method BeaconValue(beacons : BeaconVersion, name : string, attr : AttributeValue) : Result<AttributeValue, string>
  {
    var b := beacons.GetBeacon(name);
    if b.None? then
      Failure("No beacon for " + name)
    else
      BeaconValue2(b.value, name, attr)
  }
  
  function method BeaconValue2(b : Beacon, name : string, attr : AttributeValue) : Result<AttributeValue, string>
  {
    if b.IsPlain() then
      var bytes :- AttributeToBytes(attr);
      Success(AttributeValue.S(b.PlainHash(bytes)))
    else if attr.S? then
      var str :- b.CompoundHash(attr.StringAttributeValue);
      Success(AttributeValue.S(""))
    else
      Failure("Attribute " + name + " uses compound hash, but is not of type string")
  }
  */
  /*
  datatype ParsedContext = ParsedContext (
    expr : seq<token>, 
    values: ExpressionAttributeValueMap,
    names : Option<ExpressionAttributeNameMap>
  )
  */
  /*
  function method BeaconFromName(b : BeaconVersion, name : string, names : Option<ExpressionAttributeNameMap>) : (ret : Option<Beacon>)
  {
    if "gZ_b_" < name then
      b.GetBeacon(name[5..])
    else if names.Some? && name in names.value then
      b.GetBeacon(names.value[name])
    else
      b.GetBeacon(name)
  }
  */
  /*
  predicate method TokenHasBeacon(b : BeaconVersion, item : token) : (ret : bool)
    ensures ret ==> item.Attr?
  {
    if item.Attr? then
      b.HasBeacon(item.s)
    else
      false
  }
  
  // ATTR IN VAL, VAL, VAL
  function method {:tailrecursion} GetInPos(b : BeaconVersion, before : seq<token>, acc : Option<nat> := None) : (ret : Option<nat>)
    ensures ret.Some? ==> ret.value >= 2
  {
    if |before| < 2 then
      None
    else if TokenHasBeacon(b, before[|before|-2]) && before[|before|-1].In? then
      if acc.Some? then
        Some(acc.value+2)
      else
        Some(2)
    else if !before[|before|-2].Value? || !before[|before|-1].Comma? then
     None
    else if acc.None? then
      GetInPos(b, before[..|before|-2], Some(2))
    else
      GetInPos(b, before[..|before|-2], Some(acc.value+2))
  }
  
  // return the beacon that should be used to encode this value, if any.
  function method BeaconFromValue(
    b : BeaconVersion,
    name : string,
    before : seq<token>,
    after : seq<token>,
    values: ExpressionAttributeValueMap,
    names : Option<ExpressionAttributeNameMap>)
    : (ret : Option<Beacon>)
    ensures ret.Some? ==> name in values
  {
    if name !in values then
      None
    // VAL <
    else if 2 <= |after| && IsComp(after[0]) && TokenHasBeacon(b, after[1]) then
      BeaconFromName(b, after[1].s, names)
    // ATTR < VAL
    else if 2 <= |before| && TokenHasBeacon(b, before[|before|-2]) && IsComp(before[|before|-1])  then
      BeaconFromName(b, before[|before|-2].s, names)
    // contains(ATTR, VAL
    else if 4 <= |before| && (before[|before|-4].Contains? || before[|before|-4].BeginsWith? ) && before[|before|-3].Open?
    && TokenHasBeacon(b, before[|before|-2]) && before[|before|-1].Comma? then
      BeaconFromName(b, before[|before|-2].s, names)
    // ATTR BETWEEN VAL
    else if 2 <= |before| && TokenHasBeacon(b, before[|before|-2]) && before[|before|-1].Between? then
      BeaconFromName(b, before[|before|-2].s, names)
    // ATTR BETWEEN * AND VAL
    else if 4 <= |before| && TokenHasBeacon(b, before[|before|-4]) && before[|before|-3].Between? && before[|before|-1].And? then
      BeaconFromName(b, before[|before|-4].s, names)
    // ATTR IN VAL, VAL, VAL
    else if 2 <= |before| then
      var in_pos := GetInPos(b, before);
      if in_pos.None? then
        None
      else if in_pos.value <= |before| && TokenHasBeacon(b, before[|before|-in_pos.value]) then // should be ensures on GetInPos
        BeaconFromName(b, before[|before|-in_pos.value].s, names)
      else
        None
    else
      None
  }
  
  function method {:tailrecursion} Beaconize2(b : BeaconVersion, expr : seq<token>, 
    values: ExpressionAttributeValueMap,
    names : Option<ExpressionAttributeNameMap>,
    acc : seq<token> := [])
    : Result<ParsedContext, string>
  {
    if |expr| == 0 then
      Success(ParsedContext(acc, values, names))
    else if expr[0].Attr? then
      var bec := b.GetBeacon(expr[0].s);
      if bec.None? then
          Beaconize2(b, expr[1..], values, names, acc + [expr[0]])
      else
        Beaconize2(b, expr[1..], values, names, acc + [Attr(BeaconName(expr[0].s))]) // FIXME - no beacon if `size` or `exists`
    else if expr[0].Value? then
      var bec := BeaconFromValue(b, expr[0].s, acc, expr[1..], values, names);
      if bec.None? then
          Beaconize2(b, expr[1..], values, names, acc + expr[0..0])
      else
        var oldValue := values[expr[0].s];
        var newValue :- BeaconValue2(bec.value, expr[0].s, oldValue);
        Beaconize2(b, expr[1..], values[expr[0].s := newValue], names, acc + expr[0..0])
    else
      Beaconize2(b, expr[1..], values, names, acc + [expr[0]])
  }
  
  function method Beaconize(b : BeaconVersion, t : ParsedContext) : Result<ParsedContext, string>
  {
    Beaconize2(b, t.expr, t.values, t.names)
  }
  */
  function method ParsedExprToString(t : seq<token>) : string
  {
    var x := Seq.Map(x => TokenToString(x), t);
    if |x| == 0 then
      ""
    else
      Join(x, " ")
  }

  predicate method IsUnary(t : token) {
    match t
    case Not => true
    case _ => false
  }

  predicate method IsComp(t : token) {
    match t
    case Eq | Ne | Lt | Gt | Le | Ge => true
    case _ => false
  }

  predicate method IsBinaryBool(t : token) {
    match t
    case And | Or => true
    case _ => false
  }

  predicate method IsBinary(t : token) {
    IsComp(t) || IsBinaryBool(t)
  }

  predicate method IsVar(t : token) {
    match t
    case Value(s) => true
    case Attr(s) => true
    case _ => false
  }
  predicate method IsValue(t : token) {
    match t
    case Value(s) => true
    case _ => false
  }
  function method GetValue(t : token) : string {
    match t
    case Value(s) => s
    case _ => []
  }
  predicate method IsAttribute(t : token) {
    match t
    case Attr(s) => true
    case _ => false
  }
  function method GetAttribute(t : token) : string {
    match t
    case Attr(s) => s
    case _ => []
  }

  predicate method IsFunction(t : token) {
    match t
    case
      | Between
      | In
      | AttributeExists
      | AttributeNotExists
      | AttributeType
      | BeginsWith
      | Contains
      | Size => true
    case _ => false
  }

  function method Precedence(t : token) : nat {
    match t
    case Open => 11
    case Close => 11
    case Comma => 11
    case Attr(s) => 10
    case Value(s) => 10
    case Eq => 9
    case Ne => 9
    case Lt => 9
    case Gt => 9
    case Le => 9
    case Ge => 9
    case In => 8
    case Between => 7
    case AttributeExists => 6
    case AttributeNotExists => 6
    case AttributeType => 6
    case BeginsWith => 6
    case Contains => 6
    case Size => 6
    case Not => 5
    case And => 4
    case Or => 3
  }
  // convert s to a sequence of tokens
  function method {:tailrecursion} ParseExpr(s: string): (res: seq<token>)
    ensures s == [] ==> res == []
    decreases |s|
  {
    var tup := FindIndexToken(s);
    if 0 < tup.0 then [tup.1] + ParseExpr(s[tup.0..]) else []

  }

  // convert ch to lower case
  function method ByteLower(ch: uint8): uint8
  {
    if 'A' as uint8 <= ch <= 'Z' as uint8 then
      ch - 'A' as uint8 + 'a' as uint8
    else
      ch
  }
  // convert ch to lower case
  function method CharLower(ch: char): char
  {
    if 'A' <= ch <= 'Z' then
      ch - 'A' + 'a'
    else
      ch
  }

  // convert s to lowercase
  function method strLower(s: string): (res : string)
    ensures |s| == |res|
  {
    if 0 == |s| then
      s
    else
      [CharLower(s[0])] + strLower(s[1..])
  }

  function method PrefixLower(pre : string, s : string): (res : bool)
  {
    strLower(pre) <= strLower(s)
  }

  // valid value character
  predicate method ValueChar(ch : char)
  {
    if 'a' <= ch <= 'z'  then
      true
    else if 'A'  <= ch <= 'Z' then
      true
    else if '0' <= ch <= '9' then
      true
    else
      false
  }

  // valid attribute character
  predicate method AttributeChar(ch : char)
  {
    if ValueChar(ch) then
      true
    else if ch in [':' ,'[' ,']' ,'.'] then
      true
    else
      false
  }

  // length of the prefix of s that is a value name
  function method ValueLen(s : string): (res : nat)
    ensures res <= |s|
  {
    if 0 == |s| then
      0
    else if ValueChar(s[0]) then
      ValueLen(s[1..]) + 1
    else
      0
  }

  // length of the prefix of s that is an attribute name
  function method AttributeLen(s : string): (res : nat)
    ensures res <= |s|
  {
    if 0 == |s| then
      0
    else if AttributeChar(s[0]) then
      AttributeLen(s[1..]) + 1
    else
      0
  }

  // return the next token, and the number of characters consumed
  // if zero is returned for the index, then ignore the token and stop looking.
  function method {:vcs_split_on_every_assert}  FindIndexToken(s: string): (res: (nat, token))
    ensures res.0 <= |s|
  {
    if 0 == |s| then
      (0, Close)
    else
      var ch := s[0];
      if ch == ' ' then
        var foo := FindIndexToken(s[1..]);
        if foo.0 == 0 then
          (foo.0,foo.1)
        else
          (foo.0+1,foo.1)
      else if ch == '(' then
        (1, Open)
      else if ch == ')' then
        (1, Close)
      else if ch == ',' then
        (1, Comma)
      else if ch == '=' then
        (1, Eq)
      else if ch == '<' then
        if "<=" <= s then
          (2, Le)
        else if "<>" <= s then
          (2, Ne)
        else
          (1, Lt)
      else if ch == '>' then
        if ">=" <= s then
          (2, Ge)
        else
          (1, Gt)
      else if PrefixLower("in", s) then
        (2, In)
      else if PrefixLower("between", s) then
        (7, Between)
      else if PrefixLower("and", s) then
        (3, And)
      else if PrefixLower("or", s) then
        (2, Or)
      else if PrefixLower("not", s) then
        (3, Not)
      else if PrefixLower("attribute_not_exists", s) then
        (20, AttributeNotExists)
      else if PrefixLower("attribute_type", s) then
        (14, AttributeType)
      else if PrefixLower("begins_with", s) then
        (11, BeginsWith)
      else if PrefixLower("attribute_exists", s) then
        (16, AttributeExists)
      else if PrefixLower("contains", s) then
        (8, Contains)
      else if PrefixLower("size", s) then
        (4, Size)
      else if ch == ':' then
        var x := ValueLen(s[1..]) + 1;
        (x, Value(s[1..x]))
      else if ch == '#' then
        var x := ValueLen(s[1..]) + 1;
        (x, Attr(s[0..x]))
      else
        var x := AttributeLen(s);
        (x, Attr(s[0..x]))
  }

  // does it start with "A BETWEEN X AND Y"
  predicate method IsBetween(input: seq<token>)
  {
    if |input| < 5 then
      false
    else if !IsVar(input[0]) then
      false
    else if input[1] != Between then
      false
    else if !IsVar(input[2]) then
      false
    else if input[3] != And then
      false
    else if !IsVar(input[4]) then
      false
    else
      true
  }

  // does it start with "A IN ("
  predicate method IsIN(input: seq<token>)
  {
    if |input| < 3 then
      false
    else if !IsVar(input[0]) then
      false
    else if input[1] != In then
      false
    else if input[2] != Open then
      false
    else
      true
  }

  // transform A IN(X,Y) to IN(A,X,Y)
  // transform A BETWEEN X AND Y to BETWEEN(A, X, Y)
  function method ConvertToPrefix(input: seq<token>) : (res : seq<token>)
  {
    if |input| < 5 then
      input
    else if IsIN(input) then
      [input[1], input[2], input[0], Comma] + ConvertToPrefix(input[3..])
    else if IsBetween(input) then
      [input[1], Open, input[0], Comma, input[2], Comma, input[4], Close] + ConvertToPrefix(input[5..])
    else
      [input[0]] + ConvertToPrefix(input[1..])
  }

  lemma TestConvertToPrefix3(input: seq<token>)
    requires input == [Attr("A"), In, Open, Attr("B"), Comma, Attr("C"), Close]
    ensures IsIN(input)
    ensures ConvertToPrefix(input) ==  [In, Open, Attr("A"), Comma, Attr("B"), Comma, Attr("C"), Close]
  {}

  // convert from parsed order to executable order
  // must be rejiggered first
  function method ConvertToRpn(input: seq<token>) : seq<token>
  {
    var stack := [];
    ConvertToRpn_inner(input, stack)
  }

  function method ConvertToRpn_inner(input: seq<token>, stack : seq<token>) : seq<token>
  {
    if 0 == |input| then
      if 0 == |stack| then
        []
      else
        [stack[|stack|-1]] + ConvertToRpn_inner(input, stack[..|stack|-1])
    else
      match input[0]
      case Attr(s)  => [input[0]] + ConvertToRpn_inner(input[1..], stack)
      case Value(s)  => [input[0]] + ConvertToRpn_inner(input[1..], stack)
      case Open | Not | AttributeExists | AttributeNotExists | AttributeType
        | BeginsWith | Contains | Size
        => ConvertToRpn_inner(input[1..], stack + [input[0]])
      case Comma =>
        if 0 < |stack| then
          if IsFunction(stack[|stack|-1]) then
            ConvertToRpn_inner(input[1..], stack)
          else
            [stack[|stack|-1]] + ConvertToRpn_inner(input[1..], stack[..|stack|-1])
        else
          // error
          ConvertToRpn_inner(input[1..], stack)
      case Close =>
        if 0 == |stack| then
          ConvertToRpn_inner(input[1..], stack)
        else if stack[|stack|-1] == Open then
          ConvertToRpn_inner(input[1..], stack[..|stack|-1])
        else
          [stack[|stack|-1]] + ConvertToRpn_inner(input, stack[..|stack|-1])
      case Eq | Ne | Lt | Gt | Le | Ge | And | Or =>
        if 0 == |stack| then
          [input[0]] + ConvertToRpn_inner(input[1..], stack)
        else if Precedence(stack[|stack|-1]) >= Precedence(input[0]) then
          [stack[|stack|-1]] + ConvertToRpn_inner(input, stack[..|stack|-1])
        else
          [input[0]] + ConvertToRpn_inner(input[1..], stack)
      case Between | In => ConvertToRpn_inner(input[1..], stack)
  }

  datatype stackval = Bool(b : bool) | Str(s : AttributeValue) | Nada

  function method GetStr(s : stackval) : AttributeValue
  {
    match s
    case Bool(b) => AttributeValue.NULL(true)
    case Str(s) => s
    case Nada => AttributeValue.NULL(true)
  }

  function method AsStr(s : string) : stackval
  {
    Str(AttributeValue.S(s))
  }

  function method StackvalFromMap(s : string, vals : AttributeMap) : stackval
  {
    if s in vals then
      Str(vals[s])
    else
      Nada
  }
  function method GetParsedExpr(input : string) : Result<seq<token>, string>
  {
    var seq1 := ParseExpr(input);
    var seq2 := ConvertToPrefix(seq1);
    Success(ConvertToRpn(seq2))
  }
  function method FinalEval(input : string, vals : AttributeMap) : Result<bool, string>
  {
    var seq3 :- GetParsedExpr(input);
    EvalExpr(seq3, vals)
  }


  function method EvalExpr(input : seq<token>, vals : AttributeMap) : Result<bool, string>
  {
    InnerEvalExpr(input, [], vals)
  }

  function method NumStrs(input : seq<stackval>) : nat
  {
    if |input| == 0 then
      0
    else if !input[|input|-1].Str? then
      0
    else
      1 + NumStrs(input[..|input|-1])
  }

  predicate method  {:tailrecursion} seq_contains<T(==)>(haystack : seq<T>, needle : seq<T>)
  {
    if |needle| == 0 then
      true
    else if |haystack| == 0 then
      false
    else if |haystack| < |needle|  then
      false
    else if needle[0] == haystack[0] && needle[1..] <= haystack[1..] then
      true
    else
      seq_contains(haystack[1..], needle)
  }

  predicate method {:tailrecursion}  AttrInList(list : ListAttributeValue, needle : AttributeValue)
  {
    if |list| == 0 then
      false
    else if list[0] == needle then
      true
    else
      AttrInList(list[1..], needle)
  }

  predicate method does_contain(haystack : AttributeValue, needle : AttributeValue)
  {
    match haystack{
      case S(s) =>
        if needle.S? then
          seq_contains(haystack.S, needle.S)
        else
          false
      case N(n) =>
        if needle.N? then
          seq_contains(haystack.N, needle.N)
        else
          false
      case B(n) =>
        if needle.B? then
          seq_contains(haystack.B, needle.B)
        else
          false
      case SS(s) =>
        if needle.S? then
          needle.S in haystack.SS
        else
          false
      case NS(s) =>
        if needle.N? then
          needle.N in haystack.NS
        else
          false
      case BS(s) =>
        if needle.B? then
          needle.B in haystack.BS
        else
          false
      case L(list) => AttrInList(list, needle)
      case _ => false
    }
  }

  predicate method begins_with(haystack : AttributeValue, needle : AttributeValue)
  {
    match haystack{
      case S(s) =>
        if needle.S? then
          needle.S <= haystack.S
        else
          false
      case N(n) =>
        if needle.N? then
          needle.N <= haystack.N
        else
          false
      case B(n) =>
        if needle.B? then
          needle.B <= haystack.B
        else
          false
      case _ => false
    }
  }

  predicate method is_between(middle : AttributeValue, left : AttributeValue, right : AttributeValue)
  {
    AttributeLE(left, middle) && AttributeLE(middle, right)
  }

  predicate method is_in(target : AttributeValue, list : seq<stackval>)
  {
    if |list| == 0 then
      false
    else if GetStr(list[0]) == target then
      true
    else
      is_in(target, list[1..])
  }

  function method AttrToStr(attr : AttributeValue) : string
  {
    match attr {
      case S(s) => s
      case N(n) => n
      case _ => "" // FIXME
    }
  }

  function method AttrTypeToStr(attr : AttributeValue) : string
  {
    match attr {
      case S(s) => "S"
      case N(n) => "N"
      case B(n) => "B"
      case SS(n) => "SS"
      case NS(n) => "NS"
      case BS(n) => "BS"
      case M(n) => "M"
      case L(n) => "L"
      case NULL(n) => "NULL"
      case BOOL(n) => "BOOL"
    }
  }

  function method IsAttrType(attr : stackval, typestr : stackval) : bool
  {
    AttrTypeToStr(GetStr(attr)) == AttrToStr(GetStr(typestr))
  }

  function method apply_function(input : token, stack : seq<stackval>, num_args : nat) : Result<stackval, string>
  {
    match input
    case Between =>
      if |stack| < 3 then
        Failure("No Stack for Between")
      else
      if stack[|stack|-1].Str? && stack[|stack|-2].Str? && stack[|stack|-3].Str? then
        Success(Bool(is_between(stack[|stack|-3].s, stack[|stack|-2].s, stack[|stack|-1].s)))
      else
        Failure("Wrong Types for contains")

    case In =>
      var num := NumStrs(stack);
      if |stack| < num then
        Failure("Tautology False")
      else if num == 0 then
        Failure("In has no args")
      else
        Success(Bool(is_in(GetStr(stack[|stack|-num]), stack[|stack|-num+1..])))
    case AttributeExists =>
      if |stack| < 1 then
        Failure("No Stack for AttributeExists")
      else
        Success(Bool(!stack[|stack|-1].Nada?))

    case AttributeNotExists =>
      if |stack| < 1 then
        Failure("No Stack for AttributeExists")
      else
        Success(Bool(stack[|stack|-1].Nada?))
    case AttributeType =>
      if |stack| < 2 then
        Failure("No Stack for AttributeType")
      else
        Success(Bool(IsAttrType(stack[|stack|-2], stack[|stack|-1])))  // What???
    case BeginsWith =>
      if |stack| < 2 then
        Failure("No Stack for BeginsWith")
      else
      if stack[|stack|-1].Str? && stack[|stack|-2].Str? then
        Success(Bool(begins_with(stack[|stack|-2].s, stack[|stack|-1].s)))
      else
        Failure("Wrong Types for contains")

    case Contains =>
      if |stack| < 2 then
        Failure("No Stack for contains")
      else
      if stack[|stack|-1].Str? && stack[|stack|-2].Str? then
        Success(Bool(does_contain(stack[|stack|-2].s, stack[|stack|-1].s)))
      else
        Failure("Wrong Types for contains")

    case Size => Success(Bool(true)) // What???
    case _ => Success(Bool(true))
  }
  function method apply_unary(input : token, stack : stackval) : Result<stackval, string>
  {
    if stack.Bool? then
      Success(Bool(!stack.b))
    else
      Failure("wrong type for Not")
  }

  function method apply_binary_bool(input : token, x : bool, y : bool) : Result<bool, string>
  {
    match input
    case And => Success(x && y)
    case Or => Success(x || y)
    case _ => Failure("invalid op in apply_binary_bool")
  }

  predicate method LexicographicLess<T(==)>(a: seq<T>, b: seq<T>, less: (T, T) -> bool)
  {
    !LexicographicLessOrEqual(b, a, less)
  }
  predicate method LexicographicGreater<T(==)>(a: seq<T>, b: seq<T>, less: (T, T) -> bool)
  {
    !LexicographicLessOrEqual(a, b, less)
  }
  predicate method LexicographicGreaterOrEqual<T(==)>(a: seq<T>, b: seq<T>, less: (T, T) -> bool)
  {
    LexicographicLessOrEqual(b, a, less)
  }

  predicate method charless(a: char, b: char) { a < b }
  predicate method u8less(a: uint8, b: uint8) { a < b }

  predicate method AttributeLE(a : AttributeValue, b : AttributeValue)
  {
    if a.N? && b.N? then
      FloatCompare.CompareFloat(a.N, b.N) <= 0
    else if a.S? && b.S? then
      LexicographicLessOrEqual(a.S, b.S, charless)
    else if a.B? && b.B? then
      LexicographicLessOrEqual(a.B, b.B, u8less)
    else
      false // TODO, Are there other well defined < operations?
  }
  predicate method AttributeLT(a : AttributeValue, b : AttributeValue)
  {
    !AttributeLE(b,a)
  }
  predicate method AttributeGT(a : AttributeValue, b : AttributeValue)
  {
    !AttributeLE(a,b)
  }
  predicate method AttributeGE(a : AttributeValue, b : AttributeValue)
  {
    AttributeLE(b,a)
  }

  function method apply_binary_comp(input : token, x : AttributeValue, y : AttributeValue) : Result<bool, string>
  {
    match input
    case Eq => Success(x == y)
    case Ne => Success(x != y)
    case Le => Success(AttributeLE(x, y))
    case Lt => Success(AttributeLT(x, y))
    case Ge => Success(AttributeGE(x, y))
    case Gt => Success(AttributeGT(x, y))
    case _ => Failure("invalid op in apply_binary_bool")
  }

  function method apply_binary(input : token, x : stackval, y : stackval) : Result<stackval, string>
  {
    if IsComp(input) then
      if x.Str? && y.Str? then
        var val :- apply_binary_comp(input, x.s, y.s);
        Success(Bool(val))
      else
        Failure("wrong types for comparison")
    else
    if x.Bool? && y.Bool? then
      var val :- apply_binary_bool(input, x.b, y.b);
      Success(Bool(val))
    else
      Failure("wrong types for boolean binary")
  }

  function method NumArgs(t : token, stack : seq<stackval>) : nat
  {
    match t
    case Between => 3
    case In => NumStrs(stack)
    case AttributeExists => 1
    case AttributeNotExists => 1
    case AttributeType => 1
    case BeginsWith => 2
    case Contains => 2
    case Size => 1
    case _ => 0
  }

  function method InnerEvalExpr(input : seq<token>, stack : seq<stackval>, vals : AttributeMap) : Result<bool, string>
  {
    if 0 == |input| then
      if 1 == |stack| && stack[0].Bool? then
        Success(stack[0].b)
      else
        Failure("ended with bad stack")
    else
      var t := input[0];
      if IsValue(t) then
        InnerEvalExpr(input[1..], stack + [AsStr(GetValue(t))], vals)
      else if IsAttribute(t) then
        InnerEvalExpr(input[1..], stack + [StackvalFromMap(GetAttribute(t), vals)], vals)
      else if IsUnary(t) then
        if 0 == |stack| then
          Failure("Empty stack for unary op")
        else
          var val :- apply_unary(t, stack[|stack|-1]);
          InnerEvalExpr(input[1..], stack[..|stack|-1] + [val], vals)
      else if IsBinary(t) then
        if |stack| < 2 then
          Failure("Empty stack for binary op")
        else
          var val :- apply_binary(t, stack[|stack|-2], stack[|stack|-1]);
          InnerEvalExpr(input[1..], stack[..|stack|-2] + [val], vals)
      else if IsFunction(t) then
        var num_args := NumArgs(t, stack);
        if |stack| < num_args then
          Failure("Empty stack for function call")
        else
          var val :- apply_function(t, stack, num_args);
          InnerEvalExpr(input[1..], stack[..|stack|-num_args] + [val], vals)

      else
        Success(true)
  }


  /*
  lemma test1(s: ustr)
    requires s == S2U("and")
    ensures FindIndexToken(s) == (3,And)
    ensures ParseExpr(s) == [And]
  {}
  */
  /*
  lemma test2(s: ustr)
    requires s == "And"
    ensures FindIndexToken(s) == (3,And)
    ensures ParseExpr(s) == [And]
  {}
  */
  /*
  lemma test3(s: ustr)
    requires s == UTF8.Encode("a").Extract()
    ensures FindIndexToken(s) == (1,Attribute(S2U("a")))
  {}
  */
  /*
  lemma test4(s: ustr)
    requires s == "   a"
    ensures FindIndexToken(s) == (4,Attribute("a"))
  {}
  */
  lemma test5(s: string)
    requires s == []
    ensures FindIndexToken(s) == (0,Close)
  {}
  /*
  lemma test6(s: ustr)
    requires s == UTF8.Encode(" ").Extract()
    ensures FindIndexToken(s) == (0,Close)
  {}
  */
  /*
  lemma test7(s: ustr)
    requires s == "     "
    ensures FindIndexToken(s) == (0,Close)
  {}
  */

  function method doFilter(parsed : seq<token>, ItemList : ItemList) : Result<ItemList, string>
  {
    if |ItemList| == 0 then
      Success([])
    else
      var doesMatch :- EvalExpr(parsed, ItemList[0]);
      var rest :- doFilter(parsed, ItemList[1..]);
      if doesMatch then
        Success(ItemList[0..0] + rest)
      else
        Success(ItemList[0..0] + rest)

  }

  function method FilterResults(
    ItemList : ItemList,
    FilterExpression : Option<ConditionExpression>,
    ExpressionAttributeNames : Option<ExpressionAttributeNameMap>,
    ExpressionAttributeValues: Option<ExpressionAttributeValueMap>) : Result<ItemList, string>
  {
    if |ItemList| == 0 || FilterExpression.None? then
      Success(ItemList)
    else
      var parsed :- GetParsedExpr(FilterExpression.value);
      doFilter(parsed, ItemList)
  }

  // Result??
  function method GetName(s : string, ExpressionAttributeNames : Option<ExpressionAttributeNameMap>) : string
  {
    if |s| == 0 then
      s
    else if s[0] != '#' then
      s
    else if ExpressionAttributeNames.None? then
      ""
    else if s in ExpressionAttributeNames.value then
      ExpressionAttributeNames.value[s]
    else
      s[1..]
  }

  function method IsEncryptedAttr(table : Config, expr : token, ExpressionAttributeNames : Option<ExpressionAttributeNameMap>) : bool
  {
    match expr {
      case Attr(s) =>
        var name := GetName(s, ExpressionAttributeNames);
        if name in table.attributeActions then
          table.attributeActions[name] == ENCRYPT_AND_SIGN
        else
          false
      case _ => false
    }
  }

  function method hasEncrypted(table : Config, expr : seq<token>, ExpressionAttributeNames : Option<ExpressionAttributeNameMap>) : bool
  {
    if |expr| == 0 then
      false
    else if IsEncryptedAttr(table, expr[0], ExpressionAttributeNames) then
      true
    else
      hasEncrypted(table, expr[1..], ExpressionAttributeNames)
  }

  function method CheckConditionExpr(table : Config, cond : Option<ConditionExpression>, ExpressionAttributeNames : Option<ExpressionAttributeNameMap>) : Outcome<string>
  {
    if cond.None? then
      Pass
    else
      var cond := cond.value;
      var expr := ParseExpr(cond);
      if hasEncrypted(table, expr, ExpressionAttributeNames) then
        Fail("Condition expression has encrypted field")
      else
        Pass
  }

  datatype ExprContext = ExprContext (
    expr : Option<ConditionExpression>,
    values: Option<ExpressionAttributeValueMap>,
    names : Option<ExpressionAttributeNameMap>
  )

  datatype ParsedContext = ParsedContext (
    expr : seq<token>,
    values: ExpressionAttributeValueMap,
    names : Option<ExpressionAttributeNameMap>
  )
  /*
  // transform plain expression "A = B" into beacon expression "gZ_b_Z = beacon(B)"
    function method BeaconExpression (beacons : BeaconVersion, cont : ExprContext) : Result<ExprContext, string>
    {
      if cont.expr.None? || cont.values.None? then
        Success((cont))
      else
        var parsed := ParseExpr(cont.expr.value);
        var ncont := ParsedContext(parsed, cont.values.value, cont.names);
        var beaconized :- Beaconize(beacons, ncont);
        var ret := ExprContext(Some(ParsedExprToString(beaconized.expr)), Some(beaconized.values), beaconized.names); 
        Success(ret)
    }
  */
}