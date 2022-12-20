// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/StandardLibrary.dfy"
include "../src/Index.dfy"

module DdbStatementTest {
  import opened Wrappers
  import opened DdbStatement

  method ExpectEqual<X(==)>(actual : X, expected : X)
  {
    if actual != expected {
      print "\nactual\n", actual;
      print "\nexpected\n", expected, "\n";
    }
    expect actual == expected;
  }

  method {:test} TestTableFromStatement() {
    ExpectEqual(TableFromStatement(""), Failure("Unable to extract table name from PartiQL statement."));
    ExpectEqual(TableFromStatement("select blah blah from f where"), Failure("Unable to extract table name from PartiQL statement."));
    ExpectEqual(TableFromStatement("select blah blah from foo where"), Success("foo"));
    ExpectEqual(TableFromStatement("select\nblah\nblah\n\t  from\t\n  \t\n  foo where"), Success("foo"));

// The following examples copied from
// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.statements.html
    ExpectEqual(TableFromStatement("UPDATE \"Music\" SET AwardsWon=1 SET AwardDetail={'Grammys':[2020, 2018]}  WHERE Artist='Acme Band' AND SongTitle='PartiQL Rocks"), Success("Music"));
    ExpectEqual(TableFromStatement(
@"SELECT OrderID, Total
FROM ""Orders""
WHERE OrderID IN [1, 2, 3] ORDER BY OrderID DESC"), Success("Orders"));
    ExpectEqual(TableFromStatement(
@"SELECT Devices.FireStick.DateWatched[0] 
FROM WatchList 
WHERE CustomerID= 'C1' AND MovieID= 'M1'"), Success("WatchList"));
    ExpectEqual(TableFromStatement(
@"SELECT * 
FROM ""Orders"" 
WHERE OrderID IN [100, 300, 234]"), Success("Orders"));
    ExpectEqual(TableFromStatement(
@"UPDATE ""Music"" 
SET AwardsWon=1 
SET AwardDetail={'Grammys':[2020, 2018]}  
WHERE Artist='Acme Band' AND SongTitle='PartiQL Rocks'
RETURNING ALL OLD *"), Success("Music"));
    ExpectEqual(TableFromStatement(
@"DELETE FROM ""Music"" WHERE ""Artist"" = 'Acme Band' AND ""SongTitle"" = 'PartiQL Rocks' RETURNING ALL OLD *
"), Success("Music"));
    ExpectEqual(TableFromStatement(
@"INSERT INTO ""Music"" value {'Artist' : 'Acme Band','SongTitle' : 'PartiQL Rocks'}
"), Success("Music"));    ExpectEqual(TableFromStatement(
@"INSERT INTO ""Mu s ic"" value {'Artist' : 'Acme Band','SongTitle' : 'PartiQL Rocks'}
"), Success("Mu s ic"));
  }
}