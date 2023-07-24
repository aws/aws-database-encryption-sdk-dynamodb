package software.amazon.cryptography.examples.searchableencryption.complexexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyOutput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;

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

  public static DynamoDbClient SetupBeaconConfig(String ddbTableName, String branchKeyId, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

    // 1. Create Keystore and branch key.
    //    These are the same constructions as in the Basic examples, which describe this in more detail.
    KeyStore keyStore = KeyStore.builder()
        .KeyStoreConfig(KeyStoreConfig.builder()
            .kmsClient(KmsClient.create())
            .ddbClient(DynamoDbClient.create())
            .ddbTableName(branchKeyDdbTableName)
            .logicalKeyStoreName(branchKeyDdbTableName)
            .kmsConfiguration(KMSConfiguration.builder().kmsKeyArn(branchKeyWrappingKmsKeyArn).build())
            .build())
        .build();

    // 2. Create standard beacons
    //    For this example, we use a standard beacon length of 4.
    //    The BasicSearchableEncryptionExample gives a more thorough consideration of beacon length.
    //    For production applications, one should always exercise rigor when deciding beacon length, including
    //        examining population size and considering performance.
    StandardBeacon employeeIDStandardBeacon = StandardBeacon.builder()
        .name("EmployeeID")
        .length(4)
        .build();
    StandardBeacon ticketNumberStandardBeacon = StandardBeacon.builder()
        .name("TicketNumber")
        .length(4)
        .build();
    StandardBeacon projectNameStandardBeacon = StandardBeacon.builder()
        .name("ProjectName")
        .length(4)
        .build();
    StandardBeacon employeeEmailStandardBeacon = StandardBeacon.builder()
        .name("EmployeeEmail")
        .length(4)
        .build();
    StandardBeacon creatorEmailStandardBeacon = StandardBeacon.builder()
        .name("CreatorEmail")
        .length(4)
        .build();
    StandardBeacon projectStatusStandardBeacon = StandardBeacon.builder()
        .name("ProjectStatus")
        .length(4)
        .build();
    StandardBeacon organizerEmailStandardBeacon = StandardBeacon.builder()
        .name("OrganizerEmail")
        .length(4)
        .build();
    StandardBeacon managerEmailStandardBeacon = StandardBeacon.builder()
        .name("ManagerEmail")
        .length(4)
        .build();
    StandardBeacon assigneeEmailStandardBeacon = StandardBeacon.builder()
        .name("AssigneeEmail")
        .length(4)
        .build();
    StandardBeacon cityStandardBeacon = StandardBeacon.builder()
        .name("City")
        .loc("Location.City")
        .length(4)
        .build();
    StandardBeacon severityStandardBeacon = StandardBeacon.builder()
        .name("Severity")
        .length(4)
        .build();
    StandardBeacon buildingStandardBeacon = StandardBeacon.builder()
        .name("Building")
        .loc("Location.Building")
        .length(4)
        .build();
    StandardBeacon floorStandardBeacon = StandardBeacon.builder()
        .name("Floor")
        .loc("Location.Floor")
        .length(4)
        .build();
    StandardBeacon roomStandardBeacon = StandardBeacon.builder()
        .name("Room")
        .loc("Location.Room")
        .length(4)
        .build();
    StandardBeacon deskStandardBeacon = StandardBeacon.builder()
        .name("Desk")
        .loc("Location.Desk")
        .length(4)
        .build();

    List<StandardBeacon> standardBeaconList = new ArrayList<>();
    standardBeaconList.add(employeeIDStandardBeacon);
    standardBeaconList.add(ticketNumberStandardBeacon);
    standardBeaconList.add(projectNameStandardBeacon);
    standardBeaconList.add(employeeEmailStandardBeacon);
    standardBeaconList.add(creatorEmailStandardBeacon);
    standardBeaconList.add(projectStatusStandardBeacon);
    standardBeaconList.add(organizerEmailStandardBeacon);
    standardBeaconList.add(managerEmailStandardBeacon);
    standardBeaconList.add(assigneeEmailStandardBeacon);
    standardBeaconList.add(cityStandardBeacon);
    standardBeaconList.add(severityStandardBeacon);
    standardBeaconList.add(buildingStandardBeacon);
    standardBeaconList.add(floorStandardBeacon);
    standardBeaconList.add(roomStandardBeacon);
    standardBeaconList.add(deskStandardBeacon);

    // 3. Define encrypted parts
    //    Note that some of the prefixes are modified from the suggested prefixes in Demo.md.
    //    This is because all prefixes must be unique in a configuration.
    //    Encrypted parts are described in more detail in the CompoundBeaconSearcbaleEncryptionExample.
    EncryptedPart employeeIDEncryptedPart = EncryptedPart.builder()
        .name("EmployeeID")
        .prefix("E-")
        .build();
    EncryptedPart ticketNumberEncryptedPart = EncryptedPart.builder()
        .name("TicketNumber")
        .prefix("T-")
        .build();
    EncryptedPart projectNameEncryptedPart = EncryptedPart.builder()
        .name("ProjectName")
        .prefix("P-")
        .build();
    EncryptedPart employeeEmailEncryptedPart = EncryptedPart.builder()
        .name("EmployeeEmail")
        .prefix("EE-")
        .build();
    EncryptedPart creatorEmailEncryptedPart = EncryptedPart.builder()
        .name("CreatorEmail")
        .prefix("CE-")
        .build();
    EncryptedPart projectStatusEncryptedPart = EncryptedPart.builder()
        .name("ProjectStatus")
        .prefix("PSts-")
        .build();
    EncryptedPart organizerEmailEncryptedPart = EncryptedPart.builder()
        .name("OrganizerEmail")
        .prefix("OE-")
        .build();
    EncryptedPart managerEmailEncryptedPart = EncryptedPart.builder()
        .name("ManagerEmail")
        .prefix("ME-")
        .build();
    EncryptedPart assigneeEmailEncryptedPart = EncryptedPart.builder()
        .name("AssigneeEmail")
        .prefix("AE-")
        .build();
    EncryptedPart cityEncryptedPart = EncryptedPart.builder()
        .name("City")
        .prefix("C-")
        .build();
    EncryptedPart severityEncryptedPart = EncryptedPart.builder()
        .name("Severity")
        .prefix("S-")
        .build();
    EncryptedPart buildingEncryptedPart = EncryptedPart.builder()
        .name("Building")
        .prefix("B-")
        .build();
    EncryptedPart floorEncryptedPart = EncryptedPart.builder()
        .name("Floor")
        .prefix("F-")
        .build();
    EncryptedPart roomEncryptedPart = EncryptedPart.builder()
        .name("Room")
        .prefix("R-")
        .build();
    EncryptedPart deskEncryptedPart = EncryptedPart.builder()
        .name("Desk")
        .prefix("D-")
        .build();

    // 4. Define signed parts.
    //    These are unencrypted attributes we would like to use in beacon queries.
    //    In this example, all of these represent dates or times.
    //    Keeping these attributes unencrypted allows us to use them in comparison-based queries. If a signed
    //        part is the first part in a compound beacon, then that part can be used in comparison for sorting.
    SignedPart ticketModTimeSignedPart = SignedPart.builder()
        .name("TicketModTime")
        .prefix("M-")
        .build();
    SignedPart meetingStartSignedPart = SignedPart.builder()
        .name("MeetingStart")
        .prefix("MS-")
        .build();
    SignedPart timeCardStartSignedPart = SignedPart.builder()
        .name("TimeCardStart")
        .prefix("TC-")
        .build();
    SignedPart projectStartSignedPart = SignedPart.builder()
        .name("ProjectStart")
        .prefix("PS-")
        .build();

    // 5. Create lists of encrypted and signed parts for each GSI key
    List<EncryptedPart> pk0EncryptedPartList = new ArrayList<>();
    pk0EncryptedPartList.add(employeeIDEncryptedPart);
    pk0EncryptedPartList.add(ticketNumberEncryptedPart);
    pk0EncryptedPartList.add(projectNameEncryptedPart);
    pk0EncryptedPartList.add(buildingEncryptedPart);

    List<EncryptedPart> sk0EncryptedPartList = new ArrayList<>();
    sk0EncryptedPartList.add(employeeIDEncryptedPart);
    sk0EncryptedPartList.add(floorEncryptedPart);
    sk0EncryptedPartList.add(roomEncryptedPart);
    sk0EncryptedPartList.add(projectNameEncryptedPart);
    sk0EncryptedPartList.add(employeeEmailEncryptedPart);

    List<SignedPart> sk0SignedPartList = new ArrayList<>();
    sk0SignedPartList.add(timeCardStartSignedPart);
    sk0SignedPartList.add(ticketModTimeSignedPart);
    sk0SignedPartList.add(meetingStartSignedPart);

    List<EncryptedPart> pk1EncryptedPartList = new ArrayList<>();
    pk1EncryptedPartList.add(creatorEmailEncryptedPart);
    pk1EncryptedPartList.add(projectStatusEncryptedPart);
    pk1EncryptedPartList.add(organizerEmailEncryptedPart);
    pk1EncryptedPartList.add(employeeEmailEncryptedPart);

    List<EncryptedPart> sk1EncryptedPartList = new ArrayList<>();
    sk1EncryptedPartList.add(floorEncryptedPart);
    sk1EncryptedPartList.add(roomEncryptedPart);
    sk1EncryptedPartList.add(employeeIDEncryptedPart);

    List<SignedPart> sk1SignedPartList = new ArrayList<>();
    sk1SignedPartList.add(timeCardStartSignedPart);
    sk1SignedPartList.add(ticketModTimeSignedPart);
    sk1SignedPartList.add(meetingStartSignedPart);
    sk1SignedPartList.add(projectStartSignedPart);

    List<EncryptedPart> pk2EncryptedPartList = new ArrayList<>();
    pk2EncryptedPartList.add(managerEmailEncryptedPart);
    pk2EncryptedPartList.add(assigneeEmailEncryptedPart);

    List<EncryptedPart> pk3EncryptedPartList = new ArrayList<>();
    pk3EncryptedPartList.add(cityEncryptedPart);
    pk3EncryptedPartList.add(severityEncryptedPart);

    List<EncryptedPart> sk3EncryptedPartList = new ArrayList<>();
    sk3EncryptedPartList.add(buildingEncryptedPart);
    sk3EncryptedPartList.add(floorEncryptedPart);
    sk3EncryptedPartList.add(deskEncryptedPart);

    List<SignedPart> sk3SignedPartList = new ArrayList<>();
    sk3SignedPartList.add(ticketModTimeSignedPart);

    // 6. Create constructor parts.
    //    Constructor parts are used to assemble constructors (constructors described more in next step).
    //    For each attribute that will be used in a constructor, there must be a corresponding constructor part.
    //    A constructor part must receive:
    //     - name: Name of a standard beacon
    //     - required: Whether this attribute must be present in the item to match a constructor
    //    In this example, we will define each constructor part once and re-use it across multiple constructors.
    //    The parts below are defined by working backwards from the constructors in "PK Constructors",
    //        "SK constructors", etc. sections in Demo.md.
    ConstructorPart employeeIdConstructorPart = ConstructorPart.builder()
        // This name comes from the "EmployeeID" standard beacon.
        .name("EmployeeID")
        .required(true)
        .build();
    ConstructorPart ticketNumberConstructorPart = ConstructorPart.builder()
        .name("TicketNumber")
        .required(true)
        .build();
    ConstructorPart projectNameConstructorPart = ConstructorPart.builder()
        .name("ProjectName")
        .required(true)
        .build();
    ConstructorPart ticketModTimeConstructorPart = ConstructorPart.builder()
        .name("TicketModTime")
        .required(true)
        .build();
    ConstructorPart meetingStartConstructorPart = ConstructorPart.builder()
        .name("MeetingStart")
        .required(true)
        .build();
    ConstructorPart timeCardStartConstructorPart = ConstructorPart.builder()
        .name("TimeCardStart")
        .required(true)
        .build();
    ConstructorPart employeeEmailConstructorPart = ConstructorPart.builder()
        .name("EmployeeEmail")
        .required(true)
        .build();
    ConstructorPart creatorEmailConstructorPart = ConstructorPart.builder()
        .name("CreatorEmail")
        .required(true)
        .build();
    ConstructorPart projectStatusConstructorPart = ConstructorPart.builder()
        .name("ProjectStatus")
        .required(true)
        .build();
    ConstructorPart organizerEmailConstructorPart = ConstructorPart.builder()
        .name("OrganizerEmail")
        .required(true)
        .build();
    ConstructorPart projectStartConstructorPart = ConstructorPart.builder()
        .name("ProjectStart")
        .required(true)
        .build();
    ConstructorPart managerEmailConstructorPart = ConstructorPart.builder()
        .name("ManagerEmail")
        .required(true)
        .build();
    ConstructorPart assigneeEmailConstructorPart = ConstructorPart.builder()
        .name("AssigneeEmail")
        .required(true)
        .build();
    ConstructorPart cityConstructorPart = ConstructorPart.builder()
        .name("City")
        .required(true)
        .build();
    ConstructorPart severityConstructorPart = ConstructorPart.builder()
        .name("Severity")
        .required(true)
        .build();
    ConstructorPart buildingConstructorPart = ConstructorPart.builder()
        .name("Building")
        .required(true)
        .build();
    ConstructorPart floorConstructorPart = ConstructorPart.builder()
        .name("Floor")
        .required(true)
        .build();
    ConstructorPart roomConstructorPart = ConstructorPart.builder()
        .name("Room")
        .required(true)
        .build();
    ConstructorPart deskConstructorPart = ConstructorPart.builder()
        .name("Desk")
        .required(true)
        .build();

    // 7. Define constructors
    //    Constructors define how encrypted and signed parts are assembled into compound beacons.
    //    The constructors below are based off of the "PK Constructors", "SK constructors", etc. sections in Demo.md.

    // The employee ID constructor only requires an employee ID.
    // If an item has an attribute with name "EmployeeID", it will match this constructor.
    // If this is the first matching constructor in the constructor list (constructor list described more below),
    //     the compound beacon will use this constructor, and the compound beacon will be written as `E-X`.
    List<ConstructorPart> employeeIdConstructorPartList = new ArrayList<>();
    employeeIdConstructorPartList.add(employeeIdConstructorPart);
    Constructor employeeIdConstructor = Constructor.builder()
        .parts(employeeIdConstructorPartList)
        .build();

    List<ConstructorPart> ticketNumberConstructorPartList = new ArrayList<>();
    ticketNumberConstructorPartList.add(ticketNumberConstructorPart);
    Constructor ticketNumberConstructor = Constructor.builder()
        .parts(ticketNumberConstructorPartList)
        .build();

    List<ConstructorPart> projectNameConstructorPartList = new ArrayList<>();
    projectNameConstructorPartList.add(projectNameConstructorPart);
    Constructor projectNameConstructor = Constructor.builder()
        .parts(projectNameConstructorPartList)
        .build();

    List<ConstructorPart> ticketModTimeConstructorPartList = new ArrayList();
    ticketModTimeConstructorPartList.add(ticketModTimeConstructorPart);
    Constructor ticketModTimeConstructor = Constructor.builder()
        .parts(ticketModTimeConstructorPartList)
        .build();

    List<ConstructorPart> buildingConstructorPartList = new ArrayList();
    buildingConstructorPartList.add(buildingConstructorPart);
    Constructor buildingConstructor = Constructor.builder()
        .parts(buildingConstructorPartList)
        .build();

    // This constructor requires all of "MeetingStart", "Location.Floor", and "Location.Room" attributes.
    // If an item has all of these attributes, it will match this constructor.
    // If this is the first matching constructor in the constructor list (constructor list described more below),
    //     the compound beacon will use this constructor, and the compound beacon will be written as `MS-X~F-Y~R-Z`.
    // In a constructor with multiple constructor parts, the order the constructor parts are added to
    //     the constructor part list defines how the compound beacon is written.
    // We can rearrange the beacon parts by changing the order the constructors were added to the list.
    List<ConstructorPart> meetingStartFloorRoomConstructorPartList = new ArrayList();
    meetingStartFloorRoomConstructorPartList.add(meetingStartConstructorPart);
    meetingStartFloorRoomConstructorPartList.add(floorConstructorPart);
    meetingStartFloorRoomConstructorPartList.add(roomConstructorPart);
    Constructor meetingStartFloorRoomConstructor = Constructor.builder()
        .parts(meetingStartFloorRoomConstructorPartList)
        .build();

    List<ConstructorPart> timeCardStartEmployeeEmailConstructorPartList = new ArrayList();
    timeCardStartEmployeeEmailConstructorPartList.add(timeCardStartConstructorPart);
    timeCardStartEmployeeEmailConstructorPartList.add(employeeEmailConstructorPart);
    Constructor timeCardStartEmployeeEmailConstructor = Constructor.builder()
        .parts(timeCardStartEmployeeEmailConstructorPartList)
        .build();

    List<ConstructorPart> timeCardStartConstructorPartList = new ArrayList();
    timeCardStartConstructorPartList.add(timeCardStartConstructorPart);
    Constructor timeCardStartConstructor = Constructor.builder()
        .parts(timeCardStartConstructorPartList)
        .build();

    List<ConstructorPart> creatorEmailConstructorPartList = new ArrayList();
    creatorEmailConstructorPartList.add(creatorEmailConstructorPart);
    Constructor creatorEmailConstructor = Constructor.builder()
        .parts(creatorEmailConstructorPartList)
        .build();

    List<ConstructorPart> projectStatusConstructorPartList = new ArrayList();
    projectStatusConstructorPartList.add(projectStatusConstructorPart);
    Constructor projectStatusConstructor = Constructor.builder()
        .parts(projectStatusConstructorPartList)
        .build();

    List<ConstructorPart> employeeEmailConstructorPartList = new ArrayList();
    employeeEmailConstructorPartList.add(employeeEmailConstructorPart);
    Constructor employeeEmailConstructor = Constructor.builder()
        .parts(employeeEmailConstructorPartList)
        .build();

    List<ConstructorPart> organizerEmailConstructorPartList = new ArrayList();
    organizerEmailConstructorPartList.add(organizerEmailConstructorPart);
    Constructor organizerEmailConstructor = Constructor.builder()
        .parts(organizerEmailConstructorPartList)
        .build();

    List<ConstructorPart> projectStartConstructorPartList = new ArrayList();
    projectStartConstructorPartList.add(projectStartConstructorPart);
    Constructor projectStartConstructor = Constructor.builder()
        .parts(projectStartConstructorPartList)
        .build();

    List<ConstructorPart> managerEmailConstructorPartList = new ArrayList();
    managerEmailConstructorPartList.add(managerEmailConstructorPart);
    Constructor managerEmailConstructor = Constructor.builder()
        .parts(managerEmailConstructorPartList)
        .build();

    List<ConstructorPart> assigneeEmailConstructorPartList = new ArrayList();
    assigneeEmailConstructorPartList.add(assigneeEmailConstructorPart);
    Constructor assigneeEmailConstructor = Constructor.builder()
        .parts(assigneeEmailConstructorPartList)
        .build();

    List<ConstructorPart> cityConstructorPartList = new ArrayList();
    cityConstructorPartList.add(cityConstructorPart);
    Constructor cityConstructor = Constructor.builder()
        .parts(cityConstructorPartList)
        .build();

    List<ConstructorPart> severityConstructorPartList = new ArrayList();
    severityConstructorPartList.add(severityConstructorPart);
    Constructor severityConstructor = Constructor.builder()
        .parts(severityConstructorPartList)
        .build();

    List<ConstructorPart> buildingFloorDeskConstructorPartList = new ArrayList();
    buildingFloorDeskConstructorPartList.add(buildingConstructorPart);
    buildingFloorDeskConstructorPartList.add(floorConstructorPart);
    buildingFloorDeskConstructorPartList.add(deskConstructorPart);
    Constructor buildingFloorDeskConstructor = Constructor.builder()
        .parts(buildingFloorDeskConstructorPartList)
        .build();

    // 5. Add constructors to the compound beacon constructor list in desired construction order.
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

    // 9. Define compound beacons
    //    Compound beacon construction is defined in more detail in CompoundBeaconSearchableEncryptionExample.
    //    Note that the split character must be a character that is not used in any attribute value.
    CompoundBeacon pk0CompoundBeacon = CompoundBeacon.builder()
        .name("PK")
        .split("~")
        .encrypted(pk0EncryptedPartList)
        .constructors(pk0ConstructorList)
        .build();
    CompoundBeacon sk0CompoundBeacon = CompoundBeacon.builder()
        .name("SK")
        .split("~")
        .encrypted(sk0EncryptedPartList)
        .signed(sk0SignedPartList)
        .constructors(sk0ConstructorList)
        .build();
    CompoundBeacon pk1CompoundBeacon = CompoundBeacon.builder()
        .name("PK1")
        .split("~")
        .encrypted(pk1EncryptedPartList)
        .constructors(pk1ConstructorList)
        .build();
    CompoundBeacon sk1CompoundBeacon = CompoundBeacon.builder()
        .name("SK1")
        .split("~")
        .encrypted(sk1EncryptedPartList)
        .signed(sk1SignedPartList)
        .constructors(sk1ConstructorList)
        .build();
    CompoundBeacon pk2CompoundBeacon = CompoundBeacon.builder()
        .name("PK2")
        .split("~")
        .encrypted(pk2EncryptedPartList)
        .constructors(pk2ConstructorList)
        .build();
    CompoundBeacon pk3CompoundBeacon = CompoundBeacon.builder()
        .name("PK3")
        .split("~")
        .encrypted(pk3EncryptedPartList)
        .constructors(pk3ConstructorList)
        .build();
    CompoundBeacon sk3CompoundBeacon = CompoundBeacon.builder()
        .name("SK3")
        .split("~")
        .encrypted(sk3EncryptedPartList)
        .signed(sk3SignedPartList)
        .constructors(sk3ConstructorList)
        .build();

    List<CompoundBeacon> compoundBeaconList = new ArrayList<>();
    compoundBeaconList.add(pk0CompoundBeacon);
    compoundBeaconList.add(sk0CompoundBeacon);
    compoundBeaconList.add(pk1CompoundBeacon);
    compoundBeaconList.add(sk1CompoundBeacon);
    compoundBeaconList.add(pk2CompoundBeacon);
    compoundBeaconList.add(pk3CompoundBeacon);
    compoundBeaconList.add(sk3CompoundBeacon);

    // 10. Create BeaconVersion.
    List<BeaconVersion> beaconVersions = new ArrayList<>();
    beaconVersions.add(
        BeaconVersion.builder()
            .standardBeacons(standardBeaconList)
            .compoundBeacons(compoundBeaconList)
            .version(1) // MUST be 1
            .keyStore(keyStore)
            .keySource(BeaconKeySource.builder()
                .single(SingleKeyStore.builder()
                    .keyId(branchKeyId)
                    .cacheTTL(6000)
                    .build())
                .build())
            .build()
    );

    // 11. Create a Hierarchical Keyring
    final MaterialProviders matProv = MaterialProviders.builder()
        .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
        .build();
    CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
        .branchKeyId(branchKeyId)
        .keyStore(keyStore)
        .ttlSeconds(6000l)
        .build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

    // 12. Define crypto actions
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    // Our partition key must be configured as SIGN_ONLY
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY);
    // Attributes used in beacons must be configured as ENCRYPT_AND_SIGN
    attributeActionsOnEncrypt.put("EmployeeID", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("TicketNumber", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("ProjectName", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("EmployeeName", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("EmployeeEmail", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("CreatorEmail", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("ProjectStatus", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("OrganizerEmail", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("ManagerEmail", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("AssigneeEmail", CryptoAction.ENCRYPT_AND_SIGN);
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

    // 13. Set up table config
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .logicalTableName(ddbTableName)
        .partitionKeyName("partition_key")
        .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
        .keyring(kmsKeyring)
        .search(SearchConfig.builder()
            .writeVersion(1) // MUST be 1
            .versions(beaconVersions)
            .build())
        .build();
    tableConfigs.put(ddbTableName, config);

    // 14. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build())
        .build();

    // 15. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    return ddb;
  }
}
