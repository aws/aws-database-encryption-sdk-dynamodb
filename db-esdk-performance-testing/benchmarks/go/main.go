// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package main

import (
	"context"
	"flag"
	"fmt"
	"log"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/db-esdk-performance-testing/benchmarks/go/benchmark"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

func main() {
	// Parse command line arguments
	configPath := flag.String("config", "../config/test-scenarios.yaml", "Path to test configuration file")
	outputPath := flag.String("output", "../results/raw-data/go_results.json", "Path to output results file")
	quick := flag.Bool("quick", false, "Run quick test with reduced iterations")
	flag.Parse()

	// Initialize benchmark
	bench, err := benchmark.New(*configPath)
	if err != nil {
		log.Fatalf("Failed to initialize benchmark: %v", err)
	}

	// create dynamodb table
	// CreateTable(bench.DbesdkClient, bench.Config.TableName)

	// Adjust config for quick test
	if *quick {
		if bench.Config.QuickConfig == nil {
			log.Fatalf("Quick mode requested but no quick_config found in config file")
		}
		bench.Config.Iterations.Measurement = bench.Config.QuickConfig.Iterations.Measurement
		bench.Config.Iterations.Warmup = bench.Config.QuickConfig.Iterations.Warmup
		bench.Config.DataSizes.Small = bench.Config.QuickConfig.DataSizes.Small
		bench.Config.DataSizes.Medium = []int{}
		bench.Config.DataSizes.Large = []int{}
		bench.Config.ConcurrencyLevels = bench.Config.QuickConfig.ConcurrencyLevels
	}

	// Run benchmarks
	if err := bench.RunAllBenchmarks(); err != nil {
		log.Fatalf("Benchmark failed: %v", err)
	}

	// Save results
	if err := bench.SaveResults(*outputPath); err != nil {
		log.Fatalf("Failed to save results: %v", err)
	}

	// Print summary
	fmt.Printf("\n=== ESDK Go Benchmark Summary ===\n")
	fmt.Printf("Total tests completed: %d\n", len(bench.Results))
	fmt.Printf("Results saved to: %s\n", *outputPath)

	if len(bench.Results) > 0 {
		var maxThroughput float64
		for _, result := range bench.Results {
			if result.TestName == "throughput" && result.OpsPerSecond > maxThroughput {
				maxThroughput = result.OpsPerSecond
			}
		}
		if maxThroughput > 0 {
			fmt.Printf("Maximum throughput: %.2f ops/sec\n", maxThroughput)
		}
	}
}

// Create DynamoDB table
func CreateTable(dynamodbClient *dynamodb.Client, tableName string) error {
	input := &dynamodb.CreateTableInput{
		TableName: &tableName,
		KeySchema: []types.KeySchemaElement{
			{
				AttributeName: aws.String("partition_key"),
				KeyType:       types.KeyTypeHash,
			},
			{
				AttributeName: aws.String("sort_key"),
				KeyType:       types.KeyTypeRange,
			},
		},
		AttributeDefinitions: []types.AttributeDefinition{
			{
				AttributeName: aws.String("partition_key"),
				AttributeType: types.ScalarAttributeTypeS,
			},
			{
				AttributeName: aws.String("sort_key"),
				AttributeType: types.ScalarAttributeTypeN,
			},
		},
		BillingMode: types.BillingModePayPerRequest,
	}

	_, err := dynamodbClient.CreateTable(context.Background(), input)
	return err
}
