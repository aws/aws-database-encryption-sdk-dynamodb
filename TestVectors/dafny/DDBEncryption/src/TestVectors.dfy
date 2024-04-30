// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypesWrapped.dfy"
include "CreateInterceptedDDBClient.dfy"
include "JsonItem.dfy"
include "WriteManifest.dfy"
include "EncryptManifest.dfy"
include "DecryptManifest.dfy"
include "JsonConfig.dfy"

module {:options "-functionSyntax:4"} DdbEncryptionTestVectors {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.String
  import JSON.API
  import opened JSON.Values
  import JSON.Errors
  import opened DynamoDbEncryptionUtil
  import opened DdbItemJson
  import opened JsonConfig

  import WriteManifest
  import EncryptManifest
  import DecryptManifest
  import FileIO
  import opened JSONHelpers
  import Norm = DynamoDbNormalizeNumber
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import DDB = ComAmazonawsDynamodbTypes
  import Filter = DynamoDBFilterExpr
  import SE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import UTF8
  import CMP = AwsCryptographyMaterialProvidersTypes
  import CreateInterceptedDDBClient
  import SortedSets
  import Seq
  import SI = SearchableEncryptionInfo
  import MaterialProviders
  import MPT = AwsCryptographyMaterialProvidersTypes
  import Aws.Cryptography.Primitives
  import ParseJsonManifests


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
    roundTripTests : seq<RoundTripTest>,
    decryptTests : seq<DecryptTest>,
    strings : seq<string>
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
      print |strings|, " strings.\n";
      if |roundTripTests| != 0 {
        print |roundTripTests[0].configs|, " configs and ", |roundTripTests[0].records|, " records for round trip.\n";
      }
      if |roundTripTests| > 1 {
        print |roundTripTests[1].configs|, " configs and ", |roundTripTests[1].records|, " records for round trip.\n";
      }

      var _ :- expect DecryptManifest.Decrypt("decrypt_dotnet_32.json");
      var _ :- expect DecryptManifest.Decrypt("decrypt_java_32.json");
      var _ :- expect DecryptManifest.Decrypt("decrypt_dotnet_33.json");
      var _ :- expect DecryptManifest.Decrypt("decrypt_java_33.json");
      var _ :- expect DecryptManifest.Decrypt("decrypt_dotnet_33a.json");
      var _ :- expect DecryptManifest.Decrypt("decrypt_java_33a.json");
      var _ :- expect WriteManifest.Write("encrypt.json");
      var _ :- expect EncryptManifest.Encrypt("encrypt.json", "decrypt.json", "java", "3.3");
      var _ :- expect DecryptManifest.Decrypt("decrypt.json");
      if |globalRecords| + |tableEncryptionConfigs| + |queries| == 0 {
        print "\nRunning no tests\n";
        return;
      }
      Validate();
      StringOrdering();
      BasicIoTest();
      RunIoTests();
      BasicQueryTest();
      ConfigModTest();
      ComplexTests();
      WriteTests();
      RoundTripTests();
      DecryptTests();
      var client :- expect CreateInterceptedDDBClient.CreateVanillaDDBClient();
      DeleteTable(client);
    }

    function NewOrderRecord(i : nat, str : string) : Record
    {
      var n := String.Base10Int2String(i);
      var m : DDB.AttributeMap := map[HashName := DDB.AttributeValue.N(n), "StrValue" := DDB.AttributeValue.S(str)];
      Record(i, m)
    }

    method StringOrdering() {
      print "StringOrdering\n";
      var client :- expect CreateInterceptedDDBClient.CreateVanillaDDBClient();
      var records : seq<Record> := [];
      for i := 0 to |strings| {
        records := records + [NewOrderRecord(i, strings[i])];
      }
      WriteAllRecords(client, records);
      var subRecords := Seq.Map((r : Record) => r.item, records);
      var ops := ["<", "<=", ">", ">=", "=", "<>"];
      for i := 0 to |strings| {
        for j := 0 to |ops| {
          var expr := Some("StrValue " + ops[j] + " :val");
          var vals := Some(map[":val" := DDB.AttributeValue.S(strings[i])]);
          var query := SimpleQuery(None, None, expr, []);
          var items1 := FullScan(client, query, Some(map[]), vals);
          var bv :- expect GetFakeBeaconVersion();
          var items2 :- expect Filter.FilterResults(bv, subRecords, None, expr, None, vals);
          CompareRecordsDisordered2(items1, items2);
        }
      }
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
        if result.Items.Some? && |result.Items.value| != 0 {
          output := output + result.Items.value;
        }
        if result.LastEvaluatedKey.Some? && 0 < |result.LastEvaluatedKey.value| {
          lastKey := result.LastEvaluatedKey;
          print "FullQuery had lastKey\n";
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
        if result.Items.Some? && |result.Items.value| != 0 {
          output := output + result.Items.value;
        }
        if result.LastEvaluatedKey.Some? && 0 < |result.LastEvaluatedKey.value| {
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

    method RoundTripTests()
    {
      print "RoundTripTests\n";
      for i := 0 to |roundTripTests| {

        var configs := roundTripTests[i].configs;
        var records := roundTripTests[i].records;
        var keys := SortedSets.ComputeSetToOrderedSequence2(configs.Keys, CharLess);

        for j := 0 to |keys| {
          var client :- expect newGazelle(configs[keys[j]]);
          for k := 0 to |records| {
            OneRoundTripTest(client, records[k]);
          }
        }
      }
    }

    method OneRoundTripTest(client : DDB.IDynamoDBClient, record : Record)
      requires client.ValidState()
      ensures client.ValidState()
      modifies client.Modifies
    {
      var putInput := DDB.PutItemInput(
        TableName := TableName,
        Item := record.item,
        Expected := None,
        ReturnValues := None,
        ReturnConsumedCapacity := None,
        ReturnItemCollectionMetrics := None,
        ConditionalOperator := None,
        ConditionExpression := None,
        ExpressionAttributeNames := None,
        ExpressionAttributeValues := None
      );
      var _ :-  expect client.PutItem(putInput);
      expect HashName in record.item;
      var getInput := DDB.GetItemInput(
        TableName := TableName,
        Key := map[HashName := record.item[HashName]],
        AttributesToGet := None,
        ConsistentRead := None,
        ReturnConsumedCapacity := None,
        ProjectionExpression := None,
        ExpressionAttributeNames := None
      );
      var out :- expect client.GetItem(getInput);
      expect out.Item.Some?;
      if NormalizeItem(out.Item.value) != NormalizeItem(record.item) {
        print "\n", NormalizeItem(out.Item.value), "\n", NormalizeItem(record.item), "\n";
      }
      expect NormalizeItem(out.Item.value) == NormalizeItem(record.item);
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
      var results := new DDB.ItemList[|queries|](i => []);
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
        if NormalizeItem(actual[i]) == exp {
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
    method CompareRecordsDisordered2(expected : DDB.ItemList, actual : DDB.ItemList)
    {
      expect |expected| == |actual|;
      var bad := false;
      for i := 0 to |expected| {
        var found := FindMatchingRecord(expected[i], actual);
        if !found {
          print "Did not find result for record ", expected[i], "\n";
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
        expect result.UnprocessedKeys.None? || |result.UnprocessedKeys.value| == 0;
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
    TestVectorConfig(MakeCreateTableInput(), [], map[], [], map[], map[], [], [], [], [], [], [], [], [], [])
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
    var roundTripTests : seq<RoundTripTest> := [];
    var decryptTests : seq<DecryptTest> := [];
    var strings : seq<string> := [];

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
        case "RoundTripTest" => roundTripTests :- GetRoundTripTests(data.obj[i].1);
        case "DecryptTests" => decryptTests :- GetDecryptTests(data.obj[i].1);
        case "Strings" => strings :- GetStrings(data.obj[i].1);
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
        roundTripTests := prev.roundTripTests + roundTripTests,
        decryptTests := prev.decryptTests + decryptTests,
        strings := prev.strings + strings
      )
    );
  }
}
