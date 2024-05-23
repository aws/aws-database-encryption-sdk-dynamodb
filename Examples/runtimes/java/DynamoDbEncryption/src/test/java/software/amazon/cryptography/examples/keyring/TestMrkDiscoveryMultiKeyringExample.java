package software.amazon.cryptography.examples.keyring;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestMrkDiscoveryMultiKeyringExample {

  @Test
  public void TestMrkDiscoveryMultiKeyringExample() {
    List<String> accounts = Collections.singletonList(
      TestUtils.TEST_AWS_ACCOUNT_ID
    );
    List<String> regions = Collections.singletonList(TestUtils.TEST_AWS_REGION);

    MrkDiscoveryMultiKeyringExample.MultiMrkDiscoveryKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      TestUtils.TEST_MRK_KEY_ID,
      accounts,
      regions
    );
  }
}
