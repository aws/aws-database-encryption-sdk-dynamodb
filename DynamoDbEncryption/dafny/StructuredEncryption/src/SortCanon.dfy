// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "Util.dfy"

module SortCanon {
  export provides
      AuthSort,
      CryptoSort,
      AuthBelow,
      CryptoBelow,
      StructuredEncryptionUtil,
      Relations

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

  lemma {:axiom} AuthBelowIsAntiSymmetric(x: CanonAuthItem, y: CanonAuthItem)
    requires AuthBelow(x, y) && AuthBelow(y, x)
    ensures x == y
  // {
  //   assert Below(x.key, y.key);
  //   assert Below(y.key, x.key);
  //   BelowIsAntiSymmetric(x.key, y.key);
  //   BelowIsAntiSymmetric(y.key, x.key);
  // }

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

  function method AuthSort(x : seq<CanonAuthItem>) : (result : seq<CanonAuthItem>)
    ensures multiset(x) == multiset(result)
    ensures SortedBy(result, AuthBelow)
  {
    AuthBelowIsTotal();
    MergeSortBy(x, AuthBelow)
  }

  function method CryptoSort(x : seq<CanonCryptoItem>) : (result : seq<CanonCryptoItem>)
    ensures multiset(x) == multiset(result)
    ensures SortedBy(result, CryptoBelow)
  {
    CryptoBelowIsTotal();
    MergeSortBy(x, CryptoBelow)
  }


}