package software.amazon.cryptography.examples.searchableencryption.complexexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyOutput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

public class BeaconConfig {

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

  public static DynamoDbClient SetupBeaconConfig(
    String ddbTableName,
    String branchKeyId,
    String branchKeyWrappingKmsKeyArn,
    String branchKeyDdbTableName
  ) {
    // 1. Create Keystore and branch key.
    //    These are the same constructions as in the Basic examples, which describe this in more detail.
    KeyStore keyStore = KeyStore
      .builder()
      .KeyStoreConfig(
        KeyStoreConfig
          .builder()
          .kmsClient(KmsClient.create())
          .ddbClient(DynamoDbClient.create())
          .ddbTableName(branchKeyDdbTableName)
          .logicalKeyStoreName(branchKeyDdbTableName)
          .kmsConfiguration(
            KMSConfiguration
              .builder()
              .kmsKeyArn(branchKeyWrappingKmsKeyArn)
              .build()
          )
          .build()
      )
      .build();

    // 2. Create standard beacons
    //    For this example, we use a standard beacon length of 4.
    //    The BasicSearchableEncryptionExample gives a more thorough consideration of beacon length.
    //    For production applications, one should always exercise rigor when deciding beacon length, including
    //        examining population size and considering performance.
    List<StandardBeacon> standardBeaconList = Arrays.asList(
      StandardBeacon.builder().name("EmployeeID").length(4).build(),
      StandardBeacon.builder().name("TicketNumber").length(4).build(),
      StandardBeacon.builder().name("ProjectName").length(4).build(),
      StandardBeacon.builder().name("EmployeeEmail").length(4).build(),
      StandardBeacon.builder().name("CreatorEmail").length(4).build(),
      StandardBeacon.builder().name("ProjectStatus").length(4).build(),
      StandardBeacon.builder().name("OrganizerEmail").length(4).build(),
      StandardBeacon.builder().name("ManagerEmail").length(4).build(),
      StandardBeacon.builder().name("AssigneeEmail").length(4).build(),
      StandardBeacon
        .builder()
        .name("City")
        .loc("Location.City")
        .length(4)
        .build(),
      StandardBeacon.builder().name("Severity").length(4).build(),
      StandardBeacon
        .builder()
        .name("Building")
        .loc("Location.Building")
        .length(4)
        .build(),
      StandardBeacon
        .builder()
        .name("Floor")
        .loc("Location.Floor")
        .length(4)
        .build(),
      StandardBeacon
        .builder()
        .name("Room")
        .loc("Location.Room")
        .length(4)
        .build(),
      StandardBeacon
        .builder()
        .name("Desk")
        .loc("Location.Desk")
        .length(4)
        .build()
    );

    // 3. Define encrypted parts
    //    Note that some of the prefixes are modified from the suggested prefixes in Demo.md.
    //    This is because all prefixes must be unique in a configuration.
    //    Encrypted parts are described in more detail in the CompoundBeaconSearcbaleEncryptionExample.
    List<EncryptedPart> encryptedPartList = Arrays.asList(
      EncryptedPart.builder().name("EmployeeID").prefix("E-").build(),
      EncryptedPart.builder().name("TicketNumber").prefix("T-").build(),
      EncryptedPart.builder().name("ProjectName").prefix("P-").build(),
      EncryptedPart.builder().name("EmployeeEmail").prefix("EE-").build(),
      EncryptedPart.builder().name("CreatorEmail").prefix("CE-").build(),
      EncryptedPart.builder().name("ProjectStatus").prefix("PSts-").build(),
      EncryptedPart.builder().name("OrganizerEmail").prefix("OE-").build(),
      EncryptedPart.builder().name("ManagerEmail").prefix("ME-").build(),
      EncryptedPart.builder().name("AssigneeEmail").prefix("AE-").build(),
      EncryptedPart.builder().name("City").prefix("C-").build(),
      EncryptedPart.builder().name("Severity").prefix("S-").build(),
      EncryptedPart.builder().name("Building").prefix("B-").build(),
      EncryptedPart.builder().name("Floor").prefix("F-").build(),
      EncryptedPart.builder().name("Room").prefix("R-").build(),
      EncryptedPart.builder().name("Desk").prefix("D-").build()
    );

    // 4. Define signed parts.
    //    These are unencrypted attributes we would like to use in beacon queries.
    //    In this example, all of these represent dates or times.
    //    Keeping these attributes unencrypted allows us to use them in comparison-based queries. If a signed
    //        part is the first part in a compound beacon, then that part can be used in comparison for sorting.
    List<SignedPart> signedPartList = Arrays.asList(
      SignedPart.builder().name("TicketModTime").prefix("M-").build(),
      SignedPart.builder().name("MeetingStart").prefix("MS-").build(),
      SignedPart.builder().name("TimeCardStart").prefix("TC-").build(),
      SignedPart.builder().name("ProjectStart").prefix("PS-").build()
    );

    // 5. Create constructor parts.
    //    Constructor parts are used to assemble constructors (constructors described more in next step).
    //    For each attribute that will be used in a constructor, there must be a corresponding constructor part.
    //    A constructor part must receive:
    //     - name: Name of a standard beacon
    //     - required: Whether this attribute must be present in the item to match a constructor
    //    In this example, we will define each constructor part once and re-use it across multiple constructors.
    //    The parts below are defined by working backwards from the constructors in "PK Constructors",
    //        "SK constructors", etc. sections in Demo.md.
    ConstructorPart employeeIdConstructorPart = ConstructorPart
      .builder()
      // This name comes from the "EmployeeID" standard beacon.
      .name("EmployeeID")
      .required(true)
      .build();
    ConstructorPart ticketNumberConstructorPart = ConstructorPart
      .builder()
      .name("TicketNumber")
      .required(true)
      .build();
    ConstructorPart projectNameConstructorPart = ConstructorPart
      .builder()
      .name("ProjectName")
      .required(true)
      .build();
    ConstructorPart ticketModTimeConstructorPart = ConstructorPart
      .builder()
      .name("TicketModTime")
      .required(true)
      .build();
    ConstructorPart meetingStartConstructorPart = ConstructorPart
      .builder()
      .name("MeetingStart")
      .required(true)
      .build();
    ConstructorPart timeCardStartConstructorPart = ConstructorPart
      .builder()
      .name("TimeCardStart")
      .required(true)
      .build();
    ConstructorPart employeeEmailConstructorPart = ConstructorPart
      .builder()
      .name("EmployeeEmail")
      .required(true)
      .build();
    ConstructorPart creatorEmailConstructorPart = ConstructorPart
      .builder()
      .name("CreatorEmail")
      .required(true)
      .build();
    ConstructorPart projectStatusConstructorPart = ConstructorPart
      .builder()
      .name("ProjectStatus")
      .required(true)
      .build();
    ConstructorPart organizerEmailConstructorPart = ConstructorPart
      .builder()
      .name("OrganizerEmail")
      .required(true)
      .build();
    ConstructorPart projectStartConstructorPart = ConstructorPart
      .builder()
      .name("ProjectStart")
      .required(true)
      .build();
    ConstructorPart managerEmailConstructorPart = ConstructorPart
      .builder()
      .name("ManagerEmail")
      .required(true)
      .build();
    ConstructorPart assigneeEmailConstructorPart = ConstructorPart
      .builder()
      .name("AssigneeEmail")
      .required(true)
      .build();
    ConstructorPart cityConstructorPart = ConstructorPart
      .builder()
      .name("City")
      .required(true)
      .build();
    ConstructorPart severityConstructorPart = ConstructorPart
      .builder()
      .name("Severity")
      .required(true)
      .build();
    ConstructorPart buildingConstructorPart = ConstructorPart
      .builder()
      .name("Building")
      .required(true)
      .build();
    ConstructorPart floorConstructorPart = ConstructorPart
      .builder()
      .name("Floor")
      .required(true)
      .build();
    ConstructorPart roomConstructorPart = ConstructorPart
      .builder()
      .name("Room")
      .required(true)
      .build();
    ConstructorPart deskConstructorPart = ConstructorPart
      .builder()
      .name("Desk")
      .required(true)
      .build();

    // 6. Define constructors
    //    Constructors define how encrypted and signed parts are assembled into compound beacons.
    //    The constructors below are based off of the "PK Constructors", "SK constructors", etc. sections in Demo.md.

    // The employee ID constructor only requires an employee ID.
    // If an item has an attribute with name "EmployeeID", it will match this constructor.
    // If this is the first matching constructor in the constructor list (constructor list described more below),
    //     the compound beacon will use this constructor, and the compound beacon will be written as `E-X`.
    Constructor employeeIdConstructor = Constructor
      .builder()
      .parts(Arrays.asList(employeeIdConstructorPart))
      .build();

    Constructor ticketNumberConstructor = Constructor
      .builder()
      .parts(Arrays.asList(ticketNumberConstructorPart))
      .build();

    Constructor projectNameConstructor = Constructor
      .builder()
      .parts(Arrays.asList(projectNameConstructorPart))
      .build();

    Constructor ticketModTimeConstructor = Constructor
      .builder()
      .parts(Arrays.asList(ticketModTimeConstructorPart))
      .build();

    Constructor buildingConstructor = Constructor
      .builder()
      .parts(Arrays.asList(buildingConstructorPart))
      .build();

    // This constructor requires all of "MeetingStart", "Location.Floor", and "Location.Room" attributes.
    // If an item has all of these attributes, it will match this constructor.
    // If this is the first matching constructor in the constructor list (constructor list described more below),
    //     the compound beacon will use this constructor, and the compound beacon will be written as `MS-X~F-Y~R-Z`.
    // In a constructor with multiple constructor parts, the order the constructor parts are added to
    //     the constructor part list defines how the compound beacon is written.
    // We can rearrange the beacon parts by changing the order the constructors were added to the list.
    Constructor meetingStartFloorRoomConstructor = Constructor
      .builder()
      .parts(
        Arrays.asList(
          meetingStartConstructorPart,
          floorConstructorPart,
          roomConstructorPart
        )
      )
      .build();

    Constructor timeCardStartEmployeeEmailConstructor = Constructor
      .builder()
      .parts(
        Arrays.asList(
          timeCardStartConstructorPart,
          employeeEmailConstructorPart
        )
      )
      .build();

    Constructor timeCardStartConstructor = Constructor
      .builder()
      .parts(Arrays.asList(timeCardStartConstructorPart))
      .build();

    Constructor creatorEmailConstructor = Constructor
      .builder()
      .parts(Arrays.asList(creatorEmailConstructorPart))
      .build();

    Constructor projectStatusConstructor = Constructor
      .builder()
      .parts(Arrays.asList(projectStatusConstructorPart))
      .build();

    Constructor employeeEmailConstructor = Constructor
      .builder()
      .parts(Arrays.asList(employeeEmailConstructorPart))
      .build();

    Constructor organizerEmailConstructor = Constructor
      .builder()
      .parts(Arrays.asList(organizerEmailConstructorPart))
      .build();

    Constructor projectStartConstructor = Constructor
      .builder()
      .parts(Arrays.asList(projectStartConstructorPart))
      .build();

    Constructor managerEmailConstructor = Constructor
      .builder()
      .parts(Arrays.asList(managerEmailConstructorPart))
      .build();

    Constructor assigneeEmailConstructor = Constructor
      .builder()
      .parts(Arrays.asList(assigneeEmailConstructorPart))
      .build();

    Constructor cityConstructor = Constructor
      .builder()
      .parts(Arrays.asList(cityConstructorPart))
      .build();

    Constructor severityConstructor = Constructor
      .builder()
      .parts(Arrays.asList(severityConstructorPart))
      .build();

    Constructor buildingFloorDeskConstructor = Constructor
      .builder()
      .parts(
        Arrays.asList(
          buildingConstructorPart,
          floorConstructorPart,
          deskConstructorPart
        )
      )
      .build();

    // 7. Add constructors to the compound beacon constructor list in desired construction order.
    //    In a compound beacon with multiple constructors, the order the constructors are added to
    //        the constructor list determines their priority.
    //    The first constructor added to a constructor list will be the first constructor that is executed.
    //    The client will evaluate constructors until one matches, and will use the first one that matches.
    //    If no constructors match, an attribute value is not written for that beacon.
    //    A general strategy is to add constructors with unique conditions at the beginning of the list,
    //       and add constructors with general conditions at the end of the list. This would allow a given
    //       item would trigger the constructor most specific to its attributes.
    List<Constructor> pk0ConstructorList = new ArrayList<>();
    pk0ConstructorList.add(employeeIdConstructor);
    pk0ConstructorList.add(buildingConstructor);
    pk0ConstructorList.add(ticketNumberConstructor);
    pk0ConstructorList.add(projectNameConstructor);

    List<Constructor> sk0ConstructorList = new ArrayList<>();
    sk0ConstructorList.add(ticketModTimeConstructor);
    sk0ConstructorList.add(meetingStartFloorRoomConstructor);
    sk0ConstructorList.add(timeCardStartEmployeeEmailConstructor);
    sk0ConstructorList.add(projectNameConstructor);
    sk0ConstructorList.add(employeeIdConstructor);

    List<Constructor> pk1ConstructorList = new ArrayList<>();
    pk1ConstructorList.add(creatorEmailConstructor);
    pk1ConstructorList.add(employeeEmailConstructor);
    pk1ConstructorList.add(projectStatusConstructor);
    pk1ConstructorList.add(organizerEmailConstructor);

    List<Constructor> sk1ConstructorList = new ArrayList<>();
    sk1ConstructorList.add(meetingStartFloorRoomConstructor);
    sk1ConstructorList.add(timeCardStartConstructor);
    sk1ConstructorList.add(ticketModTimeConstructor);
    sk1ConstructorList.add(projectStartConstructor);
    sk1ConstructorList.add(employeeIdConstructor);

    List<Constructor> pk2ConstructorList = new ArrayList<>();
    pk2ConstructorList.add(managerEmailConstructor);
    pk2ConstructorList.add(assigneeEmailConstructor);

    List<Constructor> pk3ConstructorList = new ArrayList<>();
    pk3ConstructorList.add(cityConstructor);
    pk3ConstructorList.add(severityConstructor);

    List<Constructor> sk3ConstructorList = new ArrayList<>();
    sk3ConstructorList.add(buildingFloorDeskConstructor);
    sk3ConstructorList.add(ticketModTimeConstructor);

    // 8. Define compound beacons
    //    Compound beacon construction is defined in more detail in CompoundBeaconSearchableEncryptionExample.
    //    Note that the split character must be a character that is not used in any attribute value.
    List<CompoundBeacon> compoundBeaconList = Arrays.asList(
      CompoundBeacon
        .builder()
        .name("PK")
        .split("~")
        .constructors(pk0ConstructorList)
        .build(),
      CompoundBeacon
        .builder()
        .name("SK")
        .split("~")
        .constructors(sk0ConstructorList)
        .build(),
      CompoundBeacon
        .builder()
        .name("PK1")
        .split("~")
        .constructors(pk1ConstructorList)
        .build(),
      CompoundBeacon
        .builder()
        .name("SK1")
        .split("~")
        .constructors(sk1ConstructorList)
        .build(),
      CompoundBeacon
        .builder()
        .name("PK2")
        .split("~")
        .constructors(pk2ConstructorList)
        .build(),
      CompoundBeacon
        .builder()
        .name("PK3")
        .split("~")
        .constructors(pk3ConstructorList)
        .build(),
      CompoundBeacon
        .builder()
        .name("SK3")
        .split("~")
        .constructors(sk3ConstructorList)
        .build()
    );

    // 9. Create BeaconVersion.
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
      BeaconVersion
        .builder()
        .standardBeacons(standardBeaconList)
        .compoundBeacons(compoundBeaconList)
        .encryptedParts(encryptedPartList)
        .signedParts(signedPartList)
        .version(1) // MUST be 1
        .keyStore(keyStore)
        .keySource(
          BeaconKeySource
            .builder()
            .single(
              SingleKeyStore.builder().keyId(branchKeyId).cacheTTL(6000).build()
            )
            .build()
        )
        .build()
    );

