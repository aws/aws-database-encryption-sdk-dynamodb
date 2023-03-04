include "../src/Beacon.dfy"

module TestBaseBeacon {
  import opened BaseBeacon
  import opened Wrappers

  method TestFail(b : Beacon, s : string)
  {
    var str := b.compoundHash(s);
    if !str.Failure? {
      print "Expected failure, got " + str.value + ", from ", s, "\n";
    }
    expect str.Failure?;
  }

  method TestCompound(b : Beacon, s : string, exp : string)
  {
    var str := b.compoundHash(s);
    if !str.Success? {
      print "Expected Success, got failure, from ", s, "\n", str, "\n";
    }

    expect str.Success?;

    if (str.value != exp) {
      print "Expected ", exp, " got ", str.value, " from ", s, "\n";
    }
    expect str.value == exp;
  }

  method {:test} TestBeacon() {
    var b := Beacon(name := "foo", key := [1,2], length := 8, test := 1);
    var str :- expect b.standardHash([1,2,3]);
    expect str == "03";
    str :- expect b.standardHash([]);
    expect str == "00";
    TestCompound(b, "123", "03");
    TestCompound(b, "", "00");

    b := Beacon(name := "foo", key := [1,2], length := 4, test := 1, prefix := Some('-'));
    TestCompound(b, "stuff-junk", "stuff-4");
    TestCompound(b, "stuff-junk-foo", "stuff-8");
    TestCompound(b, "-junk", "-4");
    TestCompound(b, "_-junk", "_-4");
    TestCompound(b, "stuff-_", "stuff-1");
    TestCompound(b, "-", "-0");
    TestFail(b, "stuff");

    b := b.(ignore := Some('_'));
    TestCompound(b, "stuff-junk", "stuff-4");
    TestCompound(b, "stuff-junk-foo", "stuff-8");
    TestCompound(b, "-junk", "-4");
    TestCompound(b, "_-junk", "4");
    TestCompound(b, "stuff-_", "stuff-");
    TestCompound(b, "-", "-0");
    TestFail(b, "stuff");
    TestFail(b, "_-");
    TestFail(b, "_-_");
    TestFail(b, "-_");

    var split := SplitRec(split := '.');
    b := b.(split := Some(split), prefix := None);
    TestCompound(b, "stuff", ".5.");
    TestCompound(b, "stuff.junk", ".5.4.");
    TestCompound(b, "stuff.junk.eponymous", ".5.4.9.");
    //= specification/structured-encryption/beacons.md#splithash
    //= type=test
    //# * splitHash MUST calculate the concatenation of,
    //# for each part that is not the [ignore](#ignore-character) character,
    //# the split character followed by the [innerHash](#innerHash) of the part and its position.
    TestCompound(b, "_.junk.eponymous", ".4.9.");
    TestCompound(b, "stuff.junk._", ".5.4.");
    TestFail(b, "stuff._.eponymous");

    split := split.(inner := Some(':'));
    b := b.(split := Some(split));
    TestCompound(b, "A:stuff", ".A:5.");
    TestCompound(b, "A:stuff.BB:junk", ".A:5.BB:4.");
    TestCompound(b, "A:stuff.BB:junk.CCC:eponymous", ".A:5.BB:4.CCC:9.");
    TestCompound(b, "_.BB:junk.CCC:eponymous", ".BB:4.CCC:9.");
    TestCompound(b, "A:stuff.BB:junk._", ".A:5.BB:4.");
    TestFail(b, "A:stuff._.BB:eponymous");

    split := split.(inner := None, splitLens := [1,2,3]);
    b := b.(split := Some(split), length := 1);

    expect b.hashLength(3) == 3;
    expect b.hashLength(2) == 3;
    expect b.hashLength(1) == 2;
    expect b.hashLength(0) == 1;

    TestCompound(b, "abluted", ".1.");
    TestCompound(b, "abluted.abluted", ".1.3.");
    TestCompound(b, "abluted.abluted.abluted", ".1.3.7.");
    TestCompound(b, "abluted.abluted.abluted.abluted", ".1.3.7.7.");
    TestCompound(b, "abluted.abluted.abluted.abluted.abluted", ".1.3.7.7.7.");
    TestCompound(b, "_.abluted.abluted", ".3.7.");
    TestFail(b, "abluted._.abluted");
    TestCompound(b, "abluted.abluted._", ".1.3.");
    TestCompound(b, "abluted._._", ".1.");
    TestCompound(b, "_.abluted._", ".3.");
    TestCompound(b, "_._.abluted", ".7.");
    TestFail(b, "_._._");

    split := split.(failIfShort := true, failIfLong := true);
    b := b.(split := Some(split));
    TestFail(b, "abluted");
    TestFail(b, "abluted.abluted");
    TestCompound(b, "abluted.abluted.abluted", ".1.3.7.");
    TestFail(b, "abluted.abluted.abluted.abluted");
    TestFail(b, "abluted.abluted.abluted.abluted.abluted");

    TestCompound(b, "abluted.abluted.abluted", ".1.3.7.");
    TestCompound(b, "_.abluted.abluted", ".3.7.");
    TestFail(b, "abluted._.abluted");
    TestCompound(b, "abluted.abluted._", ".1.3.");
    TestCompound(b, "abluted._._", ".1.");
    TestCompound(b, "_.abluted._", ".3.");
    TestCompound(b, "_._.abluted", ".7.");
    TestFail(b, "_._._");

    split := split.(failIfShort := false, failIfLong := true);
    b := b.(split := Some(split));
    TestCompound(b, "abluted", ".1.");
    TestCompound(b, "abluted.abluted", ".1.3.");
    TestCompound(b, "abluted.abluted.abluted", ".1.3.7.");
    TestFail(b, "abluted.abluted.abluted.abluted");
    TestFail(b, "abluted.abluted.abluted.abluted.abluted");

    TestCompound(b, "abluted.abluted.abluted", ".1.3.7.");
    TestCompound(b, "_.abluted.abluted", ".3.7.");
    TestFail(b, "abluted._.abluted");
    TestCompound(b, "abluted.abluted._", ".1.3.");
    TestCompound(b, "abluted._._", ".1.");
    TestCompound(b, "_.abluted._", ".3.");
    TestCompound(b, "_._.abluted", ".7.");
    TestFail(b, "_._._");

    split := split.(failIfShort := true, failIfLong := false);
    b := b.(split := Some(split));
    TestFail(b, "abluted");
    TestFail(b, "abluted.abluted");
    TestCompound(b, "abluted.abluted.abluted", ".1.3.7.");
    TestCompound(b, "abluted.abluted.abluted.abluted", ".1.3.7.7.");
    TestCompound(b, "abluted.abluted.abluted.abluted.abluted", ".1.3.7.7.7.");

    TestCompound(b, "abluted.abluted.abluted", ".1.3.7.");
    TestCompound(b, "_.abluted.abluted", ".3.7.");
    TestFail(b, "abluted._.abluted");
    TestCompound(b, "abluted.abluted._", ".1.3.");
    TestCompound(b, "abluted._._", ".1.");
    TestCompound(b, "_.abluted._", ".3.");
    TestCompound(b, "_._.abluted", ".7.");
    TestFail(b, "_._._");
  }

}