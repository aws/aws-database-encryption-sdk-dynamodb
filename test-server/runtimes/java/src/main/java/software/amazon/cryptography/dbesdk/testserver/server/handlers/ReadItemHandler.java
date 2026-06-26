// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.handlers;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import software.amazon.cryptography.dbesdk.testserver.model.AttributeValue;
import software.amazon.cryptography.dbesdk.testserver.model.DBESDKClientError;
import software.amazon.cryptography.dbesdk.testserver.model.GenericServerError;
import software.amazon.cryptography.dbesdk.testserver.model.ReadItemInput;
import software.amazon.cryptography.dbesdk.testserver.model.ReadItemOutput;
import software.amazon.cryptography.dbesdk.testserver.server.ClientRegistry;
import software.amazon.cryptography.dbesdk.testserver.server.EnhancedClientHandle;
import software.amazon.cryptography.dbesdk.testserver.service.ReadItemOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Handler for the {@code ReadItem} operation (Reqs 5.2, 5.4, 5.5).
 *
 * <p>This is the {@code readItem} operation handler of the design's Java_Server component. It
 * implements the smithy-java generated {@link ReadItemOperation} functional interface so the
 * transport entry point ({@code TestServerMain}) can register it directly. The constructor
 * signature {@code ReadItemHandler(ClientRegistry)} is kept exactly as task 2.4 wired it.
 *
 * <h2>Behavior</h2>
 *
 * <ol>
 *   <li><b>Resolve the client:</b> look the request's {@code ClientId} up in the {@link
 *       ClientRegistry} via the shared {@link ClientResolution#resolveOrThrow} guard. An
 *       absent/empty/unknown id is surfaced as {@link GenericServerError} (Reqs 4.4, 4.5). See
 *       "unknown-ClientId guard" below.
 *   <li><b>Read + decrypt (Req 5.2):</b> translate the modeled {@code Key} into an AWS SDK v2
 *       attribute map, call {@link EnhancedClientHandle#getItem}, and — when an item is present —
 *       translate the decrypted SDK item back into the modeled {@code Item} and return {@code
 *       found=true} with that item.
 *   <li><b>No item (Req 5.4):</b> when {@code getItem} returns {@link Optional#empty()} the key
 *       matched no item; this is <em>not</em> an error. Return {@code ReadItemOutput{found=false}}
 *       with no decrypted item.
 *   <li><b>Failure classification (Req 5.5):</b> a decrypt exception thrown by the Enhanced_Client
 *       (DB-ESDK) is forwarded as {@link DBESDKClientError}; a DynamoDB backend
 *       connectivity/timeout failure is surfaced as {@link GenericServerError}. There is no
 *       fallback behavior and the registry is never mutated. See {@link #classifyOperationFailure}.
 * </ol>
 *
 * <h2>model&lt;-&gt;SDK AttributeValue conversion</h2>
 *
 * <p>The Enhanced_Client exchanges items/keys as AWS SDK v2 {@code AttributeValue} maps, while the
 * wire contract uses the generated {@link AttributeValue} union. Both directions are needed here:
 * model-&gt;SDK for the request {@code Key} and SDK-&gt;model for the decrypted read result. Both are
 * delegated to the shared {@link AttributeValueConversions} helper (task 4.1), which covers every
 * variant (S, N, B, BOOL, NULL, M, L, SS, NS, BS) in both directions, so this handler no longer
 * carries its own private converters (consolidated in task 4.3).
 *
 * <h2>Unknown-ClientId guard (Reqs 4.4, 4.5)</h2>
 *
 * <p>Resolution is delegated to the shared {@link ClientResolution#resolveOrThrow} guard, which the
 * {@code writeItem} handler uses too so the rule is enforced identically across operations. {@link
 * ClientRegistry#lookup} already treats a {@code null} or empty id as "not present", so the single
 * shared check covers the absent, empty, and unknown cases (Req 4.5). The guard runs as the first
 * step of {@link #readItem}, before any read/decrypt, so no operation is performed and the registry
 * is left unchanged when the id does not resolve.
 */
public final class ReadItemHandler implements ReadItemOperation {

  private final ClientRegistry registry;

  /**
   * @param registry the process-wide Client_Registry used to resolve the request's {@code ClientId}
   */
  public ReadItemHandler(final ClientRegistry registry) {
    this.registry = Objects.requireNonNull(registry, "registry must not be null");
  }

  @Override
  public ReadItemOutput readItem(final ReadItemInput input, final RequestContext context) {
    // 1. Resolve the ClientId via the shared unknown-id guard (Reqs 4.4, 4.5). Thrown BEFORE any
    //    read/decrypt so an absent/empty/unknown id performs no operation and leaves the registry
    //    unchanged.
    final EnhancedClientHandle handle =
        ClientResolution.resolveOrThrow(registry, input.getClientId());

    // 2. Translate the modeled Key into an SDK v2 attribute map for the Enhanced_Client.
    final Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> sdkKey =
        AttributeValueConversions.toSdkItem(input.getKey());

    // 3. Read + decrypt via the Enhanced_Client. Classify any thrown exception (Req 5.5).
    final Optional<Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue>>
        result;
    try {
      result = handle.getItem(input.getTableName(), sdkKey);
    } catch (final RuntimeException failure) {
      // No fallback; the registry is never mutated here (Req 5.5).
      throw classifyOperationFailure(failure);
    }

    // 4. No item matched the key: not an error (Req 5.4).
    if (result.isEmpty()) {
      return ReadItemOutput.builder().found(false).build();
    }

    // 5. Item found: translate the decrypted SDK item back into the modeled Item (Req 5.2).
    final Map<String, AttributeValue> modelItem = AttributeValueConversions.toModelItem(result.get());
    return ReadItemOutput.builder().found(true).item(modelItem).build();
  }

  // --- error classification (Req 5.5) ---------------------------------------------------------

  /**
   * Classifies an exception thrown while reading/decrypting into the correct modeled error.
   *
   * <p>Priority is deliberate: a DB-ESDK / Material-Providers exception anywhere in the cause chain
   * is treated as a decrypt failure first, because when the DB-ESDK interceptor fails during
   * response decryption the AWS SDK may wrap the DB-ESDK exception inside an {@code SdkException}.
   * Checking the DB-ESDK signature first therefore avoids misclassifying a decrypt failure as a
   * backend failure.
   *
   * <ol>
   *   <li>DB-ESDK / MPL exception in the chain -&gt; {@link DBESDKClientError} (decrypt failure
   *       thrown by the Enhanced_Client).
   *   <li>AWS SDK {@code SdkException} in the chain (connectivity, {@code ApiCallTimeoutException},
   *       {@code ApiCallAttemptTimeoutException}, {@code DynamoDbException}, etc.) -&gt; {@link
   *       GenericServerError} (backend connectivity/timeout failure).
   *   <li>Anything else -&gt; {@link GenericServerError} as a framework/server-side catch-all.
   * </ol>
   */
  private static RuntimeException classifyOperationFailure(final RuntimeException failure) {
    if (chainContainsDbEsdkException(failure)) {
      return DBESDKClientError.builder()
          .message("The Enhanced Client failed to decrypt the item: " + describe(failure))
          .withCause(failure)
          .build();
    }
    if (chainContainsSdkException(failure)) {
      return GenericServerError.builder()
          .message(
              "The DynamoDB backend could not be reached or did not respond in time: "
                  + describe(failure))
          .withCause(failure)
          .build();
    }
    return GenericServerError.builder()
        .message("The ReadItem operation failed: " + describe(failure))
        .withCause(failure)
        .build();
  }

  private static boolean chainContainsDbEsdkException(final Throwable root) {
    for (Throwable t = root; t != null; t = nextCause(t)) {
      final String className = t.getClass().getName();
      // DB-ESDK and Material Providers native exceptions live under software.amazon.cryptography.*,
      // but the TestServer's own modeled errors share that prefix — exclude them explicitly.
      if (className.startsWith("software.amazon.cryptography.")
          && !className.startsWith("software.amazon.cryptography.dbesdk.testserver.")) {
        return true;
      }
    }
    return false;
  }

  private static boolean chainContainsSdkException(final Throwable root) {
    for (Throwable t = root; t != null; t = nextCause(t)) {
      if (t instanceof software.amazon.awssdk.core.exception.SdkException) {
        return true;
      }
    }
    return false;
  }

  /** Returns the next cause, guarding against a self-referential cause cycle. */
  private static Throwable nextCause(final Throwable t) {
    final Throwable cause = t.getCause();
    return cause == t ? null : cause;
  }

  private static String describe(final Throwable t) {
    final String message = t.getMessage();
    return (message != null && !message.isEmpty()) ? message : t.getClass().getSimpleName();
  }
}
