// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../../../submodules/MaterialProviders/libraries/src/Wrappers.dfy"

module {:options "-functionSyntax:4"} Permutations {
  import opened Wrappers

  method GeneratePermutations<T>(source : seq<T>) returns (result : seq<seq<T>>)
  {
    if |source| == 0 {
      return [];
    }
    if |source| == 1 {
      return [source];
    }
    var A := new T[|source|](i requires 0 <= i < |source| => source[i]);
    result := Permute(A.Length, A);
  }

  method Swap<T>(A : array<T>, x : nat, y : nat)
    requires 0 <= x < A.Length
    requires 0 <= y < A.Length
    modifies A
  {
    var tmp := A[x];
    A[x] := A[y];
    A[y] := tmp;
  }

  // https://en.wikipedia.org/wiki/Heap%27s_algorithm
  // Each step generates the k! permutations that end with the same n-k final elements
  method Permute<T>(k : nat, A : array<T>) returns (result : seq<seq<T>>)
    requires 0 < k <= A.Length
    modifies A
  {
    if k == 1 {
      return [A[..]];
    } else {
      var result : seq<seq<T>> := [];
      for i := 0 to k {
        var next := Permute(k - 1, A);
        result := result + next;
        if (k % 1) == 0 {
          Swap(A, i, k-1);
        } else {
          Swap(A, 0, k-1);
        }
      }
      return result;
    }
  }
/*
  method {:test} BasicTests() {
    var zero := GeneratePermutations<int>([]);
    var one := GeneratePermutations([1]);
    var two := GeneratePermutations([1,2]);
    var three := GeneratePermutations([1,2,3]);
    var four := GeneratePermutations([1,2,3,4]);
    expect zero == [];
    expect one == [[1]];
    expect two == [[1,2],[2,1]];
    expect three == [[1, 2, 3], [2, 1, 3], [3, 1, 2], [1, 3, 2], [1, 2, 3], [2, 1, 3]];
    expect four == [
                     [1, 2, 3, 4], [2, 1, 3, 4], [3, 1, 2, 4], [1, 3, 2, 4], [1, 2, 3, 4], [2, 1, 3, 4],
                     [4, 1, 3, 2], [1, 4, 3, 2], [3, 4, 1, 2], [4, 3, 1, 2], [4, 1, 3, 2], [1, 4, 3, 2],
                     [1, 2, 3, 4], [2, 1, 3, 4], [3, 1, 2, 4], [1, 3, 2, 4], [1, 2, 3, 4], [2, 1, 3, 4],
                     [2, 1, 4, 3], [1, 2, 4, 3], [4, 2, 1, 3], [2, 4, 1, 3], [2, 1, 4, 3], [1, 2, 4, 3]
                   ];
  }
*/
}

