// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "BeaconTestFixtures.dfy"

module TestBaseBeacon {
  import T = AwsCryptographyDynamoDbEncryptionTypes
  import opened BaseBeacon
  import opened CompoundBeacon
  import opened Wrappers
  import opened TermLoc
  import opened BeaconTestFixtures
  import opened DynamoDbEncryptionUtil
  import opened DynamoDBFilterExpr
  import C = SearchConfigToInfo
  import I = SearchableEncryptionInfo
  import SI = SearchableEncryptionInfo
  import DDB = ComAmazonawsDynamodbTypes

  method {:test} TestBeacon() {
    var primitives :- expect Primitives.AtomicPrimitives();

    var bb := BeaconBase(client := primitives, name := "foo", beaconName := "aws_dbe_b_foo");
    var b := StandardBeacon(bb, 8, TermLocMap("foo"));
    var bytes :- expect bb.getHmac([1,2,3], key := [1,2]);
    expect bytes == [0x27, 0x93, 0x93, 0x8b, 0x26, 0xe9, 0x52, 0x7e];
    var str :- expect b.hash([1,2,3], key := [1,2]);
    expect str == "7e";
    bytes :- expect bb.getHmac([], key := [1,2]);
    expect bytes[7] == 0x80;
    str :- expect b.hash([], key := [1,2]);
    expect str == "80";
    bytes :- expect bb.getHmac(UTF8.EncodeAscii("123"), key := [1,2]);
    expect bytes[7] == 0x61;
  }

  method {:test} TestBadPrefix() {
    var store := GetKeyStore();
    var version := T.BeaconVersion (
      version := 1,
      keyStore := store,
      keySource := T.single(T.SingleKeyStore(keyId := "foo", cacheTTL := 42)),
      standardBeacons := [NameB, TitleB, TooBadB],
      compoundBeacons := Some([BadPrefix]),
      virtualFields := None
    );
    var src := GetLiteralSource([1,2,3,4,5], version);
    var res := C.ConvertVersionWithSource(FullTableConfig, version, src);

    expect res.Failure?;
    expect_equal(res.error, E("Compound beacon BadPrefix defines part Title with prefix T_ which is incompatible with part TooBad which has a prefix of T."));
  }


  method {:test} TestContainsSplit()
  {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    var badItem := SimpleItem["Name" := DDB.AttributeValue.S("A.B")];
    var badAttrs := bv.GenerateEncryptedBeacons(badItem, DontUseKeyId);
    expect badAttrs.Failure?;
    expect_equal(badAttrs.error, E("Part Name for beacon Mixed has value 'A.B' which contains the split character .'."));
  }

  method {:test} TestNumbersNormalize()
  {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var goodAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    assert "std2" in SimpleItem;
    assert SimpleItem["std2"] == Std2String;
    assert Std2String == DDB.AttributeValue.N("1.23");
    expect "aws_dbe_b_std2" in goodAttrs;
    // b1eb7a is the beaconization of "1.23" for beacon "std2"
    expect goodAttrs["aws_dbe_b_std2"] == DDB.AttributeValue.S("ac6f5d");
    var newItem := SimpleItem["std2" := DDB.AttributeValue.N("000001.23000000")];
    var newAttrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect "aws_dbe_b_std2" in newAttrs;
    expect goodAttrs["aws_dbe_b_std2"] == newAttrs["aws_dbe_b_std2"];
  }

  method {:test} TestBeaconValues()
  {
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var bv :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var attrs :- expect bv.GenerateSignedBeacons(SimpleItem);
    expect attrs == map["JustSigned" := DDB.AttributeValue.S("Y_1984.M_May")];
    attrs :- expect bv.GenerateEncryptedBeacons(SimpleItem, DontUseKeyId);
    expect attrs == map[
                      "aws_dbe_b_Mixed" := DDB.AttributeValue.S("N_7d9bfa40.Y_1984"),
                      "aws_dbe_b_Name" := DDB.AttributeValue.S("7d9bfa40"),
                      //= specification/searchable-encryption/beacons.md#getpart-for-a-compound-beacon
                      //= type=test
                      //# * The value returned MUST be these part values, joined with the `split character`.

                      //= specification/searchable-encryption/beacons.md#value-for-a-compound-beacon
                      //= type=test
                      //# * For that constructor, hash MUST join the [part value](#part-value) for each part
                      //# on the `split character`,
                      //# excluding parts that are not required and with a source field that is not available.
                      "aws_dbe_b_NameTitle" := DDB.AttributeValue.S("N_7d9bfa40.T_e4feb833"),
                      "aws_dbe_b_NameTitleField" := DDB.AttributeValue.S("4c577d7"),
                      "aws_dbe_b_std2" := DDB.AttributeValue.S("ac6f5d"),
                      "aws_dbe_b_Title" := DDB.AttributeValue.S("e4feb833"),
                      "aws_dbe_b_std6" := DDB.AttributeValue.S("2d99222"),
                      "aws_dbe_b_std4" := DDB.AttributeValue.S("0e9064"),
                      "aws_dbe_b_YearName" := DDB.AttributeValue.S("Y_1984.N_7d9bfa40")
                    ];
  }

