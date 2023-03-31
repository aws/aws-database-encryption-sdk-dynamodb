// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/Index.dfy"
include "../src/SearchInfo.dfy"

module BeaconTestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import DDB = ComAmazonawsDynamodbTypes
  import SI =  SearchableEncryptionInfo

  const std2 := StandardBeacon(name := "std2", length := 2, loc := None)
  const std4 := StandardBeacon(name := "std4", length := 4, loc := Some("std4"))
  const std6 := StandardBeacon(name := "std6", length := 6, loc := Some("std6[0]"))

  const Year := NonSensitivePart(name := "Year", prefix := "Y_", loc := None)
  const Month := NonSensitivePart(name := "Month", prefix := "M_", loc := Some("Date.Month"))
  const Nothing := NonSensitivePart(name := "Nothing", prefix := "N__", loc := None)

  const Name := SensitivePart(name := "Name", prefix := "N_", length := 4, loc := None)
  const Title := SensitivePart(name := "Title", prefix := "T_", length := 4, loc := None)
  const TooBad := SensitivePart(name := "TooBad", prefix := "T", length := 4, loc := None)

  const NameTitle := CompoundBeacon (
    name := "NameTitle",
    split := ".",
    sensitive := [Name,Title],
    nonSensitive := None,
    constructors := None
  )
  const YearName := CompoundBeacon (
    name := "NameTitle",
    split := ".",
    sensitive := [Name],
    nonSensitive := Some([Year]),
    constructors := None
  )
  const BadPrefix := CompoundBeacon (
    name := "BadPrefix",
    split := ".",
    sensitive := [Name,Title,TooBad],
    nonSensitive := None,
    constructors := None
  )
  const BadPrefix2 := CompoundBeacon (
    name := "BadPrefix",
    split := ".",
    sensitive := [Name],
    nonSensitive := Some([Nothing]),
    constructors := None
  )
  const Mixed := CompoundBeacon (
    name := "Mixed",
    split := ".",
    sensitive := [Name,Title],
    nonSensitive := Some([Year,Month]),
    constructors := Some([
      Constructor(parts := [ConstructorPart(name := "Name", required := true), ConstructorPart(name := "Year", required := true)]),
      Constructor(parts := [ConstructorPart(name := "Title", required := true), ConstructorPart(name := "Month", required := false)])
    ])
  )

  const Std2String := DDB.AttributeValue.N("222")
  const Std4String := DDB.AttributeValue.S("444")
  const Std6String := DDB.AttributeValue.S("666")
  const Std6List := DDB.AttributeValue.L([Std6String])

  const YearString := DDB.AttributeValue.S("1984")
  const MonthString := DDB.AttributeValue.S("May")
  const DateMap := DDB.AttributeValue.M(map["Month" := MonthString])

  const NameString := DDB.AttributeValue.S("1984")
  const TitleString := DDB.AttributeValue.S("1984")

  const EmptyBeacons := SI.BeaconVersion (
    version := 1,
    beacons := map[],
    virtualFields := map[]
  )

  const SimpleItem : DDB.AttributeMap := map[
    "std2" := Std2String,
    "std4" := Std2String,
    "std6" := Std6List,
    "Date" := DateMap,
    "Year" := YearString,
    "Name" := NameString,
    "Title" := TitleString
  ]
}
