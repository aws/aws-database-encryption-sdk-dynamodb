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
