// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypesWrapped.dfy"

module {:options "-functionSyntax:4"} DdbItemJson {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened JSON.Values
  import opened DynamoDbEncryptionUtil
  import opened ComAmazonawsDynamodbTypes
  import opened SortedSets
  import StandardLibrary.String
  import Base64
  import Norm = DynamoDbNormalizeNumber

  predicate IsDecimalDigit(ch : char)
  {
    '0' <= ch <= '9'
  }

  // unsigned base 10 string to integer
  function {:tailrecursion} StrToNat(s : string, acc : nat := 0) : Result<nat, string>
  {
    if |s| == 0 then
      Success(acc)
    else if IsDecimalDigit(s[0]) then
      StrToNat(s[1..], acc * 10 + s[0] as int - '0' as int)
    else
      Failure("The character '" + s[..1] + "' is not a valid decimal digit.")
  }

  // signed base 10 string to integer
  function StrToInt(s : string) : Result<int, string>
  {
    if |s| == 0 then
      Failure("An empty string is not a valid number.")
    else if s[0] == '-' then
      :- Need(1 < |s|, "An empty string is not a valid number.");
      var x :- StrToNat(s[1..]);
      Success(-(x as int))
    else if s[0] == '+' then
      :- Need(1 < |s|, "An empty string is not a valid number.");
      StrToNat(s[1..])
    else
      StrToNat(s)
  }

  // Return a string of this many zeros
  function Zeros(n : nat) : (ret : string)
  {
    seq(n, i => '0')
  }

  // return the input string with unnecessary leading zeros removed
  function {:tailrecursion} SkipLeadingZeros(val : string) : (ret : string)
  {
    if 1 < |val| && val[0] == '0' && val[1] != '.' then
      SkipLeadingZeros(val[1..])
    else
      val
  }

  function {:tailrecursion} SkipTrailingZeros(val : string) : (ret : string)
    ensures |ret| == 0 || ret[|ret|-1] != '0'
  {
    if 0 < |val| && val[|val|-1] == '0' then
      SkipTrailingZeros(val[..|val|-1])
    else
      val
  }

  function {:tailrecursion} Pow10(val : int, exp : nat) : (ret : int)
    decreases exp
  {
    if exp == 0 then
      val
    else
      Pow10(val * 10, exp - 1)
  }

  function DigitsToDecimal(num: string, sign : int, exp : int) : Result<Decimal, string>
  {
    if |num| == 0 then
      Success(Decimal(sign, exp))
    else if '.' in num then
      var (pre, post) := SplitOnce(num, '.');
      var pre := SkipLeadingZeros(pre);
      var post := SkipTrailingZeros(post);
      var val :- StrToInt(num);
      if |post| == 0 then
        Success(Decimal(sign*val, exp))
      else if |pre| == 0 then
        var val :- StrToInt(post);
        Success(Decimal(sign*val, exp - |post|))
      else
        var exp := exp - |post|;
        var val := Pow10(val, |post|);
        var frac :- StrToInt(post);
        Success(Decimal(sign*val + frac, exp))
    else
      var val :- StrToInt(num);
      Success(Decimal(sign*val, exp))
  }

  function StringToDecimalUnsigned(num: string, sign : int) : Result<Decimal, string>
  {
    if |num| == 0 then
      Failure("An empty string is not a number")
    else if 'e' in num then
      var (digits, exp) := SplitOnce(num, 'e');
      var expInt :- StrToInt(exp);
      DigitsToDecimal(digits, sign, expInt)
    else if 'E' in num then
      var (digits, exp) := SplitOnce(num, 'E');
      var expInt :- StrToInt(exp);
      DigitsToDecimal(digits, sign, expInt)
    else
      DigitsToDecimal(num, sign, 0)
  }

  function StringToDecimal(num: string) : Result<Decimal, string>
  {
    if |num| == 0 then
      Failure("An empty string is not a number")
    else if num[0] == '+' then
      StringToDecimalUnsigned(num[1..], 1)
    else if num[0] == '-' then
      StringToDecimalUnsigned(num[1..], -1)
    else if IsDecimalDigit(num[0]) then
      StringToDecimalUnsigned(num, 1)
    else
      Failure("Invalid character in number : " + num)
  }

  function BinaryToString(data: seq<uint8>) : string
  {
    Base64.Encode(data)
  }

  function StringToBinary(str : string) : Result<seq<uint8>, string>
  {
    Base64.Decode(str)
  }

  function DdbStringType(s : string) : JSON
  {
    Object([("S", String(s))])
  }
  function DdbNumberType(s : string) : JSON
  {
    Object([("N", String(s))])
  }
  function DdbBinaryType(b : seq<uint8>) : JSON
  {
    Object([("B", String(BinaryToString(b)))])
  }
  function DdbMapType(b : seq<(string, JSON)>) : JSON
  {
    Object([("M", Object(b))])
  }
  function DdbListType(b : seq<JSON>) : JSON
  {
    Object([("L", Array(b))])
  }
  function DdbBoolType(b : bool) : JSON
  {
    Object([("BOOL", Bool(b))])
  }
  function DdbNullType() : JSON
  {
    Object([("NULL", Bool(true))])
  }
  function DdbStringSetType(s : seq<JSON>) : JSON
  {
    Object([("SS", Array(s))])
  }
  function DdbNumberSetType(s : seq<JSON>) : JSON
  {
    Object([("NS", Array(s))])
  }
  function DdbBinarySetType(s : seq<JSON>) : JSON
  {
    Object([("BS", Array(s))])
  }

  method DdbValueToJson(item : AttributeValue) returns (output : Result<JSON, string>)
    decreases item
  {
    match item {
      case S(s) => return Success(DdbStringType(s));
      case N(n) => return Success(DdbNumberType(n));
      case B(b) => return Success(DdbBinaryType(b));
      case SS(ss) => var x :- DdbStringSetToJson(ss); return Success(DdbStringSetType(x));
      case NS(ss) => var x :- DdbStringSetToJson(ss); return Success(DdbNumberSetType(x));
      case BS(ss) => var x :- DdbBinarySetToJson(ss); return Success(DdbBinarySetType(x));
      case M(m) =>
        var keys := ComputeSetToSequence(m.Keys);
        var result : seq<(string, JSON)> := [];
        for i := 0 to |keys| {
          var json :- DdbValueToJson(m[keys[i]]);
          result := result + [(keys[i], json)];
        }
        return Success(DdbMapType(result));

      case L(l) => var x :- DdbListToJson(l); output := Success(DdbListType(x));
      case NULL(n) => return Success(DdbNullType());
      case BOOL(b) => return Success(DdbBoolType(b));
    }
  }

  method DdbListToJson(list : ListAttributeValue) returns (output : Result<seq<JSON>, string>)
  {
    var result : seq<JSON> := [];
    for i := 0 to |list| {
      var val :- DdbValueToJson(list[i]);
      result := result + [val];
    }
    return Success(result);
  }

  method DdbStringSetToJson(list : StringSetAttributeValue) returns (output : Result<seq<JSON>, string>)
  {
    var result : seq<JSON> := [];
    for i := 0 to |list| {
      result := result + [String(list[i])];
    }
    return Success(result);
  }

  method DdbBinarySetToJson(list : BinarySetAttributeValue) returns (output : Result<seq<JSON>, string>)
  {
    var result : seq<JSON> := [];
    for i := 0 to |list| {
      result := result + [String(BinaryToString(list[i]))];
    }
    return Success(result);
  }

  method DdbItemToJson(item : AttributeMap) returns (output : Result<JSON, string>)
  {
    var keys := ComputeSetToSequence(item.Keys);
    var result : seq<(string, JSON)> := [];
    for i := 0 to |keys| {
      var json :- DdbValueToJson(item[keys[i]]);
      result := result + [(keys[i], json)];
    }
    return Success(Object(result));
  }

  method GetAttrValue(data : JSON) returns (output : Result<DDB.AttributeValue, string>)
  {
    if data.String? {
      return Success(DDB.AttributeValue.S(data.str));
    } else if data.Number? {
      var n :- DecimalToStr(data.num);
      return Success(DDB.AttributeValue.N(n));
    } else if data.Object? {
      :- Need(|data.obj| == 1, "Attribute Value Objects must contain only one thing.");
      output := GetAttrValueObj(data.obj[0].0,data.obj[0].1);
    } else {
      return Failure("Attribute Value must be a string or an object.");
    }

  }
  method GetAttrValueObj(typeStr : string, data : JSON) returns (output : Result<DDB.AttributeValue, string>)
    decreases data
  {
    match typeStr {
      case "S" =>
        :- Need(data.String?, "Value for 'S' must be a string");
        return Success(DDB.AttributeValue.S(data.str));
      case "SS" =>
        :- Need(data.Array?, "Value for 'SS' must be a Array");
        var result : seq<string> := [];
        for i := 0 to |data.arr| {
          :- Need(data.arr[i].String?, "Values for 'SS' must be Strings");
          result := result + [data.arr[i].str];
        }
        return Success(DDB.AttributeValue.SS(result));
      case "N" =>
        :- Need(data.String?, "Value for 'S' must be a string");
        return Success(DDB.AttributeValue.N(data.str));
      case "NS" =>
        :- Need(data.Array?, "Value for 'NS' must be a Array");
        var result : seq<string> := [];
        for i := 0 to |data.arr| {
          if data.arr[i].String? {
            result := result + [data.arr[i].str];
          } else if data.arr[i].Number? {
            var val :- DecimalToStr(data.arr[i].num);
            result := result + [val];
          } else {
            return Failure("Values for 'NS' must be Strings or Numbers");
          }
        }
        return Success(DDB.AttributeValue.NS(result));
      case "B" =>
        :- Need(data.String?, "Value for 'B' must be a string");
        var val :- StringToBinary(data.str);
        return Success(DDB.AttributeValue.B(val));
      case "BS" =>
        :- Need(data.Array?, "Value for 'BS' must be a Array");
        var result : seq<Bytes> := [];
        for i := 0 to |data.arr| {
          :- Need(data.arr[i].String?, "Values for 'BS' must be Strings");
          var val :- StringToBinary(data.arr[i].str);
          result := result + [val];
        }
        return Success(DDB.AttributeValue.BS(result));
      case "L" =>
        :- Need(data.Array?, "Value for 'L' must be a Array");
        var result : seq<DDB.AttributeValue> := [];
        for i := 0 to |data.arr| {
          var val :- GetAttrValue(data.arr[i]);
          result := result + [val];
        }
        return Success(DDB.AttributeValue.L(result));
      case "M" =>
        :- Need(data.Object?, "Value for 'M' must be an Object");
        var result : DDB.AttributeMap := map[];
        for i := 0 to |data.obj| {
          var obj := data.obj[i];
          :- Need(DDB.IsValid_AttributeName(obj.0), obj.0 + " is not a valid attribute name.");
          var val :- GetAttrValue(obj.1);
          result := result[obj.0 := val];
        }
        return Success(DDB.AttributeValue.M(result));
      case "BOOL" =>
        :- Need(data.Bool?, "Value for 'BOOL' must be a Bool");
        return Success(DDB.AttributeValue.BOOL(data.b));
      case "NULL" =>
        return Success(DDB.AttributeValue.NULL(true));
      case _ => return Failure("Unexpected Attribute Type '" + typeStr + "'.\n");
    }
  }

  method JsonToDdbItem(data : JSON) returns (output : Result<AttributeMap, string>)
    ensures output.Success? ==> data.Object?
  {
    :- Need(data.Object?, "Value for a ddb item must be a JSON object.");
    var item : DDB.AttributeMap := map[];

    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      :- Need(DDB.IsValid_AttributeName(obj.0), obj.0 + " is not a valid attribute name");
      var value :- GetAttrValue(obj.1);
      item := item[obj.0 := value];
    }
    return Success(item);
  }

  function DecimalToStr(num: Decimal) : Result<string, string>
  {
    if num.n == 0 then
      Success("0")
    else
      :- Need(-1000 < num.e10 < 1000, "Exponent must be between -1000 and 1000");
      var str := String.Base10Int2String(num.n);
      if num.e10 >= 0 then
        Success(str + Zeros(num.e10))
      else if -num.e10 < |str| then
        var pos := |str| + num.e10;
        Success(str[..pos] + "." + str[pos..])
      else
        Success("0." + Zeros(|str| - num.e10) + str)
  }

  function NormalizeItem(value : DDB.AttributeMap) : DDB.AttributeMap
  {
    map k <- value :: k := Normalize(value[k])
  }

  function Normalize(value : DDB.AttributeValue) : DDB.AttributeValue
  {
    match value {
      case N(n) =>
        var nn := Norm.NormalizeNumber(n);
        if nn.Success? then
          DDB.AttributeValue.N(nn.value)
        else
          value
      case SS(s) =>
        var asSet := Seq.ToSet(s);
        DDB.AttributeValue.SS(SortedSets.ComputeSetToOrderedSequence2(asSet, CharLess))
      case NS(s) =>
        var normList := Seq.MapWithResult(n => Norm.NormalizeNumber(n), s);
        if normList.Success? then
          var asSet := Seq.ToSet(normList.value);
          DDB.AttributeValue.NS(SortedSets.ComputeSetToOrderedSequence2(asSet, CharLess))
        else
          value
      case BS(s) =>
        var asSet := Seq.ToSet(s);
        DDB.AttributeValue.BS(SortedSets.ComputeSetToOrderedSequence2(asSet, ByteLess))
      case L(list) =>
        // for some reason, Seq.Map() fails for verify, even when revealed
        var value := seq(|list|, i requires 0 <= i < |list| => Normalize(list[i]));
        DDB.AttributeValue.L(value)
      case M(m) =>
        DDB.AttributeValue.M(map k <- m :: k := Normalize(m[k]))
      case _ => value
    }
  }

}