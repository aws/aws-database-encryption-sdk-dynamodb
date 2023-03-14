// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/Virtual.dfy"

module VirtualFieldsTests {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths
  import opened VirtualFields

  method CheckValueParse(actual : Result<VirtualField, string>, expected : Result<VirtualField, string>, valid : bool)
  {
    if actual != expected {
      print "\nactual\n", actual, "\nexpected\n", expected, "\n";
    }
    expect actual == expected;
    if actual.Success? {
      if ValidVirtualField(actual.value) != valid {
        print "ValidVirtualField of ", actual.value, " should have been ", valid, " but was ", !valid, "\n";
      }
      //expect ValidVirtualField(actual.value) == valid;
    }
  }

  method {:test} TestGetValue() {
    CheckValueParse(VirtualFields.GetVirtualField("name", ""), Failure("Virtual value spec must not be empty."), false);
    var attr :- expect MakeMap("attr");
    var attrTerm := TerminalLocation([attr]);
    var attrCalc := Calc(attrTerm, []);
    var other :- expect MakeMap("other");
    var otherTerm := TerminalLocation([other]);
    var otherCalc := Calc(otherTerm, []);
    CheckValueParse(VirtualFields.GetVirtualField("name", "attr"), Success(VirtualField("name", [attrCalc])), false);
    CheckValueParse(VirtualFields.GetVirtualField("name", "attr + attr"), Success(VirtualField("name", [attrCalc, attrCalc])), false);
    CheckValueParse(VirtualFields.GetVirtualField("name", "attr + other"), Success(VirtualField("name", [attrCalc, otherCalc])), true);
  }
}
