// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

module {:options "-functionSyntax:4"} CounterClass {
  function Multiply(xs: seq<nat>): nat
  {
    if |xs| == 0 then 1
    else xs[0] * Multiply(xs[1..])
  }

  class Counter {
    var sizes : seq<nat>
    var curr : array<nat>
    var remaining : nat

    predicate Valid()
      reads this, this.curr
    {
      && 0 < |sizes|
      && |sizes| == curr.Length
      && (forall i | 0 <= i < |sizes| :: 0 < sizes[i])
      && (forall i | 0 <= i < |sizes| :: curr[i] < sizes[i])
    }

    constructor(s : seq<nat>)
      requires 0 < |s|
      requires forall i | 0 <= i < |s| :: 0 < s[i]
      ensures |sizes| == |s|
      ensures Valid()
      ensures fresh(curr)
      ensures remaining == Multiply(s)
    {
      sizes := s;
      curr := new nat[|s|](i => 0);
      remaining := 0;
      new;
      remaining := Multiply(s);
    }

    function at(pos : nat) : nat
      requires pos < |sizes|
      requires Valid()
      ensures Valid()
      reads this, this.curr
      ensures at(pos) < this.sizes[pos]
    {
      this.curr[pos]
    }

    method next() returns (output : nat)
      requires Valid()
      ensures Valid()
      modifies this`remaining, this.curr
      ensures this.curr == old(this.curr)
      ensures 0 <= output <= |sizes|
      ensures sizes == old(sizes)
      ensures output != 0 ==> (forall i | output < i < |sizes| :: curr[i] == old(curr[i]))
      requires 0 < remaining
      ensures remaining == old(remaining) - 1
    {
      remaining := remaining - 1;
      if remaining == 0 {
        return 0;
      }
      for i := 0 to |sizes|
        invariant Valid()
        invariant forall j | i < j < |sizes| :: curr[j] == old(curr[j])
        invariant remaining == old(remaining) - 1
      {
        if (curr[i]+1) < sizes[i] {
          curr[i] := curr[i] + 1;
          return i+1;
        } else {
          curr[i] := 0;
        }
      }
      return 0;
    }
  }

  method {:test} TestCounter111() {
    var c := new Counter([1,1,1]);
    expect c.at(0) == 0;
    expect c.at(1) == 0;
    expect c.at(2) == 0;
    var n := c.next();
    expect n == 0;
  }

  method {:test} TestCounter23() {
    var c := new Counter([2,3]);
    expect c.at(0) == 0;
    expect c.at(1) == 0;

    var n := c.next();
    expect n == 1;
    expect c.at(0) == 1;
    expect c.at(1) == 0;

    n := c.next();
    expect n == 2;
    expect c.at(0) == 0;
    expect c.at(1) == 1;

    n := c.next();
    expect n == 1;
    expect c.at(0) == 1;
    expect c.at(1) == 1;

    n := c.next();
    expect n == 2;
    expect c.at(0) == 0;
    expect c.at(1) == 2;

    n := c.next();
    expect n == 1;
    expect c.at(0) == 1;
    expect c.at(1) == 2;

    n := c.next();
    expect n == 0;
  }
}
