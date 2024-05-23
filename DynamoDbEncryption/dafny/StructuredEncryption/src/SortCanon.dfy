// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "Util.dfy"

module SortCanon {
  export
    provides
      AuthSort,
      CryptoSort,
      AuthBelow,
      CryptoBelow,
      StructuredEncryptionUtil,
      Relations,
      AuthSortIsCryptoSort,
      SortedIsSorted

  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened Relations
  import opened Seq.MergeSort
  import opened StructuredEncryptionUtil

  predicate method AuthBelow(x: CanonAuthItem, y: CanonAuthItem) {
    Below(x.key, y.key)
  }

  predicate method CryptoBelow(x: CanonCryptoItem, y: CanonCryptoItem) {
    Below(x.key, y.key)
  }

  lemma SameBelow2(x1 : CanonAuthItem, x2 : CanonAuthItem, y1 : CanonCryptoItem, y2 : CanonCryptoItem)
    requires x1.key == y1.key
    requires x2.key == y2.key
    ensures AuthBelow(x1, x2) == CryptoBelow(y1, y2)
  {}

  lemma SameBelow()
    ensures forall x1 : CanonAuthItem, x2 : CanonAuthItem, y1 : CanonCryptoItem, y2 : CanonCryptoItem
              | x1.key == y1.key && x2.key == y2.key
              :: AuthBelow(x1, x2) == CryptoBelow(y1, y2)
  {

  }

  lemma AuthBelowIsReflexive(x: CanonAuthItem)
    ensures AuthBelow(x, x)
  {
    BelowIsReflexive(x.key);
  }

  lemma CryptoBelowIsReflexive(x: CanonCryptoItem)
    ensures CryptoBelow(x, x)
  {
    BelowIsReflexive(x.key);
  }

  // not actually required for sorting. Standard library being updated.
  lemma {:axiom} AuthBelowIsAntiSymmetric(x: CanonAuthItem, y: CanonAuthItem)
    requires AuthBelow(x, y) && AuthBelow(y, x)
    ensures x == y

  // not actually required for sorting. Standard library being updated.
  lemma {:axiom} CryptoBelowIsAntiSymmetric(x: CanonCryptoItem, y: CanonCryptoItem)
    requires CryptoBelow(x, y) && CryptoBelow(y, x)
    ensures x == y


  lemma AuthBelowIsTransitive(x: CanonAuthItem, y: CanonAuthItem, z: CanonAuthItem)
    requires AuthBelow(x, y) && AuthBelow(y, z)
    ensures AuthBelow(x, z)
  {
    BelowIsTransitive(x.key, y.key, z.key);
  }

  lemma CryptoBelowIsTransitive(x: CanonCryptoItem, y: CanonCryptoItem, z: CanonCryptoItem)
    requires CryptoBelow(x, y) && CryptoBelow(y, z)
    ensures CryptoBelow(x, z)
  {
    BelowIsTransitive(x.key, y.key, z.key);
  }

  lemma AuthBelowIsStronglyConnected(x: CanonAuthItem, y: CanonAuthItem)
    ensures AuthBelow(x, y) || AuthBelow(y, x)
  {
    BelowIsStronglyConnected(x.key, y.key);
  }

  lemma CryptoBelowIsStronglyConnected(x: CanonCryptoItem, y: CanonCryptoItem)
    ensures CryptoBelow(x, y) || CryptoBelow(y, x)
  {
    BelowIsStronglyConnected(x.key, y.key);
  }

  lemma AuthBelowIsTotal()
    ensures TotalOrdering(AuthBelow)
  {
    BelowIsTotal();
    assert TotalOrdering(Below);
    assert Reflexive(AuthBelow) by {
      forall x {
        AuthBelowIsReflexive(x);
      }
    }
    assert AntiSymmetric(AuthBelow) by {
      forall x, y | AuthBelow(x, y) && AuthBelow(y, x) {
        AuthBelowIsAntiSymmetric(x, y);
      }
    }
    assert Relations.Transitive(AuthBelow) by {
      forall x, y, z | AuthBelow(x, y) && AuthBelow(y, z) {
        AuthBelowIsTransitive(x, y, z);
      }
    }
    assert StronglyConnected(AuthBelow) by {
      forall x, y {
        AuthBelowIsStronglyConnected(x, y);
      }
    }
  }

  lemma CryptoBelowIsTotal()
    ensures TotalOrdering(CryptoBelow)
  {
    BelowIsTotal();
    assert TotalOrdering(Below);
    assert Reflexive(CryptoBelow) by {
      forall x {
        CryptoBelowIsReflexive(x);
      }
    }
    assert AntiSymmetric(CryptoBelow) by {
      forall x, y | CryptoBelow(x, y) && CryptoBelow(y, x) {
        CryptoBelowIsAntiSymmetric(x, y);
      }
    }
    assert Relations.Transitive(CryptoBelow) by {
      forall x, y, z | CryptoBelow(x, y) && CryptoBelow(y, z) {
        CryptoBelowIsTransitive(x, y, z);
      }
    }
    assert StronglyConnected(CryptoBelow) by {
      forall x, y {
        CryptoBelowIsStronglyConnected(x, y);
      }
    }
  }

  predicate method Below(x: seq<uint8>, y: seq<uint8>) {
    |x| != 0 ==>
      && |y| != 0
      && x[0] <= y[0]
      && (x[0] == y[0] ==> Below(x[1..], y[1..]))
  }

