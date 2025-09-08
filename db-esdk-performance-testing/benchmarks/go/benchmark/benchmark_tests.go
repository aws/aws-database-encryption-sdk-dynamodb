// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package benchmark

import (
	"context"
	"fmt"
	"reflect"
	"runtime/metrics"
	"time"

	dbesdkitemencryptortypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbitemencryptorsmithygeneratedtypes"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

// === Helper Functions ===

// runBatchPutGetCycle performs a BatchWriteItem-BatchGetItem cycle with 25 items and measures performance
// func (b *DBESDKBenchmark) runBatchPutGetCycle(data []byte) (float64, float64, error) {
// 	ctx := context.Background()
// 	tableName := b.Config.TableName

// 	// Create 25 write requests with same data, different sort_key
// 	var items []map[string]types.AttributeValue

// 	for i := 0; i < 25; i++ {
// 		item := map[string]types.AttributeValue{
// 			"partition_key": &types.AttributeValueMemberS{Value: "benchmark-test"},
// 			"sort_key":      &types.AttributeValueMemberN{Value: strconv.Itoa(i)},
// 			"attribute1": &types.AttributeValueMemberM{Value: map[string]types.AttributeValue{
// 				"data": &types.AttributeValueMemberB{Value: data},
// 			}},
// 			"attribute2":  &types.AttributeValueMemberS{Value: "sign me!"},
// 			":attribute3": &types.AttributeValueMemberS{Value: "ignore me!"},
// 		}
// 		items = append(items, item)
// 	}

// 	var writeRequests []types.WriteRequest
// 	for _, item := range items {
// 		writeRequests = append(writeRequests, types.WriteRequest{
// 			PutRequest: &types.PutRequest{Item: item},
// 		})
// 	}

// 	// BatchWriteItem
// 	batchWriteStart := time.Now()
// 	_, err := b.DbesdkClient.BatchWriteItem(ctx, &dynamodb.BatchWriteItemInput{
// 		RequestItems: map[string][]types.WriteRequest{tableName: writeRequests},
// 	})
// 	if err != nil {
// 		return 0, 0, fmt.Errorf("BatchWriteItem failed: %w", err)
// 	}
// 	batchWriteDuration := time.Since(batchWriteStart).Seconds() * 1000

// 	// Create 25 keys for BatchGetItem
// 	var keys []map[string]types.AttributeValue
// 	for i := 0; i < 25; i++ {
// 		keys = append(keys, map[string]types.AttributeValue{
// 			"partition_key": &types.AttributeValueMemberS{Value: "benchmark-test"},
// 			"sort_key":      &types.AttributeValueMemberN{Value: strconv.Itoa(i)},
// 		})
// 	}

// 	// BatchGetItem
// 	batchGetStart := time.Now()
// 	result, err := b.DbesdkClient.BatchGetItem(ctx, &dynamodb.BatchGetItemInput{
// 		RequestItems: map[string]types.KeysAndAttributes{
// 			tableName: {Keys: keys, ConsistentRead: aws.Bool(true)},
// 		},
// 	})
// 	if err != nil {
// 		return 0, 0, fmt.Errorf("BatchGetItem failed: %w", err)
// 	}
// 	batchGetDuration := time.Since(batchGetStart).Seconds() * 1000

// 	// Verify 25 items retrieved with correct data size
// 	returnedItems := result.Responses[tableName]
// 	if len(returnedItems) != 25 {
// 		return 0, 0, fmt.Errorf("expected 25 items, got %d", len(returnedItems))
// 	}

// 	// Verify each returned item
// 	for i, item := range returnedItems {
// 		if _, ok := item["attribute1"]; !ok {
// 			return 0, 0, fmt.Errorf("item %d missing attribute1", i)
// 		}

// 		// Verify attribute1
// 		if attr1, ok := item["attribute1"].(*types.AttributeValueMemberM); ok {
// 			if dataAttr, ok := attr1.Value["data"].(*types.AttributeValueMemberB); ok {
// 				if !bytes.Equal(dataAttr.Value, data) {
// 					return 0, 0, fmt.Errorf("item %d data mismatch", i)
// 				}
// 			}
// 		}

// 		// Verify attribute2 value
// 		if attr2, ok := item["attribute2"].(*types.AttributeValueMemberS); ok {
// 			if attr2.Value != "sign me!" {
// 				return 0, 0, fmt.Errorf("item %d attribute2 mismatch: got %s", i, attr2.Value)
// 			}
// 		} else {
// 			return 0, 0, fmt.Errorf("item %d attribute2 wrong type", i)
// 		}

// 		// Verify :attribute3 value
// 		if attr3, ok := item[":attribute3"].(*types.AttributeValueMemberS); ok {
// 			if attr3.Value != "ignore me!" {
// 				return 0, 0, fmt.Errorf("item %d :attribute3 mismatch: got %s", i, attr3.Value)
// 			}
// 		} else {
// 			return 0, 0, fmt.Errorf("item %d :attribute3 wrong type", i)
// 		}
// 	}

// 	return batchWriteDuration, batchGetDuration, nil
// }

// runItemEncryptorCycle performs a item encryptor encrypt and decrypt cycle with 25 items and measures performance
func (b *DBESDKBenchmark) runItemEncryptorCycle(data []byte) (float64, float64, error) {
	item := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "benchmark-test"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
		"attribute1": &types.AttributeValueMemberM{Value: map[string]types.AttributeValue{
			"data": &types.AttributeValueMemberB{Value: data},
		}},
		"attribute2":  &types.AttributeValueMemberS{Value: "sign me!"},
		":attribute3": &types.AttributeValueMemberS{Value: "ignore me!"},
	}

	encryptItemInput := &dbesdkitemencryptortypes.EncryptItemInput{
		PlaintextItem: item,
	}

	encryptItemStart := time.Now()
	encryptItemOutput, err := b.ItemEncryptorClient.EncryptItem(context.Background(), *encryptItemInput)
	if err != nil {
		return 0, 0, fmt.Errorf("EncryptItem failed: %w", err)
	}
	encryptItemDuration := time.Since(encryptItemStart).Seconds() * 1000
	// Demonstrate that the item has been encrypted
	encryptedItem := encryptItemOutput.EncryptedItem

	// Directly decrypt the encrypted item using the DynamoDb Item Encryptor
	decryptItemInput := &dbesdkitemencryptortypes.DecryptItemInput{
		EncryptedItem: encryptedItem,
	}
	decryptItemStart := time.Now()
	decryptedItem, err := b.ItemEncryptorClient.DecryptItem(context.Background(), *decryptItemInput)
	if err != nil {
		return 0, 0, fmt.Errorf("EncryptItem failed: %w", err)
	}
	decryptItemDuration := time.Since(decryptItemStart).Seconds() * 1000

	if !reflect.DeepEqual(item, decryptedItem.PlaintextItem) {
		panic("Decrypted item does not match original item")
	}
	return encryptItemDuration, decryptItemDuration, nil
}

