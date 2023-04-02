// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*

• Parse a DynamoDB FilterExpression, ConditionExpression or KeyConditionExpression

  // If none of these attributes are encrypted, then you can let DynamoDB
  // treat this expression normally.
  ExtractAttributes(expr : string, names : Option<ExpressionAttributeNameMap>) : seq<string>

• Beaconize a ConditionExpression or KeyConditionExpression
• e.g. transform plain expression "A = B" into beacon expression "aws_dbe_b_A = beacon(B)"

  datatype ExprContext = ExprContext (
    expr : Option<DDB.ConditionExpression>,
    values: Option<DDB.ExpressionAttributeValueMap>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )

  function method Beaconize(b : SI.BeaconVersion, context : ExprContext) : ExprContext

*/


include "Util.dfy"
include "SearchInfo.dfy"

module DynamoDBFilterExpr {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes
  import SI = SearchableEncryptionInfo
  import opened DynamoDbEncryptionUtil
  import FloatCompare
  import Seq

  // extract all the attributes from a filter expression
  // except for those which do not need the attribute's value
  function method ExtractAttributes(s : string, ex : Option<DDB.ExpressionAttributeNameMap>) : seq<string>
  {
    var tokens := ParseExpr(s);
    ExtractAttributes2(tokens, ex, -1)
  }

  // Is this one of those special functions that ignores the underlying value?
  predicate method IsSpecial(t : Token)
  {
    || t.AttributeExists?
    || t.AttributeNotExists?
    || t.Size?
  }

  // the recursive inside of ExtractAttributes
  function method {:tailrecursion} ExtractAttributes2(
    tokens : seq<Token>,
    ex : Option<DDB.ExpressionAttributeNameMap>,
    tokensUntilSkip : int)
    : seq<string>
  {
    if |tokens| == 0 then
      []
    else if IsSpecial(tokens[0]) then
      ExtractAttributes2(tokens[1..], ex, 1)
    else if tokens[0].Attr? && tokensUntilSkip == 0 then
      ExtractAttributes2(tokens[1..], ex, -1)
    else if tokens[0].Attr? then
      [GetName(tokens[0].s, ex)] + ExtractAttributes2(tokens[1..], ex, -1)
    else
      ExtractAttributes2(tokens[1..], ex, tokensUntilSkip-1)
  }

  datatype Token =
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

  function method TokenToString(t : Token) : string
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

  // if expr is "ATTR IN VAL, VAL, VAL..."
  // and expr[pos] is one of the VAL's
  // return pos for the 'IN'
  // else return None
  function method {:tailrecursion} GetInPos(expr : seq<Token>, pos : nat) : (ret : Option<nat>)
    requires pos < |expr|
    ensures ret.Some? ==> ret.value >= 1 && ret.value < |expr|
  {
    if pos < 1 then
      None
    else if expr[pos].In? then
      Some(pos)
    else if !expr[pos].Value? then
      None
    else if pos < 2 then
      None
    else if expr[pos-1].In? then
      Some(pos-1)
    else if !expr[pos-1].Comma? then
      None
    else
      GetInPos(expr, pos-2)
  }

  function method RealName(s : string) : string
  {
    if BeaconPrefix < s then
      s[|BeaconPrefix|..]
    else
      s
  }

  predicate method HasBeacon(b : SI.BeaconVersion, t : Token, names : Option<DDB.ExpressionAttributeNameMap>)
  {
    if t.Attr? then
      var name := RealName(t.s);
      || name in b.beacons
      || (names.Some? && name in names.value && RealName(names.value[name]) in b.beacons)
    else
      false
  }

  function method GetBeacon(b : SI.BeaconVersion, t : Token, names : Option<DDB.ExpressionAttributeNameMap>)
    : Option<SI.Beacon>
    requires HasBeacon(b, t, names)
  {
    if t.Attr? then
      var name := RealName(t.s);
      if name in b.beacons then
        Some(b.beacons[name])
      else if names.Some? && name in names.value then
        var name2 := RealName(names.value[name]);
        if name2 in b.beacons then
          Some(b.beacons[name2])
        else
          None
      else
        None
    else
      None
  }
  
