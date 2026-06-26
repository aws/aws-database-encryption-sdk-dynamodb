// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.handlers;

import software.amazon.cryptography.dbesdk.testserver.model.GenericServerError;
import software.amazon.cryptography.dbesdk.testserver.server.ClientRegistry;
import software.amazon.cryptography.dbesdk.testserver.server.EnhancedClientHandle;

/**
 * The single, shared unknown-{@code ClientId} guard used by every operation handler that resolves a
 * request's {@code ClientId} to an Enhanced_Client (Reqs 4.4, 4.5).
 *
 * <p>Before task 4.3 the {@code writeItem} and {@code readItem} handlers each carried their own
 * minimal, self-contained {@code resolveClient} copy so they would be correct in isolation while
 * being developed in parallel. This class consolidates that duplicated logic into one place so the
 * guard is enforced identically across the write and read paths: the resolution rule, the error
 * shape, and the error message now live here and nowhere else.
 *
 * <h2>Behavior (Reqs 4.4, 4.5)</h2>
 *
 * <ul>
 *   <li><b>Known id (Req 4.4):</b> when the {@code ClientId} is present in the {@link
 *       ClientRegistry}, the corresponding {@link EnhancedClientHandle} is returned so the caller
 *       can perform the operation with that Enhanced_Client.
 *   <li><b>Absent / empty / unknown id (Req 4.5):</b> otherwise a {@link GenericServerError}
 *       indicating an unknown {@code ClientId} is thrown. {@link ClientRegistry#lookup} already
 *       maps a {@code null} or empty id to {@link java.util.Optional#empty()}, so this one check
 *       covers all three cases (absent, empty, and unknown).
 * </ul>
 *
 * <p><strong>No operation, registry unchanged (Req 4.5):</strong> callers invoke this guard
 * <em>before</em> touching the Enhanced_Client or the DynamoDB_Backend, so when it throws no
 * operation has been performed. Resolution is a pure read of the registry — {@link
 * ClientRegistry#lookup} never mutates it — so an unknown id leaves the registry unchanged.
 *
 * <p>This class is stateless and its method is pure; it is therefore thread-safe.
 */
public final class ClientResolution {

  private ClientResolution() {}

  /**
   * Resolves a {@code ClientId} to its Enhanced_Client, or throws the unknown-{@code ClientId}
   * {@link GenericServerError} when the id is absent, empty, or not registered (Reqs 4.4, 4.5).
   *
   * <p>This performs no side effects beyond reading the registry, so when it throws the caller has
   * performed no operation and the registry is unchanged.
   *
   * @param registry the process-wide Client_Registry to resolve against; must not be {@code null}
   * @param clientId the request's {@code ClientId}; may be {@code null} or empty (both treated as
   *     unknown)
   * @return the {@link EnhancedClientHandle} bound to {@code clientId}
   * @throws GenericServerError if {@code clientId} is absent, empty, or not present in {@code
   *     registry}
   */
  public static EnhancedClientHandle resolveOrThrow(
      final ClientRegistry registry, final String clientId) {
    return registry
        .lookup(clientId)
        .orElseThrow(
            () ->
                GenericServerError.builder()
                    .message(
                        "Unknown ClientId '"
                            + (clientId == null ? "" : clientId)
                            + "': no Enhanced Client is registered for the supplied ClientId. "
                            + "Call CreateClient first and reuse the returned ClientId.")
                    .build());
  }
}
