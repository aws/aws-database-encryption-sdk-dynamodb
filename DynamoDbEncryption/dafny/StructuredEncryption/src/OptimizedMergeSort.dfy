// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"

module {:options "-functionSyntax:4"} OptimizedMergeSort {

  import Relations
  import BoundedInts
  import InternalModule = Seq.MergeSort
  import StandardLibrary.MemoryMath

  predicate HasUint64Len<T>(s: seq<T>) {
    |s| < BoundedInts.TWO_TO_THE_64
  }

  // The MergeSortBy function implemented as implemented
  // does not compile to an optimal implementation
  // in any of the Dafny target languages.
  // This implementation aims to be significantly more optimal.
  // First, it minimizes copies.
  // It does this by making 2 arrays of the original sequence
  // and then using these 2 as left and right alternatively.
  // This can be audited by verifying
  // that the arrays are only sliced into a seq in `MergeSortNat`.
  // All other slicing is done in ghost state.
  // Second, is has a bounded number implementation
  // that avoids using `nat`.

  function {:isolate_assertions} MergeSort<T(!new)>(s: seq<T>, lessThanOrEq: (T, T) -> bool): (result :seq<T>)
    requires Relations.TotalOrdering(lessThanOrEq)
    requires HasUint64Len(s)
  {
    InternalModule.MergeSortBy(s, lessThanOrEq)
  }
  by method {
    if |s| <= 1 {
      return s;
    } else {

      // The slice x[1..], y[1..] are un-optimized operations in Dafny.
      // This means that their usage will result in a lot of data copying.
      // Additional, it is very likely that these size of these sequences
      // will be less than uint64.
      // So writing an optimized version that only works on bounded types
      // should further optimized this hot code.

      var left := new T[|s|](i requires 0 <= i < |s| => s[i]);
      var right := new T[|s|](i requires 0 <= i < |s| => s[i]);
      var lo, hi := 0, right.Length;

      label BEFORE_WORK:

      var boundedLo: BoundedInts.uint64, boundedHi: BoundedInts.uint64 := 0, right.Length as BoundedInts.uint64;
      ghost var _ := MergeSortMethod(left, right, lessThanOrEq, boundedLo, boundedHi, Right);

      result :=  right[..];

      ghost var other := InternalModule.MergeSortBy(s, lessThanOrEq);

      assert Relations.SortedBy(right[..], lessThanOrEq) by {
        assert right[..] == right[lo..hi];
      }
      assert multiset(right[..]) == multiset(other) by {
        calc {
          multiset(right[..]);
        == {assert right[..] == right[lo..hi];}
          multiset(right[lo..hi]);
        ==
          multiset(old@BEFORE_WORK(left[lo..hi]));
        == {assert old@BEFORE_WORK(left[lo..hi]) == s;}
          multiset(s);
        ==
          multiset(other);
        }
      }

      // Implementing a by method can be complicated.
      // Because methods can have non-determinism,
      // where functions can not.
      // This means that Dafny normally wants to know
      // that the method and function maintain equality at every step.
      // But this is hard for this kind of optimized sorting.
      // Because what is the functional state at every step
      // and how does it correspond the state of 2 optimized arrays?
      // This lemma works around this
      // by proving that the outcomes are always deterministic and the same.
      // It does this by proving that given a total ordering,
      // there is one and only one way to sort a given sequence.
      TotalOrderingImpliesSortingIsUnique(right[..], other, lessThanOrEq);
    }
  }

  // This is included as sugar in case you don't want to ensure your seq HasUint64Len.
  function {:isolate_assertions} MergeSortNat<T(!new)>(s: seq<T>, lessThanOrEq: (T, T) -> bool): (result :seq<T>)
    requires Relations.TotalOrdering(lessThanOrEq)
  {
    MemoryMath.SequenceIsSafeBecauseItIsInMemory(s);
    MergeSort(s, lessThanOrEq)
  }

  datatype PlaceResults = Left | Right | Either
  type ResultPlacement = r: PlaceResults | !r.Either? witness *

  // These are bounded implementations of merge sort.
  // This further speeds things up
  // because math with bounded variables
  // is significantly faster that math with big numbers.

  method {:isolate_assertions} MergeSortMethod<T(!new)>(
    left: array<T>,
    right: array<T>,
    lessThanOrEq: (T, T) -> bool,
    lo: BoundedInts.uint64,
    hi: BoundedInts.uint64,
    where: PlaceResults
  )
    returns (resultPlacement: ResultPlacement)
    requires Relations.TotalOrdering(lessThanOrEq)
    requires left.Length < BoundedInts.TWO_TO_THE_64
    requires right.Length < BoundedInts.TWO_TO_THE_64
    requires lo < hi <= left.Length as BoundedInts.uint64
    requires hi <= right.Length as BoundedInts.uint64
    requires left != right
    // reads left, right
    modifies left, right
    ensures !where.Either? ==> where == resultPlacement

    // We do not modify anything before lo
    ensures left[..lo] == old(left[..lo]) && right[..lo] == old(right[..lo])
    // We do not modify anything above hi
    ensures left[hi..] == old(left[hi..]) && right[hi..] == old(right[hi..])

    ensures multiset(left[lo..hi]) == multiset(old(left[lo..hi]))
    ensures resultPlacement.Left? ==> Relations.SortedBy(left[lo..hi], lessThanOrEq)
    ensures resultPlacement.Right? ==> Relations.SortedBy(right[lo..hi], lessThanOrEq)
    ensures resultPlacement.Right? ==> multiset(right[lo..hi]) == multiset(old(left[lo..hi]))

    decreases hi - lo
  {
    if hi - lo == 1 {
      if where == Right {
        right[lo] := left[lo];
        return Right;
      } else {
        return Left;
      }
    }

    ghost var beforeWork := multiset(left[lo..hi]);
    var mid :=  ((hi - lo)/2) + lo;
    var placement? := MergeSortMethod(left, right, lessThanOrEq, lo, mid, Either);
    assert left[mid..hi] == old(left[mid..hi]);
    ghost var placement2? := MergeSortMethod(left, right, lessThanOrEq, mid, hi, placement?);
    assert placement2? == placement?;

    ghost var preMergeResult := if placement?.Left? then left else right;
    calc {
      multiset(preMergeResult[lo..hi]);
    == { LemmaSplitAt(preMergeResult[..], lo as nat, mid as nat, hi as nat); }
      multiset(preMergeResult[lo..mid] + preMergeResult[mid..hi]);
    ==
      multiset(old(left[lo..mid]) + old(left[mid..hi]));
    ==  { LemmaSplitAt(old(left[..]), lo as nat, mid as nat, hi as nat); }
      beforeWork;
    }

    ghost var mergedResult;
    if placement?.Left? {
      MergeIntoRight(left := left, right := right, lessThanOrEq := lessThanOrEq, lo := lo, mid := mid, hi := hi);
      resultPlacement, mergedResult := Right, right[lo..hi];

      assert left[hi..] == old(left[hi..]);
      assert right[hi..] == old(right[hi..]);
      assert left[..lo] == old(left[..lo]);
      assert right[..lo] == old(right[..lo]);
    } else {
      assert placement?.Right?;
      MergeIntoRight(left := right, right := left, lessThanOrEq := lessThanOrEq, lo := lo, mid := mid, hi := hi);
      resultPlacement, mergedResult := Left, left[lo..hi];

      assert left[hi..] == old(left[hi..]);
      assert right[hi..] == old(right[hi..]);
      assert left[..lo] == old(left[..lo]);
      assert right[..lo] == old(right[..lo]);
    }

    label BEFORE_RETURN:
    assert left[hi..] == old(left[hi..]);
    assert right[hi..] == old(right[hi..]);
    assert left[..lo] == old(left[..lo]);
    assert right[..lo] == old(right[..lo]);
    if resultPlacement.Left? && where == Right {
      // A forall comprehension might seem like a nice fit here,
      // however this does not good for two reasons.
      // First, Dafny currently creates a range for the full bounds of the bounded number
      // see: https://github.com/dafny-lang/dafny/issues/5897
      // Second this would create two loops.
      // First loop would create the `lo to hi` range of numbers.
      // The second loop would then loop over these elements.
      for i := lo to hi
        modifies right
        invariant left[..lo] == old(left[..lo]) && right[..lo] == old(right[..lo])
        invariant left[hi..] == old(left[hi..]) && right[hi..] == old(right[hi..])
        invariant right[lo..i] == left[lo..i]
      {
        right[i] := left[i];
        assert right[lo..i] == left[lo..i];
      }

      assert right[lo..hi] == mergedResult by {
        assert mergedResult == left[lo..hi];
      }
      assert left[..] == old@BEFORE_RETURN(left[..]);
      assert right[..lo] == old(right[..lo]);

      resultPlacement := Right;
    }
    if resultPlacement.Right? && where == Left {
      for i := lo to hi
        modifies left
        invariant left[..lo] == old(left[..lo]) && right[..lo] == old(right[..lo])
        invariant left[hi..] == old(left[hi..]) && right[hi..] == old(right[hi..])
        invariant left[lo..i] == right[lo..i]
      {
        left[i] := right[i];
        assert right[lo..i] == left[lo..i];
      }

      assert left[lo..hi] == mergedResult by {
        assert mergedResult == right[lo..hi];
      }
      assert right[..] == old@BEFORE_RETURN(right[..]);
      assert left[..lo] == old(left[..lo]);

      resultPlacement := Left;
    }
  }

  method {:isolate_assertions} MergeIntoRight<T(!new)>(
    nameonly left: array<T>,
    nameonly right: array<T>,
    nameonly lessThanOrEq: (T, T) -> bool,
    nameonly lo: BoundedInts.uint64,
    nameonly mid: BoundedInts.uint64,
    nameonly hi: BoundedInts.uint64
  )
    requires Relations.TotalOrdering(lessThanOrEq)
    requires
      && left.Length < BoundedInts.TWO_TO_THE_64
      && right.Length < BoundedInts.TWO_TO_THE_64
    requires lo <= mid <= hi <= left.Length as BoundedInts.uint64
    requires  hi <= right.Length as BoundedInts.uint64 && left != right
    // We store "left" in [lo..mid]
    requires Relations.SortedBy(left[lo..mid], lessThanOrEq)
    // We store "right" in [mid..hi]
    requires Relations.SortedBy(left[mid..hi], lessThanOrEq)
    // reads left, right
    modifies right
    // We do not modify anything before lo
    ensures right[..lo] == old(right[..lo]) && left[..lo] == old(left[..lo])
    // We do not modify anything above hi
    ensures right[hi..] == old(right[hi..]) && left[..lo] == old(left[..lo])
    ensures Relations.SortedBy(right[lo..hi], lessThanOrEq)
    ensures multiset(right[lo..hi]) == multiset(old(left[lo..hi]))
    ensures multiset(left[lo..hi]) == multiset(old(left[lo..hi]))
  {
    var leftPosition, rightPosition, iter := lo, mid, lo;
    while iter < hi
      modifies right

      invariant lo <= leftPosition <= mid <= rightPosition <= hi
      invariant leftPosition as nat - lo as nat + rightPosition as nat - mid as nat == iter as nat - lo as nat
      invariant right[..lo] == old(right[..lo])
      invariant right[hi..] == old(right[hi..])

      invariant Relations.SortedBy(left[leftPosition..mid], lessThanOrEq)
      invariant Relations.SortedBy(left[rightPosition..hi], lessThanOrEq)
      invariant Below(right[lo..iter], left[leftPosition..mid], lessThanOrEq)
      invariant Below(right[lo..iter], left[rightPosition..hi], lessThanOrEq)
      invariant Relations.SortedBy(right[lo..iter], lessThanOrEq)
      invariant multiset(right[lo..iter]) == multiset(left[lo..leftPosition] + left[mid..rightPosition])
    {

      ghost var oldRightPosition, oldIter, oldLeftPosition := rightPosition, iter, leftPosition;
      if leftPosition == mid || (rightPosition < hi && lessThanOrEq(left[rightPosition], left[leftPosition])) {
        right[iter] := left[rightPosition];

        PushStillSortedBy(right, lo as nat, iter as nat, lessThanOrEq);
        rightPosition, iter := rightPosition + 1, iter + 1;

        BelowIsTransitive(right[lo..iter], left[leftPosition..mid], lessThanOrEq);

        assert 0 < |right[lo..iter]| && 0 < |left[rightPosition..hi]| ==> lessThanOrEq(right[lo..iter][|right[lo..iter]| - 1], left[rightPosition..hi][0]) by {
          if 0 == |right[lo..iter]| || 0 == |left[rightPosition..hi]| {
          } else {
            assert Relations.SortedBy(left[oldRightPosition..hi], lessThanOrEq);
            assert lessThanOrEq(left[oldRightPosition..hi][0], left[oldRightPosition..hi][1]);
          }
        }
        BelowIsTransitive(right[lo..iter], left[rightPosition..hi], lessThanOrEq);

        assert multiset(right[lo..iter]) == multiset(left[lo..leftPosition] + left[mid..rightPosition]) by {
          // Dafny just wants to be reminded
        }
      } else {
        right[iter] := left[leftPosition];

        PushStillSortedBy(right, lo as nat, iter as nat, lessThanOrEq);
        leftPosition, iter := leftPosition + 1, iter + 1;

        assert 0 < |right[lo..iter]| && 0 < |left[leftPosition..mid]| ==> lessThanOrEq(right[lo..iter][|right[lo..iter]| - 1], left[leftPosition..mid][0]) by {
          if 0 == |right[lo..iter]| || 0 == |left[leftPosition..mid]| {
          } else {
            assert Relations.SortedBy(left[oldLeftPosition..mid], lessThanOrEq);
            assert lessThanOrEq(left[oldLeftPosition..mid][0], left[oldLeftPosition..mid][1]);
          }
        }
        BelowIsTransitive(right[lo..iter], left[leftPosition..mid], lessThanOrEq);
        assert 0 < |right[lo..iter]| && 0 < |left[rightPosition..hi]| ==> lessThanOrEq(right[lo..iter][|right[lo..iter]| - 1], left[rightPosition..hi][0]) by {
          if 0 == |right[lo..iter]| || 0 == |left[rightPosition..hi]| {
          } else {
            assert right[lo..iter][|right[lo..iter]| - 1] == right[iter - 1];
            assert left[rightPosition..hi][0] == left[rightPosition];
          }
        }
        BelowIsTransitive(right[lo..iter], left[rightPosition..hi], lessThanOrEq);

        assert multiset(right[lo..iter]) == multiset(left[lo..leftPosition] + left[mid..rightPosition]) by {
          // Dafny just wants to be reminded
        }
      }
    }
    assert multiset(right[lo..hi]) == multiset(old(left[lo..hi])) by {
      assert leftPosition == mid && rightPosition == hi;
      LemmaSplitAt(left[..], lo as nat, mid as nat, hi as nat);
      assert old(left[lo..hi]) == left[lo..hi] == left[lo..mid] + left[mid..hi];
    }
  }

  // Helpers to prove MergeSort

  ghost predicate Below<T(!new)>(a: seq<T>, b: seq<T>, lessThanOrEq: (T, T) -> bool)
    requires Relations.TotalOrdering(lessThanOrEq)
  {
    forall i, j :: 0 <= i < |a| && 0 <= j < |b| ==> lessThanOrEq(a[i], b[j])
  }

  lemma BelowIsTransitive<T(!new)>(a: seq<T>, b: seq<T>, lessThanOrEq: (T, T) -> bool)
    requires Relations.TotalOrdering(lessThanOrEq)
    requires Relations.SortedBy(a, lessThanOrEq)
    requires Relations.SortedBy(b, lessThanOrEq)
    requires 0 < |a| && 0 < |b| ==> lessThanOrEq(a[|a| - 1], b[0])
    ensures Below(a, b, lessThanOrEq)
  {}

  lemma PushStillSortedBy<T(!new)>(a: array<T>, lo:nat, i: nat, lessThanOrEq: (T, T) -> bool)
    requires 0 <= lo <= i < a.Length
    requires Relations.SortedBy(a[lo..i], lessThanOrEq)
    requires |a[lo..i]| == 0 || lessThanOrEq(a[lo..i][|a[lo..i]| - 1], a[i])
    requires Relations.TotalOrdering(lessThanOrEq)
    ensures Relations.SortedBy(a[lo..i + 1], lessThanOrEq)
    ensures lo < i ==> lessThanOrEq(a[i - 1], a[i])
  {}

  lemma {:isolate_assertions} TotalOrderingImpliesSortingIsUnique<T(!new)>(s1: seq<T>, s2: seq<T>, lessThanOrEq: (T, T) -> bool)
    requires Relations.TotalOrdering(lessThanOrEq)
    requires Relations.SortedBy(s1, lessThanOrEq) && Relations.SortedBy(s2, lessThanOrEq)
    requires multiset(s1) == multiset(s2)
    ensures s1 == s2
  {
    if |s1| == 0 {
    } else {
      assert s1[0] in s2 by {
        assert s1[0] in multiset(s2);
      }

      var i :| 0 <= i < |s2| && s2[i] == s1[0];
      assert multiset{s1[0]} == multiset{s2[i]};
      assert multiset{s1[0]} + multiset(s1[1..]) == multiset(s1) by {
        assert s1 == [s1[0]] + s1[1..];
      }
      assert multiset{s2[i]} + multiset(s2[0..i] + s2[i+1..]) == multiset(s2) by {
        assert s2 == s2[0..i] + [s2[i]] + s2[i+1..];
      }

      assert Relations.SortedBy(s1[1..], lessThanOrEq);
      assert Relations.SortedBy(s2[0..i] + s2[i+1..], lessThanOrEq) by {
        if i == 0 || i == |s2| - 1 {
        } else {
          assert lessThanOrEq(s2[i-1], s2[i]);
          assert lessThanOrEq(s2[i], s2[i+1]);
        }
      }
      MultisetProperty(multiset{s1[0]}, multiset(s1[1..]), multiset(s2[0..i] + s2[i+1..]));
      TotalOrderingImpliesSortingIsUnique(s1[1..], s2[0..i] + s2[i+1..], lessThanOrEq);

      if i == 0 {
      } else {
        assert s1 == [s2[i]] + s1[1..];
        assert lessThanOrEq(s2[0], s2[i]);
        assert s2[0] in s1;
      }
    }
  }

  lemma MultisetProperty(m: multiset, a: multiset, b: multiset)
    requires m + a == m + b
    ensures a == b
  {
    var a' := (m + a) - m;
    var b' := (m + b) - m;
    assert a == a' == b' == b;
  }

  lemma LemmaNewFirstElementStillSortedBy<T(!new)>(x: T, s: seq<T>, lessThan: (T, T) -> bool)
    requires Relations.SortedBy(s, lessThan)
    requires |s| == 0 || lessThan(x, s[0])
    requires Relations.TotalOrdering(lessThan)
    ensures Relations.SortedBy([x] + s, lessThan)
  {}

  lemma LemmaSplitAt<T>(s: seq<T>, lo: nat, split: nat, hi: nat)
    requires 0 <= lo
    requires lo <= split
    requires split <= hi
    requires hi <= |s|
    ensures s[lo..hi] == s[lo..split] + s[split..hi]
  {}
}