// shouldRunTestType checks if a test type should be run based on quick config
func (b *DBESDKBenchmark) shouldRunTestType(testType string) bool {
	if b.Config.QuickConfig == nil || len(b.Config.QuickConfig.TestTypes) == 0 {
		return true
	}

	for _, allowedType := range b.Config.QuickConfig.TestTypes {
		if allowedType == testType {
			return true
		}
	}
	return false
}

// === Memory Test Implementation ===

// sampleMemoryContinuously runs continuous memory sampling during operation
func (b *DBESDKBenchmark) sampleMemoryContinuously(beforeHeap, beforeAllocs uint64, stopChan chan bool) []MemorySample {
	var samples []MemorySample
	ticker := time.NewTicker(SamplingIntervalMs * time.Millisecond)
	defer ticker.Stop()

	for {
		select {
		case <-stopChan:
			return samples
		case <-ticker.C:
			var currentSamples [2]metrics.Sample
			currentSamples[0].Name = "/memory/classes/heap/objects:bytes"
			currentSamples[1].Name = "/gc/heap/allocs:bytes"
			metrics.Read(currentSamples[:])

			var heapDelta, allocsDelta uint64
			if currentSamples[0].Value.Uint64() > beforeHeap {
				heapDelta = currentSamples[0].Value.Uint64() - beforeHeap
			}
			if currentSamples[1].Value.Uint64() > beforeAllocs {
				allocsDelta = currentSamples[1].Value.Uint64() - beforeAllocs
			}

			sample := MemorySample{
				Timestamp:        time.Now(),
				HeapMB:           float64(heapDelta) / (1024 * 1024),
				MetricsAllocsMB:  float64(allocsDelta) / (1024 * 1024),
				MemStatsAllocsMB: 0,
			}
			samples = append(samples, sample)
		}
	}
}
