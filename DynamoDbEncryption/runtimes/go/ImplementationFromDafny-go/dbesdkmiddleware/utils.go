package dbesdkmiddleware

import (
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

// deepCopyPutItemInput performs a deep copy of a PutItemInput struct.
func deepCopyPutItemInput(input *dynamodb.PutItemInput) *dynamodb.PutItemInput {
	if input == nil {
		return nil
	}

	copyItem := make(map[string]types.AttributeValue, len(input.Item))
	for k, v := range input.Item {
		copyItem[k] = deepCopyAttributeValue(v)
	}

	copyExpected := make(map[string]types.ExpectedAttributeValue, len(input.Expected))
	for k, v := range input.Expected {
		copyExpected[k] = v
	}

	copyExprNames := make(map[string]string, len(input.ExpressionAttributeNames))
	for k, v := range input.ExpressionAttributeNames {
		copyExprNames[k] = v
	}

	copyExprValues := make(map[string]types.AttributeValue, len(input.ExpressionAttributeValues))
	for k, v := range input.ExpressionAttributeValues {
		copyExprValues[k] = deepCopyAttributeValue(v)
	}

	var tableName *string
	if input.TableName != nil {
		t := *input.TableName
		tableName = &t
	}

	var conditionExpression *string
	if input.ConditionExpression != nil {
		ce := *input.ConditionExpression
		conditionExpression = &ce
	}

	return &dynamodb.PutItemInput{
		Item:                                copyItem,
		TableName:                           tableName,
		ConditionExpression:                 conditionExpression,
		ConditionalOperator:                 input.ConditionalOperator,
		Expected:                            copyExpected,
		ExpressionAttributeNames:            copyExprNames,
		ExpressionAttributeValues:           copyExprValues,
		ReturnConsumedCapacity:              input.ReturnConsumedCapacity,
		ReturnItemCollectionMetrics:         input.ReturnItemCollectionMetrics,
		ReturnValues:                        input.ReturnValues,
		ReturnValuesOnConditionCheckFailure: input.ReturnValuesOnConditionCheckFailure,
	}
}

// deepCopyGetItemInput performs a deep copy of a GetItemInput struct.
func deepCopyGetItemInput(input *dynamodb.GetItemInput) *dynamodb.GetItemInput {
	if input == nil {
		return nil
	}

	copyKey := make(map[string]types.AttributeValue, len(input.Key))
	for k, v := range input.Key {
		copyKey[k] = deepCopyAttributeValue(v)
	}

	copyExprNames := make(map[string]string, len(input.ExpressionAttributeNames))
	for k, v := range input.ExpressionAttributeNames {
		copyExprNames[k] = v
	}

	copyAttributesToGet := make([]string, len(input.AttributesToGet))
	copy(copyAttributesToGet, input.AttributesToGet)

	var tableName *string
	if input.TableName != nil {
		t := *input.TableName
		tableName = &t
	}

	var projectionExpression *string
	if input.ProjectionExpression != nil {
		pe := *input.ProjectionExpression
		projectionExpression = &pe
	}

	var consistentRead *bool
	if input.ConsistentRead != nil {
		cr := *input.ConsistentRead
		consistentRead = &cr
	}

	return &dynamodb.GetItemInput{
		Key:                      copyKey,
		TableName:                tableName,
		AttributesToGet:          copyAttributesToGet,
		ConsistentRead:           consistentRead,
		ExpressionAttributeNames: copyExprNames,
		ProjectionExpression:     projectionExpression,
		ReturnConsumedCapacity:   input.ReturnConsumedCapacity,
	}
}

// deepCopyBatchGetItemInput performs a deep copy of a BatchGetItemInput struct.
func deepCopyBatchGetItemInput(input *dynamodb.BatchGetItemInput) *dynamodb.BatchGetItemInput {
	if input == nil {
		return nil
	}

	// Deep copy RequestItems map
	copyRequestItems := make(map[string]types.KeysAndAttributes, len(input.RequestItems))
	for tableName, keysAndAttrs := range input.RequestItems {
		copyRequestItems[tableName] = deepCopyKeysAndAttributes(keysAndAttrs)
	}

	return &dynamodb.BatchGetItemInput{
		RequestItems:           copyRequestItems,
		ReturnConsumedCapacity: input.ReturnConsumedCapacity,
	}
}

// deepCopyBatchExecuteStatementInput performs a deep copy of a BatchExecuteStatementInput struct.
func deepCopyBatchExecuteStatementInput(input *dynamodb.BatchExecuteStatementInput) *dynamodb.BatchExecuteStatementInput {
	if input == nil {
		return nil
	}

	copyStatements := make([]types.BatchStatementRequest, len(input.Statements))
	for i, stmt := range input.Statements {
		copyStatements[i] = deepCopyBatchStatementRequest(stmt)
	}

	return &dynamodb.BatchExecuteStatementInput{
		Statements:             copyStatements,
		ReturnConsumedCapacity: input.ReturnConsumedCapacity,
	}
}

// deepCopyBatchWriteItemInput performs a deep copy of a BatchWriteItemInput struct.
func deepCopyBatchWriteItemInput(input *dynamodb.BatchWriteItemInput) *dynamodb.BatchWriteItemInput {
	if input == nil {
		return nil
	}

	copyRequestItems := make(map[string][]types.WriteRequest, len(input.RequestItems))
	for tableName, writeRequests := range input.RequestItems {
		copyRequests := make([]types.WriteRequest, len(writeRequests))
		for i, req := range writeRequests {
			copyRequests[i] = deepCopyWriteRequest(req)
		}
		copyRequestItems[tableName] = copyRequests
	}

	return &dynamodb.BatchWriteItemInput{
		RequestItems:                copyRequestItems,
		ReturnConsumedCapacity:      input.ReturnConsumedCapacity,
		ReturnItemCollectionMetrics: input.ReturnItemCollectionMetrics,
	}
}

// deepCopyDeleteItemInput performs a deep copy of a DeleteItemInput struct.
func deepCopyDeleteItemInput(input *dynamodb.DeleteItemInput) *dynamodb.DeleteItemInput {
	if input == nil {
		return nil
	}

	copyKey := deepCopyAttributeMap(input.Key)

	copyExpected := make(map[string]types.ExpectedAttributeValue, len(input.Expected))
	for k, v := range input.Expected {
		copyExpected[k] = v
	}

	copyExprNames := make(map[string]string, len(input.ExpressionAttributeNames))
	for k, v := range input.ExpressionAttributeNames {
		copyExprNames[k] = v
	}

	copyExprValues := deepCopyAttributeMap(input.ExpressionAttributeValues)

	var tableName *string
	if input.TableName != nil {
		t := *input.TableName
		tableName = &t
	}

	var conditionExpression *string
	if input.ConditionExpression != nil {
		ce := *input.ConditionExpression
		conditionExpression = &ce
	}
	return &dynamodb.DeleteItemInput{
		Key:                                 copyKey,
		TableName:                           tableName,
		ConditionExpression:                 conditionExpression,
		ConditionalOperator:                 input.ConditionalOperator,
		Expected:                            copyExpected,
		ExpressionAttributeNames:            copyExprNames,
		ExpressionAttributeValues:           copyExprValues,
		ReturnConsumedCapacity:              input.ReturnConsumedCapacity,
		ReturnItemCollectionMetrics:         input.ReturnItemCollectionMetrics,
		ReturnValues:                        input.ReturnValues,
		ReturnValuesOnConditionCheckFailure: input.ReturnValuesOnConditionCheckFailure,
	}
}

// deepCopyExecuteStatementInput performs a deep copy of an ExecuteStatementInput struct.
func deepCopyExecuteStatementInput(input *dynamodb.ExecuteStatementInput) *dynamodb.ExecuteStatementInput {
	if input == nil {
		return nil
	}

	var statement *string
	if input.Statement != nil {
		s := *input.Statement
		statement = &s
	}
	var nextToken *string
	if input.NextToken != nil {
		nt := *input.NextToken
		nextToken = &nt
	}

	var consistentRead *bool
	if input.ConsistentRead != nil {
		cr := *input.ConsistentRead
		consistentRead = &cr
	}

	var limit *int32
	if input.Limit != nil {
		l := *input.Limit
		limit = &l
	}

	copyParams := make([]types.AttributeValue, len(input.Parameters))
	for i, param := range input.Parameters {
		copyParams[i] = deepCopyAttributeValue(param)
	}
	return &dynamodb.ExecuteStatementInput{
		Statement:                           statement,
		ConsistentRead:                      consistentRead,
		Limit:                               limit,
		NextToken:                           nextToken,
		Parameters:                          copyParams,
		ReturnConsumedCapacity:              input.ReturnConsumedCapacity,
		ReturnValuesOnConditionCheckFailure: input.ReturnValuesOnConditionCheckFailure,
	}
}

// deepCopyExecuteTransactionInput performs a deep copy of an ExecuteTransactionInput struct.
func deepCopyExecuteTransactionInput(input *dynamodb.ExecuteTransactionInput) *dynamodb.ExecuteTransactionInput {
	if input == nil {
		return nil
	}

	copyStatements := make([]types.ParameterizedStatement, len(input.TransactStatements))
	for i, stmt := range input.TransactStatements {
		copyStatements[i] = deepCopyParameterizedStatement(stmt)
	}

	var clientRequestToken *string
	if input.ClientRequestToken != nil {
		token := *input.ClientRequestToken
		clientRequestToken = &token
	}

	return &dynamodb.ExecuteTransactionInput{
		TransactStatements:     copyStatements,
		ClientRequestToken:     clientRequestToken,
		ReturnConsumedCapacity: input.ReturnConsumedCapacity,
	}
}

// deepCopyQueryInput performs a deep copy of a QueryInput struct.
func deepCopyQueryInput(input *dynamodb.QueryInput) *dynamodb.QueryInput {
	if input == nil {
		return nil
	}

	var tableName *string
	if input.TableName != nil {
		t := *input.TableName
		tableName = &t
	}

	var filterExpression *string
	if input.FilterExpression != nil {
		fe := *input.FilterExpression
		filterExpression = &fe
	}

	var indexName *string
	if input.IndexName != nil {
		in := *input.IndexName
		indexName = &in
	}

	var keyConditionExpression *string
	if input.KeyConditionExpression != nil {
		kce := *input.KeyConditionExpression
		keyConditionExpression = &kce
	}

	var projectionExpression *string
	if input.ProjectionExpression != nil {
		pe := *input.ProjectionExpression
		projectionExpression = &pe
	}

	var consistentRead *bool
	if input.ConsistentRead != nil {
		cr := *input.ConsistentRead
		consistentRead = &cr
	}
	var scanIndexForward *bool
	if input.ScanIndexForward != nil {
		sif := *input.ScanIndexForward
		scanIndexForward = &sif
	}

	var limit *int32
	if input.Limit != nil {
		l := *input.Limit
		limit = &l
	}

	copyAttributesToGet := make([]string, len(input.AttributesToGet))
	copy(copyAttributesToGet, input.AttributesToGet)

	copyExclusiveStartKey := deepCopyAttributeMap(input.ExclusiveStartKey)
	copyExpressionAttributeNames := deepCopyStringMap(input.ExpressionAttributeNames)
	copyExpressionAttributeValues := deepCopyAttributeMap(input.ExpressionAttributeValues)
	copyKeyConditions := deepCopyConditionMap(input.KeyConditions)
	copyQueryFilter := deepCopyConditionMap(input.QueryFilter)

	return &dynamodb.QueryInput{
		TableName:                 tableName,
		AttributesToGet:           copyAttributesToGet,
		ConditionalOperator:       input.ConditionalOperator,
		ConsistentRead:            consistentRead,
		ExclusiveStartKey:         copyExclusiveStartKey,
		ExpressionAttributeNames:  copyExpressionAttributeNames,
		ExpressionAttributeValues: copyExpressionAttributeValues,
		FilterExpression:          filterExpression,
		IndexName:                 indexName,
		KeyConditionExpression:    keyConditionExpression,
		KeyConditions:             copyKeyConditions,
		Limit:                     limit,
		ProjectionExpression:      projectionExpression,
		QueryFilter:               copyQueryFilter,
		ReturnConsumedCapacity:    input.ReturnConsumedCapacity,
		ScanIndexForward:          scanIndexForward,
		Select:                    input.Select,
	}
}

// deepCopyScanInput performs a deep copy of a ScanInput struct.
func deepCopyScanInput(input *dynamodb.ScanInput) *dynamodb.ScanInput {
	if input == nil {
		return nil
	}

	var tableName *string
	if input.TableName != nil {
		t := *input.TableName
		tableName = &t
	}

	var filterExpression *string
	if input.FilterExpression != nil {
		fe := *input.FilterExpression
		filterExpression = &fe
	}

	var indexName *string
	if input.IndexName != nil {
		in := *input.IndexName
		indexName = &in
	}

	var projectionExpression *string
	if input.ProjectionExpression != nil {
		pe := *input.ProjectionExpression
		projectionExpression = &pe
	}

	var consistentRead *bool
	if input.ConsistentRead != nil {
		cr := *input.ConsistentRead
		consistentRead = &cr
	}

	var limit *int32
	if input.Limit != nil {
		l := *input.Limit
		limit = &l
	}

	var segment *int32
	if input.Segment != nil {
		s := *input.Segment
		segment = &s
	}

	var totalSegments *int32
	if input.TotalSegments != nil {
		ts := *input.TotalSegments
		totalSegments = &ts
	}

	copyAttributesToGet := make([]string, len(input.AttributesToGet))
	copy(copyAttributesToGet, input.AttributesToGet)

	copyExclusiveStartKey := deepCopyAttributeMap(input.ExclusiveStartKey)
	copyExpressionAttributeNames := deepCopyStringMap(input.ExpressionAttributeNames)
	copyExpressionAttributeValues := deepCopyAttributeMap(input.ExpressionAttributeValues)
	copyScanFilter := deepCopyConditionMap(input.ScanFilter)

	return &dynamodb.ScanInput{
		TableName:                 tableName,
		AttributesToGet:           copyAttributesToGet,
		ConditionalOperator:       input.ConditionalOperator,
		ConsistentRead:            consistentRead,
		ExclusiveStartKey:         copyExclusiveStartKey,
		ExpressionAttributeNames:  copyExpressionAttributeNames,
		ExpressionAttributeValues: copyExpressionAttributeValues,
		FilterExpression:          filterExpression,
		IndexName:                 indexName,
		Limit:                     limit,
		ProjectionExpression:      projectionExpression,
		ReturnConsumedCapacity:    input.ReturnConsumedCapacity,
		ScanFilter:                copyScanFilter,
		Segment:                   segment,
		Select:                    input.Select,
		TotalSegments:             totalSegments,
	}
}

// deepCopyTransactGetItemsInput performs a deep copy of a TransactGetItemsInput struct.
func deepCopyTransactGetItemsInput(input *dynamodb.TransactGetItemsInput) *dynamodb.TransactGetItemsInput {
	if input == nil {
		return nil
	}

	copyTransactItems := make([]types.TransactGetItem, len(input.TransactItems))
	for i, item := range input.TransactItems {
		copyTransactItems[i] = deepCopyTransactGetItem(item)
	}

	return &dynamodb.TransactGetItemsInput{
		TransactItems:          copyTransactItems,
		ReturnConsumedCapacity: input.ReturnConsumedCapacity,
	}
}

// DeepCopyTransactWriteItemsInput performs a deep copy of a TransactWriteItemsInput struct.
func deepCopyTransactWriteItemsInput(input *dynamodb.TransactWriteItemsInput) *dynamodb.TransactWriteItemsInput {
	if input == nil {
		return nil
	}

	// Deep copy TransactItems slice
	copyTransactItems := make([]types.TransactWriteItem, len(input.TransactItems))
	for i, item := range input.TransactItems {
		copyTransactItems[i] = deepCopyTransactWriteItem(item)
	}

	// Copy ClientRequestToken pointer
	var clientRequestToken *string
	if input.ClientRequestToken != nil {
		token := *input.ClientRequestToken
		clientRequestToken = &token
	}

	return &dynamodb.TransactWriteItemsInput{
		TransactItems:               copyTransactItems,
		ClientRequestToken:          clientRequestToken,
		ReturnConsumedCapacity:      input.ReturnConsumedCapacity,
		ReturnItemCollectionMetrics: input.ReturnItemCollectionMetrics,
	}
}

// deepCopyUpdateItemInput performs a deep copy of an UpdateItemInput struct.
func deepCopyUpdateItemInput(input *dynamodb.UpdateItemInput) *dynamodb.UpdateItemInput {
	if input == nil {
		return nil
	}

	// Deep copy Key map
	copyKey := deepCopyAttributeMap(input.Key)

	// Deep copy AttributeUpdates map
	copyAttributeUpdates := deepCopyAttributeValueUpdateMap(input.AttributeUpdates)

	// Copy string pointers
	var tableName *string
	if input.TableName != nil {
		t := *input.TableName
		tableName = &t
	}

	// Copy other optional fields
	var conditionExpression *string
	if input.ConditionExpression != nil {
		ce := *input.ConditionExpression
		conditionExpression = &ce
	}

	var updateExpression *string
	if input.UpdateExpression != nil {
		ue := *input.UpdateExpression
		updateExpression = &ue
	}

	// Deep copy ExpressionAttributeNames map
	copyExpressionAttributeNames := deepCopyStringMap(input.ExpressionAttributeNames)

	// Deep copy ExpressionAttributeValues map
	copyExpressionAttributeValues := deepCopyAttributeMap(input.ExpressionAttributeValues)

	// Deep copy Expected map
	copyExpected := deepCopyExpectedAttributeValueMap(input.Expected)

	return &dynamodb.UpdateItemInput{
		Key:                                 copyKey,
		TableName:                           tableName,
		AttributeUpdates:                    copyAttributeUpdates,
		ConditionExpression:                 conditionExpression,
		ConditionalOperator:                 input.ConditionalOperator,
		Expected:                            copyExpected,
		ExpressionAttributeNames:            copyExpressionAttributeNames,
		ExpressionAttributeValues:           copyExpressionAttributeValues,
		ReturnConsumedCapacity:              input.ReturnConsumedCapacity,
		ReturnItemCollectionMetrics:         input.ReturnItemCollectionMetrics,
		ReturnValues:                        input.ReturnValues,
		ReturnValuesOnConditionCheckFailure: input.ReturnValuesOnConditionCheckFailure,
		UpdateExpression:                    updateExpression,
	}
}

// deepCopyAttributeValueUpdateMap performs a deep copy of a map[string]types.AttributeValueUpdate.
func deepCopyAttributeValueUpdateMap(attrMap map[string]types.AttributeValueUpdate) map[string]types.AttributeValueUpdate {
	copyMap := make(map[string]types.AttributeValueUpdate, len(attrMap))
	for k, v := range attrMap {
		copyMap[k] = types.AttributeValueUpdate{
			Value:  deepCopyAttributeValue(v.Value),
			Action: v.Action,
		}
	}
	return copyMap
}

// deepCopyExpectedAttributeValueMap performs a deep copy of a map[string]types.ExpectedAttributeValue.
func deepCopyExpectedAttributeValueMap(attrMap map[string]types.ExpectedAttributeValue) map[string]types.ExpectedAttributeValue {
	copyMap := make(map[string]types.ExpectedAttributeValue, len(attrMap))
	for k, v := range attrMap {
		copyMap[k] = types.ExpectedAttributeValue{
			Value:  deepCopyAttributeValue(v.Value),
			Exists: v.Exists,
		}
	}
	return copyMap
}

// deepCopyTransactWriteItem performs a deep copy of a TransactWriteItem.
func deepCopyTransactWriteItem(item types.TransactWriteItem) types.TransactWriteItem {
	// Deep copy the condition, put, update, or delete action in the TransactWriteItem
	switch {
	case item.ConditionCheck != nil:
		return types.TransactWriteItem{
			ConditionCheck: deepCopyConditionCheck(item.ConditionCheck),
		}
	case item.Put != nil:
		return types.TransactWriteItem{
			Put: deepCopyPut(item.Put),
		}
	case item.Update != nil:
		return types.TransactWriteItem{
			Update: deepCopyUpdate(item.Update),
		}
	case item.Delete != nil:
		return types.TransactWriteItem{
			Delete: deepCopyDelete(item.Delete),
		}
	default:
		// If the item doesn't contain any of the expected actions, return an empty TransactWriteItem
		return types.TransactWriteItem{}
	}
}

// deepCopyPut performs a deep copy of a Put operation.
func deepCopyPut(p *types.Put) *types.Put {
	// Deep copy the Item map in Put
	copyItem := deepCopyAttributeMap(p.Item)

	return &types.Put{
		TableName:                 p.TableName,
		Item:                      copyItem,
		ConditionExpression:       p.ConditionExpression,
		ExpressionAttributeNames:  deepCopyStringMap(p.ExpressionAttributeNames),
		ExpressionAttributeValues: deepCopyAttributeMap(p.ExpressionAttributeValues),
	}
}

// deepCopyUpdate performs a deep copy of an Update operation.
func deepCopyUpdate(u *types.Update) *types.Update {
	// Deep copy the Key map in Update
	copyKey := deepCopyAttributeMap(u.Key)

	return &types.Update{
		TableName:                 u.TableName,
		Key:                       copyKey,
		UpdateExpression:          u.UpdateExpression,
		ConditionExpression:       u.ConditionExpression,
		ExpressionAttributeNames:  deepCopyStringMap(u.ExpressionAttributeNames),
		ExpressionAttributeValues: deepCopyAttributeMap(u.ExpressionAttributeValues),
	}
}

// deepCopyDelete performs a deep copy of a Delete operation.
func deepCopyDelete(d *types.Delete) *types.Delete {
	// Deep copy the Key map in Delete
	copyKey := deepCopyAttributeMap(d.Key)

	return &types.Delete{
		TableName:                 d.TableName,
		Key:                       copyKey,
		ConditionExpression:       d.ConditionExpression,
		ExpressionAttributeNames:  deepCopyStringMap(d.ExpressionAttributeNames),
		ExpressionAttributeValues: deepCopyAttributeMap(d.ExpressionAttributeValues),
	}
}

// deepCopyConditionCheck performs a deep copy of a ConditionCheck.
func deepCopyConditionCheck(cc *types.ConditionCheck) *types.ConditionCheck {
	// Deep copy the Key map in ConditionCheck
	copyKey := deepCopyAttributeMap(cc.Key)

	return &types.ConditionCheck{
		TableName:                 cc.TableName,
		Key:                       copyKey,
		ConditionExpression:       cc.ConditionExpression,
		ExpressionAttributeNames:  deepCopyStringMap(cc.ExpressionAttributeNames),
		ExpressionAttributeValues: deepCopyAttributeMap(cc.ExpressionAttributeValues),
	}
}

// deepCopyTransactGetItem performs a deep copy of a TransactGetItem.
func deepCopyTransactGetItem(item types.TransactGetItem) types.TransactGetItem {
	// Deep copy the Get structure in the TransactGetItem
	copyGet := deepCopyGet(item.Get)

	return types.TransactGetItem{
		Get: copyGet,
	}
}

// deepCopyGet performs a deep copy of the Get structure in TransactGetItem.
func deepCopyGet(get *types.Get) *types.Get {
	// Deep copy the Key map in Get
	copyKey := deepCopyAttributeMap(get.Key)
	// Copy string pointers
	var tableName *string
	if get.TableName != nil {
		t := *get.TableName
		tableName = &t
	}
	// Deep copy ExpressionAttributeNames map
	if get.ExpressionAttributeNames != nil {
		copyExpressionAttributeNames := make(map[string]string, len(get.ExpressionAttributeNames))
		for k, v := range get.ExpressionAttributeNames {
			copyExpressionAttributeNames[k] = v
		}
	}

	var ProjectionExpression *string
	if get.ProjectionExpression != nil {
		t := *get.ProjectionExpression
		ProjectionExpression = &t
	}

	return &types.Get{
		Key:                      copyKey,
		TableName:                tableName,
		ExpressionAttributeNames: deepCopyStringMap(get.ExpressionAttributeNames),
		ProjectionExpression:     ProjectionExpression,
	}
}

// deepCopyStringMap performs a deep copy of a map[string]string.
func deepCopyStringMap(src map[string]string) map[string]string {
	copyMap := make(map[string]string, len(src))
	for k, v := range src {
		copyMap[k] = v
	}
	return copyMap
}

// deepCopyConditionMap performs a deep copy of a map[string]types.Condition.
func deepCopyConditionMap(src map[string]types.Condition) map[string]types.Condition {
	copyMap := make(map[string]types.Condition, len(src))
	for k, v := range src {
		copyValues := make([]types.AttributeValue, len(v.AttributeValueList))
		for i, attr := range v.AttributeValueList {
			copyValues[i] = deepCopyAttributeValue(attr)
		}
		copyMap[k] = types.Condition{
			AttributeValueList: copyValues,
			ComparisonOperator: v.ComparisonOperator,
		}
	}
	return copyMap
}

// deepCopyParameterizedStatement performs a deep copy of a ParameterizedStatement.
func deepCopyParameterizedStatement(stmt types.ParameterizedStatement) types.ParameterizedStatement {
	// Deep copy Parameters slice
	copyParams := make([]types.AttributeValue, len(stmt.Parameters))
	for i, param := range stmt.Parameters {
		copyParams[i] = deepCopyAttributeValue(param)
	}

	// Copy Statement pointer
	var statement *string
	if stmt.Statement != nil {
		s := *stmt.Statement
		statement = &s
	}

	return types.ParameterizedStatement{
		Statement:  statement,
		Parameters: copyParams,
	}
}

// deepCopyWriteRequest performs a deep copy of a WriteRequest.
func deepCopyWriteRequest(req types.WriteRequest) types.WriteRequest {
	var copyReq types.WriteRequest
	// Deep copy DeleteRequest
	if req.DeleteRequest != nil {
		copyReq.DeleteRequest = &types.DeleteRequest{
			Key: deepCopyAttributeMap(req.DeleteRequest.Key),
		}
	}
	// Deep copy PutRequest
	if req.PutRequest != nil {
		copyReq.PutRequest = &types.PutRequest{
			Item: deepCopyAttributeMap(req.PutRequest.Item),
		}
	}
	return copyReq
}

// deepCopyBatchStatementRequest performs a deep copy of a BatchStatementRequest.
func deepCopyBatchStatementRequest(stmt types.BatchStatementRequest) types.BatchStatementRequest {
	// Deep copy Parameters slice
	copyParams := make([]types.AttributeValue, len(stmt.Parameters))
	for i, param := range stmt.Parameters {
		copyParams[i] = deepCopyAttributeValue(param)
	}
	// Copy String pointers
	var statement *string
	if stmt.Statement != nil {
		s := *stmt.Statement
		statement = &s
	}
	return types.BatchStatementRequest{
		Statement: statement,
	}
}

// deepCopyKeysAndAttributes performs a deep copy of types.KeysAndAttributes.
func deepCopyKeysAndAttributes(k types.KeysAndAttributes) types.KeysAndAttributes {
	// Deep copy Keys slice
	copyKeys := make([]map[string]types.AttributeValue, len(k.Keys))
	for i, keyMap := range k.Keys {
		copyKeys[i] = deepCopyAttributeMap(keyMap)
	}

	// Deep copy ExpressionAttributeNames map
	copyExprNames := make(map[string]string, len(k.ExpressionAttributeNames))
	for k, v := range k.ExpressionAttributeNames {
		copyExprNames[k] = v
	}

	// Deep copy AttributesToGet slice
	copyAttributesToGet := make([]string, len(k.AttributesToGet))
	copy(copyAttributesToGet, k.AttributesToGet)

	// Copy ProjectionExpression pointer
	var projectionExpression *string
	if k.ProjectionExpression != nil {
		pe := *k.ProjectionExpression
		projectionExpression = &pe
	}

	var consistentRead *bool
	if k.ConsistentRead != nil {
		cr := *k.ConsistentRead
		consistentRead = &cr
	}

	return types.KeysAndAttributes{
		Keys:                     copyKeys,
		ExpressionAttributeNames: copyExprNames,
		AttributesToGet:          copyAttributesToGet,
		ProjectionExpression:     projectionExpression,
		ConsistentRead:           consistentRead,
	}
}

// deepCopyAttributeMap performs a deep copy of a map[string]types.AttributeValue.
func deepCopyAttributeMap(attrMap map[string]types.AttributeValue) map[string]types.AttributeValue {
	copyMap := make(map[string]types.AttributeValue, len(attrMap))
	for k, v := range attrMap {
		copyMap[k] = deepCopyAttributeValue(v)
	}
	return copyMap
}

// deepCopyAttributeValue performs a deep copy of AttributeValue.
func deepCopyAttributeValue(attr types.AttributeValue) types.AttributeValue {
	switch v := attr.(type) {
	case *types.AttributeValueMemberS:
		return &types.AttributeValueMemberS{Value: v.Value}
	case *types.AttributeValueMemberN:
		return &types.AttributeValueMemberN{Value: v.Value}
	case *types.AttributeValueMemberB:
		b := make([]byte, len(v.Value))
		copy(b, v.Value)
		return &types.AttributeValueMemberB{Value: b}
	case *types.AttributeValueMemberBOOL:
		return &types.AttributeValueMemberBOOL{Value: v.Value}
	case *types.AttributeValueMemberNULL:
		return &types.AttributeValueMemberNULL{Value: v.Value}
	case *types.AttributeValueMemberM:
		newMap := make(map[string]types.AttributeValue, len(v.Value))
		for key, value := range v.Value {
			newMap[key] = deepCopyAttributeValue(value)
		}
		return &types.AttributeValueMemberM{Value: newMap}
	case *types.AttributeValueMemberL:
		newList := make([]types.AttributeValue, len(v.Value))
		for i, value := range v.Value {
			newList[i] = deepCopyAttributeValue(value)
		}
		return &types.AttributeValueMemberL{Value: newList}
	case *types.AttributeValueMemberSS:
		newSS := make([]string, len(v.Value))
		copy(newSS, v.Value)
		return &types.AttributeValueMemberSS{Value: newSS}
	case *types.AttributeValueMemberNS:
		newNS := make([]string, len(v.Value))
		copy(newNS, v.Value)
		return &types.AttributeValueMemberNS{Value: newNS}
	case *types.AttributeValueMemberBS:
		newBS := make([][]byte, len(v.Value))
		for i, b := range v.Value {
			newBS[i] = make([]byte, len(b))
			copy(newBS[i], b)
		}
		return &types.AttributeValueMemberBS{Value: newBS}
	default:
		panic("Unknown AttributeValue type.")
	}
}
