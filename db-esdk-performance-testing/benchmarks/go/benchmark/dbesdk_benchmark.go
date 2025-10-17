// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package benchmark

import (
	"context"
	"crypto/rand"
	"fmt"
	"log"
	"net/url"
	"runtime"

	mplsmithygenerated "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	itemencryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbitemencryptorsmithygenerated"
	dbesdkitemencryptortypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbitemencryptorsmithygeneratedtypes"
	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/dbesdkmiddleware"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	smithyendpoints "github.com/aws/smithy-go/endpoints"
	"github.com/shirou/gopsutil/v3/mem"
)

// Constants for memory testing
const (
	MemoryTestIterations = 5
	SamplingIntervalMs   = 1
	GCSettleTimeMs       = 5
	FinalSampleWaitMs    = 2
)

// DBESDKBenchmark is the main benchmark struct
type DBESDKBenchmark struct {
	Config              TestConfig
	DbesdkClient        *dynamodb.Client
	ItemEncryptorClient *itemencryptor.Client
	Keyring             mpltypes.IKeyring
	Results             []BenchmarkResult
	CPUCount            int
	TotalMemoryGB       float64
}

// New creates a new benchmark instance
func New(configPath string) (*DBESDKBenchmark, error) {
	benchmark := &DBESDKBenchmark{
		CPUCount: runtime.NumCPU(),
	}

	// Get system memory
	if vmStat, err := mem.VirtualMemory(); err == nil {
		benchmark.TotalMemoryGB = float64(vmStat.Total) / (1024 * 1024 * 1024)
	}

	// Load configuration
	config, err := LoadConfig(configPath)
	if err != nil {
		return nil, fmt.Errorf("failed to load config: %w", err)
	}
	benchmark.Config = config

	// Setup MPL
	if err := benchmark.setupMPL(); err != nil {
		return nil, fmt.Errorf("failed to setup MPL: %w", err)
	}

	// Setup DB-ESDK
	if err := benchmark.setupDBESDK(false); err != nil {
		return nil, fmt.Errorf("failed to setup DB-ESDK: %w", err)
	}

	log.Printf("Initialized DB-ESDK Benchmark - CPU cores: %d, Memory: %.1fGB",
		benchmark.CPUCount, benchmark.TotalMemoryGB)

	return benchmark, nil
}

func (b *DBESDKBenchmark) setupMPL() error {
	// Initialize the material providers client
	matProvConfig := mpltypes.MaterialProvidersConfig{}
	matProv, err := mplsmithygenerated.NewClient(matProvConfig)
	if err != nil {
		return fmt.Errorf("failed to create material providers client: %w", err)
	}

	switch b.Config.Keyring {
	case RawAESKeying:
		b.Keyring, err = SetupRawAESKeyring(matProv)
		if err != nil {
			return fmt.Errorf("failed to create keyring: %w", err)
		}
	default:
		return fmt.Errorf("unsupported keyring type: %s", b.Config.Keyring)
	}
	return nil
}

// setupDBESDK initializes the DynamoDB client with DB-ESDK middleware and creates a default keyring which is AES keyring
func (b *DBESDKBenchmark) setupDBESDK(useItemEncryptor bool) error {
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key": dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"sort_key":      dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"attribute1":    dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"attribute2":    dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		":attribute3":   dbesdkstructuredencryptiontypes.CryptoActionDoNothing,
	}

	allowedUnsignedAttributePrefix := ":"

	partitionKey := "partition_key"
	sortKeyName := "sort_key"
	algorithmSuiteID := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeyEcdsaP384SymsigHmacSha384

	err := b.setupItemEncryptorClient(partitionKey, sortKeyName, allowedUnsignedAttributePrefix, algorithmSuiteID, attributeActions)
	if err != nil {
		return err
	}

	// err = b.SetupDDB(partitionKey, sortKeyName, allowedUnsignedAttributePrefix, algorithmSuiteID, attributeActions)
	// if err != nil {
	// 	return err
	// }

	log.Println("ESDK client initialized successfully")
	return nil
}

func (b *DBESDKBenchmark) SetupDDB(partitionKey, sortKeyName, allowedUnsignedAttributePrefix string, algorithmSuiteID mpltypes.DBEAlgorithmSuiteId, attributeActions map[string]dbesdkstructuredencryptiontypes.CryptoAction) error {
	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               b.Config.TableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        b.Keyring,
		AllowedUnsignedAttributePrefix: &allowedUnsignedAttributePrefix,
		AlgorithmSuiteId:               &algorithmSuiteID,
	}
	tableConfigsMap := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[b.Config.TableName] = tableConfig
	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	}

	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		return fmt.Errorf("failed to load default config: %w", err)
	}

	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware(), func(o *dynamodb.Options) {
		o.EndpointResolverV2 = &resolverV2{}
	})

	b.DbesdkClient = ddb

	return nil
}

func (b *DBESDKBenchmark) setupItemEncryptorClient(partitionKey, sortKeyName, allowedUnsignedAttributePrefix string, algorithmSuiteID mpltypes.DBEAlgorithmSuiteId, attributeActions map[string]dbesdkstructuredencryptiontypes.CryptoAction) error {
	itemEncryptorConfig := dbesdkitemencryptortypes.DynamoDbItemEncryptorConfig{
		LogicalTableName:               b.Config.TableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        b.Keyring,
		AllowedUnsignedAttributePrefix: &allowedUnsignedAttributePrefix,
		AlgorithmSuiteId:               &algorithmSuiteID,
	}
	itemEncryptorClient, err := itemencryptor.NewClient(itemEncryptorConfig)
	if err != nil {
		return fmt.Errorf("failed to create item encryptor client: %w", err)
	}
	b.ItemEncryptorClient = itemEncryptorClient
	return nil
}

type resolverV2 struct {
}

func (*resolverV2) ResolveEndpoint(ctx context.Context, params dynamodb.EndpointParameters) (
	smithyendpoints.Endpoint, error,
) {
	u, err := url.Parse("http://localhost:8000")
	if err != nil {
		return smithyendpoints.Endpoint{}, err
	}
	return smithyendpoints.Endpoint{
		URI: *u,
	}, nil
}

// GenerateTestData creates test data of specified size
func (b *DBESDKBenchmark) GenerateTestData(size int) []byte {
	data := make([]byte, size)
	rand.Read(data)
	return data
}