  lemma BelowIsTotal()
    ensures TotalOrdering(Below)
  {
    assert Reflexive(Below) by {
      forall x {
        BelowIsReflexive(x);
      }
    }
    assert AntiSymmetric(Below) by {
      forall x, y | Below(x, y) && Below(y, x) {
        BelowIsAntiSymmetric(x, y);
      }
    }
    assert Relations.Transitive(Below) by {
      forall x, y, z | Below(x, y) && Below(y, z) {
        BelowIsTransitive(x, y, z);
      }
    }
    assert StronglyConnected(Below) by {
      forall x, y {
        BelowIsStronglyConnected(x, y);
      }
    }
  }

  lemma BelowIsReflexive(x: seq<uint8>)
    ensures Below(x, x)
  {
  }

  lemma BelowIsAntiSymmetric(x: seq<uint8>, y: seq<uint8>)
    requires Below(x, y) && Below(y, x)
    ensures x == y
  {
  }

  lemma BelowIsTransitive(x: seq<uint8>, y: seq<uint8>, z: seq<uint8>)
    requires Below(x, y) && Below(y, z)
    ensures Below(x, z)
  {
  }

  lemma BelowIsStronglyConnected(x: seq<uint8>, y: seq<uint8>)
    ensures Below(x, y) || Below(y, x)
  {
  }

  lemma AuthSortIsCryptoSort(x : CanonAuthList, y : CanonCryptoList)
    requires SortedBy(x, AuthBelow)
    requires |x| == |y|
    requires forall i | 0 <= i < |x| :: x[i].key == y[i].key
    ensures SortedBy(y, CryptoBelow)
  {}

  lemma SortedIsSorted(x : CanonCryptoList, y : CanonCryptoList)
    requires SortedBy(x, CryptoBelow)
    requires |x| == |y|
    requires forall i | 0 <= i < |x| :: x[i].key == y[i].key
    ensures SortedBy(y, CryptoBelow)
  {}


  function method AuthSort(x : CanonAuthList) : (result : CanonAuthList)
    requires CanonAuthListHasNoDuplicates(x)
    ensures multiset(x) == multiset(result)
    ensures SortedBy(result, AuthBelow)
    ensures CanonAuthListHasNoDuplicates(result)
  {
    AuthBelowIsTotal();
    var ret := MergeSortBy(x, AuthBelow);
    CanonAuthListMultiNoDup(x, ret);
    assert CanonAuthListHasNoDuplicates(ret);
    ret
  }

  function method CryptoSort(x : CanonCryptoList) : (result : CanonCryptoList)
    requires CanonCryptoListHasNoDuplicates(x)
    ensures multiset(x) == multiset(result)
    ensures multiset(result) == multiset(x)
    ensures SortedBy(result, CryptoBelow)
    ensures CanonCryptoListHasNoDuplicates(result)
  {
    CryptoBelowIsTotal();
    var ret := MergeSortBy(x, CryptoBelow);
    CanonCryptoListMultiNoDup(x, ret);
    assert CanonCryptoListHasNoDuplicates(ret);
    ret
  }

  lemma MultisetHasNoDuplicates(xs: CanonCryptoList)
    requires CanonCryptoListHasNoDuplicates(xs)
    ensures forall x | x in multiset(xs) :: multiset(xs)[x] == 1
  {
    if |xs| == 0 {
    } else {
      assert xs == Seq.DropLast(xs) + [Seq.Last(xs)];
      assert Seq.Last(xs) !in Seq.DropLast(xs);
      assert CanonCryptoListHasNoDuplicates(Seq.DropLast(xs));
      MultisetHasNoDuplicates(Seq.DropLast(xs));
    }
  }
  lemma MultisetHasNoDuplicates2(xs: CanonAuthList)
    requires CanonAuthListHasNoDuplicates(xs)
    ensures forall x | x in multiset(xs) :: multiset(xs)[x] == 1
  {
    if |xs| == 0 {
    } else {
      assert xs == Seq.DropLast(xs) + [Seq.Last(xs)];
      assert Seq.Last(xs) !in Seq.DropLast(xs);
      assert CanonAuthListHasNoDuplicates(Seq.DropLast(xs));
      MultisetHasNoDuplicates2(Seq.DropLast(xs));
    }
  }
  lemma CanonCryptoListMultiNoDup(a: CanonCryptoList, b: CanonCryptoList)
    requires CanonCryptoListHasNoDuplicates(a) && multiset(a) == multiset(b)
    ensures CanonCryptoListHasNoDuplicates(b)
  {
    forall i,j | 0 <= i < j < |b|
      ensures b[i].origKey != b[j].origKey
    {
      assert b[i] in multiset(a);
      assert b[j] in multiset(a);
      if b[i] == b[j] {
        assert b[i].origKey == b[j].origKey;
        MultisetHasNoDuplicates(a);
        assert multiset(b)[b[i]] == 1;
        assert b == b[..i] + [b[i]] + b[i+1..j] + [b[j]] + b[j+1..];
      } else {
        assert b[i].origKey != b[j].origKey;
      }
    }
  }
  lemma CanonAuthListMultiNoDup(a: CanonAuthList, b: CanonAuthList)
    requires CanonAuthListHasNoDuplicates(a) && multiset(a) == multiset(b)
    ensures CanonAuthListHasNoDuplicates(b)
  {
    forall i,j | 0 <= i < j < |b|
      ensures b[i].origKey != b[j].origKey
    {
      assert b[i] in multiset(a);
      assert b[j] in multiset(a);
      if b[i] == b[j] {
        assert b[i].origKey == b[j].origKey;
        MultisetHasNoDuplicates2(a);
        assert multiset(b)[b[i]] == 1;
        assert b == b[..i] + [b[i]] + b[i+1..j] + [b[j]] + b[j+1..];
      } else {
        assert b[i].origKey != b[j].origKey;
      }
    }
  }

}