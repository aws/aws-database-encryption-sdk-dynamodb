package software.aws.cryptography.examples.searchableencryption.complexexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconKeySource;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion;
import software.amazon.cryptography.dynamoDbEncryption.model.CompoundBeacon;
import software.amazon.cryptography.dynamoDbEncryption.model.Constructor;
import software.amazon.cryptography.dynamoDbEncryption.model.ConstructorPart;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.NonSensitivePart;
import software.amazon.cryptography.dynamoDbEncryption.model.SearchConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.SensitivePart;
import software.amazon.cryptography.dynamoDbEncryption.model.SingleKeyStore;
import software.amazon.cryptography.dynamoDbEncryption.model.StandardBeacon;
import software.amazon.cryptography.keyStore.KeyStore;
import software.amazon.cryptography.keyStore.model.CreateKeyInput;
import software.amazon.cryptography.keyStore.model.CreateKeyOutput;
import software.amazon.cryptography.keyStore.model.KeyStoreConfig;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

public class BeaconConfig {

  public static DynamoDbClient SetupBeaconConfig(String ddbTableName, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

    // 2. Create Keystore and branch key.
    //    These are the same constructions as in the Basic example, which describes these in more detail.
    KeyStore keyStore = KeyStore.builder()
        .KeyStoreConfig(KeyStoreConfig.builder()
            .kmsClient(KmsClient.create())
            .ddbClient(DynamoDbClient.create())
            .ddbTableName(branchKeyDdbTableName)
            .build())
        .build();
    CreateKeyOutput output = keyStore.CreateKey(CreateKeyInput.builder()
        .awsKmsKeyArn(branchKeyWrappingKmsKeyArn)
        .build());
    String branchKeyId = output.branchKeyIdentifier();
    System.out.println(branchKeyId);

    // PK beacons
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
//    StandardBeacon ticketModTimeStandardBeacon = StandardBeacon.builder()
//        .name("TicketModTime")
//        .length(4)
//        .build();
//    StandardBeacon meetingStartStandardBeacon = StandardBeacon.builder()
//        .name("MeetingStart")
//        .length(4)
//        .build();
//    StandardBeacon timeCardStartStandardBeacon = StandardBeacon.builder()
//        .name("TimeCardStart")
//        .length(4)
//        .build();
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
//    StandardBeacon projectStartStandardBeacon = StandardBeacon.builder()
//        .name("ProjectStart")
//        .length(4)
//        .build();
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
//    standardBeaconList.add(ticketModTimeStandardBeacon);
//    standardBeaconList.add(meetingStartStandardBeacon);
//    standardBeaconList.add(timeCardStartStandardBeacon);
    standardBeaconList.add(employeeEmailStandardBeacon);
    standardBeaconList.add(creatorEmailStandardBeacon);
    standardBeaconList.add(projectStatusStandardBeacon);
    standardBeaconList.add(organizerEmailStandardBeacon);
//    standardBeaconList.add(projectStartStandardBeacon);
    standardBeaconList.add(managerEmailStandardBeacon);
    standardBeaconList.add(assigneeEmailStandardBeacon);
    standardBeaconList.add(cityStandardBeacon);
    standardBeaconList.add(severityStandardBeacon);
    standardBeaconList.add(buildingStandardBeacon);
    standardBeaconList.add(floorStandardBeacon);
    standardBeaconList.add(roomStandardBeacon);
    standardBeaconList.add(deskStandardBeacon);

    SensitivePart employeeIDSensitivePart = SensitivePart.builder()
        .name("EmployeeID")
        .prefix("E-")
        .build();
    SensitivePart ticketNumberSensitivePart = SensitivePart.builder()
        .name("TicketNumber")
        .prefix("T-")
        .build();
    SensitivePart projectNameSensitivePart = SensitivePart.builder()
        .name("ProjectName")
        .prefix("P-")
        .build();
    NonSensitivePart ticketModTimeNonSensitivePart = NonSensitivePart.builder()
        .name("TicketModTime")
        .prefix("M-")
        .build();
    NonSensitivePart meetingStartNonSensitivePart = NonSensitivePart.builder()
        .name("MeetingStart")
        .prefix("MS-")
        .build();
    NonSensitivePart timeCardStartNonSensitivePart = NonSensitivePart.builder()
        .name("TimeCardStart")
        .prefix("T-")
        .build();
    SensitivePart employeeEmailSensitivePart = SensitivePart.builder()
        .name("EmployeeEmail")
        .prefix("EE-")
        .build();
    SensitivePart creatorEmailSensitivePart = SensitivePart.builder()
        .name("CreatorEmail")
        .prefix("CE-")
        .build();
    SensitivePart projectStatusSensitivePart = SensitivePart.builder()
        .name("ProjectStatus")
        .prefix("PSts-")
        .build();
    SensitivePart organizerEmailSensitivePart = SensitivePart.builder()
        .name("OrganizerEmail")
        .prefix("OE-")
        .build();
    NonSensitivePart projectStartNonSensitivePart = NonSensitivePart.builder()
        .name("ProjectStart")
        .prefix("PS-")
        .build();
    SensitivePart managerEmailSensitivePart = SensitivePart.builder()
        .name("ManagerEmail")
        .prefix("ME-")
        .build();
    SensitivePart assigneeEmailSensitivePart = SensitivePart.builder()
        .name("AssigneeEmail")
        .prefix("AE-")
        .build();
    SensitivePart citySensitivePart = SensitivePart.builder()
        .name("City")
        .prefix("C-")
        .build();
    SensitivePart severitySensitivePart = SensitivePart.builder()
        .name("Severity")
        .prefix("S-")
        .build();
    SensitivePart buildingSensitivePart = SensitivePart.builder()
        .name("Building")
        .prefix("B-")
        .build();
    SensitivePart floorSensitivePart = SensitivePart.builder()
        .name("Floor")
        .prefix("F-")
        .build();
    SensitivePart roomSensitivePart = SensitivePart.builder()
        .name("Room")
        .prefix("R-")
        .build();
    SensitivePart deskSensitivePart = SensitivePart.builder()
        .name("Desk")
        .prefix("D-")
        .build();

    List<SensitivePart> pk0SensitivePartList = new ArrayList<>();
    pk0SensitivePartList.add(employeeIDSensitivePart);
    pk0SensitivePartList.add(ticketNumberSensitivePart);
    pk0SensitivePartList.add(projectNameSensitivePart);
    pk0SensitivePartList.add(buildingSensitivePart);

    List<SensitivePart> sk0SensitivePartList = new ArrayList<>();
    sk0SensitivePartList.add(employeeIDSensitivePart);

    sk0SensitivePartList.add(floorSensitivePart);
    sk0SensitivePartList.add(roomSensitivePart);
    sk0SensitivePartList.add(projectNameSensitivePart);
    sk0SensitivePartList.add(employeeEmailSensitivePart);
    List<NonSensitivePart> sk0NonSensitivePartList = new ArrayList<>();
    sk0NonSensitivePartList.add(timeCardStartNonSensitivePart);
    sk0NonSensitivePartList.add(ticketModTimeNonSensitivePart);
    sk0NonSensitivePartList.add(meetingStartNonSensitivePart);


    List<SensitivePart> pk1SensitivePartList = new ArrayList<>();
    pk1SensitivePartList.add(employeeEmailSensitivePart);
    pk1SensitivePartList.add(creatorEmailSensitivePart);
    pk1SensitivePartList.add(projectStatusSensitivePart);
    pk1SensitivePartList.add(organizerEmailSensitivePart);

    List<SensitivePart> sk1SensitivePartList = new ArrayList<>();
    sk1SensitivePartList.add(employeeIDSensitivePart);
    sk1SensitivePartList.add(floorSensitivePart);
    sk1SensitivePartList.add(roomSensitivePart);
    List<NonSensitivePart> sk1NonSensitivePartList = new ArrayList<>();
    sk1NonSensitivePartList.add(ticketModTimeNonSensitivePart);
    sk1NonSensitivePartList.add(meetingStartNonSensitivePart);
    sk1NonSensitivePartList.add(projectStartNonSensitivePart);

    List<SensitivePart> pk2SensitivePartList = new ArrayList<>();
    pk2SensitivePartList.add(managerEmailSensitivePart);
    pk2SensitivePartList.add(assigneeEmailSensitivePart);

    List<SensitivePart> pk3SensitivePartList = new ArrayList<>();
    pk3SensitivePartList.add(citySensitivePart);
    pk3SensitivePartList.add(severitySensitivePart);

    List<SensitivePart> sk3SensitivePartList = new ArrayList<>();
    sk3SensitivePartList.add(buildingSensitivePart);
    sk3SensitivePartList.add(floorSensitivePart);
    sk3SensitivePartList.add(deskSensitivePart);
    List<NonSensitivePart> sk3NonSensitivePartList = new ArrayList<>();
    sk3NonSensitivePartList.add(ticketModTimeNonSensitivePart);

    ConstructorPart employeeIdConstructorPart = ConstructorPart.builder()
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
    Constructor buildingFloorDeskConstructor = Constructor.builder()
        .parts(buildingFloorDeskConstructorPartList)
        .build();

    List<Constructor> pk0ConstructorList = new ArrayList<>();
    pk0ConstructorList.add(employeeIdConstructor);
    pk0ConstructorList.add(ticketNumberConstructor);
    pk0ConstructorList.add(projectNameConstructor);

    List<Constructor> sk0ConstructorList = new ArrayList<>();
    sk0ConstructorList.add(ticketModTimeConstructor);
    sk0ConstructorList.add(meetingStartFloorRoomConstructor);
    sk0ConstructorList.add(projectNameConstructor);
    sk0ConstructorList.add(timeCardStartEmployeeEmailConstructor);
    sk0ConstructorList.add(employeeIdConstructor);

    List<Constructor> pk1ConstructorList = new ArrayList<>();
    pk1ConstructorList.add(creatorEmailConstructor);
    pk1ConstructorList.add(employeeEmailConstructor);
    pk1ConstructorList.add(projectStatusConstructor);
    pk1ConstructorList.add(organizerEmailConstructor);

    List<Constructor> sk1ConstructorList = new ArrayList<>();
    sk1ConstructorList.add(meetingStartFloorRoomConstructor);
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

    CompoundBeacon pk0CompoundBeacon = CompoundBeacon.builder()
        .name("PK")
        .split("~")
        .sensitive(pk0SensitivePartList)
        .constructors(pk0ConstructorList)
        .build();
    CompoundBeacon sk0CompoundBeacon = CompoundBeacon.builder()
        .name("SK")
        .split("~")
        .sensitive(sk0SensitivePartList)
        .nonSensitive(sk0NonSensitivePartList)
        .constructors(sk0ConstructorList)
        .build();
    CompoundBeacon pk1CompoundBeacon = CompoundBeacon.builder()
        .name("PK1")
        .split("~")
        .sensitive(pk1SensitivePartList)
        .constructors(pk1ConstructorList)
        .build();
    CompoundBeacon sk1CompoundBeacon = CompoundBeacon.builder()
        .name("SK1")
        .split("~")
        .sensitive(sk1SensitivePartList)
        .nonSensitive(sk1NonSensitivePartList)
        .constructors(sk1ConstructorList)
        .build();
    CompoundBeacon pk2CompoundBeacon = CompoundBeacon.builder()
        .name("PK2")
        .split("~")
        .sensitive(pk2SensitivePartList)
        .constructors(pk2ConstructorList)
        .build();
    CompoundBeacon pk3CompoundBeacon = CompoundBeacon.builder()
        .name("PK3")
        .split("~")
        .sensitive(pk3SensitivePartList)
        .constructors(pk3ConstructorList)
        .build();
    CompoundBeacon sk3CompoundBeacon = CompoundBeacon.builder()
        .name("SK3")
        .split("~")
        .sensitive(sk3SensitivePartList)
        .nonSensitive(sk3NonSensitivePartList)
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


//    pk0ConstructorList.add(Constructor.builder()
//        .parts(employeeIdConstructorPartList)
//        .build());
//    List<ConstructorPart> ticketNumberConstructorPartList = new ArrayList<>();
//    ConstructorPart ticketNumberConstructorPart = ConstructorPart.builder()
//        .name("TicketNumber")
//        .required(true)
//        .build();
//    ticketNumberConstructorPartList.add(ticketNumberConstructorPart);
//    pk0ConstructorList.add(Constructor.builder()
//        .parts(ticketNumberConstructorPartList)
//        .build());
//    List<ConstructorPart> projectNameConstructorPartList = new ArrayList<>();
//    ConstructorPart projectNameConstructorPart = ConstructorPart.builder()
//        .name("ProjectName")
//        .required(true)
//        .build();
//    projectNameConstructorPartList.add(projectNameConstructorPart);
//    pk0ConstructorList.add(Constructor.builder()
//        .parts(projectNameConstructorPartList)
//        .build());
//    List<ConstructorPart> buildingConstructorPartList = new ArrayList<>();
//    ConstructorPart buildingConstructorPart = ConstructorPart.builder()
//        .name("Building")
//        .required(true)
//        .build();
//    projectNameConstructorPartList.add(projectNameConstructorPart);
//    pk0ConstructorList.add(Constructor.builder()
//        .parts(projectNameConstructorPartList)
//        .build());

//    List<CompoundBeacon> compoundBeaconList = new ArrayList<>();
//    CompoundBeacon pk0CompoundBeacon = CompoundBeacon.builder()
//        .name("PK0")
//        .split(".")
//        .sensitive(pk0SensitivePartList)
//        .constructors(pk0ConstructorList)
//        .build();
//    compoundBeaconList.add(pk0CompoundBeacon);
//
//    List<SensitivePart> sk0SensitivePartList = new ArrayList<>();
//    sk0SensitivePartList.add(employeeIDSensitivePart);
//    sk0SensitivePartList.add(projectNameSensitivePart);
//
//    List<Constructor> sk0ConstructorList = new ArrayList<>();
//    List<ConstructorPart> employeeConstructorPartList = new ArrayList<>();
//    ConstructorPart employeeConstructorPart = ConstructorPart.builder()
//        .name("EmployeeID")
//        .required(true)
//        .build();
//    employeeConstructorPartList.add(employeeConstructorPart);
//    sk0ConstructorList.add(Constructor.builder()
//        .parts(employeeConstructorPartList)
//        .build());
//    List<ConstructorPart> ticketNumberConstructorPartList = new ArrayList<>();
//    ConstructorPart ticketNumberConstructorPart = ConstructorPart.builder()
//        .name("TicketNumber")
//        .required(true)
//        .build();
//    ticketNumberConstructorPartList.add(ticketNumberConstructorPart);
//    sk0ConstructorList.add(Constructor.builder()
//        .parts(ticketNumberConstructorPartList)
//        .build());
//    List<ConstructorPart> projectNameConstructorPartList = new ArrayList<>();
//    ConstructorPart projectNameConstructorPart = ConstructorPart.builder()
//        .name("ProjectName")
//        .required(true)
//        .build();
//    projectNameConstructorPartList.add(projectNameConstructorPart);
//    sk0ConstructorList.add(Constructor.builder()
//        .parts(projectNameConstructorPartList)
//        .build());

    // 5. Create BeaconVersion.
    //    This is similar to the Basic example, except we have also provided a compoundBeaconList.
    //    We must also continue to provide all of the standard beacons that compose a compound beacon list.
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

    // 6. Create a Hierarchical Keyring
    //    This is the same configuration as in the Basic example.
    final MaterialProviders matProv = MaterialProviders.builder()
        .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
        .build();
    CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
        .kmsKeyId(branchKeyWrappingKmsKeyArn)
        .branchKeyId(branchKeyId)
        .keyStore(keyStore)
        .ttlSeconds(6000l)
        .maxCacheSize(100)
        .build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

    final Map<String, CryptoAction> attributeActions = new HashMap<>();
    attributeActions.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("PK", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("SK", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("PK0", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("SK0", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("PK1", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("SK1", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("PK2", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("PK3", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("SK3", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("EmployeeID", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("TicketNumber", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("ProjectName", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("TicketModTime", CryptoAction.SIGN_ONLY); // TODO clean up comments for SIGN_ONLY NS parts Beaconized attributes must be encrypted
    attributeActions.put("MeetingStart", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("TimeCardStart", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("EmployeeName", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("EmployeeTitle", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("EmployeeEmail", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("Description", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("ProjectTarget", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("Hours", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("Role", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("Message", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("CreatorEmail", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("ProjectStatus", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("OrganizerEmail", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("ProjectStart", CryptoAction.SIGN_ONLY); // Beaconized attributes must be encrypted
    attributeActions.put("ManagerEmail", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("AssigneeEmail", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("City", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("Severity", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("Location", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("Attendees", CryptoAction.ENCRYPT_AND_SIGN); // These are not in beacons, but are sensitive
    //     and should be encrypted
    attributeActions.put("Duration", CryptoAction.SIGN_ONLY);
    attributeActions.put("Subject", CryptoAction.ENCRYPT_AND_SIGN);

    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .partitionKeyName("partition_key")
        .attributeActions(attributeActions)
        .keyring(kmsKeyring)
        .search(SearchConfig.builder()
            .writeVersion(1) // MUST be 1
            .versions(beaconVersions)
            .build())
        .build();
    tableConfigs.put(ddbTableName, config);

    // 9. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
        .config(DynamoDbTablesEncryptionConfig.builder()
            .tableEncryptionConfigs(tableConfigs)
            .build())
        .build();

    // 10. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient.builder()
        .overrideConfiguration(
            ClientOverrideConfiguration.builder()
                .addExecutionInterceptor(encryptionInterceptor)
                .build())
        .build();

    return ddb;

//    loadTable(ddbTableName, ddb);
//
//    queryTable(ddbTableName, ddb);

//    final HashMap<String, AttributeValue> meeting1 = new HashMap<>();
//    final HashMap<String, AttributeValue> meeting1Location = new HashMap<>();
//    meeting1Location.put("Floor", AttributeValue.builder().s("12").build());
//    meeting1Location.put("Room", AttributeValue.builder().s("403").build());
//    meeting1.put("partition_key", AttributeValue.builder().s("HMAC(meeting1)").build());
//    meeting1.put("EmployeeID", AttributeValue.builder().s("emp_001").build());
//    meeting1.put("EmployeeEmail", AttributeValue.builder().s("able@gmail.com").build());
//    meeting1.put("MeetingStart", AttributeValue.builder().s("2022-07-04T13:00").build());
//    meeting1.put("Location", AttributeValue.builder().m(meeting1Location).build());
//    meeting1.put("Duration", AttributeValue.builder().s("30").build());
//    meeting1.put("Attendees", AttributeValue.builder().s("SomeList").build());
//    meeting1.put("Subject", AttributeValue.builder().s("Scan Beacons").build());
//
//    final PutItemRequest putRequestOnlyZip = PutItemRequest.builder()
//        .tableName(ddbTableName)
//        .item(meeting1)
//        .build();
//
//    final PutItemResponse putResponseOnlyZip = ddb.putItem(putRequestOnlyZip);
//    // Validate item put successfully
//    assert 200 == putResponseOnlyZip.sdkHttpResponse().statusCode();

//    // 12. Query for the item we just put.
//    Map<String,String> expressionAttributesNames = new HashMap<>();
//    expressionAttributesNames.put("#p", "PK1");
//    expressionAttributesNames.put("#sk1", "SK1");
//    expressionAttributesNames.put("#dur", "Duration");
//
//    // To query against a compound beacon, you must write the prefix, then the unencrypted value.
//    // The expression below queries against zipcodes of 98109.
//    // This is similar to the behavior in the Basic example, which also queries as if the beacon was plaintext,
//    //     except we must add the prefix.
//    Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
//    expressionAttributeValues.put(":e", AttributeValue.builder().s("EE-able@gmail.com").build());
//    expressionAttributeValues.put(":date1", AttributeValue.builder().s("MS-2022-07-02").build());
//    expressionAttributeValues.put(":date2", AttributeValue.builder().s("MS-2022-07-08").build());
//    expressionAttributeValues.put(":dur", AttributeValue.builder().s("0").build());
//
//    QueryRequest queryRequest = QueryRequest.builder()
//        .tableName(ddbTableName)
//        .indexName("GSI-1")
//        .keyConditionExpression("#p = :e AND #sk1 BETWEEN :date1 AND :date2")
//        .filterExpression("#dur > :dur")
//        .expressionAttributeNames(expressionAttributesNames)
//        .expressionAttributeValues(expressionAttributeValues)
//        .build();
//
//    System.out.println(queryRequest);
//
//    QueryResponse queryResponse = ddb.query(queryRequest);
//    List<Map<String, AttributeValue>> attributeValues = queryResponse.items();
//    // Validate query was returned successfully
//    assert 200 == queryResponse.sdkHttpResponse().statusCode();
//    // Validate only 1 item was returned: the item we just put
//    assert attributeValues.size() == 1;
//    Map<String, AttributeValue> returnedItem = attributeValues.get(0);
//    // Validate the item has the expected attributes
//    System.out.println(returnedItem);
//    assert returnedItem.get("EmployeeEmail").n().equals("able@gmail.com");
  }


}
