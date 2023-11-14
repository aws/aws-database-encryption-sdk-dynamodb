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
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes
  import SI = SearchableEncryptionInfo
  import opened DynamoDbEncryptionUtil
  import FloatCompare
  import opened TermLoc
  import Seq
  import StandardLibrary.String
  import CompoundBeacon
  import SE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import Norm = DynamoDbNormalizeNumber

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
    names : Option<DDB.ExpressionAttributeNameMap>,
    tokensUntilSkip : int)
    : seq<string>
  {
    if |tokens| == 0 then
      []
    else if IsSpecial(tokens[0]) then
      ExtractAttributes2(tokens[1..], names, 1)
    else if tokens[0].Attr? && tokensUntilSkip == 0 then
      ExtractAttributes2(tokens[1..], names, -1)
    else if tokens[0].Attr? then
      [GetAttrName(tokens[0], names)] + ExtractAttributes2(tokens[1..], names, -1)
    else
      ExtractAttributes2(tokens[1..], names, tokensUntilSkip-1)
  }

  datatype Token =
    | Attr(s:string, loc : TermLoc)
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

  predicate method IsEquality(t : Token)
  {
    t.Eq? || t.Ne? || t.In?
  }

  predicate method IsInequality(t : Token)
  {
    t.Lt? || t.Le? || t.Gt? || t.Ge?
  }

  function method TokenToString(t : Token) : string
  {
    match t {
      case Attr(s, l) => s
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

  // if expr is "ATTR IN ( VAL, VAL, VAL... )"
  // and expr[pos] is one of the VAL's
  // return pos for the 'IN'
  // else return None
  function method {:tailrecursion} GetInPos(expr : seq<Token>, pos : nat) : (ret : Option<nat>)
    requires pos < |expr|
    requires expr[pos].Value?
    ensures ret.Some? ==> ret.value >= 1 && ret.value < |expr|
  {
    if pos < 3 then
      None
    else if expr[pos-1].Open? && expr[pos-2].In? then
      Some(pos-2)
    else if expr[pos-1].Comma? && expr[pos-2].Value? then
      GetInPos(expr, pos-2)
    else
      None
  }

  function method RealName(s : string) : string
  {
    if BeaconPrefix < s then
      s[|BeaconPrefix|..]
    else
      s
  }

  // true if Attr has a beacon, or needs a beacon
  predicate method HasBeacon(b : SI.BeaconVersion, t : Token, names : Option<DDB.ExpressionAttributeNameMap>)
  {
    if t.Attr? then
      var name := RealName(t.s);
      || name in b.beacons
      || (names.Some? && name in names.value && RealName(names.value[name]) in b.beacons)
      || name in b.encryptedFields
      || (names.Some? && name in names.value && RealName(names.value[name]) in b.encryptedFields)
    else
      false
  }

  function method GetBeacon2(b : SI.BeaconVersion, t : Token, names : Option<DDB.ExpressionAttributeNameMap>)
    : (ret : Result<SI.Beacon, Error>)
    requires HasBeacon(b, t, names)
    //= specification/searchable-encryption/beacons.md#partonly-initialization
    //= type=implication
    //# A query MUST fail if it tries to search on a PartOnly beacon directly.
    ensures
      var name := RealName(t.s);
      name in b.beacons && SI.IsPartOnly(b.beacons[name]) ==> ret.Failure?
  {
    var name := RealName(t.s);
    if name in b.beacons then
      if SI.IsPartOnly(b.beacons[name]) then
        Failure(E("Field " + name + " is encrypted, and has a PartOnly beacon, and so can only be used as part of a compound beacon."))
      else
        Success(b.beacons[name])
    else if names.Some? && name in names.value && RealName(names.value[name]) in b.beacons then
      var name2 := RealName(names.value[name]);
      Success(b.beacons[name2])
    else if name in b.encryptedFields then
      Failure(E("Field " + name + " is encrypted, and cannot be searched without a beacon."))
    else
      var name2 := RealName(names.value[name]);
      Failure(E("Field " + name2 + " is encrypted, and cannot be searched without a beacon."))
  }

  datatype EqualityBeacon = EqualityBeacon (
    beacon : Option<SI.Beacon>,
    forEquality : bool,
    forContains : bool
  )

  // returns Beacon, if any, and a flag indicating that the operation is exact match
  function method GetBeacon(
    bv : SI.BeaconVersion,
    t : Token,
    op : Token,
    value : Token,
    names : Option<DDB.ExpressionAttributeNameMap>,
    values : DDB.ExpressionAttributeValueMap
  )
    : Result<EqualityBeacon, Error>
    requires HasBeacon(bv, t, names)
    requires value.Value?
  {
    var b :- GetBeacon2(bv, t, names);
    var _ :- CanBeacon(b, op, value.s, values);
    Success(EqualityBeacon(Some(b), IsEquality(op), op == Contains))
  }

  function method GetBetweenBeacon(
    bv : SI.BeaconVersion,
    t : Token,
    op : Token,
    leftValue : Token,
    rightValue : Token,
    names : Option<DDB.ExpressionAttributeNameMap>,
    values : DDB.ExpressionAttributeValueMap
  )
    : (ret : Result<EqualityBeacon, Error>)
    requires HasBeacon(bv, t, names)
    requires leftValue.Value?
    requires rightValue.Value?
    //= specification/searchable-encryption/beacons.md#betweencomparable
    //= type=implication
    //# A Query MUST fail if it uses BETWEEN on values that are not BetweenComparable.
    ensures (
              && GetBeacon2(bv, t, names).Success?
              && var b := GetBeacon2(bv, t, names).value;
              && CanBetween(b, op, leftValue.s, rightValue.s, values).Failure?
            ) ==> ret.Failure?
  {
    var b :- GetBeacon2(bv, t, names);
    var _ :- CanBetween(b, op, leftValue.s, rightValue.s, values);
    Success(EqualityBeacon(Some(b), false, false))
  }

  function method CanStandardBeacon(op : Token) : (ret : Result<bool, Error>)
    ensures ret.Success? ==> ret.value
  {
    match op {
      case Ne | Lt | Gt | Le | Ge | Between | BeginsWith =>
        Failure(E("The operation '" + TokenToString(op) + "' cannot be used with a standard beacon."))
      case _ => Success(true)
    }
  }
  function method CanCompoundBeacon(b : SI.Beacon, op : Token, value : string) : (ret : Result<bool, Error>)
    requires b.Compound?
    ensures ret.Success? ==> ret.value

    //= specification/searchable-encryption/beacons.md#lessthancomparable
    //= type=implication
    //# A Query MUST fail if it uses `<`, `<=`, `>`, or `>=` on a value that is not LessThanComparable.
    ensures (
              && IsInequality(op)
              && var pieces := Split(value, b.cmp.split);
              && b.cmp.IsLessThanComparable(pieces).Success?
              && !b.cmp.IsLessThanComparable(pieces).value
            ) ==> ret.Failure?
  {
    match op {
      case Lt | Gt | Le | Ge =>
        var pieces := Split(value, b.cmp.split);
        var canLess :- b.cmp.IsLessThanComparable(pieces);
        if canLess then
          Success(true)
        else
          Failure(E("The operation '" + TokenToString(op) + "' cannot be used with a compound beacon, unless the value is LessThanComparable : " + value))
      // BeginsWith and Contains are dicey, but no way to distinguish good from bad
      case _ => Success(true)
    }
  }

  function method GetStringFromValue(value : string, values : DDB.ExpressionAttributeValueMap, b : SI.Beacon)
    : (ret : Result<string, Error>)
    requires b.Compound?
  {
    if value in values then
      var val := values[value];
      if val.S? then
        Success(val.S)
      else
        Failure(E("Value " + value + " supplied for compound beacon " + b.cmp.base.name +
                  " is of type " + AttrTypeToStr(val) + " but must be of type S (string)."))
    else
      Failure(E("Value " + value + " used in query string, but not supplied in value map."))
  }
  function method CanBeacon(
    b : SI.Beacon,
    op : Token,
    value : string,
    values : DDB.ExpressionAttributeValueMap
  )
    : (ret : Result<bool, Error>)
    ensures ret.Success? ==> ret.value
  {
    if b.Standard? then
      CanStandardBeacon(op)
    else
      var val :- GetStringFromValue(value, values, b);
      CanCompoundBeacon(b, op, val)
  }

  function method {:tailrecursion} RemoveCommonPrefix(x : seq<string>, y : seq<string>) : (seq<string>, seq<string>)
  {
    if |x| == 0 || |y| == 0 || x[0] != y[0] then
      (x, y)
    else
      RemoveCommonPrefix(x[1..], y[1..])
  }

  // Would return Outcome, if Outcome actually worked.
  function method CanBetween(
    b : SI.Beacon,
    op : Token,
    leftValue : string,
    rightValue : string,
    values : DDB.ExpressionAttributeValueMap
  )
    : (ret : Result<bool, Error>)
    ensures ret.Success? ==> ret.value
    //#  To determine if two values for a compound beacon in a query are `BetweenComparable`.
    //#
    //#  1 Remove any leading parts common to both values
    //#  1 Check if the remainder is [LessThanComparable](#lessthancomparable)
    //= specification/searchable-encryption/beacons.md#betweencomparable
    //= type=implication
    //# A Query MUST fail if it uses BETWEEN on values that are not BetweenComparable.
    ensures (
              && b.Compound?
              && GetStringFromValue(leftValue, values, b).Success?
              && var leftVal := GetStringFromValue(leftValue, values, b).value;
              && GetStringFromValue(rightValue, values, b).Success?
              && var rightVal := GetStringFromValue(rightValue, values, b).value;
              && var leftParts := Split(leftVal, b.cmp.split);
              && var rightParts := Split(rightVal, b.cmp.split);
              && var (newLeft, newRight) := RemoveCommonPrefix(leftParts, rightParts);
              && b.cmp.IsLessThanComparable(newLeft).Success?
              && var leftCanLess := b.cmp.IsLessThanComparable(newLeft).value;
              && b.cmp.IsLessThanComparable(newRight).Success?
              && var rightCanLess := b.cmp.IsLessThanComparable(newRight).value;
              && !(leftCanLess && rightCanLess)
            ) ==> ret.Failure?
  {
    if b.Standard? then
      Failure(E("The operation BETWEEN cannot be used with a standard beacon."))
    else
      // between is ok if both limits have a matching prefix followed by a signed part.
      var leftVal :- GetStringFromValue(leftValue, values, b);
      var rightVal :- GetStringFromValue(rightValue, values, b);
      var leftParts := Split(leftVal, b.cmp.split);
      var rightParts := Split(rightVal, b.cmp.split);
      var (newLeft, newRight) := RemoveCommonPrefix(leftParts, rightParts);
      var leftCanLess :- b.cmp.IsLessThanComparable(newLeft);
      var rightCanLess :- b.cmp.IsLessThanComparable(newRight);
      :- Need(leftCanLess && rightCanLess,
              E("To use BETWEEN with a compound beacon, the part after any common prefix must be LessThanComparable : "
                + "BETWEEN " + leftVal + " AND " + rightVal));
      Success(true)
  }


  // expr[pos] is a value; return the beacon to which that value refers
  // plus a flag to indicate if the operation is exact match
  function method BeaconForValue(
    b : SI.BeaconVersion,
    expr : seq<Token>,
    pos : nat,
    names : Option<DDB.ExpressionAttributeNameMap>,
    values : DDB.ExpressionAttributeValueMap
  )
    : Result<EqualityBeacon, Error>
    requires pos < |expr|
    requires expr[pos].Value?
  {
    // value < ATTR
    if pos+2 < |expr| && IsComp(expr[pos+1]) && HasBeacon(b, expr[pos+2], names) then
      GetBeacon(b, expr[pos+2], expr[pos+1], expr[pos], names, values)
    // ATTR < value
    else if 2 <= pos && IsComp(expr[pos-1]) && HasBeacon(b, expr[pos-2], names) then
      GetBeacon(b, expr[pos-2], expr[pos-1], expr[pos], names, values)
    // contains(ATTR, value .or. begins_with(ATTR, value
    else if 4 <= pos && (expr[pos-4].Contains? || expr[pos-4].BeginsWith?) && expr[pos-3].Open?
            && HasBeacon(b, expr[pos-2], names) && expr[pos-1].Comma? then
      GetBeacon(b, expr[pos-2], expr[pos-4], expr[pos], names, values)
    // contains(value, ATTR .or. begins_with(value, ATTR
    else if 2 <= pos < |expr|-2 && (expr[pos-2].Contains? || expr[pos-2].BeginsWith?) && expr[pos-1].Open?
            && HasBeacon(b, expr[pos+2], names) && expr[pos+1].Comma? then
      GetBeacon(b, expr[pos+2], expr[pos-2], expr[pos], names, values)
    // ATTR BETWEEN value AND *
    else if 2 <= pos < |expr|-2 && expr[pos-1].Between? && HasBeacon(b, expr[pos-2], names) && expr[pos+2].Value? then
      GetBetweenBeacon(b, expr[pos-2], expr[pos-1], expr[pos], expr[pos+2], names, values)
    // ATTR BETWEEN * and value
    else if 4 <= pos && expr[pos-1].And? && expr[pos-3].Between? && HasBeacon(b, expr[pos-4], names) && expr[pos-2].Value? then
      GetBetweenBeacon(b, expr[pos-4], expr[pos-3], expr[pos-2], expr[pos], names, values)
    // ATTR IN value, value, value, ...
    else if expr[pos].Value? then
      var in_pos := GetInPos(expr, pos);
      if in_pos.None? then
        Success(EqualityBeacon(None, true, false))
      else if HasBeacon(b, expr[in_pos.value-1], names) then
        GetBeacon(b, expr[in_pos.value-1], expr[in_pos.value], expr[pos], names, values)
      else
        Success(EqualityBeacon(None, true, false))
    else
      Success(EqualityBeacon(None, true, false))
  }

  // expr[pos] is a value; return the Attr to which that value refers
  function method AttrForValue(
    expr : seq<Token>,
    pos : nat
  )
    : (ret : Option<Token>)
    requires pos < |expr|
    requires expr[pos].Value?
    ensures ret.Some? ==> ret.value.Attr?
  {
    // value < ATTR
    if pos+2 < |expr| && IsComp(expr[pos+1]) && expr[pos+2].Attr? then
      Some(expr[pos+2])
    // ATTR < value
    else if 2 <= pos && IsComp(expr[pos-1]) && expr[pos-2].Attr? then
      Some(expr[pos-2])
    // contains(ATTR, value .or. begins_with(ATTR, value
    else if 4 <= pos && (expr[pos-4].Contains? || expr[pos-4].BeginsWith?) && expr[pos-3].Open?
            && expr[pos-2].Attr? && expr[pos-1].Comma? then
      Some(expr[pos-2])
    // ATTR BETWEEN value
    else if 2 <= pos && expr[pos-1].Between? && expr[pos-2].Attr? then
      Some(expr[pos-2])
    // ATTR BETWEEN * and value
    else if 4 <= pos && expr[pos-1].And? && expr[pos-3].Between? && expr[pos-4].Attr? then
      Some(expr[pos-4])
    // ATTR IN value, value, value, ...
    else
      var in_pos := GetInPos(expr, pos);
      if in_pos.None? then
        None
      else if expr[in_pos.value-1].Attr? then
        Some(expr[in_pos.value-1])
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
  // return false if that function can operate neither on encrypted values nor on beacons
  predicate method IsAllowedOnBeaconPred(expr : seq<Token>, pos : nat)
    requires pos < |expr|
    requires expr[pos].Attr?
  {
    // error if size(ATTR) or attribute_type(ATTR, type)
    // true otherwise
    if pos < 2 then
      true
    else if !expr[pos-1].Open? then
      true
    else if TokenAllowsBeacon(expr[pos-2]) then
      true
    else
      false
  }

  // expr[pos] is an argument to a function, which is an Attr which is a beacon
  // return an error if that function can operate neither on encrypted values nor on beacons
  function method IsAllowedOnBeacon(expr : seq<Token>, pos : nat, name : string) : Result<bool, Error>
    requires pos < |expr|
    requires expr[pos].Attr?
  {
    if IsAllowedOnBeaconPred(expr, pos) then
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
    oldValues: DDB.ExpressionAttributeValueMap,
    names : Option<DDB.ExpressionAttributeNameMap>,
    keys : MaybeKeyMap,
    newValues: DDB.ExpressionAttributeValueMap,
    acc : seq<Token> := []
  )
    : Result<ParsedContext, Error>
    requires pos <= |expr|
    decreases |expr| - pos
  {
    if pos == |expr| then
      Success(ParsedContext(acc, newValues, names))
    else if expr[pos].Attr? then
      var isIndirectName := "#" <= expr[pos].s;
      :- Need(!isIndirectName || (names.Some? && expr[pos].s in names.value), E("Name " + expr[pos].s + " not in ExpressionAttributeNameMap."));
      var oldName := if isIndirectName then names.value[expr[pos].s] else expr[pos].s;
      var exclude := keys.DontUseKeys? && !IsAllowedOnBeaconPred(expr, pos);
      if b.IsBeacon(oldName) && !exclude then
        var _ :- IsAllowedOnBeacon(expr, pos, oldName);
        if OpNeedsBeacon(expr, pos) then
          var newName := b.beacons[oldName].getBeaconName();
          if isIndirectName then
            BeaconizeParsedExpr(b, expr, pos+1, oldValues, Some(names.value[expr[pos].s := newName]), keys, newValues, acc + [expr[pos]])
          else
            BeaconizeParsedExpr(b, expr, pos+1, oldValues, names, keys, newValues, acc + [Attr(newName, TermLocMap(newName))])
        else
          BeaconizeParsedExpr(b, expr, pos+1, oldValues, names, keys, newValues, acc + [expr[pos]])
      else
        BeaconizeParsedExpr(b, expr, pos+1, oldValues, names, keys, newValues, acc + [expr[pos]])
    else if expr[pos].Value? then
      var name := expr[pos].s;
      :- Need(name in oldValues, E(name + " not found in ExpressionAttributeValueMap"));
      var oldValue := oldValues[name];
      var eb :- BeaconForValue(b, expr, pos, names, oldValues);
      var newValue :- if eb.beacon.None? then Success(oldValue) else eb.beacon.value.GetBeaconValue(oldValue, keys, eb.forEquality, eb.forContains);
      //= specification/dynamodb-encryption-client/ddb-support.md#queryinputforbeacons
      //# If a single value in ExpressionAttributeValues is used in more than one context,
      //# for example an expression of `this = :foo OR that = :foo` where `this` and `that`
      //# are both beacons, this operation MUST fail.
      :- Need(name !in newValues || newValues[name] == newValue, E(name + " used in two different contexts, which is not allowed."));
      BeaconizeParsedExpr(b, expr, pos+1, oldValues, names, keys, newValues[name := newValue], acc + [expr[pos]])
    else
      BeaconizeParsedExpr(b, expr, pos+1, oldValues, names, keys, newValues, acc + [expr[pos]])
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
    case Attr(s, loc) => true
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
    case Attr(s, loc) => 10
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
    else if ch == '_' then
      true
    else
      false
  }

  // valid attribute character
  predicate method AttributeChar(ch : char)
  {
    if ValueChar(ch) then
      true
    else if ch in [':' ,'[' ,']' ,'.','#'] then
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

  function method MakeAttr(s : string) : Token
  {
    var loc := MakeTermLoc(s);
    if loc.Success? then
      Attr(s, loc.value)
    else
      Attr(s, TermLocMap(s))
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
        (x, MakeAttr(s[0..x]))
      else
        var x := AttributeLen(s);
        (x, MakeAttr(s[0..x]))
  }

  function method {:opaque} VarOrSize(input: seq<Token>)
    : (ret : nat)
    ensures ret <= |input|
  {
    if |input| == 0 then
      0
    else if input[0].Value? || input[0].Attr? then
      1
    else if 3 < |input| && input[0].Size? && input[1].Open? && IsVar(input[2]) && input[3].Close? then
      4
    else
      0
  }

  // does it start with "A BETWEEN X AND Y"
  function method IsBetween(input: seq<Token>)
    : (ret : Option<(int, int, int)>)
    ensures ret.Some? ==> (ret.value.0 + ret.value.1 + ret.value.2 + 2) <= |input|
  {
    if |input| < 5 then
      None
    else
      var p1 := VarOrSize(input);
      if 0 < p1 && (p1+1 < |input|) && input[p1].Between? then
        var p2 := VarOrSize(input[p1+1..]);
        if 0 < p2 && (p1+p2+2 < |input|) && input[p1+p2+1].And? then
          var p3 := VarOrSize(input[p1+p2+2..]);
          if 0 < p3 then
            Some((p1, p2, p3))
          else
            None
        else
          None
      else
        None
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
    var between := IsBetween(input);
    if |input| < 5 then
      input
    else if IsIN(input) then
      [input[1], input[2], input[0], Comma] + ConvertToPrefix(input[3..])
    else if between.Some? then
      var b := between.value;
      [Between, Open] + input[0..b.0] + [Comma] + input[b.0+1..b.0+b.1+1] + [Comma]
      + input[b.0+b.1+2..b.0+b.1+b.2+2] + [Close] + ConvertToPrefix(input[b.0+b.1+b.2+2..])
    else
      [input[0]] + ConvertToPrefix(input[1..])
  }

  lemma TestConvertToPrefix3(input: seq<Token>)
    requires input == [MakeAttr("A"), In, Open, MakeAttr("B"), Comma, MakeAttr("C"), Close]
    ensures IsIN(input)
    ensures ConvertToPrefix(input) ==  [In, Open, MakeAttr("A"), Comma, MakeAttr("B"), Comma, MakeAttr("C"), Close]
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
      case Attr(s, loc)  => [input[0]] + ConvertToRpn_inner(input[1..], stack)
      case Value(s)  => [input[0]] + ConvertToRpn_inner(input[1..], stack)
      case Between | In | Not | AttributeExists | AttributeNotExists | AttributeType
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
          [stack[|stack|-1]] + ConvertToRpn_inner(input[1..], stack[..|stack|-1])
      case Eq | Ne | Lt | Gt | Le | Ge | And | Or =>
        if 0 == |stack| then
          ConvertToRpn_inner(input[1..], stack + [input[0]])
        else if Precedence(stack[|stack|-1]) >= Precedence(input[0]) then
          [stack[|stack|-1]] + ConvertToRpn_inner(input, stack[..|stack|-1])
        else
          ConvertToRpn_inner(input[1..], stack + [input[0]])
      case Open => ConvertToRpn_inner(input[1..], stack)
  }

  datatype StackValue =
    | Bool(b : bool)
    | Str(s : DDB.AttributeValue)
    | DoesNotExist

  function method GetSize(value : DDB.AttributeValue) : nat
  {
    match value {
      case S(s) => |s|
      case N(n) => |n|
      case B(n) => |n|
      case SS(n) => |n|
      case NS(n) => |n|
      case BS(n) => |n|
      case M(n) => |n|
      case L(n) => |n|
      case NULL(n) => 1
      case BOOL(n) => 1
    }
  }

  // returns the string value
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

  function method StackValueFromValue(
    s : string,
    values : DDB.ExpressionAttributeValueMap
  ) : StackValue
  {
    if s in values then
      Str(values[s])
    else
      DoesNotExist
  }

  function method StackValueFromItem(
    s : string,
    item : DDB.AttributeMap
  )
    : StackValue
  {
    if s in item then
      Str(item[s])
    else
      DoesNotExist
  }

  function method StackValueFromAttr(
    t : Token,
    item : DDB.AttributeMap,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    : StackValue
    requires t.Attr?
  {
    if names.Some? && t.s in names.value then
      StackValueFromItem(names.value[t.s], item)
    else
      var attr := TermToAttr(t.loc, item, names);
      if attr.Some? then
        Str(attr.value)
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

  // evaluate the expression, must be in reverse polish notation
  function method EvalExpr(
    input : seq<Token>,
    item : DDB.AttributeMap,
    names : Option<DDB.ExpressionAttributeNameMap>,
    values : DDB.ExpressionAttributeValueMap
  )
    : Result<bool, Error>
  {
    InnerEvalExpr(input, [], item, names, values)
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
  function method is_between(middle : DDB.AttributeValue, left : DDB.AttributeValue, right : DDB.AttributeValue) : Result<bool, Error>
  {
    var leftRet :- AttributeLE(left, middle);
    var rightRet :- AttributeLE(middle, right);
    Success(leftRet && rightRet)
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
          var ret :- is_between(stack[|stack|-3].s, stack[|stack|-2].s, stack[|stack|-1].s);
          Success(Bool(ret))
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
          Success(Bool(IsAttrType(stack[|stack|-2], stack[|stack|-1])))
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

      case Size =>
        if |stack| < 1 then
          Failure(E("No Stack for Size"))
        else if !stack[|stack|-1].Str? then
          Failure(E("Wrong Types for Size"))
        else
          var n := GetSize(stack[|stack|-1].s);
          Success(Str(DDB.AttributeValue.N(String.Base10Int2String(n))))
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

  function method CompareFloat(x : string, y : string) : Result<FloatCompare.CompareType, Error>
  {
    var newX :- Norm.NormalizeNumber(x).MapFailure(e => E(e));
    var newY :- Norm.NormalizeNumber(y).MapFailure(e => E(e));
    Success(FloatCompare.CompareFloat(newX, newY))
  }

  function method AttributeEQ(a : DDB.AttributeValue, b : DDB.AttributeValue) : Result<bool, Error>
  {
    if a.N? && b.N? then
      var ret :- CompareFloat(a.N, b.N);
      Success(ret == 0)
    else
      Success(a == b)
  }

  function method AttributeNE(a : DDB.AttributeValue, b : DDB.AttributeValue) : Result<bool, Error>
  {
    var ret :- AttributeEQ(a, b);
    Success(!ret)
  }

  function method AttributeLE(a : DDB.AttributeValue, b : DDB.AttributeValue) : Result<bool, Error>
  {
    if a.N? && b.N? then
      var ret :- CompareFloat(a.N, b.N);
      Success(ret <= 0)
    else if a.S? && b.S? then
      Success(LexicographicLessOrEqual(a.S, b.S, CharLess))
    else if a.B? && b.B? then
      Success(LexicographicLessOrEqual(a.B, b.B, ByteLess))
    else
      Success(false)
  }
  function method AttributeLT(a : DDB.AttributeValue, b : DDB.AttributeValue) : Result<bool, Error>
  {
    var ret :- AttributeLE(b,a);
    Success(!ret)
  }
  function method AttributeGT(a : DDB.AttributeValue, b : DDB.AttributeValue) : Result<bool, Error>
  {
    var ret :- AttributeLE(a,b);
    Success(!ret)
  }
  function method AttributeGE(a : DDB.AttributeValue, b : DDB.AttributeValue) : Result<bool, Error>
  {
    var ret :- AttributeLE(b,a);
    Success(ret)
  }

  // apply the comparison function
  function method apply_binary_comp(input : Token, x : DDB.AttributeValue, y : DDB.AttributeValue) : Result<bool, Error>
  {
    match input
    case Eq => AttributeEQ(x, y)
    case Ne => AttributeNE(x, y)
    case Le => AttributeLE(x, y)
    case Lt => AttributeLT(x, y)
    case Ge => AttributeGE(x, y)
    case Gt => AttributeGT(x, y)
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
    case AttributeType => 2
    case BeginsWith => 2
    case Contains => 2
    case Size => 1
    case _ => 0
  }

  // evaluate the expression
  function method InnerEvalExpr(
    input : seq<Token>,
    stack : seq<StackValue>,
    item : DDB.AttributeMap,
    names : Option<DDB.ExpressionAttributeNameMap>,
    values : DDB.ExpressionAttributeValueMap
  )
    : Result<bool, Error>
  {
    if 0 == |input| then
      if 1 == |stack| && stack[0].Bool? then
        Success(stack[0].b)
      else
        Failure(E("ended with bad stack"))
    else
      var t := input[0];
      if t.Value? then
        InnerEvalExpr(input[1..], stack + [StackValueFromValue(t.s, values)], item, names, values)
      else if t.Attr? then
        InnerEvalExpr(input[1..], stack + [StackValueFromAttr(t, item, names)], item, names, values)
      else if IsUnary(t) then
        if 0 == |stack| then
          Failure(E("Empty stack for unary op"))
        else
          var val :- apply_unary(t, stack[|stack|-1]);
          InnerEvalExpr(input[1..], stack[..|stack|-1] + [val], item, names, values)
      else if IsBinary(t) then
        if |stack| < 2 then
          Failure(E("Empty stack for binary op"))
        else
          var val :- apply_binary(t, stack[|stack|-2], stack[|stack|-1]);
          InnerEvalExpr(input[1..], stack[..|stack|-2] + [val], item, names, values)
      else if IsFunction(t) then
        var num_args := NumArgs(t, stack);
        if |stack| < num_args then
          Failure(E("Empty stack for function call"))
        else
          var val :- apply_function(t, stack, num_args);
          InnerEvalExpr(input[1..], stack[..|stack|-num_args] + [val], item, names, values)
      else
        Success(true)
  }

  // return the list of items for which the expression is true
  method FilterItems(
    b : SI.BeaconVersion,
    parsed : seq<Token>,
    ItemList : DDB.ItemList,
    names : Option<DDB.ExpressionAttributeNameMap>,
    values : DDB.ExpressionAttributeValueMap
  )
    returns (output : Result<DDB.ItemList, Error>)
    requires b.ValidState()
    ensures b.ValidState()
    modifies b.Modifies()
  {
    if |ItemList| == 0 {
      return Success([]);
    }
    var newAttrs :- b.GeneratePlainBeacons(ItemList[0]);
    var doesMatch :- EvalExpr(parsed, ItemList[0] + newAttrs, names, values);
    var rest :- FilterItems(b, parsed, ItemList[1..], names, values);
    if doesMatch {
      return Success(ItemList[..1] + rest);
    } else {
      return Success(rest);
    }
  }

  // return the results for which the expression is true
  method FilterResults(
    b : SI.BeaconVersion,
    ItemList : DDB.ItemList,
    KeyExpression : Option<DDB.KeyExpression>,
    FilterExpression : Option<DDB.ConditionExpression>,
    names : Option<DDB.ExpressionAttributeNameMap>,
    values: Option<DDB.ExpressionAttributeValueMap>)
    returns (output : Result<DDB.ItemList, Error>)
    requires b.ValidState()
    ensures b.ValidState()
    modifies b.Modifies()
  {
    if |ItemList| == 0 || (KeyExpression.None? && FilterExpression.None?) {
      return Success(ItemList);
    } else {
      var afterKeys;
      if KeyExpression.Some? {
        var parsed := ParseExpr(KeyExpression.value);
        var expr :- BeaconizeParsedExpr(b, parsed, 0, values.UnwrapOr(map[]), names, DontUseKeys, map[]);
        var expr1 := ConvertToPrefix(expr.expr);
        var expr2 := ConvertToRpn(expr1);
        afterKeys :- FilterItems(b, expr2, ItemList, expr.names, expr.values);
      } else {
        afterKeys := ItemList;
      }
      if FilterExpression.Some? {
        var parsed := ParseExpr(FilterExpression.value);
        var expr :- BeaconizeParsedExpr(b, parsed, 0, values.UnwrapOr(map[]), names, DontUseKeys, map[]);
        var expr1 := ConvertToPrefix(expr.expr);
        var expr2 := ConvertToRpn(expr1);
        output := FilterItems(b, expr2, afterKeys, expr.names, expr.values);
      } else {
        return Success(afterKeys);
      }
    }
  }

  // Find the KeyId for in this Value
  function method KeyIdFromPart(bv : SI.BeaconVersion, keyIdField : string, attr : string, value : string)
    : Option<string>
  {
    if attr !in bv.beacons || bv.beacons[attr].Standard? then
      None
    else
      var parts := bv.beacons[attr].cmp.parts;
      var theParts := Seq.Filter((p : CompoundBeacon.BeaconPart) => p.Signed? && p.loc[0].key == keyIdField, parts);
      if |theParts| != 1 then
        None
      else
        var pieces := Split(value, bv.beacons[attr].cmp.split);
        var piece := Seq.Filter((s : string) => theParts[0].prefix <= s, pieces);
        if |piece| != 1 then
          None
        else
          var p := piece[0];
          assert theParts[0].prefix <= p;
          Some(p[|theParts[0].prefix|..])
  }

  // Find the KeyId for the Attribute Value pair
  function method KeyIdFromAttr(bv : SI.BeaconVersion, attr : Option<Token>, value : string, names : Option<DDB.ExpressionAttributeNameMap>)
    : Option<string>
    requires bv.keySource.keyLoc.MultiLoc?
    requires attr.None? || attr.value.Attr?
  {
    if attr.None? then
      None
    else
      var name := if names.Some? && attr.value.s in names.value then names.value[attr.value.s] else attr.value.s;
      var keyIdField := bv.keySource.keyLoc.keyName;
      if keyIdField == attr.value.s then
        Some(value)
      else
        KeyIdFromPart(bv, keyIdField, attr.value.s, value)
  }

  // search through each token of a query expression, looking for KeyIds
  function method {:tailrecursion} GetBeaconKeyIds2(
    pos : nat,
    bv : SI.BeaconVersion,
    expr : seq<Token>,
    values: DDB.ExpressionAttributeValueMap,
    names : Option<DDB.ExpressionAttributeNameMap>,
    soFar : seq<string>
  )
    : Result<seq<string>, Error>
    requires bv.keySource.keyLoc.MultiLoc?
    requires pos <= |expr|
    decreases |expr| - pos
  {
    if pos == |expr| then
      Success(soFar)
    else if expr[pos].Value? then
      :- Need(expr[pos].s in values, E(expr[pos].s + " not found in ExpressionAttributeValueMap"));
      var oldValue := values[expr[pos].s];
      if oldValue.S? then
        var attr := AttrForValue(expr, pos);
        var keyId := KeyIdFromAttr(bv, attr, oldValue.S, names);
        if keyId.None? || keyId.value in soFar then
          GetBeaconKeyIds2(pos+1, bv, expr, values, names, soFar)
        else
          GetBeaconKeyIds2(pos+1, bv, expr, values, names, soFar + [keyId.value])
      else
        GetBeaconKeyIds2(pos+1, bv, expr, values, names, soFar)
    else
      GetBeaconKeyIds2(pos+1, bv, expr, values, names, soFar)
  }

  // Search through the query expression to find any Multi-Tenant KeyIds
  function method GetBeaconKeyIds(
    bv : SI.BeaconVersion,
    expr : Option<DDB.ConditionExpression>,
    values: DDB.ExpressionAttributeValueMap,
    names : Option<DDB.ExpressionAttributeNameMap>,
    soFar : seq<string>
  )
    : Result<seq<string>, Error>
    requires bv.keySource.keyLoc.MultiLoc?
  {
    if expr.None? then
      Success(soFar)
    else
      var parsed := ParseExpr(expr.value);
      GetBeaconKeyIds2(0, bv, parsed, values, names, soFar)
  }

  // Search through the query expressions to find the Multi-Tenant KeyId
  // if not multi-tenant, return None
  // if multi-tenant, and there's exactly one KeyId, return Some(keyId)
  // else fail
  function method GetBeaconKeyId(
    bv : SI.BeaconVersion,
    keyExpr : Option<DDB.ConditionExpression>,
    filterExpr : Option<DDB.ConditionExpression>,
    values: Option<DDB.ExpressionAttributeValueMap>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    : (ret : Result<MaybeKeyId, Error>)

    //= specification/searchable-encryption/search-config.md#get-beacon-key-for-query
    //= type=implication
    //# If the [Beacon Key Source](#beacon-key-source) is a [Single Key Store](#single-key-store-initialization)
    //# then `beacon key id` MUST be the configured [beacon key id](#beacon-key-id)
    ensures !bv.keySource.keyLoc.MultiLoc? ==> ret == Success(DontUseKeyId)

    ensures ret.Success? && bv.keySource.keyLoc.MultiLoc? && values.Some? ==>
              && GetBeaconKeyIds(bv, keyExpr, values.value, names, []).Success?
              && var soFar := GetBeaconKeyIds(bv, keyExpr, values.value, names, []).value;
              && GetBeaconKeyIds(bv, filterExpr, values.value, names, soFar).Success?
              && var final := GetBeaconKeyIds(bv, filterExpr, values.value, names, soFar).value;

              //= specification/searchable-encryption/search-config.md#get-beacon-key-for-query
              //= type=implication
              //# If this list of beacon key ids is empty get beacon key for query MUST
              //# return a flag indicating this.
              && (|final| == 0 ==> ret == Success(ShouldHaveKeyId))

              //= specification/searchable-encryption/search-config.md#get-beacon-key-for-query
              //= type=implication
              //# `beacon key id` MUST be this unique value.
              && (|final| == 1 ==> ret == Success(KeyId(final[0])))

              //= specification/searchable-encryption/search-config.md#get-beacon-key-for-query
              //= type=implication
              //# If this list of beacon key ids has more than one unique beacon key id
              //# then get beacon key for query MUST fail.
              && (|final| > 1 ==> ret.Failure?)
  {
    if !bv.keySource.keyLoc.MultiLoc? then
      Success(DontUseKeyId)
    else if values.None? then
      Success(ShouldHaveKeyId)
    else
      var soFar :- GetBeaconKeyIds(bv, keyExpr, values.value, names, []);
      var final :- GetBeaconKeyIds(bv, filterExpr, values.value, names, soFar);
      if |final| == 1 then
        Success(KeyId(final[0]))
      else if |final| == 0 then
        Success(ShouldHaveKeyId)
      else
        Failure(E("Multiple values found for " + bv.keySource.keyLoc.keyName + " in query : " + Join(final, ", ")))
  }

  datatype ExprContext = ExprContext (
    keyExpr : Option<DDB.KeyExpression>,
    filterExpr : Option<DDB.ConditionExpression>,
    values: Option<DDB.ExpressionAttributeValueMap>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )

  datatype ParsedContext = ParsedContext (
    expr : seq<Token>,
    values: DDB.ExpressionAttributeValueMap,
    names : Option<DDB.ExpressionAttributeNameMap>
  )

  // transform plain expression "A = B" into beacon expression "aws_dbe_b_A = beacon(B)"
  // if naked == true, it becomes "aws_dbe_b_A = B"
  method Beaconize(
    b : SI.BeaconVersion,
    context : ExprContext,
    keyId : MaybeKeyId,
    naked : bool := false
  )
    returns (output : Result<ExprContext, Error>)
    requires b.ValidState()
    ensures b.ValidState()
    modifies b.Modifies()
  {
    if (context.keyExpr.None? && context.filterExpr.None?) {
      return Success(context);
    } else {
      var keys := DontUseKeys;
      if !naked {
        keys :- b.getKeyMap(keyId);
      }
      var values :=
        if context.values.Some? then
          context.values.value
        else
          map[];
      var newValues : DDB.ExpressionAttributeValueMap := map[];
      var newKeyExpr := context.keyExpr;
      var newFilterExpr := context.filterExpr;
      var newNames := context.names;

      if context.keyExpr.Some? {
        var parsed := ParseExpr(context.keyExpr.value);
        var newContext :- BeaconizeParsedExpr(b, parsed, 0, values, newNames, keys, newValues);
        newKeyExpr := Some(ParsedExprToString(newContext.expr));
        newValues := newContext.values;
        newNames := newContext.names;
      }
      if context.filterExpr.Some? {
        var parsed := ParseExpr(context.filterExpr.value);
        var newContext :- BeaconizeParsedExpr(b, parsed, 0, values, newNames, keys, newValues);
        newFilterExpr := Some(ParsedExprToString(newContext.expr));
        newValues := newContext.values;
        newNames := newContext.names;
      }
      return Success(ExprContext(newKeyExpr, newFilterExpr, if |newValues| == 0 then None else Some(newValues), newNames));
    }
  }

  function method GetAttrName(t : Token, names : Option<DDB.ExpressionAttributeNameMap>) : string
    requires t.Attr?
  {
    if names.Some? && t.s in names.value then
      names.value[t.s]
    else
      t.s
  }

  // return an error if any encrypted field exists in the query
  method TestParsedExpr(
    expr : seq<Token>,
    encrypted : set<string>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    returns (output : Outcome<Error>)
  {
    for i := 0 to |expr| {
      if expr[i].Attr? {
        var name := GetAttrName(expr[i], names);
        if name in encrypted {
          return Fail(E("Query is using encrypted field : " + name + "."));
        }
      }
    }
    return Pass;
  }

  // return an error if any encrypted field exists in the query
  method TestBeaconize(
    actions : AttributeActions,
    keyExpr : Option<DDB.KeyExpression>,
    filterExpr : Option<DDB.ConditionExpression>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    returns (output : Result<bool, Error>)
  {
    var encrypted := set k <- actions | actions[k] == SE.ENCRYPT_AND_SIGN :: k;
    if keyExpr.Some? {
      :- TestParsedExpr(ParseExpr(keyExpr.value), encrypted, names);
    }
    if filterExpr.Some? {
      :- TestParsedExpr(ParseExpr(filterExpr.value), encrypted, names);
    }
    return Success(true);
  }

}
