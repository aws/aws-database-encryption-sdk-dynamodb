// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "Util.dfy"
include "Header.dfy"
include "SortCanon.dfy"

module Canonize {
  import opened StructuredEncryptionUtil
  import opened Types = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import Header = StructuredEncryptionHeader
  import Paths = StructuredEncryptionPaths
  import SortCanon
  import Relations

  predicate method {:opaque} IsValidPath(path : Path)
  {
    Paths.ValidPath(path)
  }

  datatype EncryptionSelector = DoEncrypt | DoDecrypt

  // Updated return true if the given item has been updated properly for the given operation.
  // Updated2..Update5 do exactly the same thing, but with different data types.
  predicate Updated(oldVal : CanonCryptoItem, newVal : CanonCryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.key
    && oldVal.origKey == newVal.origKey
    && oldVal.action == newVal.action
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  predicate Updated2(oldVal : AuthItem, newVal : CanonCryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.origKey
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  predicate Updated3(oldVal : AuthItem, newVal : CryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.key
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  predicate Updated4(oldVal : CryptoItem, newVal : CryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.key
    && oldVal.action == newVal.action
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  predicate Updated5(oldVal : CryptoItem, newVal : CanonCryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.origKey
    && oldVal.action == newVal.action
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  predicate method {:opaque} IsCanonPath(table : GoodString, origKey : Path, key : CanonicalPath)
    requires IsValidPath(origKey)
  {
    reveal IsValidPath();
    key == Paths.CanonPath(table, origKey)
  }

  function method {:opaque} MakeCanon(tableName : GoodString, data : CryptoItem) : (result : CanonCryptoItem)
    requires Paths.ValidPath(data.key)
    requires IsValidPath(data.key)
    ensures result.origKey == data.key
    ensures result.data == data.data
    ensures result.action == data.action
    ensures IsValidPath(result.origKey)
    ensures result.key == Paths.CanonPath(tableName, data.key)
    ensures IsCanonPath(tableName, data.key, result.key)
    ensures IsCanonPath(tableName, result.origKey, result.key)
  {
    reveal IsValidPath();
    reveal IsCanonPath();
    CanonCryptoItem(Paths.CanonPath(tableName, data.key), data.key, data.data, data.action)
  }

  function method {:opaque} MakeCanonAuth(tableName : GoodString, data : AuthItem) : (result : CanonAuthItem)
    requires Paths.ValidPath(data.key)
    requires IsValidPath(data.key)
    ensures result.origKey == data.key
    ensures result.data == data.data
    ensures result.action == data.action
    ensures IsValidPath(result.origKey)
    ensures result.key == Paths.CanonPath(tableName, data.key)
    ensures IsCanonPath(tableName, data.key, result.key)
    ensures IsCanonPath(tableName, result.origKey, result.key)
  {
    reveal IsValidPath();
    reveal IsCanonPath();
    CanonAuthItem(Paths.CanonPath(tableName, data.key), data.key, data.data, data.action)
  }

  predicate method Same(x : CanonAuthItem, y : CanonCryptoItem)
  {
    && x.key == y.key
    && x.origKey == y.origKey
    && x.data == y.data
  }

  function method MakeCryptoItem(x : CanonAuthItem, action : CryptoAction) : (ret : CanonCryptoItem)
    ensures Same(x, ret)
  {
    CanonCryptoItem(x.key, x.origKey, x.data, action)
  }

  function method {:opaque} LegendToAction(v : Header.LegendByte) : CryptoAction
  {
    if v == Header.ENCRYPT_AND_SIGN_LEGEND then
      ENCRYPT_AND_SIGN
    else if v == Header.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT_LEGEND then
      SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
    else
      SIGN_ONLY
  }

  function method {:tailrecursion} {:opaque} ResolveLegend(
    fields : CanonAuthList,
    legend : Header.Legend,
    ghost origFields : CanonAuthList,
    acc : CanonCryptoList
  )
    : (ret : Result<CanonCryptoList, Error>)
    requires |fields| + |acc| == |origFields|
    requires forall i | 0 <= i < |acc| :: Same(origFields[i], acc[i])
    requires forall i | |acc| <= i < |origFields| :: origFields[i] == fields[i-|acc|]
    ensures ret.Success? ==>
              && |origFields| == |ret.value|
              && forall i | 0 <= i < |origFields| :: Same(origFields[i], ret.value[i])
  {
    if |fields| == 0 then
      :- Need(|legend| == 0, E("Schema changed : something that was signed is now unsigned."));
      Success(acc)
    else if fields[0].action == DO_NOT_SIGN then
      ResolveLegend(fields[1..], legend, origFields, acc + [MakeCryptoItem(fields[0], DO_NOTHING)])
    else
      :- Need(0 < |legend|, E("Schema changed : something that was unsigned is now signed."));
      ResolveLegend(fields[1..], legend[1..], origFields, acc + [MakeCryptoItem(fields[0], LegendToAction(legend[0]))])
  }

  function method {:opaque} ForEncrypt(tableName : GoodString, data : CryptoList)
    : (ret : Result<CanonCryptoList, Error>)
    requires CryptoListHasNoDuplicates(data)
    ensures ret.Success? ==>
              && CanonCryptoMatchesCryptoList(tableName, data, ret.value)
              && IsCryptoSorted(ret.value)
  {
    :- Need(forall k <- data :: IsValidPath(k.key), E("Invalid Paths"));
    var canonList := CryptoToCanonCrypto(tableName, data);
    Success(CryptoSort(canonList, tableName, data))
  }

  predicate {:opaque} AuthExistsInCanonAuth(k : AuthItem, list : CanonAuthList)
  {
    exists x :: x in list && k.key == x.origKey && k.data == x.data
  }

  predicate {:opaque} AuthExistsInCrypto(k : AuthItem, list : CryptoList)
  {
    exists x :: x in list && k.key == x.key // && k.data == x.data
  }

  predicate {:opaque} CryptoExistsInAuth(k : CryptoItem, list : AuthList)
  {
    exists x :: x in list && k.key == x.key // && k.data == x.data
  }

  predicate {:opaque} AuthExistsInCanonCrypto(k : AuthItem, list : CanonCryptoList)
  {
    exists x :: x in list && k.key == x.origKey && k.data == x.data
  }

  predicate {:opaque} CryptoExistsInCanonCrypto(k : CryptoItem, list : CanonCryptoList)
  {
    exists x :: x in list && k.key == x.origKey && k.data == x.data
  }

  predicate {:opaque} CanonAuthExistsInAuth(k : CanonAuthItem, list : AuthList)
  {
    exists x :: x in list && k.origKey == x.key && k.data == x.data
  }

  predicate {:opaque} CanonCryptoExistsInAuth(k : CanonCryptoItem, list : AuthList)
  {
    exists x :: x in list && k.origKey == x.key && k.data == x.data
  }

  predicate {:opaque} CanonCryptoExistsInCrypto(k : CanonCryptoItem, list : CryptoList)
  {
    exists x :: x in list && k.origKey == x.key && k.data == x.data
  }

  predicate {:opaque} CanonAuthExistsInCanonAuth(k : CanonAuthItem, list : CanonAuthList)
  {
    exists x :: x in list && k.origKey == x.origKey && k.data == x.data
  }

  predicate {:opaque} CanonAuthExistsInCanonCrypto(k : CanonAuthItem, list : CanonCryptoList)
  {
    exists x :: x in list && k.origKey == x.origKey && k.data == x.data
  }

  predicate {:opaque} CanonCryptoExistsInCanonAuth(k : CanonCryptoItem, list : CanonAuthList)
  {
    exists x :: x in list && k.origKey == x.origKey && k.data == x.data
  }

  predicate {:opaque} CanonCryptoExistsInCanonCrypto(k : CanonCryptoItem, list : CanonCryptoList)
  {
    exists x :: x in list && k.origKey == x.origKey && k.data == x.data
  }

  predicate {:opaque} CanonAuthMatchesAuthList(tableName : GoodString, data : AuthList, canonList : CanonAuthList)
  {
    && (forall k <- data :: AuthExistsInCanonAuth(k, canonList))
    && (forall k <- canonList :: CanonAuthExistsInAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonAuthListHasNoDuplicates(canonList)
  }

  predicate {:opaque} CanonCryptoMatchesAuthList(tableName : GoodString, data : AuthList, canonList : CanonCryptoList)
  {
    && (forall k <- data :: AuthExistsInCanonCrypto(k, canonList))
    && (forall k <- canonList :: CanonCryptoExistsInAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonCryptoListHasNoDuplicates(canonList)
  }

  predicate {:opaque} CanonCryptoUpdatedAuth(k : CanonCryptoItem, list : AuthList)
  {
    exists x :: x in list && Updated2(x, k, DoDecrypt)
  }

  predicate {:opaque} AuthUpdatedCanonCrypto(k : AuthItem, list : CanonCryptoList)
  {
    exists x :: x in list && Updated2(k, x, DoDecrypt)
  }

  predicate {:opaque} CryptoUpdatedAuth(k : CryptoItem, list : AuthList)
  {
    exists x :: x in list && Updated3(x, k, DoDecrypt)
  }

  predicate {:opaque} AuthUpdatedCrypto(k : AuthItem, list : CryptoList)
  {
    exists x :: x in list && Updated3(k, x, DoDecrypt)
  }

  predicate {:opaque} CanonCryptoUpdatedCrypto(k : CanonCryptoItem, list : CryptoList)
  {
    exists x :: x in list && Updated5(x, k, DoDecrypt)
  }

  predicate {:opaque} CryptoUpdatedCanonCrypto(k : CryptoItem, list : CanonCryptoList)
  {
    exists x :: x in list && Updated5(k, x, DoDecrypt)
  }

  predicate {:opaque} NewCryptoUpdatedCrypto(k : CryptoItem, list : CryptoList)
  {
    exists x :: x in list && Updated4(x, k, DoDecrypt)
  }

  predicate {:opaque} CryptoUpdatedNewCrypto(k : CryptoItem, list : CryptoList)
  {
    exists x :: x in list && Updated4(k, x, DoDecrypt)
  }

  predicate {:opaque} CanonCryptoUpdatedAuthList(tableName : GoodString, data : AuthList, canonList : CanonCryptoList)
  {
    && (forall k <- data :: AuthUpdatedCanonCrypto(k, canonList))
    && (forall k <- canonList :: CanonCryptoUpdatedAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonCryptoListHasNoDuplicates(canonList)
  }

  predicate {:opaque} CryptoUpdatedAuthList(data : AuthList, canonList : CryptoList)
  {
    && (forall k <- data :: AuthUpdatedCrypto(k, canonList))
    && (forall k <- canonList :: CryptoUpdatedAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(canonList)
  }

  predicate {:opaque} CryptoMatchesAuthList(tableName : GoodString, data : AuthList, canonList : CryptoList)
  {
    && (forall k <- data :: AuthExistsInCrypto(k, canonList))
    && (forall k <- canonList :: CryptoExistsInAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(canonList)
  }

  predicate {:opaque} CanonCryptoMatchesCryptoList(tableName : GoodString, data : CryptoList, canonList : CanonCryptoList)
  {
    && (forall k <- data :: CryptoExistsInCanonCrypto(k, canonList))
    && (forall k <- canonList :: CanonCryptoExistsInCrypto(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonCryptoListHasNoDuplicates(canonList)
  }

  predicate {:opaque} CanonCryptoUpdatedCryptoList(tableName : GoodString, data : CryptoList, canonList : CanonCryptoList)
  {
    && (forall k <- data :: CryptoUpdatedCanonCrypto(k, canonList))
    && (forall k <- canonList :: CanonCryptoUpdatedCrypto(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonCryptoListHasNoDuplicates(canonList)
  }

  predicate {:opaque} CryptoUpdatedCryptoList(data : CryptoList, canonList : CryptoList)
  {
    && (forall k <- data :: CryptoUpdatedNewCrypto(k, canonList))
    && (forall k <- canonList :: NewCryptoUpdatedCrypto(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(canonList)
  }

  function method {:opaque} AuthToCanonAuth(tableName : GoodString, data : AuthList) : (ret : CanonAuthList)
    requires forall k <- data :: IsValidPath(k.key)
    requires AuthListHasNoDuplicates(data)
    ensures CanonAuthMatchesAuthList(tableName, data, ret)
  {
    reveal CanonAuthMatchesAuthList();
    reveal Seq.Map();
    reveal IsValidPath();
    var canonList : CanonAuthList := Seq.Map((s : AuthItem) requires IsValidPath(s.key) => MakeCanonAuth(tableName, s), data);

    assert |data| == |canonList|;
    assert forall i | 0 <= i < |data| :: canonList[i] == MakeCanonAuth(tableName, data[i]);
    assert (forall k <- data :: AuthExistsInCanonAuth(k, canonList)) by {
      reveal AuthExistsInCanonAuth();
    }
    assert (forall k <- canonList :: CanonAuthExistsInAuth(k, data)) by {
      reveal CanonAuthExistsInAuth();
    }
    assert (forall k <- canonList :: IsValidPath(k.origKey));
    assert (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key));
    assert CanonAuthListHasNoDuplicates(canonList) by {
      assert forall i | 0 <= i < |canonList| :: data[i].key == canonList[i].origKey;
    }
    assert CanonAuthMatchesAuthList(tableName, data, canonList);
    canonList
  }

  function method {:opaque} CryptoToCanonCrypto(tableName : GoodString, data : CryptoList) : (ret : CanonCryptoList)
    requires forall k <- data :: IsValidPath(k.key)
    requires CryptoListHasNoDuplicates(data)
    ensures CanonCryptoMatchesCryptoList(tableName, data, ret)
  {
    reveal CanonCryptoMatchesCryptoList();
    reveal Seq.Map();
    reveal IsValidPath();
    var canonList : CanonCryptoList := Seq.Map((s : CryptoItem) requires IsValidPath(s.key) => MakeCanon(tableName, s), data);

    assert |data| == |canonList|;
    assert forall i | 0 <= i < |data| :: canonList[i] == MakeCanon(tableName, data[i]);
    assert (forall k <- data :: CryptoExistsInCanonCrypto(k, canonList)) by {
      reveal CryptoExistsInCanonCrypto();
    }
    assert (forall k <- canonList :: CanonCryptoExistsInCrypto(k, data)) by {
      reveal CanonCryptoExistsInCrypto();
    }
    assert (forall k <- canonList :: IsValidPath(k.origKey));
    assert (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key));
    assert CanonCryptoListHasNoDuplicates(canonList) by {
      assert forall i | 0 <= i < |canonList| :: data[i].key == canonList[i].origKey;
    }
    assert CanonCryptoMatchesCryptoList(tableName, data, canonList);
    canonList
  }

  lemma SameMultisetSameStuff<T>(x : seq<T>, y : seq<T>)
    requires multiset(x) == multiset(y)
    ensures forall k <- x :: k in y
    ensures forall k <- y :: k in x
  {
    assert forall k <- x :: k in multiset(x);
    assert forall k <- y :: k in multiset(y);
    assert multiset(y) == multiset(x);
  }

  function method {:opaque} AuthSort(canonList : CanonAuthList, ghost tableName : GoodString, ghost data : AuthList) : (ret : CanonAuthList)
    requires forall k <- data :: IsValidPath(k.key)
    requires CanonAuthMatchesAuthList(tableName, data, canonList)
    ensures CanonAuthMatchesAuthList(tableName, data, ret)
    ensures Relations.SortedBy(ret, SortCanon.AuthBelow)
  {
    reveal CanonAuthMatchesAuthList();
    reveal IsCryptoSorted();
    var canonSorted := SortCanon.AuthSort(canonList);

    assert |data| == |canonSorted|;

    assert forall k <- canonList :: k in canonSorted by {
      SameMultisetSameStuff(canonList, canonSorted);
    }

    assert forall k <- canonSorted :: k in canonList by {
      SameMultisetSameStuff(canonList, canonSorted);
    }

    assert (forall k <- canonList :: CanonAuthExistsInCanonAuth(k, canonSorted)) by {
      reveal CanonAuthExistsInCanonAuth();
    }
    assert (forall k <- canonSorted :: CanonAuthExistsInCanonAuth(k, canonList)) by {
      reveal CanonAuthExistsInCanonAuth();
    }

    assert (forall k <- data :: AuthExistsInCanonAuth(k, canonSorted)) by {
      reveal AuthExistsInCanonAuth();
    }
    assert (forall k <- canonSorted :: CanonAuthExistsInAuth(k, data));
    assert |data| == |canonSorted|;
    assert (forall k <- canonSorted :: IsValidPath(k.origKey));
    assert (forall k <- canonSorted :: IsCanonPath(tableName, k.origKey, k.key));
    assert CanonAuthListHasNoDuplicates(canonSorted);
    assume {:axiom} CanonAuthMatchesAuthList(tableName, data, canonSorted);

    canonSorted
  }

  function method {:opaque} CryptoSort(canonList : CanonCryptoList, ghost tableName : GoodString, ghost data : CryptoList) : (ret : CanonCryptoList)
    requires forall k <- data :: IsValidPath(k.key)
    requires CanonCryptoMatchesCryptoList(tableName, data, canonList)
    ensures CanonCryptoMatchesCryptoList(tableName, data, ret)
    ensures IsCryptoSorted(ret)
  {
    reveal CanonCryptoMatchesCryptoList();
    reveal IsCryptoSorted();
    var canonSorted := SortCanon.CryptoSort(canonList);

    assert |data| == |canonSorted|;

    assert forall k <- canonList :: k in canonSorted by {
      SameMultisetSameStuff(canonList, canonSorted);
    }

    assert forall k <- canonSorted :: k in canonList by {
      SameMultisetSameStuff(canonList, canonSorted);
    }

    assert (forall k <- canonList :: CanonCryptoExistsInCanonCrypto(k, canonSorted)) by {
      reveal CanonCryptoExistsInCanonCrypto();
    }
    assert (forall k <- canonSorted :: CanonCryptoExistsInCanonCrypto(k, canonList)) by {
      reveal CanonCryptoExistsInCanonCrypto();
    }

    assert (forall k <- data :: CryptoExistsInCanonCrypto(k, canonSorted)) by {
      reveal CryptoExistsInCanonCrypto();
    }
    assert (forall k <- canonSorted :: CanonCryptoExistsInCrypto(k, data));
    assert |data| == |canonSorted|;
    assert (forall k <- canonSorted :: IsValidPath(k.origKey));
    assert (forall k <- canonSorted :: IsCanonPath(tableName, k.origKey, k.key));
    assert CanonCryptoListHasNoDuplicates(canonSorted);
    assume {:axiom} CanonCryptoMatchesCryptoList(tableName, data, canonSorted);

    canonSorted
  }

  lemma IsValidPathTransfers(canonSorted : CanonAuthList, canonResolved : CanonCryptoList)
    requires forall k <- canonSorted :: IsValidPath(k.origKey)
    requires |canonSorted| == |canonResolved|
    requires forall i | 0 <= i < |canonSorted| :: Same(canonSorted[i], canonResolved[i])
    ensures forall k <- canonResolved :: IsValidPath(k.origKey)
  {}

  lemma IsCanonPathTransfers(canonSorted : CanonAuthList, canonResolved : CanonCryptoList, tableName : GoodString)
    requires forall k <- canonSorted :: IsValidPath(k.origKey)
    requires forall k <- canonSorted :: IsCanonPath(tableName, k.origKey, k.key)
    requires |canonSorted| == |canonResolved|
    requires forall i | 0 <= i < |canonSorted| :: Same(canonSorted[i], canonResolved[i])
    ensures forall k <- canonResolved :: IsValidPath(k.origKey)
    ensures forall k <- canonResolved :: IsCanonPath(tableName, k.origKey, k.key)
  {}

  lemma NoDupsTransfers(canonSorted : CanonAuthList, canonResolved : CanonCryptoList)
    requires CanonAuthListHasNoDuplicates(canonSorted)
    requires |canonSorted| == |canonResolved|
    requires forall i | 0 <= i < |canonSorted| :: Same(canonSorted[i], canonResolved[i])
    ensures CanonCryptoListHasNoDuplicates(canonResolved)
  {}


  function method {:opaque}
  DoResolveLegend(canonSorted : CanonAuthList, legend: Header.Legend, ghost tableName : GoodString, ghost data : AuthList) : (ret : Result<CanonCryptoList, Error>)
    requires CanonAuthMatchesAuthList(tableName, data, canonSorted)
    requires Relations.SortedBy(canonSorted, SortCanon.AuthBelow)
    ensures ret.Success? ==>
              && CanonCryptoMatchesAuthList(tableName, data, ret.value)
              && IsCryptoSorted(ret.value)
  {
    reveal CanonAuthMatchesAuthList();
    reveal CanonCryptoMatchesAuthList();
    reveal IsCryptoSorted();
    var canonResolved :- ResolveLegend(canonSorted, legend, canonSorted, []);

    assert (forall k <- data :: AuthExistsInCanonCrypto(k, canonResolved)) by {
      reveal AuthExistsInCanonCrypto();
      reveal AuthExistsInCanonAuth();
    }
    assert (forall k <- canonResolved :: CanonCryptoExistsInAuth(k, data)) by {
      reveal CanonCryptoExistsInAuth();
      reveal CanonAuthExistsInAuth();
      reveal AuthExistsInCanonAuth();
      assert forall k <- canonSorted :: CanonAuthExistsInAuth(k, data);
    }
    assert |data| == |canonResolved|;
    assert (forall k <- canonResolved :: IsValidPath(k.origKey)) by {
      IsValidPathTransfers(canonSorted, canonResolved);
    }
    assert (forall k <- canonResolved :: IsCanonPath(tableName, k.origKey, k.key)) by {
      IsCanonPathTransfers(canonSorted, canonResolved, tableName);
    }
    assert CanonCryptoListHasNoDuplicates(canonResolved) by {
      NoDupsTransfers(canonSorted, canonResolved);
    }

    assert Relations.SortedBy(canonResolved, SortCanon.CryptoBelow) by {
      assert Relations.SortedBy(canonSorted, SortCanon.AuthBelow);
      SortCanon.AuthSortIsCryptoSort(canonSorted, canonResolved);
    }

    assert CanonCryptoMatchesAuthList(tableName, data, canonResolved);
    Success(canonResolved)
  }

  predicate {:opaque} IsCryptoSorted(list : CanonCryptoList)
  {
    Relations.SortedBy(list, SortCanon.CryptoBelow)
  }

  function method {:opaque} ForDecrypt(tableName : GoodString, data : AuthList, legend: Header.Legend)
    : (ret : Result<CanonCryptoList, Error>)
    requires AuthListHasNoDuplicates(data)
    ensures ret.Success? ==>
              && CanonCryptoMatchesAuthList(tableName, data, ret.value)
              && IsCryptoSorted(ret.value)
  {
    :- Need(forall k <- data :: IsValidPath(k.key), E("Invalid Paths"));
    var canonList := AuthToCanonAuth(tableName, data);
    var canonSorted := AuthSort(canonList, tableName, data);
    DoResolveLegend(canonSorted, legend, tableName, data)
  }

  predicate method SameUnCanon(x : CanonCryptoItem, y : CryptoItem)
  {
    && x.origKey == y.key
    && x.data == y.data
    && x.action == y.action
  }

  function method UnCanon(input : CanonCryptoList) : (ret : CryptoList)
    ensures
      && |ret| == |input|
      && (forall i | 0 <= i < |input| :: SameUnCanon(input[i], ret[i]))
  {
    if |input| == 0 then
      []
    else
      var newItem := CryptoItem(key := input[0].origKey, data := input[0].data, action := input[0].action);
      assert SameUnCanon(input[0], newItem);
      [newItem] + UnCanon(input[1..])
  }

  function method UnCanonDecrypt(input : CanonCryptoList, ghost tableName : GoodString, ghost origData : AuthList)
    : (ret : CryptoList)
    requires CanonCryptoUpdatedAuthList(tableName, origData, input)
    ensures CryptoUpdatedAuthList(origData, ret)
  {
    reveal CanonCryptoUpdatedAuthList();
    reveal CryptoUpdatedAuthList();
    var results := UnCanon(input);
    assume {:axiom} CryptoUpdatedAuthList(origData, results);
    results
  }

  function method UnCanonEncrypt(input : CanonCryptoList, ghost tableName : GoodString, ghost origData : CryptoList)
    : (ret : CryptoList)
    requires CanonCryptoUpdatedCryptoList(tableName, origData, input)
    ensures CryptoUpdatedCryptoList(origData, ret)
  {
    reveal CanonCryptoUpdatedCryptoList();
    reveal CryptoUpdatedCryptoList();
    var results := UnCanon(input);
    assume {:axiom} CryptoUpdatedCryptoList(origData, results);
    results
  }

  predicate {:opaque} EncryptPathFinal(origData : CryptoList, finalData : CryptoList)
  {
    && |finalData| == |origData| + 2
    && CryptoUpdatedCryptoList(origData, finalData[..(|finalData|-2)])
    && finalData[|finalData|-2].key == HeaderPath
    && finalData[|finalData|-1].key == FooterPath
  }

  function method AddHeaders(input : CryptoList, headerData : StructuredDataTerminal, footerData : StructuredDataTerminal, ghost origData : CryptoList)
    : (ret : CryptoList)
    requires CryptoUpdatedCryptoList(origData, input)
    // requires !exists x :: x in input && x.key == HeaderPath
    // requires !exists x :: x in input && x.key == FooterPath
    ensures EncryptPathFinal(origData, ret)
  {
    reveal EncryptPathFinal();
    reveal CryptoUpdatedCryptoList();
    var headItem := Types.CryptoItem(key := HeaderPath, data := headerData, action := DO_NOTHING);
    var footItem := Types.CryptoItem(key := FooterPath, data := footerData, action := DO_NOTHING);
    var largeResult := input + [headItem, footItem];
    largeResult
  }

  predicate {:opaque} DecryptPathFinal(origData : AuthList, finalData : CryptoList)
  {
    && |finalData| == |origData| - 2
    && (!exists x :: x in finalData && x.key == HeaderPath)
    && (!exists x :: x in finalData && x.key == FooterPath)
    && (forall k <- origData :: (k.key in [HeaderPath, FooterPath]) || AuthUpdatedCrypto(k, finalData))
    && (forall k <- finalData :: CryptoUpdatedAuth(k, origData))
    && (forall k <- finalData :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(finalData)
  }

  function method RemoveHeaderPaths(xs : CryptoList) : (ret : CryptoList)
    requires CryptoListHasNoDuplicates(xs)
    ensures !exists x :: x in ret && x.key in [HeaderPath, FooterPath]
    ensures !exists x :: x in ret && x.key == HeaderPath
    ensures !exists x :: x in ret && x.key == FooterPath
    ensures forall x <- ret :: x in xs
    ensures forall x <- xs :: x.key in [HeaderPath, FooterPath] || x in ret
    ensures CryptoListHasNoDuplicates(ret)
  {
    if |xs| == 0 then []
    else (if xs[0].key in [HeaderPath, FooterPath] then [] else [xs[0]]) + RemoveHeaderPaths(xs[1..])
  }

  function method RemoveHeaders(input : CryptoList, ghost origData : AuthList)
    : (ret : CryptoList)
    requires CryptoUpdatedAuthList(origData, input)
    // requires exists x :: x in input && x.key == HeaderPath
    // requires exists x :: x in input && x.key == FooterPath

    ensures DecryptPathFinal(origData, ret)
  {
    reveal CryptoUpdatedAuthList();
    reveal DecryptPathFinal();
    var finalData := RemoveHeaderPaths(input);
    assume {:axiom} |finalData| == |origData| - 2;
    assume {:axiom} forall k <- origData :: (k.key in [HeaderPath, FooterPath]) || AuthUpdatedCrypto(k, finalData);
    finalData
  }
}
