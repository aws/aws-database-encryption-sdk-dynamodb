// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/JsonPath.dfy"

module JsonPathTest {
  import opened JsonPathMod

    method {:test} TestRoundTrips() {
      var jp :- expect Parse("$.a.b.c");
      expect jp == JsonPathBase(path := ["a", "b", "c"]);
      expect PrettyString(jp) == "$.a.b.c";
      expect StandardString(jp) == "$.['a'].['b'].['c']";

      jp :- expect Parse("$.['a'].['bb'].['ccc']");
      expect jp == JsonPathBase(path := ["a", "bb", "ccc"]);
      print "\n", PrettyString(jp), "\n";
      print "\n", StandardString(jp), "\n";
      expect PrettyString(jp) == "$.a.bb.ccc";
      expect StandardString(jp) == "$.['a'].['bb'].['ccc']";

      jp :- expect Parse("abc");
      expect jp == JsonPathBase(path := ["abc"]);
      expect PrettyString(jp) == "abc";
      expect StandardString(jp) == "$.['abc']";

      jp :- expect Parse("$.[\"'\"].['bb'].[\"ccc\"]");
      expect jp == JsonPathBase(path := ["'", "bb", "ccc"]);
      expect PrettyString(jp) == "$.['\\\''].bb.ccc";
      expect StandardString(jp) == "$.['\\\''].['bb'].['ccc']";

      jp :- expect Parse("$.['a'].['b\\\\b'].['\\\'\\\\\\\''].[\"\\\"\"]");
      expect jp == JsonPathBase(path := ["a", "b\\b", "'\\'", "\""]);
      print "\n", PrettyString(jp), "\n";
      print "\n", StandardString(jp), "\n";
      expect PrettyString(jp) == "$.a.['b\\\\b'].['\\\'\\\\\\\''].['\"']";
      expect StandardString(jp) == "$.['a'].['b\\\\b'].['\\\'\\\\\\\''].['\"']";

    }

}