  // expr[pos] is a value; return the beacon t which that value refers
  function method BeaconForValue(
    b : SI.BeaconVersion,
    expr : seq<Token>,
    pos : nat,
    value: DDB.AttributeValue,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    : Option<SI.Beacon>
    requires pos < |expr|
    requires expr[pos].Value?
  {
    // value < ATTR
    if pos+2 < |expr| && IsComp(expr[pos+1]) && HasBeacon(b, expr[pos+2], names) then
      GetBeacon(b, expr[pos+2], names)
    // ATTR < value
    else if 2 <= pos && IsComp(expr[pos-1]) && HasBeacon(b, expr[pos-2], names) then
      GetBeacon(b, expr[pos-2], names)
    // contains(ATTR, value .or. begins_with(ATTR, value 
    else if 4 <= pos && (expr[pos-4].Contains? || expr[pos-4].BeginsWith?) && expr[pos-3].Open?
    && HasBeacon(b, expr[pos-2], names) && expr[pos-1].Comma? then
      GetBeacon(b, expr[pos-2], names)
    // ATTR BETWEEN value
    else if 2 <= pos && expr[pos-1].Between? && HasBeacon(b, expr[pos-2], names) then
      GetBeacon(b, expr[pos-2], names)
    // ATTR BETWEEN * and value
    else if 4 <= pos && expr[pos-1].And? && expr[pos-3].Between? && HasBeacon(b, expr[pos-4], names) then
      GetBeacon(b, expr[pos-4], names)
    // ATTR IN value, value, value, ...
    else if expr[pos].Value? then
      var in_pos := GetInPos(expr, pos);
      if in_pos.None? then
        None
      else if HasBeacon(b, expr[in_pos.value-1], names) then
        GetBeacon(b, expr[in_pos.value-1], names)
      else
        None
    else
      None
  }

  // expr[pos] is an argument to a function, which is an Attr which is a beacon
  // return false if that function operates directly on encrypted values
  predicate method OpNeedsBeacon(expr : seq<Token>, pos : nat)
    requires pos < |expr|
    requires expr[pos].Attr?
  {
    // false if attr_exists(ATTR), or  attr_not_exists(ATTR)
    // true otherwise
    if pos < 2 then
      true
    else if !expr[pos-1].Open? then
      true
    else
      TokenNeedsBeacon(expr[pos-2])
  }

  // expr[pos] is an argument to a function, which is an Attr which is a beacon
  // return an error if that function can operate neither on encrypted values nor on beacons
  function method IsAllowedOnBeacon(expr : seq<Token>, pos : nat, name : string) : Result<bool, Error>
    requires pos < |expr|
    requires expr[pos].Attr?
  {
    // error if size(ATTR) or attribute_type(ATTR, type)
    // true otherwise
    if pos < 2 then
      Success(true)
    else if !expr[pos-1].Open? then
      Success(true)
    else if TokenAllowsBeacon(expr[pos-2]) then
      Success(true)
    else
      Failure(E("Function " + TokenToString(expr[pos-2]) + " cannot be used on encrypted fields, but it is being used with " + name))
  }

  predicate method TokenNeedsBeacon(t : Token)
  {
    !(
      || t.AttributeExists?
      || t.AttributeNotExists?
    )
  }
  predicate method TokenAllowsBeacon(t : Token)
  {
    !(
      || t.AttributeType?
      || t.Size?
    )
  }

  function method {:tailrecursion} BeaconizeParsedExpr(
    b : SI.BeaconVersion,
    expr : seq<Token>,
    pos : nat,
    values: DDB.ExpressionAttributeValueMap,
    names : Option<DDB.ExpressionAttributeNameMap>,
    acc : seq<Token> := []
  )
    : Result<ParsedContext, Error>
    requires pos <= |expr|
    decreases |expr| - pos
  {
    if pos == |expr| then
      Success(ParsedContext(acc, values, names))
    else if expr[pos].Attr? then
      var isIndirectName := "#" <= expr[pos].s;
      :- Need(!isIndirectName || (names.Some? && expr[pos].s in names.value), E("Name " + expr[pos].s + " not in ExpressionAttributeNameMap."));
      var oldName := if isIndirectName then names.value[expr[pos].s] else expr[pos].s;
      if b.IsBeacon(oldName) then
        var _ :- IsAllowedOnBeacon(expr, pos, oldName);
        if OpNeedsBeacon(expr, pos) then
          var newName := b.beacons[oldName].getBeaconName();
          if isIndirectName then
            BeaconizeParsedExpr(b, expr, pos+1, values, Some(names.value[expr[pos].s := newName]), acc + [expr[pos]])
          else
            BeaconizeParsedExpr(b, expr, pos+1, values, names, acc + [Attr(newName)])
        else
          BeaconizeParsedExpr(b, expr, pos+1, values, names, acc + [expr[pos]])
      else
        BeaconizeParsedExpr(b, expr, pos+1, values, names, acc + [expr[pos]])
    else if expr[pos].Value? then
      :- Need(expr[pos].s in values, E(expr[pos].s + " not found in ExpressionAttributeValueMap"));
      var oldValue := values[expr[pos].s];
      var bec := BeaconForValue(b, expr, pos, oldValue, names);
      if bec.None? then
        BeaconizeParsedExpr(b, expr, pos+1, values, names, acc + [expr[pos]])
      else
        var newValue :- bec.value.GetBeaconValue(oldValue);
        BeaconizeParsedExpr(b, expr, pos+1, values[expr[pos].s := newValue], names, acc + [expr[pos]])
    else
      BeaconizeParsedExpr(b, expr, pos+1, values, names, acc + [expr[pos]])
  }

  // Convert the tokens back into an expression
  function method ParsedExprToString(t : seq<Token>) : string
  {
    var x := Seq.Map(x => TokenToString(x), t);
    if |x| == 0 then
      ""
    else
      Join(x, " ")
  }

  // Is this a unary operator?
  predicate method IsUnary(t : Token) {
    match t
    case Not => true
    case _ => false
  }

  // Is this a comparison operator?
  predicate method IsComp(t : Token) {
    match t
    case Eq | Ne | Lt | Gt | Le | Ge => true
    case _ => false
  }

  // Is this a boolean operator?
  predicate method IsBinaryBool(t : Token) {
    match t
    case And | Or => true
    case _ => false
  }

  // Is this an binary operator?
  predicate method IsBinary(t : Token) {
    IsComp(t) || IsBinaryBool(t)
  }

  // is this a variable?
  predicate method IsVar(t : Token) {
    match t
    case Value(s) => true
    case Attr(s) => true
    case _ => false
  }

  // is this a function?
  predicate method IsFunction(t : Token) {
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

  // return operator precedence
  function method Precedence(t : Token) : nat {
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
  function method {:tailrecursion} ParseExpr(s: string): (res: seq<Token>)
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

  // if s is long, this could be wasteful. Should probably hand roll a loop
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
  function method {:vcs_split_on_every_assert}  FindIndexToken(s: string): (res: (nat, Token))
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
        (x, Value(s[0..x]))
      else if ch == '#' then
        var x := ValueLen(s[1..]) + 1;
        (x, Attr(s[0..x]))
      else
        var x := AttributeLen(s);
        (x, Attr(s[0..x]))
  }

  // does it start with "A BETWEEN X AND Y"
  predicate method IsBetween(input: seq<Token>)
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
  predicate method IsIN(input: seq<Token>)
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
  function method ConvertToPrefix(input: seq<Token>) : (res : seq<Token>)
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

  lemma TestConvertToPrefix3(input: seq<Token>)
    requires input == [Attr("A"), In, Open, Attr("B"), Comma, Attr("C"), Close]
    ensures IsIN(input)
    ensures ConvertToPrefix(input) ==  [In, Open, Attr("A"), Comma, Attr("B"), Comma, Attr("C"), Close]
  {}

  // convert from parsed order to executable order
  // must run ConvertToPrefix first
  function method ConvertToRpn(input: seq<Token>) : seq<Token>
  {
    var stack := [];
    ConvertToRpn_inner(input, stack)
  }

  // convert infix to reverse polish
  function method ConvertToRpn_inner(input: seq<Token>, stack : seq<Token>) : seq<Token>
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

  datatype StackValue =
    | Bool(b : bool)
    | Str(s : DDB.AttributeValue)
    | DoesNotExist

  // returns th string value
  function method GetStr(s : StackValue) : DDB.AttributeValue
  {
    match s
    case Bool(b) => DDB.AttributeValue.NULL(true)
    case Str(s) => s
    case DoesNotExist => DDB.AttributeValue.NULL(true)
  }

  // string to DynamoDB string
  function method AsStr(s : string) : StackValue
  {
    Str(DDB.AttributeValue.S(s))
  }

  // look up s in map
  function method StackValueFromMap(s : string, item : DDB.AttributeMap) : StackValue
  {
    if s in item then
      Str(item[s])
    else
      DoesNotExist
  }

  // parse and return in reverse polish notation
  function method GetParsedExpr(input : string) : Result<seq<Token>, Error>
  {
    var seq1 := ParseExpr(input);
    var seq2 := ConvertToPrefix(seq1);
    Success(ConvertToRpn(seq2))
  }

  // parse and evaluate the expression
  function method FinalEval(input : string, item : DDB.AttributeMap) : Result<bool, Error>
  {
    var seq3 :- GetParsedExpr(input);
    EvalExpr(seq3, item)
  }

  // evaluate the expression, must be in reverse polish notation
  function method EvalExpr(input : seq<Token>, item : DDB.AttributeMap) : Result<bool, Error>
  {
    InnerEvalExpr(input, [], item)
  }

  // count the number of strings
  function method StringsFollowing(input : seq<StackValue>) : nat
  {
    if |input| == 0 then
      0
    else if !input[|input|-1].Str? then
      0
    else
      1 + StringsFollowing(input[..|input|-1])
  }

  // true if haystack contains needle
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

  // true if haystack contains needle
  predicate method does_contain(haystack : DDB.AttributeValue, needle : DDB.AttributeValue)
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
      case L(list) => needle in list
      case _ => false
    }
  }

