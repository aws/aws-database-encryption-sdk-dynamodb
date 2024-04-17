// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../../../submodules/MaterialProviders/StandardLibrary/src/StandardLibrary.dfy"
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

  function method NoTable<X>()
    : Result<X, string>
  {
    Failure("Unable to extract table name from PartiQL statement.")
  }
  method {:test} TestEmptyStatement() {
    ExpectEqual(TableFromStatement(""), NoTable());
  }

  method {:test} TestInvalidStatement() {
    ExpectEqual(TableFromStatement("stuff junk"), NoTable());
  }

  method {:test} TestStatementInvalidTable() {
    ExpectEqual(TableFromStatement("select blah blah from f where"), NoTable());
  }

  method {:test} TestSelectStatementCase() {
    ExpectEqual(TableFromStatement("SeLeCt blah blah FrOm foo where"), Success("foo"));
  }

  method {:test} TestInvalidStatements() {
    ExpectEqual(TableFromStatement("select"), NoTable());
    ExpectEqual(TableFromStatement("select blah blah blah"), NoTable());
    ExpectEqual(TableFromStatement("select blah blah from"), NoTable());

    ExpectEqual(TableFromStatement("insert"), NoTable());
    ExpectEqual(TableFromStatement("insert blah blah blah"), NoTable());
    ExpectEqual(TableFromStatement("insert into"), NoTable());
    ExpectEqual(TableFromStatement("insert !into blah"), NoTable());

    ExpectEqual(TableFromStatement("delete"), NoTable());
    ExpectEqual(TableFromStatement("delete blah blah blah"), NoTable());
    ExpectEqual(TableFromStatement("delete from"), NoTable());
    ExpectEqual(TableFromStatement("delete !from blah"), NoTable());

    ExpectEqual(TableFromStatement("update"), NoTable());
    ExpectEqual(TableFromStatement("  update        "), NoTable());
    ExpectEqual(TableFromStatement("update b"), NoTable());
  }

  method {:test} TestTableQuotes() {
    ExpectEqual(TableFromStatement("select * from foo"), Success("foo"));
    ExpectEqual(TableFromStatement("select * from \"foo\""), Success("foo"));
    ExpectEqual(TableFromStatement("select * from \"f o o\""), Success("f o o"));

    ExpectEqual(TableFromStatement("insert into foo"), Success("foo"));
    ExpectEqual(TableFromStatement("insert into \"foo\""), Success("foo"));
    ExpectEqual(TableFromStatement("insert into \" foo \""), Success(" foo "));

    ExpectEqual(TableFromStatement("delete from foo"), Success("foo"));
    ExpectEqual(TableFromStatement("delete from \"foo\""), Success("foo"));
    ExpectEqual(TableFromStatement("delete from \"   fo   o\""), Success("   fo   o"));

    ExpectEqual(TableFromStatement("update foo"), Success("foo"));
    ExpectEqual(TableFromStatement("update \"foo\""), Success("foo"));
    ExpectEqual(TableFromStatement("update \"f\to\no\""), Success("f\to\no"));
  }

  method {:test} TestExistsStatement() {
    ExpectEqual(TableFromStatement("exists(select * from foo"), Success("foo"));
    ExpectEqual(TableFromStatement("\t  ExIsTs \r(\t\n SeLeCt * from foo"), Success("foo"));
    ExpectEqual(TableFromStatement("exists(select * from \"foo\""), Success("foo"));
    ExpectEqual(TableFromStatement("exists(select * from \"foo.bar\""), Success("foo"));
  }

  method {:test} TestExistsStatementErrors() {
    ExpectEqual(TableFromStatement("exists"), NoTable());
    ExpectEqual(TableFromStatement("exists()"), NoTable());
    ExpectEqual(TableFromStatement("exists select blah"), NoTable());
    ExpectEqual(TableFromStatement("exists(select)"), NoTable());
    ExpectEqual(TableFromStatement("exists(select * )"), NoTable());
    ExpectEqual(TableFromStatement("exists(select * from)"), NoTable());
    ExpectEqual(TableFromStatement("exists(update blah)"), NoTable());
    ExpectEqual(TableFromStatement("exists(delete from blah)"), NoTable());
    ExpectEqual(TableFromStatement("exists(insert into blah)"), NoTable());
  }

  method {:test} TestSelectStatement() {
    ExpectEqual(TableFromStatement("select blah blah from foo where"), Success("foo"));
    ExpectEqual(TableFromStatement("select\nblah\nblah\n\t  from\t\n  \t\n  foo where"), Success("foo"));
  }

  method {:test} TestSelectStatementWithIndex() {
    ExpectEqual(TableFromStatement("select * from foo.bar where"), Success("foo"));
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.update.html
  method {:test} TestUpdateFromDocs() {
    ExpectEqual(TableFromStatement("UPDATE \"Music\" SET AwardsWon=1 SET AwardDetail={'Grammys':[2020, 2018]}  WHERE Artist='Acme Band' AND SongTitle='PartiQL Rocks"), Success("Music"));

    ExpectEqual(TableFromStatement(
                  @"UPDATE ""Music""
SET AwardsWon=1
SET AwardDetail={'Grammys':[2020, 2018]}
WHERE Artist='Acme Band' AND SongTitle='PartiQL Rocks'
RETURNING ALL OLD *"), Success("Music"));
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.select.html
  method {:test} TestSelectFromDocs() {
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
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.delete.html
  method {:test} TestDeleteFromDocs() {
    ExpectEqual(TableFromStatement(
                  @"DELETE FROM ""Music"" WHERE ""Artist"" = 'Acme Band' AND ""SongTitle"" = 'PartiQL Rocks' RETURNING ALL OLD *
"), Success("Music"));
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-functions.exists.html
  method {:test} TestExistsFromDocs() {
    ExpectEqual(TableFromStatement(
                  @"EXISTS(
    SELECT * FROM ""Music""
    WHERE ""Artist"" = 'Acme Band' AND ""SongTitle"" = 'PartiQL Rocks')
"), Success("Music"));
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.insert.html
  method {:test} TestInsertFromDocs() {
    ExpectEqual(TableFromStatement(
                  @"INSERT INTO ""Music"" value {'Artist' : 'Acme Band','SongTitle' : 'PartiQL Rocks'}
"), Success("Music"));    ExpectEqual(TableFromStatement(
                                                                                                                                               @"INSERT INTO ""Mu s ic"" value {'Artist' : 'Acme Band','SongTitle' : 'PartiQL Rocks'}
"), Success("Mu s ic"));
  }

}