  method {:test} TestOneBeaconValue()
  {
    var info :- expect UTF8.Encode("AWS_DBE_SCAN_BEACONstd2");
    var client :- expect Primitives.AtomicPrimitives();

    var key :- expect client.Hkdf(Prim.HkdfInput(
                                    digestAlgorithm := Prim.SHA_512,
                                    salt := None,
                                    ikm := [1,2,3,4,5],
                                    info := info,
                                    expectedLength := 64
                                  ));

    var data :- expect UTF8.Encode("1.23");
    var input := Prim.HMacInput (
      digestAlgorithm := Prim.SHA_384,
      key := key,
      message := data
    );
    var hmac48 :- expect client.HMac(input);
    var hmac8 := hmac48[..8];
    var beacon := BytesToHex(hmac8, 24);
    expect beacon == "ac6f5d";
  }

  method {:test} TestQueryBeacons() {
    var context := ExprContext (
      expr := Some("std2 = :std2 AND std4 = :std4 AND :std6 = std6 AND Name = :Name AND Mixed = :Mixed"
                   + " AND :NameTitle = NameTitle AND NameTitle = :NameTitleN AND NameTitle = :NameTitleT AND NameTitle = :NameTitleTN"
                   + " AND NameTitleField = :NameTitleField And Title = :Title AND YearName = :YearName"),
      values:= Some(map[
                      ":std2" := Std2String,
                      ":std4" := Std4String,
                      ":std6" := Std6String,
                      ":Name" := NameString,
                      ":Title" := TitleString,
                      ":Mixed" := DDB.AttributeValue.S("N_MyName.Y_1984"),
                      ":NameTitle" := DDB.AttributeValue.S("N_MyName.T_MyTitle"),
                      ":NameTitleN" := DDB.AttributeValue.S("N_MyName"),
                      ":NameTitleT" := DDB.AttributeValue.S("T_MyTitle"),
                      ":NameTitleTN" := DDB.AttributeValue.S("T_MyTitle.N_MyName"),
                      ":NameTitleField" := DDB.AttributeValue.S("MyName__mytitle"),
                      ":YearName" := DDB.AttributeValue.S("Y_1984.N_MyName")
                    ]),
      names := None
    );
    var version := GetLotsaBeacons();
    var src := GetLiteralSource([1,2,3,4,5], version);
    var beaconVersion :- expect C.ConvertVersionWithSource(FullTableConfig, version, src);
    var newContext :- expect Beaconize(beaconVersion, context, DontUseKeyId);
    expect newContext.values == Some(map[
                                       ":Mixed" := DDB.AttributeValue.S("N_7d9bfa40.Y_1984"),
                                       ":Name" := DDB.AttributeValue.S("7d9bfa40"),
                                       ":NameTitle" := DDB.AttributeValue.S("N_7d9bfa40.T_e4feb833"),
                                       ":NameTitleTN" := DDB.AttributeValue.S("T_e4feb833.N_7d9bfa40"),
                                       ":NameTitleN" := DDB.AttributeValue.S("N_7d9bfa40"),
                                       ":NameTitleT" := DDB.AttributeValue.S("T_e4feb833"),
                                       ":NameTitleField" := DDB.AttributeValue.S("4c577d7"),
                                       ":std2" := DDB.AttributeValue.S("ac6f5d"),
                                       ":Title" := DDB.AttributeValue.S("e4feb833"),
                                       ":std6" := DDB.AttributeValue.S("2d99222"),
                                       ":std4" := DDB.AttributeValue.S("0e9064"),
                                       ":YearName" := DDB.AttributeValue.S("Y_1984.N_7d9bfa40")
                                     ]);
    expect newContext.names == None;
    //expect_equal(newContext.expr, Some("aws_dbe_b_std2 <> :A AND #Field4 = :B"));
  }
}
