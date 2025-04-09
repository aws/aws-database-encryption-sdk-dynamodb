// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "Util.dfy"
include "Header.dfy"
include "SortCanon.dfy"

module {:options "/functionSyntax:4" } Canonize {
  import opened StructuredEncryptionUtil
  import opened Types = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import Header = StructuredEncryptionHeader
  import Paths = StructuredEncryptionPaths
  import SortCanon
  import Relations

  opaque ghost predicate IsValidPath(path : Path)
  {
    Paths.ValidPath(path)
  }

  datatype EncryptionSelector = DoEncrypt | DoDecrypt

  // Updated return true if the given item has been updated properly for the given operation.
  // Updated2..Update5 do exactly the same thing, but with different data types.
  ghost predicate Updated(oldVal : CanonCryptoItem, newVal : CanonCryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.key
    && oldVal.origKey == newVal.origKey
    && oldVal.action == newVal.action
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  ghost predicate Updated2(oldVal : AuthItem, newVal : CanonCryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.origKey
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  ghost predicate Updated3(oldVal : AuthItem, newVal : CryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.key
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  ghost predicate Updated4(oldVal : CryptoItem, newVal : CryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.key
    && oldVal.action == newVal.action
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  ghost predicate Updated5(oldVal : CryptoItem, newVal : CanonCryptoItem, mode : EncryptionSelector)
  {
    && oldVal.key == newVal.origKey
    && oldVal.action == newVal.action
    && (newVal.action != ENCRYPT_AND_SIGN <==> oldVal.data == newVal.data)
    && (newVal.action == ENCRYPT_AND_SIGN <==> oldVal.data != newVal.data)
    && (mode == DoEncrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> newVal.data.typeId == BYTES_TYPE_ID))
    && (mode == DoDecrypt ==> (newVal.action == ENCRYPT_AND_SIGN ==> |oldVal.data.value| >= 2 && newVal.data.typeId == oldVal.data.value[..2]))
  }

  opaque predicate IsCanonPath(table : GoodString, origKey : Path, key : CanonicalPath)
    requires IsValidPath(origKey)
  {
    reveal IsValidPath();
    key == Paths.CanonPath(table, origKey)
  }

  opaque function MakeCanon(tableName : GoodString, data : CryptoItem) : (result : CanonCryptoItem)
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

  opaque function MakeCanonAuth(tableName : GoodString, data : AuthItem) : (result : CanonAuthItem)
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

  predicate Same(x : CanonAuthItem, y : CanonCryptoItem)
  {
    && x.key == y.key
    && x.origKey == y.origKey
    && x.data == y.data
  }

  function MakeCryptoItem(x : CanonAuthItem, action : CryptoAction) : (ret : CanonCryptoItem)
    ensures Same(x, ret)
  {
    CanonCryptoItem(x.key, x.origKey, x.data, action)
  }

  function LegendToAction(v : Header.LegendByte) : CryptoAction
  {
    if v == Header.ENCRYPT_AND_SIGN_LEGEND then
      ENCRYPT_AND_SIGN
    else if v == Header.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT_LEGEND then
      SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
    else
      SIGN_ONLY
  }

  opaque function {:tailrecursion} ResolveLegend(
    fields : CanonAuthList,
    legend : Header.Legend,
    pos : nat := 0,
    legendPos : nat := 0,
    acc : CanonCryptoList := []
  )
    : (ret : Result<CanonCryptoList, Error>)
    requires 0 <= pos <= |fields|
    requires 0 <= legendPos <= |legend|
    requires pos == |acc|
    requires forall i | 0 <= i < pos :: Same(fields[i], acc[i])
    ensures ret.Success? ==>
              && |fields| == |ret.value|
              && forall i | 0 <= i < |fields| :: Same(fields[i], ret.value[i])
    decreases |fields| - pos
  {
    if |fields| == pos then
      :- Need(|legend| == legendPos, E("Schema changed : something that was signed is now unsigned."));
      Success(acc)
    else if fields[pos].action == DO_NOT_SIGN then
      ResolveLegend(fields, legend, pos+1, legendPos, acc + [MakeCryptoItem(fields[pos], DO_NOTHING)])
    else
      :- Need(legendPos < |legend|, E("Schema changed : something that was unsigned is now signed."));
      ResolveLegend(fields, legend, pos+1, legendPos+1, acc + [MakeCryptoItem(fields[pos], LegendToAction(legend[legendPos]))])
  }

  opaque function ForEncrypt(tableName : GoodString, data : CryptoList)
    : (ret : Result<CanonCryptoList, Error>)
    requires CryptoListHasNoDuplicates(data)
    requires !exists x | x in data :: x.key in HeaderPaths
    ensures ret.Success? ==>
              && CanonCryptoMatchesCryptoList(tableName, data, ret.value)
              && IsCryptoSorted(ret.value)
  {
    reveal IsValidPath();
    :- Need(forall k <- data :: Paths.ValidPath(k.key), E("Invalid Paths"));
    var canonList := CryptoToCanonCrypto(tableName, data);
    Success(CryptoSort(canonList, tableName, data))
  }

  opaque ghost predicate AuthExistsInCanonAuth(k : AuthItem, list : CanonAuthList)
  {
    exists x :: x in list && k.key == x.origKey && k.data == x.data && k.action == x.action
  }

  opaque ghost predicate AuthExistsInCrypto(k : AuthItem, list : CryptoList)
  {
    exists x :: x in list && k.key == x.key // && k.data == x.data
  }

  opaque ghost predicate CryptoExistsInAuth(k : CryptoItem, list : AuthList)
  {
    exists x :: x in list && k.key == x.key // && k.data == x.data
  }

  opaque ghost predicate AuthExistsInCanonCrypto(k : AuthItem, list : CanonCryptoList)
  {
    exists x :: x in list && k.key == x.origKey && k.data == x.data
  }

  ghost predicate SameStuff1(k : CryptoItem, x : CanonCryptoItem)
  {
    k.key == x.origKey && k.data == x.data && k.action == x.action
  }

  opaque ghost predicate CryptoExistsInCanonCrypto(k : CryptoItem, list : CanonCryptoList)
  {
    exists x :: x in list && SameStuff1(k, x)
  }

  opaque ghost predicate CanonAuthExistsInAuth(k : CanonAuthItem, list : AuthList)
  {
    exists x :: x in list && k.origKey == x.key && k.data == x.data && k.action == x.action
  }

  opaque ghost predicate CanonCryptoExistsInAuth(k : CanonCryptoItem, list : AuthList)
  {
    exists x :: x in list && k.origKey == x.key && k.data == x.data
  }

  opaque ghost predicate CanonCryptoExistsInCrypto(k : CanonCryptoItem, list : CryptoList)
  {
    exists x :: x in list && k.origKey == x.key && k.data == x.data && k.action == x.action
  }

  opaque ghost predicate CanonAuthExistsInCanonAuth(k : CanonAuthItem, list : CanonAuthList)
  {
    exists x :: x in list && k.origKey == x.origKey && k.data == x.data && k.action == x.action
  }

  opaque ghost predicate CanonAuthExistsInCanonCrypto(k : CanonAuthItem, list : CanonCryptoList)
  {
    exists x :: x in list && k.origKey == x.origKey && k.data == x.data
  }

  opaque ghost predicate CanonCryptoExistsInCanonAuth(k : CanonCryptoItem, list : CanonAuthList)
  {
    exists x :: x in list && k.origKey == x.origKey && k.data == x.data
  }

  opaque ghost predicate CanonCryptoExistsInCanonCrypto(k : CanonCryptoItem, list : CanonCryptoList)
  {
    exists x :: x in list && k.origKey == x.origKey && k.data == x.data && k.action == x.action
  }

  opaque ghost predicate CanonAuthMatchesAuthList(tableName : GoodString, data : AuthList, canonList : CanonAuthList)
  {
    && (exists x :: x in data && x.key == HeaderPath)
    && (exists x :: x in data && x.key == FooterPath)
    && (forall k <- data :: AuthExistsInCanonAuth(k, canonList))
    && (forall k <- canonList :: CanonAuthExistsInAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonAuthListHasNoDuplicates(canonList)
  }

  opaque ghost predicate CanonCryptoMatchesAuthList(tableName : GoodString, data : AuthList, canonList : CanonCryptoList)
  {
    && (exists x :: x in data && x.key == HeaderPath)
    && (exists x :: x in data && x.key == FooterPath)
    && (forall k <- data :: AuthExistsInCanonCrypto(k, canonList))
    && (forall k <- canonList :: CanonCryptoExistsInAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonCryptoListHasNoDuplicates(canonList)
  }

  opaque ghost predicate CanonCryptoUpdatedAuth(k : CanonCryptoItem, list : AuthList)
  {
    exists x :: x in list && Updated2(x, k, DoDecrypt)
  }

  opaque ghost predicate AuthUpdatedCanonCrypto(k : AuthItem, list : CanonCryptoList)
  {
    exists x :: x in list && Updated2(k, x, DoDecrypt)
  }

  opaque ghost predicate CryptoUpdatedAuth(k : CryptoItem, list : AuthList)
  {
    exists x :: x in list && Updated3(x, k, DoDecrypt)
  }

  opaque ghost predicate AuthUpdatedCrypto(k : AuthItem, list : CryptoList)
  {
    exists x :: x in list && Updated3(k, x, DoDecrypt)
  }

  opaque ghost predicate CanonCryptoUpdatedCrypto(k : CanonCryptoItem, list : CryptoList)
  {
    exists x :: x in list && Updated5(x, k, DoEncrypt)
  }

  opaque ghost predicate CryptoUpdatedCanonCrypto(k : CryptoItem, list : CanonCryptoList)
  {
    exists x :: x in list && Updated5(k, x, DoEncrypt)
  }

  opaque ghost predicate NewCryptoUpdatedCrypto(k : CryptoItem, list : CryptoList)
  {
    exists x :: x in list && Updated4(x, k, DoEncrypt)
  }

  opaque ghost predicate CryptoUpdatedNewCrypto(k : CryptoItem, list : CryptoList)
  {
    exists x :: x in list && Updated4(k, x, DoEncrypt)
  }

  opaque ghost predicate CanonCryptoUpdatedAuthList(tableName : GoodString, data : AuthList, canonList : CanonCryptoList)
  {
    && (exists x :: x in data && x.key == HeaderPath)
    && (exists x :: x in data && x.key == FooterPath)
    && (forall k <- data :: AuthUpdatedCanonCrypto(k, canonList))
    && (forall k <- canonList :: CanonCryptoUpdatedAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonCryptoListHasNoDuplicates(canonList)
  }

  opaque ghost predicate CryptoUpdatedAuthList(data : AuthList, canonList : CryptoList)
  {
    && (exists x :: x in data && x.key == HeaderPath)
    && (exists x :: x in data && x.key == FooterPath)
    && (forall k <- data :: AuthUpdatedCrypto(k, canonList))
    && (forall k <- canonList :: CryptoUpdatedAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(canonList)
  }

  opaque ghost predicate CryptoMatchesAuthList(tableName : GoodString, data : AuthList, canonList : CryptoList)
  {
    && (forall k <- data :: AuthExistsInCrypto(k, canonList))
    && (forall k <- canonList :: CryptoExistsInAuth(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(canonList)
  }

  opaque ghost predicate CanonCryptoMatchesCryptoList(tableName : GoodString, data : CryptoList, canonList : CanonCryptoList)
  {
    && (!exists x | x in data :: x.key in HeaderPaths)
    && (forall k <- data :: CryptoExistsInCanonCrypto(k, canonList))
    && (forall k <- canonList :: CanonCryptoExistsInCrypto(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonCryptoListHasNoDuplicates(canonList)
  }

  opaque ghost predicate CanonCryptoUpdatedCryptoList(tableName : GoodString, data : CryptoList, canonList : CanonCryptoList)
  {
    && (!exists x | x in data :: x.key in HeaderPaths)
    && (forall k <- data :: CryptoUpdatedCanonCrypto(k, canonList))
    && (forall k <- canonList :: CanonCryptoUpdatedCrypto(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.origKey))
    && (forall k <- canonList :: IsCanonPath(tableName, k.origKey, k.key))
    && CanonCryptoListHasNoDuplicates(canonList)
  }

  opaque ghost predicate CryptoUpdatedCryptoList(data : CryptoList, canonList : CryptoList)
  {
    && (!exists x | x in data :: x.key in HeaderPaths)
    && (forall k <- data :: CryptoUpdatedNewCrypto(k, canonList))
    && (forall k <- canonList :: NewCryptoUpdatedCrypto(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(canonList)
  }

  opaque ghost predicate CryptoUpdatedCryptoListHeader(data : CryptoList, canonList : CryptoList)
  {
    && (forall k <- data :: CryptoUpdatedNewCrypto(k, canonList))
    && (forall k <- canonList :: NewCryptoUpdatedCrypto(k, data))
    && |data| == |canonList|
    && (forall k <- canonList :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(canonList)
  }


  opaque function AuthToCanonAuth(tableName : GoodString, data : AuthList) : (ret : CanonAuthList)
    requires forall k <- data :: IsValidPath(k.key)
    requires exists x :: x in data && x.key == HeaderPath
    requires exists x :: x in data && x.key == FooterPath
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

  opaque function CryptoToCanonCrypto(tableName : GoodString, data : CryptoList) : (ret : CanonCryptoList)
    requires forall k <- data :: IsValidPath(k.key)
    requires CryptoListHasNoDuplicates(data)
    requires !exists x | x in data :: x.key in HeaderPaths
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
      assert forall k <- data :: exists x :: x in canonList && k.key == x.origKey && k.data == x.data && k.action == x.action;
      assert forall k <- data :: exists x :: x in canonList && SameStuff1(k, x);
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

  opaque function AuthSort(canonList : CanonAuthList, ghost tableName : GoodString, ghost data : AuthList) : (ret : CanonAuthList)
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
    assert CanonAuthMatchesAuthList(tableName, data, canonSorted);

    canonSorted
  }

  opaque function CryptoSort(canonList : CanonCryptoList, ghost tableName : GoodString, ghost data : CryptoList) : (ret : CanonCryptoList)
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
    assert CanonCryptoMatchesCryptoList(tableName, data, canonSorted);

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


  // This says vcs_split_on_every_assert, because it has many many asserts, each of which is cheap
  opaque function {:vcs_split_on_every_assert}
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
    var canonResolved :- ResolveLegend(canonSorted, legend);

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

  opaque ghost predicate IsCryptoSorted(list : CanonCryptoList)
  {
    Relations.SortedBy(list, SortCanon.CryptoBelow)
  }

  opaque function ForDecrypt(tableName : GoodString, data : AuthList, legend: Header.Legend)
    : (ret : Result<CanonCryptoList, Error>)
    requires AuthListHasNoDuplicates(data)
    requires exists x :: x in data && x.key == HeaderPath
    requires exists x :: x in data && x.key == FooterPath
    ensures ret.Success? ==>
              && CanonCryptoMatchesAuthList(tableName, data, ret.value)
              && IsCryptoSorted(ret.value)
  {
    reveal IsValidPath();
    :- Need(forall k <- data :: Paths.ValidPath(k.key), E("Invalid Paths"));
    var canonList := AuthToCanonAuth(tableName, data);
    var canonSorted := AuthSort(canonList, tableName, data);
    DoResolveLegend(canonSorted, legend, tableName, data)
  }

  predicate SameUnCanon(x : CanonCryptoItem, y : CryptoItem)
  {
    && x.origKey == y.key
    && x.data == y.data
    && x.action == y.action
  }

  function {:tailrecursion} UnCanon(input : CanonCryptoList, pos : nat := 0, acc : CryptoList := []) : (ret : CryptoList)
    requires 0 <= pos <= |input|
    requires pos == |acc|
    requires forall i | 0 <= i < |acc| :: SameUnCanon(input[i], acc[i])
    ensures |ret| == |input|
    ensures forall i | 0 <= i < |input| :: SameUnCanon(input[i], ret[i])
    decreases |input| - pos
  {
    if |input| == pos then
      acc
    else
      var newItem := CryptoItem(key := input[pos].origKey, data := input[pos].data, action := input[pos].action);
      UnCanon(input, pos+1, acc + [newItem])
  }

  lemma Update2ImpliesUpdate3()
    ensures forall oldVal : AuthItem, x : CanonCryptoItem, y : CryptoItem ::
              SameUnCanon(x, y) && Updated2(oldVal, x, DoDecrypt) ==> Updated3(oldVal, y, DoDecrypt)
  {}

  lemma Update5ImpliesUpdate4()
    ensures forall oldVal : CryptoItem, x : CanonCryptoItem, y : CryptoItem ::
              SameUnCanon(x, y) && Updated5(oldVal, x, DoEncrypt) ==> Updated4(oldVal, y, DoEncrypt)
  {}

  lemma AuthUpdatedCryptoMaps(origData : AuthList, input : CanonCryptoList, output : CryptoList)
    requires |input| == |output|
    requires forall k <- origData :: AuthUpdatedCanonCrypto(k, input)
    requires forall i | 0 <= i < |input| :: SameUnCanon(input[i], output[i])
    ensures forall k <- origData :: AuthUpdatedCrypto(k, output)
  {
    reveal AuthUpdatedCanonCrypto();
    reveal AuthUpdatedCrypto();
    assert forall k <- origData :: exists x :: x in output && Updated3(k, x, DoDecrypt) by {
      Update2ImpliesUpdate3();
    }
  }

  ghost predicate Updated2Exists(origData : AuthList, item : CanonCryptoItem)
  {
    exists x :: x in origData && Updated2(x, item, DoDecrypt)
  }

  ghost predicate Updated5Exists(origData : CryptoList, item : CanonCryptoItem)
  {
    exists x :: x in origData && Updated5(x, item, DoEncrypt)
  }

  lemma InputIsInput(origData : AuthList, input : CanonCryptoList)
    requires forall val <- input :: Updated2Exists(origData, val)
    ensures forall i | 0 <= i < |input| :: Updated2Exists(origData, input[i])
  {
  }

  lemma  InputIsInput2(origData : CryptoList, input : CanonCryptoList)
    requires forall val <- input :: Updated5Exists(origData, val)
    ensures forall i | 0 <= i < |input| :: Updated5Exists(origData, input[i])
  {
  }

  lemma CryptoUpdatedAuthMaps(origData : AuthList, input : CanonCryptoList, output : CryptoList)
    requires |input| == |output|
    requires forall k <- input :: CanonCryptoUpdatedAuth(k, origData)
    requires forall i | 0 <= i < |input| :: SameUnCanon(input[i], output[i])
    ensures forall k <- output :: CryptoUpdatedAuth(k, origData)
  {
    reveal CanonCryptoUpdatedAuth();
    reveal CryptoUpdatedAuth();
    assert forall k <- output :: exists x :: x in origData && Updated3(x, k, DoDecrypt) by {
      Update2ImpliesUpdate3();
      assert forall val <- input :: exists x :: x in origData && Updated2(x, val, DoDecrypt);
      assume {:axiom} forall i | 0 <= i < |input| :: exists x :: x in origData && Updated2(x, input[i], DoDecrypt);
      // assert forall i | 0 <= i < |input| :: exists x :: x in origData && Updated2(x, input[i], DoDecrypt) by {
      //   InputIsInput(origData, input);
      // }
      assert forall newVal <- output :: exists x :: x in origData && Updated3(x, newVal, DoDecrypt);
    }
  }

  function UnCanonDecrypt(input : CanonCryptoList, ghost tableName : GoodString, ghost origData : AuthList)
    : (ret : CryptoList)
    requires CanonCryptoUpdatedAuthList(tableName, origData, input)
    ensures CryptoUpdatedAuthList(origData, ret)
  {
    reveal CanonCryptoUpdatedAuthList();
    reveal CryptoUpdatedAuthList();

    var results := UnCanon(input);
    assert (forall k <- origData :: AuthUpdatedCrypto(k, results)) by {
      AuthUpdatedCryptoMaps(origData, input, results);
    }
    assert (forall k <- results :: CryptoUpdatedAuth(k, origData)) by {
      CryptoUpdatedAuthMaps(origData, input, results);
    }
    results
  }

  lemma CryptoUpdatedCryptoMaps(origData : CryptoList, input : CanonCryptoList, output : CryptoList)
    requires |input| == |output|
    requires forall k <- origData :: CryptoUpdatedCanonCrypto(k, input)
    requires forall i | 0 <= i < |input| :: SameUnCanon(input[i], output[i])
    ensures forall k <- origData :: CryptoUpdatedNewCrypto(k, output)
  {
    reveal CryptoUpdatedCanonCrypto();
    reveal CryptoUpdatedNewCrypto();
    assert forall k <- origData :: exists x :: x in output && Updated4(k, x, DoEncrypt) by {
      Update5ImpliesUpdate4();
    }
  }

  lemma CryptoUpdatedCryptoMaps2(origData : CryptoList, input : CanonCryptoList, output : CryptoList)
    requires |input| == |output|
    requires forall k <- input :: CanonCryptoUpdatedCrypto(k, origData)
    requires forall i | 0 <= i < |input| :: SameUnCanon(input[i], output[i])
    ensures forall k <- output :: NewCryptoUpdatedCrypto(k, origData)
  {
    assert forall i | 0 <= i < |input| :: input[i] in input;
    assert forall i | 0 <= i < |output| :: output[i] in output;
    forall i | 0 <= i < |output| ensures NewCryptoUpdatedCrypto(output[i], origData) {
      reveal CanonCryptoUpdatedCrypto();
      reveal NewCryptoUpdatedCrypto();
      Update5ImpliesUpdate4();
    }
  }

  function UnCanonEncrypt(input : CanonCryptoList, ghost tableName : GoodString, ghost origData : CryptoList)
    : (ret : CryptoList)
    requires CanonCryptoUpdatedCryptoList(tableName, origData, input)
    ensures CryptoUpdatedCryptoList(origData, ret)
  {
    reveal CanonCryptoUpdatedCryptoList();
    reveal CryptoUpdatedCryptoList();

    var results := UnCanon(input);
    assert forall k <- origData :: CryptoUpdatedNewCrypto(k, results) by {
      CryptoUpdatedCryptoMaps(origData, input, results);
    }
    assert forall k <- results :: NewCryptoUpdatedCrypto(k, origData) by {
      CryptoUpdatedCryptoMaps2(origData, input, results);
    }
    results
  }

  opaque ghost predicate EncryptPathFinal(origData : CryptoList, finalData : CryptoList)
  {
    && |finalData| == |origData| + 2
    && CryptoUpdatedCryptoListHeader(origData, finalData[..(|finalData|-2)])
    && finalData[|finalData|-2].key == HeaderPath
    && finalData[|finalData|-1].key == FooterPath
  }

  opaque function AddHeaders(input : CryptoList, headerData : StructuredDataTerminal, footerData : StructuredDataTerminal, ghost origData : CryptoList)
    : (ret : CryptoList)
    requires CryptoUpdatedCryptoList(origData, input)
    ensures EncryptPathFinal(origData, ret)
  {
    reveal EncryptPathFinal();
    reveal CryptoUpdatedCryptoList();
    reveal CryptoUpdatedCryptoListHeader();
    var headItem := Types.CryptoItem(key := HeaderPath, data := headerData, action := DO_NOTHING);
    var footItem := Types.CryptoItem(key := FooterPath, data := footerData, action := DO_NOTHING);
    var largeResult := input + [headItem, footItem];
    largeResult
  }

  opaque ghost predicate DecryptPathFinal(origData : AuthList, finalData : CryptoList)
  {
    && (!exists x :: x in finalData && x.key == HeaderPath)
    && (!exists x :: x in finalData && x.key == FooterPath)
    && (forall k <- origData :: (k.key in [HeaderPath, FooterPath]) || AuthUpdatedCrypto(k, finalData))
    && (forall k <- finalData :: CryptoUpdatedAuth(k, origData))
    && (forall k <- finalData :: IsValidPath(k.key))
    && CryptoListHasNoDuplicates(finalData)
  }

  opaque function {:tailrecursion} RemoveHeaderPaths(xs : CryptoList, pos : nat := 0, acc : CryptoList := []) : (ret : CryptoList)
    requires CryptoListHasNoDuplicates(xs)
    requires 0 <= pos <= |xs|
    requires !exists x :: x in acc && x.key in [HeaderPath, FooterPath]
    requires !exists x :: x in acc && x.key == HeaderPath
    requires !exists x :: x in acc && x.key == FooterPath
    requires forall x <- acc :: x in xs[..pos]
    requires forall i | 0 <= i < pos :: (xs[i].key in [HeaderPath, FooterPath] || xs[i] in acc)
    // should file a ticket, because this is FALSE but verifies
    // requires forall x <- xs :: (x.key in [HeaderPath, FooterPath] || x in acc)
    requires CryptoListHasNoDuplicates(acc)

    ensures !exists x :: x in ret && x.key in [HeaderPath, FooterPath]
    ensures !exists x :: x in ret && x.key == HeaderPath
    ensures !exists x :: x in ret && x.key == FooterPath
    ensures forall x <- ret :: x in xs
    ensures forall x <- xs :: (x.key in [HeaderPath, FooterPath] || x in ret)
    ensures CryptoListHasNoDuplicates(ret)

    decreases |xs| - pos
  {
    if |xs| == pos then
      acc
    else if xs[pos].key in [HeaderPath, FooterPath] then
      RemoveHeaderPaths(xs, pos+1, acc)
    else
      assert xs[pos] !in acc;
      RemoveHeaderPaths(xs, pos+1, acc + [xs[pos]])
  }

  opaque function RemoveHeaders(input : CryptoList, ghost origData : AuthList)
    : (ret : CryptoList)
    requires CryptoUpdatedAuthList(origData, input)

    ensures DecryptPathFinal(origData, ret)
  {
    reveal CryptoUpdatedAuthList();
    reveal DecryptPathFinal();
    reveal AuthUpdatedCrypto();
    var finalData := RemoveHeaderPaths(input);
    assert forall k <- origData :: (k.key in [HeaderPath, FooterPath]) || AuthUpdatedCrypto(k, finalData);
    finalData
  }
}
