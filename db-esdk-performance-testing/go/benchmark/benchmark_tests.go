// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package benchmark

import (
	"context"
	"fmt"
	"log"
	"runtime"
	"runtime/metrics"
	"sort"
	"sync"
	"time"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
	"github.com/schollz/progressbar/v3"
)

// === Helper Functions ===

// runPutGetCycle performs a single PutItem-GetItem cycle and measures performance
func (b *DBESDKBenchmark) runPutGetCycle(data []byte, itemId string) (float64, float64, error) {
	ctx := context.Background()
	tableName := b.Config.TableName

	// Create DynamoDB item with test data
	item := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "benchmark-test"},
		"sort_key":      &types.AttributeValueMemberN{Value: itemId},
		"attribute1":    &types.AttributeValueMemberB{Value: data}, // Store test data as binary
		"attribute2":    &types.AttributeValueMemberS{Value: "sign me!"},
		":attribute3":   &types.AttributeValueMemberS{Value: "ignore me!"},
	}

	// PutItem
	putStart := time.Now()
	putInput := &dynamodb.PutItemInput{
		TableName: aws.String(tableName),
		Item:      item,
	}
	_, err := b.DbesdkClient.PutItem(ctx, putInput)
	if err != nil {
		return 0, 0, fmt.Errorf("PutItem failed: %w", err)
	}
	putDuration := time.Since(putStart).Seconds() * 1000

	// GetItem
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "benchmark-test"},
		"sort_key":      &types.AttributeValueMemberN{Value: itemId},
	}

	getStart := time.Now()
	getInput := &dynamodb.GetItemInput{
		TableName:      aws.String(tableName),
		Key:            key,
		ConsistentRead: aws.Bool(true),
	}
	result, err := b.DbesdkClient.GetItem(ctx, getInput)
	if err != nil {
		return 0, 0, fmt.Errorf("GetItem failed: %w", err)
	}
	getDuration := time.Since(getStart).Seconds() * 1000

	// Verify data integrity
	if result.Item == nil {
		return 0, 0, fmt.Errorf("item not found")
	}

	retrievedData, ok := result.Item["attribute1"].(*types.AttributeValueMemberB)
	if !ok {
		return 0, 0, fmt.Errorf("attribute1 not found or wrong type")
	}

	if len(retrievedData.Value) != len(data) {
		return 0, 0, fmt.Errorf("data size mismatch: expected %d, got %d", len(data), len(retrievedData.Value))
	}

	return putDuration, getDuration, nil
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

// === Throughput Test Implementation ===