    // 10. Create a Hierarchical Keyring
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    CreateAwsKmsHierarchicalKeyringInput keyringInput =
      CreateAwsKmsHierarchicalKeyringInput
        .builder()
        .branchKeyId(branchKeyId)
        .keyStore(keyStore)
        .ttlSeconds(6000l)
        .build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(
      keyringInput
    );

    // 11. Define crypto actions
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    // Our partition key must be configured as SIGN_ONLY
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY);
    // Attributes used in beacons must be configured as ENCRYPT_AND_SIGN
    attributeActionsOnEncrypt.put("EmployeeID", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put(
      "TicketNumber",
      CryptoAction.ENCRYPT_AND_SIGN
    );
    attributeActionsOnEncrypt.put("ProjectName", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put(
      "EmployeeName",
      CryptoAction.ENCRYPT_AND_SIGN
    );
    attributeActionsOnEncrypt.put(
      "EmployeeEmail",
      CryptoAction.ENCRYPT_AND_SIGN
    );
    attributeActionsOnEncrypt.put(
      "CreatorEmail",
      CryptoAction.ENCRYPT_AND_SIGN
    );
    attributeActionsOnEncrypt.put(
      "ProjectStatus",
      CryptoAction.ENCRYPT_AND_SIGN
    );
    attributeActionsOnEncrypt.put(
      "OrganizerEmail",
      CryptoAction.ENCRYPT_AND_SIGN
    );
    attributeActionsOnEncrypt.put(
      "ManagerEmail",
      CryptoAction.ENCRYPT_AND_SIGN
    );
    attributeActionsOnEncrypt.put(
      "AssigneeEmail",
      CryptoAction.ENCRYPT_AND_SIGN
    );
    attributeActionsOnEncrypt.put("City", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("Severity", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("Location", CryptoAction.ENCRYPT_AND_SIGN);
    // These are not beaconized attributes, but are sensitive data that must be encrypted
    attributeActionsOnEncrypt.put("Attendees", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("Subject", CryptoAction.ENCRYPT_AND_SIGN);
    // signed parts and unencrypted attributes can be configured as SIGN_ONLY or DO_NOTHING
    // For this example, we will set these to SIGN_ONLY to ensure authenticity
    attributeActionsOnEncrypt.put("TicketModTime", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("MeetingStart", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("TimeCardStart", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("EmployeeTitle", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("Description", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("ProjectTarget", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("Hours", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("Role", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("Message", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("ProjectStart", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("Duration", CryptoAction.SIGN_ONLY);

    // 12. Set up table config
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("partition_key")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(kmsKeyring)
      .search(
        SearchConfig
          .builder()
          .writeVersion(1) // MUST be 1
          .versions(beaconVersions)
          .build()
      )
      .build();
    tableConfigs.put(ddbTableName, config);

    // 13. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor =
      DynamoDbEncryptionInterceptor
        .builder()
        .config(
          DynamoDbTablesEncryptionConfig
            .builder()
            .tableEncryptionConfigs(tableConfigs)
            .build()
        )
        .build();

    // 14. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    return ddb;
  }
}
