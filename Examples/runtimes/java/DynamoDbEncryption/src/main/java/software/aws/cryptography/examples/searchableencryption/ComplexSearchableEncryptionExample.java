package software.aws.cryptography.examples.searchableencryption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconKeySource;
import software.amazon.cryptography.dynamoDbEncryption.model.BeaconVersion;
import software.amazon.cryptography.dynamoDbEncryption.model.CompoundBeacon;
import software.amazon.cryptography.dynamoDbEncryption.model.Constructor;
import software.amazon.cryptography.dynamoDbEncryption.model.ConstructorPart;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
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

public class ComplexSearchableEncryptionExample {

  public static void QueryItemsWithCompoundBeacons(String ddbTableName, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {

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

    List<StandardBeacon> standardBeaconList = new ArrayList<>();
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
    StandardBeacon ticketModTimeStandardBeacon = StandardBeacon.builder()
        .name("TicketModTime")
        .length(4)
        .build();
    StandardBeacon meetingStartStandardBeacon = StandardBeacon.builder()
        .name("MeetingStart")
        .length(4)
        .build();
    StandardBeacon timeCardStartStandardBeacon = StandardBeacon.builder()
        .name("TimeCardStart")
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
    StandardBeacon projectStartStandardBeacon = StandardBeacon.builder()
        .name("ProjectStart")
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

    SensitivePart employeeSensitivePart = SensitivePart.builder()
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
    SensitivePart ticketModTimeSensitivePart = SensitivePart.builder()
        .name("TicketModTime")
        .prefix("M-")
        .build();
    SensitivePart meetingStartSensitivePart = SensitivePart.builder()
        .name("MeetingStart")
        .prefix("S-")
        .build();
    SensitivePart timeCardStartSensitivePart = SensitivePart.builder()
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
        .prefix("S-")
        .build();
    SensitivePart organizerEmailSensitivePart = SensitivePart.builder()
        .name("OrganizerEmail")
        .prefix("OE-")
        .build();
    SensitivePart projectStartSensitivePart = SensitivePart.builder()
        .name("ProjectStart")
        .prefix("S-")
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
    pk0SensitivePartList.add(employeeSensitivePart);
    pk0SensitivePartList.add(ticketNumberSensitivePart);
    pk0SensitivePartList.add(projectNameSensitivePart);
    pk0SensitivePartList.add(buildingSensitivePart);

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

    List<ConstructorPart> ticketNumberConstructorPartList = new ArrayList<>();
    ticketNumberConstructorPartList.add(ticketNumberConstructorPart);

    List<ConstructorPart> projectNameConstructorPartList = new ArrayList<>();
    projectNameConstructorPartList.add(projectNameConstructorPart);

    List<ConstructorPart> ticketModTimeConstructorPartList = new ArrayList();
    ticketModTimeConstructorPartList.add(ticketModTimeConstructorPart);

    List<ConstructorPart> meetingStartFloorRoomConstructorPartList = new ArrayList();
    meetingStartFloorRoomConstructorPartList.add(meetingStartConstructorPart);
    meetingStartFloorRoomConstructorPartList.add(floorConstructorPart);
    meetingStartFloorRoomConstructorPartList.add(roomConstructorPart);

    List<ConstructorPart> timeCardStartEmployeeEmailConstructorPartList = new ArrayList();
    timeCardStartEmployeeEmailConstructorPartList.add(timeCardStartConstructorPart);
    timeCardStartEmployeeEmailConstructorPartList.add(employeeEmailConstructorPart);

    List<ConstructorPart> creatorEmailConstructorPartList = new ArrayList();
    creatorEmailConstructorPartList.add(creatorEmailConstructorPart);

    List<ConstructorPart> projectStatusConstructorPartList = new ArrayList();
    projectStatusConstructorPartList.add(projectStatusConstructorPart);

    List<ConstructorPart> employeeEmailConstructorPartList = new ArrayList();
    employeeEmailConstructorPartList.add(employeeEmailConstructorPart);

    List<ConstructorPart> organizerEmailConstructorPartList = new ArrayList();
    organizerEmailConstructorPartList.add(organizerEmailConstructorPart);

    List<ConstructorPart> projectStartConstructorPartList = new ArrayList();
    projectStartConstructorPartList.add(projectStartConstructorPart);

    List<ConstructorPart> managerEmailConstructorPartList = new ArrayList();
    managerEmailConstructorPartList.add(managerEmailConstructorPart);

    List<ConstructorPart> assigneeEmailConstructorPartList = new ArrayList();
    assigneeEmailConstructorPartList.add(assigneeEmailConstructorPart);

    List<ConstructorPart> cityConstructorPartList = new ArrayList();
    cityConstructorPartList.add(cityConstructorPart);

    List<ConstructorPart> severityConstructorPartList = new ArrayList();
    severityConstructorPartList.add(severityConstructorPart);

    List<ConstructorPart> buildingFloorDeskConstructorPartList = new ArrayList();
    buildingFloorDeskConstructorPartList.add(buildingConstructorPart);
    buildingFloorDeskConstructorPartList.add(floorConstructorPart);
    buildingFloorDeskConstructorPartList.add(roomConstructorPart);



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

    List<CompoundBeacon> compoundBeaconList = new ArrayList<>();
    CompoundBeacon pk0CompoundBeacon = CompoundBeacon.builder()
        .name("PK0")
        .split(".")
        .sensitive(pk0SensitivePartList)
        .constructors(pk0ConstructorList)
        .build();
    compoundBeaconList.add(pk0CompoundBeacon);

    List<SensitivePart> sk0SensitivePartList = new ArrayList<>();
    sk0SensitivePartList.add(employeeSensitivePart);
    sk0SensitivePartList.add(projectNameSensitivePart);

    List<Constructor> sk0ConstructorList = new ArrayList<>();
    List<ConstructorPart> employeeConstructorPartList = new ArrayList<>();
    ConstructorPart employeeConstructorPart = ConstructorPart.builder()
        .name("EmployeeID")
        .required(true)
        .build();
    employeeConstructorPartList.add(employeeConstructorPart);
    sk0ConstructorList.add(Constructor.builder()
        .parts(employeeConstructorPartList)
        .build());
    List<ConstructorPart> ticketNumberConstructorPartList = new ArrayList<>();
    ConstructorPart ticketNumberConstructorPart = ConstructorPart.builder()
        .name("TicketNumber")
        .required(true)
        .build();
    ticketNumberConstructorPartList.add(ticketNumberConstructorPart);
    sk0ConstructorList.add(Constructor.builder()
        .parts(ticketNumberConstructorPartList)
        .build());
    List<ConstructorPart> projectNameConstructorPartList = new ArrayList<>();
    ConstructorPart projectNameConstructorPart = ConstructorPart.builder()
        .name("ProjectName")
        .required(true)
        .build();
    projectNameConstructorPartList.add(projectNameConstructorPart);
    sk0ConstructorList.add(Constructor.builder()
        .parts(projectNameConstructorPartList)
        .build());

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
    attributeActions.put("PK", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("SK", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("PK0", CryptoAction.ENCRYPT_AND_SIGN); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("EmployeeID", CryptoAction.ENCRYPT_AND_SIGN); // Our partition attribute must be SIGN_ONLY
    attributeActions.put("TicketNumber", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted
    attributeActions.put("ProjectName", CryptoAction.ENCRYPT_AND_SIGN); // Beaconized attributes must be encrypted

    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
        .partitionKeyName("PK")
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

    final HashMap<String, AttributeValue> itemOnlyZip = new HashMap<>();
    itemOnlyZip.put("PK", AttributeValue.builder().s("ABCD_1234").build());
    itemOnlyZip.put("SK", AttributeValue.builder().s("EABCD_1234").build());
    itemOnlyZip.put("EmployeeID", AttributeValue.builder().s("ABCD_1234").build());

    final PutItemRequest putRequestOnlyZip = PutItemRequest.builder()
        .tableName(ddbTableName)
        .item(itemOnlyZip)
        .build();

    final PutItemResponse putResponseOnlyZip = ddb.putItem(putRequestOnlyZip);
    // Validate item put successfully
    assert 200 == putResponseOnlyZip.sdkHttpResponse().statusCode();


  }

  public static void main(final String[] args) {
//    if (args.length != 3) {
//      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], branchKeyWrappingKmsKeyId as args[1], and branchKeyDdbTableName as args[2]");
//    }
    final String ddbTableName = "ComplexBeaconTestTable";
    final String branchKeyWrappingKmsKeyId = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";
    final String branchKeyDdbTableName = "KeyStoreTestTable";
    QueryItemsWithCompoundBeacons(ddbTableName, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);
  }


}