// runThroughputTest runs throughput benchmark test
func (b *DBESDKBenchmark) runThroughputTest(dataSize int, iterations int) (*BenchmarkResult, error) {
	log.Printf("Running throughput test - Size: %d bytes, Iterations: %d", dataSize, iterations)

	testData := b.GenerateTestData(dataSize)

	// Warmup
	for i := 0; i < b.Config.Iterations.Warmup; i++ {
		itemId := fmt.Sprintf("%d", i) // Use numeric string for Number attribute
		if _, _, err := b.runPutGetCycle(testData, itemId); err != nil {
			return nil, fmt.Errorf("warmup iteration %d failed: %w", i, err)
		}
	}

	// Measurement runs
	var putLatencies, getLatencies, endToEndLatencies []float64
	var totalBytes int64

	bar := progressbar.NewOptions(iterations,
		progressbar.OptionSetDescription("Throughput test"),
		progressbar.OptionShowCount(),
		progressbar.OptionSetWidth(50),
	)

	startTime := time.Now()
	for i := 0; i < iterations; i++ {
		itemId := fmt.Sprintf("%d", 1000+i) // Use numeric string, offset to avoid warmup conflicts
		iterationStart := time.Now()
		putMs, getMs, err := b.runPutGetCycle(testData, itemId)
		if err != nil {
			return nil, fmt.Errorf("measurement iteration %d failed: %w", i, err)
		}
		iterationDuration := time.Since(iterationStart).Seconds() * 1000

		putLatencies = append(putLatencies, putMs)
		getLatencies = append(getLatencies, getMs)
		endToEndLatencies = append(endToEndLatencies, iterationDuration)
		totalBytes += int64(dataSize)

		bar.Add(1)
	}
	totalDuration := time.Since(startTime).Seconds()

	// Calculate metrics
	sort.Float64s(endToEndLatencies)
	result := &BenchmarkResult{
		TestName:          "throughput",
		Language:          "go",
		DataSize:          dataSize,
		Concurrency:       1,
		PutLatencyMs:      Average(putLatencies),
		GetLatencyMs:      Average(getLatencies),
		EndToEndLatencyMs: Average(endToEndLatencies),
		OpsPerSecond:      float64(iterations) / totalDuration,
		BytesPerSecond:    float64(totalBytes) / totalDuration,
		P50Latency:        Percentile(endToEndLatencies, 0.50),
		P95Latency:        Percentile(endToEndLatencies, 0.95),
		P99Latency:        Percentile(endToEndLatencies, 0.99),
		Timestamp:         time.Now().Format("2006-01-02 15:04:05"),
		GoVersion:         runtime.Version(),
		CPUCount:          b.CPUCount,
		TotalMemoryGB:     b.TotalMemoryGB,
	}

	log.Printf("Throughput test completed - Ops/sec: %.2f, MB/sec: %.2f",
		result.OpsPerSecond, result.BytesPerSecond/(1024*1024))

	return result, nil
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

// runMemoryTest runs memory benchmark with continuous sampling
func (b *DBESDKBenchmark) runMemoryTest(dataSize int) (*BenchmarkResult, error) {
	log.Printf("Running memory test - Size: %d bytes (%d iterations, continuous sampling)", dataSize, MemoryTestIterations)

	data := b.GenerateTestData(dataSize)

	// Setup runtime/metrics tracking
	samples := make([]metrics.Sample, 2)
	samples[0].Name = "/memory/classes/heap/objects:bytes"
	samples[1].Name = "/gc/heap/allocs:bytes"

	var peakHeap, peakAllocations float64
	var avgHeapValues []float64

	// Run iterations
	for i := 0; i < MemoryTestIterations; i++ {
		runtime.GC()
		time.Sleep(GCSettleTimeMs * time.Millisecond)

		// Get baseline
		metrics.Read(samples)
		beforeHeap := samples[0].Value.Uint64()
		beforeAllocs := samples[1].Value.Uint64()

		// Start continuous sampling
		stopSampling := make(chan bool)
		var continuousSamples []MemorySample
		var samplingMutex sync.Mutex

		go func() {
			sampledData := b.sampleMemoryContinuously(beforeHeap, beforeAllocs, stopSampling)
			samplingMutex.Lock()
			continuousSamples = sampledData
			samplingMutex.Unlock()
		}()

		// Run operation
		operationStart := time.Now()
		itemId := fmt.Sprintf("%d", 2000+i) // Use numeric string, offset to avoid conflicts
		_, _, err := b.runPutGetCycle(data, itemId)
		operationDuration := time.Since(operationStart)

		close(stopSampling)
		time.Sleep(FinalSampleWaitMs * time.Millisecond)

		if err != nil {
			log.Printf("Iteration %d failed: %v", i+1, err)
			continue
		}

		// Analyze samples
		samplingMutex.Lock()
		var iterPeakHeap, iterTotalAllocs, iterAvgHeap float64
		if len(continuousSamples) > 0 {
			var heapSum float64
			for _, s := range continuousSamples {
				if s.HeapMB > iterPeakHeap {
					iterPeakHeap = s.HeapMB
				}
				if s.MetricsAllocsMB > iterTotalAllocs {
					iterTotalAllocs = s.MetricsAllocsMB
				}
				heapSum += s.HeapMB
			}
			iterAvgHeap = heapSum / float64(len(continuousSamples))
		}
		samplingMutex.Unlock()

		// Update global metrics
		if iterPeakHeap > peakHeap {
			peakHeap = iterPeakHeap
		}
		if iterTotalAllocs > peakAllocations {
			peakAllocations = iterTotalAllocs
		}
		avgHeapValues = append(avgHeapValues, iterAvgHeap)

		log.Printf("=== Iteration %d === Peak Heap: %.2f MB, Total Allocs: %.2f MB, Avg Heap: %.2f MB (%v, %d samples)",
			i+1, iterPeakHeap, iterTotalAllocs, iterAvgHeap, operationDuration, len(continuousSamples))
	}

	if len(avgHeapValues) == 0 {
		return nil, fmt.Errorf("all memory test iterations failed")
	}

	overallAvgHeap := Average(avgHeapValues)
	memoryEfficiency := float64(dataSize) / (overallAvgHeap * 1024 * 1024)
	if overallAvgHeap == 0 {
		memoryEfficiency = 0
	}

	log.Printf("\nMemory Summary:")
	log.Printf("- Absolute Peak Heap: %.2f MB (across all runs)", peakHeap)
	log.Printf("- Average Heap: %.2f MB (across all runs)", overallAvgHeap)
	log.Printf("- Total Allocations: %.2f MB (max across all runs)", peakAllocations)

	result := &BenchmarkResult{
		TestName:         "memory",
		Language:         "go",
		DataSize:         dataSize,
		Concurrency:      1,
		PeakMemoryMB:     peakHeap,
		MemoryEfficiency: memoryEfficiency,
		Timestamp:        time.Now().Format("2006-01-02 15:04:05"),
		GoVersion:        runtime.Version(),
		CPUCount:         b.CPUCount,
		TotalMemoryGB:    b.TotalMemoryGB,
	}

	return result, nil
}

// === Concurrent Test Implementation ===

// runConcurrentTest runs concurrent operations benchmark test
// func (b *DBESDKBenchmark) runConcurrentTest(dataSize int, concurrency int, iterationsPerWorker int) (*BenchmarkResult, error) {
// 	log.Printf("Running concurrent test - Size: %d bytes, Concurrency: %d", dataSize, concurrency)

// 	data := b.GenerateTestData(dataSize)
// 	var allTimes []float64
// 	var timesMutex sync.Mutex
// 	var wg sync.WaitGroup

// 	errorChan := make(chan error, concurrency)
// 	startTime := time.Now()

// 	// Launch workers
// 	for i := 0; i < concurrency; i++ {
// 		wg.Add(1)
// 		go func(workerID int) {
// 			defer wg.Done()

// 			var workerTimes []float64
// 			for j := 0; j < iterationsPerWorker; j++ {
// 				iterStart := time.Now()
// 				_, _, err := b.runEncryptDecryptCycle(data)
// 				if err != nil {
// 					errorChan <- fmt.Errorf("worker %d iteration %d failed: %w", workerID, j, err)
// 					return
// 				}
// 				workerTimes = append(workerTimes, time.Since(iterStart).Seconds()*1000)
// 			}

// 			timesMutex.Lock()
// 			allTimes = append(allTimes, workerTimes...)
// 			timesMutex.Unlock()
// 		}(i)
// 	}

// 	wg.Wait()
// 	totalDuration := time.Since(startTime).Seconds()

// 	// Check for errors
// 	select {
// 	case err := <-errorChan:
// 		return nil, err
// 	default:
// 	}

// 	// Calculate metrics
// 	totalOps := concurrency * iterationsPerWorker
// 	totalBytes := int64(totalOps * dataSize)

// 	sort.Float64s(allTimes)
// 	result := &BenchmarkResult{
// 		TestName:          "concurrent",
// 		Language:          "go",
// 		DataSize:          dataSize,
// 		Concurrency:       concurrency,
// 		EndToEndLatencyMs: Average(allTimes),
// 		OpsPerSecond:      float64(totalOps) / totalDuration,
// 		BytesPerSecond:    float64(totalBytes) / totalDuration,
// 		P50Latency:        Percentile(allTimes, 0.50),
// 		P95Latency:        Percentile(allTimes, 0.95),
// 		P99Latency:        Percentile(allTimes, 0.99),
// 		Timestamp:         time.Now().Format("2006-01-02 15:04:05"),
// 		GoVersion:         runtime.Version(),
// 		CPUCount:          b.CPUCount,
// 		TotalMemoryGB:     b.TotalMemoryGB,
// 	}

// 	log.Printf("Concurrent test completed - Ops/sec: %.2f, Avg latency: %.2f ms",
// 		result.OpsPerSecond, result.EndToEndLatencyMs)

// 	return result, nil
// }

// === Test Orchestration ===

// runThroughputTests executes all throughput tests
func (b *DBESDKBenchmark) runThroughputTests(dataSizes []int, iterations int) {
	log.Println("Running throughput tests...")
	for _, dataSize := range dataSizes {
		result, err := b.runThroughputTest(dataSize, iterations)
		if err != nil {
			log.Printf("Throughput test failed: %v", err)
			continue
		}
		b.Results = append(b.Results, *result)
		log.Printf("Throughput test completed: %.2f ops/sec", result.OpsPerSecond)
	}
}

// runMemoryTests executes all memory tests
func (b *DBESDKBenchmark) runMemoryTests(dataSizes []int) {
	log.Println("Running memory tests...")
	for _, dataSize := range dataSizes {
		result, err := b.runMemoryTest(dataSize)
		if err != nil {
			log.Printf("Memory test failed: %v", err)
			continue
		}
		b.Results = append(b.Results, *result)
		log.Printf("Memory test completed: %.2f MB peak", result.PeakMemoryMB)
	}
}

// runConcurrencyTests executes all concurrency tests
// func (b *DBESDKBenchmark) runConcurrencyTests(dataSizes []int, concurrencyLevels []int) {
// 	log.Println("Running concurrency tests...")
// 	for _, dataSize := range dataSizes {
// 		for _, concurrency := range concurrencyLevels {
// 			if concurrency > 1 { // Skip single-threaded
// 				result, err := b.runConcurrentTest(dataSize, concurrency, 5)
// 				if err != nil {
// 					log.Printf("Concurrent test failed: %v", err)
// 					continue
// 				}
// 				b.Results = append(b.Results, *result)
// 				log.Printf("Concurrent test completed: %.2f ops/sec @ %d threads", result.OpsPerSecond, concurrency)
// 			}
// 		}
// 	}
// }

// RunAllBenchmarks runs all configured benchmark tests
func (b *DBESDKBenchmark) RunAllBenchmarks() error {
	log.Println("Starting comprehensive DB-ESDK benchmark suite")

	// Combine all data sizes
	var dataSizes []int
	for _, sizes := range [][]int{b.Config.DataSizes.Small, b.Config.DataSizes.Medium, b.Config.DataSizes.Large} {
		dataSizes = append(dataSizes, sizes...)
	}

	// Run test suites
	if b.shouldRunTestType("throughput") {
		b.runThroughputTests(dataSizes, b.Config.Iterations.Measurement)
	} else {
		log.Println("Skipping throughput tests (not in test_types)")
	}

	if b.shouldRunTestType("memory") {
		b.runMemoryTests(dataSizes)
	} else {
		log.Println("Skipping memory tests (not in test_types)")
	}

	// if b.shouldRunTestType("concurrency") {
	// 	b.runConcurrencyTests(dataSizes, b.Config.ConcurrencyLevels)
	// } else {
	// 	log.Println("Skipping concurrency tests (not in test_types)")
	// }

	log.Printf("Benchmark suite completed. Total results: %d", len(b.Results))
	return nil
}
