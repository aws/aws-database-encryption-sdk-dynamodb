// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package complexexample

import (
	"context"

	keystoreclient "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygenerated"
	keystoretypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygeneratedtypes"
	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/dbesdkmiddleware"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/kms"
)

/*
 * This file is used in an example to demonstrate complex queries
 * you can perform using beacons.
 * The example data used is for demonstrative purposes only,
 * and might not meet the distribution and correlation uniqueness
 * recommendations for beacons.
 * See our documentation for whether beacons are
 * right for your particular data set:
 * https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me
 *
 * This file sets up all the searchable encryption configuration required to execute the examples from
 * our workshop using the encryption client.
 */

func SetupBeaconConfig(
	ctx context.Context,
	ddbTableName,
	branchKeyId,
	branchKeyWrappingKmsKeyArn,
	branchKeyDdbTableName string) (*dynamodb.Client, error) {
	// 1. Create Keystore and branch key.
	//    These are the same constructions as in the Basic examples, which describe this in more detail.
	cfg, err := config.LoadDefaultConfig(ctx)
	if err != nil {
		return nil, err
	}

	kmsClient := kms.NewFromConfig(cfg)
	ddbClient := dynamodb.NewFromConfig(cfg)

	kmsConfig := keystoretypes.KMSConfigurationMemberkmsKeyArn{
		Value: branchKeyWrappingKmsKeyArn,
	}
	keyStoreConfig := keystoretypes.KeyStoreConfig{
		KmsClient:           kmsClient,
		DdbClient:           ddbClient,
		DdbTableName:        branchKeyDdbTableName,
		LogicalKeyStoreName: branchKeyDdbTableName,
		KmsConfiguration:    &kmsConfig,
	}

	keyStore, err := keystoreclient.NewClient(keyStoreConfig)
	if err != nil {
		return nil, err
	}

	// 2. Create standard beacons
	//    For this example, we use a standard beacon length of 4.
	//    The BasicSearchableEncryptionExample gives a more thorough consideration of beacon length.
	//    For production applications, one should always exercise rigor when deciding beacon length, including
	//    examining population size and considering performance.
	standardBeaconList := []dbesdkdynamodbencryptiontypes.StandardBeacon{
		{Name: "EmployeeID", Length: 4},
		{Name: "TicketNumber", Length: 4},
		{Name: "ProjectName", Length: 4},
		{Name: "EmployeeEmail", Length: 4},
		{Name: "CreatorEmail", Length: 4},
		{Name: "ProjectStatus", Length: 4},
		{Name: "OrganizerEmail", Length: 4},
		{Name: "ManagerEmail", Length: 4},
		{Name: "AssigneeEmail", Length: 4},
		{Name: "City", Loc: StringPtr("Location.City"), Length: 4},
		{Name: "Severity", Length: 4},
		{Name: "Building", Loc: StringPtr("Location.Building"), Length: 4},
		{Name: "Floor", Loc: StringPtr("Location.Floor"), Length: 4},
		{Name: "Room", Loc: StringPtr("Location.Room"), Length: 4},
		{Name: "Desk", Loc: StringPtr("Location.Desk"), Length: 4},
	}

	// 3. Define encrypted parts
	//    Note that some of the prefixes are modified from the suggested prefixes in Demo.md.
	//    This is because all prefixes must be unique in a configuration.
	//    Encrypted parts are described in more detail in the CompoundBeaconSearchableEncryptionExample.
	encryptedPartList := []dbesdkdynamodbencryptiontypes.EncryptedPart{
		{Name: "EmployeeID", Prefix: "E-"},
		{Name: "TicketNumber", Prefix: "T-"},
		{Name: "ProjectName", Prefix: "P-"},
		{Name: "EmployeeEmail", Prefix: "EE-"},
		{Name: "CreatorEmail", Prefix: "CE-"},
		{Name: "ProjectStatus", Prefix: "PSts-"},
		{Name: "OrganizerEmail", Prefix: "OE-"},
		{Name: "ManagerEmail", Prefix: "ME-"},
		{Name: "AssigneeEmail", Prefix: "AE-"},
		{Name: "City", Prefix: "C-"},
		{Name: "Severity", Prefix: "S-"},
		{Name: "Building", Prefix: "B-"},
		{Name: "Floor", Prefix: "F-"},
		{Name: "Room", Prefix: "R-"},
		{Name: "Desk", Prefix: "D-"},
	}

	// 4. Define signed parts.
	//    These are unencrypted attributes we would like to use in beacon queries.
	//    In this example, all of these represent dates or times.
	//    Keeping these attributes unencrypted allows us to use them in comparison-based queries. If a signed
	//    part is the first part in a compound beacon, then that part can be used in comparison for sorting.
	signedPartList := []dbesdkdynamodbencryptiontypes.SignedPart{
		{Name: "TicketModTime", Prefix: "M-"},
		{Name: "MeetingStart", Prefix: "MS-"},
		{Name: "TimeCardStart", Prefix: "TC-"},
		{Name: "ProjectStart", Prefix: "PS-"},
	}

	// 5. Create constructor parts.
	//    Constructor parts are used to assemble constructors (constructors described more in next step).
	//    For each attribute that will be used in a constructor, there must be a corresponding constructor part.
	//    A constructor part must receive:
	//     - name: Name of a standard beacon
	//     - required: Whether this attribute must be present in the item to match a constructor
	//    In this example, we will define each constructor part once and re-use it across multiple constructors.
	//    The parts below are defined by working backwards from the constructors in "PK Constructors",
	//        "SK constructors", etc. sections in Demo.md.
	employeeIdConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "EmployeeID", Required: true}
	ticketNumberConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "TicketNumber", Required: true}
	projectNameConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "ProjectName", Required: true}
	ticketModTimeConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "TicketModTime", Required: true}
	meetingStartConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "MeetingStart", Required: true}
	timeCardStartConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "TimeCardStart", Required: true}
	employeeEmailConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "EmployeeEmail", Required: true}
	creatorEmailConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "CreatorEmail", Required: true}
	projectStatusConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "ProjectStatus", Required: true}
	organizerEmailConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "OrganizerEmail", Required: true}
	projectStartConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "ProjectStart", Required: true}
	managerEmailConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "ManagerEmail", Required: true}
	assigneeEmailConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "AssigneeEmail", Required: true}
	cityConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "City", Required: true}
	severityConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "Severity", Required: true}
	buildingConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "Building", Required: true}
	floorConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "Floor", Required: true}
	roomConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "Room", Required: true}
	deskConstructorPart := &dbesdkdynamodbencryptiontypes.ConstructorPart{Name: "Desk", Required: true}

	// 6. Define constructors
	//    Constructors define how encrypted and signed parts are assembled into compound beacons.
	//    The constructors below are based off of the "PK Constructors", "SK constructors", etc. sections in Demo.md.

	// The employee ID constructor only requires an employee ID.
	// If an item has an attribute with name "EmployeeID", it will match this constructor.
	// If this is the first matching constructor in the constructor list (constructor list described more below),
	//     the compound beacon will use this constructor, and the compound beacon will be written as `E-X`.
	employeeIdConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*employeeIdConstructorPart}}
	ticketNumberConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*ticketNumberConstructorPart}}
	projectNameConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*projectNameConstructorPart}}
	ticketModTimeConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*ticketModTimeConstructorPart}}
	buildingConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*buildingConstructorPart}}

	// This constructor requires all of "MeetingStart", "Location.Floor", and "Location.Room" attributes.
	// If an item has all of these attributes, it will match this constructor.
	// If this is the first matching constructor in the constructor list (constructor list described more below),
	//     the compound beacon will use this constructor, and the compound beacon will be written as `MS-X~F-Y~R-Z`.
	// In a constructor with multiple constructor parts, the order the constructor parts are added to
	//     the constructor part list defines how the compound beacon is written.
	// We can rearrange the beacon parts by changing the order the constructors were added to the list.
	meetingStartFloorRoomConstructor := dbesdkdynamodbencryptiontypes.Constructor{
		Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*meetingStartConstructorPart, *floorConstructorPart, *roomConstructorPart},
	}

	timeCardStartEmployeeEmailConstructor := dbesdkdynamodbencryptiontypes.Constructor{
		Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*timeCardStartConstructorPart, *employeeEmailConstructorPart},
	}
	timeCardStartConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*timeCardStartConstructorPart}}
	creatorEmailConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*creatorEmailConstructorPart}}
	projectStatusConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*projectStatusConstructorPart}}
	employeeEmailConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*employeeEmailConstructorPart}}
	organizerEmailConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*organizerEmailConstructorPart}}
	projectStartConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*projectStartConstructorPart}}
	managerEmailConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*managerEmailConstructorPart}}
	assigneeEmailConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*assigneeEmailConstructorPart}}
	cityConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*cityConstructorPart}}
	severityConstructor := dbesdkdynamodbencryptiontypes.Constructor{Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*severityConstructorPart}}
	buildingFloorDeskConstructor := dbesdkdynamodbencryptiontypes.Constructor{
		Parts: []dbesdkdynamodbencryptiontypes.ConstructorPart{*buildingConstructorPart, *floorConstructorPart, *deskConstructorPart},
	}

	// 7. Add constructors to the compound beacon constructor list in desired construction order.
	//    In a compound beacon with multiple constructors, the order the constructors are added to
	//        the constructor list determines their priority.
	//    The first constructor added to a constructor list will be the first constructor that is executed.
	//    The client will evaluate constructors until one matches, and will use the first one that matches.
	//    If no constructors match, an attribute value is not written for that beacon.
	//    A general strategy is to add constructors with unique conditions at the beginning of the list,
	//       and add constructors with general conditions at the end of the list. This would allow a given
	//       item would trigger the constructor most specific to its attributes.
	pk0ConstructorList := []dbesdkdynamodbencryptiontypes.Constructor{
		employeeIdConstructor,
		buildingConstructor,
		ticketNumberConstructor,
		projectNameConstructor,
	}

	sk0ConstructorList := []dbesdkdynamodbencryptiontypes.Constructor{
		ticketModTimeConstructor,
		meetingStartFloorRoomConstructor,
		timeCardStartEmployeeEmailConstructor,
		projectNameConstructor,
		employeeIdConstructor,
	}

	pk1ConstructorList := []dbesdkdynamodbencryptiontypes.Constructor{
		creatorEmailConstructor,
		employeeEmailConstructor,
		projectStatusConstructor,
		organizerEmailConstructor,
	}

	sk1ConstructorList := []dbesdkdynamodbencryptiontypes.Constructor{
		meetingStartFloorRoomConstructor,
		timeCardStartConstructor,
		ticketModTimeConstructor,
		projectStartConstructor,
		employeeIdConstructor,
	}

	pk2ConstructorList := []dbesdkdynamodbencryptiontypes.Constructor{
		managerEmailConstructor,
		assigneeEmailConstructor,
	}

	pk3ConstructorList := []dbesdkdynamodbencryptiontypes.Constructor{
		cityConstructor,
		severityConstructor,
	}

	sk3ConstructorList := []dbesdkdynamodbencryptiontypes.Constructor{
		buildingFloorDeskConstructor,
		ticketModTimeConstructor,
	}

	// 8. Define compound beacons
	//    Compound beacon construction is defined in more detail in CompoundBeaconSearchableEncryptionExample.
	//    Note that the split character must be a character that is not used in any attribute value.
	compoundBeaconList := []dbesdkdynamodbencryptiontypes.CompoundBeacon{
		{Name: "PK", Split: "~", Constructors: pk0ConstructorList},
		{Name: "SK", Split: "~", Constructors: sk0ConstructorList},
		{Name: "PK1", Split: "~", Constructors: pk1ConstructorList},
		{Name: "SK1", Split: "~", Constructors: sk1ConstructorList},
		{Name: "PK2", Split: "~", Constructors: pk2ConstructorList},
		{Name: "PK3", Split: "~", Constructors: pk3ConstructorList},
		{Name: "SK3", Split: "~", Constructors: sk3ConstructorList},
	}

	// 9. Create BeaconVersion.
	beaconVersion := &dbesdkdynamodbencryptiontypes.BeaconVersion{
		StandardBeacons: standardBeaconList,
		CompoundBeacons: compoundBeaconList,
		EncryptedParts:  encryptedPartList,
		SignedParts:     signedPartList,
		Version:         1, // MUST be 1
		KeyStore:        keyStore,
		KeySource: &dbesdkdynamodbencryptiontypes.BeaconKeySourceMembersingle{
			Value: dbesdkdynamodbencryptiontypes.SingleKeyStore{
				KeyId:    branchKeyId,
				CacheTTL: 6000,
			},
		},
	}

	beaconVersions := []dbesdkdynamodbencryptiontypes.BeaconVersion{*beaconVersion}

	// 10. Create a Hierarchical Keyring
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	hierarchicalKeyringInput := mpltypes.CreateAwsKmsHierarchicalKeyringInput{
		KeyStore:    keyStore,
		BranchKeyId: &branchKeyId,
		TtlSeconds:  6000, // This dictates how often we call back to KMS to authorize use of the branch keys
	}

	kmsKeyring, err := matProv.CreateAwsKmsHierarchicalKeyring(context.Background(), hierarchicalKeyringInput)
	utils.HandleError(err)

	// 11. Define crypto actions
	attributeActionsOnEncrypt := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		// Our partition key must be configured as SIGN_ONLY
		"partition_key": dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		// Attributes used in beacons must be configured as ENCRYPT_AND_SIGN
		"EmployeeID":     dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"TicketNumber":   dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"ProjectName":    dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"EmployeeName":   dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"EmployeeEmail":  dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"CreatorEmail":   dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"ProjectStatus":  dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"OrganizerEmail": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"ManagerEmail":   dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"AssigneeEmail":  dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"City":           dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"Severity":       dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"Location":       dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		// These are not beaconized attributes, but are sensitive data that must be encrypted
		"Attendees": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"Subject":   dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		// signed parts and unencrypted attributes can be configured as SIGN_ONLY or DO_NOTHING
		// For this example, we will set these to SIGN_ONLY to ensure authenticity
		"TicketModTime": dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"MeetingStart":  dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"TimeCardStart": dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"EmployeeTitle": dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"Description":   dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"ProjectTarget": dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"Hours":         dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"Role":          dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"Message":       dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"ProjectStart":  dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"Duration":      dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
	}

	// 12. Set up table config
	tableConfig := &dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:          ddbTableName,
		PartitionKeyName:          "partition_key",
		AttributeActionsOnEncrypt: attributeActionsOnEncrypt,
		Keyring:                   kmsKeyring,
		Search: &dbesdkdynamodbencryptiontypes.SearchConfig{
			WriteVersion: 1, // MUST be 1
			Versions:     beaconVersions,
		},
	}

	tableConfigs := map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		ddbTableName: *tableConfig,
	}

	// 13. Create the DynamoDb Encryption Interceptor
	encryptionConfig := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigs,
	}

	// 14. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(encryptionConfig)
	utils.HandleError(err)
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	return ddb, nil
}
