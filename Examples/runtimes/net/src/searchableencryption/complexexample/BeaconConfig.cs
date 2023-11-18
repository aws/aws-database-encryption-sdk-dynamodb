using System;
using System.Collections.Generic;
using Amazon.DynamoDBv2;
using Amazon.KeyManagementService;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.KeyStore;
using AWS.Cryptography.MaterialProviders;

public class BeaconConfig
{
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

    public static AmazonDynamoDBClient SetupBeaconConfig(String ddbTableName, String branchKeyId,
        String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName)
    {
        // 1. Create Keystore and branch key.
        //    These are the same constructions as in the Basic examples, which describe this in more detail.
        KeyStore keyStore = new KeyStore(new KeyStoreConfig
        {
            KmsClient = new AmazonKeyManagementServiceClient(),
            DdbClient = new AmazonDynamoDBClient(),
            DdbTableName = branchKeyDdbTableName,
            LogicalKeyStoreName = branchKeyDdbTableName,
            KmsConfiguration = new KMSConfiguration { KmsKeyArn = branchKeyWrappingKmsKeyArn }
        });

        // 2. Create standard beacons
        //    For this example, we use a standard beacon length of 4.
        //    The BasicSearchableEncryptionExample gives a more thorough consideration of beacon length.
        //    For production applications, one should always exercise rigor when deciding beacon length, including
        //        examining population size and considering performance.
        var standardBeaconList = new List<StandardBeacon>
        {
            new StandardBeacon { Name = "EmployeeID", Length = 4 },
            new StandardBeacon { Name = "TicketNumber", Length = 4 },
            new StandardBeacon { Name = "ProjectName", Length = 4 },
            new StandardBeacon { Name = "EmployeeEmail", Length = 4 },
            new StandardBeacon { Name = "CreatorEmail", Length = 4 },
            new StandardBeacon { Name = "ProjectStatus", Length = 4 },
            new StandardBeacon { Name = "OrganizerEmail", Length = 4 },
            new StandardBeacon { Name = "ManagerEmail", Length = 4 },
            new StandardBeacon { Name = "AssigneeEmail", Length = 4 },
            new StandardBeacon { Name = "Severity", Length = 4 },
            new StandardBeacon { Name = "City", Loc = "Location.City", Length = 4 },
            new StandardBeacon { Name = "Building", Loc = "Location.Building", Length = 4 },
            new StandardBeacon { Name = "Floor", Loc = "Location.Floor", Length = 4 },
            new StandardBeacon { Name = "Room", Loc = "Location.Room", Length = 4 },
            new StandardBeacon { Name = "Desk", Loc = "Location.Desk", Length = 4 },
        };

        // 3. Define encrypted parts
        //    Note that some of the prefixes are modified from the suggested prefixes in Demo.md.
        //    This is because all prefixes must be unique in a configuration.
        //    Encrypted parts are described in more detail in the CompoundBeaconSearchableEncryptionExample.
        var encryptedPartsList = new List<EncryptedPart>
        {
            new EncryptedPart { Name = "EmployeeID", Prefix = "E-" },
            new EncryptedPart { Name = "TicketNumber", Prefix = "T-" },
            new EncryptedPart { Name = "ProjectName", Prefix = "P-" },
            new EncryptedPart { Name = "EmployeeEmail", Prefix = "EE-" },
            new EncryptedPart { Name = "CreatorEmail", Prefix = "CE-" },
            new EncryptedPart { Name = "OrganizerEmail", Prefix = "OE-" },
            new EncryptedPart { Name = "ManagerEmail", Prefix = "ME-" },
            new EncryptedPart { Name = "AssigneeEmail", Prefix = "AE-" },
            new EncryptedPart { Name = "ProjectStatus", Prefix = "PSts-" },
            new EncryptedPart { Name = "City", Prefix = "C-" },
            new EncryptedPart { Name = "Severity", Prefix = "S-" },
            new EncryptedPart { Name = "Building", Prefix = "B-" },
            new EncryptedPart { Name = "Floor", Prefix = "F-" },
            new EncryptedPart { Name = "Room", Prefix = "R-" },
            new EncryptedPart { Name = "Desk", Prefix = "D-" }
        };


        // 4. Define signed parts.
        //    These are unencrypted attributes we would like to use in beacon queries.
        //    In this example, all of these represent dates or times.
        //    Keeping these attributes unencrypted allows us to use them in comparison-based queries. If a signed
        //        part is the first part in a compound beacon, then that part can be used in comparison for sorting.
        var signedPartsList = new List<SignedPart>
        {
            new SignedPart { Name = "TicketModTime", Prefix = "M-" },
            new SignedPart { Name = "MeetingStart", Prefix = "MS-" },
            new SignedPart { Name = "TimeCardStart", Prefix = "TC-" },
            new SignedPart { Name = "ProjectStart", Prefix = "PS-" }
        };

        // 6. Create constructor parts.
        //    Constructor parts are used to assemble constructors (constructors described more in next step).
        //    For each attribute that will be used in a constructor, there must be a corresponding constructor part.
        //    A constructor part must receive:
        //     - name: Name of a standard beacon
        //     - required: Whether this attribute must be present in the item to match a constructor
        //    In this example, we will define each constructor part once and re-use it across multiple constructors.
        //    The parts below are defined by working backwards from the constructors in "PK Constructors",
        //        "SK constructors", etc. sections in Demo.md.
        var employeeIdConstructorPart = new ConstructorPart { Name = "EmployeeID", Required = true };
        var ticketNumberConstructorPart = new ConstructorPart { Name = "TicketNumber", Required = true };
        var projectNameConstructorPart = new ConstructorPart { Name = "ProjectName", Required = true };
        var ticketModTimeConstructorPart = new ConstructorPart { Name = "TicketModTime", Required = true };
        var meetingStartConstructorPart = new ConstructorPart { Name = "MeetingStart", Required = true };
        var timeCardStartConstructorPart = new ConstructorPart { Name = "TimeCardStart", Required = true };
        var employeeEmailConstructorPart = new ConstructorPart { Name = "EmployeeEmail", Required = true };
        var creatorEmailConstructorPart = new ConstructorPart { Name = "CreatorEmail", Required = true };
        var projectStatusConstructorPart = new ConstructorPart { Name = "ProjectStatus", Required = true };
        var organizerEmailConstructorPart = new ConstructorPart { Name = "OrganizerEmail", Required = true };
        var projectStartConstructorPart = new ConstructorPart { Name = "ProjectStart", Required = true };
        var managerEmailConstructorPart = new ConstructorPart { Name = "ManagerEmail", Required = true };
        var assigneeEmailConstructorPart = new ConstructorPart { Name = "AssigneeEmail", Required = true };
        var cityConstructorPart = new ConstructorPart { Name = "City", Required = true };
        var severityConstructorPart = new ConstructorPart { Name = "Severity", Required = true };
        var buildingConstructorPart = new ConstructorPart { Name = "Building", Required = true };
        var floorConstructorPart = new ConstructorPart { Name = "Floor", Required = true };
        var roomConstructorPart = new ConstructorPart { Name = "Room", Required = true };
        var deskConstructorPart = new ConstructorPart { Name = "Desk", Required = true };

        // 7. Define constructors
        //    Constructors define how encrypted and signed parts are assembled into compound beacons.
        //    The constructors below are based off of the "PK Constructors", "SK constructors", etc. sections in Demo.md.

        // The employee ID constructor only requires an employee ID.
        // If an item has an attribute with name "EmployeeID", it will match this constructor.
        // If this is the first matching constructor in the constructor list (constructor list described more below),
        //     the compound beacon will use this constructor, and the compound beacon will be written as `E-X`.
        var employeeIdConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { employeeIdConstructorPart }
        };
        var ticketNumberConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { ticketNumberConstructorPart }
        };
        var projectNameConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { projectNameConstructorPart }
        };
        var ticketModTimeConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { ticketModTimeConstructorPart }
        };
        var buildingConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { buildingConstructorPart }
        };

        // This constructor requires all of "MeetingStart", "Location.Floor", and "Location.Room" attributes.
        // If an item has all of these attributes, it will match this constructor.
        // If this is the first matching constructor in the constructor list (constructor list described more below),
        //     the compound beacon will use this constructor, and the compound beacon will be written as `MS-X~F-Y~R-Z`.
        // In a constructor with multiple constructor parts, the order the constructor parts are added to
        //     the constructor part list defines how the compound beacon is written.
        // We can rearrange the beacon parts by changing the order the constructors were added to the list.
        var meetingStartFloorRoomConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { meetingStartConstructorPart, floorConstructorPart, roomConstructorPart }
        };
        var timeCardStartEmployeeEmailConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { timeCardStartConstructorPart, employeeEmailConstructorPart }
        };
        var timeCardStartConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { timeCardStartConstructorPart }
        };
        var creatorEmailConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { creatorEmailConstructorPart }
        };
        var projectStatusConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { projectStatusConstructorPart }
        };
        var employeeEmailConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { employeeEmailConstructorPart }
        };
        var organizerEmailConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { organizerEmailConstructorPart }
        };
        var projectStartConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { projectStartConstructorPart }
        };
        var managerEmailConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { managerEmailConstructorPart }
        };
        var assigneeEmailConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { assigneeEmailConstructorPart }
        };
        var cityConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { cityConstructorPart }
        };
        var severityConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { severityConstructorPart }
        };
        var buildingFloorDeskConstructor = new Constructor
        {
            Parts = new List<ConstructorPart> { buildingConstructorPart, floorConstructorPart, deskConstructorPart }
        };

        // 5. Add constructors to the compound beacon constructor list in desired construction order.
        //    In a compound beacon with multiple constructors, the order the constructors are added to
        //        the constructor list determines their priority.
        //    The first constructor added to a constructor list will be the first constructor that is executed.
        //    The client will evaluate constructors until one matches, and will use the first one that matches.
        //    If no constructors match, an attribute value is not written for that beacon.
        //    A general strategy is to add constructors with unique conditions at the beginning of the list,
        //       and add constructors with general conditions at the end of the list. This would allow a given
        //       item would trigger the constructor most specific to its attributes.
        var pk0ConstructorList = new List<Constructor>
        {
            employeeIdConstructor,
            buildingConstructor,
            ticketNumberConstructor,
            projectNameConstructor
        };
        var sk0ConstructorList = new List<Constructor>
        {
            ticketModTimeConstructor,
            meetingStartFloorRoomConstructor,
            timeCardStartEmployeeEmailConstructor,
            projectNameConstructor,
            employeeIdConstructor
        };
        var pk1ConstructorList = new List<Constructor>
        {
            creatorEmailConstructor,
            employeeEmailConstructor,
            projectStatusConstructor,
            organizerEmailConstructor
        };
        var sk1ConstructorList = new List<Constructor>
        {
            meetingStartFloorRoomConstructor,
            timeCardStartConstructor,
            ticketModTimeConstructor,
            projectStartConstructor,
            employeeIdConstructor
        };
        var pk2ConstructorList = new List<Constructor>
        {
            managerEmailConstructor,
            assigneeEmailConstructor
        };
        var pk3ConstructorList = new List<Constructor>
        {
            cityConstructor,
            severityConstructor
        };
        var sk3ConstructorList = new List<Constructor>
        {
            buildingFloorDeskConstructor,
            ticketModTimeConstructor
        };

        // 9. Define compound beacons
        //    Compound beacon construction is defined in more detail in CompoundBeaconSearchableEncryptionExample.
        //    Note that the split character must be a character that is not used in any attribute value.
        var compoundBeaconList = new List<CompoundBeacon>
        {
            new CompoundBeacon { Name = "PK", Split = "~", Constructors = pk0ConstructorList },
            new CompoundBeacon { Name = "SK", Split = "~", Constructors = sk0ConstructorList },
            new CompoundBeacon { Name = "PK1", Split = "~", Constructors = pk1ConstructorList },
            new CompoundBeacon { Name = "SK1", Split = "~", Constructors = sk1ConstructorList },
            new CompoundBeacon { Name = "PK2", Split = "~", Constructors = pk2ConstructorList },
            new CompoundBeacon { Name = "PK3", Split = "~", Constructors = pk3ConstructorList },
            new CompoundBeacon { Name = "SK3", Split = "~", Constructors = sk3ConstructorList }
        };

        // 10. Create BeaconVersion.
        var beaconVersions = new List<BeaconVersion>
        {
            new BeaconVersion
            {
                StandardBeacons = standardBeaconList,
                CompoundBeacons = compoundBeaconList,
                EncryptedParts = encryptedPartsList,
                SignedParts = signedPartsList,
                Version = 1, // MUST be 1
                KeyStore = keyStore,
                KeySource = new BeaconKeySource
                {
                    Single = new SingleKeyStore
                    {
                        KeyId = branchKeyId,
                        CacheTTL = 6000
                    }
                }
            }
        };

        // 11. Create a Hierarchical Keyring
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var keyringInput = new CreateAwsKmsHierarchicalKeyringInput
        {
            BranchKeyId = branchKeyId,
            KeyStore = keyStore,
            TtlSeconds = 6000L
        };
        var kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

        // 12. Define crypto actions
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            // Our partition key must be configured as SIGN_ONLY
            ["partition_key"] = CryptoAction.SIGN_ONLY,
            // Attributes used in beacons must be configured as ENCRYPT_AND_SIGN
            ["EmployeeID"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["TicketNumber"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["ProjectName"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["EmployeeName"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["EmployeeEmail"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["CreatorEmail"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["ProjectStatus"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["OrganizerEmail"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["ManagerEmail"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["AssigneeEmail"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["City"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["Severity"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["Location"] = CryptoAction.ENCRYPT_AND_SIGN,
            // These are not beaconized attributes, but are sensitive data that must be encrypted
            ["Attendees"] = CryptoAction.ENCRYPT_AND_SIGN,
            ["Subject"] = CryptoAction.ENCRYPT_AND_SIGN,
            // signed parts and unencrypted attributes can be configured as SIGN_ONLY or DO_NOTHING
            // For this example, we will set these to SIGN_ONLY to ensure authenticity
            ["TicketModTime"] = CryptoAction.SIGN_ONLY,
            ["MeetingStart"] = CryptoAction.SIGN_ONLY,
            ["TimeCardStart"] = CryptoAction.SIGN_ONLY,
            ["EmployeeTitle"] = CryptoAction.SIGN_ONLY,
            ["Description"] = CryptoAction.SIGN_ONLY,
            ["ProjectTarget"] = CryptoAction.SIGN_ONLY,
            ["Hours"] = CryptoAction.SIGN_ONLY,
            ["Role"] = CryptoAction.SIGN_ONLY,
            ["Message"] = CryptoAction.SIGN_ONLY,
            ["ProjectStart"] = CryptoAction.SIGN_ONLY,
            ["Duration"] = CryptoAction.SIGN_ONLY
        };

        // 13. Set up table config
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = kmsKeyring,
                Search = new SearchConfig
                {
                    WriteVersion = 1, // MUST be 1
                    Versions = beaconVersions
                }
            }
        };

        // 15. Create a new AWS SDK DynamoDb client using the config above
        return new Client.DynamoDbClient(new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });
    }
}