// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

module {:options "-functionSyntax:4"} Permutations {

  function factorial(n : nat) : nat
    ensures 0 < n ==> 0 < factorial(n)
  {
    if n == 0 then
      0
    else if n == 1 then
      1
    else
      n * factorial(n-1)
  }

  method GeneratePermutations<T>(source : seq<T>) returns (result : seq<seq<T>>)
    ensures forall x <- result :: multiset(source) == multiset(x)
    ensures |result| == factorial(|source|)
    ensures forall x <- result :: (forall e <- x :: e in source)
  {
    if |source| == 0 {
      return [];
    }
    if |source| == 1 {
      return [source];
    }
    var A := new T[|source|](i requires 0 <= i < |source| => source[i]);
    assert A[..] == source;
    result := Permute(A.Length, A, source);
  }

  method Swap<T>(A : array<T>, x : nat, y : nat)
    requires 0 <= x < A.Length
    requires 0 <= y < A.Length
    modifies A
    ensures multiset(A[..]) == multiset(old(A[..]))
    ensures forall e <- A[..] :: e in old(A[..])
    ensures A[x] == old(A[y])
    ensures A[y] == old(A[x])
  {
    var tmp := A[x];
    A[x] := A[y];
    A[y] := tmp;
  }

  // https://en.wikipedia.org/wiki/Heap%27s_algorithm
  // Each step generates the k! permutations that end with the same n-k final elements
  method Permute<T>(k : nat, A : array<T>, ghost source : seq<T>) returns (result : seq<seq<T>>)
    requires 0 < k <= A.Length
    modifies A
    requires forall x <- A[..] :: x in source
    requires multiset(source) == multiset(A[..])
    ensures multiset(source) == multiset(A[..])
    ensures forall x <- result :: multiset(source) == multiset(x)
    ensures forall x <- result :: (forall e <- x :: e in source)
    ensures |result| == factorial(k)
    ensures forall x <- A[..] :: x in source
  {
    if k == 1 {
      assert forall x <- A[..] :: x in source;
      return [A[..]];
    } else {
      var result : seq<seq<T>> := [];
      for i := 0 to k
        invariant forall x <- result :: multiset(source) == multiset(x)
        invariant multiset(old(A[..])) == multiset(A[..])
        invariant multiset(source) == multiset(A[..])
        invariant forall x <- result :: multiset(A[..]) == multiset(x)
        invariant |result| == factorial(k-1) * i
        invariant forall x <- result :: (forall e <- x :: e in source)
        invariant forall x <- A[..] :: x in source
      {
        var next := Permute(k - 1, A, source);
        result := result + next;
        if (k % 2) == 0 {
          Swap(A, i, k-1);
        } else {
          Swap(A, 0, k-1);
        }
      }
      return result;
    }
  }

  method {:test} BasicTests() {
    var zero := GeneratePermutations<int>([]);
    var one := GeneratePermutations([1]);
    var two := GeneratePermutations([1,2]);
    var three := GeneratePermutations([1,2,3]);
    var four := GeneratePermutations([1,2,3,4]);
    expect zero == [];
    expect one == [[1]];
    expect two == [[1,2],[2,1]];
    expect |two| == |multiset(two)|;
    expect |three| == |multiset(three)|;
    expect |four| == |multiset(four)|;
    expect three == [[1, 2, 3], [2, 1, 3], [3, 1, 2], [1, 3, 2], [2, 3, 1], [3, 2, 1]];
    expect four == [
      [1, 2, 3, 4], [2, 1, 3, 4], [3, 1, 2, 4], [1, 3, 2, 4], [2, 3, 1, 4], [3, 2, 1, 4],
      [4, 2, 3, 1], [2, 4, 3, 1], [3, 4, 2, 1], [4, 3, 2, 1], [2, 3, 4, 1], [3, 2, 4, 1],
      [4, 1, 3, 2], [1, 4, 3, 2], [3, 4, 1, 2], [4, 3, 1, 2], [1, 3, 4, 2], [3, 1, 4, 2],
      [4, 1, 2, 3], [1, 4, 2, 3], [2, 4, 1, 3], [4, 2, 1, 3], [1, 2, 4, 3], [2, 1, 4, 3]
    ];
  }
}

