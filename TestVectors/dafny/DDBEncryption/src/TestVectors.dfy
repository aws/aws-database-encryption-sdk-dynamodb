// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  TODO
    queries that should pass in vanilla and fail in gazelle
    configs that should fail
    Better information printed on failure
    Both algo suites, ensure fail if different on decrypt
    Multiple Tables in config
    Use vanilla client to damage encrypted record in subtle ways, ensure failure
*/

include "../Model/AwsCryptographyDynamoDbEncryptionTypesWrapped.dfy"
include "CreateInterceptedDDBClient.dfy"
include "JsonItem.dfy"

module {:options "-functionSyntax:4"} DdbEncryptionTestVectors {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.String
  import opened JSON.Values
  import opened DynamoDbEncryptionUtil
  import opened DdbItemJson

  import FileIO
  import JSON.API
  import opened JSONHelpers
  import Norm = DynamoDbNormalizeNumber

  import Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import DDB = ComAmazonawsDynamodbTypes
  import Filter = DynamoDBFilterExpr
  import SE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SKS = CreateStaticKeyStores
  import KeyMaterial
  import UTF8
  import KeyVectorsTypes = AwsCryptographyMaterialProvidersTestVectorKeysTypes
  import KeyVectors
  import CreateInterceptedDDBClient

  predicate IsValidInt32(x: int)  { -0x8000_0000 <= x < 0x8000_0000}
  type ConfigName = string

  datatype Record = Record (
    number : nat,
    item : DDB.AttributeMap
  )

  datatype TableConfig = TableConfig (
    name : ConfigName,
    config : Types.DynamoDbTableEncryptionConfig,
    vanilla : bool
  )

  datatype SimpleQuery = SimpleQuery (
    index : Option<DDB.IndexName>,
    keyExpr : Option<string>,
    filterExpr : Option<string>,
    failConfigs : seq<ConfigName>
  )

  datatype ComplexQuery = ComplexQuery (
    query : SimpleQuery,
    pass : seq<string>,
    fail : seq<string>
  )

  datatype ComplexTest = ComplexTest (
    config : ConfigName,
    queries : seq<ComplexQuery>,
    failures : seq<SimpleQuery>
  )

  datatype WriteTest = WriteTest (
    config : TableConfig,
    records : seq<Record>,
    fileName : string
  )
  datatype DecryptTest = DecryptTest (
    config : TableConfig,
    encryptedRecords : seq<Record>,
    plaintextRecords : seq<Record>
  )

  datatype IoTest = IoTest (
    name : string,
    writeConfig : TableConfig,
    readConfig : TableConfig,
    records : seq<Record>,
    names : DDB.ExpressionAttributeNameMap,
    values : DDB.ExpressionAttributeValueMap,
    queries : seq<SimpleQuery>
  )

  const TableName : DDB.TableName := "GazelleVectorTable"
  const HashName := "RecNum"

  type ConfigPair = (ConfigName, ConfigName)
  type PairList = seq<ConfigPair>

  datatype TestVectorConfig = TestVectorConfig (
    schemaOnEncrypt : DDB.CreateTableInput,
    globalRecords : seq<Record>,
    tableEncryptionConfigs : map<ConfigName, TableConfig>,
    queries : seq<SimpleQuery>,
    names : DDB.ExpressionAttributeNameMap,
    values : DDB.ExpressionAttributeValueMap,
    failingQueries : seq<SimpleQuery>,
    complexTests : seq<ComplexTest>,
    ioTests : seq<IoTest>,
    configsForIoTest : PairList,
    configsForModTest : PairList,
    writeTests : seq<WriteTest>,
    decryptTests : seq<DecryptTest>
  ) {

    method RunAllTests()
    {
      print "DBE Test Vectors\n";
      print |globalRecords|, " records.\n";
      print |tableEncryptionConfigs|, " tableEncryptionConfigs.\n";
      print |queries|, " queries.\n";
      print |names|, " names.\n";
      print |values|, " values.\n";
      print |failingQueries|, " failingQueries.\n";
      print |complexTests|, " complexTests.\n";
      print |ioTests|, " ioTests.\n";
      print |configsForIoTest|, " configsForIoTest.\n";
      print |configsForModTest|, " configsForModTest.\n";
      Validate();
      BasicIoTest();
      RunIoTests();
      BasicQueryTest();
      ConfigModTest();
      ComplexTests();
      WriteTests();
      DecryptTests();
      var client :- expect CreateInterceptedDDBClient.CreateVanillaDDBClient();
      DeleteTable(client);
    }

    method Validate() {
      var bad := false;
      for i := 0 to |globalRecords| {
        if globalRecords[i].number != i {
          print "Record number ", i, " has number ", globalRecords[i].number, "\n";
          bad := true;
        }
      }
      for i := 0 to |complexTests| {
        if complexTests[i].config !in tableEncryptionConfigs {
          print "Complex Test number ", i, " refers to search config, ", complexTests[i].config, " which does not exist.\n";
          bad := true;
        }
      }
      for i := 0 to |queries| {
        for j := 0 to |queries[i].failConfigs| {
          if queries[i].failConfigs[j] !in tableEncryptionConfigs {
            print "Simple query number ", i, " refers to search config ", queries[i].failConfigs[j], " which does not exist.\n";
            bad := true;
          }
        }
      }

      for i := 0 to |configsForIoTest| {
        if configsForIoTest[i].0 !in tableEncryptionConfigs {
          print "configsForIoTest number ", i, " refers to search config ", configsForIoTest[i].0, " which does not exist.\n";
          bad := true;
        }
        if configsForIoTest[i].1 !in tableEncryptionConfigs {
          print "configsForIoTest number ", i, " refers to search config ", configsForIoTest[i].1, " which does not exist.\n";
          bad := true;
        }
      }
      for i := 0 to |configsForModTest| {
        if configsForModTest[i].0 !in tableEncryptionConfigs {
          print "configsForModTest number ", i, " refers to search config ", configsForModTest[i].0, " which does not exist.\n";
          bad := true;
        }
        if configsForModTest[i].1 !in tableEncryptionConfigs {
          print "configsForModTest number ", i, " refers to search config ", configsForModTest[i].1, " which does not exist.\n";
          bad := true;
        }
      }
      expect !bad;
    }
    method DeleteTable(client : DDB.IDynamoDBClient)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      var res := client.DeleteTable(DDB.DeleteTableInput(TableName := TableName));
    }

    function GetUsed(q : SimpleQuery) : (DDB.ExpressionAttributeNameMap, DDB.ExpressionAttributeValueMap)
    {
      TrimMaps(q.keyExpr.UnwrapOr(""), q.filterExpr.UnwrapOr(""), names, values)
    }

    method GetUsed2(q : SimpleQuery, names : Option<DDB.ExpressionAttributeNameMap>, values : Option<DDB.ExpressionAttributeValueMap>)
      returns (output : (DDB.ExpressionAttributeNameMap, DDB.ExpressionAttributeValueMap))
    {
      expect names.Some? == values.Some?;
      if names.Some? {
        return (names.value, values.value);
      } else {
        return GetUsed(q);
      }
    }

    method FullSearch(
      client : DDB.IDynamoDBClient,
      q : SimpleQuery,
      names : Option<DDB.ExpressionAttributeNameMap> := None,
      values : Option<DDB.ExpressionAttributeValueMap> := None
    )
      returns (output : DDB.ItemList)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      if q.keyExpr.Some? {
        output := FullQuery(client, q, names, values);
      } else {
        output := FullScan(client, q, names, values);
      }
    }

    method FullQuery(client : DDB.IDynamoDBClient, q : SimpleQuery, names : Option<DDB.ExpressionAttributeNameMap>, values : Option<DDB.ExpressionAttributeValueMap>) returns (output : DDB.ItemList)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      var zzz := GetUsed2(q, names, values);
      var (usedNames, usedValues) := zzz;

      output := [];
      var lastKey : Option<DDB.Key> := None;
      for i := 0 to 100
      {
        var result :- expect client.Query(GetQueryInput(q, usedNames, usedValues, lastKey));
        if result.Items.Some? {
          output := output + result.Items.value;
        }
        if result.LastEvaluatedKey.Some? {
          lastKey := result.LastEvaluatedKey;
        } else {
          break;
        }
      }
    }

    method FullScan(client : DDB.IDynamoDBClient, q : SimpleQuery, names : Option<DDB.ExpressionAttributeNameMap>, values : Option<DDB.ExpressionAttributeValueMap>) returns (output : DDB.ItemList)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      var zzz := GetUsed2(q, names, values);
      var (usedNames, usedValues) := zzz;

      output := [];
      var lastKey : Option<DDB.Key> := None;
      for i := 0 to 100
      {
        var result :- expect client.Scan(GetScanInput(q, usedNames, usedValues, lastKey));
        if result.Items.Some? {
          output := output + result.Items.value;
        }
        if result.LastEvaluatedKey.Some? {
          lastKey := result.LastEvaluatedKey;
        } else {
          break;
        }
      }
    }

    function GetQueryInput(
      q : SimpleQuery,
      usedNames : DDB.ExpressionAttributeNameMap,
      usedValues : DDB.ExpressionAttributeValueMap,
      lastKey : Option<DDB.Key> := None
    )
      : DDB.QueryInput
    {
      DDB.QueryInput(
        TableName := TableName,
        IndexName := q.index,
        FilterExpression := q.filterExpr,
        KeyConditionExpression := q.keyExpr,
        Select := None,
        AttributesToGet := None,
        Limit := None,
        ConsistentRead := None,
        KeyConditions := None,
        QueryFilter := None,
        ConditionalOperator := None,
        ScanIndexForward := None,
        ExclusiveStartKey := lastKey,
        ReturnConsumedCapacity := None,
        ProjectionExpression := None,
        ExpressionAttributeNames := if |usedNames| == 0 then None else Some(usedNames),
        ExpressionAttributeValues :=  if |usedValues| == 0 then None else Some(usedValues)
      )
    }

    function GetScanInput(
      q : SimpleQuery,
      usedNames : DDB.ExpressionAttributeNameMap,
      usedValues : DDB.ExpressionAttributeValueMap,
      lastKey : Option<DDB.Key> := None
    )
      : DDB.ScanInput
    {
      DDB.ScanInput(
        TableName := TableName,
        IndexName := q.index,
        FilterExpression := q.filterExpr,
        Select := None,
        AttributesToGet := None,
        Limit := None,
        ConsistentRead := None,
        ConditionalOperator := None,
        ExclusiveStartKey := lastKey,
        ReturnConsumedCapacity := None,
        ProjectionExpression := None,
        ExpressionAttributeNames := if |usedNames| == 0 then None else Some(usedNames),
        ExpressionAttributeValues :=  if |usedValues| == 0 then None else Some(usedValues),
        ScanFilter := None,
        Segment := None,
        TotalSegments := None
      )
    }

    method WriteAllRecords(client : DDB.IDynamoDBClient, records : seq<Record>)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      DeleteTable(client);
      var _ :-  expect client.CreateTable(schemaOnEncrypt);
      for i := 0 to |records| {
        var input := DDB.PutItemInput(
          TableName := TableName,
          Item := records[i].item,
          Expected := None,
          ReturnValues := None,
          ReturnConsumedCapacity := None,
          ReturnItemCollectionMetrics := None,
          ConditionalOperator := None,
          ConditionExpression := None,
          ExpressionAttributeNames := None,
          ExpressionAttributeValues := None
        );
        var _ :-  expect client.PutItem(input);
      }
    }

    method BasicIoTest()
    {
      print "BasicIoTest\n";
      for x := 0 to |configsForIoTest| {
        expect configsForIoTest[x].0 in tableEncryptionConfigs;
        expect configsForIoTest[x].1 in tableEncryptionConfigs;
        var c1 := tableEncryptionConfigs[configsForIoTest[x].0];
        var c2 := tableEncryptionConfigs[configsForIoTest[x].1];
        BasicIoTestBatchWriteItem(c1, c2, globalRecords);
        BasicIoTestPutItem(c1, c2, globalRecords);
        BasicIoTestTransactWriteItems(c1, c2, globalRecords);
      }
    }

    method RunIoTests()
    {
      print "RunIoTests\n";
      for i := 0 to |ioTests| {
        BasicIoTestBatchWriteItem(ioTests[i].writeConfig, ioTests[i].readConfig, ioTests[i].records);
        BasicIoTestPutItem(ioTests[i].writeConfig, ioTests[i].readConfig, ioTests[i].records);
        BasicIoTestTransactWriteItems(ioTests[i].writeConfig, ioTests[i].readConfig, ioTests[i].records);

        var rClient :- expect newGazelle(ioTests[i].readConfig);
        for j := 0 to |ioTests[i].queries| {
          var results := FullSearch(rClient, ioTests[i].queries[j], Some(ioTests[i].names), Some(ioTests[i].values));
        }
      }
    }

    method ConfigModTest()
    {
      print "ConfigModTest\n";
      for x := 0 to |configsForModTest| {
        expect configsForModTest[x].0 in tableEncryptionConfigs;
        expect configsForModTest[x].1 in tableEncryptionConfigs;
        ConfigModPairTest(tableEncryptionConfigs[configsForModTest[x].0], tableEncryptionConfigs[configsForModTest[x].1]);
      }
    }

    method newGazelle(config: TableConfig)
      returns (output: Result<DDB.IDynamoDBClient, Types.Error>)
      ensures output.Success? ==>
                && fresh(output.value)
                && fresh(output.value.Modifies)
                && fresh(output.value.History)
                && output.value.ValidState()
    {
      if config.vanilla {
        output := CreateInterceptedDDBClient.CreateVanillaDDBClient();
      } else {
        var configs := Types.DynamoDbTablesEncryptionConfig (
          tableEncryptionConfigs := map[TableName := config.config]
        );
        output := CreateInterceptedDDBClient.CreateInterceptedDDBClient(configs);
        if output.Failure? {
          print output.error, "\n";
        }
      }
    }

    method ConfigModPairTest(x : TableConfig, y : TableConfig)
    {
      print "ConfigModPairTest ", x.name, ", ", y.name, "\n";
      var client1 :- expect newGazelle(x);
      var client2 :- expect newGazelle(y);
      WriteAllRecords(client1, globalRecords);
      for i := 0 to |queries| {
        if x.name !in queries[i].failConfigs && y.name !in queries[i].failConfigs {
          var result1 := FullSearch(client1, queries[i]);
          var result2 := FullSearch(client2, queries[i]);
          expect QueryOutputEqual(result1, result2);
        }
      }
    }

    method ComplexTests()
    {
      print "ComplexTests\n";
      for i := 0 to |complexTests| {
        DoComplexTest(complexTests[i]);
      }
    }

    method InResult(num : string, results : DDB.ItemList) returns (output : bool)
    {
      for i := 0 to |results| {
        var item := results[i];
        if HashName in results[i] && results[i][HashName] == DDB.AttributeValue.N(num) {
          return true;
        }
      }
      return false;
    }

    method DoComplexTest(test : ComplexTest)
    {
      expect test.config in tableEncryptionConfigs;
      var client :- expect newGazelle(tableEncryptionConfigs[test.config]);
      WriteAllRecords(client, globalRecords);

      for i := 0 to |test.failures| {
        var (usedNames, usedValues) := GetUsed(test.failures[i]);
        var result := client.Query(GetQueryInput(test.failures[i], usedNames, usedValues));
        expect result.Failure?;
      }
      for i := 0 to |test.queries| {
        var result := FullSearch(client, test.queries[i].query);
        for j := 0 to |test.queries[i].pass| {
          var res := InResult(test.queries[i].pass[j], result);
          if !res {
            print "Failure in DoComplexTest.\n", test.queries[i].query, "\n had ", |result|,
                  " results. Failed to include ", test.queries[i].pass[j], "\n";
          }
          expect res;
        }
        for j := 0 to |test.queries[i].fail| {
          var res := InResult(test.queries[i].fail[j], result);
          if res {
            print "Failure in DoComplexTest.\n", test.queries[i].query, "\n had ", |result|,
                  " results. Erroneously included ", test.queries[i].fail[j], "\n";
          }
          expect !res;
        }
      }
    }

    method WriteTests()
    {
      print "WriteTests\n";
      for i := 0 to |writeTests| {
        var client :- expect newGazelle(writeTests[i].config);
        WriteAllRecords(client, writeTests[i].records);
        var vanillaClient :- expect CreateInterceptedDDBClient.CreateVanillaDDBClient();
        var encRecords := ReadAllRecords(vanillaClient);
        expect |encRecords| == |writeTests[i].records|;
        WriteJsonRecords(encRecords, writeTests[i].fileName);
      }
    }

    method DecryptTests()
    {
      print "DecryptTests\n";
      for i := 0 to |decryptTests| {
        var vanillaClient :- expect CreateInterceptedDDBClient.CreateVanillaDDBClient();
        WriteAllRecords(vanillaClient, decryptTests[i].encryptedRecords);
        var client :- expect newGazelle(decryptTests[i].config);
        var plainRecords := ReadAllRecords(client);
        expect |plainRecords| == |decryptTests[i].plaintextRecords|;
        CompareRecordsDisordered(decryptTests[i].plaintextRecords, plainRecords);
      }
    }

    method WriteJsonRecords(records : DDB.ItemList, fileName : string)
    {
      var jsonItems : seq<JSON> := [];
      for i := 0 to |records| {
        var item :- expect DdbItemToJson(records[i]);
        jsonItems := jsonItems + [item];
      }
      var jsonBytes :- expect API.Serialize(Array(jsonItems));
      var jsonBv := BytesBv(jsonBytes);
      var x := FileIO.WriteBytesToFile(fileName, jsonBv);
      expect x.Success?;
    }


    method BasicQueryTest()
    {
      print "BasicQueryTest\n";
      var client :- expect CreateInterceptedDDBClient.CreateVanillaDDBClient();
      WriteAllRecords(client, globalRecords);

      for i := 0 to |failingQueries| {
        var (usedNames, usedValues) := GetUsed(failingQueries[i]);
        var res := client.Query(GetQueryInput(failingQueries[i], usedNames, usedValues));
        expect res.Failure?;
      }
      var results := new DDB.ItemList[|queries|];
      for i := 0 to |queries| {
        results[i] := FullSearch(client, queries[i]);
      }

      var configs := tableEncryptionConfigs.Keys;
      while configs != {}
        decreases |configs|
        invariant forall k <- configs :: k in tableEncryptionConfigs
      {
        var config :| config in configs;
        configs := configs - { config };
        BasicQueryTestConfig(tableEncryptionConfigs[config], results, globalRecords);
      }
    }
    predicate QueryOutputEqual(actual : DDB.ItemList, expected : DDB.ItemList)
    {
      // TODO - maybe the order isn't guaranteed?
      actual == expected
    }

    method BasicQueryTestConfig(config : TableConfig, expected : array<DDB.ItemList>, records : seq<Record>)
      requires expected.Length == |queries|
    {
      var client :- expect newGazelle(config);
      WriteAllRecords(client, records);
      for i := 0 to |failingQueries| {
        var (usedNames, usedValues) := GetUsed(failingQueries[i]);
        var res := client.Query(GetQueryInput(failingQueries[i], usedNames, usedValues));
        expect res.Failure?;
      }
      for i := 0 to |queries| {
        if config.name in queries[i].failConfigs {
          // var (usedNames, usedValues) := GetUsed(queries[i]);
          // print "Expecting failure\n";
          // var res := client.Query(GetQueryInput(queries[i], usedNames, usedValues));
          // expect res.Failure?;
          // print "Done with failure\n";
        } else {
          var result := FullSearch(client, queries[i]);
          if !QueryOutputEqual(result, expected[i]) {
            print "Query : ", queries[i], "\nconfig : ", config.name;
            print " result : ", |result|, ", expected : ", |expected[i]|, ", \n";
          }
          expect QueryOutputEqual(result, expected[i]);
        }
      }
    }

    method BasicIoTestBatchWriteItem(writeConfig : TableConfig, readConfig : TableConfig, records : seq<Record>)
    {
      var wClient :- expect newGazelle(writeConfig);
      var rClient :- expect newGazelle(readConfig);
      DeleteTable(wClient);
      var _ :-  expect wClient.CreateTable(schemaOnEncrypt);
      var i := 0;
      while i < |records| {
        var count := 10;
        if |records| - i < 10 {
          count := |records| - i;
        }
        var requests : seq<DDB.WriteRequest> := [];
        for j := 0 to count {
          var req := DDB.WriteRequest(
            DeleteRequest := None,
            PutRequest := Some(
              DDB.PutRequest(Item := records[i+j].item)
            )
          );
          requests := requests + [req];
        }
        expect DDB.IsValid_WriteRequests(requests);
        var reqMap : map<DDB.TableName, DDB.WriteRequests> := map[TableName := requests];
        expect DDB.IsValid_BatchWriteItemRequestMap(reqMap);
        var _ :- expect wClient.BatchWriteItem(DDB.BatchWriteItemInput(
                                                 RequestItems := reqMap,
                                                 ReturnConsumedCapacity := None,
                                                 ReturnItemCollectionMetrics := None
                                               ));
        i := i + count;
      }

      BasicIoTestGetItem(rClient, records);
      BasicIoTestBatchGetItems(rClient, records);
      BasicIoTestScan(rClient, records);
      BasicIoTestTransactGetItems(rClient, records);
    }

    method BasicIoTestTransactWriteItems(writeConfig : TableConfig, readConfig : TableConfig, records : seq<Record>)
    {
      var wClient :- expect newGazelle(writeConfig);
      var rClient :- expect newGazelle(readConfig);
      DeleteTable(wClient);
      var _ :-  expect wClient.CreateTable(schemaOnEncrypt);
      var i := 0;
      while i < |records| {
        var count := 10;
        if |records| - i < 10 {
          count := |records| - i;
        }
        var requests : seq<DDB.TransactWriteItem> := [];
        for j := 0 to count {
          var item := DDB.Put(
            Item := records[i+j].item,
            TableName := TableName,
            ConditionExpression := None,
            ExpressionAttributeNames := None,
            ExpressionAttributeValues := None,
            ReturnValuesOnConditionCheckFailure := None
          );
          var wItem := DDB.TransactWriteItem(
            ConditionCheck := None,
            Put := Some(item),
            Delete := None,
            Update := None
          );
          requests := requests + [wItem];
        }
        expect DDB.IsValid_TransactWriteItemList(requests);
        var _ :- expect wClient.TransactWriteItems(
          DDB.TransactWriteItemsInput(
            TransactItems := requests,
            ReturnConsumedCapacity := None,
            ReturnItemCollectionMetrics := None,
            ClientRequestToken := None
          )
        );
        i := i + count;
      }
      BasicIoTestBatchGetItems(rClient, records);
      BasicIoTestGetItem(rClient, records);
      BasicIoTestScan(rClient, records);
      BasicIoTestTransactGetItems(rClient, records);
    }

    method BasicIoTestPutItem(writeConfig : TableConfig, readConfig : TableConfig, records : seq<Record>)
    {
      var wClient :- expect newGazelle(writeConfig);
      var rClient :- expect newGazelle(readConfig);
      WriteAllRecords(wClient, records);

      BasicIoTestBatchGetItems(rClient, records);
      BasicIoTestGetItem(rClient, records);
      BasicIoTestScan(rClient, records);
      BasicIoTestTransactGetItems(rClient, records);
    }

    method FindMatchingRecord(expected : DDB.AttributeMap, actual : DDB.ItemList) returns (output : bool)
    {
      var exp := NormalizeItem(expected);
      for i := 0 to |actual| {
        if actual[i] == exp {
          return true;
        }
      }
      return false;
    }
    method CompareRecordsDisordered(expected : seq<Record>, actual : DDB.ItemList)
    {
      expect |expected| == |actual|;
      var bad := false;
      for i := 0 to |expected| {
        var found := FindMatchingRecord(expected[i].item, actual);
        if !found {
          print "Did not find result for record ", expected[i].number, "\n";
          bad := true;
        }
      }
      expect !bad;
    }

    method BasicIoTestScan(client : DDB.IDynamoDBClient, records : seq<Record>)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      var emptyQuery := SimpleQuery(None, None, None, []);
      var results := FullScan(client, emptyQuery, None, None);
      expect |results| == |records|;
      CompareRecordsDisordered(records, results);
    }

    method ReadAllRecords(client : DDB.IDynamoDBClient) returns (output : DDB.ItemList)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      var emptyQuery := SimpleQuery(None, None, None, []);
      output := FullScan(client, emptyQuery, None, None);
    }

    method BasicIoTestGetItem(client : DDB.IDynamoDBClient, records : seq<Record>)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      for i := 0 to |records| {
        :- expect Need(HashName in records[i].item, "");
        var input := DDB.GetItemInput(
          TableName := TableName,
          Key := map[HashName := records[i].item[HashName]],
          AttributesToGet := None,
          ConsistentRead := None,
          ReturnConsumedCapacity := None,
          ProjectionExpression := None,
          ExpressionAttributeNames := None
        );
        var out :- expect client.GetItem(input);
        expect out.Item.Some?;
        expect out.Item.value == NormalizeItem(records[i].item);
      }
    }

    method PrintAllRecords(records : seq<Record>)
    {
      var client :- expect CreateInterceptedDDBClient.CreateVanillaDDBClient();
      for i := 0 to |records| {
        :- expect Need(HashName in records[i].item, "");
        var input := DDB.GetItemInput(
          TableName := TableName,
          Key := map[HashName := records[i].item[HashName]],
          AttributesToGet := None,
          ConsistentRead := None,
          ReturnConsumedCapacity := None,
          ProjectionExpression := None,
          ExpressionAttributeNames := None
        );
        var out :- expect client.GetItem(input);
        expect out.Item.Some?;
        print out.Item.value, "\n\n";
      }
    }

    function NormalizeItem(value : DDB.AttributeMap) : DDB.AttributeMap
    {
      map k <- value :: k := Normalize(value[k])
    }

    function Normalize(value : DDB.AttributeValue) : DDB.AttributeValue
    {
      match value {
        case N(n) =>
          var nn := Norm.NormalizeNumber(n);
          if nn.Success? then
            DDB.AttributeValue.N(nn.value)
          else
            value
        case _ => value
      }
    }

    method ItemExists(number : DDB.AttributeValue, record : Record, resp : DDB.ItemList) returns (output : bool)
    {
      if |resp| == 0 {
        return false;
      } else if HashName in resp[0] && resp[0][HashName] == number {
        expect resp[0] == NormalizeItem(record.item);
        return true;
      } else {
        output := ItemExists(number, record, resp[1..]);
      }
    }
    method ItemExists2(number : DDB.AttributeValue, record : Record, resp : seq<DDB.ItemResponse>) returns (output : bool)
    {
      if |resp| == 0 {
        return false;
      } else if resp[0].Item.Some? && HashName in resp[0].Item.value && resp[0].Item.value[HashName] == number {
        expect resp[0].Item.value == NormalizeItem(record.item);
        return true;
      } else {
        output := ItemExists2(number, record, resp[1..]);
      }
    }

    method BasicIoTestBatchGetItems(client : DDB.IDynamoDBClient, records : seq<Record>)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      var i := 0;
      while i < |records| {
        var count := 10;
        if |records| - i < 10 {
          count := |records| - i;
        }
        var requests : seq<DDB.Key> := [];
        for j := 0 to count {
          var val := DDB.AttributeValue.N(String.Base10Int2String(i+j));
          var item := map[HashName := val];
          requests := requests + [item];
        }
        expect DDB.IsValid_KeyList(requests);
        var keyAttr := DDB.KeysAndAttributes (
          Keys := requests,
          AttributesToGet := None,
          ConsistentRead := None,
          ProjectionExpression := None,
          ExpressionAttributeNames := None
        );
        var reqMap := map[TableName := keyAttr];
        expect DDB.IsValid_BatchGetRequestMap(reqMap);
        var result :- expect client.BatchGetItem(
          DDB.BatchGetItemInput(
            RequestItems := reqMap ,
            ReturnConsumedCapacity := None
          )
        );
        expect result.UnprocessedKeys.None?; // TODO - actually handle this
        expect result.Responses.Some?;
        expect |result.Responses.value| == 1;
        expect TableName in result.Responses.value;
        var resp := result.Responses.value[TableName];
        for j := 0 to count {
          expect HashName in records[i+j].item;
          var val := records[i+j].item[HashName];
          var doesExist := ItemExists(val, records[i+j], resp);
          expect doesExist;
        }
        i := i + count;
      }
    }

    method BasicIoTestTransactGetItems(client : DDB.IDynamoDBClient, records : seq<Record>)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      var i := 0;
      while i < |records| {
        var count := 10;
        if |records| - i < 10 {
          count := |records| - i;
        }
        var requests : seq<DDB.TransactGetItem> := [];
        for j := 0 to count {
          expect HashName in records[i+j].item;
          var item := DDB.TransactGetItem(
            Get := DDB.Get (
              Key := map[HashName := records[i+j].item[HashName]],
              TableName := TableName,
              ProjectionExpression := None,
              ExpressionAttributeNames := None
            )
          );
          requests := requests + [item];
        }
        expect DDB.IsValid_TransactGetItemList(requests);
        var result :- expect client.TransactGetItems(
          DDB.TransactGetItemsInput(
            TransactItems := requests ,
            ReturnConsumedCapacity := None
          )
        );
        expect result.Responses.Some?;
        var resp := result.Responses.value;
        for j := 0 to count {
          expect HashName in records[i+j].item;
          var val := records[i+j].item[HashName];
          var doesExist := ItemExists2(val, records[i+j], resp);
          expect doesExist;
        }
        i := i + count;
      }
    }
  }

  // For the given query, keep only the names and values actually used
  function {:opaque} TrimMaps(
    keyExpr : string,
    filterExpr : string,
    names : DDB.ExpressionAttributeNameMap,
    values : DDB.ExpressionAttributeValueMap
  )
    : (ret : (DDB.ExpressionAttributeNameMap, DDB.ExpressionAttributeValueMap))
    ensures forall k <- ret.0 :: k in names && names[k] == ret.0[k]
    ensures forall k <- ret.1 :: k in values && values[k] == ret.1[k]
  {
    var keyParsed := Filter.ParseExpr(keyExpr);
    var filterParsed := Filter.ParseExpr(filterExpr);
    TrimMaps2(keyParsed+filterParsed, names, values)
  }

  function {:opaque} TrimMaps2(
    query : seq<Filter.Token>,
    origNames : DDB.ExpressionAttributeNameMap,
    origValues : DDB.ExpressionAttributeValueMap,
    newNames : DDB.ExpressionAttributeNameMap := map[],
    newValues : DDB.ExpressionAttributeValueMap := map[]
  )
    : (ret : (DDB.ExpressionAttributeNameMap, DDB.ExpressionAttributeValueMap))
    requires forall k <- newNames :: k in origNames && origNames[k] == newNames[k]
    requires forall k <- newValues :: k in origValues && origValues[k] == newValues[k]
    ensures forall k <- ret.0 :: k in origNames && origNames[k] == ret.0[k]
    ensures forall k <- ret.1 :: k in origValues && origValues[k] == ret.1[k]
  {
    if |query| == 0 then
      (newNames, newValues)
    else
      TrimMaps2(
        query[1..], origNames, origValues,
        if query[0].Attr? && query[0].s in origNames then newNames[query[0].s := origNames[query[0].s]] else newNames,
        if query[0].Value? && query[0].s in origValues then newValues[query[0].s := origValues[query[0].s]] else newValues
      )
  }

  function MakeCreateTableInput() : DDB.CreateTableInput
  {
    DDB.CreateTableInput (
      AttributeDefinitions := [DDB.AttributeDefinition(AttributeName := HashName, AttributeType := DDB.ScalarAttributeType.N)],
      TableName := TableName,
      KeySchema := [DDB.KeySchemaElement(AttributeName := HashName, KeyType := DDB.HASH)],
      LocalSecondaryIndexes := None,
      GlobalSecondaryIndexes := None,
      BillingMode := None,
      ProvisionedThroughput := Some(
        DDB.ProvisionedThroughput(
          ReadCapacityUnits := 100 ,
          WriteCapacityUnits := 100
        )),
      StreamSpecification := None,
      SSESpecification := None,
      Tags := None,
      TableClass := None
    )
  }

  function MakeEmptyTestVector() : TestVectorConfig
  {
    TestVectorConfig(MakeCreateTableInput(), [], map[], [], map[], map[], [], [], [], [], [], [], [])
  }

  method ParseTestVector(data : JSON, prev : TestVectorConfig) returns (output : Result<TestVectorConfig, string>)
  {
    :- Need(data.Object?, "Top Level JSON must be an object.");
    var records : seq<Record> := [];
    var ioPairs : PairList := [];
    var queryPairs : PairList := [];
    var queries : seq<SimpleQuery> := [];
    var failingQueries : seq<SimpleQuery> := [];
    var names : DDB.ExpressionAttributeNameMap := map[];
    var values : DDB.ExpressionAttributeValueMap := map[];
    var complexTests : seq<ComplexTest> := [];
    var ioTests : seq<IoTest> := [];
    var gsi : seq<DDB.GlobalSecondaryIndex> := [];
    var tableEncryptionConfigs : map<string, TableConfig> := map[];
    var writeTests : seq<WriteTest> := [];
    var decryptTests : seq<DecryptTest> := [];

    for i := 0 to |data.obj| {
      match data.obj[i].0 {
        case "Records" => records :- GetRecords(data.obj[i].1);
        case "IoPairs" => ioPairs :- GetPairs(data.obj[i].1);
        case "QueryPairs" => queryPairs :- GetPairs(data.obj[i].1);
        case "Queries" => queries :- GetSimpleQueries(data.obj[i].1);
        case "Failing" => failingQueries :- GetSimpleQueries(data.obj[i].1);
        case "Names" => names :- GetNameMap(data.obj[i].1);
        case "Values" => values :- GetValueMap(data.obj[i].1);
        case "Complex" => complexTests :- GetComplexTests(data.obj[i].1);
        case "IoTests" => ioTests :- GetIoTests(data.obj[i].1);
        case "GSI" => gsi :- GetGSIs(data.obj[i].1);
        case "tableEncryptionConfigs" => tableEncryptionConfigs :- GetTableConfigs(data.obj[i].1);
        case "WriteTests" => writeTests :- GetWriteTests(data.obj[i].1);
        case "DecryptTests" => decryptTests :- GetDecryptTests(data.obj[i].1);
        case _ => return Failure("Unexpected top level tag " + data.obj[i].0);
      }
    }

    var newSchema :- MergeGSI(prev.schemaOnEncrypt, gsi);
    output := Success(
      TestVectorConfig (
        schemaOnEncrypt := newSchema,
        globalRecords := prev.globalRecords + records,
        tableEncryptionConfigs := prev.tableEncryptionConfigs + tableEncryptionConfigs,
        queries := prev.queries + queries,
        failingQueries := prev.failingQueries + failingQueries,
        names := prev.names + names,
        values := prev.values + values,
        complexTests := prev.complexTests + complexTests,
        ioTests := prev.ioTests + ioTests,
        configsForIoTest := prev.configsForIoTest + ioPairs,
        configsForModTest := prev.configsForModTest + queryPairs,
        writeTests := prev.writeTests + writeTests,
        decryptTests := prev.decryptTests + decryptTests
      )
    );
  }

  method GetWriteTests(data : JSON) returns (output : Result<seq<WriteTest> , string>)
  {
    :- Need(data.Array?, "Write Test list must be an array.");
    var results : seq<WriteTest> := [];
    for i := 0 to |data.arr| {
      var obj := data.arr[i];
      var item :- GetOneWriteTest(obj);
      results := results + [item];
    }
    return Success(results);
  }
  method GetOneWriteTest(data : JSON) returns (output : Result<WriteTest, string>)
  {
    :- Need(data.Object?, "A Write Test must be an object.");
    var config : Option<TableConfig> := None;
    var fileName : string := "";
    var records : seq<Record> := [];

    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Config" => var src :- GetOneTableConfig("foo", obj.1); config := Some(src);
        case "FileName" =>
          :- Need(obj.1.String?, "Write Test file name must be a string.");
          fileName := obj.1.str;
        case "Records" => records :- GetRecords(obj.1);
        case _ => return Failure("Unexpected part of a write test : '" + obj.0 + "'");
      }
    }
    :- Need(config.Some?, "Every Write Test needs a config.");
    :- Need(0 < |fileName|, "Every Write Test needs a file name.");
    return Success(WriteTest(config.value, records, fileName));
  }

  method GetDecryptTests(data : JSON) returns (output : Result<seq<DecryptTest> , string>)
  {
    :- Need(data.Array?, "Decrypt Test list must be an array.");
    var results : seq<DecryptTest> := [];
    for i := 0 to |data.arr| {
      var obj := data.arr[i];
      var item :- GetOneDecryptTest(obj);
      results := results + [item];
    }
    return Success(results);
  }
  method GetOneDecryptTest(data : JSON) returns (output : Result<DecryptTest, string>)
  {
    :- Need(data.Object?, "A Decrypt Test must be an object.");
    var config : Option<TableConfig> := None;
    var encRecords : seq<Record> := [];
    var plainRecords : seq<Record> := [];

    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Config" => var src :- GetOneTableConfig("foo", obj.1); config := Some(src);
        case "EncryptedRecords" => encRecords :- GetRecords(obj.1);
        case "PlainTextRecords" => plainRecords :- GetRecords(obj.1);
        case _ => return Failure("Unexpected part of a encrypt test : '" + obj.0 + "'");
      }
    }
    :- Need(config.Some?, "Every Decrypt Test needs a config.");
    :- Need(|encRecords| == |plainRecords|, "A Decrypt Test needs the same number of EncryptedRecords and PlainTextRecords.");
    :- Need(0 < |encRecords|, "Every Decrypt Test needs at least on record.");
    return Success(DecryptTest(config.value, encRecords, plainRecords));
  }

  method GetTableConfigs(data : JSON) returns (output : Result<map<string, TableConfig> , string>)
  {
    :- Need(data.Object?, "Search Config list must be an object.");
    var results : map<string, TableConfig> := map[];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      var item :- GetOneTableConfig(obj.0, obj.1);
      results := results[obj.0 := item];
    }
    return Success(results);
  }
  method GetOneTableConfig(name : string, data : JSON) returns (output : Result<TableConfig, string>)
  {
    :- Need(data.Object?, "A Table Config must be an object.");
    var encrypt : seq<string>  := [];
    var attributeActionsOnEncrypt : Types.AttributeActions  := map[];
    var allowed : seq<DDB.AttributeName>  := [];
    var prefix : string  := "";
    var stdBeacons : seq<Types.StandardBeacon> := [];
    var compoundBeacons : seq<Types.CompoundBeacon> := [];
    var virtualFields : seq<Types.VirtualField> := [];
    var keySource : Option<Types.BeaconKeySource> := None;
    var search : Option<Types.SearchConfig> := None;

    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "attributeActionsOnEncrypt" => attributeActionsOnEncrypt :- GetAttributeActions(obj.1);
        case "allowedUnsignedAttributePrefix" =>
          :- Need(obj.1.String?, "Prefix must be of type String.");
          prefix := obj.1.str;
        case "allowedUnsignedAttributes" => allowed :- GetAttrNames(obj.1);
        case "search" => var src :- GetOneSearchConfig(obj.1); search := Some(src);
        case _ => return Failure("Unexpected part of a table config : '" + obj.0 + "'");
      }
    }

    var keys :- expect KeyVectors.KeyVectors(
      KeyVectorsTypes.KeyVectorsConfig(
        keyManifiestPath := "../../../submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders/test/keys.json"
      )
    );
    var keyDescription := KeyVectorsTypes.Hierarchy(KeyVectorsTypes.HierarchyKeyring(
                                                      keyId := "static-branch-key-1"
                                                    ));
    var keyring :- expect keys.CreateWappedTestVectorKeyring(KeyVectorsTypes.TestVectorKeyringInput(keyDescription := keyDescription));

    var config :=
      Types.DynamoDbTableEncryptionConfig(
        logicalTableName := TableName,
        partitionKeyName := HashName,
        sortKeyName := None,
        search := search,
        attributeActionsOnEncrypt := attributeActionsOnEncrypt,
        allowedUnsignedAttributes := OptSeq(allowed),
        allowedUnsignedAttributePrefix := OptSeq(prefix),
        algorithmSuiteId := None,
        keyring := Some(keyring),
        cmm := None,
        legacyOverride := None,
        plaintextOverride := None
      );
    return Success(TableConfig(name, config, |data.obj| == 0));
  }

  method GetOneSearchConfig(data : JSON) returns (output : Result<Types.SearchConfig, string>)
  {
    :- Need(data.Object?, "A Search Config must be an object.");
    var writeVersion : nat := 1;
    var versions : seq<Types.BeaconVersion> := [];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "versions" =>
          :- Need(obj.1.Array?, "versions must be an Array.");
          for j := 0 to |obj.1.arr| {
            var v :- GetOneBeaconVersion(obj.1.arr[j]);
            versions := versions + [v];
          }
        case "writeVersion" =>
          :- Need(obj.1.Number?, "writeVersion must be a number");
          writeVersion :- DecimalToNat(obj.1.num);
        case _ => return Failure("Unexpected part of a search config : '" + obj.0 + "'");
      }
    }

    :- Need(Types.IsValid_BeaconVersionList(versions), "versions needs at least one version");
    return Success(Types.SearchConfig (
                     versions := versions,
                     writeVersion := 1
                   ));
  }
  method GetOneBeaconVersion(data : JSON) returns (output : Result<Types.BeaconVersion, string>)
  {
    :- Need(data.Object?, "A Beacon Version must be an object.");
    var standardBeacons : seq<Types.StandardBeacon> := [];
    var compoundBeacons : seq<Types.CompoundBeacon> := [];
    var virtualFields : seq<Types.VirtualField> := [];
    var keySource : Option<Types.BeaconKeySource> := None;

    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "keySource" => var src :- GetKeySource(obj.1); keySource := Some(src);
        case "standardBeacons" => standardBeacons :- GetStandardBeacons(obj.1);
        case "compoundBeacons" => compoundBeacons :- GetCompoundBeacons(obj.1);
        case "virtualFields" => virtualFields :- GetVirtualFields(obj.1);
        case _ => return Failure("Unexpected part of a beacon version : '" + obj.0 + "'");
      }
    }

    :- Need(|standardBeacons| > 0, "A Search Config needs at least one standard beacon.");
    var keyMaterial : KeyMaterial.KeyMaterial :=
      KeyMaterial.StaticKeyStoreInformation("abc", UTF8.EncodeAscii("abc"), [1,2,3,4,5], [1,2,3,4,5]);
    var store := SKS.CreateStaticKeyStore(keyMaterial);
    var source : Types.BeaconKeySource :=
      if keySource.Some? then
        keySource.value
      else
        Types.single(Types.SingleKeyStore(keyId := "foo", cacheTTL := 42));

    return Success(Types.BeaconVersion(
                     version := 1,
                     keyStore := store,
                     keySource := source,
                     standardBeacons := standardBeacons,
                     compoundBeacons := OptSeq(compoundBeacons),
                     virtualFields := OptSeq(virtualFields),
                      encrypted := None,
                      signed := None
                   )
      );
  }

  method GetAttributeActions(data : JSON) returns (output : Result<Types.AttributeActions, string>)
  {
    :- Need(data.Object?, "attributeActionsOnEncrypt must be an object");
    var result : Types.AttributeActions := map[];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      :- Need(DDB.IsValid_AttributeName(obj.0), obj.0 + " is not a valid attribute name.");
      var action :- GetAttributeAction(obj.1);
      result := result[obj.0 := action];
    }
    return Success(result);
  }
  method GetAttributeAction(data : JSON) returns (output : Result<SE.CryptoAction, string>)
  {
    :- Need(data.String?, "Attribute Action must be a string");
    match data.str {
      case "ENCRYPT_AND_SIGN" => return Success(SE.ENCRYPT_AND_SIGN);
      case "SIGN_ONLY" => return Success(SE.SIGN_ONLY);
      case "DO_NOTHING" => return Success(SE.DO_NOTHING);
      case _ => return Failure(data.str + " is not a value CryptoAction.");
    }
  }

  method GetStrings(data : JSON) returns (output : Result<seq<string>, string>)
  {
    :- Need(data.Array?, "List of strings must be an array");
    var results : seq<string> := [];
    for i := 0 to |data.arr| {
      :- Need(data.arr[i].String?, "Each item in a string list must be a string");
      results := results + [data.arr[i].str];
    }
    return Success(results);
  }

  method GetAttrNames(data : JSON) returns (output : Result<seq<DDB.AttributeName>, string>)
  {
    :- Need(data.Array?, "List of Attribute Names must be an array");
    var results : seq<DDB.AttributeName> := [];
    for i := 0 to |data.arr| {
      :- Need(data.arr[i].String?, "Each item in a string list must be a string");
      :- Need(DDB.IsValid_AttributeName(data.arr[i].str), data.arr[i].str + " is not a valid attribute name.");
      results := results + [data.arr[i].str];
    }
    return Success(results);
  }

  method GetAttributesFromGSI(prev : seq<DDB.AttributeDefinition>, gsi : seq<DDB.GlobalSecondaryIndex>) returns (output : seq<DDB.AttributeDefinition>)
  {
    var results := prev;
    for i := 0 to |gsi| {
      for j := 0 to |gsi[i].KeySchema| {
        if forall k <- prev :: k.AttributeName != gsi[i].KeySchema[j].AttributeName {
          results := results +  [DDB.AttributeDefinition(AttributeName := gsi[i].KeySchema[j].AttributeName, AttributeType := DDB.ScalarAttributeType.S)];
        }
      }
    }
    return results;
  }

  method MergeGSI(prev : DDB.CreateTableInput, gsi : seq<DDB.GlobalSecondaryIndex>) returns (output : Result<DDB.CreateTableInput, string>)
  {
    if |gsi| == 0 {
      return Success(prev);
    }
    var newAttr := GetAttributesFromGSI(prev.AttributeDefinitions, gsi);
    if prev.GlobalSecondaryIndexes.None? {
      return Success(prev.(AttributeDefinitions := newAttr, GlobalSecondaryIndexes := Some(gsi)));
    } else {
      return Success(prev.(AttributeDefinitions := newAttr, GlobalSecondaryIndexes := Some(prev.GlobalSecondaryIndexes.value + gsi)));
    }
  }

  method GetVirtualFields(data : JSON) returns (output : Result<seq<Types.VirtualField> , string>)
  {
    :- Need(data.Array?, "Virtual Field list must be an array.");
    var results : seq<Types.VirtualField> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneVirtualField(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }

  method GetKeySource(data : JSON) returns (output : Result<Types.BeaconKeySource, string>)
  {
    :- Need(data.Object?, "keySource must be an object.");
    var keyFieldName : string := "";
    var keyId : string := "";
    var cacheTTL : nat := 42;
    var maxCacheSize : nat := 1;
    var parts : seq<Types.VirtualPart> := [];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "keyFieldName" =>
          :- Need(obj.1.String?, "keyFieldName must be a string.");
          keyFieldName := obj.1.str;
        case "keyId" =>
          :- Need(obj.1.String?, "keyId must be a string.");
          keyId := obj.1.str;
        case "cacheTTL" =>
          :- Need(obj.1.Number?, "cacheTTL must be a number.");
          cacheTTL :- DecimalToNat(obj.1.num);
        case "maxCacheSize" =>
          :- Need(obj.1.Number?, "maxCacheSize must be a number.");
          maxCacheSize :- DecimalToNat(obj.1.num);
        case _ => return Failure("Unexpected part of a key source : '" + data.obj[i].0 + "'");
      }
    }
    :- Need(cacheTTL < INT32_MAX_LIMIT, "cacheTTL must fit in an int32");
    :- Need(maxCacheSize < INT32_MAX_LIMIT, "maxCacheSize must fit in an int32");
    :- Need(|keyFieldName| > 0 || |keyId| > 0, "Each key source needs a either a keyFieldName or a keyId.");
    :- Need(|keyFieldName| == 0 || |keyId| == 0, "Each key source cannot have both a keyFieldName and a keyId.");
    if |keyId| > 0 {
      return Success(Types.single(Types.SingleKeyStore(keyId := keyId, cacheTTL := cacheTTL as int32)));
    } else {
      assert |keyFieldName| > 0;
      return Success(Types.multi(Types.MultiKeyStore(keyFieldName := keyFieldName, cacheTTL := cacheTTL as int32, cache := None)));
    }
  }

  method GetOneVirtualField(data : JSON) returns (output : Result<Types.VirtualField, string>)
  {
    :- Need(data.Object?, "Virtual Field must be an object.");
    var name : string := "";
    var parts : seq<Types.VirtualPart> := [];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "name" =>
          :- Need(obj.1.String?, "Virtual Field Name must be a string.");
          name := obj.1.str;
        case "parts" => parts :- GetVirtualParts(obj.1);
        case _ => return Failure("Unexpected part of a virtual field : '" + data.obj[i].0 + "'");
      }
    }
    :- Need(0 < |name|, "Each Virtual Field needs a name.");
    :- Need(0 < |parts|, "Each Virtual Field needs at least 1 part.");
    return Success(Types.VirtualField(name := name, parts := parts));
  }

  method GetVirtualParts(data : JSON) returns (output : Result<seq<Types.VirtualPart> , string>)
  {
    :- Need(data.Array?, "Virtual Field Parts list must be an array.");
    var results : seq<Types.VirtualPart> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneVirtualPart(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }

  method GetOneVirtualPart(data : JSON) returns (output : Result<Types.VirtualPart, string>)
  {
    :- Need(data.Object?, "Virtual Part must be an object.");
    var loc : string := "";
    var trans : seq<Types.VirtualTransform> := [];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "loc" =>
          :- Need(obj.1.String?, "Virtual Part Location must be a string.");
          loc := obj.1.str;
        case "trans" => trans :- GetVirtualTransforms(obj.1);
        case _ => return Failure("Unexpected part of a virtual part : '" + data.obj[i].0 + "'");
      }
    }
    :- Need(0 < |loc|, "Each Virtual Part needs a loc.");
    :- Need(0 < |trans|, "Each Virtual Part needs at least 1 transform.");
    return Success(Types.VirtualPart(loc := loc, trans := OptSeq(trans)));
  }

  method GetVirtualTransforms(data : JSON) returns (output : Result<seq<Types.VirtualTransform> , string>)
  {
    :- Need(data.Array?, "Virtual Field Parts list must be an array.");
    var results : seq<Types.VirtualTransform> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneVirtualTransform(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }

  method GetOneVirtualTransform(data : JSON) returns (output : Result<Types.VirtualTransform, string>)
  {
    :- Need(data.Object?, "Virtual Transform must be an object.");
    :- Need(|data.obj| == 1, "Virtual Transform object must be length 1.");
    var obj := data.obj[0];
    match obj.0 {
      case "upper" =>
        :- Need(obj.1.Null?, "Value of upper transform must be null");
        return Success(Types.upper(Types.Upper));
      case "lower" =>
        :- Need(obj.1.Null?, "Value of lower transform must be null");
        return Success(Types.lower(Types.Lower));
      case "insert" => output := GetInsert(obj.1);
      case "prefix" => output := GetPrefix(obj.1);
      case "suffix" => output := GetSuffix(obj.1);
      case "substring" => output := GetSubstring(obj.1);
      case "segment" => output := GetSegment(obj.1);
      case "segments" => output := GetSegments(obj.1);
      case _ => return Failure("Unexpected Virtual Transform : '" + obj.0 + "'");
    }
  }
  method GetInsert(data : JSON) returns (output : Result<Types.VirtualTransform, string>)
    ensures output.Success? ==> output.value.insert?
  {
    :- Need(data.Object?, "GetInsert Value must be an object.");
    var literal : Option<string> := None;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "literal" =>
          :- Need(obj.1.String?, "GetInsert literal must be a string");
          literal := Some(obj.1.str);
        case _ => return Failure("Unexpected part of a GetInsert : '" + obj.0 + "'");
      }
    }
    :- Need(literal.Some?, "Each GetInsert needs a literal.");
    return Success(Types.insert(Types.Insert(literal := literal.value)));
  }

  method GetPrefix(data : JSON) returns (output : Result<Types.VirtualTransform, string>)
    ensures output.Success? ==> output.value.prefix?
  {
    :- Need(data.Object?, "GetPrefix Value must be an object.");
    var length : Option<int32> := None;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "length" =>
          :- Need(obj.1.Number?, "GetPrefix length must be a number");
          var len :- DecimalToInt(obj.1.num);
          :- Need(IsValidInt32(len), "GetPrefix length must be an int32.");
          length := Some(len as int32);
        case _ => return Failure("Unexpected part of a GetPrefix : '" + obj.0 + "'");
      }
    }
    :- Need(length.Some?, "Each GetPrefix needs a length.");
    return Success(Types.prefix(Types.GetPrefix(length := length.value)));
  }

  method GetSuffix(data : JSON) returns (output : Result<Types.VirtualTransform, string>)
    ensures output.Success? ==> output.value.suffix?
  {
    :- Need(data.Object?, "GetSuffix Value must be an object.");
    var length : Option<int32> := None;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "length" =>
          :- Need(obj.1.Number?, "GetSuffix length must be a number");
          var len :- DecimalToInt(obj.1.num);
          :- Need(IsValidInt32(len), "GetSuffix length must be an int32.");
          length := Some(len as int32);
        case _ => return Failure("Unexpected part of a GetSuffix : '" + obj.0 + "'");
      }
    }
    :- Need(length.Some?, "Each GetSuffix needs a length.");
    return Success(Types.suffix(Types.GetSuffix(length := length.value)));
  }

  method GetSubstring(data : JSON) returns (output : Result<Types.VirtualTransform, string>)
    ensures output.Success? ==> output.value.substring?
  {
    :- Need(data.Object?, "GetSubstring Value must be an object.");
    var low : Option<int32> := None;
    var high : Option<int32> := None;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "low" =>
          :- Need(obj.1.Number?, "GetSubstring low must be a number");
          var len :- DecimalToInt(obj.1.num);
          :- Need(IsValidInt32(len), "GetSubstring low must be an int32.");
          low := Some(len as int32);
        case "high" =>
          :- Need(obj.1.Number?, "GetSubstring high must be a number");
          var len :- DecimalToInt(obj.1.num);
          :- Need(IsValidInt32(len), "GetSubstring high must be an int32.");
          high := Some(len as int32);
        case _ => return Failure("Unexpected part of a GetSubstring : '" + obj.0 + "'");
      }
    }
    :- Need(low.Some?, "Each GetSubstring needs a low.");
    :- Need(high.Some?, "Each GetSubstring needs a high.");
    return Success(Types.substring(Types.GetSubstring(low := low.value, high := high.value)));
  }

  method GetSegments(data : JSON) returns (output : Result<Types.VirtualTransform, string>)
    ensures output.Success? ==> output.value.segments?
  {
    :- Need(data.Object?, "GetSegments Value must be an object.");
    var low : Option<int32> := None;
    var high : Option<int32> := None;
    var split : Option<string> := None;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "low" =>
          :- Need(obj.1.Number?, "GetSegments low must be a number");
          var len :- DecimalToInt(obj.1.num);
          :- Need(IsValidInt32(len), "GetSegments low must be an int32.");
          low := Some(len as int32);
        case "high" =>
          :- Need(obj.1.Number?, "GetSegments high must be a number");
          var len :- DecimalToInt(obj.1.num);
          :- Need(IsValidInt32(len), "GetSegments high must be an int32.");
          high := Some(len as int32);
        case "split" =>
          :- Need(obj.1.String?, "GetSegments split must be a string");
          split := Some(obj.1.str);
        case _ => return Failure("Unexpected part of a GetSegments : '" + obj.0 + "'");
      }
    }
    :- Need(low.Some?, "Each GetSegments needs a low.");
    :- Need(high.Some?, "Each GetSegments needs a high.");
    :- Need(split.Some?, "Each GetSegments needs a split.");
    :- Need(|split.value| == 1, "GetSegments split must be length 1.");
    return Success(Types.segments(Types.GetSegments(low := low.value, high := high.value, split := split.value)));
  }

  method GetSegment(data : JSON) returns (output : Result<Types.VirtualTransform, string>)
    ensures output.Success? ==> output.value.segment?
  {
    :- Need(data.Object?, "GetSegment Value must be an object.");
    var index : Option<int32> := None;
    var split : Option<string> := None;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "index" =>
          :- Need(obj.1.Number?, "GetSegment index must be a number");
          var len :- DecimalToInt(obj.1.num);
          :- Need(IsValidInt32(len), "GetSegments low must be an int32.");
          index := Some(len as int32);
        case "split" =>
          :- Need(obj.1.String?, "GetSegments split must be a string");
          split := Some(obj.1.str);
        case _ => return Failure("Unexpected part of a GetSegment : '" + obj.0 + "'");
      }
    }
    :- Need(index.Some?, "Each GetSegments needs a low.");
    :- Need(split.Some?, "Each GetSegments needs a split.");
    :- Need(|split.value| == 1, "GetSegments split must be length 1.");
    return Success(Types.segment(Types.GetSegment(index := index.value, split := split.value)));
  }

  method GetCompoundBeacons(data : JSON) returns (output : Result<seq<Types.CompoundBeacon> , string>)
  {
    :- Need(data.Array?, "Compound Beacon list must be an array.");
    var results : seq<Types.CompoundBeacon> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneCompoundBeacon(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }

  function OptSeq<X>(s : seq<X>) : Option<seq<X>>
  {
    if |s| == 0 then
      None
    else
      Some(s)
  }

  method GetOneCompoundBeacon(data : JSON) returns (output : Result<Types.CompoundBeacon, string>)
  {
    :- Need(data.Object?, "Compound Beacon must be an object.");
    var name : string := "";
    var split : string := ".";
    var Encrypted : seq<Types.EncryptedPart> := [];
    var Signed : seq<Types.SignedPart> := [];
    var constructors : seq<Types.Constructor> := [];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Name" =>
          :- Need(obj.1.String?, "Compound Beacon Name must be a string.");
          name := obj.1.str;
        case "Split" =>
          :- Need(obj.1.String?, "Compound Beacon Split must be a string.");
          :- Need(|obj.1.str| == 1, "Compound Beacon Split must be a string of length 1.");
          split := obj.1.str;
        case "Signed" => Signed :- GetSignedParts(obj.1);
        case "Encrypted" => Encrypted :- GetEncryptedParts(obj.1);
        case "Constructors" => constructors :- GetConstructors(obj.1);
        case _ => return Failure("Unexpected part of a standard beacon : '" + data.obj[i].0 + "'");
      }
    }
    :- Need(0 < |name|, "Each Compound Beacon needs a name.");
    :- Need(|split| == 1, "Split for Compound Beacon must be length 1.");
    return Success(Types.CompoundBeacon(name := name, split := split, encrypted := OptSeq(Encrypted), signed := OptSeq(Signed), constructors := OptSeq(constructors)));
  }

  // datatype Type = Type
  // method JsonToType(data : JSON) returns (output : Result<Type, string>)

  method GetConstructors(data : JSON) returns (output : Result<seq<Types.Constructor> , string>)
  {
    :- Need(data.Array?, "Constructor list must be an array.");
    var results : seq<Types.Constructor> := [];
    for i := 0 to |data.arr| {
      :- Need(data.arr[i].Array?, "Constructors must be an arrays.");
      var result : seq<Types.ConstructorPart> := [];
      for j := 0 to |data.arr[i].arr| {
        var item :- GetOneConstructorPart(data.arr[i].arr[j]);
        result := result + [item];
      }
      :- Need(0 < |result|, "Constructor Part List must have at least one item.");
      results := results + [Types.Constructor(parts := result)];
    }
    return Success(results);
  }
  method GetOneConstructorPart(data : JSON) returns (output : Result<Types.ConstructorPart, string>)
  {
    :- Need(data.Object?, "Constructor Part must be an object.");
    var name : string := "";
    var req : bool := true;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Name" =>
          :- Need(obj.1.String?, "Constructor Part Name must be a string");
          name := obj.1.str;
        case "Required" =>
          :- Need(obj.1.Bool?, "Constructor Part Required must be a bool");
          req := obj.1.b;
        case _ => return Failure("Unexpected part of a constructor part : '" + obj.0 + "'");
      }
    }
    :- Need(0 < |name|, "Each Constructor Part needs a name.");
    return Success(Types.ConstructorPart(name := name, required := req));
  }

  method GetSignedParts(data : JSON) returns (output : Result<seq<Types.SignedPart> , string>)
  {
    :- Need(data.Array?, "Signed Parts list must be an array.");
    var results : seq<Types.SignedPart> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneSignedPart(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }

  method GetOneSignedPart(data : JSON) returns (output : Result<Types.SignedPart, string>)
  {
    :- Need(data.Object?, "Signed Part must be an object.");
    var name : string := "";
    var prefix : string := "";
    var loc : Option<Types.TerminalLocation> := None;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Name" =>
          :- Need(obj.1.String?, "Signed Part Name must be a string");
          name := obj.1.str;
        case "Prefix" =>
          :- Need(obj.1.String?, "Signed Part Prefix must be a string");
          prefix := obj.1.str;
        case "Loc" =>
          :- Need(obj.1.String?, "Signed Part Location must be a string");
          :- Need(0 < |obj.1.str|, "Signed Part Location must be a non-empty string");
          loc := Some(obj.1.str);
        case _ => return Failure("Unexpected part of a Signed part : '" + obj.0 + "'");
      }
    }
    :- Need(0 < |name|, "Each Signed Part needs a name.");
    :- Need(0 < |prefix|, "Each Signed Part needs a prefix.");
    return Success(Types.SignedPart(name := name, prefix := prefix, loc := loc));
  }

  method GetEncryptedParts(data : JSON) returns (output : Result<seq<Types.EncryptedPart> , string>)
  {
    :- Need(data.Array?, "Encrypted Parts list must be an array.");
    var results : seq<Types.EncryptedPart> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneEncryptedPart(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }
  method GetOneEncryptedPart(data : JSON) returns (output : Result<Types.EncryptedPart, string>)
  {
    :- Need(data.Object?, "Encrypted Part must be an object.");
    var name : string := "";
    var prefix : string := "";
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Name" =>
          :- Need(obj.1.String?, "Encrypted Part Name must be a string");
          name := obj.1.str;
        case "Prefix" =>
          :- Need(obj.1.String?, "Encrypted Part Prefix must be a string");
          prefix := obj.1.str;
        case _ => return Failure("Unexpected part of an Encrypted part : '" + obj.0 + "'");
      }
    }
    :- Need(0 < |name|, "Each Encrypted Part needs a name.");
    :- Need(0 < |prefix|, "Each Encrypted Part needs a prefix.");
    return Success(Types.EncryptedPart(name := name, prefix := prefix));
  }

  method GetStandardBeacons(data : JSON) returns (output : Result<seq<Types.StandardBeacon> , string>)
  {
    :- Need(data.Array?, "Standard Beacon list must be an array.");
    var results : seq<Types.StandardBeacon> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneStandardBeacon(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }
  method GetOneStandardBeacon(data : JSON) returns (output : Result<Types.StandardBeacon, string>)
  {
    :- Need(data.Object?, "Standard Beacon must be an object.");
    var name : string := "";
    var length : int := -1;
    var loc : Option<Types.TerminalLocation> := None;
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Name" =>
          :- Need(obj.1.String?, "Standard Beacon Name must be a string");
          name := obj.1.str;
        case "Length" =>
          :- Need(obj.1.Number?, "Standard Beacon length must be a number");
          length :- DecimalToNat(obj.1.num);
        case "Loc" =>
          :- Need(obj.1.String?, "Standard Beacon Location must be a string");
          :- Need(0 < |obj.1.str|, "Standard Beacon Location must nt be an empty string.");
          loc := Some(obj.1.str);
        case _ => return Failure("Unexpected part of a standard beacon : '" + data.obj[i].0 + "'");
      }
    }
    :- Need(0 < |name|, "Each Standard Beacon needs a name.");
    :- Need(0 < length < 100 && Types.IsValid_BeaconBitLength(length as int32), "Each Standard Beacon needs a length between 1 and 63.");
    return Success(Types.StandardBeacon(name := name, length := length as Types.BeaconBitLength, loc := loc, style := None));
  }

  method GetGSIs(data : JSON) returns (output : Result<seq<DDB.GlobalSecondaryIndex> , string>)
  {
    :- Need(data.Array?, "GSI list must be an array.");
    var results : seq<DDB.GlobalSecondaryIndex> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneGSI(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }
  method GetOneGSI(data : JSON) returns (output : Result<DDB.GlobalSecondaryIndex, string>)
  {
    :- Need(data.Array?, "Each GSI must be an array.");
    :- Need(2 <= |data.arr| <= 3, "Each GSI must be an array of length 2 or 3.");
    :- Need(forall k <- data.arr :: k.String?, "Each GSI must be an array of strings");
    :- Need(DDB.IsValid_IndexName(data.arr[0].str), data.arr[0].str + " is not a valid IndexName.");
    :- Need(DDB.IsValid_KeySchemaAttributeName(data.arr[1].str), data.arr[1].str + " is not a valid KeySchemaAttributeName.");

    var schema : DDB.KeySchema := [DDB.KeySchemaElement(
                                     AttributeName := data.arr[1].str,
                                     KeyType := DDB.KeyType.HASH
                                   )];

    if |data.arr| == 3 {
      :- Need(DDB.IsValid_KeySchemaAttributeName(data.arr[2].str), data.arr[2].str + " is not a valid KeySchemaAttributeName.");
      var range := DDB.KeySchemaElement(
        AttributeName := data.arr[2].str,
        KeyType := DDB.KeyType.RANGE
      );
      schema := schema + [range];
    }
    return Success(DDB.GlobalSecondaryIndex(
                     IndexName := data.arr[0].str,
                     KeySchema := schema,
                     Projection := DDB.Projection(
                       ProjectionType := None,
                       NonKeyAttributes := None
                     ),
                     ProvisionedThroughput := None
                   ));
  }

  method GetIoTests(data : JSON) returns (output : Result<seq<IoTest> , string>)
  {
    :- Need(data.Object?, "IoTests must be an object.");
    var results : seq<IoTest> := [];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      var item :- GetOneIoTest(obj.0, obj.1);
      results := results + [item];
    }
    return Success(results);
  }

  method GetOneIoTest(name : string, data : JSON) returns (output : Result<IoTest, string>)
  {
    :- Need(data.Object?, "IoTest must be an object.");
    var readConfig : Option<TableConfig> := None;
    var writeConfig : Option<TableConfig> := None;
    var names : DDB.ExpressionAttributeNameMap := map[];
    var values : DDB.ExpressionAttributeValueMap := map[];
    var queries : seq<SimpleQuery> := [];
    var records : seq<Record>  := [];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "WriteConfig" => var config :- GetOneTableConfig(obj.0, obj.1); writeConfig := Some(config);
        case "ReadConfig" => var config :- GetOneTableConfig(obj.0, obj.1); readConfig := Some(config);
        case "Records" => records :- GetRecords(obj.1);
        case "Values" => values :- GetValueMap(data.obj[i].1);
        case "Queries" => queries :- GetSimpleQueries(data.obj[i].1);
        case _ => return Failure("Unexpected part of a complex test : '" + obj.0 + "'");
      }
    }
    :- Need(writeConfig.Some?, "An IoTest needs a writeConfig");
    :- Need(0 < |records|, "An IoTest needs at least one record");
    if readConfig.Some? {
      return Success(IoTest(name, writeConfig.value, readConfig.value, records, names, values, queries));
    } else {
      return Success(IoTest(name, writeConfig.value, writeConfig.value, records, names, values, queries));
    }
  }

  method GetComplexTests(data : JSON) returns (output : Result<seq<ComplexTest> , string>)
  {
    :- Need(data.Array?, "Queries must be an array.");
    var results : seq<ComplexTest> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneComplexTest(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }
  method GetOneComplexTest(data : JSON) returns (output : Result<ComplexTest, string>)
  {
    :- Need(data.Object?, "Complex Query must be an object.");
    var config : ConfigName := "";
    var queries : seq<ComplexQuery>  := [];
    var failures : seq<SimpleQuery>  := [];
    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Config" =>
          :- Need(obj.1.String?, "Complex config name must be a string.");
          config := obj.1.str;
        case "Queries" => queries :- GetComplexQueries(obj.1);
        case "Failing" => failures :- GetSimpleQueries(obj.1);
        case _ => return Failure("Unexpected part of a complex test : '" + obj.0 + "'");
      }
    }
    :- Need(|config| >= 0, "Every complex test must specify a config");
    return Success(ComplexTest(config, queries, failures));
  }

  method GetValueMap(data : JSON) returns (output : Result<DDB.ExpressionAttributeValueMap, string>)
  {
    :- Need(data.Object?, "Value Map must be an object.");
    var results : DDB.ExpressionAttributeValueMap := map[];
    for i := 0 to |data.obj| {
      var value :- GetAttrValue(data.obj[i].1);
      results := results[data.obj[i].0 := value];
    }
    return Success(results);
  }

  method GetNameMap(data : JSON) returns (output : Result<DDB.ExpressionAttributeNameMap, string>)
  {
    :- Need(data.Object?, "Name Map must be an object.");
    var results : DDB.ExpressionAttributeNameMap := map[];
    for i := 0 to |data.obj| {
      :- Need(data.obj[i].1.String?, "");
      :- Need(DDB.IsValid_AttributeName(data.obj[i].1.str), "");
      results := results[data.obj[i].0 := data.obj[i].1.str];
    }
    return Success(results);
  }

  method GetComplexQueries(data : JSON) returns (output : Result<seq<ComplexQuery> , string>)
  {
    :- Need(data.Array?, "Queries must be an array.");
    var results : seq<ComplexQuery> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneComplex(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }
  method GetOneComplex(data : JSON) returns (output : Result<ComplexQuery, string>)
  {
    :- Need(data.Object?, "");
    var query : Option<SimpleQuery> := None;
    var pass : seq<string> := [];
    var fail : seq<string> := [];

    for i := 0 to |data.obj| {
      var obj := data.obj[i];
      match obj.0 {
        case "Query" =>
          var q :- GetOneQuery(obj.1);
          query := Some(q);
        case "Pass" => pass :- GetNumberStrings(obj.1);
        case "Fail" => fail :- GetNumberStrings(obj.1);
        case _ => return Failure("Unexpected part of a query : '" + data.obj[i].0 + "'");
      }
    }
    :- Need(query.Some?, "");
    return Success(ComplexQuery(query.value, pass, fail));
  }

  method GetNumberStrings(data : JSON) returns (output : Result<seq<string> , string>)
  {
    :- Need(data.Array?, "Number lists must be arrays");
    var results : seq<string> := [];
    for i := 0 to |data.arr| {
      var obj := data.arr[i];
      :- Need(obj.Number?, "");
      var val :- DecimalToNat(obj.num);
      results := results + [String.Base10Int2String(val)];
    }
    return Success(results);
  }

  method GetNumbers(data : JSON) returns (output : Result<seq<nat> , string>)
  {
    :- Need(data.Array?, "Number lists must be arrays");
    var results : seq<nat> := [];
    for i := 0 to |data.arr| {
      var obj := data.arr[i];
      :- Need(obj.Number?, "");
      var val :- DecimalToNat(obj.num);
      results := results + [val];
    }
    return Success(results);
  }

  method GetSimpleQueries(data : JSON) returns (output : Result<seq<SimpleQuery> , string>)
  {
    :- Need(data.Array?, "Queries must be an array.");
    var results : seq<SimpleQuery> := [];
    for i := 0 to |data.arr| {
      var item :- GetOneQuery(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }
  method GetOneQuery(data : JSON) returns (output : Result<SimpleQuery, string>)
  {
    if data.String? {
      return Success(SimpleQuery(None, None, Some(data.str), []));
    } else if data.Object? {
      var index : Option<DDB.IndexName> := None;
      var keyExpr : Option<string> := None;
      var filterExpr : Option<string> := None;
      var failConfigs : seq<ConfigName> := [];
      for i := 0 to |data.obj| {
        match data.obj[i].0 {
          case "Index" =>
            :- Need(data.obj[i].1.String?, "Index for query ust be of type string.");
            :- Need(DDB.IsValid_IndexName(data.obj[i].1.str), "Not a valid index name : '" + data.obj[i].1.str + "'");
            index := Some(data.obj[i].1.str);
          case "Key" =>
            :- Need(data.obj[i].1.String?, "Key expression for query ust be of type string.");
            keyExpr := Some(data.obj[i].1.str);
          case "Filter" =>
            :- Need(data.obj[i].1.String?, "Filter expression for query ust be of type string.");
            filterExpr := Some(data.obj[i].1.str);
          case "Fail" => failConfigs :- GetStrings(data.obj[i].1);
          case _ => return Failure("Unexpected part of a query : '" + data.obj[i].0 + "'");
        }
      }
      return Success(SimpleQuery(index, keyExpr, filterExpr, failConfigs));
    } else {
      return Failure("Individual Query must be a string or an object.");
    }
  }

  method GetPairs(data : JSON) returns (output : Result<PairList, string>)
  {
    :- Need(data.Array?, "Config Pairs must be an array of arrays.");
    var results : PairList := [];
    for i := 0 to |data.arr| {
      var item :- GetOnePair(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }

  function GetPower(n : int, pow : nat) : int
  {
    if pow == 0 then
      n
    else
      10 * GetPower(n, pow-1)
  }

  function DecimalToNat(num: Decimal) : Result<nat, string>
  {
    var val :- DecimalToInt(num);
    :- Need(val >= 0, "Number must be > 0");
    Success(val)
  }

  function DecimalToInt(num: Decimal) : Result<int, string>
  {
    if num.n == 0 then
      Success(0)
    else
      :- Need(num.e10 >= 0, "Number must be a whole number");
      :- Need(num.e10 < 100, "Number must be less than a googol");
      Success(GetPower(num.n, num.e10))
  }

  function GetOnePair(data : JSON) : Result<ConfigPair, string>
  {
    :- Need(data.Array? && |data.arr| == 2 && data.arr[0].String? && data.arr[1].String?, "A Config Pair must be an array of two strings.");
    var p1 := data.arr[0].str;
    var p2 := data.arr[1].str;
    Success((p1, p2))
  }

  method GetRecords(data : JSON) returns (output : Result<seq<Record>, string>)
  {
    :- Need(data.Array?, "Records must be an array of JSON objects.");
    var results : seq<Record> := [];
    for i := 0 to |data.arr| {
      var item :- GetRecord(data.arr[i]);
      results := results + [item];
    }
    return Success(results);
  }


  method GetRecord(data : JSON) returns (output : Result<Record, string>)
  {
    var item :- JsonToDdbItem(data);
    if HashName !in item {
      return Failure("Every record must specify the " + HashName + " field");
    }
    var hash := item[HashName];
    if !hash.N? {
      return Failure("Value for " + HashName + " must be a number");
    }
    var num :- StrToNat(hash.N);
    return Success(Record(num, item));
  }

}
