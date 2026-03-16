// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package com.amazonaws.services.dynamodbv2.datamodeling.sdkv2;

import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.DirectKmsMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.EncryptionMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.ScenarioManifest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.testng.annotations.Test;

public class CipherTextGenerator extends HolisticIT {

  @Test(enabled = false)
  public void generateKmsAes128Vector() throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();
    createCiphertextTables(client);

    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<ScenarioManifest>() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    Map<String, String> desc = Collections.singletonMap("amzn-ddb-env-alg", "AES/128");
    EncryptionMaterialsProvider provider = new DirectKmsMaterialsProvider(
      kmsClient, keyDataMap.get("awsKmsUsWest2").keyId, desc);

    generateStandardData(provider);
    writeTablesAsTestVector("aws-kms-aes128-1.json", "TableName", "HashKeyOnly");

    client.close();
    localDynamoDb.stop();
  }
}
