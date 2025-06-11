package software.amazon.cryptography.examples.migration.plaintext;

import static org.testng.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep3;
import software.amazon.cryptography.examples.migration.TestUtils;
import software.amazon.cryptography.examples.plaintext.MigrationExampleStep0;

public class TestMigrationExampleStep0 {

  @Test
  public void TestMigrationStep0() {
    // Successfully executes step 0
    MigrationExampleStep0.MigrationStep0(
      TestUtils.TEST_DDB_TABLE_NAME,
      0,
      TestUtils.PARTITION_KEY
    );

    // Given: Step 1 has succeeded
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      1,
      TestUtils.PARTITION_KEY
    );
    // When: Execute Step 0 with sortReadValue=1, Then: Success (i.e. can read plaintext values)
    MigrationExampleStep0.MigrationStep0(
      TestUtils.TEST_DDB_TABLE_NAME,
      1,
      TestUtils.PARTITION_KEY
    );

    // Given: Step 2 has succeeded
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      2,
      TestUtils.PARTITION_KEY
    );
    // When: Execute Step 0 with sortReadValue=2, Then: throws AssertionError (i.e. cannot read encrypted values)
    assertThrows(
      AssertionError.class,
      () -> {
        MigrationExampleStep0.MigrationStep0(
          TestUtils.TEST_DDB_TABLE_NAME,
          2,
          TestUtils.PARTITION_KEY
        );
      }
    );

    // Given: Step 3 has succeeded
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      3,
      TestUtils.PARTITION_KEY
    );
    // When: Execute Step 0 with sortReadValue=3, Then: throws AssertionError (i.e. cannot read encrypted values)
    assertThrows(
      AssertionError.class,
      () -> {
        MigrationExampleStep0.MigrationStep0(
          TestUtils.TEST_DDB_TABLE_NAME,
          3,
          TestUtils.PARTITION_KEY
        );
      }
    );
    List<String> sortkeys = Arrays.asList("0", "1", "2", "3");
    for (String sortkey : sortkeys) {
      TestUtils.cleanUpDDBItem(
        TestUtils.TEST_DDB_TABLE_NAME,
        "partition_key",
        "sort_key",
        TestUtils.PARTITION_KEY,
        sortkey
      );
    }
  }
}