  // true if haystack begins with needle
  predicate method begins_with(haystack : DDB.AttributeValue, needle : DDB.AttributeValue)
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
      case L(list) =>
        if |list| == 0 then
          false
        else if list[0] == needle then
          true
        else if needle.L? then
          needle.L <= list
        else
          false
      case _ => false
    }
  }

  // true if middle between left and right
  predicate method is_between(middle : DDB.AttributeValue, left : DDB.AttributeValue, right : DDB.AttributeValue)
  {
    AttributeLE(left, middle) && AttributeLE(middle, right)
  }

  // true if target in list
  predicate method is_in(target : DDB.AttributeValue, list : seq<StackValue>)
  {
    if |list| == 0 then
      false
    else if GetStr(list[0]) == target then
      true
    else
      is_in(target, list[1..])
  }

  // return string version of attribute
  function method AttrToStr(attr : DDB.AttributeValue) : string
  {
    match attr {
      case S(s) => s
      case N(n) => n
      case _ => ""
    }
  }

  // true if type of attr is typeStr
  function method IsAttrType(attr : StackValue, typeStr : StackValue) : bool
  {
    AttrTypeToStr(GetStr(attr)) == AttrToStr(GetStr(typeStr))
  }

  // call the function
  function method apply_function(input : Token, stack : seq<StackValue>, num_args : nat) : Result<StackValue, Error>
  {
    match input {
      case Between =>
        if |stack| < 3 then
          Failure(E("No Stack for Between"))
        else
        if stack[|stack|-1].Str? && stack[|stack|-2].Str? && stack[|stack|-3].Str? then
          Success(Bool(is_between(stack[|stack|-3].s, stack[|stack|-2].s, stack[|stack|-1].s)))
        else
          Failure(E("Wrong Types for contains"))

      case In =>
        var num := StringsFollowing(stack);
        if |stack| < num then
          Failure(E("Tautology False"))
        else if num == 0 then
          Failure(E("In has no args"))
        else
          Success(Bool(is_in(GetStr(stack[|stack|-num]), stack[|stack|-num+1..])))
      case AttributeExists =>
        if |stack| < 1 then
          Failure(E("No Stack for AttributeExists"))
        else
          Success(Bool(!stack[|stack|-1].DoesNotExist?))

      case AttributeNotExists =>
        if |stack| < 1 then
          Failure(E("No Stack for AttributeExists"))
        else
          Success(Bool(stack[|stack|-1].DoesNotExist?))
      case AttributeType =>
        if |stack| < 2 then
          Failure(E("No Stack for AttributeType"))
        else
          Success(Bool(IsAttrType(stack[|stack|-2], stack[|stack|-1])))  // What???
      case BeginsWith =>
        if |stack| < 2 then
          Failure(E("No Stack for BeginsWith"))
        else
        if stack[|stack|-1].Str? && stack[|stack|-2].Str? then
          Success(Bool(begins_with(stack[|stack|-2].s, stack[|stack|-1].s)))
        else
          Failure(E("Wrong Types for BeginsWith"))

      case Contains =>
        if |stack| < 2 then
          Failure(E("No Stack for contains"))
        else
        if stack[|stack|-1].Str? && stack[|stack|-2].Str? then
          Success(Bool(does_contain(stack[|stack|-2].s, stack[|stack|-1].s)))
        else
          Failure(E("Wrong Types for contains"))

      case Size => Success(Bool(true)) // What???
      case _ => Success(Bool(true))
    }
  }

  // call the unary function
  function method apply_unary(input : Token, stack : StackValue) : Result<StackValue, Error>
  {
    if stack.Bool? then
      Success(Bool(!stack.b))
    else
      Failure(E("wrong type for Not"))
  }

  // call the binary function
  function method apply_binary_bool(input : Token, x : bool, y : bool) : Result<bool, Error>
  {
    match input
    case And => Success(x && y)
    case Or => Success(x || y)
    case _ => Failure(E("invalid op in apply_binary_bool"))
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

  predicate method CharLess(a: char, b: char) { a < b }
  predicate method ByteLess(a: uint8, b: uint8) { a < b }

  predicate method AttributeLE(a : DDB.AttributeValue, b : DDB.AttributeValue)
  {
    if a.N? && b.N? then
      FloatCompare.CompareFloat(a.N, b.N) <= 0
    else if a.S? && b.S? then
      LexicographicLessOrEqual(a.S, b.S, CharLess)
    else if a.B? && b.B? then
      LexicographicLessOrEqual(a.B, b.B, ByteLess)
    else
      false // TODO, Are there other well defined < operations?
  }
  predicate method AttributeLT(a : DDB.AttributeValue, b : DDB.AttributeValue)
  {
    !AttributeLE(b,a)
  }
  predicate method AttributeGT(a : DDB.AttributeValue, b : DDB.AttributeValue)
  {
    !AttributeLE(a,b)
  }
  predicate method AttributeGE(a : DDB.AttributeValue, b : DDB.AttributeValue)
  {
    AttributeLE(b,a)
  }

  // apply the comparison function
  function method apply_binary_comp(input : Token, x : DDB.AttributeValue, y : DDB.AttributeValue) : Result<bool, Error>
  {
    match input
    case Eq => Success(x == y)
    case Ne => Success(x != y)
    case Le => Success(AttributeLE(x, y))
    case Lt => Success(AttributeLT(x, y))
    case Ge => Success(AttributeGE(x, y))
    case Gt => Success(AttributeGT(x, y))
    case _ => Failure(E("invalid op in apply_binary_bool"))
  }

  // apply the binary function
  function method apply_binary(input : Token, x : StackValue, y : StackValue) : Result<StackValue, Error>
  {
    if IsComp(input) then
      if x.Str? && y.Str? then
        var val :- apply_binary_comp(input, x.s, y.s);
        Success(Bool(val))
      else
        Failure(E("wrong types for comparison"))
    else
    if x.Bool? && y.Bool? then
      var val :- apply_binary_bool(input, x.b, y.b);
      Success(Bool(val))
    else
      Failure(E("wrong types for boolean binary"))
  }

  // return number of args for the function
  function method NumArgs(t : Token, stack : seq<StackValue>) : nat
  {
    match t
    case Between => 3
    case In => StringsFollowing(stack)
    case AttributeExists => 1
    case AttributeNotExists => 1
    case AttributeType => 1
    case BeginsWith => 2
    case Contains => 2
    case Size => 1
    case _ => 0
  }

  // evaluate the expression
  function method InnerEvalExpr(input : seq<Token>, stack : seq<StackValue>, item : DDB.AttributeMap) : Result<bool, Error>
  {
    if 0 == |input| then
      if 1 == |stack| && stack[0].Bool? then
        Success(stack[0].b)
      else
        Failure(E("ended with bad stack"))
    else
      var t := input[0];
      if t.Value? then
        InnerEvalExpr(input[1..], stack + [AsStr(t.s)], item)
      else if t.Attr? then
        InnerEvalExpr(input[1..], stack + [StackValueFromMap(t.s, item)], item)
      else if IsUnary(t) then
        if 0 == |stack| then
          Failure(E("Empty stack for unary op"))
        else
          var val :- apply_unary(t, stack[|stack|-1]);
          InnerEvalExpr(input[1..], stack[..|stack|-1] + [val], item)
      else if IsBinary(t) then
        if |stack| < 2 then
          Failure(E("Empty stack for binary op"))
        else
          var val :- apply_binary(t, stack[|stack|-2], stack[|stack|-1]);
          InnerEvalExpr(input[1..], stack[..|stack|-2] + [val], item)
      else if IsFunction(t) then
        var num_args := NumArgs(t, stack);
        if |stack| < num_args then
          Failure(E("Empty stack for function call"))
        else
          var val :- apply_function(t, stack, num_args);
          InnerEvalExpr(input[1..], stack[..|stack|-num_args] + [val], item)

      else
        Success(true)
  }

  // return the list of items for which the expression is true
  function method FilterItems(parsed : seq<Token>, ItemList : DDB.ItemList) : Result<DDB.ItemList, Error>
  {
    if |ItemList| == 0 then
      Success([])
    else
      var doesMatch :- EvalExpr(parsed, ItemList[0]);
      var rest :- FilterItems(parsed, ItemList[1..]);
      if doesMatch then
        Success(ItemList[0..0] + rest)
      else
        Success(rest)

  }

  // return the results for which the expression is true
  function method FilterResults(
    ItemList : DDB.ItemList,
    KeyExpression : Option<DDB.KeyExpression>,
    FilterExpression : Option<DDB.ConditionExpression>,
    ExpressionAttributeNames : Option<DDB.ExpressionAttributeNameMap>,
    ExpressionAttributeValues: Option<DDB.ExpressionAttributeValueMap>) : Result<DDB.ItemList, Error>
  {
    if |ItemList| == 0 || ExpressionAttributeValues.None? || (KeyExpression.None? && FilterExpression.None?) then
      Success(ItemList)
    else
      var afterKeys :-
        if KeyExpression.Some? then
          var parsed :- GetParsedExpr(KeyExpression.value);
          FilterItems(parsed, ItemList)
        else
          Success(ItemList);

      if FilterExpression.Some? then
        var parsed :- GetParsedExpr(FilterExpression.value);
        FilterItems(parsed, afterKeys)
      else
        Success(afterKeys)
  }

  // Get the name, possibly looking it up in the map
  function method GetName(s : string, ExpressionAttributeNames : Option<DDB.ExpressionAttributeNameMap>) : string
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

  datatype ExprContext = ExprContext (
    expr : Option<DDB.ConditionExpression>,
    values: Option<DDB.ExpressionAttributeValueMap>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )

  datatype ParsedContext = ParsedContext (
    expr : seq<Token>,
    values: DDB.ExpressionAttributeValueMap,
    names : Option<DDB.ExpressionAttributeNameMap>
  )

  // transform plain expression "A = B" into beacon expression "aws_dbe_b_A = beacon(B)"

  function method Beaconize(
    b : SI.BeaconVersion,
    context : ExprContext
  )
    : Result<ExprContext, Error>
  {
    if context.expr.None? || context.values.None? then
      Success(context)
    else
      var parsed := ParseExpr(context.expr.value);
      var context :- BeaconizeParsedExpr(b, parsed, 0, context.values.value, context.names);
      var exprString := ParsedExprToString(context.expr);
      Success(ExprContext(Some(exprString), Some(context.values), context.names))
  }
}
