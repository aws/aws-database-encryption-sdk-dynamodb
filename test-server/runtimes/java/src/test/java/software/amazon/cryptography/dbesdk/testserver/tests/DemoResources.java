// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

/**
 * Hard-coded AWS resources the Test_Suite uses to drive the Java_Server against <em>real</em>
 * DynamoDB and KMS (not DynamoDB Local).
 *
 * <p>These were provisioned out of band in the demo account ({@code 370957321024}, us-west-2) via
 * the AWS CLI:
 *
 * <pre>
 *   aws kms create-key --description "TestServer DB-ESDK demo key" --region us-west-2
 *   aws kms create-alias --alias-name alias/testserver-dbesdk-demo \
 *       --target-key-id &lt;key-id&gt; --region us-west-2
 *   aws dynamodb create-table --table-name TestServerRoundTripTable \
 *       --attribute-definitions AttributeName=partition_key,AttributeType=S \
 *       --key-schema AttributeName=partition_key,KeyType=HASH \
 *       --billing-mode PAY_PER_REQUEST --region us-west-2
 * </pre>
 *
 * <p>The values are intentionally hard-coded for an easy demo. Each test still allows an override
 * via system property / environment variable (see the individual test classes), so the same source
 * can target a different account's resources without editing this file. The KMS key ARN and account
 * id are not secrets (they are not credentials), but they are account-specific — swap them here if
 * you run the demo in a different account.
 */
final class DemoResources {

  private DemoResources() {}

  /** Region the demo resources live in. */
  static final String REGION = "us-west-2";

  /** The demo KMS key (alias {@code alias/testserver-dbesdk-demo}) used to build the keyring. */
  static final String KMS_KEY_ID =
      "arn:aws:kms:us-west-2:370957321024:key/b35f343f-10e3-4d30-8c63-185de7135b6c";

  /** The pre-created DynamoDB table the round-trip test writes to and reads from. */
  static final String ROUND_TRIP_TABLE_NAME = "TestServerRoundTripTable";

  /** Partition key attribute name of {@link #ROUND_TRIP_TABLE_NAME} (String-typed, HASH). */
  static final String ROUND_TRIP_PARTITION_KEY_NAME = "partition_key";

  /**
   * Asymmetric (ENCRYPT_DECRYPT, RSA_2048) KMS key used by the AWS KMS RSA keyring. The test
   * fetches its public key via {@code kms:GetPublicKey}.
   */
  static final String RSA_KMS_KEY_ID =
      "arn:aws:kms:us-west-2:370957321024:key/624eeb76-f04e-41e5-a66b-359ff89862a3";

  /**
   * KEY_AGREEMENT (ECC_NIST_P256) KMS key used by the AWS KMS ECDH keyring as both sender and
   * recipient so the shared secret round-trips. The test fetches its public key via {@code
   * kms:GetPublicKey}.
   */
  static final String ECDH_KMS_KEY_ID =
      "arn:aws:kms:us-west-2:370957321024:key/f5d6680f-4745-4135-b5fb-cdab8d3236bf";

  /** DynamoDB table backing the Hierarchical keyring's branch-key store. */
  static final String KEY_STORE_TABLE_NAME = "TestServerKeyStore";

  /** Logical key store name bound to {@link #KEY_STORE_TABLE_NAME}. */
  static final String LOGICAL_KEY_STORE_NAME = "TestServerKeyStore";
}
