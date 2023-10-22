// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes.dfy"
include "../../../../DynamoDbEncryption/dafny/StructuredEncryption/Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "../../../../DynamoDbEncryption/dafny/StructuredEncryption/src/Footer.dfy"
include "Permute.dfy"
include "Counter.dfy"

module {:options "-functionSyntax:4"} ValidatePermuted {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes
  import SET = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SE = StructuredEncryptionUtil
  import opened StructuredEncryptionFooter
  import opened StandardLibrary.String
  import Permutations
  import CounterClass

  const SET_T  : uint8 := 0x01
  const STRING_T  : uint8 := 0x01
  const NUMBER_T  : uint8 := 0x02
  const BINARY_T : uint8 := 0xFF
  const MAP_T  : uint8 := 0x02
  const LIST_T : uint8 := 0x03
  const NULL_T : uint8 := 0x00

  const STRING_SET : SET.TerminalTypeId := [SET_T,  STRING_T]
  const NUMBER_SET : SET.TerminalTypeId := [SET_T,  NUMBER_T]
  const BINARY_SET : SET.TerminalTypeId := [SET_T,  BINARY_T]
  const MAP        : SET.TerminalTypeId := [MAP_T,  NULL_T]
  const LIST       : SET.TerminalTypeId := [LIST_T, NULL_T]

  const TYPEID_LEN : nat := 2   // number of bytes in a TerminalTypeId
  const LENGTH_LEN : nat := 4 // number of bytes in an encoded count or length
  const PREFIX_LEN : nat := 6 // number of bytes in a prefix, i.e. 2-byte type and 4-byte length

  // string to Error
  function E(s : string) : Error {
    DynamoDbPermuteDecryptorException(message := s)
  }

  method Validate(
    footer : Footer,
    client: Primitives.AtomicPrimitivesClient,
    mat : CMP.DecryptionMaterials,
    edks : CMP.EncryptedDataKeyList,
    signedFields : seq<SE.CanonicalPath>,
    encFields : seq<SE.CanonicalPath>,
    encData : SE.StructuredDataCanon,
    allData : SE.StructuredDataCanon,
    header : SE.Bytes,
    maxSetSize : nat)
    returns (ret : Result<SE.StructuredDataCanon, Error>)
    requires Materials.DecryptionMaterialsWithPlaintextDataKey(mat)
    requires SE.ValidSuite(mat.algorithmSuite)
    requires Header.ValidEncryptionContext(mat.encryptionContext)
    requires forall k <- signedFields :: k in allData
    requires forall k <- encFields :: k in allData
    requires forall k <- encData :: encData[k].content.Terminal?
    requires forall k <- allData :: allData[k].content.Terminal?

    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var sign_only := Seq.Filter(n => n !in encFields, signedFields);
    reveal Seq.Filter();
    expect forall k <- sign_only :: k in signedFields;
    var sets : seq<OneSet> := FindSets(sign_only, allData);
    if |sets| == 0 {
      return Failure(E("Validation failed, and no sets were present."));
    }
    // FIXME -- maximum set size?
    var allMembers :- GetAllMembers(sets, allData);
    assert |allMembers| == |sets|;
    for i := 0 to |sets| {
      if maxSetSize < |allMembers[i]| {
        return Failure(E("maxSetSize was " + String.Base10Int2String(maxSetSize) + " but item holds a set of size " + String.Base10Int2String(|allMembers[i]|) + "."));
      }
    }

    var allPerms := GetAllPermutations(allMembers);
    assert |allPerms| == |sets|;
    var allSizes := GetAllSizes(allPerms);
    assert |allSizes| == |sets|;
    var counter := new CounterClass.Counter(allSizes);
    ghost var origCounter := counter;
    assert |counter.sizes| == |sets|;
    var newMap : SE.StructuredDataCanon := allData;
    var n : nat := |sets|;
    while 0 < counter.remaining && 0 < n
      decreases counter.remaining
      invariant counter.Valid()
      invariant forall k <- signedFields :: k in newMap
      invariant forall k <- encFields :: k in newMap
      invariant counter == origCounter
      invariant fresh(counter)
      invariant fresh(counter.curr)
      invariant counter.sizes == origCounter.sizes
      invariant |counter.sizes| == |sets|
      invariant n <= |sets|
    {
      ghost var oldRemaining := counter.remaining;
      assert |counter.sizes| == |sets|;
      for i := 0 to n
        invariant forall k <- signedFields :: k in newMap
        invariant forall k <- encFields :: k in newMap
        invariant counter.Valid()
        invariant counter == origCounter
        invariant fresh(counter)
        invariant fresh(counter.curr)
        invariant |counter.sizes| == |sets|
        invariant 0 < counter.remaining
        invariant 0 < n
        invariant oldRemaining == counter.remaining
      {
        var data : SE.Bytes := allData[sets[i].name].content.Terminal.value;
        var typeId := allData[sets[i].name].content.Terminal.typeId;
        expect counter.at(i) < |allPerms[i]|;
        expect forall s : SetMember <- allPerms[i][counter.at(i)] :: s.start <= s.end;
        var newSet := sets[i].MakeSet(data, allPerms[i][counter.at(i)]);
        expect sets[i].start <= |data|;
        expect sets[i].end <= |data|;
        var newData := data[..sets[i].start] + newSet + data[sets[i].end..];
        newMap := newMap[sets[i].name := SE.ValueToData(value := newData, typeId := typeId)];
      }
      var result := footer.validate(client, mat, edks, signedFields, encFields, encData, newMap, header);
      if result.Success? {
        return Success(newMap);
      }
      n := counter.next();
    }
    return Failure(E("Validation failed after permuting " + String.Base10Int2String(|sets|) + " sets."));
  }

  method GetAllMembers(sets : seq<OneSet>, allData : SE.StructuredDataCanon)
    returns (output : Result<seq<seq<SetMember>>, Error>)
    requires forall s <- sets :: s.name in allData
    ensures output.Success? ==> |output.value| == |sets|
    ensures output.Success? ==> forall s <- output.value :: 0 < |s|
  {
    var result : seq<seq<SetMember>> := [];
    for i := 0 to |sets|
      invariant forall s <- result :: 0 < |s|
      invariant |result| == i
    {
      var membersR := sets[i].GetMembers(allData);
      var members :- membersR.MapFailure(e => E(e));
      expect 0 < |members|;
      result := result + [members];
    }
    return Success(result);
  }

  method GetAllPermutations(sets : seq<seq<SetMember>>)
    returns (output : seq<seq<seq<SetMember>>>)
    requires forall s <- sets :: 0 < |s|
    ensures |output| == |sets|
    ensures forall i | 0 <= i < |sets| :: |output[i]| == Permutations.factorial(|sets[i]|)
    ensures forall i | 0 <= i < |sets| :: 0 < |output[i]|
  {
    var result : seq<seq<seq<SetMember>>> := [];
    for i := 0 to |sets|
      invariant |result| == i
      invariant forall j | 0 <= j < i :: |result[j]| == Permutations.factorial(|sets[j]|)
      invariant forall j | 0 <= j < i :: 0 < |result[j]|
    {
      var perms : seq<seq<SetMember>> := Permutations.GeneratePermutations(sets[i]);
      assert 0 < |sets[i]|;
      assert |perms| == Permutations.factorial(|sets[i]|);
      assert 0 < |perms|;
      result := result + [perms];
    }
    return result;
  }

  method GetAllSizes(sets : seq<seq<seq<SetMember>>>)
    returns (output : seq<nat>)
    ensures |output| == |sets|
    ensures forall i | 0 <= i < |sets| :: output[i] == |sets[i]|
  {
    var result : seq<nat> := [];
    for i := 0 to |sets|
      invariant |result| == i
      invariant forall j | 0 <= j < i :: result[j] == |sets[j]|
    {
      result := result + [|sets[i]|];
    }
    return result;
  }


  datatype SetMember = SetMember (
    start : nat,
    end : nat
  )


  datatype OneSet = OneSet (
    name : SE.CanonicalPath,
    start : nat,
    end : nat
  )
  {
    method GetMembers(allData : SE.StructuredDataCanon) returns (output : Result<seq<SetMember>, string>)
      requires name in allData
      ensures output.Success? ==>
                && (forall s <- output.value :: s.start <= s.end)
    {
      var data : SE.Bytes := allData[name].content.Terminal.value;
      var offset : nat := start;
      expect offset + 4 < |data|;
      var count :- BigEndianToU32(data[offset..]);
      offset := offset + 4;
      var result : seq<SetMember> := [];
      for i := 0 to count
        invariant forall s <- result :: s.start <= s.end
      {
        if offset > |data| {
          return Failure("Unexpected end of Set");
        }
        var length :- BigEndianToU32(data[offset..]);
        length := length + LENGTH_LEN;
        result := result + [SetMember(offset, offset+length)];
        offset := offset + length;
      }
      return Success(result);
    }
    method MakeSet(data : SE.Bytes, perm : seq<SetMember>) returns (output : SE.Bytes)
      requires forall s <- perm :: s.start <= s.end
    {
      expect start+4 <= |data|;
      output := data[start..start+4];
      for i := 0  to |perm| {
        expect perm[i].start <= |data|;
        expect perm[i].end <= |data|;
        output := output + data[perm[i].start..perm[i].end];
      }
      return output;
    }
  }

  predicate IsSetType(t : SET.TerminalTypeId)
  {
    || t == STRING_SET
    || t == NUMBER_SET
    || t == BINARY_SET
  }

  method FindSets3(fieldName : SE.CanonicalPath, attrType : SET.TerminalTypeId, attrLen : nat, value : SE.Bytes, offset : nat) returns (output : seq<OneSet>)
    ensures forall s <- output :: s.name == fieldName
    decreases |value| - offset
  {
    expect offset <= |value|;
    if IsSetType(attrType) {
      return [OneSet(fieldName, offset, offset+attrLen)];
    } else if attrType == LIST {
      if |value| < offset + 6 {
        return [];
      }
      output := [];
      var off := offset;
      var count :- expect BigEndianToU32(value[off..]);
      off := off + LENGTH_LEN;
      for i := 0 to count
        invariant off > offset
        invariant forall s <- output :: s.name == fieldName
      {
        if |value| < off + 6 {
          return [];
        }
        var innerType := value[off..off+2];
        var innerLen :- expect BigEndianToU32(value[off+TYPEID_LEN..]);
        var newSets := FindSets3(fieldName, innerType, innerLen, value, off+PREFIX_LEN);
        output := output + newSets;
        off := off + innerLen + PREFIX_LEN;
      }
    } else if attrType == MAP {
      if |value| < offset + 6 {
        return [];
      }
      output := [];
      var off := offset;
      var count :- expect BigEndianToU32(value[off..]);
      off := off + LENGTH_LEN;
      for i := 0 to count
        invariant off > offset
        invariant forall s <- output :: s.name == fieldName
      {
        if |value| < off + 6 {return [];}
        var keyType := value[off..off+2];
        var keyLen :- expect BigEndianToU32(value[off+TYPEID_LEN..]);
        off := off + PREFIX_LEN + keyLen;

        if |value| < off + 6 {return [];}
        var innerType := value[off..off+2];
        var innerLen :- expect BigEndianToU32(value[off+TYPEID_LEN..]);
        var newSets := FindSets3(fieldName, innerType, innerLen, value, off+PREFIX_LEN);
        output := output + newSets;
        off := off + innerLen + PREFIX_LEN;
      }
    } else {
      return [];
    }
  }

  function BigEndianToU32(x : seq<uint8>) : (ret : Result<nat, string>)
  {
    if |x| < LENGTH_LEN then
      Failure("Length of 4-byte integer was less than 4")
    else
      Success(SeqToUInt32(x[..LENGTH_LEN]) as nat)
  }

  method FindSets2(fieldName : SE.CanonicalPath, fieldData : SE.StructuredDataTerminalType) returns (output : seq<OneSet>)
    ensures forall s <- output :: s.name == fieldName
  {
    if IsSetType(fieldData.content.Terminal.typeId) {
      return [OneSet(fieldName, 0, |fieldData.content.Terminal.value|)];
    } else if fieldData.content.Terminal.typeId == MAP {
      output := FindSets3(fieldName, MAP, |fieldData.content.Terminal.value|, fieldData.content.Terminal.value, 0);
    } else if fieldData.content.Terminal.typeId == LIST {
      output := FindSets3(fieldName, LIST, |fieldData.content.Terminal.value|, fieldData.content.Terminal.value, 0);
    } else {
      return [];
    }
  }

  method FindSets(fieldNames : seq<SE.CanonicalPath>, fieldData : SE.StructuredDataCanon) returns (output : seq<OneSet>)
    requires forall k <- fieldNames :: k in fieldData
    ensures forall s <- output :: s.name in fieldData
  {
    output := [];
    for i := 0 to |fieldNames|
      invariant forall s <- output :: s.name in fieldData
    {
      var newSets := FindSets2(fieldNames[i], fieldData[fieldNames[i]]);
      assert forall s <- newSets :: s.name == fieldNames[i];
      output := output + newSets;
    }
  }
}