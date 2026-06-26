// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server;

import java.util.Map;
import java.util.Optional;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Handle to a constructed, configured DB-ESDK DynamoDB Enhanced Client instance held by the {@link
 * ClientRegistry}.
 *
 * <p>The {@code Client_Registry} (task 2.1) only needs to store and hand back a reference to "some
 * constructed Enhanced Client"; it never inspects the handle's internals. The concrete Enhanced
 * Client adapter is authored separately (task 2.2,
 * {@code software.amazon.cryptography.dbesdk.testserver.server.adapter.EnhancedClientAdapter}) and
 * supplies an implementation of this interface, which the {@code createClient} handler (task 2.3)
 * then registers. Decoupling the registry from the adapter this way lets the two be developed in
 * parallel without the registry taking a hard compile-time dependency on the adapter's concrete
 * type.
 *
 * <p>The encrypted write/read operations (tasks 4.1, 4.2) are declared here so the operation
 * handlers can act on whatever handle the registry resolves without down-casting to the concrete
 * adapter. Items and keys are exchanged as generic attribute maps keyed by attribute name with AWS
 * SDK v2 {@link AttributeValue} values; the handlers translate between the modeled {@code
 * AttributeValue} union and the SDK type. (Integration note: this operation surface was added by
 * task 2.2 on top of task 2.1's original marker interface; the two are reconciled here.)
 *
 * <p>Implementations are expected to be effectively immutable once constructed and safe to share
 * across threads, since a single handle resolves to the same Enhanced Client for the life of the
 * server process (Requirement 4.3).
 */
public interface EnhancedClientHandle {

  /**
   * Encrypts and writes an item to the backing DynamoDB table using the Enhanced Client (Req 5.1).
   *
   * @param tableName the physical DynamoDB table to write to; must be configured on this client
   * @param item the plaintext item to encrypt and write, keyed by attribute name
   * @throws IllegalArgumentException if {@code tableName} was not configured on this client
   */
  void putItem(String tableName, Map<String, AttributeValue> item);

  /**
   * Reads and decrypts an item from the backing DynamoDB table using the Enhanced Client (Req 5.2).
   *
   * @param tableName the physical DynamoDB table to read from; must be configured on this client
   * @param key the primary key of the item to read, keyed by attribute name
   * @return the decrypted item, or {@link Optional#empty()} if no item matched the key (Req 5.4)
   * @throws IllegalArgumentException if {@code tableName} was not configured on this client
   */
  Optional<Map<String, AttributeValue>> getItem(String tableName, Map<String, AttributeValue> key);
}
