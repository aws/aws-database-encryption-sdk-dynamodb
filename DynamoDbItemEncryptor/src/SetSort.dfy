// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

// This is from a future version of /libraries/src/
// This should be removed when that file appears

include "../../private-aws-encryption-sdk-dafny-staging/libraries/src/Collections/Sequences/MergeSort.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/libraries/src/Relations.dfy"

module {:options "-functionSyntax:4"} Set.Sort {
  import opened Seq.MergeSort
  import opened Relations

  ghost function GhostSetToSeq<X>(xs: set<X>): (xx: seq<X>)
    ensures multiset(xs) == multiset(xx)
  {
    if xs == {} then [] else var x :| x in xs; [x] + GhostSetToSeq(xs - {x})
  }

  method SetToSeq<X>(xs: set<X>) returns (xx: seq<X>)
    ensures multiset(xs) == multiset(xx)
  {
    xx := [];
    var left: set<X> := xs;
    while left != {}
      invariant multiset(left) + multiset(xx) == multiset(xs)
    {
      var x :| x in left;
      left := left - {x};
      xx := xx + [x];
    }
  }

  lemma SortedUnique<X>(xx: seq<X>, xx': seq<X>, lessThanOrEq: (X, X) -> bool)
    requires SortedBy(xx, lessThanOrEq)
    requires SortedBy(xx', lessThanOrEq)
    requires TotalOrdering(lessThanOrEq)
    requires multiset(xx) == multiset(xx')
    ensures xx == xx'
  {
    assert |xx| == |multiset(xx)| == |multiset(xx')| == |xx'|;
    if xx == [] || xx' == [] {
    } else {
      assert xx == [xx[0]] + xx[1..];
      assert xx' == [xx'[0]] + xx'[1..];
      assert multiset(xx[1..]) == multiset(xx) - multiset{xx[0]};
      assert multiset(xx'[1..]) == multiset(xx') - multiset{xx'[0]};
      assert xx[0] == xx'[0]; // ??
      assert multiset(xx[1..]) == multiset(xx'[1..]); // ??
      SortedUnique(xx[1..], xx'[1..], lessThanOrEq);
    }
  }

  function SortSet<X>(xs: set<X>, lessThanOrEq: (X, X) -> bool): (xx: seq<X>)
    requires TotalOrdering(lessThanOrEq)
    ensures multiset(xs) == multiset(xx)
    ensures SortedBy(xx, lessThanOrEq)
  {
    MergeSortBy(GhostSetToSeq(xs), lessThanOrEq)
  } by method {
    xx := SetToSeq(xs);
    xx := MergeSortBy(xx, lessThanOrEq);
    SortedUnique(xx, SortSet(xs, lessThanOrEq), lessThanOrEq);
  }
}
